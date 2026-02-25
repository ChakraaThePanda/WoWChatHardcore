/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Product;
import scala.Serializable;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.Searching$;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.generic.IsSeqLike;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\tms!\u0002\u001e<\u0011\u0003\u0001e!\u0002\"<\u0011\u0003\u0019\u0005\"\u0002%\u0002\t\u0003Ie!\u0002&\u0002\u0003CY\u0005\"\u0002%\u0004\t\u0003a\u0005\"B(\u0004\r\u0003\u0001f\u0001B+\u0002\u0001ZC\u0001\"\u0018\u0004\u0003\u0016\u0004%\t\u0001\u0015\u0005\t=\u001a\u0011\t\u0012)A\u0005#\")\u0001J\u0002C\u0001?\")qJ\u0002C!!\"9!MBA\u0001\n\u0003\u0019\u0007bB3\u0007#\u0003%\tA\u001a\u0005\bc\u001a\t\t\u0011\"\u0011s\u0011\u001dYh!!A\u0005\u0002ACq\u0001 \u0004\u0002\u0002\u0013\u0005Q\u0010C\u0005\u0002\b\u0019\t\t\u0011\"\u0011\u0002\n!I\u0011\u0011\u0003\u0004\u0002\u0002\u0013\u0005\u00111\u0003\u0005\n\u0003;1\u0011\u0011!C!\u0003?A\u0011\"!\t\u0007\u0003\u0003%\t%a\t\t\u0013\u0005\u0015b!!A\u0005B\u0005\u001dr!CA$\u0003\u0005\u0005\t\u0012AA%\r!)\u0016!!A\t\u0002\u0005-\u0003B\u0002%\u0017\t\u0003\tI\u0006C\u0005\u0002\"Y\t\t\u0011\"\u0012\u0002$!I\u00111\f\f\u0002\u0002\u0013\u0005\u0015Q\f\u0005\n\u0003C2\u0012\u0011!CA\u0003GB\u0011\"a\u001c\u0017\u0003\u0003%I!!\u001d\u0007\r\u0005-\u0012\u0001QA\u0017\u0011!yED!f\u0001\n\u0003\u0001\u0006\"CA\u00189\tE\t\u0015!\u0003R\u0011\u0019AE\u0004\"\u0001\u00022!A!\rHA\u0001\n\u0003\t9\u0004C\u0004f9E\u0005I\u0011\u00014\t\u000fEd\u0012\u0011!C!e\"91\u0010HA\u0001\n\u0003\u0001\u0006\u0002\u0003?\u001d\u0003\u0003%\t!a\u000f\t\u0013\u0005\u001dA$!A\u0005B\u0005%\u0001\"CA\t9\u0005\u0005I\u0011AA \u0011%\ti\u0002HA\u0001\n\u0003\ny\u0002C\u0005\u0002\"q\t\t\u0011\"\u0011\u0002$!I\u0011Q\u0005\u000f\u0002\u0002\u0013\u0005\u00131I\u0004\n\u0003s\n\u0011\u0011!E\u0001\u0003w2\u0011\"a\u000b\u0002\u0003\u0003E\t!! \t\r![C\u0011AAA\u0011%\t\tcKA\u0001\n\u000b\n\u0019\u0003C\u0005\u0002\\-\n\t\u0011\"!\u0002\u0004\"I\u0011\u0011M\u0016\u0002\u0002\u0013\u0005\u0015q\u0011\u0005\n\u0003_Z\u0013\u0011!C\u0005\u0003c2a!a#\u0002\u0001\u00055\u0005BCAIc\t\u0015\r\u0011\"\u0001\u0002\u0014\"Q\u0011\u0011W\u0019\u0003\u0002\u0003\u0006I!!&\t\r!\u000bD\u0011AAZ\u0011\u001d\tI,\rC\u0003\u0003wCq!!/2\t\u000b\ti\u000eC\u0004\u0002vF\"I!a>\t\u000f\tU\u0011\u0007\"\u0003\u0003\u0018!9\u0011\u0011X\u0001\u0005\u0004\tU\u0012!C*fCJ\u001c\u0007.\u001b8h\u0015\taT(\u0001\u0006d_2dWm\u0019;j_:T\u0011AP\u0001\u0006g\u000e\fG.Y\u0002\u0001!\t\t\u0015!D\u0001<\u0005%\u0019V-\u0019:dQ&twm\u0005\u0002\u0002\tB\u0011QIR\u0007\u0002{%\u0011q)\u0010\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005\u0001%\u0001D*fCJ\u001c\u0007NU3tk2$8CA\u0002E)\u0005i\u0005C\u0001(\u0004\u001b\u0005\t\u0011AD5og\u0016\u0014H/[8o!>Lg\u000e^\u000b\u0002#B\u0011QIU\u0005\u0003'v\u00121!\u00138uS\r\u0019a\u0001\b\u0002\u0006\r>,h\u000eZ\n\u0005\r5;&\f\u0005\u0002F1&\u0011\u0011,\u0010\u0002\b!J|G-^2u!\t)5,\u0003\u0002]{\ta1+\u001a:jC2L'0\u00192mK\u0006Qam\\;oI&sG-\u001a=\u0002\u0017\u0019|WO\u001c3J]\u0012,\u0007\u0010\t\u000b\u0003A\u0006\u0004\"A\u0014\u0004\t\u000buK\u0001\u0019A)\u0002\t\r|\u0007/\u001f\u000b\u0003A\u0012Dq!X\u0006\u0011\u0002\u0003\u0007\u0011+\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0003\u001dT#!\u00155,\u0003%\u0004\"A[8\u000e\u0003-T!\u0001\\7\u0002\u0013Ut7\r[3dW\u0016$'B\u00018>\u0003)\tgN\\8uCRLwN\\\u0005\u0003a.\u0014\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\t1\u000f\u0005\u0002us6\tQO\u0003\u0002wo\u0006!A.\u00198h\u0015\u0005A\u0018\u0001\u00026bm\u0006L!A_;\u0003\rM#(/\u001b8h\u00031\u0001(o\u001c3vGR\f%/\u001b;z\u00039\u0001(o\u001c3vGR,E.Z7f]R$2A`A\u0002!\t)u0C\u0002\u0002\u0002u\u00121!\u00118z\u0011!\t)aDA\u0001\u0002\u0004\t\u0016a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/\u0006\u0002\u0002\fA!\u0011)!\u0004\u007f\u0013\r\tya\u000f\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002\u0016\u0005m\u0001cA#\u0002\u0018%\u0019\u0011\u0011D\u001f\u0003\u000f\t{w\u000e\\3b]\"A\u0011QA\t\u0002\u0002\u0003\u0007a0\u0001\u0005iCND7i\u001c3f)\u0005\t\u0016\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003M\fa!Z9vC2\u001cH\u0003BA\u000b\u0003SA\u0001\"!\u0002\u0015\u0003\u0003\u0005\rA \u0002\u000f\u0013:\u001cXM\u001d;j_:\u0004v.\u001b8u'\u0011aRj\u0016.\u0002\u001f%t7/\u001a:uS>t\u0007k\\5oi\u0002\"B!a\r\u00026A\u0011a\n\b\u0005\u0006\u001f~\u0001\r!\u0015\u000b\u0005\u0003g\tI\u0004C\u0004PAA\u0005\t\u0019A)\u0015\u0007y\fi\u0004\u0003\u0005\u0002\u0006\u0011\n\t\u00111\u0001R)\u0011\t)\"!\u0011\t\u0011\u0005\u0015a%!AA\u0002y$B!!\u0006\u0002F!A\u0011QA\u0015\u0002\u0002\u0003\u0007a0A\u0003G_VtG\r\u0005\u0002O-M!a#!\u0014[!\u0019\ty%!\u0016RA6\u0011\u0011\u0011\u000b\u0006\u0004\u0003'j\u0014a\u0002:v]RLW.Z\u0005\u0005\u0003/\n\tFA\tBEN$(/Y2u\rVt7\r^5p]F\"\"!!\u0013\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0007\u0001\fy\u0006C\u0003^3\u0001\u0007\u0011+A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\u0005\u0015\u00141\u000e\t\u0005\u000b\u0006\u001d\u0014+C\u0002\u0002ju\u0012aa\u00149uS>t\u0007\u0002CA75\u0005\u0005\t\u0019\u00011\u0002\u0007a$\u0003'A\u0006sK\u0006$'+Z:pYZ,GCAA:!\r!\u0018QO\u0005\u0004\u0003o*(AB(cU\u0016\u001cG/\u0001\bJ]N,'\u000f^5p]B{\u0017N\u001c;\u0011\u00059[3\u0003B\u0016\u0002\u0000i\u0003r!a\u0014\u0002VE\u000b\u0019\u0004\u0006\u0002\u0002|Q!\u00111GAC\u0011\u0015ye\u00061\u0001R)\u0011\t)'!#\t\u0013\u00055t&!AA\u0002\u0005M\"AC*fCJ\u001c\u0007.S7qYV1\u0011qRAP\u0003[\u001b\"!\r#\u0002\t\r|G\u000e\\\u000b\u0003\u0003+\u0003r!QAL\u00037\u000bY+C\u0002\u0002\u001an\u0012qaU3r\u0019&\\W\r\u0005\u0003\u0002\u001e\u0006}E\u0002\u0001\u0003\b\u0003C\u000b$\u0019AAR\u0005\u0005\t\u0015cAAS}B\u0019Q)a*\n\u0007\u0005%VHA\u0004O_RD\u0017N\\4\u0011\t\u0005u\u0015Q\u0016\u0003\b\u0003_\u000b$\u0019AAR\u0005\u0011\u0011V\r\u001d:\u0002\u000b\r|G\u000e\u001c\u0011\u0015\t\u0005U\u0016q\u0017\t\u0007\u001dF\nY*a+\t\u000f\u0005EE\u00071\u0001\u0002\u0016\u000611/Z1sG\",B!!0\u0002TR!\u0011qXAm)\ri\u0015\u0011\u0019\u0005\b\u0003\u0007,\u00049AAc\u0003\ry'\u000f\u001a\t\u0007\u0003\u000f\fi-!5\u000e\u0005\u0005%'bAAf{\u0005!Q.\u0019;i\u0013\u0011\ty-!3\u0003\u0011=\u0013H-\u001a:j]\u001e\u0004B!!(\u0002T\u00129\u0011Q[\u001bC\u0002\u0005]'!\u0001\"\u0012\u0007\u0005me\u0010C\u0004\u0002\\V\u0002\r!!5\u0002\t\u0015dW-\\\u000b\u0005\u0003?\fI\u000f\u0006\u0005\u0002b\u0006-\u0018Q^Ay)\ri\u00151\u001d\u0005\b\u0003\u00074\u00049AAs!\u0019\t9-!4\u0002hB!\u0011QTAu\t\u001d\t)N\u000eb\u0001\u0003/Dq!a77\u0001\u0004\t9\u000f\u0003\u0004\u0002pZ\u0002\r!U\u0001\u0005MJ|W\u000e\u0003\u0004\u0002tZ\u0002\r!U\u0001\u0003i>\fABY5oCJL8+Z1sG\",B!!?\u0003\u0004QA\u00111 B\u0003\u0005\u000f\u0011I\u0001F\u0002N\u0003{Dq!a18\u0001\b\ty\u0010\u0005\u0004\u0002H\u00065'\u0011\u0001\t\u0005\u0003;\u0013\u0019\u0001B\u0004\u0002V^\u0012\r!a6\t\u000f\u0005mw\u00071\u0001\u0003\u0002!1\u0011q^\u001cA\u0002ECa!a=8\u0001\u0004\t\u0006fA\u001c\u0003\u000eA!!q\u0002B\t\u001b\u0005i\u0017b\u0001B\n[\n9A/Y5me\u0016\u001c\u0017\u0001\u00047j]\u0016\f'oU3be\u000eDW\u0003\u0002B\r\u0005G!\u0002Ba\u0007\u0003&\t=\"\u0011\u0007\u000b\u0004\u001b\nu\u0001bBAbq\u0001\u000f!q\u0004\t\u0007\u0003\u000f\fiM!\t\u0011\t\u0005u%1\u0005\u0003\b\u0003+D$\u0019AAl\u0011\u001d\u00119\u0003\u000fa\u0001\u0005S\t\u0011a\u0019\t\b\u0003\n-\u00121TAV\u0013\r\u0011ic\u000f\u0002\b'\u0016\fh+[3x\u0011\u001d\tY\u000e\u000fa\u0001\u0005CAaAa\r9\u0001\u0004\t\u0016AB8gMN,G/\u0006\u0004\u00038\tM#\u0011\f\u000b\u0005\u0005s\u00119\u0006\u0006\u0003\u0003<\t\u0005\u0003C\u0002(2\u0005{\u0011\t\u0006\u0005\u0003\u0003@\tUc\u0002BAO\u0005\u0003BqAa\u0011:\u0001\b\u0011)%\u0001\u0002geB1!q\tB'\u0005#j!A!\u0013\u000b\u0007\t-3(A\u0004hK:,'/[2\n\t\t=#\u0011\n\u0002\n\u0013N\u001cV-\u001d'jW\u0016\u0004B!!(\u0003T\u00119\u0011qV\u001dC\u0002\u0005\r\u0016\u0002BAQ\u0005\u001bBq!!%:\u0001\u0004\u0011\t\u0006B\u0004\u0002\"f\u0012\r!a)")
public final class Searching {
    public static <Repr, A> SearchImpl<Object, Repr> search(Repr Repr, IsSeqLike<Repr> isSeqLike) {
        return Searching$.MODULE$.search(Repr, isSeqLike);
    }

