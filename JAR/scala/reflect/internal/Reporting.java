/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.reflect.ScalaSignature;
import scala.reflect.internal.FatalError;
import scala.reflect.internal.Positions;
import scala.reflect.internal.Reporter;
import scala.reflect.internal.util.Position;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005=c!C\f\u0019!\u0003\r\taHA#\u0011\u0015!\u0003\u0001\"\u0001&\u0011\u0015I\u0003A\"\u0001+\u0011\u0015y\u0003A\"\u00011\r\u001d\u0019\u0004\u0001%A\u0002\u0002QBQ\u0001\n\u0003\u0005\u0002\u0015Bq!\u000e\u0003C\u0002\u0013\u0005a\u0007B\u00039\u0001\t\u0005\u0011\bC\u0003g\u0001\u0019EaGB\u0003?\u0001\u0005\u0005q\bC\u0003A\u0013\u0011\u0005\u0011\tC\u0003C\u0013\u0019\u00051\t\u0003\u0004_\u0013\u0001\u0006Ka\u0018\u0005\u0006E&!\ta\u0019\u0005\u0006O\u0002!\t\u0001\u001b\u0005\u0006E\u0002!\tA\u001b\u0005\u0006Y\u0002!\t!\u001c\u0005\u0006o\u0002!\t\u0001\u001f\u0005\b\u0003/\u0001A\u0011AA\r\u0011\u001d\ty\u0002\u0001C\u0001\u0003CAa\u0001\u001c\u0001\u0005\u0002\u0005\u0015\u0002BB<\u0001\t\u0003\ti\u0003C\u0004\u0002\u0018\u0001!\t!!\u0010\u0003\u0013I+\u0007o\u001c:uS:<'BA\r\u001b\u0003!Ig\u000e^3s]\u0006d'BA\u000e\u001d\u0003\u001d\u0011XM\u001a7fGRT\u0011!H\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001\u0001\u0005\u0005\u0002\"E5\tA$\u0003\u0002$9\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$C#\u0001\u0014\u0011\u0005\u0005:\u0013B\u0001\u0015\u001d\u0005\u0011)f.\u001b;\u0002\u0011I,\u0007o\u001c:uKJ,\u0012a\u000b\t\u0003Y5j\u0011\u0001G\u0005\u0003]a\u0011\u0001BU3q_J$XM]\u0001\u000bGV\u0014(/\u001a8u%VtW#A\u0019\u0011\u0005I\"Q\"\u0001\u0001\u0003\u0019I+hNU3q_J$\u0018N\\4\u0014\u0005\u0011\u0001\u0013!\u0003:fa>\u0014H/\u001b8h+\u00059\u0004C\u0001\u001a\b\u0005=\u0001VM\u001d*v]J+\u0007o\u001c:uS:<\u0017C\u0001\u001e>!\t\t3(\u0003\u0002=9\t9aj\u001c;iS:<\u0007C\u0001\u001a\n\u0005M\u0001VM\u001d*v]J+\u0007o\u001c:uS:<')Y:f'\tI\u0001%\u0001\u0004=S:LGO\u0010\u000b\u0002{\u0005\u0011B-\u001a9sK\u000e\fG/[8o/\u0006\u0014h.\u001b8h)\u00191Ci\u0013-[9\")Qi\u0003a\u0001\r\u0006\u0019\u0001o\\:\u0011\u0005I:\u0015B\u0001%J\u0005!\u0001vn]5uS>t\u0017B\u0001&\u0019\u0005%\u0001vn]5uS>t7\u000fC\u0003M\u0017\u0001\u0007Q*A\u0002ng\u001e\u0004\"AT+\u000f\u0005=\u001b\u0006C\u0001)\u001d\u001b\u0005\t&B\u0001*\u001f\u0003\u0019a$o\\8u}%\u0011A\u000bH\u0001\u0007!J,G-\u001a4\n\u0005Y;&AB*ue&twM\u0003\u0002U9!)\u0011l\u0003a\u0001\u001b\u0006)1/\u001b8dK\")1l\u0003a\u0001\u001b\u0006!1/\u001b;f\u0011\u0015i6\u00021\u0001N\u0003\u0019y'/[4j]\u0006\t2/\u001e9qY\u0016lWM\u001c;fI\u0016\u0013(o\u001c:\u0011\u0005\u0005\u0002\u0017BA1\u001d\u0005\u001d\u0011un\u001c7fC:\fac];qa2,W.\u001a8u\u000bJ\u0014xN]'fgN\fw-\u001a\u000b\u0003\u001b\u0012DQ!Z\u0007A\u00025\u000bA\"\u001a:s_JlUm]:bO\u0016\fq\u0002U3s%Vt'+\u001a9peRLgnZ\u0001\u0015gV\u0004\b\u000f\\3nK:$H+\u001f9feN#\u0018\r^3\u0015\u00055K\u0007\"B3\u000f\u0001\u0004iECA'l\u0011\u0015)w\u00021\u0001N\u0003\u0019IgNZ8s[R\u0011aE\u001c\u0005\u0006\u0019B\u0001\r!\u0014\u0015\u0005!A\u001cX\u000f\u0005\u0002\"c&\u0011!\u000f\b\u0002\u0015I\u0016\u0004(/Z2bi\u0016$wJ^3se&$\u0017N\\4\"\u0003Q\f!\u000b\u00165jg\u00022wN]<be\u0012\u001c\b\u0005^8!i\",\u0007eY8se\u0016\u001c\bo\u001c8eS:<\u0007%\\3uQ>$\u0007%\u001b8!e\u0016\u0004xN\u001d;fe\u0002jS\u0006I8wKJ\u0014\u0018\u000eZ3!e\u0016\u0004xN\u001d;fe\u0002Jgn\u001d;fC\u0012\f\u0013A^\u0001\u0007e9\n\u0014G\f\u001a\u0002\u000f]\f'O\\5oOR\u0011a%\u001f\u0005\u0006\u0019F\u0001\r!\u0014\u0015\u0006#mt\u0018\u0011\u0001\t\u0003CqL!! \u000f\u0003\u0015\u0011,\u0007O]3dCR,G-I\u0001\u0000\u0003\t*6/\u001a\u0011aeVt'+\u001a9peRLgn\u001a\u0018xCJt\u0017N\\4aA%t7\u000f^3bIFB1%TA\u0002\u0003\u0017\t)!\u0003\u0003\u0002\u0006\u0005\u001d\u0011a\u0007\u0013mKN\u001c\u0018N\\5uI\u001d\u0014X-\u0019;fe\u0012\"WMZ1vYR$#GC\u0002\u0002\nq\t!\u0002Z3qe\u0016\u001c\u0017\r^3ec%\u0019\u0013QBA\b\u0003#\tIAD\u0002\"\u0003\u001fI1!!\u0003\u001dc\u0015\u0011\u0013\u0005HA\n\u0005\u0015\u00198-\u00197bQ\u0011\t\u0002o];\u0002\u0017\u001ddwNY1m\u000bJ\u0014xN\u001d\u000b\u0004M\u0005m\u0001\"\u0002'\u0013\u0001\u0004i\u0005\u0006\u0002\nqgV\fQ!\u00192peR$2AOA\u0012\u0011\u0015a5\u00031\u0001N)\u00151\u0013qEA\u0015\u0011\u0015)E\u00031\u0001G\u0011\u0015aE\u00031\u0001NQ\u0011!\u0002o];\u0015\u000b\u0019\ny#!\r\t\u000b\u0015+\u0002\u0019\u0001$\t\u000b1+\u0002\u0019A')\u000bUYh0!\u000e2\u0011\rj\u00151AA\u001c\u0003\u000b\t\u0014bIA\u0007\u0003\u001f\tI$!\u00032\u000b\t\nC$a\u0005)\tU\u00018/\u001e\u000b\u0006M\u0005}\u0012\u0011\t\u0005\u0006\u000bZ\u0001\rA\u0012\u0005\u0006\u0019Z\u0001\r!\u0014\u0015\u0005-A\u001cXO\u0005\u0004\u0002H\u0005-\u0013Q\n\u0004\u0007\u0003\u0013\u0002\u0001!!\u0012\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u00051\u0002\u0001C\u0001\u0017J\u0001")
public interface Reporting {
    public Reporter reporter();

