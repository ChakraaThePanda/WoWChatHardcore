/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.KeysetHandleInterface;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.jwt.JwtPublicKeySign;
import com.google.crypto.tink.jwt.RawJwt;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

class JwtPublicKeySignWrapper
implements PrimitiveWrapper<JwtPublicKeySign, JwtPublicKeySign> {
    private static final JwtPublicKeySignWrapper WRAPPER = new JwtPublicKeySignWrapper();

    JwtPublicKeySignWrapper() {
    }

    @Override
    public JwtPublicKeySign wrap(PrimitiveSet<JwtPublicKeySign> primitives) throws GeneralSecurityException {
        return new WrappedJwtPublicKeySign(primitives);
    }

    @Override
    public Class<JwtPublicKeySign> getPrimitiveClass() {
        return JwtPublicKeySign.class;
    }

    @Override
    public Class<JwtPublicKeySign> getInputPrimitiveClass() {
        return JwtPublicKeySign.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }

    @Immutable
    private static class WrappedJwtPublicKeySign
    implements JwtPublicKeySign {
        private final JwtPublicKeySign primary;
        private final int primaryKeyId;
        private final MonitoringClient.Logger logger;

        public WrappedJwtPublicKeySign(PrimitiveSet<JwtPublicKeySign> primitives) throws GeneralSecurityException {
            KeysetHandleInterface keysetHandle = primitives.getKeysetHandle();
            this.primary = primitives.getPrimitiveForEntry(keysetHandle.getPrimary());
            this.primaryKeyId = keysetHandle.getPrimary().getId();
            if (!primitives.getAnnotations().isEmpty()) {
                MonitoringClient client = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
                this.logger = client.createLogger(keysetHandle, primitives.getAnnotations(), "jwtsign", "sign");
            } else {
                this.logger = MonitoringUtil.DO_NOTHING_LOGGER;
            }
        }

        @Override
        public String signAndEncode(RawJwt token) throws GeneralSecurityException {
            try {
                String output = this.primary.signAndEncode(token);
                this.logger.log(this.primaryKeyId, 1L);
                return output;
            }
            catch (GeneralSecurityException e) {
                this.logger.logFailure();
                throw e;
            }
        }
    }
}

