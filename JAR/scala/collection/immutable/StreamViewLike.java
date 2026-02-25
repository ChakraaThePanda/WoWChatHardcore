/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.IterableViewLike;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.SeqViewLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.SliceInterval;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.StreamView;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSeq;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\t\u001dga\u0002\u0013&!\u0003\r\t\u0001\f\u0005\u0006'\u0002!\t\u0001\u0016\u0005\u00061\u0002!\t%\u0017\u0004\bU\u0002\u0001\n1!\u0001l\u0011\u0015\u00196\u0001\"\u0001U\u0011\u0015\u00198\u0001\"\u0011u\r\u0019i\b!!\u0001(}\"9\u00111\u0002\u0004\u0005\u0002\u00055a!CA\t\u0001A\u0005\u0019\u0013AA\n\r%\tY\u0002\u0001I\u0001$\u0003\tiBB\u0005\u0002,\u0001\u0001\n1%\u0001\u0002.\u0019I\u0011Q\u0007\u0001\u0011\u0002G\u0005\u0011q\u0007\u0004\n\u0003\u000b\u0002\u0001\u0013aI\u0001\u0003\u000f2\u0011\"!\u0016\u0001!\u0003\r\n!a\u0016\u0007\u0013\u0005\u0015\u0004\u0001%A\u0012\u0002\u0005\u001dd!CA7\u0001A\u0005\u0019\u0013AA8\r%\t)\b\u0001I\u0001$\u0003\t9HB\u0005\u0002~\u0001\u0001\n1%\u0001\u0002\u0000\u0019I\u00111\u0013\u0001\u0011\u0002G\u0005\u0011Q\u0013\u0004\n\u0003W\u0003\u0001\u0013aI\u0001\u0003[3\u0011\"a-\u0001!\u0003\r\n!!.\u0007\u0013\u0005\r\u0007\u0001%A\u0012\u0002\u0005\u0015\u0007bBAj\u0001\u0011E\u0013Q\u001b\u0005\b\u0003_\u0004A\u0011KAy\u0011\u001d\u0011)\u0001\u0001C)\u0005\u000fAqA!\u0006\u0001\t#\u00129\u0002C\u0004\u0003,\u0001!\tF!\f\t\u000f\t\u0005\u0003\u0001\"\u0015\u0003D!9!\u0011\u000b\u0001\u0005R\tM\u0003b\u0002B0\u0001\u0011E#\u0011\r\u0005\b\u0005K\u0002A\u0011\u000bB4\u0011\u001d\u0011Y\u0007\u0001C)\u0005[BqA!!\u0001\t#\u0012\u0019\tC\u0004\u0003 \u0002!\tF!)\t\u000f\t\r\u0006\u0001\"\u0015\u0003&\"9!1\u0019\u0001\u0005B\t\u0015'AD*ue\u0016\fWNV5fo2K7.\u001a\u0006\u0003M\u001d\n\u0011\"[7nkR\f'\r\\3\u000b\u0005!J\u0013AC2pY2,7\r^5p]*\t!&A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\t5B$\tS\n\u0005\u00019\u0012D\t\u0005\u00020a5\t\u0011&\u0003\u00022S\t1\u0011I\\=SK\u001a\u0004Ba\r\u001b7\u00036\tq%\u0003\u00026O\t91+Z9WS\u0016<\bCA\u001c9\u0019\u0001!a!\u000f\u0001\u0005\u0006\u0004Q$!A!\u0012\u0005mr\u0004CA\u0018=\u0013\ti\u0014FA\u0004O_RD\u0017N\\4\u0011\u0005=z\u0014B\u0001!*\u0005\r\te.\u001f\t\u0003o\t#aa\u0011\u0001\u0005\u0006\u0004Q$\u0001B\"pY2\u0004RaM#7\u0003\u001eK!AR\u0014\u0003\u0017M+\u0017OV5fo2K7.\u001a\t\u0003o!#a!\u0013\u0001\u0005\u0006\u0004Q%\u0001\u0002+iSN\f\"aO&\u0013\u00071s%K\u0002\u0003N\u0001\u0001Y%\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004\u0003B(Qm\u0005k\u0011!J\u0005\u0003#\u0016\u0012!b\u0015;sK\u0006lg+[3x!\u0015y\u0005AN!H\u0003\u0019!\u0013N\\5uIQ\tQ\u000b\u0005\u00020-&\u0011q+\u000b\u0002\u0005+:LG/A\u0003g_J\u001cW-F\u0002[Or#\"a\u00170\u0011\u0005]bF!B/\u0003\u0005\u0004Q$\u0001\u0002+iCRDQa\u0018\u0002A\u0004\u0001\f!A\u00194\u0011\u000b\u0005$\u0017IZ.\u000e\u0003\tT!aY\u0014\u0002\u000f\u001d,g.\u001a:jG&\u0011QM\u0019\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0003o\u001d$Q\u0001\u001b\u0002C\u0002%\u0014\u0011AQ\t\u0003my\u00121\u0002\u0016:b]N4wN]7fIV\u0011An\\\n\u0005\u00079j\u0007\u000f\u0005\u0003P!:\f\u0005CA\u001cp\t\u0019A7\u0001\"b\u0001uA\u0019\u0011O\u001d8\u000e\u0003\u0001I!A[#\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012!\u001e\t\u0003mnl\u0011a\u001e\u0006\u0003qf\fA\u0001\\1oO*\t!0\u0001\u0003kCZ\f\u0017B\u0001?x\u0005\u0019\u0019FO]5oO\n\u0019\u0012IY:ue\u0006\u001cG\u000f\u0016:b]N4wN]7fIV\u0019q0a\u0002\u0014\u000b\u0019\t\t!!\u0003\u0011\u000bE\f\u0019!!\u0002\n\u0005u,\u0005cA\u001c\u0002\b\u00111\u0001N\u0002CC\u0002i\u0002B!]\u0002\u0002\u0006\u00051A(\u001b8jiz\"\"!a\u0004\u0011\tE4\u0011Q\u0001\u0002\n\u000b6\u0004H/\u001f,jK^\u001cb\u0001\u0003\u0018\u0002\u0016\u0005]\u0001cA9\u0004wA\u0019\u0011/!\u0007\n\u0007\u0005EQI\u0001\u0004G_J\u001cW\rZ\u000b\u0005\u0003?\t9c\u0005\u0004\n]\u0005\u0005\u0012\u0011\u0006\t\u0006c\u0006\r\u0012QE\u0005\u0004\u00037)\u0005cA\u001c\u0002(\u0011)\u0001.\u0003b\u0001uA!\u0011oAA\u0013\u0005\u0019\u0019F.[2fIN1!BLA\u0018\u0003g\u00012!]A\u0019\u0013\r\tY#\u0012\t\u0004c\u000e1$AB'baB,G-\u0006\u0003\u0002:\u0005\u00053CB\u0006/\u0003w\t\u0019\u0005E\u0003r\u0003{\ty$C\u0002\u00026\u0015\u00032aNA!\t\u0015A7B1\u0001;!\u0011\t8!a\u0010\u0003\u0015\u0019c\u0017\r^'baB,G-\u0006\u0003\u0002J\u0005E3C\u0002\u0007/\u0003\u0017\n\u0019\u0006E\u0003r\u0003\u001b\ny%C\u0002\u0002F\u0015\u00032aNA)\t\u0015AGB1\u0001;!\u0011\t8!a\u0014\u0003\u0011\u0005\u0003\b/\u001a8eK\u0012,B!!\u0017\u0002bM1QBLA.\u0003G\u0002R!]A/\u0003?J1!!\u0016F!\r9\u0014\u0011\r\u0003\u0006Q6\u0011\r!\u001b\t\u0005c\u000e\tyF\u0001\u0005GS2$XM]3e'\u0019qa&!\u001b\u00024A\u0019\u0011/a\u001b\n\u0007\u0005\u0015TI\u0001\u0006UC.,gn\u00165jY\u0016\u001cba\u0004\u0018\u0002r\u0005M\u0002cA9\u0002t%\u0019\u0011QN#\u0003\u0019\u0011\u0013x\u000e\u001d9fI^C\u0017\u000e\\3\u0014\rAq\u0013\u0011PA\u001a!\r\t\u00181P\u0005\u0004\u0003k*%A\u0002.jaB,G-\u0006\u0003\u0002\u0002\u0006%5CB\t/\u0003\u0007\u000bY\tE\u0003r\u0003\u000b\u000b9)C\u0002\u0002~\u0015\u00032aNAE\t\u0015A\u0017C1\u0001;!\u0011\t8!!$\u0011\r=\nyINAD\u0013\r\t\t*\u000b\u0002\u0007)V\u0004H.\u001a\u001a\u0003\u0013iK\u0007\u000f]3e\u00032dWCBAL\u0003?\u000b)k\u0005\u0004\u0013]\u0005e\u0015q\u0015\t\bc\u0006m\u0015QTAR\u0013\r\t\u0019*\u0012\t\u0004o\u0005}EABAQ%\t\u0007\u0011N\u0001\u0002BcA\u0019q'!*\u0005\u000b!\u0014\"\u0019\u0001\u001e\u0011\tE\u001c\u0011\u0011\u0016\t\b_\u0005=\u0015QTAR\u0005!\u0011VM^3sg\u0016$7CB\n/\u0003_\u000b\u0019\u0004E\u0002r\u0003cK1!a+F\u0005\u001d\u0001\u0016\r^2iK\u0012,B!a.\u0002@N1ACLA]\u0003\u0003\u0004R!]A^\u0003{K1!a-F!\r9\u0014q\u0018\u0003\u0006QR\u0011\r!\u001b\t\u0005c\u000e\tiLA\u0005Qe\u0016\u0004XM\u001c3fIV!\u0011qYAh'\u0019)b&!3\u0002RB)\u0011/a3\u0002N&\u0019\u00111Y#\u0011\u0007]\ny\rB\u0003i+\t\u0007\u0011\u000e\u0005\u0003r\u0007\u00055\u0017!\u00038fo\u001a{'oY3e+\u0011\t9.!8\u0015\t\u0005e\u0017q\u001c\t\u0005c\u000e\tY\u000eE\u00028\u0003;$Q\u0001\u001b\fC\u0002iB\u0001\"!9\u0017\t\u0003\u0007\u00111]\u0001\u0003qN\u0004RaLAs\u0003SL1!a:*\u0005!a$-\u001f8b[\u0016t\u0004#B\u001a\u0002l\u0006m\u0017bAAwO\t1q)\u001a8TKF\f1B\\3x\u0003B\u0004XM\u001c3fIV!\u00111_A})\u0011\t)0a?\u0011\tE\u001c\u0011q\u001f\t\u0004o\u0005eH!\u00025\u0018\u0005\u0004I\u0007bBA\u007f/\u0001\u0007\u0011q`\u0001\u0005i\"\fG\u000fE\u00034\u0005\u0003\t90C\u0002\u0003\u0004\u001d\u0012abR3o)J\fg/\u001a:tC\ndW-\u0001\u0007oK^\u0004&/\u001a9f]\u0012,G-\u0006\u0003\u0003\n\t=A\u0003\u0002B\u0006\u0005#\u0001B!]\u0002\u0003\u000eA\u0019qGa\u0004\u0005\u000b!D\"\u0019A5\t\u000f\u0005u\b\u00041\u0001\u0003\u0014A)1G!\u0001\u0003\u000e\u0005Ia.Z<NCB\u0004X\rZ\u000b\u0005\u00053\u0011y\u0002\u0006\u0003\u0003\u001c\t\u0005\u0002\u0003B9\u0004\u0005;\u00012a\u000eB\u0010\t\u0015A\u0017D1\u0001;\u0011\u001d\u0011\u0019#\u0007a\u0001\u0005K\t\u0011A\u001a\t\u0007_\t\u001dbG!\b\n\u0007\t%\u0012FA\u0005Gk:\u001cG/[8oc\u0005ia.Z<GY\u0006$X*\u00199qK\u0012,BAa\f\u00036Q!!\u0011\u0007B\u001c!\u0011\t8Aa\r\u0011\u0007]\u0012)\u0004B\u0003i5\t\u0007!\bC\u0004\u0003$i\u0001\rA!\u000f\u0011\r=\u00129C\u000eB\u001e!\u0015\u0019$Q\bB\u001a\u0013\r\u0011yd\n\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-A\u0006oK^4\u0015\u000e\u001c;fe\u0016$G\u0003BA\u001a\u0005\u000bBqAa\u0012\u001c\u0001\u0004\u0011I%A\u0001q!\u0019y#q\u0005\u001c\u0003LA\u0019qF!\u0014\n\u0007\t=\u0013FA\u0004C_>dW-\u00198\u0002\u00139,wo\u00157jG\u0016$G\u0003BA\u001a\u0005+BqAa\u0016\u001d\u0001\u0004\u0011I&\u0001\u0006`K:$\u0007o\\5oiN\u00042!\u0019B.\u0013\r\u0011iF\u0019\u0002\u000e'2L7-Z%oi\u0016\u0014h/\u00197\u0002\u001f9,w\u000f\u0012:paB,Gm\u00165jY\u0016$B!a\r\u0003d!9!qI\u000fA\u0002\t%\u0013!\u00048foR\u000b7.\u001a8XQ&dW\r\u0006\u0003\u00024\t%\u0004b\u0002B$=\u0001\u0007!\u0011J\u0001\n]\u0016<(,\u001b9qK\u0012,BAa\u001c\u0003xQ!!\u0011\u000fB=!\u0011\t8Aa\u001d\u0011\r=\nyI\u000eB;!\r9$q\u000f\u0003\u0006Q~\u0011\rA\u000f\u0005\b\u0003{|\u0002\u0019\u0001B>!\u0015\u0019$Q\u0010B;\u0013\r\u0011yh\n\u0002\f\u000f\u0016t\u0017\n^3sC\ndW-\u0001\u0007oK^T\u0016\u000e\u001d9fI\u0006cG.\u0006\u0004\u0003\u0006\n5%\u0011\u0013\u000b\t\u0005\u000f\u0013\u0019Ja&\u0003\u001cB!\u0011o\u0001BE!\u001dy\u0013q\u0012BF\u0005\u001f\u00032a\u000eBG\t\u0019\t\t\u000b\tb\u0001SB\u0019qG!%\u0005\u000b!\u0004#\u0019\u0001\u001e\t\u000f\u0005u\b\u00051\u0001\u0003\u0016B)1G! \u0003\u0010\"9!\u0011\u0014\u0011A\u0002\t-\u0015!C0uQ&\u001cX\t\\3n\u0011\u001d\u0011i\n\ta\u0001\u0005\u001f\u000b\u0011b\u0018;iCR,E.Z7\u0002\u00179,wOU3wKJ\u001cX\rZ\u000b\u0003\u0003g\t!B\\3x!\u0006$8\r[3e+\u0011\u00119K!,\u0015\u0011\t%&q\u0016B]\u0005\u007f\u0003B!]\u0002\u0003,B\u0019qG!,\u0005\u000b!\u0014#\u0019A5\t\u000f\tE&\u00051\u0001\u00034\u0006)qL\u001a:p[B\u0019qF!.\n\u0007\t]\u0016FA\u0002J]RDqAa/#\u0001\u0004\u0011i,\u0001\u0004`a\u0006$8\r\u001b\t\u0006g\u0005-(1\u0016\u0005\b\u0005\u0003\u0014\u0003\u0019\u0001BZ\u0003%y&/\u001a9mC\u000e,G-\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070F\u0001v\u0001")
public interface StreamViewLike<A, Coll, This extends StreamView<A, Coll> & StreamViewLike<A, Coll, This>>
extends SeqView<A, Coll> {
    @Override
    default public <B, That> That force(CanBuildFrom<Coll, B, That> bf) {
        return (That)this.iterator().toStream();
    }

    @Override
    default public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
        return new Forced<B>(this, xs){
            private final GenSeq<B> forced;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.Forced.length$(this);
            }

            public B apply(int idx) {
                return (B)SeqViewLike.Forced.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Forced.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Forced.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Forced.viewIdentifier$(this);
            }

            public GenSeq<B> forced() {
                return this.forced;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Forced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Forced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Forced$$$outer() {
                return this.$outer;
            }
            {
                GenSeq forced;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.forced = forced = (GenSeq)xs$1.apply();
                super($outer);
                TraversableViewLike.Forced.$init$(this);
                IterableViewLike.Forced.$init$(this);
                SeqViewLike.Forced.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newAppended(GenTraversable<B> that) {
        return new Appended<B>(this, that){
            private final GenTraversable<B> rest;
            private GenSeq<B> restSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.Appended.length$(this);
            }

            public B apply(int idx) {
                return (B)SeqViewLike.Appended.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Appended.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Appended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Appended.viewIdentifier$(this);
            }

            private GenSeq<B> restSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.restSeq = SeqViewLike.Appended.restSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.restSeq;
            }

            public GenSeq<B> restSeq() {
                if (!this.bitmap$0) {
                    return this.restSeq$lzycompute();
                }
                return this.restSeq;
            }

            public GenTraversable<B> rest() {
                return this.rest;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Appended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Appended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Appended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.rest = that$1;
                super($outer);
                TraversableViewLike.Appended.$init$(this);
                IterableViewLike.Appended.$init$(this);
                SeqViewLike.Appended.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
        return new Prepended<B>(this, that){
            private final GenTraversable<B> fst;
            private GenSeq<B> fstSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.Prepended.length$(this);
            }

            public B apply(int idx) {
                return (B)SeqViewLike.Prepended.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Prepended.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Prepended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Prepended.viewIdentifier$(this);
            }

            private GenSeq<B> fstSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.fstSeq = SeqViewLike.Prepended.fstSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.fstSeq;
            }

            public GenSeq<B> fstSeq() {
                if (!this.bitmap$0) {
                    return this.fstSeq$lzycompute();
                }
                return this.fstSeq;
            }

            public GenTraversable<B> fst() {
                return this.fst;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Prepended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Prepended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Prepended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.fst = that$2;
                super($outer);
                TraversableViewLike.Prepended.$init$(this);
                IterableViewLike.Prepended.$init$(this);
                SeqViewLike.Prepended.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newMapped(Function1<A, B> f) {
        return new Mapped<B>(this, f){
            private final Function1<A, B> mapping;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.Mapped.length$(this);
            }

            public B apply(int idx) {
                return (B)SeqViewLike.Mapped.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Mapped.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Mapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Mapped.viewIdentifier$(this);
            }

            public Function1<A, B> mapping() {
                return this.mapping;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Mapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Mapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Mapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$1;
                super($outer);
                TraversableViewLike.Mapped.$init$(this);
                IterableViewLike.Mapped.$init$(this);
                SeqViewLike.Mapped.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
        return new FlatMapped<B>(this, f){
            private final Function1<A, GenTraversableOnce<B>> mapping;
            private int[] index;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int findRow(int idx, int lo, int hi) {
                return SeqViewLike.FlatMapped.findRow$(this, idx, lo, hi);
            }

            public int length() {
                return SeqViewLike.FlatMapped.length$(this);
            }

            public B apply(int idx) {
                return (B)SeqViewLike.FlatMapped.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.FlatMapped.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.FlatMapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.FlatMapped.viewIdentifier$(this);
            }

            private int[] index$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.index = SeqViewLike.FlatMapped.index$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.index;
            }

            public int[] index() {
                if (!this.bitmap$0) {
                    return this.index$lzycompute();
                }
                return this.index;
            }

            public Function1<A, GenTraversableOnce<B>> mapping() {
                return this.mapping;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$2;
                super($outer);
                TraversableViewLike.FlatMapped.$init$(this);
                IterableViewLike.FlatMapped.$init$(this);
                SeqViewLike.FlatMapped.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newFiltered(Function1<A, Object> p) {
        return new Filtered(this, p){
            private final Function1<A, Object> pred;
            private int[] index;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.Filtered.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.Filtered.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.Filtered.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.Filtered.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Filtered.viewIdentifier$(this);
            }

            private int[] index$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.index = SeqViewLike.Filtered.index$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.index;
            }

            public int[] index() {
                if (!this.bitmap$0) {
                    return this.index$lzycompute();
                }
                return this.index;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Filtered$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$1;
                super($outer);
                TraversableViewLike.Filtered.$init$(this);
                IterableViewLike.Filtered.$init$(this);
                SeqViewLike.Filtered.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newSliced(SliceInterval _endpoints) {
        return new Sliced(this, _endpoints){
            private final SliceInterval endpoints;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.Sliced.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.Sliced.apply$(this, idx);
            }

            public <U> void foreach(Function1<Object, U> f) {
                SeqViewLike.Sliced.foreach$(this, f);
            }

            public Iterator<Object> iterator() {
                return SeqViewLike.Sliced.iterator$(this);
            }

            public int from() {
                return TraversableViewLike.Sliced.from$(this);
            }

            public int until() {
                return TraversableViewLike.Sliced.until$(this);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Sliced.viewIdentifier$(this);
            }

            public SliceInterval endpoints() {
                return this.endpoints;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Sliced$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.endpoints = _endpoints$1;
                super($outer);
                TraversableViewLike.Sliced.$init$(this);
                IterableViewLike.Sliced.$init$(this);
                SeqViewLike.Sliced.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newDroppedWhile(Function1<A, Object> p) {
        return new DroppedWhile(this, p){
            private final Function1<A, Object> pred;
            private int start;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.DroppedWhile.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.DroppedWhile.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.DroppedWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.DroppedWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.DroppedWhile.viewIdentifier$(this);
            }

            private int start$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.start = SeqViewLike.DroppedWhile.start$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.start;
            }

            public int start() {
                if (!this.bitmap$0) {
                    return this.start$lzycompute();
                }
                return this.start;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$2;
                super($outer);
                TraversableViewLike.DroppedWhile.$init$(this);
                IterableViewLike.DroppedWhile.$init$(this);
                SeqViewLike.DroppedWhile.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newTakenWhile(Function1<A, Object> p) {
        return new TakenWhile(this, p){
            private final Function1<A, Object> pred;
            private int len;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.TakenWhile.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.TakenWhile.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.TakenWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.TakenWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.TakenWhile.viewIdentifier$(this);
            }

            private int len$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.len = SeqViewLike.TakenWhile.len$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.len;
            }

            public int len() {
                if (!this.bitmap$0) {
                    return this.len$lzycompute();
                }
                return this.len;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$3;
                super($outer);
                TraversableViewLike.TakenWhile.$init$(this);
                IterableViewLike.TakenWhile.$init$(this);
                SeqViewLike.TakenWhile.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
        return new Zipped<B>(this, that){
            private final GenIterable<B> other;
            private Seq<B> thatSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.Zipped.length$(this);
            }

            public Tuple2<A, B> apply(int idx) {
                return SeqViewLike.Zipped.apply$(this, idx);
            }

            public Iterator<Tuple2<A, B>> iterator() {
                return IterableViewLike.Zipped.iterator$(this);
            }

            public final String viewIdentifier() {
                return IterableViewLike.Zipped.viewIdentifier$(this);
            }

            private Seq<B> thatSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.thatSeq = SeqViewLike.Zipped.thatSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.thatSeq;
            }

            public Seq<B> thatSeq() {
                if (!this.bitmap$0) {
                    return this.thatSeq$lzycompute();
                }
                return this.thatSeq;
            }

            public GenIterable<B> other() {
                return this.other;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Zipped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Zipped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.other = that$3;
                super($outer);
                IterableViewLike.Zipped.$init$(this);
                SeqViewLike.Zipped.$init$(this);
            }
        };
    }

    @Override
    default public <A1, B> Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
        return new ZippedAll<A1, B>(this, that, _thisElem, _thatElem){
            private final GenIterable<B> other;
            private final A1 thisElem;
            private final B thatElem;
            private Seq<B> thatSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public int length() {
                return SeqViewLike.ZippedAll.length$(this);
            }

            public Tuple2<A1, B> apply(int idx) {
                return SeqViewLike.ZippedAll.apply$(this, idx);
            }

            public final String viewIdentifier() {
                return IterableViewLike.ZippedAll.viewIdentifier$(this);
            }

            public Iterator<Tuple2<A1, B>> iterator() {
                return IterableViewLike.ZippedAll.iterator$(this);
            }

            private Seq<B> thatSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.thatSeq = SeqViewLike.ZippedAll.thatSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.thatSeq;
            }

            public Seq<B> thatSeq() {
                if (!this.bitmap$0) {
                    return this.thatSeq$lzycompute();
                }
                return this.thatSeq;
            }

            public GenIterable<B> other() {
                return this.other;
            }

            public A1 thisElem() {
                return this.thisElem;
            }

            public B thatElem() {
                return this.thatElem;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$ZippedAll$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$ZippedAll$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.other = that$4;
                this.thisElem = _thisElem$1;
                this.thatElem = _thatElem$1;
                super($outer);
                IterableViewLike.ZippedAll.$init$(this);
                SeqViewLike.ZippedAll.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newReversed() {
        return new Reversed(this){
            private Coll underlying;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public String toString() {
                return Transformed.toString$(this);
            }

            public <B, That> That force(CanBuildFrom<Coll, B, That> bf) {
                return (That)StreamViewLike.force$(this, bf);
            }

            public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
                return StreamViewLike.newForced$(this, xs);
            }

            public <B> Transformed<B> newAppended(GenTraversable<B> that) {
                return StreamViewLike.newAppended$(this, that);
            }

            public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
                return StreamViewLike.newPrepended$(this, that);
            }

            public <B> Transformed<B> newMapped(Function1<A, B> f) {
                return StreamViewLike.newMapped$(this, f);
            }

            public <B> Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
                return StreamViewLike.newFlatMapped$(this, f);
            }

            public Transformed<A> newFiltered(Function1<A, Object> p) {
                return StreamViewLike.newFiltered$(this, p);
            }

            public Transformed<A> newSliced(SliceInterval _endpoints) {
                return StreamViewLike.newSliced$(this, _endpoints);
            }

            public Transformed<A> newDroppedWhile(Function1<A, Object> p) {
                return StreamViewLike.newDroppedWhile$(this, p);
            }

            public Transformed<A> newTakenWhile(Function1<A, Object> p) {
                return StreamViewLike.newTakenWhile$(this, p);
            }

            public <B> Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
                return StreamViewLike.newZipped$(this, that);
            }

            public <A1, B> Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
                return StreamViewLike.newZippedAll$(this, that, _thisElem, _thatElem);
            }

            public Transformed<A> newReversed() {
                return StreamViewLike.newReversed$(this);
            }

            public <B> Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
                return StreamViewLike.newPatched$(this, _from, _patch, _replaced);
            }

            public String stringPrefix() {
                return StreamViewLike.stringPrefix$(this);
            }

            public Iterator<Object> iterator() {
                return SeqViewLike.Reversed.iterator$(this);
            }

            public int length() {
                return SeqViewLike.Reversed.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.Reversed.apply$(this, idx);
            }

            public final String viewIdentifier() {
                return SeqViewLike.Reversed.viewIdentifier$(this);
            }

            public <U> void foreach(Function1<A, U> f) {
                IterableViewLike.Transformed.foreach$(this, f);
            }

            public boolean isEmpty() {
                return IterableViewLike.Transformed.isEmpty$(this);
            }

            public final String viewIdString() {
                return TraversableViewLike.Transformed.viewIdString$(this);
            }

            public Option<A> headOption() {
                return TraversableViewLike.Transformed.headOption$(this);
            }

            public A last() {
                return (A)TraversableViewLike.Transformed.last$(this);
            }

            public Option<A> lastOption() {
                return TraversableViewLike.Transformed.lastOption$(this);
            }

            public SeqViewLike.Transformed<A> newTaken(int n) {
                return SeqViewLike.newTaken$(this, n);
            }

            public SeqViewLike.Transformed<A> newDropped(int n) {
                return SeqViewLike.newDropped$(this, n);
            }

            public SeqView reverse() {
                return SeqViewLike.reverse$(this);
            }

            public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)SeqViewLike.patch$(this, from, patch, replaced, bf);
            }

            public <B, That> That padTo(int len, B elem, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)SeqViewLike.padTo$(this, len, elem, bf);
            }

            public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)SeqViewLike.reverseMap$(this, f, bf);
            }

            public <B, That> That updated(int index, B elem, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)SeqViewLike.updated$(this, index, elem, bf);
            }

            public <B, That> That $plus$colon(B elem, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)SeqViewLike.$plus$colon$(this, elem, bf);
            }

            public <B, That> That $colon$plus(B elem, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)SeqViewLike.$colon$plus$(this, elem, bf);
            }

            public <B, That> That union(GenSeq<B> that, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)SeqViewLike.union$(this, that, bf);
            }

            public SeqView diff(GenSeq that) {
                return SeqViewLike.diff$(this, that);
            }

            public SeqView intersect(GenSeq that) {
                return SeqViewLike.intersect$(this, that);
            }

            public SeqView sorted(Ordering ord) {
                return SeqViewLike.sorted$(this, ord);
            }

            public SeqView sortWith(Function2 lt) {
                return SeqViewLike.sortWith$(this, lt);
            }

            public SeqView sortBy(Function1 f, Ordering ord) {
                return SeqViewLike.sortBy$(this, f, ord);
            }

            public Iterator<StreamView<A, Coll>> combinations(int n) {
                return SeqViewLike.combinations$(this, n);
            }

            public Iterator<StreamView<A, Coll>> permutations() {
                return SeqViewLike.permutations$(this);
            }

            public SeqView distinct() {
                return SeqViewLike.distinct$(this);
            }

            public IterableView drop(int n) {
                return IterableViewLike.drop$(this, n);
            }

            public IterableView take(int n) {
                return IterableViewLike.take$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<StreamView<A, Coll>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zip$(this, that, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<StreamView<A, Coll>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableViewLike.zipWithIndex$(this, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<StreamView<A, Coll>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public Iterator<StreamView<A, Coll>> grouped(int size) {
                return IterableViewLike.grouped$(this, size);
            }

            public Iterator<StreamView<A, Coll>> sliding(int size, int step) {
                return IterableViewLike.sliding$(this, size, step);
            }

            public Iterator<StreamView<A, Coll>> sliding(int size) {
                return IterableViewLike.sliding$(this, size);
            }

            public IterableView dropRight(int n) {
                return IterableViewLike.dropRight$(this, n);
            }

            public IterableView takeRight(int n) {
                return IterableViewLike.takeRight$(this, n);
            }

            public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
                return (TraversableView)TraversableLike.tail$(this);
            }

            public String viewToString() {
                return TraversableViewLike.viewToString$(this);
            }

            public Builder<A, StreamView<A, Coll>> newBuilder() {
                return TraversableViewLike.newBuilder$(this);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.map$(this, f, bf);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.collect$(this, pf, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.flatMap$(this, f, bf);
            }

            public <B> TraversableViewLike.Transformed<B> flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
                return TraversableViewLike.flatten$(this, asTraversable);
            }

            public TraversableView filter(Function1 p) {
                return TraversableViewLike.filter$(this, p);
            }

            public TraversableView withFilter(Function1 p) {
                return TraversableViewLike.withFilter$(this, p);
            }

            public Tuple2<StreamView<A, Coll>, StreamView<A, Coll>> partition(Function1<A, Object> p) {
                return TraversableViewLike.partition$(this, p);
            }

            public TraversableView init() {
                return TraversableViewLike.init$(this);
            }

            public TraversableView slice(int from, int until) {
                return TraversableViewLike.slice$(this, from, until);
            }

            public TraversableView dropWhile(Function1 p) {
                return TraversableViewLike.dropWhile$(this, p);
            }

            public TraversableView takeWhile(Function1 p) {
                return TraversableViewLike.takeWhile$(this, p);
            }

            public Tuple2<StreamView<A, Coll>, StreamView<A, Coll>> span(Function1<A, Object> p) {
                return TraversableViewLike.span$(this, p);
            }

            public Tuple2<StreamView<A, Coll>, StreamView<A, Coll>> splitAt(int n) {
                return TraversableViewLike.splitAt$(this, n);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<StreamView<A, Coll>, B, That> bf) {
                return (That)TraversableViewLike.scanRight$(this, z, op, bf);
            }

            public <K> Map<K, StreamView<A, Coll>> groupBy(Function1<A, K> f) {
                return TraversableViewLike.groupBy$(this, f);
            }

            public <A1, A2> Tuple2<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return TraversableViewLike.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>, TraversableViewLike.Transformed<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
                return TraversableViewLike.unzip3$(this, asTriple);
            }

            public TraversableView filterNot(Function1 p) {
                return TraversableViewLike.filterNot$(this, p);
            }

            public Iterator<StreamView<A, Coll>> inits() {
                return TraversableViewLike.inits$(this);
            }

            public Iterator<StreamView<A, Coll>> tails() {
                return TraversableViewLike.tails$(this);
            }

            public TraversableView tail() {
                return TraversableViewLike.tail$(this);
            }

            public Seq<A> thisSeq() {
                return ViewMkString.thisSeq$(this);
            }

            public String mkString() {
                return ViewMkString.mkString$(this);
            }

            public String mkString(String sep) {
                return ViewMkString.mkString$(this, sep);
            }

            public String mkString(String start, String sep, String end) {
                return ViewMkString.mkString$(this, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return ViewMkString.addString$(this, b, start, sep, end);
            }

            public GenericCompanion<Seq> companion() {
                return Seq.companion$(this);
            }

            public Seq<A> seq() {
                return Seq.seq$(this);
            }

            public Seq<A> thisCollection() {
                return SeqLike.thisCollection$(this);
            }

            public Seq toCollection(Object repr) {
                return SeqLike.toCollection$(this, repr);
            }

            public Combiner<A, ParSeq<A>> parCombiner() {
                return SeqLike.parCombiner$(this);
            }

            public int lengthCompare(int len) {
                return SeqLike.lengthCompare$(this, len);
            }

            public int size() {
                return SeqLike.size$(this);
            }

            public int segmentLength(Function1<A, Object> p, int from) {
                return SeqLike.segmentLength$(this, p, from);
            }

            public int indexWhere(Function1<A, Object> p, int from) {
                return SeqLike.indexWhere$(this, p, from);
            }

            public int lastIndexWhere(Function1<A, Object> p, int end) {
                return SeqLike.lastIndexWhere$(this, p, end);
            }

            public Iterator<A> reverseIterator() {
                return SeqLike.reverseIterator$(this);
            }

            public <B> boolean startsWith(GenSeq<B> that, int offset) {
                return SeqLike.startsWith$(this, that, offset);
            }

            public <B> boolean endsWith(GenSeq<B> that) {
                return SeqLike.endsWith$(this, that);
            }

            public <B> int indexOfSlice(GenSeq<B> that) {
                return SeqLike.indexOfSlice$(this, that);
            }

            public <B> int indexOfSlice(GenSeq<B> that, int from) {
                return SeqLike.indexOfSlice$(this, that, from);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that) {
                return SeqLike.lastIndexOfSlice$(this, that);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
                return SeqLike.lastIndexOfSlice$(this, that, end);
            }

            public <B> boolean containsSlice(GenSeq<B> that) {
                return SeqLike.containsSlice$(this, that);
            }

            public <A1> boolean contains(A1 elem) {
                return SeqLike.contains$(this, elem);
            }

            public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
                return SeqLike.corresponds$(this, that, p);
            }

            public Seq<A> toSeq() {
                return SeqLike.toSeq$(this);
            }

            public Range indices() {
                return SeqLike.indices$(this);
            }

            public SeqView<A, StreamView<A, Coll>> view() {
                return SeqLike.view$(this);
            }

            public SeqView<A, StreamView<A, Coll>> view(int from, int until) {
                return SeqLike.view$(this, from, until);
            }

            public boolean isDefinedAt(int idx) {
                return GenSeqLike.isDefinedAt$(this, idx);
            }

            public int prefixLength(Function1<A, Object> p) {
                return GenSeqLike.prefixLength$(this, p);
            }

            public int indexWhere(Function1<A, Object> p) {
                return GenSeqLike.indexWhere$(this, p);
            }

            public <B> int indexOf(B elem) {
                return GenSeqLike.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return GenSeqLike.indexOf$(this, elem, from);
            }

            public <B> int lastIndexOf(B elem) {
                return GenSeqLike.lastIndexOf$(this, elem);
            }

            public <B> int lastIndexOf(B elem, int end) {
                return GenSeqLike.lastIndexOf$(this, elem, end);
            }

            public int lastIndexWhere(Function1<A, Object> p) {
                return GenSeqLike.lastIndexWhere$(this, p);
            }

            public <B> boolean startsWith(GenSeq<B> that) {
                return GenSeqLike.startsWith$(this, that);
            }

            public int hashCode() {
                return GenSeqLike.hashCode$(this);
            }

            public boolean equals(Object that) {
                return GenSeqLike.equals$(this, that);
            }

            public boolean forall(Function1<A, Object> p) {
                return IterableLike.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return IterableLike.exists$(this, p);
            }

            public Option<A> find(Function1<A, Object> p) {
                return IterableLike.find$(this, p);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)IterableLike.foldRight$(this, z, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)IterableLike.reduceRight$(this, op);
            }

            public Iterable<A> toIterable() {
                return IterableLike.toIterable$(this);
            }

            public Iterator<A> toIterator() {
                return IterableLike.toIterator$(this);
            }

            public A head() {
                return (A)IterableLike.head$(this);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                IterableLike.copyToArray$(this, xs, start, len);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableLike.sameElements$(this, that);
            }

            public Stream<A> toStream() {
                return IterableLike.toStream$(this);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public <B> Builder<B, Seq<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public Object repr() {
                return TraversableLike.repr$(this);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableLike.hasDefiniteSize$(this);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<StreamView<A, Coll>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Traversable<A> toTraversable() {
                return TraversableLike.toTraversable$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<A, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableOnce.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableOnce.max$(this, cmp);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public List<A> toList() {
                return TraversableOnce.toList$(this);
            }

            public IndexedSeq<A> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return PartialFunction.orElse$(this, that);
            }

            public <C> PartialFunction<Object, C> andThen(Function1<A, C> k) {
                return PartialFunction.andThen$(this, k);
            }

            public Function1<Object, Option<A>> lift() {
                return PartialFunction.lift$(this);
            }

            public Object applyOrElse(Object x, Function1 function1) {
                return PartialFunction.applyOrElse$(this, x, function1);
            }

            public <U> Function1<Object, Object> runWith(Function1<A, U> action) {
                return PartialFunction.runWith$(this, action);
            }

            public boolean apply$mcZD$sp(double v1) {
                return Function1.apply$mcZD$sp$(this, v1);
            }

            public double apply$mcDD$sp(double v1) {
                return Function1.apply$mcDD$sp$(this, v1);
            }

            public float apply$mcFD$sp(double v1) {
                return Function1.apply$mcFD$sp$(this, v1);
            }

            public int apply$mcID$sp(double v1) {
                return Function1.apply$mcID$sp$(this, v1);
            }

            public long apply$mcJD$sp(double v1) {
                return Function1.apply$mcJD$sp$(this, v1);
            }

            public void apply$mcVD$sp(double v1) {
                Function1.apply$mcVD$sp$(this, v1);
            }

            public boolean apply$mcZF$sp(float v1) {
                return Function1.apply$mcZF$sp$(this, v1);
            }

            public double apply$mcDF$sp(float v1) {
                return Function1.apply$mcDF$sp$(this, v1);
            }

            public float apply$mcFF$sp(float v1) {
                return Function1.apply$mcFF$sp$(this, v1);
            }

            public int apply$mcIF$sp(float v1) {
                return Function1.apply$mcIF$sp$(this, v1);
            }

            public long apply$mcJF$sp(float v1) {
                return Function1.apply$mcJF$sp$(this, v1);
            }

            public void apply$mcVF$sp(float v1) {
                Function1.apply$mcVF$sp$(this, v1);
            }

            public boolean apply$mcZI$sp(int v1) {
                return Function1.apply$mcZI$sp$(this, v1);
            }

            public double apply$mcDI$sp(int v1) {
                return Function1.apply$mcDI$sp$(this, v1);
            }

            public float apply$mcFI$sp(int v1) {
                return Function1.apply$mcFI$sp$(this, v1);
            }

            public int apply$mcII$sp(int v1) {
                return Function1.apply$mcII$sp$(this, v1);
            }

            public long apply$mcJI$sp(int v1) {
                return Function1.apply$mcJI$sp$(this, v1);
            }

            public void apply$mcVI$sp(int v1) {
                Function1.apply$mcVI$sp$(this, v1);
            }

            public boolean apply$mcZJ$sp(long v1) {
                return Function1.apply$mcZJ$sp$(this, v1);
            }

            public double apply$mcDJ$sp(long v1) {
                return Function1.apply$mcDJ$sp$(this, v1);
            }

            public float apply$mcFJ$sp(long v1) {
                return Function1.apply$mcFJ$sp$(this, v1);
            }

            public int apply$mcIJ$sp(long v1) {
                return Function1.apply$mcIJ$sp$(this, v1);
            }

            public long apply$mcJJ$sp(long v1) {
                return Function1.apply$mcJJ$sp$(this, v1);
            }

            public void apply$mcVJ$sp(long v1) {
                Function1.apply$mcVJ$sp$(this, v1);
            }

            public <A> Function1<A, A> compose(Function1<A, Object> g) {
                return Function1.compose$(this, g);
            }

            private Coll underlying$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.underlying = TraversableViewLike.Transformed.underlying$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.underlying;
            }

            public Coll underlying() {
                if (!this.bitmap$0) {
                    return this.underlying$lzycompute();
                }
                return this.underlying;
            }

            public /* synthetic */ StreamViewLike scala$collection$immutable$StreamViewLike$Transformed$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Reversed$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Transformed$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Transformed$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Transformed$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                PartialFunction.$init$(this);
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Parallelizable.$init$(this);
                TraversableLike.$init$(this);
                GenericTraversableTemplate.$init$(this);
                GenTraversable.$init$(this);
                Traversable.$init$(this);
                GenIterable.$init$(this);
                IterableLike.$init$(this);
                Iterable.$init$(this);
                GenSeqLike.$init$(this);
                GenSeq.$init$(this);
                SeqLike.$init$(this);
                Seq.$init$(this);
                ViewMkString.$init$(this);
                TraversableViewLike.$init$(this);
                IterableViewLike.$init$(this);
                SeqViewLike.$init$(this);
                TraversableViewLike.Transformed.$init$(this);
                IterableViewLike.Transformed.$init$(this);
                SeqViewLike.Transformed.$init$(this);
                SeqViewLike.Reversed.$init$(this);
                StreamViewLike.$init$(this);
                Transformed.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableViewLike scala.collection.Seq ), $anonfun$sortBy$1(scala.collection.SeqViewLike scala.Function1 scala.math.Ordering ), $anonfun$sortWith$1(scala.collection.SeqViewLike scala.Function2 )}, serializedLambda);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
        return new Patched<B>(this, _from, _patch, _replaced){
            private final int from;
            private final GenSeq<B> patch;
            private final int replaced;
            private int scala$collection$SeqViewLike$Patched$$plen;
            private volatile boolean bitmap$0;
            private final /* synthetic */ StreamViewLike $outer;

            public Iterator<B> iterator() {
                return SeqViewLike.Patched.iterator$(this);
            }

            public int length() {
                return SeqViewLike.Patched.length$(this);
            }

            public B apply(int idx) {
                return (B)SeqViewLike.Patched.apply$(this, idx);
            }

            public final String viewIdentifier() {
                return SeqViewLike.Patched.viewIdentifier$(this);
            }

            private int scala$collection$SeqViewLike$Patched$$plen$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.scala$collection$SeqViewLike$Patched$$plen = SeqViewLike.Patched.scala$collection$SeqViewLike$Patched$$plen$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.scala$collection$SeqViewLike$Patched$$plen;
            }

            public int scala$collection$SeqViewLike$Patched$$plen() {
                if (!this.bitmap$0) {
                    return this.scala$collection$SeqViewLike$Patched$$plen$lzycompute();
                }
                return this.scala$collection$SeqViewLike$Patched$$plen;
            }

            public int from() {
                return this.from;
            }

            public GenSeq<B> patch() {
                return this.patch;
            }

            public int replaced() {
                return this.replaced;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Patched$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.from = _from$1;
                this.patch = _patch$1;
                this.replaced = _replaced$1;
                super($outer);
                SeqViewLike.Patched.$init$(this);
            }
        };
    }

    @Override
    default public String stringPrefix() {
        return "StreamView";
    }

    public static void $init$(StreamViewLike $this) {
    }

    public abstract class AbstractTransformed<B>
    extends SeqViewLike.AbstractTransformed<B>
    implements Transformed<B> {
        @Override
        public String toString() {
            return ((Transformed)this).toString();
        }

        @Override
        public <B, That> That force(CanBuildFrom<Coll, B, That> bf) {
            return (That)((StreamViewLike)this).force(bf);
        }

        @Override
        public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
            return ((StreamViewLike)this).newForced(xs);
        }

        @Override
        public <B> Transformed<B> newAppended(GenTraversable<B> that) {
            return ((StreamViewLike)this).newAppended(that);
        }

        @Override
        public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
            return ((StreamViewLike)this).newPrepended(that);
        }

        @Override
        public <B> Transformed<B> newMapped(Function1<B, B> f) {
            return ((StreamViewLike)this).newMapped(f);
        }

        @Override
        public <B> Transformed<B> newFlatMapped(Function1<B, GenTraversableOnce<B>> f) {
            return ((StreamViewLike)this).newFlatMapped(f);
        }

        @Override
        public Transformed<B> newFiltered(Function1<B, Object> p) {
            return ((StreamViewLike)this).newFiltered(p);
        }

        @Override
        public Transformed<B> newSliced(SliceInterval _endpoints) {
            return ((StreamViewLike)this).newSliced(_endpoints);
        }

        @Override
        public Transformed<B> newDroppedWhile(Function1<B, Object> p) {
            return ((StreamViewLike)this).newDroppedWhile(p);
        }

        @Override
        public Transformed<B> newTakenWhile(Function1<B, Object> p) {
            return ((StreamViewLike)this).newTakenWhile(p);
        }

        @Override
        public <B> Transformed<Tuple2<B, B>> newZipped(GenIterable<B> that) {
            return ((StreamViewLike)this).newZipped(that);
        }

        @Override
        public <A1, B> Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
            return ((StreamViewLike)this).newZippedAll(that, _thisElem, _thatElem);
        }

        @Override
        public Transformed<B> newReversed() {
            return ((StreamViewLike)this).newReversed();
        }

        @Override
        public <B> Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
            return ((StreamViewLike)this).newPatched(_from, _patch, _replaced);
        }

        @Override
        public String stringPrefix() {
            return ((StreamViewLike)this).stringPrefix();
        }

        public /* synthetic */ StreamViewLike scala$collection$immutable$StreamViewLike$AbstractTransformed$$$outer() {
            return (StreamViewLike)this.$outer;
        }

        @Override
        public /* synthetic */ StreamViewLike scala$collection$immutable$StreamViewLike$Transformed$$$outer() {
            return this.scala$collection$immutable$StreamViewLike$AbstractTransformed$$$outer();
        }

        public AbstractTransformed(StreamViewLike $outer) {
            StreamViewLike.$init$(this);
            Transformed.$init$(this);
        }
    }

    public interface Appended<B>
    extends SeqViewLike.Appended<B>,
    Transformed<B> {
    }

    public interface DroppedWhile
    extends SeqViewLike.DroppedWhile,
    Transformed<A> {
    }

    public interface EmptyView
    extends Transformed<Nothing$>,
    SeqViewLike.EmptyView {
    }

    public interface Filtered
    extends SeqViewLike.Filtered,
    Transformed<A> {
    }

    public interface FlatMapped<B>
    extends SeqViewLike.FlatMapped<B>,
    Transformed<B> {
    }

    public interface Forced<B>
    extends SeqViewLike.Forced<B>,
    Transformed<B> {
    }

    public interface Mapped<B>
    extends SeqViewLike.Mapped<B>,
    Transformed<B> {
    }

    public interface Patched<B>
    extends SeqViewLike.Patched<B>,
    Transformed<B> {
    }

    public interface Prepended<B>
    extends SeqViewLike.Prepended<B>,
    Transformed<B> {
    }

    public interface Reversed
    extends SeqViewLike.Reversed,
    Transformed<A> {
    }

    public interface Sliced
    extends SeqViewLike.Sliced,
    Transformed<A> {
    }

    public interface TakenWhile
    extends SeqViewLike.TakenWhile,
    Transformed<A> {
    }

    public interface Transformed<B>
    extends StreamView<B, Coll>,
    SeqViewLike.Transformed<B> {
        @Override
        default public String toString() {
            return this.viewToString();
        }

        public /* synthetic */ StreamViewLike scala$collection$immutable$StreamViewLike$Transformed$$$outer();

        public static void $init$(Transformed $this) {
        }
    }

    public interface Zipped<B>
    extends SeqViewLike.Zipped<B>,
    Transformed<Tuple2<A, B>> {
    }

    public interface ZippedAll<A1, B>
    extends SeqViewLike.ZippedAll<A1, B>,
    Transformed<Tuple2<A1, B>> {
    }
}

