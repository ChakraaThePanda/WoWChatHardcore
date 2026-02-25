/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Array$;
import scala.MatchError;
import scala.Option;
import scala.Tuple2;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArraySeq;
import scala.collection.mutable.DoublingUnrolledBuffer;
import scala.collection.mutable.UnrolledBuffer;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.Task;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.UnrolledParArrayCombiner$;
import scala.collection.parallel.package$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005-da\u0002\u000e\u001c!\u0003\r\t\u0001\n\u0005\u0006{\u0001!\tA\u0010\u0005\b\u0005\u0002\u0011\r\u0011\"\u0001D\u0011\u0015I\u0005\u0001\"\u0001K\u0011\u0015q\u0005\u0001\"\u0001P\u0011\u0015\u0001\u0006\u0001\"\u0001?\u0011\u0015\t\u0006\u0001\"\u0011S\u0011\u0015A\u0006\u0001\"\u0001Z\u0011\u00151\u0007\u0001\"\u0001h\r\u0011A\u0007\u0001A5\t\u00119L!\u0011!Q\u0001\n=D\u0001B]\u0005\u0003\u0002\u0003\u0006I!\u0016\u0005\tg&\u0011\t\u0011)A\u0005+\")A/\u0003C\u0001k\"9a*\u0003a\u0001\n\u0003I\bb\u0002>\n\u0001\u0004%\ta\u001f\u0005\u0007}&\u0001\u000b\u0015B \t\r}LA\u0011AA\u0001\u0011\u001d\ti!\u0003C\u0005\u0003\u001fAq!!\u000b\n\t\u0003\tY\u0003C\u0004\u0002:%!\t!a\u000f\t\u000f\u0005\r\u0013\u0002\"\u0011\u0002F\u001d9\u0011qK\u000e\t\u0002\u0005ecA\u0002\u000e\u001c\u0011\u0003\tY\u0006\u0003\u0004u/\u0011\u0005\u0011Q\f\u0005\b\u0003?:B\u0011AA1\u0005a)fN]8mY\u0016$\u0007+\u0019:BeJ\f\u0017pQ8nE&tWM\u001d\u0006\u00039u\tq!\\;uC\ndWM\u0003\u0002\u001f?\u0005A\u0001/\u0019:bY2,GN\u0003\u0002!C\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003\t\nQa]2bY\u0006\u001c\u0001!\u0006\u0002&aM\u0019\u0001A\n\u0016\u0011\u0005\u001dBS\"A\u0011\n\u0005%\n#AB!osJ+g\r\u0005\u0003,Y9JT\"A\u000f\n\u00055j\"\u0001C\"p[\nLg.\u001a:\u0011\u0005=\u0002D\u0002\u0001\u0003\u0006c\u0001\u0011\rA\r\u0002\u0002)F\u00111G\u000e\t\u0003OQJ!!N\u0011\u0003\u000f9{G\u000f[5oOB\u0011qeN\u0005\u0003q\u0005\u00121!\u00118z!\rQ4HL\u0007\u00027%\u0011Ah\u0007\u0002\t!\u0006\u0014\u0018I\u001d:bs\u00061A%\u001b8ji\u0012\"\u0012a\u0010\t\u0003O\u0001K!!Q\u0011\u0003\tUs\u0017\u000e^\u0001\u0005EV4g-F\u0001E!\r)uIN\u0007\u0002\r*\u0011AdH\u0005\u0003\u0011\u001a\u0013a\u0003R8vE2LgnZ+oe>dG.\u001a3Ck\u001a4WM]\u0001\tIAdWo\u001d\u0013fcR\u00111\nT\u0007\u0002\u0001!)Qj\u0001a\u0001]\u0005!Q\r\\3n\u0003\u0019\u0011Xm];miR\t\u0011(A\u0003dY\u0016\f'/\u0001\u0005tSj,\u0007*\u001b8u)\ty4\u000bC\u0003U\r\u0001\u0007Q+\u0001\u0002tuB\u0011qEV\u0005\u0003/\u0006\u00121!\u00138u\u0003\u001d\u0019w.\u001c2j]\u0016,2AW/b)\tYF\r\u0005\u0003,Yq\u0003\u0007CA\u0018^\t\u0015qvA1\u0001`\u0005\u0005q\u0015CA\u001a/!\ty\u0013\rB\u0003c\u000f\t\u00071MA\u0003OK^$v.\u0005\u0002:m!)Qm\u0002a\u00017\u0006)q\u000e\u001e5fe\u0006!1/\u001b>f+\u0005)&aE\"paf,fN]8mY\u0016$Gk\\!se\u0006L8cA\u0005'UB!1f[ n\u0013\taWD\u0001\u0003UCN\\\u0007CA&\n\u0003\u0015\t'O]1z!\r9\u0003ON\u0005\u0003c\u0006\u0012Q!\u0011:sCf\faa\u001c4gg\u0016$\u0018a\u00025po6\fg._\u0001\u0007y%t\u0017\u000e\u001e \u0015\t54x\u000f\u001f\u0005\u0006]6\u0001\ra\u001c\u0005\u0006e6\u0001\r!\u0016\u0005\u0006g6\u0001\r!V\u000b\u0002\u007f\u0005Q!/Z:vYR|F%Z9\u0015\u0005}b\bbB?\u0010\u0003\u0003\u0005\raP\u0001\u0004q\u0012\n\u0014a\u0002:fgVdG\u000fI\u0001\u0005Y\u0016\fg\rF\u0002@\u0003\u0007Aq!!\u0002\u0012\u0001\u0004\t9!\u0001\u0003qe\u00164\b\u0003B\u0014\u0002\n}J1!a\u0003\"\u0005\u0019y\u0005\u000f^5p]\u0006Ia-\u001b8e'R\f'\u000f\u001e\u000b\u0005\u0003#\t)\u0003\u0005\u0004(\u0003'\t9\"V\u0005\u0004\u0003+\t#A\u0002+va2,'\u0007E\u0003\u0002\u001a\u0005}aGD\u0002F\u00037I1!!\bG\u00039)fN]8mY\u0016$')\u001e4gKJLA!!\t\u0002$\tAQK\u001c:pY2,GMC\u0002\u0002\u001e\u0019Ca!a\n\u0013\u0001\u0004)\u0016a\u00019pg\u0006)1\u000f\u001d7jiV\u0011\u0011Q\u0006\t\u0006\u0003_\t)$\\\u0007\u0003\u0003cQ1!a\r \u0003%IW.\\;uC\ndW-\u0003\u0003\u00028\u0005E\"\u0001\u0002'jgR\f!c\u001d5pk2$7\u000b\u001d7ji\u001a+(\u000f\u001e5feV\u0011\u0011Q\b\t\u0004O\u0005}\u0012bAA!C\t9!i\\8mK\u0006t\u0017\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0005\u001d\u0003\u0003BA%\u0003'j!!a\u0013\u000b\t\u00055\u0013qJ\u0001\u0005Y\u0006twM\u0003\u0002\u0002R\u0005!!.\u0019<b\u0013\u0011\t)&a\u0013\u0003\rM#(/\u001b8h\u0003a)fN]8mY\u0016$\u0007+\u0019:BeJ\f\u0017pQ8nE&tWM\u001d\t\u0003u]\u0019\"a\u0006\u0014\u0015\u0005\u0005e\u0013!B1qa2LX\u0003BA2\u0003S\"\"!!\u001a\u0011\ti\u0002\u0011q\r\t\u0004_\u0005%D!B\u0019\u001a\u0005\u0004\u0011\u0004")
public interface UnrolledParArrayCombiner<T>
extends Combiner<T, ParArray<T>> {
    public static <T> UnrolledParArrayCombiner<T> apply() {
        return UnrolledParArrayCombiner$.MODULE$.apply();
    }

    public void scala$collection$parallel$mutable$UnrolledParArrayCombiner$_setter_$buff_$eq(DoublingUnrolledBuffer<Object> var1);

    public DoublingUnrolledBuffer<Object> buff();

    public static /* synthetic */ UnrolledParArrayCombiner $plus$eq$(UnrolledParArrayCombiner $this, Object elem) {
        return $this.$plus$eq((T)elem);
    }

    @Override
    default public UnrolledParArrayCombiner<T> $plus$eq(T elem) {
        this.buff().$plus$eq((Object)elem);
        return this;
    }

    public static /* synthetic */ ParArray result$(UnrolledParArrayCombiner $this) {
        return $this.result();
    }

    @Override
    default public ParArray<T> result() {
        ArraySeq arrayseq = new ArraySeq(this.size());
        Object[] array = arrayseq.array();
        this.combinerTaskSupport().executeAndWaitResult(new CopyUnrolledToArray(this, array, 0, this.size()));
        return new ParArray(arrayseq);
    }

    public static /* synthetic */ void clear$(UnrolledParArrayCombiner $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        this.buff().clear();
    }

    public static /* synthetic */ void sizeHint$(UnrolledParArrayCombiner $this, int sz) {
        $this.sizeHint(sz);
    }

    @Override
    default public void sizeHint(int sz) {
        this.buff().lastPtr().next_$eq(new UnrolledBuffer.Unrolled<Object>(0, new Object[sz], null, this.buff(), ClassTag$.MODULE$.Any()));
        this.buff().lastPtr_$eq(this.buff().lastPtr().next());
    }

    public static /* synthetic */ Combiner combine$(UnrolledParArrayCombiner $this, Combiner other) {
        return $this.combine(other);
    }

    @Override
    default public <N extends T, NewTo> Combiner<N, NewTo> combine(Combiner<N, NewTo> other) {
        if (other != this) {
            if (other instanceof UnrolledParArrayCombiner) {
                UnrolledParArrayCombiner unrolledParArrayCombiner = (UnrolledParArrayCombiner)other;
                this.buff().concat(unrolledParArrayCombiner.buff());
            } else {
                throw new UnsupportedOperationException("Cannot combine with combiner of different type.");
            }
        }
        return this;
    }

    public static /* synthetic */ int size$(UnrolledParArrayCombiner $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        return this.buff().size();
    }

    public static void $init$(UnrolledParArrayCombiner $this) {
        $this.scala$collection$parallel$mutable$UnrolledParArrayCombiner$_setter_$buff_$eq(new DoublingUnrolledBuffer<Object>(ClassTag$.MODULE$.Any()));
    }

    public class CopyUnrolledToArray
    implements Task<BoxedUnit, CopyUnrolledToArray> {
        private final Object[] array;
        private final int offset;
        private final int howmany;
        private BoxedUnit result;
        private volatile Throwable throwable;
        public final /* synthetic */ UnrolledParArrayCombiner $outer;

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void merge(Object that) {
            Task.merge$(this, that);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<BoxedUnit> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public void signalAbort() {
            Task.signalAbort$(this);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public void result() {
        }

        @Override
        public void result_$eq(BoxedUnit x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<BoxedUnit> prev) {
            if (this.howmany > 0) {
                int totalleft = this.howmany;
                Tuple2<UnrolledBuffer.Unrolled<Object>, Object> tuple2 = this.findStart(this.offset);
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                UnrolledBuffer.Unrolled<Object> unrolled = tuple2._1();
                int n = tuple2._2$mcI$sp();
                UnrolledBuffer.Unrolled<Object> curr = unrolled;
                int pos = n;
                int arroffset = this.offset;
                while (totalleft > 0) {
                    int lefthere = scala.math.package$.MODULE$.min(totalleft, curr.size() - pos);
                    Array$.MODULE$.copy(curr.array(), pos, this.array, arroffset, lefthere);
                    totalleft -= lefthere;
                    arroffset += lefthere;
                    pos = 0;
                    curr = curr.next();
                }
            }
        }

        private Tuple2<UnrolledBuffer.Unrolled<Object>, Object> findStart(int pos) {
            int left = pos;
            UnrolledBuffer.Unrolled node = this.scala$collection$parallel$mutable$UnrolledParArrayCombiner$CopyUnrolledToArray$$$outer().buff().headPtr();
            while (left - node.size() >= 0) {
                left -= node.size();
                node = node.next();
            }
            return new Tuple2<UnrolledBuffer.Unrolled<Object>, Object>(node, BoxesRunTime.boxToInteger(left));
        }

        public List<CopyUnrolledToArray> split() {
            int fp = this.howmany / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new CopyUnrolledToArray(this.scala$collection$parallel$mutable$UnrolledParArrayCombiner$CopyUnrolledToArray$$$outer(), this.array, this.offset, fp)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new CopyUnrolledToArray(this.scala$collection$parallel$mutable$UnrolledParArrayCombiner$CopyUnrolledToArray$$$outer(), this.array, this.offset + fp, this.howmany - fp)), Nil$.MODULE$));
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany > package$.MODULE$.thresholdFromSize(this.scala$collection$parallel$mutable$UnrolledParArrayCombiner$CopyUnrolledToArray$$$outer().size(), this.scala$collection$parallel$mutable$UnrolledParArrayCombiner$CopyUnrolledToArray$$$outer().combinerTaskSupport().parallelismLevel());
        }

        public String toString() {
            return new StringBuilder(23).append("CopyUnrolledToArray(").append(this.offset).append(", ").append(this.howmany).append(")").toString();
        }

        public /* synthetic */ UnrolledParArrayCombiner scala$collection$parallel$mutable$UnrolledParArrayCombiner$CopyUnrolledToArray$$$outer() {
            return this.$outer;
        }

        public CopyUnrolledToArray(UnrolledParArrayCombiner $outer, Object[] array, int offset, int howmany) {
            this.array = array;
            this.offset = offset;
            this.howmany = howmany;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            this.result = BoxedUnit.UNIT;
        }
    }
}

