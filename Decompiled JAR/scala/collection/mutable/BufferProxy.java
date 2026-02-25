/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
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
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.BufferLike;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.SeqLike;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSeq;
import scala.collection.script.Message;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005ca\u0002\f\u0018!\u0003\r\tA\b\u0005\u0006m\u0001!\ta\u000e\u0005\u0006w\u00011\t\u0001\u0010\u0005\u0006{\u0001!\tA\u0010\u0005\u0006\u0005\u0002!\te\u0011\u0005\u0006\u0011\u0002!\t!\u0013\u0005\u0006\u0019\u0002!\t!\u0014\u0005\u0006#\u0002!\tE\u0015\u0005\u00061\u0002!\t%\u0017\u0005\u0006?\u0002!\t\u0005\u0019\u0005\u0006E\u0002!\ta\u0019\u0005\u0006K\u0002!\tE\u001a\u0005\u0006Q\u0002!\t%\u001b\u0005\u0006W\u0002!\t\u0005\u001c\u0005\u0006]\u0002!\te\u001c\u0005\u0006e\u0002!\ta\u001d\u0005\u0006e\u0002!\tE\u001f\u0005\b\u0003\u0003\u0001A\u0011AA\u0002\u0011\u001d\tY\u0001\u0001C\u0001\u0003\u001bAa!!\u0005\u0001\t\u00039\u0004bBA\n\u0001\u0011\u0005\u0013Q\u0003\u0005\b\u0003o\u0001A\u0011IA\u001d\u0005-\u0011UO\u001a4feB\u0013x\u000e_=\u000b\u0005aI\u0012aB7vi\u0006\u0014G.\u001a\u0006\u00035m\t!bY8mY\u0016\u001cG/[8o\u0015\u0005a\u0012!B:dC2\f7\u0001A\u000b\u0003?)\u001aB\u0001\u0001\u0011%gA\u0011\u0011EI\u0007\u00027%\u00111e\u0007\u0002\u0007\u0003:L(+\u001a4\u0011\u0007\u00152\u0003&D\u0001\u0018\u0013\t9sC\u0001\u0004Ck\u001a4WM\u001d\t\u0003S)b\u0001\u0001B\u0003,\u0001\t\u0007AFA\u0001B#\ti\u0003\u0007\u0005\u0002\"]%\u0011qf\u0007\u0002\b\u001d>$\b.\u001b8h!\t\t\u0013'\u0003\u000237\t\u0019\u0011I\\=\u0011\u0005\u0005\"\u0014BA\u001b\u001c\u0005\u0015\u0001&o\u001c=z\u0003\u0019!\u0013N\\5uIQ\t\u0001\b\u0005\u0002\"s%\u0011!h\u0007\u0002\u0005+:LG/\u0001\u0003tK24W#\u0001\u0013\u0002\r1,gn\u001a;i+\u0005y\u0004CA\u0011A\u0013\t\t5DA\u0002J]R\f\u0001\"\u001b;fe\u0006$xN]\u000b\u0002\tB\u0019QI\u0012\u0015\u000e\u0003eI!aR\r\u0003\u0011%#XM]1u_J\fQ!\u00199qYf$\"\u0001\u000b&\t\u000b-+\u0001\u0019A \u0002\u00039\f\u0001\u0002\n9mkN$S-\u001d\u000b\u0003\u001d>k\u0011\u0001\u0001\u0005\u0006!\u001a\u0001\r\u0001K\u0001\u0005K2,W.A\u0007%a2,8\u000f\n9mkN$S-\u001d\u000b\u0003\u001dNCQ\u0001V\u0004A\u0002U\u000b!\u0001_:\u0011\u0007\u00153\u0006&\u0003\u0002X3\tyAK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-\u0001\u0004baB,g\u000e\u001a\u000b\u0003qiCQa\u0017\u0005A\u0002q\u000bQ!\u001a7f[N\u00042!I/)\u0013\tq6D\u0001\u0006=e\u0016\u0004X-\u0019;fIz\n\u0011\"\u00199qK:$\u0017\t\u001c7\u0015\u0005a\n\u0007\"\u0002+\n\u0001\u0004)\u0016A\u0004\u0013qYV\u001cH%Z9%G>dwN\u001c\u000b\u0003\u001d\u0012DQ\u0001\u0015\u0006A\u0002!\n1\u0003\n9mkN$\u0003\u000f\\;tI\u0015\fHeY8m_:$\"AT4\t\u000bQ[\u0001\u0019A+\u0002\u000fA\u0014X\r]3oIR\u0011\u0001H\u001b\u0005\u000672\u0001\r\u0001X\u0001\u000baJ,\u0007/\u001a8e\u00032dGC\u0001\u001dn\u0011\u0015!V\u00021\u0001V\u0003\u0019Ign]3siR\u0019\u0001\b]9\t\u000b-s\u0001\u0019A \t\u000bms\u0001\u0019\u0001/\u0002\u0013%t7/\u001a:u\u00032dGc\u0001\u001duk\")1j\u0004a\u0001\u007f!)ao\u0004a\u0001o\u0006!\u0011\u000e^3s!\r)\u0005\u0010K\u0005\u0003sf\u0011\u0001\"\u0013;fe\u0006\u0014G.\u001a\u000b\u0004qmd\b\"B&\u0011\u0001\u0004y\u0004\"\u0002<\u0011\u0001\u0004i\bcA#\u007fQ%\u0011q0\u0007\u0002\f)J\fg/\u001a:tC\ndW-\u0001\u0004va\u0012\fG/\u001a\u000b\u0006q\u0005\u0015\u0011q\u0001\u0005\u0006\u0017F\u0001\ra\u0010\u0005\u0007\u0003\u0013\t\u0002\u0019\u0001\u0015\u0002\u000f9,w/\u001a7f[\u00061!/Z7pm\u0016$2\u0001KA\b\u0011\u0015Y%\u00031\u0001@\u0003\u0015\u0019G.Z1s\u0003)!C.Z:tI1,7o\u001d\u000b\u0004q\u0005]\u0001bBA\r)\u0001\u0007\u00111D\u0001\u0004G6$\u0007#BA\u000f\u0003GASBAA\u0010\u0015\r\t\t#G\u0001\u0007g\u000e\u0014\u0018\u000e\u001d;\n\t\u0005\u0015\u0012q\u0004\u0002\b\u001b\u0016\u001c8/Y4fQ\u001d!\u0012\u0011FA\u0018\u0003g\u00012!IA\u0016\u0013\r\tic\u0007\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017EAA\u0019\u0003]\u00198M]5qi&tw\rI5tA\u0011,\u0007O]3dCR,G-\t\u0002\u00026\u00051!GL\u00192]A\nQa\u00197p]\u0016$\u0012\u0001\n\u0015\b\u0001\u0005%\u0012QHA\u001aC\t\ty$\u0001#qe>D\u00180\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eA\u0011,X\r\t;pA1\f7m\u001b\u0011pM\u0002*8/\u001a\u0011b]\u0012\u00043m\\7qS2,'/\f7fm\u0016d\u0007e];qa>\u0014H\u000f")
public interface BufferProxy<A>
extends Buffer<A>,
Proxy {
    @Override
    public Buffer<A> self();

    public static /* synthetic */ int length$(BufferProxy $this) {
        return $this.length();
    }

    @Override
    default public int length() {
        return this.self().length();
    }

    public static /* synthetic */ Iterator iterator$(BufferProxy $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<A> iterator() {
        return this.self().iterator();
    }

    public static /* synthetic */ Object apply$(BufferProxy $this, int n) {
        return $this.apply(n);
    }

    @Override
    default public A apply(int n) {
        return (A)this.self().apply(n);
    }

    public static /* synthetic */ BufferProxy $plus$eq$(BufferProxy $this, Object elem) {
        return $this.$plus$eq(elem);
    }

    @Override
    default public BufferProxy<A> $plus$eq(A elem) {
        this.self().$plus$eq(elem);
        return this;
    }

    public static /* synthetic */ BufferProxy $plus$plus$eq$(BufferProxy $this, TraversableOnce xs) {
        return $this.$plus$plus$eq(xs);
    }

    @Override
    default public BufferProxy<A> $plus$plus$eq(TraversableOnce<A> xs) {
        this.self().$plus$plus$eq(xs);
        return this;
    }

    public static /* synthetic */ void append$(BufferProxy $this, Seq elems) {
        $this.append(elems);
    }

    @Override
    default public void append(Seq<A> elems) {
        this.self().$plus$plus$eq(elems);
    }

    public static /* synthetic */ void appendAll$(BufferProxy $this, TraversableOnce xs) {
        $this.appendAll(xs);
    }

    @Override
    default public void appendAll(TraversableOnce<A> xs) {
        this.self().appendAll(xs);
    }

    public static /* synthetic */ BufferProxy $plus$eq$colon$(BufferProxy $this, Object elem) {
        return $this.$plus$eq$colon(elem);
    }

    @Override
    default public BufferProxy<A> $plus$eq$colon(A elem) {
        this.self().$plus$eq$colon(elem);
        return this;
    }

    public static /* synthetic */ BufferProxy $plus$plus$eq$colon$(BufferProxy $this, TraversableOnce xs) {
        return $this.$plus$plus$eq$colon(xs);
    }

    @Override
    default public BufferProxy<A> $plus$plus$eq$colon(TraversableOnce<A> xs) {
        this.self().$plus$plus$eq$colon(xs);
        return this;
    }

    public static /* synthetic */ void prepend$(BufferProxy $this, Seq elems) {
        $this.prepend(elems);
    }

    @Override
    default public void prepend(Seq<A> elems) {
        this.self().prependAll(elems);
    }

    public static /* synthetic */ void prependAll$(BufferProxy $this, TraversableOnce xs) {
        $this.prependAll(xs);
    }

    @Override
    default public void prependAll(TraversableOnce<A> xs) {
        this.self().prependAll(xs);
    }

    public static /* synthetic */ void insert$(BufferProxy $this, int n, Seq elems) {
        $this.insert(n, elems);
    }

    @Override
    default public void insert(int n, Seq<A> elems) {
        this.self().insertAll(n, elems);
    }

    public static /* synthetic */ void insertAll$(BufferProxy $this, int n, Iterable iter) {
        $this.insertAll(n, iter);
    }

    @Override
    default public void insertAll(int n, Iterable<A> iter) {
        this.self().insertAll(n, iter);
    }

    public static /* synthetic */ void insertAll$(BufferProxy $this, int n, Traversable iter) {
        $this.insertAll(n, iter);
    }

    @Override
    default public void insertAll(int n, Traversable<A> iter) {
        this.self().insertAll(n, iter);
    }

    public static /* synthetic */ void update$(BufferProxy $this, int n, Object newelem) {
        $this.update(n, newelem);
    }

    @Override
    default public void update(int n, A newelem) {
        this.self().update(n, newelem);
    }

    public static /* synthetic */ Object remove$(BufferProxy $this, int n) {
        return $this.remove(n);
    }

    @Override
    default public A remove(int n) {
        return this.self().remove(n);
    }

    public static /* synthetic */ void clear$(BufferProxy $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        this.self().clear();
    }

    public static /* synthetic */ void $less$less$(BufferProxy $this, Message cmd) {
        $this.$less$less(cmd);
    }

    @Override
    default public void $less$less(Message<A> cmd) {
        this.self().$less$less(cmd);
    }

    public static /* synthetic */ Buffer clone$(BufferProxy $this) {
        return $this.clone();
    }

    @Override
    default public Buffer<A> clone() {
        return new BufferProxy<A>(this){
            private final /* synthetic */ BufferProxy $outer;

            public int length() {
                return BufferProxy.length$(this);
            }

            public Iterator<A> iterator() {
                return BufferProxy.iterator$(this);
            }

            public A apply(int n) {
                return (A)BufferProxy.apply$(this, n);
            }

            public BufferProxy<A> $plus$eq(A elem) {
                return BufferProxy.$plus$eq$(this, elem);
            }

            public BufferProxy<A> $plus$plus$eq(TraversableOnce<A> xs) {
                return BufferProxy.$plus$plus$eq$(this, xs);
            }

            public void append(Seq<A> elems) {
                BufferProxy.append$(this, elems);
            }

            public void appendAll(TraversableOnce<A> xs) {
                BufferProxy.appendAll$(this, xs);
            }

            public BufferProxy<A> $plus$eq$colon(A elem) {
                return BufferProxy.$plus$eq$colon$(this, elem);
            }

            public BufferProxy<A> $plus$plus$eq$colon(TraversableOnce<A> xs) {
                return BufferProxy.$plus$plus$eq$colon$(this, xs);
            }

            public void prepend(Seq<A> elems) {
                BufferProxy.prepend$(this, elems);
            }

            public void prependAll(TraversableOnce<A> xs) {
                BufferProxy.prependAll$(this, xs);
            }

            public void insert(int n, Seq<A> elems) {
                BufferProxy.insert$(this, n, elems);
            }

            public void insertAll(int n, Iterable<A> iter) {
                BufferProxy.insertAll$((BufferProxy)this, n, iter);
            }

            public void insertAll(int n, Traversable<A> iter) {
                BufferProxy.insertAll$((BufferProxy)this, n, iter);
            }

            public void update(int n, A newelem) {
                BufferProxy.update$(this, n, newelem);
            }

            public A remove(int n) {
                return (A)BufferProxy.remove$(this, n);
            }

            public void clear() {
                BufferProxy.clear$(this);
            }

            public void $less$less(Message<A> cmd) {
                BufferProxy.$less$less$(this, cmd);
            }

            public Buffer<A> clone() {
                return BufferProxy.clone$(this);
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

            public GenericCompanion<Buffer> companion() {
                return Buffer.companion$(this);
            }

            public void remove(int n, int count) {
                BufferLike.remove$(this, n, count);
            }

            public Buffer $minus$eq(Object x) {
                return BufferLike.$minus$eq$(this, x);
            }

            public void trimStart(int n) {
                BufferLike.trimStart$(this, n);
            }

            public void trimEnd(int n) {
                BufferLike.trimEnd$(this, n);
            }

            public String stringPrefix() {
                return BufferLike.stringPrefix$(this);
            }

            public Buffer<A> $plus$plus(GenTraversableOnce<A> xs) {
                return BufferLike.$plus$plus$(this, xs);
            }

            public Buffer<A> $minus(A elem) {
                return BufferLike.$minus$(this, elem);
            }

            public Buffer<A> $minus(A elem1, A elem2, Seq<A> elems) {
                return BufferLike.$minus$(this, elem1, elem2, elems);
            }

            public Buffer<A> $minus$minus(GenTraversableOnce<A> xs) {
                return BufferLike.$minus$minus$(this, xs);
            }

            public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
                return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
            }

            public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
                return Shrinkable.$minus$minus$eq$(this, xs);
            }

            public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
                return Growable.$plus$eq$(this, elem1, elem2, elems);
            }

            public scala.collection.mutable.Seq<A> seq() {
                return scala.collection.mutable.Seq.seq$(this);
            }

            public Combiner<A, ParSeq<A>> parCombiner() {
                return SeqLike.parCombiner$(this);
            }

            public SeqLike<A, Buffer<A>> transform(Function1<A, A> f) {
                return SeqLike.transform$(this, f);
            }

            public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
                return super.clone();
            }

            public Seq<A> thisCollection() {
                return scala.collection.SeqLike.thisCollection$(this);
            }

            public Seq toCollection(Object repr) {
                return scala.collection.SeqLike.toCollection$(this, repr);
            }

            public int lengthCompare(int len) {
                return scala.collection.SeqLike.lengthCompare$(this, len);
            }

            public boolean isEmpty() {
                return scala.collection.SeqLike.isEmpty$(this);
            }

            public int size() {
                return scala.collection.SeqLike.size$(this);
            }

            public int segmentLength(Function1<A, Object> p, int from) {
                return scala.collection.SeqLike.segmentLength$(this, p, from);
            }

            public int indexWhere(Function1<A, Object> p, int from) {
                return scala.collection.SeqLike.indexWhere$(this, p, from);
            }

            public int lastIndexWhere(Function1<A, Object> p, int end) {
                return scala.collection.SeqLike.lastIndexWhere$(this, p, end);
            }

            public Iterator<Buffer<A>> permutations() {
                return scala.collection.SeqLike.permutations$(this);
            }

            public Iterator<Buffer<A>> combinations(int n) {
                return scala.collection.SeqLike.combinations$(this, n);
            }

            public Object reverse() {
                return scala.collection.SeqLike.reverse$(this);
            }

            public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)scala.collection.SeqLike.reverseMap$(this, f, bf);
            }

            public Iterator<A> reverseIterator() {
                return scala.collection.SeqLike.reverseIterator$(this);
            }

            public <B> boolean startsWith(GenSeq<B> that, int offset) {
                return scala.collection.SeqLike.startsWith$(this, that, offset);
            }

            public <B> boolean endsWith(GenSeq<B> that) {
                return scala.collection.SeqLike.endsWith$(this, that);
            }

            public <B> int indexOfSlice(GenSeq<B> that) {
                return scala.collection.SeqLike.indexOfSlice$(this, that);
            }

            public <B> int indexOfSlice(GenSeq<B> that, int from) {
                return scala.collection.SeqLike.indexOfSlice$(this, that, from);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that) {
                return scala.collection.SeqLike.lastIndexOfSlice$(this, that);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
                return scala.collection.SeqLike.lastIndexOfSlice$(this, that, end);
            }

            public <B> boolean containsSlice(GenSeq<B> that) {
                return scala.collection.SeqLike.containsSlice$(this, that);
            }

            public <A1> boolean contains(A1 elem) {
                return scala.collection.SeqLike.contains$(this, elem);
            }

            public <B, That> That union(GenSeq<B> that, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)scala.collection.SeqLike.union$(this, that, bf);
            }

            public Object diff(GenSeq that) {
                return scala.collection.SeqLike.diff$(this, that);
            }

            public Object intersect(GenSeq that) {
                return scala.collection.SeqLike.intersect$(this, that);
            }

            public Object distinct() {
                return scala.collection.SeqLike.distinct$(this);
            }

            public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)scala.collection.SeqLike.patch$(this, from, patch, replaced, bf);
            }

            public <B, That> That updated(int index, B elem, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)scala.collection.SeqLike.updated$(this, index, elem, bf);
            }

            public <B, That> That $plus$colon(B elem, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)scala.collection.SeqLike.$plus$colon$(this, elem, bf);
            }

            public <B, That> That $colon$plus(B elem, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)scala.collection.SeqLike.$colon$plus$(this, elem, bf);
            }

            public <B, That> That padTo(int len, B elem, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)scala.collection.SeqLike.padTo$(this, len, elem, bf);
            }

            public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
                return scala.collection.SeqLike.corresponds$(this, that, p);
            }

            public Object sortWith(Function2 lt) {
                return scala.collection.SeqLike.sortWith$(this, lt);
            }

            public Object sortBy(Function1 f, Ordering ord) {
                return scala.collection.SeqLike.sortBy$(this, f, ord);
            }

            public Object sorted(Ordering ord) {
                return scala.collection.SeqLike.sorted$(this, ord);
            }

            public Seq<A> toSeq() {
                return scala.collection.SeqLike.toSeq$(this);
            }

            public Range indices() {
                return scala.collection.SeqLike.indices$(this);
            }

            public SeqView<A, Buffer<A>> view() {
                return scala.collection.SeqLike.view$(this);
            }

            public SeqView<A, Buffer<A>> view(int from, int until) {
                return scala.collection.SeqLike.view$(this, from, until);
            }

            public boolean isDefinedAt(int idx) {
                return GenSeqLike.isDefinedAt$(this, idx);
            }

            public int prefixLength(Function1<A, Object> p) {
                return GenSeqLike.prefixLength$(this, p);
            }

            public int indexWhere(Function1<A, Object> p) {
                return GenSeqLike.indexWhere$(this, p);
            }

            public <B> int indexOf(B elem) {
                return GenSeqLike.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return GenSeqLike.indexOf$(this, elem, from);
            }

            public <B> int lastIndexOf(B elem) {
                return GenSeqLike.lastIndexOf$(this, elem);
            }

            public <B> int lastIndexOf(B elem, int end) {
                return GenSeqLike.lastIndexOf$(this, elem, end);
            }

            public int lastIndexWhere(Function1<A, Object> p) {
                return GenSeqLike.lastIndexWhere$(this, p);
            }

            public <B> boolean startsWith(GenSeq<B> that) {
                return GenSeqLike.startsWith$(this, that);
            }

            public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return PartialFunction.orElse$(this, that);
            }

            public <C> PartialFunction<Object, C> andThen(Function1<A, C> k) {
                return PartialFunction.andThen$(this, k);
            }

            public Function1<Object, Option<A>> lift() {
                return PartialFunction.lift$(this);
            }

            public Object applyOrElse(Object x, Function1 function1) {
                return PartialFunction.applyOrElse$(this, x, function1);
            }

            public <U> Function1<Object, Object> runWith(Function1<A, U> action) {
                return PartialFunction.runWith$(this, action);
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

            public <A> Function1<A, A> compose(Function1<A, Object> g) {
                return Function1.compose$(this, g);
            }

            public <U> void foreach(Function1<A, U> f) {
                IterableLike.foreach$(this, f);
            }

            public boolean forall(Function1<A, Object> p) {
                return IterableLike.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return IterableLike.exists$(this, p);
            }

            public Option<A> find(Function1<A, Object> p) {
                return IterableLike.find$(this, p);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)IterableLike.foldRight$(this, z, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)IterableLike.reduceRight$(this, op);
            }

            public Iterable<A> toIterable() {
                return IterableLike.toIterable$(this);
            }

            public Iterator<A> toIterator() {
                return IterableLike.toIterator$(this);
            }

            public A head() {
                return (A)IterableLike.head$(this);
            }

            public Object slice(int from, int until) {
                return IterableLike.slice$(this, from, until);
            }

            public Object take(int n) {
                return IterableLike.take$(this, n);
            }

            public Object drop(int n) {
                return IterableLike.drop$(this, n);
            }

            public Object takeWhile(Function1 p) {
                return IterableLike.takeWhile$(this, p);
            }

            public Iterator<Buffer<A>> grouped(int size) {
                return IterableLike.grouped$(this, size);
            }

            public Iterator<Buffer<A>> sliding(int size) {
                return IterableLike.sliding$(this, size);
            }

            public Iterator<Buffer<A>> sliding(int size, int step) {
                return IterableLike.sliding$(this, size, step);
            }

            public Object takeRight(int n) {
                return IterableLike.takeRight$(this, n);
            }

            public Object dropRight(int n) {
                return IterableLike.dropRight$(this, n);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                IterableLike.copyToArray$(this, xs, start, len);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Buffer<A>, Tuple2<A1, B>, That> bf) {
                return (That)IterableLike.zip$(this, that, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<Buffer<A>, Tuple2<A1, B>, That> bf) {
                return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<Buffer<A>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableLike.zipWithIndex$(this, bf);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableLike.sameElements$(this, that);
            }

            public Stream<A> toStream() {
                return IterableLike.toStream$(this);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public Builder<A, Buffer<A>> newBuilder() {
                return GenericTraversableTemplate.newBuilder$(this);
            }

            public <B> Builder<B, Buffer<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public <A1, A2> Tuple2<Buffer<A1>, Buffer<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return GenericTraversableTemplate.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<Buffer<A1>, Buffer<A2>, Buffer<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
                return GenericTraversableTemplate.unzip3$(this, asTriple);
            }

            public GenTraversable flatten(Function1 asTraversable) {
                return GenericTraversableTemplate.flatten$(this, asTraversable);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public Object repr() {
                return TraversableLike.repr$(this);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableLike.hasDefiniteSize$(this);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$(this, that, bf);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.map$(this, f, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.flatMap$(this, f, bf);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public Object filter(Function1 p) {
                return TraversableLike.filter$(this, p);
            }

            public Object filterNot(Function1 p) {
                return TraversableLike.filterNot$(this, p);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.collect$(this, pf, bf);
            }

            public Tuple2<Buffer<A>, Buffer<A>> partition(Function1<A, Object> p) {
                return TraversableLike.partition$(this, p);
            }

            public <K> Map<K, Buffer<A>> groupBy(Function1<A, K> f) {
                return TraversableLike.groupBy$(this, f);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<Buffer<A>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<Buffer<A>, B, That> bf) {
                return (That)TraversableLike.scanRight$(this, z, op, bf);
            }

            public Option<A> headOption() {
                return TraversableLike.headOption$(this);
            }

            public Object tail() {
                return TraversableLike.tail$(this);
            }

            public A last() {
                return (A)TraversableLike.last$(this);
            }

            public Option<A> lastOption() {
                return TraversableLike.lastOption$(this);
            }

            public Object init() {
                return TraversableLike.init$(this);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Object dropWhile(Function1 p) {
                return TraversableLike.dropWhile$(this, p);
            }

            public Tuple2<Buffer<A>, Buffer<A>> span(Function1<A, Object> p) {
                return TraversableLike.span$(this, p);
            }

            public Tuple2<Buffer<A>, Buffer<A>> splitAt(int n) {
                return TraversableLike.splitAt$(this, n);
            }

            public Iterator<Buffer<A>> tails() {
                return TraversableLike.tails$(this);
            }

            public Iterator<Buffer<A>> inits() {
                return TraversableLike.inits$(this);
            }

            public Traversable<A> toTraversable() {
                return TraversableLike.toTraversable$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public FilterMonadic<A, Buffer<A>> withFilter(Function1<A, Object> p) {
                return TraversableLike.withFilter$(this, p);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<A, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
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

            public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableOnce.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableOnce.max$(this, cmp);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
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

            public List<A> toList() {
                return TraversableOnce.toList$(this);
            }

            public IndexedSeq<A> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
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

            public Buffer<A> self() {
                return this.$outer.self().clone();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
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
                PartialFunction.$init$(this);
                GenSeqLike.$init$(this);
                GenSeq.$init$(this);
                scala.collection.SeqLike.$init$(this);
                Seq.$init$(this);
                Cloneable.$init$(this);
                SeqLike.$init$(this);
                scala.collection.mutable.Seq.$init$(this);
                Growable.$init$(this);
                Shrinkable.$init$(this);
                Subtractable.$init$(this);
                BufferLike.$init$(this);
                Buffer.$init$(this);
                Proxy.$init$(this);
                BufferProxy.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static void $init$(BufferProxy $this) {
    }
}

