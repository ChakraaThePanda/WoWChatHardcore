/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.NoSuchElementException;
import scala.Predef$;
import scala.collection.AbstractIterator;
import scala.collection.immutable.Vector;
import scala.collection.immutable.VectorPointer;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001=4A\u0001F\u000b\u00019!Aq\b\u0001B\u0001B\u0003%\u0001\t\u0003\u0005D\u0001\t\u0005\t\u0015!\u0003A\u0011\u0015!\u0005\u0001\"\u0001F\u0011\u001dI\u0005\u00011A\u0005\n)Cqa\u0013\u0001A\u0002\u0013%A\n\u0003\u0004S\u0001\u0001\u0006K\u0001\u0011\u0005\b'\u0002\u0001\r\u0011\"\u0003K\u0011\u001d!\u0006\u00011A\u0005\nUCaa\u0016\u0001!B\u0013\u0001\u0005b\u0002-\u0001\u0001\u0004%IA\u0013\u0005\b3\u0002\u0001\r\u0011\"\u0003[\u0011\u0019a\u0006\u0001)Q\u0005\u0001\")Q\f\u0001C\u0001=\"9!\r\u0001a\u0001\n\u0013q\u0006bB2\u0001\u0001\u0004%I\u0001\u001a\u0005\u0007M\u0002\u0001\u000b\u0015B0\t\u000b\u001d\u0004A\u0011\u00015\t\r%\u0004A\u0011A\fK\u0011\u0019Q\u0007\u0001\"\u0001\u0018W\nqa+Z2u_JLE/\u001a:bi>\u0014(B\u0001\f\u0018\u0003%IW.\\;uC\ndWM\u0003\u0002\u00193\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003i\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u001eIM!\u0001A\b\u00182!\ry\u0002EI\u0007\u0002/%\u0011\u0011e\u0006\u0002\u0011\u0003\n\u001cHO]1di&#XM]1u_J\u0004\"a\t\u0013\r\u0001\u00111Q\u0005\u0001CC\u0002\u0019\u0012\u0011!Q\t\u0003O-\u0002\"\u0001K\u0015\u000e\u0003eI!AK\r\u0003\u000f9{G\u000f[5oOB\u0011\u0001\u0006L\u0005\u0003[e\u00111!\u00118z!\ryrFI\u0005\u0003a]\u0011\u0001\"\u0013;fe\u0006$xN\u001d\t\u0004eM*T\"A\u000b\n\u0005Q*\"!\u0004,fGR|'\u000fU8j]R,'O\u000b\u0002#m-\nq\u0007\u0005\u00029{5\t\u0011H\u0003\u0002;w\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0003ye\t!\"\u00198o_R\fG/[8o\u0013\tq\u0014HA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\f1bX:uCJ$\u0018J\u001c3fqB\u0011\u0001&Q\u0005\u0003\u0005f\u00111!\u00138u\u0003!)g\u000eZ%oI\u0016D\u0018A\u0002\u001fj]&$h\bF\u0002G\u000f\"\u00032A\r\u0001#\u0011\u0015y4\u00011\u0001A\u0011\u0015\u00195\u00011\u0001A\u0003)\u0011Gn\\2l\u0013:$W\r_\u000b\u0002\u0001\u0006q!\r\\8dW&sG-\u001a=`I\u0015\fHCA'Q!\tAc*\u0003\u0002P3\t!QK\\5u\u0011\u001d\tV!!AA\u0002\u0001\u000b1\u0001\u001f\u00132\u0003-\u0011Gn\\2l\u0013:$W\r\u001f\u0011\u0002\u00051|\u0017A\u00027p?\u0012*\u0017\u000f\u0006\u0002N-\"9\u0011\u000bCA\u0001\u0002\u0004\u0001\u0015a\u00017pA\u0005)QM\u001c3M_\u0006IQM\u001c3M_~#S-\u001d\u000b\u0003\u001bnCq!U\u0006\u0002\u0002\u0003\u0007\u0001)\u0001\u0004f]\u0012du\u000eI\u0001\bQ\u0006\u001ch*\u001a=u+\u0005y\u0006C\u0001\u0015a\u0013\t\t\u0017DA\u0004C_>dW-\u00198\u0002\u0011}C\u0017m\u001d(fqR\fAb\u00185bg:+\u0007\u0010^0%KF$\"!T3\t\u000fE{\u0011\u0011!a\u0001?\u0006Iq\f[1t\u001d\u0016DH\u000fI\u0001\u0005]\u0016DH\u000fF\u0001#\u0003U\u0011X-\\1j]&tw-\u00127f[\u0016tGoQ8v]R\fqB]3nC&t\u0017N\\4WK\u000e$xN]\u000b\u0002YB\u0019!'\u001c\u0012\n\u00059,\"A\u0002,fGR|'\u000f")
public class VectorIterator<A>
extends AbstractIterator<A>
implements VectorPointer<A> {
    private final int endIndex;
    private int blockIndex;
    private int lo;
    private int endLo;
    private boolean _hasNext;
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

    private int endLo() {
        return this.endLo;
    }

    private void endLo_$eq(int x$1) {
        this.endLo = x$1;
    }

    @Override
    public boolean hasNext() {
        return this._hasNext();
    }

    private boolean _hasNext() {
        return this._hasNext;
    }

    private void _hasNext_$eq(boolean x$1) {
        this._hasNext = x$1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public A next() {
        void var1_1;
        if (!this._hasNext()) {
            throw new NoSuchElementException("reached iterator end");
        }
        Object res = this.display0()[this.lo()];
        this.lo_$eq(this.lo() + 1);
        if (this.lo() == this.endLo()) {
            if (this.blockIndex() + this.lo() < this.endIndex) {
                int newBlockIndex = this.blockIndex() + 32;
                this.gotoNextBlockStart(newBlockIndex, this.blockIndex() ^ newBlockIndex);
                this.blockIndex_$eq(newBlockIndex);
                this.endLo_$eq(package$.MODULE$.min(this.endIndex - this.blockIndex(), 32));
                this.lo_$eq(0);
            } else {
                this._hasNext_$eq(false);
            }
        }
        return var1_1;
    }

    public int remainingElementCount() {
        int n = this.endIndex - (this.blockIndex() + this.lo());
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichInt$.MODULE$.max$extension(n, 0);
    }

    /*
     * WARNING - void declaration
     */
    public Vector<A> remainingVector() {
        void var1_1;
        Vector v = new Vector(this.blockIndex() + this.lo(), this.endIndex, this.blockIndex() + this.lo());
        v.initFrom(this);
        return var1_1;
    }

    public VectorIterator(int _startIndex, int endIndex) {
        this.endIndex = endIndex;
        VectorPointer.$init$(this);
        this.blockIndex = _startIndex & ~31;
        this.lo = _startIndex & 0x1F;
        this.endLo = package$.MODULE$.min(endIndex - this.blockIndex(), 32);
        this._hasNext = this.blockIndex() + this.lo() < endIndex;
    }
}

