/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import scala.Console$;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005%h\u0001\u0003\u001f>!\u0003\r\taP!\t\u000b\u0019\u0003A\u0011\u0001%\t\u000b1\u0003a\u0011C'\t\u000be\u0003a\u0011\u0003.\t\u000f)\u0004!\u0019!C\tW\"A1\u000f\u0001EC\u0002\u0013EA\u000fC\u0003{\u0001\u0011%1\u0010C\u0004\u0002\b\u0001!\t!!\u0003\t\u000f\u0005U\u0001\u0001\"\u0001\u0002\u0018!9\u0011q\u0004\u0001\u0005\u0002\u0005\u0005\u0002bBA\u0015\u0001\u0011\u0005\u00111\u0006\u0005\b\u0003_\u0001A\u0011AA\u0019\u0011\u001d\t)\u0004\u0001C\u0001\u0003oAq!!\u0011\u0001\t\u0003\t\u0019\u0005C\u0004\u0002H\u0001!\t!!\u0013\t\u000f\u0005=\u0003\u0001\"\u0001\u0002R!9\u0011Q\u000b\u0001\u0005\u0002\u0005]\u0003bBA/\u0001\u0011\u0005\u0011q\f\u0005\b\u0003G\u0002A\u0011AA3\u0011\u001d\ti\u0007\u0001C\u0001\u0003_Bq!!\u001e\u0001\t\u0003\t9\bC\u0004\u0002|\u0001!\t!! \t\u0013\u0005\u0005\u0005A1A\u0005\u0002\u0005\r\u0005\"CAC\u0001\t\u0007I\u0011AAB\u0011\u0019\t9\t\u0001C\u0001\u001b\"A\u0011\u0011\u0012\u0001C\u0002\u0013\u00051\u000e\u0003\u0005\u0002\f\u0002\u0011\r\u0011\"\u0001N\u0011\u0019\ti\t\u0001C\u0001\u001b\"1\u0011q\u0012\u0001\u0005\u00025Ca!!%\u0001\t\u0003Y\u0007BBAJ\u0001\u0011\u00051\u000e\u0003\u0004\u0002\u0016\u0002!\ta\u001b\u0005\u0007\u0003/\u0003A\u0011A6\t\r\u0005e\u0005\u0001\"\u0001l\u0011\u0019\tY\n\u0001C\u0001W\"1\u0011Q\u0014\u0001\u0005\u0002-Da!a(\u0001\t\u0003Y\u0007BBAQ\u0001\u0011\u00051\u000e\u0003\u0004\u0002$\u0002!\ta\u001b\u0005\u0007\u0003K\u0003A\u0011A6\t\r\u0005\u001d\u0006\u0001\"\u0001l\u0011\u0019\tI\u000b\u0001C\u0001W\"1\u00111\u0016\u0001\u0005\u0002-Da!!,\u0001\t\u0003Y\u0007BBAX\u0001\u0011\u00051\u000e\u0003\u0004\u00022\u0002!\ta\u001b\u0005\u0007\u0003g\u0003A\u0011A6\t\r\u0005U\u0006\u0001\"\u0001l\u0011\u001d\t9\f\u0001C\u0001\u0003sCq!a/\u0001\t\u0003\tI\fC\u0004\u0002>\u0002!\t!!/\t\u0011\u0005}\u0006\u0001\"\u0001@\u0003sC\u0001\"!1\u0001\t\u0003y\u0014\u0011\u0018\u0005\u0007\u0003\u0007\u0004A\u0011A6\t\u0011\u0005\u0015\u0007\u0001)C\u0005\u0003\u000fDa!!4\u0001\t\u0003i\u0005BBAh\u0001\u0011\u00051\u000e\u0003\u0004\u0002R\u0002!\ta\u001b\u0005\b\u0003'\u0004A\u0011AAk\u0011\u001d\tY\u000e\u0001C\u0001\u0003;\u0014q\u0002\u0015:pa\u0016\u0014H/[3t)J\f\u0017\u000e\u001e\u0006\u0003}}\nA!\u001e;jY*\t\u0001)A\u0003tG\u0006d\u0017m\u0005\u0002\u0001\u0005B\u00111\tR\u0007\u0002\u007f%\u0011Qi\u0010\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%\u0007\u0001!\u0012!\u0013\t\u0003\u0007*K!aS \u0003\tUs\u0017\u000e^\u0001\raJ|\u0007oQ1uK\u001e|'/_\u000b\u0002\u001dB\u0011qJ\u0016\b\u0003!R\u0003\"!U \u000e\u0003IS!aU$\u0002\rq\u0012xn\u001c;?\u0013\t)v(\u0001\u0004Qe\u0016$WMZ\u0005\u0003/b\u0013aa\u0015;sS:<'BA+@\u00039\u0001\u0018nY6KCJ\u0014\u0015m]3e\u001f:,\u0012a\u0017\u0019\u00039\u0006\u00042aT/`\u0013\tq\u0006LA\u0003DY\u0006\u001c8\u000f\u0005\u0002aC2\u0001A!\u00032\u0004\u0003\u0003\u0005\tQ!\u0001d\u0005\ryFEM\t\u0003I\u001e\u0004\"aQ3\n\u0005\u0019|$a\u0002(pi\"Lgn\u001a\t\u0003\u0007\"L!![ \u0003\u0007\u0005s\u00170\u0001\u0007qe>\u0004h)\u001b7f]\u0006lW-F\u0001m!\ti'/D\u0001o\u0015\ty\u0007/\u0001\u0003mC:<'\"A9\u0002\t)\fg/Y\u0005\u0003/:\f!b]2bY\u0006\u0004&o\u001c9t+\u0005)\bC\u0001<y\u001b\u00059(B\u0001 q\u0013\tIxO\u0001\u0006Qe>\u0004XM\u001d;jKN\fa\"];jKRd\u0017\u0010R5ta>\u001cX\r\u0006\u0003Jy\u0006\r\u0001BB?\u0007\t\u0003\u0007a0\u0001\u0004bGRLwN\u001c\t\u0004\u0007~L\u0015bAA\u0001\u007f\tAAHY=oC6,g\bC\u0004\u0002\u0006\u0019!\t\u0019\u0001@\u0002\u0011\u0011L7\u000f]8tC2\f\u0011\u0002\u001d:pa&\u001b8+\u001a;\u0015\t\u0005-\u0011\u0011\u0003\t\u0004\u0007\u00065\u0011bAA\b\u007f\t9!i\\8mK\u0006t\u0007BBA\n\u000f\u0001\u0007a*\u0001\u0003oC6,\u0017a\u00039s_BL5oU3u)>$b!a\u0003\u0002\u001a\u0005m\u0001BBA\n\u0011\u0001\u0007a\n\u0003\u0004\u0002\u001e!\u0001\rAT\u0001\u0006m\u0006dW/Z\u0001\u000baJ|\u0007o\u0014:FYN,G#\u00027\u0002$\u0005\u0015\u0002BBA\n\u0013\u0001\u0007a\n\u0003\u0004\u0002(%\u0001\rAT\u0001\u0004C2$\u0018a\u00039s_B|%/R7qif$2\u0001\\A\u0017\u0011\u0019\t\u0019B\u0003a\u0001\u001d\u0006Q\u0001O]8q\u001fJtU\u000f\u001c7\u0015\u00071\f\u0019\u0004\u0003\u0004\u0002\u0014-\u0001\rAT\u0001\u000baJ|\u0007o\u0014:O_:,G\u0003BA\u001d\u0003\u007f\u0001BaQA\u001eY&\u0019\u0011QH \u0003\r=\u0003H/[8o\u0011\u0019\t\u0019\u0002\u0004a\u0001\u001d\u0006Y\u0001O]8q\u001fJ4\u0015\r\\:f)\u0011\tY!!\u0012\t\r\u0005MQ\u00021\u0001O\u0003\u001d\u0019X\r\u001e)s_B$R\u0001\\A&\u0003\u001bBa!a\u0005\u000f\u0001\u0004q\u0005BBA\u000f\u001d\u0001\u0007a*A\u0005dY\u0016\f'\u000f\u0015:paR\u0019A.a\u0015\t\r\u0005Mq\u00021\u0001O\u0003%)gN^(s\u000b2\u001cX\rF\u0003m\u00033\nY\u0006\u0003\u0004\u0002\u0014A\u0001\rA\u0014\u0005\u0007\u0003O\u0001\u0002\u0019\u0001(\u0002\u0013\u0015tgo\u0014:O_:,G\u0003BA\u001d\u0003CBa!a\u0005\u0012\u0001\u0004q\u0015!C3om>\u00138k\\7f)\u0019\tI$a\u001a\u0002j!1\u00111\u0003\nA\u00029Cq!a\n\u0013\u0001\u0004\tY\u0007\u0005\u0003D\u0003wq\u0015aD:dC2\f\u0007K]8q\u001fJ,En]3\u0015\u000b9\u000b\t(a\u001d\t\r\u0005M1\u00031\u0001O\u0011\u0019\t9c\u0005a\u0001\u001d\u0006\u00012oY1mCB\u0013x\u000e](s\u000b6\u0004H/\u001f\u000b\u0004\u001d\u0006e\u0004BBA\n)\u0001\u0007a*A\btG\u0006d\u0017\r\u0015:pa>\u0013hj\u001c8f)\u0011\tY'a \t\r\u0005MQ\u00031\u0001O\u00039\u0011X\r\\3bg\u00164VM]:j_:,\"!a\u001b\u0002%\u0011,g/\u001a7pa6,g\u000e\u001e,feNLwN\\\u0001\u0014m\u0016\u00148/[8o\u001dVl'-\u001a:TiJLgnZ\u0001\u000em\u0016\u00148/[8o'R\u0014\u0018N\\4\u0002\u001f\r|\u0007/\u001f:jO\"$8\u000b\u001e:j]\u001e\fab]8ve\u000e,WI\\2pI&tw-\u0001\u0007t_V\u00148-\u001a*fC\u0012,'/\u0001\bf]\u000e|G-\u001b8h'R\u0014\u0018N\\4\u0002\u001b1Lg.Z*fa\u0006\u0014\u0018\r^8s\u00035Q\u0017M^1DY\u0006\u001c8\u000fU1uQ\u0006A!.\u0019<b\u0011>lW-\u0001\u0006kCZ\fg+\u001a8e_J\f1B[1wCZ+'o]5p]\u0006Q!.\u0019<b-6LeNZ8\u0002\u0015)\fg/\u0019,n\u001d\u0006lW-\u0001\u0007kCZ\fg+\u001c,f]\u0012|'/A\u0007kCZ\fg+\u001c,feNLwN\\\u0001\u0010U\u00064\u0018m\u00159fGZ+'o]5p]\u0006q!.\u0019<b'B,7MV3oI>\u0014\u0018\u0001\u00046bm\u0006\u001c\u0006/Z2OC6,\u0017AB8t\u001d\u0006lW-A\u0005tG\u0006d\u0017\rS8nK\u00061A/\u001c9ESJ\fq!^:fe\u0012K'/\u0001\u0005vg\u0016\u0014\bj\\7f\u0003!)8/\u001a:OC6,\u0017!B5t/&tWCAA\u0006\u0003\u0015I7/T1d\u0003\u001dI7\u000fT5okb\fq![:Bm&\fg.\u0001\u000bd_2|'/\u001a3PkR\u0004X\u000f^#oC\ndW\rZ\u0001\bU\u0012\\\u0007j\\7f\u0003)1XM]:j_:4uN\u001d\u000b\u0004\u001d\u0006%\u0007BBAfm\u0001\u0007a*A\u0004d_6l\u0017M\u001c3\u0002\u0015Y,'o]5p]6\u001bx-\u0001\u0005tG\u0006d\u0017mQ7e\u0003%\u00198-\u00197bG\u000ekG-A\u0007jg*\u000bg/Y!u\u0019\u0016\f7\u000f\u001e\u000b\u0005\u0003\u0017\t9\u000e\u0003\u0004\u0002Zj\u0002\rAT\u0001\bm\u0016\u00148/[8o\u0003\u0011i\u0017-\u001b8\u0015\u0007%\u000by\u000eC\u0004\u0002bn\u0002\r!a9\u0002\t\u0005\u0014xm\u001d\t\u0005\u0007\u0006\u0015h*C\u0002\u0002h~\u0012Q!\u0011:sCf\u0004")
public interface PropertiesTrait {
    public void scala$util$PropertiesTrait$_setter_$propFilename_$eq(String var1);

    public void scala$util$PropertiesTrait$_setter_$releaseVersion_$eq(Option<String> var1);

    public void scala$util$PropertiesTrait$_setter_$developmentVersion_$eq(Option<String> var1);

    public void scala$util$PropertiesTrait$_setter_$versionString_$eq(String var1);

    public void scala$util$PropertiesTrait$_setter_$copyrightString_$eq(String var1);

    public String propCategory();

    public Class<?> pickJarBasedOn();

    public String propFilename();

    public static /* synthetic */ Properties scalaProps$(PropertiesTrait $this) {
        return $this.scalaProps();
    }

    /*
     * WARNING - void declaration
     */
    default public Properties scalaProps() {
        void var1_1;
        Properties props = new Properties();
        InputStream stream = this.pickJarBasedOn().getResourceAsStream(this.propFilename());
        if (stream != null) {
            try {
                props.load(stream);
            }
            catch (Throwable throwable) {
                try {
                    stream.close();
                }
                catch (IOException iOException) {}
                throw throwable;
            }
            try {
                stream.close();
            }
            catch (IOException iOException) {}
        }
        return var1_1;
    }

    private void quietlyDispose(Function0<BoxedUnit> action, Function0<BoxedUnit> disposal) {
        try {
            action.apply$mcV$sp();
        }
        catch (Throwable throwable) {
            try {
                disposal.apply$mcV$sp();
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            disposal.apply$mcV$sp();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static /* synthetic */ boolean propIsSet$(PropertiesTrait $this, String name) {
        return $this.propIsSet(name);
    }

    default public boolean propIsSet(String name) {
        return System.getProperty(name) != null;
    }

    public static /* synthetic */ boolean propIsSetTo$(PropertiesTrait $this, String name, String value) {
        return $this.propIsSetTo(name, value);
    }

    default public boolean propIsSetTo(String name, String value) {
        String string = this.propOrNull(name);
        return !(string != null ? !string.equals(value) : value != null);
    }

    public static /* synthetic */ String propOrElse$(PropertiesTrait $this, String name, String alt) {
        return $this.propOrElse(name, alt);
    }

    default public String propOrElse(String name, String alt) {
        return System.getProperty(name, alt);
    }

    public static /* synthetic */ String propOrEmpty$(PropertiesTrait $this, String name) {
        return $this.propOrEmpty(name);
    }

    default public String propOrEmpty(String name) {
        return this.propOrElse(name, "");
    }

    public static /* synthetic */ String propOrNull$(PropertiesTrait $this, String name) {
        return $this.propOrNull(name);
    }

    default public String propOrNull(String name) {
        return this.propOrElse(name, null);
    }

    public static /* synthetic */ Option propOrNone$(PropertiesTrait $this, String name) {
        return $this.propOrNone(name);
    }

    default public Option<String> propOrNone(String name) {
        return Option$.MODULE$.apply(this.propOrNull(name));
    }

    public static /* synthetic */ boolean propOrFalse$(PropertiesTrait $this, String name) {
        return $this.propOrFalse(name);
    }

    default public boolean propOrFalse(String name) {
        return this.propOrNone(name).exists((Function1<String, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(PropertiesTrait.$anonfun$propOrFalse$1(x)));
    }

    public static /* synthetic */ String setProp$(PropertiesTrait $this, String name, String value) {
        return $this.setProp(name, value);
    }

    default public String setProp(String name, String value) {
        return System.setProperty(name, value);
    }

    public static /* synthetic */ String clearProp$(PropertiesTrait $this, String name) {
        return $this.clearProp(name);
    }

    default public String clearProp(String name) {
        return System.clearProperty(name);
    }

    public static /* synthetic */ String envOrElse$(PropertiesTrait $this, String name, String alt) {
        return $this.envOrElse(name, alt);
    }

    default public String envOrElse(String name, String alt) {
        Option<String> option = Option$.MODULE$.apply(System.getenv(name));
        if (option == null) {
            throw null;
        }
        Option<String> getOrElse_this = option;
        return getOrElse_this.isEmpty() ? alt : getOrElse_this.get();
    }

    public static /* synthetic */ Option envOrNone$(PropertiesTrait $this, String name) {
        return $this.envOrNone(name);
    }

    default public Option<String> envOrNone(String name) {
        return Option$.MODULE$.apply(System.getenv(name));
    }

    public static /* synthetic */ Option envOrSome$(PropertiesTrait $this, String name, Option alt) {
        return $this.envOrSome(name, alt);
    }

    /*
     * WARNING - void declaration
     */
    default public Option<String> envOrSome(String name, Option<String> alt) {
        void var3_3;
        Option<String> option = this.envOrNone(name);
        if (option == null) {
            throw null;
        }
        Option<String> orElse_this = option;
        if (orElse_this.isEmpty()) {
            return alt;
        }
        return var3_3;
    }

    public static /* synthetic */ String scalaPropOrElse$(PropertiesTrait $this, String name, String alt) {
        return $this.scalaPropOrElse(name, alt);
    }

    default public String scalaPropOrElse(String name, String alt) {
        Option<String> option = this.scalaPropOrNone(name);
        if (option == null) {
            throw null;
        }
        Option<String> getOrElse_this = option;
        return getOrElse_this.isEmpty() ? alt : getOrElse_this.get();
    }

    public static /* synthetic */ String scalaPropOrEmpty$(PropertiesTrait $this, String name) {
        return $this.scalaPropOrEmpty(name);
    }

    default public String scalaPropOrEmpty(String name) {
        return this.scalaPropOrElse(name, "");
    }

    public static /* synthetic */ Option scalaPropOrNone$(PropertiesTrait $this, String name) {
        return $this.scalaPropOrNone(name);
    }

    /*
     * WARNING - void declaration
     */
    default public Option<String> scalaPropOrNone(String name) {
        void var2_2;
        Option<String> option = Option$.MODULE$.apply(this.scalaProps().getProperty(name));
        if (option == null) {
            throw null;
        }
        Option<String> orElse_this = option;
        if (orElse_this.isEmpty()) {
            return this.propOrNone(new StringBuilder(6).append("scala.").append(name).toString());
        }
        return var2_2;
    }

    public Option<String> releaseVersion();

    public Option<String> developmentVersion();

    public static /* synthetic */ String versionNumberString$(PropertiesTrait $this) {
        return $this.versionNumberString();
    }

    default public String versionNumberString() {
        return this.scalaPropOrEmpty("version.number");
    }

    public String versionString();

    public String copyrightString();

    public static /* synthetic */ String sourceEncoding$(PropertiesTrait $this) {
        return $this.sourceEncoding();
    }

    default public String sourceEncoding() {
        return this.scalaPropOrElse("file.encoding", "UTF-8");
    }

    public static /* synthetic */ String sourceReader$(PropertiesTrait $this) {
        return $this.sourceReader();
    }

    default public String sourceReader() {
        return this.scalaPropOrElse("source.reader", "scala.tools.nsc.io.SourceReader");
    }

    public static /* synthetic */ String encodingString$(PropertiesTrait $this) {
        return $this.encodingString();
    }

    default public String encodingString() {
        return this.propOrElse("file.encoding", "UTF-8");
    }

    public static /* synthetic */ String lineSeparator$(PropertiesTrait $this) {
        return $this.lineSeparator();
    }

    default public String lineSeparator() {
        return System.lineSeparator();
    }

    public static /* synthetic */ String javaClassPath$(PropertiesTrait $this) {
        return $this.javaClassPath();
    }

    default public String javaClassPath() {
        return this.propOrEmpty("java.class.path");
    }

    public static /* synthetic */ String javaHome$(PropertiesTrait $this) {
        return $this.javaHome();
    }

    default public String javaHome() {
        return this.propOrEmpty("java.home");
    }

    public static /* synthetic */ String javaVendor$(PropertiesTrait $this) {
        return $this.javaVendor();
    }

    default public String javaVendor() {
        return this.propOrEmpty("java.vendor");
    }

    public static /* synthetic */ String javaVersion$(PropertiesTrait $this) {
        return $this.javaVersion();
    }

    default public String javaVersion() {
        return this.propOrEmpty("java.version");
    }

    public static /* synthetic */ String javaVmInfo$(PropertiesTrait $this) {
        return $this.javaVmInfo();
    }

    default public String javaVmInfo() {
        return this.propOrEmpty("java.vm.info");
    }

    public static /* synthetic */ String javaVmName$(PropertiesTrait $this) {
        return $this.javaVmName();
    }

    default public String javaVmName() {
        return this.propOrEmpty("java.vm.name");
    }

    public static /* synthetic */ String javaVmVendor$(PropertiesTrait $this) {
        return $this.javaVmVendor();
    }

    default public String javaVmVendor() {
        return this.propOrEmpty("java.vm.vendor");
    }

    public static /* synthetic */ String javaVmVersion$(PropertiesTrait $this) {
        return $this.javaVmVersion();
    }

    default public String javaVmVersion() {
        return this.propOrEmpty("java.vm.version");
    }

    public static /* synthetic */ String javaSpecVersion$(PropertiesTrait $this) {
        return $this.javaSpecVersion();
    }

    default public String javaSpecVersion() {
        return this.propOrEmpty("java.specification.version");
    }

    public static /* synthetic */ String javaSpecVendor$(PropertiesTrait $this) {
        return $this.javaSpecVendor();
    }

    default public String javaSpecVendor() {
        return this.propOrEmpty("java.specification.vendor");
    }

    public static /* synthetic */ String javaSpecName$(PropertiesTrait $this) {
        return $this.javaSpecName();
    }

    default public String javaSpecName() {
        return this.propOrEmpty("java.specification.name");
    }

    public static /* synthetic */ String osName$(PropertiesTrait $this) {
        return $this.osName();
    }

    default public String osName() {
        return this.propOrEmpty("os.name");
    }

    public static /* synthetic */ String scalaHome$(PropertiesTrait $this) {
        return $this.scalaHome();
    }

    default public String scalaHome() {
        return this.propOrEmpty("scala.home");
    }

    public static /* synthetic */ String tmpDir$(PropertiesTrait $this) {
        return $this.tmpDir();
    }

    default public String tmpDir() {
        return this.propOrEmpty("java.io.tmpdir");
    }

    public static /* synthetic */ String userDir$(PropertiesTrait $this) {
        return $this.userDir();
    }

    default public String userDir() {
        return this.propOrEmpty("user.dir");
    }

    public static /* synthetic */ String userHome$(PropertiesTrait $this) {
        return $this.userHome();
    }

    default public String userHome() {
        return this.propOrEmpty("user.home");
    }

    public static /* synthetic */ String userName$(PropertiesTrait $this) {
        return $this.userName();
    }

    default public String userName() {
        return this.propOrEmpty("user.name");
    }

    public static /* synthetic */ boolean isWin$(PropertiesTrait $this) {
        return $this.isWin();
    }

    default public boolean isWin() {
        return this.osName().startsWith("Windows");
    }

    public static /* synthetic */ boolean isMac$(PropertiesTrait $this) {
        return $this.isMac();
    }

    default public boolean isMac() {
        return this.osName().startsWith("Mac OS X");
    }

    public static /* synthetic */ boolean isLinux$(PropertiesTrait $this) {
        return $this.isLinux();
    }

    default public boolean isLinux() {
        return this.osName().startsWith("Linux");
    }

    public static /* synthetic */ boolean isAvian$(PropertiesTrait $this) {
        return $this.isAvian();
    }

    default public boolean isAvian() {
        return this.javaVmName().contains("Avian");
    }

    public static /* synthetic */ boolean coloredOutputEnabled$(PropertiesTrait $this) {
        return $this.coloredOutputEnabled();
    }

    default public boolean coloredOutputEnabled() {
        boolean bl;
        String string = this.propOrElse("scala.color", "auto");
        if ("auto".equals(string)) {
            bl = System.console() != null && !this.isWin();
        } else {
            String string2 = string.toLowerCase();
            String string3 = "true";
            bl = string2 != null && string2.equals(string3);
        }
        return bl;
    }

    public static /* synthetic */ String jdkHome$(PropertiesTrait $this) {
        return $this.jdkHome();
    }

    default public String jdkHome() {
        return this.envOrElse("JDK_HOME", this.envOrElse("JAVA_HOME", this.javaHome()));
    }

    private String versionFor(String command) {
        String arg$macro$2 = this.versionString();
        String arg$macro$3 = this.copyrightString();
        return new StringOps("Scala %s %s -- %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{command, arg$macro$2, arg$macro$3}));
    }

    public static /* synthetic */ String versionMsg$(PropertiesTrait $this) {
        return $this.versionMsg();
    }

    default public String versionMsg() {
        return this.versionFor(this.propCategory());
    }

    public static /* synthetic */ String scalaCmd$(PropertiesTrait $this) {
        return $this.scalaCmd();
    }

    default public String scalaCmd() {
        if (this.isWin()) {
            return "scala.bat";
        }
        return "scala";
    }

    public static /* synthetic */ String scalacCmd$(PropertiesTrait $this) {
        return $this.scalacCmd();
    }

    default public String scalacCmd() {
        if (this.isWin()) {
            return "scalac.bat";
        }
        return "scalac";
    }

    public static /* synthetic */ boolean isJavaAtLeast$(PropertiesTrait $this, String version) {
        return $this.isJavaAtLeast(version);
    }

    default public boolean isJavaAtLeast(String version) {
        int n = this.compareVersions$1(this.javaSpecVersion(), version, 0);
        switch (n) {
            case -2: {
                throw new NumberFormatException(new StringBuilder(15).append("Not a version: ").append(version).toString());
            }
        }
        return n >= 0;
    }

    public static /* synthetic */ void main$(PropertiesTrait $this, String[] args2) {
        $this.main(args2);
    }

    default public void main(String[] args2) {
        new PrintWriter(Console$.MODULE$.err(), true).println(this.versionMsg());
    }

    public static /* synthetic */ boolean $anonfun$propOrFalse$1(String x) {
        return new $colon$colon<Nothing$>((Nothing$)((Object)"yes"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"on"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"true"), Nil$.MODULE$))).contains(x.toLowerCase());
    }

    public static /* synthetic */ boolean $anonfun$releaseVersion$1(String v) {
        return !v.endsWith("-SNAPSHOT");
    }

    private static Tuple2 versionOf$1(String s, int depth) {
        int n;
        int n2 = s.indexOf(46);
        switch (n2) {
            case 0: {
                return new Tuple2<Integer, String>(BoxesRunTime.boxToInteger(-2), s.substring(1));
            }
            case 1: {
                if (depth != 0 || s.charAt(0) != '1') break;
                String r0 = s.substring(2);
                Tuple2 tuple2 = PropertiesTrait.versionOf$1(r0, 1);
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                int n3 = tuple2._1$mcI$sp();
                String string = (String)tuple2._2();
                int n4 = n3 > 8 || r0.isEmpty() ? -2 : n3;
                return new Tuple2<Integer, String>(BoxesRunTime.boxToInteger(n4), string);
            }
            case -1: {
                int n5;
                if (!s.isEmpty()) {
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    n5 = new StringOps(s).toInt();
                } else {
                    n5 = depth == 0 ? -2 : 0;
                }
                int n6 = n5;
                return new Tuple2<Integer, String>(BoxesRunTime.boxToInteger(n6), "");
            }
        }
        String r = s.substring(n2 + 1);
        if (depth < 2 && r.isEmpty()) {
            n = -2;
        } else {
            String string = s.substring(0, n2);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            n = new StringOps(string).toInt();
        }
        int n7 = n;
        return new Tuple2<Integer, String>(BoxesRunTime.boxToInteger(n7), r);
    }

    private int compareVersions$1(String s, String v, int depth) {
        while (depth < 3) {
            Tuple2 tuple2 = PropertiesTrait.versionOf$1(s, depth);
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            int n = tuple2._1$mcI$sp();
            String string = (String)tuple2._2();
            Tuple2 tuple22 = PropertiesTrait.versionOf$1(v, depth);
            if (tuple22 == null) {
                throw new MatchError((Object)null);
            }
            int n2 = tuple22._1$mcI$sp();
            String string2 = (String)tuple22._2();
            if (n2 < 0) {
                return -2;
            }
            if (n < n2) {
                return -1;
            }
            if (n > n2) {
                return 1;
            }
            ++depth;
            v = string2;
            s = string;
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    public static void $init$(PropertiesTrait $this) {
        void withFilter_p;
        void withFilter_p2;
        $this.scala$util$PropertiesTrait$_setter_$propFilename_$eq(new StringBuilder(12).append("/").append($this.propCategory()).append(".properties").toString());
        Option<String> option = $this.scalaPropOrNone("maven.version.number");
        Function1<String, Object> & java.io.Serializable & Serializable intersect = (Function1<String, Object> & java.io.Serializable & Serializable)v -> BoxesRunTime.boxToBoolean(PropertiesTrait.$anonfun$releaseVersion$1(v));
        if (option == null) {
            throw null;
        }
        Option<String> withFilter_this = option;
        $this.scala$util$PropertiesTrait$_setter_$releaseVersion_$eq(new Option.WithFilter(withFilter_this, withFilter_p2).map((Function1<String, String> & java.io.Serializable & Serializable)v -> v));
        Option<String> option2 = $this.scalaPropOrNone("maven.version.number");
        Function1<String, Object> & java.io.Serializable & Serializable intersect2 = (Function1<String, Object> & java.io.Serializable & Serializable)v -> BoxesRunTime.boxToBoolean(v.endsWith("-SNAPSHOT"));
        if (option2 == null) {
            throw null;
        }
        Option<String> withFilter_this2 = option2;
        $this.scala$util$PropertiesTrait$_setter_$developmentVersion_$eq(new Option.WithFilter(withFilter_this2, withFilter_p).flatMap((Function1<String, Option> & java.io.Serializable & Serializable)v -> {
            Option<String> option = $this.scalaPropOrNone("version.number");
            if (option == null) {
                throw null;
            }
            Option<String> map_this = option;
            if (map_this.isEmpty()) {
                return None$.MODULE$;
            }
            return new Some<String>(map_this.get());
        }));
        $this.scala$util$PropertiesTrait$_setter_$versionString_$eq(new StringBuilder(8).append("version ").append($this.scalaPropOrElse("version.number", "(unknown)")).toString());
        $this.scala$util$PropertiesTrait$_setter_$copyrightString_$eq($this.scalaPropOrElse("copyright.string", "Copyright 2002-2020, LAMP/EPFL and Lightbend, Inc."));
    }
}

