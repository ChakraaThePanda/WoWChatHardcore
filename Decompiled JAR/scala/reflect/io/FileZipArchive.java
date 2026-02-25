/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.io.Codec$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.JDK9Reflectors;
import scala.reflect.io.File$;
import scala.reflect.io.Path$;
import scala.reflect.io.ZipArchive;
import scala.reflect.io.ZipArchive$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005]e\u0001\u0002\u0013&\u00051B\u0011\"\r\u0001\u0003\u0002\u0003\u0006IAM\u001d\t\u0011i\u0002!\u0011!Q\u0001\nmBQA\u0013\u0001\u0005\u0002-CQA\u0013\u0001\u0005\u0002=Ca!\u0015\u0001!\n\u0013\u0011fAB.\u0001A\u0003%A\fC\u0005b\r\t\u0005\t\u0015!\u0003@E\"AaM\u0002B\u0001B\u0003%q\r\u0003\u0005k\r\t\u0005\t\u0015!\u0003l\u0011\u0015Qe\u0001\"\u0001o\u0011\u0015\u0019h\u0001\"\u0011u\u0011\u0015)h\u0001\"\u0011w\u0011\u0015Qh\u0001\"\u0011|\r\u0019i\b\u0001)A\u0005}\"AqP\u0004B\u0001B\u0003%1\u000b\u0003\u0006\u0002\u00029\u0011\t\u0011)A\u0005\u0003\u0007A\u0011\"\u0019\b\u0003\u0002\u0003\u0006Ia\u00102\t\r)sA\u0011AA\u0005\u0011\u0015\u0019h\u0002\"\u0011u\u0011\u0015)h\u0002\"\u0011w\u0011\u0015Qh\u0002\"\u0011|\u0011!\t\u0019\u0002\u0001Q\u0001\n\u0005U\u0001BCA\u0012\u0001!\u0015\r\u0011\"\u0001\u0002&!Q\u0011q\u0005\u0001\t\u0006\u0004%\t!!\u000b\t\u000f\u0005E\u0002\u0001\"\u0001\u00024!1\u0011\r\u0001C\u0001\u0003\u0007Baa\u0019\u0001\u0005\u0002\u0005\r\u0003BB;\u0001\t\u0003\ty\u0005C\u0003t\u0001\u0011\u0005A\u000f\u0003\u0004{\u0001\u0011\u0005\u0013q\u000b\u0005\b\u0003?\u0002A\u0011IA1\u0011\u001d\t\u0019\b\u0001C!\u0003kBq!a\u001e\u0001\t\u0003\nI\b\u0003\u0005\u0002\u0000\u0001\u0001\u000b\u0015BAA\u0011\u001d\ti\t\u0001C!\u0003\u001f\u0013aBR5mKjK\u0007/\u0011:dQ&4XM\u0003\u0002'O\u0005\u0011\u0011n\u001c\u0006\u0003Q%\nqA]3gY\u0016\u001cGOC\u0001+\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001A\u0017\u0011\u00059zS\"A\u0013\n\u0005A*#A\u0003.ja\u0006\u00138\r[5wK\u0006!a-\u001b7f!\t\u0019t'D\u00015\u0015\t1SGC\u00017\u0003\u0011Q\u0017M^1\n\u0005a\"$\u0001\u0002$jY\u0016L!!M\u0018\u0002\u000fI,G.Z1tKB\u0019A(P \u000e\u0003%J!AP\u0015\u0003\r=\u0003H/[8o!\t\u0001uI\u0004\u0002B\u000bB\u0011!)K\u0007\u0002\u0007*\u0011AiK\u0001\u0007yI|w\u000e\u001e \n\u0005\u0019K\u0013A\u0002)sK\u0012,g-\u0003\u0002I\u0013\n11\u000b\u001e:j]\u001eT!AR\u0015\u0002\rqJg.\u001b;?)\raUJ\u0014\t\u0003]\u0001AQ!M\u0002A\u0002IBQAO\u0002A\u0002m\"\"\u0001\u0014)\t\u000bE\"\u0001\u0019\u0001\u001a\u0002\u0017=\u0004XM\u001c.ja\u001aKG.\u001a\u000b\u0002'B\u0011A+W\u0007\u0002+*\u0011akV\u0001\u0004u&\u0004(B\u0001-6\u0003\u0011)H/\u001b7\n\u0005i+&a\u0002.ja\u001aKG.\u001a\u0002\n\u0019\u0006T\u00180\u00128uef\u001c\"AB/\u0011\u0005y{V\"\u0001\u0001\n\u0005\u0001|#!B#oiJL\u0018\u0001\u00028b[\u0016L!a\u00193\u0002\tA\fG\u000f[\u0005\u0003K\u0016\u00121BV5siV\fGNR5mK\u0006!A/[7f!\ta\u0004.\u0003\u0002jS\t!Aj\u001c8h\u0003\u0011\u0019\u0018N_3\u0011\u0005qb\u0017BA7*\u0005\rIe\u000e\u001e\u000b\u0005_B\f(\u000f\u0005\u0002_\r!)\u0011M\u0003a\u0001\u007f!)aM\u0003a\u0001O\")!N\u0003a\u0001W\u0006aA.Y:u\u001b>$\u0017NZ5fIV\tq-A\u0003j]B,H/F\u0001x!\t\u0019\u00040\u0003\u0002zi\tY\u0011J\u001c9viN#(/Z1n\u0003)\u0019\u0018N_3PaRLwN\\\u000b\u0002yB\u0019A(P6\u0003\u00151+\u0017m[=F]R\u0014\u0018p\u0005\u0002\u000f;\u00069!0\u001b9GS2,\u0017\u0001\u0003>ja\u0016sGO]=\u0011\u0007Q\u000b)!C\u0002\u0002\bU\u0013\u0001BW5q\u000b:$(/\u001f\u000b\t\u0003\u0017\ti!a\u0004\u0002\u0012A\u0011aL\u0004\u0005\u0006\u007fJ\u0001\ra\u0015\u0005\b\u0003\u0003\u0011\u0002\u0019AA\u0002\u0011\u0015\t'\u00031\u0001@\u0003\u0011!\u0017N]:\u0011\u000f\u0005]\u0011\u0011D \u0002\u001e5\tq+C\u0002\u0002\u001c]\u0013q\u0001S1tQ6\u000b\u0007\u000fE\u0002_\u0003?I1!!\t0\u0005!!\u0015N]#oiJL\u0018\u0001\u0002:p_R,\"!!\b\u0002\u000f\u0005dG\u000eR5sgV\u0011\u00111\u0006\t\b\u0003/\ticPA\u000f\u0013\r\tyc\u0016\u0002\u0004\u001b\u0006\u0004\u0018\u0001C5uKJ\fGo\u001c:\u0016\u0005\u0005U\u0002#BA\u001c\u0003{ifb\u0001\u001f\u0002:%\u0019\u00111H\u0015\u0002\u000fA\f7m[1hK&!\u0011qHA!\u0005!IE/\u001a:bi>\u0014(bAA\u001eSU\u0011\u0011Q\t\t\u0005\u0003\u000f\ni%\u0004\u0002\u0002J)\u0019\u00111J\u001b\u0002\t1\fgnZ\u0005\u0004\u0011\u0006%SCAA)!\r\u0019\u00141K\u0005\u0004\u0003+\"$a\u0004$jY\u0016Le\u000e];u'R\u0014X-Y7\u0016\u0005\u0005e\u0003\u0003\u0002\u001f\u0002\\-L1!!\u0018*\u0005\u0011\u0019v.\\3\u0002\u0011\r\fg.R9vC2$B!a\u0019\u0002jA\u0019A(!\u001a\n\u0007\u0005\u001d\u0014FA\u0004C_>dW-\u00198\t\u000f\u0005-t\u00041\u0001\u0002n\u0005)q\u000e\u001e5feB\u0019A(a\u001c\n\u0007\u0005E\u0014FA\u0002B]f\f\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0002W\u00061Q-];bYN$B!a\u0019\u0002|!9\u0011QP\u0011A\u0002\u00055\u0014\u0001\u0002;iCR\f!b\u00197pg\u0016\f'\r\\3t!\u0019\t9$a!\u0002\b&!\u0011QQA!\u0005\u0011a\u0015n\u001d;\u0011\u0007M\nI)C\u0002\u0002\fR\u0012\u0011b\u00117pg\u0016\f'\r\\3\u0002\u000b\rdwn]3\u0015\u0005\u0005E\u0005c\u0001\u001f\u0002\u0014&\u0019\u0011QS\u0015\u0003\tUs\u0017\u000e\u001e")
public final class FileZipArchive
extends ZipArchive {
    private ZipArchive.DirEntry root;
    private Map<String, ZipArchive.DirEntry> allDirs;
    private final Option<String> release;
    private final HashMap<String, ZipArchive.DirEntry> dirs;
    private List<Closeable> closeables;
    private volatile byte bitmap$0;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ZipFile scala$reflect$io$FileZipArchive$$openZipFile() {
        try {
            Option<String> option = this.release;
            if (!(option instanceof Some)) return new ZipFile(super.file());
            String r = (String)((Some)option).value();
            if (!super.file().getName().endsWith(".jar")) return new ZipFile(super.file());
            Object releaseVersion = JDK9Reflectors.runtimeVersionParse(r);
            return JDK9Reflectors.newJarFile(super.file(), true, 1, releaseVersion);
        }
        catch (IOException ioe) {
            throw new IOException(new StringBuilder(16).append("Error accessing ").append(super.file().getPath()).toString(), ioe);
        }
    }

    /*
     * WARNING - void declaration
     */
    private ZipArchive.DirEntry root$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                void var1_1;
                ZipArchive.DirEntry root = new ZipArchive.DirEntry(this, "/");
                this.dirs.put("/", root);
                ZipFile zipFile = this.scala$reflect$io$FileZipArchive$$openZipFile();
                Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
                try {
                    while (enumeration.hasMoreElements()) {
                        ZipEntry zipEntryVersioned;
                        ZipEntry zipEntry = enumeration.nextElement();
                        if (zipEntry.getName().startsWith("META-INF/versions/")) continue;
                        ZipEntry zipEntry2 = zipEntryVersioned = this.release.isDefined() ? zipFile.getEntry(zipEntry.getName()) : zipEntry;
                        if (zipEntry.isDirectory()) continue;
                        ZipArchive.DirEntry dir = this.getDir(this.dirs, zipEntry);
                        ZipArchive.Entry f = ZipArchive$.MODULE$.closeZipFile() ? new LazyEntry(this, zipEntry.getName(), zipEntry.getTime(), (int)zipEntry.getSize()) : new LeakyEntry(this, zipFile, zipEntryVersioned, zipEntry.getName());
                        dir.entries().update(f.name(), f);
                    }
                }
                finally {
                    if (ZipArchive$.MODULE$.closeZipFile()) {
                        zipFile.close();
                    } else {
                        this.closeables = this.closeables.$colon$colon(zipFile);
                    }
                }
                this.root = var1_1;
                this.bitmap$0 = (byte)(this.bitmap$0 | 1);
            }
        }
        return this.root;
    }

    public ZipArchive.DirEntry root() {
        if ((byte)(this.bitmap$0 & 1) == 0) {
            return this.root$lzycompute();
        }
        return this.root;
    }

    private Map<String, ZipArchive.DirEntry> allDirs$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                this.root();
                this.allDirs = this.dirs;
                this.bitmap$0 = (byte)(this.bitmap$0 | 2);
            }
        }
        return this.allDirs;
    }

    public Map<String, ZipArchive.DirEntry> allDirs() {
        if ((byte)(this.bitmap$0 & 2) == 0) {
            return this.allDirs$lzycompute();
        }
        return this.allDirs;
    }

    @Override
    public Iterator<ZipArchive.Entry> iterator() {
        return this.root().iterator();
    }

    @Override
    public String name() {
        return super.file().getName();
    }

    @Override
    public String path() {
        return super.file().getPath();
    }

    @Override
    public FileInputStream input() {
        return File$.MODULE$.apply(Path$.MODULE$.jfile2path(super.file()), Codec$.MODULE$.fallbackSystemCodec()).inputStream();
    }

    @Override
    public long lastModified() {
        return super.file().lastModified();
    }

    public Some<Object> sizeOption() {
        return new Some<Object>(BoxesRunTime.boxToInteger((int)super.file().length()));
    }

    @Override
    public boolean canEqual(Object other) {
        return other instanceof FileZipArchive;
    }

    public int hashCode() {
        return super.file().hashCode();
    }

    @Override
    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof FileZipArchive) {
            FileZipArchive fileZipArchive = (FileZipArchive)that;
            File file = super.file().getAbsoluteFile();
            File file2 = fileZipArchive.file().getAbsoluteFile();
            bl = !(file != null ? !((Object)file).equals(file2) : file2 != null);
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public void close() {
        List list = this.closeables;
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            foreach_these.head().close();
            foreach_these = (List)foreach_these.tail();
        }
    }

    public FileZipArchive(File file, Option<String> release) {
        this.release = release;
        super(file, release);
        this.dirs = new HashMap();
        this.closeables = Nil$.MODULE$;
    }

    public FileZipArchive(File file) {
        this(file, None$.MODULE$);
    }

    public static final /* synthetic */ Object $anonfun$close$1$adapted(Closeable x$2) {
        x$2.close();
        return BoxedUnit.UNIT;
    }

    private class LazyEntry
    extends ZipArchive.Entry {
        private final long time;
        private final int size;

        @Override
        public long lastModified() {
            return this.time;
        }

        @Override
        public InputStream input() {
            ZipFile zipFile = this.scala$reflect$io$FileZipArchive$LazyEntry$$$outer().scala$reflect$io$FileZipArchive$$openZipFile();
            ZipEntry entry = zipFile.getEntry(super.path());
            InputStream delegate = zipFile.getInputStream(entry);
            return new FilterInputStream(null, delegate, zipFile){
                private final ZipFile zipFile$1;

                public void close() {
                    this.zipFile$1.close();
                }
                {
                    this.zipFile$1 = zipFile$1;
                    super(delegate$1);
                }
            };
        }

        @Override
        public Option<Object> sizeOption() {
            return new Some<Object>(BoxesRunTime.boxToInteger(this.size));
        }

        public /* synthetic */ FileZipArchive scala$reflect$io$FileZipArchive$LazyEntry$$$outer() {
            return (FileZipArchive)this.$outer;
        }

        public LazyEntry(FileZipArchive $outer, String name, long time, int size) {
            this.time = time;
            this.size = size;
            super($outer, name);
        }
    }

    private class LeakyEntry
    extends ZipArchive.Entry {
        private final ZipFile zipFile;
        private final ZipEntry zipEntry;

        @Override
        public long lastModified() {
            return this.zipEntry.getTime();
        }

        @Override
        public InputStream input() {
            return this.zipFile.getInputStream(this.zipEntry);
        }

        @Override
        public Option<Object> sizeOption() {
            return new Some<Object>(BoxesRunTime.boxToInteger((int)this.zipEntry.getSize()));
        }

        public /* synthetic */ FileZipArchive scala$reflect$io$FileZipArchive$LeakyEntry$$$outer() {
            return (FileZipArchive)this.$outer;
        }

        public LeakyEntry(FileZipArchive $outer, ZipFile zipFile, ZipEntry zipEntry, String name) {
            this.zipFile = zipFile;
            this.zipEntry = zipEntry;
            super($outer, name);
        }
    }
}

