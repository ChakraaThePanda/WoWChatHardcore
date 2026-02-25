/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;
import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple9;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.common.RealmListConfig;
import wowchat.common.Wow$;

@ScalaSignature(bytes="\u0006\u0001\u0005Mh\u0001B\u0017/\u0001NB\u0001\u0002\u0011\u0001\u0003\u0016\u0004%\t!\u0011\u0005\t\u001b\u0002\u0011\t\u0012)A\u0005\u0005\"Aa\n\u0001BK\u0002\u0013\u0005q\n\u0003\u0005Z\u0001\tE\t\u0015!\u0003Q\u0011!Q\u0006A!f\u0001\n\u0003Y\u0006\u0002\u00032\u0001\u0005#\u0005\u000b\u0011\u0002/\t\u0011\r\u0004!Q3A\u0005\u0002mC\u0001\u0002\u001a\u0001\u0003\u0012\u0003\u0006I\u0001\u0018\u0005\tK\u0002\u0011)\u001a!C\u0001M\"A!\u000e\u0001B\tB\u0003%q\r\u0003\u0005l\u0001\tU\r\u0011\"\u0001m\u0011!\u0019\bA!E!\u0002\u0013i\u0007\u0002\u0003;\u0001\u0005+\u0007I\u0011A!\t\u0011U\u0004!\u0011#Q\u0001\n\tC\u0001B\u001e\u0001\u0003\u0016\u0004%\t!\u0011\u0005\to\u0002\u0011\t\u0012)A\u0005\u0005\"A\u0001\u0010\u0001BK\u0002\u0013\u0005\u0011\u0010\u0003\u0005~\u0001\tE\t\u0015!\u0003{\u0011\u0015q\b\u0001\"\u0001\u0000\u0011%\t)\u0002AA\u0001\n\u0003\t9\u0002C\u0005\u0002,\u0001\t\n\u0011\"\u0001\u0002.!I\u00111\t\u0001\u0012\u0002\u0013\u0005\u0011Q\t\u0005\n\u0003\u0013\u0002\u0011\u0013!C\u0001\u0003\u0017B\u0011\"a\u0014\u0001#\u0003%\t!a\u0013\t\u0013\u0005E\u0003!%A\u0005\u0002\u0005M\u0003\"CA,\u0001E\u0005I\u0011AA-\u0011%\ti\u0006AI\u0001\n\u0003\ti\u0003C\u0005\u0002`\u0001\t\n\u0011\"\u0001\u0002.!I\u0011\u0011\r\u0001\u0012\u0002\u0013\u0005\u00111\r\u0005\n\u0003O\u0002\u0011\u0011!C!\u0003SB\u0011\"!\u001f\u0001\u0003\u0003%\t!a\u001f\t\u0013\u0005u\u0004!!A\u0005\u0002\u0005}\u0004\"CAF\u0001\u0005\u0005I\u0011IAG\u0011%\tY\nAA\u0001\n\u0003\ti\nC\u0005\u0002\"\u0002\t\t\u0011\"\u0011\u0002$\"I\u0011Q\u0015\u0001\u0002\u0002\u0013\u0005\u0013q\u0015\u0005\n\u0003S\u0003\u0011\u0011!C!\u0003W;\u0011\"a,/\u0003\u0003E\t!!-\u0007\u00115r\u0013\u0011!E\u0001\u0003gCaA`\u0014\u0005\u0002\u0005\u0005\u0007\"CASO\u0005\u0005IQIAT\u0011%\t\u0019mJA\u0001\n\u0003\u000b)\rC\u0005\u0002Z\u001e\n\t\u0011\"!\u0002\\\"I\u0011\u0011^\u0014\u0002\u0002\u0013%\u00111\u001e\u0002\u0004/><(BA\u00181\u0003\u0019\u0019w.\\7p]*\t\u0011'A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M!\u0001\u0001\u000e\u001e>!\t)\u0004(D\u00017\u0015\u00059\u0014!B:dC2\f\u0017BA\u001d7\u0005\u0019\te.\u001f*fMB\u0011QgO\u0005\u0003yY\u0012q\u0001\u0015:pIV\u001cG\u000f\u0005\u00026}%\u0011qH\u000e\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007Y>\u001c\u0017\r\\3\u0016\u0003\t\u0003\"a\u0011&\u000f\u0005\u0011C\u0005CA#7\u001b\u00051%BA$3\u0003\u0019a$o\\8u}%\u0011\u0011JN\u0001\u0007!J,G-\u001a4\n\u0005-c%AB*ue&twM\u0003\u0002Jm\u00059An\\2bY\u0016\u0004\u0013\u0001\u00039mCR4wN]7\u0016\u0003A\u0003\"!U+\u000f\u0005I\u001bV\"\u0001\u0018\n\u0005Qs\u0013\u0001\u0003)mCR4wN]7\n\u0005Y;&!\u0002,bYV,\u0017B\u0001-7\u0005-)e.^7fe\u0006$\u0018n\u001c8\u0002\u0013Ad\u0017\r\u001e4pe6\u0004\u0013A\u0003:fC2l')^5mIV\tA\fE\u00026;~K!A\u0018\u001c\u0003\r=\u0003H/[8o!\t)\u0004-\u0003\u0002bm\t\u0019\u0011J\u001c;\u0002\u0017I,\u0017\r\\7Ck&dG\rI\u0001\nO\u0006lWMQ;jY\u0012\f!bZ1nK\n+\u0018\u000e\u001c3!\u0003%\u0011X-\u00197nY&\u001cH/F\u0001h!\t\u0011\u0006.\u0003\u0002j]\ty!+Z1m[2K7\u000f^\"p]\u001aLw-\u0001\u0006sK\u0006dW\u000e\\5ti\u0002\nq!Y2d_VtG/F\u0001n!\r)d\u000e]\u0005\u0003_Z\u0012Q!\u0011:sCf\u0004\"!N9\n\u0005I4$\u0001\u0002\"zi\u0016\f\u0001\"Y2d_VtG\u000fI\u0001\ta\u0006\u001c8o^8sI\u0006I\u0001/Y:to>\u0014H\rI\u0001\nG\"\f'/Y2uKJ\f!b\u00195be\u0006\u001cG/\u001a:!\u0003A)g.\u00192mKN+'O^3s\u001b>$H-F\u0001{!\t)40\u0003\u0002}m\t9!i\\8mK\u0006t\u0017!E3oC\ndWmU3sm\u0016\u0014Xj\u001c;eA\u00051A(\u001b8jiz\"B#!\u0001\u0002\u0004\u0005\u0015\u0011qAA\u0005\u0003\u0017\ti!a\u0004\u0002\u0012\u0005M\u0001C\u0001*\u0001\u0011\u0015\u00015\u00031\u0001C\u0011\u0015q5\u00031\u0001Q\u0011\u0015Q6\u00031\u0001]\u0011\u0015\u00197\u00031\u0001]\u0011\u0015)7\u00031\u0001h\u0011\u0015Y7\u00031\u0001n\u0011\u0015!8\u00031\u0001C\u0011\u001518\u00031\u0001C\u0011\u0015A8\u00031\u0001{\u0003\u0011\u0019w\u000e]=\u0015)\u0005\u0005\u0011\u0011DA\u000e\u0003;\ty\"!\t\u0002$\u0005\u0015\u0012qEA\u0015\u0011\u001d\u0001E\u0003%AA\u0002\tCqA\u0014\u000b\u0011\u0002\u0003\u0007\u0001\u000bC\u0004[)A\u0005\t\u0019\u0001/\t\u000f\r$\u0002\u0013!a\u00019\"9Q\r\u0006I\u0001\u0002\u00049\u0007bB6\u0015!\u0003\u0005\r!\u001c\u0005\biR\u0001\n\u00111\u0001C\u0011\u001d1H\u0003%AA\u0002\tCq\u0001\u001f\u000b\u0011\u0002\u0003\u0007!0\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0005\u0005=\"f\u0001\"\u00022-\u0012\u00111\u0007\t\u0005\u0003k\ty$\u0004\u0002\u00028)!\u0011\u0011HA\u001e\u0003%)hn\u00195fG.,GMC\u0002\u0002>Y\n!\"\u00198o_R\fG/[8o\u0013\u0011\t\t%a\u000e\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0005\u0005\u001d#f\u0001)\u00022\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u001aTCAA'U\ra\u0016\u0011G\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00135\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIU*\"!!\u0016+\u0007\u001d\f\t$\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001c\u0016\u0005\u0005m#fA7\u00022\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012:\u0014AD2paf$C-\u001a4bk2$H\u0005O\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u0013:+\t\t)GK\u0002{\u0003c\tQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAA6!\u0011\ti'a\u001e\u000e\u0005\u0005=$\u0002BA9\u0003g\nA\u0001\\1oO*\u0011\u0011QO\u0001\u0005U\u00064\u0018-C\u0002L\u0003_\nA\u0002\u001d:pIV\u001cG/\u0011:jif,\u0012aX\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\u0011\t\t)a\"\u0011\u0007U\n\u0019)C\u0002\u0002\u0006Z\u00121!\u00118z\u0011!\tI\tIA\u0001\u0002\u0004y\u0016a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/\u0006\u0002\u0002\u0010B1\u0011\u0011SAL\u0003\u0003k!!a%\u000b\u0007\u0005Ue'\u0001\u0006d_2dWm\u0019;j_:LA!!'\u0002\u0014\nA\u0011\n^3sCR|'/\u0001\u0005dC:,\u0015/^1m)\rQ\u0018q\u0014\u0005\n\u0003\u0013\u0013\u0013\u0011!a\u0001\u0003\u0003\u000b\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0002?\u0006AAo\\*ue&tw\r\u0006\u0002\u0002l\u00051Q-];bYN$2A_AW\u0011%\tI)JA\u0001\u0002\u0004\t\t)A\u0002X_^\u0004\"AU\u0014\u0014\t\u001d\n),\u0010\t\u0010\u0003o\u000biL\u0011)]9\u001el'I\u0011>\u0002\u00025\u0011\u0011\u0011\u0018\u0006\u0004\u0003w3\u0014a\u0002:v]RLW.Z\u0005\u0005\u0003\u007f\u000bILA\tBEN$(/Y2u\rVt7\r^5p]f\"\"!!-\u0002\u000b\u0005\u0004\b\u000f\\=\u0015)\u0005\u0005\u0011qYAe\u0003\u0017\fi-a4\u0002R\u0006M\u0017Q[Al\u0011\u0015\u0001%\u00061\u0001C\u0011\u0015q%\u00061\u0001Q\u0011\u0015Q&\u00061\u0001]\u0011\u0015\u0019'\u00061\u0001]\u0011\u0015)'\u00061\u0001h\u0011\u0015Y'\u00061\u0001n\u0011\u0015!(\u00061\u0001C\u0011\u00151(\u00061\u0001C\u0011\u0015A(\u00061\u0001{\u0003\u001d)h.\u00199qYf$B!!8\u0002fB!Q'XAp!1)\u0014\u0011\u001d\"Q9r;WN\u0011\"{\u0013\r\t\u0019O\u000e\u0002\u0007)V\u0004H.Z\u001d\t\u0013\u0005\u001d8&!AA\u0002\u0005\u0005\u0011a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\ti\u000f\u0005\u0003\u0002n\u0005=\u0018\u0002BAy\u0003_\u0012aa\u00142kK\u000e$\b")
public class Wow
implements Product,
Serializable {
    private final String locale;
    private final Enumeration.Value platform;
    private final Option<Object> realmBuild;
    private final Option<Object> gameBuild;
    private final RealmListConfig realmlist;
    private final byte[] account;
    private final String password;
    private final String character;
    private final boolean enableServerMotd;

    public static Option<Tuple9<String, Enumeration.Value, Option<Object>, Option<Object>, RealmListConfig, byte[], String, String, Object>> unapply(Wow wow) {
        return Wow$.MODULE$.unapply(wow);
    }

    public static Wow apply(String string, Enumeration.Value value, Option<Object> option, Option<Object> option2, RealmListConfig realmListConfig, byte[] byArray, String string2, String string3, boolean bl) {
        return Wow$.MODULE$.apply(string, value, option, option2, realmListConfig, byArray, string2, string3, bl);
    }

    public static Function1<Tuple9<String, Enumeration.Value, Option<Object>, Option<Object>, RealmListConfig, byte[], String, String, Object>, Wow> tupled() {
        return Wow$.MODULE$.tupled();
    }

    public static Function1<String, Function1<Enumeration.Value, Function1<Option<Object>, Function1<Option<Object>, Function1<RealmListConfig, Function1<byte[], Function1<String, Function1<String, Function1<Object, Wow>>>>>>>>> curried() {
        return Wow$.MODULE$.curried();
    }

    public String locale() {
        return this.locale;
    }

    public Enumeration.Value platform() {
        return this.platform;
    }

    public Option<Object> realmBuild() {
        return this.realmBuild;
    }

    public Option<Object> gameBuild() {
        return this.gameBuild;
    }

    public RealmListConfig realmlist() {
        return this.realmlist;
    }

    public byte[] account() {
        return this.account;
    }

    public String password() {
        return this.password;
    }

    public String character() {
        return this.character;
    }

    public boolean enableServerMotd() {
        return this.enableServerMotd;
    }

    public Wow copy(String locale, Enumeration.Value platform, Option<Object> realmBuild, Option<Object> gameBuild, RealmListConfig realmlist, byte[] account, String password, String character, boolean enableServerMotd) {
        return new Wow(locale, platform, realmBuild, gameBuild, realmlist, account, password, character, enableServerMotd);
    }

    public String copy$default$1() {
        return this.locale();
    }

    public Enumeration.Value copy$default$2() {
        return this.platform();
    }

    public Option<Object> copy$default$3() {
        return this.realmBuild();
    }

    public Option<Object> copy$default$4() {
        return this.gameBuild();
    }

    public RealmListConfig copy$default$5() {
        return this.realmlist();
    }

    public byte[] copy$default$6() {
        return this.account();
    }

    public String copy$default$7() {
        return this.password();
    }

    public String copy$default$8() {
        return this.character();
    }

    public boolean copy$default$9() {
        return this.enableServerMotd();
    }

    @Override
    public String productPrefix() {
        return "Wow";
    }

    @Override
    public int productArity() {
        return 9;
    }

    @Override
    public Object productElement(int x$1) {
        Object object;
        int n = x$1;
        switch (n) {
            case 0: {
                object = this.locale();
                break;
            }
            case 1: {
                object = this.platform();
                break;
            }
            case 2: {
                object = this.realmBuild();
                break;
            }
            case 3: {
                object = this.gameBuild();
                break;
            }
            case 4: {
                object = this.realmlist();
                break;
            }
            case 5: {
                object = this.account();
                break;
            }
            case 6: {
                object = this.password();
                break;
            }
            case 7: {
                object = this.character();
                break;
            }
            case 8: {
                object = BoxesRunTime.boxToBoolean(this.enableServerMotd());
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
        return x$1 instanceof Wow;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.locale()));
        n = Statics.mix(n, Statics.anyHash(this.platform()));
        n = Statics.mix(n, Statics.anyHash(this.realmBuild()));
        n = Statics.mix(n, Statics.anyHash(this.gameBuild()));
        n = Statics.mix(n, Statics.anyHash(this.realmlist()));
        n = Statics.mix(n, Statics.anyHash(this.account()));
        n = Statics.mix(n, Statics.anyHash(this.password()));
        n = Statics.mix(n, Statics.anyHash(this.character()));
        n = Statics.mix(n, this.enableServerMotd() ? 1231 : 1237);
        return Statics.finalizeHash(n, 9);
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
        if (!(object instanceof Wow)) return false;
        boolean bl = true;
        if (!bl) return false;
        Wow wow = (Wow)x$1;
        String string = this.locale();
        String string2 = wow.locale();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        Enumeration.Value value = this.platform();
        Enumeration.Value value2 = wow.platform();
        if (value == null) {
            if (value2 != null) {
                return false;
            }
        } else if (!((Object)value).equals(value2)) return false;
        Option<Object> option = this.realmBuild();
        Option<Object> option2 = wow.realmBuild();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        Option<Object> option3 = this.gameBuild();
        Option<Object> option4 = wow.gameBuild();
        if (option3 == null) {
            if (option4 != null) {
                return false;
            }
        } else if (!option3.equals(option4)) return false;
        RealmListConfig realmListConfig = this.realmlist();
        RealmListConfig realmListConfig2 = wow.realmlist();
        if (realmListConfig == null) {
            if (realmListConfig2 != null) {
                return false;
            }
        } else if (!((Object)realmListConfig).equals(realmListConfig2)) return false;
        if (this.account() != wow.account()) return false;
        String string3 = this.password();
        String string4 = wow.password();
        if (string3 == null) {
            if (string4 != null) {
                return false;
            }
        } else if (!string3.equals(string4)) return false;
        String string5 = this.character();
        String string6 = wow.character();
        if (string5 == null) {
            if (string6 != null) {
                return false;
            }
        } else if (!string5.equals(string6)) return false;
        if (this.enableServerMotd() != wow.enableServerMotd()) return false;
        if (!wow.canEqual(this)) return false;
        return true;
    }

    public Wow(String locale, Enumeration.Value platform, Option<Object> realmBuild, Option<Object> gameBuild, RealmListConfig realmlist, byte[] account, String password, String character, boolean enableServerMotd) {
        this.locale = locale;
        this.platform = platform;
        this.realmBuild = realmBuild;
        this.gameBuild = gameBuild;
        this.realmlist = realmlist;
        this.account = account;
        this.password = password;
        this.character = character;
        this.enableServerMotd = enableServerMotd;
        Product.$init$(this);
    }
}

