/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import scala.Function0;
import scala.Serializable;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.convert.AsJavaConverters;
import scala.collection.convert.Decorators;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015gaB\b\u0011!\u0003\r\ta\u0006\u0005\u0006A\u0001!\t!\t\u0005\u0006K\u0001!\u0019A\n\u0005\u0006\u000f\u0002!\u0019\u0001\u0013\u0005\u0006#\u0002!\u0019A\u0015\u0005\u0006A\u0002!\u0019!\u0019\u0005\u0006U\u0002!\u0019a\u001b\u0005\u0006w\u0002!\u0019\u0001 \u0005\b\u0003\u001b\u0001A1AA\b\u0011\u001d\t\t\u0003\u0001C\u0002\u0003GAq!a\u000f\u0001\t\u0007\ti\u0004C\u0004\u0002P\u0001!\u0019!!\u0015\t\u000f\u0005=\u0004\u0001b\u0001\u0002r!9\u0011q\u0011\u0001\u0005\u0004\u0005%\u0005bBAP\u0001\u0011\r\u0011\u0011\u0015\u0002\u000f\t\u0016\u001cwN]1uK\u0006\u001b(*\u0019<b\u0015\t\t\"#A\u0004d_:4XM\u001d;\u000b\u0005M!\u0012AC2pY2,7\r^5p]*\tQ#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u0001AB\u0004\u0005\u0002\u001a55\tA#\u0003\u0002\u001c)\t1\u0011I\\=SK\u001a\u0004\"!\b\u0010\u000e\u0003AI!a\b\t\u0003!\u0005\u001b(*\u0019<b\u0007>tg/\u001a:uKJ\u001c\u0018A\u0002\u0013j]&$H\u0005F\u0001#!\tI2%\u0003\u0002%)\t!QK\\5u\u0003]\t7OS1wC&#XM]1u_J\u001cuN\u001c<feR,'/\u0006\u0002(sQ\u0011\u0001F\u0011\t\u0004S1zcBA\u000f+\u0013\tY\u0003#\u0001\u0006EK\u000e|'/\u0019;peNL!!\f\u0018\u0003\r\u0005\u001b(*\u0019<b\u0015\tY\u0003\u0003E\u00021k]j\u0011!\r\u0006\u0003eM\nA!\u001e;jY*\tA'\u0001\u0003kCZ\f\u0017B\u0001\u001c2\u0005!IE/\u001a:bi>\u0014\bC\u0001\u001d:\u0019\u0001!QA\u000f\u0002C\u0002m\u0012\u0011!Q\t\u0003y}\u0002\"!G\u001f\n\u0005y\"\"a\u0002(pi\"Lgn\u001a\t\u00033\u0001K!!\u0011\u000b\u0003\u0007\u0005s\u0017\u0010C\u0003D\u0005\u0001\u0007A)A\u0001j!\r)eiN\u0007\u0002%%\u0011aGE\u0001\u001bCNT\u0015M^1F]VlWM]1uS>t7i\u001c8wKJ$XM]\u000b\u0003\u0013:#\"AS(\u0011\u0007%ZU*\u0003\u0002M]\t\t\u0012i\u001d&bm\u0006,e.^7fe\u0006$\u0018n\u001c8\u0011\u0005arE!\u0002\u001e\u0004\u0005\u0004Y\u0004\"B\"\u0004\u0001\u0004\u0001\u0006cA#G\u001b\u00069\u0012m\u001d&bm\u0006LE/\u001a:bE2,7i\u001c8wKJ$XM]\u000b\u0003'r#\"\u0001V/\u0011\u0007%bS\u000bE\u0002W3nk\u0011a\u0016\u0006\u00031N\nA\u0001\\1oO&\u0011!l\u0016\u0002\t\u0013R,'/\u00192mKB\u0011\u0001\b\u0018\u0003\u0006u\u0011\u0011\ra\u000f\u0005\u0006\u0007\u0012\u0001\rA\u0018\t\u0004\u000b~[\u0016B\u0001.\u0013\u0003e\t7OS1wC\u000e{G\u000e\\3di&|gnQ8om\u0016\u0014H/\u001a:\u0016\u0005\t<GCA2i!\rICMZ\u0005\u0003K:\u0012\u0001#Q:KCZ\f7i\u001c7mK\u000e$\u0018n\u001c8\u0011\u0005a:G!\u0002\u001e\u0006\u0005\u0004Y\u0004\"B\"\u0006\u0001\u0004I\u0007cA#`M\u0006I\"-\u001e4gKJ\f5OS1wC2K7\u000f^\"p]Z,'\u000f^3s+\ta'\u000f\u0006\u0002ngB\u0019\u0011\u0006\f8\u0011\u0007Az\u0017/\u0003\u0002qc\t!A*[:u!\tA$\u000fB\u0003;\r\t\u00071\bC\u0003u\r\u0001\u0007Q/A\u0001c!\r1\u00180]\u0007\u0002o*\u0011\u0001PE\u0001\b[V$\u0018M\u00197f\u0013\tQxO\u0001\u0004Ck\u001a4WM]\u0001\u001e[V$\u0018M\u00197f'\u0016\f\u0018i\u001d&bm\u0006d\u0015n\u001d;D_:4XM\u001d;feV\u0019Q0a\u0001\u0015\u0007y\f)\u0001E\u0002*Y}\u0004B\u0001M8\u0002\u0002A\u0019\u0001(a\u0001\u0005\u000bi:!\u0019A\u001e\t\rQ<\u0001\u0019AA\u0004!\u00151\u0018\u0011BA\u0001\u0013\r\tYa\u001e\u0002\u0004'\u0016\f\u0018AF:fc\u0006\u001b(*\u0019<b\u0019&\u001cHoQ8om\u0016\u0014H/\u001a:\u0016\t\u0005E\u0011\u0011\u0004\u000b\u0005\u0003'\tY\u0002\u0005\u0003*Y\u0005U\u0001\u0003\u0002\u0019p\u0003/\u00012\u0001OA\r\t\u0015Q\u0004B1\u0001<\u0011\u0019!\b\u00021\u0001\u0002\u001eA)Q)a\b\u0002\u0018%\u0019\u00111\u0002\n\u000295,H/\u00192mKN+G/Q:KCZ\f7+\u001a;D_:4XM\u001d;feV!\u0011QEA\u0019)\u0011\t9#a\r\u0011\t%b\u0013\u0011\u0006\t\u0006a\u0005-\u0012qF\u0005\u0004\u0003[\t$aA*fiB\u0019\u0001(!\r\u0005\u000biJ!\u0019A\u001e\t\u000f\u0005U\u0012\u00021\u0001\u00028\u0005\t1\u000fE\u0003w\u0003s\ty#C\u0002\u0002.]\fQc]3u\u0003NT\u0015M^1TKR\u001cuN\u001c<feR,'/\u0006\u0003\u0002@\u0005\u001dC\u0003BA!\u0003\u0013\u0002B!\u000b\u0017\u0002DA)\u0001'a\u000b\u0002FA\u0019\u0001(a\u0012\u0005\u000biR!\u0019A\u001e\t\u000f\u0005U\"\u00021\u0001\u0002LA)Q)!\u0014\u0002F%\u0019\u0011Q\u0006\n\u000295,H/\u00192mK6\u000b\u0007/Q:KCZ\fW*\u00199D_:4XM\u001d;feV1\u00111KA0\u0003G\"B!!\u0016\u0002hA!\u0011\u0006LA,!\u001d\u0001\u0014\u0011LA/\u0003CJ1!a\u00172\u0005\ri\u0015\r\u001d\t\u0004q\u0005}C!\u0002\u001e\f\u0005\u0004Y\u0004c\u0001\u001d\u0002d\u00111\u0011QM\u0006C\u0002m\u0012\u0011A\u0011\u0005\b\u0003SZ\u0001\u0019AA6\u0003\u0005i\u0007c\u0002<\u0002n\u0005u\u0013\u0011M\u0005\u0004\u00037:\u0018!G1t\u0015\u00064\u0018\rR5di&|g.\u0019:z\u0007>tg/\u001a:uKJ,b!a\u001d\u0002~\u0005\u0005E\u0003BA;\u0003\u0007\u0003r!KA<\u0003w\ny(C\u0002\u0002z9\u0012\u0001#Q:KCZ\fG)[2uS>t\u0017M]=\u0011\u0007a\ni\bB\u0003;\u0019\t\u00071\bE\u00029\u0003\u0003#a!!\u001a\r\u0005\u0004Y\u0004bBA5\u0019\u0001\u0007\u0011Q\u0011\t\bm\u00065\u00141PA@\u0003Ui\u0017\r]!t\u0015\u00064\u0018-T1q\u0007>tg/\u001a:uKJ,b!a#\u0002\u0014\u0006]E\u0003BAG\u00033\u0003B!\u000b\u0017\u0002\u0010B9\u0001'!\u0017\u0002\u0012\u0006U\u0005c\u0001\u001d\u0002\u0014\u0012)!(\u0004b\u0001wA\u0019\u0001(a&\u0005\r\u0005\u0015TB1\u0001<\u0011\u001d\tI'\u0004a\u0001\u00037\u0003r!RAO\u0003#\u000b)*C\u0002\u0002\\I\tq$\\1q\u0003NT\u0015M^1D_:\u001cWO\u001d:f]Rl\u0015\r]\"p]Z,'\u000f^3s+\u0019\t\u0019+!.\u0002:R!\u0011QUA^!\u0011IC&a*\u0011\u0011\u0005%\u0016qVAZ\u0003ok!!a+\u000b\u0007\u00055\u0016'\u0001\u0006d_:\u001cWO\u001d:f]RLA!!-\u0002,\ni1i\u001c8dkJ\u0014XM\u001c;NCB\u00042\u0001OA[\t\u0015QdB1\u0001<!\rA\u0014\u0011\u0018\u0003\u0007\u0003Kr!\u0019A\u001e\t\u000f\u0005%d\u00021\u0001\u0002>BA\u0011qXAb\u0003g\u000b9,\u0004\u0002\u0002B*\u0019\u0011Q\u0016\n\n\t\u0005m\u0013\u0011\u0019")
public interface DecorateAsJava
extends AsJavaConverters {
    public static /* synthetic */ Decorators.AsJava asJavaIteratorConverter$(DecorateAsJava $this, Iterator i) {
        return $this.asJavaIteratorConverter(i);
    }

    default public <A> Decorators.AsJava<java.util.Iterator<A>> asJavaIteratorConverter(Iterator<A> i) {
        return new Decorators.AsJava<java.util.Iterator<A>>((Function0<java.util.Iterator> & java.io.Serializable & Serializable)() -> this.asJavaIterator(i));
    }

    public static /* synthetic */ Decorators.AsJavaEnumeration asJavaEnumerationConverter$(DecorateAsJava $this, Iterator i) {
        return $this.asJavaEnumerationConverter(i);
    }

    default public <A> Decorators.AsJavaEnumeration<A> asJavaEnumerationConverter(Iterator<A> i) {
        return new Decorators.AsJavaEnumeration<A>(i);
    }

    public static /* synthetic */ Decorators.AsJava asJavaIterableConverter$(DecorateAsJava $this, Iterable i) {
        return $this.asJavaIterableConverter(i);
    }

    default public <A> Decorators.AsJava<java.lang.Iterable<A>> asJavaIterableConverter(Iterable<A> i) {
        return new Decorators.AsJava<java.lang.Iterable<A>>((Function0<java.lang.Iterable> & java.io.Serializable & Serializable)() -> this.asJavaIterable(i));
    }

    public static /* synthetic */ Decorators.AsJavaCollection asJavaCollectionConverter$(DecorateAsJava $this, Iterable i) {
        return $this.asJavaCollectionConverter(i);
    }

    default public <A> Decorators.AsJavaCollection<A> asJavaCollectionConverter(Iterable<A> i) {
        return new Decorators.AsJavaCollection<A>(i);
    }

    public static /* synthetic */ Decorators.AsJava bufferAsJavaListConverter$(DecorateAsJava $this, Buffer b) {
        return $this.bufferAsJavaListConverter(b);
    }

    default public <A> Decorators.AsJava<List<A>> bufferAsJavaListConverter(Buffer<A> b) {
        return new Decorators.AsJava<List<A>>((Function0<List> & java.io.Serializable & Serializable)() -> this.bufferAsJavaList(b));
    }

    public static /* synthetic */ Decorators.AsJava mutableSeqAsJavaListConverter$(DecorateAsJava $this, scala.collection.mutable.Seq b) {
        return $this.mutableSeqAsJavaListConverter(b);
    }

    default public <A> Decorators.AsJava<List<A>> mutableSeqAsJavaListConverter(scala.collection.mutable.Seq<A> b) {
        return new Decorators.AsJava<List<A>>((Function0<List> & java.io.Serializable & Serializable)() -> this.mutableSeqAsJavaList(b));
    }

    public static /* synthetic */ Decorators.AsJava seqAsJavaListConverter$(DecorateAsJava $this, Seq b) {
        return $this.seqAsJavaListConverter(b);
    }

    default public <A> Decorators.AsJava<List<A>> seqAsJavaListConverter(Seq<A> b) {
        return new Decorators.AsJava<List<A>>((Function0<List> & java.io.Serializable & Serializable)() -> this.seqAsJavaList(b));
    }

    public static /* synthetic */ Decorators.AsJava mutableSetAsJavaSetConverter$(DecorateAsJava $this, scala.collection.mutable.Set s) {
        return $this.mutableSetAsJavaSetConverter(s);
    }

    default public <A> Decorators.AsJava<java.util.Set<A>> mutableSetAsJavaSetConverter(scala.collection.mutable.Set<A> s) {
        return new Decorators.AsJava<java.util.Set<A>>((Function0<java.util.Set> & java.io.Serializable & Serializable)() -> this.mutableSetAsJavaSet(s));
    }

    public static /* synthetic */ Decorators.AsJava setAsJavaSetConverter$(DecorateAsJava $this, Set s) {
        return $this.setAsJavaSetConverter(s);
    }

    default public <A> Decorators.AsJava<java.util.Set<A>> setAsJavaSetConverter(Set<A> s) {
        return new Decorators.AsJava<java.util.Set<A>>((Function0<java.util.Set> & java.io.Serializable & Serializable)() -> this.setAsJavaSet(s));
    }

    public static /* synthetic */ Decorators.AsJava mutableMapAsJavaMapConverter$(DecorateAsJava $this, scala.collection.mutable.Map m) {
        return $this.mutableMapAsJavaMapConverter(m);
    }

    default public <A, B> Decorators.AsJava<java.util.Map<A, B>> mutableMapAsJavaMapConverter(scala.collection.mutable.Map<A, B> m) {
        return new Decorators.AsJava<java.util.Map<A, B>>((Function0<java.util.Map> & java.io.Serializable & Serializable)() -> this.mutableMapAsJavaMap(m));
    }

    public static /* synthetic */ Decorators.AsJavaDictionary asJavaDictionaryConverter$(DecorateAsJava $this, scala.collection.mutable.Map m) {
        return $this.asJavaDictionaryConverter(m);
    }

    default public <A, B> Decorators.AsJavaDictionary<A, B> asJavaDictionaryConverter(scala.collection.mutable.Map<A, B> m) {
        return new Decorators.AsJavaDictionary<A, B>(m);
    }

    public static /* synthetic */ Decorators.AsJava mapAsJavaMapConverter$(DecorateAsJava $this, Map m) {
        return $this.mapAsJavaMapConverter(m);
    }

    default public <A, B> Decorators.AsJava<java.util.Map<A, B>> mapAsJavaMapConverter(Map<A, B> m) {
        return new Decorators.AsJava<java.util.Map<A, B>>((Function0<java.util.Map> & java.io.Serializable & Serializable)() -> this.mapAsJavaMap(m));
    }

    public static /* synthetic */ Decorators.AsJava mapAsJavaConcurrentMapConverter$(DecorateAsJava $this, scala.collection.concurrent.Map m) {
        return $this.mapAsJavaConcurrentMapConverter(m);
    }

    default public <A, B> Decorators.AsJava<ConcurrentMap<A, B>> mapAsJavaConcurrentMapConverter(scala.collection.concurrent.Map<A, B> m) {
        return new Decorators.AsJava<ConcurrentMap<A, B>>((Function0<ConcurrentMap> & java.io.Serializable & Serializable)() -> this.mapAsJavaConcurrentMap(m));
    }

    public static void $init$(DecorateAsJava $this) {
    }
}

