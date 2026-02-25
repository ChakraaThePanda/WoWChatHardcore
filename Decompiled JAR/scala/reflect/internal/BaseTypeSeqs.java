/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterator;
import scala.collection.TraversableLike;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.BitSet;
import scala.collection.mutable.ListBuffer;
import scala.math.Ordering$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.BaseTypeSeqsStats;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Depth;
import scala.reflect.internal.Depth$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.util.Statistics;
import scala.reflect.internal.util.StatisticsStatics;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0005=h!C\u00181!\u0003\r\taNAu\u0011\u0015a\u0004\u0001\"\u0001>\u0011\u0015\t\u0005\u0001\"\u0005C\u0011\u001d\t\u0019\n\u0001C\t\u0003+3A!\u0012\u0001\u0001\r\"Iq\t\u0002B\u0003\u0002\u0003\u0006I\u0001\u0013\u0005\n)\u0012\u0011)\u0011!Q\u0001\nUCa\u0001\u0017\u0003\u0005\u0012IJ\u0006B\u00020\u0005A\u0003%q\fC\u0003d\t\u0011\u0005A\rC\u0004f\t\t\u0007I\u0011\u00024\t\r=$\u0001\u0015!\u0003h\u0011\u0015\u0001H\u0001\"\u0001r\u0011\u0015!H\u0001\"\u0001v\u0011\u00159H\u0001\"\u0001y\u0011\u0019yH\u0001\"\u0002\u0002\u0002!9\u0011q\u0001\u0003\u0005\u0002\u0005%\u0001bBA\u0006\t\u0011\u0005\u0011Q\u0002\u0005\b\u0003+!A\u0011AA\f\u0011\u001d\t\t\u0003\u0002C\u0001\u0003GAq!!\u000b\u0005\t\u0003\tY\u0003C\u0004\u00020\u0011!\t!!\r\t\u000f\u0005uB\u0001\"\u0001\u0002@!9\u00111\t\u0003\u0005\u0002\u0005\u0015\u0003BCA*\t!\u0015\r\u0011\"\u0001\u0002V!9\u0011q\f\u0003\u0005\u0012\u0005U\u0003bBA1\t\u0011\u0005\u00131\r\u0005\b\u0003w\"A\u0011BA?\u00111\tI\t\u0002B\u0003\u0006\u0004%\t\u0001AA\u0005\u00111\tY\t\u0002B\u0003\u0006\u0004%\t\u0001AAG\u0011)\t)\r\u0001EC\u0002\u0013\u0005\u0011q\u0019\u0005\b\u0003\u0013\u0004A\u0011AAf\u0011\u001d\ty\r\u0001C\u0001\u0003#4a!!'\u0001\u0001\u0005m\u0005\"CAOC\t\u0005\t\u0015!\u0003D\u0011)\t)$\tB\u0001B\u0003%\u0011q\u0007\u0005\u00071\u0006\"\t!a(\t\rA\fC\u0011IAS\u0011\u0019!\u0018\u0005\"\u0011\u0002*\"9\u0011qA\u0011\u0005B\u0005%\u0001bBA\u000bC\u0011\u0005\u0013Q\u0016\u0005\b\u0003_\tC\u0011IAZ\u0011\u001d\ti$\tC!\u0003sCq!a\u0011\"\t\u0003\ni\fC\u0004\u0002`\u0005\"\t&!\u0016\t\u000f\u0005\u0005\u0014\u0005\"\u0011\u0002d!I\u0011Q\u001b\u0001C\u0002\u0013\u0005\u0011q\u001b\u0002\r\u0005\u0006\u001cX\rV=qKN+\u0017o\u001d\u0006\u0003cI\n\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0003gQ\nqA]3gY\u0016\u001cGOC\u00016\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001\u0001\u001d\u0011\u0005eRT\"\u0001\u001b\n\u0005m\"$AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0002}A\u0011\u0011hP\u0005\u0003\u0001R\u0012A!\u00168ji\u0006qa.Z<CCN,G+\u001f9f'\u0016\fH#B\"\u0002\u0010\u0006E\u0005C\u0001#\u0005\u001b\u0005\u0001!a\u0003\"bg\u0016$\u0016\u0010]3TKF\u001c\"\u0001\u0002\u001d\u0002[M\u001c\u0017\r\\1%e\u00164G.Z2uI%tG/\u001a:oC2$#)Y:f)f\u0004XmU3rg\u0012\"\u0003/\u0019:f]R\u001c\b\u0005E\u0002J\u0019>s!!\u000f&\n\u0005-#\u0014a\u00029bG.\fw-Z\u0005\u0003\u001b:\u0013A\u0001T5ti*\u00111\n\u000e\t\u0003\tBK!!\u0015*\u0003\tQK\b/Z\u0005\u0003'B\u0012Q\u0001V=qKN\f1f]2bY\u0006$#/\u001a4mK\u000e$H%\u001b8uKJt\u0017\r\u001c\u0013CCN,G+\u001f9f'\u0016\f8\u000f\n\u0013fY\u0016l7\u000f\t\t\u0004sY{\u0015BA,5\u0005\u0015\t%O]1z\u0003\u0019a\u0014N\\5u}Q\u00191I\u0017/\t\u000bm;\u0001\u0019\u0001%\u0002\u000fA\f'/\u001a8ug\")Ql\u0002a\u0001+\u0006)Q\r\\3ng\u0006YA/\u001f9f'fl'm\u001c7t!\rId\u000b\u0019\t\u0003s\u0005L!A\u0019\u001b\u0003\u0007%sG/\u0001\u0004mK:<G\u000f[\u000b\u0002A\u00069\u0001/\u001a8eS:<W#A4\u0011\u0005!lW\"A5\u000b\u0005)\\\u0017aB7vi\u0006\u0014G.\u001a\u0006\u0003YR\n!bY8mY\u0016\u001cG/[8o\u0013\tq\u0017N\u0001\u0004CSR\u001cV\r^\u0001\ta\u0016tG-\u001b8hA\u0005)\u0011\r\u001d9msR\u0011qJ\u001d\u0005\u0006g2\u0001\r\u0001Y\u0001\u0002S\u00069!/Y<FY\u0016lGCA(w\u0011\u0015\u0019X\u00021\u0001a\u0003)!\u0018\u0010]3Ts6\u0014w\u000e\u001c\u000b\u0003sz\u0004\"\u0001\u0012>\n\u0005md(AB*z[\n|G.\u0003\u0002~a\t91+_7c_2\u001c\b\"B:\u000f\u0001\u0004\u0001\u0017!\u00042bg\u0016$\u0016\u0010]3J]\u0012,\u0007\u0010F\u0002a\u0003\u0007Aa!!\u0002\u0010\u0001\u0004I\u0018aA:z[\u00061Ao\u001c'jgR,\u0012\u0001S\u0001\u000bi>LE/\u001a:bi>\u0014XCAA\b!\u0011I\u0015\u0011C(\n\u0007\u0005MaJ\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u0011\u0019w\u000e]=\u0015\u000b\r\u000bI\"!\b\t\r\u0005m!\u00031\u0001P\u0003\u0011AW-\u00193\t\r\u0005}!\u00031\u0001a\u0003\u0019ygMZ:fi\u00069\u0001O]3qK:$GcA\"\u0002&!1\u0011qE\nA\u0002=\u000b!\u0001\u001e9\u0002\u0015U\u0004H-\u0019;f\u0011\u0016\fG\rF\u0002D\u0003[Aa!a\n\u0015\u0001\u0004y\u0015aA7baR\u00191)a\r\t\u000f\u0005UR\u00031\u0001\u00028\u0005\ta\rE\u0003:\u0003syu*C\u0002\u0002<Q\u0012\u0011BR;oGRLwN\\\u0019\u0002\u000f1\fG/Z'baR\u00191)!\u0011\t\u000f\u0005Ub\u00031\u0001\u00028\u00051Q\r_5tiN$B!a\u0012\u0002NA\u0019\u0011(!\u0013\n\u0007\u0005-CGA\u0004C_>dW-\u00198\t\u000f\u0005=s\u00031\u0001\u0002R\u0005\t\u0001\u000f\u0005\u0004:\u0003sy\u0015qI\u0001\t[\u0006DH)\u001a9uQV\u0011\u0011q\u000b\t\u0005\u00033\nY&D\u00011\u0013\r\ti\u0006\r\u0002\u0006\t\u0016\u0004H\u000f[\u0001\u0010[\u0006DH)\u001a9uQ>3W\t\\3ng\u0006AAo\\*ue&tw\r\u0006\u0002\u0002fA!\u0011qMA;\u001d\u0011\tI'!\u001d\u0011\u0007\u0005-D'\u0004\u0002\u0002n)\u0019\u0011q\u000e\u001c\u0002\rq\u0012xn\u001c;?\u0013\r\t\u0019\bN\u0001\u0007!J,G-\u001a4\n\t\u0005]\u0014\u0011\u0010\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005MD'A\u0005usB,WI\u001d:peR!\u0011qPAC!\rI\u0014\u0011Q\u0005\u0004\u0003\u0007#$a\u0002(pi\"Lgn\u001a\u0005\b\u0003\u000f[\u0002\u0019AA3\u0003\ri7oZ\u0001-g\u000e\fG.\u0019\u0013sK\u001adWm\u0019;%S:$XM\u001d8bY\u0012\u0012\u0015m]3UsB,7+Z9tI\u0011\u0002\u0018M]3oiN\f!f]2bY\u0006$#/\u001a4mK\u000e$H%\u001b8uKJt\u0017\r\u001c\u0013CCN,G+\u001f9f'\u0016\f8\u000f\n\u0013fY\u0016l7/F\u0001V\u0011\u0015Y&\u00011\u0001I\u0011\u0015i&\u00011\u0001V\u0003QqWm^'baB,GMQ1tKRK\b/Z*fcR1\u0011qSAa\u0003\u0007\u0004\"\u0001R\u0011\u0003#5\u000b\u0007\u000f]3e\u0005\u0006\u001cX\rV=qKN+\u0017o\u0005\u0002\"\u0007\u0006!qN]5h)\u0019\t9*!)\u0002$\"1\u0011Q\u0014\u0013A\u0002\rCq!!\u000e%\u0001\u0004\t9\u0004F\u0002P\u0003OCQa]\u0013A\u0002\u0001$2aTAV\u0011\u0015\u0019h\u00051\u0001a)\u0015\u0019\u0015qVAY\u0011\u0019\tY\u0002\u000ba\u0001\u001f\"1\u0011q\u0004\u0015A\u0002\u0001$2aQA[\u0011\u001d\t9,\u000ba\u0001\u0003o\t\u0011a\u001a\u000b\u0004\u0007\u0006m\u0006bBA\\U\u0001\u0007\u0011q\u0007\u000b\u0005\u0003\u000f\ny\fC\u0004\u0002P-\u0002\r!!\u0015\t\r\u0005u5\u00011\u0001D\u0011\u001d\t)d\u0001a\u0001\u0003o\t\u0001#\u001e8eKR\u0014\u0015m]3UsB,7+Z9\u0016\u0003\r\u000bACY1tKRK\b/Z*j]\u001edW\r^8o'\u0016\fHcA\"\u0002N\"1\u0011qE\u0010A\u0002=\u000b1cY8na>,h\u000e\u001a\"bg\u0016$\u0016\u0010]3TKF$2aQAj\u0011\u0019\t9\u0003\ta\u0001\u001f\u0006\t2)_2mS\u000eLe\u000e[3sSR\fgnY3\u0016\u0005\u0005e\u0007\u0003BAn\u0003Kl!!!8\u000b\t\u0005}\u0017\u0011]\u0001\u0005Y\u0006twM\u0003\u0002\u0002d\u0006!!.\u0019<b\u0013\u0011\t9/!8\u0003\u0013QC'o\\<bE2,\u0007\u0003BA-\u0003WL1!!<1\u0005-\u0019\u00160\u001c2pYR\u000b'\r\\3")
public interface BaseTypeSeqs {
    public void scala$reflect$internal$BaseTypeSeqs$_setter_$CyclicInheritance_$eq(Throwable var1);

