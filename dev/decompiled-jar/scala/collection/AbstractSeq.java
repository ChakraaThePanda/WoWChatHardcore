/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.collection.AbstractIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Range;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSeq;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00012QAA\u0002\u0002\u0002!AQ!\b\u0001\u0005\u0002y\u00111\"\u00112tiJ\f7\r^*fc*\u0011A!B\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0004\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0011\u0002E\n\u0004\u0001)Q\u0002cA\u0006\r\u001d5\t1!\u0003\u0002\u000e\u0007\t\u0001\u0012IY:ue\u0006\u001cG/\u0013;fe\u0006\u0014G.\u001a\t\u0003\u001fAa\u0001\u0001\u0002\u0004\u0012\u0001\u0011\u0015\rA\u0005\u0002\u0002\u0003F\u00111c\u0006\t\u0003)Ui\u0011!B\u0005\u0003-\u0015\u0011qAT8uQ&tw\r\u0005\u0002\u00151%\u0011\u0011$\u0002\u0002\u0004\u0003:L\bcA\u0006\u001c\u001d%\u0011Ad\u0001\u0002\u0004'\u0016\f\u0018A\u0002\u001fj]&$h\bF\u0001 !\rY\u0001A\u0004")
public abstract class AbstractSeq<A>
extends AbstractIterable<A>
implements Seq<A> {
    @Override
    public GenericCompanion<Seq> companion() {
        return Seq.companion$(this);
    }

    @Override
    public Seq<A> seq() {
        return Seq.seq$(this);
    }

    @Override
    public Seq<A> thisCollection() {
        return SeqLike.thisCollection$(this);
    }

    @Override
    public Seq toCollection(Object repr) {
        return SeqLike.toCollection$(this, repr);
    }

    @Override
    public Combiner<A, ParSeq<A>> parCombiner() {
        return SeqLike.parCombiner$(this);
    }

    @Override
    public int lengthCompare(int len) {
        return SeqLike.lengthCompare$(this, len);
    }

    @Override
    public boolean isEmpty() {
        return SeqLike.isEmpty$(this);
    }

    @Override
    public int size() {
        return SeqLike.size$(this);
    }

    @Override
    public int segmentLength(Function1<A, Object> p, int from) {
        return SeqLike.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return SeqLike.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p, int end) {
        return SeqLike.lastIndexWhere$(this, p, end);
    }

    @Override
    public Iterator<Seq<A>> permutations() {
        return SeqLike.permutations$(this);
    }

    @Override
    public Iterator<Seq<A>> combinations(int n) {
        return SeqLike.combinations$(this, n);
    }

    @Override
    public Object reverse() {
        return SeqLike.reverse$(this);
    }

    @Override
    public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<Seq<A>, B, That> bf) {
        return (That)SeqLike.reverseMap$(this, f, bf);
    }

    @Override
    public Iterator<A> reverseIterator() {
        return SeqLike.reverseIterator$(this);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return SeqLike.startsWith$(this, that, offset);
    }

    @Override
    public <B> boolean endsWith(GenSeq<B> that) {
        return SeqLike.endsWith$(this, that);
    }

    @Override
    public <B> int indexOfSlice(GenSeq<B> that) {
        return SeqLike.indexOfSlice$(this, that);
    }

    @Override
    public <B> int indexOfSlice(GenSeq<B> that, int from) {
        return SeqLike.indexOfSlice$(this, that, from);
    }

    @Override
    public <B> int lastIndexOfSlice(GenSeq<B> that) {
        return SeqLike.lastIndexOfSlice$(this, that);
    }

    @Override
    public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
        return SeqLike.lastIndexOfSlice$(this, that, end);
    }

    @Override
    public <B> boolean containsSlice(GenSeq<B> that) {
        return SeqLike.containsSlice$(this, that);
    }

    @Override
    public <A1> boolean contains(A1 elem) {
        return SeqLike.contains$(this, elem);
    }

    @Override
    public <B, That> That union(GenSeq<B> that, CanBuildFrom<Seq<A>, B, That> bf) {
        return (That)SeqLike.union$(this, that, bf);
    }

    @Override
    public Object diff(GenSeq that) {
        return SeqLike.diff$(this, that);
    }

    @Override
    public Object intersect(GenSeq that) {
        return SeqLike.intersect$(this, that);
    }

    @Override
    public Object distinct() {
        return SeqLike.distinct$(this);
    }

    @Override
    public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<Seq<A>, B, That> bf) {
        return (That)SeqLike.patch$(this, from, patch, replaced, bf);
    }

    @Override
    public <B, That> That updated(int index, B elem, CanBuildFrom<Seq<A>, B, That> bf) {
        return (That)SeqLike.updated$(this, index, elem, bf);
    }

    @Override
    public <B, That> That $plus$colon(B elem, CanBuildFrom<Seq<A>, B, That> bf) {
        return (That)SeqLike.$plus$colon$(this, elem, bf);
    }

    @Override
    public <B, That> That $colon$plus(B elem, CanBuildFrom<Seq<A>, B, That> bf) {
        return (That)SeqLike.$colon$plus$(this, elem, bf);
    }

    @Override
    public <B, That> That padTo(int len, B elem, CanBuildFrom<Seq<A>, B, That> bf) {
        return (That)SeqLike.padTo$(this, len, elem, bf);
    }

    @Override
    public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return SeqLike.corresponds$(this, that, p);
    }

    @Override
    public Object sortWith(Function2 lt) {
        return SeqLike.sortWith$(this, lt);
    }

    @Override
    public Object sortBy(Function1 f, Ordering ord) {
        return SeqLike.sortBy$(this, f, ord);
    }

    @Override
    public Object sorted(Ordering ord) {
        return SeqLike.sorted$(this, ord);
    }

    @Override
    public Seq<A> toSeq() {
        return SeqLike.toSeq$(this);
    }

    @Override
    public Range indices() {
        return SeqLike.indices$(this);
    }

    @Override
    public SeqView<A, Seq<A>> view() {
        return SeqLike.view$(this);
    }

    @Override
    public SeqView<A, Seq<A>> view(int from, int until) {
        return SeqLike.view$(this, from, until);
    }

    @Override
    public String toString() {
        return SeqLike.toString$(this);
    }

    @Override
    public boolean isDefinedAt(int idx) {
        return GenSeqLike.isDefinedAt$(this, idx);
    }

    @Override
    public int prefixLength(Function1<A, Object> p) {
        return GenSeqLike.prefixLength$(this, p);
    }

    @Override
    public int indexWhere(Function1<A, Object> p) {
        return GenSeqLike.indexWhere$(this, p);
    }

    @Override
    public <B> int indexOf(B elem) {
        return GenSeqLike.indexOf$(this, elem);
    }

    @Override
    public <B> int indexOf(B elem, int from) {
        return GenSeqLike.indexOf$(this, elem, from);
    }

    @Override
    public <B> int lastIndexOf(B elem) {
        return GenSeqLike.lastIndexOf$(this, elem);
    }

    @Override
    public <B> int lastIndexOf(B elem, int end) {
        return GenSeqLike.lastIndexOf$(this, elem, end);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p) {
        return GenSeqLike.lastIndexWhere$(this, p);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that) {
        return GenSeqLike.startsWith$(this, that);
    }

    @Override
    public int hashCode() {
        return GenSeqLike.hashCode$(this);
    }

    @Override
    public boolean equals(Object that) {
        return GenSeqLike.equals$(this, that);
    }

    @Override
    public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
        return PartialFunction.orElse$(this, that);
    }

    @Override
    public <C> PartialFunction<Object, C> andThen(Function1<A, C> k) {
        return PartialFunction.andThen$(this, k);
    }

    @Override
    public Function1<Object, Option<A>> lift() {
        return PartialFunction.lift$(this);
    }

    @Override
    public Object applyOrElse(Object x, Function1 function1) {
        return PartialFunction.applyOrElse$(this, x, function1);
    }

    @Override
    public <U> Function1<Object, Object> runWith(Function1<A, U> action) {
        return PartialFunction.runWith$(this, action);
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, A> compose(Function1<A, Object> g) {
        return Function1.compose$(this, g);
    }

    public AbstractSeq() {
        PartialFunction.$init$(this);
        GenSeqLike.$init$(this);
        GenSeq.$init$(this);
        SeqLike.$init$(this);
        Seq.$init$(this);
    }
}

