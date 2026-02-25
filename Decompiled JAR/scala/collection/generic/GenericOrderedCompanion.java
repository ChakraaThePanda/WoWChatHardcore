/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.mutable.Builder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}3QAB\u0004\u0002\u00029AQ\u0001\u0006\u0001\u0005\u0002U)a\u0001\f\u0001!\u0002#i\u0003\"\u0002\u001a\u0001\r\u0003\u0019\u0004\"\u0002%\u0001\t\u0003I\u0005\"B)\u0001\t\u0003\u0011&aF$f]\u0016\u0014\u0018nY(sI\u0016\u0014X\rZ\"p[B\fg.[8o\u0015\tA\u0011\"A\u0004hK:,'/[2\u000b\u0005)Y\u0011AC2pY2,7\r^5p]*\tA\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005=Q2C\u0001\u0001\u0011!\t\t\"#D\u0001\f\u0013\t\u00192B\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003Y\u00012a\u0006\u0001\u0019\u001b\u00059\u0001CA\r\u001b\u0019\u0001!aa\u0007\u0001\u0005\u0006\u0004a\"AA\"D+\tib%\u0005\u0002\u001fCA\u0011\u0011cH\u0005\u0003A-\u0011qAT8uQ&tw\rE\u0002#G\u0015j\u0011!C\u0005\u0003I%\u00111\u0002\u0016:bm\u0016\u00148/\u00192mKB\u0011\u0011D\n\u0003\u0006Oi\u0011\r\u0001\u000b\u0002\u00021F\u0011a$\u000b\t\u0003#)J!aK\u0006\u0003\u0007\u0005s\u0017P\u0001\u0003D_2d\u0007G\u0001\u00181!\rI\"d\f\t\u00033A\"\u0011\"\r\u0002\u0002\u0002\u0003\u0005)\u0011\u0001\u0015\u0003\u0007}#\u0013'\u0001\u0006oK^\u0014U/\u001b7eKJ,\"\u0001\u000e\u001f\u0015\u0005Uz\u0004\u0003\u0002\u001c:wyj\u0011a\u000e\u0006\u0003q%\tq!\\;uC\ndW-\u0003\u0002;o\t9!)^5mI\u0016\u0014\bCA\r=\t\u0015i4A1\u0001)\u0005\u0005\t\u0005cA\r\u001bw!)\u0001i\u0001a\u0002\u0003\u0006\u0019qN\u001d3\u0011\u0007\t+5H\u0004\u0002\u0012\u0007&\u0011AiC\u0001\ba\u0006\u001c7.Y4f\u0013\t1uI\u0001\u0005Pe\u0012,'/\u001b8h\u0015\t!5\"A\u0003f[B$\u00180\u0006\u0002K\u001bR\u00111J\u0014\t\u00043ia\u0005CA\rN\t\u0015iDA1\u0001)\u0011\u001dyE!!AA\u0004A\u000b!\"\u001a<jI\u0016t7-\u001a\u00132!\r\u0011U\tT\u0001\u0006CB\u0004H._\u000b\u0003'^#\"\u0001\u0016.\u0015\u0005UC\u0006cA\r\u001b-B\u0011\u0011d\u0016\u0003\u0006{\u0015\u0011\r\u0001\u000b\u0005\u0006\u0001\u0016\u0001\u001d!\u0017\t\u0004\u0005\u00163\u0006\"B.\u0006\u0001\u0004a\u0016!B3mK6\u001c\bcA\t^-&\u0011al\u0003\u0002\u000byI,\u0007/Z1uK\u0012t\u0004")
public abstract class GenericOrderedCompanion<CC extends Traversable<Object>> {
    public abstract <A> Builder<A, CC> newBuilder(Ordering<A> var1);

    public <A> CC empty(Ordering<A> evidence$1) {
        return (CC)((Traversable)this.newBuilder(evidence$1).result());
    }

    public <A> CC apply(Seq<A> elems, Ordering<A> ord) {
        Builder<A, CC> b = this.newBuilder(ord);
        b.$plus$plus$eq(elems);
        return (CC)((Traversable)b.result());
    }
}

