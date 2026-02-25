/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Predef$;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.immutable.List$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.ReusableBuilder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001)3Q!\u0003\u0006\u0002\u0002EAQ!\u000b\u0001\u0005\u0002)Bq\u0001\f\u0001A\u0002\u0013EQ\u0006C\u00046\u0001\u0001\u0007I\u0011\u0003\u001c\t\rq\u0002\u0001\u0015)\u0003/\u0011\u0015i\u0004\u0001\"\u0001?\u0011\u0015\u0011\u0005\u0001\"\u0011D\u0011\u00151\u0005A\"\u0001H\u0011\u0015A\u0005\u0001\"\u0001J\u0005-a\u0015M_=Ck&dG-\u001a:\u000b\u0005-a\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0003\u001b9\t!bY8mY\u0016\u001cG/[8o\u0015\u0005y\u0011!B:dC2\f7\u0001A\u000b\u0004%u93c\u0001\u0001\u0014/A\u0011A#F\u0007\u0002\u001d%\u0011aC\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\taI2DJ\u0007\u0002\u0015%\u0011!D\u0003\u0002\u0010%\u0016,8/\u00192mK\n+\u0018\u000e\u001c3feB\u0011A$\b\u0007\u0001\t\u0015q\u0002A1\u0001 \u0005\u0011)E.Z7\u0012\u0005\u0001\u001a\u0003C\u0001\u000b\"\u0013\t\u0011cBA\u0004O_RD\u0017N\\4\u0011\u0005Q!\u0013BA\u0013\u000f\u0005\r\te.\u001f\t\u00039\u001d\"a\u0001\u000b\u0001\u0005\u0006\u0004y\"A\u0001+p\u0003\u0019a\u0014N\\5u}Q\t1\u0006\u0005\u0003\u0019\u0001m1\u0013!\u00029beR\u001cX#\u0001\u0018\u0011\u0007ay\u0013'\u0003\u00021\u0015\tQA*[:u\u0005V4g-\u001a:\u0011\u0007I\u001a4$D\u0001\r\u0013\t!DBA\bUe\u00064XM]:bE2,wJ\\2f\u0003%\u0001\u0018M\u001d;t?\u0012*\u0017\u000f\u0006\u00028uA\u0011A\u0003O\u0005\u0003s9\u0011A!\u00168ji\"91hAA\u0001\u0002\u0004q\u0013a\u0001=%c\u00051\u0001/\u0019:ug\u0002\n\u0001\u0002\n9mkN$S-\u001d\u000b\u0003\u007f\u0001k\u0011\u0001\u0001\u0005\u0006\u0003\u0016\u0001\raG\u0001\u0002q\u0006iA\u0005\u001d7vg\u0012\u0002H.^:%KF$\"a\u0010#\t\u000b\u00153\u0001\u0019A\u0019\u0002\u0005a\u001c\u0018A\u0002:fgVdG\u000fF\u0001'\u0003\u0015\u0019G.Z1s)\u00059\u0004")
public abstract class LazyBuilder<Elem, To>
implements ReusableBuilder<Elem, To> {
    private ListBuffer<TraversableOnce<Elem>> parts;

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

    public ListBuffer<TraversableOnce<Elem>> parts() {
        return this.parts;
    }

    public void parts_$eq(ListBuffer<TraversableOnce<Elem>> x$1) {
        this.parts = x$1;
    }

    @Override
    public LazyBuilder<Elem, To> $plus$eq(Elem x) {
        this.parts().$plus$eq(List$.MODULE$.apply((Seq)Predef$.MODULE$.genericWrapArray(new Object[]{x})));
        return this;
    }

    public LazyBuilder<Elem, To> $plus$plus$eq(TraversableOnce<Elem> xs) {
        this.parts().$plus$eq((Object)xs);
        return this;
    }

    @Override
    public abstract To result();

    @Override
    public void clear() {
        this.parts().clear();
    }

    public LazyBuilder() {
        Growable.$init$(this);
        Builder.$init$(this);
        this.parts = new ListBuffer();
    }
}

