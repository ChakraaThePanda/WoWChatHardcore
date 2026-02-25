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
import scala.collection.mutable.LinkedList$;
import scala.collection.mutable.LinkedListLike;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015a\u0001B\u0006\r\u0001MAQA\u000e\u0001\u0005\u0002]BQA\u000e\u0001\u0005\u0002aBQ!\u0010\u0001\u0005By:Q\u0001\u0015\u0007\t\u0002E3Qa\u0003\u0007\t\u0002ICQAN\u0003\u0005\u0002YCQaV\u0003\u0005BaCQ!X\u0003\u0005\u0004yCQA[\u0003\u0005\u0002-Dqa]\u0003\u0002\u0002\u0013%AO\u0001\u0006MS:\\W\r\u001a'jgRT!!\u0004\b\u0002\u000f5,H/\u00192mK*\u0011q\u0002E\u0001\u000bG>dG.Z2uS>t'\"A\t\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011AcG\n\u0007\u0001U)\u0003fL\u001a\u0011\u0007Y9\u0012$D\u0001\r\u0013\tABBA\u0006BEN$(/Y2u'\u0016\f\bC\u0001\u000e\u001c\u0019\u0001!Q\u0001\b\u0001C\u0002u\u0011\u0011!Q\t\u0003=\t\u0002\"a\b\u0011\u000e\u0003AI!!\t\t\u0003\u000f9{G\u000f[5oOB\u0011qdI\u0005\u0003IA\u00111!\u00118z!\r1b%G\u0005\u0003O1\u0011\u0011\u0002T5oK\u0006\u00148+Z9\u0011\t%b\u0013DL\u0007\u0002U)\u00111FD\u0001\bO\u0016tWM]5d\u0013\ti#F\u0001\u000eHK:,'/[2Ue\u00064XM]:bE2,G+Z7qY\u0006$X\r\u0005\u0002\u0017\u0001A!a\u0003M\r3\u0013\t\tDB\u0001\bMS:\\W\r\u001a'jgRd\u0015n[3\u0011\u0007Y\u0001\u0011\u0004\u0005\u0002 i%\u0011Q\u0007\u0005\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003I\"2AM\u001d<\u0011\u0015Q$\u00011\u0001\u001a\u0003\u0011)G.Z7\t\u000bq\u0012\u0001\u0019\u0001\u001a\u0002\t9,\u0007\u0010^\u0001\nG>l\u0007/\u00198j_:,\u0012a\u0010\t\u0004S\u0001s\u0013BA!+\u0005A9UM\\3sS\u000e\u001cu.\u001c9b]&|g\u000e\u000b\u0003\u0001\u0007\u001aC\u0005CA\u0010E\u0013\t)\u0005C\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013aR\u0001aY><X\u0006\\3wK2\u0004C.\u001b8lK\u0012\u0004C.[:ug\u0002\n'/\u001a\u0011eKB\u0014XmY1uK\u0012\u0004C-^3!i>\u0004\u0013\u000eZ5pgft7M]1tS\u0016\u001c\b%\u001b8!S:$XM\u001d4bG\u0016\u0004\u0013M\u001c3!S:\u001cw.\u001c9mKR,\u0007EZ3biV\u0014Xm]\u0011\u0002\u0013\u00061!GL\u00192]ABC\u0001A&O\u001fB\u0011q\u0004T\u0005\u0003\u001bB\u0011\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u0002\u000bY\fG.^3\u001f\u0011i\u001d\u001a^r\u0005\u00126H\u000b!\u0002T5oW\u0016$G*[:u!\t1RaE\u0002\u0006'N\u00022!\u000b+/\u0013\t)&F\u0001\u0006TKF4\u0015m\u0019;pef$\u0012!U\u0001\u0006K6\u0004H/_\u000b\u00033r+\u0012A\u0017\t\u0004-\u0001Y\u0006C\u0001\u000e]\t\u0015arA1\u0001\u001e\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\ty\u0006.F\u0001a!\u0015I\u0013mY4j\u0013\t\u0011'F\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0002eK6\tQ!\u0003\u0002g\u0001\n!1i\u001c7m!\tQ\u0002\u000eB\u0003\u001d\u0011\t\u0007Q\u0004E\u0002\u0017\u0001\u001d\f!B\\3x\u0005VLG\u000eZ3s+\ta\u0017/F\u0001n!\u00111b\u000e\u001d:\n\u0005=d!a\u0002\"vS2$WM\u001d\t\u00035E$Q\u0001H\u0005C\u0002u\u00012A\u0006\u0001q\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0003U\u0004\"A^>\u000e\u0003]T!\u0001_=\u0002\t1\fgn\u001a\u0006\u0002u\u0006!!.\u0019<b\u0013\taxO\u0001\u0004PE*,7\r\u001e\u0015\u0005\u000b\rs\b*I\u0001\u0000\u0003\u0015bwn^\u0017mKZ,G\u000e\t7j].,G\r\t7jgR\u001c\b%\u0019:fA\u0011,\u0007O]3dCR,G\r\u000b\u0003\u0006\u0007\u001aC\u0005\u0006\u0002\u0003D}\"\u0003")
public class LinkedList<A>
extends AbstractSeq<A>
implements scala.collection.mutable.LinearSeq<A>,
LinkedListLike<A, LinkedList<A>>,
Serializable {
    public static final long serialVersionUID = -7308240733518833071L;
    private A elem;
    private LinkedList<A> next;

    public static <A> CanBuildFrom<LinkedList<?>, A, LinkedList<A>> canBuildFrom() {
        return LinkedList$.MODULE$.canBuildFrom();
    }

    public static <A> LinkedList<A> empty() {
        return LinkedList$.MODULE$.empty();
    }

    public static Some unapplySeq(Seq seq) {
        return LinkedList$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)linkedList$).newBuilder();
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
        return LinkedList$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return LinkedList$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ tabulate_this = linkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ tabulate_this = linkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ tabulate_this = linkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ tabulate_this = linkedList$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return LinkedList$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ fill_this = linkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ fill_this = linkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ fill_this = linkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        LinkedList$ fill_this = linkedList$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        LinkedList$ linkedList$ = LinkedList$.MODULE$;
        if (linkedList$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)linkedList$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return LinkedList$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return LinkedList$.MODULE$.ReusableCBF();
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
    public scala.collection.mutable.Seq tail() {
        return LinkedListLike.tail$(this);
    }

    @Override
    public scala.collection.mutable.Seq append(scala.collection.mutable.Seq that) {
        return LinkedListLike.append$(this, that);
    }

    @Override
    public void insert(scala.collection.mutable.Seq that) {
        LinkedListLike.insert$(this, that);
    }

    @Override
    public scala.collection.mutable.Seq drop(int n) {
        return LinkedListLike.drop$(this, n);
    }

    @Override
    public A apply(int n) {
        return (A)LinkedListLike.apply$(this, n);
    }

    @Override
    public void update(int n, A x) {
        LinkedListLike.update$(this, n, x);
    }

    @Override
    public Option<A> get(int n) {
        return LinkedListLike.get$(this, n);
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
    public scala.collection.mutable.Seq clone() {
        return LinkedListLike.clone$(this);
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
    public A elem() {
        return this.elem;
    }

    @Override
    public void elem_$eq(A x$1) {
        this.elem = x$1;
    }

    @Override
    public LinkedList<A> next() {
        return this.next;
    }

    @Override
    public void next_$eq(LinkedList<A> x$1) {
        this.next = x$1;
    }

    @Override
    public GenericCompanion<LinkedList> companion() {
        return LinkedList$.MODULE$;
    }

    public LinkedList() {
        LinearSeqLike.$init$(this);
        LinearSeq.$init$(this);
        scala.collection.mutable.LinearSeq.$init$(this);
        LinkedListLike.$init$(this);
        this.next_$eq((scala.collection.mutable.Seq)this);
    }

    public LinkedList(A elem, LinkedList<A> next) {
        this();
        if (next != null) {
            this.elem_$eq(elem);
            this.next_$eq((scala.collection.mutable.Seq)next);
        }
    }
}

