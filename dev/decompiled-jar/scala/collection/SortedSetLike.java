/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.None$;
import scala.Option;
import scala.Some;
import scala.collection.GenSet;
import scala.collection.Iterator;
import scala.collection.SetLike;
import scala.collection.SortedSet;
import scala.collection.generic.Sorted;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001Q4q!\u0004\b\u0011\u0002\u0007\u00051\u0003C\u0003:\u0001\u0011\u0005!\bC\u0003?\u0001\u0019\rq\bC\u0003H\u0001\u0011\u0005\u0003\nC\u0003J\u0001\u0011\u0005#\nC\u0003L\u0001\u0011\u0005#\nC\u0003M\u0001\u0019\u0005Q\nC\u0003P\u0001\u0011\u0005S\u000bC\u0003U\u0001\u0011\u0005s\u000bC\u0003Z\u0001\u0011\u0005#\fC\u0003^\u0001\u0011\u0005c\fC\u0003h\u0001\u0011\u0005\u0001\u000eC\u0006o\u0001A\u0005\u0019\u0011!A\u0005\n=\f(!D*peR,GmU3u\u0019&\\WM\u0003\u0002\u0010!\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003E\tQa]2bY\u0006\u001c\u0001!F\u0002\u0015C-\u001aB\u0001A\u000b\u001amA\u0011acF\u0007\u0002!%\u0011\u0001\u0004\u0005\u0002\u0007\u0003:L(+\u001a4\u0011\tiirDK\u0007\u00027)\u0011ADD\u0001\bO\u0016tWM]5d\u0013\tq2D\u0001\u0004T_J$X\r\u001a\t\u0003A\u0005b\u0001\u0001B\u0003#\u0001\t\u00071EA\u0001B#\t!s\u0005\u0005\u0002\u0017K%\u0011a\u0005\u0005\u0002\b\u001d>$\b.\u001b8h!\t1\u0002&\u0003\u0002*!\t\u0019\u0011I\\=\u0011\u0005\u0001ZCA\u0002\u0017\u0001\t\u000b\u0007QF\u0001\u0003UQ&\u001c\u0018C\u0001\u0013/%\ry\u0013'\u000e\u0004\u0005a\u0001\u0001aF\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u00023g}i\u0011AD\u0005\u0003i9\u0011\u0011bU8si\u0016$7+\u001a;\u0011\tI\u0002qD\u000b\t\u0005e]z\"&\u0003\u00029\u001d\t91+\u001a;MS.,\u0017A\u0002\u0013j]&$H\u0005F\u0001<!\t1B(\u0003\u0002>!\t!QK\\5u\u0003!y'\u000fZ3sS:<W#\u0001!\u0011\u0007\u0005#uD\u0004\u0002\u0017\u0005&\u00111\tE\u0001\ba\u0006\u001c7.Y4f\u0013\t)eI\u0001\u0005Pe\u0012,'/\u001b8h\u0015\t\u0019\u0005#\u0001\u0004lKf\u001cV\r^\u000b\u0002U\u0005Aa-\u001b:ti.+\u00170F\u0001 \u0003\u001da\u0017m\u001d;LKf\f\u0011B]1oO\u0016LU\u000e\u001d7\u0015\u0007)r5\u000bC\u0003P\r\u0001\u0007\u0001+\u0001\u0003ge>l\u0007c\u0001\fR?%\u0011!\u000b\u0005\u0002\u0007\u001fB$\u0018n\u001c8\t\u000bQ3\u0001\u0019\u0001)\u0002\u000bUtG/\u001b7\u0015\u0005)2\u0006\"B(\b\u0001\u0004yBC\u0001\u0016Y\u0011\u0015!\u0006\u00021\u0001 \u0003\u0015\u0011\u0018M\\4f)\rQ3\f\u0018\u0005\u0006\u001f&\u0001\ra\b\u0005\u0006)&\u0001\raH\u0001\tgV\u00147/\u001a;PMR\u0011qL\u0019\t\u0003-\u0001L!!\u0019\t\u0003\u000f\t{w\u000e\\3b]\")1M\u0003a\u0001I\u0006!A\u000f[1u!\r\u0011TmH\u0005\u0003M:\u0011aaR3o'\u0016$\u0018\u0001D5uKJ\fGo\u001c:Ge>lGCA5m!\r\u0011$nH\u0005\u0003W:\u0011\u0001\"\u0013;fe\u0006$xN\u001d\u0005\u0006[.\u0001\raH\u0001\u0006gR\f'\u000f^\u0001\u000fgV\u0004XM\u001d\u0013tk\n\u001cX\r^(g)\ty\u0006\u000fC\u0003d\u0019\u0001\u0007A-\u0003\u0002^e&\u00111O\u0004\u0002\u000b\u000f\u0016t7+\u001a;MS.,\u0007")
public interface SortedSetLike<A, This extends SortedSet<A> & SortedSetLike<A, This>>
extends Sorted<A, This>,
SetLike<A, This> {
    public /* synthetic */ boolean scala$collection$SortedSetLike$$super$subsetOf(GenSet var1);

    @Override
    public Ordering<A> ordering();

    public static /* synthetic */ SortedSet keySet$(SortedSetLike $this) {
        return $this.keySet();
    }

    default public This keySet() {
        return (This)((SortedSet)this.repr());
    }

    public static /* synthetic */ Object firstKey$(SortedSetLike $this) {
        return $this.firstKey();
    }

    @Override
    default public A firstKey() {
        return this.head();
    }

    public static /* synthetic */ Object lastKey$(SortedSetLike $this) {
        return $this.lastKey();
    }

    @Override
    default public A lastKey() {
        return this.last();
    }

    @Override
    public This rangeImpl(Option<A> var1, Option<A> var2);

    public static /* synthetic */ SortedSet from$(SortedSetLike $this, Object from) {
        return $this.from((A)from);
    }

    @Override
    default public This from(A from) {
        return this.rangeImpl(new Some<A>(from), (Option<A>)None$.MODULE$);
    }

    public static /* synthetic */ SortedSet until$(SortedSetLike $this, Object until) {
        return $this.until((A)until);
    }

    @Override
    default public This until(A until) {
        return this.rangeImpl((Option<A>)None$.MODULE$, new Some<A>(until));
    }

    public static /* synthetic */ SortedSet range$(SortedSetLike $this, Object from, Object until) {
        return $this.range((A)from, (A)until);
    }

    @Override
    default public This range(A from, A until) {
        return this.rangeImpl(new Some<A>(from), new Some<A>(until));
    }

    public static /* synthetic */ boolean subsetOf$(SortedSetLike $this, GenSet that) {
        return $this.subsetOf(that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public boolean subsetOf(GenSet<A> that) {
        if (!(that instanceof SortedSet)) return this.scala$collection$SortedSetLike$$super$subsetOf(that);
        SortedSet sortedSet = (SortedSet)that;
        Ordering<A> ordering = sortedSet.ordering();
        Ordering<A> ordering2 = this.ordering();
        if (ordering != null) {
            if (!ordering.equals(ordering2)) return this.scala$collection$SortedSetLike$$super$subsetOf(that);
            return sortedSet.hasAll(this.iterator());
        }
        if (ordering2 == null) return sortedSet.hasAll(this.iterator());
        return this.scala$collection$SortedSetLike$$super$subsetOf(that);
    }

    public static /* synthetic */ Iterator iteratorFrom$(SortedSetLike $this, Object start) {
        return $this.iteratorFrom(start);
    }

    default public Iterator<A> iteratorFrom(A start) {
        return this.keysIteratorFrom(start);
    }

    public static void $init$(SortedSetLike $this) {
    }
}

