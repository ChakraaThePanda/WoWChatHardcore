/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.AbstractTraversable;
import scala.collection.GenMap;
import scala.collection.Iterable$;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.Map$;
import scala.collection.mutable.Set;
import scala.collection.mutable.Set$;
import scala.math.Ordering;
import scala.math.Ordering$Int$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Names;
import scala.reflect.internal.NoPhase$;
import scala.reflect.internal.Phase;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.runtime.java8.JFunction1$mcZI$sp;
import scala.sys.ShutdownHookThread;
import scala.sys.ShutdownHookThread$;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\u0005mgaB\r\u001b!\u0003\r\ta\t\u0005\u0006Q\u0001!\t!\u000b\u0005\b[\u0001\u0011\rQ\"\u0001/\u0011\u001d\u0019\u0004\u00011Q\u0005\nQBq\u0001\u000f\u0001AB\u0013%\u0011\bC\u0004=\u0001\t\u0007I\u0011A\u001f\t\u000fA\u0003!\u0019!C\u0001#\"9!\f\u0001b\u0001\n\u0003Y\u0006b\u00023\u0001\u0005\u0004%\t!\u001a\u0005\u0006]\u0002!\ta\u001c\u0005\u0006e\u0002!\ta\u001d\u0005\u0006m\u0002!\ta\u001e\u0005\tw\u0002A)\u0019!C\u0005y\")Q\u0010\u0001C\u0005}\"9\u0011\u0011\u0004\u0001\u0005\n\u0005m\u0001bBA\u0014\u0001\u0011%\u0011\u0011\u0006\u0005\b\u0003s\u0001A\u0011BA\u001e\u0011\u001d\t\t\u0005\u0001C\u0005\u0003\u0007Bq!a\u0012\u0001\t\u0013\tI\u0005C\u0004\u0002N\u0001!I!a\u0014\t\u000f\u0005M\u0003\u0001\"\u0003\u0002V!9\u0011\u0011\f\u0001\u0005\n\u0005m\u0003bBAI\u0001\u0011%\u00111\u0013\u0005\b\u0003w\u0003A\u0011BA_\u0011\u0019\tI\u000e\u0001C\u0001S\t\u0019BK]1dKNKXNY8m\u0003\u000e$\u0018N^5us*\u00111\u0004H\u0001\u0005kRLGN\u0003\u0002\u001e=\u0005A\u0011N\u001c;fe:\fGN\u0003\u0002 A\u00059!/\u001a4mK\u000e$(\"A\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001\u0001\n\t\u0003K\u0019j\u0011\u0001I\u0005\u0003O\u0001\u0012a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001+!\t)3&\u0003\u0002-A\t!QK\\5u\u0003\u00199Gn\u001c2bYV\tq\u0006\u0005\u00021c5\tA$\u0003\u000239\tY1+_7c_2$\u0016M\u00197f\u0003\u001d)g.\u00192mK\u0012,\u0012!\u000e\t\u0003KYJ!a\u000e\u0011\u0003\u000f\t{w\u000e\\3b]\u0006YQM\\1cY\u0016$w\fJ3r)\tQ#\bC\u0004<\t\u0005\u0005\t\u0019A\u001b\u0002\u0007a$\u0013'\u0001\u0006bY2\u001c\u00160\u001c2pYN,\u0012A\u0010\t\u0005\u007f\u00113\u0015*D\u0001A\u0015\t\t%)A\u0004nkR\f'\r\\3\u000b\u0005\r\u0003\u0013AC2pY2,7\r^5p]&\u0011Q\t\u0011\u0002\u0004\u001b\u0006\u0004\bCA\u0013H\u0013\tA\u0005EA\u0002J]R\u0004\"A\u0013'\u000f\u0005-\u0013Q\"\u0001\u0001\n\u00055s%AB*z[\n|G.\u0003\u0002P9\t91+_7c_2\u001c\u0018aC1mY\u000eC\u0017\u000e\u001c3sK:,\u0012A\u0015\t\u0005\u007f\u001135\u000bE\u0002U/\u001as!!J+\n\u0005Y\u0003\u0013a\u00029bG.\fw-Z\u0005\u00031f\u0013A\u0001T5ti*\u0011a\u000bI\u0001\u000baJ,goT<oKJ\u001cX#\u0001/\u0011\t}\"e)\u0018\t\u0004)^s\u0006\u0003B\u0013`\r\u0006L!\u0001\u0019\u0011\u0003\rQ+\b\u000f\\33!\t\u0001$-\u0003\u0002d9\t)\u0001\u000b[1tK\u0006A\u0011\r\u001c7Ue\u0016,7/F\u0001g!\ryt-[\u0005\u0003Q\u0002\u00131aU3u!\tQ%.\u0003\u0002lY\n!AK]3f\u0013\tiGDA\u0003Ue\u0016,7/A\nsK\u000e|'\u000fZ*z[\n|Gn]%o)J,W\r\u0006\u0002+a\")\u0011/\u0003a\u0001S\u0006!AO]3f\u0003=\u0011XmY8sI:+woU=nE>dGC\u0001\u0016u\u0011\u0015)(\u00021\u0001J\u0003\r\u0019\u00180\\\u0001\u0015e\u0016\u001cwN\u001d3OK^\u001c\u00160\u001c2pY>;h.\u001a:\u0015\u0007)B\u0018\u0010C\u0003v\u0017\u0001\u0007\u0011\nC\u0003{\u0017\u0001\u0007\u0011*\u0001\u0005oK^|uO\\3s\u00031)'/Y:ve\u0016\u0004\u0006.Y:f+\u0005\t\u0017!C:jO:\fG/\u001e:f)\ry\u0018Q\u0003\t\u0005\u0003\u0003\tyA\u0004\u0003\u0002\u0004\u0005-\u0001cAA\u0003A5\u0011\u0011q\u0001\u0006\u0004\u0003\u0013\u0011\u0013A\u0002\u001fs_>$h(C\u0002\u0002\u000e\u0001\na\u0001\u0015:fI\u00164\u0017\u0002BA\t\u0003'\u0011aa\u0015;sS:<'bAA\u0007A!1\u0011qC\u0007A\u0002\u0019\u000b!!\u001b3\u0002\r\u0011\f7\u000f[3t)\ry\u0018Q\u0004\u0005\b\u0003?q\u0001\u0019AA\u0011\u0003\u0005\u0019\bcA\u0013\u0002$%\u0019\u0011Q\u0005\u0011\u0003\u0007\u0005s\u00170\u0001\u0003tQ><H#\u0002\u0016\u0002,\u0005=\u0002bBA\u0017\u001f\u0001\u0007\u0011\u0011E\u0001\u0003gFBq!!\r\u0010\u0001\u0004\t\u0019$\u0001\u0002tgB)Q%!\u000e\u0002\"%\u0019\u0011q\u0007\u0011\u0003\u0015q\u0012X\r]3bi\u0016$g(\u0001\u0006tQ><\b*Z1eKJ$RAKA\u001f\u0003\u007fAq!!\f\u0011\u0001\u0004\t\t\u0003C\u0004\u00022A\u0001\r!a\r\u0002\u000fMDwn^*z[R\u0019!&!\u0012\t\u000bU\f\u0002\u0019A%\u0002\u001fMDwn^%e\u0003:$'+Z7pm\u0016$2AKA&\u0011\u0019\t9B\u0005a\u0001\r\u0006I1/_7c_2\u001cFO\u001d\u000b\u0004\u007f\u0006E\u0003BBA\f'\u0001\u0007a)\u0001\u0005po:,'o\u0015;s)\ry\u0018q\u000b\u0005\u0007\u0003/!\u0002\u0019\u0001$\u0002\t\u0019\u0014X-]\u000b\u0007\u0003;\n\t)!\u001b\u0015\t\u0005}\u0013Q\u0011\u000b\u0005\u0003C\n)\b\u0005\u0003U/\u0006\r\u0004#B\u0013`\u0003K2\u0005\u0003BA4\u0003Sb\u0001\u0001B\u0004\u0002lU\u0011\r!!\u001c\u0003\u0003U\u000bB!a\u001c\u0002\"A\u0019Q%!\u001d\n\u0007\u0005M\u0004EA\u0004O_RD\u0017N\\4\t\u000f\u0005]T\u00031\u0001\u0002z\u0005\u0011aM\u001c\t\bK\u0005m\u0014qPA3\u0013\r\ti\b\t\u0002\n\rVt7\r^5p]F\u0002B!a\u001a\u0002\u0002\u00129\u00111Q\u000bC\u0002\u00055$!\u0001+\t\u000f\u0005\u001dU\u00031\u0001\u0002\n\u0006\u0011\u0001p\u001d\t\u0007\u0003\u0017\u000bi)a \u000e\u0003\tK1!a$C\u0005-!&/\u0019<feN\f'\r\\3\u0002\u0017MDwn^'ba\u001a\u0013X-]\u000b\u0005\u0003+\u000b\t\u000b\u0006\u0003\u0002\u0018\u0006\rFc\u0001\u0016\u0002\u001a\"9\u00111\u0014\fA\u0002\u0005u\u0015AB:i_^4e\u000e\u0005\u0004&\u0003w\nyj \t\u0005\u0003O\n\t\u000bB\u0004\u0002\u0004Z\u0011\r!!\u001c\t\u000f\u0005\u001de\u00031\u0001\u0002&BA\u00111RAT\u0003?\u000bI+\u0003\u0002F\u0005B\"\u00111VAY!\u0015!\u0016QVAX\u0013\r\ty)\u0017\t\u0005\u0003O\n\t\f\u0002\u0007\u00024\u0006U\u0016\u0011!A\u0001\u0006\u0003\tiGA\u0002`IEBq!a\"\u0017\u0001\u0004\t9\f\u0005\u0005\u0002\f\u0006\u001d\u0016\u0011XAU!\u0011\t9'!)\u0002\u0011MDwn\u001e$sKF,b!a0\u0002L\u0006=G\u0003BAa\u0003+$RAKAb\u0003#Dq!!2\u0018\u0001\u0004\t9-A\u0004he>,\bO\u00128\u0011\u000f\u0015\nY(!3\u0002NB!\u0011qMAf\t\u001d\t\u0019i\u0006b\u0001\u0003[\u0002B!a\u001a\u0002P\u00129\u00111N\fC\u0002\u00055\u0004bBAN/\u0001\u0007\u00111\u001b\t\u0007K\u0005m\u0014QZ@\t\u000f\u0005\u001du\u00031\u0001\u0002XB)A+!,\u0002J\u0006q1\u000f[8x\u00032d7+_7c_2\u001c\b")
public interface TraceSymbolActivity {
    public void scala$reflect$internal$util$TraceSymbolActivity$_setter_$allSymbols_$eq(scala.collection.mutable.Map<Object, Symbols.Symbol> var1);

