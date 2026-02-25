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

@ScalaSignature(bytes="\u0006\u0001\u0005Ed\u0001\u0003\u0007\u000e!\u0003\r\t!D\n\t\u000ba\u0001A\u0011\u0001\u000e\t\u000by\u0001A1A\u0010\t\u000be\u0002A1\u0001\u001e\t\u000b\u0011\u0003A1A#\t\u000bI\u0003A1A*\t\u000bq\u0003A1A/\t\u000b1\u0004A1A7\t\u000ba\u0004A1A=\t\u000f\u0005=\u0001\u0001b\u0001\u0002\u0012!9\u00111\u0007\u0001\u0005\u0004\u0005U\u0002bBA'\u0001\u0011\r\u0011q\n\u0002\u0017\u0019><\bK]5pe&$\u0018p\u0016:ba\u0006\u001b8kY1mC*\u0011abD\u0001\bG>tg/\u001a:u\u0015\t\u0001\u0012#\u0001\u0006d_2dWm\u0019;j_:T\u0011AE\u0001\u0006g\u000e\fG.Y\n\u0003\u0001Q\u0001\"!\u0006\f\u000e\u0003EI!aF\t\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uI\r\u0001A#A\u000e\u0011\u0005Ua\u0012BA\u000f\u0012\u0005\u0011)f.\u001b;\u0002\u001f\u0005\u001c8kY1mC&#XM]1u_J,\"\u0001I\u0014\u0015\u0005\u0005\u0002\u0004c\u0001\u0012$K5\tq\"\u0003\u0002%\u001f\tA\u0011\n^3sCR|'\u000f\u0005\u0002'O1\u0001A!\u0002\u0015\u0003\u0005\u0004I#!A!\u0012\u0005)j\u0003CA\u000b,\u0013\ta\u0013CA\u0004O_RD\u0017N\\4\u0011\u0005Uq\u0013BA\u0018\u0012\u0005\r\te.\u001f\u0005\u0006c\t\u0001\rAM\u0001\u0003SR\u00042a\r\u001d&\u001b\u0005!$BA\u001b7\u0003\u0011)H/\u001b7\u000b\u0003]\nAA[1wC&\u0011A\u0005N\u0001\u001bK:,X.\u001a:bi&|g.Q:TG\u0006d\u0017-\u0013;fe\u0006$xN]\u000b\u0003wy\"\"\u0001P \u0011\u0007\t\u001aS\b\u0005\u0002'}\u0011)\u0001f\u0001b\u0001S!)\u0001i\u0001a\u0001\u0003\u0006\t\u0011\u000eE\u00024\u0005vJ!a\u0011\u001b\u0003\u0017\u0015sW/\\3sCRLwN\\\u0001\u0018SR,'/\u00192mK\u0006\u001b8kY1mC&#XM]1cY\u0016,\"AR&\u0015\u0005\u001dc\u0005c\u0001\u0012I\u0015&\u0011\u0011j\u0004\u0002\t\u0013R,'/\u00192mKB\u0011ae\u0013\u0003\u0006Q\u0011\u0011\r!\u000b\u0005\u0006\u0001\u0012\u0001\r!\u0014\t\u0004\u001dFSU\"A(\u000b\u0005A3\u0014\u0001\u00027b]\u001eL!!S(\u00023\r|G\u000e\\3di&|g.Q:TG\u0006d\u0017-\u0013;fe\u0006\u0014G.Z\u000b\u0003)^#\"!\u0016-\u0011\u0007\tBe\u000b\u0005\u0002'/\u0012)\u0001&\u0002b\u0001S!)\u0001)\u0002a\u00013B\u00191G\u0017,\n\u0005m#$AC\"pY2,7\r^5p]\u0006i\u0011m]*dC2\f')\u001e4gKJ,\"A\u00184\u0015\u0005};\u0007c\u00011dK6\t\u0011M\u0003\u0002c\u001f\u00059Q.\u001e;bE2,\u0017B\u00013b\u0005\u0019\u0011UO\u001a4feB\u0011aE\u001a\u0003\u0006Q\u0019\u0011\r!\u000b\u0005\u0006Q\u001a\u0001\r![\u0001\u0002YB\u00191G[3\n\u0005-$$\u0001\u0002'jgR\f!\"Y:TG\u0006d\u0017mU3u+\tq7\u000f\u0006\u0002piB\u0019\u0001\r\u001d:\n\u0005E\f'aA*fiB\u0011ae\u001d\u0003\u0006Q\u001d\u0011\r!\u000b\u0005\u0006k\u001e\u0001\rA^\u0001\u0002gB\u00191g\u001e:\n\u0005E$\u0014!D7ba\u0006\u001b8kY1mC6\u000b\u0007/\u0006\u0003{\u007f\u0006\rAcA>\u0002\bA)\u0001\r @\u0002\u0002%\u0011Q0\u0019\u0002\u0004\u001b\u0006\u0004\bC\u0001\u0014\u0000\t\u0015A\u0003B1\u0001*!\r1\u00131\u0001\u0003\u0007\u0003\u000bA!\u0019A\u0015\u0003\u0003\tCq!!\u0003\t\u0001\u0004\tY!A\u0001n!\u0019\u0019\u0014Q\u0002@\u0002\u0002%\u0011Q\u0010N\u0001\u0018[\u0006\u0004\u0018i]*dC2\f7i\u001c8dkJ\u0014XM\u001c;NCB,b!a\u0005\u0002\"\u0005\u0015B\u0003BA\u000b\u0003O\u0001\u0002\"a\u0006\u0002\u001e\u0005}\u00111E\u0007\u0003\u00033Q1!a\u0007\u0010\u0003)\u0019wN\\2veJ,g\u000e^\u0005\u0004{\u0006e\u0001c\u0001\u0014\u0002\"\u0011)\u0001&\u0003b\u0001SA\u0019a%!\n\u0005\r\u0005\u0015\u0011B1\u0001*\u0011\u001d\tI!\u0003a\u0001\u0003S\u0001\u0002\"a\u000b\u00020\u0005}\u00111E\u0007\u0003\u0003[Q1!a\u00075\u0013\u0011\t\t$!\f\u0003\u001b\r{gnY;se\u0016tG/T1q\u0003Q!\u0017n\u0019;j_:\f'/_!t'\u000e\fG.Y'baV1\u0011qGA\u001f\u0003\u0003\"B!!\u000f\u0002DA1\u0001\r`A\u001e\u0003\u007f\u00012AJA\u001f\t\u0015A#B1\u0001*!\r1\u0013\u0011\t\u0003\u0007\u0003\u000bQ!\u0019A\u0015\t\u000f\u0005\u0015#\u00021\u0001\u0002H\u0005\t\u0001\u000fE\u00044\u0003\u0013\nY$a\u0010\n\u0007\u0005-CG\u0001\u0006ES\u000e$\u0018n\u001c8bef\fA\u0003\u001d:pa\u0016\u0014H/[3t\u0003N\u001c6-\u00197b\u001b\u0006\u0004H\u0003BA)\u0003S\u0002b\u0001\u0019?\u0002T\u0005M\u0003\u0003BA+\u0003GrA!a\u0016\u0002`A\u0019\u0011\u0011L\t\u000e\u0005\u0005m#bAA/3\u00051AH]8pizJ1!!\u0019\u0012\u0003\u0019\u0001&/\u001a3fM&!\u0011QMA4\u0005\u0019\u0019FO]5oO*\u0019\u0011\u0011M\t\t\u000f\u0005\u00153\u00021\u0001\u0002lA\u00191'!\u001c\n\u0007\u0005=DG\u0001\u0006Qe>\u0004XM\u001d;jKN\u0004")
public interface LowPriorityWrapAsScala {
    public static /* synthetic */ Iterator asScalaIterator$(LowPriorityWrapAsScala $this, java.util.Iterator it) {
        return $this.asScalaIterator(it);
    }

