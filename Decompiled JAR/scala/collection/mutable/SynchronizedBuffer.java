/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.mutable.Buffer;
import scala.collection.script.Message;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005MhaB\u0014)!\u0003\r\ta\f\u0005\u0006\t\u0002!\t!\u0012\u0005\u0007\u0013\u0002\u0001J\u0011\u0001&\t\r9\u0003\u0001\u0013\"\u0001P\u0011\u0019!\u0006\u0001%C\u0001+\"1\u0001\f\u0001I\u0005\u0002eCQ!\u0018\u0001\u0005ByCQ!\u001b\u0001\u0005B)DQa\u001c\u0001\u0005BADQA\u001e\u0001\u0005B]Da!\u001f\u0001\u0011\n\u0003Q\b\"\u0002?\u0001\t\u0003j\bBB@\u0001\t\u0003\n\t\u0001C\u0004\u0002\u0006\u0001!\t%a\u0002\t\u000f\u0005-\u0001\u0001\"\u0011\u0002\u000e!A\u00111\u0003\u0001\u0011\n\u0003\t)\u0002\u0003\u0005\u0002\"\u0001\u0001J\u0011AA\u0012\u0011!\tY\u0003\u0001I\u0005\u0002\u00055\u0002bBA\u0019\u0001A%\t!\u0012\u0005\b\u0003g\u0001A\u0011IA\u001b\u0011\u001d\t9\u0006\u0001C!\u00033Bq!a\u0017\u0001\t\u0003\ni\u0006C\u0007\u0002`\u0001\u0001\n1!A\u0001\n\u0013Q\u0015\u0011\r\u0005\u000e\u0003O\u0002\u0001\u0013aA\u0001\u0002\u0013%q*!\u001b\t\u001d\u0005=\u0004\u0001%A\u0002\u0002\u0003%I!!\u001d\u0002v!q\u0011q\u000f\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002z\u0005u\u0004BDA@\u0001A\u0005\u0019\u0011!A\u0005\n\u0005\u0005\u0015Q\u0011\u0005\u000f\u0003\u000f\u0003\u0001\u0013aA\u0001\u0002\u0013%\u0011\u0011RAG\u00119\t9\n\u0001I\u0001\u0004\u0003\u0005I\u0011BAM\u0003;Ca\"a(\u0001!\u0003\r\t\u0011!C\u0005\u0003C\u000b)\u000b\u0003\b\u0002(\u0002\u0001\n1!A\u0001\n\u0013\tI+!,\t\u001d\u0005=\u0006\u0001%A\u0002\u0002\u0003%I!!-\u00026\"q\u0011q\u0017\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002:\u0006}\u0006BDAa\u0001A\u0005\u0019\u0011!A\u0005\n\u0005\r\u0017\u0011\u001a\u0005\u000f\u0003\u0017\u0004\u0001\u0013aA\u0001\u0002\u0013%\u0011QZAi\u00115\t\u0019\u000e\u0001I\u0001\u0004\u0003\u0005I\u0011B#\u0002V\"q\u0011q\u001b\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002Z\u0006u\u0007BDAp\u0001A\u0005\u0019\u0011!A\u0005\n\u0005\u0005\u00181\u001d\u0005\u000f\u0003K\u0004\u0001\u0013aA\u0001\u0002\u0013%\u0011QLAt\u0005I\u0019\u0016P\\2ie>t\u0017N_3e\u0005V4g-\u001a:\u000b\u0005%R\u0013aB7vi\u0006\u0014G.\u001a\u0006\u0003W1\n!bY8mY\u0016\u001cG/[8o\u0015\u0005i\u0013!B:dC2\f7\u0001A\u000b\u0003am\u001a2\u0001A\u00196!\t\u00114'D\u0001-\u0013\t!DF\u0001\u0004B]f\u0014VM\u001a\t\u0004m]JT\"\u0001\u0015\n\u0005aB#A\u0002\"vM\u001a,'\u000f\u0005\u0002;w1\u0001A!\u0002\u001f\u0001\u0005\u0004i$!A!\u0012\u0005y\n\u0005C\u0001\u001a@\u0013\t\u0001EFA\u0004O_RD\u0017N\\4\u0011\u0005I\u0012\u0015BA\"-\u0005\r\te._\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003\u0019\u0003\"AM$\n\u0005!c#\u0001B+oSR\fa\u0001\\3oORDW#A&\u0011\u0005Ib\u0015BA'-\u0005\rIe\u000e^\u0001\tSR,'/\u0019;peV\t\u0001\u000bE\u0002R%fj\u0011AK\u0005\u0003'*\u0012\u0001\"\u0013;fe\u0006$xN]\u0001\u0006CB\u0004H.\u001f\u000b\u0003sYCQa\u0016\u0003A\u0002-\u000b\u0011A\\\u0001\tIAdWo\u001d\u0013fcR\u0011!lW\u0007\u0002\u0001!)A,\u0002a\u0001s\u0005!Q\r\\3n\u0003)!\u0003\u000f\\;tIAdWo\u001d\u000b\u0003?\u0012\u0004\"A\u00171\n\u0005\u0005\u0014'\u0001B*fY\u001aL!a\u0019\u0016\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.\u001a'jW\u0016DQ!\u001a\u0004A\u0002\u0019\f!\u0001_:\u0011\u0007E;\u0017(\u0003\u0002iU\t\u0011r)\u001a8Ue\u00064XM]:bE2,wJ\\2f\u00035!\u0003\u000f\\;tIAdWo\u001d\u0013fcR\u0011!l\u001b\u0005\u0006K\u001e\u0001\r\u0001\u001c\t\u0004#6L\u0014B\u00018+\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0017AB1qa\u0016tG\r\u0006\u0002Gc\")!\u000f\u0003a\u0001g\u0006)Q\r\\3ngB\u0019!\u0007^\u001d\n\u0005Ud#A\u0003\u001fsKB,\u0017\r^3e}\u0005I\u0011\r\u001d9f]\u0012\fE\u000e\u001c\u000b\u0003\rbDQ!Z\u0005A\u00021\fa\u0002\n9mkN$S-\u001d\u0013d_2|g\u000e\u0006\u0002[w\")AL\u0003a\u0001s\u0005\u0019B\u0005\u001d7vg\u0012\u0002H.^:%KF$3m\u001c7p]R\u0011!L \u0005\u0006K.\u0001\r\u0001\\\u0001\baJ,\u0007/\u001a8e)\r1\u00151\u0001\u0005\u0006e2\u0001\ra]\u0001\u000baJ,\u0007/\u001a8e\u00032dGc\u0001$\u0002\n!)Q-\u0004a\u0001Y\u00061\u0011N\\:feR$RARA\b\u0003#AQa\u0016\bA\u0002-CQA\u001d\bA\u0002M\f\u0011\"\u001b8tKJ$\u0018\t\u001c7\u0015\u000b\u0019\u000b9\"!\u0007\t\u000b]{\u0001\u0019A&\t\r\u0015|\u0001\u0019AA\u000e!\u0011\t\u0016QD\u001d\n\u0007\u0005}!FA\u0006Ue\u00064XM]:bE2,\u0017AB;qI\u0006$X\rF\u0003G\u0003K\t9\u0003C\u0003X!\u0001\u00071\n\u0003\u0004\u0002*A\u0001\r!O\u0001\b]\u0016<X\r\\3n\u0003\u0019\u0011X-\\8wKR\u0019\u0011(a\f\t\u000b]\u000b\u0002\u0019A&\u0002\u000b\rdW-\u0019:\u0002\u0015\u0011bWm]:%Y\u0016\u001c8\u000fF\u0002G\u0003oAq!!\u000f\u0014\u0001\u0004\tY$A\u0002d[\u0012\u0004R!!\u0010\u0002Dej!!a\u0010\u000b\u0007\u0005\u0005#&\u0001\u0004tGJL\u0007\u000f^\u0005\u0005\u0003\u000b\nyDA\u0004NKN\u001c\u0018mZ3)\u000fM\tI%a\u0014\u0002TA\u0019!'a\u0013\n\u0007\u00055CF\u0001\u0006eKB\u0014XmY1uK\u0012\f#!!\u0015\u0002/M\u001c'/\u001b9uS:<\u0007%[:!I\u0016\u0004(/Z2bi\u0016$\u0017EAA+\u0003\u0019\u0011d&M\u0019/a\u0005)1\r\\8oKR\tq,\u0001\u0005iCND7i\u001c3f)\u0005Y\u0015\u0001D:va\u0016\u0014H\u0005\\3oORD\u0017bA%\u0002d%\u0019\u0011Q\r\u0015\u0003\u0015\t+hMZ3s\u0019&\\W-\u0001\btkB,'\u000fJ5uKJ\fGo\u001c:\n\u00079\u000bY'C\u0002\u0002n)\u0012A\"\u0013;fe\u0006\u0014G.\u001a'jW\u0016\f1b];qKJ$\u0013\r\u001d9msR\u0019\u0011(a\u001d\t\u000b]C\u0002\u0019A&\n\u0007Q\u000b\u0019'\u0001\btkB,'\u000f\n\u0013qYV\u001cH%Z9\u0015\u0007i\u000bY\bC\u0003]3\u0001\u0007\u0011(C\u0002Y\u0003G\n\u0001c];qKJ$C\u0005\u001d7vg\u0012\u0002H.^:\u0015\u0007U\n\u0019\tC\u0003f5\u0001\u0007a-C\u0002^\u0003G\n1c];qKJ$C\u0005\u001d7vg\u0012\u0002H.^:%KF$2AWAF\u0011\u0015)7\u00041\u0001m\u0013\rI\u0017qR\u0005\u0005\u0003#\u000b\u0019J\u0001\u0005He><\u0018M\u00197f\u0015\r\t)JK\u0001\bO\u0016tWM]5d\u0003=\u0019X\u000f]3sI\u0005\u0004\b/\u001a8e\u00032dGc\u0001$\u0002\u001c\")Q\r\ba\u0001Y&\u0019a/a\u0019\u0002)M,\b/\u001a:%IAdWo\u001d\u0013fc\u0012\u001aw\u000e\\8o)\rQ\u00161\u0015\u0005\u00069v\u0001\r!O\u0005\u0004s\u0006\r\u0014!G:va\u0016\u0014H\u0005\n9mkN$\u0003\u000f\\;tI\u0015\fHeY8m_:$2AWAV\u0011\u0015)g\u00041\u0001m\u0013\ra\u00181M\u0001\u0011gV\u0004XM\u001d\u0013qe\u0016\u0004XM\u001c3BY2$2ARAZ\u0011\u0015)w\u00041\u0001m\u0013\u0011\t)!a\u0019\u0002\u001fM,\b/\u001a:%S:\u001cXM\u001d;BY2$RARA^\u0003{CQa\u0016\u0011A\u0002-CaA\u001d\u0011A\u0002\u0005m\u0011\u0002BA\n\u0003G\nAb];qKJ$S\u000f\u001d3bi\u0016$RARAc\u0003\u000fDQaV\u0011A\u0002-Ca!!\u000b\"\u0001\u0004I\u0014\u0002BA\u0011\u0003G\nAb];qKJ$#/Z7pm\u0016$2!OAh\u0011\u00159&\u00051\u0001L\u0013\u0011\tY#a\u0019\u0002\u0017M,\b/\u001a:%G2,\u0017M]\u0005\u0005\u0003c\t\u0019'\u0001\ttkB,'\u000f\n\u0013mKN\u001cH\u0005\\3tgR\u0019a)a7\t\u000f\u0005eB\u00051\u0001\u0002<%!\u00111GA2\u0003-\u0019X\u000f]3sI\rdwN\\3\u0015\u0003UJA!a\u0016\u0002d\u0005q1/\u001e9fe\u0012B\u0017m\u001d5D_\u0012,\u0017\u0002BA.\u0003SL1!a;+\u0005)9UM\\*fc2K7.\u001a\u0015\b\u0001\u0005%\u0013q^A*C\t\t\t0AA\u0010'ft7\r\u001b:p]&T\u0018\r^5p]\u00022\u0018.\u0019\u0011ue\u0006LGo\u001d\u0011jg\u0002\"W\r\u001d:fG\u0006$X\r\u001a\u0011bg\u0002JG\u000fI5tA%t\u0007.\u001a:f]Rd\u0017\u0010I;oe\u0016d\u0017.\u00192mK:\u00023i\u001c8tS\u0012,'\u000f\t6bm\u0006tS\u000f^5m]\r|gnY;se\u0016tGOL\"p]\u000e,(O]3oi2Kgn[3e#V,W/\u001a\u0011bg\u0002\ng\u000eI1mi\u0016\u0014h.\u0019;jm\u0016t\u0003")
public interface SynchronizedBuffer<A>
extends Buffer<A> {
    public /* synthetic */ int scala$collection$mutable$SynchronizedBuffer$$super$length();

    public /* synthetic */ Iterator scala$collection$mutable$SynchronizedBuffer$$super$iterator();

    public /* synthetic */ Object scala$collection$mutable$SynchronizedBuffer$$super$apply(int var1);

    public /* synthetic */ SynchronizedBuffer scala$collection$mutable$SynchronizedBuffer$$super$$plus$eq(Object var1);

    public /* synthetic */ Buffer scala$collection$mutable$SynchronizedBuffer$$super$$plus$plus(GenTraversableOnce var1);

    public /* synthetic */ SynchronizedBuffer scala$collection$mutable$SynchronizedBuffer$$super$$plus$plus$eq(TraversableOnce var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedBuffer$$super$appendAll(TraversableOnce var1);

    public /* synthetic */ SynchronizedBuffer scala$collection$mutable$SynchronizedBuffer$$super$$plus$eq$colon(Object var1);

    public /* synthetic */ SynchronizedBuffer scala$collection$mutable$SynchronizedBuffer$$super$$plus$plus$eq$colon(TraversableOnce var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedBuffer$$super$prependAll(TraversableOnce var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedBuffer$$super$insertAll(int var1, Traversable var2);

    public /* synthetic */ void scala$collection$mutable$SynchronizedBuffer$$super$update(int var1, Object var2);

    public /* synthetic */ Object scala$collection$mutable$SynchronizedBuffer$$super$remove(int var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedBuffer$$super$clear();

    public /* synthetic */ void scala$collection$mutable$SynchronizedBuffer$$super$$less$less(Message var1);

    public /* synthetic */ Buffer scala$collection$mutable$SynchronizedBuffer$$super$clone();

    public /* synthetic */ int scala$collection$mutable$SynchronizedBuffer$$super$hashCode();

    public static /* synthetic */ int length$(SynchronizedBuffer $this) {
        return $this.length();
    }

    @Override
    default public int length() {
        synchronized (this) {
            int n = this.scala$collection$mutable$SynchronizedBuffer$$super$length();
            return n;
        }
    }

    public static /* synthetic */ Iterator iterator$(SynchronizedBuffer $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<A> iterator() {
        synchronized (this) {
            Iterator iterator2 = this.scala$collection$mutable$SynchronizedBuffer$$super$iterator();
            return iterator2;
        }
    }

    public static /* synthetic */ Object apply$(SynchronizedBuffer $this, int n) {
        return $this.apply(n);
    }

    @Override
    default public A apply(int n) {
        synchronized (this) {
            Object object = this.scala$collection$mutable$SynchronizedBuffer$$super$apply(n);
            return (A)object;
        }
    }

    public static /* synthetic */ SynchronizedBuffer $plus$eq$(SynchronizedBuffer $this, Object elem) {
        return $this.$plus$eq(elem);
    }

    @Override
    default public SynchronizedBuffer<A> $plus$eq(A elem) {
        synchronized (this) {
            SynchronizedBuffer synchronizedBuffer = this.scala$collection$mutable$SynchronizedBuffer$$super$$plus$eq(elem);
            return synchronizedBuffer;
        }
    }

    public static /* synthetic */ Buffer $plus$plus$(SynchronizedBuffer $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public Buffer<A> $plus$plus(GenTraversableOnce<A> xs) {
        synchronized (this) {
            Buffer buffer = this.scala$collection$mutable$SynchronizedBuffer$$super$$plus$plus(xs);
            return buffer;
        }
    }

    public static /* synthetic */ SynchronizedBuffer $plus$plus$eq$(SynchronizedBuffer $this, TraversableOnce xs) {
        return $this.$plus$plus$eq(xs);
    }

    @Override
    default public SynchronizedBuffer<A> $plus$plus$eq(TraversableOnce<A> xs) {
        synchronized (this) {
            SynchronizedBuffer synchronizedBuffer = this.scala$collection$mutable$SynchronizedBuffer$$super$$plus$plus$eq(xs);
            return synchronizedBuffer;
        }
    }

    public static /* synthetic */ void append$(SynchronizedBuffer $this, Seq elems) {
        $this.append(elems);
    }

    @Override
    default public void append(Seq<A> elems) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$$plus$plus$eq(elems);
            return;
        }
    }

    public static /* synthetic */ void appendAll$(SynchronizedBuffer $this, TraversableOnce xs) {
        $this.appendAll(xs);
    }

    @Override
    default public void appendAll(TraversableOnce<A> xs) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$appendAll(xs);
            return;
        }
    }

    public static /* synthetic */ SynchronizedBuffer $plus$eq$colon$(SynchronizedBuffer $this, Object elem) {
        return $this.$plus$eq$colon(elem);
    }

    @Override
    default public SynchronizedBuffer<A> $plus$eq$colon(A elem) {
        synchronized (this) {
            SynchronizedBuffer synchronizedBuffer = this.scala$collection$mutable$SynchronizedBuffer$$super$$plus$eq$colon(elem);
            return synchronizedBuffer;
        }
    }

    public static /* synthetic */ SynchronizedBuffer $plus$plus$eq$colon$(SynchronizedBuffer $this, TraversableOnce xs) {
        return $this.$plus$plus$eq$colon(xs);
    }

    @Override
    default public SynchronizedBuffer<A> $plus$plus$eq$colon(TraversableOnce<A> xs) {
        synchronized (this) {
            SynchronizedBuffer synchronizedBuffer = this.scala$collection$mutable$SynchronizedBuffer$$super$$plus$plus$eq$colon(xs);
            return synchronizedBuffer;
        }
    }

    public static /* synthetic */ void prepend$(SynchronizedBuffer $this, Seq elems) {
        $this.prepend(elems);
    }

    @Override
    default public void prepend(Seq<A> elems) {
        this.prependAll(elems);
    }

    public static /* synthetic */ void prependAll$(SynchronizedBuffer $this, TraversableOnce xs) {
        $this.prependAll(xs);
    }

    @Override
    default public void prependAll(TraversableOnce<A> xs) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$prependAll(xs);
            return;
        }
    }

    public static /* synthetic */ void insert$(SynchronizedBuffer $this, int n, Seq elems) {
        $this.insert(n, elems);
    }

    @Override
    default public void insert(int n, Seq<A> elems) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$insertAll(n, elems);
            return;
        }
    }

    public static /* synthetic */ void insertAll$(SynchronizedBuffer $this, int n, Traversable xs) {
        $this.insertAll(n, xs);
    }

    @Override
    default public void insertAll(int n, Traversable<A> xs) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$insertAll(n, xs);
            return;
        }
    }

    public static /* synthetic */ void update$(SynchronizedBuffer $this, int n, Object newelem) {
        $this.update(n, newelem);
    }

    @Override
    default public void update(int n, A newelem) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$update(n, newelem);
            return;
        }
    }

    public static /* synthetic */ Object remove$(SynchronizedBuffer $this, int n) {
        return $this.remove(n);
    }

    @Override
    default public A remove(int n) {
        synchronized (this) {
            Object object = this.scala$collection$mutable$SynchronizedBuffer$$super$remove(n);
            return (A)object;
        }
    }

    public static /* synthetic */ void clear$(SynchronizedBuffer $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$clear();
            return;
        }
    }

    public static /* synthetic */ void $less$less$(SynchronizedBuffer $this, Message cmd) {
        $this.$less$less(cmd);
    }

    @Override
    default public void $less$less(Message<A> cmd) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedBuffer$$super$$less$less(cmd);
            return;
        }
    }

    public static /* synthetic */ Buffer clone$(SynchronizedBuffer $this) {
        return $this.clone();
    }

    @Override
    default public Buffer<A> clone() {
        synchronized (this) {
            Buffer buffer = this.scala$collection$mutable$SynchronizedBuffer$$super$clone();
            return buffer;
        }
    }

    public static /* synthetic */ int hashCode$(SynchronizedBuffer $this) {
        return $this.hashCode();
    }

    @Override
    default public int hashCode() {
        synchronized (this) {
            int n = this.scala$collection$mutable$SynchronizedBuffer$$super$hashCode();
            return n;
        }
    }

    public static void $init$(SynchronizedBuffer $this) {
    }
}

