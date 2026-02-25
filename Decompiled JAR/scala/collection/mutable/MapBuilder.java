/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Tuple2;
import scala.collection.GenMap;
import scala.collection.GenMapLike;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001I3A!\u0003\u0006\u0001#!A!\b\u0001B\u0001B\u0003%A\u0006C\u0003<\u0001\u0011\u0005A\bC\u0004@\u0001\u0001\u0007I\u0011\u0003!\t\u000f\u0005\u0003\u0001\u0019!C\t\u0005\"1\u0001\n\u0001Q!\n1BQ!\u0013\u0001\u0005\u0002)CQA\u0014\u0001\u0005\u0002=CQ\u0001\u0015\u0001\u0005\u0002E\u0013!\"T1q\u0005VLG\u000eZ3s\u0015\tYA\"A\u0004nkR\f'\r\\3\u000b\u00055q\u0011AC2pY2,7\r^5p]*\tq\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\tI\u0001#&L\n\u0004\u0001M9\u0002C\u0001\u000b\u0016\u001b\u0005q\u0011B\u0001\f\u000f\u0005\u0019\te.\u001f*fMB!\u0001$G\u000e-\u001b\u0005Q\u0011B\u0001\u000e\u000b\u0005=\u0011V-^:bE2,')^5mI\u0016\u0014\b\u0003\u0002\u000b\u001d=%J!!\b\b\u0003\rQ+\b\u000f\\33!\ty\u0002\u0005\u0004\u0001\u0005\u000b\u0005\u0002!\u0019\u0001\u0012\u0003\u0003\u0005\u000b\"a\t\u0014\u0011\u0005Q!\u0013BA\u0013\u000f\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001F\u0014\n\u0005!r!aA!osB\u0011qD\u000b\u0003\u0006W\u0001\u0011\rA\t\u0002\u0002\u0005B\u0011q$\f\u0003\u0006]\u0001\u0011\ra\f\u0002\u0005\u0007>dG.\u0005\u0002$aI\u0019\u0011gM\u001c\u0007\tI\u0002\u0001\u0001\r\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0005iUr\u0012&D\u0001\r\u0013\t1DB\u0001\u0004HK:l\u0015\r\u001d\t\u0006iar\u0012\u0006L\u0005\u0003s1\u0011!bR3o\u001b\u0006\u0004H*[6f\u0003\u0015)W\u000e\u001d;z\u0003\u0019a\u0014N\\5u}Q\u0011QH\u0010\t\u00061\u0001q\u0012\u0006\f\u0005\u0006u\t\u0001\r\u0001L\u0001\u0006K2,Wn]\u000b\u0002Y\u0005IQ\r\\3ng~#S-\u001d\u000b\u0003\u0007\u001a\u0003\"\u0001\u0006#\n\u0005\u0015s!\u0001B+oSRDqa\u0012\u0003\u0002\u0002\u0003\u0007A&A\u0002yIE\na!\u001a7f[N\u0004\u0013\u0001\u0003\u0013qYV\u001cH%Z9\u0015\u0005-cU\"\u0001\u0001\t\u000b53\u0001\u0019A\u000e\u0002\u0003a\fQa\u00197fCJ$\u0012aQ\u0001\u0007e\u0016\u001cX\u000f\u001c;\u0015\u00031\u0002")
public class MapBuilder<A, B, Coll extends GenMap<A, B> & GenMapLike<A, B, Coll>>
implements ReusableBuilder<Tuple2<A, B>, Coll> {
    private final Coll empty;
    private Coll elems;

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
    public <NewTo> Builder<Tuple2<A, B>, NewTo> mapResult(Function1<Coll, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<Tuple2<A, B>> $plus$plus$eq(TraversableOnce<Tuple2<A, B>> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    public Coll elems() {
        return this.elems;
    }

    public void elems_$eq(Coll x$1) {
        this.elems = x$1;
    }

    public MapBuilder<A, B, Coll> $plus$eq(Tuple2<A, B> x) {
        this.elems_$eq(this.elems().$plus(x));
        return this;
    }

    @Override
    public void clear() {
        this.elems_$eq(this.empty);
    }

    @Override
    public Coll result() {
        return this.elems();
    }

    public MapBuilder(Coll empty) {
        this.empty = empty;
        Growable.$init$(this);
        Builder.$init$(this);
        this.elems = empty;
    }
}