    public static class Found
    extends SearchResult
    implements Product,
    Serializable {
        private final int foundIndex;

        public int foundIndex() {
            return this.foundIndex;
        }

        @Override
        public int insertionPoint() {
            return this.foundIndex();
        }

        public Found copy(int foundIndex) {
            return new Found(foundIndex);
        }

        public int copy$default$1() {
            return this.foundIndex();
        }

        @Override
        public String productPrefix() {
            return "Found";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return BoxesRunTime.boxToInteger(this.foundIndex());
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
            return x$1 instanceof Found;
        }

        public int hashCode() {
            return Statics.finalizeHash(Statics.mix(-889275714, this.foundIndex()), 1);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof Found;
                    if (!bl) break block3;
                    Found found = (Found)x$1;
                    if (!(this.foundIndex() == found.foundIndex() && found.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public Found(int foundIndex) {
            this.foundIndex = foundIndex;
            Product.$init$(this);
        }
    }

    public static class InsertionPoint
    extends SearchResult
    implements Product,
    Serializable {
        private final int insertionPoint;

        @Override
        public int insertionPoint() {
            return this.insertionPoint;
        }

        public InsertionPoint copy(int insertionPoint) {
            return new InsertionPoint(insertionPoint);
        }

        public int copy$default$1() {
            return this.insertionPoint();
        }

        @Override
        public String productPrefix() {
            return "InsertionPoint";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return BoxesRunTime.boxToInteger(this.insertionPoint());
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
            return x$1 instanceof InsertionPoint;
        }

        public int hashCode() {
            return Statics.finalizeHash(Statics.mix(-889275714, this.insertionPoint()), 1);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof InsertionPoint;
                    if (!bl) break block3;
                    InsertionPoint insertionPoint = (InsertionPoint)x$1;
                    if (!(this.insertionPoint() == insertionPoint.insertionPoint() && insertionPoint.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public InsertionPoint(int insertionPoint) {
            this.insertionPoint = insertionPoint;
            Product.$init$(this);
        }
    }

    public static class SearchImpl<A, Repr> {
        private final SeqLike<A, Repr> coll;

        public SeqLike<A, Repr> coll() {
            return this.coll;
        }

        public final <B> SearchResult search(B elem, Ordering<B> ord) {
            SearchResult searchResult = this.coll() instanceof IndexedSeqLike ? this.binarySearch(elem, 0, this.coll().length(), ord) : this.linearSearch(this.coll().view(), elem, 0, ord);
            return searchResult;
        }

        public final <B> SearchResult search(B elem, int from, int to, Ordering<B> ord) {
            SearchResult searchResult = this.coll() instanceof IndexedSeqLike ? this.binarySearch(elem, from, to, ord) : this.linearSearch(this.coll().view(from, to), elem, from, ord);
            return searchResult;
        }

        private <B> SearchResult binarySearch(B elem, int from, int to, Ordering<B> ord) {
            int idx;
            block4: while (true) {
                if (to == from) {
                    return new InsertionPoint(from);
                }
                idx = from + (to - from - 1) / 2;
                switch (package$.MODULE$.signum(ord.compare(elem, this.coll().apply(idx)))) {
                    case -1: {
                        to = idx;
                        continue block4;
                    }
                    case 1: {
                        from = idx + 1;
                        continue block4;
                    }
                }
                break;
            }
            return new Found(idx);
        }

        private <B> SearchResult linearSearch(SeqView<A, Repr> c, B elem, int offset, Ordering<B> ord) {
            int idx = offset;
            Iterator it = c.iterator();
            while (it.hasNext()) {
                Object cur = it.next();
                if (ord.equiv(elem, cur)) {
                    return new Found(idx);
                }
                if (ord.lt(elem, cur)) {
                    return new InsertionPoint(idx);
                }
                ++idx;
            }
            return new InsertionPoint(idx);
        }

        public SearchImpl(SeqLike<A, Repr> coll) {
            this.coll = coll;
        }
    }

    public static abstract class SearchResult {
        public abstract int insertionPoint();
    }
}

