/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.SeqLike;
import scala.collection.generic.IsSeqLike;
import scala.collection.generic.IsSeqLike$;
import scala.collection.immutable.StringOps;
import scala.runtime.LambdaDeserialize;

public final class IsSeqLike$ {
    public static IsSeqLike$ MODULE$;
    private final IsSeqLike<String> stringRepr;

    static {
        new IsSeqLike$();
    }

    public IsSeqLike<String> stringRepr() {
        return this.stringRepr;
    }

    public <C, A0> IsSeqLike<C> seqLikeRepr(Function1<C, SeqLike<A0, C>> conv) {
        return new IsSeqLike<C>(conv){
            private final Function1<C, SeqLike<A0, C>> conversion;

            public Function1<C, SeqLike<A0, C>> conversion() {
                return this.conversion;
            }
            {
                this.conversion = conv$1;
            }
        };
    }

    private IsSeqLike$() {
        MODULE$ = this;
        this.stringRepr = new IsSeqLike<String>(){
            private final Function1<String, SeqLike<Object, String>> conversion;

            public Function1<String, SeqLike<Object, String>> conversion() {
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

