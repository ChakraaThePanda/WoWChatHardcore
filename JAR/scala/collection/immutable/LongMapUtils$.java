/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.MatchError;
import scala.Tuple2;
import scala.collection.generic.BitOperations;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.LongMap;
import scala.collection.immutable.LongMap$Nil$;

public final class LongMapUtils$
implements BitOperations.Long {
    public static LongMapUtils$ MODULE$;

    static {
        new LongMapUtils$();
    }

    @Override
    public boolean zero(long i, long mask) {
        return BitOperations.Long.zero$(this, i, mask);
    }

    @Override
    public long mask(long i, long mask) {
        return BitOperations.Long.mask$(this, i, mask);
    }

    @Override
    public boolean hasMatch(long key, long prefix, long m) {
        return BitOperations.Long.hasMatch$(this, key, prefix, m);
    }

    @Override
    public boolean unsignedCompare(long i, long j) {
        return BitOperations.Long.unsignedCompare$(this, i, j);
    }

    @Override
    public boolean shorter(long m1, long m2) {
        return BitOperations.Long.shorter$(this, m1, m2);
    }

    @Override
    public long complement(long i) {
        return BitOperations.Long.complement$(this, i);
    }

    @Override
    public IndexedSeq<Object> bits(long num) {
        return BitOperations.Long.bits$(this, num);
    }

    @Override
    public String bitString(long num, String sep) {
        return BitOperations.Long.bitString$(this, num, sep);
    }

    @Override
    public String bitString$default$2() {
        return BitOperations.Long.bitString$default$2$(this);
    }

    @Override
    public long highestOneBit(long j) {
        return BitOperations.Long.highestOneBit$(this, j);
    }

    public long branchMask(long i, long j) {
        return this.highestOneBit(i ^ j);
    }

    public <T> LongMap<T> join(long p1, LongMap<T> t1, long p2, LongMap<T> t2) {
        long m = this.branchMask(p1, p2);
        long p = this.mask(p1, m);
        if (this.zero(p1, m)) {
            return new LongMap.Bin<T>(p, m, t1, t2);
        }
        return new LongMap.Bin<T>(p, m, t2, t1);
    }

    public <T> LongMap<T> bin(long prefix, long mask, LongMap<T> left, LongMap<T> right) {
        LongMap<T> longMap;
        Tuple2<LongMap<T>, LongMap<T>> tuple2 = new Tuple2<LongMap<T>, LongMap<T>>(left, right);
        LongMap<T> left2 = left;
        LongMap<T> longMap2 = right;
        if (((Object)LongMap$Nil$.MODULE$).equals(longMap2)) {
            longMap = left2;
        } else {
            LongMap<T> longMap3 = left;
            LongMap<T> right2 = right;
            if (((Object)LongMap$Nil$.MODULE$).equals(longMap3)) {
                longMap = right2;
            } else if (tuple2 != null) {
                LongMap<T> left3 = left;
                LongMap<T> right3 = right;
                longMap = new LongMap.Bin<T>(prefix, mask, left3, right3);
            } else {
                throw new MatchError((Object)null);
            }
        }
        return longMap;
    }

    private LongMapUtils$() {
        MODULE$ = this;
        BitOperations.Long.$init$(this);
    }
}

