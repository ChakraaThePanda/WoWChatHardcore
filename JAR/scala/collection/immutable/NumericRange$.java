/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.immutable.NumericRange;
import scala.collection.immutable.Range$;
import scala.math.Integral;
import scala.math.Numeric;
import scala.math.Numeric$BigDecimalAsIfIntegral$;
import scala.math.Numeric$BigIntIsIntegral$;
import scala.math.Numeric$ByteIsIntegral$;
import scala.math.Numeric$CharIsIntegral$;
import scala.math.Numeric$DoubleAsIfIntegral$;
import scala.math.Numeric$FloatAsIfIntegral$;
import scala.math.Numeric$IntIsIntegral$;
import scala.math.Numeric$LongIsIntegral$;
import scala.math.Numeric$ShortIsIntegral$;
import scala.math.Ordering;
import scala.math.Ordering$BigDecimal$;
import scala.math.Ordering$BigInt$;
import scala.math.Ordering$Byte$;
import scala.math.Ordering$Char$;
import scala.math.Ordering$Double$;
import scala.math.Ordering$Float$;
import scala.math.Ordering$Int$;
import scala.math.Ordering$Long$;
import scala.math.Ordering$Short$;
import scala.runtime.BoxesRunTime;

public final class NumericRange$
implements Serializable {
    public static NumericRange$ MODULE$;
    private final Map<Numeric<?>, Ordering<?>> defaultOrdering;

    static {
        new NumericRange$();
    }

    public <T> int count(T start, T end, T step, boolean isInclusive, Integral<T> num) {
        Object object;
        int endside;
        int stepint;
        int endint;
        Object zero = num.zero();
        boolean upward = num.lt(start, end);
        boolean posStep = num.gt(step, zero);
        if (BoxesRunTime.equals(step, zero)) {
            throw new IllegalArgumentException("step cannot be 0.");
        }
        if (BoxesRunTime.equals(start, end)) {
            if (isInclusive) {
                return 1;
            }
            return 0;
        }
        if (upward != posStep) {
            return 0;
        }
        int startint = num.toInt(start);
        if (BoxesRunTime.equals(start, num.fromInt(startint)) && BoxesRunTime.equals(end, num.fromInt(endint = num.toInt(end))) && BoxesRunTime.equals(step, num.fromInt(stepint = num.toInt(step)))) {
            if (isInclusive) {
                return Range$.MODULE$.inclusive(startint, endint, stepint).length();
            }
            return Range$.MODULE$.apply(startint, endint, stepint).length();
        }
        Object one = num.one();
        Object limit = num.fromInt(Integer.MAX_VALUE);
        int startside = num.signum(start);
        if (startside * (endside = num.signum(end)) >= 0) {
            T diff = num.minus(end, start);
            Object quotient = NumericRange$.check$1(num.quot(diff, step), num, limit);
            Object remainder = num.minus(diff, num.times(quotient, step));
            object = !isInclusive && BoxesRunTime.equals(zero, remainder) ? quotient : NumericRange$.check$1(num.plus(quotient, one), num, limit);
        } else {
            Object object2;
            Object negone = num.fromInt(-1);
            Object startlim = posStep ? negone : one;
            Object startdiff = num.minus(startlim, start);
            Object startq = NumericRange$.check$1(num.quot(startdiff, step), num, limit);
            Object waypointA = BoxesRunTime.equals(startq, zero) ? start : num.plus(start, num.times(startq, step));
            T waypointB = num.plus(waypointA, step);
            if (num.lt(waypointB, end) != upward) {
                object2 = isInclusive && BoxesRunTime.equals(waypointB, end) ? num.plus(startq, num.fromInt(2)) : num.plus(startq, one);
            } else {
                T enddiff = num.minus(end, waypointB);
                Object endq = NumericRange$.check$1(num.quot(enddiff, step), num, limit);
                T last = BoxesRunTime.equals(endq, zero) ? waypointB : num.plus(waypointB, num.times(endq, step));
                object2 = num.plus(startq, num.plus(endq, !isInclusive && BoxesRunTime.equals(last, end) ? one : num.fromInt(2)));
            }
            object = NumericRange$.check$1(object2, num, limit);
        }
        return num.toInt(object);
    }

    public <T> NumericRange.Exclusive<T> apply(T start, T end, T step, Integral<T> num) {
        return new NumericRange.Exclusive<T>(start, end, step, num);
    }

    public <T> NumericRange.Inclusive<T> inclusive(T start, T end, T step, Integral<T> num) {
        return new NumericRange.Inclusive<T>(start, end, step, num);
    }

    public Map<Numeric<?>, Ordering<?>> defaultOrdering() {
        return this.defaultOrdering;
    }

    private Object readResolve() {
        return MODULE$;
    }

    private static final Object check$1(Object t, Integral num$1, Object limit$1) {
        if (num$1.gt(t, limit$1)) {
            throw new IllegalArgumentException("More than Int.MaxValue elements.");
        }
        return t;
    }

    /*
     * WARNING - void declaration
     */
    private NumericRange$() {
        void $minus$greater$extension_y;
        void $minus$greater$extension_$this;
        void $minus$greater$extension_y2;
        void $minus$greater$extension_$this2;
        void $minus$greater$extension_y3;
        void $minus$greater$extension_$this3;
        void $minus$greater$extension_y4;
        void $minus$greater$extension_$this4;
        void $minus$greater$extension_y5;
        void $minus$greater$extension_$this5;
        void $minus$greater$extension_y6;
        void $minus$greater$extension_$this6;
        void $minus$greater$extension_y7;
        void $minus$greater$extension_$this7;
        void $minus$greater$extension_y8;
        void $minus$greater$extension_$this8;
        void $minus$greater$extension_y9;
        void $minus$greater$extension_$this9;
        MODULE$ = this;
        Tuple2[] tuple2Array = new Tuple2[9];
        Ordering$BigInt$ ordering$BigInt$ = Ordering$BigInt$.MODULE$;
        Numeric$BigIntIsIntegral$ numeric$BigIntIsIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$BigIntIsIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[0] = new Tuple2<void, void>($minus$greater$extension_$this9, $minus$greater$extension_y9);
        Ordering$Int$ ordering$Int$ = Ordering$Int$.MODULE$;
        Numeric$IntIsIntegral$ numeric$IntIsIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$IntIsIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[1] = new Tuple2<void, void>($minus$greater$extension_$this8, $minus$greater$extension_y8);
        Ordering$Short$ ordering$Short$ = Ordering$Short$.MODULE$;
        Numeric$ShortIsIntegral$ numeric$ShortIsIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$ShortIsIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[2] = new Tuple2<void, void>($minus$greater$extension_$this7, $minus$greater$extension_y7);
        Ordering$Byte$ ordering$Byte$ = Ordering$Byte$.MODULE$;
        Numeric$ByteIsIntegral$ numeric$ByteIsIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$ByteIsIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[3] = new Tuple2<void, void>($minus$greater$extension_$this6, $minus$greater$extension_y6);
        Ordering$Char$ ordering$Char$ = Ordering$Char$.MODULE$;
        Numeric$CharIsIntegral$ numeric$CharIsIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$CharIsIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[4] = new Tuple2<void, void>($minus$greater$extension_$this5, $minus$greater$extension_y5);
        Ordering$Long$ ordering$Long$ = Ordering$Long$.MODULE$;
        Numeric$LongIsIntegral$ numeric$LongIsIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$LongIsIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[5] = new Tuple2<void, void>($minus$greater$extension_$this4, $minus$greater$extension_y4);
        Ordering$Float$ ordering$Float$ = Ordering$Float$.MODULE$;
        Numeric$FloatAsIfIntegral$ numeric$FloatAsIfIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$FloatAsIfIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[6] = new Tuple2<void, void>($minus$greater$extension_$this3, $minus$greater$extension_y3);
        Ordering$Double$ ordering$Double$ = Ordering$Double$.MODULE$;
        Numeric$DoubleAsIfIntegral$ numeric$DoubleAsIfIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$DoubleAsIfIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[7] = new Tuple2<void, void>($minus$greater$extension_$this2, $minus$greater$extension_y2);
        Ordering$BigDecimal$ ordering$BigDecimal$ = Ordering$BigDecimal$.MODULE$;
        Numeric$BigDecimalAsIfIntegral$ numeric$BigDecimalAsIfIntegral$ = Predef$.MODULE$.ArrowAssoc(Numeric$BigDecimalAsIfIntegral$.MODULE$);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[8] = new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y);
        this.defaultOrdering = (Map)Map$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array));
    }
}

