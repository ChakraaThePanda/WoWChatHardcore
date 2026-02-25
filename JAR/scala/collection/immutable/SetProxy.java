/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Proxy;
import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenSet;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableProxyLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.SetLike;
import scala.collection.SetProxyLike;
import scala.collection.TraversableProxyLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSet;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001-3qa\u0002\u0005\u0011\u0002\u0007\u0005q\u0002C\u0003)\u0001\u0011\u0005\u0011\u0006C\u0003.\u0001\u0011\u0005c\u0006C\u00031\u0001\u0011%\u0011\u0007C\u0003<\u0001\u0011\u0005c\u0006C\u0003=\u0001\u0011\u0005S\bC\u0003A\u0001\u0011\u0005\u0013I\u0001\u0005TKR\u0004&o\u001c=z\u0015\tI!\"A\u0005j[6,H/\u00192mK*\u00111\u0002D\u0001\u000bG>dG.Z2uS>t'\"A\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0001cG\n\u0005\u0001E)B\u0005\u0005\u0002\u0013'5\tA\"\u0003\u0002\u0015\u0019\t1\u0011I\\=SK\u001a\u00042AF\f\u001a\u001b\u0005A\u0011B\u0001\r\t\u0005\r\u0019V\r\u001e\t\u00035ma\u0001\u0001B\u0003\u001d\u0001\t\u0007QDA\u0001B#\tq\u0012\u0005\u0005\u0002\u0013?%\u0011\u0001\u0005\u0004\u0002\b\u001d>$\b.\u001b8h!\t\u0011\"%\u0003\u0002$\u0019\t\u0019\u0011I\\=\u0011\t\u00152\u0013$F\u0007\u0002\u0015%\u0011qE\u0003\u0002\r'\u0016$\bK]8ys2K7.Z\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003)\u0002\"AE\u0016\n\u00051b!\u0001B+oSR\fAA]3qeV\tq\u0006E\u0002\u0017\u0001e\t\u0001B\\3x!J|\u00070_\u000b\u0003eU\"\"a\r\u001d\u0011\u0007Y\u0001A\u0007\u0005\u0002\u001bk\u0011)ag\u0001b\u0001o\t\t!)\u0005\u0002\u001aC!)\u0011h\u0001a\u0001u\u00059a.Z<TK24\u0007c\u0001\f\u0018i\u0005)Q-\u001c9us\u0006)A\u0005\u001d7vgR\u0011qF\u0010\u0005\u0006\u007f\u0015\u0001\r!G\u0001\u0005K2,W.\u0001\u0004%[&tWo\u001d\u000b\u0003_\tCQa\u0010\u0004A\u0002eAC\u0001\u0001#H\u0013B\u0011!#R\u0005\u0003\r2\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005A\u0015!\u00129s_bL\u0018N\\4!SN\u0004C-\u001a9sK\u000e\fG/\u001a3!IV,\u0007\u0005^8!Y\u0006\u001c7\u000eI8gAU\u001cX\rI1oI\u0002\u001aw.\u001c9jY\u0016\u0014X\u0006\\3wK2\u00043/\u001e9q_J$h&I\u0001K\u0003\u0019\u0011d&M\u0019/a\u0001")
public interface SetProxy<A>
extends scala.collection.immutable.Set<A>,
SetProxyLike<A, scala.collection.immutable.Set<A>> {
    public static /* synthetic */ SetProxy repr$(SetProxy $this) {
        return $this.repr();
    }

    @Override
    default public SetProxy<A> repr() {
        return this;
    }

    private <B> SetProxy<B> newProxy(scala.collection.immutable.Set<B> newSelf) {
        return new SetProxy<B>(null, newSelf){
            private final scala.collection.immutable.Set<B> self;

            public SetProxy<B> repr() {
                return SetProxy.repr$(this);
            }

            public SetProxy<B> empty() {
                return SetProxy.empty$(this);
            }

            public SetProxy<B> $plus(B elem) {
                return SetProxy.$plus$(this, elem);
            }

            public SetProxy<B> $minus(B elem) {
                return SetProxy.$minus$(this, elem);
            }

            public boolean contains(B elem) {
                return SetProxyLike.contains$(this, elem);
            }

            public boolean isEmpty() {
                return SetProxyLike.isEmpty$(this);
            }

            public boolean apply(B elem) {
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

            public boolean subsetOf(GenSet<B> that) {
                return SetProxyLike.subsetOf$(this, that);
            }

            public Iterator<B> iterator() {
                return IterableProxyLike.iterator$(this);
            }

            public Iterator<scala.collection.immutable.Set<B>> grouped(int size) {
                return IterableProxyLike.grouped$(this, size);
            }

            public Iterator<scala.collection.immutable.Set<B>> sliding(int size) {
                return IterableProxyLike.sliding$(this, size);
            }

            public Iterator<scala.collection.immutable.Set<B>> sliding(int size, int step) {
                return IterableProxyLike.sliding$(this, size, step);
            }

            public Iterable takeRight(int n) {
                return IterableProxyLike.takeRight$(this, n);
            }

            public Iterable dropRight(int n) {
                return IterableProxyLike.dropRight$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<scala.collection.immutable.Set<B>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zip$(this, that, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<scala.collection.immutable.Set<B>, Tuple2<A1, B>, That> bf) {
                return (That)IterableProxyLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<scala.collection.immutable.Set<B>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableProxyLike.zipWithIndex$(this, bf);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableProxyLike.sameElements$(this, that);
            }

            public IterableView<B, scala.collection.immutable.Set<B>> view() {
                return IterableProxyLike.view$(this);
            }

            public IterableView<B, scala.collection.immutable.Set<B>> view(int from, int until) {
                return IterableProxyLike.view$(this, from, until);
            }

            public <U> void foreach(Function1<B, U> f) {
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

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<scala.collection.immutable.Set<B>, B, That> bf) {
                return (That)TraversableProxyLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That map(Function1<B, B> f, CanBuildFrom<scala.collection.immutable.Set<B>, B, That> bf) {
                return (That)TraversableProxyLike.map$(this, f, bf);
            }

            public <B, That> That flatMap(Function1<B, GenTraversableOnce<B>> f, CanBuildFrom<scala.collection.immutable.Set<B>, B, That> bf) {
                return (That)TraversableProxyLike.flatMap$(this, f, bf);
            }

            public scala.collection.Traversable filter(Function1 p) {
                return TraversableProxyLike.filter$(this, p);
            }

            public scala.collection.Traversable filterNot(Function1 p) {
                return TraversableProxyLike.filterNot$(this, p);
            }

            public <B, That> That collect(PartialFunction<B, B> pf, CanBuildFrom<scala.collection.immutable.Set<B>, B, That> bf) {
                return (That)TraversableProxyLike.collect$(this, pf, bf);
            }

            public Tuple2<scala.collection.immutable.Set<B>, scala.collection.immutable.Set<B>> partition(Function1<B, Object> p) {
                return TraversableProxyLike.partition$(this, p);
            }

            public <K> Map<K, scala.collection.immutable.Set<B>> groupBy(Function1<B, K> f) {
                return TraversableProxyLike.groupBy$(this, f);
            }

            public boolean forall(Function1<B, Object> p) {
                return TraversableProxyLike.forall$(this, p);
            }

            public boolean exists(Function1<B, Object> p) {
                return TraversableProxyLike.exists$(this, p);
            }

            public int count(Function1<B, Object> p) {
                return TraversableProxyLike.count$(this, p);
            }

            public Option<B> find(Function1<B, Object> p) {
                return TraversableProxyLike.find$(this, p);
            }

            public <B> B foldLeft(B z, Function2<B, B, B> op) {
                return (B)TraversableProxyLike.foldLeft$(this, z, op);
            }

            public <B> B $div$colon(B z, Function2<B, B, B> op) {
                return (B)TraversableProxyLike.$div$colon$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<B, B, B> op) {
                return (B)TraversableProxyLike.foldRight$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<B, B, B> op) {
                return (B)TraversableProxyLike.$colon$bslash$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, B, B> op) {
                return (B)TraversableProxyLike.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, B, B> op) {
                return TraversableProxyLike.reduceLeftOption$(this, op);
            }

            public <B> B reduceRight(Function2<B, B, B> op) {
                return (B)TraversableProxyLike.reduceRight$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<B, B, B> op) {
                return TraversableProxyLike.reduceRightOption$(this, op);
            }

            public <B, That> That scanLeft(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.immutable.Set<B>, B, That> bf) {
                return (That)TraversableProxyLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.immutable.Set<B>, B, That> bf) {
                return (That)TraversableProxyLike.scanRight$(this, z, op, bf);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableProxyLike.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableProxyLike.product$(this, num);
            }

            public <B> B min(Ordering<B> cmp) {
                return (B)TraversableProxyLike.min$(this, cmp);
            }

            public <B> B max(Ordering<B> cmp) {
                return (B)TraversableProxyLike.max$(this, cmp);
            }

            public B head() {
                return (B)TraversableProxyLike.head$(this);
            }

            public Option<B> headOption() {
                return TraversableProxyLike.headOption$(this);
            }

            public scala.collection.Traversable tail() {
                return TraversableProxyLike.tail$(this);
            }

            public B last() {
                return (B)TraversableProxyLike.last$(this);
            }

            public Option<B> lastOption() {
                return TraversableProxyLike.lastOption$(this);
            }

            public scala.collection.Traversable init() {
                return TraversableProxyLike.init$(this);
            }

            public scala.collection.Traversable take(int n) {
                return TraversableProxyLike.take$(this, n);
            }

            public scala.collection.Traversable drop(int n) {
                return TraversableProxyLike.drop$(this, n);
            }

            public scala.collection.Traversable slice(int from, int until) {
                return TraversableProxyLike.slice$(this, from, until);
            }

            public scala.collection.Traversable takeWhile(Function1 p) {
                return TraversableProxyLike.takeWhile$(this, p);
            }

            public scala.collection.Traversable dropWhile(Function1 p) {
                return TraversableProxyLike.dropWhile$(this, p);
            }

            public Tuple2<scala.collection.immutable.Set<B>, scala.collection.immutable.Set<B>> span(Function1<B, Object> p) {
                return TraversableProxyLike.span$(this, p);
            }

            public Tuple2<scala.collection.immutable.Set<B>, scala.collection.immutable.Set<B>> splitAt(int n) {
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

            public List<B> toList() {
                return TraversableProxyLike.toList$(this);
            }

            public Iterable<B> toIterable() {
                return TraversableProxyLike.toIterable$(this);
            }

            public Seq<B> toSeq() {
                return TraversableProxyLike.toSeq$(this);
            }

            public IndexedSeq<B> toIndexedSeq() {
                return TraversableProxyLike.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableProxyLike.toBuffer$(this);
            }

            public Stream<B> toStream() {
                return TraversableProxyLike.toStream$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableProxyLike.toSet$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<B, Tuple2<T, U>> ev) {
                return TraversableProxyLike.toMap$(this, ev);
            }

            public scala.collection.Traversable<B> toTraversable() {
                return TraversableProxyLike.toTraversable$(this);
            }

            public Iterator<B> toIterator() {
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

            public GenericCompanion<scala.collection.immutable.Set> companion() {
                return scala.collection.immutable.Set.companion$(this);
            }

            public scala.collection.immutable.Set<B> seq() {
                return scala.collection.immutable.Set.seq$(this);
            }

            public Combiner<B, ParSet<B>> parCombiner() {
                return scala.collection.immutable.Set.parCombiner$(this);
            }

            public scala.collection.immutable.Set<B> self() {
                return this.self;
            }
            {
                Traversable.$init$(this);
                scala.collection.immutable.Iterable.$init$(this);
                scala.collection.immutable.Set.$init$(this);
                Proxy.$init$(this);
                TraversableProxyLike.$init$(this);
                IterableProxyLike.$init$(this);
                SetProxyLike.$init$(this);
                SetProxy.$init$(this);
                this.self = newSelf$1;
            }
        };
    }

    public static /* synthetic */ SetProxy empty$(SetProxy $this) {
        return $this.empty();
    }

    @Override
    default public SetProxy<A> empty() {
        return this.newProxy((scala.collection.immutable.Set)((GenericSetTemplate)this.self()).empty());
    }

    public static /* synthetic */ SetProxy $plus$(SetProxy $this, Object elem) {
        return $this.$plus(elem);
    }

    @Override
    default public SetProxy<A> $plus(A elem) {
        return this.newProxy((scala.collection.immutable.Set)((SetLike)this.self()).$plus(elem));
    }

    public static /* synthetic */ SetProxy $minus$(SetProxy $this, Object elem) {
        return $this.$minus(elem);
    }

    @Override
    default public SetProxy<A> $minus(A elem) {
        return this.newProxy((scala.collection.immutable.Set)((SetLike)this.self()).$minus(elem));
    }

    public static void $init$(SetProxy $this) {
    }
}

