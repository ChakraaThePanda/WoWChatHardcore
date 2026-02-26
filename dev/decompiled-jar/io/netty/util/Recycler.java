/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class Recycler<T> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Recycler.class);
    private static final Handle<?> NOOP_HANDLE = new Handle<Object>(){

        @Override
        public void recycle(Object object) {
        }

        public String toString() {
            return "NOOP_HANDLE";
        }
    };
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final int RATIO;
    private static final int DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD;
    private static final boolean BLOCKING_POOL;
    private final int maxCapacityPerThread;
    private final int interval;
    private final int chunkSize;
    private final FastThreadLocal<LocalPool<T>> threadLocal = new FastThreadLocal<LocalPool<T>>(){

        @Override
        protected LocalPool<T> initialValue() {
            return new LocalPool(Recycler.this.maxCapacityPerThread, Recycler.this.interval, Recycler.this.chunkSize);
        }

        @Override
        protected void onRemoval(LocalPool<T> value) throws Exception {
            super.onRemoval(value);
            MessagePassingQueue handles = value.pooledHandles;
            value.pooledHandles = null;
            handles.clear();
        }
    };

    protected Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    protected Recycler(int maxCapacityPerThread) {
        this(maxCapacityPerThread, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    protected Recycler(int maxCapacityPerThread, int maxSharedCapacityFactor) {
        this(maxCapacityPerThread, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    protected Recycler(int maxCapacityPerThread, int maxSharedCapacityFactor, int ratio, int maxDelayedQueuesPerThread) {
        this(maxCapacityPerThread, ratio, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    protected Recycler(int maxCapacityPerThread, int maxSharedCapacityFactor, int ratio, int maxDelayedQueuesPerThread, int delayedQueueRatio) {
        this(maxCapacityPerThread, ratio, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    protected Recycler(int maxCapacityPerThread, int ratio, int chunkSize) {
        this.interval = Math.max(0, ratio);
        if (maxCapacityPerThread <= 0) {
            this.maxCapacityPerThread = 0;
            this.chunkSize = 0;
        } else {
            this.maxCapacityPerThread = Math.max(4, maxCapacityPerThread);
            this.chunkSize = Math.max(2, Math.min(chunkSize, this.maxCapacityPerThread >> 1));
        }
    }

    public final T get() {
        Object obj;
        if (this.maxCapacityPerThread == 0) {
            return (T)this.newObject(NOOP_HANDLE);
        }
        LocalPool<T> localPool = this.threadLocal.get();
        DefaultHandle<T> handle = localPool.claim();
        if (handle == null) {
            handle = localPool.newHandle();
            if (handle != null) {
                obj = this.newObject(handle);
                handle.set(obj);
            } else {
                obj = this.newObject(NOOP_HANDLE);
            }
        } else {
            obj = handle.get();
        }
        return obj;
    }

    @Deprecated
    public final boolean recycle(T o, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        handle.recycle(o);
        return true;
    }

    final int threadLocalSize() {
        LocalPool<T> localPool = this.threadLocal.getIfExists();
        return localPool == null ? 0 : ((LocalPool)localPool).pooledHandles.size();
    }

    protected abstract T newObject(Handle<T> var1);

    static {
        int maxCapacityPerThread = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        if (maxCapacityPerThread < 0) {
            maxCapacityPerThread = 4096;
        }
        DEFAULT_MAX_CAPACITY_PER_THREAD = maxCapacityPerThread;
        DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD = SystemPropertyUtil.getInt("io.netty.recycler.chunkSize", 32);
        RATIO = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        BLOCKING_POOL = SystemPropertyUtil.getBoolean("io.netty.recycler.blocking", false);
        if (logger.isDebugEnabled()) {
            if (DEFAULT_MAX_CAPACITY_PER_THREAD == 0) {
                logger.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                logger.debug("-Dio.netty.recycler.ratio: disabled");
                logger.debug("-Dio.netty.recycler.chunkSize: disabled");
                logger.debug("-Dio.netty.recycler.blocking: disabled");
            } else {
                logger.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", (Object)DEFAULT_MAX_CAPACITY_PER_THREAD);
                logger.debug("-Dio.netty.recycler.ratio: {}", (Object)RATIO);
                logger.debug("-Dio.netty.recycler.chunkSize: {}", (Object)DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
                logger.debug("-Dio.netty.recycler.blocking: {}", (Object)BLOCKING_POOL);
            }
        }
    }

    private static final class BlockingMessageQueue<T>
    implements MessagePassingQueue<T> {
        private final Queue<T> deque;
        private final int maxCapacity;

        BlockingMessageQueue(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            this.deque = new ArrayDeque<T>();
        }

        @Override
        public synchronized boolean offer(T e) {
            if (this.deque.size() == this.maxCapacity) {
                return false;
            }
            return this.deque.offer(e);
        }

        @Override
        public synchronized T poll() {
            return this.deque.poll();
        }

        @Override
        public synchronized T peek() {
            return this.deque.peek();
        }

        @Override
        public synchronized int size() {
            return this.deque.size();
        }

        @Override
        public synchronized void clear() {
            this.deque.clear();
        }

        @Override
        public synchronized boolean isEmpty() {
            return this.deque.isEmpty();
        }

        @Override
        public int capacity() {
            return this.maxCapacity;
        }

        @Override
        public boolean relaxedOffer(T e) {
            return this.offer(e);
        }

        @Override
        public T relaxedPoll() {
            return this.poll();
        }

        @Override
        public T relaxedPeek() {
            return this.peek();
        }

        @Override
        public int drain(MessagePassingQueue.Consumer<T> c, int limit) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int fill(MessagePassingQueue.Supplier<T> s, int limit) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int drain(MessagePassingQueue.Consumer<T> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int fill(MessagePassingQueue.Supplier<T> s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void drain(MessagePassingQueue.Consumer<T> c, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void fill(MessagePassingQueue.Supplier<T> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class LocalPool<T> {
        private final int ratioInterval;
        private volatile MessagePassingQueue<DefaultHandle<T>> pooledHandles;
        private int ratioCounter;

        LocalPool(int maxCapacity, int ratioInterval, int chunkSize) {
            this.ratioInterval = ratioInterval;
            this.pooledHandles = BLOCKING_POOL ? new BlockingMessageQueue<DefaultHandle<T>>(maxCapacity) : (MessagePassingQueue)((Object)PlatformDependent.newMpscQueue(chunkSize, maxCapacity));
            this.ratioCounter = ratioInterval;
        }

        DefaultHandle<T> claim() {
            MessagePassingQueue<DefaultHandle<T>> handles = this.pooledHandles;
            if (handles == null) {
                return null;
            }
            DefaultHandle<T> handle = handles.relaxedPoll();
            if (null != handle) {
                handle.toClaimed();
            }
            return handle;
        }

        void release(DefaultHandle<T> handle) {
            handle.toAvailable();
            MessagePassingQueue<DefaultHandle<DefaultHandle<T>>> handles = this.pooledHandles;
            if (handles != null) {
                handles.relaxedOffer(handle);
            }
        }

        DefaultHandle<T> newHandle() {
            if (++this.ratioCounter >= this.ratioInterval) {
                this.ratioCounter = 0;
                return new DefaultHandle(this);
            }
            return null;
        }
    }

    private static final class DefaultHandle<T>
    implements Handle<T> {
        private static final int STATE_CLAIMED = 0;
        private static final int STATE_AVAILABLE = 1;
        private static final AtomicIntegerFieldUpdater<DefaultHandle<?>> STATE_UPDATER;
        private volatile int state;
        private final LocalPool<T> localPool;
        private T value;

        DefaultHandle(LocalPool<T> localPool) {
            this.localPool = localPool;
        }

        @Override
        public void recycle(Object object) {
            if (object != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.localPool.release(this);
        }

        T get() {
            return this.value;
        }

        void set(T value) {
            this.value = value;
        }

        void toClaimed() {
            assert (this.state == 1);
            this.state = 0;
        }

        void toAvailable() {
            int prev = STATE_UPDATER.getAndSet(this, 1);
            if (prev == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
        }

        static {
            AtomicIntegerFieldUpdater<DefaultHandle> updater = AtomicIntegerFieldUpdater.newUpdater(DefaultHandle.class, "state");
            STATE_UPDATER = updater;
        }
    }

    public static interface Handle<T>
    extends ObjectPool.Handle<T> {
    }
}

