/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.lang.invoke.LambdaMetafactory;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import scala.Array$;
import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Product;
import scala.Product1;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.Traversable$;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.generic.IsTraversableLike;
import scala.collection.generic.Sorted;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.NumericRange;
import scala.collection.immutable.Range;
import scala.collection.immutable.StringLike;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.WrappedArray$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichChar$;
import scala.runtime.RichInt$;
import scala.runtime.Statics;
import scala.util.hashing.MurmurHash3$;

public final class ScalaRunTime$ {
    public static ScalaRunTime$ MODULE$;

    static {
        new ScalaRunTime$();
    }

    public boolean isArray(Object x, int atLevel) {
        return x != null && this.isArrayClass(x.getClass(), atLevel);
    }

    public int isArray$default$2() {
        return 1;
    }

    private boolean isArrayClass(Class<?> clazz, int atLevel) {
        while (clazz.isArray()) {
            if (atLevel != 1) {
                --atLevel;
                clazz = clazz.getComponentType();
                continue;
            }
            return true;
        }
        return false;
    }

    public <Repr> Repr drop(Repr coll, int num, IsTraversableLike<Repr> traversable) {
        return traversable.conversion().apply(coll).drop(num);
    }

    public Class<?> arrayClass(Class<?> clazz) {
        Class<?> clazz2 = clazz;
        Class<Void> clazz3 = Void.TYPE;
        if (!(clazz2 != null ? !clazz2.equals(clazz3) : clazz3 != null)) {
            return BoxedUnit[].class;
        }
        return Array.newInstance(clazz, 0).getClass();
    }

    public <T> Class<T> anyValClass(T value, ClassTag<T> evidence$1) {
        return package$.MODULE$.classTag(evidence$1).runtimeClass();
    }

    public Object array_apply(Object xs, int idx) {
        Object object;
        if (xs instanceof Object[]) {
            object = ((Object[])xs)[idx];
        } else if (xs instanceof int[]) {
            object = BoxesRunTime.boxToInteger(((int[])xs)[idx]);
        } else if (xs instanceof double[]) {
            object = BoxesRunTime.boxToDouble(((double[])xs)[idx]);
        } else if (xs instanceof long[]) {
            object = BoxesRunTime.boxToLong(((long[])xs)[idx]);
        } else if (xs instanceof float[]) {
            object = BoxesRunTime.boxToFloat(((float[])xs)[idx]);
        } else if (xs instanceof char[]) {
            object = BoxesRunTime.boxToCharacter(((char[])xs)[idx]);
        } else if (xs instanceof byte[]) {
            object = BoxesRunTime.boxToByte(((byte[])xs)[idx]);
        } else if (xs instanceof short[]) {
            object = BoxesRunTime.boxToShort(((short[])xs)[idx]);
        } else if (xs instanceof boolean[]) {
            object = BoxesRunTime.boxToBoolean(((boolean[])xs)[idx]);
        } else if (xs instanceof BoxedUnit[]) {
            object = ((BoxedUnit[])xs)[idx];
        } else {
            if (xs == null) {
                throw new NullPointerException();
            }
            throw new MatchError(xs);
        }
        return object;
    }

