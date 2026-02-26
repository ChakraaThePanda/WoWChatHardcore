/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentMap;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.JavaConverters$;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.convert.AsJavaConverters;
import scala.collection.convert.AsScalaConverters;
import scala.collection.convert.DecorateAsJava;
import scala.collection.convert.DecorateAsScala;
import scala.collection.convert.Decorators;
import scala.collection.convert.LowPriorityWrapAsJava;
import scala.collection.convert.LowPriorityWrapAsScala;
import scala.collection.convert.WrapAsJava;
import scala.collection.convert.WrapAsScala;
import scala.collection.mutable.Buffer;

public final class package$ {
    public static package$ MODULE$;
    private final DecorateAsJava decorateAsJava;
    private final DecorateAsScala decorateAsScala;
    private final JavaConverters$ decorateAll;
    private final WrapAsJava wrapAsJava;
    private final WrapAsScala wrapAsScala;
    private final WrapAsJava wrapAll;

    static {
        new package$();
    }

    public DecorateAsJava decorateAsJava() {
        return this.decorateAsJava;
    }

    public DecorateAsScala decorateAsScala() {
        return this.decorateAsScala;
    }

    public JavaConverters$ decorateAll() {
        return this.decorateAll;
    }

    public WrapAsJava wrapAsJava() {
        return this.wrapAsJava;
    }

    public WrapAsScala wrapAsScala() {
        return this.wrapAsScala;
    }

    public WrapAsJava wrapAll() {
        return this.wrapAll;
    }

    private package$() {
        MODULE$ = this;
        this.decorateAsJava = new DecorateAsJava(){

            public <A> Decorators.AsJava<java.util.Iterator<A>> asJavaIteratorConverter(Iterator<A> i) {
                return DecorateAsJava.asJavaIteratorConverter$(this, i);
            }

            public <A> Decorators.AsJavaEnumeration<A> asJavaEnumerationConverter(Iterator<A> i) {
                return DecorateAsJava.asJavaEnumerationConverter$(this, i);
            }

            public <A> Decorators.AsJava<java.lang.Iterable<A>> asJavaIterableConverter(Iterable<A> i) {
                return DecorateAsJava.asJavaIterableConverter$(this, i);
            }

            public <A> Decorators.AsJavaCollection<A> asJavaCollectionConverter(Iterable<A> i) {
                return DecorateAsJava.asJavaCollectionConverter$(this, i);
            }

            public <A> Decorators.AsJava<List<A>> bufferAsJavaListConverter(Buffer<A> b) {
                return DecorateAsJava.bufferAsJavaListConverter$(this, b);
            }

            public <A> Decorators.AsJava<List<A>> mutableSeqAsJavaListConverter(scala.collection.mutable.Seq<A> b) {
                return DecorateAsJava.mutableSeqAsJavaListConverter$(this, b);
            }

            public <A> Decorators.AsJava<List<A>> seqAsJavaListConverter(Seq<A> b) {
                return DecorateAsJava.seqAsJavaListConverter$(this, b);
            }

            public <A> Decorators.AsJava<java.util.Set<A>> mutableSetAsJavaSetConverter(scala.collection.mutable.Set<A> s) {
                return DecorateAsJava.mutableSetAsJavaSetConverter$(this, s);
            }

            public <A> Decorators.AsJava<java.util.Set<A>> setAsJavaSetConverter(Set<A> s) {
                return DecorateAsJava.setAsJavaSetConverter$(this, s);
            }

            public <A, B> Decorators.AsJava<java.util.Map<A, B>> mutableMapAsJavaMapConverter(scala.collection.mutable.Map<A, B> m) {
                return DecorateAsJava.mutableMapAsJavaMapConverter$(this, m);
            }

            public <A, B> Decorators.AsJavaDictionary<A, B> asJavaDictionaryConverter(scala.collection.mutable.Map<A, B> m) {
                return DecorateAsJava.asJavaDictionaryConverter$(this, m);
            }

            public <A, B> Decorators.AsJava<java.util.Map<A, B>> mapAsJavaMapConverter(Map<A, B> m) {
                return DecorateAsJava.mapAsJavaMapConverter$(this, m);
            }

            public <A, B> Decorators.AsJava<ConcurrentMap<A, B>> mapAsJavaConcurrentMapConverter(scala.collection.concurrent.Map<A, B> m) {
                return DecorateAsJava.mapAsJavaConcurrentMapConverter$(this, m);
            }

            public <A> java.util.Iterator<A> asJavaIterator(Iterator<A> i) {
                return AsJavaConverters.asJavaIterator$(this, i);
            }

            public <A> Enumeration<A> asJavaEnumeration(Iterator<A> i) {
                return AsJavaConverters.asJavaEnumeration$(this, i);
            }

            public <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> i) {
                return AsJavaConverters.asJavaIterable$(this, i);
            }

            public <A> Collection<A> asJavaCollection(Iterable<A> i) {
                return AsJavaConverters.asJavaCollection$(this, i);
            }

            public <A> List<A> bufferAsJavaList(Buffer<A> b) {
                return AsJavaConverters.bufferAsJavaList$(this, b);
            }

            public <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> s) {
                return AsJavaConverters.mutableSeqAsJavaList$(this, s);
            }

