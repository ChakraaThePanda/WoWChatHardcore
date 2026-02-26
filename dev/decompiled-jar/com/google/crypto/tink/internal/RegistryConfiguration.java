/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.InternalConfiguration;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.errorprone.annotations.DoNotCall;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

public final class RegistryConfiguration
extends InternalConfiguration {
    private static final RegistryConfiguration CONFIG = new RegistryConfiguration();

    public static RegistryConfiguration get() {
        return CONFIG;
    }

    private RegistryConfiguration() {
    }

    @Override
    public <P> P getPrimitive(Key key, Class<P> primitiveClass) throws GeneralSecurityException {
        return MutablePrimitiveRegistry.globalInstance().getPrimitive(key, primitiveClass);
    }

    @Override
    public <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> clazz) throws GeneralSecurityException {
        return Registry.wrap(primitiveSet, clazz);
    }

    @Override
    @Nullable
    public Class<?> getInputPrimitiveClass(Class<?> wrapperClassObject) {
        return Registry.getInputPrimitive(wrapperClassObject);
    }

    @DoNotCall
    public static InternalConfiguration createFromPrimitiveRegistry(PrimitiveRegistry registry) {
        throw new UnsupportedOperationException("Cannot create RegistryConfiguration from a PrimitiveRegistry");
    }
}

