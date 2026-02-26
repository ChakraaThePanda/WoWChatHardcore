/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Array$;
import scala.Predef$;
import scala.collection.immutable.Set;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005Uaa\u0002\f\u0018!\u0003\r\tA\b\u0005\u0006G\u0001!\t\u0001\n\u0005\bQ\u0001\u0011\r\u0011\"\u0002*\u0011\u001da\u0003A1A\u0005\u00065Bq\u0001\r\u0001C\u0002\u0013\u0015\u0011\u0007C\u00045\u0001\t\u0007IQA\u001b\t\u000ba\u0002A\u0011A\u001d\t\u000f\u0011\u0003!\u0019)C\u0005\u000b\")\u0011\n\u0001C\u0001\u0015\")\u0001\f\u0001C\u00013\")a\f\u0001C\u0001?\")\u0011\r\u0001C\u0001E\")A\r\u0001C\u0001K\")q\r\u0001C\u0001Q\")!\u000e\u0001C\u0001W\"9Q\u000e\u0001b\u0001\n\u001bq\u0007bB<\u0001\u0005\u0004%i\u0001\u001f\u0005\u0006{\u0002!\tA \u0005\b\u0003\u0003\u0001A\u0011AA\u0002\u000f\u001d\t9a\u0006E\u0001\u0003\u00131aAF\f\t\u0002\u00055\u0001bBA\t)\u0011\u0005\u00111\u0003\u0002\u0006\u0007\"\f'o\u001d\u0006\u00031e\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u00035m\tqA]3gY\u0016\u001cGOC\u0001\u001d\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001A\u0010\u0011\u0005\u0001\nS\"A\u000e\n\u0005\tZ\"AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0002KA\u0011\u0001EJ\u0005\u0003Om\u0011A!\u00168ji\u0006\u0011AJR\u000b\u0002U=\t1\u0006H\u0001\u000b\u0003\t1e)F\u0001/\u001f\u0005yC$\u0001\u0007\u0002\u0005\r\u0013V#\u0001\u001a\u0010\u0003Mb\u0012!D\u0001\u0003'V+\u0012AN\b\u0002oq\t!$A\u0005eS\u001eLGOM5oiR\u0019!(\u0010\"\u0011\u0005\u0001Z\u0014B\u0001\u001f\u001c\u0005\rIe\u000e\u001e\u0005\u0006}\u0019\u0001\raP\u0001\u0003G\"\u0004\"\u0001\t!\n\u0005\u0005[\"\u0001B\"iCJDQa\u0011\u0004A\u0002i\nAAY1tK\u0006\t2\r[1seU,7oY1qK\u0006\u0013(/Y=\u0016\u0003\u0019\u00032\u0001I$@\u0013\tA5DA\u0003BeJ\f\u00170\u0001\u0007dQ\u0006\u0014('^3tG\u0006\u0004X\r\u0006\u0002L-B\u0011Aj\u0015\b\u0003\u001bF\u0003\"AT\u000e\u000e\u0003=S!\u0001U\u000f\u0002\rq\u0012xn\u001c;?\u0013\t\u00116$\u0001\u0004Qe\u0016$WMZ\u0005\u0003)V\u0013aa\u0015;sS:<'B\u0001*\u001c\u0011\u00159\u0006\u00021\u0001@\u0003\u0005\u0019\u0017aD5t\u0019&tWM\u0011:fC.\u001c\u0005.\u0019:\u0015\u0005ik\u0006C\u0001\u0011\\\u0013\ta6DA\u0004C_>dW-\u00198\t\u000b]K\u0001\u0019A \u0002\u0019%\u001cx\u000b[5uKN\u0004\u0018mY3\u0015\u0005i\u0003\u0007\"B,\u000b\u0001\u0004y\u0014!C5t-\u0006\u0014\b+\u0019:u)\tQ6\rC\u0003X\u0017\u0001\u0007q(A\tjg&#WM\u001c;jM&,'o\u0015;beR$\"A\u00174\t\u000b]c\u0001\u0019A \u0002!%\u001c\u0018\nZ3oi&4\u0017.\u001a:QCJ$HC\u0001.j\u0011\u00159V\u00021\u0001@\u0003%I7o\u00159fG&\fG\u000e\u0006\u0002[Y\")qK\u0004a\u0001\u007f\u0005aq\u000e\u001e5fe2+G\u000f^3sgV\tq\u000eE\u0002qk~j\u0011!\u001d\u0006\u0003eN\f\u0011\"[7nkR\f'\r\\3\u000b\u0005Q\\\u0012AC2pY2,7\r^5p]&\u0011a/\u001d\u0002\u0004'\u0016$\u0018\u0001\u00047fiR,'o\u0012:pkB\u001cX#A=\u0011\u0007A,(\u0010\u0005\u0002!w&\u0011Ap\u0007\u0002\u0005\u0005f$X-A\u0007jgN\u001b\u0017\r\\1MKR$XM\u001d\u000b\u00035~DQAP\tA\u0002}\na\"[:Pa\u0016\u0014\u0018\r^8s!\u0006\u0014H\u000fF\u0002[\u0003\u000bAQa\u0016\nA\u0002}\nQa\u00115beN\u00042!a\u0003\u0015\u001b\u000592\u0003\u0002\u000b \u0003\u001f\u00012!a\u0003\u0001\u0003\u0019a\u0014N\\5u}Q\u0011\u0011\u0011\u0002")
public interface Chars {
    public void scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$char2uescapeArray_$eq(char[] var1);

    public void scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$otherLetters_$eq(Set<Object> var1);

    public void scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$letterGroups_$eq(Set<Object> var1);

    public static /* synthetic */ char LF$(Chars $this) {
        return $this.LF();
    }

