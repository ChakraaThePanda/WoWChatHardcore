/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.collection.GenSet;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.collection.mutable.Set;
import scala.collection.script.Message;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t-ba\u0002\u0015*!\u0003\r\t\u0001\r\u0005\u0006\u000b\u0002!\tA\u0012\u0005\u0007\u0015\u0002\u0001J\u0011A&\t\u000b=\u0003A\u0011\t)\t\rQ\u0003\u0001\u0013\"\u0001V\u0011\u0019A\u0006\u0001%C\u00013\")A\f\u0001C!;\"1A\r\u0001I\u0005\u0002\u0015DQa\u001a\u0001\u0005B!DQA\u001b\u0001\u0005B-DQa\u001c\u0001\u0005BADQA\u001d\u0001\u0005BMDQ!\u001e\u0001\u0005BYDa\u0001 \u0001\u0011\n\u00031\u0005\"B?\u0001\t\u0003r\bbBA\u0001\u0001\u0011\u0005\u00131\u0001\u0005\b\u0003/\u0001A\u0011IA\r\u0011\u001d\t\t\u0003\u0001C!\u0003GAq!a\r\u0001\t\u0003\n)\u0004C\u0004\u0002N\u0001!\t%a\u0014\t\u000f\u0005E\u0004\u0001\"\u0011\u0002t!i\u0011q\u0010\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003L\u0003\u0003CQ\"a!\u0001!\u0003\r\t\u0011!C\u0005!\u0006\u0015\u0005BDAF\u0001A\u0005\u0019\u0011!A\u0005\n\u00055\u0015\u0011\u0013\u0005\u000f\u0003'\u0003\u0001\u0013aA\u0001\u0002\u0013%\u0011QSAM\u00119\ti\n\u0001I\u0001\u0004\u0003\u0005I\u0011BAP\u0003GCa\"!,\u0001!\u0003\r\t\u0011!C\u0005\u0003_\u000b\u0019\f\u0003\b\u00026\u0002\u0001\n1!A\u0001\n\u0013\t9,a/\t\u001d\u0005\u0005\u0007\u0001%A\u0002\u0002\u0003%I!a1\u0002J\"q\u00111\u001a\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002N\u0006E\u0007BDAj\u0001A\u0005\u0019\u0011!A\u0005\n\u0005U\u0017\u0011\u001c\u0005\u000f\u00037\u0004\u0001\u0013aA\u0001\u0002\u0013%\u0011Q\\Aq\u00115\t9\u000f\u0001I\u0001\u0004\u0003\u0005I\u0011\u0002$\u0002j\"q\u00111\u001e\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002n\u0006E\bBDAz\u0001A\u0005\u0019\u0011!A\u0005\n\u0005U(\u0011\u0001\u0005\u000f\u0005\u000f\u0001\u0001\u0013aA\u0001\u0002\u0013%!\u0011\u0002B\u0007\u00119\u0011y\u0001\u0001I\u0001\u0004\u0003\u0005I\u0011BA\u0012\u0005#AaBa\u0005\u0001!\u0003\r\t\u0011!C\u0005\u0003k\u0011)\u0002\u0003\b\u0003\u0018\u0001\u0001\n1!A\u0001\n\u0013\u0011IB!\b\t\u001d\t}\u0001\u0001%A\u0002\u0002\u0003%IA!\t\u0003$\ty1+\u001f8dQJ|g.\u001b>fIN+GO\u0003\u0002+W\u00059Q.\u001e;bE2,'B\u0001\u0017.\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002]\u0005)1oY1mC\u000e\u0001QCA\u0019='\r\u0001!G\u000e\t\u0003gQj\u0011!L\u0005\u0003k5\u0012a!\u00118z%\u00164\u0007cA\u001c9u5\t\u0011&\u0003\u0002:S\t\u00191+\u001a;\u0011\u0005mbD\u0002\u0001\u0003\u0006{\u0001\u0011\rA\u0010\u0002\u0002\u0003F\u0011qH\u0011\t\u0003g\u0001K!!Q\u0017\u0003\u000f9{G\u000f[5oOB\u00111gQ\u0005\u0003\t6\u00121!\u00118z\u0003\u0019!\u0013N\\5uIQ\tq\t\u0005\u00024\u0011&\u0011\u0011*\f\u0002\u0005+:LG/\u0001\u0003tSj,W#\u0001'\u0011\u0005Mj\u0015B\u0001(.\u0005\rIe\u000e^\u0001\bSN,U\u000e\u001d;z+\u0005\t\u0006CA\u001aS\u0013\t\u0019VFA\u0004C_>dW-\u00198\u0002\u0011\r|g\u000e^1j]N$\"!\u0015,\t\u000b]#\u0001\u0019\u0001\u001e\u0002\t\u0015dW-\\\u0001\tIAdWo\u001d\u0013fcR\u0011!lW\u0007\u0002\u0001!)q+\u0002a\u0001u\u0005iA\u0005\u001d7vg\u0012\u0002H.^:%KF$\"A\u00170\t\u000b}3\u0001\u0019\u00011\u0002\u0005a\u001c\bcA1cu5\t1&\u0003\u0002dW\tyAK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-A\u0005%[&tWo\u001d\u0013fcR\u0011!L\u001a\u0005\u0006/\u001e\u0001\rAO\u0001\u0010I5Lg.^:%[&tWo\u001d\u0013fcR\u0011!,\u001b\u0005\u0006?\"\u0001\r\u0001Y\u0001\u0007kB$\u0017\r^3\u0015\u0007\u001dcW\u000eC\u0003X\u0013\u0001\u0007!\bC\u0003o\u0013\u0001\u0007\u0011+\u0001\u0005j]\u000edW\u000fZ3e\u0003\r\tG\r\u001a\u000b\u0003#FDQa\u0016\u0006A\u0002i\naA]3n_Z,GCA)u\u0011\u001596\u00021\u0001;\u0003%Ig\u000e^3sg\u0016\u001cG\u000f\u0006\u00027o\")\u0001\u0010\u0004a\u0001s\u0006!A\u000f[1u!\r\t'PO\u0005\u0003w.\u0012aaR3o'\u0016$\u0018!B2mK\u0006\u0014\u0018\u0001C:vEN,Go\u00144\u0015\u0005E{\b\"\u0002=\u000f\u0001\u0004I\u0018a\u00024pe\u0016\f7\r[\u000b\u0005\u0003\u000b\t\u0019\u0002F\u0002H\u0003\u000fAq!!\u0003\u0010\u0001\u0004\tY!A\u0001g!\u0019\u0019\u0014Q\u0002\u001e\u0002\u0012%\u0019\u0011qB\u0017\u0003\u0013\u0019+hn\u0019;j_:\f\u0004cA\u001e\u0002\u0014\u00111\u0011QC\bC\u0002y\u0012\u0011!V\u0001\u0007e\u0016$\u0018-\u001b8\u0015\u0007\u001d\u000bY\u0002C\u0004\u0002\u001eA\u0001\r!a\b\u0002\u0003A\u0004RaMA\u0007uE\u000ba\u0001^8MSN$XCAA\u0013!\u0015\t9#!\f;\u001d\r\u0019\u0014\u0011F\u0005\u0004\u0003Wi\u0013a\u00029bG.\fw-Z\u0005\u0005\u0003_\t\tD\u0001\u0003MSN$(bAA\u0016[\u0005AAo\\*ue&tw\r\u0006\u0002\u00028A!\u0011\u0011HA$\u001d\u0011\tY$a\u0011\u0011\u0007\u0005uR&\u0004\u0002\u0002@)\u0019\u0011\u0011I\u0018\u0002\rq\u0012xn\u001c;?\u0013\r\t)%L\u0001\u0007!J,G-\u001a4\n\t\u0005%\u00131\n\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005\u0015S&\u0001\u0006%Y\u0016\u001c8\u000f\n7fgN$2aRA)\u0011\u001d\t\u0019f\u0005a\u0001\u0003+\n1aY7e!\u0015\t9&!\u0018;\u001b\t\tIFC\u0002\u0002\\-\naa]2sSB$\u0018\u0002BA0\u00033\u0012q!T3tg\u0006<W\rK\u0004\u0014\u0003G\nI'!\u001c\u0011\u0007M\n)'C\u0002\u0002h5\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\tY'A\ftGJL\u0007\u000f^5oO\u0002J7\u000f\t3faJ,7-\u0019;fI\u0006\u0012\u0011qN\u0001\u0007e9\n\u0014G\f\u0019\u0002\u000b\rdwN\\3\u0015\u0005\u0005U\u0004c\u0001.\u0002x%!\u0011\u0011PA>\u0005\u0011\u0019V\r\u001c4\n\u0007\u0005u4FA\bUe\u00064XM]:bE2,G*[6f\u0003)\u0019X\u000f]3sIML'0Z\u0005\u0003\u0015\n\fQb];qKJ$\u0013n]#naRL\u0018bA(\u0002\b&\u0019\u0011\u0011R\u0016\u0003\u000fM+G\u000fT5lK\u0006q1/\u001e9fe\u0012\u001awN\u001c;bS:\u001cHcA)\u0002\u0010\")qk\u0006a\u0001u%\u0019A+a\"\u0002\u001dM,\b/\u001a:%IAdWo\u001d\u0013fcR\u0019!,a&\t\u000b]C\u0002\u0019\u0001\u001e\n\u0007a\u000bY*C\u0002\u0002\n&\n1c];qKJ$C\u0005\u001d7vg\u0012\u0002H.^:%KF$2AWAQ\u0011\u0015y\u0016\u00041\u0001a\u0013\ra\u0016QU\u0005\u0005\u0003O\u000bIK\u0001\u0005He><\u0018M\u00197f\u0015\r\tYkK\u0001\bO\u0016tWM]5d\u0003=\u0019X\u000f]3sI\u0011j\u0017N\\;tI\u0015\fHc\u0001.\u00022\")qK\u0007a\u0001u%\u0019A-a'\u0002+M,\b/\u001a:%I5Lg.^:%[&tWo\u001d\u0013fcR\u0019!,!/\t\u000b}[\u0002\u0019\u00011\n\u0007\u001d\fi,\u0003\u0003\u0002@\u0006%&AC*ie&t7.\u00192mK\u0006a1/\u001e9fe\u0012*\b\u000fZ1uKR)q)!2\u0002H\")q\u000b\ba\u0001u!)a\u000e\ba\u0001#&\u0019!.a'\u0002\u0013M,\b/\u001a:%C\u0012$GcA)\u0002P\")q+\ba\u0001u%\u0019q.a'\u0002\u0019M,\b/\u001a:%e\u0016lwN^3\u0015\u0007E\u000b9\u000eC\u0003X=\u0001\u0007!(C\u0002s\u00037\u000bqb];qKJ$\u0013N\u001c;feN,7\r\u001e\u000b\u0004m\u0005}\u0007\"\u0002= \u0001\u0004I\u0018bA;\u0002d&\u0019\u0011Q]\u0016\u0003\u0015\u001d+gnU3u\u0019&\\W-A\u0006tkB,'\u000fJ2mK\u0006\u0014\u0018b\u0001?\u0002\u001c\u0006q1/\u001e9fe\u0012\u001aXOY:fi>3GcA)\u0002p\")\u00010\ta\u0001s&\u0019Q0a9\u0002\u001bM,\b/\u001a:%M>\u0014X-Y2i+\u0011\t90a@\u0015\u0007\u001d\u000bI\u0010C\u0004\u0002\n\t\u0002\r!a?\u0011\rM\niAOA\u007f!\rY\u0014q \u0003\u0007\u0003+\u0011#\u0019\u0001 \n\t\u0005\u0005!1A\u0005\u0004\u0005\u000bY#\u0001D%uKJ\f'\r\\3MS.,\u0017\u0001D:va\u0016\u0014HE]3uC&tGcA$\u0003\f!9\u0011QD\u0012A\u0002\u0005}\u0011\u0002BA\f\u00037\u000bAb];qKJ$Co\u001c'jgRL1!!\tc\u00039\u0019X\u000f]3sIQ|7\u000b\u001e:j]\u001eLA!a\r\u0002\b\u0006\u00012/\u001e9fe\u0012\"C.Z:tI1,7o\u001d\u000b\u0004\u000f\nm\u0001bBA*M\u0001\u0007\u0011QK\u0005\u0005\u0003\u001b\nY*A\u0006tkB,'\u000fJ2m_:,G#\u0001\u001c\n\t\u0005E\u00141\u0014\u0015\b\u0001\u0005\r$qEA7C\t\u0011I#AA\u0014'ft7\r\u001b:p]&T\u0018\r^5p]\u00022\u0018.\u0019\u0011ue\u0006LGo\u001d\u0011jg\u0002\"W\r\u001d:fG\u0006$X\r\u001a\u0011bg\u0002JG\u000fI5tA%t\u0007.\u001a:f]Rd\u0017\u0010I;oe\u0016d\u0017.\u00192mK:\u00023i\u001c8tS\u0012,'\u000f\t6bm\u0006tS\u000f^5m]\r|gnY;se\u0016tGOL\"p]\u000e,(O]3oi\"\u000b7\u000f['ban\u000bE&\u00168jiv\u0003\u0013m\u001d\u0011b]\u0002\nG\u000e^3s]\u0006$\u0018N^3/\u0001")
public interface SynchronizedSet<A>
extends Set<A> {
    public /* synthetic */ int scala$collection$mutable$SynchronizedSet$$super$size();

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedSet$$super$isEmpty();

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedSet$$super$contains(Object var1);

    public /* synthetic */ SynchronizedSet scala$collection$mutable$SynchronizedSet$$super$$plus$eq(Object var1);

    public /* synthetic */ SynchronizedSet scala$collection$mutable$SynchronizedSet$$super$$plus$plus$eq(TraversableOnce var1);

    public /* synthetic */ SynchronizedSet scala$collection$mutable$SynchronizedSet$$super$$minus$eq(Object var1);

    public /* synthetic */ SynchronizedSet scala$collection$mutable$SynchronizedSet$$super$$minus$minus$eq(TraversableOnce var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedSet$$super$update(Object var1, boolean var2);

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedSet$$super$add(Object var1);

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedSet$$super$remove(Object var1);

    public /* synthetic */ Set scala$collection$mutable$SynchronizedSet$$super$intersect(GenSet var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedSet$$super$clear();

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedSet$$super$subsetOf(GenSet var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedSet$$super$foreach(Function1 var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedSet$$super$retain(Function1 var1);

    public /* synthetic */ List scala$collection$mutable$SynchronizedSet$$super$toList();

    public /* synthetic */ String scala$collection$mutable$SynchronizedSet$$super$toString();

    public /* synthetic */ void scala$collection$mutable$SynchronizedSet$$super$$less$less(Message var1);

    public /* synthetic */ Set scala$collection$mutable$SynchronizedSet$$super$clone();

    public static /* synthetic */ int size$(SynchronizedSet $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        synchronized (this) {
            int n = this.scala$collection$mutable$SynchronizedSet$$super$size();
            return n;
        }
    }

    public static /* synthetic */ boolean isEmpty$(SynchronizedSet $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedSet$$super$isEmpty();
            return bl;
        }
    }

    public static /* synthetic */ boolean contains$(SynchronizedSet $this, Object elem) {
        return $this.contains(elem);
    }

    @Override
    default public boolean contains(A elem) {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedSet$$super$contains(elem);
            return bl;
        }
    }

    public static /* synthetic */ SynchronizedSet $plus$eq$(SynchronizedSet $this, Object elem) {
        return $this.$plus$eq((A)elem);
    }

    @Override
    default public SynchronizedSet<A> $plus$eq(A elem) {
        synchronized (this) {
            SynchronizedSet synchronizedSet = this.scala$collection$mutable$SynchronizedSet$$super$$plus$eq(elem);
            return synchronizedSet;
        }
    }

    public static /* synthetic */ SynchronizedSet $plus$plus$eq$(SynchronizedSet $this, TraversableOnce xs) {
        return $this.$plus$plus$eq(xs);
    }

    @Override
    default public SynchronizedSet<A> $plus$plus$eq(TraversableOnce<A> xs) {
        synchronized (this) {
            SynchronizedSet synchronizedSet = this.scala$collection$mutable$SynchronizedSet$$super$$plus$plus$eq(xs);
            return synchronizedSet;
        }
    }

    public static /* synthetic */ SynchronizedSet $minus$eq$(SynchronizedSet $this, Object elem) {
        return $this.$minus$eq(elem);
    }

    @Override
    default public SynchronizedSet<A> $minus$eq(A elem) {
        synchronized (this) {
            SynchronizedSet synchronizedSet = this.scala$collection$mutable$SynchronizedSet$$super$$minus$eq(elem);
            return synchronizedSet;
        }
    }

    public static /* synthetic */ SynchronizedSet $minus$minus$eq$(SynchronizedSet $this, TraversableOnce xs) {
        return $this.$minus$minus$eq(xs);
    }

    @Override
    default public SynchronizedSet<A> $minus$minus$eq(TraversableOnce<A> xs) {
        synchronized (this) {
            SynchronizedSet synchronizedSet = this.scala$collection$mutable$SynchronizedSet$$super$$minus$minus$eq(xs);
            return synchronizedSet;
        }
    }

    public static /* synthetic */ void update$(SynchronizedSet $this, Object elem, boolean included) {
        $this.update(elem, included);
    }

    @Override
    default public void update(A elem, boolean included) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedSet$$super$update(elem, included);
            return;
        }
    }

    public static /* synthetic */ boolean add$(SynchronizedSet $this, Object elem) {
        return $this.add(elem);
    }

    @Override
    default public boolean add(A elem) {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedSet$$super$add(elem);
            return bl;
        }
    }

    public static /* synthetic */ boolean remove$(SynchronizedSet $this, Object elem) {
        return $this.remove(elem);
    }

    @Override
    default public boolean remove(A elem) {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedSet$$super$remove(elem);
            return bl;
        }
    }

    public static /* synthetic */ Set intersect$(SynchronizedSet $this, GenSet that) {
        return $this.intersect(that);
    }

    @Override
    default public Set<A> intersect(GenSet<A> that) {
        synchronized (this) {
            Set set = this.scala$collection$mutable$SynchronizedSet$$super$intersect(that);
            return set;
        }
    }

    public static /* synthetic */ void clear$(SynchronizedSet $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedSet$$super$clear();
            return;
        }
    }

    public static /* synthetic */ boolean subsetOf$(SynchronizedSet $this, GenSet that) {
        return $this.subsetOf(that);
    }

    @Override
    default public boolean subsetOf(GenSet<A> that) {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedSet$$super$subsetOf(that);
            return bl;
        }
    }

    public static /* synthetic */ void foreach$(SynchronizedSet $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedSet$$super$foreach(f);
            return;
        }
    }

    public static /* synthetic */ void retain$(SynchronizedSet $this, Function1 p) {
        $this.retain(p);
    }

    @Override
    default public void retain(Function1<A, Object> p) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedSet$$super$retain(p);
            return;
        }
    }

    public static /* synthetic */ List toList$(SynchronizedSet $this) {
        return $this.toList();
    }

    @Override
    default public List<A> toList() {
        synchronized (this) {
            List list = this.scala$collection$mutable$SynchronizedSet$$super$toList();
            return list;
        }
    }

    public static /* synthetic */ String toString$(SynchronizedSet $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        synchronized (this) {
            String string = this.scala$collection$mutable$SynchronizedSet$$super$toString();
            return string;
        }
    }

    public static /* synthetic */ void $less$less$(SynchronizedSet $this, Message cmd) {
        $this.$less$less(cmd);
    }

    @Override
    default public void $less$less(Message<A> cmd) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedSet$$super$$less$less(cmd);
            return;
        }
    }

    public static /* synthetic */ Set clone$(SynchronizedSet $this) {
        return $this.clone();
    }

    @Override
    default public Set<A> clone() {
        synchronized (this) {
            Set set = this.scala$collection$mutable$SynchronizedSet$$super$clone();
            return set;
        }
    }

    public static void $init$(SynchronizedSet $this) {
    }
}

