/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.NoSuchElementException;
import scala.Function1;
import scala.MatchError;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.LongMap;
import scala.math.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;

public final class LongMap$
implements Serializable {
    public static LongMap$ MODULE$;
    private final Function1<Object, Nothing$> scala$collection$mutable$LongMap$$exceptionDefault;
    private final CanBuildFrom<LongMap<Object>, Tuple2<Object, Object>, LongMap<Object>> ReusableCBF;

    static {
        new LongMap$();
    }

    private final int IndexMask() {
        return 0x3FFFFFFF;
    }

    private final int MissingBit() {
        return Integer.MIN_VALUE;
    }

    private final int VacantBit() {
        return 0x40000000;
    }

    private final int MissVacant() {
        return -1073741824;
    }

    public Function1<Object, Nothing$> scala$collection$mutable$LongMap$$exceptionDefault() {
        return this.scala$collection$mutable$LongMap$$exceptionDefault;
    }

    public <V, U> CanBuildFrom<LongMap<V>, Tuple2<Object, U>, LongMap<U>> canBuildFrom() {
        return this.ReusableCBF;
    }

    /*
     * WARNING - void declaration
     */
    public <V> LongMap<V> apply(Seq<Tuple2<Object, V>> elems) {
        void var3_3;
        int sz = elems.hasDefiniteSize() ? elems.size() : 4;
        LongMap lm = new LongMap(sz * 2);
        elems.foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> {
            LongMap$.$anonfun$apply$1(lm, x0$1);
            return BoxedUnit.UNIT;
        });
        if (lm.size() < sz >> 3) {
            lm.repack();
        }
        return var3_3;
    }

    public <V> LongMap<V> empty() {
        return new LongMap();
    }

    public <V> LongMap<V> withDefault(Function1<Object, V> function1) {
        return new LongMap<V>(function1);
    }

    public <V> LongMap<V> fromZip(long[] keys2, Object values2) {
        int sz = package$.MODULE$.min(keys2.length, ScalaRunTime$.MODULE$.array_length(values2));
        LongMap<Object> lm = new LongMap<Object>(sz * 2);
        for (int i = 0; i < sz; ++i) {
            lm.update(keys2[i], ScalaRunTime$.MODULE$.array_apply(values2, i));
        }
        if (lm.size() < sz >> 3) {
            lm.repack();
        }
        return lm;
    }

    public <V> LongMap<V> fromZip(Iterable<Object> keys2, Iterable<V> values2) {
        int sz = package$.MODULE$.min(keys2.size(), values2.size());
        LongMap lm = new LongMap(sz * 2);
        Iterator ki = keys2.iterator();
        Iterator vi = values2.iterator();
        while (ki.hasNext() && vi.hasNext()) {
            lm.update(BoxesRunTime.unboxToLong(ki.next()), vi.next());
        }
        if (lm.size() < sz >> 3) {
            lm.repack();
        }
        return lm;
    }

    private Object readResolve() {
        return MODULE$;
    }

    public static final /* synthetic */ Nothing$ $anonfun$exceptionDefault$1(long k) {
        throw new NoSuchElementException(((Object)BoxesRunTime.boxToLong(k)).toString());
    }

    public static final /* synthetic */ void $anonfun$apply$1(LongMap lm$2, Tuple2 x0$1) {
        if (x0$1 != null) {
            long k = x0$1._1$mcJ$sp();
            Object v = x0$1._2();
            lm$2.update(k, v);
            return;
        }
        throw new MatchError((Object)null);
    }

    private LongMap$() {
        MODULE$ = this;
        this.scala$collection$mutable$LongMap$$exceptionDefault = (Function1<Object, Nothing$> & java.io.Serializable & Serializable)k -> LongMap$.$anonfun$exceptionDefault$1(BoxesRunTime.unboxToLong(k));
        this.ReusableCBF = new CanBuildFrom<LongMap<Object>, Tuple2<Object, Object>, LongMap<Object>>(){

            public LongMap.LongMapBuilder<Object> apply(LongMap<Object> from) {
                return this.apply();
            }

            public LongMap.LongMapBuilder<Object> apply() {
                return new LongMap.LongMapBuilder<Object>();
            }
        };
    }
}

