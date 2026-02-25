/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.Function2;
import scala.collection.GenSeq;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.generic.IterableForwarder;
import scala.collection.immutable.Range;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\rhaB\u000f\u001f!\u0003\r\t!\n\u0005\u0006}\u0001!\ta\u0010\u0005\u0006\u0007\u00021\t\u0006\u0012\u0005\u0006\u000b\u0002!\tE\u0012\u0005\u0006\u0015\u0002!\te\u0013\u0005\u0006\u001d\u0002!\te\u0014\u0005\u0006%\u0002!\te\u0015\u0005\u00063\u0002!\tE\u0017\u0005\u0006E\u0002!\te\u0019\u0005\u0006K\u0002!\tE\u001a\u0005\u0006K\u0002!\t\u0005\u001b\u0005\u0006W\u0002!\t\u0005\u001c\u0005\u0006W\u0002!\t\u0005\u001e\u0005\u0006u\u0002!\te\u001f\u0005\u0007u\u0002!\t%!\u0001\t\u000f\u0005=\u0001\u0001\"\u0011\u0002\u0012!9\u0011q\u0002\u0001\u0005B\u0005U\u0001bBA\u000e\u0001\u0011\u0005\u0013Q\u0004\u0005\b\u0003K\u0001A\u0011IA\u0014\u0011\u001d\t)\u0003\u0001C!\u0003{Aq!!\u0013\u0001\t\u0003\nY\u0005C\u0004\u0002X\u0001!\t%!\u0017\t\u000f\u0005]\u0003\u0001\"\u0011\u0002f!9\u00111\u000f\u0001\u0005B\u0005U\u0004bBA:\u0001\u0011\u0005\u0013\u0011\u0011\u0005\b\u0003\u001f\u0003A\u0011IAI\u0011\u001d\ti\n\u0001C!\u0003?Cq!a+\u0001\t\u0003\ni\u000bC\u0004\u0002D\u0002!\t%!2\u0003\u0019M+\u0017OR8so\u0006\u0014H-\u001a:\u000b\u0005}\u0001\u0013aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003C\t\n!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0019\u0013!B:dC2\f7\u0001A\u000b\u0003ME\u001aB\u0001A\u0014,uA\u0011\u0001&K\u0007\u0002E%\u0011!F\t\u0002\u0007\u0003:L(+\u001a4\u0011\u00071js&D\u0001!\u0013\tq\u0003EA\u0002TKF\u0004\"\u0001M\u0019\r\u0001\u00111!\u0007\u0001CC\u0002M\u0012\u0011!Q\t\u0003i]\u0002\"\u0001K\u001b\n\u0005Y\u0012#a\u0002(pi\"Lgn\u001a\t\u0003QaJ!!\u000f\u0012\u0003\u0007\u0005s\u0017\u0010E\u0002<y=j\u0011AH\u0005\u0003{y\u0011\u0011#\u0013;fe\u0006\u0014G.\u001a$pe^\f'\u000fZ3s\u0003\u0019!\u0013N\\5uIQ\t\u0001\t\u0005\u0002)\u0003&\u0011!I\t\u0002\u0005+:LG/\u0001\u0006v]\u0012,'\u000f\\=j]\u001e,\u0012aK\u0001\u0007Y\u0016tw\r\u001e5\u0016\u0003\u001d\u0003\"\u0001\u000b%\n\u0005%\u0013#aA%oi\u0006)\u0011\r\u001d9msR\u0011q\u0006\u0014\u0005\u0006\u001b\u0012\u0001\raR\u0001\u0004S\u0012D\u0018!\u00047f]\u001e$\bnQ8na\u0006\u0014X\r\u0006\u0002H!\")\u0011+\u0002a\u0001\u000f\u0006\u0019A.\u001a8\u0002\u0017%\u001cH)\u001a4j]\u0016$\u0017\t\u001e\u000b\u0003)^\u0003\"\u0001K+\n\u0005Y\u0013#a\u0002\"p_2,\u0017M\u001c\u0005\u00061\u001a\u0001\raR\u0001\u0002q\u0006i1/Z4nK:$H*\u001a8hi\"$2aR.a\u0011\u0015av\u00011\u0001^\u0003\u0005\u0001\b\u0003\u0002\u0015__QK!a\u0018\u0012\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\"B1\b\u0001\u00049\u0015\u0001\u00024s_6\fA\u0002\u001d:fM&DH*\u001a8hi\"$\"a\u00123\t\u000bqC\u0001\u0019A/\u0002\u0015%tG-\u001a=XQ\u0016\u0014X\r\u0006\u0002HO\")A,\u0003a\u0001;R\u0019q)\u001b6\t\u000bqS\u0001\u0019A/\t\u000b\u0005T\u0001\u0019A$\u0002\u000f%tG-\u001a=PMV\u0011Q.\u001d\u000b\u0003\u000f:DQa\\\u0006A\u0002A\fA!\u001a7f[B\u0011\u0001'\u001d\u0003\u0006e.\u0011\ra\u001d\u0002\u0002\u0005F\u0011qfN\u000b\u0003kb$2a\u0012<z\u0011\u0015yG\u00021\u0001x!\t\u0001\u0004\u0010B\u0003s\u0019\t\u00071\u000fC\u0003b\u0019\u0001\u0007q)A\u0006mCN$\u0018J\u001c3fq>3WC\u0001?\u0000)\t9U\u0010C\u0003p\u001b\u0001\u0007a\u0010\u0005\u00021\u007f\u0012)!/\u0004b\u0001gV!\u00111AA\u0005)\u00159\u0015QAA\u0006\u0011\u0019yg\u00021\u0001\u0002\bA\u0019\u0001'!\u0003\u0005\u000bIt!\u0019A:\t\r\u00055a\u00021\u0001H\u0003\r)g\u000eZ\u0001\u000fY\u0006\u001cH/\u00138eKb<\u0006.\u001a:f)\r9\u00151\u0003\u0005\u00069>\u0001\r!\u0018\u000b\u0006\u000f\u0006]\u0011\u0011\u0004\u0005\u00069B\u0001\r!\u0018\u0005\u0007\u0003\u001b\u0001\u0002\u0019A$\u0002\u001fI,g/\u001a:tK&#XM]1u_J,\"!a\b\u0011\t1\n\tcL\u0005\u0004\u0003G\u0001#\u0001C%uKJ\fGo\u001c:\u0002\u0015M$\u0018M\u001d;t/&$\b.\u0006\u0003\u0002*\u0005]B#\u0002+\u0002,\u0005e\u0002bBA\u0017%\u0001\u0007\u0011qF\u0001\u0005i\"\fG\u000fE\u0003-\u0003c\t)$C\u0002\u00024\u0001\u0012aaR3o'\u0016\f\bc\u0001\u0019\u00028\u0011)!O\u0005b\u0001g!1\u00111\b\nA\u0002\u001d\u000baa\u001c4gg\u0016$X\u0003BA \u0003\u000f\"2\u0001VA!\u0011\u001d\tic\u0005a\u0001\u0003\u0007\u0002R\u0001LA\u0019\u0003\u000b\u00022\u0001MA$\t\u0015\u00118C1\u00014\u0003!)g\u000eZ:XSRDW\u0003BA'\u0003+\"2\u0001VA(\u0011\u001d\ti\u0003\u0006a\u0001\u0003#\u0002R\u0001LA\u0019\u0003'\u00022\u0001MA+\t\u0015\u0011HC1\u00014\u00031Ig\u000eZ3y\u001f\u001a\u001cF.[2f+\u0011\tY&a\u0019\u0015\u0007\u001d\u000bi\u0006C\u0004\u0002.U\u0001\r!a\u0018\u0011\u000b1\n\t$!\u0019\u0011\u0007A\n\u0019\u0007B\u0003s+\t\u00071/\u0006\u0003\u0002h\u0005=D#B$\u0002j\u0005E\u0004bBA\u0017-\u0001\u0007\u00111\u000e\t\u0006Y\u0005E\u0012Q\u000e\t\u0004a\u0005=D!\u0002:\u0017\u0005\u0004\u0019\b\"B1\u0017\u0001\u00049\u0015\u0001\u00057bgRLe\u000eZ3y\u001f\u001a\u001cF.[2f+\u0011\t9(a \u0015\u0007\u001d\u000bI\bC\u0004\u0002.]\u0001\r!a\u001f\u0011\u000b1\n\t$! \u0011\u0007A\ny\bB\u0003s/\t\u00071/\u0006\u0003\u0002\u0004\u0006-E#B$\u0002\u0006\u00065\u0005bBA\u00171\u0001\u0007\u0011q\u0011\t\u0006Y\u0005E\u0012\u0011\u0012\t\u0004a\u0005-E!\u0002:\u0019\u0005\u0004\u0019\bBBA\u00071\u0001\u0007q)A\u0007d_:$\u0018-\u001b8t'2L7-Z\u000b\u0005\u0003'\u000bY\nF\u0002U\u0003+Cq!!\f\u001a\u0001\u0004\t9\nE\u0003-\u0003c\tI\nE\u00021\u00037#QA]\rC\u0002M\n\u0001bY8oi\u0006Lgn]\u000b\u0005\u0003C\u000b9\u000bF\u0002U\u0003GCaa\u001c\u000eA\u0002\u0005\u0015\u0006c\u0001\u0019\u0002(\u00121\u0011\u0011\u0016\u000eC\u0002M\u0014!!Q\u0019\u0002\u0017\r|'O]3ta>tGm]\u000b\u0005\u0003_\u000bi\f\u0006\u0003\u00022\u0006}Fc\u0001+\u00024\"1Al\u0007a\u0001\u0003k\u0003r\u0001KA\\_\u0005mF+C\u0002\u0002:\n\u0012\u0011BR;oGRLwN\u001c\u001a\u0011\u0007A\ni\fB\u0003s7\t\u00071\u0007C\u0004\u0002.m\u0001\r!!1\u0011\u000b1\n\t$a/\u0002\u000f%tG-[2fgV\u0011\u0011q\u0019\t\u0005\u0003\u0013\fy-\u0004\u0002\u0002L*\u0019\u0011Q\u001a\u0011\u0002\u0013%lW.\u001e;bE2,\u0017\u0002BAi\u0003\u0017\u0014QAU1oO\u0016Ds\u0001AAk\u00037\fy\u000eE\u0002)\u0003/L1!!7#\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0003\u0003;\faLZ8so\u0006\u0014H-\u001b8hA%\u001c\b%\u001b8iKJ,g\u000e\u001e7zAUt'/\u001a7jC\ndW\rI:j]\u000e,\u0007%\u001b;!SN\u0004cn\u001c;!CV$x.\\1uK\u0012\u0004\u0013M\u001c3!]\u0016<\b%\\3uQ>$7\u000fI2b]\u0002\u0012W\r\t4pe\u001e|G\u000f^3oC\t\t\t/\u0001\u00043]E\nd\u0006\r")
public interface SeqForwarder<A>
extends Seq<A>,
IterableForwarder<A> {
    @Override
    public Seq<A> underlying();

    public static /* synthetic */ int length$(SeqForwarder $this) {
        return $this.length();
    }

    @Override
    default public int length() {
        return this.underlying().length();
    }

    public static /* synthetic */ Object apply$(SeqForwarder $this, int idx) {
        return $this.apply(idx);
    }

    @Override
    default public A apply(int idx) {
        return (A)this.underlying().apply(idx);
    }

    public static /* synthetic */ int lengthCompare$(SeqForwarder $this, int len) {
        return $this.lengthCompare(len);
    }

    @Override
    default public int lengthCompare(int len) {
        return this.underlying().lengthCompare(len);
    }

    public static /* synthetic */ boolean isDefinedAt$(SeqForwarder $this, int x) {
        return $this.isDefinedAt(x);
    }

    @Override
    default public boolean isDefinedAt(int x) {
        return this.underlying().isDefinedAt(x);
    }

    public static /* synthetic */ int segmentLength$(SeqForwarder $this, Function1 p, int from) {
        return $this.segmentLength(p, from);
    }

    @Override
    default public int segmentLength(Function1<A, Object> p, int from) {
        return this.underlying().segmentLength(p, from);
    }

    public static /* synthetic */ int prefixLength$(SeqForwarder $this, Function1 p) {
        return $this.prefixLength(p);
    }

    @Override
    default public int prefixLength(Function1<A, Object> p) {
        return this.underlying().prefixLength(p);
    }

    public static /* synthetic */ int indexWhere$(SeqForwarder $this, Function1 p) {
        return $this.indexWhere(p);
    }

    @Override
    default public int indexWhere(Function1<A, Object> p) {
        return this.underlying().indexWhere(p);
    }

    public static /* synthetic */ int indexWhere$(SeqForwarder $this, Function1 p, int from) {
        return $this.indexWhere(p, from);
    }

    @Override
    default public int indexWhere(Function1<A, Object> p, int from) {
        return this.underlying().indexWhere(p, from);
    }

    public static /* synthetic */ int indexOf$(SeqForwarder $this, Object elem) {
        return $this.indexOf(elem);
    }

    @Override
    default public <B> int indexOf(B elem) {
        return this.underlying().indexOf(elem);
    }

    public static /* synthetic */ int indexOf$(SeqForwarder $this, Object elem, int from) {
        return $this.indexOf(elem, from);
    }

    @Override
    default public <B> int indexOf(B elem, int from) {
        return this.underlying().indexOf(elem, from);
    }

    public static /* synthetic */ int lastIndexOf$(SeqForwarder $this, Object elem) {
        return $this.lastIndexOf(elem);
    }

    @Override
    default public <B> int lastIndexOf(B elem) {
        return this.underlying().lastIndexOf(elem);
    }

    public static /* synthetic */ int lastIndexOf$(SeqForwarder $this, Object elem, int end) {
        return $this.lastIndexOf(elem, end);
    }

    @Override
    default public <B> int lastIndexOf(B elem, int end) {
        return this.underlying().lastIndexOf(elem, end);
    }

    public static /* synthetic */ int lastIndexWhere$(SeqForwarder $this, Function1 p) {
        return $this.lastIndexWhere(p);
    }

    @Override
    default public int lastIndexWhere(Function1<A, Object> p) {
        return this.underlying().lastIndexWhere(p);
    }

    public static /* synthetic */ int lastIndexWhere$(SeqForwarder $this, Function1 p, int end) {
        return $this.lastIndexWhere(p, end);
    }

    @Override
    default public int lastIndexWhere(Function1<A, Object> p, int end) {
        return this.underlying().lastIndexWhere(p, end);
    }

    public static /* synthetic */ Iterator reverseIterator$(SeqForwarder $this) {
        return $this.reverseIterator();
    }

    @Override
    default public Iterator<A> reverseIterator() {
        return this.underlying().reverseIterator();
    }

    public static /* synthetic */ boolean startsWith$(SeqForwarder $this, GenSeq that, int offset) {
        return $this.startsWith(that, offset);
    }

    @Override
    default public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return this.underlying().startsWith(that, offset);
    }

    public static /* synthetic */ boolean startsWith$(SeqForwarder $this, GenSeq that) {
        return $this.startsWith(that);
    }

    @Override
    default public <B> boolean startsWith(GenSeq<B> that) {
        return this.underlying().startsWith(that);
    }

    public static /* synthetic */ boolean endsWith$(SeqForwarder $this, GenSeq that) {
        return $this.endsWith(that);
    }

    @Override
    default public <B> boolean endsWith(GenSeq<B> that) {
        return this.underlying().endsWith(that);
    }

    public static /* synthetic */ int indexOfSlice$(SeqForwarder $this, GenSeq that) {
        return $this.indexOfSlice(that);
    }

    @Override
    default public <B> int indexOfSlice(GenSeq<B> that) {
        return this.underlying().indexOfSlice(that);
    }

    public static /* synthetic */ int indexOfSlice$(SeqForwarder $this, GenSeq that, int from) {
        return $this.indexOfSlice(that, from);
    }

    @Override
    default public <B> int indexOfSlice(GenSeq<B> that, int from) {
        return this.underlying().indexOfSlice(that, from);
    }

    public static /* synthetic */ int lastIndexOfSlice$(SeqForwarder $this, GenSeq that) {
        return $this.lastIndexOfSlice(that);
    }

    @Override
    default public <B> int lastIndexOfSlice(GenSeq<B> that) {
        return this.underlying().lastIndexOfSlice(that);
    }

    public static /* synthetic */ int lastIndexOfSlice$(SeqForwarder $this, GenSeq that, int end) {
        return $this.lastIndexOfSlice(that, end);
    }

    @Override
    default public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
        return this.underlying().lastIndexOfSlice(that, end);
    }

    public static /* synthetic */ boolean containsSlice$(SeqForwarder $this, GenSeq that) {
        return $this.containsSlice(that);
    }

    @Override
    default public <B> boolean containsSlice(GenSeq<B> that) {
        return this.underlying().containsSlice(that);
    }

    public static /* synthetic */ boolean contains$(SeqForwarder $this, Object elem) {
        return $this.contains(elem);
    }

    @Override
    default public <A1> boolean contains(A1 elem) {
        return this.underlying().contains(elem);
    }

    public static /* synthetic */ boolean corresponds$(SeqForwarder $this, GenSeq that, Function2 p) {
        return $this.corresponds(that, p);
    }

    @Override
    default public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return this.underlying().corresponds(that, p);
    }

    public static /* synthetic */ Range indices$(SeqForwarder $this) {
        return $this.indices();
    }

    @Override
    default public Range indices() {
        return this.underlying().indices();
    }

    public static void $init$(SeqForwarder $this) {
    }
}

