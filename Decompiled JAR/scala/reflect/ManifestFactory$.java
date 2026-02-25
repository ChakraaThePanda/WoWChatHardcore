/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import scala.None$;
import scala.Predef$;
import scala.Some;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.reflect.AnyValManifest;
import scala.reflect.Manifest;
import scala.reflect.ManifestFactory;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.Null$;

public final class ManifestFactory$ {
    public static ManifestFactory$ MODULE$;
    private final AnyValManifest<Object> Byte;
    private final AnyValManifest<Object> Short;
    private final AnyValManifest<Object> Char;
    private final AnyValManifest<Object> Int;
    private final AnyValManifest<Object> Long;
    private final AnyValManifest<Object> Float;
    private final AnyValManifest<Object> Double;
    private final AnyValManifest<Object> Boolean;
    private final AnyValManifest<BoxedUnit> Unit;
    private final Class<Object> scala$reflect$ManifestFactory$$ObjectTYPE;
    private final Class<Nothing$> scala$reflect$ManifestFactory$$NothingTYPE;
    private final Class<Null$> scala$reflect$ManifestFactory$$NullTYPE;
    private final Manifest<Object> Any;
    private final Manifest<Object> Object;
    private final Manifest<Object> AnyRef;
    private final Manifest<Object> AnyVal;
    private final Manifest<Null$> Null;
    private final Manifest<Nothing$> Nothing;

    static {
        new ManifestFactory$();
    }

    public List<AnyValManifest<?>> valueManifests() {
        return List$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new AnyValManifest[]{this.Byte(), this.Short(), this.Char(), this.Int(), this.Long(), this.Float(), this.Double(), this.Boolean(), this.Unit()}));
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

    public Class<Object> scala$reflect$ManifestFactory$$ObjectTYPE() {
        return this.scala$reflect$ManifestFactory$$ObjectTYPE;
    }

    public Class<Nothing$> scala$reflect$ManifestFactory$$NothingTYPE() {
        return this.scala$reflect$ManifestFactory$$NothingTYPE;
    }

    public Class<Null$> scala$reflect$ManifestFactory$$NullTYPE() {
        return this.scala$reflect$ManifestFactory$$NullTYPE;
    }

    public Manifest<Object> Any() {
        return this.Any;
    }

    public Manifest<Object> Object() {
        return this.Object;
    }

    public Manifest<Object> AnyRef() {
        return this.AnyRef;
    }

    public Manifest<Object> AnyVal() {
        return this.AnyVal;
    }

    public Manifest<Null$> Null() {
        return this.Null;
    }

    public Manifest<Nothing$> Nothing() {
        return this.Nothing;
    }

    public <T> Manifest<T> singleType(Object value) {
        return new ManifestFactory.SingletonTypeManifest(value);
    }

    public <T> Manifest<T> classType(Class<?> clazz) {
        return new ManifestFactory.ClassTypeManifest(None$.MODULE$, clazz, Nil$.MODULE$);
    }

    public <T> Manifest<T> classType(Class<T> clazz, Manifest<?> arg1, Seq<Manifest<?>> args2) {
        return new ManifestFactory.ClassTypeManifest(None$.MODULE$, clazz, args2.toList().$colon$colon(arg1));
    }

    public <T> Manifest<T> classType(Manifest<?> prefix, Class<?> clazz, Seq<Manifest<?>> args2) {
        return new ManifestFactory.ClassTypeManifest(new Some(prefix), clazz, args2.toList());
    }

    public <T> Manifest<Object> arrayType(Manifest<?> arg) {
        return arg.arrayManifest();
    }

    public <T> Manifest<T> abstractType(Manifest<?> prefix, String name, Class<?> upperBound, Seq<Manifest<?>> args2) {
        return new ManifestFactory.AbstractTypeManifest(prefix, name, upperBound, args2);
    }

    public <T> Manifest<T> wildcardType(Manifest<?> lowerBound, Manifest<?> upperBound) {
        return new ManifestFactory.WildcardManifest(lowerBound, upperBound);
    }

    public <T> Manifest<T> intersectionType(Seq<Manifest<?>> parents) {
        return new ManifestFactory.IntersectionTypeManifest(parents);
    }

    private ManifestFactory$() {
        MODULE$ = this;
        this.Byte = new ManifestFactory.ByteManifest();
        this.Short = new ManifestFactory.ShortManifest();
        this.Char = new ManifestFactory.CharManifest();
        this.Int = new ManifestFactory.IntManifest();
        this.Long = new ManifestFactory.LongManifest();
        this.Float = new ManifestFactory.FloatManifest();
        this.Double = new ManifestFactory.DoubleManifest();
        this.Boolean = new ManifestFactory.BooleanManifest();
        this.Unit = new ManifestFactory.UnitManifest();
        this.scala$reflect$ManifestFactory$$ObjectTYPE = Object.class;
        this.scala$reflect$ManifestFactory$$NothingTYPE = Nothing$.class;
        this.scala$reflect$ManifestFactory$$NullTYPE = Null$.class;
        this.Any = new ManifestFactory.AnyManifest();
        this.Object = new ManifestFactory.ObjectManifest();
        this.AnyRef = this.Object();
        this.AnyVal = new ManifestFactory.AnyValPhantomManifest();
        this.Null = new ManifestFactory.NullManifest();
        this.Nothing = new ManifestFactory.NothingManifest();
    }
}

