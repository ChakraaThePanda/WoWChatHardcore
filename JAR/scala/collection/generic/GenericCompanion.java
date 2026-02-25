/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001A3QAB\u0004\u0002\u00029AQ\u0001\u0006\u0001\u0005\u0002U)a\u0001\f\u0001!\u0002#i\u0003\"\u0002\u001a\u0001\r\u0003\u0019\u0004\"B \u0001\t\u0003\u0001\u0005\"B#\u0001\t\u00031%\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o\u0015\tA\u0011\"A\u0004hK:,'/[2\u000b\u0005)Y\u0011AC2pY2,7\r^5p]*\tA\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005=Q2C\u0001\u0001\u0011!\t\t\"#D\u0001\f\u0013\t\u00192B\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003Y\u00012a\u0006\u0001\u0019\u001b\u00059\u0001CA\r\u001b\u0019\u0001!aa\u0007\u0001\u0005\u0006\u0004a\"AA\"D+\tib%\u0005\u0002\u001fCA\u0011\u0011cH\u0005\u0003A-\u0011qAT8uQ&tw\rE\u0002#G\u0015j\u0011!C\u0005\u0003I%\u0011abR3o)J\fg/\u001a:tC\ndW\r\u0005\u0002\u001aM\u0011)qE\u0007b\u0001Q\t\t\u0001,\u0005\u0002\u001fSA\u0011\u0011CK\u0005\u0003W-\u00111!\u00118z\u0005\u0011\u0019u\u000e\u001c71\u00059\u0002\u0004cA\r\u001b_A\u0011\u0011\u0004\r\u0003\nc\t\t\t\u0011!A\u0003\u0002!\u00121a\u0018\u00132\u0003)qWm\u001e\"vS2$WM]\u000b\u0003iq*\u0012!\u000e\t\u0005meZd(D\u00018\u0015\tA\u0014\"A\u0004nkR\f'\r\\3\n\u0005i:$a\u0002\"vS2$WM\u001d\t\u00033q\"Q!P\u0002C\u0002!\u0012\u0011!\u0011\t\u00043iY\u0014!B3naRLXCA!E+\u0005\u0011\u0005cA\r\u001b\u0007B\u0011\u0011\u0004\u0012\u0003\u0006{\u0011\u0011\r\u0001K\u0001\u0006CB\u0004H._\u000b\u0003\u000f*#\"\u0001S&\u0011\u0007eQ\u0012\n\u0005\u0002\u001a\u0015\u0012)Q(\u0002b\u0001Q!)A*\u0002a\u0001\u001b\u0006)Q\r\\3ngB\u0019\u0011CT%\n\u0005=[!A\u0003\u001fsKB,\u0017\r^3e}\u0001")
public abstract class GenericCompanion<CC extends GenTraversable<Object>> {
    public abstract <A> Builder<A, CC> newBuilder();

    public <A> CC empty() {
        if (this == scala.collection.immutable.Seq$.MODULE$ || this == Seq$.MODULE$) {
            return (CC)Nil$.MODULE$;
        }
        return (CC)((GenTraversable)this.newBuilder().result());
    }

    public <A> CC apply(Seq<A> elems) {
        if (elems.isEmpty()) {
            return this.empty();
        }
        Builder<A, CC> b = this.newBuilder();
        b.$plus$plus$eq(elems);
        return (CC)((GenTraversable)b.result());
    }
}

