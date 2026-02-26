/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterator;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.Directory;
import scala.reflect.io.File;
import scala.reflect.io.Path;
import scala.reflect.io.Path$;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005\rb\u0001\u0002\u000e\u001c\u0001\tB\u0001b\n\u0001\u0003\u0006\u0004%\t\u0001\u000b\u0005\tY\u0001\u0011\t\u0011)A\u0005S!)Q\u0006\u0001C\u0001]!9\u0011\u0007\u0001b\u0001\n\u0003\u0011\u0004B\u0002\u001e\u0001A\u0003%1\u0007\u0003\u0005<\u0001!\u0015\r\u0011\"\u0011=\u0011\u0015A\u0005\u0001\"\u0011J\u0011\u001dq\u0005A1A\u0005\n!Baa\u0014\u0001!\u0002\u0013I\u0003\"\u0002)\u0001\t\u0003a\u0004\"B)\u0001\t\u0003a\u0004\"\u0002*\u0001\t\u0003\u0019\u0006\"\u0002+\u0001\t\u0003*\u0006\"\u0002,\u0001\t\u0003:\u0006\"B.\u0001\t\u0003b\u0006\"\u00021\u0001\t\u0003\n\u0007\"\u00024\u0001\t\u0003:\u0007\"\u00025\u0001\t\u0003J\u0007\"\u0002:\u0001\t\u0003\u0019\b\"\u0002;\u0001\t\u0003)\b\"B=\u0001\t\u0003Q\bbBA\u0003\u0001\u0011\u0005\u0011q\u0001\u0005\b\u0003\u001f\u0001A\u0011AA\t\u0011\u001d\tI\u0002\u0001C\u0001\u0003#Aq!a\u0007\u0001\t\u0003\tiBA\u0005QY\u0006LgNR5mK*\u0011A$H\u0001\u0003S>T!AH\u0010\u0002\u000fI,g\r\\3di*\t\u0001%A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001\u0019\u0003C\u0001\u0013&\u001b\u0005Y\u0012B\u0001\u0014\u001c\u00051\t%m\u001d;sC\u000e$h)\u001b7f\u0003%9\u0017N^3o!\u0006$\b.F\u0001*!\t!#&\u0003\u0002,7\t!\u0001+\u0019;i\u0003)9\u0017N^3o!\u0006$\b\u000eI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005=\u0002\u0004C\u0001\u0013\u0001\u0011\u001593\u00011\u0001*\u0003\u00111\u0017\u000e\\3\u0016\u0003M\u0002\"\u0001\u000e\u001d\u000e\u0003UR!\u0001\b\u001c\u000b\u0003]\nAA[1wC&\u0011\u0011(\u000e\u0002\u0005\r&dW-A\u0003gS2,\u0007%A\u0007dC:|g.[2bYB\u000bG\u000f[\u000b\u0002{A\u0011a(\u0012\b\u0003\u007f\r\u0003\"\u0001Q\u0010\u000e\u0003\u0005S!AQ\u0011\u0002\rq\u0012xn\u001c;?\u0013\t!u$\u0001\u0004Qe\u0016$WMZ\u0005\u0003\r\u001e\u0013aa\u0015;sS:<'B\u0001# \u0003A)h\u000eZ3sYfLgnZ*pkJ\u001cW-F\u0001K!\rYEjL\u0007\u0002?%\u0011Qj\b\u0002\u0005'>lW-A\u0003ga\u0006$\b.\u0001\u0004ga\u0006$\b\u000eI\u0001\u0005]\u0006lW-\u0001\u0003qCRD\u0017\u0001C1cg>dW\u000f^3\u0016\u0003=\n\u0011bY8oi\u0006Lg.\u001a:\u0016\u0003\r\nQ!\u001b8qkR,\u0012\u0001\u0017\t\u0003ieK!AW\u001b\u0003\u001f\u0019KG.Z%oaV$8\u000b\u001e:fC6\faa\\;uaV$X#A/\u0011\u0005Qr\u0016BA06\u0005A1\u0015\u000e\\3PkR\u0004X\u000f^*ue\u0016\fW.\u0001\u0006tSj,w\n\u001d;j_:,\u0012A\u0019\t\u0004\u00172\u001b\u0007CA&e\u0013\t)wDA\u0002J]R\f\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0002G\u00061Q-];bYN$\"A[7\u0011\u0005-[\u0017B\u00017 \u0005\u001d\u0011un\u001c7fC:DQA\u001c\nA\u0002=\fA\u0001\u001e5biB\u00111\n]\u0005\u0003c~\u00111!\u00118z\u0003-I7\u000fR5sK\u000e$xN]=\u0016\u0003)\fA\u0002\\1ti6{G-\u001b4jK\u0012,\u0012A\u001e\t\u0003\u0017^L!\u0001_\u0010\u0003\t1{gnZ\u0001\tSR,'/\u0019;peV\t1\u0010E\u0002}\u007f\u000er!aS?\n\u0005y|\u0012a\u00029bG.\fw-Z\u0005\u0005\u0003\u0003\t\u0019A\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0015\tqx$\u0001\u0006m_>\\W\u000f\u001d(b[\u0016$RaIA\u0005\u0003\u0017AQ\u0001\u0015\fA\u0002uBa!!\u0004\u0017\u0001\u0004Q\u0017!\u00033je\u0016\u001cGo\u001c:z\u0003\u0019\u0019'/Z1uKR\u0011\u00111\u0003\t\u0004\u0017\u0006U\u0011bAA\f?\t!QK\\5u\u0003\u0019!W\r\\3uK\u0006\u0019Bn\\8lkBt\u0015-\\3V]\u000eDWmY6fIR)1%a\b\u0002\"!)\u0001+\u0007a\u0001{!1\u0011QB\rA\u0002)\u0004")
public class PlainFile
extends AbstractFile {
    private String canonicalPath;
    private final Path givenPath;
    private final java.io.File file;
    private final Path fpath;
    private volatile boolean bitmap$0;

    public Path givenPath() {
        return this.givenPath;
    }

    @Override
    public java.io.File file() {
        return this.file;
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

    public Some<PlainFile> underlyingSource() {
        return new Some<PlainFile>(this);
    }

    private Path fpath() {
        return this.fpath;
    }

    @Override
    public String name() {
        return this.givenPath().name();
    }

    @Override
    public String path() {
        return this.givenPath().path();
    }

    @Override
    public PlainFile absolute() {
        return new PlainFile(this.givenPath().toAbsolute());
    }

    @Override
    public AbstractFile container() {
        return new PlainFile(this.givenPath().parent());
    }

    @Override
    public FileInputStream input() {
        return this.givenPath().toFile().inputStream();
    }

    @Override
    public FileOutputStream output() {
        File qual$1 = this.givenPath().toFile();
        boolean x$1 = qual$1.outputStream$default$1();
        return qual$1.outputStream(x$1);
    }

    public Some<Object> sizeOption() {
        return new Some<Object>(BoxesRunTime.boxToInteger((int)this.givenPath().length()));
    }

    public int hashCode() {
        return this.fpath().hashCode();
    }

    @Override
    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof PlainFile) {
            PlainFile plainFile = (PlainFile)that;
            Path path = this.fpath();
            Path path2 = plainFile.fpath();
            bl = !(path != null ? !((Object)path).equals(path2) : path2 != null);
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public boolean isDirectory() {
        return this.givenPath().isDirectory();
    }

    @Override
    public long lastModified() {
        return this.givenPath().lastModified();
    }

    @Override
    public Iterator<AbstractFile> iterator() {
        if (!this.isDirectory()) {
            return package$.MODULE$.Iterator().empty();
        }
        return this.givenPath().toDirectory().list().filter((Function1<Path, Object> & java.io.Serializable & Serializable)(A path) -> BoxesRunTime.boxToBoolean(PlainFile.existsFast$1(path))).map((Function1<Path, PlainFile> & java.io.Serializable & Serializable)x$2 -> new PlainFile((Path)x$2));
    }

    @Override
    public AbstractFile lookupName(String name, boolean directory) {
        Path child = this.givenPath().$div(Path$.MODULE$.string2path(name));
        if (child.isDirectory() && directory || child.isFile() && !directory) {
            return new PlainFile(child);
        }
        return null;
    }

    @Override
    public void create() {
        if (!this.exists()) {
            this.givenPath().createFile(this.givenPath().createFile$default$1());
        }
    }

    @Override
    public void delete() {
        if (this.givenPath().isFile()) {
            this.givenPath().delete();
            return;
        }
        if (this.givenPath().isDirectory()) {
            this.givenPath().toDirectory().deleteRecursively();
        }
    }

    @Override
    public AbstractFile lookupNameUnchecked(String name, boolean directory) {
        return new PlainFile(this.givenPath().$div(Path$.MODULE$.string2path(name)));
    }

    private static final boolean existsFast$1(Path path) {
        boolean bl = path instanceof Directory ? true : path instanceof File;
        boolean bl2 = bl ? true : path.exists();
        return bl2;
    }

    public PlainFile(Path givenPath) {
        this.givenPath = givenPath;
        Predef$.MODULE$.assert(this.path() != null);
        this.file = givenPath.jfile();
        this.fpath = givenPath.toAbsolute();
    }
}

