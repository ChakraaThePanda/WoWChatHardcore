/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Array$;
import scala.collection.Iterator;
import scala.collection.immutable.Nil$;
import scala.package$;
import scala.reflect.ClassTag$;
import scala.reflect.internal.util.NoFile$;
import scala.reflect.internal.util.SourceFile;
import scala.runtime.Nothing$;

public final class NoSourceFile$
extends SourceFile {
    public static NoSourceFile$ MODULE$;

    static {
        new NoSourceFile$();
    }

    @Override
    public char[] content() {
        return (char[])Array$.MODULE$.apply(Nil$.MODULE$, ClassTag$.MODULE$.Char());
    }

    @Override
    public NoFile$ file() {
        return NoFile$.MODULE$;
    }

    @Override
    public boolean isLineBreak(int idx) {
        return false;
    }

    @Override
    public boolean isEndOfLine(int idx) {
        return false;
    }

    @Override
    public boolean isSelfContained() {
        return true;
    }

    @Override
    public int length() {
        return -1;
    }

    @Override
    public int lineCount() {
        return 0;
    }

    @Override
    public int offsetToLine(int offset) {
        return -1;
    }

    @Override
    public int lineToOffset(int index) {
        return -1;
    }

    public Iterator<Nothing$> lines(int start, int end) {
        return package$.MODULE$.Iterator().empty();
    }

    @Override
    public String toString() {
        return "<no source file>";
    }

    private NoSourceFile$() {
        MODULE$ = this;
    }
}

