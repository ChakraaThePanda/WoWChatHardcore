/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Array$;
import scala.Function1;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.collection.TraversableLike;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.HashSet$;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.UnrolledBuffer;
import scala.collection.parallel.BucketCombiner;
import scala.collection.parallel.Task;
import scala.collection.parallel.immutable.HashSetCombiner$;
import scala.collection.parallel.immutable.ParHashSet;
import scala.collection.parallel.package$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005-cAB\u000e\u001d\u0003\u0003aB\u0005C\u0003=\u0001\u0011\u0005Q\bC\u0004?\u0001\t\u0007I\u0011A \t\r\u0015\u0003\u0001\u0015!\u0003A\u0011\u00151\u0005\u0001\"\u0001H\u0011\u0015Y\u0005\u0001\"\u0001M\r\u0011i\u0005\u0001\u0001(\t\u0011e3!\u0011!Q\u0001\niC\u0001b\u001c\u0004\u0003\u0002\u0003\u0006I\u0001\u001d\u0005\tc\u001a\u0011\t\u0011)A\u0005e\"AQO\u0002B\u0001B\u0003%!\u000fC\u0003=\r\u0011\u0005a\u000fC\u0004L\r\u0001\u0007I\u0011A>\t\u000fq4\u0001\u0019!C\u0001{\"9\u0011\u0011\u0001\u0004!B\u0013)\u0006bBA\u0002\r\u0011\u0005\u0011Q\u0001\u0005\b\u0003#1A\u0011BA\n\u0011\u001d\tIB\u0002C\u0001\u00037Aq!a\t\u0007\t\u0003\t)cB\u0004\u0002.qA\t!a\f\u0007\rma\u0002\u0012AA\u0019\u0011\u0019aD\u0003\"\u0001\u00024!9\u0011Q\u0007\u000b\u0005\u0002\u0005]\u0002BCA!)\t\u0007I\u0011\u0001\u000f\u0002D!9\u0011Q\t\u000b!\u0002\u0013\u0011\bBCA$)\t\u0007I\u0011\u0001\u000f\u0002D!9\u0011\u0011\n\u000b!\u0002\u0013\u0011(a\u0004%bg\"\u001cV\r^\"p[\nLg.\u001a:\u000b\u0005uq\u0012!C5n[V$\u0018M\u00197f\u0015\ty\u0002%\u0001\u0005qCJ\fG\u000e\\3m\u0015\t\t#%\u0001\u0006d_2dWm\u0019;j_:T\u0011aI\u0001\u0006g\u000e\fG.Y\u000b\u0003K1\u001a\"\u0001\u0001\u0014\u0011\r\u001dB#f\u000e\u001b<\u001b\u0005q\u0012BA\u0015\u001f\u00059\u0011UoY6fi\u000e{WNY5oKJ\u0004\"a\u000b\u0017\r\u0001\u0011)Q\u0006\u0001b\u0001_\t\tAk\u0001\u0001\u0012\u0005A\"\u0004CA\u00193\u001b\u0005\u0011\u0013BA\u001a#\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!M\u001b\n\u0005Y\u0012#aA!osB\u0019\u0001(\u000f\u0016\u000e\u0003qI!A\u000f\u000f\u0003\u0015A\u000b'\u000fS1tQN+G\u000fE\u00029\u0001)\na\u0001P5oSRtD#A\u001e\u0002\u0013\u0015l\u0007\u000f^=Ue&,W#\u0001!\u0011\u0007\u0005\u001b%&D\u0001C\u0015\ti\u0002%\u0003\u0002E\u0005\n9\u0001*Y:i'\u0016$\u0018AC3naRLHK]5fA\u0005AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0002I\u00136\t\u0001\u0001C\u0003K\t\u0001\u0007!&\u0001\u0003fY\u0016l\u0017A\u0002:fgVdG\u000fF\u00018\u0005)\u0019%/Z1uKR\u0013\u0018.Z\n\u0004\r=\u0013\u0006CA\u0019Q\u0013\t\t&E\u0001\u0004B]f\u0014VM\u001a\t\u0005OM+\u0006,\u0003\u0002U=\t!A+Y:l!\t\td+\u0003\u0002XE\t!QK\\5u!\tAe!A\u0003ck\u000e\\7\u000fE\u000227vK!\u0001\u0018\u0012\u0003\u000b\u0005\u0013(/Y=\u0011\u0007ycGG\u0004\u0002`S:\u0011\u0001m\u001a\b\u0003C\u001at!AY3\u000e\u0003\rT!\u0001\u001a\u0018\u0002\rq\u0012xn\u001c;?\u0013\u0005\u0019\u0013BA\u0011#\u0013\tA\u0007%A\u0004nkR\f'\r\\3\n\u0005)\\\u0017AD+oe>dG.\u001a3Ck\u001a4WM\u001d\u0006\u0003Q\u0002J!!\u001c8\u0003\u0011Us'o\u001c7mK\u0012T!A[6\u0002\tI|w\u000e\u001e\t\u0004cm\u0003\u0015AB8gMN,G\u000f\u0005\u00022g&\u0011AO\t\u0002\u0004\u0013:$\u0018a\u00025po6\fg.\u001f\u000b\u00061^D\u0018P\u001f\u0005\u00063.\u0001\rA\u0017\u0005\u0006_.\u0001\r\u0001\u001d\u0005\u0006c.\u0001\rA\u001d\u0005\u0006k.\u0001\rA]\u000b\u0002+\u0006Q!/Z:vYR|F%Z9\u0015\u0005Us\bbB@\u000e\u0003\u0003\u0005\r!V\u0001\u0004q\u0012\n\u0014a\u0002:fgVdG\u000fI\u0001\u0005Y\u0016\fg\rF\u0002V\u0003\u000fAq!!\u0003\u0010\u0001\u0004\tY!\u0001\u0003qe\u00164\b\u0003B\u0019\u0002\u000eUK1!a\u0004#\u0005\u0019y\u0005\u000f^5p]\u0006Q1M]3bi\u0016$&/[3\u0015\u0007\u0001\u000b)\u0002\u0003\u0004\u0002\u0018A\u0001\r!X\u0001\u0006K2,Wn]\u0001\u0006gBd\u0017\u000e^\u000b\u0003\u0003;\u0001B!QA\u00101&\u0019\u0011\u0011\u0005\"\u0003\t1K7\u000f^\u0001\u0013g\"|W\u000f\u001c3Ta2LGOR;si\",'/\u0006\u0002\u0002(A\u0019\u0011'!\u000b\n\u0007\u0005-\"EA\u0004C_>dW-\u00198\u0002\u001f!\u000b7\u000f[*fi\u000e{WNY5oKJ\u0004\"\u0001\u000f\u000b\u0014\u0005QyECAA\u0018\u0003\u0015\t\u0007\u000f\u001d7z+\u0011\tI$a\u0010\u0016\u0005\u0005m\u0002\u0003\u0002\u001d\u0001\u0003{\u00012aKA \t\u0015icC1\u00010\u0003!\u0011xn\u001c;cSR\u001cX#\u0001:\u0002\u0013I|w\u000e\u001e2jiN\u0004\u0013\u0001\u0003:p_R\u001c\u0018N_3\u0002\u0013I|w\u000e^:ju\u0016\u0004\u0003")
public abstract class HashSetCombiner<T>
extends BucketCombiner<T, ParHashSet<T>, Object, HashSetCombiner<T>> {
    private final HashSet<T> emptyTrie = (HashSet)HashSet$.MODULE$.empty();

    public static <T> HashSetCombiner<T> apply() {
        return HashSetCombiner$.MODULE$.apply();
    }

    public HashSet<T> emptyTrie() {
        return this.emptyTrie;
    }

    @Override
    public HashSetCombiner<T> $plus$eq(T elem) {
        this.sz_$eq(this.sz() + 1);
        int pos = HashSet$.MODULE$.computeHash(elem) & 0x1F;
        if (this.buckets()[pos] == null) {
            this.buckets()[pos] = new UnrolledBuffer<Object>(ClassTag$.MODULE$.Any());
        }
        this.buckets()[pos].$plus$eq((Object)elem);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ParHashSet<T> result() {
        void foldLeft_foldl_end;
        void foldLeft_z;
        UnrolledBuffer.Unrolled[] bucks = (UnrolledBuffer.Unrolled[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.buckets())).filterImpl((Function1<UnrolledBuffer, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(HashSetCombiner.$anonfun$result$1(x$3)), false))), (Function1<UnrolledBuffer, UnrolledBuffer.Unrolled> & java.io.Serializable & Serializable)x$4 -> x$4.headPtr(), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(UnrolledBuffer.Unrolled.class)));
        HashSet[] root = new HashSet[bucks.length];
        this.combinerTaskSupport().executeAndWaitResult(new CreateTrie(this, bucks, root, 0, bucks.length));
        int bitmap = 0;
        for (int i = 0; i < HashSetCombiner$.MODULE$.rootsize(); ++i) {
            if (this.buckets()[i] == null) continue;
            bitmap |= 1 << i;
        }
        Integer n = BoxesRunTime.boxToInteger(0);
        ArrayOps.ofRef<Object> foldLeft_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])root));
        void var11_7 = foldLeft_z;
        int n2 = foldLeft_this.length();
        for (int foldLeft_foldl_start = 0; foldLeft_foldl_start != foldLeft_foldl_end; ++foldLeft_foldl_start) {
            Object foldLeft_foldl_z;
            HashSet hashSet = (HashSet)foldLeft_this.apply(foldLeft_foldl_start);
            foldLeft_foldl_z = HashSetCombiner.$anonfun$result$3$adapted(foldLeft_foldl_z, hashSet);
        }
        int sz = BoxesRunTime.unboxToInt(var11_7);
        if (sz == 0) {
            return new ParHashSet();
        }
        if (sz == 1) {
            return new ParHashSet(root[0]);
        }
        HashSet.HashTrieSet trie = new HashSet.HashTrieSet(bitmap, root, sz);
        return new ParHashSet(trie);
    }

    public static final /* synthetic */ boolean $anonfun$result$1(UnrolledBuffer x$3) {
        return x$3 != null;
    }

    public static final /* synthetic */ int $anonfun$result$3(int x$5, HashSet x$6) {
        return x$5 + x$6.size();
    }

    public HashSetCombiner() {
        super(HashSetCombiner$.MODULE$.rootsize());
    }

    public static final /* synthetic */ Object $anonfun$result$3$adapted(Object x$5, HashSet x$6) {
        return BoxesRunTime.boxToInteger(HashSetCombiner.$anonfun$result$3(BoxesRunTime.unboxToInt(x$5), x$6));
    }

    public class CreateTrie
    implements Task<BoxedUnit, CreateTrie> {
        private final UnrolledBuffer.Unrolled<Object>[] bucks;
        private final HashSet<T>[] root;
        private final int offset;
        private final int howmany;
        private BoxedUnit result;
        private volatile Throwable throwable;
        public final /* synthetic */ HashSetCombiner $outer;

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
            int until = this.offset + this.howmany;
            for (int i = this.offset; i < until; ++i) {
                this.root[i] = this.createTrie(this.bucks[i]);
            }
        }

        /*
         * WARNING - void declaration
         */
        private HashSet<T> createTrie(UnrolledBuffer.Unrolled<Object> elems) {
            void var2_2;
            HashSet<Object> trie = new HashSet<Object>();
            int i = 0;
            for (UnrolledBuffer.Unrolled<Object> unrolled = elems; unrolled != null; unrolled = unrolled.next()) {
                Object[] chunkarr = (Object[])unrolled.array();
                int chunksz = unrolled.size();
                while (i < chunksz) {
                    Object v = chunkarr[i];
                    int hc = HashSet$.MODULE$.computeHash(v);
                    trie = trie.updated0(v, hc, HashSetCombiner$.MODULE$.rootbits());
                    ++i;
                }
                i = 0;
            }
            return var2_2;
        }

        public List<CreateTrie> split() {
            int fp = this.howmany / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new CreateTrie(this.scala$collection$parallel$immutable$HashSetCombiner$CreateTrie$$$outer(), this.bucks, this.root, this.offset, fp)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new CreateTrie(this.scala$collection$parallel$immutable$HashSetCombiner$CreateTrie$$$outer(), this.bucks, this.root, this.offset + fp, this.howmany - fp)), Nil$.MODULE$));
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany > package$.MODULE$.thresholdFromSize(this.root.length, this.scala$collection$parallel$immutable$HashSetCombiner$CreateTrie$$$outer().combinerTaskSupport().parallelismLevel());
        }

        public /* synthetic */ HashSetCombiner scala$collection$parallel$immutable$HashSetCombiner$CreateTrie$$$outer() {
            return this.$outer;
        }

        public CreateTrie(HashSetCombiner $outer, UnrolledBuffer.Unrolled<Object>[] bucks, HashSet<T>[] root, int offset, int howmany) {
            this.bucks = bucks;
            this.root = root;
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

