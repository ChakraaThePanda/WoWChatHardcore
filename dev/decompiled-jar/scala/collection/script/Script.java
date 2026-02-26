/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.script;

import scala.collection.Iterator;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.script.Message;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001m2Aa\u0001\u0003\u0001\u0017!)1\u0005\u0001C\u0001I!)a\u0005\u0001C!O\t11k\u0019:jaRT!!\u0002\u0004\u0002\rM\u001c'/\u001b9u\u0015\t9\u0001\"\u0001\u0006d_2dWm\u0019;j_:T\u0011!C\u0001\u0006g\u000e\fG.Y\u0002\u0001+\ta\u0011dE\u0002\u0001\u001bM\u00012AD\t\u0014\u001b\u0005y!B\u0001\t\u0007\u0003\u001diW\u000f^1cY\u0016L!AE\b\u0003\u0017\u0005\u0013(/Y=Ck\u001a4WM\u001d\t\u0004)U9R\"\u0001\u0003\n\u0005Y!!aB'fgN\fw-\u001a\t\u00031ea\u0001\u0001B\u0003\u001b\u0001\t\u00071DA\u0001B#\ta\u0002\u0005\u0005\u0002\u001e=5\t\u0001\"\u0003\u0002 \u0011\t9aj\u001c;iS:<\u0007CA\u000f\"\u0013\t\u0011\u0003BA\u0002B]f\fa\u0001P5oSRtD#A\u0013\u0011\u0007Q\u0001q#\u0001\u0005u_N#(/\u001b8h)\u0005A\u0003CA\u00151\u001d\tQc\u0006\u0005\u0002,\u00115\tAF\u0003\u0002.\u0015\u00051AH]8pizJ!a\f\u0005\u0002\rA\u0013X\rZ3g\u0013\t\t$G\u0001\u0004TiJLgn\u001a\u0006\u0003_!AC\u0001\u0001\u001b8sA\u0011Q$N\u0005\u0003m!\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005A\u0014aF:de&\u0004H/\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eC\u0005Q\u0014A\u0002\u001a/cEr\u0003\u0007")
public class Script<A>
extends ArrayBuffer<Message<A>>
implements Message<A> {
    @Override
    public String toString() {
        String res = "Script(";
        Iterator it = this.iterator();
        int i = 1;
        while (it.hasNext()) {
            if (i > 1) {
                res = new StringBuilder(2).append(res).append(", ").toString();
            }
            res = new StringBuilder(3).append(res).append("[").append(i).append("] ").append(it.next()).toString();
            ++i;
        }
        return new StringBuilder(1).append(res).append(")").toString();
    }
}

