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
import com.google.crypto.tink.jwt.JwtInvalidException;
import com.google.crypto.tink.jwt.JwtPublicKeyVerify;
import com.google.crypto.tink.jwt.JwtValidator;
import com.google.crypto.tink.jwt.VerifiedJwt;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

class JwtPublicKeyVerifyWrapper
implements PrimitiveWrapper<JwtPublicKeyVerify, JwtPublicKeyVerify> {
    private static final JwtPublicKeyVerifyWrapper WRAPPER = new JwtPublicKeyVerifyWrapper();

    JwtPublicKeyVerifyWrapper() {
    }

    @Override
    public JwtPublicKeyVerify wrap(PrimitiveSet<JwtPublicKeyVerify> primitives) throws GeneralSecurityException {
        MonitoringClient.Logger logger;
        KeysetHandleInterface keysetHandle = primitives.getKeysetHandle();
        ArrayList<JwtPublicKeyVerifyWithId> allVerifiers = new ArrayList<JwtPublicKeyVerifyWithId>(keysetHandle.size());
        for (int i = 0; i < keysetHandle.size(); ++i) {
            KeysetHandleInterface.Entry entry = keysetHandle.getAt(i);
            allVerifiers.add(new JwtPublicKeyVerifyWithId(primitives.getPrimitiveForEntry(entry), entry.getId()));
        }
        if (!primitives.getAnnotations().isEmpty()) {
            MonitoringClient client = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            logger = client.createLogger(keysetHandle, primitives.getAnnotations(), "jwtverify", "verify");
        } else {
            logger = MonitoringUtil.DO_NOTHING_LOGGER;
        }
        return new WrappedJwtPublicKeyVerify(logger, allVerifiers);
    }

    @Override
    public Class<JwtPublicKeyVerify> getPrimitiveClass() {
        return JwtPublicKeyVerify.class;
    }

    @Override
    public Class<JwtPublicKeyVerify> getInputPrimitiveClass() {
        return JwtPublicKeyVerify.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }

    @Immutable
    private static class WrappedJwtPublicKeyVerify
    implements JwtPublicKeyVerify {
        private final MonitoringClient.Logger logger;
        private final List<JwtPublicKeyVerifyWithId> allVerifiers;

        public WrappedJwtPublicKeyVerify(MonitoringClient.Logger logger, List<JwtPublicKeyVerifyWithId> allVerifiers) {
            this.logger = logger;
            this.allVerifiers = allVerifiers;
        }

        @Override
        public VerifiedJwt verifyAndDecode(String compact, JwtValidator validator) throws GeneralSecurityException {
            GeneralSecurityException interestingException = null;
            for (JwtPublicKeyVerifyWithId verifier : this.allVerifiers) {
                try {
                    VerifiedJwt result2 = verifier.verify.verifyAndDecode(compact, validator);
                    this.logger.log(verifier.id, 1L);
                    return result2;
                }
                catch (GeneralSecurityException e) {
                    if (!(e instanceof JwtInvalidException)) continue;
                    interestingException = e;
                }
            }
            this.logger.logFailure();
            if (interestingException != null) {
                throw interestingException;
            }
            throw new GeneralSecurityException("invalid JWT");
        }
    }

    private static class JwtPublicKeyVerifyWithId {
        final JwtPublicKeyVerify verify;
        final int id;

        JwtPublicKeyVerifyWithId(JwtPublicKeyVerify verify, int id) {
            this.verify = verify;
            this.id = id;
        }
    }
}

