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
import scala.collection.convert.Wrappers;
import scala.collection.convert.Wrappers$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Map;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005=da\u0002\u0007\u000e!\u0003\r\t\u0001\u0006\u0005\u00063\u0001!\tA\u0007\u0005\u0006=\u0001!\ta\b\u0005\u0006s\u0001!\tA\u000f\u0005\u0006\u0007\u0002!\t\u0001\u0012\u0005\u0006#\u0002!\tA\u0015\u0005\u00067\u0002!\t\u0001\u0018\u0005\u0006W\u0002!\t\u0001\u001c\u0005\u0006o\u0002!\t\u0001\u001f\u0005\b\u0003\u001b\u0001A\u0011AA\b\u0011\u001d\t\t\u0004\u0001C\u0001\u0003gAq!a\u0013\u0001\t\u0003\tiEA\tBgN\u001b\u0017\r\\1D_:4XM\u001d;feNT!AD\b\u0002\u000f\r|gN^3si*\u0011\u0001#E\u0001\u000bG>dG.Z2uS>t'\"\u0001\n\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001!\u0006\t\u0003-]i\u0011!E\u0005\u00031E\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001\u001c!\t1B$\u0003\u0002\u001e#\t!QK\\5u\u0003=\t7oU2bY\u0006LE/\u001a:bi>\u0014XC\u0001\u0011()\t\t\u0003\u0007E\u0002#G\u0015j\u0011aD\u0005\u0003I=\u0011\u0001\"\u0013;fe\u0006$xN\u001d\t\u0003M\u001db\u0001\u0001B\u0003)\u0005\t\u0007\u0011FA\u0001B#\tQS\u0006\u0005\u0002\u0017W%\u0011A&\u0005\u0002\b\u001d>$\b.\u001b8h!\t1b&\u0003\u00020#\t\u0019\u0011I\\=\t\u000bE\u0012\u0001\u0019\u0001\u001a\u0002\u0003%\u00042a\r\u001d&\u001b\u0005!$BA\u001b7\u0003\u0011)H/\u001b7\u000b\u0003]\nAA[1wC&\u0011A\u0005N\u0001\u001bK:,X.\u001a:bi&|g.Q:TG\u0006d\u0017-\u0013;fe\u0006$xN]\u000b\u0003wy\"\"\u0001P \u0011\u0007\t\u001aS\b\u0005\u0002'}\u0011)\u0001f\u0001b\u0001S!)\u0011g\u0001a\u0001\u0001B\u00191'Q\u001f\n\u0005\t#$aC#ok6,'/\u0019;j_:\fq#\u001b;fe\u0006\u0014G.Z!t'\u000e\fG.Y%uKJ\f'\r\\3\u0016\u0005\u0015SEC\u0001$L!\r\u0011s)S\u0005\u0003\u0011>\u0011\u0001\"\u0013;fe\u0006\u0014G.\u001a\t\u0003M)#Q\u0001\u000b\u0003C\u0002%BQ!\r\u0003A\u00021\u00032!\u0014)J\u001b\u0005q%BA(7\u0003\u0011a\u0017M\\4\n\u0005!s\u0015!G2pY2,7\r^5p]\u0006\u001b8kY1mC&#XM]1cY\u0016,\"a\u0015,\u0015\u0005Q;\u0006c\u0001\u0012H+B\u0011aE\u0016\u0003\u0006Q\u0015\u0011\r!\u000b\u0005\u0006c\u0015\u0001\r\u0001\u0017\t\u0004ge+\u0016B\u0001.5\u0005)\u0019u\u000e\u001c7fGRLwN\\\u0001\u000eCN\u001c6-\u00197b\u0005V4g-\u001a:\u0016\u0005u+GC\u00010g!\ry&\rZ\u0007\u0002A*\u0011\u0011mD\u0001\b[V$\u0018M\u00197f\u0013\t\u0019\u0007M\u0001\u0004Ck\u001a4WM\u001d\t\u0003M\u0015$Q\u0001\u000b\u0004C\u0002%BQa\u001a\u0004A\u0002!\f\u0011\u0001\u001c\t\u0004g%$\u0017B\u000165\u0005\u0011a\u0015n\u001d;\u0002\u0015\u0005\u001c8kY1mCN+G/\u0006\u0002neR\u0011an\u001d\t\u0004?>\f\u0018B\u00019a\u0005\r\u0019V\r\u001e\t\u0003MI$Q\u0001K\u0004C\u0002%BQ\u0001^\u0004A\u0002U\f\u0011a\u001d\t\u0004gY\f\u0018B\u000195\u00035i\u0017\r]!t'\u000e\fG.Y'baV!\u0011P`A\u0001)\rQ\u0018Q\u0001\t\u0005?nlx0\u0003\u0002}A\n\u0019Q*\u00199\u0011\u0005\u0019rH!\u0002\u0015\t\u0005\u0004I\u0003c\u0001\u0014\u0002\u0002\u00111\u00111\u0001\u0005C\u0002%\u0012\u0011A\u0011\u0005\b\u0003\u000fA\u0001\u0019AA\u0005\u0003\u0005i\u0007#B\u001a\u0002\fu|\u0018B\u0001?5\u0003]i\u0017\r]!t'\u000e\fG.Y\"p]\u000e,(O]3oi6\u000b\u0007/\u0006\u0004\u0002\u0012\u0005}\u00111\u0005\u000b\u0005\u0003'\t)\u0003\u0005\u0005\u0002\u0016\u0005m\u0011QDA\u0011\u001b\t\t9BC\u0002\u0002\u001a=\t!bY8oGV\u0014(/\u001a8u\u0013\ra\u0018q\u0003\t\u0004M\u0005}A!\u0002\u0015\n\u0005\u0004I\u0003c\u0001\u0014\u0002$\u00111\u00111A\u0005C\u0002%Bq!a\u0002\n\u0001\u0004\t9\u0003\u0005\u0005\u0002*\u00055\u0012QDA\u0011\u001b\t\tYCC\u0002\u0002\u001aQJA!a\f\u0002,\ti1i\u001c8dkJ\u0014XM\u001c;NCB\fA\u0003Z5di&|g.\u0019:z\u0003N\u001c6-\u00197b\u001b\u0006\u0004XCBA\u001b\u0003w\ty\u0004\u0006\u0003\u00028\u0005\u0005\u0003CB0|\u0003s\ti\u0004E\u0002'\u0003w!Q\u0001\u000b\u0006C\u0002%\u00022AJA \t\u0019\t\u0019A\u0003b\u0001S!9\u00111\t\u0006A\u0002\u0005\u0015\u0013!\u00019\u0011\u000fM\n9%!\u000f\u0002>%\u0019\u0011\u0011\n\u001b\u0003\u0015\u0011K7\r^5p]\u0006\u0014\u00180\u0001\u000bqe>\u0004XM\u001d;jKN\f5oU2bY\u0006l\u0015\r\u001d\u000b\u0005\u0003\u001f\n9\u0007\u0005\u0004`w\u0006E\u0013\u0011\u000b\t\u0005\u0003'\n\tG\u0004\u0003\u0002V\u0005u\u0003cAA,#5\u0011\u0011\u0011\f\u0006\u0004\u00037\u001a\u0012A\u0002\u001fs_>$h(C\u0002\u0002`E\ta\u0001\u0015:fI\u00164\u0017\u0002BA2\u0003K\u0012aa\u0015;sS:<'bAA0#!9\u00111I\u0006A\u0002\u0005%\u0004cA\u001a\u0002l%\u0019\u0011Q\u000e\u001b\u0003\u0015A\u0013x\u000e]3si&,7\u000f")
public interface AsScalaConverters {
    public static /* synthetic */ Iterator asScalaIterator$(AsScalaConverters $this, java.util.Iterator i) {
        return $this.asScalaIterator(i);
    }

