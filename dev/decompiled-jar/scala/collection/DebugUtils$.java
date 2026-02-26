/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.util.NoSuchElementException;
import scala.Array$;
import scala.Function1;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Serializable;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;

public final class DebugUtils$ {
    public static DebugUtils$ MODULE$;

    static {
        new DebugUtils$();
    }

    public Nothing$ unsupported(String msg) {
        throw new UnsupportedOperationException(msg);
    }

    public Nothing$ noSuchElement(String msg) {
        throw new NoSuchElementException(msg);
    }

    public Nothing$ indexOutOfBounds(int index) {
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(index)).toString());
    }

    public Nothing$ illegalArgument(String msg) {
        throw new IllegalArgumentException(msg);
    }

    public String buildString(Function1<Function1<Object, BoxedUnit>, BoxedUnit> closure) {
        ObjectRef<String> output = ObjectRef.create("");
        closure.apply((Function1<Object, BoxedUnit>)(Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> {
            output.elem = new StringBuilder(0).append((String)output.elem).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(x$1), "\n")).toString();
            return BoxedUnit.UNIT;
        });
        return (String)output.elem;
    }

    public <T> String arrayString(Object array, int from, int until) {
        return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])Predef$.MODULE$.genericArrayOps(Predef$.MODULE$.genericArrayOps(array).slice(from, until)).map((Function1<Object, String> & java.io.Serializable & Serializable)x0$1 -> {
            String string = x0$1 == null ? "n/a" : String.valueOf(x0$1);
            return string;
        }, Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(String.class))))).mkString(" | ");
    }

    private DebugUtils$() {
        MODULE$ = this;
    }
}

