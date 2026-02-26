/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.collection.immutable.Set;
import scala.reflect.internal.Chars;

public final class Chars$
implements Chars {
    public static Chars$ MODULE$;
    private final char[] scala$reflect$internal$Chars$$char2uescapeArray;
    private final Set<Object> scala$reflect$internal$Chars$$otherLetters;
    private final Set<Object> scala$reflect$internal$Chars$$letterGroups;

    static {
        new Chars$();
    }

    @Override
    public int digit2int(char ch, int base) {
        return Chars.digit2int$(this, ch, base);
    }

    @Override
    public String char2uescape(char c) {
        return Chars.char2uescape$(this, c);
    }

    @Override
    public boolean isLineBreakChar(char c) {
        return Chars.isLineBreakChar$(this, c);
    }

    @Override
    public boolean isWhitespace(char c) {
        return Chars.isWhitespace$(this, c);
    }

    @Override
    public boolean isVarPart(char c) {
        return Chars.isVarPart$(this, c);
    }

    @Override
    public boolean isIdentifierStart(char c) {
        return Chars.isIdentifierStart$(this, c);
    }

    @Override
    public boolean isIdentifierPart(char c) {
        return Chars.isIdentifierPart$(this, c);
    }

    @Override
    public boolean isSpecial(char c) {
        return Chars.isSpecial$(this, c);
    }

    @Override
    public boolean isScalaLetter(char ch) {
        return Chars.isScalaLetter$(this, ch);
    }

    @Override
    public boolean isOperatorPart(char c) {
        return Chars.isOperatorPart$(this, c);
    }

    @Override
    public char[] scala$reflect$internal$Chars$$char2uescapeArray() {
        return this.scala$reflect$internal$Chars$$char2uescapeArray;
    }

    @Override
    public final Set<Object> scala$reflect$internal$Chars$$otherLetters() {
        return this.scala$reflect$internal$Chars$$otherLetters;
    }

    @Override
    public final Set<Object> scala$reflect$internal$Chars$$letterGroups() {
        return this.scala$reflect$internal$Chars$$letterGroups;
    }

    @Override
    public final void scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$char2uescapeArray_$eq(char[] x$1) {
        this.scala$reflect$internal$Chars$$char2uescapeArray = x$1;
    }

    @Override
    public final void scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$otherLetters_$eq(Set<Object> x$1) {
        this.scala$reflect$internal$Chars$$otherLetters = x$1;
    }

    @Override
    public final void scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$letterGroups_$eq(Set<Object> x$1) {
        this.scala$reflect$internal$Chars$$letterGroups = x$1;
    }

    private Chars$() {
        MODULE$ = this;
        Chars.$init$(this);
    }
}

