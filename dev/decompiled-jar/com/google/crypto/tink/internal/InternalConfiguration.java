/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.internal;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import java.security.GeneralSecurityException;

public abstract class InternalConfiguration
extends Configuration {
    public abstract <P> P getPrimitive(Key var1, Class<P> var2) throws GeneralSecurityException;

    public abstract <B, P> P wrap(PrimitiveSet<B> var1, Class<P> var2) throws GeneralSecurityException;

    public abstract Class<?> getInputPrimitiveClass(Class<?> var1) throws GeneralSecurityException;

    public static InternalConfiguration createFromPrimitiveRegistry(PrimitiveRegistry registry) {
        return new InternalConfigurationImpl(registry);
    }

    private static class InternalConfigurationImpl
    extends InternalConfiguration {
        private final PrimitiveRegistry registry;

        private InternalConfigurationImpl(PrimitiveRegistry registry) {
            this.registry = registry;
        }

        @Override
        public <P> P getPrimitive(Key key, Class<P> primitiveClass) throws GeneralSecurityException {
            return this.registry.getPrimitive(key, primitiveClass);
        }

        @Override
        public Class<?> getInputPrimitiveClass(Class<?> wrapperClassObject) throws GeneralSecurityException {
            return this.registry.getInputPrimitiveClass(wrapperClassObject);
        }

        @Override
        public <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> clazz) throws GeneralSecurityException {
            return this.registry.wrap(primitiveSet, clazz);
        }
    }
}

