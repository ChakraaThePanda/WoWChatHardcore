/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.mutable.Builder;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001y3QAB\u0004\u0002\u00029AQ\u0001\u0006\u0001\u0005\u0002U)a\u0001\f\u0001!\u0002#i\u0003\"\u0002\u001a\u0001\r\u0003\u0019\u0004\"B$\u0001\t\u0003A\u0005\"\u0002)\u0001\t\u0003\t&\u0001G$f]\u0016\u0014\u0018nY\"mCN\u001cH+Y4D_6\u0004\u0018M\\5p]*\u0011\u0001\"C\u0001\bO\u0016tWM]5d\u0015\tQ1\"\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001D\u0001\u0006g\u000e\fG.Y\u0002\u0001+\ty!d\u0005\u0002\u0001!A\u0011\u0011CE\u0007\u0002\u0017%\u00111c\u0003\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u00051\u0002cA\f\u000115\tq\u0001\u0005\u0002\u001a51\u0001AAB\u000e\u0001\t\u000b\u0007AD\u0001\u0002D\u0007V\u0011QDJ\t\u0003=\u0005\u0002\"!E\u0010\n\u0005\u0001Z!a\u0002(pi\"Lgn\u001a\t\u0004E\r*S\"A\u0005\n\u0005\u0011J!a\u0003+sCZ,'o]1cY\u0016\u0004\"!\u0007\u0014\u0005\u000b\u001dR\"\u0019\u0001\u0015\u0003\u0003a\u000b\"AH\u0015\u0011\u0005EQ\u0013BA\u0016\f\u0005\r\te.\u001f\u0002\u0005\u0007>dG\u000e\r\u0002/aA\u0019\u0011DG\u0018\u0011\u0005e\u0001D!C\u0019\u0003\u0003\u0003\u0005\tQ!\u0001)\u0005\ryF%M\u0001\u000b]\u0016<()^5mI\u0016\u0014XC\u0001\u001b=)\t)t\b\u0005\u00037smrT\"A\u001c\u000b\u0005aJ\u0011aB7vi\u0006\u0014G.Z\u0005\u0003u]\u0012qAQ;jY\u0012,'\u000f\u0005\u0002\u001ay\u0011)Qh\u0001b\u0001Q\t\t\u0011\tE\u0002\u001a5mBQ\u0001Q\u0002A\u0004\u0005\u000b1a\u001c:e!\r\u0011UiO\u0007\u0002\u0007*\u0011AiC\u0001\be\u00164G.Z2u\u0013\t15I\u0001\u0005DY\u0006\u001c8\u000fV1h\u0003\u0015)W\u000e\u001d;z+\tIE\n\u0006\u0002K\u001bB\u0019\u0011DG&\u0011\u0005eaE!B\u001f\u0005\u0005\u0004A\u0003b\u0002(\u0005\u0003\u0003\u0005\u001daT\u0001\u000bKZLG-\u001a8dK\u0012\n\u0004c\u0001\"F\u0017\u0006)\u0011\r\u001d9msV\u0011!K\u0016\u000b\u0003'f#\"\u0001V,\u0011\u0007eQR\u000b\u0005\u0002\u001a-\u0012)Q(\u0002b\u0001Q!)\u0001)\u0002a\u00021B\u0019!)R+\t\u000bi+\u0001\u0019A.\u0002\u000b\u0015dW-\\:\u0011\u0007EaV+\u0003\u0002^\u0017\tQAH]3qK\u0006$X\r\u001a ")
public abstract class GenericClassTagCompanion<CC extends Traversable<Object>> {
    public abstract <A> Builder<A, CC> newBuilder(ClassTag<A> var1);

    public <A> CC empty(ClassTag<A> evidence$1) {
        return (CC)((Traversable)this.newBuilder(evidence$1).result());
    }

    public <A> CC apply(Seq<A> elems, ClassTag<A> ord) {
        Builder<A, CC> b = this.newBuilder(ord);
        b.$plus$plus$eq(elems);
        return (CC)((Traversable)b.result());
    }
}

