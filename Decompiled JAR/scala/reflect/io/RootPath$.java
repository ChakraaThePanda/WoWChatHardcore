/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashMap;
import scala.Function1;
import scala.Option;
import scala.Serializable;
import scala.collection.IterableLike;
import scala.collection.JavaConverters$;
import scala.reflect.io.RootPath;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

public final class RootPath$ {
    public static RootPath$ MODULE$;
    private FileSystemProvider jarFsProvider;
    private volatile boolean bitmap$0;

    static {
        new RootPath$();
    }

    private FileSystemProvider jarFsProvider$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                Option option = ((IterableLike)JavaConverters$.MODULE$.collectionAsScalaIterableConverter(FileSystemProvider.installedProviders()).asScala()).find((Function1<FileSystemProvider, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(RootPath$.$anonfun$jarFsProvider$1(x$1)));
                if (option == null) {
                    throw null;
                }
                Option getOrElse_this = option;
                if (getOrElse_this.isEmpty()) {
                    throw RootPath$.$anonfun$jarFsProvider$2();
                }
                this.jarFsProvider = (FileSystemProvider)getOrElse_this.get();
                this.bitmap$0 = true;
            }
        }
        return this.jarFsProvider;
    }

    private FileSystemProvider jarFsProvider() {
        if (!this.bitmap$0) {
            return this.jarFsProvider$lzycompute();
        }
        return this.jarFsProvider;
    }

    public RootPath apply(Path path, boolean writable) {
        if (((Object)path.getFileName()).toString().endsWith(".jar")) {
            HashMap<String, String> env = new HashMap<String, String>();
            if (!Files.exists(path.getParent(), new LinkOption[0])) {
                Files.createDirectories(path.getParent(), new FileAttribute[0]);
            }
            if (writable) {
                env.put("create", "true");
                if (Files.exists(path, new LinkOption[0])) {
                    Files.delete(path);
                }
            }
            FileSystem zipfs = this.jarFsProvider().newFileSystem(path, env);
            return new RootPath(zipfs, path){
                private final FileSystem zipfs$1;
                private final Path path$1;

                public Path root() {
                    return this.zipfs$1.getRootDirectories().iterator().next();
                }

                public void close() {
                    this.zipfs$1.close();
                }

                public String toString() {
                    return ((Object)this.path$1).toString();
                }
                {
                    this.zipfs$1 = zipfs$1;
                    this.path$1 = path$1;
                }
            };
        }
        return new RootPath(path){
            private final Path path$1;

            public Path root() {
                return this.path$1;
            }

            public void close() {
            }

            public String toString() {
                return ((Object)this.path$1).toString();
            }
            {
                this.path$1 = path$1;
            }
        };
    }

    public static final /* synthetic */ boolean $anonfun$jarFsProvider$1(FileSystemProvider x$1) {
        String string = x$1.getScheme();
        String string2 = "jar";
        return string != null && string.equals(string2);
    }

    public static final /* synthetic */ Nothing$ $anonfun$jarFsProvider$2() {
        throw new RuntimeException("No jar filesystem provider");
    }

    private RootPath$() {
        MODULE$ = this;
    }
}

