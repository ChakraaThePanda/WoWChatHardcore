/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.reflect.ScalaSignature;
import scala.reflect.internal.Reporter$;
import scala.reflect.internal.Reporter$ERROR$;
import scala.reflect.internal.Reporter$INFO$;
import scala.reflect.internal.Reporter$WARNING$;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.Position;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005Uf!\u0002\u00192\u0003\u0003A\u0004\"B\u001f\u0001\t\u0003q\u0004BB!\u0001A\u0003&!\t\u0003\u0004F\u0001\u0001\u0006KAQ\u0003\u0005\r\u0002\u0011q\tC\u0004\u0002\u0002\u0001!)!a\u0002\t\u000f\u0005\r\u0001\u0001\"\u0002\u0002\b!9\u0011Q\u0001\u0001\u0005\u0006\u0005\u001d\u0001bBA\u0012\u0001\u0019E\u0011Q\u0005\u0005\b\u0003\u001f\u0002A\u0011AA)\u0011\u001d\tI\u0006\u0001C\u0003\u00037Bq!!\u0017\u0001\t\u000b\ty\u0006C\u0004\u0002f\u0001!\t!a\u001a\t\u000f\u00055\u0004\u0001\"\u0001\u0002p!9\u0011Q\u000f\u0001\u0005\n\u0005]\u0004bBA@\u0001\u0011\u0005\u0011\u0011\u0011\u0005\u0007\u0003\u000b\u0003A\u0011\u00010\t\r\u0005\u001d\u0005\u0001\"\u0001_\u0011\u001d\tI\t\u0001C\u0001\u0003\u0017Cq!!$\u0001\t\u0003\tY\tC\u0004\u0002\u0010\u0002!\t!!%\t\u000f\u0005M\u0005\u0001\"\u0001\u0002\u0012\"9\u0011Q\u0013\u0001\u0005\u0002\u0005E\u0005bBAL\u0001\u0011\u0005\u0011\u0011T\u0004\u0006\u0013FB\tA\u0013\u0004\u0006aEB\ta\u0013\u0005\u0006{e!\t\u0001\u0014\u0005\b\u001bf\u0011\r\u0011\"\u0002O\u0011\u0019\t\u0016\u0004)A\u0007\u001f\"9!+\u0007b\u0001\n\u000b\u0019\u0006B\u0002,\u001aA\u00035A\u000bC\u0004X3\t\u0007IQ\u0001-\t\rmK\u0002\u0015!\u0004Z\r\u00151\u0015$!\t]\u0011!i\u0016E!b\u0001\n\u0003q\u0006\u0002C0\"\u0005\u0003\u0005\u000b\u0011\u0002\"\t\u0011\u0001\f#Q1A\u0005B\u0005D\u0001\"\\\u0011\u0003\u0002\u0003\u0006IA\u0019\u0005\u0006{\u0005\"\tA\\\u0004\u0007\u0003\u0003I\u0002\u0012A>\u0007\u000baL\u0002\u0012A=\t\u000buBC\u0011\u0001>\b\r\u0005\r\u0011\u0004#\u0001\u0000\r\u0015a\u0018\u0004#\u0001~\u0011\u0015i4\u0006\"\u0001\u007f\u000f\u0019\t)!\u0007E\u0001o\u001a)A/\u0007E\u0001k\")QH\fC\u0001m\nA!+\u001a9peR,'O\u0003\u00023g\u0005A\u0011N\u001c;fe:\fGN\u0003\u00025k\u00059!/\u001a4mK\u000e$(\"\u0001\u001c\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001!\u000f\t\u0003umj\u0011!N\u0005\u0003yU\u0012a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001@!\t\u0001\u0005!D\u00012\u0003-yVM\u001d:pe\u000e{WO\u001c;\u0011\u0005i\u001a\u0015B\u0001#6\u0005\rIe\u000e^\u0001\u000e?^\f'O\\5oO\u000e{WO\u001c;\u0003\u0011M+g/\u001a:jif\u0004\"\u0001S\u0011\u000f\u0005\u0001C\u0012\u0001\u0003*fa>\u0014H/\u001a:\u0011\u0005\u0001K2CA\r:)\u0005Q\u0015a\u0002#jgBd\u0017-_\u000b\u0002\u001f>\t\u0001+H\u0001\u0001\u0003!!\u0015n\u001d9mCf\u0004\u0013!B\"pk:$X#\u0001+\u0010\u0003Uk\u0012!A\u0001\u0007\u0007>,h\u000e\u001e\u0011\u0002\u0011M+\b\u000f\u001d:fgN,\u0012!W\b\u00025v\t!!A\u0005TkB\u0004(/Z:tAM\u0011\u0011%O\u0001\u0003S\u0012,\u0012AQ\u0001\u0004S\u0012\u0004\u0013\u0001\u0003;p'R\u0014\u0018N\\4\u0016\u0003\t\u0004\"a\u00196\u000f\u0005\u0011D\u0007CA36\u001b\u00051'BA48\u0003\u0019a$o\\8u}%\u0011\u0011.N\u0001\u0007!J,G-\u001a4\n\u0005-d'AB*ue&twM\u0003\u0002jk\u0005IAo\\*ue&tw\r\t\u000b\u0004_F\u0014\bC\u00019\"\u001b\u0005I\u0002\"B/'\u0001\u0004\u0011\u0005\"\u00021'\u0001\u0004\u0011\u0017\u0006B\u0011/Q-\u0012Q!\u0012*S\u001fJ\u001b\"AL8\u0015\u0003]\u0004\"\u0001\u001d\u0018\u0003\t%seiT\n\u0003Q=$\u0012a\u001f\t\u0003a\"\u0012qaV!S\u001d&sui\u0005\u0002,_R\tq\u0010\u0005\u0002qW\u0005!\u0011J\u0014$P\u0003\u001d9\u0016I\u0015(J\u001d\u001e\u000bQ!\u0012*S\u001fJ+\"!!\u0003\u0011\u0007\u0005-A!D\u0001\u0001Q\r)\u0011q\u0002\t\u0005\u0003#\tY\"\u0004\u0002\u0002\u0014)!\u0011QCA\f\u0003%)hn\u00195fG.,GMC\u0002\u0002\u001aU\n!\"\u00198o_R\fG/[8o\u0013\u0011\ti\"a\u0005\u0003\u001fUt7\r[3dW\u0016$7\u000b^1cY\u0016D3ABA\bQ\r9\u0011qB\u0001\u0006S:4w\u000e\r\u000b\u000b\u0003O\ti#!\u0010\u0002B\u0005\u0015\u0003c\u0001\u001e\u0002*%\u0019\u00111F\u001b\u0003\tUs\u0017\u000e\u001e\u0005\b\u0003_A\u0001\u0019AA\u0019\u0003\r\u0001xn\u001d\t\u0005\u0003g\tI$\u0004\u0002\u00026)\u0019\u0011qG\u0019\u0002\tU$\u0018\u000e\\\u0005\u0005\u0003w\t)D\u0001\u0005Q_NLG/[8o\u0011\u0019\ty\u0004\u0003a\u0001E\u0006\u0019Qn]4\t\u000f\u0005\r\u0003\u00021\u0001\u0002\n\u0005A1/\u001a<fe&$\u0018\u0010C\u0004\u0002H!\u0001\r!!\u0013\u0002\u000b\u0019|'oY3\u0011\u0007i\nY%C\u0002\u0002NU\u0012qAQ8pY\u0016\fg.\u0001\u0004gS2$XM\u001d\u000b\b\u0005\u0006M\u0013QKA,\u0011\u001d\ty#\u0003a\u0001\u0003cAa!a\u0010\n\u0001\u0004\u0011\u0007bBA\"\u0013\u0001\u0007\u0011\u0011B\u0001\u0005K\u000eDw\u000e\u0006\u0003\u0002(\u0005u\u0003BBA \u0015\u0001\u0007!\r\u0006\u0004\u0002(\u0005\u0005\u00141\r\u0005\b\u0003_Y\u0001\u0019AA\u0019\u0011\u0019\tyd\u0003a\u0001E\u00069q/\u0019:oS:<GCBA\u0014\u0003S\nY\u0007C\u0004\u000201\u0001\r!!\r\t\r\u0005}B\u00021\u0001c\u0003\u0015)'O]8s)\u0019\t9#!\u001d\u0002t!9\u0011qF\u0007A\u0002\u0005E\u0002BBA \u001b\u0001\u0007!-\u0001\u0007gS2$XM]3e\u0013:4w\u000e\u0006\u0005\u0002(\u0005e\u00141PA?\u0011\u001d\tyC\u0004a\u0001\u0003cAa!a\u0010\u000f\u0001\u0004\u0011\u0007bBA\"\u001d\u0001\u0007\u0011\u0011B\u0001\nS:\u001c'/Z7f]R$B!a\n\u0002\u0004\"9\u00111I\bA\u0002\u0005%\u0011AC3se>\u00148i\\;oi\u0006aq/\u0019:oS:<7i\\;oi\u0006I\u0001.Y:FeJ|'o]\u000b\u0003\u0003\u0013\n1\u0002[1t/\u0006\u0014h.\u001b8hg\u0006)!/Z:fiR\u0011\u0011qE\u0001\u0006M2,8\u000f[\u0001\u0007M&t\u0017n\u001d5\u0002!I,'/\u001e8XSRDG)\u001a;bS2\u001cH#\u00022\u0002\u001c\u0006E\u0006bBAO/\u0001\u0007\u0011qT\u0001\bg\u0016$H/\u001b8h!\u0011\t\t+!,\u0011\t\u0005\r\u0016\u0011V\u0007\u0003\u0003KS1!a*2\u0003!\u0019X\r\u001e;j]\u001e\u001c\u0018\u0002BAV\u0003K\u0013q\"T;uC\ndWmU3ui&twm]\u0005\u0005\u0003_\u000bIKA\u0004TKR$\u0018N\\4\t\r\u0005Mv\u00031\u0001c\u0003\u0011q\u0017-\\3")
public abstract class Reporter {
    private int _errorCount = 0;
    private int _warningCount = 0;

