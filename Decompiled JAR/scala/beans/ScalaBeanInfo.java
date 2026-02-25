/*
 * Decompiled with CFR 0.152.
 */
package scala.beans;

import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.lang.reflect.Method;
import scala.Array$;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.IndexedSeqOptimized;
import scala.collection.TraversableLike;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001!4Q\u0001D\u0007\u0002\u0002IA\u0001B\u0007\u0001\u0003\u0002\u0003\u0006Ia\u0007\u0005\t]\u0001\u0011\t\u0011)A\u0005_!AQ\b\u0001B\u0001B\u0003%q\u0006C\u0003?\u0001\u0011\u0005q\bC\u0004J\u0001\t\u0007I\u0011\u0002&\t\r=\u0003\u0001\u0015!\u0003L\u0011\u001d\u0001\u0006A1A\u0005\nECaA\u0016\u0001!\u0002\u0013\u0011\u0006\"B,\u0001\t\u0003B\u0006\"B-\u0001\t\u0003R\u0006\"B.\u0001\t\u0013a&!D*dC2\f')Z1o\u0013:4wN\u0003\u0002\u000f\u001f\u0005)!-Z1og*\t\u0001#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001\u0019\u0002C\u0001\u000b\u0019\u001b\u0005)\"B\u0001\b\u0017\u0015\u00059\u0012\u0001\u00026bm\u0006L!!G\u000b\u0003\u001dMKW\u000e\u001d7f\u0005\u0016\fg.\u00138g_\u0006)1\r\\1{uB\u0012A\u0004\n\t\u0004;\u0001\u0012S\"\u0001\u0010\u000b\u0005}1\u0012\u0001\u00027b]\u001eL!!\t\u0010\u0003\u000b\rc\u0017m]:\u0011\u0005\r\"C\u0002\u0001\u0003\nK\u0005\t\t\u0011!A\u0003\u0002\u0019\u00121a\u0018\u00132#\t93\u0006\u0005\u0002)S5\tq\"\u0003\u0002+\u001f\t9aj\u001c;iS:<\u0007C\u0001\u0015-\u0013\tisBA\u0002B]f\fQ\u0001\u001d:paN\u00042\u0001\u000b\u00193\u0013\t\ttBA\u0003BeJ\f\u0017\u0010\u0005\u00024u9\u0011A\u0007\u000f\t\u0003k=i\u0011A\u000e\u0006\u0003oE\ta\u0001\u0010:p_Rt\u0014BA\u001d\u0010\u0003\u0019\u0001&/\u001a3fM&\u00111\b\u0010\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005ez\u0011aB7fi\"|Gm]\u0001\u0007y%t\u0017\u000e\u001e \u0015\t\u0001\u0013u\t\u0013\t\u0003\u0003\u0002i\u0011!\u0004\u0005\u00065\u0011\u0001\ra\u0011\u0019\u0003\t\u001a\u00032!\b\u0011F!\t\u0019c\tB\u0005&\u0005\u0006\u0005\t\u0011!B\u0001M!)a\u0006\u0002a\u0001_!)Q\b\u0002a\u0001_\u0005\u0011\u0001\u000fZ\u000b\u0002\u0017B\u0019\u0001\u0006\r'\u0011\u0005Qi\u0015B\u0001(\u0016\u0005I\u0001&o\u001c9feRLH)Z:de&\u0004Ho\u001c:\u0002\u0007A$\u0007%\u0001\u0002nIV\t!\u000bE\u0002)aM\u0003\"\u0001\u0006+\n\u0005U+\"\u0001E'fi\"|G\rR3tGJL\u0007\u000f^8s\u0003\riG\rI\u0001\u0017O\u0016$\bK]8qKJ$\u0018\u0010R3tGJL\u0007\u000f^8sgR\t1*\u0001\u000bhKRlU\r\u001e5pI\u0012+7o\u0019:jaR|'o\u001d\u000b\u0002%\u0006!\u0011N\\5u)\u0005i\u0006C\u0001\u0015_\u0013\tyvB\u0001\u0003V]&$\b\u0006\u0002\u0001bI\u001a\u0004\"\u0001\u000b2\n\u0005\r|!A\u00033faJ,7-\u0019;fI\u0006\nQ-A\u001duQ\u0016\u0004s-\u001a8fe\u0006$\u0018n\u001c8!_\u001a\u0004#)Z1o\u0013:4w\u000eI2mCN\u001cXm\u001d\u0011jg\u0002rw\u000e\t7p]\u001e,'\u000fI:vaB|'\u000f^3eC\u00059\u0017A\u0002\u001a/cIrS\u0007")
public abstract class ScalaBeanInfo
extends SimpleBeanInfo {
    private final Class<?> clazz;
    private final String[] props;
    private final String[] methods;
    private final PropertyDescriptor[] pd;
    private final MethodDescriptor[] md;

    private PropertyDescriptor[] pd() {
        return this.pd;
    }

    private MethodDescriptor[] md() {
        return this.md;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return this.pd();
    }

    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return this.md();
    }

    private void init() {
        for (int i = 0; i < this.props.length; i += 3) {
            this.pd()[i / 3] = new PropertyDescriptor(this.props[i], this.clazz, this.props[i + 1], this.props[i + 2]);
        }
    }

    public static final /* synthetic */ boolean $anonfun$md$2(Method m$1, String x$1) {
        String string = x$1;
        String string2 = m$1.getName();
        return !(string != null ? !string.equals(string2) : string2 != null);
    }

    public static final /* synthetic */ boolean $anonfun$md$1(ScalaBeanInfo $this, Method m) {
        return IndexedSeqOptimized.exists$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])$this.methods)), (Function1<String, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(ScalaBeanInfo.$anonfun$md$2(m, x$1)));
    }

    /*
     * WARNING - void declaration
     */
    public ScalaBeanInfo(Class<?> clazz, String[] props, String[] methods) {
        void withFilter_p;
        this.clazz = clazz;
        this.props = props;
        this.methods = methods;
        this.pd = new PropertyDescriptor[props.length / 3];
        Function1<Method, Object> & java.io.Serializable & Serializable intersect = (Function1<Method, Object> & java.io.Serializable & Serializable)m -> BoxesRunTime.boxToBoolean(ScalaBeanInfo.$anonfun$md$1(this, m));
        ArrayOps.ofRef<Object> withFilter_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])clazz.getMethods()));
        this.md = (MethodDescriptor[])new TraversableLike.WithFilter(withFilter_this, withFilter_p).map((Function1<Method, MethodDescriptor> & java.io.Serializable & Serializable)m -> new MethodDescriptor((Method)m), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(MethodDescriptor.class)));
        this.init();
    }
}

