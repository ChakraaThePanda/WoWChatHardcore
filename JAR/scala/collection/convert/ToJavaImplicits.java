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
import scala.collection.JavaConverters$;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005faB\b\u0011!\u0003\r\ta\u0006\u0005\u00069\u0001!\t!\b\u0005\u0006C\u0001!\u0019A\t\u0005\u0006y\u0001!\u0019!\u0010\u0005\u0006\r\u0002!\u0019a\u0012\u0005\u0006+\u0002!\u0019A\u0016\u0005\u0006?\u0002!\u0019\u0001\u0019\u0005\u0006_\u0002!\u0019\u0001\u001d\u0005\u0006u\u0002!\u0019a\u001f\u0005\b\u0003\u000f\u0001A1AA\u0005\u0011\u001d\ty\u0002\u0001C\u0002\u0003CAq!!\r\u0001\t\u0007\t\u0019\u0004C\u0004\u0002P\u0001!\u0019!!\u0015\t\u000f\u0005\u001d\u0004\u0001b\u0001\u0002j!9\u0011Q\u0010\u0001\u0005\u0004\u0005}$a\u0004+p\u0015\u00064\u0018-S7qY&\u001c\u0017\u000e^:\u000b\u0005E\u0011\u0012aB2p]Z,'\u000f\u001e\u0006\u0003'Q\t!bY8mY\u0016\u001cG/[8o\u0015\u0005)\u0012!B:dC2\f7\u0001A\n\u0003\u0001a\u0001\"!\u0007\u000e\u000e\u0003QI!a\u0007\u000b\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\ta\u0004\u0005\u0002\u001a?%\u0011\u0001\u0005\u0006\u0002\u0005+:LG/\u0001\u000bji\u0016\u0014\u0018\r^8sIU\u0004\u0004G\r\u0019bg*\u000bg/Y\u000b\u0003G9\"\"\u0001J\u001c\u0011\u0007\u0015RC&D\u0001'\u0015\t9\u0003&\u0001\u0003vi&d'\"A\u0015\u0002\t)\fg/Y\u0005\u0003W\u0019\u0012\u0001\"\u0013;fe\u0006$xN\u001d\t\u0003[9b\u0001\u0001B\u00030\u0005\t\u0007\u0001GA\u0001B#\t\tD\u0007\u0005\u0002\u001ae%\u00111\u0007\u0006\u0002\b\u001d>$\b.\u001b8h!\tIR'\u0003\u00027)\t\u0019\u0011I\\=\t\u000ba\u0012\u0001\u0019A\u001d\u0002\u0005%$\bc\u0001\u001e<Y5\t!#\u0003\u0002,%\u00059RM\\;nKJ\fG/[8oIU\u0004\u0004G\r\u0019bg*\u000bg/Y\u000b\u0003}\r#\"a\u0010#\u0011\u0007\u0015\u0002%)\u0003\u0002BM\tYQI\\;nKJ\fG/[8o!\ti3\tB\u00030\u0007\t\u0007\u0001\u0007C\u00039\u0007\u0001\u0007Q\tE\u0002;w\t\u000bA#\u001b;fe\u0006\u0014G.\u001a\u0013vaA\u0012\u0004'Y:KCZ\fWC\u0001%Q)\tI\u0015\u000bE\u0002K\u001b>k\u0011a\u0013\u0006\u0003\u0019\"\nA\u0001\\1oO&\u0011aj\u0013\u0002\t\u0013R,'/\u00192mKB\u0011Q\u0006\u0015\u0003\u0006_\u0011\u0011\r\u0001\r\u0005\u0006%\u0012\u0001\raU\u0001\u0002SB\u0019!\bV(\n\u00059\u0013\u0012AF2pY2,7\r^5p]\u0012*\b\u0007\r\u001a1CNT\u0015M^1\u0016\u0005]cFC\u0001-^!\r)\u0013lW\u0005\u00035\u001a\u0012!bQ8mY\u0016\u001cG/[8o!\tiC\fB\u00030\u000b\t\u0007\u0001\u0007C\u00039\u000b\u0001\u0007a\fE\u0002;)n\u000baCY;gM\u0016\u0014H%\u001e\u00191eA\n5OS1wC2K7\u000f^\u000b\u0003C\u001a$\"AY4\u0011\u0007\u0015\u001aW-\u0003\u0002eM\t!A*[:u!\tic\rB\u00030\r\t\u0007\u0001\u0007C\u0003i\r\u0001\u0007\u0011.A\u0001c!\rQW.Z\u0007\u0002W*\u0011ANE\u0001\b[V$\u0018M\u00197f\u0013\tq7N\u0001\u0004Ck\u001a4WM]\u0001\u001b[V$\u0018M\u00197f'\u0016\fH%\u001e\u00191eA\n5OS1wC2K7\u000f^\u000b\u0003cR$\"A];\u0011\u0007\u0015\u001a7\u000f\u0005\u0002.i\u0012)qf\u0002b\u0001a!)ao\u0002a\u0001o\u0006\u00191/Z9\u0011\u0007)D8/\u0003\u0002zW\n\u00191+Z9\u0002'M,\u0017\u000fJ;1aI\u0002\u0014i\u001d&bm\u0006d\u0015n\u001d;\u0016\u0005q|HcA?\u0002\u0002A\u0019Qe\u0019@\u0011\u00055zH!B\u0018\t\u0005\u0004\u0001\u0004B\u0002<\t\u0001\u0004\t\u0019\u0001\u0005\u0003;\u0003\u000bq\u0018BA=\u0013\u0003eiW\u000f^1cY\u0016\u001cV\r\u001e\u0013vaA\u0012\u0004'Q:KCZ\f7+\u001a;\u0016\t\u0005-\u0011Q\u0003\u000b\u0005\u0003\u001b\t9\u0002E\u0003&\u0003\u001f\t\u0019\"C\u0002\u0002\u0012\u0019\u00121aU3u!\ri\u0013Q\u0003\u0003\u0006_%\u0011\r\u0001\r\u0005\b\u00033I\u0001\u0019AA\u000e\u0003\u0005\u0019\b#\u00026\u0002\u001e\u0005M\u0011bAA\tW\u0006\u00112/\u001a;%kB\u0002$\u0007M!t\u0015\u00064\u0018mU3u+\u0011\t\u0019#!\u000b\u0015\t\u0005\u0015\u00121\u0006\t\u0006K\u0005=\u0011q\u0005\t\u0004[\u0005%B!B\u0018\u000b\u0005\u0004\u0001\u0004bBA\r\u0015\u0001\u0007\u0011Q\u0006\t\u0006u\u0005=\u0012qE\u0005\u0004\u0003#\u0011\u0012!G7vi\u0006\u0014G.Z'ba\u0012*\b\u0007\r\u001a1\u0003NT\u0015M^1NCB,b!!\u000e\u0002@\u0005\rC\u0003BA\u001c\u0003\u000f\u0002r!JA\u001d\u0003{\t\t%C\u0002\u0002<\u0019\u00121!T1q!\ri\u0013q\b\u0003\u0006_-\u0011\r\u0001\r\t\u0004[\u0005\rCABA#\u0017\t\u0007\u0001GA\u0001C\u0011\u001d\tIe\u0003a\u0001\u0003\u0017\n\u0011!\u001c\t\bU\u00065\u0013QHA!\u0013\r\tYd[\u0001\u0017I&\u001cG/[8oCJLH%\u001e\u00191eA\n7OS1wCV1\u00111KA/\u0003C\"B!!\u0016\u0002dA9Q%a\u0016\u0002\\\u0005}\u0013bAA-M\tQA)[2uS>t\u0017M]=\u0011\u00075\ni\u0006B\u00030\u0019\t\u0007\u0001\u0007E\u0002.\u0003C\"a!!\u0012\r\u0005\u0004\u0001\u0004bBA%\u0019\u0001\u0007\u0011Q\r\t\bU\u00065\u00131LA0\u0003Ii\u0017\r\u001d\u0013vaA\u0012\u0004'Q:KCZ\fW*\u00199\u0016\r\u0005-\u0014\u0011OA;)\u0011\ti'a\u001e\u0011\u000f\u0015\nI$a\u001c\u0002tA\u0019Q&!\u001d\u0005\u000b=j!\u0019\u0001\u0019\u0011\u00075\n)\b\u0002\u0004\u0002F5\u0011\r\u0001\r\u0005\b\u0003\u0013j\u0001\u0019AA=!\u001dQ\u00141PA8\u0003gJ1!a\u000f\u0013\u0003qi\u0017\r\u001d\u0013vaA\u0012\u0004'Q:KCZ\f7i\u001c8dkJ\u0014XM\u001c;NCB,b!!!\u0002\u0012\u0006UE\u0003BAB\u0003/\u0003\u0002\"!\"\u0002\f\u0006=\u00151S\u0007\u0003\u0003\u000fS1!!#'\u0003)\u0019wN\\2veJ,g\u000e^\u0005\u0005\u0003\u001b\u000b9IA\u0007D_:\u001cWO\u001d:f]Rl\u0015\r\u001d\t\u0004[\u0005EE!B\u0018\u000f\u0005\u0004\u0001\u0004cA\u0017\u0002\u0016\u00121\u0011Q\t\bC\u0002ABq!!\u0013\u000f\u0001\u0004\tI\n\u0005\u0005\u0002\u001c\u0006}\u0015qRAJ\u001b\t\tiJC\u0002\u0002\nJIA!a\u000f\u0002\u001e\u0002")
public interface ToJavaImplicits {
    public static /* synthetic */ java.util.Iterator iterator$u0020asJava$(ToJavaImplicits $this, Iterator it) {
        return $this.iterator$u0020asJava(it);
    }

