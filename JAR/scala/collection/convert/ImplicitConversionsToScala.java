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
import scala.collection.convert.ImplicitConversionsToScala$;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001a9Qa\u0001\u0003\t\u0002-1Q!\u0004\u0003\t\u00029AQAF\u0001\u0005\u0002]\t!$S7qY&\u001c\u0017\u000e^\"p]Z,'o]5p]N$vnU2bY\u0006T!!\u0002\u0004\u0002\u000f\r|gN^3si*\u0011q\u0001C\u0001\u000bG>dG.Z2uS>t'\"A\u0005\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u0011A\"A\u0007\u0002\t\tQ\u0012*\u001c9mS\u000eLGoQ8om\u0016\u00148/[8ogR{7kY1mCN\u0019\u0011aD\n\u0011\u0005A\tR\"\u0001\u0005\n\u0005IA!AB!osJ+g\r\u0005\u0002\r)%\u0011Q\u0003\u0002\u0002\u0011)>\u001c6-\u00197b\u00136\u0004H.[2jiN\fa\u0001P5oSRtD#A\u0006")
public final class ImplicitConversionsToScala {
    public static scala.collection.mutable.Map<String, String> properties$u0020AsScalaMap(Properties properties) {
        return ImplicitConversionsToScala$.MODULE$.properties$u0020AsScalaMap(properties);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> dictionary$u0020AsScalaMap(Dictionary<A, B> dictionary) {
        return ImplicitConversionsToScala$.MODULE$.dictionary$u0020AsScalaMap(dictionary);
    }

    public static <A, B> Map<A, B> map$u0020AsScalaConcurrentMap(ConcurrentMap<A, B> concurrentMap) {
        return ImplicitConversionsToScala$.MODULE$.map$u0020AsScalaConcurrentMap(concurrentMap);
    }

    public static <A, B> scala.collection.mutable.Map<A, B> map$u0020AsScala(java.util.Map<A, B> map) {
        return ImplicitConversionsToScala$.MODULE$.map$u0020AsScala(map);
    }

    public static <A> scala.collection.mutable.Set<A> set$u0020asScala(Set<A> set) {
        return ImplicitConversionsToScala$.MODULE$.set$u0020asScala(set);
    }

    public static <A> Buffer<A> list$u0020asScalaBuffer(List<A> list) {
        return ImplicitConversionsToScala$.MODULE$.list$u0020asScalaBuffer(list);
    }

    public static <A> Iterable<A> collection$u0020AsScalaIterable(Collection<A> collection) {
        return ImplicitConversionsToScala$.MODULE$.collection$u0020AsScalaIterable(collection);
    }

    public static <A> Iterable<A> iterable$u0020AsScalaIterable(java.lang.Iterable<A> iterable) {
        return ImplicitConversionsToScala$.MODULE$.iterable$u0020AsScalaIterable(iterable);
    }

    public static <A> Iterator<A> enumeration$u0020AsScalaIterator(Enumeration<A> enumeration) {
        return ImplicitConversionsToScala$.MODULE$.enumeration$u0020AsScalaIterator(enumeration);
    }

    public static <A> Iterator<A> iterator$u0020asScala(java.util.Iterator<A> iterator2) {
        return ImplicitConversionsToScala$.MODULE$.iterator$u0020asScala(iterator2);
    }
}

