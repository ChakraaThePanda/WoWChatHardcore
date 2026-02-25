/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.ClassfileConstants$FlagTranslation$;
import scala.reflect.internal.JavaAccFlags;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;

public final class JavaAccFlags$ {
    public static JavaAccFlags$ MODULE$;
    private final int Unknown;
    private final int Class;
    private final int Field;
    private final int Method;
    private final int Constructor;

    static {
        new JavaAccFlags$();
    }

    private int Unknown() {
        return this.Unknown;
    }

    private int Class() {
        return this.Class;
    }

    private int Field() {
        return this.Field;
    }

    private int Method() {
        return this.Method;
    }

    private int Constructor() {
        return this.Constructor;
    }

    private int create(int flagCarrier, int access_flags) {
        return flagCarrier << 16 | access_flags & 0xFFFF;
    }

    public int classFlags(int flags) {
        return this.create(this.Class(), flags);
    }

    public int methodFlags(int flags) {
        return this.create(this.Method(), flags);
    }

    public int fieldFlags(int flags) {
        return this.create(this.Field(), flags);
    }

    public int constructorFlags(int flags) {
        return this.create(this.Constructor(), flags);
    }

    public int apply(int access_flags) {
        return this.create(this.Unknown(), access_flags);
    }

    public int apply(Class<?> clazz) {
        return this.classFlags(clazz.getModifiers());
    }

    public int apply(Member member) {
        int n;
        if (member instanceof Constructor) {
            Constructor constructor = (Constructor)member;
            n = this.constructorFlags(constructor.getModifiers());
        } else if (member instanceof Method) {
            Method method = (Method)member;
            n = this.methodFlags(method.getModifiers());
        } else if (member instanceof Field) {
            Field field2 = (Field)member;
            n = this.fieldFlags(field2.getModifiers());
        } else {
            n = this.apply(member.getModifiers());
        }
        return n;
    }

    public final boolean has$extension(int $this, int mask) {
        return (this.flags$extension($this) & mask) != 0;
    }

    public final int flagCarrierId$extension(int $this) {
        return $this >>> 16;
    }

    public final int flags$extension(int $this) {
        return $this & 0xFFFF;
    }

    public final boolean isAbstract$extension(int $this) {
        return this.has$extension($this, 1024);
    }

    public final boolean isAnnotation$extension(int $this) {
        return this.has$extension($this, 8192);
    }

    public final boolean isBridge$extension(int $this) {
        return this.has$extension($this, 64);
    }

    public final boolean isEnum$extension(int $this) {
        return this.has$extension($this, 16384);
    }

    public final boolean isFinal$extension(int $this) {
        return this.has$extension($this, 16);
    }

    public final boolean isInterface$extension(int $this) {
        return this.has$extension($this, 512);
    }

    public final boolean isNative$extension(int $this) {
        return this.has$extension($this, 256);
    }

    public final boolean isPrivate$extension(int $this) {
        return this.has$extension($this, 2);
    }

    public final boolean isProtected$extension(int $this) {
        return this.has$extension($this, 4);
    }

    public final boolean isPublic$extension(int $this) {
        return this.has$extension($this, 1);
    }

    public final boolean isStatic$extension(int $this) {
        return this.has$extension($this, 8);
    }

    public final boolean isStrictFp$extension(int $this) {
        return this.has$extension($this, 2048);
    }

    public final boolean isSuper$extension(int $this) {
        return this.has$extension($this, 32);
    }

    public final boolean isSynchronized$extension(int $this) {
        return this.has$extension($this, 32);
    }

    public final boolean isSynthetic$extension(int $this) {
        return this.has$extension($this, 4096);
    }

    public final boolean isTransient$extension(int $this) {
        return this.has$extension($this, 128);
    }

    public final boolean isVarargs$extension(int $this) {
        return this.has$extension($this, 128);
    }

    public final boolean isVolatile$extension(int $this) {
        return this.has$extension($this, 64);
    }

    public final boolean hasPackageAccessBoundary$extension(int $this) {
        return !this.has$extension($this, 3);
    }

    public final boolean isPackageProtected$extension(int $this) {
        return !this.has$extension($this, 7);
    }

    public final int toJavaFlags$extension(int $this) {
        return this.flags$extension($this);
    }

    public final long toScalaFlags$extension(int $this) {
        int n = this.flagCarrierId$extension($this);
        boolean bl = this.Method() == n ? true : this.Constructor() == n;
        long l = bl ? ClassfileConstants$FlagTranslation$.MODULE$.methodFlags(this.flags$extension($this)) : (this.Class() == n ? ClassfileConstants$FlagTranslation$.MODULE$.classFlags(this.flags$extension($this)) : ClassfileConstants$FlagTranslation$.MODULE$.fieldFlags(this.flags$extension($this)));
        return l;
    }

    /*
     * WARNING - void declaration
     */
    public final List<AnnotationInfos.AnnotationInfo> toScalaAnnotations$extension(int $this, SymbolTable syms) {
        void var3_3;
        List anns = Nil$.MODULE$;
        if (this.isNative$extension($this)) {
            anns = anns.$colon$colon(JavaAccFlags$.annInfo$1(syms.definitions().NativeAttr(), syms));
        }
        if (this.isTransient$extension($this)) {
            anns = anns.$colon$colon(JavaAccFlags$.annInfo$1(syms.definitions().TransientAttr(), syms));
        }
        if (this.isVolatile$extension($this)) {
            anns = anns.$colon$colon(JavaAccFlags$.annInfo$1(syms.definitions().VolatileAttr(), syms));
        }
        return var3_3;
    }

    public final int hashCode$extension(int $this) {
        return Integer.hashCode($this);
    }

    public final boolean equals$extension(int $this, Object x$1) {
        int n;
        boolean bl = x$1 instanceof JavaAccFlags;
        return bl && $this == (n = ((JavaAccFlags)x$1).coded());
    }

    private static final AnnotationInfos.AnnotationInfo annInfo$1(Symbols.ClassSymbol asym, SymbolTable syms$1) {
        return syms$1.AnnotationInfo().apply(asym.tpe(), Nil$.MODULE$, Nil$.MODULE$);
    }

    private JavaAccFlags$() {
        MODULE$ = this;
        this.Unknown = 0;
        this.Class = 1;
        this.Field = 2;
        this.Method = 3;
        this.Constructor = 4;
    }
}

