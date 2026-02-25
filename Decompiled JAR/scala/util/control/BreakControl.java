/*
 * Decompiled with CFR 0.152.
 */
package scala.util.control;

import scala.reflect.ScalaSignature;
import scala.util.control.ControlThrowable;
import scala.util.control.NoStackTrace;

@ScalaSignature(bytes="\u0006\u0001i1AAA\u0002\u0005\u0015!)q\u0003\u0001C\u00011\ta!I]3bW\u000e{g\u000e\u001e:pY*\u0011A!B\u0001\bG>tGO]8m\u0015\t1q!\u0001\u0003vi&d'\"\u0001\u0005\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001aC\n\u0011\u00051\u0001bBA\u0007\u000f\u001b\u00059\u0011BA\b\b\u0003\u001d\u0001\u0018mY6bO\u0016L!!\u0005\n\u0003\u0013QC'o\\<bE2,'BA\b\b!\t!R#D\u0001\u0004\u0013\t12A\u0001\tD_:$(o\u001c7UQJ|w/\u00192mK\u00061A(\u001b8jiz\"\u0012!\u0007\t\u0003)\u0001\u0001")
public class BreakControl
extends Throwable
implements ControlThrowable {
    @Override
    public /* synthetic */ Throwable scala$util$control$NoStackTrace$$super$fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public Throwable fillInStackTrace() {
        return NoStackTrace.fillInStackTrace$(this);
    }

    public BreakControl() {
        NoStackTrace.$init$(this);
    }
}

