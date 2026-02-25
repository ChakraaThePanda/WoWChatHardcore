/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.Function2;
import scala.Serializable;
import scala.collection.generic.Growable;
import scala.collection.generic.Sizing;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.parallel.Combiner;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u000194qa\u0003\u0007\u0011\u0002\u0007\u0005Q\u0003C\u0003.\u0001\u0011\u0005a\u0006C\u00043\u0001\t\u0007i\u0011A\u001a\t\u000f%\u0003!\u0019!C\u0001\u0015\")1\n\u0001C\u0001\u0019\")\u0001\u000b\u0001C\u0001#\")!\u000b\u0001C\u0001]!)1\u000b\u0001C\u0001)\")\u0011\r\u0001C\u0001E\")a\r\u0001D\u0001O\")\u0001\u000e\u0001D\u0001S\naA*\u0019>z\u0007>l'-\u001b8fe*\u0011QBD\u0001\b[V$\u0018M\u00197f\u0015\ty\u0001#\u0001\u0005qCJ\fG\u000e\\3m\u0015\t\t\"#\u0001\u0006d_2dWm\u0019;j_:T\u0011aE\u0001\u0006g\u000e\fG.Y\u0002\u0001+\u00111\u0012e\u000b\u001e\u0014\u0007\u000192\u0004\u0005\u0002\u001935\t!#\u0003\u0002\u001b%\t1\u0011I\\=SK\u001a\u0004B\u0001H\u000f U5\ta\"\u0003\u0002\u001f\u001d\tA1i\\7cS:,'\u000f\u0005\u0002!C1\u0001A!\u0002\u0012\u0001\u0005\u0004\u0019#\u0001B#mK6\f\"\u0001J\u0014\u0011\u0005a)\u0013B\u0001\u0014\u0013\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u0007\u0015\n\u0005%\u0012\"aA!osB\u0011\u0001e\u000b\u0003\u0007Y\u0001!)\u0019A\u0012\u0003\u0005Q{\u0017A\u0002\u0013j]&$H\u0005F\u00010!\tA\u0002'\u0003\u00022%\t!QK\\5u\u0003\u0015\u0019\u0007.Y5o+\u0005!\u0004cA\u001b8s5\taG\u0003\u0002\u000e!%\u0011\u0001H\u000e\u0002\f\u0003J\u0014\u0018-\u001f\"vM\u001a,'\u000f\u0005\u0002!u\u0011)1\b\u0001b\u0001y\t!!)\u001e4g#\t!SHE\u0002?\u0001\u001a3Aa\u0010\u0001\u0001{\taAH]3gS:,W.\u001a8u}A\u0019\u0011\tR\u0010\u000e\u0003\tS!a\u0011\t\u0002\u000f\u001d,g.\u001a:jG&\u0011QI\u0011\u0002\t\u000fJ|w/\u00192mKB\u0011\u0011iR\u0005\u0003\u0011\n\u0013aaU5{S:<\u0017\u0001\u00037bgR\u0014WO\u001a4\u0016\u0003e\n\u0001\u0002\n9mkN$S-\u001d\u000b\u0003\u001b:k\u0011\u0001\u0001\u0005\u0006\u001f\u0012\u0001\raH\u0001\u0005K2,W.\u0001\u0004sKN,H\u000e\u001e\u000b\u0002U\u0005)1\r\\3be\u000691m\\7cS:,WcA+Y9R\u0011ak\u0018\t\u00059u96\f\u0005\u0002!1\u0012)\u0011l\u0002b\u00015\n\ta*\u0005\u0002%?A\u0011\u0001\u0005\u0018\u0003\u0006;\u001e\u0011\rA\u0018\u0002\u0006\u001d\u0016<Hk\\\t\u0003U\u001dBQ\u0001Y\u0004A\u0002Y\u000bQa\u001c;iKJ\fAa]5{KV\t1\r\u0005\u0002\u0019I&\u0011QM\u0005\u0002\u0004\u0013:$\u0018aD1mY>\u001c\u0017\r^3B]\u0012\u001cu\u000e]=\u0016\u0003)\nqB\\3x\u0019\u0006T\u0018pQ8nE&tWM\u001d\u000b\u0003U2\u0004Ra\u001b\u0001 Uej\u0011\u0001\u0004\u0005\u0006[*\u0001\r\u0001N\u0001\nEV4gm\u00195bS:\u0004")
public interface LazyCombiner<Elem, To, Buff extends Growable<Elem> & Sizing>
extends Combiner<Elem, To> {
    public void scala$collection$parallel$mutable$LazyCombiner$_setter_$lastbuff_$eq(Buff var1);

    public ArrayBuffer<Buff> chain();

    public Buff lastbuff();

    public static /* synthetic */ LazyCombiner $plus$eq$(LazyCombiner $this, Object elem) {
        return $this.$plus$eq((Elem)elem);
    }

    default public LazyCombiner<Elem, To, Buff> $plus$eq(Elem elem) {
        this.lastbuff().$plus$eq(elem);
        return this;
    }

    public static /* synthetic */ Object result$(LazyCombiner $this) {
        return $this.result();
    }

    @Override
    default public To result() {
        return this.allocateAndCopy();
    }

    public static /* synthetic */ void clear$(LazyCombiner $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        this.chain().clear();
    }

    public static /* synthetic */ Combiner combine$(LazyCombiner $this, Combiner other) {
        return $this.combine(other);
    }

    @Override
    default public <N extends Elem, NewTo> Combiner<N, NewTo> combine(Combiner<N, NewTo> other) {
        if (this != other) {
            if (other instanceof LazyCombiner) {
                LazyCombiner that = (LazyCombiner)other;
                return this.newLazyCombiner((ArrayBuffer<Buff>)this.chain().$plus$plus$eq(that.chain()));
            }
            throw new UnsupportedOperationException("Cannot combine with combiner of different type.");
        }
        return this;
    }

    public static /* synthetic */ int size$(LazyCombiner $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        return BoxesRunTime.unboxToInt(this.chain().foldLeft(BoxesRunTime.boxToInteger(0), (Function2<Object, Growable, Object> & java.io.Serializable & Serializable)(x$1, x$2) -> BoxesRunTime.boxToInteger(LazyCombiner.$anonfun$size$1(BoxesRunTime.unboxToInt(x$1), x$2))));
    }

    public To allocateAndCopy();

    public LazyCombiner<Elem, To, Buff> newLazyCombiner(ArrayBuffer<Buff> var1);

    public static /* synthetic */ int $anonfun$size$1(int x$1, Growable x$2) {
        return x$1 + ((Sizing)((Object)x$2)).size();
    }

    public static void $init$(LazyCombiner $this) {
        $this.scala$collection$parallel$mutable$LazyCombiner$_setter_$lastbuff_$eq((Growable)$this.chain().last());
    }
}

