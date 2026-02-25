/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.MatchError;
import scala.Serializable;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.HashSet$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Trees;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.Variance;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.Variances$VarianceValidator$ValidateVarianceMap$;
import scala.reflect.internal.util.ReusableInstance;

@ScalaSignature(bytes="\u0006\u0001\t\u0015c!\u0003\u00180!\u0003\r\tA\u000eB \u0011\u0015Y\u0004\u0001\"\u0001=\r\u0011\u0001\u0005\u0001A!\t\u000b)\u0013A\u0011A&\t\u000f5\u0013!\u0019!C\u0005\u001d\"1AL\u0001Q\u0001\n=CA\"\u0018\u0002\u0005\u0002\u0003\u0015\t\u00111A\u0005\nyCAB\u0019\u0002\u0005\u0002\u0003\u0015\t\u00111A\u0005\n\rD\u0011B\u001a\u0002\u0003\u0002\u0003\u0005\u000b\u0015B0\t\u000b\u001d\u0014A\u0011\u00025\t\u000b]\u0014AQ\u0001=\t\u000f\u0005%!\u0001\"\u0005\u0002\f!9\u0011q\u0004\u0002\u0005\u0002\u0005\u0005\u0002bBA\u0015\u0005\u0011\u0005\u00111F\u0004\b\u0003_\u0011\u0001\u0012BA\u0019\r\u001d\t)D\u0001E\u0005\u0003oAaAS\b\u0005\u0002\u0005\u001d\u0003bCA\b\u001f\u0001\u0007\t\u0019!C\u0005\u0003\u0013B1\"a\u0013\u0010\u0001\u0004\u0005\r\u0011\"\u0003\u0002N!Q\u0011\u0011K\bA\u0002\u0003\u0005\u000b\u0015B,\t\u000f\u0005Ms\u0002\"\u0001\u0002V!9\u0011\u0011L\b\u0005\u0002\u0005m\u0003bBA1\u001f\u0011%\u00111\r\u0005\b\u0003OzA\u0011IA5\u0011\u001d\tIh\u0004C\u0005\u0003wBq!a \u0010\t\u0003\t\t\tC\u0004\u0002\u0006>!I!a\"\t\u000f\u0005-u\u0002\"\u0001\u0002\u000e\"9\u0011\u0011\u0013\u0002\u0005\n\u0005M\u0005bBAL\u0005\u0011\u0005\u0013\u0011\u0014\u0005\b\u0003O\u0003AQAAU\u0011\u001d\t\u0019\r\u0001C\u0003\u0003\u000bD\u0011\"!4\u0001\u0005\u0004&I!a4\u0007\r\u0005}\u0007ABAq\u0011\u0019Q\u0015\u0005\"\u0001\u0002d\"Q\u0011qL\u0011A\u0002\u0003\u0005\u000b\u0015B5\t\u0015\u0005=\u0016\u00051A\u0001B\u0003&q\u000bC\u0004\u0002f\u0006\"I!a:\t\u000f\u0005=\u0018\u0005\"\u0003\u0002r\"9\u0011\u0011`\u0011\u0005\n\u0005m\bbBA\u0000C\u0011%!\u0011\u0001\u0005\u000b\u0005'\t\u0003R1Q\u0005\n\tU\u0001B\u0003B\u0013C!\u0015\r\u0015\"\u0003\u0003(!Q!qF\u0011\t\u0006\u0004&IA!\r\t\u0011\tU\u0012\u0005)A\u0005\u0005oAq!a \"\t\u0003\u0011IDA\u0005WCJL\u0017M\\2fg*\u0011\u0001'M\u0001\tS:$XM\u001d8bY*\u0011!gM\u0001\be\u00164G.Z2u\u0015\u0005!\u0014!B:dC2\f7\u0001A\n\u0003\u0001]\u0002\"\u0001O\u001d\u000e\u0003MJ!AO\u001a\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\tQ\b\u0005\u00029}%\u0011qh\r\u0002\u0005+:LGOA\tWCJL\u0017M\\2f-\u0006d\u0017\u000eZ1u_J\u001c\"A\u0001\"\u0011\u0005\r#U\"\u0001\u0001\n\u0005\u00153%!\u0003+sCZ,'o]3s\u0013\t9\u0005JA\u0003Ue\u0016,7O\u0003\u0002Jc\u0005\u0019\u0011\r]5\u0002\rqJg.\u001b;?)\u0005a\u0005CA\"\u0003\u00035)7oY1qK\u0012dunY1mgV\tq\nE\u0002Q+^k\u0011!\u0015\u0006\u0003%N\u000bq!\\;uC\ndWM\u0003\u0002Ug\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005Y\u000b&a\u0002%bg\"\u001cV\r\u001e\t\u0003\u0007bK!!\u0017.\u0003\rMKXNY8m\u0013\tYvFA\u0004Ts6\u0014w\u000e\\:\u0002\u001d\u0015\u001c8-\u00199fI2{7-\u00197tA\u0005\u00015oY1mC\u0012\u0012XM\u001a7fGR$\u0013N\u001c;fe:\fG\u000e\n,be&\fgnY3tIY\u000b'/[1oG\u00164\u0016\r\\5eCR|'\u000f\n\u0013j]J+g-\u001b8f[\u0016tG/F\u0001`!\tA\u0004-\u0003\u0002bg\t9!i\\8mK\u0006t\u0017\u0001R:dC2\fGE]3gY\u0016\u001cG\u000fJ5oi\u0016\u0014h.\u00197%-\u0006\u0014\u0018.\u00198dKN$c+\u0019:jC:\u001cWMV1mS\u0012\fGo\u001c:%I%t'+\u001a4j]\u0016lWM\u001c;`I\u0015\fHCA\u001fe\u0011\u001d)w!!AA\u0002}\u000b1\u0001\u001f\u00132\u0003\u0005\u001b8-\u00197bII,g\r\\3di\u0012Jg\u000e^3s]\u0006dGEV1sS\u0006t7-Z:%-\u0006\u0014\u0018.\u00198dKZ\u000bG.\u001b3bi>\u0014H\u0005J5o%\u00164\u0017N\\3nK:$\b%\u0001\txSRD\u0017N\u001c*fM&tW-\\3oiR\u0011\u0011N\u001c\t\u0003\u0007*L!a\u001b7\u0003\tQK\b/Z\u0005\u0003[>\u0012Q\u0001V=qKNDaa\\\u0005\u0005\u0002\u0004\u0001\u0018\u0001\u00022pIf\u00042\u0001O9j\u0013\t\u00118G\u0001\u0005=Eft\u0017-\\3?Q\tIA\u000f\u0005\u00029k&\u0011ao\r\u0002\u0007S:d\u0017N\\3\u0002\u001d\rDWmY6G_J,5oY1qKR\u0019Q(_>\t\u000biT\u0001\u0019A,\u0002\u0007MLX\u000eC\u0003}\u0015\u0001\u0007q+\u0001\u0003tSR,\u0007F\u0001\u0006\u007f!\ry\u0018QA\u0007\u0003\u0003\u0003Q1!a\u00014\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003\u000f\t\tAA\u0004uC&d'/Z2\u0002%%\u001c8/^3WCJL\u0017M\\2f\u000bJ\u0014xN\u001d\u000b\b{\u00055\u0011\u0011CA\n\u0011\u0019\tya\u0003a\u0001/\u0006!!-Y:f\u0011\u0015Q8\u00021\u0001X\u0011\u001d\t)b\u0003a\u0001\u0003/\t\u0001B]3rk&\u0014X\r\u001a\t\u0005\u00033\tY\"D\u00010\u0013\r\tib\f\u0002\t-\u0006\u0014\u0018.\u00198dK\u0006Q1\u000f[8vY\u00124E.\u001b9\u0015\u000b}\u000b\u0019#!\n\t\u000bid\u0001\u0019A,\t\r\u0005\u001dB\u00021\u0001X\u0003\u0011!h/\u0019:\u0002)%\u001cX\t_3naR4%o\\7WCJL\u0017M\\2f)\ry\u0016Q\u0006\u0005\u0006u6\u0001\raV\u0001\u0014-\u0006d\u0017\u000eZ1uKZ\u000b'/[1oG\u0016l\u0015\r\u001d\t\u0004\u0003gyQ\"\u0001\u0002\u0003'Y\u000bG.\u001b3bi\u00164\u0016M]5b]\u000e,W*\u00199\u0014\u0007=\tI\u0004E\u0002D\u0003wIA!!\u0010\u0002@\t9A+\u001f9f\u001b\u0006\u0004\u0018\u0002BA!\u0003\u0007\u0012\u0001\u0002V=qK6\u000b\u0007o\u001d\u0006\u0004\u0003\u000bz\u0013a\u0001;qKR\u0011\u0011\u0011G\u000b\u0002/\u0006A!-Y:f?\u0012*\u0017\u000fF\u0002>\u0003\u001fBq!\u001a\n\u0002\u0002\u0003\u0007q+A\u0003cCN,\u0007%\u0001\tsK2\fG/\u001b<f-\u0006\u0014\u0018.\u00198dKR!\u0011qCA,\u0011\u0019\t9\u0003\u0006a\u0001/\u0006\u0019\u0012n]+oG\",7m[3e-\u0006\u0014\u0018.\u00198dKR\u0019q,!\u0018\t\r\u0005}S\u00031\u0001j\u0003\t!\b/A\u000bdQ\u0016\u001c7NV1sS\u0006t7-Z(g'fl'm\u001c7\u0015\u0007u\n)\u0007C\u0003{-\u0001\u0007q+A\u0004nCB|e/\u001a:\u0015\t\u0005-\u0014Q\u000f\t\u0004\u0007\u00065\u0014\u0002BA8\u0003c\u0012QaU2pa\u0016L1!a\u001d0\u0005\u0019\u00196m\u001c9fg\"9\u0011qO\fA\u0002\u0005-\u0014!\u00023fG2\u001c\u0018A\u0004:fgVdG\u000fV=qK>sG.\u001f\u000b\u0004?\u0006u\u0004BBA01\u0001\u0007\u0011.A\u0003baBd\u0017\u0010F\u0002j\u0003\u0007Ca!a\u0018\u001a\u0001\u0004I\u0017!D:i_VdG\rR3bY&\f7\u000fF\u0002`\u0003\u0013CQA\u001f\u000eA\u0002]\u000b!C^1mS\u0012\fG/\u001a#fM&t\u0017\u000e^5p]R\u0019Q(a$\t\r\u0005=1\u00041\u0001X\u0003A1\u0018\r\\5eCR,g+\u0019:jC:\u001cW\rF\u0002>\u0003+Ca!a\u0004\u001d\u0001\u00049\u0016\u0001\u0003;sCZ,'o]3\u0015\u0007u\nY\nC\u0004\u0002\u001ev\u0001\r!a(\u0002\tQ\u0014X-\u001a\t\u0004\u0007\u0006\u0005\u0016\u0002BAR\u0003K\u0013A\u0001\u0016:fK&\u0011qiL\u0001\u0010m\u0006\u0014\u0018.\u00198dK&sG+\u001f9fgR!\u00111VAY)\u0011\t9\"!,\t\r\u0005=f\u00041\u0001X\u0003\u0019!\b/\u0019:b[\"9\u00111\u0017\u0010A\u0002\u0005U\u0016a\u0001;qgB)\u0011qWA_S:\u0019\u0001(!/\n\u0007\u0005m6'A\u0004qC\u000e\\\u0017mZ3\n\t\u0005}\u0016\u0011\u0019\u0002\u0005\u0019&\u001cHOC\u0002\u0002<N\naB^1sS\u0006t7-Z%o)f\u0004X\r\u0006\u0003\u0002H\u0006-G\u0003BA\f\u0003\u0013Da!a, \u0001\u00049\u0006BBA0?\u0001\u0007\u0011.A\nwCJL\u0017M\\2f\u0013:$\u0016\u0010]3DC\u000eDW-\u0006\u0002\u0002RB1\u00111[Am\u0003;l!!!6\u000b\u0007\u0005]w&\u0001\u0003vi&d\u0017\u0002BAn\u0003+\u0014\u0001CU3vg\u0006\u0014G.Z%ogR\fgnY3\u0011\u0005\r\u000b#A\u0004<be&\fgnY3J]RK\b/Z\n\u0003C]\"\"!!8\u0002\r%t\u0017I]4t)\u0019\t9\"!;\u0002l\")!0\na\u0001/\"9\u0011Q^\u0013A\u0002\u0005U\u0016\u0001B1sON\fa!\u001b8Ts6\u001cH\u0003BA\f\u0003gDq!!>'\u0001\u0004\t90\u0001\u0003ts6\u001c\b#BA\\\u0003{;\u0016aB5o)f\u0004Xm\u001d\u000b\u0005\u0003/\ti\u0010C\u0004\u00024\u001e\u0002\r!!.\u0002\u0011%t\u0017I\u001c8piN$B!a\u0006\u0003\u0004!9!Q\u0001\u0015A\u0002\t\u001d\u0011\u0001B1o]N\u0004b!a.\u0002>\n%\u0001cA\"\u0003\f%!!Q\u0002B\b\u00059\teN\\8uCRLwN\\%oM>L1A!\u00050\u0005=\teN\\8uCRLwN\\%oM>\u001c\u0018aD5o\u0003:tw\u000e^1uS>t\u0017\t\u001e9\u0016\u0005\t]\u0001C\u0002B\r\u0005?\u0011IA\u0004\u0003\u0002\u001a\tm\u0011b\u0001B\u000f_\u0005Aa+\u0019:jC:\u001cW-\u0003\u0003\u0003\"\t\r\"!C#yiJ\f7\r^8s\u0015\r\u0011ibL\u0001\u000bS:\f%o\u001a)be\u0006lWC\u0001B\u0015!\u0019\u0011IBa\u000bj/&!!Q\u0006B\u0012\u0005))\u0005\u0010\u001e:bGR|'OM\u0001\u0006S:\u001c\u00160\\\u000b\u0003\u0005g\u0001RA!\u0007\u0003 ]\u000ba!\u001b8UsB,\u0007#\u0002B\r\u0005?IGCBA\f\u0005w\u0011i\u0004\u0003\u0004\u0002`5\u0002\r!\u001b\u0005\u0007\u0003_k\u0003\u0019A,\u0011\t\u0005e!\u0011I\u0005\u0004\u0005\u0007z#aC*z[\n|G\u000eV1cY\u0016\u0004")
public interface Variances {
    public void scala$reflect$internal$Variances$_setter_$scala$reflect$internal$Variances$$varianceInTypeCache_$eq(ReusableInstance<varianceInType> var1);

