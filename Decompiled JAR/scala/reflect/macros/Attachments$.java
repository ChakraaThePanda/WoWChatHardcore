/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Serializable;
import scala.reflect.macros.Attachments$;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;

public final class Attachments$ {
    public static Attachments$ MODULE$;
    private final ClassValue<Function1<Object, Object>> scala$reflect$macros$Attachments$$matchesTagCache;

    static {
        new Attachments$();
    }

    public ClassValue<Function1<Object, Object>> scala$reflect$macros$Attachments$$matchesTagCache() {
        return this.scala$reflect$macros$Attachments$$matchesTagCache;
    }

    private Attachments$() {
        MODULE$ = this;
        this.scala$reflect$macros$Attachments$$matchesTagCache = new ClassValue<Function1<Object, Object>>(){

            public Function1<Object, Object> computeValue(Class<?> cls) {
                return (Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(anon.1.$anonfun$computeValue$1(cls, x$1));
            }

            public static final /* synthetic */ boolean $anonfun$computeValue$1(Class cls$1, Object x$1) {
                return cls$1.isInstance(x$1);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$computeValue$1$adapted(java.lang.Class java.lang.Object )}, serializedLambda);
            }
        };
    }
}

