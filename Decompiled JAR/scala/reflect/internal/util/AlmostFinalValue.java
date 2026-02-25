/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.SwitchPoint;

public class AlmostFinalValue {
    private final AlmostFinalCallSite callsite = new AlmostFinalCallSite(this);

    protected boolean initialValue() {
        return false;
    }

    public MethodHandle createGetter() {
        return this.callsite.dynamicInvoker();
    }

    public void setValue(boolean value) {
        this.callsite.setValue(value);
    }

    private static class AlmostFinalCallSite
    extends MutableCallSite {
        private Boolean value;
        private SwitchPoint switchPoint;
        private final AlmostFinalValue volatileFinalValue;
        private final MethodHandle fallback;
        private final Object lock;
        private static final Boolean NONE = null;
        private static final MethodHandle FALLBACK;

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        AlmostFinalCallSite(AlmostFinalValue volatileFinalValue) {
            super(MethodType.methodType(Boolean.TYPE));
            Object lock = new Object();
            MethodHandle fallback = FALLBACK.bindTo(this);
            Object object = lock;
            synchronized (object) {
                this.value = null;
                this.switchPoint = new SwitchPoint();
                this.setTarget(fallback);
            }
            this.volatileFinalValue = volatileFinalValue;
            this.lock = lock;
            this.fallback = fallback;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean fallback() {
            Object object = this.lock;
            synchronized (object) {
                Boolean value = this.value;
                if (value == NONE) {
                    value = this.volatileFinalValue.initialValue();
                }
                MethodHandle target = this.switchPoint.guardWithTest(MethodHandles.constant(Boolean.TYPE, value), this.fallback);
                this.setTarget(target);
                return value;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void setValue(boolean value) {
            Object object = this.lock;
            synchronized (object) {
                SwitchPoint switchPoint = this.switchPoint;
                this.value = value;
                this.switchPoint = new SwitchPoint();
                SwitchPoint.invalidateAll(new SwitchPoint[]{switchPoint});
            }
        }

        static {
            try {
                FALLBACK = MethodHandles.lookup().findVirtual(AlmostFinalCallSite.class, "fallback", MethodType.methodType(Boolean.TYPE));
            }
            catch (IllegalAccessException | NoSuchMethodException e) {
                throw new AssertionError(e.getMessage(), e);
            }
        }
    }
}

