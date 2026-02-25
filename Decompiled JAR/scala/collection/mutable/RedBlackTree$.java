/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.mutable.RedBlackTree;
import scala.collection.mutable.RedBlackTree$Node$;
import scala.math.Ordering;

public final class RedBlackTree$ {
    public static RedBlackTree$ MODULE$;

    static {
        new RedBlackTree$();
    }

    public boolean isRed(RedBlackTree.Node<?, ?> node) {
        return node != null && node.red();
    }

    public boolean isBlack(RedBlackTree.Node<?, ?> node) {
        return node == null || !node.red();
    }

    public int size(RedBlackTree.Node<?, ?> node) {
        if (node == null) {
            return 0;
        }
        return 1 + this.size(node.left()) + this.size(node.right());
    }

    public int size(RedBlackTree.Tree<?, ?> tree) {
        return tree.size();
    }

    public boolean isEmpty(RedBlackTree.Tree<?, ?> tree) {
        return tree.root() == null;
    }

    public void clear(RedBlackTree.Tree<?, ?> tree) {
        tree.root_$eq(null);
        tree.size_$eq(0);
    }

    public <A, B> Option<B> get(RedBlackTree.Tree<A, B> tree, A key, Ordering<A> evidence$1) {
        RedBlackTree.Node<A, B> node = this.getNode(tree.root(), key, evidence$1);
        Option option = node == null ? None$.MODULE$ : new Some<B>(node.value());
        return option;
    }

    private <A, B> RedBlackTree.Node<A, B> getNode(RedBlackTree.Node<A, B> node, A key, Ordering<A> ord) {
        while (true) {
            if (node == null) {
                return null;
            }
            int cmp = ord.compare(key, node.key());
            if (cmp < 0) {
                node = node.left();
                continue;
            }
            if (cmp <= 0) break;
            node = node.right();
        }
        return node;
    }

    public <A> boolean contains(RedBlackTree.Tree<A, ?> tree, A key, Ordering<A> evidence$2) {
        return this.getNode(tree.root(), key, evidence$2) != null;
    }

    public <A, B> Option<Tuple2<A, B>> min(RedBlackTree.Tree<A, B> tree) {
        RedBlackTree.Node<A, B> node = this.scala$collection$mutable$RedBlackTree$$minNode(tree.root());
        Option option = node == null ? None$.MODULE$ : new Some<Tuple2<A, B>>(new Tuple2<A, B>(node.key(), node.value()));
        return option;
    }

    public <A> Option<A> minKey(RedBlackTree.Tree<A, ?> tree) {
        RedBlackTree.Node<A, ?> node = this.scala$collection$mutable$RedBlackTree$$minNode(tree.root());
        Option option = node == null ? None$.MODULE$ : new Some<A>(node.key());
        return option;
    }

    public <A, B> RedBlackTree.Node<A, B> scala$collection$mutable$RedBlackTree$$minNode(RedBlackTree.Node<A, B> node) {
        if (node == null) {
            return null;
        }
        return this.minNodeNonNull(node);
    }

    public <A, B> RedBlackTree.Node<A, B> minNodeNonNull(RedBlackTree.Node<A, B> node) {
        while (node.left() != null) {
            node = node.left();
        }
        return node;
    }

    public <A, B> Option<Tuple2<A, B>> max(RedBlackTree.Tree<A, B> tree) {
        RedBlackTree.Node<A, B> node = this.maxNode(tree.root());
        Option option = node == null ? None$.MODULE$ : new Some<Tuple2<A, B>>(new Tuple2<A, B>(node.key(), node.value()));
        return option;
    }

    public <A> Option<A> maxKey(RedBlackTree.Tree<A, ?> tree) {
        RedBlackTree.Node<A, ?> node = this.maxNode(tree.root());
        Option option = node == null ? None$.MODULE$ : new Some<A>(node.key());
        return option;
    }

    private <A, B> RedBlackTree.Node<A, B> maxNode(RedBlackTree.Node<A, B> node) {
        if (node == null) {
            return null;
        }
        return this.maxNodeNonNull(node);
    }

    public <A, B> RedBlackTree.Node<A, B> maxNodeNonNull(RedBlackTree.Node<A, B> node) {
        while (node.right() != null) {
            node = node.right();
        }
        return node;
    }

