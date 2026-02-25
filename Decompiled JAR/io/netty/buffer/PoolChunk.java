/*
 * Decompiled with CFR 0.152.
 */
package io.netty.buffer;

import io.netty.buffer.LongLongHashMap;
import io.netty.buffer.LongPriorityQueue;
import io.netty.buffer.PoolArena;
import io.netty.buffer.PoolChunkList;
import io.netty.buffer.PoolChunkMetric;
import io.netty.buffer.PoolSubpage;
import io.netty.buffer.PoolThreadCache;
import io.netty.buffer.PooledByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

final class PoolChunk<T>
implements PoolChunkMetric {
    private static final int SIZE_BIT_LENGTH = 15;
    private static final int INUSED_BIT_LENGTH = 1;
    private static final int SUBPAGE_BIT_LENGTH = 1;
    private static final int BITMAP_IDX_BIT_LENGTH = 32;
    static final int IS_SUBPAGE_SHIFT = 32;
    static final int IS_USED_SHIFT = 33;
    static final int SIZE_SHIFT = 34;
    static final int RUN_OFFSET_SHIFT = 49;
    final PoolArena<T> arena;
    final Object base;
    final T memory;
    final boolean unpooled;
    private final LongLongHashMap runsAvailMap;
    private final LongPriorityQueue[] runsAvail;
    private final ReentrantLock runsAvailLock;
    private final PoolSubpage<T>[] subpages;
    private final LongCounter pinnedBytes = PlatformDependent.newLongCounter();
    private final int pageSize;
    private final int pageShifts;
    private final int chunkSize;
    private final Deque<ByteBuffer> cachedNioBuffers;
    int freeBytes;
    PoolChunkList<T> parent;
    PoolChunk<T> prev;
    PoolChunk<T> next;

    PoolChunk(PoolArena<T> arena, Object base, T memory, int pageSize, int pageShifts, int chunkSize, int maxPageIdx) {
        this.unpooled = false;
        this.arena = arena;
        this.base = base;
        this.memory = memory;
        this.pageSize = pageSize;
        this.pageShifts = pageShifts;
        this.chunkSize = chunkSize;
        this.freeBytes = chunkSize;
        this.runsAvail = PoolChunk.newRunsAvailqueueArray(maxPageIdx);
        this.runsAvailLock = new ReentrantLock();
        this.runsAvailMap = new LongLongHashMap(-1L);
        this.subpages = new PoolSubpage[chunkSize >> pageShifts];
        int pages = chunkSize >> pageShifts;
        long initHandle = (long)pages << 34;
        this.insertAvailRun(0, pages, initHandle);
        this.cachedNioBuffers = new ArrayDeque<ByteBuffer>(8);
    }

    PoolChunk(PoolArena<T> arena, Object base, T memory, int size) {
        this.unpooled = true;
        this.arena = arena;
        this.base = base;
        this.memory = memory;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.runsAvailMap = null;
        this.runsAvail = null;
        this.runsAvailLock = null;
        this.subpages = null;
        this.chunkSize = size;
        this.cachedNioBuffers = null;
    }

    private static LongPriorityQueue[] newRunsAvailqueueArray(int size) {
        LongPriorityQueue[] queueArray = new LongPriorityQueue[size];
        for (int i = 0; i < queueArray.length; ++i) {
            queueArray[i] = new LongPriorityQueue();
        }
        return queueArray;
    }

    private void insertAvailRun(int runOffset, int pages, long handle) {
        int pageIdxFloor = this.arena.pages2pageIdxFloor(pages);
        LongPriorityQueue queue = this.runsAvail[pageIdxFloor];
        queue.offer(handle);
        this.insertAvailRun0(runOffset, handle);
        if (pages > 1) {
            this.insertAvailRun0(PoolChunk.lastPage(runOffset, pages), handle);
        }
    }

    private void insertAvailRun0(int runOffset, long handle) {
        long pre = this.runsAvailMap.put(runOffset, handle);
        assert (pre == -1L);
    }

    private void removeAvailRun(long handle) {
        int pageIdxFloor = this.arena.pages2pageIdxFloor(PoolChunk.runPages(handle));
        LongPriorityQueue queue = this.runsAvail[pageIdxFloor];
        this.removeAvailRun(queue, handle);
    }

    private void removeAvailRun(LongPriorityQueue queue, long handle) {
        queue.remove(handle);
        int runOffset = PoolChunk.runOffset(handle);
        int pages = PoolChunk.runPages(handle);
        this.runsAvailMap.remove(runOffset);
        if (pages > 1) {
            this.runsAvailMap.remove(PoolChunk.lastPage(runOffset, pages));
        }
    }

    private static int lastPage(int runOffset, int pages) {
        return runOffset + pages - 1;
    }

    private long getAvailRunByOffset(int runOffset) {
        return this.runsAvailMap.get(runOffset);
    }

    @Override
    public int usage() {
        int freeBytes;
        this.arena.lock();
        try {
            freeBytes = this.freeBytes;
        }
        finally {
            this.arena.unlock();
        }
        return this.usage(freeBytes);
    }

    private int usage(int freeBytes) {
        if (freeBytes == 0) {
            return 100;
        }
        int freePercentage = (int)((long)freeBytes * 100L / (long)this.chunkSize);
        if (freePercentage == 0) {
            return 99;
        }
        return 100 - freePercentage;
    }

    boolean allocate(PooledByteBuf<T> buf, int reqCapacity, int sizeIdx, PoolThreadCache cache) {
        long handle;
        if (sizeIdx <= this.arena.smallMaxSizeIdx) {
            handle = this.allocateSubpage(sizeIdx);
            if (handle < 0L) {
                return false;
            }
            assert (PoolChunk.isSubpage(handle));
        } else {
            int runSize = this.arena.sizeIdx2size(sizeIdx);
            handle = this.allocateRun(runSize);
            if (handle < 0L) {
                return false;
            }
            assert (!PoolChunk.isSubpage(handle));
        }
        ByteBuffer nioBuffer = this.cachedNioBuffers != null ? this.cachedNioBuffers.pollLast() : null;
        this.initBuf(buf, nioBuffer, handle, reqCapacity, cache);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private long allocateRun(int runSize) {
        int pages = runSize >> this.pageShifts;
        int pageIdx = this.arena.pages2pageIdx(pages);
        this.runsAvailLock.lock();
        try {
            int queueIdx = this.runFirstBestFit(pageIdx);
            if (queueIdx == -1) {
                long l = -1L;
                return l;
            }
            LongPriorityQueue queue = this.runsAvail[queueIdx];
            long handle = queue.poll();
            assert (handle != -1L && !PoolChunk.isUsed(handle)) : "invalid handle: " + handle;
            this.removeAvailRun(queue, handle);
            if (handle != -1L) {
                handle = this.splitLargeRun(handle, pages);
            }
            int pinnedSize = PoolChunk.runSize(this.pageShifts, handle);
            this.freeBytes -= pinnedSize;
            long l = handle;
            return l;
        }
        finally {
            this.runsAvailLock.unlock();
        }
    }

    private int calculateRunSize(int sizeIdx) {
        int nElements;
        int maxElements = 1 << this.pageShifts - 4;
        int runSize = 0;
        int elemSize = this.arena.sizeIdx2size(sizeIdx);
        while ((nElements = (runSize += this.pageSize) / elemSize) < maxElements && runSize != nElements * elemSize) {
        }
        while (nElements > maxElements) {
            nElements = (runSize -= this.pageSize) / elemSize;
        }
        assert (nElements > 0);
        assert (runSize <= this.chunkSize);
        assert (runSize >= elemSize);
        return runSize;
    }

    private int runFirstBestFit(int pageIdx) {
        if (this.freeBytes == this.chunkSize) {
            return this.arena.nPSizes - 1;
        }
        for (int i = pageIdx; i < this.arena.nPSizes; ++i) {
            LongPriorityQueue queue = this.runsAvail[i];
            if (queue == null || queue.isEmpty()) continue;
            return i;
        }
        return -1;
    }

    private long splitLargeRun(long handle, int needPages) {
        assert (needPages > 0);
        int totalPages = PoolChunk.runPages(handle);
        assert (needPages <= totalPages);
        int remPages = totalPages - needPages;
        if (remPages > 0) {
            int runOffset = PoolChunk.runOffset(handle);
            int availOffset = runOffset + needPages;
            long availRun = PoolChunk.toRunHandle(availOffset, remPages, 0);
            this.insertAvailRun(availOffset, remPages, availRun);
            return PoolChunk.toRunHandle(runOffset, needPages, 1);
        }
        return handle |= 0x200000000L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private long allocateSubpage(int sizeIdx) {
        PoolSubpage<T> head = this.arena.findSubpagePoolHead(sizeIdx);
        head.lock();
        try {
            int runSize = this.calculateRunSize(sizeIdx);
            long runHandle = this.allocateRun(runSize);
            if (runHandle < 0L) {
                long l = -1L;
                return l;
            }
            int runOffset = PoolChunk.runOffset(runHandle);
            assert (this.subpages[runOffset] == null);
            int elemSize = this.arena.sizeIdx2size(sizeIdx);
            PoolSubpage<T> subpage = new PoolSubpage<T>(head, this, this.pageShifts, runOffset, PoolChunk.runSize(this.pageShifts, runHandle), elemSize);
            this.subpages[runOffset] = subpage;
            long l = subpage.allocate();
            return l;
        }
        finally {
            head.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void free(long handle, int normCapacity, ByteBuffer nioBuffer) {
        int runSize = PoolChunk.runSize(this.pageShifts, handle);
        if (PoolChunk.isSubpage(handle)) {
            int sizeIdx = this.arena.size2SizeIdx(normCapacity);
            PoolSubpage<T> head = this.arena.findSubpagePoolHead(sizeIdx);
            int sIdx = PoolChunk.runOffset(handle);
            PoolSubpage<T> subpage = this.subpages[sIdx];
            head.lock();
            try {
                assert (subpage != null && subpage.doNotDestroy);
                if (subpage.free(head, PoolChunk.bitmapIdx(handle))) {
                    return;
                }
                assert (!subpage.doNotDestroy);
                this.subpages[sIdx] = null;
            }
            finally {
                head.unlock();
            }
        }
        this.runsAvailLock.lock();
        try {
            long finalRun = this.collapseRuns(handle);
            finalRun &= 0xFFFFFFFDFFFFFFFFL;
            this.insertAvailRun(PoolChunk.runOffset(finalRun &= 0xFFFFFFFEFFFFFFFFL), PoolChunk.runPages(finalRun), finalRun);
            this.freeBytes += runSize;
        }
        finally {
            this.runsAvailLock.unlock();
        }
        if (nioBuffer != null && this.cachedNioBuffers != null && this.cachedNioBuffers.size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
            this.cachedNioBuffers.offer(nioBuffer);
        }
    }

    private long collapseRuns(long handle) {
        return this.collapseNext(this.collapsePast(handle));
    }

    private long collapsePast(long handle) {
        while (true) {
            int runOffset = PoolChunk.runOffset(handle);
            int runPages = PoolChunk.runPages(handle);
            long pastRun = this.getAvailRunByOffset(runOffset - 1);
            if (pastRun == -1L) {
                return handle;
            }
            int pastOffset = PoolChunk.runOffset(pastRun);
            int pastPages = PoolChunk.runPages(pastRun);
            if (pastRun == handle || pastOffset + pastPages != runOffset) break;
            this.removeAvailRun(pastRun);
            handle = PoolChunk.toRunHandle(pastOffset, pastPages + runPages, 0);
        }
        return handle;
    }

    private long collapseNext(long handle) {
        while (true) {
            int runPages;
            int runOffset;
            long nextRun;
            if ((nextRun = this.getAvailRunByOffset((runOffset = PoolChunk.runOffset(handle)) + (runPages = PoolChunk.runPages(handle)))) == -1L) {
                return handle;
            }
            int nextOffset = PoolChunk.runOffset(nextRun);
            int nextPages = PoolChunk.runPages(nextRun);
            if (nextRun == handle || runOffset + runPages != nextOffset) break;
            this.removeAvailRun(nextRun);
            handle = PoolChunk.toRunHandle(runOffset, runPages + nextPages, 0);
        }
        return handle;
    }

    private static long toRunHandle(int runOffset, int runPages, int inUsed) {
        return (long)runOffset << 49 | (long)runPages << 34 | (long)inUsed << 33;
    }

    void initBuf(PooledByteBuf<T> buf, ByteBuffer nioBuffer, long handle, int reqCapacity, PoolThreadCache threadCache) {
        if (PoolChunk.isSubpage(handle)) {
            this.initBufWithSubpage(buf, nioBuffer, handle, reqCapacity, threadCache);
        } else {
            int maxLength = PoolChunk.runSize(this.pageShifts, handle);
            buf.init(this, nioBuffer, handle, PoolChunk.runOffset(handle) << this.pageShifts, reqCapacity, maxLength, this.arena.parent.threadCache());
        }
    }

    void initBufWithSubpage(PooledByteBuf<T> buf, ByteBuffer nioBuffer, long handle, int reqCapacity, PoolThreadCache threadCache) {
        int runOffset = PoolChunk.runOffset(handle);
        int bitmapIdx = PoolChunk.bitmapIdx(handle);
        PoolSubpage<T> s = this.subpages[runOffset];
        assert (s.doNotDestroy);
        assert (reqCapacity <= s.elemSize) : reqCapacity + "<=" + s.elemSize;
        int offset = (runOffset << this.pageShifts) + bitmapIdx * s.elemSize;
        buf.init(this, nioBuffer, handle, offset, reqCapacity, s.elemSize, threadCache);
    }

    void incrementPinnedMemory(int delta) {
        assert (delta > 0);
        this.pinnedBytes.add(delta);
    }

    void decrementPinnedMemory(int delta) {
        assert (delta > 0);
        this.pinnedBytes.add(-delta);
    }

    @Override
    public int chunkSize() {
        return this.chunkSize;
    }

    @Override
    public int freeBytes() {
        this.arena.lock();
        try {
            int n = this.freeBytes;
            return n;
        }
        finally {
            this.arena.unlock();
        }
    }

    public int pinnedBytes() {
        return (int)this.pinnedBytes.value();
    }

    public String toString() {
        int freeBytes;
        this.arena.lock();
        try {
            freeBytes = this.freeBytes;
        }
        finally {
            this.arena.unlock();
        }
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + this.usage(freeBytes) + "%, " + (this.chunkSize - freeBytes) + '/' + this.chunkSize + ')';
    }

    void destroy() {
        this.arena.destroyChunk(this);
    }

    static int runOffset(long handle) {
        return (int)(handle >> 49);
    }

    static int runSize(int pageShifts, long handle) {
        return PoolChunk.runPages(handle) << pageShifts;
    }

    static int runPages(long handle) {
        return (int)(handle >> 34 & 0x7FFFL);
    }

    static boolean isUsed(long handle) {
        return (handle >> 33 & 1L) == 1L;
    }

    static boolean isRun(long handle) {
        return !PoolChunk.isSubpage(handle);
    }

    static boolean isSubpage(long handle) {
        return (handle >> 32 & 1L) == 1L;
    }

    static int bitmapIdx(long handle) {
        return (int)handle;
    }
}

