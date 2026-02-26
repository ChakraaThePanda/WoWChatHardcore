/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Option;
import scala.PartialFunction;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.mutable.BitSet;
import scala.collection.mutable.LinkedHashMap;
import scala.reflect.internal.util.Collections;
import scala.runtime.BoxedUnit;

public final class Collections$
implements Collections {
    public static Collections$ MODULE$;

    static {
        new Collections$();
    }

    @Override
    public final <A, B, C> boolean corresponds3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        return Collections.corresponds3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A> boolean mexists(List<List<A>> xss, Function1<A, Object> p) {
        return Collections.mexists$(this, xss, p);
    }

    @Override
    public final <A> boolean mforall(List<List<A>> xss, Function1<A, Object> p) {
        return Collections.mforall$(this, xss, p);
    }

    @Override
    public final <A, B> List<List<B>> mmap(List<List<A>> xss, Function1<A, B> f) {
        return Collections.mmap$(this, xss, f);
    }

    @Override
    public final <A> Option<A> mfind(List<List<A>> xss, Function1<A, Object> p) {
        return Collections.mfind$(this, xss, p);
    }

    @Override
    public final <A> void mforeach(List<List<A>> xss, Function1<A, BoxedUnit> f) {
        Collections.mforeach$((Collections)this, xss, f);
    }

    @Override
    public final <A> void mforeach(Traversable<Traversable<A>> xss, Function1<A, BoxedUnit> f) {
        Collections.mforeach$((Collections)this, xss, f);
    }

    @Override
    public final <A, B> List<B> mapList(List<A> as, Function1<A, B> f) {
        return Collections.mapList$(this, as, f);
    }

    @Override
    public final boolean sameElementsEquals(List<Object> thiss, List<Object> that) {
        return Collections.sameElementsEquals$(this, thiss, that);
    }

    @Override
    public final <A, B> Option<B> collectFirst(List<A> as, PartialFunction<A, B> pf) {
        return Collections.collectFirst$(this, as, pf);
    }

    @Override
    public final <A, B, C> List<C> map2(List<A> xs1, List<B> xs2, Function2<A, B, C> f) {
        return Collections.map2$(this, xs1, xs2, f);
    }

    @Override
    public final <A, B> List<A> map2Conserve(List<A> xs, List<B> ys, Function2<A, B, A> f) {
        return Collections.map2Conserve$(this, xs, ys, f);
    }

    @Override
    public final <A, B, C, D> List<D> map3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, D> f) {
        return Collections.map3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B, C> List<C> flatMap2(List<A> xs1, List<B> xs2, Function2<A, B, List<C>> f) {
        return Collections.flatMap2$(this, xs1, xs2, f);
    }

    @Override
    public final <A1, A2, B> B foldLeft2(List<A1> xs1, List<A2> xs2, B z0, Function3<B, A1, A2, B> f) {
        return (B)Collections.foldLeft2$(this, xs1, xs2, z0, f);
    }

    @Override
    public final <A, B> List<B> flatCollect(List<A> elems, PartialFunction<A, Traversable<B>> pf) {
        return Collections.flatCollect$(this, elems, pf);
    }

    @Override
    public final <A, B> List<A> distinctBy(List<A> xs, Function1<A, B> f) {
        return Collections.distinctBy$(this, xs, f);
    }

    @Override
    public final boolean flattensToEmpty(Seq<Seq<?>> xss) {
        return Collections.flattensToEmpty$(this, xss);
    }

    @Override
    public final <A> void foreachWithIndex(List<A> xs, Function2<A, Object, BoxedUnit> f) {
        Collections.foreachWithIndex$(this, xs, f);
    }

    @Override
    public final <A> A findOrElse(TraversableOnce<A> xs, Function1<A, Object> p, Function0<A> orElse) {
        return (A)Collections.findOrElse$(this, xs, p, orElse);
    }

    @Override
    public final <A, A1, B> Map<A1, B> mapFrom(List<A> xs, Function1<A, B> f) {
        return Collections.mapFrom$(this, xs, f);
    }

    @Override
    public final <A, A1, B> LinkedHashMap<A1, B> linkedMapFrom(List<A> xs, Function1<A, B> f) {
        return Collections.linkedMapFrom$(this, xs, f);
    }

    @Override
    public final <A, B> List<B> mapWithIndex(List<A> xs, Function2<A, Object, B> f) {
        return Collections.mapWithIndex$(this, xs, f);
    }

    @Override
    public final <A, B, C> Map<A, B> collectMap2(List<A> xs1, List<B> xs2, Function2<A, B, Object> p) {
        return Collections.collectMap2$(this, xs1, xs2, p);
    }

    @Override
    public final <A, B> void foreach2(List<A> xs1, List<B> xs2, Function2<A, B, BoxedUnit> f) {
        Collections.foreach2$(this, xs1, xs2, f);
    }

    @Override
    public final <A, B, C> void foreach3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, BoxedUnit> f) {
        Collections.foreach3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B> boolean exists2(List<A> xs1, List<B> xs2, Function2<A, B, Object> f) {
        return Collections.exists2$(this, xs1, xs2, f);
    }

    @Override
    public final <A, B, C> boolean exists3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        return Collections.exists3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B, C> boolean forall3(List<A> xs1, List<B> xs2, List<C> xs3, Function3<A, B, C, Object> f) {
        return Collections.forall3$(this, xs1, xs2, xs3, f);
    }

    @Override
    public final <A, B, C> Iterator<C> mapFilter2(Iterator<A> itA, Iterator<B> itB, Function2<A, B, Option<C>> f) {
        return Collections.mapFilter2$(this, itA, itB, f);
    }

    @Override
    public final <A> Option<List<A>> sequenceOpt(List<Option<A>> as) {
        return Collections.sequenceOpt$(this, as);
    }

    @Override
    public final <A, B> Option<List<B>> traverseOpt(List<A> as, Function1<A, Option<B>> f) {
        return Collections.traverseOpt$(this, as, f);
    }

    @Override
    public final <A> BitSet bitSetByPredicate(List<A> xs, Function1<A, Object> pred) {
        return Collections.bitSetByPredicate$(this, xs, pred);
    }

    @Override
    public final <A> Option<List<A>> sequence(List<Option<A>> as) {
        return Collections.sequence$(this, as);
    }

    @Override
    public final <A> Option<List<List<A>>> transposeSafe(List<List<A>> ass) {
        return Collections.transposeSafe$(this, ass);
    }

    @Override
    public final boolean sameLength(List<?> xs1, List<?> xs2) {
        return Collections.sameLength$(this, xs1, xs2);
    }

    @Override
    public final int compareLengths(List<?> xs1, List<?> xs2) {
        return Collections.compareLengths$(this, xs1, xs2);
    }

    @Override
    public final boolean hasLength(List<?> xs, int len) {
        return Collections.hasLength$(this, xs, len);
    }

    @Override
    public final int sumSize(List<List<?>> xss, int acc) {
        return Collections.sumSize$(this, xss, acc);
    }

    private Collections$() {
        MODULE$ = this;
        Collections.$init$(this);
    }
}

