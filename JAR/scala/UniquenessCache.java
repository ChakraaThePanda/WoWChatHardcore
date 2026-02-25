/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import scala.Option;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000154aAD\b\u0002\u0002=\t\u0002\"B\f\u0001\t\u0003I\u0002bB\u0017\u0001\u0005\u0004%IA\f\u0005\u0007w\u0001\u0001\u000b\u0011B\u0018\t\u000fq\u0002!\u0019!C\u0005{!1A\t\u0001Q\u0001\nyBq!\u0012\u0001C\u0002\u0013%a\t\u0003\u0004K\u0001\u0001\u0006Ia\u0012\u0005\b\u0017\u0002\u0011\r\u0011\"\u0003M\u0011\u0019I\u0006\u0001)A\u0005\u001b\")!\f\u0001D\t7\")a\f\u0001D\t?\")Q\r\u0001C\u0001M\")\u0011\u000e\u0001C\u0001U\nyQK\\5rk\u0016tWm]:DC\u000eDWMC\u0001\u0011\u0003\u0015\u00198-\u00197b+\r\u0011RdJ\n\u0003\u0001M\u0001\"\u0001F\u000b\u000e\u0003=I!AF\b\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}\r\u0001A#\u0001\u000e\u0011\tQ\u00011D\n\t\u00039ua\u0001\u0001B\u0003\u001f\u0001\t\u0007qDA\u0001L#\t\u00013\u0005\u0005\u0002\u0015C%\u0011!e\u0004\u0002\b\u001d>$\b.\u001b8h!\t!B%\u0003\u0002&\u001f\t\u0019\u0011I\\=\u0011\u0005q9C!\u0002\u0015\u0001\u0005\u0004I#!\u0001,\u0012\u0005)\u001a\u0003C\u0001\u000b,\u0013\tasB\u0001\u0003Ok2d\u0017a\u0001:xYV\tq\u0006\u0005\u00021s5\t\u0011G\u0003\u00023g\u0005)An\\2lg*\u0011A'N\u0001\u000bG>t7-\u001e:sK:$(B\u0001\u001c8\u0003\u0011)H/\u001b7\u000b\u0003a\nAA[1wC&\u0011!(\r\u0002\u0017%\u0016,g\u000e\u001e:b]R\u0014V-\u00193Xe&$X\rT8dW\u0006!!o\u001e7!\u0003\u0015\u0011Hn\\2l+\u0005q\u0004CA C\u001b\u0005\u0001%BA!2\u0003Y\u0011V-\u001a8ue\u0006tGOU3bI^\u0013\u0018\u000e^3M_\u000e\\\u0017BA\"A\u0005!\u0011V-\u00193M_\u000e\\\u0017A\u0002:m_\u000e\\\u0007%A\u0003xY>\u001c7.F\u0001H!\ty\u0004*\u0003\u0002J\u0001\nIqK]5uK2{7m[\u0001\u0007o2|7m\u001b\u0011\u0002\u00075\f\u0007/F\u0001N!\u0011qujG)\u000e\u0003UJ!\u0001U\u001b\u0003\u0017]+\u0017m\u001b%bg\"l\u0015\r\u001d\t\u0004%^3S\"A*\u000b\u0005Q+\u0016a\u0001:fM*\u0011akN\u0001\u0005Y\u0006tw-\u0003\u0002Y'\niq+Z1l%\u00164WM]3oG\u0016\fA!\\1qA\u0005aa/\u00197vK\u001a\u0013x.\\&fsR\u0011a\u0005\u0018\u0005\u0006;*\u0001\raG\u0001\u0002W\u0006a1.Z=Ge>lg+\u00197vKR\u0011\u0001m\u0019\t\u0004)\u0005\\\u0012B\u00012\u0010\u0005\u0019y\u0005\u000f^5p]\")Am\u0003a\u0001M\u0005\ta/A\u0003baBd\u0017\u0010\u0006\u0002'O\")\u0001\u000e\u0004a\u00017\u0005!a.Y7f\u0003\u001d)h.\u00199qYf$\"\u0001Y6\t\u000b1l\u0001\u0019\u0001\u0014\u0002\u000b=$\b.\u001a:")
public abstract class UniquenessCache<K, V> {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock rlock = this.rwl().readLock();
    private final ReentrantReadWriteLock.WriteLock wlock = this.rwl().writeLock();
    private final WeakHashMap<K, WeakReference<V>> map = new WeakHashMap();

    private ReentrantReadWriteLock rwl() {
        return this.rwl;
    }

    private ReentrantReadWriteLock.ReadLock rlock() {
        return this.rlock;
    }

    private ReentrantReadWriteLock.WriteLock wlock() {
        return this.wlock;
    }

    private WeakHashMap<K, WeakReference<V>> map() {
        return this.map;
    }

    public abstract V valueFromKey(K var1);

    public abstract Option<K> keyFromValue(V var1);

    /*
     * WARNING - void declaration
     */
    public V apply(K name) {
        void var2_2;
        Object res = this.cached$1(name);
        if (res == null) {
            return (V)this.updateCache$1(name);
        }
        return var2_2;
    }

    public Option<K> unapply(V other) {
        return this.keyFromValue(other);
    }

    private final Object cached$1(Object name$1) {
        Object v0;
        this.rlock().lock();
        try {
            WeakReference<V> reference = this.map().get(name$1);
            v0 = reference == null ? null : reference.get();
        }
        finally {
            this.rlock().unlock();
        }
        return v0;
    }

    /*
     * WARNING - void declaration
     */
    private final Object updateCache$1(Object name$1) {
        Object object;
        this.wlock().lock();
        try {
            Object res = this.cached$1(name$1);
            if (res != null) {
                object = res;
            } else {
                void var3_3;
                this.map().remove(name$1);
                V sym = this.valueFromKey(name$1);
                this.map().put(name$1, new WeakReference<V>(sym));
                object = var3_3;
            }
        }
        finally {
            this.wlock().unlock();
        }
        return object;
    }
}

