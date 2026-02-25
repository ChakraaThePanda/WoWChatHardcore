/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00012QAA\u0002\u0002\u0002!AQ!\b\u0001\u0005\u0002y\u00111#\u00112tiJ\f7\r\u001e+sCZ,'o]1cY\u0016T!\u0001B\u0003\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0007\u0003\u0015\u00198-\u00197b\u0007\u0001)\"!\u0003\u000b\u0014\u0007\u0001Qa\u0002\u0005\u0002\f\u00195\tQ!\u0003\u0002\u000e\u000b\t1\u0011I\\=SK\u001a\u00042a\u0004\t\u0013\u001b\u0005\u0019\u0011BA\t\u0004\u0005-!&/\u0019<feN\f'\r\\3\u0011\u0005M!B\u0002\u0001\u0003\u0007+\u0001!)\u0019\u0001\f\u0003\u0003\u0005\u000b\"a\u0006\u000e\u0011\u0005-A\u0012BA\r\u0006\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"aC\u000e\n\u0005q)!aA!os\u00061A(\u001b8jiz\"\u0012a\b\t\u0004\u001f\u0001\u0011\u0002")
public abstract class AbstractTraversable<A>
implements Traversable<A> {
    @Override
    public GenericCompanion<Traversable> companion() {
        return Traversable.companion$(this);
    }

    @Override
    public Traversable<A> seq() {
        return Traversable.seq$(this);
    }

    @Override
    public Builder<A, Traversable<A>> newBuilder() {
        return GenericTraversableTemplate.newBuilder$(this);
    }

    @Override
    public <B> Builder<B, Traversable<B>> genericBuilder() {
        return GenericTraversableTemplate.genericBuilder$(this);
    }

    @Override
    public <A1, A2> Tuple2<Traversable<A1>, Traversable<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<Traversable<A1>, Traversable<A2>, Traversable<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
        return GenericTraversableTemplate.unzip3$(this, asTriple);
    }

    @Override
    public GenTraversable flatten(Function1 asTraversable) {
        return GenericTraversableTemplate.flatten$(this, asTraversable);
    }

    @Override
    public GenTraversable transpose(Function1 asTraversable) {
        return GenericTraversableTemplate.transpose$(this, asTraversable);
    }

    @Override
    public Object repr() {
        return TraversableLike.repr$(this);
    }

    @Override
    public final boolean isTraversableAgain() {
        return TraversableLike.isTraversableAgain$(this);
    }

    @Override
    public Traversable<A> thisCollection() {
        return TraversableLike.thisCollection$(this);
    }

    @Override
    public Traversable toCollection(Object repr) {
        return TraversableLike.toCollection$(this, repr);
    }

    @Override
    public Combiner<A, ParIterable<A>> parCombiner() {
        return TraversableLike.parCombiner$(this);
    }

    @Override
    public boolean isEmpty() {
        return TraversableLike.isEmpty$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return TraversableLike.hasDefiniteSize$(this);
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That map(Function1<A, B> f, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.map$(this, f, bf);
    }

    @Override
    public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    @Override
    public Object filterImpl(Function1 p, boolean isFlipped) {
        return TraversableLike.filterImpl$(this, p, isFlipped);
    }

    @Override
    public Object filter(Function1 p) {
        return TraversableLike.filter$(this, p);
    }

    @Override
    public Object filterNot(Function1 p) {
        return TraversableLike.filterNot$(this, p);
    }

    @Override
    public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public Tuple2<Traversable<A>, Traversable<A>> partition(Function1<A, Object> p) {
        return TraversableLike.partition$(this, p);
    }

    @Override
    public <K> Map<K, Traversable<A>> groupBy(Function1<A, K> f) {
        return TraversableLike.groupBy$(this, f);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return TraversableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return TraversableLike.exists$(this, p);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return TraversableLike.find$(this, p);
    }

    @Override
    public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<Traversable<A>, B, That> cbf) {
        return (That)TraversableLike.scan$(this, z, op, cbf);
    }

    @Override
    public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<Traversable<A>, B, That> bf) {
        return (That)TraversableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public A head() {
        return (A)TraversableLike.head$(this);
    }

    @Override
    public Option<A> headOption() {
        return TraversableLike.headOption$(this);
    }

    @Override
    public Object tail() {
        return TraversableLike.tail$(this);
    }

    @Override
    public A last() {
        return (A)TraversableLike.last$(this);
    }

    @Override
    public Option<A> lastOption() {
        return TraversableLike.lastOption$(this);
    }

    @Override
    public Object init() {
        return TraversableLike.init$(this);
    }

    @Override
    public Object take(int n) {
        return TraversableLike.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return TraversableLike.drop$(this, n);
    }

    @Override
    public Object slice(int from, int until) {
        return TraversableLike.slice$(this, from, until);
    }

    @Override
    public Object sliceWithKnownDelta(int from, int until, int delta) {
        return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
    }

    @Override
    public Object sliceWithKnownBound(int from, int until) {
        return TraversableLike.sliceWithKnownBound$(this, from, until);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return TraversableLike.takeWhile$(this, p);
    }

    @Override
    public Object dropWhile(Function1 p) {
        return TraversableLike.dropWhile$(this, p);
    }

    @Override
    public Tuple2<Traversable<A>, Traversable<A>> span(Function1<A, Object> p) {
        return TraversableLike.span$(this, p);
    }

    @Override
    public Tuple2<Traversable<A>, Traversable<A>> splitAt(int n) {
        return TraversableLike.splitAt$(this, n);
    }

    @Override
    public Iterator<Traversable<A>> tails() {
        return TraversableLike.tails$(this);
    }

    @Override
    public Iterator<Traversable<A>> inits() {
        return TraversableLike.inits$(this);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        TraversableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public Traversable<A> toTraversable() {
        return TraversableLike.toTraversable$(this);
    }

    @Override
    public Iterator<A> toIterator() {
        return TraversableLike.toIterator$(this);
    }

    @Override
    public Stream<A> toStream() {
        return TraversableLike.toStream$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
        return (Col)TraversableLike.to$(this, cbf);
    }

    @Override
    public String toString() {
        return TraversableLike.toString$(this);
    }

    @Override
    public String stringPrefix() {
        return TraversableLike.stringPrefix$(this);
    }

    @Override
    public TraversableView<A, Traversable<A>> view() {
        return TraversableLike.view$(this);
    }

    @Override
    public TraversableView<A, Traversable<A>> view(int from, int until) {
        return TraversableLike.view$(this, from, until);
    }

    @Override
    public FilterMonadic<A, Traversable<A>> withFilter(Function1<A, Object> p) {
        return TraversableLike.withFilter$(this, p);
    }

    @Override
    public Parallel par() {
        return Parallelizable.par$(this);
    }

    @Override
    public List<A> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public int size() {
        return TraversableOnce.size$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<A, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, A, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)TraversableOnce.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)TraversableOnce.reduceRight$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
        return TraversableOnce.reduceRightOption$(this, op);
    }

    @Override
    public <A1> A1 reduce(Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.reduce$(this, op);
    }

    @Override
    public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
        return TraversableOnce.reduceOption$(this, op);
    }

    @Override
    public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.fold$(this, z, op);
    }

    @Override
    public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
        return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <B> B sum(Numeric<B> num) {
        return (B)TraversableOnce.sum$(this, num);
    }

    @Override
    public <B> B product(Numeric<B> num) {
        return (B)TraversableOnce.product$(this, num);
    }

    @Override
    public <B> A min(Ordering<B> cmp) {
        return (A)TraversableOnce.min$(this, cmp);
    }

    @Override
    public <B> A max(Ordering<B> cmp) {
        return (A)TraversableOnce.max$(this, cmp);
    }

    @Override
    public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
        return (A)TraversableOnce.maxBy$(this, f, cmp);
    }

    @Override
    public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
        return (A)TraversableOnce.minBy$(this, f, cmp);
    }

    @Override
    public <B> void copyToBuffer(Buffer<B> dest) {
        TraversableOnce.copyToBuffer$(this, dest);
    }

    @Override
    public <B> void copyToArray(Object xs, int start) {
        TraversableOnce.copyToArray$(this, xs, start);
    }

    @Override
    public <B> void copyToArray(Object xs) {
        TraversableOnce.copyToArray$(this, xs);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public List<A> toList() {
        return TraversableOnce.toList$(this);
    }

    @Override
    public Iterable<A> toIterable() {
        return TraversableOnce.toIterable$(this);
    }

    @Override
    public Seq<A> toSeq() {
        return TraversableOnce.toSeq$(this);
    }

    @Override
    public IndexedSeq<A> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public <B> Buffer<B> toBuffer() {
        return TraversableOnce.toBuffer$(this);
    }

    @Override
    public <B> Set<B> toSet() {
        return TraversableOnce.toSet$(this);
    }

    @Override
    public Vector<A> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
        return TraversableOnce.toMap$(this, ev);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return TraversableOnce.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return TraversableOnce.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return TraversableOnce.mkString$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return TraversableOnce.addString$(this, b, start, sep, end);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String sep) {
        return TraversableOnce.addString$(this, b, sep);
    }

    @Override
    public StringBuilder addString(StringBuilder b) {
        return TraversableOnce.addString$(this, b);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    public AbstractTraversable() {
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        TraversableLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        Traversable.$init$(this);
    }
}

