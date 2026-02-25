/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Seq;
import scala.collection.SortedSet;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;
import scala.collection.mutable.SetBuilder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005ua!\u0002\b\u0010\u0003\u00031\u0002\"\u0002\u000f\u0001\t\u0003iR\u0001B\u001e\u0001\u0001qBQ!\u0011\u0001\u0007\u0002\tCQ\u0001\u0015\u0001\u0005\u0002ECQA\u0018\u0001\u0005\u0002}CQ\u0001\u001c\u0001\u0005\u000454A!\u001f\u0001\u0001u\"I\u0001j\u0002B\u0001B\u0003-\u0011\u0011\u0001\u0005\u00079\u001d!\t!a\u0001\t\u0011\u0005-q\u0001\"\u0001\u0012\u0003\u001bA\u0001\"a\u0004\b\t\u0003\t\u0012\u0011\u0003\u0005\u0007!\u001e!\t!a\u0005\t\rA;A\u0011AA\u000e\u0005A\u0019vN\u001d;fIN+GOR1di>\u0014\u0018P\u0003\u0002\u0011#\u00059q-\u001a8fe&\u001c'B\u0001\n\u0014\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002)\u0005)1oY1mC\u000e\u0001QCA\f#'\t\u0001\u0001\u0004\u0005\u0002\u001a55\t1#\u0003\u0002\u001c'\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#\u0001\u0010\u0011\u0007}\u0001\u0001%D\u0001\u0010!\t\t#\u0005\u0004\u0001\u0005\u000b\r\u0002!\u0019\u0001\u0013\u0003\u0005\r\u001bUCA\u00132#\t1\u0013\u0006\u0005\u0002\u001aO%\u0011\u0001f\u0005\u0002\b\u001d>$\b.\u001b8h%\rQCf\u000e\u0004\u0005W\u0001\u0001\u0011F\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0002.]Aj\u0011!E\u0005\u0003_E\u0011\u0011bU8si\u0016$7+\u001a;\u0011\u0005\u0005\nD!\u0002\u001a#\u0005\u0004\u0019$!A!\u0012\u0005\u0019\"\u0004CA\r6\u0013\t14CA\u0002B]f\u0004B!\f\u001d1u%\u0011\u0011(\u0005\u0002\u000e'>\u0014H/\u001a3TKRd\u0015n[3\u0011\u0007\u0005\u0012\u0003G\u0001\u0003D_2d\u0007GA\u001f@!\r\t#E\u0010\t\u0003C}\"\u0011\u0002\u0011\u0002\u0002\u0002\u0003\u0005)\u0011A\u001a\u0003\u0007}#\u0013'A\u0003f[B$\u00180\u0006\u0002D\rR\u0011Ai\u0012\t\u0004C\t*\u0005CA\u0011G\t\u0015\u00114A1\u00014\u0011\u0015A5\u0001q\u0001J\u0003\ry'\u000f\u001a\t\u0004\u00156+eBA\rL\u0013\ta5#A\u0004qC\u000e\\\u0017mZ3\n\u00059{%\u0001C(sI\u0016\u0014\u0018N\\4\u000b\u00051\u001b\u0012!B1qa2LXC\u0001*W)\t\u0019\u0016\f\u0006\u0002U/B\u0019\u0011EI+\u0011\u0005\u00052F!\u0002\u001a\u0005\u0005\u0004\u0019\u0004\"\u0002%\u0005\u0001\bA\u0006c\u0001&N+\")!\f\u0002a\u00017\u0006)Q\r\\3ngB\u0019\u0011\u0004X+\n\u0005u\u001b\"A\u0003\u001fsKB,\u0017\r^3e}\u0005Qa.Z<Ck&dG-\u001a:\u0016\u0005\u0001DGCA1k!\u0011\u0011WmZ5\u000e\u0003\rT!\u0001Z\t\u0002\u000f5,H/\u00192mK&\u0011am\u0019\u0002\b\u0005VLG\u000eZ3s!\t\t\u0003\u000eB\u00033\u000b\t\u00071\u0007E\u0002\"E\u001dDQ\u0001S\u0003A\u0004-\u00042AS'h\u0003=qWm^\"b]\n+\u0018\u000e\u001c3Ge>lWC\u00018v)\tyw\u000fE\u0003 aJ$h/\u0003\u0002r\u001f\ta1)\u00198Ck&dGM\u0012:p[B\u00111OA\u0007\u0002\u0001A\u0011\u0011%\u001e\u0003\u0006e\u0019\u0011\ra\r\t\u0004C\t\"\b\"\u0002%\u0007\u0001\bA\bc\u0001&Ni\n)2k\u001c:uK\u0012\u001cV\r^\"b]\n+\u0018\u000e\u001c3Ge>lWCA>\u007f'\r9\u0001\u0004 \t\u0006?A\u0014Xp \t\u0003Cy$QAM\u0004C\u0002M\u00022!\t\u0012~!\rQU* \u000b\u0003\u0003\u000b!B!a\u0002\u0002\nA\u00191oB?\t\r!K\u00019AA\u0001\u0003\u001d1\u0017m\u0019;pef,\u0012AH\u0001\t_J$WM]5oOV\u0011\u0011\u0011\u0001\u000b\u0005\u0003+\t9\u0002\u0005\u0003cKv|\bBBA\r\u0019\u0001\u0007!/\u0001\u0003ge>lGCAA\u000b\u0001")
public abstract class SortedSetFactory<CC extends SortedSet<Object>> {
    public abstract <A> CC empty(Ordering<A> var1);

    public <A> CC apply(Seq<A> elems, Ordering<A> ord) {
        if (elems.isEmpty()) {
            return this.empty(ord);
        }
        return (CC)((SortedSet)((Builder)this.newBuilder(ord).$plus$plus$eq(elems)).result());
    }

    public <A> Builder<A, CC> newBuilder(Ordering<A> ord) {
        return new SetBuilder(this.empty(ord));
    }

    public <A> CanBuildFrom<CC, A, CC> newCanBuildFrom(Ordering<A> ord) {
        return new SortedSetCanBuildFrom<A>(this, ord);
    }

    public class SortedSetCanBuildFrom<A>
    implements CanBuildFrom<CC, A, CC> {
        private final Ordering<A> ord;
        public final /* synthetic */ SortedSetFactory $outer;

        public SortedSetFactory<CC> factory() {
            return this.scala$collection$generic$SortedSetFactory$SortedSetCanBuildFrom$$$outer();
        }

        public Ordering<A> ordering() {
            return this.ord;
        }

        @Override
        public Builder<A, CC> apply(CC from) {
            return this.scala$collection$generic$SortedSetFactory$SortedSetCanBuildFrom$$$outer().newBuilder(this.ord);
        }

        @Override
        public Builder<A, CC> apply() {
            return this.scala$collection$generic$SortedSetFactory$SortedSetCanBuildFrom$$$outer().newBuilder(this.ord);
        }

        public /* synthetic */ SortedSetFactory scala$collection$generic$SortedSetFactory$SortedSetCanBuildFrom$$$outer() {
            return this.$outer;
        }

        public SortedSetCanBuildFrom(SortedSetFactory $outer, Ordering<A> ord) {
            this.ord = ord;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

