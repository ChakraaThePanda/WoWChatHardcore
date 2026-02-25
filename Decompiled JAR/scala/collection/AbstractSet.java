/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.collection.AbstractIterable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.SetLike;
import scala.collection.TraversableLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.Subtractable;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSet;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00012QAA\u0002\u0002\u0002!AQ!\b\u0001\u0005\u0002y\u00111\"\u00112tiJ\f7\r^*fi*\u0011A!B\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0004\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0011\u0002E\n\u0004\u0001)Q\u0002cA\u0006\r\u001d5\t1!\u0003\u0002\u000e\u0007\t\u0001\u0012IY:ue\u0006\u001cG/\u0013;fe\u0006\u0014G.\u001a\t\u0003\u001fAa\u0001\u0001B\u0003\u0012\u0001\t\u0007!CA\u0001B#\t\u0019r\u0003\u0005\u0002\u0015+5\tQ!\u0003\u0002\u0017\u000b\t9aj\u001c;iS:<\u0007C\u0001\u000b\u0019\u0013\tIRAA\u0002B]f\u00042aC\u000e\u000f\u0013\ta2AA\u0002TKR\fa\u0001P5oSRtD#A\u0010\u0011\u0007-\u0001a\u0002")
public abstract class AbstractSet<A>
extends AbstractIterable<A>
implements Set<A> {
    @Override
    public GenericCompanion<Set> companion() {
        return Set.companion$(this);
    }

    @Override
    public Set<A> seq() {
        return Set.seq$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$SetLike$$super$map(Function1 f, CanBuildFrom bf) {
        return TraversableLike.map$(this, f, bf);
    }

    @Override
    public Builder<A, Set<A>> newBuilder() {
        return SetLike.newBuilder$(this);
    }

    @Override
    public Combiner<A, ParSet<A>> parCombiner() {
        return SetLike.parCombiner$(this);
    }

    @Override
    public Seq<A> toSeq() {
        return SetLike.toSeq$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return SetLike.toBuffer$(this);
    }

    @Override
    public <B, That> That map(Function1<A, B> f, CanBuildFrom<Set<A>, B, That> bf) {
        return (That)SetLike.map$(this, f, bf);
    }

    @Override
    public Set<A> $plus(A elem1, A elem2, Seq<A> elems) {
        return SetLike.$plus$(this, elem1, elem2, elems);
    }

    @Override
    public Set<A> $plus$plus(GenTraversableOnce<A> elems) {
        return SetLike.$plus$plus$(this, elems);
    }

    @Override
    public boolean isEmpty() {
        return SetLike.isEmpty$(this);
    }

    @Override
    public Set<A> union(GenSet<A> that) {
        return SetLike.union$(this, that);
    }

    @Override
    public Set<A> diff(GenSet<A> that) {
        return SetLike.diff$(this, that);
    }

    @Override
    public Iterator<Set<A>> subsets(int len) {
        return SetLike.subsets$(this, len);
    }

    @Override
    public Iterator<Set<A>> subsets() {
        return SetLike.subsets$(this);
    }

    @Override
    public String stringPrefix() {
        return SetLike.stringPrefix$(this);
    }

    @Override
    public String toString() {
        return SetLike.toString$(this);
    }

    @Override
    public Subtractable $minus(Object elem1, Object elem2, Seq elems) {
        return Subtractable.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public Subtractable $minus$minus(GenTraversableOnce xs) {
        return Subtractable.$minus$minus$(this, xs);
    }

    @Override
    public GenSet empty() {
        return GenericSetTemplate.empty$(this);
    }

    @Override
    public boolean apply(A elem) {
        return GenSetLike.apply$(this, elem);
    }

    @Override
    public Object intersect(GenSet that) {
        return GenSetLike.intersect$(this, that);
    }

    @Override
    public Object $amp(GenSet that) {
        return GenSetLike.$amp$(this, that);
    }

    @Override
    public Object $bar(GenSet that) {
        return GenSetLike.$bar$(this, that);
    }

    @Override
    public Object $amp$tilde(GenSet that) {
        return GenSetLike.$amp$tilde$(this, that);
    }

    @Override
    public boolean subsetOf(GenSet<A> that) {
        return GenSetLike.subsetOf$(this, that);
    }

    @Override
    public boolean equals(Object that) {
        return GenSetLike.equals$(this, that);
    }

    @Override
    public int hashCode() {
        return GenSetLike.hashCode$(this);
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, Object> compose(Function1<A, A> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public <A> Function1<A, A> andThen(Function1<Object, A> g) {
        return Function1.andThen$(this, g);
    }

    public AbstractSet() {
        GenSetLike.$init$(this);
        GenericSetTemplate.$init$(this);
        GenSet.$init$(this);
        Subtractable.$init$(this);
        SetLike.$init$(this);
        Set.$init$(this);
    }
}

