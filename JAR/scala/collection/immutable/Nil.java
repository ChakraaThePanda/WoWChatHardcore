/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.Parallel;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.LinearSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Seq;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001q;Q\u0001D\u0007\t\u0002R1QAF\u0007\t\u0002^AQ!J\u0001\u0005\u0002\u0019BQaJ\u0001\u0005B!BQ\u0001L\u0001\u0005B5BQAL\u0001\u0005B=BQ\u0001M\u0001\u0005BEBqaN\u0001\u0002\u0002\u0013\u0005\u0003\bC\u0004B\u0003\u0005\u0005I\u0011\u0001\"\t\u000f\u0019\u000b\u0011\u0011!C\u0001\u000f\"9!*AA\u0001\n\u0003Z\u0005b\u0002)\u0002\u0003\u0003%I!U\u0001\u0004\u001d&d'B\u0001\b\u0010\u0003%IW.\\;uC\ndWM\u0003\u0002\u0011#\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003I\tQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002\u0016\u00035\tQBA\u0002OS2\u001cB!\u0001\r EA\u0019Q#G\u000e\n\u0005ii!\u0001\u0002'jgR\u0004\"\u0001H\u000f\u000e\u0003EI!AH\t\u0003\u000f9{G\u000f[5oOB\u0011A\u0004I\u0005\u0003CE\u0011q\u0001\u0015:pIV\u001cG\u000f\u0005\u0002\u001dG%\u0011A%\u0005\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003Q\tq![:F[B$\u00180F\u0001*!\ta\"&\u0003\u0002,#\t9!i\\8mK\u0006t\u0017\u0001\u00025fC\u0012,\u0012aG\u0001\u0005i\u0006LG.F\u0001\u0019\u0003\u0019)\u0017/^1mgR\u0011\u0011F\r\u0005\u0006g\u0019\u0001\r\u0001N\u0001\u0005i\"\fG\u000f\u0005\u0002\u001dk%\u0011a'\u0005\u0002\u0004\u0003:L\u0018!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001:!\tQt(D\u0001<\u0015\taT(\u0001\u0003mC:<'\"\u0001 \u0002\t)\fg/Y\u0005\u0003\u0001n\u0012aa\u0015;sS:<\u0017\u0001\u00049s_\u0012,8\r^!sSRLX#A\"\u0011\u0005q!\u0015BA#\u0012\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\t!\u0004\nC\u0004J\u0013\u0005\u0005\t\u0019A\"\u0002\u0007a$\u0013'A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\u0005a\u0005cA'Oi5\tq\"\u0003\u0002P\u001f\tA\u0011\n^3sCR|'/A\u0006sK\u0006$'+Z:pYZ,G#\u0001*\u0011\u0005i\u001a\u0016B\u0001+<\u0005\u0019y%M[3di\"\"\u0011AV-[!\tar+\u0003\u0002Y#\t\u00012+\u001a:jC24VM]:j_:,\u0016\nR\u0001\u0006m\u0006dW/\u001a\u0010\t\u001b'\u0004_?OFH\u000b!\"\u0001AV-[\u0001")
public final class Nil {
    public static Iterator<Object> productIterator() {
        return Nil$.MODULE$.productIterator();
    }

    public static Object productElement(int n) {
        return Nil$.MODULE$.productElement(n);
    }

    public static int productArity() {
        return Nil$.MODULE$.productArity();
    }

    public static String productPrefix() {
        return Nil$.MODULE$.productPrefix();
    }

    public static boolean equals(Object object) {
        return Nil$.MODULE$.equals(object);
    }

    public static List<Nothing$> tail() {
        return Nil$.MODULE$.tail();
    }

    public static Nothing$ head() {
        return Nil$.MODULE$.head();
    }

    public static boolean isEmpty() {
        return Nil$.MODULE$.isEmpty();
    }

    public static Stream<Nothing$> toStream() {
        return Nil$.MODULE$.toStream();
    }

