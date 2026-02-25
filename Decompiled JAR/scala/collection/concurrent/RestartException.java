/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import java.io.PrintStream;
import java.io.PrintWriter;
import scala.collection.concurrent.RestartException$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u00011:a\u0001B\u0003\t\u0002\u0015YaAB\u0007\u0006\u0011\u0003)a\u0002C\u0003 \u0003\u0011\u0005\u0011\u0005C\u0004#\u0003\u0005\u0005I\u0011B\u0012\u0002!I+7\u000f^1si\u0016C8-\u001a9uS>t'B\u0001\u0004\b\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0003\u0011%\t!bY8mY\u0016\u001cG/[8o\u0015\u0005Q\u0011!B:dC2\f\u0007C\u0001\u0007\u0002\u001b\u0005)!\u0001\u0005*fgR\f'\u000f^#yG\u0016\u0004H/[8o'\r\tqb\u0006\t\u0003!Qq!!\u0005\n\u000e\u0003%I!aE\u0005\u0002\u000fA\f7m[1hK&\u0011QC\u0006\u0002\n)\"\u0014xn^1cY\u0016T!aE\u0005\u0011\u0005aiR\"A\r\u000b\u0005iY\u0012aB2p]R\u0014x\u000e\u001c\u0006\u00039%\tA!\u001e;jY&\u0011a$\u0007\u0002\u0011\u0007>tGO]8m)\"\u0014xn^1cY\u0016\fa\u0001P5oSRt4\u0001\u0001\u000b\u0002\u0017\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\u0005!\u0003CA\u0013+\u001b\u00051#BA\u0014)\u0003\u0011a\u0017M\\4\u000b\u0003%\nAA[1wC&\u00111F\n\u0002\u0007\u001f\nTWm\u0019;")
public final class RestartException {
    public static Throwable fillInStackTrace() {
        return RestartException$.MODULE$.fillInStackTrace();
    }

    public static Throwable[] getSuppressed() {
        return RestartException$.MODULE$.getSuppressed();
    }

    public static void addSuppressed(Throwable throwable) {
        RestartException$.MODULE$.addSuppressed(throwable);
    }

    public static void setStackTrace(StackTraceElement[] stackTraceElementArray) {
        RestartException$.MODULE$.setStackTrace(stackTraceElementArray);
    }

    public static StackTraceElement[] getStackTrace() {
        return RestartException$.MODULE$.getStackTrace();
    }

    public static void printStackTrace(PrintWriter printWriter) {
        RestartException$.MODULE$.printStackTrace(printWriter);
    }

    public static void printStackTrace(PrintStream printStream) {
        RestartException$.MODULE$.printStackTrace(printStream);
    }

    public static void printStackTrace() {
        RestartException$.MODULE$.printStackTrace();
    }

    public static String toString() {
        return RestartException$.MODULE$.toString();
    }

    public static Throwable initCause(Throwable throwable) {
        return RestartException$.MODULE$.initCause(throwable);
    }

    public static Throwable getCause() {
        return RestartException$.MODULE$.getCause();
    }

    public static String getLocalizedMessage() {
        return RestartException$.MODULE$.getLocalizedMessage();
    }

    public static String getMessage() {
        return RestartException$.MODULE$.getMessage();
    }
}

