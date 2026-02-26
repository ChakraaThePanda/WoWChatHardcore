/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentMap;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.convert.LowPriorityWrapAsJava;
import scala.collection.convert.LowPriorityWrapAsScala;
import scala.collection.convert.WrapAsJava;
import scala.collection.convert.WrapAsScala;
import scala.collection.mutable.Buffer;

public final class JavaConversions$
implements WrapAsScala,
WrapAsJava {
    public static JavaConversions$ MODULE$;

    static {
        new JavaConversions$();
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
    public <A> scala.collection.mutable.Set<A> deprecated$u0020asScalaSet(java.util.Set<A> s) {
        return WrapAsScala.deprecated$u0020asScalaSet$(this, s);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020mapAsScalaMap(java.util.Map<A, B> m) {
        return WrapAsScala.deprecated$u0020mapAsScalaMap$(this, m);
    }

    @Override
    public <A, B> scala.collection.concurrent.Map<A, B> deprecated$u0020mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
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
    public <A> scala.collection.mutable.Set<A> asScalaSet(java.util.Set<A> s) {
        return LowPriorityWrapAsScala.asScalaSet$(this, s);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
        return LowPriorityWrapAsScala.mapAsScalaMap$(this, m);
    }

    @Override
    public <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
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

    private JavaConversions$() {
        MODULE$ = this;
        LowPriorityWrapAsScala.$init$(this);
        WrapAsScala.$init$(this);
        LowPriorityWrapAsJava.$init$(this);
        WrapAsJava.$init$(this);
    }
}

