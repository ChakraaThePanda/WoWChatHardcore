/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView$;
import scala.collection.TraversableViewLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001I4q\u0001D\u0007\u0011\u0002G\u0005!cB\u0003,\u001b!\u0005AFB\u0003\r\u001b!\u0005Q\u0006C\u0003/\u0005\u0011\u0005qF\u0002\u00031\u0005\u0001\t\u0004\"\u0002\u0018\u0005\t\u0003Y\u0004\"\u0002 \u0005\t\u0003y\u0004\"B\"\u0005\t\u0003!\u0005\"\u0002%\u0005\t\u0003I\u0005\"\u0002&\u0005\t\u0003YU\u0001B\u0015\u0003\u0001=CQ\u0001\u0019\u0002\u0005\u0004\u0005\u0014q\u0002\u0016:bm\u0016\u00148/\u00192mKZKWm\u001e\u0006\u0003\u001d=\t!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0001\u0012!B:dC2\f7\u0001A\u000b\u0004'yA3c\u0001\u0001\u00151A\u0011QCF\u0007\u0002\u001f%\u0011qc\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\u000beQBd\n\u0016\u000e\u00035I!aG\u0007\u0003'Q\u0013\u0018M^3sg\u0006\u0014G.\u001a,jK^d\u0015n[3\u0011\u0005uqB\u0002\u0001\u0003\u0007?\u0001!)\u0019\u0001\u0011\u0003\u0003\u0005\u000b\"!\t\u0013\u0011\u0005U\u0011\u0013BA\u0012\u0010\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!F\u0013\n\u0005\u0019z!aA!osB\u0011Q\u0004\u000b\u0003\u0007S\u0001!)\u0019\u0001\u0011\u0003\t\r{G\u000e\u001c\t\u00053\u0001ar%A\bUe\u00064XM]:bE2,g+[3x!\tI\"a\u0005\u0002\u0003)\u00051A(\u001b8jiz\"\u0012\u0001\f\u0002\n\u001d>\u0014U/\u001b7eKJ,\"A\r\u001e\u0014\u0007\u0011!2\u0007\u0005\u00035oe\nS\"A\u001b\u000b\u0005Yj\u0011aB7vi\u0006\u0014G.Z\u0005\u0003qU\u0012qAQ;jY\u0012,'\u000f\u0005\u0002\u001eu\u0011)q\u0004\u0002b\u0001AQ\tA\bE\u0002>\tej\u0011AA\u0001\tIAdWo\u001d\u0013fcR\u0011\u0001)Q\u0007\u0002\t!)!I\u0002a\u0001s\u0005!Q\r\\3n\u0003!IG/\u001a:bi>\u0014X#A#\u0011\u0007e1\u0015(\u0003\u0002H\u001b\tA\u0011\n^3sCR|'/\u0001\u0004sKN,H\u000e\u001e\u000b\u0002C\u0005)1\r\\3beR\tA\n\u0005\u0002\u0016\u001b&\u0011aj\u0004\u0002\u0005+:LG\u000fM\u0002Q+J\u0003B!\u0007\u0001R)B\u0011QD\u0015\u0003\n'*\t\t\u0011!A\u0003\u0002\u0001\u00121a\u0018\u00132!\tiR\u000bB\u0005W\u0015\u0005\u0005\t\u0011!B\u0001/\n\t1)\u0005\u0002\"1B\u0012\u0011,\u0018\t\u00043ic\u0016BA.\u000e\u0005-!&/\u0019<feN\f'\r\\3\u0011\u0005uiF!\u00030`\u0003\u0003\u0005\tQ!\u0001!\u0005\ryFE\r\u0003\n-*\t\t\u0011!A\u0003\u0002]\u000bAbY1o\u0005VLG\u000e\u001a$s_6,\"AY6\u0016\u0003\r\u0004R\u0001Z4jU2l\u0011!\u001a\u0006\u0003M6\tqaZ3oKJL7-\u0003\u0002iK\na1)\u00198Ck&dGM\u0012:p[B\u0011QH\u0003\t\u0003;-$QaH\u0006C\u0002\u0001\u0002B!\u0007\u0001k[B\u0012a\u000e\u001d\t\u00043i{\u0007CA\u000fq\t%\t8\"!A\u0001\u0002\u000b\u0005\u0001EA\u0002`IM\u0002")
public interface TraversableView<A, Coll>
extends TraversableViewLike<A, Coll, TraversableView<A, Coll>> {
    public static <A> CanBuildFrom<TraversableView<?, ? extends Traversable<?>>, A, TraversableView<A, Traversable<?>>> canBuildFrom() {
        return TraversableView$.MODULE$.canBuildFrom();
    }

    public static class NoBuilder<A>
    implements Builder<A, Nothing$> {
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
        public <NewTo> Builder<A, NewTo> mapResult(Function1<Nothing$, NewTo> f) {
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

        @Override
        public NoBuilder<A> $plus$eq(A elem) {
            return this;
        }

        public Iterator<A> iterator() {
            return Iterator$.MODULE$.empty();
        }

        @Override
        public Nothing$ result() {
            throw new UnsupportedOperationException("TraversableView.Builder.result");
        }

        @Override
        public void clear() {
        }

        public NoBuilder() {
            Growable.$init$(this);
            Builder.$init$(this);
        }
    }
}

