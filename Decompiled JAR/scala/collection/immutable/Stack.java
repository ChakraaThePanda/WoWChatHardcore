/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractSeq;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.LinearSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Stack$;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\rv!\u0002\r\u001a\u0011\u0003\u0001c!\u0002\u0012\u001a\u0011\u0003\u0019\u0003B\u0002)\u0002\t\u0003\tI\u0006C\u0004\u0002\\\u0005!\u0019!!\u0018\t\u000f\u0005U\u0014\u0001\"\u0001\u0002x!I\u0011QR\u0001\u0002\u0002\u0013%\u0011q\u0012\u0004\u0005Ee\u00011\u0006\u0003\u0005K\r\t\u0015\r\u0011\"\u0005L\u0011!yeA!A!\u0002\u0013a\u0005\"\u0002)\u0007\t#\t\u0006\"B*\u0007\t\u0003\"\u0006\"\u0002)\u0007\t\u0003A\u0006\"B-\u0007\t\u0003R\u0006\"\u00020\u0007\t\u0003z\u0006\"\u00021\u0007\t\u0003\n\u0007\"\u00022\u0007\t\u0003\u0019\u0007\"\u00022\u0007\t\u0003a\u0007\"B=\u0007\t\u0003Q\bBBA\u0005\r\u0011\u0005q\f\u0003\u0004\u0002\f\u0019!\t!\u0019\u0005\b\u0003\u001b1A\u0011AA\b\u0011\u0019\t9B\u0002C!C\"9\u0011\u0011\u0004\u0004\u0005B\u0005m\u0001bBA\u0012\r\u0011\u0005\u0013QE\u0001\u0006'R\f7m\u001b\u0006\u00035m\t\u0011\"[7nkR\f'\r\\3\u000b\u0005qi\u0012AC2pY2,7\r^5p]*\ta$A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005\u0005\nQ\"A\r\u0003\u000bM#\u0018mY6\u0014\u0007\u0005!s\tE\u0002&Q)j\u0011A\n\u0006\u0003Om\tqaZ3oKJL7-\u0003\u0002*M\tQ1+Z9GC\u000e$xN]=\u0011\u0005\u00052QC\u0001\u00174'\u00191Q&\u0010!D\u000fB\u0019afL\u0019\u000e\u0003mI!\u0001M\u000e\u0003\u0017\u0005\u00137\u000f\u001e:bGR\u001cV-\u001d\t\u0003eMb\u0001\u0001\u0002\u00045\r\u0011\u0015\r!\u000e\u0002\u0002\u0003F\u0011aG\u000f\t\u0003oaj\u0011!H\u0005\u0003su\u0011qAT8uQ&tw\r\u0005\u00028w%\u0011A(\b\u0002\u0004\u0003:L\bcA\u0011?c%\u0011q(\u0007\u0002\n\u0019&tW-\u0019:TKF\u0004B!J!2U%\u0011!I\n\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u0005]\u0011\u000bd)\u0003\u0002F7\t\u0011B*\u001b8fCJ\u001cV-](qi&l\u0017N_3e!\r\tc!\r\t\u0003o!K!!S\u000f\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u000b\u0015dW-\\:\u0016\u00031\u00032!I'2\u0013\tq\u0015D\u0001\u0003MSN$\u0018AB3mK6\u001c\b%\u0001\u0004=S:LGO\u0010\u000b\u0003\rJCQAS\u0005A\u00021\u000b\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003U\u00032!\n,+\u0013\t9fE\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]R\ta)A\u0004jg\u0016k\u0007\u000f^=\u0016\u0003m\u0003\"a\u000e/\n\u0005uk\"a\u0002\"p_2,\u0017M\\\u0001\u0005Q\u0016\fG-F\u00012\u0003\u0011!\u0018-\u001b7\u0016\u0003\u0019\u000bA\u0001];tQV\u0011Am\u001a\u000b\u0003K*\u00042!\t\u0004g!\t\u0011t\rB\u0003i\u001f\t\u0007\u0011NA\u0001C#\t\t$\bC\u0003l\u001f\u0001\u0007a-\u0001\u0003fY\u0016lWCA7q)\u0011q\u0017o];\u0011\u0007\u00052q\u000e\u0005\u00023a\u0012)\u0001\u000e\u0005b\u0001S\")!\u000f\u0005a\u0001_\u0006)Q\r\\3nc!)A\u000f\u0005a\u0001_\u0006)Q\r\\3ne!)!\n\u0005a\u0001mB\u0019qg^8\n\u0005al\"A\u0003\u001fsKB,\u0017\r^3e}\u00059\u0001/^:i\u00032dWCA>\u007f)\tax\u0010E\u0002\"\ru\u0004\"A\r@\u0005\u000b!\f\"\u0019A5\t\u000f\u0005\u0005\u0011\u00031\u0001\u0002\u0004\u0005\u0011\u0001p\u001d\t\u0005]\u0005\u0015Q0C\u0002\u0002\bm\u0011q\u0002\u0016:bm\u0016\u00148/\u00192mK>s7-Z\u0001\u0004i>\u0004\u0018a\u00019pa\u0006!\u0001o\u001c93+\t\t\t\u0002E\u00038\u0003'\td)C\u0002\u0002\u0016u\u0011a\u0001V;qY\u0016\u0014\u0014a\u0002:fm\u0016\u00148/Z\u0001\tSR,'/\u0019;peV\u0011\u0011Q\u0004\t\u0005]\u0005}\u0011'C\u0002\u0002\"m\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\ti>\u001cFO]5oOR\u0011\u0011q\u0005\t\u0005\u0003S\t9D\u0004\u0003\u0002,\u0005M\u0002cAA\u0017;5\u0011\u0011q\u0006\u0006\u0004\u0003cy\u0012A\u0002\u001fs_>$h(C\u0002\u00026u\ta\u0001\u0015:fI\u00164\u0017\u0002BA\u001d\u0003w\u0011aa\u0015;sS:<'bAA\u001b;!:a!a\u0010\u0002F\u0005%\u0003cA\u001c\u0002B%\u0019\u00111I\u000f\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0002H\u0005\tic\u0015;bG.\u0004\u0013n\u001d\u0011b]\u0002Jg.\u001a7fO\u0006tG\u000fI1oI\u0002\u0002x\u000e^3oi&\fG\u000e\\=!a>|'\u000f\\=.a\u0016\u0014hm\u001c:nS:<\u0007e\u001e:baB,'\u000fI1s_VtG\r\t'jgRt\u0003%V:fA1K7\u000f\u001e\u0011j]N$X-\u00193;AM$\u0018mY6!aV\u001c\b\u000e\t=!E\u0016\u001cw.\\3tAa\u0004#H\u000f\u0011mSN$8\bI:uC\u000e\\g\u0006]8qA%\u001c\b\u0005\\5ti:\"\u0018-\u001b7/C\t\tY%\u0001\u00043]E\nd\u0006\r\u0015\b\r\u0005=\u0013QKA,!\r9\u0014\u0011K\u0005\u0004\u0003'j\"\u0001E*fe&\fGNV3sg&|g.V%E\u0003\u00151\u0018\r\\;f=!YRNxQ\u001ceixL#\u0001\u0011\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\t\u0005}\u0013\u0011O\u000b\u0003\u0003C\u0002\u0012\"JA2\u0003O\ny'a\u001d\n\u0007\u0005\u0015dE\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0003\u0002j\u0005-T\"A\u0001\n\u0007\u00055dK\u0001\u0003D_2d\u0007c\u0001\u001a\u0002r\u0011)Ag\u0001b\u0001kA!\u0011EBA8\u0003)qWm\u001e\"vS2$WM]\u000b\u0005\u0003s\nI)\u0006\u0002\u0002|AA\u0011QPAB\u0003\u000f\u000bY)\u0004\u0002\u0002\u0000)\u0019\u0011\u0011Q\u000e\u0002\u000f5,H/\u00192mK&!\u0011QQA@\u0005\u001d\u0011U/\u001b7eKJ\u00042AMAE\t\u0015!DA1\u00016!\u0011\tc!a\"\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0003#\u0003B!a%\u0002\u001e6\u0011\u0011Q\u0013\u0006\u0005\u0003/\u000bI*\u0001\u0003mC:<'BAAN\u0003\u0011Q\u0017M^1\n\t\u0005}\u0015Q\u0013\u0002\u0007\u001f\nTWm\u0019;)\u000f\u0005\ty$!\u0012\u0002J\u0001")
public class Stack<A>
extends AbstractSeq<A>
implements LinearSeq<A>,
LinearSeqOptimized<A, Stack<A>>,
Serializable {
    public static final long serialVersionUID = 1976480595012942526L;
    private final List<A> elems;

    public static <A> CanBuildFrom<Stack<?>, A, Stack<A>> canBuildFrom() {
        return Stack$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return Stack$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)stack$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return Stack$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Stack$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ tabulate_this = stack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ tabulate_this = stack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ tabulate_this = stack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ tabulate_this = stack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Stack$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ fill_this = stack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ fill_this = stack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ fill_this = stack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Stack$ fill_this = stack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Stack$ stack$ = Stack$.MODULE$;
        if (stack$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)stack$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return Stack$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Stack$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return Stack$.MODULE$.empty();
    }

    @Override
    public /* synthetic */ boolean scala$collection$LinearSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public int length() {
        return LinearSeqOptimized.length$(this);
    }

    @Override
    public A apply(int n) {
        return (A)LinearSeqOptimized.apply$(this, n);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        LinearSeqOptimized.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return LinearSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return LinearSeqOptimized.exists$(this, p);
    }

    @Override
    public <A1> boolean contains(A1 elem) {
        return LinearSeqOptimized.contains$(this, elem);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return LinearSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)LinearSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)LinearSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)LinearSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)LinearSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public A last() {
        return (A)LinearSeqOptimized.last$(this);
    }

    @Override
    public LinearSeqOptimized take(int n) {
        return LinearSeqOptimized.take$(this, n);
    }

    @Override
    public LinearSeqOptimized drop(int n) {
        return LinearSeqOptimized.drop$(this, n);
    }

    @Override
    public LinearSeqOptimized dropRight(int n) {
        return LinearSeqOptimized.dropRight$(this, n);
    }

    @Override
    public LinearSeqOptimized slice(int from, int until) {
        return LinearSeqOptimized.slice$(this, from, until);
    }

    @Override
    public LinearSeqOptimized takeWhile(Function1 p) {
        return LinearSeqOptimized.takeWhile$(this, p);
    }

    @Override
    public Tuple2<Stack<A>, Stack<A>> span(Function1<A, Object> p) {
        return LinearSeqOptimized.span$(this, p);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return LinearSeqOptimized.sameElements$(this, that);
    }

    @Override
    public int lengthCompare(int len) {
        return LinearSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public boolean isDefinedAt(int x) {
        return LinearSeqOptimized.isDefinedAt$(this, x);
    }

    @Override
    public int segmentLength(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p, int end) {
        return LinearSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Iterator<Stack<A>> tails() {
        return LinearSeqOptimized.tails$(this);
    }

    @Override
    public LinearSeq<A> seq() {
        return LinearSeq.seq$(this);
    }

    @Override
    public scala.collection.LinearSeq<A> thisCollection() {
        return LinearSeqLike.thisCollection$(this);
    }

    @Override
    public scala.collection.LinearSeq toCollection(LinearSeqLike repr) {
        return LinearSeqLike.toCollection$(this, repr);
    }

    @Override
    public int hashCode() {
        return LinearSeqLike.hashCode$(this);
    }

    @Override
    public final <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return LinearSeqLike.corresponds$(this, that, p);
    }

    @Override
    public scala.collection.immutable.Seq<A> toSeq() {
        return scala.collection.immutable.Seq.toSeq$(this);
    }

    @Override
    public Combiner<A, ParSeq<A>> parCombiner() {
        return scala.collection.immutable.Seq.parCombiner$(this);
    }

    public List<A> elems() {
        return this.elems;
    }

    @Override
    public GenericCompanion<Stack> companion() {
        return Stack$.MODULE$;
    }

    @Override
    public boolean isEmpty() {
        return this.elems().isEmpty();
    }

    @Override
    public A head() {
        return this.elems().head();
    }

    @Override
    public Stack<A> tail() {
        return new Stack<A>((List)this.elems().tail());
    }

    public <B> Stack<B> push(B elem) {
        return new Stack<B>(this.elems().$colon$colon(elem));
    }

    public <B> Stack<B> push(B elem1, B elem2, Seq<B> elems) {
        return this.push(elem1).push(elem2).pushAll(elems);
    }

    public <B> Stack<B> pushAll(TraversableOnce<B> xs) {
        return xs.toIterator().$div$colon(this, (Function2<Stack, Object, Stack> & java.io.Serializable & Serializable)(x$3, x$4) -> x$3.push(x$4));
    }

    public A top() {
        if (!this.isEmpty()) {
            return this.elems().head();
        }
        throw new NoSuchElementException("top of empty stack");
    }

    public Stack<A> pop() {
        if (!this.isEmpty()) {
            return new Stack<A>((List)this.elems().tail());
        }
        throw new NoSuchElementException("pop of empty stack");
    }

    public Tuple2<A, Stack<A>> pop2() {
        if (!this.isEmpty()) {
            return new Tuple2<A, Stack<A>>(this.elems().head(), new Stack<A>((List)this.elems().tail()));
        }
        throw new NoSuchElementException("pop of empty stack");
    }

    @Override
    public Stack<A> reverse() {
        return new Stack<A>(this.elems().reverse());
    }

    @Override
    public Iterator<A> iterator() {
        return this.elems().iterator();
    }

    @Override
    public String toString() {
        return this.elems().mkString("Stack(", ", ", ")");
    }

    public Stack(List<A> elems) {
        this.elems = elems;
        Traversable.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Seq.$init$(this);
        LinearSeqLike.$init$(this);
        scala.collection.LinearSeq.$init$(this);
        LinearSeq.$init$(this);
        LinearSeqOptimized.$init$(this);
    }

    public Stack() {
        this(Nil$.MODULE$);
    }
}

