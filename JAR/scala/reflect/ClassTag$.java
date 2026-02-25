/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import scala.MatchError;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.reflect.ClassTag;
import scala.reflect.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.Null$;

public final class ClassTag$
implements Serializable {
    public static ClassTag$ MODULE$;
    private final Class<Object> scala$reflect$ClassTag$$ObjectTYPE;
    private final Class<Nothing$> scala$reflect$ClassTag$$NothingTYPE;
    private final Class<Null$> scala$reflect$ClassTag$$NullTYPE;
    private final ClassTag<Object> Byte;
    private final ClassTag<Object> Short;
    private final ClassTag<Object> Char;
    private final ClassTag<Object> Int;
    private final ClassTag<Object> Long;
    private final ClassTag<Object> Float;
    private final ClassTag<Object> Double;
    private final ClassTag<Object> Boolean;
    private final ClassTag<BoxedUnit> Unit;
    private final ClassTag<Object> Any;
    private final ClassTag<Object> Object;
    private final ClassTag<Object> AnyVal;
    private final ClassTag<Object> AnyRef;
    private final ClassTag<Nothing$> Nothing;
    private final ClassTag<Null$> Null;
    private final ClassValue<ClassTag<?>> cache;

    static {
        new ClassTag$();
    }

    public Class<Object> scala$reflect$ClassTag$$ObjectTYPE() {
        return this.scala$reflect$ClassTag$$ObjectTYPE;
    }

    public Class<Nothing$> scala$reflect$ClassTag$$NothingTYPE() {
        return this.scala$reflect$ClassTag$$NothingTYPE;
    }

    public Class<Null$> scala$reflect$ClassTag$$NullTYPE() {
        return this.scala$reflect$ClassTag$$NullTYPE;
    }

    public ClassTag<Object> Byte() {
        return this.Byte;
    }

    public ClassTag<Object> Short() {
        return this.Short;
    }

    public ClassTag<Object> Char() {
        return this.Char;
    }

    public ClassTag<Object> Int() {
        return this.Int;
    }

    public ClassTag<Object> Long() {
        return this.Long;
    }

    public ClassTag<Object> Float() {
        return this.Float;
    }

    public ClassTag<Object> Double() {
        return this.Double;
    }

    public ClassTag<Object> Boolean() {
        return this.Boolean;
    }

    public ClassTag<BoxedUnit> Unit() {
        return this.Unit;
    }

    public ClassTag<Object> Any() {
        return this.Any;
    }

    public ClassTag<Object> Object() {
        return this.Object;
    }

    public ClassTag<Object> AnyVal() {
        return this.AnyVal;
    }

    public ClassTag<Object> AnyRef() {
        return this.AnyRef;
    }

    public ClassTag<Nothing$> Nothing() {
        return this.Nothing;
    }

    public ClassTag<Null$> Null() {
        return this.Null;
    }

    public <T> ClassTag<T> apply(Class<?> runtimeClass1) {
        return this.cache.get(runtimeClass1);
    }

    public <T> Option<Class<?>> unapply(ClassTag<T> ctag) {
        return new Some(ctag.runtimeClass());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private ClassTag$() {
        MODULE$ = this;
        this.scala$reflect$ClassTag$$ObjectTYPE = Object.class;
        this.scala$reflect$ClassTag$$NothingTYPE = Nothing$.class;
        this.scala$reflect$ClassTag$$NullTYPE = Null$.class;
        this.Byte = package$.MODULE$.Manifest().Byte();
        this.Short = package$.MODULE$.Manifest().Short();
        this.Char = package$.MODULE$.Manifest().Char();
        this.Int = package$.MODULE$.Manifest().Int();
        this.Long = package$.MODULE$.Manifest().Long();
        this.Float = package$.MODULE$.Manifest().Float();
        this.Double = package$.MODULE$.Manifest().Double();
        this.Boolean = package$.MODULE$.Manifest().Boolean();
        this.Unit = package$.MODULE$.Manifest().Unit();
        this.Any = package$.MODULE$.Manifest().Any();
        this.Object = package$.MODULE$.Manifest().Object();
        this.AnyVal = package$.MODULE$.Manifest().AnyVal();
        this.AnyRef = package$.MODULE$.Manifest().AnyRef();
        this.Nothing = package$.MODULE$.Manifest().Nothing();
        this.Null = package$.MODULE$.Manifest().Null();
        this.cache = new ClassValue<ClassTag<?>>(){

            public ClassTag<?> computeValue(Class<?> runtimeClass) {
                ClassTag<Object> classTag;
                if (runtimeClass.isPrimitive()) {
                    classTag = this.primitiveClassTag(runtimeClass);
                } else {
                    Class<Object> clazz = ClassTag$.MODULE$.scala$reflect$ClassTag$$ObjectTYPE();
                    if (clazz != null && clazz.equals(runtimeClass)) {
                        classTag = ClassTag$.MODULE$.Object();
                    } else {
                        Class<Nothing$> clazz2 = ClassTag$.MODULE$.scala$reflect$ClassTag$$NothingTYPE();
                        if (clazz2 != null && clazz2.equals(runtimeClass)) {
                            classTag = ClassTag$.MODULE$.Nothing();
                        } else {
                            Class<Null$> clazz3 = ClassTag$.MODULE$.scala$reflect$ClassTag$$NullTYPE();
                            classTag = clazz3 != null && clazz3.equals(runtimeClass) ? ClassTag$.MODULE$.Null() : new ClassTag.GenericClassTag<?>(runtimeClass);
                        }
                    }
                }
                return classTag;
            }

            private <T> ClassTag<?> primitiveClassTag(Class<?> runtimeClass) {
                ClassTag<Object> classTag;
                Class<Byte> clazz = java.lang.Byte.TYPE;
                if (!(clazz != null ? !clazz.equals(runtimeClass) : runtimeClass != null)) {
                    classTag = ClassTag$.MODULE$.Byte();
                } else {
                    Class<Short> clazz2 = java.lang.Short.TYPE;
                    if (!(clazz2 != null ? !clazz2.equals(runtimeClass) : runtimeClass != null)) {
                        classTag = ClassTag$.MODULE$.Short();
                    } else {
                        Class<Character> clazz3 = Character.TYPE;
                        if (!(clazz3 != null ? !clazz3.equals(runtimeClass) : runtimeClass != null)) {
                            classTag = ClassTag$.MODULE$.Char();
                        } else {
                            Class<Integer> clazz4 = Integer.TYPE;
                            if (!(clazz4 != null ? !clazz4.equals(runtimeClass) : runtimeClass != null)) {
                                classTag = ClassTag$.MODULE$.Int();
                            } else {
                                Class<Long> clazz5 = java.lang.Long.TYPE;
                                if (!(clazz5 != null ? !clazz5.equals(runtimeClass) : runtimeClass != null)) {
                                    classTag = ClassTag$.MODULE$.Long();
                                } else {
                                    Class<Float> clazz6 = java.lang.Float.TYPE;
                                    if (!(clazz6 != null ? !clazz6.equals(runtimeClass) : runtimeClass != null)) {
                                        classTag = ClassTag$.MODULE$.Float();
                                    } else {
                                        Class<Double> clazz7 = java.lang.Double.TYPE;
                                        if (!(clazz7 != null ? !clazz7.equals(runtimeClass) : runtimeClass != null)) {
                                            classTag = ClassTag$.MODULE$.Double();
                                        } else {
                                            Class<Boolean> clazz8 = java.lang.Boolean.TYPE;
                                            if (!(clazz8 != null ? !clazz8.equals(runtimeClass) : runtimeClass != null)) {
                                                classTag = ClassTag$.MODULE$.Boolean();
                                            } else {
                                                Class<Void> clazz9 = Void.TYPE;
                                                if (!(clazz9 != null ? !clazz9.equals(runtimeClass) : runtimeClass != null)) {
                                                    classTag = ClassTag$.MODULE$.Unit();
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
                return classTag;
            }
        };
    }
}