    public void scala$reflect$internal$util$TraceSymbolActivity$_setter_$allChildren_$eq(scala.collection.mutable.Map<Object, List<Object>> var1);

    public void scala$reflect$internal$util$TraceSymbolActivity$_setter_$prevOwners_$eq(scala.collection.mutable.Map<Object, List<Tuple2<Object, Phase>>> var1);

    public void scala$reflect$internal$util$TraceSymbolActivity$_setter_$allTrees_$eq(Set<Trees.Tree> var1);

    public SymbolTable global();

    public boolean scala$reflect$internal$util$TraceSymbolActivity$$enabled();

    public void scala$reflect$internal$util$TraceSymbolActivity$$enabled_$eq(boolean var1);

    public scala.collection.mutable.Map<Object, Symbols.Symbol> allSymbols();

    public scala.collection.mutable.Map<Object, List<Object>> allChildren();

    public scala.collection.mutable.Map<Object, List<Tuple2<Object, Phase>>> prevOwners();

    public Set<Trees.Tree> allTrees();

    public static /* synthetic */ void recordSymbolsInTree$(TraceSymbolActivity $this, Trees.Tree tree) {
        $this.recordSymbolsInTree(tree);
    }

    default public void recordSymbolsInTree(Trees.Tree tree) {
        if (this.scala$reflect$internal$util$TraceSymbolActivity$$enabled()) {
            this.allTrees().$plus$eq(tree);
        }
    }