    public static String stringPrefix() {
        return Nil$.MODULE$.stringPrefix();
    }

    public static <B> B foldRight(B b, Function2<Nothing$, B, B> function2) {
        return Nil$.MODULE$.foldRight(b, function2);
    }

    public static List<Nothing$> reverse() {
        return Nil$.MODULE$.reverse();
    }

    public static <U> void foreach(Function1<Nothing$, U> function1) {
        Nil$.MODULE$.foreach(function1);
    }

    public static Tuple2<List<Nothing$>, List<Nothing$>> span(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.span(function1);
    }

    public static List<Nothing$> dropWhile(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.dropWhile(function1);
    }

    public static List<Nothing$> takeWhile(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.takeWhile(function1);
    }

    public static <B, That> That flatMap(Function1<Nothing$, GenTraversableOnce<B>> function1, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.flatMap(function1, canBuildFrom);
    }

    public static <B, That> That collect(PartialFunction<Nothing$, B> partialFunction, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.collect(partialFunction, canBuildFrom);
    }

    public static <B, That> That map(Function1<Nothing$, B> function1, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.map(function1, canBuildFrom);
    }

    public static Tuple2<List<Nothing$>, List<Nothing$>> splitAt(int n) {
        return Nil$.MODULE$.splitAt(n);
    }

    public static List<Nothing$> takeRight(int n) {
        return Nil$.MODULE$.takeRight(n);
    }

    public static List<Nothing$> slice(int n, int n2) {
        return Nil$.MODULE$.slice(n, n2);
    }

    public static List<Nothing$> drop(int n) {
        return Nil$.MODULE$.drop(n);
    }

    public static List<Nothing$> take(int n) {
        return Nil$.MODULE$.take(n);
    }

    public static List<Nothing$> toList() {
        return Nil$.MODULE$.toList();
    }

    public static <B, That> That $plus$colon(B b, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.$plus$colon(b, canBuildFrom);
    }

    public static <B, That> That $plus$plus(GenTraversableOnce<B> genTraversableOnce, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.$plus$plus(genTraversableOnce, canBuildFrom);
    }

    public static <B> List<B> mapConserve(Function1<Nothing$, B> function1) {
        return Nil$.MODULE$.mapConserve(function1);
    }

    public static <B> List<B> reverse_$colon$colon$colon(List<B> list) {
        return Nil$.MODULE$.reverse_$colon$colon$colon(list);
    }

    public static <B> List<B> $colon$colon$colon(List<B> list) {
        return Nil$.MODULE$.$colon$colon$colon(list);
    }

    public static <B> List<B> $colon$colon(B b) {
        return Nil$.MODULE$.$colon$colon(b);
    }

    public static GenericCompanion<List> companion() {
        return Nil$.MODULE$.companion();
    }

    public static Iterator<List<Nothing$>> tails() {
        return Nil$.MODULE$.tails();
    }

    public static int lastIndexWhere(Function1<Nothing$, Object> function1, int n) {
        return Nil$.MODULE$.lastIndexWhere(function1, n);
    }

    public static int indexWhere(Function1<Nothing$, Object> function1, int n) {
        return Nil$.MODULE$.indexWhere(function1, n);
    }

    public static int segmentLength(Function1<Nothing$, Object> function1, int n) {
        return Nil$.MODULE$.segmentLength(function1, n);
    }

    public static boolean isDefinedAt(int n) {
        return Nil$.MODULE$.isDefinedAt(n);
    }

    public static int lengthCompare(int n) {
        return Nil$.MODULE$.lengthCompare(n);
    }

    public static <B> boolean sameElements(GenIterable<B> genIterable) {
        return Nil$.MODULE$.sameElements(genIterable);
    }

    public static LinearSeqOptimized dropRight(int n) {
        return Nil$.MODULE$.dropRight(n);
    }

    public static Object last() {
        return Nil$.MODULE$.last();
    }

