/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.utils.requestbody;

import java.io.IOException;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.dv8tion.jda.internal.utils.requestbody.TypedBody;
import okhttp3.MediaType;
import okio.BufferedSink;
import okio.Source;

public class DataSupplierBody
extends TypedBody<DataSupplierBody> {
    private final Supplier<? extends Source> streamSupply;

    public DataSupplierBody(MediaType type, Supplier<? extends Source> streamSupply) {
        super(type);
        this.streamSupply = streamSupply;
    }

    @Override
    @Nonnull
    public DataSupplierBody withType(@Nonnull MediaType newType) {
        if (this.type.equals(newType)) {
            return this;
        }
        return new DataSupplierBody(newType, this.streamSupply);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeTo(@Nonnull BufferedSink bufferedSink) throws IOException {
        Supplier<? extends Source> supplier = this.streamSupply;
        synchronized (supplier) {
            try (Source stream = this.streamSupply.get();){
                bufferedSink.writeAll(stream);
            }
        }
    }
}

