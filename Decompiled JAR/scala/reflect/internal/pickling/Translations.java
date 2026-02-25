/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.pickling;

import scala.MatchError;
import scala.Tuple2;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Names;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001)3\u0001\u0002C\u0005\u0011\u0002\u0007\u0005!C\u0012\u0005\u0006/\u0001!\t\u0001\u0007\u0005\u00069\u0001!\t!\b\u0005\u00069\u0001!\tA\n\u0005\u0006_\u0001!\t\u0001\r\u0005\u0006_\u0001!\ta\r\u0005\u0006_\u0001!\ta\u000f\u0005\u0006\u0007\u0002!\t\u0001\u0012\u0002\r)J\fgn\u001d7bi&|gn\u001d\u0006\u0003\u0015-\t\u0001\u0002]5dW2Lgn\u001a\u0006\u0003\u00195\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0003\u001d=\tqA]3gY\u0016\u001cGOC\u0001\u0011\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001A\n\u0011\u0005Q)R\"A\b\n\u0005Yy!AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u00023A\u0011ACG\u0005\u00037=\u0011A!\u00168ji\u0006\u0019\u0012n\u001d+sK\u0016\u001c\u00160\u001c2pYBK7m\u001b7fIR\u0011a$\t\t\u0003)}I!\u0001I\b\u0003\u000f\t{w\u000e\\3b]\")!E\u0001a\u0001G\u0005!1m\u001c3f!\t!B%\u0003\u0002&\u001f\t\u0019\u0011J\u001c;\u0015\u0005y9\u0003\"\u0002\u0015\u0004\u0001\u0004I\u0013\u0001\u0002;sK\u0016\u0004\"AK\u0016\u000e\u0003\u0001I!\u0001L\u0017\u0003\tQ\u0013X-Z\u0005\u0003]-\u0011Q\u0001\u0016:fKN\f!\u0002]5dW2,'\u000fV1h)\t\u0019\u0013\u0007C\u00033\t\u0001\u00071#A\u0002sK\u001a$\"a\t\u001b\t\u000bU*\u0001\u0019\u0001\u001c\u0002\u0007MLX\u000e\u0005\u0002+o%\u0011\u0001(\u000f\u0002\u0007'fl'm\u001c7\n\u0005iZ!aB*z[\n|Gn\u001d\u000b\u0003GqBQ!\u0010\u0004A\u0002y\n1\u0001\u001e9f!\tQs(\u0003\u0002A\u0003\n!A+\u001f9f\u0013\t\u00115BA\u0003UsB,7/A\u0007qS\u000e\\G.\u001a:Tk\n$\u0016m\u001a\u000b\u0003G\u0015CQ\u0001K\u0004A\u0002%\u0002\"a\u0012%\u000e\u0003-I!!S\u0006\u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface Translations {
    public static /* synthetic */ boolean isTreeSymbolPickled$(Translations $this, int code) {
        return $this.isTreeSymbolPickled(code);
    }

    default public boolean isTreeSymbolPickled(int code) {
        switch (code) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return true;
            }
            case 9: 
            case 12: 
            case 18: 
            case 21: 
            case 25: {
                return true;
            }
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isTreeSymbolPickled$(Translations $this, Trees.Tree tree) {
        return $this.isTreeSymbolPickled(tree);
    }

    default public boolean isTreeSymbolPickled(Trees.Tree tree) {
        return this.isTreeSymbolPickled(this.picklerSubTag(tree));
    }

    public static /* synthetic */ int picklerTag$(Translations $this, Object ref) {
        return $this.picklerTag(ref);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public int picklerTag(Object ref) {
        boolean bl = false;
        Tuple2 tuple2 = null;
        if (ref instanceof Types.Type && ((Types.Type)ref).scala$reflect$internal$Types$Type$$$outer() == this) {
            Types.Type type = (Types.Type)ref;
            return this.picklerTag(type);
        }
        if (ref instanceof Symbols.Symbol && ((Symbols.Symbol)ref).scala$reflect$internal$Symbols$Symbol$$$outer() == this) {
            Symbols.Symbol symbol = (Symbols.Symbol)ref;
            return this.picklerTag(symbol);
        }
        if (ref instanceof Constants.Constant && ((Constants.Constant)ref).scala$reflect$internal$Constants$Constant$$$outer() == this) {
            Constants.Constant constant = (Constants.Constant)ref;
            return 23 + constant.tag();
        }
        if (ref instanceof Trees.Tree && ((Trees.Tree)ref).scala$reflect$internal$Trees$Tree$$$outer() == this) {
            return 49;
        }
        if (ref instanceof Names.TermName) {
            return 1;
        }
        if (ref instanceof Names.TypeName) {
            return 2;
        }
        if (ref instanceof AnnotationInfos.ArrayAnnotArg && ((AnnotationInfos.ArrayAnnotArg)ref).scala$reflect$internal$AnnotationInfos$ArrayAnnotArg$$$outer() == this) {
            return 44;
        }
        if (ref instanceof AnnotationInfos.AnnotationInfo && ((AnnotationInfos.AnnotationInfo)ref).scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer() == this) {
            return 43;
        }
        if (ref instanceof Tuple2) {
            bl = true;
            tuple2 = (Tuple2)ref;
            if (tuple2._1() instanceof Symbols.Symbol && ((Symbols.Symbol)tuple2._1()).scala$reflect$internal$Symbols$Symbol$$$outer() == this && tuple2._2() instanceof AnnotationInfos.AnnotationInfo && ((AnnotationInfos.AnnotationInfo)tuple2._2()).scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer() == this) {
                return 40;
            }
        }
        if (bl && tuple2._1() instanceof Symbols.Symbol && ((Symbols.Symbol)tuple2._1()).scala$reflect$internal$Symbols$Symbol$$$outer() == this && tuple2._2() instanceof List) {
            return 41;
        }
        if (!(ref instanceof Trees.Modifiers)) throw package$.MODULE$.error(new StringBuilder(19).append("unpicklable entry ").append(scala.reflect.internal.util.package$.MODULE$.shortClassOfInstance(ref)).append(" ").append(ref).toString());
        if (((Trees.Modifiers)ref).scala$reflect$internal$Trees$Modifiers$$$outer() != this) throw package$.MODULE$.error(new StringBuilder(19).append("unpicklable entry ").append(scala.reflect.internal.util.package$.MODULE$.shortClassOfInstance(ref)).append(" ").append(ref).toString());
        return 50;
    }

    public static /* synthetic */ int picklerTag$(Translations $this, Symbols.Symbol sym) {
        return $this.picklerTag(sym);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public int picklerTag(Symbols.Symbol sym) {
        boolean bl = false;
        boolean bl2 = false;
        Symbols.NoSymbol noSymbol = ((Symbols)((Object)this)).NoSymbol();
        if (noSymbol == null) {
            if (sym == null) return 3;
        } else if (noSymbol.equals(sym)) {
            return 3;
        }
        if (sym instanceof Symbols.ClassSymbol) {
            return 6;
        }
        if (sym instanceof Symbols.TypeSymbol) {
            bl = true;
            Symbols.TypeSymbol cfr_ignored_0 = (Symbols.TypeSymbol)sym;
            if (sym.isAbstractType()) {
                return 4;
            }
        }
        if (bl) {
            return 5;
        }
        if (sym instanceof Symbols.TermSymbol) {
            bl2 = true;
            Symbols.TermSymbol cfr_ignored_1 = (Symbols.TermSymbol)sym;
            if (sym.isModule()) {
                return 7;
            }
        }
        if (!bl2) throw new MatchError(sym);
        return 8;
    }

    public static /* synthetic */ int picklerTag$(Translations $this, Types.Type tpe) {
        return $this.picklerTag(tpe);
    }

    default public int picklerTag(Types.Type tpe) {
        int n;
        if (((Types)((Object)this)).NoType().equals(tpe)) {
            n = 11;
        } else if (((Types)((Object)this)).NoPrefix().equals(tpe)) {
            n = 12;
        } else if (tpe instanceof Types.ThisType) {
            n = 13;
        } else if (tpe instanceof Types.SingleType) {
            n = 14;
        } else if (tpe instanceof Types.SuperType) {
            n = 46;
        } else if (tpe instanceof Types.ConstantType) {
            n = 15;
        } else if (tpe instanceof Types.TypeBounds) {
            n = 17;
        } else if (tpe instanceof Types.TypeRef) {
            n = 16;
        } else if (tpe instanceof Types.RefinedType) {
            n = 18;
        } else if (tpe instanceof Types.ClassInfoType) {
            n = 19;
        } else if (tpe instanceof Types.MethodType) {
            n = 20;
        } else if (tpe instanceof Types.PolyType) {
            n = 21;
        } else if (tpe instanceof Types.NullaryMethodType) {
            n = 21;
        } else if (tpe instanceof Types.ExistentialType) {
            n = 48;
        } else if (!((Types)((Object)this)).StaticallyAnnotatedType().unapply(tpe).isEmpty()) {
            n = 42;
        } else if (tpe instanceof Types.AnnotatedType) {
            n = this.picklerTag(tpe.underlying());
        } else {
            throw new MatchError(tpe);
        }
        return n;
    }

    public static /* synthetic */ int picklerSubTag$(Translations $this, Trees.Tree tree) {
        return $this.picklerSubTag(tree);
    }

    default public int picklerSubTag(Trees.Tree tree) {
        int n;
        if (((Object)((Trees)((Object)this)).EmptyTree()).equals(tree)) {
            n = 1;
        } else if (tree instanceof Trees.PackageDef) {
            n = 2;
        } else if (tree instanceof Trees.ClassDef) {
            n = 3;
        } else if (tree instanceof Trees.ModuleDef) {
            n = 4;
        } else if (tree instanceof Trees.ValDef) {
            n = 5;
        } else if (tree instanceof Trees.DefDef) {
            n = 6;
        } else if (tree instanceof Trees.TypeDef) {
            n = 7;
        } else if (tree instanceof Trees.LabelDef) {
            n = 8;
        } else if (tree instanceof Trees.Import) {
            n = 9;
        } else if (tree instanceof Trees.Template) {
            n = 12;
        } else if (tree instanceof Trees.Block) {
            n = 13;
        } else if (tree instanceof Trees.CaseDef) {
            n = 14;
        } else if (tree instanceof Trees.Alternative) {
            n = 16;
        } else if (tree instanceof Trees.Star) {
            n = 17;
        } else if (tree instanceof Trees.Bind) {
            n = 18;
        } else if (tree instanceof Trees.UnApply) {
            n = 19;
        } else if (tree instanceof Trees.ArrayValue) {
            n = 20;
        } else if (tree instanceof Trees.Function) {
            n = 21;
        } else if (tree instanceof Trees.Assign) {
            n = 22;
        } else if (tree instanceof Trees.If) {
            n = 23;
        } else if (tree instanceof Trees.Match) {
            n = 24;
        } else if (tree instanceof Trees.Return) {
            n = 25;
        } else if (tree instanceof Trees.Try) {
            n = 26;
        } else if (tree instanceof Trees.Throw) {
            n = 27;
        } else if (tree instanceof Trees.New) {
            n = 28;
        } else if (tree instanceof Trees.Typed) {
            n = 29;
        } else if (tree instanceof Trees.TypeApply) {
            n = 30;
        } else if (tree instanceof Trees.Apply) {
            n = 31;
        } else if (tree instanceof Trees.ApplyDynamic) {
            n = 32;
        } else if (tree instanceof Trees.Super) {
            n = 33;
        } else if (tree instanceof Trees.This) {
            n = 34;
        } else if (tree instanceof Trees.Select) {
            n = 35;
        } else if (tree instanceof Trees.Ident) {
            n = 36;
        } else if (tree instanceof Trees.Literal) {
            n = 37;
        } else if (tree instanceof Trees.TypeTree) {
            n = 38;
        } else if (tree instanceof Trees.Annotated) {
            n = 39;
        } else if (tree instanceof Trees.SingletonTypeTree) {
            n = 40;
        } else if (tree instanceof Trees.SelectFromTypeTree) {
            n = 41;
        } else if (tree instanceof Trees.CompoundTypeTree) {
            n = 42;
        } else if (tree instanceof Trees.AppliedTypeTree) {
            n = 43;
        } else if (tree instanceof Trees.TypeBoundsTree) {
            n = 44;
        } else if (tree instanceof Trees.ExistentialTypeTree) {
            n = 45;
        } else {
            throw new MatchError(tree);
        }
        return n;
    }

    public static void $init$(Translations $this) {
    }
}

