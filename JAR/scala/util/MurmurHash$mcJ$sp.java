/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Function1$mcVJ$sp;
import scala.runtime.Statics;
import scala.util.MurmurHash;
import scala.util.MurmurHash$;

public class MurmurHash$mcJ$sp
extends MurmurHash<Object>
implements Function1$mcVJ$sp {
    private final int seed;

    @Override
    public void apply(long t) {
        this.apply$mcJ$sp(t);
    }

    @Override
    public void apply$mcJ$sp(long t) {
        this.scala$util$MurmurHash$$h_$eq(MurmurHash$.MODULE$.extendHash(this.scala$util$MurmurHash$$h(), Statics.longHash(t), this.scala$util$MurmurHash$$c(), this.scala$util$MurmurHash$$k()));
        this.scala$util$MurmurHash$$c_$eq(MurmurHash$.MODULE$.nextMagicA(this.scala$util$MurmurHash$$c()));
        this.scala$util$MurmurHash$$k_$eq(MurmurHash$.MODULE$.nextMagicB(this.scala$util$MurmurHash$$k()));
        this.scala$util$MurmurHash$$hashed_$eq(false);
    }

    public MurmurHash$mcJ$sp(int seed) {
        this.seed = seed;
        super(seed);
    }
}

