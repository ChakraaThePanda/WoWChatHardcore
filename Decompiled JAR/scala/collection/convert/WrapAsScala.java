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
import scala.collection.convert.LowPriorityWrapAsScala;
import scala.collection.mutable.Buffer;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015faB\b\u0011!\u0003\r\ta\u0006\u0005\u0006A\u0001!\t!\t\u0005\u0006K\u0001!\u0019A\n\u0005\u0006\u0001\u0002!\u0019!\u0011\u0005\u0006\u0017\u0002!\u0019\u0001\u0014\u0005\u00063\u0002!\u0019A\u0017\u0005\u0006G\u0002!\u0019\u0001\u001a\u0005\u0006g\u0002!\u0019\u0001\u001e\u0005\u0007\u007f\u0002!\u0019!!\u0001\t\u000f\u0005u\u0001\u0001b\u0001\u0002 !9\u0011\u0011\t\u0001\u0005\u0004\u0005\r\u0003bBA.\u0001\u0011\r\u0011QL\u0004\b\u0003\u001f\u0003\u0002\u0012AAI\r\u0019y\u0001\u0003#\u0001\u0002\u0014\"9\u0011qS\u0007\u0005\u0002\u0005e%aC,sCB\f5oU2bY\u0006T!!\u0005\n\u0002\u000f\r|gN^3si*\u00111\u0003F\u0001\u000bG>dG.Z2uS>t'\"A\u000b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001\u0001\u0007\u000f\u0011\u0005eQR\"\u0001\u000b\n\u0005m!\"AB!osJ+g\r\u0005\u0002\u001e=5\t\u0001#\u0003\u0002 !\t1Bj\\<Qe&|'/\u001b;z/J\f\u0007/Q:TG\u0006d\u0017-\u0001\u0004%S:LG\u000f\n\u000b\u0002EA\u0011\u0011dI\u0005\u0003IQ\u0011A!\u00168ji\u0006yB-\u001a9sK\u000e\fG/\u001a3%kB\u0002$\u0007M1t'\u000e\fG.Y%uKJ\fGo\u001c:\u0016\u0005\u001drCC\u0001\u00158!\rI#\u0006L\u0007\u0002%%\u00111F\u0005\u0002\t\u0013R,'/\u0019;peB\u0011QF\f\u0007\u0001\t\u0015y#A1\u00011\u0005\u0005\t\u0015CA\u00195!\tI\"'\u0003\u00024)\t9aj\u001c;iS:<\u0007CA\r6\u0013\t1DCA\u0002B]fDQ\u0001\u000f\u0002A\u0002e\n!!\u001b;\u0011\u0007izD&D\u0001<\u0015\taT(\u0001\u0003vi&d'\"\u0001 \u0002\t)\fg/Y\u0005\u0003Wm\n!\u0006Z3qe\u0016\u001c\u0017\r^3eIU\u0004\u0004G\r\u0019f]VlWM]1uS>t\u0017i]*dC2\f\u0017\n^3sCR|'/\u0006\u0002C\u000bR\u00111I\u0012\t\u0004S)\"\u0005CA\u0017F\t\u0015y3A1\u00011\u0011\u001595\u00011\u0001I\u0003\u0005I\u0007c\u0001\u001eJ\t&\u0011!j\u000f\u0002\f\u000b:,X.\u001a:bi&|g.A\u0014eKB\u0014XmY1uK\u0012$S\u000f\r\u00193a%$XM]1cY\u0016\f5oU2bY\u0006LE/\u001a:bE2,WCA'S)\tq5\u000bE\u0002*\u001fFK!\u0001\u0015\n\u0003\u0011%#XM]1cY\u0016\u0004\"!\f*\u0005\u000b=\"!\u0019\u0001\u0019\t\u000b\u001d#\u0001\u0019\u0001+\u0011\u0007UC\u0016+D\u0001W\u0015\t9V(\u0001\u0003mC:<\u0017B\u0001)W\u0003%\"W\r\u001d:fG\u0006$X\r\u001a\u0013vaA\u0012\u0004gY8mY\u0016\u001cG/[8o\u0003N\u001c6-\u00197b\u0013R,'/\u00192mKV\u00111L\u0018\u000b\u00039~\u00032!K(^!\tic\fB\u00030\u000b\t\u0007\u0001\u0007C\u0003H\u000b\u0001\u0007\u0001\rE\u0002;CvK!AY\u001e\u0003\u0015\r{G\u000e\\3di&|g.A\u000feKB\u0014XmY1uK\u0012$S\u000f\r\u00193a\u0005\u001c8kY1mC\n+hMZ3s+\t)W\u000e\u0006\u0002g]B\u0019qM\u001b7\u000e\u0003!T!!\u001b\n\u0002\u000f5,H/\u00192mK&\u00111\u000e\u001b\u0002\u0007\u0005V4g-\u001a:\u0011\u00055jG!B\u0018\u0007\u0005\u0004\u0001\u0004\"B8\u0007\u0001\u0004\u0001\u0018!\u00017\u0011\u0007i\nH.\u0003\u0002sw\t!A*[:u\u0003i!W\r\u001d:fG\u0006$X\r\u001a\u0013vaA\u0012\u0004'Y:TG\u0006d\u0017mU3u+\t)(\u0010\u0006\u0002wwB\u0019qm^=\n\u0005aD'aA*fiB\u0011QF\u001f\u0003\u0006_\u001d\u0011\r\u0001\r\u0005\u0006y\u001e\u0001\r!`\u0001\u0002gB\u0019!H`=\n\u0005a\\\u0014!\b3faJ,7-\u0019;fI\u0012*\b\u0007\r\u001a1[\u0006\u0004\u0018i]*dC2\fW*\u00199\u0016\r\u0005\r\u0011QBA\t)\u0011\t)!!\u0006\u0011\u000f\u001d\f9!a\u0003\u0002\u0010%\u0019\u0011\u0011\u00025\u0003\u00075\u000b\u0007\u000fE\u0002.\u0003\u001b!Qa\f\u0005C\u0002A\u00022!LA\t\t\u0019\t\u0019\u0002\u0003b\u0001a\t\t!\tC\u0004\u0002\u0018!\u0001\r!!\u0007\u0002\u00035\u0004rAOA\u000e\u0003\u0017\ty!C\u0002\u0002\nm\nq\u0005Z3qe\u0016\u001c\u0017\r^3eIU\u0004\u0004G\r\u0019nCB\f5oU2bY\u0006\u001cuN\\2veJ,g\u000e^'baV1\u0011\u0011EA\u0018\u0003g!B!a\t\u00026AA\u0011QEA\u0016\u0003[\t\t$\u0004\u0002\u0002()\u0019\u0011\u0011\u0006\n\u0002\u0015\r|gnY;se\u0016tG/\u0003\u0003\u0002\n\u0005\u001d\u0002cA\u0017\u00020\u0011)q&\u0003b\u0001aA\u0019Q&a\r\u0005\r\u0005M\u0011B1\u00011\u0011\u001d\t9\"\u0003a\u0001\u0003o\u0001\u0002\"!\u000f\u0002>\u00055\u0012\u0011G\u0007\u0003\u0003wQ1!!\u000b<\u0013\u0011\ty$a\u000f\u0003\u001b\r{gnY;se\u0016tG/T1q\u0003\u0011\"W\r\u001d:fG\u0006$X\r\u001a\u0013vaA\u0012\u0004\u0007Z5di&|g.\u0019:z\u0003N\u001c6-\u00197b\u001b\u0006\u0004XCBA#\u0003\u0017\ny\u0005\u0006\u0003\u0002H\u0005E\u0003cB4\u0002\b\u0005%\u0013Q\n\t\u0004[\u0005-C!B\u0018\u000b\u0005\u0004\u0001\u0004cA\u0017\u0002P\u00111\u00111\u0003\u0006C\u0002ABq!a\u0015\u000b\u0001\u0004\t)&A\u0001q!\u001dQ\u0014qKA%\u0003\u001bJ1!!\u0017<\u0005)!\u0015n\u0019;j_:\f'/_\u0001%I\u0016\u0004(/Z2bi\u0016$G%\u001e\u00191eA\u0002(o\u001c9feRLWm]!t'\u000e\fG.Y'baR!\u0011qLA<!\u001d9\u0017qAA1\u0003C\u0002B!a\u0019\u0002r9!\u0011QMA7!\r\t9\u0007F\u0007\u0003\u0003SR1!a\u001b\u0017\u0003\u0019a$o\\8u}%\u0019\u0011q\u000e\u000b\u0002\rA\u0013X\rZ3g\u0013\u0011\t\u0019(!\u001e\u0003\rM#(/\u001b8h\u0015\r\ty\u0007\u0006\u0005\b\u0003'Z\u0001\u0019AA=!\rQ\u00141P\u0005\u0004\u0003{Z$A\u0003)s_B,'\u000f^5fg\":\u0001!!!\u0002\b\u0006-\u0005cA\r\u0002\u0004&\u0019\u0011Q\u0011\u000b\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0002\n\u0006ySo]3!\u0015\u00064\u0018mQ8om\u0016\u0014H/\u001a:tA=\u0014\beY8og&$WM\u001d\u0011U_N\u001b\u0017\r\\1J[Bd\u0017nY5ug\u0006\u0012\u0011QR\u0001\u0007e9\n$G\f\u0019\u0002\u0017]\u0013\u0018\r]!t'\u000e\fG.\u0019\t\u0003;5\u0019B!\u0004\r\u0002\u0016B\u0011Q\u0004A\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\u0005E\u0005fB\u0007\u0002\u0002\u0006u\u00151R\u0011\u0003\u0003?\u000b\u0011(^:fA)\u000bg/Y\"p]Z,'\u000f^3sg\u0002z'\u000fI2p]NLG-\u001a:!\u00136\u0004H.[2ji\u000e{gN^3sg&|gn\u001d+p'\u000e\fG.\u0019\u0015\b\u001b\u0005\u0005\u0015qQAFQ\u001da\u0011\u0011QAO\u0003\u0017\u0003")
public interface WrapAsScala
extends LowPriorityWrapAsScala {
    public static /* synthetic */ Iterator deprecated$u0020asScalaIterator$(WrapAsScala $this, java.util.Iterator it) {
        return $this.deprecated$u0020asScalaIterator(it);
    }

    default public <A> Iterator<A> deprecated$u0020asScalaIterator(java.util.Iterator<A> it) {
        return this.asScalaIterator(it);
    }

    public static /* synthetic */ Iterator deprecated$u0020enumerationAsScalaIterator$(WrapAsScala $this, Enumeration i) {
        return $this.deprecated$u0020enumerationAsScalaIterator(i);
    }

    default public <A> Iterator<A> deprecated$u0020enumerationAsScalaIterator(Enumeration<A> i) {
        return this.enumerationAsScalaIterator(i);
    }

    public static /* synthetic */ Iterable deprecated$u0020iterableAsScalaIterable$(WrapAsScala $this, java.lang.Iterable i) {
        return $this.deprecated$u0020iterableAsScalaIterable(i);
    }

    default public <A> Iterable<A> deprecated$u0020iterableAsScalaIterable(java.lang.Iterable<A> i) {
        return this.iterableAsScalaIterable(i);
    }

    public static /* synthetic */ Iterable deprecated$u0020collectionAsScalaIterable$(WrapAsScala $this, Collection i) {
        return $this.deprecated$u0020collectionAsScalaIterable(i);
    }

    default public <A> Iterable<A> deprecated$u0020collectionAsScalaIterable(Collection<A> i) {
        return this.collectionAsScalaIterable(i);
    }

    public static /* synthetic */ Buffer deprecated$u0020asScalaBuffer$(WrapAsScala $this, List l) {
        return $this.deprecated$u0020asScalaBuffer(l);
    }

    default public <A> Buffer<A> deprecated$u0020asScalaBuffer(List<A> l) {
        return this.asScalaBuffer(l);
    }

    public static /* synthetic */ scala.collection.mutable.Set deprecated$u0020asScalaSet$(WrapAsScala $this, Set s) {
        return $this.deprecated$u0020asScalaSet(s);
    }

    default public <A> scala.collection.mutable.Set<A> deprecated$u0020asScalaSet(Set<A> s) {
        return this.asScalaSet(s);
    }

    public static /* synthetic */ scala.collection.mutable.Map deprecated$u0020mapAsScalaMap$(WrapAsScala $this, java.util.Map m) {
        return $this.deprecated$u0020mapAsScalaMap(m);
    }

    default public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020mapAsScalaMap(java.util.Map<A, B> m) {
        return this.mapAsScalaMap(m);
    }

    public static /* synthetic */ Map deprecated$u0020mapAsScalaConcurrentMap$(WrapAsScala $this, ConcurrentMap m) {
        return $this.deprecated$u0020mapAsScalaConcurrentMap(m);
    }

    default public <A, B> Map<A, B> deprecated$u0020mapAsScalaConcurrentMap(ConcurrentMap<A, B> m) {
        return this.mapAsScalaConcurrentMap(m);
    }

    public static /* synthetic */ scala.collection.mutable.Map deprecated$u0020dictionaryAsScalaMap$(WrapAsScala $this, Dictionary p) {
        return $this.deprecated$u0020dictionaryAsScalaMap(p);
    }

    default public <A, B> scala.collection.mutable.Map<A, B> deprecated$u0020dictionaryAsScalaMap(Dictionary<A, B> p) {
        return this.dictionaryAsScalaMap(p);
    }

    public static /* synthetic */ scala.collection.mutable.Map deprecated$u0020propertiesAsScalaMap$(WrapAsScala $this, Properties p) {
        return $this.deprecated$u0020propertiesAsScalaMap(p);
    }

    default public scala.collection.mutable.Map<String, String> deprecated$u0020propertiesAsScalaMap(Properties p) {
        return this.propertiesAsScalaMap(p);
    }

    public static void $init$(WrapAsScala $this) {
    }
}

