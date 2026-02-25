/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.immutable.Vector;
import scala.collection.immutable.Vector$;
import scala.collection.immutable.VectorPointer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t4A\u0001D\u0007\u0003)!)A\b\u0001C\u0001{!9q\b\u0001a\u0001\n\u0013\u0001\u0005b\u0002#\u0001\u0001\u0004%I!\u0012\u0005\u0007\u0017\u0002\u0001\u000b\u0015B!\t\u000f1\u0003\u0001\u0019!C\u0005\u0001\"9Q\n\u0001a\u0001\n\u0013q\u0005B\u0002)\u0001A\u0003&\u0011\tC\u0003R\u0001\u0011\u0005!\u000bC\u0003W\u0001\u0011\u0005s\u000bC\u0003_\u0001\u0011\u0005q\fC\u0003a\u0001\u0011\u0005\u0011MA\u0007WK\u000e$xN\u001d\"vS2$WM\u001d\u0006\u0003\u001d=\t\u0011\"[7nkR\f'\r\\3\u000b\u0005A\t\u0012AC2pY2,7\r^5p]*\t!#A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005U\u00113\u0003\u0002\u0001\u00175=\u0002\"a\u0006\r\u000e\u0003EI!!G\t\u0003\r\u0005s\u0017PU3g!\u0011Yb\u0004I\u0016\u000e\u0003qQ!!H\b\u0002\u000f5,H/\u00192mK&\u0011q\u0004\b\u0002\u0010%\u0016,8/\u00192mK\n+\u0018\u000e\u001c3feB\u0011\u0011E\t\u0007\u0001\t\u0015\u0019\u0003A1\u0001%\u0005\u0005\t\u0015CA\u0013)!\t9b%\u0003\u0002(#\t9aj\u001c;iS:<\u0007CA\f*\u0013\tQ\u0013CA\u0002B]f\u00042\u0001L\u0017!\u001b\u0005i\u0011B\u0001\u0018\u000e\u0005\u00191Vm\u0019;peB\u0019A\u0006\r\u001a\n\u0005Ej!!\u0004,fGR|'\u000fU8j]R,'O\u000b\u0002!g-\nA\u0007\u0005\u00026u5\taG\u0003\u00028q\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0003sE\t!\"\u00198o_R\fG/[8o\u0013\tYdGA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fa\u0001P5oSRtD#\u0001 \u0011\u00071\u0002\u0001%\u0001\u0006cY>\u001c7.\u00138eKb,\u0012!\u0011\t\u0003/\tK!aQ\t\u0003\u0007%sG/\u0001\bcY>\u001c7.\u00138eKb|F%Z9\u0015\u0005\u0019K\u0005CA\fH\u0013\tA\u0015C\u0001\u0003V]&$\bb\u0002&\u0004\u0003\u0003\u0005\r!Q\u0001\u0004q\u0012\n\u0014a\u00032m_\u000e\\\u0017J\u001c3fq\u0002\n!\u0001\\8\u0002\r1|w\fJ3r)\t1u\nC\u0004K\r\u0005\u0005\t\u0019A!\u0002\u00071|\u0007%\u0001\u0005%a2,8\u000fJ3r)\t\u0019F+D\u0001\u0001\u0011\u0015)\u0006\u00021\u0001!\u0003\u0011)G.Z7\u0002\u001b\u0011\u0002H.^:%a2,8\u000fJ3r)\t\u0019\u0006\fC\u0003Z\u0013\u0001\u0007!,\u0001\u0002ygB\u00191\f\u0018\u0011\u000e\u0003=I!!X\b\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\faA]3tk2$H#A\u0016\u0002\u000b\rdW-\u0019:\u0015\u0003\u0019\u0003")
public final class VectorBuilder<A>
implements ReusableBuilder<A, Vector<A>>,
VectorPointer<A> {
    private int blockIndex;
    private int lo;
    private int depth;
    private Object[] display0;
    private Object[] display1;
    private Object[] display2;
    private Object[] display3;
    private Object[] display4;
    private Object[] display5;

    @Override
    public final <U> void initFrom(VectorPointer<U> that) {
        VectorPointer.initFrom$(this, that);
    }

    @Override
    public final <U> void initFrom(VectorPointer<U> that, int depth) {
        VectorPointer.initFrom$(this, that, depth);
    }

    @Override
    public final A getElem(int index, int xor) {
        return (A)VectorPointer.getElem$(this, index, xor);
    }

    @Override
    public final void gotoPos(int index, int xor) {
        VectorPointer.gotoPos$(this, index, xor);
    }

    @Override
    public final void gotoNextBlockStart(int index, int xor) {
        VectorPointer.gotoNextBlockStart$(this, index, xor);
    }

    @Override
    public final void gotoNextBlockStartWritable(int index, int xor) {
        VectorPointer.gotoNextBlockStartWritable$(this, index, xor);
    }

    @Override
    public final Object[] copyOf(Object[] a) {
        return VectorPointer.copyOf$(this, a);
    }

    @Override
    public final Object[] nullSlotAndCopy(Object[] array, int index) {
        return VectorPointer.nullSlotAndCopy$(this, array, index);
    }

    @Override
    public final void stabilize(int index) {
        VectorPointer.stabilize$(this, index);
    }

    @Override
    public final void gotoPosWritable0(int newIndex, int xor) {
        VectorPointer.gotoPosWritable0$(this, newIndex, xor);
    }

    @Override
    public final void gotoPosWritable1(int oldIndex, int newIndex, int xor) {
        VectorPointer.gotoPosWritable1$(this, oldIndex, newIndex, xor);
    }

    @Override
    public final Object[] copyRange(Object[] array, int oldLeft, int newLeft) {
        return VectorPointer.copyRange$(this, array, oldLeft, newLeft);
    }

    @Override
    public final void gotoFreshPosWritable0(int oldIndex, int newIndex, int xor) {
        VectorPointer.gotoFreshPosWritable0$(this, oldIndex, newIndex, xor);
    }

    @Override
    public final void gotoFreshPosWritable1(int oldIndex, int newIndex, int xor) {
        VectorPointer.gotoFreshPosWritable1$(this, oldIndex, newIndex, xor);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<A, NewTo> mapResult(Function1<Vector<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public int depth() {
        return this.depth;
    }

    @Override
    public void depth_$eq(int x$1) {
        this.depth = x$1;
    }

    @Override
    public Object[] display0() {
        return this.display0;
    }

    @Override
    public void display0_$eq(Object[] x$1) {
        this.display0 = x$1;
    }

    @Override
    public Object[] display1() {
        return this.display1;
    }

    @Override
    public void display1_$eq(Object[] x$1) {
        this.display1 = x$1;
    }

    @Override
    public Object[] display2() {
        return this.display2;
    }

    @Override
    public void display2_$eq(Object[] x$1) {
        this.display2 = x$1;
    }

    @Override
    public Object[] display3() {
        return this.display3;
    }

    @Override
    public void display3_$eq(Object[] x$1) {
        this.display3 = x$1;
    }

    @Override
    public Object[] display4() {
        return this.display4;
    }

    @Override
    public void display4_$eq(Object[] x$1) {
        this.display4 = x$1;
    }

    @Override
    public Object[] display5() {
        return this.display5;
    }

    @Override
    public void display5_$eq(Object[] x$1) {
        this.display5 = x$1;
    }

    private int blockIndex() {
        return this.blockIndex;
    }

    private void blockIndex_$eq(int x$1) {
        this.blockIndex = x$1;
    }

    private int lo() {
        return this.lo;
    }

    private void lo_$eq(int x$1) {
        this.lo = x$1;
    }

    @Override
    public VectorBuilder<A> $plus$eq(A elem) {
        if (this.lo() >= this.display0().length) {
            int newBlockIndex = this.blockIndex() + 32;
            this.gotoNextBlockStartWritable(newBlockIndex, this.blockIndex() ^ newBlockIndex);
            this.blockIndex_$eq(newBlockIndex);
            this.lo_$eq(0);
        }
        this.display0()[this.lo()] = elem;
        this.lo_$eq(this.lo() + 1);
        return this;
    }

    @Override
    public VectorBuilder<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return (VectorBuilder)Growable.$plus$plus$eq$(this, xs);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Vector<A> result() {
        void var2_2;
        int size = this.blockIndex() + this.lo();
        if (size == 0) {
            return Vector$.MODULE$.empty();
        }
        Vector s = new Vector(0, size, 0);
        s.initFrom(this);
        if (this.depth() > 1) {
            s.gotoPos(0, size - 1);
        }
        return var2_2;
    }

    @Override
    public void clear() {
        this.display0_$eq(new Object[32]);
        this.depth_$eq(1);
        this.blockIndex_$eq(0);
        this.lo_$eq(0);
    }

    public VectorBuilder() {
        Growable.$init$(this);
        Builder.$init$(this);
        VectorPointer.$init$(this);
        this.display0_$eq(new Object[32]);
        this.depth_$eq(1);
        this.blockIndex = 0;
        this.lo = 0;
    }
}

