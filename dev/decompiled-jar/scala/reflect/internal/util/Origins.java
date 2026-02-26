/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.Map;
import scala.math.Ordering;
import scala.math.Ordering$Int$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.Origins$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.java8.JFunction2$mcJJI$sp;

@ScalaSignature(bytes="\u0006\u0001\t\u001dg!B&M\u0003\u0003)\u0006\"\u0002.\u0001\t\u0003YF!\u00020\u0001\u0005\u0003yV\u0001\u00024\u0001\u0001\u001dDQA\u001d\u0001\u0007\u0002MDaa \u0001\u0007\u0002\u0005\u0005\u0001bBA\u0007\u0001\u0019\u0005\u0011q\u0002\u0005\b\u00037\u0001a\u0011AA\u000f\u0011%\t\u0019\u0003\u0001b\u0001\n\u0013\t)\u0003\u0003\u0005\u0002>\u0001\u0001\u000b\u0011BA\u0014\u0011\u001d\ty\u0004\u0001C\u0005\u0003\u0003Bq!a\u0013\u0001\t\u0013\ti\u0005C\u0004\u0002V\u0001!\t!a\u0016\t\u000f\u0005e\u0003\u0001\"\u0001\u0002\\!9\u0011\u0011\u000f\u0001\u0005\u0002\u0005M\u0004bBA;\u0001\u0011\u0005\u00111\u000f\u0005\b\u0003o\u0002A\u0011AA:\u000f\u001d\tI\b\u0014E\u0001\u0003w2aa\u0013'\t\u0002\u0005u\u0004B\u0002.\u0013\t\u0003\ty\bC\u0005\u0002\u0002J\u0011\r\u0011\"\u0003\u0002\u0004\"A\u00111\u0012\n!\u0002\u0013\t)\tC\u0005\u0002\u000eJ\u0011\r\u0011\"\u0003\u0002\u0010\"A\u0011Q\u0013\n!\u0002\u0013\t\tJ\u0002\u0004\u0002\u0018J\u0001\u0015\u0011\u0014\u0005\n\u0003OC\"Q3A\u0005\u0002MD\u0011\"!+\u0019\u0005#\u0005\u000b\u0011\u0002;\t\u0013\u0005-\u0006D!f\u0001\n\u0003\u0019\b\"CAW1\tE\t\u0015!\u0003u\u0011\u0019Q\u0006\u0004\"\u0001\u00020\"9\u0011\u0011\u0018\r\u0005\u0002\u0005m\u0006\"CA`1\u0005\u0005I\u0011AAa\u0011%\t9\rGI\u0001\n\u0003\tI\rC\u0005\u0002`b\t\n\u0011\"\u0001\u0002J\"I\u0011\u0011\u001d\r\u0002\u0002\u0013\u0005\u0013q\u0012\u0005\n\u0003GD\u0012\u0011!C\u0001\u0003KD\u0011\"a:\u0019\u0003\u0003%\t!!;\t\u0013\u0005=\b$!A\u0005B\u0005E\b\"CA~1\u0005\u0005I\u0011AA\u007f\u0011%\u0011\t\u0001GA\u0001\n\u0003\u0012\u0019\u0001C\u0005\u0003\u0006a\t\t\u0011\"\u0011\u0003\b!I!\u0011\u0002\r\u0002\u0002\u0013\u0005#1B\u0004\n\u0005\u001f\u0011\u0012\u0011!E\u0001\u0005#1\u0011\"a&\u0013\u0003\u0003E\tAa\u0005\t\ri[C\u0011\u0001B\u0011\u0011%\u0011)aKA\u0001\n\u000b\u00129\u0001C\u0005\u0002Z-\n\t\u0011\"!\u0003$!I!\u0011F\u0016\u0002\u0002\u0013\u0005%1\u0006\u0005\n\u0005{Y\u0013\u0011!C\u0005\u0005\u007fAqAa\u0012\u0013\t\u0003\u0011I\u0005C\u0004\u0003XI!\tA!\u0017\t\u000f\t}#\u0003\"\u0003\u0003b!9!Q\r\n\u0005\n\t\u001d\u0004bBA-%\u0011\u0005!\u0011\u000e\u0005\b\u00033\u0012B\u0011\u0001B7\r\u0019\u0011)H\u0005\u0001\u0003x!A!o\u000eBC\u0002\u0013\u00051\u000fC\u0005\u0003z]\u0012\t\u0011)A\u0005i\"Q!1P\u001c\u0003\u0002\u0003\u0006I!!-\t\ri;D\u0011\u0001B?\u000b\u0011qv\u0007\u00016\t\r}<D\u0011\u0001BC\u0011\u001d\tia\u000eC\u0001\u0005\u0013Cq!a\u00078\t\u0003\u0011\u0019J\u0002\u0004\u0003\u0018J\u0001!\u0011\u0014\u0005\te\u0002\u0013)\u0019!C\u0001g\"I!\u0011\u0010!\u0003\u0002\u0003\u0006I\u0001\u001e\u0005\u000b\u0005w\u0002%\u0011!Q\u0001\n\u0005E\u0006B\u0003BN\u0001\n\u0005\t\u0015!\u0003\u00028!1!\f\u0011C\u0001\u0005;+QA\u0018!\u0001\u0005OCaa !\u0005\u0002\tU\u0006bBA\u0007\u0001\u0012\u0005!\u0011\u0018\u0005\b\u00037\u0001E\u0011\u0001Bb\u0011\u001d\t)\u0006\u0011C!\u0003/\u0012qa\u0014:jO&t7O\u0003\u0002N\u001d\u0006!Q\u000f^5m\u0015\ty\u0005+\u0001\u0005j]R,'O\\1m\u0015\t\t&+A\u0004sK\u001adWm\u0019;\u000b\u0003M\u000bQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001-B\u0011q\u000bW\u0007\u0002%&\u0011\u0011L\u0015\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005a\u0006CA/\u0001\u001b\u0005a%a\u0001*faF\u0011\u0001m\u0019\t\u0003/\u0006L!A\u0019*\u0003\u000f9{G\u000f[5oOB\u0011q\u000bZ\u0005\u0003KJ\u00131!\u00118z\u0005)\u0019F/Y2l'2L7-\u001a\t\u0004/\"T\u0017BA5S\u0005\u0015\t%O]1z!\tY\u0007/D\u0001m\u0015\tig.\u0001\u0003mC:<'\"A8\u0002\t)\fg/Y\u0005\u0003c2\u0014\u0011c\u0015;bG.$&/Y2f\u000b2,W.\u001a8u\u0003\r!\u0018mZ\u000b\u0002iB\u0011Q\u000f \b\u0003mj\u0004\"a\u001e*\u000e\u0003aT!!\u001f+\u0002\rq\u0012xn\u001c;?\u0013\tY(+\u0001\u0004Qe\u0016$WMZ\u0005\u0003{z\u0014aa\u0015;sS:<'BA>S\u0003!I7oQ;u_\u001a4G\u0003BA\u0002\u0003\u0013\u00012aVA\u0003\u0013\r\t9A\u0015\u0002\b\u0005>|G.Z1o\u0011\u0019\tY!\u0002a\u0001U\u0006\u0011Q\r\\\u0001\u0007]\u0016<(+\u001a9\u0015\t\u0005E\u0011Q\u0003\t\u0004\u0003'\u0011Q\"\u0001\u0001\t\u000f\u0005]a\u00011\u0001\u0002\u001a\u0005\u0011\u0001p\u001d\t\u0004\u0003'\u0019\u0011!\u0003:faN#(/\u001b8h)\r!\u0018q\u0004\u0005\b\u0003C9\u0001\u0019AA\t\u0003\r\u0011X\r]\u0001\b_JLw-\u001b8t+\t\t9\u0003\u0005\u0005\u0002*\u0005M\u0012\u0011CA\u001c\u001b\t\tYC\u0003\u0003\u0002.\u0005=\u0012aB7vi\u0006\u0014G.\u001a\u0006\u0004\u0003c\u0011\u0016AC2pY2,7\r^5p]&!\u0011QGA\u0016\u0005\ri\u0015\r\u001d\t\u0004/\u0006e\u0012bAA\u001e%\n\u0019\u0011J\u001c;\u0002\u0011=\u0014\u0018nZ5og\u0002\n1!\u00193e)\u0011\t\u0019%!\u0013\u0011\u0007]\u000b)%C\u0002\u0002HI\u0013A!\u00168ji\"9\u0011q\u0003\u0006A\u0002\u0005E\u0011!\u0002;pi\u0006dWCAA(!\r9\u0016\u0011K\u0005\u0004\u0003'\u0012&\u0001\u0002'p]\u001e\f\u0011B]3bIN#\u0018mY6\u0015\u0003\u001d\fQ!\u00199qYf,B!!\u0018\u0002dQ!\u0011qLA4!\u0011\t\t'a\u0019\r\u0001\u00111\u0011QM\u0007C\u0002}\u0013\u0011\u0001\u0016\u0005\t\u0003SjA\u00111\u0001\u0002l\u0005!!m\u001c3z!\u00159\u0016QNA0\u0013\r\tyG\u0015\u0002\ty\tLh.Y7f}\u0005)1\r\\3beR\u0011\u00111I\u0001\u0005g\"|w/A\u0003qkJ<W-A\u0004Pe&<\u0017N\\:\u0011\u0005u\u00132C\u0001\nW)\t\tY(\u0001\u0005d_VtG/\u001a:t+\t\t)\t\u0005\u0004\u0002*\u0005\u001dE\u000fX\u0005\u0005\u0003\u0013\u000bYCA\u0004ICNDW*\u00199\u0002\u0013\r|WO\u001c;feN\u0004\u0013!\u0003;iSN\u001cE.Y:t+\t\t\t\nE\u0002l\u0003'K!! 7\u0002\u0015QD\u0017n]\"mCN\u001c\bE\u0001\u0005Pe&<\u0017N\\%e'\u0019Ab+a'\u0002\"B\u0019q+!(\n\u0007\u0005}%KA\u0004Qe>$Wo\u0019;\u0011\u0007]\u000b\u0019+C\u0002\u0002&J\u0013AbU3sS\u0006d\u0017N_1cY\u0016\f\u0011b\u00197bgNt\u0015-\\3\u0002\u0015\rd\u0017m]:OC6,\u0007%\u0001\u0006nKRDw\u000e\u001a(b[\u0016\f1\"\\3uQ>$g*Y7fAQ1\u0011\u0011WA[\u0003o\u00032!a-\u0019\u001b\u0005\u0011\u0002BBAT;\u0001\u0007A\u000f\u0003\u0004\u0002,v\u0001\r\u0001^\u0001\b[\u0006$8\r[3t)\u0011\t\u0019!!0\t\r\u0005-a\u00041\u0001k\u0003\u0011\u0019w\u000e]=\u0015\r\u0005E\u00161YAc\u0011!\t9k\bI\u0001\u0002\u0004!\b\u0002CAV?A\u0005\t\u0019\u0001;\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\u0011\u00111\u001a\u0016\u0004i\u000657FAAh!\u0011\t\t.a7\u000e\u0005\u0005M'\u0002BAk\u0003/\f\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0007\u0005e'+\u0001\u0006b]:|G/\u0019;j_:LA!!8\u0002T\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%e\u0005i\u0001O]8ek\u000e$\bK]3gSb\fA\u0002\u001d:pIV\u001cG/\u0011:jif,\"!a\u000e\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u00191-a;\t\u0013\u00055H%!AA\u0002\u0005]\u0012a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/\u0006\u0002\u0002tB)\u0011Q_A|G6\u0011\u0011qF\u0005\u0005\u0003s\fyC\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dG\u0003BA\u0002\u0003\u007fD\u0001\"!<'\u0003\u0003\u0005\raY\u0001\tQ\u0006\u001c\bnQ8eKR\u0011\u0011qG\u0001\ti>\u001cFO]5oOR\u0011\u0011\u0011S\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005\r!Q\u0002\u0005\t\u0003[L\u0013\u0011!a\u0001G\u0006AqJ]5hS:LE\rE\u0002\u00024.\u001aRa\u000bB\u000b\u0003C\u0003\u0002Ba\u0006\u0003\u001eQ$\u0018\u0011W\u0007\u0003\u00053Q1Aa\u0007S\u0003\u001d\u0011XO\u001c;j[\u0016LAAa\b\u0003\u001a\t\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0005\tEACBAY\u0005K\u00119\u0003\u0003\u0004\u0002(:\u0002\r\u0001\u001e\u0005\u0007\u0003Ws\u0003\u0019\u0001;\u0002\u000fUt\u0017\r\u001d9msR!!Q\u0006B\u001d!\u00159&q\u0006B\u001a\u0013\r\u0011\tD\u0015\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u000b]\u0013)\u0004\u001e;\n\u0007\t]\"K\u0001\u0004UkBdWM\r\u0005\n\u0005wy\u0013\u0011!a\u0001\u0003c\u000b1\u0001\u001f\u00131\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\t\u0005\u0003cA6\u0003D%\u0019!Q\t7\u0003\r=\u0013'.Z2u\u0003\u0019awn\\6vaR)ALa\u0013\u0003N!)!/\ra\u0001i\"9!qJ\u0019A\u0002\tE\u0013AB8s\u000b2\u001cX\rE\u0003X\u0005'\"H,C\u0002\u0003VI\u0013\u0011BR;oGRLwN\\\u0019\u0002\u0011I,w-[:uKJ$2\u0001\u0018B.\u0011\u0019\u0011iF\ra\u00019\u0006\t\u00010A\u0005qe\u0016\u001cU\u000f^8gMR!\u00111\u0001B2\u0011\u0019\tYa\ra\u0001U\u0006Qa-\u001b8e\u0007V$xN\u001a4\u0015\u0005\u0005EFc\u0001/\u0003l!)!/\u000ea\u0001iR)ALa\u001c\u0003r!)!O\u000ea\u0001i\"9!1\u000f\u001cA\u0002\u0005]\u0012A\u00024sC6,7OA\u0004P]\u0016d\u0015N\\3\u0014\u0005]b\u0016\u0001\u0002;bO\u0002\n!!\u001b3\u0015\r\t}$\u0011\u0011BB!\r\t\u0019l\u000e\u0005\u0006en\u0002\r\u0001\u001e\u0005\b\u0005wZ\u0004\u0019AAY)\u0011\t\u0019Aa\"\t\r\u0005-Q\b1\u0001k)\u0011\u0011YIa$\u0011\u0007\t5E(D\u00018\u0011\u001d\t9B\u0010a\u0001\u0005#\u00032A!$\u0004)\u0011\t\tJ!&\t\u000f\u0005\u0005r\b1\u0001\u0003\f\nIQ*\u001e7uS2Kg.Z\n\u0003\u0001r\u000b\u0001B\\;n\u0019&tWm\u001d\u000b\t\u0005?\u0013\tKa)\u0003&B\u0019\u00111\u0017!\t\u000bI,\u0005\u0019\u0001;\t\u000f\tmT\t1\u0001\u00022\"9!1T#A\u0002\u0005]\u0002#\u0002BU\u0005_SgbA,\u0003,&\u0019!Q\u0016*\u0002\u000fA\f7m[1hK&!!\u0011\u0017BZ\u0005\u0011a\u0015n\u001d;\u000b\u0007\t5&\u000b\u0006\u0003\u0002\u0004\t]\u0006BBA\u0006\u000f\u0002\u0007!\u000e\u0006\u0003\u0003<\n}\u0006c\u0001B_\r6\t\u0001\tC\u0004\u0002\u0018!\u0003\rA!1\u0011\u0007\tu6\u0001F\u0002u\u0005\u000bDq!!\tJ\u0001\u0004\u0011Y\f")
public abstract class Origins {
    private final Map<Object, Object> origins = new HashMap().withDefaultValue(BoxesRunTime.boxToInteger(0));

