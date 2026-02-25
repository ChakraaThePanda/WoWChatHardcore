/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.GenTraversableOnce;
import scala.collection.generic.IsTraversableOnce;
import scala.collection.generic.IsTraversableOnce$;
import scala.collection.immutable.StringOps;
import scala.runtime.LambdaDeserialize;

public final class IsTraversableOnce$ {
    public static IsTraversableOnce$ MODULE$;
    private final IsTraversableOnce<String> stringRepr;

    static {
        new IsTraversableOnce$();
    }

    public IsTraversableOnce<String> stringRepr() {
        return this.stringRepr;
    }

    public <C, A0> IsTraversableOnce<C> genTraversableLikeRepr(Function1<C, GenTraversableOnce<A0>> conv) {
        return new IsTraversableOnce<C>(conv){
            private final Function1<C, GenTraversableOnce<A0>> conversion;

            public Function1<C, GenTraversableOnce<A0>> conversion() {
                return this.conversion;
            }
            {
                this.conversion = conv$1;
            }
        };
    }

    private IsTraversableOnce$() {
        MODULE$ = this;
        this.stringRepr = new IsTraversableOnce<String>(){
            private final Function1<String, GenTraversableOnce<Object>> conversion;

            public Function1<String, GenTraversableOnce<Object>> conversion() {
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

