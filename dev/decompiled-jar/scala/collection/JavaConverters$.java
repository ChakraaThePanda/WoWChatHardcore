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
import scala.collection.convert.AsJavaConverters;
import scala.collection.convert.AsScalaConverters;
import scala.collection.convert.DecorateAsJava;
import scala.collection.convert.DecorateAsScala;
import scala.collection.convert.Decorators;
import scala.collection.mutable.Buffer;

public final class JavaConverters$
implements DecorateAsJava,
DecorateAsScala {
    public static JavaConverters$ MODULE$;

    static {
        new JavaConverters$();
    }

    @Override
    public <A> Decorators.AsScala<Iterator<A>> asScalaIteratorConverter(java.util.Iterator<A> i) {
        return DecorateAsScala.asScalaIteratorConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsScala<Iterator<A>> enumerationAsScalaIteratorConverter(Enumeration<A> i) {
        return DecorateAsScala.enumerationAsScalaIteratorConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsScala<Iterable<A>> iterableAsScalaIterableConverter(java.lang.Iterable<A> i) {
        return DecorateAsScala.iterableAsScalaIterableConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsScala<Iterable<A>> collectionAsScalaIterableConverter(Collection<A> i) {
        return DecorateAsScala.collectionAsScalaIterableConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsScala<Buffer<A>> asScalaBufferConverter(List<A> l) {
        return DecorateAsScala.asScalaBufferConverter$(this, l);
    }

    @Override
    public <A> Decorators.AsScala<scala.collection.mutable.Set<A>> asScalaSetConverter(java.util.Set<A> s) {
        return DecorateAsScala.asScalaSetConverter$(this, s);
    }

    @Override
    public <A, B> Decorators.AsScala<scala.collection.mutable.Map<A, B>> mapAsScalaMapConverter(java.util.Map<A, B> m) {
        return DecorateAsScala.mapAsScalaMapConverter$(this, m);
    }

    @Override
    public <A, B> Decorators.AsScala<scala.collection.concurrent.Map<A, B>> mapAsScalaConcurrentMapConverter(ConcurrentMap<A, B> m) {
        return DecorateAsScala.mapAsScalaConcurrentMapConverter$(this, m);
    }

    @Override
    public <A, B> Decorators.AsScala<scala.collection.mutable.Map<A, B>> dictionaryAsScalaMapConverter(Dictionary<A, B> p) {
        return DecorateAsScala.dictionaryAsScalaMapConverter$(this, p);
    }

    @Override
    public Decorators.AsScala<scala.collection.mutable.Map<String, String>> propertiesAsScalaMapConverter(Properties p) {
        return DecorateAsScala.propertiesAsScalaMapConverter$(this, p);
    }

    @Override
    public <A> Iterator<A> asScalaIterator(java.util.Iterator<A> i) {
        return AsScalaConverters.asScalaIterator$(this, i);
    }

    @Override
    public <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> i) {
        return AsScalaConverters.enumerationAsScalaIterator$(this, i);
    }

    @Override
    public <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> i) {
        return AsScalaConverters.iterableAsScalaIterable$(this, i);
    }

    @Override
    public <A> Iterable<A> collectionAsScalaIterable(Collection<A> i) {
        return AsScalaConverters.collectionAsScalaIterable$(this, i);
    }

    @Override
    public <A> Buffer<A> asScalaBuffer(List<A> l) {
        return AsScalaConverters.asScalaBuffer$(this, l);
    }

    @Override
    public <A> scala.collection.mutable.Set<A> asScalaSet(java.util.Set<A> s) {
        return AsScalaConverters.asScalaSet$(this, s);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
        return AsScalaConverters.mapAsScalaMap$(this, m);
    }

    @Override
    public <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
        return AsScalaConverters.mapAsScalaConcurrentMap$(this, m);
    }

    @Override
    public <A, B> scala.collection.mutable.Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> p) {
        return AsScalaConverters.dictionaryAsScalaMap$(this, p);
    }

    @Override
    public scala.collection.mutable.Map<String, String> propertiesAsScalaMap(Properties p) {
        return AsScalaConverters.propertiesAsScalaMap$(this, p);
    }

    @Override
    public <A> Decorators.AsJava<java.util.Iterator<A>> asJavaIteratorConverter(Iterator<A> i) {
        return DecorateAsJava.asJavaIteratorConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsJavaEnumeration<A> asJavaEnumerationConverter(Iterator<A> i) {
        return DecorateAsJava.asJavaEnumerationConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsJava<java.lang.Iterable<A>> asJavaIterableConverter(Iterable<A> i) {
        return DecorateAsJava.asJavaIterableConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsJavaCollection<A> asJavaCollectionConverter(Iterable<A> i) {
        return DecorateAsJava.asJavaCollectionConverter$(this, i);
    }

    @Override
    public <A> Decorators.AsJava<List<A>> bufferAsJavaListConverter(Buffer<A> b) {
        return DecorateAsJava.bufferAsJavaListConverter$(this, b);
    }

    @Override
    public <A> Decorators.AsJava<List<A>> mutableSeqAsJavaListConverter(scala.collection.mutable.Seq<A> b) {
        return DecorateAsJava.mutableSeqAsJavaListConverter$(this, b);
    }

    @Override
    public <A> Decorators.AsJava<List<A>> seqAsJavaListConverter(Seq<A> b) {
        return DecorateAsJava.seqAsJavaListConverter$(this, b);
    }

    @Override
    public <A> Decorators.AsJava<java.util.Set<A>> mutableSetAsJavaSetConverter(scala.collection.mutable.Set<A> s) {
        return DecorateAsJava.mutableSetAsJavaSetConverter$(this, s);
    }

    @Override
    public <A> Decorators.AsJava<java.util.Set<A>> setAsJavaSetConverter(Set<A> s) {
        return DecorateAsJava.setAsJavaSetConverter$(this, s);
    }

    @Override
    public <A, B> Decorators.AsJava<java.util.Map<A, B>> mutableMapAsJavaMapConverter(scala.collection.mutable.Map<A, B> m) {
        return DecorateAsJava.mutableMapAsJavaMapConverter$(this, m);
    }

    @Override
    public <A, B> Decorators.AsJavaDictionary<A, B> asJavaDictionaryConverter(scala.collection.mutable.Map<A, B> m) {
        return DecorateAsJava.asJavaDictionaryConverter$(this, m);
    }

    @Override
    public <A, B> Decorators.AsJava<java.util.Map<A, B>> mapAsJavaMapConverter(Map<A, B> m) {
        return DecorateAsJava.mapAsJavaMapConverter$(this, m);
    }

    @Override
    public <A, B> Decorators.AsJava<ConcurrentMap<A, B>> mapAsJavaConcurrentMapConverter(scala.collection.concurrent.Map<A, B> m) {
        return DecorateAsJava.mapAsJavaConcurrentMapConverter$(this, m);
    }

    @Override
    public <A> java.util.Iterator<A> asJavaIterator(Iterator<A> i) {
        return AsJavaConverters.asJavaIterator$(this, i);
    }

    @Override
    public <A> Enumeration<A> asJavaEnumeration(Iterator<A> i) {
        return AsJavaConverters.asJavaEnumeration$(this, i);
    }

    @Override
    public <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> i) {
        return AsJavaConverters.asJavaIterable$(this, i);
    }

    @Override
    public <A> Collection<A> asJavaCollection(Iterable<A> i) {
        return AsJavaConverters.asJavaCollection$(this, i);
    }

    @Override
    public <A> List<A> bufferAsJavaList(Buffer<A> b) {
        return AsJavaConverters.bufferAsJavaList$(this, b);
    }

    @Override
    public <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> s) {
        return AsJavaConverters.mutableSeqAsJavaList$(this, s);
    }

    @Override
    public <A> List<A> seqAsJavaList(Seq<A> s) {
        return AsJavaConverters.seqAsJavaList$(this, s);
    }

    @Override
    public <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
        return AsJavaConverters.mutableSetAsJavaSet$(this, s);
    }

    @Override
    public <A> java.util.Set<A> setAsJavaSet(Set<A> s) {
        return AsJavaConverters.setAsJavaSet$(this, s);
    }

    @Override
    public <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
        return AsJavaConverters.mutableMapAsJavaMap$(this, m);
    }

    @Override
    public <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
        return AsJavaConverters.asJavaDictionary$(this, m);
    }

    @Override
    public <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> m) {
        return AsJavaConverters.mapAsJavaMap$(this, m);
    }

    @Override
    public <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        return AsJavaConverters.mapAsJavaConcurrentMap$(this, m);
    }

    private JavaConverters$() {
        MODULE$ = this;
        AsJavaConverters.$init$(this);
        DecorateAsJava.$init$(this);
        AsScalaConverters.$init$(this);
        DecorateAsScala.$init$(this);
    }
}

