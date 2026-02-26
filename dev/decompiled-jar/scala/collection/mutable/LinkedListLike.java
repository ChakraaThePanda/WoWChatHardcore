/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.NoSuchElementException;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Seq;
import scala.collection.mutable.SeqLike;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005\u001dcaB\u000b\u0017!\u0003\r\t!\b\u0005\u0006{\u0001!\tA\u0010\u0005\n\u0005\u0002\u0001\r\u00111A\u0005\u0002\rC\u0011\u0002\u0012\u0001A\u0002\u0003\u0007I\u0011A#\t\u0013!\u0003\u0001\u0019!a\u0001\n\u0003I\u0005\"\u0003&\u0001\u0001\u0004\u0005\r\u0011\"\u0001L\u0011\u0015i\u0005\u0001\"\u0011O\u0011\u0015\u0011\u0006\u0001\"\u0011T\u0011\u00159\u0006\u0001\"\u0003Y\u0011\u0015\u0019\u0007\u0001\"\u0011D\u0011\u0015!\u0007\u0001\"\u0011J\u0011\u0015)\u0007\u0001\"\u0001g\u0011\u0015I\u0007\u0001\"\u0001k\u0011\u0015a\u0007\u0001\"\u0011n\u0011\u0015\u0001\b\u0001\"\u0003r\u0011\u0015i\b\u0001\"\u0011\u007f\u0011\u001d\t\t\u0001\u0001C\u0001\u0003\u0007Aq!a\u0003\u0001\t\u0003\ti\u0001C\u0004\u0002\u0018\u0001!\t%!\u0007\t\u000f\u0005\r\u0002\u0001\"\u0011\u0002&!9\u00111\u0007\u0001\u0005B\u0005U\"A\u0004'j].,G\rT5ti2K7.\u001a\u0006\u0003/a\tq!\\;uC\ndWM\u0003\u0002\u001a5\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003m\tQa]2bY\u0006\u001c\u0001!F\u0002\u001fSM\u001a2\u0001A\u0010$!\t\u0001\u0013%D\u0001\u001b\u0013\t\u0011#D\u0001\u0004B]f\u0014VM\u001a\t\u0005I\u0015:#'D\u0001\u0017\u0013\t1cCA\u0004TKFd\u0015n[3\u0011\u0005!JC\u0002\u0001\u0003\u0006U\u0001\u0011\ra\u000b\u0002\u0002\u0003F\u0011Af\f\t\u0003A5J!A\f\u000e\u0003\u000f9{G\u000f[5oOB\u0011\u0001\u0005M\u0005\u0003ci\u00111!\u00118z!\tA3\u0007B\u00035\u0001\t\u0007QG\u0001\u0003UQ&\u001c\u0018C\u0001\u00177%\r9\u0014\b\u0010\u0004\u0005q\u0001\u0001aG\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0002%u\u001dJ!a\u000f\f\u0003\u0007M+\u0017\u000f\u0005\u0003%\u0001\u001d\u0012\u0014A\u0002\u0013j]&$H\u0005F\u0001@!\t\u0001\u0003)\u0003\u0002B5\t!QK\\5u\u0003\u0011)G.Z7\u0016\u0003\u001d\n\u0001\"\u001a7f[~#S-\u001d\u000b\u0003\u007f\u0019CqaR\u0002\u0002\u0002\u0003\u0007q%A\u0002yIE\nAA\\3yiV\t!'\u0001\u0005oKb$x\fJ3r)\tyD\nC\u0004H\u000b\u0005\u0005\t\u0019\u0001\u001a\u0002\u000f%\u001cX)\u001c9usV\tq\n\u0005\u0002!!&\u0011\u0011K\u0007\u0002\b\u0005>|G.Z1o\u0003\u0019aWM\\4uQV\tA\u000b\u0005\u0002!+&\u0011aK\u0007\u0002\u0004\u0013:$\u0018a\u00027f]\u001e$\b\u000e\r\u000b\u0004)fS\u0006\"\u0002\"\t\u0001\u0004\u0011\u0004\"B.\t\u0001\u0004!\u0016aA1dG\"\u0012\u0001\"\u0018\t\u0003=\u0006l\u0011a\u0018\u0006\u0003Aj\t!\"\u00198o_R\fG/[8o\u0013\t\u0011wLA\u0004uC&d'/Z2\u0002\t!,\u0017\rZ\u0001\u0005i\u0006LG.\u0001\u0004baB,g\u000e\u001a\u000b\u0003e\u001dDQ\u0001[\u0006A\u0002I\nA\u0001\u001e5bi\u00061\u0011N\\:feR$\"aP6\t\u000b!d\u0001\u0019\u0001\u001a\u0002\t\u0011\u0014x\u000e\u001d\u000b\u0003e9DQa\\\u0007A\u0002Q\u000b\u0011A\\\u0001\u000bCRdunY1uS>tWC\u0001:v)\t\u0019H\u0010\u0006\u0002uoB\u0011\u0001&\u001e\u0003\u0006m:\u0011\ra\u000b\u0002\u0002)\")\u0001P\u0004a\u0001s\u0006\ta\r\u0005\u0003!uJ\"\u0018BA>\u001b\u0005%1UO\\2uS>t\u0017\u0007C\u0003p\u001d\u0001\u0007A+A\u0003baBd\u0017\u0010\u0006\u0002(\u007f\")qn\u0004a\u0001)\u00061Q\u000f\u001d3bi\u0016$RaPA\u0003\u0003\u000fAQa\u001c\tA\u0002QCa!!\u0003\u0011\u0001\u00049\u0013!\u0001=\u0002\u0007\u001d,G\u000f\u0006\u0003\u0002\u0010\u0005U\u0001\u0003\u0002\u0011\u0002\u0012\u001dJ1!a\u0005\u001b\u0005\u0019y\u0005\u000f^5p]\")q.\u0005a\u0001)\u0006A\u0011\u000e^3sCR|'/\u0006\u0002\u0002\u001cA)\u0011QDA\u0010O5\t\u0001$C\u0002\u0002\"a\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\bM>\u0014X-Y2i+\u0011\t9#a\f\u0015\u0007}\nI\u0003\u0003\u0004y'\u0001\u0007\u00111\u0006\t\u0006Ai<\u0013Q\u0006\t\u0004Q\u0005=BABA\u0019'\t\u00071FA\u0001V\u0003\u0015\u0019Gn\u001c8f)\u0005\u0011\u0004f\u0002\u0001\u0002:\u0005}\u00121\t\t\u0004A\u0005m\u0012bAA\u001f5\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0005\u0005\u0005\u0013\u0001\u00197po6bWM^3mA1Lgn[3eA1L7\u000f^:!CJ,\u0007\u0005Z3qe\u0016\u001c\u0017\r^3eA\u0011,X\r\t;pA%$\u0017n\\:z]\u000e\u0014\u0018m]5fg\u0002Jg\u000eI5oi\u0016\u0014h-Y2fA\u0005tG\rI5oG>l\u0007\u000f\\3uK\u00022W-\u0019;ve\u0016\u001c\u0018EAA#\u0003\u0019\u0011d&M\u0019/a\u0001")
public interface LinkedListLike<A, This extends Seq<A> & LinkedListLike<A, This>>
extends SeqLike<A, This> {
    public A elem();

    public void elem_$eq(A var1);

    public This next();

    public void next_$eq(This var1);

    public static /* synthetic */ boolean isEmpty$(LinkedListLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return this.next() == this;
    }

    public static /* synthetic */ int length$(LinkedListLike $this) {
        return $this.length();
    }

    @Override
    default public int length() {
        return this.length0((Seq)this.repr(), 0);
    }

    private int length0(This elem, int acc) {
        while (!((LinkedListLike)elem).isEmpty()) {
            ++acc;
            elem = ((LinkedListLike)elem).next();
        }
        return acc;
    }

    public static /* synthetic */ Object head$(LinkedListLike $this) {
        return $this.head();
    }

    @Override
    default public A head() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elem();
    }

    public static /* synthetic */ Seq tail$(LinkedListLike $this) {
        return $this.tail();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public This tail() {
        void require_requirement;
        boolean bl = this.nonEmpty();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (require_requirement == false) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)LinkedListLike.$anonfun$tail$1()).toString());
        }
        return this.next();
    }

    public static /* synthetic */ Seq append$(LinkedListLike $this, Seq that) {
        return $this.append(that);
    }

    default public This append(This that) {
        if (this.isEmpty()) {
            return that;
        }
        this.loop$1((Seq)this.repr(), (Seq)that);
        return (This)((Seq)this.repr());
    }

    public static /* synthetic */ void insert$(LinkedListLike $this, Seq that) {
        $this.insert(that);
    }

    /*
     * WARNING - void declaration
     */
    default public void insert(This that) {
        void require_requirement;
        boolean bl = this.nonEmpty();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (require_requirement == false) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)LinkedListLike.$anonfun$insert$1()).toString());
        }
        if (that.nonEmpty()) {
            ((LinkedListLike)that).append(this.next());
            this.next_$eq(that);
        }
    }

    public static /* synthetic */ Seq drop$(LinkedListLike $this, int n) {
        return $this.drop(n);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public This drop(int n) {
        void var3_3;
        Seq<Object> these = (Seq)this.repr();
        for (int i = 0; i < n && !((LinkedListLike)((Object)these)).isEmpty(); ++i) {
            these = ((LinkedListLike)((Object)these)).next();
        }
        return var3_3;
    }

    private <T> T atLocation(int n, Function1<This, T> f) {
        This loc = this.drop(n);
        if (loc.nonEmpty()) {
            return f.apply(loc);
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
    }

    public static /* synthetic */ Object apply$(LinkedListLike $this, int n) {
        return $this.apply(n);
    }

    @Override
    default public A apply(int n) {
        return (A)this.atLocation(n, (Function1<Seq, Object> & java.io.Serializable & Serializable)x$1 -> ((LinkedListLike)((Object)x$1)).elem());
    }

    public static /* synthetic */ void update$(LinkedListLike $this, int n, Object x) {
        $this.update(n, x);
    }

    @Override
    default public void update(int n, A x) {
        this.atLocation(n, (Function1<Seq, Object> & java.io.Serializable & Serializable)x$2 -> {
            LinkedListLike.$anonfun$update$1(x, x$2);
            return BoxedUnit.UNIT;
        });
    }

    public static /* synthetic */ Option get$(LinkedListLike $this, int n) {
        return $this.get(n);
    }

    default public Option<A> get(int n) {
        This loc = this.drop(n);
        if (loc.nonEmpty()) {
            return new Some<A>(((LinkedListLike)loc).elem());
        }
        return None$.MODULE$;
    }

    public static /* synthetic */ Iterator iterator$(LinkedListLike $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<A> iterator() {
        return new AbstractIterator<A>(this){
            private LinkedListLike<A, This> elems;

            private LinkedListLike<A, This> elems() {
                return this.elems;
            }

            private void elems_$eq(LinkedListLike<A, This> x$1) {
                this.elems = x$1;
            }

            public boolean hasNext() {
                return this.elems().nonEmpty();
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                void var1_1;
                A res = this.elems().elem();
                this.elems_$eq((LinkedListLike)this.elems().next());
                return var1_1;
            }
            {
                this.elems = $outer;
            }
        };
    }

    public static /* synthetic */ void foreach$(LinkedListLike $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        LinkedListLike these = this;
        while (these.nonEmpty()) {
            f.apply(these.elem());
            these = (LinkedListLike)these.next();
        }
    }

    public static /* synthetic */ Seq clone$(LinkedListLike $this) {
        return $this.clone();
    }

    @Override
    default public This clone() {
        Builder bf = this.newBuilder();
        bf.$plus$plus$eq(this);
        return (This)((Seq)bf.result());
    }

    public static /* synthetic */ String $anonfun$tail$1() {
        return "tail of empty list";
    }

    private void loop$1(Seq x, Seq that$1) {
        while (true) {
            if (((LinkedListLike)((LinkedListLike)((Object)x)).next()).isEmpty()) {
                ((LinkedListLike)((Object)x)).next_$eq(that$1);
                return;
            }
            x = ((LinkedListLike)((Object)x)).next();
        }
    }

    public static /* synthetic */ String $anonfun$insert$1() {
        return "insert into empty list";
    }

    public static /* synthetic */ void $anonfun$update$1(Object x$3, Seq x$2) {
        ((LinkedListLike)((Object)x$2)).elem_$eq(x$3);
    }

    public static void $init$(LinkedListLike $this) {
    }
}

