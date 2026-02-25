/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple6;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.game.GuildMember$;

@ScalaSignature(bytes="\u0006\u0001\u0005ue\u0001\u0002\u0013&\u0001*B\u0001b\u000e\u0001\u0003\u0016\u0004%\t\u0001\u000f\u0005\t\t\u0002\u0011\t\u0012)A\u0005s!AQ\t\u0001BK\u0002\u0013\u0005a\t\u0003\u0005K\u0001\tE\t\u0015!\u0003H\u0011!Y\u0005A!f\u0001\n\u0003a\u0005\u0002\u0003)\u0001\u0005#\u0005\u000b\u0011B'\t\u0011E\u0003!Q3A\u0005\u00021C\u0001B\u0015\u0001\u0003\u0012\u0003\u0006I!\u0014\u0005\t'\u0002\u0011)\u001a!C\u0001)\"A\u0001\f\u0001B\tB\u0003%Q\u000b\u0003\u0005Z\u0001\tU\r\u0011\"\u0001[\u0011!q\u0006A!E!\u0002\u0013Y\u0006\"B0\u0001\t\u0003\u0001\u0007bB5\u0001\u0003\u0003%\tA\u001b\u0005\bc\u0002\t\n\u0011\"\u0001s\u0011\u001di\b!%A\u0005\u0002yD\u0011\"!\u0001\u0001#\u0003%\t!a\u0001\t\u0013\u0005\u001d\u0001!%A\u0005\u0002\u0005\r\u0001\"CA\u0005\u0001E\u0005I\u0011AA\u0006\u0011%\ty\u0001AI\u0001\n\u0003\t\t\u0002C\u0005\u0002\u0016\u0001\t\t\u0011\"\u0011\u0002\u0018!A\u0011q\u0005\u0001\u0002\u0002\u0013\u0005A\u000bC\u0005\u0002*\u0001\t\t\u0011\"\u0001\u0002,!I\u0011q\u0007\u0001\u0002\u0002\u0013\u0005\u0013\u0011\b\u0005\n\u0003\u000f\u0002\u0011\u0011!C\u0001\u0003\u0013B\u0011\"!\u0014\u0001\u0003\u0003%\t%a\u0014\t\u0013\u0005E\u0003!!A\u0005B\u0005M\u0003\"CA+\u0001\u0005\u0005I\u0011IA,\u000f%\tY&JA\u0001\u0012\u0003\tiF\u0002\u0005%K\u0005\u0005\t\u0012AA0\u0011\u0019yf\u0004\"\u0001\u0002n!I\u0011\u0011\u000b\u0010\u0002\u0002\u0013\u0015\u00131\u000b\u0005\n\u0003_r\u0012\u0011!CA\u0003cB\u0011\"a \u001f\u0003\u0003%\t)!!\t\u0013\u0005Me$!A\u0005\n\u0005U%aC$vS2$W*Z7cKJT!AJ\u0014\u0002\t\u001d\fW.\u001a\u0006\u0002Q\u00059qo\\<dQ\u0006$8\u0001A\n\u0005\u0001-\nD\u0007\u0005\u0002-_5\tQFC\u0001/\u0003\u0015\u00198-\u00197b\u0013\t\u0001TF\u0001\u0004B]f\u0014VM\u001a\t\u0003YIJ!aM\u0017\u0003\u000fA\u0013x\u000eZ;diB\u0011A&N\u0005\u0003m5\u0012AbU3sS\u0006d\u0017N_1cY\u0016\fAA\\1nKV\t\u0011\b\u0005\u0002;\u0003:\u00111h\u0010\t\u0003y5j\u0011!\u0010\u0006\u0003}%\na\u0001\u0010:p_Rt\u0014B\u0001!.\u0003\u0019\u0001&/\u001a3fM&\u0011!i\u0011\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005\u0001k\u0013!\u00028b[\u0016\u0004\u0013\u0001C5t\u001f:d\u0017N\\3\u0016\u0003\u001d\u0003\"\u0001\f%\n\u0005%k#a\u0002\"p_2,\u0017M\\\u0001\nSN|e\u000e\\5oK\u0002\n\u0011b\u00195be\u000ec\u0017m]:\u0016\u00035\u0003\"\u0001\f(\n\u0005=k#\u0001\u0002\"zi\u0016\f!b\u00195be\u000ec\u0017m]:!\u0003\u0015aWM^3m\u0003\u0019aWM^3mA\u00051!p\u001c8f\u0013\u0012,\u0012!\u0016\t\u0003YYK!aV\u0017\u0003\u0007%sG/A\u0004{_:,\u0017\n\u001a\u0011\u0002\u00151\f7\u000f\u001e'pO>4g-F\u0001\\!\taC,\u0003\u0002^[\t)a\t\\8bi\u0006YA.Y:u\u0019><wN\u001a4!\u0003\u0019a\u0014N\\5u}Q9\u0011m\u00193fM\u001eD\u0007C\u00012\u0001\u001b\u0005)\u0003\"B\u001c\u000e\u0001\u0004I\u0004\"B#\u000e\u0001\u00049\u0005\"B&\u000e\u0001\u0004i\u0005\"B)\u000e\u0001\u0004i\u0005\"B*\u000e\u0001\u0004)\u0006\"B-\u000e\u0001\u0004Y\u0016\u0001B2paf$r!Y6m[:|\u0007\u000fC\u00048\u001dA\u0005\t\u0019A\u001d\t\u000f\u0015s\u0001\u0013!a\u0001\u000f\"91J\u0004I\u0001\u0002\u0004i\u0005bB)\u000f!\u0003\u0005\r!\u0014\u0005\b':\u0001\n\u00111\u0001V\u0011\u001dIf\u0002%AA\u0002m\u000babY8qs\u0012\"WMZ1vYR$\u0013'F\u0001tU\tIDoK\u0001v!\t180D\u0001x\u0015\tA\u00180A\u0005v]\u000eDWmY6fI*\u0011!0L\u0001\u000bC:tw\u000e^1uS>t\u0017B\u0001?x\u0005E)hn\u00195fG.,GMV1sS\u0006t7-Z\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00133+\u0005y(FA$u\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIM*\"!!\u0002+\u00055#\u0018AD2paf$C-\u001a4bk2$H\u0005N\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00136+\t\tiA\u000b\u0002Vi\u0006q1m\u001c9zI\u0011,g-Y;mi\u00122TCAA\nU\tYF/A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0003\u00033\u0001B!a\u0007\u0002&5\u0011\u0011Q\u0004\u0006\u0005\u0003?\t\t#\u0001\u0003mC:<'BAA\u0012\u0003\u0011Q\u0017M^1\n\u0007\t\u000bi\"\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\t\u00055\u00121\u0007\t\u0004Y\u0005=\u0012bAA\u0019[\t\u0019\u0011I\\=\t\u0011\u0005Ur#!AA\u0002U\u000b1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XCAA\u001e!\u0019\ti$a\u0011\u0002.5\u0011\u0011q\b\u0006\u0004\u0003\u0003j\u0013AC2pY2,7\r^5p]&!\u0011QIA \u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\u0007\u001d\u000bY\u0005C\u0005\u00026e\t\t\u00111\u0001\u0002.\u0005A\u0001.Y:i\u0007>$W\rF\u0001V\u0003!!xn\u0015;sS:<GCAA\r\u0003\u0019)\u0017/^1mgR\u0019q)!\u0017\t\u0013\u0005UB$!AA\u0002\u00055\u0012aC$vS2$W*Z7cKJ\u0004\"A\u0019\u0010\u0014\ty\t\t\u0007\u000e\t\f\u0003G\nI'O$N\u001bV[\u0016-\u0004\u0002\u0002f)\u0019\u0011qM\u0017\u0002\u000fI,h\u000e^5nK&!\u00111NA3\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gN\u000e\u000b\u0003\u0003;\nQ!\u00199qYf$R\"YA:\u0003k\n9(!\u001f\u0002|\u0005u\u0004\"B\u001c\"\u0001\u0004I\u0004\"B#\"\u0001\u00049\u0005\"B&\"\u0001\u0004i\u0005\"B)\"\u0001\u0004i\u0005\"B*\"\u0001\u0004)\u0006\"B-\"\u0001\u0004Y\u0016aB;oCB\u0004H.\u001f\u000b\u0005\u0003\u0007\u000by\tE\u0003-\u0003\u000b\u000bI)C\u0002\u0002\b6\u0012aa\u00149uS>t\u0007#\u0003\u0017\u0002\ff:U*T+\\\u0013\r\ti)\f\u0002\u0007)V\u0004H.\u001a\u001c\t\u0011\u0005E%%!AA\u0002\u0005\f1\u0001\u001f\u00131\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005]\u0005\u0003BA\u000e\u00033KA!a'\u0002\u001e\t1qJ\u00196fGR\u0004")
public class GuildMember
implements Product,
Serializable {
    private final String name;
    private final boolean isOnline;
    private final byte charClass;
    private final byte level;
    private final int zoneId;
    private final float lastLogoff;

    public static Option<Tuple6<String, Object, Object, Object, Object, Object>> unapply(GuildMember guildMember) {
        return GuildMember$.MODULE$.unapply(guildMember);
    }

    public static GuildMember apply(String string, boolean bl, byte by, byte by2, int n, float f) {
        return GuildMember$.MODULE$.apply(string, bl, by, by2, n, f);
    }

    public static Function1<Tuple6<String, Object, Object, Object, Object, Object>, GuildMember> tupled() {
        return GuildMember$.MODULE$.tupled();
    }

    public static Function1<String, Function1<Object, Function1<Object, Function1<Object, Function1<Object, Function1<Object, GuildMember>>>>>> curried() {
        return GuildMember$.MODULE$.curried();
    }

    public String name() {
        return this.name;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public byte charClass() {
        return this.charClass;
    }

    public byte level() {
        return this.level;
    }

    public int zoneId() {
        return this.zoneId;
    }

    public float lastLogoff() {
        return this.lastLogoff;
    }

    public GuildMember copy(String name, boolean isOnline, byte charClass, byte level, int zoneId, float lastLogoff) {
        return new GuildMember(name, isOnline, charClass, level, zoneId, lastLogoff);
    }

    public String copy$default$1() {
        return this.name();
    }

    public boolean copy$default$2() {
        return this.isOnline();
    }

    public byte copy$default$3() {
        return this.charClass();
    }

    public byte copy$default$4() {
        return this.level();
    }

    public int copy$default$5() {
        return this.zoneId();
    }

    public float copy$default$6() {
        return this.lastLogoff();
    }

    @Override
    public String productPrefix() {
        return "GuildMember";
    }

    @Override
    public int productArity() {
        return 6;
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
                object = BoxesRunTime.boxToBoolean(this.isOnline());
                break;
            }
            case 2: {
                object = BoxesRunTime.boxToByte(this.charClass());
                break;
            }
            case 3: {
                object = BoxesRunTime.boxToByte(this.level());
                break;
            }
            case 4: {
                object = BoxesRunTime.boxToInteger(this.zoneId());
                break;
            }
            case 5: {
                object = BoxesRunTime.boxToFloat(this.lastLogoff());
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
        return x$1 instanceof GuildMember;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.name()));
        n = Statics.mix(n, this.isOnline() ? 1231 : 1237);
        n = Statics.mix(n, this.charClass());
        n = Statics.mix(n, this.level());
        n = Statics.mix(n, this.zoneId());
        n = Statics.mix(n, Statics.floatHash(this.lastLogoff()));
        return Statics.finalizeHash(n, 6);
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
        if (!(object instanceof GuildMember)) return false;
        boolean bl = true;
        if (!bl) return false;
        GuildMember guildMember = (GuildMember)x$1;
        String string = this.name();
        String string2 = guildMember.name();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (this.isOnline() != guildMember.isOnline()) return false;
        if (this.charClass() != guildMember.charClass()) return false;
        if (this.level() != guildMember.level()) return false;
        if (this.zoneId() != guildMember.zoneId()) return false;
        if (this.lastLogoff() != guildMember.lastLogoff()) return false;
        if (!guildMember.canEqual(this)) return false;
        return true;
    }

    public GuildMember(String name, boolean isOnline, byte charClass, byte level, int zoneId, float lastLogoff) {
        this.name = name;
        this.isOnline = isOnline;
        this.charClass = charClass;
        this.level = level;
        this.zoneId = zoneId;
        this.lastLogoff = lastLogoff;
        Product.$init$(this);
    }
}