    public static Origins register(Origins origins) {
        return Origins$.MODULE$.register(origins);
    }

    public static Origins lookup(String string, Function1<String, Origins> function1) {
        return Origins$.MODULE$.lookup(string, function1);
    }

    public abstract String tag();

    public abstract boolean isCutoff(StackTraceElement var1);

    public abstract Object newRep(StackTraceElement[] var1);

    public abstract String repString(Object var1);

    private Map<Object, Object> origins() {
        return this.origins;
    }

    private void add(Object xs) {
        this.origins().update(xs, BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(this.origins().apply(xs)) + 1));
    }

    private long total() {
        return BoxesRunTime.unboxToLong(this.origins().values().foldLeft(BoxesRunTime.boxToLong(0L), (JFunction2$mcJJI$sp & Serializable)(x$1, x$2) -> x$1 + (long)x$2));
    }

    /*
     * WARNING - void declaration
     */
    public StackTraceElement[] readStack() {
        void dropWhile_p;
        Function1<StackTraceElement, Object> & java.io.Serializable & Serializable dropWhile_p2 = (Function1<StackTraceElement, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(Origins.$anonfun$readStack$1(this, x));
        ArrayOps.ofRef<Object> dropWhile_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])Thread.currentThread().getStackTrace()));
        Function1<StackTraceElement, Object> & java.io.Serializable & Serializable intersect = (Function1<StackTraceElement, Object> & java.io.Serializable & Serializable)el -> BoxesRunTime.boxToBoolean(this.isCutoff(el));
        ArrayOps.ofRef<Object> dropWhile_this2 = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])dropWhile_this.drop(dropWhile_this.prefixLength(dropWhile_p2))));
        return (StackTraceElement[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])dropWhile_this2.drop(dropWhile_this2.prefixLength(dropWhile_p)))).drop(1);
    }

    public <T> T apply(Function0<T> body) {
        this.add(this.newRep(this.readStack()));
        return body.apply();
    }

    public void clear() {
        this.origins().clear();
    }

    public void show() {
        String string = "\n>> Origins tag '%s' logged %s calls from %s distinguished sources.\n";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Predef$.MODULE$.println(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.tag(), BoxesRunTime.boxToLong(this.total()), BoxesRunTime.boxToInteger(this.origins().keys().size())})));
        List list = (List)this.origins().toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToInteger(Origins.$anonfun$show$1(x$3)), (Ordering)Ordering$Int$.MODULE$);
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Tuple2 tuple2 = (Tuple2)foreach_these.head();
            Origins.$anonfun$show$2(this, tuple2);
            foreach_these = (List)foreach_these.tail();
        }
    }

    public void purge() {
        this.show();
        this.clear();
    }

    public static final /* synthetic */ boolean $anonfun$readStack$1(Origins $this, StackTraceElement x) {
        return !$this.isCutoff(x);
    }

    public static final /* synthetic */ int $anonfun$show$1(Tuple2 x$3) {
        return -x$3._2$mcI$sp();
    }

    public static final /* synthetic */ void $anonfun$show$2(Origins $this, Tuple2 x0$1) {
        if (x0$1 != null) {
            Object k = x0$1._1();
            int v = x0$1._2$mcI$sp();
            String string = "%7s %s";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Predef$.MODULE$.println(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(v), $this.repString(k)})));
            return;
        }
        throw new MatchError((Object)null);
    }

    public static final /* synthetic */ Object $anonfun$show$2$adapted(Origins $this, Tuple2 x0$1) {
        Origins.$anonfun$show$2($this, x0$1);
        return BoxedUnit.UNIT;
    }

    public static class MultiLine
    extends Origins {
        private final String tag;
        private final OriginId id;
        private final int numLines;

        @Override
        public String tag() {
            return this.tag;
        }

        @Override
        public boolean isCutoff(StackTraceElement el) {
            return this.id.matches(el);
        }

        @Override
        public List<StackTraceElement> newRep(StackTraceElement[] xs) {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])xs)).take(this.numLines))).toList();
        }

        public String repString(List<StackTraceElement> rep) {
            return ((TraversableOnce)rep.map((Function1<StackTraceElement, String> & java.io.Serializable & Serializable)x$5 -> new StringBuilder(3).append("\n  ").append(x$5).toString(), List$.MODULE$.canBuildFrom())).mkString();
        }

        @Override
        public StackTraceElement[] readStack() {
            return (StackTraceElement[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])super.readStack())).drop(1);
        }

        public MultiLine(String tag, OriginId id, int numLines) {
            this.tag = tag;
            this.id = id;
            this.numLines = numLines;
        }
    }

    public static class OneLine
    extends Origins {
        private final String tag;
        private final OriginId id;

        @Override
        public String tag() {
            return this.tag;
        }

        @Override
        public boolean isCutoff(StackTraceElement el) {
            return this.id.matches(el);
        }

        @Override
        public StackTraceElement newRep(StackTraceElement[] xs) {
            if (xs == null || xs.length == 0) {
                return null;
            }
            return xs[0];
        }

        public String repString(StackTraceElement rep) {
            return new StringBuilder(2).append("  ").append(rep).toString();
        }

        public OneLine(String tag, OriginId id) {
            this.tag = tag;
            this.id = id;
        }
    }

    public static class OriginId
    implements Product,
    Serializable {
        private final String className;
        private final String methodName;

        public String className() {
            return this.className;
        }

        public String methodName() {
            return this.methodName;
        }

        public boolean matches(StackTraceElement el) {
            String string = this.methodName();
            String string2 = el.getMethodName();
            return !(string != null ? !string.equals(string2) : string2 != null) && this.className().startsWith(el.getClassName());
        }

        public OriginId copy(String className, String methodName) {
            return new OriginId(className, methodName);
        }

        public String copy$default$1() {
            return this.className();
        }

        public String copy$default$2() {
            return this.methodName();
        }

        @Override
        public String productPrefix() {
            return "OriginId";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.className();
                }
                case 1: {
                    return this.methodName();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof OriginId;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof OriginId)) return false;
            boolean bl = true;
            if (!bl) return false;
            OriginId originId = (OriginId)x$1;
            String string = this.className();
            String string2 = originId.className();
            if (string == null) {
                if (string2 != null) {
                    return false;
                }
            } else if (!string.equals(string2)) return false;
            String string3 = this.methodName();
            String string4 = originId.methodName();
            if (string3 == null) {
                if (string4 != null) {
                    return false;
                }
            } else if (!string3.equals(string4)) return false;
            if (!originId.canEqual(this)) return false;
            return true;
        }

        public OriginId(String className, String methodName) {
            this.className = className;
            this.methodName = methodName;
            Product.$init$(this);
        }
    }
}

