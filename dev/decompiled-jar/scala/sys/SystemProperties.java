/*
 * Decompiled with CFR 0.152.
 */
package scala.sys;

import java.security.AccessControlException;
import java.util.Properties;
import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.GenSetLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.JavaConverters$;
import scala.collection.MapLike;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.Map;
import scala.collection.mutable.Map$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.java8.JFunction0$mcZ$sp;
import scala.sys.BooleanProp;
import scala.sys.SystemProperties$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u0005=e\u0001B\u0010!\u0001\u0015BQ\u0001\u0010\u0001\u0005\u0002uBQ\u0001\u0011\u0001\u0005B\u0005CQA\u0011\u0001\u0005B\rCQA\u0012\u0001\u0005\u0002\u001dCQ\u0001\u0015\u0001\u0005\u0002ECQa\u0015\u0001\u0005\u0002QCQ\u0001\u0019\u0001\u0005B\u0005DQA\u001a\u0001\u0005\u0002\u001dDQA\u001b\u0001\u0005\u0002-DQA\u001c\u0001\u0005\u0002=Da\"!\u0002\u0001!\u0003\r\t\u0011!C\u0005\u0003\u000f\tYaB\u0004\u0002\u0012\u0001B\t!a\u0005\u0007\r}\u0001\u0003\u0012AA\u000b\u0011\u0019aT\u0002\"\u0001\u0002\u001e!9\u0011qD\u0007\u0005\u0002\u0005\u0005\u0002bBA\u0017\u001b\u0011\r\u0011q\u0006\u0005\n\u0003oi!\u0019!C\u0007\u0003sA\u0001\"!\u0011\u000eA\u00035\u00111\b\u0005\n\u0003\u0007j!\u0019!C\u0007\u0003\u000bB\u0001\"!\u0014\u000eA\u00035\u0011q\t\u0005\n\u0003\u001fj!\u0019!C\u0007\u0003#B\u0001\"!\u0017\u000eA\u00035\u00111\u000b\u0005\n\u00037j!\u0019!C\u0007\u0003;B\u0001\"!\u001a\u000eA\u00035\u0011q\f\u0005\b\u0003OjA\u0011AA5\u0011)\ti'\u0004EC\u0002\u0013\u0005\u0011q\u000e\u0005\u000b\u0003oj\u0001R1A\u0005\u0002\u0005=\u0004BCA=\u001b!\u0015\r\u0011\"\u0001\u0002p!Q\u00111P\u0007\t\u0006\u0004%\t!a\u001c\t\u000f\u0005uT\u0002\"\u0001\u0002p\t\u00012+_:uK6\u0004&o\u001c9feRLWm\u001d\u0006\u0003C\t\n1a]=t\u0015\u0005\u0019\u0013!B:dC2\f7\u0001A\n\u0004\u0001\u0019J\u0004\u0003B\u0014-]9j\u0011\u0001\u000b\u0006\u0003S)\nq!\\;uC\ndWM\u0003\u0002,E\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u00055B#aC!cgR\u0014\u0018m\u0019;NCB\u0004\"a\f\u001c\u000f\u0005A\"\u0004CA\u0019#\u001b\u0005\u0011$BA\u001a%\u0003\u0019a$o\\8u}%\u0011QGI\u0001\u0007!J,G-\u001a4\n\u0005]B$AB*ue&twM\u0003\u00026EA!qE\u000f\u0018/\u0013\tY\u0004FA\u0002NCB\fa\u0001P5oSRtD#\u0001 \u0011\u0005}\u0002Q\"\u0001\u0011\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003e\nq\u0001Z3gCVdG\u000f\u0006\u0002/\t\")Qi\u0001a\u0001]\u0005\u00191.Z=\u0002\u0011%$XM]1u_J,\u0012\u0001\u0013\t\u0004\u0013*cU\"\u0001\u0016\n\u0005-S#\u0001C%uKJ\fGo\u001c:\u0011\t5seFL\u0007\u0002E%\u0011qJ\t\u0002\u0007)V\u0004H.\u001a\u001a\u0002\u000b9\fW.Z:\u0016\u0003I\u00032!\u0013&/\u0003\r9W\r\u001e\u000b\u0003+~\u00032!\u0014,Y\u0013\t9&E\u0001\u0004PaRLwN\u001c\t\u00033zk\u0011A\u0017\u0006\u00037r\u000bA\u0001\\1oO*\tQ,\u0001\u0003kCZ\f\u0017BA\u001c[\u0011\u0015)e\u00011\u0001/\u0003!\u0019wN\u001c;bS:\u001cHC\u00012f!\ti5-\u0003\u0002eE\t9!i\\8mK\u0006t\u0007\"B#\b\u0001\u0004q\u0013!\u0003\u0013nS:,8\u000fJ3r)\tA\u0017.D\u0001\u0001\u0011\u0015)\u0005\u00021\u0001/\u0003!!\u0003\u000f\\;tI\u0015\fHC\u00015m\u0011\u0015i\u0017\u00021\u0001M\u0003\tYg/\u0001\u0006xe\u0006\u0004\u0018iY2fgN,\"\u0001\u001d;\u0015\u0005El\bcA'WeB\u00111\u000f\u001e\u0007\u0001\t\u0015)(B1\u0001w\u0005\u0005!\u0016CA<{!\ti\u00050\u0003\u0002zE\t9aj\u001c;iS:<\u0007CA'|\u0013\ta(EA\u0002B]fDaA \u0006\u0005\u0002\u0004y\u0018\u0001\u00022pIf\u0004B!TA\u0001e&\u0019\u00111\u0001\u0012\u0003\u0011q\u0012\u0017P\\1nKz\nab];qKJ$3m\u001c8uC&t7\u000fF\u0002c\u0003\u0013AQ!R\u0006A\u00029J1\u0001YA\u0007\u0013\r\tyA\u000b\u0002\b\u001b\u0006\u0004H*[6f\u0003A\u0019\u0016p\u001d;f[B\u0013x\u000e]3si&,7\u000f\u0005\u0002@\u001bM\u0019Q\"a\u0006\u0011\u00075\u000bI\"C\u0002\u0002\u001c\t\u0012a!\u00118z%\u00164GCAA\n\u0003-)\u0007p\u00197vg&4X\r\\=\u0016\t\u0005\r\u0012q\u0005\u000b\u0005\u0003K\tI\u0003E\u0002t\u0003O!Q!^\bC\u0002YDqA`\b\u0005\u0002\u0004\tY\u0003E\u0003N\u0003\u0003\t)#A\u000etsN$X-\u001c)s_B,'\u000f^5fgR{7i\\7qC:LwN\u001c\u000b\u0005\u0003c\t\u0019D\u0004\u0002@\u0019!1\u0011Q\u0007\tA\u0002y\n\u0011\u0001]\u0001\f\u0011\u0016\fG\r\\3tg.+\u00170\u0006\u0002\u0002<=\u0011\u0011QH\u0011\u0003\u0003\u007f\t\u0011C[1wC:\nw\u000f\u001e\u0018iK\u0006$G.Z:t\u00031AU-\u00193mKN\u001c8*Z=!\u0003I\u0001&/\u001a4fe&\u0003f\u000fN*uC\u000e\\7*Z=\u0016\u0005\u0005\u001dsBAA%C\t\tY%\u0001\rkCZ\fgF\\3u]A\u0014XMZ3s\u0013B3Hg\u0015;bG.\f1\u0003\u0015:fM\u0016\u0014\u0018\n\u0015<5'R\f7m[&fs\u0002\na\u0003\u0015:fM\u0016\u0014\u0018\n\u0015<7\u0003\u0012$'/Z:tKN\\U-_\u000b\u0003\u0003'z!!!\u0016\"\u0005\u0005]\u0013\u0001\b6bm\u0006tc.\u001a;/aJ,g-\u001a:J!Z4\u0014\t\u001a3sKN\u001cXm]\u0001\u0018!J,g-\u001a:J!Z4\u0014\t\u001a3sKN\u001cXm]&fs\u0002\nQCT8Ue\u0006\u001cWmU;qaJ,7o]5p].+\u00170\u0006\u0002\u0002`=\u0011\u0011\u0011M\u0011\u0003\u0003G\n\u0001e]2bY\u0006t3m\u001c8ue>dgF\\8Ue\u0006\u001cWmU;qaJ,7o]5p]\u00061bj\u001c+sC\u000e,7+\u001e9qe\u0016\u001c8/[8o\u0017\u0016L\b%\u0001\u0003iK2\u0004Hc\u0001\u0018\u0002l!)Q)\u0007a\u0001]\u0005A\u0001.Z1eY\u0016\u001c8/\u0006\u0002\u0002rA\u0019q(a\u001d\n\u0007\u0005U\u0004EA\u0006C_>dW-\u00198Qe>\u0004\u0018a\u00049sK\u001a,'/\u0013)wiM#\u0018mY6\u0002'A\u0014XMZ3s\u0013B3h'\u00113ee\u0016\u001c8/Z:\u0002%9|GK]1dKN+\b\u000f\u001d:fgNLwN\\\u0001\u0012]>$&/Y2f'V\u0004(/Z:tS>t\u0007f\u0002\u0010\u0002\u0002\u0006\u001d\u00151\u0012\t\u0004\u001b\u0006\r\u0015bAACE\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0005\u0005%\u0015AF;tK\u0002rw\u000e\u0016:bG\u0016\u001cV\u000f\u001d9sKN\u001c\u0018n\u001c8\"\u0005\u00055\u0015A\u0002\u001a/cIr\u0003\u0007")
public class SystemProperties
extends AbstractMap<String, String> {
    public static BooleanProp noTraceSupression() {
        return SystemProperties$.MODULE$.noTraceSupression();
    }

    public static BooleanProp noTraceSuppression() {
        return SystemProperties$.MODULE$.noTraceSuppression();
    }

    public static BooleanProp preferIPv6Addresses() {
        return SystemProperties$.MODULE$.preferIPv6Addresses();
    }

    public static BooleanProp preferIPv4Stack() {
        return SystemProperties$.MODULE$.preferIPv4Stack();
    }

    public static BooleanProp headless() {
        return SystemProperties$.MODULE$.headless();
    }

    public static String help(String string) {
        return SystemProperties$.MODULE$.help(string);
    }

    public static SystemProperties$ systemPropertiesToCompanion(SystemProperties systemProperties) {
        return SystemProperties$.MODULE$.systemPropertiesToCompanion(systemProperties);
    }

    public static <T> T exclusively(Function0<T> function0) {
        return SystemProperties$.MODULE$.exclusively(function0);
    }

    private /* synthetic */ boolean super$contains(String key) {
        return MapLike.contains$(this, key);
    }

    @Override
    public Map<String, String> empty() {
        return (Map)Map$.MODULE$.apply(Nil$.MODULE$);
    }

    @Override
    public String default(String key) {
        return null;
    }

    @Override
    public Iterator<Tuple2<String, String>> iterator() {
        Option option = this.wrapAccess((Function0<Iterator> & java.io.Serializable & Serializable)() -> {
            Properties ps = System.getProperties();
            return this.names().map((Function1<String, Tuple2> & java.io.Serializable & Serializable)k -> new Tuple2<String, String>((String)k, ps.getProperty((String)k))).filter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x$1) -> BoxesRunTime.boxToBoolean(SystemProperties.$anonfun$iterator$3(x$1)));
        });
        if (option == null) {
            throw null;
        }
        Option getOrElse_this = option;
        return getOrElse_this.isEmpty() ? Iterator$.MODULE$.empty() : getOrElse_this.get();
    }

    public Iterator<String> names() {
        Option option = this.wrapAccess((Function0<Iterator> & java.io.Serializable & Serializable)() -> ((GenSetLike)JavaConverters$.MODULE$.asScalaSetConverter(System.getProperties().stringPropertyNames()).asScala()).iterator());
        if (option == null) {
            throw null;
        }
        Option getOrElse_this = option;
        return getOrElse_this.isEmpty() ? Iterator$.MODULE$.empty() : getOrElse_this.get();
    }

    @Override
    public Option<String> get(String key) {
        Option option = this.wrapAccess((Function0<Option> & java.io.Serializable & Serializable)() -> Option$.MODULE$.apply(System.getProperty(key)));
        if (option == null) {
            throw null;
        }
        Option flatMap_this = option;
        if (flatMap_this.isEmpty()) {
            return None$.MODULE$;
        }
        return (Option)flatMap_this.get();
    }

    @Override
    public boolean contains(String key) {
        return this.wrapAccess((JFunction0$mcZ$sp & Serializable)() -> this.super$contains(key)).exists((Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(BoxesRunTime.unboxToBoolean(x)));
    }

    public SystemProperties $minus$eq(String key) {
        this.wrapAccess((Function0<String> & java.io.Serializable & Serializable)() -> System.clearProperty(key));
        return this;
    }

    public SystemProperties $plus$eq(Tuple2<String, String> kv) {
        this.wrapAccess((Function0<String> & java.io.Serializable & Serializable)() -> System.setProperty((String)kv._1(), (String)kv._2()));
        return this;
    }

    public <T> Option<T> wrapAccess(Function0<T> body) {
        try {
            return new Some<T>(body.apply());
        }
        catch (AccessControlException accessControlException) {
            return None$.MODULE$;
        }
    }

    public static final /* synthetic */ boolean $anonfun$iterator$3(Tuple2 x$1) {
        return x$1._2() != null;
    }
}

