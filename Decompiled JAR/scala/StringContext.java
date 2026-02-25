/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.StringContext$;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.immutable.StringOps$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005%g\u0001B\u0010!\u0001\u000eB\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\t}\u0001\u0011\t\u0012)A\u0005a!)q\b\u0001C\u0001\u0001\")1\t\u0001C\u0001\t\")A\u000b\u0001C\u0001+\")\u0001\f\u0001C\u00013\")1\f\u0001C\u00019\"11\r\u0001B\u0005\u0002\u0011Dq!\u001c\u0001\u0002\u0002\u0013\u0005c\u000eC\u0004w\u0001\u0005\u0005I\u0011A<\t\u000fm\u0004\u0011\u0011!C\u0001y\"Aq\u0010AA\u0001\n\u0003\n\t\u0001C\u0005\u0002\u0010\u0001\t\t\u0011\"\u0001\u0002\u0012!I\u00111\u0004\u0001\u0002\u0002\u0013\u0005\u0013Q\u0004\u0005\n\u0003?\u0001\u0011\u0011!C!\u0003CA\u0011\"a\t\u0001\u0003\u0003%\t%!\n\b\u000f\u0005%\u0002\u0005#\u0001\u0002,\u00191q\u0004\tE\u0001\u0003[Aaa\u0010\n\u0005\u0002\u0005=bABA\u0019%\u0001\t\u0019\u0004C\u0005\u0002<Q\u0011\t\u0011)A\u0005g!I\u0011Q\b\u000b\u0003\u0006\u0004%\ta\u001e\u0005\n\u0003\u007f!\"\u0011!Q\u0001\naDaa\u0010\u000b\u0005\u0002\u0005\u0005\u0003bBAJ%\u0011\u0005\u0011Q\u0013\u0005\b\u00033\u0013B\u0011AAN\u0011\u001d\tyJ\u0005C\u0005\u0003CC\u0011\"!\u001a\u0013\u0003\u0003%\t)!+\t\u0013\u00055&#!A\u0005\u0002\u0006=\u0006\"CA`%\u0005\u0005I\u0011BAa\u00055\u0019FO]5oO\u000e{g\u000e^3yi*\t\u0011%A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\t\u0001!\u0003f\u000b\t\u0003K\u0019j\u0011\u0001I\u0005\u0003O\u0001\u0012a!\u00118z%\u00164\u0007CA\u0013*\u0013\tQ\u0003EA\u0004Qe>$Wo\u0019;\u0011\u0005\u0015b\u0013BA\u0017!\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0015\u0001\u0018M\u001d;t+\u0005\u0001\u0004cA\u00132g%\u0011!\u0007\t\u0002\u000byI,\u0007/Z1uK\u0012t\u0004C\u0001\u001b<\u001d\t)\u0014\b\u0005\u00027A5\tqG\u0003\u00029E\u00051AH]8pizJ!A\u000f\u0011\u0002\rA\u0013X\rZ3g\u0013\taTH\u0001\u0004TiJLgn\u001a\u0006\u0003u\u0001\na\u0001]1siN\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0002B\u0005B\u0011Q\u0005\u0001\u0005\u0006]\r\u0001\r\u0001M\u0001\rG\",7m\u001b'f]\u001e$\bn\u001d\u000b\u0003\u000b\"\u0003\"!\n$\n\u0005\u001d\u0003#\u0001B+oSRDQ!\u0013\u0003A\u0002)\u000bA!\u0019:hgB\u00191JT)\u000f\u0005\u0015b\u0015BA'!\u0003\u001d\u0001\u0018mY6bO\u0016L!a\u0014)\u0003\u0007M+\u0017O\u0003\u0002NAA\u0011QEU\u0005\u0003'\u0002\u00121!\u00118z\u0003\u0005\u0019HCA\u001aW\u0011\u0015IU\u00011\u0001X!\r)\u0013'U\u0001\u0004e\u0006<HCA\u001a[\u0011\u0015Ie\u00011\u0001X\u0003Q\u0019H/\u00198eCJ$\u0017J\u001c;feB|G.\u0019;peR\u00191'\u00182\t\u000by;\u0001\u0019A0\u0002\u000fA\u0014xnY3tgB!Q\u0005Y\u001a4\u0013\t\t\u0007EA\u0005Gk:\u001cG/[8oc!)\u0011j\u0002a\u0001\u0015\u0006\ta-\u0006\u0002fUR\u00111G\u001a\u0005\u0006\u0013\"\u0001\ra\u001a\t\u0004KEB\u0007CA5k\u0019\u0001!Qa\u001b\u0005C\u00021\u0014\u0011!Q\t\u0003#F\u000bQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DX#A8\u0011\u0005A,X\"A9\u000b\u0005I\u001c\u0018\u0001\u00027b]\u001eT\u0011\u0001^\u0001\u0005U\u00064\u0018-\u0003\u0002=c\u0006a\u0001O]8ek\u000e$\u0018I]5usV\t\u0001\u0010\u0005\u0002&s&\u0011!\u0010\t\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u0003#vDqA`\u0006\u0002\u0002\u0003\u0007\u00010A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0003\u0003\u0007\u0001R!!\u0002\u0002\fEk!!a\u0002\u000b\u0007\u0005%\u0001%\u0001\u0006d_2dWm\u0019;j_:LA!!\u0004\u0002\b\tA\u0011\n^3sCR|'/\u0001\u0005dC:,\u0015/^1m)\u0011\t\u0019\"!\u0007\u0011\u0007\u0015\n)\"C\u0002\u0002\u0018\u0001\u0012qAQ8pY\u0016\fg\u000eC\u0004\u007f\u001b\u0005\u0005\t\u0019A)\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012\u0001_\u0001\ti>\u001cFO]5oOR\tq.\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003'\t9\u0003C\u0004\u007f!\u0005\u0005\t\u0019A)\u0002\u001bM#(/\u001b8h\u0007>tG/\u001a=u!\t)#cE\u0002\u0013I-\"\"!a\u000b\u0003-%sg/\u00197jI\u0016\u001b8-\u00199f\u000bb\u001cW\r\u001d;j_:\u001c2\u0001FA\u001b!\rY\u0015qG\u0005\u0004\u0003s\u0001&\u0001G%mY\u0016<\u0017\r\\!sOVlWM\u001c;Fq\u000e,\u0007\u000f^5p]\u0006\u00191\u000f\u001e:\u0002\u000b%tG-\u001a=\u0002\r%tG-\u001a=!)\u0019\t\u0019%a\u0012\u0002JA\u0019\u0011Q\t\u000b\u000e\u0003IAa!a\u000f\u0019\u0001\u0004\u0019\u0004BBA\u001f1\u0001\u0007\u0001\u0010\u000b\u0005\u0002J\u00055\u00131KA@!\r)\u0013qJ\u0005\u0004\u0003#\u0002#A\u00043faJ,7-\u0019;fI:\u000bW.Z\u0019\b?\u0005U\u00131LA<!\r)\u0013qK\u0005\u0004\u00033\u0002#AB*z[\n|G.M\u0005$\u0003;\n\u0019'a\u001b\u0002fQ!\u0011QKA0\u0011\u0019\t\tG\ta\u0001g\u0005!a.Y7f\u0013\u0011\t)'a\u001a\u0002\u000b\u0005\u0004\b\u000f\\=\u000b\u0007\u0005%\u0004%\u0001\u0004Ts6\u0014w\u000e\\\u0019\nG\u00055\u00141OA;\u0003SrA!a\u001c\u0002t9\u0019a'!\u001d\n\u0003\u0005J1!!\u001b!c\u0019!\u0013qNA9CE*Q%!\u001f\u0002|=\u0011\u00111P\u0011\u0003\u0003{\n1!\u001b3yc!\u00193'!!\u0002\n\u0006\r\u0015\u0002BAB\u0003\u000b\u000b1\u0004\n7fgNLg.\u001b;%OJ,\u0017\r^3sI\u0011,g-Y;mi\u0012\u0012$bAADA\u0005qA-\u001a9sK\u000e\fG/\u001a3OC6,\u0017'C\u0012\u0002\f\u00065\u0015qRAD\u001d\r)\u0013QR\u0005\u0004\u0003\u000f\u0003\u0013'\u0002\u0012&A\u0005E%!B:dC2\f\u0017\u0001\u0004;sK\u0006$Xi]2ba\u0016\u001cHcA\u001a\u0002\u0018\"1\u00111H\rA\u0002M\na\u0002\u001d:pG\u0016\u001c8/R:dCB,7\u000fF\u00024\u0003;Ca!a\u000f\u001b\u0001\u0004\u0019\u0014!\u0004;sK\u0006$Xi]2ba\u0016\u001c\b\u0007F\u00034\u0003G\u000b)\u000b\u0003\u0004\u0002<m\u0001\ra\r\u0005\b\u0003O[\u0002\u0019AA\n\u0003\u0019\u0019HO]5diR\u0019\u0011)a+\t\u000b9b\u0002\u0019\u0001\u0019\u0002\u0015Ut\u0017\r\u001d9msN+\u0017\u000f\u0006\u0003\u00022\u0006m\u0006#B\u0013\u00024\u0006]\u0016bAA[A\t1q\n\u001d;j_:\u0004B!!/Og9\u0019\u0011q\u000e'\t\u0011\u0005uV$!AA\u0002\u0005\u000b1\u0001\u001f\u00131\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005\r\u0007c\u00019\u0002F&\u0019\u0011qY9\u0003\r=\u0013'.Z2u\u0001")
public class StringContext
implements Product,
Serializable {
    private final Seq<String> parts;

    public static Option<Seq<String>> unapplySeq(StringContext stringContext) {
        return StringContext$.MODULE$.unapplySeq(stringContext);
    }

    public static StringContext apply(Seq<String> seq) {
        return StringContext$.MODULE$.apply(seq);
    }

    public static String processEscapes(String string) {
        return StringContext$.MODULE$.processEscapes(string);
    }

    public static String treatEscapes(String string) {
        return StringContext$.MODULE$.treatEscapes(string);
    }

    public Seq<String> parts() {
        return this.parts;
    }

    public void checkLengths(Seq<Object> args2) {
        if (this.parts().length() != args2.length() + 1) {
            throw new IllegalArgumentException(new StringBuilder(64).append("wrong number of arguments (").append(args2.length()).append(") for interpolated string with ").append(this.parts().length()).append(" parts").toString());
        }
    }

    public String s(Seq<Object> args2) {
        return this.standardInterpolator((Function1<String, String> & java.io.Serializable & Serializable)str -> StringContext$.MODULE$.treatEscapes((String)str), args2);
    }

    public String raw(Seq<Object> args2) {
        return this.standardInterpolator((Function1<String, String> & java.io.Serializable & Serializable)x -> {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return x;
        }, args2);
    }

    public String standardInterpolator(Function1<String, String> process, Seq<Object> args2) {
        this.checkLengths(args2);
        Iterator pi = this.parts().iterator();
        Iterator ai = args2.iterator();
        StringBuilder bldr = new StringBuilder(process.apply((String)pi.next()));
        while (ai.hasNext()) {
            bldr.append(ai.next());
            bldr.append(process.apply((String)pi.next()));
        }
        return bldr.toString();
    }

    @Override
    public String productPrefix() {
        return "StringContext";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.parts();
            }
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof StringContext;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof StringContext;
                if (!bl) break block3;
                StringContext stringContext = (StringContext)x$1;
                Seq<String> seq = this.parts();
                Seq<String> seq2 = stringContext.parts();
                if (!(!(seq != null ? !seq.equals(seq2) : seq2 != null) && stringContext.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public StringContext(Seq<String> parts) {
        this.parts = parts;
        Product.$init$(this);
    }

    public static class InvalidEscapeException
    extends IllegalArgumentException {
        private final int index;

        public int index() {
            return this.index;
        }

        public InvalidEscapeException(String str, int index) {
            String string;
            this.index = index;
            StringBuilder stringBuilder = new StringBuilder(51).append("invalid escape ");
            Predef$.MODULE$.require(index >= 0 && index < str.length());
            String ok = "[\\b, \\t, \\n, \\f, \\r, \\\\, \\\", \\']";
            if (index == str.length() - 1) {
                string = "at terminal";
            } else {
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                string = new StringBuilder(18).append("'\\").append(StringOps$.MODULE$.apply$extension(str, index + 1)).append("' not one of ").append(ok).append(" at").toString();
            }
            super(stringBuilder.append((Object)string).append(" index ").append(index).append(" in \"").append(str).append("\". Use \\\\ for literal \\.").toString());
        }
    }
}

