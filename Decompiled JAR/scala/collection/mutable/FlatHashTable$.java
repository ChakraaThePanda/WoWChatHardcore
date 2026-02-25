/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Predef$;
import scala.math.package$;
import scala.util.Random;

public final class FlatHashTable$ {
    public static FlatHashTable$ MODULE$;

    static {
        new FlatHashTable$();
    }

    public final ThreadLocal<Random> seedGenerator() {
        return new ThreadLocal<Random>(){

            public Random initialValue() {
                return new Random();
            }
        };
    }

    public int defaultLoadFactor() {
        return 450;
    }

    public final int loadFactorDenum() {
        return 1000;
    }

    public int sizeForThreshold(int size, int _loadFactor) {
        return package$.MODULE$.max(32, (int)((long)size * (long)this.loadFactorDenum() / (long)_loadFactor));
    }

    /*
     * WARNING - void declaration
     */
    public int newThreshold(int _loadFactor, int size) {
        void assert_assertion;
        boolean bl;
        boolean bl2 = bl = _loadFactor < this.loadFactorDenum() / 2;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)FlatHashTable$.$anonfun$newThreshold$1()).toString());
        }
        return (int)((long)size * (long)_loadFactor / (long)this.loadFactorDenum());
    }

    public static final /* synthetic */ String $anonfun$newThreshold$1() {
        return "loadFactor too large; must be < 0.5";
    }

    private FlatHashTable$() {
        MODULE$ = this;
    }
}

