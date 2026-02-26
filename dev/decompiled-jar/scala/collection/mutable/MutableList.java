/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.NoSuchElementException;
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
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.LinearSeq;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.List;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.Builder;
import scala.collection.mutable.LinkedList;
import scala.collection.mutable.MutableList$;
import scala.collection.mutable.Queue;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005=g\u0001B\u0014)\u0001=BQA\u0016\u0001\u0005\u0002]CQ\u0001\u0017\u0001\u0005BeCa!\u0018\u0001!\n#r\u0006bB0\u0001\u0001\u0004%\t\u0002\u0019\u0005\bI\u0002\u0001\r\u0011\"\u0005f\u0011\u0019Y\u0007\u0001)Q\u0005C\"9A\u000e\u0001a\u0001\n#\u0001\u0007bB7\u0001\u0001\u0004%\tB\u001c\u0005\u0007a\u0002\u0001\u000b\u0015B1\t\u000fE\u0004\u0001\u0019!C\te\"9a\u000f\u0001a\u0001\n#9\bBB=\u0001A\u0003&1\u000fC\u0003{\u0001\u0011\u00051\u0010\u0003\u0004\u0000\u0001\u0011\u0005\u0013\u0011\u0001\u0005\b\u0003\u0013\u0001A\u0011IA\u0006\u0011\u001d\ti\u0001\u0001C!\u0003\u001fAq!!\u0005\u0001\t+\t\u0019\u0002C\u0004\u0002\u001a\u0001!\t!a\u0007\t\r\u0005\r\u0002\u0001\"\u0011s\u0011\u001d\t)\u0003\u0001C!\u0003OAq!!\f\u0001\t\u0003\ty\u0003C\u0004\u00028\u0001!\t!!\u000f\t\u000f\u0005\r\u0003\u0001\"\u0005\u0002F!9\u0011\u0011\n\u0001\u0005\u0012\u0005-\u0003bBA(\u0001\u0011\u0005\u0013\u0011\u000b\u0005\b\u00033\u0002A\u0011IA\u0006\u0011\u001d\tY\u0006\u0001C!\u0003;Bq!a\u001b\u0001\t\u0003A\u0003\rC\u0004\u0002n\u0001!\t!a\u001c\t\u000f\u0005M\u0004\u0001\"\u0001\u0002v!1\u0011q\u000f\u0001\u0005\u0002]Ca!!\u001f\u0001\t\u0003:vaBADQ!\u0005\u0011\u0011\u0012\u0004\u0007O!B\t!a#\t\rY\u0013C\u0011AAJ\u0011\u001d\t)J\tC\u0002\u0003/Ca!\u0018\u0012\u0005\u0002\u0005=\u0006\"CA^E\u0005\u0005I\u0011BA_\u0005-iU\u000f^1cY\u0016d\u0015n\u001d;\u000b\u0005%R\u0013aB7vi\u0006\u0014G.\u001a\u0006\u0003W1\n!bY8mY\u0016\u001cG/[8o\u0015\u0005i\u0013!B:dC2\f7\u0001A\u000b\u0003a]\u001ar\u0001A\u0019B\t&\u00036\u000bE\u00023gUj\u0011\u0001K\u0005\u0003i!\u00121\"\u00112tiJ\f7\r^*fcB\u0011ag\u000e\u0007\u0001\t\u0015A\u0004A1\u0001:\u0005\u0005\t\u0015C\u0001\u001e?!\tYD(D\u0001-\u0013\tiDFA\u0004O_RD\u0017N\\4\u0011\u0005mz\u0014B\u0001!-\u0005\r\te.\u001f\t\u0004e\t+\u0014BA\")\u0005%a\u0015N\\3beN+\u0017\u000f\u0005\u0003F\rVBU\"\u0001\u0016\n\u0005\u001dS#A\u0005'j]\u0016\f'oU3r\u001fB$\u0018.\\5{K\u0012\u00042A\r\u00016!\u0011QU*N(\u000e\u0003-S!\u0001\u0014\u0016\u0002\u000f\u001d,g.\u001a:jG&\u0011aj\u0013\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u0003e\u0001\u0001BAM)6\u0011&\u0011!\u000b\u000b\u0002\b\u0005VLG\u000eZ3s!\tYD+\u0003\u0002VY\ta1+\u001a:jC2L'0\u00192mK\u00061A(\u001b8jiz\"\u0012\u0001S\u0001\nG>l\u0007/\u00198j_:,\u0012A\u0017\t\u0004\u0015n{\u0015B\u0001/L\u0005A9UM\\3sS\u000e\u001cu.\u001c9b]&|g.\u0001\u0006oK^\u0014U/\u001b7eKJ,\u0012\u0001U\u0001\u0007M&\u00148\u000f\u001e\u0019\u0016\u0003\u0005\u00042A\r26\u0013\t\u0019\u0007F\u0001\u0006MS:\\W\r\u001a'jgR\f!BZ5sgR\u0004t\fJ3r)\t1\u0017\u000e\u0005\u0002<O&\u0011\u0001\u000e\f\u0002\u0005+:LG\u000fC\u0004k\u000b\u0005\u0005\t\u0019A1\u0002\u0007a$\u0013'A\u0004gSJ\u001cH\u000f\r\u0011\u0002\u000b1\f7\u000f\u001e\u0019\u0002\u00131\f7\u000f\u001e\u0019`I\u0015\fHC\u00014p\u0011\u001dQ\u0007\"!AA\u0002\u0005\fa\u0001\\1tiB\u0002\u0013a\u00017f]V\t1\u000f\u0005\u0002<i&\u0011Q\u000f\f\u0002\u0004\u0013:$\u0018a\u00027f]~#S-\u001d\u000b\u0003MbDqA[\u0006\u0002\u0002\u0003\u00071/\u0001\u0003mK:\u0004\u0013a\u0002;p#V,W/Z\u000b\u0002yB\u0019!'`\u001b\n\u0005yD#!B)vKV,\u0017aB5t\u000b6\u0004H/_\u000b\u0003\u0003\u0007\u00012aOA\u0003\u0013\r\t9\u0001\f\u0002\b\u0005>|G.Z1o\u0003\u0011AW-\u00193\u0016\u0003U\nA\u0001^1jYV\t\u0001*\u0001\u0005uC&d\u0017*\u001c9m)\r1\u0017Q\u0003\u0005\u0007\u0003/\t\u0002\u0019\u0001%\u0002\u0005Qd\u0017A\u0004\u0013qYV\u001cH%Z9%G>dwN\u001c\u000b\u0005\u0003;\ty\"D\u0001\u0001\u0011\u0019\t\tC\u0005a\u0001k\u0005!Q\r\\3n\u0003\u0019aWM\\4uQ\u0006)\u0011\r\u001d9msR\u0019Q'!\u000b\t\r\u0005-B\u00031\u0001t\u0003\u0005q\u0017AB;qI\u0006$X\rF\u0003g\u0003c\t\u0019\u0004\u0003\u0004\u0002,U\u0001\ra\u001d\u0005\u0007\u0003k)\u0002\u0019A\u001b\u0002\u0003a\f1aZ3u)\u0011\tY$!\u0011\u0011\tm\ni$N\u0005\u0004\u0003\u007fa#AB(qi&|g\u000e\u0003\u0004\u0002,Y\u0001\ra]\u0001\faJ,\u0007/\u001a8e\u000b2,W\u000eF\u0002g\u0003\u000fBa!!\t\u0018\u0001\u0004)\u0014AC1qa\u0016tG-\u00127f[R\u0019a-!\u0014\t\r\u0005\u0005\u0002\u00041\u00016\u0003!IG/\u001a:bi>\u0014XCAA*!\u0011)\u0015QK\u001b\n\u0007\u0005]#F\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u0011a\u0017m\u001d;\u0002\rQ|G*[:u+\t\ty\u0006E\u0003\u0002b\u0005\u001dT'\u0004\u0002\u0002d)\u0019\u0011Q\r\u0016\u0002\u0013%lW.\u001e;bE2,\u0017\u0002BA5\u0003G\u0012A\u0001T5ti\u0006aAo\u001c'j].,G\rT5ti\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0003\u0002\u001e\u0005E\u0004BBA\u0011;\u0001\u0007Q'A\u0003dY\u0016\f'\u000fF\u0001g\u0003\u0019\u0011Xm];mi\u0006)1\r\\8oK\":\u0001!! \u0002\u0004\u0006\u0015\u0005cA\u001e\u0002\u0000%\u0019\u0011\u0011\u0011\u0017\u0003!M+'/[1m-\u0016\u00148/[8o+&#\u0015!\u0002<bYV,g\u0004\u0003*j=Kr\bQ\u0016a\u0002\u00175+H/\u00192mK2K7\u000f\u001e\t\u0003e\t\u001aBAIAG'B!!*a$P\u0013\r\t\tj\u0013\u0002\u000b'\u0016\fh)Y2u_JLHCAAE\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0011\tI*a+\u0016\u0005\u0005m\u0005#\u0003&\u0002\u001e\u0006\u0005\u0016\u0011VAW\u0013\r\tyj\u0013\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0005\u0003G\u000b)+D\u0001#\u0013\r\t9k\u0017\u0002\u0005\u0007>dG\u000eE\u00027\u0003W#Q\u0001\u000f\u0013C\u0002e\u0002BA\r\u0001\u0002*V!\u0011\u0011WA\\+\t\t\u0019\f\u0005\u00043#\u0006U\u0016\u0011\u0018\t\u0004m\u0005]F!\u0002\u001d&\u0005\u0004I\u0004\u0003\u0002\u001a\u0001\u0003k\u000b1B]3bIJ+7o\u001c7wKR\u0011\u0011q\u0018\t\u0005\u0003\u0003\fY-\u0004\u0002\u0002D*!\u0011QYAd\u0003\u0011a\u0017M\\4\u000b\u0005\u0005%\u0017\u0001\u00026bm\u0006LA!!4\u0002D\n1qJ\u00196fGR\u0004")
public class MutableList<A>
extends AbstractSeq<A>
implements scala.collection.mutable.LinearSeq<A>,
LinearSeqOptimized<A, MutableList<A>>,
Builder<A, MutableList<A>>,
Serializable {
    public static final long serialVersionUID = 5938451523372603072L;
    private LinkedList<A> first0;
    private LinkedList<A> last0;
    private int len;

    public static <A> CanBuildFrom<MutableList<?>, A, MutableList<A>> canBuildFrom() {
        return MutableList$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return MutableList$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)mutableList$).newBuilder();
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
        return MutableList$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return MutableList$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ tabulate_this = mutableList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ tabulate_this = mutableList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ tabulate_this = mutableList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ tabulate_this = mutableList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return MutableList$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ fill_this = mutableList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ fill_this = mutableList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ fill_this = mutableList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        MutableList$ fill_this = mutableList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        MutableList$ mutableList$ = MutableList$.MODULE$;
        if (mutableList$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)mutableList$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return MutableList$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return MutableList$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return MutableList$.MODULE$.empty();
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
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
    public <NewTo> Builder<A, NewTo> mapResult(Function1<MutableList<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public /* synthetic */ boolean scala$collection$LinearSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        LinearSeqOptimized.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return LinearSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return LinearSeqOptimized.exists$(this, p);
    }

    @Override
    public <A1> boolean contains(A1 elem) {
        return LinearSeqOptimized.contains$(this, elem);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return LinearSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)LinearSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)LinearSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)LinearSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)LinearSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public LinearSeqOptimized take(int n) {
        return LinearSeqOptimized.take$(this, n);
    }

    @Override
    public LinearSeqOptimized drop(int n) {
        return LinearSeqOptimized.drop$(this, n);
    }

    @Override
    public LinearSeqOptimized dropRight(int n) {
        return LinearSeqOptimized.dropRight$(this, n);
    }

    @Override
    public LinearSeqOptimized slice(int from, int until) {
        return LinearSeqOptimized.slice$(this, from, until);
    }

    @Override
    public LinearSeqOptimized takeWhile(Function1 p) {
        return LinearSeqOptimized.takeWhile$(this, p);
    }

    @Override
    public Tuple2<MutableList<A>, MutableList<A>> span(Function1<A, Object> p) {
        return LinearSeqOptimized.span$(this, p);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return LinearSeqOptimized.sameElements$(this, that);
    }

    @Override
    public int lengthCompare(int len) {
        return LinearSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public boolean isDefinedAt(int x) {
        return LinearSeqOptimized.isDefinedAt$(this, x);
    }

    @Override
    public int segmentLength(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p, int end) {
        return LinearSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Iterator<MutableList<A>> tails() {
        return LinearSeqOptimized.tails$(this);
    }

    @Override
    public scala.collection.mutable.LinearSeq<A> seq() {
        return scala.collection.mutable.LinearSeq.seq$(this);
    }

    @Override
    public LinearSeq<A> thisCollection() {
        return LinearSeqLike.thisCollection$(this);
    }

    @Override
    public LinearSeq toCollection(LinearSeqLike repr) {
        return LinearSeqLike.toCollection$(this, repr);
    }

    @Override
    public int hashCode() {
        return LinearSeqLike.hashCode$(this);
    }

    @Override
    public final <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return LinearSeqLike.corresponds$(this, that, p);
    }

    @Override
    public GenericCompanion<MutableList> companion() {
        return MutableList$.MODULE$;
    }

    @Override
    public Builder<A, MutableList<A>> newBuilder() {
        return new MutableList<A>();
    }

    public LinkedList<A> first0() {
        return this.first0;
    }

    public void first0_$eq(LinkedList<A> x$1) {
        this.first0 = x$1;
    }

    public LinkedList<A> last0() {
        return this.last0;
    }

    public void last0_$eq(LinkedList<A> x$1) {
        this.last0 = x$1;
    }

    public int len() {
        return this.len;
    }

    public void len_$eq(int x$1) {
        this.len = x$1;
    }

    public Queue<A> toQueue() {
        return new Queue<A>(this.first0(), this.last0(), this.len());
    }

    @Override
    public boolean isEmpty() {
        return this.len() == 0;
    }

    @Override
    public A head() {
        if (this.nonEmpty()) {
            return this.first0().head();
        }
        throw new NoSuchElementException();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public MutableList<A> tail() {
        void var1_1;
        MutableList<A> tl = new MutableList<A>();
        this.tailImpl(tl);
        return var1_1;
    }

    /*
     * WARNING - void declaration
     */
    public final void tailImpl(MutableList<A> tl) {
        void require_requirement;
        boolean bl = this.nonEmpty();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (require_requirement == false) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)MutableList.$anonfun$tailImpl$1()).toString());
        }
        tl.first0_$eq((LinkedList)this.first0().tail());
        tl.len_$eq(this.len() - 1);
        tl.last0_$eq(tl.len() == 0 ? tl.first0() : this.last0());
    }

    public MutableList<A> $plus$eq$colon(A elem) {
        this.prependElem(elem);
        return this;
    }

    @Override
    public int length() {
        return this.len();
    }

    @Override
    public A apply(int n) {
        return this.first0().apply(n);
    }

    @Override
    public void update(int n, A x) {
        this.first0().update(n, x);
    }

    public Option<A> get(int n) {
        return this.first0().get(n);
    }

    public void prependElem(A elem) {
        this.first0_$eq(new LinkedList<A>(elem, this.first0()));
        if (this.len() == 0) {
            this.last0_$eq(this.first0());
        }
        this.len_$eq(this.len() + 1);
    }

    public void appendElem(A elem) {
        if (this.len() == 0) {
            this.prependElem(elem);
            return;
        }
        this.last0().next_$eq((scala.collection.mutable.Seq)new LinkedList());
        this.last0_$eq((LinkedList)this.last0().next());
        this.last0().elem_$eq(elem);
        this.last0().next_$eq((scala.collection.mutable.Seq)new LinkedList());
        this.len_$eq(this.len() + 1);
    }

    @Override
    public Iterator<A> iterator() {
        if (this.isEmpty()) {
            return Iterator$.MODULE$.empty();
        }
        return new AbstractIterator<A>(this){
            private LinkedList<A> elems;
            private int count;

            private LinkedList<A> elems() {
                return this.elems;
            }

            private void elems_$eq(LinkedList<A> x$1) {
                this.elems = x$1;
            }

            private int count() {
                return this.count;
            }

            private void count_$eq(int x$1) {
                this.count = x$1;
            }

            public boolean hasNext() {
                return this.count() > 0 && this.elems().nonEmpty();
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                void var1_1;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                this.count_$eq(this.count() - 1);
                A e = this.elems().elem();
                this.elems_$eq(this.count() == 0 ? null : (LinkedList)this.elems().next());
                return var1_1;
            }
            {
                this.elems = $outer.first0();
                this.count = $outer.len();
            }
        };
    }

    @Override
    public A last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("MutableList.empty.last");
        }
        return this.last0().elem();
    }

    @Override
    public List<A> toList() {
        return this.first0().toList();
    }

    public LinkedList<A> toLinkedList() {
        return this.first0();
    }

    @Override
    public MutableList<A> $plus$eq(A elem) {
        this.appendElem(elem);
        return this;
    }

    @Override
    public void clear() {
        this.first0_$eq(new LinkedList());
        this.last0_$eq(this.first0());
        this.len_$eq(0);
    }

    @Override
    public MutableList<A> result() {
        return this;
    }

    @Override
    public MutableList<A> clone() {
        Builder<A, MutableList<A>> bf = this.newBuilder();
        bf.$plus$plus$eq(this.seq());
        return bf.result();
    }

    public static final /* synthetic */ String $anonfun$tailImpl$1() {
        return "tail of empty list";
    }

    public MutableList() {
        LinearSeqLike.$init$(this);
        LinearSeq.$init$(this);
        scala.collection.mutable.LinearSeq.$init$(this);
        LinearSeqOptimized.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
        this.first0 = new LinkedList();
        this.last0 = this.first0();
        this.len = 0;
    }
}

