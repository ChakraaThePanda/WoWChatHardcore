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
import scala.collection.JavaConversions$;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0015:Qa\u0001\u0003\t\u0002%1Qa\u0003\u0003\t\u00021AQAG\u0001\u0005\u0002m\tqBS1wC\u000e{gN^3sg&|gn\u001d\u0006\u0003\u000b\u0019\t!bY8mY\u0016\u001cG/[8o\u0015\u00059\u0011!B:dC2\f7\u0001\u0001\t\u0003\u0015\u0005i\u0011\u0001\u0002\u0002\u0010\u0015\u00064\u0018mQ8om\u0016\u00148/[8ogN!\u0011!D\t\u0018!\tqq\"D\u0001\u0007\u0013\t\u0001bA\u0001\u0004B]f\u0014VM\u001a\t\u0003%Ui\u0011a\u0005\u0006\u0003)\u0011\tqaY8om\u0016\u0014H/\u0003\u0002\u0017'\tYqK]1q\u0003N\u001c6-\u00197b!\t\u0011\u0002$\u0003\u0002\u001a'\tQqK]1q\u0003NT\u0015M^1\u0002\rqJg.\u001b;?)\u0005I\u0001\u0006B\u0001\u001eA\t\u0002\"A\u0004\u0010\n\u0005}1!A\u00033faJ,7-\u0019;fI\u0006\n\u0011%\u0001\nvg\u0016\u0004#*\u0019<b\u0007>tg/\u001a:uKJ\u001c\u0018%A\u0012\u0002\rIr\u0013G\r\u00181Q\u0011\u0001Q\u0004\t\u0012")
public final class JavaConversions {
    public static <A, B> ConcurrentMap<A, B> deprecated$u0020mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> map) {
        return JavaConversions$.MODULE$.deprecated$u0020mapAsJavaConcurrentMap(map);
    }

    public static <A, B> java.util.Map<A, B> deprecated$u0020mapAsJavaMap(Map<A, B> map) {
        return JavaConversions$.MODULE$.deprecated$u0020mapAsJavaMap(map);
    }

    public static <A, B> Dictionary<A, B> deprecated$u0020asJavaDictionary(scala.collection.mutable.Map<A, B> map) {
        return JavaConversions$.MODULE$.deprecated$u0020asJavaDictionary(map);
    }

    public static <A, B> java.util.Map<A, B> deprecated$u0020mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> map) {
        return JavaConversions$.MODULE$.deprecated$u0020mutableMapAsJavaMap(map);
    }

    public static <A> java.util.Set<A> deprecated$u0020setAsJavaSet(Set<A> set) {
        return JavaConversions$.MODULE$.deprecated$u0020setAsJavaSet(set);
    }

    public static <A> java.util.Set<A> deprecated$u0020mutableSetAsJavaSet(scala.collection.mutable.Set<A> set) {
        return JavaConversions$.MODULE$.deprecated$u0020mutableSetAsJavaSet(set);
    }

    public static <A> List<A> deprecated$u0020seqAsJavaList(Seq<A> seq) {
        return JavaConversions$.MODULE$.deprecated$u0020seqAsJavaList(seq);
    }

    public static <A> List<A> deprecated$u0020mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
        return JavaConversions$.MODULE$.deprecated$u0020mutableSeqAsJavaList(seq);
    }

    public static <A> List<A> deprecated$u0020bufferAsJavaList(Buffer<A> buffer) {
        return JavaConversions$.MODULE$.deprecated$u0020bufferAsJavaList(buffer);
    }

    public static <A> Collection<A> deprecated$u0020asJavaCollection(Iterable<A> iterable) {
        return JavaConversions$.MODULE$.deprecated$u0020asJavaCollection(iterable);
    }

    public static <A> java.lang.Iterable<A> deprecated$u0020asJavaIterable(Iterable<A> iterable) {
        return JavaConversions$.MODULE$.deprecated$u0020asJavaIterable(iterable);
    }

    public static <A> Enumeration<A> deprecated$u0020asJavaEnumeration(Iterator<A> iterator2) {
        return JavaConversions$.MODULE$.deprecated$u0020asJavaEnumeration(iterator2);
    }

    public static <A> java.util.Iterator<A> deprecated$u0020asJavaIterator(Iterator<A> iterator2) {
        return JavaConversions$.MODULE$.deprecated$u0020asJavaIterator(iterator2);
    }

    public static <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> map) {
        return JavaConversions$.MODULE$.mapAsJavaConcurrentMap(map);
    }

    public static <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> map) {
        return JavaConversions$.MODULE$.mapAsJavaMap(map);
    }

    public static <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> map) {
        return JavaConversions$.MODULE$.asJavaDictionary(map);
    }

    public static <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> map) {
        return JavaConversions$.MODULE$.mutableMapAsJavaMap(map);
    }

    public static <A> java.util.Set<A> setAsJavaSet(Set<A> set) {
        return JavaConversions$.MODULE$.setAsJavaSet(set);
    }

    public static <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> set) {
        return JavaConversions$.MODULE$.mutableSetAsJavaSet(set);
    }

    public static <A> List<A> seqAsJavaList(Seq<A> seq) {
        return JavaConversions$.MODULE$.seqAsJavaList(seq);
    }

    public static <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
        return JavaConversions$.MODULE$.mutableSeqAsJavaList(seq);
    }

    public static <A> List<A> bufferAsJavaList(Buffer<A> buffer) {
        return JavaConversions$.MODULE$.bufferAsJavaList(buffer);
    }

    public static <A> Collection<A> asJavaCollection(Iterable<A> iterable) {
        return JavaConversions$.MODULE$.asJavaCollection(iterable);
    }

    public static <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> iterable) {
        return JavaConversions$.MODULE$.asJavaIterable(iterable);
    }

    public static <A> Enumeration<A> asJavaEnumeration(Iterator<A> iterator2) {
        return JavaConversions$.MODULE$.asJavaEnumeration(iterator2);
    }

    public static <A> java.util.Iterator<A> asJavaIterator(Iterator<A> iterator2) {
        return JavaConversions$.MODULE$.asJavaIterator(iterator2);
    }

    public static scala.collection.mutable.Map<String, String> deprecated$u0020propertiesAsScalaMap(Properties properties) {
        return JavaConversions$.MODULE$.deprecated$u0020propertiesAsScalaMap(properties);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020dictionaryAsScalaMap(Dictionary<A, B> dictionary) {
        return JavaConversions$.MODULE$.deprecated$u0020dictionaryAsScalaMap(dictionary);
    }

    public static <A, B> scala.collection.concurrent.Map<A, B> deprecated$u0020mapAsScalaConcurrentMap(ConcurrentMap<A, B> concurrentMap) {
        return JavaConversions$.MODULE$.deprecated$u0020mapAsScalaConcurrentMap(concurrentMap);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020mapAsScalaMap(java.util.Map<A, B> map) {
        return JavaConversions$.MODULE$.deprecated$u0020mapAsScalaMap(map);
    }

    public static <A> scala.collection.mutable.Set<A> deprecated$u0020asScalaSet(java.util.Set<A> set) {
        return JavaConversions$.MODULE$.deprecated$u0020asScalaSet(set);
    }

    public static <A> Buffer<A> deprecated$u0020asScalaBuffer(List<A> list) {
        return JavaConversions$.MODULE$.deprecated$u0020asScalaBuffer(list);
    }

    public static <A> Iterable<A> deprecated$u0020collectionAsScalaIterable(Collection<A> collection) {
        return JavaConversions$.MODULE$.deprecated$u0020collectionAsScalaIterable(collection);
    }

    public static <A> Iterable<A> deprecated$u0020iterableAsScalaIterable(java.lang.Iterable<A> iterable) {
        return JavaConversions$.MODULE$.deprecated$u0020iterableAsScalaIterable(iterable);
    }

    public static <A> Iterator<A> deprecated$u0020enumerationAsScalaIterator(Enumeration<A> enumeration) {
        return JavaConversions$.MODULE$.deprecated$u0020enumerationAsScalaIterator(enumeration);
    }

    public static <A> Iterator<A> deprecated$u0020asScalaIterator(java.util.Iterator<A> iterator2) {
        return JavaConversions$.MODULE$.deprecated$u0020asScalaIterator(iterator2);
    }

    public static scala.collection.mutable.Map<String, String> propertiesAsScalaMap(Properties properties) {
        return JavaConversions$.MODULE$.propertiesAsScalaMap(properties);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> dictionary) {
        return JavaConversions$.MODULE$.dictionaryAsScalaMap(dictionary);
    }

    public static <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> concurrentMap) {
        return JavaConversions$.MODULE$.mapAsScalaConcurrentMap(concurrentMap);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> mapAsScalaMap(java.util.Map<A, B> map) {
        return JavaConversions$.MODULE$.mapAsScalaMap(map);
    }

    public static <A> scala.collection.mutable.Set<A> asScalaSet(java.util.Set<A> set) {
        return JavaConversions$.MODULE$.asScalaSet(set);
    }

    public static <A> Buffer<A> asScalaBuffer(List<A> list) {
        return JavaConversions$.MODULE$.asScalaBuffer(list);
    }

    public static <A> Iterable<A> collectionAsScalaIterable(Collection<A> collection) {
        return JavaConversions$.MODULE$.collectionAsScalaIterable(collection);
    }

    public static <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> iterable) {
        return JavaConversions$.MODULE$.iterableAsScalaIterable(iterable);
    }

    public static <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> enumeration) {
        return JavaConversions$.MODULE$.enumerationAsScalaIterator(enumeration);
    }

    public static <A> Iterator<A> asScalaIterator(java.util.Iterator<A> iterator2) {
        return JavaConversions$.MODULE$.asScalaIterator(iterator2);
    }
}

