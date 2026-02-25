/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Some$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005ee\u0001\u0002\r\u001a\u0005rA\u0001b\r\u0001\u0003\u0016\u0004%\t\u0001\u000e\u0005\tk\u0001\u0011\t\u0012)A\u0005E!)a\u0007\u0001C\u0001o!)\u0011\r\u0001C\u0001E\")a\r\u0001C\u0001i!)a\f\u0001C\u0001i!9Q\u000eAA\u0001\n\u0003q\u0007b\u0002;\u0001#\u0003%\t!\u001e\u0005\n\u0003\u000b\u0001\u0011\u0011!C!\u0003\u000fA\u0011\"a\u0006\u0001\u0003\u0003%\t!!\u0007\t\u0013\u0005\u0005\u0002!!A\u0005\u0002\u0005\r\u0002\"CA\u0015\u0001\u0005\u0005I\u0011IA\u0016\u0011%\tI\u0004AA\u0001\n\u0003\tY\u0004C\u0005\u0002@\u0001\t\t\u0011\"\u0011\u0002B!I\u00111\t\u0001\u0002\u0002\u0013\u0005\u0013Q\t\u0005\n\u0003\u000f\u0002\u0011\u0011!C!\u0003\u0013:\u0011\"a\u0016\u001a\u0003\u0003E\t!!\u0017\u0007\u0011aI\u0012\u0011!E\u0001\u00037BaA\u000e\n\u0005\u0002\u0005\r\u0004\"CA\"%\u0005\u0005IQIA#\u0011!9%#!A\u0005\u0002\u0006\u0015\u0004\"CA?%\u0005\u0005I\u0011QA@\u0011%\tyIEA\u0001\n\u0013\t\tJ\u0001\u0003T_6,'\"\u0001\u000e\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011Q\u0004J\n\u0005\u0001yi\u0003\u0007E\u0002 A\tj\u0011!G\u0005\u0003Ce\u0011aa\u00149uS>t\u0007CA\u0012%\u0019\u0001!a!\n\u0001\u0005\u0006\u00041#!A!\u0012\u0005\u001dR\u0003CA\u0010)\u0013\tI\u0013DA\u0004O_RD\u0017N\\4\u0011\u0005}Y\u0013B\u0001\u0017\u001a\u0005\r\te.\u001f\t\u0003?9J!aL\r\u0003\u000fA\u0013x\u000eZ;diB\u0011q$M\u0005\u0003ee\u0011AbU3sS\u0006d\u0017N_1cY\u0016\fQA^1mk\u0016,\u0012AI\u0001\u0007m\u0006dW/\u001a\u0011\u0002\rqJg.\u001b;?)\tA\u0014\bE\u0002 \u0001\tBQaM\u0002A\u0002\tBC!O\u001e??B\u0011q\u0004P\u0005\u0003{e\u0011a\u0002Z3qe\u0016\u001c\u0017\r^3e\u001d\u0006lW-\r\u0003 \u007f\t[\u0006CA\u0010A\u0013\t\t\u0015D\u0001\u0004Ts6\u0014w\u000e\\\u0019\u0006G\r3Uk\u0012\u000b\u0003\u007f\u0011CQ!R\u000eA\u0002)\u000bAA\\1nK&\u0011q\tS\u0001\u0006CB\u0004H.\u001f\u0006\u0003\u0013f\taaU=nE>d\u0007CA&S\u001d\ta\u0005\u000b\u0005\u0002N35\taJ\u0003\u0002P7\u00051AH]8pizJ!!U\r\u0002\rA\u0013X\rZ3g\u0013\t\u0019FK\u0001\u0004TiJLgn\u001a\u0006\u0003#f\tTa\t,Z5&s!aV-\u000f\u00055C\u0016\"\u0001\u000e\n\u0005%K\u0012\u0007\u0002\u0013X1j\t4!\n/^\u001f\u0005i\u0016%\u00010\u0002\u0003a\f\u0013\u0001Y\u0001\u0007e9\n$G\f\u0019\u0002\u000f%\u001cX)\u001c9usV\t1\r\u0005\u0002 I&\u0011Q-\u0007\u0002\b\u0005>|G.Z1o\u0003\r9W\r\u001e\u0015\u0005\r!\\w\f\u0005\u0002 S&\u0011!.\u0007\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%\u00017\u0002'U\u001bX\r\t\u0018wC2,X\rI5ogR,\u0017\r\u001a\u0018\u0002\t\r|\u0007/_\u000b\u0003_J$\"\u0001]:\u0011\u0007}\u0001\u0011\u000f\u0005\u0002$e\u0012)Qe\u0002b\u0001M!91g\u0002I\u0001\u0002\u0004\t\u0018AD2paf$C-\u001a4bk2$H%M\u000b\u0004m\u0006\rQ#A<+\u0005\tB8&A=\u0011\u0005i|X\"A>\u000b\u0005ql\u0018!C;oG\",7m[3e\u0015\tq\u0018$\u0001\u0006b]:|G/\u0019;j_:L1!!\u0001|\u0005E)hn\u00195fG.,GMV1sS\u0006t7-\u001a\u0003\u0006K!\u0011\rAJ\u0001\u000eaJ|G-^2u!J,g-\u001b=\u0016\u0005\u0005%\u0001\u0003BA\u0006\u0003+i!!!\u0004\u000b\t\u0005=\u0011\u0011C\u0001\u0005Y\u0006twM\u0003\u0002\u0002\u0014\u0005!!.\u0019<b\u0013\r\u0019\u0016QB\u0001\raJ|G-^2u\u0003JLG/_\u000b\u0003\u00037\u00012aHA\u000f\u0013\r\ty\"\u0007\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u0004U\u0005\u0015\u0002\"CA\u0014\u0017\u0005\u0005\t\u0019AA\u000e\u0003\rAH%M\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011\u0011Q\u0006\t\u0006\u0003_\t)DK\u0007\u0003\u0003cQ1!a\r\u001a\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003o\t\tD\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dGcA2\u0002>!A\u0011qE\u0007\u0002\u0002\u0003\u0007!&\u0001\u0005iCND7i\u001c3f)\t\tY\"\u0001\u0005u_N#(/\u001b8h)\t\tI!\u0001\u0004fcV\fGn\u001d\u000b\u0004G\u0006-\u0003\u0002CA\u0014!\u0005\u0005\t\u0019\u0001\u0016)\r\u0001\tyeMA+!\ry\u0012\u0011K\u0005\u0004\u0003'J\"\u0001E*fe&\fGNV3sg&|g.V%E=!\t\"E}5_C/%\u0018\u0001B*p[\u0016\u0004\"a\b\n\u0014\tI\ti\u0006\r\t\u0004?\u0005}\u0013bAA13\t1\u0011I\\=SK\u001a$\"!!\u0017\u0016\t\u0005\u001d\u0014Q\u000e\u000b\u0005\u0003S\ny\u0007\u0005\u0003 \u0001\u0005-\u0004cA\u0012\u0002n\u0011)Q%\u0006b\u0001M!11'\u0006a\u0001\u0003WBc!a\u001c<\u0003gz\u0016GB\u0010@\u0003k\nY(\r\u0004$\u0007\u001a\u000b9hR\u0019\u0007GYK\u0016\u0011P%2\t\u0011:\u0006LG\u0019\u0004Kqk\u0016aB;oCB\u0004H._\u000b\u0005\u0003\u0003\u000b9\t\u0006\u0003\u0002\u0004\u0006%\u0005\u0003B\u0010!\u0003\u000b\u00032aIAD\t\u0015)cC1\u0001'\u0011%\tYIFA\u0001\u0002\u0004\ti)A\u0002yIA\u0002Ba\b\u0001\u0002\u0006\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t\u0019\n\u0005\u0003\u0002\f\u0005U\u0015\u0002BAL\u0003\u001b\u0011aa\u00142kK\u000e$\b")
public final class Some<A>
extends Option<A> {
    public static final long serialVersionUID = 1234815782226070388L;
    private final A value;

    public static <A> Option<A> unapply(Some<A> some) {
        return Some$.MODULE$.unapply(some);
    }

    public static <A> Some<A> apply(A a) {
        return Some$.MODULE$.apply(a);
    }

    public A value() {
        return this.value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public A get() {
        return this.value();
    }

    public A x() {
        return this.value();
    }

    public <A> Some<A> copy(A value) {
        return new Some<A>(value);
    }

    public <A> A copy$default$1() {
        return this.value();
    }

    @Override
    public String productPrefix() {
        return "Some";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.value();
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
        return x$1 instanceof Some;
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
                boolean bl = x$1 instanceof Some;
                if (!bl) break block3;
                Some some = (Some)x$1;
                if (!BoxesRunTime.equals(this.value(), some.value())) break block3;
            }
            return true;
        }
        return false;
    }

    public Some(A value) {
        this.value = value;
    }
}

