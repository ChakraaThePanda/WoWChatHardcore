/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

class BooleanContainer {
    private final boolean value;

    public BooleanContainer(boolean value) {
        this.value = value;
    }

    public boolean isEnabledNow() {
        return this.value;
    }

    protected static final class FalseContainer
    extends BooleanContainer {
        FalseContainer() {
            super(false);
        }
    }

    protected static final class TrueContainer
    extends BooleanContainer {
        TrueContainer() {
            super(true);
        }
    }
}

