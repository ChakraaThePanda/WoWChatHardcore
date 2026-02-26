/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Predef$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.StringFormat$;

@ScalaSignature(bytes="\u0006\u0001\u00054A!\u0004\b\u0003'!A\u0001\u0004\u0001BC\u0002\u0013\u0005\u0011\u0004\u0003\u0005\u001e\u0001\t\u0005\t\u0015!\u0003\u001b\u0011\u0015q\u0002\u0001\"\u0001 \u0011\u0015\u0019\u0003\u0001\"\u0001%\u0011\u001d1\u0004!!A\u0005B]Bqa\u000f\u0001\u0002\u0002\u0013\u0005ChB\u0004K\u001d\u0005\u0005\t\u0012A&\u0007\u000f5q\u0011\u0011!E\u0001\u0019\")a\u0004\u0003C\u0001!\")\u0011\u000b\u0003C\u0003%\"9\u0001\fCA\u0001\n\u000bI\u0006bB.\t\u0003\u0003%)\u0001\u0018\u0002\r'R\u0014\u0018N\\4G_Jl\u0017\r\u001e\u0006\u0003\u001fA\tqA];oi&lWMC\u0001\u0012\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001\u0001\u000b\u0011\u0005U1R\"\u0001\t\n\u0005]\u0001\"AB!osZ\u000bG.\u0001\u0003tK24W#\u0001\u000e\u0011\u0005UY\u0012B\u0001\u000f\u0011\u0005\r\te._\u0001\u0006g\u0016dg\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\u0001\u0012\u0003CA\u0011\u0001\u001b\u0005q\u0001\"\u0002\r\u0004\u0001\u0004Q\u0012!\u00034pe6\fG\u000f^3e)\t)\u0003\u0007\u0005\u0002'[9\u0011qe\u000b\t\u0003QAi\u0011!\u000b\u0006\u0003UI\ta\u0001\u0010:p_Rt\u0014B\u0001\u0017\u0011\u0003\u0019\u0001&/\u001a3fM&\u0011af\f\u0002\u0007'R\u0014\u0018N\\4\u000b\u00051\u0002\u0002\"B\u0019\u0005\u0001\u0004)\u0013A\u00024niN$(\u000f\u000b\u0002\u0005gA\u0011Q\u0003N\u0005\u0003kA\u0011a!\u001b8mS:,\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003a\u0002\"!F\u001d\n\u0005i\u0002\"aA%oi\u00061Q-];bYN$\"!\u0010!\u0011\u0005Uq\u0014BA \u0011\u0005\u001d\u0011un\u001c7fC:Dq!\u0011\u0004\u0002\u0002\u0003\u0007!$A\u0002yIEBC\u0001A\"G\u0011B\u0011Q\u0003R\u0005\u0003\u000bB\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u00059\u0015aF;tK\u0002\u0002&/\u001a3fM:\u001aFO]5oO\u001a{'/\\1uC\u0005I\u0015A\u0002\u001a/cEr\u0003'\u0001\u0007TiJLgn\u001a$pe6\fG\u000f\u0005\u0002\"\u0011M\u0011\u0001\"\u0014\t\u0003+9K!a\u0014\t\u0003\r\u0005s\u0017PU3g)\u0005Y\u0015a\u00054pe6\fG\u000f^3eI\u0015DH/\u001a8tS>tGCA*V)\t)C\u000bC\u00032\u0015\u0001\u0007Q\u0005C\u0003W\u0015\u0001\u0007\u0001%A\u0003%i\"L7\u000f\u000b\u0002\u000bg\u0005\u0011\u0002.Y:i\u0007>$W\rJ3yi\u0016t7/[8o)\t9$\fC\u0003W\u0017\u0001\u0007\u0001%\u0001\tfcV\fGn\u001d\u0013fqR,gn]5p]R\u0011Ql\u0018\u000b\u0003{yCq!\u0011\u0007\u0002\u0002\u0003\u0007!\u0004C\u0003W\u0019\u0001\u0007\u0001\u0005\u000b\u0003\t\u0007\u001aC\u0005")
public final class StringFormat {
    private final Object self;

    public static boolean equals$extension(Object object, Object object2) {
        return StringFormat$.MODULE$.equals$extension(object, object2);
    }

    public static int hashCode$extension(Object object) {
        return StringFormat$.MODULE$.hashCode$extension(object);
    }

    public static String formatted$extension(Object object, String string) {
        if (StringFormat$.MODULE$ == null) {
            throw null;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{object}));
    }

    public Object self() {
        return this.self;
    }

    /*
     * WARNING - void declaration
     */
    public String formatted(String fmtstr) {
        void formatted$extension_$this;
        Object object = this.self();
        if (StringFormat$.MODULE$ == null) {
            throw null;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(fmtstr).format(Predef$.MODULE$.genericWrapArray(new Object[]{formatted$extension_$this}));
    }

    public int hashCode() {
        return StringFormat$.MODULE$.hashCode$extension(this.self());
    }

    public boolean equals(Object x$1) {
        return StringFormat$.MODULE$.equals$extension(this.self(), x$1);
    }

    public StringFormat(Object self) {
        this.self = self;
    }
}