    public <A, B> Option<Tuple2<A, B>> minAfter(RedBlackTree.Tree<A, B> tree, A key, Ordering<A> ord) {
        RedBlackTree.Node<A, B> node = this.scala$collection$mutable$RedBlackTree$$minNodeAfter(tree.root(), key, ord);
        Option option = node == null ? None$.MODULE$ : new Some<Tuple2<A, B>>(new Tuple2<A, B>(node.key(), node.value()));
        return option;
    }

    public <A> Option<A> minKeyAfter(RedBlackTree.Tree<A, ?> tree, A key, Ordering<A> ord) {
        RedBlackTree.Node<A, ?> node = this.scala$collection$mutable$RedBlackTree$$minNodeAfter(tree.root(), key, ord);
        Option option = node == null ? None$.MODULE$ : new Some<A>(node.key());
        return option;
    }

    public <A, B> RedBlackTree.Node<A, B> scala$collection$mutable$RedBlackTree$$minNodeAfter(RedBlackTree.Node<A, B> node, A key, Ordering<A> ord) {
        if (node == null) {
            return null;
        }
        RedBlackTree.Node<A, B> y = null;
        RedBlackTree.Node<A, B> x = node;
        int cmp = 1;
        while (x != null && cmp != 0) {
            y = x;
            cmp = ord.compare(key, x.key());
            x = cmp < 0 ? x.left() : x.right();
        }
        if (cmp <= 0) {
            return y;
        }
        return this.scala$collection$mutable$RedBlackTree$$successor(y);
    }

    public <A, B> Option<Tuple2<A, B>> maxBefore(RedBlackTree.Tree<A, B> tree, A key, Ordering<A> ord) {
        RedBlackTree.Node<A, B> node = this.maxNodeBefore(tree.root(), key, ord);
        Option option = node == null ? None$.MODULE$ : new Some<Tuple2<A, B>>(new Tuple2<A, B>(node.key(), node.value()));
        return option;
    }

    public <A> Option<A> maxKeyBefore(RedBlackTree.Tree<A, ?> tree, A key, Ordering<A> ord) {
        RedBlackTree.Node<A, ?> node = this.maxNodeBefore(tree.root(), key, ord);
        Option option = node == null ? None$.MODULE$ : new Some<A>(node.key());
        return option;
    }

    private <A, B> RedBlackTree.Node<A, B> maxNodeBefore(RedBlackTree.Node<A, B> node, A key, Ordering<A> ord) {
        if (node == null) {
            return null;
        }
        RedBlackTree.Node<A, B> y = null;
        RedBlackTree.Node<A, B> x = node;
        int cmp = 1;
        while (x != null && cmp != 0) {
            y = x;
            cmp = ord.compare(key, x.key());
            x = cmp < 0 ? x.left() : x.right();
        }
        if (cmp > 0) {
            return y;
        }
        return this.predecessor(y);
    }

    /*
     * WARNING - void declaration
     */
    public <A, B> void insert(RedBlackTree.Tree<A, B> tree, A key, B value, Ordering<A> ord) {
        void leaf_red;
        RedBlackTree.Node<A, B> y = null;
        RedBlackTree.Node<A, B> x = tree.root();
        int cmp = 1;
        while (x != null && cmp != 0) {
            y = x;
            cmp = ord.compare(key, x.key());
            x = cmp < 0 ? x.left() : x.right();
        }
        if (cmp == 0) {
            y.value_$eq(value);
            return;
        }
        boolean bl = true;
        if (RedBlackTree$Node$.MODULE$ == null) {
            throw null;
        }
        RedBlackTree.Node<A, B> node = new RedBlackTree.Node<A, B>(key, value, (boolean)leaf_red, null, null, y);
        if (y == null) {
            tree.root_$eq(node);
        } else if (cmp < 0) {
            y.left_$eq(node);
        } else {
            y.right_$eq(node);
        }
        this.fixAfterInsert(tree, node);
        tree.size_$eq(tree.size() + 1);
    }