    default public char LF() {
        return '\n';
    }

    public static /* synthetic */ char FF$(Chars $this) {
        return $this.FF();
    }

    default public char FF() {
        return '\f';
    }

    public static /* synthetic */ char CR$(Chars $this) {
        return $this.CR();
    }

    default public char CR() {
        return '\r';
    }

    public static /* synthetic */ char SU$(Chars $this) {
        return $this.SU();
    }

    default public char SU() {
        return '\u001a';
    }

    public static /* synthetic */ int digit2int$(Chars $this, char ch, int base) {
        return $this.digit2int(ch, base);
    }

    default public int digit2int(char ch, int base) {
        int num;
        int n = ch <= '9' ? ch - 48 : ('a' <= ch && ch <= 'z' ? ch - 97 + 10 : (num = 'A' <= ch && ch <= 'Z' ? ch - 65 + 10 : -1));
        if (0 <= num && num < base) {
            return num;
        }
        return -1;
    }

    public char[] scala$reflect$internal$Chars$$char2uescapeArray();

    public static /* synthetic */ String char2uescape$(Chars $this, char c) {
        return $this.char2uescape(c);
    }

    default public String char2uescape(char c) {
        int hexChar$1_ch = c >> 12;
        this.scala$reflect$internal$Chars$$char2uescapeArray()[2] = (char)((hexChar$1_ch < 10 ? 48 : 55) + hexChar$1_ch);
        int hexChar$1_ch2 = (c >> 8) % 16;
        this.scala$reflect$internal$Chars$$char2uescapeArray()[3] = (char)((hexChar$1_ch2 < 10 ? 48 : 55) + hexChar$1_ch2);
        int hexChar$1_ch3 = (c >> 4) % 16;
        this.scala$reflect$internal$Chars$$char2uescapeArray()[4] = (char)((hexChar$1_ch3 < 10 ? 48 : 55) + hexChar$1_ch3);
        int hexChar$1_ch4 = c % 16;
        this.scala$reflect$internal$Chars$$char2uescapeArray()[5] = (char)((hexChar$1_ch4 < 10 ? 48 : 55) + hexChar$1_ch4);
        return new String(this.scala$reflect$internal$Chars$$char2uescapeArray());
    }

    public static /* synthetic */ boolean isLineBreakChar$(Chars $this, char c) {
        return $this.isLineBreakChar(c);
    }

    default public boolean isLineBreakChar(char c) {
        switch (c) {
            case '\n': 
            case '\f': 
            case '\r': 
            case '\u001a': {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isWhitespace$(Chars $this, char c) {
        return $this.isWhitespace(c);
    }

    default public boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\r';
    }

    public static /* synthetic */ boolean isVarPart$(Chars $this, char c) {
        return $this.isVarPart(c);
    }

    default public boolean isVarPart(char c) {
        return '0' <= c && c <= '9' || 'A' <= c && c <= 'Z' || 'a' <= c && c <= 'z';
    }

    public static /* synthetic */ boolean isIdentifierStart$(Chars $this, char c) {
        return $this.isIdentifierStart(c);
    }

    default public boolean isIdentifierStart(char c) {
        return c == '_' || c == '$' || Character.isUnicodeIdentifierStart(c);
    }

    public static /* synthetic */ boolean isIdentifierPart$(Chars $this, char c) {
        return $this.isIdentifierPart(c);
    }

    default public boolean isIdentifierPart(char c) {
        return c == '$' || Character.isUnicodeIdentifierPart(c);
    }

    public static /* synthetic */ boolean isSpecial$(Chars $this, char c) {
        return $this.isSpecial(c);
    }

    default public boolean isSpecial(char c) {
        int chtp = Character.getType(c);
        return chtp == 25 || chtp == 28;
    }

    public Set<Object> scala$reflect$internal$Chars$$otherLetters();

    public Set<Object> scala$reflect$internal$Chars$$letterGroups();

    public static /* synthetic */ boolean isScalaLetter$(Chars $this, char ch) {
        return $this.isScalaLetter(ch);
    }

    default public boolean isScalaLetter(char ch) {
        return this.scala$reflect$internal$Chars$$letterGroups().apply(BoxesRunTime.boxToByte((byte)Character.getType(ch))) || this.scala$reflect$internal$Chars$$otherLetters().apply(BoxesRunTime.boxToCharacter(ch));
    }

    public static /* synthetic */ boolean isOperatorPart$(Chars $this, char c) {
        return $this.isOperatorPart(c);
    }

    default public boolean isOperatorPart(char c) {
        switch (c) {
            case '!': 
            case '#': 
            case '%': 
            case '&': 
            case '*': 
            case '+': 
            case '-': 
            case '/': 
            case ':': 
            case '<': 
            case '=': 
            case '>': 
            case '?': 
            case '@': 
            case '\\': 
            case '^': 
            case '|': 
            case '~': {
                return true;
            }
        }
        return this.isSpecial(c);
    }

    private static char hexChar$1(int ch) {
        return (char)((ch < 10 ? 48 : 55) + ch);
    }

    public static void $init$(Chars $this) {
        $this.scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$char2uescapeArray_$eq((char[])Array$.MODULE$.apply(Predef$.MODULE$.wrapCharArray(new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'}), ClassTag$.MODULE$.Char()));
        $this.scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$otherLetters_$eq((Set)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapCharArray(new char[]{'$', '_'})));
        $this.scala$reflect$internal$Chars$_setter_$scala$reflect$internal$Chars$$letterGroups_$eq((Set)Predef$.MODULE$.Set().apply(Predef$.MODULE$.wrapByteArray(new byte[]{2, 1, 5, 3, 10})));
    }
}

