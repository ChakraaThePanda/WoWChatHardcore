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

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005f\u0001C\b\u0011!\u0003\r\t\u0001\u0005\f\t\u000bm\u0001A\u0011A\u000f\t\u000b\u0005\u0002A1\u0001\u0012\t\u000bq\u0002A1A\u001f\t\u000b\u0019\u0003A1A$\t\u000bU\u0003A1\u0001,\t\u000b}\u0003A1\u00011\t\u000b=\u0004A1\u00019\t\u000bi\u0004A1A>\t\u000f\u0005\u001d\u0001\u0001b\u0001\u0002\n!9\u0011q\u0004\u0001\u0005\u0004\u0005\u0005\u0002bBA\u0019\u0001\u0011\r\u00111\u0007\u0005\b\u0003\u001f\u0002A1AA)\u0011\u001d\t9\u0007\u0001C\u0002\u0003SBq!! \u0001\t\u0007\tyHA\u000bM_^\u0004&/[8sSRLxK]1q\u0003NT\u0015M^1\u000b\u0005E\u0011\u0012aB2p]Z,'\u000f\u001e\u0006\u0003'Q\t!bY8mY\u0016\u001cG/[8o\u0015\u0005)\u0012!B:dC2\f7C\u0001\u0001\u0018!\tA\u0012$D\u0001\u0015\u0013\tQBC\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0004\u0001Q\ta\u0004\u0005\u0002\u0019?%\u0011\u0001\u0005\u0006\u0002\u0005+:LG/\u0001\bbg*\u000bg/Y%uKJ\fGo\u001c:\u0016\u0005\rrCC\u0001\u00138!\r)#\u0006L\u0007\u0002M)\u0011q\u0005K\u0001\u0005kRLGNC\u0001*\u0003\u0011Q\u0017M^1\n\u0005-2#\u0001C%uKJ\fGo\u001c:\u0011\u00055rC\u0002\u0001\u0003\u0006_\t\u0011\r\u0001\r\u0002\u0002\u0003F\u0011\u0011\u0007\u000e\t\u00031IJ!a\r\u000b\u0003\u000f9{G\u000f[5oOB\u0011\u0001$N\u0005\u0003mQ\u00111!\u00118z\u0011\u0015A$\u00011\u0001:\u0003\tIG\u000fE\u0002;w1j\u0011AE\u0005\u0003WI\t\u0011#Y:KCZ\fWI\\;nKJ\fG/[8o+\tq4\t\u0006\u0002@\tB\u0019Q\u0005\u0011\"\n\u0005\u00053#aC#ok6,'/\u0019;j_:\u0004\"!L\"\u0005\u000b=\u001a!\u0019\u0001\u0019\t\u000ba\u001a\u0001\u0019A#\u0011\u0007iZ$)\u0001\bbg*\u000bg/Y%uKJ\f'\r\\3\u0016\u0005!\u0003FCA%R!\rQUjT\u0007\u0002\u0017*\u0011A\nK\u0001\u0005Y\u0006tw-\u0003\u0002O\u0017\nA\u0011\n^3sC\ndW\r\u0005\u0002.!\u0012)q\u0006\u0002b\u0001a!)!\u000b\u0002a\u0001'\u0006\t\u0011\u000eE\u0002;)>K!A\u0014\n\u0002!\u0005\u001c(*\u0019<b\u0007>dG.Z2uS>tWCA,])\tAV\fE\u0002&3nK!A\u0017\u0014\u0003\u0015\r{G\u000e\\3di&|g\u000e\u0005\u0002.9\u0012)q&\u0002b\u0001a!)\u0001(\u0002a\u0001=B\u0019!\bV.\u0002!\t,hMZ3s\u0003NT\u0015M^1MSN$XCA1g)\t\u0011w\rE\u0002&G\u0016L!\u0001\u001a\u0014\u0003\t1K7\u000f\u001e\t\u0003[\u0019$Qa\f\u0004C\u0002ABQ\u0001\u001b\u0004A\u0002%\f\u0011A\u0019\t\u0004U6,W\"A6\u000b\u00051\u0014\u0012aB7vi\u0006\u0014G.Z\u0005\u0003].\u0014aAQ;gM\u0016\u0014\u0018\u0001F7vi\u0006\u0014G.Z*fc\u0006\u001b(*\u0019<b\u0019&\u001cH/\u0006\u0002riR\u0011!/\u001e\t\u0004K\r\u001c\bCA\u0017u\t\u0015ysA1\u00011\u0011\u00151x\u00011\u0001x\u0003\r\u0019X-\u001d\t\u0004Ub\u001c\u0018BA=l\u0005\r\u0019V-]\u0001\u000eg\u0016\f\u0018i\u001d&bm\u0006d\u0015n\u001d;\u0016\u0005q|HcA?\u0002\u0002A\u0019Qe\u0019@\u0011\u00055zH!B\u0018\t\u0005\u0004\u0001\u0004B\u0002<\t\u0001\u0004\t\u0019\u0001\u0005\u0003;\u0003\u000bq\u0018BA=\u0013\u0003MiW\u000f^1cY\u0016\u001cV\r^!t\u0015\u00064\u0018mU3u+\u0011\tY!!\u0006\u0015\t\u00055\u0011q\u0003\t\u0006K\u0005=\u00111C\u0005\u0004\u0003#1#aA*fiB\u0019Q&!\u0006\u0005\u000b=J!\u0019\u0001\u0019\t\u000f\u0005e\u0011\u00021\u0001\u0002\u001c\u0005\t1\u000fE\u0003k\u0003;\t\u0019\"C\u0002\u0002\u0012-\fAb]3u\u0003NT\u0015M^1TKR,B!a\t\u0002*Q!\u0011QEA\u0016!\u0015)\u0013qBA\u0014!\ri\u0013\u0011\u0006\u0003\u0006_)\u0011\r\u0001\r\u0005\b\u00033Q\u0001\u0019AA\u0017!\u0015Q\u0014qFA\u0014\u0013\r\t\tBE\u0001\u0014[V$\u0018M\u00197f\u001b\u0006\u0004\u0018i\u001d&bm\u0006l\u0015\r]\u000b\u0007\u0003k\ty$a\u0011\u0015\t\u0005]\u0012q\t\t\bK\u0005e\u0012QHA!\u0013\r\tYD\n\u0002\u0004\u001b\u0006\u0004\bcA\u0017\u0002@\u0011)qf\u0003b\u0001aA\u0019Q&a\u0011\u0005\r\u0005\u00153B1\u00011\u0005\u0005\u0011\u0005bBA%\u0017\u0001\u0007\u00111J\u0001\u0002[B9!.!\u0014\u0002>\u0005\u0005\u0013bAA\u001eW\u0006\u0001\u0012m\u001d&bm\u0006$\u0015n\u0019;j_:\f'/_\u000b\u0007\u0003'\ni&!\u0019\u0015\t\u0005U\u00131\r\t\bK\u0005]\u00131LA0\u0013\r\tIF\n\u0002\u000b\t&\u001cG/[8oCJL\bcA\u0017\u0002^\u0011)q\u0006\u0004b\u0001aA\u0019Q&!\u0019\u0005\r\u0005\u0015CB1\u00011\u0011\u001d\tI\u0005\u0004a\u0001\u0003K\u0002rA[A'\u00037\ny&\u0001\u0007nCB\f5OS1wC6\u000b\u0007/\u0006\u0004\u0002l\u0005E\u0014Q\u000f\u000b\u0005\u0003[\n9\bE\u0004&\u0003s\ty'a\u001d\u0011\u00075\n\t\bB\u00030\u001b\t\u0007\u0001\u0007E\u0002.\u0003k\"a!!\u0012\u000e\u0005\u0004\u0001\u0004bBA%\u001b\u0001\u0007\u0011\u0011\u0010\t\bu\u0005m\u0014qNA:\u0013\r\tYDE\u0001\u0017[\u0006\u0004\u0018i\u001d&bm\u0006\u001cuN\\2veJ,g\u000e^'baV1\u0011\u0011QAI\u0003+#B!a!\u0002\u0018BA\u0011QQAF\u0003\u001f\u000b\u0019*\u0004\u0002\u0002\b*\u0019\u0011\u0011\u0012\u0014\u0002\u0015\r|gnY;se\u0016tG/\u0003\u0003\u0002\u000e\u0006\u001d%!D\"p]\u000e,(O]3oi6\u000b\u0007\u000fE\u0002.\u0003##Qa\f\bC\u0002A\u00022!LAK\t\u0019\t)E\u0004b\u0001a!9\u0011\u0011\n\bA\u0002\u0005e\u0005\u0003CAN\u0003?\u000by)a%\u000e\u0005\u0005u%bAAE%%!\u00111HAO\u0001")
public interface LowPriorityWrapAsJava {
    public static /* synthetic */ java.util.Iterator asJavaIterator$(LowPriorityWrapAsJava $this, Iterator it) {
        return $this.asJavaIterator(it);
    }

