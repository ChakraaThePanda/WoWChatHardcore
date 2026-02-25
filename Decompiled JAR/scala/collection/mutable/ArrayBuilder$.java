/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.collection.mutable.ArrayBuilder;
import scala.reflect.ClassTag;

public final class ArrayBuilder$
implements Serializable {
    public static ArrayBuilder$ MODULE$;

    static {
        new ArrayBuilder$();
    }

    public <T> ArrayBuilder<T> make(ClassTag<T> evidence$1) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        ClassTag<T> tag = evidence$1;
        Class<?> cls = tag.runtimeClass();
        if (cls.isPrimitive()) {
            ArrayBuilder arrayBuilder;
            Class<Integer> clazz = Integer.TYPE;
            if (clazz != null && clazz.equals(cls)) {
                arrayBuilder = new ArrayBuilder.ofInt();
            } else {
                Class<Double> clazz2 = Double.TYPE;
                if (clazz2 != null && clazz2.equals(cls)) {
                    arrayBuilder = new ArrayBuilder.ofDouble();
                } else {
                    Class<Long> clazz3 = Long.TYPE;
                    if (clazz3 != null && clazz3.equals(cls)) {
                        arrayBuilder = new ArrayBuilder.ofLong();
                    } else {
                        Class<Float> clazz4 = Float.TYPE;
                        if (clazz4 != null && clazz4.equals(cls)) {
                            arrayBuilder = new ArrayBuilder.ofFloat();
                        } else {
                            Class<Character> clazz5 = Character.TYPE;
                            if (clazz5 != null && clazz5.equals(cls)) {
                                arrayBuilder = new ArrayBuilder.ofChar();
                            } else {
                                Class<Byte> clazz6 = Byte.TYPE;
                                if (clazz6 != null && clazz6.equals(cls)) {
                                    arrayBuilder = new ArrayBuilder.ofByte();
                                } else {
                                    Class<Short> clazz7 = Short.TYPE;
                                    if (clazz7 != null && clazz7.equals(cls)) {
                                        arrayBuilder = new ArrayBuilder.ofShort();
                                    } else {
                                        Class<Boolean> clazz8 = Boolean.TYPE;
                                        if (clazz8 != null && clazz8.equals(cls)) {
                                            arrayBuilder = new ArrayBuilder.ofBoolean();
                                        } else {
                                            Class<Void> clazz9 = Void.TYPE;
                                            if (clazz9 != null && clazz9.equals(cls)) {
                                                arrayBuilder = new ArrayBuilder.ofUnit();
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
            return arrayBuilder;
        }
        return new ArrayBuilder.ofRef<T>(tag);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private ArrayBuilder$() {
        MODULE$ = this;
    }
}

