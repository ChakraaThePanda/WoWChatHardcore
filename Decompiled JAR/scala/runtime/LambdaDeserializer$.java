/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.SerializedLambda;
import java.util.Map;
import scala.Array$;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.reflect.ClassTag$;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;

public final class LambdaDeserializer$ {
    public static LambdaDeserializer$ MODULE$;
    private final String ScalaSerializable;
    private final String JavaIOSerializable;

    static {
        new LambdaDeserializer$();
    }

    public Object deserializeLambda(MethodHandles.Lookup lookup, Map<String, MethodHandle> cache, Map<String, MethodHandle> targetMethodMap, SerializedLambda serialized) {
        MethodHandle methodHandle;
        Predef$.MODULE$.assert(targetMethodMap != null);
        ClassLoader loader = lookup.lookupClass().getClassLoader();
        Class<?> implClass = loader.loadClass(LambdaDeserializer$.slashDot$1(serialized.getImplClass()));
        String key = LambdaDeserialize.nameAndDescriptorKey(serialized.getImplMethodName(), serialized.getImplMethodSignature());
        if (cache == null) {
            methodHandle = this.makeCallSite$1(loader, serialized, implClass, targetMethodMap, key, lookup).getTarget();
        } else {
            synchronized (cache) {
                MethodHandle methodHandle2;
                MethodHandle methodHandle3 = cache.get(key);
                if (methodHandle3 == null) {
                    MethodHandle temp = this.makeCallSite$1(loader, serialized, implClass, targetMethodMap, key, lookup).getTarget();
                    cache.put(key, temp);
                    methodHandle2 = temp;
                } else {
                    methodHandle2 = methodHandle3;
                }
                // MONITOREXIT @DISABLED, blocks:[0, 1, 5] lbl18 : MonitorExitStatement: MONITOREXIT : cache
                methodHandle = methodHandle2;
            }
        }
        MethodHandle factory2 = methodHandle;
        Object[] captures = (Object[])Array$.MODULE$.tabulate(serialized.getCapturedArgCount(), (Function1<Object, Object> & java.io.Serializable & Serializable)n -> serialized.getCapturedArg(BoxesRunTime.unboxToInt(n)), ClassTag$.MODULE$.Object());
        return factory2.invokeWithArguments(captures);
    }

    private String ScalaSerializable() {
        return this.ScalaSerializable;
    }

    private String JavaIOSerializable() {
        return this.JavaIOSerializable;
    }

    private static final String slashDot$1(String name) {
        return name.replaceAll("/", ".");
    }

    private static final MethodType parseDescriptor$1(String s, ClassLoader loader$1) {
        return MethodType.fromMethodDescriptorString(s, loader$1);
    }

    private final CallSite makeCallSite$1(ClassLoader loader$1, SerializedLambda serialized$1, Class implClass$1, Map targetMethodMap$1, String key$1, MethodHandles.Lookup lookup$1) {
        MethodType methodType;
        MethodType funcInterfaceSignature = LambdaDeserializer$.parseDescriptor$1(serialized$1.getFunctionalInterfaceMethodSignature(), loader$1);
        MethodType instantiated = LambdaDeserializer$.parseDescriptor$1(serialized$1.getInstantiatedMethodType(), loader$1);
        Class<?> functionalInterfaceClass = loader$1.loadClass(LambdaDeserializer$.slashDot$1(serialized$1.getFunctionalInterfaceClass()));
        MethodType implMethodSig = LambdaDeserializer$.parseDescriptor$1(serialized$1.getImplMethodSignature(), loader$1);
        switch (serialized$1.getImplMethodKind()) {
            case 6: 
            case 8: {
                methodType = implMethodSig;
                break;
            }
            default: {
                methodType = implMethodSig.insertParameterTypes(0, implClass$1);
            }
        }
        MethodType withReceiver = methodType;
        int lambdaArity = funcInterfaceSignature.parameterCount();
        int from = withReceiver.parameterCount() - lambdaArity;
        int to = withReceiver.parameterCount();
        MethodType invokedType = withReceiver.dropParameterTypes(from, to).changeReturnType(functionalInterfaceClass);
        if (!targetMethodMap$1.containsKey(key$1)) {
            throw new IllegalArgumentException("Illegal lambda deserialization");
        }
        MethodHandle implMethod = (MethodHandle)targetMethodMap$1.get(key$1);
        int flags = 3;
        boolean isScalaFunction = functionalInterfaceClass.getName().startsWith("scala.Function");
        Class<?> markerInterface = loader$1.loadClass(isScalaFunction ? this.ScalaSerializable() : this.JavaIOSerializable());
        return LambdaMetafactory.altMetafactory(lookup$1, serialized$1.getFunctionalInterfaceMethodName(), invokedType, funcInterfaceSignature, implMethod, instantiated, BoxesRunTime.boxToInteger(flags), BoxesRunTime.boxToInteger(1), markerInterface, BoxesRunTime.boxToInteger(0));
    }

    private LambdaDeserializer$() {
        MODULE$ = this;
        this.ScalaSerializable = "scala.Serializable";
        this.JavaIOSerializable = "java.io.Serializable";
    }
}

