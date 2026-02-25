/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.MatchError;
import scala.Tuple2;
import scala.collection.generic.BitOperations;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.IntMap;
import scala.collection.immutable.IntMap$Nil$;

public final class IntMapUtils$
implements BitOperations.Int {
    public static IntMapUtils$ MODULE$;

    static {
        new IntMapUtils$();
    }

    @Override
    public boolean zero(int i, int mask) {
        return BitOperations.Int.zero$(this, i, mask);
    }

    @Override
    public int mask(int i, int mask) {
        return BitOperations.Int.mask$(this, i, mask);
    }

    @Override
    public boolean hasMatch(int key, int prefix, int m) {
        return BitOperations.Int.hasMatch$(this, key, prefix, m);
    }

    @Override
    public boolean unsignedCompare(int i, int j) {
        return BitOperations.Int.unsignedCompare$(this, i, j);
    }

    @Override
    public boolean shorter(int m1, int m2) {
        return BitOperations.Int.shorter$(this, m1, m2);
    }

    @Override
    public int complement(int i) {
        return BitOperations.Int.complement$(this, i);
    }

    @Override
    public IndexedSeq<Object> bits(int num) {
        return BitOperations.Int.bits$(this, num);
    }

    @Override
    public String bitString(int num, String sep) {
        return BitOperations.Int.bitString$(this, num, sep);
    }

    @Override
    public String bitString$default$2() {
        return BitOperations.Int.bitString$default$2$(this);
    }

    @Override
    public int highestOneBit(int j) {
        return BitOperations.Int.highestOneBit$(this, j);
    }

    public int branchMask(int i, int j) {
        return this.highestOneBit(i ^ j);
    }

    public <T> IntMap<T> join(int p1, IntMap<T> t1, int p2, IntMap<T> t2) {
        int m = this.branchMask(p1, p2);
        int p = this.mask(p1, m);
        if (this.zero(p1, m)) {
            return new IntMap.Bin<T>(p, m, t1, t2);
        }
        return new IntMap.Bin<T>(p, m, t2, t1);
    }

    public <T> IntMap<T> bin(int prefix, int mask, IntMap<T> left, IntMap<T> right) {
        IntMap<T> intMap;
        Tuple2<IntMap<T>, IntMap<T>> tuple2 = new Tuple2<IntMap<T>, IntMap<T>>(left, right);
        IntMap<T> left2 = left;
        IntMap<T> intMap2 = right;
        if (((Object)IntMap$Nil$.MODULE$).equals(intMap2)) {
            intMap = left2;
        } else {
            IntMap<T> intMap3 = left;
            IntMap<T> right2 = right;
            if (((Object)IntMap$Nil$.MODULE$).equals(intMap3)) {
                intMap = right2;
            } else if (tuple2 != null) {
                IntMap<T> left3 = left;
                IntMap<T> right3 = right;
                intMap = new IntMap.Bin<T>(prefix, mask, left3, right3);
            } else {
                throw new MatchError((Object)null);
            }
        }
        return intMap;
    }

    private IntMapUtils$() {
        MODULE$ = this;
        BitOperations.Int.$init$(this);
    }
}

