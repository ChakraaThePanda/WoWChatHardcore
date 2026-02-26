/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.LinearSeq;
import scala.collection.LinearSeqLike;
import scala.collection.SeqLike;
import scala.collection.mutable.Builder;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\t\u001dc\u0001C\u0010!!\u0003\r\t!\n\u001e\t\u000b}\u0002A\u0011\u0001!\t\u000b\u0011\u0003a\u0011A#\t\u000b%\u0003a\u0011\u0001&\t\u000b-\u0003a\u0011\u0001'\t\u000b5\u0003A\u0011\u0001(\t\u000bI\u0003A\u0011A*\t\u000bY\u0003A\u0011I,\t\u000b\u0005\u0004A\u0011\t2\t\u000b\u0019\u0004A\u0011I4\t\u000b%\u0004A\u0011\t6\t\u000bI\u0004A\u0011I:\t\u000ba\u0004A\u0011I=\t\u000f\u0005\u001d\u0004\u0001\"\u0011\u0002j!9\u00111\u0012\u0001\u0005B\u00055\u0005bBAV\u0001\u0011\u0005\u0013Q\u0016\u0005\u0007\u0003s\u0003A\u0011\t&\t\u000f\u0005m\u0006\u0001\"\u0011\u0002>\"9\u0011\u0011\u0019\u0001\u0005B\u0005\r\u0007bBAd\u0001\u0011\u0005\u0013\u0011\u001a\u0005\b\u0003\u001b\u0004A\u0011IAh\u0011\u001d\tI\u000e\u0001C!\u00037Dq!a8\u0001\t\u0003\n\t\u000fC\u0004\u0002l\u0002!\t%!<\t\u000f\u0005}\b\u0001\"\u0011\u0003\u0002!9!q\u0001\u0001\u0005B\t%\u0001b\u0002B\b\u0001\u0011\u0005#\u0011\u0003\u0005\b\u0005/\u0001A\u0011\tB\r\u0011\u001d\u0011y\u0002\u0001C!\u0005CAqA!\u000b\u0001\t\u0003\u0012Y\u0003\u0003\b\u00034\u0001\u0001\n1!A\u0001\n\u0013\u0011)D!\u0011\u0003%1Kg.Z1s'\u0016\fx\n\u001d;j[&TX\r\u001a\u0006\u0003C\t\n!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0019\u0013!B:dC2\f7\u0001A\u000b\u0004MEZ4c\u0001\u0001(WA\u0011\u0001&K\u0007\u0002E%\u0011!F\t\u0002\u0007\u0003:L(+\u001a4\u0011\t1jsFO\u0007\u0002A%\u0011a\u0006\t\u0002\u000e\u0019&tW-\u0019:TKFd\u0015n[3\u0011\u0005A\nD\u0002\u0001\u0003\u0007e\u0001!)\u0019A\u001a\u0003\u0003\u0005\u000b\"\u0001N\u001c\u0011\u0005!*\u0014B\u0001\u001c#\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u000b\u001d\n\u0005e\u0012#aA!osB\u0011\u0001g\u000f\u0003\u0007y\u0001!)\u0019A\u001f\u0003\tI+\u0007O]\t\u0003iy\u0002B\u0001\f\u00010u\u00051A%\u001b8ji\u0012\"\u0012!\u0011\t\u0003Q\tK!a\u0011\u0012\u0003\tUs\u0017\u000e^\u0001\bSN,U\u000e\u001d;z+\u00051\u0005C\u0001\u0015H\u0013\tA%EA\u0004C_>dW-\u00198\u0002\t!,\u0017\rZ\u000b\u0002_\u0005!A/Y5m+\u0005Q\u0014A\u00027f]\u001e$\b.F\u0001P!\tA\u0003+\u0003\u0002RE\t\u0019\u0011J\u001c;\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0005=\"\u0006\"B+\u0007\u0001\u0004y\u0015!\u00018\u0002\u000f\u0019|'/Z1dQV\u0011\u0001l\u0018\u000b\u0003\u0003fCQAW\u0004A\u0002m\u000b\u0011A\u001a\t\u0005Qq{c,\u0003\u0002^E\tIa)\u001e8di&|g.\r\t\u0003a}#Q\u0001Y\u0004C\u0002M\u0012\u0011!V\u0001\u0007M>\u0014\u0018\r\u001c7\u0015\u0005\u0019\u001b\u0007\"\u00023\t\u0001\u0004)\u0017!\u00019\u0011\t!bvFR\u0001\u0007KbL7\u000f^:\u0015\u0005\u0019C\u0007\"\u00023\n\u0001\u0004)\u0017\u0001C2p]R\f\u0017N\\:\u0016\u0005-|GC\u0001$m\u0011\u0015i'\u00021\u0001o\u0003\u0011)G.Z7\u0011\u0005AzG!\u00029\u000b\u0005\u0004\t(AA!2#\tys'\u0001\u0003gS:$GC\u0001;x!\rASoL\u0005\u0003m\n\u0012aa\u00149uS>t\u0007\"\u00023\f\u0001\u0004)\u0017\u0001\u00034pY\u0012dUM\u001a;\u0016\u0005ilHcA>\u0002dQ\u0011Ap \t\u0003au$QA \u0007C\u0002M\u0012\u0011A\u0011\u0005\b\u0003\u0003a\u0001\u0019AA\u0002\u0003\ty\u0007\u000f\u0005\u0004)\u0003\u000bax\u0006`\u0005\u0004\u0003\u000f\u0011#!\u0003$v]\u000e$\u0018n\u001c83Q\u001dy\u00181BA\t\u0003\u001f\u00022\u0001KA\u0007\u0013\r\tyA\t\u0002\u000fI\u0016\u0004(/Z2bi\u0016$g*Y7fc\u001dy\u00121CA\r\u0003\u0013\u00022\u0001KA\u000b\u0013\r\t9B\t\u0002\u0007'fl'm\u001c72\u0011\r\nY\"!\t\u0002>I#B!a\u0005\u0002\u001e!9\u0011q\u0004\u0013A\u0002\u0005\u001d\u0012\u0001\u00028b[\u0016L1AUA\u0012\u0015\r\t)CI\u0001\u0007'fl'm\u001c7\u0011\t\u0005%\u0012q\u0007\b\u0005\u0003W\t\u0019\u0004E\u0002\u0002.\tj!!a\f\u000b\u0007\u0005EB%\u0001\u0004=e>|GOP\u0005\u0004\u0003k\u0011\u0013A\u0002)sK\u0012,g-\u0003\u0003\u0002:\u0005m\"AB*ue&twMC\u0002\u00026\t\n\u0014bIA \u0003\u000b\n9%!\n\u000f\t\u0005\u0005\u0013Q\t\b\u0005\u0003[\t\u0019%C\u0001$\u0013\r\t)CI\u0019\u0007I\u0005\u0005\u00131I\u00122\u000b\u0015\nY%!\u0014\u0010\u0005\u00055\u0013%\u0001.2\u0013\r\n9#!\u0015\u0002Z\u0005M\u0013\u0002BA*\u0003+\n1\u0004\n7fgNLg.\u001b;%OJ,\u0017\r^3sI\u0011,g-Y;mi\u0012\u0012$bAA,E\u0005qA-\u001a9sK\u000e\fG/\u001a3OC6,\u0017'C\u0012\u0002\\\u0005u\u0013qLA,\u001d\rA\u0013QL\u0005\u0004\u0003/\u0012\u0013'\u0002\u0012)E\u0005\u0005$!B:dC2\f\u0007BBA3\u0019\u0001\u0007A0A\u0001{\u0003%1w\u000e\u001c3SS\u001eDG/\u0006\u0003\u0002l\u0005ED\u0003BA7\u0003\u0013#B!a\u001c\u0002tA\u0019\u0001'!\u001d\u0005\u000byl!\u0019A\u001a\t\u000f\u0005\u0005Q\u00021\u0001\u0002vAA\u0001&!\u00020\u0003_\ny\u0007\u000b\u0005\u0002t\u0005-\u0011\u0011PABc\u001dy\u00121CA>\u0003\u0003\u000b\u0004bIA\u000e\u0003C\tiHU\u0019\nG\u0005}\u0012QIA@\u0003K\td\u0001JA!\u0003\u0007\u001a\u0013'B\u0013\u0002L\u00055\u0013'C\u0012\u0002(\u0005E\u0013QQA*c%\u0019\u00131LA/\u0003\u000f\u000b9&M\u0003#Q\t\n\t\u0007C\u0004\u0002f5\u0001\r!a\u001c\u0002\u0015I,G-^2f\u0019\u00164G/\u0006\u0003\u0002\u0010\u0006ME\u0003BAI\u0003+\u00032\u0001MAJ\t\u0015qhB1\u0001r\u0011\u001d\t\tA\u0004a\u0001\u0003/\u0003\u0002\u0002KA\u0003\u0003#{\u0013\u0011\u0013\u0015\t\u0003+\u000bY!a'\u0002&F:q$a\u0005\u0002\u001e\u0006\r\u0016\u0007C\u0012\u0002\u001c\u0005\u0005\u0012q\u0014*2\u0013\r\ny$!\u0012\u0002\"\u0006\u0015\u0012G\u0002\u0013\u0002B\u0005\r3%M\u0003&\u0003\u0017\ni%M\u0005$\u0003O\t\t&a*\u0002TEJ1%a\u0017\u0002^\u0005%\u0016qK\u0019\u0006E!\u0012\u0013\u0011M\u0001\fe\u0016$WoY3SS\u001eDG/\u0006\u0003\u00020\u0006MF\u0003BAY\u0003k\u00032\u0001MAZ\t\u0015qxB1\u0001r\u0011\u001d\t\ta\u0004a\u0001\u0003o\u0003\u0002\u0002KA\u0003_\u0005E\u0016\u0011W\u0001\u0005Y\u0006\u001cH/\u0001\u0003uC.,Gc\u0001\u001e\u0002@\")Q+\u0005a\u0001\u001f\u0006!AM]8q)\rQ\u0014Q\u0019\u0005\u0006+J\u0001\raT\u0001\nIJ|\u0007OU5hQR$2AOAf\u0011\u0015)6\u00031\u0001P\u0003\u0015\u0019H.[2f)\u0015Q\u0014\u0011[Ak\u0011\u0019\t\u0019\u000e\u0006a\u0001\u001f\u0006!aM]8n\u0011\u0019\t9\u000e\u0006a\u0001\u001f\u0006)QO\u001c;jY\u0006IA/Y6f/\"LG.\u001a\u000b\u0004u\u0005u\u0007\"\u00023\u0016\u0001\u0004)\u0017\u0001B:qC:$B!a9\u0002jB)\u0001&!:;u%\u0019\u0011q\u001d\u0012\u0003\rQ+\b\u000f\\33\u0011\u0015!g\u00031\u0001f\u00031\u0019\u0018-\\3FY\u0016lWM\u001c;t+\u0011\ty/!@\u0015\u0007\u0019\u000b\t\u0010C\u0004\u0002t^\u0001\r!!>\u0002\tQD\u0017\r\u001e\t\u0006Y\u0005]\u00181`\u0005\u0004\u0003s\u0004#aC$f]&#XM]1cY\u0016\u00042\u0001MA\u007f\t\u0015qxC1\u0001r\u00035aWM\\4uQ\u000e{W\u000e]1sKR\u0019qJa\u0001\t\r\t\u0015\u0001\u00041\u0001P\u0003\raWM\\\u0001\fSN$UMZ5oK\u0012\fE\u000fF\u0002G\u0005\u0017AaA!\u0004\u001a\u0001\u0004y\u0015!\u0001=\u0002\u001bM,w-\\3oi2+gn\u001a;i)\u0015y%1\u0003B\u000b\u0011\u0015!'\u00041\u0001f\u0011\u0019\t\u0019N\u0007a\u0001\u001f\u0006Q\u0011N\u001c3fq^CWM]3\u0015\u000b=\u0013YB!\b\t\u000b\u0011\\\u0002\u0019A3\t\r\u0005M7\u00041\u0001P\u00039a\u0017m\u001d;J]\u0012,\u0007p\u00165fe\u0016$Ra\u0014B\u0012\u0005KAQ\u0001\u001a\u000fA\u0002\u0015DaAa\n\u001d\u0001\u0004y\u0015aA3oI\u0006)A/Y5mgV\u0011!Q\u0006\t\u0005Y\t=\"(C\u0002\u00032\u0001\u0012\u0001\"\u0013;fe\u0006$xN]\u0001\u0013gV\u0004XM\u001d\u0013tC6,W\t\\3nK:$8/\u0006\u0003\u00038\t}Bc\u0001$\u0003:!9\u00111\u001f\u0010A\u0002\tm\u0002#\u0002\u0017\u0002x\nu\u0002c\u0001\u0019\u0003@\u0011)aP\bb\u0001c&!\u00111\u001eB\"\u0013\r\u0011)\u0005\t\u0002\r\u0013R,'/\u00192mK2K7.\u001a")
public interface LinearSeqOptimized<A, Repr extends LinearSeqOptimized<A, Repr>>
extends LinearSeqLike<A, Repr> {
    public /* synthetic */ boolean scala$collection$LinearSeqOptimized$$super$sameElements(GenIterable var1);

    @Override
    public boolean isEmpty();

    @Override
    public A head();

    @Override
    public Repr tail();

    public static /* synthetic */ int length$(LinearSeqOptimized $this) {
        return $this.length();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public int length() {
        void var2_2;
        LinearSeqOptimized these = this;
        int len = 0;
        while (!these.isEmpty()) {
            ++len;
            these = (LinearSeqOptimized)these.tail();
        }
        return (int)var2_2;
    }

    public static /* synthetic */ Object apply$(LinearSeqOptimized $this, int n) {
        return $this.apply(n);
    }

    @Override
    default public A apply(int n) {
        Repr rest = this.drop(n);
        if (n < 0 || rest.isEmpty()) {
            throw new IndexOutOfBoundsException(String.valueOf(BoxesRunTime.boxToInteger(n)));
        }
        return rest.head();
    }

    public static /* synthetic */ void foreach$(LinearSeqOptimized $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        LinearSeqOptimized these = this;
        while (!these.isEmpty()) {
            f.apply(these.head());
            these = (LinearSeqOptimized)these.tail();
        }
    }

    public static /* synthetic */ boolean forall$(LinearSeqOptimized $this, Function1 p) {
        return $this.forall(p);
    }

    @Override
    default public boolean forall(Function1<A, Object> p) {
        LinearSeqOptimized these = this;
        while (!these.isEmpty()) {
            if (!BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
                return false;
            }
            these = (LinearSeqOptimized)these.tail();
        }
        return true;
    }

    public static /* synthetic */ boolean exists$(LinearSeqOptimized $this, Function1 p) {
        return $this.exists(p);
    }

    @Override
    default public boolean exists(Function1<A, Object> p) {
        LinearSeqOptimized these = this;
        while (!these.isEmpty()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
                return true;
            }
            these = (LinearSeqOptimized)these.tail();
        }
        return false;
    }

    public static /* synthetic */ boolean contains$(LinearSeqOptimized $this, Object elem) {
        return $this.contains(elem);
    }

    @Override
    default public <A1> boolean contains(A1 elem) {
        LinearSeqOptimized these = this;
        while (!these.isEmpty()) {
            if (BoxesRunTime.equals(these.head(), elem)) {
                return true;
            }
            these = (LinearSeqOptimized)these.tail();
        }
        return false;
    }

    public static /* synthetic */ Option find$(LinearSeqOptimized $this, Function1 p) {
        return $this.find(p);
    }

    @Override
    default public Option<A> find(Function1<A, Object> p) {
        LinearSeqOptimized these = this;
        while (!these.isEmpty()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
                return new Some<A>(these.head());
            }
            these = (LinearSeqOptimized)these.tail();
        }
        return None$.MODULE$;
    }

    public static /* synthetic */ Object foldLeft$(LinearSeqOptimized $this, Object z, Function2 op) {
        return $this.foldLeft(z, op);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <B> B foldLeft(B z, Function2<B, A, B> op) {
        void var3_3;
        B acc = z;
        LinearSeqOptimized these = this;
        while (!these.isEmpty()) {
            acc = op.apply(acc, these.head());
            these = (LinearSeqOptimized)these.tail();
        }
        return var3_3;
    }

    public static /* synthetic */ Object foldRight$(LinearSeqOptimized $this, Object z, Function2 op) {
        return $this.foldRight(z, op);
    }

    @Override
    default public <B> B foldRight(B z, Function2<A, B, B> op) {
        if (this.isEmpty()) {
            return z;
        }
        return op.apply(this.head(), ((LinearSeqOptimized)this.tail()).foldRight(z, op));
    }

    public static /* synthetic */ Object reduceLeft$(LinearSeqOptimized $this, Function2 op) {
        return $this.reduceLeft(op);
    }

    @Override
    default public <B> B reduceLeft(Function2<B, A, B> op) {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.reduceLeft");
        }
        return (B)((LinearSeqOptimized)this.tail()).foldLeft(this.head(), op);
    }

    public static /* synthetic */ Object reduceRight$(LinearSeqOptimized $this, Function2 op) {
        return $this.reduceRight(op);
    }

    @Override
    default public <B> B reduceRight(Function2<A, B, B> op) {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("Nil.reduceRight");
        }
        if (((SeqLike)this.tail()).isEmpty()) {
            return (B)this.head();
        }
        return op.apply(this.head(), ((LinearSeqOptimized)this.tail()).reduceRight(op));
    }

    public static /* synthetic */ Object last$(LinearSeqOptimized $this) {
        return $this.last();
    }

    @Override
    default public A last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        LinearSeqOptimized these = this;
        LinearSeqOptimized nx = (LinearSeqOptimized)this.tail();
        while (!nx.isEmpty()) {
            these = nx;
            nx = (LinearSeqOptimized)nx.tail();
        }
        return these.head();
    }

    public static /* synthetic */ LinearSeqOptimized take$(LinearSeqOptimized $this, int n) {
        return $this.take(n);
    }

    @Override
    default public Repr take(int n) {
        Builder b = this.newBuilder();
        int i = 0;
        LinearSeqOptimized these = (LinearSeqOptimized)this.repr();
        while (!these.isEmpty() && i < n) {
            ++i;
            b.$plus$eq(these.head());
            these = (LinearSeqOptimized)these.tail();
        }
        return (Repr)((LinearSeqOptimized)b.result());
    }

    public static /* synthetic */ LinearSeqOptimized drop$(LinearSeqOptimized $this, int n) {
        return $this.drop(n);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public Repr drop(int n) {
        void var2_2;
        LinearSeqOptimized these = (LinearSeqOptimized)this.repr();
        for (int count = n; !these.isEmpty() && count > 0; --count) {
            these = (LinearSeqOptimized)these.tail();
        }
        return var2_2;
    }

    public static /* synthetic */ LinearSeqOptimized dropRight$(LinearSeqOptimized $this, int n) {
        return $this.dropRight(n);
    }

    @Override
    default public Repr dropRight(int n) {
        Builder b = this.newBuilder();
        LinearSeqOptimized these = this;
        Object lead = this.drop(n);
        while (!lead.isEmpty()) {
            b.$plus$eq(these.head());
            these = (LinearSeqOptimized)these.tail();
            lead = (LinearSeqOptimized)lead.tail();
        }
        return (Repr)((LinearSeqOptimized)b.result());
    }

    public static /* synthetic */ LinearSeqOptimized slice$(LinearSeqOptimized $this, int from, int until) {
        return $this.slice(from, until);
    }

    @Override
    default public Repr slice(int from, int until) {
        LinearSeqOptimized these = (LinearSeqOptimized)this.repr();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int count = RichInt$.MODULE$.max$extension(from, 0);
        if (until <= count) {
            return (Repr)((LinearSeqOptimized)this.newBuilder().result());
        }
        Builder b = this.newBuilder();
        int sliceElems = until - count;
        while (these.nonEmpty() && count > 0) {
            these = (LinearSeqOptimized)these.tail();
            --count;
        }
        while (these.nonEmpty() && sliceElems > 0) {
            --sliceElems;
            b.$plus$eq(these.head());
            these = (LinearSeqOptimized)these.tail();
        }
        return (Repr)((LinearSeqOptimized)b.result());
    }

    public static /* synthetic */ LinearSeqOptimized takeWhile$(LinearSeqOptimized $this, Function1 p) {
        return $this.takeWhile(p);
    }

    @Override
    default public Repr takeWhile(Function1<A, Object> p) {
        Builder b = this.newBuilder();
        LinearSeqOptimized these = this;
        while (!these.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
            b.$plus$eq(these.head());
            these = (LinearSeqOptimized)these.tail();
        }
        return (Repr)((LinearSeqOptimized)b.result());
    }

    public static /* synthetic */ Tuple2 span$(LinearSeqOptimized $this, Function1 p) {
        return $this.span(p);
    }

    @Override
    default public Tuple2<Repr, Repr> span(Function1<A, Object> p) {
        LinearSeqOptimized these = (LinearSeqOptimized)this.repr();
        Builder b = this.newBuilder();
        while (!these.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
            b.$plus$eq(these.head());
            these = (LinearSeqOptimized)these.tail();
        }
        return new Tuple2(b.result(), these);
    }

    public static /* synthetic */ boolean sameElements$(LinearSeqOptimized $this, GenIterable that) {
        return $this.sameElements(that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public <B> boolean sameElements(GenIterable<B> that) {
        if (!(that instanceof LinearSeq)) return this.scala$collection$LinearSeqOptimized$$super$sameElements(that);
        LinearSeq linearSeq = (LinearSeq)that;
        if (this == linearSeq) return true;
        LinearSeqOptimized these = this;
        LinearSeq those = linearSeq;
        while (!these.isEmpty() && !those.isEmpty() && BoxesRunTime.equals(these.head(), those.head())) {
            these = (LinearSeqOptimized)these.tail();
            those = (LinearSeq)those.tail();
        }
        if (!these.isEmpty()) return false;
        if (!those.isEmpty()) return false;
        return true;
    }

    public static /* synthetic */ int lengthCompare$(LinearSeqOptimized $this, int len) {
        return $this.lengthCompare(len);
    }

    @Override
    default public int lengthCompare(int len) {
        if (len < 0) {
            return 1;
        }
        return this.loop$1(0, this, len);
    }

    public static /* synthetic */ boolean isDefinedAt$(LinearSeqOptimized $this, int x) {
        return $this.isDefinedAt(x);
    }

    @Override
    default public boolean isDefinedAt(int x) {
        return x >= 0 && this.lengthCompare(x) > 0;
    }

    public static /* synthetic */ int segmentLength$(LinearSeqOptimized $this, Function1 p, int from) {
        return $this.segmentLength(p, from);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public int segmentLength(Function1<A, Object> p, int from) {
        void var3_3;
        int i = 0;
        Object these = this.drop(from);
        while (!these.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
            ++i;
            these = (LinearSeqOptimized)these.tail();
        }
        return (int)var3_3;
    }

    public static /* synthetic */ int indexWhere$(LinearSeqOptimized $this, Function1 p, int from) {
        return $this.indexWhere(p, from);
    }

    @Override
    default public int indexWhere(Function1<A, Object> p, int from) {
        int i = package$.MODULE$.max(from, 0);
        Object these = this.drop(from);
        while (these.nonEmpty()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
                return i;
            }
            ++i;
            these = (LinearSeqOptimized)these.tail();
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexWhere$(LinearSeqOptimized $this, Function1 p, int end) {
        return $this.lastIndexWhere(p, end);
    }

    @Override
    default public int lastIndexWhere(Function1<A, Object> p, int end) {
        LinearSeqOptimized these = this;
        int last = -1;
        for (int i = 0; !these.isEmpty() && i <= end; ++i) {
            if (BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
                last = i;
            }
            these = (LinearSeqOptimized)these.tail();
        }
        return last;
    }

    public static /* synthetic */ Iterator tails$(LinearSeqOptimized $this) {
        return $this.tails();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public Iterator<Repr> tails() {
        void iterate_f;
        void iterate_start;
        Function1<LinearSeqOptimized, LinearSeqOptimized> & java.io.Serializable & Serializable intersect = (Function1<LinearSeqOptimized, LinearSeqOptimized> & java.io.Serializable & Serializable)x$1 -> (LinearSeqOptimized)x$1.tail();
        Object Repr = this.repr();
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new AbstractIterator<T>(iterate_start, (Function1)iterate_f){
            private boolean first;
            private T acc;
            private final Function1 f$2;

            public boolean hasNext() {
                return true;
            }

            public T next() {
                if (this.first) {
                    this.first = false;
                } else {
                    this.acc = this.f$2.apply(this.acc);
                }
                return this.acc;
            }
            {
                this.f$2 = f$2;
                this.first = true;
                this.acc = start$2;
            }
        }.takeWhile((Function1<LinearSeqOptimized, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(((LinearSeqOptimized)x$2).nonEmpty())).$plus$plus((Function0<Iterator> & java.io.Serializable & Serializable)() -> Iterator$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new LinearSeqOptimized[]{(LinearSeqOptimized)this.newBuilder().result()})));
    }

    private int loop$1(int i, LinearSeqOptimized xs, int len$1) {
        while (true) {
            if (i == len$1) {
                if (xs.isEmpty()) {
                    return 0;
                }
                return 1;
            }
            if (xs.isEmpty()) {
                return -1;
            }
            xs = (LinearSeqOptimized)xs.tail();
            ++i;
        }
    }

    public static void $init$(LinearSeqOptimized $this) {
    }
}

