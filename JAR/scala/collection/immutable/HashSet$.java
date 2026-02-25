/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Predef$;
import scala.Serializable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.ImmutableSetFactory;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.HashSet$EmptyHashSet$;
import scala.collection.mutable.Builder;
import scala.runtime.RichInt$;
import scala.runtime.Statics;

public final class HashSet$
extends ImmutableSetFactory<HashSet>
implements Serializable {
    public static HashSet$ MODULE$;
    private final CanBuildFrom<HashSet<?>, Object, HashSet<Object>> ReusableCBF;

    static {
        new HashSet$();
    }

    @Override
    public <A> Builder<A, HashSet<A>> newBuilder() {
        return new HashSet.HashSetBuilder();
    }

    public <A> CanBuildFrom<HashSet<?>, A, HashSet<A>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public HashSet<Object> emptyInstance() {
        return HashSet$EmptyHashSet$.MODULE$;
    }

    public <A> HashSet.HashTrieSet<A> scala$collection$immutable$HashSet$$makeHashTrieSet(int hash0, HashSet<A> elem0, int hash1, HashSet<A> elem1, int level, int newSize) {
        int index0 = hash0 >>> level & 0x1F;
        int index1 = hash1 >>> level & 0x1F;
        if (index0 != index1) {
            int bitmap = 1 << index0 | 1 << index1;
            HashSet[] elems = new HashSet[2];
            if (index0 < index1) {
                elems[0] = elem0;
                elems[1] = elem1;
            } else {
                elems[0] = elem1;
                elems[1] = elem0;
            }
            return new HashSet.HashTrieSet(bitmap, elems, newSize);
        }
        int bitmap = 1 << index0;
        HashSet.HashTrieSet<A> child = this.scala$collection$immutable$HashSet$$makeHashTrieSet(hash0, elem0, hash1, elem1, level + 5, newSize);
        HashSet[] elems = new HashSet[]{child};
        return new HashSet.HashTrieSet(bitmap, elems, newSize);
    }

    public int elemHashCode(Object key) {
        return Statics.anyHash(key);
    }

    public final int improve(int hcode) {
        int h = hcode + ~(hcode << 9);
        h ^= h >>> 14;
        h += h << 4;
        return h ^ h >>> 10;
    }

    public int computeHash(Object key) {
        return this.improve(this.elemHashCode(key));
    }

    public int scala$collection$immutable$HashSet$$bufferSize(int size) {
        int n = size + 6;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichInt$.MODULE$.min$extension(n, 224);
    }

    public <A> HashSet<A> scala$collection$immutable$HashSet$$nullToEmpty(HashSet<A> s) {
        if (s == null) {
            return (HashSet)this.empty();
        }
        return s;
    }

    /*
     * WARNING - void declaration
     */
    public int scala$collection$immutable$HashSet$$keepBits(int bitmap, int keep) {
        void var3_3;
        int result2 = 0;
        int current = bitmap;
        for (int kept = keep; kept != 0; kept >>>= 1) {
            int lsb = current ^ current & current - 1;
            if ((kept & 1) != 0) {
                result2 |= lsb;
            }
            current &= ~lsb;
        }
        return (int)var3_3;
    }

    public boolean scala$collection$immutable$HashSet$$unsignedCompare(int i, int j) {
        return i < j ^ i < 0 ^ j < 0;
    }

    private Object readResolve() {
        return MODULE$;
    }

    private HashSet$() {
        MODULE$ = this;
        this.ReusableCBF = this.setCanBuildFrom();
    }
}

