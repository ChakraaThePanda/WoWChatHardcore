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
import scala.collection.JavaConverters$;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.convert.Decorators;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001q9Qa\u0001\u0003\t\u0002%1Qa\u0003\u0003\t\u00021AQAG\u0001\u0005\u0002m\taBS1wC\u000e{gN^3si\u0016\u00148O\u0003\u0002\u0006\r\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003\u001d\tQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002\u000b\u00035\tAA\u0001\bKCZ\f7i\u001c8wKJ$XM]:\u0014\t\u0005i\u0011c\u0006\t\u0003\u001d=i\u0011AB\u0005\u0003!\u0019\u0011a!\u00118z%\u00164\u0007C\u0001\n\u0016\u001b\u0005\u0019\"B\u0001\u000b\u0005\u0003\u001d\u0019wN\u001c<feRL!AF\n\u0003\u001d\u0011+7m\u001c:bi\u0016\f5OS1wCB\u0011!\u0003G\u0005\u00033M\u0011q\u0002R3d_J\fG/Z!t'\u000e\fG.Y\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003%\u0001")
public final class JavaConverters {
    public static Decorators.AsScala<scala.collection.mutable.Map<String, String>> propertiesAsScalaMapConverter(Properties properties) {
        return JavaConverters$.MODULE$.propertiesAsScalaMapConverter(properties);
    }

    public static <A, B> Decorators.AsScala<scala.collection.mutable.Map<A, B>> dictionaryAsScalaMapConverter(Dictionary<A, B> dictionary) {
        return JavaConverters$.MODULE$.dictionaryAsScalaMapConverter(dictionary);
    }

    public static <A, B> Decorators.AsScala<scala.collection.concurrent.Map<A, B>> mapAsScalaConcurrentMapConverter(ConcurrentMap<A, B> concurrentMap) {
        return JavaConverters$.MODULE$.mapAsScalaConcurrentMapConverter(concurrentMap);
    }

    public static <A, B> Decorators.AsScala<scala.collection.mutable.Map<A, B>> mapAsScalaMapConverter(java.util.Map<A, B> map) {
        return JavaConverters$.MODULE$.mapAsScalaMapConverter(map);
    }

    public static <A> Decorators.AsScala<scala.collection.mutable.Set<A>> asScalaSetConverter(java.util.Set<A> set) {
        return JavaConverters$.MODULE$.asScalaSetConverter(set);
    }

    public static <A> Decorators.AsScala<Buffer<A>> asScalaBufferConverter(List<A> list) {
        return JavaConverters$.MODULE$.asScalaBufferConverter(list);
    }

    public static <A> Decorators.AsScala<Iterable<A>> collectionAsScalaIterableConverter(Collection<A> collection) {
        return JavaConverters$.MODULE$.collectionAsScalaIterableConverter(collection);
    }

    public static <A> Decorators.AsScala<Iterable<A>> iterableAsScalaIterableConverter(java.lang.Iterable<A> iterable) {
        return JavaConverters$.MODULE$.iterableAsScalaIterableConverter(iterable);
    }

    public static <A> Decorators.AsScala<Iterator<A>> enumerationAsScalaIteratorConverter(Enumeration<A> enumeration) {
        return JavaConverters$.MODULE$.enumerationAsScalaIteratorConverter(enumeration);
    }

    public static <A> Decorators.AsScala<Iterator<A>> asScalaIteratorConverter(java.util.Iterator<A> iterator2) {
        return JavaConverters$.MODULE$.asScalaIteratorConverter(iterator2);
    }

    public static scala.collection.mutable.Map<String, String> propertiesAsScalaMap(Properties properties) {
        return JavaConverters$.MODULE$.propertiesAsScalaMap(properties);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> dictionary) {
        return JavaConverters$.MODULE$.dictionaryAsScalaMap(dictionary);
    }

