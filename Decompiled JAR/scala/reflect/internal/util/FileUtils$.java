/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import scala.reflect.internal.util.FileUtils;
import scala.reflect.internal.util.FileUtils$AsyncBufferedWriter$;

public final class FileUtils$ {
    public static FileUtils$ MODULE$;
    private final OpenOption[] NO_OPTIONS;

    static {
        new FileUtils$();
    }

    public FileUtils.LineWriter newAsyncBufferedWriter(Path path, Charset charset, OpenOption[] options, boolean threadsafe) {
        CharsetEncoder encoder = charset.newEncoder();
        OutputStreamWriter writer = new OutputStreamWriter(Files.newOutputStream(path, options), encoder);
        return this.newAsyncBufferedWriter(new BufferedWriter(writer), threadsafe);
    }

    /*
     * WARNING - void declaration
     */
    public FileUtils.LineWriter newAsyncBufferedWriter(Writer underlying, boolean threadsafe) {
        void var3_3;
        FileUtils.AsyncBufferedWriter async = new FileUtils.AsyncBufferedWriter(underlying, FileUtils$AsyncBufferedWriter$.MODULE$.$lessinit$greater$default$2());
        if (threadsafe) {
            return new FileUtils.ThreadsafeWriter(async);
        }
        return var3_3;
    }

    public Charset newAsyncBufferedWriter$default$2() {
        return StandardCharsets.UTF_8;
    }

    public OpenOption[] newAsyncBufferedWriter$default$3() {
        return this.NO_OPTIONS();
    }

    public boolean newAsyncBufferedWriter$default$4() {
        return false;
    }

    private OpenOption[] NO_OPTIONS() {
        return this.NO_OPTIONS;
    }

    private FileUtils$() {
        MODULE$ = this;
        this.NO_OPTIONS = new OpenOption[0];
    }
}