    public static /* synthetic */ BaseTypeSeq newBaseTypeSeq$(BaseTypeSeqs $this, List parents, Types.Type[] elems) {
        return $this.newBaseTypeSeq(parents, elems);
    }

    default public BaseTypeSeq newBaseTypeSeq(List<Types.Type> parents, Types.Type[] elems) {
        return new BaseTypeSeq((SymbolTable)this, parents, elems);
    }

    public static /* synthetic */ MappedBaseTypeSeq newMappedBaseTypeSeq$(BaseTypeSeqs $this, BaseTypeSeq orig, Function1 f) {
        return $this.newMappedBaseTypeSeq(orig, f);
    }

    default public MappedBaseTypeSeq newMappedBaseTypeSeq(BaseTypeSeq orig, Function1<Types.Type, Types.Type> f) {
        return new MappedBaseTypeSeq((SymbolTable)this, orig, f);
    }

    public static /* synthetic */ BaseTypeSeq undetBaseTypeSeq$(BaseTypeSeqs $this) {
        return $this.undetBaseTypeSeq();
    }

    default public BaseTypeSeq undetBaseTypeSeq() {
        return this.newBaseTypeSeq(Nil$.MODULE$, (Types.Type[])Array$.MODULE$.apply(Nil$.MODULE$, ((Types)((Object)this)).TypeTagg()));
    }

