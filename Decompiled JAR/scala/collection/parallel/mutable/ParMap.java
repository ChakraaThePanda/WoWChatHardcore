/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Function1;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Map;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParMap;
import scala.collection.parallel.mutable.ParHashMap;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ParMap$;
import scala.collection.parallel.mutable.ParMapLike;
import scala.collection.parallel.mutable.ParSeq;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005%ha\u0002\u0010 !\u0003\r\t\u0001\u000b\u0005\u00065\u0002!\ta\u0017\u0005\u0007?\u0002\u0001K\u0011\u000b1\t\u000b\u0011\u0004A\u0011I3\t\u000b%\u0004A\u0011\t6\t\u000b-\u0004a\u0011\u00017\t\u000b5\u0004A\u0011\t8\t\u000be\u0004A\u0011\u0001>\t\u000f\u0005\u0005\u0001\u0001\"\u0001\u0002\u0004\u001d9\u0011qA\u0010\t\u0002\u0005%aA\u0002\u0010 \u0011\u0003\tY\u0001C\u0004\u0002\u0014)!\t!!\u0006\t\r%TA\u0011AA\f\u0011\u0019y&\u0002\"\u0001\u0002&!9\u0011q\u0007\u0006\u0005\u0004\u0005ebABA.\u0015\u0001\ti\u0006\u0003\u0006\u0002\b>\u0011\t\u0011)A\u0005\u0003\u000bC\u0011\u0002`\b\u0003\u0002\u0003\u0006I!!#\t\u000f\u0005Mq\u0002\"\u0001\u0002\f\"9\u00111S\b\u0005B\u0005U\u0005bBAP\u001f\u0011\u0005\u0011\u0011\u0015\u0005\u0007S>!\t%!*\t\r5|A\u0011IAT\u0011\u001d\t9l\u0004C!\u0003sCq!a2\u0010\t\u0003\nI\r\u0003\u0004l\u001f\u0011\u0005\u0013Q\u001a\u0005\u0007\u0003#|A\u0011A.\t\u000f\u0005Mw\u0002\"\u0001\u0002V\"1\u0011p\u0004C!\u0003CDq!!\u0001\u0010\t\u0003\n)O\u0001\u0004QCJl\u0015\r\u001d\u0006\u0003A\u0005\nq!\\;uC\ndWM\u0003\u0002#G\u0005A\u0001/\u0019:bY2,GN\u0003\u0002%K\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003\u0019\nQa]2bY\u0006\u001c\u0001!F\u0002*iy\u001ar\u0001\u0001\u0016/\u0001\u000eS\u0015\u000b\u0005\u0002,Y5\tQ%\u0003\u0002.K\t1\u0011I\\=SK\u001a\u0004Ba\f\u00193{5\t1%\u0003\u00022G\t1q)\u001a8NCB\u0004\"a\r\u001b\r\u0001\u0011)Q\u0007\u0001b\u0001m\t\t1*\u0005\u00028uA\u00111\u0006O\u0005\u0003s\u0015\u0012qAT8uQ&tw\r\u0005\u0002,w%\u0011A(\n\u0002\u0004\u0003:L\bCA\u001a?\t\u0015y\u0004A1\u00017\u0005\u00051\u0006\u0003B!Ceuj\u0011!I\u0005\u0003=\u0005\u00022\u0001R#H\u001b\u0005y\u0012B\u0001$ \u0005-\u0001\u0016M]%uKJ\f'\r\\3\u0011\t-B%'P\u0005\u0003\u0013\u0016\u0012a\u0001V;qY\u0016\u0014\u0004#B&Oeu\u0002V\"\u0001'\u000b\u00055\u001b\u0013aB4f]\u0016\u0014\u0018nY\u0005\u0003\u001f2\u0013QcR3oKJL7\rU1s\u001b\u0006\u0004H+Z7qY\u0006$X\r\u0005\u0002E\u0001A1AI\u0015\u001a>)VK!aU\u0010\u0003\u0015A\u000b'/T1q\u0019&\\W\r\u0005\u0003E\u0001Ij\u0004\u0003\u0002,Yeuj\u0011a\u0016\u0006\u0003A\rJ!!W,\u0003\u00075\u000b\u0007/\u0001\u0004%S:LG\u000f\n\u000b\u00029B\u00111&X\u0005\u0003=\u0016\u0012A!\u00168ji\u0006Ya.Z<D_6\u0014\u0017N\\3s+\u0005\t\u0007\u0003B!c\u000fRK!aY\u0011\u0003\u0011\r{WNY5oKJ\fA\"\\1q\u0007>l\u0007/\u00198j_:,\u0012A\u001a\t\u0004\u0017\u001e\u0004\u0016B\u00015M\u0005Y9UM\\3sS\u000e\u0004\u0016M]'ba\u000e{W\u000e]1oS>t\u0017!B3naRLX#\u0001+\u0002\u0007M,\u0017/F\u0001V\u0003\u001d)\b\u000fZ1uK\u0012,\"a\u001c:\u0015\u0007A,x\u000f\u0005\u0003E\u0001I\n\bCA\u001as\t\u0015\u0019hA1\u0001u\u0005\u0005)\u0016CA\u001f;\u0011\u00151h\u00011\u00013\u0003\rYW-\u001f\u0005\u0006q\u001a\u0001\r!]\u0001\u0006m\u0006dW/Z\u0001\fo&$\b\u000eR3gCVdG\u000f\u0006\u0002Uw\")Ap\u0002a\u0001{\u0006\tA\r\u0005\u0003,}Jj\u0014BA@&\u0005%1UO\\2uS>t\u0017'\u0001\txSRDG)\u001a4bk2$h+\u00197vKR\u0019A+!\u0002\t\u000bqD\u0001\u0019A\u001f\u0002\rA\u000b'/T1q!\t!%bE\u0002\u000b\u0003\u001b\u0001BaSA\b!&\u0019\u0011\u0011\u0003'\u0003\u001bA\u000b'/T1q\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\u0011\u0011\u0011B\u000b\u0007\u00033\ty\"a\t\u0016\u0005\u0005m\u0001C\u0002#\u0001\u0003;\t\t\u0003E\u00024\u0003?!Q!\u000e\u0007C\u0002Y\u00022aMA\u0012\t\u0015yDB1\u00017+\u0019\t9#a\f\u00024U\u0011\u0011\u0011\u0006\t\u0007\u0003\n\fY#!\u000e\u0011\r-B\u0015QFA\u0019!\r\u0019\u0014q\u0006\u0003\u0006k5\u0011\rA\u000e\t\u0004g\u0005MB!B \u000e\u0005\u00041\u0004C\u0002#\u0001\u0003[\t\t$\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0004\u0002<\u0005M\u0013qK\u000b\u0003\u0003{\u0001\u0012bSA \u0003\u0007\ny%!\u0017\n\u0007\u0005\u0005CJ\u0001\bDC:\u001cu.\u001c2j]\u00164%o\\7\u0011\t\u0005\u0015\u0013qI\u0007\u0002\u0015%!\u0011\u0011JA&\u0005\u0011\u0019u\u000e\u001c7\n\u0007\u00055CJA\u0007HK:l\u0015\r\u001d$bGR|'/\u001f\t\u0007W!\u000b\t&!\u0016\u0011\u0007M\n\u0019\u0006B\u00036\u001d\t\u0007a\u0007E\u00024\u0003/\"Qa\u0010\bC\u0002Y\u0002b\u0001\u0012\u0001\u0002R\u0005U#aC,ji\"$UMZ1vYR,b!a\u0018\u0002\u0000\u0005\r5#B\b\u0002b\u0005\u0015\u0005\u0003CA2\u0003s\ni(!!\u000f\t\u0005\u0015\u0014q\u000f\b\u0005\u0003O\n)H\u0004\u0003\u0002j\u0005Md\u0002BA6\u0003cj!!!\u001c\u000b\u0007\u0005=t%\u0001\u0004=e>|GOP\u0005\u0002M%\u0011A%J\u0005\u0003E\rJ1!a\u0002\"\u0013\u0011\tY&a\u001f\u000b\u0007\u0005\u001d\u0011\u0005E\u00024\u0003\u007f\"Q!N\bC\u0002Y\u00022aMAB\t\u0015ytB1\u00017!\u0019!\u0005!! \u0002\u0002\u0006QQO\u001c3fe2L\u0018N\\4\u0011\r-r\u0018QPAA)\u0019\ti)a$\u0002\u0012B9\u0011QI\b\u0002~\u0005\u0005\u0005bBAD%\u0001\u0007\u0011Q\u0011\u0005\u0007yJ\u0001\r!!#\u0002\u0011\u0011\u0002H.^:%KF$B!a&\u0002\u001a6\tq\u0002C\u0004\u0002\u001cN\u0001\r!!(\u0002\u0005-4\bCB\u0016I\u0003{\n\t)A\u0005%[&tWo\u001d\u0013fcR!\u0011qSAR\u0011\u00191H\u00031\u0001\u0002~U\u0011\u0011QR\u000b\u0005\u0003S\u000by\u000b\u0006\u0004\u0002,\u0006M\u0016Q\u0017\t\b\u0003\u000bz\u0011QPAW!\r\u0019\u0014q\u0016\u0003\u0007gZ\u0011\r!!-\u0012\u0007\u0005\u0005%\b\u0003\u0004w-\u0001\u0007\u0011Q\u0010\u0005\u0007qZ\u0001\r!!,\u0002\u000b\u0011\u0002H.^:\u0016\t\u0005m\u0016\u0011\u0019\u000b\u0005\u0003{\u000b\u0019\rE\u0004\u0002F=\ti(a0\u0011\u0007M\n\t\r\u0002\u0004t/\t\u0007\u0011\u0011\u0017\u0005\b\u00037;\u0002\u0019AAc!\u0019Y\u0003*! \u0002@\u00061A%\\5okN$B!!$\u0002L\"1a\u000f\u0007a\u0001\u0003{*\"!a4\u0011\rYC\u0016QPAA\u0003\u0015\u0019G.Z1s\u0003\r\u0001X\u000f\u001e\u000b\u0007\u0003/\fi.a8\u0011\u000b-\nI.!!\n\u0007\u0005mWE\u0001\u0004PaRLwN\u001c\u0005\u0007mn\u0001\r!! \t\ra\\\u0002\u0019AAA)\u0011\t))a9\t\rqd\u0002\u0019AAE)\u0011\t))a:\t\rql\u0002\u0019AAA\u0001")
public interface ParMap<K, V>
extends scala.collection.parallel.ParMap<K, V>,
ParIterable<Tuple2<K, V>>,
ParMapLike<K, V, ParMap<K, V>, Map<K, V>> {
    public static <K, V> CanCombineFrom<ParMap<?, ?>, Tuple2<K, V>, ParMap<K, V>> canBuildFrom() {
        return ParMap$.MODULE$.canBuildFrom();
    }

    @Override
    default public Combiner<Tuple2<K, V>, ParMap<K, V>> newCombiner() {
        return ParMap$.MODULE$.newCombiner();
    }

    @Override
    default public GenericParMapCompanion<ParMap> mapCompanion() {
        return ParMap$.MODULE$;
    }

    public static /* synthetic */ ParMap empty$(ParMap $this) {
        return $this.empty();
    }

    @Override
    default public ParMap<K, V> empty() {
        return new ParHashMap();
    }

    @Override
    public Map<K, V> seq();

    public static /* synthetic */ ParMap updated$(ParMap $this, Object key, Object value) {
        return $this.updated((K)key, (U)value);
    }

    @Override
    default public <U> ParMap<K, U> updated(K key, U value) {
        return this.$plus(new Tuple2<K, U>(key, value));
    }

    public static /* synthetic */ ParMap withDefault$(ParMap $this, Function1 d) {
        return $this.withDefault(d);
    }

    default public ParMap<K, V> withDefault(Function1<K, V> d) {
        return new WithDefault<K, V>(this, d);
    }

    public static /* synthetic */ ParMap withDefaultValue$(ParMap $this, Object d) {
        return $this.withDefaultValue(d);
    }

    default public ParMap<K, V> withDefaultValue(V d) {
        return new WithDefault(this, (Function1<Object, Object> & java.io.Serializable & Serializable)x -> d);
    }

    public static void $init$(ParMap $this) {
    }

    public static class WithDefault<K, V>
    extends ParMap.WithDefault<K, V>
    implements ParMap<K, V> {
        private final ParMap<K, V> underlying;
        private final Function1<K, V> d;

        @Override
        public Combiner<Tuple2<K, V>, ParMap<K, V>> newCombiner() {
            return ((ParMap)this).newCombiner();
        }

        @Override
        public GenericParMapCompanion<ParMap> mapCompanion() {
            return ((ParMap)this).mapCompanion();
        }

        @Override
        public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
            return super.clone();
        }

        @Override
        public Object clone() {
            return Cloneable.clone$(this);
        }

        @Override
        public Shrinkable<K> $minus$eq(K elem1, K elem2, Seq<K> elems) {
            return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
        }

        @Override
        public Shrinkable<K> $minus$minus$eq(TraversableOnce<K> xs) {
            return Shrinkable.$minus$minus$eq$(this, xs);
        }

        @Override
        public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
            return Growable.$plus$eq$(this, elem1, elem2, elems);
        }

        @Override
        public Growable<Tuple2<K, V>> $plus$plus$eq(TraversableOnce<Tuple2<K, V>> xs) {
            return Growable.$plus$plus$eq$(this, xs);
        }

        @Override
        public GenericCompanion<ParIterable> companion() {
            return ParIterable.companion$(this);
        }

        @Override
        public ParIterable<Tuple2<K, V>> toIterable() {
            return ParIterable.toIterable$(this);
        }

        @Override
        public ParSeq<Tuple2<K, V>> toSeq() {
            return ParIterable.toSeq$(this);
        }

        public WithDefault<K, V> $plus$eq(Tuple2<K, V> kv) {
            this.underlying.$plus$eq(kv);
            return this;
        }

        public WithDefault<K, V> $minus$eq(K key) {
            this.underlying.$minus$eq(key);
            return this;
        }

        @Override
        public WithDefault<K, V> empty() {
            return new WithDefault<K, V>(this.underlying.empty(), this.d);
        }

        @Override
        public <U> WithDefault<K, U> updated(K key, U value) {
            return new WithDefault<K, U>(this.underlying.updated(key, value), this.d);
        }

        @Override
        public <U> WithDefault<K, U> $plus(Tuple2<K, U> kv) {
            return this.updated((Object)kv._1(), (Object)kv._2());
        }

        @Override
        public WithDefault<K, V> $minus(K key) {
            return new WithDefault<K, V>(this.underlying.$minus(key), this.d);
        }

        @Override
        public Map<K, V> seq() {
            return this.underlying.seq().withDefault(this.d);
        }

        @Override
        public void clear() {
            this.underlying.clear();
        }

        @Override
        public Option<V> put(K key, V value) {
            return this.underlying.put(key, value);
        }

        @Override
        public ParMap<K, V> withDefault(Function1<K, V> d) {
            return new WithDefault<K, V>(this.underlying, d);
        }

        @Override
        public ParMap<K, V> withDefaultValue(V d) {
            return new WithDefault<K, V>(this.underlying, (Function1<Object, Object> & java.io.Serializable & Serializable)x -> d);
        }

        public WithDefault(ParMap<K, V> underlying, Function1<K, V> d) {
            this.underlying = underlying;
            this.d = d;
            super(underlying, d);
            ParIterable.$init$(this);
            Growable.$init$(this);
            Shrinkable.$init$(this);
            Cloneable.$init$(this);
            ParMapLike.$init$(this);
            ParMap.$init$(this);
        }
    }
}

