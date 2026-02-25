/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function$;
import scala.Function1;
import scala.Tuple2;
import scala.collection.AbstractTraversable;
import scala.collection.Traversable;
import scala.runtime.LambdaDeserialize;
import scala.runtime.ZippedTraversable2;

public final class ZippedTraversable2$ {
    public static ZippedTraversable2$ MODULE$;

    static {
        new ZippedTraversable2$();
    }

    public <El1, El2> Traversable<Tuple2<El1, El2>> zippedTraversable2ToTraversable(ZippedTraversable2<El1, El2> zz) {
        return new AbstractTraversable<Tuple2<El1, El2>>(zz){
            private final ZippedTraversable2 zz$1;

            public <U> void foreach(Function1<Tuple2<El1, El2>, U> f) {
                if (Function$.MODULE$ == null) {
                    throw null;
                }
                this.zz$1.foreach((arg_0, arg_1) -> Function$.$anonfun$untupled$1(f, arg_0, arg_1));
            }
            {
                this.zz$1 = zz$1;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$untupled$1(scala.Function1 java.lang.Object java.lang.Object )}, serializedLambda);
            }
        };
    }

    private ZippedTraversable2$() {
        MODULE$ = this;
    }
}