    public void array_update(Object xs, int idx, Object value) {
        if (xs instanceof Object[]) {
            ((Object[])xs)[idx] = value;
            return;
        }
        if (xs instanceof int[]) {
            ((int[])xs)[idx] = BoxesRunTime.unboxToInt(value);
            return;
        }
        if (xs instanceof double[]) {
            ((double[])xs)[idx] = BoxesRunTime.unboxToDouble(value);
            return;
        }
        if (xs instanceof long[]) {
            ((long[])xs)[idx] = BoxesRunTime.unboxToLong(value);
            return;
        }
        if (xs instanceof float[]) {
            ((float[])xs)[idx] = BoxesRunTime.unboxToFloat(value);
            return;
        }
        if (xs instanceof char[]) {
            ((char[])xs)[idx] = BoxesRunTime.unboxToChar(value);
            return;
        }
        if (xs instanceof byte[]) {
            ((byte[])xs)[idx] = BoxesRunTime.unboxToByte(value);
            return;
        }
        if (xs instanceof short[]) {
            ((short[])xs)[idx] = BoxesRunTime.unboxToShort(value);
            return;
        }
        if (xs instanceof boolean[]) {
            ((boolean[])xs)[idx] = BoxesRunTime.unboxToBoolean(value);
            return;
        }
        if (xs instanceof BoxedUnit[]) {
            ((BoxedUnit[])xs)[idx] = BoxedUnit.UNIT;
            return;
        }
        if (xs == null) {
            throw new NullPointerException();
        }
        throw new MatchError(xs);
    }

    public int array_length(Object xs) {
        int n;
        if (xs instanceof Object[]) {
            n = ((Object[])xs).length;
        } else if (xs instanceof int[]) {
            n = ((int[])xs).length;
        } else if (xs instanceof double[]) {
            n = ((double[])xs).length;
        } else if (xs instanceof long[]) {
            n = ((long[])xs).length;
        } else if (xs instanceof float[]) {
            n = ((float[])xs).length;
        } else if (xs instanceof char[]) {
            n = ((char[])xs).length;
        } else if (xs instanceof byte[]) {
            n = ((byte[])xs).length;
        } else if (xs instanceof short[]) {
            n = ((short[])xs).length;
        } else if (xs instanceof boolean[]) {
            n = ((boolean[])xs).length;
        } else if (xs instanceof BoxedUnit[]) {
            n = ((BoxedUnit[])xs).length;
        } else {
            if (xs == null) {
                throw new NullPointerException();
            }
            throw new MatchError(xs);
        }
        return n;
    }

    public Object array_clone(Object xs) {
        BoxedUnit[] boxedUnitArray;
        if (xs instanceof Object[]) {
            boxedUnitArray = ((Object[])xs).clone();
        } else if (xs instanceof int[]) {
            boxedUnitArray = ((int[])xs).clone();
        } else if (xs instanceof double[]) {
            boxedUnitArray = ((double[])xs).clone();
        } else if (xs instanceof long[]) {
            boxedUnitArray = ((long[])xs).clone();
        } else if (xs instanceof float[]) {
            boxedUnitArray = ((float[])xs).clone();
        } else if (xs instanceof char[]) {
            boxedUnitArray = ((char[])xs).clone();
        } else if (xs instanceof byte[]) {
            boxedUnitArray = ((byte[])xs).clone();
        } else if (xs instanceof short[]) {
            boxedUnitArray = ((short[])xs).clone();
        } else if (xs instanceof boolean[]) {
            boxedUnitArray = ((boolean[])xs).clone();
        } else if (xs instanceof BoxedUnit[]) {
            boxedUnitArray = (BoxedUnit[])xs;
        } else {
            if (xs == null) {
                throw new NullPointerException();
            }
            throw new MatchError(xs);
        }
        return boxedUnitArray;
    }

    public Object[] toObjectArray(Object src) {
        Object[] objectArray;
        if (src instanceof Object[]) {
            objectArray = (Object[])src;
        } else if (src instanceof int[]) {
            objectArray = ScalaRunTime$.copy$mIc$sp$1((int[])src);
        } else if (src instanceof double[]) {
            objectArray = ScalaRunTime$.copy$mDc$sp$1((double[])src);
        } else if (src instanceof long[]) {
            objectArray = ScalaRunTime$.copy$mJc$sp$1((long[])src);
        } else if (src instanceof float[]) {
            objectArray = ScalaRunTime$.copy$mFc$sp$1((float[])src);
        } else if (src instanceof char[]) {
            objectArray = ScalaRunTime$.copy$mCc$sp$1((char[])src);
        } else if (src instanceof byte[]) {
            objectArray = ScalaRunTime$.copy$mBc$sp$1((byte[])src);
        } else if (src instanceof short[]) {
            objectArray = ScalaRunTime$.copy$mSc$sp$1((short[])src);
        } else if (src instanceof boolean[]) {
            objectArray = ScalaRunTime$.copy$mZc$sp$1((boolean[])src);
        } else if (src instanceof BoxedUnit[]) {
            objectArray = ScalaRunTime$.copy$mVc$sp$1((BoxedUnit[])src);
        } else {
            if (src == null) {
                throw new NullPointerException();
            }
            throw new MatchError(src);
        }
        return objectArray;
    }

