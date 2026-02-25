/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.IterableLike;
import scala.collection.mutable.LinkedListLike;
import scala.collection.mutable.Seq;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005baB\b\u0011!\u0003\r\ta\u0006\u0005\u0006u\u0001!\ta\u000f\u0005\n\u007f\u0001\u0001\r\u00111A\u0005\u0002\u0001C\u0011\"\u0011\u0001A\u0002\u0003\u0007I\u0011\u0001\"\t\u000b\u0015\u0003A\u0011\t$\t\u000b%\u0003A\u0011\t&\t\u000b1\u0003A\u0011A\u001e\t\u000ba\u0003A\u0011B-\t\u000b=\u0004A\u0011\u00029\t\u000bI\u0004A\u0011I:\t\u000bU\u0004A\u0011\t!\t\u000bY\u0004A\u0011I<\t\u000be\u0004A\u0011\t>\t\u000by\u0004A\u0011I@\t\u001d\u0005%\u0001\u0001%A\u0002\u0002\u0003%I!a\u0003\u0002\u0010\t!Bi\\;cY\u0016d\u0015N\\6fI2K7\u000f\u001e'jW\u0016T!!\u0005\n\u0002\u000f5,H/\u00192mK*\u00111\u0003F\u0001\u000bG>dG.Z2uS>t'\"A\u000b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019\u0001dI\u0017\u0014\t\u0001IRd\u000e\t\u00035mi\u0011\u0001F\u0005\u00039Q\u0011a!\u00118z%\u00164\u0007\u0003\u0002\u0010 C1j\u0011\u0001E\u0005\u0003AA\u0011qaU3r\u0019&\\W\r\u0005\u0002#G1\u0001A!\u0002\u0013\u0001\u0005\u0004)#!A!\u0012\u0005\u0019J\u0003C\u0001\u000e(\u0013\tACCA\u0004O_RD\u0017N\\4\u0011\u0005iQ\u0013BA\u0016\u0015\u0005\r\te.\u001f\t\u0003E5\"QA\f\u0001C\u0002=\u0012A\u0001\u00165jgF\u0011a\u0005\r\n\u0004cM2d\u0001\u0002\u001a\u0001\u0001A\u0012A\u0002\u0010:fM&tW-\\3oiz\u00022A\b\u001b\"\u0013\t)\u0004CA\u0002TKF\u0004BA\b\u0001\"YA!a\u0004O\u0011-\u0013\tI\u0004C\u0001\bMS:\\W\r\u001a'jgRd\u0015n[3\u0002\r\u0011Jg.\u001b;%)\u0005a\u0004C\u0001\u000e>\u0013\tqDC\u0001\u0003V]&$\u0018\u0001\u00029sKZ,\u0012\u0001L\u0001\taJ,go\u0018\u0013fcR\u0011Ah\u0011\u0005\b\t\u000e\t\t\u00111\u0001-\u0003\rAH%M\u0001\u0007CB\u0004XM\u001c3\u0015\u00051:\u0005\"\u0002%\u0005\u0001\u0004a\u0013\u0001\u0002;iCR\fa!\u001b8tKJ$HC\u0001\u001fL\u0011\u0015AU\u00011\u0001-\u0003\u0019\u0011X-\\8wK\"\"aA\u0014+W!\ty%+D\u0001Q\u0015\t\tF#\u0001\u0006b]:|G/\u0019;j_:L!a\u0015)\u0003\u00135LwM]1uS>t\u0017%A+\u0002}\u0011{WO\u00197fA1Lgn[3eA1L7\u000f\u001e\u0011o_^\u0004#/Z7pm\u0016\u001c\b\u0005\u001e5fA\r,(O]3oi\u0002rw\u000eZ3!MJ|W\u000e\t;iK\u0002b\u0017n\u001d;/C\u00059\u0016!\u0002\u001a/s9\u0002\u0014AC1u\u0019>\u001c\u0017\r^5p]V\u0011!L\u0018\u000b\u00037*$\"\u0001X3\u0015\u0005u\u0003\u0007C\u0001\u0012_\t\u0015yvA1\u0001&\u0005\u0005!\u0006BB1\b\t\u0003\u0007!-A\u0007p]>+Ho\u00144C_VtGm\u001d\t\u00045\rl\u0016B\u00013\u0015\u0005!a$-\u001f8b[\u0016t\u0004\"\u00024\b\u0001\u00049\u0017!\u00014\u0011\tiAG&X\u0005\u0003SR\u0011\u0011BR;oGRLwN\\\u0019\t\u000b-<\u0001\u0019\u00017\u0002\u00039\u0004\"AG7\n\u00059$\"aA%oi\u0006Yq.\u001e;pM\n|WO\u001c3t)\t1\u0013\u000fC\u0003l\u0011\u0001\u0007A.\u0001\u0003ee>\u0004HC\u0001\u0017u\u0011\u0015Y\u0017\u00021\u0001m\u0003\u0011!\u0018-\u001b7\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0005\u0005B\b\"B6\f\u0001\u0004a\u0017AB;qI\u0006$X\rF\u0002=wrDQa\u001b\u0007A\u00021DQ! \u0007A\u0002\u0005\n\u0011\u0001_\u0001\u0004O\u0016$H\u0003BA\u0001\u0003\u000f\u0001BAGA\u0002C%\u0019\u0011Q\u0001\u000b\u0003\r=\u0003H/[8o\u0011\u0015YW\u00021\u0001m\u00031\u0019X\u000f]3sI%t7/\u001a:u)\ra\u0014Q\u0002\u0005\u0006\u0011:\u0001\r\u0001L\u0005\u0003\u0013bBs\u0001AA\n\u00033\ti\u0002E\u0002\u001b\u0003+I1!a\u0006\u0015\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0003\u00037\t\u0001\r\\8x[1,g/\u001a7!Y&t7.\u001a3!Y&\u001cHo\u001d\u0011be\u0016\u0004C-\u001a9sK\u000e\fG/\u001a3!IV,\u0007\u0005^8!S\u0012Lwn]=oGJ\f7/[3tA%t\u0007%\u001b8uKJ4\u0017mY3!C:$\u0007%\u001b8d_6\u0004H.\u001a;fA\u0019,\u0017\r^;sKN\f#!a\b\u0002\rIr\u0013'\r\u00181\u0001")
public interface DoubleLinkedListLike<A, This extends Seq<A> & DoubleLinkedListLike<A, This>>
extends LinkedListLike<A, This> {
    public /* synthetic */ void scala$collection$mutable$DoubleLinkedListLike$$super$insert(Seq var1);

    public This prev();

    public void prev_$eq(This var1);

    public static /* synthetic */ Seq append$(DoubleLinkedListLike $this, Seq that) {
        return $this.append(that);
    }

    @Override
    default public This append(This that) {
        if (this.isEmpty()) {
            return that;
        }
        if (((LinkedListLike)this.next()).isEmpty()) {
            this.next_$eq(that);
            if (that.nonEmpty()) {
                ((DoubleLinkedListLike)that).prev_$eq((Seq)this.repr());
            }
        } else {
            ((DoubleLinkedListLike)this.next()).append(that);
        }
        return (This)((Seq)this.repr());
    }

    public static /* synthetic */ void insert$(DoubleLinkedListLike $this, Seq that) {
        $this.insert(that);
    }

    @Override
    default public void insert(This that) {
        this.scala$collection$mutable$DoubleLinkedListLike$$super$insert((Seq)that);
        if (that.nonEmpty()) {
            ((DoubleLinkedListLike)that).prev_$eq((Seq)this.repr());
        }
    }

    public static /* synthetic */ void remove$(DoubleLinkedListLike $this) {
        $this.remove();
    }

    default public void remove() {
        if (this.nonEmpty()) {
            ((DoubleLinkedListLike)this.next()).prev_$eq(this.prev());
            if (this.prev() != null) {
                ((LinkedListLike)this.prev()).next_$eq(this.next());
                return;
            }
        }
    }

    private <T> T atLocation(int n, Function1<This, T> f, Function0<T> onOutOfBounds) {
        if (this.isEmpty()) {
            return onOutOfBounds.apply();
        }
        Seq<Object> loc = (Seq)this.repr();
        for (int left = n; left > 0; --left) {
            loc = ((LinkedListLike)((Object)loc)).next();
            if (!((LinkedListLike)((Object)loc)).isEmpty()) continue;
            onOutOfBounds.apply();
        }
        return f.apply(loc);
    }

    private Nothing$ outofbounds(int n) {
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
    }

    public static /* synthetic */ Seq drop$(DoubleLinkedListLike $this, int n) {
        return $this.drop(n);
    }

    @Override
    default public This drop(int n) {
        return (This)((Seq)IterableLike.drop$(this, n));
    }

    public static /* synthetic */ Seq tail$(DoubleLinkedListLike $this) {
        return $this.tail();
    }

    @Override
    default public This tail() {
        return this.drop(1);
    }

    public static /* synthetic */ Object apply$(DoubleLinkedListLike $this, int n) {
        return $this.apply(n);
    }

    @Override
    default public A apply(int n) {
        return (A)this.atLocation(n, (Function1<Seq, Object> & java.io.Serializable & Serializable)x$1 -> ((LinkedListLike)((Object)x$1)).elem(), (Function0<Nothing$> & java.io.Serializable & Serializable)() -> this.outofbounds(n));
    }

    public static /* synthetic */ void update$(DoubleLinkedListLike $this, int n, Object x) {
        $this.update(n, x);
    }

    @Override
    default public void update(int n, A x) {
        this.atLocation(n, (Function1<Seq, Object> & java.io.Serializable & Serializable)x$2 -> {
            DoubleLinkedListLike.$anonfun$update$1(x, x$2);
            return BoxedUnit.UNIT;
        }, (Function0<Nothing$> & java.io.Serializable & Serializable)() -> this.outofbounds(n));
    }

    public static /* synthetic */ Option get$(DoubleLinkedListLike $this, int n) {
        return $this.get(n);
    }

    @Override
    default public Option<A> get(int n) {
        return (Option)this.atLocation(n, (Function1<Seq, Some> & java.io.Serializable & Serializable)x -> new Some(((LinkedListLike)((Object)x)).elem()), (Function0<None$> & java.io.Serializable & Serializable)() -> None$.MODULE$);
    }

    public static /* synthetic */ void $anonfun$update$1(Object x$3, Seq x$2) {
        ((LinkedListLike)((Object)x$2)).elem_$eq(x$3);
    }

    public static void $init$(DoubleLinkedListLike $this) {
    }
}

