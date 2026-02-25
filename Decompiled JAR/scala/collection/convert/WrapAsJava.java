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
import scala.collection.convert.LowPriorityWrapAsJava;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005Uga\u0002\n\u0014!\u0003\r\tA\u0007\u0005\u0006G\u0001!\t\u0001\n\u0005\u0006Q\u0001!\u0019!\u000b\u0005\u0006\u0007\u0002!\u0019\u0001\u0012\u0005\u0006\u001b\u0002!\u0019A\u0014\u0005\u00069\u0002!\u0019!\u0018\u0005\u0006M\u0002!\u0019a\u001a\u0005\u0006m\u0002!\u0019a\u001e\u0005\b\u0003\u0007\u0001A1AA\u0003\u0011\u001d\t)\u0002\u0001C\u0002\u0003/Aq!!\f\u0001\t\u0007\ty\u0003C\u0004\u0002@\u0001!\u0019!!\u0011\t\u000f\u0005u\u0003\u0001b\u0001\u0002`!9\u0011Q\u000f\u0001\u0005\u0004\u0005]\u0004bBAF\u0001\u0011\r\u0011QR\u0004\b\u0003\u007f\u001b\u0002\u0012AAa\r\u0019\u00112\u0003#\u0001\u0002D\"9\u0011q\u0019\t\u0005\u0002\u0005%'AC,sCB\f5OS1wC*\u0011A#F\u0001\bG>tg/\u001a:u\u0015\t1r#\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001G\u0001\u0006g\u000e\fG.Y\u0002\u0001'\r\u00011d\b\t\u00039ui\u0011aF\u0005\u0003=]\u0011a!\u00118z%\u00164\u0007C\u0001\u0011\"\u001b\u0005\u0019\u0012B\u0001\u0012\u0014\u0005Uaun\u001e)sS>\u0014\u0018\u000e^=Xe\u0006\u0004\u0018i\u001d&bm\u0006\fa\u0001J5oSR$C#A\u0013\u0011\u0005q1\u0013BA\u0014\u0018\u0005\u0011)f.\u001b;\u0002=\u0011,\u0007O]3dCR,G\rJ;1aI\u0002\u0014m\u001d&bm\u0006LE/\u001a:bi>\u0014XC\u0001\u00166)\tYc\bE\u0002-cMj\u0011!\f\u0006\u0003]=\nA!\u001e;jY*\t\u0001'\u0001\u0003kCZ\f\u0017B\u0001\u001a.\u0005!IE/\u001a:bi>\u0014\bC\u0001\u001b6\u0019\u0001!QA\u000e\u0002C\u0002]\u0012\u0011!Q\t\u0003qm\u0002\"\u0001H\u001d\n\u0005i:\"a\u0002(pi\"Lgn\u001a\t\u00039qJ!!P\f\u0003\u0007\u0005s\u0017\u0010C\u0003@\u0005\u0001\u0007\u0001)\u0001\u0002jiB\u0019\u0011IQ\u001a\u000e\u0003UI!AM\u000b\u0002C\u0011,\u0007O]3dCR,G\rJ;1aI\u0002\u0014m\u001d&bm\u0006,e.^7fe\u0006$\u0018n\u001c8\u0016\u0005\u0015SEC\u0001$L!\ras)S\u0005\u0003\u00116\u00121\"\u00128v[\u0016\u0014\u0018\r^5p]B\u0011AG\u0013\u0003\u0006m\r\u0011\ra\u000e\u0005\u0006\u007f\r\u0001\r\u0001\u0014\t\u0004\u0003\nK\u0015A\b3faJ,7-\u0019;fI\u0012*\b\u0007\r\u001a1CNT\u0015M^1Ji\u0016\u0014\u0018M\u00197f+\tyu\u000b\u0006\u0002Q1B\u0019\u0011\u000b\u0016,\u000e\u0003IS!aU\u0018\u0002\t1\fgnZ\u0005\u0003+J\u0013\u0001\"\u0013;fe\u0006\u0014G.\u001a\t\u0003i]#QA\u000e\u0003C\u0002]BQ!\u0017\u0003A\u0002i\u000b\u0011!\u001b\t\u0004\u0003n3\u0016BA+\u0016\u0003\u0001\"W\r\u001d:fG\u0006$X\r\u001a\u0013vaA\u0012\u0004'Y:KCZ\f7i\u001c7mK\u000e$\u0018n\u001c8\u0016\u0005y\u001bGCA0e!\ra\u0003MY\u0005\u0003C6\u0012!bQ8mY\u0016\u001cG/[8o!\t!4\rB\u00037\u000b\t\u0007q\u0007C\u0003@\u000b\u0001\u0007Q\rE\u0002B7\n\f\u0001\u0005Z3qe\u0016\u001c\u0017\r^3eIU\u0004\u0004G\r\u0019ck\u001a4WM]!t\u0015\u00064\u0018\rT5tiV\u0011\u0001.\u001c\u000b\u0003S:\u00042\u0001\f6m\u0013\tYWF\u0001\u0003MSN$\bC\u0001\u001bn\t\u00151dA1\u00018\u0011\u0015yg\u00011\u0001q\u0003\u0005\u0011\u0007cA9uY6\t!O\u0003\u0002t+\u00059Q.\u001e;bE2,\u0017BA;s\u0005\u0019\u0011UO\u001a4fe\u0006!C-\u001a9sK\u000e\fG/\u001a3%kB\u0002$\u0007M7vi\u0006\u0014G.Z*fc\u0006\u001b(*\u0019<b\u0019&\u001cH/\u0006\u0002ywR\u0011\u0011\u0010 \t\u0004Y)T\bC\u0001\u001b|\t\u00151tA1\u00018\u0011\u0015ix\u00011\u0001\u007f\u0003\r\u0019X-\u001d\t\u0004c~T\u0018bAA\u0001e\n\u00191+Z9\u0002;\u0011,\u0007O]3dCR,G\rJ;1aI\u00024/Z9Bg*\u000bg/\u0019'jgR,B!a\u0002\u0002\u000eQ!\u0011\u0011BA\b!\u0011a#.a\u0003\u0011\u0007Q\ni\u0001B\u00037\u0011\t\u0007q\u0007\u0003\u0004~\u0011\u0001\u0007\u0011\u0011\u0003\t\u0006\u0003\u0006M\u00111B\u0005\u0004\u0003\u0003)\u0012a\t3faJ,7-\u0019;fI\u0012*\b\u0007\r\u001a1[V$\u0018M\u00197f'\u0016$\u0018i\u001d&bm\u0006\u001cV\r^\u000b\u0005\u00033\t\u0019\u0003\u0006\u0003\u0002\u001c\u0005\u0015\u0002#\u0002\u0017\u0002\u001e\u0005\u0005\u0012bAA\u0010[\t\u00191+\u001a;\u0011\u0007Q\n\u0019\u0003B\u00037\u0013\t\u0007q\u0007C\u0004\u0002(%\u0001\r!!\u000b\u0002\u0003M\u0004R!]A\u0016\u0003CI1!a\bs\u0003q!W\r\u001d:fG\u0006$X\r\u001a\u0013vaA\u0012\u0004g]3u\u0003NT\u0015M^1TKR,B!!\r\u00028Q!\u00111GA\u001d!\u0015a\u0013QDA\u001b!\r!\u0014q\u0007\u0003\u0006m)\u0011\ra\u000e\u0005\b\u0003OQ\u0001\u0019AA\u001e!\u0015\t\u0015QHA\u001b\u0013\r\ty\"F\u0001$I\u0016\u0004(/Z2bi\u0016$G%\u001e\u00191eAjW\u000f^1cY\u0016l\u0015\r]!t\u0015\u00064\u0018-T1q+\u0019\t\u0019%!\u0014\u0002RQ!\u0011QIA+!\u001da\u0013qIA&\u0003\u001fJ1!!\u0013.\u0005\ri\u0015\r\u001d\t\u0004i\u00055C!\u0002\u001c\f\u0005\u00049\u0004c\u0001\u001b\u0002R\u00111\u00111K\u0006C\u0002]\u0012\u0011A\u0011\u0005\b\u0003/Z\u0001\u0019AA-\u0003\u0005i\u0007cB9\u0002\\\u0005-\u0013qJ\u0005\u0004\u0003\u0013\u0012\u0018\u0001\t3faJ,7-\u0019;fI\u0012*\b\u0007\r\u001a1CNT\u0015M^1ES\u000e$\u0018n\u001c8bef,b!!\u0019\u0002l\u0005=D\u0003BA2\u0003c\u0002r\u0001LA3\u0003S\ni'C\u0002\u0002h5\u0012!\u0002R5di&|g.\u0019:z!\r!\u00141\u000e\u0003\u0006m1\u0011\ra\u000e\t\u0004i\u0005=DABA*\u0019\t\u0007q\u0007C\u0004\u0002X1\u0001\r!a\u001d\u0011\u000fE\fY&!\u001b\u0002n\u0005aB-\u001a9sK\u000e\fG/\u001a3%kB\u0002$\u0007M7ba\u0006\u001b(*\u0019<b\u001b\u0006\u0004XCBA=\u0003\u007f\n\u0019\t\u0006\u0003\u0002|\u0005\u0015\u0005c\u0002\u0017\u0002H\u0005u\u0014\u0011\u0011\t\u0004i\u0005}D!\u0002\u001c\u000e\u0005\u00049\u0004c\u0001\u001b\u0002\u0004\u00121\u00111K\u0007C\u0002]Bq!a\u0016\u000e\u0001\u0004\t9\tE\u0004B\u0003\u0013\u000bi(!!\n\u0007\u0005%S#\u0001\u0014eKB\u0014XmY1uK\u0012$S\u000f\r\u00193a5\f\u0007/Q:KCZ\f7i\u001c8dkJ\u0014XM\u001c;NCB,b!a$\u0002 \u0006\rF\u0003BAI\u0003K\u0003\u0002\"a%\u0002\u001a\u0006u\u0015\u0011U\u0007\u0003\u0003+S1!a&.\u0003)\u0019wN\\2veJ,g\u000e^\u0005\u0005\u00037\u000b)JA\u0007D_:\u001cWO\u001d:f]Rl\u0015\r\u001d\t\u0004i\u0005}E!\u0002\u001c\u000f\u0005\u00049\u0004c\u0001\u001b\u0002$\u00121\u00111\u000b\bC\u0002]Bq!a\u0016\u000f\u0001\u0004\t9\u000b\u0005\u0005\u0002*\u00065\u0016QTAQ\u001b\t\tYKC\u0002\u0002\u0018VIA!!\u0013\u0002,\":\u0001!!-\u00028\u0006m\u0006c\u0001\u000f\u00024&\u0019\u0011QW\f\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0002:\u0006qSo]3!\u0015\u00064\u0018mQ8om\u0016\u0014H/\u001a:tA=\u0014\beY8og&$WM\u001d\u0011U_*\u000bg/Y%na2L7-\u001b;tC\t\ti,\u0001\u00043]E\u0012d\u0006M\u0001\u000b/J\f\u0007/Q:KCZ\f\u0007C\u0001\u0011\u0011'\u0011\u00012$!2\u0011\u0005\u0001\u0002\u0011A\u0002\u001fj]&$h\b\u0006\u0002\u0002B\":\u0001#!-\u0002N\u0006m\u0016EAAh\u0003a*8/\u001a\u0011KCZ\f7i\u001c8wKJ$XM]:!_J\u00043m\u001c8tS\u0012,'\u000fI%na2L7-\u001b;D_:4XM]:j_:\u001cHk\u001c&bm\u0006Ds\u0001EAY\u0003o\u000bY\fK\u0004\u0010\u0003c\u000bi-a/")
public interface WrapAsJava
extends LowPriorityWrapAsJava {
    public static /* synthetic */ java.util.Iterator deprecated$u0020asJavaIterator$(WrapAsJava $this, Iterator it) {
        return $this.deprecated$u0020asJavaIterator(it);
    }

    default public <A> java.util.Iterator<A> deprecated$u0020asJavaIterator(Iterator<A> it) {
        return this.asJavaIterator(it);
    }

    public static /* synthetic */ Enumeration deprecated$u0020asJavaEnumeration$(WrapAsJava $this, Iterator it) {
        return $this.deprecated$u0020asJavaEnumeration(it);
    }

    default public <A> Enumeration<A> deprecated$u0020asJavaEnumeration(Iterator<A> it) {
        return this.asJavaEnumeration(it);
    }

    public static /* synthetic */ java.lang.Iterable deprecated$u0020asJavaIterable$(WrapAsJava $this, Iterable i) {
        return $this.deprecated$u0020asJavaIterable(i);
    }

    default public <A> java.lang.Iterable<A> deprecated$u0020asJavaIterable(Iterable<A> i) {
        return this.asJavaIterable(i);
    }

    public static /* synthetic */ Collection deprecated$u0020asJavaCollection$(WrapAsJava $this, Iterable it) {
        return $this.deprecated$u0020asJavaCollection(it);
    }

    default public <A> Collection<A> deprecated$u0020asJavaCollection(Iterable<A> it) {
        return this.asJavaCollection(it);
    }

    public static /* synthetic */ List deprecated$u0020bufferAsJavaList$(WrapAsJava $this, Buffer b) {
        return $this.deprecated$u0020bufferAsJavaList(b);
    }

    default public <A> List<A> deprecated$u0020bufferAsJavaList(Buffer<A> b) {
        return this.bufferAsJavaList(b);
    }

    public static /* synthetic */ List deprecated$u0020mutableSeqAsJavaList$(WrapAsJava $this, scala.collection.mutable.Seq seq) {
        return $this.deprecated$u0020mutableSeqAsJavaList(seq);
    }

    default public <A> List<A> deprecated$u0020mutableSeqAsJavaList(scala.collection.mutable.Seq<A> seq) {
        return this.mutableSeqAsJavaList(seq);
    }

    public static /* synthetic */ List deprecated$u0020seqAsJavaList$(WrapAsJava $this, Seq seq) {
        return $this.deprecated$u0020seqAsJavaList(seq);
    }

    default public <A> List<A> deprecated$u0020seqAsJavaList(Seq<A> seq) {
        return this.seqAsJavaList(seq);
    }

    public static /* synthetic */ java.util.Set deprecated$u0020mutableSetAsJavaSet$(WrapAsJava $this, scala.collection.mutable.Set s) {
        return $this.deprecated$u0020mutableSetAsJavaSet(s);
    }

    default public <A> java.util.Set<A> deprecated$u0020mutableSetAsJavaSet(scala.collection.mutable.Set<A> s) {
        return this.mutableSetAsJavaSet(s);
    }

    public static /* synthetic */ java.util.Set deprecated$u0020setAsJavaSet$(WrapAsJava $this, Set s) {
        return $this.deprecated$u0020setAsJavaSet(s);
    }

    default public <A> java.util.Set<A> deprecated$u0020setAsJavaSet(Set<A> s) {
        return this.setAsJavaSet(s);
    }

    public static /* synthetic */ java.util.Map deprecated$u0020mutableMapAsJavaMap$(WrapAsJava $this, scala.collection.mutable.Map m) {
        return $this.deprecated$u0020mutableMapAsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> deprecated$u0020mutableMapAsJavaMap(scala.collection.mutable.Map<A, B> m) {
        return this.mutableMapAsJavaMap(m);
    }

    public static /* synthetic */ Dictionary deprecated$u0020asJavaDictionary$(WrapAsJava $this, scala.collection.mutable.Map m) {
        return $this.deprecated$u0020asJavaDictionary(m);
    }

    default public <A, B> Dictionary<A, B> deprecated$u0020asJavaDictionary(scala.collection.mutable.Map<A, B> m) {
        return this.asJavaDictionary(m);
    }

    public static /* synthetic */ java.util.Map deprecated$u0020mapAsJavaMap$(WrapAsJava $this, Map m) {
        return $this.deprecated$u0020mapAsJavaMap(m);
    }

    default public <A, B> java.util.Map<A, B> deprecated$u0020mapAsJavaMap(Map<A, B> m) {
        return this.mapAsJavaMap(m);
    }

    public static /* synthetic */ ConcurrentMap deprecated$u0020mapAsJavaConcurrentMap$(WrapAsJava $this, scala.collection.concurrent.Map m) {
        return $this.deprecated$u0020mapAsJavaConcurrentMap(m);
    }

    default public <A, B> ConcurrentMap<A, B> deprecated$u0020mapAsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        return this.mapAsJavaConcurrentMap(m);
    }

    public static void $init$(WrapAsJava $this) {
    }
}

