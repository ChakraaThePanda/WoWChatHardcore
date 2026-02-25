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
import scala.collection.parallel.AugmentedSeqIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.PreciseSplitter;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.immutable.package$;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.ParArray$;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BooleanRef;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.java8.JFunction2$mcIII$sp;

@ScalaSignature(bytes="\u0006\u0001\tMfa\u0002 @!\u0003\r\tA\u0012\u0005\u0006C\u0002!\tA\u0019\u0005\u0006M\u00021\ta\u001a\u0005\u0006S\u00021\tA\u001b\u0005\u0006e\u00021\ta\u001d\u0005\u0006y\u0002!\tE\u001b\u0005\u0006{\u0002!\tA \u0005\b\u0003\u0003\u0001a\u0011AA\u0002\r\u0019\t)\u0001\u0001\u0001\u0002\b!I\u0011q\u0002\u0005\u0003\u0002\u0003\u0006I!\u001f\u0005\b\u0003#AA\u0011AA\n\u0011\u00151\u0007\u0002\"\u0011h\u0011\u0015I\u0007\u0002\"\u0011k\u0011\u0019\u0011\b\u0002\"\u0001\u0002\u001a!A\u0011Q\u0004\u0001\u0005B\u0005\u000by\u0002C\u0004\u0002&\u0001!\t%a\n\t\u000f\u00055\u0002\u0001\"\u0011\u00020\u00191\u0011\u0011\b\u0001\u0001\u0003wA!\"a\u0013\u0012\u0005\u0003\u0005\u000b\u0011BA'\u0011\u001d\t\t\"\u0005C\u0001\u0003'BaAZ\t\u0005B\u0005e\u0003BB5\u0012\t\u0003\nY\u0006\u0003\u0004s#\u0011\u0005\u0011q\f\u0005\b\u0003G\u0002A\u0011IA3\r\u0019\t\u0019\b\u0001\u0001\u0002v!a\u0011q\u0012\r\u0003\u0002\u0003\u0006I!!\"\u0002\u0012\"9\u0011\u0011\u0003\r\u0005\u0002\u0005U\u0005B\u00024\u0019\t\u0003\nY\n\u0003\u0004j1\u0011\u0005\u0013Q\u0014\u0005\u0007eb!\t!!)\t\u000f\u0005\u0015\u0006\u0001\"\u0001\u0002(\u001a1\u00111\u0018\u0001\u0001\u0003{CA\"!5 \u0005\u0003\u0005\u000b\u0011BAj\u0003+Dq!!\u0005 \t\u0003\t9\u000e\u0003\u0004g?\u0011\u0005\u0013Q\u001c\u0005\u0007S~!\t%a8\t\rI|B\u0011AAr\u0011\u001d\tI\u000f\u0001C!\u0003W4a!!?\u0001\u0001\u0005m\b\u0002DAiM\t\u0005\t\u0015!\u0003\u0003\u0010\tE\u0001\u0002\u0004B\nM\t\u0005\t\u0015!\u0003\u0003\u0004\tU\u0001\u0002\u0004B\rM\t\u0005\t\u0015!\u0003\u0003\b\tm\u0001bBA\tM\u0011\u0005!q\u0004\u0005\u0007M\u001a\"\tE!\u000b\t\u000f\t-b\u0005\"\u0003\u0003.!1\u0011N\nC!\u0005gAaA\u001d\u0014\u0005\u0002\t]\u0002b\u0002B\u001e\u0001\u0011\u0005#Q\b\u0005\u0007\u0005?\u0002A\u0011A4\u0007\r\t\u0005\u0004\u0001\u0001B2\u0011%\u0011i'\rB\u0001B\u0003%\u0011\u0010\u0003\u0006\u0003pE\u0012\t\u0011)A\u0005\u0005OB\u0011B!\u001d2\u0005\u0003\u0005\u000b\u0011B=\t\u000f\u0005E\u0011\u0007\"\u0001\u0003t!A!QP\u0019!\u0002\u0013\u0011y\bC\u0004\u0003\u0004F\"\tA!\"\t\u000f\t5\u0015\u0007\"\u0001\u0003\u0010\"9\u0011\u0011A\u0019\u0005\u0002\u0005\r\u0001B\u000242\t\u0003\u0011\t\n\u0003\u0004jc\u0011\u0005!Q\u0013\u0005\u0007eF\"\tA!'\t\u000f\tu\u0005\u0001\"\u0001\u0003 \nY1+Z9Ta2LG\u000f^3s\u0015\t\u0001\u0015)\u0001\u0005qCJ\fG\u000e\\3m\u0015\t\u00115)\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001R\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t9%kE\u0003\u0001\u00112[f\f\u0005\u0002J\u00156\t1)\u0003\u0002L\u0007\n1\u0011I\\=SK\u001a\u00042!\u0014(Q\u001b\u0005y\u0014BA(@\u0005AIE/\u001a:bE2,7\u000b\u001d7jiR,'\u000f\u0005\u0002R%2\u0001AAB*\u0001\t\u000b\u0007AKA\u0001U#\t)\u0006\f\u0005\u0002J-&\u0011qk\u0011\u0002\b\u001d>$\b.\u001b8h!\tI\u0015,\u0003\u0002[\u0007\n\u0019\u0011I\\=\u0011\u00075c\u0006+\u0003\u0002^\u007f\t!\u0012)^4nK:$X\rZ*fc&#XM]1u_J\u00042!T0Q\u0013\t\u0001wHA\bQe\u0016\u001c\u0017n]3Ta2LG\u000f^3s\u0003\u0019!\u0013N\\5uIQ\t1\r\u0005\u0002JI&\u0011Qm\u0011\u0002\u0005+:LG/A\u0002ekB,\u0012\u0001\u001b\t\u0004\u001b\u0002\u0001\u0016!B:qY&$X#A6\u0011\u00071|\u0007N\u0004\u0002J[&\u0011anQ\u0001\ba\u0006\u001c7.Y4f\u0013\t\u0001\u0018OA\u0002TKFT!A\\\"\u0002\rA\u001c\b\u000f\\5u)\tYG\u000fC\u0003v\t\u0001\u0007a/A\u0003tSj,7\u000fE\u0002JofL!\u0001_\"\u0003\u0015q\u0012X\r]3bi\u0016$g\b\u0005\u0002Ju&\u00111p\u0011\u0002\u0004\u0013:$\u0018aE:qY&$x+\u001b;i'&<g.\u00197mS:<\u0017\u0001\u00069ta2LGoV5uQNKwM\\1mY&tw\r\u0006\u0002l\u007f\")QO\u0002a\u0001m\u0006I!/Z7bS:LgnZ\u000b\u0002s\n)A+Y6f]N!\u0001\"!\u0003i!\u0011\tY!!\u0004\u000e\u0003\u0001I1!!\u0002O\u0003\t!8.\u0001\u0004=S:LGO\u0010\u000b\u0005\u0003+\t9\u0002E\u0002\u0002\f!Aa!a\u0004\u000b\u0001\u0004IHcA6\u0002\u001c!)Q/\u0004a\u0001m\u0006Aa.Z<UC.,g\u000e\u0006\u0003\u0002\u0016\u0005\u0005\u0002BBA\u0012\u001d\u0001\u0007\u00110A\u0003v]RLG.\u0001\u0003uC.,Gc\u00015\u0002*!1\u00111F\bA\u0002e\f\u0011A\\\u0001\u0006g2L7-\u001a\u000b\u0006Q\u0006E\u0012Q\u0007\u0005\u0007\u0003g\u0001\u0002\u0019A=\u0002\u000b\u0019\u0014x.\\\u0019\t\r\u0005]\u0002\u00031\u0001z\u0003\u0019)h\u000e^5mc\t1Q*\u00199qK\u0012,B!!\u0010\u0002FM)\u0011#a\u0010\u0002JA1\u00111BA!\u0003\u0007J1!!\u000fO!\r\t\u0016Q\t\u0003\u0007\u0003\u000f\n\"\u0019\u0001+\u0003\u0003M\u0003B!\u0014\u0001\u0002D\u0005\ta\r\u0005\u0004J\u0003\u001f\u0002\u00161I\u0005\u0004\u0003#\u001a%!\u0003$v]\u000e$\u0018n\u001c82)\u0011\t)&a\u0016\u0011\u000b\u0005-\u0011#a\u0011\t\u000f\u0005-3\u00031\u0001\u0002NU\u0011\u0011\u0011J\u000b\u0003\u0003;\u0002B\u0001\\8\u0002JQ!\u0011QLA1\u0011\u0015)h\u00031\u0001w\u0003\ri\u0017\r]\u000b\u0005\u0003O\ni\u0007\u0006\u0003\u0002j\u0005=\u0004#BA\u0006#\u0005-\u0004cA)\u0002n\u00111\u0011qI\fC\u0002QCq!a\u0013\u0018\u0001\u0004\t\t\b\u0005\u0004J\u0003\u001f\u0002\u00161\u000e\u0002\t\u0003B\u0004XM\u001c3fIV1\u0011qOA@\u0003\u000f\u001bR\u0001GA=\u0003\u001b\u0003\u0002\"a\u0003\u0002|\u0005u\u0014QQ\u0005\u0004\u0003gr\u0005cA)\u0002\u0000\u00119\u0011\u0011\u0011\rC\u0002\u0005\r%!A+\u0012\u0005AC\u0006cA)\u0002\b\u00129\u0011\u0011\u0012\rC\u0002\u0005-%A\u0001)J#\r)\u0016Q\u0012\t\u0005\u001b\u0002\ti(\u0001\u0002ji&!\u00111SA>\u0003\u0011!\b.\u0019;\u0015\t\u0005]\u0015\u0011\u0014\t\b\u0003\u0017A\u0012QPAC\u0011\u001d\tyI\u0007a\u0001\u0003\u000b+\"!!$\u0016\u0005\u0005}\u0005\u0003\u00027p\u0003\u001b#B!a(\u0002$\")Q/\ba\u0001m\u0006a\u0011\r\u001d9f]\u0012\u0004\u0016M]*fcV1\u0011\u0011VAX\u0003g#B!a+\u0002:B9\u00111\u0002\r\u0002.\u0006E\u0006cA)\u00020\u00129\u0011\u0011\u0011\u0010C\u0002\u0005\r\u0005cA)\u00024\u00129\u0011\u0011\u0012\u0010C\u0002\u0005U\u0016cA+\u00028B!Q\nAAW\u0011\u001d\t\u0019J\ba\u0001\u0003c\u0013aAW5qa\u0016$W\u0003BA`\u0003\u000f\u001cRaHAa\u0003\u0013\u0004b!a\u0003\u0002D\u0006\u0015\u0017bAA^\u001dB\u0019\u0011+a2\u0005\r\u0005\u001dsD1\u0001U!\u0011i\u0005!a3\u0011\r%\u000bi\rUAc\u0013\r\tym\u0011\u0002\u0007)V\u0004H.\u001a\u001a\u0002\u0005QL\u0007\u0003B'\u0001\u0003\u000bLA!a%\u0002DR!\u0011\u0011\\An!\u0015\tYaHAc\u0011\u001d\t\t.\ta\u0001\u0003',\"!!3\u0016\u0005\u0005\u0005\b\u0003\u00027p\u0003\u0013$B!!9\u0002f\"1\u0011q\u001d\u0013A\u0002Y\f1a\u001d>t\u0003%Q\u0018\u000e\u001d)beN+\u0017/\u0006\u0003\u0002n\u0006MH\u0003BAx\u0003k\u0004R!a\u0003 \u0003c\u00042!UAz\t\u0019\t9%\nb\u0001)\"9\u00111S\u0013A\u0002\u0005]\b\u0003B'\u0001\u0003c\u0014\u0011BW5qa\u0016$\u0017\t\u001c7\u0016\r\u0005u(Q\u0001B\u0005'\u00151\u0013q B\u0006!!\tYA!\u0001\u0003\u0004\t\u001d\u0011bAA}\u001dB\u0019\u0011K!\u0002\u0005\u000f\u0005\u0005eE1\u0001\u0002\u0004B\u0019\u0011K!\u0003\u0005\r\u0005\u001dcE1\u0001U!\u0011i\u0005A!\u0004\u0011\u000f%\u000biMa\u0001\u0003\bA!Q\n\u0001B\u0004\u0013\u0011\t\u0019J!\u0001\u0002\u000bQD\u0017n]3\n\t\t]!\u0011A\u0001\ti\"L7/\u001a7f[\u0006)A\u000f[1uK&!!Q\u0004B\u0001\u0003!!\b.\u0019;fY\u0016lG\u0003\u0003B\u0011\u0005G\u0011)Ca\n\u0011\u000f\u0005-aEa\u0001\u0003\b!9\u0011\u0011\u001b\u0016A\u0002\t=\u0001b\u0002B\nU\u0001\u0007!1\u0001\u0005\b\u00053Q\u0003\u0019\u0001B\u0004+\t\u0011Y!A\u0004qCR\u001c\u0007.Z7\u0016\u0005\t=\u0002cB%\u0002N\nE\"q\u0002\t\u0005\u001b\u0002\u0011\u0019!\u0006\u0002\u00036A!An\u001cB\u0006)\u0011\u0011)D!\u000f\t\u000bUt\u0003\u0019\u0001<\u0002\u0019iL\u0007/\u00117m!\u0006\u00148+Z9\u0016\u0011\t}\"\u0011\u000bB#\u0005\u0013\"\u0002B!\u0011\u0003T\t]#1\f\t\b\u0003\u00171#1\tB$!\r\t&Q\t\u0003\b\u0003\u0003{#\u0019AAB!\r\t&\u0011\n\u0003\b\u0005\u0017z#\u0019\u0001B'\u0005\u0005\u0011\u0016c\u0001B(1B\u0019\u0011K!\u0015\u0005\r\u0005\u001dsF1\u0001U\u0011\u001d\t\u0019j\fa\u0001\u0005+\u0002B!\u0014\u0001\u0003P!9!\u0011L\u0018A\u0002\t\r\u0013\u0001\u0003;iSN,E.Z7\t\u000f\tus\u00061\u0001\u0003H\u0005AA\u000f[1u\u000b2,W.A\u0004sKZ,'o]3\u0003\u000fA\u000bGo\u00195fIV!!Q\rB6'\u0011\t\u0004Ja\u001a\u0011\t5\u0003!\u0011\u000e\t\u0004#\n-DaBAAc\t\u0007\u00111Q\u0001\u0005MJ|W.A\u0003qCR\u001c\u0007.\u0001\u0005sKBd\u0017mY3e)!\u0011)Ha\u001e\u0003z\tm\u0004#BA\u0006c\t%\u0004B\u0002B7k\u0001\u0007\u0011\u0010C\u0004\u0003pU\u0002\rAa\u001a\t\r\tET\u00071\u0001z\u0003\u0011!(/[8\u0011\r\t\u0005\u0005D!\u001bi!\u0019A\u0007D!\u001b\u0003h\u00059\u0001.Y:OKb$XC\u0001BD!\rI%\u0011R\u0005\u0004\u0005\u0017\u001b%a\u0002\"p_2,\u0017M\\\u0001\u0005]\u0016DH\u000f\u0006\u0002\u0003jU\u0011!1\u0013\t\u0005QF\u0012I'\u0006\u0002\u0003\u0018B!An\u001cB4)\u0011\u00119Ja'\t\u000bUd\u0004\u0019\u0001<\u0002\u0017A\fGo\u00195QCJ\u001cV-]\u000b\u0005\u0005C\u00139\u000b\u0006\u0005\u0003$\n%&1\u0016BY!\u0015\tY!\rBS!\r\t&q\u0015\u0003\b\u0003\u0003k$\u0019AAB\u0011\u0019\u0011i'\u0010a\u0001s\"9!QV\u001fA\u0002\t=\u0016A\u00039bi\u000eDW\t\\3ngB!Q\n\u0001BS\u0011\u0019\u0011\t(\u0010a\u0001s\u0002")
public interface SeqSplitter<T>
extends IterableSplitter<T>,
AugmentedSeqIterator<T>,
PreciseSplitter<T> {
    @Override
    public SeqSplitter<T> dup();

    @Override
    public Seq<SeqSplitter<T>> split();

    @Override
    public Seq<SeqSplitter<T>> psplit(Seq<Object> var1);

    /*
     * WARNING - void declaration
     */
    @Override
    default public Seq<SeqSplitter<T>> splitWithSignalling() {
        void var1_1;
        Seq<SeqSplitter<T>> pits = this.split();
        pits.foreach((Function1<SeqSplitter, Object> & java.io.Serializable & Serializable)x$9 -> {
            ((SeqSplitter)x$9).signalDelegate_$eq(this.signalDelegate());
            return BoxedUnit.UNIT;
        });
        return var1_1;
    }

    /*
     * WARNING - void declaration
     */
    default public Seq<SeqSplitter<T>> psplitWithSignalling(Seq<Object> sizes) {
        void var2_2;
        Seq<SeqSplitter<T>> pits = this.psplit(sizes);
        pits.foreach((Function1<SeqSplitter, Object> & java.io.Serializable & Serializable)x$10 -> {
            ((SeqSplitter)x$10).signalDelegate_$eq(this.signalDelegate());
            return BoxedUnit.UNIT;
        });
        return var2_2;
    }

    @Override
    public int remaining();

    @Override
    default public Taken newTaken(int until) {
        return new Taken(this, until);
    }

    @Override
    default public SeqSplitter<T> take(int n) {
        return this.newTaken(n);
    }

    @Override
    default public SeqSplitter<T> slice(int from1, int until1) {
        return this.newSliceInternal(this.newTaken(until1), from1);
    }

    @Override
    default public <S> Mapped<S> map(Function1<T, S> f) {
        return new Mapped<S>(this, f);
    }

    default public <U, PI extends SeqSplitter<U>> Appended<U, PI> appendParSeq(PI that) {
        return new Appended(this, that);
    }

    @Override
    default public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
        return new Zipped<S>(this, that);
    }

    @Override
    default public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
        return new ZippedAll<U, S>(this, that, thisElem, thatElem);
    }

    default public SeqSplitter<T> reverse() {
        ParArray pa = (ParArray)ParArray$.MODULE$.fromTraversables(Predef$.MODULE$.genericWrapArray(new GenTraversableOnce[]{this})).reverse();
        return new ParArray.ParArrayIterator(this, pa){
            private final /* synthetic */ SeqSplitter $outer;

            public SeqSplitter<T> reverse() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super(pa$1, pa$1.ParArrayIterator().$lessinit$greater$default$1(), pa$1.ParArrayIterator().$lessinit$greater$default$2(), pa$1.ParArrayIterator().$lessinit$greater$default$3());
            }
        };
    }

    default public <U> Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
        return new Patched<U>(this, from, patchElems, replaced);
    }

    public static void $init$(SeqSplitter $this) {
    }

    public class Appended<U, PI extends SeqSplitter<U>>
    extends IterableSplitter.Appended<U, PI>
    implements SeqSplitter<U> {
        @Override
        public Seq<SeqSplitter<U>> splitWithSignalling() {
            return ((SeqSplitter)this).splitWithSignalling();
        }

        @Override
        public Seq<SeqSplitter<U>> psplitWithSignalling(Seq<Object> sizes) {
            return ((SeqSplitter)this).psplitWithSignalling(sizes);
        }

        @Override
        public Taken newTaken(int until) {
            return ((SeqSplitter)this).newTaken(until);
        }

        @Override
        public SeqSplitter<U> take(int n) {
            return ((SeqSplitter)this).take(n);
        }

        @Override
        public SeqSplitter<U> slice(int from1, int until1) {
            return ((SeqSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<U, S> f) {
            return ((SeqSplitter)this).map(f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> Appended<U, PI> appendParSeq(PI that) {
            return ((SeqSplitter)this).appendParSeq((SeqSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((SeqSplitter)this).zipParSeq((SeqSplitter)that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((SeqSplitter)this).zipAllParSeq((SeqSplitter)that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<U> reverse() {
            return ((SeqSplitter)this).reverse();
        }

        @Override
        public <U> Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return ((SeqSplitter)this).patchParSeq(from, (SeqSplitter)patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<U, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<U, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<U, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<U, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<U, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public SeqSplitter<U> dup() {
            return (SeqSplitter)super.dup();
        }

        @Override
        public Seq<SeqSplitter<U>> split() {
            return super.split();
        }

        @Override
        public Seq<SeqSplitter<U>> psplit(Seq<Object> sizes) {
            if (this.firstNonEmpty()) {
                int selfrem = this.scala$collection$parallel$SeqSplitter$Appended$$$outer().remaining();
                BooleanRef appendMiddle = BooleanRef.create(false);
                Seq szcum = sizes.scanLeft(BoxesRunTime.boxToInteger(0), (JFunction2$mcIII$sp & Serializable)(x$12, x$13) -> x$12 + x$13, Seq$.MODULE$.canBuildFrom());
                Tuple2 tuple2 = ((TraversableLike)((TraversableLike)sizes.zip(((IterableLike)szcum.init()).zip((GenIterable)szcum.tail(), Seq$.MODULE$.canBuildFrom()), Seq$.MODULE$.canBuildFrom())).flatMap((Function1<Tuple2, Seq> & java.io.Serializable & Serializable)t -> {
                    Tuple2 tuple2;
                    int n;
                    block5: {
                        block4: {
                            if (t == null) break block4;
                            n = t._1$mcI$sp();
                            tuple2 = (Tuple2)t._2();
                            if (tuple2 != null) break block5;
                        }
                        throw new MatchError(t);
                    }
                    int n2 = tuple2._1$mcI$sp();
                    int n3 = tuple2._2$mcI$sp();
                    if (n2 < selfrem && n3 > selfrem) {
                        appendMiddle$1.elem = true;
                        return (Seq)Seq$.MODULE$.apply(Predef$.MODULE$.wrapIntArray(new int[]{selfrem - n2, n3 - selfrem}));
                    }
                    return (Seq)Seq$.MODULE$.apply(Predef$.MODULE$.wrapIntArray(new int[]{n}));
                }, Seq$.MODULE$.canBuildFrom()).zip((GenIterable)szcum.init(), Seq$.MODULE$.canBuildFrom())).span((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x$15) -> BoxesRunTime.boxToBoolean(Appended.$anonfun$psplit$5(selfrem, x$15)));
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                Seq seq = (Seq)tuple2._1();
                Seq seq2 = (Seq)tuple2._2();
                Seq selfszfrom = seq;
                Seq thatszfrom = seq2;
                Seq<Object> seq3 = thatszfrom.map((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$18 -> BoxesRunTime.boxToInteger(x$18._1$mcI$sp()), Seq$.MODULE$.canBuildFrom());
                Seq<Object> seq4 = selfszfrom.map((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$17 -> BoxesRunTime.boxToInteger(x$17._1$mcI$sp()), Seq$.MODULE$.canBuildFrom());
                Seq<Object> seq5 = seq3;
                Seq<Object> selfsizes = seq4;
                Seq<Object> thatsizes = seq5;
                Seq selfs = this.scala$collection$parallel$SeqSplitter$Appended$$$outer().psplit(selfsizes);
                Seq thats = ((SeqSplitter)this.that()).psplit(thatsizes);
                if (appendMiddle.elem) {
                    return ((TraversableLike)((TraversableLike)selfs.init()).$plus$plus(new $colon$colon<Nothing$>((Nothing$)((Object)((SeqSplitter)selfs.last()).appendParSeq((SeqSplitter)thats.head())), Nil$.MODULE$), Seq$.MODULE$.canBuildFrom())).$plus$plus((GenTraversableOnce)thats.tail(), Seq$.MODULE$.canBuildFrom());
                }
                return selfs.$plus$plus(thats, Seq$.MODULE$.canBuildFrom());
            }
            return ((SeqSplitter)this.curr()).psplit(sizes);
        }

        public /* synthetic */ SeqSplitter scala$collection$parallel$SeqSplitter$Appended$$$outer() {
            return (SeqSplitter)this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$psplit$5(int selfrem$1, Tuple2 x$15) {
            return x$15._2$mcI$sp() < selfrem$1;
        }

        public Appended(PI it) {
            super((IterableSplitter)$outer, it);
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
        }
    }

    public class Mapped<S>
    extends IterableSplitter.Mapped<S>
    implements SeqSplitter<S> {
        private final Function1<T, S> f;

        @Override
        public Seq<SeqSplitter<S>> splitWithSignalling() {
            return ((SeqSplitter)this).splitWithSignalling();
        }

        @Override
        public Seq<SeqSplitter<S>> psplitWithSignalling(Seq<Object> sizes) {
            return ((SeqSplitter)this).psplitWithSignalling(sizes);
        }

        @Override
        public Taken newTaken(int until) {
            return ((SeqSplitter)this).newTaken(until);
        }

        @Override
        public SeqSplitter<S> take(int n) {
            return ((SeqSplitter)this).take(n);
        }

        @Override
        public SeqSplitter<S> slice(int from1, int until1) {
            return ((SeqSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<S, S> f) {
            return ((SeqSplitter)this).map(f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> Appended<U, PI> appendParSeq(PI that) {
            return ((SeqSplitter)this).appendParSeq((SeqSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((SeqSplitter)this).zipParSeq((SeqSplitter)that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((SeqSplitter)this).zipAllParSeq((SeqSplitter)that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<S> reverse() {
            return ((SeqSplitter)this).reverse();
        }

        @Override
        public <U> Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return ((SeqSplitter)this).patchParSeq(from, (SeqSplitter)patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<S, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<S, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<S, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<S, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<S, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public SeqSplitter<S> dup() {
            return (SeqSplitter)super.dup();
        }

        @Override
        public Seq<SeqSplitter<S>> split() {
            return super.split();
        }

        @Override
        public Seq<SeqSplitter<S>> psplit(Seq<Object> sizes) {
            return this.scala$collection$parallel$SeqSplitter$Mapped$$$outer().psplit(sizes).map((Function1<SeqSplitter, Mapped> & java.io.Serializable & Serializable)x$11 -> x$11.map($this.f), Seq$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ SeqSplitter scala$collection$parallel$SeqSplitter$Mapped$$$outer() {
            return (SeqSplitter)this.$outer;
        }

        public Mapped(SeqSplitter $outer, Function1<T, S> f) {
            this.f = f;
            super($outer, f);
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
        }
    }

    public class Patched<U>
    implements SeqSplitter<U> {
        private final int from;
        private final SeqSplitter<U> patch;
        private final int replaced;
        private final Appended<U, SeqSplitter<T>> trio;
        private Signalling signalDelegate;
        public final /* synthetic */ SeqSplitter $outer;

        @Override
        public Seq<SeqSplitter<U>> splitWithSignalling() {
            return ((SeqSplitter)this).splitWithSignalling();
        }

        @Override
        public Seq<SeqSplitter<U>> psplitWithSignalling(Seq<Object> sizes) {
            return ((SeqSplitter)this).psplitWithSignalling(sizes);
        }

        @Override
        public Taken newTaken(int until) {
            return ((SeqSplitter)this).newTaken(until);
        }

        @Override
        public SeqSplitter<U> take(int n) {
            return ((SeqSplitter)this).take(n);
        }

        @Override
        public SeqSplitter<U> slice(int from1, int until1) {
            return ((SeqSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<U, S> f) {
            return ((SeqSplitter)this).map(f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> Appended<U, PI> appendParSeq(PI that) {
            return ((SeqSplitter)this).appendParSeq((SeqSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((SeqSplitter)this).zipParSeq((SeqSplitter)that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((SeqSplitter)this).zipAllParSeq((SeqSplitter)that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<U> reverse() {
            return ((SeqSplitter)this).reverse();
        }

        @Override
        public <U> Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return ((SeqSplitter)this).patchParSeq(from, (SeqSplitter)patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<U, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<U, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<U, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<U, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<U, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return IterableSplitter.shouldSplitFurther$(this, coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return IterableSplitter.buildString$(this, closure);
        }

        @Override
        public String debugInformation() {
            return IterableSplitter.debugInformation$(this);
        }

        @Override
        public <U extends IterableSplitter.Taken> U newSliceInternal(U it, int from1) {
            return (U)IterableSplitter.newSliceInternal$(this, it, from1);
        }

        @Override
        public IterableSplitter<U> drop(int n) {
            return IterableSplitter.drop$(this, n);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> IterableSplitter.Appended<U, PI> appendParIterable(PI that) {
            return IterableSplitter.appendParIterable$(this, that);
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

        @Override
        public boolean hasNext() {
            return this.trio.hasNext();
        }

        @Override
        public U next() {
            return this.trio.next();
        }

        @Override
        public int remaining() {
            return this.trio.remaining();
        }

        @Override
        public Patched<U> dup() {
            return this.scala$collection$parallel$SeqSplitter$Patched$$$outer().dup().patchParSeq(this.from, this.patch, this.replaced);
        }

        @Override
        public Seq<SeqSplitter<U>> split() {
            return this.trio.split();
        }

        @Override
        public Seq<SeqSplitter<U>> psplit(Seq<Object> sizes) {
            return this.trio.psplit(sizes);
        }

        public /* synthetic */ SeqSplitter scala$collection$parallel$SeqSplitter$Patched$$$outer() {
            return this.$outer;
        }

        public Patched(SeqSplitter $outer, int from, SeqSplitter<U> patch, int replaced) {
            this.from = from;
            this.patch = patch;
            this.replaced = replaced;
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
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
            this.signalDelegate_$eq($outer.signalDelegate());
            Seq pits = $outer.psplit(Predef$.MODULE$.wrapIntArray(new int[]{from, replaced, $outer.remaining() - from - replaced}));
            this.trio = ((SeqSplitter)pits.apply(false)).appendParSeq(patch).appendParSeq((SeqSplitter)pits.apply(2));
        }
    }

    public class Taken
    extends IterableSplitter.Taken
    implements SeqSplitter<T> {
        @Override
        public Seq<SeqSplitter<T>> splitWithSignalling() {
            return ((SeqSplitter)this).splitWithSignalling();
        }

        @Override
        public Seq<SeqSplitter<T>> psplitWithSignalling(Seq<Object> sizes) {
            return ((SeqSplitter)this).psplitWithSignalling(sizes);
        }

        @Override
        public Taken newTaken(int until) {
            return ((SeqSplitter)this).newTaken(until);
        }

        @Override
        public SeqSplitter<T> take(int n) {
            return ((SeqSplitter)this).take(n);
        }

        @Override
        public SeqSplitter<T> slice(int from1, int until1) {
            return ((SeqSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<T, S> f) {
            return ((SeqSplitter)this).map(f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> Appended<U, PI> appendParSeq(PI that) {
            return ((SeqSplitter)this).appendParSeq((SeqSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((SeqSplitter)this).zipParSeq((SeqSplitter)that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((SeqSplitter)this).zipAllParSeq((SeqSplitter)that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<T> reverse() {
            return ((SeqSplitter)this).reverse();
        }

        @Override
        public <U> Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return ((SeqSplitter)this).patchParSeq(from, (SeqSplitter)patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<T, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<T, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<T, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<T, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<T, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public SeqSplitter<T> dup() {
            return (SeqSplitter)super.dup();
        }

        @Override
        public Seq<SeqSplitter<T>> split() {
            return super.split();
        }

        @Override
        public Seq<SeqSplitter<T>> psplit(Seq<Object> sizes) {
            return this.takeSeq(this.scala$collection$parallel$SeqSplitter$Taken$$$outer().psplit(sizes), (Function2<SeqSplitter, Object, SeqSplitter> & java.io.Serializable & Serializable)(p, n) -> p.take(BoxesRunTime.unboxToInt(n)));
        }

        public /* synthetic */ SeqSplitter scala$collection$parallel$SeqSplitter$Taken$$$outer() {
            return (SeqSplitter)this.$outer;
        }

        public Taken(SeqSplitter $outer, int tk) {
            super($outer, tk);
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
        }
    }

    public class Zipped<S>
    extends IterableSplitter.Zipped<S>
    implements SeqSplitter<Tuple2<T, S>> {
        @Override
        public Seq<SeqSplitter<Tuple2<T, S>>> splitWithSignalling() {
            return ((SeqSplitter)this).splitWithSignalling();
        }

        @Override
        public Seq<SeqSplitter<Tuple2<T, S>>> psplitWithSignalling(Seq<Object> sizes) {
            return ((SeqSplitter)this).psplitWithSignalling(sizes);
        }

        @Override
        public Taken newTaken(int until) {
            return ((SeqSplitter)this).newTaken(until);
        }

        @Override
        public SeqSplitter<Tuple2<T, S>> take(int n) {
            return ((SeqSplitter)this).take(n);
        }

        @Override
        public SeqSplitter<Tuple2<T, S>> slice(int from1, int until1) {
            return ((SeqSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<Tuple2<T, S>, S> f) {
            return ((SeqSplitter)this).map(f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> Appended<U, PI> appendParSeq(PI that) {
            return ((SeqSplitter)this).appendParSeq((SeqSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((SeqSplitter)this).zipParSeq((SeqSplitter)that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((SeqSplitter)this).zipAllParSeq((SeqSplitter)that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<Tuple2<T, S>> reverse() {
            return ((SeqSplitter)this).reverse();
        }

        @Override
        public <U> Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return ((SeqSplitter)this).patchParSeq(from, (SeqSplitter)patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<Tuple2<T, S>, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<Tuple2<T, S>, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<Tuple2<T, S>, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<Tuple2<T, S>, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<Tuple2<T, S>, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public SeqSplitter<Tuple2<T, S>> dup() {
            return (SeqSplitter)super.dup();
        }

        @Override
        public Seq<SeqSplitter<Tuple2<T, S>>> split() {
            return super.split();
        }

        @Override
        public Seq<SeqSplitter<Tuple2<T, S>>> psplit(Seq<Object> szs) {
            return ((TraversableLike)this.scala$collection$parallel$SeqSplitter$Zipped$$$outer().psplit(szs).zip(this.that().psplit(szs), Seq$.MODULE$.canBuildFrom())).map((Function1<Tuple2, Zipped> & java.io.Serializable & Serializable)p -> ((SeqSplitter)p._1()).zipParSeq((SeqSplitter)p._2()), Seq$.MODULE$.canBuildFrom());
        }

        public /* synthetic */ SeqSplitter scala$collection$parallel$SeqSplitter$Zipped$$$outer() {
            return (SeqSplitter)this.$outer;
        }

        public Zipped(SeqSplitter $outer, SeqSplitter<S> ti) {
            super($outer, ti);
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
        }
    }

    public class ZippedAll<U, S>
    extends IterableSplitter.ZippedAll<U, S>
    implements SeqSplitter<Tuple2<U, S>> {
        @Override
        public Seq<SeqSplitter<Tuple2<U, S>>> splitWithSignalling() {
            return ((SeqSplitter)this).splitWithSignalling();
        }

        @Override
        public Seq<SeqSplitter<Tuple2<U, S>>> psplitWithSignalling(Seq<Object> sizes) {
            return ((SeqSplitter)this).psplitWithSignalling(sizes);
        }

        @Override
        public Taken newTaken(int until) {
            return ((SeqSplitter)this).newTaken(until);
        }

        @Override
        public SeqSplitter<Tuple2<U, S>> take(int n) {
            return ((SeqSplitter)this).take(n);
        }

        @Override
        public SeqSplitter<Tuple2<U, S>> slice(int from1, int until1) {
            return ((SeqSplitter)this).slice(from1, until1);
        }

        @Override
        public <S> Mapped<S> map(Function1<Tuple2<U, S>, S> f) {
            return ((SeqSplitter)this).map(f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> Appended<U, PI> appendParSeq(PI that) {
            return ((SeqSplitter)this).appendParSeq((SeqSplitter)that);
        }

        @Override
        public <S> Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return ((SeqSplitter)this).zipParSeq((SeqSplitter)that);
        }

        @Override
        public <S, U, R> ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return ((SeqSplitter)this).zipAllParSeq((SeqSplitter)that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<Tuple2<U, S>> reverse() {
            return ((SeqSplitter)this).reverse();
        }

        @Override
        public <U> Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return ((SeqSplitter)this).patchParSeq(from, (SeqSplitter)patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<Tuple2<U, S>, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<Tuple2<U, S>, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<Tuple2<U, S>, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<Tuple2<U, S>, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<Tuple2<U, S>, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public SeqSplitter<Tuple2<U, S>> dup() {
            return (SeqSplitter)super.dup();
        }

        private Tuple2<SeqSplitter<U>, SeqSplitter<S>> patchem() {
            int thatrem;
            int selfrem = this.scala$collection$parallel$SeqSplitter$ZippedAll$$$outer().remaining();
            Appended thisit = selfrem < (thatrem = this.that().remaining()) ? this.scala$collection$parallel$SeqSplitter$ZippedAll$$$outer().appendParSeq(package$.MODULE$.repetition(this.thiselem(), thatrem - selfrem).splitter()) : this.scala$collection$parallel$SeqSplitter$ZippedAll$$$outer();
            SeqSplitter thatit = selfrem > thatrem ? this.that().appendParSeq(package$.MODULE$.repetition(this.thatelem(), selfrem - thatrem).splitter()) : this.that();
            return new Tuple2<SeqSplitter<U>, SeqSplitter<S>>(thisit, thatit);
        }

        @Override
        public Seq<SeqSplitter<Tuple2<U, S>>> split() {
            Tuple2<SeqSplitter<U>, SeqSplitter<S>> tuple2 = this.patchem();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            SeqSplitter<U> seqSplitter = tuple2._1();
            SeqSplitter<S> seqSplitter2 = tuple2._2();
            SeqSplitter<U> thisit = seqSplitter;
            SeqSplitter<S> thatit = seqSplitter2;
            return thisit.zipParSeq(thatit).split();
        }

        @Override
        public Seq<SeqSplitter<Tuple2<U, S>>> psplit(Seq<Object> sizes) {
            Tuple2<SeqSplitter<U>, SeqSplitter<S>> tuple2 = this.patchem();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            SeqSplitter<U> seqSplitter = tuple2._1();
            SeqSplitter<S> seqSplitter2 = tuple2._2();
            SeqSplitter<U> thisit = seqSplitter;
            SeqSplitter<S> thatit = seqSplitter2;
            return thisit.zipParSeq(thatit).psplit(sizes);
        }

        public /* synthetic */ SeqSplitter scala$collection$parallel$SeqSplitter$ZippedAll$$$outer() {
            return (SeqSplitter)this.$outer;
        }

        public ZippedAll(SeqSplitter $outer, SeqSplitter<S> ti, U thise, S thate) {
            super($outer, ti, thise, thate);
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
        }
    }
}

