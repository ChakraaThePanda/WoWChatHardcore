/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.SetLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000113A!\u0003\u0006\u0001#!AA\u0007\u0001B\u0001B\u0003%a\u0005C\u00036\u0001\u0011\u0005a\u0007C\u0004:\u0001\u0001\u0007I\u0011\u0003\u001e\t\u000fm\u0002\u0001\u0019!C\ty!1!\t\u0001Q!\n\u0019BQa\u0011\u0001\u0005\u0002\u0011CQ\u0001\u0013\u0001\u0005\u0002%CQA\u0013\u0001\u0005\u0002-\u0013!bU3u\u0005VLG\u000eZ3s\u0015\tYA\"A\u0004nkR\f'\r\\3\u000b\u00055q\u0011AC2pY2,7\r^5p]*\tq\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0007IireE\u0002\u0001']\u0001\"\u0001F\u000b\u000e\u00039I!A\u0006\b\u0003\r\u0005s\u0017PU3g!\u0011A\u0012d\u0007\u0014\u000e\u0003)I!A\u0007\u0006\u0003\u001fI+Wo]1cY\u0016\u0014U/\u001b7eKJ\u0004\"\u0001H\u000f\r\u0001\u0011)a\u0004\u0001b\u0001?\t\t\u0011)\u0005\u0002!GA\u0011A#I\u0005\u0003E9\u0011qAT8uQ&tw\r\u0005\u0002\u0015I%\u0011QE\u0004\u0002\u0004\u0003:L\bC\u0001\u000f(\t\u0015A\u0003A1\u0001*\u0005\u0011\u0019u\u000e\u001c7\u0012\u0005\u0001R#cA\u0016.c\u0019!A\u0006\u0001\u0001+\u00051a$/\u001a4j]\u0016lWM\u001c;?!\rqsfG\u0007\u0002\u0019%\u0011\u0001\u0007\u0004\u0002\u0004'\u0016$\b\u0003\u0002\u001837\u0019J!a\r\u0007\u0003\u000fM+G\u000fT5lK\u0006)Q-\u001c9us\u00061A(\u001b8jiz\"\"a\u000e\u001d\u0011\ta\u00011D\n\u0005\u0006i\t\u0001\rAJ\u0001\u0006K2,Wn]\u000b\u0002M\u0005IQ\r\\3ng~#S-\u001d\u000b\u0003{\u0001\u0003\"\u0001\u0006 \n\u0005}r!\u0001B+oSRDq!\u0011\u0003\u0002\u0002\u0003\u0007a%A\u0002yIE\na!\u001a7f[N\u0004\u0013\u0001\u0003\u0013qYV\u001cH%Z9\u0015\u0005\u00153U\"\u0001\u0001\t\u000b\u001d3\u0001\u0019A\u000e\u0002\u0003a\fQa\u00197fCJ$\u0012!P\u0001\u0007e\u0016\u001cX\u000f\u001c;\u0015\u0003\u0019\u0002")
public class SetBuilder<A, Coll extends Set<A> & SetLike<A, Coll>>
implements ReusableBuilder<A, Coll> {
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
    public <NewTo> Builder<A, NewTo> mapResult(Function1<Coll, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    public Coll elems() {
        return this.elems;
    }

    public void elems_$eq(Coll x$1) {
        this.elems = x$1;
    }

    @Override
    public SetBuilder<A, Coll> $plus$eq(A x) {
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

    public SetBuilder(Coll empty) {
        this.empty = empty;
        Growable.$init$(this);
        Builder.$init$(this);
        this.elems = empty;
    }
}

