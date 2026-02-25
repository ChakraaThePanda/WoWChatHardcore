/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.StringContext;
import scala.collection.AbstractTraversable;
import scala.collection.IndexedSeqOptimized;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.reflect.internal.util.package;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichChar$;

public final class package$ {
    public static package$ MODULE$;
    private final List<List<Nothing$>> ListOfNil;
    private final Option<List<Nothing$>> SomeOfNil;

    static {
        new package$();
    }

    public List<List<Nothing$>> ListOfNil() {
        return this.ListOfNil;
    }

    public Option<List<Nothing$>> SomeOfNil() {
        return this.SomeOfNil;
    }

    public boolean andFalse(BoxedUnit body) {
        return false;
    }

    private String shortenName(String name) {
        String string = name;
        String string2 = "";
        if (string != null && string.equals(string2)) {
            return "";
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        List<Object> segments = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new StringOps(name).split('$'))).toList();
        String last = (String)segments.last();
        if (last.length() == 0) {
            return ((AbstractTraversable)segments.takeRight(2)).mkString("$");
        }
        return last;
    }

    public String shortClassOfInstance(Object x) {
        return this.shortClass(x.getClass());
    }

    public String shortClass(Class<?> clazz) {
        String string = clazz.getName();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        String name = (String)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new StringOps(string).split('.'))).last();
        if (package$.isModule$1(name)) {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringBuilder(1).append((String)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new StringOps(name).split('$'))).filterImpl((Function1<String, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(package$.$anonfun$shortClass$2(x$3)), true))).last()).append("$").toString();
        }
        if (package$.isAnon$1(name)) {
            Class<?> clazz2 = clazz.getSuperclass();
            return ((TraversableOnce)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])clazz.getInterfaces())).toList().$colon$colon(clazz2).map((Function1<Class, String> & java.io.Serializable & Serializable)c -> MODULE$.shortClass((Class<?>)c), List$.MODULE$.canBuildFrom())).mkString(" with ");
        }
        return this.shortenName(name);
    }

    public package.StringContextStripMarginOps StringContextStripMarginOps(StringContext stringContext) {
        return new package.StringContextStripMarginOps(stringContext);
    }

    private static final boolean isModule$1(String name$1) {
        return name$1.endsWith("$");
    }

    public static final /* synthetic */ boolean $anonfun$shortClass$1(char x$2) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichChar$.MODULE$.isDigit$extension(x$2);
    }

    private static final boolean isAnon$1(String name$1) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        String string = (String)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new StringOps(name$1).split('$'))).last();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return IndexedSeqOptimized.forall$(new StringOps(string), (Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(package$.$anonfun$shortClass$1(BoxesRunTime.unboxToChar(x$2))));
    }

    public static final /* synthetic */ boolean $anonfun$shortClass$2(String x$3) {
        String string = x$3;
        String string2 = "";
        return string != null && string.equals(string2);
    }

    private package$() {
        MODULE$ = this;
        Nil$ nil$ = Nil$.MODULE$;
        this.ListOfNil = Nil$.MODULE$.$colon$colon(nil$);
        this.SomeOfNil = new Some<Nil$>(Nil$.MODULE$);
    }
}

