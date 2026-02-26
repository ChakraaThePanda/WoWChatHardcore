/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.immutable.VectorBuilder;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.immutable.ParVector;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00154Q\u0001D\u0007\u0001\u001bUAQa\f\u0001\u0005\u0002ABqA\r\u0001A\u0002\u0013\u00051\u0007C\u00048\u0001\u0001\u0007I\u0011\u0001\u001d\t\ry\u0002\u0001\u0015)\u00035\u0011\u001dy\u0004A1A\u0005\u0002\u0001Ca\u0001\u0014\u0001!\u0002\u0013\t\u0005\"B'\u0001\t\u0003\u0019\u0004\"\u0002(\u0001\t\u0003y\u0005\"B*\u0001\t\u0003!\u0006\"B+\u0001\t\u00031\u0006\"B,\u0001\t\u0003A&!\u0006'buf\u0004\u0016M\u001d,fGR|'oQ8nE&tWM\u001d\u0006\u0003\u001d=\t\u0011\"[7nkR\f'\r\\3\u000b\u0005A\t\u0012\u0001\u00039be\u0006dG.\u001a7\u000b\u0005I\u0019\u0012AC2pY2,7\r^5p]*\tA#A\u0003tG\u0006d\u0017-\u0006\u0002\u0017CM\u0019\u0001aF\u000e\u0011\u0005aIR\"A\n\n\u0005i\u0019\"AB!osJ+g\r\u0005\u0003\u001d;}YS\"A\b\n\u0005yy!\u0001C\"p[\nLg.\u001a:\u0011\u0005\u0001\nC\u0002\u0001\u0003\u0006E\u0001\u0011\r\u0001\n\u0002\u0002)\u000e\u0001\u0011CA\u0013)!\tAb%\u0003\u0002('\t9aj\u001c;iS:<\u0007C\u0001\r*\u0013\tQ3CA\u0002B]f\u00042\u0001L\u0017 \u001b\u0005i\u0011B\u0001\u0018\u000e\u0005%\u0001\u0016M\u001d,fGR|'/\u0001\u0004=S:LGO\u0010\u000b\u0002cA\u0019A\u0006A\u0010\u0002\u0005MTX#\u0001\u001b\u0011\u0005a)\u0014B\u0001\u001c\u0014\u0005\rIe\u000e^\u0001\u0007gj|F%Z9\u0015\u0005eb\u0004C\u0001\r;\u0013\tY4C\u0001\u0003V]&$\bbB\u001f\u0004\u0003\u0003\u0005\r\u0001N\u0001\u0004q\u0012\n\u0014aA:{A\u00059a/Z2u_J\u001cX#A!\u0011\u0007\t+u)D\u0001D\u0015\t!\u0015#A\u0004nkR\f'\r\\3\n\u0005\u0019\u001b%aC!se\u0006L()\u001e4gKJ\u00042\u0001\u0013& \u001b\u0005I%B\u0001\b\u0012\u0013\tY\u0015JA\u0007WK\u000e$xN\u001d\"vS2$WM]\u0001\tm\u0016\u001cGo\u001c:tA\u0005!1/\u001b>f\u0003!!\u0003\u000f\\;tI\u0015\fHC\u0001)R\u001b\u0005\u0001\u0001\"\u0002*\t\u0001\u0004y\u0012\u0001B3mK6\fQa\u00197fCJ$\u0012!O\u0001\u0007e\u0016\u001cX\u000f\u001c;\u0015\u0003-\nqaY8nE&tW-F\u0002Z9\u0002$\"AW2\u0011\tqi2l\u0018\t\u0003Aq#Q!X\u0006C\u0002y\u0013\u0011!V\t\u0003K}\u0001\"\u0001\t1\u0005\u000b\u0005\\!\u0019\u00012\u0003\u000b9+w\u000fV8\u0012\u0005-B\u0003\"\u00023\f\u0001\u0004Q\u0016!B8uQ\u0016\u0014\b")
public class LazyParVectorCombiner<T>
implements Combiner<T, ParVector<T>> {
    private int sz;
    private final ArrayBuffer<VectorBuilder<T>> vectors;
    private volatile transient TaskSupport _combinerTaskSupport;

    @Override
    public TaskSupport combinerTaskSupport() {
        return Combiner.combinerTaskSupport$(this);
    }

    @Override
    public void combinerTaskSupport_$eq(TaskSupport cts) {
        Combiner.combinerTaskSupport_$eq$(this, cts);
    }

    @Override
    public boolean canBeShared() {
        return Combiner.canBeShared$(this);
    }

    @Override
    public Object resultWithTaskSupport() {
        return Combiner.resultWithTaskSupport$(this);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<T, NewTo> mapResult(Function1<ParVector<T>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<T> $plus$eq(T elem1, T elem2, Seq<T> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<T> $plus$plus$eq(TraversableOnce<T> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public TaskSupport _combinerTaskSupport() {
        return this._combinerTaskSupport;
    }

    @Override
    public void _combinerTaskSupport_$eq(TaskSupport x$1) {
        this._combinerTaskSupport = x$1;
    }

    public int sz() {
        return this.sz;
    }

    public void sz_$eq(int x$1) {
        this.sz = x$1;
    }

    public ArrayBuffer<VectorBuilder<T>> vectors() {
        return this.vectors;
    }

    @Override
    public int size() {
        return this.sz();
    }

    @Override
    public LazyParVectorCombiner<T> $plus$eq(T elem) {
        this.vectors().last().$plus$eq((Object)elem);
        this.sz_$eq(this.sz() + 1);
        return this;
    }

    @Override
    public void clear() {
        this.vectors().clear();
        this.vectors().$plus$eq((Object)new VectorBuilder());
        this.sz_$eq(0);
    }

    @Override
    public ParVector<T> result() {
        VectorBuilder rvb = new VectorBuilder();
        this.vectors().foreach((Function1<VectorBuilder, VectorBuilder> & java.io.Serializable & Serializable)vb -> rvb.$plus$plus$eq((TraversableOnce)vb.result()));
        return new ParVector(rvb.result());
    }

    @Override
    public <U extends T, NewTo> Combiner<U, NewTo> combine(Combiner<U, NewTo> other) {
        if (other == this) {
            return this;
        }
        LazyParVectorCombiner that = (LazyParVectorCombiner)other;
        this.sz_$eq(this.sz() + that.sz());
        this.vectors().$plus$plus$eq(that.vectors());
        return this;
    }

    public LazyParVectorCombiner() {
        Growable.$init$(this);
        Builder.$init$(this);
        Combiner.$init$(this);
        this.sz = 0;
        this.vectors = new ArrayBuffer().$plus$eq(new VectorBuilder());
    }
}