            public <A> List<A> seqAsJavaList(Seq<A> s) {
                return AsJavaConverters.seqAsJavaList$(this, s);
            }

            public <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
                return AsJavaConverters.mutableSetAsJavaSet$(this, s);
            }

            public <A> java.util.Set<A> setAsJavaSet(Set<A> s) {
                return AsJavaConverters.setAsJavaSet$(this, s);
            }

            public <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
                return AsJavaConverters.mutableMapAsJavaMap$(this, m);
            }

            public <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
                return AsJavaConverters.asJavaDictionary$(this, m);
            }

            public <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> m) {
                return AsJavaConverters.mapAsJavaMap$(this, m);
            }

            public <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
                return AsJavaConverters.mapAsJavaConcurrentMap$(this, m);
            }
            {
                AsJavaConverters.$init$(this);
                DecorateAsJava.$init$(this);
            }
        };
        this.decorateAsScala = new DecorateAsScala(){

            public <A> Decorators.AsScala<Iterator<A>> asScalaIteratorConverter(java.util.Iterator<A> i) {
                return DecorateAsScala.asScalaIteratorConverter$(this, i);
            }

            public <A> Decorators.AsScala<Iterator<A>> enumerationAsScalaIteratorConverter(Enumeration<A> i) {
                return DecorateAsScala.enumerationAsScalaIteratorConverter$(this, i);
            }

            public <A> Decorators.AsScala<Iterable<A>> iterableAsScalaIterableConverter(java.lang.Iterable<A> i) {
                return DecorateAsScala.iterableAsScalaIterableConverter$(this, i);
            }

            public <A> Decorators.AsScala<Iterable<A>> collectionAsScalaIterableConverter(Collection<A> i) {
                return DecorateAsScala.collectionAsScalaIterableConverter$(this, i);
            }

            public <A> Decorators.AsScala<Buffer<A>> asScalaBufferConverter(List<A> l) {
                return DecorateAsScala.asScalaBufferConverter$(this, l);
            }

            public <A> Decorators.AsScala<scala.collection.mutable.Set<A>> asScalaSetConverter(java.util.Set<A> s) {
                return DecorateAsScala.asScalaSetConverter$(this, s);
            }

            public <A, B> Decorators.AsScala<scala.collection.mutable.Map<A, B>> mapAsScalaMapConverter(java.util.Map<A, B> m) {
                return DecorateAsScala.mapAsScalaMapConverter$(this, m);
            }

            public <A, B> Decorators.AsScala<scala.collection.concurrent.Map<A, B>> mapAsScalaConcurrentMapConverter(ConcurrentMap<A, B> m) {
                return DecorateAsScala.mapAsScalaConcurrentMapConverter$(this, m);
            }

            public <A, B> Decorators.AsScala<scala.collection.mutable.Map<A, B>> dictionaryAsScalaMapConverter(Dictionary<A, B> p) {
                return DecorateAsScala.dictionaryAsScalaMapConverter$(this, p);
            }

            public Decorators.AsScala<scala.collection.mutable.Map<String, String>> propertiesAsScalaMapConverter(Properties p) {
                return DecorateAsScala.propertiesAsScalaMapConverter$(this, p);
            }

            public <A> Iterator<A> asScalaIterator(java.util.Iterator<A> i) {
                return AsScalaConverters.asScalaIterator$(this, i);
            }

            public <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> i) {
                return AsScalaConverters.enumerationAsScalaIterator$(this, i);
            }

            public <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> i) {
                return AsScalaConverters.iterableAsScalaIterable$(this, i);
            }

            public <A> Iterable<A> collectionAsScalaIterable(Collection<A> i) {
                return AsScalaConverters.collectionAsScalaIterable$(this, i);
            }

            public <A> Buffer<A> asScalaBuffer(List<A> l) {
                return AsScalaConverters.asScalaBuffer$(this, l);
            }

            public <A> scala.collection.mutable.Set<A> asScalaSet(java.util.Set<A> s) {
                return AsScalaConverters.asScalaSet$(this, s);
            }

            public <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
                return AsScalaConverters.mapAsScalaMap$(this, m);
            }

            public <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
                return AsScalaConverters.mapAsScalaConcurrentMap$(this, m);
            }

            public <A, B> scala.collection.mutable.Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> p) {
                return AsScalaConverters.dictionaryAsScalaMap$(this, p);
            }

            public scala.collection.mutable.Map<String, String> propertiesAsScalaMap(Properties p) {
                return AsScalaConverters.propertiesAsScalaMap$(this, p);
            }
            {
                AsScalaConverters.$init$(this);
                DecorateAsScala.$init$(this);
            }
        };
        this.decorateAll = JavaConverters$.MODULE$;
        this.wrapAsJava = new WrapAsJava(){

            public <A> java.util.Iterator<A> deprecated$u0020asJavaIterator(Iterator<A> it) {
                return WrapAsJava.deprecated$u0020asJavaIterator$(this, it);
            }

            public <A> Enumeration<A> deprecated$u0020asJavaEnumeration(Iterator<A> it) {
                return WrapAsJava.deprecated$u0020asJavaEnumeration$(this, it);
            }

            public <A> java.lang.Iterable<A> deprecated$u0020asJavaIterable(Iterable<A> i) {
                return WrapAsJava.deprecated$u0020asJavaIterable$(this, i);
            }

            public <A> Collection<A> deprecated$u0020asJavaCollection(Iterable<A> it) {
                return WrapAsJava.deprecated$u0020asJavaCollection$(this, it);
            }

            public <A> List<A> deprecated$u0020bufferAsJavaList(Buffer<A> b) {
                return WrapAsJava.deprecated$u0020bufferAsJavaList$(this, b);
            }

            public <A> List<A> deprecated$u0020mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
                return WrapAsJava.deprecated$u0020mutableSeqAsJavaList$(this, seq);
            }

            public <A> List<A> deprecated$u0020seqAsJavaList(Seq<A> seq) {
                return WrapAsJava.deprecated$u0020seqAsJavaList$(this, seq);
            }

            public <A> java.util.Set<A> deprecated$u0020mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
                return WrapAsJava.deprecated$u0020mutableSetAsJavaSet$(this, s);
            }

            public <A> java.util.Set<A> deprecated$u0020setAsJavaSet(Set<A> s) {
                return WrapAsJava.deprecated$u0020setAsJavaSet$(this, s);
            }

            public <A, B> java.util.Map<A, B> deprecated$u0020mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
                return WrapAsJava.deprecated$u0020mutableMapAsJavaMap$(this, m);
            }

            public <A, B> Dictionary<A, B> deprecated$u0020asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
                return WrapAsJava.deprecated$u0020asJavaDictionary$(this, m);
            }

            public <A, B> java.util.Map<A, B> deprecated$u0020mapAsJavaMap(Map<A, B> m) {
                return WrapAsJava.deprecated$u0020mapAsJavaMap$(this, m);
            }

            public <A, B> ConcurrentMap<A, B> deprecated$u0020mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
                return WrapAsJava.deprecated$u0020mapAsJavaConcurrentMap$(this, m);
            }

            public <A> java.util.Iterator<A> asJavaIterator(Iterator<A> it) {
                return LowPriorityWrapAsJava.asJavaIterator$(this, it);
            }

            public <A> Enumeration<A> asJavaEnumeration(Iterator<A> it) {
                return LowPriorityWrapAsJava.asJavaEnumeration$(this, it);
            }

            public <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> i) {
                return LowPriorityWrapAsJava.asJavaIterable$(this, i);
            }

            public <A> Collection<A> asJavaCollection(Iterable<A> it) {
                return LowPriorityWrapAsJava.asJavaCollection$(this, it);
            }

            public <A> List<A> bufferAsJavaList(Buffer<A> b) {
                return LowPriorityWrapAsJava.bufferAsJavaList$(this, b);
            }

            public <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
                return LowPriorityWrapAsJava.mutableSeqAsJavaList$(this, seq);
            }

            public <A> List<A> seqAsJavaList(Seq<A> seq) {
                return LowPriorityWrapAsJava.seqAsJavaList$(this, seq);
            }

            public <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
                return LowPriorityWrapAsJava.mutableSetAsJavaSet$(this, s);
            }

            public <A> java.util.Set<A> setAsJavaSet(Set<A> s) {
                return LowPriorityWrapAsJava.setAsJavaSet$(this, s);
            }

            public <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
                return LowPriorityWrapAsJava.mutableMapAsJavaMap$(this, m);
            }

            public <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
                return LowPriorityWrapAsJava.asJavaDictionary$(this, m);
            }

            public <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> m) {
                return LowPriorityWrapAsJava.mapAsJavaMap$(this, m);
            }

            public <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
                return LowPriorityWrapAsJava.mapAsJavaConcurrentMap$(this, m);
            }
            {
                LowPriorityWrapAsJava.$init$(this);
                WrapAsJava.$init$(this);
            }
        };
        this.wrapAsScala = new WrapAsScala(){

            public <A> Iterator<A> deprecated$u0020asScalaIterator(java.util.Iterator<A> it) {
                return WrapAsScala.deprecated$u0020asScalaIterator$(this, it);
            }

            public <A> Iterator<A> deprecated$u0020enumerationAsScalaIterator(Enumeration<A> i) {
                return WrapAsScala.deprecated$u0020enumerationAsScalaIterator$(this, i);
            }

            public <A> Iterable<A> deprecated$u0020iterableAsScalaIterable(java.lang.Iterable<A> i) {
                return WrapAsScala.deprecated$u0020iterableAsScalaIterable$(this, i);
            }

            public <A> Iterable<A> deprecated$u0020collectionAsScalaIterable(Collection<A> i) {
                return WrapAsScala.deprecated$u0020collectionAsScalaIterable$(this, i);
            }

            public <A> Buffer<A> deprecated$u0020asScalaBuffer(List<A> l) {
                return WrapAsScala.deprecated$u0020asScalaBuffer$(this, l);
            }

            public <A> scala.collection.mutable.Set<A> deprecated$u0020asScalaSet(java.util.Set<A> s) {
                return WrapAsScala.deprecated$u0020asScalaSet$(this, s);
            }

            public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020mapAsScalaMap(java.util.Map<A, B> m) {
                return WrapAsScala.deprecated$u0020mapAsScalaMap$(this, m);
            }

            public <A, B> scala.collection.concurrent.Map<A, B> deprecated$u0020mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
                return WrapAsScala.deprecated$u0020mapAsScalaConcurrentMap$(this, m);
            }

            public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020dictionaryAsScalaMap(Dictionary<A, B> p) {
                return WrapAsScala.deprecated$u0020dictionaryAsScalaMap$(this, p);
            }

            public scala.collection.mutable.Map<String, String> deprecated$u0020propertiesAsScalaMap(Properties p) {
                return WrapAsScala.deprecated$u0020propertiesAsScalaMap$(this, p);
            }

            public <A> Iterator<A> asScalaIterator(java.util.Iterator<A> it) {
                return LowPriorityWrapAsScala.asScalaIterator$(this, it);
            }

            public <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> i) {
                return LowPriorityWrapAsScala.enumerationAsScalaIterator$(this, i);
            }

            public <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> i) {
                return LowPriorityWrapAsScala.iterableAsScalaIterable$(this, i);
            }

            public <A> Iterable<A> collectionAsScalaIterable(Collection<A> i) {
                return LowPriorityWrapAsScala.collectionAsScalaIterable$(this, i);
            }

            public <A> Buffer<A> asScalaBuffer(List<A> l) {
                return LowPriorityWrapAsScala.asScalaBuffer$(this, l);
            }

            public <A> scala.collection.mutable.Set<A> asScalaSet(java.util.Set<A> s) {
                return LowPriorityWrapAsScala.asScalaSet$(this, s);
            }

            public <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
                return LowPriorityWrapAsScala.mapAsScalaMap$(this, m);
            }

            public <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
                return LowPriorityWrapAsScala.mapAsScalaConcurrentMap$(this, m);
            }

            public <A, B> scala.collection.mutable.Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> p) {
                return LowPriorityWrapAsScala.dictionaryAsScalaMap$(this, p);
            }

            public scala.collection.mutable.Map<String, String> propertiesAsScalaMap(Properties p) {
                return LowPriorityWrapAsScala.propertiesAsScalaMap$(this, p);
            }
            {
                LowPriorityWrapAsScala.$init$(this);
                WrapAsScala.$init$(this);
            }
        };
        this.wrapAll = new WrapAsJava(){

            public <A> Iterator<A> deprecated$u0020asScalaIterator(java.util.Iterator<A> it) {
                return WrapAsScala.deprecated$u0020asScalaIterator$(this, it);
            }

            public <A> Iterator<A> deprecated$u0020enumerationAsScalaIterator(Enumeration<A> i) {
                return WrapAsScala.deprecated$u0020enumerationAsScalaIterator$(this, i);
            }

            public <A> Iterable<A> deprecated$u0020iterableAsScalaIterable(java.lang.Iterable<A> i) {
                return WrapAsScala.deprecated$u0020iterableAsScalaIterable$(this, i);
            }

            public <A> Iterable<A> deprecated$u0020collectionAsScalaIterable(Collection<A> i) {
                return WrapAsScala.deprecated$u0020collectionAsScalaIterable$(this, i);
            }

            public <A> Buffer<A> deprecated$u0020asScalaBuffer(List<A> l) {
                return WrapAsScala.deprecated$u0020asScalaBuffer$(this, l);
            }

            public <A> scala.collection.mutable.Set<A> deprecated$u0020asScalaSet(java.util.Set<A> s) {
                return WrapAsScala.deprecated$u0020asScalaSet$(this, s);
            }

            public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020mapAsScalaMap(java.util.Map<A, B> m) {
                return WrapAsScala.deprecated$u0020mapAsScalaMap$(this, m);
            }

            public <A, B> scala.collection.concurrent.Map<A, B> deprecated$u0020mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
                return WrapAsScala.deprecated$u0020mapAsScalaConcurrentMap$(this, m);
            }

            public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020dictionaryAsScalaMap(Dictionary<A, B> p) {
                return WrapAsScala.deprecated$u0020dictionaryAsScalaMap$(this, p);
            }

            public scala.collection.mutable.Map<String, String> deprecated$u0020propertiesAsScalaMap(Properties p) {
                return WrapAsScala.deprecated$u0020propertiesAsScalaMap$(this, p);
            }

            public <A> Iterator<A> asScalaIterator(java.util.Iterator<A> it) {
                return LowPriorityWrapAsScala.asScalaIterator$(this, it);
            }

            public <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> i) {
                return LowPriorityWrapAsScala.enumerationAsScalaIterator$(this, i);
            }

            public <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> i) {
                return LowPriorityWrapAsScala.iterableAsScalaIterable$(this, i);
            }

            public <A> Iterable<A> collectionAsScalaIterable(Collection<A> i) {
                return LowPriorityWrapAsScala.collectionAsScalaIterable$(this, i);
            }

            public <A> Buffer<A> asScalaBuffer(List<A> l) {
                return LowPriorityWrapAsScala.asScalaBuffer$(this, l);
            }

            public <A> scala.collection.mutable.Set<A> asScalaSet(java.util.Set<A> s) {
                return LowPriorityWrapAsScala.asScalaSet$(this, s);
            }

            public <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
                return LowPriorityWrapAsScala.mapAsScalaMap$(this, m);
            }

            public <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
                return LowPriorityWrapAsScala.mapAsScalaConcurrentMap$(this, m);
            }

            public <A, B> scala.collection.mutable.Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> p) {
                return LowPriorityWrapAsScala.dictionaryAsScalaMap$(this, p);
            }

            public scala.collection.mutable.Map<String, String> propertiesAsScalaMap(Properties p) {
                return LowPriorityWrapAsScala.propertiesAsScalaMap$(this, p);
            }

            public <A> java.util.Iterator<A> deprecated$u0020asJavaIterator(Iterator<A> it) {
                return WrapAsJava.deprecated$u0020asJavaIterator$(this, it);
            }

            public <A> Enumeration<A> deprecated$u0020asJavaEnumeration(Iterator<A> it) {
                return WrapAsJava.deprecated$u0020asJavaEnumeration$(this, it);
            }

            public <A> java.lang.Iterable<A> deprecated$u0020asJavaIterable(Iterable<A> i) {
                return WrapAsJava.deprecated$u0020asJavaIterable$(this, i);
            }

            public <A> Collection<A> deprecated$u0020asJavaCollection(Iterable<A> it) {
                return WrapAsJava.deprecated$u0020asJavaCollection$(this, it);
            }

            public <A> List<A> deprecated$u0020bufferAsJavaList(Buffer<A> b) {
                return WrapAsJava.deprecated$u0020bufferAsJavaList$(this, b);
            }

            public <A> List<A> deprecated$u0020mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
                return WrapAsJava.deprecated$u0020mutableSeqAsJavaList$(this, seq);
            }

            public <A> List<A> deprecated$u0020seqAsJavaList(Seq<A> seq) {
                return WrapAsJava.deprecated$u0020seqAsJavaList$(this, seq);
            }

            public <A> java.util.Set<A> deprecated$u0020mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
                return WrapAsJava.deprecated$u0020mutableSetAsJavaSet$(this, s);
            }

            public <A> java.util.Set<A> deprecated$u0020setAsJavaSet(Set<A> s) {
                return WrapAsJava.deprecated$u0020setAsJavaSet$(this, s);
            }

            public <A, B> java.util.Map<A, B> deprecated$u0020mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
                return WrapAsJava.deprecated$u0020mutableMapAsJavaMap$(this, m);
            }

            public <A, B> Dictionary<A, B> deprecated$u0020asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
                return WrapAsJava.deprecated$u0020asJavaDictionary$(this, m);
            }

            public <A, B> java.util.Map<A, B> deprecated$u0020mapAsJavaMap(Map<A, B> m) {
                return WrapAsJava.deprecated$u0020mapAsJavaMap$(this, m);
            }

            public <A, B> ConcurrentMap<A, B> deprecated$u0020mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
                return WrapAsJava.deprecated$u0020mapAsJavaConcurrentMap$(this, m);
            }

            public <A> java.util.Iterator<A> asJavaIterator(Iterator<A> it) {
                return LowPriorityWrapAsJava.asJavaIterator$(this, it);
            }

            public <A> Enumeration<A> asJavaEnumeration(Iterator<A> it) {
                return LowPriorityWrapAsJava.asJavaEnumeration$(this, it);
            }

            public <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> i) {
                return LowPriorityWrapAsJava.asJavaIterable$(this, i);
            }

            public <A> Collection<A> asJavaCollection(Iterable<A> it) {
                return LowPriorityWrapAsJava.asJavaCollection$(this, it);
            }

            public <A> List<A> bufferAsJavaList(Buffer<A> b) {
                return LowPriorityWrapAsJava.bufferAsJavaList$(this, b);
            }

            public <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
                return LowPriorityWrapAsJava.mutableSeqAsJavaList$(this, seq);
            }

            public <A> List<A> seqAsJavaList(Seq<A> seq) {
                return LowPriorityWrapAsJava.seqAsJavaList$(this, seq);
            }

            public <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
                return LowPriorityWrapAsJava.mutableSetAsJavaSet$(this, s);
            }

            public <A> java.util.Set<A> setAsJavaSet(Set<A> s) {
                return LowPriorityWrapAsJava.setAsJavaSet$(this, s);
            }

            public <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
                return LowPriorityWrapAsJava.mutableMapAsJavaMap$(this, m);
            }

            public <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
                return LowPriorityWrapAsJava.asJavaDictionary$(this, m);
            }

            public <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> m) {
                return LowPriorityWrapAsJava.mapAsJavaMap$(this, m);
            }

            public <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
                return LowPriorityWrapAsJava.mapAsJavaConcurrentMap$(this, m);
            }
            {
                LowPriorityWrapAsJava.$init$(this);
                WrapAsJava.$init$(this);
                LowPriorityWrapAsScala.$init$(this);
                WrapAsScala.$init$(this);
            }
        };
    }
}

