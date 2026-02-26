/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.Option;
import scala.math.Equiv;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001=3q!\u0003\u0006\u0011\u0002\u0007\u0005q\u0002C\u0003%\u0001\u0011\u0005Q\u0005C\u0003*\u0001\u0019\u0005!\u0006C\u00036\u0001\u0019\u0005a\u0007C\u0003=\u0001\u0011\u0005Q\bC\u0003A\u0001\u0011\u0005\u0011\tC\u0003E\u0001\u0011\u0005Q\tC\u0003I\u0001\u0011\u0005\u0011\nC\u0003M\u0001\u0011\u0005QJA\bQCJ$\u0018.\u00197Pe\u0012,'/\u001b8h\u0015\tYA\"\u0001\u0003nCRD'\"A\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0001cG\n\u0004\u0001E)\u0002C\u0001\n\u0014\u001b\u0005a\u0011B\u0001\u000b\r\u0005\u0019\te.\u001f*fMB\u0019acF\r\u000e\u0003)I!\u0001\u0007\u0006\u0003\u000b\u0015\u000bX/\u001b<\u0011\u0005iYB\u0002\u0001\u0003\u00069\u0001\u0011\r!\b\u0002\u0002)F\u0011a$\t\t\u0003%}I!\u0001\t\u0007\u0003\u000f9{G\u000f[5oOB\u0011!CI\u0005\u0003G1\u00111!\u00118z\u0003\u0019!\u0013N\\5uIQ\ta\u0005\u0005\u0002\u0013O%\u0011\u0001\u0006\u0004\u0002\u0005+:LG/\u0001\u0006uef\u001cu.\u001c9be\u0016$2aK\u00194!\r\u0011BFL\u0005\u0003[1\u0011aa\u00149uS>t\u0007C\u0001\n0\u0013\t\u0001DBA\u0002J]RDQA\r\u0002A\u0002e\t\u0011\u0001\u001f\u0005\u0006i\t\u0001\r!G\u0001\u0002s\u0006!A\u000e^3r)\r9$h\u000f\t\u0003%aJ!!\u000f\u0007\u0003\u000f\t{w\u000e\\3b]\")!g\u0001a\u00013!)Ag\u0001a\u00013\u0005!q\r^3r)\r9dh\u0010\u0005\u0006e\u0011\u0001\r!\u0007\u0005\u0006i\u0011\u0001\r!G\u0001\u0003YR$2a\u000e\"D\u0011\u0015\u0011T\u00011\u0001\u001a\u0011\u0015!T\u00011\u0001\u001a\u0003\t9G\u000fF\u00028\r\u001eCQA\r\u0004A\u0002eAQ\u0001\u000e\u0004A\u0002e\tQ!Z9vSZ$2a\u000e&L\u0011\u0015\u0011t\u00011\u0001\u001a\u0011\u0015!t\u00011\u0001\u001a\u0003\u001d\u0011XM^3sg\u0016,\u0012A\u0014\t\u0004-\u0001I\u0002")
public interface PartialOrdering<T>
extends Equiv<T> {
    public Option<Object> tryCompare(T var1, T var2);

    public boolean lteq(T var1, T var2);

    public static /* synthetic */ boolean gteq$(PartialOrdering $this, Object x, Object y) {
        return $this.gteq(x, y);
    }

    default public boolean gteq(T x, T y) {
        return this.lteq(y, x);
    }

    public static /* synthetic */ boolean lt$(PartialOrdering $this, Object x, Object y) {
        return $this.lt(x, y);
    }

    default public boolean lt(T x, T y) {
        return this.lteq(x, y) && !this.equiv(x, y);
    }

    public static /* synthetic */ boolean gt$(PartialOrdering $this, Object x, Object y) {
        return $this.gt(x, y);
    }

    default public boolean gt(T x, T y) {
        return this.gteq(x, y) && !this.equiv(x, y);
    }

    public static /* synthetic */ boolean equiv$(PartialOrdering $this, Object x, Object y) {
        return $this.equiv(x, y);
    }

    @Override
    default public boolean equiv(T x, T y) {
        return this.lteq(x, y) && this.lteq(y, x);
    }

    public static /* synthetic */ PartialOrdering reverse$(PartialOrdering $this) {
        return $this.reverse();
    }

    default public PartialOrdering<T> reverse() {
        return new PartialOrdering<T>(this){
            private final /* synthetic */ PartialOrdering $outer;

            public PartialOrdering<T> reverse() {
                return this.$outer;
            }

            public Option<Object> tryCompare(T x, T y) {
                return this.$outer.tryCompare(y, x);
            }

            public boolean lteq(T x, T y) {
                return this.$outer.lteq(y, x);
            }

            public boolean gteq(T x, T y) {
                return this.$outer.gteq(y, x);
            }

            public boolean lt(T x, T y) {
                return this.$outer.lt(y, x);
            }

            public boolean gt(T x, T y) {
                return this.$outer.gt(y, x);
            }

            public boolean equiv(T x, T y) {
                return this.$outer.equiv(y, x);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                PartialOrdering.$init$(this);
            }
        };
    }

    public static void $init$(PartialOrdering $this) {
    }
}

