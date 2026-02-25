/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import wowchat.game.Player$;

@ScalaSignature(bytes="\u0006\u0001\u0005}b\u0001\u0002\r\u001a\u0001zA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\tq\u0001\u0011\t\u0012)A\u0005[!A\u0011\b\u0001BK\u0002\u0013\u0005!\b\u0003\u0005?\u0001\tE\t\u0015!\u0003<\u0011\u0015y\u0004\u0001\"\u0001A\u0011\u001d)\u0005!!A\u0005\u0002\u0019Cq!\u0013\u0001\u0012\u0002\u0013\u0005!\nC\u0004V\u0001E\u0005I\u0011\u0001,\t\u000fa\u0003\u0011\u0011!C!3\"9\u0011\rAA\u0001\n\u0003\u0011\u0007b\u00024\u0001\u0003\u0003%\ta\u001a\u0005\b[\u0002\t\t\u0011\"\u0011o\u0011\u001d)\b!!A\u0005\u0002YDqa\u001f\u0001\u0002\u0002\u0013\u0005C\u0010C\u0004~\u0001\u0005\u0005I\u0011\t@\t\u0011}\u0004\u0011\u0011!C!\u0003\u00039\u0011\"!\u0002\u001a\u0003\u0003E\t!a\u0002\u0007\u0011aI\u0012\u0011!E\u0001\u0003\u0013Aaa\u0010\n\u0005\u0002\u0005]\u0001bB?\u0013\u0003\u0003%)E \u0005\n\u00033\u0011\u0012\u0011!CA\u00037A\u0011\"!\t\u0013\u0003\u0003%\t)a\t\t\u0013\u0005U\"#!A\u0005\n\u0005]\"A\u0002)mCf,'O\u0003\u0002\u001b7\u0005!q-Y7f\u0015\u0005a\u0012aB<po\u000eD\u0017\r^\u0002\u0001'\u0011\u0001q$\n\u0015\u0011\u0005\u0001\u001aS\"A\u0011\u000b\u0003\t\nQa]2bY\u0006L!\u0001J\u0011\u0003\r\u0005s\u0017PU3g!\t\u0001c%\u0003\u0002(C\t9\u0001K]8ek\u000e$\bC\u0001\u0011*\u0013\tQ\u0013E\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0003oC6,W#A\u0017\u0011\u00059*dBA\u00184!\t\u0001\u0014%D\u00012\u0015\t\u0011T$\u0001\u0004=e>|GOP\u0005\u0003i\u0005\na\u0001\u0015:fI\u00164\u0017B\u0001\u001c8\u0005\u0019\u0019FO]5oO*\u0011A'I\u0001\u0006]\u0006lW\rI\u0001\nG\"\f'o\u00117bgN,\u0012a\u000f\t\u0003AqJ!!P\u0011\u0003\t\tKH/Z\u0001\u000bG\"\f'o\u00117bgN\u0004\u0013A\u0002\u001fj]&$h\bF\u0002B\u0007\u0012\u0003\"A\u0011\u0001\u000e\u0003eAQaK\u0003A\u00025BQ!O\u0003A\u0002m\nAaY8qsR\u0019\u0011i\u0012%\t\u000f-2\u0001\u0013!a\u0001[!9\u0011H\u0002I\u0001\u0002\u0004Y\u0014AD2paf$C-\u001a4bk2$H%M\u000b\u0002\u0017*\u0012Q\u0006T\u0016\u0002\u001bB\u0011ajU\u0007\u0002\u001f*\u0011\u0001+U\u0001\nk:\u001c\u0007.Z2lK\u0012T!AU\u0011\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002U\u001f\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU\tqK\u000b\u0002<\u0019\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012A\u0017\t\u00037\u0002l\u0011\u0001\u0018\u0006\u0003;z\u000bA\u0001\\1oO*\tq,\u0001\u0003kCZ\f\u0017B\u0001\u001c]\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005\u0019\u0007C\u0001\u0011e\u0013\t)\u0017EA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0002iWB\u0011\u0001%[\u0005\u0003U\u0006\u00121!\u00118z\u0011\u001da7\"!AA\u0002\r\f1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#A8\u0011\u0007A\u001c\b.D\u0001r\u0015\t\u0011\u0018%\u0001\u0006d_2dWm\u0019;j_:L!\u0001^9\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0003oj\u0004\"\u0001\t=\n\u0005e\f#a\u0002\"p_2,\u0017M\u001c\u0005\bY6\t\t\u00111\u0001i\u0003!A\u0017m\u001d5D_\u0012,G#A2\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012AW\u0001\u0007KF,\u0018\r\\:\u0015\u0007]\f\u0019\u0001C\u0004m!\u0005\u0005\t\u0019\u00015\u0002\rAc\u0017-_3s!\t\u0011%c\u0005\u0003\u0013\u0003\u0017A\u0003cBA\u0007\u0003'i3(Q\u0007\u0003\u0003\u001fQ1!!\u0005\"\u0003\u001d\u0011XO\u001c;j[\u0016LA!!\u0006\u0002\u0010\t\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0005\u0005\u001d\u0011!B1qa2LH#B!\u0002\u001e\u0005}\u0001\"B\u0016\u0016\u0001\u0004i\u0003\"B\u001d\u0016\u0001\u0004Y\u0014aB;oCB\u0004H.\u001f\u000b\u0005\u0003K\t\t\u0004E\u0003!\u0003O\tY#C\u0002\u0002*\u0005\u0012aa\u00149uS>t\u0007#\u0002\u0011\u0002.5Z\u0014bAA\u0018C\t1A+\u001e9mKJB\u0001\"a\r\u0017\u0003\u0003\u0005\r!Q\u0001\u0004q\u0012\u0002\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!!\u000f\u0011\u0007m\u000bY$C\u0002\u0002>q\u0013aa\u00142kK\u000e$\b")
public class Player
implements Product,
Serializable {
    private final String name;
    private final byte charClass;

    public static Option<Tuple2<String, Object>> unapply(Player player) {
        return Player$.MODULE$.unapply(player);
    }

    public static Player apply(String string, byte by) {
        return Player$.MODULE$.apply(string, by);
    }

    public static Function1<Tuple2<String, Object>, Player> tupled() {
        return Player$.MODULE$.tupled();
    }

    public static Function1<String, Function1<Object, Player>> curried() {
        return Player$.MODULE$.curried();
    }

    public String name() {
        return this.name;
    }

    public byte charClass() {
        return this.charClass;
    }

    public Player copy(String name, byte charClass) {
        return new Player(name, charClass);
    }

    public String copy$default$1() {
        return this.name();
    }

    public byte copy$default$2() {
        return this.charClass();
    }

    @Override
    public String productPrefix() {
        return "Player";
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
                object = this.name();
                break;
            }
            case 1: {
                object = BoxesRunTime.boxToByte(this.charClass());
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
        return x$1 instanceof Player;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.name()));
        n = Statics.mix(n, this.charClass());
        return Statics.finalizeHash(n, 2);
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
        if (!(object instanceof Player)) return false;
        boolean bl = true;
        if (!bl) return false;
        Player player = (Player)x$1;
        String string = this.name();
        String string2 = player.name();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (this.charClass() != player.charClass()) return false;
        if (!player.canEqual(this)) return false;
        return true;
    }

    public Player(String name, byte charClass) {
        this.name = name;
        this.charClass = charClass;
        Product.$init$(this);
    }
}