    public RunReporting currentRun();

    public PerRunReportingBase PerRunReporting();

    public static /* synthetic */ String supplementTyperState$(Reporting $this, String errorMessage) {
        return $this.supplementTyperState(errorMessage);
    }

    default public String supplementTyperState(String errorMessage) {
        return errorMessage;
    }

    public static /* synthetic */ String supplementErrorMessage$(Reporting $this, String errorMessage) {
        return $this.supplementErrorMessage(errorMessage);
    }

    default public String supplementErrorMessage(String errorMessage) {
        return this.currentRun().reporting().supplementErrorMessage(errorMessage);
    }

    public static /* synthetic */ void inform$(Reporting $this, String msg) {
        $this.inform(msg);
    }

    default public void inform(String msg) {
        this.inform(((Positions)((Object)this)).NoPosition(), msg);
    }

    public static /* synthetic */ void warning$(Reporting $this, String msg) {
        $this.warning(msg);
    }

    default public void warning(String msg) {
        this.warning(((Positions)((Object)this)).NoPosition(), msg);
    }

    public static /* synthetic */ void globalError$(Reporting $this, String msg) {
        $this.globalError(msg);
    }

    default public void globalError(String msg) {
        this.globalError(((Positions)((Object)this)).NoPosition(), msg);
    }

