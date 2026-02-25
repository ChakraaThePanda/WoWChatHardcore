/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
public final class LegacyFullHybridEncrypt
implements HybridEncrypt {
    private final HybridEncrypt rawHybridEncrypt;
    private final byte[] outputPrefix;

    public static HybridEncrypt create(LegacyProtoKey key) throws GeneralSecurityException {
        byte[] outputPrefix;
        ProtoKeySerialization protoKeySerialization = key.getSerialization(InsecureSecretKeyAccess.get());
        KeyData keyData = KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType()).build();
        HybridEncrypt rawPrimitive = Registry.getPrimitive(keyData, HybridEncrypt.class);
        OutputPrefixType outputPrefixType = protoKeySerialization.getOutputPrefixType();
        switch (outputPrefixType) {
            case RAW: {
                outputPrefix = OutputPrefixUtil.EMPTY_PREFIX.toByteArray();
                break;
            }
            case LEGACY: 
            case CRUNCHY: {
                outputPrefix = OutputPrefixUtil.getLegacyOutputPrefix(key.getIdRequirementOrNull()).toByteArray();
                break;
            }
            case TINK: {
                outputPrefix = OutputPrefixUtil.getTinkOutputPrefix(key.getIdRequirementOrNull()).toByteArray();
                break;
            }
            default: {
                throw new GeneralSecurityException("unknown output prefix type " + outputPrefixType);
            }
        }
        return new LegacyFullHybridEncrypt(rawPrimitive, outputPrefix);
    }

    private LegacyFullHybridEncrypt(HybridEncrypt rawHybridEncrypt, byte[] outputPrefix) {
        this.rawHybridEncrypt = rawHybridEncrypt;
        this.outputPrefix = outputPrefix;
    }

    @Override
    public byte[] encrypt(byte[] plaintext, byte[] contextInfo) throws GeneralSecurityException {
        if (this.outputPrefix.length == 0) {
            return this.rawHybridEncrypt.encrypt(plaintext, contextInfo);
        }
        return Bytes.concat(this.outputPrefix, this.rawHybridEncrypt.encrypt(plaintext, contextInfo));
    }
}

