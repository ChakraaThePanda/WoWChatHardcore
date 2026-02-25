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
import scala.collection.JavaConverters$;
import scala.collection.concurrent.Map;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005Eda\u0002\u0007\u000e!\u0003\r\t\u0001\u0006\u0005\u00063\u0001!\tA\u0007\u0005\u0006=\u0001!\u0019a\b\u0005\u0006s\u0001!\u0019A\u000f\u0005\u0006\t\u0002!\u0019!\u0012\u0005\u0006%\u0002!\u0019a\u0015\u0005\u00069\u0002!\u0019!\u0018\u0005\u0006Y\u0002!\u0019!\u001c\u0005\u0006q\u0002!\u0019!\u001f\u0005\b\u0003\u001f\u0001A1AA\t\u0011\u001d\t\u0019\u0004\u0001C\u0002\u0003kAq!!\u0014\u0001\t\u0007\tyE\u0001\tU_N\u001b\u0017\r\\1J[Bd\u0017nY5ug*\u0011abD\u0001\bG>tg/\u001a:u\u0015\t\u0001\u0012#\u0001\u0006d_2dWm\u0019;j_:T\u0011AE\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001Q\u0003\u0005\u0002\u0017/5\t\u0011#\u0003\u0002\u0019#\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$C#A\u000e\u0011\u0005Ya\u0012BA\u000f\u0012\u0005\u0011)f.\u001b;\u0002+%$XM]1u_J$S\u000f\r\u00193a\u0005\u001c8kY1mCV\u0011\u0001e\n\u000b\u0003CA\u00022AI\u0012&\u001b\u0005y\u0011B\u0001\u0013\u0010\u0005!IE/\u001a:bi>\u0014\bC\u0001\u0014(\u0019\u0001!Q\u0001\u000b\u0002C\u0002%\u0012\u0011!Q\t\u0003U5\u0002\"AF\u0016\n\u00051\n\"a\u0002(pi\"Lgn\u001a\t\u0003-9J!aL\t\u0003\u0007\u0005s\u0017\u0010C\u00032\u0005\u0001\u0007!'\u0001\u0002jiB\u00191\u0007O\u0013\u000e\u0003QR!!\u000e\u001c\u0002\tU$\u0018\u000e\u001c\u0006\u0002o\u0005!!.\u0019<b\u0013\t!C'\u0001\u0011f]VlWM]1uS>tG%\u001e\u00191eA\n5oU2bY\u0006LE/\u001a:bi>\u0014XCA\u001e?)\tat\bE\u0002#Gu\u0002\"A\n \u0005\u000b!\u001a!\u0019A\u0015\t\u000b\u0001\u001b\u0001\u0019A!\u0002\u0003%\u00042a\r\">\u0013\t\u0019EGA\u0006F]VlWM]1uS>t\u0017!H5uKJ\f'\r\\3%kB\u0002$\u0007M!t'\u000e\fG.Y%uKJ\f'\r\\3\u0016\u0005\u0019[ECA$M!\r\u0011\u0003JS\u0005\u0003\u0013>\u0011\u0001\"\u0013;fe\u0006\u0014G.\u001a\t\u0003M-#Q\u0001\u000b\u0003C\u0002%BQ\u0001\u0011\u0003A\u00025\u00032AT)K\u001b\u0005y%B\u0001)7\u0003\u0011a\u0017M\\4\n\u0005%{\u0015aH2pY2,7\r^5p]\u0012*\b\u0007\r\u001a1\u0003N\u001c6-\u00197b\u0013R,'/\u00192mKV\u0011Ak\u0016\u000b\u0003+b\u00032A\t%W!\t1s\u000bB\u0003)\u000b\t\u0007\u0011\u0006C\u0003A\u000b\u0001\u0007\u0011\fE\u000245ZK!a\u0017\u001b\u0003\u0015\r{G\u000e\\3di&|g.A\fmSN$H%\u001e\u00191eA\n7oU2bY\u0006\u0014UO\u001a4feV\u0011aL\u001a\u000b\u0003?\u001e\u00042\u0001Y2f\u001b\u0005\t'B\u00012\u0010\u0003\u001diW\u000f^1cY\u0016L!\u0001Z1\u0003\r\t+hMZ3s!\t1c\rB\u0003)\r\t\u0007\u0011\u0006C\u0003i\r\u0001\u0007\u0011.A\u0001m!\r\u0019$.Z\u0005\u0003WR\u0012A\u0001T5ti\u0006\u00012/\u001a;%kB\u0002$\u0007M1t'\u000e\fG.Y\u000b\u0003]N$\"a\u001c;\u0011\u0007\u0001\u0004(/\u0003\u0002rC\n\u00191+\u001a;\u0011\u0005\u0019\u001aH!\u0002\u0015\b\u0005\u0004I\u0003\"B;\b\u0001\u00041\u0018!A:\u0011\u0007M:(/\u0003\u0002ri\u0005\u0001R.\u00199%kB\u0002$\u0007M!t'\u000e\fG.Y\u000b\u0005u~\f\u0019\u0001F\u0002|\u0003\u000f\u0001R\u0001\u0019?\u007f\u0003\u0003I!!`1\u0003\u00075\u000b\u0007\u000f\u0005\u0002'\u007f\u0012)\u0001\u0006\u0003b\u0001SA\u0019a%a\u0001\u0005\r\u0005\u0015\u0001B1\u0001*\u0005\u0005\u0011\u0005bBA\u0005\u0011\u0001\u0007\u00111B\u0001\u0002[B11'!\u0004\u007f\u0003\u0003I!! \u001b\u0002;5\f\u0007\u000fJ;1aI\u0002\u0014i]*dC2\f7i\u001c8dkJ\u0014XM\u001c;NCB,b!a\u0005\u0002\"\u0005\u0015B\u0003BA\u000b\u0003O\u0001\u0002\"a\u0006\u0002\u001e\u0005}\u00111E\u0007\u0003\u00033Q1!a\u0007\u0010\u0003)\u0019wN\\2veJ,g\u000e^\u0005\u0004{\u0006e\u0001c\u0001\u0014\u0002\"\u0011)\u0001&\u0003b\u0001SA\u0019a%!\n\u0005\r\u0005\u0015\u0011B1\u0001*\u0011\u001d\tI!\u0003a\u0001\u0003S\u0001\u0002\"a\u000b\u00020\u0005}\u00111E\u0007\u0003\u0003[Q1!a\u00075\u0013\u0011\t\t$!\f\u0003\u001b\r{gnY;se\u0016tG/T1q\u0003i!\u0017n\u0019;j_:\f'/\u001f\u0013vaA\u0012\u0004'Q:TG\u0006d\u0017-T1q+\u0019\t9$!\u0010\u0002BQ!\u0011\u0011HA\"!\u0019\u0001G0a\u000f\u0002@A\u0019a%!\u0010\u0005\u000b!R!\u0019A\u0015\u0011\u0007\u0019\n\t\u0005\u0002\u0004\u0002\u0006)\u0011\r!\u000b\u0005\b\u0003\u000bR\u0001\u0019AA$\u0003\u0005\u0001\bcB\u001a\u0002J\u0005m\u0012qH\u0005\u0004\u0003\u0017\"$A\u0003#jGRLwN\\1ss\u0006Q\u0002O]8qKJ$\u0018.Z:%kB\u0002$\u0007M!t'\u000e\fG.Y'baR!\u0011\u0011KA5!\u0019\u0001G0a\u0015\u0002TA!\u0011QKA2\u001d\u0011\t9&a\u0018\u0011\u0007\u0005e\u0013#\u0004\u0002\u0002\\)\u0019\u0011QL\n\u0002\rq\u0012xn\u001c;?\u0013\r\t\t'E\u0001\u0007!J,G-\u001a4\n\t\u0005\u0015\u0014q\r\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005\u0005\u0014\u0003C\u0004\u0002F-\u0001\r!a\u001b\u0011\u0007M\ni'C\u0002\u0002pQ\u0012!\u0002\u0015:pa\u0016\u0014H/[3t\u0001")
public interface ToScalaImplicits {
    public static /* synthetic */ Iterator iterator$u0020asScala$(ToScalaImplicits $this, java.util.Iterator it) {
        return $this.iterator$u0020asScala(it);
    }

    default public <A> Iterator<A> iterator$u0020asScala(java.util.Iterator<A> it) {
        return JavaConverters$.MODULE$.asScalaIterator(it);
    }

    public static /* synthetic */ Iterator enumeration$u0020AsScalaIterator$(ToScalaImplicits $this, Enumeration i) {
        return $this.enumeration$u0020AsScalaIterator(i);
    }

    default public <A> Iterator<A> enumeration$u0020AsScalaIterator(Enumeration<A> i) {
        return JavaConverters$.MODULE$.enumerationAsScalaIterator(i);
    }

    public static /* synthetic */ Iterable iterable$u0020AsScalaIterable$(ToScalaImplicits $this, java.lang.Iterable i) {
        return $this.iterable$u0020AsScalaIterable(i);
    }

    default public <A> Iterable<A> iterable$u0020AsScalaIterable(java.lang.Iterable<A> i) {
        return JavaConverters$.MODULE$.iterableAsScalaIterable(i);
    }

    public static /* synthetic */ Iterable collection$u0020AsScalaIterable$(ToScalaImplicits $this, Collection i) {
        return $this.collection$u0020AsScalaIterable(i);
    }

    default public <A> Iterable<A> collection$u0020AsScalaIterable(Collection<A> i) {
        return JavaConverters$.MODULE$.collectionAsScalaIterable(i);
    }

    public static /* synthetic */ Buffer list$u0020asScalaBuffer$(ToScalaImplicits $this, List l) {
        return $this.list$u0020asScalaBuffer(l);
    }

    default public <A> Buffer<A> list$u0020asScalaBuffer(List<A> l) {
        return JavaConverters$.MODULE$.asScalaBuffer(l);
    }

    public static /* synthetic */ scala.collection.mutable.Set set$u0020asScala$(ToScalaImplicits $this, Set s) {
        return $this.set$u0020asScala(s);
    }

    default public <A> scala.collection.mutable.Set<A> set$u0020asScala(Set<A> s) {
        return JavaConverters$.MODULE$.asScalaSet(s);
    }

    public static /* synthetic */ scala.collection.mutable.Map map$u0020AsScala$(ToScalaImplicits $this, java.util.Map m) {
        return $this.map$u0020AsScala(m);
    }

    default public <A, B> scala.collection.mutable.Map<A, B> map$u0020AsScala(java.util.Map<A, B> m) {
        return JavaConverters$.MODULE$.mapAsScalaMap(m);
    }

    public static /* synthetic */ Map map$u0020AsScalaConcurrentMap$(ToScalaImplicits $this, ConcurrentMap m) {
        return $this.map$u0020AsScalaConcurrentMap(m);
    }

    default public <A, B> Map<A, B> map$u0020AsScalaConcurrentMap(ConcurrentMap<A, B> m) {
        return JavaConverters$.MODULE$.mapAsScalaConcurrentMap(m);
    }

    public static /* synthetic */ scala.collection.mutable.Map dictionary$u0020AsScalaMap$(ToScalaImplicits $this, Dictionary p) {
        return $this.dictionary$u0020AsScalaMap(p);
    }

    default public <A, B> scala.collection.mutable.Map<A, B> dictionary$u0020AsScalaMap(Dictionary<A, B> p) {
        return JavaConverters$.MODULE$.dictionaryAsScalaMap(p);
    }

    public static /* synthetic */ scala.collection.mutable.Map properties$u0020AsScalaMap$(ToScalaImplicits $this, Properties p) {
        return $this.properties$u0020AsScalaMap(p);
    }

    default public scala.collection.mutable.Map<String, String> properties$u0020AsScalaMap(Properties p) {
        return JavaConverters$.MODULE$.propertiesAsScalaMap(p);
    }

    public static void $init$(ToScalaImplicits $this) {
    }
}

