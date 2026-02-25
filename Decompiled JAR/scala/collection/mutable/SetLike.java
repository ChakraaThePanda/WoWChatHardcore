/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.immutable.List;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Set;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSet;
import scala.collection.parallel.mutable.ParSet$;
import scala.collection.script.Include;
import scala.collection.script.Message;
import scala.collection.script.Remove;
import scala.collection.script.Reset;
import scala.collection.script.Script;
import scala.collection.script.Scriptable;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015faB\u000b\u0017!\u0003\r\t!\b\u0005\u00069\u0002!\t!\u0018\u0005\u0007C\u0002\u0001K\u0011\u000b2\t\r\r\u0004\u0001\u0015\"\u0015e\u0011\u0015I\u0007\u0001\"\u0011k\u0011\u0015q\u0007\u0001\"\u0001p\u0011\u0015)\b\u0001\"\u0001w\u0011\u0015A\b\u0001\"\u0001z\u0011\u0015i\bA\"\u0001\u007f\u0011\u001d\t\u0019\u0001\u0001D\u0001\u0003\u000bAq!!\u0003\u0001\t\u0003\tY\u0001\u0003\u0004\u0002\u0018\u0001!\t!\u0018\u0005\b\u00033\u0001A\u0011IA\u000e\u0011\u001d\ti\u0002\u0001C\u0001\u00037Aq!a\b\u0001\t\u0003\n\t\u0003C\u0004\u0002 \u0001!\t%a\u000f\t\u000f\u0005E\u0003\u0001\"\u0011\u0002T!9\u0011Q\r\u0001\u0005B\u0005\u001d\u0004bBA3\u0001\u0011\u0005\u0013\u0011\u000f\u0005\b\u0003w\u0002A\u0011IA?\u0011\u001d\t9\t\u0001C\u0001\u0003\u0013\u0013qaU3u\u0019&\\WM\u0003\u0002\u00181\u00059Q.\u001e;bE2,'BA\r\u001b\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00027\u0005)1oY1mC\u000e\u0001Qc\u0001\u0010)eMI\u0001aH\u0012>\u0007\u001acuJ\u0015\t\u0003A\u0005j\u0011AG\u0005\u0003Ei\u0011a!\u00118z%\u00164\u0007\u0003\u0002\u0013&MEj\u0011\u0001G\u0005\u0003+a\u0001\"a\n\u0015\r\u0001\u0011)\u0011\u0006\u0001b\u0001U\t\t\u0011)\u0005\u0002,]A\u0011\u0001\u0005L\u0005\u0003[i\u0011qAT8uQ&tw\r\u0005\u0002!_%\u0011\u0001G\u0007\u0002\u0004\u0003:L\bCA\u00143\t\u0019\u0019\u0004\u0001\"b\u0001i\t!A\u000b[5t#\tYSGE\u00027qi2Aa\u000e\u0001\u0001k\taAH]3gS:,W.\u001a8u}A!\u0011\b\u0001\u00142\u001b\u00051\u0002cA\u001d<M%\u0011AH\u0006\u0002\u0004'\u0016$\bc\u0001 BM5\tqH\u0003\u0002A1\u000511o\u0019:jaRL!AQ \u0003\u0015M\u001b'/\u001b9uC\ndW\r\u0005\u0003:\t\u001a\n\u0014BA#\u0017\u0005\u001d\u0011U/\u001b7eKJ\u00042a\u0012&'\u001b\u0005A%BA%\u0019\u0003\u001d9WM\\3sS\u000eL!a\u0013%\u0003\u0011\u001d\u0013xn^1cY\u0016\u00042aR''\u0013\tq\u0005J\u0001\u0006TQJLgn[1cY\u0016\u00042!\u000f);\u0013\t\tfCA\u0005DY>tW-\u00192mKB!Ae\u0015\u0014V\u0013\t!\u0006D\u0001\bQCJ\fG\u000e\\3mSj\f'\r\\3\u0011\u0007YSf%D\u0001X\u0015\t9\u0002L\u0003\u0002Z1\u0005A\u0001/\u0019:bY2,G.\u0003\u0002\\/\n1\u0001+\u0019:TKR\fa\u0001J5oSR$C#\u00010\u0011\u0005\u0001z\u0016B\u00011\u001b\u0005\u0011)f.\u001b;\u0002\u00159,wOQ;jY\u0012,'/F\u0001D\u0003-\u0001\u0018M]\"p[\nLg.\u001a:\u0016\u0003\u0015\u0004BAZ4'+6\t\u0001,\u0003\u0002i1\nA1i\\7cS:,'/A\u0003u_N+\u0017/F\u0001l!\r!CNJ\u0005\u0003[b\u00111aU3r\u0003\r\tG\r\u001a\u000b\u0003aN\u0004\"\u0001I9\n\u0005IT\"a\u0002\"p_2,\u0017M\u001c\u0005\u0006i\u0016\u0001\rAJ\u0001\u0005K2,W.\u0001\u0004sK6|g/\u001a\u000b\u0003a^DQ\u0001\u001e\u0004A\u0002\u0019\na!\u001e9eCR,Gc\u00010{w\")Ao\u0002a\u0001M!)Ap\u0002a\u0001a\u0006A\u0011N\\2mk\u0012,G-\u0001\u0005%a2,8\u000fJ3r)\ry\u0018\u0011A\u0007\u0002\u0001!)A\u000f\u0003a\u0001M\u0005IA%\\5okN$S-\u001d\u000b\u0004\u007f\u0006\u001d\u0001\"\u0002;\n\u0001\u00041\u0013A\u0002:fi\u0006Lg\u000eF\u0002_\u0003\u001bAq!a\u0004\u000b\u0001\u0004\t\t\"A\u0001q!\u0015\u0001\u00131\u0003\u0014q\u0013\r\t)B\u0007\u0002\n\rVt7\r^5p]F\nQa\u00197fCJ\fQa\u00197p]\u0016$\u0012!M\u0001\u0007e\u0016\u001cX\u000f\u001c;\u0002\u000b\u0011\u0002H.^:\u0015\u0007E\n\u0019\u0003C\u0003u\u001d\u0001\u0007a\u0005K\u0004\u000f\u0003O\t\u0019$a\u000e\u0011\t\u0005%\u0012qF\u0007\u0003\u0003WQ1!!\f\u001b\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003c\tYCA\u0005nS\u001e\u0014\u0018\r^5p]\u0006\u0012\u0011QG\u0001ZA.\u0002\u0007e\u0019:fCR,7\u000fI1!]\u0016<\be]3u]\u0001*6/\u001a\u0011aWu\u0002\u0007\u0005^8!C\u0012$\u0007%\u00198!K2,W.\u001a8uAQ|\u0007\u0005\u001e5jg\u0002\u001aX\r\u001e\u0011b]\u0012\u0004#/\u001a;ve:\u0004C\u000f[1uAM,G\u000fI5ug\u0016dgML\u0011\u0003\u0003s\tQA\r\u00189]A\"r!MA\u001f\u0003\u0003\n)\u0005\u0003\u0004\u0002@=\u0001\rAJ\u0001\u0006K2,W.\r\u0005\u0007\u0003\u0007z\u0001\u0019\u0001\u0014\u0002\u000b\u0015dW-\u001c\u001a\t\u000f\u0005\u001ds\u00021\u0001\u0002J\u0005)Q\r\\3ngB!\u0001%a\u0013'\u0013\r\tiE\u0007\u0002\u000byI,\u0007/Z1uK\u0012t\u0004fB\b\u0002(\u0005M\u0012qG\u0001\u000bIAdWo\u001d\u0013qYV\u001cHcA\u0019\u0002V!9\u0011q\u000b\tA\u0002\u0005e\u0013A\u0001=t!\u0011!\u00131\f\u0014\n\u0007\u0005u\u0003D\u0001\nHK:$&/\u0019<feN\f'\r\\3P]\u000e,\u0007f\u0002\t\u0002(\u0005\u0005\u0014qG\u0011\u0003\u0003G\n\u0011\fY\u0016,A\u0002\u001a'/Z1uKN\u0004\u0013\r\t8fo\u0002\u001aX\r\u001e\u0018!+N,\u0007\u0005Y\u0016,{\u0001\u0004Co\u001c\u0011bI\u0012\u0004S\r\\3nK:$8\u000f\t;pAQD\u0017n\u001d\u0011tKR\u0004\u0013M\u001c3!e\u0016$XO\u001d8!i\"\fG\u000fI:fi\u0002JGo]3mM:\na\u0001J7j]V\u001cHcA\u0019\u0002j!)A/\u0005a\u0001M!:\u0011#a\n\u0002n\u0005]\u0012EAA8\u0003y\u0003W\u0006\u0019\u0011de\u0016\fG/Z:!C\u0002rWm\u001e\u0011tKRt\u0003%V:fA\u0001lS\b\u0019\u0011u_\u0002\u0012X-\\8wK\u0002\ng\u000eI3mK6,g\u000e\u001e\u0011ge>l\u0007\u0005\u001e5jg\u0002\u001aX\r\u001e\u0011b]\u0012\u0004#/\u001a;ve:\u0004C\u000f[1uAM,G\u000fI5ug\u0016dgM\f\u000b\bc\u0005M\u0014QOA<\u0011\u0019\tyD\u0005a\u0001M!1\u00111\t\nA\u0002\u0019Bq!a\u0012\u0013\u0001\u0004\tI\u0005K\u0004\u0013\u0003O\ti'a\u000e\u0002\u0019\u0011j\u0017N\\;tI5Lg.^:\u0015\u0007E\ny\bC\u0004\u0002XM\u0001\r!!\u0017)\u000fM\t9#a!\u00028\u0005\u0012\u0011QQ\u0001_A6j\u0003\rI2sK\u0006$Xm\u001d\u0011bA9,w\u000fI:fi:\u0002Sk]3!A6jS\b\u0019\u0011u_\u0002\u0012X-\\8wK\u0002*G.Z7f]R\u001c\bE\u001a:p[\u0002\"\b.[:!g\u0016$\b%\u00198eAI,G/\u001e:oAQD\u0017\r\u001e\u0011tKR\u0004\u0013\u000e^:fY\u001at\u0013A\u0003\u0013mKN\u001cH\u0005\\3tgR\u0019a,a#\t\u000f\u00055E\u00031\u0001\u0002\u0010\u0006\u00191-\u001c3\u0011\ty\n\tJJ\u0005\u0004\u0003'{$aB'fgN\fw-\u001a\u0015\b)\u0005]\u0015QTAQ!\r\u0001\u0013\u0011T\u0005\u0004\u00037S\"A\u00033faJ,7-\u0019;fI\u0006\u0012\u0011qT\u0001\u0018g\u000e\u0014\u0018\u000e\u001d;j]\u001e\u0004\u0013n\u001d\u0011eKB\u0014XmY1uK\u0012\f#!a)\u0002\rIr\u0013'\r\u00181\u0001")
public interface SetLike<A, This extends SetLike<A, This> & Set<A>>
extends scala.collection.SetLike<A, This>,
Scriptable<A>,
Builder<A, This>,
Shrinkable<A>,
Cloneable<Set<A>> {
    public static /* synthetic */ Builder newBuilder$(SetLike $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<A, This> newBuilder() {
        return (Builder)this.empty();
    }

    public static /* synthetic */ Combiner parCombiner$(SetLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<A, ParSet<A>> parCombiner() {
        return ParSet$.MODULE$.newCombiner();
    }

    public static /* synthetic */ Seq toSeq$(SetLike $this) {
        return $this.toSeq();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public Seq<A> toSeq() {
        void var1_1;
        ArrayBuffer result2 = new ArrayBuffer(this.size());
        this.foreach((Function1<Object, ArrayBuffer> & java.io.Serializable & Serializable)x$1 -> result2.$plus$eq(x$1));
        return var1_1;
    }

    public static /* synthetic */ boolean add$(SetLike $this, Object elem) {
        return $this.add(elem);
    }

    default public boolean add(A elem) {
        boolean r = this.contains(elem);
        this.$plus$eq(elem);
        return !r;
    }

    public static /* synthetic */ boolean remove$(SetLike $this, Object elem) {
        return $this.remove(elem);
    }

    /*
     * WARNING - void declaration
     */
    default public boolean remove(A elem) {
        void var2_2;
        boolean r = this.contains(elem);
        this.$minus$eq(elem);
        return (boolean)var2_2;
    }

    public static /* synthetic */ void update$(SetLike $this, Object elem, boolean included) {
        $this.update(elem, included);
    }

    default public void update(A elem, boolean included) {
        if (included) {
            this.$plus$eq(elem);
            return;
        }
        this.$minus$eq(elem);
    }

    @Override
    public SetLike<A, This> $plus$eq(A var1);

    public SetLike<A, This> $minus$eq(A var1);

    public static /* synthetic */ void retain$(SetLike $this, Function1 p) {
        $this.retain(p);
    }

    default public void retain(Function1<A, Object> p) {
        List list = this.toList();
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Object a = foreach_these.head();
            SetLike.$anonfun$retain$1(this, p, a);
            foreach_these = (List)foreach_these.tail();
        }
    }

    public static /* synthetic */ void clear$(SetLike $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        List list = this.toList();
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Object a = foreach_these.head();
            this.$minus$eq(a);
            foreach_these = (List)foreach_these.tail();
        }
    }

    public static /* synthetic */ Set clone$(SetLike $this) {
        return $this.clone();
    }

    @Override
    default public This clone() {
        return (This)((Set)((Growable)this.empty()).$plus$plus$eq(((Set)this.repr()).seq()));
    }

    public static /* synthetic */ Set result$(SetLike $this) {
        return $this.result();
    }

    @Override
    default public This result() {
        return (This)((Set)this.repr());
    }

    public static /* synthetic */ Set $plus$(SetLike $this, Object elem) {
        return $this.$plus(elem);
    }

    @Override
    default public This $plus(A elem) {
        return (This)((Set)this.clone().$plus$eq(elem));
    }

    public static /* synthetic */ Set $plus$(SetLike $this, Object elem1, Object elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    @Override
    default public This $plus(A elem1, A elem2, Seq<A> elems) {
        return (This)((Set)this.clone().$plus$eq(elem1).$plus$eq(elem2).$plus$plus$eq(elems));
    }

    public static /* synthetic */ Set $plus$plus$(SetLike $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public This $plus$plus(GenTraversableOnce<A> xs) {
        return (This)((Set)this.clone().$plus$plus$eq(xs.seq()));
    }

    public static /* synthetic */ Set $minus$(SetLike $this, Object elem) {
        return $this.$minus(elem);
    }

    @Override
    default public This $minus(A elem) {
        return (This)((Set)this.clone().$minus$eq(elem));
    }

    public static /* synthetic */ Set $minus$(SetLike $this, Object elem1, Object elem2, Seq elems) {
        return $this.$minus(elem1, elem2, elems);
    }

    @Override
    default public This $minus(A elem1, A elem2, Seq<A> elems) {
        return (This)((Set)this.clone().$minus$eq(elem1).$minus$eq(elem2).$minus$minus$eq(elems));
    }

    public static /* synthetic */ Set $minus$minus$(SetLike $this, GenTraversableOnce xs) {
        return $this.$minus$minus(xs);
    }

    @Override
    default public This $minus$minus(GenTraversableOnce<A> xs) {
        return (This)((Set)this.clone().$minus$minus$eq(xs.seq()));
    }

    public static /* synthetic */ void $less$less$(SetLike $this, Message cmd) {
        $this.$less$less(cmd);
    }

    @Override
    default public void $less$less(Message<A> cmd2) {
        if (cmd2 instanceof Include) {
            Object x = ((Include)cmd2).elem();
            this.$plus$eq((A)x);
            return;
        }
        if (cmd2 instanceof Remove) {
            Object x = ((Remove)cmd2).elem();
            this.$minus$eq(x);
            return;
        }
        if (cmd2 instanceof Reset) {
            this.clear();
            return;
        }
        if (cmd2 instanceof Script) {
            ((Script)cmd2).iterator().foreach((Function1<Message, Object> & java.io.Serializable & Serializable)cmd -> {
                this.$less$less(cmd);
                return BoxedUnit.UNIT;
            });
            return;
        }
        throw new UnsupportedOperationException(new StringBuilder(23).append("message ").append(cmd2).append(" not understood").toString());
    }

    public static /* synthetic */ Object $anonfun$retain$1(SetLike $this, Function1 p$1, Object elem) {
        if (!BoxesRunTime.unboxToBoolean(p$1.apply(elem))) {
            return $this.$minus$eq(elem);
        }
        return BoxedUnit.UNIT;
    }

    public static void $init$(SetLike $this) {
    }
}

