/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.transform;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.ListBuffer$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.StdAttachments;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.tpe.TypeMaps;
import scala.reflect.internal.transform.UnCurry$;
import scala.reflect.internal.transform.UnCurry$DesugaredParameterType$;
import scala.reflect.internal.transform.UnCurry$VarargsSymbolAttachment$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005UeaB\u0011#!\u0003\r\ta\u000b\u0005\u0006a\u0001!\t!\r\u0005\bk\u0001\u0011\rQ\"\u00017\r\u0011Y\u0004\u0001\u0011\u001f\t\u0011\r\u001b!Q3A\u0005\u0002\u0011C\u0001\u0002T\u0002\u0003\u0012\u0003\u0006I!\u0012\u0005\u0006\u001b\u000e!\tA\u0014\u0005\b#\u000e\t\t\u0011\"\u0001S\u0011\u001d!6!%A\u0005\u0002UCq\u0001Y\u0002\u0002\u0002\u0013\u0005\u0013\rC\u0004k\u0007\u0005\u0005I\u0011A6\t\u000f=\u001c\u0011\u0011!C\u0001a\"9aoAA\u0001\n\u0003:\bb\u0002@\u0004\u0003\u0003%\ta \u0005\n\u0003\u0013\u0019\u0011\u0011!C!\u0003\u0017A\u0011\"!\u0004\u0004\u0003\u0003%\t%a\u0004\t\u0013\u0005E1!!A\u0005B\u0005Mq!CA\f\u0001\u0005\u0005\t\u0012AA\r\r!Y\u0004!!A\t\u0002\u0005m\u0001BB'\u0013\t\u0003\tI\u0003C\u0005\u0002\u000eI\t\t\u0011\"\u0012\u0002\u0010!I\u00111\u0006\n\u0002\u0002\u0013\u0005\u0015Q\u0006\u0005\n\u0003c\u0011\u0012\u0011!CA\u0003gAq!a\u0010\u0001\t\u0013\t\t\u0005C\u0005\u0002R\u0001\u0011\r\u0011\"\u0001\u0002T\u001d9\u00111\r\u0001\t\u0002\u0005\u0015daBA4\u0001!\u0005\u0011\u0011\u000e\u0005\u0007\u001bj!\t!a\u001b\t\u000f\u00055$\u0004\"\u0001\u0002p!9\u0011\u0011\u0007\u000e\u0005\u0002\u0005M\u0004\"CA=\u0001\t\u0007I\u0011BA*\u0011\u001d\tY\b\u0001C\u0005\u0003{Bq!a#\u0001\t\u0003\tiIA\u0004V]\u000e+(O]=\u000b\u0005\r\"\u0013!\u0003;sC:\u001chm\u001c:n\u0015\t)c%\u0001\u0005j]R,'O\\1m\u0015\t9\u0003&A\u0004sK\u001adWm\u0019;\u000b\u0003%\nQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001YA\u0011QFL\u0007\u0002Q%\u0011q\u0006\u000b\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%)\u0005\u0011\u0004CA\u00174\u0013\t!\u0004F\u0001\u0003V]&$\u0018AB4m_\n\fG.F\u00018!\tA\u0014(D\u0001%\u0013\tQDEA\u0006Ts6\u0014w\u000e\u001c+bE2,'a\u0006,be\u0006\u0014xm]*z[\n|G.\u0011;uC\u000eDW.\u001a8u'\u0011\u0019A&\u0010!\u0011\u00055r\u0014BA )\u0005\u001d\u0001&o\u001c3vGR\u0004\"!L!\n\u0005\tC#\u0001D*fe&\fG.\u001b>bE2,\u0017\u0001\u0004<be\u0006\u0014x-T3uQ>$W#A#\u0011\u0005\u0019CeBA$\u0003\u001b\u0005\u0001\u0011BA%K\u0005\u0019\u0019\u00160\u001c2pY&\u00111\n\n\u0002\b'fl'm\u001c7t\u000351\u0018M]1sO6+G\u000f[8eA\u00051A(\u001b8jiz\"\"a\u0014)\u0011\u0005\u001d\u001b\u0001\"B\"\u0007\u0001\u0004)\u0015\u0001B2paf$\"aT*\t\u000f\r;\u0001\u0013!a\u0001\u000b\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#\u0001,+\u0005\u0015;6&\u0001-\u0011\u0005esV\"\u0001.\u000b\u0005mc\u0016!C;oG\",7m[3e\u0015\ti\u0006&\u0001\u0006b]:|G/\u0019;j_:L!a\u0018.\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0002EB\u00111\r[\u0007\u0002I*\u0011QMZ\u0001\u0005Y\u0006twMC\u0001h\u0003\u0011Q\u0017M^1\n\u0005%$'AB*ue&tw-\u0001\u0007qe>$Wo\u0019;Be&$\u00180F\u0001m!\tiS.\u0003\u0002oQ\t\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u0011\u0011\u000f\u001e\t\u0003[IL!a\u001d\u0015\u0003\u0007\u0005s\u0017\u0010C\u0004v\u0017\u0005\u0005\t\u0019\u00017\u0002\u0007a$\u0013'A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\u0005A\bcA=}c6\t!P\u0003\u0002|Q\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005uT(\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$B!!\u0001\u0002\bA\u0019Q&a\u0001\n\u0007\u0005\u0015\u0001FA\u0004C_>dW-\u00198\t\u000fUl\u0011\u0011!a\u0001c\u0006A\u0001.Y:i\u0007>$W\rF\u0001m\u0003!!xn\u0015;sS:<G#\u00012\u0002\r\u0015\fX/\u00197t)\u0011\t\t!!\u0006\t\u000fU\u0004\u0012\u0011!a\u0001c\u00069b+\u0019:be\u001e\u001c8+_7c_2\fE\u000f^1dQ6,g\u000e\u001e\t\u0003\u000fJ\u0019BAEA\u000f\u0001B1\u0011qDA\u0013\u000b>k!!!\t\u000b\u0007\u0005\r\u0002&A\u0004sk:$\u0018.\\3\n\t\u0005\u001d\u0012\u0011\u0005\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\fDCAA\r\u0003\u0015\t\u0007\u000f\u001d7z)\ry\u0015q\u0006\u0005\u0006\u0007V\u0001\r!R\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\t)$a\u000f\u0011\t5\n9$R\u0005\u0004\u0003sA#AB(qi&|g\u000e\u0003\u0005\u0002>Y\t\t\u00111\u0001P\u0003\rAH\u0005M\u0001\fKb\u0004\u0018M\u001c3BY&\f7\u000f\u0006\u0003\u0002D\u00055\u0003c\u0001$\u0002F%!\u0011qIA%\u0005\u0011!\u0016\u0010]3\n\u0007\u0005-CEA\u0003UsB,7\u000fC\u0004\u0002P]\u0001\r!a\u0011\u0002\u0005Q\u0004\u0018aB;oGV\u0014(/_\u000b\u0003\u0003+\u00022ARA,\u0013\u0011\tI&a\u0017\u0003\u000fQK\b/Z'ba&!\u0011QLA0\u0005!!\u0016\u0010]3NCB\u001c(bAA1I\u0005\u0019A\u000f]3\u0002-\u0011+7/^4be\u0016$\u0007+\u0019:b[\u0016$XM\u001d+za\u0016\u0004\"a\u0012\u000e\u0003-\u0011+7/^4be\u0016$\u0007+\u0019:b[\u0016$XM\u001d+za\u0016\u001c\"A\u0007\u0017\u0015\u0005\u0005\u0015\u0014AE5t+:\u0014w.\u001e8eK\u0012<UM\\3sS\u000e$B!!\u0001\u0002r!9\u0011q\n\u000fA\u0002\u0005\rC\u0003BA;\u0003o\u0002R!LA\u001c\u0003\u0007Bq!!\u0019\u001e\u0001\u0004\t\u0019%A\u0006v]\u000e,(O]=UsB,\u0017A\u0005<be\u0006\u0014xMR8so\u0006\u0014H-\u001a:Ts6$r!RA@\u0003\u0007\u000b9\t\u0003\u0004\u0002\u0002~\u0001\r!R\u0001\rGV\u0014(/\u001a8u\u00072\f7o\u001d\u0005\u0007\u0003\u000b{\u0002\u0019A#\u0002\u000f=\u0014\u0018nZ*z[\"9\u0011\u0011R\u0010A\u0002\u0005\r\u0013a\u00028fo&sgm\\\u0001\u000eiJ\fgn\u001d4pe6LeNZ8\u0015\r\u0005\r\u0013qRAJ\u0011\u0019\t\t\n\ta\u0001\u000b\u0006\u00191/_7\t\u000f\u0005=\u0003\u00051\u0001\u0002D\u0001")
public interface UnCurry {
    public UnCurry$VarargsSymbolAttachment$ VarargsSymbolAttachment();