    public static /* synthetic */ int varianceInTypes$(Variances $this, List tps, Symbols.Symbol tparam) {
        return $this.varianceInTypes(tps, tparam);
    }

    default public int varianceInTypes(List<Types.Type> tps, Symbols.Symbol tparam) {
        return Variance$.MODULE$.foldExtract(tps, t -> this.varianceInType((Types.Type)t, tparam));
    }

    public static /* synthetic */ int varianceInType$(Variances $this, Types.Type tp, Symbols.Symbol tparam) {
        return $this.varianceInType(tp, tparam);
    }

    default public int varianceInType(Types.Type tp, Symbols.Symbol tparam) {
        Variance variance;
        ReusableInstance<varianceInType> reusableInstance = this.scala$reflect$internal$Variances$$varianceInTypeCache();
        if (reusableInstance == null) {
            throw null;
        }
        ReusableInstance<varianceInType> using_this = reusableInstance;
        if (!using_this.scala$reflect$internal$util$ReusableInstance$$enabled || using_this.scala$reflect$internal$util$ReusableInstance$$taken()) {
            varianceInType varianceInType2 = (varianceInType)using_this.scala$reflect$internal$util$ReusableInstance$$make.apply();
            variance = new Variance(varianceInType2.apply(tp, tparam));
        } else {
            try {
                using_this.scala$reflect$internal$util$ReusableInstance$$taken_$eq(true);
                varianceInType varianceInType3 = using_this.scala$reflect$internal$util$ReusableInstance$$cached();
                variance = new Variance(varianceInType3.apply(tp, tparam));
            }
            finally {
                using_this.scala$reflect$internal$util$ReusableInstance$$taken_$eq(false);
            }
        }
        return variance.flags();
    }

