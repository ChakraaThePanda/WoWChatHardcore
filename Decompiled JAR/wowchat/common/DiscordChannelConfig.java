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
import wowchat.common.DiscordChannelConfig$;
import wowchat.common.FiltersConfig;

@ScalaSignature(bytes="\u0006\u0001\u0005Mc\u0001B\u000e\u001d\u0001\u0006B\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\tw\u0001\u0011\t\u0012)A\u0005a!AA\b\u0001BK\u0002\u0013\u0005q\u0006\u0003\u0005>\u0001\tE\t\u0015!\u00031\u0011!q\u0004A!f\u0001\n\u0003y\u0004\u0002C$\u0001\u0005#\u0005\u000b\u0011\u0002!\t\u000b!\u0003A\u0011A%\t\u000f9\u0003\u0011\u0011!C\u0001\u001f\"91\u000bAI\u0001\n\u0003!\u0006bB0\u0001#\u0003%\t\u0001\u0016\u0005\bA\u0002\t\n\u0011\"\u0001b\u0011\u001d\u0019\u0007!!A\u0005B\u0011Dq\u0001\u001c\u0001\u0002\u0002\u0013\u0005Q\u000eC\u0004r\u0001\u0005\u0005I\u0011\u0001:\t\u000fa\u0004\u0011\u0011!C!s\"I\u0011\u0011\u0001\u0001\u0002\u0002\u0013\u0005\u00111\u0001\u0005\n\u0003\u001b\u0001\u0011\u0011!C!\u0003\u001fA\u0011\"!\u0005\u0001\u0003\u0003%\t%a\u0005\t\u0013\u0005U\u0001!!A\u0005B\u0005]q!CA\u000e9\u0005\u0005\t\u0012AA\u000f\r!YB$!A\t\u0002\u0005}\u0001B\u0002%\u0016\t\u0003\ti\u0003C\u0005\u0002\u0012U\t\t\u0011\"\u0012\u0002\u0014!I\u0011qF\u000b\u0002\u0002\u0013\u0005\u0015\u0011\u0007\u0005\n\u0003s)\u0012\u0011!CA\u0003wA\u0011\"!\u0013\u0016\u0003\u0003%I!a\u0013\u0003)\u0011K7oY8sI\u000eC\u0017M\u001c8fY\u000e{gNZ5h\u0015\tib$\u0001\u0004d_6lwN\u001c\u0006\u0002?\u00059qo\\<dQ\u0006$8\u0001A\n\u0005\u0001\tB3\u0006\u0005\u0002$M5\tAEC\u0001&\u0003\u0015\u00198-\u00197b\u0013\t9CE\u0001\u0004B]f\u0014VM\u001a\t\u0003G%J!A\u000b\u0013\u0003\u000fA\u0013x\u000eZ;diB\u00111\u0005L\u0005\u0003[\u0011\u0012AbU3sS\u0006d\u0017N_1cY\u0016\fqa\u00195b]:,G.F\u00011!\t\t\u0004H\u0004\u00023mA\u00111\u0007J\u0007\u0002i)\u0011Q\u0007I\u0001\u0007yI|w\u000e\u001e \n\u0005]\"\u0013A\u0002)sK\u0012,g-\u0003\u0002:u\t11\u000b\u001e:j]\u001eT!a\u000e\u0013\u0002\u0011\rD\u0017M\u001c8fY\u0002\naAZ8s[\u0006$\u0018a\u00024pe6\fG\u000fI\u0001\bM&dG/\u001a:t+\u0005\u0001\u0005cA\u0012B\u0007&\u0011!\t\n\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u0005\u0011+U\"\u0001\u000f\n\u0005\u0019c\"!\u0004$jYR,'o]\"p]\u001aLw-\u0001\u0005gS2$XM]:!\u0003\u0019a\u0014N\\5u}Q!!j\u0013'N!\t!\u0005\u0001C\u0003/\u000f\u0001\u0007\u0001\u0007C\u0003=\u000f\u0001\u0007\u0001\u0007C\u0003?\u000f\u0001\u0007\u0001)\u0001\u0003d_BLH\u0003\u0002&Q#JCqA\f\u0005\u0011\u0002\u0003\u0007\u0001\u0007C\u0004=\u0011A\u0005\t\u0019\u0001\u0019\t\u000fyB\u0001\u0013!a\u0001\u0001\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#A++\u0005A26&A,\u0011\u0005akV\"A-\u000b\u0005i[\u0016!C;oG\",7m[3e\u0015\taF%\u0001\u0006b]:|G/\u0019;j_:L!AX-\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%gU\t!M\u000b\u0002A-\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012!\u001a\t\u0003M.l\u0011a\u001a\u0006\u0003Q&\fA\u0001\\1oO*\t!.\u0001\u0003kCZ\f\u0017BA\u001dh\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005q\u0007CA\u0012p\u0013\t\u0001HEA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0002tmB\u00111\u0005^\u0005\u0003k\u0012\u00121!\u00118z\u0011\u001d9h\"!AA\u00029\f1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#\u0001>\u0011\u0007mt8/D\u0001}\u0015\tiH%\u0001\u0006d_2dWm\u0019;j_:L!a ?\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0003\u000b\tY\u0001E\u0002$\u0003\u000fI1!!\u0003%\u0005\u001d\u0011un\u001c7fC:Dqa\u001e\t\u0002\u0002\u0003\u00071/\u0001\u0005iCND7i\u001c3f)\u0005q\u0017\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003\u0015\fa!Z9vC2\u001cH\u0003BA\u0003\u00033Aqa^\n\u0002\u0002\u0003\u00071/\u0001\u000bESN\u001cwN\u001d3DQ\u0006tg.\u001a7D_:4\u0017n\u001a\t\u0003\tV\u0019B!FA\u0011WAA\u00111EA\u0015aA\u0002%*\u0004\u0002\u0002&)\u0019\u0011q\u0005\u0013\u0002\u000fI,h\u000e^5nK&!\u00111FA\u0013\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gn\r\u000b\u0003\u0003;\tQ!\u00199qYf$rASA\u001a\u0003k\t9\u0004C\u0003/1\u0001\u0007\u0001\u0007C\u0003=1\u0001\u0007\u0001\u0007C\u0003?1\u0001\u0007\u0001)A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\u0005u\u0012Q\t\t\u0005G\u0005\u000by\u0004\u0005\u0004$\u0003\u0003\u0002\u0004\u0007Q\u0005\u0004\u0003\u0007\"#A\u0002+va2,7\u0007\u0003\u0005\u0002He\t\t\u00111\u0001K\u0003\rAH\u0005M\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002NA\u0019a-a\u0014\n\u0007\u0005EsM\u0001\u0004PE*,7\r\u001e")
public class DiscordChannelConfig
implements Product,
Serializable {
    private final String channel;
    private final String format;
    private final Option<FiltersConfig> filters;

    public static Option<Tuple3<String, String, Option<FiltersConfig>>> unapply(DiscordChannelConfig discordChannelConfig) {
        return DiscordChannelConfig$.MODULE$.unapply(discordChannelConfig);
    }

    public static DiscordChannelConfig apply(String string, String string2, Option<FiltersConfig> option) {
        return DiscordChannelConfig$.MODULE$.apply(string, string2, option);
    }

    public static Function1<Tuple3<String, String, Option<FiltersConfig>>, DiscordChannelConfig> tupled() {
        return DiscordChannelConfig$.MODULE$.tupled();
    }

    public static Function1<String, Function1<String, Function1<Option<FiltersConfig>, DiscordChannelConfig>>> curried() {
        return DiscordChannelConfig$.MODULE$.curried();
    }

    public String channel() {
        return this.channel;
    }

    public String format() {
        return this.format;
    }

    public Option<FiltersConfig> filters() {
        return this.filters;
    }

    public DiscordChannelConfig copy(String channel, String format, Option<FiltersConfig> filters) {
        return new DiscordChannelConfig(channel, format, filters);
    }

    public String copy$default$1() {
        return this.channel();
    }

    public String copy$default$2() {
        return this.format();
    }

    public Option<FiltersConfig> copy$default$3() {
        return this.filters();
    }

    @Override
    public String productPrefix() {
        return "DiscordChannelConfig";
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
                object = this.channel();
                break;
            }
            case 1: {
                object = this.format();
                break;
            }
            case 2: {
                object = this.filters();
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
        return x$1 instanceof DiscordChannelConfig;
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
        if (!(object instanceof DiscordChannelConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        DiscordChannelConfig discordChannelConfig = (DiscordChannelConfig)x$1;
        String string = this.channel();
        String string2 = discordChannelConfig.channel();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        String string3 = this.format();
        String string4 = discordChannelConfig.format();
        if (string3 == null) {
            if (string4 != null) {
                return false;
            }
        } else if (!string3.equals(string4)) return false;
        Option<FiltersConfig> option = this.filters();
        Option<FiltersConfig> option2 = discordChannelConfig.filters();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        if (!discordChannelConfig.canEqual(this)) return false;
        return true;
    }

    public DiscordChannelConfig(String channel, String format, Option<FiltersConfig> filters) {
        this.channel = channel;
        this.format = format;
        this.filters = filters;
        Product.$init$(this);
    }
}

