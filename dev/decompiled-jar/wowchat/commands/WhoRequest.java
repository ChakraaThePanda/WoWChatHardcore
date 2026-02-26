/*
 * Decompiled with CFR 0.152.
 */
package wowchat.commands;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import wowchat.commands.WhoRequest$;

@ScalaSignature(bytes="\u0006\u0001\u0005uc\u0001\u0002\r\u001a\u0001zA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\t\u007f\u0001\u0011\t\u0012)A\u0005[!A\u0001\t\u0001BK\u0002\u0013\u0005\u0011\t\u0003\u0005N\u0001\tE\t\u0015!\u0003C\u0011\u0015q\u0005\u0001\"\u0001P\u0011\u001d!\u0006!!A\u0005\u0002UCq\u0001\u0017\u0001\u0012\u0002\u0013\u0005\u0011\fC\u0004e\u0001E\u0005I\u0011A3\t\u000f\u001d\u0004\u0011\u0011!C!Q\"9\u0001\u000fAA\u0001\n\u0003\t\bbB;\u0001\u0003\u0003%\tA\u001e\u0005\by\u0002\t\t\u0011\"\u0011~\u0011%\tI\u0001AA\u0001\n\u0003\tY\u0001C\u0005\u0002\u0016\u0001\t\t\u0011\"\u0011\u0002\u0018!I\u0011\u0011\u0004\u0001\u0002\u0002\u0013\u0005\u00131\u0004\u0005\n\u0003;\u0001\u0011\u0011!C!\u0003?9\u0011\"a\t\u001a\u0003\u0003E\t!!\n\u0007\u0011aI\u0012\u0011!E\u0001\u0003OAaA\u0014\n\u0005\u0002\u0005U\u0002\"CA\r%\u0005\u0005IQIA\u000e\u0011%\t9DEA\u0001\n\u0003\u000bI\u0004C\u0005\u0002@I\t\t\u0011\"!\u0002B!I\u00111\u000b\n\u0002\u0002\u0013%\u0011Q\u000b\u0002\u000b/\"|'+Z9vKN$(B\u0001\u000e\u001c\u0003!\u0019w.\\7b]\u0012\u001c(\"\u0001\u000f\u0002\u000f]|wo\u00195bi\u000e\u00011\u0003\u0002\u0001 K!\u0002\"\u0001I\u0012\u000e\u0003\u0005R\u0011AI\u0001\u0006g\u000e\fG.Y\u0005\u0003I\u0005\u0012a!\u00118z%\u00164\u0007C\u0001\u0011'\u0013\t9\u0013EA\u0004Qe>$Wo\u0019;\u0011\u0005\u0001J\u0013B\u0001\u0016\"\u00051\u0019VM]5bY&T\u0018M\u00197f\u00039iWm]:bO\u0016\u001c\u0005.\u00198oK2,\u0012!\f\t\u0003]uj\u0011a\f\u0006\u0003aE\n\u0011\"\\5eI2,W.\u00198\u000b\u0005I\u001a\u0014aB2iC:tW\r\u001c\u0006\u0003iU\n\u0001\"\u001a8uSRLWm\u001d\u0006\u0003m]\n1!\u00199j\u0015\tA\u0014(A\u0002kI\u0006T!AO\u001e\u0002\u000f\u00114\b\b^5p]*\tA(A\u0002oKRL!AP\u0018\u0003\u001d5+7o]1hK\u000eC\u0017M\u001c8fY\u0006yQ.Z:tC\u001e,7\t[1o]\u0016d\u0007%\u0001\u0006qY\u0006LXM\u001d(b[\u0016,\u0012A\u0011\t\u0003\u0007*s!\u0001\u0012%\u0011\u0005\u0015\u000bS\"\u0001$\u000b\u0005\u001dk\u0012A\u0002\u001fs_>$h(\u0003\u0002JC\u00051\u0001K]3eK\u001aL!a\u0013'\u0003\rM#(/\u001b8h\u0015\tI\u0015%A\u0006qY\u0006LXM\u001d(b[\u0016\u0004\u0013A\u0002\u001fj]&$h\bF\u0002Q%N\u0003\"!\u0015\u0001\u000e\u0003eAQaK\u0003A\u00025BQ\u0001Q\u0003A\u0002\t\u000bAaY8qsR\u0019\u0001KV,\t\u000f-2\u0001\u0013!a\u0001[!9\u0001I\u0002I\u0001\u0002\u0004\u0011\u0015AD2paf$C-\u001a4bk2$H%M\u000b\u00025*\u0012QfW\u0016\u00029B\u0011QLY\u0007\u0002=*\u0011q\fY\u0001\nk:\u001c\u0007.Z2lK\u0012T!!Y\u0011\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002d=\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU\taM\u000b\u0002C7\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012!\u001b\t\u0003U>l\u0011a\u001b\u0006\u0003Y6\fA\u0001\\1oO*\ta.\u0001\u0003kCZ\f\u0017BA&l\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005\u0011\bC\u0001\u0011t\u0013\t!\u0018EA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0002xuB\u0011\u0001\u0005_\u0005\u0003s\u0006\u00121!\u00118z\u0011\u001dY8\"!AA\u0002I\f1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#\u0001@\u0011\t}\f)a^\u0007\u0003\u0003\u0003Q1!a\u0001\"\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003\u000f\t\tA\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dG\u0003BA\u0007\u0003'\u00012\u0001IA\b\u0013\r\t\t\"\t\u0002\b\u0005>|G.Z1o\u0011\u001dYX\"!AA\u0002]\f\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0002e\u0006AAo\\*ue&tw\rF\u0001j\u0003\u0019)\u0017/^1mgR!\u0011QBA\u0011\u0011\u001dY\b#!AA\u0002]\f!b\u00165p%\u0016\fX/Z:u!\t\t&c\u0005\u0003\u0013\u0003SA\u0003cBA\u0016\u0003ci#\tU\u0007\u0003\u0003[Q1!a\f\"\u0003\u001d\u0011XO\u001c;j[\u0016LA!a\r\u0002.\t\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0005\u0005\u0015\u0012!B1qa2LH#\u0002)\u0002<\u0005u\u0002\"B\u0016\u0016\u0001\u0004i\u0003\"\u0002!\u0016\u0001\u0004\u0011\u0015aB;oCB\u0004H.\u001f\u000b\u0005\u0003\u0007\ny\u0005E\u0003!\u0003\u000b\nI%C\u0002\u0002H\u0005\u0012aa\u00149uS>t\u0007#\u0002\u0011\u0002L5\u0012\u0015bAA'C\t1A+\u001e9mKJB\u0001\"!\u0015\u0017\u0003\u0003\u0005\r\u0001U\u0001\u0004q\u0012\u0002\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!a\u0016\u0011\u0007)\fI&C\u0002\u0002\\-\u0014aa\u00142kK\u000e$\b")
public class WhoRequest
implements Product,
Serializable {
    private final MessageChannel messageChannel;
    private final String playerName;

    public static Option<Tuple2<MessageChannel, String>> unapply(WhoRequest whoRequest) {
        return WhoRequest$.MODULE$.unapply(whoRequest);
    }

    public static WhoRequest apply(MessageChannel messageChannel, String string) {
        return WhoRequest$.MODULE$.apply(messageChannel, string);
    }

    public static Function1<Tuple2<MessageChannel, String>, WhoRequest> tupled() {
        return WhoRequest$.MODULE$.tupled();
    }

    public static Function1<MessageChannel, Function1<String, WhoRequest>> curried() {
        return WhoRequest$.MODULE$.curried();
    }

    public MessageChannel messageChannel() {
        return this.messageChannel;
    }

    public String playerName() {
        return this.playerName;
    }

    public WhoRequest copy(MessageChannel messageChannel, String playerName) {
        return new WhoRequest(messageChannel, playerName);
    }

    public MessageChannel copy$default$1() {
        return this.messageChannel();
    }

    public String copy$default$2() {
        return this.playerName();
    }

    @Override
    public String productPrefix() {
        return "WhoRequest";
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
                object = this.messageChannel();
                break;
            }
            case 1: {
                object = this.playerName();
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
        return x$1 instanceof WhoRequest;
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
        if (!(object instanceof WhoRequest)) return false;
        boolean bl = true;
        if (!bl) return false;
        WhoRequest whoRequest = (WhoRequest)x$1;
        MessageChannel messageChannel = this.messageChannel();
        MessageChannel messageChannel2 = whoRequest.messageChannel();
        if (messageChannel == null) {
            if (messageChannel2 != null) {
                return false;
            }
        } else if (!messageChannel.equals(messageChannel2)) return false;
        String string = this.playerName();
        String string2 = whoRequest.playerName();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (!whoRequest.canEqual(this)) return false;
        return true;
    }

    public WhoRequest(MessageChannel messageChannel, String playerName) {
        this.messageChannel = messageChannel;
        this.playerName = playerName;
        Product.$init$(this);
    }
}

