/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.utils.AttachmentUpdate;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.requests.Requester;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public interface AttachedFile
extends Closeable {
    public static final int MAX_DESCRIPTION_LENGTH = 1024;

    @Nonnull
    public static FileUpload fromData(@Nonnull InputStream data, @Nonnull String name) {
        return FileUpload.fromData(data, name);
    }

    @Nonnull
    public static FileUpload fromData(@Nonnull byte[] data, @Nonnull String name) {
        return FileUpload.fromData(data, name);
    }

    @Nonnull
    public static FileUpload fromData(@Nonnull File file, @Nonnull String name) {
        return FileUpload.fromData(file, name);
    }

    @Nonnull
    public static FileUpload fromData(@Nonnull File file) {
        return FileUpload.fromData(file);
    }

    @Nonnull
    public static FileUpload fromData(@Nonnull Path path, @Nonnull String name, OpenOption ... options) {
        return FileUpload.fromData(path, name, options);
    }

    @Nonnull
    public static FileUpload fromData(@Nonnull Path path, OpenOption ... options) {
        return FileUpload.fromData(path, options);
    }

    @Nonnull
    public static AttachmentUpdate fromAttachment(long id) {
        return AttachmentUpdate.fromAttachment(id);
    }

    @Nonnull
    public static AttachmentUpdate fromAttachment(@Nonnull String id) {
        return AttachmentUpdate.fromAttachment(id);
    }

    @Nonnull
    public static AttachmentUpdate fromAttachment(@Nonnull Message.Attachment attachment) {
        return AttachmentUpdate.fromAttachment(attachment);
    }

    public void addPart(@Nonnull MultipartBody.Builder var1, int var2);

    @Nonnull
    public DataObject toAttachmentData(int var1);

    @Nonnull
    public static MultipartBody.Builder createMultipartBody(@Nonnull List<? extends AttachedFile> files2) {
        return AttachedFile.createMultipartBody(files2, (RequestBody)null);
    }

    @Nonnull
    public static MultipartBody.Builder createMultipartBody(@Nonnull List<? extends AttachedFile> files2, @Nullable DataObject payloadJson) {
        RequestBody body = payloadJson != null ? RequestBody.create(payloadJson.toJson(), Requester.MEDIA_TYPE_JSON) : null;
        return AttachedFile.createMultipartBody(files2, body);
    }

    @Nonnull
    public static MultipartBody.Builder createMultipartBody(@Nonnull List<? extends AttachedFile> files2, @Nullable RequestBody payloadJson) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (int i = 0; i < files2.size(); ++i) {
            AttachedFile file = files2.get(i);
            file.addPart(builder, i);
        }
        if (payloadJson != null) {
            builder.addFormDataPart("payload_json", null, payloadJson);
        }
        return builder;
    }

    public void forceClose() throws IOException;
}

