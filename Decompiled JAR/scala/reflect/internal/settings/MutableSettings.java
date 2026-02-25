/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.settings;

import scala.None$;
import scala.Option;
import scala.Some;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.settings.AbsSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005Me!B\u00193\u0003\u0003Y\u0004\"\u0002#\u0001\t\u0003)E!B$\u0001\u0005\u0003AE!B<\u0001\u0005\u0003AH!\u0002@\u0001\u0005\u0003yHaBA\u0007\u0001\t\u0005\u0011q\u0002\u0004\b\u001d\u0002\u0001\n1!\u0001P\u0011\u0015\u0019f\u0001\"\u0001U\u0011\u001dAf\u00011A\u0007\u0012eCqA\u0018\u0004A\u0002\u001bEq\fC\u0004c\r\u0001\u0007I\u0011C2\t\u000f\u001d4\u0001\u0019!C\tQ\")!N\u0002C\u0001)\")1N\u0002C\u0001G\")AN\u0002C\u0001G\")QN\u0002C\u00013\")aN\u0002C\u0001_\")!O\u0002C\u0001g\"9\u00111\b\u0001\u0007\u0002\u0005u\u0002bBA!\u0001\u0019\u0005\u0011Q\b\u0005\b\u0003\u0007\u0002a\u0011AA\u001f\u0011\u001d\t)\u0005\u0001D\u0001\u0003{Aq!a\u0012\u0001\r\u0003\ti\u0004C\u0004\u0002J\u00011\t!!\u0010\t\u000f\u0005-\u0003A\"\u0001\u0002>!9\u0011Q\n\u0001\u0007\u0002\u0005u\u0002bBA(\u0001\u0019\u0005\u0011Q\b\u0005\b\u0003#\u0002a\u0011AA\u001f\u0011\u001d\t\u0019\u0006\u0001D\u0001\u0003{Aq!!\u0016\u0001\r\u0003\ti\u0004C\u0004\u0002X\u00011\t!!\u0010\t\u000f\u0005e\u0003A\"\u0001\u0002>!9\u00111\f\u0001\u0007\u0002\u0005u\u0002bBA/\u0001\u0019\u0005\u0011Q\b\u0005\b\u0003?\u0002a\u0011AA\u001f\u0011\u001d\t\t\u0007\u0001D\u0001\u0003{Aq!a\u0019\u0001\r\u0003\ti\u0004C\u0004\u0002f\u00011\t!!\u0010\t\r\u0005\u001d\u0004\u0001\"\u0001d\u0011\u0019\tI\u0007\u0001C\u0001G\"9\u00111\u000e\u0001\u0007\u0002\u00055\u0004bBA9\u0001\u0019\u0005\u0011Q\u000e\u0005\u0007\u0003g\u0002a\u0011A2\t\r\u0005U\u0004A\"\u0001d\u0011\u001d\t9\b\u0001D\u0001q\r<q!!\u001f3\u0011\u0003\tYH\u0002\u00042e!\u0005\u0011Q\u0010\u0005\u0007\t:\"\t!a \t\u000f\u0005\u0005e\u0006b\u0001\u0002\u0004\nyQ*\u001e;bE2,7+\u001a;uS:<7O\u0003\u00024i\u0005A1/\u001a;uS:<7O\u0003\u00026m\u0005A\u0011N\u001c;fe:\fGN\u0003\u00028q\u00059!/\u001a4mK\u000e$(\"A\u001d\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001\u0001\u0010!\u0011\u0005urT\"\u0001\u001d\n\u0005}B$AB!osJ+g\r\u0005\u0002B\u00056\t!'\u0003\u0002De\tY\u0011IY:TKR$\u0018N\\4t\u0003\u0019a\u0014N\\5u}Q\ta\t\u0005\u0002B\u0001\t91+\u001a;uS:<\u0017CA%M!\ti$*\u0003\u0002Lq\t9aj\u001c;iS:<\u0007CA'\u0007\u001b\u0005\u0001!\u0001D*fiRLgn\u001a,bYV,7c\u0001\u0004=!B\u0011Q*U\u0005\u0003%\n\u0013q\"\u00112t'\u0016$H/\u001b8h-\u0006dW/Z\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003U\u0003\"!\u0010,\n\u0005]C$\u0001B+oSR\f\u0011A^\u000b\u00025B\u00111\fX\u0007\u0002\r%\u0011Q,\u0015\u0002\u0002)\u0006)ao\u0018\u0013fcR\u0011Q\u000b\u0019\u0005\bC&\t\t\u00111\u0001[\u0003\rAH%M\u0001\ng\u0016$()_+tKJ,\u0012\u0001\u001a\t\u0003{\u0015L!A\u001a\u001d\u0003\u000f\t{w\u000e\\3b]\u0006i1/\u001a;CsV\u001bXM]0%KF$\"!V5\t\u000f\u0005\\\u0011\u0011!a\u0001I\u0006Y\u0001o\\:u'\u0016$\bj\\8l\u0003%I7\u000fR3gCVdG/A\u0006jgN+GOQ=Vg\u0016\u0014\u0018!\u0002<bYV,\u0017!\u0003<bYV,w\fJ3r)\t)\u0006\u000fC\u0003r!\u0001\u0007!,A\u0002be\u001e\faB^1mk\u0016\u001cV\r\u001e\"z+N,'/F\u0001u!\riTOW\u0005\u0003mb\u0012aa\u00149uS>t'A\u0004\"p_2,\u0017M\\*fiRLgnZ\t\u0003\u0013f\u0014\"A\u001f?\u0007\tm\u0004\u0001!\u001f\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0003\u001b\n)A!\u0018>!I\nQ\u0011J\u001c;TKR$\u0018N\\4\u0012\u0007%\u000b\tAE\u0002\u0002\u0004q4Qa\u001f\u0001\u0001\u0003\u0003)a!XA\u0002A\u0005\u001d\u0001cA\u001f\u0002\n%\u0019\u00111\u0002\u001d\u0003\u0007%sGO\u0001\nNk2$\u0018n\u0015;sS:<7+\u001a;uS:<\u0017cA%\u0002\u0012I\u0019\u00111\u0003?\u0007\u000bm\u0004\u0001!!\u0005\u0006\ru\u000b\u0019\u0002IA\f!\u0019\tI\"a\b\u0002&9\u0019Q(a\u0007\n\u0007\u0005u\u0001(A\u0004qC\u000e\\\u0017mZ3\n\t\u0005\u0005\u00121\u0005\u0002\u0005\u0019&\u001cHOC\u0002\u0002\u001ea\u0002B!a\n\u000269!\u0011\u0011FA\u0019!\r\tY\u0003O\u0007\u0003\u0003[Q1!a\f;\u0003\u0019a$o\\8u}%\u0019\u00111\u0007\u001d\u0002\rA\u0013X\rZ3g\u0013\u0011\t9$!\u000f\u0003\rM#(/\u001b8h\u0015\r\t\u0019\u0004O\u0001\u0006CNLhnY\u000b\u0003\u0003\u007f\u0001\"!T\u0002\u0002\u001ba+\u0007\u0010]3sS6,g\u000e^1m\u0003%Af-\u001e7m\u0019V\u00147/A\tY]>\u0004\u0016\r^7bi\u0006s\u0017\r\\=tSN\f\u0011\u0002\u00179sS:$\bo\\:\u0002\u001fM$(/[2u\u0013:4WM]3oG\u0016\f\u0011\"\u00179pg\u0012,'-^4\u0002\u0013e\u0013\u0018M\\4fa>\u001c\u0018AD-tQ><8/_7po:,'o]\u0001\u000e3NDwn^:z[.Lg\u000eZ:\u0002\u0017\t\u0014X-Y6Ds\u000edWm]\u0001\u0006I\u0016\u0014WoZ\u0001\nI\u00164X\r\\8qKJ\fA\"\u001a=qY\u0006Lg\u000e^=qKN\fqb\u001c<feJLG-Z(cU\u0016\u001cGo]\u0001\u000baJLg\u000e\u001e;za\u0016\u001c\u0018AB;oSFLG-A\u0004wKJ\u0014wn]3\u0002'e\u0003\u0018M\u001d;jC2,f.\u001b4jG\u0006$\u0018n\u001c8\u0002\u0017e3\u0018N\u001d;qCRl\u0017\r^\u0001\u00163\"|Go\u0015;bi&\u001cH/[2t\u000b:\f'\r\\3e\u0003II6\u000f^1uSN$\u0018nY:F]\u0006\u0014G.\u001a3\u0002\u0015e\u0013XmY;sg&|g.\u0006\u0002\u0002pA\u0011Q\nB\u0001\u0011[\u0006D8\t\\1tg\u001aLG.\u001a(b[\u0016\f!\"[:TG\u0006d\u0017MM\u00192\u0003)I7oU2bY\u0006\u0014\u0014GM\u0001\u000bSN\u001c6-\u00197beE\u001a\u0014aD'vi\u0006\u0014G.Z*fiRLgnZ:\u0011\u0005\u0005s3C\u0001\u0018=)\t\tY(A\fsK\u001adWm\u0019;TKR$\u0018N\\4U_\n{w\u000e\\3b]R\u0019A-!\"\t\u000f\u0005\u001d\u0005\u00071\u0001\u0002\n\u0006\t1\u000f\u0005\u0002G\u0007!\u001a\u0001'!$\u0011\u0007u\ny)C\u0002\u0002\u0012b\u0012a!\u001b8mS:,\u0007")
public abstract class MutableSettings
implements AbsSettings {
    public static boolean reflectSettingToBoolean(SettingValue settingValue) {
        if (MutableSettings$.MODULE$ == null) {
            throw null;
        }
        return BoxesRunTime.unboxToBoolean(settingValue.value());
    }

    public abstract SettingValue async();

    public abstract SettingValue Xexperimental();

    public abstract SettingValue XfullLubs();

    public abstract SettingValue XnoPatmatAnalysis();

    public abstract SettingValue Xprintpos();

    public abstract SettingValue strictInference();

    public abstract SettingValue Yposdebug();

    public abstract SettingValue Yrangepos();

    public abstract SettingValue Yshowsymowners();

    public abstract SettingValue Yshowsymkinds();

    public abstract SettingValue breakCycles();

    public abstract SettingValue debug();

    public abstract SettingValue developer();

    public abstract SettingValue explaintypes();

    public abstract SettingValue overrideObjects();

    public abstract SettingValue printtypes();

    public abstract SettingValue uniqid();

    public abstract SettingValue verbose();

    public abstract SettingValue YpartialUnification();

    public abstract SettingValue Yvirtpatmat();

    public boolean YhotStatisticsEnabled() {
        return false;
    }

    public boolean YstatisticsEnabled() {
        return false;
    }

    public abstract SettingValue Yrecursion();

    public abstract SettingValue maxClassfileName();

    public abstract boolean isScala211();

    public abstract boolean isScala212();

    public abstract boolean isScala213();

    public MutableSettings() {
        AbsSettings.$init$(this);
    }

    public interface SettingValue
    extends AbsSettings.AbsSettingValue {
        public Object v();

        public void v_$eq(Object var1);

        public boolean setByUser();

        public void setByUser_$eq(boolean var1);

        public static /* synthetic */ void postSetHook$(SettingValue $this) {
            $this.postSetHook();
        }

        default public void postSetHook() {
        }

        public static /* synthetic */ boolean isDefault$(SettingValue $this) {
            return $this.isDefault();
        }

        @Override
        default public boolean isDefault() {
            return !this.setByUser();
        }

        public static /* synthetic */ boolean isSetByUser$(SettingValue $this) {
            return $this.isSetByUser();
        }

        default public boolean isSetByUser() {
            return this.setByUser();
        }

        public static /* synthetic */ Object value$(SettingValue $this) {
            return $this.value();
        }

        @Override
        default public Object value() {
            return this.v();
        }

        public static /* synthetic */ void value_$eq$(SettingValue $this, Object arg) {
            $this.value_$eq(arg);
        }

        default public void value_$eq(Object arg) {
            this.setByUser_$eq(true);
            this.v_$eq(arg);
            this.postSetHook();
        }

        public static /* synthetic */ Option valueSetByUser$(SettingValue $this) {
            return $this.valueSetByUser();
        }

        default public Option<Object> valueSetByUser() {
            if (this.isSetByUser()) {
                return new Some<Object>(this.value());
            }
            return None$.MODULE$;
        }

        public /* synthetic */ MutableSettings scala$reflect$internal$settings$MutableSettings$SettingValue$$$outer();

        public static void $init$(SettingValue $this) {
            $this.setByUser_$eq(false);
        }
    }
}