    public static /* synthetic */ BaseTypeSeq baseTypeSingletonSeq$(BaseTypeSeqs $this, Types.Type tp) {
        return $this.baseTypeSingletonSeq(tp);
    }

    default public BaseTypeSeq baseTypeSingletonSeq(Types.Type tp) {
        return this.newBaseTypeSeq(Nil$.MODULE$, (Types.Type[])((Object[])new Types.Type[]{tp}));
    }

    public static /* synthetic */ BaseTypeSeq compoundBaseTypeSeq$(BaseTypeSeqs $this, Types.Type tp) {
        return $this.compoundBaseTypeSeq(tp);
    }

    default public BaseTypeSeq compoundBaseTypeSeq(Types.Type tp) {
        Symbols.Symbol tsym = tp.typeSymbol();
        List parents = tp.parents();
        ListBuffer buf = new ListBuffer();
        buf.$plus$eq(tsym.tpe_$times());
        int btsSize = 1;
        if (parents.nonEmpty()) {
            int nparents = parents.length();
            BaseTypeSeq[] pbtss = new BaseTypeSeq[nparents];
            int[] index = new int[nparents];
            IntRef i = IntRef.create(0);
            List foreach_these = parents;
            while (!foreach_these.isEmpty()) {
                Types.Type type = foreach_these.head();
                BaseTypeSeqs.$anonfun$compoundBaseTypeSeq$1(this, pbtss, i, index, type);
                foreach_these = (List)foreach_these.tail();
            }
            Symbols.Symbol minSym = ((Symbols)((Object)this)).NoSymbol();
            while (true) {
                Symbols.NoSymbol noSymbol = minSym;
                Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().AnyClass();
                if (!(noSymbol == null ? classSymbol != null : !noSymbol.equals(classSymbol))) break;
                minSym = this.nextTypeSymbol$1(0, index, pbtss);
                i.elem = 1;
                while (i.elem < nparents) {
                    Symbols.Symbol nextSym = this.nextTypeSymbol$1(i.elem, index, pbtss);
                    if (nextSym.isLess(minSym)) {
                        minSym = nextSym;
                    }
                    ++i.elem;
                }
                ObjectRef<Nil$> minTypes = ObjectRef.create(Nil$.MODULE$);
                i.elem = 0;
                while (i.elem < nparents) {
                    Symbols.Symbol symbol = this.nextTypeSymbol$1(i.elem, index, pbtss);
                    if (!(symbol != null ? !symbol.equals(minSym) : minSym != null)) {
                        Types.Type type = this.nextRawElem$1(i.elem, index, pbtss);
                        if (type instanceof Types.RefinedType) {
                            List variants = ((Types.RefinedType)type).parents();
                            if (variants == null) {
                                throw null;
                            }
                            List foreach_these2 = variants;
                            while (!foreach_these2.isEmpty()) {
                                Types.Type type2 = foreach_these2.head();
                                BaseTypeSeqs.$anonfun$compoundBaseTypeSeq$2(this, minTypes, type2);
                                foreach_these2 = (List)foreach_these2.tail();
                            }
                        } else if (!this.alreadyInMinTypes$1(type, minTypes)) {
                            minTypes.elem = ((List)minTypes.elem).$colon$colon(type);
                        }
                        index[i.elem] = index[i.elem] + 1;
                    }
                    ++i.elem;
                }
                buf.$plus$eq(((Types)((Object)this)).intersectionTypeForLazyBaseType((List)minTypes.elem));
                ++btsSize;
            }
        }
        Types.Type[] elems = new Types.Type[btsSize];
        buf.copyToArray(elems, 0);
        return this.newBaseTypeSeq(parents, elems);
    }

