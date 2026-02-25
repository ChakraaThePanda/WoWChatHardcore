/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Predef$;
import scala.Serializable;
import scala.collection.GenTraversable;
import scala.collection.IndexedSeq;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.NumericRange$;
import scala.collection.mutable.Builder;
import scala.math.Integral;
import scala.math.Numeric$IntIsIntegral$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\t\u0005e!\u0002\f\u0018\u0003\u0003q\u0002\"B \u0001\t\u0003\u0001\u0005B\u0002\"\u0001A\u0003%1\tC\u0003h\u0001\u0011\u0005\u0001N\u0002\u0003F\u0001\u00011\u0005\"B \u0005\t\u00039\u0006\"B-\u0005\t\u0003Q\u0006\"B-\u0005\t\u00031\u0007\"B5\u0001\t\u0003Q\u0007\"B<\u0001\t\u0003A\bBB<\u0001\t\u0003\t\t\u0002\u0003\u0004x\u0001\u0011\u0005\u00111\u0006\u0005\u0007o\u0002!\t!a\u0012\t\r]\u0004A\u0011AA4\u0011\u001d\tY\t\u0001C\u0001\u0003\u001bCq!a#\u0001\t\u0003\t)\u000bC\u0004\u0002\f\u0002!\t!a0\t\u000f\u0005-\u0005\u0001\"\u0001\u0002^\"9\u00111\u0012\u0001\u0005\u0002\u0005}\bb\u0002B\u0013\u0001\u0011\u0005!q\u0005\u0005\b\u0005K\u0001A\u0011\u0001B(\u0011\u001d\u0011I\u0007\u0001C\u0001\u0005W\u0012QcR3o)J\fg/\u001a:tC\ndWMR1di>\u0014\u0018P\u0003\u0002\u00193\u00059q-\u001a8fe&\u001c'B\u0001\u000e\u001c\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00029\u0005)1oY1mC\u000e\u0001QCA\u0010''\t\u0001\u0001\u0005E\u0002\"E\u0011j\u0011aF\u0005\u0003G]\u0011\u0001cR3oKJL7mQ8na\u0006t\u0017n\u001c8\u0011\u0005\u00152C\u0002\u0001\u0003\u0006O\u0001\u0011\r\u0001\u000b\u0002\u0003\u0007\u000e+\"!\u000b\u001c\u0012\u0005)r\u0003CA\u0016-\u001b\u0005Y\u0012BA\u0017\u001c\u0005\u001dqu\u000e\u001e5j]\u001e\u00142aL\u0019=\r\u0011\u0001\u0004\u0001\u0001\u0018\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0007I\u001aT'D\u0001\u001a\u0013\t!\u0014D\u0001\bHK:$&/\u0019<feN\f'\r\\3\u0011\u0005\u00152D!B\u001c'\u0005\u0004A$!\u0001-\u0012\u0005)J\u0004CA\u0016;\u0013\tY4DA\u0002B]f\u0004B!I\u001f6I%\u0011ah\u0006\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\u0005\u00032!\t\u0001%\u0003M\u0011V-^:bE2,7I\u0011$J]N$\u0018M\\2f!\r!EAK\u0007\u0002\u0001\t\u0019r)\u001a8fe&\u001c7)\u00198Ck&dGM\u0012:p[V\u0011q\tV\n\u0004\t![\u0005CA\u0016J\u0013\tQ5D\u0001\u0004B]f\u0014VM\u001a\t\u0006C1s5KV\u0005\u0003\u001b^\u0011AbQ1o\u0005VLG\u000e\u001a$s_6\u0004$aT)\u0011\u0007\u00152\u0003\u000b\u0005\u0002&#\u0012I!\u000bBA\u0001\u0002\u0003\u0015\t\u0001\u000f\u0002\u0004?\u0012\n\u0004CA\u0013U\t\u0015)FA1\u00019\u0005\u0005\t\u0005cA\u0013''R\t\u0001\fE\u0002E\tM\u000bQ!\u00199qYf$\"aW1\u0011\tq{6KV\u0007\u0002;*\u0011a,G\u0001\b[V$\u0018M\u00197f\u0013\t\u0001WLA\u0004Ck&dG-\u001a:\t\u000b\t4\u0001\u0019A2\u0002\t\u0019\u0014x.\u001c\t\u0003\t\u0012L!!\u001a\u0012\u0003\t\r{G\u000e\u001c\u000b\u00027\u0006Y!+Z;tC\ndWm\u0011\"G+\u0005\u0019\u0015AB2p]\u000e\fG/\u0006\u0002l]R\u0011An\u001c\t\u0004K\u0019j\u0007CA\u0013o\t\u0015)\u0006B1\u00019\u0011\u0015\u0001\b\u00021\u0001r\u0003\rA8o\u001d\t\u0004WI$\u0018BA:\u001c\u0005)a$/\u001a9fCR,GM\u0010\t\u0004eUl\u0017B\u0001<\u001a\u0005-!&/\u0019<feN\f'\r\\3\u0002\t\u0019LG\u000e\\\u000b\u0003sv$2A_A\u0004)\tYh\u0010E\u0002&Mq\u0004\"!J?\u0005\u000bUK!\u0019\u0001\u001d\t\u000f}LA\u00111\u0001\u0002\u0002\u0005!Q\r\\3n!\u0011Y\u00131\u0001?\n\u0007\u0005\u00151D\u0001\u0005=Eft\u0017-\\3?\u0011\u001d\tI!\u0003a\u0001\u0003\u0017\t\u0011A\u001c\t\u0004W\u00055\u0011bAA\b7\t\u0019\u0011J\u001c;\u0016\t\u0005M\u0011Q\u0004\u000b\u0007\u0003+\t\u0019#a\n\u0015\t\u0005]\u0011q\u0004\t\u0005K\u0019\nI\u0002\u0005\u0003&M\u0005m\u0001cA\u0013\u0002\u001e\u0011)QK\u0003b\u0001q!9qP\u0003CA\u0002\u0005\u0005\u0002#B\u0016\u0002\u0004\u0005m\u0001bBA\u0013\u0015\u0001\u0007\u00111B\u0001\u0003]FBq!!\u000b\u000b\u0001\u0004\tY!\u0001\u0002oeU!\u0011QFA\u001d)!\ty#a\u0010\u0002B\u0005\rC\u0003BA\u0019\u0003w\u0001B!\n\u0014\u00024A!QEJA\u001b!\u0011)c%a\u000e\u0011\u0007\u0015\nI\u0004B\u0003V\u0017\t\u0007\u0001\bC\u0004\u0000\u0017\u0011\u0005\r!!\u0010\u0011\u000b-\n\u0019!a\u000e\t\u000f\u0005\u00152\u00021\u0001\u0002\f!9\u0011\u0011F\u0006A\u0002\u0005-\u0001bBA#\u0017\u0001\u0007\u00111B\u0001\u0003]N*B!!\u0013\u0002XQQ\u00111JA/\u0003?\n\t'a\u0019\u0015\t\u00055\u0013\u0011\f\t\u0005K\u0019\ny\u0005\u0005\u0003&M\u0005E\u0003\u0003B\u0013'\u0003'\u0002B!\n\u0014\u0002VA\u0019Q%a\u0016\u0005\u000bUc!\u0019\u0001\u001d\t\u000f}dA\u00111\u0001\u0002\\A)1&a\u0001\u0002V!9\u0011Q\u0005\u0007A\u0002\u0005-\u0001bBA\u0015\u0019\u0001\u0007\u00111\u0002\u0005\b\u0003\u000bb\u0001\u0019AA\u0006\u0011\u001d\t)\u0007\u0004a\u0001\u0003\u0017\t!A\u001c\u001b\u0016\t\u0005%\u0014\u0011\u0010\u000b\r\u0003W\ny(!!\u0002\u0004\u0006\u0015\u0015q\u0011\u000b\u0005\u0003[\nY\b\u0005\u0003&M\u0005=\u0004\u0003B\u0013'\u0003c\u0002B!\n\u0014\u0002tA!QEJA;!\u0011)c%a\u001e\u0011\u0007\u0015\nI\bB\u0003V\u001b\t\u0007\u0001\bC\u0004\u0000\u001b\u0011\u0005\r!! \u0011\u000b-\n\u0019!a\u001e\t\u000f\u0005\u0015R\u00021\u0001\u0002\f!9\u0011\u0011F\u0007A\u0002\u0005-\u0001bBA#\u001b\u0001\u0007\u00111\u0002\u0005\b\u0003Kj\u0001\u0019AA\u0006\u0011\u001d\tI)\u0004a\u0001\u0003\u0017\t!A\\\u001b\u0002\u0011Q\f'-\u001e7bi\u0016,B!a$\u0002\u0018R!\u0011\u0011SAR)\u0011\t\u0019*!'\u0011\t\u00152\u0013Q\u0013\t\u0004K\u0005]E!B+\u000f\u0005\u0004A\u0004bBAN\u001d\u0001\u0007\u0011QT\u0001\u0002MB91&a(\u0002\f\u0005U\u0015bAAQ7\tIa)\u001e8di&|g.\r\u0005\b\u0003\u0013q\u0001\u0019AA\u0006+\u0011\t9+!-\u0015\r\u0005%\u00161XA_)\u0011\tY+a-\u0011\t\u00152\u0013Q\u0016\t\u0005K\u0019\ny\u000bE\u0002&\u0003c#Q!V\bC\u0002aBq!a'\u0010\u0001\u0004\t)\fE\u0005,\u0003o\u000bY!a\u0003\u00020&\u0019\u0011\u0011X\u000e\u0003\u0013\u0019+hn\u0019;j_:\u0014\u0004bBA\u0013\u001f\u0001\u0007\u00111\u0002\u0005\b\u0003Sy\u0001\u0019AA\u0006+\u0011\t\t-!4\u0015\u0011\u0005\r\u0017q[Am\u00037$B!!2\u0002PB!QEJAd!\u0011)c%!3\u0011\t\u00152\u00131\u001a\t\u0004K\u00055G!B+\u0011\u0005\u0004A\u0004bBAN!\u0001\u0007\u0011\u0011\u001b\t\fW\u0005M\u00171BA\u0006\u0003\u0017\tY-C\u0002\u0002Vn\u0011\u0011BR;oGRLwN\\\u001a\t\u000f\u0005\u0015\u0002\u00031\u0001\u0002\f!9\u0011\u0011\u0006\tA\u0002\u0005-\u0001bBA#!\u0001\u0007\u00111B\u000b\u0005\u0003?\fi\u000f\u0006\u0006\u0002b\u0006]\u0018\u0011`A~\u0003{$B!a9\u0002pB!QEJAs!\u0011)c%a:\u0011\t\u00152\u0013\u0011\u001e\t\u0005K\u0019\nY\u000fE\u0002&\u0003[$Q!V\tC\u0002aBq!a'\u0012\u0001\u0004\t\t\u0010E\u0007,\u0003g\fY!a\u0003\u0002\f\u0005-\u00111^\u0005\u0004\u0003k\\\"!\u0003$v]\u000e$\u0018n\u001c85\u0011\u001d\t)#\u0005a\u0001\u0003\u0017Aq!!\u000b\u0012\u0001\u0004\tY\u0001C\u0004\u0002FE\u0001\r!a\u0003\t\u000f\u0005\u0015\u0014\u00031\u0001\u0002\fU!!\u0011\u0001B\t)1\u0011\u0019Aa\u0007\u0003\u001e\t}!\u0011\u0005B\u0012)\u0011\u0011)Aa\u0005\u0011\t\u00152#q\u0001\t\u0005K\u0019\u0012I\u0001\u0005\u0003&M\t-\u0001\u0003B\u0013'\u0005\u001b\u0001B!\n\u0014\u0003\u0010A\u0019QE!\u0005\u0005\u000bU\u0013\"\u0019\u0001\u001d\t\u000f\u0005m%\u00031\u0001\u0003\u0016Ay1Fa\u0006\u0002\f\u0005-\u00111BA\u0006\u0003\u0017\u0011y!C\u0002\u0003\u001am\u0011\u0011BR;oGRLwN\\\u001b\t\u000f\u0005\u0015\"\u00031\u0001\u0002\f!9\u0011\u0011\u0006\nA\u0002\u0005-\u0001bBA#%\u0001\u0007\u00111\u0002\u0005\b\u0003K\u0012\u0002\u0019AA\u0006\u0011\u001d\tII\u0005a\u0001\u0003\u0017\tQA]1oO\u0016,BA!\u000b\u00032Q1!1\u0006B$\u0005\u0017\"BA!\f\u00036A!QE\nB\u0018!\r)#\u0011\u0007\u0003\u0007\u0005g\u0019\"\u0019\u0001\u001d\u0003\u0003QC\u0011Ba\u000e\u0014\u0003\u0003\u0005\u001dA!\u000f\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$\u0013\u0007\u0005\u0004\u0003<\t\u0005#q\u0006\b\u0004W\tu\u0012b\u0001B 7\u00059\u0001/Y2lC\u001e,\u0017\u0002\u0002B\"\u0005\u000b\u0012\u0001\"\u00138uK\u001e\u0014\u0018\r\u001c\u0006\u0004\u0005\u007fY\u0002b\u0002B%'\u0001\u0007!qF\u0001\u0006gR\f'\u000f\u001e\u0005\b\u0005\u001b\u001a\u0002\u0019\u0001B\u0018\u0003\r)g\u000eZ\u000b\u0005\u0005#\u0012I\u0006\u0006\u0005\u0003T\t\u0005$1\rB3)\u0011\u0011)Fa\u0017\u0011\t\u00152#q\u000b\t\u0004K\teCA\u0002B\u001a)\t\u0007\u0001\bC\u0005\u0003^Q\t\t\u0011q\u0001\u0003`\u0005QQM^5eK:\u001cW\r\n\u001a\u0011\r\tm\"\u0011\tB,\u0011\u001d\u0011I\u0005\u0006a\u0001\u0005/BqA!\u0014\u0015\u0001\u0004\u00119\u0006C\u0004\u0003hQ\u0001\rAa\u0016\u0002\tM$X\r]\u0001\bSR,'/\u0019;f+\u0011\u0011iG!\u001e\u0015\r\t=$1\u0010B?)\u0011\u0011\tHa\u001e\u0011\t\u00152#1\u000f\t\u0004K\tUD!B+\u0016\u0005\u0004A\u0004bBAN+\u0001\u0007!\u0011\u0010\t\bW\u0005}%1\u000fB:\u0011\u001d\u0011I%\u0006a\u0001\u0005gBqAa \u0016\u0001\u0004\tY!A\u0002mK:\u0004")
public abstract class GenTraversableFactory<CC extends GenTraversable<Object>>
extends GenericCompanion<CC> {
    private final GenericCanBuildFrom<Nothing$> ReusableCBFInstance = new GenericCanBuildFrom<Nothing$>(this){
        private final /* synthetic */ GenTraversableFactory $outer;

        public Builder<Nothing$, CC> apply() {
            return this.$outer.newBuilder();
        }
        {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    };

    public GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return this.ReusableCBFInstance;
    }

    public <A> CC concat(Seq<Traversable<A>> xss) {
        Builder b = this.newBuilder();
        if (xss.forall((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(GenTraversableFactory.$anonfun$concat$1(x$1)))) {
            b.sizeHint(BoxesRunTime.unboxToInt(((TraversableOnce)xss.map((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToInteger(x$2.size()), Seq$.MODULE$.canBuildFrom())).sum(Numeric$IntIsIntegral$.MODULE$)));
        }
        xss.seq().foreach((Function1<Traversable, Builder> & java.io.Serializable & Serializable)xs -> (Builder)b.$plus$plus$eq(xs));
        return (CC)((GenTraversable)b.result());
    }

    public <A> CC fill(int n, Function0<A> elem) {
        Builder b = this.newBuilder();
        b.sizeHint(n);
        for (int i = 0; i < n; ++i) {
            b.$plus$eq(elem.apply());
        }
        return (CC)((GenTraversable)b.result());
    }

    public <A> CC fill(int n1, int n2, Function0<A> elem) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)x$3 -> this.fill(n2, elem));
    }

    public <A> CC fill(int n1, int n2, int n3, Function0<A> elem) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)x$4 -> this.fill(n2, n3, elem));
    }

    public <A> CC fill(int n1, int n2, int n3, int n4, Function0<A> elem) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)x$5 -> this.fill(n2, n3, n4, elem));
    }

    public <A> CC fill(int n1, int n2, int n3, int n4, int n5, Function0<A> elem) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)x$6 -> this.fill(n2, n3, n4, n5, elem));
    }

    public <A> CC tabulate(int n, Function1<Object, A> f) {
        Builder b = this.newBuilder();
        b.sizeHint(n);
        for (int i = 0; i < n; ++i) {
            b.$plus$eq(f.apply(BoxesRunTime.boxToInteger(i)));
        }
        return (CC)((GenTraversable)b.result());
    }

    public <A> CC tabulate(int n1, int n2, Function2<Object, Object, A> f) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)i1 -> {
            int $anonfun$tabulate$1_i1 = BoxesRunTime.unboxToInt(i1);
            return this.tabulate(n2, (Function1<Object, Object> & java.io.Serializable & Serializable)x$7 -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$7))));
        });
    }

    public <A> CC tabulate(int n1, int n2, int n3, Function3<Object, Object, Object, A> f) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)i1 -> {
            int $anonfun$tabulate$3_i1 = BoxesRunTime.unboxToInt(i1);
            return this.tabulate(n2, n3, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x$8, x$9) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$8)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$9))));
        });
    }

    public <A> CC tabulate(int n1, int n2, int n3, int n4, Function4<Object, Object, Object, Object, A> f) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)i1 -> {
            int $anonfun$tabulate$5_i1 = BoxesRunTime.unboxToInt(i1);
            return this.tabulate(n2, n3, n4, (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$10, x$11, x$12) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$10)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$11)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$12))));
        });
    }

    public <A> CC tabulate(int n1, int n2, int n3, int n4, int n5, Function5<Object, Object, Object, Object, Object, A> f) {
        return this.tabulate(n1, (Function1<Object, GenTraversable> & java.io.Serializable & Serializable)i1 -> {
            int $anonfun$tabulate$7_i1 = BoxesRunTime.unboxToInt(i1);
            return this.tabulate(n2, n3, n4, n5, (Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$13, x$14, x$15, x$16) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$13)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$14)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$15)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$16))));
        });
    }

    public <T> CC range(T start, T end, Integral<T> evidence$1) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return this.range(start, end, evidence$1.one(), evidence$1);
    }

    public <T> CC range(T start, T end, T step, Integral<T> evidence$2) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Integral<T> num = evidence$2;
        if (BoxesRunTime.equals(step, num.zero())) {
            throw new IllegalArgumentException("zero step");
        }
        Builder b = this.newBuilder();
        b.sizeHint(NumericRange$.MODULE$.count(start, end, step, false, evidence$2));
        T i = start;
        while (num.mkOrderingOps(step).$less(num.zero()) ? num.mkOrderingOps(end).$less(i) : num.mkOrderingOps(i).$less(end)) {
            b.$plus$eq(i);
            i = num.mkNumericOps(i).$plus(step);
        }
        return (CC)((GenTraversable)b.result());
    }

    public <A> CC iterate(A start, int len, Function1<A, A> f) {
        Builder b = this.newBuilder();
        if (len > 0) {
            b.sizeHint(len);
            A acc = start;
            b.$plus$eq(start);
            for (int i = 1; i < len; ++i) {
                acc = f.apply(acc);
                b.$plus$eq(acc);
            }
        }
        return (CC)((GenTraversable)b.result());
    }

    public static final /* synthetic */ boolean $anonfun$concat$1(Traversable x$1) {
        return x$1 instanceof IndexedSeq;
    }

    public static final /* synthetic */ GenTraversable $anonfun$fill$1(GenTraversableFactory $this, int n2$1, Function0 elem$1, int x$3) {
        return $this.fill(n2$1, elem$1);
    }

    public static final /* synthetic */ GenTraversable $anonfun$fill$2(GenTraversableFactory $this, int n2$2, int n3$1, Function0 elem$2, int x$4) {
        return $this.fill(n2$2, n3$1, elem$2);
    }

    public static final /* synthetic */ GenTraversable $anonfun$fill$3(GenTraversableFactory $this, int n2$3, int n3$2, int n4$1, Function0 elem$3, int x$5) {
        return $this.fill(n2$3, n3$2, n4$1, elem$3);
    }

    public static final /* synthetic */ GenTraversable $anonfun$fill$4(GenTraversableFactory $this, int n2$4, int n3$3, int n4$2, int n5$1, Function0 elem$4, int x$6) {
        return $this.fill(n2$4, n3$3, n4$2, n5$1, elem$4);
    }

    public static final /* synthetic */ GenTraversable $anonfun$tabulate$1(GenTraversableFactory $this, int n2$5, Function2 f$1, int i1) {
        return $this.tabulate(n2$5, (Function1<Object, Object> & java.io.Serializable & Serializable)x$7 -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$7))));
    }

    public static final /* synthetic */ GenTraversable $anonfun$tabulate$3(GenTraversableFactory $this, int n2$6, int n3$4, Function3 f$2, int i1) {
        return $this.tabulate(n2$6, n3$4, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x$8, x$9) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$8)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$9))));
    }

    public static final /* synthetic */ GenTraversable $anonfun$tabulate$5(GenTraversableFactory $this, int n2$7, int n3$5, int n4$3, Function4 f$3, int i1) {
        return $this.tabulate(n2$7, n3$5, n4$3, (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$10, x$11, x$12) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$10)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$11)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$12))));
    }

    public static final /* synthetic */ GenTraversable $anonfun$tabulate$7(GenTraversableFactory $this, int n2$8, int n3$6, int n4$4, int n5$2, Function5 f$4, int i1) {
        return $this.tabulate(n2$8, n3$6, n4$4, n5$2, (Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$13, x$14, x$15, x$16) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$13)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$14)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$15)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$16))));
    }

    public class GenericCanBuildFrom<A>
    implements CanBuildFrom<CC, A, CC> {
        @Override
        public Builder<A, CC> apply(CC from) {
            return from.genericBuilder();
        }

        @Override
        public Builder<A, CC> apply() {
            return this.scala$collection$generic$GenTraversableFactory$GenericCanBuildFrom$$$outer().newBuilder();
        }

        public /* synthetic */ GenTraversableFactory scala$collection$generic$GenTraversableFactory$GenericCanBuildFrom$$$outer() {
            return GenTraversableFactory.this;
        }

        public GenericCanBuildFrom() {
            if (GenTraversableFactory.this == null) {
                throw null;
            }
        }
    }
}

