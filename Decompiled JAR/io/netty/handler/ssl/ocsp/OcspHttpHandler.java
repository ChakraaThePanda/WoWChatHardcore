/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.cert.ocsp.OCSPException
 *  org.bouncycastle.cert.ocsp.OCSPResp
 */
package io.netty.handler.ssl.ocsp;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.cert.ocsp.OCSPResp;

final class OcspHttpHandler
extends SimpleChannelInboundHandler<FullHttpResponse> {
    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(OcspHttpHandler.class);
    private final Promise<OCSPResp> responseFuture;
    public static final String OCSP_REQUEST_TYPE = "application/ocsp-request";
    public static final String OCSP_RESPONSE_TYPE = "application/ocsp-response";

    OcspHttpHandler(Promise<OCSPResp> responsePromise) {
        this.responseFuture = ObjectUtil.checkNotNull(responsePromise, "ResponsePromise");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse response) throws Exception {
        try {
            String contentType;
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Received OCSP HTTP Response: {}", (Object)response);
            }
            if ((contentType = response.headers().get(HttpHeaderNames.CONTENT_TYPE)) == null) {
                throw new OCSPException("HTTP Response does not contain 'CONTENT-TYPE' header");
            }
            if (!contentType.equalsIgnoreCase(OCSP_RESPONSE_TYPE)) {
                throw new OCSPException("Response Content-Type was: " + contentType + "; Expected: " + OCSP_RESPONSE_TYPE);
            }
            if (response.status() != HttpResponseStatus.OK) {
                throw new IllegalArgumentException("HTTP Response Code was: " + response.status().code() + "; Expected: 200");
            }
            this.responseFuture.trySuccess(new OCSPResp(ByteBufUtil.getBytes(response.content())));
        }
        finally {
            ctx.channel().close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        this.responseFuture.tryFailure(cause);
    }
}

