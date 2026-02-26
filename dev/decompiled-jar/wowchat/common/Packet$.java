/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.EmptyByteBuf;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.runtime.AbstractFunction2;
import scala.runtime.BoxesRunTime;
import wowchat.common.Packet;

public final class Packet$
extends AbstractFunction2<Object, ByteBuf, Packet>
implements Serializable {
    public static Packet$ MODULE$;

    static {
        new Packet$();
    }

    public ByteBuf $lessinit$greater$default$2() {
        return new EmptyByteBuf(ByteBufAllocator.DEFAULT);
    }

    @Override
    public final String toString() {
        return "Packet";
    }

    @Override
    public Packet apply(int id, ByteBuf byteBuf) {
        return new Packet(id, byteBuf);
    }

    public ByteBuf apply$default$2() {
        return new EmptyByteBuf(ByteBufAllocator.DEFAULT);
    }

    public Option<Tuple2<Object, ByteBuf>> unapply(Packet x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple2<Integer, ByteBuf>>(new Tuple2<Integer, ByteBuf>(BoxesRunTime.boxToInteger(x$0.id()), x$0.byteBuf()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Packet$() {
        MODULE$ = this;
    }
}

