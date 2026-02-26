/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.duration;

import java.util.concurrent.TimeUnit;
import scala.MatchError;
import scala.Predef$;
import scala.concurrent.duration.Deadline;
import scala.concurrent.duration.Deadline$;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.Duration$;
import scala.concurrent.duration.FiniteDuration$;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichLong;

@ScalaSignature(bytes="\u0006\u0001\t\u0015t!\u0002#F\u0011\u0003ae!\u0002(F\u0011\u0003y\u0005\"B,\u0002\t\u0003Av!B-\u0002\u0011\u0007Qf!\u0002/\u0002\u0011\u0003i\u0006BB,\u0005\t\u0003\t9\u0010C\u0004\u0002V\u0011!\t!!?\t\u0013\u0005}H!!A\u0005\n\t\u0005\u0001b\u0002B\u0002\u0003\u0011\u0005!Q\u0001\u0005\b\u0005\u0007\tA\u0011\u0001B\u0006\u0011%\u0011y\"\u0001b\u0001\n\u001b\u0011\t\u0003\u0003\u0005\u0003(\u0005\u0001\u000bQ\u0002B\u0012\u0011%\u0011I#\u0001b\u0001\n\u001b\u0011Y\u0003\u0003\u0005\u00032\u0005\u0001\u000bQ\u0002B\u0017\u0011%\u0011\u0019$\u0001b\u0001\n\u001b\u0011)\u0004\u0003\u0005\u0003<\u0005\u0001\u000bQ\u0002B\u001c\u0011%\u0011i$\u0001b\u0001\n\u001b\u0011y\u0004\u0003\u0005\u0003F\u0005\u0001\u000bQ\u0002B!\u0011%\u00119%\u0001b\u0001\n\u001b\u0011I\u0005\u0003\u0005\u0003P\u0005\u0001\u000bQ\u0002B&\u0011%\u0011\t&\u0001b\u0001\n\u001b\u0011\u0019\u0006\u0003\u0005\u0003Z\u0005\u0001\u000bQ\u0002B+\u0011%\u0011Y&\u0001b\u0001\n\u001b\u0011i\u0006\u0003\u0005\u0003d\u0005\u0001\u000bQ\u0002B0\u0011%\ty0AA\u0001\n\u0013\u0011\tA\u0002\u0003O\u000b\n\u0019\b\u0002C<\u001a\u0005\u000b\u0007I\u0011\u0001=\t\u0011qL\"\u0011!Q\u0001\neD\u0001\"`\r\u0003\u0006\u0004%\tA \u0005\n\u0003\u0017I\"\u0011!Q\u0001\n}DaaV\r\u0005\u0002\u00055\u0001\u0002CA\n3\u0001&I!!\u0006\t\r\u0005\u0005\u0012\u0004\"\u0001y\u0011\u0019\t\u0019#\u0007C\u0001q\"1\u0011QE\r\u0005\u0002aDa!a\n\u001a\t\u0003A\bBBA\u00153\u0011\u0005\u0001\u0010\u0003\u0004\u0002,e!\t\u0001\u001f\u0005\u0007\u0003[IB\u0011\u0001=\t\u000f\u0005=\u0012\u0004\"\u0001\u00022!9\u0011QH\r\u0005\u0002\u0005}\u0002\u0002CA$3\u0001&I!!\u0013\t\u000f\u0005E\u0013\u0004\"\u0011\u0002T!9\u0011QK\r\u0005\u0002\u0005]\u0003\u0002CA23\u0001&I!!\u001a\t\u0011\u0005=\u0014\u0004)C\u0005\u0003cBq!a\u001f\u001a\t\u0003\ti\bC\u0004\u0002\u0002f!\t!a!\t\u000f\u0005\u001d\u0015\u0004\"\u0001\u0002\n\"9\u0011qR\r\u0005\u0002\u0005E\u0005\u0002CAL3\u0001&I!!'\t\u000f\u0005=\u0015\u0004\"\u0001\u0002\u001c\"9\u00111P\r\u0005\u0002\u0005}\u0005bBAA3\u0011\u0005\u00111\u0015\u0005\b\u0003OKB\u0011AAU\u0011\u001d\ti+\u0007C\u0001\u0003_Cq!a-\u001a\t\u0003\t)\fC\u0004\u0002 e!\t!!/\t\u000f\u0005=\u0015\u0004\"\u0001\u0002>\"9\u0011qQ\r\u0005\u0002\u0005\u0005\u0007bBAc3\u0011%\u0011q\u0019\u0005\b\u0003#LB\u0011AAj\u0011\u001d\t9.\u0007C\u0001\u00033Dq!!8\u001a\t\u0003\ty\u000eC\u0004\u0002bf!)!a9\t\u000f\u0005\u0015\u0018\u0004\"\u0012\u0002`\"9\u0011q]\r\u0005B\u0005%\bbBAz3\u0011\u0005\u0013Q_\u0001\u000f\r&t\u0017\u000e^3EkJ\fG/[8o\u0015\t1u)\u0001\u0005ekJ\fG/[8o\u0015\tA\u0015*\u0001\u0006d_:\u001cWO\u001d:f]RT\u0011AS\u0001\u0006g\u000e\fG.Y\u0002\u0001!\ti\u0015!D\u0001F\u000591\u0015N\\5uK\u0012+(/\u0019;j_:\u001c2!\u0001)U!\t\t&+D\u0001J\u0013\t\u0019\u0016J\u0001\u0004B]f\u0014VM\u001a\t\u0003#VK!AV%\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\u0005a\u0015a\u0006$j]&$X\rR;sCRLwN\\%t\u001fJ$WM]3e!\tYF!D\u0001\u0002\u0005]1\u0015N\\5uK\u0012+(/\u0019;j_:L5o\u0014:eKJ,GmE\u0002\u0005=\u001a\u0004\"a\u00183\u000e\u0003\u0001T!!\u00192\u0002\t1\fgn\u001a\u0006\u0002G\u0006!!.\u0019<b\u0013\t)\u0007M\u0001\u0004PE*,7\r\u001e\t\u0004O>\u0014hB\u00015n\u001d\tIG.D\u0001k\u0015\tY7*\u0001\u0004=e>|GOP\u0005\u0002\u0015&\u0011a.S\u0001\ba\u0006\u001c7.Y4f\u0013\t\u0001\u0018O\u0001\u0005Pe\u0012,'/\u001b8h\u0015\tq\u0017\n\u0005\u0002N3M\u0011\u0011\u0004\u001e\t\u0003\u001bVL!A^#\u0003\u0011\u0011+(/\u0019;j_:\fa\u0001\\3oORDW#A=\u0011\u0005ES\u0018BA>J\u0005\u0011auN\\4\u0002\u000f1,gn\u001a;iA\u0005!QO\\5u+\u0005y\b\u0003BA\u0001\u0003\u000bq1!TA\u0002\u0013\tqW)\u0003\u0003\u0002\b\u0005%!\u0001\u0003+j[\u0016,f.\u001b;\u000b\u00059,\u0015!B;oSR\u0004C#\u0002:\u0002\u0010\u0005E\u0001\"B<\u001f\u0001\u0004I\b\"B?\u001f\u0001\u0004y\u0018a\u00022pk:$W\r\u001a\u000b\u0005\u0003/\ti\u0002E\u0002R\u00033I1!a\u0007J\u0005\u001d\u0011un\u001c7fC:Da!a\b \u0001\u0004I\u0018aA7bq\u00069Ao\u001c(b]>\u001c\u0018\u0001\u0003;p\u001b&\u001c'o\\:\u0002\u0011Q|W*\u001b7mSN\f\u0011\u0002^8TK\u000e|g\u000eZ:\u0002\u0013Q|W*\u001b8vi\u0016\u001c\u0018a\u0002;p\u0011>,(o]\u0001\u0007i>$\u0015-_:\u0002\rQ|WK\\5u)\u0011\t\u0019$!\u000f\u0011\u0007E\u000b)$C\u0002\u00028%\u0013a\u0001R8vE2,\u0007BBA\u001eO\u0001\u0007q0A\u0001v\u0003\u001d1'o\\7O_^,\"!!\u0011\u0011\u00075\u000b\u0019%C\u0002\u0002F\u0015\u0013\u0001\u0002R3bI2Lg.Z\u0001\u000bk:LGo\u0015;sS:<WCAA&!\ry\u0016QJ\u0005\u0004\u0003\u001f\u0002'AB*ue&tw-\u0001\u0005u_N#(/\u001b8h)\t\tY%A\u0004d_6\u0004\u0018M]3\u0015\t\u0005e\u0013q\f\t\u0004#\u0006m\u0013bAA/\u0013\n\u0019\u0011J\u001c;\t\r\u0005\u00054\u00061\u0001u\u0003\u0015yG\u000f[3s\u0003\u001d\u0019\u0018MZ3BI\u0012$R!_A4\u0003WBa!!\u001b-\u0001\u0004I\u0018!A1\t\r\u00055D\u00061\u0001z\u0003\u0005\u0011\u0017aA1eIR)!/a\u001d\u0002x!1\u0011QO\u0017A\u0002e\f1b\u001c;iKJdUM\\4uQ\"1\u0011\u0011P\u0017A\u0002}\f\u0011b\u001c;iKJ,f.\u001b;\u0002\u000b\u0011\u0002H.^:\u0015\u0007Q\fy\b\u0003\u0004\u0002b9\u0002\r\u0001^\u0001\u0007I5Lg.^:\u0015\u0007Q\f)\t\u0003\u0004\u0002b=\u0002\r\u0001^\u0001\u0007IQLW.Z:\u0015\u0007Q\fY\tC\u0004\u0002\u000eB\u0002\r!a\r\u0002\r\u0019\f7\r^8s\u0003\u0011!C-\u001b<\u0015\u0007Q\f\u0019\nC\u0004\u0002\u0016F\u0002\r!a\r\u0002\u000f\u0011Lg/[:pe\u0006IQ.\u001b8vgj+'o\\\u000b\u0003\u0003g!B!a\r\u0002\u001e\"1\u0011QS\u001aA\u0002Q$2A]AQ\u0011\u0019\t\t\u0007\u000ea\u0001eR\u0019!/!*\t\r\u0005\u0005T\u00071\u0001s\u0003\u0011\u0001H.^:\u0015\u0007I\fY\u000b\u0003\u0004\u0002bY\u0002\rA]\u0001\u0006[&tWo\u001d\u000b\u0004e\u0006E\u0006BBA1o\u0001\u0007!/A\u0002nS:$2A]A\\\u0011\u0019\t\t\u0007\u000fa\u0001eR\u0019!/a/\t\r\u0005\u0005\u0014\b1\u0001s)\r\u0011\u0018q\u0018\u0005\u0007\u0003+S\u0004\u0019A=\u0015\u0007I\f\u0019\r\u0003\u0004\u0002\u000en\u0002\r!_\u0001\bg\u00064W-T;m)\u0015I\u0018\u0011ZAg\u0011\u0019\tY\r\u0010a\u0001s\u0006\u0011q,\u0019\u0005\u0007\u0003\u001fd\u0004\u0019A=\u0002\u0005}\u0013\u0017a\u00013jmR\u0019!/!6\t\r\u0005UU\b1\u0001z\u0003\riW\u000f\u001c\u000b\u0004e\u0006m\u0007BBAG}\u0001\u0007\u00110\u0001\u0007v]\u0006\u0014\u0018p\u0018\u0013nS:,8/F\u0001s\u0003!I7OR5oSR,GCAA\f\u0003)!xnQ8beN,7\u000f^\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005]\u00111\u001e\u0005\b\u0003C\u0012\u0005\u0019AAw!\r\t\u0016q^\u0005\u0004\u0003cL%aA!os\u0006A\u0001.Y:i\u0007>$W\r\u0006\u0002\u0002ZQ\t!\f\u0006\u0004\u0002Z\u0005m\u0018Q \u0005\u0007\u0003S2\u0001\u0019\u0001:\t\r\u00055d\u00011\u0001s\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0003y\u000bQ!\u00199qYf$RA\u001dB\u0004\u0005\u0013AQa\u001e\u0005A\u0002eDQ! \u0005A\u0002}$RA\u001dB\u0007\u0005\u001fAQa^\u0005A\u0002eDa!`\u0005A\u0002\tE\u0001\u0003\u0002B\n\u00057qAA!\u0006\u0003\u0018A\u0011\u0011.S\u0005\u0004\u00053I\u0015A\u0002)sK\u0012,g-\u0003\u0003\u0002P\tu!b\u0001B\r\u0013\u00061Q.\u0019=`]N,\"Aa\t\u0010\u0005\t\u0015b\u0004C@\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0002\u000f5\f\u0007p\u00188tA\u00059Q.\u0019=`\u0005X\u001eXC\u0001B\u0017\u001f\t\u0011yCH\u0004!\tp-;}U|\u0002\u00115\f\u0007p\u0018b6h\u0002\na!\\1y?6\u001cXC\u0001B\u001c\u001f\t\u0011ID\b\u0004\tGn\u0004.L~\u0001\b[\u0006Dx,\\:!\u0003\u0015i\u0017\r_0t+\t\u0011\te\u0004\u0002\u0003Dy)!!Ja~\t\u00051Q.\u0019=`g\u0002\nq!\\1y?6Lg.\u0006\u0002\u0003L=\u0011!Q\n\u0010\u0005\u0013%z:?\u0001\u0005nCb|V.\u001b8!\u0003\u0015i\u0017\r_0i+\t\u0011)f\u0004\u0002\u0003Xy\u0019qeF\u0000\u0002\r5\f\u0007p\u00185!\u0003\u0015i\u0017\r_0e+\t\u0011yf\u0004\u0002\u0003by\u0019\u0011\u0001i\u0000\u0002\r5\f\u0007p\u00183!\u0001")
public final class FiniteDuration
extends Duration {
    private final long length;
    private final TimeUnit unit;

    public static FiniteDuration apply(long l, String string) {
        return FiniteDuration$.MODULE$.apply(l, string);
    }

    public static FiniteDuration apply(long l, TimeUnit timeUnit) {
        return FiniteDuration$.MODULE$.apply(l, timeUnit);
    }

    @Override
    public long length() {
        return this.length;
    }

    @Override
    public TimeUnit unit() {
        return this.unit;
    }

    private boolean bounded(long max) {
        return -max <= this.length() && this.length() <= max;
    }

    @Override
    public long toNanos() {
        return this.unit().toNanos(this.length());
    }

    @Override
    public long toMicros() {
        return this.unit().toMicros(this.length());
    }

    @Override
    public long toMillis() {
        return this.unit().toMillis(this.length());
    }

    @Override
    public long toSeconds() {
        return this.unit().toSeconds(this.length());
    }

    @Override
    public long toMinutes() {
        return this.unit().toMinutes(this.length());
    }

    @Override
    public long toHours() {
        return this.unit().toHours(this.length());
    }

    @Override
    public long toDays() {
        return this.unit().toDays(this.length());
    }

    @Override
    public double toUnit(TimeUnit u) {
        return (double)this.toNanos() / (double)TimeUnit.NANOSECONDS.convert(1L, u);
    }

    public Deadline fromNow() {
        return Deadline$.MODULE$.now().$plus(this);
    }

    private String unitString() {
        return new StringBuilder(0).append((String)Duration$.MODULE$.timeUnitName().apply(this.unit())).append((Object)(this.length() == 1L ? "" : "s")).toString();
    }

    public String toString() {
        return new StringBuilder(1).append(this.length()).append(" ").append(this.unitString()).toString();
    }

    @Override
    public int compare(Duration other) {
        int n;
        if (other instanceof FiniteDuration) {
            FiniteDuration finiteDuration = (FiniteDuration)other;
            long l = this.toNanos();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            n = new RichLong(l).compare(BoxesRunTime.boxToLong(finiteDuration.toNanos()));
        } else {
            n = -other.compare(this);
        }
        return n;
    }

    private long safeAdd(long a, long b) {
        if (b > 0L && a > Long.MAX_VALUE - b || b < 0L && a < Long.MIN_VALUE - b) {
            throw new IllegalArgumentException("integer overflow");
        }
        return a + b;
    }

    private FiniteDuration add(long otherLength, TimeUnit otherUnit) {
        TimeUnit commonUnit = otherUnit.convert(1L, this.unit()) == 0L ? this.unit() : otherUnit;
        long totalLength = this.safeAdd(commonUnit.convert(this.length(), this.unit()), commonUnit.convert(otherLength, otherUnit));
        return new FiniteDuration(totalLength, commonUnit);
    }

    @Override
    public Duration $plus(Duration other) {
        Duration duration;
        if (other instanceof FiniteDuration) {
            FiniteDuration finiteDuration = (FiniteDuration)other;
            duration = this.add(finiteDuration.length(), finiteDuration.unit());
        } else {
            duration = other;
        }
        return duration;
    }

    @Override
    public Duration $minus(Duration other) {
        Duration duration;
        if (other instanceof FiniteDuration) {
            FiniteDuration finiteDuration = (FiniteDuration)other;
            duration = this.add(-finiteDuration.length(), finiteDuration.unit());
        } else {
            duration = other.unary_$minus();
        }
        return duration;
    }

    @Override
    public Duration $times(double factor) {
        if (!Predef$.MODULE$.double2Double(factor).isInfinite()) {
            return Duration$.MODULE$.fromNanos((double)this.toNanos() * factor);
        }
        if (Double.isNaN(factor)) {
            return Duration$.MODULE$.Undefined();
        }
        if (factor > 0.0 ^ this.$less(Duration$.MODULE$.Zero())) {
            return Duration$.MODULE$.Inf();
        }
        return Duration$.MODULE$.MinusInf();
    }

    @Override
    public Duration $div(double divisor) {
        if (!Predef$.MODULE$.double2Double(divisor).isInfinite()) {
            return Duration$.MODULE$.fromNanos((double)this.toNanos() / divisor);
        }
        if (Double.isNaN(divisor)) {
            return Duration$.MODULE$.Undefined();
        }
        return Duration$.MODULE$.Zero();
    }

    private double minusZero() {
        return -0.0;
    }

    @Override
    public double $div(Duration divisor) {
        if (divisor.isFinite()) {
            return (double)this.toNanos() / (double)divisor.toNanos();
        }
        if (divisor == Duration$.MODULE$.Undefined()) {
            return Double.NaN;
        }
        if (this.length() < 0L ^ divisor.$greater(Duration$.MODULE$.Zero())) {
            return 0.0;
        }
        return this.minusZero();
    }

    public FiniteDuration $plus(FiniteDuration other) {
        return this.add(other.length(), other.unit());
    }

    public FiniteDuration $minus(FiniteDuration other) {
        return this.add(-other.length(), other.unit());
    }

    public FiniteDuration plus(FiniteDuration other) {
        return this.$plus(other);
    }

    public FiniteDuration minus(FiniteDuration other) {
        return this.$minus(other);
    }

    public FiniteDuration min(FiniteDuration other) {
        if (this.$less(other)) {
            return this;
        }
        return other;
    }

    public FiniteDuration max(FiniteDuration other) {
        if (this.$greater(other)) {
            return this;
        }
        return other;
    }

    public FiniteDuration $div(long divisor) {
        return Duration$.MODULE$.fromNanos(this.toNanos() / divisor);
    }

    public FiniteDuration $times(long factor) {
        return new FiniteDuration(this.safeMul(this.length(), factor), this.unit());
    }

    private long safeMul(long _a, long _b) {
        long a = package$.MODULE$.abs(_a);
        long b = package$.MODULE$.abs(_b);
        if (Long.numberOfLeadingZeros(a) + Long.numberOfLeadingZeros(b) < 64) {
            throw new IllegalArgumentException("multiplication overflow");
        }
        long product = a * b;
        if (product < 0L) {
            throw new IllegalArgumentException("multiplication overflow");
        }
        if (a == _a ^ b == _b) {
            return -product;
        }
        return product;
    }

    public FiniteDuration div(long divisor) {
        return this.$div(divisor);
    }

    public FiniteDuration mul(long factor) {
        return this.$times(factor);
    }

    @Override
    public FiniteDuration unary_$minus() {
        return Duration$.MODULE$.apply(-this.length(), this.unit());
    }

    @Override
    public final boolean isFinite() {
        return true;
    }

    @Override
    public final FiniteDuration toCoarsest() {
        TimeUnit timeUnit = this.unit();
        TimeUnit timeUnit2 = TimeUnit.DAYS;
        if (!(timeUnit == null ? timeUnit2 != null : !((Object)((Object)timeUnit)).equals((Object)timeUnit2)) || this.length() == 0L) {
            return this;
        }
        return this.loop$1(this.length(), this.unit());
    }

    public boolean equals(Object other) {
        boolean bl;
        if (other instanceof FiniteDuration) {
            FiniteDuration finiteDuration = (FiniteDuration)other;
            bl = this.toNanos() == finiteDuration.toNanos();
        } else {
            bl = super.equals(other);
        }
        return bl;
    }

    public int hashCode() {
        return (int)this.toNanos();
    }

    public static final /* synthetic */ String $anonfun$new$1() {
        return "Duration is limited to +-(2^63-1)ns (ca. 292 years)";
    }

    private final FiniteDuration coarserOrThis$1(TimeUnit coarser, int divider, long length$1, TimeUnit unit$2) {
        if (length$1 % (long)divider == 0L) {
            return this.loop$1(length$1 / (long)divider, coarser);
        }
        TimeUnit timeUnit = unit$2;
        TimeUnit timeUnit2 = this.unit();
        if (!(timeUnit != null ? !((Object)((Object)timeUnit)).equals((Object)timeUnit2) : timeUnit2 != null)) {
            return this;
        }
        return FiniteDuration$.MODULE$.apply(length$1, unit$2);
    }

    private final FiniteDuration loop$1(long length, TimeUnit unit) {
        FiniteDuration finiteDuration;
        if (((Object)((Object)TimeUnit.DAYS)).equals((Object)unit)) {
            finiteDuration = FiniteDuration$.MODULE$.apply(length, unit);
        } else if (((Object)((Object)TimeUnit.HOURS)).equals((Object)unit)) {
            finiteDuration = this.coarserOrThis$1(TimeUnit.DAYS, 24, length, unit);
        } else if (((Object)((Object)TimeUnit.MINUTES)).equals((Object)unit)) {
            finiteDuration = this.coarserOrThis$1(TimeUnit.HOURS, 60, length, unit);
        } else if (((Object)((Object)TimeUnit.SECONDS)).equals((Object)unit)) {
            finiteDuration = this.coarserOrThis$1(TimeUnit.MINUTES, 60, length, unit);
        } else if (((Object)((Object)TimeUnit.MILLISECONDS)).equals((Object)unit)) {
            finiteDuration = this.coarserOrThis$1(TimeUnit.SECONDS, 1000, length, unit);
        } else if (((Object)((Object)TimeUnit.MICROSECONDS)).equals((Object)unit)) {
            finiteDuration = this.coarserOrThis$1(TimeUnit.MILLISECONDS, 1000, length, unit);
        } else if (((Object)((Object)TimeUnit.NANOSECONDS)).equals((Object)unit)) {
            finiteDuration = this.coarserOrThis$1(TimeUnit.MICROSECONDS, 1000, length, unit);
        } else {
            throw new MatchError((Object)unit);
        }
        return finiteDuration;
    }

    public FiniteDuration(long length, TimeUnit unit) {
        boolean bl;
        this.length = length;
        this.unit = unit;
        if (((Object)((Object)TimeUnit.NANOSECONDS)).equals((Object)unit)) {
            bl = this.bounded(Long.MAX_VALUE);
        } else if (((Object)((Object)TimeUnit.MICROSECONDS)).equals((Object)unit)) {
            bl = this.bounded(9223372036854775L);
        } else if (((Object)((Object)TimeUnit.MILLISECONDS)).equals((Object)unit)) {
            bl = this.bounded(9223372036854L);
        } else if (((Object)((Object)TimeUnit.SECONDS)).equals((Object)unit)) {
            bl = this.bounded(9223372036L);
        } else if (((Object)((Object)TimeUnit.MINUTES)).equals((Object)unit)) {
            bl = this.bounded(153722867L);
        } else if (((Object)((Object)TimeUnit.HOURS)).equals((Object)unit)) {
            bl = this.bounded(2562047L);
        } else if (((Object)((Object)TimeUnit.DAYS)).equals((Object)unit)) {
            bl = this.bounded(106751L);
        } else {
            long v = TimeUnit.DAYS.convert(length, unit);
            boolean bl2 = bl = -106751L <= v && v <= 106751L;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (!bl) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)FiniteDuration.$anonfun$new$1()).toString());
        }
    }
}

