/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.Predef$;
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
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.List;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.ArraySeq$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqView;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.ParArray$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u00055d\u0001B\n\u0015\u0001mA\u0001\"\u0013\u0001\u0003\u0006\u0004%\tE\u0013\u0005\t\u001d\u0002\u0011\t\u0011)A\u0005\u0017\")q\n\u0001C\u0001!\")!\u000b\u0001C!'\"9q\u000b\u0001b\u0001\n\u0003A\u0006BB0\u0001A\u0003%\u0011\fC\u0003a\u0001\u0011\u0005\u0013\rC\u0003c\u0001\u0011\u00051\rC\u0003g\u0001\u0011\u0005q\rC\u0003o\u0001\u0011\u0005s\u000eC\u0003z\u0001\u0011\u0005#\u0010C\u0004\u0002\u0010\u0001!\t%!\u0005\b\u000f\u0005}A\u0003#\u0001\u0002\"\u001911\u0003\u0006E\u0001\u0003GAaa\u0014\b\u0005\u0002\u0005-\u0002bBA\u0017\u001d\u0011\r\u0011q\u0006\u0005\b\u0003\u000frA\u0011AA%\u0011%\tIFDA\u0001\n\u0013\tYF\u0001\u0005BeJ\f\u0017pU3r\u0015\t)b#A\u0004nkR\f'\r\\3\u000b\u0005]A\u0012AC2pY2,7\r^5p]*\t\u0011$A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005q\u00193c\u0002\u0001\u001e[A:4H\u0012\t\u0004=}\tS\"\u0001\u000b\n\u0005\u0001\"\"aC!cgR\u0014\u0018m\u0019;TKF\u0004\"AI\u0012\r\u0001\u0011)A\u0005\u0001b\u0001K\t\t\u0011)\u0005\u0002'UA\u0011q\u0005K\u0007\u00021%\u0011\u0011\u0006\u0007\u0002\b\u001d>$\b.\u001b8h!\t93&\u0003\u0002-1\t\u0019\u0011I\\=\u0011\u0007yq\u0013%\u0003\u00020)\tQ\u0011J\u001c3fq\u0016$7+Z9\u0011\tE\"\u0014EN\u0007\u0002e)\u00111GF\u0001\bO\u0016tWM]5d\u0013\t)$G\u0001\u000eHK:,'/[2Ue\u00064XM]:bE2,G+Z7qY\u0006$X\r\u0005\u0002\u001f\u0001A!a\u0004O\u0011;\u0013\tIDCA\nJ]\u0012,\u00070\u001a3TKF|\u0005\u000f^5nSj,G\rE\u0002\u001f\u0001\u0005\u0002B\u0001P\u001f\"\u007f5\ta#\u0003\u0002?-\t!2)^:u_6\u0004\u0016M]1mY\u0016d\u0017N_1cY\u0016\u00042\u0001\u0011#\"\u001b\u0005\t%BA\u000bC\u0015\t\u0019e#\u0001\u0005qCJ\fG\u000e\\3m\u0013\t)\u0015I\u0001\u0005QCJ\f%O]1z!\t9s)\u0003\u0002I1\ta1+\u001a:jC2L'0\u00192mK\u00061A.\u001a8hi\",\u0012a\u0013\t\u0003O1K!!\u0014\r\u0003\u0007%sG/A\u0004mK:<G\u000f\u001b\u0011\u0002\rqJg.\u001b;?)\tQ\u0014\u000bC\u0003J\u0007\u0001\u00071*A\u0005d_6\u0004\u0018M\\5p]V\tA\u000bE\u00022+ZJ!A\u0016\u001a\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>t\u0017!B1se\u0006LX#A-\u0011\u0007\u001dRF,\u0003\u0002\\1\t)\u0011I\u001d:bsB\u0011q%X\u0005\u0003=b\u0011a!\u00118z%\u00164\u0017AB1se\u0006L\b%A\u0002qCJ,\u0012aP\u0001\u0006CB\u0004H.\u001f\u000b\u0003C\u0011DQ!\u001a\u0005A\u0002-\u000b1!\u001b3y\u0003\u0019)\b\u000fZ1uKR\u0019\u0001n\u001b7\u0011\u0005\u001dJ\u0017B\u00016\u0019\u0005\u0011)f.\u001b;\t\u000b\u0015L\u0001\u0019A&\t\u000b5L\u0001\u0019A\u0011\u0002\t\u0015dW-\\\u0001\bM>\u0014X-Y2i+\t\u0001x\u000f\u0006\u0002ic\")!O\u0003a\u0001g\u0006\ta\r\u0005\u0003(i\u00062\u0018BA;\u0019\u0005%1UO\\2uS>t\u0017\u0007\u0005\u0002#o\u0012)\u0001P\u0003b\u0001K\t\tQ+A\u0006d_BLHk\\!se\u0006LXcA>\u0002\u0002Q1\u0001\u000e`A\u0004\u0003\u0017AQ!`\u0006A\u0002y\f!\u0001_:\u0011\u0007\u001dRv\u0010E\u0002#\u0003\u0003!q!a\u0001\f\u0005\u0004\t)AA\u0001C#\t\t#\u0006\u0003\u0004\u0002\n-\u0001\raS\u0001\u0006gR\f'\u000f\u001e\u0005\u0007\u0003\u001bY\u0001\u0019A&\u0002\u00071,g.A\u0003dY>tW\rF\u0001;Q\u001d\u0001\u0011QCA\u000e\u0003;\u00012aJA\f\u0013\r\tI\u0002\u0007\u0002\u0011'\u0016\u0014\u0018.\u00197WKJ\u001c\u0018n\u001c8V\u0013\u0012\u000bQA^1mk\u0016t\u0002\"\u0006\u001f>%$Jeb]\u0001\t\u0003J\u0014\u0018-_*fcB\u0011aDD\n\u0005\u001d\u0005\u0015b\t\u0005\u00032\u0003O1\u0014bAA\u0015e\tQ1+Z9GC\u000e$xN]=\u0015\u0005\u0005\u0005\u0012\u0001D2b]\n+\u0018\u000e\u001c3Ge>lW\u0003BA\u0019\u0003\u0007*\"!a\r\u0011\u0013E\n)$!\u000f\u0002B\u0005\u0015\u0013bAA\u001ce\ta1)\u00198Ck&dGM\u0012:p[B!\u00111HA\u001f\u001b\u0005q\u0011bAA +\n!1i\u001c7m!\r\u0011\u00131\t\u0003\u0006IA\u0011\r!\n\t\u0005=\u0001\t\t%\u0001\u0006oK^\u0014U/\u001b7eKJ,B!a\u0013\u0002VU\u0011\u0011Q\n\t\b=\u0005=\u00131KA,\u0013\r\t\t\u0006\u0006\u0002\b\u0005VLG\u000eZ3s!\r\u0011\u0013Q\u000b\u0003\u0006IE\u0011\r!\n\t\u0005=\u0001\t\u0019&A\u0006sK\u0006$'+Z:pYZ,GCAA/!\u0011\ty&!\u001b\u000e\u0005\u0005\u0005$\u0002BA2\u0003K\nA\u0001\\1oO*\u0011\u0011qM\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002l\u0005\u0005$AB(cU\u0016\u001cG\u000f")
public class ArraySeq<A>
extends AbstractSeq<A>
implements IndexedSeq<A>,
scala.collection.mutable.IndexedSeqOptimized<A, ArraySeq<A>>,
CustomParallelizable<A, ParArray<A>>,
Serializable {
    public static final long serialVersionUID = 1530165946227428979L;
    private final int length;
    private final Object[] array;

    public static <A> CanBuildFrom<ArraySeq<?>, A, ArraySeq<A>> canBuildFrom() {
        return ArraySeq$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return ArraySeq$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)arraySeq$).newBuilder();
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
        return ArraySeq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ArraySeq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ tabulate_this = arraySeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ tabulate_this = arraySeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ tabulate_this = arraySeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ tabulate_this = arraySeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ArraySeq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ fill_this = arraySeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ fill_this = arraySeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ fill_this = arraySeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        ArraySeq$ fill_this = arraySeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ArraySeq$ arraySeq$ = ArraySeq$.MODULE$;
        if (arraySeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)arraySeq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ArraySeq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ArraySeq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ArraySeq$.MODULE$.empty();
    }

    @Override
    public Combiner<A, ParArray<A>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
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
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<ArraySeq<A>, Tuple2<A1, B>, That> bf) {
        return (That)IndexedSeqOptimized.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<ArraySeq<A>, Tuple2<A1, Object>, That> bf) {
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
    public Tuple2<ArraySeq<A>, ArraySeq<A>> splitAt(int n) {
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
    public Tuple2<ArraySeq<A>, ArraySeq<A>> span(Function1<A, Object> p) {
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
    public IndexedSeq<A> seq() {
        return IndexedSeq.seq$(this);
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
    public IndexedSeqView<A, ArraySeq<A>> view() {
        return scala.collection.mutable.IndexedSeqLike.view$(this);
    }

    @Override
    public IndexedSeqView<A, ArraySeq<A>> view(int from, int until) {
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
    public int length() {
        return this.length;
    }

    @Override
    public GenericCompanion<ArraySeq> companion() {
        return ArraySeq$.MODULE$;
    }

    public Object[] array() {
        return this.array;
    }

    @Override
    public ParArray<A> par() {
        return ParArray$.MODULE$.handoff(this.array(), this.length());
    }

    @Override
    public A apply(int idx) {
        if (idx >= this.length()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }
        return (A)this.array()[idx];
    }

    @Override
    public void update(int idx, A elem) {
        if (idx >= this.length()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }
        this.array()[idx] = elem;
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        for (int i = 0; i < this.length(); ++i) {
            f.apply(this.array()[i]);
        }
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int n = RichInt$.MODULE$.min$extension(len, ScalaRunTime$.MODULE$.array_length(xs) - start);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int len1 = RichInt$.MODULE$.min$extension(n, this.length());
        if (len1 > 0) {
            Array$.MODULE$.copy(this.array(), 0, xs, start, len1);
        }
    }

    @Override
    public ArraySeq<A> clone() {
        Object[] cloned = (Object[])this.array().clone();
        return new ArraySeq<A>(this, cloned){
            private final Object[] array;

            public Object[] array() {
                return this.array;
            }
            {
                this.array = cloned$1;
            }
        };
    }

    public ArraySeq(int length) {
        this.length = length;
        IndexedSeqLike.$init$(this);
        scala.collection.IndexedSeq.$init$(this);
        scala.collection.mutable.IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        IndexedSeqOptimized.$init$(this);
        CustomParallelizable.$init$(this);
        this.array = new Object[length];
    }
}

