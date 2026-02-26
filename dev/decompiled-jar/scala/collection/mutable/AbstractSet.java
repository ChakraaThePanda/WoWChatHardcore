/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.mutable.AbstractIterable;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.SetLike;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSet;
import scala.collection.script.Message;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t2QAA\u0002\u0002\u0002)AQa\b\u0001\u0005\u0002\u0001\u00121\"\u00112tiJ\f7\r^*fi*\u0011A!B\u0001\b[V$\u0018M\u00197f\u0015\t1q!\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001C\u0001\u0006g\u000e\fG.Y\u0002\u0001+\tY!cE\u0002\u0001\u0019q\u00012!\u0004\b\u0011\u001b\u0005\u0019\u0011BA\b\u0004\u0005A\t%m\u001d;sC\u000e$\u0018\n^3sC\ndW\r\u0005\u0002\u0012%1\u0001A!B\n\u0001\u0005\u0004!\"!A!\u0012\u0005UI\u0002C\u0001\f\u0018\u001b\u00059\u0011B\u0001\r\b\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"A\u0006\u000e\n\u0005m9!aA!osB\u0019Q\"\b\t\n\u0005y\u0019!aA*fi\u00061A(\u001b8jiz\"\u0012!\t\t\u0004\u001b\u0001\u0001\u0002")
public abstract class AbstractSet<A>
extends AbstractIterable<A>
implements scala.collection.mutable.Set<A> {
    @Override
    public GenericCompanion<scala.collection.mutable.Set> companion() {
        return scala.collection.mutable.Set.companion$(this);
    }

    @Override
    public scala.collection.mutable.Set<A> seq() {
        return scala.collection.mutable.Set.seq$(this);
    }

    @Override
    public Builder<A, scala.collection.mutable.Set<A>> newBuilder() {
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
    public boolean add(A elem) {
        return SetLike.add$(this, elem);
    }

    @Override
    public boolean remove(A elem) {
        return SetLike.remove$(this, elem);
    }

    @Override
    public void update(A elem, boolean included) {
        SetLike.update$(this, elem, included);
    }

    @Override
    public void retain(Function1<A, Object> p) {
        SetLike.retain$(this, p);
    }

    @Override
    public void clear() {
        SetLike.clear$(this);
    }

    @Override
    public scala.collection.mutable.Set<A> clone() {
        return SetLike.clone$(this);
    }

    @Override
    public scala.collection.mutable.Set<A> result() {
        return SetLike.result$(this);
    }

    @Override
    public scala.collection.mutable.Set<A> $plus(A elem) {
        return SetLike.$plus$(this, elem);
    }

    @Override
    public scala.collection.mutable.Set<A> $plus(A elem1, A elem2, Seq<A> elems) {
        return SetLike.$plus$(this, elem1, elem2, elems);
    }

    @Override
    public scala.collection.mutable.Set<A> $plus$plus(GenTraversableOnce<A> xs) {
        return SetLike.$plus$plus$(this, xs);
    }

    @Override
    public scala.collection.mutable.Set<A> $minus(A elem) {
        return SetLike.$minus$(this, elem);
    }

    @Override
    public scala.collection.mutable.Set<A> $minus(A elem1, A elem2, Seq<A> elems) {
        return SetLike.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public scala.collection.mutable.Set<A> $minus$minus(GenTraversableOnce<A> xs) {
        return SetLike.$minus$minus$(this, xs);
    }

    @Override
    public void $less$less(Message<A> cmd) {
        SetLike.$less$less$(this, cmd);
    }

    @Override
    public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
        return super.clone();
    }

    @Override
    public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
        return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
        return Shrinkable.$minus$minus$eq$(this, xs);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<A, NewTo> mapResult(Function1<scala.collection.mutable.Set<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public /* synthetic */ Object scala$collection$SetLike$$super$map(Function1 f, CanBuildFrom bf) {
        return TraversableLike.map$(this, f, bf);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return scala.collection.SetLike.toBuffer$(this);
    }

    @Override
    public <B, That> That map(Function1<A, B> f, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)scala.collection.SetLike.map$(this, f, bf);
    }

    @Override
    public boolean isEmpty() {
        return scala.collection.SetLike.isEmpty$(this);
    }

    @Override
    public Set union(GenSet that) {
        return scala.collection.SetLike.union$(this, that);
    }

    @Override
    public Set diff(GenSet that) {
        return scala.collection.SetLike.diff$(this, that);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> subsets(int len) {
        return scala.collection.SetLike.subsets$(this, len);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> subsets() {
        return scala.collection.SetLike.subsets$(this);
    }

    @Override
    public String stringPrefix() {
        return scala.collection.SetLike.stringPrefix$(this);
    }

    @Override
    public String toString() {
        return scala.collection.SetLike.toString$(this);
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
        scala.collection.SetLike.$init$(this);
        Set.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
        Shrinkable.$init$(this);
        Cloneable.$init$(this);
        SetLike.$init$(this);
        scala.collection.mutable.Set.$init$(this);
    }
}

