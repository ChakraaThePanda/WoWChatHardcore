/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001i2q!\u0002\u0004\u0011\u0002\u0007\u0005Q\u0002C\u0003\u0014\u0001\u0011\u0005A\u0003C\u0003\u0019\u0001\u0019\u0005\u0011\u0004C\u0003\u0019\u0001\u0011\u0005\u0001\u0006C\u00033\u0001\u0011\u00051G\u0001\u0006TQJLgn[1cY\u0016T!a\u0002\u0005\u0002\u000f\u001d,g.\u001a:jG*\u0011\u0011BC\u0001\u000bG>dG.Z2uS>t'\"A\u0006\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011abH\n\u0003\u0001=\u0001\"\u0001E\t\u000e\u0003)I!A\u0005\u0006\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\tQ\u0003\u0005\u0002\u0011-%\u0011qC\u0003\u0002\u0005+:LG/A\u0005%[&tWo\u001d\u0013fcR\u0011!dG\u0007\u0002\u0001!)AD\u0001a\u0001;\u0005!Q\r\\3n!\tqr\u0004\u0004\u0001\u0005\r\u0001\u0002\u0001R1\u0001\"\u0005\u0005\t\u0015C\u0001\u0012&!\t\u00012%\u0003\u0002%\u0015\t9aj\u001c;iS:<\u0007C\u0001\t'\u0013\t9#BA\u0002B]f$BAG\u0015,[!)!f\u0001a\u0001;\u0005)Q\r\\3nc!)Af\u0001a\u0001;\u0005)Q\r\\3ne!)af\u0001a\u0001_\u0005)Q\r\\3ngB\u0019\u0001\u0003M\u000f\n\u0005ER!A\u0003\u001fsKB,\u0017\r^3e}\u0005yA%\\5okN$S.\u001b8vg\u0012*\u0017\u000f\u0006\u0002\u001bi!)Q\u0007\u0002a\u0001m\u0005\u0011\u0001p\u001d\t\u0004oajR\"\u0001\u0005\n\u0005eB!a\u0004+sCZ,'o]1cY\u0016|enY3")
public interface Shrinkable<A> {
    public Shrinkable<A> $minus$eq(A var1);

    public static /* synthetic */ Shrinkable $minus$eq$(Shrinkable $this, Object elem1, Object elem2, Seq elems) {
        return $this.$minus$eq(elem1, elem2, elems);
    }

    default public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
        this.$minus$eq(elem1);
        this.$minus$eq(elem2);
        return this.$minus$minus$eq(elems);
    }

    public static /* synthetic */ Shrinkable $minus$minus$eq$(Shrinkable $this, TraversableOnce xs) {
        return $this.$minus$minus$eq(xs);
    }

    default public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
        xs.foreach((Function1<Object, Shrinkable> & java.io.Serializable & Serializable)elem -> this.$minus$eq(elem));
        return this;
    }

    public static void $init$(Shrinkable $this) {
    }
}

