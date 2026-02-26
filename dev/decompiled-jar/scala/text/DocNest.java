/*
 * Decompiled with CFR 0.152.
 */
package scala.text;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import scala.text.DocNest$;
import scala.text.Document;

@ScalaSignature(bytes="\u0006\u0001\u0005Eb\u0001\u0002\r\u001a\u0001zA\u0001B\u000b\u0001\u0003\u0016\u0004%\ta\u000b\u0005\t_\u0001\u0011\t\u0012)A\u0005Y!A\u0001\u0007\u0001BK\u0002\u0013\u0005\u0011\u0007\u0003\u00053\u0001\tE\t\u0015!\u0003 \u0011\u0015\u0019\u0004\u0001\"\u00015\u0011\u001dA\u0004!!A\u0005\u0002eBq\u0001\u0010\u0001\u0012\u0002\u0013\u0005Q\bC\u0004I\u0001E\u0005I\u0011A%\t\u000f-\u0003\u0011\u0011!C!\u0019\"9Q\u000bAA\u0001\n\u0003Y\u0003b\u0002,\u0001\u0003\u0003%\ta\u0016\u0005\b;\u0002\t\t\u0011\"\u0011_\u0011\u001d)\u0007!!A\u0005\u0002\u0019Dqa\u001b\u0001\u0002\u0002\u0013\u0005C\u000eC\u0004n\u0001\u0005\u0005I\u0011\t8\t\u000f=\u0004\u0011\u0011!C!a\u001e9!0GA\u0001\u0012\u0003Yha\u0002\r\u001a\u0003\u0003E\t\u0001 \u0005\u0007gI!\t!a\u0002\t\u000f5\u0014\u0012\u0011!C#]\"I\u0011\u0011\u0002\n\u0002\u0002\u0013\u0005\u00151\u0002\u0005\n\u0003#\u0011\u0012\u0011!CA\u0003'A\u0011\"!\n\u0013\u0003\u0003%I!a\n\u0003\u000f\u0011{7MT3ti*\u0011!dG\u0001\u0005i\u0016DHOC\u0001\u001d\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019B\u0001A\u0010$OA\u0011\u0001%I\u0007\u00023%\u0011!%\u0007\u0002\t\t>\u001cW/\\3oiB\u0011A%J\u0007\u00027%\u0011ae\u0007\u0002\b!J|G-^2u!\t!\u0003&\u0003\u0002*7\ta1+\u001a:jC2L'0\u00192mK\u00061\u0011N\u001c3f]R,\u0012\u0001\f\t\u0003I5J!AL\u000e\u0003\u0007%sG/A\u0004j]\u0012,g\u000e\u001e\u0011\u0002\u0007\u0011|7-F\u0001 \u0003\u0011!wn\u0019\u0011\u0002\rqJg.\u001b;?)\r)dg\u000e\t\u0003A\u0001AQAK\u0003A\u00021BQ\u0001M\u0003A\u0002}\tAaY8qsR\u0019QGO\u001e\t\u000f)2\u0001\u0013!a\u0001Y!9\u0001G\u0002I\u0001\u0002\u0004y\u0012AD2paf$C-\u001a4bk2$H%M\u000b\u0002})\u0012AfP\u0016\u0002\u0001B\u0011\u0011IR\u0007\u0002\u0005*\u00111\tR\u0001\nk:\u001c\u0007.Z2lK\u0012T!!R\u000e\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002H\u0005\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU\t!J\u000b\u0002 \u007f\u0005i\u0001O]8ek\u000e$\bK]3gSb,\u0012!\u0014\t\u0003\u001dNk\u0011a\u0014\u0006\u0003!F\u000bA\u0001\\1oO*\t!+\u0001\u0003kCZ\f\u0017B\u0001+P\u0005\u0019\u0019FO]5oO\u0006a\u0001O]8ek\u000e$\u0018I]5us\u0006q\u0001O]8ek\u000e$X\t\\3nK:$HC\u0001-\\!\t!\u0013,\u0003\u0002[7\t\u0019\u0011I\\=\t\u000fq[\u0011\u0011!a\u0001Y\u0005\u0019\u0001\u0010J\u0019\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\u0012a\u0018\t\u0004A\u000eDV\"A1\u000b\u0005\t\\\u0012AC2pY2,7\r^5p]&\u0011A-\u0019\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0002hUB\u0011A\u0005[\u0005\u0003Sn\u0011qAQ8pY\u0016\fg\u000eC\u0004]\u001b\u0005\u0005\t\u0019\u0001-\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012\u0001L\u0001\ti>\u001cFO]5oOR\tQ*\u0001\u0004fcV\fGn\u001d\u000b\u0003OFDq\u0001\u0018\t\u0002\u0002\u0003\u0007\u0001\f\u000b\u0003\u0001gZD\bC\u0001\u0013u\u0013\t)8D\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013a^\u0001\u001bi\"L7\u000fI2mCN\u001c\be^5mY\u0002\u0012W\r\t:f[>4X\rZ\u0011\u0002s\u00061!GL\u00192]A\nq\u0001R8d\u001d\u0016\u001cH\u000f\u0005\u0002!%M\u0019!#`\u0014\u0011\ry\f\u0019\u0001L\u00106\u001b\u0005y(bAA\u00017\u00059!/\u001e8uS6,\u0017bAA\u0003\u007f\n\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0003m\fQ!\u00199qYf$R!NA\u0007\u0003\u001fAQAK\u000bA\u00021BQ\u0001M\u000bA\u0002}\tq!\u001e8baBd\u0017\u0010\u0006\u0003\u0002\u0016\u0005\u0005\u0002#\u0002\u0013\u0002\u0018\u0005m\u0011bAA\r7\t1q\n\u001d;j_:\u0004R\u0001JA\u000fY}I1!a\b\u001c\u0005\u0019!V\u000f\u001d7fe!A\u00111\u0005\f\u0002\u0002\u0003\u0007Q'A\u0002yIA\n1B]3bIJ+7o\u001c7wKR\u0011\u0011\u0011\u0006\t\u0004\u001d\u0006-\u0012bAA\u0017\u001f\n1qJ\u00196fGRDCAE:wq\u0002")
public class DocNest
extends Document
implements Product,
Serializable {
    private final int indent;
    private final Document doc;

    public static Option<Tuple2<Object, Document>> unapply(DocNest docNest) {
        return DocNest$.MODULE$.unapply(docNest);
    }

    public static DocNest apply(int n, Document document) {
        return DocNest$.MODULE$.apply(n, document);
    }

    public static Function1<Tuple2<Object, Document>, DocNest> tupled() {
        return DocNest$.MODULE$.tupled();
    }

    public static Function1<Object, Function1<Document, DocNest>> curried() {
        return DocNest$.MODULE$.curried();
    }

    public int indent() {
        return this.indent;
    }

    public Document doc() {
        return this.doc;
    }

    public DocNest copy(int indent, Document doc) {
        return new DocNest(indent, doc);
    }

    public int copy$default$1() {
        return this.indent();
    }

    public Document copy$default$2() {
        return this.doc();
    }

    @Override
    public String productPrefix() {
        return "DocNest";
    }

    @Override
    public int productArity() {
        return 2;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return BoxesRunTime.boxToInteger(this.indent());
            }
            case 1: {
                return this.doc();
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
        return x$1 instanceof DocNest;
    }

    public int hashCode() {
        return Statics.finalizeHash(Statics.mix(Statics.mix(-889275714, this.indent()), Statics.anyHash(this.doc())), 2);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        if (!(x$1 instanceof DocNest)) return false;
        boolean bl = true;
        if (!bl) return false;
        DocNest docNest = (DocNest)x$1;
        if (this.indent() != docNest.indent()) return false;
        Document document = this.doc();
        Document document2 = docNest.doc();
        if (document == null) {
            if (document2 != null) {
                return false;
            }
        } else if (!document.equals(document2)) return false;
        if (!docNest.canEqual(this)) return false;
        return true;
    }

    public DocNest(int indent, Document doc) {
        this.indent = indent;
        this.doc = doc;
        Product.$init$(this);
    }
}

