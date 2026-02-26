/*
 * Decompiled with CFR 0.152.
 */
package scala.util.control;

import scala.reflect.ScalaSignature;
import scala.util.control.NoStackTrace$;

@ScalaSignature(bytes="\u0006\u0001)3q\u0001D\u0007\u0011\u0002\u0007\u0005A\u0003C\u0003\u001e\u0001\u0011\u0005a\u0004C\u0003#\u0001\u0011\u00053\u0005C\u0006%\u0001A\u0005\u0019\u0011!A\u0005\n\u0015js!\u0002\u0018\u000e\u0011\u0003yc!\u0002\u0007\u000e\u0011\u0003\t\u0004\"\u0002\u001d\u0006\t\u0003I\u0004\"\u0002\u001e\u0006\t\u000bY\u0004bB \u0006\u0001\u0004%ia\u000f\u0005\b\u0001\u0016\u0001\r\u0011\"\u0004B\u0011\u0019!U\u0001)Q\u0007y!9Q)BA\u0001\n\u00131%\u0001\u0004(p'R\f7m\u001b+sC\u000e,'B\u0001\b\u0010\u0003\u001d\u0019wN\u001c;s_2T!\u0001E\t\u0002\tU$\u0018\u000e\u001c\u0006\u0002%\u0005)1oY1mC\u000e\u00011C\u0001\u0001\u0016!\t1\"D\u0004\u0002\u001815\t\u0011#\u0003\u0002\u001a#\u00059\u0001/Y2lC\u001e,\u0017BA\u000e\u001d\u0005%!\u0006N]8xC\ndWM\u0003\u0002\u001a#\u00051A%\u001b8ji\u0012\"\u0012a\b\t\u0003/\u0001J!!I\t\u0003\tUs\u0017\u000e^\u0001\u0011M&dG.\u00138Ti\u0006\u001c7\u000e\u0016:bG\u0016$\u0012!F\u0001\u0017gV\u0004XM\u001d\u0013gS2d\u0017J\\*uC\u000e\\GK]1dKR\ta\u0005\u0005\u0002(Y5\t\u0001F\u0003\u0002*U\u0005!A.\u00198h\u0015\u0005Y\u0013\u0001\u00026bm\u0006L!a\u0007\u0015\n\u0005\tb\u0013\u0001\u0004(p'R\f7m\u001b+sC\u000e,\u0007C\u0001\u0019\u0006\u001b\u0005i1cA\u00033kA\u0011qcM\u0005\u0003iE\u0011a!\u00118z%\u00164\u0007CA\f7\u0013\t9\u0014C\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0004=S:LGO\u0010\u000b\u0002_\u0005ian\\*vaB\u0014Xm]:j_:,\u0012\u0001\u0010\t\u0003/uJ!AP\t\u0003\u000f\t{w\u000e\\3b]\u0006qqL\\8TkB\u0004(/Z:tS>t\u0017AE0o_N+\b\u000f\u001d:fgNLwN\\0%KF$\"a\b\"\t\u000f\rK\u0011\u0011!a\u0001y\u0005\u0019\u0001\u0010J\u0019\u0002\u001f}swnU;qaJ,7o]5p]\u0002\n1B]3bIJ+7o\u001c7wKR\tq\t\u0005\u0002(\u0011&\u0011\u0011\n\u000b\u0002\u0007\u001f\nTWm\u0019;")
public interface NoStackTrace {
    public static boolean noSuppression() {
        return NoStackTrace$.MODULE$.noSuppression();
    }

    public /* synthetic */ Throwable scala$util$control$NoStackTrace$$super$fillInStackTrace();

    public static /* synthetic */ Throwable fillInStackTrace$(NoStackTrace $this) {
        return $this.fillInStackTrace();
    }

    default public Throwable fillInStackTrace() {
        if (NoStackTrace$.MODULE$.noSuppression()) {
            return this.scala$util$control$NoStackTrace$$super$fillInStackTrace();
        }
        return (Throwable)((Object)this);
    }

    public static void $init$(NoStackTrace $this) {
    }
}

