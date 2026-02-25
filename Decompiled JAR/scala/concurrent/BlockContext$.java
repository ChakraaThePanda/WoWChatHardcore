/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.Function0;
import scala.concurrent.BlockContext;
import scala.concurrent.BlockContext$DefaultBlockContext$;

public final class BlockContext$ {
    public static BlockContext$ MODULE$;
    private final ThreadLocal<BlockContext> contextLocal;

    static {
        new BlockContext$();
    }

    public BlockContext defaultBlockContext() {
        return BlockContext$DefaultBlockContext$.MODULE$;
    }

    private ThreadLocal<BlockContext> contextLocal() {
        return this.contextLocal;
    }

    public BlockContext current() {
        BlockContext blockContext;
        BlockContext blockContext2 = this.contextLocal().get();
        if (blockContext2 == null) {
            Thread thread2 = Thread.currentThread();
            BlockContext blockContext3 = thread2 instanceof BlockContext ? (BlockContext)((Object)thread2) : BlockContext$DefaultBlockContext$.MODULE$;
            blockContext = blockContext3;
        } else {
            blockContext = blockContext2;
        }
        return blockContext;
    }

    public <T> T withBlockContext(BlockContext blockContext, Function0<T> body) {
        T t;
        BlockContext old = this.contextLocal().get();
        try {
            this.contextLocal().set(blockContext);
            t = body.apply();
        }
        finally {
            this.contextLocal().set(old);
        }
        return t;
    }

    private BlockContext$() {
        MODULE$ = this;
        this.contextLocal = new ThreadLocal();
    }
}

