/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.util.Either;
import scala.util.Failure;
import scala.util.Success;
import scala.util.Try$;
import scala.util.control.NonFatal$;

@ScalaSignature(bytes="\u0006\u0001\tue!B\u0011#\u0003C9\u0003\"B\u001a\u0001\t\u0003!\u0004\"\u0002\"\u0001\r\u0003\u0019\u0005\"B$\u0001\r\u0003\u0019\u0005\"\u0002%\u0001\r\u0003I\u0005\"\u0002+\u0001\r\u0003)\u0006\"\u0002/\u0001\r\u0003i\u0006\"\u00020\u0001\r\u0003y\u0006\"B6\u0001\r\u0003a\u0007\"B:\u0001\r\u0003!\b\"B>\u0001\r\u0003a\bbBA\u0007\u0001\u0019\u0005\u0011q\u0002\u0005\b\u0003/\u0001AQAA\r\r\u0019\ty\u0002\u0001\u0001\u0002\"!Q\u00111C\u0007\u0003\u0002\u0003\u0006I!!\u0006\t\rMjA\u0011AA\u0012\u0011\u0019\u0019X\u0002\"\u0001\u0002(!11.\u0004C\u0001\u0003kAaAX\u0007\u0005\u0002\u0005\r\u0003bBA\f\u001b\u0011\u0005\u0011q\n\u0005\b\u0003_\u0002a\u0011AA9\u0011\u001d\tI\u000f\u0001D\u0001\u0003WDqAa\u0003\u0001\r\u0003\u0011i\u0001C\u0004\u0003\u0016\u00011\tAa\u0006\t\u000f\t-\u0002A\"\u0001\u0003.!9!\u0011\u0007\u0001\u0007\u0002\tM\u0002b\u0002B$\u0001\u0019\u0005!\u0011\n\u0005\b\u0005#\u0002a\u0011\u0001B*\u000f\u001d\u0011\tH\tE\u0001\u0005g2a!\t\u0012\t\u0002\tU\u0004BB\u001a\u001e\t\u0003\u00119\bC\u0004\u0002(v!\tA!\u001f\t\u0013\t%U$!A\u0005\n\t-%a\u0001+ss*\u00111\u0005J\u0001\u0005kRLGNC\u0001&\u0003\u0015\u00198-\u00197b\u0007\u0001)\"\u0001K\u001d\u0014\t\u0001IS\u0006\r\t\u0003U-j\u0011\u0001J\u0005\u0003Y\u0011\u0012a!\u00118z%\u00164\u0007C\u0001\u0016/\u0013\tyCEA\u0004Qe>$Wo\u0019;\u0011\u0005)\n\u0014B\u0001\u001a%\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0019a\u0014N\\5u}Q\tQ\u0007E\u00027\u0001]j\u0011A\t\t\u0003qeb\u0001\u0001\u0002\u0004;\u0001\u0011\u0015\ra\u000f\u0002\u0002)F\u0011Ah\u0010\t\u0003UuJ!A\u0010\u0013\u0003\u000f9{G\u000f[5oOB\u0011!\u0006Q\u0005\u0003\u0003\u0012\u00121!\u00118z\u0003%I7OR1jYV\u0014X-F\u0001E!\tQS)\u0003\u0002GI\t9!i\\8mK\u0006t\u0017!C5t'V\u001c7-Z:t\u0003%9W\r^(s\u000b2\u001cX-\u0006\u0002K\u0019R\u00111j\u0014\t\u0003q1#Q!\u0014\u0003C\u00029\u0013\u0011!V\t\u0003o}Ba\u0001\u0015\u0003\u0005\u0002\u0004\t\u0016a\u00023fM\u0006,H\u000e\u001e\t\u0004UI[\u0015BA*%\u0005!a$-\u001f8b[\u0016t\u0014AB8s\u000b2\u001cX-\u0006\u0002W3R\u0011qK\u0017\t\u0004m\u0001A\u0006C\u0001\u001dZ\t\u0015iUA1\u0001O\u0011\u0019\u0001V\u0001\"a\u00017B\u0019!FU,\u0002\u0007\u001d,G/F\u00018\u0003\u001d1wN]3bG\",\"\u0001\u00196\u0015\u0005\u0005$\u0007C\u0001\u0016c\u0013\t\u0019GE\u0001\u0003V]&$\b\"B3\b\u0001\u00041\u0017!\u00014\u0011\t):w'[\u0005\u0003Q\u0012\u0012\u0011BR;oGRLwN\\\u0019\u0011\u0005aRG!B'\b\u0005\u0004Y\u0014a\u00024mCRl\u0015\r]\u000b\u0003[B$\"A\\9\u0011\u0007Y\u0002q\u000e\u0005\u00029a\u0012)Q\n\u0003b\u0001w!)Q\r\u0003a\u0001eB!!fZ\u001co\u0003\ri\u0017\r]\u000b\u0003kb$\"A^=\u0011\u0007Y\u0002q\u000f\u0005\u00029q\u0012)Q*\u0003b\u0001w!)Q-\u0003a\u0001uB!!fZ\u001cx\u0003\u001d\u0019w\u000e\u001c7fGR,2!`A\u0001)\rq\u00181\u0001\t\u0004m\u0001y\bc\u0001\u001d\u0002\u0002\u0011)QJ\u0003b\u0001w!9\u0011Q\u0001\u0006A\u0002\u0005\u001d\u0011A\u00019g!\u0015Q\u0013\u0011B\u001c\u0000\u0013\r\tY\u0001\n\u0002\u0010!\u0006\u0014H/[1m\rVt7\r^5p]\u00061a-\u001b7uKJ$2!NA\t\u0011\u001d\t\u0019b\u0003a\u0001\u0003+\t\u0011\u0001\u001d\t\u0005U\u001d<D)\u0001\u0006xSRDg)\u001b7uKJ$B!a\u0007\u0002fA\u0019\u0011QD\u0007\u000e\u0003\u0001\u0011!bV5uQ\u001aKG\u000e^3s'\ti\u0011\u0006\u0006\u0003\u0002\u001c\u0005\u0015\u0002bBA\n\u001f\u0001\u0007\u0011QC\u000b\u0005\u0003S\ty\u0003\u0006\u0003\u0002,\u0005E\u0002\u0003\u0002\u001c\u0001\u0003[\u00012\u0001OA\u0018\t\u0015i\u0005C1\u0001<\u0011\u0019)\u0007\u00031\u0001\u00024A)!fZ\u001c\u0002.U!\u0011qGA\u001f)\u0011\tI$a\u0010\u0011\tY\u0002\u00111\b\t\u0004q\u0005uB!B'\u0012\u0005\u0004Y\u0004BB3\u0012\u0001\u0004\t\t\u0005E\u0003+O^\nI$\u0006\u0003\u0002F\u00055CcA1\u0002H!1QM\u0005a\u0001\u0003\u0013\u0002RAK48\u0003\u0017\u00022\u0001OA'\t\u0015i%C1\u0001<)\u0011\tY\"!\u0015\t\u000f\u0005M3\u00031\u0001\u0002\u0016\u0005\t\u0011\u000fK\u0004\u000e\u0003/\ni&!\u0019\u0011\u0007)\nI&C\u0002\u0002\\\u0011\u0012Q\u0003Z3qe\u0016\u001c\u0017\r^3e\u0013:DWM]5uC:\u001cW-\t\u0002\u0002`\u0005A\u0014l\\;!o\u0016\u0014X\r\t8fm\u0016\u0014\be];qa>\u001cX\r\u001a\u0011u_\u0002\u0012W\rI1cY\u0016\u0004Co\u001c\u0011fqR,g\u000e\u001a\u0011uQ&\u001c\be\u00197bgNt\u0013EAA2\u0003\u0019\u0011d&\r\u001a/a!9\u00111\u0003\u0007A\u0002\u0005U\u0001f\u0001\u0007\u0002jA\u0019!&a\u001b\n\u0007\u00055DE\u0001\u0004j]2Lg.Z\u0001\fe\u0016\u001cwN^3s/&$\b.\u0006\u0003\u0002t\u0005eD\u0003BA;\u0003w\u0002BA\u000e\u0001\u0002xA\u0019\u0001(!\u001f\u0005\u000b5#\"\u0019\u0001(\t\u000f\u0005\u0015A\u00031\u0001\u0002~A9!&!\u0003\u0002\u0000\u0005U\u0004\u0003BAA\u0003\u000fs1AKAB\u0013\r\t)\tJ\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\tI)a#\u0003\u0013QC'o\\<bE2,'bAACI!B\u00111PAH\u0003+\u000b)\u000eE\u0002+\u0003#K1!a%%\u00059!W\r\u001d:fG\u0006$X\r\u001a(b[\u0016\ftaHAL\u0003;\u000by\rE\u0002+\u00033K1!a'%\u0005\u0019\u0019\u00160\u001c2pYFJ1%a(\u0002&\u0006\r\u0017q\u0015\u000b\u0005\u0003/\u000b\t\u000bC\u0004\u0002$\u001a\u0002\r!!,\u0002\t9\fW.Z\u0005\u0005\u0003O\u000bI+A\u0003baBd\u0017PC\u0002\u0002,\u0012\naaU=nE>d\u0007\u0003BAX\u0003{sA!!-\u0002:B\u0019\u00111\u0017\u0013\u000e\u0005\u0005U&bAA\\M\u00051AH]8pizJ1!a/%\u0003\u0019\u0001&/\u001a3fM&!\u0011qXAa\u0005\u0019\u0019FO]5oO*\u0019\u00111\u0018\u00132\u0013\r\n)-a3\u0002N\u0006-f\u0002BAd\u0003\u0017tA!a-\u0002J&\tQ%C\u0002\u0002,\u0012\nd\u0001JAd\u0003\u0013,\u0013'B\u0013\u0002R\u0006MwBAAjC\u0005)\u0017'C\u0012\u0002.\u0006]\u0017q\\Am\u0013\u0011\tI.a7\u00027\u0011bWm]:j]&$He\u001a:fCR,'\u000f\n3fM\u0006,H\u000e\u001e\u00133\u0015\r\ti\u000eJ\u0001\u000fI\u0016\u0004(/Z2bi\u0016$g*Y7fc%\u0019\u0013\u0011]Ar\u0003K\fiND\u0002+\u0003GL1!!8%c\u0015\u0011#\u0006JAt\u0005\u0015\u00198-\u00197b\u0003\u001d\u0011XmY8wKJ,B!!<\u0002tR!\u0011q^A{!\u00111\u0004!!=\u0011\u0007a\n\u0019\u0010B\u0003N+\t\u0007a\nC\u0004\u0002\u0006U\u0001\r!a>\u0011\u000f)\nI!a \u0002r\"B\u0011Q_AH\u0003w\u0014)!M\u0004 \u0003/\u000biPa\u00012\u0013\r\ny*!*\u0002\u0000\u0006\u001d\u0016'C\u0012\u0002F\u0006-'\u0011AAVc\u0019!\u0013qYAeKE*Q%!5\u0002TFJ1%!,\u0002X\n\u001d\u0011\u0011\\\u0019\nG\u0005\u0005\u00181\u001dB\u0005\u0003;\fTA\t\u0016%\u0003O\f\u0001\u0002^8PaRLwN\\\u000b\u0003\u0005\u001f\u0001BA\u000bB\to%\u0019!1\u0003\u0013\u0003\r=\u0003H/[8o\u0003\u001d1G.\u0019;uK:,BA!\u0007\u0003 Q!!1\u0004B\u0011!\u00111\u0004A!\b\u0011\u0007a\u0012y\u0002B\u0003N/\t\u00071\bC\u0004\u0003$]\u0001\u001dA!\n\u0002\u0005\u00154\bcBAX\u0005O9$1D\u0005\u0005\u0005S\t\tM\u0001\t%Y\u0016\u001c8\u000fJ2pY>tG\u0005\\3tg\u00061a-Y5mK\u0012,\"Aa\f\u0011\tY\u0002\u0011qP\u0001\niJ\fgn\u001d4pe6,BA!\u000e\u0003<Q1!q\u0007B\u001f\u0005\u0007\u0002BA\u000e\u0001\u0003:A\u0019\u0001Ha\u000f\u0005\u000b5K\"\u0019A\u001e\t\u000f\t}\u0012\u00041\u0001\u0003B\u0005\t1\u000fE\u0003+O^\u00129\u0004\u0003\u0004f3\u0001\u0007!Q\t\t\u0007U\u001d\fyHa\u000e\u0002\u0011Q|W)\u001b;iKJ,\"Aa\u0013\u0011\rY\u0012i%a 8\u0013\r\u0011yE\t\u0002\u0007\u000b&$\b.\u001a:\u0002\t\u0019|G\u000eZ\u000b\u0005\u0005+\u0012I\u0006\u0006\u0004\u0003X\tm#\u0011\r\t\u0004q\teC!B'\u001c\u0005\u0004Y\u0004b\u0002B/7\u0001\u0007!qL\u0001\u0003M\u0006\u0004bAK4\u0002\u0000\t]\u0003b\u0002B27\u0001\u0007!QM\u0001\u0003M\n\u0004RAK48\u0005/JS\u0001\u0001B5\u0005[J1Aa\u001b#\u0005\u001d1\u0015-\u001b7ve\u0016L1Aa\u001c#\u0005\u001d\u0019VoY2fgN\f1\u0001\u0016:z!\t1TdE\u0002\u001eSA\"\"Aa\u001d\u0016\t\tm$\u0011\u0011\u000b\u0005\u0005{\u0012\u0019\t\u0005\u00037\u0001\t}\u0004c\u0001\u001d\u0003\u0002\u0012)!h\bb\u0001w!A!QQ\u0010\u0005\u0002\u0004\u00119)A\u0001s!\u0011Q#Ka \u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0005\u001b\u0003BAa$\u0003\u001a6\u0011!\u0011\u0013\u0006\u0005\u0005'\u0013)*\u0001\u0003mC:<'B\u0001BL\u0003\u0011Q\u0017M^1\n\t\tm%\u0011\u0013\u0002\u0007\u001f\nTWm\u0019;")
public abstract class Try<T>
implements Product,
Serializable {
    public static <T> Try<T> apply(Function0<T> function0) {
        if (Try$.MODULE$ == null) {
            throw null;
        }
        try {
            return new Success<T>(function0.apply());
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable apply_e = option.get();
            Failure failure = new Failure(apply_e);
            return failure;
        }
    }

    @Override
    public Iterator<Object> productIterator() {
        return Product.productIterator$(this);
    }

    @Override
    public String productPrefix() {
        return Product.productPrefix$(this);
    }

    public abstract boolean isFailure();

    public abstract boolean isSuccess();

    public abstract <U> U getOrElse(Function0<U> var1);

    public abstract <U> Try<U> orElse(Function0<Try<U>> var1);

    public abstract T get();

    public abstract <U> void foreach(Function1<T, U> var1);

    public abstract <U> Try<U> flatMap(Function1<T, Try<U>> var1);

    public abstract <U> Try<U> map(Function1<T, U> var1);

    public abstract <U> Try<U> collect(PartialFunction<T, U> var1);

    public abstract Try<T> filter(Function1<T, Object> var1);

    public final WithFilter withFilter(Function1<T, Object> p) {
        return new WithFilter(this, p);
    }

    public abstract <U> Try<U> recoverWith(PartialFunction<Throwable, Try<U>> var1);

    public abstract <U> Try<U> recover(PartialFunction<Throwable, U> var1);

    public abstract Option<T> toOption();

    public abstract <U> Try<U> flatten(Predef$.less.colon.less<T, Try<U>> var1);

    public abstract Try<Throwable> failed();

    public abstract <U> Try<U> transform(Function1<T, Try<U>> var1, Function1<Throwable, Try<U>> var2);

    public abstract Either<Throwable, T> toEither();

    public abstract <U> U fold(Function1<Throwable, U> var1, Function1<T, U> var2);

    public Try() {
        Product.$init$(this);
    }

    public class WithFilter {
        private final Function1<T, Object> p;
        public final /* synthetic */ Try $outer;

        public <U> Try<U> map(Function1<T, U> f) {
            return this.scala$util$Try$WithFilter$$$outer().filter(this.p).map(f);
        }

        public <U> Try<U> flatMap(Function1<T, Try<U>> f) {
            return this.scala$util$Try$WithFilter$$$outer().filter(this.p).flatMap(f);
        }

        public <U> void foreach(Function1<T, U> f) {
            this.scala$util$Try$WithFilter$$$outer().filter(this.p).foreach(f);
        }

        public WithFilter withFilter(Function1<T, Object> q) {
            return new WithFilter(this.scala$util$Try$WithFilter$$$outer(), (Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(WithFilter.$anonfun$withFilter$1(this, q, x)));
        }

        public /* synthetic */ Try scala$util$Try$WithFilter$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$withFilter$1(WithFilter $this, Function1 q$1, Object x) {
            return BoxesRunTime.unboxToBoolean($this.p.apply(x)) && BoxesRunTime.unboxToBoolean(q$1.apply(x));
        }

        public WithFilter(Try $outer, Function1<T, Object> p) {
            this.p = p;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

