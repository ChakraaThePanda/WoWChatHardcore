/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.GenTraversableLike;
import scala.collection.generic.IsTraversableLike;
import scala.collection.generic.IsTraversableLike$;
import scala.collection.immutable.StringOps;
import scala.runtime.LambdaDeserialize;

public final class IsTraversableLike$ {
    public static IsTraversableLike$ MODULE$;
    private final IsTraversableLike<String> stringRepr;

    static {
        new IsTraversableLike$();
    }

    public IsTraversableLike<String> stringRepr() {
        return this.stringRepr;
    }

    public <C, A0> IsTraversableLike<C> genTraversableLikeRepr(Function1<C, GenTraversableLike<A0, C>> conv) {
        return new IsTraversableLike<C>(conv){
            private final Function1<C, GenTraversableLike<A0, C>> conversion;

            public Function1<C, GenTraversableLike<A0, C>> conversion() {
                return this.conversion;
            }
            {
                this.conversion = conv$1;
            }
        };
    }

    private IsTraversableLike$() {
        MODULE$ = this;
        this.stringRepr = new IsTraversableLike<String>(){
            private final Function1<String, GenTraversableLike<Object, String>> conversion;

            public Function1<String, GenTraversableLike<Object, String>> conversion() {
                return this.conversion;
            }

            public static final /* synthetic */ String $anonfun$conversion$1(String x) {
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return x;
            }
            {
                Function1<String, Object> & java.io.Serializable & Serializable intersect = (Function1<String, Object> & java.io.Serializable & Serializable)x -> new StringOps(anon.1.$anonfun$conversion$1(x));
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                this.conversion = intersect;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$conversion$1$adapted(java.lang.String )}, serializedLambda);
            }
        };
    }
}

