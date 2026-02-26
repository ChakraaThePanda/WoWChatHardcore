/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Option;
import scala.Tuple2;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Map;
import scala.collection.mutable.MapLike;
import scala.collection.parallel.mutable.ParMap;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001i4q\u0001C\u0005\u0011\u0002\u0007\u0005!\u0003C\u0003W\u0001\u0011\u0005q\u000bC\u0003\\\u0001\u0019\u0005A\fC\u0003e\u0001\u0019\u0005Q\rC\u0003j\u0001\u0019\u0005!\u000eC\u0003m\u0001\u0011\u0005Q\u000eC\u0003w\u0001\u0011\u0005q\u000fC\u0003z\u0001\u0019\u0005qK\u0001\u0006QCJl\u0015\r\u001d'jW\u0016T!AC\u0006\u0002\u000f5,H/\u00192mK*\u0011A\"D\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011abD\u0001\u000bG>dG.Z2uS>t'\"\u0001\t\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U)1C\b\u0015,iM9\u0001\u0001\u0006\rE\u000fB\u001b\u0006CA\u000b\u0017\u001b\u0005y\u0011BA\f\u0010\u0005\u0019\te.\u001f*fMB)\u0011D\u0007\u000f(U5\tQ\"\u0003\u0002\u001c\u001b\tQq)\u001a8NCBd\u0015n[3\u0011\u0005uqB\u0002\u0001\u0003\u0006?\u0001\u0011\r\u0001\t\u0002\u0002\u0017F\u0011\u0011\u0005\n\t\u0003+\tJ!aI\b\u0003\u000f9{G\u000f[5oOB\u0011Q#J\u0005\u0003M=\u00111!\u00118z!\ti\u0002\u0006B\u0003*\u0001\t\u0007\u0001EA\u0001W!\ti2\u0006\u0002\u0004-\u0001\u0011\u0015\r!\f\u0002\u0005%\u0016\u0004(/\u0005\u0002\"]I\u0019q&M!\u0007\tA\u0002\u0001A\f\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0007e\u0001arEK\u001a\u000e\u0003%\u0001\"!\b\u001b\u0005\rU\u0002AQ1\u00017\u0005)\u0019V-];f]RL\u0017\r\\\t\u0003C]\u00122\u0001O\u001d?\r\u0011\u0001\u0004\u0001A\u001c\u0011\tibDdJ\u0007\u0002w)\u0011!\"D\u0005\u0003{m\u00121!T1q!\u0015Qt\bH\u00144\u0013\t\u00015HA\u0004NCBd\u0015n[3\u0011\tI\u0012EdJ\u0005\u0003\u0007&\u0011a\u0001U1s\u001b\u0006\u0004\bCB#G9\u001dR3'D\u0001\f\u0013\tA1\u0002E\u0002I\u00176k\u0011!\u0013\u0006\u0003\u00156\tqaZ3oKJL7-\u0003\u0002M\u0013\nAqI]8xC\ndW\r\u0005\u0003\u0016\u001dr9\u0013BA(\u0010\u0005\u0019!V\u000f\u001d7feA\u0019\u0001*\u0015\u000f\n\u0005IK%AC*ie&t7.\u00192mKB\u0019!\b\u0016\u0016\n\u0005U[$!C\"m_:,\u0017M\u00197f\u0003\u0019!\u0013N\\5uIQ\t\u0001\f\u0005\u0002\u00163&\u0011!l\u0004\u0002\u0005+:LG/A\u0002qkR$2!\u00181c!\r)blJ\u0005\u0003?>\u0011aa\u00149uS>t\u0007\"B1\u0003\u0001\u0004a\u0012aA6fs\")1M\u0001a\u0001O\u0005)a/\u00197vK\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0002gO6\t\u0001\u0001C\u0003i\u0007\u0001\u0007Q*\u0001\u0002lm\u0006IA%\\5okN$S-\u001d\u000b\u0003M.DQ!\u0019\u0003A\u0002q\tQ\u0001\n9mkN,\"A\\9\u0015\u0005=$\b\u0003\u0002\u001aC9A\u0004\"!H9\u0005\u000bI,!\u0019A:\u0003\u0003U\u000b\"a\n\u0013\t\u000b!,\u0001\u0019A;\u0011\tUqE\u0004]\u0001\u0007I5Lg.^:\u0015\u0005)B\b\"B1\u0007\u0001\u0004a\u0012!B2mK\u0006\u0014\b")
public interface ParMapLike<K, V, Repr extends ParMapLike<K, V, Repr, Sequential> & ParMap<K, V>, Sequential extends Map<K, V> & MapLike<K, V, Sequential>>
extends scala.collection.parallel.ParMapLike<K, V, Repr, Sequential>,
Growable<Tuple2<K, V>>,
Shrinkable<K>,
Cloneable<Repr> {
    public Option<V> put(K var1, V var2);

    public ParMapLike<K, V, Repr, Sequential> $plus$eq(Tuple2<K, V> var1);

    public ParMapLike<K, V, Repr, Sequential> $minus$eq(K var1);

    public static /* synthetic */ ParMap $plus$(ParMapLike $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <U> ParMap<K, U> $plus(Tuple2<K, U> kv) {
        return (ParMap)((ParMap)this.clone()).$plus$eq(kv);
    }

    public static /* synthetic */ ParMap $minus$(ParMapLike $this, Object key) {
        return $this.$minus(key);
    }

    @Override
    default public Repr $minus(K key) {
        return (Repr)((ParMap)((ParMapLike)this.clone()).$minus$eq(key));
    }

    @Override
    public void clear();

    public static void $init$(ParMapLike $this) {
    }
}

