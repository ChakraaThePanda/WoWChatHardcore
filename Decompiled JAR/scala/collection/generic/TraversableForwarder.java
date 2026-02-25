/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Predef$;
import scala.Tuple2;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\ruaaB\u00181!\u0003\r\ta\u000e\u0005\u0006\u0019\u0002!\t!\u0014\u0005\u0006#\u00021\tB\u0015\u0005\u0006'\u0002!\t\u0005\u0016\u0005\u0006=\u0002!\te\u0018\u0005\u0006G\u0002!\te\u0018\u0005\u0006I\u0002!\t%\u001a\u0005\u0006S\u0002!\te\u0018\u0005\u0006U\u0002!\te\u001b\u0005\u0006_\u0002!\t\u0005\u001d\u0005\u0006e\u0002!\te\u001d\u0005\u0006k\u0002!\tE\u001e\u0005\u0006w\u0002!\t\u0005 \u0005\b\u0003'\u0001A\u0011IA\u000b\u0011\u001d\t)\u0003\u0001C!\u0003OAq!a\u000e\u0001\t\u0003\nI\u0004C\u0004\u0002J\u0001!\t%a\u0013\t\u000f\u0005e\u0003\u0001\"\u0011\u0002\\!9\u0011\u0011\u000e\u0001\u0005B\u0005-\u0004bBA<\u0001\u0011\u0005\u0013\u0011\u0010\u0005\b\u0003\u000f\u0003A\u0011IAE\u0011\u001d\t\u0019\u000b\u0001C!\u0003KCq!!-\u0001\t\u0003\n\u0019\fC\u0004\u0002F\u0002!\t%a2\t\u000f\u0005M\u0007\u0001\"\u0011\u0002V\"9\u0011q\u001b\u0001\u0005B\u0005e\u0007bBAn\u0001\u0011\u0005\u0013Q\u001b\u0005\b\u0003;\u0004A\u0011IAm\u0011\u001d\ty\u000e\u0001C!\u0003CDq!!?\u0001\t\u0003\nY\u0010C\u0004\u0002z\u0002!\tE!\u0006\t\u000f\u0005e\b\u0001\"\u0011\u0003$!9!q\u0006\u0001\u0005B\tE\u0002b\u0002B&\u0001\u0011\u0005#Q\n\u0005\b\u00057\u0002A\u0011\tB/\u0011\u001d\u0011)\u0007\u0001C!\u0005OBqAa\u001c\u0001\t\u0003\u0012\t\bC\u0004\u0003z\u0001!\tEa\u001f\t\u000f\t\u0015\u0005\u0001\"\u0011\u0003\b\"9!q\u0012\u0001\u0005B\tE\u0005b\u0002BP\u0001\u0011\u0005#\u0011\u0015\u0005\b\u0005+\u0004A\u0011\tBl\u0011\u001d\u0011)\u000e\u0001C!\u0005SDqA!6\u0001\t\u0003\u0012i\u000fC\u0004\u0003p\u0002!\tE!=\t\u000f\t=\b\u0001\"\u0011\u0004\u0004!9!q\u001e\u0001\u0005B\r%!\u0001\u0006+sCZ,'o]1cY\u00164uN]<be\u0012,'O\u0003\u00022e\u00059q-\u001a8fe&\u001c'BA\u001a5\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002k\u0005)1oY1mC\u000e\u0001QC\u0001\u001dD'\r\u0001\u0011(\u0010\t\u0003umj\u0011\u0001N\u0005\u0003yQ\u0012a!\u00118z%\u00164\u0007c\u0001 @\u00036\t!'\u0003\u0002Ae\tYAK]1wKJ\u001c\u0018M\u00197f!\t\u00115\t\u0004\u0001\u0005\r\u0011\u0003AQ1\u0001F\u0005\u0005\t\u0015C\u0001$J!\tQt)\u0003\u0002Ii\t9aj\u001c;iS:<\u0007C\u0001\u001eK\u0013\tYEGA\u0002B]f\fa\u0001J5oSR$C#\u0001(\u0011\u0005iz\u0015B\u0001)5\u0005\u0011)f.\u001b;\u0002\u0015UtG-\u001a:ms&tw-F\u0001>\u0003\u001d1wN]3bG\",\"!\u0016/\u0015\u000593\u0006\"B,\u0004\u0001\u0004A\u0016!\u00014\u0011\tiJ\u0016iW\u0005\u00035R\u0012\u0011BR;oGRLwN\\\u0019\u0011\u0005\tcF!B/\u0004\u0005\u0004)%!A+\u0002\u000f%\u001cX)\u001c9usV\t\u0001\r\u0005\u0002;C&\u0011!\r\u000e\u0002\b\u0005>|G.Z1o\u0003!qwN\\#naRL\u0018\u0001B:ju\u0016,\u0012A\u001a\t\u0003u\u001dL!\u0001\u001b\u001b\u0003\u0007%sG/A\biCN$UMZ5oSR,7+\u001b>f\u0003\u00191wN]1mYR\u0011\u0001\r\u001c\u0005\u0006[\"\u0001\rA\\\u0001\u0002aB!!(W!a\u0003\u0019)\u00070[:ugR\u0011\u0001-\u001d\u0005\u0006[&\u0001\rA\\\u0001\u0006G>,h\u000e\u001e\u000b\u0003MRDQ!\u001c\u0006A\u00029\fAAZ5oIR\u0011qO\u001f\t\u0004ua\f\u0015BA=5\u0005\u0019y\u0005\u000f^5p]\")Qn\u0003a\u0001]\u0006Aam\u001c7e\u0019\u00164G/F\u0002~\u0003\u0003!2A`A\b)\ry\u0018Q\u0001\t\u0004\u0005\u0006\u0005AABA\u0002\u0019\t\u0007QIA\u0001C\u0011\u001d\t9\u0001\u0004a\u0001\u0003\u0013\t!a\u001c9\u0011\ri\nYa`!\u0000\u0013\r\ti\u0001\u000e\u0002\n\rVt7\r^5p]JBa!!\u0005\r\u0001\u0004y\u0018!\u0001>\u0002\u0015\u0011\"\u0017N\u001e\u0013d_2|g.\u0006\u0003\u0002\u0018\u0005uA\u0003BA\r\u0003G!B!a\u0007\u0002 A\u0019!)!\b\u0005\r\u0005\rQB1\u0001F\u0011\u001d\t9!\u0004a\u0001\u0003C\u0001\u0002BOA\u0006\u00037\t\u00151\u0004\u0005\b\u0003#i\u0001\u0019AA\u000e\u0003%1w\u000e\u001c3SS\u001eDG/\u0006\u0003\u0002*\u0005=B\u0003BA\u0016\u0003k!B!!\f\u00022A\u0019!)a\f\u0005\r\u0005\raB1\u0001F\u0011\u001d\t9A\u0004a\u0001\u0003g\u0001\u0002BOA\u0006\u0003\u00065\u0012Q\u0006\u0005\b\u0003#q\u0001\u0019AA\u0017\u00035!3m\u001c7p]\u0012\u00127\u000f\\1tQV!\u00111HA!)\u0011\ti$a\u0012\u0015\t\u0005}\u00121\t\t\u0004\u0005\u0006\u0005CABA\u0002\u001f\t\u0007Q\tC\u0004\u0002\b=\u0001\r!!\u0012\u0011\u0011i\nY!QA \u0003\u007fAq!!\u0005\u0010\u0001\u0004\ty$\u0001\u0006sK\u0012,8-\u001a'fMR,B!!\u0014\u0002RQ!\u0011qJA+!\r\u0011\u0015\u0011\u000b\u0003\b\u0003\u0007\u0001\"\u0019AA*#\t\t\u0015\nC\u0004\u0002\bA\u0001\r!a\u0016\u0011\u0011i\nY!a\u0014B\u0003\u001f\n\u0001C]3ek\u000e,G*\u001a4u\u001fB$\u0018n\u001c8\u0016\t\u0005u\u00131\r\u000b\u0005\u0003?\n)\u0007\u0005\u0003;q\u0006\u0005\u0004c\u0001\"\u0002d\u00119\u00111A\tC\u0002\u0005M\u0003bBA\u0004#\u0001\u0007\u0011q\r\t\tu\u0005-\u0011\u0011M!\u0002b\u0005Y!/\u001a3vG\u0016\u0014\u0016n\u001a5u+\u0011\ti'!\u001d\u0015\t\u0005=\u00141\u000f\t\u0004\u0005\u0006EDaBA\u0002%\t\u0007\u00111\u000b\u0005\b\u0003\u000f\u0011\u0002\u0019AA;!!Q\u00141B!\u0002p\u0005=\u0014!\u0005:fIV\u001cWMU5hQR|\u0005\u000f^5p]V!\u00111PAA)\u0011\ti(a!\u0011\tiB\u0018q\u0010\t\u0004\u0005\u0006\u0005EaBA\u0002'\t\u0007\u00111\u000b\u0005\b\u0003\u000f\u0019\u0002\u0019AAC!!Q\u00141B!\u0002\u0000\u0005}\u0014aA:v[V!\u00111RAH)\u0011\ti)!%\u0011\u0007\t\u000by\tB\u0004\u0002\u0004Q\u0011\r!a\u0015\t\u000f\u0005ME\u0003q\u0001\u0002\u0016\u0006\u0019a.^7\u0011\r\u0005]\u0015QTAG\u001d\rQ\u0014\u0011T\u0005\u0004\u00037#\u0014a\u00029bG.\fw-Z\u0005\u0005\u0003?\u000b\tKA\u0004Ok6,'/[2\u000b\u0007\u0005mE'A\u0004qe>$Wo\u0019;\u0016\t\u0005\u001d\u00161\u0016\u000b\u0005\u0003S\u000bi\u000bE\u0002C\u0003W#q!a\u0001\u0016\u0005\u0004\t\u0019\u0006C\u0004\u0002\u0014V\u0001\u001d!a,\u0011\r\u0005]\u0015QTAU\u0003\ri\u0017N\\\u000b\u0005\u0003k\u000b\u0019\rF\u0002B\u0003oCq!!/\u0017\u0001\b\tY,A\u0002d[B\u0004b!a&\u0002>\u0006\u0005\u0017\u0002BA`\u0003C\u0013\u0001b\u0014:eKJLgn\u001a\t\u0004\u0005\u0006\rGaBA\u0002-\t\u0007\u00111K\u0001\u0004[\u0006DX\u0003BAe\u0003#$2!QAf\u0011\u001d\tIl\u0006a\u0002\u0003\u001b\u0004b!a&\u0002>\u0006=\u0007c\u0001\"\u0002R\u00129\u00111A\fC\u0002\u0005M\u0013\u0001\u00025fC\u0012,\u0012!Q\u0001\u000bQ\u0016\fGm\u00149uS>tW#A<\u0002\t1\f7\u000f^\u0001\u000bY\u0006\u001cHo\u00149uS>t\u0017\u0001D2paf$vNQ;gM\u0016\u0014X\u0003BAr\u0003o$2ATAs\u0011\u001d\t9\u000f\ba\u0001\u0003S\fA\u0001Z3tiB1\u00111^Ay\u0003kl!!!<\u000b\u0007\u0005=('A\u0004nkR\f'\r\\3\n\t\u0005M\u0018Q\u001e\u0002\u0007\u0005V4g-\u001a:\u0011\u0007\t\u000b9\u0010B\u0004\u0002\u0004q\u0011\r!a\u0015\u0002\u0017\r|\u0007/\u001f+p\u0003J\u0014\u0018-_\u000b\u0005\u0003{\u0014Y\u0001F\u0004O\u0003\u007f\u0014iA!\u0005\t\u000f\t\u0005Q\u00041\u0001\u0003\u0004\u0005\u0011\u0001p\u001d\t\u0006u\t\u0015!\u0011B\u0005\u0004\u0005\u000f!$!B!se\u0006L\bc\u0001\"\u0003\f\u00119\u00111A\u000fC\u0002\u0005M\u0003B\u0002B\b;\u0001\u0007a-A\u0003ti\u0006\u0014H\u000f\u0003\u0004\u0003\u0014u\u0001\rAZ\u0001\u0004Y\u0016tW\u0003\u0002B\f\u0005?!RA\u0014B\r\u0005CAqA!\u0001\u001f\u0001\u0004\u0011Y\u0002E\u0003;\u0005\u000b\u0011i\u0002E\u0002C\u0005?!q!a\u0001\u001f\u0005\u0004\t\u0019\u0006\u0003\u0004\u0003\u0010y\u0001\rAZ\u000b\u0005\u0005K\u0011i\u0003F\u0002O\u0005OAqA!\u0001 \u0001\u0004\u0011I\u0003E\u0003;\u0005\u000b\u0011Y\u0003E\u0002C\u0005[!q!a\u0001 \u0005\u0004\t\u0019&A\u0004u_\u0006\u0013(/Y=\u0016\t\tM\"\u0011\b\u000b\u0005\u0005k\u0011Y\u0004E\u0003;\u0005\u000b\u00119\u0004E\u0002C\u0005s!q!a\u0001!\u0005\u0004\t\u0019\u0006C\u0005\u0003>\u0001\n\t\u0011q\u0001\u0003@\u0005QQM^5eK:\u001cW\rJ\u0019\u0011\r\t\u0005#q\tB\u001c\u001b\t\u0011\u0019EC\u0002\u0003FQ\nqA]3gY\u0016\u001cG/\u0003\u0003\u0003J\t\r#\u0001C\"mCN\u001cH+Y4\u0002\rQ|G*[:u+\t\u0011y\u0005E\u0003\u0003R\t]\u0013)\u0004\u0002\u0003T)\u0019!Q\u000b\u001a\u0002\u0013%lW.\u001e;bE2,\u0017\u0002\u0002B-\u0005'\u0012A\u0001T5ti\u0006QAo\\%uKJ\f'\r\\3\u0016\u0005\t}\u0003\u0003\u0002 \u0003b\u0005K1Aa\u00193\u0005!IE/\u001a:bE2,\u0017!\u0002;p'\u0016\fXC\u0001B5!\u0011q$1N!\n\u0007\t5$GA\u0002TKF\fA\u0002^8J]\u0012,\u00070\u001a3TKF,\"Aa\u001d\u0011\u000b\tE#QO!\n\t\t]$1\u000b\u0002\u000b\u0013:$W\r_3e'\u0016\f\u0018\u0001\u0003;p\u0005V4g-\u001a:\u0016\t\tu$1Q\u000b\u0003\u0005\u007f\u0002b!a;\u0002r\n\u0005\u0005c\u0001\"\u0003\u0004\u00129\u00111A\u0013C\u0002\u0005M\u0013\u0001\u0003;p'R\u0014X-Y7\u0016\u0005\t%\u0005#\u0002B)\u0005\u0017\u000b\u0015\u0002\u0002BG\u0005'\u0012aa\u0015;sK\u0006l\u0017!\u0002;p'\u0016$X\u0003\u0002BJ\u0005;+\"A!&\u0011\r\tE#q\u0013BN\u0013\u0011\u0011IJa\u0015\u0003\u0007M+G\u000fE\u0002C\u0005;#q!a\u0001(\u0005\u0004\t\u0019&A\u0003u_6\u000b\u0007/\u0006\u0004\u0003$\n5&1\u0017\u000b\u0005\u0005K\u0013)\f\u0005\u0005\u0003R\t\u001d&1\u0016BY\u0013\u0011\u0011IKa\u0015\u0003\u00075\u000b\u0007\u000fE\u0002C\u0005[#aAa,)\u0005\u0004)%!\u0001+\u0011\u0007\t\u0013\u0019\fB\u0003^Q\t\u0007Q\tC\u0004\u00038\"\u0002\u001dA!/\u0002\u0005\u00154\bc\u0002B^\u0005\u0013\f%q\u001a\b\u0005\u0005{\u0013)\rE\u0002\u0003@Rj!A!1\u000b\u0007\t\rg'\u0001\u0004=e>|GOP\u0005\u0004\u0005\u000f$\u0014A\u0002)sK\u0012,g-\u0003\u0003\u0003L\n5'\u0001\u0005\u0013mKN\u001cHeY8m_:$C.Z:t\u0015\r\u00119\r\u000e\t\bu\tE'1\u0016BY\u0013\r\u0011\u0019\u000e\u000e\u0002\u0007)V\u0004H.\u001a\u001a\u0002\u00115\\7\u000b\u001e:j]\u001e$\u0002B!7\u0003`\n\u0005(Q\u001d\t\u0005\u0005w\u0013Y.\u0003\u0003\u0003^\n5'AB*ue&tw\rC\u0004\u0003\u0010%\u0002\rA!7\t\u000f\t\r\u0018\u00061\u0001\u0003Z\u0006\u00191/\u001a9\t\u000f\t\u001d\u0018\u00061\u0001\u0003Z\u0006\u0019QM\u001c3\u0015\t\te'1\u001e\u0005\b\u0005GT\u0003\u0019\u0001Bm+\t\u0011I.A\u0005bI\u0012\u001cFO]5oORQ!1\u001fB}\u0005{\u0014yp!\u0001\u0011\t\u0005-(Q_\u0005\u0005\u0005o\fiOA\u0007TiJLgn\u001a\"vS2$WM\u001d\u0005\b\u0005wd\u0003\u0019\u0001Bz\u0003\u0005\u0011\u0007b\u0002B\bY\u0001\u0007!\u0011\u001c\u0005\b\u0005Gd\u0003\u0019\u0001Bm\u0011\u001d\u00119\u000f\fa\u0001\u00053$bAa=\u0004\u0006\r\u001d\u0001b\u0002B~[\u0001\u0007!1\u001f\u0005\b\u0005Gl\u0003\u0019\u0001Bm)\u0011\u0011\u0019pa\u0003\t\u000f\tmh\u00061\u0001\u0003t\":\u0001aa\u0004\u0004\u0016\re\u0001c\u0001\u001e\u0004\u0012%\u001911\u0003\u001b\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0004\u0018\u0005qfm\u001c:xCJ$\u0017N\\4!SN\u0004\u0013N\u001c5fe\u0016tG\u000f\\=!k:\u0014X\r\\5bE2,\u0007e]5oG\u0016\u0004\u0013\u000e\u001e\u0011jg\u0002rw\u000e\u001e\u0011bkR|W.\u0019;fI\u0002\ng\u000e\u001a\u0011oK^\u0004S.\u001a;i_\u0012\u001c\beY1oA\t,\u0007EZ8sO>$H/\u001a8\"\u0005\rm\u0011A\u0002\u001a/cEr\u0003\u0007")
public interface TraversableForwarder<A>
extends Traversable<A> {
    public Traversable<A> underlying();

    public static /* synthetic */ void foreach$(TraversableForwarder $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        this.underlying().foreach(f);
    }

    public static /* synthetic */ boolean isEmpty$(TraversableForwarder $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return this.underlying().isEmpty();
    }

    public static /* synthetic */ boolean nonEmpty$(TraversableForwarder $this) {
        return $this.nonEmpty();
    }

    @Override
    default public boolean nonEmpty() {
        return this.underlying().nonEmpty();
    }

    public static /* synthetic */ int size$(TraversableForwarder $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        return this.underlying().size();
    }

    public static /* synthetic */ boolean hasDefiniteSize$(TraversableForwarder $this) {
        return $this.hasDefiniteSize();
    }

    @Override
    default public boolean hasDefiniteSize() {
        return this.underlying().hasDefiniteSize();
    }

    public static /* synthetic */ boolean forall$(TraversableForwarder $this, Function1 p) {
        return $this.forall(p);
    }

    @Override
    default public boolean forall(Function1<A, Object> p) {
        return this.underlying().forall(p);
    }

    public static /* synthetic */ boolean exists$(TraversableForwarder $this, Function1 p) {
        return $this.exists(p);
    }

    @Override
    default public boolean exists(Function1<A, Object> p) {
        return this.underlying().exists(p);
    }

    public static /* synthetic */ int count$(TraversableForwarder $this, Function1 p) {
        return $this.count(p);
    }

    @Override
    default public int count(Function1<A, Object> p) {
        return this.underlying().count(p);
    }

    public static /* synthetic */ Option find$(TraversableForwarder $this, Function1 p) {
        return $this.find(p);
    }

    @Override
    default public Option<A> find(Function1<A, Object> p) {
        return this.underlying().find(p);
    }

    public static /* synthetic */ Object foldLeft$(TraversableForwarder $this, Object z, Function2 op) {
        return $this.foldLeft(z, op);
    }

    @Override
    default public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return this.underlying().foldLeft(z, op);
    }

    public static /* synthetic */ Object $div$colon$(TraversableForwarder $this, Object z, Function2 op) {
        return $this.$div$colon(z, op);
    }

    @Override
    default public <B> B $div$colon(B z, Function2<B, A, B> op) {
        return this.underlying().$div$colon(z, op);
    }

    public static /* synthetic */ Object foldRight$(TraversableForwarder $this, Object z, Function2 op) {
        return $this.foldRight(z, op);
    }

    @Override
    default public <B> B foldRight(B z, Function2<A, B, B> op) {
        return this.underlying().foldRight(z, op);
    }

    public static /* synthetic */ Object $colon$bslash$(TraversableForwarder $this, Object z, Function2 op) {
        return $this.$colon$bslash(z, op);
    }

    @Override
    default public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
        return this.underlying().$colon$bslash(z, op);
    }

    public static /* synthetic */ Object reduceLeft$(TraversableForwarder $this, Function2 op) {
        return $this.reduceLeft(op);
    }

    @Override
    default public <B> B reduceLeft(Function2<B, A, B> op) {
        return this.underlying().reduceLeft(op);
    }

    public static /* synthetic */ Option reduceLeftOption$(TraversableForwarder $this, Function2 op) {
        return $this.reduceLeftOption(op);
    }

    @Override
    default public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
        return this.underlying().reduceLeftOption(op);
    }

    public static /* synthetic */ Object reduceRight$(TraversableForwarder $this, Function2 op) {
        return $this.reduceRight(op);
    }

    @Override
    default public <B> B reduceRight(Function2<A, B, B> op) {
        return this.underlying().reduceRight(op);
    }

    public static /* synthetic */ Option reduceRightOption$(TraversableForwarder $this, Function2 op) {
        return $this.reduceRightOption(op);
    }

    @Override
    default public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
        return this.underlying().reduceRightOption(op);
    }

    public static /* synthetic */ Object sum$(TraversableForwarder $this, Numeric num) {
        return $this.sum(num);
    }

    @Override
    default public <B> B sum(Numeric<B> num) {
        return this.underlying().sum(num);
    }

    public static /* synthetic */ Object product$(TraversableForwarder $this, Numeric num) {
        return $this.product(num);
    }

    @Override
    default public <B> B product(Numeric<B> num) {
        return this.underlying().product(num);
    }

    public static /* synthetic */ Object min$(TraversableForwarder $this, Ordering cmp) {
        return $this.min(cmp);
    }

    @Override
    default public <B> A min(Ordering<B> cmp) {
        return this.underlying().min(cmp);
    }

    public static /* synthetic */ Object max$(TraversableForwarder $this, Ordering cmp) {
        return $this.max(cmp);
    }

    @Override
    default public <B> A max(Ordering<B> cmp) {
        return this.underlying().max(cmp);
    }

    public static /* synthetic */ Object head$(TraversableForwarder $this) {
        return $this.head();
    }

    @Override
    default public A head() {
        return this.underlying().head();
    }

    public static /* synthetic */ Option headOption$(TraversableForwarder $this) {
        return $this.headOption();
    }

    @Override
    default public Option<A> headOption() {
        return this.underlying().headOption();
    }

    public static /* synthetic */ Object last$(TraversableForwarder $this) {
        return $this.last();
    }

    @Override
    default public A last() {
        return this.underlying().last();
    }

    public static /* synthetic */ Option lastOption$(TraversableForwarder $this) {
        return $this.lastOption();
    }

    @Override
    default public Option<A> lastOption() {
        return this.underlying().lastOption();
    }

    public static /* synthetic */ void copyToBuffer$(TraversableForwarder $this, Buffer dest) {
        $this.copyToBuffer(dest);
    }

    @Override
    default public <B> void copyToBuffer(Buffer<B> dest) {
        this.underlying().copyToBuffer(dest);
    }

    public static /* synthetic */ void copyToArray$(TraversableForwarder $this, Object xs, int start, int len) {
        $this.copyToArray(xs, start, len);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start, int len) {
        this.underlying().copyToArray(xs, start, len);
    }

    public static /* synthetic */ void copyToArray$(TraversableForwarder $this, Object xs, int start) {
        $this.copyToArray(xs, start);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start) {
        this.underlying().copyToArray(xs, start);
    }

    public static /* synthetic */ void copyToArray$(TraversableForwarder $this, Object xs) {
        $this.copyToArray(xs);
    }

    @Override
    default public <B> void copyToArray(Object xs) {
        this.underlying().copyToArray(xs);
    }

    public static /* synthetic */ Object toArray$(TraversableForwarder $this, ClassTag evidence$1) {
        return $this.toArray(evidence$1);
    }

    @Override
    default public <B> Object toArray(ClassTag<B> evidence$1) {
        return this.underlying().toArray(evidence$1);
    }

    public static /* synthetic */ List toList$(TraversableForwarder $this) {
        return $this.toList();
    }

    @Override
    default public List<A> toList() {
        return this.underlying().toList();
    }

    public static /* synthetic */ Iterable toIterable$(TraversableForwarder $this) {
        return $this.toIterable();
    }

    @Override
    default public Iterable<A> toIterable() {
        return this.underlying().toIterable();
    }

    public static /* synthetic */ Seq toSeq$(TraversableForwarder $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<A> toSeq() {
        return this.underlying().toSeq();
    }

    public static /* synthetic */ IndexedSeq toIndexedSeq$(TraversableForwarder $this) {
        return $this.toIndexedSeq();
    }

    @Override
    default public IndexedSeq<A> toIndexedSeq() {
        return this.underlying().toIndexedSeq();
    }

    public static /* synthetic */ Buffer toBuffer$(TraversableForwarder $this) {
        return $this.toBuffer();
    }

    @Override
    default public <B> Buffer<B> toBuffer() {
        return this.underlying().toBuffer();
    }

    public static /* synthetic */ Stream toStream$(TraversableForwarder $this) {
        return $this.toStream();
    }

    @Override
    default public Stream<A> toStream() {
        return this.underlying().toStream();
    }

    public static /* synthetic */ Set toSet$(TraversableForwarder $this) {
        return $this.toSet();
    }

    @Override
    default public <B> Set<B> toSet() {
        return this.underlying().toSet();
    }

    public static /* synthetic */ Map toMap$(TraversableForwarder $this, Predef$.less.colon.less ev) {
        return $this.toMap(ev);
    }

    @Override
    default public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
        return this.underlying().toMap(ev);
    }

    public static /* synthetic */ String mkString$(TraversableForwarder $this, String start, String sep, String end) {
        return $this.mkString(start, sep, end);
    }

    @Override
    default public String mkString(String start, String sep, String end) {
        return this.underlying().mkString(start, sep, end);
    }

    public static /* synthetic */ String mkString$(TraversableForwarder $this, String sep) {
        return $this.mkString(sep);
    }

    @Override
    default public String mkString(String sep) {
        return this.underlying().mkString(sep);
    }

    public static /* synthetic */ String mkString$(TraversableForwarder $this) {
        return $this.mkString();
    }

    @Override
    default public String mkString() {
        return this.underlying().mkString();
    }

    public static /* synthetic */ StringBuilder addString$(TraversableForwarder $this, StringBuilder b, String start, String sep, String end) {
        return $this.addString(b, start, sep, end);
    }

    @Override
    default public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return this.underlying().addString(b, start, sep, end);
    }

    public static /* synthetic */ StringBuilder addString$(TraversableForwarder $this, StringBuilder b, String sep) {
        return $this.addString(b, sep);
    }

    @Override
    default public StringBuilder addString(StringBuilder b, String sep) {
        return this.underlying().addString(b, sep);
    }

    public static /* synthetic */ StringBuilder addString$(TraversableForwarder $this, StringBuilder b) {
        return $this.addString(b);
    }

    @Override
    default public StringBuilder addString(StringBuilder b) {
        return this.underlying().addString(b);
    }

    public static void $init$(TraversableForwarder $this) {
    }
}

