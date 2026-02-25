/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.tpe;

import java.lang.invoke.LambdaMetafactory;
import scala.Console$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.GenSeq;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.SeqLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.ListBuffer$;
import scala.math.Ordering$Int$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.AnnotationCheckers;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Depth;
import scala.reflect.internal.Depth$;
import scala.reflect.internal.Names;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoType$;
import scala.reflect.internal.TypesStats;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.tpe.CommonOwners;
import scala.reflect.internal.tpe.TypeComparers;
import scala.reflect.internal.tpe.TypeMaps;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.Statistics;
import scala.reflect.internal.util.StatisticsStatics;
import scala.reflect.internal.util.TableDef;
import scala.reflect.internal.util.TableDef$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\u0005]fA\u0003\u0011\"!\u0003\r\taI\u0015\u00022\")a\u0006\u0001C\u0001a!9A\u0007\u0001b\u0001\n\u001b)\u0004bB\u001d\u0001\u0005\u0004%iA\u000f\u0005\b\t\u0002\u0011\r\u0011\"\u0004F\u0011\u0015A\u0005\u0001\"\u0003J\u0011\u0015Q\u0007\u0001\"\u0001l\u0011\u00159\b\u0001\"\u0003y\u0011\u0015q\b\u0001\"\u0001\u0000\u0011\u001d\t)\u0001\u0001C\u0005\u0003\u000fAq!!\u0004\u0001\t\u0003\ty\u0001C\u0004\u0002\u0014\u0001!I!!\u0006\t\u000f\u0005e\u0001\u0001\"\u0003\u0002\u001c!9\u0011\u0011\u0005\u0001\u0005\u0002\u0005\r\u0002bBA\u0014\u0001\u0011\u0005\u0011\u0011\u0006\u0005\b\u0003[\u0001A\u0011AA\u0018\u0011%\t\u0019\u0004\u0001b\u0001\n\u0013\t)\u0004C\u0004\u0002J\u0001!\t!!\u000e\t\u0013\u0005-\u0003A1A\u0005\n\u0005U\u0002bBA'\u0001\u0011\u0005\u0011Q\u0007\u0005\b\u0003\u001f\u0002A\u0011AA)\u0011!\ty\u0005\u0001C\tG\u0005U\u0003\"CA.\u0001\t\u0007I\u0011AA/\u0011%\ty\u0007\u0001a\u0001\n\u0013\t\t\bC\u0005\u0002t\u0001\u0001\r\u0011\"\u0003\u0002v!I\u00111\u0010\u0001C\u0002\u00135\u0011\u0011\u000f\u0005\b\u0003{\u0002A\u0011AA@\u0011!\ti\b\u0001C\tG\u0005\r\u0005bBAE\u0001\u0011E\u00111\u0012\u0005\b\u0003#\u0003A\u0011BAJ\u0011\u001d\ty\n\u0001C\u0005\u0003CCq!a*\u0001\t\u0013\tIKA\u0004HY\ndUOY:\u000b\u0005\t\u001a\u0013a\u0001;qK*\u0011A%J\u0001\tS:$XM\u001d8bY*\u0011aeJ\u0001\be\u00164G.Z2u\u0015\u0005A\u0013!B:dC2\f7C\u0001\u0001+!\tYC&D\u0001(\u0013\tisE\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0004\u0001Q\t\u0011\u0007\u0005\u0002,e%\u00111g\n\u0002\u0005+:LG/A\u0005qe&tG\u000fT;cgV\ta\u0007\u0005\u0002,o%\u0011\u0001h\n\u0002\b\u0005>|G.Z1o\u0003=\u0019HO]5di&sg-\u001a:f]\u000e,W#A\u001e\u0011\u0005q\u0012\u0005CA\u001fA\u001b\u0005q$BA $\u0003!\u0019X\r\u001e;j]\u001e\u001c\u0018BA!?\u0005=iU\u000f^1cY\u0016\u001cV\r\u001e;j]\u001e\u001c\u0018BA\"A\u00059\u0011un\u001c7fC:\u001cV\r\u001e;j]\u001e\f!B^3sS\u001aLH*\u001e2t+\u00051u\"A$\u001a\u0003\u0005\ta\u0002\u001d:j]RdUOY'biJL\u0007\u0010F\u00022\u0015\u0012DQaS\u0003A\u00021\u000baA\u0019;t\u001b\u0006\u0004\b\u0003B'U/vs!A\u0014*\u0011\u0005=;S\"\u0001)\u000b\u0005E{\u0013A\u0002\u001fs_>$h(\u0003\u0002TO\u00051\u0001K]3eK\u001aL!!\u0016,\u0003\u00075\u000b\u0007O\u0003\u0002TOA\u0011\u0001,W\u0007\u0002\u0001%\u0011!l\u0017\u0002\u0005)f\u0004X-\u0003\u0002]G\t)A+\u001f9fgB\u0019a,Y,\u000f\u0005-z\u0016B\u00011(\u0003\u001d\u0001\u0018mY6bO\u0016L!AY2\u0003\t1K7\u000f\u001e\u0006\u0003A\u001eBQ!Z\u0003A\u0002\u0019\fQ\u0001Z3qi\"\u0004\"a\u001a5\u000e\u0003\rJ!![\u0012\u0003\u000b\u0011+\u0007\u000f\u001e5\u0002'\u0019Lg\u000e\u001a*fGV\u00148/\u001b<f\u0005>,h\u000eZ:\u0015\u00051,\bc\u00010b[B!1F\u001c9q\u0013\tywE\u0001\u0004UkBdWM\r\t\u00031FL!A]:\u0003\rMKXNY8m\u0013\t!8EA\u0004Ts6\u0014w\u000e\\:\t\u000bY4\u0001\u0019A/\u0002\u0005Q\u001c\u0018AG<jY24\u0016n\u001c7bi\u0016\u0014VmY;sg&4XMQ8v]\u0012\u001cH\u0003\u0002\u001czwrDQA_\u0004A\u0002]\u000b!\u0001\u001e9\t\u000bY<\u0001\u0019A/\t\u000bu<\u0001\u0019A/\u0002\u0013Q\u001cX\t\\5n'V\u0014\u0017a\u00027vE2K7\u000f\u001e\u000b\u0006;\u0006\u0005\u00111\u0001\u0005\u0006m\"\u0001\r!\u0018\u0005\u0006K\"\u0001\rAZ\u0001\u0007[&t7+_7\u0015\u0007A\fI\u0001\u0003\u0004\u0002\f%\u0001\r!X\u0001\u0004iB\u001c\u0018!D:qC:t\u0017N\\4UsB,7\u000fF\u0002^\u0003#AQA\u001e\u0006A\u0002u\u000b\u0011\"\u001a7j[N+\b/\u001a:\u0015\u0007u\u000b9\u0002C\u0003w\u0017\u0001\u0007Q,A\u0004fY&l7+\u001e2\u0015\u000bu\u000bi\"a\b\t\u000bYd\u0001\u0019A/\t\u000b\u0015d\u0001\u0019\u00014\u0002!M\fW.Z,fC.dUOY!t\u0019V\u0014Gc\u0001\u001c\u0002&!1\u00111B\u0007A\u0002u\u000bqa^3bW2+(\rF\u0002X\u0003WAa!a\u0003\u000f\u0001\u0004i\u0016A\u00038v[\u0016\u0014\u0018n\u0019'vER\u0019q+!\r\t\u000bY|\u0001\u0019A/\u0002\u0017}cWO\u0019*fgVdGo]\u000b\u0003\u0003o\u0001r!!\u000f\u0002D\u0005\u001ds+\u0004\u0002\u0002<)!\u0011QHA \u0003\u001diW\u000f^1cY\u0016T1!!\u0011(\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003\u000b\nYDA\u0004ICNDW*\u00199\u0011\t-rg-X\u0001\u000bYV\u0014'+Z:vYR\u001c\u0018aC0hY\n\u0014Vm];miN\f!b\u001a7c%\u0016\u001cX\u000f\u001c;t\u0003\raWO\u0019\u000b\u0004/\u0006M\u0003\"\u0002<\u0015\u0001\u0004iF#B,\u0002X\u0005e\u0003\"\u0002<\u0016\u0001\u0004i\u0006\"B3\u0016\u0001\u00041\u0017AC$mE\u001a\u000b\u0017\u000e\\;sKV\u0011\u0011q\f\t\u0005\u0003C\nY'\u0004\u0002\u0002d)!\u0011QMA4\u0003\u0011a\u0017M\\4\u000b\u0005\u0005%\u0014\u0001\u00026bm\u0006LA!!\u001c\u0002d\tIA\u000b\u001b:po\u0006\u0014G.Z\u0001\u000fO2|'-\u00197HY\n$U\r\u001d;i+\u00051\u0017AE4m_\n\fGn\u00127c\t\u0016\u0004H\u000f[0%KF$2!MA<\u0011!\tI\bGA\u0001\u0002\u00041\u0017a\u0001=%c\u0005qq\r\\8cC2<EN\u0019'j[&$\u0018aA4mER\u0019q+!!\t\u000bYT\u0002\u0019A/\u0015\u000b]\u000b))a\"\t\u000bY\\\u0002\u0019A/\t\u000b\u0015\\\u0002\u0019\u00014\u0002\u000f\u001dd'MT8s[R)q+!$\u0002\u0010\")a\u000f\ba\u0001;\")Q\r\ba\u0001M\u0006qQ.\u0019;dQ&twMQ8v]\u0012\u001cHCBAK\u0003/\u000bI\nE\u0002_CvCa!a\u0003\u001e\u0001\u0004i\u0006bBAN;\u0001\u0007\u0011QT\u0001\biB\f'/Y7t!\rq\u0016\r]\u0001\u0012[\u0006$8\r[5oO&s7\u000f\u001e+za\u0016\u001cH#B/\u0002$\u0006\u0015\u0006BBA\u0006=\u0001\u0007Q\fC\u0004\u0002\u001cz\u0001\r!!(\u0002!5\fGo\u00195j]\u001e\u0014Vm\u001d;za\u0016\u001cH#B/\u0002,\u00065\u0006BBA\u0006?\u0001\u0007Q\f\u0003\u0004\u00020~\u0001\r!X\u0001\u0004aR\u001c\bcA4\u00024&\u0019\u0011QW\u0012\u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface GlbLubs {
    public void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$printLubs_$eq(boolean var1);

    public void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$strictInference_$eq(MutableSettings.SettingValue var1);

    public void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$_lubResults_$eq(HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> var1);

    public void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$_glbResults_$eq(HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> var1);

    public void scala$reflect$internal$tpe$GlbLubs$_setter_$GlbFailure_$eq(Throwable var1);

    public void scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit_$eq(int var1);

    public boolean scala$reflect$internal$tpe$GlbLubs$$printLubs();

    public MutableSettings.SettingValue scala$reflect$internal$tpe$GlbLubs$$strictInference();

    private boolean verifyLubs() {
        return true;
    }

    private void printLubMatrix(Map<Types.Type, List<Types.Type>> btsMap, int depth) {
        List sorted2 = (List)btsMap.toList().sortWith((Function2<Tuple2, Tuple2, Object> & java.io.Serializable & Serializable)(x, y) -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$printLubMatrix$1(x, y)));
        int maxSeqLength = BoxesRunTime.unboxToInt(((TraversableOnce)sorted2.map((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToInteger(GlbLubs.$anonfun$printLubMatrix$2(x$1)), List$.MODULE$.canBuildFrom())).max(Ordering$Int$.MODULE$));
        List transposed = (List)sorted2.map((Function1<Tuple2, List> & java.io.Serializable & Serializable)x$2 -> ((SeqLike)x$2._2()).padTo(maxSeqLength, ((Types)this).NoType(), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom()).transpose((Function1)Predef$.MODULE$.$conforms());
        Collections cfr_ignored_0 = (Collections)((Object)this);
        ListBuffer mapWithIndex_lb = new ListBuffer();
        int mapWithIndex_index = 0;
        List mapWithIndex_ys = sorted2;
        while (!mapWithIndex_ys.isEmpty()) {
            Tuple2 tuple2 = (Tuple2)mapWithIndex_ys.head();
            mapWithIndex_lb.$plus$eq(GlbLubs.$anonfun$printLubMatrix$4(this, tuple2, mapWithIndex_index));
            mapWithIndex_ys = (List)mapWithIndex_ys.tail();
            ++mapWithIndex_index;
        }
        List list = mapWithIndex_lb.toList();
        TableDef.Table formatted = TableDef$.MODULE$.apply(list).table(transposed);
        Predef$.MODULE$.println(new StringBuilder(13).append("** Depth is ").append(new Depth(depth)).append("\n").append(formatted).toString());
    }

    public static /* synthetic */ List findRecursiveBounds$(GlbLubs $this, List ts) {
        return $this.findRecursiveBounds(ts);
    }

    /*
     * WARNING - void declaration
     */
    default public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> findRecursiveBounds(List<Types.Type> ts) {
        void require_requirement;
        if (ts.isEmpty()) {
            return Nil$.MODULE$;
        }
        Symbols.Symbol sym = ts.head().typeSymbol();
        boolean bl = ((LinearSeqOptimized)ts.tail()).forall((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$findRecursiveBounds$1(sym, x$3)));
        SymbolTable require_this = (SymbolTable)this;
        if (require_requirement == false) {
            throw require_this.throwRequirementError(ts);
        }
        return sym.typeParams().flatMap((Function1<Symbols.Symbol, List> & java.io.Serializable & Serializable)p -> sym.typeParams().withFilter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)in -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$findRecursiveBounds$4(p, in))).map((Function1<Symbols.Symbol, Tuple2> & java.io.Serializable & Serializable)in -> {
            void $minus$greater$extension_$this;
            Symbols.Symbol symbol = Predef$.MODULE$.ArrowAssoc(p);
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            return new Tuple2<void, Symbols.Symbol>($minus$greater$extension_$this, (Symbols.Symbol)in);
        }, List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom());
    }

    private boolean willViolateRecursiveBounds(Types.Type tp, List<Types.Type> ts, List<Types.Type> tsElimSub) {
        Symbols.Symbol typeSym = ts.head().typeSymbol();
        if (this.isRecursive$1(typeSym, ts)) {
            boolean bl;
            Option option = ((Collections)((Object)this)).transposeSafe(tsElimSub.map((Function1<Types.Type, List> & java.io.Serializable & Serializable)x$5 -> x$5.normalize().typeArgs(), List$.MODULE$.canBuildFrom()));
            if (option instanceof Some) {
                boolean bl2;
                block8: {
                    List arggsTransposed = (List)((Some)option).value();
                    Types.Type type = tp instanceof Types.ExistentialType ? ((Types.ExistentialType)tp).underlying() : tp;
                    List mergedTypeArgs = type.typeArgs();
                    Collections cfr_ignored_0 = (Collections)((Object)this);
                    List exists3_ys1 = typeSym.typeParams();
                    List exists3_ys2 = mergedTypeArgs;
                    List exists3_ys3 = arggsTransposed;
                    while (!(exists3_ys1.isEmpty() || exists3_ys2.isEmpty() || exists3_ys3.isEmpty())) {
                        List list = (List)exists3_ys3.head();
                        Types.Type type2 = exists3_ys2.head();
                        Symbols.Symbol symbol = exists3_ys1.head();
                        if (GlbLubs.$anonfun$willViolateRecursiveBounds$4(this, ts, symbol, type2, list)) {
                            bl2 = true;
                            break block8;
                        }
                        exists3_ys1 = (List)exists3_ys1.tail();
                        exists3_ys2 = (List)exists3_ys2.tail();
                        exists3_ys3 = (List)exists3_ys3.tail();
                    }
                    bl2 = false;
                }
                bl = bl2;
            } else if (None$.MODULE$.equals(option)) {
                bl = false;
            } else {
                throw new MatchError(option);
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ List lubList$(GlbLubs $this, List ts, int depth) {
        return $this.lubList(ts, depth);
    }

    default public List<Types.Type> lubList(List<Types.Type> ts, int depth) {
        IntRef lubListDepth = IntRef.create(Depth$.MODULE$.Zero());
        List initialBTSes = ts.map((Function1<Types.Type, List> & java.io.Serializable & Serializable)x$17 -> x$17.baseTypeSeq().toList(), List$.MODULE$.canBuildFrom());
        if (this.scala$reflect$internal$tpe$GlbLubs$$printLubs()) {
            this.printLubMatrix(((TraversableOnce)ts.zip(initialBTSes, List$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms()), depth);
        }
        return this.loop$1(Nil$.MODULE$, initialBTSes, lubListDepth, depth, ts);
    }

    private Symbols.Symbol minSym(List<Types.Type> tps) {
        Symbols.Symbol symbol = tps.head().typeSymbol();
        return ((TraversableOnce)tps.tail()).$div$colon(symbol, (Function2<Symbols.Symbol, Types.Type, Symbols.Symbol> & java.io.Serializable & Serializable)(sym1, tp2) -> {
            if (tp2.typeSymbol().isLess((Symbols.Symbol)sym1)) {
                return tp2.typeSymbol();
            }
            return sym1;
        });
    }

    public static /* synthetic */ List spanningTypes$(GlbLubs $this, List ts) {
        return $this.spanningTypes(ts);
    }

    default public List<Types.Type> spanningTypes(List<Types.Type> ts) {
        List list;
        Some<List<Types.Type>> some = List$.MODULE$.unapplySeq(ts);
        if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
            list = Nil$.MODULE$;
        } else if (ts instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)ts;
            Types.Type first = (Types.Type)$colon$colon.head();
            List rest = $colon$colon.tl$access$1();
            list = this.spanningTypes((List)rest.filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)t -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$spanningTypes$1(first, t)))).$colon$colon(first);
        } else {
            throw new MatchError(ts);
        }
        return list;
    }

    private List<Types.Type> elimSuper(List<Types.Type> ts) {
        List<Types.Type> list;
        Some<List<Types.Type>> some;
        Some<List<Types.Type>> some2 = List$.MODULE$.unapplySeq(ts);
        boolean bl = !some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(0) == 0 ? true : !(some = List$.MODULE$.unapplySeq(ts)).isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0;
        if (bl) {
            list = ts;
        } else if (ts instanceof $colon$colon) {
            boolean bl2;
            List<Types.Type> rest;
            Types.Type t;
            block7: {
                $colon$colon $colon$colon = ($colon$colon)ts;
                t = (Types.Type)$colon$colon.head();
                List ts1 = $colon$colon.tl$access$1();
                rest = this.elimSuper((List)ts1.filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)t1 -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$elimSuper$1(t, t1))));
                if (rest == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = rest;
                while (!exists_these.isEmpty()) {
                    Types.Type type = (Types.Type)exists_these.head();
                    if (type.$less$colon$less(t)) {
                        bl2 = true;
                        break block7;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl2 = false;
            }
            list = bl2 ? rest : rest.$colon$colon(t);
        } else {
            throw new MatchError(ts);
        }
        return list;
    }

    private List<Types.Type> elimSub(List<Types.Type> ts, int depth) {
        List ts0;
        while (!(ts0 = this_.elimSub0$1(ts, depth)).isEmpty() && !((SeqLike)ts0.tail()).isEmpty()) {
            $colon$colon<Nothing$> $colon$colon;
            List list = ts0;
            List list2 = ts0;
            Object var5_5 = null;
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
                Types.Type type = (Types.Type)mapConserve_loop$1_head0;
                Types.Type mapConserve_loop$1_head1 = GlbLubs.$anonfun$elimSub$3(this_, type);
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
            if ($colon$colon == ts0) {
                return ts0;
            }
            ts = $colon$colon;
            GlbLubs this_ = (SymbolTable)this_;
        }
        return ts0;
    }

    public static /* synthetic */ boolean sameWeakLubAsLub$(GlbLubs $this, List tps) {
        return $this.sameWeakLubAsLub(tps);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public boolean sameWeakLubAsLub(List<Types.Type> tps) {
        void var8_11;
        void var6_7;
        if (((Object)Nil$.MODULE$).equals(tps)) {
            return true;
        }
        if (tps instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)tps;
            Types.Type tp = (Types.Type)$colon$colon.head();
            List list = $colon$colon.tl$access$1();
            if (((Object)Nil$.MODULE$).equals(list)) {
                return tp.annotations().isEmpty();
            }
        }
        if (tps == null) {
            throw null;
        }
        List<Types.Type> list = tps;
        while (!var6_7.isEmpty()) {
            if (!GlbLubs.$anonfun$sameWeakLubAsLub$1((Types.Type)var6_7.head())) {
                return false;
            }
            LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var6_7.tail();
        }
        boolean bl = true;
        if (!bl) return false;
        List<Types.Type> list2 = tps;
        while (!var8_11.isEmpty()) {
            Types.Type type = (Types.Type)var8_11.head();
            if (!GlbLubs.$anonfun$sameWeakLubAsLub$2(this, type)) {
                return true;
            }
            LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var8_11.tail();
        }
        return false;
    }

    public static /* synthetic */ Types.Type weakLub$(GlbLubs $this, List tps) {
        return $this.weakLub(tps);
    }

    default public Types.Type weakLub(List<Types.Type> tps) {
        boolean bl;
        block8: {
            boolean bl2;
            block7: {
                if (tps.isEmpty()) {
                    return ((Definitions)((Object)this)).definitions().NothingTpe();
                }
                LinearSeqOptimized forall_these = tps;
                while (!forall_these.isEmpty()) {
                    Types.Type type = (Types.Type)forall_these.head();
                    if (!GlbLubs.$anonfun$weakLub$1(this, type)) {
                        bl2 = false;
                        break block7;
                    }
                    forall_these = (LinearSeqOptimized)forall_these.tail();
                }
                bl2 = true;
            }
            if (bl2) {
                return this.numericLub(tps);
            }
            LinearSeqOptimized exists_these = tps;
            while (!exists_these.isEmpty()) {
                if (GlbLubs.$anonfun$weakLub$2((Types.Type)exists_these.head())) {
                    bl = true;
                    break block8;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        if (bl) {
            return ((AnnotationCheckers)((Object)this)).annotationsLub(this.lub(tps.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$24 -> x$24.withoutAnnotations(), List$.MODULE$.canBuildFrom())), tps);
        }
        return this.lub(tps);
    }

    public static /* synthetic */ Types.Type numericLub$(GlbLubs $this, List ts) {
        return $this.numericLub(ts);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type numericLub(List<Types.Type> ts) {
        void reduceLeft_op;
        Function2<Types.Type, Types.Type, Types.Type> & java.io.Serializable & Serializable intersect = (Function2<Types.Type, Types.Type, Types.Type> & java.io.Serializable & Serializable)(t1, t2) -> {
            if (((TypeComparers)((Object)this)).isNumericSubType((Types.Type)t1, (Types.Type)t2)) {
                return t2;
            }
            if (((TypeComparers)((Object)this)).isNumericSubType((Types.Type)t2, (Types.Type)t1)) {
                return t1;
            }
            return ((Definitions)((Object)this)).definitions().IntTpe();
        };
        if (ts == null) {
            throw null;
        }
        if (ts.isEmpty()) {
            throw new UnsupportedOperationException("empty.reduceLeft");
        }
        return (Types.Type)((LinearSeqOptimized)ts.tail()).foldLeft(ts.head(), reduceLeft_op);
    }

    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> scala$reflect$internal$tpe$GlbLubs$$_lubResults();

    public static /* synthetic */ HashMap lubResults$(GlbLubs $this) {
        return $this.lubResults();
    }

    default public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> lubResults() {
        return this.scala$reflect$internal$tpe$GlbLubs$$_lubResults();
    }

    public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> scala$reflect$internal$tpe$GlbLubs$$_glbResults();

    public static /* synthetic */ HashMap glbResults$(GlbLubs $this) {
        return $this.glbResults();
    }

    default public HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type> glbResults() {
        return this.scala$reflect$internal$tpe$GlbLubs$$_glbResults();
    }

    public static /* synthetic */ Types.Type lub$(GlbLubs $this, List ts) {
        return $this.lub(ts);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    default public Types.Type lub(List<Types.Type> ts) {
        block20: {
            block21: {
                block19: {
                    if (!Nil$.MODULE$.equals(ts)) break block19;
                    var2_2 = ((Definitions)this).definitions().NothingTpe();
                    break block20;
                }
                if (!(ts instanceof $colon$colon)) break block21;
                var3_3 = ($colon$colon)ts;
                t = (Types.Type)var3_3.head();
                var5_5 = var3_3.tl$access$1();
                if (!Nil$.MODULE$.equals(var5_5)) break block21;
                var2_2 = t;
                break block20;
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                v0 = ((SymbolTable)this).statistics();
                var14_6 = ((TypesStats)((SymbolTable)this).statistics()).lubCount();
                if (v0 == null) {
                    throw null;
                }
                if (v0.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                }
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                v1 = ((SymbolTable)this).statistics();
                var15_7 = ((TypesStats)((SymbolTable)this).statistics()).typeOpsStack();
                if (v1 == null) {
                    throw null;
                }
                v2 = v1.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(GlbLubs.$anonfun$lub$1(this)) : null;
            } else {
                v2 = null;
            }
            start = v2;
            try {
                block18: {
                    res = this.lub(ts, ((Types)this).lubDepth(ts));
                    rtps = res.typeParams().size();
                    hs = ts.head().typeParams().size();
                    if (hs == rtps) ** GOTO lbl-1000
                    forall_these /* !! */  = ts;
                    while (!forall_these /* !! */ .isEmpty()) {
                        var18_13 = (Types.Type)forall_these /* !! */ .head();
                        if (!GlbLubs.$anonfun$lub$2(hs, var18_13)) {
                            var12_14 = false;
                            break block18;
                        }
                        forall_these /* !! */  = (LinearSeqOptimized)forall_these /* !! */ .tail();
                    }
                    var12_14 = true;
                }
                if (var12_14) {
                    logResult_result = res.typeConstructor();
                    ((SymbolTable)this).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$logResult$1(scala.Function0 java.lang.Object ), ()Ljava/lang/String;)((Function0)(Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$lub$3(scala.reflect.internal.Types$Type scala.collection.immutable.List ), ()Ljava/lang/String;)((Types.Type)res, ts), (Object)logResult_result));
                    v3 = var13_15;
                } else lbl-1000:
                // 2 sources

                {
                    v3 = res;
                }
            }
            catch (Throwable var10_16) {
                this.lubResults().clear();
                this.glbResults().clear();
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    v4 = ((SymbolTable)this).statistics();
                    var16_17 = ((TypesStats)((SymbolTable)this).statistics()).typeOpsStack();
                    if (v4 == null) {
                        throw null;
                    }
                    if (v4.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                        popTimer_timers.pop(start);
                    }
                }
                throw var10_16;
            }
            this.lubResults().clear();
            this.glbResults().clear();
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                v5 = ((SymbolTable)this).statistics();
                var17_18 = ((TypesStats)((SymbolTable)this).statistics()).typeOpsStack();
                if (v5 == null) {
                    throw null;
                }
                if (v5.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                    popTimer_timers.pop(start);
                }
            }
            var2_2 = v3;
        }
        return var2_2;
    }

    public static /* synthetic */ Types.Type lub$(GlbLubs $this, List ts, int depth) {
        return $this.lub(ts, depth);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type lub(List<Types.Type> ts, int depth) {
        void var3_4;
        if (this.scala$reflect$internal$tpe$GlbLubs$$printLubs()) {
            Predef$.MODULE$.println(new StringBuilder(17).append(((Types)this).indent()).append("lub of ").append(ts).append(" at depth ").append(new Depth(depth)).toString());
            ((Types)this).indent_$eq(new StringBuilder(2).append(((Types)this).indent()).append("  ").toString());
            ((SymbolTable)this).assert(((Types)this).indent().length() <= 100);
        }
        if (StatisticsStatics.areSomeColdStatsEnabled()) {
            void incCounter_c;
            Statistics statistics = ((SymbolTable)this).statistics();
            Statistics.Counter counter = ((TypesStats)((Object)((SymbolTable)this).statistics())).nestedLubCount();
            if (statistics == null) {
                throw null;
            }
            if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                incCounter_c.value_$eq(incCounter_c.value() + 1);
            }
        }
        Types.Type res = this.lub0$1(ts, depth);
        if (this.scala$reflect$internal$tpe$GlbLubs$$printLubs()) {
            String string = ((Types)this).indent();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            ((Types)this).indent_$eq(new StringOps(string).stripSuffix("  "));
            Predef$.MODULE$.println(new StringBuilder(11).append(((Types)this).indent()).append("lub of ").append(ts).append(" is ").append(res).toString());
        }
        return var3_4;
    }

    public Throwable GlbFailure();

    public int scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth();

    public void scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth_$eq(int var1);

    public int scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit();

    public static /* synthetic */ Types.Type glb$(GlbLubs $this, List ts) {
        return $this.glb(ts);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type glb(List<Types.Type> ts) {
        Types.Type type;
        List<Types.Type> list = this.elimSuper(ts);
        Some<List<Types.Type>> some = List$.MODULE$.unapplySeq(list);
        if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
            type = ((Definitions)((Object)this)).definitions().AnyTpe();
        } else {
            Some<List<Types.Type>> some2 = List$.MODULE$.unapplySeq(list);
            if (!some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(1) == 0) {
                type = (Types.Type)((LinearSeqOptimized)some2.get()).apply(0);
            } else {
                Types.Type type2;
                Tuple2<Object, Object> tuple2;
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    void incCounter_c;
                    Statistics statistics = ((SymbolTable)this).statistics();
                    Statistics.Counter counter = ((TypesStats)((Object)((SymbolTable)this).statistics())).lubCount();
                    if (statistics == null) {
                        throw null;
                    }
                    if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                        incCounter_c.value_$eq(incCounter_c.value() + 1);
                    }
                }
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    void pushTimer_timers;
                    Statistics statistics = ((SymbolTable)this).statistics();
                    Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                    if (statistics == null) {
                        throw null;
                    }
                    tuple2 = statistics.areColdStatsLocallyEnabled() && pushTimer_timers != null ? pushTimer_timers.push(GlbLubs.$anonfun$glb$1(this)) : null;
                } else {
                    tuple2 = null;
                }
                Tuple2<Object, Object> start = tuple2;
                try {
                    type2 = this.glbNorm(list, ((Types)this).lubDepth(list));
                }
                catch (Throwable throwable) {
                    this.lubResults().clear();
                    this.glbResults().clear();
                    if (StatisticsStatics.areSomeColdStatsEnabled()) {
                        void popTimer_timers;
                        Statistics statistics = ((SymbolTable)this).statistics();
                        Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                        if (statistics == null) {
                            throw null;
                        }
                        if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                            popTimer_timers.pop(start);
                        }
                    }
                    throw throwable;
                }
                this.lubResults().clear();
                this.glbResults().clear();
                if (StatisticsStatics.areSomeColdStatsEnabled()) {
                    void popTimer_timers;
                    Statistics statistics = ((SymbolTable)this).statistics();
                    Statistics.TimerStack timerStack = ((TypesStats)((Object)((SymbolTable)this).statistics())).typeOpsStack();
                    if (statistics == null) {
                        throw null;
                    }
                    if (statistics.areColdStatsLocallyEnabled() && popTimer_timers != null) {
                        popTimer_timers.pop(start);
                    }
                }
                type = type2;
            }
        }
        return type;
    }

    public static /* synthetic */ Types.Type glb$(GlbLubs $this, List ts, int depth) {
        return $this.glb(ts, depth);
    }

    default public Types.Type glb(List<Types.Type> ts, int depth) {
        Some<List<Types.Type>> some;
        List<Types.Type> list = this.elimSuper(ts);
        Some<List<Types.Type>> some2 = List$.MODULE$.unapplySeq(list);
        Types.Type type = !some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(0) == 0 ? ((Definitions)((Object)this)).definitions().AnyTpe() : (!(some = List$.MODULE$.unapplySeq(list)).isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0 ? (Types.Type)((LinearSeqOptimized)some.get()).apply(0) : this.glbNorm(list, depth));
        return type;
    }

    public static /* synthetic */ Types.Type glbNorm$(GlbLubs $this, List ts, int depth) {
        return $this.glbNorm(ts, depth);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type glbNorm(List<Types.Type> ts, int depth) {
        if (StatisticsStatics.areSomeColdStatsEnabled()) {
            void incCounter_c;
            Statistics statistics = ((SymbolTable)this).statistics();
            Statistics.Counter counter = ((TypesStats)((Object)((SymbolTable)this).statistics())).nestedLubCount();
            if (statistics == null) {
                throw null;
            }
            if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                incCounter_c.value_$eq(incCounter_c.value() + 1);
            }
        }
        return this.glb0$1(ts, depth, ts);
    }

    private List<List<Types.Type>> matchingBounds(List<Types.Type> tps, List<Symbols.Symbol> tparams) {
        return tps.map((Function1<Types.Type, List> & java.io.Serializable & Serializable)tp -> this.getBounds$1((Types.Type)tp, tparams, tps), List$.MODULE$.canBuildFrom());
    }

    private List<Types.Type> matchingInstTypes(List<Types.Type> tps, List<Symbols.Symbol> tparams) {
        return tps.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)tp -> this.transformResultType$1((Types.Type)tp, tparams, tps), List$.MODULE$.canBuildFrom());
    }

    private List<Types.Type> matchingRestypes(List<Types.Type> tps, List<Types.Type> pts) {
        return tps.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 instanceof Types.MethodType) {
                Types.MethodType methodType = (Types.MethodType)x0$1;
                Types.Type res = methodType.resultType();
                if (((Types)this).isSameTypes(methodType.paramTypes(), pts)) {
                    return res;
                }
            }
            if (!(x0$1 instanceof Types.NullaryMethodType)) throw new Types.NoCommonType((SymbolTable)this, tps);
            Types.Type res = ((Types.NullaryMethodType)x0$1).resultType();
            if (!pts.isEmpty()) throw new Types.NoCommonType((SymbolTable)this, tps);
            return res;
        }, List$.MODULE$.canBuildFrom());
    }

    private String str$1(Types.Type tp) {
        Types.Type type = tp;
        Types$NoType$ types$NoType$ = ((Types)this).NoType();
        if (!(type != null ? !type.equals(types$NoType$) : types$NoType$ != null)) {
            return "";
        }
        String s = String.valueOf(tp).replaceAll("[\\w.]+\\.(\\w+)", "$1");
        if (s.length() < 60) {
            return s;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringBuilder(3).append((String)new StringOps(s).take(57)).append("...").toString();
    }

    public static /* synthetic */ boolean $anonfun$printLubMatrix$1(Tuple2 x, Tuple2 y) {
        return ((Types.Type)x._1()).typeSymbol().isLess(((Types.Type)y._1()).typeSymbol());
    }

    public static /* synthetic */ int $anonfun$printLubMatrix$2(Tuple2 x$1) {
        return ((SeqLike)x$1._2()).size();
    }

    public static /* synthetic */ TableDef.Column $anonfun$printLubMatrix$4(GlbLubs $this, Tuple2 x0$1, int x1$1) {
        Integer n = BoxesRunTime.boxToInteger(x1$1);
        Tuple2<Tuple2, Integer> tuple2 = new Tuple2<Tuple2, Integer>(x0$1, n);
        if (x0$1 == null) {
            throw new MatchError(tuple2);
        }
        Types.Type k = (Types.Type)x0$1._1();
        TableDef.Column column = new TableDef.Column($this.str$1(k), (Function1<List, String> & java.io.Serializable & Serializable)xs -> $this.str$1((Types.Type)xs.apply(x1$1)), true);
        return column;
    }

    public static /* synthetic */ boolean $anonfun$findRecursiveBounds$1(Symbols.Symbol sym$1, Types.Type x$3) {
        Symbols.Symbol symbol = x$3.typeSymbol();
        return !(symbol != null ? !symbol.equals(sym$1) : sym$1 != null);
    }

    public static /* synthetic */ boolean $anonfun$findRecursiveBounds$4(Symbols.Symbol p$1, Symbols.Symbol in) {
        return in.info().bounds().contains(p$1);
    }

    private List fbounds$1(List ts$2) {
        return this.findRecursiveBounds(ts$2).map((Function1<Tuple2, Symbols.Symbol> & java.io.Serializable & Serializable)x$4 -> (Symbols.Symbol)x$4._2(), List$.MODULE$.canBuildFrom());
    }

    private boolean isRecursive$1(Symbols.Symbol typeSym$1, List ts$2) {
        boolean bl;
        block3: {
            List<Symbols.Symbol> list = typeSym$1.typeParams();
            List list2 = this.fbounds$1(ts$2);
            if (list == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = list;
            while (!exists_these.isEmpty()) {
                Object a = exists_these.head();
                if (list2.contains(a)) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ boolean $anonfun$willViolateRecursiveBounds$4(GlbLubs $this, List ts$2, Symbols.Symbol param2, Types.Type arg, List lubbedArgs) {
        boolean wasLubbed;
        boolean bl;
        boolean isInFBound;
        boolean isExistential;
        block3: {
            isExistential = arg.typeSymbol().isExistentiallyBound();
            isInFBound = $this.fbounds$1(ts$2).contains(param2);
            if (lubbedArgs == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = lubbedArgs;
            while (!exists_these.isEmpty()) {
                Types.Type type = (Types.Type)exists_these.head();
                if (type.$eq$colon$eq(arg)) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        boolean bl2 = wasLubbed = !bl;
        return !isExistential && isInFBound && wasLubbed;
    }

    private static boolean isHotForT$1(Symbols.Symbol tyPar, Types.Type x) {
        return tyPar == x.typeSymbol();
    }

    public static /* synthetic */ boolean $anonfun$lubList$1(List xs$1, Types.Type x$7) {
        boolean bl;
        block3: {
            List<Symbols.Symbol> list = x$7.typeParams();
            if (list == null) {
                throw null;
            }
            GenSeq corresponds_that = xs$1;
            LinearSeqLike corresponds_this = list;
            while (true) {
                if (corresponds_this.isEmpty()) {
                    bl = corresponds_that.isEmpty();
                    break block3;
                }
                if (!corresponds_that.nonEmpty()) break;
                Types.Type type = (Types.Type)corresponds_that.head();
                if (!GlbLubs.isHotForT$1((Symbols.Symbol)corresponds_this.head(), type)) break;
                corresponds_that = (GenSeq)corresponds_that.tail();
                corresponds_this = (LinearSeqLike)corresponds_this.tail();
            }
            bl = false;
        }
        return bl;
    }

    private static boolean isHotForTs$1(List xs, List ts$3) {
        boolean bl;
        block3: {
            if (ts$3 == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = ts$3;
            while (!exists_these.isEmpty()) {
                Types.Type type = (Types.Type)exists_these.head();
                if (GlbLubs.$anonfun$lubList$1(xs, type)) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private Types.Type elimHigherOrderTypeParam$1(Types.Type tp, List ts$3) {
        Types.Type type;
        List<Types.Type> args2;
        if (tp instanceof Types.TypeRef && (args2 = ((Types.TypeRef)tp).args()).nonEmpty() && GlbLubs.isHotForTs$1(args2, ts$3)) {
            void var5_4;
            Types.Type logResult_result = tp.typeConstructor();
            ((SymbolTable)this).log((Function0<Object>)((Function0<String> & java.io.Serializable & Serializable)() -> SymbolTable.$anonfun$logResult$1((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(35).append("Retracting dummies from ").append(tp).append(" in lublist").toString(), logResult_result)));
            type = var5_4;
        } else {
            type = tp;
        }
        return type;
    }

    public static /* synthetic */ boolean $anonfun$lubList$6(Types.Type t$1, Types.Type x$13) {
        Symbols.Symbol symbol = x$13.typeSymbol();
        Symbols.Symbol symbol2 = t$1.typeSymbol();
        return !(symbol != null ? !symbol.equals(symbol2) : symbol2 != null);
    }

    /*
     * WARNING - void declaration
     */
    private List loop$1(List pretypes, List tsBts, IntRef lubListDepth$1, int depth$1, List ts$3) {
        while (true) {
            GlbLubs this_;
            boolean bl;
            List<Types.Type> ts0;
            block19: {
                block21: {
                    block20: {
                        boolean bl2;
                        block18: {
                            lubListDepth$1.elem = Depth$.MODULE$.incr$extension1(lubListDepth$1.elem);
                            if (tsBts.isEmpty()) break block20;
                            LinearSeqOptimized exists_these = tsBts;
                            while (!exists_these.isEmpty()) {
                                if (((List)exists_these.head()).isEmpty()) {
                                    bl2 = true;
                                    break block18;
                                }
                                exists_these = (LinearSeqOptimized)exists_these.tail();
                            }
                            bl2 = false;
                        }
                        if (!bl2) break block21;
                    }
                    return pretypes.reverse();
                }
                if (((SeqLike)tsBts.tail()).isEmpty()) {
                    return ((List)tsBts.head()).reverse_$colon$colon$colon(pretypes);
                }
                ts0 = tsBts.map((Function1<List, Types.Type> & java.io.Serializable & Serializable)x$12 -> (Types.Type)x$12.head(), List$.MODULE$.canBuildFrom());
                if (ts0 instanceof $colon$colon) {
                    $colon$colon $colon$colon = ($colon$colon)ts0;
                    Types.Type t = (Types.Type)$colon$colon.head();
                    List ts2 = $colon$colon.tl$access$1();
                    if (ts2 == null) {
                        throw null;
                    }
                    LinearSeqOptimized forall_these = ts2;
                    while (!forall_these.isEmpty()) {
                        Types.Type type = (Types.Type)forall_these.head();
                        if (!GlbLubs.$anonfun$lubList$6(t, type)) {
                            bl = false;
                            break block19;
                        }
                        forall_these = (LinearSeqOptimized)forall_these.tail();
                    }
                    bl = true;
                } else {
                    throw new MatchError(ts0);
                }
            }
            if (bl) {
                void reflectSettingToBoolean_s;
                List tails = tsBts.map((Function1<List, List> & java.io.Serializable & Serializable)x$14 -> (List)x$14.tail(), List$.MODULE$.canBuildFrom());
                List<Types.Type> ts1 = this_.elimSub(ts0, depth$1).map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)tp -> this_.elimHigherOrderTypeParam$1((Types.Type)tp, ts$3), List$.MODULE$.canBuildFrom());
                Types.Type type = ((Types)this_).mergePrefixAndArgs(ts1, Variance$.MODULE$.Covariant(), depth$1);
                if (((Types)this_).NoType().equals(type)) {
                    tsBts = tails;
                    this_ = (SymbolTable)this_;
                    continue;
                }
                MutableSettings.SettingValue settingValue = this_.scala$reflect$internal$tpe$GlbLubs$$strictInference();
                if (MutableSettings$.MODULE$ == null) {
                    throw null;
                }
                if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) && this_.willViolateRecursiveBounds(type, ts0, ts1)) {
                    ((SymbolTable)this_).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(89).append("Breaking recursion in lublist, advancing frontier and discarding merged prefix/args from ").append(type).toString());
                    tsBts = tails;
                    this_ = (SymbolTable)this_;
                    continue;
                }
                tsBts = tails;
                pretypes = pretypes.$colon$colon(type);
                this_ = (SymbolTable)this_;
                continue;
            }
            Symbols.Symbol sym = this_.minSym(ts0);
            List<?> newtps = tsBts.map((Function1<List, List> & java.io.Serializable & Serializable)ts -> {
                Symbols.Symbol symbol = ((Types.Type)ts.head()).typeSymbol();
                if (!(symbol != null ? !symbol.equals(sym) : sym != null)) {
                    return (List)ts.tail();
                }
                return ts;
            }, List$.MODULE$.canBuildFrom());
            if (this_.scala$reflect$internal$tpe$GlbLubs$$printLubs()) {
                String str = ((TraversableOnce)newtps.zipWithIndex(List$.MODULE$.canBuildFrom()).map((Function1<Tuple2, String> & java.io.Serializable & Serializable)x0$1 -> {
                    if (x0$1 == null) {
                        throw new MatchError((Object)null);
                    }
                    List tps = (List)x0$1._1();
                    int idx = x0$1._2$mcI$sp();
                    String string = ((TraversableOnce)tps.map((Function1<Types.Type, String> & java.io.Serializable & Serializable)x$16 -> new StringBuilder(9).append("        ").append(x$16).append("\n").toString(), List$.MODULE$.canBuildFrom())).mkString(new StringBuilder(6).append("   (").append(idx).append(")\n").toString(), "", "\n");
                    return string;
                }, List$.MODULE$.canBuildFrom())).mkString("");
                Predef$.MODULE$.println(new StringBuilder(11).append("Frontier(\n").append(str).append(")").toString());
                this_.printLubMatrix(((TraversableOnce)ts$3.zip(tsBts, List$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms()), lubListDepth$1.elem);
            }
            tsBts = newtps;
            this_ = (SymbolTable)this_;
        }
    }

    public static /* synthetic */ boolean $anonfun$spanningTypes$1(Types.Type first$1, Types.Type t) {
        return !first$1.typeSymbol().isSubClass(t.typeSymbol());
    }

    public static /* synthetic */ boolean $anonfun$elimSuper$1(Types.Type t$2, Types.Type t1) {
        return !t$2.$less$colon$less(t1);
    }

    public static /* synthetic */ boolean $anonfun$elimSub$1(GlbLubs $this, Types.Type t$3, int depth$2, Types.Type t1) {
        return !((TypeComparers)((Object)$this)).isSubType(t1, t$3, Depth$.MODULE$.decr$extension1(depth$2));
    }

    public static /* synthetic */ boolean $anonfun$elimSub$2(GlbLubs $this, Types.Type t$3, int depth$2, Types.Type t1) {
        return ((TypeComparers)((Object)$this)).isSubType(t$3, t1, Depth$.MODULE$.decr$extension1(depth$2));
    }

    private List elimSub0$1(List ts, int depth$2) {
        List list;
        Some<List> some = List$.MODULE$.unapplySeq(ts);
        if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
            list = ts;
        } else {
            Some<List> some2 = List$.MODULE$.unapplySeq(ts);
            if (!some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(1) == 0) {
                list = ts;
            } else if (ts instanceof $colon$colon) {
                boolean bl;
                List<Types.Type> rest;
                Types.Type t;
                block9: {
                    $colon$colon $colon$colon = ($colon$colon)ts;
                    t = (Types.Type)$colon$colon.head();
                    List ts1 = $colon$colon.tl$access$1();
                    rest = this.elimSub0$1((List)ts1.filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)t1 -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$elimSub$1(this, t, depth$2, t1))), depth$2);
                    if (rest == null) {
                        throw null;
                    }
                    LinearSeqOptimized exists_these = rest;
                    while (!exists_these.isEmpty()) {
                        Types.Type type = (Types.Type)exists_these.head();
                        if (GlbLubs.$anonfun$elimSub$2(this, t, depth$2, type)) {
                            bl = true;
                            break block9;
                        }
                        exists_these = (LinearSeqOptimized)exists_these.tail();
                    }
                    bl = false;
                }
                list = bl ? rest : rest.$colon$colon(t);
            } else {
                throw new MatchError(ts);
            }
        }
        return list;
    }

    public static /* synthetic */ Types.Type $anonfun$elimSub$3(GlbLubs $this, Types.Type t) {
        return ((Types)$this).elimAnonymousClass(t.dealiasWiden());
    }

    public static /* synthetic */ boolean $anonfun$sameWeakLubAsLub$1(Types.Type x$22) {
        return x$22.annotations().isEmpty();
    }

    public static /* synthetic */ boolean $anonfun$sameWeakLubAsLub$2(GlbLubs $this, Types.Type tp) {
        return ((Definitions)((Object)$this)).definitions().isNumericValueType(tp);
    }

    public static /* synthetic */ boolean $anonfun$weakLub$1(GlbLubs $this, Types.Type tp) {
        return ((Definitions)((Object)$this)).definitions().isNumericValueType(tp);
    }

    public static /* synthetic */ boolean $anonfun$weakLub$2(Types.Type x$23) {
        return !x$23.annotations().isEmpty();
    }

    public static /* synthetic */ Statistics.StackableTimer $anonfun$lub$1(GlbLubs $this) {
        return ((TypesStats)((Object)((SymbolTable)$this).statistics())).lubNanos();
    }

    public static /* synthetic */ boolean $anonfun$lub$2(int hs$1, Types.Type x$25) {
        return x$25.typeParams().size() == hs$1;
    }

    public static /* synthetic */ String $anonfun$lub$3(Types.Type res$1, List ts$4) {
        return new StringBuilder(61).append("Stripping type args from lub because ").append(res$1).append(" is not consistent with ").append(ts$4).toString();
    }

    public static /* synthetic */ Symbols.Symbol $anonfun$lub$4(GlbLubs $this, int depth$3, Symbols.Symbol tparam, List bounds) {
        return tparam.cloneSymbol().setInfo($this.glb(bounds, depth$3));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Types.Type lub0$1(List ts0, int depth$3) {
        Types.Type type;
        Types.Type mt;
        boolean bl = false;
        $colon$colon $colon$colon = null;
        List<Types.Type> list = this.elimSub(ts0, depth$3);
        Some<List<Types.Type>> some = List$.MODULE$.unapplySeq(list);
        if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
            return ((Definitions)((Object)this)).definitions().NothingTpe();
        }
        Some<List<Types.Type>> some2 = List$.MODULE$.unapplySeq(list);
        if (!some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(1) == 0) {
            return (Types.Type)((LinearSeqOptimized)some2.get()).apply(0);
        }
        if (list instanceof $colon$colon) {
            bl = true;
            $colon$colon = ($colon$colon)list;
            Types.Type type2 = (Types.Type)$colon$colon.head();
            if (type2 instanceof Types.PolyType) {
                List tparams = ((Types.PolyType)type2).typeParams();
                Collections cfr_ignored_0 = (Collections)((Object)this);
                List map2_xs2 = (List)this.matchingBounds($colon$colon, tparams).transpose((Function1)Predef$.MODULE$.$conforms());
                ListBuffer map2_lb = new ListBuffer();
                List map2_ys1 = tparams;
                List map2_ys2 = map2_xs2;
                while (!map2_ys1.isEmpty() && !map2_ys2.isEmpty()) {
                    List list2 = (List)map2_ys2.head();
                    Symbols.Symbol symbol = map2_ys1.head();
                    map2_lb.$plus$eq(GlbLubs.$anonfun$lub$4(this, depth$3, symbol, list2));
                    map2_ys1 = (List)map2_ys1.tail();
                    map2_ys2 = (List)map2_ys2.tail();
                }
                List<Symbols.Symbol> list3 = map2_lb.toList();
                return new Types.PolyType((SymbolTable)this, list3, this.lub0$1(this.matchingInstTypes($colon$colon, list3), depth$3));
            }
        }
        if (bl && (mt = (Types.Type)$colon$colon.head()) instanceof Types.MethodType) {
            Types.MethodType methodType = (Types.MethodType)mt;
            List<Symbols.Symbol> params = methodType.params();
            return new Types.MethodType((SymbolTable)this, params, this.lub0$1(this.matchingRestypes($colon$colon, methodType.paramTypes()), depth$3));
        }
        if (bl && (Types.Type)$colon$colon.head() instanceof Types.NullaryMethodType) {
            return new Types.NullaryMethodType((SymbolTable)this, this.lub0$1(this.matchingRestypes($colon$colon, Nil$.MODULE$), depth$3));
        }
        if (bl && (Types.Type)$colon$colon.head() instanceof Types.TypeBounds) {
            return ((Types)this).TypeBounds().apply(this.glb($colon$colon.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$26 -> x$26.lowerBound(), List$.MODULE$.canBuildFrom()), depth$3), this.lub($colon$colon.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$27 -> x$27.upperBound(), List$.MODULE$.canBuildFrom()), depth$3));
        }
        if (bl && (Types.Type)$colon$colon.head() instanceof Types.AnnotatedType) {
            return ((AnnotationCheckers)((Object)this)).annotationsLub(this.lub0$1($colon$colon.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$28 -> x$28.withoutAnnotations(), List$.MODULE$.canBuildFrom()), depth$3), $colon$colon);
        }
        Option<Types.Type> option = this.lubResults().get(new Tuple2<Depth, List<Types.Type>>(new Depth(depth$3), list));
        if (option instanceof Some) {
            type = (Types.Type)((Some)option).value();
            return type;
        } else {
            if (!None$.MODULE$.equals(option)) throw new MatchError(option);
            this.lubResults().update(new Tuple2<Depth, List<Types.Type>>(new Depth(depth$3), list), ((Definitions)((Object)this)).definitions().AnyTpe());
            Types.Type res = Depth$.MODULE$.isNegative$extension(depth$3) ? ((Definitions)((Object)this)).definitions().AnyTpe() : this.lub1$1(list, depth$3);
            this.lubResults().update(new Tuple2<Depth, List<Types.Type>>(new Depth(depth$3), list), res);
            type = res;
        }
        return type;
    }

    public static /* synthetic */ boolean $anonfun$lub$9(GlbLubs $this, Symbols.Symbol sym$3, Types.Type lubThisType$1, int depth$3, Types.Type t) {
        return !$this.refines$1(t, sym$3, lubThisType$1, depth$3);
    }

    private boolean excludeFromLub$1(Symbols.Symbol sym, List narrowts$1, Types.Type lubThisType$1, int depth$3) {
        block9: {
            block8: {
                boolean bl;
                block7: {
                    if (sym.isClass() || sym.isConstructor() || !sym.isPublic() || ((Definitions)((Object)this)).definitions().isGetClass(sym) || sym.isFinal()) break block8;
                    if (narrowts$1 == null) {
                        throw null;
                    }
                    LinearSeqOptimized exists_these = narrowts$1;
                    while (!exists_these.isEmpty()) {
                        Types.Type type = (Types.Type)exists_these.head();
                        if (GlbLubs.$anonfun$lub$9(this, sym, lubThisType$1, depth$3, type)) {
                            bl = true;
                            break block7;
                        }
                        exists_these = (LinearSeqOptimized)exists_these.tail();
                    }
                    bl = false;
                }
                if (!bl) break block9;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean $anonfun$lub$11(Types.Type prototp$1, Types.Type lubThisType$1, Types.Type t$4, Symbols.Symbol sym) {
        return sym.tpe().matches(prototp$1.substThis(lubThisType$1.typeSymbol(), t$4));
    }

    public static /* synthetic */ Types.Type $anonfun$lub$12(Types.Type lubThisType$1, Types.Type t, Symbols.Symbol sym) {
        return t.memberInfo(sym).substThis(t.typeSymbol(), lubThisType$1);
    }

    public static /* synthetic */ boolean $anonfun$lub$13(List symtypes$1, Types.Type x$31) {
        return ((Types.Type)symtypes$1.head()).$eq$colon$eq(x$31);
    }

    private Symbols.Symbol lubsym$1(Symbols.Symbol proto, Types.Type lubThisType$1, List narrowts$1, Types.Type lubRefined$1, int depth$3) {
        Types.Type prototp = lubThisType$1.memberInfo(proto);
        List syms = narrowts$1.map((Function1<Types.Type, Symbols.Symbol> & java.io.Serializable & Serializable)t -> t.nonPrivateMember(proto.name()).filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lub$11(prototp, lubThisType$1, t, sym))), List$.MODULE$.canBuildFrom());
        if (syms.contains(((Symbols)((Object)this)).NoSymbol())) {
            return ((Symbols)((Object)this)).NoSymbol();
        }
        Collections cfr_ignored_0 = (Collections)((Object)this);
        ListBuffer map2_lb = new ListBuffer();
        List map2_ys1 = narrowts$1;
        List map2_ys2 = syms;
        while (!map2_ys1.isEmpty() && !map2_ys2.isEmpty()) {
            Symbols.Symbol symbol = (Symbols.Symbol)map2_ys2.head();
            Types.Type type = (Types.Type)map2_ys1.head();
            map2_lb.$plus$eq(GlbLubs.$anonfun$lub$12(lubThisType$1, type, symbol));
            map2_ys1 = (List)map2_ys1.tail();
            map2_ys2 = (List)map2_ys2.tail();
        }
        List<Types.Type> list = map2_lb.toList();
        if (proto.isTerm()) {
            return proto.cloneSymbol(lubRefined$1.typeSymbol()).setInfoOwnerAdjusted(this.lub(list, Depth$.MODULE$.decr$extension1(depth$3)));
        }
        if (((LinearSeqOptimized)list.tail()).forall((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$31 -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lub$13(list, x$31)))) {
            return proto.cloneSymbol(lubRefined$1.typeSymbol()).setInfoOwnerAdjusted(list.head());
        }
        Types.Type lo = this.glb(list.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$32 -> x$32.lowerBound(), List$.MODULE$.canBuildFrom()), Depth$.MODULE$.decr$extension1(depth$3));
        Types.Type hi = this.lub(list.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$33 -> x$33.upperBound(), List$.MODULE$.canBuildFrom()), Depth$.MODULE$.decr$extension1(depth$3));
        Symbols.Symbol qual$1 = lubRefined$1.typeSymbol();
        Names.TypeName x$1 = proto.name().toTypeName();
        Position x$2 = proto.pos();
        long x$3 = qual$1.newAbstractType$default$3();
        return qual$1.newAbstractType(x$1, x$2, x$3).setInfoOwnerAdjusted(((Types)this).TypeBounds().apply(lo, hi));
    }

    public static /* synthetic */ boolean $anonfun$lub$16(GlbLubs $this, Symbols.Symbol sym$4, Types.Type lubThisType$1, Types.Type tp$2, int depth$3, Symbols.Symbol alt) {
        Symbols.Symbol symbol = alt;
        return (symbol == null ? sym$4 != null : !symbol.equals(sym$4)) && !((Types)$this).specializesSym(lubThisType$1, sym$4, tp$2, alt, depth$3);
    }

    private boolean refines$1(Types.Type tp, Symbols.Symbol sym, Types.Type lubThisType$1, int depth$3) {
        List<Symbols.Symbol> syms = tp.nonPrivateMember(sym.name()).alternatives();
        if (!syms.isEmpty()) {
            boolean bl;
            block4: {
                LinearSeqOptimized forall_these = syms;
                while (!forall_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)forall_these.head();
                    if (!GlbLubs.$anonfun$lub$16(this, sym, lubThisType$1, tp, depth$3, symbol)) {
                        bl = false;
                        break block4;
                    }
                    forall_these = (LinearSeqOptimized)forall_these.tail();
                }
                bl = true;
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean $anonfun$lub$17(GlbLubs $this, List narrowts$1, Types.Type lubThisType$1, int depth$3, Symbols.Symbol sym) {
        return !$this.excludeFromLub$1(sym, narrowts$1, lubThisType$1, depth$3);
    }

    public static /* synthetic */ void $anonfun$lub$19(GlbLubs $this, Types.Type lubThisType$1, Types.Type lubRefined$1, int depth$3, Symbols.Symbol x$34) {
        ((Types)$this).addMember(lubThisType$1, lubRefined$1, x$34, depth$3);
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ boolean $anonfun$lub$20(GlbLubs $this, Types.Type lubRefined$1, int depth$3, Types.Type lubBase$1, Types.Type t) {
        if (!((TypeComparers)((Object)$this)).isSubType(t, lubRefined$1, depth$3)) {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = ((SymbolTable)$this).settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) || $this.scala$reflect$internal$tpe$GlbLubs$$printLubs()) {
                Console$.MODULE$.println(new StringBuilder(61).append("Malformed lub: ").append(lubRefined$1).append("\n").append("Argument ").append(t).append(" does not conform.  Falling back to ").append(lubBase$1).toString());
            }
        } else {
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private Types.Type lub1$1(List ts0, int depth$3) {
        Types.Type type;
        void var5_5;
        void var4_4;
        Tuple2<List<Types.Type>, List<Symbols.Symbol>> tuple2 = ((Types)this).stripExistentialsAndTypeVars(ts0, ((Types)this).stripExistentialsAndTypeVars$default$2());
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        List<Types.Type> ts = tuple2._1();
        List<Symbols.Symbol> tparams = tuple2._2();
        void ts2 = var4_4;
        void tparams2 = var5_5;
        List<Types.Type> lubBaseTypes = this.lubList((List<Types.Type>)ts2, depth$3);
        List<Types.Type> lubParents = this.spanningTypes(lubBaseTypes);
        Symbols.Symbol lubOwner = ((CommonOwners)((Object)this)).commonOwner((List<Types.Type>)ts2);
        Types.Type lubBase = ((Types)this).intersectionType(lubParents, lubOwner);
        if (((SymbolTable)this).phase().erasedTypes() || Depth$.MODULE$.isZero$extension(depth$3)) {
            type = lubBase;
        } else {
            Types.Type lubRefined = ((Types)this).refinedType(lubParents, lubOwner);
            Types.Type lubThisType = lubRefined.typeSymbol().thisType();
            List narrowts = ts2.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$30 -> x$30.narrow(), List$.MODULE$.canBuildFrom());
            lubBase.nonPrivateMembers().withFilter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lub$17(this, narrowts, lubThisType, depth$3, sym))).foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> {
                try {
                    void var6_6;
                    Symbols.Symbol symbol = this.lubsym$1((Symbols.Symbol)sym, lubThisType, narrowts, lubRefined, depth$3);
                    if (symbol == null) {
                        throw null;
                    }
                    Symbols.Symbol andAlso_this = symbol;
                    if (andAlso_this != andAlso_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                        Symbols.Symbol symbol2 = andAlso_this;
                        GlbLubs.$anonfun$lub$19(this, lubThisType, lubRefined, depth$3, symbol2);
                    }
                    return var6_6;
                }
                catch (Types.NoCommonType noCommonType) {
                    return BoxedUnit.UNIT;
                }
            });
            if (lubRefined.decls().isEmpty()) {
                type = lubBase;
            } else {
                boolean bl;
                block7: {
                    LinearSeqOptimized forall_these = ts2;
                    while (!forall_these.isEmpty()) {
                        Types.Type type2 = (Types.Type)forall_these.head();
                        if (!GlbLubs.$anonfun$lub$20(this, lubRefined, depth$3, lubBase, type2)) {
                            bl = false;
                            break block7;
                        }
                        forall_these = (LinearSeqOptimized)forall_these.tail();
                    }
                    bl = true;
                }
                type = bl ? lubRefined : lubBase;
            }
        }
        Types.Type lubType = type;
        return ((Types)this).existentialAbstraction((List<Symbols.Symbol>)tparams2, ((TypeMaps)((Object)this)).dropIllegalStarTypes().apply(lubType));
    }

    public static /* synthetic */ Statistics.StackableTimer $anonfun$glb$1(GlbLubs $this) {
        return ((TypesStats)((Object)((SymbolTable)$this).statistics())).lubNanos();
    }

    public static /* synthetic */ Symbols.Symbol $anonfun$glbNorm$1(GlbLubs $this, int depth$4, Symbols.Symbol tparam, List bounds) {
        return tparam.cloneSymbol().setInfo($this.lub(bounds, depth$4));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Types.Type glb0$1(List ts0, int depth$4, List ts$6) {
        Types.Type type;
        Types.Type mt;
        boolean bl = false;
        $colon$colon $colon$colon = null;
        Some<List> some = List$.MODULE$.unapplySeq(ts0);
        if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
            return ((Definitions)((Object)this)).definitions().AnyTpe();
        }
        Some<List> some2 = List$.MODULE$.unapplySeq(ts0);
        if (!some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(1) == 0) {
            return (Types.Type)((LinearSeqOptimized)some2.get()).apply(0);
        }
        if (ts0 instanceof $colon$colon) {
            bl = true;
            $colon$colon = ($colon$colon)ts0;
            Types.Type type2 = (Types.Type)$colon$colon.head();
            if (type2 instanceof Types.PolyType) {
                List tparams = ((Types.PolyType)type2).typeParams();
                Collections cfr_ignored_0 = (Collections)((Object)this);
                List map2_xs2 = (List)this.matchingBounds($colon$colon, tparams).transpose((Function1)Predef$.MODULE$.$conforms());
                ListBuffer map2_lb = new ListBuffer();
                List map2_ys1 = tparams;
                List map2_ys2 = map2_xs2;
                while (!map2_ys1.isEmpty() && !map2_ys2.isEmpty()) {
                    List list = (List)map2_ys2.head();
                    Symbols.Symbol symbol = map2_ys1.head();
                    map2_lb.$plus$eq(GlbLubs.$anonfun$glbNorm$1(this, depth$4, symbol, list));
                    map2_ys1 = (List)map2_ys1.tail();
                    map2_ys2 = (List)map2_ys2.tail();
                }
                List<Symbols.Symbol> list = map2_lb.toList();
                return new Types.PolyType((SymbolTable)this, list, this.glbNorm(this.matchingInstTypes($colon$colon, list), depth$4));
            }
        }
        if (bl && (mt = (Types.Type)$colon$colon.head()) instanceof Types.MethodType) {
            Types.MethodType methodType = (Types.MethodType)mt;
            List<Symbols.Symbol> params = methodType.params();
            return new Types.MethodType((SymbolTable)this, params, this.glbNorm(this.matchingRestypes($colon$colon, methodType.paramTypes()), depth$4));
        }
        if (bl && (Types.Type)$colon$colon.head() instanceof Types.NullaryMethodType) {
            return new Types.NullaryMethodType((SymbolTable)this, this.glbNorm(this.matchingRestypes($colon$colon, Nil$.MODULE$), depth$4));
        }
        if (bl && (Types.Type)$colon$colon.head() instanceof Types.TypeBounds) {
            return ((Types)this).TypeBounds().apply(this.lub($colon$colon.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$35 -> x$35.lowerBound(), List$.MODULE$.canBuildFrom()), depth$4), this.glb($colon$colon.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$36 -> x$36.upperBound(), List$.MODULE$.canBuildFrom()), depth$4));
        }
        Option<Types.Type> option = this.glbResults().get(new Tuple2<Depth, List>(new Depth(depth$4), ts0));
        if (option instanceof Some) {
            type = (Types.Type)((Some)option).value();
            return type;
        } else {
            this.glbResults().update(new Tuple2<Depth, List>(new Depth(depth$4), ts0), ((Definitions)((Object)this)).definitions().NothingTpe());
            Types.Type res = Depth$.MODULE$.isNegative$extension(depth$4) ? ((Definitions)((Object)this)).definitions().NothingTpe() : this.glb1$1(ts0, depth$4, ts$6);
            this.glbResults().update(new Tuple2<Depth, List>(new Depth(depth$4), ts0), res);
            type = res;
        }
        return type;
    }

    private static void loop$2(Types.Type ty, ListBuffer res$2) {
        if (ty instanceof Types.RefinedType) {
            List ps = ((Types.RefinedType)ty).parents();
            if (ps == null) {
                throw null;
            }
            List foreach_these = ps;
            while (!foreach_these.isEmpty()) {
                Types.Type type = foreach_these.head();
                GlbLubs.loop$2(type, res$2);
                foreach_these = (List)foreach_these.tail();
            }
        } else {
            res$2.$plus$eq(ty);
        }
    }

    public static /* synthetic */ Object $anonfun$glbNorm$7(Types.Type glbThisType$1, Types.Type prototp$2, ListBuffer res$3, Symbols.Symbol alt) {
        Types.Type mi = glbThisType$1.memberInfo(alt);
        if (mi.matches(prototp$2)) {
            return res$3.$plus$eq(mi);
        }
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ void $anonfun$glbNorm$6(Symbols.Symbol proto$2, Types.Type glbThisType$1, Types.Type prototp$2, ListBuffer res$3, Types.Type t) {
        List list = t.nonPrivateMember(proto$2.name()).alternatives();
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Symbols.Symbol symbol = foreach_these.head();
            GlbLubs.$anonfun$glbNorm$7(glbThisType$1, prototp$2, res$3, symbol);
            foreach_these = (List)foreach_these.tail();
        }
    }

    private static boolean isTypeBound$1(Types.Type tp) {
        boolean bl = tp instanceof Types.TypeBounds;
        return bl;
    }

    private Types.TypeBounds glbBounds$1(List bnds, int depth$4) {
        Types.Type hi;
        Types.Type lo = this.lub(bnds.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$38 -> x$38.lowerBound(), List$.MODULE$.canBuildFrom()), Depth$.MODULE$.decr$extension1(depth$4));
        if (lo.$less$colon$less(hi = this.glb(bnds.map((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x$39 -> x$39.upperBound(), List$.MODULE$.canBuildFrom()), Depth$.MODULE$.decr$extension1(depth$4)))) {
            return ((Types)this).TypeBounds().apply(lo, hi);
        }
        throw this.GlbFailure();
    }

    public static /* synthetic */ boolean $anonfun$glbNorm$11(Types.Type t) {
        return !GlbLubs.isTypeBound$1(t);
    }

    public static /* synthetic */ void $anonfun$glbNorm$12(GlbLubs $this, ObjectRef result$1, Types.Type t) {
        if (((Types.Type)result$1.elem).bounds().containsType(t)) {
            result$1.elem = t;
            return;
        }
        throw $this.GlbFailure();
    }

    private Symbols.Symbol glbsym$1(Symbols.Symbol proto, Types.Type glbThisType$1, List ts$5, Types.Type glbRefined$1, int depth$4) {
        Types.Type type;
        Types.Type prototp = glbThisType$1.memberInfo(proto);
        ListBuffer res = (ListBuffer)ListBuffer$.MODULE$.empty();
        if (ts$5 == null) {
            throw null;
        }
        List foreach_these = ts$5;
        while (!foreach_these.isEmpty()) {
            Types.Type type2 = (Types.Type)foreach_these.head();
            GlbLubs.$anonfun$glbNorm$6(proto, glbThisType$1, prototp, res, type2);
            foreach_these = (List)foreach_these.tail();
        }
        List<Types.Type> symtypes = res.toList();
        ((SymbolTable)this).assert(!symtypes.isEmpty());
        Symbols.Symbol symbol = proto.cloneSymbol(glbRefined$1.typeSymbol());
        if (proto.isTerm()) {
            type = this.glb(symtypes, Depth$.MODULE$.decr$extension1(depth$4));
        } else {
            List symbounds = (List)symtypes.filter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)tp -> BoxesRunTime.boxToBoolean(GlbLubs.isTypeBound$1(tp)));
            ObjectRef<Types.TypeBounds> result2 = ObjectRef.create(symbounds.isEmpty() ? ((Types)this).TypeBounds().empty() : this.glbBounds$1(symbounds, depth$4));
            symtypes.withFilter((Function1<Types.Type, Object> & java.io.Serializable & Serializable)t -> BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$glbNorm$11(t))).foreach((Function1<Types.Type, Object> & java.io.Serializable & Serializable)t -> {
                GlbLubs.$anonfun$glbNorm$12(this, result2, t);
                return BoxedUnit.UNIT;
            });
            type = (Types.Type)result2.elem;
        }
        return symbol.setInfoOwnerAdjusted(type);
    }

    public static /* synthetic */ void $anonfun$glbNorm$14(GlbLubs $this, Types.Type glbThisType$1, int depth$4, Types.Type glbRefined$1, List ts$5, Symbols.Symbol sym) {
        if (new Depth($this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth()).$less(new Depth($this.scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit())) && !((Types)$this).specializesSym(glbThisType$1, sym, depth$4)) {
            try {
                ((Types)$this).addMember(glbThisType$1, glbRefined$1, $this.glbsym$1(sym, glbThisType$1, ts$5, glbRefined$1, depth$4), depth$4);
                return;
            }
            catch (Types.NoCommonType noCommonType) {
                return;
            }
        }
    }

    private void foreachRefinedDecls$1(Types.Type ty, Types.Type glbThisType$1, int depth$4, Types.Type glbRefined$1, List ts$5) {
        if (ty instanceof Types.RefinedType) {
            Types.RefinedType refinedType = (Types.RefinedType)ty;
            List ps = refinedType.parents();
            Scopes.Scope decls = refinedType.decls();
            if (ps == null) {
                throw null;
            }
            List foreach_these = ps;
            while (!foreach_these.isEmpty()) {
                Types.Type type = foreach_these.head();
                this.foreachRefinedDecls$1(type, glbThisType$1, depth$4, glbRefined$1, ts$5);
                foreach_these = (List)foreach_these.tail();
            }
            if (!decls.isEmpty()) {
                decls.iterator().foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> {
                    GlbLubs.$anonfun$glbNorm$14(this, glbThisType$1, depth$4, glbRefined$1, ts$5, sym);
                    return BoxedUnit.UNIT;
                });
                return;
            }
        }
    }

    public static /* synthetic */ boolean $anonfun$glbNorm$16(GlbLubs $this, Types.Type t) {
        return ((Definitions)((Object)$this)).definitions().NullTpe().$less$colon$less(t);
    }

    /*
     * WARNING - void declaration
     */
    private Types.Type glb1$1(List ts0, int depth$4, List ts$6) {
        try {
            Types.Type type;
            void var7_6;
            void var6_5;
            Tuple2<List<Types.Type>, List<Symbols.Symbol>> tuple2 = ((Types)this).stripExistentialsAndTypeVars(ts0, ((Types)this).stripExistentialsAndTypeVars$default$2());
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            List<Types.Type> ts = tuple2._1();
            List<Symbols.Symbol> tparams = tuple2._2();
            void ts2 = var6_5;
            void tparams2 = var7_6;
            Symbols.Symbol glbOwner = ((CommonOwners)((Object)this)).commonOwner((List<Types.Type>)ts2);
            ListBuffer res = (ListBuffer)ListBuffer$.MODULE$.empty();
            if (ts2 == null) {
                throw null;
            }
            List foreach_these = ts2;
            while (!foreach_these.isEmpty()) {
                Types.Type type2 = (Types.Type)foreach_these.head();
                GlbLubs.loop$2(type2, res);
                foreach_these = (List)foreach_these.tail();
            }
            List<Types.Type> ts1 = res.toList();
            if (((SymbolTable)this).phase().erasedTypes() || Depth$.MODULE$.isZero$extension(depth$4)) {
                type = ((Types)this).intersectionType(ts1, glbOwner);
            } else {
                Types.Type glbRefined = ((Types)this).refinedType(ts1, glbOwner);
                Types.Type glbThisType = glbRefined.typeSymbol().thisType();
                if (new Depth(this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth()).$less(new Depth(this.scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit()))) {
                    try {
                        this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth_$eq(Depth$.MODULE$.incr$extension1(this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth()));
                        List foreach_these2 = ts2;
                        while (!foreach_these2.isEmpty()) {
                            Types.Type type3 = (Types.Type)foreach_these2.head();
                            this.foreachRefinedDecls$1(type3, glbThisType, depth$4, glbRefined, (List)ts2);
                            foreach_these2 = (List)foreach_these2.tail();
                        }
                    }
                    finally {
                        this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth_$eq(Depth$.MODULE$.decr$extension1(this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth()));
                    }
                }
                type = glbRefined.decls().isEmpty() ? ((Types)this).intersectionType(ts1, glbOwner) : glbRefined;
            }
            Types.Type glbType = type;
            return ((Types)this).existentialAbstraction((List<Symbols.Symbol>)tparams2, glbType);
        }
        catch (Throwable throwable) {
            boolean bl;
            block18: {
                Throwable throwable2 = this.GlbFailure();
                if (!(throwable2 != null ? !throwable2.equals(throwable) : throwable != null)) {
                    if (ts$6 == null) {
                        throw null;
                    }
                    LinearSeqOptimized forall_these = ts$6;
                    while (!forall_these.isEmpty()) {
                        Types.Type type = (Types.Type)forall_these.head();
                        if (!GlbLubs.$anonfun$glbNorm$16(this, type)) {
                            bl = false;
                            break block18;
                        }
                        forall_these = (LinearSeqOptimized)forall_these.tail();
                    }
                    bl = true;
                } else {
                    throw throwable;
                }
            }
            Types.Type type = bl ? ((Definitions)((Object)this)).definitions().NullTpe() : ((Definitions)((Object)this)).definitions().NothingTpe();
            return type;
        }
    }

    private List getBounds$1(Types.Type tp, List tparams$1, List tps$1) {
        List<Symbols.Symbol> tparams1;
        block1: {
            while (true) {
                if (tp instanceof Types.PolyType && ((Collections)((Object)this_)).sameLength(tparams1 = ((Types.PolyType)tp).typeParams(), tparams$1)) break block1;
                if (tp == tp.normalize()) break;
                tp = tp.normalize();
                GlbLubs this_ = (SymbolTable)this_;
            }
            throw new Types.NoCommonType((SymbolTable)this_, tps$1);
        }
        List list = tparams1.map((Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)tparam -> tparam.info().substSym(tparams1, tparams$1), List$.MODULE$.canBuildFrom());
        return list;
    }

    private Types.Type transformResultType$1(Types.Type tp, List tparams$2, List tps$2) {
        Types.Type restpe;
        List<Symbols.Symbol> tparams1;
        block2: {
            while (true) {
                if (tp instanceof Types.PolyType) {
                    Types.PolyType polyType = (Types.PolyType)tp;
                    tparams1 = polyType.typeParams();
                    restpe = polyType.resultType();
                    if (((Collections)((Object)this_)).sameLength(tparams1, tparams$2)) break block2;
                }
                if (tp == tp.normalize()) break;
                tp = tp.normalize();
                GlbLubs this_ = (SymbolTable)this_;
            }
            throw new Types.NoCommonType((SymbolTable)this_, tps$2);
        }
        Types.Type type = restpe.substSym(tparams1, tparams$2);
        return type;
    }

    /*
     * WARNING - void declaration
     */
    public static void $init$(GlbLubs $this) {
        void apply_depth;
        $this.scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$printLubs_$eq(package$.MODULE$.props().contains("scalac.debug.lub"));
        $this.scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$strictInference_$eq(((SymbolTable)$this).settings().strictInference());
        $this.scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$_lubResults_$eq(new HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>());
        $this.scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$_glbResults_$eq(new HashMap<Tuple2<Depth, List<Types.Type>>, Types.Type>());
        $this.scala$reflect$internal$tpe$GlbLubs$_setter_$GlbFailure_$eq(new Throwable());
        $this.scala$reflect$internal$tpe$GlbLubs$$globalGlbDepth_$eq(Depth$.MODULE$.Zero());
        Depth$ depth$ = Depth$.MODULE$;
        int n = 2;
        if (depth$ == null) {
            throw null;
        }
        Depth$ apply_this = depth$;
        $this.scala$reflect$internal$tpe$GlbLubs$_setter_$scala$reflect$internal$tpe$GlbLubs$$globalGlbLimit_$eq(apply_depth < -3 ? apply_this.AnyDepth() : n);
    }

    public static /* synthetic */ TableDef.Column $anonfun$printLubMatrix$4$adapted(GlbLubs $this, Tuple2 x0$1, Object x1$1) {
        return GlbLubs.$anonfun$printLubMatrix$4($this, x0$1, BoxesRunTime.unboxToInt(x1$1));
    }

    public static /* synthetic */ Object $anonfun$willViolateRecursiveBounds$4$adapted(GlbLubs $this, List ts$2, Symbols.Symbol param2, Types.Type arg, List lubbedArgs) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$willViolateRecursiveBounds$4($this, ts$2, param2, arg, lubbedArgs));
    }

    public static /* synthetic */ Object $anonfun$elimSuper$2$adapted(Types.Type t$2, Types.Type t1) {
        return BoxesRunTime.boxToBoolean(t1.$less$colon$less(t$2));
    }

    public static /* synthetic */ Object $anonfun$sameWeakLubAsLub$1$adapted(Types.Type x$22) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$sameWeakLubAsLub$1(x$22));
    }

    public static /* synthetic */ Object $anonfun$sameWeakLubAsLub$2$adapted(GlbLubs $this, Types.Type tp) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$sameWeakLubAsLub$2($this, tp));
    }

    public static /* synthetic */ Object $anonfun$weakLub$1$adapted(GlbLubs $this, Types.Type tp) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$weakLub$1($this, tp));
    }

    public static /* synthetic */ Object $anonfun$weakLub$2$adapted(Types.Type x$23) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$weakLub$2(x$23));
    }

    public static /* synthetic */ Object $anonfun$lub$2$adapted(int hs$1, Types.Type x$25) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lub$2(hs$1, x$25));
    }

    public static /* synthetic */ Object $anonfun$willViolateRecursiveBounds$2$adapted(List eta$0$1$1, Object elem) {
        return BoxesRunTime.boxToBoolean(eta$0$1$1.contains(elem));
    }

    public static /* synthetic */ Object $anonfun$willViolateRecursiveBounds$5$adapted(Types.Type arg$1, Types.Type x$6) {
        return BoxesRunTime.boxToBoolean(x$6.$eq$colon$eq(arg$1));
    }

    public static /* synthetic */ Object $anonfun$lubList$2$adapted(Symbols.Symbol x$8, Types.Type x$9) {
        return BoxesRunTime.boxToBoolean(GlbLubs.isHotForT$1(x$8, x$9));
    }

    public static /* synthetic */ Object $anonfun$lubList$1$adapted(List xs$1, Types.Type x$7) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lubList$1(xs$1, x$7));
    }

    public static /* synthetic */ Object $anonfun$lubList$4$adapted(List x$10) {
        return BoxesRunTime.boxToBoolean(x$10.isEmpty());
    }

    public static /* synthetic */ Object $anonfun$lubList$6$adapted(Types.Type t$1, Types.Type x$13) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lubList$6(t$1, x$13));
    }

    public static /* synthetic */ Object $anonfun$elimSub$2$adapted(GlbLubs $this, Types.Type t$3, int depth$2, Types.Type t1) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$elimSub$2($this, t$3, depth$2, t1));
    }

    public static /* synthetic */ Object $anonfun$lub$9$adapted(GlbLubs $this, Symbols.Symbol sym$3, Types.Type lubThisType$1, int depth$3, Types.Type t) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lub$9($this, sym$3, lubThisType$1, depth$3, t));
    }

    public static /* synthetic */ Object $anonfun$lub$16$adapted(GlbLubs $this, Symbols.Symbol sym$4, Types.Type lubThisType$1, Types.Type tp$2, int depth$3, Symbols.Symbol alt) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lub$16($this, sym$4, lubThisType$1, tp$2, depth$3, alt));
    }

    public static /* synthetic */ Object $anonfun$lub$19$adapted(GlbLubs $this, Types.Type lubThisType$1, Types.Type lubRefined$1, int depth$3, Symbols.Symbol x$34) {
        GlbLubs.$anonfun$lub$19($this, lubThisType$1, lubRefined$1, depth$3, x$34);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$lub$20$adapted(GlbLubs $this, Types.Type lubRefined$1, int depth$3, Types.Type lubBase$1, Types.Type t) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$lub$20($this, lubRefined$1, depth$3, lubBase$1, t));
    }

    public static /* synthetic */ Object $anonfun$glbNorm$4$adapted(ListBuffer res$2, Types.Type ty) {
        GlbLubs.loop$2(ty, res$2);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$glbNorm$6$adapted(Symbols.Symbol proto$2, Types.Type glbThisType$1, Types.Type prototp$2, ListBuffer res$3, Types.Type t) {
        GlbLubs.$anonfun$glbNorm$6(proto$2, glbThisType$1, prototp$2, res$3, t);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$glbNorm$13$adapted(GlbLubs $this, Types.Type glbThisType$1, int depth$4, Types.Type glbRefined$1, List ts$5, Types.Type ty) {
        $this.foreachRefinedDecls$1(ty, glbThisType$1, depth$4, glbRefined$1, ts$5);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$glbNorm$5$adapted(ListBuffer res$2, Types.Type ty) {
        GlbLubs.loop$2(ty, res$2);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$glbNorm$15$adapted(GlbLubs $this, Types.Type glbThisType$1, int depth$4, Types.Type glbRefined$1, List ts$5, Types.Type ty) {
        $this.foreachRefinedDecls$1(ty, glbThisType$1, depth$4, glbRefined$1, ts$5);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$glbNorm$16$adapted(GlbLubs $this, Types.Type t) {
        return BoxesRunTime.boxToBoolean(GlbLubs.$anonfun$glbNorm$16($this, t));
    }
}

