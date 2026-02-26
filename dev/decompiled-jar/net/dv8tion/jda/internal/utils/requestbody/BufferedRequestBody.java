/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.utils.requestbody;

import java.io.IOException;
import javax.annotation.Nonnull;
import net.dv8tion.jda.internal.utils.IOUtil;
import net.dv8tion.jda.internal.utils.requestbody.TypedBody;
import okhttp3.MediaType;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class BufferedRequestBody
extends TypedBody<BufferedRequestBody> {
    private final Source source;
    private byte[] data;

    public BufferedRequestBody(Source source2, MediaType type) {
        super(type);
        this.source = source2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @Nonnull
    public BufferedRequestBody withType(@Nonnull MediaType type) {
        if (type.equals(this.type)) {
            return this;
        }
        Source source2 = this.source;
        synchronized (source2) {
            BufferedRequestBody copy = new BufferedRequestBody(this.source, type);
            copy.data = this.data;
            return copy;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeTo(@Nonnull BufferedSink sink2) throws IOException {
        Source source2 = this.source;
        synchronized (source2) {
            if (this.data != null) {
                sink2.write(this.data);
                return;
            }
            try (BufferedSource s = Okio.buffer(this.source);){
                this.data = s.readByteArray();
                sink2.write(this.data);
            }
        }
    }

    protected void finalize() {
        IOUtil.silentClose(this.source);
    }
}

