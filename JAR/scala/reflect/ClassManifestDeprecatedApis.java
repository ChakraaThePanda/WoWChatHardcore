/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import java.lang.reflect.Array;
import scala.Function2;
import scala.Option$;
import scala.Predef$;
import scala.Serializable;
import scala.collection.LinearSeqLike;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.WrappedArray;
import scala.reflect.AnyValManifest;
import scala.reflect.ClassTag;
import scala.reflect.NoManifest$;
import scala.reflect.OptManifest;
import scala.reflect.ScalaSignature;
import scala.reflect.package$;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005uh!C\n\u0015!\u0003\r\t!GA{\u0011\u0015q\u0003\u0001\"\u00010\u0011\u0015\u0019\u0004\u0001\"\u00015\u0011\u0015I\u0005\u0001\"\u0003K\u0011\u0015a\u0006\u0001\"\u0003^\u0011\u0015!\b\u0001\"\u0001v\u0011\u001d\tY\u0001\u0001C\u0001\u0003\u001bAq!!\b\u0001\t\u0003\ny\u0002C\u0004\u0002&\u0001!\t\"a\n\t\u000f\u0005\u0015\u0003\u0001\"\u0001\u0002H!9\u00111\u000b\u0001\u0005B\u0005U\u0003bBA1\u0001\u0011\u0005\u00111\r\u0005\b\u0003_\u0002A\u0011AA9\u0011\u001d\ti\b\u0001C\u0001\u0003\u007fBq!a#\u0001\t\u0003\ti\tC\u0004\u0002\u001a\u0002!\t!a'\t\u000f\u0005U\u0006\u0001\"\u0001\u00028\"9\u0011Q\u0019\u0001\u0005\u0002\u0005\u001d\u0007bBAn\u0001\u0011E\u0011Q\u001c\u0002\u001c\u00072\f7o]'b]&4Wm\u001d;EKB\u0014XmY1uK\u0012\f\u0005/[:\u000b\u0005U1\u0012a\u0002:fM2,7\r\u001e\u0006\u0002/\u0005)1oY1mC\u000e\u0001QC\u0001\u000e&'\r\u00011d\b\t\u00039ui\u0011AF\u0005\u0003=Y\u0011a!\u00118z%\u00164\u0007c\u0001\u0011\"G5\tA#\u0003\u0002#)\tYq\n\u001d;NC:Lg-Z:u!\t!S\u0005\u0004\u0001\u0005\u000b\u0019\u0002!\u0019A\u0014\u0003\u0003Q\u000b\"\u0001K\u0016\u0011\u0005qI\u0013B\u0001\u0016\u0017\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\b\u0017\n\u000552\"aA!os\u00061A%\u001b8ji\u0012\"\u0012\u0001\r\t\u00039EJ!A\r\f\u0003\tUs\u0017\u000e^\u0001\bKJ\f7/\u001e:f+\u0005)\u0004G\u0001\u001c@!\r9DHP\u0007\u0002q)\u0011\u0011HO\u0001\u0005Y\u0006twMC\u0001<\u0003\u0011Q\u0017M^1\n\u0005uB$!B\"mCN\u001c\bC\u0001\u0013@\t%\u0001%!!A\u0001\u0002\u000b\u0005qEA\u0002`IEBCA\u0001\"F\u000fB\u0011AdQ\u0005\u0003\tZ\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u00051\u0015\u0001G;tK\u0002\u0012XO\u001c;j[\u0016\u001cE.Y:tA%t7\u000f^3bI\u0006\n\u0001*\u0001\u00043]E\u0002d\u0006M\u0001\bgV\u0014G/\u001f9f)\rYe*\u0016\t\u000391K!!\u0014\f\u0003\u000f\t{w\u000e\\3b]\")qj\u0001a\u0001!\u0006\u00191/\u001e21\u0005E\u001b\u0006cA\u001c=%B\u0011Ae\u0015\u0003\n):\u000b\t\u0011!A\u0003\u0002\u001d\u00121a\u0018\u00133\u0011\u001516\u00011\u0001X\u0003\r\u0019X\u000f\u001d\u0019\u00031j\u00032a\u000e\u001fZ!\t!#\fB\u0005\\+\u0006\u0005\t\u0011!B\u0001O\t\u0019q\fJ\u001a\u0002\u000fM,(-\u0019:hgR\u00191J\u00187\t\u000b}#\u0001\u0019\u00011\u0002\u000b\u0005\u0014xm]\u0019\u0011\u0007\u0005$wM\u0004\u0002\u001dE&\u00111MF\u0001\ba\u0006\u001c7.Y4f\u0013\t)gM\u0001\u0003MSN$(BA2\u0017a\tA'\u000eE\u0002!C%\u0004\"\u0001\n6\u0005\u0013-t\u0016\u0011!A\u0001\u0006\u00039#aA0%m!)Q\u000e\u0002a\u0001]\u0006)\u0011M]4teA\u0019\u0011\rZ81\u0005A\u0014\bc\u0001\u0011\"cB\u0011AE\u001d\u0003\ng2\f\t\u0011!A\u0003\u0002\u001d\u00121a\u0018\u00138\u0003A!C.Z:tI\r|Gn\u001c8%Y\u0016\u001c8\u000f\u0006\u0002Lm\")q/\u0002a\u0001q\u0006!A\u000f[1ua\rI\u0018\u0011\u0001\t\u0004ur|hB\u0001\u0011|\u0013\t\u0019G#\u0003\u0002~}\ni1\t\\1tg6\u000bg.\u001b4fgRT!a\u0019\u000b\u0011\u0007\u0011\n\t\u0001\u0002\u0006\u0002\u0004Y\f\t\u0011!A\u0003\u0002\u001d\u00121a\u0018\u00139Q\u0015)!)a\u0002HC\t\tI!A$vg\u0016\u00043oY1mC:\u0012XM\u001a7fGRt#/\u001e8uS6,g&\u001e8jm\u0016\u00148/\u001a\u0018UsB,G+Y4!M>\u0014\be];cif\u0004X\rI2iK\u000e\\\u0017N\\4!S:\u001cH/Z1e\u0003Y!sM]3bi\u0016\u0014HeY8m_:$sM]3bi\u0016\u0014HcA&\u0002\u0010!1qO\u0002a\u0001\u0003#\u0001D!a\u0005\u0002\u0018A!!\u0010`A\u000b!\r!\u0013q\u0003\u0003\f\u00033\ty!!A\u0001\u0002\u000b\u0005qE\u0001\u0003`IE\u0002\u0004&\u0002\u0004C\u0003\u000f9\u0015\u0001C2b]\u0016\u000bX/\u00197\u0015\u0007-\u000b\t\u0003\u0003\u0004\u0002$\u001d\u0001\raK\u0001\u0006_RDWM]\u0001\u000bCJ\u0014\u0018-_\"mCN\u001cX\u0003BA\u0015\u0003k!B!a\u000b\u00028A!q\u0007PA\u0017!\u0015a\u0012qFA\u001a\u0013\r\t\tD\u0006\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0004I\u0005UB!\u0002\u0014\t\u0005\u00049\u0003bBA\u001d\u0011\u0001\u0007\u00111H\u0001\u0003iB\u0004D!!\u0010\u0002BA!q\u0007PA !\r!\u0013\u0011\t\u0003\f\u0003\u0007\n9$!A\u0001\u0002\u000b\u0005qE\u0001\u0003`IE\n\u0014!D1se\u0006LX*\u00198jM\u0016\u001cH/\u0006\u0002\u0002JA!!\u0010`A&!\u0011a\u0012qF\u0012)\u000b%\u0011\u0015qJ$\"\u0005\u0005E\u0013\u0001E;tK\u0002:(/\u00199!S:\u001cH/Z1e\u0003!qWm^!se\u0006LH\u0003BA&\u0003/Bq!!\u0017\u000b\u0001\u0004\tY&A\u0002mK:\u00042\u0001HA/\u0013\r\tyF\u0006\u0002\u0004\u0013:$\u0018!\u00038fo\u0006\u0013(/Y=3)\u0011\t)'a\u001a\u0011\u000bq\ty#a\u0013\t\u000f\u0005e3\u00021\u0001\u0002\\!*1BQA6\u000f\u0006\u0012\u0011QN\u0001\u001akN,\u0007e\u001e:ba:rWm^!se\u0006L\b%\u001b8ti\u0016\fG-A\u0005oK^\f%O]1zgQ!\u00111OA;!\u0015a\u0012qFA3\u0011\u001d\tI\u0006\u0004a\u0001\u00037BS\u0001\u0004\"\u0002z\u001d\u000b#!a\u001f\u0002=U\u001cX\rI<sCBtsO]1q]9,w/\u0011:sCf\u0004\u0013N\\:uK\u0006$\u0017!\u00038fo\u0006\u0013(/Y=5)\u0011\t\t)a!\u0011\u000bq\ty#a\u001d\t\u000f\u0005eS\u00021\u0001\u0002\\!*QBQAD\u000f\u0006\u0012\u0011\u0011R\u0001$kN,\u0007e\u001e:ba::(/\u00199/oJ\f\u0007O\f8fo\u0006\u0013(/Y=!S:\u001cH/Z1e\u0003%qWm^!se\u0006LX\u0007\u0006\u0003\u0002\u0010\u0006E\u0005#\u0002\u000f\u00020\u0005\u0005\u0005bBA-\u001d\u0001\u0007\u00111\f\u0015\u0006\u001d\t\u000b)jR\u0011\u0003\u0003/\u000b\u0001&^:fA]\u0014\u0018\r\u001d\u0018xe\u0006\u0004hf\u001e:ba::(/\u00199/]\u0016<\u0018I\u001d:bs\u0002Jgn\u001d;fC\u0012\fqB\\3x/J\f\u0007\u000f]3e\u0003J\u0014\u0018-\u001f\u000b\u0005\u0003;\u000bi\u000bE\u0003\u0002 \u0006%6%\u0004\u0002\u0002\"*!\u00111UAS\u0003\u001diW\u000f^1cY\u0016T1!a*\u0017\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003W\u000b\tK\u0001\u0007Xe\u0006\u0004\b/\u001a3BeJ\f\u0017\u0010C\u0004\u0002Z=\u0001\r!a\u0017)\u000b=\u0011\u0015\u0011W$\"\u0005\u0005M\u0016\u0001J2sK\u0006$X\rI,sCB\u0004X\rZ!se\u0006L\b\u0005Z5sK\u000e$H.\u001f\u0011j]N$X-\u00193\u0002\u001f9,w/\u0011:sCf\u0014U/\u001b7eKJ$\"!!/\u0011\u000b\u0005}\u00151X\u0012\n\t\u0005u\u0016\u0011\u0015\u0002\r\u0003J\u0014\u0018-\u001f\"vS2$WM\u001d\u0015\u0006!\t\u000b\tmR\u0011\u0003\u0003\u0007\f1%^:fA\u0005\u0013(/Y=Ck&dG-\u001a:/[\u0006\\W\r\u000b;iSNL\u0003%\u001b8ti\u0016\fG-A\u0007usB,\u0017I]4v[\u0016tGo]\u000b\u0003\u0003\u0013\u0004B!\u00193\u0002LB\"\u0011QZAi!\u0011\u0001\u0013%a4\u0011\u0007\u0011\n\t\u000e\u0002\u0006\u0002TF\t\t\u0011!A\u0003\u0002\u001d\u0012Aa\u0018\u00132e!*\u0011CQAl\u000f\u0006\u0012\u0011\u0011\\\u0001MkN,\u0007e]2bY\u0006t#/\u001a4mK\u000e$hF];oi&lWML;oSZ,'o]3/)f\u0004X\rV1hAQ|\u0007eY1qiV\u0014X\r\t;za\u0016\u00043\u000f\u001e:vGR,(/\u001a\u0011j]N$X-\u00193\u0002\u0013\u0005\u0014xm\u0015;sS:<WCAAp!\u0011\t\t/a<\u000f\t\u0005\r\u00181\u001e\t\u0004\u0003K4RBAAt\u0015\r\tI\u000fG\u0001\u0007yI|w\u000e\u001e \n\u0007\u00055h#\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003c\f\u0019P\u0001\u0004TiJLgn\u001a\u0006\u0004\u0003[4\u0002c\u0001>}G!*\u0001AQA}\u000f\u0006\u0012\u00111`\u0001#kN,\u0007e]2bY\u0006t#/\u001a4mK\u000e$hf\u00117bgN$\u0016m\u001a\u0011j]N$X-\u00193")
public interface ClassManifestDeprecatedApis<T>
extends OptManifest<T> {
    public static /* synthetic */ Class erasure$(ClassManifestDeprecatedApis $this) {
        return $this.erasure();
    }

    default public Class<?> erasure() {
        return ((ClassTag)this).runtimeClass();
    }

    private boolean subtype(Class<?> sub, Class<?> sup) {
        return this.loop$1((Set)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapRefArray((Object[])new Class[]{sub})), (Set)Predef$.MODULE$.Set().apply(Nil$.MODULE$), sup);
    }

    /*
     * WARNING - void declaration
     */
    private boolean subargs(List<OptManifest<?>> args1, List<OptManifest<?>> args2) {
        void corresponds_p;
        Function2<OptManifest, OptManifest, Object> & java.io.Serializable & Serializable intersect = (Function2<OptManifest, OptManifest, Object> & java.io.Serializable & Serializable)(x0$1, x1$1) -> BoxesRunTime.boxToBoolean(ClassManifestDeprecatedApis.$anonfun$subargs$1(x0$1, x1$1));
        if (args1 == null) {
            throw null;
        }
        return LinearSeqLike.corresponds$(args1, args2, (Function2)corresponds_p);
    }

    public static /* synthetic */ boolean $less$colon$less$(ClassManifestDeprecatedApis $this, ClassTag that) {
        return $this.$less$colon$less(that);
    }

    default public boolean $less$colon$less(ClassTag<?> that) {
        if (!ClassManifestDeprecatedApis.cannotMatch$1(that)) {
            Class<?> clazz = ((ClassTag)this).runtimeClass();
            Class<?> clazz2 = that.runtimeClass();
            if (!(clazz != null ? !clazz.equals(clazz2) : clazz2 != null) ? this.subargs(this.typeArguments(), that.typeArguments()) : that.typeArguments().isEmpty() && this.subtype(((ClassTag)this).runtimeClass(), that.runtimeClass())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean $greater$colon$greater$(ClassManifestDeprecatedApis $this, ClassTag that) {
        return $this.$greater$colon$greater(that);
    }

    default public boolean $greater$colon$greater(ClassTag<?> that) {
        return that.$less$colon$less((ClassTag)this);
    }

    public static /* synthetic */ boolean canEqual$(ClassManifestDeprecatedApis $this, Object other) {
        return $this.canEqual(other);
    }

    default public boolean canEqual(Object other) {
        boolean bl = other instanceof ClassTag;
        return bl;
    }

    public static /* synthetic */ Class arrayClass$(ClassManifestDeprecatedApis $this, Class tp) {
        return $this.arrayClass(tp);
    }

    default public <T> Class<Object> arrayClass(Class<?> tp) {
        return Array.newInstance(tp, 0).getClass();
    }

    public static /* synthetic */ ClassTag arrayManifest$(ClassManifestDeprecatedApis $this) {
        return $this.arrayManifest();
    }

    default public ClassTag<Object> arrayManifest() {
        return package$.MODULE$.ClassManifest().classType(this.arrayClass(((ClassTag)this).runtimeClass()), this, Predef$.MODULE$.wrapRefArray((Object[])new OptManifest[0]));
    }

    public static /* synthetic */ Object newArray$(ClassManifestDeprecatedApis $this, int len) {
        return $this.newArray(len);
    }

    default public Object newArray(int len) {
        return Array.newInstance(((ClassTag)this).runtimeClass(), len);
    }

    public static /* synthetic */ Object[] newArray2$(ClassManifestDeprecatedApis $this, int len) {
        return $this.newArray2(len);
    }

    default public Object[] newArray2(int len) {
        return (Object[])Array.newInstance(this.arrayClass(((ClassTag)this).runtimeClass()), len);
    }

    public static /* synthetic */ Object[][] newArray3$(ClassManifestDeprecatedApis $this, int len) {
        return $this.newArray3(len);
    }

    default public Object[][] newArray3(int len) {
        return (Object[][])Array.newInstance(this.arrayClass(this.arrayClass(((ClassTag)this).runtimeClass())), len);
    }

    public static /* synthetic */ Object[][][] newArray4$(ClassManifestDeprecatedApis $this, int len) {
        return $this.newArray4(len);
    }

    default public Object[][][] newArray4(int len) {
        return (Object[][][])Array.newInstance(this.arrayClass(this.arrayClass(this.arrayClass(((ClassTag)this).runtimeClass()))), len);
    }

    public static /* synthetic */ Object[][][][] newArray5$(ClassManifestDeprecatedApis $this, int len) {
        return $this.newArray5(len);
    }

    default public Object[][][][] newArray5(int len) {
        return (Object[][][][])Array.newInstance(this.arrayClass(this.arrayClass(this.arrayClass(this.arrayClass(((ClassTag)this).runtimeClass())))), len);
    }

    public static /* synthetic */ WrappedArray newWrappedArray$(ClassManifestDeprecatedApis $this, int len) {
        return $this.newWrappedArray(len);
    }

    default public WrappedArray<T> newWrappedArray(int len) {
        return new WrappedArray.ofRef<Object>((Object[])((ClassTag)this).newArray(len));
    }

    public static /* synthetic */ ArrayBuilder newArrayBuilder$(ClassManifestDeprecatedApis $this) {
        return $this.newArrayBuilder();
    }

    default public ArrayBuilder<T> newArrayBuilder() {
        return new ArrayBuilder.ofRef((ClassTag)this);
    }

    public static /* synthetic */ List typeArguments$(ClassManifestDeprecatedApis $this) {
        return $this.typeArguments();
    }

    default public List<OptManifest<?>> typeArguments() {
        return Nil$.MODULE$;
    }

    public static /* synthetic */ String argString$(ClassManifestDeprecatedApis $this) {
        return $this.argString();
    }

    default public String argString() {
        if (this.typeArguments().nonEmpty()) {
            return this.typeArguments().mkString("[", ", ", "]");
        }
        if (((ClassTag)this).runtimeClass().isArray()) {
            return new StringBuilder(2).append("[").append(package$.MODULE$.ClassManifest().fromClass(((ClassTag)this).runtimeClass().getComponentType())).append("]").toString();
        }
        return "";
    }

    private boolean loop$1(Set left, Set seen, Class sup$1) {
        while (left.nonEmpty()) {
            Class next = (Class)left.head();
            Set supers = (Set)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])next.getInterfaces())).toSet().$plus$plus(Option$.MODULE$.option2Iterable(Option$.MODULE$.apply(next.getSuperclass())));
            if (!supers.apply(sup$1)) {
                Set xs = (Set)left.$plus$plus(supers).filterNot(seen);
                seen = (Set)seen.$plus(next);
                left = (Set)xs.$minus(next);
                ClassManifestDeprecatedApis this_ = (ClassTag)this_;
                continue;
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ boolean $anonfun$subargs$1(OptManifest x0$1, OptManifest x1$1) {
        OptManifest x = x0$1;
        OptManifest y = x1$1;
        if (x instanceof ClassTag) {
            ClassTag classTag = (ClassTag)x;
            if (y instanceof ClassTag) {
                ClassTag classTag2 = (ClassTag)y;
                return classTag.$less$colon$less(classTag2);
            }
        }
        OptManifest x2 = x0$1;
        OptManifest y2 = x1$1;
        if (x2 != NoManifest$.MODULE$) return false;
        if (y2 != NoManifest$.MODULE$) return false;
        return true;
    }

    private static boolean cannotMatch$1(ClassTag that$1) {
        return that$1 instanceof AnyValManifest || that$1 == package$.MODULE$.Manifest().AnyVal() || that$1 == package$.MODULE$.Manifest().Nothing() || that$1 == package$.MODULE$.Manifest().Null();
    }

    public static void $init$(ClassManifestDeprecatedApis $this) {
    }
}