    public static int Suppress() {
        return Reporter$.MODULE$.Suppress();
    }

    public static int Count() {
        return Reporter$.MODULE$.Count();
    }

    public static int Display() {
        return Reporter$.MODULE$.Display();
    }

    public final Severity INFO() {
        return Reporter$INFO$.MODULE$;
    }

    public final Severity WARNING() {
        return Reporter$WARNING$.MODULE$;
    }

    public final Severity ERROR() {
        return Reporter$ERROR$.MODULE$;
    }

    public abstract void info0(Position var1, String var2, Severity var3, boolean var4);

    public int filter(Position pos, String msg, Severity severity) {
        return 0;
    }

    public final void echo(String msg) {
        this.echo(NoPosition$.MODULE$, msg);
    }

    public final void echo(Position pos, String msg) {
        if (this.filter(pos, msg, this.INFO()) == 0) {
            this.info0(pos, msg, this.INFO(), true);
        }
    }

    public void warning(Position pos, String msg) {
        this.filteredInfo(pos, msg, this.WARNING());
    }

    public void error(Position pos, String msg) {
        this.filteredInfo(pos, msg, this.ERROR());
    }

    private void filteredInfo(Position pos, String msg, Severity severity) {
        int f = this.filter(pos, msg, severity);
        if (f <= 1) {
            this.increment(severity);
        }
        if (f == 0) {
            this.info0(pos, msg, severity, false);
        }
    }

