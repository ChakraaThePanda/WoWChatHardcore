/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function1;
import scala.math.Ordered;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Precedence$;

@ScalaSignature(bytes="\u0006\u0001\u00055a\u0001B\u000b\u0017\u0005uA\u0001b\u000b\u0001\u0003\u0006\u0004%\t\u0001\f\u0005\ta\u0001\u0011\t\u0011)A\u0005[!a\u0011\u0007\u0001C\u0001\u0002\u0003\u0005\t\u0011!C\u0005e!)A\u0007\u0001C\u0001k!)\u0001\b\u0001C!s!9Q\tAA\u0001\n\u00032\u0005bB$\u0001\u0003\u0003%\t\u0005S\u0004\u0006#ZA\tA\u0015\u0004\u0006+YA\ta\u0015\u0005\u0006c%!\tA\u0017\u0005\b7&\u0011\r\u0011\"\u0003]\u0011\u0019!\u0017\u0002)A\u0005;\")Q-\u0003C\u0005M\")\u0011.\u0003C\u0005U\")\u0001/\u0003C\u0001c\")\u0001/\u0003C\u0001g\")Q/\u0003C\u0003m\")10\u0003C\u0003y\"9a0CA\u0001\n\u000by\b\"CA\u0002\u0013\u0005\u0005IQAA\u0003\u0005)\u0001&/Z2fI\u0016t7-\u001a\u0006\u0003/a\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u00033i\tqA]3gY\u0016\u001cGOC\u0001\u001c\u0003\u0015\u00198-\u00197b\u0007\u0001\u00192\u0001\u0001\u0010#!\ty\u0002%D\u0001\u001b\u0013\t\t#D\u0001\u0004B]f4\u0016\r\u001c\t\u0004G\u0019JcBA\u0010%\u0013\t)#$A\u0004qC\u000e\\\u0017mZ3\n\u0005\u001dB#aB(sI\u0016\u0014X\r\u001a\u0006\u0003Ki\u0001\"A\u000b\u0001\u000e\u0003Y\tQ\u0001\\3wK2,\u0012!\f\t\u0003?9J!a\f\u000e\u0003\u0007%sG/\u0001\u0004mKZ,G\u000eI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005%\u001a\u0004\"B\u0016\u0004\u0001\u0004i\u0013aB2p[B\f'/\u001a\u000b\u0003[YBQa\u000e\u0003A\u0002%\nA\u0001\u001e5bi\u0006AAo\\*ue&tw\rF\u0001;!\tY$I\u0004\u0002=\u0001B\u0011QHG\u0007\u0002})\u0011q\bH\u0001\u0007yI|w\u000e\u001e \n\u0005\u0005S\u0012A\u0002)sK\u0012,g-\u0003\u0002D\t\n11\u000b\u001e:j]\u001eT!!\u0011\u000e\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012!L\u0001\u0007KF,\u0018\r\\:\u0015\u0005%c\u0005CA\u0010K\u0013\tY%DA\u0004C_>dW-\u00198\t\u000f5;\u0011\u0011!a\u0001\u001d\u0006\u0019\u0001\u0010J\u0019\u0011\u0005}y\u0015B\u0001)\u001b\u0005\r\te._\u0001\u000b!J,7-\u001a3f]\u000e,\u0007C\u0001\u0016\n'\rIAk\u0016\t\u0003?UK!A\u0016\u000e\u0003\r\u0005s\u0017PU3g!\u0011y\u0002,L\u0015\n\u0005eS\"!\u0003$v]\u000e$\u0018n\u001c82)\u0005\u0011\u0016!C#se>\u0014h*Y7f+\u0005i\u0006C\u00010d\u001b\u0005y&B\u00011b\u0003\u0011a\u0017M\\4\u000b\u0003\t\fAA[1wC&\u00111iX\u0001\u000b\u000bJ\u0014xN\u001d(b[\u0016\u0004\u0013AD5t\u0003N\u001c\u0018n\u001a8nK:$x\n\u001d\u000b\u0003\u0013\u001eDQ\u0001[\u0007A\u0002i\nAA\\1nK\u0006Ia-\u001b:ti\u000eC\u0017M\u001d\u000b\u0003S-DQ\u0001\u001c\bA\u00025\f!a\u00195\u0011\u0005}q\u0017BA8\u001b\u0005\u0011\u0019\u0005.\u0019:\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0005%\u0012\b\"B\u0016\u0010\u0001\u0004iCCA\u0015u\u0011\u0015A\u0007\u00031\u0001;\u0003E\u0019w.\u001c9be\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0003of$\"!\f=\t\u000b]\n\u0002\u0019A\u0015\t\u000bi\f\u0002\u0019A\u0015\u0002\u000b\u0011\"\b.[:\u0002%Q|7\u000b\u001e:j]\u001e$S\r\u001f;f]NLwN\u001c\u000b\u0003suDQA\u001f\nA\u0002%\n!\u0003[1tQ\u000e{G-\u001a\u0013fqR,gn]5p]R\u0019a)!\u0001\t\u000bi\u001c\u0002\u0019A\u0015\u0002!\u0015\fX/\u00197tI\u0015DH/\u001a8tS>tG\u0003BA\u0004\u0003\u0017!2!SA\u0005\u0011\u001diE#!AA\u00029CQA\u001f\u000bA\u0002%\u0002")
public final class Precedence
implements Ordered<Precedence> {
    private final int level;

    public static boolean equals$extension(int n, Object object) {
        return Precedence$.MODULE$.equals$extension(n, object);
    }

    public static int hashCode$extension(int n) {
        return Precedence$.MODULE$.hashCode$extension(n);
    }

    public static String toString$extension(int n) {
        return Precedence$.MODULE$.toString$extension(n);
    }

    public static int compare$extension(int n, int n2) {
        return Precedence$.MODULE$.compare$extension(n, n2);
    }

    public static int apply(String string) {
        return Precedence$.MODULE$.apply(string);
    }

    public static int apply(int n) {
        return Precedence$.MODULE$.apply(n);
    }

    public static <A> Function1<Object, A> andThen(Function1<Precedence, A> function1) {
        Precedence$ precedence$ = Precedence$.MODULE$;
        if (precedence$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(precedence$, function1, arg_0);
    }

    public static <A> Function1<A, Precedence> compose(Function1<A, Object> function1) {
        Precedence$ precedence$ = Precedence$.MODULE$;
        if (precedence$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(precedence$, function1, arg_0);
    }

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    public int level() {
        return this.level;
    }

    @Override
    public int compare(int that) {
        return Precedence$.MODULE$.compare$extension(this.level(), that);
    }

    public String toString() {
        return Precedence$.MODULE$.toString$extension(this.level());
    }

    public int hashCode() {
        return Precedence$.MODULE$.hashCode$extension(this.level());
    }

    public boolean equals(Object x$1) {
        return Precedence$.MODULE$.equals$extension(this.level(), x$1);
    }

    public Precedence(int level) {
        this.level = level;
        Ordered.$init$(this);
    }
}

