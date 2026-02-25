/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function2;
import scala.Serializable;
import scala.collection.GenSet;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.TreeMap;
import scala.collection.immutable.TreeSet;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t3qAB\u0004\u0011\u0002\u0007\u0005a\u0002C\u0003\u0015\u0001\u0011\u0005Q\u0003C\u0003\u001a\u0001\u0019E!\u0004C\u0003-\u0001\u0019\u0005Q\u0006C\u0003-\u0001\u0011\u0005\u0001\u0007C\u0003;\u0001\u0011\u00051H\u0001\u0007Tk\n$(/Y2uC\ndWM\u0003\u0002\t\u0013\u00059q-\u001a8fe&\u001c'B\u0001\u0006\f\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u0019\u0005)1oY1mC\u000e\u0001QcA\b';M\u0011\u0001\u0001\u0005\t\u0003#Ii\u0011aC\u0005\u0003'-\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001\u0017!\t\tr#\u0003\u0002\u0019\u0017\t!QK\\5u\u0003\u0011\u0011X\r\u001d:\u0016\u0003m\u0001\"\u0001H\u000f\r\u0001\u00111a\u0004\u0001CC\u0002}\u0011AAU3qeF\u0011\u0001e\t\t\u0003#\u0005J!AI\u0006\u0003\u000f9{G\u000f[5oOB!A\u0005A\u0013\u001c\u001b\u00059\u0001C\u0001\u000f'\t\u00159\u0003A1\u0001)\u0005\u0005\t\u0015C\u0001\u0011*!\t\t\"&\u0003\u0002,\u0017\t\u0019\u0011I\\=\u0002\r\u0011j\u0017N\\;t)\tYb\u0006C\u00030\u0007\u0001\u0007Q%\u0001\u0003fY\u0016lG\u0003B\u000e2gUBQA\r\u0003A\u0002\u0015\nQ!\u001a7f[FBQ\u0001\u000e\u0003A\u0002\u0015\nQ!\u001a7f[JBQA\u000e\u0003A\u0002]\nQ!\u001a7f[N\u00042!\u0005\u001d&\u0013\tI4B\u0001\u0006=e\u0016\u0004X-\u0019;fIz\nA\u0002J7j]V\u001cH%\\5okN$\"a\u0007\u001f\t\u000bu*\u0001\u0019\u0001 \u0002\u0005a\u001c\bcA AK5\t\u0011\"\u0003\u0002B\u0013\t\u0011r)\u001a8Ue\u00064XM]:bE2,wJ\\2f\u0001")
public interface Subtractable<A, Repr extends Subtractable<A, Repr>> {
    public Repr repr();

    public Repr $minus(A var1);

    public static /* synthetic */ Subtractable $minus$(Subtractable $this, Object elem1, Object elem2, Seq elems) {
        return $this.$minus(elem1, elem2, elems);
    }

    default public Repr $minus(A elem1, A elem2, Seq<A> elems) {
        return this.$minus(elem1).$minus(elem2).$minus$minus(elems);
    }

    public static /* synthetic */ Subtractable $minus$minus$(Subtractable $this, GenTraversableOnce xs) {
        return $this.$minus$minus(xs);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    default public Repr $minus$minus(GenTraversableOnce<A> xs) {
        void var2_7;
        if (this instanceof HashSet) {
            HashSet hashSet = (HashSet)this;
            if (xs instanceof HashSet) {
                Object object = hashSet.diff((GenSet)((HashSet)xs));
                return var2_7;
            }
        }
        if (this instanceof TreeMap) {
            TreeMap treeMap = (TreeMap)this;
            if (xs instanceof TreeSet) {
                Ordering ordering = treeMap.ordering();
                Ordering ordering2 = ((TreeSet)xs).ordering();
                if (!(ordering != null ? !ordering.equals(ordering2) : ordering2 != null)) {
                    TreeMap treeMap2 = treeMap.removeAllImpl((TreeSet)xs);
                    return var2_7;
                }
            }
        }
        if (this instanceof TreeSet) {
            TreeSet treeSet = (TreeSet)this;
            if (xs instanceof TreeSet) {
                Ordering ordering = treeSet.ordering();
                Ordering ordering3 = ((TreeSet)xs).ordering();
                if (!(ordering != null ? !ordering.equals(ordering3) : ordering3 != null)) {
                    TreeSet treeSet2 = treeSet.removeAll((TreeSet)xs);
                    return var2_7;
                }
            }
        }
        Repr Repr = this.repr();
        Subtractable subtractable = (Subtractable)xs.seq().$div$colon(Repr, (Function2<Subtractable, Object, Subtractable> & java.io.Serializable & Serializable)(x$2, x$3) -> x$2.$minus(x$3));
        return var2_7;
    }

    public static void $init$(Subtractable $this) {
    }
}

