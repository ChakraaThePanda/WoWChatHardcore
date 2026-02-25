/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenIterable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.IdleSignalling$;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.Splitter;
import scala.collection.parallel.package$;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\tuha\u0002&L!\u0003\r\tA\u0015\u0005\u0006g\u0002!\t\u0001\u001e\u0005\bq\u0002\u0001\r\u0011\"\u0001z\u0011\u001dQ\b\u00011A\u0005\u0002mDQA \u0001\u0007\u0002}Dq!a\u0001\u0001\r\u0003\t)\u0001C\u0004\u0002\u0016\u0001!\t!!\u0002\t\u000f\u0005]\u0001\u0001\"\u0001\u0002\u001a!9\u0011Q\b\u0001\u0007\u0002\u0005}\u0002bBA!\u0001\u0011E\u00111\t\u0005\t\u0003O\u0002A\u0011A&\u0002j\u00191\u0011\u0011\u0010\u0001\u0001\u0003wB!\"! \f\u0005\u0003\u0005\u000b\u0011BA\u001c\u0011\u001d\tyh\u0003C\u0001\u0003\u0003C\u0011\"!\u0010\f\u0001\u0004%\t!a\u0010\t\u0013\u0005%5\u00021A\u0005\u0002\u0005-\u0005\u0002CAH\u0017\u0001\u0006K!a\u000e\t\u000f\u0005E5\u0002\"\u0001\u0002\u0014\"9\u0011QS\u0006\u0005\u0002\u0005]\u0005\"\u0002@\f\t\u0003y\bbBA\u0002\u0017\u0011\u0005\u0011Q\u0001\u0005\t\u00033[\u0001\u0015\"\u0005\u0002\u001c\"A\u0011q\u0018\u0001\u0005\u00025\u000b\t\r\u0003\u0005\u0002H\u0002!\t!TAe\u0011\u001d\ti\u000e\u0001C!\u0003?Dq!!:\u0001\t\u0003\n9\u000fC\u0004\u0002l\u0002!\t%!<\u0007\r\u0005U\b\u0001AA|\u0011)\u0011\ta\u0007B\u0001B\u0003%!1\u0001\u0005\b\u0003\u007fZB\u0011\u0001B\u0003\u0011\u001d\t\tj\u0007C\u0001\u0003'Cq!!&\u001c\t\u0003\u0011Y\u0001C\u0004\u0002>m!\t!a\u0010\t\ry\\B\u0011\u0001B\u0007\u0011\u001d\t\u0019a\u0007C\u0001\u0005\u001fAqAa\u0005\u0001\t\u0003\u0012)B\u0002\u0004\u0003$\u0001\u0001!Q\u0005\u0005\u000b\u0005c!#Q1A\u0005\u0012\tM\u0002B\u0003B\u001eI\t\u0005\t\u0015!\u0003\u00036!9\u0011q\u0010\u0013\u0005\u0002\tu\u0002\"\u0003B\"I\u0001\u0007I\u0011\u0003B#\u0011%\u00119\u0005\na\u0001\n#\u0011I\u0005\u0003\u0005\u0003N\u0011\u0002\u000b\u0015\u0002B\u0015\u0011\u001d\t\t\n\nC\u0001\u0003'Cq!!&%\t\u0003\u0011y\u0005C\u0004\u0002>\u0011\"\t!a\u0010\t\u000f\tEC\u0005\"\u0005\u0002\u0014\"1a\u0010\nC\u0001\u0005\u000bBq!a\u0001%\t\u0003\u0011\u0019\u0006C\u0004\u0003X\u0001!\tA!\u0017\u0007\r\t5\u0004\u0001\u0001B8\u0011)\u0011\tD\rBC\u0002\u0013E!q\u0010\u0005\u000b\u0005w\u0011$\u0011!Q\u0001\n\t\u0005\u0005bBA@e\u0011\u0005!q\u0011\u0005\b\u0003#\u0013D\u0011AAJ\u0011\u001d\t)J\rC\u0001\u0005\u001bCq!!\u00103\t\u0003\ty\u0004\u0003\u0004\u007fe\u0011\u0005!q\u0012\u0005\b\u0003\u0007\u0011D\u0011\u0001BI\u0011\u001d\u0011)\n\u0001C\u0001\u0005/3aA!*\u0001\u0001\t\u001d\u0006B\u0003B\u0019y\t\u0015\r\u0011\"\u0005\u00038\"Q!1\b\u001f\u0003\u0002\u0003\u0006IA!/\t\u0015\tmFH!b\u0001\n#\u0011i\f\u0003\u0006\u0003@r\u0012\t\u0011)A\u0005\u0005_C!B!1=\u0005\u000b\u0007I\u0011\u0003Bb\u0011)\u0011)\r\u0010B\u0001B\u0003%!1\u0017\u0005\b\u0003\u007fbD\u0011\u0001Bd\u0011\u001d\t\t\n\u0010C\u0001\u0003'Cq!!&=\t\u0003\u0011\t\u000eC\u0004\u0002>q\"\t!a\u0010\t\rydD\u0011\u0001Bj\u0011\u001d\t\u0019\u0001\u0010C\u0001\u0005+DqA!7\u0001\t\u0003\u0011YN\u0001\tJi\u0016\u0014\u0018M\u00197f'Bd\u0017\u000e\u001e;fe*\u0011A*T\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011ajT\u0001\u000bG>dG.Z2uS>t'\"\u0001)\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u00111KX\n\u0007\u0001QCvM\u001b9\u0011\u0005U3V\"A(\n\u0005]{%AB!osJ+g\rE\u0002Z5rk\u0011aS\u0005\u00037.\u0013\u0011$Q;h[\u0016tG/\u001a3Ji\u0016\u0014\u0018M\u00197f\u0013R,'/\u0019;peB\u0011QL\u0018\u0007\u0001\t\u0019y\u0006\u0001\"b\u0001A\n\tA+\u0005\u0002bIB\u0011QKY\u0005\u0003G>\u0013qAT8uQ&tw\r\u0005\u0002VK&\u0011am\u0014\u0002\u0004\u0003:L\bcA-i9&\u0011\u0011n\u0013\u0002\t'Bd\u0017\u000e\u001e;feB\u00111N\\\u0007\u0002Y*\u0011Q.T\u0001\bO\u0016tWM]5d\u0013\tyGN\u0001\u0006TS\u001et\u0017\r\u001c7j]\u001e\u0004\"a[9\n\u0005Id'a\u0005#fY\u0016<\u0017\r^3e'&<g.\u00197mS:<\u0017A\u0002\u0013j]&$H\u0005F\u0001v!\t)f/\u0003\u0002x\u001f\n!QK\\5u\u00039\u0019\u0018n\u001a8bY\u0012+G.Z4bi\u0016,\u0012A[\u0001\u0013g&<g.\u00197EK2,w-\u0019;f?\u0012*\u0017\u000f\u0006\u0002vy\"9QpAA\u0001\u0002\u0004Q\u0017a\u0001=%c\u0005\u0019A-\u001e9\u0016\u0005\u0005\u0005\u0001cA-\u00019\u0006)1\u000f\u001d7jiV\u0011\u0011q\u0001\t\u0007\u0003\u0013\ty!!\u0001\u000f\u0007U\u000bY!C\u0002\u0002\u000e=\u000bq\u0001]1dW\u0006<W-\u0003\u0003\u0002\u0012\u0005M!aA*fc*\u0019\u0011QB(\u0002'M\u0004H.\u001b;XSRD7+[4oC2d\u0017N\\4\u0002%MDw.\u001e7e'Bd\u0017\u000e\u001e$veRDWM]\u000b\u0005\u00037\ty\u0003\u0006\u0004\u0002\u001e\u0005\r\u00121\u0007\t\u0004+\u0006}\u0011bAA\u0011\u001f\n9!i\\8mK\u0006t\u0007bBA\u0013\u000f\u0001\u0007\u0011qE\u0001\u0005G>dG\u000eE\u0003Z\u0003S\ti#C\u0002\u0002,-\u00131\u0002U1s\u0013R,'/\u00192mKB\u0019Q,a\f\u0005\r\u0005ErA1\u0001a\u0005\u0005\u0019\u0006bBA\u001b\u000f\u0001\u0007\u0011qG\u0001\u0011a\u0006\u0014\u0018\r\u001c7fY&\u001cX\u000eT3wK2\u00042!VA\u001d\u0013\r\tYd\u0014\u0002\u0004\u0013:$\u0018!\u0003:f[\u0006Lg.\u001b8h+\t\t9$A\u0006ck&dGm\u0015;sS:<G\u0003BA#\u00037\u0002B!a\u0012\u0002V9!\u0011\u0011JA)!\r\tYeT\u0007\u0003\u0003\u001bR1!a\u0014R\u0003\u0019a$o\\8u}%\u0019\u00111K(\u0002\rA\u0013X\rZ3g\u0013\u0011\t9&!\u0017\u0003\rM#(/\u001b8h\u0015\r\t\u0019f\u0014\u0005\b\u0003;J\u0001\u0019AA0\u0003\u001d\u0019Gn\\:ve\u0016\u0004b!VA1\u0003K*\u0018bAA2\u001f\nIa)\u001e8di&|g.\r\t\u0007+\u0006\u0005\u0014QI;\u0002!\u0011,'-^4J]\u001a|'/\\1uS>tWCAA6!\u0011\ti'a\u001e\u000e\u0005\u0005=$\u0002BA9\u0003g\nA\u0001\\1oO*\u0011\u0011QO\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002X\u0005=$!\u0002+bW\u0016t7\u0003B\u0006U\u0003\u0003\tQ\u0001^1lK:\fa\u0001P5oSRtD\u0003BAB\u0003\u000f\u00032!!\"\f\u001b\u0005\u0001\u0001bBA?\u001b\u0001\u0007\u0011qG\u0001\u000ee\u0016l\u0017-\u001b8j]\u001e|F%Z9\u0015\u0007U\fi\t\u0003\u0005~\u001f\u0005\u0005\t\u0019AA\u001c\u0003)\u0011X-\\1j]&tw\rI\u0001\bQ\u0006\u001ch*\u001a=u+\t\ti\"\u0001\u0003oKb$H#\u0001/\u0002\u000fQ\f7.Z*fcV!\u0011QTAU)\u0011\ty*!/\u0015\t\u0005\u0005\u0016q\u0016\t\u0007\u0003G\u000b)+a*\u000e\u00035K1!!\u0005N!\ri\u0016\u0011\u0016\u0003\b\u0003W+\"\u0019AAW\u0005\t\u0001\u0016*E\u0002b\u0003\u0003Aq!!-\u0016\u0001\u0004\t\u0019,A\u0003uC.,'\u000fE\u0005V\u0003k\u000b9+a\u000e\u0002(&\u0019\u0011qW(\u0003\u0013\u0019+hn\u0019;j_:\u0014\u0004bBA^+\u0001\u0007\u0011QX\u0001\u0003gF\u0004b!!\u0003\u0002\u0010\u0005\u001d\u0016\u0001\u00038foR\u000b7.\u001a8\u0015\t\u0005\r\u00151\u0019\u0005\b\u0003\u000b4\u0002\u0019AA\u001c\u0003\u0015)h\u000e^5m\u0003AqWm^*mS\u000e,\u0017J\u001c;fe:\fG.\u0006\u0003\u0002L\u0006=GCBAg\u0003+\fI\u000eE\u0002^\u0003\u001f$q!!5\u0018\u0005\u0004\t\u0019NA\u0001V#\r\t\u00171\u0011\u0005\b\u0003/<\u0002\u0019AAg\u0003\tIG\u000fC\u0004\u0002\\^\u0001\r!a\u000e\u0002\u000b\u0019\u0014x.\\\u0019\u0002\t\u0011\u0014x\u000e\u001d\u000b\u0005\u0003\u0003\t\t\u000fC\u0004\u0002db\u0001\r!a\u000e\u0002\u00039\fA\u0001^1lKR!\u0011\u0011AAu\u0011\u001d\t\u0019/\u0007a\u0001\u0003o\tQa\u001d7jG\u0016$b!!\u0001\u0002p\u0006E\bbBAn5\u0001\u0007\u0011q\u0007\u0005\b\u0003gT\u0002\u0019AA\u001c\u0003\u0019)h\u000e^5mc\t1Q*\u00199qK\u0012,B!!?\u0002\u0000N!1\u0004VA~!\u0011I\u0006!!@\u0011\u0007u\u000by\u0010\u0002\u0004\u00022m\u0011\r\u0001Y\u0001\u0002MB1Q+!\u0019]\u0003{$BAa\u0002\u0003\nA)\u0011QQ\u000e\u0002~\"9!\u0011A\u000fA\u0002\t\rACAA\u007f+\t\tY0\u0006\u0002\u0003\u0012A1\u0011\u0011BA\b\u0003w\f1!\\1q+\u0011\u00119B!\b\u0015\t\te!q\u0004\t\u0006\u0003\u000b[\"1\u0004\t\u0004;\nuAABA\u0019G\t\u0007\u0001\rC\u0004\u0003\u0002\r\u0002\rA!\t\u0011\rU\u000b\t\u0007\u0018B\u000e\u0005!\t\u0005\u000f]3oI\u0016$WC\u0002B\u0014\u0005[\u00119d\u0005\u0003%)\n%\u0002\u0003B-\u0001\u0005W\u00012!\u0018B\u0017\t\u001d\t\t\u000e\nb\u0001\u0005_\t\"\u0001\u00183\u0002\tQD\u0017\r^\u000b\u0003\u0005k\u00012!\u0018B\u001c\t\u001d\tY\u000b\nb\u0001\u0005s\t2!\u0019B\u0015\u0003\u0015!\b.\u0019;!)\u0011\u0011yD!\u0011\u0011\u000f\u0005\u0015EEa\u000b\u00036!9!\u0011G\u0014A\u0002\tU\u0012\u0001B2veJ,\"A!\u000b\u0002\u0011\r,(O]0%KF$2!\u001eB&\u0011!i\u0018&!AA\u0002\t%\u0012!B2veJ\u0004CC\u0001B\u0016\u000351\u0017N]:u\u001d>tW)\u001c9usV\u0011!Q\u000b\t\u0007\u0003\u0013\tyA!\u000b\u0002#\u0005\u0004\b/\u001a8e!\u0006\u0014\u0018\n^3sC\ndW-\u0006\u0004\u0003\\\t\u0005$Q\r\u000b\u0005\u0005;\u0012Y\u0007E\u0004\u0002\u0006\u0012\u0012yFa\u0019\u0011\u0007u\u0013\t\u0007B\u0004\u0002RF\u0012\rAa\f\u0011\u0007u\u0013)\u0007B\u0004\u0002,F\u0012\rAa\u001a\u0012\u0007\u0005\u0014I\u0007\u0005\u0003Z\u0001\t}\u0003b\u0002B\u0019c\u0001\u0007!1\r\u0002\u00075&\u0004\b/\u001a3\u0016\t\tE$QP\n\u0005eQ\u0013\u0019\b\u0005\u0003Z\u0001\tU\u0004CB+\u0003xq\u0013Y(C\u0002\u0003z=\u0013a\u0001V;qY\u0016\u0014\u0004cA/\u0003~\u00111\u0011\u0011\u0007\u001aC\u0002\u0001,\"A!!\u0011\u000be\u0013\u0019Ia\u001f\n\u0007\t\u00155JA\u0006TKF\u001c\u0006\u000f\\5ui\u0016\u0014H\u0003\u0002BE\u0005\u0017\u0003R!!\"3\u0005wBqA!\r6\u0001\u0004\u0011\t\t\u0006\u0002\u0003vU\u0011!1O\u000b\u0003\u0005'\u0003b!!\u0003\u0002\u0010\tM\u0014!\u0003>jaB\u000b'oU3r+\u0011\u0011IJa(\u0015\t\tm%\u0011\u0015\t\u0006\u0003\u000b\u0013$Q\u0014\t\u0004;\n}EABA\u0019w\t\u0007\u0001\rC\u0004\u00032m\u0002\rAa)\u0011\u000be\u0013\u0019I!(\u0003\u0013iK\u0007\u000f]3e\u00032dWC\u0002BU\u0005c\u0013)l\u0005\u0003=)\n-\u0006\u0003B-\u0001\u0005[\u0003r!\u0016B<\u0005_\u0013\u0019\fE\u0002^\u0005c#q!!5=\u0005\u0004\u0011y\u0003E\u0002^\u0005k#a!!\r=\u0005\u0004\u0001WC\u0001B]!\u0015I&1\u0011BZ\u0003!!\b.[:fY\u0016lWC\u0001BX\u0003%!\b.[:fY\u0016l\u0007%\u0001\u0005uQ\u0006$X\r\\3n+\t\u0011\u0019,A\u0005uQ\u0006$X\r\\3nAQA!\u0011\u001aBf\u0005\u001b\u0014y\rE\u0004\u0002\u0006r\u0012yKa-\t\u000f\tE2\t1\u0001\u0003:\"9!1X\"A\u0002\t=\u0006b\u0002Ba\u0007\u0002\u0007!1\u0017\u000b\u0003\u0005[+\"Aa+\u0016\u0005\t]\u0007CBA\u0005\u0003\u001f\u0011Y+\u0001\u0007{SB\fE\u000e\u001c)beN+\u0017/\u0006\u0005\u0003^\n=(1\u001dBt)!\u0011yN!=\u0003v\ne\bcBACy\t\u0005(Q\u001d\t\u0004;\n\rHaBAi\u0013\n\u0007!q\u0006\t\u0004;\n\u001dHa\u0002Bu\u0013\n\u0007!1\u001e\u0002\u0002%F\u0019!Q\u001e3\u0011\u0007u\u0013y\u000f\u0002\u0004\u00022%\u0013\r\u0001\u0019\u0005\b\u0005cI\u0005\u0019\u0001Bz!\u0015I&1\u0011Bw\u0011\u001d\u001190\u0013a\u0001\u0005C\f\u0001\u0002\u001e5jg\u0016cW-\u001c\u0005\b\u0005wL\u0005\u0019\u0001Bs\u0003!!\b.\u0019;FY\u0016l\u0007")
public interface IterableSplitter<T>
extends AugmentedIterableIterator<T>,
Splitter<T>,
DelegatedSignalling {
    @Override
    public Signalling signalDelegate();

    @Override
    public void signalDelegate_$eq(Signalling var1);

    public IterableSplitter<T> dup();

    @Override
    public Seq<IterableSplitter<T>> split();

    /*
     * WARNING - void declaration
     */
    default public Seq<IterableSplitter<T>> splitWithSignalling() {
        void var1_1;
        Seq<IterableSplitter<T>> pits = this.split();
        pits.foreach((Function1<IterableSplitter, Object> & java.io.Serializable & Serializable)x$2 -> {
            ((IterableSplitter)x$2).signalDelegate_$eq(this.signalDelegate());
            return BoxedUnit.UNIT;
        });
        return var1_1;
    }

    default public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
        return this.remaining() > package$.MODULE$.thresholdFromSize(coll.size(), parallelismLevel);
    }

    @Override
    public int remaining();

    default public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
        ObjectRef<String> output = ObjectRef.create("");
        closure.apply((Function1<String, BoxedUnit>)(Function1<String, Object> & java.io.Serializable & Serializable)s -> {
            IterableSplitter.appendln$1(s, output);
            return BoxedUnit.UNIT;
        });
        return (String)output.elem;
    }

    default public String debugInformation() {
        return new java.lang.StringBuilder(19).append("Parallel iterator: ").append(this.getClass()).toString();
    }

    default public Taken newTaken(int until) {
        return new Taken(this, until);
    }

    default public <U extends Taken> U newSliceInternal(U it, int from1) {
        for (int count = from1; count > 0 && it.hasNext(); --count) {
            it.next();
        }
        return it;
    }

    @Override
    default public IterableSplitter<T> drop(int n) {
        for (int i = 0; i < n && this.hasNext(); ++i) {
            this.next();
        }
        return this;
    }

    @Override
    default public IterableSplitter<T> take(int n) {
        return this.newTaken(n);
    }

    @Override
    default public IterableSplitter<T> slice(int from1, int until1) {
        return this.newSliceInternal(this.newTaken(until1), from1);
    }

    @Override
    default public <S> Mapped<S> map(Function1<T, S> f) {
        return new Mapped<S>(this, f);
    }

    default public <U, PI extends IterableSplitter<U>> Appended<U, PI> appendParIterable(PI that) {
        return new Appended(this, that);
    }

    default public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
        return new Zipped<S>(this, that);
    }

    default public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
        return new ZippedAll<U, S>(this, that, thisElem, thatElem);
    }

    private static void appendln$1(String s, ObjectRef output$1) {
        output$1.elem = new java.lang.StringBuilder(1).append((String)output$1.elem).append(s).append("\n").toString();
    }

    public static void $init$(IterableSplitter $this) {
        $this.signalDelegate_$eq(IdleSignalling$.MODULE$);
    }

    public class Appended<U, PI extends IterableSplitter<U>>
    implements IterableSplitter<U> {
        private final PI that;
        private IterableSplitter<U> curr;
        private Signalling signalDelegate;
        public final /* synthetic */ IterableSplitter $outer;

        @Override
        public Seq<IterableSplitter<U>> splitWithSignalling() {
            return ((IterableSplitter)this).splitWithSignalling();
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return ((IterableSplitter)this).shouldSplitFurther(coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return ((IterableSplitter)this).buildString(closure);
        }

        @Override
        public String debugInformation() {
            return ((IterableSplitter)this).debugInformation();
        }

        @Override
        public Taken newTaken(int until) {
            return ((IterableSplitter)this).newTaken(until);
        }

        @Override
        public <U extends Taken> U newSliceInternal(U it, int from1) {
            return (U)((IterableSplitter)this).newSliceInternal(it, from1);
        }

        @Override
        public IterableSplitter<U> drop(int n) {
            return ((IterableSplitter)this).drop(n);
        }

        @Override
        public IterableSplitter<U> take(int n) {
            return ((IterableSplitter)this).take(n);
        }

        @Override
        public IterableSplitter<U> slice(int from1, int until1) {
            return ((IterableSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<U, S> f) {
            return ((IterableSplitter)this).map(f);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> Appended<U, PI> appendParIterable(PI that) {
            return ((IterableSplitter)this).appendParIterable((IterableSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((IterableSplitter)this).zipParSeq(that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((IterableSplitter)this).zipAllParSeq(that, thisElem, thatElem);
        }

        @Override
        public boolean isAborted() {
            return DelegatedSignalling.isAborted$(this);
        }

        @Override
        public void abort() {
            DelegatedSignalling.abort$(this);
        }

        @Override
        public int indexFlag() {
            return DelegatedSignalling.indexFlag$(this);
        }

        @Override
        public void setIndexFlag(int f) {
            DelegatedSignalling.setIndexFlag$(this, f);
        }

        @Override
        public void setIndexFlagIfGreater(int f) {
            DelegatedSignalling.setIndexFlagIfGreater$(this, f);
        }

        @Override
        public void setIndexFlagIfLesser(int f) {
            DelegatedSignalling.setIndexFlagIfLesser$(this, f);
        }

        @Override
        public int tag() {
            return DelegatedSignalling.tag$(this);
        }

        @Override
        public int count(Function1<U, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
        }

        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.fold$(this, z, op);
        }

        @Override
        public <U> U sum(Numeric<U> num) {
            return (U)AugmentedIterableIterator.sum$(this, num);
        }

        @Override
        public <U> U product(Numeric<U> num) {
            return (U)AugmentedIterableIterator.product$(this, num);
        }

        @Override
        public <U> U min(Ordering<U> ord) {
            return (U)AugmentedIterableIterator.min$(this, ord);
        }

        @Override
        public <U> U max(Ordering<U> ord) {
            return (U)AugmentedIterableIterator.max$(this, ord);
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            AugmentedIterableIterator.copyToArray$(this, array, from, len);
        }

        @Override
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<U, S> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.map2combiner$(this, f, cb);
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<U, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<U, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<U, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<U, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<U, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.take2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.drop2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
            return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<U, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<U, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.span2combiners$(this, p, before, after);
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
            AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
        }

        @Override
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<U> seq() {
            return Iterator.seq$(this);
        }

        @Override
        public boolean isEmpty() {
            return Iterator.isEmpty$(this);
        }

        @Override
        public boolean isTraversableAgain() {
            return Iterator.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return Iterator.hasDefiniteSize$(this);
        }

        @Override
        public Iterator<U> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<U, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<U> filter(Function1<U, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<U, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<U> withFilter(Function1<U, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<U> filterNot(Function1<U, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<U, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, U, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<U, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<U> takeWhile(Function1<U, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<U>, Iterator<U>> partition(Function1<U, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<U>, Iterator<U>> span(Function1<U, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<U> dropWhile(Function1<U, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<U, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<U, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<U, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<U, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<U, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<U> find(Function1<U, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<U, Object> p) {
            return Iterator.indexWhere$(this, p);
        }

        @Override
        public int indexWhere(Function1<U, Object> p, int from) {
            return Iterator.indexWhere$(this, p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return Iterator.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return Iterator.indexOf$(this, elem, from);
        }

        @Override
        public BufferedIterator<U> buffered() {
            return Iterator.buffered$(this);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> grouped(int size) {
            return Iterator.grouped$(this, size);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
            return Iterator.sliding$(this, size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return Iterator.sliding$default$2$(this);
        }

        @Override
        public int length() {
            return Iterator.length$(this);
        }

        @Override
        public Tuple2<Iterator<U>, Iterator<U>> duplicate() {
            return Iterator.duplicate$(this);
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return Iterator.patch$(this, from, patchElems, replaced);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return Iterator.sameElements$(this, that);
        }

        @Override
        public Traversable<U> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<U> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<U> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public String toString() {
            return Iterator.toString$(this);
        }

        @Override
        public List<U> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<U, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, U, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<U, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, U, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<U, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, U, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<U, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, U, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<U, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, U, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <B> U maxBy(Function1<U, B> f, Ordering<B> cmp) {
            return (U)TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> U minBy(Function1<U, B> f, Ordering<B> cmp) {
            return (U)TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<U> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<U> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<U> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<U> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<U> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, U, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<U, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return TraversableOnce.mkString$(this, start, sep, end);
        }

        @Override
        public String mkString(String sep) {
            return TraversableOnce.mkString$(this, sep);
        }

        @Override
        public String mkString() {
            return TraversableOnce.mkString$(this);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return TraversableOnce.addString$(this, b, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        @Override
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        public PI that() {
            return this.that;
        }

        public IterableSplitter<U> curr() {
            return this.curr;
        }

        public void curr_$eq(IterableSplitter<U> x$1) {
            this.curr = x$1;
        }

        @Override
        public boolean hasNext() {
            if (this.curr().hasNext()) {
                return true;
            }
            if (this.curr() == this.scala$collection$parallel$IterableSplitter$Appended$$$outer()) {
                this.curr_$eq((IterableSplitter<U>)this.that());
                return this.curr().hasNext();
            }
            return false;
        }

        @Override
        public U next() {
            if (this.curr() == this.scala$collection$parallel$IterableSplitter$Appended$$$outer()) {
                this.hasNext();
                return (U)this.curr().next();
            }
            return (U)this.curr().next();
        }

        @Override
        public int remaining() {
            if (this.curr() == this.scala$collection$parallel$IterableSplitter$Appended$$$outer()) {
                return this.curr().remaining() + this.that().remaining();
            }
            return this.curr().remaining();
        }

        public boolean firstNonEmpty() {
            return this.curr() == this.scala$collection$parallel$IterableSplitter$Appended$$$outer() && this.curr().hasNext();
        }

        @Override
        public IterableSplitter<U> dup() {
            return this.scala$collection$parallel$IterableSplitter$Appended$$$outer().dup().appendParIterable(this.that());
        }

        @Override
        public Seq<IterableSplitter<U>> split() {
            if (this.firstNonEmpty()) {
                return new $colon$colon<Nothing$>((Nothing$)((Object)this.curr()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)this.that(), Nil$.MODULE$));
            }
            return this.curr().split();
        }

        public /* synthetic */ IterableSplitter scala$collection$parallel$IterableSplitter$Appended$$$outer() {
            return this.$outer;
        }

        public Appended(PI that) {
            this.that = that;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            this.signalDelegate_$eq($outer.signalDelegate());
            this.curr = $outer;
        }
    }

    public class Mapped<S>
    implements IterableSplitter<S> {
        private final Function1<T, S> f;
        private Signalling signalDelegate;
        public final /* synthetic */ IterableSplitter $outer;

        @Override
        public Seq<IterableSplitter<S>> splitWithSignalling() {
            return ((IterableSplitter)this).splitWithSignalling();
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return ((IterableSplitter)this).shouldSplitFurther(coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return ((IterableSplitter)this).buildString(closure);
        }

        @Override
        public String debugInformation() {
            return ((IterableSplitter)this).debugInformation();
        }

        @Override
        public Taken newTaken(int until) {
            return ((IterableSplitter)this).newTaken(until);
        }

        @Override
        public <U extends Taken> U newSliceInternal(U it, int from1) {
            return (U)((IterableSplitter)this).newSliceInternal(it, from1);
        }

        @Override
        public IterableSplitter<S> drop(int n) {
            return ((IterableSplitter)this).drop(n);
        }

        @Override
        public IterableSplitter<S> take(int n) {
            return ((IterableSplitter)this).take(n);
        }

        @Override
        public IterableSplitter<S> slice(int from1, int until1) {
            return ((IterableSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<S, S> f) {
            return ((IterableSplitter)this).map(f);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> Appended<U, PI> appendParIterable(PI that) {
            return ((IterableSplitter)this).appendParIterable((IterableSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((IterableSplitter)this).zipParSeq(that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((IterableSplitter)this).zipAllParSeq(that, thisElem, thatElem);
        }

        @Override
        public boolean isAborted() {
            return DelegatedSignalling.isAborted$(this);
        }

        @Override
        public void abort() {
            DelegatedSignalling.abort$(this);
        }

        @Override
        public int indexFlag() {
            return DelegatedSignalling.indexFlag$(this);
        }

        @Override
        public void setIndexFlag(int f) {
            DelegatedSignalling.setIndexFlag$(this, f);
        }

        @Override
        public void setIndexFlagIfGreater(int f) {
            DelegatedSignalling.setIndexFlagIfGreater$(this, f);
        }

        @Override
        public void setIndexFlagIfLesser(int f) {
            DelegatedSignalling.setIndexFlagIfLesser$(this, f);
        }

        @Override
        public int tag() {
            return DelegatedSignalling.tag$(this);
        }

        @Override
        public int count(Function1<S, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
        }

        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.fold$(this, z, op);
        }

        @Override
        public <U> U sum(Numeric<U> num) {
            return (U)AugmentedIterableIterator.sum$(this, num);
        }

        @Override
        public <U> U product(Numeric<U> num) {
            return (U)AugmentedIterableIterator.product$(this, num);
        }

        @Override
        public <U> S min(Ordering<U> ord) {
            return (S)AugmentedIterableIterator.min$(this, ord);
        }

        @Override
        public <U> S max(Ordering<U> ord) {
            return (S)AugmentedIterableIterator.max$(this, ord);
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            AugmentedIterableIterator.copyToArray$(this, array, from, len);
        }

        @Override
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<S, S> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.map2combiner$(this, f, cb);
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<S, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<S, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<S, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<S, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<S, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.take2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.drop2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
            return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<S, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<S, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.span2combiners$(this, p, before, after);
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
            AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
        }

        @Override
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<S> seq() {
            return Iterator.seq$(this);
        }

        @Override
        public boolean isEmpty() {
            return Iterator.isEmpty$(this);
        }

        @Override
        public boolean isTraversableAgain() {
            return Iterator.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return Iterator.hasDefiniteSize$(this);
        }

        @Override
        public Iterator<S> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<S, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<S> filter(Function1<S, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<S, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<S> withFilter(Function1<S, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<S> filterNot(Function1<S, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<S, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, S, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<S, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<S> takeWhile(Function1<S, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<S>, Iterator<S>> partition(Function1<S, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<S>, Iterator<S>> span(Function1<S, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<S> dropWhile(Function1<S, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<S, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<S, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<S, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<S, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<S, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<S> find(Function1<S, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<S, Object> p) {
            return Iterator.indexWhere$(this, p);
        }

        @Override
        public int indexWhere(Function1<S, Object> p, int from) {
            return Iterator.indexWhere$(this, p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return Iterator.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return Iterator.indexOf$(this, elem, from);
        }

        @Override
        public BufferedIterator<S> buffered() {
            return Iterator.buffered$(this);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> grouped(int size) {
            return Iterator.grouped$(this, size);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
            return Iterator.sliding$(this, size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return Iterator.sliding$default$2$(this);
        }

        @Override
        public int length() {
            return Iterator.length$(this);
        }

        @Override
        public Tuple2<Iterator<S>, Iterator<S>> duplicate() {
            return Iterator.duplicate$(this);
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return Iterator.patch$(this, from, patchElems, replaced);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return Iterator.sameElements$(this, that);
        }

        @Override
        public Traversable<S> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<S> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<S> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public String toString() {
            return Iterator.toString$(this);
        }

        @Override
        public List<S> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<S, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, S, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<S, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, S, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<S, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, S, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<S, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, S, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<S, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, S, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <B> S maxBy(Function1<S, B> f, Ordering<B> cmp) {
            return (S)TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> S minBy(Function1<S, B> f, Ordering<B> cmp) {
            return (S)TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<S> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<S> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<S> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<S> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<S> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, S, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<S, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return TraversableOnce.mkString$(this, start, sep, end);
        }

        @Override
        public String mkString(String sep) {
            return TraversableOnce.mkString$(this, sep);
        }

        @Override
        public String mkString() {
            return TraversableOnce.mkString$(this);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return TraversableOnce.addString$(this, b, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        @Override
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        @Override
        public boolean hasNext() {
            return this.scala$collection$parallel$IterableSplitter$Mapped$$$outer().hasNext();
        }

        @Override
        public S next() {
            return this.f.apply(this.scala$collection$parallel$IterableSplitter$Mapped$$$outer().next());
        }

        @Override
        public int remaining() {
            return this.scala$collection$parallel$IterableSplitter$Mapped$$$outer().remaining();
        }

        @Override
        public IterableSplitter<S> dup() {
            return this.scala$collection$parallel$IterableSplitter$Mapped$$$outer().dup().map(this.f);
        }

        @Override
        public Seq<IterableSplitter<S>> split() {
            return this.scala$collection$parallel$IterableSplitter$Mapped$$$outer().split().map((Function1<IterableSplitter, Mapped> & java.io.Serializable & Serializable)x$7 -> x$7.map($this.f), Seq$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ IterableSplitter scala$collection$parallel$IterableSplitter$Mapped$$$outer() {
            return this.$outer;
        }

        public Mapped(IterableSplitter $outer, Function1<T, S> f) {
            this.f = f;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            this.signalDelegate_$eq($outer.signalDelegate());
        }
    }

    public class Taken
    implements IterableSplitter<T> {
        private final int taken;
        private int remaining;
        private Signalling signalDelegate;
        public final /* synthetic */ IterableSplitter $outer;

        @Override
        public Seq<IterableSplitter<T>> splitWithSignalling() {
            return ((IterableSplitter)this).splitWithSignalling();
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return ((IterableSplitter)this).shouldSplitFurther(coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return ((IterableSplitter)this).buildString(closure);
        }

        @Override
        public String debugInformation() {
            return ((IterableSplitter)this).debugInformation();
        }

        @Override
        public Taken newTaken(int until) {
            return ((IterableSplitter)this).newTaken(until);
        }

        @Override
        public <U extends Taken> U newSliceInternal(U it, int from1) {
            return (U)((IterableSplitter)this).newSliceInternal(it, from1);
        }

        @Override
        public IterableSplitter<T> drop(int n) {
            return ((IterableSplitter)this).drop(n);
        }

        @Override
        public IterableSplitter<T> take(int n) {
            return ((IterableSplitter)this).take(n);
        }

        @Override
        public IterableSplitter<T> slice(int from1, int until1) {
            return ((IterableSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<T, S> f) {
            return ((IterableSplitter)this).map(f);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> Appended<U, PI> appendParIterable(PI that) {
            return ((IterableSplitter)this).appendParIterable((IterableSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((IterableSplitter)this).zipParSeq(that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((IterableSplitter)this).zipAllParSeq(that, thisElem, thatElem);
        }

        @Override
        public boolean isAborted() {
            return DelegatedSignalling.isAborted$(this);
        }

        @Override
        public void abort() {
            DelegatedSignalling.abort$(this);
        }

        @Override
        public int indexFlag() {
            return DelegatedSignalling.indexFlag$(this);
        }

        @Override
        public void setIndexFlag(int f) {
            DelegatedSignalling.setIndexFlag$(this, f);
        }

        @Override
        public void setIndexFlagIfGreater(int f) {
            DelegatedSignalling.setIndexFlagIfGreater$(this, f);
        }

        @Override
        public void setIndexFlagIfLesser(int f) {
            DelegatedSignalling.setIndexFlagIfLesser$(this, f);
        }

        @Override
        public int tag() {
            return DelegatedSignalling.tag$(this);
        }

        @Override
        public int count(Function1<T, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
        }

        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.fold$(this, z, op);
        }

        @Override
        public <U> U sum(Numeric<U> num) {
            return (U)AugmentedIterableIterator.sum$(this, num);
        }

        @Override
        public <U> U product(Numeric<U> num) {
            return (U)AugmentedIterableIterator.product$(this, num);
        }

        @Override
        public <U> T min(Ordering<U> ord) {
            return AugmentedIterableIterator.min$(this, ord);
        }

        @Override
        public <U> T max(Ordering<U> ord) {
            return AugmentedIterableIterator.max$(this, ord);
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            AugmentedIterableIterator.copyToArray$(this, array, from, len);
        }

        @Override
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<T, S> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.map2combiner$(this, f, cb);
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<T, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<T, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<T, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.take2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.drop2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
            return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<T, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<T, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.span2combiners$(this, p, before, after);
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
            AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
        }

        @Override
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<T> seq() {
            return Iterator.seq$(this);
        }

        @Override
        public boolean isEmpty() {
            return Iterator.isEmpty$(this);
        }

        @Override
        public boolean isTraversableAgain() {
            return Iterator.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return Iterator.hasDefiniteSize$(this);
        }

        @Override
        public Iterator<T> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<T, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<T> filter(Function1<T, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<T, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<T> withFilter(Function1<T, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<T> filterNot(Function1<T, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<T, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, T, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<T, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<T> takeWhile(Function1<T, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> partition(Function1<T, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> span(Function1<T, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<T> dropWhile(Function1<T, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<T, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<T, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<T, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<T, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<T, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<T> find(Function1<T, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<T, Object> p) {
            return Iterator.indexWhere$(this, p);
        }

        @Override
        public int indexWhere(Function1<T, Object> p, int from) {
            return Iterator.indexWhere$(this, p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return Iterator.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return Iterator.indexOf$(this, elem, from);
        }

        @Override
        public BufferedIterator<T> buffered() {
            return Iterator.buffered$(this);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> grouped(int size) {
            return Iterator.grouped$(this, size);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
            return Iterator.sliding$(this, size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return Iterator.sliding$default$2$(this);
        }

        @Override
        public int length() {
            return Iterator.length$(this);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> duplicate() {
            return Iterator.duplicate$(this);
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return Iterator.patch$(this, from, patchElems, replaced);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return Iterator.sameElements$(this, that);
        }

        @Override
        public Traversable<T> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<T> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<T> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public String toString() {
            return Iterator.toString$(this);
        }

        @Override
        public List<T> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<T, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, T, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<T, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, T, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<T, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, T, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<T, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, T, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<T, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, T, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <B> T maxBy(Function1<T, B> f, Ordering<B> cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> T minBy(Function1<T, B> f, Ordering<B> cmp) {
            return TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<T> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<T> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<T> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<T> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<T> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<T, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return TraversableOnce.mkString$(this, start, sep, end);
        }

        @Override
        public String mkString(String sep) {
            return TraversableOnce.mkString$(this, sep);
        }

        @Override
        public String mkString() {
            return TraversableOnce.mkString$(this);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return TraversableOnce.addString$(this, b, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        @Override
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        @Override
        public int remaining() {
            return this.remaining;
        }

        public void remaining_$eq(int x$1) {
            this.remaining = x$1;
        }

        @Override
        public boolean hasNext() {
            return this.remaining() > 0;
        }

        @Override
        public T next() {
            this.remaining_$eq(this.remaining() - 1);
            return this.scala$collection$parallel$IterableSplitter$Taken$$$outer().next();
        }

        @Override
        public IterableSplitter<T> dup() {
            return this.scala$collection$parallel$IterableSplitter$Taken$$$outer().dup().take(this.taken);
        }

        @Override
        public Seq<IterableSplitter<T>> split() {
            return this.takeSeq(this.scala$collection$parallel$IterableSplitter$Taken$$$outer().split(), (Function2<IterableSplitter, Object, IterableSplitter> & java.io.Serializable & Serializable)(p, n) -> p.take(BoxesRunTime.unboxToInt(n)));
        }

        public <PI extends IterableSplitter<T>> Seq<PI> takeSeq(Seq<PI> sq, Function2<PI, Object, PI> taker) {
            Seq sizes = sq.scanLeft(BoxesRunTime.boxToInteger(0), (Function2<Object, IterableSplitter, Object> & java.io.Serializable & Serializable)(x$3, x$4) -> BoxesRunTime.boxToInteger(Taken.$anonfun$takeSeq$1(BoxesRunTime.unboxToInt(x$3), x$4)), Seq$.MODULE$.canBuildFrom());
            return (Seq)((TraversableLike)sq.zip(((IterableLike)sizes.init()).zip((GenIterable)sizes.tail(), Seq$.MODULE$.canBuildFrom()), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A check$ifrefutable$1) -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null && (Tuple2)check$ifrefutable$1._2() != null)).map((Function1<Tuple2, IterableSplitter> & java.io.Serializable & Serializable)x$5 -> {
                Tuple2 tuple2;
                IterableSplitter it;
                block3: {
                    block2: {
                        if (x$5 == null) break block2;
                        it = (IterableSplitter)x$5._1();
                        tuple2 = (Tuple2)x$5._2();
                        if (tuple2 != null) break block3;
                    }
                    throw new MatchError(x$5);
                }
                int from = tuple2._1$mcI$sp();
                IterableSplitter iterableSplitter = tuple2._2$mcI$sp() < this.remaining() ? it : (IterableSplitter)taker.apply(it, BoxesRunTime.boxToInteger(this.remaining() - from));
                return iterableSplitter;
            }, Seq$.MODULE$.canBuildFrom()).filter((Function1<IterableSplitter, Object> & java.io.Serializable & Serializable)(A x$6) -> BoxesRunTime.boxToBoolean(Taken.$anonfun$takeSeq$4(x$6)));
        }

        public /* synthetic */ IterableSplitter scala$collection$parallel$IterableSplitter$Taken$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ int $anonfun$takeSeq$1(int x$3, IterableSplitter x$4) {
            return x$3 + x$4.remaining();
        }

        public static final /* synthetic */ boolean $anonfun$takeSeq$4(IterableSplitter x$6) {
            return x$6.remaining() > 0;
        }

        public Taken(IterableSplitter $outer, int taken) {
            this.taken = taken;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            this.remaining = RichInt$.MODULE$.min$extension(taken, $outer.remaining());
        }
    }

    public class Zipped<S>
    implements IterableSplitter<Tuple2<T, S>> {
        private final SeqSplitter<S> that;
        private Signalling signalDelegate;
        public final /* synthetic */ IterableSplitter $outer;

        @Override
        public Seq<IterableSplitter<Tuple2<T, S>>> splitWithSignalling() {
            return ((IterableSplitter)this).splitWithSignalling();
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return ((IterableSplitter)this).shouldSplitFurther(coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return ((IterableSplitter)this).buildString(closure);
        }

        @Override
        public String debugInformation() {
            return ((IterableSplitter)this).debugInformation();
        }

        @Override
        public Taken newTaken(int until) {
            return ((IterableSplitter)this).newTaken(until);
        }

        @Override
        public <U extends Taken> U newSliceInternal(U it, int from1) {
            return (U)((IterableSplitter)this).newSliceInternal(it, from1);
        }

        @Override
        public IterableSplitter<Tuple2<T, S>> drop(int n) {
            return ((IterableSplitter)this).drop(n);
        }

        @Override
        public IterableSplitter<Tuple2<T, S>> take(int n) {
            return ((IterableSplitter)this).take(n);
        }

        @Override
        public IterableSplitter<Tuple2<T, S>> slice(int from1, int until1) {
            return ((IterableSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<Tuple2<T, S>, S> f) {
            return ((IterableSplitter)this).map(f);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> Appended<U, PI> appendParIterable(PI that) {
            return ((IterableSplitter)this).appendParIterable((IterableSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((IterableSplitter)this).zipParSeq(that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((IterableSplitter)this).zipAllParSeq(that, thisElem, thatElem);
        }

        @Override
        public boolean isAborted() {
            return DelegatedSignalling.isAborted$(this);
        }

        @Override
        public void abort() {
            DelegatedSignalling.abort$(this);
        }

        @Override
        public int indexFlag() {
            return DelegatedSignalling.indexFlag$(this);
        }

        @Override
        public void setIndexFlag(int f) {
            DelegatedSignalling.setIndexFlag$(this, f);
        }

        @Override
        public void setIndexFlagIfGreater(int f) {
            DelegatedSignalling.setIndexFlagIfGreater$(this, f);
        }

        @Override
        public void setIndexFlagIfLesser(int f) {
            DelegatedSignalling.setIndexFlagIfLesser$(this, f);
        }

        @Override
        public int tag() {
            return DelegatedSignalling.tag$(this);
        }

        @Override
        public int count(Function1<Tuple2<T, S>, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
        }

        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.fold$(this, z, op);
        }

        @Override
        public <U> U sum(Numeric<U> num) {
            return (U)AugmentedIterableIterator.sum$(this, num);
        }

        @Override
        public <U> U product(Numeric<U> num) {
            return (U)AugmentedIterableIterator.product$(this, num);
        }

        @Override
        public Object min(Ordering ord) {
            return AugmentedIterableIterator.min$(this, ord);
        }

        @Override
        public Object max(Ordering ord) {
            return AugmentedIterableIterator.max$(this, ord);
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            AugmentedIterableIterator.copyToArray$(this, array, from, len);
        }

        @Override
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<Tuple2<T, S>, S> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.map2combiner$(this, f, cb);
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<Tuple2<T, S>, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<Tuple2<T, S>, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<Tuple2<T, S>, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<Tuple2<T, S>, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<Tuple2<T, S>, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.take2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.drop2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
            return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<Tuple2<T, S>, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<Tuple2<T, S>, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.span2combiners$(this, p, before, after);
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
            AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
        }

        @Override
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<Tuple2<T, S>> seq() {
            return Iterator.seq$(this);
        }

        @Override
        public boolean isEmpty() {
            return Iterator.isEmpty$(this);
        }

        @Override
        public boolean isTraversableAgain() {
            return Iterator.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return Iterator.hasDefiniteSize$(this);
        }

        @Override
        public Iterator<Tuple2<T, S>> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<Tuple2<T, S>, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<Tuple2<T, S>> filter(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Tuple2<T, S>, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<Tuple2<T, S>> withFilter(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<Tuple2<T, S>> filterNot(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<Tuple2<T, S>, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, Tuple2<T, S>, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<Tuple2<T, S>, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<Tuple2<T, S>> takeWhile(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<Tuple2<T, S>>, Iterator<Tuple2<T, S>>> partition(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<Tuple2<T, S>>, Iterator<Tuple2<T, S>>> span(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<Tuple2<T, S>> dropWhile(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<Tuple2<T, S>, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<Tuple2<T, S>, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<Tuple2<T, S>, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<Tuple2<T, S>> find(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<Tuple2<T, S>, Object> p) {
            return Iterator.indexWhere$(this, p);
        }

        @Override
        public int indexWhere(Function1<Tuple2<T, S>, Object> p, int from) {
            return Iterator.indexWhere$(this, p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return Iterator.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return Iterator.indexOf$(this, elem, from);
        }

        @Override
        public BufferedIterator<Tuple2<T, S>> buffered() {
            return Iterator.buffered$(this);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> grouped(int size) {
            return Iterator.grouped$(this, size);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
            return Iterator.sliding$(this, size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return Iterator.sliding$default$2$(this);
        }

        @Override
        public int length() {
            return Iterator.length$(this);
        }

        @Override
        public Tuple2<Iterator<Tuple2<T, S>>, Iterator<Tuple2<T, S>>> duplicate() {
            return Iterator.duplicate$(this);
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return Iterator.patch$(this, from, patchElems, replaced);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return Iterator.sameElements$(this, that);
        }

        @Override
        public Traversable<Tuple2<T, S>> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<Tuple2<T, S>> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<Tuple2<T, S>> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public String toString() {
            return Iterator.toString$(this);
        }

        @Override
        public List<Tuple2<T, S>> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Tuple2<T, S>, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Tuple2<T, S>, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Tuple2<T, S>, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Tuple2<T, S>, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Tuple2<T, S>, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Tuple2<T, S>, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Tuple2<T, S>, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<T, S>, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Tuple2<T, S>, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<T, S>, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
            return TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<Tuple2<T, S>> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<Tuple2<T, S>> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<Tuple2<T, S>> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<Tuple2<T, S>> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Tuple2<T, S>> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<T, S>, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<T, S>, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return TraversableOnce.mkString$(this, start, sep, end);
        }

        @Override
        public String mkString(String sep) {
            return TraversableOnce.mkString$(this, sep);
        }

        @Override
        public String mkString() {
            return TraversableOnce.mkString$(this);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return TraversableOnce.addString$(this, b, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        @Override
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        public SeqSplitter<S> that() {
            return this.that;
        }

        @Override
        public boolean hasNext() {
            return this.scala$collection$parallel$IterableSplitter$Zipped$$$outer().hasNext() && this.that().hasNext();
        }

        @Override
        public Tuple2<T, S> next() {
            return new Tuple2(this.scala$collection$parallel$IterableSplitter$Zipped$$$outer().next(), this.that().next());
        }

        @Override
        public int remaining() {
            int n = this.scala$collection$parallel$IterableSplitter$Zipped$$$outer().remaining();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.min$extension(n, this.that().remaining());
        }

        @Override
        public IterableSplitter<Tuple2<T, S>> dup() {
            return this.scala$collection$parallel$IterableSplitter$Zipped$$$outer().dup().zipParSeq(this.that());
        }

        @Override
        public Seq<IterableSplitter<Tuple2<T, S>>> split() {
            Seq selfs = this.scala$collection$parallel$IterableSplitter$Zipped$$$outer().split();
            Seq<Object> sizes = selfs.map((Function1<IterableSplitter, Object> & java.io.Serializable & Serializable)x$8 -> BoxesRunTime.boxToInteger(x$8.remaining()), Seq$.MODULE$.canBuildFrom());
            Seq<SeqSplitter<S>> thats = this.that().psplit(sizes);
            return ((TraversableLike)selfs.zip(thats, Seq$.MODULE$.canBuildFrom())).map((Function1<Tuple2, Zipped> & java.io.Serializable & Serializable)p -> ((IterableSplitter)p._1()).zipParSeq((SeqSplitter)p._2()), Seq$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ IterableSplitter scala$collection$parallel$IterableSplitter$Zipped$$$outer() {
            return this.$outer;
        }

        public Zipped(IterableSplitter $outer, SeqSplitter<S> that) {
            this.that = that;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            this.signalDelegate_$eq($outer.signalDelegate());
        }
    }

    public class ZippedAll<U, S>
    implements IterableSplitter<Tuple2<U, S>> {
        private final SeqSplitter<S> that;
        private final U thiselem;
        private final S thatelem;
        private Signalling signalDelegate;
        public final /* synthetic */ IterableSplitter $outer;

        @Override
        public Seq<IterableSplitter<Tuple2<U, S>>> splitWithSignalling() {
            return ((IterableSplitter)this).splitWithSignalling();
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return ((IterableSplitter)this).shouldSplitFurther(coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return ((IterableSplitter)this).buildString(closure);
        }

        @Override
        public String debugInformation() {
            return ((IterableSplitter)this).debugInformation();
        }

        @Override
        public Taken newTaken(int until) {
            return ((IterableSplitter)this).newTaken(until);
        }

        @Override
        public <U extends Taken> U newSliceInternal(U it, int from1) {
            return (U)((IterableSplitter)this).newSliceInternal(it, from1);
        }

        @Override
        public IterableSplitter<Tuple2<U, S>> drop(int n) {
            return ((IterableSplitter)this).drop(n);
        }

        @Override
        public IterableSplitter<Tuple2<U, S>> take(int n) {
            return ((IterableSplitter)this).take(n);
        }

        @Override
        public IterableSplitter<Tuple2<U, S>> slice(int from1, int until1) {
            return ((IterableSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<Tuple2<U, S>, S> f) {
            return ((IterableSplitter)this).map(f);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> Appended<U, PI> appendParIterable(PI that) {
            return ((IterableSplitter)this).appendParIterable((IterableSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((IterableSplitter)this).zipParSeq(that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((IterableSplitter)this).zipAllParSeq(that, thisElem, thatElem);
        }

        @Override
        public boolean isAborted() {
            return DelegatedSignalling.isAborted$(this);
        }

        @Override
        public void abort() {
            DelegatedSignalling.abort$(this);
        }

        @Override
        public int indexFlag() {
            return DelegatedSignalling.indexFlag$(this);
        }

        @Override
        public void setIndexFlag(int f) {
            DelegatedSignalling.setIndexFlag$(this, f);
        }

        @Override
        public void setIndexFlagIfGreater(int f) {
            DelegatedSignalling.setIndexFlagIfGreater$(this, f);
        }

        @Override
        public void setIndexFlagIfLesser(int f) {
            DelegatedSignalling.setIndexFlagIfLesser$(this, f);
        }

        @Override
        public int tag() {
            return DelegatedSignalling.tag$(this);
        }

        @Override
        public int count(Function1<Tuple2<U, S>, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
        }

        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.fold$(this, z, op);
        }

        @Override
        public <U> U sum(Numeric<U> num) {
            return (U)AugmentedIterableIterator.sum$(this, num);
        }

        @Override
        public <U> U product(Numeric<U> num) {
            return (U)AugmentedIterableIterator.product$(this, num);
        }

        @Override
        public Object min(Ordering ord) {
            return AugmentedIterableIterator.min$(this, ord);
        }

        @Override
        public Object max(Ordering ord) {
            return AugmentedIterableIterator.max$(this, ord);
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            AugmentedIterableIterator.copyToArray$(this, array, from, len);
        }

        @Override
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<Tuple2<U, S>, S> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.map2combiner$(this, f, cb);
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<Tuple2<U, S>, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<Tuple2<U, S>, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<Tuple2<U, S>, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<Tuple2<U, S>, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<Tuple2<U, S>, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.take2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.drop2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
            return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<Tuple2<U, S>, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<Tuple2<U, S>, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.span2combiners$(this, p, before, after);
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
            AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
        }

        @Override
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<Tuple2<U, S>> seq() {
            return Iterator.seq$(this);
        }

        @Override
        public boolean isEmpty() {
            return Iterator.isEmpty$(this);
        }

        @Override
        public boolean isTraversableAgain() {
            return Iterator.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return Iterator.hasDefiniteSize$(this);
        }

        @Override
        public Iterator<Tuple2<U, S>> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<Tuple2<U, S>, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<Tuple2<U, S>> filter(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Tuple2<U, S>, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<Tuple2<U, S>> withFilter(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<Tuple2<U, S>> filterNot(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<Tuple2<U, S>, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, Tuple2<U, S>, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<Tuple2<U, S>, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<Tuple2<U, S>> takeWhile(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<Tuple2<U, S>>, Iterator<Tuple2<U, S>>> partition(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<Tuple2<U, S>>, Iterator<Tuple2<U, S>>> span(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<Tuple2<U, S>> dropWhile(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<Tuple2<U, S>, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<Tuple2<U, S>, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<Tuple2<U, S>, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<Tuple2<U, S>> find(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<Tuple2<U, S>, Object> p) {
            return Iterator.indexWhere$(this, p);
        }

        @Override
        public int indexWhere(Function1<Tuple2<U, S>, Object> p, int from) {
            return Iterator.indexWhere$(this, p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return Iterator.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return Iterator.indexOf$(this, elem, from);
        }

        @Override
        public BufferedIterator<Tuple2<U, S>> buffered() {
            return Iterator.buffered$(this);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> grouped(int size) {
            return Iterator.grouped$(this, size);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
            return Iterator.sliding$(this, size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return Iterator.sliding$default$2$(this);
        }

        @Override
        public int length() {
            return Iterator.length$(this);
        }

        @Override
        public Tuple2<Iterator<Tuple2<U, S>>, Iterator<Tuple2<U, S>>> duplicate() {
            return Iterator.duplicate$(this);
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return Iterator.patch$(this, from, patchElems, replaced);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return Iterator.sameElements$(this, that);
        }

        @Override
        public Traversable<Tuple2<U, S>> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<Tuple2<U, S>> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<Tuple2<U, S>> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public String toString() {
            return Iterator.toString$(this);
        }

        @Override
        public List<Tuple2<U, S>> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Tuple2<U, S>, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Tuple2<U, S>, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Tuple2<U, S>, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Tuple2<U, S>, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Tuple2<U, S>, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Tuple2<U, S>, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Tuple2<U, S>, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<U, S>, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Tuple2<U, S>, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<U, S>, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
            return TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<Tuple2<U, S>> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<Tuple2<U, S>> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<Tuple2<U, S>> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<Tuple2<U, S>> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Tuple2<U, S>> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<U, S>, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<U, S>, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return TraversableOnce.mkString$(this, start, sep, end);
        }

        @Override
        public String mkString(String sep) {
            return TraversableOnce.mkString$(this, sep);
        }

        @Override
        public String mkString() {
            return TraversableOnce.mkString$(this);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return TraversableOnce.addString$(this, b, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        @Override
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        public SeqSplitter<S> that() {
            return this.that;
        }

        public U thiselem() {
            return this.thiselem;
        }

        public S thatelem() {
            return this.thatelem;
        }

        @Override
        public boolean hasNext() {
            return this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().hasNext() || this.that().hasNext();
        }

        @Override
        public Tuple2<U, S> next() {
            if (this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().hasNext()) {
                if (this.that().hasNext()) {
                    return new Tuple2(this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().next(), this.that().next());
                }
                return new Tuple2(this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().next(), this.thatelem());
            }
            return new Tuple2(this.thiselem(), this.that().next());
        }

        @Override
        public int remaining() {
            int n = this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().remaining();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.max$extension(n, this.that().remaining());
        }

        @Override
        public IterableSplitter<Tuple2<U, S>> dup() {
            return this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().dup().zipAllParSeq(this.that(), this.thiselem(), this.thatelem());
        }

        @Override
        public Seq<IterableSplitter<Tuple2<U, S>>> split() {
            int thatrem;
            int selfrem = this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().remaining();
            Appended thisit = selfrem < (thatrem = this.that().remaining()) ? this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer().appendParIterable(scala.collection.parallel.immutable.package$.MODULE$.repetition(this.thiselem(), thatrem - selfrem).splitter()) : this.scala$collection$parallel$IterableSplitter$ZippedAll$$$outer();
            SeqSplitter<S> thatit = selfrem > thatrem ? this.that().appendParSeq(scala.collection.parallel.immutable.package$.MODULE$.repetition(this.thatelem(), selfrem - thatrem).splitter()) : this.that();
            return thisit.zipParSeq(thatit).split();
        }

        public /* synthetic */ IterableSplitter scala$collection$parallel$IterableSplitter$ZippedAll$$$outer() {
            return this.$outer;
        }

        public ZippedAll(IterableSplitter $outer, SeqSplitter<S> that, U thiselem, S thatelem) {
            this.that = that;
            this.thiselem = thiselem;
            this.thatelem = thatelem;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            this.signalDelegate_$eq($outer.signalDelegate());
        }
    }
}

