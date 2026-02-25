/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.Set;
import scala.collection.parallel.mutable.ParHashSet$;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ParSet$;
import scala.collection.parallel.mutable.ParSetLike;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001i4qa\u0003\u0007\u0011\u0002\u0007\u0005Q\u0003C\u0003B\u0001\u0011\u0005!\tC\u0003G\u0001\u0011\u0005s\tC\u0003R\u0001\u0011\u0005#\u000bC\u0003T\u0001\u0019\u0005AkB\u0003V\u0019!\u0005aKB\u0003\f\u0019!\u0005q\u000bC\u0003\\\r\u0011\u0005A\fC\u0003^\r\u0011\ra\fC\u0003k\r\u0011\u00053\u000eC\u0003t\r\u0011\u0005CO\u0001\u0004QCJ\u001cV\r\u001e\u0006\u0003\u001b9\tq!\\;uC\ndWM\u0003\u0002\u0010!\u0005A\u0001/\u0019:bY2,GN\u0003\u0002\u0012%\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003M\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u0017CM9\u0001aF\u000e+]EB\u0004C\u0001\r\u001a\u001b\u0005\u0011\u0012B\u0001\u000e\u0013\u0005\u0019\te.\u001f*fMB\u0019A$H\u0010\u000e\u0003AI!A\b\t\u0003\r\u001d+gnU3u!\t\u0001\u0013\u0005\u0004\u0001\u0005\u000b\t\u0002!\u0019A\u0012\u0003\u0003Q\u000b\"\u0001J\u0014\u0011\u0005a)\u0013B\u0001\u0014\u0013\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u0007\u0015\n\u0005%\u0012\"aA!osB\u00191\u0006L\u0010\u000e\u00031I!!\f\u0007\u0003\u0017A\u000b'/\u0013;fe\u0006\u0014G.\u001a\t\u0004_AzR\"\u0001\b\n\u0005-q\u0001\u0003\u0002\u001a6?]j\u0011a\r\u0006\u0003iA\tqaZ3oKJL7-\u0003\u00027g\t\u0011r)\u001a8fe&\u001c\u0007+\u0019:UK6\u0004H.\u0019;f!\tY\u0003\u0001E\u0003,s}YD(\u0003\u0002;\u0019\tQ\u0001+\u0019:TKRd\u0015n[3\u0011\u0007-\u0002q\u0004E\u0002>\u007f}i\u0011A\u0010\u0006\u0003\u001bAI!\u0001\u0011 \u0003\u0007M+G/\u0001\u0004%S:LG\u000f\n\u000b\u0002\u0007B\u0011\u0001\u0004R\u0005\u0003\u000bJ\u0011A!\u00168ji\u0006I1m\\7qC:LwN\\\u000b\u0002\u0011J\u0019\u0011j\u0013(\u0007\t)\u0003\u0001\u0001\u0013\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0004e1;\u0014BA'4\u0005A9UM\\3sS\u000e\u001cu.\u001c9b]&|g\u000eE\u00023\u001f^J!\u0001U\u001a\u0003'\u001d+g.\u001a:jGB\u000b'oQ8na\u0006t\u0017n\u001c8\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003m\n1a]3r+\u0005a\u0014A\u0002)beN+G\u000f\u0005\u0002,\rM\u0011a\u0001\u0017\t\u0004ee;\u0014B\u0001.4\u00055\u0001\u0016M]*fi\u001a\u000b7\r^8ss\u00061A(\u001b8jiz\"\u0012AV\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003?\",\u0012\u0001\u0019\t\u0006e\u0005\u001cw-[\u0005\u0003EN\u0012abQ1o\u0007>l'-\u001b8f\rJ|W\u000e\u0005\u0002eK6\ta!\u0003\u0002g\u0019\n!1i\u001c7m!\t\u0001\u0003\u000eB\u0003#\u0011\t\u00071\u0005E\u0002,\u0001\u001d\f!B\\3x\u0005VLG\u000eZ3s+\ta\u0017/F\u0001n!\u0011yc\u000e\u001d:\n\u0005=t!\u0001C\"p[\nLg.\u001a:\u0011\u0005\u0001\nH!\u0002\u0012\n\u0005\u0004\u0019\u0003cA\u0016\u0001a\u0006Ya.Z<D_6\u0014\u0017N\\3s+\t)\b0F\u0001w!\u0011ycn^=\u0011\u0005\u0001BH!\u0002\u0012\u000b\u0005\u0004\u0019\u0003cA\u0016\u0001o\u0002")
public interface ParSet<T>
extends ParIterable<T>,
scala.collection.parallel.ParSet<T>,
ParSetLike<T, ParSet<T>, Set<T>> {
    public static <T> CanCombineFrom<ParSet<?>, T, ParSet<T>> canBuildFrom() {
        return ParSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<ParSet<?>, A, ParSet<A>> setCanBuildFrom() {
        return ParSet$.MODULE$.setCanBuildFrom();
    }

    public static /* synthetic */ GenericCompanion companion$(ParSet $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<ParSet> companion() {
        return ParSet$.MODULE$;
    }

    public static /* synthetic */ ParSet empty$(ParSet $this) {
        return $this.empty();
    }

    @Override
    default public ParSet<T> empty() {
        return (ParSet)ParHashSet$.MODULE$.apply(Nil$.MODULE$);
    }

    @Override
    public Set<T> seq();

    public static void $init$(ParSet $this) {
    }
}

