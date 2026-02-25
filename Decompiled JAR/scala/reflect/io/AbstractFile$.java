/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.net.URL;
import scala.io.Codec$;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.File;
import scala.reflect.io.File$;
import scala.reflect.io.Path;
import scala.reflect.io.Path$;
import scala.reflect.io.PlainFile;
import scala.reflect.io.ZipArchive$;

public final class AbstractFile$ {
    public static AbstractFile$ MODULE$;

    static {
        new AbstractFile$();
    }

    public AbstractFile getFile(String path) {
        return this.getFile(File$.MODULE$.apply(Path$.MODULE$.string2path(path), Codec$.MODULE$.fallbackSystemCodec()));
    }

    public AbstractFile getFile(Path path) {
        return this.getFile(path.toFile());
    }

    public AbstractFile getFile(File file) {
        if (!file.isDirectory()) {
            return new PlainFile(file);
        }
        return null;
    }

    public AbstractFile getDirectory(Path path) {
        return this.getDirectory(path.toFile());
    }

    public AbstractFile getDirectory(File file) {
        if (file.isDirectory()) {
            return new PlainFile(file);
        }
        if (file.isFile() && Path$.MODULE$.isExtensionJarOrZip(file.jfile())) {
            return ZipArchive$.MODULE$.fromFile(file);
        }
        return null;
    }

    public AbstractFile getURL(URL url) {
        String string = url.getProtocol();
        String string2 = "file";
        if (string != null && string.equals(string2)) {
            java.io.File f = new java.io.File(url.toURI());
            if (f.isDirectory()) {
                return this.getDirectory(Path$.MODULE$.jfile2path(f));
            }
            return this.getFile(Path$.MODULE$.jfile2path(f));
        }
        return null;
    }

    public AbstractFile getResources(URL url) {
        return ZipArchive$.MODULE$.fromManifestURL(url);
    }

    private AbstractFile$() {
        MODULE$ = this;
    }
}

