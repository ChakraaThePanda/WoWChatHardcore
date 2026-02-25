/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoType$;

@ScalaSignature(bytes="\u0006\u0001A3\u0001\u0002C\u0005\u0011\u0002\u0007\u0005\u0001\u0003\u0014\u0005\u0006+\u0001!\tA\u0006\u0005\u00065\u0001!\ta\u0007\u0005\u0006I\u0001!\t!\n\u0005\u0006Y\u0001!\t!\f\u0005\u0006Y\u0001!\t\u0001\u000e\u0005\b{\u0001\t\n\u0011\"\u0001?\u0011\u001dI\u0005!%A\u0005\u0002)\u0013\u0011cQ1qiV\u0014X\r\u001a,be&\f'\r\\3t\u0015\tQ1\"\u0001\u0005j]R,'O\\1m\u0015\taQ\"A\u0004sK\u001adWm\u0019;\u000b\u00039\tQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001#A\u0011!cE\u0007\u0002\u001b%\u0011A#\u0004\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%)\u00059\u0002C\u0001\n\u0019\u0013\tIRB\u0001\u0003V]&$\u0018aD2baR,(/\u001a,be&\f'\r\\3\u0015\u0005]a\u0002\"B\u000f\u0003\u0001\u0004q\u0012\u0001\u0002<cY\u0016\u0004\"a\b\u0011\u000e\u0003\u0001I!!\t\u0012\u0003\rMKXNY8m\u0013\t\u0019\u0013BA\u0004Ts6\u0014w\u000e\\:\u00023I,g-\u001a:f]\u000e,7)\u00199ukJ,GMV1sS\u0006\u0014G.\u001a\u000b\u0003M-\u0002\"aH\u0014\n\u0005!J#\u0001\u0002+sK\u0016L!AK\u0005\u0003\u000bQ\u0013X-Z:\t\u000bu\u0019\u0001\u0019\u0001\u0010\u0002)\r\f\u0007\u000f^;sK\u00124\u0016M]5bE2,G+\u001f9f)\tq3\u0007\u0005\u0002 _%\u0011\u0001'\r\u0002\u0005)f\u0004X-\u0003\u00023\u0013\t)A+\u001f9fg\")Q\u0004\u0002a\u0001=Q!a&\u000e\u001c9\u0011\u0015iR\u00011\u0001\u001f\u0011\u001d9T\u0001%AA\u00029\n1\u0001\u001e9f\u0011\u001dIT\u0001%AA\u0002i\n1\"\u001a:bg\u0016$G+\u001f9fgB\u0011!cO\u0005\u0003y5\u0011qAQ8pY\u0016\fg.\u0001\u0010dCB$XO]3e-\u0006\u0014\u0018.\u00192mKRK\b/\u001a\u0013eK\u001a\fW\u000f\u001c;%eU\tqH\u000b\u0002/\u0001.\n\u0011\t\u0005\u0002C\u000f6\t1I\u0003\u0002E\u000b\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0003\r6\t!\"\u00198o_R\fG/[8o\u0013\tA5IA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fadY1qiV\u0014X\r\u001a,be&\f'\r\\3UsB,G\u0005Z3gCVdG\u000fJ\u001a\u0016\u0003-S#A\u000f!\u0011\u00055sU\"A\u0005\n\u0005=K!aC*z[\n|G\u000eV1cY\u0016\u0004")
public interface CapturedVariables {
    public static /* synthetic */ void captureVariable$(CapturedVariables $this, Symbols.Symbol vble) {
        $this.captureVariable(vble);
    }

    default public void captureVariable(Symbols.Symbol vble) {
        vble.setFlag(65536L);
    }

    public static /* synthetic */ Trees.Tree referenceCapturedVariable$(CapturedVariables $this, Symbols.Symbol vble) {
        return $this.referenceCapturedVariable(vble);
    }

    default public Trees.Tree referenceCapturedVariable(Symbols.Symbol vble) {
        return new Trees.ReferenceToBoxed((SymbolTable)this, ((Trees)((Object)this)).Ident(vble));
    }

    public static /* synthetic */ Types.Type capturedVariableType$(CapturedVariables $this, Symbols.Symbol vble) {
        return $this.capturedVariableType(vble);
    }

    default public Types.Type capturedVariableType(Symbols.Symbol vble) {
        return this.capturedVariableType(vble, ((Types)((Object)this)).NoType(), false);
    }

    public static /* synthetic */ Types.Type capturedVariableType$(CapturedVariables $this, Symbols.Symbol vble, Types.Type tpe, boolean erasedTypes) {
        return $this.capturedVariableType(vble, tpe, erasedTypes);
    }

    default public Types.Type capturedVariableType(Symbols.Symbol vble, Types.Type tpe, boolean erasedTypes) {
        Types.Type type = tpe;
        Types$NoType$ types$NoType$ = ((Types)((Object)this)).NoType();
        Types.Type tpe1 = !(type != null ? !type.equals(types$NoType$) : types$NoType$ != null) ? vble.tpe() : tpe;
        Symbols.Symbol symClass = tpe1.typeSymbol();
        if (vble.hasAnnotation(((Definitions)((Object)this)).definitions().VolatileAttr())) {
            return this.refType$1(((Definitions)((Object)this)).definitions().volatileRefClass(), ((Definitions)((Object)this)).definitions().VolatileObjectRefClass(), symClass, erasedTypes, tpe1);
        }
        return this.refType$1(((Definitions)((Object)this)).definitions().refClass(), ((Definitions)((Object)this)).definitions().ObjectRefClass(), symClass, erasedTypes, tpe1);
    }

    public static /* synthetic */ Types.Type capturedVariableType$default$2$(CapturedVariables $this) {
        return $this.capturedVariableType$default$2();
    }

    default public Types.Type capturedVariableType$default$2() {
        return ((Types)((Object)this)).NoType();
    }

    public static /* synthetic */ boolean capturedVariableType$default$3$(CapturedVariables $this) {
        return $this.capturedVariableType$default$3();
    }

    default public boolean capturedVariableType$default$3() {
        return false;
    }

    private Types.Type refType$1(Map valueRef, Symbols.Symbol objectRefClass, Symbols.Symbol symClass$1, boolean erasedTypes$1, Types.Type tpe1$1) {
        if (((Definitions)((Object)this)).definitions().isPrimitiveValueClass(symClass$1)) {
            Symbols.Symbol symbol = symClass$1;
            Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().UnitClass();
            if (symbol == null ? classSymbol != null : !symbol.equals(classSymbol)) {
                return ((Symbols.Symbol)valueRef.apply(symClass$1)).tpe();
            }
        }
        if (erasedTypes$1) {
            return objectRefClass.tpe();
        }
        return ((Types)((Object)this)).appliedType(objectRefClass, Nil$.MODULE$.$colon$colon(tpe1$1));
    }

    public static void $init$(CapturedVariables $this) {
    }
}

