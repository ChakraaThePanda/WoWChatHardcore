/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.concurrent.Map;
import scala.collection.convert.LowPriorityWrapAsScala;
import scala.collection.convert.WrapAsScala;
import scala.collection.mutable.Buffer;

public final class WrapAsScala$
implements WrapAsScala {
    public static WrapAsScala$ MODULE$;

    static {
        new WrapAsScala$();
    }

    @Override
    public <A> Iterator<A> deprecated$u0020asScalaIterator(java.util.Iterator<A> it) {
        return WrapAsScala.deprecated$u0020asScalaIterator$(this, it);
    }

    @Override
    public <A> Iterator<A> deprecated$u0020enumerationAsScalaIterator(Enumeration<A> i) {
        return WrapAsScala.deprecated$u0020enumerationAsScalaIterator$(this, i);
    }

    @Override
    public <A> Iterable<A> deprecated$u0020iterableAsScalaIterable(java.lang.Iterable<A> i) {
        return WrapAsScala.deprecated$u0020iterableAsScalaIterable$(this, i);
    }

    @Override
    public <A> Iterable<A> deprecated$u0020collectionAsScalaIterable(Collection<A> i) {
        return WrapAsScala.deprecated$u0020collectionAsScalaIterable$(this, i);
    }

    @Override
    public <A> Buffer<A> deprecated$u0020asScalaBuffer(List<A> l) {
        return WrapAsScala.deprecated$u0020asScalaBuffer$(this, l);
    }

    @Override
    public <A> scala.collection.mutable.Set<A> deprecated$u0020asScalaSet(Set<A> s) {
        return WrapAsScala.deprecated$u0020asScalaSet$(this, s);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020mapAsScalaMap(java.util.Map<A, B> m) {
        return WrapAsScala.deprecated$u0020mapAsScalaMap$(this, m);
    }

    @Override
    public <A, B> Map<A, B> deprecated$u0020mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
        return WrapAsScala.deprecated$u0020mapAsScalaConcurrentMap$(this, m);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020dictionaryAsScalaMap(Dictionary<A, B> p) {
        return WrapAsScala.deprecated$u0020dictionaryAsScalaMap$(this, p);
    }

    @Override
    public scala.collection.mutable.Map<String, String> deprecated$u0020propertiesAsScalaMap(Properties p) {
        return WrapAsScala.deprecated$u0020propertiesAsScalaMap$(this, p);
    }

    @Override
    public <A> Iterator<A> asScalaIterator(java.util.Iterator<A> it) {
        return LowPriorityWrapAsScala.asScalaIterator$(this, it);
    }

    @Override
    public <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> i) {
        return LowPriorityWrapAsScala.enumerationAsScalaIterator$(this, i);
    }

    @Override
    public <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> i) {
        return LowPriorityWrapAsScala.iterableAsScalaIterable$(this, i);
    }

    @Override
    public <A> Iterable<A> collectionAsScalaIterable(Collection<A> i) {
        return LowPriorityWrapAsScala.collectionAsScalaIterable$(this, i);
    }

    @Override
    public <A> Buffer<A> asScalaBuffer(List<A> l) {
        return LowPriorityWrapAsScala.asScalaBuffer$(this, l);
    }

    @Override
    public <A> scala.collection.mutable.Set<A> asScalaSet(Set<A> s) {
        return LowPriorityWrapAsScala.asScalaSet$(this, s);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
        return LowPriorityWrapAsScala.mapAsScalaMap$(this, m);
    }

    @Override
    public <A, B> Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
        return LowPriorityWrapAsScala.mapAsScalaConcurrentMap$(this, m);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> p) {
        return LowPriorityWrapAsScala.dictionaryAsScalaMap$(this, p);
    }

    @Override
    public scala.collection.mutable.Map<String, String> propertiesAsScalaMap(Properties p) {
        return LowPriorityWrapAsScala.propertiesAsScalaMap$(this, p);
    }

    private WrapAsScala$() {
        MODULE$ = this;
        LowPriorityWrapAsScala.$init$(this);
        WrapAsScala.$init$(this);
    }
}