    private <A, B> void fixAfterInsert(RedBlackTree.Tree<A, B> tree, RedBlackTree.Node<A, B> node) {
        RedBlackTree.Node<A, B> z = node;
        while (this.isRed(z.parent())) {
            if (z.parent() == z.parent().parent().left()) {
                RedBlackTree.Node<A, B> y = z.parent().parent().right();
                if (this.isRed(y)) {
                    z.parent().red_$eq(false);
                    y.red_$eq(false);
                    z.parent().parent().red_$eq(true);
                    z = z.parent().parent();
                    continue;
                }
                if (z == z.parent().right()) {
                    z = z.parent();
                    this.rotateLeft(tree, z);
                }
                z.parent().red_$eq(false);
                z.parent().parent().red_$eq(true);
                this.rotateRight(tree, z.parent().parent());
                continue;
            }
            RedBlackTree.Node<A, B> y = z.parent().parent().left();
            if (this.isRed(y)) {
                z.parent().red_$eq(false);
                y.red_$eq(false);
                z.parent().parent().red_$eq(true);
                z = z.parent().parent();
                continue;
            }
            if (z == z.parent().left()) {
                z = z.parent();
                this.rotateRight(tree, z);
            }
            z.parent().red_$eq(false);
            z.parent().parent().red_$eq(true);
            this.rotateLeft(tree, z.parent().parent());
        }
        tree.root().red_$eq(false);
    }

    public <A, B> void delete(RedBlackTree.Tree<A, B> tree, A key, Ordering<A> ord) {
        RedBlackTree.Node<A, B> z = this.getNode(tree.root(), key, ord);
        if (z != null) {
            RedBlackTree.Node<A, B> xParent;
            RedBlackTree.Node<A, B> x;
            boolean yIsRed = z.red();
            if (z.left() == null) {
                x = z.right();
                this.transplant(tree, z, z.right());
                xParent = z.parent();
            } else if (z.right() == null) {
                x = z.left();
                this.transplant(tree, z, z.left());
                xParent = z.parent();
            } else {
                RedBlackTree.Node<A, B> y = this.minNodeNonNull(z.right());
                yIsRed = y.red();
                x = y.right();
                if (y.parent() == z) {
                    xParent = y;
                } else {
                    xParent = y.parent();
                    this.transplant(tree, y, y.right());
                    y.right_$eq(z.right());
                    y.right().parent_$eq(y);
                }
                this.transplant(tree, z, y);
                y.left_$eq(z.left());
                y.left().parent_$eq(y);
                y.red_$eq(z.red());
            }
            if (!yIsRed) {
                this.fixAfterDelete(tree, x, xParent);
            }
            tree.size_$eq(tree.size() - 1);
        }
    }

    private <A, B> void fixAfterDelete(RedBlackTree.Tree<A, B> tree, RedBlackTree.Node<A, B> node, RedBlackTree.Node<A, B> parent) {
        RedBlackTree.Node<A, B> x = node;
        RedBlackTree.Node<A, B> xParent = parent;
        while (x != tree.root() && this.isBlack(x)) {
            if (x == xParent.left()) {
                RedBlackTree.Node<A, B> w = xParent.right();
                if (w.red()) {
                    w.red_$eq(false);
                    xParent.red_$eq(true);
                    this.rotateLeft(tree, xParent);
                    w = xParent.right();
                }
                if (this.isBlack(w.left()) && this.isBlack(w.right())) {
                    w.red_$eq(true);
                    x = xParent;
                } else {
                    if (this.isBlack(w.right())) {
                        w.left().red_$eq(false);
                        w.red_$eq(true);
                        this.rotateRight(tree, w);
                        w = xParent.right();
                    }
                    w.red_$eq(xParent.red());
                    xParent.red_$eq(false);
                    w.right().red_$eq(false);
                    this.rotateLeft(tree, xParent);
                    x = tree.root();
                }
            } else {
                RedBlackTree.Node<A, B> w = xParent.left();
                if (w.red()) {
                    w.red_$eq(false);
                    xParent.red_$eq(true);
                    this.rotateRight(tree, xParent);
                    w = xParent.left();
                }
                if (this.isBlack(w.right()) && this.isBlack(w.left())) {
                    w.red_$eq(true);
                    x = xParent;
                } else {
                    if (this.isBlack(w.left())) {
                        w.right().red_$eq(false);
                        w.red_$eq(true);
                        this.rotateLeft(tree, w);
                        w = xParent.left();
                    }
                    w.red_$eq(xParent.red());
                    xParent.red_$eq(false);
                    w.left().red_$eq(false);
                    this.rotateRight(tree, xParent);
                    x = tree.root();
                }
            }
            xParent = x.parent();
        }
        if (x != null) {
            x.red_$eq(false);
        }
    }

