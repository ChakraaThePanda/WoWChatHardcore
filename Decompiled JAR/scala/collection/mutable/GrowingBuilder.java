/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001!3A!\u0003\u0006\u0001#!A\u0001\u0007\u0001B\u0001B\u0003%a\u0005C\u00032\u0001\u0011\u0005!\u0007C\u00046\u0001\u0001\u0007I\u0011\u0003\u001c\t\u000f]\u0002\u0001\u0019!C\tq!1a\b\u0001Q!\n\u0019BQa\u0010\u0001\u0005\u0002\u0001CQ\u0001\u0012\u0001\u0005\u0002\u0015CQA\u0012\u0001\u0005\u0002\u001d\u0013ab\u0012:po&twMQ;jY\u0012,'O\u0003\u0002\f\u0019\u00059Q.\u001e;bE2,'BA\u0007\u000f\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u001f\u0005)1oY1mC\u000e\u0001Qc\u0001\n\u001eOM\u0019\u0001aE\f\u0011\u0005Q)R\"\u0001\b\n\u0005Yq!AB!osJ+g\r\u0005\u0003\u00193m1S\"\u0001\u0006\n\u0005iQ!a\u0002\"vS2$WM\u001d\t\u00039ua\u0001\u0001B\u0003\u001f\u0001\t\u0007qD\u0001\u0003FY\u0016l\u0017C\u0001\u0011$!\t!\u0012%\u0003\u0002#\u001d\t9aj\u001c;iS:<\u0007C\u0001\u000b%\u0013\t)cBA\u0002B]f\u0004\"\u0001H\u0014\u0005\u000b!\u0002!\u0019A\u0015\u0003\u0005Q{\u0017C\u0001\u0011+!\rYcfG\u0007\u0002Y)\u0011Q\u0006D\u0001\bO\u0016tWM]5d\u0013\tyCF\u0001\u0005He><\u0018M\u00197f\u0003\u0015)W\u000e\u001d;z\u0003\u0019a\u0014N\\5u}Q\u00111\u0007\u000e\t\u00051\u0001Yb\u0005C\u00031\u0005\u0001\u0007a%A\u0003fY\u0016l7/F\u0001'\u0003%)G.Z7t?\u0012*\u0017\u000f\u0006\u0002:yA\u0011ACO\u0005\u0003w9\u0011A!\u00168ji\"9Q\bBA\u0001\u0002\u00041\u0013a\u0001=%c\u00051Q\r\\3ng\u0002\n\u0001\u0002\n9mkN$S-\u001d\u000b\u0003\u0003\nk\u0011\u0001\u0001\u0005\u0006\u0007\u001a\u0001\raG\u0001\u0002q\u0006)1\r\\3beR\t\u0011(\u0001\u0004sKN,H\u000e\u001e\u000b\u0002M\u0001")
public class GrowingBuilder<Elem, To extends Growable<Elem>>
implements Builder<Elem, To> {
    private final To empty;
    private To elems;

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
    public <NewTo> Builder<Elem, NewTo> mapResult(Function1<To, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<Elem> $plus$eq(Elem elem1, Elem elem2, Seq<Elem> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<Elem> $plus$plus$eq(TraversableOnce<Elem> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    public To elems() {
        return this.elems;
    }

    public void elems_$eq(To x$1) {
        this.elems = x$1;
    }

    @Override
    public GrowingBuilder<Elem, To> $plus$eq(Elem x) {
        this.elems().$plus$eq(x);
        return this;
    }

    @Override
    public void clear() {
        this.empty.clear();
    }

    @Override
    public To result() {
        return this.elems();
    }

    public GrowingBuilder(To empty) {
        this.empty = empty;
        Growable.$init$(this);
        Builder.$init$(this);
        this.elems = empty;
    }
}

