/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.IterableProxyLike;
import scala.collection.Set;
import scala.collection.SetLike;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001E4qa\u0004\t\u0011\u0002\u0007\u0005Q\u0003C\u00038\u0001\u0011\u0005\u0001\bC\u0003=\u0001\u0019\u0005Q\bC\u0003?\u0001\u0011\u0005s\bC\u0003F\u0001\u0011\u0005c\tC\u0003I\u0001\u0011\u0005\u0013\nC\u0003L\u0001\u0011\u0005C\nC\u0003N\u0001\u0011\u0005c\nC\u0003Q\u0001\u0011\u0005\u0013\u000bC\u0003X\u0001\u0011\u0005\u0003\fC\u0003[\u0001\u0011\u00053\fC\u0003^\u0001\u0011\u0005c\fC\u0003a\u0001\u0011\u0005\u0013\rC\u0003d\u0001\u0011\u0005C\rC\u0003g\u0001\u0011\u0005sM\u0001\u0007TKR\u0004&o\u001c=z\u0019&\\WM\u0003\u0002\u0012%\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003M\tQa]2bY\u0006\u001c\u0001!F\u0002\u0017C-\u001aB\u0001A\f\u001ciA\u0011\u0001$G\u0007\u0002%%\u0011!D\u0005\u0002\u0007\u0003:L(+\u001a4\u0011\tqirDK\u0007\u0002!%\u0011a\u0004\u0005\u0002\b'\u0016$H*[6f!\t\u0001\u0013\u0005\u0004\u0001\u0005\u000b\t\u0002!\u0019A\u0012\u0003\u0003\u0005\u000b\"\u0001J\u0014\u0011\u0005a)\u0013B\u0001\u0014\u0013\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u0007\u0015\n\u0005%\u0012\"aA!osB\u0011\u0001e\u000b\u0003\u0007Y\u0001!)\u0019A\u0017\u0003\tQC\u0017n]\t\u0003I9\u00122aL\u000e2\r\u0011\u0001\u0004\u0001\u0001\u0018\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0007q\u0011t$\u0003\u00024!\t\u00191+\u001a;\u0011\tq)tDK\u0005\u0003mA\u0011\u0011#\u0013;fe\u0006\u0014G.\u001a)s_bLH*[6f\u0003\u0019!\u0013N\\5uIQ\t\u0011\b\u0005\u0002\u0019u%\u00111H\u0005\u0002\u0005+:LG/A\u0003f[B$\u00180F\u0001+\u0003!\u0019wN\u001c;bS:\u001cHC\u0001!D!\tA\u0012)\u0003\u0002C%\t9!i\\8mK\u0006t\u0007\"\u0002#\u0004\u0001\u0004y\u0012\u0001B3mK6\fQ\u0001\n9mkN$\"AK$\t\u000b\u0011#\u0001\u0019A\u0010\u0002\r\u0011j\u0017N\\;t)\tQ#\nC\u0003E\u000b\u0001\u0007q$A\u0004jg\u0016k\u0007\u000f^=\u0016\u0003\u0001\u000bQ!\u00199qYf$\"\u0001Q(\t\u000b\u0011;\u0001\u0019A\u0010\u0002\u0013%tG/\u001a:tK\u000e$HC\u0001\u0016S\u0011\u0015\u0019\u0006\u00021\u0001U\u0003\u0011!\b.\u0019;\u0011\u0007q)v$\u0003\u0002W!\t1q)\u001a8TKR\fA\u0001J1naR\u0011!&\u0017\u0005\u0006'&\u0001\r\u0001V\u0001\u0006k:LwN\u001c\u000b\u0003UqCQa\u0015\u0006A\u0002Q\u000bA\u0001\n2beR\u0011!f\u0018\u0005\u0006'.\u0001\r\u0001V\u0001\u0005I&4g\r\u0006\u0002+E\")1\u000b\u0004a\u0001)\u0006QA%Y7qIQLG\u000eZ3\u0015\u0005)*\u0007\"B*\u000e\u0001\u0004!\u0016\u0001C:vEN,Go\u00144\u0015\u0005\u0001C\u0007\"B*\u000f\u0001\u0004!\u0006\u0006\u0002\u0001k[>\u0004\"\u0001G6\n\u00051\u0014\"A\u00033faJ,7-\u0019;fI\u0006\na.\u0001#qe>D\u00180\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eA\u0011,X\r\t;pA1\f7m\u001b\u0011pM\u0002*8/\u001a\u0011b]\u0012\u00043m\\7qS2,'/\f7fm\u0016d\u0007e];qa>\u0014H/I\u0001q\u0003\u0019\u0011d&M\u0019/a\u0001")
public interface SetProxyLike<A, This extends SetLike<A, This> & Set<A>>
extends SetLike<A, This>,
IterableProxyLike<A, This> {
    @Override
    public This empty();

    public static /* synthetic */ boolean contains$(SetProxyLike $this, Object elem) {
        return $this.contains(elem);
    }

    @Override
    default public boolean contains(A elem) {
        return ((SetLike)this.self()).contains(elem);
    }

    public static /* synthetic */ Set $plus$(SetProxyLike $this, Object elem) {
        return $this.$plus(elem);
    }

    @Override
    default public This $plus(A elem) {
        return ((SetLike)this.self()).$plus(elem);
    }

    public static /* synthetic */ Set $minus$(SetProxyLike $this, Object elem) {
        return $this.$minus(elem);
    }

    @Override
    default public This $minus(A elem) {
        return ((SetLike)this.self()).$minus(elem);
    }

    public static /* synthetic */ boolean isEmpty$(SetProxyLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return ((SetLike)this.self()).isEmpty();
    }

    public static /* synthetic */ boolean apply$(SetProxyLike $this, Object elem) {
        return $this.apply((A)elem);
    }

    @Override
    default public boolean apply(A elem) {
        return ((GenSetLike)this.self()).apply(elem);
    }

    public static /* synthetic */ Set intersect$(SetProxyLike $this, GenSet that) {
        return $this.intersect(that);
    }

    @Override
    default public This intersect(GenSet<A> that) {
        return (This)((Set)((GenSetLike)this.self()).intersect(that));
    }

    public static /* synthetic */ Set $amp$(SetProxyLike $this, GenSet that) {
        return $this.$amp(that);
    }

    @Override
    default public This $amp(GenSet<A> that) {
        return (This)((Set)((GenSetLike)this.self()).$amp(that));
    }

    public static /* synthetic */ Set union$(SetProxyLike $this, GenSet that) {
        return $this.union(that);
    }

    @Override
    default public This union(GenSet<A> that) {
        return ((SetLike)this.self()).union(that);
    }

    public static /* synthetic */ Set $bar$(SetProxyLike $this, GenSet that) {
        return $this.$bar(that);
    }

    @Override
    default public This $bar(GenSet<A> that) {
        return (This)((Set)((GenSetLike)this.self()).$bar(that));
    }

    public static /* synthetic */ Set diff$(SetProxyLike $this, GenSet that) {
        return $this.diff(that);
    }

    @Override
    default public This diff(GenSet<A> that) {
        return ((SetLike)this.self()).diff(that);
    }

    public static /* synthetic */ Set $amp$tilde$(SetProxyLike $this, GenSet that) {
        return $this.$amp$tilde(that);
    }

    @Override
    default public This $amp$tilde(GenSet<A> that) {
        return (This)((Set)((GenSetLike)this.self()).$amp$tilde(that));
    }

    public static /* synthetic */ boolean subsetOf$(SetProxyLike $this, GenSet that) {
        return $this.subsetOf(that);
    }

    @Override
    default public boolean subsetOf(GenSet<A> that) {
        return ((GenSetLike)this.self()).subsetOf(that);
    }

    public static void $init$(SetProxyLike $this) {
    }
}

