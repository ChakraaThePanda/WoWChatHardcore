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
import scala.Serializable;
import scala.Some;
import scala.collection.GenTraversable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.Stack$;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\tUq!\u0002\u0013&\u0011\u0003ac!\u0002\u0018&\u0011\u0003y\u0003B\u00025\u0002\t\u0003\t)J\u0002\u0004\u0002\u0018\u0006\u0001\u0011\u0011\u0014\u0005\u0007Q\u000e!\t!a,\t\u0013\u0005U6A1A\u0005\u0002\u0005]\u0006\u0002CA`\u0007\u0001\u0006I!!/\t\u000f\u0005\u00057\u0001\"\u0001\u0002D\"9\u00111H\u0002\u0005\u0002\u0005u\u0002bBAe\u0007\u0011\u0005\u00111\u001a\u0005\b\u0003\u001b\fA1AAh\u0011\u001d\tI/\u0001C\u0001\u0003WD\u0011\"a>\u0002\u0005\u0004%\t!!?\t\u0011\u0005u\u0018\u0001)A\u0005\u0003wD\u0011\"a@\u0002\u0003\u0003%IA!\u0001\u0007\t9*\u0003a\u000e\u0005\t1>\u0011\t\u0019!C\u00013\"A\u0001m\u0004BA\u0002\u0013\u0005\u0011\r\u0003\u0005h\u001f\t\u0005\t\u0015)\u0003[\u0011\u0015Aw\u0002\"\u0003j\u0011\u0015Aw\u0002\"\u0001l\u0011\u0015aw\u0002\"\u0011n\u0011\u0015yw\u0002\"\u0011q\u0011\u0015!x\u0002\"\u0011v\u0011\u0015Ix\u0002\"\u0011{\u0011\u0015ix\u0002\"\u0001\u007f\u0011\u001d\t9a\u0004C\u0001\u0003\u0013Aq!a\u0002\u0010\t\u0003\t\t\u0002C\u0004\u0002$=!\t!!\n\t\u000f\u0005Mr\u0002\"\u0001\u00026!9\u0011qG\b\u0005\u0002\u0005e\u0002bBA\u001e\u001f\u0011\u0005\u0011Q\b\u0005\b\u0003\u007fyA\u0011IA!\u0011\u0019\tyf\u0004C!3\"9\u0011qM\b\u0005B\u0005%\u0004BBAB\u001f\u0011\u00053.A\u0003Ti\u0006\u001c7N\u0003\u0002'O\u00059Q.\u001e;bE2,'B\u0001\u0015*\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002U\u0005)1oY1mC\u000e\u0001\u0001CA\u0017\u0002\u001b\u0005)#!B*uC\u000e\\7cA\u00011+B\u0019\u0011\u0007\u000e\u001c\u000e\u0003IR!aM\u0014\u0002\u000f\u001d,g.\u001a:jG&\u0011QG\r\u0002\u000b'\u0016\fh)Y2u_JL\bCA\u0017\u0010+\tAdhE\u0004\u0010s![uJU+\u0011\u00075RD(\u0003\u0002<K\tY\u0011IY:ue\u0006\u001cGoU3r!\tid\b\u0004\u0001\u0005\u000b}z!\u0019\u0001!\u0003\u0003\u0005\u000b\"!Q#\u0011\u0005\t\u001bU\"A\u0015\n\u0005\u0011K#a\u0002(pi\"Lgn\u001a\t\u0003\u0005\u001aK!aR\u0015\u0003\u0007\u0005s\u0017\u0010E\u0002.\u0013rJ!AS\u0013\u0003\u0007M+\u0017\u000f\u0005\u0003.\u0019rr\u0015BA'&\u0005\u001d\u0019V-\u001d'jW\u0016\u00042!L\b=!\u0011\t\u0004\u000b\u0010\u001c\n\u0005E\u0013$AG$f]\u0016\u0014\u0018n\u0019+sCZ,'o]1cY\u0016$V-\u001c9mCR,\u0007cA\u0017T\u001d&\u0011A+\n\u0002\n\u00072|g.Z1cY\u0016\u0004\"A\u0011,\n\u0005]K#\u0001D*fe&\fG.\u001b>bE2,\u0017!B3mK6\u001cX#\u0001.\u0011\u0007msF(D\u0001]\u0015\tiv%A\u0005j[6,H/\u00192mK&\u0011q\f\u0018\u0002\u0005\u0019&\u001cH/A\u0005fY\u0016l7o\u0018\u0013fcR\u0011!-\u001a\t\u0003\u0005\u000eL!\u0001Z\u0015\u0003\tUs\u0017\u000e\u001e\u0005\bMF\t\t\u00111\u0001[\u0003\rAH%M\u0001\u0007K2,Wn\u001d\u0011\u0002\rqJg.\u001b;?)\tq%\u000eC\u0003Y'\u0001\u0007!\fF\u0001O\u0003%\u0019w.\u001c9b]&|g.F\u0001o\u001d\ti\u0003!A\u0004jg\u0016k\u0007\u000f^=\u0016\u0003E\u0004\"A\u0011:\n\u0005ML#a\u0002\"p_2,\u0017M\\\u0001\u0007Y\u0016tw\r\u001e5\u0016\u0003Y\u0004\"AQ<\n\u0005aL#aA%oi\u0006)\u0011\r\u001d9msR\u0011Ah\u001f\u0005\u0006yb\u0001\rA^\u0001\u0006S:$W\r_\u0001\u0007kB$\u0017\r^3\u0015\t\t|\u00181\u0001\u0005\u0007\u0003\u0003I\u0002\u0019\u0001<\u0002\u00039Da!!\u0002\u001a\u0001\u0004a\u0014a\u00028fo\u0016dW-\\\u0001\u0005aV\u001c\b\u000e\u0006\u0003\u0002\f\u00055Q\"A\b\t\r\u0005=!\u00041\u0001=\u0003\u0011)G.Z7\u0015\u0011\u0005-\u00111CA\f\u00037Aa!!\u0006\u001c\u0001\u0004a\u0014!B3mK6\f\u0004BBA\r7\u0001\u0007A(A\u0003fY\u0016l'\u0007\u0003\u0004Y7\u0001\u0007\u0011Q\u0004\t\u0005\u0005\u0006}A(C\u0002\u0002\"%\u0012!\u0002\u0010:fa\u0016\fG/\u001a3?\u0003\u001d\u0001Xo\u001d5BY2$B!a\u0003\u0002(!9\u0011\u0011\u0006\u000fA\u0002\u0005-\u0012A\u0001=t!\u0015\ti#a\f=\u001b\u00059\u0013bAA\u0019O\tyAK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-A\u0002u_B,\u0012\u0001P\u0001\u0004a>\u0004H#\u0001\u001f\u0002\u000b\rdW-\u0019:\u0015\u0003\t\f\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0003\u0007\u0002R!!\f\u0002FqJ1!a\u0012(\u0005!IE/\u001a:bi>\u0014\bf\u0002\u0011\u0002L\u0005]\u00131\f\t\u0005\u0003\u001b\n\u0019&\u0004\u0002\u0002P)\u0019\u0011\u0011K\u0015\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002V\u0005=#!C7jOJ\fG/[8oC\t\tI&A\u0012aSR,'/\u0019;pe\u0002\u0004CO]1wKJ\u001cXm\u001d\u0011j]\u00022\u0015JR(!_J$WM\u001d\u0018\"\u0005\u0005u\u0013!\u0002\u001a/q9\u0002\u0014A\u0002;p\u0019&\u001cH\u000fK\u0004\"\u0003\u0017\n\u0019'a\u0017\"\u0005\u0005\u0015\u0014!\t1u_2K7\u000f\u001e1!iJ\fg/\u001a:tKN\u0004\u0013N\u001c\u0011G\u0013\u001a{\u0005e\u001c:eKJt\u0013a\u00024pe\u0016\f7\r[\u000b\u0005\u0003W\nI\bF\u0002c\u0003[Bq!a\u001c#\u0001\u0004\t\t(A\u0001g!\u0019\u0011\u00151\u000f\u001f\u0002x%\u0019\u0011QO\u0015\u0003\u0013\u0019+hn\u0019;j_:\f\u0004cA\u001f\u0002z\u00111\u00111\u0010\u0012C\u0002\u0001\u0013\u0011!\u0016\u0015\bE\u0005-\u0013qPA.C\t\t\t)\u0001\u0012aM>\u0014X-Y2iA\u0002\"(/\u0019<feN,7\u000fI5oA\u0019Kei\u0014\u0011pe\u0012,'OL\u0001\u0006G2|g.\u001a\u0015\b\u001f\u0005\u001d\u0015QRAI!\r\u0011\u0015\u0011R\u0005\u0004\u0003\u0017K#A\u00033faJ,7-\u0019;fI\u0006\u0012\u0011qR\u0001s'R\f7m\u001b\u0011jg\u0002\ng\u000eI5oK2,w-\u00198uA\u0005tG\r\t9pi\u0016tG/[1mYf\u0004\u0003o\\8sYfl\u0003/\u001a:g_Jl\u0017N\\4!oJ\f\u0007\u000f]3sA\u0005\u0014x.\u001e8eA1K7\u000f\u001e\u0018!+N,\u0007%\u0019\u0011MSN$\b%Y:tS\u001etW\r\u001a\u0011u_\u0002\n\u0007E^1sA%t7\u000f^3bI:\n#!a%\u0002\rIr\u0013G\r\u00181)\u0005a#\u0001D*uC\u000e\\')^5mI\u0016\u0014X\u0003BAN\u0003W\u001bRaAAO\u0003G\u00032AQAP\u0013\r\t\t+\u000b\u0002\u0007\u0003:L(+\u001a4\u0011\u000f5\n)+!+\u0002.&\u0019\u0011qU\u0013\u0003\u000f\t+\u0018\u000e\u001c3feB\u0019Q(a+\u0005\u000b}\u001a!\u0019\u0001!\u0011\t5z\u0011\u0011\u0016\u000b\u0003\u0003c\u0003R!a-\u0004\u0003Sk\u0011!A\u0001\u0006Y\n,hMZ\u000b\u0003\u0003s\u0003R!LA^\u0003SK1!!0&\u0005)a\u0015n\u001d;Ck\u001a4WM]\u0001\u0007Y\n,hM\u001a\u0011\u0002\u0011\u0011\u0002H.^:%KF$B!!2\u0002H6\t1\u0001C\u0004\u0002\u0010\u001d\u0001\r!!+\u0002\rI,7/\u001e7u)\t\ti+\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0003\u0002R\u0006\u0015XCAAj!%\t\u0014Q[Am\u0003G\f9/C\u0002\u0002XJ\u0012AbQ1o\u0005VLG\u000e\u001a$s_6\u0004B!a-\u0002\\&!\u0011Q\\Ap\u0005\u0011\u0019u\u000e\u001c7\n\u0007\u0005\u0005(G\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]B\u0019Q(!:\u0005\u000b}R!\u0019\u0001!\u0011\t5z\u00111]\u0001\u000b]\u0016<()^5mI\u0016\u0014X\u0003BAw\u0003g,\"!a<\u0011\u000f5\n)+!=\u0002vB\u0019Q(a=\u0005\u000b}Z!\u0019\u0001!\u0011\t5z\u0011\u0011_\u0001\u0006K6\u0004H/_\u000b\u0003\u0003w\u00042!L\bB\u0003\u0019)W\u000e\u001d;zA\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0011\u0019\u0001\u0005\u0003\u0003\u0006\t=QB\u0001B\u0004\u0015\u0011\u0011IAa\u0003\u0002\t1\fgn\u001a\u0006\u0003\u0005\u001b\tAA[1wC&!!\u0011\u0003B\u0004\u0005\u0019y%M[3di\":\u0011!a\"\u0002\u000e\u0006E\u0005")
public class Stack<A>
extends AbstractSeq<A>
implements Serializable {
    private List<A> elems;

    public static Stack<Nothing$> empty() {
        return Stack$.MODULE$.empty();
    }

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

    public List<A> elems() {
        return this.elems;
    }

    public void elems_$eq(List<A> x$1) {
        this.elems = x$1;
    }

    public Stack$ companion() {
        return Stack$.MODULE$;
    }

    @Override
    public boolean isEmpty() {
        return this.elems().isEmpty();
    }

    @Override
    public int length() {
        return this.elems().length();
    }

    @Override
    public A apply(int index) {
        return this.elems().apply(index);
    }

    @Override
    public void update(int n, A newelem) {
        if (n < 0 || n >= this.length()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
        }
        this.elems_$eq(((List)this.elems().take(n)).$plus$plus(((List)this.elems().drop(n + 1)).$colon$colon(newelem), List$.MODULE$.canBuildFrom()));
    }

    public Stack<A> push(A elem) {
        this.elems_$eq(this.elems().$colon$colon(elem));
        return this;
    }

    public Stack<A> push(A elem1, A elem2, Seq<A> elems) {
        return this.push(elem1).push(elem2).pushAll(elems);
    }

    public Stack<A> pushAll(TraversableOnce<A> xs) {
        xs.foreach((Function1<Object, Stack> & java.io.Serializable & Serializable)elem -> this.push(elem));
        return this;
    }

    public A top() {
        return this.elems().head();
    }

    /*
     * WARNING - void declaration
     */
    public A pop() {
        void var1_1;
        A res = this.elems().head();
        this.elems_$eq((List)this.elems().tail());
        return var1_1;
    }

    public void clear() {
        this.elems_$eq(Nil$.MODULE$);
    }

    @Override
    public Iterator<A> iterator() {
        return this.elems().iterator();
    }

    @Override
    public List<A> toList() {
        return this.elems();
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        IterableLike.foreach$(this, f);
    }

    @Override
    public Stack<A> clone() {
        return new Stack<A>(this.elems());
    }

    public Stack(List<A> elems) {
        this.elems = elems;
    }

    public Stack() {
        this(Nil$.MODULE$);
    }

    public static class StackBuilder<A>
    implements Builder<A, Stack<A>> {
        private final ListBuffer<A> lbuff;

        @Override
        public void sizeHint(int size) {
            Builder.sizeHint$((Builder)this, size);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll) {
            Builder.sizeHint$((Builder)this, coll);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll, int delta) {
            Builder.sizeHint$(this, coll, delta);
        }

        @Override
        public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
            Builder.sizeHintBounded$(this, size, boundingColl);
        }

        @Override
        public <NewTo> Builder<A, NewTo> mapResult(Function1<Stack<A>, NewTo> f) {
            return Builder.mapResult$(this, f);
        }

        @Override
        public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
            return Growable.$plus$eq$(this, elem1, elem2, elems);
        }

        @Override
        public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
            return Growable.$plus$plus$eq$(this, xs);
        }

        public ListBuffer<A> lbuff() {
            return this.lbuff;
        }

        @Override
        public StackBuilder<A> $plus$eq(A elem) {
            this.lbuff().$plus$eq((Object)elem);
            return this;
        }

        @Override
        public void clear() {
            this.lbuff().clear();
        }

        @Override
        public Stack<A> result() {
            return new Stack(this.lbuff().result());
        }

        public StackBuilder() {
            Growable.$init$(this);
            Builder.$init$(this);
            this.lbuff = new ListBuffer();
        }
    }
}

