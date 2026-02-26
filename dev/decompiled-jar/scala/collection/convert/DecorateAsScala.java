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
import scala.Function0;
import scala.Serializable;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.convert.AsScalaConverters;
import scala.collection.convert.Decorators;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Map;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005]ea\u0002\u0007\u000e!\u0003\r\t\u0001\u0006\u0005\u0006;\u0001!\tA\b\u0005\u0006E\u0001!\u0019a\t\u0005\u0006\t\u0002!\u0019!\u0012\u0005\u0006\u001f\u0002!\u0019\u0001\u0015\u0005\u0006=\u0002!\u0019a\u0018\u0005\u0006S\u0002!\u0019A\u001b\u0005\u0006u\u0002!\u0019a\u001f\u0005\b\u0003\u001f\u0001A1AA\t\u0011\u001d\ty\u0003\u0001C\u0002\u0003cAq!!\u0016\u0001\t\u0007\t9\u0006C\u0004\u0002r\u0001!\u0019!a\u001d\u0003\u001f\u0011+7m\u001c:bi\u0016\f5oU2bY\u0006T!AD\b\u0002\u000f\r|gN^3si*\u0011\u0001#E\u0001\u000bG>dG.Z2uS>t'\"\u0001\n\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001!F\r\u0011\u0005Y9R\"A\t\n\u0005a\t\"AB!osJ+g\r\u0005\u0002\u001b75\tQ\"\u0003\u0002\u001d\u001b\t\t\u0012i]*dC2\f7i\u001c8wKJ$XM]:\u0002\r\u0011Jg.\u001b;%)\u0005y\u0002C\u0001\f!\u0013\t\t\u0013C\u0001\u0003V]&$\u0018\u0001G1t'\u000e\fG.Y%uKJ\fGo\u001c:D_:4XM\u001d;feV\u0011AE\r\u000b\u0003Km\u00022AJ\u0015-\u001d\tQr%\u0003\u0002)\u001b\u0005QA)Z2pe\u0006$xN]:\n\u0005)Z#aB!t'\u000e\fG.\u0019\u0006\u0003Q5\u00012!\f\u00181\u001b\u0005y\u0011BA\u0018\u0010\u0005!IE/\u001a:bi>\u0014\bCA\u00193\u0019\u0001!Qa\r\u0002C\u0002Q\u0012\u0011!Q\t\u0003ka\u0002\"A\u0006\u001c\n\u0005]\n\"a\u0002(pi\"Lgn\u001a\t\u0003-eJ!AO\t\u0003\u0007\u0005s\u0017\u0010C\u0003=\u0005\u0001\u0007Q(A\u0001j!\rq4\tM\u0007\u0002\u007f)\u0011\u0001)Q\u0001\u0005kRLGNC\u0001C\u0003\u0011Q\u0017M^1\n\u0005=z\u0014aI3ok6,'/\u0019;j_:\f5oU2bY\u0006LE/\u001a:bi>\u00148i\u001c8wKJ$XM]\u000b\u0003\r*#\"aR&\u0011\u0007\u0019J\u0003\nE\u0002.]%\u0003\"!\r&\u0005\u000bM\u001a!\u0019\u0001\u001b\t\u000bq\u001a\u0001\u0019\u0001'\u0011\u0007yj\u0015*\u0003\u0002O\u007f\tYQI\\;nKJ\fG/[8o\u0003\u0001JG/\u001a:bE2,\u0017i]*dC2\f\u0017\n^3sC\ndWmQ8om\u0016\u0014H/\u001a:\u0016\u0005E;FC\u0001*Y!\r1\u0013f\u0015\t\u0004[Q3\u0016BA+\u0010\u0005!IE/\u001a:bE2,\u0007CA\u0019X\t\u0015\u0019DA1\u00015\u0011\u0015aD\u00011\u0001Z!\rQVLV\u0007\u00027*\u0011A,Q\u0001\u0005Y\u0006tw-\u0003\u0002V7\u0006\u00113m\u001c7mK\u000e$\u0018n\u001c8BgN\u001b\u0017\r\\1Ji\u0016\u0014\u0018M\u00197f\u0007>tg/\u001a:uKJ,\"\u0001\u00193\u0015\u0005\u0005,\u0007c\u0001\u0014*EB\u0019Q\u0006V2\u0011\u0005E\"G!B\u001a\u0006\u0005\u0004!\u0004\"\u0002\u001f\u0006\u0001\u00041\u0007c\u0001 hG&\u0011\u0001n\u0010\u0002\u000b\u0007>dG.Z2uS>t\u0017AF1t'\u000e\fG.\u0019\"vM\u001a,'oQ8om\u0016\u0014H/\u001a:\u0016\u0005-$HC\u00017v!\r1\u0013&\u001c\t\u0004]F\u001cX\"A8\u000b\u0005A|\u0011aB7vi\u0006\u0014G.Z\u0005\u0003e>\u0014aAQ;gM\u0016\u0014\bCA\u0019u\t\u0015\u0019dA1\u00015\u0011\u00151h\u00011\u0001x\u0003\u0005a\u0007c\u0001 yg&\u0011\u0011p\u0010\u0002\u0005\u0019&\u001cH/A\nbgN\u001b\u0017\r\\1TKR\u001cuN\u001c<feR,'/F\u0002}\u0003\u000b!2!`A\u0004!\r1\u0013F \t\u0005]~\f\u0019!C\u0002\u0002\u0002=\u00141aU3u!\r\t\u0014Q\u0001\u0003\u0006g\u001d\u0011\r\u0001\u000e\u0005\b\u0003\u00139\u0001\u0019AA\u0006\u0003\u0005\u0019\b#\u0002 \u0002\u000e\u0005\r\u0011bAA\u0001\u007f\u00051R.\u00199BgN\u001b\u0017\r\\1NCB\u001cuN\u001c<feR,'/\u0006\u0004\u0002\u0014\u0005}\u00111\u0005\u000b\u0005\u0003+\t9\u0003\u0005\u0003'S\u0005]\u0001c\u00028\u0002\u001a\u0005u\u0011\u0011E\u0005\u0004\u00037y'aA'baB\u0019\u0011'a\b\u0005\u000bMB!\u0019\u0001\u001b\u0011\u0007E\n\u0019\u0003\u0002\u0004\u0002&!\u0011\r\u0001\u000e\u0002\u0002\u0005\"9\u0011\u0011\u0006\u0005A\u0002\u0005-\u0012!A7\u0011\u000fy\ni#!\b\u0002\"%\u0019\u00111D \u0002A5\f\u0007/Q:TG\u0006d\u0017mQ8oGV\u0014(/\u001a8u\u001b\u0006\u00048i\u001c8wKJ$XM]\u000b\u0007\u0003g\t\u0019%a\u0012\u0015\t\u0005U\u0012\u0011\n\t\u0005M%\n9\u0004\u0005\u0005\u0002:\u0005}\u0012\u0011IA#\u001b\t\tYDC\u0002\u0002>=\t!bY8oGV\u0014(/\u001a8u\u0013\u0011\tY\"a\u000f\u0011\u0007E\n\u0019\u0005B\u00034\u0013\t\u0007A\u0007E\u00022\u0003\u000f\"a!!\n\n\u0005\u0004!\u0004bBA\u0015\u0013\u0001\u0007\u00111\n\t\t\u0003\u001b\n\t&!\u0011\u0002F5\u0011\u0011q\n\u0006\u0004\u0003{y\u0014\u0002BA*\u0003\u001f\u0012QbQ8oGV\u0014(/\u001a8u\u001b\u0006\u0004\u0018!\b3jGRLwN\\1ss\u0006\u001b8kY1mC6\u000b\u0007oQ8om\u0016\u0014H/\u001a:\u0016\r\u0005e\u0013\u0011MA3)\u0011\tY&a\u001a\u0011\t\u0019J\u0013Q\f\t\b]\u0006e\u0011qLA2!\r\t\u0014\u0011\r\u0003\u0006g)\u0011\r\u0001\u000e\t\u0004c\u0005\u0015DABA\u0013\u0015\t\u0007A\u0007C\u0004\u0002j)\u0001\r!a\u001b\u0002\u0003A\u0004rAPA7\u0003?\n\u0019'C\u0002\u0002p}\u0012!\u0002R5di&|g.\u0019:z\u0003u\u0001(o\u001c9feRLWm]!t'\u000e\fG.Y'ba\u000e{gN^3si\u0016\u0014H\u0003BA;\u0003\u001f\u0003BAJ\u0015\u0002xA9a.!\u0007\u0002z\u0005e\u0004\u0003BA>\u0003\u0013sA!! \u0002\u0006B\u0019\u0011qP\t\u000e\u0005\u0005\u0005%bAAB'\u00051AH]8pizJ1!a\"\u0012\u0003\u0019\u0001&/\u001a3fM&!\u00111RAG\u0005\u0019\u0019FO]5oO*\u0019\u0011qQ\t\t\u000f\u0005%4\u00021\u0001\u0002\u0012B\u0019a(a%\n\u0007\u0005UuH\u0001\u0006Qe>\u0004XM\u001d;jKN\u0004")
public interface DecorateAsScala
extends AsScalaConverters {
    public static /* synthetic */ Decorators.AsScala asScalaIteratorConverter$(DecorateAsScala $this, java.util.Iterator i) {
        return $this.asScalaIteratorConverter(i);
    }

    default public <A> Decorators.AsScala<Iterator<A>> asScalaIteratorConverter(java.util.Iterator<A> i) {
        return new Decorators.AsScala<Iterator<A>>((Function0<Iterator> & java.io.Serializable & Serializable)() -> this.asScalaIterator(i));
    }

    public static /* synthetic */ Decorators.AsScala enumerationAsScalaIteratorConverter$(DecorateAsScala $this, Enumeration i) {
        return $this.enumerationAsScalaIteratorConverter(i);
    }

    default public <A> Decorators.AsScala<Iterator<A>> enumerationAsScalaIteratorConverter(Enumeration<A> i) {
        return new Decorators.AsScala<Iterator<A>>((Function0<Iterator> & java.io.Serializable & Serializable)() -> this.enumerationAsScalaIterator(i));
    }

    public static /* synthetic */ Decorators.AsScala iterableAsScalaIterableConverter$(DecorateAsScala $this, java.lang.Iterable i) {
        return $this.iterableAsScalaIterableConverter(i);
    }

    default public <A> Decorators.AsScala<Iterable<A>> iterableAsScalaIterableConverter(java.lang.Iterable<A> i) {
        return new Decorators.AsScala<Iterable<A>>((Function0<Iterable> & java.io.Serializable & Serializable)() -> this.iterableAsScalaIterable(i));
    }

    public static /* synthetic */ Decorators.AsScala collectionAsScalaIterableConverter$(DecorateAsScala $this, Collection i) {
        return $this.collectionAsScalaIterableConverter(i);
    }

    default public <A> Decorators.AsScala<Iterable<A>> collectionAsScalaIterableConverter(Collection<A> i) {
        return new Decorators.AsScala<Iterable<A>>((Function0<Iterable> & java.io.Serializable & Serializable)() -> this.collectionAsScalaIterable(i));
    }

    public static /* synthetic */ Decorators.AsScala asScalaBufferConverter$(DecorateAsScala $this, List l) {
        return $this.asScalaBufferConverter(l);
    }

    default public <A> Decorators.AsScala<Buffer<A>> asScalaBufferConverter(List<A> l) {
        return new Decorators.AsScala<Buffer<A>>((Function0<Buffer> & java.io.Serializable & Serializable)() -> this.asScalaBuffer(l));
    }

    public static /* synthetic */ Decorators.AsScala asScalaSetConverter$(DecorateAsScala $this, Set s) {
        return $this.asScalaSetConverter(s);
    }

    default public <A> Decorators.AsScala<scala.collection.mutable.Set<A>> asScalaSetConverter(Set<A> s) {
        return new Decorators.AsScala<scala.collection.mutable.Set<A>>((Function0<scala.collection.mutable.Set> & java.io.Serializable & Serializable)() -> this.asScalaSet(s));
    }

    public static /* synthetic */ Decorators.AsScala mapAsScalaMapConverter$(DecorateAsScala $this, java.util.Map m) {
        return $this.mapAsScalaMapConverter(m);
    }

    default public <A, B> Decorators.AsScala<Map<A, B>> mapAsScalaMapConverter(java.util.Map<A, B> m) {
        return new Decorators.AsScala<Map<A, B>>((Function0<Map> & java.io.Serializable & Serializable)() -> this.mapAsScalaMap(m));
    }

    public static /* synthetic */ Decorators.AsScala mapAsScalaConcurrentMapConverter$(DecorateAsScala $this, ConcurrentMap m) {
        return $this.mapAsScalaConcurrentMapConverter(m);
    }

    default public <A, B> Decorators.AsScala<scala.collection.concurrent.Map<A, B>> mapAsScalaConcurrentMapConverter(ConcurrentMap<A, B> m) {
        return new Decorators.AsScala<scala.collection.concurrent.Map<A, B>>((Function0<scala.collection.concurrent.Map> & java.io.Serializable & Serializable)() -> this.mapAsScalaConcurrentMap(m));
    }

    public static /* synthetic */ Decorators.AsScala dictionaryAsScalaMapConverter$(DecorateAsScala $this, Dictionary p) {
        return $this.dictionaryAsScalaMapConverter(p);
    }

    default public <A, B> Decorators.AsScala<Map<A, B>> dictionaryAsScalaMapConverter(Dictionary<A, B> p) {
        return new Decorators.AsScala<Map<A, B>>((Function0<Map> & java.io.Serializable & Serializable)() -> this.dictionaryAsScalaMap(p));
    }

    public static /* synthetic */ Decorators.AsScala propertiesAsScalaMapConverter$(DecorateAsScala $this, Properties p) {
        return $this.propertiesAsScalaMapConverter(p);
    }

    default public Decorators.AsScala<Map<String, String>> propertiesAsScalaMapConverter(Properties p) {
        return new Decorators.AsScala<Map<String, String>>((Function0<Map> & java.io.Serializable & Serializable)() -> this.propertiesAsScalaMap(p));
    }

    public static void $init$(DecorateAsScala $this) {
    }
}

