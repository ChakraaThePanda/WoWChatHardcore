/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

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
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Splitter;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.runtime.Nothing$;

public final class Splitter$ {
    public static Splitter$ MODULE$;

    static {
        new Splitter$();
    }

    public <T> Splitter<T> empty() {
        return new Splitter<T>(){

            public Iterator<T> seq() {
                return Iterator.seq$(this);
            }

            public boolean isEmpty() {
                return Iterator.isEmpty$(this);
            }

            public boolean isTraversableAgain() {
                return Iterator.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return Iterator.hasDefiniteSize$(this);
            }

            public Iterator<T> take(int n) {
                return Iterator.take$(this, n);
            }

            public Iterator<T> drop(int n) {
                return Iterator.drop$(this, n);
            }

            public Iterator<T> slice(int from, int until) {
                return Iterator.slice$(this, from, until);
            }

            public Iterator<T> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> map(Function1<T, B> f) {
                return Iterator.map$(this, f);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<T, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<T> filter(Function1<T, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<T, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<T> withFilter(Function1<T, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<T> filterNot(Function1<T, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<T, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, T, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<T, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<T> takeWhile(Function1<T, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<T>, Iterator<T>> partition(Function1<T, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<T>, Iterator<T>> span(Function1<T, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<T> dropWhile(Function1<T, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<T, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<T, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<T, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<T, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<T, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<T> find(Function1<T, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<T, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<T, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<T> buffered() {
                return Iterator.buffered$(this);
            }

            public <B> Iterator.GroupedIterator<B> grouped(int size) {
                return Iterator.grouped$(this, size);
            }

            public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
                return Iterator.sliding$(this, size, step);
            }

            public <B> int sliding$default$2() {
                return Iterator.sliding$default$2$(this);
            }

            public int length() {
                return Iterator.length$(this);
            }

            public Tuple2<Iterator<T>, Iterator<T>> duplicate() {
                return Iterator.duplicate$(this);
            }

            public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                return Iterator.patch$(this, from, patchElems, replaced);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                Iterator.copyToArray$(this, xs, start, len);
            }

            public boolean sameElements(Iterator<?> that) {
                return Iterator.sameElements$(this, that);
            }

            public Traversable<T> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<T> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<T> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<T> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<T, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<T, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, T, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<T, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, T, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<T, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, T, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<T, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, T, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<T, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, T, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> T min(Ordering<B> cmp) {
                return (T)TraversableOnce.min$(this, cmp);
            }

            public <B> T max(Ordering<B> cmp) {
                return (T)TraversableOnce.max$(this, cmp);
            }

            public <B> T maxBy(Function1<T, B> f, Ordering<B> cmp) {
                return (T)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> T minBy(Function1<T, B> f, Ordering<B> cmp) {
                return (T)TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public List<T> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<T> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<T> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<T> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<T> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<T, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableOnce.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableOnce.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableOnce.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableOnce.addString$(this, b, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public boolean hasNext() {
                return false;
            }

            public Nothing$ next() {
                return Iterator$.MODULE$.empty().next();
            }

            public Seq<Splitter<T>> split() {
                return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Iterator.$init$(this);
            }
        };
    }

    private Splitter$() {
        MODULE$ = this;
    }
}