    public UnCurry$DesugaredParameterType$ DesugaredParameterType();

    public void scala$reflect$internal$transform$UnCurry$_setter_$uncurry_$eq(TypeMaps.TypeMap var1);

    public void scala$reflect$internal$transform$UnCurry$_setter_$scala$reflect$internal$transform$UnCurry$$uncurryType_$eq(TypeMaps.TypeMap var1);

    public SymbolTable global();

    public static /* synthetic */ Types.Type scala$reflect$internal$transform$UnCurry$$expandAlias$(UnCurry $this, Types.Type tp) {
        return $this.scala$reflect$internal$transform$UnCurry$$expandAlias(tp);
    }

    default public Types.Type scala$reflect$internal$transform$UnCurry$$expandAlias(Types.Type tp) {
        if (!tp.isHigherKinded()) {
            return tp.normalize();
        }
        return tp;
    }

    public TypeMaps.TypeMap uncurry();

    public TypeMaps.TypeMap scala$reflect$internal$transform$UnCurry$$uncurryType();

    public static /* synthetic */ Symbols.Symbol scala$reflect$internal$transform$UnCurry$$varargForwarderSym$(UnCurry $this, Symbols.Symbol currentClass, Symbols.Symbol origSym, Types.Type newInfo) {
        return $this.scala$reflect$internal$transform$UnCurry$$varargForwarderSym(currentClass, origSym, newInfo);
    }