    default public <A> java.util.Iterator<A> iterator$u0020asJava(Iterator<A> it) {
        return JavaConverters$.MODULE$.asJavaIterator(it);
    }

    public static /* synthetic */ Enumeration enumeration$u0020asJava$(ToJavaImplicits $this, Iterator it) {
        return $this.enumeration$u0020asJava(it);
    }

    default public <A> Enumeration<A> enumeration$u0020asJava(Iterator<A> it) {
        return JavaConverters$.MODULE$.asJavaEnumeration(it);
    }

    public static /* synthetic */ java.lang.Iterable iterable$u0020asJava$(ToJavaImplicits $this, Iterable i) {
        return $this.iterable$u0020asJava(i);
    }

    default public <A> java.lang.Iterable<A> iterable$u0020asJava(Iterable<A> i) {
        return JavaConverters$.MODULE$.asJavaIterable(i);
    }

    public static /* synthetic */ Collection collection$u0020asJava$(ToJavaImplicits $this, Iterable it) {
        return $this.collection$u0020asJava(it);
    }

    default public <A> Collection<A> collection$u0020asJava(Iterable<A> it) {
        return JavaConverters$.MODULE$.asJavaCollection(it);
    }

    public static /* synthetic */ List buffer$u0020AsJavaList$(ToJavaImplicits $this, Buffer b) {
        return $this.buffer$u0020AsJavaList(b);
    }