    public Throwable CyclicInheritance();

    public static /* synthetic */ void $anonfun$compoundBaseTypeSeq$1(BaseTypeSeqs $this, BaseTypeSeq[] pbtss$1, IntRef i$2, int[] index$1, Types.Type p) {
        BaseTypeSeq parentBts = p.dealias().baseTypeSeq();
        pbtss$1[i$2.elem] = parentBts == $this.undetBaseTypeSeq() ? ((Definitions)((Object)$this)).definitions().AnyClass().info().baseTypeSeq() : parentBts;
        index$1[i$2.elem] = 0;
        ++i$2.elem;
    }

    private Symbols.Symbol nextTypeSymbol$1(int i, int[] index$1, BaseTypeSeq[] pbtss$1) {
        int j = index$1[i];
        BaseTypeSeq pbts = pbtss$1[i];
        if (j < pbts.length()) {
            return pbts.typeSymbol(j);
        }
        return ((Definitions)((Object)this)).definitions().AnyClass();
    }

    private Types.Type nextRawElem$1(int i, int[] index$1, BaseTypeSeq[] pbtss$1) {
        int j = index$1[i];
        BaseTypeSeq pbts = pbtss$1[i];
        if (j < pbts.length()) {
            return pbts.rawElem(j);
        }
        return ((Definitions)((Object)this)).definitions().AnyTpe();
    }

