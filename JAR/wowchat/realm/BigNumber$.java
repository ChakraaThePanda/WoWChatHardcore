/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import java.security.SecureRandom;
import scala.Predef$;
import scala.Serializable;
import scala.math.BigInt;
import scala.package$;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcVI$sp;
import wowchat.realm.BigNumber;

public final class BigNumber$ {
    public static BigNumber$ MODULE$;

    static {
        new BigNumber$();
    }

    public BigNumber apply(BigInt value) {
        return new BigNumber(value);
    }

    public BigNumber apply(String value) {
        return this.apply(value, 16);
    }

    public BigNumber apply(String value, int radix) {
        return new BigNumber(package$.MODULE$.BigInt().apply(value, radix));
    }

    public BigNumber apply(byte[] array, boolean reverse) {
        BigNumber bigNumber;
        if (reverse) {
            int length = array.length;
            RichInt$.MODULE$.until$extension0(Predef$.MODULE$.intWrapper(0), length / 2).foreach$mVc$sp((JFunction1$mcVI$sp & Serializable)i -> {
                byte j = array[i];
                array$1[i] = array[length - i - 1];
                array$1[length$1 - i - 1] = j;
            });
        }
        if (array[0] < 0) {
            byte[] tmp = new byte[array.length + 1];
            System.arraycopy(array, 0, tmp, 1, array.length);
            bigNumber = new BigNumber(package$.MODULE$.BigInt().apply(tmp));
        } else {
            bigNumber = new BigNumber(package$.MODULE$.BigInt().apply(array));
        }
        return bigNumber;
    }

    public boolean apply$default$2() {
        return false;
    }

    public BigNumber rand(int amount) {
        return new BigNumber(package$.MODULE$.BigInt().apply(1, new SecureRandom().generateSeed(amount)));
    }

    private BigNumber$() {
        MODULE$ = this;
    }
}

