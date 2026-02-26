/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.script;

import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.script.Message;
import scala.collection.script.Reset$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005%a\u0001\u0002\n\u0014\u0001jAQ!\u000e\u0001\u0005\u0002YBq\u0001\u000f\u0001\u0002\u0002\u0013\u0005\u0011\bC\u0004?\u0001\u0005\u0005I\u0011I \t\u000f!\u0003\u0011\u0011!C\u0001\u0013\"9Q\nAA\u0001\n\u0003q\u0005bB)\u0001\u0003\u0003%\tE\u0015\u0005\b/\u0002\t\t\u0011\"\u0001Y\u0011\u001di\u0006!!A\u0005ByCqa\u0018\u0001\u0002\u0002\u0013\u0005\u0003\rC\u0004b\u0001\u0005\u0005I\u0011\t2\b\u000f1\u001c\u0012\u0011!E\u0001[\u001a9!cEA\u0001\u0012\u0003q\u0007\"B\u001b\r\t\u0003y\u0007bB0\r\u0003\u0003%)\u0005\u0019\u0005\ba2\t\t\u0011\"!r\u0011\u001d1H\"!A\u0005\u0002^DqA \u0007\u0002\u0002\u0013%qPA\u0003SKN,GO\u0003\u0002\u0015+\u000511o\u0019:jaRT!AF\f\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0019\u0003\u0015\u00198-\u00197b\u0007\u0001)\"a\u0007\u0014\u0014\u000b\u0001a\u0002e\f\u001a\u0011\u0005uqR\"A\f\n\u0005}9\"AB!osJ+g\rE\u0002\"E\u0011j\u0011aE\u0005\u0003GM\u0011q!T3tg\u0006<W\r\u0005\u0002&M1\u0001AAB\u0014\u0001\t\u000b\u0007\u0001FA\u0001B#\tIC\u0006\u0005\u0002\u001eU%\u00111f\u0006\u0002\b\u001d>$\b.\u001b8h!\tiR&\u0003\u0002//\t\u0019\u0011I\\=\u0011\u0005u\u0001\u0014BA\u0019\u0018\u0005\u001d\u0001&o\u001c3vGR\u0004\"!H\u001a\n\u0005Q:\"\u0001D*fe&\fG.\u001b>bE2,\u0017A\u0002\u001fj]&$h\bF\u00018!\r\t\u0003\u0001J\u0001\u0005G>\u0004\u00180\u0006\u0002;{Q\t1\bE\u0002\"\u0001q\u0002\"!J\u001f\u0005\u000b\u001d\u0012!\u0019\u0001\u0015\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\u0005\u0001\u0005CA!G\u001b\u0005\u0011%BA\"E\u0003\u0011a\u0017M\\4\u000b\u0003\u0015\u000bAA[1wC&\u0011qI\u0011\u0002\u0007'R\u0014\u0018N\\4\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0003)\u0003\"!H&\n\u00051;\"aA%oi\u0006q\u0001O]8ek\u000e$X\t\\3nK:$HC\u0001\u0017P\u0011\u001d\u0001V!!AA\u0002)\u000b1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#A*\u0011\u0007Q+F&D\u0001\u0016\u0013\t1VC\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dGCA-]!\ti\",\u0003\u0002\\/\t9!i\\8mK\u0006t\u0007b\u0002)\b\u0003\u0003\u0005\r\u0001L\u0001\tQ\u0006\u001c\bnQ8eKR\t!*\u0001\u0005u_N#(/\u001b8h)\u0005\u0001\u0015AB3rk\u0006d7\u000f\u0006\u0002ZG\"9\u0001KCA\u0001\u0002\u0004a\u0003\u0006\u0002\u0001fQ*\u0004\"!\b4\n\u0005\u001d<\"A\u00033faJ,7-\u0019;fI\u0006\n\u0011.A\ftGJL\u0007\u000f^5oO\u0002J7\u000f\t3faJ,7-\u0019;fI\u0006\n1.\u0001\u00043]E\nd\u0006M\u0001\u0006%\u0016\u001cX\r\u001e\t\u0003C1\u00192\u0001\u0004\u000f3)\u0005i\u0017!B1qa2LXC\u0001:v)\u0005\u0019\bcA\u0011\u0001iB\u0011Q%\u001e\u0003\u0006O=\u0011\r\u0001K\u0001\bk:\f\u0007\u000f\u001d7z+\tAX\u0010\u0006\u0002Zs\"9!\u0010EA\u0001\u0002\u0004Y\u0018a\u0001=%aA\u0019\u0011\u0005\u0001?\u0011\u0005\u0015jH!B\u0014\u0011\u0005\u0004A\u0013a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!!\u0001\u0011\u0007\u0005\u000b\u0019!C\u0002\u0002\u0006\t\u0013aa\u00142kK\u000e$\b\u0006\u0002\u0007fQ*\u0004")
public class Reset<A>
implements Message<A>,
Product,
Serializable {
    public static <A> boolean unapply(Reset<A> reset) {
        return Reset$.MODULE$.unapply(reset);
    }

    public static <A> Reset<A> apply() {
        return Reset$.MODULE$.apply();
    }

    public <A> Reset<A> copy() {
        return new Reset<A>();
    }

    @Override
    public String productPrefix() {
        return "Reset";
    }

    @Override
    public int productArity() {
        return 0;
    }

    @Override
    public Object productElement(int x$1) {
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Reset;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    @Override
    public boolean equals(Object x$1) {
        boolean bl = x$1 instanceof Reset;
        return bl && ((Reset)x$1).canEqual(this);
    }

    public Reset() {
        Product.$init$(this);
    }
}

