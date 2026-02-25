/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.TraversableLike;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.HashMap;
import scala.collection.immutable.HashMap$;
import scala.collection.immutable.List;
import scala.collection.immutable.ListMap;
import scala.collection.immutable.ListMap$;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Builder;
import scala.collection.mutable.UnrolledBuffer;
import scala.collection.parallel.BucketCombiner;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.Task;
import scala.collection.parallel.immutable.HashMapCombiner$;
import scala.collection.parallel.immutable.ParHashMap;
import scala.collection.parallel.package$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005ehA\u0002\u0017.\u0003\u0003yS\u0007C\u0003T\u0001\u0011\u0005A\u000bC\u0004V\u0001\t\u0007I\u0011\u0001,\t\rq\u0003\u0001\u0015!\u0003X\u0011\u0015i\u0006\u0001\"\u0001_\u0011\u0015\u0011\u0007\u0001\"\u0001d\u0011\u0015!\u0007\u0001\"\u0001f\u0011\u0015\u0019\b\u0001\"\u0011u\r\u0011i\b\u0001\u0001@\t\u0015\u0005M\u0001B!A!\u0002\u0013\t)\u0002\u0003\u0006\u0002@!\u0011\t\u0011)A\u0005\u0003\u0003B!\"a\u0011\t\u0005\u0003\u0005\u000b\u0011BA#\u0011)\tY\u0005\u0003B\u0001B\u0003%\u0011Q\t\u0005\u0007'\"!\t!!\u0014\t\u0011\tD\u0001\u0019!C\u0001\u0003/B\u0011\"!\u0017\t\u0001\u0004%\t!a\u0017\t\u0011\u0005\u0005\u0004\u0002)Q\u0005\u0003\u0017Aq!a\u001b\t\t\u0003\ti\u0007C\u0004\u0002z!!I!a\u001f\t\u000f\u0005\u0005\u0005\u0002\"\u0001\u0002\u0004\"9\u00111\u0012\u0005\u0005\u0002\u00055eABAK\u0001\u0001\t9\nC\u0005m+\t\u0005\t\u0015!\u0003\u0002$\"Q\u00111C\u000b\u0003\u0002\u0003\u0006I!!\u0006\t\u0015\u0005}RC!A!\u0002\u0013\t9\u000b\u0003\u0006\u0002DU\u0011\t\u0011)A\u0005\u0003\u000bB!\"a\u0013\u0016\u0005\u0003\u0005\u000b\u0011BA#\u0011\u0019\u0019V\u0003\"\u0001\u0002,\"A!-\u0006a\u0001\n\u0003\t9\u0006C\u0005\u0002ZU\u0001\r\u0011\"\u0001\u00028\"A\u0011\u0011M\u000b!B\u0013\tY\u0001C\u0004\u0002lU!\t!!0\t\u000f\u0005\u0005W\u0003\"\u0003\u0002D\"9\u0011\u0011Z\u000b\u0005\n\u0005-\u0007bBAA+\u0011\u0005\u00111\u001b\u0005\b\u0003\u0017+B\u0011AAG\u000f!\t9.\fE\u0001_\u0005ega\u0002\u0017.\u0011\u0003y\u00131\u001c\u0005\u0007'\u0016\"\t!!8\t\u000f\u0005}W\u0005\"\u0001\u0002b\"Q\u0011q^\u0013C\u0002\u0013\u0005Q&!=\t\u0011\u0005MX\u0005)A\u0005\u0003\u000bB!\"!>&\u0005\u0004%\t!LAy\u0011!\t90\nQ\u0001\n\u0005\u0015#a\u0004%bg\"l\u0015\r]\"p[\nLg.\u001a:\u000b\u00059z\u0013!C5n[V$\u0018M\u00197f\u0015\t\u0001\u0014'\u0001\u0005qCJ\fG\u000e\\3m\u0015\t\u00114'\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001N\u0001\u0006g\u000e\fG.Y\u000b\u0004m\u0005c5C\u0001\u00018!\u0019A\u0014h\u000f(<%6\tq&\u0003\u0002;_\tq!)^2lKR\u001cu.\u001c2j]\u0016\u0014\b\u0003\u0002\u001f>\u007f-k\u0011aM\u0005\u0003}M\u0012a\u0001V;qY\u0016\u0014\u0004C\u0001!B\u0019\u0001!QA\u0011\u0001C\u0002\u0011\u0013\u0011aS\u0002\u0001#\t)\u0005\n\u0005\u0002=\r&\u0011qi\r\u0002\b\u001d>$\b.\u001b8h!\ta\u0014*\u0003\u0002Kg\t\u0019\u0011I\\=\u0011\u0005\u0001cE!B'\u0001\u0005\u0004!%!\u0001,\u0011\t=\u0003vhS\u0007\u0002[%\u0011\u0011+\f\u0002\u000b!\u0006\u0014\b*Y:i\u001b\u0006\u0004\b\u0003B(\u0001\u007f-\u000ba\u0001P5oSRtD#\u0001*\u0002\u0013\u0015l\u0007\u000f^=Ue&,W#A,\u0011\taSvhS\u0007\u00023*\u0011a&M\u0005\u00037f\u0013q\u0001S1tQ6\u000b\u0007/\u0001\u0006f[B$\u0018\u0010\u0016:jK\u0002\n\u0001\u0002\n9mkN$S-\u001d\u000b\u0003?\u0002l\u0011\u0001\u0001\u0005\u0006C\u0012\u0001\raO\u0001\u0005K2,W.\u0001\u0004sKN,H\u000e\u001e\u000b\u0002\u001d\u0006QqM]8va\nK8*Z=\u0016\u0005\u0019LGCA4l!\u0011y\u0005k\u00105\u0011\u0005\u0001KG!\u00026\u0007\u0005\u0004!%\u0001\u0002*faJDQ\u0001\u001c\u0004A\u00025\f1a\u00192g!\rad\u000e]\u0005\u0003_N\u0012\u0011BR;oGRLwN\u001c\u0019\u0011\ta\n8\n[\u0005\u0003e>\u0012\u0001bQ8nE&tWM]\u0001\ti>\u001cFO]5oOR\tQ\u000f\u0005\u0002ww6\tqO\u0003\u0002ys\u0006!A.\u00198h\u0015\u0005Q\u0018\u0001\u00026bm\u0006L!\u0001`<\u0003\rM#(/\u001b8h\u0005)\u0019%/Z1uKR\u0013\u0018.Z\n\u0005\u0011}\f)\u0001E\u0002=\u0003\u0003I1!a\u00014\u0005\u0019\te.\u001f*fMB9\u0001(a\u0002\u0002\f\u0005E\u0011bAA\u0005_\t!A+Y:l!\ra\u0014QB\u0005\u0004\u0003\u001f\u0019$\u0001B+oSR\u0004\"a\u0018\u0005\u0002\u000b\t,8m[:\u0011\u000bq\n9\"a\u0007\n\u0007\u0005e1GA\u0003BeJ\f\u0017\u0010E\u0003\u0002\u001e\u0005e2H\u0004\u0003\u0002 \u0005Mb\u0002BA\u0011\u0003_qA!a\t\u0002.9!\u0011QEA\u0016\u001b\t\t9CC\u0002\u0002*\r\u000ba\u0001\u0010:p_Rt\u0014\"\u0001\u001b\n\u0005I\u001a\u0014bAA\u0019c\u00059Q.\u001e;bE2,\u0017\u0002BA\u001b\u0003o\ta\"\u00168s_2dW\r\u001a\"vM\u001a,'OC\u0002\u00022EJA!a\u000f\u0002>\tAQK\u001c:pY2,GM\u0003\u0003\u00026\u0005]\u0012\u0001\u0002:p_R\u0004B\u0001PA\f/\u00061qN\u001a4tKR\u00042\u0001PA$\u0013\r\tIe\r\u0002\u0004\u0013:$\u0018a\u00025po6\fg.\u001f\u000b\u000b\u0003#\ty%!\u0015\u0002T\u0005U\u0003bBA\n\u001b\u0001\u0007\u0011Q\u0003\u0005\b\u0003\u007fi\u0001\u0019AA!\u0011\u001d\t\u0019%\u0004a\u0001\u0003\u000bBq!a\u0013\u000e\u0001\u0004\t)%\u0006\u0002\u0002\f\u0005Q!/Z:vYR|F%Z9\u0015\t\u0005-\u0011Q\f\u0005\n\u0003?z\u0011\u0011!a\u0001\u0003\u0017\t1\u0001\u001f\u00132\u0003\u001d\u0011Xm];mi\u0002B3\u0001EA3!\ra\u0014qM\u0005\u0004\u0003S\u001a$\u0001\u0003<pY\u0006$\u0018\u000e\\3\u0002\t1,\u0017M\u001a\u000b\u0005\u0003\u0017\ty\u0007C\u0004\u0002rE\u0001\r!a\u001d\u0002\tA\u0014XM\u001e\t\u0006y\u0005U\u00141B\u0005\u0004\u0003o\u001a$AB(qi&|g.\u0001\u0006de\u0016\fG/\u001a+sS\u0016$2aVA?\u0011\u001d\tyH\u0005a\u0001\u00037\tQ!\u001a7f[N\fQa\u001d9mSR,\"!!\"\u0011\u000ba\u000b9)!\u0005\n\u0007\u0005%\u0015L\u0001\u0003MSN$\u0018AE:i_VdGm\u00159mSR4UO\u001d;iKJ,\"!a$\u0011\u0007q\n\t*C\u0002\u0002\u0014N\u0012qAQ8pY\u0016\fgNA\tDe\u0016\fG/Z$s_V\u0004X\r\u001a+sS\u0016,B!!'\u0002\"N!Qc`AN!\u001dA\u0014qAA\u0006\u0003;\u0003BaX\u000b\u0002 B\u0019\u0001)!)\u0005\u000b),\"\u0019\u0001#\u0011\tqr\u0017Q\u0015\t\u0006qE\\\u0015q\u0014\t\u0006y\u0005]\u0011\u0011\u0016\t\u00051j{t\u0010\u0006\u0007\u0002\u001e\u00065\u0016qVAY\u0003g\u000b)\f\u0003\u0004m7\u0001\u0007\u00111\u0015\u0005\b\u0003'Y\u0002\u0019AA\u000b\u0011\u001d\tyd\u0007a\u0001\u0003OCq!a\u0011\u001c\u0001\u0004\t)\u0005C\u0004\u0002Lm\u0001\r!!\u0012\u0015\t\u0005-\u0011\u0011\u0018\u0005\n\u0003?j\u0012\u0011!a\u0001\u0003\u0017A3AHA3)\u0011\tY!a0\t\u000f\u0005Et\u00041\u0001\u0002t\u0005\t2M]3bi\u0016<%o\\;qK\u0012$&/[3\u0015\t\u0005\u0015\u0017q\u0019\t\u00061j{\u0014q\u0014\u0005\b\u0003\u007f\u0002\u0003\u0019AA\u000e\u0003E)g/\u00197vCR,7i\\7cS:,'o\u001d\u000b\u0005\u0003\u000b\fi\rC\u0004\u0002P\u0006\u0002\r!!5\u0002\tQ\u0014\u0018.\u001a\t\u00061j{\u0014QU\u000b\u0003\u0003+\u0004R\u0001WAD\u0003;\u000bq\u0002S1tQ6\u000b\u0007oQ8nE&tWM\u001d\t\u0003\u001f\u0016\u001a\"!J@\u0015\u0005\u0005e\u0017!B1qa2LXCBAr\u0003S\fi/\u0006\u0002\u0002fB1q\nAAt\u0003W\u00042\u0001QAu\t\u0015\u0011uE1\u0001E!\r\u0001\u0015Q\u001e\u0003\u0006\u001b\u001e\u0012\r\u0001R\u0001\te>|GOY5ugV\u0011\u0011QI\u0001\ne>|GOY5ug\u0002\n\u0001B]8piNL'0Z\u0001\ne>|Go]5{K\u0002\u0002")
public abstract class HashMapCombiner<K, V>
extends BucketCombiner<Tuple2<K, V>, ParHashMap<K, V>, Tuple2<K, V>, HashMapCombiner<K, V>> {
    private final HashMap<K, V> emptyTrie = HashMap$.MODULE$.empty();

    public static <K, V> HashMapCombiner<K, V> apply() {
        return HashMapCombiner$.MODULE$.apply();
    }

    public HashMap<K, V> emptyTrie() {
        return this.emptyTrie;
    }

    @Override
    public HashMapCombiner<K, V> $plus$eq(Tuple2<K, V> elem) {
        this.sz_$eq(this.sz() + 1);
        int pos = this.emptyTrie().computeHash(elem._1()) & 0x1F;
        if (this.buckets()[pos] == null) {
            this.buckets()[pos] = new UnrolledBuffer(ClassTag$.MODULE$.apply(Tuple2.class));
        }
        this.buckets()[pos].$plus$eq(elem);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ParHashMap<K, V> result() {
        void foldLeft_foldl_end;
        void foldLeft_z;
        UnrolledBuffer.Unrolled[] bucks = (UnrolledBuffer.Unrolled[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.buckets())).filterImpl((Function1<UnrolledBuffer, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(HashMapCombiner.$anonfun$result$1(x$3)), false))), (Function1<UnrolledBuffer, UnrolledBuffer.Unrolled> & java.io.Serializable & Serializable)x$4 -> x$4.headPtr(), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(UnrolledBuffer.Unrolled.class)));
        HashMap[] root = new HashMap[bucks.length];
        this.combinerTaskSupport().executeAndWaitResult(new CreateTrie(this, bucks, root, 0, bucks.length));
        int bitmap = 0;
        for (int i = 0; i < HashMapCombiner$.MODULE$.rootsize(); ++i) {
            if (this.buckets()[i] == null) continue;
            bitmap |= 1 << i;
        }
        Integer n = BoxesRunTime.boxToInteger(0);
        ArrayOps.ofRef<Object> foldLeft_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])root));
        void var11_7 = foldLeft_z;
        int n2 = foldLeft_this.length();
        for (int foldLeft_foldl_start = 0; foldLeft_foldl_start != foldLeft_foldl_end; ++foldLeft_foldl_start) {
            Object foldLeft_foldl_z;
            HashMap hashMap = (HashMap)foldLeft_this.apply(foldLeft_foldl_start);
            foldLeft_foldl_z = HashMapCombiner.$anonfun$result$3$adapted(foldLeft_foldl_z, hashMap);
        }
        int sz = BoxesRunTime.unboxToInt(var11_7);
        if (sz == 0) {
            return new ParHashMap();
        }
        if (sz == 1) {
            return new ParHashMap(root[0]);
        }
        HashMap.HashTrieMap trie = new HashMap.HashTrieMap(bitmap, root, sz);
        return new ParHashMap(trie);
    }

    /*
     * WARNING - void declaration
     */
    public <Repr> ParHashMap<K, Repr> groupByKey(Function0<Combiner<V, Repr>> cbf) {
        void foldLeft_foldl_end;
        void foldLeft_z;
        UnrolledBuffer.Unrolled[] bucks = (UnrolledBuffer.Unrolled[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.buckets())).filterImpl((Function1<UnrolledBuffer, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToBoolean(HashMapCombiner.$anonfun$groupByKey$1(x$7)), false))), (Function1<UnrolledBuffer, UnrolledBuffer.Unrolled> & java.io.Serializable & Serializable)x$8 -> x$8.headPtr(), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(UnrolledBuffer.Unrolled.class)));
        HashMap[] root = new HashMap[bucks.length];
        this.combinerTaskSupport().executeAndWaitResult(new CreateGroupedTrie<Repr>(this, cbf, bucks, root, 0, bucks.length));
        int bitmap = 0;
        for (int i = 0; i < HashMapCombiner$.MODULE$.rootsize(); ++i) {
            if (this.buckets()[i] == null) continue;
            bitmap |= 1 << i;
        }
        Integer n = BoxesRunTime.boxToInteger(0);
        ArrayOps.ofRef<Object> foldLeft_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])root));
        void var12_8 = foldLeft_z;
        int n2 = foldLeft_this.length();
        for (int foldLeft_foldl_start = 0; foldLeft_foldl_start != foldLeft_foldl_end; ++foldLeft_foldl_start) {
            Object foldLeft_foldl_z;
            HashMap hashMap = (HashMap)foldLeft_this.apply(foldLeft_foldl_start);
            foldLeft_foldl_z = HashMapCombiner.$anonfun$groupByKey$3$adapted(foldLeft_foldl_z, hashMap);
        }
        int sz = BoxesRunTime.unboxToInt(var12_8);
        if (sz == 0) {
            return new ParHashMap();
        }
        if (sz == 1) {
            return new ParHashMap(root[0]);
        }
        HashMap.HashTrieMap trie = new HashMap.HashTrieMap(bitmap, root, sz);
        return new ParHashMap(trie);
    }

    public String toString() {
        return new StringBuilder(22).append("HashTrieCombiner(sz: ").append(this.size()).append(")").toString();
    }

    public static final /* synthetic */ boolean $anonfun$result$1(UnrolledBuffer x$3) {
        return x$3 != null;
    }

    public static final /* synthetic */ int $anonfun$result$3(int x$5, HashMap x$6) {
        return x$5 + x$6.size();
    }

    public static final /* synthetic */ boolean $anonfun$groupByKey$1(UnrolledBuffer x$7) {
        return x$7 != null;
    }

    public static final /* synthetic */ int $anonfun$groupByKey$3(int x$9, HashMap x$10) {
        return x$9 + x$10.size();
    }

    public HashMapCombiner() {
        super(HashMapCombiner$.MODULE$.rootsize());
    }

    public static final /* synthetic */ Object $anonfun$result$3$adapted(Object x$5, HashMap x$6) {
        return BoxesRunTime.boxToInteger(HashMapCombiner.$anonfun$result$3(BoxesRunTime.unboxToInt(x$5), x$6));
    }

    public static final /* synthetic */ Object $anonfun$groupByKey$3$adapted(Object x$9, HashMap x$10) {
        return BoxesRunTime.boxToInteger(HashMapCombiner.$anonfun$groupByKey$3(BoxesRunTime.unboxToInt(x$9), x$10));
    }

    public class CreateGroupedTrie<Repr>
    implements Task<BoxedUnit, CreateGroupedTrie<Repr>> {
        private final Function0<Combiner<V, Repr>> cbf;
        private final UnrolledBuffer.Unrolled<Tuple2<K, V>>[] bucks;
        private final HashMap<K, Object>[] root;
        private final int offset;
        private final int howmany;
        private volatile BoxedUnit result;
        private volatile Throwable throwable;
        public final /* synthetic */ HashMapCombiner $outer;

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
                this.root[i] = this.createGroupedTrie(this.bucks[i]);
            }
            this.result();
            this.result_$eq(BoxedUnit.UNIT);
        }

        private HashMap<K, Repr> createGroupedTrie(UnrolledBuffer.Unrolled<Tuple2<K, V>> elems) {
            HashMap<Object, Object> trie = new HashMap();
            int i = 0;
            for (UnrolledBuffer.Unrolled unrolled = elems; unrolled != null; unrolled = unrolled.next()) {
                Tuple2[] chunkarr = (Tuple2[])unrolled.array();
                int chunksz = unrolled.size();
                while (i < chunksz) {
                    Combiner combiner;
                    Tuple2 kv = chunkarr[i];
                    int hc = trie.computeHash(kv._1());
                    Option option = trie.get0(kv._1(), hc, HashMapCombiner$.MODULE$.rootbits());
                    if (option instanceof Some) {
                        combiner = (Combiner)((Some)option).value();
                    } else if (None$.MODULE$.equals(option)) {
                        Combiner cmb = this.cbf.apply();
                        trie = trie.updated0(kv._1(), hc, HashMapCombiner$.MODULE$.rootbits(), cmb, null, null);
                        combiner = cmb;
                    } else {
                        throw new MatchError(option);
                    }
                    combiner.$plus$eq((Object)kv._2());
                    ++i;
                }
                i = 0;
            }
            return this.evaluateCombiners(trie);
        }

        private HashMap<K, Repr> evaluateCombiners(HashMap<K, Combiner<V, Repr>> trie) {
            HashMap hashMap;
            if (trie instanceof HashMap.HashMap1) {
                HashMap.HashMap1 hashMap1 = (HashMap.HashMap1)((Object)trie);
                Object evaledvalue = ((Builder)hashMap1.value()).result();
                hashMap = new HashMap.HashMap1(hashMap1.key(), hashMap1.hash(), evaledvalue, null);
            } else if (trie instanceof HashMap.HashMapCollision1) {
                HashMap.HashMapCollision1 hashMapCollision1 = (HashMap.HashMapCollision1)((Object)trie);
                ListMap evaledkvs = hashMapCollision1.kvs().map((Function1<Tuple2, Tuple2> & java.io.Serializable & Serializable)p -> new Tuple2(p._1(), ((Builder)p._2()).result()), ListMap$.MODULE$.canBuildFrom());
                hashMap = new HashMap.HashMapCollision1(hashMapCollision1.hash(), evaledkvs);
            } else if (trie instanceof HashMap.HashTrieMap) {
                HashMap.HashTrieMap hashTrieMap = trie;
                int i = 0;
                while (true) {
                    if (hashTrieMap == null) {
                        throw null;
                    }
                    if (i >= hashTrieMap.elems0().length) break;
                    hashTrieMap.elems0()[i] = this.evaluateCombiners(hashTrieMap.elems0()[i]);
                    ++i;
                }
                hashMap = hashTrieMap;
            } else {
                hashMap = trie;
            }
            return hashMap;
        }

        public List<CreateGroupedTrie<Repr>> split() {
            int fp = this.howmany / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new CreateGroupedTrie<Repr>(this.scala$collection$parallel$immutable$HashMapCombiner$CreateGroupedTrie$$$outer(), this.cbf, this.bucks, this.root, this.offset, fp)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new CreateGroupedTrie<Repr>(this.scala$collection$parallel$immutable$HashMapCombiner$CreateGroupedTrie$$$outer(), this.cbf, this.bucks, this.root, this.offset + fp, this.howmany - fp)), Nil$.MODULE$));
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany > package$.MODULE$.thresholdFromSize(this.root.length, this.scala$collection$parallel$immutable$HashMapCombiner$CreateGroupedTrie$$$outer().combinerTaskSupport().parallelismLevel());
        }

        public /* synthetic */ HashMapCombiner scala$collection$parallel$immutable$HashMapCombiner$CreateGroupedTrie$$$outer() {
            return this.$outer;
        }

        public CreateGroupedTrie(HashMapCombiner $outer, Function0<Combiner<V, Repr>> cbf, UnrolledBuffer.Unrolled<Tuple2<K, V>>[] bucks, HashMap<K, Object>[] root, int offset, int howmany) {
            this.cbf = cbf;
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

    public class CreateTrie
    implements Task<BoxedUnit, CreateTrie> {
        private final UnrolledBuffer.Unrolled<Tuple2<K, V>>[] bucks;
        private final HashMap<K, V>[] root;
        private final int offset;
        private final int howmany;
        private volatile BoxedUnit result;
        private volatile Throwable throwable;
        public final /* synthetic */ HashMapCombiner $outer;

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
            this.result();
            this.result_$eq(BoxedUnit.UNIT);
        }

        /*
         * WARNING - void declaration
         */
        private HashMap<K, V> createTrie(UnrolledBuffer.Unrolled<Tuple2<K, V>> elems) {
            void var2_2;
            HashMap<Object, Object> trie = new HashMap();
            int i = 0;
            for (UnrolledBuffer.Unrolled unrolled = elems; unrolled != null; unrolled = unrolled.next()) {
                Tuple2[] chunkarr = (Tuple2[])unrolled.array();
                int chunksz = unrolled.size();
                while (i < chunksz) {
                    Tuple2 kv = chunkarr[i];
                    int hc = trie.computeHash(kv._1());
                    trie = trie.updated0(kv._1(), hc, HashMapCombiner$.MODULE$.rootbits(), kv._2(), kv, null);
                    ++i;
                }
                i = 0;
            }
            return var2_2;
        }

        public List<CreateTrie> split() {
            int fp = this.howmany / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new CreateTrie(this.scala$collection$parallel$immutable$HashMapCombiner$CreateTrie$$$outer(), this.bucks, this.root, this.offset, fp)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new CreateTrie(this.scala$collection$parallel$immutable$HashMapCombiner$CreateTrie$$$outer(), this.bucks, this.root, this.offset + fp, this.howmany - fp)), Nil$.MODULE$));
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany > package$.MODULE$.thresholdFromSize(this.root.length, this.scala$collection$parallel$immutable$HashMapCombiner$CreateTrie$$$outer().combinerTaskSupport().parallelismLevel());
        }

        public /* synthetic */ HashMapCombiner scala$collection$parallel$immutable$HashMapCombiner$CreateTrie$$$outer() {
            return this.$outer;
        }

        public CreateTrie(HashMapCombiner $outer, UnrolledBuffer.Unrolled<Tuple2<K, V>>[] bucks, HashMap<K, V>[] root, int offset, int howmany) {
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

