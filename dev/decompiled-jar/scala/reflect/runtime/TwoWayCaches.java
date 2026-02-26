/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.lang.ref.WeakReference;
import scala.Function0;
import scala.Option;
import scala.Some;
import scala.collection.mutable.WeakHashMap;
import scala.reflect.ScalaSignature;
import scala.reflect.runtime.SymbolTable;
import scala.reflect.runtime.TwoWayCaches$TwoWayCache$SomeRef$;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u0005-aA\u0003\t\u0012!\u0003\r\t!E\f\u0002\u0004!)A\u0004\u0001C\u0001=\u0019!!\u0005\u0001\u0001$\u0011\u0015)#\u0001\"\u0001'\u0011\u001d9$A1A\u0005\naBaa\u0013\u0002!\u0002\u0013I\u0004b\u0002'\u0003\u0005\u0004%I!\u0014\u0005\u0007!\n\u0001\u000b\u0011\u0002(\t\u000bE\u0013A\u0011\u0001*\b\u000b]\u0013\u0001\u0012\u0002-\u0007\u000bi\u0013\u0001\u0012B.\t\u000b\u0015RA\u0011\u0001/\t\u000buSA\u0011\u00010\t\u000b)\u0014A\u0011A6\t\u000bQ\u0014A\u0011A;\t\u000bi\u0014A\u0011A>\u0003\u0019Q;xnV1z\u0007\u0006\u001c\u0007.Z:\u000b\u0005I\u0019\u0012a\u0002:v]RLW.\u001a\u0006\u0003)U\tqA]3gY\u0016\u001cGOC\u0001\u0017\u0003\u0015\u00198-\u00197b'\t\u0001\u0001\u0004\u0005\u0002\u001a55\tQ#\u0003\u0002\u001c+\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$3\u0001\u0001\u000b\u0002?A\u0011\u0011\u0004I\u0005\u0003CU\u0011A!\u00168ji\nYAk^8XCf\u001c\u0015m\u00195f+\r!3&N\n\u0003\u0005a\ta\u0001P5oSRtD#A\u0014\u0011\t!\u0012\u0011\u0006N\u0007\u0002\u0001A\u0011!f\u000b\u0007\u0001\t\u0015a#A1\u0001.\u0005\u0005Q\u0015C\u0001\u00182!\tIr&\u0003\u00021+\t9aj\u001c;iS:<\u0007CA\r3\u0013\t\u0019TCA\u0002B]f\u0004\"AK\u001b\u0005\u000bY\u0012!\u0019A\u0017\u0003\u0003M\u000b!\u0002^8TG\u0006d\u0017-T1q+\u0005I\u0004\u0003\u0002\u001e@S\u0005k\u0011a\u000f\u0006\u0003yu\nq!\\;uC\ndWM\u0003\u0002?+\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005\u0001[$aC,fC.D\u0015m\u001d5NCB\u00042AQ%5\u001b\u0005\u0019%B\u0001#F\u0003\r\u0011XM\u001a\u0006\u0003\r\u001e\u000bA\u0001\\1oO*\t\u0001*\u0001\u0003kCZ\f\u0017B\u0001&D\u000559V-Y6SK\u001a,'/\u001a8dK\u0006YAo\\*dC2\fW*\u00199!\u0003%!xNS1wC6\u000b\u0007/F\u0001O!\u0011Qt\bN(\u0011\u0007\tK\u0015&\u0001\u0006u_*\u000bg/Y'ba\u0002\nQ!\u001a8uKJ$2aH*V\u0011\u0015!\u0006\u00021\u0001*\u0003\u0005Q\u0007\"\u0002,\t\u0001\u0004!\u0014!A:\u0002\u000fM{W.\u001a*fMB\u0011\u0011LC\u0007\u0002\u0005\t91k\\7f%\u001647C\u0001\u0006\u0019)\u0005A\u0016aB;oCB\u0004H._\u000b\u0003?\u0012$\"\u0001\u00194\u0011\u0007e\t7-\u0003\u0002c+\t1q\n\u001d;j_:\u0004\"A\u000b3\u0005\u000b\u0015d!\u0019A\u0017\u0003\u0003QCQa\u001a\u0007A\u0002!\faa\u001c9u%\u00164\u0007cA\rbSB\u0019!)S2\u0002\u000fQ|7kY1mCR\u0011AN\u001d\u000b\u0003i5DaA\\\u0007\u0005\u0002\u0004y\u0017\u0001\u00022pIf\u00042!\u000795\u0013\t\tXC\u0001\u0005=Eft\u0017-\\3?\u0011\u0015\u0019X\u00021\u0001*\u0003\rYW-_\u0001\u0007i>T\u0015M^1\u0015\u0005YLHCA\u0015x\u0011\u0019qg\u0002\"a\u0001qB\u0019\u0011\u0004]\u0015\t\u000bMt\u0001\u0019\u0001\u001b\u0002\u0019Q|'*\u0019<b\u001fB$\u0018n\u001c8\u0015\u0007q\f\t\u0001\u0006\u0002~}B\u0019\u0011$Y\u0015\t\r9|A\u00111\u0001\u0000!\rI\u0002/ \u0005\u0006g>\u0001\r\u0001\u000e\t\u0005\u0003\u000b\t9!D\u0001\u0012\u0013\r\tI!\u0005\u0002\f'fl'm\u001c7UC\ndW\r")
public interface TwoWayCaches {
    public static void $init$(TwoWayCaches $this) {
    }

