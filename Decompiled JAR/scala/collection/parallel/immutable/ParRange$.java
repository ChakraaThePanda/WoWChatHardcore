/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Serializable;
import scala.collection.immutable.Range;
import scala.collection.parallel.immutable.ParRange;

public final class ParRange$
implements Serializable {
    public static ParRange$ MODULE$;

    static {
        new ParRange$();
    }

    public ParRange apply(int start, int end, int step, boolean inclusive) {
        return new ParRange(inclusive ? new Range.Inclusive(start, end, step) : new Range(start, end, step));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private ParRange$() {
        MODULE$ = this;
    }
}