    public static /* synthetic */ void recordNewSymbol$(TraceSymbolActivity $this, Symbols.Symbol sym) {
        $this.recordNewSymbol(sym);
    }

    default public void recordNewSymbol(Symbols.Symbol sym) {
        if (this.scala$reflect$internal$util$TraceSymbolActivity$$enabled() && sym.id() > 1) {
            this.allSymbols().update(BoxesRunTime.boxToInteger(sym.id()), sym);
            int n = sym.owner().id();
            this.allChildren().update(BoxesRunTime.boxToInteger(n), ((List)this.allChildren().apply(BoxesRunTime.boxToInteger(n))).$colon$colon(BoxesRunTime.boxToInteger(sym.id())));
        }
    }

    public static /* synthetic */ void recordNewSymbolOwner$(TraceSymbolActivity $this, Symbols.Symbol sym, Symbols.Symbol newOwner) {
        $this.recordNewSymbolOwner(sym, newOwner);
    }

    /*
     * WARNING - void declaration
     */
    default public void recordNewSymbolOwner(Symbols.Symbol sym, Symbols.Symbol newOwner) {
        if (this.scala$reflect$internal$util$TraceSymbolActivity$$enabled()) {
            void $minus$greater$extension_y;
            void $minus$greater$extension_$this;
            int sid = sym.id();
            int oid = sym.owner().id();
            int nid = newOwner.id();
            Phase phase = this.global().phase();
            Integer n = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(oid));
            if (Predef$ArrowAssoc$.MODULE$ == null) {
                throw null;
            }
            this.prevOwners().update(BoxesRunTime.boxToInteger(sid), ((List)this.prevOwners().apply(BoxesRunTime.boxToInteger(sid))).$colon$colon(new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y)));
            this.allChildren().update(BoxesRunTime.boxToInteger(oid), (List<Object>)((TraversableLike)this.allChildren().apply(BoxesRunTime.boxToInteger(oid))).filterNot((JFunction1$mcZI$sp & Serializable)x$1 -> x$1 == sid));
            this.allChildren().update(BoxesRunTime.boxToInteger(nid), ((List)this.allChildren().apply(BoxesRunTime.boxToInteger(nid))).$colon$colon(BoxesRunTime.boxToInteger(sid)));
        }
    }

    public static /* synthetic */ Phase scala$reflect$internal$util$TraceSymbolActivity$$erasurePhase$(TraceSymbolActivity $this) {
        return $this.scala$reflect$internal$util$TraceSymbolActivity$$erasurePhase();
    }

    default public Phase scala$reflect$internal$util$TraceSymbolActivity$$erasurePhase() {
        return this.global().findPhaseWithName("erasure");
    }

    /*
     * WARNING - void declaration
     */
    private String signature(int id) {
        String string;
        void enteringPhase_ph;
        SymbolTable symbolTable = this.global();
        Phase phase = this.scala$reflect$internal$util$TraceSymbolActivity$$erasurePhase();
        if (symbolTable == null) {
            throw null;
        }
        SymbolTable enteringPhase_this = symbolTable;
        if (enteringPhase_ph == enteringPhase_this.phase()) {
            return TraceSymbolActivity.$anonfun$signature$1(this, id);
        }
        Phase enteringPhase_saved = enteringPhase_this.pushPhase((Phase)enteringPhase_ph);
        try {
            string = TraceSymbolActivity.$anonfun$signature$1(this, id);
        }
        finally {
            enteringPhase_this.popPhase(enteringPhase_saved);
        }
        return string;
    }

    private String dashes(Object s) {
        String string = String.valueOf(s);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return (String)TraversableLike.map$(new StringOps(string), (Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToCharacter(TraceSymbolActivity.$anonfun$dashes$1(BoxesRunTime.unboxToChar(x$2))), Predef$.MODULE$.StringCanBuildFrom());
    }

    private void show(Object s1, Seq<Object> ss) {
        String string = "%-12s";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        String string2 = new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{s1}));
        Predef$.MODULE$.println(((TraversableOnce)ss.$plus$colon(string2, Seq$.MODULE$.canBuildFrom())).mkString(" "));
    }

    private void showHeader(Object s1, Seq<Object> ss) {
        this.show(s1, ss);
        this.show(this.dashes(s1), ss.map((Function1<Object, String> & java.io.Serializable & Serializable)s -> this.dashes(s), Seq$.MODULE$.canBuildFrom()));
    }

    private void showSym(Symbols.Symbol sym) {
        try {
            String string = "%s#%s %s";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Predef$.MODULE$.println(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{TraceSymbolActivity.prefix$1(sym), sym.accurateKindString(), sym.name().decode()})));
        }
        catch (Throwable x) {
            Predef$.MODULE$.println(new StringBuilder(9).append(TraceSymbolActivity.prefix$1(sym)).append(" failed: ").append(x).toString());
        }
        List list = (List)((SeqLike)this.allChildren().apply(BoxesRunTime.boxToInteger(sym.id()))).sorted(Ordering$Int$.MODULE$);
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            int n = BoxesRunTime.unboxToInt(foreach_these.head());
            this.showIdAndRemove(n);
            foreach_these = (List)foreach_these.tail();
        }
    }

    private void showIdAndRemove(int id) {
        Option option = this.allSymbols().remove(BoxesRunTime.boxToInteger(id));
        if (option == null) {
            throw null;
        }
        Option foreach_this = option;
        if (!foreach_this.isEmpty()) {
            Symbols.Symbol symbol = (Symbols.Symbol)foreach_this.get();
            this.showSym(symbol);
            return;
        }
    }

    private String symbolStr(int id) {
        if (id == 1) {
            return "NoSymbol";
        }
        Symbols.Symbol sym = (Symbols.Symbol)this.allSymbols().apply(BoxesRunTime.boxToInteger(id));
        return new StringBuilder(1).append(sym.accurateKindString()).append(" ").append(sym.name().decode()).toString();
    }

    private String ownerStr(int id) {
        Symbols.Symbol sym = (Symbols.Symbol)this.allSymbols().apply(BoxesRunTime.boxToInteger(id));
        return new StringBuilder(1).append(sym.name().decode()).append("#").append(sym.id()).toString();
    }

    private <T, U> List<Tuple2<U, Object>> freq(Traversable<T> xs, Function1<T, U> fn) {
        return (List)xs.groupBy(fn).mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$4 -> BoxesRunTime.boxToInteger(x$4.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$5 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$freq$2(x$5)), (Ordering)Ordering$Int$.MODULE$);
    }

    private <T> void showMapFreq(Map<T, Traversable<?>> xs, Function1<T, String> showFn) {
        Object object = ((List)xs.mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToInteger(x$6.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$showMapFreq$2(x$7)), (Ordering)Ordering$Int$.MODULE$)).take(100);
        if (object == null) {
            throw null;
        }
        Object foreach_these = object;
        while (!((List)foreach_these).isEmpty()) {
            Tuple2 tuple2 = (Tuple2)((List)foreach_these).head();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Object $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k = tuple2._1();
            int $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size = tuple2._2$mcI$sp();
            this.show(BoxesRunTime.boxToInteger($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size), Predef$.MODULE$.genericWrapArray(new Object[]{showFn.apply($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k)}));
            foreach_these = (List)((AbstractTraversable)foreach_these).tail();
        }
        Predef$.MODULE$.println("\n");
    }

    private <T, U> void showFreq(Traversable<T> xs, Function1<T, U> groupFn, Function1<U, String> showFn) {
        Object object = ((List)xs.toList().groupBy(groupFn).mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToInteger(x$6.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$showMapFreq$2(x$7)), (Ordering)Ordering$Int$.MODULE$)).take(100);
        if (object == null) {
            throw null;
        }
        Object showMapFreq_foreach_these = object;
        while (!((List)showMapFreq_foreach_these).isEmpty()) {
            Tuple2 tuple2 = (Tuple2)((List)showMapFreq_foreach_these).head();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Object $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k = tuple2._1();
            int $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size = tuple2._2$mcI$sp();
            this.show(BoxesRunTime.boxToInteger($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size), Predef$.MODULE$.genericWrapArray(new Object[]{showFn.apply($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k)}));
            showMapFreq_foreach_these = (List)((AbstractTraversable)showMapFreq_foreach_these).tail();
        }
        Predef$.MODULE$.println("\n");
    }

    public static /* synthetic */ void showAllSymbols$(TraceSymbolActivity $this) {
        $this.showAllSymbols();
    }

    /*
     * WARNING - void declaration
     */
    default public void showAllSymbols() {
        if (!this.scala$reflect$internal$util$TraceSymbolActivity$$enabled()) {
            return;
        }
        this.scala$reflect$internal$util$TraceSymbolActivity$$enabled_$eq(false);
        this.allSymbols().update(BoxesRunTime.boxToInteger(1), this.global().NoSymbol());
        Predef$.MODULE$.println(new StringBuilder(17).append(this.allSymbols().size()).append(" symbols created.").toString());
        Predef$.MODULE$.println("");
        this.showHeader("descendants", Predef$.MODULE$.genericWrapArray(new Object[]{"symbol"}));
        Function1<Object, String> & java.io.Serializable & Serializable intersect = (Function1<Object, String> & java.io.Serializable & Serializable)id -> this.symbolStr(BoxesRunTime.unboxToInt(id));
        Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable showFreq_groupFn = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$9 -> BoxesRunTime.boxToInteger(x$9.id());
        Object object = ((List)((Traversable)this.allSymbols().values().flatMap((Function1<Symbols.Symbol, List> & java.io.Serializable & Serializable)x$8 -> x$8.ownerChain().drop(1), Iterable$.MODULE$.canBuildFrom())).toList().groupBy(showFreq_groupFn).mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToInteger(x$6.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$showMapFreq$2(x$7)), (Ordering)Ordering$Int$.MODULE$)).take(100);
        if (object == null) {
            throw null;
        }
        Object showFreq_showMapFreq_foreach_these = object;
        while (!((List)showFreq_showMapFreq_foreach_these).isEmpty()) {
            void showFreq_showFn;
            Tuple2 tuple2 = (Tuple2)((List)showFreq_showMapFreq_foreach_these).head();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Object $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k = tuple2._1();
            int $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size = tuple2._2$mcI$sp();
            this.show(BoxesRunTime.boxToInteger($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size), Predef$.MODULE$.genericWrapArray(new Object[]{showFreq_showFn.apply($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k)}));
            showFreq_showMapFreq_foreach_these = (List)((AbstractTraversable)showFreq_showMapFreq_foreach_these).tail();
        }
        Predef$.MODULE$.println("\n");
        this.showHeader("children", Predef$.MODULE$.genericWrapArray(new Object[]{"symbol"}));
        Function1<Object, String> & java.io.Serializable & Serializable showMapFreq_showFn = (Function1<Object, String> & java.io.Serializable & Serializable)id -> this.symbolStr(BoxesRunTime.unboxToInt(id));
        Object object2 = ((List)this.allChildren().mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToInteger(x$6.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$showMapFreq$2(x$7)), (Ordering)Ordering$Int$.MODULE$)).take(100);
        if (object2 == null) {
            throw null;
        }
        Object showMapFreq_foreach_these = object2;
        while (!((List)showMapFreq_foreach_these).isEmpty()) {
            Tuple2 tuple2 = (Tuple2)((List)showMapFreq_foreach_these).head();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Object $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k = tuple2._1();
            int $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size = tuple2._2$mcI$sp();
            this.show(BoxesRunTime.boxToInteger($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size), Predef$.MODULE$.genericWrapArray(new Object[]{showMapFreq_showFn.apply($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k)}));
            showMapFreq_foreach_these = (List)((AbstractTraversable)showMapFreq_foreach_these).tail();
        }
        Predef$.MODULE$.println("\n");
        if (this.prevOwners().nonEmpty()) {
            this.showHeader("prev owners", Predef$.MODULE$.genericWrapArray(new Object[]{"symbol"}));
            Function1<Object, String> & java.io.Serializable & Serializable showMapFreq_showFn2 = (Function1<Object, String> & java.io.Serializable & Serializable)k -> TraceSymbolActivity.$anonfun$showAllSymbols$5(this, BoxesRunTime.unboxToInt(k));
            Object object3 = ((List)this.prevOwners().mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToInteger(x$6.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$showMapFreq$2(x$7)), (Ordering)Ordering$Int$.MODULE$)).take(100);
            if (object3 == null) {
                throw null;
            }
            Object showMapFreq_foreach_these2 = object3;
            while (!((List)showMapFreq_foreach_these2).isEmpty()) {
                Tuple2 tuple2 = (Tuple2)((List)showMapFreq_foreach_these2).head();
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                Object $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k = tuple2._1();
                int $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size = tuple2._2$mcI$sp();
                this.show(BoxesRunTime.boxToInteger($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size), Predef$.MODULE$.genericWrapArray(new Object[]{showMapFreq_showFn2.apply($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k)}));
                showMapFreq_foreach_these2 = (List)((AbstractTraversable)showMapFreq_foreach_these2).tail();
            }
            Predef$.MODULE$.println("\n");
        }
        GenMap nameFreq = this.allSymbols().values().toList().groupBy((Function1<Symbols.Symbol, Names.Name> & java.io.Serializable & Serializable)x$12 -> x$12.name());
        Object[] objectArray = new Object[2];
        String string = "%-15s";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        objectArray[0] = new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{"name"}));
        objectArray[1] = "owners";
        this.showHeader("frequency", Predef$.MODULE$.genericWrapArray(objectArray));
        Function1<Names.Name, String> & java.io.Serializable & Serializable showMapFreq_showFn3 = arg_0 -> TraceSymbolActivity.$anonfun$showAllSymbols$8(this, (scala.collection.immutable.Map)nameFreq, arg_0);
        Object object4 = ((List)nameFreq.mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToInteger(x$6.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$showMapFreq$2(x$7)), (Ordering)Ordering$Int$.MODULE$)).take(100);
        if (object4 == null) {
            throw null;
        }
        Object showMapFreq_foreach_these3 = object4;
        while (!((List)showMapFreq_foreach_these3).isEmpty()) {
            Tuple2 tuple2 = (Tuple2)((List)showMapFreq_foreach_these3).head();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Object $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k = tuple2._1();
            int $anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size = tuple2._2$mcI$sp();
            this.show(BoxesRunTime.boxToInteger($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_size), Predef$.MODULE$.genericWrapArray(new Object[]{showMapFreq_showFn3.apply($anonfun$showMapFreq$3$adapted_$anonfun$showMapFreq$3_k)}));
            showMapFreq_foreach_these3 = (List)((AbstractTraversable)showMapFreq_foreach_these3).tail();
        }
        Predef$.MODULE$.println("\n");
        List list = (List)this.allSymbols().keys().toList().sorted((Ordering)Ordering$Int$.MODULE$);
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            int n = BoxesRunTime.unboxToInt(foreach_these.head());
            this.showIdAndRemove(n);
            foreach_these = (List)foreach_these.tail();
        }
    }

    public static /* synthetic */ String $anonfun$signature$1(TraceSymbolActivity $this, int id$1) {
        return ((Symbols.Symbol)$this.allSymbols().apply(BoxesRunTime.boxToInteger(id$1))).defString();
    }

    public static /* synthetic */ char $anonfun$dashes$1(char x$2) {
        return '-';
    }

    private static String prefix$1(Symbols.Symbol sym$1) {
        String string = "  ";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringBuilder(0).append(new StringOps(string).$times(sym$1.ownerChain().length() - 1)).append(sym$1.id()).toString();
    }

    public static /* synthetic */ int $anonfun$freq$2(Tuple2 x$5) {
        return -x$5._2$mcI$sp();
    }

    public static /* synthetic */ int $anonfun$showMapFreq$2(Tuple2 x$7) {
        return -x$7._2$mcI$sp();
    }

    public static /* synthetic */ void $anonfun$showMapFreq$3(TraceSymbolActivity $this, Function1 showFn$1, Tuple2 x0$1) {
        if (x0$1 != null) {
            Object k = x0$1._1();
            int size = x0$1._2$mcI$sp();
            $this.show(BoxesRunTime.boxToInteger(size), Predef$.MODULE$.genericWrapArray(new Object[]{showFn$1.apply(k)}));
            return;
        }
        throw new MatchError((Object)null);
    }

    public static /* synthetic */ String $anonfun$showAllSymbols$5(TraceSymbolActivity $this, int k) {
        Tuple2<Integer, NoPhase$> tuple2 = new Tuple2<Integer, NoPhase$>(BoxesRunTime.boxToInteger(((Symbols.Symbol)$this.allSymbols().apply(BoxesRunTime.boxToInteger(k))).owner().id()), NoPhase$.MODULE$);
        List owners = ((List)$this.prevOwners().apply(BoxesRunTime.boxToInteger(k))).$colon$colon(tuple2).map((Function1<Tuple2, String> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 != null) {
                int oid = x0$1._1$mcI$sp();
                Phase phase = (Phase)x0$1._2();
                if (((Object)NoPhase$.MODULE$).equals(phase)) {
                    return new StringBuilder(12).append("-> owned by ").append($this.ownerStr(oid)).toString();
                }
            }
            if (x0$1 == null) throw new MatchError((Object)null);
            int oid = x0$1._1$mcI$sp();
            Phase ph = (Phase)x0$1._2();
            String string = "-> owned by %s (until %s)";
            if (Predef$.MODULE$ != null) return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{$this.ownerStr(oid), ph}));
            throw null;
        }, List$.MODULE$.canBuildFrom());
        String string = $this.signature(k);
        return owners.$colon$colon(string).mkString("\n                ");
    }

    public static /* synthetic */ String $anonfun$showAllSymbols$8(TraceSymbolActivity $this, scala.collection.immutable.Map nameFreq$1, Names.Name name) {
        String string = "%-15s %s";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = name.decode();
        List list = (List)((Traversable)nameFreq$1.apply(name)).groupBy((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)x$13 -> x$13.owner()).mapValues((Function1<Traversable, Object> & java.io.Serializable & Serializable)x$4 -> BoxesRunTime.boxToInteger(x$4.size())).toList().sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$5 -> BoxesRunTime.boxToInteger(TraceSymbolActivity.$anonfun$freq$2(x$5)), (Ordering)Ordering$Int$.MODULE$);
        String string2 = "%4s owners (%s)";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        objectArray[1] = new StringOps(string2).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(list.size()), new StringBuilder(5).append(((TraversableOnce)((List)list.take(3)).map((Function1<Tuple2, String> & java.io.Serializable & Serializable)x0$2 -> {
            if (x0$2 == null) {
                throw new MatchError((Object)null);
            }
            Symbols.Symbol k = (Symbols.Symbol)x0$2._1();
            int v = x0$2._2$mcI$sp();
            String string = new StringBuilder(1).append(v).append("/").append(k).toString();
            return string;
        }, List$.MODULE$.canBuildFrom())).mkString(", ")).append(", ...").toString()}));
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(objectArray));
    }

    /*
     * WARNING - void declaration
     */
    public static void $init$(TraceSymbolActivity $this) {
        $this.scala$reflect$internal$util$TraceSymbolActivity$$enabled_$eq($this.global().traceSymbolActivity());
        if ($this.scala$reflect$internal$util$TraceSymbolActivity$$enabled() && $this.global().isCompilerUniverse()) {
            void addShutdownHook_body;
            JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> $this.showAllSymbols();
            if (package$.MODULE$ == null) {
                throw null;
            }
            if (ShutdownHookThread$.MODULE$ == null) {
                throw null;
            }
            ShutdownHookThread addShutdownHook_apply_t = new ShutdownHookThread((Function0)addShutdownHook_body){
                private final Function0 body$1;

                public void run() {
                    this.body$1.apply$mcV$sp();
                }
                {
                    this.body$1 = body$1;
                    super(ShutdownHookThread$.MODULE$.scala$sys$ShutdownHookThread$$hookName());
                }
            };
            package$.MODULE$.runtime().addShutdownHook(addShutdownHook_apply_t);
        }
        $this.scala$reflect$internal$util$TraceSymbolActivity$_setter_$allSymbols_$eq((scala.collection.mutable.Map)Map$.MODULE$.apply(Nil$.MODULE$));
        $this.scala$reflect$internal$util$TraceSymbolActivity$_setter_$allChildren_$eq(((scala.collection.mutable.Map)Map$.MODULE$.apply(Nil$.MODULE$)).withDefaultValue(Nil$.MODULE$));
        $this.scala$reflect$internal$util$TraceSymbolActivity$_setter_$prevOwners_$eq(((scala.collection.mutable.Map)Map$.MODULE$.apply(Nil$.MODULE$)).withDefaultValue(Nil$.MODULE$));
        $this.scala$reflect$internal$util$TraceSymbolActivity$_setter_$allTrees_$eq((Set)Set$.MODULE$.apply(Nil$.MODULE$));
    }

    public static /* synthetic */ Object $anonfun$showIdAndRemove$1$adapted(TraceSymbolActivity $this, Symbols.Symbol sym) {
        $this.showSym(sym);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$showMapFreq$3$adapted(TraceSymbolActivity $this, Function1 showFn$1, Tuple2 x0$1) {
        if (x0$1 == null) {
            throw new MatchError((Object)null);
        }
        Object $anonfun$showMapFreq$3_k = x0$1._1();
        int $anonfun$showMapFreq$3_size = x0$1._2$mcI$sp();
        $this.show(BoxesRunTime.boxToInteger($anonfun$showMapFreq$3_size), Predef$.MODULE$.genericWrapArray(new Object[]{showFn$1.apply($anonfun$showMapFreq$3_k)}));
        return BoxedUnit.UNIT;
    }
}

