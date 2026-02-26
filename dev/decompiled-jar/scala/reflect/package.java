/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import java.lang.reflect.AccessibleObject;
import scala.reflect.ClassManifestFactory$;
import scala.reflect.ClassTag;
import scala.reflect.ManifestFactory$;
import scala.reflect.ScalaSignature;
import scala.reflect.package$;

@ScalaSignature(bytes="\u0006\u0001%<Qa\u0003\u0007\t\u0002E1Qa\u0005\u0007\t\u0002QAQ!G\u0001\u0005\u0002i)AaG\u0001\u00019!9A(\u0001b\u0001\n\u0003i\u0004B\u0002\"\u0002A\u0003%a\bC\u0004E\u0003\t\u0007I\u0011A#\t\r%\u000b\u0001\u0015!\u0003G\u0011\u0015Q\u0015\u0001\"\u0001L\u0011\u0015\u0011\u0016\u0001\"\u0001T\u0011\u001d\u0019\u0017A!C\u0001\u001d\u0011\fq\u0001]1dW\u0006<WM\u0003\u0002\u000e\u001d\u00059!/\u001a4mK\u000e$(\"A\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u0011!#A\u0007\u0002\u0019\t9\u0001/Y2lC\u001e,7CA\u0001\u0016!\t1r#D\u0001\u000f\u0013\tAbB\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003E\u0011Qb\u00117bgNl\u0015M\\5gKN$XCA\u000f#!\r\u0011b\u0004I\u0005\u0003?1\u0011\u0001b\u00117bgN$\u0016m\u001a\t\u0003C\tb\u0001\u0001B\u0003$\u0007\t\u0007AEA\u0001U#\t)\u0003\u0006\u0005\u0002\u0017M%\u0011qE\u0004\u0002\b\u001d>$\b.\u001b8h!\t1\u0012&\u0003\u0002+\u001d\t\u0019\u0011I\\=)\u0007\ra#\u0007\u0005\u0002.a5\taF\u0003\u00020\u001d\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005Er#\u0001E5na2L7-\u001b;O_R4u.\u001e8eC\u0005\u0019\u0014\u0001\n(pA\rc\u0017m]:NC:Lg-Z:uA\u00054\u0018-\u001b7bE2,\u0007EZ8sA\u0011ZH+ \u0018)\t\r)\u0004H\u000f\t\u0003-YJ!a\u000e\b\u0003\u0015\u0011,\u0007O]3dCR,G-I\u0001:\u0003\t*8/\u001a\u0011tG\u0006d\u0017M\f:fM2,7\r\u001e\u0018DY\u0006\u001c8\u000fV1hA%t7\u000f^3bI\u0006\n1(\u0001\u00043]E\u0002d\u0006M\u0001\u000e\u00072\f7o]'b]&4Wm\u001d;\u0016\u0003yr!AE \n\u0005\u0001c\u0011\u0001F\"mCN\u001cX*\u00198jM\u0016\u001cHOR1di>\u0014\u0018\u0010\u000b\u0003\u0005kaR\u0014AD\"mCN\u001cX*\u00198jM\u0016\u001cH\u000f\t\u0015\u0005\u000bUB$(\u0001\u0005NC:Lg-Z:u+\u00051eB\u0001\nH\u0013\tAE\"A\bNC:Lg-Z:u\r\u0006\u001cGo\u001c:z\u0003%i\u0015M\\5gKN$\b%\u0001\u0005dY\u0006\u001c8\u000fV1h+\tau\n\u0006\u0002N!B\u0019!C\b(\u0011\u0005\u0005zE!B\u0012\t\u0005\u0004!\u0003\"B)\t\u0001\bi\u0015\u0001B2uC\u001e\f\u0001#\u001a8tkJ,\u0017iY2fgNL'\r\\3\u0016\u0005Q3FCA+b!\t\tc\u000bB\u0003$\u0013\t\u0007q+\u0005\u0002&1B\u0011\u0011lX\u0007\u00025*\u0011Qb\u0017\u0006\u00039v\u000bA\u0001\\1oO*\ta,\u0001\u0003kCZ\f\u0017B\u00011[\u0005A\t5mY3tg&\u0014G.Z(cU\u0016\u001cG\u000fC\u0003c\u0013\u0001\u0007Q+A\u0001n\u0003Mi\u0017\r^3sS\u0006d\u0017N_3DY\u0006\u001c8\u000fV1h+\t)\u0007\u000eF\u0001g!\r\u0011bd\u001a\t\u0003C!$Qa\t\u0006C\u0002\u0011\u0002")
public final class package {
    public static <T extends AccessibleObject> T ensureAccessible(T t) {
        return package$.MODULE$.ensureAccessible(t);
    }

    public static <T> ClassTag<T> classTag(ClassTag<T> classTag) {
        return package$.MODULE$.classTag(classTag);
    }

    public static ManifestFactory$ Manifest() {
        return package$.MODULE$.Manifest();
    }

    public static ClassManifestFactory$ ClassManifest() {
        return package$.MODULE$.ClassManifest();
    }
}

