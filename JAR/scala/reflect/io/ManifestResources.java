/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import scala.Function1;
import scala.None$;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.JavaConverters$;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.ManifestResources;
import scala.reflect.io.ZipArchive;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001Q4Aa\u0004\t\u0003/!AA\u0004\u0001BC\u0002\u0013\u0005Q\u0004\u0003\u0005'\u0001\t\u0005\t\u0015!\u0003\u001f\u0011\u00159\u0003\u0001\"\u0001)\u0011\u0015Y\u0003\u0001\"\u0001-\u0011\u0015A\u0004\u0001\"\u0001:\u0011\u0015)\u0005\u0001\"\u0001:\u0011\u00151\u0005\u0001\"\u0001H\u0011\u0015i\u0005\u0001\"\u0001O\u0011\u0015\u0011\u0006\u0001\"\u0011T\u0011\u0015a\u0006\u0001\"\u0011^\u0011\u0015\t\u0007\u0001\"\u0011c\u0011\u0015)\u0007\u0001\"\u0003g\u0011\u0019A\u0007\u0001)Q\u0005S\")q\u000e\u0001C!a\n\tR*\u00198jM\u0016\u001cHOU3t_V\u00148-Z:\u000b\u0005E\u0011\u0012AA5p\u0015\t\u0019B#A\u0004sK\u001adWm\u0019;\u000b\u0003U\tQa]2bY\u0006\u001c\u0001a\u0005\u0002\u00011A\u0011\u0011DG\u0007\u0002!%\u00111\u0004\u0005\u0002\u000b5&\u0004\u0018I]2iSZ,\u0017aA;sYV\ta\u0004\u0005\u0002 I5\t\u0001E\u0003\u0002\"E\u0005\u0019a.\u001a;\u000b\u0003\r\nAA[1wC&\u0011Q\u0005\t\u0002\u0004+Jc\u0015\u0001B;sY\u0002\na\u0001P5oSRtDCA\u0015+!\tI\u0002\u0001C\u0003\u001d\u0007\u0001\u0007a$\u0001\u0005ji\u0016\u0014\u0018\r^8s+\u0005i\u0003c\u0001\u00183k9\u0011q\u0006M\u0007\u0002)%\u0011\u0011\u0007F\u0001\ba\u0006\u001c7.Y4f\u0013\t\u0019DG\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0015\t\tD\u0003\u0005\u0002\u001am%\u0011q\u0007\u0005\u0002\r\u0003\n\u001cHO]1di\u001aKG.Z\u0001\u0005]\u0006lW-F\u0001;!\tY$I\u0004\u0002=\u0001B\u0011Q\bF\u0007\u0002})\u0011qHF\u0001\u0007yI|w\u000e\u001e \n\u0005\u0005#\u0012A\u0002)sK\u0012,g-\u0003\u0002D\t\n11\u000b\u001e:j]\u001eT!!\u0011\u000b\u0002\tA\fG\u000f[\u0001\u0006S:\u0004X\u000f^\u000b\u0002\u0011B\u0011\u0011jS\u0007\u0002\u0015*\u0011\u0011CI\u0005\u0003\u0019*\u00131\"\u00138qkR\u001cFO]3b[\u0006aA.Y:u\u001b>$\u0017NZ5fIV\tq\n\u0005\u00020!&\u0011\u0011\u000b\u0006\u0002\u0005\u0019>tw-\u0001\u0005dC:,\u0015/^1m)\t!v\u000b\u0005\u00020+&\u0011a\u000b\u0006\u0002\b\u0005>|G.Z1o\u0011\u0015A\u0016\u00021\u0001Z\u0003\u0015yG\u000f[3s!\ty#,\u0003\u0002\\)\t\u0019\u0011I\\=\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012A\u0018\t\u0003_}K!\u0001\u0019\u000b\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0003)\u000eDQ\u0001Z\u0006A\u0002e\u000bA\u0001\u001e5bi\u0006\u0019\"/Z:pkJ\u001cW-\u00138qkR\u001cFO]3b[R\u0011\u0001j\u001a\u0005\u0006\u000b2\u0001\rAO\u0001\u000bG2|7/Z1cY\u0016\u001c\bc\u0001\u0018kY&\u00111\u000e\u000e\u0002\u0005\u0019&\u001cH\u000f\u0005\u0002J[&\u0011aN\u0013\u0002\n\u00072|7/Z1cY\u0016\fQa\u00197pg\u0016$\u0012!\u001d\t\u0003_IL!a\u001d\u000b\u0003\tUs\u0017\u000e\u001e")
public final class ManifestResources
extends ZipArchive {
    private final URL url;
    private List<Closeable> closeables;

    public URL url() {
        return this.url;
    }

    @Override
    public Iterator<AbstractFile> iterator() {
        Iterator<AbstractFile> iterator2;
        ZipArchive.DirEntry root = new ZipArchive.DirEntry(this, "/");
        HashMap<String, ZipArchive.DirEntry> dirs2 = new HashMap<String, ZipArchive.DirEntry>();
        dirs2.put("/", root);
        Manifest manifest = new Manifest(this.input());
        this.closeables = this.closeables.$colon$colon(this.input());
        JavaConverters$.MODULE$.asScalaIteratorConverter(manifest.getEntries().keySet().iterator()).asScala().filter((Function1<String, Object> & java.io.Serializable & Serializable)(A x$4) -> BoxesRunTime.boxToBoolean(x$4.endsWith(".class"))).map((Function1<String, ZipEntry> & java.io.Serializable & Serializable)x$5 -> new ZipEntry((String)x$5)).foreach((Function1<ZipEntry, Object> & java.io.Serializable & Serializable)(A zipEntry) -> {
            ManifestResources.$anonfun$iterator$4(this, dirs2, zipEntry);
            return BoxedUnit.UNIT;
        });
        try {
            iterator2 = root.iterator();
        }
        finally {
            dirs2.clear();
        }
        return iterator2;
    }

    @Override
    public String name() {
        return this.path();
    }

    @Override
    public String path() {
        String s = this.url().getPath();
        int n = s.lastIndexOf(33);
        return s.substring(0, n);
    }

    @Override
    public InputStream input() {
        return this.url().openStream();
    }

    @Override
    public long lastModified() {
        try {
            return this.url().openConnection().getLastModified();
        }
        catch (IOException iOException) {
            return 0L;
        }
    }

    @Override
    public boolean canEqual(Object other) {
        return other instanceof ManifestResources;
    }

    public int hashCode() {
        return this.url().hashCode();
    }

    @Override
    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof ManifestResources) {
            ManifestResources manifestResources = (ManifestResources)that;
            URL uRL = this.url();
            URL uRL2 = manifestResources.url();
            bl = !(uRL != null ? !((Object)uRL).equals(uRL2) : uRL2 != null);
        } else {
            bl = false;
        }
        return bl;
    }

    public InputStream scala$reflect$io$ManifestResources$$resourceInputStream(String path) {
        return new FilterInputStream(null, path){
            private final String path$1;

            public int read() {
                if (this.in == null) {
                    this.in = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.path$1);
                }
                if (this.in == null) {
                    throw new RuntimeException(new StringBuilder(10).append(this.path$1).append(" not found").toString());
                }
                return super.read();
            }

            public void close() {
                super.close();
                this.in = null;
            }
            {
                this.path$1 = path$1;
                super(null);
            }
        };
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

    public static final /* synthetic */ void $anonfun$iterator$4(ManifestResources $this, HashMap dirs$2, ZipEntry zipEntry) {
        ZipArchive.DirEntry dir = $this.getDir(dirs$2, zipEntry);
        if (!zipEntry.isDirectory()) {
            public class Scala_reflect_io_ManifestResources$FileEntry$2
            extends ZipArchive.Entry {
                private final /* synthetic */ ManifestResources $outer;
                private final ZipEntry zipEntry$2;

                public long lastModified() {
                    return this.zipEntry$2.getTime();
                }

                public InputStream input() {
                    return this.$outer.scala$reflect$io$ManifestResources$$resourceInputStream(this.path());
                }

                public None$ sizeOption() {
                    return None$.MODULE$;
                }

                public Scala_reflect_io_ManifestResources$FileEntry$2(ManifestResources $outer, ZipEntry zipEntry$2) {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    this.zipEntry$2 = zipEntry$2;
                    super($outer, zipEntry$2.getName());
                }
            }
            Scala_reflect_io_ManifestResources$FileEntry$2 f = new Scala_reflect_io_ManifestResources$FileEntry$2($this, zipEntry);
            dir.entries().update(f.name(), f);
        }
    }

    public ManifestResources(URL url) {
        this.url = url;
        super(null);
        this.closeables = Nil$.MODULE$;
    }

    public static final /* synthetic */ Object $anonfun$close$3$adapted(Closeable x$6) {
        x$6.close();
        return BoxedUnit.UNIT;
    }
}

