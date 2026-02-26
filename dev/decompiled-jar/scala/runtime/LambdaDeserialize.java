/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.SerializedLambda;
import java.util.HashMap;
import scala.runtime.LambdaDeserializer$;

public final class LambdaDeserialize {
    public static final MethodType DESERIALIZE_LAMBDA_MT = MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/SerializedLambda;)Ljava/lang/Object;", LambdaDeserialize.class.getClassLoader());
    private MethodHandles.Lookup lookup;
    private final HashMap<String, MethodHandle> cache = new HashMap();
    private final LambdaDeserializer$ l = LambdaDeserializer$.MODULE$;
    private final HashMap<String, MethodHandle> targetMethodMap;

    private LambdaDeserialize(MethodHandles.Lookup lookup, MethodHandle[] targetMethods) {
        this.lookup = lookup;
        this.targetMethodMap = new HashMap(targetMethods.length);
        for (MethodHandle targetMethod : targetMethods) {
            MethodHandleInfo info = lookup.revealDirect(targetMethod);
            String key = LambdaDeserialize.nameAndDescriptorKey(info.getName(), info.getMethodType().toMethodDescriptorString());
            this.targetMethodMap.put(key, targetMethod);
        }
    }

    public Object deserializeLambda(SerializedLambda serialized) {
        return this.l.deserializeLambda(this.lookup, this.cache, this.targetMethodMap, serialized);
    }

    public static CallSite bootstrap(MethodHandles.Lookup lookup, String invokedName, MethodType invokedType, MethodHandle ... targetMethods) throws Throwable {
        MethodHandle deserializeLambda = lookup.findVirtual(LambdaDeserialize.class, "deserializeLambda", DESERIALIZE_LAMBDA_MT);
        MethodHandle exact = deserializeLambda.bindTo(new LambdaDeserialize(lookup, targetMethods)).asType(invokedType);
        return new ConstantCallSite(exact);
    }

    public static String nameAndDescriptorKey(String name, String descriptor) {
        return name + descriptor;
    }
}

