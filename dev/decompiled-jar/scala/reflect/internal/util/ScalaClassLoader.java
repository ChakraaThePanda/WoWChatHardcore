/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableOnce;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.HasClassPath;
import scala.reflect.internal.util.ScalaClassLoader$;
import scala.reflect.io.Streamable;
import scala.reflect.io.Streamable$;
import scala.reflect.package$;
import scala.reflect.runtime.ReflectionUtils$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.util.control.Exception$;

@ScalaSignature(bytes="\u0006\u0001\t]aaB\u0011#!\u0003\r\ta\u000b\u0005\u0006i\u0001!\t!\u000e\u0005\u0006u\u0001!\ta\u000f\u0005\u0006\u001b\u0002!\tA\u0014\u0005\u0006S\u0002!\tA\u001b\u0005\u0006c\u0002!IA\u001d\u0005\u0006}\u0002!\ta \u0005\u0007}\u0002!\t!a\u0001\t\u000f\u0005E\u0002\u0001\"\u0001\u00024!9\u0011Q\t\u0001\u0005\u0002\u0005\u001d\u0003bBA,\u0001\u0011\u0005\u0011\u0011L\u0004\b\u0003c\u0012\u0003\u0012AA:\r\u0019\t#\u0005#\u0001\u0002x!9\u0011\u0011\u0010\u0007\u0005\u0002\u0005m\u0004bBA?\u0019\u0011\r\u0011q\u0010\u0005\b\u0003\u000fcA\u0011AAE\u0011\u001d\tY\t\u0004C\u0001\u0003\u0013Cq!!$\r\t\u0003\tyI\u0002\u0004\u0002\u00142\u0001\u0011Q\u0013\u0005\u000b\u0003O\u0013\"\u0011!Q\u0001\n\u0005%\u0006\"CAY%\t\u0005\t\u0015!\u0003-\u0011\u001d\tIH\u0005C\u0001\u0003gC\u0011\"!0\u0013\u0001\u0004%I!a0\t\u0013\u0005\u0005'\u00031A\u0005\n\u0005\r\u0007\u0002CAe%\u0001\u0006K!!+\t\u000f\u0005-'\u0003\"\u0001\u0002@\"9\u0011Q\u001a\n\u0005B\u0005=\u0007BBAk%\u0011\u0005S\u0007C\u0004\u0002X2!\t!!7\t\u0013\u0005}G\"%A\u0005\u0002\u0005\u0005\bbBA|\u0019\u0011\u0005\u0011\u0011 \u0005\b\u0005\u0003aA\u0011\u0001B\u0002\u0011\u001d\u0011)\u0002\u0004Q\u0001\n1\u0012\u0001cU2bY\u0006\u001cE.Y:t\u0019>\fG-\u001a:\u000b\u0005\r\"\u0013\u0001B;uS2T!!\n\u0014\u0002\u0011%tG/\u001a:oC2T!a\n\u0015\u0002\u000fI,g\r\\3di*\t\u0011&A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001a\u0003CA\u00173\u001b\u0005q#BA\u00181\u0003\u0011a\u0017M\\4\u000b\u0003E\nAA[1wC&\u00111G\f\u0002\f\u00072\f7o\u001d'pC\u0012,'/\u0001\u0004%S:LG\u000f\n\u000b\u0002mA\u0011q\u0007O\u0007\u0002Q%\u0011\u0011\b\u000b\u0002\u0005+:LG/A\u0005bg\u000e{g\u000e^3yiV\u0011Ah\u0010\u000b\u0003{!\u0003\"AP \r\u0001\u0011)\u0001I\u0001b\u0001\u0003\n\tA+\u0005\u0002C\u000bB\u0011qgQ\u0005\u0003\t\"\u0012qAT8uQ&tw\r\u0005\u00028\r&\u0011q\t\u000b\u0002\u0004\u0003:L\bBB%\u0003\t\u0003\u0007!*\u0001\u0004bGRLwN\u001c\t\u0004o-k\u0014B\u0001')\u0005!a$-\u001f8b[\u0016t\u0014A\u0004;ssR{Gj\\1e\u00072\f7o]\u000b\u0003\u001f~#\"\u0001\u00153\u0011\u0007]\n6+\u0003\u0002SQ\t1q\n\u001d;j_:\u00042\u0001V._\u001d\t)\u0016\f\u0005\u0002WQ5\tqK\u0003\u0002YU\u00051AH]8pizJ!A\u0017\u0015\u0002\rA\u0013X\rZ3g\u0013\taVLA\u0003DY\u0006\u001c8O\u0003\u0002[QA\u0011ah\u0018\u0003\u0006\u0001\u000e\u0011\r\u0001Y\t\u0003\u0005\u0006\u0004\"a\u000e2\n\u0005\rD#AB!osJ+g\rC\u0003f\u0007\u0001\u0007a-\u0001\u0003qCRD\u0007C\u0001+h\u0013\tAWL\u0001\u0004TiJLgnZ\u0001\u0015iJLHk\\%oSRL\u0017\r\\5{K\u000ec\u0017m]:\u0016\u0005-|GC\u00017q!\r9\u0014+\u001c\t\u0004)ns\u0007C\u0001 p\t\u0015\u0001EA1\u0001a\u0011\u0015)G\u00011\u0001g\u0003!!(/_\"mCN\u001cXCA:x)\r!\b0\u001f\t\u0004oE+\bc\u0001+\\mB\u0011ah\u001e\u0003\u0006\u0001\u0016\u0011\r\u0001\u0019\u0005\u0006K\u0016\u0001\rA\u001a\u0005\u0006u\u0016\u0001\ra_\u0001\u000bS:LG/[1mSj,\u0007CA\u001c}\u0013\ti\bFA\u0004C_>dW-\u00198\u0002\r\r\u0014X-\u0019;f)\r\t\u0017\u0011\u0001\u0005\u0006K\u001a\u0001\rAZ\u000b\u0005\u0003\u000b\ti\u0001\u0006\u0004\u0002\b\u0005\u0015\u0012q\u0005\u000b\u0005\u0003\u0013\tY\u0002\u0006\u0003\u0002\f\u0005=\u0001c\u0001 \u0002\u000e\u0011)\u0001i\u0002b\u0001A\"I\u0011\u0011C\u0004\u0002\u0002\u0003\u000f\u00111C\u0001\u000bKZLG-\u001a8dK\u0012\n\u0004CBA\u000b\u0003/\tY!D\u0001'\u0013\r\tIB\n\u0002\t\u00072\f7o\u001d+bO\"9\u0011QD\u0004A\u0002\u0005}\u0011\u0001B1sON\u0004BaNA\u0011C&\u0019\u00111\u0005\u0015\u0003\u0015q\u0012X\r]3bi\u0016$g\bC\u0003f\u000f\u0001\u0007a\rC\u0004\u0002*\u001d\u0001\r!a\u000b\u0002\u000f\u0015\u0014(o\u001c:G]B)q'!\fgm%\u0019\u0011q\u0006\u0015\u0003\u0013\u0019+hn\u0019;j_:\f\u0014AC2mCN\u001c()\u001f;fgR!\u0011QGA!!\u00159\u0014qGA\u001e\u0013\r\tI\u0004\u000b\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0004o\u0005u\u0012bAA Q\t!!)\u001f;f\u0011\u0019\t\u0019\u0005\u0003a\u0001M\u0006I1\r\\1tg:\u000bW.Z\u0001\u000eG2\f7o]!t'R\u0014X-Y7\u0015\t\u0005%\u0013Q\u000b\t\u0005\u0003\u0017\n\t&\u0004\u0002\u0002N)\u0019\u0011q\n\u0019\u0002\u0005%|\u0017\u0002BA*\u0003\u001b\u00121\"\u00138qkR\u001cFO]3b[\"1\u00111I\u0005A\u0002\u0019\f1A];o)\u00151\u00141LA0\u0011\u0019\tiF\u0003a\u0001M\u0006QqN\u00196fGRt\u0015-\\3\t\u000f\u0005\u0005$\u00021\u0001\u0002d\u0005I\u0011M]4v[\u0016tGo\u001d\t\u0006\u0003K\nYG\u001a\b\u0004o\u0005\u001d\u0014bAA5Q\u00059\u0001/Y2lC\u001e,\u0017\u0002BA7\u0003_\u00121aU3r\u0015\r\tI\u0007K\u0001\u0011'\u000e\fG.Y\"mCN\u001cHj\\1eKJ\u00042!!\u001e\r\u001b\u0005\u00113C\u0001\u0007b\u0003\u0019a\u0014N\\5u}Q\u0011\u00111O\u0001\u0006CB\u0004H.\u001f\u000b\u0005\u0003\u0003\u000b\u0019\tE\u0002\u0002v\u0001Aa!!\"\u000f\u0001\u0004a\u0013AA2m\u00035\u0019wN\u001c;fqRdu.\u00193feV\u0011\u0011\u0011Q\u0001\nCB\u0004Hj\\1eKJ\f!b]3u\u0007>tG/\u001a=u)\r1\u0014\u0011\u0013\u0005\u0007\u0003\u000b\u000b\u0002\u0019\u0001\u0017\u0003\u001dU\u0013Fj\u00117bgNdu.\u00193feN9!#a&\u0002\u0002\u0006\u0005\u0006\u0003BAM\u0003?k!!a'\u000b\u0007\u0005u\u0005'A\u0002oKRLA!a%\u0002\u001cB!\u0011QOAR\u0013\r\t)K\t\u0002\r\u0011\u0006\u001c8\t\\1tgB\u000bG\u000f[\u0001\u0005kJd7\u000f\u0005\u0004\u0002f\u0005-\u00141\u0016\t\u0005\u00033\u000bi+\u0003\u0003\u00020\u0006m%aA+S\u0019\u00061\u0001/\u0019:f]R$b!!.\u0002:\u0006m\u0006cAA\\%5\tA\u0002C\u0004\u0002(V\u0001\r!!+\t\r\u0005EV\u00031\u0001-\u0003=\u0019G.Y:tY>\fG-\u001a:V%2\u001bXCAAU\u0003M\u0019G.Y:tY>\fG-\u001a:V%2\u001bx\fJ3r)\r1\u0014Q\u0019\u0005\n\u0003\u000f<\u0012\u0011!a\u0001\u0003S\u000b1\u0001\u001f\u00132\u0003A\u0019G.Y:tY>\fG-\u001a:V%2\u001b\b%A\u0007dY\u0006\u001c8\u000fU1uQV\u0013Fj]\u0001\u0007C\u0012$WK\u0015'\u0015\u0007Y\n\t\u000eC\u0004\u0002Tj\u0001\r!a+\u0002\u0007U\u0014H.A\u0003dY>\u001cX-\u0001\u0005ge>lWK\u0015't)\u0019\t),a7\u0002^\"9\u0011q\u0015\u000fA\u0002\u0005%\u0006\u0002CAY9A\u0005\t\u0019\u0001\u0017\u0002%\u0019\u0014x.\\+S\u0019N$C-\u001a4bk2$HEM\u000b\u0003\u0003GT3\u0001LAsW\t\t9\u000f\u0005\u0003\u0002j\u0006MXBAAv\u0015\u0011\ti/a<\u0002\u0013Ut7\r[3dW\u0016$'bAAyQ\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\u0005U\u00181\u001e\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017aC2mCN\u001cX\t_5tiN$Ra_A~\u0003{Dq!a*\u001f\u0001\u0004\tI\u000b\u0003\u0004\u0002\u0000z\u0001\rAZ\u0001\u0005]\u0006lW-A\u0007pe&<\u0017N\\(g\u00072\f7o\u001d\u000b\u0005\u0005\u000b\u00119\u0001\u0005\u00038#\u0006-\u0006b\u0002B\u0005?\u0001\u0007!1B\u0001\u0002qB\"!Q\u0002B\t!\u0011!6La\u0004\u0011\u0007y\u0012\t\u0002B\u0006\u0003\u0014\t\u001d\u0011\u0011!A\u0001\u0006\u0003\t%aA0%c\u0005y!m\\8u\u00072\f7o\u001d'pC\u0012,'\u000f")
public interface ScalaClassLoader {
    public static Option<URL> originOfClass(Class<?> clazz) {
        return ScalaClassLoader$.MODULE$.originOfClass(clazz);
    }

