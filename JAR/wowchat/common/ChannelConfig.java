/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;
import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple3;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import wowchat.common.ChannelConfig$;
import wowchat.common.DiscordChannelConfig;
import wowchat.common.WowChannelConfig;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015d\u0001B\u000e\u001d\u0001\u0006B\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\t}\u0001\u0011\t\u0012)A\u0005a!Aq\b\u0001BK\u0002\u0013\u0005\u0001\t\u0003\u0005F\u0001\tE\t\u0015!\u0003B\u0011!1\u0005A!f\u0001\n\u00039\u0005\u0002C&\u0001\u0005#\u0005\u000b\u0011\u0002%\t\u000b1\u0003A\u0011A'\t\u000fI\u0003\u0011\u0011!C\u0001'\"9q\u000bAI\u0001\n\u0003A\u0006bB2\u0001#\u0003%\t\u0001\u001a\u0005\bM\u0002\t\n\u0011\"\u0001h\u0011\u001dI\u0007!!A\u0005B)Dqa\u001d\u0001\u0002\u0002\u0013\u0005A\u000fC\u0004y\u0001\u0005\u0005I\u0011A=\t\u0011}\u0004\u0011\u0011!C!\u0003\u0003A\u0011\"a\u0004\u0001\u0003\u0003%\t!!\u0005\t\u0013\u0005m\u0001!!A\u0005B\u0005u\u0001\"CA\u0010\u0001\u0005\u0005I\u0011IA\u0011\u0011%\t\u0019\u0003AA\u0001\n\u0003\n)cB\u0005\u0002*q\t\t\u0011#\u0001\u0002,\u0019A1\u0004HA\u0001\u0012\u0003\ti\u0003\u0003\u0004M+\u0011\u0005\u00111\b\u0005\n\u0003?)\u0012\u0011!C#\u0003CA\u0011\"!\u0010\u0016\u0003\u0003%\t)a\u0010\t\u0013\u0005\u001dS#!A\u0005\u0002\u0006%\u0003\"CA.+\u0005\u0005I\u0011BA/\u00055\u0019\u0005.\u00198oK2\u001cuN\u001c4jO*\u0011QDH\u0001\u0007G>lWn\u001c8\u000b\u0003}\tqa^8xG\"\fGo\u0001\u0001\u0014\t\u0001\u0011\u0003f\u000b\t\u0003G\u0019j\u0011\u0001\n\u0006\u0002K\u0005)1oY1mC&\u0011q\u0005\n\u0002\u0007\u0003:L(+\u001a4\u0011\u0005\rJ\u0013B\u0001\u0016%\u0005\u001d\u0001&o\u001c3vGR\u0004\"a\t\u0017\n\u00055\"#\u0001D*fe&\fG.\u001b>bE2,\u0017!D2iCR$\u0015N]3di&|g.F\u00011!\t\t4H\u0004\u00023s9\u00111\u0007\u000f\b\u0003i]j\u0011!\u000e\u0006\u0003m\u0001\na\u0001\u0010:p_Rt\u0014\"A\u0010\n\u0005uq\u0012B\u0001\u001e\u001d\u00035\u0019\u0005.\u0019;ESJ,7\r^5p]&\u0011A(\u0010\u0002\u000e\u0007\"\fG\u000fR5sK\u000e$\u0018n\u001c8\u000b\u0005ib\u0012AD2iCR$\u0015N]3di&|g\u000eI\u0001\u0004o><X#A!\u0011\u0005\t\u001bU\"\u0001\u000f\n\u0005\u0011c\"\u0001E,po\u000eC\u0017M\u001c8fY\u000e{gNZ5h\u0003\u00119xn\u001e\u0011\u0002\u000f\u0011L7oY8sIV\t\u0001\n\u0005\u0002C\u0013&\u0011!\n\b\u0002\u0015\t&\u001c8m\u001c:e\u0007\"\fgN\\3m\u0007>tg-[4\u0002\u0011\u0011L7oY8sI\u0002\na\u0001P5oSRtD\u0003\u0002(P!F\u0003\"A\u0011\u0001\t\u000b9:\u0001\u0019\u0001\u0019\t\u000b}:\u0001\u0019A!\t\u000b\u0019;\u0001\u0019\u0001%\u0002\t\r|\u0007/\u001f\u000b\u0005\u001dR+f\u000bC\u0004/\u0011A\u0005\t\u0019\u0001\u0019\t\u000f}B\u0001\u0013!a\u0001\u0003\"9a\t\u0003I\u0001\u0002\u0004A\u0015AD2paf$C-\u001a4bk2$H%M\u000b\u00023*\u0012\u0001GW\u0016\u00027B\u0011A,Y\u0007\u0002;*\u0011alX\u0001\nk:\u001c\u0007.Z2lK\u0012T!\u0001\u0019\u0013\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002c;\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU\tQM\u000b\u0002B5\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\u001aT#\u00015+\u0005!S\u0016!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001l!\ta\u0017/D\u0001n\u0015\tqw.\u0001\u0003mC:<'\"\u00019\u0002\t)\fg/Y\u0005\u0003e6\u0014aa\u0015;sS:<\u0017\u0001\u00049s_\u0012,8\r^!sSRLX#A;\u0011\u0005\r2\u0018BA<%\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\tQX\u0010\u0005\u0002$w&\u0011A\u0010\n\u0002\u0004\u0003:L\bb\u0002@\u000f\u0003\u0003\u0005\r!^\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\u0005\r\u0001#BA\u0003\u0003\u0017QXBAA\u0004\u0015\r\tI\u0001J\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA\u0007\u0003\u000f\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!\u00111CA\r!\r\u0019\u0013QC\u0005\u0004\u0003/!#a\u0002\"p_2,\u0017M\u001c\u0005\b}B\t\t\u00111\u0001{\u0003!A\u0017m\u001d5D_\u0012,G#A;\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012a[\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005M\u0011q\u0005\u0005\b}N\t\t\u00111\u0001{\u00035\u0019\u0005.\u00198oK2\u001cuN\u001c4jOB\u0011!)F\n\u0005+\u0005=2\u0006\u0005\u0005\u00022\u0005]\u0002'\u0011%O\u001b\t\t\u0019DC\u0002\u00026\u0011\nqA];oi&lW-\u0003\u0003\u0002:\u0005M\"!E!cgR\u0014\u0018m\u0019;Gk:\u001cG/[8ogQ\u0011\u00111F\u0001\u0006CB\u0004H.\u001f\u000b\b\u001d\u0006\u0005\u00131IA#\u0011\u0015q\u0003\u00041\u00011\u0011\u0015y\u0004\u00041\u0001B\u0011\u00151\u0005\u00041\u0001I\u0003\u001d)h.\u00199qYf$B!a\u0013\u0002XA)1%!\u0014\u0002R%\u0019\u0011q\n\u0013\u0003\r=\u0003H/[8o!\u0019\u0019\u00131\u000b\u0019B\u0011&\u0019\u0011Q\u000b\u0013\u0003\rQ+\b\u000f\\34\u0011!\tI&GA\u0001\u0002\u0004q\u0015a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\ty\u0006E\u0002m\u0003CJ1!a\u0019n\u0005\u0019y%M[3di\u0002")
public class ChannelConfig
implements Product,
Serializable {
    private final Enumeration.Value chatDirection;
    private final WowChannelConfig wow;
    private final DiscordChannelConfig discord;

    public static Option<Tuple3<Enumeration.Value, WowChannelConfig, DiscordChannelConfig>> unapply(ChannelConfig channelConfig) {
        return ChannelConfig$.MODULE$.unapply(channelConfig);
    }

    public static ChannelConfig apply(Enumeration.Value value, WowChannelConfig wowChannelConfig, DiscordChannelConfig discordChannelConfig) {
        return ChannelConfig$.MODULE$.apply(value, wowChannelConfig, discordChannelConfig);
    }

    public static Function1<Tuple3<Enumeration.Value, WowChannelConfig, DiscordChannelConfig>, ChannelConfig> tupled() {
        return ChannelConfig$.MODULE$.tupled();
    }

    public static Function1<Enumeration.Value, Function1<WowChannelConfig, Function1<DiscordChannelConfig, ChannelConfig>>> curried() {
        return ChannelConfig$.MODULE$.curried();
    }

    public Enumeration.Value chatDirection() {
        return this.chatDirection;
    }

    public WowChannelConfig wow() {
        return this.wow;
    }

    public DiscordChannelConfig discord() {
        return this.discord;
    }

    public ChannelConfig copy(Enumeration.Value chatDirection, WowChannelConfig wow, DiscordChannelConfig discord) {
        return new ChannelConfig(chatDirection, wow, discord);
    }

    public Enumeration.Value copy$default$1() {
        return this.chatDirection();
    }

    public WowChannelConfig copy$default$2() {
        return this.wow();
    }

    public DiscordChannelConfig copy$default$3() {
        return this.discord();
    }

    @Override
    public String productPrefix() {
        return "ChannelConfig";
    }

    @Override
    public int productArity() {
        return 3;
    }

    @Override
    public Object productElement(int x$1) {
        Serializable serializable;
        int n = x$1;
        switch (n) {
            case 0: {
                serializable = this.chatDirection();
                break;
            }
            case 1: {
                serializable = this.wow();
                break;
            }
            case 2: {
                serializable = this.discord();
                break;
            }
            default: {
                throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
            }
        }
        return serializable;
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof ChannelConfig;
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
        if (!(object instanceof ChannelConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        ChannelConfig channelConfig = (ChannelConfig)x$1;
        Enumeration.Value value = this.chatDirection();
        Enumeration.Value value2 = channelConfig.chatDirection();
        if (value == null) {
            if (value2 != null) {
                return false;
            }
        } else if (!((Object)value).equals(value2)) return false;
        WowChannelConfig wowChannelConfig = this.wow();
        WowChannelConfig wowChannelConfig2 = channelConfig.wow();
        if (wowChannelConfig == null) {
            if (wowChannelConfig2 != null) {
                return false;
            }
        } else if (!((Object)wowChannelConfig).equals(wowChannelConfig2)) return false;
        DiscordChannelConfig discordChannelConfig = this.discord();
        DiscordChannelConfig discordChannelConfig2 = channelConfig.discord();
        if (discordChannelConfig == null) {
            if (discordChannelConfig2 != null) {
                return false;
            }
        } else if (!((Object)discordChannelConfig).equals(discordChannelConfig2)) return false;
        if (!channelConfig.canEqual(this)) return false;
        return true;
    }

    public ChannelConfig(Enumeration.Value chatDirection, WowChannelConfig wow, DiscordChannelConfig discord) {
        this.chatDirection = chatDirection;
        this.wow = wow;
        this.discord = discord;
        Product.$init$(this);
    }
}