    default public <A> Iterator<A> asScalaIterator(java.util.Iterator<A> i) {
        Iterator<A> iterator2 = i == null ? null : (i instanceof Wrappers.IteratorWrapper && ((Wrappers.IteratorWrapper)i).scala$collection$convert$Wrappers$IteratorWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IteratorWrapper)i).underlying() : new Wrappers.JIteratorWrapper<A>(Wrappers$.MODULE$, i));
        return iterator2;
    }

    public static /* synthetic */ Iterator enumerationAsScalaIterator$(AsScalaConverters $this, Enumeration i) {
        return $this.enumerationAsScalaIterator(i);
    }

    default public <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> i) {
        Iterator<A> iterator2 = i == null ? null : (i instanceof Wrappers.IteratorWrapper && ((Wrappers.IteratorWrapper)i).scala$collection$convert$Wrappers$IteratorWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IteratorWrapper)i).underlying() : new Wrappers.JEnumerationWrapper<A>(Wrappers$.MODULE$, i));
        return iterator2;
    }

    public static /* synthetic */ Iterable iterableAsScalaIterable$(AsScalaConverters $this, java.lang.Iterable i) {
        return $this.iterableAsScalaIterable(i);
    }

    default public <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> i) {
        Iterable<A> iterable = i == null ? null : (i instanceof Wrappers.IterableWrapper && ((Wrappers.IterableWrapper)i).scala$collection$convert$Wrappers$IterableWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IterableWrapper)i).underlying() : new Wrappers.JIterableWrapper<A>(Wrappers$.MODULE$, i));
        return iterable;
    }

    public static /* synthetic */ Iterable collectionAsScalaIterable$(AsScalaConverters $this, Collection i) {
        return $this.collectionAsScalaIterable(i);
    }

    default public <A> Iterable<A> collectionAsScalaIterable(Collection<A> i) {
        Iterable<A> iterable = i == null ? null : (i instanceof Wrappers.IterableWrapper && ((Wrappers.IterableWrapper)i).scala$collection$convert$Wrappers$IterableWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IterableWrapper)i).underlying() : new Wrappers.JCollectionWrapper<A>(Wrappers$.MODULE$, i));
        return iterable;
    }

    public static /* synthetic */ Buffer asScalaBuffer$(AsScalaConverters $this, List l) {
        return $this.asScalaBuffer(l);
    }

    default public <A> Buffer<A> asScalaBuffer(List<A> l) {
        Iterable<A> iterable = l == null ? null : (l instanceof Wrappers.MutableBufferWrapper && ((Wrappers.MutableBufferWrapper)l).scala$collection$convert$Wrappers$MutableBufferWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.MutableBufferWrapper)l).underlying() : new Wrappers.JListWrapper<A>(Wrappers$.MODULE$, l));
        return iterable;
    }

    public static /* synthetic */ scala.collection.mutable.Set asScalaSet$(AsScalaConverters $this, Set s) {
        return $this.asScalaSet(s);
    }

    default public <A> scala.collection.mutable.Set<A> asScalaSet(Set<A> s) {
        scala.collection.mutable.Set<A> set = s == null ? null : (s instanceof Wrappers.MutableSetWrapper && ((Wrappers.MutableSetWrapper)s).scala$collection$convert$Wrappers$MutableSetWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.MutableSetWrapper)s).underlying() : new Wrappers.JSetWrapper<A>(Wrappers$.MODULE$, s));
        return set;
    }

    public static /* synthetic */ Map mapAsScalaMap$(AsScalaConverters $this, java.util.Map m) {
        return $this.mapAsScalaMap(m);
    }

    default public <A, B> Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
        Map<A, B> map = m == null ? null : (m instanceof Wrappers.MutableMapWrapper && ((Wrappers.MutableMapWrapper)m).scala$collection$convert$Wrappers$MutableMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.MutableMapWrapper)m).underlying() : new Wrappers.JMapWrapper<A, B>(Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ scala.collection.concurrent.Map mapAsScalaConcurrentMap$(AsScalaConverters $this, ConcurrentMap m) {
        return $this.mapAsScalaConcurrentMap(m);
    }

    default public <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
        Map<Object, Object> map = m == null ? null : (m instanceof Wrappers.ConcurrentMapWrapper && ((Wrappers.ConcurrentMapWrapper)m).scala$collection$convert$Wrappers$ConcurrentMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.ConcurrentMapWrapper)m).underlying() : new Wrappers.JConcurrentMapWrapper<A, B>(Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ Map dictionaryAsScalaMap$(AsScalaConverters $this, Dictionary p) {
        return $this.dictionaryAsScalaMap(p);
    }

    default public <A, B> Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> p) {
        Map<A, B> map = p == null ? null : (p instanceof Wrappers.DictionaryWrapper && ((Wrappers.DictionaryWrapper)p).scala$collection$convert$Wrappers$DictionaryWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.DictionaryWrapper)p).underlying() : new Wrappers.JDictionaryWrapper<A, B>(Wrappers$.MODULE$, p));
        return map;
    }

    public static /* synthetic */ Map propertiesAsScalaMap$(AsScalaConverters $this, Properties p) {
        return $this.propertiesAsScalaMap(p);
    }

    default public Map<String, String> propertiesAsScalaMap(Properties p) {
        Wrappers.JPropertiesWrapper jPropertiesWrapper = p == null ? null : new Wrappers.JPropertiesWrapper(Wrappers$.MODULE$, p);
        return jPropertiesWrapper;
    }

    public static void $init$(AsScalaConverters $this) {
    }
}

