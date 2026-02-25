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
import scala.text.DocGroup$;
import scala.text.Document;

@ScalaSignature(bytes="\u0006\u0001\u0005Ua\u0001B\u000b\u0017\u0001nA\u0001b\n\u0001\u0003\u0016\u0004%\t\u0001\u000b\u0005\tS\u0001\u0011\t\u0012)A\u00059!)!\u0006\u0001C\u0001W!9a\u0006AA\u0001\n\u0003y\u0003bB\u0019\u0001#\u0003%\tA\r\u0005\b{\u0001\t\t\u0011\"\u0011?\u0011\u001d9\u0005!!A\u0005\u0002!Cq\u0001\u0014\u0001\u0002\u0002\u0013\u0005Q\nC\u0004T\u0001\u0005\u0005I\u0011\t+\t\u000fm\u0003\u0011\u0011!C\u00019\"9\u0011\rAA\u0001\n\u0003\u0012\u0007bB2\u0001\u0003\u0003%\t\u0005\u001a\u0005\bK\u0002\t\t\u0011\"\u0011g\u000f\u001d\u0001h#!A\t\u0002E4q!\u0006\f\u0002\u0002#\u0005!\u000fC\u0003+\u001f\u0011\u0005\u0011\u0010C\u0004d\u001f\u0005\u0005IQ\t3\t\u000fi|\u0011\u0011!CAw\"9QpDA\u0001\n\u0003s\b\"CA\u0005\u001f\u0005\u0005I\u0011BA\u0006\u0005!!unY$s_V\u0004(BA\f\u0019\u0003\u0011!X\r\u001f;\u000b\u0003e\tQa]2bY\u0006\u001c\u0001a\u0005\u0003\u00019\u0001\"\u0003CA\u000f\u001f\u001b\u00051\u0012BA\u0010\u0017\u0005!!unY;nK:$\bCA\u0011#\u001b\u0005A\u0012BA\u0012\u0019\u0005\u001d\u0001&o\u001c3vGR\u0004\"!I\u0013\n\u0005\u0019B\"\u0001D*fe&\fG.\u001b>bE2,\u0017a\u00013pGV\tA$\u0001\u0003e_\u000e\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0002-[A\u0011Q\u0004\u0001\u0005\u0006O\r\u0001\r\u0001H\u0001\u0005G>\u0004\u0018\u0010\u0006\u0002-a!9q\u0005\u0002I\u0001\u0002\u0004a\u0012AD2paf$C-\u001a4bk2$H%M\u000b\u0002g)\u0012A\u0004N\u0016\u0002kA\u0011agO\u0007\u0002o)\u0011\u0001(O\u0001\nk:\u001c\u0007.Z2lK\u0012T!A\u000f\r\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002=o\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\u0005y\u0004C\u0001!F\u001b\u0005\t%B\u0001\"D\u0003\u0011a\u0017M\\4\u000b\u0003\u0011\u000bAA[1wC&\u0011a)\u0011\u0002\u0007'R\u0014\u0018N\\4\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0003%\u0003\"!\t&\n\u0005-C\"aA%oi\u0006q\u0001O]8ek\u000e$X\t\\3nK:$HC\u0001(R!\t\ts*\u0003\u0002Q1\t\u0019\u0011I\\=\t\u000fIC\u0011\u0011!a\u0001\u0013\u0006\u0019\u0001\u0010J\u0019\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\u0012!\u0016\t\u0004-fsU\"A,\u000b\u0005aC\u0012AC2pY2,7\r^5p]&\u0011!l\u0016\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0002^AB\u0011\u0011EX\u0005\u0003?b\u0011qAQ8pY\u0016\fg\u000eC\u0004S\u0015\u0005\u0005\t\u0019\u0001(\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012!S\u0001\ti>\u001cFO]5oOR\tq(\u0001\u0004fcV\fGn\u001d\u000b\u0003;\u001eDqAU\u0007\u0002\u0002\u0003\u0007a\n\u000b\u0003\u0001S2t\u0007CA\u0011k\u0013\tY\u0007D\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013!\\\u0001\u001bi\"L7\u000fI2mCN\u001c\be^5mY\u0002\u0012W\r\t:f[>4X\rZ\u0011\u0002_\u00061!GL\u00192]A\n\u0001\u0002R8d\u000fJ|W\u000f\u001d\t\u0003;=\u00192aD:%!\u0011!x\u000f\b\u0017\u000e\u0003UT!A\u001e\r\u0002\u000fI,h\u000e^5nK&\u0011\u00010\u001e\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\fD#A9\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u00051b\b\"B\u0014\u0013\u0001\u0004a\u0012aB;oCB\u0004H.\u001f\u000b\u0004\u007f\u0006\u0015\u0001\u0003B\u0011\u0002\u0002qI1!a\u0001\u0019\u0005\u0019y\u0005\u000f^5p]\"A\u0011qA\n\u0002\u0002\u0003\u0007A&A\u0002yIA\n1B]3bIJ+7o\u001c7wKR\u0011\u0011Q\u0002\t\u0004\u0001\u0006=\u0011bAA\t\u0003\n1qJ\u00196fGRDCaD5m]\u0002")
public class DocGroup
extends Document
implements Product,
Serializable {
    private final Document doc;

    public static Option<Document> unapply(DocGroup docGroup) {
        return DocGroup$.MODULE$.unapply(docGroup);
    }

    public static DocGroup apply(Document document) {
        return DocGroup$.MODULE$.apply(document);
    }

    public static <A> Function1<Document, A> andThen(Function1<DocGroup, A> function1) {
        DocGroup$ docGroup$ = DocGroup$.MODULE$;
        if (docGroup$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(docGroup$, function1, arg_0);
    }

    public static <A> Function1<A, DocGroup> compose(Function1<A, Document> function1) {
        DocGroup$ docGroup$ = DocGroup$.MODULE$;
        if (docGroup$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(docGroup$, function1, arg_0);
    }

    public Document doc() {
        return this.doc;
    }

    public DocGroup copy(Document doc) {
        return new DocGroup(doc);
    }

    public Document copy$default$1() {
        return this.doc();
    }

    @Override
    public String productPrefix() {
        return "DocGroup";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
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
        return x$1 instanceof DocGroup;
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
                boolean bl = x$1 instanceof DocGroup;
                if (!bl) break block3;
                DocGroup docGroup = (DocGroup)x$1;
                Document document = this.doc();
                Document document2 = docGroup.doc();
                if (!(!(document != null ? !document.equals(document2) : document2 != null) && docGroup.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public DocGroup(Document doc) {
        this.doc = doc;
        Product.$init$(this);
    }
}

