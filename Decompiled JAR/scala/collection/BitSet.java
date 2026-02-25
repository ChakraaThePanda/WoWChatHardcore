/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.BitSet$;
import scala.collection.BitSetLike;
import scala.collection.SortedSet;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u001d3qa\u0003\u0007\u0011\u0002\u0007\u0005\u0011\u0003C\u0003\"\u0001\u0011\u0005!\u0005C\u0003'\u0001\u0011\u0005seB\u0003)\u0019!\u0005\u0011FB\u0003\f\u0019!\u0005!\u0006C\u00032\t\u0011\u0005!\u0007C\u0004'\t\t\u0007I\u0011A\u0014\t\rM\"\u0001\u0015!\u0003!\u0011\u0015!D\u0001\"\u00016\u0011\u001d\tEA1A\u0005\u0004\tCaA\u0012\u0003!\u0002\u0013\u0019%A\u0002\"jiN+GO\u0003\u0002\u000e\u001d\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003=\tQa]2bY\u0006\u001c\u0001a\u0005\u0003\u0001%Yi\u0002CA\n\u0015\u001b\u0005q\u0011BA\u000b\u000f\u0005\u0019\te.\u001f*fMB\u0019q\u0003\u0007\u000e\u000e\u00031I!!\u0007\u0007\u0003\u0013M{'\u000f^3e'\u0016$\bCA\n\u001c\u0013\tabBA\u0002J]R\u00042a\u0006\u0010!\u0013\tyBB\u0001\u0006CSR\u001cV\r\u001e'jW\u0016\u0004\"a\u0006\u0001\u0002\r\u0011Jg.\u001b;%)\u0005\u0019\u0003CA\n%\u0013\t)cB\u0001\u0003V]&$\u0018!B3naRLX#\u0001\u0011\u0002\r\tKGoU3u!\t9BaE\u0002\u0005%-\u00022\u0001L\u0018!\u001b\u0005i#B\u0001\u0018\r\u0003\u001d9WM\\3sS\u000eL!\u0001M\u0017\u0003\u001b\tKGoU3u\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\t\u0011&\u0001\u0004f[B$\u0018\u0010I\u0001\u000b]\u0016<()^5mI\u0016\u0014X#\u0001\u001c\u0011\t]R$\u0004P\u0007\u0002q)\u0011\u0011\bD\u0001\b[V$\u0018M\u00197f\u0013\tY\u0004HA\u0004Ck&dG-\u001a:\u0011\u0005u\u0002U\"\u0001 \u000b\u0005}b\u0011!C5n[V$\u0018M\u00197f\u0013\tYa(\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.F\u0001D!\u0015aC\t\t\u000e!\u0013\t)UF\u0001\u0007DC:\u0014U/\u001b7e\rJ|W.A\u0007dC:\u0014U/\u001b7e\rJ|W\u000e\t")
public interface BitSet
extends SortedSet<Object>,
BitSetLike<BitSet> {
    public static CanBuildFrom<BitSet, Object, BitSet> canBuildFrom() {
        return BitSet$.MODULE$.canBuildFrom();
    }

    public static CanBuildFrom<BitSet, Object, BitSet> bitsetCanBuildFrom() {
        return BitSet$.MODULE$.bitsetCanBuildFrom();
    }

    public static /* synthetic */ BitSet empty$(BitSet $this) {
        return $this.empty();
    }

    @Override
    default public BitSet empty() {
        return BitSet$.MODULE$.empty();
    }

    public static void $init$(BitSet $this) {
    }
}

