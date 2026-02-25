/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.net.URL;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashMap$;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.File;
import scala.reflect.io.FileZipArchive;
import scala.reflect.io.URLZipArchive;
import scala.reflect.io.VirtualFile;
import scala.reflect.io.ZipArchive$;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\tur!\u0002\u001a4\u0011\u0003Qd!\u0002\u001f4\u0011\u0003i\u0004\"\u0002\"\u0002\t\u0003\u0019\u0005\u0002\u0003#\u0002\u0005\u0004%\taM#\t\r%\u000b\u0001\u0015!\u0003G\u0011!Q\u0015A1A\u0005\u0006MZ\u0005BB(\u0002A\u00035A\nC\u0003Q\u0003\u0011\u0005\u0011\u000bC\u0003Q\u0003\u0011\u0005!\fC\u0003c\u0003\u0011\u00051\rC\u0003p\u0003\u0011\u0005\u0001\u000fC\u0003v\u0003\u0011%a\u000fC\u0004\u0002\n\u0005!I!a\u0003\t\u000f\u0005=\u0011\u0001\"\u0003\u0002\u0012\u00191AhMA\u0001\u00037A\u0011B\u0016\b\u0003\u0006\u0004%\t%a\t\t\u0013\u0005\u0015bB!A!\u0002\u0013a\u0006BCA\u0014\u001d\t\u0005\t\u0015!\u0003\u0002*!1!I\u0004C\u0001\u0003_AaA\u0011\b\u0005\u0002\u0005]\u0002BCA\u001e\u001d!\u0015\r\u0011\"\u0011\u0002>!9\u0011q\b\b\u0005B\u0005\u0005\u0003BBA%\u001d\u0011\u0005Q\tC\u0004\u0002L9!\t!!\u0014\t\u000f\u0005uc\u0002\"\u0001\u0002`!9\u0011Q\r\b\u0005\u0002\u0005\u001d\u0004bBA5\u001d\u0011\u0005\u0011q\r\u0005\b\u0003WrA\u0011AA7\u0011\u001d\tyG\u0004C\u0001\u0003[Bq!!\u001d\u000f\t\u0003\tiGB\u0004\u0002t9\t\t#!\u001e\t\u0017\u0005\u001daD!A!\u0002\u00139\u0018Q\u0010\u0005\u0007\u0005z!\t!a \t\u000f\u0005\u001de\u0004\"\u0001\u0002\n\"9\u0011q\b\u0010\u0005B\u0005\u0005\u0003bBAN=\u0011\u0005\u0013Q\u0014\u0005\b\u0003SsB\u0011IAV\r\u0019\t\tM\u0004\u0001\u0002D\"Y\u0011qA\u0013\u0003\u0002\u0003\u0006Ia^A?\u0011\u0019\u0011U\u0005\"\u0001\u0002F\"I\u00111Z\u0013C\u0002\u0013\u0005\u0011Q\u001a\u0005\t\u0003?,\u0003\u0015!\u0003\u0002P\"1\u0011\u0011J\u0013\u0005B\u0015Cq!!9&\t\u0003\n\u0019\u000fC\u0004\u0002L\u0015\"\t%a=\t\u000f\t\u0005a\u0002\"\u0003\u0003\u0004!9!1\u0003\b!B\u00139\bb\u0002B\u000f\u001d\u0011%!q\u0004\u0005\b\u0005GqA\u0011\u0003B\u0013\u0011\u001d\u0011\u0019D\u0004D\u0001\u0005k\t!BW5q\u0003J\u001c\u0007.\u001b<f\u0015\t!T'\u0001\u0002j_*\u0011agN\u0001\be\u00164G.Z2u\u0015\u0005A\u0014!B:dC2\f7\u0001\u0001\t\u0003w\u0005i\u0011a\r\u0002\u000b5&\u0004\u0018I]2iSZ,7CA\u0001?!\ty\u0004)D\u00018\u0013\t\tuG\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003i\nAb\u00197pg\u0016T\u0016\u000e\u001d$jY\u0016,\u0012A\u0012\t\u0003\u007f\u001dK!\u0001S\u001c\u0003\u000f\t{w\u000e\\3b]\u0006i1\r\\8tKjK\u0007OR5mK\u0002\n\u0011BU8pi\u0016sGO]=\u0016\u00031{\u0011!T\u0011\u0002\u001d\u0006\tq&\u0001\u0006S_>$XI\u001c;ss\u0002\n\u0001B\u001a:p[\u001aKG.\u001a\u000b\u0003%V\u0003\"aO*\n\u0005Q\u001b$A\u0004$jY\u0016T\u0016\u000e]!sG\"Lg/\u001a\u0005\u0006-\u001e\u0001\raV\u0001\u0005M&dW\r\u0005\u0002<1&\u0011\u0011l\r\u0002\u0005\r&dW\r\u0006\u0002S7\")a\u000b\u0003a\u00019B\u0011Q,Y\u0007\u0002=*\u0011Ag\u0018\u0006\u0002A\u0006!!.\u0019<b\u0013\tIf,A\u0004ge>lWK\u0015'\u0015\u0005\u0011<\u0007CA\u001ef\u0013\t17GA\u0007V%2S\u0016\u000e]!sG\"Lg/\u001a\u0005\u0006Q&\u0001\r![\u0001\u0004kJd\u0007C\u00016n\u001b\u0005Y'B\u00017`\u0003\rqW\r^\u0005\u0003].\u00141!\u0016*M\u0003=1'o\\7NC:Lg-Z:u+JcECA9u!\tY$/\u0003\u0002tg\ta\u0011IY:ue\u0006\u001cGOR5mK\")\u0001N\u0003a\u0001S\u00069A-\u001b:OC6,GcA<\u0002\u0006A\u0011\u0001p \b\u0003sv\u0004\"A_\u001c\u000e\u0003mT!\u0001`\u001d\u0002\rq\u0012xn\u001c;?\u0013\tqx'\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003\u0003\t\u0019A\u0001\u0004TiJLgn\u001a\u0006\u0003}^Ba!a\u0002\f\u0001\u00049\u0018\u0001\u00029bi\"\f\u0001BY1tK:\u000bW.\u001a\u000b\u0004o\u00065\u0001BBA\u0004\u0019\u0001\u0007q/A\u0005ta2LG\u000fU1uQR)q/a\u0005\u0002\u0018!1\u0011QC\u0007A\u0002]\fQ\u0001]1uQBBa!!\u0007\u000e\u0001\u00041\u0015!\u00024s_:$8\u0003\u0002\br\u0003;\u00012aPA\u0010\u0013\r\t\tc\u000e\u0002\u0007\u000bF,\u0018\r\\:\u0016\u0003q\u000bQAZ5mK\u0002\nqA]3mK\u0006\u001cX\r\u0005\u0003@\u0003W9\u0018bAA\u0017o\t1q\n\u001d;j_:$b!!\r\u00024\u0005U\u0002CA\u001e\u000f\u0011\u00151&\u00031\u0001]\u0011\u001d\t9C\u0005a\u0001\u0003S!B!!\r\u0002:!)ak\u0005a\u00019\u0006i1-\u00198p]&\u001c\u0017\r\u001c)bi\",\u0012a^\u0001\u0011k:$WM\u001d7zS:<7k\\;sG\u0016,\"!a\u0011\u0011\u000b}\n)%!\r\n\u0007\u0005\u001dsG\u0001\u0003T_6,\u0017aC5t\t&\u0014Xm\u0019;pef\f!\u0002\\8pWV\u0004h*Y7f)\u0019\ty%!\u0016\u0002ZA\u0019q(!\u0015\n\u0007\u0005MsGA\u0004O_RD\u0017N\\4\t\r\u0005]s\u00031\u0001x\u0003\u0011q\u0017-\\3\t\r\u0005ms\u00031\u0001G\u0003%!\u0017N]3di>\u0014\u00180A\nm_>\\W\u000f\u001d(b[\u0016,fn\u00195fG.,G\r\u0006\u0004\u0002P\u0005\u0005\u00141\r\u0005\u0007\u0003/B\u0002\u0019A<\t\r\u0005m\u0003\u00041\u0001G\u0003\u0019\u0019'/Z1uKR\u0011\u0011qJ\u0001\u0007I\u0016dW\r^3\u0002\r=,H\u000f];u+\t\ty%A\u0005d_:$\u0018-\u001b8fe\u0006A\u0011MY:pYV$XMA\u0003F]R\u0014\u0018pE\u0002\u001f\u0003o\u00022aOA=\u0013\r\tYh\r\u0002\f-&\u0014H/^1m\r&dW-\u0003\u0003\u0002\b\u0005eD\u0003BAA\u0003\u000b\u00032!a!\u001f\u001b\u0005q\u0001BBA\u0004A\u0001\u0007q/\u0001\u0006hKR\f%o\u00195jm\u0016,\"!a#\u0011\t\u00055\u0015qS\u0007\u0003\u0003\u001fSA!!%\u0002\u0014\u0006\u0019!0\u001b9\u000b\u0007\u0005Uu,\u0001\u0003vi&d\u0017\u0002BAM\u0003\u001f\u0013qAW5q\r&dW-\u0001\u0005u_N#(/\u001b8h)\t\ty\n\u0005\u0003\u0002\"\u0006\u001dVBAAR\u0015\r\t)kX\u0001\u0005Y\u0006tw-\u0003\u0003\u0002\u0002\u0005\r\u0016!E;og\u00064W\rV8CsR,\u0017I\u001d:bsV\u0011\u0011Q\u0016\t\u0006\u007f\u0005=\u00161W\u0005\u0004\u0003c;$!B!se\u0006L\bcA \u00026&\u0019\u0011qW\u001c\u0003\t\tKH/Z\u0015\t=\u0005mV%!?\u0002~\u001a1\u0011Q\u0018\u0010\u0001\u0003\u007f\u0013Q\u0002\u00107pG\u0006d\u0007e\u00195jY\u0012t4\u0003BA^\u0003\u0003\u0013\u0001\u0002R5s\u000b:$(/_\n\u0004K\u0005\u0005E\u0003BAd\u0003\u0013\u00042!a!&\u0011\u0019\t9a\na\u0001o\u00069QM\u001c;sS\u0016\u001cXCAAh!!\t\t.a7\u0002 \u0006\u0005UBAAj\u0015\u0011\t).a6\u0002\u000f5,H/\u00192mK*\u0019\u0011\u0011\\\u001c\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0003\u0002^\u0006M'a\u0002%bg\"l\u0015\r]\u0001\tK:$(/[3tA\u0005A\u0011\u000e^3sCR|'/\u0006\u0002\u0002fB1\u0011q]Aw\u0003\u0003s1aPAu\u0013\r\tYoN\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\ty/!=\u0003\u0011%#XM]1u_JT1!a;8)\u0019\t\t)!>\u0002x\"1\u0011q\u000b\u0017A\u0002]Da!a\u0017-\u0001\u00041\u0015bAA~'\nIA*\u0019>z\u000b:$(/_\u0005\u0004\u0003\u007f\u001c&A\u0003'fC.LXI\u001c;ss\u0006IQM\\:ve\u0016$\u0015N\u001d\u000b\u0007\u0003\u000f\u0014)A!\u0005\t\u000f\t\u001dQ\u00061\u0001\u0003\n\u0005!A-\u001b:t!\u001d\u0011YA!\u0004x\u0003\u000fl!!a%\n\t\t=\u00111\u0013\u0002\u0004\u001b\u0006\u0004\bBBA\u0004[\u0001\u0007q/A\u0006mCN$H)\u001b:OC6,\u0007f\u0001\u0018\u0003\u0018A\u0019qH!\u0007\n\u0007\tmqG\u0001\u0005w_2\fG/\u001b7f\u0003A!\u0017N\u001d(b[\u0016,6/\u001b8h\u0019\u0006\u001cH\u000fF\u0002x\u0005CAa!a\u00160\u0001\u00049\u0018AB4fi\u0012K'\u000f\u0006\u0004\u0002H\n\u001d\"\u0011\u0006\u0005\b\u0005\u000f\u0001\u0004\u0019\u0001B\u0005\u0011\u001d\u0011Y\u0003\ra\u0001\u0005[\tQ!\u001a8uef\u0004B!!$\u00030%!!\u0011GAH\u0005!Q\u0016\u000e]#oiJL\u0018!B2m_N,GC\u0001B\u001c!\ry$\u0011H\u0005\u0004\u0005w9$\u0001B+oSR\u0004")
public abstract class ZipArchive
extends AbstractFile {
    private String canonicalPath;
    private final java.io.File file;
    private volatile String lastDirName;
    private volatile boolean bitmap$0;

    public static AbstractFile fromManifestURL(URL uRL) {
        return ZipArchive$.MODULE$.fromManifestURL(uRL);
    }

    public static URLZipArchive fromURL(URL uRL) {
        return ZipArchive$.MODULE$.fromURL(uRL);
    }

    public static FileZipArchive fromFile(java.io.File file) {
        return ZipArchive$.MODULE$.fromFile(file);
    }

    public static FileZipArchive fromFile(File file) {
        return ZipArchive$.MODULE$.fromFile(file);
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

    public Some<ZipArchive> underlyingSource() {
        return new Some<ZipArchive>(this);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public Nothing$ lookupName(String name, boolean directory) {
        return this.unsupported();
    }

    public Nothing$ lookupNameUnchecked(String name, boolean directory) {
        return this.unsupported();
    }

    public Nothing$ create() {
        return this.unsupported();
    }

    public Nothing$ delete() {
        return this.unsupported();
    }

    public Nothing$ output() {
        return this.unsupported();
    }

    public Nothing$ container() {
        return this.unsupported();
    }

    public Nothing$ absolute() {
        return this.unsupported();
    }

    private DirEntry ensureDir(Map<String, DirEntry> dirs2, String path) {
        DirEntry dirEntry;
        DirEntry dirEntry2 = dirs2.get(path);
        if (dirEntry2 == null) {
            DirEntry parent = this.ensureDir(dirs2, ZipArchive$.MODULE$.scala$reflect$io$ZipArchive$$dirName(path));
            DirEntry dir = new DirEntry(this, path);
            parent.entries().update(ZipArchive$.MODULE$.scala$reflect$io$ZipArchive$$baseName(path), dir);
            dirs2.put(path, dir);
            dirEntry = dir;
        } else {
            dirEntry = dirEntry2;
        }
        return dirEntry;
    }

    /*
     * WARNING - void declaration
     */
    private String dirNameUsingLast(String name) {
        void var3_3;
        String result2;
        String last = this.lastDirName;
        if (name.length() > last.length() + 1 && name.startsWith(last) && name.charAt(last.length()) == '/' && name.indexOf(47, last.length() + 1) == -1) {
            return this.lastDirName;
        }
        this.lastDirName = result2 = ZipArchive$.MODULE$.scala$reflect$io$ZipArchive$$dirName(name);
        return var3_3;
    }

    public DirEntry getDir(Map<String, DirEntry> dirs2, ZipEntry entry) {
        if (entry.isDirectory()) {
            return this.ensureDir(dirs2, entry.getName());
        }
        return this.ensureDir(dirs2, this.dirNameUsingLast(entry.getName()));
    }

    public abstract void close();

    public ZipArchive(java.io.File file, Option<String> release) {
        this.file = file;
        this.lastDirName = "";
    }

    public ZipArchive(java.io.File file) {
        this(file, None$.MODULE$);
    }

    public class DirEntry
    extends Entry {
        private final HashMap<String, Entry> entries = (HashMap)HashMap$.MODULE$.apply(Nil$.MODULE$);

        public HashMap<String, Entry> entries() {
            return this.entries;
        }

        @Override
        public boolean isDirectory() {
            return true;
        }

        @Override
        public Iterator<Entry> iterator() {
            return this.entries().valuesIterator();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Entry lookupName(String name, boolean directory) {
            void orNull_ev;
            if (directory) {
                void orNull_ev2;
                Option<Entry> option = this.entries().get(new StringBuilder(1).append(name).append("/").toString());
                Predef$.less.colon.less less2 = Predef$.MODULE$.$conforms();
                if (option == null) {
                    throw null;
                }
                Option<Entry> orNull_this = option;
                Object object = orNull_this.isEmpty() ? Option.$anonfun$orNull$1((Predef$.less.colon.less)orNull_ev2) : orNull_this.get();
                return (Entry)object;
            }
            Option<Entry> option = this.entries().get(name);
            Predef$.less.colon.less less3 = Predef$.MODULE$.$conforms();
            if (option == null) {
                throw null;
            }
            Option<Entry> orNull_this = option;
            Object object = orNull_this.isEmpty() ? Option.$anonfun$orNull$1((Predef$.less.colon.less)orNull_ev) : orNull_this.get();
            return (Entry)object;
        }

        public /* synthetic */ ZipArchive scala$reflect$io$ZipArchive$DirEntry$$$outer() {
            return this.$outer;
        }

        public DirEntry(ZipArchive $outer, String path) {
            super(path);
        }
    }

    public abstract class Entry
    extends VirtualFile {
        public ZipFile getArchive() {
            return null;
        }

        public Some<ZipArchive> underlyingSource() {
            return new Some<ZipArchive>(this.scala$reflect$io$ZipArchive$Entry$$$outer());
        }

        @Override
        public String toString() {
            return new StringBuilder(2).append(this.scala$reflect$io$ZipArchive$Entry$$$outer().path()).append("(").append(super.path()).append(")").toString();
        }

        @Override
        public byte[] unsafeToByteArray() {
            return this.toByteArray();
        }

        public /* synthetic */ ZipArchive scala$reflect$io$ZipArchive$Entry$$$outer() {
            return ZipArchive.this;
        }

        public Entry(String path) {
            if (ZipArchive.this == null) {
                throw null;
            }
            super(ZipArchive$.MODULE$.scala$reflect$io$ZipArchive$$baseName(path), path);
        }
    }
}

