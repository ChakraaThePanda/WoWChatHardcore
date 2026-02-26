/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.memcache;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.memcache.MemcacheObject;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public abstract class AbstractMemcacheObject
extends AbstractReferenceCounted
implements MemcacheObject {
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    protected AbstractMemcacheObject() {
    }

    @Override
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override
    public void setDecoderResult(DecoderResult result2) {
        this.decoderResult = ObjectUtil.checkNotNull(result2, "DecoderResult should not be null.");
    }
}

