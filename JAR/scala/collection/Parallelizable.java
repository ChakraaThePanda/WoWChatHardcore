/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Serializable;
import scala.collection.Parallel;
import scala.collection.TraversableOnce;
import scala.collection.parallel.Combiner;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001U2q!\u0002\u0004\u0011\u0002\u0007\u00051\u0002C\u0003\u0012\u0001\u0011\u0005!\u0003C\u0003\u0017\u0001\u0019\u0005q\u0003C\u0003%\u0001\u0011\u0005Q\u0005\u0003\u0004.\u0001\u00016\tB\f\u0002\u000f!\u0006\u0014\u0018\r\u001c7fY&T\u0018M\u00197f\u0015\t9\u0001\"\u0001\u0006d_2dWm\u0019;j_:T\u0011!C\u0001\u0006g\u000e\fG.Y\u0002\u0001+\raadJ\n\u0003\u00015\u0001\"AD\b\u000e\u0003!I!\u0001\u0005\u0005\u0003\u0007\u0005s\u00170\u0001\u0004%S:LG\u000f\n\u000b\u0002'A\u0011a\u0002F\u0005\u0003+!\u0011A!\u00168ji\u0006\u00191/Z9\u0016\u0003a\u00012!\u0007\u000e\u001d\u001b\u00051\u0011BA\u000e\u0007\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0007CA\u000f\u001f\u0019\u0001!aa\b\u0001\u0005\u0006\u0004\u0001#!A!\u0012\u0005\u0005j\u0001C\u0001\b#\u0013\t\u0019\u0003BA\u0004O_RD\u0017N\\4\u0002\u0007A\f'/F\u0001'!\tir\u0005\u0002\u0004)\u0001\u0011\u0015\r!\u000b\u0002\b!\u0006\u0014(+\u001a9s#\t\t#\u0006\u0005\u0002\u001aW%\u0011AF\u0002\u0002\t!\u0006\u0014\u0018\r\u001c7fY\u0006Y\u0001/\u0019:D_6\u0014\u0017N\\3s+\u0005y\u0003\u0003\u0002\u001949\u0019j\u0011!\r\u0006\u0003e\u0019\t\u0001\u0002]1sC2dW\r\\\u0005\u0003iE\u0012\u0001bQ8nE&tWM\u001d")
public interface Parallelizable<A, ParRepr extends Parallel> {
    public TraversableOnce<A> seq();

    public static /* synthetic */ Parallel par$(Parallelizable $this) {
        return $this.par();
    }

    default public ParRepr par() {
        Combiner cb = this.parCombiner();
        this.seq().foreach((Function1<Object, Combiner> & java.io.Serializable & Serializable)x -> (Combiner)cb.$plus$eq((Object)x));
        return (ParRepr)((Parallel)cb.result());
    }

    public Combiner<A, ParRepr> parCombiner();

    public static void $init$(Parallelizable $this) {
    }
}

