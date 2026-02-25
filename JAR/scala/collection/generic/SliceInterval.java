/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Predef$;
import scala.collection.generic.SliceInterval$;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001i2Q!\u0004\b\u0001!QA\u0001\"\u0007\u0001\u0003\u0006\u0004%\ta\u0007\u0005\t?\u0001\u0011\t\u0011)A\u00059!A\u0001\u0005\u0001BC\u0002\u0013\u00051\u0004\u0003\u0005\"\u0001\t\u0005\t\u0015!\u0003\u001d\u0011\u0015\u0011\u0003\u0001\"\u0003$\u0011\u0015A\u0003\u0001\"\u0001\u001c\u0011\u0015I\u0003\u0001\"\u0001+\u0011\u0015I\u0003\u0001\"\u00010\u000f\u0015\u0011d\u0002#\u00014\r\u0015ia\u0002#\u00015\u0011\u0015\u0011#\u0002\"\u00016\u0011\u00151$\u0002\"\u00018\u00055\u0019F.[2f\u0013:$XM\u001d<bY*\u0011q\u0002E\u0001\bO\u0016tWM]5d\u0015\t\t\"#\u0001\u0006d_2dWm\u0019;j_:T\u0011aE\u0001\u0006g\u000e\fG.Y\n\u0003\u0001U\u0001\"AF\f\u000e\u0003II!\u0001\u0007\n\u0003\r\u0005s\u0017PU3g\u0003\u00111'o\\7\u0004\u0001U\tA\u0004\u0005\u0002\u0017;%\u0011aD\u0005\u0002\u0004\u0013:$\u0018!\u00024s_6\u0004\u0013!B;oi&d\u0017AB;oi&d\u0007%\u0001\u0004=S:LGO\u0010\u000b\u0004I\u0019:\u0003CA\u0013\u0001\u001b\u0005q\u0001\"B\r\u0006\u0001\u0004a\u0002\"\u0002\u0011\u0006\u0001\u0004a\u0012!B<jIRD\u0017a\u0003:fG\u0006d7-\u001e7bi\u0016$2\u0001J\u0016.\u0011\u0015as\u00011\u0001\u001d\u0003\u0015yfM]8n\u0011\u0015qs\u00011\u0001\u001d\u0003\u0019yVO\u001c;jYR\u0011A\u0005\r\u0005\u0006c!\u0001\r\u0001J\u0001\tS:$XM\u001d<bY\u0006i1\u000b\\5dK&sG/\u001a:wC2\u0004\"!\n\u0006\u0014\u0005))B#A\u001a\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0007\u0011B\u0014\bC\u0003\u001a\u0019\u0001\u0007A\u0004C\u0003!\u0019\u0001\u0007A\u0004")
public class SliceInterval {
    private final int from;
    private final int until;

    public static SliceInterval apply(int n, int n2) {
        return SliceInterval$.MODULE$.apply(n, n2);
    }

    public int from() {
        return this.from;
    }

    public int until() {
        return this.until;
    }

    public int width() {
        return this.until() - this.from();
    }

    public SliceInterval recalculate(int _from, int _until) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int lo = RichInt$.MODULE$.max$extension(_from, 0);
        int elems = package$.MODULE$.min(_until - lo, this.width());
        int start = this.from() + lo;
        if (elems <= 0) {
            return new SliceInterval(this.from(), this.from());
        }
        return new SliceInterval(start, start + elems);
    }

    public SliceInterval recalculate(SliceInterval interval) {
        return this.recalculate(interval.from(), interval.until());
    }

    public SliceInterval(int from, int until) {
        this.from = from;
        this.until = until;
    }
}

