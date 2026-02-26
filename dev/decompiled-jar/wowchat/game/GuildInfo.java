/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.immutable.Map;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import wowchat.game.GuildInfo$;

@ScalaSignature(bytes="\u0006\u0001\u0005}b\u0001\u0002\r\u001a\u0001zA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\tq\u0001\u0011\t\u0012)A\u0005[!A\u0011\b\u0001BK\u0002\u0013\u0005!\b\u0003\u0005B\u0001\tE\t\u0015!\u0003<\u0011\u0015\u0011\u0005\u0001\"\u0001D\u0011\u001dA\u0005!!A\u0005\u0002%Cq\u0001\u0014\u0001\u0012\u0002\u0013\u0005Q\nC\u0004Y\u0001E\u0005I\u0011A-\t\u000fm\u0003\u0011\u0011!C!9\"9A\rAA\u0001\n\u0003)\u0007b\u00024\u0001\u0003\u0003%\ta\u001a\u0005\b[\u0002\t\t\u0011\"\u0011o\u0011\u001d)\b!!A\u0005\u0002YDqa\u001f\u0001\u0002\u0002\u0013\u0005C\u0010C\u0004~\u0001\u0005\u0005I\u0011\t@\t\u0011}\u0004\u0011\u0011!C!\u0003\u00039\u0011\"!\u0002\u001a\u0003\u0003E\t!a\u0002\u0007\u0011aI\u0012\u0011!E\u0001\u0003\u0013AaA\u0011\n\u0005\u0002\u0005]\u0001bB?\u0013\u0003\u0003%)E \u0005\n\u00033\u0011\u0012\u0011!CA\u00037A\u0011\"!\t\u0013\u0003\u0003%\t)a\t\t\u0013\u0005U\"#!A\u0005\n\u0005]\"!C$vS2$\u0017J\u001c4p\u0015\tQ2$\u0001\u0003hC6,'\"\u0001\u000f\u0002\u000f]|wo\u00195bi\u000e\u00011\u0003\u0002\u0001 K!\u0002\"\u0001I\u0012\u000e\u0003\u0005R\u0011AI\u0001\u0006g\u000e\fG.Y\u0005\u0003I\u0005\u0012a!\u00118z%\u00164\u0007C\u0001\u0011'\u0013\t9\u0013EA\u0004Qe>$Wo\u0019;\u0011\u0005\u0001J\u0013B\u0001\u0016\"\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0011q\u0017-\\3\u0016\u00035\u0002\"AL\u001b\u000f\u0005=\u001a\u0004C\u0001\u0019\"\u001b\u0005\t$B\u0001\u001a\u001e\u0003\u0019a$o\\8u}%\u0011A'I\u0001\u0007!J,G-\u001a4\n\u0005Y:$AB*ue&twM\u0003\u00025C\u0005)a.Y7fA\u0005)!/\u00198lgV\t1\b\u0005\u0003/yyj\u0013BA\u001f8\u0005\ri\u0015\r\u001d\t\u0003A}J!\u0001Q\u0011\u0003\u0007%sG/\u0001\u0004sC:\\7\u000fI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007\u00113u\t\u0005\u0002F\u00015\t\u0011\u0004C\u0003,\u000b\u0001\u0007Q\u0006C\u0003:\u000b\u0001\u00071(\u0001\u0003d_BLHc\u0001#K\u0017\"91F\u0002I\u0001\u0002\u0004i\u0003bB\u001d\u0007!\u0003\u0005\raO\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0005q%FA\u0017PW\u0005\u0001\u0006CA)W\u001b\u0005\u0011&BA*U\u0003%)hn\u00195fG.,GM\u0003\u0002VC\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005]\u0013&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012T#\u0001.+\u0005mz\u0015!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001^!\tq6-D\u0001`\u0015\t\u0001\u0017-\u0001\u0003mC:<'\"\u00012\u0002\t)\fg/Y\u0005\u0003m}\u000bA\u0002\u001d:pIV\u001cG/\u0011:jif,\u0012AP\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\tA7\u000e\u0005\u0002!S&\u0011!.\t\u0002\u0004\u0003:L\bb\u00027\f\u0003\u0003\u0005\rAP\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0003=\u00042\u0001]:i\u001b\u0005\t(B\u0001:\"\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0003iF\u0014\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR\u0011qO\u001f\t\u0003AaL!!_\u0011\u0003\u000f\t{w\u000e\\3b]\"9A.DA\u0001\u0002\u0004A\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003y\n\u0001\u0002^8TiJLgn\u001a\u000b\u0002;\u00061Q-];bYN$2a^A\u0002\u0011\u001da\u0007#!AA\u0002!\f\u0011bR;jY\u0012LeNZ8\u0011\u0005\u0015\u00132\u0003\u0002\n\u0002\f!\u0002r!!\u0004\u0002\u00145ZD)\u0004\u0002\u0002\u0010)\u0019\u0011\u0011C\u0011\u0002\u000fI,h\u000e^5nK&!\u0011QCA\b\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gN\r\u000b\u0003\u0003\u000f\tQ!\u00199qYf$R\u0001RA\u000f\u0003?AQaK\u000bA\u00025BQ!O\u000bA\u0002m\nq!\u001e8baBd\u0017\u0010\u0006\u0003\u0002&\u0005E\u0002#\u0002\u0011\u0002(\u0005-\u0012bAA\u0015C\t1q\n\u001d;j_:\u0004R\u0001IA\u0017[mJ1!a\f\"\u0005\u0019!V\u000f\u001d7fe!A\u00111\u0007\f\u0002\u0002\u0003\u0007A)A\u0002yIA\n1B]3bIJ+7o\u001c7wKR\u0011\u0011\u0011\b\t\u0004=\u0006m\u0012bAA\u001f?\n1qJ\u00196fGR\u0004")
public class GuildInfo
implements Product,
Serializable {
    private final String name;
    private final Map<Object, String> ranks;

    public static Option<Tuple2<String, Map<Object, String>>> unapply(GuildInfo guildInfo) {
        return GuildInfo$.MODULE$.unapply(guildInfo);
    }

    public static GuildInfo apply(String string, Map<Object, String> map) {
        return GuildInfo$.MODULE$.apply(string, map);
    }

    public static Function1<Tuple2<String, Map<Object, String>>, GuildInfo> tupled() {
        return GuildInfo$.MODULE$.tupled();
    }

    public static Function1<String, Function1<Map<Object, String>, GuildInfo>> curried() {
        return GuildInfo$.MODULE$.curried();
    }

    public String name() {
        return this.name;
    }

    public Map<Object, String> ranks() {
        return this.ranks;
    }

    public GuildInfo copy(String name, Map<Object, String> ranks) {
        return new GuildInfo(name, ranks);
    }

    public String copy$default$1() {
        return this.name();
    }

    public Map<Object, String> copy$default$2() {
        return this.ranks();
    }

    @Override
    public String productPrefix() {
        return "GuildInfo";
    }

    @Override
    public int productArity() {
        return 2;
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
                object = this.ranks();
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
        return x$1 instanceof GuildInfo;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
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
        if (!(object instanceof GuildInfo)) return false;
        boolean bl = true;
        if (!bl) return false;
        GuildInfo guildInfo = (GuildInfo)x$1;
        String string = this.name();
        String string2 = guildInfo.name();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        Map<Object, String> map = this.ranks();
        Map<Object, String> map2 = guildInfo.ranks();
        if (map == null) {
            if (map2 != null) {
                return false;
            }
        } else if (!map.equals(map2)) return false;
        if (!guildInfo.canEqual(this)) return false;
        return true;
    }

    public GuildInfo(String name, Map<Object, String> ranks) {
        this.name = name;
        this.ranks = ranks;
        Product.$init$(this);
    }
}

