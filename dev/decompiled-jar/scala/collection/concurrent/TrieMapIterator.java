/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.concurrent.BasicNode;
import scala.collection.concurrent.CNode;
import scala.collection.concurrent.INode;
import scala.collection.concurrent.KVNode;
import scala.collection.concurrent.LNode;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.SNode;
import scala.collection.concurrent.TNode;
import scala.collection.concurrent.TrieMap;
import scala.collection.concurrent.TrieMapIterator$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u00055e!\u0002\u0013&\u0001\u001dZ\u0003\u0002C$\u0001\u0005\u0003\u0007I\u0011\u0001%\t\u00111\u0003!\u00111A\u0005\u00025C\u0001b\u0015\u0001\u0003\u0002\u0003\u0006K!\u0013\u0005\t)\u0002\u0011\t\u0019!C\u0005+\"A!\f\u0001BA\u0002\u0013%1\f\u0003\u0005^\u0001\t\u0005\t\u0015)\u0003W\u0011!q\u0006A!A!\u0002\u0013y\u0006\"\u00022\u0001\t\u0003\u0019\u0007b\u00025\u0001\u0005\u0004%I!\u001b\u0005\u0007c\u0002\u0001\u000b\u0011\u00026\t\u000fI\u0004!\u0019!C\u0005g\"1Q\u000f\u0001Q\u0001\nQDqA\u001e\u0001A\u0002\u0013%\u0001\nC\u0004x\u0001\u0001\u0007I\u0011\u0002=\t\ri\u0004\u0001\u0015)\u0003J\u0011\u001dY\b\u00011A\u0005\nqDq! \u0001A\u0002\u0013%a\u0010C\u0004\u0002\u0002\u0001\u0001\u000b\u0015B\u0019\t\u0013\u0005\r\u0001\u00011A\u0005\n\u0005\u0015\u0001\"CA\u0007\u0001\u0001\u0007I\u0011BA\b\u0011!\t\u0019\u0002\u0001Q!\n\u0005\u001d\u0001bBA\u000b\u0001\u0011\u0005\u0011q\u0003\u0005\b\u00033\u0001A\u0011AA\u000e\u0011\u001d\ti\u0002\u0001C\u0005\u0003?Aq!a\u000b\u0001\t\u0013\ti\u0003C\u0004\u00020\u0001!I!!\f\t\u000f\u0005E\u0002\u0001\"\u0001\u0002.!9\u00111\u0007\u0001\u0005\u0012\u0005U\u0002bBA\"\u0001\u0011E\u0011Q\t\u0005\b\u0003\u0017\u0002A\u0011CA'\u0011\u001d\t)\u0006\u0001C\u0001\u0003[9!\"a\u001a&\u0003\u0003E\taJA5\r%!S%!A\t\u0002\u001d\nY\u0007\u0003\u0004cC\u0011\u0005\u0011Q\u000e\u0005\n\u0003_\n\u0013\u0013!C\u0001\u0003c\u0012q\u0002\u0016:jK6\u000b\u0007/\u0013;fe\u0006$xN\u001d\u0006\u0003M\u001d\n!bY8oGV\u0014(/\u001a8u\u0015\tA\u0013&\u0001\u0006d_2dWm\u0019;j_:T\u0011AK\u0001\u0006g\u000e\fG.Y\u000b\u0004Yi*5c\u0001\u0001.cA\u0011afL\u0007\u0002S%\u0011\u0001'\u000b\u0002\u0007\u0003:L(+\u001a4\u0011\u0007I\u001aT'D\u0001(\u0013\t!tE\u0001\u0005Ji\u0016\u0014\u0018\r^8s!\u0011qc\u0007\u000f#\n\u0005]J#A\u0002+va2,'\u0007\u0005\u0002:u1\u0001A!B\u001e\u0001\u0005\u0004i$!A&\u0004\u0001E\u0011a(\u0011\t\u0003]}J!\u0001Q\u0015\u0003\u000f9{G\u000f[5oOB\u0011aFQ\u0005\u0003\u0007&\u00121!\u00118z!\tIT\tB\u0003G\u0001\t\u0007QHA\u0001W\u0003\u0015aWM^3m+\u0005I\u0005C\u0001\u0018K\u0013\tY\u0015FA\u0002J]R\f\u0011\u0002\\3wK2|F%Z9\u0015\u00059\u000b\u0006C\u0001\u0018P\u0013\t\u0001\u0016F\u0001\u0003V]&$\bb\u0002*\u0003\u0003\u0003\u0005\r!S\u0001\u0004q\u0012\n\u0014A\u00027fm\u0016d\u0007%\u0001\u0002diV\ta\u000b\u0005\u0003X1b\"U\"A\u0013\n\u0005e+#a\u0002+sS\u0016l\u0015\r]\u0001\u0007GR|F%Z9\u0015\u00059c\u0006b\u0002*\u0006\u0003\u0003\u0005\rAV\u0001\u0004GR\u0004\u0013\u0001C7vgRLe.\u001b;\u0011\u00059\u0002\u0017BA1*\u0005\u001d\u0011un\u001c7fC:\fa\u0001P5oSRtD\u0003\u00023fM\u001e\u0004Ba\u0016\u00019\t\")q\t\u0003a\u0001\u0013\")A\u000b\u0003a\u0001-\"9a\f\u0003I\u0001\u0002\u0004y\u0016!B:uC\u000e\\W#\u00016\u0011\u00079ZW.\u0003\u0002mS\t)\u0011I\u001d:bsB\u0019af\u001b8\u0011\u0005]{\u0017B\u00019&\u0005%\u0011\u0015m]5d\u001d>$W-\u0001\u0004ti\u0006\u001c7\u000eI\u0001\tgR\f7m\u001b9pgV\tA\u000fE\u0002/W&\u000b\u0011b\u001d;bG.\u0004xn\u001d\u0011\u0002\u000b\u0011,\u0007\u000f\u001e5\u0002\u0013\u0011,\u0007\u000f\u001e5`I\u0015\fHC\u0001(z\u0011\u001d\u0011f\"!AA\u0002%\u000ba\u0001Z3qi\"\u0004\u0013aB:vE&$XM]\u000b\u0002c\u0005Y1/\u001e2ji\u0016\u0014x\fJ3r)\tqu\u0010C\u0004S#\u0005\u0005\t\u0019A\u0019\u0002\u0011M,(-\u001b;fe\u0002\nqaY;se\u0016tG/\u0006\u0002\u0002\bA)q+!\u00039\t&\u0019\u00111B\u0013\u0003\r-3fj\u001c3f\u0003-\u0019WO\u001d:f]R|F%Z9\u0015\u00079\u000b\t\u0002\u0003\u0005S)\u0005\u0005\t\u0019AA\u0004\u0003!\u0019WO\u001d:f]R\u0004\u0013a\u00025bg:+\u0007\u0010^\u000b\u0002?\u0006!a.\u001a=u)\u0005)\u0014A\u0002:fC\u0012Lg\u000eF\u0002O\u0003CAq!a\t\u0019\u0001\u0004\t)#\u0001\u0002j]B)q+a\n9\t&\u0019\u0011\u0011F\u0013\u0003\u000b%su\u000eZ3\u0002\u0019\rDWmY6Tk\nLG/\u001a:\u0015\u00039\u000b!\"\u001b8ji&\fG.\u001b>f\u0003\u001d\tGM^1oG\u0016\f1B\\3x\u0013R,'/\u0019;peR9A-a\u000e\u0002<\u0005}\u0002BBA\u001d9\u0001\u0007\u0011*\u0001\u0003`Y\u00164\bBBA\u001f9\u0001\u0007a+A\u0002`GRDa!!\u0011\u001d\u0001\u0004y\u0016!C0nkN$\u0018J\\5u\u0003\u0015!W\u000f\u001d+p)\rq\u0015q\t\u0005\u0007\u0003\u0013j\u0002\u0019\u00013\u0002\u0005%$\u0018!C:vE\u0012Lg/\u001b3f)\t\ty\u0005\u0005\u00033\u0003#\n\u0014bAA*O\t\u00191+Z9\u0002\u0015A\u0014\u0018N\u001c;EK\n,x\rK\u0004 \u00033\ny&a\u0019\u0011\u00079\nY&C\u0002\u0002^%\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\t\t'A\u000euQ&\u001c\b%\\3uQ>$\u0007e^5mY\u0002\u0012W\r\t:f[>4X\rZ\u0011\u0003\u0003K\naA\r\u00182e9\u0002\u0014a\u0004+sS\u0016l\u0015\r]%uKJ\fGo\u001c:\u0011\u0005]\u000b3CA\u0011.)\t\tI'A\u000e%Y\u0016\u001c8/\u001b8ji\u0012:'/Z1uKJ$C-\u001a4bk2$HeM\u000b\u0007\u0003g\nI)a#\u0016\u0005\u0005U$fA0\u0002x-\u0012\u0011\u0011\u0010\t\u0005\u0003w\n))\u0004\u0002\u0002~)!\u0011qPAA\u0003%)hn\u00195fG.,GMC\u0002\u0002\u0004&\n!\"\u00198o_R\fG/[8o\u0013\u0011\t9)! \u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW\rB\u0003<G\t\u0007Q\bB\u0003GG\t\u0007Q\b")
public class TrieMapIterator<K, V>
implements Iterator<Tuple2<K, V>> {
    private int level;
    private TrieMap<K, V> ct;
    private final BasicNode[][] stack;
    private final int[] stackpos;
    private int depth;
    private Iterator<Tuple2<K, V>> subiter;
    private KVNode<K, V> current;

    public static <K, V> boolean $lessinit$greater$default$3() {
        return TrieMapIterator$.MODULE$.$lessinit$greater$default$3();
    }

    @Override
    public Iterator<Tuple2<K, V>> seq() {
        return Iterator.seq$(this);
    }

    @Override
    public boolean isEmpty() {
        return Iterator.isEmpty$(this);
    }

    @Override
    public boolean isTraversableAgain() {
        return Iterator.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return Iterator.hasDefiniteSize$(this);
    }

    @Override
    public Iterator<Tuple2<K, V>> take(int n) {
        return Iterator.take$(this, n);
    }

    @Override
    public Iterator<Tuple2<K, V>> drop(int n) {
        return Iterator.drop$(this, n);
    }

    @Override
    public Iterator<Tuple2<K, V>> slice(int from, int until) {
        return Iterator.slice$(this, from, until);
    }

    @Override
    public Iterator<Tuple2<K, V>> sliceIterator(int from, int until) {
        return Iterator.sliceIterator$(this, from, until);
    }

    @Override
    public <B> Iterator<B> map(Function1<Tuple2<K, V>, B> f) {
        return Iterator.map$(this, f);
    }

    @Override
    public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
        return Iterator.$plus$plus$(this, that);
    }

    @Override
    public <B> Iterator<B> flatMap(Function1<Tuple2<K, V>, GenTraversableOnce<B>> f) {
        return Iterator.flatMap$(this, f);
    }

    @Override
    public Iterator<Tuple2<K, V>> filter(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.filter$(this, p);
    }

    @Override
    public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Tuple2<K, V>, B, Object> p) {
        return Iterator.corresponds$(this, that, p);
    }

    @Override
    public Iterator<Tuple2<K, V>> withFilter(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.withFilter$(this, p);
    }

    @Override
    public Iterator<Tuple2<K, V>> filterNot(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.filterNot$(this, p);
    }

    @Override
    public <B> Iterator<B> collect(PartialFunction<Tuple2<K, V>, B> pf) {
        return Iterator.collect$(this, pf);
    }

    @Override
    public <B> Iterator<B> scanLeft(B z, Function2<B, Tuple2<K, V>, B> op) {
        return Iterator.scanLeft$(this, z, op);
    }

    @Override
    public <B> Iterator<B> scanRight(B z, Function2<Tuple2<K, V>, B, B> op) {
        return Iterator.scanRight$(this, z, op);
    }

    @Override
    public Iterator<Tuple2<K, V>> takeWhile(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.takeWhile$(this, p);
    }

    @Override
    public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> partition(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.partition$(this, p);
    }

    @Override
    public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> span(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.span$(this, p);
    }

    @Override
    public Iterator<Tuple2<K, V>> dropWhile(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.dropWhile$(this, p);
    }

    @Override
    public <B> Iterator<Tuple2<Tuple2<K, V>, B>> zip(Iterator<B> that) {
        return Iterator.zip$(this, that);
    }

    @Override
    public <A1> Iterator<A1> padTo(int len, A1 elem) {
        return Iterator.padTo$(this, len, elem);
    }

    @Override
    public Iterator<Tuple2<Tuple2<K, V>, Object>> zipWithIndex() {
        return Iterator.zipWithIndex$(this);
    }

    @Override
    public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
        return Iterator.zipAll$(this, that, thisElem, thatElem);
    }

    @Override
    public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
        Iterator.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.exists$(this, p);
    }

    @Override
    public boolean contains(Object elem) {
        return Iterator.contains$(this, elem);
    }

    @Override
    public Option<Tuple2<K, V>> find(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.find$(this, p);
    }

    @Override
    public int indexWhere(Function1<Tuple2<K, V>, Object> p) {
        return Iterator.indexWhere$(this, p);
    }

    @Override
    public int indexWhere(Function1<Tuple2<K, V>, Object> p, int from) {
        return Iterator.indexWhere$(this, p, from);
    }

    @Override
    public <B> int indexOf(B elem) {
        return Iterator.indexOf$(this, elem);
    }

    @Override
    public <B> int indexOf(B elem, int from) {
        return Iterator.indexOf$(this, elem, from);
    }

    @Override
    public BufferedIterator<Tuple2<K, V>> buffered() {
        return Iterator.buffered$(this);
    }

    @Override
    public <B> Iterator.GroupedIterator<B> grouped(int size) {
        return Iterator.grouped$(this, size);
    }

    @Override
    public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
        return Iterator.sliding$(this, size, step);
    }

    @Override
    public <B> int sliding$default$2() {
        return Iterator.sliding$default$2$(this);
    }

    @Override
    public int length() {
        return Iterator.length$(this);
    }

    @Override
    public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> duplicate() {
        return Iterator.duplicate$(this);
    }

    @Override
    public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
        return Iterator.patch$(this, from, patchElems, replaced);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        Iterator.copyToArray$(this, xs, start, len);
    }

    @Override
    public boolean sameElements(Iterator<?> that) {
        return Iterator.sameElements$(this, that);
    }

    @Override
    public Traversable<Tuple2<K, V>> toTraversable() {
        return Iterator.toTraversable$(this);
    }

    @Override
    public Iterator<Tuple2<K, V>> toIterator() {
        return Iterator.toIterator$(this);
    }

    @Override
    public Stream<Tuple2<K, V>> toStream() {
        return Iterator.toStream$(this);
    }

    @Override
    public String toString() {
        return Iterator.toString$(this);
    }

    @Override
    public List<Tuple2<K, V>> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public int size() {
        return TraversableOnce.size$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<Tuple2<K, V>, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<Tuple2<K, V>, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, Tuple2<K, V>, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<Tuple2<K, V>, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, Tuple2<K, V>, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<Tuple2<K, V>, B, B> op) {
        return (B)TraversableOnce.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, Tuple2<K, V>, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<Tuple2<K, V>, B, B> op) {
        return (B)TraversableOnce.reduceRight$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<K, V>, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<Tuple2<K, V>, B, B> op) {
        return TraversableOnce.reduceRightOption$(this, op);
    }

    @Override
    public <A1> A1 reduce(Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.reduce$(this, op);
    }

    @Override
    public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
        return TraversableOnce.reduceOption$(this, op);
    }

    @Override
    public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.fold$(this, z, op);
    }

    @Override
    public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<K, V>, B> seqop, Function2<B, B, B> combop) {
        return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <B> B sum(Numeric<B> num) {
        return (B)TraversableOnce.sum$(this, num);
    }

    @Override
    public <B> B product(Numeric<B> num) {
        return (B)TraversableOnce.product$(this, num);
    }

    @Override
    public Object min(Ordering cmp) {
        return TraversableOnce.min$(this, cmp);
    }

    @Override
    public Object max(Ordering cmp) {
        return TraversableOnce.max$(this, cmp);
    }

    @Override
    public Object maxBy(Function1 f, Ordering cmp) {
        return TraversableOnce.maxBy$(this, f, cmp);
    }

    @Override
    public Object minBy(Function1 f, Ordering cmp) {
        return TraversableOnce.minBy$(this, f, cmp);
    }

    @Override
    public <B> void copyToBuffer(Buffer<B> dest) {
        TraversableOnce.copyToBuffer$(this, dest);
    }

    @Override
    public <B> void copyToArray(Object xs, int start) {
        TraversableOnce.copyToArray$(this, xs, start);
    }

    @Override
    public <B> void copyToArray(Object xs) {
        TraversableOnce.copyToArray$(this, xs);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public List<Tuple2<K, V>> toList() {
        return TraversableOnce.toList$(this);
    }

    @Override
    public Iterable<Tuple2<K, V>> toIterable() {
        return TraversableOnce.toIterable$(this);
    }

    @Override
    public Seq<Tuple2<K, V>> toSeq() {
        return TraversableOnce.toSeq$(this);
    }

    @Override
    public IndexedSeq<Tuple2<K, V>> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public <B> Buffer<B> toBuffer() {
        return TraversableOnce.toBuffer$(this);
    }

    @Override
    public <B> Set<B> toSet() {
        return TraversableOnce.toSet$(this);
    }

    @Override
    public Vector<Tuple2<K, V>> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<K, V>, Col> cbf) {
        return (Col)TraversableOnce.to$(this, cbf);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<T, U>> ev) {
        return TraversableOnce.toMap$(this, ev);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return TraversableOnce.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return TraversableOnce.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return TraversableOnce.mkString$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return TraversableOnce.addString$(this, b, start, sep, end);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String sep) {
        return TraversableOnce.addString$(this, b, sep);
    }

    @Override
    public StringBuilder addString(StringBuilder b) {
        return TraversableOnce.addString$(this, b);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    public int level() {
        return this.level;
    }

    public void level_$eq(int x$1) {
        this.level = x$1;
    }

    private TrieMap<K, V> ct() {
        return this.ct;
    }

    private void ct_$eq(TrieMap<K, V> x$1) {
        this.ct = x$1;
    }

    private BasicNode[][] stack() {
        return this.stack;
    }

    private int[] stackpos() {
        return this.stackpos;
    }

    private int depth() {
        return this.depth;
    }

    private void depth_$eq(int x$1) {
        this.depth = x$1;
    }

    private Iterator<Tuple2<K, V>> subiter() {
        return this.subiter;
    }

    private void subiter_$eq(Iterator<Tuple2<K, V>> x$1) {
        this.subiter = x$1;
    }

    private KVNode<K, V> current() {
        return this.current;
    }

    private void current_$eq(KVNode<K, V> x$1) {
        this.current = x$1;
    }

    @Override
    public boolean hasNext() {
        return this.current() != null || this.subiter() != null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Tuple2<K, V> next() {
        if (this.hasNext()) {
            void var1_1;
            Tuple2<K, V> r;
            if (this.subiter() != null) {
                r = this.subiter().next();
                this.checkSubiter();
            } else {
                r = this.current().kvPair();
                this.advance();
            }
            return var1_1;
        }
        return (Tuple2)((Object)Iterator$.MODULE$.empty().next());
    }

    private void readin(INode<K, V> in) {
        MainNode<K, V> mainNode = in.gcasRead(this.ct());
        if (mainNode instanceof CNode) {
            CNode cNode = (CNode)mainNode;
            this.depth_$eq(this.depth() + 1);
            this.stack()[this.depth()] = cNode.array();
            this.stackpos()[this.depth()] = -1;
            this.advance();
            return;
        }
        if (mainNode instanceof TNode) {
            TNode tNode = (TNode)mainNode;
            this.current_$eq(tNode);
            return;
        }
        if (mainNode instanceof LNode) {
            LNode lNode = (LNode)mainNode;
            this.subiter_$eq(lNode.listmap().iterator());
            this.checkSubiter();
            return;
        }
        if (mainNode == null) {
            this.current_$eq(null);
            return;
        }
        throw new MatchError(mainNode);
    }

    private void checkSubiter() {
        if (!this.subiter().hasNext()) {
            this.subiter_$eq(null);
            this.advance();
        }
    }

    private void initialize() {
        Predef$.MODULE$.assert(this.ct().isReadOnly());
        TrieMap<K, V> qual$1 = this.ct();
        boolean x$1 = qual$1.RDCSS_READ_ROOT$default$1();
        INode<K, V> r = qual$1.RDCSS_READ_ROOT(x$1);
        this.readin(r);
    }

    public void advance() {
        if (this.depth() >= 0) {
            int npos = this.stackpos()[this.depth()] + 1;
            if (npos < this.stack()[this.depth()].length) {
                this.stackpos()[this.depth()] = npos;
                BasicNode basicNode = this.stack()[this.depth()][npos];
                if (basicNode instanceof SNode) {
                    SNode sNode = (SNode)basicNode;
                    this.current_$eq(sNode);
                    return;
                }
                if (basicNode instanceof INode) {
                    INode iNode = (INode)basicNode;
                    this.readin(iNode);
                    return;
                }
                throw new MatchError(basicNode);
            }
            this.depth_$eq(this.depth() - 1);
            this.advance();
            return;
        }
        this.current_$eq(null);
    }

    public TrieMapIterator<K, V> newIterator(int _lev, TrieMap<K, V> _ct, boolean _mustInit) {
        return new TrieMapIterator<K, V>(_lev, _ct, _mustInit);
    }

    public void dupTo(TrieMapIterator<K, V> it) {
        it.level_$eq(this.level());
        super.ct_$eq(this.ct());
        super.depth_$eq(this.depth());
        super.current_$eq(this.current());
        Array$.MODULE$.copy(this.stack(), 0, super.stack(), 0, 7);
        Array$.MODULE$.copy(this.stackpos(), 0, super.stackpos(), 0, 7);
        if (this.subiter() == null) {
            super.subiter_$eq(null);
            return;
        }
        List lst = this.subiter().toList();
        this.subiter_$eq(lst.iterator());
        super.subiter_$eq(lst.iterator());
    }

    public Seq<Iterator<Tuple2<K, V>>> subdivide() {
        if (this.subiter() != null) {
            TrieMapIterator<K, V> it = this.newIterator(this.level() + 1, this.ct(), false);
            super.depth_$eq(-1);
            super.subiter_$eq(this.subiter());
            super.current_$eq(null);
            this.subiter_$eq(null);
            this.advance();
            this.level_$eq(this.level() + 1);
            return new $colon$colon<Nothing$>((Nothing$)((Object)it), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$));
        }
        if (this.depth() == -1) {
            this.level_$eq(this.level() + 1);
            return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
        }
        for (int d = 0; d <= this.depth(); ++d) {
            int rem = this.stack()[d].length - 1 - this.stackpos()[d];
            if (rem <= 0) continue;
            Tuple2<Object[], Object[]> tuple2 = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.stack()[d])).drop(this.stackpos()[d] + 1))).splitAt(rem / 2);
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            BasicNode[] basicNodeArray = (BasicNode[])tuple2._1();
            BasicNode[] basicNodeArray2 = (BasicNode[])tuple2._2();
            BasicNode[] arr1 = basicNodeArray;
            BasicNode[] arr2 = basicNodeArray2;
            this.stack()[d] = arr1;
            this.stackpos()[d] = -1;
            TrieMapIterator<K, V> it = this.newIterator(this.level() + 1, this.ct(), false);
            super.stack()[0] = arr2;
            super.stackpos()[0] = -1;
            super.depth_$eq(0);
            it.advance();
            this.level_$eq(this.level() + 1);
            return new $colon$colon<Nothing$>((Nothing$)((Object)this), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)it), Nil$.MODULE$));
        }
        this.level_$eq(this.level() + 1);
        return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
    }

    public void printDebug() {
        Predef$.MODULE$.println("ctrie iterator");
        Predef$.MODULE$.println(new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(this.stackpos())).mkString(","));
        Predef$.MODULE$.println(new java.lang.StringBuilder(7).append("depth: ").append(this.depth()).toString());
        Predef$.MODULE$.println(new java.lang.StringBuilder(7).append("curr.: ").append(this.current()).toString());
        Predef$.MODULE$.println(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.stack())).mkString("\n"));
    }

    public TrieMapIterator(int level, TrieMap<K, V> ct, boolean mustInit) {
        this.level = level;
        this.ct = ct;
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Iterator.$init$(this);
        this.stack = new BasicNode[7][];
        this.stackpos = new int[7];
        this.depth = -1;
        this.subiter = null;
        this.current = null;
        if (mustInit) {
            this.initialize();
        }
    }
}