    public static boolean classExists(Seq<URL> seq, String string) {
        return ScalaClassLoader$.MODULE$.classExists(seq, string);
    }

    public static ClassLoader fromURLs$default$2() {
        return ScalaClassLoader$.MODULE$.fromURLs$default$2();
    }

    public static URLClassLoader fromURLs(Seq<URL> seq, ClassLoader classLoader) {
        return ScalaClassLoader$.MODULE$.fromURLs(seq, classLoader);
    }

    public static void setContext(ClassLoader classLoader) {
        ScalaClassLoader$.MODULE$.setContext(classLoader);
    }

    public static ScalaClassLoader appLoader() {
        return ScalaClassLoader$.MODULE$.appLoader();
    }

    public static ScalaClassLoader contextLoader() {
        return ScalaClassLoader$.MODULE$.contextLoader();
    }

    public static ScalaClassLoader apply(ClassLoader classLoader) {
        return ScalaClassLoader$.MODULE$.apply(classLoader);
    }

    default public <T> T asContext(Function0<T> action) {
        T t;
        ClassLoader saved = Thread.currentThread().getContextClassLoader();
        try {
            ScalaClassLoader$.MODULE$.setContext((ClassLoader)((Object)this));
            t = action.apply();
        }
        finally {
            ScalaClassLoader$.MODULE$.setContext(saved);
        }
        return t;
    }

