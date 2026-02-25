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
import scala.collection.convert.Wrappers;
import scala.collection.convert.Wrappers$;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005ueaB\b\u0011!\u0003\r\ta\u0006\u0005\u00069\u0001!\t!\b\u0005\u0006C\u0001!\tA\t\u0005\u0006y\u0001!\t!\u0010\u0005\u0006\r\u0002!\ta\u0012\u0005\u0006)\u0002!\t!\u0016\u0005\u0006=\u0002!\ta\u0018\u0005\u0006]\u0002!\ta\u001c\u0005\u0006s\u0002!\tA\u001f\u0005\b\u0003\u000b\u0001A\u0011AA\u0004\u0011\u001d\tY\u0002\u0001C\u0001\u0003;Aq!!\f\u0001\t\u0003\ty\u0003C\u0004\u0002L\u0001!\t!!\u0014\t\u000f\u0005\r\u0004\u0001\"\u0001\u0002f!9\u0011\u0011\u0010\u0001\u0005\u0002\u0005m$\u0001E!t\u0015\u00064\u0018mQ8om\u0016\u0014H/\u001a:t\u0015\t\t\"#A\u0004d_:4XM\u001d;\u000b\u0005M!\u0012AC2pY2,7\r^5p]*\tQ#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001A\u0002CA\r\u001b\u001b\u0005!\u0012BA\u000e\u0015\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012A\b\t\u00033}I!\u0001\t\u000b\u0003\tUs\u0017\u000e^\u0001\u000fCNT\u0015M^1Ji\u0016\u0014\u0018\r^8s+\t\u0019c\u0006\u0006\u0002%oA\u0019QE\u000b\u0017\u000e\u0003\u0019R!a\n\u0015\u0002\tU$\u0018\u000e\u001c\u0006\u0002S\u0005!!.\u0019<b\u0013\tYcE\u0001\u0005Ji\u0016\u0014\u0018\r^8s!\tic\u0006\u0004\u0001\u0005\u000b=\u0012!\u0019\u0001\u0019\u0003\u0003\u0005\u000b\"!\r\u001b\u0011\u0005e\u0011\u0014BA\u001a\u0015\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!G\u001b\n\u0005Y\"\"aA!os\")\u0001H\u0001a\u0001s\u0005\t\u0011\u000eE\u0002;w1j\u0011AE\u0005\u0003WI\t\u0011#Y:KCZ\fWI\\;nKJ\fG/[8o+\tq4\t\u0006\u0002@\tB\u0019Q\u0005\u0011\"\n\u0005\u00053#aC#ok6,'/\u0019;j_:\u0004\"!L\"\u0005\u000b=\u001a!\u0019\u0001\u0019\t\u000ba\u001a\u0001\u0019A#\u0011\u0007iZ$)\u0001\bbg*\u000bg/Y%uKJ\f'\r\\3\u0016\u0005!\u0003FCA%R!\rQUjT\u0007\u0002\u0017*\u0011A\nK\u0001\u0005Y\u0006tw-\u0003\u0002O\u0017\nA\u0011\n^3sC\ndW\r\u0005\u0002.!\u0012)q\u0006\u0002b\u0001a!)\u0001\b\u0002a\u0001%B\u0019!hU(\n\u00059\u0013\u0012\u0001E1t\u0015\u00064\u0018mQ8mY\u0016\u001cG/[8o+\t16\f\u0006\u0002X9B\u0019Q\u0005\u0017.\n\u0005e3#AC\"pY2,7\r^5p]B\u0011Qf\u0017\u0003\u0006_\u0015\u0011\r\u0001\r\u0005\u0006q\u0015\u0001\r!\u0018\t\u0004uMS\u0016\u0001\u00052vM\u001a,'/Q:KCZ\fG*[:u+\t\u0001W\r\u0006\u0002bMB\u0019QE\u00193\n\u0005\r4#\u0001\u0002'jgR\u0004\"!L3\u0005\u000b=2!\u0019\u0001\u0019\t\u000b\u001d4\u0001\u0019\u00015\u0002\u0003\t\u00042!\u001b7e\u001b\u0005Q'BA6\u0013\u0003\u001diW\u000f^1cY\u0016L!!\u001c6\u0003\r\t+hMZ3s\u0003QiW\u000f^1cY\u0016\u001cV-]!t\u0015\u00064\u0018\rT5tiV\u0011\u0001o\u001d\u000b\u0003cR\u00042!\n2s!\ti3\u000fB\u00030\u000f\t\u0007\u0001\u0007C\u0003v\u000f\u0001\u0007a/A\u0001t!\rIwO]\u0005\u0003q*\u00141aU3r\u00035\u0019X-]!t\u0015\u00064\u0018\rT5tiV\u00111P \u000b\u0003y~\u00042!\n2~!\tic\u0010B\u00030\u0011\t\u0007\u0001\u0007\u0003\u0004v\u0011\u0001\u0007\u0011\u0011\u0001\t\u0005u\u0005\rQ0\u0003\u0002y%\u0005\u0019R.\u001e;bE2,7+\u001a;Bg*\u000bg/Y*fiV!\u0011\u0011BA\n)\u0011\tY!!\u0006\u0011\u000b\u0015\ni!!\u0005\n\u0007\u0005=aEA\u0002TKR\u00042!LA\n\t\u0015y\u0013B1\u00011\u0011\u0019)\u0018\u00021\u0001\u0002\u0018A)\u0011.!\u0007\u0002\u0012%\u0019\u0011q\u00026\u0002\u0019M,G/Q:KCZ\f7+\u001a;\u0016\t\u0005}\u0011Q\u0005\u000b\u0005\u0003C\t9\u0003E\u0003&\u0003\u001b\t\u0019\u0003E\u0002.\u0003K!Qa\f\u0006C\u0002ABa!\u001e\u0006A\u0002\u0005%\u0002#\u0002\u001e\u0002,\u0005\r\u0012bAA\b%\u0005\u0019R.\u001e;bE2,W*\u00199Bg*\u000bg/Y'baV1\u0011\u0011GA\u001e\u0003\u007f!B!a\r\u0002DA9Q%!\u000e\u0002:\u0005u\u0012bAA\u001cM\t\u0019Q*\u00199\u0011\u00075\nY\u0004B\u00030\u0017\t\u0007\u0001\u0007E\u0002.\u0003\u007f!a!!\u0011\f\u0005\u0004\u0001$!\u0001\"\t\u000f\u0005\u00153\u00021\u0001\u0002H\u0005\tQ\u000eE\u0004j\u0003\u0013\nI$!\u0010\n\u0007\u0005]\".\u0001\tbg*\u000bg/\u0019#jGRLwN\\1ssV1\u0011qJA-\u0003;\"B!!\u0015\u0002`A9Q%a\u0015\u0002X\u0005m\u0013bAA+M\tQA)[2uS>t\u0017M]=\u0011\u00075\nI\u0006B\u00030\u0019\t\u0007\u0001\u0007E\u0002.\u0003;\"a!!\u0011\r\u0005\u0004\u0001\u0004bBA#\u0019\u0001\u0007\u0011\u0011\r\t\bS\u0006%\u0013qKA.\u00031i\u0017\r]!t\u0015\u00064\u0018-T1q+\u0019\t9'!\u001c\u0002rQ!\u0011\u0011NA:!\u001d)\u0013QGA6\u0003_\u00022!LA7\t\u0015ySB1\u00011!\ri\u0013\u0011\u000f\u0003\u0007\u0003\u0003j!\u0019\u0001\u0019\t\u000f\u0005\u0015S\u00021\u0001\u0002vA9!(a\u001e\u0002l\u0005=\u0014bAA\u001c%\u00051R.\u00199Bg*\u000bg/Y\"p]\u000e,(O]3oi6\u000b\u0007/\u0006\u0004\u0002~\u00055\u0015\u0011\u0013\u000b\u0005\u0003\u007f\n\u0019\n\u0005\u0005\u0002\u0002\u0006\u001d\u00151RAH\u001b\t\t\u0019IC\u0002\u0002\u0006\u001a\n!bY8oGV\u0014(/\u001a8u\u0013\u0011\tI)a!\u0003\u001b\r{gnY;se\u0016tG/T1q!\ri\u0013Q\u0012\u0003\u0006_9\u0011\r\u0001\r\t\u0004[\u0005EEABA!\u001d\t\u0007\u0001\u0007C\u0004\u0002F9\u0001\r!!&\u0011\u0011\u0005]\u00151TAF\u0003\u001fk!!!'\u000b\u0007\u0005\u0015%#\u0003\u0003\u00028\u0005e\u0005")
public interface AsJavaConverters {
    public static /* synthetic */ java.util.Iterator asJavaIterator$(AsJavaConverters $this, Iterator i) {
        return $this.asJavaIterator(i);
    }

