/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Serializable;
import scala.Some;
import scala.collection.AbstractSeq;
import scala.collection.GenTraversable;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005eaaB\b\u0011!\u0003\r\ta\u0006\u0005\u0006u\u0001!\ta\u000f\u0005\u0006\u007f\u0001!\t\u0005\u0011\u0005\u0006\t\u0002!\t%\u0012\u0005\u0006\u001d\u0002!\t%R\u0004\u0006\u001fBA\t\u0001\u0015\u0004\u0006\u001fAA\t!\u0015\u0005\u0006+\u001a!\tA\u0016\u0004\u0005/\u001a\u0001\u0001\f\u0003\u0005d\u0011\t\u0005\t\u0015!\u0003e\u0011\u0015)\u0006\u0002\"\u0001k\u0011\u0015q\u0007\u0002\"\u0001p\u0011\u0015\u0019\b\u0002\"\u0001u\u0011\u00159h\u0001\"\u0001y\u0011\u001d\t\tA\u0002C\u0002\u0003\u0007\u0011!\"\u00138eKb,GmU3r\u0015\t\t\"#A\u0005j[6,H/\u00192mK*\u00111\u0003F\u0001\u000bG>dG.Z2uS>t'\"A\u000b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0001dI\n\u0007\u0001eiBf\f\u001c\u0011\u0005iYR\"\u0001\u000b\n\u0005q!\"AB!osJ+g\rE\u0002\u001f?\u0005j\u0011\u0001E\u0005\u0003AA\u00111aU3r!\t\u00113\u0005\u0004\u0001\u0005\r\u0011\u0002AQ1\u0001&\u0005\u0005\t\u0015C\u0001\u0014*!\tQr%\u0003\u0002))\t9aj\u001c;iS:<\u0007C\u0001\u000e+\u0013\tYCCA\u0002B]f\u00042!\f\u0018\"\u001b\u0005\u0011\u0012BA\b\u0013!\u0011\u00014'I\u001b\u000e\u0003ER!A\r\n\u0002\u000f\u001d,g.\u001a:jG&\u0011A'\r\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u0003=\u0001\u0001B!L\u001c\"s%\u0011\u0001H\u0005\u0002\u000f\u0013:$W\r_3e'\u0016\fH*[6f!\rq\u0002!I\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003q\u0002\"AG\u001f\n\u0005y\"\"\u0001B+oSR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003\u0005\u00032\u0001\r\"6\u0013\t\u0019\u0015G\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006aAo\\%oI\u0016DX\rZ*fcV\t\u0011\b\u000b\u0003\u0004\u000f*c\u0005C\u0001\u000eI\u0013\tIEC\u0001\u000beKB\u0014XmY1uK\u0012|e/\u001a:sS\u0012LgnZ\u0011\u0002\u0017\u0006a\u0017*\\7vi\u0006\u0014G.\u001a\u0011j]\u0012,\u00070\u001a3!g\u0016\fX/\u001a8dKN\u00043\u000f[8vY\u0012\u0004Cm\u001c\u0011o_RD\u0017N\\4!_:\u0004Co\\%oI\u0016DX\rZ*fc\u0002*\u0007pY3qi\u0002\u001a\u0017m\u001d;!i\",Wn]3mm\u0016\u001c\b%Y:!C:\u0004\u0013N\u001c3fq\u0016$\u0007e]3rk\u0016t7-\u001a\u0018\"\u00035\u000baA\r\u00182c9\u0002\u0014aA:fc\u0006Q\u0011J\u001c3fq\u0016$7+Z9\u0011\u0005y11C\u0001\u0004S!\r\u00014+N\u0005\u0003)F\u0012\u0011#\u00138eKb,GmU3r\r\u0006\u001cGo\u001c:z\u0003\u0019a\u0014N\\5u}Q\t\u0001K\u0001\u0003J[BdWCA-_'\u0011A!l\u00181\u0011\u00075ZV,\u0003\u0002]%\tY\u0011IY:ue\u0006\u001cGoU3r!\t\u0011c\fB\u0003%\u0011\t\u0007Q\u0005E\u0002\u001f\u0001u\u0003\"AG1\n\u0005\t$\"\u0001D*fe&\fG.\u001b>bE2,\u0017a\u00012vMB\u0019Q\r[/\u000e\u0003\u0019T!a\u001a\n\u0002\u000f5,H/\u00192mK&\u0011\u0011N\u001a\u0002\f\u0003J\u0014\u0018-\u001f\"vM\u001a,'\u000f\u0006\u0002l[B\u0019A\u000eC/\u000e\u0003\u0019AQa\u0019\u0006A\u0002\u0011\fa\u0001\\3oORDW#\u00019\u0011\u0005i\t\u0018B\u0001:\u0015\u0005\rIe\u000e^\u0001\u0006CB\u0004H.\u001f\u000b\u0003;VDQA\u001e\u0007A\u0002A\f1!\u001b3y\u0003)qWm\u001e\"vS2$WM]\u000b\u0003sz,\u0012A\u001f\t\u0005Knlx0\u0003\u0002}M\n9!)^5mI\u0016\u0014\bC\u0001\u0012\u007f\t\u0015!SB1\u0001&!\rq\u0002!`\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0005\u0003\u000b\t)\"\u0006\u0002\u0002\bAI\u0001'!\u0003\u0002\u000e\u0005M\u0011qC\u0005\u0004\u0003\u0017\t$\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007c\u00017\u0002\u0010%\u0019\u0011\u0011\u0003\"\u0003\t\r{G\u000e\u001c\t\u0004E\u0005UA!\u0002\u0013\u000f\u0005\u0004)\u0003\u0003\u0002\u0010\u0001\u0003'\u0001")
public interface IndexedSeq<A>
extends scala.collection.immutable.Seq<A>,
scala.collection.IndexedSeq<A> {
    public static <A> CanBuildFrom<IndexedSeq<?>, A, IndexedSeq<A>> canBuildFrom() {
        return IndexedSeq$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return IndexedSeq$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)indexedSeq$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return IndexedSeq$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return IndexedSeq$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ tabulate_this = indexedSeq$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return IndexedSeq$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        IndexedSeq$ fill_this = indexedSeq$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)indexedSeq$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return IndexedSeq$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return IndexedSeq$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return IndexedSeq$.MODULE$.empty();
    }

    @Override
    default public GenericCompanion<IndexedSeq> companion() {
        return IndexedSeq$.MODULE$;
    }

    @Override
    default public IndexedSeq<A> toIndexedSeq() {
        return this;
    }

    @Override
    default public IndexedSeq<A> seq() {
        return this;
    }

    public static void $init$(IndexedSeq $this) {
    }

    public static class Impl<A>
    extends AbstractSeq<A>
    implements IndexedSeq<A>,
    Serializable {
        private final ArrayBuffer<A> buf;

        @Override
        public GenericCompanion<IndexedSeq> companion() {
            return ((IndexedSeq)this).companion();
        }

        @Override
        public IndexedSeq<A> toIndexedSeq() {
            return ((IndexedSeq)this).toIndexedSeq();
        }

        @Override
        public IndexedSeq<A> seq() {
            return ((IndexedSeq)this).seq();
        }

        @Override
        public int hashCode() {
            return IndexedSeqLike.hashCode$(this);
        }

        @Override
        public scala.collection.IndexedSeq<A> thisCollection() {
            return IndexedSeqLike.thisCollection$(this);
        }

        @Override
        public scala.collection.IndexedSeq toCollection(Object repr) {
            return IndexedSeqLike.toCollection$(this, repr);
        }

        @Override
        public Iterator<A> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public scala.collection.immutable.Seq<A> toSeq() {
            return scala.collection.immutable.Seq.toSeq$(this);
        }

        @Override
        public Combiner<A, ParSeq<A>> parCombiner() {
            return scala.collection.immutable.Seq.parCombiner$(this);
        }

        @Override
        public int length() {
            return this.buf.length();
        }

        @Override
        public A apply(int idx) {
            return this.buf.apply(idx);
        }

        public Impl(ArrayBuffer<A> buf) {
            this.buf = buf;
            Traversable.$init$(this);
            Iterable.$init$(this);
            scala.collection.immutable.Seq.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.IndexedSeq.$init$(this);
            IndexedSeq.$init$(this);
        }
    }
}

