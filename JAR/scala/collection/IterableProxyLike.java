/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.TraversableProxyLike;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005da\u0002\b\u0010!\u0003\r\t\u0001\u0006\u0005\u0006m\u0001!\ta\u000e\u0005\u0006w\u0001!\t\u0005\u0010\u0005\u0006\u0001\u0002!\t%\u0011\u0005\u0006\u0011\u0002!\t%\u0013\u0005\u0006\u0011\u0002!\te\u0013\u0005\u0006\u001f\u0002!\t\u0005\u0015\u0005\u0006'\u0002!\t\u0005\u0016\u0005\u0006-\u0002!\te\u0016\u0005\u0006i\u0002!\t%\u001e\u0005\b\u0003\u001f\u0001A\u0011IA\t\u0011\u001d\t\u0019\u0003\u0001C!\u0003KAq!a\u000e\u0001\t\u0003\nI\u0004C\u0004\u00028\u0001!\t%a\u0012\u0003#%#XM]1cY\u0016\u0004&o\u001c=z\u0019&\\WM\u0003\u0002\u0011#\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003I\tQa]2bY\u0006\u001c\u0001!F\u0002\u0016A)\u001aB\u0001\u0001\f\u001bgA\u0011q\u0003G\u0007\u0002#%\u0011\u0011$\u0005\u0002\u0007\u0003:L(+\u001a4\u0011\tmab$K\u0007\u0002\u001f%\u0011Qd\u0004\u0002\r\u0013R,'/\u00192mK2K7.\u001a\t\u0003?\u0001b\u0001\u0001\u0002\u0004\"\u0001\u0011\u0015\rA\t\u0002\u0002\u0003F\u00111E\n\t\u0003/\u0011J!!J\t\u0003\u000f9{G\u000f[5oOB\u0011qcJ\u0005\u0003QE\u00111!\u00118z!\ty\"\u0006\u0002\u0004,\u0001\u0011\u0015\r\u0001\f\u0002\u0005%\u0016\u0004(/\u0005\u0002$[I\u0019aF\u0007\u0019\u0007\t=\u0002\u0001!\f\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u00047Er\u0012B\u0001\u001a\u0010\u0005!IE/\u001a:bE2,\u0007\u0003B\u000e5=%J!!N\b\u0003)Q\u0013\u0018M^3sg\u0006\u0014G.\u001a)s_bLH*[6f\u0003\u0019!\u0013N\\5uIQ\t\u0001\b\u0005\u0002\u0018s%\u0011!(\u0005\u0002\u0005+:LG/\u0001\u0005ji\u0016\u0014\u0018\r^8s+\u0005i\u0004cA\u000e?=%\u0011qh\u0004\u0002\t\u0013R,'/\u0019;pe\u00069qM]8va\u0016$GC\u0001\"D!\rYb(\u000b\u0005\u0006\t\u000e\u0001\r!R\u0001\u0005g&TX\r\u0005\u0002\u0018\r&\u0011q)\u0005\u0002\u0004\u0013:$\u0018aB:mS\u0012Lgn\u001a\u000b\u0003\u0005*CQ\u0001\u0012\u0003A\u0002\u0015#2A\u0011'N\u0011\u0015!U\u00011\u0001F\u0011\u0015qU\u00011\u0001F\u0003\u0011\u0019H/\u001a9\u0002\u0013Q\f7.\u001a*jO\"$HCA\u0015R\u0011\u0015\u0011f\u00011\u0001F\u0003\u0005q\u0017!\u00033s_B\u0014\u0016n\u001a5u)\tIS\u000bC\u0003S\u000f\u0001\u0007Q)A\u0002{SB,B\u0001W5n7R\u0011\u0011l\u001c\u000b\u00035v\u0003\"aH.\u0005\u000bqC!\u0019\u0001\u0012\u0003\tQC\u0017\r\u001e\u0005\u0006=\"\u0001\u001daX\u0001\u0003E\u001a\u0004R\u0001Y2*Kjk\u0011!\u0019\u0006\u0003E>\tqaZ3oKJL7-\u0003\u0002eC\na1)\u00198Ck&dGM\u0012:p[B!qC\u001a5m\u0013\t9\u0017C\u0001\u0004UkBdWM\r\t\u0003?%$QA\u001b\u0005C\u0002-\u0014!!Q\u0019\u0012\u0005y1\u0003CA\u0010n\t\u0015q\u0007B1\u0001#\u0005\u0005\u0011\u0005\"\u00029\t\u0001\u0004\t\u0018\u0001\u0002;iCR\u00042a\u0007:m\u0013\t\u0019xBA\u0006HK:LE/\u001a:bE2,\u0017A\u0002>ja\u0006cG.F\u0003w\u0003\u0003q\u0018\u0010F\u0004x\u0003\u0007\t9!a\u0003\u0015\u0005aT\bCA\u0010z\t\u0015a\u0016B1\u0001#\u0011\u0015q\u0016\u0002q\u0001|!\u0015\u00017-\u000b?y!\u00119b-`@\u0011\u0005}qH!\u00026\n\u0005\u0004Y\u0007cA\u0010\u0002\u0002\u0011)a.\u0003b\u0001E!1\u0001/\u0003a\u0001\u0003\u000b\u00012a\u0007:\u0000\u0011\u0019\tI!\u0003a\u0001{\u0006AA\u000f[5t\u000b2,W\u000e\u0003\u0004\u0002\u000e%\u0001\ra`\u0001\ti\"\fG/\u00127f[\u0006a!0\u001b9XSRD\u0017J\u001c3fqV1\u00111CA\u0011\u0003/!B!!\u0006\u0002\u001aA\u0019q$a\u0006\u0005\u000bqS!\u0019\u0001\u0012\t\ryS\u00019AA\u000e!\u001d\u00017-KA\u000f\u0003+\u0001Ra\u00064\u0002 \u0015\u00032aHA\u0011\t\u0015Q'B1\u0001l\u00031\u0019\u0018-\\3FY\u0016lWM\u001c;t+\u0011\t9#!\u000e\u0015\t\u0005%\u0012q\u0006\t\u0004/\u0005-\u0012bAA\u0017#\t9!i\\8mK\u0006t\u0007B\u00029\f\u0001\u0004\t\t\u0004\u0005\u0003\u001ce\u0006M\u0002cA\u0010\u00026\u0011)an\u0003b\u0001W\u0006!a/[3x+\t\tYDE\u0003\u0002>Y\t\tEB\u00030\u0001\u0001\tY$C\u0002\u00028q\u0001RaGA\"=%J1!!\u0012\u0010\u00051IE/\u001a:bE2,g+[3x)\u0019\t\t%!\u0013\u0002N!1\u00111J\u0007A\u0002\u0015\u000bAA\u001a:p[\"1\u0011qJ\u0007A\u0002\u0015\u000bQ!\u001e8uS2Ds\u0001AA*\u00033\ni\u0006E\u0002\u0018\u0003+J1!a\u0016\u0012\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0003\u00037\nA\t\u001d:pqfLgn\u001a\u0011jg\u0002\"W\r\u001d:fG\u0006$X\r\u001a\u0011ek\u0016\u0004Co\u001c\u0011mC\u000e\\\u0007e\u001c4!kN,\u0007%\u00198eA\r|W\u000e]5mKJlC.\u001a<fY\u0002\u001aX\u000f\u001d9peR\f#!a\u0018\u0002\rIr\u0013'\r\u00181\u0001")
public interface IterableProxyLike<A, Repr extends IterableLike<A, Repr> & Iterable<A>>
extends IterableLike<A, Repr>,
TraversableProxyLike<A, Repr> {
    public static /* synthetic */ Iterator iterator$(IterableProxyLike $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<A> iterator() {
        return ((IterableLike)this.self()).iterator();
    }

    public static /* synthetic */ Iterator grouped$(IterableProxyLike $this, int size) {
        return $this.grouped(size);
    }

    @Override
    default public Iterator<Repr> grouped(int size) {
        return ((IterableLike)this.self()).grouped(size);
    }

    public static /* synthetic */ Iterator sliding$(IterableProxyLike $this, int size) {
        return $this.sliding(size);
    }

    @Override
    default public Iterator<Repr> sliding(int size) {
        return ((IterableLike)this.self()).sliding(size);
    }

    public static /* synthetic */ Iterator sliding$(IterableProxyLike $this, int size, int step) {
        return $this.sliding(size, step);
    }

    @Override
    default public Iterator<Repr> sliding(int size, int step) {
        return ((IterableLike)this.self()).sliding(size, step);
    }

    public static /* synthetic */ Iterable takeRight$(IterableProxyLike $this, int n) {
        return $this.takeRight(n);
    }

    @Override
    default public Repr takeRight(int n) {
        return (Repr)((Iterable)((IterableLike)this.self()).takeRight(n));
    }

    public static /* synthetic */ Iterable dropRight$(IterableProxyLike $this, int n) {
        return $this.dropRight(n);
    }

    @Override
    default public Repr dropRight(int n) {
        return (Repr)((Iterable)((IterableLike)this.self()).dropRight(n));
    }

    public static /* synthetic */ Object zip$(IterableProxyLike $this, GenIterable that, CanBuildFrom bf) {
        return $this.zip(that, bf);
    }

    @Override
    default public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Repr, Tuple2<A1, B>, That> bf) {
        return ((IterableLike)this.self()).zip(that, bf);
    }

    public static /* synthetic */ Object zipAll$(IterableProxyLike $this, GenIterable that, Object thisElem, Object thatElem, CanBuildFrom bf) {
        return $this.zipAll(that, thisElem, thatElem, bf);
    }

    @Override
    default public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<Repr, Tuple2<A1, B>, That> bf) {
        return ((IterableLike)this.self()).zipAll(that, thisElem, thatElem, bf);
    }

    public static /* synthetic */ Object zipWithIndex$(IterableProxyLike $this, CanBuildFrom bf) {
        return $this.zipWithIndex(bf);
    }

    @Override
    default public <A1, That> That zipWithIndex(CanBuildFrom<Repr, Tuple2<A1, Object>, That> bf) {
        return ((IterableLike)this.self()).zipWithIndex(bf);
    }

    public static /* synthetic */ boolean sameElements$(IterableProxyLike $this, GenIterable that) {
        return $this.sameElements(that);
    }

    @Override
    default public <B> boolean sameElements(GenIterable<B> that) {
        return ((IterableLike)this.self()).sameElements(that);
    }

    public static /* synthetic */ IterableView view$(IterableProxyLike $this) {
        return $this.view();
    }

    @Override
    default public IterableView<A, Repr> view() {
        return ((IterableLike)this.self()).view();
    }

    public static /* synthetic */ IterableView view$(IterableProxyLike $this, int from, int until) {
        return $this.view(from, until);
    }

    @Override
    default public IterableView<A, Repr> view(int from, int until) {
        return ((IterableLike)this.self()).view(from, until);
    }

    public static void $init$(IterableProxyLike $this) {
    }
}