    default public <A> java.util.Iterator<A> asJavaIterator(Iterator<A> i) {
        java.util.Iterator<A> iterator2 = i == null ? null : (i instanceof Wrappers.JIteratorWrapper && ((Wrappers.JIteratorWrapper)i).scala$collection$convert$Wrappers$JIteratorWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JIteratorWrapper)i).underlying() : new Wrappers.IteratorWrapper<A>(Wrappers$.MODULE$, i));
        return iterator2;
    }

    public static /* synthetic */ Enumeration asJavaEnumeration$(AsJavaConverters $this, Iterator i) {
        return $this.asJavaEnumeration(i);
    }

    default public <A> Enumeration<A> asJavaEnumeration(Iterator<A> i) {
        Enumeration<A> enumeration = i == null ? null : (i instanceof Wrappers.JEnumerationWrapper && ((Wrappers.JEnumerationWrapper)i).scala$collection$convert$Wrappers$JEnumerationWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JEnumerationWrapper)i).underlying() : new Wrappers.IteratorWrapper<A>(Wrappers$.MODULE$, i));
        return enumeration;
    }

    public static /* synthetic */ java.lang.Iterable asJavaIterable$(AsJavaConverters $this, Iterable i) {
        return $this.asJavaIterable(i);
    }

    default public <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> i) {
        java.lang.Iterable<A> iterable = i == null ? null : (i instanceof Wrappers.JIterableWrapper && ((Wrappers.JIterableWrapper)i).scala$collection$convert$Wrappers$JIterableWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JIterableWrapper)i).underlying() : new Wrappers.IterableWrapper<A>(Wrappers$.MODULE$, i));
        return iterable;
    }

    public static /* synthetic */ Collection asJavaCollection$(AsJavaConverters $this, Iterable i) {
        return $this.asJavaCollection(i);
    }

    default public <A> Collection<A> asJavaCollection(Iterable<A> i) {
        Collection<A> collection = i == null ? null : (i instanceof Wrappers.JCollectionWrapper && ((Wrappers.JCollectionWrapper)i).scala$collection$convert$Wrappers$JCollectionWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JCollectionWrapper)i).underlying() : new Wrappers.IterableWrapper<A>(Wrappers$.MODULE$, i));
        return collection;
    }

    public static /* synthetic */ List bufferAsJavaList$(AsJavaConverters $this, Buffer b) {
        return $this.bufferAsJavaList(b);
    }

    default public <A> List<A> bufferAsJavaList(Buffer<A> b) {
        List<A> list = b == null ? null : (b instanceof Wrappers.JListWrapper && ((Wrappers.JListWrapper)b).scala$collection$convert$Wrappers$JListWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JListWrapper)b).underlying() : new Wrappers.MutableBufferWrapper<A>(Wrappers$.MODULE$, b));
        return list;
    }

    public static /* synthetic */ List mutableSeqAsJavaList$(AsJavaConverters $this, scala.collection.mutable.Seq s) {
        return $this.mutableSeqAsJavaList(s);
    }

    default public <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> s) {
        List<A> list = s == null ? null : (s instanceof Wrappers.JListWrapper && ((Wrappers.JListWrapper)s).scala$collection$convert$Wrappers$JListWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JListWrapper)s).underlying() : new Wrappers.MutableSeqWrapper<A>(Wrappers$.MODULE$, s));
        return list;
    }

    public static /* synthetic */ List seqAsJavaList$(AsJavaConverters $this, Seq s) {
        return $this.seqAsJavaList(s);
    }

    default public <A> List<A> seqAsJavaList(Seq<A> s) {
        List<A> list = s == null ? null : (s instanceof Wrappers.JListWrapper && ((Wrappers.JListWrapper)s).scala$collection$convert$Wrappers$JListWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JListWrapper)s).underlying() : new Wrappers.SeqWrapper<A>(Wrappers$.MODULE$, s));
        return list;
    }

    public static /* synthetic */ java.util.Set mutableSetAsJavaSet$(AsJavaConverters $this, scala.collection.mutable.Set s) {
        return $this.mutableSetAsJavaSet(s);
    }

    default public <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
        java.util.Set<A> set = s == null ? null : (s instanceof Wrappers.JSetWrapper && ((Wrappers.JSetWrapper)s).scala$collection$convert$Wrappers$JSetWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JSetWrapper)s).underlying() : new Wrappers.MutableSetWrapper<A>((Wrappers)Wrappers$.MODULE$, s));
        return set;
    }

    public static /* synthetic */ java.util.Set setAsJavaSet$(AsJavaConverters $this, Set s) {
        return $this.setAsJavaSet(s);
    }

    default public <A> java.util.Set<A> setAsJavaSet(Set<A> s) {
        java.util.Set<A> set = s == null ? null : (s instanceof Wrappers.JSetWrapper && ((Wrappers.JSetWrapper)s).scala$collection$convert$Wrappers$JSetWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JSetWrapper)s).underlying() : new Wrappers.SetWrapper<A>(Wrappers$.MODULE$, s));
        return set;
    }

    public static /* synthetic */ java.util.Map mutableMapAsJavaMap$(AsJavaConverters $this, scala.collection.mutable.Map m) {
        return $this.mutableMapAsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
        java.util.Map<A, B> map = m == null ? null : (m instanceof Wrappers.JMapWrapper && ((Wrappers.JMapWrapper)m).scala$collection$convert$Wrappers$JMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JMapWrapper)m).underlying() : new Wrappers.MutableMapWrapper<A, B>((Wrappers)Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ Dictionary asJavaDictionary$(AsJavaConverters $this, scala.collection.mutable.Map m) {
        return $this.asJavaDictionary(m);
    }

    default public <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
        Dictionary dictionary = m == null ? null : (m instanceof Wrappers.JDictionaryWrapper && ((Wrappers.JDictionaryWrapper)m).scala$collection$convert$Wrappers$JDictionaryWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JDictionaryWrapper)m).underlying() : new Wrappers.DictionaryWrapper<A, B>(Wrappers$.MODULE$, m));
        return dictionary;
    }

    public static /* synthetic */ java.util.Map mapAsJavaMap$(AsJavaConverters $this, Map m) {
        return $this.mapAsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> m) {
        java.util.Map<A, B> map = m == null ? null : (m instanceof Wrappers.JMapWrapper && ((Wrappers.JMapWrapper)m).scala$collection$convert$Wrappers$JMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JMapWrapper)m).underlying() : new Wrappers.MapWrapper<A, B>(Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ ConcurrentMap mapAsJavaConcurrentMap$(AsJavaConverters $this, scala.collection.concurrent.Map m) {
        return $this.mapAsJavaConcurrentMap(m);
    }

    default public <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        java.util.Map<Object, Object> map = m == null ? null : (m instanceof Wrappers.JConcurrentMapWrapper && ((Wrappers.JConcurrentMapWrapper)m).scala$collection$convert$Wrappers$JConcurrentMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JConcurrentMapWrapper)m).underlying() : new Wrappers.ConcurrentMapWrapper<A, B>((Wrappers)Wrappers$.MODULE$, m));
        return map;
    }

    public static void $init$(AsJavaConverters $this) {
    }
}