    default public <A> List<A> buffer$u0020AsJavaList(Buffer<A> b) {
        return JavaConverters$.MODULE$.bufferAsJavaList(b);
    }

    public static /* synthetic */ List mutableSeq$u0020AsJavaList$(ToJavaImplicits $this, scala.collection.mutable.Seq seq) {
        return $this.mutableSeq$u0020AsJavaList(seq);
    }

    default public <A> List<A> mutableSeq$u0020AsJavaList(scala.collection.mutable.Seq<A> seq) {
        return JavaConverters$.MODULE$.mutableSeqAsJavaList(seq);
    }

    public static /* synthetic */ List seq$u0020AsJavaList$(ToJavaImplicits $this, Seq seq) {
        return $this.seq$u0020AsJavaList(seq);
    }

    default public <A> List<A> seq$u0020AsJavaList(Seq<A> seq) {
        return JavaConverters$.MODULE$.seqAsJavaList(seq);
    }

    public static /* synthetic */ java.util.Set mutableSet$u0020AsJavaSet$(ToJavaImplicits $this, scala.collection.mutable.Set s) {
        return $this.mutableSet$u0020AsJavaSet(s);
    }

    default public <A> java.util.Set<A> mutableSet$u0020AsJavaSet(scala.collection.mutable.Set<A> s) {
        return JavaConverters$.MODULE$.mutableSetAsJavaSet(s);
    }

    public static /* synthetic */ java.util.Set set$u0020AsJavaSet$(ToJavaImplicits $this, Set s) {
        return $this.set$u0020AsJavaSet(s);
    }

    default public <A> java.util.Set<A> set$u0020AsJavaSet(Set<A> s) {
        return JavaConverters$.MODULE$.setAsJavaSet(s);
    }

    public static /* synthetic */ java.util.Map mutableMap$u0020AsJavaMap$(ToJavaImplicits $this, scala.collection.mutable.Map m) {
        return $this.mutableMap$u0020AsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> mutableMap$u0020AsJavaMap(scala.collection.mutable.Map<A, B> m) {
        return JavaConverters$.MODULE$.mutableMapAsJavaMap(m);
    }

    public static /* synthetic */ Dictionary dictionary$u0020asJava$(ToJavaImplicits $this, scala.collection.mutable.Map m) {
        return $this.dictionary$u0020asJava(m);
    }

    default public <A, B> Dictionary<A, B> dictionary$u0020asJava(scala.collection.mutable.Map<A, B> m) {
        return JavaConverters$.MODULE$.asJavaDictionary(m);
    }

    public static /* synthetic */ java.util.Map map$u0020AsJavaMap$(ToJavaImplicits $this, Map m) {
        return $this.map$u0020AsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> map$u0020AsJavaMap(Map<A, B> m) {
        return JavaConverters$.MODULE$.mapAsJavaMap(m);
    }

    public static /* synthetic */ ConcurrentMap map$u0020AsJavaConcurrentMap$(ToJavaImplicits $this, scala.collection.concurrent.Map m) {
        return $this.map$u0020AsJavaConcurrentMap(m);
    }

    default public <A, B> ConcurrentMap<A, B> map$u0020AsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        return JavaConverters$.MODULE$.mapAsJavaConcurrentMap(m);
    }

    public static void $init$(ToJavaImplicits $this) {
    }
}