    public void increment(Severity severity) {
        if (severity == Reporter$ERROR$.MODULE$) {
            ++this._errorCount;
            return;
        }
        if (severity == Reporter$WARNING$.MODULE$) {
            ++this._warningCount;
            return;
        }
    }

    public int errorCount() {
        return this._errorCount;
    }

    public int warningCount() {
        return this._warningCount;
    }

    public boolean hasErrors() {
        return this.errorCount() > 0;
    }

    public boolean hasWarnings() {
        return this.warningCount() > 0;
    }

    public void reset() {
        this._errorCount = 0;
        this._warningCount = 0;
    }

    public void flush() {
    }

    public void finish() {
    }

    public String rerunWithDetails(MutableSettings.SettingValue setting, String name) {
        Object object = setting.value();
        String string = object instanceof Boolean && !BoxesRunTime.unboxToBoolean(object) ? new StringBuilder(26).append("; re-run with ").append(name).append(" for details").toString() : new StringBuilder(44).append("; re-run enabling ").append(name).append(" for details, or try -help").toString();
        return string;
    }

    public static abstract class Severity {
        private final int id;
        private final String toString;

        public int id() {
            return this.id;
        }

        public String toString() {
            return this.toString;
        }

        public Severity(int id, String toString2) {
            this.id = id;
            this.toString = toString2;
        }
    }
}

