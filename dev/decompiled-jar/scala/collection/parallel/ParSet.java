/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.collection.GenSet;
import scala.collection.Set;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Nil$;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.ParSet$;
import scala.collection.parallel.ParSetLike;
import scala.collection.parallel.mutable.ParHashSet$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001M4qAC\u0006\u0011\u0002\u0007\u0005!\u0003C\u0003:\u0001\u0011\u0005!\bC\u0003?\u0001\u0011\u0005s\bC\u0003A\u0001\u0011\u0005\u0013\tC\u0003L\u0001\u0011\u0005CjB\u0003V\u0017!\u0005aKB\u0003\u000b\u0017!\u0005q\u000bC\u0003\\\r\u0011\u0005A\fC\u0003^\r\u0011\u0005a\fC\u0003g\r\u0011\rqM\u0001\u0004QCJ\u001cV\r\u001e\u0006\u0003\u00195\t\u0001\u0002]1sC2dW\r\u001c\u0006\u0003\u001d=\t!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0001\u0012!B:dC2\f7\u0001A\u000b\u0003'y\u0019b\u0001\u0001\u000b\u0019O=\u0012\u0004CA\u000b\u0017\u001b\u0005y\u0011BA\f\u0010\u0005\u0019\te.\u001f*fMB\u0019\u0011D\u0007\u000f\u000e\u00035I!aG\u0007\u0003\r\u001d+gnU3u!\tib\u0004\u0004\u0001\u0005\u000b}\u0001!\u0019\u0001\u0011\u0003\u0003Q\u000b\"!\t\u0013\u0011\u0005U\u0011\u0013BA\u0012\u0010\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!F\u0013\n\u0005\u0019z!aA!osB!\u0001f\u000b\u000f.\u001b\u0005I#B\u0001\u0016\u000e\u0003\u001d9WM\\3sS\u000eL!\u0001L\u0015\u0003%\u001d+g.\u001a:jGB\u000b'\u000fV3na2\fG/\u001a\t\u0003]\u0001i\u0011a\u0003\t\u0004]Ab\u0012BA\u0019\f\u0005-\u0001\u0016M]%uKJ\f'\r\\3\u0011\u000b9\u001aD$\u000e\u001c\n\u0005QZ!A\u0003)beN+G\u000fT5lKB\u0019a\u0006\u0001\u000f\u0011\u0007e9D$\u0003\u00029\u001b\t\u00191+\u001a;\u0002\r\u0011Jg.\u001b;%)\u0005Y\u0004CA\u000b=\u0013\titB\u0001\u0003V]&$\u0018!B3naRLX#A\u001b\u0002\u0013\r|W\u000e]1oS>tW#\u0001\"\u0013\u0007\r+\u0005J\u0002\u0003E\u0001\u0001\u0011%\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004c\u0001\u0015G[%\u0011q)\u000b\u0002\u0011\u000f\u0016tWM]5d\u0007>l\u0007/\u00198j_:\u00042\u0001K%.\u0013\tQ\u0015FA\nHK:,'/[2QCJ\u001cu.\u001c9b]&|g.\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070F\u0001N!\tq5+D\u0001P\u0015\t\u0001\u0016+\u0001\u0003mC:<'\"\u0001*\u0002\t)\fg/Y\u0005\u0003)>\u0013aa\u0015;sS:<\u0017A\u0002)beN+G\u000f\u0005\u0002/\rM\u0011a\u0001\u0017\t\u0004Qek\u0013B\u0001.*\u00055\u0001\u0016M]*fi\u001a\u000b7\r^8ss\u00061A(\u001b8jiz\"\u0012AV\u0001\f]\u0016<8i\\7cS:,'/\u0006\u0002`IV\t\u0001\r\u0005\u0003/C\u000e,\u0017B\u00012\f\u0005!\u0019u.\u001c2j]\u0016\u0014\bCA\u000fe\t\u0015y\u0002B1\u0001!!\rq\u0003aY\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003QF,\u0012!\u001b\t\u0006Q)d\u0007O]\u0005\u0003W&\u0012abQ1o\u0007>l'-\u001b8f\rJ|W\u000e\u0005\u0002n]6\ta!\u0003\u0002p\r\n!1i\u001c7m!\ti\u0012\u000fB\u0003 \u0013\t\u0007\u0001\u0005E\u0002/\u0001A\u0004")
public interface ParSet<T>
extends GenSet<T>,
ParIterable<T>,
ParSetLike<T, ParSet<T>, Set<T>> {
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

    public static void $init$(ParSet $this) {
    }
}