    public static <B> B reduceRight(Function2<Nothing$, B, B> function2) {
        return Nil$.MODULE$.reduceRight(function2);
    }

    public static <B> B reduceLeft(Function2<B, Nothing$, B> function2) {
        return Nil$.MODULE$.reduceLeft(function2);
    }

    public static <B> B foldLeft(B b, Function2<B, Nothing$, B> function2) {
        return Nil$.MODULE$.foldLeft(b, function2);
    }

    public static Option<Nothing$> find(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.find(function1);
    }

    public static <A1> boolean contains(A1 A1) {
        return Nil$.MODULE$.contains(A1);
    }

    public static boolean exists(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.exists(function1);
    }

    public static boolean forall(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.forall(function1);
    }

    public static Object apply(int n) {
        return Nil$.MODULE$.apply(n);
    }

    public static int length() {
        return Nil$.MODULE$.length();
    }

    public static LinearSeq<Nothing$> seq() {
        return Nil$.MODULE$.seq();
    }

    public static <B> boolean corresponds(GenSeq<B> genSeq, Function2<Nothing$, B, Object> function2) {
        return Nil$.MODULE$.corresponds(genSeq, function2);
    }

    public static Iterator<Nothing$> iterator() {
        return Nil$.MODULE$.iterator();
    }

    public static int hashCode() {
        return Nil$.MODULE$.hashCode();
    }

    public static Seq<Nothing$> toSeq() {
        return Nil$.MODULE$.toSeq();
    }

    public static String toString() {
        return Nil$.MODULE$.toString();
    }

    public static SeqView<Nothing$, List<Nothing$>> view(int n, int n2) {
        return Nil$.MODULE$.view(n, n2);
    }

    public static SeqView<Nothing$, List<Nothing$>> view() {
        return Nil$.MODULE$.view();
    }

    public static Range indices() {
        return Nil$.MODULE$.indices();
    }

    public static Object sorted(Ordering ordering) {
        return Nil$.MODULE$.sorted(ordering);
    }

    public static Object sortBy(Function1 function1, Ordering ordering) {
        return Nil$.MODULE$.sortBy(function1, ordering);
    }

    public static Object sortWith(Function2 function2) {
        return Nil$.MODULE$.sortWith(function2);
    }

    public static <B, That> That padTo(int n, B b, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.padTo(n, b, canBuildFrom);
    }

    public static <B, That> That $colon$plus(B b, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.$colon$plus(b, canBuildFrom);
    }

    public static <B, That> That updated(int n, B b, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.updated(n, b, canBuildFrom);
    }

    public static <B, That> That patch(int n, GenSeq<B> genSeq, int n2, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.patch(n, genSeq, n2, canBuildFrom);
    }

    public static Object distinct() {
        return Nil$.MODULE$.distinct();
    }

    public static Object intersect(GenSeq genSeq) {
        return Nil$.MODULE$.intersect(genSeq);
    }

    public static Object diff(GenSeq genSeq) {
        return Nil$.MODULE$.diff(genSeq);
    }

    public static <B, That> That union(GenSeq<B> genSeq, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.union(genSeq, canBuildFrom);
    }

    public static <B> boolean containsSlice(GenSeq<B> genSeq) {
        return Nil$.MODULE$.containsSlice(genSeq);
    }

    public static <B> int lastIndexOfSlice(GenSeq<B> genSeq, int n) {
        return Nil$.MODULE$.lastIndexOfSlice(genSeq, n);
    }

    public static <B> int lastIndexOfSlice(GenSeq<B> genSeq) {
        return Nil$.MODULE$.lastIndexOfSlice(genSeq);
    }

    public static <B> int indexOfSlice(GenSeq<B> genSeq, int n) {
        return Nil$.MODULE$.indexOfSlice(genSeq, n);
    }

    public static <B> int indexOfSlice(GenSeq<B> genSeq) {
        return Nil$.MODULE$.indexOfSlice(genSeq);
    }

