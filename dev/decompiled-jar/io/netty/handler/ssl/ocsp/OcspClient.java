/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.asn1.ASN1OctetString
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.DEROctetString
 *  org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers
 *  org.bouncycastle.asn1.x509.AccessDescription
 *  org.bouncycastle.asn1.x509.AuthorityInformationAccess
 *  org.bouncycastle.asn1.x509.Extension
 *  org.bouncycastle.asn1.x509.Extensions
 *  org.bouncycastle.asn1.x509.X509ObjectIdentifiers
 *  org.bouncycastle.cert.X509CertificateHolder
 *  org.bouncycastle.cert.jcajce.JcaX509CertificateHolder
 *  org.bouncycastle.cert.ocsp.BasicOCSPResp
 *  org.bouncycastle.cert.ocsp.CertificateID
 *  org.bouncycastle.cert.ocsp.OCSPException
 *  org.bouncycastle.cert.ocsp.OCSPReqBuilder
 *  org.bouncycastle.cert.ocsp.OCSPResp
 *  org.bouncycastle.operator.ContentVerifierProvider
 *  org.bouncycastle.operator.OperatorCreationException
 *  org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder
 *  org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder
 */
package io.netty.handler.ssl.ocsp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.ssl.ocsp.IoTransport;
import io.netty.handler.ssl.ocsp.OcspHttpHandler;
import io.netty.resolver.dns.DnsNameResolver;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.asn1.x509.AccessDescription;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cert.ocsp.BasicOCSPResp;
import org.bouncycastle.cert.ocsp.CertificateID;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.cert.ocsp.OCSPReqBuilder;
import org.bouncycastle.cert.ocsp.OCSPResp;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

