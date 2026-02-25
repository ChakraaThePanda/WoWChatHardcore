/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

public final class HashTable$ {
    public static HashTable$ MODULE$;

    static {
        new HashTable$();
    }

    public final int defaultLoadFactor() {
        return 750;
    }

    public final int loadFactorDenum() {
        return 1000;
    }

    public final int newThreshold(int _loadFactor, int size) {
        return (int)((long)size * (long)_loadFactor / (long)this.loadFactorDenum());
    }

    public final int sizeForThreshold(int _loadFactor, int thr) {
        return (int)((long)thr * (long)this.loadFactorDenum() / (long)_loadFactor);
    }

    public final int capacity(int expectedSize) {
        return this.nextPositivePowerOfTwo(expectedSize);
    }

    public int nextPositivePowerOfTwo(int target) {
        return 1 << -Integer.numberOfLeadingZeros(target - 1);
    }

    private HashTable$() {
        MODULE$ = this;
    }
}

