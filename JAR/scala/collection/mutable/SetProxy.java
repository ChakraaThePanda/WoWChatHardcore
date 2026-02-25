/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Proxy;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableProxyLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.SetProxyLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableProxyLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.SetLike;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSet;
import scala.collection.script.Message;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001=3q\u0001C\u0005\u0011\u0002\u0007\u0005\u0001\u0003C\u0003*\u0001\u0011\u0005!\u0006C\u0003/\u0001\u0011\u0005s\u0006C\u00032\u0001\u0011\u0005#\u0007C\u0003:\u0001\u0011\u0005#\bC\u0003>\u0001\u0011\u0005c\bC\u0003A\u0001\u0011\u0005\u0011\tC\u0003E\u0001\u0011\u0005QI\u0001\u0005TKR\u0004&o\u001c=z\u0015\tQ1\"A\u0004nkR\f'\r\\3\u000b\u00051i\u0011AC2pY2,7\r^5p]*\ta\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005Ea2\u0003\u0002\u0001\u0013-\u0015\u0002\"a\u0005\u000b\u000e\u00035I!!F\u0007\u0003\r\u0005s\u0017PU3g!\r9\u0002DG\u0007\u0002\u0013%\u0011\u0011$\u0003\u0002\u0004'\u0016$\bCA\u000e\u001d\u0019\u0001!Q!\b\u0001C\u0002y\u0011\u0011!Q\t\u0003?\t\u0002\"a\u0005\u0011\n\u0005\u0005j!a\u0002(pi\"Lgn\u001a\t\u0003'\rJ!\u0001J\u0007\u0003\u0007\u0005s\u0017\u0010\u0005\u0003'Oi1R\"A\u0006\n\u0005!Z!\u0001D*fiB\u0013x\u000e_=MS.,\u0017A\u0002\u0013j]&$H\u0005F\u0001,!\t\u0019B&\u0003\u0002.\u001b\t!QK\\5u\u0003\u0011\u0011X\r\u001d:\u0016\u0003A\u00022a\u0006\u0001\u001b\u0003\u0015)W\u000e\u001d;z+\u0005\u0019$c\u0001\u001b\u0013a\u0019!Qg\u0001\u00014\u00051a$/\u001a4j]\u0016lWM\u001c;?\u0011\u001d9DG1A\u0005\u0002a\nAa]3mMV\ta#A\u0003%a2,8\u000f\u0006\u00021w!)A\b\u0002a\u00015\u0005!Q\r\\3n\u0003\u0019!S.\u001b8vgR\u0011\u0001g\u0010\u0005\u0006y\u0015\u0001\rAG\u0001\tIAdWo\u001d\u0013fcR\u0011!iQ\u0007\u0002\u0001!)AH\u0002a\u00015\u0005IA%\\5okN$S-\u001d\u000b\u0003\u0005\u001aCQ\u0001P\u0004A\u0002iAC\u0001\u0001%L\u001bB\u00111#S\u0005\u0003\u00156\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005a\u0015\u0001\u00129s_bL\u0018N\\4!SN\u0004C-\u001a9sK\u000e\fG/\u001a3!IV,\u0007\u0005^8!Y\u0006\u001c7\u000eI8gAU\u001cX\rI1oI\u0002\u001aw.\u001c9jY\u0016\u0014X\u0006\\3wK2\u00043/\u001e9q_J$\u0018%\u0001(\u0002\rIr\u0013'\r\u00181\u0001")
public interface SetProxy<A>
extends scala.collection.mutable.Set<A>,
SetProxyLike<A, scala.collection.mutable.Set<A>> {
    public static /* synthetic */ SetProxy repr$(SetProxy $this) {
        return $this.repr();
    }

    @Override
    default public SetProxy<A> repr() {
        return this;
    }

    public static /* synthetic */ SetProxy empty$(SetProxy $this) {
        return $this.empty();
    }

    @Override
    default public SetProxy<A> empty() {
        return new SetProxy<A>(this){
            private final scala.collection.mutable.Set<A> self;

            public SetProxy<A> repr() {
                return SetProxy.repr$(this);
            }

            public SetProxy<A> empty() {
                return SetProxy.empty$(this);
            }

            public SetProxy<A> $plus(A elem) {
                return SetProxy.$plus$(this, elem);
            }

            public SetProxy<A> $minus(A elem) {
                return SetProxy.$minus$(this, elem);
            }

            public SetProxy<A> $plus$eq(A elem) {
                return SetProxy.$plus$eq$(this, elem);
            }

            public SetProxy<A> $minus$eq(A elem) {
                return SetProxy.$minus$eq$(this, elem);
            }

            public boolean contains(A elem) {
                return SetProxyLike.contains$(this, elem);
            }

            public boolean isEmpty() {
                return SetProxyLike.isEmpty$(this);
            }

            public boolean apply(A elem) {
                return SetProxyLike.apply$(this, elem);
            }

            public Set intersect(GenSet that) {
                return SetProxyLike.intersect$(this, that);
            }

            public Set $amp(GenSet that) {
                return SetProxyLike.$amp$(this, that);
            }

            public Set union(GenSet that) {
                return SetProxyLike.union$(this, that);
            }

            public Set $bar(GenSet that) {
                return SetProxyLike.$bar$(this, that);
            }

            public Set diff(GenSet that) {
                return SetProxyLike.diff$(this, that);
            }

            public Set $amp$tilde(GenSet that) {
                return SetProxyLike.$amp$tilde$(this, that);
            }

            public boolean subsetOf(GenSet<A> that) {
                return SetProxyLike.subsetOf$(this, that);
            }

            public Iterator<A> iterator() {
                return IterableProxyLike.iterator$(this);
            }

            public Iterator<scala.collection.mutable.Set<A>> grouped(int size) {
                return IterableProxyLike.grouped$(this, size);
            }

            public Iterator<scala.collection.mutable.Set<A>> sliding(int size) {
                return IterableProxyLike.sliding$(this, size);
            }

            public Iterator<scala.collection.mutable.Set<A>> sliding(int size, int step) {
                return IterableProxyLike.sliding$(this, size, step);
            }

            public Iterable takeRight(int n) {
                return IterableProxyLike.takeRight$(this, n);
            }

            public Iterable dropRight(int n) {
                return IterableProxyLike.dropRight$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<scala.collection.mutable.Set<A>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zip$(this, that, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<scala.collection.mutable.Set<A>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<scala.collection.mutable.Set<A>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableProxyLike.zipWithIndex$(this, bf);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableProxyLike.sameElements$(this, that);
            }

            public IterableView<A, scala.collection.mutable.Set<A>> view() {
                return IterableProxyLike.view$(this);
            }

            public IterableView<A, scala.collection.mutable.Set<A>> view(int from, int until) {
                return IterableProxyLike.view$(this, from, until);
            }

            public <U> void foreach(Function1<A, U> f) {
                TraversableProxyLike.foreach$(this, f);
            }

            public boolean nonEmpty() {
                return TraversableProxyLike.nonEmpty$(this);
            }

            public int size() {
                return TraversableProxyLike.size$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableProxyLike.hasDefiniteSize$(this);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.map$(this, f, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.flatMap$(this, f, bf);
            }

            public Traversable filter(Function1 p) {
                return TraversableProxyLike.filter$(this, p);
            }

            public Traversable filterNot(Function1 p) {
                return TraversableProxyLike.filterNot$(this, p);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.collect$(this, pf, bf);
            }

            public Tuple2<scala.collection.mutable.Set<A>, scala.collection.mutable.Set<A>> partition(Function1<A, Object> p) {
                return TraversableProxyLike.partition$(this, p);
            }

            public <K> Map<K, scala.collection.mutable.Set<A>> groupBy(Function1<A, K> f) {
                return TraversableProxyLike.groupBy$(this, f);
            }

            public boolean forall(Function1<A, Object> p) {
                return TraversableProxyLike.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return TraversableProxyLike.exists$(this, p);
            }

            public int count(Function1<A, Object> p) {
                return TraversableProxyLike.count$(this, p);
            }

            public Option<A> find(Function1<A, Object> p) {
                return TraversableProxyLike.find$(this, p);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)TraversableProxyLike.foldLeft$(this, z, op);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableProxyLike.$div$colon$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)TraversableProxyLike.foldRight$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableProxyLike.$colon$bslash$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)TraversableProxyLike.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableProxyLike.reduceLeftOption$(this, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)TraversableProxyLike.reduceRight$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
                return TraversableProxyLike.reduceRightOption$(this, op);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableProxyLike.scanRight$(this, z, op, bf);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableProxyLike.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableProxyLike.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableProxyLike.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableProxyLike.max$(this, cmp);
            }

            public A head() {
                return (A)TraversableProxyLike.head$(this);
            }

            public Option<A> headOption() {
                return TraversableProxyLike.headOption$(this);
            }

            public Traversable tail() {
                return TraversableProxyLike.tail$(this);
            }

            public A last() {
                return (A)TraversableProxyLike.last$(this);
            }

            public Option<A> lastOption() {
                return TraversableProxyLike.lastOption$(this);
            }

            public Traversable init() {
                return TraversableProxyLike.init$(this);
            }

            public Traversable take(int n) {
                return TraversableProxyLike.take$(this, n);
            }

            public Traversable drop(int n) {
                return TraversableProxyLike.drop$(this, n);
            }

            public Traversable slice(int from, int until) {
                return TraversableProxyLike.slice$(this, from, until);
            }

            public Traversable takeWhile(Function1 p) {
                return TraversableProxyLike.takeWhile$(this, p);
            }

            public Traversable dropWhile(Function1 p) {
                return TraversableProxyLike.dropWhile$(this, p);
            }

            public Tuple2<scala.collection.mutable.Set<A>, scala.collection.mutable.Set<A>> span(Function1<A, Object> p) {
                return TraversableProxyLike.span$(this, p);
            }

            public Tuple2<scala.collection.mutable.Set<A>, scala.collection.mutable.Set<A>> splitAt(int n) {
                return TraversableProxyLike.splitAt$(this, n);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableProxyLike.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                TraversableProxyLike.copyToArray$(this, xs, start, len);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableProxyLike.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableProxyLike.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableProxyLike.toArray$(this, evidence$1);
            }

            public List<A> toList() {
                return TraversableProxyLike.toList$(this);
            }

            public Iterable<A> toIterable() {
                return TraversableProxyLike.toIterable$(this);
            }

            public Seq<A> toSeq() {
                return TraversableProxyLike.toSeq$(this);
            }

            public IndexedSeq<A> toIndexedSeq() {
                return TraversableProxyLike.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableProxyLike.toBuffer$(this);
            }

            public Stream<A> toStream() {
                return TraversableProxyLike.toStream$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableProxyLike.toSet$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
                return TraversableProxyLike.toMap$(this, ev);
            }

            public Traversable<A> toTraversable() {
                return TraversableProxyLike.toTraversable$(this);
            }

            public Iterator<A> toIterator() {
                return TraversableProxyLike.toIterator$(this);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableProxyLike.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableProxyLike.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableProxyLike.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableProxyLike.addString$(this, b, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableProxyLike.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableProxyLike.addString$(this, b);
            }

            public String stringPrefix() {
                return TraversableProxyLike.stringPrefix$(this);
            }

            public int hashCode() {
                return Proxy.hashCode$(this);
            }

            public boolean equals(Object that) {
                return Proxy.equals$(this, that);
            }

            public String toString() {
                return Proxy.toString$(this);
            }

            public GenericCompanion<scala.collection.mutable.Set> companion() {
                return scala.collection.mutable.Set.companion$(this);
            }

            public scala.collection.mutable.Set<A> seq() {
                return scala.collection.mutable.Set.seq$(this);
            }

            public Builder<A, scala.collection.mutable.Set<A>> newBuilder() {
                return SetLike.newBuilder$(this);
            }

            public Combiner<A, ParSet<A>> parCombiner() {
                return SetLike.parCombiner$(this);
            }

            public boolean add(A elem) {
                return SetLike.add$(this, elem);
            }

            public boolean remove(A elem) {
                return SetLike.remove$(this, elem);
            }

            public void update(A elem, boolean included) {
                SetLike.update$(this, elem, included);
            }

            public void retain(Function1<A, Object> p) {
                SetLike.retain$(this, p);
            }

            public void clear() {
                SetLike.clear$(this);
            }

            public scala.collection.mutable.Set<A> clone() {
                return SetLike.clone$(this);
            }

            public scala.collection.mutable.Set<A> result() {
                return SetLike.result$(this);
            }

            public scala.collection.mutable.Set<A> $plus(A elem1, A elem2, Seq<A> elems) {
                return SetLike.$plus$(this, elem1, elem2, elems);
            }

            public scala.collection.mutable.Set<A> $plus$plus(GenTraversableOnce<A> xs) {
                return SetLike.$plus$plus$(this, xs);
            }

            public scala.collection.mutable.Set<A> $minus(A elem1, A elem2, Seq<A> elems) {
                return SetLike.$minus$(this, elem1, elem2, elems);
            }

            public scala.collection.mutable.Set<A> $minus$minus(GenTraversableOnce<A> xs) {
                return SetLike.$minus$minus$(this, xs);
            }

            public void $less$less(Message<A> cmd) {
                SetLike.$less$less$(this, cmd);
            }

            public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
                return super.clone();
            }

            public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
                return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
            }

            public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
                return Shrinkable.$minus$minus$eq$(this, xs);
            }

            public void sizeHint(int size) {
                Builder.sizeHint$((Builder)this, size);
            }

            public void sizeHint(TraversableLike<?, ?> coll) {
                Builder.sizeHint$((Builder)this, coll);
            }

            public void sizeHint(TraversableLike<?, ?> coll, int delta) {
                Builder.sizeHint$(this, coll, delta);
            }

            public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
                Builder.sizeHintBounded$(this, size, boundingColl);
            }

            public <NewTo> Builder<A, NewTo> mapResult(Function1<scala.collection.mutable.Set<A>, NewTo> f) {
                return Builder.mapResult$(this, f);
            }

            public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
                return Growable.$plus$plus$eq$(this, xs);
            }

            public /* synthetic */ Object scala$collection$SetLike$$super$map(Function1 f, CanBuildFrom bf) {
                return TraversableLike.map$(this, f, bf);
            }

            public Iterator<scala.collection.mutable.Set<A>> subsets(int len) {
                return scala.collection.SetLike.subsets$(this, len);
            }

            public Iterator<scala.collection.mutable.Set<A>> subsets() {
                return scala.collection.SetLike.subsets$(this);
            }

            public boolean apply$mcZD$sp(double v1) {
                return Function1.apply$mcZD$sp$(this, v1);
            }

            public double apply$mcDD$sp(double v1) {
                return Function1.apply$mcDD$sp$(this, v1);
            }

            public float apply$mcFD$sp(double v1) {
                return Function1.apply$mcFD$sp$(this, v1);
            }

            public int apply$mcID$sp(double v1) {
                return Function1.apply$mcID$sp$(this, v1);
            }

            public long apply$mcJD$sp(double v1) {
                return Function1.apply$mcJD$sp$(this, v1);
            }

            public void apply$mcVD$sp(double v1) {
                Function1.apply$mcVD$sp$(this, v1);
            }

            public boolean apply$mcZF$sp(float v1) {
                return Function1.apply$mcZF$sp$(this, v1);
            }

            public double apply$mcDF$sp(float v1) {
                return Function1.apply$mcDF$sp$(this, v1);
            }

            public float apply$mcFF$sp(float v1) {
                return Function1.apply$mcFF$sp$(this, v1);
            }

            public int apply$mcIF$sp(float v1) {
                return Function1.apply$mcIF$sp$(this, v1);
            }

            public long apply$mcJF$sp(float v1) {
                return Function1.apply$mcJF$sp$(this, v1);
            }

            public void apply$mcVF$sp(float v1) {
                Function1.apply$mcVF$sp$(this, v1);
            }

            public boolean apply$mcZI$sp(int v1) {
                return Function1.apply$mcZI$sp$(this, v1);
            }

            public double apply$mcDI$sp(int v1) {
                return Function1.apply$mcDI$sp$(this, v1);
            }

            public float apply$mcFI$sp(int v1) {
                return Function1.apply$mcFI$sp$(this, v1);
            }

            public int apply$mcII$sp(int v1) {
                return Function1.apply$mcII$sp$(this, v1);
            }

            public long apply$mcJI$sp(int v1) {
                return Function1.apply$mcJI$sp$(this, v1);
            }

            public void apply$mcVI$sp(int v1) {
                Function1.apply$mcVI$sp$(this, v1);
            }

            public boolean apply$mcZJ$sp(long v1) {
                return Function1.apply$mcZJ$sp$(this, v1);
            }

            public double apply$mcDJ$sp(long v1) {
                return Function1.apply$mcDJ$sp$(this, v1);
            }

            public float apply$mcFJ$sp(long v1) {
                return Function1.apply$mcFJ$sp$(this, v1);
            }

            public int apply$mcIJ$sp(long v1) {
                return Function1.apply$mcIJ$sp$(this, v1);
            }

            public long apply$mcJJ$sp(long v1) {
                return Function1.apply$mcJJ$sp$(this, v1);
            }

            public void apply$mcVJ$sp(long v1) {
                Function1.apply$mcVJ$sp$(this, v1);
            }

            public <A> Function1<A, Object> compose(Function1<A, A> g) {
                return Function1.compose$(this, g);
            }

            public <A> Function1<A, A> andThen(Function1<Object, A> g) {
                return Function1.andThen$(this, g);
            }

            public Iterable<A> thisCollection() {
                return IterableLike.thisCollection$(this);
            }

            public Iterable toCollection(Object repr) {
                return IterableLike.toCollection$(this, repr);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public <B> Builder<B, scala.collection.mutable.Set<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public <A1, A2> Tuple2<scala.collection.mutable.Set<A1>, scala.collection.mutable.Set<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<scala.collection.mutable.Set<A1>, scala.collection.mutable.Set<A2>, scala.collection.mutable.Set<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
                return GenericTraversableTemplate.unzip3$(this, asTriple);
            }

            public GenTraversable flatten(Function1 asTraversable) {
                return GenericTraversableTemplate.flatten$(this, asTraversable);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Iterator<scala.collection.mutable.Set<A>> tails() {
                return TraversableLike.tails$(this);
            }

            public Iterator<scala.collection.mutable.Set<A>> inits() {
                return TraversableLike.inits$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public FilterMonadic<A, scala.collection.mutable.Set<A>> withFilter(Function1<A, Object> p) {
                return TraversableLike.withFilter$(this, p);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
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

            public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public scala.collection.mutable.Set<A> self() {
                return this.self;
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Parallelizable.$init$(this);
                TraversableLike.$init$(this);
                GenericTraversableTemplate.$init$(this);
                GenTraversable.$init$(this);
                Traversable.$init$(this);
                scala.collection.mutable.Traversable.$init$(this);
                GenIterable.$init$(this);
                IterableLike.$init$(this);
                Iterable.$init$(this);
                scala.collection.mutable.Iterable.$init$(this);
                GenSetLike.$init$(this);
                GenericSetTemplate.$init$(this);
                GenSet.$init$(this);
                Subtractable.$init$(this);
                scala.collection.SetLike.$init$(this);
                Set.$init$(this);
                Growable.$init$(this);
                Builder.$init$(this);
                Shrinkable.$init$(this);
                Cloneable.$init$(this);
                SetLike.$init$(this);
                scala.collection.mutable.Set.$init$(this);
                Proxy.$init$(this);
                TraversableProxyLike.$init$(this);
                IterableProxyLike.$init$(this);
                SetProxyLike.$init$(this);
                SetProxy.$init$(this);
                this.self = (scala.collection.mutable.Set)((GenericSetTemplate)$outer.self()).empty();
            }
        };
    }

    public static /* synthetic */ SetProxy $plus$(SetProxy $this, Object elem) {
        return $this.$plus(elem);
    }

    @Override
    default public SetProxy<A> $plus(A elem) {
        ((SetLike)this.self()).$plus$eq(elem);
        return this;
    }

    public static /* synthetic */ SetProxy $minus$(SetProxy $this, Object elem) {
        return $this.$minus(elem);
    }

    @Override
    default public SetProxy<A> $minus(A elem) {
        ((SetLike)this.self()).$minus$eq(elem);
        return this;
    }

    public static /* synthetic */ SetProxy $plus$eq$(SetProxy $this, Object elem) {
        return $this.$plus$eq((A)elem);
    }

    @Override
    default public SetProxy<A> $plus$eq(A elem) {
        ((SetLike)this.self()).$plus$eq(elem);
        return this;
    }

    public static /* synthetic */ SetProxy $minus$eq$(SetProxy $this, Object elem) {
        return $this.$minus$eq(elem);
    }

    @Override
    default public SetProxy<A> $minus$eq(A elem) {
        ((SetLike)this.self()).$minus$eq(elem);
        return this;
    }

    public static void $init$(SetProxy $this) {
    }
}

