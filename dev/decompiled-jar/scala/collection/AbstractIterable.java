/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Tuple2;
import scala.collection.AbstractTraversable;
import scala.collection.GenIterable;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Stream;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00012QAA\u0002\u0002\u0002!AQ!\b\u0001\u0005\u0002y\u0011\u0001#\u00112tiJ\f7\r^%uKJ\f'\r\\3\u000b\u0005\u0011)\u0011AC2pY2,7\r^5p]*\ta!A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005%\u00012c\u0001\u0001\u000b5A\u00191\u0002\u0004\b\u000e\u0003\rI!!D\u0002\u0003'\u0005\u00137\u000f\u001e:bGR$&/\u0019<feN\f'\r\\3\u0011\u0005=\u0001B\u0002\u0001\u0003\u0007#\u0001!)\u0019\u0001\n\u0003\u0003\u0005\u000b\"aE\f\u0011\u0005Q)R\"A\u0003\n\u0005Y)!a\u0002(pi\"Lgn\u001a\t\u0003)aI!!G\u0003\u0003\u0007\u0005s\u0017\u0010E\u0002\f79I!\u0001H\u0002\u0003\u0011%#XM]1cY\u0016\fa\u0001P5oSRtD#A\u0010\u0011\u0007-\u0001a\u0002")
public abstract class AbstractIterable<A>
extends AbstractTraversable<A>
implements Iterable<A> {
    @Override
    public GenericCompanion<Iterable> companion() {
        return Iterable.companion$(this);
    }

    @Override
    public Iterable<A> seq() {
        return Iterable.seq$(this);
    }

    @Override
    public Iterable<A> thisCollection() {
        return IterableLike.thisCollection$(this);
    }

    @Override
    public Iterable toCollection(Object repr) {
        return IterableLike.toCollection$(this, repr);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        IterableLike.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return IterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return IterableLike.exists$(this, p);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return IterableLike.find$(this, p);
    }

    @Override
    public boolean isEmpty() {
        return IterableLike.isEmpty$(this);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)IterableLike.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)IterableLike.reduceRight$(this, op);
    }

    @Override
    public Iterable<A> toIterable() {
        return IterableLike.toIterable$(this);
    }

    @Override
    public Iterator<A> toIterator() {
        return IterableLike.toIterator$(this);
    }

    @Override
    public A head() {
        return (A)IterableLike.head$(this);
    }

    @Override
    public Object slice(int from, int until) {
        return IterableLike.slice$(this, from, until);
    }

    @Override
    public Object take(int n) {
        return IterableLike.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return IterableLike.drop$(this, n);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return IterableLike.takeWhile$(this, p);
    }

    @Override
    public Iterator<Iterable<A>> grouped(int size) {
        return IterableLike.grouped$(this, size);
    }

    @Override
    public Iterator<Iterable<A>> sliding(int size) {
        return IterableLike.sliding$(this, size);
    }

    @Override
    public Iterator<Iterable<A>> sliding(int size, int step) {
        return IterableLike.sliding$(this, size, step);
    }

    @Override
    public Object takeRight(int n) {
        return IterableLike.takeRight$(this, n);
    }

    @Override
    public Object dropRight(int n) {
        return IterableLike.dropRight$(this, n);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IterableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Iterable<A>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zip$(this, that, bf);
    }

    @Override
    public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<Iterable<A>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<Iterable<A>, Tuple2<A1, Object>, That> bf) {
        return (That)IterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public Stream<A> toStream() {
        return IterableLike.toStream$(this);
    }

    @Override
    public boolean canEqual(Object that) {
        return IterableLike.canEqual$(this, that);
    }

    @Override
    public IterableView<A, Iterable<A>> view() {
        return IterableLike.view$(this);
    }

    @Override
    public IterableView<A, Iterable<A>> view(int from, int until) {
        return IterableLike.view$(this, from, until);
    }

    public AbstractIterable() {
        GenIterable.$init$(this);
        IterableLike.$init$(this);
        Iterable.$init$(this);
    }
}

