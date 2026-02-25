/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl.ocsp;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.ObjectUtil;

public final class IoTransport {
    private final EventLoop eventLoop;
    private final ChannelFactory<SocketChannel> socketChannel;
    private final ChannelFactory<DatagramChannel> datagramChannel;
    public static final IoTransport DEFAULT = new IoTransport(new NioEventLoopGroup(1).next(), new ChannelFactory<SocketChannel>(){

        @Override
        public SocketChannel newChannel() {
            return new NioSocketChannel();
        }
    }, new ChannelFactory<DatagramChannel>(){

        @Override
        public DatagramChannel newChannel() {
            return new NioDatagramChannel();
        }
    });

    public static IoTransport create(EventLoop eventLoop, ChannelFactory<SocketChannel> socketChannel, ChannelFactory<DatagramChannel> datagramChannel) {
        return new IoTransport(eventLoop, socketChannel, datagramChannel);
    }

    private IoTransport(EventLoop eventLoop, ChannelFactory<SocketChannel> socketChannel, ChannelFactory<DatagramChannel> datagramChannel) {
        this.eventLoop = ObjectUtil.checkNotNull(eventLoop, "EventLoop");
        this.socketChannel = ObjectUtil.checkNotNull(socketChannel, "SocketChannel");
        this.datagramChannel = ObjectUtil.checkNotNull(datagramChannel, "DatagramChannel");
    }

    public EventLoop eventLoop() {
        return this.eventLoop;
    }

    public ChannelFactory<SocketChannel> socketChannel() {
        return this.socketChannel;
    }

    public ChannelFactory<DatagramChannel> datagramChannel() {
        return this.datagramChannel;
    }
}