    /*
     * WARNING - void declaration
     */
    default public Symbols.Symbol scala$reflect$internal$transform$UnCurry$$varargForwarderSym(Symbols.Symbol currentClass, Symbols.Symbol origSym, Types.Type newInfo) {
        void foreach2_xs2;
        void foreach2_xs1;
        Symbols.Symbol forwSym = origSym.cloneSymbol(currentClass, 0x80000200000L | origSym.flags() & (long)(~16), origSym.name().toTermName()).withoutAnnotations();
        List<List<Symbols.Symbol>> list = origSym.info().paramss();
        List<List<Symbols.Symbol>> list2 = forwSym.paramss();
        if (this.global() == null) {
            throw null;
        }
        List foreach2_ys1 = foreach2_xs1;
        List foreach2_ys2 = foreach2_xs2;
        while (!foreach2_ys1.isEmpty() && !foreach2_ys2.isEmpty()) {
            List list3 = (List)foreach2_ys2.head();
            List list4 = (List)foreach2_ys1.head();
            UnCurry.$anonfun$varargForwarderSym$1(this, list4, list3);
            foreach2_ys1 = (List)foreach2_ys1.tail();
            foreach2_ys2 = (List)foreach2_ys2.tail();
        }
        origSym.updateAttachment(new VarargsSymbolAttachment(this, forwSym), ClassTag$.MODULE$.apply(VarargsSymbolAttachment.class));
        return forwSym;
    }

    public static /* synthetic */ Types.Type transformInfo$(UnCurry $this, Symbols.Symbol sym, Types.Type tp) {
        return $this.transformInfo(sym, tp);
    }

    default public Types.Type transformInfo(Symbols.Symbol sym, Types.Type tp) {
        if (sym.isType()) {
            return this.scala$reflect$internal$transform$UnCurry$$uncurryType().apply(tp);
        }
        if (sym.hasFlag(256) && !sym.isStatic()) {
            sym.setFlag(0x400040L);
            return new Types.MethodType(this.global(), Nil$.MODULE$, this.uncurry().apply(tp));
        }
        return this.uncurry().apply(tp);
    }

    private Types.Type toArrayType$1(Types.Type tp, Symbols.Symbol newParam) {
        Types.Type type;
        Types.Type arg = this.global().definitions().elementType(this.global().definitions().SeqClass(), tp);
        if (arg.typeSymbol().isTypeParameterOrSkolem() && !arg.$less$colon$less(this.global().definitions().AnyRefTpe())) {
            newParam.updateAttachment(new StdAttachments.TypeParamVarargsAttachment(this.global(), arg), ClassTag$.MODULE$.apply(StdAttachments.TypeParamVarargsAttachment.class));
            type = this.global().definitions().ObjectTpe();
        } else {
            type = arg;
        }
        Types.Type elem = type;
        return this.global().definitions().arrayType(elem);
    }

    public static /* synthetic */ void $anonfun$varargForwarderSym$2(UnCurry $this, Symbols.Symbol p, Symbols.Symbol sym) {
        if ($this.global().definitions().isRepeatedParamType(sym.tpe())) {
            p.setInfo($this.toArrayType$1(p.info(), p));
        }
    }

