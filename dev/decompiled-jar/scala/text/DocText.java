/*
 * Decompiled with CFR 0.152.
 */
package scala.text;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.text.DocText$;
import scala.text.Document;

@ScalaSignature(bytes="\u0006\u0001\u0005%b\u0001B\u000b\u0017\u0001nA\u0001b\n\u0001\u0003\u0016\u0004%\t\u0001\u000b\u0005\ti\u0001\u0011\t\u0012)A\u0005S!)Q\u0007\u0001C\u0001m!9\u0011\bAA\u0001\n\u0003Q\u0004b\u0002\u001f\u0001#\u0003%\t!\u0010\u0005\b\u0011\u0002\t\t\u0011\"\u0011J\u0011\u001d\t\u0006!!A\u0005\u0002ICqA\u0016\u0001\u0002\u0002\u0013\u0005q\u000bC\u0004^\u0001\u0005\u0005I\u0011\t0\t\u000f\u0015\u0004\u0011\u0011!C\u0001M\"91\u000eAA\u0001\n\u0003b\u0007bB7\u0001\u0003\u0003%\tE\u001c\u0005\b_\u0002\t\t\u0011\"\u0011q\u000f\u001dQh#!A\t\u0002m4q!\u0006\f\u0002\u0002#\u0005A\u0010\u0003\u00046\u001f\u0011\u0005\u0011q\u0001\u0005\b[>\t\t\u0011\"\u0012o\u0011%\tIaDA\u0001\n\u0003\u000bY\u0001C\u0005\u0002\u0010=\t\t\u0011\"!\u0002\u0012!I\u0011QD\b\u0002\u0002\u0013%\u0011q\u0004\u0002\b\t>\u001cG+\u001a=u\u0015\t9\u0002$\u0001\u0003uKb$(\"A\r\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M!\u0001\u0001\b\u0011%!\tib$D\u0001\u0017\u0013\tybC\u0001\u0005E_\u000e,X.\u001a8u!\t\t#%D\u0001\u0019\u0013\t\u0019\u0003DA\u0004Qe>$Wo\u0019;\u0011\u0005\u0005*\u0013B\u0001\u0014\u0019\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\r!\b\u0010^\u000b\u0002SA\u0011!&\r\b\u0003W=\u0002\"\u0001\f\r\u000e\u00035R!A\f\u000e\u0002\rq\u0012xn\u001c;?\u0013\t\u0001\u0004$\u0001\u0004Qe\u0016$WMZ\u0005\u0003eM\u0012aa\u0015;sS:<'B\u0001\u0019\u0019\u0003\u0011!\b\u0010\u001e\u0011\u0002\rqJg.\u001b;?)\t9\u0004\b\u0005\u0002\u001e\u0001!)qe\u0001a\u0001S\u0005!1m\u001c9z)\t94\bC\u0004(\tA\u0005\t\u0019A\u0015\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\taH\u000b\u0002*\u007f-\n\u0001\t\u0005\u0002B\r6\t!I\u0003\u0002D\t\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0003\u000bb\t!\"\u00198o_R\fG/[8o\u0013\t9%IA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DX#\u0001&\u0011\u0005-\u0003V\"\u0001'\u000b\u00055s\u0015\u0001\u00027b]\u001eT\u0011aT\u0001\u0005U\u00064\u0018-\u0003\u00023\u0019\u0006a\u0001O]8ek\u000e$\u0018I]5usV\t1\u000b\u0005\u0002\")&\u0011Q\u000b\u0007\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u00031n\u0003\"!I-\n\u0005iC\"aA!os\"9A\fCA\u0001\u0002\u0004\u0019\u0016a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/F\u0001`!\r\u00017\rW\u0007\u0002C*\u0011!\rG\u0001\u000bG>dG.Z2uS>t\u0017B\u00013b\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\u0005\u001dT\u0007CA\u0011i\u0013\tI\u0007DA\u0004C_>dW-\u00198\t\u000fqS\u0011\u0011!a\u00011\u0006A\u0001.Y:i\u0007>$W\rF\u0001T\u0003!!xn\u0015;sS:<G#\u0001&\u0002\r\u0015\fX/\u00197t)\t9\u0017\u000fC\u0004]\u001b\u0005\u0005\t\u0019\u0001-)\t\u0001\u0019h\u000f\u001f\t\u0003CQL!!\u001e\r\u0003\u0015\u0011,\u0007O]3dCR,G-I\u0001x\u0003i!\b.[:!G2\f7o\u001d\u0011xS2d\u0007EY3!e\u0016lwN^3eC\u0005I\u0018A\u0002\u001a/cEr\u0003'A\u0004E_\u000e$V\r\u001f;\u0011\u0005uy1cA\b~IA)a0a\u0001*o5\tqPC\u0002\u0002\u0002a\tqA];oi&lW-C\u0002\u0002\u0006}\u0014\u0011#\u00112tiJ\f7\r\u001e$v]\u000e$\u0018n\u001c82)\u0005Y\u0018!B1qa2LHcA\u001c\u0002\u000e!)qE\u0005a\u0001S\u00059QO\\1qa2LH\u0003BA\n\u00033\u0001B!IA\u000bS%\u0019\u0011q\u0003\r\u0003\r=\u0003H/[8o\u0011!\tYbEA\u0001\u0002\u00049\u0014a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t\t\u0003E\u0002L\u0003GI1!!\nM\u0005\u0019y%M[3di\"\"qb\u001d<y\u0001")
public class DocText
extends Document
implements Product,
Serializable {
    private final String txt;

    public static Option<String> unapply(DocText docText) {
        return DocText$.MODULE$.unapply(docText);
    }

    public static DocText apply(String string) {
        return DocText$.MODULE$.apply(string);
    }

    public static <A> Function1<String, A> andThen(Function1<DocText, A> function1) {
        DocText$ docText$ = DocText$.MODULE$;
        if (docText$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(docText$, function1, arg_0);
    }

    public static <A> Function1<A, DocText> compose(Function1<A, String> function1) {
        DocText$ docText$ = DocText$.MODULE$;
        if (docText$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(docText$, function1, arg_0);
    }

    public String txt() {
        return this.txt;
    }

    public DocText copy(String txt) {
        return new DocText(txt);
    }

    public String copy$default$1() {
        return this.txt();
    }

    @Override
    public String productPrefix() {
        return "DocText";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.txt();
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
        return x$1 instanceof DocText;
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
                boolean bl = x$1 instanceof DocText;
                if (!bl) break block3;
                DocText docText = (DocText)x$1;
                String string = this.txt();
                String string2 = docText.txt();
                if (!(!(string != null ? !string.equals(string2) : string2 != null) && docText.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public DocText(String txt) {
        this.txt = txt;
        Product.$init$(this);
    }
}

