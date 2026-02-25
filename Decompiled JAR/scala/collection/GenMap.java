/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenMap$;
import scala.collection.GenMapLike;
import scala.collection.Map;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001-4q!\u0003\u0006\u0011\u0002G\u0005q\u0002C\u0003/\u0001\u0019\u0005q\u0006C\u00034\u0001\u0019\u0005AgB\u0003@\u0015!\u0005\u0001IB\u0003\n\u0015!\u0005\u0011\tC\u0003J\t\u0011\u0005!\nC\u0003L\t\u0011\u0005A\nC\u0003X\t\u0011\r\u0001\f\u0003\u0004h\t\u0001\u0006I\u0001\u001b\u0002\u0007\u000f\u0016tW*\u00199\u000b\u0005-a\u0011AC2pY2,7\r^5p]*\tQ\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0007AYRe\u0005\u0003\u0001#UA\u0003C\u0001\n\u0014\u001b\u0005a\u0011B\u0001\u000b\r\u0005\u0019\te.\u001f*fMB)acF\r%O5\t!\"\u0003\u0002\u0019\u0015\tQq)\u001a8NCBd\u0015n[3\u0011\u0005iYB\u0002\u0001\u0003\u00069\u0001\u0011\r!\b\u0002\u0002\u0017F\u0011a$\t\t\u0003%}I!\u0001\t\u0007\u0003\u000f9{G\u000f[5oOB\u0011!CI\u0005\u0003G1\u00111!\u00118z!\tQR\u0005\u0002\u0004'\u0001\u0011\u0015\r!\b\u0002\u0002-B!a\u0003A\r%!\r1\u0012fK\u0005\u0003U)\u00111bR3o\u0013R,'/\u00192mKB!!\u0003L\r%\u0013\tiCB\u0001\u0004UkBdWMM\u0001\u0004g\u0016\fX#\u0001\u0019\u0011\tY\t\u0014\u0004J\u0005\u0003e)\u00111!T1q\u0003\u001d)\b\u000fZ1uK\u0012,\"!\u000e\u001d\u0015\u0007YZT\b\u0005\u0003\u0017\u0001e9\u0004C\u0001\u000e9\t\u0015I$A1\u0001;\u0005\t1\u0016'\u0005\u0002%C!)AH\u0001a\u00013\u0005\u00191.Z=\t\u000by\u0012\u0001\u0019A\u001c\u0002\u000bY\fG.^3\u0002\r\u001d+g.T1q!\t1Ba\u0005\u0002\u0005\u0005B\u00191I\u0012%\u000e\u0003\u0011S!!\u0012\u0006\u0002\u000f\u001d,g.\u001a:jG&\u0011q\t\u0012\u0002\u000e\u000f\u0016tW*\u00199GC\u000e$xN]=\u0011\u0005Y\u0001\u0011A\u0002\u001fj]&$h\bF\u0001A\u0003\u0015)W\u000e\u001d;z+\riEKV\u000b\u0002\u001dB!qJU*V\u001b\u0005\u0001&BA)\u000b\u0003%IW.\\;uC\ndW-\u0003\u00023!B\u0011!\u0004\u0016\u0003\u00069\u0019\u0011\r!\b\t\u00035Y#QA\n\u0004C\u0002u\tAbY1o\u0005VLG\u000e\u001a$s_6,2!W2f+\u0005Q\u0006#B\"\\;\u00064\u0017B\u0001/E\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\tqv,D\u0001\u0005\u0013\t\u0001gI\u0001\u0003D_2d\u0007\u0003\u0002\n-E\u0012\u0004\"AG2\u0005\u000bq9!\u0019A\u000f\u0011\u0005i)G!\u0002\u0014\b\u0005\u0004i\u0002\u0003\u0002\f\u0001E\u0012\f1BU3vg\u0006\u0014G.Z\"C\rB!a,\u001b\u0010\u001f\u0013\tQgIA\bNCB\u001c\u0015M\u001c\"vS2$gI]8n\u0001")
public interface GenMap<K, V>
extends GenMapLike<K, V, GenMap<K, V>>,
GenIterable<Tuple2<K, V>> {
    public static <K, V> CanBuildFrom<GenMap<?, ?>, Tuple2<K, V>, GenMap<K, V>> canBuildFrom() {
        return GenMap$.MODULE$.canBuildFrom();
    }

    public static <K, V> scala.collection.immutable.Map<K, V> empty() {
        return GenMap$.MODULE$.empty();
    }

    @Override
    public Map<K, V> seq();

    public <V1> GenMap<K, V1> updated(K var1, V1 var2);
}

