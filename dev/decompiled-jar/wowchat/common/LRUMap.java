/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import java.io.Serializable;
import scala.Option;
import scala.collection.mutable.LinkedHashMap;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u001d<Qa\u0003\u0007\t\u0002E1Qa\u0005\u0007\t\u0002QAQAH\u0001\u0005\u0002}AQ\u0001I\u0001\u0005\u0002\u0005BQ\u0001I\u0001\u0005\u0002eBq!R\u0001\u0002\u0002\u0013%aI\u0002\u0003\u0014\u0019\u0001y\u0005\u0002C!\u0007\u0005\u0003\u0005\u000b\u0011\u0002\"\t\u000by1A\u0011\u0001-\t\u000bm3A\u0011\t/\t\u000b\t4A\u0011I2\u0002\r1\u0013V+T1q\u0015\tia\"\u0001\u0004d_6lwN\u001c\u0006\u0002\u001f\u00059qo\\<dQ\u0006$8\u0001\u0001\t\u0003%\u0005i\u0011\u0001\u0004\u0002\u0007\u0019J+V*\u00199\u0014\u0007\u0005)2\u0004\u0005\u0002\u001735\tqCC\u0001\u0019\u0003\u0015\u00198-\u00197b\u0013\tQrC\u0001\u0004B]f\u0014VM\u001a\t\u0003-qI!!H\f\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\u0005\t\u0012!B3naRLXc\u0001\u0012.oQ\t1\u0005\u0005\u0003%S-2T\"A\u0013\u000b\u0005\u0019:\u0013aB7vi\u0006\u0014G.\u001a\u0006\u0003Q]\t!bY8mY\u0016\u001cG/[8o\u0013\tQSEA\u0002NCB\u0004\"\u0001L\u0017\r\u0001\u0011)af\u0001b\u0001_\t\t1*\u0005\u00021gA\u0011a#M\u0005\u0003e]\u0011qAT8uQ&tw\r\u0005\u0002\u0017i%\u0011Qg\u0006\u0002\u0004\u0003:L\bC\u0001\u00178\t\u0015A4A1\u00010\u0005\u00051Vc\u0001\u001e>\u007fQ\u00111\b\u0011\t\u0005I%bd\b\u0005\u0002-{\u0011)a\u0006\u0002b\u0001_A\u0011Af\u0010\u0003\u0006q\u0011\u0011\ra\f\u0005\u0006\u0003\u0012\u0001\rAQ\u0001\b[\u0006D8+\u001b>f!\t12)\u0003\u0002E/\t\u0019\u0011J\u001c;\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0002\u000fB\u0011\u0001*T\u0007\u0002\u0013*\u0011!jS\u0001\u0005Y\u0006twMC\u0001M\u0003\u0011Q\u0017M^1\n\u00059K%AB(cU\u0016\u001cG/F\u0002Q+^\u001b\"AB)\u0011\t\u0011\u0012FKV\u0005\u0003'\u0016\u0012Q\u0002T5oW\u0016$\u0007*Y:i\u001b\u0006\u0004\bC\u0001\u0017V\t\u0015qcA1\u00010!\tas\u000bB\u00039\r\t\u0007q\u0006\u0006\u0002Z5B!!C\u0002+W\u0011\u0015\t\u0005\u00021\u0001C\u0003\r9W\r\u001e\u000b\u0003;\u0002\u00042A\u00060W\u0013\tyvC\u0001\u0004PaRLwN\u001c\u0005\u0006C&\u0001\r\u0001V\u0001\u0004W\u0016L\u0018a\u00019viR\u0019Q\fZ3\t\u000b\u0005T\u0001\u0019\u0001+\t\u000b\u0019T\u0001\u0019\u0001,\u0002\u000bY\fG.^3")
public class LRUMap<K, V>
extends LinkedHashMap<K, V> {
    private final int maxSize;

    /*
     * WARNING - void declaration
     */
    @Override
    public Option<V> get(K key) {
        void var2_2;
        Option ret = this.remove(key);
        Serializable serializable = ret.isDefined() ? super.put(key, ret.get()) : BoxedUnit.UNIT;
        return var2_2;
    }

    @Override
    public Option<V> put(K key, V value) {
        while (this.size() >= this.maxSize) {
            this.remove(this.firstEntry().key());
        }
        return super.put(key, value);
    }

    public LRUMap(int maxSize) {
        this.maxSize = maxSize;
    }
}

