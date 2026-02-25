/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.ExecutionContextExecutorService;
import scala.concurrent.JavaConversions$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u00015:Q!\u0002\u0004\t\u0002-1Q!\u0004\u0004\t\u00029AQaE\u0001\u0005\u0002QAQ!F\u0001\u0005\u0004YAQ!F\u0001\u0005\u0004\u0015\nqBS1wC\u000e{gN^3sg&|gn\u001d\u0006\u0003\u000f!\t!bY8oGV\u0014(/\u001a8u\u0015\u0005I\u0011!B:dC2\f7\u0001\u0001\t\u0003\u0019\u0005i\u0011A\u0002\u0002\u0010\u0015\u00064\u0018mQ8om\u0016\u00148/[8ogN\u0011\u0011a\u0004\t\u0003!Ei\u0011\u0001C\u0005\u0003%!\u0011a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001\f\u0003I\t7/\u0012=fGV$\u0018n\u001c8D_:$X\r\u001f;\u0015\u0005]Q\u0002C\u0001\u0007\u0019\u0013\tIbAA\u0010Fq\u0016\u001cW\u000f^5p]\u000e{g\u000e^3yi\u0016CXmY;u_J\u001cVM\u001d<jG\u0016DQaG\u0002A\u0002q\tA!\u001a=fGB\u0011QdI\u0007\u0002=)\u0011qa\b\u0006\u0003A\u0005\nA!\u001e;jY*\t!%\u0001\u0003kCZ\f\u0017B\u0001\u0013\u001f\u0005=)\u00050Z2vi>\u00148+\u001a:wS\u000e,GC\u0001\u0014*!\taq%\u0003\u0002)\r\tAR\t_3dkRLwN\\\"p]R,\u0007\u0010^#yK\u000e,Ho\u001c:\t\u000bm!\u0001\u0019\u0001\u0016\u0011\u0005uY\u0013B\u0001\u0017\u001f\u0005!)\u00050Z2vi>\u0014\b")
public final class JavaConversions {
    public static ExecutionContextExecutor asExecutionContext(Executor executor) {
        return JavaConversions$.MODULE$.asExecutionContext(executor);
    }

    public static ExecutionContextExecutorService asExecutionContext(ExecutorService executorService) {
        return JavaConversions$.MODULE$.asExecutionContext(executorService);
    }
}

