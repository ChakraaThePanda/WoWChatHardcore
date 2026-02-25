/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.OffsetPosition;
import scala.reflect.internal.util.SourceFile;

@ScalaSignature(bytes="\u0006\u0001I2A!\u0003\u0006\u0001'!A\u0001\u0004\u0001B\u0001B\u0003%\u0011\u0004\u0003\u0005\u001d\u0001\t\u0005\t\u0015!\u0003\u001e\u0011!\t\u0003A!A!\u0002\u0013i\u0002\u0002\u0003\u0012\u0001\u0005\u0003\u0005\u000b\u0011B\u000f\t\u000b\r\u0002A\u0011\u0001\u0013\t\u000b)\u0002A\u0011I\u0016\t\u000b=\u0002A\u0011\t\u0019\t\u000bE\u0002A\u0011\t\u0019\u0003\u001bI\u000bgnZ3Q_NLG/[8o\u0015\tYA\"\u0001\u0003vi&d'BA\u0007\u000f\u0003!Ig\u000e^3s]\u0006d'BA\b\u0011\u0003\u001d\u0011XM\u001a7fGRT\u0011!E\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001A\u0003\u0005\u0002\u0016-5\t!\"\u0003\u0002\u0018\u0015\tqqJ\u001a4tKR\u0004vn]5uS>t\u0017\u0001C:pkJ\u001cW-\u00138\u0011\u0005UQ\u0012BA\u000e\u000b\u0005)\u0019v.\u001e:dK\u001aKG.Z\u0001\bgR\f'\u000f^%o!\tqr$D\u0001\u0011\u0013\t\u0001\u0003CA\u0002J]R\fq\u0001]8j]RLe.A\u0003f]\u0012Le.\u0001\u0004=S:LGO\u0010\u000b\u0006K\u0019:\u0003&\u000b\t\u0003+\u0001AQ\u0001G\u0003A\u0002eAQ\u0001H\u0003A\u0002uAQ!I\u0003A\u0002uAQAI\u0003A\u0002u\tq![:SC:<W-F\u0001-!\tqR&\u0003\u0002/!\t9!i\\8mK\u0006t\u0017!B:uCJ$X#A\u000f\u0002\u0007\u0015tG\r")
public class RangePosition
extends OffsetPosition {
    private final int startIn;
    private final int endIn;

    @Override
    public boolean isRange() {
        return true;
    }

    @Override
    public int start() {
        return this.startIn;
    }

    @Override
    public int end() {
        return this.endIn;
    }

    public RangePosition(SourceFile sourceIn, int startIn, int pointIn, int endIn) {
        this.startIn = startIn;
        this.endIn = endIn;
        super(sourceIn, pointIn);
    }
}

