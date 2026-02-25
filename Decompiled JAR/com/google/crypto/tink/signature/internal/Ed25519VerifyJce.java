/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.AccessesPartialKey;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

@Immutable
public final class Ed25519VerifyJce
implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final int PUBLIC_KEY_LEN = 32;
    private static final int SIGNATURE_LEN = 64;
    private static final String ALGORITHM_NAME = "Ed25519";
    private static final byte[] ED25519_X509_PREFIX = new byte[]{48, 42, 48, 5, 6, 3, 43, 101, 112, 3, 33, 0};
    private final PublicKey publicKey;
    private final byte[] outputPrefix;
    private final byte[] messageSuffix;

    static byte[] x509EncodePublicKey(byte[] publicKey) throws GeneralSecurityException {
        if (publicKey.length != 32) {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
        }
        return Bytes.concat(ED25519_X509_PREFIX, publicKey);
    }

    @AccessesPartialKey
    public static PublicKeyVerify create(Ed25519PublicKey key) throws GeneralSecurityException {
        byte[] byArray;
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        byte[] byArray2 = key.getPublicKeyBytes().toByteArray();
        byte[] byArray3 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(Ed25519Parameters.Variant.LEGACY)) {
            byte[] byArray4 = new byte[1];
            byArray = byArray4;
            byArray4[0] = 0;
        } else {
            byArray = new byte[]{};
        }
        return new Ed25519VerifyJce(byArray2, byArray3, byArray);
    }

    Ed25519VerifyJce(byte[] publicKey) throws GeneralSecurityException {
        this(publicKey, new byte[0], new byte[0]);
    }

    private Ed25519VerifyJce(byte[] publicKey, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Ed25519VerifyJce.x509EncodePublicKey(publicKey));
        KeyFactory keyFactory = EngineFactory.KEY_FACTORY.getInstance(ALGORITHM_NAME);
        this.publicKey = keyFactory.generatePublic(spec);
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
    }

    public static boolean isSupported() {
        try {
            KeyFactory unusedKeyFactory = EngineFactory.KEY_FACTORY.getInstance(ALGORITHM_NAME);
            Signature unusedSignature = EngineFactory.SIGNATURE.getInstance(ALGORITHM_NAME);
            return true;
        }
        catch (GeneralSecurityException e) {
            return false;
        }
    }

    @Override
    public void verify(byte[] signature, byte[] data) throws GeneralSecurityException {
        boolean verified;
        if (signature.length != this.outputPrefix.length + 64) {
            throw new GeneralSecurityException(String.format("Invalid signature length: %s", 64));
        }
        if (!Util.isPrefix(this.outputPrefix, signature)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        Signature verifier = EngineFactory.SIGNATURE.getInstance(ALGORITHM_NAME);
        verifier.initVerify(this.publicKey);
        verifier.update(data);
        verifier.update(this.messageSuffix);
        try {
            verified = verifier.verify(signature, this.outputPrefix.length, 64);
        }
        catch (RuntimeException ex) {
            verified = false;
        }
        if (!verified) {
            throw new GeneralSecurityException("Signature check failed.");
        }
    }
}

