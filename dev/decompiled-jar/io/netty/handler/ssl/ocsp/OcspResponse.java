/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl.ocsp;

import io.netty.util.internal.ObjectUtil;
import java.util.Date;

public class OcspResponse {
    private final Status status;
    private final Date thisUpdate;
    private final Date nextUpdate;

    public OcspResponse(Status status, Date thisUpdate, Date nextUpdate) {
        this.status = ObjectUtil.checkNotNull(status, "Status");
        this.thisUpdate = ObjectUtil.checkNotNull(thisUpdate, "ThisUpdate");
        this.nextUpdate = ObjectUtil.checkNotNull(nextUpdate, "NextUpdate");
    }

    public Status status() {
        return this.status;
    }

    public Date thisUpdate() {
        return this.thisUpdate;
    }

    public Date nextUpdate() {
        return this.nextUpdate;
    }

    public String toString() {
        return "OcspResponse{status=" + (Object)((Object)this.status) + ", thisUpdate=" + this.thisUpdate + ", nextUpdate=" + this.nextUpdate + '}';
    }

    public static enum Status {
        VALID,
        REVOKED,
        UNKNOWN;

    }
}

