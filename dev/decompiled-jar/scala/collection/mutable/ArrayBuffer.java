/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.IndexedSeqLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.List;
import scala.collection.mutable.AbstractBuffer;
import scala.collection.mutable.ArrayBuffer$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqView;
import scala.collection.mutable.ResizableArray;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.ParArray$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005ee\u0001\u0002\r\u001a\u0001\u0001B\u0001b\u0016\u0001\u0003\u0006\u0004%\t\u0006\u0017\u0005\t9\u0002\u0011\t\u0011)A\u00053\")Q\f\u0001C\u0001=\")\u0001\r\u0001C!C\")Q\f\u0001C\u0001K\")a\r\u0001C\u0001O\")1\u000e\u0001C!Y\")q\u000e\u0001C!a\")\u0011\u000f\u0001C\u0001e\")a\u000f\u0001C!o\")Q\u0010\u0001C\u0001}\"9\u0011\u0011\u0001\u0001\u0005B\u0005\r\u0001bBA\u0004\u0001\u0011\u0005\u0011\u0011\u0002\u0005\b\u00033\u0001A\u0011IA\u000e\u0011\u001d\tI\u0002\u0001C\u0001\u0003GAa!a\n\u0001\t\u0003)\u0007bBA\u0015\u0001\u0011\u0005\u00131F\u0004\b\u0003\u001fJ\u0002\u0012AA)\r\u0019A\u0012\u0004#\u0001\u0002T!1Ql\u0005C\u0001\u00037Bq!!\u0018\u0014\t\u0007\ty\u0006C\u0004\u0002xM!\t!!\u001f\t\u0013\u0005\u00155#!A\u0005\n\u0005\u001d%aC!se\u0006L()\u001e4gKJT!AG\u000e\u0002\u000f5,H/\u00192mK*\u0011A$H\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0010\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0011\u0005K\n\u000b\u0001\t\u0012T\u0007\u0010!D\r&#\u0006cA\u0012%M5\t\u0011$\u0003\u0002&3\tq\u0011IY:ue\u0006\u001cGOQ;gM\u0016\u0014\bCA\u0014)\u0019\u0001!Q!\u000b\u0001C\u0002)\u0012\u0011!Q\t\u0003W=\u0002\"\u0001L\u0017\u000e\u0003uI!AL\u000f\u0003\u000f9{G\u000f[5oOB\u0011A\u0006M\u0005\u0003cu\u00111!\u00118z!\r\u00193GJ\u0005\u0003ie\u0011aAQ;gM\u0016\u0014\b\u0003\u0002\u001c:Mmj\u0011a\u000e\u0006\u0003qm\tqaZ3oKJL7-\u0003\u0002;o\tQr)\u001a8fe&\u001cGK]1wKJ\u001c\u0018M\u00197f)\u0016l\u0007\u000f\\1uKB\u00111\u0005\u0001\t\u0005Gu2s(\u0003\u0002?3\tQ!)\u001e4gKJd\u0015n[3\u0011\u0007\r\u0002a\u0005\u0005\u0003$\u0003\u001az\u0014B\u0001\"\u001a\u0005MIe\u000eZ3yK\u0012\u001cV-](qi&l\u0017N_3e!\u0011\u0019CIJ \n\u0005\u0015K\"a\u0002\"vS2$WM\u001d\t\u0004G\u001d3\u0013B\u0001%\u001a\u00059\u0011Vm]5{C\ndW-\u0011:sCf\u0004BAS&'\u001b6\t1$\u0003\u0002M7\t!2)^:u_6\u0004\u0016M]1mY\u0016d\u0017N_1cY\u0016\u00042A\u0014*'\u001b\u0005y%B\u0001\u000eQ\u0015\t\t6$\u0001\u0005qCJ\fG\u000e\\3m\u0013\t\u0019vJ\u0001\u0005QCJ\f%O]1z!\taS+\u0003\u0002W;\ta1+\u001a:jC2L'0\u00192mK\u0006Y\u0011N\\5uS\u0006d7+\u001b>f+\u0005I\u0006C\u0001\u0017[\u0013\tYVDA\u0002J]R\fA\"\u001b8ji&\fGnU5{K\u0002\na\u0001P5oSRtDCA `\u0011\u001596\u00011\u0001Z\u0003%\u0019w.\u001c9b]&|g.F\u0001c!\r14mO\u0005\u0003I^\u0012\u0001cR3oKJL7mQ8na\u0006t\u0017n\u001c8\u0015\u0003}\nQa\u00197fCJ$\u0012\u0001\u001b\t\u0003Y%L!A[\u000f\u0003\tUs\u0017\u000e^\u0001\tg&TX\rS5oiR\u0011\u0001.\u001c\u0005\u0006]\u001e\u0001\r!W\u0001\u0004Y\u0016t\u0017a\u00019beV\tQ*\u0001\u0005%a2,8\u000fJ3r)\t\u0019H/D\u0001\u0001\u0011\u0015)\u0018\u00021\u0001'\u0003\u0011)G.Z7\u0002\u001b\u0011\u0002H.^:%a2,8\u000fJ3r)\t\u0019\b\u0010C\u0003z\u0015\u0001\u0007!0\u0001\u0002ygB\u0019!j\u001f\u0014\n\u0005q\\\"a\u0004+sCZ,'o]1cY\u0016|enY3\u0002\u001d\u0011\u0002H.^:%KF$3m\u001c7p]R\u00111o \u0005\u0006k.\u0001\rAJ\u0001\u0014IAdWo\u001d\u0013qYV\u001cH%Z9%G>dwN\u001c\u000b\u0004g\u0006\u0015\u0001\"B=\r\u0001\u0004Q\u0018!C5og\u0016\u0014H/\u00117m)\u0015A\u00171BA\b\u0011\u0019\ti!\u0004a\u00013\u0006\ta\u000eC\u0004\u0002\u00125\u0001\r!a\u0005\u0002\u0007M,\u0017\u000f\u0005\u0003K\u0003+1\u0013bAA\f7\tYAK]1wKJ\u001c\u0018M\u00197f\u0003\u0019\u0011X-\\8wKR)\u0001.!\b\u0002 !1\u0011Q\u0002\bA\u0002eCa!!\t\u000f\u0001\u0004I\u0016!B2pk:$Hc\u0001\u0014\u0002&!1\u0011QB\bA\u0002e\u000baA]3tk2$\u0018\u0001D:ue&tw\r\u0015:fM&DXCAA\u0017!\u0011\ty#!\u0010\u000f\t\u0005E\u0012\u0011\b\t\u0004\u0003giRBAA\u001b\u0015\r\t9dH\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005mR$\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003\u007f\t\tE\u0001\u0004TiJLgn\u001a\u0006\u0004\u0003wi\u0002f\u0002\u0001\u0002F\u0005-\u0013Q\n\t\u0004Y\u0005\u001d\u0013bAA%;\t\u00012+\u001a:jC24VM]:j_:,\u0016\nR\u0001\u0006m\u0006dW/\u001a\u0010\t+a\u0002<k!B\u000fh\u0006Y\u0011I\u001d:bs\n+hMZ3s!\t\u00193c\u0005\u0003\u0014\u0003+\"\u0006\u0003\u0002\u001c\u0002XmJ1!!\u00178\u0005)\u0019V-\u001d$bGR|'/\u001f\u000b\u0003\u0003#\nAbY1o\u0005VLG\u000e\u001a$s_6,B!!\u0019\u0002tU\u0011\u00111\r\t\nm\u0005\u0015\u0014\u0011NA9\u0003kJ1!a\u001a8\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u0011\tY'!\u001c\u000e\u0003MI1!a\u001cd\u0005\u0011\u0019u\u000e\u001c7\u0011\u0007\u001d\n\u0019\bB\u0003*+\t\u0007!\u0006\u0005\u0003$\u0001\u0005E\u0014A\u00038fo\n+\u0018\u000e\u001c3feV!\u00111PAA+\t\ti\b\u0005\u0004$\t\u0006}\u00141\u0011\t\u0004O\u0005\u0005E!B\u0015\u0017\u0005\u0004Q\u0003\u0003B\u0012\u0001\u0003\u007f\n1B]3bIJ+7o\u001c7wKR\u0011\u0011\u0011\u0012\t\u0005\u0003\u0017\u000b)*\u0004\u0002\u0002\u000e*!\u0011qRAI\u0003\u0011a\u0017M\\4\u000b\u0005\u0005M\u0015\u0001\u00026bm\u0006LA!a&\u0002\u000e\n1qJ\u00196fGR\u0004")
public class ArrayBuffer<A>
extends AbstractBuffer<A>
implements Builder<A, ArrayBuffer<A>>,
ResizableArray<A>,
CustomParallelizable<A, ParArray<A>>,
Serializable {
    public static final long serialVersionUID = 1529165946227428979L;
    private final int initialSize;
    private Object[] array;
    private int size0;

    public static <A> CanBuildFrom<ArrayBuffer<?>, A, ArrayBuffer<A>> canBuildFrom() {
        return ArrayBuffer$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return ArrayBuffer$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)arrayBuffer$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return ArrayBuffer$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ArrayBuffer$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ tabulate_this = arrayBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ tabulate_this = arrayBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ tabulate_this = arrayBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ tabulate_this = arrayBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ArrayBuffer$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ fill_this = arrayBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ fill_this = arrayBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ fill_this = arrayBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        ArrayBuffer$ fill_this = arrayBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ArrayBuffer$ arrayBuffer$ = ArrayBuffer$.MODULE$;
        if (arrayBuffer$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)arrayBuffer$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ArrayBuffer$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ArrayBuffer$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ArrayBuffer$.MODULE$.empty();
    }

    @Override
    public Combiner<A, ParArray<A>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public int length() {
        return ResizableArray.length$(this);
    }

    @Override
    public A apply(int idx) {
        return (A)ResizableArray.apply$(this, idx);
    }

    @Override
    public void update(int idx, A elem) {
        ResizableArray.update$(this, idx, elem);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        ResizableArray.foreach$(this, f);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        ResizableArray.copyToArray$(this, xs, start, len);
    }

    @Override
    public void reduceToSize(int sz) {
        ResizableArray.reduceToSize$(this, sz);
    }

    @Override
    public void ensureSize(int n) {
        ResizableArray.ensureSize$(this, n);
    }

    @Override
    public void swap(int a, int b) {
        ResizableArray.swap$(this, a, b);
    }

    @Override
    public void copy(int m, int n, int len) {
        ResizableArray.copy$(this, m, n, len);
    }

    @Override
    public IndexedSeq<A> seq() {
        return IndexedSeq.seq$(this);
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
    public <NewTo> Builder<A, NewTo> mapResult(Function1<ArrayBuffer<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
        return TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
        return this.iterator().reduceRight(op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
        return IterableLike.zip$(this, that, bf);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
        return IterableLike.head$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
        return TraversableLike.tail$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
        return TraversableLike.last$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
        return TraversableLike.init$(this);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
        return SeqLike.endsWith$(this, that);
    }

    @Override
    public boolean isEmpty() {
        return IndexedSeqOptimized.isEmpty$(this);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return IndexedSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return IndexedSeqOptimized.exists$(this, p);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return IndexedSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)IndexedSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)IndexedSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)IndexedSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<ArrayBuffer<A>, Tuple2<A1, B>, That> bf) {
        return (That)IndexedSeqOptimized.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<ArrayBuffer<A>, Tuple2<A1, Object>, That> bf) {
        return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
    }

    @Override
    public Object slice(int from, int until) {
        return IndexedSeqOptimized.slice$(this, from, until);
    }

    @Override
    public A head() {
        return (A)IndexedSeqOptimized.head$(this);
    }

    @Override
    public Object tail() {
        return IndexedSeqOptimized.tail$(this);
    }

    @Override
    public A last() {
        return (A)IndexedSeqOptimized.last$(this);
    }

    @Override
    public Object init() {
        return IndexedSeqOptimized.init$(this);
    }

    @Override
    public Object take(int n) {
        return IndexedSeqOptimized.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return IndexedSeqOptimized.drop$(this, n);
    }

    @Override
    public Object takeRight(int n) {
        return IndexedSeqOptimized.takeRight$(this, n);
    }

    @Override
    public Object dropRight(int n) {
        return IndexedSeqOptimized.dropRight$(this, n);
    }

    @Override
    public Tuple2<ArrayBuffer<A>, ArrayBuffer<A>> splitAt(int n) {
        return IndexedSeqOptimized.splitAt$(this, n);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return IndexedSeqOptimized.takeWhile$(this, p);
    }

    @Override
    public Object dropWhile(Function1 p) {
        return IndexedSeqOptimized.dropWhile$(this, p);
    }

    @Override
    public Tuple2<ArrayBuffer<A>, ArrayBuffer<A>> span(Function1<A, Object> p) {
        return IndexedSeqOptimized.span$(this, p);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IndexedSeqOptimized.sameElements$(this, that);
    }

    @Override
    public int lengthCompare(int len) {
        return IndexedSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public int segmentLength(Function1<A, Object> p, int from) {
        return IndexedSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return IndexedSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p, int end) {
        return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Object reverse() {
        return IndexedSeqOptimized.reverse$(this);
    }

    @Override
    public Iterator<A> reverseIterator() {
        return IndexedSeqOptimized.reverseIterator$(this);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return IndexedSeqOptimized.startsWith$(this, that, offset);
    }

    @Override
    public <B> boolean endsWith(GenSeq<B> that) {
        return IndexedSeqOptimized.endsWith$(this, that);
    }

    @Override
    public List<A> toList() {
        return IndexedSeqOptimized.toList$(this);
    }

    @Override
    public IndexedSeq<A> thisCollection() {
        return scala.collection.mutable.IndexedSeqLike.thisCollection$(this);
    }

    @Override
    public IndexedSeq toCollection(Object repr) {
        return scala.collection.mutable.IndexedSeqLike.toCollection$(this, repr);
    }

    @Override
    public IndexedSeqView<A, ArrayBuffer<A>> view() {
        return scala.collection.mutable.IndexedSeqLike.view$(this);
    }

    @Override
    public IndexedSeqView<A, ArrayBuffer<A>> view(int from, int until) {
        return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
    }

    @Override
    public int hashCode() {
        return IndexedSeqLike.hashCode$(this);
    }

    @Override
    public Iterator<A> iterator() {
        return IndexedSeqLike.iterator$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return IndexedSeqLike.sizeHintIfCheap$(this);
    }

    @Override
    public Object[] array() {
        return this.array;
    }

    @Override
    public void array_$eq(Object[] x$1) {
        this.array = x$1;
    }

    @Override
    public int size0() {
        return this.size0;
    }

    @Override
    public void size0_$eq(int x$1) {
        this.size0 = x$1;
    }

    @Override
    public int initialSize() {
        return this.initialSize;
    }

    @Override
    public GenericCompanion<ArrayBuffer> companion() {
        return ArrayBuffer$.MODULE$;
    }

    @Override
    public void clear() {
        this.reduceToSize(0);
    }

    @Override
    public void sizeHint(int len) {
        if (len > this.size() && len >= 1) {
            Object[] newarray = new Object[len];
            System.arraycopy(this.array(), 0, newarray, 0, this.size0());
            this.array_$eq(newarray);
        }
    }

    @Override
    public ParArray<A> par() {
        return ParArray$.MODULE$.handoff(this.array(), this.size());
    }

    @Override
    public ArrayBuffer<A> $plus$eq(A elem) {
        this.ensureSize(this.size0() + 1);
        this.array()[this.size0()] = elem;
        this.size0_$eq(this.size0() + 1);
        return this;
    }

    @Override
    public ArrayBuffer<A> $plus$plus$eq(TraversableOnce<A> xs) {
        ArrayBuffer arrayBuffer;
        if (xs instanceof IndexedSeqLike) {
            IndexedSeqLike indexedSeqLike = (IndexedSeqLike)xs;
            int n = indexedSeqLike.length();
            this.ensureSize(this.size0() + n);
            indexedSeqLike.copyToArray(this.array(), this.size0(), n);
            this.size0_$eq(this.size0() + n);
            arrayBuffer = this;
        } else {
            arrayBuffer = (ArrayBuffer)Growable.$plus$plus$eq$(this, xs);
        }
        return arrayBuffer;
    }

    @Override
    public ArrayBuffer<A> $plus$eq$colon(A elem) {
        this.ensureSize(this.size0() + 1);
        this.copy(0, 1, this.size0());
        this.array()[0] = elem;
        this.size0_$eq(this.size0() + 1);
        return this;
    }

    @Override
    public ArrayBuffer<A> $plus$plus$eq$colon(TraversableOnce<A> xs) {
        this.insertAll(0, xs.toTraversable());
        return this;
    }

    @Override
    public void insertAll(int n, Traversable<A> seq) {
        if (n < 0 || n > this.size0()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
        }
        int len = seq.size();
        int newSize = this.size0() + len;
        this.ensureSize(newSize);
        this.copy(n, n + len, this.size0() - n);
        seq.copyToArray(this.array(), n);
        this.size0_$eq(newSize);
    }

    @Override
    public void remove(int n, int count) {
        if (count < 0) {
            throw new IllegalArgumentException(new StringBuilder(38).append("removing negative number of elements: ").append(((Object)BoxesRunTime.boxToInteger(count)).toString()).toString());
        }
        if (count == 0) {
            return;
        }
        if (n < 0 || n > this.size0() - count) {
            throw new IndexOutOfBoundsException(new StringBuilder(13).append("at ").append(((Object)BoxesRunTime.boxToInteger(n)).toString()).append(" deleting ").append(((Object)BoxesRunTime.boxToInteger(count)).toString()).toString());
        }
        this.copy(n + count, n, this.size0() - (n + count));
        this.reduceToSize(this.size0() - count);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public A remove(int n) {
        void var2_2;
        A result2 = this.apply(n);
        this.remove(n, 1);
        return var2_2;
    }

    @Override
    public ArrayBuffer<A> result() {
        return this;
    }

    @Override
    public String stringPrefix() {
        return "ArrayBuffer";
    }

    public ArrayBuffer(int initialSize) {
        this.initialSize = initialSize;
        IndexedSeqLike.$init$(this);
        scala.collection.mutable.IndexedSeqLike.$init$(this);
        IndexedSeqOptimized.$init$(this);
        Builder.$init$(this);
        scala.collection.IndexedSeq.$init$(this);
        IndexedSeq.$init$(this);
        ResizableArray.$init$(this);
        CustomParallelizable.$init$(this);
    }

    public ArrayBuffer() {
        this(16);
    }
}