    /*
     * WARNING - void declaration
     */
    public <T> Object[] toArray(Seq<T> xs) {
        void var2_2;
        if (xs.isEmpty()) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] arr = new Object[xs.length()];
        Iterator it = xs.iterator();
        int i = 0;
        while (it.hasNext()) {
            arr[i] = it.next();
            ++i;
        }
        return var2_2;
    }

    public Method ensureAccessible(Method m) {
        return package$.MODULE$.ensureAccessible(m);
    }

    public String _toString(Product x) {
        return x.productIterator().mkString(new StringBuilder(1).append(x.productPrefix()).append("(").toString(), ",", ")");
    }

    public int _hashCode(Product x) {
        return MurmurHash3$.MODULE$.productHash(x);
    }

    public <T> Iterator<T> typedProductIterator(Product x) {
        return new AbstractIterator<T>(x){
            private int c;
            private final int cmax;
            private final Product x$2;

            private int c() {
                return this.c;
            }

            private void c_$eq(int x$1) {
                this.c = x$1;
            }

            private int cmax() {
                return this.cmax;
            }

            public boolean hasNext() {
                return this.c() < this.cmax();
            }

            /*
             * WARNING - void declaration
             */
            public T next() {
                void var1_1;
                Object result2 = this.x$2.productElement(this.c());
                this.c_$eq(this.c() + 1);
                return var1_1;
            }
            {
                this.x$2 = x$2;
                this.c = 0;
                this.cmax = x$2.productArity();
            }
        };
    }

    public int hash(Object x) {
        return Statics.anyHash(x);
    }

    public String stringOf(Object arg) {
        return this.stringOf(arg, Integer.MAX_VALUE);
    }

    public String stringOf(Object arg, int maxElements) {
        try {
            return this.inner$1(arg, maxElements);
        }
        catch (Throwable throwable) {
            boolean bl = throwable instanceof UnsupportedOperationException ? true : throwable instanceof AssertionError;
            if (!bl) {
                throw throwable;
            }
            String string = String.valueOf(arg);
            return string;
        }
    }

    public String replStringOf(Object arg, int maxElements) {
        String s = this.stringOf(arg, maxElements);
        String nl = s.contains("\n") ? "\n" : "";
        return new StringBuilder(1).append(nl).append(s).append("\n").toString();
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mZc$sp$1(boolean[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToBoolean(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mBc$sp$1(byte[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToByte(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mCc$sp$1(char[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToCharacter(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mDc$sp$1(double[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToDouble(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mFc$sp$1(float[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToFloat(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mIc$sp$1(int[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToInteger(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mJc$sp$1(long[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToLong(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mSc$sp$1(short[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = BoxesRunTime.boxToShort(src[i]);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$mVc$sp$1(BoxedUnit[] src) {
        void var2_2;
        int length = src.length;
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = src[i];
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Object[] copy$1(Object src) {
        void var2_2;
        int length = MODULE$.array_length(src);
        if (length == 0) {
            return Array$.MODULE$.emptyObjectArray();
        }
        Object[] dest = new Object[length];
        for (int i = 0; i < length; ++i) {
            dest[i] = MODULE$.array_apply(src, i);
        }
        return var2_2;
    }

    private static final String packageOf$1(Object x) {
        Package package_ = x.getClass().getPackage();
        String string = package_ == null ? "" : package_.getName();
        return string;
    }

    private static final boolean isScalaClass$1(Object x) {
        return ScalaRunTime$.packageOf$1(x).startsWith("scala.");
    }

    private static final boolean isScalaCompilerClass$1(Object x) {
        return ScalaRunTime$.packageOf$1(x).startsWith("scala.tools.nsc.");
    }

    private static final boolean isTuple$1(Object x) {
        return x != null && x.getClass().getName().startsWith("scala.Tuple");
    }

    private static final boolean isSubClassOf$1(Class potentialSubClass, String ofClass) {
        try {
            ClassLoader classLoader = potentialSubClass.getClassLoader();
            return Class.forName(ofClass, false, classLoader).isAssignableFrom(potentialSubClass);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    private static final boolean isXmlNode$1(Class potentialSubClass) {
        return ScalaRunTime$.isSubClassOf$1(potentialSubClass, "scala.xml.Node");
    }

    private static final boolean isXmlMetaData$1(Class potentialSubClass) {
        return ScalaRunTime$.isSubClassOf$1(potentialSubClass, "scala.xml.MetaData");
    }

    private static final boolean useOwnToString$1(Object x) {
        Traversable traversable;
        boolean bl = x instanceof Range ? true : x instanceof NumericRange;
        boolean bl2 = bl ? true : (x instanceof Sorted ? true : (x instanceof StringLike ? true : (x instanceof TraversableView ? true : (x instanceof Traversable ? !(traversable = (Traversable)x).hasDefiniteSize() || !ScalaRunTime$.isScalaClass$1(traversable) || ScalaRunTime$.isScalaCompilerClass$1(traversable) || ScalaRunTime$.isXmlNode$1(traversable.getClass()) || ScalaRunTime$.isXmlMetaData$1(traversable.getClass()) : false))));
        return bl2;
    }

    private final String mapInner$1(Object arg, int maxElements$1) {
        String string;
        if (arg instanceof Tuple2) {
            Tuple2 tuple2 = (Tuple2)arg;
            Object k = tuple2._1();
            Object v = tuple2._2();
            string = new StringBuilder(4).append(this.inner$1(k, maxElements$1)).append(" -> ").append(this.inner$1(v, maxElements$1)).toString();
        } else {
            string = this.inner$1(arg, maxElements$1);
        }
        return string;
    }

    public static final /* synthetic */ String $anonfun$stringOf$1(int x$1) {
        return "()";
    }

    private final String arrayToString$1(Object x, int maxElements$1) {
        Class<?> clazz = x.getClass().getComponentType();
        Class<BoxedUnit> clazz2 = BoxedUnit.class;
        if (clazz != null && clazz.equals(clazz2)) {
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int n2 = this.array_length(x);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return ((TraversableOnce)RichInt$.MODULE$.until$extension0(n, RichInt$.MODULE$.min$extension(n2, maxElements$1)).map((Function1<Object, String> & java.io.Serializable & Serializable)x$1 -> ScalaRunTime$.$anonfun$stringOf$1(BoxesRunTime.unboxToInt(x$1)), IndexedSeq$.MODULE$.canBuildFrom())).mkString("Array(", ", ", ")");
        }
        return ((TraversableOnce)((TraversableLike)WrappedArray$.MODULE$.make(x).take(maxElements$1)).map((Function1<Object, String> & java.io.Serializable & Serializable)arg -> this.inner$1(arg, maxElements$1), WrappedArray$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(String.class)))).mkString("Array(", ", ", ")");
    }

    public static final /* synthetic */ String $anonfun$stringOf$3(ScalaRunTime$ $this, int maxElements$1, Object arg) {
        return $this.mapInner$1(arg, maxElements$1);
    }

    public static final /* synthetic */ String $anonfun$stringOf$4(ScalaRunTime$ $this, int maxElements$1, Object arg) {
        return $this.inner$1(arg, maxElements$1);
    }

    public static final /* synthetic */ String $anonfun$stringOf$5(ScalaRunTime$ $this, int maxElements$1, Object arg) {
        return $this.inner$1(arg, maxElements$1);
    }

    public static final /* synthetic */ String $anonfun$stringOf$6(ScalaRunTime$ $this, int maxElements$1, Object arg) {
        return $this.inner$1(arg, maxElements$1);
    }

    /*
     * Unable to fully structure code
     */
    private final String inner$1(Object arg, int maxElements$1) {
        block17: {
            block19: {
                block18: {
                    block16: {
                        if (arg != null) break block16;
                        var3_3 = "null";
                        break block17;
                    }
                    if (!"".equals(arg)) break block18;
                    var3_3 = "\"\"";
                    break block17;
                }
                if (!(arg instanceof String)) break block19;
                var4_4 = (String)arg;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                var10_5 = BoxesRunTime.unboxToChar(new StringOps(var4_4).head());
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                if (RichChar$.MODULE$.isWhitespace$extension(var10_5)) ** GOTO lbl-1000
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                var11_6 = BoxesRunTime.unboxToChar(new StringOps(var4_4).last());
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                if (RichChar$.MODULE$.isWhitespace$extension(var11_6)) lbl-1000:
                // 2 sources

                {
                    v0 = new StringBuilder(2).append("\"").append(var4_4).append("\"").toString();
                } else {
                    v0 = var4_4;
                }
                var3_3 = v0;
                break block17;
            }
            if (ScalaRunTime$.useOwnToString$1(arg)) {
                var3_3 = arg.toString();
            } else if (arg instanceof Object && this.isArray(arg, this.isArray$default$2())) {
                var3_3 = this.arrayToString$1(arg, maxElements$1);
            } else if (arg instanceof Map) {
                var5_7 = (Map)arg;
                var3_3 = var5_7.iterator().take(maxElements$1).map((Function1<Object, String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$stringOf$3(scala.runtime.ScalaRunTime$ int java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/String;)((ScalaRunTime$)this, (int)maxElements$1)).mkString(new StringBuilder(1).append(var5_7.stringPrefix()).append("(").toString(), ", ", ")");
            } else if (arg instanceof GenIterable) {
                var6_8 = (GenIterable)arg;
                var3_3 = var6_8.iterator().take(maxElements$1).map((Function1<Object, String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$stringOf$4(scala.runtime.ScalaRunTime$ int java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/String;)((ScalaRunTime$)this, (int)maxElements$1)).mkString(new StringBuilder(1).append(var6_8.stringPrefix()).append("(").toString(), ", ", ")");
            } else if (arg instanceof Traversable) {
                var7_9 = (Traversable)arg;
                var3_3 = ((TraversableOnce)((TraversableLike)var7_9.take(maxElements$1)).map((Function1<Object, String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$stringOf$5(scala.runtime.ScalaRunTime$ int java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/String;)((ScalaRunTime$)this, (int)maxElements$1), Traversable$.MODULE$.canBuildFrom())).mkString(new StringBuilder(1).append(var7_9.stringPrefix()).append("(").toString(), ", ", ")");
            } else {
                var3_3 = arg instanceof Product1 != false && ScalaRunTime$.isTuple$1(var8_10 = (Product1)arg) != false ? new StringBuilder(3).append("(").append(this.inner$1(var8_10._1(), maxElements$1)).append(",)").toString() : (arg instanceof Product != false && ScalaRunTime$.isTuple$1(var9_11 = (Product)arg) != false ? var9_11.productIterator().map((Function1<Object, String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$stringOf$6(scala.runtime.ScalaRunTime$ int java.lang.Object ), (Ljava/lang/Object;)Ljava/lang/String;)((ScalaRunTime$)this, (int)maxElements$1)).mkString("(", ",", ")") : arg.toString());
            }
        }
        return var3_3;
    }

    private ScalaRunTime$() {
        MODULE$ = this;
    }
}

