/*
 * Decompiled with CFR 0.152.
 */
package wowchat.commands;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple7;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.commands.WhoResponse$;

@ScalaSignature(bytes="\u0006\u0001\u0005ee\u0001B\u0014)\u00016B\u0001B\u000f\u0001\u0003\u0016\u0004%\ta\u000f\u0005\t\u000f\u0002\u0011\t\u0012)A\u0005y!A\u0001\n\u0001BK\u0002\u0013\u00051\b\u0003\u0005J\u0001\tE\t\u0015!\u0003=\u0011!Q\u0005A!f\u0001\n\u0003Y\u0005\u0002C(\u0001\u0005#\u0005\u000b\u0011\u0002'\t\u0011A\u0003!Q3A\u0005\u0002mB\u0001\"\u0015\u0001\u0003\u0012\u0003\u0006I\u0001\u0010\u0005\t%\u0002\u0011)\u001a!C\u0001w!A1\u000b\u0001B\tB\u0003%A\b\u0003\u0005U\u0001\tU\r\u0011\"\u0001V\u0011!I\u0006A!E!\u0002\u00131\u0006\u0002\u0003.\u0001\u0005+\u0007I\u0011A\u001e\t\u0011m\u0003!\u0011#Q\u0001\nqBQ\u0001\u0018\u0001\u0005\u0002uCqa\u001a\u0001\u0002\u0002\u0013\u0005\u0001\u000eC\u0004q\u0001E\u0005I\u0011A9\t\u000fq\u0004\u0011\u0013!C\u0001c\"9Q\u0010AI\u0001\n\u0003q\b\u0002CA\u0001\u0001E\u0005I\u0011A9\t\u0011\u0005\r\u0001!%A\u0005\u0002ED\u0011\"!\u0002\u0001#\u0003%\t!a\u0002\t\u0011\u0005-\u0001!%A\u0005\u0002ED\u0011\"!\u0004\u0001\u0003\u0003%\t%a\u0004\t\u0011\u0005}\u0001!!A\u0005\u0002-C\u0011\"!\t\u0001\u0003\u0003%\t!a\t\t\u0013\u0005=\u0002!!A\u0005B\u0005E\u0002\"CA \u0001\u0005\u0005I\u0011AA!\u0011%\tY\u0005AA\u0001\n\u0003\ni\u0005C\u0005\u0002P\u0001\t\t\u0011\"\u0011\u0002R!I\u00111\u000b\u0001\u0002\u0002\u0013\u0005\u0013QK\u0004\n\u00033B\u0013\u0011!E\u0001\u000372\u0001b\n\u0015\u0002\u0002#\u0005\u0011Q\f\u0005\u00079\u0006\"\t!a\u001b\t\u0013\u0005=\u0013%!A\u0005F\u0005E\u0003\"CA7C\u0005\u0005I\u0011QA8\u0011%\ty(IA\u0001\n\u0003\u000b\t\tC\u0005\u0002\u0010\u0006\n\t\u0011\"\u0003\u0002\u0012\nYq\u000b[8SKN\u0004xN\\:f\u0015\tI#&\u0001\u0005d_6l\u0017M\u001c3t\u0015\u0005Y\u0013aB<po\u000eD\u0017\r^\u0002\u0001'\u0011\u0001a\u0006N\u001c\u0011\u0005=\u0012T\"\u0001\u0019\u000b\u0003E\nQa]2bY\u0006L!a\r\u0019\u0003\r\u0005s\u0017PU3g!\tyS'\u0003\u00027a\t9\u0001K]8ek\u000e$\bCA\u00189\u0013\tI\u0004G\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0006qY\u0006LXM\u001d(b[\u0016,\u0012\u0001\u0010\t\u0003{\u0011s!A\u0010\"\u0011\u0005}\u0002T\"\u0001!\u000b\u0005\u0005c\u0013A\u0002\u001fs_>$h(\u0003\u0002Da\u00051\u0001K]3eK\u001aL!!\u0012$\u0003\rM#(/\u001b8h\u0015\t\u0019\u0005'A\u0006qY\u0006LXM\u001d(b[\u0016\u0004\u0013!C4vS2$g*Y7f\u0003)9W/\u001b7e\u001d\u0006lW\rI\u0001\u0004YZdW#\u0001'\u0011\u0005=j\u0015B\u0001(1\u0005\rIe\u000e^\u0001\u0005YZd\u0007%A\u0002dYN\fAa\u00197tA\u0005!!/Y2f\u0003\u0015\u0011\u0018mY3!\u0003\u00199WM\u001c3feV\ta\u000bE\u00020/rJ!\u0001\u0017\u0019\u0003\r=\u0003H/[8o\u0003\u001d9WM\u001c3fe\u0002\nAA_8oK\u0006)!p\u001c8fA\u00051A(\u001b8jiz\"\u0002B\u00181bE\u000e$WM\u001a\t\u0003?\u0002i\u0011\u0001\u000b\u0005\u0006u=\u0001\r\u0001\u0010\u0005\u0006\u0011>\u0001\r\u0001\u0010\u0005\u0006\u0015>\u0001\r\u0001\u0014\u0005\u0006!>\u0001\r\u0001\u0010\u0005\u0006%>\u0001\r\u0001\u0010\u0005\u0006)>\u0001\rA\u0016\u0005\u00065>\u0001\r\u0001P\u0001\u0005G>\u0004\u0018\u0010\u0006\u0005_S*\\G.\u001c8p\u0011\u001dQ\u0004\u0003%AA\u0002qBq\u0001\u0013\t\u0011\u0002\u0003\u0007A\bC\u0004K!A\u0005\t\u0019\u0001'\t\u000fA\u0003\u0002\u0013!a\u0001y!9!\u000b\u0005I\u0001\u0002\u0004a\u0004b\u0002+\u0011!\u0003\u0005\rA\u0016\u0005\b5B\u0001\n\u00111\u0001=\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\u0012A\u001d\u0016\u0003yM\\\u0013\u0001\u001e\t\u0003kjl\u0011A\u001e\u0006\u0003ob\f\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005e\u0004\u0014AC1o]>$\u0018\r^5p]&\u00111P\u001e\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017AD2paf$C-\u001a4bk2$HEM\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00134+\u0005y(F\u0001't\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIQ\nabY8qs\u0012\"WMZ1vYR$S'\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001c\u0016\u0005\u0005%!F\u0001,t\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uI]\nQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAA\t!\u0011\t\u0019\"!\b\u000e\u0005\u0005U!\u0002BA\f\u00033\tA\u0001\\1oO*\u0011\u00111D\u0001\u0005U\u00064\u0018-C\u0002F\u0003+\tA\u0002\u001d:pIV\u001cG/\u0011:jif\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0003\u0002&\u0005-\u0002cA\u0018\u0002(%\u0019\u0011\u0011\u0006\u0019\u0003\u0007\u0005s\u0017\u0010\u0003\u0005\u0002.i\t\t\u00111\u0001M\u0003\rAH%M\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011\u00111\u0007\t\u0007\u0003k\tY$!\n\u000e\u0005\u0005]\"bAA\u001da\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u0005u\u0012q\u0007\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002D\u0005%\u0003cA\u0018\u0002F%\u0019\u0011q\t\u0019\u0003\u000f\t{w\u000e\\3b]\"I\u0011Q\u0006\u000f\u0002\u0002\u0003\u0007\u0011QE\u0001\tQ\u0006\u001c\bnQ8eKR\tA*\u0001\u0005u_N#(/\u001b8h)\t\t\t\"\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003\u0007\n9\u0006C\u0005\u0002.}\t\t\u00111\u0001\u0002&\u0005Yq\u000b[8SKN\u0004xN\\:f!\ty\u0016e\u0005\u0003\"\u0003?:\u0004\u0003DA1\u0003ObD\b\u0014\u001f=-rrVBAA2\u0015\r\t)\u0007M\u0001\beVtG/[7f\u0013\u0011\tI'a\u0019\u0003#\u0005\u00137\u000f\u001e:bGR4UO\\2uS>tw\u0007\u0006\u0002\u0002\\\u0005)\u0011\r\u001d9msRya,!\u001d\u0002t\u0005U\u0014qOA=\u0003w\ni\bC\u0003;I\u0001\u0007A\bC\u0003II\u0001\u0007A\bC\u0003KI\u0001\u0007A\nC\u0003QI\u0001\u0007A\bC\u0003SI\u0001\u0007A\bC\u0003UI\u0001\u0007a\u000bC\u0003[I\u0001\u0007A(A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\u0005\r\u00151\u0012\t\u0005_]\u000b)\t\u0005\u00060\u0003\u000fcD\b\u0014\u001f=-rJ1!!#1\u0005\u0019!V\u000f\u001d7fo!A\u0011QR\u0013\u0002\u0002\u0003\u0007a,A\u0002yIA\n1B]3bIJ+7o\u001c7wKR\u0011\u00111\u0013\t\u0005\u0003'\t)*\u0003\u0003\u0002\u0018\u0006U!AB(cU\u0016\u001cG\u000f")
public class WhoResponse
implements Product,
Serializable {
    private final String playerName;
    private final String guildName;
    private final int lvl;
    private final String cls;
    private final String race;
    private final Option<String> gender;
    private final String zone;

    public static Option<Tuple7<String, String, Object, String, String, Option<String>, String>> unapply(WhoResponse whoResponse) {
        return WhoResponse$.MODULE$.unapply(whoResponse);
    }

    public static WhoResponse apply(String string, String string2, int n, String string3, String string4, Option<String> option, String string5) {
        return WhoResponse$.MODULE$.apply(string, string2, n, string3, string4, option, string5);
    }

    public static Function1<Tuple7<String, String, Object, String, String, Option<String>, String>, WhoResponse> tupled() {
        return WhoResponse$.MODULE$.tupled();
    }

    public static Function1<String, Function1<String, Function1<Object, Function1<String, Function1<String, Function1<Option<String>, Function1<String, WhoResponse>>>>>>> curried() {
        return WhoResponse$.MODULE$.curried();
    }

    public String playerName() {
        return this.playerName;
    }

    public String guildName() {
        return this.guildName;
    }

    public int lvl() {
        return this.lvl;
    }

    public String cls() {
        return this.cls;
    }

    public String race() {
        return this.race;
    }

    public Option<String> gender() {
        return this.gender;
    }

    public String zone() {
        return this.zone;
    }

    public WhoResponse copy(String playerName, String guildName, int lvl, String cls, String race, Option<String> gender, String zone) {
        return new WhoResponse(playerName, guildName, lvl, cls, race, gender, zone);
    }

    public String copy$default$1() {
        return this.playerName();
    }

    public String copy$default$2() {
        return this.guildName();
    }

    public int copy$default$3() {
        return this.lvl();
    }

    public String copy$default$4() {
        return this.cls();
    }

    public String copy$default$5() {
        return this.race();
    }

    public Option<String> copy$default$6() {
        return this.gender();
    }

    public String copy$default$7() {
        return this.zone();
    }

    @Override
    public String productPrefix() {
        return "WhoResponse";
    }

    @Override
    public int productArity() {
        return 7;
    }

    @Override
    public Object productElement(int x$1) {
        Object object;
        int n = x$1;
        switch (n) {
            case 0: {
                object = this.playerName();
                break;
            }
            case 1: {
                object = this.guildName();
                break;
            }
            case 2: {
                object = BoxesRunTime.boxToInteger(this.lvl());
                break;
            }
            case 3: {
                object = this.cls();
                break;
            }
            case 4: {
                object = this.race();
                break;
            }
            case 5: {
                object = this.gender();
                break;
            }
            case 6: {
                object = this.zone();
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
        return x$1 instanceof WhoResponse;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.playerName()));
        n = Statics.mix(n, Statics.anyHash(this.guildName()));
        n = Statics.mix(n, this.lvl());
        n = Statics.mix(n, Statics.anyHash(this.cls()));
        n = Statics.mix(n, Statics.anyHash(this.race()));
        n = Statics.mix(n, Statics.anyHash(this.gender()));
        n = Statics.mix(n, Statics.anyHash(this.zone()));
        return Statics.finalizeHash(n, 7);
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
        if (!(object instanceof WhoResponse)) return false;
        boolean bl = true;
        if (!bl) return false;
        WhoResponse whoResponse = (WhoResponse)x$1;
        String string = this.playerName();
        String string2 = whoResponse.playerName();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        String string3 = this.guildName();
        String string4 = whoResponse.guildName();
        if (string3 == null) {
            if (string4 != null) {
                return false;
            }
        } else if (!string3.equals(string4)) return false;
        if (this.lvl() != whoResponse.lvl()) return false;
        String string5 = this.cls();
        String string6 = whoResponse.cls();
        if (string5 == null) {
            if (string6 != null) {
                return false;
            }
        } else if (!string5.equals(string6)) return false;
        String string7 = this.race();
        String string8 = whoResponse.race();
        if (string7 == null) {
            if (string8 != null) {
                return false;
            }
        } else if (!string7.equals(string8)) return false;
        Option<String> option = this.gender();
        Option<String> option2 = whoResponse.gender();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        String string9 = this.zone();
        String string10 = whoResponse.zone();
        if (string9 == null) {
            if (string10 != null) {
                return false;
            }
        } else if (!string9.equals(string10)) return false;
        if (!whoResponse.canEqual(this)) return false;
        return true;
    }

    public WhoResponse(String playerName, String guildName, int lvl, String cls, String race, Option<String> gender, String zone) {
        this.playerName = playerName;
        this.guildName = guildName;
        this.lvl = lvl;
        this.cls = cls;
        this.race = race;
        this.gender = gender;
        this.zone = zone;
        Product.$init$(this);
    }
}

