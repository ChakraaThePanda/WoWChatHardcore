/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001Y2qa\u0001\u0003\u0011\u0002G\u00051\u0002C\u0003\u0012\u0001\u0019\u0005!\u0003C\u0003\u0012\u0001\u0019\u0005AF\u0001\u0007DC:\u0014U/\u001b7e\rJ|WN\u0003\u0002\u0006\r\u00059q-\u001a8fe&\u001c'BA\u0004\t\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u0013\u0005)1oY1mC\u000e\u0001Q\u0003\u0002\u0007+7\u0015\u001a\"\u0001A\u0007\u0011\u00059yQ\"\u0001\u0005\n\u0005AA!AB!osJ+g-A\u0003baBd\u0017\u0010\u0006\u0002\u0014OA!AcF\r%\u001b\u0005)\"B\u0001\f\u0007\u0003\u001diW\u000f^1cY\u0016L!\u0001G\u000b\u0003\u000f\t+\u0018\u000e\u001c3feB\u0011!d\u0007\u0007\u0001\t\u0019a\u0002\u0001#b\u0001;\t!Q\t\\3n#\tq\u0012\u0005\u0005\u0002\u000f?%\u0011\u0001\u0005\u0003\u0002\b\u001d>$\b.\u001b8h!\tq!%\u0003\u0002$\u0011\t\u0019\u0011I\\=\u0011\u0005i)CA\u0002\u0014\u0001\t\u000b\u0007QD\u0001\u0002U_\")\u0001&\u0001a\u0001S\u0005!aM]8n!\tQ\"\u0006\u0002\u0004,\u0001!\u0015\r!\b\u0002\u0005\rJ|W\u000eF\u0001\u0014Q\r\u0001a\u0006\u000e\t\u0003_Ij\u0011\u0001\r\u0006\u0003c!\t!\"\u00198o_R\fG/[8o\u0013\t\u0019\u0004G\u0001\tj[Bd\u0017nY5u\u001d>$hi\\;oI\u0006\nQ'\u00019DC:tw\u000e\u001e\u0011d_:\u001cHO];di\u0002\n\u0007eY8mY\u0016\u001cG/[8oA=4\u0007\u0005^=qK\u0002\"3\u0010V8~A]LG\u000f\u001b\u0011fY\u0016lWM\u001c;tA=4\u0007\u0005^=qK\u0002\"30\u00127f[v\u0004#-Y:fI\u0002zg\u000eI1!G>dG.Z2uS>t\u0007e\u001c4!if\u0004X\r\t\u0013|\rJ|W. \u0018")
public interface CanBuildFrom<From, Elem, To> {
    public Builder<Elem, To> apply(From var1);

    public Builder<Elem, To> apply();
}

