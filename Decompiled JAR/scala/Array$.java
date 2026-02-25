/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.FallbackArrayBuilding;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.IndexedSeq;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.Range;
import scala.collection.immutable.Range$;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.ArrayBuilder$;
import scala.math.Numeric$IntIsIntegral$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.java8.JFunction1$mcVD$sp;
import scala.runtime.java8.JFunction1$mcVF$sp;
import scala.runtime.java8.JFunction1$mcVI$sp;
import scala.runtime.java8.JFunction1$mcVJ$sp;

public final class Array$
extends FallbackArrayBuilding
implements Serializable {
    public static Array$ MODULE$;
    private final boolean[] emptyBooleanArray;
    private final byte[] emptyByteArray;
    private final char[] emptyCharArray;
    private final double[] emptyDoubleArray;
    private final float[] emptyFloatArray;
    private final int[] emptyIntArray;
    private final long[] emptyLongArray;
    private final short[] emptyShortArray;
    private final Object[] emptyObjectArray;
    private final Class<Object> ObjectClass;
    private final CanBuildFrom<Object, Object, boolean[]> cbfBooleanArray;
    private final CanBuildFrom<Object, Object, byte[]> cbfByteArray;
    private final CanBuildFrom<Object, Object, char[]> cbfCharArray;
    private final CanBuildFrom<Object, Object, double[]> cbfDoubleArray;
    private final CanBuildFrom<Object, Object, float[]> cbfFloatArray;
    private final CanBuildFrom<Object, Object, int[]> cbfIntArray;
    private final CanBuildFrom<Object, Object, long[]> cbfLongArray;
    private final CanBuildFrom<Object, Object, short[]> cbfShortArray;
    private final CanBuildFrom<Object, BoxedUnit, BoxedUnit[]> cbfUnitArray;
    private final CanBuildFrom<Object, Object, Object[]> cbfObjectArray;

    static {
        new Array$();
    }

    public boolean[] emptyBooleanArray() {
        return this.emptyBooleanArray;
    }

    public byte[] emptyByteArray() {
        return this.emptyByteArray;
    }

    public char[] emptyCharArray() {
        return this.emptyCharArray;
    }

    public double[] emptyDoubleArray() {
        return this.emptyDoubleArray;
    }

    public float[] emptyFloatArray() {
        return this.emptyFloatArray;
    }

    public int[] emptyIntArray() {
        return this.emptyIntArray;
    }

    public long[] emptyLongArray() {
        return this.emptyLongArray;
    }

    public short[] emptyShortArray() {
        return this.emptyShortArray;
    }

    public Object[] emptyObjectArray() {
        return this.emptyObjectArray;
    }

    public <T> CanBuildFrom<Object, T, Object> canBuildFrom(ClassTag<T> tag) {
        Class<?> cls = tag.runtimeClass();
        if (cls.isPrimitive()) {
            CanBuildFrom<Object, Object, Object[]> canBuildFrom;
            Class<Integer> clazz = Integer.TYPE;
            if (clazz != null && clazz.equals(cls)) {
                canBuildFrom = this.cbfIntArray;
            } else {
                Class<Double> clazz2 = Double.TYPE;
                if (clazz2 != null && clazz2.equals(cls)) {
                    canBuildFrom = this.cbfDoubleArray;
                } else {
                    Class<Long> clazz3 = Long.TYPE;
                    if (clazz3 != null && clazz3.equals(cls)) {
                        canBuildFrom = this.cbfLongArray;
                    } else {
                        Class<Float> clazz4 = Float.TYPE;
                        if (clazz4 != null && clazz4.equals(cls)) {
                            canBuildFrom = this.cbfFloatArray;
                        } else {
                            Class<Character> clazz5 = Character.TYPE;
                            if (clazz5 != null && clazz5.equals(cls)) {
                                canBuildFrom = this.cbfCharArray;
                            } else {
                                Class<Byte> clazz6 = Byte.TYPE;
                                if (clazz6 != null && clazz6.equals(cls)) {
                                    canBuildFrom = this.cbfByteArray;
                                } else {
                                    Class<Short> clazz7 = Short.TYPE;
                                    if (clazz7 != null && clazz7.equals(cls)) {
                                        canBuildFrom = this.cbfShortArray;
                                    } else {
                                        Class<Boolean> clazz8 = Boolean.TYPE;
                                        if (clazz8 != null && clazz8.equals(cls)) {
                                            canBuildFrom = this.cbfBooleanArray;
                                        } else {
                                            Class<Void> clazz9 = Void.TYPE;
                                            if (clazz9 != null && clazz9.equals(cls)) {
                                                canBuildFrom = this.cbfUnitArray;
                                            } else {
                                                throw new MatchError(cls);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return canBuildFrom;
        }
        if (cls.equals(this.ObjectClass)) {
            return this.cbfObjectArray;
        }
        return this.refCBF(tag);
    }

    private <T> CanBuildFrom<Object, T, T[]> refCBF(ClassTag<T> t) {
        return new CanBuildFrom<Object, T, T[]>(t){
            private final ClassTag t$1;

            public ArrayBuilder.ofRef<T> apply(Object from) {
                return new ArrayBuilder.ofRef<T>(this.t$1);
            }

            public ArrayBuilder.ofRef<T> apply() {
                return new ArrayBuilder.ofRef<T>(this.t$1);
            }
            {
                this.t$1 = t$1;
            }
        };
    }

    public <T> ArrayBuilder<T> newBuilder(ClassTag<T> t) {
        return ArrayBuilder$.MODULE$.make(t);
    }

    private void slowcopy(Object src, int srcPos, Object dest, int destPos, int length) {
        int i = srcPos;
        int j = destPos;
        int srcUntil = srcPos + length;
        while (i < srcUntil) {
            ScalaRunTime$.MODULE$.array_update(dest, j, ScalaRunTime$.MODULE$.array_apply(src, i));
            ++i;
            ++j;
        }
    }

    public void copy(Object src, int srcPos, Object dest, int destPos, int length) {
        Class<?> srcClass = src.getClass();
        if (srcClass.isArray() && dest.getClass().isAssignableFrom(srcClass)) {
            System.arraycopy(src, srcPos, dest, destPos, length);
            return;
        }
        this.slowcopy(src, srcPos, dest, destPos, length);
    }

    public <T> Object empty(ClassTag<T> evidence$1) {
        return evidence$1.newArray(0);
    }

    /*
     * WARNING - void declaration
     */
    public <T> Object apply(Seq<T> xs, ClassTag<T> evidence$2) {
        void var3_3;
        Object array = evidence$2.newArray(xs.length());
        IntRef i = IntRef.create(0);
        xs.iterator().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            Array$.$anonfun$apply$1(array, i, x);
            return BoxedUnit.UNIT;
        });
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    public boolean[] apply(boolean x2, Seq<Object> xs) {
        void var3_3;
        boolean[] array = new boolean[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            Array$.$anonfun$apply$2(array, i, BoxesRunTime.unboxToBoolean(x));
            return BoxedUnit.UNIT;
        });
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    public byte[] apply(byte x2, Seq<Object> xs) {
        void var3_3;
        byte[] array = new byte[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            Array$.$anonfun$apply$3(array, i, BoxesRunTime.unboxToByte(x));
            return BoxedUnit.UNIT;
        });
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    public short[] apply(short x2, Seq<Object> xs) {
        void var3_3;
        short[] array = new short[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            Array$.$anonfun$apply$4(array, i, BoxesRunTime.unboxToShort(x));
            return BoxedUnit.UNIT;
        });
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    public char[] apply(char x2, Seq<Object> xs) {
        void var3_3;
        char[] array = new char[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            Array$.$anonfun$apply$5(array, i, BoxesRunTime.unboxToChar(x));
            return BoxedUnit.UNIT;
        });
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    public int[] apply(int x2, Seq<Object> xs) {
        void var3_3;
        int[] array = new int[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((JFunction1$mcVI$sp & Serializable)x -> {
            array$6[i$6.elem] = x;
            ++i$6.elem;
        });
        return var3_3;
    }

    public long[] apply(long x2, Seq<Object> xs) {
        long[] array = new long[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((JFunction1$mcVJ$sp & Serializable)x -> {
            array$7[i$7.elem] = x;
            ++i$7.elem;
        });
        return array;
    }

    /*
     * WARNING - void declaration
     */
    public float[] apply(float x2, Seq<Object> xs) {
        void var3_3;
        float[] array = new float[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((JFunction1$mcVF$sp & Serializable)x -> {
            array$8[i$8.elem] = x;
            ++i$8.elem;
        });
        return var3_3;
    }

    public double[] apply(double x2, Seq<Object> xs) {
        double[] array = new double[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((JFunction1$mcVD$sp & Serializable)x -> {
            array$9[i$9.elem] = x;
            ++i$9.elem;
        });
        return array;
    }

    /*
     * WARNING - void declaration
     */
    public BoxedUnit[] apply(BoxedUnit x2, Seq<BoxedUnit> xs) {
        void var3_3;
        BoxedUnit[] array = new BoxedUnit[xs.length() + 1];
        array[0] = x2;
        IntRef i = IntRef.create(1);
        xs.iterator().foreach((Function1<BoxedUnit, Object> & java.io.Serializable & Serializable)x -> {
            Array$.$anonfun$apply$10(array, i, x);
            return BoxedUnit.UNIT;
        });
        return var3_3;
    }

    public <T> Object ofDim(int n1, ClassTag<T> evidence$3) {
        return evidence$3.newArray(n1);
    }

    public <T> Object[] ofDim(int n1, int n2, ClassTag<T> evidence$4) {
        Object[] arr = (Object[])ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$4.runtimeClass())).newArray(n1);
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, n1);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                arr[foreach$mVc$sp_i] = evidence$4.newArray(n2);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        return arr;
    }

    public <T> Object[][] ofDim(int n1, int n2, int n3, ClassTag<T> evidence$5) {
        return (Object[][])this.tabulate(n1, (Function1<Object, Object[]> & java.io.Serializable & Serializable)x$1 -> Array$.MODULE$.ofDim(n2, n3, evidence$5), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$5.runtimeClass()))));
    }

    public <T> Object[][][] ofDim(int n1, int n2, int n3, int n4, ClassTag<T> evidence$6) {
        return (Object[][][])this.tabulate(n1, (Function1<Object, Object[][]> & java.io.Serializable & Serializable)x$2 -> Array$.MODULE$.ofDim(n2, n3, n4, evidence$6), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$6.runtimeClass())))));
    }

    public <T> Object[][][][] ofDim(int n1, int n2, int n3, int n4, int n5, ClassTag<T> evidence$7) {
        return (Object[][][][])this.tabulate(n1, (Function1<Object, Object[][][]> & java.io.Serializable & Serializable)x$3 -> Array$.MODULE$.ofDim(n2, n3, n4, n5, evidence$7), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$7.runtimeClass()))))));
    }

    public <T> Object concat(Seq<Object> xss, ClassTag<T> evidence$8) {
        ArrayBuilder b = this.newBuilder(evidence$8);
        b.sizeHint(BoxesRunTime.unboxToInt(((TraversableOnce)xss.map((Function1<Object, Object> & java.io.Serializable & Serializable)x$4 -> BoxesRunTime.boxToInteger(ScalaRunTime$.MODULE$.array_length(x$4)), Seq$.MODULE$.canBuildFrom())).sum(Numeric$IntIsIntegral$.MODULE$)));
        xss.foreach((Function1<Object, ArrayBuilder> & java.io.Serializable & Serializable)xs -> (ArrayBuilder)b.$plus$plus$eq(Predef$.MODULE$.genericArrayOps(xs)));
        return b.result();
    }

    public <T> Object fill(int n, Function0<T> elem, ClassTag<T> evidence$9) {
        ArrayBuilder<T> b = this.newBuilder(evidence$9);
        b.sizeHint(n);
        for (int i = 0; i < n; ++i) {
            b.$plus$eq(elem.apply());
        }
        return b.result();
    }

    public <T> Object[] fill(int n1, int n2, Function0<T> elem, ClassTag<T> evidence$10) {
        return (Object[])this.tabulate(n1, (Function1<Object, Object> & java.io.Serializable & Serializable)x$5 -> {
            Array$ array$ = MODULE$;
            if (array$ == null) {
                throw null;
            }
            ArrayBuilder $anonfun$fill$1_fill_b = array$.newBuilder(evidence$13);
            $anonfun$fill$1_fill_b.sizeHint(n5);
            for (int $anonfun$fill$1_fill_i = 0; $anonfun$fill$1_fill_i < n5; ++$anonfun$fill$1_fill_i) {
                $anonfun$fill$1_fill_b.$plus$eq(elem.apply());
            }
            return $anonfun$fill$1_fill_b.result();
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$10.runtimeClass())));
    }

    public <T> Object[][] fill(int n1, int n2, int n3, Function0<T> elem, ClassTag<T> evidence$11) {
        return (Object[][])this.tabulate(n1, (Function1<Object, Object[]> & java.io.Serializable & Serializable)x$6 -> {
            Array$ array$ = MODULE$;
            if (array$ == null) {
                throw null;
            }
            return (Object[])array$.tabulate(n4, (Function1<Object, Object> & java.io.Serializable & Serializable)x$5 -> {
                Array$ array$ = MODULE$;
                if (array$ == null) {
                    throw null;
                }
                ArrayBuilder $anonfun$fill$1_fill_b = array$.newBuilder(evidence$13);
                $anonfun$fill$1_fill_b.sizeHint(n5);
                for (int $anonfun$fill$1_fill_i = 0; $anonfun$fill$1_fill_i < n5; ++$anonfun$fill$1_fill_i) {
                    $anonfun$fill$1_fill_b.$plus$eq(elem.apply());
                }
                return $anonfun$fill$1_fill_b.result();
            }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass())));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$11.runtimeClass()))));
    }

    public <T> Object[][][] fill(int n1, int n2, int n3, int n4, Function0<T> elem, ClassTag<T> evidence$12) {
        return (Object[][][])this.tabulate(n1, (Function1<Object, Object[][]> & java.io.Serializable & Serializable)x$7 -> {
            Array$ array$ = MODULE$;
            if (array$ == null) {
                throw null;
            }
            return (Object[][])array$.tabulate(n3, (Function1<Object, Object[]> & java.io.Serializable & Serializable)x$6 -> {
                Array$ array$ = MODULE$;
                if (array$ == null) {
                    throw null;
                }
                return (Object[])array$.tabulate(n4, (Function1<Object, Object> & java.io.Serializable & Serializable)x$5 -> {
                    Array$ array$ = MODULE$;
                    if (array$ == null) {
                        throw null;
                    }
                    ArrayBuilder $anonfun$fill$1_fill_b = array$.newBuilder(evidence$13);
                    $anonfun$fill$1_fill_b.sizeHint(n5);
                    for (int $anonfun$fill$1_fill_i = 0; $anonfun$fill$1_fill_i < n5; ++$anonfun$fill$1_fill_i) {
                        $anonfun$fill$1_fill_b.$plus$eq(elem.apply());
                    }
                    return $anonfun$fill$1_fill_b.result();
                }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass())));
            }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass()))));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$12.runtimeClass())))));
    }

    public <T> Object[][][][] fill(int n1, int n2, int n3, int n4, int n5, Function0<T> elem, ClassTag<T> evidence$13) {
        return (Object[][][][])this.tabulate(n1, (Function1<Object, Object[][][]> & java.io.Serializable & Serializable)x$8 -> {
            Array$ array$ = MODULE$;
            if (array$ == null) {
                throw null;
            }
            return (Object[][][])array$.tabulate(n2, (Function1<Object, Object[][]> & java.io.Serializable & Serializable)x$7 -> {
                Array$ array$ = MODULE$;
                if (array$ == null) {
                    throw null;
                }
                return (Object[][])array$.tabulate(n3, (Function1<Object, Object[]> & java.io.Serializable & Serializable)x$6 -> {
                    Array$ array$ = MODULE$;
                    if (array$ == null) {
                        throw null;
                    }
                    return (Object[])array$.tabulate(n4, (Function1<Object, Object> & java.io.Serializable & Serializable)x$5 -> {
                        Array$ array$ = MODULE$;
                        if (array$ == null) {
                            throw null;
                        }
                        ArrayBuilder $anonfun$fill$1_fill_b = array$.newBuilder(evidence$13);
                        $anonfun$fill$1_fill_b.sizeHint(n5);
                        for (int $anonfun$fill$1_fill_i = 0; $anonfun$fill$1_fill_i < n5; ++$anonfun$fill$1_fill_i) {
                            $anonfun$fill$1_fill_b.$plus$eq(elem.apply());
                        }
                        return $anonfun$fill$1_fill_b.result();
                    }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass())));
                }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass()))));
            }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass())))));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass()))))));
    }

    public <T> Object tabulate(int n, Function1<Object, T> f, ClassTag<T> evidence$14) {
        ArrayBuilder<T> b = this.newBuilder(evidence$14);
        b.sizeHint(n);
        for (int i = 0; i < n; ++i) {
            b.$plus$eq(f.apply(BoxesRunTime.boxToInteger(i)));
        }
        return b.result();
    }

    public <T> Object[] tabulate(int n1, int n2, Function2<Object, Object, T> f, ClassTag<T> evidence$15) {
        return (Object[])this.tabulate(n1, (Function1<Object, Object> & java.io.Serializable & Serializable)i1 -> {
            int $anonfun$tabulate$1_i1 = BoxesRunTime.unboxToInt(i1);
            return MODULE$.tabulate(n2, (Function1<Object, Object> & java.io.Serializable & Serializable)x$9 -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$9))), evidence$15);
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$15.runtimeClass())));
    }

    public <T> Object[][] tabulate(int n1, int n2, int n3, Function3<Object, Object, Object, T> f, ClassTag<T> evidence$16) {
        return (Object[][])this.tabulate(n1, (Function1<Object, Object[]> & java.io.Serializable & Serializable)i1 -> {
            void $anonfun$tabulate$3_tabulate_f;
            int $anonfun$tabulate$3_i1 = BoxesRunTime.unboxToInt(i1);
            Array$ array$ = MODULE$;
            Function2<Object, Object, Object> & java.io.Serializable & Serializable intersect = (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x$10, x$11) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$10)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$11)));
            if (array$ == null) {
                throw null;
            }
            return (Object[])array$.tabulate(n2, arg_0 -> Array$.$anonfun$tabulate$1$adapted(n3, (Function2)$anonfun$tabulate$3_tabulate_f, evidence$16, arg_0), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$16.runtimeClass())));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$16.runtimeClass()))));
    }

    public <T> Object[][][] tabulate(int n1, int n2, int n3, int n4, Function4<Object, Object, Object, Object, T> f, ClassTag<T> evidence$17) {
        return (Object[][][])this.tabulate(n1, (Function1<Object, Object[][]> & java.io.Serializable & Serializable)i1 -> {
            void $anonfun$tabulate$5_tabulate_f;
            int $anonfun$tabulate$5_i1 = BoxesRunTime.unboxToInt(i1);
            Array$ array$ = MODULE$;
            Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable intersect = (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$12, x$13, x$14) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$12)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$13)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$14)));
            if (array$ == null) {
                throw null;
            }
            return (Object[][])array$.tabulate(n2, arg_0 -> Array$.$anonfun$tabulate$3$adapted(n3, n4, (Function3)$anonfun$tabulate$5_tabulate_f, evidence$17, arg_0), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$17.runtimeClass()))));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$17.runtimeClass())))));
    }

    public <T> Object[][][][] tabulate(int n1, int n2, int n3, int n4, int n5, Function5<Object, Object, Object, Object, Object, T> f, ClassTag<T> evidence$18) {
        return (Object[][][][])this.tabulate(n1, (Function1<Object, Object[][][]> & java.io.Serializable & Serializable)i1 -> {
            void $anonfun$tabulate$7_tabulate_f;
            int $anonfun$tabulate$7_i1 = BoxesRunTime.unboxToInt(i1);
            Array$ array$ = MODULE$;
            Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable intersect = (Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$15, x$16, x$17, x$18) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$15)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$16)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$17)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$18)));
            if (array$ == null) {
                throw null;
            }
            return (Object[][][])array$.tabulate(n2, arg_0 -> Array$.$anonfun$tabulate$5$adapted(n3, n4, n5, (Function4)$anonfun$tabulate$7_tabulate_f, evidence$18, arg_0), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$18.runtimeClass())))));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$18.runtimeClass()))))));
    }

    public int[] range(int start, int end) {
        return this.range(start, end, 1);
    }

    public int[] range(int start, int end, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("zero step");
        }
        ArrayBuilder<Object> b = this.newBuilder(ClassTag$.MODULE$.Int());
        b.sizeHint(Range$.MODULE$.count(start, end, step, false));
        int i = start;
        while (true) {
            boolean bl = step < 0 ? end < i : i < end;
            if (!bl) break;
            b.$plus$eq(BoxesRunTime.boxToInteger(i));
            i += step;
        }
        return (int[])b.result();
    }

    public <T> Object iterate(T start, int len, Function1<T, T> f, ClassTag<T> evidence$19) {
        ArrayBuilder<T> b = this.newBuilder(evidence$19);
        if (len > 0) {
            b.sizeHint(len);
            T acc = start;
            b.$plus$eq(start);
            for (int i = 1; i < len; ++i) {
                acc = f.apply(acc);
                b.$plus$eq(acc);
            }
        }
        return b.result();
    }

    public <T> Option<IndexedSeq<T>> unapplySeq(Object x) {
        if (x == null) {
            return None$.MODULE$;
        }
        return new Some<IndexedSeq<T>>(Predef$.MODULE$.genericArrayOps(x).toIndexedSeq());
    }

    private Object readResolve() {
        return MODULE$;
    }

    public static final /* synthetic */ void $anonfun$apply$1(Object array$1, IntRef i$1, Object x) {
        ScalaRunTime$.MODULE$.array_update(array$1, i$1.elem, x);
        ++i$1.elem;
    }

    public static final /* synthetic */ void $anonfun$apply$2(boolean[] array$2, IntRef i$2, boolean x) {
        array$2[i$2.elem] = x;
        ++i$2.elem;
    }

    public static final /* synthetic */ void $anonfun$apply$3(byte[] array$3, IntRef i$3, byte x) {
        array$3[i$3.elem] = x;
        ++i$3.elem;
    }

    public static final /* synthetic */ void $anonfun$apply$4(short[] array$4, IntRef i$4, short x) {
        array$4[i$4.elem] = x;
        ++i$4.elem;
    }

    public static final /* synthetic */ void $anonfun$apply$5(char[] array$5, IntRef i$5, char x) {
        array$5[i$5.elem] = x;
        ++i$5.elem;
    }

    public static final /* synthetic */ void $anonfun$apply$10(BoxedUnit[] array$10, IntRef i$10, BoxedUnit x) {
        array$10[i$10.elem] = x;
        ++i$10.elem;
    }

    public static final /* synthetic */ Object $anonfun$fill$1(int n2$5, Function0 elem$1, ClassTag evidence$10$1, int x$5) {
        Array$ array$ = MODULE$;
        if (array$ == null) {
            throw null;
        }
        ArrayBuilder fill_b = array$.newBuilder(evidence$10$1);
        fill_b.sizeHint(n2$5);
        for (int fill_i = 0; fill_i < n2$5; ++fill_i) {
            fill_b.$plus$eq(elem$1.apply());
        }
        return fill_b.result();
    }

    public static final /* synthetic */ Object[] $anonfun$fill$2(int n2$6, int n3$4, Function0 elem$2, ClassTag evidence$11$1, int x$6) {
        Array$ array$ = MODULE$;
        if (array$ == null) {
            throw null;
        }
        return (Object[])array$.tabulate(n2$6, (Function1<Object, Object> & java.io.Serializable & Serializable)x$5 -> {
            Array$ array$ = MODULE$;
            if (array$ == null) {
                throw null;
            }
            ArrayBuilder $anonfun$fill$1_fill_b = array$.newBuilder(evidence$13);
            $anonfun$fill$1_fill_b.sizeHint(n5);
            for (int $anonfun$fill$1_fill_i = 0; $anonfun$fill$1_fill_i < n5; ++$anonfun$fill$1_fill_i) {
                $anonfun$fill$1_fill_b.$plus$eq(elem.apply());
            }
            return $anonfun$fill$1_fill_b.result();
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$11$1.runtimeClass())));
    }

    public static final /* synthetic */ Object[][] $anonfun$fill$3(int n2$7, int n3$5, int n4$3, Function0 elem$3, ClassTag evidence$12$1, int x$7) {
        Array$ array$ = MODULE$;
        if (array$ == null) {
            throw null;
        }
        return (Object[][])array$.tabulate(n2$7, (Function1<Object, Object[]> & java.io.Serializable & Serializable)x$6 -> {
            Array$ array$ = MODULE$;
            if (array$ == null) {
                throw null;
            }
            return (Object[])array$.tabulate(n4, (Function1<Object, Object> & java.io.Serializable & Serializable)x$5 -> {
                Array$ array$ = MODULE$;
                if (array$ == null) {
                    throw null;
                }
                ArrayBuilder $anonfun$fill$1_fill_b = array$.newBuilder(evidence$13);
                $anonfun$fill$1_fill_b.sizeHint(n5);
                for (int $anonfun$fill$1_fill_i = 0; $anonfun$fill$1_fill_i < n5; ++$anonfun$fill$1_fill_i) {
                    $anonfun$fill$1_fill_b.$plus$eq(elem.apply());
                }
                return $anonfun$fill$1_fill_b.result();
            }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass())));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$12$1.runtimeClass()))));
    }

    public static final /* synthetic */ Object[][][] $anonfun$fill$4(int n2$8, int n3$6, int n4$4, int n5$2, Function0 elem$4, ClassTag evidence$13$1, int x$8) {
        Array$ array$ = MODULE$;
        if (array$ == null) {
            throw null;
        }
        return (Object[][][])array$.tabulate(n2$8, (Function1<Object, Object[][]> & java.io.Serializable & Serializable)x$7 -> {
            Array$ array$ = MODULE$;
            if (array$ == null) {
                throw null;
            }
            return (Object[][])array$.tabulate(n3, (Function1<Object, Object[]> & java.io.Serializable & Serializable)x$6 -> {
                Array$ array$ = MODULE$;
                if (array$ == null) {
                    throw null;
                }
                return (Object[])array$.tabulate(n4, (Function1<Object, Object> & java.io.Serializable & Serializable)x$5 -> {
                    Array$ array$ = MODULE$;
                    if (array$ == null) {
                        throw null;
                    }
                    ArrayBuilder $anonfun$fill$1_fill_b = array$.newBuilder(evidence$13);
                    $anonfun$fill$1_fill_b.sizeHint(n5);
                    for (int $anonfun$fill$1_fill_i = 0; $anonfun$fill$1_fill_i < n5; ++$anonfun$fill$1_fill_i) {
                        $anonfun$fill$1_fill_b.$plus$eq(elem.apply());
                    }
                    return $anonfun$fill$1_fill_b.result();
                }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass())));
            }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$13.runtimeClass()))));
        }, ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$13$1.runtimeClass())))));
    }

    public static final /* synthetic */ Object $anonfun$tabulate$1(int n2$9, Function2 f$1, ClassTag evidence$15$1, int i1) {
        return MODULE$.tabulate(n2$9, (Function1<Object, Object> & java.io.Serializable & Serializable)x$9 -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$9))), evidence$15$1);
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ Object[] $anonfun$tabulate$3(int n2$10, int n3$7, Function3 f$2, ClassTag evidence$16$1, int i1) {
        void tabulate_f;
        Array$ array$ = MODULE$;
        Function2<Object, Object, Object> & java.io.Serializable & Serializable intersect = (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x$10, x$11) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$10)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$11)));
        if (array$ == null) {
            throw null;
        }
        return (Object[])array$.tabulate(n2$10, arg_0 -> Array$.$anonfun$tabulate$1$adapted(n3$7, (Function2)tabulate_f, evidence$16$1, arg_0), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(evidence$16$1.runtimeClass())));
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ Object[][] $anonfun$tabulate$5(int n2$11, int n3$8, int n4$5, Function4 f$3, ClassTag evidence$17$1, int i1) {
        void tabulate_f;
        Array$ array$ = MODULE$;
        Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable intersect = (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$12, x$13, x$14) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$12)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$13)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$14)));
        if (array$ == null) {
            throw null;
        }
        return (Object[][])array$.tabulate(n2$11, arg_0 -> Array$.$anonfun$tabulate$3$adapted(n3$8, n4$5, (Function3)tabulate_f, evidence$17$1, arg_0), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$17$1.runtimeClass()))));
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ Object[][][] $anonfun$tabulate$7(int n2$12, int n3$9, int n4$6, int n5$3, Function5 f$4, ClassTag evidence$18$1, int i1) {
        void tabulate_f;
        Array$ array$ = MODULE$;
        Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable intersect = (Function4<Object, Object, Object, Object, Object> & java.io.Serializable & Serializable)(x$15, x$16, x$17, x$18) -> f.apply(BoxesRunTime.boxToInteger(i1), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$15)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$16)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$17)), BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(x$18)));
        if (array$ == null) {
            throw null;
        }
        return (Object[][][])array$.tabulate(n2$12, arg_0 -> Array$.$anonfun$tabulate$5$adapted(n3$9, n4$6, n5$3, (Function4)tabulate_f, evidence$18$1, arg_0), ClassTag$.MODULE$.apply(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(ScalaRunTime$.MODULE$.arrayClass(evidence$18$1.runtimeClass())))));
    }

    private Array$() {
        MODULE$ = this;
        this.emptyBooleanArray = new boolean[0];
        this.emptyByteArray = new byte[0];
        this.emptyCharArray = new char[0];
        this.emptyDoubleArray = new double[0];
        this.emptyFloatArray = new float[0];
        this.emptyIntArray = new int[0];
        this.emptyLongArray = new long[0];
        this.emptyShortArray = new short[0];
        this.emptyObjectArray = new Object[0];
        this.ObjectClass = Object.class;
        this.cbfBooleanArray = new CanBuildFrom<Object, Object, boolean[]>(){

            public ArrayBuilder.ofBoolean apply(Object from) {
                return new ArrayBuilder.ofBoolean();
            }

            public ArrayBuilder.ofBoolean apply() {
                return new ArrayBuilder.ofBoolean();
            }
        };
        this.cbfByteArray = new CanBuildFrom<Object, Object, byte[]>(){

            public ArrayBuilder.ofByte apply(Object from) {
                return new ArrayBuilder.ofByte();
            }

            public ArrayBuilder.ofByte apply() {
                return new ArrayBuilder.ofByte();
            }
        };
        this.cbfCharArray = new CanBuildFrom<Object, Object, char[]>(){

            public ArrayBuilder.ofChar apply(Object from) {
                return new ArrayBuilder.ofChar();
            }

            public ArrayBuilder.ofChar apply() {
                return new ArrayBuilder.ofChar();
            }
        };
        this.cbfDoubleArray = new CanBuildFrom<Object, Object, double[]>(){

            public ArrayBuilder.ofDouble apply(Object from) {
                return new ArrayBuilder.ofDouble();
            }

            public ArrayBuilder.ofDouble apply() {
                return new ArrayBuilder.ofDouble();
            }
        };
        this.cbfFloatArray = new CanBuildFrom<Object, Object, float[]>(){

            public ArrayBuilder.ofFloat apply(Object from) {
                return new ArrayBuilder.ofFloat();
            }

            public ArrayBuilder.ofFloat apply() {
                return new ArrayBuilder.ofFloat();
            }
        };
        this.cbfIntArray = new CanBuildFrom<Object, Object, int[]>(){

            public ArrayBuilder.ofInt apply(Object from) {
                return new ArrayBuilder.ofInt();
            }

            public ArrayBuilder.ofInt apply() {
                return new ArrayBuilder.ofInt();
            }
        };
        this.cbfLongArray = new CanBuildFrom<Object, Object, long[]>(){

            public ArrayBuilder.ofLong apply(Object from) {
                return new ArrayBuilder.ofLong();
            }

            public ArrayBuilder.ofLong apply() {
                return new ArrayBuilder.ofLong();
            }
        };
        this.cbfShortArray = new CanBuildFrom<Object, Object, short[]>(){

            public ArrayBuilder.ofShort apply(Object from) {
                return new ArrayBuilder.ofShort();
            }

            public ArrayBuilder.ofShort apply() {
                return new ArrayBuilder.ofShort();
            }
        };
        this.cbfUnitArray = new CanBuildFrom<Object, BoxedUnit, BoxedUnit[]>(){

            public ArrayBuilder.ofUnit apply(Object from) {
                return new ArrayBuilder.ofUnit();
            }

            public ArrayBuilder.ofUnit apply() {
                return new ArrayBuilder.ofUnit();
            }
        };
        this.cbfObjectArray = this.refCBF(ClassTag$.MODULE$.Object());
    }
}

