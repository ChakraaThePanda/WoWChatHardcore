/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import io.netty.buffer.ByteBuf;
import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import wowchat.game.AuthChallengeMessage$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015c\u0001\u0002\r\u001a\u0001zA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\tg\u0001\u0011\t\u0012)A\u0005[!AA\u0007\u0001BK\u0002\u0013\u0005Q\u0007\u0003\u0005A\u0001\tE\t\u0015!\u00037\u0011\u0015\t\u0005\u0001\"\u0001C\u0011\u001d9\u0005!!A\u0005\u0002!Cqa\u0013\u0001\u0012\u0002\u0013\u0005A\nC\u0004X\u0001E\u0005I\u0011\u0001-\t\u000fi\u0003\u0011\u0011!C!7\"9A\rAA\u0001\n\u0003)\u0007bB5\u0001\u0003\u0003%\tA\u001b\u0005\ba\u0002\t\t\u0011\"\u0011r\u0011\u001dA\b!!A\u0005\u0002eDqA \u0001\u0002\u0002\u0013\u0005s\u0010C\u0005\u0002\u0002\u0001\t\t\u0011\"\u0011\u0002\u0004!I\u0011Q\u0001\u0001\u0002\u0002\u0013\u0005\u0013qA\u0004\n\u0003\u0017I\u0012\u0011!E\u0001\u0003\u001b1\u0001\u0002G\r\u0002\u0002#\u0005\u0011q\u0002\u0005\u0007\u0003J!\t!!\b\t\u0013\u0005\u0005!#!A\u0005F\u0005\r\u0001\"CA\u0010%\u0005\u0005I\u0011QA\u0011\u0011%\t9CEA\u0001\n\u0003\u000bI\u0003C\u0005\u0002<I\t\t\u0011\"\u0003\u0002>\t!\u0012)\u001e;i\u0007\"\fG\u000e\\3oO\u0016lUm]:bO\u0016T!AG\u000e\u0002\t\u001d\fW.\u001a\u0006\u00029\u00059qo\\<dQ\u0006$8\u0001A\n\u0005\u0001})\u0003\u0006\u0005\u0002!G5\t\u0011EC\u0001#\u0003\u0015\u00198-\u00197b\u0013\t!\u0013E\u0001\u0004B]f\u0014VM\u001a\t\u0003A\u0019J!aJ\u0011\u0003\u000fA\u0013x\u000eZ;diB\u0011\u0001%K\u0005\u0003U\u0005\u0012AbU3sS\u0006d\u0017N_1cY\u0016\f!b]3tg&|gnS3z+\u0005i\u0003c\u0001\u0011/a%\u0011q&\t\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0003AEJ!AM\u0011\u0003\t\tKH/Z\u0001\fg\u0016\u001c8/[8o\u0017\u0016L\b%A\u0004csR,')\u001e4\u0016\u0003Y\u0002\"a\u000e \u000e\u0003aR!!\u000f\u001e\u0002\r\t,hMZ3s\u0015\tYD(A\u0003oKR$\u0018PC\u0001>\u0003\tIw.\u0003\u0002@q\t9!)\u001f;f\u0005V4\u0017\u0001\u00032zi\u0016\u0014UO\u001a\u0011\u0002\rqJg.\u001b;?)\r\u0019UI\u0012\t\u0003\t\u0002i\u0011!\u0007\u0005\u0006W\u0015\u0001\r!\f\u0005\u0006i\u0015\u0001\rAN\u0001\u0005G>\u0004\u0018\u0010F\u0002D\u0013*Cqa\u000b\u0004\u0011\u0002\u0003\u0007Q\u0006C\u00045\rA\u0005\t\u0019\u0001\u001c\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\tQJ\u000b\u0002.\u001d.\nq\n\u0005\u0002Q+6\t\u0011K\u0003\u0002S'\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0003)\u0006\n!\"\u00198o_R\fG/[8o\u0013\t1\u0016KA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fabY8qs\u0012\"WMZ1vYR$#'F\u0001ZU\t1d*A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u00029B\u0011QLY\u0007\u0002=*\u0011q\fY\u0001\u0005Y\u0006twMC\u0001b\u0003\u0011Q\u0017M^1\n\u0005\rt&AB*ue&tw-\u0001\u0007qe>$Wo\u0019;Be&$\u00180F\u0001g!\t\u0001s-\u0003\u0002iC\t\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u00111N\u001c\t\u0003A1L!!\\\u0011\u0003\u0007\u0005s\u0017\u0010C\u0004p\u0017\u0005\u0005\t\u0019\u00014\u0002\u0007a$\u0013'A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\u0005\u0011\bcA:wW6\tAO\u0003\u0002vC\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005]$(\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$\"A_?\u0011\u0005\u0001Z\u0018B\u0001?\"\u0005\u001d\u0011un\u001c7fC:Dqa\\\u0007\u0002\u0002\u0003\u00071.\u0001\u0005iCND7i\u001c3f)\u00051\u0017\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003q\u000ba!Z9vC2\u001cHc\u0001>\u0002\n!9q\u000eEA\u0001\u0002\u0004Y\u0017\u0001F!vi\"\u001c\u0005.\u00197mK:<W-T3tg\u0006<W\r\u0005\u0002E%M!!#!\u0005)!\u001d\t\u0019\"!\u0007.m\rk!!!\u0006\u000b\u0007\u0005]\u0011%A\u0004sk:$\u0018.\\3\n\t\u0005m\u0011Q\u0003\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\u0014DCAA\u0007\u0003\u0015\t\u0007\u000f\u001d7z)\u0015\u0019\u00151EA\u0013\u0011\u0015YS\u00031\u0001.\u0011\u0015!T\u00031\u00017\u0003\u001d)h.\u00199qYf$B!a\u000b\u00028A)\u0001%!\f\u00022%\u0019\u0011qF\u0011\u0003\r=\u0003H/[8o!\u0015\u0001\u00131G\u00177\u0013\r\t)$\t\u0002\u0007)V\u0004H.\u001a\u001a\t\u0011\u0005eb#!AA\u0002\r\u000b1\u0001\u001f\u00131\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005}\u0002cA/\u0002B%\u0019\u00111\t0\u0003\r=\u0013'.Z2u\u0001")
public class AuthChallengeMessage
implements Product,
Serializable {
    private final byte[] sessionKey;
    private final ByteBuf byteBuf;

    public static Option<Tuple2<byte[], ByteBuf>> unapply(AuthChallengeMessage authChallengeMessage) {
        return AuthChallengeMessage$.MODULE$.unapply(authChallengeMessage);
    }

    public static AuthChallengeMessage apply(byte[] byArray, ByteBuf byteBuf) {
        return AuthChallengeMessage$.MODULE$.apply(byArray, byteBuf);
    }

    public static Function1<Tuple2<byte[], ByteBuf>, AuthChallengeMessage> tupled() {
        return AuthChallengeMessage$.MODULE$.tupled();
    }

    public static Function1<byte[], Function1<ByteBuf, AuthChallengeMessage>> curried() {
        return AuthChallengeMessage$.MODULE$.curried();
    }

    public byte[] sessionKey() {
        return this.sessionKey;
    }

    public ByteBuf byteBuf() {
        return this.byteBuf;
    }

    public AuthChallengeMessage copy(byte[] sessionKey, ByteBuf byteBuf) {
        return new AuthChallengeMessage(sessionKey, byteBuf);
    }

    public byte[] copy$default$1() {
        return this.sessionKey();
    }

    public ByteBuf copy$default$2() {
        return this.byteBuf();
    }

    @Override
    public String productPrefix() {
        return "AuthChallengeMessage";
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
                object = this.sessionKey();
                break;
            }
            case 1: {
                object = this.byteBuf();
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
        return x$1 instanceof AuthChallengeMessage;
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
        if (!(object instanceof AuthChallengeMessage)) return false;
        boolean bl = true;
        if (!bl) return false;
        AuthChallengeMessage authChallengeMessage = (AuthChallengeMessage)x$1;
        if (this.sessionKey() != authChallengeMessage.sessionKey()) return false;
        ByteBuf byteBuf = this.byteBuf();
        ByteBuf byteBuf2 = authChallengeMessage.byteBuf();
        if (byteBuf == null) {
            if (byteBuf2 != null) {
                return false;
            }
        } else if (!((Object)byteBuf).equals(byteBuf2)) return false;
        if (!authChallengeMessage.canEqual(this)) return false;
        return true;
    }

    public AuthChallengeMessage(byte[] sessionKey, ByteBuf byteBuf) {
        this.sessionKey = sessionKey;
        this.byteBuf = byteBuf;
        Product.$init$(this);
    }
}

