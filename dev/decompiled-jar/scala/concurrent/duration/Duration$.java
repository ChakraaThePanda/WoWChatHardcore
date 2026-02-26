/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.duration;

import java.util.concurrent.TimeUnit;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichChar$;
import scala.runtime.RichDouble$;

public final class Duration$
implements Serializable {
    public static Duration$ MODULE$;
    private final List<Tuple2<TimeUnit, String>> timeUnitLabels;
    private final Map<TimeUnit, String> timeUnitName;
    private final Map<String, TimeUnit> timeUnit;
    private final FiniteDuration Zero;
    private final Duration.Infinite Undefined;
    private final Duration.Infinite Inf;
    private final Duration.Infinite MinusInf;

    static {
        new Duration$();
    }

    public Duration apply(double length, TimeUnit unit) {
        return this.fromNanos((double)unit.toNanos(1L) * length);
    }

    public FiniteDuration apply(long length, TimeUnit unit) {
        return new FiniteDuration(length, unit);
    }

    public FiniteDuration apply(long length, String unit) {
        return new FiniteDuration(length, (TimeUnit)((Object)this.timeUnit().apply(unit)));
    }

    /*
     * WARNING - void declaration
     */
    public Duration apply(String s) {
        Duration duration;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        String s1 = (String)new StringOps(s).filterImpl((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(Duration$.$anonfun$apply$1(BoxesRunTime.unboxToChar(x$1))), true);
        boolean bl = "Inf".equals(s1) ? true : ("PlusInf".equals(s1) ? true : "+Inf".equals(s1));
        if (bl) {
            duration = this.Inf();
        } else {
            boolean bl2 = "MinusInf".equals(s1) ? true : "-Inf".equals(s1);
            if (bl2) {
                duration = this.MinusInf();
            } else {
                TimeUnit unit;
                void takeWhile_p;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                String string = (String)new StringOps(s1).reverse();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                Function1<Object, Object> & java.io.Serializable & Serializable intersect = (Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(Duration$.$anonfun$apply$2(BoxesRunTime.unboxToChar(x$2)));
                StringOps takeWhile_this = new StringOps(string);
                String string2 = (String)takeWhile_this.take(takeWhile_this.prefixLength(takeWhile_p));
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                String unitName = (String)new StringOps(string2).reverse();
                Option option = this.timeUnit().get(unitName);
                if (option instanceof Some) {
                    unit = (TimeUnit)((Object)((Some)option).value());
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                } else {
                    throw new NumberFormatException(new StringBuilder(13).append("format error ").append(s).toString());
                }
                String valueStr = (String)new StringOps(s1).dropRight(unitName.length());
                double valueD = Double.parseDouble(valueStr);
                FiniteDuration finiteDuration = valueD >= -9.007199254740992E15 && valueD <= 9.007199254740992E15 ? this.apply(valueD, unit) : this.apply(Long.parseLong(valueStr), unit);
                duration = finiteDuration;
            }
        }
        return duration;
    }

    private List<String> words(String s) {
        return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])s.trim().split("\\s+"))).toList();
    }

    private List<String> expandLabels(String labels) {
        List<String> list = this.words(labels);
        if (!(list instanceof $colon$colon)) {
            throw new MatchError(list);
        }
        $colon$colon $colon$colon = ($colon$colon)list;
        String string = (String)$colon$colon.head();
        List list2 = $colon$colon.tl$access$1();
        String hd = string;
        return list2.flatMap((Function1<String, List> & java.io.Serializable & Serializable)s -> new $colon$colon<Nothing$>((Nothing$)((Object)s), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new StringBuilder(1).append((String)s).append("s").toString()), Nil$.MODULE$)), List$.MODULE$.canBuildFrom()).$colon$colon(hd);
    }

    public Map<TimeUnit, String> timeUnitName() {
        return this.timeUnitName;
    }

    public Map<String, TimeUnit> timeUnit() {
        return this.timeUnit;
    }

    public Option<Tuple2<Object, TimeUnit>> unapply(String s) {
        Option option = this.liftedTree1$1(s);
        if (option == null) {
            throw null;
        }
        Option flatMap_this = option;
        if (flatMap_this.isEmpty()) {
            return None$.MODULE$;
        }
        return Duration$.MODULE$.unapply((Duration)flatMap_this.get());
    }

    public Option<Tuple2<Object, TimeUnit>> unapply(Duration d) {
        if (d.isFinite()) {
            return new Some<Tuple2<Object, TimeUnit>>(new Tuple2<Long, TimeUnit>(BoxesRunTime.boxToLong(d.length()), d.unit()));
        }
        return None$.MODULE$;
    }

    public Duration fromNanos(double nanos) {
        if (Predef$.MODULE$.double2Double(nanos).isInfinite()) {
            if (nanos > 0.0) {
                return this.Inf();
            }
            return this.MinusInf();
        }
        if (Double.isNaN(nanos)) {
            return this.Undefined();
        }
        if (nanos > (double)Long.MAX_VALUE || nanos < (double)Long.MIN_VALUE) {
            throw new IllegalArgumentException(new StringBuilder(46).append("trying to construct too large duration with ").append(nanos).append("ns").toString());
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return this.fromNanos(RichDouble$.MODULE$.round$extension(nanos));
    }

    public FiniteDuration fromNanos(long nanos) {
        if (nanos % 86400000000000L == 0L) {
            return this.apply(nanos / 86400000000000L, TimeUnit.DAYS);
        }
        if (nanos % 3600000000000L == 0L) {
            return this.apply(nanos / 3600000000000L, TimeUnit.HOURS);
        }
        if (nanos % 60000000000L == 0L) {
            return this.apply(nanos / 60000000000L, TimeUnit.MINUTES);
        }
        if (nanos % 1000000000L == 0L) {
            return this.apply(nanos / 1000000000L, TimeUnit.SECONDS);
        }
        if (nanos % 1000000L == 0L) {
            return this.apply(nanos / 1000000L, TimeUnit.MILLISECONDS);
        }
        if (nanos % 1000L == 0L) {
            return this.apply(nanos / 1000L, TimeUnit.MICROSECONDS);
        }
        return this.apply(nanos, TimeUnit.NANOSECONDS);
    }

    public FiniteDuration Zero() {
        return this.Zero;
    }

    public Duration.Infinite Undefined() {
        return this.Undefined;
    }

    public Duration.Infinite Inf() {
        return this.Inf;
    }

    public Duration.Infinite MinusInf() {
        return this.MinusInf;
    }

    public FiniteDuration create(long length, TimeUnit unit) {
        return this.apply(length, unit);
    }

    public Duration create(double length, TimeUnit unit) {
        return this.apply(length, unit);
    }

    public FiniteDuration create(long length, String unit) {
        return this.apply(length, unit);
    }

    public Duration create(String s) {
        return this.apply(s);
    }

    private Object readResolve() {
        return MODULE$;
    }

    public static final /* synthetic */ boolean $anonfun$apply$1(char x$1) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichChar$.MODULE$.isWhitespace$extension(x$1);
    }

    public static final /* synthetic */ boolean $anonfun$apply$2(char x$2) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichChar$.MODULE$.isLetter$extension(x$2);
    }

    private final /* synthetic */ Option liftedTree1$1(String s$1) {
        try {
            return new Some<Duration>(this.apply(s$1));
        }
        catch (RuntimeException runtimeException) {
            return None$.MODULE$;
        }
    }

    /*
     * WARNING - void declaration
     */
    private Duration$() {
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
        MODULE$ = this;
        String string = "d day";
        TimeUnit timeUnit = Predef$.MODULE$.ArrowAssoc(TimeUnit.DAYS);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        String string2 = "h hr hour";
        TimeUnit timeUnit2 = Predef$.MODULE$.ArrowAssoc(TimeUnit.HOURS);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        String string3 = "m min minute";
        TimeUnit timeUnit3 = Predef$.MODULE$.ArrowAssoc(TimeUnit.MINUTES);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        String string4 = "s sec second";
        TimeUnit timeUnit4 = Predef$.MODULE$.ArrowAssoc(TimeUnit.SECONDS);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        String string5 = "ms milli millisecond";
        TimeUnit timeUnit5 = Predef$.MODULE$.ArrowAssoc(TimeUnit.MILLISECONDS);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        String string6 = "\u00b5s micro microsecond";
        TimeUnit timeUnit6 = Predef$.MODULE$.ArrowAssoc(TimeUnit.MICROSECONDS);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        String string7 = "ns nano nanosecond";
        TimeUnit timeUnit7 = Predef$.MODULE$.ArrowAssoc(TimeUnit.NANOSECONDS);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        this.timeUnitLabels = new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this7, $minus$greater$extension_y7)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this6, $minus$greater$extension_y6)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this5, $minus$greater$extension_y5)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this4, $minus$greater$extension_y4)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this3, $minus$greater$extension_y3)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this2, $minus$greater$extension_y2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y)), Nil$.MODULE$)))))));
        this.timeUnitName = this.timeUnitLabels.toMap(Predef$.MODULE$.$conforms()).mapValues((Function1<String, String> & java.io.Serializable & Serializable)s -> MODULE$.words((String)s).last()).toMap(Predef$.MODULE$.$conforms());
        this.timeUnit = ((TraversableOnce)this.timeUnitLabels.flatMap((Function1<Tuple2, List> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            TimeUnit unit = (TimeUnit)((Object)((Object)x0$1._1()));
            String names = (String)x0$1._2();
            List list = MODULE$.expandLabels(names).map((Function1<String, Tuple2> & java.io.Serializable & Serializable)x$5 -> {
                void $minus$greater$extension_$this;
                String string = Predef$.MODULE$.ArrowAssoc(x$5);
                if (Predef$ArrowAssoc$.MODULE$ == null) {
                    throw null;
                }
                return new Tuple2<void, TimeUnit>($minus$greater$extension_$this, unit);
            }, List$.MODULE$.canBuildFrom());
            return list;
        }, List$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
        this.Zero = new FiniteDuration(0L, TimeUnit.DAYS);
        this.Undefined = new Duration.Infinite(){

            public String toString() {
                return "Duration.Undefined";
            }

            public boolean equals(Object other) {
                return false;
            }

            public Duration $plus(Duration other) {
                return this;
            }

            public Duration $minus(Duration other) {
                return this;
            }

            public Duration $times(double factor) {
                return this;
            }

            public Duration $div(double factor) {
                return this;
            }

            public double $div(Duration other) {
                return Double.NaN;
            }

            public int compare(Duration other) {
                if (other == this) {
                    return 0;
                }
                return 1;
            }

            public Duration unary_$minus() {
                return this;
            }

            public double toUnit(TimeUnit unit) {
                return Double.NaN;
            }

            private Object readResolve() {
                return Duration$.MODULE$.Undefined();
            }
        };
        this.Inf = new Duration.Infinite(){

            public String toString() {
                return "Duration.Inf";
            }

            public int compare(Duration other) {
                int n = other == Duration$.MODULE$.Undefined() ? -1 : (other == this ? 0 : 1);
                return n;
            }

            public Duration unary_$minus() {
                return Duration$.MODULE$.MinusInf();
            }

            public double toUnit(TimeUnit unit) {
                return Double.POSITIVE_INFINITY;
            }

            private Object readResolve() {
                return Duration$.MODULE$.Inf();
            }
        };
        this.MinusInf = new Duration.Infinite(){

            public String toString() {
                return "Duration.MinusInf";
            }

            public int compare(Duration other) {
                if (other == this) {
                    return 0;
                }
                return -1;
            }

            public Duration unary_$minus() {
                return Duration$.MODULE$.Inf();
            }

            public double toUnit(TimeUnit unit) {
                return Double.NEGATIVE_INFINITY;
            }

            private Object readResolve() {
                return Duration$.MODULE$.MinusInf();
            }
        };
    }
}

