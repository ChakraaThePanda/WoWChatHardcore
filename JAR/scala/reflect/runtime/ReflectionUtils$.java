/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.lang.invoke.CallSite;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URLClassLoader;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.IndexedSeqOptimized;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.reflect.internal.util.AbstractFileClassLoader;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.NoAbstractFile$;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.StructuralCallSite;
import scala.util.Properties$;

public final class ReflectionUtils$ {
    public static ReflectionUtils$ MODULE$;

    static {
        new ReflectionUtils$();
    }

    public static Method reflMethod$Method1(Class x$1) {
        CallSite methodCache1 = StructuralCallSite.bootstrap("apply", ()Ljava/lang/Object;);
        Method method1 = ((StructuralCallSite)((Object)methodCache1)).find(x$1);
        if (method1 != null) {
            return method1;
        }
        method1 = ScalaRunTime$.MODULE$.ensureAccessible(x$1.getMethod("root", ((StructuralCallSite)((Object)methodCache1)).parameterTypes()));
        ((StructuralCallSite)((Object)methodCache1)).add(x$1, method1);
        return method1;
    }

    public Throwable unwrapThrowable(Throwable x) {
        boolean bl;
        while ((bl = x instanceof InvocationTargetException ? true : (x instanceof ExceptionInInitializerError ? true : (x instanceof UndeclaredThrowableException ? true : (x instanceof ClassNotFoundException ? true : x instanceof NoClassDefFoundError)))) && x.getCause() != null) {
            x = x.getCause();
        }
        return x;
    }

    public <T> PartialFunction<Throwable, T> unwrapHandler(PartialFunction<Throwable, T> pf) {
        return new Serializable(pf){
            public static final long serialVersionUID = 0L;
            private final PartialFunction pf$1;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                Object object = this.pf$1.isDefinedAt(ReflectionUtils$.MODULE$.unwrapThrowable(x1)) ? this.pf$1.apply(ReflectionUtils$.MODULE$.unwrapThrowable(x1)) : function1.apply(x1);
                return object;
            }

            public final boolean isDefinedAt(Throwable x1) {
                boolean bl = this.pf$1.isDefinedAt(ReflectionUtils$.MODULE$.unwrapThrowable(x1));
                return bl;
            }
            {
                this.pf$1 = pf$1;
            }
        };
    }

    public String show(ClassLoader cl) {
        String string;
        if (cl != null) {
            String string2 = "%s of type %s with classpath [%s] and parent being %s";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            string = new StringOps(string2).format(Predef$.MODULE$.genericWrapArray(new Object[]{cl, cl.getClass(), this.inferClasspath$1(cl), this.show(cl.getParent())}));
        } else {
            String string3 = "primordial classloader with boot classpath [%s]";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            string = new StringOps(string3).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.inferClasspath$1(null)}));
        }
        return string;
    }

    public Object staticSingletonInstance(ClassLoader cl, String className) {
        Class<?> clazz = Class.forName(className.endsWith("$") ? className : new StringBuilder(1).append(className).append("$").toString(), true, cl);
        return this.staticSingletonInstance(clazz);
    }

    public Object staticSingletonInstance(Class<?> clazz) {
        return clazz.getField("MODULE$").get(null);
    }

    public Object innerSingletonInstance(Object outer, String className) {
        String accessorName = className.endsWith("$") ? className.substring(0, className.length() - 1) : className;
        Option option = ReflectionUtils$.singletonAccessor$1(outer.getClass(), accessorName);
        if (option == null) {
            throw null;
        }
        Option getOrElse_this = option;
        if (getOrElse_this.isEmpty()) {
            throw ReflectionUtils$.$anonfun$innerSingletonInstance$3(outer, accessorName);
        }
        Method accessor = (Method)getOrElse_this.get();
        accessor.setAccessible(true);
        return accessor.invoke(outer, new Object[0]);
    }

    public AbstractFile associatedFile(Class<?> clazz) {
        return NoAbstractFile$.MODULE$;
    }

    private final boolean isAbstractFileClassLoader$1(Class clazz) {
        while (clazz != null) {
            if (clazz.equals(AbstractFileClassLoader.class)) {
                return true;
            }
            clazz = clazz.getSuperclass();
        }
        return false;
    }

    public static final /* synthetic */ Option $anonfun$show$2(Function1 loadBootCp$1) {
        return (Option)loadBootCp$1.apply("java");
    }

    public static final /* synthetic */ String $anonfun$show$3() {
        return "<unknown>";
    }

    private final String inferClasspath$1(ClassLoader cl) {
        String string;
        if (cl instanceof URLClassLoader) {
            URLClassLoader uRLClassLoader = (URLClassLoader)cl;
            string = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])uRLClassLoader.getURLs())).mkString(",");
        } else if (cl != null && this.isAbstractFileClassLoader$1(cl.getClass())) {
            Object object;
            try {
                object = ReflectionUtils$.reflMethod$Method1(cl.getClass()).invoke(cl, new Object[0]);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw invocationTargetException.getCause();
            }
            string = ((AbstractFile)object).canonicalPath();
        } else if (cl == null) {
            Function1<String, Option> & java.io.Serializable & Serializable loadBootCp = (Function1<String, Option> & java.io.Serializable & Serializable)flavor -> Properties$.MODULE$.propOrNone(new StringBuilder(16).append((String)flavor).append(".boot.class.path").toString());
            Option option = Properties$.MODULE$.propOrNone(new StringBuilder(16).append((String)flavor).append(".boot.class.path").toString());
            if (option == null) {
                throw null;
            }
            Option orElse_this = option;
            Option option2 = orElse_this.isEmpty() ? ReflectionUtils$.$anonfun$show$2(loadBootCp) : orElse_this;
            if (option2 == null) {
                throw null;
            }
            String string2 = option2.isEmpty() ? ReflectionUtils$.$anonfun$show$3() : option2.get();
            string = string2;
        } else {
            string = "<unknown>";
        }
        return string;
    }

    public static final /* synthetic */ boolean $anonfun$innerSingletonInstance$1(String accessorName$1, Method x$1) {
        String string = x$1.getName();
        return !(string != null ? !string.equals(accessorName$1) : accessorName$1 != null);
    }

    private static final Option singletonAccessor$1(Class clazz, String accessorName$1) {
        if (clazz == null) {
            return None$.MODULE$;
        }
        Function1<Method, Object> & java.io.Serializable & Serializable find_p = (Function1<Method, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(ReflectionUtils$.$anonfun$innerSingletonInstance$1(accessorName$1, x$1));
        ArrayOps.ofRef<Object> find_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])clazz.getDeclaredMethods()));
        int find_i = find_this.prefixLength(arg_0 -> IndexedSeqOptimized.$anonfun$find$1$adapted(find_p, arg_0));
        Option option = find_i < find_this.length() ? new Some(find_this.apply(find_i)) : None$.MODULE$;
        if (option == null) {
            throw null;
        }
        Option option2 = ((Option)option).isEmpty() ? ReflectionUtils$.singletonAccessor$1(clazz.getSuperclass(), accessorName$1) : option;
        return option2;
    }

    public static final /* synthetic */ Nothing$ $anonfun$innerSingletonInstance$3(Object outer$1, String accessorName$1) {
        throw new NoSuchMethodException(new StringBuilder(1).append(outer$1.getClass().getName()).append(".").append(accessorName$1).toString());
    }

    private ReflectionUtils$() {
        MODULE$ = this;
    }
}