    private boolean loop$1(List tps, Types.Type tp$1) {
        boolean bl;
        block2: {
            block3: {
                while (true) {
                    if (((Object)Nil$.MODULE$).equals(tps)) {
                        bl = false;
                        break block2;
                    }
                    if (!(tps instanceof $colon$colon)) break block3;
                    $colon$colon $colon$colon = ($colon$colon)tps;
                    Types.Type x = (Types.Type)$colon$colon.head();
                    List xs = $colon$colon.tl$access$1();
                    if (tp$1.$eq$colon$eq(x)) break;
                    tps = xs;
                    BaseTypeSeqs this_ = (SymbolTable)this_;
                }
                bl = true;
                break block2;
            }
            throw new MatchError(tps);
        }
        return bl;
    }

    private boolean alreadyInMinTypes$1(Types.Type tp, ObjectRef minTypes$1) {
        return this.loop$1((List)minTypes$1.elem, tp);
    }

    public static /* synthetic */ void $anonfun$compoundBaseTypeSeq$2(BaseTypeSeqs $this, ObjectRef minTypes$1, Types.Type tp) {
        if (!$this.alreadyInMinTypes$1(tp, minTypes$1)) {
            minTypes$1.elem = ((List)minTypes$1.elem).$colon$colon(tp);
        }
    }

