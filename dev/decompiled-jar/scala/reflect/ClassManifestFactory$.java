/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import scala.MatchError;
import scala.None$;
import scala.Predef$;
import scala.Some;
import scala.collection.Seq;
import scala.collection.immutable.Nil$;
import scala.reflect.AnyValManifest;
import scala.reflect.ClassManifestFactory;
import scala.reflect.ClassTag;
import scala.reflect.ClassTypeManifest;
import scala.reflect.Manifest;
import scala.reflect.ManifestFactory$;
import scala.reflect.NoManifest$;
import scala.reflect.OptManifest;
import scala.reflect.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.Null$;

public final class ClassManifestFactory$ {
    public static ClassManifestFactory$ MODULE$;
    private final AnyValManifest<Object> Byte;
    private final AnyValManifest<Object> Short;
    private final AnyValManifest<Object> Char;
    private final AnyValManifest<Object> Int;
    private final AnyValManifest<Object> Long;
    private final AnyValManifest<Object> Float;
    private final AnyValManifest<Object> Double;
    private final AnyValManifest<Object> Boolean;
    private final AnyValManifest<BoxedUnit> Unit;
    private final Manifest<Object> Any;
    private final Manifest<Object> Object;
    private final Manifest<Object> AnyVal;
    private final Manifest<Nothing$> Nothing;
    private final Manifest<Null$> Null;

    static {
        new ClassManifestFactory$();
    }

    public AnyValManifest<Object> Byte() {
        return this.Byte;
    }

    public AnyValManifest<Object> Short() {
        return this.Short;
    }

    public AnyValManifest<Object> Char() {
        return this.Char;
    }

    public AnyValManifest<Object> Int() {
        return this.Int;
    }

    public AnyValManifest<Object> Long() {
        return this.Long;
    }

    public AnyValManifest<Object> Float() {
        return this.Float;
    }

    public AnyValManifest<Object> Double() {
        return this.Double;
    }

    public AnyValManifest<Object> Boolean() {
        return this.Boolean;
    }

    public AnyValManifest<BoxedUnit> Unit() {
        return this.Unit;
    }

    public Manifest<Object> Any() {
        return this.Any;
    }

    public Manifest<Object> Object() {
        return this.Object;
    }

    public Manifest<Object> AnyVal() {
        return this.AnyVal;
    }

    public Manifest<Nothing$> Nothing() {
        return this.Nothing;
    }

    public Manifest<Null$> Null() {
        return this.Null;
    }

    public <T> ClassTag<T> fromClass(Class<T> clazz) {
        ClassTag<Object> classTag;
        Class<Byte> clazz2 = java.lang.Byte.TYPE;
        if (!(clazz2 != null ? !clazz2.equals(clazz) : clazz != null)) {
            classTag = this.Byte();
        } else {
            Class<Short> clazz3 = java.lang.Short.TYPE;
            if (!(clazz3 != null ? !clazz3.equals(clazz) : clazz != null)) {
                classTag = this.Short();
            } else {
                Class<Character> clazz4 = Character.TYPE;
                if (!(clazz4 != null ? !clazz4.equals(clazz) : clazz != null)) {
                    classTag = this.Char();
                } else {
                    Class<Integer> clazz5 = Integer.TYPE;
                    if (!(clazz5 != null ? !clazz5.equals(clazz) : clazz != null)) {
                        classTag = this.Int();
                    } else {
                        Class<Long> clazz6 = java.lang.Long.TYPE;
                        if (!(clazz6 != null ? !clazz6.equals(clazz) : clazz != null)) {
                            classTag = this.Long();
                        } else {
                            Class<Float> clazz7 = java.lang.Float.TYPE;
                            if (!(clazz7 != null ? !clazz7.equals(clazz) : clazz != null)) {
                                classTag = this.Float();
                            } else {
                                Class<Double> clazz8 = java.lang.Double.TYPE;
                                if (!(clazz8 != null ? !clazz8.equals(clazz) : clazz != null)) {
                                    classTag = this.Double();
                                } else {
                                    Class<Boolean> clazz9 = java.lang.Boolean.TYPE;
                                    if (!(clazz9 != null ? !clazz9.equals(clazz) : clazz != null)) {
                                        classTag = this.Boolean();
                                    } else {
                                        Class<Void> clazz10 = Void.TYPE;
                                        classTag = !(clazz10 != null ? !clazz10.equals(clazz) : clazz != null) ? this.Unit() : this.classType(clazz);
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

    public <T> Manifest<T> singleType(Object value) {
        return package$.MODULE$.Manifest().singleType(value);
    }

    public <T> ClassTag<T> classType(Class<?> clazz) {
        return new ClassTypeManifest(None$.MODULE$, clazz, Nil$.MODULE$);
    }

    public <T> ClassTag<T> classType(Class<?> clazz, OptManifest<?> arg1, Seq<OptManifest<?>> args2) {
        return new ClassTypeManifest(None$.MODULE$, clazz, args2.toList().$colon$colon(arg1));
    }

    public <T> ClassTag<T> classType(OptManifest<?> prefix, Class<?> clazz, Seq<OptManifest<?>> args2) {
        return new ClassTypeManifest(new Some(prefix), clazz, args2.toList());
    }

    public <T> ClassTag<Object> arrayType(OptManifest<?> arg) {
        ClassTag<Object> classTag;
        if (NoManifest$.MODULE$.equals(arg)) {
            classTag = this.Object();
        } else if (arg instanceof ClassTag) {
            classTag = ((ClassTag)arg).arrayManifest();
        } else {
            throw new MatchError(arg);
        }
        return classTag;
    }

    public <T> ClassTag<T> abstractType(OptManifest<?> prefix, String name, Class<?> clazz, Seq<OptManifest<?>> args2) {
        return new ClassManifestFactory.AbstractTypeClassManifest(prefix, name, clazz, Predef$.MODULE$.wrapRefArray((Object[])new OptManifest[0]));
    }

    public <T> ClassTag<T> abstractType(OptManifest<?> prefix, String name, ClassTag<?> upperbound, Seq<OptManifest<?>> args2) {
        return new ClassManifestFactory.AbstractTypeClassManifest(prefix, name, upperbound.runtimeClass(), Predef$.MODULE$.wrapRefArray((Object[])new OptManifest[0]));
    }

    private ClassManifestFactory$() {
        MODULE$ = this;
        this.Byte = ManifestFactory$.MODULE$.Byte();
        this.Short = ManifestFactory$.MODULE$.Short();
        this.Char = ManifestFactory$.MODULE$.Char();
        this.Int = ManifestFactory$.MODULE$.Int();
        this.Long = ManifestFactory$.MODULE$.Long();
        this.Float = ManifestFactory$.MODULE$.Float();
        this.Double = ManifestFactory$.MODULE$.Double();
        this.Boolean = ManifestFactory$.MODULE$.Boolean();
        this.Unit = ManifestFactory$.MODULE$.Unit();
        this.Any = ManifestFactory$.MODULE$.Any();
        this.Object = ManifestFactory$.MODULE$.Object();
        this.AnyVal = ManifestFactory$.MODULE$.AnyVal();
        this.Nothing = ManifestFactory$.MODULE$.Nothing();
        this.Null = ManifestFactory$.MODULE$.Null();
    }
}

