/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.nio.file.Path;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.OwnerOnlyChmod$;

@ScalaSignature(bytes="\u0006\u0001Q;Qa\u0003\u0007\t\u0002U1Qa\u0006\u0007\t\u0002aAQ!H\u0001\u0005\u0002yAQaH\u0001\u0005\n\u0001Bq\u0001M\u0001C\u0002\u0013%\u0011\u0007\u0003\u0004>\u0003\u0001\u0006IA\r\u0005\b}\u0005\u0011\r\u0011\"\u00032\u0011\u0019y\u0014\u0001)A\u0005e!)\u0001)\u0001C\u0001\u0003\")a)\u0001C\u0001\u000f\")\u0011*\u0001C\u0001\u0015\u0006qqj\u001e8fe>sG._\"i[>$'BA\u0007\u000f\u0003\u0011)H/\u001b7\u000b\u0005=\u0001\u0012\u0001C5oi\u0016\u0014h.\u00197\u000b\u0005E\u0011\u0012a\u0002:fM2,7\r\u001e\u0006\u0002'\u0005)1oY1mC\u000e\u0001\u0001C\u0001\f\u0002\u001b\u0005a!AD(x]\u0016\u0014xJ\u001c7z\u0007\"lw\u000eZ\n\u0003\u0003e\u0001\"AG\u000e\u000e\u0003II!\u0001\b\n\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\tQ#\u0001\u0005dC:\u0004vn]5y)\t\tC\u0005\u0005\u0002\u001bE%\u00111E\u0005\u0002\b\u0005>|G.Z1o\u0011\u0015)3\u00011\u0001'\u0003\u0011\u0001\u0018\r\u001e5\u0011\u0005\u001drS\"\u0001\u0015\u000b\u0005%R\u0013\u0001\u00024jY\u0016T!a\u000b\u0017\u0002\u00079LwNC\u0001.\u0003\u0011Q\u0017M^1\n\u0005=B#\u0001\u0002)bi\"\f\u0001\u0002]8tSb$\u0015N]\u000b\u0002eA\u00191'N\u001c\u000e\u0003QR!!\u0004\u0017\n\u0005Y\"$aB#ok6\u001cV\r\u001e\t\u0003qmj\u0011!\u000f\u0006\u0003u!\n\u0011\"\u0019;ue&\u0014W\u000f^3\n\u0005qJ$a\u0005)pg&Dh)\u001b7f!\u0016\u0014X.[:tS>t\u0017!\u00039pg&DH)\u001b:!\u0003%\u0001xn]5y\r&dW-\u0001\u0006q_NL\u0007PR5mK\u0002\nQa\u00195n_\u0012$\"AQ#\u0011\u0005i\u0019\u0015B\u0001#\u0013\u0005\u0011)f.\u001b;\t\u000b\u0015B\u0001\u0019\u0001\u0014\u0002-\rDWn\u001c3GS2,wJ]\"sK\u0006$X-R7qif$\"A\u0011%\t\u000b\u0015J\u0001\u0019\u0001\u0014\u0002#\rDWn\u001c3GS2,\u0017I\u001c3Xe&$X\rF\u0002C\u00172CQ!\n\u0006A\u0002\u0019BQ!\u0014\u0006A\u00029\u000b\u0001bY8oi\u0016tGo\u001d\t\u00045=\u000b\u0016B\u0001)\u0013\u0005\u0015\t%O]1z!\tQ\"+\u0003\u0002T%\t!!)\u001f;f\u0001")
public final class OwnerOnlyChmod {
    public static void chmodFileAndWrite(Path path, byte[] byArray) {
        OwnerOnlyChmod$.MODULE$.chmodFileAndWrite(path, byArray);
    }

    public static void chmodFileOrCreateEmpty(Path path) {
        OwnerOnlyChmod$.MODULE$.chmodFileOrCreateEmpty(path);
    }

    public static void chmod(Path path) {
        OwnerOnlyChmod$.MODULE$.chmod(path);
    }
}