    default public <A> java.util.Iterator<A> asJavaIterator(Iterator<A> it) {
        java.util.Iterator<A> iterator2 = it == null ? null : (it instanceof Wrappers.JIteratorWrapper && ((Wrappers.JIteratorWrapper)it).scala$collection$convert$Wrappers$JIteratorWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JIteratorWrapper)it).underlying() : new Wrappers.IteratorWrapper<A>(Wrappers$.MODULE$, it));
        return iterator2;
    }

    public static /* synthetic */ Enumeration asJavaEnumeration$(LowPriorityWrapAsJava $this, Iterator it) {
        return $this.asJavaEnumeration(it);
    }

    default public <A> Enumeration<A> asJavaEnumeration(Iterator<A> it) {
        Enumeration<A> enumeration = it == null ? null : (it instanceof Wrappers.JEnumerationWrapper && ((Wrappers.JEnumerationWrapper)it).scala$collection$convert$Wrappers$JEnumerationWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JEnumerationWrapper)it).underlying() : new Wrappers.IteratorWrapper<A>(Wrappers$.MODULE$, it));
        return enumeration;
    }

    public static /* synthetic */ java.lang.Iterable asJavaIterable$(LowPriorityWrapAsJava $this, Iterable i) {
        return $this.asJavaIterable(i);
    }

    default public <A> java.lang.Iterable<A> asJavaIterable(Iterable<A> i) {
        java.lang.Iterable<A> iterable = i == null ? null : (i instanceof Wrappers.JIterableWrapper && ((Wrappers.JIterableWrapper)i).scala$collection$convert$Wrappers$JIterableWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JIterableWrapper)i).underlying() : new Wrappers.IterableWrapper<A>(Wrappers$.MODULE$, i));
        return iterable;
    }

    public static /* synthetic */ Collection asJavaCollection$(LowPriorityWrapAsJava $this, Iterable it) {
        return $this.asJavaCollection(it);
    }

    default public <A> Collection<A> asJavaCollection(Iterable<A> it) {
        Collection<A> collection = it == null ? null : (it instanceof Wrappers.JCollectionWrapper && ((Wrappers.JCollectionWrapper)it).scala$collection$convert$Wrappers$JCollectionWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JCollectionWrapper)it).underlying() : new Wrappers.IterableWrapper<A>(Wrappers$.MODULE$, it));
        return collection;
    }

    public static /* synthetic */ List bufferAsJavaList$(LowPriorityWrapAsJava $this, Buffer b) {
        return $this.bufferAsJavaList(b);
    }

    default public <A> List<A> bufferAsJavaList(Buffer<A> b) {
        List<A> list = b == null ? null : (b instanceof Wrappers.JListWrapper && ((Wrappers.JListWrapper)b).scala$collection$convert$Wrappers$JListWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JListWrapper)b).underlying() : new Wrappers.MutableBufferWrapper<A>(Wrappers$.MODULE$, b));
        return list;
    }

    public static /* synthetic */ List mutableSeqAsJavaList$(LowPriorityWrapAsJava $this, scala.collection.mutable.Seq seq) {
        return $this.mutableSeqAsJavaList(seq);
    }

    default public <A> List<A> mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
        List<A> list = seq == null ? null : (seq instanceof Wrappers.JListWrapper && ((Wrappers.JListWrapper)seq).scala$collection$convert$Wrappers$JListWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JListWrapper)seq).underlying() : new Wrappers.MutableSeqWrapper<A>(Wrappers$.MODULE$, seq));
        return list;
    }

    public static /* synthetic */ List seqAsJavaList$(LowPriorityWrapAsJava $this, Seq seq) {
        return $this.seqAsJavaList(seq);
    }

    default public <A> List<A> seqAsJavaList(Seq<A> seq) {
        List<A> list = seq == null ? null : (seq instanceof Wrappers.JListWrapper && ((Wrappers.JListWrapper)seq).scala$collection$convert$Wrappers$JListWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JListWrapper)seq).underlying() : new Wrappers.SeqWrapper<A>(Wrappers$.MODULE$, seq));
        return list;
    }

    public static /* synthetic */ java.util.Set mutableSetAsJavaSet$(LowPriorityWrapAsJava $this, scala.collection.mutable.Set s) {
        return $this.mutableSetAsJavaSet(s);
    }

    default public <A> java.util.Set<A> mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
        java.util.Set<A> set = s == null ? null : (s instanceof Wrappers.JSetWrapper && ((Wrappers.JSetWrapper)s).scala$collection$convert$Wrappers$JSetWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JSetWrapper)s).underlying() : new Wrappers.MutableSetWrapper<A>((Wrappers)Wrappers$.MODULE$, s));
        return set;
    }

    public static /* synthetic */ java.util.Set setAsJavaSet$(LowPriorityWrapAsJava $this, Set s) {
        return $this.setAsJavaSet(s);
    }

    default public <A> java.util.Set<A> setAsJavaSet(Set<A> s) {
        java.util.Set<A> set = s == null ? null : (s instanceof Wrappers.JSetWrapper && ((Wrappers.JSetWrapper)s).scala$collection$convert$Wrappers$JSetWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JSetWrapper)s).underlying() : new Wrappers.SetWrapper<A>(Wrappers$.MODULE$, s));
        return set;
    }

    public static /* synthetic */ java.util.Map mutableMapAsJavaMap$(LowPriorityWrapAsJava $this, scala.collection.mutable.Map m) {
        return $this.mutableMapAsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
        java.util.Map<A, B> map = m == null ? null : (m instanceof Wrappers.JMapWrapper && ((Wrappers.JMapWrapper)m).scala$collection$convert$Wrappers$JMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JMapWrapper)m).underlying() : new Wrappers.MutableMapWrapper<A, B>((Wrappers)Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ Dictionary asJavaDictionary$(LowPriorityWrapAsJava $this, scala.collection.mutable.Map m) {
        return $this.asJavaDictionary(m);
    }

    default public <A, B> Dictionary<A, B> asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
        Dictionary dictionary = m == null ? null : (m instanceof Wrappers.JDictionaryWrapper && ((Wrappers.JDictionaryWrapper)m).scala$collection$convert$Wrappers$JDictionaryWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JDictionaryWrapper)m).underlying() : new Wrappers.DictionaryWrapper<A, B>(Wrappers$.MODULE$, m));
        return dictionary;
    }

    public static /* synthetic */ java.util.Map mapAsJavaMap$(LowPriorityWrapAsJava $this, Map m) {
        return $this.mapAsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> mapAsJavaMap(Map<A, B> m) {
        java.util.Map<A, B> map = m == null ? null : (m instanceof Wrappers.JMapWrapper && ((Wrappers.JMapWrapper)m).scala$collection$convert$Wrappers$JMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JMapWrapper)m).underlying() : new Wrappers.MapWrapper<A, B>(Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ ConcurrentMap mapAsJavaConcurrentMap$(LowPriorityWrapAsJava $this, scala.collection.concurrent.Map m) {
        return $this.mapAsJavaConcurrentMap(m);
    }

    default public <A, B> ConcurrentMap<A, B> mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        java.util.Map<Object, Object> map = m == null ? null : (m instanceof Wrappers.JConcurrentMapWrapper && ((Wrappers.JConcurrentMapWrapper)m).scala$collection$convert$Wrappers$JConcurrentMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.JConcurrentMapWrapper)m).underlying() : new Wrappers.ConcurrentMapWrapper<A, B>((Wrappers)Wrappers$.MODULE$, m));
        return map;
    }

    public static void $init$(LowPriorityWrapAsJava $this) {
    }
}

