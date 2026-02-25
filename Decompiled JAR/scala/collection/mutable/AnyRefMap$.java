/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.MatchError;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.AnyRefMap;
import scala.collection.mutable.Iterable;
import scala.math.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.ScalaRunTime$;

public final class AnyRefMap$
implements Serializable {
    public static AnyRefMap$ MODULE$;
    private final AnyRefMap.ExceptionDefault scala$collection$mutable$AnyRefMap$$exceptionDefault;
    private final CanBuildFrom<AnyRefMap<Object, Object>, Tuple2<Object, Object>, AnyRefMap<Object, Object>> ReusableCBFInstance;

    static {
        new AnyRefMap$();
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

    public AnyRefMap.ExceptionDefault scala$collection$mutable$AnyRefMap$$exceptionDefault() {
        return this.scala$collection$mutable$AnyRefMap$$exceptionDefault;
    }

    public <K, V, J, U> CanBuildFrom<AnyRefMap<K, V>, Tuple2<J, U>, AnyRefMap<J, U>> canBuildFrom() {
        return this.ReusableCBFInstance;
    }

    /*
     * WARNING - void declaration
     */
    public <K, V> AnyRefMap<K, V> apply(Seq<Tuple2<K, V>> elems) {
        void var3_3;
        int sz = elems.hasDefiniteSize() ? elems.size() : 4;
        AnyRefMap arm = new AnyRefMap(sz * 2);
        elems.foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> {
            AnyRefMap$.$anonfun$apply$1(arm, x0$1);
            return BoxedUnit.UNIT;
        });
        if (arm.size() < sz >> 3) {
            arm.repack();
        }
        return var3_3;
    }

    public <K, V> AnyRefMap<K, V> empty() {
        return new AnyRefMap();
    }

    public <K, V> AnyRefMap<K, V> withDefault(Function1<K, V> function1) {
        return new AnyRefMap<K, V>(function1);
    }

    public <K, V> AnyRefMap<K, V> fromZip(K[] keys2, Object values2) {
        int sz = package$.MODULE$.min(keys2.length, ScalaRunTime$.MODULE$.array_length(values2));
        AnyRefMap<K, Object> arm = new AnyRefMap<K, Object>(sz * 2);
        for (int i = 0; i < sz; ++i) {
            arm.update(keys2[i], ScalaRunTime$.MODULE$.array_apply(values2, i));
        }
        if (arm.size() < sz >> 3) {
            arm.repack();
        }
        return arm;
    }

    public <K, V> AnyRefMap<K, V> fromZip(Iterable<K> keys2, Iterable<V> values2) {
        int sz = package$.MODULE$.min(keys2.size(), values2.size());
        AnyRefMap arm = new AnyRefMap(sz * 2);
        Iterator ki = keys2.iterator();
        Iterator vi = values2.iterator();
        while (ki.hasNext() && vi.hasNext()) {
            arm.update(ki.next(), vi.next());
        }
        if (arm.size() < sz >> 3) {
            arm.repack();
        }
        return arm;
    }

    private Object readResolve() {
        return MODULE$;
    }

    public static final /* synthetic */ void $anonfun$apply$1(AnyRefMap arm$2, Tuple2 x0$1) {
        if (x0$1 != null) {
            Object k = x0$1._1();
            Object v = x0$1._2();
            arm$2.update(k, v);
            return;
        }
        throw new MatchError((Object)null);
    }

    private AnyRefMap$() {
        MODULE$ = this;
        this.scala$collection$mutable$AnyRefMap$$exceptionDefault = new AnyRefMap.ExceptionDefault();
        this.ReusableCBFInstance = new CanBuildFrom<AnyRefMap<Object, Object>, Tuple2<Object, Object>, AnyRefMap<Object, Object>>(){

            public AnyRefMap.AnyRefMapBuilder<Object, Object> apply(AnyRefMap<Object, Object> from) {
                return this.apply();
            }

            public AnyRefMap.AnyRefMapBuilder<Object, Object> apply() {
                return new AnyRefMap.AnyRefMapBuilder<Object, Object>();
            }
        };
    }
}

