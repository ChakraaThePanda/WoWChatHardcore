/*
 * Decompiled with CFR 0.152.
 */
package scala.sys;

import scala.Function0;
import scala.collection.IndexedSeq;
import scala.collection.immutable.Map;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.sys.ShutdownHookThread;
import scala.sys.SystemProperties;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\u0019<Qa\u0003\u0007\t\u0002E1Qa\u0005\u0007\t\u0002QAQ!G\u0001\u0005\u0002iAQaG\u0001\u0005\u0002qAQ!L\u0001\u0005\u00029BQ!L\u0001\u0005\u0002=BQ!N\u0001\u0005\u0002YBQaP\u0001\u0005\u0002\u0001CQ\u0001R\u0001\u0005\u0002\u0015CQAT\u0001\u0005\u0002=CQaW\u0001\u0005\u0002q\u000bq\u0001]1dW\u0006<WM\u0003\u0002\u000e\u001d\u0005\u00191/_:\u000b\u0003=\tQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002\u0013\u00035\tABA\u0004qC\u000e\\\u0017mZ3\u0014\u0005\u0005)\u0002C\u0001\f\u0018\u001b\u0005q\u0011B\u0001\r\u000f\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012!E\u0001\u0006KJ\u0014xN\u001d\u000b\u0003;\u0001\u0002\"A\u0006\u0010\n\u0005}q!a\u0002(pi\"Lgn\u001a\u0005\u0006C\r\u0001\rAI\u0001\b[\u0016\u001c8/Y4f!\t\u0019#F\u0004\u0002%QA\u0011QED\u0007\u0002M)\u0011q\u0005E\u0001\u0007yI|w\u000e\u001e \n\u0005%r\u0011A\u0002)sK\u0012,g-\u0003\u0002,Y\t11\u000b\u001e:j]\u001eT!!\u000b\b\u0002\t\u0015D\u0018\u000e\u001e\u000b\u0002;Q\u0011Q\u0004\r\u0005\u0006c\u0015\u0001\rAM\u0001\u0007gR\fG/^:\u0011\u0005Y\u0019\u0014B\u0001\u001b\u000f\u0005\rIe\u000e^\u0001\beVtG/[7f+\u00059\u0004C\u0001\u001d>\u001b\u0005I$B\u0001\u001e<\u0003\u0011a\u0017M\\4\u000b\u0003q\nAA[1wC&\u0011a(\u000f\u0002\b%VtG/[7f\u0003\u0015\u0001(o\u001c9t+\u0005\t\u0005C\u0001\nC\u0013\t\u0019EB\u0001\tTsN$X-\u001c)s_B,'\u000f^5fg\u0006\u0019QM\u001c<\u0016\u0003\u0019\u0003Ba\u0012'#E5\t\u0001J\u0003\u0002J\u0015\u0006I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u0003\u0017:\t!bY8mY\u0016\u001cG/[8o\u0013\ti\u0005JA\u0002NCB\fq\"\u00193e'\",H\u000fZ8x]\"{wn\u001b\u000b\u0003!N\u0003\"AE)\n\u0005Ic!AE*ikR$wn\u001e8I_>\\G\u000b\u001b:fC\u0012Da\u0001V\u0005\u0005\u0002\u0004)\u0016\u0001\u00022pIf\u00042A\u0006,Y\u0013\t9fB\u0001\u0005=Eft\u0017-\\3?!\t1\u0012,\u0003\u0002[\u001d\t!QK\\5u\u0003)\tG\u000e\u001c+ie\u0016\fGm\u001d\u000b\u0002;B\u0019a\fY2\u000f\u0005Yy\u0016BA\u0006\u000f\u0013\t\t'M\u0001\u0006J]\u0012,\u00070\u001a3TKFT!a\u0003\b\u0011\u0005a\"\u0017BA3:\u0005\u0019!\u0006N]3bI\u0002")
public final class package {
    public static IndexedSeq<Thread> allThreads() {
        return package$.MODULE$.allThreads();
    }

    public static ShutdownHookThread addShutdownHook(Function0<BoxedUnit> function0) {
        return package$.MODULE$.addShutdownHook(function0);
    }

    public static Map<String, String> env() {
        return package$.MODULE$.env();
    }

    public static SystemProperties props() {
        return package$.MODULE$.props();
    }

    public static Runtime runtime() {
        return package$.MODULE$.runtime();
    }

    public static Nothing$ exit(int n) {
        return package$.MODULE$.exit(n);
    }

    public static Nothing$ exit() {
        return package$.MODULE$.exit();
    }

    public static Nothing$ error(String string) {
        return package$.MODULE$.error(string);
    }
}

