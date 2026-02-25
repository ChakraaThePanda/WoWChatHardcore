/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NotDirectoryException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.JavaConverters$;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.Directory;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u00055b!\u0002\r\u001a\u0001uy\u0002\u0002\u0003\u0013\u0001\u0005\u0003\u0005\u000b\u0011\u0002\u0014\t\u000bA\u0002A\u0011A\u0019\t\u000b%\u0002A\u0011\t\u001b\t\u0011i\u0002\u0001R1A\u0005BmBQa\u0012\u0001\u0005B!Cq!\u0014\u0001C\u0002\u0013%a\n\u0003\u0004U\u0001\u0001\u0006Ia\u0014\u0005\u0006+\u0002!\tA\u0014\u0005\u0006-\u0002!\tA\u0014\u0005\u0006/\u0002!\t\u0001\u0017\u0005\u00063\u0002!\tE\u0017\u0005\u00067\u0002!\t\u0005\u0018\u0005\u0006A\u0002!\t%\u0019\u0005\u0006K\u0002!\tE\u001a\u0005\u0006W\u0002!\t\u0005\u001c\u0005\u0006[\u0002!\tE\u001c\u0005\u0006o\u0002!\t\u0001\u001f\u0005\u0006s\u0002!\tA\u001f\u0005\u0006}\u0002!\ta \u0005\b\u0003\u001f\u0001A\u0011AA\t\u0011\u001d\tI\u0002\u0001C\u0001\u00037Aq!a\t\u0001\t\u0003\tY\u0002C\u0004\u0002&\u0001!\t!a\n\u0003\u0019Ac\u0017-\u001b8OS>4\u0015\u000e\\3\u000b\u0005iY\u0012AA5p\u0015\taR$A\u0004sK\u001adWm\u0019;\u000b\u0003y\tQa]2bY\u0006\u001c\"\u0001\u0001\u0011\u0011\u0005\u0005\u0012S\"A\r\n\u0005\rJ\"\u0001D!cgR\u0014\u0018m\u0019;GS2,\u0017a\u00028j_B\u000bG\u000f[\u0002\u0001!\t9c&D\u0001)\u0015\tI#&\u0001\u0003gS2,'BA\u0016-\u0003\rq\u0017n\u001c\u0006\u0002[\u0005!!.\u0019<b\u0013\ty\u0003F\u0001\u0003QCRD\u0017A\u0002\u001fj]&$h\b\u0006\u00023gA\u0011\u0011\u0005\u0001\u0005\u0006I\t\u0001\rAJ\u000b\u0002kA\u0011a\u0007O\u0007\u0002o)\u0011!\u0004L\u0005\u0003s]\u0012AAR5mK\u0006i1-\u00198p]&\u001c\u0017\r\u001c)bi\",\u0012\u0001\u0010\t\u0003{\u0011s!A\u0010\"\u0011\u0005}jR\"\u0001!\u000b\u0005\u0005+\u0013A\u0002\u001fs_>$h(\u0003\u0002D;\u00051\u0001K]3eK\u001aL!!\u0012$\u0003\rM#(/\u001b8h\u0015\t\u0019U$\u0001\tv]\u0012,'\u000f\\=j]\u001e\u001cv.\u001e:dKV\t\u0011\nE\u0002K\u0017Jj\u0011!H\u0005\u0003\u0019v\u0011AaU8nK\u0006)a\r]1uQV\tq\n\u0005\u0002Q'6\t\u0011K\u0003\u0002SY\u0005!A.\u00198h\u0013\t)\u0015+\u0001\u0004ga\u0006$\b\u000eI\u0001\u0005]\u0006lW-\u0001\u0003qCRD\u0017\u0001C1cg>dW\u000f^3\u0016\u0003I\n\u0011bY8oi\u0006Lg.\u001a:\u0016\u0003\u0001\nQ!\u001b8qkR,\u0012!\u0018\t\u0003myK!aX\u001c\u0003\u0017%s\u0007/\u001e;TiJ,\u0017-\\\u0001\u0007_V$\b/\u001e;\u0016\u0003\t\u0004\"AN2\n\u0005\u0011<$\u0001D(viB,Ho\u0015;sK\u0006l\u0017AC:ju\u0016|\u0005\u000f^5p]V\tq\rE\u0002K\u0017\"\u0004\"AS5\n\u0005)l\"aA%oi\u0006A\u0001.Y:i\u0007>$W\rF\u0001i\u0003\u0019)\u0017/^1mgR\u0011qN\u001d\t\u0003\u0015BL!!]\u000f\u0003\u000f\t{w\u000e\\3b]\")1\u000f\u0005a\u0001i\u0006!A\u000f[1u!\tQU/\u0003\u0002w;\t\u0019\u0011I\\=\u0002\u0017%\u001cH)\u001b:fGR|'/_\u000b\u0002_\u0006aA.Y:u\u001b>$\u0017NZ5fIV\t1\u0010\u0005\u0002Ky&\u0011Q0\b\u0002\u0005\u0019>tw-\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\t\t\u0001E\u0003\u0002\u0004\u0005%\u0001ED\u0002K\u0003\u000bI1!a\u0002\u001e\u0003\u001d\u0001\u0018mY6bO\u0016LA!a\u0003\u0002\u000e\tA\u0011\n^3sCR|'OC\u0002\u0002\bu\t!\u0002\\8pWV\u0004h*Y7f)\u0015\u0001\u00131CA\u000b\u0011\u0015)F\u00031\u0001=\u0011\u0019\t9\u0002\u0006a\u0001_\u0006IA-\u001b:fGR|'/_\u0001\u0007GJ,\u0017\r^3\u0015\u0005\u0005u\u0001c\u0001&\u0002 %\u0019\u0011\u0011E\u000f\u0003\tUs\u0017\u000e^\u0001\u0007I\u0016dW\r^3\u0002'1|wn[;q\u001d\u0006lW-\u00168dQ\u0016\u001c7.\u001a3\u0015\u000b\u0001\nI#a\u000b\t\u000bU;\u0002\u0019\u0001\u001f\t\r\u0005]q\u00031\u0001p\u0001")
public class PlainNioFile
extends AbstractFile {
    private String canonicalPath;
    private final Path nioPath;
    private final String fpath;
    private volatile boolean bitmap$0;

    @Override
    public File file() {
        try {
            return this.nioPath.toFile();
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            return null;
        }
    }

    private String canonicalPath$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                this.canonicalPath = super.canonicalPath();
                this.bitmap$0 = true;
            }
        }
        return this.canonicalPath;
    }

    @Override
    public String canonicalPath() {
        if (!this.bitmap$0) {
            return this.canonicalPath$lzycompute();
        }
        return this.canonicalPath;
    }

    public Some<PlainNioFile> underlyingSource() {
        return new Some<PlainNioFile>(this);
    }

    private String fpath() {
        return this.fpath;
    }

    @Override
    public String name() {
        return ((Object)this.nioPath.getFileName()).toString();
    }

    @Override
    public String path() {
        return ((Object)this.nioPath).toString();
    }

    @Override
    public PlainNioFile absolute() {
        return new PlainNioFile(this.nioPath.toAbsolutePath());
    }

    @Override
    public AbstractFile container() {
        return new PlainNioFile(this.nioPath.getParent());
    }

    @Override
    public InputStream input() {
        return Files.newInputStream(this.nioPath, new OpenOption[0]);
    }

    @Override
    public OutputStream output() {
        return Files.newOutputStream(this.nioPath, new OpenOption[0]);
    }

    public Some<Object> sizeOption() {
        return new Some<Object>(BoxesRunTime.boxToInteger((int)Files.size(this.nioPath)));
    }

    public int hashCode() {
        return this.fpath().hashCode();
    }

    @Override
    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof PlainNioFile) {
            PlainNioFile plainNioFile = (PlainNioFile)that;
            String string = this.fpath();
            String string2 = plainNioFile.fpath();
            bl = !(string != null ? !string.equals(string2) : string2 != null);
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public boolean isDirectory() {
        return Files.isDirectory(this.nioPath, new LinkOption[0]);
    }

    @Override
    public long lastModified() {
        return Files.getLastModifiedTime(this.nioPath, new LinkOption[0]).toMillis();
    }

    @Override
    public Iterator<AbstractFile> iterator() {
        try {
            java.util.Iterator<Path> it = Files.newDirectoryStream(this.nioPath).iterator();
            return JavaConverters$.MODULE$.asScalaIteratorConverter(it).asScala().map((Function1<Path, PlainNioFile> & java.io.Serializable & Serializable)x$3 -> new PlainNioFile((Path)x$3));
        }
        catch (NotDirectoryException notDirectoryException) {
            return package$.MODULE$.Iterator().empty();
        }
    }

    @Override
    public AbstractFile lookupName(String name, boolean directory) {
        Path child = this.nioPath.resolve(name);
        if (Files.isDirectory(child, new LinkOption[0]) && directory || Files.isRegularFile(child, new LinkOption[0]) && !directory) {
            return new PlainNioFile(child);
        }
        return null;
    }

    @Override
    public void create() {
        if (!this.exists()) {
            Files.createFile(this.nioPath, new FileAttribute[0]);
        }
    }

    @Override
    public void delete() {
        if (Files.isRegularFile(this.nioPath, new LinkOption[0])) {
            Files.deleteIfExists(this.nioPath);
            return;
        }
        if (Files.isDirectory(this.nioPath, new LinkOption[0])) {
            new Directory(this.nioPath.toFile()).deleteRecursively();
        }
    }

    @Override
    public AbstractFile lookupNameUnchecked(String name, boolean directory) {
        return new PlainNioFile(this.nioPath.resolve(name));
    }

    public PlainNioFile(Path nioPath) {
        this.nioPath = nioPath;
        Predef$.MODULE$.assert(nioPath != null);
        this.fpath = ((Object)nioPath.toAbsolutePath()).toString();
    }
}

