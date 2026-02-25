/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Array$;
import scala.Function1;
import scala.MatchError;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.collection.mutable.WrappedArray;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001e4A!\u0006\f\u0001;!AQ\u0007\u0001B\u0001B\u0003%a\u0007C\u0003=\u0001\u0011\u0005Q\bC\u0004A\u0001\t\u0007I\u0011A!\t\r)\u0003\u0001\u0015!\u00037\u0011%a\u0005\u00011AA\u0002\u0013%Q\nC\u0005O\u0001\u0001\u0007\t\u0019!C\u0005\u001f\"IQ\u000b\u0001a\u0001\u0002\u0003\u0006KA\r\u0005\b-\u0002\u0001\r\u0011\"\u0003X\u0011\u001dY\u0006\u00011A\u0005\nqCaA\u0018\u0001!B\u0013A\u0006bB0\u0001\u0001\u0004%Ia\u0016\u0005\bA\u0002\u0001\r\u0011\"\u0003b\u0011\u0019\u0019\u0007\u0001)Q\u00051\")A\r\u0001C\u0005K\")q\r\u0001C\u0005Q\")!\u000e\u0001C!W\")Q\u000e\u0001C\u0005]\")\u0001\u000f\u0001C\u0001c\")Q\u000f\u0001C\u0001m\")q\u000f\u0001C\u0001q\n\u0019rK]1qa\u0016$\u0017I\u001d:bs\n+\u0018\u000e\u001c3fe*\u0011q\u0003G\u0001\b[V$\u0018M\u00197f\u0015\tI\"$\u0001\u0006d_2dWm\u0019;j_:T\u0011aG\u0001\u0006g\u000e\fG.Y\u0002\u0001+\tq\u0012fE\u0002\u0001?\r\u0002\"\u0001I\u0011\u000e\u0003iI!A\t\u000e\u0003\r\u0005s\u0017PU3g!\u0011!Se\n\u001a\u000e\u0003YI!A\n\f\u0003\u001fI+Wo]1cY\u0016\u0014U/\u001b7eKJ\u0004\"\u0001K\u0015\r\u0001\u0011)!\u0006\u0001b\u0001W\t\t\u0011)\u0005\u0002-_A\u0011\u0001%L\u0005\u0003]i\u0011qAT8uQ&tw\r\u0005\u0002!a%\u0011\u0011G\u0007\u0002\u0004\u0003:L\bc\u0001\u00134O%\u0011AG\u0006\u0002\r/J\f\u0007\u000f]3e\u0003J\u0014\u0018-_\u0001\u0004i\u0006<\u0007cA\u001c;O5\t\u0001H\u0003\u0002:5\u00059!/\u001a4mK\u000e$\u0018BA\u001e9\u0005!\u0019E.Y:t)\u0006<\u0017A\u0002\u001fj]&$h\b\u0006\u0002?\u007fA\u0019A\u0005A\u0014\t\u000bU\u0012\u0001\u0019\u0001\u001c\u0002\u00115\fg.\u001b4fgR,\u0012A\u000e\u0015\u0005\u0007\r3\u0005\n\u0005\u0002!\t&\u0011QI\u0007\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%A$\u0002\u001fU\u001cX\r\t;bO\u0002Jgn\u001d;fC\u0012\f\u0013!S\u0001\u0007e9\n\u0004G\f\u0019\u0002\u00135\fg.\u001b4fgR\u0004\u0003\u0006\u0002\u0003D\r\"\u000bQ!\u001a7f[N,\u0012AM\u0001\nK2,Wn]0%KF$\"\u0001U*\u0011\u0005\u0001\n\u0016B\u0001*\u001b\u0005\u0011)f.\u001b;\t\u000fQ3\u0011\u0011!a\u0001e\u0005\u0019\u0001\u0010J\u0019\u0002\r\u0015dW-\\:!\u0003!\u0019\u0017\r]1dSRLX#\u0001-\u0011\u0005\u0001J\u0016B\u0001.\u001b\u0005\rIe\u000e^\u0001\rG\u0006\u0004\u0018mY5us~#S-\u001d\u000b\u0003!vCq\u0001V\u0005\u0002\u0002\u0003\u0007\u0001,A\u0005dCB\f7-\u001b;zA\u0005!1/\u001b>f\u0003!\u0019\u0018N_3`I\u0015\fHC\u0001)c\u0011\u001d!F\"!AA\u0002a\u000bQa]5{K\u0002\nq!\\6BeJ\f\u0017\u0010\u0006\u00023M\")qL\u0004a\u00011\u00061!/Z:ju\u0016$\"\u0001U5\t\u000b}{\u0001\u0019\u0001-\u0002\u0011ML'0\u001a%j]R$\"\u0001\u00157\t\u000b}\u0003\u0002\u0019\u0001-\u0002\u0015\u0015t7/\u001e:f'&TX\r\u0006\u0002Q_\")q,\u0005a\u00011\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0002sg6\t\u0001\u0001C\u0003u%\u0001\u0007q%\u0001\u0003fY\u0016l\u0017!B2mK\u0006\u0014H#\u0001)\u0002\rI,7/\u001e7u)\u0005\u0011\u0004")
public class WrappedArrayBuilder<A>
implements ReusableBuilder<A, WrappedArray<A>> {
    private final ClassTag<A> tag;
    private final ClassTag<A> manifest;
    private WrappedArray<A> elems;
    private int capacity;
    private int size;

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<A, NewTo> mapResult(Function1<WrappedArray<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    public ClassTag<A> manifest() {
        return this.manifest;
    }

    private WrappedArray<A> elems() {
        return this.elems;
    }

    private void elems_$eq(WrappedArray<A> x$1) {
        this.elems = x$1;
    }

    private int capacity() {
        return this.capacity;
    }

    private void capacity_$eq(int x$1) {
        this.capacity = x$1;
    }

    private int size() {
        return this.size;
    }

    private void size_$eq(int x$1) {
        this.size = x$1;
    }

    private WrappedArray<A> mkArray(int size) {
        WrappedArray.ofRef<Object> newelems;
        WrappedArray wrappedArray;
        Class<?> runtimeClass = this.tag.runtimeClass();
        if (runtimeClass.isPrimitive()) {
            WrappedArray wrappedArray2;
            Class<Integer> clazz = Integer.TYPE;
            if (clazz != null && clazz.equals(runtimeClass)) {
                wrappedArray2 = new WrappedArray.ofInt(new int[size]);
            } else {
                Class<Double> clazz2 = Double.TYPE;
                if (clazz2 != null && clazz2.equals(runtimeClass)) {
                    wrappedArray2 = new WrappedArray.ofDouble(new double[size]);
                } else {
                    Class<Long> clazz3 = Long.TYPE;
                    if (clazz3 != null && clazz3.equals(runtimeClass)) {
                        wrappedArray2 = new WrappedArray.ofLong(new long[size]);
                    } else {
                        Class<Float> clazz4 = Float.TYPE;
                        if (clazz4 != null && clazz4.equals(runtimeClass)) {
                            wrappedArray2 = new WrappedArray.ofFloat(new float[size]);
                        } else {
                            Class<Character> clazz5 = Character.TYPE;
                            if (clazz5 != null && clazz5.equals(runtimeClass)) {
                                wrappedArray2 = new WrappedArray.ofChar(new char[size]);
                            } else {
                                Class<Byte> clazz6 = Byte.TYPE;
                                if (clazz6 != null && clazz6.equals(runtimeClass)) {
                                    wrappedArray2 = new WrappedArray.ofByte(new byte[size]);
                                } else {
                                    Class<Short> clazz7 = Short.TYPE;
                                    if (clazz7 != null && clazz7.equals(runtimeClass)) {
                                        wrappedArray2 = new WrappedArray.ofShort(new short[size]);
                                    } else {
                                        Class<Boolean> clazz8 = Boolean.TYPE;
                                        if (clazz8 != null && clazz8.equals(runtimeClass)) {
                                            wrappedArray2 = new WrappedArray.ofBoolean(new boolean[size]);
                                        } else {
                                            Class<Void> clazz9 = Void.TYPE;
                                            if (clazz9 != null && clazz9.equals(runtimeClass)) {
                                                wrappedArray2 = new WrappedArray.ofUnit(new BoxedUnit[size]);
                                            } else {
                                                throw new MatchError(runtimeClass);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            wrappedArray = wrappedArray2;
        } else {
            wrappedArray = newelems = new WrappedArray.ofRef<Object>((Object[])this.tag.newArray(size));
        }
        if (this.size() > 0) {
            Array$.MODULE$.copy(this.elems().array(), 0, ((WrappedArray)newelems).array(), 0, this.size());
        }
        return newelems;
    }

    private void resize(int size) {
        this.elems_$eq(this.mkArray(size));
        this.capacity_$eq(size);
    }

    @Override
    public void sizeHint(int size) {
        if (this.capacity() < size) {
            this.resize(size);
        }
    }

    private void ensureSize(int size) {
        if (this.capacity() < size) {
            int newsize;
            int n = newsize = this.capacity() == 0 ? 16 : this.capacity() * 2;
            while (newsize < size) {
                newsize *= 2;
            }
            this.resize(newsize);
        }
    }

    @Override
    public WrappedArrayBuilder<A> $plus$eq(A elem) {
        this.ensureSize(this.size() + 1);
        this.elems().update(this.size(), elem);
        this.size_$eq(this.size() + 1);
        return this;
    }

    @Override
    public void clear() {
        this.size_$eq(0);
    }

    @Override
    public WrappedArray<A> result() {
        if (this.capacity() != 0 && this.capacity() == this.size()) {
            this.capacity_$eq(0);
            return this.elems();
        }
        return this.mkArray(this.size());
    }

    public WrappedArrayBuilder(ClassTag<A> tag) {
        this.tag = tag;
        Growable.$init$(this);
        Builder.$init$(this);
        this.manifest = tag;
        this.capacity = 0;
        this.size = 0;
    }
}