    public static <B> boolean endsWith(GenSeq<B> genSeq) {
        return Nil$.MODULE$.endsWith(genSeq);
    }

    public static <B> boolean startsWith(GenSeq<B> genSeq, int n) {
        return Nil$.MODULE$.startsWith(genSeq, n);
    }

    public static Iterator<Nothing$> reverseIterator() {
        return Nil$.MODULE$.reverseIterator();
    }

    public static <B, That> That reverseMap(Function1<Nothing$, B> function1, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.reverseMap(function1, canBuildFrom);
    }

    public static Iterator<List<Nothing$>> combinations(int n) {
        return Nil$.MODULE$.combinations(n);
    }

    public static Iterator<List<Nothing$>> permutations() {
        return Nil$.MODULE$.permutations();
    }

    public static int size() {
        return Nil$.MODULE$.size();
    }

    public static <B> boolean startsWith(GenSeq<B> genSeq) {
        return Nil$.MODULE$.startsWith(genSeq);
    }

    public static int lastIndexWhere(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.lastIndexWhere(function1);
    }

    public static <B> int lastIndexOf(B b, int n) {
        return Nil$.MODULE$.lastIndexOf(b, n);
    }

    public static <B> int lastIndexOf(B b) {
        return Nil$.MODULE$.lastIndexOf(b);
    }

    public static <B> int indexOf(B b, int n) {
        return Nil$.MODULE$.indexOf(b, n);
    }

    public static <B> int indexOf(B b) {
        return Nil$.MODULE$.indexOf(b);
    }

    public static int indexWhere(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.indexWhere(function1);
    }

    public static int prefixLength(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.prefixLength(function1);
    }

    public static <U> Function1<Object, Object> runWith(Function1<Nothing$, U> function1) {
        return Nil$.MODULE$.runWith(function1);
    }

    public static Object applyOrElse(Object object, Function1 function1) {
        return Nil$.MODULE$.applyOrElse(object, function1);
    }

    public static Function1<Object, Option<Nothing$>> lift() {
        return Nil$.MODULE$.lift();
    }

    public static <C> PartialFunction<Object, C> andThen(Function1<Nothing$, C> function1) {
        return Nil$.MODULE$.andThen(function1);
    }

