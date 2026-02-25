/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.NonceBasedStreamingAead;
import com.google.crypto.tink.subtle.StreamSegmentEncrypter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

class StreamingAeadEncryptingStream
extends FilterOutputStream {
    private StreamSegmentEncrypter encrypter;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;
    ByteBuffer ctBuffer;
    boolean open;

    public StreamingAeadEncryptingStream(NonceBasedStreamingAead streamAead, OutputStream ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        super(ciphertextChannel);
        this.encrypter = streamAead.newStreamSegmentEncrypter(associatedData);
        this.plaintextSegmentSize = streamAead.getPlaintextSegmentSize();
        this.ptBuffer = ByteBuffer.allocate(this.plaintextSegmentSize);
        this.ctBuffer = ByteBuffer.allocate(streamAead.getCiphertextSegmentSize());
        this.ptBuffer.limit(this.plaintextSegmentSize - streamAead.getCiphertextOffset());
        ByteBuffer header = this.encrypter.getHeader();
        byte[] headerBytes = new byte[header.remaining()];
        header.get(headerBytes);
        this.out.write(headerBytes);
        this.open = true;
    }

    @Override
    public void write(int b) throws IOException {
        this.write(new byte[]{(byte)b});
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.write(b, 0, b.length);
    }

    @Override
    public synchronized void write(byte[] pt, int offset, int length) throws IOException {
        int remaining;
        int sliceSize;
        if (!this.open) {
            throw new IOException("Trying to write to closed stream");
        }
        int startPosition = offset;
        for (remaining = length; remaining > this.ptBuffer.remaining(); remaining -= sliceSize) {
            sliceSize = this.ptBuffer.remaining();
            ByteBuffer slice = ByteBuffer.wrap(pt, startPosition, sliceSize);
            startPosition += sliceSize;
            try {
                this.ptBuffer.flip();
                this.ctBuffer.clear();
                this.encrypter.encryptSegment(this.ptBuffer, slice, false, this.ctBuffer);
            }
            catch (GeneralSecurityException ex) {
                throw new IOException(ex);
            }
            this.ctBuffer.flip();
            this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
            this.ptBuffer.clear();
            this.ptBuffer.limit(this.plaintextSegmentSize);
        }
        this.ptBuffer.put(pt, startPosition, remaining);
    }

    @Override
    public synchronized void close() throws IOException {
        if (!this.open) {
            return;
        }
        try {
            this.ptBuffer.flip();
            this.ctBuffer.clear();
            this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
        }
        catch (GeneralSecurityException ex) {
            throw new IOException("ptBuffer.remaining():" + this.ptBuffer.remaining() + " ctBuffer.remaining():" + this.ctBuffer.remaining(), ex);
        }
        this.ctBuffer.flip();
        this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
        this.open = false;
        super.close();
    }
}

