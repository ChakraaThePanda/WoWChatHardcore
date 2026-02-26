/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import scala.collection.concurrent.Debug$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001E:aa\u0002\u0005\t\u0002!qaA\u0002\t\t\u0011\u0003A\u0011\u0003C\u0003\u0017\u0003\u0011\u0005\u0001\u0004\u0003\u0005\u001a\u0003!\u0015\r\u0011\"\u0001\u001b\u0011\u0015!\u0013\u0001\"\u0001&\u0011\u0015Y\u0013\u0001\"\u0001-\u0011\u0015\u0001\u0014\u0001\"\u0001-\u0003\u0015!UMY;h\u0015\tI!\"\u0001\u0006d_:\u001cWO\u001d:f]RT!a\u0003\u0007\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u000e\u0003\u0015\u00198-\u00197b!\ty\u0011!D\u0001\t\u0005\u0015!UMY;h'\t\t!\u0003\u0005\u0002\u0014)5\tA\"\u0003\u0002\u0016\u0019\t1\u0011I\\=SK\u001a\fa\u0001P5oSRt4\u0001\u0001\u000b\u0002\u001d\u0005IAn\\4ck\u001a4WM]\u000b\u00027A\u0019AD\t\n\u000e\u0003uQ!!\u0003\u0010\u000b\u0005}\u0001\u0013\u0001B;uS2T\u0011!I\u0001\u0005U\u00064\u0018-\u0003\u0002$;\t)2i\u001c8dkJ\u0014XM\u001c;MS:\\W\rZ)vKV,\u0017a\u00017pOR\u0011a%\u000b\t\u0003'\u001dJ!\u0001\u000b\u0007\u0003\u000f\t{w\u000e\\3b]\")!\u0006\u0002a\u0001%\u0005\t1/A\u0003gYV\u001c\b\u000eF\u0001.!\t\u0019b&\u0003\u00020\u0019\t!QK\\5u\u0003\u0015\u0019G.Z1s\u0001")
public final class Debug {
    public static void clear() {
        Debug$.MODULE$.clear();
    }

    public static void flush() {
        Debug$.MODULE$.flush();
    }

    public static boolean log(Object object) {
        return Debug$.MODULE$.log(object);
    }

    public static ConcurrentLinkedQueue<Object> logbuffer() {
        return Debug$.MODULE$.logbuffer();
    }
}

