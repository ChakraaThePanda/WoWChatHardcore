/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Map;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParMap;
import scala.collection.parallel.mutable.ParMap$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015haB\f\u0019!\u0003\r\ta\b\u0005\u0006=\u0002!\ta\u0018\u0005\u0007G\u0002\u0001K\u0011\u000b3\t\r\u0015\u0004\u0001\u0015\"\u0015g\u0011\u0015Y\u0007\u0001\"\u0011m\u0011\u0015\u0001\b\u0001\"\u0001r\u0011\u0015I\b\u0001\"\u0001{\u0011\u0015i\bA\"\u0001\u007f\u0011\u001d\t)\u0001\u0001C!\u0003\u000fAq!!\u0007\u0001\t\u0003\tY\u0002C\u0004\u0002\u001a\u0001!\t%a\u0010\t\u000f\u0005}\u0003\u0001\"\u0011\u0002b!9\u0011Q\u0010\u0001\u0005\u0002\u0005}\u0004bBAB\u0001\u0019\u0005\u0011Q\u0011\u0005\b\u0003\u0013\u0003A\u0011IAF\u0011\u0019\t)\n\u0001C\u0001?\"9\u0011q\u0013\u0001\u0005\u0002\u0005e\u0005bBAT\u0001\u0011\u0005\u0011\u0011\u0016\u0005\b\u0003k\u0003A\u0011AA\\\u0011\u001d\t)\r\u0001C!\u0003\u000fDq!!3\u0001\t\u0003\t9\rC\u0004\u0002\n\u0002!\t%a3\t\u000f\u0005]\u0007\u0001\"\u0011\u0002Z\n9Q*\u00199MS.,'BA\r\u001b\u0003\u001diW\u000f^1cY\u0016T!a\u0007\u000f\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u001e\u0003\u0015\u00198-\u00197b\u0007\u0001)B\u0001\t\u00165oMA\u0001!I\u0013C\u0011:\u000bF\u000b\u0005\u0002#G5\tA$\u0003\u0002%9\t1\u0011I\\=SK\u001a\u0004RAJ\u0014)gYj\u0011AG\u0005\u0003/i\u0001\"!\u000b\u0016\r\u0001\u0011)1\u0006\u0001b\u0001Y\t\t1*\u0005\u0002.aA\u0011!EL\u0005\u0003_q\u0011qAT8uQ&tw\r\u0005\u0002#c%\u0011!\u0007\b\u0002\u0004\u0003:L\bCA\u00155\t\u0015)\u0004A1\u0001-\u0005\u00051\u0006CA\u00158\t\u0019A\u0004\u0001\"b\u0001s\t!A\u000b[5t#\ti#HE\u0002<{}2A\u0001\u0010\u0001\u0001u\taAH]3gS:,W.\u001a8u}A)a\b\u0001\u00154m5\t\u0001\u0004\u0005\u0003?\u0001\"\u001a\u0014BA!\u0019\u0005\ri\u0015\r\u001d\t\u0005}\r+e'\u0003\u0002E1\t9!)^5mI\u0016\u0014\b\u0003\u0002\u0012GQMJ!a\u0012\u000f\u0003\rQ+\b\u000f\\33!\rIE*R\u0007\u0002\u0015*\u00111JG\u0001\bO\u0016tWM]5d\u0013\ti%J\u0001\u0005He><\u0018M\u00197f!\rIu\nK\u0005\u0003!*\u0013!b\u00155sS:\\\u0017M\u00197f!\rq$KN\u0005\u0003'b\u0011\u0011b\u00117p]\u0016\f'\r\\3\u0011\t\u0019*ViV\u0005\u0003-j\u0011a\u0002U1sC2dW\r\\5{C\ndW\r\u0005\u0003Y9\"\u001aT\"A-\u000b\u0005eQ&BA.\u001b\u0003!\u0001\u0018M]1mY\u0016d\u0017BA/Z\u0005\u0019\u0001\u0016M]'ba\u00061A%\u001b8ji\u0012\"\u0012\u0001\u0019\t\u0003E\u0005L!A\u0019\u000f\u0003\tUs\u0017\u000e^\u0001\u000b]\u0016<()^5mI\u0016\u0014X#\u0001\"\u0002\u0017A\f'oQ8nE&tWM]\u000b\u0002OB!\u0001.[#X\u001b\u0005Q\u0016B\u00016[\u0005!\u0019u.\u001c2j]\u0016\u0014\u0018!\u0002;p'\u0016\fX#A7\u0011\u0007\u0019rW)\u0003\u0002p5\t\u00191+Z9\u0002\u0007A,H\u000fF\u0002sk^\u00042AI:4\u0013\t!HD\u0001\u0004PaRLwN\u001c\u0005\u0006m\u0016\u0001\r\u0001K\u0001\u0004W\u0016L\b\"\u0002=\u0006\u0001\u0004\u0019\u0014!\u0002<bYV,\u0017AB;qI\u0006$X\rF\u0002awrDQA\u001e\u0004A\u0002!BQ\u0001\u001f\u0004A\u0002M\n\u0001\u0002\n9mkN$S-\u001d\u000b\u0004\u007f\u0006\u0005Q\"\u0001\u0001\t\r\u0005\rq\u00011\u0001F\u0003\tYg/A\u0004va\u0012\fG/\u001a3\u0016\t\u0005%\u0011q\u0002\u000b\u0007\u0003\u0017\t)\"a\u0006\u0011\u000by\u0002\u0005&!\u0004\u0011\u0007%\ny\u0001B\u0004\u0002\u0012!\u0011\r!a\u0005\u0003\u0005Y\u000b\u0014CA\u001a1\u0011\u00151\b\u00021\u0001)\u0011\u0019A\b\u00021\u0001\u0002\u000e\u0005)A\u0005\u001d7vgV!\u0011QDA\u0012)\u0011\ty\"!\n\u0011\u000by\u0002\u0005&!\t\u0011\u0007%\n\u0019\u0003B\u0004\u0002\u0012%\u0011\r!a\u0005\t\u000f\u0005\r\u0011\u00021\u0001\u0002(A)!E\u0012\u0015\u0002\"!:\u0011\"a\u000b\u00028\u0005m\u0002\u0003BA\u0017\u0003gi!!a\f\u000b\u0007\u0005EB$\u0001\u0006b]:|G/\u0019;j_:LA!!\u000e\u00020\tIQ.[4sCRLwN\\\u0011\u0003\u0003s\t\u0011\fY\u0016aA\r\u0014X-\u0019;fg\u0002\n\u0007E\\3xA5\f\u0007O\f\u0011Vg\u0016\u0004\u0003mK\u001faAQ|\u0007%\u00193eA\u0005t\u0007%\u001a7f[\u0016tG\u000f\t;pAQD\u0017n\u001d\u0011nCB\u0004\u0013M\u001c3!e\u0016$XO\u001d8!i\"\fG\u000fI7ba\u0002JGo]3mM:\n#!!\u0010\u0002\u000bIr\u0003H\f\u0019\u0016\t\u0005\u0005\u0013q\t\u000b\t\u0003\u0007\nI%a\u0014\u0002TA)a\b\u0011\u0015\u0002FA\u0019\u0011&a\u0012\u0005\u000f\u0005E!B1\u0001\u0002\u0014!9\u00111\n\u0006A\u0002\u00055\u0013!B3mK6\f\u0004#\u0002\u0012GQ\u0005\u0015\u0003bBA)\u0015\u0001\u0007\u0011QJ\u0001\u0006K2,WN\r\u0005\b\u0003+R\u0001\u0019AA,\u0003\u0015)G.Z7t!\u0015\u0011\u0013\u0011LA'\u0013\r\tY\u0006\b\u0002\u000byI,\u0007/Z1uK\u0012t\u0004f\u0002\u0006\u0002,\u0005]\u00121H\u0001\u000bIAdWo\u001d\u0013qYV\u001cX\u0003BA2\u0003S\"B!!\u001a\u0002lA)a\b\u0011\u0015\u0002hA\u0019\u0011&!\u001b\u0005\u000f\u0005E1B1\u0001\u0002\u0014!9\u0011QN\u0006A\u0002\u0005=\u0014A\u0001=t!\u00151\u0013\u0011OA;\u0013\r\t\u0019H\u0007\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\rE\u0003#\r\"\n9\u0007K\u0004\f\u0003W\tI(a\u000f\"\u0005\u0005m\u0014a\u00171,W\u0001\u00043M]3bi\u0016\u001c\b%\u0019\u0011oK^\u0004S.\u00199/AU\u001bX\r\t1,Wu\u0002\u0007\u0005^8!C\u0012$\u0007%\u00198!K2,W.\u001a8uAQ|\u0007\u0005\u001e5jg\u0002j\u0017\r\u001d\u0011b]\u0012\u0004#/\u001a;ve:\u0004C\u000f[1uA5\f\u0007\u000fI5ug\u0016dgML\u0001\u0007e\u0016lwN^3\u0015\u0007I\f\t\tC\u0003w\u0019\u0001\u0007\u0001&A\u0005%[&tWo\u001d\u0013fcR\u0019q0a\"\t\u000bYl\u0001\u0019\u0001\u0015\u0002\r\u0011j\u0017N\\;t)\r1\u0014Q\u0012\u0005\u0006m:\u0001\r\u0001\u000b\u0015\b\u001d\u0005-\u0012\u0011SA\u001eC\t\t\u0019*\u00010a[\u0001\u00043M]3bi\u0016\u001c\b%\u0019\u0011oK^\u0004S.\u00199/AU\u001bX\r\t1.{\u0001\u0004Co\u001c\u0011sK6|g/\u001a\u0011b]\u0002*G.Z7f]R\u0004cM]8nAQD\u0017n\u001d\u0011nCB\u0004\u0013M\u001c3!e\u0016$XO\u001d8!i\"\fG\u000fI7ba\u0002JGo]3mM:\nQa\u00197fCJ\fqbZ3u\u001fJ,En]3Va\u0012\fG/\u001a\u000b\u0006g\u0005m\u0015Q\u0014\u0005\u0006mB\u0001\r\u0001\u000b\u0005\t\u0003?\u0003B\u00111\u0001\u0002\"\u0006\u0011q\u000e\u001d\t\u0005E\u0005\r6'C\u0002\u0002&r\u0011\u0001\u0002\u00102z]\u0006lWMP\u0001\niJ\fgn\u001d4pe6$2a`AV\u0011\u001d\ti+\u0005a\u0001\u0003_\u000b\u0011A\u001a\t\u0007E\u0005E\u0006fM\u001a\n\u0007\u0005MFDA\u0005Gk:\u001cG/[8oe\u00051!/\u001a;bS:$2a`A]\u0011\u001d\tYL\u0005a\u0001\u0003{\u000b\u0011\u0001\u001d\t\bE\u0005E\u0006fMA`!\r\u0011\u0013\u0011Y\u0005\u0004\u0003\u0007d\"a\u0002\"p_2,\u0017M\\\u0001\u0006G2|g.\u001a\u000b\u0002m\u00051!/Z:vYR$rANAg\u0003\u001f\f\t\u000e\u0003\u0004\u0002LU\u0001\r\u0001\u000b\u0005\u0007\u0003#*\u0002\u0019\u0001\u0015\t\u000f\u0005US\u00031\u0001\u0002TB!!%!\u0017)Q\u001d)\u00121FAI\u0003w\tA\u0002J7j]V\u001cH%\\5okN$2ANAn\u0011\u001d\tiG\u0006a\u0001\u0003;\u0004BAJA9Q!:a#a\u000b\u0002b\u0006m\u0012EAAr\u0003\u0001\u0004W&\f1!GJ,\u0017\r^3tA\u0005\u0004c.Z<![\u0006\u0004h\u0006I+tK\u0002\u0002W&L\u001faAQ|\u0007E]3n_Z,\u0007%\u00198!K2,W.\u001a8uA\u0019\u0014x.\u001c\u0011uQ&\u001c\b%\\1qA\u0005tG\r\t:fiV\u0014h\u000e\t;iCR\u0004S.\u00199!SR\u001cX\r\u001c4/\u0001")
public interface MapLike<K, V, This extends MapLike<K, V, This> & Map<K, V>>
extends scala.collection.MapLike<K, V, This>,
Builder<Tuple2<K, V>, This>,
Shrinkable<K>,
Cloneable<This> {
    public static /* synthetic */ Builder newBuilder$(MapLike $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<Tuple2<K, V>, This> newBuilder() {
        return (Builder)this.empty();
    }

    public static /* synthetic */ Combiner parCombiner$(MapLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
        return ParMap$.MODULE$.newCombiner();
    }

    public static /* synthetic */ Seq toSeq$(MapLike $this) {
        return $this.toSeq();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public Seq<Tuple2<K, V>> toSeq() {
        void var1_1;
        ArrayBuffer result2 = new ArrayBuffer(this.size());
        this.foreach((Function1<Tuple2, ArrayBuffer> & java.io.Serializable & Serializable)x$1 -> result2.$plus$eq(x$1));
        return var1_1;
    }

    public static /* synthetic */ Option put$(MapLike $this, Object key, Object value) {
        return $this.put(key, value);
    }

    /*
     * WARNING - void declaration
     */
    default public Option<V> put(K key, V value) {
        void var3_3;
        Option r = this.get(key);
        this.update(key, value);
        return var3_3;
    }

    public static /* synthetic */ void update$(MapLike $this, Object key, Object value) {
        $this.update(key, value);
    }

    default public void update(K key, V value) {
        this.$plus$eq(new Tuple2<K, V>(key, value));
    }

    public MapLike<K, V, This> $plus$eq(Tuple2<K, V> var1);

    public static /* synthetic */ Map updated$(MapLike $this, Object key, Object value) {
        return $this.updated(key, value);
    }

    @Override
    default public <V1> Map<K, V1> updated(K key, V1 value) {
        return this.$plus(new Tuple2<K, V1>(key, value));
    }

    public static /* synthetic */ Map $plus$(MapLike $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <V1> Map<K, V1> $plus(Tuple2<K, V1> kv) {
        return (Map)this.clone().$plus$eq(kv);
    }

    public static /* synthetic */ Map $plus$(MapLike $this, Tuple2 elem1, Tuple2 elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public <V1> Map<K, V1> $plus(Tuple2<K, V1> elem1, Tuple2<K, V1> elem2, Seq<Tuple2<K, V1>> elems) {
        return (Map)this.clone().$plus$eq(elem1).$plus$eq(elem2).$plus$plus$eq(elems);
    }

    public static /* synthetic */ Map $plus$plus$(MapLike $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <V1> Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
        return (Map)this.clone().$plus$plus$eq(xs.seq());
    }

    public static /* synthetic */ Option remove$(MapLike $this, Object key) {
        return $this.remove(key);
    }

    /*
     * WARNING - void declaration
     */
    default public Option<V> remove(K key) {
        void var2_2;
        Option r = this.get(key);
        this.$minus$eq(key);
        return var2_2;
    }

    public MapLike<K, V, This> $minus$eq(K var1);

    public static /* synthetic */ Map $minus$(MapLike $this, Object key) {
        return $this.$minus((K)key);
    }

    @Override
    default public This $minus(K key) {
        return (This)((Map)this.clone().$minus$eq(key));
    }

    public static /* synthetic */ void clear$(MapLike $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        this.keysIterator().foreach((Function1<Object, MapLike> & java.io.Serializable & Serializable)key -> this.$minus$eq((K)key));
    }

    public static /* synthetic */ Object getOrElseUpdate$(MapLike $this, Object key, Function0 op) {
        return $this.getOrElseUpdate(key, op);
    }

    default public V getOrElseUpdate(K key, Function0<V> op) {
        Object object;
        Option option = this.get(key);
        if (option instanceof Some) {
            object = ((Some)option).value();
        } else if (None$.MODULE$.equals(option)) {
            V d = op.apply();
            this.update(key, d);
            object = d;
        } else {
            throw new MatchError(option);
        }
        return (V)object;
    }

    public static /* synthetic */ MapLike transform$(MapLike $this, Function2 f) {
        return $this.transform(f);
    }

    default public MapLike<K, V, This> transform(Function2<K, V, V> f) {
        this.iterator().foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> {
            MapLike.$anonfun$transform$1(this, f, x0$1);
            return BoxedUnit.UNIT;
        });
        return this;
    }

    public static /* synthetic */ MapLike retain$(MapLike $this, Function2 p) {
        return $this.retain(p);
    }

    default public MapLike<K, V, This> retain(Function2<K, V, Object> p) {
        this.toList().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$1 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$2 -> {
            Object v;
            if (x$2 == null) {
                throw new MatchError((Object)null);
            }
            Object k = x$2._1();
            BoxedUnit boxedUnit = !BoxesRunTime.unboxToBoolean(p.apply(k, v = x$2._2())) ? this.$minus$eq((K)k) : BoxedUnit.UNIT;
            return boxedUnit;
        });
        return this;
    }

    public static /* synthetic */ Map clone$(MapLike $this) {
        return $this.clone();
    }

    @Override
    default public This clone() {
        return (This)((Map)((Growable)this.empty()).$plus$plus$eq((TraversableOnce)this.repr()));
    }

    public static /* synthetic */ Map result$(MapLike $this) {
        return $this.result();
    }

    @Override
    default public This result() {
        return (This)((Map)this.repr());
    }

    public static /* synthetic */ Map $minus$(MapLike $this, Object elem1, Object elem2, Seq elems) {
        return $this.$minus((K)elem1, (K)elem2, elems);
    }

    @Override
    default public This $minus(K elem1, K elem2, Seq<K> elems) {
        return (This)((Map)this.clone().$minus$eq(elem1).$minus$eq(elem2).$minus$minus$eq(elems));
    }

    public static /* synthetic */ Map $minus$minus$(MapLike $this, GenTraversableOnce xs) {
        return $this.$minus$minus(xs);
    }

    @Override
    default public This $minus$minus(GenTraversableOnce<K> xs) {
        return (This)((Map)this.clone().$minus$minus$eq(xs.seq()));
    }

    public static /* synthetic */ void $anonfun$transform$1(MapLike $this, Function2 f$1, Tuple2 x0$1) {
        if (x0$1 != null) {
            Object key = x0$1._1();
            Object value = x0$1._2();
            $this.update(key, f$1.apply(key, value));
            return;
        }
        throw new MatchError((Object)null);
    }

    public static void $init$(MapLike $this) {
    }
}

