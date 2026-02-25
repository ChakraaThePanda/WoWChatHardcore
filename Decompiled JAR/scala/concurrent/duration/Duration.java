/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.duration;

import java.util.concurrent.TimeUnit;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.concurrent.duration.Duration$;
import scala.concurrent.duration.FiniteDuration;
import scala.math.Ordered;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichDouble;

@ScalaSignature(bytes="\u0006\u0001\rEq!\u00020`\u0011\u00031g!\u00025`\u0011\u0003I\u0007\"B9\u0002\t\u0003\u0011\b\"B:\u0002\t\u0003!\bBB:\u0002\t\u0003\ty\u0010\u0003\u0004t\u0003\u0011\u0005!q\u0001\u0005\t\u0005\u001b\t\u0001\u0015!\u0004\u0003\u0010!11/\u0001C\u0001\u0005'A\u0001B!\u0007\u0002A\u0013%!1\u0004\u0005\t\u0005k\t\u0001\u0015\"\u0003\u00038!A!qH\u0001!\u0002\u0013\u0011\t\u0005\u0003\u0006\u0003b\u0005\u0011\r\u0011\"\u0005`\u0005GB\u0001Ba\u001b\u0002A\u0003%!Q\r\u0005\u000b\u0005[\n!\u0019!C\t?\n=\u0004\u0002\u0003B:\u0003\u0001\u0006IA!\u001d\t\u000f\tU\u0014\u0001\"\u0001\u0003x!9!QO\u0001\u0005\u0002\t\r\u0005b\u0002BE\u0003\u0011\u0005!1\u0012\u0005\t\u0005#\u000b\u0001\u0015!\u0004\u0003\u0014\"A!qS\u0001!\u0002\u001b\u0011I\n\u0003\u0005\u0003\u001e\u0006\u0001\u000bQ\u0002BP\u0011!\u0011\u0019+\u0001Q\u0001\u000e\t\u0015\u0006\u0002\u0003BU\u0003\u0001\u0006iAa+\t\u0011\t=\u0016\u0001)A\u0007\u0005cCqA!#\u0002\t\u0003\u0011)\fC\u0005\u0003:\u0006\u0011\r\u0011\"\u0001\u0003<\"A!QX\u0001!\u0002\u0013\u0011\t\u0001C\u0005\u0003@\u0006\u0011\r\u0011\"\u0001\u0003B\"A!1Y\u0001!\u0002\u0013\tiLB\u0004\u00028\u0006\t\t#!/\t\rElB\u0011AA^\u0011\u001d\ti$\bC\u0001\u0003\u0003Dq!!\u0012\u001e\t\u0003\t)\rC\u0004\u0002Lu!\t!!3\t\u000f\u0005MS\u0004\"\u0001\u0002N\"9\u00111K\u000f\u0005\u0002\u0005E\u0007bBA2;\u0011\u0015\u0011Q\r\u0005\t\u0003+l\u0002\u0015\"\u0003\u0002X\"9\u0011\u0011B\u000f\u0005\u0006\u0005-\u0001bBA\n;\u0011\u0015\u0011Q\u0003\u0005\b\u0003GiBQAA\u0006\u0011\u001d\t)#\bC\u0003\u0003\u0017Aq!a\n\u001e\t\u000b\tY\u0001C\u0004\u0002*u!)!a\u0003\t\u000f\u0005-R\u0004\"\u0002\u0002\f!9\u0011QF\u000f\u0005\u0006\u0005-\u0001bBA\u0018;\u0011\u0015\u00111\u0002\u0005\b\u0003_kBQAA1\u0011%\u0011)-\u0001b\u0001\n\u0003\u0011\t\r\u0003\u0005\u0003H\u0006\u0001\u000b\u0011BA_\u0011%\u0011I-\u0001b\u0001\n\u0003\u0011\t\r\u0003\u0005\u0003L\u0006\u0001\u000b\u0011BA_\u0011\u001d\u0011i-\u0001C\u0001\u0005\u001fDqA!4\u0002\t\u0003\u0011)\u000eC\u0004\u0003N\u0006!\tAa7\t\u000f\t5\u0017\u0001\"\u0001\u0003b\u001e9!Q]\u0001\t\u0004\t\u001dha\u0002Bu\u0003!\u0005!1\u001e\u0005\u0007cf\"\tA!?\t\u000f\tm\u0018\b\"\u0001\u0003~\"I1QB\u001d\u0002\u0002\u0013%1q\u0002\u0005\n\u0007\u001b\t\u0011\u0011!C\u0005\u0007\u001f1Q\u0001[0\u0002\"YDa!\u001d \u0005\u0002\u0005\u001d\u0001bBA\u0005}\u0019\u0005\u00111\u0002\u0005\b\u0003'qd\u0011AA\u000b\u0011\u001d\t\u0019C\u0010D\u0001\u0003\u0017Aq!!\n?\r\u0003\tY\u0001C\u0004\u0002(y2\t!a\u0003\t\u000f\u0005%bH\"\u0001\u0002\f!9\u00111\u0006 \u0007\u0002\u0005-\u0001bBA\u0017}\u0019\u0005\u00111\u0002\u0005\b\u0003_qd\u0011AA\u0006\u0011\u001d\t\tD\u0010D\u0001\u0003gAq!!\u0010?\r\u0003\ty\u0004C\u0004\u0002Fy2\t!a\u0012\t\u000f\u0005-cH\"\u0001\u0002N!9\u00111\u000b \u0007\u0002\u0005U\u0003bBA*}\u0019\u0005\u00111\f\u0005\b\u0003?rd\u0011AA1\u0011\u001d\t\u0019G\u0010D\u0001\u0003KBq!!\u001c?\t\u0003\ty\u0007C\u0004\u0002ty\"\t!!\u001e\t\u000f\u0005ed\b\"\u0001\u0002|!9\u0011\u0011\u0010 \u0005\u0002\u0005}\u0004bBAB}\u0011\u0005\u0011Q\u0011\u0005\b\u0003\u0013sD\u0011AAF\u0011\u001d\tyI\u0010C\u0001\u0003#Cq!!&?\t\u0003\t9\nC\u0004\u0002\u001cz\"\t!!(\t\u000f\u0005\u0005f\b\"\u0001\u0002$\"9\u0011q\u0015 \u0005\u0002\u0005\u001d\u0001bBAU}\u0011\u0005\u00111\u0016\u0005\b\u0003_sd\u0011AA1\u0003!!UO]1uS>t'B\u00011b\u0003!!WO]1uS>t'B\u00012d\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0002I\u0006)1oY1mC\u000e\u0001\u0001CA4\u0002\u001b\u0005y&\u0001\u0003#ve\u0006$\u0018n\u001c8\u0014\u0007\u0005Qg\u000e\u0005\u0002lY6\t1-\u0003\u0002nG\n1\u0011I\\=SK\u001a\u0004\"a[8\n\u0005A\u001c'\u0001D*fe&\fG.\u001b>bE2,\u0017A\u0002\u001fj]&$h\bF\u0001g\u0003\u0015\t\u0007\u000f\u001d7z)\u0015)\u00181`A\u007f!\t9gh\u0005\u0003?U:<\b\u0003\u0002=\u0002\u0002Ut!!\u001f@\u000f\u0005ilX\"A>\u000b\u0005q,\u0017A\u0002\u001fs_>$h(C\u0001e\u0013\ty8-A\u0004qC\u000e\\\u0017mZ3\n\t\u0005\r\u0011Q\u0001\u0002\b\u001fJ$WM]3e\u0015\ty8\rF\u0001v\u0003\u0019aWM\\4uQV\u0011\u0011Q\u0002\t\u0004W\u0006=\u0011bAA\tG\n!Aj\u001c8h\u0003\u0011)h.\u001b;\u0016\u0005\u0005]\u0001\u0003BA\r\u0003;q1aZA\u000e\u0013\tyx,\u0003\u0003\u0002 \u0005\u0005\"\u0001\u0003+j[\u0016,f.\u001b;\u000b\u0005}|\u0016a\u0002;p\u001d\u0006twn]\u0001\ti>l\u0015n\u0019:pg\u0006AAo\\'jY2L7/A\u0005u_N+7m\u001c8eg\u0006IAo\\'j]V$Xm]\u0001\bi>Du.\u001e:t\u0003\u0019!x\u000eR1zg\u00061Ao\\+oSR$B!!\u000e\u0002<A\u00191.a\u000e\n\u0007\u0005e2M\u0001\u0004E_V\u0014G.\u001a\u0005\b\u0003'I\u0005\u0019AA\f\u0003\u0015!\u0003\u000f\\;t)\r)\u0018\u0011\t\u0005\u0007\u0003\u0007R\u0005\u0019A;\u0002\u000b=$\b.\u001a:\u0002\r\u0011j\u0017N\\;t)\r)\u0018\u0011\n\u0005\u0007\u0003\u0007Z\u0005\u0019A;\u0002\r\u0011\"\u0018.\\3t)\r)\u0018q\n\u0005\b\u0003#b\u0005\u0019AA\u001b\u0003\u00191\u0017m\u0019;pe\u0006!A\u0005Z5w)\r)\u0018q\u000b\u0005\b\u00033j\u0005\u0019AA\u001b\u0003\u001d!\u0017N^5t_J$B!!\u000e\u0002^!1\u0011\u0011\f(A\u0002U\fA\"\u001e8bef|F%\\5okN,\u0012!^\u0001\tSN4\u0015N\\5uKR\u0011\u0011q\r\t\u0004W\u0006%\u0014bAA6G\n9!i\\8mK\u0006t\u0017aA7j]R\u0019Q/!\u001d\t\r\u0005\r\u0013\u000b1\u0001v\u0003\ri\u0017\r\u001f\u000b\u0004k\u0006]\u0004BBA\"%\u0002\u0007Q/A\u0002eSZ$2!^A?\u0011\u001d\tIf\u0015a\u0001\u0003k!B!!\u000e\u0002\u0002\"1\u00111\t+A\u0002U\f!a\u001a;\u0015\t\u0005\u001d\u0014q\u0011\u0005\u0007\u0003\u0007*\u0006\u0019A;\u0002\t\u001d$X-\u001d\u000b\u0005\u0003O\ni\t\u0003\u0004\u0002DY\u0003\r!^\u0001\u0003YR$B!a\u001a\u0002\u0014\"1\u00111I,A\u0002U\fA\u0001\u001c;fcR!\u0011qMAM\u0011\u0019\t\u0019\u0005\u0017a\u0001k\u0006)Q.\u001b8vgR\u0019Q/a(\t\r\u0005\r\u0013\f1\u0001v\u0003\riW\u000f\u001c\u000b\u0004k\u0006\u0015\u0006bBA)5\u0002\u0007\u0011QG\u0001\u0004]\u0016<\u0017\u0001\u00029mkN$2!^AW\u0011\u0019\t\u0019\u0005\u0018a\u0001k\u0006QAo\\\"pCJ\u001cXm\u001d;*\ty\n\u0019,H\u0005\u0004\u0003k{&A\u0004$j]&$X\rR;sCRLwN\u001c\u0002\t\u0013:4\u0017N\\5uKN\u0011Q$\u001e\u000b\u0003\u0003{\u00032!a0\u001e\u001b\u0005\tAcA;\u0002D\"1\u00111I\u0010A\u0002U$2!^Ad\u0011\u0019\t\u0019\u0005\ta\u0001kR\u0019Q/a3\t\u000f\u0005E\u0013\u00051\u0001\u00026Q\u0019Q/a4\t\u000f\u0005e#\u00051\u0001\u00026Q!\u0011QGAj\u0011\u0019\tIf\ta\u0001k\u0006!a-Y5m)\u0011\tI.a8\u0011\u0007-\fY.C\u0002\u0002^\u000e\u0014qAT8uQ&tw\rC\u0004\u0002b\u0016\u0002\r!a9\u0002\t]D\u0017\r\u001e\t\u0005\u0003K\fiO\u0004\u0003\u0002h\u0006%\bC\u0001>d\u0013\r\tYoY\u0001\u0007!J,G-\u001a4\n\t\u0005=\u0018\u0011\u001f\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005-8-K\u0002\u001e\u0003k4a!a>\u001e\u0001\u0005e(!\u0004\u001fm_\u000e\fG\u000eI2iS2$gh\u0005\u0003\u0002v\u0006u\u0006bBA\u0005\u0007\u0001\u0007\u0011Q\u0007\u0005\b\u0003'\u0019\u0001\u0019AA\f)\u0019\u0011\tAa\u0001\u0003\u0006A\u0019q-a-\t\u000f\u0005%A\u00011\u0001\u0002\u000e!9\u00111\u0003\u0003A\u0002\u0005]AC\u0002B\u0001\u0005\u0013\u0011Y\u0001C\u0004\u0002\n\u0015\u0001\r!!\u0004\t\u000f\u0005MQ\u00011\u0001\u0002d\u0006\u0001R.\u0019=Qe\u0016\u001c\u0017n]3E_V\u0014G.Z\b\u0003\u0005#\u0001\u0003b\u0011!\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u000b\u0004k\nU\u0001b\u0002B\f\u000f\u0001\u0007\u00111]\u0001\u0002g\u0006)qo\u001c:egR!!Q\u0004B\u001a!\u0019\u0011yB!\t\u0003&9\u00111N`\u0005\u0005\u0005G\t)A\u0001\u0003MSN$\b\u0003\u0002B\u0014\u0005ci!A!\u000b\u000b\t\t-\"QF\u0001\u0005Y\u0006twM\u0003\u0002\u00030\u0005!!.\u0019<b\u0013\u0011\tyO!\u000b\t\u000f\t]\u0001\u00021\u0001\u0002d\u0006aQ\r\u001f9b]\u0012d\u0015MY3mgR!!\u0011\bB\u001e!\u0015A(\u0011EAr\u0011\u001d\u0011i$\u0003a\u0001\u0003G\fa\u0001\\1cK2\u001c\u0018A\u0004;j[\u0016,f.\u001b;MC\n,Gn\u001d\t\u0007\u0005\u0007\u0012iEa\u0014\u000e\u0005\t\u0015#\u0002\u0002B$\u0005\u0013\n\u0011\"[7nkR\f'\r\\3\u000b\u0007\t-3-\u0001\u0006d_2dWm\u0019;j_:LAAa\t\u0003FA91N!\u0015\u0003V\t\u0015\u0012b\u0001B*G\n1A+\u001e9mKJ\u0002BAa\u0016\u0003`5\u0011!\u0011\f\u0006\u0004E\nm#\u0002\u0002B/\u0005[\tA!\u001e;jY&!\u0011q\u0004B-\u00031!\u0018.\\3V]&$h*Y7f+\t\u0011)\u0007\u0005\u0005\u0002f\n\u001d\u0014qCAr\u0013\u0011\u0011I'!=\u0003\u00075\u000b\u0007/A\u0007uS6,WK\\5u\u001d\u0006lW\rI\u0001\ti&lW-\u00168jiV\u0011!\u0011\u000f\t\t\u0003K\u00149'a9\u0002\u0018\u0005IA/[7f+:LG\u000fI\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\u0011IH!!\u0011\u000b-\u0014YHa \n\u0007\tu4M\u0001\u0004PaRLwN\u001c\t\bW\nE\u0013QBA\f\u0011\u001d\u00119b\u0004a\u0001\u0003G$BA!\u001f\u0003\u0006\"1!q\u0011\tA\u0002U\f\u0011\u0001Z\u0001\nMJ|WNT1o_N$2!\u001eBG\u0011\u001d\u0011y)\u0005a\u0001\u0003k\tQA\\1o_N\f!Bq[t?B,'o\u00188t\u001f\t\u0011)J\b\u0002\u0004Q\bIQn]0qKJ|fn]\b\u0003\u00057s2a\u0004\"A\u0003!\u0019x\f]3s?:\u001cxB\u0001BQ=\u0011Y$T3\u0001\u0002\u00155Lgn\u00189fe~s7o\u0004\u0002\u0003(z)Q\u0002\u007f$Y\u0001\u0005A\u0001n\u00189fe~s7o\u0004\u0002\u0003.z11A\u0012\u00199B\u0003\t\u0001\u0002Z0qKJ|fn]\b\u0003\u0005gsbA\u0014K\u0012 \u0002\u0001A\u0003\u0002B\u0001\u0005oCqAa$\u0019\u0001\u0004\ti!\u0001\u0003[KJ|WC\u0001B\u0001\u0003\u0015QVM]8!\u0003%)f\u000eZ3gS:,G-\u0006\u0002\u0002>\u0006QQK\u001c3fM&tW\r\u001a\u0011\u0002\u0007%sg-\u0001\u0003J]\u001a\u0004\u0013\u0001C'j]V\u001c\u0018J\u001c4\u0002\u00135Kg.^:J]\u001a\u0004\u0013AB2sK\u0006$X\r\u0006\u0004\u0003\u0002\tE'1\u001b\u0005\b\u0003\u0013!\u0004\u0019AA\u0007\u0011\u001d\t\u0019\u0002\u000ea\u0001\u0003/!R!\u001eBl\u00053Dq!!\u00036\u0001\u0004\t)\u0004C\u0004\u0002\u0014U\u0002\r!a\u0006\u0015\r\t\u0005!Q\u001cBp\u0011\u001d\tIA\u000ea\u0001\u0003\u001bAq!a\u00057\u0001\u0004\t\u0019\u000fF\u0002v\u0005GDqAa\u00068\u0001\u0004\t\u0019/A\tEkJ\fG/[8o\u0013N|%\u000fZ3sK\u0012\u00042!a0:\u0005E!UO]1uS>t\u0017j](sI\u0016\u0014X\rZ\n\u0006s\t5(1\u001f\t\u0005\u0005O\u0011y/\u0003\u0003\u0003r\n%\"AB(cU\u0016\u001cG\u000f\u0005\u0003y\u0005k,\u0018\u0002\u0002B|\u0003\u000b\u0011\u0001b\u0014:eKJLgn\u001a\u000b\u0003\u0005O\fqaY8na\u0006\u0014X\r\u0006\u0004\u0003\u0000\u000e\u00151\u0011\u0002\t\u0004W\u000e\u0005\u0011bAB\u0002G\n\u0019\u0011J\u001c;\t\r\r\u001d1\b1\u0001v\u0003\u0005\t\u0007BBB\u0006w\u0001\u0007Q/A\u0001c\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\t5\b")
public abstract class Duration
implements Serializable,
Ordered<Duration> {
    public static Duration create(String string) {
        return Duration$.MODULE$.create(string);
    }

    public static FiniteDuration create(long l, String string) {
        return Duration$.MODULE$.create(l, string);
    }

    public static Duration create(double d, TimeUnit timeUnit) {
        return Duration$.MODULE$.create(d, timeUnit);
    }

    public static FiniteDuration create(long l, TimeUnit timeUnit) {
        return Duration$.MODULE$.create(l, timeUnit);
    }

    public static Infinite MinusInf() {
        return Duration$.MODULE$.MinusInf();
    }

    public static Infinite Inf() {
        return Duration$.MODULE$.Inf();
    }

    public static Infinite Undefined() {
        return Duration$.MODULE$.Undefined();
    }

    public static FiniteDuration Zero() {
        return Duration$.MODULE$.Zero();
    }

    public static FiniteDuration fromNanos(long l) {
        return Duration$.MODULE$.fromNanos(l);
    }

    public static Duration fromNanos(double d) {
        return Duration$.MODULE$.fromNanos(d);
    }

    public static Option<Tuple2<Object, TimeUnit>> unapply(Duration duration) {
        return Duration$.MODULE$.unapply(duration);
    }

    public static Option<Tuple2<Object, TimeUnit>> unapply(String string) {
        return Duration$.MODULE$.unapply(string);
    }

    public static Duration apply(String string) {
        return Duration$.MODULE$.apply(string);
    }

    public static FiniteDuration apply(long l, String string) {
        return Duration$.MODULE$.apply(l, string);
    }

    public static FiniteDuration apply(long l, TimeUnit timeUnit) {
        return Duration$.MODULE$.apply(l, timeUnit);
    }

    public static Duration apply(double d, TimeUnit timeUnit) {
        return Duration$.MODULE$.apply(d, timeUnit);
    }

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    public abstract long length();

    public abstract TimeUnit unit();

    public abstract long toNanos();

    public abstract long toMicros();

    public abstract long toMillis();

    public abstract long toSeconds();

    public abstract long toMinutes();

    public abstract long toHours();

    public abstract long toDays();

    public abstract double toUnit(TimeUnit var1);

    public abstract Duration $plus(Duration var1);

    public abstract Duration $minus(Duration var1);

    public abstract Duration $times(double var1);

    public abstract Duration $div(double var1);

    public abstract double $div(Duration var1);

    public abstract Duration unary_$minus();

    public abstract boolean isFinite();

    public Duration min(Duration other) {
        if (this.$less(other)) {
            return this;
        }
        return other;
    }

    public Duration max(Duration other) {
        if (this.$greater(other)) {
            return this;
        }
        return other;
    }

    public Duration div(double divisor) {
        return this.$div(divisor);
    }

    public double div(Duration other) {
        return this.$div(other);
    }

    public boolean gt(Duration other) {
        return this.$greater(other);
    }

    public boolean gteq(Duration other) {
        return this.$greater$eq(other);
    }

    public boolean lt(Duration other) {
        return this.$less(other);
    }

    public boolean lteq(Duration other) {
        return this.$less$eq(other);
    }

    public Duration minus(Duration other) {
        return this.$minus(other);
    }

    public Duration mul(double factor) {
        return this.$times(factor);
    }

    public Duration neg() {
        return this.unary_$minus();
    }

    public Duration plus(Duration other) {
        return this.$plus(other);
    }

    public abstract Duration toCoarsest();

    public Duration() {
        Ordered.$init$(this);
    }

    public static abstract class Infinite
    extends Duration {
        @Override
        public Duration $plus(Duration other) {
            Infinite infinite = other == Duration$.MODULE$.Undefined() ? Duration$.MODULE$.Undefined() : (other instanceof Infinite && (Infinite)other != this ? Duration$.MODULE$.Undefined() : this);
            return infinite;
        }

        @Override
        public Duration $minus(Duration other) {
            Infinite infinite = other == Duration$.MODULE$.Undefined() ? Duration$.MODULE$.Undefined() : (other instanceof Infinite && (Infinite)other == this ? Duration$.MODULE$.Undefined() : this);
            return infinite;
        }

        @Override
        public Duration $times(double factor) {
            if (factor == 0.0 || Double.isNaN(factor)) {
                return Duration$.MODULE$.Undefined();
            }
            if (factor < 0.0) {
                return this.unary_$minus();
            }
            return this;
        }

        @Override
        public Duration $div(double divisor) {
            if (Double.isNaN(divisor) || Predef$.MODULE$.double2Double(divisor).isInfinite()) {
                return Duration$.MODULE$.Undefined();
            }
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (new RichDouble(divisor).compare(BoxesRunTime.boxToDouble(0.0)) < 0) {
                return this.unary_$minus();
            }
            return this;
        }

        @Override
        public double $div(Duration divisor) {
            double d = divisor instanceof Infinite ? Double.NaN : Double.POSITIVE_INFINITY * (double)(this.$greater(Duration$.MODULE$.Zero()) ^ divisor.$greater$eq(Duration$.MODULE$.Zero()) ? -1 : 1);
            return d;
        }

        @Override
        public final boolean isFinite() {
            return false;
        }

        private Nothing$ fail(String what) {
            throw new IllegalArgumentException(new StringBuilder(34).append(what).append(" not allowed on infinite Durations").toString());
        }

        @Override
        public final long length() {
            throw this.fail("length");
        }

        @Override
        public final TimeUnit unit() {
            throw this.fail("unit");
        }

        @Override
        public final long toNanos() {
            throw this.fail("toNanos");
        }

        @Override
        public final long toMicros() {
            throw this.fail("toMicros");
        }

        @Override
        public final long toMillis() {
            throw this.fail("toMillis");
        }

        @Override
        public final long toSeconds() {
            throw this.fail("toSeconds");
        }

        @Override
        public final long toMinutes() {
            throw this.fail("toMinutes");
        }

        @Override
        public final long toHours() {
            throw this.fail("toHours");
        }

        @Override
        public final long toDays() {
            throw this.fail("toDays");
        }

        @Override
        public final Duration toCoarsest() {
            return this;
        }
    }
}

