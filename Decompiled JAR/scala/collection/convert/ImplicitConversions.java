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
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.convert.ImplicitConversions$;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001m9Qa\u0001\u0003\t\u0002-1Q!\u0004\u0003\t\u00029AQ!G\u0001\u0005\u0002i\t1#S7qY&\u001c\u0017\u000e^\"p]Z,'o]5p]NT!!\u0002\u0004\u0002\u000f\r|gN^3si*\u0011q\u0001C\u0001\u000bG>dG.Z2uS>t'\"A\u0005\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u0011A\"A\u0007\u0002\t\t\u0019\u0012*\u001c9mS\u000eLGoQ8om\u0016\u00148/[8ogN!\u0011aD\n\u0017!\t\u0001\u0012#D\u0001\t\u0013\t\u0011\u0002B\u0001\u0004B]f\u0014VM\u001a\t\u0003\u0019QI!!\u0006\u0003\u0003!Q{7kY1mC&k\u0007\u000f\\5dSR\u001c\bC\u0001\u0007\u0018\u0013\tABAA\bU_*\u000bg/Y%na2L7-\u001b;t\u0003\u0019a\u0014N\\5u}Q\t1\u0002")
public final class ImplicitConversions {
    public static <A, B> ConcurrentMap<A, B> map$u0020AsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> map) {
        return ImplicitConversions$.MODULE$.map$u0020AsJavaConcurrentMap(map);
    }

    public static <A, B> java.util.Map<A, B> map$u0020AsJavaMap(Map<A, B> map) {
        return ImplicitConversions$.MODULE$.map$u0020AsJavaMap(map);
    }

    public static <A, B> Dictionary<A, B> dictionary$u0020asJava(scala.collection.mutable.Map<A, B> map) {
        return ImplicitConversions$.MODULE$.dictionary$u0020asJava(map);
    }

    public static <A, B> java.util.Map<A, B> mutableMap$u0020AsJavaMap(scala.collection.mutable.Map<A, B> map) {
        return ImplicitConversions$.MODULE$.mutableMap$u0020AsJavaMap(map);
    }

    public static <A> java.util.Set<A> set$u0020AsJavaSet(Set<A> set) {
        return ImplicitConversions$.MODULE$.set$u0020AsJavaSet(set);
    }

    public static <A> java.util.Set<A> mutableSet$u0020AsJavaSet(scala.collection.mutable.Set<A> set) {
        return ImplicitConversions$.MODULE$.mutableSet$u0020AsJavaSet(set);
    }

    public static <A> List<A> seq$u0020AsJavaList(Seq<A> seq) {
        return ImplicitConversions$.MODULE$.seq$u0020AsJavaList(seq);
    }

    public static <A> List<A> mutableSeq$u0020AsJavaList(scala.collection.mutable.Seq<A> seq) {
        return ImplicitConversions$.MODULE$.mutableSeq$u0020AsJavaList(seq);
    }

    public static <A> List<A> buffer$u0020AsJavaList(Buffer<A> buffer) {
        return ImplicitConversions$.MODULE$.buffer$u0020AsJavaList(buffer);
    }

    public static <A> Collection<A> collection$u0020asJava(Iterable<A> iterable) {
        return ImplicitConversions$.MODULE$.collection$u0020asJava(iterable);
    }

    public static <A> java.lang.Iterable<A> iterable$u0020asJava(Iterable<A> iterable) {
        return ImplicitConversions$.MODULE$.iterable$u0020asJava(iterable);
    }

    public static <A> Enumeration<A> enumeration$u0020asJava(Iterator<A> iterator2) {
        return ImplicitConversions$.MODULE$.enumeration$u0020asJava(iterator2);
    }

    public static <A> java.util.Iterator<A> iterator$u0020asJava(Iterator<A> iterator2) {
        return ImplicitConversions$.MODULE$.iterator$u0020asJava(iterator2);
    }

    public static scala.collection.mutable.Map<String, String> properties$u0020AsScalaMap(Properties properties) {
        return ImplicitConversions$.MODULE$.properties$u0020AsScalaMap(properties);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> dictionary$u0020AsScalaMap(Dictionary<A, B> dictionary) {
        return ImplicitConversions$.MODULE$.dictionary$u0020AsScalaMap(dictionary);
    }

    public static <A, B> scala.collection.concurrent.Map<A, B> map$u0020AsScalaConcurrentMap(ConcurrentMap<A, B> concurrentMap) {
        return ImplicitConversions$.MODULE$.map$u0020AsScalaConcurrentMap(concurrentMap);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> map$u0020AsScala(java.util.Map<A, B> map) {
        return ImplicitConversions$.MODULE$.map$u0020AsScala(map);
    }

    public static <A> scala.collection.mutable.Set<A> set$u0020asScala(java.util.Set<A> set) {
        return ImplicitConversions$.MODULE$.set$u0020asScala(set);
    }

    public static <A> Buffer<A> list$u0020asScalaBuffer(List<A> list) {
        return ImplicitConversions$.MODULE$.list$u0020asScalaBuffer(list);
    }

    public static <A> Iterable<A> collection$u0020AsScalaIterable(Collection<A> collection) {
        return ImplicitConversions$.MODULE$.collection$u0020AsScalaIterable(collection);
    }

    public static <A> Iterable<A> iterable$u0020AsScalaIterable(java.lang.Iterable<A> iterable) {
        return ImplicitConversions$.MODULE$.iterable$u0020AsScalaIterable(iterable);
    }

    public static <A> Iterator<A> enumeration$u0020AsScalaIterator(Enumeration<A> enumeration) {
        return ImplicitConversions$.MODULE$.enumeration$u0020AsScalaIterator(enumeration);
    }

    public static <A> Iterator<A> iterator$u0020asScala(java.util.Iterator<A> iterator2) {
        return ImplicitConversions$.MODULE$.iterator$u0020asScala(iterator2);
    }
}

