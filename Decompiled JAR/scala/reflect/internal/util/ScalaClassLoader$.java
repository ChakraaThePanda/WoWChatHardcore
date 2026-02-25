/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.collection.Seq;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag;
import scala.reflect.internal.util.ScalaClassLoader;
import scala.runtime.BoxedUnit;
import scala.util.Properties$;

public final class ScalaClassLoader$ {
    public static ScalaClassLoader$ MODULE$;
    private final ClassLoader bootClassLoader;

    static {
        new ScalaClassLoader$();
    }

    public ScalaClassLoader apply(ClassLoader cl) {
        ScalaClassLoader scalaClassLoader;
        if (cl instanceof ScalaClassLoader) {
            scalaClassLoader = (ScalaClassLoader)((Object)cl);
        } else if (cl instanceof URLClassLoader) {
            URLClassLoader uRLClassLoader = (URLClassLoader)cl;
            scalaClassLoader = new ScalaClassLoader.URLClassLoader((Seq<URL>)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])uRLClassLoader.getURLs())).toSeq(), uRLClassLoader.getParent());
        } else {
            scalaClassLoader = new ScalaClassLoader(cl){

                public <T> T asContext(Function0<T> action) {
                    return (T)ScalaClassLoader.asContext$(this, action);
                }

                public <T> Option<Class<T>> tryToLoadClass(String path) {
                    return ScalaClassLoader.tryToLoadClass$(this, path);
                }

                public <T> Option<Class<T>> tryToInitializeClass(String path) {
                    return ScalaClassLoader.tryToInitializeClass$(this, path);
                }

                public Object create(String path) {
                    return ScalaClassLoader.create$(this, path);
                }

                public <T> T create(String path, Function1<String, BoxedUnit> errorFn, Seq<Object> args2, ClassTag<T> evidence$1) {
                    return (T)ScalaClassLoader.create$(this, path, errorFn, args2, evidence$1);
                }

                public byte[] classBytes(String className) {
                    return ScalaClassLoader.classBytes$(this, className);
                }

                public InputStream classAsStream(String className) {
                    return ScalaClassLoader.classAsStream$(this, className);
                }

                public void run(String objectName, Seq<String> arguments) {
                    ScalaClassLoader.run$(this, objectName, arguments);
                }
                {
                    ScalaClassLoader.$init$(this);
                }
            };
        }
        return scalaClassLoader;
    }

    public ScalaClassLoader contextLoader() {
        return this.apply(Thread.currentThread().getContextClassLoader());
    }

    public ScalaClassLoader appLoader() {
        return this.apply(ClassLoader.getSystemClassLoader());
    }

    public void setContext(ClassLoader cl) {
        Thread.currentThread().setContextClassLoader(cl);
    }

    public ScalaClassLoader.URLClassLoader fromURLs(Seq<URL> urls2, ClassLoader parent) {
        return new ScalaClassLoader.URLClassLoader(urls2, parent == null ? this.bootClassLoader : parent);
    }

    public ClassLoader fromURLs$default$2() {
        return null;
    }

    public boolean classExists(Seq<URL> urls2, String name) {
        return this.fromURLs(urls2, this.fromURLs$default$2()).tryToLoadClass(name).isDefined();
    }

    public Option<URL> originOfClass(Class<?> x) {
        Option<CodeSource> option = Option$.MODULE$.apply(x.getProtectionDomain().getCodeSource());
        if (option == null) {
            throw null;
        }
        Option<CodeSource> flatMap_this = option;
        Option option2 = flatMap_this.isEmpty() ? None$.MODULE$ : Option$.MODULE$.apply(flatMap_this.get().getLocation());
        return option2;
    }

    private static final /* synthetic */ ClassLoader liftedTree1$1() {
        try {
            return MethodHandles.lookup().findStatic(ClassLoader.class, "getPlatformClassLoader", MethodType.methodType(ClassLoader.class)).invoke();
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private ScalaClassLoader$() {
        MODULE$ = this;
        this.bootClassLoader = !Properties$.MODULE$.isJavaAtLeast("9") ? null : ScalaClassLoader$.liftedTree1$1();
    }
}

