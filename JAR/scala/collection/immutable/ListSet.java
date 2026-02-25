/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.NoSuchElementException;
import scala.Function2;
import scala.Serializable;
import scala.collection.AbstractSet;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.List;
import scala.collection.immutable.ListSet$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Traversable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSet;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005Mx!\u0002\u0015*\u0011\u0003\u0001d!\u0002\u001a*\u0011\u0003\u0019\u0004B\u0002.\u0002\t\u0003\tY\u000bC\u0004\u0002.\u0006!\u0019!a,\t\u0011\u0005\u0015\u0017\u0001)A\u0005\u0003\u000f<q!a;\u0002\u0011\u0013\t)JB\u0004\u0002\u000e\u0006AI!a$\t\ri3A\u0011AAJ\u0011%\tIJBA\u0001\n\u0013\tY\n\u0003\u0005\u0002p\u0006!\taKAy\u0011%\tI*AA\u0001\n\u0013\tYJ\u0002\u00033SAY\u0004\"\u0002.\f\t\u0003Y\u0006\"\u0002/\f\t\u0003j\u0006\"B1\f\t\u0003\u0012\u0007\"\u00024\f\t\u0003:\u0007\"B6\f\t\u0003a\u0007\"B8\f\t\u0003\u0001\b\"\u0002:\f\t\u0003\u0019\b\"B;\f\t\u00032\b\"\u0002?\f\t\u0003i\bB\u00028\f\t#\t\u0019\u0001C\u0004\u0002\u0006-!\t\"a\u0002\t\u000f\u0005%1\u0002\"\u0011\u0002\f!9\u0011\u0011D\u0006\u0005B\u0005maABA\u0017\u0017!\ty\u0003C\u0005o3\t\u0015\r\u0011\"\u0015\u0002\u0004!I\u0011\u0011G\r\u0003\u0002\u0003\u0006I!\u0011\u0005\u00075f!\t!a\r\t\u000b\u0005LB\u0011\t2\t\u0011\u0005m\u0012\u0004)C\u0005\u0003{AQAZ\r\u0005B\u001dDaa[\r\u0005B\u0005U\u0003\u0002CA.3\u0001&I!!\u0018\t\u0011\u0005\u0015\u0014\u0004)C\u0005\u0003OBaa\\\r\u0005B\u0005M\u0004B\u0002:\u001a\t\u0003\n9\bC\u0004\u0002\u0006e!\t&a\u0002\t\u000f\u0005m\u0014\u0004\"\u0011\u0002\u0004!9\u0011QP\r\u0005B\u0005\u001d\u0011a\u0002'jgR\u001cV\r\u001e\u0006\u0003U-\n\u0011\"[7nkR\f'\r\\3\u000b\u00051j\u0013AC2pY2,7\r^5p]*\ta&A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005E\nQ\"A\u0015\u0003\u000f1K7\u000f^*fiN\u0019\u0011\u0001N,\u0011\u0007UB$(D\u00017\u0015\t94&A\u0004hK:,'/[2\n\u0005e2$aE%n[V$\u0018M\u00197f'\u0016$h)Y2u_JL\bCA\u0019\f+\ta4i\u0005\u0004\f{5\u00036k\u0016\t\u0004}}\nU\"A\u0016\n\u0005\u0001[#aC!cgR\u0014\u0018m\u0019;TKR\u0004\"AQ\"\r\u0001\u0011)Ai\u0003b\u0001\u000b\n\t\u0011)\u0005\u0002G\u0015B\u0011q\tS\u0007\u0002[%\u0011\u0011*\f\u0002\b\u001d>$\b.\u001b8h!\t95*\u0003\u0002M[\t\u0019\u0011I\\=\u0011\u0007Er\u0015)\u0003\u0002PS\t\u00191+\u001a;\u0011\tU\n\u0016IO\u0005\u0003%Z\u0012!cR3oKJL7mU3u)\u0016l\u0007\u000f\\1uKB!a\bV!W\u0013\t)6FA\u0004TKRd\u0015n[3\u0011\u0007EZ\u0011\t\u0005\u0002H1&\u0011\u0011,\f\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003Y\u000b\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0003y\u00032!N0;\u0013\t\u0001gG\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006!1/\u001b>f+\u0005\u0019\u0007CA$e\u0013\t)WFA\u0002J]R\fq![:F[B$\u00180F\u0001i!\t9\u0015.\u0003\u0002k[\t9!i\\8mK\u0006t\u0017\u0001C2p]R\f\u0017N\\:\u0015\u0005!l\u0007\"\u00028\u0011\u0001\u0004\t\u0015\u0001B3mK6\fQ\u0001\n9mkN$\"AV9\t\u000b9\f\u0002\u0019A!\u0002\r\u0011j\u0017N\\;t)\t1F\u000fC\u0003o%\u0001\u0007\u0011)\u0001\u0006%a2,8\u000f\n9mkN$\"AV<\t\u000ba\u001c\u0002\u0019A=\u0002\u0005a\u001c\bc\u0001 {\u0003&\u00111p\u000b\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-\u0001\u0005ji\u0016\u0014\u0018\r^8s+\u0005q\bc\u0001 \u0000\u0003&\u0019\u0011\u0011A\u0016\u0003\u0011%#XM]1u_J,\u0012!Q\u0001\u0005]\u0016DH/F\u0001W\u0003\u0015!xnU3u+\u0011\ti!a\u0005\u0016\u0005\u0005=\u0001\u0003B\u0019O\u0003#\u00012AQA\n\t\u001d\t)b\u0006b\u0001\u0003/\u0011\u0011AQ\t\u0003\u0003*\u000bAb\u001d;sS:<\u0007K]3gSb,\"!!\b\u0011\t\u0005}\u0011\u0011F\u0007\u0003\u0003CQA!a\t\u0002&\u0005!A.\u00198h\u0015\t\t9#\u0001\u0003kCZ\f\u0017\u0002BA\u0016\u0003C\u0011aa\u0015;sS:<'\u0001\u0002(pI\u0016\u001c2!\u0007,X\u0003\u0015)G.Z7!)\u0011\t)$!\u000f\u0011\u0007\u0005]\u0012$D\u0001\f\u0011\u0015qG\u00041\u0001B\u00031\u0019\u0018N_3J]R,'O\\1m)\u0015\u0019\u0017qHA\"\u0011\u0019\t\tE\ba\u0001-\u0006\ta\u000e\u0003\u0004\u0002Fy\u0001\raY\u0001\u0004C\u000e\u001c\u0007f\u0001\u0010\u0002JA!\u00111JA)\u001b\t\tiEC\u0002\u0002P5\n!\"\u00198o_R\fG/[8o\u0013\u0011\t\u0019&!\u0014\u0003\u000fQ\f\u0017\u000e\u001c:fGR\u0019\u0001.a\u0016\t\r\u0005e\u0003\u00051\u0001B\u0003\u0005)\u0017\u0001E2p]R\f\u0017N\\:J]R,'O\\1m)\u0015A\u0017qLA1\u0011\u0019\t\t%\ta\u0001-\"1\u0011\u0011L\u0011A\u0002\u0005C3!IA%\u00035Ig\u000eZ3y\u0013:$XM\u001d8bYR91-!\u001b\u0002l\u00055\u0004BBA!E\u0001\u0007a\u000b\u0003\u0004\u0002Z\t\u0002\r!\u0011\u0005\u0007\u0003_\u0012\u0003\u0019A2\u0002\u0003%D3AIA%)\r1\u0016Q\u000f\u0005\u0007\u00033\u001a\u0003\u0019A!\u0015\u0007Y\u000bI\b\u0003\u0004\u0002Z\u0011\u0002\r!Q\u0001\u0005Y\u0006\u001cH/\u0001\u0003j]&$\bfB\r\u0002\u0002\u0006\u001d\u0015\u0011\u0012\t\u0004\u000f\u0006\r\u0015bAAC[\t\u00012+\u001a:jC24VM]:j_:,\u0016\nR\u0001\u0006m\u0006dW/\u001a\u0010\tkHiXu#\u0019Ao&\u001a1BB\r\u0003\u0019\u0015k\u0007\u000f^=MSN$8+\u001a;\u0014\u0007\u0019\t\t\nE\u00022\u0017)#\"!!&\u0011\u0007\u0005]e!D\u0001\u0002\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005u\u0005\u0003BA\u0010\u0003?KA!!)\u0002\"\t1qJ\u00196fGRDsABAA\u0003\u000f\u000b)K\b\u0005F\u0011G\u0004\f\u0014l\u0011MQ\u001dY\u0011\u0011QAD\u0003Ss\u0002b#\u0019\u001aT\"R*[\u000e\u000b\u0002a\u0005a1-\u00198Ck&dGM\u0012:p[V!\u0011\u0011WAa+\t\t\u0019\fE\u00056\u0003k\u000bI,a0\u0002D&\u0019\u0011q\u0017\u001c\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\t\u0005]\u00151X\u0005\u0004\u0003{{&\u0001B\"pY2\u00042AQAa\t\u0015!5A1\u0001F!\u0011\t4\"a0\u0002\u0017I+Wo]1cY\u0016\u001c%I\u0012\n\u0007\u0003\u0013\f).a7\u0007\r\u0005-\u0007\u0001AAd\u00051a$/\u001a4j]\u0016lWM\u001c;?\u0013\u0011\ty-!5\u0002\u001fM,GoQ1o\u0005VLG\u000e\u001a$s_6L1!a57\u000559UM\\*fi\u001a\u000b7\r^8ssB\u0019q)a6\n\u0007\u0005eWF\u0001\u0004B]f\u0014VM\u001a\t\tk\u0005U\u0016Q\u001c&\u0002\u0012B\"\u0011q\\Ar!\u0011\t4\"!9\u0011\u0007\t\u000b\u0019\u000f\u0002\u0006\u0002f\u0002\t\t\u0011!A\u0003\u0002\u0015\u00131a\u0018\u00132\u0013\u0011\tI/!4\u0003\u000b\u0011\ngn\u001c8\u0002\u0019\u0015k\u0007\u000f^=MSN$8+\u001a;)\u000f\u0015\t\t)a\"\u0002&\u0006iQ-\u001c9us&s7\u000f^1oG\u0016,\"!!%")
public class ListSet<A>
extends AbstractSet<A>
implements Set<A>,
Serializable {
    public static final long serialVersionUID = -8417059026623606218L;

    public static <A> CanBuildFrom<ListSet<?>, A, ListSet<A>> canBuildFrom() {
        return ListSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<ListSet<?>, A, ListSet<A>> setCanBuildFrom() {
        return ListSet$.MODULE$.setCanBuildFrom();
    }

    @Override
    public Set<A> seq() {
        return Set.seq$(this);
    }

    @Override
    public Combiner<A, ParSet<A>> parCombiner() {
        return Set.parCombiner$(this);
    }

    @Override
    public GenericCompanion<ListSet> companion() {
        return ListSet$.MODULE$;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(A elem) {
        return false;
    }

    @Override
    public ListSet<A> $plus(A elem) {
        return new Node(this, elem);
    }

    @Override
    public ListSet<A> $minus(A elem) {
        return this;
    }

    @Override
    public ListSet<A> $plus$plus(GenTraversableOnce<A> xs) {
        ListSet listSet;
        if (xs instanceof ListSet) {
            ListSet listSet2;
            ListSet<A> listSet3 = (ListSet<A>)xs;
            if (listSet3 == this) {
                listSet2 = this;
            } else {
                int lsSize = listSet3.size();
                if (lsSize == 0) {
                    listSet2 = this;
                } else {
                    ListSet<A> lsTail;
                    int thisSize = this.size();
                    int remaining = Math.min(thisSize, lsSize);
                    ListSet<A> thisTail = this.skip$1(this, thisSize - remaining);
                    for (lsTail = this.skip$1(listSet3, lsSize - remaining); thisTail != lsTail && !lsTail.isEmpty(); thisTail = thisTail.next(), lsTail = lsTail.next()) {
                    }
                    ListSet result2 = this;
                    for (ListSet<A> toAdd = listSet3; toAdd != lsTail; toAdd = toAdd.next()) {
                        A elem = toAdd.elem();
                        if (this.containsLimited$1(result2, elem, lsTail)) continue;
                        result2 = new Node(result2, elem);
                    }
                    listSet2 = result2;
                }
            }
            listSet = listSet2;
        } else {
            ListSet listSet4;
            if (xs.isEmpty()) {
                listSet4 = this;
            } else {
                ListSet listSet5 = (ListSet)this.repr();
                listSet4 = xs.$div$colon(listSet5, (Function2<ListSet, Object, ListSet> & java.io.Serializable & Serializable)(x$2, x$3) -> x$2.$plus(x$3));
            }
            listSet = listSet4;
        }
        return listSet;
    }

    @Override
    public Iterator<A> iterator() {
        return this.reverseList$1().iterator();
    }

    public A elem() {
        throw new NoSuchElementException("elem of empty set");
    }

    public ListSet<A> next() {
        throw new NoSuchElementException("next of empty set");
    }

    @Override
    public <B> Set<B> toSet() {
        return this;
    }

    @Override
    public String stringPrefix() {
        return "ListSet";
    }

    private final ListSet skip$1(ListSet ls, int count) {
        while (count != 0) {
            --count;
            ls = ls.next();
        }
        return ls;
    }

    private final boolean containsLimited$1(ListSet n, Object e, ListSet end) {
        while (n != end) {
            if (!BoxesRunTime.equals(e, n.elem())) {
                n = n.next();
                continue;
            }
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private final List reverseList$1() {
        void var2_2;
        ListSet<A> curr = this;
        List res = Nil$.MODULE$;
        while (!curr.isEmpty()) {
            A a = curr.elem();
            res = res.$colon$colon(a);
            curr = curr.next();
        }
        return var2_2;
    }

    public ListSet() {
        Traversable.$init$(this);
        Iterable.$init$(this);
        Set.$init$(this);
    }

    public class Node
    extends ListSet<A> {
        public static final long serialVersionUID = -787710309854855049L;
        private final A elem;
        public final /* synthetic */ ListSet $outer;

        @Override
        public A elem() {
            return this.elem;
        }

        @Override
        public int size() {
            return this.sizeInternal(this, 0);
        }

        private int sizeInternal(ListSet<A> n, int acc) {
            while (!n.isEmpty()) {
                ++acc;
                n = n.next();
            }
            return acc;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(A e) {
            return this.containsInternal(this, e);
        }

        private boolean containsInternal(ListSet<A> n, A e) {
            while (!n.isEmpty()) {
                if (!BoxesRunTime.equals(n.elem(), e)) {
                    n = n.next();
                    continue;
                }
                return true;
            }
            return false;
        }

        private int indexInternal(ListSet<A> n, A e, int i) {
            while (!n.isEmpty()) {
                if (BoxesRunTime.equals(n.elem(), e)) {
                    return i;
                }
                ++i;
                n = n.next();
            }
            return -1;
        }

        @Override
        public ListSet<A> $plus(A e) {
            if (this.contains(e)) {
                return this;
            }
            return new Node(this, e);
        }

        @Override
        public ListSet<A> $minus(A e) {
            int index = this.indexInternal(this, e, 0);
            if (index < 0) {
                return this;
            }
            if (index == 0) {
                return this.next();
            }
            ListSet[] data = new ListSet[index];
            this.store$1(0, this, index, data);
            return this.reform$1(index - 1, data[index - 1].next().next(), data);
        }

        @Override
        public ListSet<A> next() {
            return this.scala$collection$immutable$ListSet$Node$$$outer();
        }

        @Override
        public A last() {
            return this.elem();
        }

        @Override
        public ListSet<A> init() {
            return this.next();
        }

        public /* synthetic */ ListSet scala$collection$immutable$ListSet$Node$$$outer() {
            return this.$outer;
        }

        private final void store$1(int i, ListSet e, int index$1, ListSet[] data$1) {
            while (i < index$1) {
                data$1[i] = e;
                e = e.next();
                ++i;
            }
        }

        private final ListSet reform$1(int i, ListSet e, ListSet[] data$1) {
            while (i >= 0) {
                e = new Node(e, data$1[i].elem());
                --i;
            }
            return e;
        }

        public Node(ListSet $outer, A elem) {
            this.elem = elem;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

