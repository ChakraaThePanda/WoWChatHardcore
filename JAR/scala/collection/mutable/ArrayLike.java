/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.IndexedSeqOptimized;
import scala.collection.mutable.WrappedArray$;
import scala.reflect.ScalaSignature;
import scala.runtime.LambdaDeserialize;

@ScalaSignature(bytes="\u0006\u0001-2qa\u0001\u0003\u0011\u0002\u0007\u00051\u0002C\u0003!\u0001\u0011\u0005\u0011\u0005C\u0003&\u0001\u0011\u0005aEA\u0005BeJ\f\u0017\u0010T5lK*\u0011QAB\u0001\b[V$\u0018M\u00197f\u0015\t9\u0001\"\u0001\u0006d_2dWm\u0019;j_:T\u0011!C\u0001\u0006g\u000e\fG.Y\u0002\u0001+\raqCH\n\u0004\u00015\t\u0002C\u0001\b\u0010\u001b\u0005A\u0011B\u0001\t\t\u0005\r\te.\u001f\t\u0005%M)R$D\u0001\u0005\u0013\t!BAA\nJ]\u0012,\u00070\u001a3TKF|\u0005\u000f^5nSj,G\r\u0005\u0002\u0017/1\u0001A!\u0002\r\u0001\u0005\u0004I\"!A!\u0012\u0005ii\u0001C\u0001\b\u001c\u0013\ta\u0002BA\u0004O_RD\u0017N\\4\u0011\u0005YqBAB\u0010\u0001\t\u000b\u0007\u0011D\u0001\u0003SKB\u0014\u0018A\u0002\u0013j]&$H\u0005F\u0001#!\tq1%\u0003\u0002%\u0011\t!QK\\5u\u0003\u0011!W-\u001a9\u0016\u0003\u001d\u00022\u0001K\u0015\u000e\u001b\u00051\u0011B\u0001\u0016\u0007\u0005)Ie\u000eZ3yK\u0012\u001cV-\u001d")
public interface ArrayLike<A, Repr>
extends IndexedSeqOptimized<A, Repr> {
    public static /* synthetic */ IndexedSeq deep$(ArrayLike $this) {
        return $this.deep();
    }

    default public IndexedSeq<Object> deep() {
        return new IndexedSeq<Object>(this){
            private final /* synthetic */ ArrayLike $outer;

            public GenericCompanion<IndexedSeq> companion() {
                return IndexedSeq.companion$(this);
            }

            public IndexedSeq<Object> seq() {
                return IndexedSeq.seq$(this);
            }

            public int hashCode() {
                return IndexedSeqLike.hashCode$(this);
            }

            public IndexedSeq<Object> thisCollection() {
                return IndexedSeqLike.thisCollection$(this);
            }

            public IndexedSeq toCollection(Object repr) {
                return IndexedSeqLike.toCollection$(this, repr);
            }

            public Iterator<Object> iterator() {
                return IndexedSeqLike.iterator$(this);
            }

            public <A1> Buffer<A1> toBuffer() {
                return IndexedSeqLike.toBuffer$(this);
            }

            public int sizeHintIfCheap() {
                return IndexedSeqLike.sizeHintIfCheap$(this);
            }

            public int length() {
                return this.$outer.length();
            }

            public Object apply(int idx) {
                A a = this.$outer.apply(idx);
                Object object = a instanceof Object && a.getClass().isArray() ? WrappedArray$.MODULE$.make(a).deep() : a;
                return object;
            }

            public String stringPrefix() {
                return "Array";
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                IndexedSeqLike.$init$(this);
                IndexedSeq.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableLike scala.Function1 scala.collection.mutable.Map java.lang.Object ), $anonfun$groupBy$3$adapted(scala.Tuple2 ), $anonfun$groupBy$4(scala.collection.mutable.Builder scala.Tuple2 )}, serializedLambda);
            }
        };
    }

    public static void $init$(ArrayLike $this) {
    }
}

