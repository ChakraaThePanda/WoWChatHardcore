/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.Iterator;
import scala.collection.LinearSeq;
import scala.collection.LinearSeqLike;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.Builder;
import scala.collection.mutable.DoubleLinkedList$;
import scala.collection.mutable.DoubleLinkedListLike;
import scala.collection.mutable.LinkedListLike;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001u4Aa\u0003\u0007\u0001'!)a\u0007\u0001C\u0001o!)a\u0007\u0001C\u0001q!)Q\b\u0001C!}!)!\t\u0001C!o\u001d)\u0011\u000b\u0004E\u0001%\u001a)1\u0002\u0004E\u0001'\")aG\u0002C\u0001/\")\u0001L\u0002C\u00023\")QM\u0002C\u0001M\"9aNBA\u0001\n\u0013y'\u0001\u0005#pk\ndW\rT5oW\u0016$G*[:u\u0015\tia\"A\u0004nkR\f'\r\\3\u000b\u0005=\u0001\u0012AC2pY2,7\r^5p]*\t\u0011#A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005QY2C\u0002\u0001\u0016K!z3\u0007E\u0002\u0017/ei\u0011\u0001D\u0005\u000311\u00111\"\u00112tiJ\f7\r^*fcB\u0011!d\u0007\u0007\u0001\t\u0015a\u0002A1\u0001\u001e\u0005\u0005\t\u0015C\u0001\u0010#!\ty\u0002%D\u0001\u0011\u0013\t\t\u0003CA\u0004O_RD\u0017N\\4\u0011\u0005}\u0019\u0013B\u0001\u0013\u0011\u0005\r\te.\u001f\t\u0004-\u0019J\u0012BA\u0014\r\u0005%a\u0015N\\3beN+\u0017\u000f\u0005\u0003*YeqS\"\u0001\u0016\u000b\u0005-r\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003[)\u0012!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u0004\"A\u0006\u0001\u0011\tY\u0001\u0014DM\u0005\u0003c1\u0011A\u0003R8vE2,G*\u001b8lK\u0012d\u0015n\u001d;MS.,\u0007c\u0001\f\u00013A\u0011q\u0004N\u0005\u0003kA\u0011AbU3sS\u0006d\u0017N_1cY\u0016\fa\u0001P5oSRtD#\u0001\u001a\u0015\u0007IJ4\bC\u0003;\u0005\u0001\u0007\u0011$\u0001\u0003fY\u0016l\u0007\"\u0002\u001f\u0003\u0001\u0004\u0011\u0014\u0001\u00028fqR\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003}\u00022!\u000b!/\u0013\t\t%F\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006)1\r\\8oK\"\"\u0001\u0001R$I!\tyR)\u0003\u0002G!\t\u00012+\u001a:jC24VM]:j_:,\u0016\nR\u0001\u0006m\u0006dW/\u001a\u0010\t\u001d_h3V\u0003$>$\"\"\u0001AS'P!\ty2*\u0003\u0002M!\tQA-\u001a9sK\u000e\fG/\u001a3\"\u00039\u000b\u0001\r\\8x[1,g/\u001a7!Y&t7.\u001a3!Y&\u001cHo\u001d\u0011be\u0016\u0004C-\u001a9sK\u000e\fG/\u001a3!IV,\u0007\u0005^8!S\u0012Lwn]=oGJ\f7/[3tA%t\u0007%\u001b8uKJ4\u0017mY3!C:$\u0007%\u001b8d_6\u0004H.\u001a;fA\u0019,\u0017\r^;sKN\f\u0013\u0001U\u0001\u0007e9\n\u0014G\f\u0019\u0002!\u0011{WO\u00197f\u0019&t7.\u001a3MSN$\bC\u0001\f\u0007'\r1Ak\r\t\u0004SUs\u0013B\u0001,+\u0005)\u0019V-\u001d$bGR|'/\u001f\u000b\u0002%\u0006a1-\u00198Ck&dGM\u0012:p[V\u0011!lY\u000b\u00027B)\u0011\u0006\u00180cI&\u0011QL\u000b\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0003?\u0002l\u0011AB\u0005\u0003C\u0002\u0013AaQ8mYB\u0011!d\u0019\u0003\u00069!\u0011\r!\b\t\u0004-\u0001\u0011\u0017A\u00038fo\n+\u0018\u000e\u001c3feV\u0011q\r\\\u000b\u0002QB!a#[6n\u0013\tQGBA\u0004Ck&dG-\u001a:\u0011\u0005iaG!\u0002\u000f\n\u0005\u0004i\u0002c\u0001\f\u0001W\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\u0005\u0001\bCA9w\u001b\u0005\u0011(BA:u\u0003\u0011a\u0017M\\4\u000b\u0003U\fAA[1wC&\u0011qO\u001d\u0002\u0007\u001f\nTWm\u0019;)\t\u0019Q\u0015pT\u0011\u0002u\u0006)Cn\\<.Y\u00164X\r\u001c\u0011mS:\\W\r\u001a\u0011mSN$8\u000fI1sK\u0002\"W\r\u001d:fG\u0006$X\r\u001a\u0015\u0005\r)ku\n\u000b\u0003\u0006\u0015f|\u0005")
public class DoubleLinkedList<A>
extends AbstractSeq<A>
implements scala.collection.mutable.LinearSeq<A>,
DoubleLinkedListLike<A, DoubleLinkedList<A>>,
Serializable {
    public static final long serialVersionUID = -8144992287952814767L;
    private DoubleLinkedList<A> prev;
    private A elem;
    private DoubleLinkedList<A> next;

    public static <A> CanBuildFrom<DoubleLinkedList<?>, A, DoubleLinkedList<A>> canBuildFrom() {
        return DoubleLinkedList$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return DoubleLinkedList$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)doubleLinkedList$).newBuilder();
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
        return DoubleLinkedList$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return DoubleLinkedList$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ tabulate_this = doubleLinkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ tabulate_this = doubleLinkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ tabulate_this = doubleLinkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ tabulate_this = doubleLinkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return DoubleLinkedList$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ fill_this = doubleLinkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ fill_this = doubleLinkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ fill_this = doubleLinkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        DoubleLinkedList$ fill_this = doubleLinkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        DoubleLinkedList$ doubleLinkedList$ = DoubleLinkedList$.MODULE$;
        if (doubleLinkedList$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)doubleLinkedList$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return DoubleLinkedList$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return DoubleLinkedList$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return DoubleLinkedList$.MODULE$.empty();
    }

    @Override
    public /* synthetic */ void scala$collection$mutable$DoubleLinkedListLike$$super$insert(scala.collection.mutable.Seq that) {
        LinkedListLike.insert$(this, that);
    }

    @Override
    public scala.collection.mutable.Seq append(scala.collection.mutable.Seq that) {
        return DoubleLinkedListLike.append$(this, that);
    }

    @Override
    public void insert(scala.collection.mutable.Seq that) {
        DoubleLinkedListLike.insert$(this, that);
    }

    @Override
    public void remove() {
        DoubleLinkedListLike.remove$(this);
    }

    @Override
    public scala.collection.mutable.Seq drop(int n) {
        return DoubleLinkedListLike.drop$(this, n);
    }

    @Override
    public scala.collection.mutable.Seq tail() {
        return DoubleLinkedListLike.tail$(this);
    }

    @Override
    public A apply(int n) {
        return (A)DoubleLinkedListLike.apply$(this, n);
    }

    @Override
    public void update(int n, A x) {
        DoubleLinkedListLike.update$(this, n, x);
    }

    @Override
    public Option<A> get(int n) {
        return DoubleLinkedListLike.get$(this, n);
    }

    @Override
    public boolean isEmpty() {
        return LinkedListLike.isEmpty$(this);
    }

    @Override
    public int length() {
        return LinkedListLike.length$(this);
    }

    @Override
    public A head() {
        return (A)LinkedListLike.head$(this);
    }

    @Override
    public Iterator<A> iterator() {
        return LinkedListLike.iterator$(this);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        LinkedListLike.foreach$(this, f);
    }

    @Override
    public scala.collection.mutable.LinearSeq<A> seq() {
        return scala.collection.mutable.LinearSeq.seq$(this);
    }

    @Override
    public LinearSeq<A> thisCollection() {
        return LinearSeqLike.thisCollection$(this);
    }

    @Override
    public LinearSeq toCollection(LinearSeqLike repr) {
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
    public DoubleLinkedList<A> prev() {
        return this.prev;
    }

    @Override
    public void prev_$eq(DoubleLinkedList<A> x$1) {
        this.prev = x$1;
    }

    @Override
    public A elem() {
        return this.elem;
    }

    @Override
    public void elem_$eq(A x$1) {
        this.elem = x$1;
    }

    @Override
    public DoubleLinkedList<A> next() {
        return this.next;
    }

    @Override
    public void next_$eq(DoubleLinkedList<A> x$1) {
        this.next = x$1;
    }

    @Override
    public GenericCompanion<DoubleLinkedList> companion() {
        return DoubleLinkedList$.MODULE$;
    }

    @Override
    public DoubleLinkedList<A> clone() {
        Builder builder = this.newBuilder();
        builder.$plus$plus$eq(this);
        return (DoubleLinkedList)builder.result();
    }

    public DoubleLinkedList() {
        LinearSeqLike.$init$(this);
        LinearSeq.$init$(this);
        scala.collection.mutable.LinearSeq.$init$(this);
        LinkedListLike.$init$(this);
        DoubleLinkedListLike.$init$(this);
        this.next_$eq((scala.collection.mutable.Seq)this);
    }

    public DoubleLinkedList(A elem, DoubleLinkedList<A> next) {
        this();
        if (next != null) {
            this.elem_$eq(elem);
            this.next_$eq((scala.collection.mutable.Seq)next);
            ((DoubleLinkedListLike)((Object)this.next())).prev_$eq(this);
        }
    }
}

