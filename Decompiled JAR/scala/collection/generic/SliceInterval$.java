/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Predef$;
import scala.collection.generic.SliceInterval;
import scala.runtime.RichInt$;

public final class SliceInterval$ {
    public static SliceInterval$ MODULE$;

    static {
        new SliceInterval$();
    }

    public SliceInterval apply(int from, int until) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int lo = RichInt$.MODULE$.max$extension(from, 0);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int hi = RichInt$.MODULE$.max$extension(until, 0);
        if (hi <= lo) {
            return new SliceInterval(lo, lo);
        }
        return new SliceInterval(lo, hi);
    }

    private SliceInterval$() {
        MODULE$ = this;
    }
}

