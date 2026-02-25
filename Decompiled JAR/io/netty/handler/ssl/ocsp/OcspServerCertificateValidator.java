/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.cert.ocsp.BasicOCSPResp
 *  org.bouncycastle.cert.ocsp.OCSPException
 *  org.bouncycastle.cert.ocsp.RevokedStatus
 *  org.bouncycastle.cert.ocsp.SingleResp
 */
package io.netty.handler.ssl.ocsp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.handler.ssl.ocsp.IoTransport;
import io.netty.handler.ssl.ocsp.OcspClient;
import io.netty.handler.ssl.ocsp.OcspResponse;
import io.netty.handler.ssl.ocsp.OcspValidationEvent;
import io.netty.resolver.dns.DnsNameResolver;
import io.netty.resolver.dns.DnsNameResolverBuilder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.cert.ocsp.BasicOCSPResp;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.cert.ocsp.RevokedStatus;
import org.bouncycastle.cert.ocsp.SingleResp;

public class OcspServerCertificateValidator
extends ChannelInboundHandlerAdapter {
    private final boolean closeAndThrowIfNotValid;
    private final boolean validateNonce;
    private final IoTransport ioTransport;
    private final DnsNameResolver dnsNameResolver;

    public OcspServerCertificateValidator() {
        this(false);
    }

    public OcspServerCertificateValidator(boolean validateNonce) {
        this(validateNonce, IoTransport.DEFAULT);
    }

    public OcspServerCertificateValidator(boolean validateNonce, IoTransport ioTransport) {
        this(validateNonce, ioTransport, OcspServerCertificateValidator.createDefaultResolver(ioTransport));
    }

    public OcspServerCertificateValidator(boolean validateNonce, IoTransport ioTransport, DnsNameResolver dnsNameResolver) {
        this(true, validateNonce, ioTransport, dnsNameResolver);
    }

    public OcspServerCertificateValidator(boolean closeAndThrowIfNotValid, boolean validateNonce, IoTransport ioTransport, DnsNameResolver dnsNameResolver) {
        this.closeAndThrowIfNotValid = closeAndThrowIfNotValid;
        this.validateNonce = validateNonce;
        this.ioTransport = ObjectUtil.checkNotNull(ioTransport, "IoTransport");
        this.dnsNameResolver = ObjectUtil.checkNotNull(dnsNameResolver, "DnsNameResolver");
    }

    protected static DnsNameResolver createDefaultResolver(IoTransport ioTransport) {
        return new DnsNameResolverBuilder().eventLoop(ioTransport.eventLoop()).channelFactory(ioTransport.datagramChannel()).socketChannelFactory(ioTransport.socketChannel()).build();
    }

    @Override
    public void userEventTriggered(final ChannelHandlerContext ctx, Object evt) throws Exception {
        ctx.fireUserEventTriggered(evt);
        if (evt instanceof SslHandshakeCompletionEvent) {
            SslHandshakeCompletionEvent sslHandshakeCompletionEvent = (SslHandshakeCompletionEvent)evt;
            if (sslHandshakeCompletionEvent.isSuccess()) {
                Certificate[] certificates = ctx.pipeline().get(SslHandler.class).engine().getSession().getPeerCertificates();
                assert (certificates.length <= 2) : "There must an end-entity certificate and issuer certificate";
                Promise<BasicOCSPResp> ocspRespPromise = OcspClient.query((X509Certificate)certificates[0], (X509Certificate)certificates[1], this.validateNonce, this.ioTransport, this.dnsNameResolver);
                ocspRespPromise.addListener(new GenericFutureListener<Future<BasicOCSPResp>>(){

                    @Override
                    public void operationComplete(Future<BasicOCSPResp> future) throws Exception {
                        if (future.isSuccess()) {
                            Date current = new Date();
                            SingleResp response = ((BasicOCSPResp)future.get()).getResponses()[0];
                            if (!current.after(response.getThisUpdate()) || !current.before(response.getNextUpdate())) {
                                ctx.fireExceptionCaught(new IllegalStateException("OCSP Response is out-of-date"));
                            }
                            OcspResponse.Status status = response.getCertStatus() == null ? OcspResponse.Status.VALID : (response.getCertStatus() instanceof RevokedStatus ? OcspResponse.Status.REVOKED : OcspResponse.Status.UNKNOWN);
                            ctx.fireUserEventTriggered(new OcspValidationEvent(new OcspResponse(status, response.getThisUpdate(), response.getNextUpdate())));
                            if (status != OcspResponse.Status.VALID && OcspServerCertificateValidator.this.closeAndThrowIfNotValid) {
                                ctx.channel().close();
                                ctx.fireExceptionCaught((Throwable)new OCSPException("Certificate not valid. Status: " + (Object)((Object)status)));
                            }
                        } else {
                            ctx.fireExceptionCaught(future.cause());
                        }
                    }
                });
            }
            ctx.pipeline().remove(this);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.channel().close();
    }
}

