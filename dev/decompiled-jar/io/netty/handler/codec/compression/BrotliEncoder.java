/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.aayushatharva.brotli4j.encoder.BrotliEncoderChannel
 *  com.aayushatharva.brotli4j.encoder.Encoder
 *  com.aayushatharva.brotli4j.encoder.Encoder$Parameters
 */
package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.BrotliEncoderChannel;
import com.aayushatharva.brotli4j.encoder.Encoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.compression.BrotliOptions;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;

@ChannelHandler.Sharable
public final class BrotliEncoder
extends MessageToByteEncoder<ByteBuf> {
    private static final AttributeKey<Writer> ATTR;
    private static final Method FLUSH_METHOD;
    private final Encoder.Parameters parameters;
    private final boolean isSharable;
    private Writer writer;

    public BrotliEncoder() {
        this(BrotliOptions.DEFAULT);
    }

    public BrotliEncoder(BrotliOptions brotliOptions) {
        this(brotliOptions.parameters());
    }

    public BrotliEncoder(Encoder.Parameters parameters) {
        this(parameters, true);
    }

    public BrotliEncoder(Encoder.Parameters parameters, boolean isSharable) {
        this.parameters = ObjectUtil.checkNotNull(parameters, "Parameters");
        this.isSharable = isSharable;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Writer writer = new Writer(this.parameters, ctx);
        if (this.isSharable) {
            ctx.channel().attr(ATTR).set(writer);
        } else {
            this.writer = writer;
        }
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.finish(ctx);
        super.handlerRemoved(ctx);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
    }

    @Override
    protected ByteBuf allocateBuffer(ChannelHandlerContext ctx, ByteBuf msg, boolean preferDirect) throws Exception {
        if (!msg.isReadable()) {
            return Unpooled.EMPTY_BUFFER;
        }
        Writer writer = this.isSharable ? ctx.channel().attr(ATTR).get() : this.writer;
        if (writer == null) {
            return Unpooled.EMPTY_BUFFER;
        }
        writer.encode(msg, preferDirect);
        return writer.writableBuffer;
    }

    @Override
    public boolean isSharable() {
        return this.isSharable;
    }

    public void finish(ChannelHandlerContext ctx) throws IOException {
        Writer writer = this.isSharable ? (Writer)ctx.channel().attr(ATTR).getAndSet(null) : this.writer;
        if (writer != null) {
            writer.close();
            this.writer = null;
        }
    }

    static {
        Method method;
        ATTR = AttributeKey.valueOf("BrotliEncoderWriter");
        try {
            method = Encoder.class.getDeclaredMethod("flush", new Class[0]);
            method.setAccessible(true);
        }
        catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
        FLUSH_METHOD = method;
    }

    private static final class Writer
    implements WritableByteChannel {
        private ByteBuf writableBuffer;
        private final BrotliEncoderChannel brotliEncoderChannel;
        private final ChannelHandlerContext ctx;
        private boolean isClosed;

        private Writer(Encoder.Parameters parameters, ChannelHandlerContext ctx) throws IOException {
            this.brotliEncoderChannel = new BrotliEncoderChannel((WritableByteChannel)this, parameters);
            this.ctx = ctx;
        }

        private void encode(ByteBuf msg, boolean preferDirect) throws Exception {
            try {
                this.allocate(preferDirect);
                this.brotliEncoderChannel.write(msg.nioBuffer());
                FLUSH_METHOD.invoke(this.brotliEncoderChannel, new Object[0]);
            }
            catch (Exception e) {
                ReferenceCountUtil.release(msg);
                throw e;
            }
        }

        private void allocate(boolean preferDirect) {
            this.writableBuffer = preferDirect ? this.ctx.alloc().ioBuffer() : this.ctx.alloc().buffer();
        }

        @Override
        public int write(ByteBuffer src) throws IOException {
            if (!this.isOpen()) {
                throw new ClosedChannelException();
            }
            return this.writableBuffer.writeBytes(src).readableBytes();
        }

        @Override
        public boolean isOpen() {
            return !this.isClosed;
        }

        @Override
        public void close() {
            final ChannelPromise promise = this.ctx.newPromise();
            this.ctx.executor().execute(new Runnable(){

                @Override
                public void run() {
                    try {
                        Writer.this.finish(promise);
                    }
                    catch (IOException ex) {
                        promise.setFailure(new IllegalStateException("Failed to finish encoding", ex));
                    }
                }
            });
        }

        public void finish(ChannelPromise promise) throws IOException {
            if (!this.isClosed) {
                this.allocate(true);
                try {
                    this.brotliEncoderChannel.close();
                    this.isClosed = true;
                }
                catch (Exception ex) {
                    promise.setFailure(ex);
                    ReferenceCountUtil.release(this.writableBuffer);
                    return;
                }
                this.ctx.writeAndFlush(this.writableBuffer, promise);
            }
        }
    }
}

