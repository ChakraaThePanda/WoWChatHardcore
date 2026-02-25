/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.transform;

import java.lang.invoke.LambdaMetafactory;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.math.Ordering$Int$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Names;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.tpe.TypeMaps;
import scala.reflect.internal.transform.Erasure$GenericArray$;
import scala.reflect.internal.transform.Erasure$boxingErasure$;
import scala.reflect.internal.transform.Erasure$javaErasure$;
import scala.reflect.internal.transform.Erasure$scalaErasure$;
import scala.reflect.internal.transform.Erasure$specialScalaErasure$;
import scala.reflect.internal.transform.Erasure$verifiedJavaErasure$;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005MhaB\u001c9!\u0003\r\t!\u0011\u0005\u0006\r\u0002!\ta\u0012\u0005\b\u0017\u0002\u0011\rQ\"\u0001M\u000f\u0015\t\u0006\u0001#\u0001S\r\u0015!\u0006\u0001#\u0001V\u0011\u00151F\u0001\"\u0001X\u0011\u0015AF\u0001\"\u0003Z\u0011\u0015\u0011G\u0001\"\u0001d\u0011\u0015q\u0007\u0001\"\u0005p\u0011\u0015\t\b\u0001\"\u0005s\u0011\u0015a\b\u0001\"\u0001~\u0011\u001d\t9\u0001\u0001C\u0001\u0003\u00131q!!\u0006\u0001\u0003\u0003\t9\u0002\u0003\u0004W\u0019\u0011\u0005\u0011q\u0005\u0005\b\u0003Waa\u0011AA\u0017\u0011\u001d\t\t\u0005\u0004C\u0001\u0003\u0007Bq!a\u0012\r\t#\tI\u0005C\u0004\u0002N1!\t!a\u0014\t\u000f\u0005MC\u0002\"\u0001\u0002V!9\u0011\u0011\f\u0001\u0005\u0012\u0005m\u0003bBA/\u0001\u0011\u0005\u0011q\f\u0005\b\u0003K\u0002A\u0011AA4\u0011\u001d\ty\u0007\u0001C\u0001\u0003c2a!a\u001e\u0001\u0001\u0005e\u0004B\u0002,\u0018\t\u0003\tY\bC\u0004\u0002,]!\t!a \u0007\r\u0005\r\u0005\u0001AAC\u0011\u00191&\u0004\"\u0001\u0002\b\"9\u00111\u0006\u000e\u0005\u0002\u0005-\u0005bBA$5\u0011E\u0013qR\u0004\b\u0003'\u0003\u0001\u0012AAK\r\u001d\t9\n\u0001E\u0001\u00033CaAV\u0010\u0005\u0002\u0005muaBAO\u0001!\u0005\u0011q\u0014\u0004\b\u0003C\u0003\u0001\u0012AAR\u0011\u00191&\u0005\"\u0001\u0002&\"9\u0011q\t\u0012\u0005B\u0005\u001dvaBAV\u0001!\u0005\u0011Q\u0016\u0004\b\u0003_\u0003\u0001\u0012AAY\u0011\u00191f\u0005\"\u0001\u00024\u001e9\u0011Q\u0017\u0001\t\u0002\u0005]faBA]\u0001!\u0005\u00111\u0018\u0005\u0007-&\"\t!!0\t\u000f\u00055\u0013\u0006\"\u0011\u0002@\u001e9\u00111\u0019\u0001\t\u0002\u0005\u0015gaBAd\u0001!\u0005\u0011\u0011\u001a\u0005\u0007-6\"\t!a3\t\u0013\u00055W\u00061A\u0005\n\u0005m\u0003\"CAh[\u0001\u0007I\u0011BAi\u0011!\t9.\fQ!\n\u0005-\u0001bBA*[\u0011\u0005\u0013\u0011\u001c\u0005\b\u0003\u0003jC\u0011IAo\u0011\u001d\t9%\fC!\u0003CDq!!:\u0001\t\u0003\t9\u000fC\u0004\u0002l\u0002!\t!!<\u0003\u000f\u0015\u0013\u0018m];sK*\u0011\u0011HO\u0001\niJ\fgn\u001d4pe6T!a\u000f\u001f\u0002\u0011%tG/\u001a:oC2T!!\u0010 \u0002\u000fI,g\r\\3di*\tq(A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001\u0011\u0005CA\"E\u001b\u0005q\u0014BA#?\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012\u0001\u0013\t\u0003\u0007&K!A\u0013 \u0003\tUs\u0017\u000e^\u0001\u0007O2|'-\u00197\u0016\u00035\u0003\"AT(\u000e\u0003iJ!\u0001\u0015\u001e\u0003\u0017MKXNY8m)\u0006\u0014G.Z\u0001\r\u000f\u0016tWM]5d\u0003J\u0014\u0018-\u001f\t\u0003'\u0012i\u0011\u0001\u0001\u0002\r\u000f\u0016tWM]5d\u0003J\u0014\u0018-_\n\u0003\t\t\u000ba\u0001P5oSRtD#\u0001*\u0002\u0017\u001d,g.\u001a:jG\u000e{'/\u001a\u000b\u00035\u0002\u0004\"a\u0017/\u000f\u0005M\u0013\u0011BA/_\u0005\u0011!\u0016\u0010]3\n\u0005}S$!\u0002+za\u0016\u001c\b\"B1\u0007\u0001\u0004Q\u0016A\u0001;q\u0003\u001d)h.\u00199qYf$\"\u0001Z7\u0011\u0007\r+w-\u0003\u0002g}\t1q\n\u001d;j_:\u0004Ba\u00115k5&\u0011\u0011N\u0010\u0002\u0007)V\u0004H.\u001a\u001a\u0011\u0005\r[\u0017B\u00017?\u0005\rIe\u000e\u001e\u0005\u0006C\u001e\u0001\rAW\u0001\u001bk:\u0014w.\u001e8eK\u0012<UM\\3sS\u000e\f%O]1z\u0019\u00164X\r\u001c\u000b\u0003UBDQ!\u0019\u0005A\u0002i\u000b\u0001C]3cS:$\u0017J\u001c8fe\u000ec\u0017m]:\u0015\u0007i\u001bX\u000fC\u0003u\u0013\u0001\u0007!,A\u0002qe\u0016DQA^\u0005A\u0002]\f1a\u00197t!\tY\u00060\u0003\u0002zu\n11+_7c_2L!a\u001f\u001e\u0003\u000fMKXNY8mg\u0006\u0019RM]1tK\u00124\u0016\r\\;f\u00072\f7o]!sOR\u0011!L \u0005\u0007\u007f*\u0001\r!!\u0001\u0002\tQ\u0014XM\u001a\t\u00047\u0006\r\u0011bAA\u0003=\n9A+\u001f9f%\u00164\u0017A\u0006<bYV,7\t\\1tg&\u001b\b+\u0019:b[\u0016$(/[2\u0015\t\u0005-\u0011\u0011\u0003\t\u0004\u0007\u00065\u0011bAA\b}\t9!i\\8mK\u0006t\u0007BBA\n\u0017\u0001\u0007q/A\u0003dY\u0006T(P\u0001\u0006Fe\u0006\u001cXO]3NCB\u001c2\u0001DA\r!\rY\u00161D\u0005\u0005\u0003;\tyBA\u0004UsB,W*\u00199\n\t\u0005\u0005\u00121\u0005\u0002\t)f\u0004X-T1qg*\u0019\u0011Q\u0005\u001e\u0002\u0007Q\u0004X\r\u0006\u0002\u0002*A\u00111\u000bD\u0001\r[\u0016\u0014x-\u001a)be\u0016tGo\u001d\u000b\u00045\u0006=\u0002bBA\u0019\u001d\u0001\u0007\u00111G\u0001\ba\u0006\u0014XM\u001c;t!\u0015\t)$a\u000f[\u001d\r\u0019\u0015qG\u0005\u0004\u0003sq\u0014a\u00029bG.\fw-Z\u0005\u0005\u0003{\tyD\u0001\u0003MSN$(bAA\u001d}\u0005\u0019RM]1tK:{'/\\1m\u00072\f7o\u001d*fMR\u0019!,!\u0012\t\r}|\u0001\u0019AA\u0001\u0003e)'/Y:f\t\u0016\u0014\u0018N^3e-\u0006dW/Z\"mCN\u001c(+\u001a4\u0015\u0007i\u000bY\u0005\u0003\u0004\u0000!\u0001\u0007\u0011\u0011A\u0001\u0006CB\u0004H.\u001f\u000b\u00045\u0006E\u0003\"B1\u0012\u0001\u0004Q\u0016\u0001D1qa2L\u0018J\\!se\u0006LHc\u0001.\u0002X!)\u0011M\u0005a\u00015\u0006\tb/\u001a:jMfT\u0015M^1Fe\u0006\u001cXO]3\u0016\u0005\u0005-\u0011aB3sCN,(/\u001a\u000b\u0005\u0003S\t\t\u0007\u0003\u0004\u0002dQ\u0001\ra^\u0001\u0004gfl\u0017AD:qK\u000eL\u0017\r\\#sCN,(/\u001a\u000b\u0005\u0003S\ni\u0007F\u0002[\u0003WBQ!Y\u000bA\u0002iCa!a\u0019\u0016\u0001\u00049\u0018!G:qK\u000eL\u0017\r\\\"p]N$(/^2u_J,%/Y:ve\u0016$RAWA:\u0003kBa!a\u0005\u0017\u0001\u00049\bBBA\u0013-\u0001\u0007!LA\bTG\u0006d\u0017-\u0012:bgV\u0014X-T1q'\r9\u0012\u0011\u0006\u000b\u0003\u0003{\u0002\"aU\f\u0015\u0007i\u000b\t\tC\u0004\u00022e\u0001\r!a\r\u0003\u001d)\u000bg/Y#sCN,(/Z'baN\u0019!$!\u000b\u0015\u0005\u0005%\u0005CA*\u001b)\rQ\u0016Q\u0012\u0005\b\u0003ca\u0002\u0019AA\u001a)\rQ\u0016\u0011\u0013\u0005\u0007\u007fv\u0001\r!!\u0001\u0002\u0019M\u001c\u0017\r\\1Fe\u0006\u001cXO]3\u0011\u0005M{\"\u0001D:dC2\fWI]1tkJ,7cA\u0010\u0002~Q\u0011\u0011QS\u0001\u0014gB,7-[1m'\u000e\fG.Y#sCN,(/\u001a\t\u0003'\n\u00121c\u001d9fG&\fGnU2bY\u0006,%/Y:ve\u0016\u001c2AIA?)\t\ty\nF\u0002[\u0003SCaa \u0013A\u0002\u0005\u0005\u0011a\u00036bm\u0006,%/Y:ve\u0016\u0004\"a\u0015\u0014\u0003\u0017)\fg/Y#sCN,(/Z\n\u0004M\u0005%ECAAW\u0003M1XM]5gS\u0016$'*\u0019<b\u000bJ\f7/\u001e:f!\t\u0019\u0016FA\nwKJLg-[3e\u0015\u00064\u0018-\u0012:bgV\u0014XmE\u0002*\u0003\u0013#\"!a.\u0015\u0007i\u000b\t\rC\u0003bW\u0001\u0007!,A\u0007c_bLgnZ#sCN,(/\u001a\t\u0003'6\u0012QBY8yS:<WI]1tkJ,7cA\u0017\u0002~Q\u0011\u0011QY\u0001\u000eE>D\bK]5nSRLg/Z:\u0002#\t|\u0007\u0010\u0015:j[&$\u0018N^3t?\u0012*\u0017\u000fF\u0002I\u0003'D\u0011\"!61\u0003\u0003\u0005\r!a\u0003\u0002\u0007a$\u0013'\u0001\bc_b\u0004&/[7ji&4Xm\u001d\u0011\u0015\u0007i\u000bY\u000eC\u0003be\u0001\u0007!\fF\u0002[\u0003?Daa`\u001aA\u0002\u0005\u0005Ac\u0001.\u0002d\"1q\u0010\u000ea\u0001\u0003\u0003\tQ#\u001b8uKJ\u001cXm\u0019;j_:$u.\\5oCR|'\u000fF\u0002[\u0003SDq!!\r6\u0001\u0004\t\u0019$A\u0007ue\u0006t7OZ8s[&sgm\u001c\u000b\u00065\u0006=\u0018\u0011\u001f\u0005\u0007\u0003G2\u0004\u0019A<\t\u000b\u00054\u0004\u0019\u0001.")
public interface Erasure {
    public Erasure$GenericArray$ GenericArray();

