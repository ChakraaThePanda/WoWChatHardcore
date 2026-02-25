/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.IOException;
import java.net.URL;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.collection.immutable.StringOps;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.File;
import scala.reflect.io.FileZipArchive;
import scala.reflect.io.ManifestResources;
import scala.reflect.io.URLZipArchive;
import scala.runtime.BoxesRunTime;
import scala.sys.package$;

public final class ZipArchive$ {
    public static ZipArchive$ MODULE$;
    private final boolean closeZipFile;

    static {
        new ZipArchive$();
    }

    public boolean closeZipFile() {
        return this.closeZipFile;
    }

    public final String RootEntry() {
        return "/";
    }

    public FileZipArchive fromFile(File file) {
        return this.fromFile(file.jfile());
    }

    public FileZipArchive fromFile(java.io.File file) {
        try {
            return new FileZipArchive(file);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public URLZipArchive fromURL(URL url) {
        return new URLZipArchive(url);
    }

    public AbstractFile fromManifestURL(URL url) {
        return new ManifestResources(url);
    }

    public String scala$reflect$io$ZipArchive$$dirName(String path) {
        return this.splitPath(path, true);
    }

    public String scala$reflect$io$ZipArchive$$baseName(String path) {
        return this.splitPath(path, false);
    }

    private String splitPath(String path0, boolean front) {
        String path = path0.charAt(path0.length() - 1) == '/' ? path0.substring(0, path0.length() - 1) : path0;
        int idx = path.lastIndexOf(47);
        if (idx < 0) {
            if (front) {
                return "/";
            }
            return path;
        }
        if (front) {
            return path.substring(0, idx + 1);
        }
        return path.substring(idx + 1);
    }

    public static final /* synthetic */ boolean $anonfun$closeZipFile$1(String x$1) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(x$1).toBoolean();
    }

    public static final /* synthetic */ boolean $anonfun$closeZipFile$2() {
        return false;
    }

    private ZipArchive$() {
        MODULE$ = this;
        Option<String> option = package$.MODULE$.props().get("scala.classpath.closeZip");
        if (option == null) {
            throw null;
        }
        Option<String> map_this = option;
        Option option2 = map_this.isEmpty() ? None$.MODULE$ : new Some<Boolean>(BoxesRunTime.boxToBoolean(ZipArchive$.$anonfun$closeZipFile$1(map_this.get())));
        if (option2 == null) {
            throw null;
        }
        Boolean bl = ((Option)option2).isEmpty() ? BoxesRunTime.boxToBoolean(ZipArchive$.$anonfun$closeZipFile$2()) : ((Option)option2).get();
        this.closeZipFile = BoxesRunTime.unboxToBoolean(bl);
    }

    public static final /* synthetic */ Object $anonfun$closeZipFile$1$adapted(String x$1) {
        return BoxesRunTime.boxToBoolean(ZipArchive$.$anonfun$closeZipFile$1(x$1));
    }
}