    public static /* synthetic */ Nothing$ abort$(Reporting $this, String msg) {
        return $this.abort(msg);
    }

    default public Nothing$ abort(String msg) {
        String augmented = this.supplementErrorMessage(msg);
        this.globalError(augmented);
        throw new FatalError(augmented);
    }

    public static /* synthetic */ void inform$(Reporting $this, Position pos, String msg) {
        $this.inform(pos, msg);
    }

    default public void inform(Position pos, String msg) {
        this.reporter().echo(pos, msg);
    }

    public static /* synthetic */ void warning$(Reporting $this, Position pos, String msg) {
        $this.warning(pos, msg);
    }

    default public void warning(Position pos, String msg) {
        this.reporter().warning(pos, msg);
    }

    public static /* synthetic */ void globalError$(Reporting $this, Position pos, String msg) {
        $this.globalError(pos, msg);
    }

    default public void globalError(Position pos, String msg) {
        this.reporter().error(pos, msg);
    }

    public static void $init$(Reporting $this) {
    }

    public abstract class PerRunReportingBase {
        private boolean supplementedError;

        public abstract void deprecationWarning(Position var1, String var2, String var3, String var4, String var5);

        public String supplementErrorMessage(String errorMessage) {
            if (this.supplementedError) {
                return errorMessage;
            }
            this.supplementedError = true;
            return this.scala$reflect$internal$Reporting$PerRunReportingBase$$$outer().supplementTyperState(errorMessage);
        }

        public /* synthetic */ Reporting scala$reflect$internal$Reporting$PerRunReportingBase$$$outer() {
            return Reporting.this;
        }

        public PerRunReportingBase() {
            if (Reporting.this == null) {
                throw null;
            }
            this.supplementedError = false;
        }
    }

    public interface RunReporting {
        public void scala$reflect$internal$Reporting$RunReporting$_setter_$reporting_$eq(PerRunReportingBase var1);

        public PerRunReportingBase reporting();

        public /* synthetic */ Reporting scala$reflect$internal$Reporting$RunReporting$$$outer();

        public static void $init$(RunReporting $this) {
            $this.scala$reflect$internal$Reporting$RunReporting$_setter_$reporting_$eq($this.scala$reflect$internal$Reporting$RunReporting$$$outer().PerRunReporting());
        }
    }
}

