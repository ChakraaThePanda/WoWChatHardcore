/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.SerializedLambda;
import java.util.Map;
import scala.reflect.ScalaSignature;
import scala.runtime.LambdaDeserializer$;

@ScalaSignature(bytes="\u0006\u0001=;Q\u0001C\u0005\t\u000291Q\u0001E\u0005\t\u0002EAQAF\u0001\u0005\u0002]AQ\u0001G\u0001\u0005\u0002eAqaR\u0001C\u0002\u0013%\u0001\n\u0003\u0004M\u0003\u0001\u0006I!\u0013\u0005\b\u001b\u0006\u0011\r\u0011\"\u0003I\u0011\u0019q\u0015\u0001)A\u0005\u0013\u0006\u0011B*Y7cI\u0006$Um]3sS\u0006d\u0017N_3s\u0015\tQ1\"A\u0004sk:$\u0018.\\3\u000b\u00031\tQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002\u0010\u00035\t\u0011B\u0001\nMC6\u0014G-\u0019#fg\u0016\u0014\u0018.\u00197ju\u0016\u00148CA\u0001\u0013!\t\u0019B#D\u0001\f\u0013\t)2B\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u00039\t\u0011\u0003Z3tKJL\u0017\r\\5{K2\u000bWN\u00193b)\u0015\u0011\"D\u000b!C\u0011\u0015Y2\u00011\u0001\u001d\u0003\u0019awn\\6vaB\u0011Qd\n\b\u0003=\u0015j\u0011a\b\u0006\u0003A\u0005\na!\u001b8w_.,'B\u0001\u0012$\u0003\u0011a\u0017M\\4\u000b\u0003\u0011\nAA[1wC&\u0011aeH\u0001\u000e\u001b\u0016$\bn\u001c3IC:$G.Z:\n\u0005!J#A\u0002'p_.,\bO\u0003\u0002'?!)1f\u0001a\u0001Y\u0005)1-Y2iKB!Q\u0006\r\u001a>\u001b\u0005q#BA\u0018$\u0003\u0011)H/\u001b7\n\u0005Er#aA'baB\u00111G\u000f\b\u0003ia\u0002\"!N\u0006\u000e\u0003YR!aN\u0007\u0002\rq\u0012xn\u001c;?\u0013\tI4\"\u0001\u0004Qe\u0016$WMZ\u0005\u0003wq\u0012aa\u0015;sS:<'BA\u001d\f!\tqb(\u0003\u0002@?\taQ*\u001a;i_\u0012D\u0015M\u001c3mK\")\u0011i\u0001a\u0001Y\u0005yA/\u0019:hKRlU\r\u001e5pI6\u000b\u0007\u000fC\u0003D\u0007\u0001\u0007A)\u0001\u0006tKJL\u0017\r\\5{K\u0012\u0004\"AH#\n\u0005\u0019{\"\u0001E*fe&\fG.\u001b>fI2\u000bWN\u00193b\u0003E\u00196-\u00197b'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u000b\u0002\u0013B\u0011!jS\u0007\u0002C%\u00111(I\u0001\u0013'\u000e\fG.Y*fe&\fG.\u001b>bE2,\u0007%\u0001\nKCZ\f\u0017jT*fe&\fG.\u001b>bE2,\u0017a\u0005&bm\u0006LujU3sS\u0006d\u0017N_1cY\u0016\u0004\u0003")
public final class LambdaDeserializer {
    public static Object deserializeLambda(MethodHandles.Lookup lookup, Map<String, MethodHandle> map, Map<String, MethodHandle> map2, SerializedLambda serializedLambda) {
        return LambdaDeserializer$.MODULE$.deserializeLambda(lookup, map, map2, serializedLambda);
    }
}

