/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Seq;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSeq;
import scala.collection.parallel.mutable.ParSeq$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.IntRef;

@ScalaSignature(bytes="\u0006\u0001Y3q!\u0002\u0004\u0011\u0002\u0007\u0005Q\u0002C\u0003;\u0001\u0011\u00051\b\u0003\u0004@\u0001\u0001&\t\u0006\u0011\u0005\u0006\u000b\u00021\tA\u0012\u0005\u0006\u001d\u0002!\ta\u0014\u0002\b'\u0016\fH*[6f\u0015\t9\u0001\"A\u0004nkR\f'\r\\3\u000b\u0005%Q\u0011AC2pY2,7\r^5p]*\t1\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00079A\"eE\u0003\u0001\u001fMi\u0003\u0007\u0005\u0002\u0011#5\t!\"\u0003\u0002\u0013\u0015\t1\u0011I\\=SK\u001a\u0004B\u0001F\u000b\u0017C5\t\u0001\"\u0003\u0002\u0006\u0011A\u0011q\u0003\u0007\u0007\u0001\t\u0015I\u0002A1\u0001\u001b\u0005\u0005\t\u0015CA\u000e\u001f!\t\u0001B$\u0003\u0002\u001e\u0015\t9aj\u001c;iS:<\u0007C\u0001\t \u0013\t\u0001#BA\u0002B]f\u0004\"a\u0006\u0012\u0005\r\r\u0002AQ1\u0001%\u0005\u0011!\u0006.[:\u0012\u0005m)#c\u0001\u0014)U\u0019!q\u0005\u0001\u0001&\u00051a$/\u001a4j]\u0016lWM\u001c;?!\u0011I\u0003AF\u0011\u000e\u0003\u0019\u00012!K\u0016\u0017\u0013\tacAA\u0002TKF\u00042!\u000b\u0018\"\u0013\tycAA\u0005DY>tW-\u00192mKB!A#\r\f4\u0013\t\u0011\u0004B\u0001\bQCJ\fG\u000e\\3mSj\f'\r\\3\u0011\u0007QBd#D\u00016\u0015\t9aG\u0003\u00028\u0011\u0005A\u0001/\u0019:bY2,G.\u0003\u0002:k\t1\u0001+\u0019:TKF\fa\u0001J5oSR$C#\u0001\u001f\u0011\u0005Ai\u0014B\u0001 \u000b\u0005\u0011)f.\u001b;\u0002\u0017A\f'oQ8nE&tWM]\u000b\u0002\u0003B!!i\u0011\f4\u001b\u00051\u0014B\u0001#7\u0005!\u0019u.\u001c2j]\u0016\u0014\u0018AB;qI\u0006$X\rF\u0002=\u000f2CQ\u0001S\u0002A\u0002%\u000b1!\u001b3y!\t\u0001\"*\u0003\u0002L\u0015\t\u0019\u0011J\u001c;\t\u000b5\u001b\u0001\u0019\u0001\f\u0002\t\u0015dW-\\\u0001\niJ\fgn\u001d4pe6$\"\u0001U)\u000e\u0003\u0001AQA\u0015\u0003A\u0002M\u000b\u0011A\u001a\t\u0005!Q3b#\u0003\u0002V\u0015\tIa)\u001e8di&|g.\r")
public interface SeqLike<A, This extends SeqLike<A, This> & Seq<A>>
extends scala.collection.SeqLike<A, This>,
Cloneable<This> {
    public static /* synthetic */ Combiner parCombiner$(SeqLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<A, ParSeq<A>> parCombiner() {
        return ParSeq$.MODULE$.newCombiner();
    }

    public void update(int var1, A var2);

    public static /* synthetic */ SeqLike transform$(SeqLike $this, Function1 f) {
        return $this.transform(f);
    }

    default public SeqLike<A, This> transform(Function1<A, A> f) {
        IntRef i = IntRef.create(0);
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)el -> {
            SeqLike.$anonfun$transform$1(this, i, f, el);
            return BoxedUnit.UNIT;
        });
        return this;
    }

    public static /* synthetic */ void $anonfun$transform$1(SeqLike $this, IntRef i$1, Function1 f$1, Object el) {
        $this.update(i$1.elem, f$1.apply(el));
        ++i$1.elem;
    }

    public static void $init$(SeqLike $this) {
    }
}

