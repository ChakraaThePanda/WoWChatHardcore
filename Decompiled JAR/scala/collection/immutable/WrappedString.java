/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.Locale;
import java.util.regex.PatternSyntaxException;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Predef$;
import scala.Tuple2;
import scala.collection.AbstractSeq;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.List;
import scala.collection.immutable.StringLike;
import scala.collection.immutable.Traversable;
import scala.collection.immutable.WrappedString$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Ordered;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.util.matching.Regex;

@ScalaSignature(bytes="\u0006\u0001\u00154A\u0001E\t\u00031!A\u0011\u0006\u0001BC\u0002\u0013\u0005!\u0006\u0003\u00057\u0001\t\u0005\t\u0015!\u0003,\u0011\u00159\u0004\u0001\"\u00019\u0011\u0019Q\u0004\u0001)C)w!1A\b\u0001Q\u0005RuBa\u0001\u0011\u0001!\n#\n\u0005\"\u0002%\u0001\t\u0003J\u0005\"B)\u0001\t\u0003\u0012\u0006\"B*\u0001\t\u0003\"v!B+\u0012\u0011\u00031f!\u0002\t\u0012\u0011\u00039\u0006\"B\u001c\f\t\u0003Y\u0006b\u0002/\f\u0005\u0004%\u0019!\u0018\u0005\u0007I.\u0001\u000b\u0011\u00020\t\u000b\u0001[A\u0011A!\u0003\u001b]\u0013\u0018\r\u001d9fIN#(/\u001b8h\u0015\t\u00112#A\u0005j[6,H/\u00192mK*\u0011A#F\u0001\u000bG>dG.Z2uS>t'\"\u0001\f\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M!\u0001!G\u0011&!\rQ2$H\u0007\u0002'%\u0011Ad\u0005\u0002\f\u0003\n\u001cHO]1diN+\u0017\u000f\u0005\u0002\u001f?5\tQ#\u0003\u0002!+\t!1\t[1s!\r\u00113%H\u0007\u0002#%\u0011A%\u0005\u0002\u000b\u0013:$W\r_3e'\u0016\f\bc\u0001\u0012'Q%\u0011q%\u0005\u0002\u000b'R\u0014\u0018N\\4MS.,\u0007C\u0001\u0012\u0001\u0003\u0011\u0019X\r\u001c4\u0016\u0003-\u0002\"\u0001L\u001a\u000f\u00055\n\u0004C\u0001\u0018\u0016\u001b\u0005y#B\u0001\u0019\u0018\u0003\u0019a$o\\8u}%\u0011!'F\u0001\u0007!J,G-\u001a4\n\u0005Q*$AB*ue&twM\u0003\u00023+\u0005)1/\u001a7gA\u00051A(\u001b8jiz\"\"\u0001K\u001d\t\u000b%\u001a\u0001\u0019A\u0016\u0002\u001dQD\u0017n]\"pY2,7\r^5p]V\t\u0001&\u0001\u0007u_\u000e{G\u000e\\3di&|g\u000e\u0006\u0002)}!)q(\u0002a\u0001Q\u0005!!/\u001a9s\u0003)qWm\u001e\"vS2$WM]\u000b\u0002\u0005B!1IR\u000f)\u001b\u0005!%BA#\u0014\u0003\u001diW\u000f^1cY\u0016L!a\u0012#\u0003\u000f\t+\u0018\u000e\u001c3fe\u0006)1\u000f\\5dKR\u0019\u0001FS(\t\u000b-;\u0001\u0019\u0001'\u0002\t\u0019\u0014x.\u001c\t\u0003=5K!AT\u000b\u0003\u0007%sG\u000fC\u0003Q\u000f\u0001\u0007A*A\u0003v]RLG.\u0001\u0004mK:<G\u000f[\u000b\u0002\u0019\u0006AAo\\*ue&tw\rF\u0001,\u000359&/\u00199qK\u0012\u001cFO]5oOB\u0011!eC\n\u0003\u0017a\u0003\"AH-\n\u0005i+\"AB!osJ+g\rF\u0001W\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0005q\u0006#B0cQuAS\"\u00011\u000b\u0005\u0005\u001c\u0012aB4f]\u0016\u0014\u0018nY\u0005\u0003G\u0002\u0014AbQ1o\u0005VLG\u000e\u001a$s_6\fQbY1o\u0005VLG\u000e\u001a$s_6\u0004\u0003")
public final class WrappedString
extends AbstractSeq<Object>
implements scala.collection.immutable.IndexedSeq<Object>,
StringLike<WrappedString> {
    private final String self;

    public static CanBuildFrom<WrappedString, Object, WrappedString> canBuildFrom() {
        return WrappedString$.MODULE$.canBuildFrom();
    }

    @Override
    public char apply(int n) {
        return StringLike.apply$(this, n);
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
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<WrappedString, Tuple2<A1, B>, That> bf) {
        return (That)IndexedSeqOptimized.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<WrappedString, Tuple2<A1, Object>, That> bf) {
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
    public Tuple2<WrappedString, WrappedString> splitAt(int n) {
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
    public Tuple2<WrappedString, WrappedString> span(Function1<Object, Object> p) {
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
    public GenericCompanion<scala.collection.immutable.IndexedSeq> companion() {
        return scala.collection.immutable.IndexedSeq.companion$(this);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
        return scala.collection.immutable.IndexedSeq.toIndexedSeq$(this);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<Object> seq() {
        return scala.collection.immutable.IndexedSeq.seq$(this);
    }

    @Override
    public int hashCode() {
        return IndexedSeqLike.hashCode$(this);
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
    public scala.collection.immutable.Seq<Object> toSeq() {
        return scala.collection.immutable.Seq.toSeq$(this);
    }

    @Override
    public Combiner<Object, ParSeq<Object>> parCombiner() {
        return scala.collection.immutable.Seq.parCombiner$(this);
    }

    public String self() {
        return this.self;
    }

    @Override
    public WrappedString thisCollection() {
        return this;
    }

    public WrappedString toCollection(WrappedString repr) {
        return repr;
    }

    @Override
    public Builder<Object, WrappedString> newBuilder() {
        return WrappedString$.MODULE$.newBuilder();
    }

    @Override
    public WrappedString slice(int from, int until) {
        int start;
        int n = start = from < 0 ? 0 : from;
        if (until <= start || start >= ((WrappedString)this.repr()).length()) {
            return new WrappedString("");
        }
        int end = until > this.length() ? this.length() : until;
        return new WrappedString(Predef$.MODULE$.unwrapString((WrappedString)this.repr()).substring(start, end));
    }

    @Override
    public int length() {
        return this.self().length();
    }

    @Override
    public String toString() {
        return this.self();
    }

    public WrappedString(String self) {
        this.self = self;
        Traversable.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Seq.$init$(this);
        IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        scala.collection.immutable.IndexedSeq.$init$(this);
        IndexedSeqOptimized.$init$(this);
        Ordered.$init$(this);
        StringLike.$init$(this);
    }
}

