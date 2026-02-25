/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Function2;
import scala.Predef$;
import scala.Serializable;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.ExistentialsAndSkolems;
import scala.reflect.internal.Names;
import scala.reflect.internal.Reporting;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.StdNames;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.Collections;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001e4\u0001\"\u0003\u0006\u0011\u0002\u0007\u0005\u0011#\u001e\u0005\u0006-\u0001!\ta\u0006\u0005\u00067\u0001!\t\u0001\b\u0005\u0006Y\u0001!\t!\f\u0005\u0006g\u0001!I\u0001\u000e\u0005\u0006\u000f\u0002!)\u0001\u0013\u0005\bC\u0002\t\n\u0011\"\u0002c\u0011\u0015y\u0007\u0001\"\u0002q\u0011\u001d!\b!%A\u0005\u0006\r\u0014a#\u0012=jgR,g\u000e^5bYN\fe\u000eZ*l_2,Wn\u001d\u0006\u0003\u00171\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0003\u001b9\tqA]3gY\u0016\u001cGOC\u0001\u0010\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001\u0001\n\u0011\u0005M!R\"\u0001\b\n\u0005Uq!AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u00021A\u00111#G\u0005\u000359\u0011A!\u00168ji\u0006\u0011B-\u001a:jm\u00164%/Z:i'.|G.Z7t)\ti\"\u0006E\u0002\u001fC\u0011r!aE\u0010\n\u0005\u0001r\u0011a\u00029bG.\fw-Z\u0005\u0003E\r\u0012A\u0001T5ti*\u0011\u0001E\u0004\t\u0003K\u0019j\u0011\u0001A\u0005\u0003O!\u0012aaU=nE>d\u0017BA\u0015\u000b\u0005\u001d\u0019\u00160\u001c2pYNDQa\u000b\u0002A\u0002u\tq\u0001\u001e9be\u0006l7/\u0001\bjgJ\u000bw\u000fU1sC6,G/\u001a:\u0015\u00059\n\u0004CA\n0\u0013\t\u0001dBA\u0004C_>dW-\u00198\t\u000bI\u001a\u0001\u0019\u0001\u0013\u0002\u0007MLX.\u0001\u0011fq&\u001cH/\u001a8uS\u0006d'i\\;oIN,\u0005p\u00197vI&tw\rS5eI\u0016tGCA\u001bF!\u00111T\b\n!\u000f\u0005]Z\u0004C\u0001\u001d\u000f\u001b\u0005I$B\u0001\u001e\u0011\u0003\u0019a$o\\8u}%\u0011AHD\u0001\u0007!J,G-\u001a4\n\u0005yz$aA'ba*\u0011AH\u0004\t\u0003K\u0005K!AQ\"\u0003\tQK\b/Z\u0005\u0003\t*\u0011Q\u0001V=qKNDQA\u0012\u0003A\u0002u\ta\u0001[5eI\u0016t\u0017\u0001F3ySN$XM\u001c;jC2$&/\u00198tM>\u0014X.\u0006\u0002J\u001bR!!jW/`)\tYe\u000b\u0005\u0002M\u001b2\u0001A!\u0002(\u0006\u0005\u0004y%!\u0001+\u0012\u0005A\u001b\u0006CA\nR\u0013\t\u0011fBA\u0004O_RD\u0017N\\4\u0011\u0005M!\u0016BA+\u000f\u0005\r\te.\u001f\u0005\u0006/\u0016\u0001\r\u0001W\u0001\bGJ,\u0017\r^8s!\u0015\u0019\u0012,\b!L\u0013\tQfBA\u0005Gk:\u001cG/[8oe!)A,\u0002a\u0001;\u00059!/Y<Ts6\u001c\b\"\u00020\u0006\u0001\u0004\u0001\u0015A\u0001;q\u0011\u001d\u0001W\u0001%AA\u0002\u0011\n\u0001B]1x\u001f^tWM]\u0001\u001fKbL7\u000f^3oi&\fG\u000e\u0016:b]N4wN]7%I\u00164\u0017-\u001e7uIM*\"a\u00198\u0016\u0003\u0011T#\u0001J3,\u0003\u0019\u0004\"a\u001a7\u000e\u0003!T!!\u001b6\u0002\u0013Ut7\r[3dW\u0016$'BA6\u000f\u0003)\tgN\\8uCRLwN\\\u0005\u0003[\"\u0014\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\t\u0015qeA1\u0001P\u0003-\u0001\u0018mY6Ts6\u0014w\u000e\\:\u0015\t\u0001\u000b(o\u001d\u0005\u0006\r\u001e\u0001\r!\b\u0005\u0006=\u001e\u0001\r\u0001\u0011\u0005\bA\u001e\u0001\n\u00111\u0001%\u0003U\u0001\u0018mY6Ts6\u0014w\u000e\\:%I\u00164\u0017-\u001e7uIM\u0002\"A^<\u000e\u0003)I!\u0001\u001f\u0006\u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface ExistentialsAndSkolems {
    public static /* synthetic */ List deriveFreshSkolems$(ExistentialsAndSkolems $this, List tparams) {
        return $this.deriveFreshSkolems(tparams);
    }

    default public List<Symbols.Symbol> deriveFreshSkolems(List<Symbols.Symbol> tparams) {
        List<Symbols.Symbol> list;
        int saved = ((Types)((Object)this)).skolemizationLevel();
        ((Types)((Object)this)).skolemizationLevel_$eq(0);
        try {
            public class Scala_reflect_internal_ExistentialsAndSkolems$Deskolemizer$1
            extends Types.LazyType {
                private final List<Symbols.Symbol> typeParams;
                private final List<Symbols.TypeSkolem> typeSkolems;

                public List<Symbols.Symbol> typeParams() {
                    return this.typeParams;
                }

                public List<Symbols.TypeSkolem> typeSkolems() {
                    return this.typeSkolems;
                }

                public void complete(Symbols.Symbol sym) {
                    sym.setInfo(sym.deSkolemize().info().substSym(this.typeParams(), this.typeSkolems()));
                }

                public Scala_reflect_internal_ExistentialsAndSkolems$Deskolemizer$1(SymbolTable $outer, List tparams$1) {
                    super($outer);
                    this.typeParams = tparams$1;
                    this.typeSkolems = this.typeParams().map((Function1<Symbols.Symbol, Symbols.TypeSkolem> & java.io.Serializable & Serializable)x$1 -> (Symbols.TypeSkolem)x$1.newTypeSkolem().setInfo(this), List$.MODULE$.canBuildFrom());
                }

                private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                    return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$typeSkolems$1(scala.reflect.internal.ExistentialsAndSkolems$Deskolemizer$1 scala.reflect.internal.Symbols$Symbol )}, serializedLambda);
                }
            }
            list = new Scala_reflect_internal_ExistentialsAndSkolems$Deskolemizer$1((SymbolTable)this, tparams).typeSkolems();
        }
        finally {
            ((Types)((Object)this)).skolemizationLevel_$eq(saved);
        }
        return list;
    }

    public static /* synthetic */ boolean isRawParameter$(ExistentialsAndSkolems $this, Symbols.Symbol sym) {
        return $this.isRawParameter(sym);
    }

    default public boolean isRawParameter(Symbols.Symbol sym) {
        return sym.isTypeParameter() && sym.owner().isJavaDefined();
    }

    private Map<Symbols.Symbol, Types.Type> existentialBoundsExcludingHidden(List<Symbols.Symbol> hidden) {
        Collections cfr_ignored_0 = (Collections)((Object)this);
        Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable mapFrom_f = (Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)s -> {
            Types.Type type;
            Types.Type type2 = s.existentialBound();
            if (type2 instanceof Types.TypeBounds) {
                Types.Type lo = ((Types.TypeBounds)type2).lo();
                type = ((Types)((Object)this)).TypeBounds().apply(lo, this.hiBound$1((Symbols.Symbol)s, hidden));
            } else {
                type = this.hiBound$1((Symbols.Symbol)s, hidden);
            }
            return type;
        };
        return (Map)Predef$.MODULE$.Map().apply(hidden.map(arg_0 -> Collections.$anonfun$mapFrom$1(mapFrom_f, arg_0), List$.MODULE$.canBuildFrom()));
    }

    public static /* synthetic */ Object existentialTransform$(ExistentialsAndSkolems $this, List rawSyms, Types.Type tp, Symbols.Symbol rawOwner, Function2 creator) {
        return $this.existentialTransform(rawSyms, tp, rawOwner, creator);
    }

    default public <T> T existentialTransform(List<Symbols.Symbol> rawSyms, Types.Type tp, Symbols.Symbol rawOwner, Function2<List<Symbols.Symbol>, Types.Type, T> creator) {
        Map<Symbols.Symbol, Types.Type> allBounds = this.existentialBoundsExcludingHidden(rawSyms);
        List typeParams = rawSyms.map((Function1<Symbols.Symbol, Symbols.TypeSymbol> & java.io.Serializable & Serializable)sym -> {
            Names.Name name = sym.name();
            Names.TypeName typeName = name instanceof Names.TypeName ? (Names.TypeName)name : ((StdNames)((Object)this)).tpnme().singletonName(name);
            Types.Type bound = (Types.Type)allBounds.apply((Symbols.Symbol)sym);
            Symbols.Symbol sowner = this.isRawParameter((Symbols.Symbol)sym) ? this.rawOwner0$1(rawOwner, (Symbols.Symbol)sym) : sym.owner();
            Symbols.TypeSymbol quantified = sowner.newExistential(typeName, sym.pos(), sowner.newExistential$default$3());
            return (Symbols.TypeSymbol)quantified.setInfo(bound.cloneInfo(quantified));
        }, List$.MODULE$.canBuildFrom());
        List typeParamTypes = typeParams.map((Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$2 -> x$2.tpeHK(), List$.MODULE$.canBuildFrom());
        List foreach_these = typeParams;
        while (!foreach_these.isEmpty()) {
            Symbols.Symbol symbol = (Symbols.Symbol)foreach_these.head();
            symbol.modifyInfo((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)info -> ExistentialsAndSkolems.doSubst$1(info, rawSyms$1, typeParamTypes$1));
            foreach_these = (List)foreach_these.tail();
        }
        return creator.apply(typeParams, ExistentialsAndSkolems.doSubst$1(tp, rawSyms, typeParamTypes));
    }

    public static /* synthetic */ Symbols.Symbol existentialTransform$default$3$(ExistentialsAndSkolems $this) {
        return $this.existentialTransform$default$3();
    }

    default public <T> Symbols.Symbol existentialTransform$default$3() {
        return ((Symbols)((Object)this)).NoSymbol();
    }

    public static /* synthetic */ Types.Type packSymbols$(ExistentialsAndSkolems $this, List hidden, Types.Type tp, Symbols.Symbol rawOwner) {
        return $this.packSymbols(hidden, tp, rawOwner);
    }

    default public Types.Type packSymbols(List<Symbols.Symbol> hidden, Types.Type tp, Symbols.Symbol rawOwner) {
        if (hidden.isEmpty()) {
            return tp;
        }
        Map<Symbols.Symbol, Types.Type> existentialTransform_allBounds = this.existentialBoundsExcludingHidden(hidden);
        List existentialTransform_typeParams = hidden.map((Function1<Symbols.Symbol, Symbols.TypeSymbol> & java.io.Serializable & Serializable)sym -> {
            Names.Name name = sym.name();
            Names.TypeName typeName = name instanceof Names.TypeName ? (Names.TypeName)name : ((StdNames)((Object)this)).tpnme().singletonName(name);
            Types.Type bound = (Types.Type)allBounds.apply((Symbols.Symbol)sym);
            Symbols.Symbol sowner = this.isRawParameter((Symbols.Symbol)sym) ? this.rawOwner0$1(rawOwner, (Symbols.Symbol)sym) : sym.owner();
            Symbols.TypeSymbol quantified = sowner.newExistential(typeName, sym.pos(), sowner.newExistential$default$3());
            return (Symbols.TypeSymbol)quantified.setInfo(bound.cloneInfo(quantified));
        }, List$.MODULE$.canBuildFrom());
        List existentialTransform_typeParamTypes = existentialTransform_typeParams.map((Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$2 -> x$2.tpeHK(), List$.MODULE$.canBuildFrom());
        List existentialTransform_foreach_these = existentialTransform_typeParams;
        while (!existentialTransform_foreach_these.isEmpty()) {
            Symbols.Symbol symbol = (Symbols.Symbol)existentialTransform_foreach_these.head();
            symbol.modifyInfo((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)info -> ExistentialsAndSkolems.doSubst$1(info, rawSyms$1, typeParamTypes$1));
            existentialTransform_foreach_these = (List)existentialTransform_foreach_these.tail();
        }
        Types.Type type = ExistentialsAndSkolems.doSubst$1(tp, hidden, existentialTransform_typeParamTypes);
        List list = existentialTransform_typeParams;
        return ExistentialsAndSkolems.$anonfun$packSymbols$1(this, list, type);
    }

    public static /* synthetic */ Symbols.Symbol packSymbols$default$3$(ExistentialsAndSkolems $this) {
        return $this.packSymbols$default$3();
    }

    default public Symbols.Symbol packSymbols$default$3() {
        return ((Symbols)((Object)this)).NoSymbol();
    }

    private Types.Type safeBound$1(Types.Type t, List hidden$1) {
        while (hidden$1.contains(t.typeSymbol())) {
            t = t.typeSymbol().existentialBound().upperBound();
            ExistentialsAndSkolems this_ = (SymbolTable)this_;
        }
        return t;
    }

    private Types.Type hiBound$1(Symbols.Symbol s, List hidden$1) {
        Types.Type type;
        Types.Type type2 = this.safeBound$1(s.existentialBound().upperBound(), hidden$1);
        if (type2 instanceof Types.RefinedType) {
            $colon$colon<Nothing$> $colon$colon;
            Types.RefinedType refinedType = (Types.RefinedType)type2;
            List<Types.Type> parents = refinedType.parents();
            Scopes.Scope decls = refinedType.decls();
            if (parents == null) {
                throw null;
            }
            List<Types.Type> list = parents;
            List<Types.Type> list2 = parents;
            Object var9_9 = null;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
            while (true) {
                List mapConserve_loop$1_tail0;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                List mapConserve_loop$1_unchanged;
                List mapConserve_loop$1_pending;
                if (mapConserve_loop$1_pending.isEmpty()) {
                    if (mapConserve_loop$1_mappedHead == null) {
                        $colon$colon = mapConserve_loop$1_unchanged;
                        break;
                    }
                    mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                    $colon$colon = mapConserve_loop$1_mappedHead;
                    break;
                }
                Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                Types.Type type3 = (Types.Type)mapConserve_loop$1_head0;
                Types.Type mapConserve_loop$1_head1 = this.safeBound$1(type3, hidden$1);
                if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                    mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                    continue;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)((Object)mapConserve_loop$1_head1), Nil$.MODULE$);
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
            type = parents == $colon$colon ? refinedType : ((Types)((Object)this)).copyRefinedType(refinedType, $colon$colon, decls);
        } else {
            type = type2;
        }
        return type;
    }

    public static /* synthetic */ Nothing$ $anonfun$existentialTransform$2(ExistentialsAndSkolems $this, Symbols.Symbol sym$1) {
        return ((Reporting)((Object)$this)).abort(new StringBuilder(64).append("no owner provided for existential transform over raw parameter: ").append(sym$1).toString());
    }

    private Symbols.Symbol rawOwner0$1(Symbols.Symbol rawOwner$1, Symbols.Symbol sym$1) {
        if (rawOwner$1 == null) {
            throw null;
        }
        if (rawOwner$1 == rawOwner$1.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
            throw ExistentialsAndSkolems.$anonfun$existentialTransform$2(this, sym$1);
        }
        return rawOwner$1;
    }

    private static Types.Type doSubst$1(Types.Type info, List rawSyms$1, List typeParamTypes$1) {
        return info.subst(rawSyms$1, typeParamTypes$1);
    }

    public static /* synthetic */ Types.Type $anonfun$packSymbols$1(ExistentialsAndSkolems $this, List tparams, Types.Type tpe0) {
        return ((Types)((Object)$this)).existentialAbstraction(tparams, tpe0);
    }

    public static void $init$(ExistentialsAndSkolems $this) {
    }
}

