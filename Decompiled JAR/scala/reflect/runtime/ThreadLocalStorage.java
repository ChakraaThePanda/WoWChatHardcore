/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import scala.Function0;
import scala.reflect.ScalaSignature;
import scala.reflect.runtime.SymbolTable;

@ScalaSignature(bytes="\u0006\u0001\u00194\u0011\"\u0004\b\u0011\u0002\u0007\u0005\u0001\u0003\u00062\t\u000be\u0001A\u0011A\u000e\u0007\u000f5\u0001\u0001\u0013aI\u0001?!)\u0011E\u0001D\u0001E!)aF\u0001D\u0001_\u0019!!\u0007\u0001\u00034\u0011!ITA!A%\u0002\u0013Q\u0004\"B\u001f\u0006\t\u0003q\u0004bB!\u0006\u0005\u0004%IA\u0011\u0005\u0007#\u0016\u0001\u000b\u0011B\"\t\u000b\u0005*A\u0011\u0001*\t\u000b9*A\u0011A*\t\u000bU\u0003AQ\u0001,\u0003%QC'/Z1e\u0019>\u001c\u0017\r\\*u_J\fw-\u001a\u0006\u0003\u001fA\tqA];oi&lWM\u0003\u0002\u0012%\u00059!/\u001a4mK\u000e$(\"A\n\u0002\u000bM\u001c\u0017\r\\1\u0014\u0005\u0001)\u0002C\u0001\f\u0018\u001b\u0005\u0011\u0012B\u0001\r\u0013\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\u001a\u0001\u0001F\u0001\u001d!\t1R$\u0003\u0002\u001f%\t!QK\\5u+\t\u0001Se\u0005\u0002\u0003+\u0005\u0019q-\u001a;\u0016\u0003\r\u0002\"\u0001J\u0013\r\u0001\u0011)aE\u0001b\u0001O\t\tA+\u0005\u0002)WA\u0011a#K\u0005\u0003UI\u0011qAT8uQ&tw\r\u0005\u0002\u0017Y%\u0011QF\u0005\u0002\u0004\u0003:L\u0018aA:fiR\u0011A\u0004\r\u0005\u0006c\u0011\u0001\raI\u0001\t]\u0016<h+\u00197vK\n!R*\u001f+ie\u0016\fG\rT8dC2\u001cFo\u001c:bO\u0016,\"\u0001\u000e\u001d\u0014\u0007\u0015)R\u0007E\u00027\u0005]j\u0011\u0001\u0001\t\u0003Ia\"QAJ\u0003C\u0002\u001d\nA\"\u001b8ji&\fGNV1mk\u0016\u00042AF\u001e8\u0013\ta$C\u0001\u0005=Eft\u0017-\\3?\u0003\u0019a\u0014N\\5u}Q\u0011q\b\u0011\t\u0004m\u00159\u0004BB\u001d\b\t\u0003\u0007!(\u0001\u0004wC2,Xm]\u000b\u0002\u0007B!A)S&8\u001b\u0005)%B\u0001$H\u0003\u0011)H/\u001b7\u000b\u0003!\u000bAA[1wC&\u0011!*\u0012\u0002\u0004\u001b\u0006\u0004\bC\u0001'P\u001b\u0005i%B\u0001(H\u0003\u0011a\u0017M\\4\n\u0005Ak%A\u0002+ie\u0016\fG-A\u0004wC2,Xm\u001d\u0011\u0016\u0003]\"\"\u0001\b+\t\u000bEZ\u0001\u0019A\u001c\u0002)5\\G\u000b\u001b:fC\u0012dunY1m'R|'/Y4f+\t9&\f\u0006\u0002Y7B\u0019aGA-\u0011\u0005\u0011RF!\u0002\u0014\r\u0005\u00049\u0003B\u0002/\r\t\u0003\u0007Q,A\u0001y!\r12(\u0017\u0015\u0003\u0019}\u0003\"A\u00061\n\u0005\u0005\u0014\"AB5oY&tW\r\u0005\u0002dI6\ta\"\u0003\u0002f\u001d\tY1+_7c_2$\u0016M\u00197f\u0001")
public interface ThreadLocalStorage {
    public static /* synthetic */ ThreadLocalStorage mkThreadLocalStorage$(ThreadLocalStorage $this, Function0 x) {
        return $this.mkThreadLocalStorage(x);
    }

    default public <T> ThreadLocalStorage<T> mkThreadLocalStorage(Function0<T> x) {
        return new MyThreadLocalStorage<T>((SymbolTable)this, x);
    }

    public static void $init$(ThreadLocalStorage $this) {
    }

    private class MyThreadLocalStorage<T>
    implements ThreadLocalStorage<T> {
        private final Function0<T> initialValue;
        private final Map<Thread, T> values;
        public final /* synthetic */ SymbolTable $outer;

        private Map<Thread, T> values() {
            return this.values;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public T get() {
            void var1_1;
            if (this.values().containsKey(Thread.currentThread())) {
                return this.values().get(Thread.currentThread());
            }
            T value = this.initialValue.apply();
            this.values().put(Thread.currentThread(), value);
            return var1_1;
        }

        @Override
        public void set(T newValue) {
            this.values().put(Thread.currentThread(), newValue);
        }

        public /* synthetic */ SymbolTable scala$reflect$runtime$ThreadLocalStorage$MyThreadLocalStorage$$$outer() {
            return this.$outer;
        }

        public MyThreadLocalStorage(SymbolTable $outer, Function0<T> initialValue) {
            this.initialValue = initialValue;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.values = Collections.synchronizedMap(new WeakHashMap());
        }
    }

    public interface ThreadLocalStorage<T> {
        public T get();

        public void set(T var1);
    }
}

