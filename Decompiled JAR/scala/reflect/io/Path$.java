/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Stream;
import scala.collection.mutable.ArrayOps;
import scala.io.Codec$;
import scala.reflect.io.Directory;
import scala.reflect.io.File;
import scala.reflect.io.FileOperationException;
import scala.reflect.io.Path;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.util.Random$;

public final class Path$ {
    public static Path$ MODULE$;

    static {
        new Path$();
    }

    public boolean isExtensionJarOrZip(java.io.File jfile) {
        return this.isExtensionJarOrZip(jfile.getName());
    }

    public boolean isExtensionJarOrZip(String name) {
        return name.endsWith(".jar") || name.endsWith(".zip");
    }

    public String extension(String name) {
        int i = name.lastIndexOf(46);
        if (i < 0) {
            return "";
        }
        return name.substring(i + 1).toLowerCase();
    }

    public Path string2path(String s) {
        return this.apply(s);
    }

    public Path jfile2path(java.io.File jfile) {
        return this.apply(jfile);
    }

    public Iterator<Directory> onlyDirs(Iterator<Path> xs) {
        return xs.filter((Function1<Path, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(x$1.isDirectory())).map((Function1<Path, Directory> & java.io.Serializable & Serializable)x$2 -> x$2.toDirectory());
    }

    public List<Directory> onlyDirs(List<Path> xs) {
        return ((List)xs.filter((Function1<Path, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(x$3.isDirectory()))).map((Function1<Path, Directory> & java.io.Serializable & Serializable)x$4 -> x$4.toDirectory(), List$.MODULE$.canBuildFrom());
    }

    public Iterator<File> onlyFiles(Iterator<Path> xs) {
        return xs.filter((Function1<Path, Object> & java.io.Serializable & Serializable)x$5 -> BoxesRunTime.boxToBoolean(x$5.isFile())).map((Function1<Path, File> & java.io.Serializable & Serializable)x$6 -> x$6.toFile());
    }

    public List<Path> roots() {
        return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])java.io.File.listRoots())).toList().map((Function1<java.io.File, Path> & java.io.Serializable & Serializable)jfile -> MODULE$.apply((java.io.File)jfile), List$.MODULE$.canBuildFrom());
    }

    public Path apply(String path) {
        return this.apply(new java.io.File(path));
    }

    public Path apply(java.io.File jfile) {
        Path path;
        block4: {
            try {
                if (Path$.isFile$1(jfile)) {
                    path = new File(jfile, Codec$.MODULE$.fallbackSystemCodec());
                    break block4;
                }
                if (Path$.isDirectory$1(jfile)) {
                    path = new Directory(jfile);
                    break block4;
                }
                return new Path(jfile);
            }
            catch (SecurityException securityException) {
                path = new Path(jfile);
            }
        }
        return path;
    }

    public String randomPrefix() {
        return ((Stream)Random$.MODULE$.alphanumeric().take(6)).mkString("");
    }

    public Nothing$ fail(String msg) {
        throw new FileOperationException(msg);
    }

    private static final boolean isFile$1(java.io.File jfile$1) {
        return jfile$1.isFile();
    }

    private static final boolean isDirectory$1(java.io.File jfile$1) {
        return jfile$1.isDirectory();
    }

    private Path$() {
        MODULE$ = this;
    }
}

