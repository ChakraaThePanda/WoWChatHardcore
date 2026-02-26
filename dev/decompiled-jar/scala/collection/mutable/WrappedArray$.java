/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Proxy;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Growable;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.ArrayBuilder$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Builder$;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.WrappedArray;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.runtime.BoxedUnit;
import scala.runtime.LambdaDeserialize;

public final class WrappedArray$ {
    public static WrappedArray$ MODULE$;
    private final WrappedArray.ofRef<Object> EmptyWrappedArray;
    private final Class<Object> ObjectClass;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfBooleanArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfByteArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfCharArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfDoubleArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfFloatArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfIntArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfLongArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfShortArray;
    private final CanBuildFrom<WrappedArray<?>, BoxedUnit, WrappedArray<BoxedUnit>> cbfUnitArray;
    private final CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> cbfObjectArray;

    static {
        new WrappedArray$();
    }

    private WrappedArray.ofRef<Object> EmptyWrappedArray() {
        return this.EmptyWrappedArray;
    }

    public <T> WrappedArray<T> empty() {
        return this.EmptyWrappedArray();
    }

    public <T> WrappedArray<T> make(Object x) {
        WrappedArray wrappedArray;
        if (x == null) {
            wrappedArray = null;
        } else if (x instanceof Object[]) {
            Object[] objectArray = (Object[])x;
            wrappedArray = new WrappedArray.ofRef<Object>(objectArray);
        } else if (x instanceof int[]) {
            int[] nArray = (int[])x;
            wrappedArray = new WrappedArray.ofInt(nArray);
        } else if (x instanceof double[]) {
            double[] dArray = (double[])x;
            wrappedArray = new WrappedArray.ofDouble(dArray);
        } else if (x instanceof long[]) {
            long[] lArray = (long[])x;
            wrappedArray = new WrappedArray.ofLong(lArray);
        } else if (x instanceof float[]) {
            float[] fArray = (float[])x;
            wrappedArray = new WrappedArray.ofFloat(fArray);
        } else if (x instanceof char[]) {
            char[] cArray = (char[])x;
            wrappedArray = new WrappedArray.ofChar(cArray);
        } else if (x instanceof byte[]) {
            byte[] byArray = (byte[])x;
            wrappedArray = new WrappedArray.ofByte(byArray);
        } else if (x instanceof short[]) {
            short[] sArray = (short[])x;
            wrappedArray = new WrappedArray.ofShort(sArray);
        } else if (x instanceof boolean[]) {
            boolean[] blArray = (boolean[])x;
            wrappedArray = new WrappedArray.ofBoolean(blArray);
        } else if (x instanceof BoxedUnit[]) {
            BoxedUnit[] boxedUnitArray = (BoxedUnit[])x;
            wrappedArray = new WrappedArray.ofUnit(boxedUnitArray);
        } else {
            throw new MatchError(x);
        }
        return wrappedArray;
    }