    /*
     * WARNING - void declaration
     */
    public <A, B> RedBlackTree.Node<A, B> scala$collection$mutable$RedBlackTree$$successor(RedBlackTree.Node<A, B> node) {
        void var3_3;
        if (node.right() != null) {
            return this.minNodeNonNull(node.right());
        }
        RedBlackTree.Node<A, B> x = node;
        for (RedBlackTree.Node<A, B> y = node.parent(); y != null && x == y.right(); y = y.parent()) {
            x = y;
        }
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    private <A, B> RedBlackTree.Node<A, B> predecessor(RedBlackTree.Node<A, B> node) {
        void var3_3;
        if (node.left() != null) {
            return this.maxNodeNonNull(node.left());
        }
        RedBlackTree.Node<A, B> x = node;
        for (RedBlackTree.Node<A, B> y = node.parent(); y != null && x == y.left(); y = y.parent()) {
            x = y;
        }
        return var3_3;
    }

    private <A, B> void rotateLeft(RedBlackTree.Tree<A, B> tree, RedBlackTree.Node<A, B> x) {
        if (x != null) {
            RedBlackTree.Node<A, B> y = x.right();
            x.right_$eq(y.left());
            if (y.left() != null) {
                y.left().parent_$eq(x);
            }
            y.parent_$eq(x.parent());
            if (x.parent() == null) {
                tree.root_$eq(y);
            } else if (x == x.parent().left()) {
                x.parent().left_$eq(y);
            } else {
                x.parent().right_$eq(y);
            }
            y.left_$eq(x);
            x.parent_$eq(y);
        }
    }

    private <A, B> void rotateRight(RedBlackTree.Tree<A, B> tree, RedBlackTree.Node<A, B> x) {
        if (x != null) {
            RedBlackTree.Node<A, B> y = x.left();
            x.left_$eq(y.right());
            if (y.right() != null) {
                y.right().parent_$eq(x);
            }
            y.parent_$eq(x.parent());
            if (x.parent() == null) {
                tree.root_$eq(y);
            } else if (x == x.parent().right()) {
                x.parent().right_$eq(y);
            } else {
                x.parent().left_$eq(y);
            }
            y.right_$eq(x);
            x.parent_$eq(y);
        }
    }

    private <A, B> void transplant(RedBlackTree.Tree<A, B> tree, RedBlackTree.Node<A, B> to, RedBlackTree.Node<A, B> from) {
        if (to.parent() == null) {
            tree.root_$eq(from);
        } else if (to == to.parent().left()) {
            to.parent().left_$eq(from);
        } else {
            to.parent().right_$eq(from);
        }
        if (from != null) {
            from.parent_$eq(to.parent());
        }
    }

    public <A, B, U> void foreach(RedBlackTree.Tree<A, B> tree, Function1<Tuple2<A, B>, U> f) {
        RedBlackTree.Node<A, B> foreachNode_node = tree.root();
        if (foreachNode_node != null) {
            this.foreachNodeNonNull(foreachNode_node, f);
            return;
        }
    }

    private <A, B, U> void foreachNode(RedBlackTree.Node<A, B> node, Function1<Tuple2<A, B>, U> f) {
        if (node != null) {
            this.foreachNodeNonNull(node, f);
        }
    }

    private <A, B, U> void foreachNodeNonNull(RedBlackTree.Node<A, B> node, Function1<Tuple2<A, B>, U> f) {
        while (true) {
            if (node.left() != null) {
                this.foreachNodeNonNull(node.left(), f);
            }
            f.apply(new Tuple2<A, B>(node.key(), node.value()));
            if (node.right() == null) break;
            node = node.right();
        }
    }

    public <A, U> void foreachKey(RedBlackTree.Tree<A, ?> tree, Function1<A, U> f) {
        RedBlackTree.Node<A, ?> foreachNodeKey_node = tree.root();
        if (foreachNodeKey_node != null) {
            this.foreachNodeKeyNonNull(foreachNodeKey_node, f);
            return;
        }
    }

    private <A, U> void foreachNodeKey(RedBlackTree.Node<A, ?> node, Function1<A, U> f) {
        if (node != null) {
            this.foreachNodeKeyNonNull(node, f);
        }
    }

    private <A, U> void foreachNodeKeyNonNull(RedBlackTree.Node<A, ?> node, Function1<A, U> f) {
        while (true) {
            if (node.left() != null) {
                this.foreachNodeKeyNonNull(node.left(), f);
            }
            f.apply(node.key());
            if (node.right() == null) break;
            node = node.right();
        }
    }

    public <A, B> void transform(RedBlackTree.Tree<A, B> tree, Function2<A, B, B> f) {
        RedBlackTree.Node<A, B> transformNode_node = tree.root();
        if (transformNode_node != null) {
            this.transformNodeNonNull(transformNode_node, f);
            return;
        }
    }

    private <A, B, U> void transformNode(RedBlackTree.Node<A, B> node, Function2<A, B, B> f) {
        if (node != null) {
            this.transformNodeNonNull(node, f);
        }
    }

    private <A, B, U> void transformNodeNonNull(RedBlackTree.Node<A, B> node, Function2<A, B, B> f) {
        while (true) {
            if (node.left() != null) {
                this.transformNodeNonNull(node.left(), f);
            }
            node.value_$eq(f.apply(node.key(), node.value()));
            if (node.right() == null) break;
            node = node.right();
        }
    }

    public <A, B> Iterator<Tuple2<A, B>> iterator(RedBlackTree.Tree<A, B> tree, Option<A> start, Option<A> end, Ordering<A> evidence$3) {
        return new RedBlackTree.EntriesIterator<A, B>(tree, start, end, evidence$3);
    }

    public <A, B> None$ iterator$default$2() {
        return None$.MODULE$;
    }

    public <A, B> None$ iterator$default$3() {
        return None$.MODULE$;
    }

    public <A> Iterator<A> keysIterator(RedBlackTree.Tree<A, ?> tree, Option<A> start, Option<A> end, Ordering<A> evidence$4) {
        return new RedBlackTree.KeysIterator(tree, start, end, evidence$4);
    }

    public <A> None$ keysIterator$default$2() {
        return None$.MODULE$;
    }

    public <A> None$ keysIterator$default$3() {
        return None$.MODULE$;
    }

    public <A, B> Iterator<B> valuesIterator(RedBlackTree.Tree<A, B> tree, Option<A> start, Option<A> end, Ordering<A> evidence$5) {
        return new RedBlackTree.ValuesIterator<A, B>(tree, start, end, evidence$5);
    }

    public <A, B> None$ valuesIterator$default$2() {
        return None$.MODULE$;
    }

    public <A, B> None$ valuesIterator$default$3() {
        return None$.MODULE$;
    }

    public <A, B> boolean isValid(RedBlackTree.Tree<A, B> tree, Ordering<A> evidence$9) {
        return this.isValidBST(tree.root(), evidence$9) && this.hasProperParentRefs(tree) && this.isValidRedBlackTree(tree) && this.size(tree.root()) == tree.size();
    }

    private <A, B> boolean hasProperParentRefs(RedBlackTree.Tree<A, B> tree) {
        if (tree.root() == null) {
            return true;
        }
        return tree.root().parent() == null && this.hasProperParentRefs$1(tree.root());
    }

    private <A, B> boolean isValidBST(RedBlackTree.Node<A, B> node, Ordering<A> ord) {
        while (true) {
            if (node == null) {
                return true;
            }
            if (node.left() != null && ord.compare(node.key(), node.left().key()) <= 0 || node.right() != null && ord.compare(node.key(), node.right().key()) >= 0) {
                return false;
            }
            if (!this.isValidBST(node.left(), ord)) break;
            node = node.right();
        }
        return false;
    }

    private <A, B> boolean isValidRedBlackTree(RedBlackTree.Tree<A, B> tree) {
        return this.isBlack(tree.root()) && this.noRedAfterRed$1(tree.root()) && this.blackHeight$1(tree.root()) >= 0;
    }

    private final boolean hasProperParentRefs$1(RedBlackTree.Node node) {
        while (true) {
            if (node == null) {
                return true;
            }
            if (node.left() != null && node.left().parent() != node || node.right() != null && node.right().parent() != node) {
                return false;
            }
            if (!this.hasProperParentRefs$1(node.left())) break;
            node = node.right();
        }
        return false;
    }

    private final boolean noRedAfterRed$1(RedBlackTree.Node node) {
        while (true) {
            if (node == null) {
                return true;
            }
            if (node.red() && (this.isRed(node.left()) || this.isRed(node.right()))) {
                return false;
            }
            if (!this.noRedAfterRed$1(node.left())) break;
            node = node.right();
        }
        return false;
    }

    private final int blackHeight$1(RedBlackTree.Node node) {
        if (node == null) {
            return 1;
        }
        int lh = this.blackHeight$1(node.left());
        int rh = this.blackHeight$1(node.right());
        if (lh == -1 || lh != rh) {
            return -1;
        }
        if (this.isRed(node)) {
            return lh;
        }
        return lh + 1;
    }

    private RedBlackTree$() {
        MODULE$ = this;
    }
}

