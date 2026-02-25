/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function1;
import scala.Serializable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.Set;
import scala.collection.SetLike;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParSet;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000193q!\u0002\u0004\u0011\u0002\u0007\u0005Q\u0002C\u0003>\u0001\u0011\u0005a\bC\u0003C\u0001\u0019\u00051\tC\u0003E\u0001\u0011\u0005Q\tC\u0003L\u0001\u0011\u0005AJ\u0001\u0006QCJ\u001cV\r\u001e'jW\u0016T!a\u0002\u0005\u0002\u0011A\f'/\u00197mK2T!!\u0003\u0006\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\f\u0003\u0015\u00198-\u00197b\u0007\u0001)BAD\r$YM!\u0001aD\n;!\t\u0001\u0012#D\u0001\u000b\u0013\t\u0011\"B\u0001\u0004B]f\u0014VM\u001a\t\u0005)U9\"%D\u0001\t\u0013\t1\u0002B\u0001\u0006HK:\u001cV\r\u001e'jW\u0016\u0004\"\u0001G\r\r\u0001\u0011)!\u0004\u0001b\u00017\t\tA+\u0005\u0002\u001d?A\u0011\u0001#H\u0005\u0003=)\u0011qAT8uQ&tw\r\u0005\u0002\u0011A%\u0011\u0011E\u0003\u0002\u0004\u0003:L\bC\u0001\r$\t\u0019!\u0003\u0001\"b\u0001K\t!!+\u001a9s#\tabEE\u0002(S]2A\u0001\u000b\u0001\u0001M\taAH]3gS:,W.\u001a8u}A)!\u0006A\f#W5\ta\u0001\u0005\u0002\u0019Y\u00111Q\u0006\u0001CC\u00029\u0012!bU3rk\u0016tG/[1m#\tarFE\u00021cQ2A\u0001\u000b\u0001\u0001_A\u0019ACM\f\n\u0005MB!aA*fiB!A#N\f,\u0013\t1\u0004BA\u0004TKRd\u0015n[3\u0011\u0007)Bt#\u0003\u0002:\r\t1\u0001+\u0019:TKR\u0004RAK\u001e\u0018E-J!\u0001\u0010\u0004\u0003\u001fA\u000b'/\u0013;fe\u0006\u0014G.\u001a'jW\u0016\fa\u0001J5oSR$C#A \u0011\u0005A\u0001\u0015BA!\u000b\u0005\u0011)f.\u001b;\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003\t\nQ!\u001e8j_:$\"A\t$\t\u000b\u001d\u001b\u0001\u0019\u0001%\u0002\tQD\u0017\r\u001e\t\u0004)%;\u0012B\u0001&\t\u0005\u00199UM\\*fi\u0006!A-\u001b4g)\t\u0011S\nC\u0003H\t\u0001\u0007\u0001\n")
public interface ParSetLike<T, Repr extends ParSetLike<T, Repr, Sequential> & ParSet<T>, Sequential extends Set<T> & SetLike<T, Sequential>>
extends GenSetLike<T, Repr>,
ParIterableLike<T, Repr, Sequential> {
    public Repr empty();

    public static /* synthetic */ ParSet union$(ParSetLike $this, GenSet that) {
        return $this.union(that);
    }

    @Override
    default public Repr union(GenSet<T> that) {
        return (Repr)((ParSet)this.sequentially((Function1<Set, Set> & java.io.Serializable & Serializable)x$1 -> x$1.union(that)));
    }

    public static /* synthetic */ ParSet diff$(ParSetLike $this, GenSet that) {
        return $this.diff(that);
    }

    @Override
    default public Repr diff(GenSet<T> that) {
        return (Repr)((ParSet)this.sequentially((Function1<Set, Set> & java.io.Serializable & Serializable)x$2 -> x$2.diff(that)));
    }

    public static void $init$(ParSetLike $this) {
    }
}