    public Erasure$scalaErasure$ scalaErasure();

    public Erasure$specialScalaErasure$ specialScalaErasure();

    public Erasure$javaErasure$ javaErasure();

    public Erasure$verifiedJavaErasure$ verifiedJavaErasure();

    public Erasure$boxingErasure$ boxingErasure();

    public SymbolTable global();

    public static /* synthetic */ int unboundedGenericArrayLevel$(Erasure $this, Types.Type tp) {
        return $this.unboundedGenericArrayLevel(tp);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public int unboundedGenericArrayLevel(Types.Type tp2) {
        void logResult_result;
        void logResult_msg;
        Option<Tuple2<Object, Types.Type>> option = this.GenericArray().unapply(tp2);
        if (!option.isEmpty()) {
            int level = option.get()._1$mcI$sp();
            if (!option.get()._2().$less$colon$less(this.global().definitions().AnyRefTpe())) {
                return level;
            }
        }
        if (!(tp2 instanceof Types.RefinedType)) return 0;
        List<Types.Type> ps = ((Types.RefinedType)tp2).parents();
        if (!ps.nonEmpty()) return 0;
        SymbolTable symbolTable = this.global();
        Object a = ((TraversableOnce)ps.map((Function1<Types.Type, Object> & java.io.Serializable & Serializable)tp -> BoxesRunTime.boxToInteger(this.unboundedGenericArrayLevel(tp)), List$.MODULE$.canBuildFrom())).max(Ordering$Int$.MODULE$);
        Function0<String> & java.io.Serializable & Serializable intersect = (Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(31).append("Unbounded generic level for ").append(tp2).append(" is").toString();
        if (symbolTable == null) {
            throw null;
        }
        symbolTable.log((Function0<Object>)((Function0<String> & java.io.Serializable & Serializable)() -> SymbolTable.$anonfun$logResult$1((Function0)logResult_msg, logResult_result)));
        return BoxesRunTime.unboxToInt(a);
    }

    public static /* synthetic */ Types.Type rebindInnerClass$(Erasure $this, Types.Type pre, Symbols.Symbol cls) {
        return $this.rebindInnerClass(pre, cls);
    }

    default public Types.Type rebindInnerClass(Types.Type pre, Symbols.Symbol cls) {
        if (cls.isTopLevel() || cls.isLocalToBlock()) {
            return pre;
        }
        return cls.owner().tpe_$times();
    }

    public static /* synthetic */ Types.Type erasedValueClassArg$(Erasure $this, Types.TypeRef tref) {
        return $this.erasedValueClassArg(tref);
    }

    default public Types.Type erasedValueClassArg(Types.TypeRef tref) {
        this.global().assert(!this.global().phase().erasedTypes());
        Symbols.Symbol clazz = tref.sym();
        if (this.valueClassIsParametric(clazz)) {
            Types.Type underlying = tref.memberType(clazz.derivedValueClassUnbox()).resultType();
            return this.boxingErasure().apply(underlying);
        }
        return this.scalaErasure().apply(this.global().definitions().underlyingOfValueClass(clazz));
    }

    public static /* synthetic */ boolean valueClassIsParametric$(Erasure $this, Symbols.Symbol clazz) {
        return $this.valueClassIsParametric(clazz);
    }

    default public boolean valueClassIsParametric(Symbols.Symbol clazz) {
        this.global().assert(!this.global().phase().erasedTypes());
        return clazz.typeParams().contains(clazz.derivedValueClassUnbox().tpe().resultType().typeSymbol());
    }

    public static /* synthetic */ boolean verifyJavaErasure$(Erasure $this) {
        return $this.verifyJavaErasure();
    }

    default public boolean verifyJavaErasure() {
        return false;
    }

    public static /* synthetic */ ErasureMap erasure$(Erasure $this, Symbols.Symbol sym) {
        return $this.erasure(sym);
    }

    default public ErasureMap erasure(Symbols.Symbol sym) {
        Symbols.Symbol symbol = sym;
        Symbols.NoSymbol noSymbol = this.global().NoSymbol();
        if (!(symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) || !sym.enclClass().isJavaDefined()) {
            return this.scalaErasure();
        }
        if (this.verifyJavaErasure() && sym.isMethod()) {
            return this.verifiedJavaErasure();
        }
        return this.javaErasure();
    }

    public static /* synthetic */ Types.Type specialErasure$(Erasure $this, Symbols.Symbol sym, Types.Type tp) {
        return $this.specialErasure(sym, tp);
    }

    default public Types.Type specialErasure(Symbols.Symbol sym, Types.Type tp) {
        Symbols.Symbol symbol = sym;
        Symbols.NoSymbol noSymbol = this.global().NoSymbol();
        if ((symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) && sym.enclClass().isJavaDefined()) {
            return this.erasure(sym).apply(tp);
        }
        if (sym.isClassConstructor()) {
            return this.specialConstructorErasure(sym.owner(), tp);
        }
        return this.specialScalaErasure().apply(tp);
    }

    public static /* synthetic */ Types.Type specialConstructorErasure$(Erasure $this, Symbols.Symbol clazz, Types.Type tpe) {
        return $this.specialConstructorErasure(clazz, tpe);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public Types.Type specialConstructorErasure(Symbols.Symbol clazz, Types.Type tpe) {
        void assert_assertion;
        boolean bl;
        if (tpe instanceof Types.PolyType) {
            Types.Type restpe = ((Types.PolyType)tpe).resultType();
            return this.specialConstructorErasure(clazz, restpe);
        }
        if (tpe instanceof Types.ExistentialType) {
            Types.Type restpe = ((Types.ExistentialType)tpe).underlying();
            return this.specialConstructorErasure(clazz, restpe);
        }
        if (tpe instanceof Types.MethodType) {
            Types.MethodType methodType = (Types.MethodType)tpe;
            List<Symbols.Symbol> params = methodType.params();
            Types.Type restpe = methodType.resultType();
            return new Types.MethodType(this.global(), this.global().cloneSymbolsAndModify(params, this.specialScalaErasure()), this.specialConstructorErasure(clazz, restpe));
        }
        if (tpe instanceof Types.TypeRef) {
            Types.TypeRef typeRef = (Types.TypeRef)tpe;
            Types.Type pre = typeRef.pre();
            Symbols.Symbol symbol = typeRef.sym();
            Symbols.Symbol symbol2 = clazz;
            if (symbol2 == null) {
                if (symbol == null) return this.global().typeRef(pre, clazz, Nil$.MODULE$);
            } else if (symbol2.equals(symbol)) {
                return this.global().typeRef(pre, clazz, Nil$.MODULE$);
            }
        }
        Symbols.Symbol symbol = clazz;
        Symbols.ClassSymbol classSymbol = this.global().definitions().ArrayClass();
        if (symbol == null) {
            if (classSymbol == null) return this.specialScalaErasure().apply(tpe);
        } else if (symbol.equals(classSymbol)) return this.specialScalaErasure().apply(tpe);
        if (tpe.isError()) return this.specialScalaErasure().apply(tpe);
        SymbolTable symbolTable = this.global();
        Symbols.Symbol symbol3 = clazz;
        Symbols.ClassSymbol classSymbol2 = this.global().definitions().ArrayClass();
        boolean bl2 = !(symbol3 == null ? classSymbol2 != null : !symbol3.equals(classSymbol2)) || tpe.isError() ? true : (bl = false);
        if (symbolTable == null) {
            throw null;
        }
        SymbolTable assert_this = symbolTable;
        if (assert_assertion != false) return this.specialScalaErasure().apply(tpe);
        throw assert_this.throwAssertionError(Erasure.$anonfun$specialConstructorErasure$1(tpe, clazz));
    }

    public static /* synthetic */ Types.Type intersectionDominator$(Erasure $this, List parents) {
        return $this.intersectionDominator(parents);
    }

    default public Types.Type intersectionDominator(List<Types.Type> parents) {
        if (parents.isEmpty()) {
            return this.global().definitions().ObjectTpe();
        }
        List psyms = parents.map((Function1<Types.Type, Symbols.Symbol> & java.io.Serializable & Serializable)x$5 -> x$5.typeSymbol(), List$.MODULE$.canBuildFrom());
        if (psyms.contains(this.global().definitions().ArrayClass())) {
            return this.global().definitions().arrayType(this.intersectionDominator(((List)parents.filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToBoolean(Erasure.$anonfun$intersectionDominator$2(this, x$6)))).map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$7 -> x$7.typeArgs().head(), List$.MODULE$.canBuildFrom())));
        }
        Iterator<Types.Type> cs = parents.iterator().filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)p -> BoxesRunTime.boxToBoolean(Erasure.$anonfun$intersectionDominator$5(psyms, p)));
        return (cs.hasNext() ? cs : parents.iterator().filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)p -> BoxesRunTime.boxToBoolean(Erasure.isUnshadowed$1(p.typeSymbol(), psyms)))).next();
    }

    public static /* synthetic */ Types.Type transformInfo$(Erasure $this, Symbols.Symbol sym, Types.Type tp) {
        return $this.transformInfo(sym, tp);
    }

    default public Types.Type transformInfo(Symbols.Symbol sym, Types.Type tp2) {
        block15: {
            block16: {
                Types.Type type;
                List<Symbols.Symbol> params;
                block18: {
                    block17: {
                        block14: {
                            block13: {
                                Symbols.Symbol symbol = sym;
                                Symbols.MethodSymbol methodSymbol = this.global().definitions().Object_asInstanceOf();
                                if (!(symbol == null ? methodSymbol != null : !symbol.equals(methodSymbol)) || this.synchronizedPrimitive$1(sym)) {
                                    return sym.info();
                                }
                                Symbols.Symbol symbol2 = sym;
                                Symbols.MethodSymbol methodSymbol2 = this.global().definitions().Object_isInstanceOf();
                                if (!(symbol2 == null ? methodSymbol2 != null : !symbol2.equals(methodSymbol2))) break block13;
                                Symbols.Symbol symbol3 = sym;
                                Symbols.ClassSymbol classSymbol = this.global().definitions().ArrayClass();
                                if (symbol3 != null ? !symbol3.equals(classSymbol) : classSymbol != null) break block14;
                            }
                            return new Types.PolyType(this.global(), sym.info().typeParams(), this.specialErasure(sym, sym.info().resultType()));
                        }
                        if (sym.isAbstractType()) {
                            return this.global().TypeBounds().apply(this.global().WildcardType(), this.global().WildcardType());
                        }
                        if (!sym.isTerm()) break block15;
                        Symbols.Symbol symbol = sym.owner();
                        Symbols.ClassSymbol classSymbol = this.global().definitions().ArrayClass();
                        if (symbol != null ? !symbol.equals(classSymbol) : classSymbol != null) break block15;
                        if (!sym.isClassConstructor()) break block16;
                        if (!(tp2 instanceof Types.MethodType)) break block17;
                        Types.MethodType methodType = (Types.MethodType)tp2;
                        params = methodType.params();
                        type = methodType.resultType();
                        if (type instanceof Types.TypeRef) break block18;
                    }
                    throw new MatchError(tp2);
                }
                Types.TypeRef typeRef = (Types.TypeRef)type;
                Types.Type pre = typeRef.pre();
                Symbols.Symbol sym1 = typeRef.sym();
                List<Types.Type> args2 = typeRef.args();
                Types.MethodType methodType = new Types.MethodType(this.global(), this.global().cloneSymbolsAndModify(params, (Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)tp -> this.specialErasure(sym, (Types.Type)tp)), this.global().typeRef(this.specialErasure(sym, pre), sym1, args2));
                return methodType;
            }
            Names.Name name = sym.name();
            Names.TermName termName = this.global().nme().apply();
            if (!(name != null ? !name.equals(termName) : termName != null)) {
                return tp2;
            }
            Names.Name name2 = sym.name();
            Names.TermName termName2 = this.global().nme().update();
            if (!(name2 != null ? !name2.equals(termName2) : termName2 != null)) {
                List<Symbols.Symbol> list;
                Some<List<Symbols.Symbol>> some;
                if (!(tp2 instanceof Types.MethodType) || (some = List$.MODULE$.unapplySeq(list = ((Types.MethodType)tp2).params())).isEmpty() || some.get() == null || ((LinearSeqOptimized)some.get()).lengthCompare(2) != 0) {
                    throw new MatchError(tp2);
                }
                Symbols.Symbol index = (Symbols.Symbol)((LinearSeqOptimized)some.get()).apply(0);
                Symbols.Symbol tvar = (Symbols.Symbol)((LinearSeqOptimized)some.get()).apply(1);
                Types.MethodType methodType = new Types.MethodType(this.global(), new $colon$colon<Nothing$>((Nothing$)((Object)index.cloneSymbol().setInfo(this.specialErasure(sym, index.tpe()))), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)tvar), Nil$.MODULE$)), this.global().definitions().UnitTpe());
                return methodType;
            }
            return this.specialErasure(sym, tp2);
        }
        Symbols.Symbol symbol = sym.owner();
        Symbols.NoSymbol noSymbol = this.global().NoSymbol();
        if (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) {
            Symbols.Symbol symbol4 = sym.owner().owner();
            Symbols.ClassSymbol classSymbol = this.global().definitions().ArrayClass();
            if (!(symbol4 != null ? !symbol4.equals(classSymbol) : classSymbol != null) && sym.equals(((LinearSeqOptimized)this.global().definitions().Array_update().paramss().head()).apply(1))) {
                return tp2;
            }
        }
        return this.specialErasure(sym, tp2);
    }

    public static /* synthetic */ String $anonfun$specialConstructorErasure$1(Types.Type x1$1, Symbols.Symbol clazz$1) {
        return new StringBuilder(40).append("!!! unexpected constructor erasure ").append(x1$1).append(" for ").append(clazz$1).toString();
    }

    public static /* synthetic */ boolean $anonfun$intersectionDominator$2(Erasure $this, Types.Type x$6) {
        Symbols.Symbol symbol = x$6.typeSymbol();
        Symbols.ClassSymbol classSymbol = $this.global().definitions().ArrayClass();
        return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
    }

    public static /* synthetic */ boolean $anonfun$intersectionDominator$4(Symbols.Symbol psym$1, Symbols.Symbol qsym) {
        return psym$1 != qsym && qsym.isNonBottomSubClass(psym$1);
    }

    private static boolean isUnshadowed$1(Symbols.Symbol psym, List psyms$1) {
        boolean bl;
        block3: {
            if (psyms$1 == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = psyms$1;
            while (!exists_these.isEmpty()) {
                Symbols.Symbol symbol = (Symbols.Symbol)exists_these.head();
                if (Erasure.$anonfun$intersectionDominator$4(psym, symbol)) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return !bl;
    }

    public static /* synthetic */ boolean $anonfun$intersectionDominator$5(List psyms$1, Types.Type p) {
        Symbols.Symbol psym = p.typeSymbol();
        psym.initialize();
        return psym.isClass() && !psym.isTrait() && Erasure.isUnshadowed$1(psym, psyms$1);
    }

    private boolean synchronizedPrimitive$1(Symbols.Symbol sym) {
        block3: {
            block2: {
                Symbols.Symbol symbol = sym;
                Symbols.MethodSymbol methodSymbol = this.global().definitions().Object_synchronized();
                if (!(symbol == null ? methodSymbol != null : !symbol.equals(methodSymbol))) break block2;
                Symbols.Symbol symbol2 = sym.owner();
                Symbols.MethodSymbol methodSymbol2 = this.global().definitions().Object_synchronized();
                if ((symbol2 != null ? !symbol2.equals(methodSymbol2) : methodSymbol2 != null) || !sym.isTerm()) break block3;
            }
            return true;
        }
        return false;
    }

    public static void $init$(Erasure $this) {
    }

    public static /* synthetic */ Object $anonfun$intersectionDominator$4$adapted(Symbols.Symbol psym$1, Symbols.Symbol qsym) {
        return BoxesRunTime.boxToBoolean(Erasure.$anonfun$intersectionDominator$4(psym$1, qsym));
    }

    public abstract class ErasureMap
    extends TypeMaps.TypeMap {
        public abstract Types.Type mergeParents(List<Types.Type> var1);

        /*
         * WARNING - void declaration
         */
        public Types.Type eraseNormalClassRef(Types.TypeRef tref) {
            void var4_4;
            void var3_3;
            void var2_2;
            if (tref == null) {
                throw new MatchError((Object)null);
            }
            Types.Type pre = tref.pre();
            Symbols.Symbol clazz = tref.sym();
            List<Types.Type> args2 = tref.args();
            void pre2 = var2_2;
            void clazz2 = var3_3;
            void args3 = var4_4;
            Types.Type pre1 = this.apply(this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().rebindInnerClass((Types.Type)pre2, (Symbols.Symbol)clazz2));
            Nil$ args1 = Nil$.MODULE$;
            if (pre2 == pre1 && args3 == args1) {
                return tref;
            }
            return this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().typeRef(pre1, (Symbols.Symbol)clazz2, args1);
        }

        public Types.Type eraseDerivedValueClassRef(Types.TypeRef tref) {
            return this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().erasedValueClassArg(tref);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        @Override
        public Types.Type apply(Types.Type tp) {
            block36: {
                block35: {
                    if (!(tp instanceof Types.ConstantType)) break block35;
                    ct = ((Types.ConstantType)tp).value();
                    if (ct.tag() != 12) ** GOTO lbl-1000
                    v0 = ct.typeValue().typeSymbol();
                    var4_3 = this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().UnitClass();
                    if (v0 == null ? var4_3 != null : v0.equals(var4_3) == false) {
                        v1 = this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().ConstantType().apply(new Constants.Constant(this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global(), this.apply(ct.typeValue())));
                    } else lbl-1000:
                    // 2 sources

                    {
                        v1 = tp;
                    }
                    var2_4 = v1;
                    break block36;
                }
                if (tp instanceof Types.ThisType && ((Types.ThisType)tp).sym().isPackageClass()) {
                    var2_4 = tp;
                } else if (tp instanceof Types.SubType) {
                    var5_5 = (Types.SubType)tp;
                    var2_4 = this.apply(var5_5.supertype());
                } else if (tp instanceof Types.TypeRef) {
                    var6_6 = (Types.TypeRef)tp;
                    pre = var6_6.pre();
                    sym = var6_6.sym();
                    args = var6_6.args();
                    var2_4 = sym == this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ArrayClass() ? (this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().unboundedGenericArrayLevel(tp) == 1 ? this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ObjectTpe() : (args.head().typeSymbol().isBottomClass() ? this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().arrayType(this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ObjectTpe()) : this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().typeRef(this.apply(pre), sym, args.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$apply$1(scala.reflect.internal.transform.Erasure$ErasureMap scala.reflect.internal.Types$Type ), (Lscala/reflect/internal/Types$Type;)Lscala/reflect/internal/Types$Type;)((ErasureMap)this), List$.MODULE$.canBuildFrom())))) : (sym == this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().AnyClass() || sym == this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().AnyValClass() || sym == this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().SingletonClass() ? this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ObjectTpe() : (sym == this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().UnitClass() ? this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().BoxedUnitTpe() : (sym.isRefinementClass() != false ? this.apply(this.mergeParents(tp.parents())) : (sym.isDerivedValueClass() != false ? this.eraseDerivedValueClassRef(var6_6) : (sym.isClass() != false ? this.eraseNormalClassRef(var6_6) : this.apply(sym.info().asSeenFrom(pre, sym.owner())))))));
                } else if (tp instanceof Types.PolyType) {
                    restpe = ((Types.PolyType)tp).resultType();
                    var2_4 = this.apply(restpe);
                } else if (tp instanceof Types.ExistentialType) {
                    restpe = ((Types.ExistentialType)tp).underlying();
                    var2_4 = this.apply(restpe);
                } else if (tp instanceof Types.MethodType) {
                    var12_12 = (Types.MethodType)tp;
                    params = var12_12.params();
                    restpe = var12_12.resultType();
                    v2 = restpe.typeSymbol();
                    var15_15 = this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().UnitClass();
                    var2_4 = new Types.MethodType(this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global(), this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().cloneSymbolsAndModify(params, this), !(v2 != null ? v2.equals(var15_15) == false : var15_15 != null) ? this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().UnitTpe() : this.apply(var12_12.resultType(var12_12.paramTypes())));
                } else if (tp instanceof Types.RefinedType) {
                    parents = ((Types.RefinedType)tp).parents();
                    var2_4 = this.apply(this.mergeParents(parents));
                } else if (tp instanceof Types.AnnotatedType) {
                    atp = ((Types.AnnotatedType)tp).underlying();
                    var2_4 = this.apply(atp);
                } else if (tp instanceof Types.ClassInfoType) {
                    var18_18 = (Types.ClassInfoType)tp;
                    parents = var18_18.parents();
                    decls = var18_18.decls();
                    clazz = var18_18.typeSymbol();
                    if (parents.isEmpty() || clazz == this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ObjectClass() || this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().isPrimitiveValueClass(clazz)) {
                        v3 /* !! */  = Nil$.MODULE$;
                    } else if (clazz == this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ArrayClass()) {
                        var23_22 = this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ObjectTpe();
                        v3 /* !! */  = Nil$.MODULE$.$colon$colon(var23_22);
                    } else {
                        var28_23 = parents;
                        var27_24 = parents;
                        var26_25 = null;
                        mapConserve_loop$1_mappedHead = null;
                        while (true) {
                            if (mapConserve_loop$1_pending.isEmpty()) {
                                if (mapConserve_loop$1_mappedHead == null) {
                                    var37_35 = mapConserve_loop$1_unchanged;
                                    break;
                                }
                                mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                                var37_35 = mapConserve_loop$1_mappedHead;
                                break;
                            }
                            mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                            mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                            if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                                mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                                continue;
                            }
                            mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                            mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                            for (mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                                mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                                if (mapConserve_loop$1_mappedHead1 == null) {
                                    mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                                }
                                if (mapConserve_loop$1_mappedLast1 != null) {
                                    mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                                }
                                mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                            }
                            mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                            if (mapConserve_loop$1_mappedHead1 == null) {
                                mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                            }
                            if (mapConserve_loop$1_mappedLast1 != null) {
                                mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                            }
                            mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                            mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                            mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                            mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                            mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
                        }
                        if (clazz.hasFlag(0x2000000) && !clazz.hasFlag(0x100000)) {
                            var24_36 = this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ObjectTpe();
                            v3 /* !! */  = ((List)((TraversableLike)var37_35.tail()).filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$apply$2$adapted(scala.reflect.internal.transform.Erasure$ErasureMap scala.reflect.internal.Types$Type ), (Lscala/reflect/internal/Types$Type;)Ljava/lang/Object;)((ErasureMap)this))).$colon$colon(var24_36);
                        } else {
                            v3 /* !! */  = var37_35;
                        }
                    }
                    newParents = v3 /* !! */ ;
                    var2_4 = newParents == parents ? tp : new Types.ClassInfoType(this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global(), newParents, decls, clazz);
                } else {
                    var2_4 = tp instanceof Types.BoundedWildcardType != false ? tp : this.mapOver(tp);
                }
            }
            return var2_4;
        }

        public Types.Type applyInArray(Types.Type tp) {
            if (tp.typeSymbol().isDerivedValueClass()) {
                return this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().javaErasure().apply(tp);
            }
            return this.apply(tp);
        }

        public /* synthetic */ Erasure scala$reflect$internal$transform$Erasure$ErasureMap$$$outer() {
            return Erasure.this;
        }

        public static final /* synthetic */ Types.Type $anonfun$apply$1(ErasureMap $this, Types.Type tp) {
            return $this.applyInArray(tp);
        }

        public static final /* synthetic */ boolean $anonfun$apply$2(ErasureMap $this, Types.Type x$3) {
            return x$3.typeSymbol() != $this.scala$reflect$internal$transform$Erasure$ErasureMap$$$outer().global().definitions().ObjectClass();
        }

        public ErasureMap() {
            if (Erasure.this == null) {
                throw null;
            }
            super(Erasure.this.global());
        }

        public static final /* synthetic */ Object $anonfun$apply$2$adapted(ErasureMap $this, Types.Type x$3) {
            return BoxesRunTime.boxToBoolean(ErasureMap.$anonfun$apply$2($this, x$3));
        }
    }

    public class JavaErasureMap
    extends ErasureMap {
        @Override
        public Types.Type mergeParents(List<Types.Type> parents) {
            if (parents.isEmpty()) {
                return this.scala$reflect$internal$transform$Erasure$JavaErasureMap$$$outer().global().definitions().ObjectTpe();
            }
            return parents.head();
        }

        @Override
        public Types.Type eraseDerivedValueClassRef(Types.TypeRef tref) {
            return this.eraseNormalClassRef(tref);
        }

        public /* synthetic */ Erasure scala$reflect$internal$transform$Erasure$JavaErasureMap$$$outer() {
            return this.$outer;
        }

        public JavaErasureMap(Erasure $outer) {
        }
    }

    public class ScalaErasureMap
    extends ErasureMap {
        @Override
        public Types.Type mergeParents(List<Types.Type> parents) {
            return this.scala$reflect$internal$transform$Erasure$ScalaErasureMap$$$outer().intersectionDominator(parents);
        }

        public /* synthetic */ Erasure scala$reflect$internal$transform$Erasure$ScalaErasureMap$$$outer() {
            return this.$outer;
        }

        public ScalaErasureMap(Erasure $outer) {
        }
    }
}

