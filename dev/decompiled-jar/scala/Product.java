/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Equals;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001M2qAB\u0004\u0011\u0002\u0007\u0005!\u0002C\u0003\u0013\u0001\u0011\u00051\u0003C\u0003\u0018\u0001\u0019\u0005\u0001\u0004C\u0003\u001f\u0001\u0019\u0005q\u0004C\u0003!\u0001\u0011\u0005\u0011\u0005C\u0003*\u0001\u0011\u0005!FA\u0004Qe>$Wo\u0019;\u000b\u0003!\tQa]2bY\u0006\u001c\u0001aE\u0002\u0001\u0017=\u0001\"\u0001D\u0007\u000e\u0003\u001dI!AD\u0004\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\r!%\u0011\u0011c\u0002\u0002\u0007\u000bF,\u0018\r\\:\u0002\r\u0011Jg.\u001b;%)\u0005!\u0002C\u0001\u0007\u0016\u0013\t1rA\u0001\u0003V]&$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u0003\u0017eAQA\u0007\u0002A\u0002m\t\u0011A\u001c\t\u0003\u0019qI!!H\u0004\u0003\u0007%sG/\u0001\u0007qe>$Wo\u0019;Be&$\u00180F\u0001\u001c\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#\u0001\u0012\u0011\u0007\r23B\u0004\u0002\rI%\u0011QeB\u0001\ba\u0006\u001c7.Y4f\u0013\t9\u0003F\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0015\t)s!A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0002WA\u0011A&M\u0007\u0002[)\u0011afL\u0001\u0005Y\u0006twMC\u00011\u0003\u0011Q\u0017M^1\n\u0005Ij#AB*ue&tw\r")
public interface Product
extends Equals {
    public Object productElement(int var1);

    public int productArity();

    public static /* synthetic */ Iterator productIterator$(Product $this) {
        return $this.productIterator();
    }

    default public Iterator<Object> productIterator() {
        return new AbstractIterator<Object>(this){
            private int c;
            private final int cmax;
            private final /* synthetic */ Product $outer;

            private int c() {
                return this.c;
            }

            private void c_$eq(int x$1) {
                this.c = x$1;
            }

            private int cmax() {
                return this.cmax;
            }

            public boolean hasNext() {
                return this.c() < this.cmax();
            }

            /*
             * WARNING - void declaration
             */
            public Object next() {
                void var1_1;
                Object result2 = this.$outer.productElement(this.c());
                this.c_$eq(this.c() + 1);
                return var1_1;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.c = 0;
                this.cmax = $outer.productArity();
            }
        };
    }

    public static /* synthetic */ String productPrefix$(Product $this) {
        return $this.productPrefix();
    }

    default public String productPrefix() {
        return "";
    }

    public static void $init$(Product $this) {
    }
}

