/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import java.util.Comparator;
import scala.Function1;
import scala.Function2;
import scala.Predef$;
import scala.Serializable;
import scala.math.Equiv;
import scala.math.LowPriorityEquiv;
import scala.runtime.BoxesRunTime;

public final class Equiv$
implements LowPriorityEquiv,
Serializable {
    public static Equiv$ MODULE$;

    static {
        new Equiv$();
    }

    @Override
    public <T> Equiv<T> universalEquiv() {
        return LowPriorityEquiv.universalEquiv$(this);
    }

    public <T> Equiv<T> reference() {
        return new Equiv<T>(){

            public boolean equiv(T x, T y) {
                return x == y;
            }
        };
    }

    public <T> Equiv<T> universal() {
        return new Equiv<T>(){

            public boolean equiv(T x, T y) {
                return BoxesRunTime.equals(x, y);
            }
        };
    }

    public <T> Equiv<T> fromComparator(Comparator<T> cmp) {
        return new Equiv<T>(cmp){
            private final Comparator cmp$1;

            public boolean equiv(T x, T y) {
                return this.cmp$1.compare(x, y) == 0;
            }
            {
                this.cmp$1 = cmp$1;
            }
        };
    }

    public <T> Equiv<T> fromFunction(Function2<T, T, Object> cmp) {
        return new Equiv<T>(cmp){
            private final Function2 cmp$2;

            public boolean equiv(T x, T y) {
                return BoxesRunTime.unboxToBoolean(this.cmp$2.apply(x, y));
            }
            {
                this.cmp$2 = cmp$2;
            }
        };
    }

    public <T, S> Equiv<T> by(Function1<T, S> f, Equiv<S> evidence$1) {
        Function2<Object, Object, Object> & java.io.Serializable & Serializable fromFunction_cmp = (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return BoxesRunTime.boxToBoolean(evidence$1.equiv(f.apply(x), f.apply(y)));
        };
        return new /* invalid duplicate definition of identical inner class */;
    }

    public <T> Equiv<T> apply(Equiv<T> evidence$2) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return evidence$2;
    }

    private Object readResolve() {
        return MODULE$;
    }

    public static final /* synthetic */ boolean $anonfun$by$1(Equiv evidence$1$1, Function1 f$1, Object x, Object y) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return evidence$1$1.equiv(f$1.apply(x), f$1.apply(y));
    }

    private Equiv$() {
        MODULE$ = this;
        LowPriorityEquiv.$init$(this);
    }
}

