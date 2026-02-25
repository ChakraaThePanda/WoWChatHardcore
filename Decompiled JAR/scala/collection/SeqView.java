/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.Seq;
import scala.collection.SeqView$;
import scala.collection.SeqViewLike;
import scala.collection.Traversable;
import scala.collection.TraversableView;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001I3qAB\u0004\u0011\u0002G\u0005AbB\u0003&\u000f!\u0005aEB\u0003\u0007\u000f!\u0005q\u0005C\u0003)\u0005\u0011\u0005\u0011&\u0002\u0003$\u0005\u0001Q\u0003\"B\u001f\u0003\t\u0007q$aB*fcZKWm\u001e\u0006\u0003\u0011%\t!bY8mY\u0016\u001cG/[8o\u0015\u0005Q\u0011!B:dC2\f7\u0001A\u000b\u0004\u001ba\u00113c\u0001\u0001\u000f%A\u0011q\u0002E\u0007\u0002\u0013%\u0011\u0011#\u0003\u0002\u0007\u0003:L(+\u001a4\u0011\u000bM!b#\t\u0013\u000e\u0003\u001dI!!F\u0004\u0003\u0017M+\u0017OV5fo2K7.\u001a\t\u0003/aa\u0001\u0001\u0002\u0004\u001a\u0001\u0011\u0015\rA\u0007\u0002\u0002\u0003F\u00111D\b\t\u0003\u001fqI!!H\u0005\u0003\u000f9{G\u000f[5oOB\u0011qbH\u0005\u0003A%\u00111!\u00118z!\t9\"\u0005\u0002\u0004$\u0001\u0011\u0015\rA\u0007\u0002\u0005\u0007>dG\u000e\u0005\u0003\u0014\u0001Y\t\u0013aB*fcZKWm\u001e\t\u0003'\t\u0019\"A\u0001\b\u0002\rqJg.\u001b;?)\u00051\u0003gA\u00163_A!1\u0003\f\u00182\u0013\tisAA\bUe\u00064XM]:bE2,g+[3x!\t9r\u0006B\u00051\t\u0005\u0005\t\u0011!B\u00015\t\u0019q\fJ\u0019\u0011\u0005]\u0011D!C\u001a\u0005\u0003\u0003\u0005\tQ!\u00015\u0005\u0005\u0019\u0015CA\u000e6a\t1$\bE\u0002\u0014oeJ!\u0001O\u0004\u0003\u0017Q\u0013\u0018M^3sg\u0006\u0014G.\u001a\t\u0003/i\"\u0011b\u000f\u001f\u0002\u0002\u0003\u0005)\u0011\u0001\u000e\u0003\u0007}##\u0007B\u00054\t\u0005\u0005\t\u0011!B\u0001i\u0005a1-\u00198Ck&dGM\u0012:p[V\u0011q(S\u000b\u0002\u0001B)\u0011\t\u0012$I\u00156\t!I\u0003\u0002D\u000f\u00059q-\u001a8fe&\u001c\u0017BA#C\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\t9E!D\u0001\u0003!\t9\u0012\nB\u0003\u001a\u000b\t\u0007!\u0004\u0005\u0003\u0014\u0001![\u0005G\u0001'Q!\r\u0019RjT\u0005\u0003\u001d\u001e\u00111aU3r!\t9\u0002\u000bB\u0005R\u000b\u0005\u0005\t\u0011!B\u00015\t\u0019q\fJ\u001a")
public interface SeqView<A, Coll>
extends SeqViewLike<A, Coll, SeqView<A, Coll>> {
    public static <A> CanBuildFrom<TraversableView<?, ? extends Traversable<?>>, A, SeqView<A, Seq<?>>> canBuildFrom() {
        return SeqView$.MODULE$.canBuildFrom();
    }
}

