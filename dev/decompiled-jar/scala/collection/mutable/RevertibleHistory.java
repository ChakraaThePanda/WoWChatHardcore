/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.MatchError;
import scala.Tuple2;
import scala.collection.AbstractTraversable;
import scala.collection.immutable.List;
import scala.collection.mutable.History;
import scala.collection.mutable.Undoable;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001=2Aa\u0001\u0003\u0001\u0017!)q\u0005\u0001C\u0001Q!)!\u0006\u0001C\u0001W\t\t\"+\u001a<feRL'\r\\3ISN$xN]=\u000b\u0005\u00151\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0003\u000f!\t!bY8mY\u0016\u001cG/[8o\u0015\u0005I\u0011!B:dC2\f7\u0001A\u000b\u0004\u0019Mq2\u0003\u0002\u0001\u000e5\u0011\u0002BAD\b\u0012;5\tA!\u0003\u0002\u0011\t\t9\u0001*[:u_JL\bC\u0001\n\u0014\u0019\u0001!Q\u0001\u0006\u0001C\u0002U\u00111!\u0012<u#\t1\"\u0004\u0005\u0002\u001815\t\u0001\"\u0003\u0002\u001a\u0011\t9aj\u001c;iS:<\u0007C\u0001\b\u001c\u0013\taBA\u0001\u0005V]\u0012|\u0017M\u00197f!\t\u0011b\u0004B\u0003 \u0001\t\u0007\u0001EA\u0002Qk\n\f\"AF\u0011\u0011\u0005]\u0011\u0013BA\u0012\t\u0005\r\te.\u001f\t\u0003/\u0015J!A\n\u0005\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\u0005I\u0003\u0003\u0002\b\u0001#u\tA!\u001e8e_R\tA\u0006\u0005\u0002\u0018[%\u0011a\u0006\u0003\u0002\u0005+:LG\u000f")
public class RevertibleHistory<Evt extends Undoable, Pub>
extends History<Evt, Pub>
implements Undoable {
    @Override
    public void undo() {
        Object old = this.log().toList().reverse();
        this.clear();
        if (old == null) {
            throw null;
        }
        Object foreach_these = old;
        while (!((List)foreach_these).isEmpty()) {
            RevertibleHistory.$anonfun$undo$1$adapted((Tuple2)((List)foreach_these).head());
            foreach_these = (List)((AbstractTraversable)foreach_these).tail();
        }
    }

    public static final /* synthetic */ void $anonfun$undo$1(Tuple2 x0$1) {
        if (x0$1 != null) {
            ((Undoable)x0$1._2()).undo();
            return;
        }
        throw new MatchError((Object)null);
    }

    public static final /* synthetic */ Object $anonfun$undo$1$adapted(Tuple2 x0$1) {
        RevertibleHistory.$anonfun$undo$1(x0$1);
        return BoxedUnit.UNIT;
    }
}