    public ReusableInstance<varianceInType> scala$reflect$internal$Variances$$varianceInTypeCache();

    public static void $init$(Variances $this) {
        $this.scala$reflect$internal$Variances$_setter_$scala$reflect$internal$Variances$$varianceInTypeCache_$eq(new ReusableInstance<varianceInType>((Function0<varianceInType> & java.io.Serializable & Serializable)() -> new varianceInType((SymbolTable)$this), ((SymbolTable)$this).isCompilerUniverse()));
    }

    public static /* synthetic */ Object $anonfun$varianceInType$1$adapted(Types.Type tp$2, Symbols.Symbol tparam$2, varianceInType x$2) {
        return new Variance(x$2.apply(tp$2, tparam$2));
    }

    public static class VarianceValidator
    extends Trees.Traverser {
        private volatile Variances$VarianceValidator$ValidateVarianceMap$ ValidateVarianceMap$module;
        private final HashSet<Symbols.Symbol> escapedLocals;
        private boolean scala$reflect$internal$Variances$VarianceValidator$$inRefinement;
        public final /* synthetic */ SymbolTable $outer;

        private Variances$VarianceValidator$ValidateVarianceMap$ ValidateVarianceMap() {
            if (this.ValidateVarianceMap$module == null) {
                this.ValidateVarianceMap$lzycompute$1();
            }
            return this.ValidateVarianceMap$module;
        }

        private HashSet<Symbols.Symbol> escapedLocals() {
            return this.escapedLocals;
        }

        public boolean scala$reflect$internal$Variances$VarianceValidator$$inRefinement() {
            return this.scala$reflect$internal$Variances$VarianceValidator$$inRefinement;
        }

        public void scala$reflect$internal$Variances$VarianceValidator$$inRefinement_$eq(boolean x$1) {
            this.scala$reflect$internal$Variances$VarianceValidator$$inRefinement = x$1;
        }

        public Types.Type scala$reflect$internal$Variances$VarianceValidator$$withinRefinement(Function0<Types.Type> body) {
            Types.Type type;
            boolean saved = this.scala$reflect$internal$Variances$VarianceValidator$$inRefinement();
            this.scala$reflect$internal$Variances$VarianceValidator$$inRefinement_$eq(true);
            try {
                type = body.apply();
            }
            finally {
                this.scala$reflect$internal$Variances$VarianceValidator$$inRefinement_$eq(saved);
            }
            return type;
        }

        public final void checkForEscape(Symbols.Symbol sym, Symbols.Symbol site) {
            block1: {
                while (true) {
                    Symbols.Symbol symbol = site;
                    Symbols.Symbol symbol2 = sym.owner();
                    if (!(symbol == null ? symbol2 != null : !symbol.equals(symbol2))) break block1;
                    Symbols.Symbol symbol3 = site;
                    Symbols.Symbol symbol4 = sym.owner().moduleClass();
                    if (!(symbol3 == null ? symbol4 != null : !symbol3.equals(symbol4)) || site.hasPackageFlag()) break block1;
                    if (!site.isTerm() && !site.isPrivateLocal()) break;
                    site = site.owner();
                }
                this.escapedLocals().$plus$eq((Object)sym);
            }
        }

        public void issueVarianceError(Symbols.Symbol base, Symbols.Symbol sym, int required) {
        }

        public boolean shouldFlip(Symbols.Symbol sym, Symbols.Symbol tvar) {
            block2: {
                block3: {
                    if (!sym.isParameter()) break block2;
                    if (!tvar.isTypeParameterOrSkolem() || !sym.isTypeParameterOrSkolem()) break block3;
                    Symbols.Symbol symbol = tvar.owner();
                    Symbols.Symbol symbol2 = sym.owner();
                    if (!(symbol == null ? symbol2 != null : !symbol.equals(symbol2))) break block2;
                }
                return true;
            }
            return false;
        }

        public boolean isExemptFromVariance(Symbols.Symbol sym) {
            return !sym.owner().isClass() || (sym.isLocalToThis() || sym.isSuperAccessor()) && !this.escapedLocals().apply(sym);
        }

        private void validateVariance(Symbols.Symbol base) {
            this.ValidateVarianceMap().validateDefinition(base);
        }

        public void traverse(Trees.Tree tree) {
            Trees.TypeTree typeTree;
            if (tree instanceof Trees.MemberDef && this.skip$1(tree)) {
                this.scala$reflect$internal$Variances$VarianceValidator$$$outer().debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(27).append("Skipping variance check of ").append(VarianceValidator.sym$3(tree).defString()).toString());
                return;
            }
            boolean bl = tree instanceof Trees.ClassDef ? true : tree instanceof Trees.TypeDef;
            if (bl) {
                this.validateVariance(VarianceValidator.sym$3(tree));
                super.traverse(tree);
                return;
            }
            if (tree instanceof Trees.ModuleDef) {
                this.validateVariance(VarianceValidator.sym$3(tree).moduleClass());
                super.traverse(tree);
                return;
            }
            if (tree instanceof Trees.ValDef) {
                this.validateVariance(VarianceValidator.sym$3(tree));
                return;
            }
            if (tree instanceof Trees.DefDef) {
                Trees.DefDef defDef = (Trees.DefDef)tree;
                List<Trees.TreeApi> tparams = defDef.tparams();
                List<List<Trees.TreeApi>> vparamss = defDef.vparamss();
                this.validateVariance(VarianceValidator.sym$3(tree));
                this.traverseTrees(tparams);
                this.traverseTreess(vparamss);
                return;
            }
            if (tree instanceof Trees.Template) {
                super.traverse(tree);
                return;
            }
            if (tree instanceof Trees.CompoundTypeTree) {
                super.traverse(tree);
                return;
            }
            if (tree instanceof Trees.TypeTree && (typeTree = (Trees.TypeTree)tree).original() != null) {
                super.traverse(typeTree.original());
                return;
            }
            if (tree instanceof Trees.TypTree) {
                Trees.TypTree typTree = (Trees.TypTree)((Object)tree);
                super.traverse(typTree);
                return;
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Variances$VarianceValidator$$$outer() {
            return this.$outer;
        }

        private final void ValidateVarianceMap$lzycompute$1() {
            synchronized (this) {
                if (this.ValidateVarianceMap$module == null) {
                    this.ValidateVarianceMap$module = new Variances$VarianceValidator$ValidateVarianceMap$(this);
                }
                return;
            }
        }

        private static final Symbols.Symbol sym$3(Trees.Tree tree$1) {
            return tree$1.symbol();
        }

        private final boolean skip$1(Trees.Tree tree$1) {
            Symbols.Symbol symbol = VarianceValidator.sym$3(tree$1);
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Variances$VarianceValidator$$$outer().NoSymbol();
            return !(symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) || VarianceValidator.sym$3(tree$1).isLocalToThis() || VarianceValidator.sym$3(tree$1).owner().isConstructor() || VarianceValidator.sym$3(tree$1).owner().isCaseApplyOrUnapply();
        }

        public VarianceValidator(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer);
            this.escapedLocals = (HashSet)HashSet$.MODULE$.apply(Nil$.MODULE$);
            this.scala$reflect$internal$Variances$VarianceValidator$$inRefinement = false;
        }
    }

