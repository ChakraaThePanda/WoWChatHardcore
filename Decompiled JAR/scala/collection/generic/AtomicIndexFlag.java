/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import java.util.concurrent.atomic.AtomicInteger;
import scala.collection.generic.Signalling;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001i2qa\u0002\u0005\u0011\u0002\u0007\u0005q\u0002C\u0003\u0019\u0001\u0011\u0005\u0011\u0004C\u0004\u001e\u0001\t\u0007I\u0011\u0002\u0010\t\r-\u0002\u0001\u0013\"\u0001-\u0011\u0019\u0001\u0004\u0001%C\u0001c!1A\u0007\u0001I\u0005\u0002UBaa\u000e\u0001\u0011\n\u0003A$aD!u_6L7-\u00138eKb4E.Y4\u000b\u0005%Q\u0011aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003\u00171\t!bY8mY\u0016\u001cG/[8o\u0015\u0005i\u0011!B:dC2\f7\u0001A\n\u0004\u0001A!\u0002CA\t\u0013\u001b\u0005a\u0011BA\n\r\u0005\u0019\te.\u001f*fMB\u0011QCF\u0007\u0002\u0011%\u0011q\u0003\u0003\u0002\u000b'&<g.\u00197mS:<\u0017A\u0002\u0013j]&$H\u0005F\u0001\u001b!\t\t2$\u0003\u0002\u001d\u0019\t!QK\\5u\u0003\u001dIg\u000e\u001e4mC\u001e,\u0012a\b\t\u0003A%j\u0011!\t\u0006\u0003E\r\na!\u0019;p[&\u001c'B\u0001\u0013&\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0003M\u001d\nA!\u001e;jY*\t\u0001&\u0001\u0003kCZ\f\u0017B\u0001\u0016\"\u00055\tEo\\7jG&sG/Z4fe\u0006I\u0011N\u001c3fq\u001ac\u0017mZ\u000b\u0002[A\u0011\u0011CL\u0005\u0003_1\u00111!\u00138u\u00031\u0019X\r^%oI\u0016Dh\t\\1h)\tQ\"\u0007C\u00034\t\u0001\u0007Q&A\u0001g\u0003U\u0019X\r^%oI\u0016Dh\t\\1h\u0013\u001a<%/Z1uKJ$\"A\u0007\u001c\t\u000bM*\u0001\u0019A\u0017\u0002)M,G/\u00138eKb4E.Y4JM2+7o]3s)\tQ\u0012\bC\u00034\r\u0001\u0007Q\u0006")
public interface AtomicIndexFlag
extends Signalling {
    public void scala$collection$generic$AtomicIndexFlag$_setter_$scala$collection$generic$AtomicIndexFlag$$intflag_$eq(AtomicInteger var1);

    public AtomicInteger scala$collection$generic$AtomicIndexFlag$$intflag();

    public static /* synthetic */ int indexFlag$(AtomicIndexFlag $this) {
        return $this.indexFlag();
    }

    @Override
    default public int indexFlag() {
        return this.scala$collection$generic$AtomicIndexFlag$$intflag().get();
    }

    public static /* synthetic */ void setIndexFlag$(AtomicIndexFlag $this, int f) {
        $this.setIndexFlag(f);
    }

    @Override
    default public void setIndexFlag(int f) {
        this.scala$collection$generic$AtomicIndexFlag$$intflag().set(f);
    }

    public static /* synthetic */ void setIndexFlagIfGreater$(AtomicIndexFlag $this, int f) {
        $this.setIndexFlagIfGreater(f);
    }

    @Override
    default public void setIndexFlagIfGreater(int f) {
        boolean loop = true;
        do {
            int old;
            if (f <= (old = this.scala$collection$generic$AtomicIndexFlag$$intflag().get())) {
                loop = false;
                continue;
            }
            if (!this.scala$collection$generic$AtomicIndexFlag$$intflag().compareAndSet(old, f)) continue;
            loop = false;
        } while (loop);
    }

    public static /* synthetic */ void setIndexFlagIfLesser$(AtomicIndexFlag $this, int f) {
        $this.setIndexFlagIfLesser(f);
    }

    @Override
    default public void setIndexFlagIfLesser(int f) {
        boolean loop = true;
        do {
            int old;
            if (f >= (old = this.scala$collection$generic$AtomicIndexFlag$$intflag().get())) {
                loop = false;
                continue;
            }
            if (!this.scala$collection$generic$AtomicIndexFlag$$intflag().compareAndSet(old, f)) continue;
            loop = false;
        } while (loop);
    }

    public static void $init$(AtomicIndexFlag $this) {
        $this.scala$collection$generic$AtomicIndexFlag$_setter_$scala$collection$generic$AtomicIndexFlag$$intflag_$eq(new AtomicInteger(-1));
    }
}

