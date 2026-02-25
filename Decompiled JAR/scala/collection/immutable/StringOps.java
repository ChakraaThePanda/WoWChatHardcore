/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.Locale;
import java.util.regex.PatternSyntaxException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeqLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.StringLike;
import scala.collection.immutable.StringOps$;
import scala.collection.immutable.Vector;
import scala.collection.immutable.WrappedString;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSeq;
import scala.math.Numeric;
import scala.math.Ordered;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;
import scala.util.matching.Regex;

@ScalaSignature(bytes="\u0006\u0001\u0005ub\u0001B\u000e\u001d\u0005\rB\u0001b\u000e\u0001\u0003\u0006\u0004%\t\u0005\u000f\u0005\ts\u0001\u0011\t\u0011)A\u0005Y!)!\b\u0001C\u0001w!1a\b\u0001Q\u0005R}Baa\u0011\u0001!\n#\"\u0005B\u0002$\u0001A\u0013Es\tC\u0003O\u0001\u0011\u0005s\nC\u0003Y\u0001\u0011\u0005\u0013\fC\u0003_\u0001\u0011\u0005s\fC\u0003a\u0001\u0011\u0005\u0013\rC\u0003c\u0001\u0011\u0005q\bC\u0004d\u0001\u0005\u0005I\u0011\t3\t\u000f\u0015\u0004\u0011\u0011!C!M\u001e9q\u000eHA\u0001\u0012\u0003\u0001haB\u000e\u001d\u0003\u0003E\t!\u001d\u0005\u0006u=!\t!\u001e\u0005\u0006m>!)a\u001e\u0005\u0006u>!)a\u001f\u0005\u0007\u007f>!)!!\u0001\t\u000f\u0005\u0015q\u0002\"\u0002\u0002\b!9\u0011qB\b\u0005\u0006\u0005E\u0001bBA\u000e\u001f\u0011\u0015\u0011Q\u0004\u0005\b\u0003CyAQAA\u0012\u0011\u001d\t9c\u0004C\u0003\u0003SA\u0011\"!\f\u0010\u0003\u0003%)!a\f\t\u0013\u0005Mr\"!A\u0005\u0006\u0005U\"!C*ue&twm\u00149t\u0015\tib$A\u0005j[6,H/\u00192mK*\u0011q\u0004I\u0001\u000bG>dG.Z2uS>t'\"A\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001\u0001\n\u0015\u0011\u0005\u00152S\"\u0001\u0011\n\u0005\u001d\u0002#AB!osZ\u000bG\u000eE\u0002*U1j\u0011\u0001H\u0005\u0003Wq\u0011!b\u0015;sS:<G*[6f!\tiCG\u0004\u0002/eA\u0011q\u0006I\u0007\u0002a)\u0011\u0011GI\u0001\u0007yI|w\u000e\u001e \n\u0005M\u0002\u0013A\u0002)sK\u0012,g-\u0003\u00026m\t11\u000b\u001e:j]\u001eT!a\r\u0011\u0002\tI,\u0007O]\u000b\u0002Y\u0005)!/\u001a9sA\u00051A(\u001b8jiz\"\"\u0001P\u001f\u0011\u0005%\u0002\u0001\"B\u001c\u0004\u0001\u0004a\u0013A\u0004;iSN\u001cu\u000e\u001c7fGRLwN\\\u000b\u0002\u0001B\u0011\u0011&Q\u0005\u0003\u0005r\u0011Qb\u0016:baB,Gm\u0015;sS:<\u0017\u0001\u0004;p\u0007>dG.Z2uS>tGC\u0001!F\u0011\u00159T\u00011\u0001-\u0003)qWm\u001e\"vS2$WM]\u000b\u0002\u0011B\u0011\u0011\nT\u0007\u0002\u0015*\u00111JH\u0001\b[V$\u0018M\u00197f\u0013\ti%JA\u0007TiJLgn\u001a\"vS2$WM]\u0001\u0006CB\u0004H.\u001f\u000b\u0003!N\u0003\"!J)\n\u0005I\u0003#\u0001B\"iCJDQ\u0001V\u0004A\u0002U\u000bQ!\u001b8eKb\u0004\"!\n,\n\u0005]\u0003#aA%oi\u0006)1\u000f\\5dKR\u0019AF\u0017/\t\u000bmC\u0001\u0019A+\u0002\t\u0019\u0014x.\u001c\u0005\u0006;\"\u0001\r!V\u0001\u0006k:$\u0018\u000e\\\u0001\ti>\u001cFO]5oOR\tA&\u0001\u0004mK:<G\u000f[\u000b\u0002+\u0006\u00191/Z9\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012!V\u0001\u0007KF,\u0018\r\\:\u0015\u0005\u001dT\u0007CA\u0013i\u0013\tI\u0007EA\u0004C_>dW-\u00198\t\u000f-l\u0011\u0011!a\u0001Y\u0006\u0019\u0001\u0010J\u0019\u0011\u0005\u0015j\u0017B\u00018!\u0005\r\te._\u0001\n'R\u0014\u0018N\\4PaN\u0004\"!K\b\u0014\u0005=\u0011\bCA\u0013t\u0013\t!\bE\u0001\u0004B]f\u0014VM\u001a\u000b\u0002a\u0006AB\u000f[5t\u0007>dG.Z2uS>tG%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0005\u0001C\b\"B=\u0012\u0001\u0004a\u0014!\u0002\u0013uQ&\u001c\u0018A\u0006;p\u0007>dG.Z2uS>tG%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0005qtHC\u0001!~\u0011\u00159$\u00031\u0001-\u0011\u0015I(\u00031\u0001=\u0003QqWm\u001e\"vS2$WM\u001d\u0013fqR,gn]5p]R\u0019\u0001*a\u0001\t\u000be\u001c\u0002\u0019\u0001\u001f\u0002\u001f\u0005\u0004\b\u000f\\=%Kb$XM\\:j_:$B!!\u0003\u0002\u000eQ\u0019\u0001+a\u0003\t\u000bQ#\u0002\u0019A+\t\u000be$\u0002\u0019\u0001\u001f\u0002\u001fMd\u0017nY3%Kb$XM\\:j_:$B!a\u0005\u0002\u001aQ)A&!\u0006\u0002\u0018!)1,\u0006a\u0001+\")Q,\u0006a\u0001+\")\u00110\u0006a\u0001y\u0005\u0011Bo\\*ue&tw\rJ3yi\u0016t7/[8o)\ry\u0016q\u0004\u0005\u0006sZ\u0001\r\u0001P\u0001\u0011Y\u0016tw\r\u001e5%Kb$XM\\:j_:$2!VA\u0013\u0011\u0015Ix\u00031\u0001=\u00035\u0019X-\u001d\u0013fqR,gn]5p]R\u0019\u0001)a\u000b\t\u000beD\u0002\u0019\u0001\u001f\u0002%!\f7\u000f[\"pI\u0016$S\r\u001f;f]NLwN\u001c\u000b\u0004I\u0006E\u0002\"B=\u001a\u0001\u0004a\u0014\u0001E3rk\u0006d7\u000fJ3yi\u0016t7/[8o)\u0011\t9$a\u000f\u0015\u0007\u001d\fI\u0004C\u0004l5\u0005\u0005\t\u0019\u00017\t\u000beT\u0002\u0019\u0001\u001f")
public final class StringOps
implements StringLike<String> {
    private final String repr;

    public static boolean equals$extension(String string, Object object) {
        return StringOps$.MODULE$.equals$extension(string, object);
    }

    public static int hashCode$extension(String string) {
        return StringOps$.MODULE$.hashCode$extension(string);
    }

    public static WrappedString seq$extension(String string) {
        return StringOps$.MODULE$.seq$extension(string);
    }

    public static int length$extension(String string) {
        return StringOps$.MODULE$.length$extension(string);
    }

    public static String toString$extension(String string) {
        return StringOps$.MODULE$.toString$extension(string);
    }

    public static String slice$extension(String string, int n, int n2) {
        return StringOps$.MODULE$.slice$extension(string, n, n2);
    }

    public static char apply$extension(String string, int n) {
        return StringOps$.MODULE$.apply$extension(string, n);
    }

    public static StringBuilder newBuilder$extension(String string) {
        return StringOps$.MODULE$.newBuilder$extension(string);
    }

    public static WrappedString toCollection$extension(String string, String string2) {
        return StringOps$.MODULE$.toCollection$extension(string, string2);
    }

    public static WrappedString thisCollection$extension(String string) {
        return StringOps$.MODULE$.thisCollection$extension(string);
    }

    @Override
    public String mkString() {
        return StringLike.mkString$(this);
    }

    @Override
    public String $times(int n) {
        return StringLike.$times$(this, n);
    }

    @Override
    public int compare(String other) {
        return StringLike.compare$(this, other);
    }

    @Override
    public String stripLineEnd() {
        return StringLike.stripLineEnd$(this);
    }

    @Override
    public Iterator<String> linesWithSeparators() {
        return StringLike.linesWithSeparators$(this);
    }

    @Override
    public Iterator<String> lines() {
        return StringLike.lines$(this);
    }

    @Override
    public Iterator<String> linesIterator() {
        return StringLike.linesIterator$(this);
    }

    @Override
    public String capitalize() {
        return StringLike.capitalize$(this);
    }

    @Override
    public String stripPrefix(String prefix) {
        return StringLike.stripPrefix$(this, prefix);
    }

    @Override
    public String stripSuffix(String suffix) {
        return StringLike.stripSuffix$(this, suffix);
    }

    @Override
    public String replaceAllLiterally(String literal, String replacement) {
        return StringLike.replaceAllLiterally$(this, literal, replacement);
    }

    @Override
    public String stripMargin(char marginChar) {
        return StringLike.stripMargin$(this, marginChar);
    }

    @Override
    public String stripMargin() {
        return StringLike.stripMargin$(this);
    }

    @Override
    public String[] split(char separator) {
        return StringLike.split$((StringLike)this, separator);
    }

    @Override
    public String[] split(char[] separators) throws PatternSyntaxException {
        return StringLike.split$((StringLike)this, separators);
    }

    @Override
    public Regex r() {
        return StringLike.r$(this);
    }

    @Override
    public Regex r(Seq<String> groupNames) {
        return StringLike.r$(this, groupNames);
    }

    @Override
    public boolean toBoolean() {
        return StringLike.toBoolean$(this);
    }

    @Override
    public byte toByte() {
        return StringLike.toByte$(this);
    }

    @Override
    public short toShort() {
        return StringLike.toShort$(this);
    }

    @Override
    public int toInt() {
        return StringLike.toInt$(this);
    }

    @Override
    public long toLong() {
        return StringLike.toLong$(this);
    }

    @Override
    public float toFloat() {
        return StringLike.toFloat$(this);
    }

    @Override
    public double toDouble() {
        return StringLike.toDouble$(this);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return StringLike.toArray$(this, evidence$1);
    }

    @Override
    public String format(Seq<Object> args2) {
        return StringLike.format$(this, args2);
    }

    @Override
    public String formatLocal(Locale l, Seq<Object> args2) {
        return StringLike.formatLocal$(this, l, args2);
    }

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
        return TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
        return this.iterator().reduceRight(op);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
        return IterableLike.zip$(this, that, bf);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
        return IterableLike.head$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
        return TraversableLike.tail$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
        return TraversableLike.last$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
        return TraversableLike.init$(this);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
        return SeqLike.endsWith$(this, that);
    }

    @Override
    public boolean isEmpty() {
        return IndexedSeqOptimized.isEmpty$(this);
    }

    @Override
    public <U> void foreach(Function1<Object, U> f) {
        IndexedSeqOptimized.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<Object, Object> p) {
        return IndexedSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Object, Object> p) {
        return IndexedSeqOptimized.exists$(this, p);
    }

    @Override
    public Option<Object> find(Function1<Object, Object> p) {
        return IndexedSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, Object, B> op) {
        return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<Object, B, B> op) {
        return (B)IndexedSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, Object, B> op) {
        return (B)IndexedSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<Object, B, B> op) {
        return (B)IndexedSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<String, Tuple2<A1, B>, That> bf) {
        return (That)IndexedSeqOptimized.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<String, Tuple2<A1, Object>, That> bf) {
        return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
    }

    @Override
    public Object head() {
        return IndexedSeqOptimized.head$(this);
    }

    @Override
    public Object tail() {
        return IndexedSeqOptimized.tail$(this);
    }

    @Override
    public Object last() {
        return IndexedSeqOptimized.last$(this);
    }

    @Override
    public Object init() {
        return IndexedSeqOptimized.init$(this);
    }

    @Override
    public Object take(int n) {
        return IndexedSeqOptimized.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return IndexedSeqOptimized.drop$(this, n);
    }

    @Override
    public Object takeRight(int n) {
        return IndexedSeqOptimized.takeRight$(this, n);
    }

    @Override
    public Object dropRight(int n) {
        return IndexedSeqOptimized.dropRight$(this, n);
    }

    @Override
    public Tuple2<String, String> splitAt(int n) {
        return IndexedSeqOptimized.splitAt$(this, n);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return IndexedSeqOptimized.takeWhile$(this, p);
    }

    @Override
    public Object dropWhile(Function1 p) {
        return IndexedSeqOptimized.dropWhile$(this, p);
    }

    @Override
    public Tuple2<String, String> span(Function1<Object, Object> p) {
        return IndexedSeqOptimized.span$(this, p);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IndexedSeqOptimized.sameElements$(this, that);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IndexedSeqOptimized.copyToArray$(this, xs, start, len);
    }

    @Override
    public int lengthCompare(int len) {
        return IndexedSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public int segmentLength(Function1<Object, Object> p, int from) {
        return IndexedSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<Object, Object> p, int from) {
        return IndexedSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<Object, Object> p, int end) {
        return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Object reverse() {
        return IndexedSeqOptimized.reverse$(this);
    }

    @Override
    public Iterator<Object> reverseIterator() {
        return IndexedSeqOptimized.reverseIterator$(this);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return IndexedSeqOptimized.startsWith$(this, that, offset);
    }

    @Override
    public <B> boolean endsWith(GenSeq<B> that) {
        return IndexedSeqOptimized.endsWith$(this, that);
    }

    @Override
    public List<Object> toList() {
        return IndexedSeqOptimized.toList$(this);
    }

    @Override
    public Iterator<Object> iterator() {
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
    public Combiner<Object, ParSeq<Object>> parCombiner() {
        return SeqLike.parCombiner$(this);
    }

    @Override
    public int size() {
        return SeqLike.size$(this);
    }

    @Override
    public Iterator<String> permutations() {
        return SeqLike.permutations$(this);
    }

    @Override
    public Iterator<String> combinations(int n) {
        return SeqLike.combinations$(this, n);
    }

    @Override
    public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<String, B, That> bf) {
        return (That)SeqLike.reverseMap$(this, f, bf);
    }

    @Override
    public <B> int indexOfSlice(GenSeq<B> that) {
        return SeqLike.indexOfSlice$(this, that);
    }

    @Override
    public <B> int indexOfSlice(GenSeq<B> that, int from) {
        return SeqLike.indexOfSlice$(this, that, from);
    }

    @Override
    public <B> int lastIndexOfSlice(GenSeq<B> that) {
        return SeqLike.lastIndexOfSlice$(this, that);
    }

    @Override
    public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
        return SeqLike.lastIndexOfSlice$(this, that, end);
    }

    @Override
    public <B> boolean containsSlice(GenSeq<B> that) {
        return SeqLike.containsSlice$(this, that);
    }

    @Override
    public <A1> boolean contains(A1 elem) {
        return SeqLike.contains$(this, elem);
    }

    @Override
    public <B, That> That union(GenSeq<B> that, CanBuildFrom<String, B, That> bf) {
        return (That)SeqLike.union$(this, that, bf);
    }

    @Override
    public Object diff(GenSeq that) {
        return SeqLike.diff$(this, that);
    }

    @Override
    public Object intersect(GenSeq that) {
        return SeqLike.intersect$(this, that);
    }

    @Override
    public Object distinct() {
        return SeqLike.distinct$(this);
    }

    @Override
    public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<String, B, That> bf) {
        return (That)SeqLike.patch$(this, from, patch, replaced, bf);
    }

    @Override
    public <B, That> That updated(int index, B elem, CanBuildFrom<String, B, That> bf) {
        return (That)SeqLike.updated$(this, index, elem, bf);
    }

    @Override
    public <B, That> That $plus$colon(B elem, CanBuildFrom<String, B, That> bf) {
        return (That)SeqLike.$plus$colon$(this, elem, bf);
    }

    @Override
    public <B, That> That $colon$plus(B elem, CanBuildFrom<String, B, That> bf) {
        return (That)SeqLike.$colon$plus$(this, elem, bf);
    }

    @Override
    public <B, That> That padTo(int len, B elem, CanBuildFrom<String, B, That> bf) {
        return (That)SeqLike.padTo$(this, len, elem, bf);
    }

    @Override
    public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
        return SeqLike.corresponds$(this, that, p);
    }

    @Override
    public Object sortWith(Function2 lt) {
        return SeqLike.sortWith$(this, lt);
    }

    @Override
    public Object sortBy(Function1 f, Ordering ord) {
        return SeqLike.sortBy$(this, f, ord);
    }

    @Override
    public Object sorted(Ordering ord) {
        return SeqLike.sorted$(this, ord);
    }

    @Override
    public Seq<Object> toSeq() {
        return SeqLike.toSeq$(this);
    }

    @Override
    public Range indices() {
        return SeqLike.indices$(this);
    }

    @Override
    public SeqView<Object, String> view() {
        return SeqLike.view$(this);
    }

    @Override
    public SeqView<Object, String> view(int from, int until) {
        return SeqLike.view$(this, from, until);
    }

    @Override
    public boolean isDefinedAt(int idx) {
        return GenSeqLike.isDefinedAt$(this, idx);
    }

    @Override
    public int prefixLength(Function1<Object, Object> p) {
        return GenSeqLike.prefixLength$(this, p);
    }

    @Override
    public int indexWhere(Function1<Object, Object> p) {
        return GenSeqLike.indexWhere$(this, p);
    }

    @Override
    public <B> int indexOf(B elem) {
        return GenSeqLike.indexOf$(this, elem);
    }

    @Override
    public <B> int indexOf(B elem, int from) {
        return GenSeqLike.indexOf$(this, elem, from);
    }

    @Override
    public <B> int lastIndexOf(B elem) {
        return GenSeqLike.lastIndexOf$(this, elem);
    }

    @Override
    public <B> int lastIndexOf(B elem, int end) {
        return GenSeqLike.lastIndexOf$(this, elem, end);
    }

    @Override
    public int lastIndexWhere(Function1<Object, Object> p) {
        return GenSeqLike.lastIndexWhere$(this, p);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that) {
        return GenSeqLike.startsWith$(this, that);
    }

    @Override
    public Iterable<Object> toIterable() {
        return IterableLike.toIterable$(this);
    }

    @Override
    public Iterator<Object> toIterator() {
        return IterableLike.toIterator$(this);
    }

    @Override
    public Iterator<String> grouped(int size) {
        return IterableLike.grouped$(this, size);
    }

    @Override
    public Iterator<String> sliding(int size) {
        return IterableLike.sliding$(this, size);
    }

    @Override
    public Iterator<String> sliding(int size, int step) {
        return IterableLike.sliding$(this, size, step);
    }

    @Override
    public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<String, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public Stream<Object> toStream() {
        return IterableLike.toStream$(this);
    }

    @Override
    public boolean canEqual(Object that) {
        return IterableLike.canEqual$(this, that);
    }

    @Override
    public final boolean isTraversableAgain() {
        return TraversableLike.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return TraversableLike.hasDefiniteSize$(this);
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That map(Function1<Object, B> f, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.map$(this, f, bf);
    }

    @Override
    public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    @Override
    public Object filterImpl(Function1 p, boolean isFlipped) {
        return TraversableLike.filterImpl$(this, p, isFlipped);
    }

    @Override
    public Object filter(Function1 p) {
        return TraversableLike.filter$(this, p);
    }

    @Override
    public Object filterNot(Function1 p) {
        return TraversableLike.filterNot$(this, p);
    }

    @Override
    public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public Tuple2<String, String> partition(Function1<Object, Object> p) {
        return TraversableLike.partition$(this, p);
    }

    @Override
    public <K> Map<K, String> groupBy(Function1<Object, K> f) {
        return TraversableLike.groupBy$(this, f);
    }

    @Override
    public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<String, B, That> cbf) {
        return (That)TraversableLike.scan$(this, z, op, cbf);
    }

    @Override
    public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<String, B, That> bf) {
        return (That)TraversableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public Option<Object> headOption() {
        return TraversableLike.headOption$(this);
    }

    @Override
    public Option<Object> lastOption() {
        return TraversableLike.lastOption$(this);
    }

    @Override
    public Object sliceWithKnownDelta(int from, int until, int delta) {
        return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
    }

    @Override
    public Object sliceWithKnownBound(int from, int until) {
        return TraversableLike.sliceWithKnownBound$(this, from, until);
    }

    @Override
    public Iterator<String> tails() {
        return TraversableLike.tails$(this);
    }

    @Override
    public Iterator<String> inits() {
        return TraversableLike.inits$(this);
    }

    @Override
    public Traversable<Object> toTraversable() {
        return TraversableLike.toTraversable$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
        return (Col)TraversableLike.to$(this, cbf);
    }

    @Override
    public String stringPrefix() {
        return TraversableLike.stringPrefix$(this);
    }

    @Override
    public FilterMonadic<Object, String> withFilter(Function1<Object, Object> p) {
        return TraversableLike.withFilter$(this, p);
    }

    @Override
    public Parallel par() {
        return Parallelizable.par$(this);
    }

    @Override
    public List<Object> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<Object, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, Object, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
    public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
    public IndexedSeq<Object> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public <B> Set<B> toSet() {
        return TraversableOnce.toSet$(this);
    }

    @Override
    public Vector<Object> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
    public String repr() {
        return this.repr;
    }

    public WrappedString thisCollection() {
        return StringOps$.MODULE$.thisCollection$extension(this.repr());
    }

    public WrappedString toCollection(String repr) {
        return StringOps$.MODULE$.toCollection$extension(this.repr(), repr);
    }

    public StringBuilder newBuilder() {
        return StringOps$.MODULE$.newBuilder$extension(this.repr());
    }

    @Override
    public char apply(int index) {
        return StringOps$.MODULE$.apply$extension(this.repr(), index);
    }

    @Override
    public String slice(int from, int until) {
        return StringOps$.MODULE$.slice$extension(this.repr(), from, until);
    }

    @Override
    public String toString() {
        return StringOps$.MODULE$.toString$extension(this.repr());
    }

    @Override
    public int length() {
        return StringOps$.MODULE$.length$extension(this.repr());
    }

    public WrappedString seq() {
        return StringOps$.MODULE$.seq$extension(this.repr());
    }

    @Override
    public int hashCode() {
        return StringOps$.MODULE$.hashCode$extension(this.repr());
    }

    @Override
    public boolean equals(Object x$1) {
        return StringOps$.MODULE$.equals$extension(this.repr(), x$1);
    }

    public StringOps(String repr) {
        this.repr = repr;
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        TraversableLike.$init$(this);
        IterableLike.$init$(this);
        GenSeqLike.$init$(this);
        SeqLike.$init$(this);
        IndexedSeqLike.$init$(this);
        IndexedSeqOptimized.$init$(this);
        Ordered.$init$(this);
        StringLike.$init$(this);
    }
}

