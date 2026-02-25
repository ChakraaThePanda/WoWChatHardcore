/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import scala.Enumeration$ValueOrdering$;
import scala.Enumeration$ValueSet$;
import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Predef$any2stringadd$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractSet;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterator;
import scala.collection.SortedSetLike;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Sorted;
import scala.collection.immutable.BitSet;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Set;
import scala.collection.immutable.SortedSet;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Builder;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.Map;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSet;
import scala.math.Ordered;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.util.matching.Regex$;

@ScalaSignature(bytes="\u0006\u0001\t}h!B+W\u0003\u0003I\u0006\u0002C1\u0001\u0005\u0003\u0005\u000b\u0011\u00022\t\u000b\u0015\u0004A\u0011\u00014\t\u000b\u0015\u0004A\u0011A5\t\u000b)\u0004A\u0011C6\t\u000b1\u0004A\u0011I7\t\u000fY\u0004!\u0019!C\u0005o\"9\u0011Q\u001f\u0001!\u0002\u0013A\b\"CA|\u0001\u0001\u0007I\u0011BAG\u0011%\tI\u0010\u0001a\u0001\n\u0013\tY\u0010\u0003\u0005\u0003\b\u0001\u0001\u000b\u0015BA\"\u0011%\u0011\t\u0002\u0001a\u0001\n\u0013\u0011\u0019\u0002C\u0005\u0003\u0016\u0001\u0001\r\u0011\"\u0003\u0003\u0018!A!1\u0004\u0001!B\u0013\tY\u0003C\u0005\u0003(\u0001\u0011\r\u0011\"\u0003\u0003*!A!Q\u0006\u0001!\u0002\u0013\u0011Y\u0003C\u0004\u00030\u0001!\t!!$\t\u0013\tE\u0002\u00011A\u0005\u0012\u0005m\u0001\"\u0003B\u001a\u0001\u0001\u0007I\u0011\u0003B\u001b\u0011\u001d\u0011I\u0004\u0001Q!\n\tD1Ba\u000f\u0001\u0001\u0004\u0005\r\u0011\"\u0005\u0003>!Y!1\t\u0001A\u0002\u0003\u0007I\u0011\u0003B#\u0011-\u0011I\u0005\u0001a\u0001\u0002\u0003\u0006KAa\u0010\t\u000f\t-\u0003\u0001\"\u0003\u00028\"I!Q\n\u0001A\u0002\u0013%\u00111\u0004\u0005\n\u0005\u001f\u0002\u0001\u0019!C\u0005\u0005#BqA!\u0016\u0001A\u0003&!\rC\u0005\u0003X\u0001\u0001\r\u0011\"\u0003\u0002\u001c!I!\u0011\f\u0001A\u0002\u0013%!1\f\u0005\b\u0005?\u0002\u0001\u0015)\u0003c\u0011\u001d\u0011\t\u0007\u0001C\u0003\u00037AqAa\u0019\u0001\t\u000b\u0011)\u0007C\u0004\u0003l\u0001!)A!\u001c\t\u000f\tM\u0004\u0001\"\u0006\u0003v!9!1\u000f\u0001\u0005\u0016\t]\u0004b\u0002B:\u0001\u0011U!Q\u0010\u0005\b\u0005g\u0002AQ\u0003BB\u0011\u001d\u0011I\t\u0001C\u0005\u0005\u0017CqA!$\u0001\t\u0013\u0011yIB\u0004\u0002\u0006\u0001\t\t!a\u0002\t\r\u0015<C\u0011AA\f\u0011\u001d\tIb\nD\u0001\u00037A!\"!\b(\u0005\u0003\u0005\t\u0015!\u0003h\u0011\u001d\tyb\nC!\u0003CAq!a\n(\t\u0003\nI\u0003C\u0004\u0002<\u001d\"\t%!\u0010\t\u000f\u0005}r\u0005\"\u0001\u0002B!a\u0011q]\u0014\u0003\u0002\u000b\u0007I\u0011\u0001\u0001\u0002j\u001a1!1\u0013\u0001\t\u0005+C\u0011Ba\u001f1\u0005\u0003\u0005\u000b\u0011\u00022\t\u0015\t\u0005\u0005G!A!\u0002\u0013\tI\f\u0003\u0004fa\u0011\u0005!q\u0013\u0005\u0007KB\"\tAa(\t\r\u0015\u0004D\u0011\u0001BR\u0011\u0019)\u0007\u0007\"\u0001\u0003(\"9\u0011\u0011\u0004\u0019\u0005\u0002\u0005m\u0001\"\u000271\t\u0003j\u0007\"\u000261\t#Ywa\u0002BW\u0001!\u0005!q\u0016\u0004\b\u0005c\u0003\u0001\u0012\u0001BZ\u0011\u0019)7\b\"\u0001\u0003<\"9\u0011qD\u001e\u0005\u0002\tufABA#\u0001\u0001\t9\u0005\u0003\u0006\u0002dy\u0012\t\u0011)Q\u0005\u0003KBq!\u001a \u0005\u0002y\nY\u0007C\u0004\u0002py\"\u0019!!\u001d\t\u000f\u0005ed\b\"\u0001\u0002|!9\u00111\u0012 \u0005B\u00055\u0005bBAH}\u0011\u0005\u0011\u0011\u0013\u0005\b\u0003\u007fqD\u0011AAL\u0011\u001d\tiJ\u0010C\u0001\u0003?Cq!a)?\t\u0003\t)\u000bC\u0004\u0002.z\"\t%a,\t\u000f\u0005Uf\b\"\u0011\u00028\"9\u0011Q\u001a \u0005\u0002\u0005=\u0007\u0002DAo}\tE)\u0019!C\u0001\u0001\u0005}wa\u0002Bc\u0001!\u0005!q\u0019\u0004\b\u0003\u000b\u0002\u0001\u0012\u0001Be\u0011\u0019)W\n\"\u0001\u0003L\"I\u00111R'C\u0002\u0013\u0005\u0011Q\u0012\u0005\t\u0005\u001bl\u0005\u0015!\u0003\u0002D!9!1M'\u0005\u0002\t=\u0007b\u0002Bn\u001b\u0012\u0005!Q\u001c\u0005\b\u0005ClE\u0011\u0001Br\u0011\u001d\u0011Y/\u0014C\u0002\u0005[\u00141\"\u00128v[\u0016\u0014\u0018\r^5p]*\tq+A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u0001Qf\f\u0005\u0002\\96\ta+\u0003\u0002^-\n1\u0011I\\=SK\u001a\u0004\"aW0\n\u0005\u00014&\u0001D*fe&\fG.\u001b>bE2,\u0017aB5oSRL\u0017\r\u001c\t\u00037\u000eL!\u0001\u001a,\u0003\u0007%sG/\u0001\u0004=S:LGO\u0010\u000b\u0003O\"\u0004\"a\u0017\u0001\t\u000b\u0005\u0014\u0001\u0019\u00012\u0015\u0003\u001d\f1B]3bIJ+7o\u001c7wKR\t!,\u0001\u0005u_N#(/\u001b8h)\u0005q\u0007CA8u\u001b\u0005\u0001(BA9s\u0003\u0011a\u0017M\\4\u000b\u0003M\fAA[1wC&\u0011Q\u000f\u001d\u0002\u0007'R\u0014\u0018N\\4\u0002\tYl\u0017\r]\u000b\u0002qB)\u0011P 2\u0002\u00025\t!P\u0003\u0002|y\u00069Q.\u001e;bE2,'BA?W\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0003\u007fj\u00141!T1q!\r\t\u0019aJ\u0007\u0002\u0001\t)a+\u00197vKN)qEWA\u0005=B1\u00111BA\t\u0003\u0003q1aWA\u0007\u0013\r\tyAV\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\t\u0019\"!\u0006\u0003\u000f=\u0013H-\u001a:fI*\u0019\u0011q\u0002,\u0015\u0005\u0005\u0005\u0011AA5e+\u0005\u0011\u0017!H:dC2\fG%\u00128v[\u0016\u0014\u0018\r^5p]\u0012\"s.\u001e;fe\u0016sW/\u001c\u0011\u0002\u000f\r|W\u000e]1sKR\u0019!-a\t\t\u000f\u0005\u00152\u00061\u0001\u0002\u0002\u0005!A\u000f[1u\u0003\u0019)\u0017/^1mgR!\u00111FA\u0019!\rY\u0016QF\u0005\u0004\u0003_1&a\u0002\"p_2,\u0017M\u001c\u0005\b\u0003ga\u0003\u0019AA\u001b\u0003\u0015yG\u000f[3s!\rY\u0016qG\u0005\u0004\u0003s1&aA!os\u0006A\u0001.Y:i\u0007>$W\rF\u0001c\u0003\u0015!\u0003\u000f\\;t)\u0011\t\u0019%!:\u0011\u0007\u0005\raH\u0001\u0005WC2,XmU3u'!q\u0014\u0011JA)\u0003;r\u0006CBA&\u0003\u001b\n\t!D\u0001}\u0013\r\ty\u0005 \u0002\f\u0003\n\u001cHO]1diN+G\u000f\u0005\u0004\u0002T\u0005e\u0013\u0011A\u0007\u0003\u0003+R1!a\u0016}\u0003%IW.\\;uC\ndW-\u0003\u0003\u0002\\\u0005U#!C*peR,GmU3u!!\tY%a\u0018\u0002\u0002\u0005\r\u0013bAA1y\ni1k\u001c:uK\u0012\u001cV\r\u001e'jW\u0016\fQA\u001c8JIN\u0004B!a\u0015\u0002h%!\u0011\u0011NA+\u0005\u0019\u0011\u0015\u000e^*fiR!\u00111IA7\u0011\u001d\t\u0019\u0007\u0011a\u0001\u0003K\n\u0001b\u001c:eKJLgnZ\u000b\u0003\u0003g\u0002b!a\u0003\u0002v\u0005\u0005\u0011\u0002BA<\u0003+\u0011\u0001b\u0014:eKJLgnZ\u0001\ne\u0006tw-Z%na2$b!a\u0011\u0002~\u0005\u001d\u0005bBA@\u0005\u0002\u0007\u0011\u0011Q\u0001\u0005MJ|W\u000eE\u0003\\\u0003\u0007\u000b\t!C\u0002\u0002\u0006Z\u0013aa\u00149uS>t\u0007bBAE\u0005\u0002\u0007\u0011\u0011Q\u0001\u0006k:$\u0018\u000e\\\u0001\u0006K6\u0004H/_\u000b\u0003\u0003\u0007\n\u0001bY8oi\u0006Lgn\u001d\u000b\u0005\u0003W\t\u0019\nC\u0004\u0002\u0016\u0012\u0003\r!!\u0001\u0002\u0003Y$B!a\u0011\u0002\u001a\"9\u00111T#A\u0002\u0005\u0005\u0011!\u0002<bYV,\u0017A\u0002\u0013nS:,8\u000f\u0006\u0003\u0002D\u0005\u0005\u0006bBAN\r\u0002\u0007\u0011\u0011A\u0001\tSR,'/\u0019;peV\u0011\u0011q\u0015\t\u0007\u0003\u0017\nI+!\u0001\n\u0007\u0005-FP\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003AYW-_:Ji\u0016\u0014\u0018\r^8s\rJ|W\u000e\u0006\u0003\u0002(\u0006E\u0006bBAZ\u0011\u0002\u0007\u0011\u0011A\u0001\u0006gR\f'\u000f^\u0001\rgR\u0014\u0018N\\4Qe\u00164\u0017\u000e_\u000b\u0003\u0003s\u0003B!a/\u0002J:!\u0011QXAc!\r\tyLV\u0007\u0003\u0003\u0003T1!a1Y\u0003\u0019a$o\\8u}%\u0019\u0011q\u0019,\u0002\rA\u0013X\rZ3g\u0013\r)\u00181\u001a\u0006\u0004\u0003\u000f4\u0016!\u0003;p\u0005&$X*Y:l+\t\t\t\u000eE\u0003\\\u0003'\f9.C\u0002\u0002VZ\u0013Q!\u0011:sCf\u00042aWAm\u0013\r\tYN\u0016\u0002\u0005\u0019>tw-A\rtG\u0006d\u0017\rJ#ok6,'/\u0019;j_:$CEY=OC6,WCAAq!!\tY,a9\u0002:\u0006\u0005\u0011bA@\u0002L\"9\u0011Q\u0013\u0018A\u0002\u0005\u0005\u0011\u0001H:dC2\fG%\u00128v[\u0016\u0014\u0018\r^5p]\u0012\"s.\u001e;fe\u0016sW/\\\u000b\u0002O\":q%!<\u0002\u001c\u0006M\bcA.\u0002p&\u0019\u0011\u0011\u001f,\u0003!M+'/[1m-\u0016\u00148/[8o+&#e\u0004\u00032jy>j\u001f%H)\u0002\u000bYl\u0017\r\u001d\u0011\u0002\tY\u001cX\r^\u0001\tmN,Go\u0018\u0013fcR!\u0011Q B\u0002!\rY\u0016q`\u0005\u0004\u0005\u00031&\u0001B+oSRD\u0011B!\u0002\n\u0003\u0003\u0005\r!a\u0011\u0002\u0007a$\u0013'A\u0003wg\u0016$\b\u0005K\u0002\u000b\u0005\u0017\u00012a\u0017B\u0007\u0013\r\u0011yA\u0016\u0002\niJ\fgn]5f]R\f1B^:fi\u0012+g-\u001b8fIV\u0011\u00111F\u0001\u0010mN,G\u000fR3gS:,Gm\u0018\u0013fcR!\u0011Q B\r\u0011%\u0011)\u0001DA\u0001\u0002\u0004\tY#\u0001\u0007wg\u0016$H)\u001a4j]\u0016$\u0007\u0005K\u0002\u000e\u0005?\u00012a\u0017B\u0011\u0013\r\u0011\u0019C\u0016\u0002\tm>d\u0017\r^5mK\"\u001aQBa\u0003\u0002\t9l\u0017\r]\u000b\u0003\u0005W\u0001R!\u001f@c\u0003s\u000bQA\\7ba\u0002\naA^1mk\u0016\u001c\u0018A\u00028fqRLE-\u0001\u0006oKb$\u0018\nZ0%KF$B!!@\u00038!A!Q\u0001\n\u0002\u0002\u0003\u0007!-A\u0004oKb$\u0018\n\u001a\u0011\u0002\u00119,\u0007\u0010\u001e(b[\u0016,\"Aa\u0010\u0011\r\u0005-!\u0011IA]\u0013\u0011\tY+!\u0006\u0002\u00199,\u0007\u0010\u001e(b[\u0016|F%Z9\u0015\t\u0005u(q\t\u0005\n\u0005\u000b)\u0012\u0011!a\u0001\u0005\u007f\t\u0011B\\3yi:\u000bW.\u001a\u0011\u0002\u001d9,\u0007\u0010\u001e(b[\u0016|%OT;mY\u0006)Ao\u001c9JI\u0006IAo\u001c9JI~#S-\u001d\u000b\u0005\u0003{\u0014\u0019\u0006\u0003\u0005\u0003\u0006e\t\t\u00111\u0001c\u0003\u0019!x\u000e]%eA\u0005A!m\u001c;u_6LE-\u0001\u0007c_R$x.\\%e?\u0012*\u0017\u000f\u0006\u0003\u0002~\nu\u0003\u0002\u0003B\u00039\u0005\u0005\t\u0019\u00012\u0002\u0013\t|G\u000f^8n\u0013\u0012\u0004\u0013!B7bq&#\u0017!B1qa2LH\u0003BA\u0001\u0005OBaA!\u001b \u0001\u0004\u0011\u0017!\u0001=\u0002\u0011]LG\u000f\u001b(b[\u0016$B!!\u0001\u0003p!9!\u0011\u000f\u0011A\u0002\u0005e\u0016!A:\u0002\u000bY\u000bG.^3\u0016\u0005\u0005\u0005A\u0003BA\u0001\u0005sBaAa\u001f#\u0001\u0004\u0011\u0017!A5\u0015\t\u0005\u0005!q\u0010\u0005\b\u0005\u0003\u001b\u0003\u0019AA]\u0003\u0011q\u0017-\\3\u0015\r\u0005\u0005!Q\u0011BD\u0011\u0019\u0011Y\b\na\u0001E\"9!\u0011\u0011\u0013A\u0002\u0005e\u0016a\u00049paVd\u0017\r^3OC6,W*\u00199\u0015\u0005\u0005u\u0018A\u00028b[\u0016|e\r\u0006\u0003\u0002:\nE\u0005B\u0002B>M\u0001\u0007!MA\u0002WC2\u001cB\u0001MA\u0001=R1!\u0011\u0014BN\u0005;\u00032!a\u00011\u0011\u0019\u0011Yh\ra\u0001E\"9!\u0011Q\u001aA\u0002\u0005eF\u0003\u0002BM\u0005CCaAa\u001f5\u0001\u0004\u0011G\u0003\u0002BM\u0005KCqA!!6\u0001\u0004\tI\f\u0006\u0002\u0003\u001a\":\u0001'!<\u0002\u001c\n-f\u0004ChjO>NM@|(\u0002\u001bY\u000bG.^3Pe\u0012,'/\u001b8h!\r\t\u0019a\u000f\u0002\u000e-\u0006dW/Z(sI\u0016\u0014\u0018N\\4\u0014\u000bm\u0012),a\u001d\u0011\u0007=\u00149,C\u0002\u0003:B\u0014aa\u00142kK\u000e$HC\u0001BX)\u0015\u0011'q\u0018Ba\u0011\u001d\u0011I'\u0010a\u0001\u0003\u0003AqAa1>\u0001\u0004\t\t!A\u0001z\u0003!1\u0016\r\\;f'\u0016$\bcAA\u0002\u001bN\u0019QJ\u00170\u0015\u0005\t\u001d\u0017AB3naRL\b\u0005\u0006\u0003\u0002D\tE\u0007b\u0002Bj#\u0002\u0007!Q[\u0001\u0006K2,Wn\u001d\t\u00067\n]\u0017\u0011A\u0005\u0004\u000534&A\u0003\u001fsKB,\u0017\r^3e}\u0005YaM]8n\u0005&$X*Y:l)\u0011\t\u0019Ea8\t\u000f\tM'\u000b1\u0001\u0002R\u0006Qa.Z<Ck&dG-\u001a:\u0016\u0005\t\u0015\bcB=\u0003h\u0006\u0005\u00111I\u0005\u0004\u0005ST(a\u0002\"vS2$WM]\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003\u0005_\u0004\"B!=\u0003x\u0006\r\u0013\u0011AA\"\u001b\t\u0011\u0019PC\u0002\u0003vr\fqaZ3oKJL7-\u0003\u0003\u0003z\nM(\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007f\u0002\u0001\u0002n\u0006m%Q \u0010\tk\u0002n]\u001c'\bZ\u001d\u0003")
public abstract class Enumeration
implements Serializable {
    public static final long serialVersionUID = 8476000850333817230L;
    private volatile Enumeration$ValueOrdering$ ValueOrdering$module;
    private volatile Enumeration$ValueSet$ ValueSet$module;
    private final Map<Object, Value> scala$Enumeration$$vmap = new HashMap<Object, Value>();
    private transient ValueSet vset = null;
    private volatile transient boolean scala$Enumeration$$vsetDefined = false;
    private final Map<Object, String> nmap = new HashMap<Object, String>();
    private int nextId;
    private Iterator<String> nextName;
    private int scala$Enumeration$$topId;
    private int scala$Enumeration$$bottomId;

    public Enumeration$ValueOrdering$ ValueOrdering() {
        if (this.ValueOrdering$module == null) {
            this.ValueOrdering$lzycompute$1();
        }
        return this.ValueOrdering$module;
    }

    public Enumeration$ValueSet$ ValueSet() {
        if (this.ValueSet$module == null) {
            this.ValueSet$lzycompute$1();
        }
        return this.ValueSet$module;
    }

    public Object readResolve() {
        return this.getClass().getField("MODULE$").get(null);
    }

    public String toString() {
        String string = this.getClass().getName();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        String string2 = new StringOps(string).stripSuffix("$");
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return (String)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])((String)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new StringOps(string2).split('.'))).last()).split(Regex$.MODULE$.quote("$")))).last();
    }

    public Map<Object, Value> scala$Enumeration$$vmap() {
        return this.scala$Enumeration$$vmap;
    }

    private ValueSet vset() {
        return this.vset;
    }

    private void vset_$eq(ValueSet x$1) {
        this.vset = x$1;
    }

    private boolean scala$Enumeration$$vsetDefined() {
        return this.scala$Enumeration$$vsetDefined;
    }

    public void scala$Enumeration$$vsetDefined_$eq(boolean x$1) {
        this.scala$Enumeration$$vsetDefined = x$1;
    }

    private Map<Object, String> nmap() {
        return this.nmap;
    }

    public ValueSet values() {
        if (!this.scala$Enumeration$$vsetDefined()) {
            this.vset_$eq((ValueSet)((Builder)this.ValueSet().newBuilder().$plus$plus$eq(this.scala$Enumeration$$vmap().values())).result());
            this.scala$Enumeration$$vsetDefined_$eq(true);
        }
        return this.vset();
    }

    public int nextId() {
        return this.nextId;
    }

    public void nextId_$eq(int x$1) {
        this.nextId = x$1;
    }

    public Iterator<String> nextName() {
        return this.nextName;
    }

    public void nextName_$eq(Iterator<String> x$1) {
        this.nextName = x$1;
    }

    public String scala$Enumeration$$nextNameOrNull() {
        if (this.nextName() != null && this.nextName().hasNext()) {
            return this.nextName().next();
        }
        return null;
    }

    public int scala$Enumeration$$topId() {
        return this.scala$Enumeration$$topId;
    }

    public void scala$Enumeration$$topId_$eq(int x$1) {
        this.scala$Enumeration$$topId = x$1;
    }

    public int scala$Enumeration$$bottomId() {
        return this.scala$Enumeration$$bottomId;
    }

    public void scala$Enumeration$$bottomId_$eq(int x$1) {
        this.scala$Enumeration$$bottomId = x$1;
    }

    public final int maxId() {
        return this.scala$Enumeration$$topId();
    }

    public final Value apply(int x) {
        return (Value)this.scala$Enumeration$$vmap().apply(BoxesRunTime.boxToInteger(x));
    }

    public final Value withName(String s) {
        return (Value)this.values().scala$Enumeration$$byName().getOrElse(s, (Function0<Nothing$> & java.io.Serializable & Serializable)() -> {
            throw new NoSuchElementException(new StringBuilder(21).append("No value found for '").append(s).append("'").toString());
        });
    }

    public final Value Value() {
        return this.Value(this.nextId());
    }

    public final Value Value(int i) {
        return this.Value(i, this.scala$Enumeration$$nextNameOrNull());
    }

    public final Value Value(String name) {
        return this.Value(this.nextId(), name);
    }

    public final Value Value(int i, String name) {
        return new Val(this, i, name);
    }

    private void populateNameMap() {
        Field[] fields = this.getClass().getDeclaredFields();
        Method[] methods = (Method[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.getClass().getMethods())).filterImpl((Function1<Method, Object> & java.io.Serializable & Serializable)m -> BoxesRunTime.boxToBoolean(Enumeration.$anonfun$populateNameMap$2(fields, m)), false);
        ArrayOps.ofRef<Object> foreach_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])methods));
        int foreach_len = foreach_this.length();
        for (int foreach_i = 0; foreach_i < foreach_len; ++foreach_i) {
            Method method = (Method)foreach_this.apply(foreach_i);
            Enumeration.$anonfun$populateNameMap$3(this, method);
        }
    }

    public synchronized String scala$Enumeration$$nameOf(int i) {
        return (String)this.nmap().getOrElse(BoxesRunTime.boxToInteger(i), (Function0<String> & java.io.Serializable & Serializable)() -> {
            this.populateNameMap();
            return (String)this.nmap().apply(BoxesRunTime.boxToInteger(i));
        });
    }

    private final void ValueOrdering$lzycompute$1() {
        synchronized (this) {
            if (this.ValueOrdering$module == null) {
                this.ValueOrdering$module = new Enumeration$ValueOrdering$(this);
            }
            return;
        }
    }

    private final void ValueSet$lzycompute$1() {
        synchronized (this) {
            if (this.ValueSet$module == null) {
                this.ValueSet$module = new Enumeration$ValueSet$(this);
            }
            return;
        }
    }

    public static final /* synthetic */ boolean $anonfun$populateNameMap$1(Method m$1, Field fd) {
        String string = fd.getName();
        String string2 = m$1.getName();
        if (!(string != null ? !string.equals(string2) : string2 != null)) {
            Class<?> clazz = fd.getType();
            Class<?> clazz2 = m$1.getReturnType();
            if (!(clazz != null ? !clazz.equals(clazz2) : clazz2 != null)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isValDef$1(Method m, Field[] fields$1) {
        return IndexedSeqOptimized.exists$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])fields$1)), (Function1<Field, Object> & java.io.Serializable & Serializable)fd -> BoxesRunTime.boxToBoolean(Enumeration.$anonfun$populateNameMap$1(m, fd)));
    }

    public static final /* synthetic */ boolean $anonfun$populateNameMap$2(Field[] fields$1, Method m) {
        if (new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])m.getParameterTypes())).isEmpty() && Value.class.isAssignableFrom(m.getReturnType())) {
            Class<?> clazz = m.getDeclaringClass();
            Class<Enumeration> clazz2 = Enumeration.class;
            if ((clazz == null || !clazz.equals(clazz2)) && Enumeration.isValDef$1(m, fields$1)) {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ Object $anonfun$populateNameMap$3(Enumeration $this, Method m) {
        String name = m.getName();
        Value value = (Value)m.invoke($this, new Object[0]);
        if (value.scala$Enumeration$$outerEnum() == $this) {
            int id = value.id();
            return $this.nmap().$plus$eq(new Tuple2<Integer, String>(BoxesRunTime.boxToInteger(id), name));
        }
        return BoxedUnit.UNIT;
    }

    public Enumeration(int initial) {
        this.nextId = initial;
        this.scala$Enumeration$$topId = initial;
        this.scala$Enumeration$$bottomId = initial < 0 ? initial : 0;
    }

    public Enumeration() {
        this(0);
    }

    public class Val
    extends Value {
        public static final long serialVersionUID = -3501153230598116017L;
        private final int i;
        private final String name;

        @Override
        public int id() {
            return this.i;
        }

        public String toString() {
            if (this.name != null) {
                return this.name;
            }
            try {
                return this.scala$Enumeration$Val$$$outer().scala$Enumeration$$nameOf(this.i);
            }
            catch (NoSuchElementException noSuchElementException) {
                return new StringBuilder(30).append("<Invalid enum: no field for #").append(this.i).append(">").toString();
            }
        }

        public Object readResolve() {
            Enumeration enumeration = (Enumeration)this.scala$Enumeration$Val$$$outer().readResolve();
            if (enumeration.scala$Enumeration$$vmap() == null) {
                return this;
            }
            return enumeration.scala$Enumeration$$vmap().apply(BoxesRunTime.boxToInteger(this.i));
        }

        public /* synthetic */ Enumeration scala$Enumeration$Val$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$new$1(Val $this) {
            return new StringBuilder(14).append("Duplicate id: ").append($this.i).toString();
        }

        /*
         * WARNING - void declaration
         */
        public Val(Enumeration $outer, int i, String name) {
            void assert_assertion;
            boolean bl;
            this.i = i;
            this.name = name;
            boolean bl2 = bl = !$outer.scala$Enumeration$$vmap().isDefinedAt(BoxesRunTime.boxToInteger(i));
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)Val.$anonfun$new$1(this)).toString());
            }
            $outer.scala$Enumeration$$vmap().update(BoxesRunTime.boxToInteger(i), this);
            $outer.scala$Enumeration$$vsetDefined_$eq(false);
            $outer.nextId_$eq(i + 1);
            if ($outer.nextId() > $outer.scala$Enumeration$$topId()) {
                $outer.scala$Enumeration$$topId_$eq($outer.nextId());
            }
            if (i < $outer.scala$Enumeration$$bottomId()) {
                $outer.scala$Enumeration$$bottomId_$eq(i);
            }
        }

        public Val(Enumeration $outer, int i) {
            this($outer, i, $outer.scala$Enumeration$$nextNameOrNull());
        }

        public Val(Enumeration $outer, String name) {
            this($outer, $outer.nextId(), name);
        }

        public Val(Enumeration $outer) {
            this($outer, $outer.nextId());
        }
    }

    public abstract class Value
    implements Ordered<Value>,
    Serializable {
        public static final long serialVersionUID = 7091335633555234129L;
        private final Enumeration scala$Enumeration$$outerEnum;

        @Override
        public boolean $less(Object that) {
            return Ordered.$less$(this, that);
        }

        @Override
        public boolean $greater(Object that) {
            return Ordered.$greater$(this, that);
        }

        @Override
        public boolean $less$eq(Object that) {
            return Ordered.$less$eq$(this, that);
        }

        @Override
        public boolean $greater$eq(Object that) {
            return Ordered.$greater$eq$(this, that);
        }

        @Override
        public int compareTo(Object that) {
            return Ordered.compareTo$(this, that);
        }

        public abstract int id();

        public Enumeration scala$Enumeration$$outerEnum() {
            return this.scala$Enumeration$$outerEnum;
        }

        @Override
        public int compare(Value that) {
            if (this.id() < that.id()) {
                return -1;
            }
            if (this.id() == that.id()) {
                return 0;
            }
            return 1;
        }

        public boolean equals(Object other) {
            boolean bl;
            if (other instanceof Value) {
                Value value = (Value)other;
                bl = this.scala$Enumeration$$outerEnum() == value.scala$Enumeration$$outerEnum() && this.id() == value.id();
            } else {
                bl = false;
            }
            return bl;
        }

        public int hashCode() {
            return this.id();
        }

        public ValueSet $plus(Value v) {
            return this.scala$Enumeration$Value$$$outer().ValueSet().apply(Predef$.MODULE$.wrapRefArray((Object[])new Value[]{this, v}));
        }

        public /* synthetic */ Enumeration scala$Enumeration$Value$$$outer() {
            return Enumeration.this;
        }

        public Value() {
            if (Enumeration.this == null) {
                throw null;
            }
            Ordered.$init$(this);
            this.scala$Enumeration$$outerEnum = Enumeration.this;
        }
    }

    public class ValueSet
    extends AbstractSet<Value>
    implements SortedSet<Value>,
    Serializable {
        private scala.collection.immutable.Map<String, Value> scala$Enumeration$$byName;
        private BitSet nnIds;
        private volatile boolean bitmap$0;
        public final /* synthetic */ Enumeration $outer;

        @Override
        public /* synthetic */ boolean scala$collection$immutable$SortedSet$$super$equals(Object that) {
            return GenSetLike.equals$(this, that);
        }

        @Override
        public boolean equals(Object that) {
            return SortedSet.equals$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$SortedSetLike$$super$subsetOf(GenSet that) {
            return GenSetLike.subsetOf$(this, that);
        }

        @Override
        public scala.collection.SortedSet keySet() {
            return SortedSetLike.keySet$(this);
        }

        @Override
        public Object firstKey() {
            return SortedSetLike.firstKey$(this);
        }

        @Override
        public Object lastKey() {
            return SortedSetLike.lastKey$(this);
        }

        @Override
        public scala.collection.SortedSet from(Object from) {
            return SortedSetLike.from$(this, from);
        }

        @Override
        public scala.collection.SortedSet until(Object until) {
            return SortedSetLike.until$(this, until);
        }

        @Override
        public scala.collection.SortedSet range(Object from, Object until) {
            return SortedSetLike.range$(this, from, until);
        }

        @Override
        public boolean subsetOf(GenSet<Value> that) {
            return SortedSetLike.subsetOf$(this, that);
        }

        @Override
        public Iterator iteratorFrom(Object start) {
            return SortedSetLike.iteratorFrom$(this, start);
        }

        @Override
        public int compare(Object k0, Object k1) {
            return Sorted.compare$(this, k0, k1);
        }

        @Override
        public Sorted to(Object to) {
            return Sorted.to$(this, to);
        }

        @Override
        public boolean hasAll(Iterator<Value> j) {
            return Sorted.hasAll$(this, j);
        }

        @Override
        public GenericCompanion<Set> companion() {
            return Set.companion$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return Set.toSet$(this);
        }

        @Override
        public Set<Value> seq() {
            return Set.seq$(this);
        }

        @Override
        public Combiner<Value, ParSet<Value>> parCombiner() {
            return Set.parCombiner$(this);
        }

        @Override
        public Ordering<Value> ordering() {
            return this.scala$Enumeration$ValueSet$$$outer().ValueOrdering();
        }

        @Override
        public ValueSet rangeImpl(Option<Value> from, Option<Value> until) {
            Option option;
            Option option2;
            Enumeration enumeration = this.scala$Enumeration$ValueSet$$$outer();
            if (from == null) {
                throw null;
            }
            if (from.isEmpty()) {
                option2 = None$.MODULE$;
            } else {
                Value value = from.get();
                Option option3 = option2 = new Option(ValueSet.$anonfun$rangeImpl$1$adapted(this, value));
            }
            if (until == null) {
                throw null;
            }
            if (until.isEmpty()) {
                option = None$.MODULE$;
            } else {
                Value value = until.get();
                Some<Object> some = new Some<Object>(ValueSet.$anonfun$rangeImpl$2$adapted(this, value));
                option = some;
            }
            return new ValueSet(enumeration, (BitSet)this.nnIds.rangeImpl(option2, option));
        }

        @Override
        public ValueSet empty() {
            return this.scala$Enumeration$ValueSet$$$outer().ValueSet().empty();
        }

        @Override
        public boolean contains(Value v) {
            return this.nnIds.contains(v.id() - this.scala$Enumeration$ValueSet$$$outer().scala$Enumeration$$bottomId());
        }

        @Override
        public ValueSet $plus(Value value) {
            return new ValueSet(this.scala$Enumeration$ValueSet$$$outer(), this.nnIds.$plus(value.id() - this.scala$Enumeration$ValueSet$$$outer().scala$Enumeration$$bottomId()));
        }

        @Override
        public ValueSet $minus(Value value) {
            return new ValueSet(this.scala$Enumeration$ValueSet$$$outer(), this.nnIds.$minus(value.id() - this.scala$Enumeration$ValueSet$$$outer().scala$Enumeration$$bottomId()));
        }

        @Override
        public Iterator<Value> iterator() {
            return this.nnIds.iterator().map((Function1<Object, Value> & java.io.Serializable & Serializable)id -> ValueSet.$anonfun$iterator$1(this, BoxesRunTime.unboxToInt(id)));
        }

        @Override
        public Iterator<Value> keysIteratorFrom(Value start) {
            return this.nnIds.keysIteratorFrom(start.id()).map((Function1<Object, Value> & java.io.Serializable & Serializable)id -> ValueSet.$anonfun$keysIteratorFrom$1(this, BoxesRunTime.unboxToInt(id)));
        }

        @Override
        public String stringPrefix() {
            return Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this.scala$Enumeration$ValueSet$$$outer()), ".ValueSet");
        }

        public long[] toBitMask() {
            return this.nnIds.toBitMask();
        }

        private scala.collection.immutable.Map<String, Value> scala$Enumeration$$byName$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.scala$Enumeration$$byName = this.iterator().map((Function1<Value, Tuple2> & java.io.Serializable & Serializable)v -> {
                        void $minus$greater$extension_$this;
                        String string = Predef$.MODULE$.ArrowAssoc(v.toString());
                        if (Predef$ArrowAssoc$.MODULE$ == null) {
                            throw null;
                        }
                        return new Tuple2<void, Value>($minus$greater$extension_$this, (Value)v);
                    }).toMap(Predef$.MODULE$.$conforms());
                    this.bitmap$0 = true;
                }
            }
            return this.scala$Enumeration$$byName;
        }

        public scala.collection.immutable.Map<String, Value> scala$Enumeration$$byName() {
            if (!this.bitmap$0) {
                return this.scala$Enumeration$$byName$lzycompute();
            }
            return this.scala$Enumeration$$byName;
        }

        public /* synthetic */ Enumeration scala$Enumeration$ValueSet$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ int $anonfun$rangeImpl$1(ValueSet $this, Value x$1) {
            return x$1.id() - $this.scala$Enumeration$ValueSet$$$outer().scala$Enumeration$$bottomId();
        }

        public static final /* synthetic */ int $anonfun$rangeImpl$2(ValueSet $this, Value x$2) {
            return x$2.id() - $this.scala$Enumeration$ValueSet$$$outer().scala$Enumeration$$bottomId();
        }

        public static final /* synthetic */ Value $anonfun$iterator$1(ValueSet $this, int id) {
            return $this.scala$Enumeration$ValueSet$$$outer().apply($this.scala$Enumeration$ValueSet$$$outer().scala$Enumeration$$bottomId() + id);
        }

        public static final /* synthetic */ Value $anonfun$keysIteratorFrom$1(ValueSet $this, int id) {
            return $this.scala$Enumeration$ValueSet$$$outer().apply($this.scala$Enumeration$ValueSet$$$outer().scala$Enumeration$$bottomId() + id);
        }

        public ValueSet(Enumeration $outer, BitSet nnIds) {
            this.nnIds = nnIds;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Traversable.$init$(this);
            Iterable.$init$(this);
            Set.$init$(this);
            Sorted.$init$(this);
            SortedSetLike.$init$(this);
            scala.collection.SortedSet.$init$(this);
            SortedSet.$init$(this);
        }

        public static final /* synthetic */ Object $anonfun$rangeImpl$1$adapted(ValueSet $this, Value x$1) {
            return BoxesRunTime.boxToInteger(ValueSet.$anonfun$rangeImpl$1($this, x$1));
        }

        public static final /* synthetic */ Object $anonfun$rangeImpl$2$adapted(ValueSet $this, Value x$2) {
            return BoxesRunTime.boxToInteger(ValueSet.$anonfun$rangeImpl$2($this, x$2));
        }
    }
}

