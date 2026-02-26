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
import scala.collection.convert.ImplicitConversionsToJava$;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001a9Qa\u0001\u0003\t\u0002-1Q!\u0004\u0003\t\u00029AQAF\u0001\u0005\u0002]\t\u0011$S7qY&\u001c\u0017\u000e^\"p]Z,'o]5p]N$vNS1wC*\u0011QAB\u0001\bG>tg/\u001a:u\u0015\t9\u0001\"\u0001\u0006d_2dWm\u0019;j_:T\u0011!C\u0001\u0006g\u000e\fG.Y\u0002\u0001!\ta\u0011!D\u0001\u0005\u0005eIU\u000e\u001d7jG&$8i\u001c8wKJ\u001c\u0018n\u001c8t)>T\u0015M^1\u0014\u0007\u0005y1\u0003\u0005\u0002\u0011#5\t\u0001\"\u0003\u0002\u0013\u0011\t1\u0011I\\=SK\u001a\u0004\"\u0001\u0004\u000b\n\u0005U!!a\u0004+p\u0015\u00064\u0018-S7qY&\u001c\u0017\u000e^:\u0002\rqJg.\u001b;?)\u0005Y\u0001")
public final class ImplicitConversionsToJava {
    public static <A, B> ConcurrentMap<A, B> map$u0020AsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> map) {
        return ImplicitConversionsToJava$.MODULE$.map$u0020AsJavaConcurrentMap(map);
    }

    public static <A, B> java.util.Map<A, B> map$u0020AsJavaMap(Map<A, B> map) {
        return ImplicitConversionsToJava$.MODULE$.map$u0020AsJavaMap(map);
    }

    public static <A, B> Dictionary<A, B> dictionary$u0020asJava(scala.collection.mutable.Map<A, B> map) {
        return ImplicitConversionsToJava$.MODULE$.dictionary$u0020asJava(map);
    }

    public static <A, B> java.util.Map<A, B> mutableMap$u0020AsJavaMap(scala.collection.mutable.Map<A, B> map) {
        return ImplicitConversionsToJava$.MODULE$.mutableMap$u0020AsJavaMap(map);
    }

    public static <A> java.util.Set<A> set$u0020AsJavaSet(Set<A> set) {
        return ImplicitConversionsToJava$.MODULE$.set$u0020AsJavaSet(set);
    }

    public static <A> java.util.Set<A> mutableSet$u0020AsJavaSet(scala.collection.mutable.Set<A> set) {
        return ImplicitConversionsToJava$.MODULE$.mutableSet$u0020AsJavaSet(set);
    }

    public static <A> List<A> seq$u0020AsJavaList(Seq<A> seq) {
        return ImplicitConversionsToJava$.MODULE$.seq$u0020AsJavaList(seq);
    }

    public static <A> List<A> mutableSeq$u0020AsJavaList(scala.collection.mutable.Seq<A> seq) {
        return ImplicitConversionsToJava$.MODULE$.mutableSeq$u0020AsJavaList(seq);
    }

    public static <A> List<A> buffer$u0020AsJavaList(Buffer<A> buffer) {
        return ImplicitConversionsToJava$.MODULE$.buffer$u0020AsJavaList(buffer);
    }

    public static <A> Collection<A> collection$u0020asJava(Iterable<A> iterable) {
        return ImplicitConversionsToJava$.MODULE$.collection$u0020asJava(iterable);
    }

    public static <A> java.lang.Iterable<A> iterable$u0020asJava(Iterable<A> iterable) {
        return ImplicitConversionsToJava$.MODULE$.iterable$u0020asJava(iterable);
    }

    public static <A> Enumeration<A> enumeration$u0020asJava(Iterator<A> iterator2) {
        return ImplicitConversionsToJava$.MODULE$.enumeration$u0020asJava(iterator2);
    }

    public static <A> java.util.Iterator<A> iterator$u0020asJava(Iterator<A> iterator2) {
        return ImplicitConversionsToJava$.MODULE$.iterator$u0020asJava(iterator2);
    }
}

