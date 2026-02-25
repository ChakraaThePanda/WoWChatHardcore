/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple3;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.common.RealmListConfig$;

@ScalaSignature(bytes="\u0006\u0001\u0005%c\u0001B\u000e\u001d\u0001\u0006B\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\tw\u0001\u0011\t\u0012)A\u0005a!AA\b\u0001BK\u0002\u0013\u0005q\u0006\u0003\u0005>\u0001\tE\t\u0015!\u00031\u0011!q\u0004A!f\u0001\n\u0003y\u0004\u0002C\"\u0001\u0005#\u0005\u000b\u0011\u0002!\t\u000b\u0011\u0003A\u0011A#\t\u000f-\u0003\u0011\u0011!C\u0001\u0019\"9\u0001\u000bAI\u0001\n\u0003\t\u0006b\u0002/\u0001#\u0003%\t!\u0015\u0005\b;\u0002\t\n\u0011\"\u0001_\u0011\u001d\u0001\u0007!!A\u0005B\u0005Dq!\u001b\u0001\u0002\u0002\u0013\u0005q\bC\u0004k\u0001\u0005\u0005I\u0011A6\t\u000fE\u0004\u0011\u0011!C!e\"9\u0011\u0010AA\u0001\n\u0003Q\b\u0002C@\u0001\u0003\u0003%\t%!\u0001\t\u0013\u0005\r\u0001!!A\u0005B\u0005\u0015\u0001\"CA\u0004\u0001\u0005\u0005I\u0011IA\u0005\u000f%\ti\u0001HA\u0001\u0012\u0003\tyA\u0002\u0005\u001c9\u0005\u0005\t\u0012AA\t\u0011\u0019!U\u0003\"\u0001\u0002 !I\u00111A\u000b\u0002\u0002\u0013\u0015\u0013Q\u0001\u0005\n\u0003C)\u0012\u0011!CA\u0003GA\u0011\"a\u000b\u0016\u0003\u0003%\t)!\f\t\u0013\u0005}R#!A\u0005\n\u0005\u0005#a\u0004*fC2lG*[:u\u0007>tg-[4\u000b\u0005uq\u0012AB2p[6|gNC\u0001 \u0003\u001d9xn^2iCR\u001c\u0001a\u0005\u0003\u0001E!Z\u0003CA\u0012'\u001b\u0005!#\"A\u0013\u0002\u000bM\u001c\u0017\r\\1\n\u0005\u001d\"#AB!osJ+g\r\u0005\u0002$S%\u0011!\u0006\n\u0002\b!J|G-^2u!\t\u0019C&\u0003\u0002.I\ta1+\u001a:jC2L'0\u00192mK\u0006!a.Y7f+\u0005\u0001\u0004CA\u00199\u001d\t\u0011d\u0007\u0005\u00024I5\tAG\u0003\u00026A\u00051AH]8pizJ!a\u000e\u0013\u0002\rA\u0013X\rZ3g\u0013\tI$H\u0001\u0004TiJLgn\u001a\u0006\u0003o\u0011\nQA\\1nK\u0002\nA\u0001[8ti\u0006)\u0001n\\:uA\u0005!\u0001o\u001c:u+\u0005\u0001\u0005CA\u0012B\u0013\t\u0011EEA\u0002J]R\fQ\u0001]8si\u0002\na\u0001P5oSRtD\u0003\u0002$I\u0013*\u0003\"a\u0012\u0001\u000e\u0003qAQAL\u0004A\u0002ABQ\u0001P\u0004A\u0002ABQAP\u0004A\u0002\u0001\u000bAaY8qsR!a)\u0014(P\u0011\u001dq\u0003\u0002%AA\u0002ABq\u0001\u0010\u0005\u0011\u0002\u0003\u0007\u0001\u0007C\u0004?\u0011A\u0005\t\u0019\u0001!\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\t!K\u000b\u00021'.\nA\u000b\u0005\u0002V56\taK\u0003\u0002X1\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u00033\u0012\n!\"\u00198o_R\fG/[8o\u0013\tYfKA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fabY8qs\u0012\"WMZ1vYR$#'\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001a\u0016\u0003}S#\u0001Q*\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\u0005\u0011\u0007CA2i\u001b\u0005!'BA3g\u0003\u0011a\u0017M\\4\u000b\u0003\u001d\fAA[1wC&\u0011\u0011\bZ\u0001\raJ|G-^2u\u0003JLG/_\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\taw\u000e\u0005\u0002$[&\u0011a\u000e\n\u0002\u0004\u0003:L\bb\u00029\u000f\u0003\u0003\u0005\r\u0001Q\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0003M\u00042\u0001^<m\u001b\u0005)(B\u0001<%\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0003qV\u0014\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR\u00111P \t\u0003GqL!! \u0013\u0003\u000f\t{w\u000e\\3b]\"9\u0001\u000fEA\u0001\u0002\u0004a\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003\u0001\u000b\u0001\u0002^8TiJLgn\u001a\u000b\u0002E\u00061Q-];bYN$2a_A\u0006\u0011\u001d\u00018#!AA\u00021\fqBU3bY6d\u0015n\u001d;D_:4\u0017n\u001a\t\u0003\u000fV\u0019B!FA\nWAA\u0011QCA\u000eaA\u0002e)\u0004\u0002\u0002\u0018)\u0019\u0011\u0011\u0004\u0013\u0002\u000fI,h\u000e^5nK&!\u0011QDA\f\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gn\r\u000b\u0003\u0003\u001f\tQ!\u00199qYf$rARA\u0013\u0003O\tI\u0003C\u0003/1\u0001\u0007\u0001\u0007C\u0003=1\u0001\u0007\u0001\u0007C\u0003?1\u0001\u0007\u0001)A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\u0005=\u00121\b\t\u0006G\u0005E\u0012QG\u0005\u0004\u0003g!#AB(qi&|g\u000e\u0005\u0004$\u0003o\u0001\u0004\u0007Q\u0005\u0004\u0003s!#A\u0002+va2,7\u0007\u0003\u0005\u0002>e\t\t\u00111\u0001G\u0003\rAH\u0005M\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002DA\u00191-!\u0012\n\u0007\u0005\u001dCM\u0001\u0004PE*,7\r\u001e")
public class RealmListConfig
implements Product,
Serializable {
    private final String name;
    private final String host;
    private final int port;

    public static Option<Tuple3<String, String, Object>> unapply(RealmListConfig realmListConfig) {
        return RealmListConfig$.MODULE$.unapply(realmListConfig);
    }

    public static RealmListConfig apply(String string, String string2, int n) {
        return RealmListConfig$.MODULE$.apply(string, string2, n);
    }

    public static Function1<Tuple3<String, String, Object>, RealmListConfig> tupled() {
        return RealmListConfig$.MODULE$.tupled();
    }

    public static Function1<String, Function1<String, Function1<Object, RealmListConfig>>> curried() {
        return RealmListConfig$.MODULE$.curried();
    }

    public String name() {
        return this.name;
    }

    public String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public RealmListConfig copy(String name, String host, int port) {
        return new RealmListConfig(name, host, port);
    }

    public String copy$default$1() {
        return this.name();
    }

    public String copy$default$2() {
        return this.host();
    }

    public int copy$default$3() {
        return this.port();
    }

    @Override
    public String productPrefix() {
        return "RealmListConfig";
    }

    @Override
    public int productArity() {
        return 3;
    }

    @Override
    public Object productElement(int x$1) {
        Object object;
        int n = x$1;
        switch (n) {
            case 0: {
                object = this.name();
                break;
            }
            case 1: {
                object = this.host();
                break;
            }
            case 2: {
                object = BoxesRunTime.boxToInteger(this.port());
                break;
            }
            default: {
                throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
            }
        }
        return object;
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof RealmListConfig;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.name()));
        n = Statics.mix(n, Statics.anyHash(this.host()));
        n = Statics.mix(n, this.port());
        return Statics.finalizeHash(n, 3);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        Object object = x$1;
        if (!(object instanceof RealmListConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        RealmListConfig realmListConfig = (RealmListConfig)x$1;
        String string = this.name();
        String string2 = realmListConfig.name();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        String string3 = this.host();
        String string4 = realmListConfig.host();
        if (string3 == null) {
            if (string4 != null) {
                return false;
            }
        } else if (!string3.equals(string4)) return false;
        if (this.port() != realmListConfig.port()) return false;
        if (!realmListConfig.canEqual(this)) return false;
        return true;
    }

    public RealmListConfig(String name, String host, int port) {
        this.name = name;
        this.host = host;
        this.port = port;
        Product.$init$(this);
    }
}

