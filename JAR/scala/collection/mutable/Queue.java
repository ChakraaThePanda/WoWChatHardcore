/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.LinkedList;
import scala.collection.mutable.LinkedListLike;
import scala.collection.mutable.MutableList;
import scala.collection.mutable.Queue$;
import scala.collection.mutable.Seq$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005ud\u0001\u0002\f\u0018\u0001yAQA\u0011\u0001\u0005\u0002\rCQ\u0001\u0012\u0001\u0005B\u0015Ca!\u0013\u0001!\n#R\u0005B\u0002\"\u0001\t\u00039b\nC\u0003\\\u0001\u0011\u0005A\fC\u0003f\u0001\u0011\u0005a\rC\u0003h\u0001\u0011\u0005\u0001\u000eC\u0003u\u0001\u0011%Q\u000fC\u0003x\u0001\u0011\u0005\u0001\u0010C\u0003~\u0001\u0011%a\u0010C\u0004\u0002\f\u0001!\t!!\u0004\t\u000f\u0005\u001d\u0002\u0001\"\u0001\u0002*!9\u00111\u0006\u0001\u0005B\u00055\u0002BBA\u0018\u0001\u0011\u00053\t\u0003\u0005\u00022\u0001\u0001K\u0011BA\u001a\u000f\u001d\t)d\u0006E\u0001\u0003o1aAF\f\t\u0002\u0005e\u0002B\u0002\"\u0012\t\u0003\t\t\u0005C\u0004\u0002DE!\u0019!!\u0012\t\r%\u000bB\u0011AA/\u0011%\tI'EA\u0001\n\u0013\tYGA\u0003Rk\u0016,XM\u0003\u0002\u00193\u00059Q.\u001e;bE2,'B\u0001\u000e\u001c\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00029\u0005)1oY1mC\u000e\u0001QCA\u0010''\u0019\u0001\u0001\u0005M\u001b=\u007fA\u0019\u0011E\t\u0013\u000e\u0003]I!aI\f\u0003\u00175+H/\u00192mK2K7\u000f\u001e\t\u0003K\u0019b\u0001\u0001B\u0003(\u0001\t\u0007\u0001FA\u0001B#\tIS\u0006\u0005\u0002+W5\t1$\u0003\u0002-7\t9aj\u001c;iS:<\u0007C\u0001\u0016/\u0013\ty3DA\u0002B]f\u0004B!\r\u001a%i5\t\u0011$\u0003\u000243\t\u0011B*\u001b8fCJ\u001cV-](qi&l\u0017N_3e!\r\t\u0003\u0001\n\t\u0005me\"3(D\u00018\u0015\tA\u0014$A\u0004hK:,'/[2\n\u0005i:$AG$f]\u0016\u0014\u0018n\u0019+sCZ,'o]1cY\u0016$V-\u001c9mCR,\u0007CA\u0011\u0001!\r\tS\bN\u0005\u0003}]\u0011\u0011b\u00117p]\u0016\f'\r\\3\u0011\u0005)\u0002\u0015BA!\u001c\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0019a\u0014N\\5u}Q\tA'A\u0005d_6\u0004\u0018M\\5p]V\ta\tE\u00027\u000fnJ!\u0001S\u001c\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>t\u0017A\u00038fo\n+\u0018\u000e\u001c3feV\t1\n\u0005\u0003\"\u0019\u0012\"\u0014BA'\u0018\u0005\u001d\u0011U/\u001b7eKJ$B\u0001N(U-\")\u0001\u000b\u0002a\u0001#\u0006\u0019am\u001d;\u0011\u0007\u0005\u0012F%\u0003\u0002T/\tQA*\u001b8lK\u0012d\u0015n\u001d;\t\u000bU#\u0001\u0019A)\u0002\u00071\u001cH\u000fC\u0003X\t\u0001\u0007\u0001,A\u0002m]\u001e\u0004\"AK-\n\u0005i[\"aA%oi\u00069QM\\9vKV,GCA/a!\tQc,\u0003\u0002`7\t!QK\\5u\u0011\u0015\tW\u00011\u0001c\u0003\u0015)G.Z7t!\rQ3\rJ\u0005\u0003In\u0011!\u0002\u0010:fa\u0016\fG/\u001a3?\u0003\u001d!W-];fk\u0016$\u0012\u0001J\u0001\rI\u0016\fX/Z;f\r&\u00148\u000f\u001e\u000b\u0003S2\u00042A\u000b6%\u0013\tY7D\u0001\u0004PaRLwN\u001c\u0005\u0006[\u001e\u0001\rA\\\u0001\u0002aB!!f\u001c\u0013r\u0013\t\u00018DA\u0005Gk:\u001cG/[8ocA\u0011!F]\u0005\u0003gn\u0011qAQ8pY\u0016\fg.\u0001\bsK6|g/\u001a$s_6d\u0015n\u001d;\u0015\u0005%4\b\"B7\t\u0001\u0004q\u0017A\u00033fcV,W/Z!mYR\u0011\u0011\u0010 \t\u0004Ci$\u0013BA>\u0018\u0005\r\u0019V-\u001d\u0005\u0006[&\u0001\rA\\\u0001\u0012e\u0016lwN^3BY24%o\\7MSN$H#B@\u0002\u0006\u0005\u001d\u0001\u0003B\u0011\u0002\u0002\u0011J1!a\u0001\u0018\u0005-\t%O]1z\u0005V4g-\u001a:\t\u000b5T\u0001\u0019\u00018\t\r\u0005%!\u00021\u0001\u0000\u0003\r\u0011Xm]\u0001\rKb$(/Y2u\r&\u00148\u000f\u001e\u000b\u0007\u0003\u001f\t\t\"!\u0006\u0011\u0007)R\u0017\u000b\u0003\u0004\u0002\u0014-\u0001\r!U\u0001\u0006gR\f'\u000f\u001e\u0005\u0006[.\u0001\rA\u001c\u0015\b\u0017\u0005e\u0011qDA\u0012!\rQ\u00131D\u0005\u0004\u0003;Y\"A\u00033faJ,7-\u0019;fI\u0006\u0012\u0011\u0011E\u0001XKb$(/Y2u\r&\u00148\u000f\u001e\u0011j]\u0006\u0004\bO]8qe&\fG/\u001a7zA\u0015D\bo\\:fg\u0002JW\u000e\u001d7f[\u0016tG/\u0019;j_:\u0004C-\u001a;bS2\u001ch\u0006I+tK\u0002\"W-];fk\u0016\u0004sN\u001d\u0011eKF,X-^3BY2t\u0013EAA\u0013\u0003\u0019\u0011d&M\u0019/a\u0005)aM]8oiV\tA%\u0001\u0003uC&dW#\u0001\u001b\u0002\u000b\rdwN\\3\u0002\u001f\u0011,7M]3nK:$H*\u001a8hi\"$\u0012!X\u0001\u0006#V,W/\u001a\t\u0003CE\u0019B!EA\u001e\u007fA!a'!\u0010<\u0013\r\tyd\u000e\u0002\u000b'\u0016\fh)Y2u_JLHCAA\u001c\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0011\t9%!\u0017\u0016\u0005\u0005%\u0003#\u0003\u001c\u0002L\u0005=\u0013qKA.\u0013\r\tie\u000e\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0005\u0003#\n\u0019&D\u0001\u0012\u0013\r\t)f\u0012\u0002\u0005\u0007>dG\u000eE\u0002&\u00033\"QaJ\nC\u0002!\u0002B!\t\u0001\u0002XU!\u0011qLA3+\t\t\t\u0007\u0005\u0004\"\u0019\u0006\r\u0014q\r\t\u0004K\u0005\u0015D!B\u0014\u0015\u0005\u0004A\u0003\u0003B\u0011\u0001\u0003G\n1B]3bIJ+7o\u001c7wKR\u0011\u0011Q\u000e\t\u0005\u0003_\nI(\u0004\u0002\u0002r)!\u00111OA;\u0003\u0011a\u0017M\\4\u000b\u0005\u0005]\u0014\u0001\u00026bm\u0006LA!a\u001f\u0002r\t1qJ\u00196fGR\u0004")
public class Queue<A>
extends MutableList<A> {
    public static <A> CanBuildFrom<Queue<?>, A, Queue<A>> canBuildFrom() {
        return Queue$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return Queue$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)queue$).newBuilder();
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
        return Queue$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Queue$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ tabulate_this = queue$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ tabulate_this = queue$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ tabulate_this = queue$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ tabulate_this = queue$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Queue$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ fill_this = queue$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ fill_this = queue$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ fill_this = queue$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Queue$ fill_this = queue$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Queue$ queue$ = Queue$.MODULE$;
        if (queue$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)queue$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return Queue$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Queue$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return Queue$.MODULE$.empty();
    }

    @Override
    public GenericCompanion<Queue> companion() {
        return Queue$.MODULE$;
    }

    @Override
    public Builder<A, Queue<A>> newBuilder() {
        return this.companion().newBuilder();
    }

    public void enqueue(Seq<A> elems) {
        this.$plus$plus$eq(elems);
    }

    /*
     * WARNING - void declaration
     */
    public A dequeue() {
        void var1_1;
        if (this.isEmpty()) {
            throw new NoSuchElementException("queue empty");
        }
        Object res = this.first0().elem();
        this.first0_$eq((LinkedList)this.first0().next());
        this.decrementLength();
        return var1_1;
    }

    /*
     * WARNING - void declaration
     */
    public Option<A> dequeueFirst(Function1<A, Object> p) {
        void var3_3;
        Option<A> optElem;
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        if (BoxesRunTime.unboxToBoolean(p.apply(this.first0().elem()))) {
            void var2_2;
            Some res = new Some(this.first0().elem());
            this.first0_$eq((LinkedList)this.first0().next());
            this.decrementLength();
            return var2_2;
        }
        Option<A> option = optElem = this.removeFromList(p);
        None$ none$ = None$.MODULE$;
        if (option == null ? none$ != null : !option.equals(none$)) {
            this.decrementLength();
        }
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    private Option<A> removeFromList(Function1<A, Object> p) {
        void var3_3;
        LinkedList leftlst = this.first0();
        Option res = None$.MODULE$;
        while (leftlst.next().nonEmpty() && !BoxesRunTime.unboxToBoolean(p.apply(((LinkedListLike)((Object)leftlst.next())).elem()))) {
            leftlst = (LinkedList)leftlst.next();
        }
        if (leftlst.next().nonEmpty()) {
            res = new Some(((LinkedListLike)((Object)leftlst.next())).elem());
            if (leftlst.next() == this.last0()) {
                this.last0_$eq(leftlst);
            }
            leftlst.next_$eq((scala.collection.mutable.Seq)((LinkedListLike)((Object)leftlst.next())).next());
        }
        return var3_3;
    }

    public scala.collection.mutable.Seq<A> dequeueAll(Function1<A, Object> p) {
        if (this.first0().isEmpty()) {
            return (scala.collection.mutable.Seq)Seq$.MODULE$.empty();
        }
        ArrayBuffer res = new ArrayBuffer();
        while (this.first0().nonEmpty() && BoxesRunTime.unboxToBoolean(p.apply(this.first0().elem()))) {
            res.$plus$eq(this.first0().elem());
            this.first0_$eq((LinkedList)this.first0().next());
            this.decrementLength();
        }
        if (this.first0().isEmpty()) {
            return res;
        }
        return this.removeAllFromList(p, res);
    }

    private ArrayBuffer<A> removeAllFromList(Function1<A, Object> p, ArrayBuffer<A> res) {
        LinkedList leftlst = this.first0();
        while (leftlst.next().nonEmpty()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(((LinkedListLike)((Object)leftlst.next())).elem()))) {
                res.$plus$eq(((LinkedListLike)((Object)leftlst.next())).elem());
                if (leftlst.next() == this.last0()) {
                    this.last0_$eq(leftlst);
                }
                leftlst.next_$eq((scala.collection.mutable.Seq)((LinkedListLike)((Object)leftlst.next())).next());
                this.decrementLength();
                continue;
            }
            leftlst = (LinkedList)leftlst.next();
        }
        return res;
    }

    public Option<LinkedList<A>> extractFirst(LinkedList<A> start, Function1<A, Object> p) {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        LinkedList cell = start;
        while (cell.next().nonEmpty() && !BoxesRunTime.unboxToBoolean(p.apply(((LinkedListLike)((Object)cell.next())).elem()))) {
            cell = (LinkedList)cell.next();
        }
        if (((LinkedListLike)((Object)cell.next())).isEmpty()) {
            return None$.MODULE$;
        }
        Some<scala.collection.mutable.Seq> res = new Some<scala.collection.mutable.Seq>(cell.next());
        cell.next_$eq((scala.collection.mutable.Seq)((LinkedListLike)((Object)cell.next())).next());
        this.decrementLength();
        return res;
    }

    public A front() {
        return this.head();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Queue<A> tail() {
        void var1_1;
        Queue<A> tl = new Queue<A>();
        this.tailImpl(tl);
        return var1_1;
    }

    @Override
    public Queue<A> clone() {
        Builder<A, Queue<A>> bf = this.newBuilder();
        bf.$plus$plus$eq(this.seq());
        return bf.result();
    }

    private void decrementLength() {
        this.len_$eq(this.len() - 1);
        if (this.len() == 0) {
            this.last0_$eq(this.first0());
        }
    }

    public Queue() {
    }

    public Queue(LinkedList<A> fst, LinkedList<A> lst, int lng) {
        this();
        this.first0_$eq(fst);
        this.last0_$eq(lst);
        this.len_$eq(lng);
    }
}