    public static void $init$(BaseTypeSeqs $this) {
        $this.scala$reflect$internal$BaseTypeSeqs$_setter_$CyclicInheritance_$eq(new Throwable());
    }

    public static /* synthetic */ Object $anonfun$compoundBaseTypeSeq$1$adapted(BaseTypeSeqs $this, BaseTypeSeq[] pbtss$1, IntRef i$2, int[] index$1, Types.Type p) {
        BaseTypeSeqs.$anonfun$compoundBaseTypeSeq$1($this, pbtss$1, i$2, index$1, p);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$compoundBaseTypeSeq$2$adapted(BaseTypeSeqs $this, ObjectRef minTypes$1, Types.Type tp) {
        BaseTypeSeqs.$anonfun$compoundBaseTypeSeq$2($this, minTypes$1, tp);
        return BoxedUnit.UNIT;
    }

    public class BaseTypeSeq {
        private int maxDepth;
        private final List<Types.Type> scala$reflect$internal$BaseTypeSeqs$$parents;
        private final Types.Type[] scala$reflect$internal$BaseTypeSeqs$$elems;
        private final int[] typeSymbols;
        private final BitSet pending;
        private volatile boolean bitmap$0;
        public final /* synthetic */ SymbolTable $outer;

        public List<Types.Type> scala$reflect$internal$BaseTypeSeqs$$parents() {
            return this.scala$reflect$internal$BaseTypeSeqs$$parents;
        }

        public Types.Type[] scala$reflect$internal$BaseTypeSeqs$$elems() {
            return this.scala$reflect$internal$BaseTypeSeqs$$elems;
        }

        public int length() {
            return this.scala$reflect$internal$BaseTypeSeqs$$elems().length;
        }

        private BitSet pending() {
            return this.pending;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Types.Type apply(int i) {
            if (this.pending().contains(i)) {
                this.pending().clear();
                throw this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().CyclicInheritance();
            }
            Types.Type type = this.scala$reflect$internal$BaseTypeSeqs$$elems()[i];
            if (type instanceof Types.RefinedType) {
                Types.RefinedType refinedType = (Types.RefinedType)type;
                return this.computeLazyType$1(refinedType, i);
            }
            if (!(type instanceof Types.ExistentialType)) return type;
            Types.ExistentialType existentialType = (Types.ExistentialType)type;
            List<Symbols.Symbol> quantified = existentialType.quantified();
            Types.Type rtp = existentialType.underlying();
            if (!(rtp instanceof Types.RefinedType)) return type;
            Types.RefinedType refinedType = (Types.RefinedType)rtp;
            return this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().existentialAbstraction(quantified, this.computeLazyType$1(refinedType, i));
        }

        public Types.Type rawElem(int i) {
            return this.scala$reflect$internal$BaseTypeSeqs$$elems()[i];
        }

        public Symbols.Symbol typeSymbol(int i) {
            return this.scala$reflect$internal$BaseTypeSeqs$$elems()[i].typeSymbol();
        }

        public final int baseTypeIndex(Symbols.Symbol sym) {
            int symId = sym.id();
            int len = this.length();
            for (int i = 0; i < len; ++i) {
                if (this.typeSymbols[i] != symId) continue;
                return i;
            }
            return -1;
        }

        public List<Types.Type> toList() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())).toList();
        }

