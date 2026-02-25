/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.transform;

import scala.Function0;
import scala.Serializable;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.tpe.TypeMaps;
import scala.reflect.internal.transform.Erasure;
import scala.reflect.internal.transform.Erasure$GenericArray$;
import scala.reflect.internal.transform.Erasure$boxingErasure$;
import scala.reflect.internal.transform.Erasure$javaErasure$;
import scala.reflect.internal.transform.Erasure$scalaErasure$;
import scala.reflect.internal.transform.Erasure$specialScalaErasure$;
import scala.reflect.internal.transform.Erasure$verifiedJavaErasure$;
import scala.reflect.internal.transform.PostErasure;
import scala.reflect.internal.transform.PostErasure$elimErasedValueType$;
import scala.reflect.internal.transform.Transforms$;
import scala.reflect.internal.transform.UnCurry;
import scala.reflect.internal.transform.UnCurry$DesugaredParameterType$;
import scala.reflect.internal.transform.UnCurry$VarargsSymbolAttachment$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005c!C\u000b\u0017!\u0003\r\taHA\u001d\u0011\u0015!\u0003\u0001\"\u0001&\r\u0011I\u0003\u0001\u0002\u0016\t\u00111\u0012!\u0011!S\u0001\n5BQa\u000f\u0002\u0005\u0002qB\u0011\u0002\u0011\u0002A\u0002\u0003\u0007I\u0011B!\t\u0013\t\u0013\u0001\u0019!a\u0001\n\u0013\u0019\u0005\"\u0003$\u0003\u0001\u0004\u0005\t\u0015)\u00031\u0011\u001d9%\u00011A\u0005\n!Cq\u0001\u0014\u0002A\u0002\u0013%Q\n\u0003\u0004P\u0005\u0001\u0006K!\u0013\u0005\u0006!\n!\t\u0001\u0013\u0005\u0006#\n!\t!\u0011\u0005\b%\u0002\u0011\r\u0011\"\u0003T\u0011\u001dy\u0006A1A\u0005\n\u0001Dq\u0001\u001b\u0001C\u0002\u0013%\u0011\u000eC\u0003r\u0001\u0011\u0005!\u000fC\u0003t\u0001\u0011\u0005A\u000fC\u0003v\u0001\u0011\u0005a\u000fC\u0003x\u0001\u0011\u0005\u0001\u0010\u0003\u0004x\u0001\u0011\u0005\u0011\u0011\u0005\u0002\u000b)J\fgn\u001d4pe6\u001c(BA\f\u0019\u0003%!(/\u00198tM>\u0014XN\u0003\u0002\u001a5\u0005A\u0011N\u001c;fe:\fGN\u0003\u0002\u001c9\u00059!/\u001a4mK\u000e$(\"A\u000f\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001\u0001\t\t\u0003C\tj\u0011\u0001H\u0005\u0003Gq\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001'!\t\ts%\u0003\u0002)9\t!QK\\5u\u0005\u0011a\u0015M_=\u0016\u0005-\u00124C\u0001\u0002!\u0003\ty\u0007\u000fE\u0002\"]AJ!a\f\u000f\u0003\u0011q\u0012\u0017P\\1nKz\u0002\"!\r\u001a\r\u0001\u0011)1G\u0001b\u0001i\t\tA+\u0005\u00026qA\u0011\u0011EN\u0005\u0003oq\u0011qAT8uQ&tw\r\u0005\u0002\"s%\u0011!\b\b\u0002\u0004\u0003:L\u0018A\u0002\u001fj]&$h\b\u0006\u0002>\u007fA\u0019aH\u0001\u0019\u000e\u0003\u0001Aa\u0001\f\u0003\u0005\u0002\u0004i\u0013!\u0002<bYV,W#\u0001\u0019\u0002\u0013Y\fG.^3`I\u0015\fHC\u0001\u0014E\u0011\u001d)e!!AA\u0002A\n1\u0001\u001f\u00132\u0003\u00191\u0018\r\\;fA\u0005Qq,[:EK\u001aLg.\u001a3\u0016\u0003%\u0003\"!\t&\n\u0005-c\"a\u0002\"p_2,\u0017M\\\u0001\u000f?&\u001cH)\u001a4j]\u0016$w\fJ3r)\t1c\nC\u0004F\u0013\u0005\u0005\t\u0019A%\u0002\u0017}K7\u000fR3gS:,G\rI\u0001\nSN$UMZ5oK\u0012\fQAZ8sG\u0016\f1\"\u001e8dkJ\u0014\u0018\u0010T1{sV\tA\u000bE\u0002?\u0005U\u00132A\u0016\u0011Y\r\u00119V\u0002A+\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0005eSV\"\u0001\f\n\u0005m3\"aB+o\u0007V\u0014(/\u001f\u0005\b;Z\u0013\r\u0011\"\u0001_\u0003\u00199Gn\u001c2bYV\ta(A\u0006fe\u0006\u001cXO]3MCjLX#A1\u0011\u0007y\u0012!ME\u0002dA\u00114Aa\u0016\b\u0001EB\u0011\u0011,Z\u0005\u0003MZ\u0011q!\u0012:bgV\u0014X\rC\u0004^G\n\u0007I\u0011\u00010\u0002\u001fA|7\u000f^#sCN,(/\u001a'buf,\u0012A\u001b\t\u0004}\tY'c\u00017![\u001a!qk\u0004\u0001l!\tIf.\u0003\u0002p-\tY\u0001k\\:u\u000bJ\f7/\u001e:f\u0011\u001diFN1A\u0005\u0002y\u000bq!\u001e8dkJ\u0014\u00180F\u0001V\u0003\u001d)'/Y:ve\u0016,\u0012AY\u0001\fa>\u001cH/\u0012:bgV\u0014X-F\u0001l\u0003=!(/\u00198tM>\u0014X.\u001a3UsB,GcA=\u0002\u0014A\u0012!0 \t\u0004w\u0006-aB\u0001?q!\t\tT\u0010B\u0005\u007f'\u0005\u0005\t\u0011!B\u0001\u007f\n9q,\r\u0018usB,\u0017cA\u001b\u0002\u0002I)\u00111A6\u0002\u0006\u0019)q\u000b\u0001\u0001\u0002\u0002A\u0019\u0011%a\u0002\n\u0007\u0005%ADA\u0005TS:<G.\u001a;p]&!\u0011QBA\b\u0005\u0011!\u0016\u0010]3\n\u0007\u0005E\u0001DA\u0003UsB,7\u000fC\u0004\u0002\u0016M\u0001\r!a\u0006\u0002\u0007MLX\u000eE\u0002?\u00033IA!a\u0007\u0002\u001e\t11+_7c_2L1!a\b\u0019\u0005\u001d\u0019\u00160\u001c2pYN$B!a\t\u00024A\"\u0011QEA\u0016!\u0011\t9#a\u0003\u000f\u0007\u0005%\u0002\u000fE\u00022\u0003W!!B \u000b\u0002\u0002\u0003\u0005)\u0011AA\u0017#\r)\u0014q\u0006\n\u0006\u0003cY\u0017Q\u0001\u0004\u0006/\u0002\u0001\u0011q\u0006\u0005\b\u0003k!\u0002\u0019AA\u001c\u0003\r!\b/\u001a\t\u0004}\u0005-\u0001\u0003BA\u001e\u0003{i\u0011\u0001G\u0005\u0004\u0003\u007fA\"aC*z[\n|G\u000eV1cY\u0016\u0004")
public interface Transforms {
    public void scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$uncurryLazy_$eq(Lazy<UnCurry> var1);