final class OcspClient {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OcspClient.class);
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final int OCSP_RESPONSE_MAX_SIZE = SystemPropertyUtil.getInt("io.netty.ocsp.responseSize", 10240);

    static Promise<BasicOCSPResp> query(final X509Certificate x509Certificate, final X509Certificate issuer, final boolean validateResponseNonce, final IoTransport ioTransport, final DnsNameResolver dnsNameResolver) {
        final EventLoop eventLoop = ioTransport.eventLoop();
        final Promise<BasicOCSPResp> responsePromise = eventLoop.newPromise();
        eventLoop.execute(new Runnable(){

            @Override
            public void run() {
                try {
                    String path;
                    CertificateID certificateID = new CertificateID(new JcaDigestCalculatorProviderBuilder().build().get(CertificateID.HASH_SHA1), (X509CertificateHolder)new JcaX509CertificateHolder(issuer), x509Certificate.getSerialNumber());
                    OCSPReqBuilder builder = new OCSPReqBuilder();
                    builder.addRequest(certificateID);
                    byte[] nonce = new byte[16];
                    SECURE_RANDOM.nextBytes(nonce);
                    final DEROctetString derNonce = new DEROctetString(nonce);
                    builder.setRequestExtensions(new Extensions(new Extension(OCSPObjectIdentifiers.id_pkix_ocsp_nonce, false, (ASN1OctetString)derNonce)));
                    URL uri = new URL(OcspClient.parseOcspUrlFromCertificate(x509Certificate));
                    int port = uri.getPort();
                    if (port == -1) {
                        port = uri.getDefaultPort();
                    }
                    if ((path = uri.getPath()).isEmpty()) {
                        path = "/";
                    } else if (uri.getQuery() != null) {
                        path = path + "?" + uri.getQuery();
                    }
                    Promise ocspResponsePromise = OcspClient.query(eventLoop, Unpooled.wrappedBuffer(builder.build().getEncoded()), uri.getHost(), port, path, ioTransport, dnsNameResolver);
                    ocspResponsePromise.addListener(new GenericFutureListener<Future<OCSPResp>>(){

                        @Override
                        public void operationComplete(Future<OCSPResp> future) throws Exception {
                            if (future.isSuccess()) {
                                BasicOCSPResp resp = (BasicOCSPResp)((OCSPResp)future.get()).getResponseObject();
                                OcspClient.validateResponse(responsePromise, resp, derNonce, issuer, validateResponseNonce);
                            } else {
                                responsePromise.tryFailure(future.cause());
                            }
                        }
                    });
                }
                catch (Exception ex) {
                    responsePromise.tryFailure(ex);
                }
            }
        });
        return responsePromise;
    }

    private static Promise<OCSPResp> query(EventLoop eventLoop, final ByteBuf ocspRequest, final String host, final int port, final String path, IoTransport ioTransport, DnsNameResolver dnsNameResolver) {
        final Promise<OCSPResp> responsePromise = eventLoop.newPromise();
        try {
            final Bootstrap bootstrap = (Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(ioTransport.eventLoop())).option(ChannelOption.TCP_NODELAY, true)).channelFactory(ioTransport.socketChannel())).handler(new Initializer(responsePromise));
            dnsNameResolver.resolve(host).addListener(new FutureListener<InetAddress>(){

                @Override
                public void operationComplete(Future<InetAddress> future) throws Exception {
                    if (future.isSuccess()) {
                        InetAddress hostAddress = (InetAddress)future.get();
                        final ChannelFuture channelFuture = bootstrap.connect(hostAddress, port);
                        channelFuture.addListener(new ChannelFutureListener(){

                            @Override
                            public void operationComplete(ChannelFuture future) {
                                if (future.isSuccess()) {
                                    DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, path, ocspRequest);
                                    request.headers().add((CharSequence)HttpHeaderNames.HOST, (Object)host);
                                    request.headers().add((CharSequence)HttpHeaderNames.USER_AGENT, (Object)"Netty OCSP Client");
                                    request.headers().add((CharSequence)HttpHeaderNames.CONTENT_TYPE, (Object)"application/ocsp-request");
                                    request.headers().add((CharSequence)HttpHeaderNames.ACCEPT_ENCODING, (Object)"application/ocsp-response");
                                    request.headers().add((CharSequence)HttpHeaderNames.CONTENT_LENGTH, (Object)ocspRequest.readableBytes());
                                    channelFuture.channel().writeAndFlush(request);
                                } else {
                                    responsePromise.tryFailure(new IllegalStateException("Connection to OCSP Responder Failed", future.cause()));
                                }
                            }
                        });
                    } else {
                        responsePromise.tryFailure(future.cause());
                    }
                }
            });
        }
        catch (Exception ex) {
            responsePromise.tryFailure(ex);
        }
        return responsePromise;
    }

    private static void validateResponse(Promise<BasicOCSPResp> responsePromise, BasicOCSPResp basicResponse, DEROctetString derNonce, X509Certificate issuer, boolean validateNonce) {
        try {
            int responses = basicResponse.getResponses().length;
            if (responses != 1) {
                throw new IllegalArgumentException("Expected number of responses was 1 but got: " + responses);
            }
            if (validateNonce) {
                OcspClient.validateNonce(basicResponse, derNonce);
            }
            OcspClient.validateSignature(basicResponse, issuer);
            responsePromise.trySuccess(basicResponse);
        }
        catch (Exception ex) {
            responsePromise.tryFailure(ex);
        }
    }

    private static void validateNonce(BasicOCSPResp basicResponse, DEROctetString encodedNonce) throws OCSPException {
        Extension nonceExt = basicResponse.getExtension(OCSPObjectIdentifiers.id_pkix_ocsp_nonce);
        if (nonceExt != null) {
            DEROctetString responseNonceString = (DEROctetString)nonceExt.getExtnValue();
            if (!responseNonceString.equals((ASN1Primitive)encodedNonce)) {
                throw new OCSPException("Nonce does not match");
            }
        } else {
            throw new IllegalArgumentException("Nonce is not present");
        }
    }

    private static void validateSignature(BasicOCSPResp resp, X509Certificate certificate) throws OCSPException {
        try {
            ContentVerifierProvider verifier = new JcaContentVerifierProviderBuilder().build(certificate);
            if (!resp.isSignatureValid(verifier)) {
                throw new OCSPException("OCSP signature is not valid");
            }
        }
        catch (OperatorCreationException e) {
            throw new OCSPException("Error validating OCSP-Signature", (Throwable)e);
        }
    }

    private static String parseOcspUrlFromCertificate(X509Certificate cert) {
        JcaX509CertificateHolder holder;
        try {
            holder = new JcaX509CertificateHolder(cert);
        }
        catch (CertificateEncodingException e) {
            throw new IllegalArgumentException("Error while parsing X509Certificate into JcaX509CertificateHolder", e);
        }
        AuthorityInformationAccess aiaExtension = AuthorityInformationAccess.fromExtensions((Extensions)holder.getExtensions());
        for (AccessDescription accessDescription : aiaExtension.getAccessDescriptions()) {
            if (!accessDescription.getAccessMethod().equals((ASN1Primitive)X509ObjectIdentifiers.id_ad_ocsp)) continue;
            return accessDescription.getAccessLocation().getName().toASN1Primitive().toString();
        }
        throw new NullPointerException("Unable to find OCSP responder URL in Certificate");
    }

    private OcspClient() {
    }

    static {
        logger.debug("-Dio.netty.ocsp.responseSize: {} bytes", (Object)OCSP_RESPONSE_MAX_SIZE);
    }

    static final class Initializer
    extends ChannelInitializer<SocketChannel> {
        private final Promise<OCSPResp> responsePromise;

        Initializer(Promise<OCSPResp> responsePromise) {
            this.responsePromise = ObjectUtil.checkNotNull(responsePromise, "ResponsePromise");
        }

        @Override
        protected void initChannel(SocketChannel socketChannel) {
            ChannelPipeline pipeline = socketChannel.pipeline();
            pipeline.addLast(new HttpClientCodec());
            pipeline.addLast(new HttpObjectAggregator(OCSP_RESPONSE_MAX_SIZE));
            pipeline.addLast(new OcspHttpHandler(this.responsePromise));
        }
    }
}

