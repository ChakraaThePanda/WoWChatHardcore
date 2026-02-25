/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.AbstractSortedSet;
import scala.collection.mutable.Builder;
import scala.collection.mutable.RedBlackTree;
import scala.collection.mutable.RedBlackTree$;
import scala.collection.mutable.RedBlackTree$Tree$;
import scala.collection.mutable.SetLike;
import scala.collection.mutable.TreeSet$;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.Null$;

@ScalaSignature(bytes="\u0006\u0001\tmr!\u0002\u001a4\u0011\u0003Qd!\u0002\u001f4\u0011\u0003i\u0004BB=\u0002\t\u0003\ty\u0010C\u0004\u0002\u0006\u0005!\tA!\u0001\t\u000f\t=\u0011\u0001b\u0001\u0003\u0012!I!\u0011G\u0001\u0002\u0002\u0013%!1\u0007\u0004\u0005yM\u0002R\t\u0003\u0005e\r\t\u0005\t\u0015!\u0003f\u0011!ygA!b\u0001\n\u0007\u0001\b\u0002\u0003=\u0007\u0005\u0003\u0005\u000b\u0011B9\t\u000be4A\u0011\u0002>\t\u000be4A\u0011\u0001@\t\u000f\u0005\u0015a\u0001\"\u0011\u0002\b!A\u0011\u0011\u0002\u0004!\n#\nY\u0001C\u0004\u0002\u0014\u0019!\t!!\u0006\t\u000f\u0005\u0015b\u0001\"\u0001\u0002(!9\u0011q\u0006\u0004\u0005\u0002\u0005E\u0002bBA\u001c\r\u0011\u0005\u0011\u0011\b\u0005\b\u0003\u00072A\u0011AA#\u0011\u001d\tiE\u0002C\u0001\u0003\u001fBq!!\u0016\u0007\t\u0003\n9\u0006C\u0004\u0002\\\u0019!\t%!\u0018\t\u000f\u0005\u0015d\u0001\"\u0011\u0002h!9\u0011\u0011\u000e\u0004\u0005B\u0005-\u0004bBA7\r\u0011\u0005\u0013q\u000e\u0005\b\u0003c2A\u0011IA6\u0011\u001d\t\u0019H\u0002C!\u0003_Bq!!\u001e\u0007\t\u0003\n9\bC\u0004\u0002\u0012\u001a!\t%a%\t\u000f\u0005Ue\u0001\"\u0011\u0002\u0018\u001aA\u0011\u0011\u0016\u0004!\u0002\u001b\tY\u000b\u0003\u0006\u0002\u001ay\u0011\t\u0011)A\u0005\u00037A!\"a\t\u001f\u0005\u0003\u0005\u000b\u0011BA\u000e\u0011\u0019Ih\u0004\"\u0001\u0002.\"A\u0011Q\u0017\u0010!\n\u0013\t9\f\u0003\u0005\u0002>z\u0001K\u0011BA`\u0011!\t)M\bQ\u0005\n\u0005\u001d\u0007bBA\n=\u0011\u0005\u00131\u001a\u0005\b\u0003oqB\u0011IAi\u0011\u001d\t\u0019E\bC!\u0003\u000bBq!!\u0014\u001f\t\u0003\n)\u000eC\u0004\u0002Vy!\t%!7\t\u000f\u0005mc\u0004\"\u0011\u0002^!9\u0011Q\r\u0010\u0005B\u0005\u001d\u0004bBA5=\u0011\u0005\u00131\u000e\u0005\b\u0003[rB\u0011IA8\u0011\u001d\t\tH\bC!\u0003WBq!a\u001d\u001f\t\u0003\ny\u0007C\u0004\u0002vy!\t%!8\t\u000f\u0005%h\u0004\"\u0011\u0002l\u00069AK]3f'\u0016$(B\u0001\u001b6\u0003\u001diW\u000f^1cY\u0016T!AN\u001c\u0002\u0015\r|G\u000e\\3di&|gNC\u00019\u0003\u0015\u00198-\u00197b\u0007\u0001\u0001\"aO\u0001\u000e\u0003M\u0012q\u0001\u0016:fKN+GoE\u0002\u0002}\u0005\u00042a\u0010\"E\u001b\u0005\u0001%BA!6\u0003\u001d9WM\\3sS\u000eL!a\u0011!\u0003/5+H/\u00192mKN{'\u000f^3e'\u0016$h)Y2u_JL\bCA\u001e\u0007+\t1Ej\u0005\u0004\u0007\u000fZKV,\u0019\t\u0004w!S\u0015BA%4\u0005E\t%m\u001d;sC\u000e$8k\u001c:uK\u0012\u001cV\r\u001e\t\u0003\u00172c\u0001\u0001B\u0003N\r\t\u0007aJA\u0001B#\ty5\u000b\u0005\u0002Q#6\tq'\u0003\u0002So\t9aj\u001c;iS:<\u0007C\u0001)U\u0013\t)vGA\u0002B]f\u00042aO,K\u0013\tA6GA\u0005T_J$X\rZ*fiB!1H\u0017&]\u0013\tY6GA\u0004TKRd\u0015n[3\u0011\u0007m2!\n\u0005\u0003_?*cV\"A\u001b\n\u0005\u0001,$!D*peR,GmU3u\u0019&\\W\r\u0005\u0002QE&\u00111m\u000e\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0005iJ,W\r\u0005\u0003gS*cgBA\u001eh\u0013\tA7'\u0001\u0007SK\u0012\u0014E.Y2l)J,W-\u0003\u0002kW\n!AK]3f\u0015\tA7\u0007\u0005\u0002Q[&\u0011an\u000e\u0002\u0005\u001dVdG.\u0001\u0005pe\u0012,'/\u001b8h+\u0005\t\bc\u0001:v\u0015:\u0011\u0001k]\u0005\u0003i^\nq\u0001]1dW\u0006<W-\u0003\u0002wo\nAqJ\u001d3fe&twM\u0003\u0002uo\u0005IqN\u001d3fe&tw\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005mlHC\u0001/}\u0011\u0015y'\u0002q\u0001r\u0011\u0015!'\u00021\u0001f)\u0005yHc\u0001/\u0002\u0002!1\u00111A\u0006A\u0004E\f1a\u001c:e\u0003\u0015)W\u000e\u001d;z+\u0005a\u0016A\u00038fo\n+\u0018\u000e\u001c3feV\u0011\u0011Q\u0002\t\u0006w\u0005=!\nX\u0005\u0004\u0003#\u0019$a\u0002\"vS2$WM]\u0001\ne\u0006tw-Z%na2$R\u0001XA\f\u0003CAq!!\u0007\u000f\u0001\u0004\tY\"\u0001\u0003ge>l\u0007\u0003\u0002)\u0002\u001e)K1!a\b8\u0005\u0019y\u0005\u000f^5p]\"9\u00111\u0005\bA\u0002\u0005m\u0011!B;oi&d\u0017!\u0003\u0013nS:,8\u000fJ3r)\u0011\tI#a\u000b\u000e\u0003\u0019Aa!!\f\u0010\u0001\u0004Q\u0015aA6fs\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0003\u0002*\u0005M\u0002BBA\u001b!\u0001\u0007!*\u0001\u0003fY\u0016l\u0017\u0001C2p]R\f\u0017N\\:\u0015\t\u0005m\u0012\u0011\t\t\u0004!\u0006u\u0012bAA o\t9!i\\8mK\u0006t\u0007BBA\u001b#\u0001\u0007!*\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\t9\u0005\u0005\u0003_\u0003\u0013R\u0015bAA&k\tA\u0011\n^3sCR|'/\u0001\tlKf\u001c\u0018\n^3sCR|'O\u0012:p[R!\u0011qIA)\u0011\u0019\t\u0019f\u0005a\u0001\u0015\u0006)1\u000f^1si\u0006a\u0011\u000e^3sCR|'O\u0012:p[R!\u0011qIA-\u0011\u0019\t\u0019\u0006\u0006a\u0001\u0015\u0006!1/\u001b>f+\t\ty\u0006E\u0002Q\u0003CJ1!a\u00198\u0005\rIe\u000e^\u0001\bSN,U\u000e\u001d;z+\t\tY$\u0001\u0003iK\u0006$W#\u0001&\u0002\u0015!,\u0017\rZ(qi&|g.\u0006\u0002\u0002\u001c\u0005!A.Y:u\u0003)a\u0017m\u001d;PaRLwN\\\u0001\bM>\u0014X-Y2i+\u0011\tI(!$\u0015\t\u0005m\u0014\u0011\u0011\t\u0004!\u0006u\u0014bAA@o\t!QK\\5u\u0011\u001d\t\u0019i\u0007a\u0001\u0003\u000b\u000b\u0011A\u001a\t\u0007!\u0006\u001d%*a#\n\u0007\u0005%uGA\u0005Gk:\u001cG/[8ocA\u00191*!$\u0005\r\u0005=5D1\u0001O\u0005\u0005)\u0016!B2mK\u0006\u0014HCAA>\u00031\u0019HO]5oOB\u0013XMZ5y+\t\tI\n\u0005\u0003\u0002\u001c\u0006\u0015VBAAO\u0015\u0011\ty*!)\u0002\t1\fgn\u001a\u0006\u0003\u0003G\u000bAA[1wC&!\u0011qUAO\u0005\u0019\u0019FO]5oO\nYAK]3f'\u0016$h+[3x'\tqB\f\u0006\u0004\u00020\u0006E\u00161\u0017\t\u0004\u0003Sq\u0002bBA\rC\u0001\u0007\u00111\u0004\u0005\b\u0003G\t\u0003\u0019AA\u000e\u00039\u0001\u0018nY6M_^,'OQ8v]\u0012$B!a\u0007\u0002:\"9\u00111\u0018\u0012A\u0002\u0005m\u0011a\u00028fo\u001a\u0013x.\\\u0001\u000fa&\u001c7.\u00169qKJ\u0014u.\u001e8e)\u0011\tY\"!1\t\u000f\u0005\r7\u00051\u0001\u0002\u001c\u0005Aa.Z<V]RLG.\u0001\njg&s7/\u001b3f-&,wOQ8v]\u0012\u001cH\u0003BA\u001e\u0003\u0013Da!!\f%\u0001\u0004QE#\u0002/\u0002N\u0006=\u0007bBA\rK\u0001\u0007\u00111\u0004\u0005\b\u0003G)\u0003\u0019AA\u000e)\u0011\tY$a5\t\r\u00055b\u00051\u0001K)\u0011\t9%a6\t\r\u0005M\u0003\u00061\u0001K)\u0011\t9%a7\t\r\u0005M\u0013\u00061\u0001K+\u0011\ty.a:\u0015\t\u0005m\u0014\u0011\u001d\u0005\b\u0003\u0007\u0003\u0004\u0019AAr!\u0019\u0001\u0016q\u0011&\u0002fB\u00191*a:\u0005\r\u0005=\u0005G1\u0001O\u0003\u0015\u0019Gn\u001c8f)\u0005a\u0006f\u0002\u0010\u0002p\u0006U\u0018q\u001f\t\u0004!\u0006E\u0018bAAzo\t\u00012+\u001a:jC24VM]:j_:,\u0016\nR\u0001\u0006m\u0006dW/\u001a\u0010\tEv\u001b!H-i;\r&\u0012aA\b\u0015\b\r\u0005=\u0018Q_A\u007f=!iMoh\tQ\u001dmEH#\u0001\u001e\u0016\t\t\r!\u0011\u0002\u000b\u0005\u0005\u000b\u0011Y\u0001\u0005\u0003<\r\t\u001d\u0001cA&\u0003\n\u0011)Qj\u0001b\u0001\u001d\"1qn\u0001a\u0002\u0005\u001b\u0001BA];\u0003\b\u0005a1-\u00198Ck&dGM\u0012:p[V!!1\u0003B\u0015)\u0011\u0011)B!\f\u0011\u0013}\u00129Ba\u0007\u0003(\t-\u0012b\u0001B\r\u0001\na1)\u00198Ck&dGM\u0012:p[B!!Q\u0004B\u0010\u001b\u0005\t\u0011\u0002\u0002B\u0011\u0005G\u0011AaQ8mY&\u0019!Q\u0005!\u0003!M{'\u000f^3e'\u0016$h)Y2u_JL\bcA&\u0003*\u0011)Q\n\u0002b\u0001\u001dB!1H\u0002B\u0014\u0011\u001d\t\u0019\u0001\u0002a\u0002\u0005_\u0001BA];\u0003(\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0011)\u0004\u0005\u0003\u0002\u001c\n]\u0012\u0002\u0002B\u001d\u0003;\u0013aa\u00142kK\u000e$\b")
public class TreeSet<A>
extends AbstractSortedSet<A>
implements Serializable {
    public static final long serialVersionUID = -3642111301929493640L;
    public final RedBlackTree.Tree<A, Null$> scala$collection$mutable$TreeSet$$tree;
    private final Ordering<A> ordering;

    public static <A> CanBuildFrom<TreeSet<?>, A, TreeSet<A>> canBuildFrom(Ordering<A> ordering) {
        return TreeSet$.MODULE$.canBuildFrom(ordering);
    }

    public static <A> CanBuildFrom<TreeSet<?>, A, TreeSet<A>> newCanBuildFrom(Ordering<A> ordering) {
        return TreeSet$.MODULE$.newCanBuildFrom(ordering);
    }

    @Override
    public Ordering<A> ordering() {
        return this.ordering;
    }

    @Override
    public TreeSet<A> empty() {
        return TreeSet$.MODULE$.empty((Ordering)this.ordering());
    }

    @Override
    public Builder<A, TreeSet<A>> newBuilder() {
        return TreeSet$.MODULE$.newBuilder(this.ordering());
    }

    @Override
    public TreeSet<A> rangeImpl(Option<A> from, Option<A> until) {
        return new TreeSetView(this, from, until);
    }

    @Override
    public TreeSet<A> $minus$eq(A key) {
        RedBlackTree$.MODULE$.delete(this.scala$collection$mutable$TreeSet$$tree, key, this.ordering());
        return this;
    }

    @Override
    public TreeSet<A> $plus$eq(A elem) {
        RedBlackTree$.MODULE$.insert(this.scala$collection$mutable$TreeSet$$tree, elem, null, this.ordering());
        return this;
    }

    @Override
    public boolean contains(A elem) {
        return RedBlackTree$.MODULE$.contains(this.scala$collection$mutable$TreeSet$$tree, elem, this.ordering());
    }

    @Override
    public Iterator<A> iterator() {
        return RedBlackTree$.MODULE$.keysIterator(this.scala$collection$mutable$TreeSet$$tree, RedBlackTree$.MODULE$.keysIterator$default$2(), RedBlackTree$.MODULE$.keysIterator$default$3(), this.ordering());
    }

    @Override
    public Iterator<A> keysIteratorFrom(A start) {
        return RedBlackTree$.MODULE$.keysIterator(this.scala$collection$mutable$TreeSet$$tree, new Some<A>(start), RedBlackTree$.MODULE$.keysIterator$default$3(), this.ordering());
    }

    @Override
    public Iterator<A> iteratorFrom(A start) {
        return RedBlackTree$.MODULE$.keysIterator(this.scala$collection$mutable$TreeSet$$tree, new Some<A>(start), RedBlackTree$.MODULE$.keysIterator$default$3(), this.ordering());
    }

    @Override
    public int size() {
        return RedBlackTree$.MODULE$.size(this.scala$collection$mutable$TreeSet$$tree);
    }

    @Override
    public boolean isEmpty() {
        return RedBlackTree$.MODULE$.isEmpty(this.scala$collection$mutable$TreeSet$$tree);
    }

    @Override
    public A head() {
        return RedBlackTree$.MODULE$.minKey(this.scala$collection$mutable$TreeSet$$tree).get();
    }

    @Override
    public Option<A> headOption() {
        return RedBlackTree$.MODULE$.minKey(this.scala$collection$mutable$TreeSet$$tree);
    }

    @Override
    public A last() {
        return RedBlackTree$.MODULE$.maxKey(this.scala$collection$mutable$TreeSet$$tree).get();
    }

    @Override
    public Option<A> lastOption() {
        return RedBlackTree$.MODULE$.maxKey(this.scala$collection$mutable$TreeSet$$tree);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        RedBlackTree$.MODULE$.foreachKey(this.scala$collection$mutable$TreeSet$$tree, f);
    }

    @Override
    public void clear() {
        RedBlackTree$.MODULE$.clear(this.scala$collection$mutable$TreeSet$$tree);
    }

    @Override
    public String stringPrefix() {
        return "TreeSet";
    }

    public TreeSet(RedBlackTree.Tree<A, Null$> tree, Ordering<A> ordering) {
        this.scala$collection$mutable$TreeSet$$tree = tree;
        this.ordering = ordering;
        if (ordering == null) {
            throw new NullPointerException("ordering must not be null");
        }
    }

    public TreeSet(Ordering<A> ord) {
        this(RedBlackTree$Tree$.MODULE$.empty(), ord);
    }

    public final class TreeSetView
    extends TreeSet<A> {
        public static final long serialVersionUID = 7087824939194006086L;
        private final Option<A> from;
        private final Option<A> until;
        private final /* synthetic */ TreeSet $outer;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private Option<A> pickLowerBound(Option<A> newFrom) {
            Option option;
            Option option2;
            Option option3 = option2 = this.from;
            Option option4 = newFrom;
            if (option3 instanceof Some) {
                Object fr = ((Some)option3).value();
                if (option4 instanceof Some) {
                    Object newFr = ((Some)option4).value();
                    return new Some(this.ordering().max(fr, newFr));
                }
            }
            if (!None$.MODULE$.equals(option = option2)) return this.from;
            return newFrom;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private Option<A> pickUpperBound(Option<A> newUntil) {
            Option option;
            Option option2;
            Option option3 = option2 = this.until;
            Option option4 = newUntil;
            if (option3 instanceof Some) {
                Object unt = ((Some)option3).value();
                if (option4 instanceof Some) {
                    Object newUnt = ((Some)option4).value();
                    return new Some(this.ordering().min(unt, newUnt));
                }
            }
            if (!None$.MODULE$.equals(option = option2)) return this.until;
            return newUntil;
        }

        private boolean isInsideViewBounds(A key) {
            boolean beforeUntil;
            boolean afterFrom = this.from.isEmpty() || this.ordering().compare(this.from.get(), key) <= 0;
            boolean bl = beforeUntil = this.until.isEmpty() || this.ordering().compare(key, this.until.get()) < 0;
            return afterFrom && beforeUntil;
        }

        @Override
        public TreeSet<A> rangeImpl(Option<A> from, Option<A> until) {
            return new TreeSetView(this.$outer, this.pickLowerBound(from), this.pickUpperBound(until));
        }

        @Override
        public boolean contains(A key) {
            return this.isInsideViewBounds(key) && RedBlackTree$.MODULE$.contains(this.$outer.scala$collection$mutable$TreeSet$$tree, key, this.ordering());
        }

        @Override
        public Iterator<A> iterator() {
            return RedBlackTree$.MODULE$.keysIterator(this.$outer.scala$collection$mutable$TreeSet$$tree, this.from, this.until, this.ordering());
        }

        @Override
        public Iterator<A> keysIteratorFrom(A start) {
            return RedBlackTree$.MODULE$.keysIterator(this.$outer.scala$collection$mutable$TreeSet$$tree, this.pickLowerBound(new Some(start)), this.until, this.ordering());
        }

        @Override
        public Iterator<A> iteratorFrom(A start) {
            return RedBlackTree$.MODULE$.keysIterator(this.$outer.scala$collection$mutable$TreeSet$$tree, this.pickLowerBound(new Some(start)), this.until, this.ordering());
        }

        @Override
        public int size() {
            return this.iterator().length();
        }

        @Override
        public boolean isEmpty() {
            return !this.iterator().hasNext();
        }

        @Override
        public A head() {
            return this.headOption().get();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Option<A> headOption() {
            None$ elem = this.from.isDefined() ? RedBlackTree$.MODULE$.minKeyAfter(this.$outer.scala$collection$mutable$TreeSet$$tree, this.from.get(), this.ordering()) : RedBlackTree$.MODULE$.minKey(this.$outer.scala$collection$mutable$TreeSet$$tree);
            Option option = this.until;
            None$ none$ = elem;
            Option option2 = option;
            if (!(none$ instanceof Some)) return elem;
            Object e = ((Some)((Object)none$)).value();
            if (!(option2 instanceof Some)) return elem;
            Object unt = ((Some)option2).value();
            if (this.ordering().compare(e, unt) < 0) return elem;
            return None$.MODULE$;
        }

        @Override
        public A last() {
            return this.lastOption().get();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Option<A> lastOption() {
            None$ elem = this.until.isDefined() ? RedBlackTree$.MODULE$.maxKeyBefore(this.$outer.scala$collection$mutable$TreeSet$$tree, this.until.get(), this.ordering()) : RedBlackTree$.MODULE$.maxKey(this.$outer.scala$collection$mutable$TreeSet$$tree);
            Option option = this.from;
            None$ none$ = elem;
            Option option2 = option;
            if (!(none$ instanceof Some)) return elem;
            Object e = ((Some)((Object)none$)).value();
            if (!(option2 instanceof Some)) return elem;
            Object fr = ((Some)option2).value();
            if (this.ordering().compare(e, fr) >= 0) return elem;
            return None$.MODULE$;
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            this.iterator().foreach(f);
        }

        @Override
        public TreeSet<A> clone() {
            return ((TreeSet)SetLike.clone$(this)).rangeImpl(this.from, this.until);
        }

        public TreeSetView(TreeSet $outer, Option<A> from, Option<A> until) {
            this.from = from;
            this.until = until;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer.scala$collection$mutable$TreeSet$$tree, $outer.ordering());
        }
    }
}