    public static class TwoWayCache<J, S> {
        private volatile TwoWayCaches$TwoWayCache$SomeRef$ SomeRef$module;
        private final WeakHashMap<J, WeakReference<S>> toScalaMap;
        private final WeakHashMap<S, WeakReference<J>> toJavaMap;
        public final /* synthetic */ SymbolTable $outer;

        private TwoWayCaches$TwoWayCache$SomeRef$ SomeRef() {
            if (this.SomeRef$module == null) {
                this.SomeRef$lzycompute$1();
            }
            return this.SomeRef$module;
        }

        private WeakHashMap<J, WeakReference<S>> toScalaMap() {
            return this.toScalaMap;
        }

        private WeakHashMap<S, WeakReference<J>> toJavaMap() {
            return this.toJavaMap;
        }

        public void enter(J j, S s) {
            SymbolTable symbolTable = this.scala$reflect$runtime$TwoWayCaches$TwoWayCache$$$outer();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable gilSynchronized_this = symbolTable;
            if (gilSynchronized_this.isCompilerUniverse()) {
                TwoWayCache.$anonfun$enter$1(this, j, s);
                return;
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                TwoWayCache.$anonfun$enter$1(this, j, s);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
        }

        public S toScala(J key, Function0<S> body) {
            Object object;
            SymbolTable symbolTable = this.scala$reflect$runtime$TwoWayCaches$TwoWayCache$$$outer();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable gilSynchronized_this = symbolTable;
            if (gilSynchronized_this.isCompilerUniverse()) {
                return (S)TwoWayCache.$anonfun$toScala$1(this, key, body);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                object = TwoWayCache.$anonfun$toScala$1(this, key, body);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return (S)object;
        }

        public J toJava(S key, Function0<J> body) {
            Object object;
            SymbolTable symbolTable = this.scala$reflect$runtime$TwoWayCaches$TwoWayCache$$$outer();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable gilSynchronized_this = symbolTable;
            if (gilSynchronized_this.isCompilerUniverse()) {
                return (J)TwoWayCache.$anonfun$toJava$1(this, key, body);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                object = TwoWayCache.$anonfun$toJava$1(this, key, body);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return (J)object;
        }

        public Option<J> toJavaOption(S key, Function0<Option<J>> body) {
            Option option;
            SymbolTable symbolTable = this.scala$reflect$runtime$TwoWayCaches$TwoWayCache$$$outer();
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable gilSynchronized_this = symbolTable;
            if (gilSynchronized_this.isCompilerUniverse()) {
                return TwoWayCache.$anonfun$toJavaOption$1(this, key, body);
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                option = TwoWayCache.$anonfun$toJavaOption$1(this, key, body);
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return option;
        }

        public /* synthetic */ SymbolTable scala$reflect$runtime$TwoWayCaches$TwoWayCache$$$outer() {
            return this.$outer;
        }

        private final void SomeRef$lzycompute$1() {
            synchronized (this) {
                if (this.SomeRef$module == null) {
                    this.SomeRef$module = new TwoWayCaches$TwoWayCache$SomeRef$(this);
                }
                return;
            }
        }

        public static final /* synthetic */ void $anonfun$enter$1(TwoWayCache $this, Object j$1, Object s$1) {
            $this.toScalaMap().update(j$1, new WeakReference<Object>(s$1));
            $this.toJavaMap().update(s$1, new WeakReference<Object>(j$1));
        }

        public static final /* synthetic */ Object $anonfun$toScala$1(TwoWayCache $this, Object key$1, Function0 body$1) {
            Object object;
            Option option = $this.toScalaMap().get((Object)key$1);
            Option option2 = $this.SomeRef().unapply(option);
            if (!option2.isEmpty()) {
                object = option2.get();
            } else {
                Object result2 = body$1.apply();
                $this.enter(key$1, result2);
                object = result2;
            }
            return object;
        }

        public static final /* synthetic */ Object $anonfun$toJava$1(TwoWayCache $this, Object key$2, Function0 body$2) {
            Object object;
            Option option = $this.toJavaMap().get((Object)key$2);
            Option option2 = $this.SomeRef().unapply(option);
            if (!option2.isEmpty()) {
                object = option2.get();
            } else {
                Object result2 = body$2.apply();
                $this.enter(result2, key$2);
                object = result2;
            }
            return object;
        }

        public static final /* synthetic */ Option $anonfun$toJavaOption$1(TwoWayCache $this, Object key$3, Function0 body$3) {
            Option option;
            Option option2 = $this.toJavaMap().get((Object)key$3);
            Option option3 = $this.SomeRef().unapply(option2);
            if (!option3.isEmpty()) {
                Object v = option3.get();
                option = new Some(v);
            } else {
                Option result2 = (Option)body$3.apply();
                if (result2 == null) {
                    throw null;
                }
                if (!result2.isEmpty()) {
                    Object a = result2.get();
                    $this.enter(a, key$3);
                }
                option = result2;
            }
            return option;
        }

        public TwoWayCache(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.toScalaMap = new WeakHashMap();
            this.toJavaMap = new WeakHashMap();
        }

        public static final /* synthetic */ Object $anonfun$toJavaOption$2$adapted(TwoWayCache $this, Object key$3, Object value) {
            $this.enter(value, key$3);
            return BoxedUnit.UNIT;
        }
    }
}

