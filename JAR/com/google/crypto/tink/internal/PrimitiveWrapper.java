/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.internal;

import com.google.crypto.tink.internal.PrimitiveSet;
import java.security.GeneralSecurityException;

public interface PrimitiveWrapper<B, P> {
    public P wrap(PrimitiveSet<B> var1) throws GeneralSecurityException;

    public Class<P> getPrimitiveClass();

    public Class<B> getInputPrimitiveClass();
}

