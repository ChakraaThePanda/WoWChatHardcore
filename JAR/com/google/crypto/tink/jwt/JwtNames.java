/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.jwt;

final class JwtNames {
    static final String CLAIM_ISSUER = "iss";
    static final String CLAIM_SUBJECT = "sub";
    static final String CLAIM_AUDIENCE = "aud";
    static final String CLAIM_EXPIRATION = "exp";
    static final String CLAIM_NOT_BEFORE = "nbf";
    static final String CLAIM_ISSUED_AT = "iat";
    static final String CLAIM_JWT_ID = "jti";
    static final String HEADER_ALGORITHM = "alg";
    static final String HEADER_KEY_ID = "kid";
    static final String HEADER_TYPE = "typ";
    static final String HEADER_CRITICAL = "crit";

    static void validate(String name) {
        if (JwtNames.isRegisteredName(name)) {
            throw new IllegalArgumentException(String.format("claim '%s' is invalid because it's a registered name; use the corresponding setter method.", name));
        }
    }

    static boolean isRegisteredName(String name) {
        return name.equals(CLAIM_ISSUER) || name.equals(CLAIM_SUBJECT) || name.equals(CLAIM_AUDIENCE) || name.equals(CLAIM_EXPIRATION) || name.equals(CLAIM_NOT_BEFORE) || name.equals(CLAIM_ISSUED_AT) || name.equals(CLAIM_JWT_ID);
    }

    private JwtNames() {
    }
}

