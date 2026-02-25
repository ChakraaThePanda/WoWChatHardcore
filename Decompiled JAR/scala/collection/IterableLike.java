/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Equals;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenIterableLike;
import scala.collection.GenSeq;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableView;
import scala.collection.IterableViewLike;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.SliceInterval;
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
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\t\rcaB\u0011#!\u0003\r\ta\n\u0005\u0006\u0005\u0002!\ta\u0011\u0005\u0007\u000f\u0002\u0001K\u0011\u000b%\t\r1\u0003\u0001\u0015\"\u0015N\u0011\u0015\u0001\u0006A\"\u0001R\u0011\u0015)\u0006\u0001\"\u0001W\u0011\u0015\u0001\u0007\u0001\"\u0011b\u0011\u0015A\u0007\u0001\"\u0011j\u0011\u0015Y\u0007\u0001\"\u0011m\u0011\u0015\t\b\u0001\"\u0011s\u0011\u0015\u0019\b\u0001\"\u0011u\u0011\u001d\t\u0019\u0001\u0001C!\u0003\u000bAa!a\u0005\u0001\t\u0003B\u0005BBA\u000b\u0001\u0011\u0005\u0013\u000bC\u0004\u0002(\u0001!\t%!\u000b\t\u000f\u0005-\u0002\u0001\"\u0011\u0002.!9\u0011Q\b\u0001\u0005B\u0005}\u0002bBA#\u0001\u0011\u0005\u0013q\t\u0005\b\u0003\u0017\u0002A\u0011IA'\u0011\u001d\t\t\u0006\u0001C\u0001\u0003'Bq!a\u0017\u0001\t\u0003\ti\u0006C\u0004\u0002\\\u0001!\t!!\u0019\t\u000f\u0005%\u0004\u0001\"\u0001\u0002l!9\u0011q\u000e\u0001\u0005\u0002\u0005E\u0004bBA;\u0001\u0011\u0005\u0013q\u000f\u0005\b\u0003#\u0003A\u0011AAJ\u0011\u001d\tI\r\u0001C\u0001\u0003\u0017Dq!a<\u0001\t\u0003\t\t\u0010C\u0004\u0003\u0004\u0001!\tA!\u0002\t\u000f\tE\u0001\u0001\"\u0011\u0003\u0014!9!\u0011\u0005\u0001\u0005B\t\r\u0002b\u0002B\u0014\u0001\u0011\u0005#\u0011\u0006\u0005\b\u0005O\u0001A\u0011\tB\u001f\u00051IE/\u001a:bE2,G*[6f\u0015\t\u0019C%\u0001\u0006d_2dWm\u0019;j_:T\u0011!J\u0001\u0006g\u000e\fG.Y\u0002\u0001+\rAc'P\n\u0006\u0001%j\u0003g\u0010\t\u0003U-j\u0011\u0001J\u0005\u0003Y\u0011\u00121!\u00118z!\tQc&\u0003\u00020I\t1Q)];bYN\u0004B!\r\u001a5y5\t!%\u0003\u00024E\tyAK]1wKJ\u001c\u0018M\u00197f\u0019&\\W\r\u0005\u00026m1\u0001AAB\u001c\u0001\t\u000b\u0007\u0001HA\u0001B#\tI\u0014\u0006\u0005\u0002+u%\u00111\b\n\u0002\b\u001d>$\b.\u001b8h!\t)T\b\u0002\u0004?\u0001\u0011\u0015\r\u0001\u000f\u0002\u0005%\u0016\u0004(\u000f\u0005\u00032\u0001Rb\u0014BA!#\u0005=9UM\\%uKJ\f'\r\\3MS.,\u0017A\u0002\u0013j]&$H\u0005F\u0001E!\tQS)\u0003\u0002GI\t!QK\\5u\u00039!\b.[:D_2dWm\u0019;j_:,\u0012!\u0013\t\u0004c)#\u0014BA&#\u0005!IE/\u001a:bE2,\u0017\u0001\u0004;p\u0007>dG.Z2uS>tGCA%O\u0011\u0015y5\u00011\u0001=\u0003\u0011\u0011X\r\u001d:\u0002\u0011%$XM]1u_J,\u0012A\u0015\t\u0004cM#\u0014B\u0001+#\u0005!IE/\u001a:bi>\u0014\u0018a\u00024pe\u0016\f7\r[\u000b\u0003/z#\"\u0001\u0012-\t\u000be+\u0001\u0019\u0001.\u0002\u0003\u0019\u0004BAK.5;&\u0011A\f\n\u0002\n\rVt7\r^5p]F\u0002\"!\u000e0\u0005\u000b}+!\u0019\u0001\u001d\u0003\u0003U\u000baAZ8sC2dGC\u00012f!\tQ3-\u0003\u0002eI\t9!i\\8mK\u0006t\u0007\"\u00024\u0007\u0001\u00049\u0017!\u00019\u0011\t)ZFGY\u0001\u0007KbL7\u000f^:\u0015\u0005\tT\u0007\"\u00024\b\u0001\u00049\u0017\u0001\u00024j]\u0012$\"!\u001c9\u0011\u0007)rG'\u0003\u0002pI\t1q\n\u001d;j_:DQA\u001a\u0005A\u0002\u001d\fq![:F[B$\u00180F\u0001c\u0003%1w\u000e\u001c3SS\u001eDG/\u0006\u0002vqR\u0011ao \u000b\u0003oj\u0004\"!\u000e=\u0005\u000beT!\u0019\u0001\u001d\u0003\u0003\tCQa\u001f\u0006A\u0002q\f!a\u001c9\u0011\u000b)jHg^<\n\u0005y$#!\u0003$v]\u000e$\u0018n\u001c83\u0011\u0019\t\tA\u0003a\u0001o\u0006\t!0A\u0006sK\u0012,8-\u001a*jO\"$X\u0003BA\u0004\u0003\u0017!B!!\u0003\u0002\u0010A\u0019Q'a\u0003\u0005\re\\!\u0019AA\u0007#\t!\u0014\u0006\u0003\u0004|\u0017\u0001\u0007\u0011\u0011\u0003\t\bUu$\u0014\u0011BA\u0005\u0003)!x.\u0013;fe\u0006\u0014G.Z\u0001\u000bi>LE/\u001a:bi>\u0014\bfB\u0007\u0002\u001a\u0005}\u00111\u0005\t\u0004U\u0005m\u0011bAA\u000fI\t!B-\u001a9sK\u000e\fG/\u001a3Pm\u0016\u0014(/\u001b3j]\u001e\f#!!\t\u0002;R|\u0017\n^3sCR|'\u000fI:i_VdG\rI:uCf\u00043m\u001c8tSN$XM\u001c;!o&$\b\u000eI5uKJ\fGo\u001c:!M>\u0014\b%\u00197mA%#XM]1cY\u0016\u001c(\bI8wKJ\u0014\u0018\u000eZ3!SR,'/\u0019;pe\u0002Jgn\u001d;fC\u0012t\u0013EAA\u0013\u0003\u0019\u0011d&M\u0019/a\u0005!\u0001.Z1e+\u0005!\u0014!B:mS\u000e,G#\u0002\u001f\u00020\u0005e\u0002bBA\u0019\u001f\u0001\u0007\u00111G\u0001\u0005MJ|W\u000eE\u0002+\u0003kI1!a\u000e%\u0005\rIe\u000e\u001e\u0005\b\u0003wy\u0001\u0019AA\u001a\u0003\u0015)h\u000e^5m\u0003\u0011!\u0018m[3\u0015\u0007q\n\t\u0005C\u0004\u0002DA\u0001\r!a\r\u0002\u00039\fA\u0001\u001a:paR\u0019A(!\u0013\t\u000f\u0005\r\u0013\u00031\u0001\u00024\u0005IA/Y6f/\"LG.\u001a\u000b\u0004y\u0005=\u0003\"\u00024\u0013\u0001\u00049\u0017aB4s_V\u0004X\r\u001a\u000b\u0005\u0003+\n9\u0006E\u00022'rBq!!\u0017\u0014\u0001\u0004\t\u0019$\u0001\u0003tSj,\u0017aB:mS\u0012Lgn\u001a\u000b\u0005\u0003+\ny\u0006C\u0004\u0002ZQ\u0001\r!a\r\u0015\r\u0005U\u00131MA3\u0011\u001d\tI&\u0006a\u0001\u0003gAq!a\u001a\u0016\u0001\u0004\t\u0019$\u0001\u0003ti\u0016\u0004\u0018!\u0003;bW\u0016\u0014\u0016n\u001a5u)\ra\u0014Q\u000e\u0005\b\u0003\u00072\u0002\u0019AA\u001a\u0003%!'o\u001c9SS\u001eDG\u000fF\u0002=\u0003gBq!a\u0011\u0018\u0001\u0004\t\u0019$A\u0006d_BLHk\\!se\u0006LX\u0003BA=\u0003\u000f#r\u0001RA>\u0003\u0013\u000bi\tC\u0004\u0002~a\u0001\r!a \u0002\u0005a\u001c\b#\u0002\u0016\u0002\u0002\u0006\u0015\u0015bAABI\t)\u0011I\u001d:bsB\u0019Q'a\"\u0005\reD\"\u0019AA\u0007\u0011\u001d\tY\t\u0007a\u0001\u0003g\tQa\u001d;beRDq!a$\u0019\u0001\u0004\t\u0019$A\u0002mK:\f1A_5q+!\t)*a.\u0002>\u0006mE\u0003BAL\u0003\u007f#B!!'\u0002 B\u0019Q'a'\u0005\r\u0005u\u0015D1\u00019\u0005\u0011!\u0006.\u0019;\t\u000f\u0005\u0005\u0016\u0004q\u0001\u0002$\u0006\u0011!M\u001a\t\n\u0003K\u000bY\u000bPAX\u00033k!!a*\u000b\u0007\u0005%&%A\u0004hK:,'/[2\n\t\u00055\u0016q\u0015\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\bU\u0005E\u0016QWA^\u0013\r\t\u0019\f\n\u0002\u0007)V\u0004H.\u001a\u001a\u0011\u0007U\n9\fB\u0004\u0002:f\u0011\r!!\u0004\u0003\u0005\u0005\u000b\u0004cA\u001b\u0002>\u0012)\u00110\u0007b\u0001q!9\u0011\u0011Y\rA\u0002\u0005\r\u0017\u0001\u0002;iCR\u0004R!MAc\u0003wK1!a2#\u0005-9UM\\%uKJ\f'\r\\3\u0002\riL\u0007/\u00117m+!\ti-!9\u0002^\u0006MG\u0003CAh\u0003G\f9/a;\u0015\t\u0005E\u0017Q\u001b\t\u0004k\u0005MGABAO5\t\u0007\u0001\bC\u0004\u0002\"j\u0001\u001d!a6\u0011\u0013\u0005\u0015\u00161\u0016\u001f\u0002Z\u0006E\u0007c\u0002\u0016\u00022\u0006m\u0017q\u001c\t\u0004k\u0005uGaBA]5\t\u0007\u0011Q\u0002\t\u0004k\u0005\u0005H!B=\u001b\u0005\u0004A\u0004bBAa5\u0001\u0007\u0011Q\u001d\t\u0006c\u0005\u0015\u0017q\u001c\u0005\b\u0003ST\u0002\u0019AAn\u0003!!\b.[:FY\u0016l\u0007bBAw5\u0001\u0007\u0011q\\\u0001\ti\"\fG/\u00127f[\u0006a!0\u001b9XSRD\u0017J\u001c3fqV1\u00111\u001fB\u0001\u0003o$B!!>\u0002zB\u0019Q'a>\u0005\r\u0005u5D1\u00019\u0011\u001d\t\tk\u0007a\u0002\u0003w\u0004\u0012\"!*\u0002,r\ni0!>\u0011\u000f)\n\t,a@\u00024A\u0019QG!\u0001\u0005\u000f\u0005e6D1\u0001\u0002\u000e\u0005a1/Y7f\u000b2,W.\u001a8ugV!!q\u0001B\b)\r\u0011'\u0011\u0002\u0005\b\u0003\u0003d\u0002\u0019\u0001B\u0006!\u0015\t\u0014Q\u0019B\u0007!\r)$q\u0002\u0003\u0007sr\u0011\r!!\u0004\u0002\u0011Q|7\u000b\u001e:fC6,\"A!\u0006\u0011\u000b\t]!Q\u0004\u001b\u000e\u0005\te!b\u0001B\u000eE\u0005I\u0011.\\7vi\u0006\u0014G.Z\u0005\u0005\u0005?\u0011IB\u0001\u0004TiJ,\u0017-\\\u0001\tG\u0006tW)];bYR\u0019!M!\n\t\r\u0005\u0005g\u00041\u0001*\u0003\u00111\u0018.Z<\u0016\u0005\t-\"C\u0002B\u0017\u0005c\u00119D\u0002\u0004\u00030}\u0001!1\u0006\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0004U\tM\u0012b\u0001B\u001bI\t1\u0011I\\=SK\u001a\u0004R!\rB\u001diqJ1Aa\u000f#\u00051IE/\u001a:bE2,g+[3x)\u0019\u00119Da\u0010\u0003B!9\u0011\u0011\u0007\u0011A\u0002\u0005M\u0002bBA\u001eA\u0001\u0007\u00111\u0007")
public interface IterableLike<A, Repr>
extends Equals,
TraversableLike<A, Repr>,
GenIterableLike<A, Repr> {
    public static /* synthetic */ Iterable thisCollection$(IterableLike $this) {
        return $this.thisCollection();
    }

    @Override
    default public Iterable<A> thisCollection() {
        return (Iterable)this;
    }

    public static /* synthetic */ Iterable toCollection$(IterableLike $this, Object repr) {
        return $this.toCollection(repr);
    }

    @Override
    default public Iterable<A> toCollection(Repr repr) {
        return (Iterable)repr;
    }

    @Override
    public Iterator<A> iterator();

    public static /* synthetic */ void foreach$(IterableLike $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        this.iterator().foreach(f);
    }

    public static /* synthetic */ boolean forall$(IterableLike $this, Function1 p) {
        return $this.forall(p);
    }

    @Override
    default public boolean forall(Function1<A, Object> p) {
        return this.iterator().forall(p);
    }

    public static /* synthetic */ boolean exists$(IterableLike $this, Function1 p) {
        return $this.exists(p);
    }

    @Override
    default public boolean exists(Function1<A, Object> p) {
        return this.iterator().exists(p);
    }

    public static /* synthetic */ Option find$(IterableLike $this, Function1 p) {
        return $this.find(p);
    }

    @Override
    default public Option<A> find(Function1<A, Object> p) {
        return this.iterator().find(p);
    }

    public static /* synthetic */ boolean isEmpty$(IterableLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return !this.iterator().hasNext();
    }

    public static /* synthetic */ Object foldRight$(IterableLike $this, Object z, Function2 op) {
        return $this.foldRight(z, op);
    }

    @Override
    default public <B> B foldRight(B z, Function2<A, B, B> op) {
        return this.iterator().foldRight(z, op);
    }

    public static /* synthetic */ Object reduceRight$(IterableLike $this, Function2 op) {
        return $this.reduceRight(op);
    }

    @Override
    default public <B> B reduceRight(Function2<A, B, B> op) {
        return this.iterator().reduceRight(op);
    }

    public static /* synthetic */ Iterable toIterable$(IterableLike $this) {
        return $this.toIterable();
    }

    @Override
    default public Iterable<A> toIterable() {
        return this.thisCollection();
    }

    public static /* synthetic */ Iterator toIterator$(IterableLike $this) {
        return $this.toIterator();
    }

    @Override
    default public Iterator<A> toIterator() {
        return this.iterator();
    }

    public static /* synthetic */ Object head$(IterableLike $this) {
        return $this.head();
    }

    @Override
    default public A head() {
        return this.iterator().next();
    }

    public static /* synthetic */ Object slice$(IterableLike $this, int from, int until) {
        return $this.slice(from, until);
    }

    @Override
    default public Repr slice(int from, int until) {
        int lo = package$.MODULE$.max(from, 0);
        int elems = until - lo;
        Builder b = this.newBuilder();
        if (elems <= 0) {
            return b.result();
        }
        b.sizeHintBounded(elems, this);
        Iterator<A> it = this.iterator().drop(lo);
        for (int i = 0; i < elems && it.hasNext(); ++i) {
            b.$plus$eq(it.next());
        }
        return b.result();
    }

    public static /* synthetic */ Object take$(IterableLike $this, int n) {
        return $this.take(n);
    }

    @Override
    default public Repr take(int n) {
        Builder b = this.newBuilder();
        if (n <= 0) {
            return b.result();
        }
        b.sizeHintBounded(n, this);
        Iterator<A> it = this.iterator();
        for (int i = 0; i < n && it.hasNext(); ++i) {
            b.$plus$eq(it.next());
        }
        return b.result();
    }

    public static /* synthetic */ Object drop$(IterableLike $this, int n) {
        return $this.drop(n);
    }

    @Override
    default public Repr drop(int n) {
        Builder b = this.newBuilder();
        int lo = package$.MODULE$.max(0, n);
        b.sizeHint(this, -lo);
        Iterator<A> it = this.iterator();
        for (int i = 0; i < n && it.hasNext(); ++i) {
            it.next();
        }
        return (Repr)((Builder)b.$plus$plus$eq(it)).result();
    }

    public static /* synthetic */ Object takeWhile$(IterableLike $this, Function1 p) {
        return $this.takeWhile(p);
    }

    @Override
    default public Repr takeWhile(Function1<A, Object> p) {
        Builder b = this.newBuilder();
        Iterator<A> it = this.iterator();
        while (it.hasNext()) {
            A x = it.next();
            if (!BoxesRunTime.unboxToBoolean(p.apply(x))) {
                return b.result();
            }
            b.$plus$eq(x);
        }
        return b.result();
    }

    public static /* synthetic */ Iterator grouped$(IterableLike $this, int size) {
        return $this.grouped(size);
    }

    default public Iterator<Repr> grouped(int size) {
        return this.iterator().grouped(size).map((Function1<Seq, Object> & java.io.Serializable & Serializable)xs -> {
            Builder b = this.newBuilder();
            b.$plus$plus$eq(xs);
            return b.result();
        });
    }

    public static /* synthetic */ Iterator sliding$(IterableLike $this, int size) {
        return $this.sliding(size);
    }

    default public Iterator<Repr> sliding(int size) {
        return this.sliding(size, 1);
    }

    public static /* synthetic */ Iterator sliding$(IterableLike $this, int size, int step) {
        return $this.sliding(size, step);
    }

    default public Iterator<Repr> sliding(int size, int step) {
        return this.iterator().sliding(size, step).map((Function1<Seq, Object> & java.io.Serializable & Serializable)xs -> {
            Builder b = this.newBuilder();
            b.$plus$plus$eq(xs);
            return b.result();
        });
    }

    public static /* synthetic */ Object takeRight$(IterableLike $this, int n) {
        return $this.takeRight(n);
    }

    default public Repr takeRight(int n) {
        Builder b = this.newBuilder();
        b.sizeHintBounded(n, this);
        Iterator<A> lead = this.iterator().drop(n);
        Iterator<A> it = this.iterator();
        while (lead.hasNext()) {
            lead.next();
            it.next();
        }
        while (it.hasNext()) {
            b.$plus$eq(it.next());
        }
        return b.result();
    }

    public static /* synthetic */ Object dropRight$(IterableLike $this, int n) {
        return $this.dropRight(n);
    }

    default public Repr dropRight(int n) {
        Builder b = this.newBuilder();
        if (n >= 0) {
            b.sizeHint(this, -n);
        }
        Iterator<A> lead = this.iterator().drop(n);
        Iterator<A> it = this.iterator();
        while (lead.hasNext()) {
            b.$plus$eq(it.next());
            lead.next();
        }
        return b.result();
    }

    public static /* synthetic */ void copyToArray$(IterableLike $this, Object xs, int start, int len) {
        $this.copyToArray(xs, start, len);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start, int len) {
        int n = start + len;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int end = RichInt$.MODULE$.min$extension(n, ScalaRunTime$.MODULE$.array_length(xs));
        Iterator<A> it = this.iterator();
        for (int i = start; i < end && it.hasNext(); ++i) {
            ScalaRunTime$.MODULE$.array_update(xs, i, it.next());
        }
    }

    public static /* synthetic */ Object zip$(IterableLike $this, GenIterable that, CanBuildFrom bf) {
        return $this.zip(that, bf);
    }

    @Override
    default public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Repr, Tuple2<A1, B>, That> bf) {
        Builder<Tuple2<A1, B>, That> b = bf.apply(this.repr());
        Iterator<A> these = this.iterator();
        Iterator those = that.iterator();
        while (these.hasNext() && those.hasNext()) {
            b.$plus$eq(new Tuple2(these.next(), those.next()));
        }
        return b.result();
    }

    public static /* synthetic */ Object zipAll$(IterableLike $this, GenIterable that, Object thisElem, Object thatElem, CanBuildFrom bf) {
        return $this.zipAll(that, thisElem, thatElem, bf);
    }

    @Override
    default public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<Repr, Tuple2<A1, B>, That> bf) {
        Builder<Tuple2<A1, B>, That> b = bf.apply(this.repr());
        Iterator<A> these = this.iterator();
        Iterator those = that.iterator();
        while (these.hasNext() && those.hasNext()) {
            b.$plus$eq(new Tuple2(these.next(), those.next()));
        }
        while (these.hasNext()) {
            b.$plus$eq(new Tuple2<A, B>(these.next(), thatElem));
        }
        while (those.hasNext()) {
            b.$plus$eq(new Tuple2(thisElem, those.next()));
        }
        return b.result();
    }

    public static /* synthetic */ Object zipWithIndex$(IterableLike $this, CanBuildFrom bf) {
        return $this.zipWithIndex(bf);
    }

    @Override
    default public <A1, That> That zipWithIndex(CanBuildFrom<Repr, Tuple2<A1, Object>, That> bf) {
        Builder<Tuple2<A1, Object>, That> b = bf.apply(this.repr());
        Iterator<A> these = this.iterator();
        int i = 0;
        while (these.hasNext()) {
            b.$plus$eq(new Tuple2<A, Integer>(these.next(), BoxesRunTime.boxToInteger(i)));
            ++i;
        }
        return b.result();
    }

    public static /* synthetic */ boolean sameElements$(IterableLike $this, GenIterable that) {
        return $this.sameElements(that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public <B> boolean sameElements(GenIterable<B> that) {
        if (this == that) return true;
        if (that instanceof Vector) {
            Vector vector = (Vector)that;
            if (this instanceof Vector) {
                Vector thisVector = (Vector)this;
                if (thisVector == vector) return true;
                if (thisVector.length() != vector.length()) return false;
                boolean bl = true;
                boolean equal = bl;
                if (equal) {
                    int length = vector.length();
                    for (int index = 0; index < length && equal; ++index) {
                        equal = BoxesRunTime.equals(thisVector.apply(index), vector.apply(index));
                    }
                }
                if (!equal) return false;
                return true;
            }
        }
        if (that instanceof GenSet) {
            GenSet genSet = (GenSet)that;
            if (this instanceof GenSetLike) {
                GenSetLike thisSet = (GenSetLike)((Object)this);
                if (thisSet.size() != genSet.size()) return false;
                if (!thisSet.subsetOf(genSet)) return false;
                return true;
            }
        }
        Iterator<A> these = this.iterator();
        Iterator those = that.iterator();
        while (these.hasNext() && those.hasNext()) {
            if (BoxesRunTime.equals(these.next(), those.next())) continue;
            return false;
        }
        if (these.hasNext()) return false;
        if (those.hasNext()) return false;
        return true;
    }

    public static /* synthetic */ Stream toStream$(IterableLike $this) {
        return $this.toStream();
    }

    @Override
    default public Stream<A> toStream() {
        return this.iterator().toStream();
    }

    public static /* synthetic */ boolean canEqual$(IterableLike $this, Object that) {
        return $this.canEqual(that);
    }

    @Override
    default public boolean canEqual(Object that) {
        return true;
    }

    public static /* synthetic */ IterableView view$(IterableLike $this) {
        return $this.view();
    }

    @Override
    default public IterableView<A, Repr> view() {
        return new IterableView<A, Repr>(this){
            private Repr underlying;
            private volatile boolean bitmap$0;
            private final /* synthetic */ IterableLike $outer;

            public <B> IterableViewLike.Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
                return IterableViewLike.newZipped$(this, that);
            }

            public <A1, B> IterableViewLike.Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
                return IterableViewLike.newZippedAll$(this, that, _thisElem, _thatElem);
            }

            public <B> IterableViewLike.Transformed<B> newForced(Function0<GenSeq<B>> xs) {
                return IterableViewLike.newForced$(this, xs);
            }

            public <B> IterableViewLike.Transformed<B> newAppended(GenTraversable<B> that) {
                return IterableViewLike.newAppended$(this, that);
            }

            public <B> IterableViewLike.Transformed<B> newPrepended(GenTraversable<B> that) {
                return IterableViewLike.newPrepended$(this, that);
            }

            public <B> IterableViewLike.Transformed<B> newMapped(Function1<A, B> f) {
                return IterableViewLike.newMapped$(this, f);
            }

            public <B> IterableViewLike.Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
                return IterableViewLike.newFlatMapped$(this, f);
            }

            public IterableViewLike.Transformed<A> newFiltered(Function1<A, Object> p) {
                return IterableViewLike.newFiltered$(this, p);
            }

            public IterableViewLike.Transformed<A> newSliced(SliceInterval _endpoints) {
                return IterableViewLike.newSliced$(this, _endpoints);
            }

            public IterableViewLike.Transformed<A> newDroppedWhile(Function1<A, Object> p) {
                return IterableViewLike.newDroppedWhile$(this, p);
            }

            public IterableViewLike.Transformed<A> newTakenWhile(Function1<A, Object> p) {
                return IterableViewLike.newTakenWhile$(this, p);
            }

            public IterableViewLike.Transformed<A> newTaken(int n) {
                return IterableViewLike.newTaken$(this, n);
            }

            public IterableViewLike.Transformed<A> newDropped(int n) {
                return IterableViewLike.newDropped$(this, n);
            }

            public IterableView<A, Repr> drop(int n) {
                return IterableViewLike.drop$(this, n);
            }

            public IterableView<A, Repr> take(int n) {
                return IterableViewLike.take$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<IterableView<A, Repr>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zip$(this, that, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<IterableView<A, Repr>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableViewLike.zipWithIndex$(this, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<IterableView<A, Repr>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public Iterator<IterableView<A, Repr>> grouped(int size) {
                return IterableViewLike.grouped$(this, size);
            }

            public Iterator<IterableView<A, Repr>> sliding(int size, int step) {
                return IterableViewLike.sliding$(this, size, step);
            }

            public Iterator<IterableView<A, Repr>> sliding(int size) {
                return IterableViewLike.sliding$(this, size);
            }

            public IterableView<A, Repr> dropRight(int n) {
                return IterableViewLike.dropRight$(this, n);
            }

            public IterableView<A, Repr> takeRight(int n) {
                return IterableViewLike.takeRight$(this, n);
            }

            public String stringPrefix() {
                return IterableViewLike.stringPrefix$(this);
            }

            public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
                return (TraversableView)TraversableLike.tail$(this);
            }

            public String viewIdentifier() {
                return TraversableViewLike.viewIdentifier$(this);
            }

            public String viewIdString() {
                return TraversableViewLike.viewIdString$(this);
            }

            public String viewToString() {
                return TraversableViewLike.viewToString$(this);
            }

            public Builder<A, IterableView<A, Repr>> newBuilder() {
                return TraversableViewLike.newBuilder$(this);
            }

            public <B, That> That force(CanBuildFrom<Repr, B, That> bf) {
                return (That)TraversableViewLike.force$(this, bf);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.map$(this, f, bf);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.collect$(this, pf, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.flatMap$(this, f, bf);
            }

            public <B> TraversableViewLike.Transformed<B> flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
                return TraversableViewLike.flatten$(this, asTraversable);
            }

            public TraversableView filter(Function1 p) {
                return TraversableViewLike.filter$(this, p);
            }

            public TraversableView withFilter(Function1 p) {
                return TraversableViewLike.withFilter$(this, p);
            }

            public Tuple2<IterableView<A, Repr>, IterableView<A, Repr>> partition(Function1<A, Object> p) {
                return TraversableViewLike.partition$(this, p);
            }

            public TraversableView init() {
                return TraversableViewLike.init$(this);
            }

            public TraversableView slice(int from, int until) {
                return TraversableViewLike.slice$(this, from, until);
            }

            public TraversableView dropWhile(Function1 p) {
                return TraversableViewLike.dropWhile$(this, p);
            }

            public TraversableView takeWhile(Function1 p) {
                return TraversableViewLike.takeWhile$(this, p);
            }

            public Tuple2<IterableView<A, Repr>, IterableView<A, Repr>> span(Function1<A, Object> p) {
                return TraversableViewLike.span$(this, p);
            }

            public Tuple2<IterableView<A, Repr>, IterableView<A, Repr>> splitAt(int n) {
                return TraversableViewLike.splitAt$(this, n);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<IterableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanRight$(this, z, op, bf);
            }

            public <K> Map<K, IterableView<A, Repr>> groupBy(Function1<A, K> f) {
                return TraversableViewLike.groupBy$(this, f);
            }

            public <A1, A2> Tuple2<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return TraversableViewLike.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>, TraversableViewLike.Transformed<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
                return TraversableViewLike.unzip3$(this, asTriple);
            }

            public TraversableView filterNot(Function1 p) {
                return TraversableViewLike.filterNot$(this, p);
            }

            public Iterator<IterableView<A, Repr>> inits() {
                return TraversableViewLike.inits$(this);
            }

            public Iterator<IterableView<A, Repr>> tails() {
                return TraversableViewLike.tails$(this);
            }

            public TraversableView tail() {
                return TraversableViewLike.tail$(this);
            }

            public String toString() {
                return TraversableViewLike.toString$(this);
            }

            public Seq<A> thisSeq() {
                return ViewMkString.thisSeq$(this);
            }

            public String mkString() {
                return ViewMkString.mkString$(this);
            }

            public String mkString(String sep) {
                return ViewMkString.mkString$(this, sep);
            }

            public String mkString(String start, String sep, String end) {
                return ViewMkString.mkString$(this, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return ViewMkString.addString$(this, b, start, sep, end);
            }

            public GenericCompanion<Iterable> companion() {
                return Iterable.companion$(this);
            }

            public Iterable<A> seq() {
                return Iterable.seq$(this);
            }

            public Iterable<A> thisCollection() {
                return IterableLike.thisCollection$(this);
            }

            public Iterable toCollection(Object repr) {
                return IterableLike.toCollection$(this, repr);
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

            public boolean isEmpty() {
                return IterableLike.isEmpty$(this);
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

            public <B> void copyToArray(Object xs, int start, int len) {
                IterableLike.copyToArray$(this, xs, start, len);
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

            public IterableView<A, IterableView<A, Repr>> view() {
                return IterableLike.view$(this);
            }

            public IterableView<A, IterableView<A, Repr>> view(int from, int until) {
                return IterableLike.view$(this, from, until);
            }

            public <B> Builder<B, Iterable<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
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

            public Combiner<A, ParIterable<A>> parCombiner() {
                return TraversableLike.parCombiner$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableLike.hasDefiniteSize$(this);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<IterableView<A, Repr>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Option<A> headOption() {
                return TraversableLike.headOption$(this);
            }

            public A last() {
                return (A)TraversableLike.last$(this);
            }

            public Option<A> lastOption() {
                return TraversableLike.lastOption$(this);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Traversable<A> toTraversable() {
                return TraversableLike.toTraversable$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
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

            public Seq<A> toSeq() {
                return TraversableOnce.toSeq$(this);
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

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            private Repr underlying$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.underlying = this.$outer.repr();
                        this.bitmap$0 = true;
                    }
                }
                return this.underlying;
            }

            public Repr underlying() {
                if (!this.bitmap$0) {
                    return this.underlying$lzycompute();
                }
                return this.underlying;
            }

            public Iterator<A> iterator() {
                return this.$outer.iterator();
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
                GenIterable.$init$(this);
                IterableLike.$init$(this);
                Iterable.$init$(this);
                ViewMkString.$init$(this);
                TraversableViewLike.$init$(this);
                IterableViewLike.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableViewLike scala.collection.Seq )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ IterableView view$(IterableLike $this, int from, int until) {
        return $this.view(from, until);
    }

    @Override
    default public IterableView<A, Repr> view(int from, int until) {
        return (IterableView)this.view().slice(from, until);
    }

    public static void $init$(IterableLike $this) {
    }
}

