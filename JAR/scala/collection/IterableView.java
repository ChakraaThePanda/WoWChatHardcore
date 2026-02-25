/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.Iterable;
import scala.collection.IterableView$;
import scala.collection.IterableViewLike;
import scala.collection.Traversable;
import scala.collection.TraversableView;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001I3qAB\u0004\u0011\u0002G\u0005AbB\u0003&\u000f!\u0005aEB\u0003\u0007\u000f!\u0005q\u0005C\u0003)\u0005\u0011\u0005\u0011&\u0002\u0003$\u0005\u0001Q\u0003\"B\u001f\u0003\t\u0007q$\u0001D%uKJ\f'\r\\3WS\u0016<(B\u0001\u0005\n\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u0015\u0005)1oY1mC\u000e\u0001QcA\u0007\u0019EM\u0019\u0001A\u0004\n\u0011\u0005=\u0001R\"A\u0005\n\u0005EI!AB!osJ+g\rE\u0003\u0014)Y\tC%D\u0001\b\u0013\t)rA\u0001\tJi\u0016\u0014\u0018M\u00197f-&,w\u000fT5lKB\u0011q\u0003\u0007\u0007\u0001\t\u0019I\u0002\u0001\"b\u00015\t\t\u0011)\u0005\u0002\u001c=A\u0011q\u0002H\u0005\u0003;%\u0011qAT8uQ&tw\r\u0005\u0002\u0010?%\u0011\u0001%\u0003\u0002\u0004\u0003:L\bCA\f#\t\u0019\u0019\u0003\u0001\"b\u00015\t!1i\u001c7m!\u0011\u0019\u0002AF\u0011\u0002\u0019%#XM]1cY\u00164\u0016.Z<\u0011\u0005M\u00111C\u0001\u0002\u000f\u0003\u0019a\u0014N\\5u}Q\ta\u0005M\u0002,e=\u0002Ba\u0005\u0017/c%\u0011Qf\u0002\u0002\u0010)J\fg/\u001a:tC\ndWMV5foB\u0011qc\f\u0003\na\u0011\t\t\u0011!A\u0003\u0002i\u00111a\u0018\u00132!\t9\"\u0007B\u00054\t\u0005\u0005\t\u0011!B\u0001i\t\t1)\u0005\u0002\u001ckA\u0012aG\u000f\t\u0004']J\u0014B\u0001\u001d\b\u0005-!&/\u0019<feN\f'\r\\3\u0011\u0005]QD!C\u001e=\u0003\u0003\u0005\tQ!\u0001\u001b\u0005\ryFE\r\u0003\ng\u0011\t\t\u0011!A\u0003\u0002Q\nAbY1o\u0005VLG\u000e\u001a$s_6,\"aP%\u0016\u0003\u0001\u0003R!\u0011#G\u0011*k\u0011A\u0011\u0006\u0003\u0007\u001e\tqaZ3oKJL7-\u0003\u0002F\u0005\na1)\u00198Ck&dGM\u0012:p[B\u0011q\tB\u0007\u0002\u0005A\u0011q#\u0013\u0003\u00063\u0015\u0011\rA\u0007\t\u0005'\u0001A5\n\r\u0002M!B\u00191#T(\n\u00059;!\u0001C%uKJ\f'\r\\3\u0011\u0005]\u0001F!C)\u0006\u0003\u0003\u0005\tQ!\u0001\u001b\u0005\ryFe\r")
public interface IterableView<A, Coll>
extends IterableViewLike<A, Coll, IterableView<A, Coll>> {
    public static <A> CanBuildFrom<TraversableView<?, ? extends Traversable<?>>, A, IterableView<A, Iterable<?>>> canBuildFrom() {
        return IterableView$.MODULE$.canBuildFrom();
    }
}

