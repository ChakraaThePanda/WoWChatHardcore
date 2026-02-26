/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple5;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.common.FiltersConfig;
import wowchat.common.WowChannelConfig$;

@ScalaSignature(bytes="\u0006\u0001\u0005me\u0001B\u0012%\u0001&B\u0001B\u000e\u0001\u0003\u0016\u0004%\ta\u000e\u0005\t}\u0001\u0011\t\u0012)A\u0005q!Aq\b\u0001BK\u0002\u0013\u0005\u0001\t\u0003\u0005E\u0001\tE\t\u0015!\u0003B\u0011!)\u0005A!f\u0001\n\u00031\u0005\u0002C*\u0001\u0005#\u0005\u000b\u0011B$\t\u0011Q\u0003!Q3A\u0005\u0002UC\u0001B\u0016\u0001\u0003\u0012\u0003\u0006I\u0001\u0013\u0005\t/\u0002\u0011)\u001a!C\u00011\"Aa\f\u0001B\tB\u0003%\u0011\fC\u0003`\u0001\u0011\u0005\u0001\rC\u0004h\u0001\u0005\u0005I\u0011\u00015\t\u000f9\u0004\u0011\u0013!C\u0001_\"9!\u0010AI\u0001\n\u0003Y\bbB?\u0001#\u0003%\tA \u0005\n\u0003\u0003\u0001\u0011\u0013!C\u0001\u0003\u0007A\u0011\"a\u0002\u0001#\u0003%\t!!\u0003\t\u0013\u00055\u0001!!A\u0005B\u0005=\u0001\"CA\u0010\u0001\u0005\u0005I\u0011AA\u0011\u0011%\t\u0019\u0003AA\u0001\n\u0003\t)\u0003C\u0005\u00022\u0001\t\t\u0011\"\u0011\u00024!I\u0011\u0011\t\u0001\u0002\u0002\u0013\u0005\u00111\t\u0005\n\u0003\u001b\u0002\u0011\u0011!C!\u0003\u001fB\u0011\"!\u0015\u0001\u0003\u0003%\t%a\u0015\t\u0013\u0005U\u0003!!A\u0005B\u0005]s!CA.I\u0005\u0005\t\u0012AA/\r!\u0019C%!A\t\u0002\u0005}\u0003BB0\u001c\t\u0003\ti\u0007C\u0005\u0002Rm\t\t\u0011\"\u0012\u0002T!I\u0011qN\u000e\u0002\u0002\u0013\u0005\u0015\u0011\u000f\u0005\t\u0003{Z\u0012\u0013!C\u0001}\"I\u0011qP\u000e\u0002\u0002\u0013\u0005\u0015\u0011\u0011\u0005\t\u0003\u001f[\u0012\u0013!C\u0001}\"I\u0011\u0011S\u000e\u0002\u0002\u0013%\u00111\u0013\u0002\u0011/><8\t[1o]\u0016d7i\u001c8gS\u001eT!!\n\u0014\u0002\r\r|W.\\8o\u0015\u00059\u0013aB<po\u000eD\u0017\r^\u0002\u0001'\u0011\u0001!\u0006M\u001a\u0011\u0005-rS\"\u0001\u0017\u000b\u00035\nQa]2bY\u0006L!a\f\u0017\u0003\r\u0005s\u0017PU3g!\tY\u0013'\u0003\u00023Y\t9\u0001K]8ek\u000e$\bCA\u00165\u0013\t)DF\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0002jIV\t\u0001\bE\u0002,smJ!A\u000f\u0017\u0003\r=\u0003H/[8o!\tYC(\u0003\u0002>Y\t\u0019\u0011J\u001c;\u0002\u0007%$\u0007%\u0001\u0002uaV\t\u0011\t\u0005\u0002,\u0005&\u00111\t\f\u0002\u0005\u0005f$X-A\u0002ua\u0002\nqa\u00195b]:,G.F\u0001H!\rY\u0013\b\u0013\t\u0003\u0013Bs!A\u0013(\u0011\u0005-cS\"\u0001'\u000b\u00055C\u0013A\u0002\u001fs_>$h(\u0003\u0002PY\u00051\u0001K]3eK\u001aL!!\u0015*\u0003\rM#(/\u001b8h\u0015\tyE&\u0001\u0005dQ\u0006tg.\u001a7!\u0003\u00191wN]7biV\t\u0001*A\u0004g_Jl\u0017\r\u001e\u0011\u0002\u000f\u0019LG\u000e^3sgV\t\u0011\fE\u0002,si\u0003\"a\u0017/\u000e\u0003\u0011J!!\u0018\u0013\u0003\u001b\u0019KG\u000e^3sg\u000e{gNZ5h\u0003!1\u0017\u000e\u001c;feN\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0004bE\u000e$WM\u001a\t\u00037\u0002AQAN\u0006A\u0002aBQaP\u0006A\u0002\u0005Cq!R\u0006\u0011\u0002\u0003\u0007q\tC\u0003U\u0017\u0001\u0007\u0001\nC\u0003X\u0017\u0001\u0007\u0011,\u0001\u0003d_BLHCB1jU.dW\u000eC\u00047\u0019A\u0005\t\u0019\u0001\u001d\t\u000f}b\u0001\u0013!a\u0001\u0003\"9Q\t\u0004I\u0001\u0002\u00049\u0005b\u0002+\r!\u0003\u0005\r\u0001\u0013\u0005\b/2\u0001\n\u00111\u0001Z\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\u0012\u0001\u001d\u0016\u0003qE\\\u0013A\u001d\t\u0003gbl\u0011\u0001\u001e\u0006\u0003kZ\f\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005]d\u0013AC1o]>$\u0018\r^5p]&\u0011\u0011\u0010\u001e\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017AD2paf$C-\u001a4bk2$HEM\u000b\u0002y*\u0012\u0011)]\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00134+\u0005y(FA$r\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIQ*\"!!\u0002+\u0005!\u000b\u0018AD2paf$C-\u001a4bk2$H%N\u000b\u0003\u0003\u0017Q#!W9\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\t\t\t\u0002\u0005\u0003\u0002\u0014\u0005uQBAA\u000b\u0015\u0011\t9\"!\u0007\u0002\t1\fgn\u001a\u0006\u0003\u00037\tAA[1wC&\u0019\u0011+!\u0006\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0003m\na\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0003\u0002(\u00055\u0002cA\u0016\u0002*%\u0019\u00111\u0006\u0017\u0003\u0007\u0005s\u0017\u0010\u0003\u0005\u00020Q\t\t\u00111\u0001<\u0003\rAH%M\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011\u0011Q\u0007\t\u0007\u0003o\ti$a\n\u000e\u0005\u0005e\"bAA\u001eY\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u0005}\u0012\u0011\b\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002F\u0005-\u0003cA\u0016\u0002H%\u0019\u0011\u0011\n\u0017\u0003\u000f\t{w\u000e\\3b]\"I\u0011q\u0006\f\u0002\u0002\u0003\u0007\u0011qE\u0001\tQ\u0006\u001c\bnQ8eKR\t1(\u0001\u0005u_N#(/\u001b8h)\t\t\t\"\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003\u000b\nI\u0006C\u0005\u00020e\t\t\u00111\u0001\u0002(\u0005\u0001rk\\<DQ\u0006tg.\u001a7D_:4\u0017n\u001a\t\u00037n\u0019BaGA1gAQ\u00111MA5q\u0005;\u0005*W1\u000e\u0005\u0005\u0015$bAA4Y\u00059!/\u001e8uS6,\u0017\u0002BA6\u0003K\u0012\u0011#\u00112tiJ\f7\r\u001e$v]\u000e$\u0018n\u001c86)\t\ti&A\u0003baBd\u0017\u0010F\u0006b\u0003g\n)(a\u001e\u0002z\u0005m\u0004\"\u0002\u001c\u001f\u0001\u0004A\u0004\"B \u001f\u0001\u0004\t\u0005bB#\u001f!\u0003\u0005\ra\u0012\u0005\u0006)z\u0001\r\u0001\u0013\u0005\u0006/z\u0001\r!W\u0001\u0010CB\u0004H.\u001f\u0013eK\u001a\fW\u000f\u001c;%g\u00059QO\\1qa2LH\u0003BAB\u0003\u0017\u0003BaK\u001d\u0002\u0006BA1&a\"9\u0003\u001eC\u0015,C\u0002\u0002\n2\u0012a\u0001V;qY\u0016,\u0004\u0002CAGA\u0005\u0005\t\u0019A1\u0002\u0007a$\u0003'A\u000e%Y\u0016\u001c8/\u001b8ji\u0012:'/Z1uKJ$C-\u001a4bk2$HeM\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002\u0016B!\u00111CAL\u0013\u0011\tI*!\u0006\u0003\r=\u0013'.Z2u\u0001")
public class WowChannelConfig
implements Product,
Serializable {
    private final Option<Object> id;
    private final byte tp;
    private final Option<String> channel;
    private final String format;
    private final Option<FiltersConfig> filters;

    public static Option<String> $lessinit$greater$default$3() {
        return WowChannelConfig$.MODULE$.$lessinit$greater$default$3();
    }

    public static Option<Tuple5<Option<Object>, Object, Option<String>, String, Option<FiltersConfig>>> unapply(WowChannelConfig wowChannelConfig) {
        return WowChannelConfig$.MODULE$.unapply(wowChannelConfig);
    }

    public static Option<String> apply$default$3() {
        return WowChannelConfig$.MODULE$.apply$default$3();
    }

    public static WowChannelConfig apply(Option<Object> option, byte by, Option<String> option2, String string, Option<FiltersConfig> option3) {
        return WowChannelConfig$.MODULE$.apply(option, by, option2, string, option3);
    }

    public static Function1<Tuple5<Option<Object>, Object, Option<String>, String, Option<FiltersConfig>>, WowChannelConfig> tupled() {
        return WowChannelConfig$.MODULE$.tupled();
    }

    public static Function1<Option<Object>, Function1<Object, Function1<Option<String>, Function1<String, Function1<Option<FiltersConfig>, WowChannelConfig>>>>> curried() {
        return WowChannelConfig$.MODULE$.curried();
    }

    public Option<Object> id() {
        return this.id;
    }

    public byte tp() {
        return this.tp;
    }

    public Option<String> channel() {
        return this.channel;
    }

    public String format() {
        return this.format;
    }

    public Option<FiltersConfig> filters() {
        return this.filters;
    }

    public WowChannelConfig copy(Option<Object> id, byte tp, Option<String> channel, String format, Option<FiltersConfig> filters) {
        return new WowChannelConfig(id, tp, channel, format, filters);
    }

    public Option<Object> copy$default$1() {
        return this.id();
    }

    public byte copy$default$2() {
        return this.tp();
    }

    public Option<String> copy$default$3() {
        return this.channel();
    }

    public String copy$default$4() {
        return this.format();
    }

    public Option<FiltersConfig> copy$default$5() {
        return this.filters();
    }

    @Override
    public String productPrefix() {
        return "WowChannelConfig";
    }

    @Override
    public int productArity() {
        return 5;
    }

    @Override
    public Object productElement(int x$1) {
        java.io.Serializable serializable;
        int n = x$1;
        switch (n) {
            case 0: {
                serializable = this.id();
                break;
            }
            case 1: {
                serializable = BoxesRunTime.boxToByte(this.tp());
                break;
            }
            case 2: {
                serializable = this.channel();
                break;
            }
            case 3: {
                serializable = this.format();
                break;
            }
            case 4: {
                serializable = this.filters();
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
        return x$1 instanceof WowChannelConfig;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.id()));
        n = Statics.mix(n, this.tp());
        n = Statics.mix(n, Statics.anyHash(this.channel()));
        n = Statics.mix(n, Statics.anyHash(this.format()));
        n = Statics.mix(n, Statics.anyHash(this.filters()));
        return Statics.finalizeHash(n, 5);
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
        if (!(object instanceof WowChannelConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        WowChannelConfig wowChannelConfig = (WowChannelConfig)x$1;
        Option<Object> option = this.id();
        Option<Object> option2 = wowChannelConfig.id();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        if (this.tp() != wowChannelConfig.tp()) return false;
        Option<String> option3 = this.channel();
        Option<String> option4 = wowChannelConfig.channel();
        if (option3 == null) {
            if (option4 != null) {
                return false;
            }
        } else if (!option3.equals(option4)) return false;
        String string = this.format();
        String string2 = wowChannelConfig.format();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        Option<FiltersConfig> option5 = this.filters();
        Option<FiltersConfig> option6 = wowChannelConfig.filters();
        if (option5 == null) {
            if (option6 != null) {
                return false;
            }
        } else if (!option5.equals(option6)) return false;
        if (!wowChannelConfig.canEqual(this)) return false;
        return true;
    }

    public WowChannelConfig(Option<Object> id, byte tp, Option<String> channel, String format, Option<FiltersConfig> filters) {
        this.id = id;
        this.tp = tp;
        this.channel = channel;
        this.format = format;
        this.filters = filters;
        Product.$init$(this);
    }
}

