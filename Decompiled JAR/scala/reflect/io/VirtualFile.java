/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import scala.Array$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.collection.Iterator;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.NoAbstractFile$;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005eb\u0001B\u000e\u001d\u0001\rB\u0001\u0002\u000b\u0001\u0003\u0006\u0004%\t!\u000b\u0005\tk\u0001\u0011\t\u0011)A\u0005U!Aa\u0007\u0001BC\u0002\u0013\u0005\u0013\u0006\u0003\u00058\u0001\t\u0005\t\u0015!\u0003+\u0011\u0015A\u0004\u0001\"\u0001:\u0011\u0015A\u0004\u0001\"\u0001>\u0011\u0015y\u0004\u0001\"\u0011A\u0011\u0015)\u0005\u0001\"\u0011G\u0011\u001dy\u0005\u00011A\u0005\nACqa\u0016\u0001A\u0002\u0013%\u0001\f\u0003\u0004_\u0001\u0001\u0006K!\u0015\u0005\u0006?\u0002!\t\u0001\u0019\u0005\u0006C\u0002!\tA\u0019\u0005\u0006U\u0002!\te\u001b\u0005\u0006_\u0002!\t\u0001\u001d\u0005\u0006i\u0002!\t%\u001e\u0005\u0006s\u0002!\t\u0005\u0015\u0005\u0006u\u0002!\ta\u001f\u0005\u0006y\u0002!\t! \u0005\u0006}\u0002!\t% \u0005\u0007\u007f\u0002!\t!!\u0001\t\u000f\u0005%\u0001\u0001\"\u0001\u0002\f!9\u00111\u0004\u0001\u0005\u0002\u0005u\u0001bBA\u0010\u0001\u0011\u0005\u0011Q\u0004\u0005\b\u0003C\u0001A\u0011AA\u0012\u0011\u001d\tY\u0003\u0001C\u0001\u0003[\u00111BV5siV\fGNR5mK*\u0011QDH\u0001\u0003S>T!a\b\u0011\u0002\u000fI,g\r\\3di*\t\u0011%A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001!\u0003CA\u0013'\u001b\u0005a\u0012BA\u0014\u001d\u00051\t%m\u001d;sC\u000e$h)\u001b7f\u0003\u0011q\u0017-\\3\u0016\u0003)\u0002\"a\u000b\u001a\u000f\u00051\u0002\u0004CA\u0017!\u001b\u0005q#BA\u0018#\u0003\u0019a$o\\8u}%\u0011\u0011\u0007I\u0001\u0007!J,G-\u001a4\n\u0005M\"$AB*ue&twM\u0003\u00022A\u0005)a.Y7fA\u0005!\u0001/\u0019;i\u0003\u0015\u0001\u0018\r\u001e5!\u0003\u0019a\u0014N\\5u}Q\u0019!h\u000f\u001f\u0011\u0005\u0015\u0002\u0001\"\u0002\u0015\u0006\u0001\u0004Q\u0003\"\u0002\u001c\u0006\u0001\u0004QCC\u0001\u001e?\u0011\u0015Ac\u00011\u0001+\u0003!A\u0017m\u001d5D_\u0012,G#A!\u0011\u0005\t\u001bU\"\u0001\u0011\n\u0005\u0011\u0003#aA%oi\u00061Q-];bYN$\"a\u0012&\u0011\u0005\tC\u0015BA%!\u0005\u001d\u0011un\u001c7fC:DQa\u0013\u0005A\u00021\u000bA\u0001\u001e5biB\u0011!)T\u0005\u0003\u001d\u0002\u00121!\u00118z\u0003\u001d\u0019wN\u001c;f]R,\u0012!\u0015\t\u0004\u0005J#\u0016BA*!\u0005\u0015\t%O]1z!\t\u0011U+\u0003\u0002WA\t!!)\u001f;f\u0003-\u0019wN\u001c;f]R|F%Z9\u0015\u0005ec\u0006C\u0001\"[\u0013\tY\u0006E\u0001\u0003V]&$\bbB/\u000b\u0003\u0003\u0005\r!U\u0001\u0004q\u0012\n\u0014\u0001C2p]R,g\u000e\u001e\u0011\u0002\u0011\u0005\u00147o\u001c7vi\u0016,\u0012AO\u0001\u0005M&dW-F\u0001d!\t!\u0007.D\u0001f\u0015\tibMC\u0001h\u0003\u0011Q\u0017M^1\n\u0005%,'\u0001\u0002$jY\u0016\f!b]5{K>\u0003H/[8o+\u0005a\u0007c\u0001\"n\u0003&\u0011a\u000e\t\u0002\u0007\u001fB$\u0018n\u001c8\u0002\u000b%t\u0007/\u001e;\u0016\u0003E\u0004\"\u0001\u001a:\n\u0005M,'aC%oaV$8\u000b\u001e:fC6\faa\\;uaV$X#\u0001<\u0011\u0005\u0011<\u0018B\u0001=f\u00051yU\u000f\u001e9viN#(/Z1n\u0003E)hn]1gKR{')\u001f;f\u0003J\u0014\u0018-_\u0001\nG>tG/Y5oKJ,\u0012\u0001J\u0001\fSN$\u0015N]3di>\u0014\u00180F\u0001H\u0003%I7OV5siV\fG.\u0001\u0007mCN$Xj\u001c3jM&,G-\u0006\u0002\u0002\u0004A\u0019!)!\u0002\n\u0007\u0005\u001d\u0001E\u0001\u0003M_:<\u0017\u0001C5uKJ\fGo\u001c:\u0016\u0005\u00055\u0001#BA\b\u0003+!cb\u0001\"\u0002\u0012%\u0019\u00111\u0003\u0011\u0002\u000fA\f7m[1hK&!\u0011qCA\r\u0005!IE/\u001a:bi>\u0014(bAA\nA\u000511M]3bi\u0016$\u0012!W\u0001\u0007I\u0016dW\r^3\u0002\u00151|wn[;q\u001d\u0006lW\rF\u0003%\u0003K\t9\u0003C\u0003)3\u0001\u0007!\u0006\u0003\u0004\u0002*e\u0001\raR\u0001\nI&\u0014Xm\u0019;pef\f1\u0003\\8pWV\u0004h*Y7f+:\u001c\u0007.Z2lK\u0012$b!a\f\u00026\u0005]\u0002c\u0001\"\u00022%\u0019\u00111\u0007\u0011\u0003\u000f9{G\u000f[5oO\")\u0001F\u0007a\u0001U!1\u0011\u0011\u0006\u000eA\u0002\u001d\u0003")
public class VirtualFile
extends AbstractFile {
    private final String name;
    private final String path;
    private byte[] scala$reflect$io$VirtualFile$$content;

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String path() {
        return this.path;
    }

    public int hashCode() {
        return this.path().hashCode();
    }

    @Override
    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof VirtualFile) {
            String string = ((VirtualFile)that).path();
            String string2 = this.path();
            bl = !(string != null ? !string.equals(string2) : string2 != null);
        } else {
            bl = false;
        }
        return bl;
    }

    private byte[] scala$reflect$io$VirtualFile$$content() {
        return this.scala$reflect$io$VirtualFile$$content;
    }

    public void scala$reflect$io$VirtualFile$$content_$eq(byte[] x$1) {
        this.scala$reflect$io$VirtualFile$$content = x$1;
    }

    @Override
    public VirtualFile absolute() {
        return this;
    }

    @Override
    public File file() {
        return null;
    }

    @Override
    public Option<Object> sizeOption() {
        return new Some<Object>(BoxesRunTime.boxToInteger(this.scala$reflect$io$VirtualFile$$content().length));
    }

    @Override
    public InputStream input() {
        return new ByteArrayInputStream(this.scala$reflect$io$VirtualFile$$content());
    }

    @Override
    public OutputStream output() {
        return new ByteArrayOutputStream(this){
            private final /* synthetic */ VirtualFile $outer;

            public void close() {
                super.close();
                this.$outer.scala$reflect$io$VirtualFile$$content_$eq(this.toByteArray());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        };
    }

    @Override
    public byte[] unsafeToByteArray() {
        return this.scala$reflect$io$VirtualFile$$content();
    }

    @Override
    public AbstractFile container() {
        return NoAbstractFile$.MODULE$;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isVirtual() {
        return true;
    }

    @Override
    public long lastModified() {
        return 0L;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Iterator<AbstractFile> iterator() {
        void assert_assertion;
        boolean bl = this.isDirectory();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)VirtualFile.$anonfun$iterator$1(this)).toString());
        }
        return package$.MODULE$.Iterator().empty();
    }

    @Override
    public void create() {
        throw this.unsupported();
    }

    @Override
    public void delete() {
        throw this.unsupported();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public AbstractFile lookupName(String name, boolean directory) {
        void assert_assertion;
        boolean bl = this.isDirectory();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)VirtualFile.$anonfun$lookupName$1(this)).toString());
        }
        return null;
    }

    public Nothing$ lookupNameUnchecked(String name, boolean directory) {
        return this.unsupported();
    }

    public static final /* synthetic */ String $anonfun$iterator$1(VirtualFile $this) {
        return new StringBuilder(18).append("not a directory '").append($this).append("'").toString();
    }

    public static final /* synthetic */ String $anonfun$lookupName$1(VirtualFile $this) {
        return new StringBuilder(18).append("not a directory '").append($this).append("'").toString();
    }

    public VirtualFile(String name, String path) {
        this.name = name;
        this.path = path;
        this.scala$reflect$io$VirtualFile$$content = Array$.MODULE$.emptyByteArray();
    }

    public VirtualFile(String name) {
        this(name, name);
    }
}

