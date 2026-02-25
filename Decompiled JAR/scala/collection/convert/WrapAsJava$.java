/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.convert.LowPriorityWrapAsJava;
import scala.collection.convert.WrapAsJava;
import scala.collection.mutable.Buffer;

public final class WrapAsJava$
implements WrapAsJava {
    public static WrapAsJava$ MODULE$;

    static {
        new WrapAsJava$();
    }

    @Override
    public <A> java.util.Iterator<A> deprecated$u0020asJavaIterator(Iterator<A> it) {
        return WrapAsJava.deprecated$u0020asJavaIterator$(this, it);
    }

    @Override
    public <A> Enumeration<A> deprecated$u0020asJavaEnumeration(Iterator<A> it) {
        return WrapAsJava.deprecated$u0020asJavaEnumeration$(this, it);
    }

    @Override
    public <A> java.lang.Iterable<A> deprecated$u0020asJavaIterable(Iterable<A> i) {
        return WrapAsJava.deprecated$u0020asJavaIterable$(this, i);
    }

    @Override
    public <A> Collection<A> deprecated$u0020asJavaCollection(Iterable<A> it) {
        return WrapAsJava.deprecated$u0020asJavaCollection$(this, it);
    }

    @Override
    public <A> List<A> deprecated$u0020bufferAsJavaList(Buffer<A> b) {
        return WrapAsJava.deprecated$u0020bufferAsJavaList$(this, b);
    }

    @Override
    public <A> List<A> deprecated$u0020mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
        return WrapAsJava.deprecated$u0020mutableSeqAsJavaList$(this, seq);
    }

    @Override
    public <A> List<A> deprecated$u0020seqAsJavaList(Seq<A> seq) {
        return WrapAsJava.deprecated$u0020seqAsJavaList$(this, seq);
    }

    @Override
    public <A> java.util.Set<A> deprecated$u0020mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
        return WrapAsJava.deprecated$u0020mutableSetAsJavaSet$(this, s);
    }

    @Override
    public <A> java.util.Set<A> deprecated$u0020setAsJavaSet(Set<A> s) {
        return WrapAsJava.deprecated$u0020setAsJavaSet$(this, s);
    }

    @Override
    public <A, B> java.util.Map<A, B> deprecated$u0020mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
        return WrapAsJava.deprecated$u0020mutableMapAsJavaMap$(this, m);
    }

    @Override
    public <A, B> Dictionary<A, B> deprecated$u0020asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
        return WrapAsJava.deprecated$u0020asJavaDictionary$(this, m);
    }

    @Override
    public <A, B> java.util.Map<A, B> deprecated$u0020mapAsJavaMap(Map<A, B> m) {
        return WrapAsJava.deprecated$u0020mapAsJavaMap$(this, m);
    }

    @Override
    public <A, B> ConcurrentMap<A, B> deprecated$u0020mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        return WrapAsJava.deprecated$u0020mapAsJavaConcurrentMap$(this, m);
    }

    @Override
    public <A> java.util.Iterator<A> asJavaIterator(Iterator<A> it) {
        return LowPriorityWrapAsJava.asJavaIterator$(this, it);
    }

    @Override
    public <A> Enumeration<A> asJavaEnumeration(Iterator<A> it) {
        return LowPriorityWrapAsJava.asJavaEnumeration$(this, it);
    }

    @Override
    public <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> i) {
        return LowPriorityWrapAsJava.asJavaIterable$(this, i);
    }

    @Override
    public <A> Collection<A> asJavaCollection(Iterable<A> it) {
        return LowPriorityWrapAsJava.asJavaCollection$(this, it);
    }

    @Override
    public <A> List<A> bufferAsJavaList(Buffer<A> b) {
        return LowPriorityWrapAsJava.bufferAsJavaList$(this, b);
    }

    @Override
    public <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
        return LowPriorityWrapAsJava.mutableSeqAsJavaList$(this, seq);
    }

    @Override
    public <A> List<A> seqAsJavaList(Seq<A> seq) {
        return LowPriorityWrapAsJava.seqAsJavaList$(this, seq);
    }

    @Override
    public <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
        return LowPriorityWrapAsJava.mutableSetAsJavaSet$(this, s);
    }

    @Override
    public <A> java.util.Set<A> setAsJavaSet(Set<A> s) {
        return LowPriorityWrapAsJava.setAsJavaSet$(this, s);
    }

    @Override
    public <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
        return LowPriorityWrapAsJava.mutableMapAsJavaMap$(this, m);
    }

    @Override
    public <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
        return LowPriorityWrapAsJava.asJavaDictionary$(this, m);
    }

    @Override
    public <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> m) {
        return LowPriorityWrapAsJava.mapAsJavaMap$(this, m);
    }

    @Override
    public <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        return LowPriorityWrapAsJava.mapAsJavaConcurrentMap$(this, m);
    }

    private WrapAsJava$() {
        MODULE$ = this;
        LowPriorityWrapAsJava.$init$(this);
        WrapAsJava.$init$(this);
    }
}

