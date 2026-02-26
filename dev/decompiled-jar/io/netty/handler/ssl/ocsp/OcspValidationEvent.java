/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl.ocsp;

import io.netty.handler.ssl.ocsp.OcspResponse;

public final class OcspValidationEvent {
    private final OcspResponse response;

    public OcspValidationEvent(OcspResponse response) {
        this.response = response;
    }

    public OcspResponse response() {
        return this.response;
    }

    public String toString() {
        return "OcspValidationEvent{response=" + this.response + '}';
    }
}

