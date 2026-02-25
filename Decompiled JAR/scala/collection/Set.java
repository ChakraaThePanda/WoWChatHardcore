/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.GenSet;
import scala.collection.Iterable;
import scala.collection.Set$;
import scala.collection.SetLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015aaB\u0006\r!\u0003\r\t!\u0005\u0005\u0006u\u0001!\ta\u000f\u0005\u0006\u007f\u0001!\t\u0005\u0011\u0005\u0006\t\u0002!\t%R\u0004\u0006\r2A\ta\u0012\u0004\u0006\u00171A\t\u0001\u0013\u0005\u0006\u0019\u0016!\t!\u0014\u0005\u0006\u001d\u0016!\ta\u0014\u0005\u0006=\u0016!\te\u0018\u0005\u0006I\u0016!\u0019!\u001a\u0005\u0007c\u0016\u0001\u000b\u0011\u0002:\u0003\u0007M+GO\u0003\u0002\u000e\u001d\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003=\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u00139M9\u0001aE\f)Y=2\u0004C\u0001\u000b\u0016\u001b\u0005q\u0011B\u0001\f\u000f\u0005\u0019\te.\u001f*fMB!A\u0003\u0007\u000e&\u0013\tIbBA\u0005Gk:\u001cG/[8ocA\u00111\u0004\b\u0007\u0001\t\u0015i\u0002A1\u0001\u001f\u0005\u0005\t\u0015CA\u0010#!\t!\u0002%\u0003\u0002\"\u001d\t9aj\u001c;iS:<\u0007C\u0001\u000b$\u0013\t!cBA\u0002B]f\u0004\"\u0001\u0006\u0014\n\u0005\u001dr!a\u0002\"p_2,\u0017M\u001c\t\u0004S)RR\"\u0001\u0007\n\u0005-b!\u0001C%uKJ\f'\r\\3\u0011\u0007%j#$\u0003\u0002/\u0019\t1q)\u001a8TKR\u0004B\u0001M\u001a\u001bk5\t\u0011G\u0003\u00023\u0019\u00059q-\u001a8fe&\u001c\u0017B\u0001\u001b2\u0005I9UM\\3sS\u000e\u001cV\r\u001e+f[Bd\u0017\r^3\u0011\u0005%\u0002\u0001\u0003B\u001585eJ!\u0001\u000f\u0007\u0003\u000fM+G\u000fT5lKB\u0019\u0011\u0006\u0001\u000e\u0002\r\u0011Jg.\u001b;%)\u0005a\u0004C\u0001\u000b>\u0013\tqdB\u0001\u0003V]&$\u0018!C2p[B\fg.[8o+\u0005\t\u0005c\u0001\u0019Ck%\u00111)\r\u0002\u0011\u000f\u0016tWM]5d\u0007>l\u0007/\u00198j_:\f1a]3r+\u0005I\u0014aA*fiB\u0011\u0011&B\n\u0003\u000b%\u00032\u0001\r&6\u0013\tY\u0015G\u0001\u0006TKR4\u0015m\u0019;pef\fa\u0001P5oSRtD#A$\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0002Q1V\t\u0011\u000b\u0005\u0003S+^KV\"A*\u000b\u0005Qc\u0011aB7vi\u0006\u0014G.Z\u0005\u0003-N\u0013qAQ;jY\u0012,'\u000f\u0005\u0002\u001c1\u0012)Qd\u0002b\u0001=A\u0019!,X,\u000e\u0003mS!\u0001\u0018\u0007\u0002\u0013%lW.\u001e;bE2,\u0017BA\u0006\\\u0003\u0015)W\u000e\u001d;z+\t\u00017-F\u0001b!\rI\u0003A\u0019\t\u00037\r$Q!\b\u0005C\u0002y\tAbY1o\u0005VLG\u000e\u001a$s_6,\"AZ8\u0016\u0003\u001d\u0004R\u0001\r5k]BL!![\u0019\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\u0005-dW\"A\u0003\n\u00055\u0014%\u0001B\"pY2\u0004\"aG8\u0005\u000buI!\u0019\u0001\u0010\u0011\u0007%\u0002a.A\u0006SKV\u001c\u0018M\u00197f\u0007\n3%cA:\u0014s\u001a!A\u000f\u0001\u0001s\u00051a$/\u001a4j]\u0016lWM\u001c;?\u0013\t1x/A\btKR\u001c\u0015M\u001c\"vS2$gI]8n\u0013\tA\u0018GA\u0007HK:\u001cV\r\u001e$bGR|'/\u001f\t\u0007a!T(%a\u00011\u0005ml\bcA\u0015\u0001yB\u00111$ \u0003\n}\u0002\t\t\u0011!A\u0003\u0002y\u00111a\u0018\u00132\u0013\r\t\t!\u001e\u0002\u0006I\u0005twN\u001c\t\u0004S\u0001\u0011\u0003")
public interface Set<A>
extends Iterable<A>,
GenSet<A>,
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

