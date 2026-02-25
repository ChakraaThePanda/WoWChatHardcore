/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple4;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.game.ChatMessage$;

@ScalaSignature(bytes="\u0006\u0001\u0005}d\u0001\u0002\u0011\"\u0001\u001aB\u0001b\r\u0001\u0003\u0016\u0004%\t\u0001\u000e\u0005\tq\u0001\u0011\t\u0012)A\u0005k!A\u0011\b\u0001BK\u0002\u0013\u0005!\b\u0003\u0005?\u0001\tE\t\u0015!\u0003<\u0011!y\u0004A!f\u0001\n\u0003\u0001\u0005\u0002\u0003'\u0001\u0005#\u0005\u000b\u0011B!\t\u00115\u0003!Q3A\u0005\u00029C\u0001B\u0015\u0001\u0003\u0012\u0003\u0006Ia\u0014\u0005\u0006'\u0002!\t\u0001\u0016\u0005\b7\u0002\t\t\u0011\"\u0001]\u0011\u001d\t\u0007!%A\u0005\u0002\tDq!\u001c\u0001\u0012\u0002\u0013\u0005a\u000eC\u0004q\u0001E\u0005I\u0011A9\t\u000fM\u0004\u0011\u0013!C\u0001i\"9a\u000fAA\u0001\n\u0003:\b\u0002C@\u0001\u0003\u0003%\t!!\u0001\t\u0013\u0005%\u0001!!A\u0005\u0002\u0005-\u0001\"CA\f\u0001\u0005\u0005I\u0011IA\r\u0011%\t9\u0003AA\u0001\n\u0003\tI\u0003C\u0005\u00024\u0001\t\t\u0011\"\u0011\u00026!I\u0011q\u0007\u0001\u0002\u0002\u0013\u0005\u0013\u0011\b\u0005\n\u0003w\u0001\u0011\u0011!C!\u0003{9\u0011\"!\u0011\"\u0003\u0003E\t!a\u0011\u0007\u0011\u0001\n\u0013\u0011!E\u0001\u0003\u000bBaa\u0015\r\u0005\u0002\u0005M\u0003\"CA\u001c1\u0005\u0005IQIA\u001d\u0011%\t)\u0006GA\u0001\n\u0003\u000b9\u0006\u0003\u0005\u0002ba\t\n\u0011\"\u0001u\u0011%\t\u0019\u0007GA\u0001\n\u0003\u000b)\u0007\u0003\u0005\u0002ta\t\n\u0011\"\u0001u\u0011%\t)\bGA\u0001\n\u0013\t9HA\u0006DQ\u0006$X*Z:tC\u001e,'B\u0001\u0012$\u0003\u00119\u0017-\\3\u000b\u0003\u0011\nqa^8xG\"\fGo\u0001\u0001\u0014\t\u00019S\u0006\r\t\u0003Q-j\u0011!\u000b\u0006\u0002U\u0005)1oY1mC&\u0011A&\u000b\u0002\u0007\u0003:L(+\u001a4\u0011\u0005!r\u0013BA\u0018*\u0005\u001d\u0001&o\u001c3vGR\u0004\"\u0001K\u0019\n\u0005IJ#\u0001D*fe&\fG.\u001b>bE2,\u0017\u0001B4vS\u0012,\u0012!\u000e\t\u0003QYJ!aN\u0015\u0003\t1{gnZ\u0001\u0006OVLG\rI\u0001\u0003iB,\u0012a\u000f\t\u0003QqJ!!P\u0015\u0003\t\tKH/Z\u0001\u0004iB\u0004\u0013aB7fgN\fw-Z\u000b\u0002\u0003B\u0011!)\u0013\b\u0003\u0007\u001e\u0003\"\u0001R\u0015\u000e\u0003\u0015S!AR\u0013\u0002\rq\u0012xn\u001c;?\u0013\tA\u0015&\u0001\u0004Qe\u0016$WMZ\u0005\u0003\u0015.\u0013aa\u0015;sS:<'B\u0001%*\u0003!iWm]:bO\u0016\u0004\u0013aB2iC:tW\r\\\u000b\u0002\u001fB\u0019\u0001\u0006U!\n\u0005EK#AB(qi&|g.\u0001\u0005dQ\u0006tg.\u001a7!\u0003\u0019a\u0014N\\5u}Q)Qk\u0016-Z5B\u0011a\u000bA\u0007\u0002C!)1'\u0003a\u0001k!)\u0011(\u0003a\u0001w!)q(\u0003a\u0001\u0003\"9Q*\u0003I\u0001\u0002\u0004y\u0015\u0001B2paf$R!V/_?\u0002Dqa\r\u0006\u0011\u0002\u0003\u0007Q\u0007C\u0004:\u0015A\u0005\t\u0019A\u001e\t\u000f}R\u0001\u0013!a\u0001\u0003\"9QJ\u0003I\u0001\u0002\u0004y\u0015AD2paf$C-\u001a4bk2$H%M\u000b\u0002G*\u0012Q\u0007Z\u0016\u0002KB\u0011am[\u0007\u0002O*\u0011\u0001.[\u0001\nk:\u001c\u0007.Z2lK\u0012T!A[\u0015\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002mO\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU\tqN\u000b\u0002<I\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\u001aT#\u0001:+\u0005\u0005#\u0017AD2paf$C-\u001a4bk2$H\u0005N\u000b\u0002k*\u0012q\nZ\u0001\u000eaJ|G-^2u!J,g-\u001b=\u0016\u0003a\u0004\"!\u001f@\u000e\u0003iT!a\u001f?\u0002\t1\fgn\u001a\u0006\u0002{\u0006!!.\u0019<b\u0013\tQ%0\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0006\u0002\u0002\u0004A\u0019\u0001&!\u0002\n\u0007\u0005\u001d\u0011FA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0003\u0002\u000e\u0005M\u0001c\u0001\u0015\u0002\u0010%\u0019\u0011\u0011C\u0015\u0003\u0007\u0005s\u0017\u0010C\u0005\u0002\u0016E\t\t\u00111\u0001\u0002\u0004\u0005\u0019\u0001\u0010J\u0019\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\"!a\u0007\u0011\r\u0005u\u00111EA\u0007\u001b\t\tyBC\u0002\u0002\"%\n!bY8mY\u0016\u001cG/[8o\u0013\u0011\t)#a\b\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0003W\t\t\u0004E\u0002)\u0003[I1!a\f*\u0005\u001d\u0011un\u001c7fC:D\u0011\"!\u0006\u0014\u0003\u0003\u0005\r!!\u0004\u0002\u0011!\f7\u000f[\"pI\u0016$\"!a\u0001\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012\u0001_\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005-\u0012q\b\u0005\n\u0003+1\u0012\u0011!a\u0001\u0003\u001b\t1b\u00115bi6+7o]1hKB\u0011a\u000bG\n\u00051\u0005\u001d\u0003\u0007E\u0005\u0002J\u0005=SgO!P+6\u0011\u00111\n\u0006\u0004\u0003\u001bJ\u0013a\u0002:v]RLW.Z\u0005\u0005\u0003#\nYEA\tBEN$(/Y2u\rVt7\r^5p]R\"\"!a\u0011\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0013U\u000bI&a\u0017\u0002^\u0005}\u0003\"B\u001a\u001c\u0001\u0004)\u0004\"B\u001d\u001c\u0001\u0004Y\u0004\"B \u001c\u0001\u0004\t\u0005bB'\u001c!\u0003\u0005\raT\u0001\u0010CB\u0004H.\u001f\u0013eK\u001a\fW\u000f\u001c;%i\u00059QO\\1qa2LH\u0003BA4\u0003_\u0002B\u0001\u000b)\u0002jA9\u0001&a\u001b6w\u0005{\u0015bAA7S\t1A+\u001e9mKRB\u0001\"!\u001d\u001e\u0003\u0003\u0005\r!V\u0001\u0004q\u0012\u0002\u0014a\u0007\u0013mKN\u001c\u0018N\\5uI\u001d\u0014X-\u0019;fe\u0012\"WMZ1vYR$C'A\u0006sK\u0006$'+Z:pYZ,GCAA=!\rI\u00181P\u0005\u0004\u0003{R(AB(cU\u0016\u001cG\u000f")
public class ChatMessage
implements Product,
Serializable {
    private final long guid;
    private final byte tp;
    private final String message;
    private final Option<String> channel;

    public static Option<String> $lessinit$greater$default$4() {
        return ChatMessage$.MODULE$.$lessinit$greater$default$4();
    }

    public static Option<Tuple4<Object, Object, String, Option<String>>> unapply(ChatMessage chatMessage) {
        return ChatMessage$.MODULE$.unapply(chatMessage);
    }

    public static Option<String> apply$default$4() {
        return ChatMessage$.MODULE$.apply$default$4();
    }

    public static ChatMessage apply(long l, byte by, String string, Option<String> option) {
        return ChatMessage$.MODULE$.apply(l, by, string, option);
    }

    public static Function1<Tuple4<Object, Object, String, Option<String>>, ChatMessage> tupled() {
        return ChatMessage$.MODULE$.tupled();
    }

    public static Function1<Object, Function1<Object, Function1<String, Function1<Option<String>, ChatMessage>>>> curried() {
        return ChatMessage$.MODULE$.curried();
    }

    public long guid() {
        return this.guid;
    }

    public byte tp() {
        return this.tp;
    }

    public String message() {
        return this.message;
    }

    public Option<String> channel() {
        return this.channel;
    }

    public ChatMessage copy(long guid, byte tp, String message, Option<String> channel) {
        return new ChatMessage(guid, tp, message, channel);
    }

    public long copy$default$1() {
        return this.guid();
    }

    public byte copy$default$2() {
        return this.tp();
    }

    public String copy$default$3() {
        return this.message();
    }

    public Option<String> copy$default$4() {
        return this.channel();
    }

    @Override
    public String productPrefix() {
        return "ChatMessage";
    }

    @Override
    public int productArity() {
        return 4;
    }

    @Override
    public Object productElement(int x$1) {
        Object object;
        int n = x$1;
        switch (n) {
            case 0: {
                object = BoxesRunTime.boxToLong(this.guid());
                break;
            }
            case 1: {
                object = BoxesRunTime.boxToByte(this.tp());
                break;
            }
            case 2: {
                object = this.message();
                break;
            }
            case 3: {
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
        return x$1 instanceof ChatMessage;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.longHash(this.guid()));
        n = Statics.mix(n, this.tp());
        n = Statics.mix(n, Statics.anyHash(this.message()));
        n = Statics.mix(n, Statics.anyHash(this.channel()));
        return Statics.finalizeHash(n, 4);
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
        if (!(object instanceof ChatMessage)) return false;
        boolean bl = true;
        if (!bl) return false;
        ChatMessage chatMessage = (ChatMessage)x$1;
        if (this.guid() != chatMessage.guid()) return false;
        if (this.tp() != chatMessage.tp()) return false;
        String string = this.message();
        String string2 = chatMessage.message();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        Option<String> option = this.channel();
        Option<String> option2 = chatMessage.channel();
        if (option == null) {
            if (option2 != null) {
                return false;
            }
        } else if (!option.equals(option2)) return false;
        if (!chatMessage.canEqual(this)) return false;
        return true;
    }

    public ChatMessage(long guid, byte tp, String message, Option<String> channel) {
        this.guid = guid;
        this.tp = tp;
        this.message = message;
        this.channel = channel;
        Product.$init$(this);
    }
}