    public static <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> concurrentMap) {
        return JavaConverters$.MODULE$.mapAsScalaConcurrentMap(concurrentMap);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> map) {
        return JavaConverters$.MODULE$.mapAsScalaMap(map);
    }

    public static <A> scala.collection.mutable.Set<A> asScalaSet(java.util.Set<A> set) {
        return JavaConverters$.MODULE$.asScalaSet(set);
    }

    public static <A> Buffer<A> asScalaBuffer(List<A> list) {
        return JavaConverters$.MODULE$.asScalaBuffer(list);
    }

    public static <A> Iterable<A> collectionAsScalaIterable(Collection<A> collection) {
        return JavaConverters$.MODULE$.collectionAsScalaIterable(collection);
    }

    public static <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> iterable) {
        return JavaConverters$.MODULE$.iterableAsScalaIterable(iterable);
    }

    public static <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> enumeration) {
        return JavaConverters$.MODULE$.enumerationAsScalaIterator(enumeration);
    }

    public static <A> Iterator<A> asScalaIterator(java.util.Iterator<A> iterator2) {
        return JavaConverters$.MODULE$.asScalaIterator(iterator2);
    }

    public static <A, B> Decorators.AsJava<ConcurrentMap<A, B>> mapAsJavaConcurrentMapConverter(scala.collection.concurrent.Map<A, B> map) {
        return JavaConverters$.MODULE$.mapAsJavaConcurrentMapConverter(map);
    }

    public static <A, B> Decorators.AsJava<java.util.Map<A, B>> mapAsJavaMapConverter(Map<A, B> map) {
        return JavaConverters$.MODULE$.mapAsJavaMapConverter(map);
    }

    public static <A, B> Decorators.AsJavaDictionary<A, B> asJavaDictionaryConverter(scala.collection.mutable.Map<A, B> map) {
        return JavaConverters$.MODULE$.asJavaDictionaryConverter(map);
    }

    public static <A, B> Decorators.AsJava<java.util.Map<A, B>> mutableMapAsJavaMapConverter(scala.collection.mutable.Map<A, B> map) {
        return JavaConverters$.MODULE$.mutableMapAsJavaMapConverter(map);
    }

    public static <A> Decorators.AsJava<java.util.Set<A>> setAsJavaSetConverter(Set<A> set) {
        return JavaConverters$.MODULE$.setAsJavaSetConverter(set);
    }

    public static <A> Decorators.AsJava<java.util.Set<A>> mutableSetAsJavaSetConverter(scala.collection.mutable.Set<A> set) {
        return JavaConverters$.MODULE$.mutableSetAsJavaSetConverter(set);
    }

    public static <A> Decorators.AsJava<List<A>> seqAsJavaListConverter(Seq<A> seq) {
        return JavaConverters$.MODULE$.seqAsJavaListConverter(seq);
    }

    public static <A> Decorators.AsJava<List<A>> mutableSeqAsJavaListConverter(scala.collection.mutable.Seq<A> seq) {
        return JavaConverters$.MODULE$.mutableSeqAsJavaListConverter(seq);
    }

    public static <A> Decorators.AsJava<List<A>> bufferAsJavaListConverter(Buffer<A> buffer) {
        return JavaConverters$.MODULE$.bufferAsJavaListConverter(buffer);
    }

    public static <A> Decorators.AsJavaCollection<A> asJavaCollectionConverter(Iterable<A> iterable) {
        return JavaConverters$.MODULE$.asJavaCollectionConverter(iterable);
    }

    public static <A> Decorators.AsJava<java.lang.Iterable<A>> asJavaIterableConverter(Iterable<A> iterable) {
        return JavaConverters$.MODULE$.asJavaIterableConverter(iterable);
    }

    public static <A> Decorators.AsJavaEnumeration<A> asJavaEnumerationConverter(Iterator<A> iterator2) {
        return JavaConverters$.MODULE$.asJavaEnumerationConverter(iterator2);
    }

    public static <A> Decorators.AsJava<java.util.Iterator<A>> asJavaIteratorConverter(Iterator<A> iterator2) {
        return JavaConverters$.MODULE$.asJavaIteratorConverter(iterator2);
    }

    public static <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> map) {
        return JavaConverters$.MODULE$.mapAsJavaConcurrentMap(map);
    }

    public static <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> map) {
        return JavaConverters$.MODULE$.mapAsJavaMap(map);
    }

    public static <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> map) {
        return JavaConverters$.MODULE$.asJavaDictionary(map);
    }

    public static <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> map) {
        return JavaConverters$.MODULE$.mutableMapAsJavaMap(map);
    }

    public static <A> java.util.Set<A> setAsJavaSet(Set<A> set) {
        return JavaConverters$.MODULE$.setAsJavaSet(set);
    }

    public static <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> set) {
        return JavaConverters$.MODULE$.mutableSetAsJavaSet(set);
    }

    public static <A> List<A> seqAsJavaList(Seq<A> seq) {
        return JavaConverters$.MODULE$.seqAsJavaList(seq);
    }

    public static <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
        return JavaConverters$.MODULE$.mutableSeqAsJavaList(seq);
    }

    public static <A> List<A> bufferAsJavaList(Buffer<A> buffer) {
        return JavaConverters$.MODULE$.bufferAsJavaList(buffer);
    }

    public static <A> Collection<A> asJavaCollection(Iterable<A> iterable) {
        return JavaConverters$.MODULE$.asJavaCollection(iterable);
    }

    public static <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> iterable) {
        return JavaConverters$.MODULE$.asJavaIterable(iterable);
    }

    public static <A> Enumeration<A> asJavaEnumeration(Iterator<A> iterator2) {
        return JavaConverters$.MODULE$.asJavaEnumeration(iterator2);
    }

    public static <A> java.util.Iterator<A> asJavaIterator(Iterator<A> iterator2) {
        return JavaConverters$.MODULE$.asJavaIterator(iterator2);
    }
}