    private static final class varianceInType {
        private Variance.Extractor<AnnotationInfos.AnnotationInfo> inAnnotationAtp;
        private Variance.Extractor2<Types.Type, Symbols.Symbol> inArgParam;
        private Variance.Extractor<Symbols.Symbol> inSym;
        private Types.Type tp;
        private Symbols.Symbol tparam;
        private final Variance.Extractor<Types.Type> inType;
        private volatile byte bitmap$0;
        private final /* synthetic */ SymbolTable $outer;

        private int inArgs(Symbols.Symbol sym, List<Types.Type> args2) {
            return Variance$.MODULE$.foldExtract2(args2, sym.typeParams(), this.inArgParam());
        }

        private int inSyms(List<Symbols.Symbol> syms) {
            return Variance$.MODULE$.foldExtract(syms, this.inSym());
        }

        private int inTypes(List<Types.Type> tps) {
            return Variance$.MODULE$.foldExtract(tps, this.inType);
        }

        private int inAnnots(List<AnnotationInfos.AnnotationInfo> anns) {
            return Variance$.MODULE$.foldExtract(anns, this.inAnnotationAtp());
        }

        private Variance.Extractor<AnnotationInfos.AnnotationInfo> inAnnotationAtp$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 1) == 0) {
                    this.inAnnotationAtp = a -> $this.inType.apply(a.atp());
                    this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                }
            }
            return this.inAnnotationAtp;
        }

        private Variance.Extractor<AnnotationInfos.AnnotationInfo> inAnnotationAtp() {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                return this.inAnnotationAtp$lzycompute();
            }
            return this.inAnnotationAtp;
        }

        private Variance.Extractor2<Types.Type, Symbols.Symbol> inArgParam$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 2) == 0) {
                    this.inArgParam = (a, b) -> Variance$.MODULE$.$times$extension($this.inType.apply((Types.Type)a), b.variance());
                    this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                }
            }
            return this.inArgParam;
        }

        private Variance.Extractor2<Types.Type, Symbols.Symbol> inArgParam() {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                return this.inArgParam$lzycompute();
            }
            return this.inArgParam;
        }

        private Variance.Extractor<Symbols.Symbol> inSym$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 4) == 0) {
                    this.inSym = sym -> {
                        if (sym.isAliasType()) {
                            return Variance$.MODULE$.cut$extension($this.inType.apply(sym.info()));
                        }
                        return $this.inType.apply(sym.info());
                    };
                    this.bitmap$0 = (byte)(this.bitmap$0 | 4);
                }
            }
            return this.inSym;
        }

        private Variance.Extractor<Symbols.Symbol> inSym() {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                return this.inSym$lzycompute();
            }
            return this.inSym;
        }

        public int apply(Types.Type tp, Symbols.Symbol tparam) {
            int n;
            this.tp = tp;
            this.tparam = tparam;
            try {
                n = this.inType.apply(tp);
            }
            finally {
                this.tp = null;
                this.tparam = null;
            }
            return n;
        }

        public varianceInType(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.inType = x0$1 -> {
                boolean bl = false;
                Types.TypeRef typeRef = null;
                boolean bl2 = $this.$outer.ErrorType().equals(x0$1) ? true : ($this.$outer.WildcardType().equals(x0$1) ? true : ($this.$outer.NoType().equals(x0$1) ? true : $this.$outer.NoPrefix().equals(x0$1)));
                if (bl2) {
                    return Variance$.MODULE$.Bivariant();
                }
                boolean bl3 = x0$1 instanceof Types.ThisType ? true : x0$1 instanceof Types.ConstantType;
                if (bl3) {
                    return Variance$.MODULE$.Bivariant();
                }
                if (x0$1 instanceof Types.TypeRef) {
                    bl = true;
                    typeRef = (Types.TypeRef)x0$1;
                    if (typeRef.sym() == $this.tparam) {
                        return Variance$.MODULE$.Covariant();
                    }
                }
                if (x0$1 instanceof Types.BoundedWildcardType) {
                    Types.TypeBounds bounds = ((Types.BoundedWildcardType)x0$1).bounds();
                    return $this.inType.apply(bounds);
                }
                if (x0$1 instanceof Types.NullaryMethodType) {
                    Types.Type restpe = ((Types.NullaryMethodType)x0$1).resultType();
                    return $this.inType.apply(restpe);
                }
                if (x0$1 instanceof Types.SingleType) {
                    Types.Type pre = ((Types.SingleType)x0$1).pre();
                    return $this.inType.apply(pre);
                }
                if (bl) {
                    Types.Type pre = typeRef.pre();
                    if ($this.tp.isHigherKinded()) {
                        return $this.inType.apply(pre);
                    }
                }
                if (bl) {
                    Types.Type pre = typeRef.pre();
                    Symbols.Symbol sym = typeRef.sym();
                    List<Types.Type> args2 = typeRef.args();
                    return Variance$.MODULE$.$amp$extension($this.inType.apply(pre), this.inArgs(sym, args2));
                }
                if (x0$1 instanceof Types.TypeBounds) {
                    Types.TypeBounds typeBounds = (Types.TypeBounds)x0$1;
                    Types.Type lo = typeBounds.lo();
                    Types.Type hi = typeBounds.hi();
                    return Variance$.MODULE$.$amp$extension(Variance$.MODULE$.flip$extension($this.inType.apply(lo)), $this.inType.apply(hi));
                }
                if (x0$1 instanceof Types.RefinedType) {
                    Types.RefinedType refinedType = (Types.RefinedType)x0$1;
                    List<Types.Type> parents = refinedType.parents();
                    Scopes.Scope defs = refinedType.decls();
                    return Variance$.MODULE$.$amp$extension(this.inTypes(parents), this.inSyms(defs.toList()));
                }
                if (x0$1 instanceof Types.MethodType) {
                    Types.MethodType methodType = (Types.MethodType)x0$1;
                    List<Symbols.Symbol> params = methodType.params();
                    Types.Type restpe = methodType.resultType();
                    return Variance$.MODULE$.$amp$extension(Variance$.MODULE$.flip$extension(this.inSyms(params)), $this.inType.apply(restpe));
                }
                if (x0$1 instanceof Types.PolyType) {
                    Types.PolyType polyType = (Types.PolyType)x0$1;
                    List<Symbols.Symbol> tparams = polyType.typeParams();
                    Types.Type restpe = polyType.resultType();
                    return Variance$.MODULE$.$amp$extension(Variance$.MODULE$.flip$extension(this.inSyms(tparams)), $this.inType.apply(restpe));
                }
                if (x0$1 instanceof Types.ExistentialType) {
                    Types.ExistentialType existentialType = (Types.ExistentialType)x0$1;
                    List<Symbols.Symbol> tparams = existentialType.quantified();
                    Types.Type restpe = existentialType.underlying();
                    return Variance$.MODULE$.$amp$extension(this.inSyms(tparams), $this.inType.apply(restpe));
                }
                if (!(x0$1 instanceof Types.AnnotatedType)) throw new MatchError(x0$1);
                Types.AnnotatedType annotatedType = (Types.AnnotatedType)x0$1;
                List<AnnotationInfos.AnnotationInfo> annots = annotatedType.annotations();
                Types.Type tp = annotatedType.underlying();
                return Variance$.MODULE$.$amp$extension(this.inAnnots(annots), $this.inType.apply(tp));
            };
        }
    }
}

