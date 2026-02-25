/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import scala.runtime.EmptyMethodCache;
import scala.runtime.MethodCache;

public final class StructuralCallSite {
    private Class<?>[] parameterTypes;
    private SoftReference<MethodCache> cache = new SoftReference<EmptyMethodCache>(new EmptyMethodCache());

    private StructuralCallSite(MethodType callType) {
        this.parameterTypes = callType.parameterArray();
    }

    public MethodCache get() {
        MethodCache cache = this.cache.get();
        if (cache == null) {
            cache = new EmptyMethodCache();
            this.cache = new SoftReference<MethodCache>(cache);
        }
        return cache;
    }

    public Method find(Class<?> receiver) {
        return this.get().find(receiver);
    }

    public Method add(Class<?> receiver, Method m) {
        this.cache = new SoftReference<MethodCache>(this.get().add(receiver, m));
        return m;
    }

    public Class<?>[] parameterTypes() {
        return this.parameterTypes;
    }

    public static CallSite bootstrap(MethodHandles.Lookup lookup, String invokedName, MethodType invokedType, MethodType reflectiveCallType) throws Throwable {
        StructuralCallSite structuralCallSite = new StructuralCallSite(reflectiveCallType);
        return new ConstantCallSite(MethodHandles.constant(StructuralCallSite.class, structuralCallSite));
    }
}