    public void scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$erasureLazy_$eq(Lazy<Erasure> var1);

    public void scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$postErasureLazy_$eq(Lazy<PostErasure> var1);

    public Lazy<UnCurry> scala$reflect$internal$transform$Transforms$$uncurryLazy();

    public Lazy<Erasure> scala$reflect$internal$transform$Transforms$$erasureLazy();

    public Lazy<PostErasure> scala$reflect$internal$transform$Transforms$$postErasureLazy();

    public static /* synthetic */ UnCurry uncurry$(Transforms $this) {
        return $this.uncurry();
    }

    default public UnCurry uncurry() {
        return this.scala$reflect$internal$transform$Transforms$$uncurryLazy().force();
    }

    public static /* synthetic */ Erasure erasure$(Transforms $this) {
        return $this.erasure();
    }

    default public Erasure erasure() {
        return this.scala$reflect$internal$transform$Transforms$$erasureLazy().force();
    }

    public static /* synthetic */ PostErasure postErasure$(Transforms $this) {
        return $this.postErasure();
    }

    default public PostErasure postErasure() {
        return this.scala$reflect$internal$transform$Transforms$$postErasureLazy().force();
    }

    public static /* synthetic */ Types.Type transformedType$(Transforms $this, Symbols.Symbol sym) {
        return $this.transformedType(sym);
    }