    default public <T> Option<Class<T>> tryToLoadClass(String path) {
        return this.tryClass(path, false);
    }

    default public <T> Option<Class<T>> tryToInitializeClass(String path) {
        return this.tryClass(path, true);
    }

    private <T> Option<Class<T>> tryClass(String path, boolean initialize) {
        return Exception$.MODULE$.catching((Seq<Class<?>>)Predef$.MODULE$.wrapRefArray((Object[])new Class[]{ClassNotFoundException.class, SecurityException.class})).opt((Function0<Class> & java.io.Serializable & Serializable)() -> Class.forName(path, initialize, (ClassLoader)((Object)this)));
    }

    /*
     * WARNING - void declaration
     */
    default public Object create(String path) {
        void orNull_ev;
        Option option = this.tryToInitializeClass(path);
        if (option == null) {
            throw null;
        }
        Option map_this = option;
        Option option2 = map_this.isEmpty() ? None$.MODULE$ : new Some<Object>(map_this.get().newInstance());
        Predef$.less.colon.less less2 = Predef$.MODULE$.$conforms();
        if (option2 == null) {
            throw null;
        }
        Object object = option2.isEmpty() ? Option.$anonfun$orNull$1((Predef$.less.colon.less)orNull_ev) : option2.get();
        return object;
    }

