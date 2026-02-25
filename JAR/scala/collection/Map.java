/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.AbstractMap;
import scala.collection.GenMap;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Map$;
import scala.collection.MapLike;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005]ba\u0002\n\u0014!\u0003\r\t\u0001\u0007\u0005\u0006u\u0001!\ta\u000f\u0005\u0006\u007f\u0001!\t\u0001\u0011\u0005\u0006\u0003\u0002!\t\u0005Q\u0004\u0006\u0005NA\ta\u0011\u0004\u0006%MA\t\u0001\u0012\u0005\u0006\u0019\u0016!\t!\u0014\u0005\u0006\u007f\u0015!\tA\u0014\u0005\u00063\u0016!\u0019A\u0017\u0005\u0007W\u0016\u0001\u000b\u0011\u00027\u0007\u000b=,\u0011\u0011\u00019\t\u0011uT!\u0011!Q\u0001\neD\u0001B \u0006\u0003\u0002\u0003\u0006Ia \u0005\u0007\u0019*!\t!!\u0002\t\u000f\u00055!\u0002\"\u0011\u0002\u0010!9\u0011q\u0003\u0006\u0005\u0002\u0005e\u0001bBA\u0013\u0015\u0011\u0005\u0011q\u0005\u0005\b\u0003cQA\u0011IA\u001a\u0005\ri\u0015\r\u001d\u0006\u0003)U\t!bY8mY\u0016\u001cG/[8o\u0015\u00051\u0012!B:dC2\f7\u0001A\u000b\u00043\u001d\n4#\u0002\u0001\u001b=M2\u0004CA\u000e\u001d\u001b\u0005)\u0012BA\u000f\u0016\u0005\u0019\te.\u001f*fMB\u0019q\u0004\t\u0012\u000e\u0003MI!!I\n\u0003\u0011%#XM]1cY\u0016\u0004BaG\u0012&a%\u0011A%\u0006\u0002\u0007)V\u0004H.\u001a\u001a\u0011\u0005\u0019:C\u0002\u0001\u0003\u0006Q\u0001\u0011\r!\u000b\u0002\u0002\u0017F\u0011!&\f\t\u00037-J!\u0001L\u000b\u0003\u000f9{G\u000f[5oOB\u00111DL\u0005\u0003_U\u00111!\u00118z!\t1\u0013\u0007\u0002\u00043\u0001\u0011\u0015\r!\u000b\u0002\u0002-B!q\u0004N\u00131\u0013\t)4C\u0001\u0004HK:l\u0015\r\u001d\t\u0006?]*\u0003'O\u0005\u0003qM\u0011q!T1q\u0019&\\W\r\u0005\u0003 \u0001\u0015\u0002\u0014A\u0002\u0013j]&$H\u0005F\u0001=!\tYR(\u0003\u0002?+\t!QK\\5u\u0003\u0015)W\u000e\u001d;z+\u0005I\u0014aA:fc\u0006\u0019Q*\u00199\u0011\u0005})1CA\u0003F!\r1\u0015jS\u0007\u0002\u000f*\u0011\u0001jE\u0001\bO\u0016tWM]5d\u0013\tQuI\u0001\u0006NCB4\u0015m\u0019;pef\u0004\"a\b\u0001\u0002\rqJg.\u001b;?)\u0005\u0019UcA(W1V\t\u0001\u000b\u0005\u0003R)V;V\"\u0001*\u000b\u0005M\u001b\u0012!C5n[V$\u0018M\u00197f\u0013\t\u0011\"\u000b\u0005\u0002'-\u0012)\u0001f\u0002b\u0001SA\u0011a\u0005\u0017\u0003\u0006e\u001d\u0011\r!K\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u00047\u001eLW#\u0001/\u0011\u000b\u0019kv,\u001a6\n\u0005y;%\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007C\u00011b\u001b\u0005)\u0011B\u00012d\u0005\u0011\u0019u\u000e\u001c7\n\u0005\u0011<%!D$f]6\u000b\u0007OR1di>\u0014\u0018\u0010\u0005\u0003\u001cG\u0019D\u0007C\u0001\u0014h\t\u0015A\u0003B1\u0001*!\t1\u0013\u000eB\u00033\u0011\t\u0007\u0011\u0006\u0005\u0003 \u0001\u0019D\u0017a\u0003*fkN\f'\r\\3D\u0005\u001a\u0003B\u0001Y7+U%\u0011an\u0019\u0002\u0010\u001b\u0006\u00048)\u00198Ck&dGM\u0012:p[\nYq+\u001b;i\t\u00164\u0017-\u001e7u+\r\th\u000f_\n\u0005\u0015IL(\u0010\u0005\u0003 gV<\u0018B\u0001;\u0014\u0005-\t%m\u001d;sC\u000e$X*\u00199\u0011\u0005\u00192H!\u0002\u0015\u000b\u0005\u0004I\u0003C\u0001\u0014y\t\u0019\u0011$\u0002\"b\u0001SA!q\u0004A;x!\tY20\u0003\u0002}+\ta1+\u001a:jC2L'0\u00192mK\u0006QQO\u001c3fe2L\u0018N\\4\u0002\u0003\u0011\u0004RaGA\u0001k^L1!a\u0001\u0016\u0005%1UO\\2uS>t\u0017\u0007\u0006\u0004\u0002\b\u0005%\u00111\u0002\t\u0005A*)x\u000fC\u0003~\u001b\u0001\u0007\u0011\u0010C\u0003\u007f\u001b\u0001\u0007q0\u0001\u0003tSj,WCAA\t!\rY\u00121C\u0005\u0004\u0003+)\"aA%oi\u0006\u0019q-\u001a;\u0015\t\u0005m\u0011\u0011\u0005\t\u00057\u0005uq/C\u0002\u0002 U\u0011aa\u00149uS>t\u0007BBA\u0012\u001f\u0001\u0007Q/A\u0002lKf\f\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0003S\u0001RaHA\u0016\u0003_I1!!\f\u0014\u0005!IE/\u001a:bi>\u0014\b\u0003B\u000e$k^\fq\u0001Z3gCVdG\u000fF\u0002x\u0003kAa!a\t\u0012\u0001\u0004)\b")
public interface Map<K, V>
extends Iterable<Tuple2<K, V>>,
GenMap<K, V>,
MapLike<K, V, Map<K, V>> {
    public static <K, V> CanBuildFrom<Map<?, ?>, Tuple2<K, V>, Map<K, V>> canBuildFrom() {
        return Map$.MODULE$.canBuildFrom();
    }

    public static /* synthetic */ Map empty$(Map $this) {
        return $this.empty();
    }

    @Override
    default public Map<K, V> empty() {
        return Map$.MODULE$.empty();
    }

    public static /* synthetic */ Map seq$(Map $this) {
        return $this.seq();
    }

    @Override
    default public Map<K, V> seq() {
        return this;
    }

    public static void $init$(Map $this) {
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static abstract class WithDefault<K, V>
    extends AbstractMap<K, V>
    implements Serializable {
        private final Map<K, V> underlying;
        private final Function1<K, V> d;

        @Override
        public int size() {
            return this.underlying.size();
        }

        @Override
        public Option<V> get(K key) {
            return this.underlying.get(key);
        }

        @Override
        public Iterator<Tuple2<K, V>> iterator() {
            return this.underlying.iterator();
        }

        @Override
        public V default(K key) {
            return this.d.apply(key);
        }

        public WithDefault(Map<K, V> underlying, Function1<K, V> d) {
            this.underlying = underlying;
            this.d = d;
        }
    }
}

