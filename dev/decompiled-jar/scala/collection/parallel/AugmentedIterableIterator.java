/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function1;
import scala.Function2;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.TraversableOnce;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.RemainsIterator;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\rEb\u0001C\u000f\u001f!\u0003\r\t\u0001\t\u0013\t\u000bi\u0002A\u0011A\u001e\t\u000b}\u0002A\u0011\t!\t\u000b1\u0003A\u0011I'\t\u000ba\u0003A\u0011I-\t\u000b\t\u0004A\u0011I2\t\u000bA\u0004A\u0011I9\t\u000b]\u0004A\u0011\t=\t\u000f\u0005\r\u0001\u0001\"\u0011\u0002\u0006!9\u0011\u0011\u0003\u0001\u0005B\u0005M\u0001bBA\u0017\u0001\u0011\u0005\u0011q\u0006\u0005\b\u0003\u007f\u0001A\u0011AA!\u0011\u001d\t\t\u0007\u0001C\u0001\u0003GBq!! \u0001\t\u0003\ty\bC\u0004\u0002\u001c\u0002!\t!!(\t\u000f\u0005\r\u0007\u0001\"\u0001\u0002F\"9\u00111\u001c\u0001\u0005\u0002\u0005u\u0007bBAx\u0001\u0011\u0005\u0011\u0011\u001f\u0005\b\u0005\u001f\u0001A\u0011\u0001B\t\u0011\u001d\u0011)\u0003\u0001C\u0001\u0005OAqA!\u000f\u0001\t\u0003\u0011Y\u0004C\u0004\u0003R\u0001!\tAa\u0015\t\u000f\t=\u0004\u0001\"\u0001\u0003r!9!Q\u0011\u0001\u0005\u0002\t\u001d\u0005b\u0002BO\u0001\u0011\u0005!q\u0014\u0005\b\u0005w\u0003A\u0011\u0001B_\u0011\u001d\u0011Y\f\u0001C\u0001\u0005+DqA!<\u0001\t\u0003\u0011y\u000fC\u0004\u0004\f\u0001!\ta!\u0004\u00033\u0005+x-\\3oi\u0016$\u0017\n^3sC\ndW-\u0013;fe\u0006$xN\u001d\u0006\u0003?\u0001\n\u0001\u0002]1sC2dW\r\u001c\u0006\u0003C\t\n!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0019\u0013!B:dC2\fWCA\u00131'\r\u0001aE\u000b\t\u0003O!j\u0011AI\u0005\u0003S\t\u0012a!\u00118z%\u00164\u0007cA\u0016-]5\ta$\u0003\u0002.=\ty!+Z7bS:\u001c\u0018\n^3sCR|'\u000f\u0005\u00020a1\u0001AAB\u0019\u0001\t\u000b\u00071GA\u0001U\u0007\u0001\t\"\u0001N\u001c\u0011\u0005\u001d*\u0014B\u0001\u001c#\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"a\n\u001d\n\u0005e\u0012#aA!os\u00061A%\u001b8ji\u0012\"\u0012\u0001\u0010\t\u0003OuJ!A\u0010\u0012\u0003\tUs\u0017\u000e^\u0001\u0006G>,h\u000e\u001e\u000b\u0003\u0003\u0012\u0003\"a\n\"\n\u0005\r\u0013#aA%oi\")QI\u0001a\u0001\r\u0006\t\u0001\u000f\u0005\u0003(\u000f:J\u0015B\u0001%#\u0005%1UO\\2uS>t\u0017\u0007\u0005\u0002(\u0015&\u00111J\t\u0002\b\u0005>|G.Z1o\u0003\u0019\u0011X\rZ;dKV\u0011a\n\u0015\u000b\u0003\u001fN\u0003\"a\f)\u0005\u000bE\u001b!\u0019\u0001*\u0003\u0003U\u000b\"AL\u001c\t\u000bQ\u001b\u0001\u0019A+\u0002\u0005=\u0004\b#B\u0014W\u001f>{\u0015BA,#\u0005%1UO\\2uS>t''\u0001\u0003g_2$WC\u0001.^)\tY\u0006\r\u0006\u0002]=B\u0011q&\u0018\u0003\u0006#\u0012\u0011\rA\u0015\u0005\u0006)\u0012\u0001\ra\u0018\t\u0006OYcF\f\u0018\u0005\u0006C\u0012\u0001\r\u0001X\u0001\u0002u\u0006\u00191/^7\u0016\u0005\u00114GCA3h!\tyc\rB\u0003R\u000b\t\u0007!\u000bC\u0003i\u000b\u0001\u000f\u0011.A\u0002ok6\u00042A[7f\u001d\t93.\u0003\u0002mE\u00059\u0001/Y2lC\u001e,\u0017B\u00018p\u0005\u001dqU/\\3sS\u000eT!\u0001\u001c\u0012\u0002\u000fA\u0014x\u000eZ;diV\u0011!\u000f\u001e\u000b\u0003gV\u0004\"a\f;\u0005\u000bE3!\u0019\u0001*\t\u000b!4\u00019\u0001<\u0011\u0007)l7/A\u0002nS:,2!_A\u0001)\tq#\u0010C\u0003|\u000f\u0001\u000fA0A\u0002pe\u0012\u00042A[?\u0000\u0013\tqxN\u0001\u0005Pe\u0012,'/\u001b8h!\ry\u0013\u0011\u0001\u0003\u0006#\u001e\u0011\rAU\u0001\u0004[\u0006DX\u0003BA\u0004\u0003\u001f!2ALA\u0005\u0011\u0019Y\b\u0002q\u0001\u0002\fA!!.`A\u0007!\ry\u0013q\u0002\u0003\u0006#\"\u0011\rAU\u0001\fG>\u0004\u0018\u0010V8BeJ\f\u00170\u0006\u0003\u0002\u0016\u0005\rBc\u0002\u001f\u0002\u0018\u0005\u0015\u0012\u0011\u0006\u0005\b\u00033I\u0001\u0019AA\u000e\u0003\u0015\t'O]1z!\u00159\u0013QDA\u0011\u0013\r\tyB\t\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0004_\u0005\rB!B)\n\u0005\u0004\u0011\u0006BBA\u0014\u0013\u0001\u0007\u0011)\u0001\u0003ge>l\u0007BBA\u0016\u0013\u0001\u0007\u0011)A\u0002mK:\f!B]3ek\u000e,G*\u001a4u+\u0011\t\t$!\u000e\u0015\r\u0005M\u0012qGA\u001e!\ry\u0013Q\u0007\u0003\u0006#*\u0011\rA\u0015\u0005\u0007\u0003sQ\u0001\u0019A!\u0002\u000f!|w/\\1os\"1AK\u0003a\u0001\u0003{\u0001\u0002b\n,\u00024\u0005M\u00121G\u0001\r[\u0006\u0004(gY8nE&tWM]\u000b\u0007\u0003\u0007\ni%a\u0015\u0015\r\u0005\u0015\u0013qKA/!\u001dY\u0013qIA&\u0003#J1!!\u0013\u001f\u0005!\u0019u.\u001c2j]\u0016\u0014\bcA\u0018\u0002N\u00111\u0011qJ\u0006C\u0002M\u0012\u0011a\u0015\t\u0004_\u0005MCABA+\u0017\t\u00071G\u0001\u0003UQ\u0006$\bbBA-\u0017\u0001\u0007\u00111L\u0001\u0002MB)qe\u0012\u0018\u0002L!9\u0011qL\u0006A\u0002\u0005\u0015\u0013AA2c\u0003A\u0019w\u000e\u001c7fGR\u00144m\\7cS:,'/\u0006\u0004\u0002f\u0005-\u0014q\u000e\u000b\u0007\u0003O\n\t(a\u001f\u0011\u000f-\n9%!\u001b\u0002nA\u0019q&a\u001b\u0005\r\u0005=CB1\u00014!\ry\u0013q\u000e\u0003\u0007\u0003+b!\u0019A\u001a\t\u000f\u0005MD\u00021\u0001\u0002v\u0005\u0011\u0001O\u001a\t\u0007O\u0005]d&!\u001b\n\u0007\u0005e$EA\bQCJ$\u0018.\u00197Gk:\u001cG/[8o\u0011\u001d\ty\u0006\u0004a\u0001\u0003O\n\u0001C\u001a7bi6\f\u0007OM2p[\nLg.\u001a:\u0016\r\u0005\u0005\u0015qQAF)\u0019\t\u0019)!$\u0002\u001aB91&a\u0012\u0002\u0006\u0006%\u0005cA\u0018\u0002\b\u00121\u0011qJ\u0007C\u0002M\u00022aLAF\t\u0019\t)&\u0004b\u0001g!9\u0011\u0011L\u0007A\u0002\u0005=\u0005#B\u0014H]\u0005E\u0005CBAJ\u0003+\u000b))D\u0001!\u0013\r\t9\n\t\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\rC\u0004\u0002`5\u0001\r!a!\u0002\u0019\r|\u0007/\u001f\u001ack&dG-\u001a:\u0016\u0011\u0005}\u0015qWA^\u0003G#B!!)\u0002@B\u0019q&a)\u0005\u000f\u0005\u0015fB1\u0001\u0002(\n\u0019!\t\u001c3\u0012\u0007Q\nI\u000b\u0005\u0005\u0002,\u0006E\u0016QWA]\u001b\t\tiKC\u0002\u00020\u0002\nq!\\;uC\ndW-\u0003\u0003\u00024\u00065&a\u0002\"vS2$WM\u001d\t\u0004_\u0005]F!B)\u000f\u0005\u0004\u0011\u0006cA\u0018\u0002<\u00121\u0011Q\u0018\bC\u0002M\u0012AaQ8mY\"9\u0011\u0011\u0019\bA\u0002\u0005\u0005\u0016!\u00012\u0002\u001f\u0019LG\u000e^3se\r|WNY5oKJ,b!a2\u0002N\u0006EGCBAe\u0003+\fI\u000eE\u0004,\u0003\u000f\nY-a4\u0011\u0007=\ni\rB\u0003R\u001f\t\u0007!\u000bE\u00020\u0003#$a!a5\u0010\u0005\u0004\u0019$\u0001\u0002+iSNDa!a6\u0010\u0001\u00041\u0015\u0001\u00029sK\u0012Dq!a\u0018\u0010\u0001\u0004\tI-\u0001\ngS2$XM\u001d(piJ\u001aw.\u001c2j]\u0016\u0014XCBAp\u0003K\fI\u000f\u0006\u0004\u0002b\u0006-\u0018Q\u001e\t\bW\u0005\u001d\u00131]At!\ry\u0013Q\u001d\u0003\u0006#B\u0011\rA\u0015\t\u0004_\u0005%HABAj!\t\u00071\u0007\u0003\u0004\u0002XB\u0001\rA\u0012\u0005\b\u0003?\u0002\u0002\u0019AAq\u0003M\u0001\u0018M\u001d;ji&|gNM2p[\nLg.\u001a:t+\u0019\t\u00190a@\u0003\u0004QA\u0011Q\u001fB\u0003\u0005\u000f\u0011Y\u0001E\u0004(\u0003o\fY0a?\n\u0007\u0005e(E\u0001\u0004UkBdWM\r\t\bW\u0005\u001d\u0013Q B\u0001!\ry\u0013q \u0003\u0006#F\u0011\rA\u0015\t\u0004_\t\rAABAj#\t\u00071\u0007\u0003\u0004\u0002XF\u0001\rA\u0012\u0005\b\u0005\u0013\t\u0002\u0019AA~\u0003\u0015\u0011GO];f\u0011\u001d\u0011i!\u0005a\u0001\u0003w\faA\u00194bYN,\u0017!\u0004;bW\u0016\u00144m\\7cS:,'/\u0006\u0004\u0003\u0014\te!Q\u0004\u000b\u0007\u0005+\u0011yBa\t\u0011\u000f-\n9Ea\u0006\u0003\u001cA\u0019qF!\u0007\u0005\u000bE\u0013\"\u0019\u0001*\u0011\u0007=\u0012i\u0002\u0002\u0004\u0002TJ\u0011\ra\r\u0005\u0007\u0005C\u0011\u0002\u0019A!\u0002\u00039Dq!a\u0018\u0013\u0001\u0004\u0011)\"A\u0007ee>\u0004(gY8nE&tWM]\u000b\u0007\u0005S\u0011yCa\r\u0015\r\t-\"Q\u0007B\u001c!\u001dY\u0013q\tB\u0017\u0005c\u00012a\fB\u0018\t\u0015\t6C1\u0001S!\ry#1\u0007\u0003\u0007\u0003'\u001c\"\u0019A\u001a\t\r\t\u00052\u00031\u0001B\u0011\u001d\tyf\u0005a\u0001\u0005W\tab\u001d7jG\u0016\u00144m\\7cS:,'/\u0006\u0004\u0003>\t\r#q\t\u000b\t\u0005\u007f\u0011IEa\u0013\u0003PA91&a\u0012\u0003B\t\u0015\u0003cA\u0018\u0003D\u0011)\u0011\u000b\u0006b\u0001%B\u0019qFa\u0012\u0005\r\u0005MGC1\u00014\u0011\u0019\t9\u0003\u0006a\u0001\u0003\"1!Q\n\u000bA\u0002\u0005\u000bQ!\u001e8uS2Dq!a\u0018\u0015\u0001\u0004\u0011y$A\tta2LG/\u0011;3G>l'-\u001b8feN,bA!\u0016\u0003^\t\u0005D\u0003\u0003B,\u0005G\u00129Ga\u001b\u0011\u000f\u001d\n9P!\u0017\u0003ZA91&a\u0012\u0003\\\t}\u0003cA\u0018\u0003^\u0011)\u0011+\u0006b\u0001%B\u0019qF!\u0019\u0005\r\u0005MWC1\u00014\u0011\u0019\u0011)'\u0006a\u0001\u0003\u0006\u0011\u0011\r\u001e\u0005\b\u0005S*\u0002\u0019\u0001B-\u0003\u0019\u0011WMZ8sK\"9!QN\u000bA\u0002\te\u0013!B1gi\u0016\u0014\u0018A\u0005;bW\u0016<\u0006.\u001b7fe\r|WNY5oKJ,bAa\u001d\u0003|\t}DC\u0002B;\u0005\u0003\u0013\u0019\t\u0005\u0004(\u0003o\u00149(\u0013\t\bW\u0005\u001d#\u0011\u0010B?!\ry#1\u0010\u0003\u0006#Z\u0011\rA\u0015\t\u0004_\t}DABAj-\t\u00071\u0007C\u0003F-\u0001\u0007a\tC\u0004\u0002`Y\u0001\rAa\u001e\u0002\u001dM\u0004\u0018M\u001c\u001ad_6\u0014\u0017N\\3sgV1!\u0011\u0012BI\u0005+#\u0002Ba#\u0003\u0018\ne%1\u0014\t\bO\u0005](Q\u0012BG!\u001dY\u0013q\tBH\u0005'\u00032a\fBI\t\u0015\tvC1\u0001S!\ry#Q\u0013\u0003\u0007\u0003'<\"\u0019A\u001a\t\u000b\u0015;\u0002\u0019\u0001$\t\u000f\t%t\u00031\u0001\u0003\u000e\"9!QN\fA\u0002\t5\u0015aC:dC:$v.\u0011:sCf,bA!)\u0003(\nMF#\u0003\u001f\u0003$\n%&Q\u0016B]\u0011\u0019\t\u0007\u00041\u0001\u0003&B\u0019qFa*\u0005\u000bEC\"\u0019\u0001*\t\rQC\u0002\u0019\u0001BV!!9cK!*\u0003&\n\u0015\u0006bBA\r1\u0001\u0007!q\u0016\t\u0006O\u0005u!\u0011\u0017\t\u0004_\tMFa\u0002B[1\t\u0007!q\u0017\u0002\u0002\u0003F\u0019!QU\u001c\t\r\u0005\u001d\u0002\u00041\u0001B\u00039\u00198-\u00198U_\u000e{WNY5oKJ,bAa0\u0003F\n%G\u0003\u0003Ba\u0005\u0017\u0014yMa5\u0011\u000f-\n9Ea1\u0003HB\u0019qF!2\u0005\u000bEK\"\u0019\u0001*\u0011\u0007=\u0012I\r\u0002\u0004\u0002Ve\u0011\ra\r\u0005\b\u0005\u001bL\u0002\u0019\u0001Bb\u0003)\u0019H/\u0019:u-\u0006dW/\u001a\u0005\u0007)f\u0001\rA!5\u0011\u0011\u001d2&1\u0019Bb\u0005\u0007Dq!a\u0018\u001a\u0001\u0004\u0011\t-\u0006\u0004\u0003X\nu'\u0011\u001d\u000b\u000b\u00053\u0014\u0019O!:\u0003h\n-\bcB\u0016\u0002H\tm'q\u001c\t\u0004_\tuG!B)\u001b\u0005\u0004\u0011\u0006cA\u0018\u0003b\u00121\u0011Q\u000b\u000eC\u0002MBa!!\u000f\u001b\u0001\u0004\t\u0005b\u0002Bg5\u0001\u0007!1\u001c\u0005\u0007)j\u0001\rA!;\u0011\u0011\u001d2&1\u001cBn\u00057Dq!a\u0018\u001b\u0001\u0004\u0011I.\u0001\u0007{SB\u00144m\\7cS:,'/\u0006\u0005\u0003r\ne(Q`B\u0001)\u0019\u0011\u0019pa\u0001\u0004\nA91&a\u0012\u0003v\n}\bcB\u0014\u0002x\n](1 \t\u0004_\teH!B)\u001c\u0005\u0004\u0011\u0006cA\u0018\u0003~\u00121\u0011qJ\u000eC\u0002M\u00022aLB\u0001\t\u0019\t)f\u0007b\u0001g!91QA\u000eA\u0002\r\u001d\u0011\u0001C8uQ\u0016\u0014\b/\u001b;\u0011\t-b#1 \u0005\b\u0003?Z\u0002\u0019\u0001Bz\u0003=Q\u0018\u000e]!mYJ\u001aw.\u001c2j]\u0016\u0014X\u0003CB\b\u0007/\u0019Yba\b\u0015\u0015\rE1\u0011EB\u0014\u0007W\u0019y\u0003E\u0004,\u0003\u000f\u001a\u0019b!\b\u0011\u000f\u001d\n9p!\u0006\u0004\u001aA\u0019qfa\u0006\u0005\u000bEc\"\u0019\u0001*\u0011\u0007=\u001aY\u0002\u0002\u0004\u0002Pq\u0011\ra\r\t\u0004_\r}AABA+9\t\u00071\u0007C\u0004\u0004$q\u0001\ra!\n\u0002\tQD\u0017\r\u001e\t\u0005W1\u001aI\u0002C\u0004\u0004*q\u0001\ra!\u0006\u0002\u0011QD\u0017n]3mK6Dqa!\f\u001d\u0001\u0004\u0019I\"\u0001\u0005uQ\u0006$X\r\\3n\u0011\u001d\ty\u0006\ba\u0001\u0007#\u0001")
public interface AugmentedIterableIterator<T>
extends RemainsIterator<T> {
    public static /* synthetic */ int count$(AugmentedIterableIterator $this, Function1 p) {
        return $this.count(p);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public int count(Function1<T, Object> p) {
        void var2_2;
        int i = 0;
        while (this.hasNext()) {
            if (!BoxesRunTime.unboxToBoolean(p.apply(this.next()))) continue;
            ++i;
        }
        return (int)var2_2;
    }

    public static /* synthetic */ Object reduce$(AugmentedIterableIterator $this, Function2 op) {
        return $this.reduce(op);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <U> U reduce(Function2<U, U, U> op) {
        void var2_2;
        Object r = this.next();
        while (this.hasNext()) {
            r = op.apply(r, this.next());
        }
        return var2_2;
    }

    public static /* synthetic */ Object fold$(AugmentedIterableIterator $this, Object z, Function2 op) {
        return $this.fold((U)z, op);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <U> U fold(U z, Function2<U, U, U> op) {
        void var3_3;
        U r = z;
        while (this.hasNext()) {
            r = op.apply(r, this.next());
        }
        return var3_3;
    }

    public static /* synthetic */ Object sum$(AugmentedIterableIterator $this, Numeric num) {
        return $this.sum(num);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <U> U sum(Numeric<U> num) {
        void var2_2;
        U r = num.zero();
        while (this.hasNext()) {
            r = num.plus(r, this.next());
        }
        return var2_2;
    }

    public static /* synthetic */ Object product$(AugmentedIterableIterator $this, Numeric num) {
        return $this.product(num);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <U> U product(Numeric<U> num) {
        void var2_2;
        U r = num.one();
        while (this.hasNext()) {
            r = num.times(r, this.next());
        }
        return var2_2;
    }

    public static /* synthetic */ Object min$(AugmentedIterableIterator $this, Ordering ord) {
        return $this.min(ord);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <U> T min(Ordering<U> ord) {
        void var2_2;
        Object r = this.next();
        while (this.hasNext()) {
            Object curr = this.next();
            if (!ord.lteq(curr, r)) continue;
            r = curr;
        }
        return var2_2;
    }

    public static /* synthetic */ Object max$(AugmentedIterableIterator $this, Ordering ord) {
        return $this.max(ord);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <U> T max(Ordering<U> ord) {
        void var2_2;
        Object r = this.next();
        while (this.hasNext()) {
            Object curr = this.next();
            if (!ord.gteq(curr, r)) continue;
            r = curr;
        }
        return var2_2;
    }

    public static /* synthetic */ void copyToArray$(AugmentedIterableIterator $this, Object array, int from, int len) {
        $this.copyToArray(array, from, len);
    }

    @Override
    default public <U> void copyToArray(Object array, int from, int len) {
        int until = from + len;
        for (int i = from; i < until && this.hasNext(); ++i) {
            ScalaRunTime$.MODULE$.array_update(array, i, this.next());
        }
    }

    public static /* synthetic */ Object reduceLeft$(AugmentedIterableIterator $this, int howmany, Function2 op) {
        return $this.reduceLeft(howmany, op);
    }

    default public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
        Object u = this.next();
        for (int i = howmany - 1; i > 0 && this.hasNext(); --i) {
            u = op.apply(u, this.next());
        }
        return (U)u;
    }

    public static /* synthetic */ Combiner map2combiner$(AugmentedIterableIterator $this, Function1 f, Combiner cb) {
        return $this.map2combiner(f, cb);
    }

    default public <S, That> Combiner<S, That> map2combiner(Function1<T, S> f, Combiner<S, That> cb) {
        if (this.isRemainingCheap()) {
            cb.sizeHint(this.remaining());
        }
        while (this.hasNext()) {
            cb.$plus$eq(f.apply(this.next()));
        }
        return cb;
    }

    public static /* synthetic */ Combiner collect2combiner$(AugmentedIterableIterator $this, PartialFunction pf, Combiner cb) {
        return $this.collect2combiner(pf, cb);
    }

    default public <S, That> Combiner<S, That> collect2combiner(PartialFunction<T, S> pf, Combiner<S, That> cb) {
        Function1<T, Object> runWith = pf.runWith((Function1<Object, Combiner> & java.io.Serializable & Serializable)x$1 -> (Combiner)cb.$plus$eq((Object)x$1));
        while (this.hasNext()) {
            Object curr = this.next();
            runWith.apply(curr);
        }
        return cb;
    }

    public static /* synthetic */ Combiner flatmap2combiner$(AugmentedIterableIterator $this, Function1 f, Combiner cb) {
        return $this.flatmap2combiner(f, cb);
    }

    default public <S, That> Combiner<S, That> flatmap2combiner(Function1<T, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
        while (this.hasNext()) {
            TraversableOnce<S> traversable = f.apply(this.next()).seq();
            if (traversable instanceof Iterable) {
                cb.$plus$plus$eq(((Iterable)traversable).iterator());
                continue;
            }
            cb.$plus$plus$eq(traversable);
        }
        return cb;
    }

    public static /* synthetic */ Builder copy2builder$(AugmentedIterableIterator $this, Builder b) {
        return $this.copy2builder(b);
    }

    default public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
        if (this.isRemainingCheap()) {
            b.sizeHint(this.remaining());
        }
        while (this.hasNext()) {
            b.$plus$eq(this.next());
        }
        return b;
    }

    public static /* synthetic */ Combiner filter2combiner$(AugmentedIterableIterator $this, Function1 pred, Combiner cb) {
        return $this.filter2combiner(pred, cb);
    }

    default public <U, This> Combiner<U, This> filter2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
        while (this.hasNext()) {
            Object curr = this.next();
            if (!BoxesRunTime.unboxToBoolean(pred.apply(curr))) continue;
            cb.$plus$eq((U)curr);
        }
        return cb;
    }

    public static /* synthetic */ Combiner filterNot2combiner$(AugmentedIterableIterator $this, Function1 pred, Combiner cb) {
        return $this.filterNot2combiner(pred, cb);
    }

    default public <U, This> Combiner<U, This> filterNot2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
        while (this.hasNext()) {
            Object curr = this.next();
            if (BoxesRunTime.unboxToBoolean(pred.apply(curr))) continue;
            cb.$plus$eq((U)curr);
        }
        return cb;
    }

    public static /* synthetic */ Tuple2 partition2combiners$(AugmentedIterableIterator $this, Function1 pred, Combiner btrue, Combiner bfalse) {
        return $this.partition2combiners(pred, btrue, bfalse);
    }

    default public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<T, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
        while (this.hasNext()) {
            Object curr = this.next();
            if (BoxesRunTime.unboxToBoolean(pred.apply(curr))) {
                btrue.$plus$eq((U)curr);
                continue;
            }
            bfalse.$plus$eq((U)curr);
        }
        return new Tuple2<Combiner<U, This>, Combiner<U, This>>(btrue, bfalse);
    }

    public static /* synthetic */ Combiner take2combiner$(AugmentedIterableIterator $this, int n, Combiner cb) {
        return $this.take2combiner(n, cb);
    }

    default public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
        cb.sizeHint(n);
        for (int left = n; left > 0; --left) {
            cb.$plus$eq((U)this.next());
        }
        return cb;
    }

    public static /* synthetic */ Combiner drop2combiner$(AugmentedIterableIterator $this, int n, Combiner cb) {
        return $this.drop2combiner(n, cb);
    }

    default public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
        this.drop(n);
        if (this.isRemainingCheap()) {
            cb.sizeHint(this.remaining());
        }
        while (this.hasNext()) {
            cb.$plus$eq((U)this.next());
        }
        return cb;
    }

    public static /* synthetic */ Combiner slice2combiner$(AugmentedIterableIterator $this, int from, int until, Combiner cb) {
        return $this.slice2combiner(from, until, cb);
    }

    default public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
        int left;
        this.drop(from);
        cb.sizeHint(left);
        for (left = package$.MODULE$.max(until - from, 0); left > 0; --left) {
            cb.$plus$eq((U)this.next());
        }
        return cb;
    }

    public static /* synthetic */ Tuple2 splitAt2combiners$(AugmentedIterableIterator $this, int at, Combiner before, Combiner after) {
        return $this.splitAt2combiners(at, before, after);
    }

    default public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
        before.sizeHint(at);
        if (this.isRemainingCheap()) {
            after.sizeHint(this.remaining() - at);
        }
        for (int left = at; left > 0; --left) {
            before.$plus$eq((U)this.next());
        }
        while (this.hasNext()) {
            after.$plus$eq((U)this.next());
        }
        return new Tuple2<Combiner<U, This>, Combiner<U, This>>(before, after);
    }

    public static /* synthetic */ Tuple2 takeWhile2combiner$(AugmentedIterableIterator $this, Function1 p, Combiner cb) {
        return $this.takeWhile2combiner(p, cb);
    }

    default public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<T, Object> p, Combiner<U, This> cb) {
        boolean loop = true;
        while (this.hasNext() && loop) {
            Object curr = this.next();
            if (BoxesRunTime.unboxToBoolean(p.apply(curr))) {
                cb.$plus$eq((U)curr);
                continue;
            }
            loop = false;
        }
        return new Tuple2<Combiner<U, This>, Object>(cb, BoxesRunTime.boxToBoolean(loop));
    }

    public static /* synthetic */ Tuple2 span2combiners$(AugmentedIterableIterator $this, Function1 p, Combiner before, Combiner after) {
        return $this.span2combiners(p, before, after);
    }

    default public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<T, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
        boolean isBefore = true;
        while (this.hasNext() && isBefore) {
            Object curr = this.next();
            if (BoxesRunTime.unboxToBoolean(p.apply(curr))) {
                before.$plus$eq((U)curr);
                continue;
            }
            if (this.isRemainingCheap()) {
                after.sizeHint(this.remaining() + 1);
            }
            after.$plus$eq((U)curr);
            isBefore = false;
        }
        while (this.hasNext()) {
            after.$plus$eq((U)this.next());
        }
        return new Tuple2<Combiner<U, This>, Combiner<U, This>>(before, after);
    }

    public static /* synthetic */ void scanToArray$(AugmentedIterableIterator $this, Object z, Function2 op, Object array, int from) {
        $this.scanToArray(z, op, array, from);
    }

    default public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
        U last = z;
        int i = from;
        while (this.hasNext()) {
            last = op.apply(last, this.next());
            ScalaRunTime$.MODULE$.array_update(array, i, last);
            ++i;
        }
    }

    public static /* synthetic */ Combiner scanToCombiner$(AugmentedIterableIterator $this, Object startValue, Function2 op, Combiner cb) {
        return $this.scanToCombiner(startValue, op, cb);
    }

    default public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
        U curr = startValue;
        while (this.hasNext()) {
            curr = op.apply(curr, this.next());
            cb.$plus$eq(curr);
        }
        return cb;
    }

    public static /* synthetic */ Combiner scanToCombiner$(AugmentedIterableIterator $this, int howmany, Object startValue, Function2 op, Combiner cb) {
        return $this.scanToCombiner(howmany, startValue, op, cb);
    }

    default public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
        U curr = startValue;
        for (int left = howmany; left > 0; --left) {
            curr = op.apply(curr, this.next());
            cb.$plus$eq(curr);
        }
        return cb;
    }

    public static /* synthetic */ Combiner zip2combiner$(AugmentedIterableIterator $this, RemainsIterator otherpit, Combiner cb) {
        return $this.zip2combiner(otherpit, cb);
    }

    default public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
        if (this.isRemainingCheap() && otherpit.isRemainingCheap()) {
            int n = this.remaining();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            cb.sizeHint(RichInt$.MODULE$.min$extension(n, otherpit.remaining()));
        }
        while (this.hasNext() && otherpit.hasNext()) {
            cb.$plus$eq(new Tuple2(this.next(), otherpit.next()));
        }
        return cb;
    }

    public static /* synthetic */ Combiner zipAll2combiner$(AugmentedIterableIterator $this, RemainsIterator that, Object thiselem, Object thatelem, Combiner cb) {
        return $this.zipAll2combiner(that, thiselem, thatelem, cb);
    }

    default public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
        if (this.isRemainingCheap() && that.isRemainingCheap()) {
            int n = this.remaining();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            cb.sizeHint(RichInt$.MODULE$.max$extension(n, that.remaining()));
        }
        while (this.hasNext() && that.hasNext()) {
            cb.$plus$eq(new Tuple2(this.next(), that.next()));
        }
        while (this.hasNext()) {
            cb.$plus$eq(new Tuple2(this.next(), thatelem));
        }
        while (that.hasNext()) {
            cb.$plus$eq(new Tuple2(thiselem, that.next()));
        }
        return cb;
    }

    public static void $init$(AugmentedIterableIterator $this) {
    }
}

