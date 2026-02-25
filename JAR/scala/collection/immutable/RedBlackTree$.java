/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.NoSuchElementException;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;
import scala.collection.Iterator;
import scala.collection.immutable.RedBlackTree;
import scala.collection.immutable.RedBlackTree$BlackTree$;
import scala.collection.immutable.RedBlackTree$RedTree$;
import scala.math.Ordering;
import scala.runtime.BoxesRunTime;
import scala.runtime.Null$;
import scala.runtime.ObjectRef;
import scala.sys.package$;

public final class RedBlackTree$ {
    public static RedBlackTree$ MODULE$;

    static {
        new RedBlackTree$();
    }

    public boolean isEmpty(RedBlackTree.Tree<?, ?> tree) {
        return tree == null;
    }

    public <A> boolean contains(RedBlackTree.Tree<A, ?> tree, A x, Ordering<A> evidence$1) {
        return this.lookup(tree, x, evidence$1) != null;
    }

    public <A, B> Option<B> get(RedBlackTree.Tree<A, B> tree, A x, Ordering<A> evidence$2) {
        RedBlackTree.Tree<A, B> tree2 = this.lookup(tree, x, evidence$2);
        Option option = tree2 == null ? None$.MODULE$ : new Some<B>(tree2.value());
        return option;
    }

    public <A, B> RedBlackTree.Tree<A, B> lookup(RedBlackTree.Tree<A, B> tree, A x, Ordering<A> ordering) {
        while (true) {
            if (tree == null) {
                return null;
            }
            int cmp = ordering.compare(x, tree.key());
            if (cmp < 0) {
                tree = tree.left();
                continue;
            }
            if (cmp <= 0) break;
            tree = tree.right();
        }
        return tree;
    }

    public int count(RedBlackTree.Tree<?, ?> tree) {
        if (tree == null) {
            return 0;
        }
        return tree.count();
    }

    public <A, B, B1> RedBlackTree.Tree<A, B1> update(RedBlackTree.Tree<A, B> tree, A k, B1 v, boolean overwrite, Ordering<A> evidence$3) {
        return this.blacken(this.upd(tree, k, v, overwrite, evidence$3));
    }