    public static /* synthetic */ void $anonfun$varargForwarderSym$1(UnCurry $this, List fsps, List origPs) {
        if ($this.global() == null) {
            throw null;
        }
        List foreach2_ys1 = fsps;
        List foreach2_ys2 = origPs;
        while (!foreach2_ys1.isEmpty() && !foreach2_ys2.isEmpty()) {
            Symbols.Symbol symbol = (Symbols.Symbol)foreach2_ys2.head();
            Symbols.Symbol symbol2 = (Symbols.Symbol)foreach2_ys1.head();
            UnCurry.$anonfun$varargForwarderSym$2($this, symbol2, symbol);
            foreach2_ys1 = (List)foreach2_ys1.tail();
            foreach2_ys2 = (List)foreach2_ys2.tail();
        }
    }

    public static void $init$(UnCurry $this) {
        $this.scala$reflect$internal$transform$UnCurry$_setter_$uncurry_$eq(new TypeMaps.TypeMap($this){
            private final /* synthetic */ UnCurry $outer;

            public Types.Type apply(Types.Type tp0) {
                Types.Type tp;
                while (true) {
                    Types.Type type;
                    tp = this.$outer.scala$reflect$internal$transform$UnCurry$$expandAlias(tp0);
                    boolean bl = false;
                    Types.MethodType methodType = null;
                    if (tp instanceof Types.MethodType) {
                        bl = true;
                        methodType = (Types.MethodType)tp;
                        List<Symbols.Symbol> params = methodType.params();
                        Types.Type type2 = methodType.resultType();
                        if (type2 instanceof Types.MethodType) {
                            Types.MethodType methodType2 = (Types.MethodType)type2;
                            List<Symbols.Symbol> params1 = methodType2.params();
                            Types.Type restpe = methodType2.resultType();
                            List<Symbols.Symbol> existentiallyAbstractedParam1s = new TypeMaps.TypeMap(this, params){
                                private final /* synthetic */ $anon$1 $outer;
                                private final List params$1;

                                public Types.Type apply(Types.Type tp) {
                                    return this.$outer.scala$reflect$internal$transform$UnCurry$$anon$$$outer().global().packSymbols(this.params$1, tp, this.$outer.scala$reflect$internal$transform$UnCurry$$anon$$$outer().global().packSymbols$default$3());
                                }
                                {
                                    if ($outer == null) {
                                        throw null;
                                    }
                                    this.$outer = $outer;
                                    this.params$1 = params$1;
                                    super($outer.scala$reflect$internal$transform$UnCurry$$anon$$$outer().global());
                                }
                            }.mapOver(params1);
                            Types.Type substitutedResult = restpe.substSym(params1, existentiallyAbstractedParam1s);
                            tp0 = new Types.MethodType(this.$outer.global(), existentiallyAbstractedParam1s.$colon$colon$colon(params), substitutedResult);
                            continue;
                        }
                    }
                    if (bl && (type = methodType.resultType()) instanceof Types.ExistentialType && ((Types.ExistentialType)type).underlying() instanceof Types.MethodType) {
                        throw this.$outer.global().abort("unexpected curried method types with intervening existential");
                    }
                    if (bl) {
                        List<Symbols.Symbol> list = methodType.params();
                        Types.Type restpe = methodType.resultType();
                        if (list instanceof $colon$colon) {
                            $colon$colon $colon$colon = ($colon$colon)list;
                            Symbols.Symbol h = (Symbols.Symbol)$colon$colon.head();
                            List<Symbols.Symbol> t = $colon$colon.tl$access$1();
                            if (h.isImplicit()) {
                                Symbols.Symbol symbol = h.cloneSymbol().resetFlag(512L);
                                tp0 = new Types.MethodType(this.$outer.global(), t.$colon$colon(symbol), restpe);
                                continue;
                            }
                        }
                    }
                    if (tp instanceof Types.NullaryMethodType) {
                        Types.Type restpe = ((Types.NullaryMethodType)tp).resultType();
                        tp0 = new Types.MethodType(this.$outer.global(), Nil$.MODULE$, restpe);
                        continue;
                    }
                    Option<Types.Type> option = this.$outer.DesugaredParameterType().unapply(tp);
                    if (option.isEmpty()) break;
                    tp0 = option.get();
                }
                return this.$outer.scala$reflect$internal$transform$UnCurry$$expandAlias(this.mapOver(tp));
            }

            public /* synthetic */ UnCurry scala$reflect$internal$transform$UnCurry$$anon$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super($outer.global());
            }
        });
        $this.scala$reflect$internal$transform$UnCurry$_setter_$scala$reflect$internal$transform$UnCurry$$uncurryType_$eq(new TypeMaps.TypeMap($this){
            private final /* synthetic */ UnCurry $outer;

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public Types.Type apply(Types.Type tp0) {
                Types.Type tp = this.$outer.scala$reflect$internal$transform$UnCurry$$expandAlias(tp0);
                if (tp instanceof Types.ClassInfoType) {
                    Types.ClassInfoType classInfoType = (Types.ClassInfoType)tp;
                    List<Types.Type> parents = classInfoType.parents();
                    Scopes.Scope decls = classInfoType.decls();
                    Symbols.Symbol clazz = classInfoType.typeSymbol();
                    if (!clazz.isJavaDefined()) {
                        Types.Type type;
                        $colon$colon<Nothing$> $colon$colon;
                        TypeMaps.TypeMap typeMap = this.$outer.uncurry();
                        if (parents == null) {
                            throw null;
                        }
                        List<Types.Type> list = parents;
                        List<Types.Type> list2 = parents;
                        Object var12_10 = null;
                        $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
                        while (true) {
                            List mapConserve_loop$1_tail0;
                            void mapConserve_f;
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
                            A mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                            R mapConserve_loop$1_head1 = mapConserve_f.apply(mapConserve_loop$1_head0);
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
                            $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
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
                        ListBuffer varargOverloads = (ListBuffer)ListBuffer$.MODULE$.empty();
                        decls.withFilter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)decl -> BoxesRunTime.boxToBoolean($anon$3.$anonfun$apply$1(this, decl))).foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)decl -> {
                            boolean bl;
                            block9: {
                                void mexists_xss;
                                Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean($anon$3.$anonfun$apply$4(this, sym));
                                List<List<Symbols.Symbol>> list = decl.paramss();
                                if ($this.$outer.global() == null) {
                                    throw null;
                                }
                                if (mexists_xss == null) {
                                    throw null;
                                }
                                LinearSeqOptimized mexists_exists_these = mexists_xss;
                                while (!mexists_exists_these.isEmpty()) {
                                    boolean bl2;
                                    block8: {
                                        List list2 = (List)mexists_exists_these.head();
                                        if (list2 == null) {
                                            throw null;
                                        }
                                        LinearSeqOptimized<A, List<A>> $anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these = list2;
                                        while (!$anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these.isEmpty()) {
                                            void mexists_p;
                                            if (BoxesRunTime.unboxToBoolean(mexists_p.apply($anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these.head()))) {
                                                bl2 = true;
                                                break block8;
                                            }
                                            $anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these = (LinearSeqOptimized)$anonfun$mexists$1$adapted_$anonfun$mexists$1_exists_these.tail();
                                        }
                                        bl2 = false;
                                    }
                                    if (bl2) {
                                        bl = true;
                                        break block9;
                                    }
                                    mexists_exists_these = (LinearSeqOptimized)mexists_exists_these.tail();
                                }
                                bl = false;
                            }
                            if (bl) {
                                return varargOverloads.$plus$eq($this.$outer.scala$reflect$internal$transform$UnCurry$$varargForwarderSym(clazz, (Symbols.Symbol)decl, (Types.Type)$this.$outer.global().exitingPhase($this.$outer.global().phase(), (Function0<Types.Type> & java.io.Serializable & Serializable)() -> decl.info())));
                            }
                            return BoxedUnit.UNIT;
                        });
                        if ($colon$colon == parents && varargOverloads.isEmpty()) {
                            type = tp;
                            return type;
                        } else {
                            void foreach_f;
                            Scopes.Scope newDecls = decls.cloneScope();
                            Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)sym -> newDecls.enter(sym);
                            if (varargOverloads == null) {
                                throw null;
                            }
                            varargOverloads.underlying().foreach(foreach_f);
                            type = new Types.ClassInfoType(this.$outer.global(), $colon$colon, newDecls, clazz);
                        }
                        return type;
                    }
                }
                if (!(tp instanceof Types.PolyType)) return tp;
                return this.mapOver(tp);
            }

            public static final /* synthetic */ boolean $anonfun$apply$2($anon$3 $this, AnnotationInfos.AnnotationInfo x$3) {
                Symbols.Symbol symbol = x$3.symbol();
                Symbols.ClassSymbol classSymbol = $this.$outer.global().definitions().VarargsClass();
                return !(symbol != null ? !symbol.equals(classSymbol) : classSymbol != null);
            }

            public static final /* synthetic */ boolean $anonfun$apply$1($anon$3 $this, Symbols.Symbol decl) {
                boolean bl;
                block3: {
                    List<AnnotationInfos.AnnotationInfo> list = decl.annotations();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized<A, List<A>> exists_these = list;
                    while (!exists_these.isEmpty()) {
                        AnnotationInfos.AnnotationInfo annotationInfo = (AnnotationInfos.AnnotationInfo)exists_these.head();
                        if ($anon$3.$anonfun$apply$2($this, annotationInfo)) {
                            bl = true;
                            break block3;
                        }
                        exists_these = (LinearSeqOptimized)exists_these.tail();
                    }
                    bl = false;
                }
                return bl;
            }

            public static final /* synthetic */ boolean $anonfun$apply$4($anon$3 $this, Symbols.Symbol sym) {
                return $this.$outer.global().definitions().isRepeatedParamType(sym.tpe());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super($outer.global());
            }

            public static final /* synthetic */ Object $anonfun$apply$2$adapted($anon$3 $this, AnnotationInfos.AnnotationInfo x$3) {
                return BoxesRunTime.boxToBoolean($anon$3.$anonfun$apply$2($this, x$3));
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$1$adapted(scala.reflect.internal.transform.UnCurry$$anon$3 scala.reflect.internal.Symbols$Symbol ), $anonfun$apply$3(scala.reflect.internal.transform.UnCurry$$anon$3 scala.collection.mutable.ListBuffer scala.reflect.internal.Symbols$Symbol scala.reflect.internal.Symbols$Symbol ), $anonfun$apply$6(scala.reflect.internal.Scopes$Scope scala.reflect.internal.Symbols$Symbol ), $anonfun$apply$2$adapted(scala.reflect.internal.transform.UnCurry$$anon$3 scala.reflect.internal.AnnotationInfos$AnnotationInfo ), $anonfun$apply$4$adapted(scala.reflect.internal.transform.UnCurry$$anon$3 scala.reflect.internal.Symbols$Symbol ), $anonfun$apply$5(scala.reflect.internal.Symbols$Symbol ), $anonfun$mexists$1$adapted(scala.Function1 scala.collection.immutable.List )}, serializedLambda);
            }
        });
    }

    public static /* synthetic */ Object $anonfun$varargForwarderSym$1$adapted(UnCurry $this, List fsps, List origPs) {
        UnCurry.$anonfun$varargForwarderSym$1($this, fsps, origPs);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$varargForwarderSym$2$adapted(UnCurry $this, Symbols.Symbol p, Symbols.Symbol sym) {
        UnCurry.$anonfun$varargForwarderSym$2($this, p, sym);
        return BoxedUnit.UNIT;
    }

    public class VarargsSymbolAttachment
    implements Product,
    Serializable {
        private final Symbols.Symbol varargMethod;
        public final /* synthetic */ UnCurry $outer;

        public Symbols.Symbol varargMethod() {
            return this.varargMethod;
        }

        public VarargsSymbolAttachment copy(Symbols.Symbol varargMethod) {
            return new VarargsSymbolAttachment(this.scala$reflect$internal$transform$UnCurry$VarargsSymbolAttachment$$$outer(), varargMethod);
        }

        public Symbols.Symbol copy$default$1() {
            return this.varargMethod();
        }

        @Override
        public String productPrefix() {
            return "VarargsSymbolAttachment";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.varargMethod();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof VarargsSymbolAttachment;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof VarargsSymbolAttachment && ((VarargsSymbolAttachment)x$1).scala$reflect$internal$transform$UnCurry$VarargsSymbolAttachment$$$outer() == this.scala$reflect$internal$transform$UnCurry$VarargsSymbolAttachment$$$outer();
                    if (!bl) break block3;
                    VarargsSymbolAttachment varargsSymbolAttachment = (VarargsSymbolAttachment)x$1;
                    Symbols.Symbol symbol = this.varargMethod();
                    Symbols.Symbol symbol2 = varargsSymbolAttachment.varargMethod();
                    if (!(!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null) && varargsSymbolAttachment.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ UnCurry scala$reflect$internal$transform$UnCurry$VarargsSymbolAttachment$$$outer() {
            return this.$outer;
        }

        public VarargsSymbolAttachment(UnCurry $outer, Symbols.Symbol varargMethod) {
            this.varargMethod = varargMethod;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }
}

