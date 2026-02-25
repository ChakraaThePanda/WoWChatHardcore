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
import scala.collection.BufferedIterator;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00012QAA\u0002\u0002\u0002!AQ!\b\u0001\u0005\u0002y\u0011\u0001#\u00112tiJ\f7\r^%uKJ\fGo\u001c:\u000b\u0005\u0011)\u0011AC2pY2,7\r^5p]*\ta!A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005%!2c\u0001\u0001\u000b\u001dA\u00111\u0002D\u0007\u0002\u000b%\u0011Q\"\u0002\u0002\u0007\u0003:L(+\u001a4\u0011\u0007=\u0001\"#D\u0001\u0004\u0013\t\t2A\u0001\u0005Ji\u0016\u0014\u0018\r^8s!\t\u0019B\u0003\u0004\u0001\u0005\rU\u0001AQ1\u0001\u0017\u0005\u0005\t\u0015CA\f\u001b!\tY\u0001$\u0003\u0002\u001a\u000b\t9aj\u001c;iS:<\u0007CA\u0006\u001c\u0013\taRAA\u0002B]f\fa\u0001P5oSRtD#A\u0010\u0011\u0007=\u0001!\u0003")
public abstract class AbstractIterator<A>
implements Iterator<A> {
    @Override
    public Iterator<A> seq() {
        return Iterator.seq$(this);
    }

    @Override
    public boolean isEmpty() {
        return Iterator.isEmpty$(this);
    }

    @Override
    public boolean isTraversableAgain() {
        return Iterator.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return Iterator.hasDefiniteSize$(this);
    }

    @Override
    public Iterator<A> take(int n) {
        return Iterator.take$(this, n);
    }

    @Override
    public Iterator<A> drop(int n) {
        return Iterator.drop$(this, n);
    }

    @Override
    public Iterator<A> slice(int from, int until) {
        return Iterator.slice$(this, from, until);
    }

    @Override
    public Iterator<A> sliceIterator(int from, int until) {
        return Iterator.sliceIterator$(this, from, until);
    }

    @Override
    public <B> Iterator<B> map(Function1<A, B> f) {
        return Iterator.map$(this, f);
    }

    @Override
    public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
        return Iterator.$plus$plus$(this, that);
    }

    @Override
    public <B> Iterator<B> flatMap(Function1<A, GenTraversableOnce<B>> f) {
        return Iterator.flatMap$(this, f);
    }

    @Override
    public Iterator<A> filter(Function1<A, Object> p) {
        return Iterator.filter$(this, p);
    }

    @Override
    public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<A, B, Object> p) {
        return Iterator.corresponds$(this, that, p);
    }

    @Override
    public Iterator<A> withFilter(Function1<A, Object> p) {
        return Iterator.withFilter$(this, p);
    }

    @Override
    public Iterator<A> filterNot(Function1<A, Object> p) {
        return Iterator.filterNot$(this, p);
    }

    @Override
    public <B> Iterator<B> collect(PartialFunction<A, B> pf) {
        return Iterator.collect$(this, pf);
    }

    @Override
    public <B> Iterator<B> scanLeft(B z, Function2<B, A, B> op) {
        return Iterator.scanLeft$(this, z, op);
    }

    @Override
    public <B> Iterator<B> scanRight(B z, Function2<A, B, B> op) {
        return Iterator.scanRight$(this, z, op);
    }

    @Override
    public Iterator<A> takeWhile(Function1<A, Object> p) {
        return Iterator.takeWhile$(this, p);
    }

    @Override
    public Tuple2<Iterator<A>, Iterator<A>> partition(Function1<A, Object> p) {
        return Iterator.partition$(this, p);
    }

    @Override
    public Tuple2<Iterator<A>, Iterator<A>> span(Function1<A, Object> p) {
        return Iterator.span$(this, p);
    }

    @Override
    public Iterator<A> dropWhile(Function1<A, Object> p) {
        return Iterator.dropWhile$(this, p);
    }

    @Override
    public <B> Iterator<Tuple2<A, B>> zip(Iterator<B> that) {
        return Iterator.zip$(this, that);
    }

    @Override
    public <A1> Iterator<A1> padTo(int len, A1 elem) {
        return Iterator.padTo$(this, len, elem);
    }

    @Override
    public Iterator<Tuple2<A, Object>> zipWithIndex() {
        return Iterator.zipWithIndex$(this);
    }

    @Override
    public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
        return Iterator.zipAll$(this, that, thisElem, thatElem);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        Iterator.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return Iterator.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return Iterator.exists$(this, p);
    }

    @Override
    public boolean contains(Object elem) {
        return Iterator.contains$(this, elem);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return Iterator.find$(this, p);
    }

    @Override
    public int indexWhere(Function1<A, Object> p) {
        return Iterator.indexWhere$(this, p);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return Iterator.indexWhere$(this, p, from);
    }

    @Override
    public <B> int indexOf(B elem) {
        return Iterator.indexOf$(this, elem);
    }

    @Override
    public <B> int indexOf(B elem, int from) {
        return Iterator.indexOf$(this, elem, from);
    }

    @Override
    public BufferedIterator<A> buffered() {
        return Iterator.buffered$(this);
    }

    @Override
    public <B> Iterator.GroupedIterator<B> grouped(int size) {
        return Iterator.grouped$(this, size);
    }

    @Override
    public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
        return Iterator.sliding$(this, size, step);
    }

    @Override
    public <B> int sliding$default$2() {
        return Iterator.sliding$default$2$(this);
    }

    @Override
    public int length() {
        return Iterator.length$(this);
    }

    @Override
    public Tuple2<Iterator<A>, Iterator<A>> duplicate() {
        return Iterator.duplicate$(this);
    }

    @Override
    public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
        return Iterator.patch$(this, from, patchElems, replaced);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        Iterator.copyToArray$(this, xs, start, len);
    }

    @Override
    public boolean sameElements(Iterator<?> that) {
        return Iterator.sameElements$(this, that);
    }

    @Override
    public Traversable<A> toTraversable() {
        return Iterator.toTraversable$(this);
    }

    @Override
    public Iterator<A> toIterator() {
        return Iterator.toIterator$(this);
    }

    @Override
    public Stream<A> toStream() {
        return Iterator.toStream$(this);
    }

    @Override
    public String toString() {
        return Iterator.toString$(this);
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
    public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
        return (Col)TraversableOnce.to$(this, cbf);
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

    public AbstractIterator() {
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Iterator.$init$(this);
    }
}

