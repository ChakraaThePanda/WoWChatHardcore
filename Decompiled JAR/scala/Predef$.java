/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Console$;
import scala.DeprecatedPredef;
import scala.Function0;
import scala.LowPriorityImplicits;
import scala.MatchError;
import scala.NotImplementedError;
import scala.Predef;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.IndexedSeq;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.List;
import scala.collection.immutable.Map$;
import scala.collection.immutable.Set$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.StringBuilder;
import scala.collection.mutable.StringBuilder$;
import scala.reflect.ClassManifestFactory$;
import scala.reflect.ClassTag;
import scala.reflect.Manifest;
import scala.reflect.ManifestFactory$;
import scala.reflect.NoManifest$;
import scala.reflect.OptManifest;
import scala.reflect.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class Predef$
extends LowPriorityImplicits
implements DeprecatedPredef {
    public static Predef$ MODULE$;
    private final Map$ Map;
    private final Set$ Set;
    private final ClassManifestFactory$ ClassManifest;
    private final ManifestFactory$ Manifest;
    private final NoManifest$ NoManifest;
    private final CanBuildFrom<String, Object, String> StringCanBuildFrom;
    private final less.colon.less<Object, Object> singleton_$less$colon$less;
    public final eq.colon.eq<Object, Object> scala$Predef$$singleton_$eq$colon$eq;

    static {
        new Predef$();
    }

    @Override
    public <A> A any2ArrowAssoc(A x) {
        return (A)DeprecatedPredef.any2ArrowAssoc$(this, x);
    }

    @Override
    public <A> A any2Ensuring(A x) {
        return (A)DeprecatedPredef.any2Ensuring$(this, x);
    }

    @Override
    public Object any2stringfmt(Object x) {
        return DeprecatedPredef.any2stringfmt$(this, x);
    }

    @Override
    public Throwable exceptionWrapper(Throwable exc) {
        return DeprecatedPredef.exceptionWrapper$(this, exc);
    }

    @Override
    public CharSequence seqToCharSequence(IndexedSeq<Object> xs) {
        return DeprecatedPredef.seqToCharSequence$(this, xs);
    }

    @Override
    public CharSequence arrayToCharSequence(char[] xs) {
        return DeprecatedPredef.arrayToCharSequence$(this, xs);
    }

    @Override
    public String readLine() {
        return DeprecatedPredef.readLine$(this);
    }

    @Override
    public String readLine(String text, Seq<Object> args2) {
        return DeprecatedPredef.readLine$(this, text, args2);
    }

    @Override
    public boolean readBoolean() {
        return DeprecatedPredef.readBoolean$(this);
    }

    @Override
    public byte readByte() {
        return DeprecatedPredef.readByte$(this);
    }

    @Override
    public short readShort() {
        return DeprecatedPredef.readShort$(this);
    }

    @Override
    public char readChar() {
        return DeprecatedPredef.readChar$(this);
    }

    @Override
    public int readInt() {
        return DeprecatedPredef.readInt$(this);
    }

    @Override
    public long readLong() {
        return DeprecatedPredef.readLong$(this);
    }

    @Override
    public float readFloat() {
        return DeprecatedPredef.readFloat$(this);
    }

    @Override
    public double readDouble() {
        return DeprecatedPredef.readDouble$(this);
    }

    @Override
    public List<Object> readf(String format) {
        return DeprecatedPredef.readf$(this, format);
    }

    @Override
    public Object readf1(String format) {
        return DeprecatedPredef.readf1$(this, format);
    }

    @Override
    public Tuple2<Object, Object> readf2(String format) {
        return DeprecatedPredef.readf2$(this, format);
    }

    @Override
    public Tuple3<Object, Object, Object> readf3(String format) {
        return DeprecatedPredef.readf3$(this, format);
    }

    public <T> Class<T> classOf() {
        return null;
    }

    public Map$ Map() {
        return this.Map;
    }

    public Set$ Set() {
        return this.Set;
    }

    public ClassManifestFactory$ ClassManifest() {
        return this.ClassManifest;
    }

    public ManifestFactory$ Manifest() {
        return this.Manifest;
    }

    public NoManifest$ NoManifest() {
        return this.NoManifest;
    }

    public <T> Manifest<T> manifest(Manifest<T> m) {
        return m;
    }

    public <T> ClassTag<T> classManifest(ClassTag<T> m) {
        return m;
    }

    public <T> OptManifest<T> optManifest(OptManifest<T> m) {
        return m;
    }

    public <A> A identity(A x) {
        return x;
    }

    public <T> T implicitly(T e) {
        return e;
    }

    public <T> T locally(T x) {
        return x;
    }

    public void assert(boolean assertion) {
        if (!assertion) {
            throw new AssertionError((Object)"assertion failed");
        }
    }

    public final void assert(boolean assertion, Function0<Object> message) {
        if (!assertion) {
            throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append(message.apply()).toString());
        }
    }

    public void assume(boolean assumption) {
        if (!assumption) {
            throw new AssertionError((Object)"assumption failed");
        }
    }

    public final void assume(boolean assumption, Function0<Object> message) {
        if (!assumption) {
            throw new AssertionError((Object)new java.lang.StringBuilder(19).append("assumption failed: ").append(message.apply()).toString());
        }
    }

    public void require(boolean requirement) {
        if (!requirement) {
            throw new IllegalArgumentException("requirement failed");
        }
    }

    public final void require(boolean requirement, Function0<Object> message) {
        if (!requirement) {
            throw new IllegalArgumentException(new java.lang.StringBuilder(20).append("requirement failed: ").append(message.apply()).toString());
        }
    }

    public Nothing$ $qmark$qmark$qmark() {
        throw new NotImplementedError();
    }

    public <A> A ArrowAssoc(A self) {
        return self;
    }

    public <A> A Ensuring(A self) {
        return self;
    }

    public <A> A StringFormat(A self) {
        return self;
    }

    public <A> A any2stringadd(A self) {
        return self;
    }

    public Throwable RichException(Throwable self) {
        return self;
    }

    public Predef.SeqCharSequence SeqCharSequence(IndexedSeq<Object> __sequenceOfChars) {
        return new Predef.SeqCharSequence(__sequenceOfChars);
    }

    public Predef.ArrayCharSequence ArrayCharSequence(char[] __arrayOfChars) {
        return new Predef.ArrayCharSequence(__arrayOfChars);
    }

    public CanBuildFrom<String, Object, String> StringCanBuildFrom() {
        return this.StringCanBuildFrom;
    }

    public String augmentString(String x) {
        return x;
    }

    public String unaugmentString(String x) {
        return x;
    }

    public void print(Object x) {
        Console$.MODULE$.print(x);
    }

    public void println() {
        Console$.MODULE$.println();
    }

    public void println(Object x) {
        Console$.MODULE$.println(x);
    }

    public void printf(String text, Seq<Object> xs) {
        Console$.MODULE$.print(new StringOps(text).format(xs));
    }

    public <T1, T2> Tuple2<T1, T2> tuple2ToZippedOps(Tuple2<T1, T2> x) {
        return x;
    }

    public <T1, T2, T3> Tuple3<T1, T2, T3> tuple3ToZippedOps(Tuple3<T1, T2, T3> x) {
        return x;
    }

    public <T> ArrayOps<T> genericArrayOps(Object xs) {
        ArrayOps<Object> arrayOps;
        if (xs instanceof Object[]) {
            Object[] objectArray = (Object[])xs;
            arrayOps = new ArrayOps.ofRef<Object>(this.refArrayOps(objectArray));
        } else if (xs instanceof boolean[]) {
            boolean[] blArray = (boolean[])xs;
            arrayOps = new ArrayOps.ofBoolean(this.booleanArrayOps(blArray));
        } else if (xs instanceof byte[]) {
            byte[] byArray = (byte[])xs;
            arrayOps = new ArrayOps.ofByte(this.byteArrayOps(byArray));
        } else if (xs instanceof char[]) {
            char[] cArray = (char[])xs;
            arrayOps = new ArrayOps.ofChar(this.charArrayOps(cArray));
        } else if (xs instanceof double[]) {
            double[] dArray = (double[])xs;
            arrayOps = new ArrayOps.ofDouble(this.doubleArrayOps(dArray));
        } else if (xs instanceof float[]) {
            float[] fArray = (float[])xs;
            arrayOps = new ArrayOps.ofFloat(this.floatArrayOps(fArray));
        } else if (xs instanceof int[]) {
            int[] nArray = (int[])xs;
            arrayOps = new ArrayOps.ofInt(this.intArrayOps(nArray));
        } else if (xs instanceof long[]) {
            long[] lArray = (long[])xs;
            arrayOps = new ArrayOps.ofLong(this.longArrayOps(lArray));
        } else if (xs instanceof short[]) {
            short[] sArray = (short[])xs;
            arrayOps = new ArrayOps.ofShort(this.shortArrayOps(sArray));
        } else if (xs instanceof BoxedUnit[]) {
            BoxedUnit[] boxedUnitArray = (BoxedUnit[])xs;
            arrayOps = new ArrayOps.ofUnit(this.unitArrayOps(boxedUnitArray));
        } else if (xs == null) {
            arrayOps = null;
        } else {
            throw new MatchError(xs);
        }
        return arrayOps;
    }

    public boolean[] booleanArrayOps(boolean[] xs) {
        return xs;
    }

    public byte[] byteArrayOps(byte[] xs) {
        return xs;
    }

    public char[] charArrayOps(char[] xs) {
        return xs;
    }

    public double[] doubleArrayOps(double[] xs) {
        return xs;
    }

    public float[] floatArrayOps(float[] xs) {
        return xs;
    }

    public int[] intArrayOps(int[] xs) {
        return xs;
    }

    public long[] longArrayOps(long[] xs) {
        return xs;
    }

    public <T> T[] refArrayOps(T[] xs) {
        return xs;
    }

    public short[] shortArrayOps(short[] xs) {
        return xs;
    }

    public BoxedUnit[] unitArrayOps(BoxedUnit[] xs) {
        return xs;
    }

    public Byte byte2Byte(byte x) {
        return BoxesRunTime.boxToByte(x);
    }

    public Short short2Short(short x) {
        return BoxesRunTime.boxToShort(x);
    }

    public Character char2Character(char x) {
        return BoxesRunTime.boxToCharacter(x);
    }

    public Integer int2Integer(int x) {
        return BoxesRunTime.boxToInteger(x);
    }

    public Long long2Long(long x) {
        return BoxesRunTime.boxToLong(x);
    }

    public Float float2Float(float x) {
        return BoxesRunTime.boxToFloat(x);
    }

    public Double double2Double(double x) {
        return BoxesRunTime.boxToDouble(x);
    }

    public Boolean boolean2Boolean(boolean x) {
        return BoxesRunTime.boxToBoolean(x);
    }

    public byte Byte2byte(Byte x) {
        return BoxesRunTime.unboxToByte(x);
    }

    public short Short2short(Short x) {
        return BoxesRunTime.unboxToShort(x);
    }

    public char Character2char(Character x) {
        return BoxesRunTime.unboxToChar(x);
    }

    public int Integer2int(Integer x) {
        return BoxesRunTime.unboxToInt(x);
    }

    public long Long2long(Long x) {
        return BoxesRunTime.unboxToLong(x);
    }

    public float Float2float(Float x) {
        return BoxesRunTime.unboxToFloat(x);
    }

    public double Double2double(Double x) {
        return BoxesRunTime.unboxToDouble(x);
    }

    public boolean Boolean2boolean(Boolean x) {
        return BoxesRunTime.unboxToBoolean(x);
    }

    public <A> less.colon.less<A, A> $conforms() {
        return this.singleton_$less$colon$less;
    }

    public <A> less.colon.less<A, A> conforms() {
        return this.$conforms();
    }

    private Predef$() {
        MODULE$ = this;
        DeprecatedPredef.$init$(this);
        this.Map = Map$.MODULE$;
        this.Set = Set$.MODULE$;
        this.ClassManifest = package$.MODULE$.ClassManifest();
        this.Manifest = package$.MODULE$.Manifest();
        this.NoManifest = NoManifest$.MODULE$;
        this.StringCanBuildFrom = new CanBuildFrom<String, Object, String>(){

            public StringBuilder apply(String from) {
                return this.apply();
            }

            public StringBuilder apply() {
                return StringBuilder$.MODULE$.newBuilder();
            }
        };
        this.singleton_$less$colon$less = new less.colon.less<Object, Object>(){

            public Object apply(Object x) {
                return x;
            }
        };
        this.scala$Predef$$singleton_$eq$colon$eq = new eq.colon.eq<Object, Object>(){

            public Object apply(Object x) {
                return x;
            }
        };
    }
}

