/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.immutable;

import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.immutable.Map;
import scala.collection.parallel.ParMap;
import scala.collection.parallel.immutable.ParHashMap;
import scala.collection.parallel.immutable.ParIterable;
import scala.collection.parallel.immutable.ParMap$;
import scala.collection.parallel.immutable.ParSeq;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t-baB\u000e\u001d!\u0003\r\t!\n\u0005\u0006/\u0002!\t\u0001\u0017\u0005\u00069\u0002!\t%\u0018\u0005\u0006C\u0002!\tE\u0019\u0005\u0006G\u0002!\t\u0005\u001a\u0005\u0006[\u0002!\tE\u001c\u0005\b\u0003\u0017\u0001A\u0011IA\u0007\u0011\u001d\t\u0019\u0003\u0001D\u0001\u0003KAq!!\u000e\u0001\t\u0003\t9\u0004C\u0004\u0002L\u0001!\t!!\u0014\b\u000f\u0005eC\u0004#\u0001\u0002\\\u001911\u0004\bE\u0001\u0003;Bq!!\u001a\f\t\u0003\t9\u0007\u0003\u0004b\u0017\u0011\u0005\u0011\u0011\u000e\u0005\b\u0003oZA\u0011AA=\u0011\u001d\tyi\u0003C\u0002\u0003#3a!a-\f\u0001\u0005U\u0006BCAm!\t\u0005\t\u0015!\u0003\u0002X\"Q\u00111\t\t\u0003\u0002\u0003\u0006I!a7\t\u000f\u0005\u0015\u0004\u0003\"\u0001\u0002^\"1\u0011\r\u0005C!\u0003KDq!a\u0003\u0011\t\u0003\n9\u000fC\u0004\u0002$A!\t%a>\t\u000f\t\u0015\u0001\u0003\"\u0011\u0003\b!9\u0011Q\u0007\t\u0005B\t-\u0001bBA&!\u0011\u0005#\u0011\u0004\u0005\b\u0005K\u0001B\u0011\tB\u0014\u0005\u0019\u0001\u0016M]'ba*\u0011QDH\u0001\nS6lW\u000f^1cY\u0016T!a\b\u0011\u0002\u0011A\f'/\u00197mK2T!!\t\u0012\u0002\u0015\r|G\u000e\\3di&|gNC\u0001$\u0003\u0015\u00198-\u00197b\u0007\u0001)2AJ\u0019<'\u001d\u0001qeK\u001fF\u0011:\u0003\"\u0001K\u0015\u000e\u0003\tJ!A\u000b\u0012\u0003\r\u0005s\u0017PU3g!\u0011aSf\f\u001e\u000e\u0003\u0001J!A\f\u0011\u0003\r\u001d+g.T1q!\t\u0001\u0014\u0007\u0004\u0001\u0005\u000bI\u0002!\u0019A\u001a\u0003\u0003-\u000b\"\u0001N\u001c\u0011\u0005!*\u0014B\u0001\u001c#\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u000b\u001d\n\u0005e\u0012#aA!osB\u0011\u0001g\u000f\u0003\u0007y\u0001!)\u0019A\u001a\u0003\u0003Y\u0003RAP!0u\rk\u0011a\u0010\u0006\u0003\u0001\u0002\nqaZ3oKJL7-\u0003\u0002C\u007f\t)r)\u001a8fe&\u001c\u0007+\u0019:NCB$V-\u001c9mCR,\u0007C\u0001#\u0001\u001b\u0005a\u0002\u0003\u0002$H_ij\u0011AH\u0005\u00037y\u00012\u0001R%L\u0013\tQEDA\u0006QCJLE/\u001a:bE2,\u0007\u0003\u0002\u0015M_iJ!!\u0014\u0012\u0003\rQ+\b\u000f\\33!\u00191uj\f\u001eR%&\u0011\u0001K\b\u0002\u000b!\u0006\u0014X*\u00199MS.,\u0007\u0003\u0002#\u0001_i\u0002BaU+0u5\tAK\u0003\u0002\u001eA%\u0011a\u000b\u0016\u0002\u0004\u001b\u0006\u0004\u0018A\u0002\u0013j]&$H\u0005F\u0001Z!\tA#,\u0003\u0002\\E\t!QK\\5u\u00031i\u0017\r]\"p[B\fg.[8o+\u0005q\u0006c\u0001 `\u0007&\u0011\u0001m\u0010\u0002\u0017\u000f\u0016tWM]5d!\u0006\u0014X*\u00199D_6\u0004\u0018M\\5p]\u0006)Q-\u001c9usV\t\u0011+\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070F\u0001f!\t17.D\u0001h\u0015\tA\u0017.\u0001\u0003mC:<'\"\u00016\u0002\t)\fg/Y\u0005\u0003Y\u001e\u0014aa\u0015;sS:<\u0017!\u0002;p\u001b\u0006\u0004XcA8skR\u0011\u0001o\u001e\t\u0005\t\u0002\tH\u000f\u0005\u00021e\u0012)1/\u0002b\u0001g\t\t\u0001\u000b\u0005\u00021k\u0012)a/\u0002b\u0001g\t\t\u0011\u000bC\u0003y\u000b\u0001\u000f\u00110\u0001\u0002fmB1!0a\u0001L\u0003\u0013q!a_@\u0011\u0005q\u0014S\"A?\u000b\u0005y$\u0013A\u0002\u001fs_>$h(C\u0002\u0002\u0002\t\na\u0001\u0015:fI\u00164\u0017\u0002BA\u0003\u0003\u000f\u0011\u0001\u0003\n7fgN$3m\u001c7p]\u0012bWm]:\u000b\u0007\u0005\u0005!\u0005\u0005\u0003)\u0019F$\u0018aB;qI\u0006$X\rZ\u000b\u0005\u0003\u001f\t)\u0002\u0006\u0004\u0002\u0012\u0005m\u0011q\u0004\t\u0006\t\u0002y\u00131\u0003\t\u0004a\u0005UAaBA\f\r\t\u0007\u0011\u0011\u0004\u0002\u0002+F\u0011!h\u000e\u0005\u0007\u0003;1\u0001\u0019A\u0018\u0002\u0007-,\u0017\u0010C\u0004\u0002\"\u0019\u0001\r!a\u0005\u0002\u000bY\fG.^3\u0002\u000b\u0011\u0002H.^:\u0016\t\u0005\u001d\u0012Q\u0006\u000b\u0005\u0003S\ty\u0003E\u0003E\u0001=\nY\u0003E\u00021\u0003[!q!a\u0006\b\u0005\u0004\tI\u0002C\u0004\u00022\u001d\u0001\r!a\r\u0002\u0005-4\b#\u0002\u0015M_\u0005-\u0012aC<ji\"$UMZ1vYR,B!!\u000f\u0002@Q!\u00111HA!!\u0015!\u0005aLA\u001f!\r\u0001\u0014q\b\u0003\b\u0003/A!\u0019AA\r\u0011\u001d\t\u0019\u0005\u0003a\u0001\u0003\u000b\n\u0011\u0001\u001a\t\u0007Q\u0005\u001ds&!\u0010\n\u0007\u0005%#EA\u0005Gk:\u001cG/[8oc\u0005\u0001r/\u001b;i\t\u00164\u0017-\u001e7u-\u0006dW/Z\u000b\u0005\u0003\u001f\n)\u0006\u0006\u0003\u0002R\u0005]\u0003#\u0002#\u0001_\u0005M\u0003c\u0001\u0019\u0002V\u00119\u0011qC\u0005C\u0002\u0005e\u0001bBA\"\u0013\u0001\u0007\u00111K\u0001\u0007!\u0006\u0014X*\u00199\u0011\u0005\u0011[1cA\u0006\u0002`A!a(!\u0019D\u0013\r\t\u0019g\u0010\u0002\u000e!\u0006\u0014X*\u00199GC\u000e$xN]=\u0002\rqJg.\u001b;?)\t\tY&\u0006\u0004\u0002l\u0005E\u0014QO\u000b\u0003\u0003[\u0002b\u0001\u0012\u0001\u0002p\u0005M\u0004c\u0001\u0019\u0002r\u0011)!'\u0004b\u0001gA\u0019\u0001'!\u001e\u0005\u000bqj!\u0019A\u001a\u0002\u00179,woQ8nE&tWM]\u000b\u0007\u0003w\n9)a#\u0016\u0005\u0005u\u0004c\u0002$\u0002\u0000\u0005\r\u0015QR\u0005\u0004\u0003\u0003s\"\u0001C\"p[\nLg.\u001a:\u0011\r!b\u0015QQAE!\r\u0001\u0014q\u0011\u0003\u0006e9\u0011\ra\r\t\u0004a\u0005-E!\u0002\u001f\u000f\u0005\u0004\u0019\u0004C\u0002#\u0001\u0003\u000b\u000bI)\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0004\u0002\u0014\u0006-\u0016qV\u000b\u0003\u0003+\u0003\u0012BPAL\u00037\u000b9+!-\n\u0007\u0005euH\u0001\bDC:\u001cu.\u001c2j]\u00164%o\\7\u0011\t\u0005u\u0015qT\u0007\u0002\u0017%!\u0011\u0011UAR\u0005\u0011\u0019u\u000e\u001c7\n\u0007\u0005\u0015vHA\u0007HK:l\u0015\r\u001d$bGR|'/\u001f\t\u0007Q1\u000bI+!,\u0011\u0007A\nY\u000bB\u00033\u001f\t\u00071\u0007E\u00021\u0003_#Q\u0001P\bC\u0002M\u0002b\u0001\u0012\u0001\u0002*\u00065&aC,ji\"$UMZ1vYR,b!a.\u0002R\u0006U7#\u0002\t\u0002:\u0006]\u0007\u0003CA^\u0003\u0017\fy-a5\u000f\t\u0005u\u0016\u0011\u001a\b\u0005\u0003\u007f\u000b9M\u0004\u0003\u0002B\u0006\u0015gb\u0001?\u0002D&\t1%\u0003\u0002\"E%\u0011q\u0004I\u0005\u0004\u00033r\u0012\u0002BAZ\u0003\u001bT1!!\u0017\u001f!\r\u0001\u0014\u0011\u001b\u0003\u0006eA\u0011\ra\r\t\u0004a\u0005UGA\u0002\u001f\u0011\t\u000b\u00071\u0007\u0005\u0004E\u0001\u0005=\u00171[\u0001\u000bk:$WM\u001d7zS:<\u0007c\u0002\u0015\u0002H\u0005=\u00171\u001b\u000b\u0007\u0003?\f\t/a9\u0011\u000f\u0005u\u0005#a4\u0002T\"9\u0011\u0011\\\nA\u0002\u0005]\u0007bBA\"'\u0001\u0007\u00111\\\u000b\u0003\u0003?,B!!;\u0002pR1\u00111^Az\u0003k\u0004r!!(\u0011\u0003\u001f\fi\u000fE\u00021\u0003_$q!a\u0006\u0016\u0005\u0004\t\t0E\u0002\u0002T^Bq!!\b\u0016\u0001\u0004\ty\rC\u0004\u0002\"U\u0001\r!!<\u0016\t\u0005e\u0018q \u000b\u0005\u0003w\u0014\t\u0001E\u0004\u0002\u001eB\ty-!@\u0011\u0007A\ny\u0010B\u0004\u0002\u0018Y\u0011\r!!=\t\u000f\u0005Eb\u00031\u0001\u0003\u0004A1\u0001\u0006TAh\u0003{\fa\u0001J7j]V\u001cH\u0003BAp\u0005\u0013Aq!!\b\u0018\u0001\u0004\ty-\u0006\u0003\u0003\u000e\tMA\u0003\u0002B\b\u0005+\u0001b\u0001\u0012\u0001\u0002P\nE\u0001c\u0001\u0019\u0003\u0014\u00119\u0011q\u0003\rC\u0002\u0005E\bbBA\"1\u0001\u0007!q\u0003\t\bQ\u0005\u001d\u0013q\u001aB\t+\u0011\u0011YB!\t\u0015\t\tu!1\u0005\t\u0007\t\u0002\tyMa\b\u0011\u0007A\u0012\t\u0003B\u0004\u0002\u0018e\u0011\r!!=\t\u000f\u0005\r\u0013\u00041\u0001\u0003 \u0005\u00191/Z9\u0016\u0005\t%\u0002CB*V\u0003\u001f\f\u0019\u000e")
public interface ParMap<K, V>
extends scala.collection.parallel.ParMap<K, V>,
ParIterable<Tuple2<K, V>> {
    public static <K, V> CanCombineFrom<ParMap<?, ?>, Tuple2<K, V>, ParMap<K, V>> canBuildFrom() {
        return ParMap$.MODULE$.canBuildFrom();
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
    default public String stringPrefix() {
        return "ParMap";
    }

    @Override
    default public <P, Q> ParMap<P, Q> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<P, Q>> ev) {
        return this;
    }

    public static /* synthetic */ ParMap updated$(ParMap $this, Object key, Object value) {
        return $this.updated((K)key, (U)value);
    }

    @Override
    default public <U> ParMap<K, U> updated(K key, U value) {
        return this.$plus(new Tuple2<K, U>(key, value));
    }

    @Override
    public <U> ParMap<K, U> $plus(Tuple2<K, U> var1);

    public static /* synthetic */ ParMap withDefault$(ParMap $this, Function1 d) {
        return $this.withDefault(d);
    }

    default public <U> ParMap<K, U> withDefault(Function1<K, U> d) {
        return new WithDefault<K, U>(this, d);
    }

    public static /* synthetic */ ParMap withDefaultValue$(ParMap $this, Object d) {
        return $this.withDefaultValue(d);
    }

    default public <U> ParMap<K, U> withDefaultValue(U d) {
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
        public GenericParMapCompanion<ParMap> mapCompanion() {
            return ((ParMap)this).mapCompanion();
        }

        @Override
        public String stringPrefix() {
            return ((ParMap)this).stringPrefix();
        }

        @Override
        public <P, Q> ParMap<P, Q> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<P, Q>> ev) {
            return ((ParMap)this).toMap(ev);
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
            return new WithDefault<K, V>((ParMap)this.underlying.$minus(key), this.d);
        }

        @Override
        public <U> ParMap<K, U> withDefault(Function1<K, U> d) {
            return new WithDefault<K, V>(this.underlying, d);
        }

        @Override
        public <U> ParMap<K, U> withDefaultValue(U d) {
            return new WithDefault<K, V>(this.underlying, (Function1<Object, Object> & java.io.Serializable & Serializable)x -> d);
        }

        @Override
        public Map<K, V> seq() {
            return ((Map)this.underlying.seq()).withDefault(this.d);
        }

        public WithDefault(ParMap<K, V> underlying, Function1<K, V> d) {
            this.underlying = underlying;
            this.d = d;
            super(underlying, d);
            ParIterable.$init$(this);
            ParMap.$init$(this);
        }
    }
}