    default public <A> Iterator<A> asScalaIterator(java.util.Iterator<A> it) {
        Iterator<A> iterator2 = it == null ? null : (it instanceof Wrappers.IteratorWrapper && ((Wrappers.IteratorWrapper)it).scala$collection$convert$Wrappers$IteratorWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IteratorWrapper)it).underlying() : new Wrappers.JIteratorWrapper<A>(Wrappers$.MODULE$, it));
        return iterator2;
    }

    public static /* synthetic */ Iterator enumerationAsScalaIterator$(LowPriorityWrapAsScala $this, Enumeration i) {
        return $this.enumerationAsScalaIterator(i);
    }

    default public <A> Iterator<A> enumerationAsScalaIterator(Enumeration<A> i) {
        Iterator<A> iterator2 = i == null ? null : (i instanceof Wrappers.IteratorWrapper && ((Wrappers.IteratorWrapper)i).scala$collection$convert$Wrappers$IteratorWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IteratorWrapper)i).underlying() : new Wrappers.JEnumerationWrapper<A>(Wrappers$.MODULE$, i));
        return iterator2;
    }

    public static /* synthetic */ Iterable iterableAsScalaIterable$(LowPriorityWrapAsScala $this, java.lang.Iterable i) {
        return $this.iterableAsScalaIterable(i);
    }

    default public <A> Iterable<A> iterableAsScalaIterable(java.lang.Iterable<A> i) {
        Iterable<A> iterable = i == null ? null : (i instanceof Wrappers.IterableWrapper && ((Wrappers.IterableWrapper)i).scala$collection$convert$Wrappers$IterableWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IterableWrapper)i).underlying() : new Wrappers.JIterableWrapper<A>(Wrappers$.MODULE$, i));
        return iterable;
    }

    public static /* synthetic */ Iterable collectionAsScalaIterable$(LowPriorityWrapAsScala $this, Collection i) {
        return $this.collectionAsScalaIterable(i);
    }

    default public <A> Iterable<A> collectionAsScalaIterable(Collection<A> i) {
        Iterable<A> iterable = i == null ? null : (i instanceof Wrappers.IterableWrapper && ((Wrappers.IterableWrapper)i).scala$collection$convert$Wrappers$IterableWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.IterableWrapper)i).underlying() : new Wrappers.JCollectionWrapper<A>(Wrappers$.MODULE$, i));
        return iterable;
    }

    public static /* synthetic */ Buffer asScalaBuffer$(LowPriorityWrapAsScala $this, List l) {
        return $this.asScalaBuffer(l);
    }

    default public <A> Buffer<A> asScalaBuffer(List<A> l) {
        Iterable<A> iterable = l == null ? null : (l instanceof Wrappers.MutableBufferWrapper && ((Wrappers.MutableBufferWrapper)l).scala$collection$convert$Wrappers$MutableBufferWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.MutableBufferWrapper)l).underlying() : new Wrappers.JListWrapper<A>(Wrappers$.MODULE$, l));
        return iterable;
    }

    public static /* synthetic */ scala.collection.mutable.Set asScalaSet$(LowPriorityWrapAsScala $this, Set s) {
        return $this.asScalaSet(s);
    }

    default public <A> scala.collection.mutable.Set<A> asScalaSet(Set<A> s) {
        scala.collection.mutable.Set<A> set = s == null ? null : (s instanceof Wrappers.MutableSetWrapper && ((Wrappers.MutableSetWrapper)s).scala$collection$convert$Wrappers$MutableSetWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.MutableSetWrapper)s).underlying() : new Wrappers.JSetWrapper<A>(Wrappers$.MODULE$, s));
        return set;
    }

    public static /* synthetic */ Map mapAsScalaMap$(LowPriorityWrapAsScala $this, java.util.Map m) {
        return $this.mapAsScalaMap(m);
    }

    default public <A, B> Map<A, B> mapAsScalaMap(java.util.Map<A, B> m) {
        Map<A, B> map = m == null ? null : (m instanceof Wrappers.MutableMapWrapper && ((Wrappers.MutableMapWrapper)m).scala$collection$convert$Wrappers$MutableMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.MutableMapWrapper)m).underlying() : new Wrappers.JMapWrapper<A, B>(Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ scala.collection.concurrent.Map mapAsScalaConcurrentMap$(LowPriorityWrapAsScala $this, ConcurrentMap m) {
        return $this.mapAsScalaConcurrentMap(m);
    }

    default public <A, B> scala.collection.concurrent.Map<A, B> mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
        Map<Object, Object> map = m == null ? null : (m instanceof Wrappers.ConcurrentMapWrapper && ((Wrappers.ConcurrentMapWrapper)m).scala$collection$convert$Wrappers$ConcurrentMapWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.ConcurrentMapWrapper)m).underlying() : new Wrappers.JConcurrentMapWrapper<A, B>(Wrappers$.MODULE$, m));
        return map;
    }

    public static /* synthetic */ Map dictionaryAsScalaMap$(LowPriorityWrapAsScala $this, Dictionary p) {
        return $this.dictionaryAsScalaMap(p);
    }

    default public <A, B> Map<A, B> dictionaryAsScalaMap(Dictionary<A, B> p) {
        Map<A, B> map = p == null ? null : (p instanceof Wrappers.DictionaryWrapper && ((Wrappers.DictionaryWrapper)p).scala$collection$convert$Wrappers$DictionaryWrapper$$$outer() == Wrappers$.MODULE$ ? ((Wrappers.DictionaryWrapper)p).underlying() : new Wrappers.JDictionaryWrapper<A, B>(Wrappers$.MODULE$, p));
        return map;
    }

    public static /* synthetic */ Map propertiesAsScalaMap$(LowPriorityWrapAsScala $this, Properties p) {
        return $this.propertiesAsScalaMap(p);
    }

    default public Map<String, String> propertiesAsScalaMap(Properties p) {
        Wrappers.JPropertiesWrapper jPropertiesWrapper = p == null ? null : new Wrappers.JPropertiesWrapper(Wrappers$.MODULE$, p);
        return jPropertiesWrapper;
    }

    public static void $init$(LowPriorityWrapAsScala $this) {
    }
}