    public static <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> partialFunction) {
        return Nil$.MODULE$.orElse(partialFunction);
    }

    public static <A> Function1<A, Nothing$> compose(Function1<A, Object> function1) {
        return Nil$.MODULE$.compose(function1);
    }

    public static boolean canEqual(Object object) {
        return Nil$.MODULE$.canEqual(object);
    }

    public static <A1, That> That zipWithIndex(CanBuildFrom<List<Nothing$>, Tuple2<A1, Object>, That> canBuildFrom) {
        return Nil$.MODULE$.zipWithIndex(canBuildFrom);
    }

    public static <B, A1, That> That zipAll(GenIterable<B> genIterable, A1 A1, B b, CanBuildFrom<List<Nothing$>, Tuple2<A1, B>, That> canBuildFrom) {
        return Nil$.MODULE$.zipAll(genIterable, A1, b, canBuildFrom);
    }

    public static <A1, B, That> That zip(GenIterable<B> genIterable, CanBuildFrom<List<Nothing$>, Tuple2<A1, B>, That> canBuildFrom) {
        return Nil$.MODULE$.zip(genIterable, canBuildFrom);
    }

    public static <B> void copyToArray(Object object, int n, int n2) {
        Nil$.MODULE$.copyToArray(object, n, n2);
    }

    public static Iterator<List<Nothing$>> sliding(int n, int n2) {
        return Nil$.MODULE$.sliding(n, n2);
    }

    public static Iterator<List<Nothing$>> sliding(int n) {
        return Nil$.MODULE$.sliding(n);
    }

    public static Iterator<List<Nothing$>> grouped(int n) {
        return Nil$.MODULE$.grouped(n);
    }

    public static Iterator<Nothing$> toIterator() {
        return Nil$.MODULE$.toIterator();
    }

    public static Iterable<Nothing$> toIterable() {
        return Nil$.MODULE$.toIterable();
    }

    public static GenTraversable transpose(Function1 function1) {
        return Nil$.MODULE$.transpose(function1);
    }

    public static GenTraversable flatten(Function1 function1) {
        return Nil$.MODULE$.flatten(function1);
    }

    public static <A1, A2, A3> Tuple3<List<A1>, List<A2>, List<A3>> unzip3(Function1<Nothing$, Tuple3<A1, A2, A3>> function1) {
        return Nil$.MODULE$.unzip3(function1);
    }

    public static <A1, A2> Tuple2<List<A1>, List<A2>> unzip(Function1<Nothing$, Tuple2<A1, A2>> function1) {
        return Nil$.MODULE$.unzip(function1);
    }

    public static <B> Builder<B, List<B>> genericBuilder() {
        return Nil$.MODULE$.genericBuilder();
    }

    public static FilterMonadic<Nothing$, List<Nothing$>> withFilter(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.withFilter(function1);
    }

    public static <Col> Col to(CanBuildFrom<Nothing$, Nothing$, Col> canBuildFrom) {
        return Nil$.MODULE$.to(canBuildFrom);
    }

    public static Traversable<Nothing$> toTraversable() {
        return Nil$.MODULE$.toTraversable();
    }

    public static Iterator<List<Nothing$>> inits() {
        return Nil$.MODULE$.inits();
    }

    public static Object init() {
        return Nil$.MODULE$.init();
    }

    public static Option<Nothing$> lastOption() {
        return Nil$.MODULE$.lastOption();
    }

    public static Option<Nothing$> headOption() {
        return Nil$.MODULE$.headOption();
    }

    public static <B, That> That scanRight(B b, Function2<Nothing$, B, B> function2, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.scanRight(b, function2, canBuildFrom);
    }

    public static <B, That> That scanLeft(B b, Function2<B, Nothing$, B> function2, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.scanLeft(b, function2, canBuildFrom);
    }

    public static <B, That> That scan(B b, Function2<B, B, B> function2, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.scan(b, function2, canBuildFrom);
    }

    public static <K> Map<K, List<Nothing$>> groupBy(Function1<Nothing$, K> function1) {
        return Nil$.MODULE$.groupBy(function1);
    }

    public static Tuple2<List<Nothing$>, List<Nothing$>> partition(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.partition(function1);
    }

    public static Object filterNot(Function1 function1) {
        return Nil$.MODULE$.filterNot(function1);
    }

    public static Object filter(Function1 function1) {
        return Nil$.MODULE$.filter(function1);
    }

    public static <B, That> That $plus$plus$colon(Traversable<B> traversable, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.$plus$plus$colon(traversable, canBuildFrom);
    }

    public static <B, That> That $plus$plus$colon(TraversableOnce<B> traversableOnce, CanBuildFrom<List<Nothing$>, B, That> canBuildFrom) {
        return Nil$.MODULE$.$plus$plus$colon(traversableOnce, canBuildFrom);
    }

    public static boolean hasDefiniteSize() {
        return Nil$.MODULE$.hasDefiniteSize();
    }

    public static boolean isTraversableAgain() {
        return Nil$.MODULE$.isTraversableAgain();
    }

    public static Object repr() {
        return Nil$.MODULE$.repr();
    }

    public static Parallel par() {
        return Nil$.MODULE$.par();
    }

    public static StringBuilder addString(StringBuilder stringBuilder) {
        return Nil$.MODULE$.addString(stringBuilder);
    }

    public static StringBuilder addString(StringBuilder stringBuilder, String string) {
        return Nil$.MODULE$.addString(stringBuilder, string);
    }

    public static StringBuilder addString(StringBuilder stringBuilder, String string, String string2, String string3) {
        return Nil$.MODULE$.addString(stringBuilder, string, string2, string3);
    }

    public static String mkString() {
        return Nil$.MODULE$.mkString();
    }

    public static String mkString(String string) {
        return Nil$.MODULE$.mkString(string);
    }

    public static String mkString(String string, String string2, String string3) {
        return Nil$.MODULE$.mkString(string, string2, string3);
    }

    public static <T, U> Map<T, U> toMap(Predef$.less.colon.less<Nothing$, Tuple2<T, U>> less2) {
        return Nil$.MODULE$.toMap(less2);
    }

    public static Vector<Nothing$> toVector() {
        return Nil$.MODULE$.toVector();
    }

    public static <B> Set<B> toSet() {
        return Nil$.MODULE$.toSet();
    }

    public static <B> Buffer<B> toBuffer() {
        return Nil$.MODULE$.toBuffer();
    }

    public static IndexedSeq<Nothing$> toIndexedSeq() {
        return Nil$.MODULE$.toIndexedSeq();
    }

    public static Object toArray(ClassTag classTag) {
        return Nil$.MODULE$.toArray(classTag);
    }

    public static <B> void copyToArray(Object object) {
        Nil$.MODULE$.copyToArray(object);
    }

    public static <B> void copyToArray(Object object, int n) {
        Nil$.MODULE$.copyToArray(object, n);
    }

    public static <B> void copyToBuffer(Buffer<B> buffer) {
        Nil$.MODULE$.copyToBuffer(buffer);
    }

    public static Object minBy(Function1 function1, Ordering ordering) {
        return Nil$.MODULE$.minBy(function1, ordering);
    }

    public static Object maxBy(Function1 function1, Ordering ordering) {
        return Nil$.MODULE$.maxBy(function1, ordering);
    }

    public static Object max(Ordering ordering) {
        return Nil$.MODULE$.max(ordering);
    }

    public static Object min(Ordering ordering) {
        return Nil$.MODULE$.min(ordering);
    }

    public static <B> B product(Numeric<B> numeric) {
        return Nil$.MODULE$.product(numeric);
    }

    public static <B> B sum(Numeric<B> numeric) {
        return Nil$.MODULE$.sum(numeric);
    }

    public static <B> B aggregate(Function0<B> function0, Function2<B, Nothing$, B> function2, Function2<B, B, B> function22) {
        return Nil$.MODULE$.aggregate(function0, function2, function22);
    }

    public static <A1> A1 fold(A1 A1, Function2<A1, A1, A1> function2) {
        return Nil$.MODULE$.fold(A1, function2);
    }

    public static <A1> Option<A1> reduceOption(Function2<A1, A1, A1> function2) {
        return Nil$.MODULE$.reduceOption(function2);
    }

    public static <A1> A1 reduce(Function2<A1, A1, A1> function2) {
        return Nil$.MODULE$.reduce(function2);
    }

    public static <B> Option<B> reduceRightOption(Function2<Nothing$, B, B> function2) {
        return Nil$.MODULE$.reduceRightOption(function2);
    }

    public static <B> Option<B> reduceLeftOption(Function2<B, Nothing$, B> function2) {
        return Nil$.MODULE$.reduceLeftOption(function2);
    }

    public static <B> B $colon$bslash(B b, Function2<Nothing$, B, B> function2) {
        return Nil$.MODULE$.$colon$bslash(b, function2);
    }

    public static <B> B $div$colon(B b, Function2<B, Nothing$, B> function2) {
        return Nil$.MODULE$.$div$colon(b, function2);
    }

    public static <B> Option<B> collectFirst(PartialFunction<Nothing$, B> partialFunction) {
        return Nil$.MODULE$.collectFirst(partialFunction);
    }

    public static int count(Function1<Nothing$, Object> function1) {
        return Nil$.MODULE$.count(function1);
    }

    public static boolean nonEmpty() {
        return Nil$.MODULE$.nonEmpty();
    }
}