    default public Types.Type transformedType(Symbols.Symbol sym) {
        return this.postErasure().transformInfo(sym, this.erasure().transformInfo(sym, this.uncurry().transformInfo(sym, sym.info())));
    }

    public static /* synthetic */ Types.Type transformedType$(Transforms $this, Types.Type tpe) {
        return $this.transformedType(tpe);
    }

    default public Types.Type transformedType(Types.Type tpe) {
        return this.postErasure().elimErasedValueType().apply(this.erasure().scalaErasure().apply(this.uncurry().uncurry().apply(tpe)));
    }

    public static void $init$(Transforms $this) {
        $this.scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$uncurryLazy_$eq(new Lazy<UnCurry>((SymbolTable)$this, (Function0<$anon$1> & java.io.Serializable & Serializable)() -> new UnCurry((SymbolTable)$this){
            private final SymbolTable global;
            private volatile UnCurry$VarargsSymbolAttachment$ VarargsSymbolAttachment$module;
            private final TypeMaps.TypeMap uncurry;
            private volatile UnCurry$DesugaredParameterType$ DesugaredParameterType$module;
            private final TypeMaps.TypeMap scala$reflect$internal$transform$UnCurry$$uncurryType;

            public Types.Type transformInfo(Symbols.Symbol sym, Types.Type tp) {
                return UnCurry.transformInfo$(this, sym, tp);
            }

            public UnCurry$VarargsSymbolAttachment$ VarargsSymbolAttachment() {
                if (this.VarargsSymbolAttachment$module == null) {
                    this.VarargsSymbolAttachment$lzycompute$1();
                }
                return this.VarargsSymbolAttachment$module;
            }

            public TypeMaps.TypeMap uncurry() {
                return this.uncurry;
            }

            public UnCurry$DesugaredParameterType$ DesugaredParameterType() {
                if (this.DesugaredParameterType$module == null) {
                    this.DesugaredParameterType$lzycompute$1();
                }
                return this.DesugaredParameterType$module;
            }

            public TypeMaps.TypeMap scala$reflect$internal$transform$UnCurry$$uncurryType() {
                return this.scala$reflect$internal$transform$UnCurry$$uncurryType;
            }

            public void scala$reflect$internal$transform$UnCurry$_setter_$uncurry_$eq(TypeMaps.TypeMap x$1) {
                this.uncurry = x$1;
            }

            public final void scala$reflect$internal$transform$UnCurry$_setter_$scala$reflect$internal$transform$UnCurry$$uncurryType_$eq(TypeMaps.TypeMap x$1) {
                this.scala$reflect$internal$transform$UnCurry$$uncurryType = x$1;
            }

            public SymbolTable global() {
                return this.global;
            }

            private final void VarargsSymbolAttachment$lzycompute$1() {
                synchronized (this) {
                    if (this.VarargsSymbolAttachment$module == null) {
                        this.VarargsSymbolAttachment$module = new UnCurry$VarargsSymbolAttachment$(this);
                    }
                    return;
                }
            }

            private final void DesugaredParameterType$lzycompute$1() {
                synchronized (this) {
                    if (this.DesugaredParameterType$module == null) {
                        this.DesugaredParameterType$module = new UnCurry$DesugaredParameterType$(this);
                    }
                    return;
                }
            }
            {
                this.global = $outer;
                UnCurry.$init$(this);
            }
        }));
        $this.scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$erasureLazy_$eq(new Lazy<Erasure>((SymbolTable)$this, (Function0<$anon$2> & java.io.Serializable & Serializable)() -> new Erasure((SymbolTable)$this){
            private final SymbolTable global;
            private volatile Erasure$GenericArray$ GenericArray$module;
            private volatile Erasure$scalaErasure$ scalaErasure$module;
            private volatile Erasure$specialScalaErasure$ specialScalaErasure$module;
            private volatile Erasure$javaErasure$ javaErasure$module;
            private volatile Erasure$verifiedJavaErasure$ verifiedJavaErasure$module;
            private volatile Erasure$boxingErasure$ boxingErasure$module;

            public int unboundedGenericArrayLevel(Types.Type tp) {
                return Erasure.unboundedGenericArrayLevel$(this, tp);
            }

            public Types.Type rebindInnerClass(Types.Type pre, Symbols.Symbol cls) {
                return Erasure.rebindInnerClass$(this, pre, cls);
            }

            public Types.Type erasedValueClassArg(Types.TypeRef tref) {
                return Erasure.erasedValueClassArg$(this, tref);
            }

            public boolean valueClassIsParametric(Symbols.Symbol clazz) {
                return Erasure.valueClassIsParametric$(this, clazz);
            }

            public boolean verifyJavaErasure() {
                return Erasure.verifyJavaErasure$(this);
            }

            public Erasure.ErasureMap erasure(Symbols.Symbol sym) {
                return Erasure.erasure$(this, sym);
            }

            public Types.Type specialErasure(Symbols.Symbol sym, Types.Type tp) {
                return Erasure.specialErasure$(this, sym, tp);
            }

            public Types.Type specialConstructorErasure(Symbols.Symbol clazz, Types.Type tpe) {
                return Erasure.specialConstructorErasure$(this, clazz, tpe);
            }

            public Types.Type intersectionDominator(List<Types.Type> parents) {
                return Erasure.intersectionDominator$(this, parents);
            }

            public Types.Type transformInfo(Symbols.Symbol sym, Types.Type tp) {
                return Erasure.transformInfo$(this, sym, tp);
            }

            public Erasure$GenericArray$ GenericArray() {
                if (this.GenericArray$module == null) {
                    this.GenericArray$lzycompute$1();
                }
                return this.GenericArray$module;
            }

            public Erasure$scalaErasure$ scalaErasure() {
                if (this.scalaErasure$module == null) {
                    this.scalaErasure$lzycompute$1();
                }
                return this.scalaErasure$module;
            }

            public Erasure$specialScalaErasure$ specialScalaErasure() {
                if (this.specialScalaErasure$module == null) {
                    this.specialScalaErasure$lzycompute$1();
                }
                return this.specialScalaErasure$module;
            }

            public Erasure$javaErasure$ javaErasure() {
                if (this.javaErasure$module == null) {
                    this.javaErasure$lzycompute$1();
                }
                return this.javaErasure$module;
            }

            public Erasure$verifiedJavaErasure$ verifiedJavaErasure() {
                if (this.verifiedJavaErasure$module == null) {
                    this.verifiedJavaErasure$lzycompute$1();
                }
                return this.verifiedJavaErasure$module;
            }

            public Erasure$boxingErasure$ boxingErasure() {
                if (this.boxingErasure$module == null) {
                    this.boxingErasure$lzycompute$1();
                }
                return this.boxingErasure$module;
            }

            public SymbolTable global() {
                return this.global;
            }

            private final void GenericArray$lzycompute$1() {
                synchronized (this) {
                    if (this.GenericArray$module == null) {
                        this.GenericArray$module = new Erasure$GenericArray$(this);
                    }
                    return;
                }
            }

            private final void scalaErasure$lzycompute$1() {
                synchronized (this) {
                    if (this.scalaErasure$module == null) {
                        this.scalaErasure$module = new Erasure$scalaErasure$(this);
                    }
                    return;
                }
            }

            private final void specialScalaErasure$lzycompute$1() {
                synchronized (this) {
                    if (this.specialScalaErasure$module == null) {
                        this.specialScalaErasure$module = new Erasure$specialScalaErasure$(this);
                    }
                    return;
                }
            }

            private final void javaErasure$lzycompute$1() {
                synchronized (this) {
                    if (this.javaErasure$module == null) {
                        this.javaErasure$module = new Erasure$javaErasure$(this);
                    }
                    return;
                }
            }

            private final void verifiedJavaErasure$lzycompute$1() {
                synchronized (this) {
                    if (this.verifiedJavaErasure$module == null) {
                        this.verifiedJavaErasure$module = new Erasure$verifiedJavaErasure$(this);
                    }
                    return;
                }
            }

            private final void boxingErasure$lzycompute$1() {
                synchronized (this) {
                    if (this.boxingErasure$module == null) {
                        this.boxingErasure$module = new Erasure$boxingErasure$(this);
                    }
                    return;
                }
            }
            {
                this.global = $outer;
                Erasure.$init$(this);
            }
        }));
        $this.scala$reflect$internal$transform$Transforms$_setter_$scala$reflect$internal$transform$Transforms$$postErasureLazy_$eq(new Lazy<PostErasure>((SymbolTable)$this, (Function0<$anon$3> & java.io.Serializable & Serializable)() -> new PostErasure((SymbolTable)$this){
            private final SymbolTable global;
            private volatile PostErasure$elimErasedValueType$ elimErasedValueType$module;

            public Types.Type transformInfo(Symbols.Symbol sym, Types.Type tp) {
                return PostErasure.transformInfo$(this, sym, tp);
            }

            public PostErasure$elimErasedValueType$ elimErasedValueType() {
                if (this.elimErasedValueType$module == null) {
                    this.elimErasedValueType$lzycompute$1();
                }
                return this.elimErasedValueType$module;
            }

            public SymbolTable global() {
                return this.global;
            }

            private final void elimErasedValueType$lzycompute$1() {
                synchronized (this) {
                    if (this.elimErasedValueType$module == null) {
                        this.elimErasedValueType$module = new PostErasure$elimErasedValueType$(this);
                    }
                    return;
                }
            }
            {
                this.global = $outer;
                PostErasure.$init$(this);
            }
        }));
    }

    private class Lazy<T> {
        private final Function0<T> op;
        private T value;
        private boolean _isDefined;
        public final /* synthetic */ SymbolTable $outer;

        private T value() {
            return this.value;
        }

        private void value_$eq(T x$1) {
            this.value = x$1;
        }

        private boolean _isDefined() {
            return this._isDefined;
        }

        private void _isDefined_$eq(boolean x$1) {
            this._isDefined = x$1;
        }

        public boolean isDefined() {
            return this._isDefined();
        }

        public T force() {
            if (!this.isDefined()) {
                this.value_$eq(this.op.apply());
                this._isDefined_$eq(true);
            }
            return this.value();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$transform$Transforms$Lazy$$$outer() {
            return this.$outer;
        }

        public Lazy(SymbolTable $outer, Function0<T> op) {
            this.op = op;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this._isDefined = false;
        }
    }
}

