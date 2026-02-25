/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Equals;
import scala.Function1;
import scala.collection.GenIterableLike;
import scala.collection.GenSet;
import scala.collection.Iterator;
import scala.collection.Set;
import scala.reflect.ScalaSignature;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001y4q!\u0005\n\u0011\u0002\u0007\u0005q\u0003C\u0003B\u0001\u0011\u0005!\tC\u0003G\u0001\u0019\u0005q\tC\u0003L\u0001\u0019\u0005A\nC\u0003P\u0001\u0019\u0005\u0001\u000bC\u0003S\u0001\u0019\u00051\u000bC\u0003V\u0001\u0019\u0005a\u000bC\u0003[\u0001\u0011\u00051\fC\u0003^\u0001\u0011\u0005a\fC\u0003e\u0001\u0011\u0005Q\rC\u0003h\u0001\u0019\u0005\u0001\u000eC\u0003k\u0001\u0011\u00051\u000eC\u0003n\u0001\u0019\u0005a\u000eC\u0003q\u0001\u0011\u0005\u0011\u000fC\u0003t\u0001\u0011\u0005A\u000fC\u0003w\u0001\u0011\u0005s\u000fC\u0003z\u0001\u0011\u0005#P\u0001\u0006HK:\u001cV\r\u001e'jW\u0016T!a\u0005\u000b\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0016\u0003\u0015\u00198-\u00197b\u0007\u0001)2\u0001G\u0012.'\u0019\u0001\u0011$H\u00186qA\u0011!dG\u0007\u0002)%\u0011A\u0004\u0006\u0002\u0007\u0003:L(+\u001a4\u0011\tyy\u0012\u0005L\u0007\u0002%%\u0011\u0001E\u0005\u0002\u0010\u000f\u0016t\u0017\n^3sC\ndW\rT5lKB\u0011!e\t\u0007\u0001\t\u0015!\u0003A1\u0001&\u0005\u0005\t\u0015C\u0001\u0014*!\tQr%\u0003\u0002))\t9aj\u001c;iS:<\u0007C\u0001\u000e+\u0013\tYCCA\u0002B]f\u0004\"AI\u0017\u0005\r9\u0002AQ1\u0001&\u0005\u0011\u0011V\r\u001d:\u0011\ti\u0001\u0014EM\u0005\u0003cQ\u0011\u0011BR;oGRLwN\\\u0019\u0011\u0005i\u0019\u0014B\u0001\u001b\u0015\u0005\u001d\u0011un\u001c7fC:\u0004\"A\u0007\u001c\n\u0005]\"\"AB#rk\u0006d7\u000f\u0005\u0003\u001fs\u0005Z\u0014B\u0001\u001e\u0013\u00059\u0001\u0016M]1mY\u0016d\u0017N_1cY\u0016\u00042\u0001P \"\u001b\u0005i$B\u0001 \u0013\u0003!\u0001\u0018M]1mY\u0016d\u0017B\u0001!>\u0005\u0019\u0001\u0016M]*fi\u00061A%\u001b8ji\u0012\"\u0012a\u0011\t\u00035\u0011K!!\u0012\u000b\u0003\tUs\u0017\u000e^\u0001\tSR,'/\u0019;peV\t\u0001\nE\u0002\u001f\u0013\u0006J!A\u0013\n\u0003\u0011%#XM]1u_J\f\u0001bY8oi\u0006Lgn\u001d\u000b\u0003e5CQAT\u0002A\u0002\u0005\nA!\u001a7f[\u0006)A\u0005\u001d7vgR\u0011A&\u0015\u0005\u0006\u001d\u0012\u0001\r!I\u0001\u0007I5Lg.^:\u0015\u00051\"\u0006\"\u0002(\u0006\u0001\u0004\t\u0013aA:fcV\tq\u000bE\u0002\u001f1\u0006J!!\u0017\n\u0003\u0007M+G/A\u0003baBd\u0017\u0010\u0006\u000239\")aj\u0002a\u0001C\u0005I\u0011N\u001c;feN,7\r\u001e\u000b\u0003Y}CQ\u0001\u0019\u0005A\u0002\u0005\fA\u0001\u001e5biB\u0019aDY\u0011\n\u0005\r\u0014\"AB$f]N+G/\u0001\u0003%C6\u0004HC\u0001\u0017g\u0011\u0015\u0001\u0017\u00021\u0001b\u0003\u0015)h.[8o)\ta\u0013\u000eC\u0003a\u0015\u0001\u0007\u0011-\u0001\u0003%E\u0006\u0014HC\u0001\u0017m\u0011\u0015\u00017\u00021\u0001b\u0003\u0011!\u0017N\u001a4\u0015\u00051z\u0007\"\u00021\r\u0001\u0004\t\u0017A\u0003\u0013b[B$C/\u001b7eKR\u0011AF\u001d\u0005\u0006A6\u0001\r!Y\u0001\tgV\u00147/\u001a;PMR\u0011!'\u001e\u0005\u0006A:\u0001\r!Y\u0001\u0007KF,\u0018\r\\:\u0015\u0005IB\b\"\u00021\u0010\u0001\u0004I\u0013\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003m\u0004\"A\u0007?\n\u0005u$\"aA%oi\u0002")
public interface GenSetLike<A, Repr>
extends GenIterableLike<A, Repr>,
Function1<A, Object>,
Equals {
    @Override
    public Iterator<A> iterator();

    public boolean contains(A var1);

    public Repr $plus(A var1);

    public Repr $minus(A var1);

    @Override
    public Set<A> seq();

    public static /* synthetic */ boolean apply$(GenSetLike $this, Object elem) {
        return $this.apply((A)elem);
    }

    @Override
    default public boolean apply(A elem) {
        return this.contains(elem);
    }

    public static /* synthetic */ Object intersect$(GenSetLike $this, GenSet that) {
        return $this.intersect(that);
    }

    default public Repr intersect(GenSet<A> that) {
        return this.filter(that);
    }

    public static /* synthetic */ Object $amp$(GenSetLike $this, GenSet that) {
        return $this.$amp(that);
    }

    default public Repr $amp(GenSet<A> that) {
        return this.intersect(that);
    }

    public Repr union(GenSet<A> var1);

    public static /* synthetic */ Object $bar$(GenSetLike $this, GenSet that) {
        return $this.$bar(that);
    }

    default public Repr $bar(GenSet<A> that) {
        return this.union(that);
    }

    public Repr diff(GenSet<A> var1);

    public static /* synthetic */ Object $amp$tilde$(GenSetLike $this, GenSet that) {
        return $this.$amp$tilde(that);
    }

    default public Repr $amp$tilde(GenSet<A> that) {
        return this.diff(that);
    }

    public static /* synthetic */ boolean subsetOf$(GenSetLike $this, GenSet that) {
        return $this.subsetOf(that);
    }

    default public boolean subsetOf(GenSet<A> that) {
        return this.forall(that);
    }

    public static /* synthetic */ boolean equals$(GenSetLike $this, Object that) {
        return $this.equals(that);
    }

    @Override
    default public boolean equals(Object that) {
        GenSet genSet;
        boolean bl = that instanceof GenSet ? this == (genSet = (GenSet)that) || genSet.canEqual(this) && this.size() == genSet.size() && this.liftedTree1$1(genSet) : false;
        return bl;
    }

    public static /* synthetic */ int hashCode$(GenSetLike $this) {
        return $this.hashCode();
    }

    default public int hashCode() {
        return MurmurHash3$.MODULE$.setHash(this.seq());
    }

    private /* synthetic */ boolean liftedTree1$1(GenSet x2$1) {
        try {
            return this.subsetOf(x2$1);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public static void $init$(GenSetLike $this) {
    }
}

