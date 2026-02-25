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
import scala.text.DocCons$;
import scala.text.Document;

@ScalaSignature(bytes="\u0006\u0001\u00055b\u0001\u0002\r\u001a\u0001zA\u0001B\u000b\u0001\u0003\u0016\u0004%\ta\u000b\u0005\tY\u0001\u0011\t\u0012)A\u0005?!AQ\u0006\u0001BK\u0002\u0013\u00051\u0006\u0003\u0005/\u0001\tE\t\u0015!\u0003 \u0011\u0015y\u0003\u0001\"\u00011\u0011\u001d!\u0004!!A\u0005\u0002UBq\u0001\u000f\u0001\u0012\u0002\u0013\u0005\u0011\bC\u0004E\u0001E\u0005I\u0011A\u001d\t\u000f\u0015\u0003\u0011\u0011!C!\r\"9q\nAA\u0001\n\u0003\u0001\u0006b\u0002+\u0001\u0003\u0003%\t!\u0016\u0005\b7\u0002\t\t\u0011\"\u0011]\u0011\u001d\u0019\u0007!!A\u0005\u0002\u0011Dq!\u001b\u0001\u0002\u0002\u0013\u0005#\u000eC\u0004l\u0001\u0005\u0005I\u0011\t7\t\u000f5\u0004\u0011\u0011!C!]\u001e9\u00010GA\u0001\u0012\u0003Iha\u0002\r\u001a\u0003\u0003E\tA\u001f\u0005\u0007_I!\t!a\u0001\t\u000f-\u0014\u0012\u0011!C#Y\"I\u0011Q\u0001\n\u0002\u0002\u0013\u0005\u0015q\u0001\u0005\n\u0003\u001b\u0011\u0012\u0011!CA\u0003\u001fA\u0011\"!\t\u0013\u0003\u0003%I!a\t\u0003\u000f\u0011{7mQ8og*\u0011!dG\u0001\u0005i\u0016DHOC\u0001\u001d\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019B\u0001A\u0010$OA\u0011\u0001%I\u0007\u00023%\u0011!%\u0007\u0002\t\t>\u001cW/\\3oiB\u0011A%J\u0007\u00027%\u0011ae\u0007\u0002\b!J|G-^2u!\t!\u0003&\u0003\u0002*7\ta1+\u001a:jC2L'0\u00192mK\u0006\u0011\u0001\u000eZ\u000b\u0002?\u0005\u0019\u0001\u000e\u001a\u0011\u0002\u0005Qd\u0017a\u0001;mA\u00051A(\u001b8jiz\"2!\r\u001a4!\t\u0001\u0003\u0001C\u0003+\u000b\u0001\u0007q\u0004C\u0003.\u000b\u0001\u0007q$\u0001\u0003d_BLHcA\u00197o!9!F\u0002I\u0001\u0002\u0004y\u0002bB\u0017\u0007!\u0003\u0005\raH\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0005Q$FA\u0010<W\u0005a\u0004CA\u001fC\u001b\u0005q$BA A\u0003%)hn\u00195fG.,GM\u0003\u0002B7\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005\rs$!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012\u0014!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001H!\tAU*D\u0001J\u0015\tQ5*\u0001\u0003mC:<'\"\u0001'\u0002\t)\fg/Y\u0005\u0003\u001d&\u0013aa\u0015;sS:<\u0017\u0001\u00049s_\u0012,8\r^!sSRLX#A)\u0011\u0005\u0011\u0012\u0016BA*\u001c\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\t1\u0016\f\u0005\u0002%/&\u0011\u0001l\u0007\u0002\u0004\u0003:L\bb\u0002.\f\u0003\u0003\u0005\r!U\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0003u\u00032AX1W\u001b\u0005y&B\u00011\u001c\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0003E~\u0013\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR\u0011Q\r\u001b\t\u0003I\u0019L!aZ\u000e\u0003\u000f\t{w\u000e\\3b]\"9!,DA\u0001\u0002\u00041\u0016\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003E\u000b\u0001\u0002^8TiJLgn\u001a\u000b\u0002\u000f\u00061Q-];bYN$\"!Z8\t\u000fi\u0003\u0012\u0011!a\u0001-\"\"\u0001!\u001d;w!\t!#/\u0003\u0002t7\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0003U\f!\u0004\u001e5jg\u0002\u001aG.Y:tA]LG\u000e\u001c\u0011cK\u0002\u0012X-\\8wK\u0012\f\u0013a^\u0001\u0007e9\n\u0014G\f\u0019\u0002\u000f\u0011{7mQ8ogB\u0011\u0001EE\n\u0004%m<\u0003#\u0002?\u0000?}\tT\"A?\u000b\u0005y\\\u0012a\u0002:v]RLW.Z\u0005\u0004\u0003\u0003i(!E!cgR\u0014\u0018m\u0019;Gk:\u001cG/[8oeQ\t\u00110A\u0003baBd\u0017\u0010F\u00032\u0003\u0013\tY\u0001C\u0003++\u0001\u0007q\u0004C\u0003.+\u0001\u0007q$A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\u0005E\u0011Q\u0004\t\u0006I\u0005M\u0011qC\u0005\u0004\u0003+Y\"AB(qi&|g\u000eE\u0003%\u00033yr$C\u0002\u0002\u001cm\u0011a\u0001V;qY\u0016\u0014\u0004\u0002CA\u0010-\u0005\u0005\t\u0019A\u0019\u0002\u0007a$\u0003'A\u0006sK\u0006$'+Z:pYZ,GCAA\u0013!\rA\u0015qE\u0005\u0004\u0003SI%AB(cU\u0016\u001cG\u000f\u000b\u0003\u0013cR4\b")
public class DocCons
extends Document
implements Product,
Serializable {
    private final Document hd;
    private final Document tl;

    public static Option<Tuple2<Document, Document>> unapply(DocCons docCons) {
        return DocCons$.MODULE$.unapply(docCons);
    }

    public static DocCons apply(Document document, Document document2) {
        return DocCons$.MODULE$.apply(document, document2);
    }

    public static Function1<Tuple2<Document, Document>, DocCons> tupled() {
        return DocCons$.MODULE$.tupled();
    }

    public static Function1<Document, Function1<Document, DocCons>> curried() {
        return DocCons$.MODULE$.curried();
    }

    public Document hd() {
        return this.hd;
    }

    public Document tl() {
        return this.tl;
    }

    public DocCons copy(Document hd, Document tl) {
        return new DocCons(hd, tl);
    }

    public Document copy$default$1() {
        return this.hd();
    }

    public Document copy$default$2() {
        return this.tl();
    }

    @Override
    public String productPrefix() {
        return "DocCons";
    }

    @Override
    public int productArity() {
        return 2;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.hd();
            }
            case 1: {
                return this.tl();
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
        return x$1 instanceof DocCons;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
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
        if (!(x$1 instanceof DocCons)) return false;
        boolean bl = true;
        if (!bl) return false;
        DocCons docCons = (DocCons)x$1;
        Document document = this.hd();
        Document document2 = docCons.hd();
        if (document == null) {
            if (document2 != null) {
                return false;
            }
        } else if (!document.equals(document2)) return false;
        Document document3 = this.tl();
        Document document4 = docCons.tl();
        if (document3 == null) {
            if (document4 != null) {
                return false;
            }
        } else if (!document3.equals(document4)) return false;
        if (!docCons.canEqual(this)) return false;
        return true;
    }

    public DocCons(Document hd, Document tl) {
        this.hd = hd;
        this.tl = tl;
        Product.$init$(this);
    }
}

