/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Iterable;
import scala.collection.mutable.Set$;
import scala.collection.mutable.SetLike;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000154qAC\u0006\u0011\u0002\u0007\u0005!\u0003C\u00036\u0001\u0011\u0005a\u0007C\u0003;\u0001\u0011\u00053\bC\u0003@\u0001\u0011\u0005\u0003iB\u0003B\u0017!\u0005!IB\u0003\u000b\u0017!\u00051\tC\u0003H\u000b\u0011\u0005\u0001\nC\u0003J\u000b\u0011\r!\n\u0003\u0004W\u000b\u0001\u0006Ia\u0016\u0005\u0006O\u0016!\t\u0005\u001b\u0002\u0004'\u0016$(B\u0001\u0007\u000e\u0003\u001diW\u000f^1cY\u0016T!AD\b\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0011\u0003\u0015\u00198-\u00197b\u0007\u0001)\"a\u0005\u0010\u0014\r\u0001!\u0002d\n\u00162!\t)b#D\u0001\u0010\u0013\t9rB\u0001\u0004B]f\u0014VM\u001a\t\u00043iaR\"A\u0006\n\u0005mY!\u0001C%uKJ\f'\r\\3\u0011\u0005uqB\u0002\u0001\u0003\u0006?\u0001\u0011\r\u0001\t\u0002\u0002\u0003F\u0011\u0011\u0005\n\t\u0003+\tJ!aI\b\u0003\u000f9{G\u000f[5oOB\u0011Q#J\u0005\u0003M=\u00111!\u00118z!\rA\u0013\u0006H\u0007\u0002\u001b%\u0011!\"\u0004\t\u0005W9b\u0002'D\u0001-\u0015\tiS\"A\u0004hK:,'/[2\n\u0005=b#AE$f]\u0016\u0014\u0018nY*fiR+W\u000e\u001d7bi\u0016\u0004\"!\u0007\u0001\u0011\te\u0011D\u0004N\u0005\u0003g-\u0011qaU3u\u0019&\\W\rE\u0002\u001a\u0001q\ta\u0001J5oSR$C#A\u001c\u0011\u0005UA\u0014BA\u001d\u0010\u0005\u0011)f.\u001b;\u0002\u0013\r|W\u000e]1oS>tW#\u0001\u001f\u0011\u0007-j\u0004'\u0003\u0002?Y\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0004g\u0016\fX#\u0001\u001b\u0002\u0007M+G\u000f\u0005\u0002\u001a\u000bM\u0011Q\u0001\u0012\t\u0004W\u0015\u0003\u0014B\u0001$-\u0005EiU\u000f^1cY\u0016\u001cV\r\u001e$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\t\u000bAbY1o\u0005VLG\u000e\u001a$s_6,\"a\u0013+\u0016\u00031\u0003RaK'P'VK!A\u0014\u0017\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\u0005A\u000bV\"A\u0003\n\u0005Ik$\u0001B\"pY2\u0004\"!\b+\u0005\u000b}9!\u0019\u0001\u0011\u0011\u0007e\u00011+A\u0006SKV\u001c\u0018M\u00197f\u0007\n3%c\u0001-\u0015=\u001a!\u0011\f\u0001\u0001X\u00051a$/\u001a4j]\u0016lWM\u001c;?\u0013\tYF,A\btKR\u001c\u0015M\u001c\"vS2$gI]8n\u0013\tiFFA\u0007HK:\u001cV\r\u001e$bGR|'/\u001f\t\u0006W5{FE\u001a\u0019\u0003A\n\u00042!\u0007\u0001b!\ti\"\rB\u0005d\u0001\u0005\u0005\t\u0011!B\u0001A\t\u0019q\fJ\u0019\n\u0005\u0015T&!\u0002\u0013b]>t\u0007cA\r\u0001I\u0005)Q-\u001c9usV\u0011\u0011\u000e\\\u000b\u0002UB\u0019\u0011\u0004A6\u0011\u0005uaG!B\u0010\n\u0005\u0004\u0001\u0003")
public interface Set<A>
extends Iterable<A>,
scala.collection.Set<A>,
SetLike<A, Set<A>> {
    public static <A> CanBuildFrom<Set<?>, A, Set<A>> canBuildFrom() {
        return Set$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<Set<?>, A, Set<A>> setCanBuildFrom() {
        return Set$.MODULE$.setCanBuildFrom();
    }

    public static /* synthetic */ GenericCompanion companion$(Set $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<Set> companion() {
        return Set$.MODULE$;
    }

    public static /* synthetic */ Set seq$(Set $this) {
        return $this.seq();
    }

    @Override
    default public Set<A> seq() {
        return this;
    }

    public static void $init$(Set $this) {
    }
}

