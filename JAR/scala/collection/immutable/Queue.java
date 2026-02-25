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
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractSeq;
import scala.collection.AbstractTraversable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.LinearSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Queue$;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ListBuffer;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSeq;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\t\rc\u0001B\u0013'!5B\u0001\"\u0015\u0001\u0003\u0006\u0004%\tB\u0015\u0005\t-\u0002\u0011\t\u0011)A\u0005'\"Aq\u000b\u0001BC\u0002\u0013E!\u000b\u0003\u0005Y\u0001\t\u0005\t\u0015!\u0003T\u0011\u0015I\u0006\u0001\"\u0005[\u0011\u0015i\u0006\u0001\"\u0011_\u0011\u0015\u0011\u0007\u0001\"\u0011d\u0011\u0015I\u0007\u0001\"\u0011k\u0011\u0015q\u0007\u0001\"\u0011p\u0011\u0015\u0019\b\u0001\"\u0011u\u0011\u0015)\b\u0001\"\u0011w\u0011\u00159\b\u0001\"\u0011y\u0011\u0015q\b\u0001\"\u0011\u0000\u0011\u001d\t\u0019\u0001\u0001C!\u0003\u000bAq!a\u0006\u0001\t\u0003\nI\u0002C\u0004\u0002\u001c\u0001!\t%!\b\t\u000f\u0005}\u0002\u0001\"\u0011\u0002B!9\u0011Q\u000b\u0001\u0005B\u0005]\u0003bBA:\u0001\u0011\u0005\u0011Q\u000f\u0005\b\u0003g\u0002A\u0011AAA\u0011\u001d\t)\n\u0001C\u0001\u0003/Cq!a(\u0001\t\u0003\t\t\u000b\u0003\u0004\u0002*\u0002!\t\u0001\u001e\u0005\b\u0003W\u0003A\u0011IAW\u000f\u001d\u0011\tE\nE\u0001\u0003#4a!\n\u0014\t\u0002\u0005\u001d\u0007BB-\u001b\t\u0003\ty\rC\u0004\u0002Tj!\u0019!!6\t\u000f\u0005%(\u0004\"\u0001\u0002l\"9!\u0011\u0001\u000e\u0005B\t\r\u0001B\u00022\u001b\t\u0003\u0012iaB\u0004\u0003\"iAIAa\t\u0007\u000f\u0005\u0015'\u0004#\u0003\u00030!1\u0011,\tC\u0001\u0005gA\u0011B!\n\"\u0003\u0003%IAa\n\t\u0013\t\u0015\"$!A\u0005\n\t\u001d\"!B)vKV,'BA\u0014)\u0003%IW.\\;uC\ndWM\u0003\u0002*U\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003-\nQa]2bY\u0006\u001c\u0001!\u0006\u0002/kM1\u0001aL D\u0015:\u00032\u0001M\u00194\u001b\u0005A\u0013B\u0001\u001a)\u0005-\t%m\u001d;sC\u000e$8+Z9\u0011\u0005Q*D\u0002\u0001\u0003\u0007m\u0001!)\u0019A\u001c\u0003\u0003\u0005\u000b\"\u0001\u000f\u001f\u0011\u0005eRT\"\u0001\u0016\n\u0005mR#a\u0002(pi\"Lgn\u001a\t\u0003suJ!A\u0010\u0016\u0003\u0007\u0005s\u0017\u0010E\u0002A\u0003Nj\u0011AJ\u0005\u0003\u0005\u001a\u0012\u0011\u0002T5oK\u0006\u00148+Z9\u0011\t\u0011;5'S\u0007\u0002\u000b*\u0011a\tK\u0001\bO\u0016tWM]5d\u0013\tAUI\u0001\u000eHK:,'/[2Ue\u00064XM]:bE2,G+Z7qY\u0006$X\r\u0005\u0002A\u0001A!\u0001gS\u001aN\u0013\ta\u0005FA\u0007MS:,\u0017M]*fc2K7.\u001a\t\u0004\u0001\u0002\u0019\u0004CA\u001dP\u0013\t\u0001&F\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0002j]V\t1\u000bE\u0002A)NJ!!\u0016\u0014\u0003\t1K7\u000f^\u0001\u0004S:\u0004\u0013aA8vi\u0006!q.\u001e;!\u0003\u0019a\u0014N\\5u}Q\u0019Qj\u0017/\t\u000bE+\u0001\u0019A*\t\u000b]+\u0001\u0019A*\u0002\u0013\r|W\u000e]1oS>tW#A0\u0011\u0007\u0011\u0003\u0017*\u0003\u0002b\u000b\n\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0006CB\u0004H.\u001f\u000b\u0003g\u0011DQ!Z\u0004A\u0002\u0019\f\u0011A\u001c\t\u0003s\u001dL!\u0001\u001b\u0016\u0003\u0007%sG/\u0001\u0005ji\u0016\u0014\u0018\r^8s+\u0005Y\u0007c\u0001\u0019mg%\u0011Q\u000e\u000b\u0002\t\u0013R,'/\u0019;pe\u00069\u0011n]#naRLX#\u00019\u0011\u0005e\n\u0018B\u0001:+\u0005\u001d\u0011un\u001c7fC:\fA\u0001[3bIV\t1'\u0001\u0003uC&dW#A'\u0002\r\u0019|'/\u00197m)\t\u0001\u0018\u0010C\u0003{\u0019\u0001\u000710A\u0001q!\u0011IDp\r9\n\u0005uT#!\u0003$v]\u000e$\u0018n\u001c82\u0003\u0019)\u00070[:ugR\u0019\u0001/!\u0001\t\u000bil\u0001\u0019A>\u0002\u0019M$(/\u001b8h!J,g-\u001b=\u0016\u0005\u0005\u001d\u0001\u0003BA\u0005\u0003'i!!a\u0003\u000b\t\u00055\u0011qB\u0001\u0005Y\u0006twM\u0003\u0002\u0002\u0012\u0005!!.\u0019<b\u0013\u0011\t)\"a\u0003\u0003\rM#(/\u001b8h\u0003\u0019aWM\\4uQV\ta-A\u0006%a2,8\u000fJ2pY>tWCBA\u0010\u0003k\t)\u0003\u0006\u0003\u0002\"\u0005mB\u0003BA\u0012\u0003S\u00012\u0001NA\u0013\t\u0019\t9\u0003\u0005b\u0001o\t!A\u000b[1u\u0011\u001d\tY\u0003\u0005a\u0002\u0003[\t!A\u00194\u0011\u0011\u0011\u000by#TA\u001a\u0003GI1!!\rF\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\r!\u0014Q\u0007\u0003\b\u0003o\u0001\"\u0019AA\u001d\u0005\u0005\u0011\u0015CA\u001a=\u0011\u001d\ti\u0004\u0005a\u0001\u0003g\tA!\u001a7f[\u0006YAeY8m_:$\u0003\u000f\\;t+\u0019\t\u0019%!\u0015\u0002JQ!\u0011QIA*)\u0011\t9%a\u0013\u0011\u0007Q\nI\u0005\u0002\u0004\u0002(E\u0011\ra\u000e\u0005\b\u0003W\t\u00029AA'!!!\u0015qF'\u0002P\u0005\u001d\u0003c\u0001\u001b\u0002R\u00119\u0011qG\tC\u0002\u0005e\u0002bBA\u001f#\u0001\u0007\u0011qJ\u0001\u000bIAdWo\u001d\u0013qYV\u001cXCBA-\u0003O\ny\u0006\u0006\u0003\u0002\\\u0005%D\u0003BA/\u0003C\u00022\u0001NA0\t\u0019\t9C\u0005b\u0001o!9\u00111\u0006\nA\u0004\u0005\r\u0004\u0003\u0003#\u000205\u000b)'!\u0018\u0011\u0007Q\n9\u0007B\u0004\u00028I\u0011\r!!\u000f\t\u000f\u0005-$\u00031\u0001\u0002n\u0005!A\u000f[1u!\u0015\u0001\u0014qNA3\u0013\r\t\t\b\u000b\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-A\u0004f]F,X-^3\u0016\t\u0005]\u0014Q\u0010\u000b\u0005\u0003s\ny\b\u0005\u0003A\u0001\u0005m\u0004c\u0001\u001b\u0002~\u00119\u0011qG\nC\u0002\u0005e\u0002bBA\u001f'\u0001\u0007\u00111P\u000b\u0005\u0003\u0007\u000bI\t\u0006\u0003\u0002\u0006\u0006-\u0005\u0003\u0002!\u0001\u0003\u000f\u00032\u0001NAE\t\u001d\t9\u0004\u0006b\u0001\u0003sAq!!$\u0015\u0001\u0004\ty)\u0001\u0003ji\u0016\u0014\b#\u0002!\u0002\u0012\u0006\u001d\u0015bAAJM\tA\u0011\n^3sC\ndW-A\u0004eKF,X-^3\u0016\u0005\u0005e\u0005#B\u001d\u0002\u001cNj\u0015bAAOU\t1A+\u001e9mKJ\nQ\u0002Z3rk\u0016,Xm\u00149uS>tWCAAR!\u0015I\u0014QUAM\u0013\r\t9K\u000b\u0002\u0007\u001fB$\u0018n\u001c8\u0002\u000b\u0019\u0014xN\u001c;\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!a,\u0011\t\u0005E\u0016q\u0018\b\u0005\u0003g\u000bY\fE\u0002\u00026*j!!a.\u000b\u0007\u0005eF&\u0001\u0004=e>|GOP\u0005\u0004\u0003{S\u0013A\u0002)sK\u0012,g-\u0003\u0003\u0002\u0016\u0005\u0005'bAA_U%\u0012\u0001!\t\u0002\u000b\u000b6\u0004H/_)vKV,7\u0003\u0002\u000e\u0002J:\u0003B\u0001RAf\u0013&\u0019\u0011QZ#\u0003\u0015M+\u0017OR1di>\u0014\u0018\u0010\u0006\u0002\u0002RB\u0011\u0001IG\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0005\u0003/\f)/\u0006\u0002\u0002ZBIA)a\f\u0002\\\u0006\r\u0018q\u001d\t\u0005\u0003;\fy.D\u0001\u001b\u0013\r\t\t\u000f\u0019\u0002\u0005\u0007>dG\u000eE\u00025\u0003K$QA\u000e\u000fC\u0002]\u0002B\u0001\u0011\u0001\u0002d\u0006Qa.Z<Ck&dG-\u001a:\u0016\t\u00055\u0018Q`\u000b\u0003\u0003_\u0004\u0002\"!=\u0002x\u0006m\u0018q`\u0007\u0003\u0003gT1!!>)\u0003\u001diW\u000f^1cY\u0016LA!!?\u0002t\n9!)^5mI\u0016\u0014\bc\u0001\u001b\u0002~\u0012)a'\bb\u0001oA!\u0001\tAA~\u0003\u0015)W\u000e\u001d;z+\u0011\u0011)Aa\u0003\u0016\u0005\t\u001d\u0001\u0003\u0002!\u0001\u0005\u0013\u00012\u0001\u000eB\u0006\t\u00151dD1\u00018+\u0011\u0011yA!\u0006\u0015\t\tE!q\u0003\t\u0005\u0001\u0002\u0011\u0019\u0002E\u00025\u0005+!QAN\u0010C\u0002]BqA!\u0007 \u0001\u0004\u0011Y\"\u0001\u0002ygB)\u0011H!\b\u0003\u0014%\u0019!q\u0004\u0016\u0003\u0015q\u0012X\r]3bi\u0016$g(\u0001\u0006F[B$\u00180U;fk\u0016\u00042!!8\"\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\t%\u0002\u0003BA\u0005\u0005WIAA!\f\u0002\f\t1qJ\u00196fGR\u001c2!\tB\u0019!\r\u0001\u0005\u0001\u000f\u000b\u0003\u0005GAs\u0001\u0001B\u001c\u0005{\u0011y\u0004E\u0002:\u0005sI1Aa\u000f+\u0005A\u0019VM]5bYZ+'o]5p]VKE)A\u0003wC2,XM\b\u0005\u0017l\r0{7k\u0016\"\u0004\u0015\tV/Z;f\u0001")
public class Queue<A>
extends AbstractSeq<A>
implements LinearSeq<A>,
Serializable {
    public static final long serialVersionUID = -7622936493364270175L;
    private final List<A> in;
    private final List<A> out;

    public static <A> Queue<A> empty() {
        return Queue$.MODULE$.empty();
    }

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

    public List<A> in() {
        return this.in;
    }

    public List<A> out() {
        return this.out;
    }

    @Override
    public GenericCompanion<Queue> companion() {
        return Queue$.MODULE$;
    }

    @Override
    public A apply(int n) {
        int olen = this.out().length();
        if (n < olen) {
            return this.out().apply(n);
        }
        int m = n - olen;
        int ilen = this.in().length();
        if (m < ilen) {
            return this.in().apply(ilen - m - 1);
        }
        throw new NoSuchElementException("index out of range");
    }

    @Override
    public Iterator<A> iterator() {
        List<A> list = this.out();
        return ((List)this.in().reverse()).$colon$colon$colon(list).iterator();
    }

    @Override
    public boolean isEmpty() {
        return this.in().isEmpty() && this.out().isEmpty();
    }

    @Override
    public A head() {
        if (this.out().nonEmpty()) {
            return this.out().head();
        }
        if (this.in().nonEmpty()) {
            return this.in().last();
        }
        throw new NoSuchElementException("head on empty queue");
    }

    @Override
    public Queue<A> tail() {
        if (this.out().nonEmpty()) {
            return new Queue<A>(this.in(), (List)this.out().tail());
        }
        if (this.in().nonEmpty()) {
            return new Queue<Nothing$>(Nil$.MODULE$, (List)((AbstractTraversable)this.in().reverse()).tail());
        }
        throw new NoSuchElementException("tail on empty queue");
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        List<A> list = this.in();
        if (list == null) {
            throw null;
        }
        if (LinearSeqOptimized.forall$(list, p)) {
            List<A> list2 = this.out();
            if (list2 == null) {
                throw null;
            }
            if (LinearSeqOptimized.forall$(list2, p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        block6: {
            block5: {
                List<A> list = this.in();
                if (list == null) {
                    throw null;
                }
                if (LinearSeqOptimized.exists$(list, p)) break block5;
                List<A> list2 = this.out();
                if (list2 == null) {
                    throw null;
                }
                if (!LinearSeqOptimized.exists$(list2, p)) break block6;
            }
            return true;
        }
        return false;
    }

    @Override
    public String stringPrefix() {
        return "Queue";
    }

    @Override
    public int length() {
        return this.in().length() + this.out().length();
    }

    @Override
    public <B, That> That $plus$colon(B elem, CanBuildFrom<Queue<A>, B, That> bf) {
        Queue<A> queue = bf instanceof GenTraversableFactory.GenericCanBuildFrom ? new Queue<A>(this.in(), this.out().$colon$colon(elem)) : SeqLike.$plus$colon$(this, elem, bf);
        return (That)queue;
    }

    @Override
    public <B, That> That $colon$plus(B elem, CanBuildFrom<Queue<A>, B, That> bf) {
        Object object = bf instanceof GenTraversableFactory.GenericCanBuildFrom ? this.enqueue(elem) : SeqLike.$colon$plus$(this, elem, bf);
        return (That)object;
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Queue<A>, B, That> bf) {
        if (bf == Queue$.MODULE$.ReusableCBF()) {
            List list;
            if (that instanceof Queue) {
                Queue thatQueue = (Queue)that;
                List<A> list2 = thatQueue.out();
                list = thatQueue.in().$plus$plus(this.in().reverse_$colon$colon$colon(list2), List$.MODULE$.canBuildFrom());
            } else {
                ListBuffer lb = new ListBuffer();
                that.seq().foreach((Function1<Object, ListBuffer> & java.io.Serializable & Serializable)x$4 -> lb.$plus$eq$colon(x$4));
                list = lb.prependToList(this.in());
            }
            List newIn = list;
            return (That)new Queue(newIn, this.out());
        }
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    public <B> Queue<B> enqueue(B elem) {
        return new Queue<B>(this.in().$colon$colon(elem), this.out());
    }

    public <B> Queue<B> enqueue(Iterable<B> iter) {
        List list = iter.toList();
        return new Queue(this.in().reverse_$colon$colon$colon(list), this.out());
    }

    public Tuple2<A, Queue<A>> dequeue() {
        Tuple2<Object, Queue<Nothing$>> tuple2;
        List<A> list = this.out();
        if (((Object)Nil$.MODULE$).equals(list) && !this.in().isEmpty()) {
            Object rev = this.in().reverse();
            tuple2 = new Tuple2(((List)rev).head(), new Queue<Nothing$>(Nil$.MODULE$, (List)((AbstractTraversable)rev).tail()));
        } else if (list instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)list;
            Object x = $colon$colon.head();
            List xs = $colon$colon.tl$access$1();
            tuple2 = new Tuple2(x, new Queue<A>(this.in(), xs));
        } else {
            throw new NoSuchElementException("dequeue on empty queue");
        }
        return tuple2;
    }

    public Option<Tuple2<A, Queue<A>>> dequeueOption() {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return new Some<Tuple2<A, Queue<A>>>(this.dequeue());
    }

    public A front() {
        return this.head();
    }

    @Override
    public String toString() {
        return this.mkString("Queue(", ", ", ")");
    }

    public Queue(List<A> in, List<A> out) {
        this.in = in;
        this.out = out;
        Traversable.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Seq.$init$(this);
        LinearSeqLike.$init$(this);
        scala.collection.LinearSeq.$init$(this);
        LinearSeq.$init$(this);
    }
}

