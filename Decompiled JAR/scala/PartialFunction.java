/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function1;
import scala.None$;
import scala.Option;
import scala.PartialFunction$;
import scala.Serializable;
import scala.Some;
import scala.reflect.ScalaSignature;
import scala.runtime.AbstractFunction1;
import scala.runtime.AbstractPartialFunction;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\t\u001dga\u0002\u00192!\u0003\r\t\u0001\u000e\u0005\u0006\u0017\u0002!\t\u0001\u0014\u0005\u0006!\u00021\t!\u0015\u0005\u0006/\u0002!\t\u0001\u0017\u0005\u0006K\u0002!\tE\u001a\u0005\u0006_\u0002!\t\u0001\u001d\u0005\u0006k\u0002!\tA\u001e\u0005\b\u0003\u0003\u0001A\u0011AA\u0002\u000f\u001d\t)\"\rE\u0001\u0003/1a\u0001M\u0019\t\u0002\u0005e\u0001bBA\u000e\u0013\u0011\u0005\u0011Q\u0004\u0004\u0007\u0003?IA!!\t\t\u0015\u0005}2B!A!\u0002\u0013\t\t\u0005\u0003\u0006\u0002D-\u0011\t\u0011)A\u0005\u0003\u0003Bq!a\u0007\f\t\u0003\t)\u0005\u0003\u0004Q\u0017\u0011\u0005\u0011q\n\u0005\b\u0003'ZA\u0011IA+\u0011\u0019)8\u0002\"\u0011\u0002Z!1qk\u0003C!\u0003_Ba!Z\u0006\u0005B\u0005\u0005eABAH\u0013\u0011\t\t\n\u0003\u0006\u0002 R\u0011\t\u0011)A\u0005\u0003CC\u0011\"\u001c\u000b\u0003\u0002\u0003\u0006I!a*\t\u000f\u0005mA\u0003\"\u0001\u0002*\"1\u0001\u000b\u0006C\u0001\u0003cCq!a\u0015\u0015\t\u0003\t)\f\u0003\u0004v)\u0011\u0005\u0013\u0011\u0018\u0005\t\u0003#L\u0001\u0015!\u0003\u0002T\"9\u0011Q[\u0005\u0005\n\u0005]\u0007bBAq\u0013\u0011%\u00111\u001d\u0004\u0007\u0003[LA!a<\t\u0015\u0005}eD!b\u0001\n\u0003\u0011\u0019\u0001\u0003\u0006\u0003\by\u0011\t\u0011)A\u0005\u0005\u000bAq!a\u0007\u001f\t\u0003\u0011I\u0001C\u0004\u0002Ty!\tAa\u0004\u0007\r\tM\u0011\u0002\u0002B\u000b\u0011)\u0011\u0019c\tB\u0001B\u0003%!Q\u0005\u0005\b\u00037\u0019C\u0011\u0001B\u0015\u0011\u0019\u00016\u0005\"\u0001\u00030!1Qo\tC!\u0005gAaa\\\u0012\u0005B\t%\u0003\u0002\u0003B&\u0013\u0011\u0005\u0011G!\u0014\t\u000f\u0005M\u0013\u0002\"\u0001\u0003b!A!1Q\u0005!\u0002\u0013\u0011)\t\u0003\u0005\u0003\b&\u0001\u000b\u0011\u0002BE\u0011\u001d\u0011Y)\u0003C\u0001\u0005\u001bCqAa'\n\t\u0003\u0011i\nC\u0004\u00030&!\tA!-\u0003\u001fA\u000b'\u000f^5bY\u001a+hn\u0019;j_:T\u0011AM\u0001\u0006g\u000e\fG.Y\u0002\u0001+\r)t(S\n\u0004\u0001YR\u0004CA\u001c9\u001b\u0005\t\u0014BA\u001d2\u0005\u0019\te.\u001f*fMB!qgO\u001fI\u0013\ta\u0014GA\u0005Gk:\u001cG/[8ocA\u0011ah\u0010\u0007\u0001\t\u0019\u0001\u0005\u0001#b\u0001\u0003\n\t\u0011)\u0005\u0002C\u000bB\u0011qgQ\u0005\u0003\tF\u0012qAT8uQ&tw\r\u0005\u00028\r&\u0011q)\r\u0002\u0004\u0003:L\bC\u0001 J\t\u0019Q\u0005\u0001\"b\u0001\u0003\n\t!)\u0001\u0004%S:LG\u000f\n\u000b\u0002\u001bB\u0011qGT\u0005\u0003\u001fF\u0012A!\u00168ji\u0006Y\u0011n\u001d#fM&tW\rZ!u)\t\u0011V\u000b\u0005\u00028'&\u0011A+\r\u0002\b\u0005>|G.Z1o\u0011\u00151&\u00011\u0001>\u0003\u0005A\u0018AB8s\u000b2\u001cX-F\u0002Z9\u0002$\"AW2\u0011\t]\u00021l\u0018\t\u0003}q#Q!X\u0002C\u0002y\u0013!!Q\u0019\u0012\u0005\tk\u0004C\u0001 a\t\u0015\t7A1\u0001c\u0005\t\u0011\u0015'\u0005\u0002I\u000b\")Am\u0001a\u00015\u0006!A\u000f[1u\u0003\u001d\tg\u000e\u001a+iK:,\"a\u001a6\u0015\u0005!d\u0007\u0003B\u001c\u0001{%\u0004\"A\u00106\u0005\u000b-$!\u0019A!\u0003\u0003\rCQ!\u001c\u0003A\u00029\f\u0011a\u001b\t\u0005omB\u0015.\u0001\u0003mS\u001a$X#A9\u0011\t]ZTH\u001d\t\u0004oMD\u0015B\u0001;2\u0005\u0019y\u0005\u000f^5p]\u0006Y\u0011\r\u001d9ms>\u0013X\t\\:f+\r9H0\u001f\u000b\u0004qjl\bC\u0001 z\t\u0015\tgA1\u0001c\u0011\u00151f\u00011\u0001|!\tqD\u0010B\u0003^\r\t\u0007a\fC\u0003\u007f\r\u0001\u0007q0A\u0004eK\u001a\fW\u000f\u001c;\u0011\t]Z4\u0010_\u0001\beVtw+\u001b;i+\u0011\t)!!\u0005\u0015\t\u0005\u001d\u0011\u0011\u0002\t\u0005omj$\u000bC\u0004\u0002\f\u001d\u0001\r!!\u0004\u0002\r\u0005\u001cG/[8o!\u001594\bSA\b!\rq\u0014\u0011\u0003\u0003\u0007\u0003'9!\u0019A!\u0003\u0003U\u000bq\u0002U1si&\fGNR;oGRLwN\u001c\t\u0003o%\u0019\"!\u0003\u001c\u0002\rqJg.\u001b;?)\t\t9B\u0001\u0004Pe\u0016c7/Z\u000b\u0007\u0003G\t\u0019$a\u000e\u0014\u000b-\t)#!\u000f\u0011\u0011\u0005\u001d\u0012QFA\u0019\u0003ki!!!\u000b\u000b\u0007\u0005-\u0012'A\u0004sk:$\u0018.\\3\n\t\u0005=\u0012\u0011\u0006\u0002\u0018\u0003\n\u001cHO]1diB\u000b'\u000f^5bY\u001a+hn\u0019;j_:\u00042APA\u001a\t\u0019\u00015\u0002#b\u0001\u0003B\u0019a(a\u000e\u0005\r)[AQ1\u0001B!\r9\u00141H\u0005\u0004\u0003{\t$\u0001D*fe&\fG.\u001b>bE2,\u0017A\u000142!\u00199\u0004!!\r\u00026\u0005\u0011aM\r\u000b\u0007\u0003\u000f\nY%!\u0014\u0011\u000f\u0005%3\"!\r\u000265\t\u0011\u0002C\u0004\u0002@9\u0001\r!!\u0011\t\u000f\u0005\rc\u00021\u0001\u0002BQ\u0019!+!\u0015\t\rY{\u0001\u0019AA\u0019\u0003\u0015\t\u0007\u000f\u001d7z)\u0011\t)$a\u0016\t\rY\u0003\u0002\u0019AA\u0019+\u0019\tY&a\u001a\u0002`Q1\u0011QLA2\u0003W\u00022APA0\t\u0019\t\u0017C1\u0001\u0002bE\u0019\u0011QG#\t\rY\u000b\u0002\u0019AA3!\rq\u0014q\r\u0003\u0007;F\u0011\r!!\u001b\u0012\u0007\t\u000b\t\u0004\u0003\u0004\u007f#\u0001\u0007\u0011Q\u000e\t\u0007om\n)'!\u0018\u0016\r\u0005E\u0014qOA>)\u0011\t\u0019(! \u0011\u000f\u0005%3\"!\u001e\u0002zA\u0019a(a\u001e\u0005\ru\u0013\"\u0019AA5!\rq\u00141\u0010\u0003\u0007CJ\u0011\r!!\u0019\t\r\u0011\u0014\u0002\u0019AA@!\u00199\u0004!!\u001e\u0002zU!\u00111QAE)\u0011\t))a#\u0011\u000f\u0005%3\"!\r\u0002\bB\u0019a(!#\u0005\u000b-\u001c\"\u0019A!\t\r5\u001c\u0002\u0019AAG!\u001994(!\u000e\u0002\b\n9\u0011I\u001c3UQ\u0016tW\u0003CAJ\u00033\u000b)+!(\u0014\rQ1\u0014QSA\u001d!\u00199\u0004!a&\u0002\u001cB\u0019a(!'\u0005\r\u0001#\u0002R1\u0001B!\rq\u0014Q\u0014\u0003\u0007WR!)\u0019A!\u0002\u0005A4\u0007CB\u001c\u0001\u0003/\u000b\u0019\u000bE\u0002?\u0003K#QA\u0013\u000bC\u0002\u0005\u0003baN\u001e\u0002$\u0006mECBAV\u0003[\u000by\u000bE\u0005\u0002JQ\t9*a)\u0002\u001c\"9\u0011qT\fA\u0002\u0005\u0005\u0006BB7\u0018\u0001\u0004\t9\u000bF\u0002S\u0003gCaA\u0016\rA\u0002\u0005]E\u0003BAN\u0003oCaAV\rA\u0002\u0005]UCBA^\u0003\u0013\fy\f\u0006\u0004\u0002>\u0006\u0015\u0017Q\u001a\t\u0004}\u0005}FaBAa5\t\u0007\u00111\u0019\u0002\u0003\u0007F\n2!a'F\u0011\u00191&\u00041\u0001\u0002HB\u0019a(!3\u0005\ruS\"\u0019AAf#\r\u0011\u0015q\u0013\u0005\u0007}j\u0001\r!a4\u0011\r]Z\u0014qYA_\u0003-1\u0017\r\u001c7cC\u000e\\w\f\u001d4\u0011\t]\u0002Q)R\u0001\u000eG\",7m\u001b$bY2\u0014\u0017mY6\u0016\t\u0005e\u0017q\\\u000b\u0003\u00037\u0004Ra\u000e\u0001F\u0003;\u00042APAp\t\u0015QED1\u0001B\u0003A1\u0017\r\u001c7cC\u000e\\wjY2veJ,G-\u0006\u0003\u0002f\u0006-Hc\u0001*\u0002h\"1a+\ba\u0001\u0003S\u00042APAv\t\u0015QUD1\u0001B\u0005\u0019a\u0015N\u001a;fIV1\u0011\u0011_A~\u0005\u0003\u0019RAHAz\u0003s\u0001\u0002\"a\n\u0002v\u0006e\u0018Q`\u0005\u0005\u0003o\fICA\tBEN$(/Y2u\rVt7\r^5p]F\u00022APA~\t\u0019\u0001e\u0004#b\u0001\u0003B!qg]A\u0000!\rq$\u0011\u0001\u0003\u0007\u0015z!)\u0019A!\u0016\u0005\t\u0015\u0001CB\u001c\u0001\u0003s\fy0A\u0002qM\u0002\"BAa\u0003\u0003\u000eA9\u0011\u0011\n\u0010\u0002z\u0006}\bbBAPC\u0001\u0007!Q\u0001\u000b\u0005\u0003{\u0014\t\u0002\u0003\u0004WE\u0001\u0007\u0011\u0011 \u0002\t+:d\u0017N\u001a;fIV1!q\u0003B\u000f\u0005C\u0019Ra\tB\r\u0003s\u0001\u0002\"a\n\u0002.\tm!q\u0004\t\u0004}\tuA!\u0002!$\u0005\u0004\t\u0005c\u0001 \u0003\"\u0011)!j\tb\u0001\u0003\u0006\ta\r\u0005\u00048w\tm!q\u0005\t\u0005oM\u0014y\u0002\u0006\u0003\u0003,\t5\u0002cBA%G\tm!q\u0004\u0005\b\u0005G)\u0003\u0019\u0001B\u0013)\r\u0011&\u0011\u0007\u0005\u0007-\u001a\u0002\rAa\u0007\u0016\r\tU\"\u0011\tB\u001d)\u0019\u00119D!\u0010\u0003FA\u0019aH!\u000f\u0005\r\u0005<#\u0019\u0001B\u001e#\r\u0011y\"\u0012\u0005\u0007-\u001e\u0002\rAa\u0010\u0011\u0007y\u0012\t\u0005\u0002\u0004^O\t\u0007!1I\t\u0004\u0005\nm\u0001B\u0002@(\u0001\u0004\u00119\u0005\u0005\u00048w\t}\"qG\u000b\u0003\u0005K\t\u0001\"\u001e8mS\u001a$X\rZ\u000b\u0007\u0005\u001f\u0012)F!\u0017\u0015\t\tE#1\f\t\u0007o\u0001\u0011\u0019Fa\u0016\u0011\u0007y\u0012)\u0006B\u0003AS\t\u0007\u0011\tE\u0002?\u00053\"QAS\u0015C\u0002\u0005CqAa\t*\u0001\u0004\u0011i\u0006\u0005\u00048w\tM#q\f\t\u0005oM\u00149&\u0006\u0004\u0003d\t%$Q\u000e\u000b\u0005\u0005K\u0012y\u0007\u0005\u00048\u0001\t\u001d$1\u000e\t\u0004}\t%D!\u0002!+\u0005\u0004\t\u0005c\u0001 \u0003n\u0011)!J\u000bb\u0001\u0003\"9!1\u0005\u0016A\u0002\tE\u0004CB\u001c<\u0005O\u0012Y\u0007K\u0004+\u0005k\u0012YHa \u0011\u0007]\u00129(C\u0002\u0003zE\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\u0011i(\u0001B\r\r>\u0014\beY8om\u0016\u0014H/\u001b8hA\u0005t\u0007e\u001c:eS:\f'/\u001f\u0011gk:\u001cG/[8oA\u0019\u0004Co\u001c\u0011bAA\f'\u000f^5bY\u00022WO\\2uS>t\u0007\u0005\u001d4-AU\u001cX\r\t1wC2\u0004\u0003O\u001a\u001e!!\u0006\u0014H/[1m\rVt7\r^5p]n\u000bE\u0006\t\"^Au\u00023\u0010I2bg\u0016\u0004\u0003\u0010I\u001f?A\u0019D\u00030\u000b\u0011~A:\u0002ci\u001c:!GJ,\u0017\r^5oO\u0002\n\u0007E\\3xAA\u000b'\u000f^5bY\u001a+hn\u0019;j_:d\u0003%^:fA\u0005t\u0007%\u001a=qY&\u001c\u0017\u000e\u001e\u0011usB,\u0007%\u00198o_R\fG/[8oA%t7\u000f^3bI2\u0002C.[6fA%t\u0007\u0005\u0019<bY\u0002\u0002hM\u000f\u0011QCJ$\u0018.\u00197Gk:\u001cG/[8o7&sG\u000f\f\u0011TiJLgnZ/!{\u0001Z\beY1tK\u0002\n\u0004%\u0010 !E=tWM\t\u0011~A:\n#A!!\u0002\rIr\u0013G\r\u00186\u0003)\u0019wN\\:u\r\u0006d7/\u001a\t\u0005om*%+\u0001\u0005f[B$\u0018p\u00189g!\u00119\u0004!\u0012\"\u0002\u000b\u0015l\u0007\u000f^=\u0016\r\t=%Q\u0013BM+\t\u0011\t\n\u0005\u00048\u0001\tM%q\u0013\t\u0004}\tUE!\u0002!.\u0005\u0004\t\u0005c\u0001 \u0003\u001a\u0012)!*\fb\u0001\u0003\u0006!1m\u001c8e+\u0011\u0011yJ!+\u0015\t\t\u0005&Q\u0016\u000b\u0004%\n\r\u0006bBAP]\u0001\u0007!Q\u0015\t\u0006o\u0001\u00119K\u0015\t\u0004}\t%FA\u0002BV]\t\u0007\u0011IA\u0001U\u0011\u00191f\u00061\u0001\u0003(\u000691m\u001c8e\u001fB$XC\u0002BZ\u0005\u0007\u0014Y\f\u0006\u0003\u00036\n\u0015G\u0003\u0002B\\\u0005{\u0003BaN:\u0003:B\u0019aHa/\u0005\r\u0005MqF1\u0001B\u0011\u001d\tyj\fa\u0001\u0005\u007f\u0003ba\u000e\u0001\u0003B\ne\u0006c\u0001 \u0003D\u00121!1V\u0018C\u0002\u0005CaAV\u0018A\u0002\t\u0005\u0007")
public interface PartialFunction<A, B>
extends Function1<A, B> {
    public static <T, U> Option<U> condOpt(T t, PartialFunction<T, U> partialFunction) {
        return PartialFunction$.MODULE$.condOpt(t, partialFunction);
    }

    public static <T> boolean cond(T t, PartialFunction<T, Object> partialFunction) {
        return PartialFunction$.MODULE$.cond(t, partialFunction);
    }

    public static <A, B> PartialFunction<A, B> empty() {
        return PartialFunction$.MODULE$.empty();
    }

    public boolean isDefinedAt(A var1);

    default public <A1 extends A, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
        return new OrElse<A1, B1>(this, that);
    }

    @Override
    default public <C> PartialFunction<A, C> andThen(Function1<B, C> k) {
        return new AndThen(this, k);
    }

    default public Function1<A, Option<B>> lift() {
        return new Lifted(this);
    }

    public static /* synthetic */ Object applyOrElse$(PartialFunction $this, Object x, Function1 function1) {
        return $this.applyOrElse(x, function1);
    }

    default public <A1 extends A, B1> B1 applyOrElse(A1 x, Function1<A1, B1> function1) {
        if (this.isDefinedAt(x)) {
            return (B1)this.apply(x);
        }
        return function1.apply(x);
    }

    default public <U> Function1<A, Object> runWith(Function1<B, U> action) {
        return (Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            boolean bl;
            Object $anonfun$runWith$1_z = this.applyOrElse(x, PartialFunction$.MODULE$.scala$PartialFunction$$checkFallback());
            if (!PartialFunction$.MODULE$.scala$PartialFunction$$fallbackOccurred($anonfun$runWith$1_z)) {
                action.apply($anonfun$runWith$1_z);
                bl = true;
            } else {
                bl = false;
            }
            return BoxesRunTime.boxToBoolean(bl);
        };
    }

    public static /* synthetic */ boolean $anonfun$runWith$1(PartialFunction $this, Function1 action$1, Object x) {
        Object z = $this.applyOrElse(x, PartialFunction$.MODULE$.scala$PartialFunction$$checkFallback());
        if (!PartialFunction$.MODULE$.scala$PartialFunction$$fallbackOccurred(z)) {
            action$1.apply(z);
            return true;
        }
        return false;
    }

    public static void $init$(PartialFunction $this) {
    }

    public static class AndThen<A, B, C>
    implements PartialFunction<A, C>,
    Serializable {
        private final PartialFunction<A, B> pf;
        private final Function1<B, C> k;

        @Override
        public <A1 extends A, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
            return ((PartialFunction)this).orElse((PartialFunction)that);
        }

        @Override
        public <C> PartialFunction<A, C> andThen(Function1<C, C> k) {
            return ((PartialFunction)this).andThen(k);
        }

        @Override
        public Function1<A, Option<C>> lift() {
            return ((PartialFunction)this).lift();
        }

        @Override
        public <U> Function1<A, Object> runWith(Function1<C, U> action) {
            return ((PartialFunction)this).runWith(action);
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
        public <A> Function1<A, C> compose(Function1<A, A> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        @Override
        public boolean isDefinedAt(A x) {
            return this.pf.isDefinedAt(x);
        }

        @Override
        public C apply(A x) {
            return this.k.apply(this.pf.apply(x));
        }

        @Override
        public <A1 extends A, C1> C1 applyOrElse(A1 x, Function1<A1, C1> function1) {
            Object z = this.pf.applyOrElse(x, PartialFunction$.MODULE$.scala$PartialFunction$$checkFallback());
            if (!PartialFunction$.MODULE$.scala$PartialFunction$$fallbackOccurred(z)) {
                return (C1)this.k.apply(z);
            }
            return function1.apply(x);
        }

        public AndThen(PartialFunction<A, B> pf, Function1<B, C> k) {
            this.pf = pf;
            this.k = k;
            PartialFunction.$init$(this);
        }
    }

    public static class Lifted<A, B>
    extends AbstractFunction1<A, Option<B>>
    implements Serializable {
        private final PartialFunction<A, B> pf;

        public PartialFunction<A, B> pf() {
            return this.pf;
        }

        @Override
        public Option<B> apply(A x) {
            Object z = this.pf().applyOrElse(x, PartialFunction$.MODULE$.scala$PartialFunction$$checkFallback());
            if (!PartialFunction$.MODULE$.scala$PartialFunction$$fallbackOccurred(z)) {
                return new Some(z);
            }
            return None$.MODULE$;
        }

        public Lifted(PartialFunction<A, B> pf) {
            this.pf = pf;
        }
    }

    public static class OrElse<A, B>
    extends AbstractPartialFunction<A, B>
    implements Serializable {
        private final PartialFunction<A, B> f1;
        private final PartialFunction<A, B> f2;

        @Override
        public boolean isDefinedAt(A x) {
            return this.f1.isDefinedAt(x) || this.f2.isDefinedAt(x);
        }

        @Override
        public B apply(A x) {
            return this.f1.applyOrElse(x, this.f2);
        }

        @Override
        public <A1 extends A, B1> B1 applyOrElse(A1 x, Function1<A1, B1> function1) {
            Object z = this.f1.applyOrElse(x, PartialFunction$.MODULE$.scala$PartialFunction$$checkFallback());
            if (!PartialFunction$.MODULE$.scala$PartialFunction$$fallbackOccurred(z)) {
                return (B1)z;
            }
            return this.f2.applyOrElse(x, function1);
        }

        @Override
        public <A1 extends A, B1> OrElse<A1, B1> orElse(PartialFunction<A1, B1> that) {
            return new OrElse<A, B>(this.f1, this.f2.orElse(that));
        }

        @Override
        public <C> OrElse<A, C> andThen(Function1<B, C> k) {
            return new OrElse<A, C>(this.f1.andThen(k), this.f2.andThen(k));
        }

        public OrElse(PartialFunction<A, B> f1, PartialFunction<A, B> f2) {
            this.f1 = f1;
            this.f2 = f2;
        }
    }

    public static class Unlifted<A, B>
    extends AbstractPartialFunction<A, B>
    implements Serializable {
        private final Function1<A, Option<B>> f;

        @Override
        public boolean isDefinedAt(A x) {
            return this.f.apply(x).isDefined();
        }

        @Override
        public <A1 extends A, B1> B1 applyOrElse(A1 x, Function1<A1, B1> function1) {
            Option<B> z = this.f.apply(x);
            if (!z.isEmpty()) {
                return (B1)z.get();
            }
            return function1.apply(x);
        }

        @Override
        public Function1<A, Option<B>> lift() {
            return this.f;
        }

        public Unlifted(Function1<A, Option<B>> f) {
            this.f = f;
        }
    }
}