    public <A, B> RedBlackTree.Tree<A, B> delete(RedBlackTree.Tree<A, B> tree, A k, Ordering<A> evidence$4) {
        return this.blacken(this.del(tree, k, evidence$4));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public <A, B> RedBlackTree.Tree<A, B> rangeImpl(RedBlackTree.Tree<A, B> tree, Option<A> from, Option<A> until, Ordering<A> evidence$5) {
        Tuple2<Option<A>, Option<A>> tuple2 = new Tuple2<Option<A>, Option<A>>(from, until);
        Option<A> option = from;
        Option<A> option2 = until;
        if (option instanceof Some) {
            Object from2 = ((Some)option).value();
            if (option2 instanceof Some) {
                Object until2 = ((Some)option2).value();
                return this.range(tree, from2, until2, evidence$5);
            }
        }
        Option<A> option3 = from;
        Option<A> option4 = until;
        if (option3 instanceof Some) {
            Object from3 = ((Some)option3).value();
            if (None$.MODULE$.equals(option4)) {
                return this.from(tree, from3, evidence$5);
            }
        }
        if (tuple2 != null) {
            Option<A> option5 = from;
            Option<A> option6 = until;
            if (None$.MODULE$.equals(option5) && option6 instanceof Some) {
                Object until3 = ((Some)option6).value();
                return this.until(tree, until3, evidence$5);
            }
        }
        if (tuple2 == null) throw new MatchError(tuple2);
        Option<A> option7 = from;
        Option<A> option8 = until;
        if (!None$.MODULE$.equals(option7)) throw new MatchError(tuple2);
        if (!None$.MODULE$.equals(option8)) throw new MatchError(tuple2);
        return tree;
    }

    public <A, B> RedBlackTree.Tree<A, B> range(RedBlackTree.Tree<A, B> tree, A from, A until, Ordering<A> evidence$6) {
        return this.blacken(this.doRange(tree, from, until, evidence$6));
    }

    public <A, B> RedBlackTree.Tree<A, B> from(RedBlackTree.Tree<A, B> tree, A from, Ordering<A> evidence$7) {
        return this.blacken(this.doFrom(tree, from, evidence$7));
    }

    public <A, B> RedBlackTree.Tree<A, B> to(RedBlackTree.Tree<A, B> tree, A to, Ordering<A> evidence$8) {
        return this.blacken(this.doTo(tree, to, evidence$8));
    }

    public <A, B> RedBlackTree.Tree<A, B> until(RedBlackTree.Tree<A, B> tree, A key, Ordering<A> evidence$9) {
        return this.blacken(this.doUntil(tree, key, evidence$9));
    }

    public <A, B> RedBlackTree.Tree<A, B> drop(RedBlackTree.Tree<A, B> tree, int n, Ordering<A> evidence$10) {
        return this.blacken(this.doDrop(tree, n));
    }

    public <A, B> RedBlackTree.Tree<A, B> take(RedBlackTree.Tree<A, B> tree, int n, Ordering<A> evidence$11) {
        return this.blacken(this.doTake(tree, n));
    }

    public <A, B> RedBlackTree.Tree<A, B> slice(RedBlackTree.Tree<A, B> tree, int from, int until, Ordering<A> evidence$12) {
        return this.blacken(this.doSlice(tree, from, until));
    }

    /*
     * WARNING - void declaration
     */
    public <A, B> RedBlackTree.Tree<A, B> smallest(RedBlackTree.Tree<A, B> tree) {
        void var2_2;
        if (tree == null) {
            throw new NoSuchElementException("empty tree");
        }
        RedBlackTree.Tree<A, B> result2 = tree;
        while (result2.left() != null) {
            result2 = result2.left();
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    public <A, B> RedBlackTree.Tree<A, B> greatest(RedBlackTree.Tree<A, B> tree) {
        void var2_2;
        if (tree == null) {
            throw new NoSuchElementException("empty tree");
        }
        RedBlackTree.Tree<A, B> result2 = tree;
        while (result2.right() != null) {
            result2 = result2.right();
        }
        return var2_2;
    }

    public <A, B> RedBlackTree.Tree<A, B> tail(RedBlackTree.Tree<A, B> tree) {
        return this.blacken(this._tail$1(tree));
    }

    public <A, B> RedBlackTree.Tree<A, B> init(RedBlackTree.Tree<A, B> tree) {
        return this.blacken(this._init$1(tree));
    }

    public <A, B> RedBlackTree.Tree<A, B> minAfter(RedBlackTree.Tree<A, B> tree, A x, Ordering<A> ordering) {
        while (tree != null) {
            int cmp = ordering.compare(x, tree.key());
            if (cmp == 0) {
                return tree;
            }
            if (cmp < 0) {
                RedBlackTree.Tree<A, B> l = this.minAfter(tree.left(), x, ordering);
                if (l != null) {
                    return l;
                }
                return tree;
            }
            tree = tree.right();
        }
        return null;
    }

    public <A, B> RedBlackTree.Tree<A, B> maxBefore(RedBlackTree.Tree<A, B> tree, A x, Ordering<A> ordering) {
        while (true) {
            if (tree == null) {
                return null;
            }
            if (ordering.compare(x, tree.key()) > 0) break;
            tree = tree.left();
        }
        RedBlackTree.Tree<A, B> r = this.maxBefore(tree.right(), x, ordering);
        if (r != null) {
            return r;
        }
        return tree;
    }

    public <A, B, U> void foreach(RedBlackTree.Tree<A, B> tree, Function1<Tuple2<A, B>, U> f) {
        if (tree != null) {
            this._foreach(tree, f);
        }
    }

    public <A, X, Y> boolean keysEqual(RedBlackTree.Tree<A, X> a, RedBlackTree.Tree<A, Y> b, Ordering<A> evidence$13) {
        if (a == b) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (b == null) {
            return false;
        }
        return a.count() == b.count() && new RedBlackTree.EqualsIterator<A, Y>(a, evidence$13).sameKeys(new RedBlackTree.EqualsIterator<A, Y>(b, evidence$13));
    }

    public <A, X, Y> boolean valuesEqual(RedBlackTree.Tree<A, X> a, RedBlackTree.Tree<A, Y> b, Ordering<A> evidence$14) {
        if (a == b) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (b == null) {
            return false;
        }
        return a.count() == b.count() && new RedBlackTree.EqualsIterator<A, Y>(a, evidence$14).sameValues(new RedBlackTree.EqualsIterator<A, Y>(b, evidence$14));
    }

    public <A, X, Y> boolean entriesEqual(RedBlackTree.Tree<A, X> a, RedBlackTree.Tree<A, Y> b, Ordering<A> evidence$15) {
        if (a == b) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (b == null) {
            return false;
        }
        return a.count() == b.count() && new RedBlackTree.EqualsIterator<A, Y>(a, evidence$15).sameEntries(new RedBlackTree.EqualsIterator<A, Y>(b, evidence$15));
    }

    private <A, B, U> void _foreach(RedBlackTree.Tree<A, B> tree, Function1<Tuple2<A, B>, U> f) {
        while (true) {
            if (tree.left() != null) {
                this._foreach(tree.left(), f);
            }
            f.apply(new Tuple2<A, B>(tree.key(), tree.value()));
            if (tree.right() == null) break;
            tree = tree.right();
        }
    }

    public <A, U> void foreachKey(RedBlackTree.Tree<A, ?> tree, Function1<A, U> f) {
        if (tree != null) {
            this._foreachKey(tree, f);
        }
    }

    private <A, U> void _foreachKey(RedBlackTree.Tree<A, ?> tree, Function1<A, U> f) {
        while (true) {
            if (tree.left() != null) {
                this._foreachKey(tree.left(), f);
            }
            f.apply(tree.key());
            if (tree.right() == null) break;
            tree = tree.right();
        }
    }

    public <A, B, U> void foreachEntry(RedBlackTree.Tree<A, B> tree, Function2<A, B, U> f) {
        if (tree != null) {
            this._foreachEntry(tree, f);
        }
    }

    private <A, B, U> void _foreachEntry(RedBlackTree.Tree<A, B> tree, Function2<A, B, U> f) {
        while (true) {
            if (tree.left() != null) {
                this._foreachEntry(tree.left(), f);
            }
            f.apply(tree.key(), tree.value());
            if (tree.right() == null) break;
            tree = tree.right();
        }
    }

    public <A, B> Iterator<Tuple2<A, B>> iterator(RedBlackTree.Tree<A, B> tree, Option<A> start, Ordering<A> evidence$16) {
        return new RedBlackTree.EntriesIterator<A, B>(tree, start, evidence$16);
    }

    public <A, B> None$ iterator$default$2() {
        return None$.MODULE$;
    }

    public <A> Iterator<A> keysIterator(RedBlackTree.Tree<A, ?> tree, Option<A> start, Ordering<A> evidence$17) {
        return new RedBlackTree.KeysIterator(tree, start, evidence$17);
    }

    public <A> None$ keysIterator$default$2() {
        return None$.MODULE$;
    }

    public <A, B> Iterator<B> valuesIterator(RedBlackTree.Tree<A, B> tree, Option<A> start, Ordering<A> evidence$18) {
        return new RedBlackTree.ValuesIterator<A, B>(tree, start, evidence$18);
    }

    public <A, B> None$ valuesIterator$default$2() {
        return None$.MODULE$;
    }

    public <A, B> RedBlackTree.Tree<A, B> nth(RedBlackTree.Tree<A, B> tree, int n) {
        while (true) {
            int count;
            if (n < (count = this.count(tree.left()))) {
                tree = tree.left();
                continue;
            }
            if (n <= count) break;
            n = n - count - 1;
            tree = tree.right();
        }
        return tree;
    }

    public boolean isBlack(RedBlackTree.Tree<?, ?> tree) {
        return tree == null || tree instanceof RedBlackTree.BlackTree;
    }

    private boolean isRedTree(RedBlackTree.Tree<?, ?> tree) {
        return tree instanceof RedBlackTree.RedTree;
    }

    public boolean scala$collection$immutable$RedBlackTree$$isBlackTree(RedBlackTree.Tree<?, ?> tree) {
        return tree instanceof RedBlackTree.BlackTree;
    }

    private <A, B> RedBlackTree.Tree<A, B> blacken(RedBlackTree.Tree<A, B> t) {
        if (t == null) {
            return null;
        }
        return t.black();
    }

    private <A, B> RedBlackTree.Tree<A, B> maybeBlacken(RedBlackTree.Tree<A, B> t) {
        if (this.isBlack(t)) {
            return t;
        }
        if (t.left() instanceof RedBlackTree.RedTree || t.right() instanceof RedBlackTree.RedTree) {
            return t.black();
        }
        return t;
    }

    private <A, B> RedBlackTree.Tree<A, B> mkTree(boolean isBlack, A k, B v, RedBlackTree.Tree<A, B> l, RedBlackTree.Tree<A, B> r) {
        if (isBlack) {
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.BlackTree<A, B>(k, v, l, r);
        }
        if (RedBlackTree$RedTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.RedTree<A, B>(k, v, l, r);
    }

    /*
     * WARNING - void declaration
     */
    private <A, B1> RedBlackTree.Tree<A, B1> balanceLeft(RedBlackTree.Tree<A, B1> tree, RedBlackTree.Tree<A, B1> newLeft) {
        if (tree.left() == newLeft) {
            return tree;
        }
        A tree_key = tree.key();
        B1 tree_value = tree.value();
        RedBlackTree.Tree<A, B1> tree_right = tree.right();
        if (newLeft instanceof RedBlackTree.RedTree) {
            RedBlackTree.Tree<A, B1> newLeft_left = newLeft.left();
            RedBlackTree.Tree<A, B1> newLeft_right = newLeft.right();
            if (newLeft_left instanceof RedBlackTree.RedTree) {
                void apply_left;
                void apply_value;
                void apply_key;
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B1> blackTree = new RedBlackTree.BlackTree<A, B1>(tree_key, tree_value, newLeft_right, tree_right);
                RedBlackTree.Tree<A, B1> tree2 = newLeft_left.black();
                B1 B1 = newLeft.value();
                A a = newLeft.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)blackTree);
            }
            if (newLeft_right instanceof RedBlackTree.RedTree) {
                void apply_value;
                void apply_key;
                void apply_left;
                void apply_right;
                void apply_value2;
                void apply_key2;
                RedBlackTree.Tree<A, B1> tree3 = newLeft_right.left();
                B1 B1 = newLeft.value();
                A a = newLeft.key();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<void, void> blackTree = new RedBlackTree.BlackTree<void, void>(apply_key2, apply_value2, (RedBlackTree.Tree<void, void>)newLeft_left, (RedBlackTree.Tree<void, void>)apply_right);
                RedBlackTree.Tree<A, B1> tree4 = newLeft_right.right();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B1> blackTree2 = new RedBlackTree.BlackTree<A, B1>(tree_key, tree_value, apply_left, tree_right);
                B1 B12 = newLeft_right.value();
                A a2 = newLeft_right.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, blackTree, blackTree2);
            }
            return this.mkTree(this.isBlack(tree), tree_key, tree_value, newLeft, tree_right);
        }
        return this.mkTree(this.isBlack(tree), tree_key, tree_value, newLeft, tree_right);
    }

    /*
     * WARNING - void declaration
     */
    private <A, B1> RedBlackTree.Tree<A, B1> balanceRight(RedBlackTree.Tree<A, B1> tree, RedBlackTree.Tree<A, B1> newRight) {
        if (tree.right() == newRight) {
            return tree;
        }
        A tree_key = tree.key();
        B1 tree_value = tree.value();
        RedBlackTree.Tree<A, B1> tree_left = tree.left();
        if (newRight instanceof RedBlackTree.RedTree) {
            RedBlackTree.Tree<A, B1> newRight_left = newRight.left();
            RedBlackTree.Tree<A, B1> newRight_right = newRight.right();
            if (newRight_left instanceof RedBlackTree.RedTree) {
                void apply_value;
                void apply_key;
                void apply_left;
                void apply_value2;
                void apply_key2;
                void apply_right;
                RedBlackTree.Tree<A, B1> tree2 = newRight_left.left();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B1> blackTree = new RedBlackTree.BlackTree<A, B1>(tree_key, tree_value, tree_left, apply_right);
                RedBlackTree.Tree<A, B1> tree3 = newRight_left.right();
                B1 B1 = newRight.value();
                A a = newRight.key();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<void, void> blackTree2 = new RedBlackTree.BlackTree<void, void>(apply_key2, apply_value2, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)newRight_right);
                B1 B12 = newRight_left.value();
                A a2 = newRight_left.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, blackTree, blackTree2);
            }
            if (newRight_right instanceof RedBlackTree.RedTree) {
                void apply_right;
                void apply_value;
                void apply_key;
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B1> blackTree = new RedBlackTree.BlackTree<A, B1>(tree_key, tree_value, tree_left, newRight_left);
                RedBlackTree.Tree<A, B1> tree4 = newRight_right.black();
                B1 B1 = newRight.value();
                A a = newRight.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)blackTree, (RedBlackTree.Tree<void, void>)apply_right);
            }
            return this.mkTree(this.isBlack(tree), tree_key, tree_value, tree_left, newRight);
        }
        return this.mkTree(this.isBlack(tree), tree_key, tree_value, tree_left, newRight);
    }

    private <A, B, B1> RedBlackTree.Tree<A, B1> upd(RedBlackTree.Tree<A, B> tree, A k, B1 v, boolean overwrite, Ordering<A> ordering) {
        if (tree == null) {
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<A, B1>(k, v, null, null);
        }
        int cmp = ordering.compare(k, tree.key());
        if (cmp < 0) {
            return this.balanceLeft(tree, this.upd(tree.left(), k, v, overwrite, ordering));
        }
        if (cmp > 0) {
            return this.balanceRight(tree, this.upd(tree.right(), k, v, overwrite, ordering));
        }
        if (overwrite && v != tree.value() || !BoxesRunTime.equals(k, tree.key())) {
            return this.mkTree(tree instanceof RedBlackTree.BlackTree, k, v, tree.left(), tree.right());
        }
        return tree;
    }

    private <A, B, B1> RedBlackTree.Tree<A, B1> updNth(RedBlackTree.Tree<A, B> tree, int idx, A k, B1 v) {
        if (tree == null) {
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<A, B1>(k, v, null, null);
        }
        int rank = this.count(tree.left()) + 1;
        if (idx < rank) {
            return this.balanceLeft(tree, this.updNth(tree.left(), idx, k, v));
        }
        if (idx > rank) {
            return this.balanceRight(tree, this.updNth(tree.right(), idx - rank, k, v));
        }
        return tree;
    }

    private <A, B> RedBlackTree.Tree<A, B> doFrom(RedBlackTree.Tree<A, B> tree, A from, Ordering<A> ordering) {
        if (tree == null) {
            return null;
        }
        if (ordering.lt(tree.key(), from)) {
            return this.doFrom(tree.right(), from, ordering);
        }
        RedBlackTree.Tree<A, B> newLeft = this.doFrom(tree.left(), from, ordering);
        if (newLeft == tree.left()) {
            return tree;
        }
        if (newLeft == null) {
            return this.upd(tree.right(), tree.key(), tree.value(), false, ordering);
        }
        return this.join(newLeft, tree.key(), tree.value(), tree.right());
    }

    private <A, B> RedBlackTree.Tree<A, B> doTo(RedBlackTree.Tree<A, B> tree, A to, Ordering<A> ordering) {
        if (tree == null) {
            return null;
        }
        if (ordering.lt(to, tree.key())) {
            return this.doTo(tree.left(), to, ordering);
        }
        RedBlackTree.Tree<A, B> newRight = this.doTo(tree.right(), to, ordering);
        if (newRight == tree.right()) {
            return tree;
        }
        if (newRight == null) {
            return this.upd(tree.left(), tree.key(), tree.value(), false, ordering);
        }
        return this.join(tree.left(), tree.key(), tree.value(), newRight);
    }

    private <A, B> RedBlackTree.Tree<A, B> doUntil(RedBlackTree.Tree<A, B> tree, A until, Ordering<A> ordering) {
        if (tree == null) {
            return null;
        }
        if (ordering.lteq(until, tree.key())) {
            return this.doUntil(tree.left(), until, ordering);
        }
        RedBlackTree.Tree<A, B> newRight = this.doUntil(tree.right(), until, ordering);
        if (newRight == tree.right()) {
            return tree;
        }
        if (newRight == null) {
            return this.upd(tree.left(), tree.key(), tree.value(), false, ordering);
        }
        return this.join(tree.left(), tree.key(), tree.value(), newRight);
    }

    private <A, B> RedBlackTree.Tree<A, B> doRange(RedBlackTree.Tree<A, B> tree, A from, A until, Ordering<A> ordering) {
        if (tree == null) {
            return null;
        }
        if (ordering.lt(tree.key(), from)) {
            return this.doRange(tree.right(), from, until, ordering);
        }
        if (ordering.lteq(until, tree.key())) {
            return this.doRange(tree.left(), from, until, ordering);
        }
        RedBlackTree.Tree<A, B> newLeft = this.doFrom(tree.left(), from, ordering);
        RedBlackTree.Tree<A, B> newRight = this.doUntil(tree.right(), until, ordering);
        if (newLeft == tree.left() && newRight == tree.right()) {
            return tree;
        }
        if (newLeft == null) {
            return this.upd(newRight, tree.key(), tree.value(), false, ordering);
        }
        if (newRight == null) {
            return this.upd(newLeft, tree.key(), tree.value(), false, ordering);
        }
        return this.join(newLeft, tree.key(), tree.value(), newRight);
    }

    private <A, B> RedBlackTree.Tree<A, B> doDrop(RedBlackTree.Tree<A, B> tree, int n) {
        int l;
        while (true) {
            if (tree == null || n <= 0) {
                return tree;
            }
            if (n >= tree.count()) {
                return null;
            }
            l = this.count(tree.left());
            if (n <= l) break;
            n = n - l - 1;
            tree = tree.right();
        }
        if (n == l) {
            return this.join(null, tree.key(), tree.value(), tree.right());
        }
        return this.join(this.doDrop(tree.left(), n), tree.key(), tree.value(), tree.right());
    }

    private <A, B> RedBlackTree.Tree<A, B> doTake(RedBlackTree.Tree<A, B> tree, int n) {
        int l;
        while (true) {
            if (tree == null || n <= 0) {
                return null;
            }
            if (n >= tree.count()) {
                return tree;
            }
            l = this.count(tree.left());
            if (n > l) break;
            tree = tree.left();
        }
        if (n == l + 1) {
            return this.maybeBlacken(this.updNth(tree.left(), n, tree.key(), tree.value()));
        }
        return this.join(tree.left(), tree.key(), tree.value(), this.doTake(tree.right(), n - l - 1));
    }

    private <A, B> RedBlackTree.Tree<A, B> doSlice(RedBlackTree.Tree<A, B> tree, int from, int until) {
        int l;
        while (true) {
            if (tree == null || from >= until || from >= tree.count() || until <= 0) {
                return null;
            }
            if (from <= 0 && until >= tree.count()) {
                return tree;
            }
            l = this.count(tree.left());
            if (until <= l) {
                tree = tree.left();
                continue;
            }
            if (from <= l) break;
            until = until - l - 1;
            from = from - l - 1;
            tree = tree.right();
        }
        return this.join(this.doDrop(tree.left(), from), tree.key(), tree.value(), this.doTake(tree.right(), until - l - 1));
    }

    public <A> RedBlackTree.Tree<A, Null$> fromOrderedKeys(Iterator<A> xs, int size) {
        int maxUsedDepth = 32 - Integer.numberOfLeadingZeros(size);
        return this.f$1(1, size, maxUsedDepth, xs);
    }

    public <A, B> RedBlackTree.Tree<A, B> fromOrderedEntries(Iterator<Tuple2<A, B>> xs, int size) {
        int maxUsedDepth = 32 - Integer.numberOfLeadingZeros(size);
        return this.f$2(1, size, xs, maxUsedDepth);
    }

    public <A, B, C> RedBlackTree.Tree<A, C> transform(RedBlackTree.Tree<A, B> t, Function2<A, B, C> f) {
        if (t == null) {
            return null;
        }
        A k = t.key();
        B v = t.value();
        RedBlackTree.Tree<A, B> l = t.left();
        RedBlackTree.Tree<A, B> r = t.right();
        RedBlackTree.Tree<A, C> l2 = this.transform(l, f);
        C v2 = f.apply(k, v);
        RedBlackTree.Tree<A, C> r2 = this.transform(r, f);
        if (v2 == v && l2 == l && r2 == r) {
            return t;
        }
        return this.mkTree(t instanceof RedBlackTree.BlackTree, k, v2, l2, r2);
    }

    public <A, B> RedBlackTree.Tree<A, B> filterEntries(RedBlackTree.Tree<A, B> t, Function2<A, B, Object> f) {
        if (t == null) {
            return null;
        }
        return this.blacken(this.fk$1(t, f));
    }

    public <A, B> RedBlackTree.Tree<A, B> filterKeys(RedBlackTree.Tree<A, B> t, Function1<A, Object> f, boolean isFlipped) {
        if (t == null) {
            return null;
        }
        return this.blacken(this.fk$2(t, isFlipped, f));
    }

    public <A, B> Tuple2<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>> partitionEntries(RedBlackTree.Tree<A, B> t, Function2<A, B, Object> p) {
        if (t == null) {
            return new Tuple2<Object, Object>(null, null);
        }
        ObjectRef<Object> tmpk = ObjectRef.create(null);
        ObjectRef<Object> tmpd = ObjectRef.create(null);
        this.fk$3(t, tmpk, tmpd, p);
        return new Tuple2<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>>(this.blacken((RedBlackTree.Tree)tmpk.elem), this.blacken((RedBlackTree.Tree)tmpd.elem));
    }

    public <A, B> Tuple2<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>> partitionKeys(RedBlackTree.Tree<A, B> t, Function1<A, Object> p) {
        if (t == null) {
            return new Tuple2<Object, Object>(null, null);
        }
        ObjectRef<Object> tmpk = ObjectRef.create(null);
        ObjectRef<Object> tmpd = ObjectRef.create(null);
        this.fk$4(t, tmpk, tmpd, p);
        return new Tuple2<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>>(this.blacken((RedBlackTree.Tree)tmpk.elem), this.blacken((RedBlackTree.Tree)tmpd.elem));
    }

    private <A, B> RedBlackTree.Tree<A, B> del(RedBlackTree.Tree<A, B> tree, A k, Ordering<A> ordering) {
        if (tree == null) {
            return null;
        }
        int cmp = ordering.compare(k, tree.key());
        if (cmp < 0) {
            return this.delLeft$1(tree, k, ordering);
        }
        if (cmp > 0) {
            return this.delRight$1(tree, k, ordering);
        }
        return this.append(tree.left(), tree.right());
    }

    /*
     * WARNING - void declaration
     */
    private <A, B> RedBlackTree.Tree<A, B> balance(A x, B xv, RedBlackTree.Tree<A, B> tl, RedBlackTree.Tree<A, B> tr) {
        if (tl instanceof RedBlackTree.RedTree) {
            if (tr instanceof RedBlackTree.RedTree) {
                void apply_right;
                void apply_left;
                RedBlackTree.Tree<A, B> tree = tr.black();
                RedBlackTree.Tree<A, B> tree2 = tl.black();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<A, B>(x, xv, apply_left, apply_right);
            }
            if (tl.left() instanceof RedBlackTree.RedTree) {
                void apply_left;
                void apply_value;
                void apply_key;
                void apply_left2;
                RedBlackTree.Tree<A, B> tree = tl.right();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B> blackTree = new RedBlackTree.BlackTree<A, B>(x, xv, apply_left2, tr);
                RedBlackTree.Tree<A, B> tree3 = tl.left().black();
                B b = tl.value();
                A a = tl.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)blackTree);
            }
            if (tl.right() instanceof RedBlackTree.RedTree) {
                void apply_value;
                void apply_key;
                void apply_left;
                void apply_right;
                void apply_left3;
                void apply_value2;
                void apply_key2;
                RedBlackTree.Tree<A, B> tree = tl.right().left();
                RedBlackTree.Tree<A, B> tree4 = tl.left();
                B b = tl.value();
                A a = tl.key();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<void, void> blackTree = new RedBlackTree.BlackTree<void, void>(apply_key2, apply_value2, (RedBlackTree.Tree<void, void>)apply_left3, (RedBlackTree.Tree<void, void>)apply_right);
                RedBlackTree.Tree<A, B> tree5 = tl.right().right();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B> blackTree2 = new RedBlackTree.BlackTree<A, B>(x, xv, apply_left, tr);
                B b2 = tl.right().value();
                A a2 = tl.right().key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, blackTree, blackTree2);
            }
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.BlackTree<A, B>(x, xv, tl, tr);
        }
        if (tr instanceof RedBlackTree.RedTree) {
            if (tr.right() instanceof RedBlackTree.RedTree) {
                void apply_right;
                void apply_value;
                void apply_key;
                void apply_right2;
                RedBlackTree.Tree<A, B> tree = tr.left();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B> blackTree = new RedBlackTree.BlackTree<A, B>(x, xv, tl, apply_right2);
                RedBlackTree.Tree<A, B> tree6 = tr.right().black();
                B b = tr.value();
                A a = tr.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)blackTree, (RedBlackTree.Tree<void, void>)apply_right);
            }
            if (tr.left() instanceof RedBlackTree.RedTree) {
                void apply_value;
                void apply_key;
                void apply_right;
                void apply_left;
                void apply_value3;
                void apply_key3;
                void apply_right3;
                RedBlackTree.Tree<A, B> tree = tr.left().left();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<A, B> blackTree = new RedBlackTree.BlackTree<A, B>(x, xv, tl, apply_right3);
                RedBlackTree.Tree<A, B> tree7 = tr.right();
                RedBlackTree.Tree<A, B> tree8 = tr.left().right();
                B b = tr.value();
                A a = tr.key();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<void, void> blackTree3 = new RedBlackTree.BlackTree<void, void>(apply_key3, apply_value3, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right);
                B b3 = tr.left().value();
                A a3 = tr.left().key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, blackTree, blackTree3);
            }
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.BlackTree<A, B>(x, xv, tl, tr);
        }
        if (RedBlackTree$BlackTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.BlackTree<A, B>(x, xv, tl, tr);
    }

    /*
     * WARNING - void declaration
     */
    private <A, B> RedBlackTree.Tree<A, B> balLeft(A x, B xv, RedBlackTree.Tree<A, B> tl, RedBlackTree.Tree<A, B> tr) {
        if (tl instanceof RedBlackTree.RedTree) {
            void apply_left;
            RedBlackTree.Tree<A, B> tree = tl.black();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<A, B>(x, xv, apply_left, tr);
        }
        if (tr instanceof RedBlackTree.BlackTree) {
            return this.balance(x, xv, tl, tr.red());
        }
        if (tr instanceof RedBlackTree.RedTree && tr.left() instanceof RedBlackTree.BlackTree) {
            void apply_right;
            void apply_value;
            void apply_key;
            void apply_right2;
            RedBlackTree.Tree<A, B> tree = tr.left().left();
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            RedBlackTree.BlackTree<A, B> blackTree = new RedBlackTree.BlackTree<A, B>(x, xv, tl, apply_right2);
            RedBlackTree.Tree<A, B> tree2 = this.balance(tr.key(), tr.value(), tr.left().right(), tr.right().red());
            B b = tr.left().value();
            A a = tr.left().key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)blackTree, (RedBlackTree.Tree<void, void>)apply_right);
        }
        throw package$.MODULE$.error("Defect: invariance violation");
    }

    /*
     * WARNING - void declaration
     */
    private <A, B> RedBlackTree.Tree<A, B> balRight(A x, B xv, RedBlackTree.Tree<A, B> tl, RedBlackTree.Tree<A, B> tr) {
        if (tr instanceof RedBlackTree.RedTree) {
            void apply_right;
            RedBlackTree.Tree<A, B> tree = tr.black();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<A, B>(x, xv, tl, apply_right);
        }
        if (tl instanceof RedBlackTree.BlackTree) {
            return this.balance(x, xv, tl.red(), tr);
        }
        if (tl instanceof RedBlackTree.RedTree && tl.right() instanceof RedBlackTree.BlackTree) {
            void apply_left;
            void apply_value;
            void apply_key;
            void apply_left2;
            RedBlackTree.Tree<A, B> tree = tl.right().right();
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            RedBlackTree.BlackTree<A, B> blackTree = new RedBlackTree.BlackTree<A, B>(x, xv, apply_left2, tr);
            RedBlackTree.Tree<A, B> tree2 = this.balance(tl.key(), tl.value(), tl.left().red(), tl.right().left());
            B b = tl.right().value();
            A a = tl.right().key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)blackTree);
        }
        throw package$.MODULE$.error("Defect: invariance violation");
    }

    /*
     * WARNING - void declaration
     */
    private <A, B> RedBlackTree.Tree<A, B> append(RedBlackTree.Tree<A, B> tl, RedBlackTree.Tree<A, B> tr) {
        if (tl == null) {
            return tr;
        }
        if (tr == null) {
            return tl;
        }
        if (tl instanceof RedBlackTree.RedTree && tr instanceof RedBlackTree.RedTree) {
            void apply_left;
            void apply_value;
            void apply_key;
            void apply_right;
            void apply_value2;
            void apply_key2;
            RedBlackTree.Tree<A, B> bc = this.append(tl.right(), tr.left());
            if (bc instanceof RedBlackTree.RedTree) {
                void apply_value3;
                void apply_key3;
                void apply_right2;
                void apply_left2;
                void apply_value4;
                void apply_key4;
                void apply_right3;
                void apply_left3;
                void apply_value5;
                void apply_key5;
                RedBlackTree.Tree<A, B> tree = bc.left();
                RedBlackTree.Tree<A, B> tree2 = tl.left();
                B b = tl.value();
                A a = tl.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.RedTree<void, void> redTree = new RedBlackTree.RedTree<void, void>(apply_key5, apply_value5, (RedBlackTree.Tree<void, void>)apply_left3, (RedBlackTree.Tree<void, void>)apply_right3);
                RedBlackTree.Tree<A, B> tree3 = tr.right();
                RedBlackTree.Tree<A, B> tree4 = bc.right();
                B b2 = tr.value();
                A a2 = tr.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.RedTree<void, void> redTree2 = new RedBlackTree.RedTree<void, void>(apply_key4, apply_value4, (RedBlackTree.Tree<void, void>)apply_left2, (RedBlackTree.Tree<void, void>)apply_right2);
                B b3 = bc.value();
                A a3 = bc.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key3, apply_value3, redTree, redTree2);
            }
            RedBlackTree.Tree<A, B> tree = tr.right();
            B b = tr.value();
            A a = tr.key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            RedBlackTree.RedTree<void, void> redTree = new RedBlackTree.RedTree<void, void>(apply_key2, apply_value2, (RedBlackTree.Tree<void, void>)bc, (RedBlackTree.Tree<void, void>)apply_right);
            RedBlackTree.Tree<A, B> tree5 = tl.left();
            B b4 = tl.value();
            A a4 = tl.key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)redTree);
        }
        if (tl instanceof RedBlackTree.BlackTree && tr instanceof RedBlackTree.BlackTree) {
            void apply_right;
            void apply_value;
            void apply_key;
            RedBlackTree.Tree<A, B> bc = this.append(tl.right(), tr.left());
            if (bc instanceof RedBlackTree.RedTree) {
                void apply_value6;
                void apply_key6;
                void apply_right4;
                void apply_left;
                void apply_value7;
                void apply_key7;
                void apply_right5;
                void apply_left4;
                void apply_value8;
                void apply_key8;
                RedBlackTree.Tree<A, B> tree = bc.left();
                RedBlackTree.Tree<A, B> tree6 = tl.left();
                B b = tl.value();
                A a = tl.key();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<void, void> blackTree = new RedBlackTree.BlackTree<void, void>(apply_key8, apply_value8, (RedBlackTree.Tree<void, void>)apply_left4, (RedBlackTree.Tree<void, void>)apply_right5);
                RedBlackTree.Tree<A, B> tree7 = tr.right();
                RedBlackTree.Tree<A, B> tree8 = bc.right();
                B b5 = tr.value();
                A a5 = tr.key();
                if (RedBlackTree$BlackTree$.MODULE$ == null) {
                    throw null;
                }
                RedBlackTree.BlackTree<void, void> blackTree2 = new RedBlackTree.BlackTree<void, void>(apply_key7, apply_value7, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right4);
                B b6 = bc.value();
                A a6 = bc.key();
                if (RedBlackTree$RedTree$.MODULE$ == null) {
                    throw null;
                }
                return new RedBlackTree.RedTree<void, void>(apply_key6, apply_value6, blackTree, blackTree2);
            }
            RedBlackTree.Tree<A, B> tree = tr.right();
            B b = tr.value();
            A a = tr.key();
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            return this.balLeft(tl.key(), tl.value(), tl.left(), new RedBlackTree.BlackTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)bc, (RedBlackTree.Tree<void, void>)apply_right));
        }
        if (tr instanceof RedBlackTree.RedTree) {
            void apply_right;
            void apply_left;
            void apply_value;
            void apply_key;
            RedBlackTree.Tree<A, B> tree = tr.right();
            RedBlackTree.Tree<A, B> tree9 = this.append(tl, tr.left());
            B b = tr.value();
            A a = tr.key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right);
        }
        if (tl instanceof RedBlackTree.RedTree) {
            void apply_right;
            void apply_left;
            void apply_value;
            void apply_key;
            RedBlackTree.Tree<A, B> tree = this.append(tl.right(), tr);
            RedBlackTree.Tree<A, B> tree10 = tl.left();
            B b = tl.value();
            A a = tl.key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right);
        }
        throw package$.MODULE$.error(new StringBuilder(28).append("unmatched tree on append: ").append(tl).append(", ").append(tr).toString());
    }

    public <A, B> RedBlackTree.Tree<A, B> union(RedBlackTree.Tree<A, B> t1, RedBlackTree.Tree<A, B> t2, Ordering<A> ordering) {
        return this.blacken(this._union(t1, t2, ordering));
    }

    public <A, B> RedBlackTree.Tree<A, B> intersect(RedBlackTree.Tree<A, B> t1, RedBlackTree.Tree<A, B> t2, Ordering<A> ordering) {
        return this.blacken(this._intersect(t1, t2, ordering));
    }

    public <A, B> RedBlackTree.Tree<A, B> difference(RedBlackTree.Tree<A, B> t1, RedBlackTree.Tree<A, ?> t2, Ordering<A> ordering) {
        return this.blacken(this._difference(t1, t2, ordering));
    }

    private int rank(RedBlackTree.Tree<?, ?> t, int bh) {
        if (t == null) {
            return 0;
        }
        if (t instanceof RedBlackTree.BlackTree) {
            return 2 * (bh - 1);
        }
        return 2 * bh - 1;
    }

    /*
     * WARNING - void declaration
     */
    private <A, B> RedBlackTree.Tree<A, B> joinRight(RedBlackTree.Tree<A, B> tl, A k, B v, RedBlackTree.Tree<A, B> tr, int bhtl, int rtr) {
        if ((tl == null ? 0 : (tl instanceof RedBlackTree.BlackTree ? 2 * (bhtl - 1) : 2 * bhtl - 1)) == rtr / 2 * 2) {
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<A, B>(k, v, tl, tr);
        }
        boolean bl = tl instanceof RedBlackTree.BlackTree;
        int bhtlr = bl ? bhtl - 1 : bhtl;
        RedBlackTree.Tree<A, B> ttr = this.joinRight(tl.right(), k, v, tr, bhtlr, rtr);
        if (bl && ttr instanceof RedBlackTree.RedTree && ttr.right() instanceof RedBlackTree.RedTree) {
            void apply_right;
            void apply_value;
            void apply_key;
            void apply_right2;
            void apply_left;
            void apply_value2;
            void apply_key2;
            RedBlackTree.Tree<A, B> tree = ttr.left();
            RedBlackTree.Tree<A, B> tree2 = tl.left();
            B b = tl.value();
            A a = tl.key();
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            RedBlackTree.BlackTree<void, void> blackTree = new RedBlackTree.BlackTree<void, void>(apply_key2, apply_value2, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right2);
            RedBlackTree.Tree<A, B> tree3 = ttr.right().black();
            B b2 = ttr.value();
            A a2 = ttr.key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)blackTree, (RedBlackTree.Tree<void, void>)apply_right);
        }
        return this.mkTree(bl, tl.key(), tl.value(), tl.left(), ttr);
    }

    /*
     * WARNING - void declaration
     */
    private <A, B> RedBlackTree.Tree<A, B> joinLeft(RedBlackTree.Tree<A, B> tl, A k, B v, RedBlackTree.Tree<A, B> tr, int rtl, int bhtr) {
        if ((tr == null ? 0 : (tr instanceof RedBlackTree.BlackTree ? 2 * (bhtr - 1) : 2 * bhtr - 1)) == rtl / 2 * 2) {
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<A, B>(k, v, tl, tr);
        }
        boolean bl = tr instanceof RedBlackTree.BlackTree;
        int bhtrl = bl ? bhtr - 1 : bhtr;
        RedBlackTree.Tree<A, B> ttl = this.joinLeft(tl, k, v, tr.left(), rtl, bhtrl);
        if (bl && ttl instanceof RedBlackTree.RedTree && ttl.left() instanceof RedBlackTree.RedTree) {
            void apply_left;
            void apply_value;
            void apply_key;
            void apply_right;
            void apply_left2;
            void apply_value2;
            void apply_key2;
            RedBlackTree.Tree<A, B> tree = tr.right();
            RedBlackTree.Tree<A, B> tree2 = ttl.right();
            B b = tr.value();
            A a = tr.key();
            if (RedBlackTree$BlackTree$.MODULE$ == null) {
                throw null;
            }
            RedBlackTree.BlackTree<void, void> blackTree = new RedBlackTree.BlackTree<void, void>(apply_key2, apply_value2, (RedBlackTree.Tree<void, void>)apply_left2, (RedBlackTree.Tree<void, void>)apply_right);
            RedBlackTree.Tree<A, B> tree3 = ttl.left().black();
            B b2 = ttl.value();
            A a2 = ttl.key();
            if (RedBlackTree$RedTree$.MODULE$ == null) {
                throw null;
            }
            return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)blackTree);
        }
        return this.mkTree(bl, tr.key(), tr.value(), ttl, tr.right());
    }

    private <A, B> RedBlackTree.Tree<A, B> join(RedBlackTree.Tree<A, B> tl, A k, B v, RedBlackTree.Tree<A, B> tr) {
        int bhtr;
        int bhtl = this.h$1(tl, 0);
        if (bhtl > (bhtr = this.h$1(tr, 0))) {
            RedBlackTree.Tree<A, B> tt = this.joinRight(tl, k, v, tr, bhtl, tr == null ? 0 : (tr instanceof RedBlackTree.BlackTree ? 2 * (bhtr - 1) : 2 * bhtr - 1));
            if (tt instanceof RedBlackTree.RedTree && tt.right() instanceof RedBlackTree.RedTree) {
                return tt.black();
            }
            return tt;
        }
        if (bhtr > bhtl) {
            RedBlackTree.Tree<A, B> tt = this.joinLeft(tl, k, v, tr, tl == null ? 0 : (tl instanceof RedBlackTree.BlackTree ? 2 * (bhtl - 1) : 2 * bhtl - 1), bhtr);
            if (tt instanceof RedBlackTree.RedTree && tt.left() instanceof RedBlackTree.RedTree) {
                return tt.black();
            }
            return tt;
        }
        return this.mkTree(tl instanceof RedBlackTree.RedTree || tr instanceof RedBlackTree.RedTree, k, v, tl, tr);
    }

    private <A, B> Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A> split(RedBlackTree.Tree<A, B> t, A k2, Ordering<A> ordering) {
        if (t == null) {
            return new Tuple4<Object, Object, Object, A>(null, null, null, k2);
        }
        int cmp = ordering.compare(k2, t.key());
        if (cmp == 0) {
            return new Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A>(t.left(), t, t.right(), t.key());
        }
        if (cmp < 0) {
            Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A> tuple4 = this.split(t.left(), k2, ordering);
            if (tuple4 == null) {
                throw new MatchError((Object)null);
            }
            RedBlackTree.Tree<A, B> tree = tuple4._1();
            RedBlackTree.Tree<A, B> tree2 = tuple4._2();
            RedBlackTree.Tree<A, B> tree3 = tuple4._3();
            A a = tuple4._4();
            RedBlackTree.Tree<A, B> ll = tree;
            RedBlackTree.Tree<A, B> b = tree2;
            RedBlackTree.Tree<A, B> lr = tree3;
            return new Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A>(ll, b, this.join(lr, t.key(), t.value(), t.right()), a);
        }
        Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A> tuple4 = this.split(t.right(), k2, ordering);
        if (tuple4 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, B> tree = tuple4._1();
        RedBlackTree.Tree<A, B> tree4 = tuple4._2();
        RedBlackTree.Tree<A, B> tree5 = tuple4._3();
        A a = tuple4._4();
        RedBlackTree.Tree<A, B> rl = tree;
        RedBlackTree.Tree<A, B> b = tree4;
        RedBlackTree.Tree<A, B> rr = tree5;
        return new Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A>(this.join(t.left(), t.key(), t.value(), rl), b, rr, a);
    }

    private <A, B> Tuple3<RedBlackTree.Tree<A, B>, A, B> splitLast(RedBlackTree.Tree<A, B> t) {
        if (t.right() == null) {
            return new Tuple3<RedBlackTree.Tree<A, B>, A, B>(t.left(), t.key(), t.value());
        }
        Tuple3<RedBlackTree.Tree<A, B>, A, B> tuple3 = this.splitLast(t.right());
        if (tuple3 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, B> tree = tuple3._1();
        A a = tuple3._2();
        B b = tuple3._3();
        RedBlackTree.Tree<A, B> tt = tree;
        return new Tuple3<RedBlackTree.Tree<A, B>, A, B>(this.join(t.left(), t.key(), t.value(), tt), a, b);
    }

    private <A, B> RedBlackTree.Tree<A, B> join2(RedBlackTree.Tree<A, B> tl, RedBlackTree.Tree<A, B> tr) {
        if (tl == null) {
            return tr;
        }
        if (tr == null) {
            return tl;
        }
        Tuple3<RedBlackTree.Tree<A, B>, A, B> tuple3 = this.splitLast(tl);
        if (tuple3 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, B> tree = tuple3._1();
        A a = tuple3._2();
        B b = tuple3._3();
        RedBlackTree.Tree<A, B> ttl = tree;
        return this.join(ttl, a, b, tr);
    }

    private <A, B> RedBlackTree.Tree<A, B> _union(RedBlackTree.Tree<A, B> t1, RedBlackTree.Tree<A, B> t2, Ordering<A> ordering) {
        if (t1 == null || t1 == t2) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A> tuple4 = this.split(t1, t2.key(), ordering);
        if (tuple4 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, B> tree = tuple4._1();
        RedBlackTree.Tree<A, B> tree2 = tuple4._3();
        A a = tuple4._4();
        RedBlackTree.Tree<A, B> l1 = tree;
        RedBlackTree.Tree<A, B> r1 = tree2;
        RedBlackTree.Tree<A, B> tl = this._union(l1, t2.left(), ordering);
        RedBlackTree.Tree<A, B> tr = this._union(r1, t2.right(), ordering);
        return this.join(tl, a, t2.value(), tr);
    }

    private <A, B> RedBlackTree.Tree<A, B> _intersect(RedBlackTree.Tree<A, B> t1, RedBlackTree.Tree<A, B> t2, Ordering<A> ordering) {
        if (t1 == null || t2 == null) {
            return null;
        }
        if (t1 == t2) {
            return t1;
        }
        Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A> tuple4 = this.split(t1, t2.key(), ordering);
        if (tuple4 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, B> tree = tuple4._1();
        RedBlackTree.Tree<A, B> tree2 = tuple4._2();
        RedBlackTree.Tree<A, B> tree3 = tuple4._3();
        A a = tuple4._4();
        RedBlackTree.Tree<A, B> l1 = tree;
        RedBlackTree.Tree<A, B> b = tree2;
        RedBlackTree.Tree<A, B> r1 = tree3;
        RedBlackTree.Tree<A, B> tl = this._intersect(l1, t2.left(), ordering);
        RedBlackTree.Tree<A, B> tr = this._intersect(r1, t2.right(), ordering);
        if (b != null) {
            return this.join(tl, a, t2.value(), tr);
        }
        return this.join2(tl, tr);
    }

    private <A, B> RedBlackTree.Tree<A, B> _difference(RedBlackTree.Tree<A, B> t1, RedBlackTree.Tree<A, B> t2, Ordering<A> ordering) {
        if (t1 == null || t2 == null) {
            return t1;
        }
        if (t1 == t2) {
            return null;
        }
        Tuple4<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>, A> tuple4 = this.split(t1, t2.key(), ordering);
        if (tuple4 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, B> tree = tuple4._1();
        RedBlackTree.Tree<A, B> tree2 = tuple4._3();
        tuple4._4();
        RedBlackTree.Tree<A, B> l1 = tree;
        RedBlackTree.Tree<A, B> r1 = tree2;
        RedBlackTree.Tree<A, B> tl = this._difference(l1, t2.left(), ordering);
        RedBlackTree.Tree<A, B> tr = this._difference(r1, t2.right(), ordering);
        return this.join2(tl, tr);
    }

    /*
     * WARNING - void declaration
     */
    private final RedBlackTree.Tree _tail$1(RedBlackTree.Tree tree) {
        void apply_right;
        void apply_left;
        void apply_value;
        void apply_key;
        if (tree == null) {
            throw new NoSuchElementException("empty tree");
        }
        if (tree.left() == null) {
            return tree.right();
        }
        if (tree.left() instanceof RedBlackTree.BlackTree) {
            return this.balLeft(tree.key(), tree.value(), this._tail$1(tree.left()), tree.right());
        }
        RedBlackTree.Tree tree2 = tree.right();
        RedBlackTree.Tree tree3 = this._tail$1(tree.left());
        Object b = tree.value();
        Object a = tree.key();
        if (RedBlackTree$RedTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right);
    }

    /*
     * WARNING - void declaration
     */
    private final RedBlackTree.Tree _init$1(RedBlackTree.Tree tree) {
        void apply_right;
        void apply_left;
        void apply_value;
        void apply_key;
        if (tree == null) {
            throw new NoSuchElementException("empty tree");
        }
        if (tree.right() == null) {
            return tree.left();
        }
        if (tree.right() instanceof RedBlackTree.BlackTree) {
            return this.balRight(tree.key(), tree.value(), tree.left(), this._init$1(tree.right()));
        }
        RedBlackTree.Tree tree2 = this._init$1(tree.right());
        RedBlackTree.Tree tree3 = tree.left();
        Object b = tree.value();
        Object a = tree.key();
        if (RedBlackTree$RedTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right);
    }

    private final RedBlackTree.Tree f$1(int level, int size, int maxUsedDepth$1, Iterator xs$1) {
        switch (size) {
            case 0: {
                return null;
            }
            case 1: {
                return this.mkTree(level != maxUsedDepth$1 || level == 1, xs$1.next(), null, null, null);
            }
        }
        int leftSize = (size - 1) / 2;
        RedBlackTree.Tree left = this.f$1(level + 1, leftSize, maxUsedDepth$1, xs$1);
        Object x = xs$1.next();
        RedBlackTree.Tree right = this.f$1(level + 1, size - 1 - leftSize, maxUsedDepth$1, xs$1);
        if (RedBlackTree$BlackTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.BlackTree(x, null, left, right);
    }

    private final RedBlackTree.Tree f$2(int level, int size, Iterator xs$2, int maxUsedDepth$2) {
        switch (size) {
            case 0: {
                return null;
            }
            case 1: {
                Tuple2 tuple2 = (Tuple2)xs$2.next();
                if (tuple2 == null) {
                    throw new MatchError((Object)null);
                }
                Object T1 = tuple2._1();
                Object T2 = tuple2._2();
                return this.mkTree(level != maxUsedDepth$2 || level == 1, T1, T2, null, null);
            }
        }
        int leftSize = (size - 1) / 2;
        RedBlackTree.Tree left = this.f$2(level + 1, leftSize, xs$2, maxUsedDepth$2);
        Tuple2 tuple2 = (Tuple2)xs$2.next();
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        Object T1 = tuple2._1();
        Object T2 = tuple2._2();
        RedBlackTree.Tree right = this.f$2(level + 1, size - 1 - leftSize, xs$2, maxUsedDepth$2);
        if (RedBlackTree$BlackTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.BlackTree(T1, T2, left, right);
    }

    private final RedBlackTree.Tree fk$1(RedBlackTree.Tree t, Function2 f$3) {
        RedBlackTree.Tree r2;
        Object k = t.key();
        Object v = t.value();
        RedBlackTree.Tree l = t.left();
        RedBlackTree.Tree r = t.right();
        RedBlackTree.Tree l2 = l == null ? null : this.fk$1(l, f$3);
        boolean keep = BoxesRunTime.unboxToBoolean(f$3.apply(k, v));
        RedBlackTree.Tree tree = r2 = r == null ? null : this.fk$1(r, f$3);
        if (!keep) {
            return this.join2(l2, r2);
        }
        if (l2 == l && r2 == r) {
            return t;
        }
        return this.join(l2, k, v, r2);
    }

    private final RedBlackTree.Tree fk$2(RedBlackTree.Tree t, boolean isFlipped$1, Function1 f$4) {
        RedBlackTree.Tree r2;
        Object k = t.key();
        RedBlackTree.Tree l = t.left();
        RedBlackTree.Tree r = t.right();
        RedBlackTree.Tree l2 = l == null ? null : this.fk$2(l, isFlipped$1, f$4);
        boolean keep = isFlipped$1 ^ BoxesRunTime.unboxToBoolean(f$4.apply(k));
        RedBlackTree.Tree tree = r2 = r == null ? null : this.fk$2(r, isFlipped$1, f$4);
        if (!keep) {
            return this.join2(l2, r2);
        }
        if (l2 == l && r2 == r) {
            return t;
        }
        return this.join(l2, k, t.value(), r2);
    }

    private final void fk$3(RedBlackTree.Tree t, ObjectRef tmpk$1, ObjectRef tmpd$1, Function2 p$1) {
        RedBlackTree.Tree jk;
        Object k = t.key();
        Object v = t.value();
        RedBlackTree.Tree l = t.left();
        RedBlackTree.Tree r = t.right();
        RedBlackTree.Tree l2k = null;
        RedBlackTree.Tree l2d = null;
        RedBlackTree.Tree r2k = null;
        RedBlackTree.Tree r2d = null;
        if (l != null) {
            this.fk$3(l, tmpk$1, tmpd$1, p$1);
            l2k = (RedBlackTree.Tree)tmpk$1.elem;
            l2d = (RedBlackTree.Tree)tmpd$1.elem;
        }
        boolean keep = BoxesRunTime.unboxToBoolean(p$1.apply(k, v));
        if (r != null) {
            this.fk$3(r, tmpk$1, tmpd$1, p$1);
            r2k = (RedBlackTree.Tree)tmpk$1.elem;
            r2d = (RedBlackTree.Tree)tmpd$1.elem;
        }
        RedBlackTree.Tree tree = !keep ? this.join2(l2k, r2k) : (jk = l2k == l && r2k == r ? t : this.join(l2k, k, v, r2k));
        RedBlackTree.Tree jd = keep ? this.join2(l2d, r2d) : (l2d == l && r2d == r ? t : this.join(l2d, k, v, r2d));
        tmpk$1.elem = jk;
        tmpd$1.elem = jd;
    }

    private final void fk$4(RedBlackTree.Tree t, ObjectRef tmpk$2, ObjectRef tmpd$2, Function1 p$2) {
        RedBlackTree.Tree jk;
        Object k = t.key();
        Object v = t.value();
        RedBlackTree.Tree l = t.left();
        RedBlackTree.Tree r = t.right();
        RedBlackTree.Tree l2k = null;
        RedBlackTree.Tree l2d = null;
        RedBlackTree.Tree r2k = null;
        RedBlackTree.Tree r2d = null;
        if (l != null) {
            this.fk$4(l, tmpk$2, tmpd$2, p$2);
            l2k = (RedBlackTree.Tree)tmpk$2.elem;
            l2d = (RedBlackTree.Tree)tmpd$2.elem;
        }
        boolean keep = BoxesRunTime.unboxToBoolean(p$2.apply(k));
        if (r != null) {
            this.fk$4(r, tmpk$2, tmpd$2, p$2);
            r2k = (RedBlackTree.Tree)tmpk$2.elem;
            r2d = (RedBlackTree.Tree)tmpd$2.elem;
        }
        RedBlackTree.Tree tree = !keep ? this.join2(l2k, r2k) : (jk = l2k == l && r2k == r ? t : this.join(l2k, k, v, r2k));
        RedBlackTree.Tree jd = keep ? this.join2(l2d, r2d) : (l2d == l && r2d == r ? t : this.join(l2d, k, v, r2d));
        tmpk$2.elem = jk;
        tmpd$2.elem = jd;
    }

    /*
     * WARNING - void declaration
     */
    private final RedBlackTree.Tree delLeft$1(RedBlackTree.Tree tree$1, Object k$1, Ordering ordering$1) {
        void apply_right;
        void apply_left;
        void apply_value;
        void apply_key;
        if (tree$1.left() instanceof RedBlackTree.BlackTree) {
            return this.balLeft(tree$1.key(), tree$1.value(), this.del(tree$1.left(), k$1, ordering$1), tree$1.right());
        }
        RedBlackTree.Tree tree = tree$1.right();
        RedBlackTree.Tree tree2 = this.del(tree$1.left(), k$1, ordering$1);
        Object b = tree$1.value();
        Object a = tree$1.key();
        if (RedBlackTree$RedTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right);
    }

    /*
     * WARNING - void declaration
     */
    private final RedBlackTree.Tree delRight$1(RedBlackTree.Tree tree$1, Object k$1, Ordering ordering$1) {
        void apply_right;
        void apply_left;
        void apply_value;
        void apply_key;
        if (tree$1.right() instanceof RedBlackTree.BlackTree) {
            return this.balRight(tree$1.key(), tree$1.value(), tree$1.left(), this.del(tree$1.right(), k$1, ordering$1));
        }
        RedBlackTree.Tree tree = this.del(tree$1.right(), k$1, ordering$1);
        RedBlackTree.Tree tree2 = tree$1.left();
        Object b = tree$1.value();
        Object a = tree$1.key();
        if (RedBlackTree$RedTree$.MODULE$ == null) {
            throw null;
        }
        return new RedBlackTree.RedTree<void, void>(apply_key, apply_value, (RedBlackTree.Tree<void, void>)apply_left, (RedBlackTree.Tree<void, void>)apply_right);
    }

    private final int h$1(RedBlackTree.Tree t, int i) {
        while (t != null) {
            i = t instanceof RedBlackTree.BlackTree ? i + 1 : i;
            t = t.left();
        }
        return i + 1;
    }

    private RedBlackTree$() {
        MODULE$ = this;
    }
}

