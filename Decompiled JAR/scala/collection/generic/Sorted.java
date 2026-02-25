/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.None$;
import scala.Option;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.SortedSet;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001I4qa\u0004\t\u0011\u0002\u0007\u0005q\u0003C\u0003\u001e\u0001\u0011\u0005a\u0004C\u0003#\u0001\u0019\u00051\u0005C\u00037\u0001\u0019Eq\u0007C\u0003?\u0001\u0019\u0005q\bC\u0003E\u0001\u0019\u0005Q\tC\u0003G\u0001\u0019\u0005Q\tC\u0003H\u0001\u0011\u0005\u0001\nC\u0003Q\u0001\u0019\u0005\u0011\u000bC\u0003T\u0001\u0011\u0005\u0011\fC\u0003Y\u0001\u0011\u00051\fC\u0003^\u0001\u0011\u0005a\fC\u0003b\u0001\u0011\u0005!\rC\u0003e\u0001\u0019\u0005Q\rC\u0003l\u0001\u0011EAN\u0001\u0004T_J$X\r\u001a\u0006\u0003#I\tqaZ3oKJL7M\u0003\u0002\u0014)\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003U\tQa]2bY\u0006\u001c\u0001!F\u0002\u0019[e\u001a\"\u0001A\r\u0011\u0005iYR\"\u0001\u000b\n\u0005q!\"AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0002?A\u0011!\u0004I\u0005\u0003CQ\u0011A!\u00168ji\u0006AqN\u001d3fe&tw-F\u0001%!\r)\u0003f\u000b\b\u00035\u0019J!a\n\u000b\u0002\u000fA\f7m[1hK&\u0011\u0011F\u000b\u0002\t\u001fJ$WM]5oO*\u0011q\u0005\u0006\t\u0003Y5b\u0001\u0001B\u0003/\u0001\t\u0007qFA\u0001L#\t\u00014\u0007\u0005\u0002\u001bc%\u0011!\u0007\u0006\u0002\b\u001d>$\b.\u001b8h!\tQB'\u0003\u00026)\t\u0019\u0011I\\=\u0002\tI,\u0007O]\u000b\u0002qA\u0011A&\u000f\u0003\u0007u\u0001!)\u0019A\u001e\u0003\tQC\u0017n]\t\u0003aq\u0002B!\u0010\u0001,q5\t\u0001#\u0001\u0004lKf\u001cV\r^\u000b\u0002\u0001B\u0019\u0011IQ\u0016\u000e\u0003II!a\u0011\n\u0003\u0013M{'\u000f^3e'\u0016$\u0018\u0001\u00034jeN$8*Z=\u0016\u0003-\nq\u0001\\1ti.+\u00170A\u0004d_6\u0004\u0018M]3\u0015\u0007%ce\n\u0005\u0002\u001b\u0015&\u00111\n\u0006\u0002\u0004\u0013:$\b\"B'\b\u0001\u0004Y\u0013AA61\u0011\u0015yu\u00011\u0001,\u0003\tY\u0017'A\u0005sC:<W-S7qYR\u0019\u0001HU,\t\u000bMC\u0001\u0019\u0001+\u0002\t\u0019\u0014x.\u001c\t\u00045U[\u0013B\u0001,\u0015\u0005\u0019y\u0005\u000f^5p]\")\u0001\f\u0003a\u0001)\u0006)QO\u001c;jYR\u0011\u0001H\u0017\u0005\u0006'&\u0001\ra\u000b\u000b\u0003qqCQ\u0001\u0017\u0006A\u0002-\nQA]1oO\u0016$2\u0001O0a\u0011\u0015\u00196\u00021\u0001,\u0011\u0015A6\u00021\u0001,\u0003\t!x\u000e\u0006\u00029G\")\u0011\r\u0004a\u0001W\u0005\u00012.Z=t\u0013R,'/\u0019;pe\u001a\u0013x.\u001c\u000b\u0003M&\u00042!Q4,\u0013\tA'C\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0011\u0015QW\u00021\u0001,\u0003\u0015\u0019H/\u0019:u\u0003\u0019A\u0017m]!mYR\u0011Q\u000e\u001d\t\u000359L!a\u001c\u000b\u0003\u000f\t{w\u000e\\3b]\")\u0011O\u0004a\u0001M\u0006\t!\u000e")
public interface Sorted<K, This extends Sorted<K, This>> {
    public Ordering<K> ordering();

    public This repr();

    public SortedSet<K> keySet();

    public K firstKey();

    public K lastKey();

    public static /* synthetic */ int compare$(Sorted $this, Object k0, Object k1) {
        return $this.compare(k0, k1);
    }

    default public int compare(K k0, K k1) {
        return this.ordering().compare(k0, k1);
    }

    public This rangeImpl(Option<K> var1, Option<K> var2);

    public static /* synthetic */ Sorted from$(Sorted $this, Object from) {
        return $this.from(from);
    }

    default public This from(K from) {
        return this.rangeImpl(new Some<K>(from), None$.MODULE$);
    }

    public static /* synthetic */ Sorted until$(Sorted $this, Object until) {
        return $this.until(until);
    }

    default public This until(K until) {
        return this.rangeImpl(None$.MODULE$, new Some<K>(until));
    }

    public static /* synthetic */ Sorted range$(Sorted $this, Object from, Object until) {
        return $this.range(from, until);
    }

    default public This range(K from, K until) {
        return this.rangeImpl(new Some<K>(from), new Some<K>(until));
    }

    public static /* synthetic */ Sorted to$(Sorted $this, Object to) {
        return $this.to(to);
    }

    default public This to(K to) {
        Iterator i = this.keySet().from(to).iterator();
        if (i.isEmpty()) {
            return this.repr();
        }
        Object next = i.next();
        if (this.compare(next, to) == 0) {
            if (i.isEmpty()) {
                return this.repr();
            }
            return this.until(i.next());
        }
        return this.until(next);
    }

    public Iterator<K> keysIteratorFrom(K var1);

    public static /* synthetic */ boolean hasAll$(Sorted $this, Iterator j) {
        return $this.hasAll(j);
    }

    default public boolean hasAll(Iterator<K> j) {
        Iterator i = this.keySet().iterator();
        if (i.isEmpty()) {
            return j.isEmpty();
        }
        Object in = i.next();
        block0: while (j.hasNext()) {
            K jn = j.next();
            while (true) {
                boolean bl;
                int n;
                if ((n = this.compare(jn, in)) == 0) {
                    bl = false;
                } else {
                    if (n < 0) {
                        return false;
                    }
                    if (!i.hasNext()) {
                        return false;
                    }
                    bl = true;
                }
                if (!bl) continue block0;
                in = i.next();
            }
        }
        return true;
    }

    public static void $init$(Sorted $this) {
    }
}

