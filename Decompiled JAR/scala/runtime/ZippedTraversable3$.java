/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function$;
import scala.Function1;
import scala.Tuple3;
import scala.collection.AbstractTraversable;
import scala.collection.Traversable;
import scala.runtime.LambdaDeserialize;
import scala.runtime.ZippedTraversable3;

public final class ZippedTraversable3$ {
    public static ZippedTraversable3$ MODULE$;

    static {
        new ZippedTraversable3$();
    }

    public <El1, El2, El3> Traversable<Tuple3<El1, El2, El3>> zippedTraversable3ToTraversable(ZippedTraversable3<El1, El2, El3> zz) {
        return new AbstractTraversable<Tuple3<El1, El2, El3>>(zz){
            private final ZippedTraversable3 zz$1;

            public <U> void foreach(Function1<Tuple3<El1, El2, El3>, U> f) {
                if (Function$.MODULE$ == null) {
                    throw null;
                }
                this.zz$1.foreach((arg_0, arg_1, arg_2) -> Function$.$anonfun$untupled$2(f, arg_0, arg_1, arg_2));
            }
            {
                this.zz$1 = zz$1;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$untupled$2(scala.Function1 java.lang.Object java.lang.Object java.lang.Object )}, serializedLambda);
            }
        };
    }

    private ZippedTraversable3$() {
        MODULE$ = this;
    }
}

