/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Predef$;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.NoSourceFile$;
import scala.reflect.internal.util.OffsetPosition;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.RangePosition;
import scala.reflect.internal.util.SourceFile;
import scala.reflect.internal.util.TransparentPosition;

public final class Position$ {
    public static Position$ MODULE$;
    private final int tabInc;

    static {
        new Position$();
    }

    public int tabInc() {
        return this.tabInc;
    }

    /*
     * WARNING - void declaration
     */
    private <T extends Position> T validate(T pos) {
        if (pos.isRange()) {
            void assert_assertion;
            boolean bl;
            boolean bl2 = bl = pos.start() <= pos.end();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)Position$.$anonfun$validate$1(pos)).toString());
            }
        }
        return pos;
    }

    public String formatMessage(Position posIn, String msg, boolean shortenFile) {
        Position pos = posIn == null ? NoPosition$.MODULE$ : posIn;
        SourceFile sourceFile = pos.source();
        String string = NoSourceFile$.MODULE$.equals(sourceFile) ? "" : (shortenFile ? new StringBuilder(1).append(sourceFile.file().name()).append(":").toString() : new StringBuilder(1).append(sourceFile.file().path()).append(":").toString());
        return new StringBuilder(0).append(string).append(pos.showError(msg)).toString();
    }

    public Position offset(SourceFile source2, int point) {
        return this.validate(new OffsetPosition(source2, point));
    }

    public Position range(SourceFile source2, int start, int point, int end) {
        return this.validate(new RangePosition(source2, start, point, end));
    }

    public Position transparent(SourceFile source2, int start, int point, int end) {
        return this.validate(new TransparentPosition(source2, start, point, end));
    }

    public static final /* synthetic */ String $anonfun$validate$1(Position pos$1) {
        return new StringBuilder(14).append("bad position: ").append(pos$1.show()).toString();
    }

    private Position$() {
        MODULE$ = this;
        this.tabInc = 8;
    }
}