    public <T> CanBuildFrom<WrappedArray<?>, T, WrappedArray<T>> canBuildFrom(ClassTag<T> m) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        ClassTag<T> tag = m;
        Class<?> cls = tag.runtimeClass();
        if (cls.isPrimitive()) {
            CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>> canBuildFrom;
            Class<?> clazz = tag.runtimeClass();
            Class<Integer> clazz2 = Integer.TYPE;
            if (!(clazz2 != null ? !clazz2.equals(clazz) : clazz != null)) {
                canBuildFrom = this.cbfIntArray;
            } else {
                Class<Double> clazz3 = Double.TYPE;
                if (!(clazz3 != null ? !clazz3.equals(clazz) : clazz != null)) {
                    canBuildFrom = this.cbfDoubleArray;
                } else {
                    Class<Long> clazz4 = Long.TYPE;
                    if (!(clazz4 != null ? !clazz4.equals(clazz) : clazz != null)) {
                        canBuildFrom = this.cbfLongArray;
                    } else {
                        Class<Float> clazz5 = Float.TYPE;
                        if (!(clazz5 != null ? !clazz5.equals(clazz) : clazz != null)) {
                            canBuildFrom = this.cbfFloatArray;
                        } else {
                            Class<Character> clazz6 = Character.TYPE;
                            if (!(clazz6 != null ? !clazz6.equals(clazz) : clazz != null)) {
                                canBuildFrom = this.cbfCharArray;
                            } else {
                                Class<Byte> clazz7 = Byte.TYPE;
                                if (!(clazz7 != null ? !clazz7.equals(clazz) : clazz != null)) {
                                    canBuildFrom = this.cbfByteArray;
                                } else {
                                    Class<Short> clazz8 = Short.TYPE;
                                    if (!(clazz8 != null ? !clazz8.equals(clazz) : clazz != null)) {
                                        canBuildFrom = this.cbfShortArray;
                                    } else {
                                        Class<Boolean> clazz9 = Boolean.TYPE;
                                        if (!(clazz9 != null ? !clazz9.equals(clazz) : clazz != null)) {
                                            canBuildFrom = this.cbfBooleanArray;
                                        } else {
                                            Class<Void> clazz10 = Void.TYPE;
                                            if (!(clazz10 != null ? !clazz10.equals(clazz) : clazz != null)) {
                                                canBuildFrom = this.cbfUnitArray;
                                            } else {
                                                throw new MatchError(clazz);
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

    private <T> CanBuildFrom<WrappedArray<?>, T, WrappedArray<T>> refCBF(ClassTag<T> m) {
        return new CanBuildFrom<WrappedArray<?>, T, WrappedArray<T>>(m){
            private final ClassTag m$1;

            public Builder<T, WrappedArray<T>> apply(WrappedArray<?> from) {
                return ArrayBuilder$.MODULE$.make(this.m$1).mapResult((Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x));
            }

            public Builder<T, WrappedArray<T>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofRef<T> mapResult_this = new ArrayBuilder.ofRef<T>(this.m$1);
                return new Builder<Elem, NewTo>(mapResult_this, (Function1)mapResult_f){
                    private final Builder<Elem, To> self;
                    private final Function1 f$1;

                    public int hashCode() {
                        return Proxy.hashCode$(this);
                    }

                    public boolean equals(Object that) {
                        return Proxy.equals$(this, that);
                    }

                    public String toString() {
                        return Proxy.toString$(this);
                    }

                    public void sizeHint(TraversableLike<?, ?> coll) {
                        Builder.sizeHint$((Builder)this, coll);
                    }

                    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
                        Builder.sizeHint$(this, coll, delta);
                    }

                    public <NewTo> Builder<Elem, NewTo> mapResult(Function1<NewTo, NewTo> f) {
                        return Builder.mapResult$(this, f);
                    }

                    public Growable<Elem> $plus$eq(Elem elem1, Elem elem2, Seq<Elem> elems) {
                        return Growable.$plus$eq$(this, elem1, elem2, elems);
                    }

                    public Builder<Elem, To> self() {
                        return this.self;
                    }

                    public Builder$.anon.1 $plus$eq(Elem x) {
                        this.self().$plus$eq(x);
                        return this;
                    }

                    public void clear() {
                        this.self().clear();
                    }

                    public Builder$.anon.1 $plus$plus$eq(TraversableOnce<Elem> xs) {
                        this.self().$plus$plus$eq(xs);
                        return this;
                    }

                    public void sizeHint(int size) {
                        this.self().sizeHint(size);
                    }

                    public void sizeHintBounded(int size, TraversableLike<?, ?> boundColl) {
                        this.self().sizeHintBounded(size, boundColl);
                    }

                    public NewTo result() {
                        return (NewTo)this.f$1.apply(this.self().result());
                    }
                    {
                        this.f$1 = f$1;
                        Growable.$init$(this);
                        Builder.$init$(this);
                        Proxy.$init$(this);
                        this.self = $outer;
                    }
                };
            }
            {
                this.m$1 = m$1;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$19(java.lang.Object ), $anonfun$apply$20(java.lang.Object )}, serializedLambda);
            }
        };
    }

    public <A> Builder<A, IndexedSeq<A>> newBuilder() {
        return new ArrayBuffer();
    }

    private WrappedArray$() {
        MODULE$ = this;
        this.EmptyWrappedArray = new WrappedArray.ofRef<Object>(new Object[0]);
        this.ObjectClass = Object.class;
        this.cbfBooleanArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                return new ArrayBuilder.ofBoolean().mapResult((Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x));
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                return new ArrayBuilder.ofBoolean().mapResult((Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x));
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$1(java.lang.Object ), $anonfun$apply$2(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfByteArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofByte mapResult_this = new ArrayBuilder.ofByte();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofByte mapResult_this = new ArrayBuilder.ofByte();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$3(java.lang.Object ), $anonfun$apply$4(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfCharArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofChar mapResult_this = new ArrayBuilder.ofChar();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofChar mapResult_this = new ArrayBuilder.ofChar();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$5(java.lang.Object ), $anonfun$apply$6(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfDoubleArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofDouble mapResult_this = new ArrayBuilder.ofDouble();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofDouble mapResult_this = new ArrayBuilder.ofDouble();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$7(java.lang.Object ), $anonfun$apply$8(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfFloatArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofFloat mapResult_this = new ArrayBuilder.ofFloat();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofFloat mapResult_this = new ArrayBuilder.ofFloat();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$9(java.lang.Object ), $anonfun$apply$10(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfIntArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofInt mapResult_this = new ArrayBuilder.ofInt();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofInt mapResult_this = new ArrayBuilder.ofInt();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$11(java.lang.Object ), $anonfun$apply$12(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfLongArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofLong mapResult_this = new ArrayBuilder.ofLong();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofLong mapResult_this = new ArrayBuilder.ofLong();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$13(java.lang.Object ), $anonfun$apply$14(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfShortArray = new CanBuildFrom<WrappedArray<?>, Object, WrappedArray<Object>>(){

            public Builder<Object, WrappedArray<Object>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofShort mapResult_this = new ArrayBuilder.ofShort();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<Object, WrappedArray<Object>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofShort mapResult_this = new ArrayBuilder.ofShort();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$15(java.lang.Object ), $anonfun$apply$16(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfUnitArray = new CanBuildFrom<WrappedArray<?>, BoxedUnit, WrappedArray<BoxedUnit>>(){

            public Builder<BoxedUnit, WrappedArray<BoxedUnit>> apply(WrappedArray<?> from) {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofUnit mapResult_this = new ArrayBuilder.ofUnit();
                return new /* invalid duplicate definition of identical inner class */;
            }

            public Builder<BoxedUnit, WrappedArray<BoxedUnit>> apply() {
                Function1<Object, WrappedArray> & java.io.Serializable & Serializable mapResult_f = (Function1<Object, WrappedArray> & java.io.Serializable & Serializable)x -> WrappedArray$.MODULE$.make(x);
                ArrayBuilder.ofUnit mapResult_this = new ArrayBuilder.ofUnit();
                return new /* invalid duplicate definition of identical inner class */;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$17(java.lang.Object ), $anonfun$apply$18(java.lang.Object )}, serializedLambda);
            }
        };
        this.cbfObjectArray = this.refCBF(ClassTag$.MODULE$.Object());
    }
}