        public Iterator<Types.Type> toIterator() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())).iterator();
        }

        public BaseTypeSeq copy(Types.Type head, int offset) {
            Types.Type[] arr = new Types.Type[this.scala$reflect$internal$BaseTypeSeqs$$elems().length + offset];
            System.arraycopy(this.scala$reflect$internal$BaseTypeSeqs$$elems(), 0, arr, offset, this.scala$reflect$internal$BaseTypeSeqs$$elems().length);
            arr[0] = head;
            return this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().newBaseTypeSeq(this.scala$reflect$internal$BaseTypeSeqs$$parents(), arr);
        }

        public BaseTypeSeq prepend(Types.Type tp) {
            return this.copy(tp, 1);
        }

        public BaseTypeSeq updateHead(Types.Type tp) {
            return this.copy(tp, 0);
        }

        public BaseTypeSeq map(Function1<Types.Type, Types.Type> f) {
            int len = this.length();
            Types.Type[] arr = new Types.Type[len];
            for (int i = 0; i < len; ++i) {
                arr[i] = f.apply(this.scala$reflect$internal$BaseTypeSeqs$$elems()[i]);
            }
            return this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().newBaseTypeSeq(this.scala$reflect$internal$BaseTypeSeqs$$parents(), arr);
        }

        public BaseTypeSeq lateMap(Function1<Types.Type, Types.Type> f) {
            return this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().newMappedBaseTypeSeq(this, f);
        }

        public boolean exists(Function1<Types.Type, Object> p) {
            return IndexedSeqOptimized.exists$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())), p);
        }

        private int maxDepth$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.maxDepth = this.maxDepthOfElems();
                    this.bitmap$0 = true;
                }
            }
            return this.maxDepth;
        }

        public int maxDepth() {
            if (!this.bitmap$0) {
                return this.maxDepth$lzycompute();
            }
            return this.maxDepth;
        }

        public int maxDepthOfElems() {
            IntRef d = IntRef.create(Depth$.MODULE$.Zero());
            int n = 1;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Range range = RichInt$.MODULE$.until$extension0(n, this.length());
            if (range == null) {
                throw null;
            }
            Range foreach$mVc$sp_this = range;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    d.elem = Depth$.MODULE$.max$extension(d.elem, this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().typeDepth(this.scala$reflect$internal$BaseTypeSeqs$$elems()[foreach$mVc$sp_i]));
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
            }
            return d.elem;
        }

        public String toString() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())).mkString("BTS(", ",", ")");
        }

        private Nothing$ typeError(String msg) {
            throw new Types.TypeError(this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer(), new StringBuilder(53).append("the type intersection ").append(this.scala$reflect$internal$BaseTypeSeqs$$parents().mkString(" with ")).append(" is malformed").append("\n --- because ---\n").append(msg).toString());
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$apply$1(BaseTypeSeq $this, Types.RefinedType rtp$1) {
            return !$this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().isIntersectionTypeForLazyBaseType(rtp$1);
        }

        /*
         * WARNING - void declaration
         */
        private final Types.Type computeLazyType$1(Types.RefinedType rtp, int i$1) {
            SymbolTable symbolTable = this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer();
            Function0<String> & java.io.Serializable & Serializable intersect = (Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(114).append("unexpected RefinedType in base type seq, lazy BTS elements should be created via intersectionTypeForLazyBaseType: ").append(rtp).toString();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable devWarningIf_this = symbolTable;
            if (devWarningIf_this.isDeveloper() && BaseTypeSeq.$anonfun$apply$1(this, rtp)) {
                void devWarningIf_msg;
                devWarningIf_this.devWarning((Function0<String>)devWarningIf_msg);
            }
            List<Types.Type> variants = rtp.parents();
            this.pending().$plus$eq(i$1);
            try {
                Types.Type type = this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().mergePrefixAndArgs(variants, Variance$.MODULE$.Contravariant(), this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().lubDepth(variants));
                if (this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().NoType().equals(type)) {
                    throw this.typeError(new StringBuilder(46).append("no common type instance of base types ").append(variants.mkString(", and ")).append(" exists.").toString());
                }
                this.pending().update(BoxesRunTime.boxToInteger(i$1), false);
                this.scala$reflect$internal$BaseTypeSeqs$$elems()[i$1] = type;
                return type;
            }
            catch (Throwable throwable) {
                Throwable throwable2 = this.scala$reflect$internal$BaseTypeSeqs$BaseTypeSeq$$$outer().CyclicInheritance();
                if (!(throwable2 != null ? !throwable2.equals(throwable) : throwable != null)) {
                    throw this.typeError(new StringBuilder(67).append("computing the common type instance of base types ").append(variants.mkString(", and ")).append(" leads to a cycle.").toString());
                }
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public BaseTypeSeq(SymbolTable $outer, List<Types.Type> parents, Types.Type[] elems) {
            this.scala$reflect$internal$BaseTypeSeqs$$parents = parents;
            this.scala$reflect$internal$BaseTypeSeqs$$elems = elems;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void incCounter_c;
                Statistics statistics = $outer.statistics();
                Statistics.Counter counter = ((BaseTypeSeqsStats)((Object)$outer.statistics())).baseTypeSeqCount();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                }
            }
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void incCounter_c;
                Statistics statistics = $outer.statistics();
                int n = elems.length;
                Statistics.Counter counter = ((BaseTypeSeqsStats)((Object)$outer.statistics())).baseTypeSeqLenTotal();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    void incCounter_delta;
                    incCounter_c.value_$eq(incCounter_c.value() + incCounter_delta);
                }
            }
            int[] tmp = new int[elems.length];
            for (int i = 0; i < elems.length; ++i) {
                tmp[i] = elems[i].typeSymbol().id();
            }
            this.typeSymbols = tmp;
            this.pending = new BitSet(this.length());
        }
    }

    public class MappedBaseTypeSeq
    extends BaseTypeSeq {
        private final BaseTypeSeq orig;
        private final Function1<Types.Type, Types.Type> f;

        @Override
        public Types.Type apply(int i) {
            return this.f.apply(this.orig.apply(i));
        }

        @Override
        public Types.Type rawElem(int i) {
            return this.f.apply(this.orig.rawElem(i));
        }

        @Override
        public List<Types.Type> toList() {
            return this.orig.toList().map(this.f, List$.MODULE$.canBuildFrom());
        }

        @Override
        public BaseTypeSeq copy(Types.Type head, int offset) {
            return this.orig.map(this.f).copy(head, offset);
        }

        @Override
        public BaseTypeSeq map(Function1<Types.Type, Types.Type> g) {
            return this.lateMap(g);
        }

        @Override
        public BaseTypeSeq lateMap(Function1<Types.Type, Types.Type> g) {
            return this.orig.lateMap((Function1<Types.Type, Types.Type> & java.io.Serializable & Serializable)x -> (Types.Type)g.apply($this.f.apply((Types.Type)x)));
        }

        @Override
        public boolean exists(Function1<Types.Type, Object> p) {
            return IndexedSeqOptimized.exists$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())), (Function1<Types.Type, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(BoxesRunTime.unboxToBoolean(p.apply($this.f.apply((Types.Type)x)))));
        }

        @Override
        public int maxDepthOfElems() {
            return ((Depth)Predef$.MODULE$.genericArrayOps(TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())), (Function1<Types.Type, Object> & java.io.Serializable & Serializable)x -> new Depth(MappedBaseTypeSeq.$anonfun$maxDepthOfElems$2(this, x)), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(Depth.class)))).max(Ordering$.MODULE$.ordered(Predef$.MODULE$.$conforms()))).depth();
        }

        @Override
        public String toString() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$BaseTypeSeqs$$elems())).mkString("MBTS(", ",", ")");
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$BaseTypeSeqs$MappedBaseTypeSeq$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$exists$1(MappedBaseTypeSeq $this, Function1 p$1, Types.Type x) {
            return BoxesRunTime.unboxToBoolean(p$1.apply($this.f.apply(x)));
        }

        public static final /* synthetic */ int $anonfun$maxDepthOfElems$2(MappedBaseTypeSeq $this, Types.Type x) {
            return $this.scala$reflect$internal$BaseTypeSeqs$MappedBaseTypeSeq$$$outer().typeDepth($this.f.apply(x));
        }

        public MappedBaseTypeSeq(SymbolTable $outer, BaseTypeSeq orig, Function1<Types.Type, Types.Type> f) {
            this.orig = orig;
            this.f = f;
            super($outer, orig.scala$reflect$internal$BaseTypeSeqs$$parents().map(f, List$.MODULE$.canBuildFrom()), orig.scala$reflect$internal$BaseTypeSeqs$$elems());
        }
    }
}

