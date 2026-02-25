/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.Serializable;
import scala.collection.LinearSeq;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.generic.Clearable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00013qAB\u0004\u0011\u0002\u0007\u0005a\u0002C\u0003\u0019\u0001\u0011\u0005\u0011\u0004C\u0003\u001e\u0001\u0019\u0005a\u0004C\u0003\u001e\u0001\u0011\u0005Q\u0006C\u00038\u0001\u0011\u0005\u0001\bC\u0003@\u0001\u0019\u0005\u0011D\u0001\u0005He><\u0018M\u00197f\u0015\tA\u0011\"A\u0004hK:,'/[2\u000b\u0005)Y\u0011AC2pY2,7\r^5p]*\tA\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005=!3c\u0001\u0001\u0011)A\u0011\u0011CE\u0007\u0002\u0017%\u00111c\u0003\u0002\u0007\u0003:L(+\u001a4\u0011\u0005U1R\"A\u0004\n\u0005]9!!C\"mK\u0006\u0014\u0018M\u00197f\u0003\u0019!\u0013N\\5uIQ\t!\u0004\u0005\u0002\u00127%\u0011Ad\u0003\u0002\u0005+:LG/\u0001\u0005%a2,8\u000fJ3r)\ty\u0002%D\u0001\u0001\u0011\u0015\t#\u00011\u0001#\u0003\u0011)G.Z7\u0011\u0005\r\"C\u0002\u0001\u0003\u0007K\u0001A)\u0019\u0001\u0014\u0003\u0003\u0005\u000b\"a\n\u0016\u0011\u0005EA\u0013BA\u0015\f\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!E\u0016\n\u00051Z!aA!osR!qD\f\u00193\u0011\u0015y3\u00011\u0001#\u0003\u0015)G.Z72\u0011\u0015\t4\u00011\u0001#\u0003\u0015)G.Z73\u0011\u0015\u00194\u00011\u00015\u0003\u0015)G.Z7t!\r\tRGI\u0005\u0003m-\u0011!\u0002\u0010:fa\u0016\fG/\u001a3?\u00035!\u0003\u000f\\;tIAdWo\u001d\u0013fcR\u0011q$\u000f\u0005\u0006u\u0011\u0001\raO\u0001\u0003qN\u00042\u0001P\u001f#\u001b\u0005I\u0011B\u0001 \n\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0017!B2mK\u0006\u0014\b")
public interface Growable<A>
extends Clearable {
    public Growable<A> $plus$eq(A var1);

    public static /* synthetic */ Growable $plus$eq$(Growable $this, Object elem1, Object elem2, Seq elems) {
        return $this.$plus$eq(elem1, elem2, elems);
    }

    default public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return this.$plus$eq(elem1).$plus$eq(elem2).$plus$plus$eq(elems);
    }

    public static /* synthetic */ Growable $plus$plus$eq$(Growable $this, TraversableOnce xs) {
        return $this.$plus$plus$eq(xs);
    }

    default public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
        if (xs instanceof LinearSeq) {
            LinearSeq linearSeq = (LinearSeq)xs;
            this.loop$1(linearSeq);
        } else {
            xs.foreach((Function1<Object, Growable> & java.io.Serializable & Serializable)elem -> this.$plus$eq(elem));
        }
        return this;
    }

    @Override
    public void clear();

    private void loop$1(LinearSeq xs) {
        while (xs.nonEmpty()) {
            this.$plus$eq(xs.head());
            xs = (LinearSeq)xs.tail();
        }
    }

    public static void $init$(Growable $this) {
    }
}

