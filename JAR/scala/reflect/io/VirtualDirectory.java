/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.mutable.Map;
import scala.collection.mutable.Map$;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.VirtualFile;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.Null$;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005a\u0001B\r\u001b\u0001\u0005B\u0001B\n\u0001\u0003\u0006\u0004%\ta\n\u0005\tg\u0001\u0011\t\u0011)A\u0005Q!AA\u0007\u0001B\u0001B\u0003%Q\u0007C\u0003;\u0001\u0011\u00051\bC\u0003?\u0001\u0011\u0005q\u0005C\u0003@\u0001\u0011\u0005\u0001\tC\u0003B\u0001\u0011\u0005\u0001\tC\u0003C\u0001\u0011\u00051\tC\u0003H\u0001\u0011\u00053\tC\u0004I\u0001\t\u0007I\u0011A%\t\r5\u0003\u0001\u0015!\u0003K\u0011\u0015q\u0005\u0001\"\u0011P\u0011\u0015\u0019\u0006\u0001\"\u0011U\u0011\u0015A\u0006\u0001\"\u0011U\u0011\u0015I\u0006\u0001\"\u0001[\u0011\u0015q\u0006\u0001\"\u0001[\u0011\u0015y\u0006\u0001\"\u0001a\u0011\u001d!\u0007A1A\u0005\n\u0015DaA\u001c\u0001!\u0002\u00131\u0007\"B8\u0001\t\u0003\u0001\b\"B;\u0001\t\u00032\b\"B=\u0001\t\u0003R\b\"\u0002?\u0001\t\u0003j\b\"B@\u0001\t\u0003Q&\u0001\u0005,jeR,\u0018\r\u001c#je\u0016\u001cGo\u001c:z\u0015\tYB$\u0001\u0002j_*\u0011QDH\u0001\be\u00164G.Z2u\u0015\u0005y\u0012!B:dC2\f7\u0001A\n\u0003\u0001\t\u0002\"a\t\u0013\u000e\u0003iI!!\n\u000e\u0003\u0019\u0005\u00137\u000f\u001e:bGR4\u0015\u000e\\3\u0002\t9\fW.Z\u000b\u0002QA\u0011\u0011\u0006\r\b\u0003U9\u0002\"a\u000b\u0010\u000e\u00031R!!\f\u0011\u0002\rq\u0012xn\u001c;?\u0013\tyc$\u0001\u0004Qe\u0016$WMZ\u0005\u0003cI\u0012aa\u0015;sS:<'BA\u0018\u001f\u0003\u0015q\u0017-\\3!\u00039i\u0017-\u001f2f\u0007>tG/Y5oKJ\u00042AN\u001c:\u001b\u0005q\u0012B\u0001\u001d\u001f\u0005\u0019y\u0005\u000f^5p]B\u00111\u0005A\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007ebT\bC\u0003'\t\u0001\u0007\u0001\u0006C\u00035\t\u0001\u0007Q'\u0001\u0003qCRD\u0017\u0001C1cg>dW\u000f^3\u0016\u0003e\n\u0011bY8oi\u0006Lg.\u001a:\u0002\u0017%\u001cH)\u001b:fGR|'/_\u000b\u0002\tB\u0011a'R\u0005\u0003\rz\u0011qAQ8pY\u0016\fg.A\u0005jgZK'\u000f^;bY\u0006aA.Y:u\u001b>$\u0017NZ5fIV\t!\n\u0005\u00027\u0017&\u0011AJ\b\u0002\u0005\u0019>tw-A\u0007mCN$Xj\u001c3jM&,G\rI\u0001\u0005M&dW-F\u0001Q!\t1\u0014+\u0003\u0002S=\t!a*\u001e7m\u0003\u0015Ig\u000e];u+\u0005)\u0006C\u0001\u001cW\u0013\t9fDA\u0004O_RD\u0017N\\4\u0002\r=,H\u000f];u\u0003\u0019\u0019'/Z1uKR\t1\f\u0005\u000279&\u0011QL\b\u0002\u0005+:LG/\u0001\u0004eK2,G/Z\u0001\u0014Y>|7.\u001e9OC6,WK\\2iK\u000e\\W\r\u001a\u000b\u0004E\u0005\u0014\u0007\"\u0002\u0014\u0012\u0001\u0004A\u0003\"B2\u0012\u0001\u0004!\u0015!\u00033je\u0016\u001cGo\u001c:z\u0003\u00151\u0017\u000e\\3t+\u00051\u0007\u0003B4mQ\tj\u0011\u0001\u001b\u0006\u0003S*\fq!\\;uC\ndWM\u0003\u0002l=\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u00055D'aA'ba\u00061a-\u001b7fg\u0002\n\u0001\"\u001b;fe\u0006$xN]\u000b\u0002cB\u0019!o\u001d\u0012\u000e\u0003)L!\u0001\u001e6\u0003\u0011%#XM]1u_J\f!\u0002\\8pWV\u0004h*Y7f)\r\u0011s\u000f\u001f\u0005\u0006MU\u0001\r\u0001\u000b\u0005\u0006GV\u0001\r\u0001R\u0001\nM&dWMT1nK\u0012$\"AI>\t\u000b\u00192\u0002\u0019\u0001\u0015\u0002#M,(\rZ5sK\u000e$xN]=OC6,G\r\u0006\u0002#}\")ae\u0006a\u0001Q\u0005)1\r\\3be\u0002")
public class VirtualDirectory
extends AbstractFile {
    private final String name;
    private final Option<VirtualDirectory> maybeContainer;
    private final long lastModified;
    private final Map<String, AbstractFile> files;

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String path() {
        String string;
        Option<VirtualDirectory> option = this.maybeContainer;
        if (None$.MODULE$.equals(option)) {
            string = this.name();
        } else if (option instanceof Some) {
            VirtualDirectory parent = (VirtualDirectory)((Some)option).value();
            string = new StringBuilder(0).append(parent.path()).append('/').append(this.name()).toString();
        } else {
            throw new MatchError(option);
        }
        return string;
    }

    @Override
    public VirtualDirectory absolute() {
        return this;
    }

    @Override
    public VirtualDirectory container() {
        return this.maybeContainer.get();
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isVirtual() {
        return true;
    }

    @Override
    public long lastModified() {
        return this.lastModified;
    }

    public Null$ file() {
        return null;
    }

    public Nothing$ input() {
        return package$.MODULE$.error("directories cannot be read");
    }

    public Nothing$ output() {
        return package$.MODULE$.error("directories cannot be written");
    }

    @Override
    public void create() {
        throw this.unsupported();
    }

    @Override
    public void delete() {
        throw this.unsupported();
    }

    @Override
    public AbstractFile lookupNameUnchecked(String name, boolean directory) {
        throw this.unsupported();
    }

    private Map<String, AbstractFile> files() {
        return this.files;
    }

    @Override
    public Iterator<AbstractFile> iterator() {
        return this.files().values().toList().iterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public AbstractFile lookupName(String name, boolean directory) {
        void orNull_ev;
        AbstractFile abstractFile;
        None$ none$ = this.files().get(name);
        if (none$ == null) {
            throw null;
        }
        None$ filter_this = none$;
        None$ none$2 = ((Option)filter_this).isEmpty() || VirtualDirectory.$anonfun$lookupName$1(directory, abstractFile = (AbstractFile)((Option)filter_this).get()) ? filter_this : None$.MODULE$;
        Predef$.less.colon.less less2 = Predef$.MODULE$.$conforms();
        if (none$2 == null) {
            throw null;
        }
        Object object = ((Option)none$2).isEmpty() ? Option.$anonfun$orNull$1((Predef$.less.colon.less)orNull_ev) : ((Option)none$2).get();
        return (AbstractFile)object;
    }

    @Override
    public AbstractFile fileNamed(String name) {
        Option<AbstractFile> option = Option$.MODULE$.apply(this.lookupName(name, false));
        if (option == null) {
            throw null;
        }
        Option<AbstractFile> getOrElse_this = option;
        AbstractFile abstractFile = getOrElse_this.isEmpty() ? VirtualDirectory.$anonfun$fileNamed$1(this, name) : getOrElse_this.get();
        return abstractFile;
    }

    @Override
    public AbstractFile subdirectoryNamed(String name) {
        Option<AbstractFile> option = Option$.MODULE$.apply(this.lookupName(name, true));
        if (option == null) {
            throw null;
        }
        Option<AbstractFile> getOrElse_this = option;
        AbstractFile abstractFile = getOrElse_this.isEmpty() ? VirtualDirectory.$anonfun$subdirectoryNamed$1(this, name) : getOrElse_this.get();
        return abstractFile;
    }

    public void clear() {
        this.files().clear();
    }

    public static final /* synthetic */ boolean $anonfun$lookupName$1(boolean directory$1, AbstractFile x$1) {
        return x$1.isDirectory() == directory$1;
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ VirtualFile $anonfun$fileNamed$1(VirtualDirectory $this, String name$1) {
        void var2_2;
        VirtualFile newFile = new VirtualFile(name$1, new StringBuilder(0).append($this.path()).append('/').append(name$1).toString());
        $this.files().update(name$1, newFile);
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ VirtualDirectory $anonfun$subdirectoryNamed$1(VirtualDirectory $this, String name$2) {
        void var2_2;
        VirtualDirectory dir = new VirtualDirectory(name$2, new Some<VirtualDirectory>($this));
        $this.files().update(name$2, dir);
        return var2_2;
    }

    public VirtualDirectory(String name, Option<VirtualDirectory> maybeContainer) {
        this.name = name;
        this.maybeContainer = maybeContainer;
        this.lastModified = System.currentTimeMillis();
        this.files = Map$.MODULE$.empty();
    }

    public static final /* synthetic */ Object $anonfun$lookupName$1$adapted(boolean directory$1, AbstractFile x$1) {
        return BoxesRunTime.boxToBoolean(VirtualDirectory.$anonfun$lookupName$1(directory$1, x$1));
    }
}

