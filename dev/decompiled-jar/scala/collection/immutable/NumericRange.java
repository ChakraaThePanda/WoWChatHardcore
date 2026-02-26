/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractSeq;
import scala.collection.GenSeqLike;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.NumericRange$;
import scala.collection.immutable.Seq;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Integral;
import scala.math.Numeric;
import scala.math.Numeric$BigDecimalIsFractional$;
import scala.math.Numeric$BigIntIsIntegral$;
import scala.math.Numeric$ByteIsIntegral$;
import scala.math.Numeric$CharIsIntegral$;
import scala.math.Numeric$DoubleAsIfIntegral$;
import scala.math.Numeric$FloatAsIfIntegral$;
import scala.math.Numeric$IntIsIntegral$;
import scala.math.Numeric$LongIsIntegral$;
import scala.math.Numeric$ShortIsIntegral$;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;

@ScalaSignature(bytes="\u0006\u0001\t]g!\u0002\u001e<\u0003\u0003\u0011\u0005\u0002C.\u0001\u0005\u000b\u0007I\u0011\u0001/\t\u0011u\u0003!\u0011!Q\u0001\n!C\u0001B\u0018\u0001\u0003\u0006\u0004%\t\u0001\u0018\u0005\t?\u0002\u0011\t\u0011)A\u0005\u0011\"A\u0001\r\u0001BC\u0002\u0013\u0005A\f\u0003\u0005b\u0001\t\u0005\t\u0015!\u0003I\u0011!\u0011\u0007A!b\u0001\n\u0003\u0019\u0007\u0002C4\u0001\u0005\u0003\u0005\u000b\u0011\u00023\t\u0011!\u0004!\u0011!Q\u0001\f%DQ\u0001\u001d\u0001\u0005\u0002ED\u0001\"\u001f\u0001\t\u0006\u0004%IA\u001f\u0005\u0006}\u0002!\tE\u001f\u0005\u0006\u007f\u0002!\te\u0019\u0005\n\u0003\u0003\u0001\u0001R1A\u0005BqCq!a\u0001\u0001\t\u0003\t)\u0001C\u0004\u0002\f\u00011\t!!\u0004\t\u000f\u0005U\u0001\u0001\"\u0011\u0002\u0018!9\u0011\u0011\u0007\u0001\u0005\n\u0005M\u0002bBA\u001d\u0001\u0011%\u00111\b\u0005\b\u0003\u0003\u0002A\u0011BA\"\u0011\u001d\u0011I\u0004\u0001C#\u0005wAqAa\u0010\u0001\t\u000b\u0012\t\u0005C\u0004\u0002F\u0002!\tA!\u0012\t\u000f\t-\u0003\u0001\"\u0011\u0003N!9!\u0011\r\u0001\u0005B\t\r\u0004\u0002\u0003B8\u0001\u0011\u00051H!\u001d\t\u000f\t-\u0005\u0001\"\u0001\u0003\u000e\"9!1\u0013\u0001\u0005B\tU\u0005b\u0002BQ\u0001\u0011\u0015#1\u0015\u0005\n\u0005g\u0003\u0001R1A\u0005BiDqA!.\u0001\t\u0003\u00129\fC\u0004\u0003>\u0002!\tEa0\b\u000f\u0005%3\b#\u0001\u0002L\u00191!h\u000fE\u0001\u0003\u001bBa\u0001\u001d\u0012\u0005\u0002\u0005U\u0003bBA,E\u0011\u0005\u0011\u0011\f\u0004\u0007\u0003_\u0012\u0003!!\u001d\t\u0015m+#\u0011!Q\u0001\n\u0005]\u0014\u0001\u0003\u0006_K\t\u0005\t\u0015!\u0003\u0002x\rA!\u0002Y\u0013\u0003\u0002\u0003\u0006I!a\u001e\u0006\u0011%AWE!A!\u0002\u0017\tY\b\u0003\u0004qK\u0011\u0005\u0011Q\u0010\u0005\b\u0003\u0017)C\u0011AAG\u0011\u001d\t)*\nC\u0001\u0003/3a!a'#\u0001\u0005u\u0005BC..\u0005\u0003\u0005\u000b\u0011BAR\u0003!Qa,\fB\u0001B\u0003%\u00111U\u0002\t\u0015\u0001l#\u0011!Q\u0001\n\u0005\rV\u0001C\u0005i[\t\u0005\t\u0015a\u0003\u0002(\"1\u0001/\fC\u0001\u0003SCq!a\u0003.\t\u0003\t9\fC\u0004\u0002@6\"\t!!1\t\u000f\u0005\u0015'\u0005\"\u0001\u0002H\"9\u0011q\u0018\u0012\u0005\u0002\u0005u\u0007BCAzE\t\u0007I\u0011A\u001f\u0002v\"A!\u0011\u0003\u0012!\u0002\u0013\t9\u0010C\u0005\u0003\"\t\n\t\u0011\"\u0003\u0003$\taa*^7fe&\u001c'+\u00198hK*\u0011A(P\u0001\nS6lW\u000f^1cY\u0016T!AP \u0002\u0015\r|G\u000e\\3di&|gNC\u0001A\u0003\u0015\u00198-\u00197b\u0007\u0001)\"a\u0011&\u0014\t\u0001!E\u000b\u0017\t\u0004\u000b\u001aCU\"A\u001f\n\u0005\u001dk$aC!cgR\u0014\u0018m\u0019;TKF\u0004\"!\u0013&\r\u0001\u0011)1\n\u0001b\u0001\u0019\n\tA+\u0005\u0002N#B\u0011ajT\u0007\u0002\u007f%\u0011\u0001k\u0010\u0002\b\u001d>$\b.\u001b8h!\tq%+\u0003\u0002T\u007f\t\u0019\u0011I\\=\u0011\u0007U3\u0006*D\u0001<\u0013\t96H\u0001\u0006J]\u0012,\u00070\u001a3TKF\u0004\"AT-\n\u0005i{$\u0001D*fe&\fG.\u001b>bE2,\u0017!B:uCJ$X#\u0001%\u0002\rM$\u0018M\u001d;!\u0003\r)g\u000eZ\u0001\u0005K:$\u0007%\u0001\u0003ti\u0016\u0004\u0018!B:uKB\u0004\u0013aC5t\u0013:\u001cG.^:jm\u0016,\u0012\u0001\u001a\t\u0003\u001d\u0016L!AZ \u0003\u000f\t{w\u000e\\3b]\u0006a\u0011n]%oG2,8/\u001b<fA\u0005\u0019a.^7\u0011\u0007)l\u0007J\u0004\u0002OW&\u0011AnP\u0001\ba\u0006\u001c7.Y4f\u0013\tqwN\u0001\u0005J]R,wM]1m\u0015\taw(\u0001\u0004=S:LGO\u0010\u000b\u0006eV4x\u000f\u001f\u000b\u0003gR\u00042!\u0016\u0001I\u0011\u0015A'\u0002q\u0001j\u0011\u0015Y&\u00021\u0001I\u0011\u0015q&\u00021\u0001I\u0011\u0015\u0001'\u00021\u0001I\u0011\u0015\u0011'\u00021\u0001e\u0003AqW/\u001c*b]\u001e,W\t\\3nK:$8/F\u0001|!\tqE0\u0003\u0002~\u007f\t\u0019\u0011J\u001c;\u0002\r1,gn\u001a;i\u0003\u001dI7/R7qif\fA\u0001\\1ti\u0006\u0011!-\u001f\u000b\u0004g\u0006\u001d\u0001BBA\u0005\u001f\u0001\u0007\u0001*A\u0004oK^\u001cF/\u001a9\u0002\t\r|\u0007/\u001f\u000b\bg\u0006=\u0011\u0011CA\n\u0011\u0015Y\u0006\u00031\u0001I\u0011\u0015q\u0006\u00031\u0001I\u0011\u0015\u0001\u0007\u00031\u0001I\u0003\u001d1wN]3bG\",B!!\u0007\u0002.Q!\u00111DA\u0011!\rq\u0015QD\u0005\u0004\u0003?y$\u0001B+oSRDq!a\t\u0012\u0001\u0004\t)#A\u0001g!\u0019q\u0015q\u0005%\u0002,%\u0019\u0011\u0011F \u0003\u0013\u0019+hn\u0019;j_:\f\u0004cA%\u0002.\u00111\u0011qF\tC\u00021\u0013\u0011!V\u0001\u0013SN<\u0016\u000e\u001e5j]\n{WO\u001c3be&,7\u000fF\u0002e\u0003kAa!a\u000e\u0013\u0001\u0004A\u0015\u0001B3mK6\fa\u0002\\8dCRLwN\\!gi\u0016\u0014h\nF\u0002I\u0003{Aa!a\u0010\u0014\u0001\u0004Y\u0018!\u00018\u0002\u001b9,w/R7qif\u0014\u0016M\\4f)\u0011\t)E!\u000e\u0011\t\u0005\u001dS\u0006\u0013\b\u0003+\u0006\nABT;nKJL7MU1oO\u0016\u0004\"!\u0016\u0012\u0014\t\t\ny\u0005\u0017\t\u0004\u001d\u0006E\u0013bAA*\u007f\t1\u0011I\\=SK\u001a$\"!a\u0013\u0002\u000b\r|WO\u001c;\u0016\t\u0005m\u0013Q\r\u000b\u000b\u0003;\n9'!\u001b\u0002l\u00055DcA>\u0002`!1\u0001\u000e\na\u0002\u0003C\u0002BA[7\u0002dA\u0019\u0011*!\u001a\u0005\u000b-##\u0019\u0001'\t\rm#\u0003\u0019AA2\u0011\u0019qF\u00051\u0001\u0002d!1\u0001\r\na\u0001\u0003GBQA\u0019\u0013A\u0002\u0011\u0014\u0011\"\u00138dYV\u001c\u0018N^3\u0016\t\u0005M\u0014\u0011P\n\u0004K\u0005U\u0004\u0003B+\u0001\u0003o\u00022!SA=\t\u0015YUE1\u0001M!\u0011QW.a\u001e\u0015\u0011\u0005}\u0014qQAE\u0003\u0017#B!!!\u0002\u0006B)\u00111Q\u0013\u0002x5\t!\u0005\u0003\u0004iU\u0001\u000f\u00111\u0010\u0005\u00077*\u0002\r!a\u001e\t\ryS\u0003\u0019AA<\u0011\u0019\u0001'\u00061\u0001\u0002xQA\u0011\u0011QAH\u0003#\u000b\u0019\n\u0003\u0004\\W\u0001\u0007\u0011q\u000f\u0005\u0007=.\u0002\r!a\u001e\t\r\u0001\\\u0003\u0019AA<\u0003%)\u0007p\u00197vg&4X-\u0006\u0002\u0002\u001aB)\u00111Q\u0017\u0002x\tIQ\t_2mkNLg/Z\u000b\u0005\u0003?\u000b)kE\u0002.\u0003C\u0003B!\u0016\u0001\u0002$B\u0019\u0011*!*\u0005\u000b-k#\u0019\u0001'\u0011\t)l\u00171\u0015\u000b\t\u0003W\u000b\t,a-\u00026R!\u0011QVAX!\u0015\t\u0019)LAR\u0011\u0019A'\u0007q\u0001\u0002(\"11L\ra\u0001\u0003GCaA\u0018\u001aA\u0002\u0005\r\u0006B\u000213\u0001\u0004\t\u0019\u000b\u0006\u0005\u0002.\u0006e\u00161XA_\u0011\u0019Y6\u00071\u0001\u0002$\"1al\ra\u0001\u0003GCa\u0001Y\u001aA\u0002\u0005\r\u0016!C5oG2,8/\u001b<f+\t\t\u0019\rE\u0003\u0002\u0004\u0016\n\u0019+A\u0003baBd\u00170\u0006\u0003\u0002J\u0006EG\u0003CAf\u0003/\fI.a7\u0015\t\u00055\u00171\u001b\t\u0006\u0003\u0007k\u0013q\u001a\t\u0004\u0013\u0006EG!B&6\u0005\u0004a\u0005B\u000256\u0001\b\t)\u000e\u0005\u0003k[\u0006=\u0007BB.6\u0001\u0004\ty\r\u0003\u0004_k\u0001\u0007\u0011q\u001a\u0005\u0007AV\u0002\r!a4\u0016\t\u0005}\u0017q\u001d\u000b\t\u0003C\fi/a<\u0002rR!\u00111]Au!\u0015\t\u0019)JAs!\rI\u0015q\u001d\u0003\u0006\u0017Z\u0012\r\u0001\u0014\u0005\u0007QZ\u0002\u001d!a;\u0011\t)l\u0017Q\u001d\u0005\u00077Z\u0002\r!!:\t\ry3\u0004\u0019AAs\u0011\u0019\u0001g\u00071\u0001\u0002f\u0006yA-\u001a4bk2$xJ\u001d3fe&tw-\u0006\u0002\u0002xB9Q+!?\u0002~\nM\u0011bAA~w\t\u0019Q*\u001991\t\u0005}(Q\u0002\t\u0007\u0005\u0003\u00119Aa\u0003\u000e\u0005\t\r!b\u0001B\u0003\u007f\u0005!Q.\u0019;i\u0013\u0011\u0011IAa\u0001\u0003\u000f9+X.\u001a:jGB\u0019\u0011J!\u0004\u0005\u0015\t=\u0001(!A\u0001\u0002\u000b\u0005AJA\u0002`IE\n\u0001\u0003Z3gCVdGo\u0014:eKJLgn\u001a\u00111\t\tU!Q\u0004\t\u0007\u0005\u0003\u00119Ba\u0007\n\t\te!1\u0001\u0002\t\u001fJ$WM]5oOB\u0019\u0011J!\b\u0005\u0015\t}\u0001(!A\u0001\u0002\u000b\u0005AJA\u0002`II\n1B]3bIJ+7o\u001c7wKR\u0011!Q\u0005\t\u0005\u0005O\u0011\t$\u0004\u0002\u0003*)!!1\u0006B\u0017\u0003\u0011a\u0017M\\4\u000b\u0005\t=\u0012\u0001\u00026bm\u0006LAAa\r\u0003*\t1qJ\u00196fGRDaAa\u000e\u0015\u0001\u0004A\u0015!\u0002<bYV,\u0017\u0001\u0002;bW\u0016$2a\u001dB\u001f\u0011\u0019\ty$\u0006a\u0001w\u0006!AM]8q)\r\u0019(1\t\u0005\u0007\u0003\u007f1\u0002\u0019A>\u0015\u0007!\u00139\u0005\u0003\u0004\u0003J]\u0001\ra_\u0001\u0004S\u0012D\u0018aA7j]V!!q\nB.)\rA%\u0011\u000b\u0005\b\u0005'B\u00029\u0001B+\u0003\ry'\u000f\u001a\t\u0006U\n]#\u0011L\u0005\u0004\u00053y\u0007cA%\u0003\\\u00119!Q\f\rC\u0002\t}#A\u0001+2#\tA\u0015+A\u0002nCb,BA!\u001a\u0003nQ\u0019\u0001Ja\u001a\t\u000f\tM\u0013\u0004q\u0001\u0003jA)!Na\u0016\u0003lA\u0019\u0011J!\u001c\u0005\u000f\tu\u0013D1\u0001\u0003`\u0005AQ.\u00199SC:<W-\u0006\u0003\u0003t\tmD\u0003\u0002B;\u0005\u000b#BAa\u001e\u0003\u0000A!Q\u000b\u0001B=!\rI%1\u0010\u0003\u0007\u0005{R\"\u0019\u0001'\u0003\u0003\u0005CqA!!\u001b\u0001\b\u0011\u0019)\u0001\u0003v]Vl\u0007\u0003\u00026n\u0005sBqAa\"\u001b\u0001\u0004\u0011I)\u0001\u0002g[B1a*a\nI\u0005s\nQbY8oi\u0006Lgn\u001d+za\u0016$Gc\u00013\u0003\u0010\"1!\u0011S\u000eA\u0002!\u000b\u0011\u0001_\u0001\tG>tG/Y5ogV!!q\u0013BO)\r!'\u0011\u0014\u0005\b\u0005#c\u0002\u0019\u0001BN!\rI%Q\u0014\u0003\b\u0005?c\"\u0019\u0001B0\u0005\t\t\u0015'A\u0002tk6,BA!*\u0003*R!!q\u0015BW!\rI%\u0011\u0016\u0003\b\u0005Wk\"\u0019\u0001B0\u0005\u0005\u0011\u0005B\u00025\u001e\u0001\b\u0011y\u000bE\u0003k\u0005c\u00139+C\u0002\u0003\n=\f\u0001\u0002[1tQ\u000e{G-Z\u0001\u0007KF,\u0018\r\\:\u0015\u0007\u0011\u0014I\f\u0003\u0004\u0003<~\u0001\r!U\u0001\u0006_RDWM]\u0001\ti>\u001cFO]5oOR\u0011!\u0011\u0019\t\u0005\u0005\u0007\u0014\tN\u0004\u0003\u0003F\n5\u0007c\u0001Bd\u007f5\u0011!\u0011\u001a\u0006\u0004\u0005\u0017\f\u0015A\u0002\u001fs_>$h(C\u0002\u0003P~\na\u0001\u0015:fI\u00164\u0017\u0002\u0002Bj\u0005+\u0014aa\u0015;sS:<'b\u0001Bh\u007f\u0001")
public abstract class NumericRange<T>
extends AbstractSeq<T>
implements scala.collection.immutable.IndexedSeq<T>,
Serializable {
    private int numRangeElements;
    private T last;
    private int hashCode;
    private final T start;
    private final T end;
    private final T step;
    private final boolean isInclusive;
    private final Integral<T> num;
    private volatile byte bitmap$0;

    public static <T> Inclusive<T> inclusive(T t, T t2, T t3, Integral<T> integral) {
        return NumericRange$.MODULE$.inclusive(t, t2, t3, integral);
    }

    @Override
    public GenericCompanion<scala.collection.immutable.IndexedSeq> companion() {
        return scala.collection.immutable.IndexedSeq.companion$(this);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<T> toIndexedSeq() {
        return scala.collection.immutable.IndexedSeq.toIndexedSeq$(this);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<T> seq() {
        return scala.collection.immutable.IndexedSeq.seq$(this);
    }

    @Override
    public IndexedSeq<T> thisCollection() {
        return IndexedSeqLike.thisCollection$(this);
    }

    @Override
    public IndexedSeq toCollection(Object repr) {
        return IndexedSeqLike.toCollection$(this, repr);
    }

    @Override
    public Iterator<T> iterator() {
        return IndexedSeqLike.iterator$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return IndexedSeqLike.sizeHintIfCheap$(this);
    }

    @Override
    public Seq<T> toSeq() {
        return Seq.toSeq$(this);
    }

    @Override
    public Combiner<T, ParSeq<T>> parCombiner() {
        return Seq.parCombiner$(this);
    }

    public T start() {
        return this.start;
    }

    public T end() {
        return this.end;
    }

    public T step() {
        return this.step;
    }

    public boolean isInclusive() {
        return this.isInclusive;
    }

    private int numRangeElements$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                this.numRangeElements = NumericRange$.MODULE$.count(this.start(), this.end(), this.step(), this.isInclusive(), this.num);
                this.bitmap$0 = (byte)(this.bitmap$0 | 1);
            }
        }
        return this.numRangeElements;
    }

    private int numRangeElements() {
        if ((byte)(this.bitmap$0 & 1) == 0) {
            return this.numRangeElements$lzycompute();
        }
        return this.numRangeElements;
    }

    @Override
    public int length() {
        return this.numRangeElements();
    }

    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }

    private T last$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                this.last = this.length() == 0 ? Nil$.MODULE$.last() : this.locationAfterN(this.length() - 1);
                this.bitmap$0 = (byte)(this.bitmap$0 | 2);
            }
        }
        return this.last;
    }

    @Override
    public T last() {
        if ((byte)(this.bitmap$0 & 2) == 0) {
            return this.last$lzycompute();
        }
        return this.last;
    }

    public NumericRange<T> by(T newStep) {
        return this.copy(this.start(), this.end(), newStep);
    }

    public abstract NumericRange<T> copy(T var1, T var2, T var3);

    @Override
    public <U> void foreach(Function1<T, U> f) {
        T current = this.start();
        for (int count = 0; count < this.length(); ++count) {
            f.apply(current);
            current = this.num.mkNumericOps(current).$plus(this.step());
        }
    }

    private boolean isWithinBoundaries(T elem) {
        return !this.isEmpty() && (this.num.mkOrderingOps(this.step()).$greater(this.num.zero()) && this.num.mkOrderingOps(this.start()).$less$eq(elem) && this.num.mkOrderingOps(elem).$less$eq(this.last()) || this.num.mkOrderingOps(this.step()).$less(this.num.zero()) && this.num.mkOrderingOps(this.last()).$less$eq(elem) && this.num.mkOrderingOps(elem).$less$eq(this.start()));
    }

    private T locationAfterN(int n) {
        return this.num.mkNumericOps(this.start()).$plus(this.num.mkNumericOps(this.step()).$times(this.num.fromInt(n)));
    }

    private Exclusive<T> newEmptyRange(T value) {
        return NumericRange$.MODULE$.apply(value, value, this.step(), this.num);
    }

    @Override
    public final NumericRange<T> take(int n) {
        if (n <= 0 || this.length() == 0) {
            return this.newEmptyRange(this.start());
        }
        if (n >= this.length()) {
            return this;
        }
        return new Inclusive<T>(this.start(), this.locationAfterN(n - 1), this.step(), this.num);
    }

    @Override
    public final NumericRange<T> drop(int n) {
        if (n <= 0 || this.length() == 0) {
            return this;
        }
        if (n >= this.length()) {
            return this.newEmptyRange(this.end());
        }
        return this.copy(this.locationAfterN(n), this.end(), this.step());
    }

    @Override
    public T apply(int idx) {
        if (idx < 0 || idx >= this.length()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }
        return this.locationAfterN(idx);
    }

    @Override
    public <T1> T min(Ordering<T1> ord) {
        if (ord == this.num || NumericRange$.MODULE$.defaultOrdering().get(this.num).exists((Function1<Ordering, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(NumericRange.$anonfun$min$1(ord, x$1)))) {
            if (this.num.signum(this.step()) > 0) {
                return (T)this.head();
            }
            return this.last();
        }
        return (T)TraversableOnce.min$(this, ord);
    }

    @Override
    public <T1> T max(Ordering<T1> ord) {
        if (ord == this.num || NumericRange$.MODULE$.defaultOrdering().get(this.num).exists((Function1<Ordering, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(NumericRange.$anonfun$max$1(ord, x$2)))) {
            if (this.num.signum(this.step()) > 0) {
                return this.last();
            }
            return (T)this.head();
        }
        return (T)TraversableOnce.max$(this, ord);
    }

    public <A> NumericRange<A> mapRange(Function1<T, A> fm, Integral<A> unum) {
        return new NumericRange<A>(this, fm, unum, this){
            private NumericRange<T> underlyingRange;
            private volatile boolean bitmap$0;
            private final Integral unum$1;
            private NumericRange self$1;
            private final Function1 fm$1;

            public NumericRange<A> copy(A start, A end, A step) {
                if (this.isInclusive()) {
                    return NumericRange$.MODULE$.inclusive(start, end, step, this.unum$1);
                }
                return NumericRange$.MODULE$.apply(start, end, step, this.unum$1);
            }

            private NumericRange<T> underlyingRange$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.underlyingRange = this.self$1;
                        this.bitmap$0 = true;
                    }
                }
                this.self$1 = null;
                return this.underlyingRange;
            }

            private NumericRange<T> underlyingRange() {
                if (!this.bitmap$0) {
                    return this.underlyingRange$lzycompute();
                }
                return this.underlyingRange;
            }

            public <U> void foreach(Function1<A, U> f) {
                this.underlyingRange().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(T x) -> f.apply($this.fm$1.apply(x)));
            }

            public boolean isEmpty() {
                return this.underlyingRange().isEmpty();
            }

            public A apply(int idx) {
                return (A)this.fm$1.apply(this.underlyingRange().apply(idx));
            }

            public boolean containsTyped(A el) {
                return this.underlyingRange().exists((Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean($anon$1.$anonfun$containsTyped$1(this, el, x)));
            }

            public String toString() {
                String stepped = $anon$1.simpleOf$1(this.underlyingRange().step());
                return new StringBuilder(13).append(super.toString()).append(" (using ").append(this.underlyingRange()).append(" of ").append(stepped).append(")").toString();
            }

            public static final /* synthetic */ boolean $anonfun$containsTyped$1($anon$1 $this, Object el$1, Object x) {
                return BoxesRunTime.equals($this.fm$1.apply(x), el$1);
            }

            private static final String simpleOf$1(Object x) {
                return (String)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])x.getClass().getName().split("\\."))).last();
            }
            {
                this.unum$1 = unum$1;
                this.self$1 = self$1;
                this.fm$1 = fm$1;
                super(fm$1.apply($outer.start()), fm$1.apply($outer.end()), fm$1.apply($outer.step()), $outer.isInclusive(), unum$1);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$foreach$1(scala.collection.immutable.NumericRange$$anon$1 scala.Function1 java.lang.Object ), $anonfun$containsTyped$1$adapted(scala.collection.immutable.NumericRange$$anon$1 java.lang.Object java.lang.Object )}, serializedLambda);
            }
        };
    }

    public boolean containsTyped(T x) {
        return this.isWithinBoundaries(x) && BoxesRunTime.equals(this.num.mkNumericOps(this.num.mkNumericOps(x).$minus(this.start())).$percent(this.step()), this.num.zero());
    }

    @Override
    public <A1> boolean contains(A1 x) {
        try {
            return this.containsTyped(x);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    @Override
    public final <B> B sum(Numeric<B> num) {
        if (this.isEmpty()) {
            return num.zero();
        }
        if (this.numRangeElements() == 1) {
            return (B)this.head();
        }
        if (num == Numeric$IntIsIntegral$.MODULE$ || num == Numeric$ShortIsIntegral$.MODULE$ || num == Numeric$ByteIsIntegral$.MODULE$ || num == Numeric$CharIsIntegral$.MODULE$) {
            long exact = (long)this.numRangeElements() * (num.toLong(this.head()) + (long)num.toInt(this.last())) / 2L;
            return num.fromInt((int)exact);
        }
        if (num == Numeric$LongIsIntegral$.MODULE$) {
            long l;
            long a = this.num.mkNumericOps(this.head()).toLong();
            long b = this.num.mkNumericOps(this.last()).toLong();
            if ((this.numRangeElements() & 1) == 0) {
                l = (long)(this.numRangeElements() / 2) * (a + b);
            } else {
                long ha = a / 2L;
                long hb = b / 2L;
                l = (long)this.numRangeElements() * (ha + hb + (a - 2L * ha + (b - 2L * hb)) / 2L);
            }
            return (B)BoxesRunTime.boxToLong(l);
        }
        if (num == Numeric$FloatAsIfIntegral$.MODULE$ || num == Numeric$DoubleAsIfIntegral$.MODULE$) {
            Integral numAsIntegral = (Integral)num;
            double a = package$.MODULE$.abs(numAsIntegral.mkNumericOps(this.head()).toDouble());
            double b = package$.MODULE$.abs(numAsIntegral.mkNumericOps(this.last()).toDouble());
            B two = num.fromInt(2);
            B nre = num.fromInt(this.numRangeElements());
            if (a > 1.0E38 || b > 1.0E38) {
                return (B)numAsIntegral.mkNumericOps(nre).$times(numAsIntegral.mkNumericOps(numAsIntegral.mkNumericOps(this.head()).$div(two)).$plus(numAsIntegral.mkNumericOps(this.last()).$div(two)));
            }
            return (B)numAsIntegral.mkNumericOps(numAsIntegral.mkNumericOps(nre).$div(two)).$times(numAsIntegral.mkNumericOps(this.head()).$plus(this.last()));
        }
        if (num == Numeric$BigIntIsIntegral$.MODULE$ || num == Numeric$BigDecimalIsFractional$.MODULE$) {
            Integral numAsIntegral = (Integral)num;
            return (B)numAsIntegral.mkNumericOps(numAsIntegral.mkNumericOps(num.fromInt(this.numRangeElements())).$times(numAsIntegral.mkNumericOps(this.head()).$plus(this.last()))).$div(num.fromInt(2));
        }
        if (this.isEmpty()) {
            return num.zero();
        }
        B acc = num.zero();
        Object i = this.head();
        for (int idx = 0; idx < this.length(); ++idx) {
            acc = num.plus(acc, i);
            i = this.num.mkNumericOps(i).$plus(this.step());
        }
        return acc;
    }

    private int hashCode$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                this.hashCode = IndexedSeqLike.hashCode$(this);
                this.bitmap$0 = (byte)(this.bitmap$0 | 4);
            }
        }
        return this.hashCode;
    }

    @Override
    public int hashCode() {
        if ((byte)(this.bitmap$0 & 4) == 0) {
            return this.hashCode$lzycompute();
        }
        return this.hashCode;
    }

    @Override
    public boolean equals(Object other) {
        NumericRange numericRange;
        boolean bl = other instanceof NumericRange ? (numericRange = (NumericRange)other).canEqual(this) && this.length() == numericRange.length() && (this.length() == 0 || BoxesRunTime.equals(this.start(), numericRange.start()) && BoxesRunTime.equals(this.last(), numericRange.last())) : GenSeqLike.equals$(this, other);
        return bl;
    }

    @Override
    public String toString() {
        String empty = this.isEmpty() ? "empty " : "";
        String preposition = this.isInclusive() ? "to" : "until";
        String stepped = BoxesRunTime.equals(this.step(), BoxesRunTime.boxToInteger(1)) ? "" : new StringBuilder(4).append(" by ").append(this.step()).toString();
        return new StringBuilder(15).append(empty).append("NumericRange ").append(this.start()).append(" ").append(preposition).append(" ").append(this.end()).append(stepped).toString();
    }

    public static final /* synthetic */ boolean $anonfun$min$1(Ordering ord$1, Ordering x$1) {
        return ord$1 == x$1;
    }

    public static final /* synthetic */ boolean $anonfun$max$1(Ordering ord$2, Ordering x$2) {
        return ord$2 == x$2;
    }

    public NumericRange(T start, T end, T step, boolean isInclusive, Integral<T> num) {
        this.start = start;
        this.end = end;
        this.step = step;
        this.isInclusive = isInclusive;
        this.num = num;
        Traversable.$init$(this);
        Iterable.$init$(this);
        Seq.$init$(this);
        IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        scala.collection.immutable.IndexedSeq.$init$(this);
    }

    public static class Exclusive<T>
    extends NumericRange<T> {
        private final Integral<T> num;

        @Override
        public Exclusive<T> copy(T start, T end, T step) {
            return NumericRange$.MODULE$.apply(start, end, step, this.num);
        }

        public Inclusive<T> inclusive() {
            return NumericRange$.MODULE$.inclusive(super.start(), super.end(), super.step(), this.num);
        }

        public Exclusive(T start, T end, T step, Integral<T> num) {
            this.num = num;
            super(start, end, step, false, num);
        }
    }

    public static class Inclusive<T>
    extends NumericRange<T> {
        private final Integral<T> num;

        @Override
        public Inclusive<T> copy(T start, T end, T step) {
            return NumericRange$.MODULE$.inclusive(start, end, step, this.num);
        }

        public Exclusive<T> exclusive() {
            return NumericRange$.MODULE$.apply(super.start(), super.end(), super.step(), this.num);
        }

        public Inclusive(T start, T end, T step, Integral<T> num) {
            this.num = num;
            super(start, end, step, true, num);
        }
    }
}

