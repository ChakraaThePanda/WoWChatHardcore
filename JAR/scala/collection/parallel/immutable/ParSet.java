/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Nil$;
import scala.collection.parallel.immutable.ParHashSet$;
import scala.collection.parallel.immutable.ParIterable;
import scala.collection.parallel.immutable.ParSet$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\u001daaB\u0006\r!\u0003\r\t!\u0006\u0005\u0006\u0003\u0002!\tA\u0011\u0005\u0006\r\u0002!\te\u0012\u0005\u0006\u0011\u0002!\t%\u0013\u0005\u0006'\u0002!\t\u0005\u0016\u0005\u0006;\u0002!\tEX\u0004\u0006K2A\tA\u001a\u0004\u0006\u00171A\ta\u001a\u0005\u0006W\u001e!\t\u0001\u001c\u0005\u0006[\u001e!\tA\u001c\u0005\u0006m\u001e!\u0019a\u001e\u0002\u0007!\u0006\u00148+\u001a;\u000b\u00055q\u0011!C5n[V$\u0018M\u00197f\u0015\ty\u0001#\u0001\u0005qCJ\fG\u000e\\3m\u0015\t\t\"#\u0001\u0006d_2dWm\u0019;j_:T\u0011aE\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t1\u0012eE\u0004\u0001/mQ#'\u000e\u001d\u0011\u0005aIR\"\u0001\n\n\u0005i\u0011\"AB!osJ+g\rE\u0002\u001d;}i\u0011\u0001E\u0005\u0003=A\u0011aaR3o'\u0016$\bC\u0001\u0011\"\u0019\u0001!QA\t\u0001C\u0002\r\u0012\u0011\u0001V\t\u0003I\u001d\u0002\"\u0001G\u0013\n\u0005\u0019\u0012\"a\u0002(pi\"Lgn\u001a\t\u00031!J!!\u000b\n\u0003\u0007\u0005s\u0017\u0010\u0005\u0003,]}\u0001T\"\u0001\u0017\u000b\u00055\u0002\u0012aB4f]\u0016\u0014\u0018nY\u0005\u0003_1\u0012!cR3oKJL7\rU1s)\u0016l\u0007\u000f\\1uKB\u0011\u0011\u0007A\u0007\u0002\u0019A\u00191\u0007N\u0010\u000e\u00039I!a\u0003\b\u0011\u0007E2t$\u0003\u00028\u0019\tY\u0001+\u0019:Ji\u0016\u0014\u0018M\u00197f!\u0015\u0019\u0014hH\u001e=\u0013\tQdB\u0001\u0006QCJ\u001cV\r\u001e'jW\u0016\u00042!\r\u0001 !\rithH\u0007\u0002})\u0011Q\u0002E\u0005\u0003\u0001z\u00121aU3u\u0003\u0019!\u0013N\\5uIQ\t1\t\u0005\u0002\u0019\t&\u0011QI\u0005\u0002\u0005+:LG/A\u0003f[B$\u00180F\u0001<\u0003%\u0019w.\u001c9b]&|g.F\u0001K%\rYU\n\u0015\u0004\u0005\u0019\u0002\u0001!J\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0002,\u001dBJ!a\u0014\u0017\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>t\u0007cA\u0016Ra%\u0011!\u000b\f\u0002\u0014\u000f\u0016tWM]5d!\u0006\u00148i\\7qC:LwN\\\u0001\rgR\u0014\u0018N\\4Qe\u00164\u0017\u000e_\u000b\u0002+B\u0011akW\u0007\u0002/*\u0011\u0001,W\u0001\u0005Y\u0006twMC\u0001[\u0003\u0011Q\u0017M^1\n\u0005q;&AB*ue&tw-A\u0003u_N+G/\u0006\u0002`EV\t\u0001\rE\u00022\u0001\u0005\u0004\"\u0001\t2\u0005\u000b\r,!\u0019\u00013\u0003\u0003U\u000b\"aH\u0014\u0002\rA\u000b'oU3u!\t\tta\u0005\u0002\bQB\u00191&\u001b\u0019\n\u0005)d#!\u0004)beN+GOR1di>\u0014\u00180\u0001\u0004=S:LGO\u0010\u000b\u0002M\u0006Ya.Z<D_6\u0014\u0017N\\3s+\tyG/F\u0001q!\u0011\u0019\u0014o];\n\u0005It!\u0001C\"p[\nLg.\u001a:\u0011\u0005\u0001\"H!\u0002\u0012\n\u0005\u0004\u0019\u0003cA\u0019\u0001g\u0006a1-\u00198Ck&dGM\u0012:p[V\u0019\u00010a\u0001\u0016\u0003e\u0004ra\u000b>}\u0003\u0003\t)!\u0003\u0002|Y\tq1)\u00198D_6\u0014\u0017N\\3Ge>l\u0007CA?\u007f\u001b\u00059\u0011BA@O\u0005\u0011\u0019u\u000e\u001c7\u0011\u0007\u0001\n\u0019\u0001B\u0003#\u0015\t\u00071\u0005\u0005\u00032\u0001\u0005\u0005\u0001")
public interface ParSet<T>
extends scala.collection.parallel.ParSet<T>,
ParIterable<T> {
    public static <T> CanCombineFrom<ParSet<?>, T, ParSet<T>> canBuildFrom() {
        return ParSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<ParSet<?>, A, ParSet<A>> setCanBuildFrom() {
        return ParSet$.MODULE$.setCanBuildFrom();
    }

    public static /* synthetic */ ParSet empty$(ParSet $this) {
        return $this.empty();
    }

    @Override
    default public ParSet<T> empty() {
        return (ParSet)ParHashSet$.MODULE$.apply(Nil$.MODULE$);
    }

    public static /* synthetic */ GenericCompanion companion$(ParSet $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<ParSet> companion() {
        return ParSet$.MODULE$;
    }

    public static /* synthetic */ String stringPrefix$(ParSet $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return "ParSet";
    }

    public static /* synthetic */ ParSet toSet$(ParSet $this) {
        return $this.toSet();
    }

    @Override
    default public <U> ParSet<U> toSet() {
        return this;
    }

    public static void $init$(ParSet $this) {
    }
}

