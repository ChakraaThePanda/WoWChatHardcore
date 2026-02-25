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
import wowchat.common.GuildNotificationConfig$;

@ScalaSignature(bytes="\u0006\u0001\u0005Mc\u0001B\u000e\u001d\u0001\u0006B\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\tg\u0001\u0011\t\u0012)A\u0005a!AA\u0007\u0001BK\u0002\u0013\u0005Q\u0007\u0003\u0005B\u0001\tE\t\u0015!\u00037\u0011!\u0011\u0005A!f\u0001\n\u0003\u0019\u0005\u0002C$\u0001\u0005#\u0005\u000b\u0011\u0002#\t\u000b!\u0003A\u0011A%\t\u000f=\u0003\u0011\u0011!C\u0001!\"9A\u000bAI\u0001\n\u0003)\u0006b\u00021\u0001#\u0003%\t!\u0019\u0005\bG\u0002\t\n\u0011\"\u0001e\u0011\u001d1\u0007!!A\u0005B\u001dDqa\u001c\u0001\u0002\u0002\u0013\u0005\u0001\u000fC\u0004u\u0001\u0005\u0005I\u0011A;\t\u000fm\u0004\u0011\u0011!C!y\"I\u0011q\u0001\u0001\u0002\u0002\u0013\u0005\u0011\u0011\u0002\u0005\n\u0003\u001b\u0001\u0011\u0011!C!\u0003\u001fA\u0011\"!\u0005\u0001\u0003\u0003%\t%a\u0005\t\u0013\u0005U\u0001!!A\u0005B\u0005]q!CA\u000e9\u0005\u0005\t\u0012AA\u000f\r!YB$!A\t\u0002\u0005}\u0001B\u0002%\u0016\t\u0003\ti\u0003C\u0005\u0002\u0012U\t\t\u0011\"\u0012\u0002\u0014!I\u0011qF\u000b\u0002\u0002\u0013\u0005\u0015\u0011\u0007\u0005\n\u0003s)\u0012\u0011!CA\u0003wA\u0011\"!\u0013\u0016\u0003\u0003%I!a\u0013\u0003/\u001d+\u0018\u000e\u001c3O_RLg-[2bi&|gnQ8oM&<'BA\u000f\u001f\u0003\u0019\u0019w.\\7p]*\tq$A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M!\u0001A\t\u0015,!\t\u0019c%D\u0001%\u0015\u0005)\u0013!B:dC2\f\u0017BA\u0014%\u0005\u0019\te.\u001f*fMB\u00111%K\u0005\u0003U\u0011\u0012q\u0001\u0015:pIV\u001cG\u000f\u0005\u0002$Y%\u0011Q\u0006\n\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\bK:\f'\r\\3e+\u0005\u0001\u0004CA\u00122\u0013\t\u0011DEA\u0004C_>dW-\u00198\u0002\u0011\u0015t\u0017M\u00197fI\u0002\naAZ8s[\u0006$X#\u0001\u001c\u0011\u0005]rdB\u0001\u001d=!\tID%D\u0001;\u0015\tY\u0004%\u0001\u0004=e>|GOP\u0005\u0003{\u0011\na\u0001\u0015:fI\u00164\u0017BA A\u0005\u0019\u0019FO]5oO*\u0011Q\bJ\u0001\bM>\u0014X.\u0019;!\u0003\u001d\u0019\u0007.\u00198oK2,\u0012\u0001\u0012\t\u0004G\u00153\u0014B\u0001$%\u0005\u0019y\u0005\u000f^5p]\u0006A1\r[1o]\u0016d\u0007%\u0001\u0004=S:LGO\u0010\u000b\u0005\u00152ke\n\u0005\u0002L\u00015\tA\u0004C\u0003/\u000f\u0001\u0007\u0001\u0007C\u00035\u000f\u0001\u0007a\u0007C\u0003C\u000f\u0001\u0007A)\u0001\u0003d_BLH\u0003\u0002&R%NCqA\f\u0005\u0011\u0002\u0003\u0007\u0001\u0007C\u00045\u0011A\u0005\t\u0019\u0001\u001c\t\u000f\tC\u0001\u0013!a\u0001\t\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#\u0001,+\u0005A:6&\u0001-\u0011\u0005esV\"\u0001.\u000b\u0005mc\u0016!C;oG\",7m[3e\u0015\tiF%\u0001\u0006b]:|G/\u0019;j_:L!a\u0018.\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0003\tT#AN,\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%gU\tQM\u000b\u0002E/\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012\u0001\u001b\t\u0003S:l\u0011A\u001b\u0006\u0003W2\fA\u0001\\1oO*\tQ.\u0001\u0003kCZ\f\u0017BA k\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005\t\bCA\u0012s\u0013\t\u0019HEA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0002wsB\u00111e^\u0005\u0003q\u0012\u00121!\u00118z\u0011\u001dQh\"!AA\u0002E\f1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#A?\u0011\ty\f\u0019A^\u0007\u0002\u007f*\u0019\u0011\u0011\u0001\u0013\u0002\u0015\r|G\u000e\\3di&|g.C\u0002\u0002\u0006}\u0014\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR\u0019\u0001'a\u0003\t\u000fi\u0004\u0012\u0011!a\u0001m\u0006A\u0001.Y:i\u0007>$W\rF\u0001r\u0003!!xn\u0015;sS:<G#\u00015\u0002\r\u0015\fX/\u00197t)\r\u0001\u0014\u0011\u0004\u0005\buN\t\t\u00111\u0001w\u0003]9U/\u001b7e\u001d>$\u0018NZ5dCRLwN\\\"p]\u001aLw\r\u0005\u0002L+M!Q#!\t,!!\t\u0019#!\u000b1m\u0011SUBAA\u0013\u0015\r\t9\u0003J\u0001\beVtG/[7f\u0013\u0011\tY#!\n\u0003#\u0005\u00137\u000f\u001e:bGR4UO\\2uS>t7\u0007\u0006\u0002\u0002\u001e\u0005)\u0011\r\u001d9msR9!*a\r\u00026\u0005]\u0002\"\u0002\u0018\u0019\u0001\u0004\u0001\u0004\"\u0002\u001b\u0019\u0001\u00041\u0004\"\u0002\"\u0019\u0001\u0004!\u0015aB;oCB\u0004H.\u001f\u000b\u0005\u0003{\t)\u0005\u0005\u0003$\u000b\u0006}\u0002CB\u0012\u0002BA2D)C\u0002\u0002D\u0011\u0012a\u0001V;qY\u0016\u001c\u0004\u0002CA$3\u0005\u0005\t\u0019\u0001&\u0002\u0007a$\u0003'A\u0006sK\u0006$'+Z:pYZ,GCAA'!\rI\u0017qJ\u0005\u0004\u0003#R'AB(cU\u0016\u001cG\u000f")
public class GuildNotificationConfig
implements Product,
Serializable {
    private final boolean enabled;
    private final String format;
    private final Option<String> channel;

    public static Option<Tuple3<Object, String, Option<String>>> unapply(GuildNotificationConfig guildNotificationConfig) {
        return GuildNotificationConfig$.MODULE$.unapply(guildNotificationConfig);
    }

    public static GuildNotificationConfig apply(boolean bl, String string, Option<String> option) {
        return GuildNotificationConfig$.MODULE$.apply(bl, string, option);
    }

    public static Function1<Tuple3<Object, String, Option<String>>, GuildNotificationConfig> tupled() {
        return GuildNotificationConfig$.MODULE$.tupled();
    }

    public static Function1<Object, Function1<String, Function1<Option<String>, GuildNotificationConfig>>> curried() {
        return GuildNotificationConfig$.MODULE$.curried();
    }

    public boolean enabled() {
        return this.enabled;
    }

    public String format() {
        return this.format;
    }

    public Option<String> channel() {
        return this.channel;
    }

    public GuildNotificationConfig copy(boolean enabled, String format, Option<String> channel) {
        return new GuildNotificationConfig(enabled, format, channel);
    }

    public boolean copy$default$1() {
        return this.enabled();
    }

    public String copy$default$2() {
        return this.format();
    }

    public Option<String> copy$default$3() {
        return this.channel();
    }

    @Override
    public String productPrefix() {
        return "GuildNotificationConfig";
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
                object = BoxesRunTime.boxToBoolean(this.enabled());
                break;
            }
            case 1: {
                object = this.format();
                break;
            }
            case 2: {
                object = this.channel();
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
        return x$1 instanceof GuildNotificationConfig;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, this.enabled() ? 1231 : 1237);
        n = Statics.mix(n, Statics.anyHash(this.format()));
        n = Statics.mix(n, Statics.anyHash(this.channel()));
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
        if (!(object instanceof GuildNotificationConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        GuildNotificationConfig guildNotificationConfig = (GuildNotificationConfig)x$1;
        if (this.enabled() != guildNotificationConfig.enabled()) return false;
        String string = this.format();
        String string2 = guildNotificationConfig.format();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        Option<String> option = this.channel();
        Option<String> option2 = guildNotificationConfig.channel();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        if (!guildNotificationConfig.canEqual(this)) return false;
        return true;
    }

    public GuildNotificationConfig(boolean enabled, String format, Option<String> channel) {
        this.enabled = enabled;
        this.format = format;
        this.channel = channel;
        Product.$init$(this);
    }
}

