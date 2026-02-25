/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple6;
import scala.collection.Iterator;
import scala.collection.immutable.Set;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.common.DiscordConfig$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ue\u0001\u0002\u0013&\u0001*B\u0001b\u000e\u0001\u0003\u0016\u0004%\t\u0001\u000f\u0005\t\t\u0002\u0011\t\u0012)A\u0005s!AQ\t\u0001BK\u0002\u0013\u0005a\t\u0003\u0005K\u0001\tE\t\u0015!\u0003H\u0011!Y\u0005A!f\u0001\n\u0003a\u0005\u0002\u0003)\u0001\u0005#\u0005\u000b\u0011B'\t\u0011E\u0003!Q3A\u0005\u00021C\u0001B\u0015\u0001\u0003\u0012\u0003\u0006I!\u0014\u0005\t'\u0002\u0011)\u001a!C\u0001\r\"AA\u000b\u0001B\tB\u0003%q\t\u0003\u0005V\u0001\tU\r\u0011\"\u0001W\u0011!Q\u0006A!E!\u0002\u00139\u0006\"B.\u0001\t\u0003a\u0006bB3\u0001\u0003\u0003%\tA\u001a\u0005\b[\u0002\t\n\u0011\"\u0001o\u0011\u001dI\b!%A\u0005\u0002iDq\u0001 \u0001\u0012\u0002\u0013\u0005Q\u0010C\u0004\u0000\u0001E\u0005I\u0011A?\t\u0011\u0005\u0005\u0001!%A\u0005\u0002iD\u0011\"a\u0001\u0001#\u0003%\t!!\u0002\t\u0013\u0005%\u0001!!A\u0005B\u0005-\u0001\"CA\u000e\u0001\u0005\u0005I\u0011AA\u000f\u0011%\t)\u0003AA\u0001\n\u0003\t9\u0003C\u0005\u00024\u0001\t\t\u0011\"\u0011\u00026!I\u00111\t\u0001\u0002\u0002\u0013\u0005\u0011Q\t\u0005\n\u0003\u0013\u0002\u0011\u0011!C!\u0003\u0017B\u0011\"!\u0014\u0001\u0003\u0003%\t%a\u0014\t\u0013\u0005E\u0003!!A\u0005B\u0005Ms!CA,K\u0005\u0005\t\u0012AA-\r!!S%!A\t\u0002\u0005m\u0003BB.\u001f\t\u0003\tI\u0007C\u0005\u0002Ny\t\t\u0011\"\u0012\u0002P!I\u00111\u000e\u0010\u0002\u0002\u0013\u0005\u0015Q\u000e\u0005\n\u0003wr\u0012\u0011!CA\u0003{B\u0011\"a#\u001f\u0003\u0003%I!!$\u0003\u001b\u0011K7oY8sI\u000e{gNZ5h\u0015\t1s%\u0001\u0004d_6lwN\u001c\u0006\u0002Q\u00059qo\\<dQ\u0006$8\u0001A\n\u0005\u0001-\nD\u0007\u0005\u0002-_5\tQFC\u0001/\u0003\u0015\u00198-\u00197b\u0013\t\u0001TF\u0001\u0004B]f\u0014VM\u001a\t\u0003YIJ!aM\u0017\u0003\u000fA\u0013x\u000eZ;diB\u0011A&N\u0005\u0003m5\u0012AbU3sS\u0006d\u0017N_1cY\u0016\fQ\u0001^8lK:,\u0012!\u000f\t\u0003u\u0005s!aO \u0011\u0005qjS\"A\u001f\u000b\u0005yJ\u0013A\u0002\u001fs_>$h(\u0003\u0002A[\u00051\u0001K]3eK\u001aL!AQ\"\u0003\rM#(/\u001b8h\u0015\t\u0001U&\u0001\u0004u_.,g\u000eI\u0001\u0012K:\f'\r\\3E_R\u001cu.\\7b]\u0012\u001cX#A$\u0011\u00051B\u0015BA%.\u0005\u001d\u0011un\u001c7fC:\f!#\u001a8bE2,Gi\u001c;D_6l\u0017M\u001c3tA\u0005!Bm\u001c;D_6l\u0017M\u001c3t/\"LG/\u001a7jgR,\u0012!\u0014\t\u0004u9K\u0014BA(D\u0005\r\u0019V\r^\u0001\u0016I>$8i\\7nC:$7o\u00165ji\u0016d\u0017n\u001d;!\u0003Y)g.\u00192mK\u000e{W.\\1oIN\u001c\u0005.\u00198oK2\u001c\u0018aF3oC\ndWmQ8n[\u0006tGm]\"iC:tW\r\\:!\u0003q)g.\u00192mKR\u000bwMR1jY\u0016$gj\u001c;jM&\u001c\u0017\r^5p]N\fQ$\u001a8bE2,G+Y4GC&dW\r\u001a(pi&4\u0017nY1uS>t7\u000fI\u0001\rSR,W\u000eR1uC\n\f7/Z\u000b\u0002/B\u0019A\u0006W\u001d\n\u0005ek#AB(qi&|g.A\u0007ji\u0016lG)\u0019;bE\u0006\u001cX\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u000fu{\u0006-\u00192dIB\u0011a\fA\u0007\u0002K!)q'\u0004a\u0001s!)Q)\u0004a\u0001\u000f\")1*\u0004a\u0001\u001b\")\u0011+\u0004a\u0001\u001b\")1+\u0004a\u0001\u000f\")Q+\u0004a\u0001/\u0006!1m\u001c9z)\u001div\r[5kW2Dqa\u000e\b\u0011\u0002\u0003\u0007\u0011\bC\u0004F\u001dA\u0005\t\u0019A$\t\u000f-s\u0001\u0013!a\u0001\u001b\"9\u0011K\u0004I\u0001\u0002\u0004i\u0005bB*\u000f!\u0003\u0005\ra\u0012\u0005\b+:\u0001\n\u00111\u0001X\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\u0012a\u001c\u0016\u0003sA\\\u0013!\u001d\t\u0003e^l\u0011a\u001d\u0006\u0003iV\f\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005Yl\u0013AC1o]>$\u0018\r^5p]&\u0011\u0001p\u001d\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017AD2paf$C-\u001a4bk2$HEM\u000b\u0002w*\u0012q\t]\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00134+\u0005q(FA'q\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIQ\nabY8qs\u0012\"WMZ1vYR$S'\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001c\u0016\u0005\u0005\u001d!FA,q\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\u0011\u0011Q\u0002\t\u0005\u0003\u001f\tI\"\u0004\u0002\u0002\u0012)!\u00111CA\u000b\u0003\u0011a\u0017M\\4\u000b\u0005\u0005]\u0011\u0001\u00026bm\u0006L1AQA\t\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\t\ty\u0002E\u0002-\u0003CI1!a\t.\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\u0011\tI#a\f\u0011\u00071\nY#C\u0002\u0002.5\u00121!\u00118z\u0011%\t\tdFA\u0001\u0002\u0004\ty\"A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0003\u0003o\u0001b!!\u000f\u0002@\u0005%RBAA\u001e\u0015\r\ti$L\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA!\u0003w\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR\u0019q)a\u0012\t\u0013\u0005E\u0012$!AA\u0002\u0005%\u0012\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005}\u0011\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u00055\u0011AB3rk\u0006d7\u000fF\u0002H\u0003+B\u0011\"!\r\u001d\u0003\u0003\u0005\r!!\u000b\u0002\u001b\u0011K7oY8sI\u000e{gNZ5h!\tqfd\u0005\u0003\u001f\u0003;\"\u0004cCA0\u0003KJt)T'H/vk!!!\u0019\u000b\u0007\u0005\rT&A\u0004sk:$\u0018.\\3\n\t\u0005\u001d\u0014\u0011\r\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:4DCAA-\u0003\u0015\t\u0007\u000f\u001d7z)5i\u0016qNA9\u0003g\n)(a\u001e\u0002z!)q'\ta\u0001s!)Q)\ta\u0001\u000f\")1*\ta\u0001\u001b\")\u0011+\ta\u0001\u001b\")1+\ta\u0001\u000f\")Q+\ta\u0001/\u00069QO\\1qa2LH\u0003BA@\u0003\u000f\u0003B\u0001\f-\u0002\u0002BIA&a!:\u000f6kuiV\u0005\u0004\u0003\u000bk#A\u0002+va2,g\u0007\u0003\u0005\u0002\n\n\n\t\u00111\u0001^\u0003\rAH\u0005M\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002\u0010B!\u0011qBAI\u0013\u0011\t\u0019*!\u0005\u0003\r=\u0013'.Z2u\u0001")
public class DiscordConfig
implements Product,
Serializable {
    private final String token;
    private final boolean enableDotCommands;
    private final Set<String> dotCommandsWhitelist;
    private final Set<String> enableCommandsChannels;
    private final boolean enableTagFailedNotifications;
    private final Option<String> itemDatabase;

    public static Option<Tuple6<String, Object, Set<String>, Set<String>, Object, Option<String>>> unapply(DiscordConfig discordConfig) {
        return DiscordConfig$.MODULE$.unapply(discordConfig);
    }

    public static DiscordConfig apply(String string, boolean bl, Set<String> set, Set<String> set2, boolean bl2, Option<String> option) {
        return DiscordConfig$.MODULE$.apply(string, bl, set, set2, bl2, option);
    }

    public static Function1<Tuple6<String, Object, Set<String>, Set<String>, Object, Option<String>>, DiscordConfig> tupled() {
        return DiscordConfig$.MODULE$.tupled();
    }

    public static Function1<String, Function1<Object, Function1<Set<String>, Function1<Set<String>, Function1<Object, Function1<Option<String>, DiscordConfig>>>>>> curried() {
        return DiscordConfig$.MODULE$.curried();
    }

    public String token() {
        return this.token;
    }

    public boolean enableDotCommands() {
        return this.enableDotCommands;
    }

    public Set<String> dotCommandsWhitelist() {
        return this.dotCommandsWhitelist;
    }

    public Set<String> enableCommandsChannels() {
        return this.enableCommandsChannels;
    }

    public boolean enableTagFailedNotifications() {
        return this.enableTagFailedNotifications;
    }

    public Option<String> itemDatabase() {
        return this.itemDatabase;
    }

    public DiscordConfig copy(String token, boolean enableDotCommands, Set<String> dotCommandsWhitelist, Set<String> enableCommandsChannels, boolean enableTagFailedNotifications, Option<String> itemDatabase) {
        return new DiscordConfig(token, enableDotCommands, dotCommandsWhitelist, enableCommandsChannels, enableTagFailedNotifications, itemDatabase);
    }

    public String copy$default$1() {
        return this.token();
    }

    public boolean copy$default$2() {
        return this.enableDotCommands();
    }

    public Set<String> copy$default$3() {
        return this.dotCommandsWhitelist();
    }

    public Set<String> copy$default$4() {
        return this.enableCommandsChannels();
    }

    public boolean copy$default$5() {
        return this.enableTagFailedNotifications();
    }

    public Option<String> copy$default$6() {
        return this.itemDatabase();
    }

    @Override
    public String productPrefix() {
        return "DiscordConfig";
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
                object = this.token();
                break;
            }
            case 1: {
                object = BoxesRunTime.boxToBoolean(this.enableDotCommands());
                break;
            }
            case 2: {
                object = this.dotCommandsWhitelist();
                break;
            }
            case 3: {
                object = this.enableCommandsChannels();
                break;
            }
            case 4: {
                object = BoxesRunTime.boxToBoolean(this.enableTagFailedNotifications());
                break;
            }
            case 5: {
                object = this.itemDatabase();
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
        return x$1 instanceof DiscordConfig;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.token()));
        n = Statics.mix(n, this.enableDotCommands() ? 1231 : 1237);
        n = Statics.mix(n, Statics.anyHash(this.dotCommandsWhitelist()));
        n = Statics.mix(n, Statics.anyHash(this.enableCommandsChannels()));
        n = Statics.mix(n, this.enableTagFailedNotifications() ? 1231 : 1237);
        n = Statics.mix(n, Statics.anyHash(this.itemDatabase()));
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
        if (!(object instanceof DiscordConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        DiscordConfig discordConfig = (DiscordConfig)x$1;
        String string = this.token();
        String string2 = discordConfig.token();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (this.enableDotCommands() != discordConfig.enableDotCommands()) return false;
        Set<String> set = this.dotCommandsWhitelist();
        Set<String> set2 = discordConfig.dotCommandsWhitelist();
        if (set == null) {
            if (set2 != null) {
                return false;
            }
        } else if (!set.equals(set2)) return false;
        Set<String> set3 = this.enableCommandsChannels();
        Set<String> set4 = discordConfig.enableCommandsChannels();
        if (set3 == null) {
            if (set4 != null) {
                return false;
            }
        } else if (!set3.equals(set4)) return false;
        if (this.enableTagFailedNotifications() != discordConfig.enableTagFailedNotifications()) return false;
        Option<String> option = this.itemDatabase();
        Option<String> option2 = discordConfig.itemDatabase();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        if (!discordConfig.canEqual(this)) return false;
        return true;
    }

    public DiscordConfig(String token, boolean enableDotCommands, Set<String> dotCommandsWhitelist, Set<String> enableCommandsChannels, boolean enableTagFailedNotifications, Option<String> itemDatabase) {
        this.token = token;
        this.enableDotCommands = enableDotCommands;
        this.dotCommandsWhitelist = dotCommandsWhitelist;
        this.enableCommandsChannels = enableCommandsChannels;
        this.enableTagFailedNotifications = enableTagFailedNotifications;
        this.itemDatabase = itemDatabase;
        Product.$init$(this);
    }
}