    default public <T> T create(String path, Function1<String, BoxedUnit> errorFn, Seq<Object> args2, ClassTag<T> evidence$1) {
        Object t;
        try {
            Constructor[] maybes;
            Class<?> clazz = Class.forName(path, true, (ClassLoader)((Object)this));
            if (package$.MODULE$.classTag(evidence$1).runtimeClass().isAssignableFrom(clazz)) {
                maybes = (Constructor[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])clazz.getConstructors())).filterImpl((Function1<Constructor, Object> & java.io.Serializable & Serializable)c -> BoxesRunTime.boxToBoolean(ScalaClassLoader.$anonfun$create$2(args2, c)), false);
                if (new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])maybes)).size() != 1) {
                    String fail$1_msg = new StringBuilder(37).append("Constructor must accept arg list (").append(((TraversableOnce)args2.map((Function1<Object, String> & java.io.Serializable & Serializable)x$2 -> x$2.getClass().getName(), Seq$.MODULE$.canBuildFrom())).mkString(", ")).append("): ").append(path).toString();
                    IllegalArgumentException fail$1_error$1_e = new IllegalArgumentException(fail$1_msg);
                    errorFn.apply(fail$1_msg);
                    throw fail$1_error$1_e;
                }
            } else {
                String string = new StringBuilder(53).append("Loader for ").append(package$.MODULE$.classTag(evidence$1)).append(":   [").append(ReflectionUtils$.MODULE$.show(package$.MODULE$.classTag(evidence$1).runtimeClass().getClassLoader())).append("]\n                   |Loader for ").append(clazz.getName()).append(": [").append(ReflectionUtils$.MODULE$.show(clazz.getClassLoader())).append("]").toString();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                errorFn.apply(new StringOps(string).stripMargin());
                String fail$1_msg = new StringBuilder(8).append("Not a ").append(package$.MODULE$.classTag(evidence$1)).append(": ").append(path).toString();
                IllegalArgumentException fail$1_error$1_e = new IllegalArgumentException(fail$1_msg);
                errorFn.apply(fail$1_msg);
                throw fail$1_error$1_e;
            }
            t = ((Constructor)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])maybes)).head()).newInstance((Object[])args2.toArray(ClassTag$.MODULE$.AnyRef()));
        }
        catch (Throwable throwable) {
            if (throwable instanceof ClassNotFoundException) {
                ClassNotFoundException classNotFoundException = (ClassNotFoundException)throwable;
                String error$1_msg = new StringBuilder(17).append("Class not found: ").append(path).toString();
                errorFn.apply(error$1_msg);
                throw classNotFoundException;
            }
            boolean bl = throwable instanceof LinkageError ? true : throwable instanceof ReflectiveOperationException;
            if (bl) {
                String error$1_msg = new StringBuilder(29).append("Unable to create instance: ").append(path).append(": ").append(throwable.toString()).toString();
                errorFn.apply(error$1_msg);
                throw throwable;
            }
            throw throwable;
        }
        return t;
    }

    /*
     * WARNING - void declaration
     */
    default public byte[] classBytes(String className) {
        byte[] byArray;
        InputStream inputStream2 = this.classAsStream(className);
        if (inputStream2 == null) {
            byArray = (byte[])Array$.MODULE$.apply(Nil$.MODULE$, ClassTag$.MODULE$.Byte());
        } else {
            void bytes_is;
            Function0<InputStream> & java.io.Serializable & Serializable intersect = (Function0<InputStream> & java.io.Serializable & Serializable)() -> inputStream2;
            if (Streamable$.MODULE$ == null) {
                throw null;
            }
            byArray = new Streamable.Bytes((Function0)bytes_is){
                private final Function0 is$1;

                public long length() {
                    return Streamable.Bytes.length$(this);
                }

                public BufferedInputStream bufferedInput() {
                    return Streamable.Bytes.bufferedInput$(this);
                }

                public Iterator<Object> bytes() {
                    return Streamable.Bytes.bytes$(this);
                }

                public Iterator<Object> bytesAsInts() {
                    return Streamable.Bytes.bytesAsInts$(this);
                }

                public byte[] toByteArray() {
                    return Streamable.Bytes.toByteArray$(this);
                }

                public InputStream inputStream() {
                    return (InputStream)this.is$1.apply();
                }
                {
                    this.is$1 = is$1;
                    Streamable.Bytes.$init$(this);
                }
            }.toByteArray();
        }
        return byArray;
    }

    default public InputStream classAsStream(String className) {
        return ((ClassLoader)((Object)this)).getResourceAsStream(className.endsWith(".class") ? className : new StringBuilder(6).append(className.replace('.', '/')).append(".class").toString());
    }

    default public void run(String objectName, Seq<String> arguments) {
        Option option = this.tryToInitializeClass(objectName);
        if (option == null) {
            throw null;
        }
        Option getOrElse_this = option;
        if (getOrElse_this.isEmpty()) {
            throw ScalaClassLoader.$anonfun$run$1(objectName);
        }
        Method method = getOrElse_this.get().getMethod("main", String[].class);
        if (!Modifier.isStatic(method.getModifiers())) {
            throw new NoSuchMethodException(new StringBuilder(19).append(objectName).append(".main is not static").toString());
        }
        try {
            this.asContext((Function0<Object> & java.io.Serializable & Serializable)() -> method.invoke(null, arguments.toArray(ClassTag$.MODULE$.apply(String.class))));
            return;
        }
        catch (Throwable x$3) {
            PartialFunction<Throwable, Nothing$> catchExpr$1 = ReflectionUtils$.MODULE$.unwrapHandler(new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                    throw x1;
                }

                public final boolean isDefinedAt(Throwable x1) {
                    return true;
                }
            });
            if (catchExpr$1.isDefinedAt(x$3)) {
                catchExpr$1.apply(x$3);
                return;
            }
            throw x$3;
        }
    }

    private static Nothing$ fail$1(String msg, Function1 errorFn$1) {
        IllegalArgumentException error$1_e = new IllegalArgumentException(msg);
        errorFn$1.apply(msg);
        throw error$1_e;
    }

    private static Nothing$ error$1(String msg, Throwable e, Function1 errorFn$1) {
        errorFn$1.apply(msg);
        throw e;
    }

    public static /* synthetic */ boolean $anonfun$create$3(Tuple2 x0$1) {
        if (x0$1 == null) {
            throw new MatchError((Object)null);
        }
        Class k = (Class)x0$1._1();
        Object a = x0$1._2();
        boolean bl = k.isAssignableFrom(a.getClass());
        return bl;
    }

    public static /* synthetic */ boolean $anonfun$create$2(Seq args$1, Constructor c) {
        return c.getParameterCount() == args$1.size() && IndexedSeqOptimized.forall$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])c.getParameterTypes())).zip(args$1, Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(Tuple2.class))))), (Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(ScalaClassLoader.$anonfun$create$3(x0$1)));
    }

    public static /* synthetic */ Nothing$ $anonfun$run$1(String objectName$1) {
        throw new ClassNotFoundException(objectName$1);
    }

    public static void $init$(ScalaClassLoader $this) {
    }

    public static class URLClassLoader
    extends java.net.URLClassLoader
    implements ScalaClassLoader,
    HasClassPath {
        private Seq<URL> classloaderURLs;

        @Override
        public <T> T asContext(Function0<T> action) {
            return (T)((ScalaClassLoader)this).asContext(action);
        }

        @Override
        public <T> Option<Class<T>> tryToLoadClass(String path) {
            return ((ScalaClassLoader)this).tryToLoadClass(path);
        }

        @Override
        public <T> Option<Class<T>> tryToInitializeClass(String path) {
            return ((ScalaClassLoader)this).tryToInitializeClass(path);
        }

        @Override
        public Object create(String path) {
            return ((ScalaClassLoader)this).create(path);
        }

        @Override
        public <T> T create(String path, Function1<String, BoxedUnit> errorFn, Seq<Object> args2, ClassTag<T> evidence$1) {
            return (T)((ScalaClassLoader)this).create(path, errorFn, args2, evidence$1);
        }

        @Override
        public byte[] classBytes(String className) {
            return ((ScalaClassLoader)this).classBytes(className);
        }

        @Override
        public InputStream classAsStream(String className) {
            return ((ScalaClassLoader)this).classAsStream(className);
        }

        @Override
        public void run(String objectName, Seq<String> arguments) {
            ((ScalaClassLoader)this).run(objectName, arguments);
        }

        private Seq<URL> classloaderURLs() {
            return this.classloaderURLs;
        }

        private void classloaderURLs_$eq(Seq<URL> x$1) {
            this.classloaderURLs = x$1;
        }

        @Override
        public Seq<URL> classPathURLs() {
            return this.classloaderURLs();
        }

        @Override
        public void addURL(URL url) {
            this.classloaderURLs_$eq(this.classloaderURLs().$colon$plus(url, Seq$.MODULE$.canBuildFrom()));
            super.addURL(url);
        }

        @Override
        public void close() {
            super.close();
            this.classloaderURLs_$eq(null);
        }

        public URLClassLoader(Seq<URL> urls2, ClassLoader parent) {
            super((URL[])urls2.toArray(ClassTag$.MODULE$.apply(URL.class)), parent);
            ScalaClassLoader.$init$(this);
            this.classloaderURLs = urls2;
        }
    }
}

