/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Serializable;
import scala.collection.immutable.Range;

public final class Range$
implements Serializable {
    public static Range$ MODULE$;

    static {
        new Range$();
    }

    public int count(int start, int end, int step, boolean isInclusive) {
        if (step == 0) {
            throw new IllegalArgumentException("step cannot be 0.");
        }
        boolean bl = start == end ? !isInclusive : (start < end ? step < 0 : step > 0);
        if (bl) {
            return 0;
        }
        long gap = (long)end - (long)start;
        long jumps = gap / (long)step;
        boolean hasStub = isInclusive || gap % (long)step != 0L;
        long result2 = jumps + (long)(hasStub ? 1 : 0);
        if (result2 > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)result2;
    }

    public int count(int start, int end, int step) {
        return this.count(start, end, step, false);
    }

    public Range apply(int start, int end, int step) {
        return new Range(start, end, step);
    }

    public Range apply(int start, int end) {
        return new Range(start, end, 1);
    }

    public Range.Inclusive inclusive(int start, int end, int step) {
        return new Range.Inclusive(start, end, step);
    }

    public Range.Inclusive inclusive(int start, int end) {
        return new Range.Inclusive(start, end, 1);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Range$() {
        MODULE$ = this;
    }
}

