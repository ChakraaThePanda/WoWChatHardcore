/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

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
import wowchat.game.NameQueryMessage$;

@ScalaSignature(bytes="\u0006\u0001\u0005uc\u0001B\u000e\u001d\u0001\u0006B\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\tg\u0001\u0011\t\u0012)A\u0005a!AA\u0007\u0001BK\u0002\u0013\u0005Q\u0007\u0003\u0005B\u0001\tE\t\u0015!\u00037\u0011!\u0011\u0005A!f\u0001\n\u0003\u0019\u0005\u0002C$\u0001\u0005#\u0005\u000b\u0011\u0002#\t\u000b!\u0003A\u0011A%\t\u000f=\u0003\u0011\u0011!C\u0001!\"9A\u000bAI\u0001\n\u0003)\u0006b\u00021\u0001#\u0003%\t!\u0019\u0005\bG\u0002\t\n\u0011\"\u0001e\u0011\u001d1\u0007!!A\u0005B\u001dDqa\u001c\u0001\u0002\u0002\u0013\u0005\u0001\u000fC\u0004u\u0001\u0005\u0005I\u0011A;\t\u000fm\u0004\u0011\u0011!C!y\"I\u0011q\u0001\u0001\u0002\u0002\u0013\u0005\u0011\u0011\u0002\u0005\n\u0003'\u0001\u0011\u0011!C!\u0003+A\u0011\"a\u0006\u0001\u0003\u0003%\t%!\u0007\t\u0013\u0005m\u0001!!A\u0005B\u0005uq!CA\u00119\u0005\u0005\t\u0012AA\u0012\r!YB$!A\t\u0002\u0005\u0015\u0002B\u0002%\u0016\t\u0003\t\u0019\u0004C\u0005\u0002\u0018U\t\t\u0011\"\u0012\u0002\u001a!I\u0011QG\u000b\u0002\u0002\u0013\u0005\u0015q\u0007\u0005\n\u0003\u007f)\u0012\u0011!CA\u0003\u0003B\u0011\"a\u0015\u0016\u0003\u0003%I!!\u0016\u0003!9\u000bW.Z)vKJLX*Z:tC\u001e,'BA\u000f\u001f\u0003\u00119\u0017-\\3\u000b\u0003}\tqa^8xG\"\fGo\u0001\u0001\u0014\t\u0001\u0011\u0003f\u000b\t\u0003G\u0019j\u0011\u0001\n\u0006\u0002K\u0005)1oY1mC&\u0011q\u0005\n\u0002\u0007\u0003:L(+\u001a4\u0011\u0005\rJ\u0013B\u0001\u0016%\u0005\u001d\u0001&o\u001c3vGR\u0004\"a\t\u0017\n\u00055\"#\u0001D*fe&\fG.\u001b>bE2,\u0017\u0001B4vS\u0012,\u0012\u0001\r\t\u0003GEJ!A\r\u0013\u0003\t1{gnZ\u0001\u0006OVLG\rI\u0001\u0005]\u0006lW-F\u00017!\t9dH\u0004\u00029yA\u0011\u0011\bJ\u0007\u0002u)\u00111\bI\u0001\u0007yI|w\u000e\u001e \n\u0005u\"\u0013A\u0002)sK\u0012,g-\u0003\u0002@\u0001\n11\u000b\u001e:j]\u001eT!!\u0010\u0013\u0002\u000b9\fW.\u001a\u0011\u0002\u0013\rD\u0017M]\"mCN\u001cX#\u0001#\u0011\u0005\r*\u0015B\u0001$%\u0005\u0011\u0011\u0015\u0010^3\u0002\u0015\rD\u0017M]\"mCN\u001c\b%\u0001\u0004=S:LGO\u0010\u000b\u0005\u00152ke\n\u0005\u0002L\u00015\tA\u0004C\u0003/\u000f\u0001\u0007\u0001\u0007C\u00035\u000f\u0001\u0007a\u0007C\u0003C\u000f\u0001\u0007A)\u0001\u0003d_BLH\u0003\u0002&R%NCqA\f\u0005\u0011\u0002\u0003\u0007\u0001\u0007C\u00045\u0011A\u0005\t\u0019\u0001\u001c\t\u000f\tC\u0001\u0013!a\u0001\t\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#\u0001,+\u0005A:6&\u0001-\u0011\u0005esV\"\u0001.\u000b\u0005mc\u0016!C;oG\",7m[3e\u0015\tiF%\u0001\u0006b]:|G/\u0019;j_:L!a\u0018.\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0003\tT#AN,\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%gU\tQM\u000b\u0002E/\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012\u0001\u001b\t\u0003S:l\u0011A\u001b\u0006\u0003W2\fA\u0001\\1oO*\tQ.\u0001\u0003kCZ\f\u0017BA k\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005\t\bCA\u0012s\u0013\t\u0019HEA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0002wsB\u00111e^\u0005\u0003q\u0012\u00121!\u00118z\u0011\u001dQh\"!AA\u0002E\f1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#A?\u0011\ty\f\u0019A^\u0007\u0002\u007f*\u0019\u0011\u0011\u0001\u0013\u0002\u0015\r|G\u000e\\3di&|g.C\u0002\u0002\u0006}\u0014\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!\u00111BA\t!\r\u0019\u0013QB\u0005\u0004\u0003\u001f!#a\u0002\"p_2,\u0017M\u001c\u0005\buB\t\t\u00111\u0001w\u0003!A\u0017m\u001d5D_\u0012,G#A9\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012\u0001[\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005-\u0011q\u0004\u0005\buN\t\t\u00111\u0001w\u0003Aq\u0015-\\3Rk\u0016\u0014\u00180T3tg\u0006<W\r\u0005\u0002L+M!Q#a\n,!!\tI#a\f1m\u0011SUBAA\u0016\u0015\r\ti\u0003J\u0001\beVtG/[7f\u0013\u0011\t\t$a\u000b\u0003#\u0005\u00137\u000f\u001e:bGR4UO\\2uS>t7\u0007\u0006\u0002\u0002$\u0005)\u0011\r\u001d9msR9!*!\u000f\u0002<\u0005u\u0002\"\u0002\u0018\u0019\u0001\u0004\u0001\u0004\"\u0002\u001b\u0019\u0001\u00041\u0004\"\u0002\"\u0019\u0001\u0004!\u0015aB;oCB\u0004H.\u001f\u000b\u0005\u0003\u0007\ny\u0005E\u0003$\u0003\u000b\nI%C\u0002\u0002H\u0011\u0012aa\u00149uS>t\u0007CB\u0012\u0002LA2D)C\u0002\u0002N\u0011\u0012a\u0001V;qY\u0016\u001c\u0004\u0002CA)3\u0005\u0005\t\u0019\u0001&\u0002\u0007a$\u0003'A\u0006sK\u0006$'+Z:pYZ,GCAA,!\rI\u0017\u0011L\u0005\u0004\u00037R'AB(cU\u0016\u001cG\u000f")
public class NameQueryMessage
implements Product,
Serializable {
    private final long guid;
    private final String name;
    private final byte charClass;

    public static Option<Tuple3<Object, String, Object>> unapply(NameQueryMessage nameQueryMessage) {
        return NameQueryMessage$.MODULE$.unapply(nameQueryMessage);
    }

    public static NameQueryMessage apply(long l, String string, byte by) {
        return NameQueryMessage$.MODULE$.apply(l, string, by);
    }

    public static Function1<Tuple3<Object, String, Object>, NameQueryMessage> tupled() {
        return NameQueryMessage$.MODULE$.tupled();
    }

    public static Function1<Object, Function1<String, Function1<Object, NameQueryMessage>>> curried() {
        return NameQueryMessage$.MODULE$.curried();
    }

    public long guid() {
        return this.guid;
    }

    public String name() {
        return this.name;
    }

    public byte charClass() {
        return this.charClass;
    }

    public NameQueryMessage copy(long guid, String name, byte charClass) {
        return new NameQueryMessage(guid, name, charClass);
    }

    public long copy$default$1() {
        return this.guid();
    }

    public String copy$default$2() {
        return this.name();
    }

    public byte copy$default$3() {
        return this.charClass();
    }

    @Override
    public String productPrefix() {
        return "NameQueryMessage";
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
                object = BoxesRunTime.boxToLong(this.guid());
                break;
            }
            case 1: {
                object = this.name();
                break;
            }
            case 2: {
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
        return x$1 instanceof NameQueryMessage;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.longHash(this.guid()));
        n = Statics.mix(n, Statics.anyHash(this.name()));
        n = Statics.mix(n, this.charClass());
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
        if (!(object instanceof NameQueryMessage)) return false;
        boolean bl = true;
        if (!bl) return false;
        NameQueryMessage nameQueryMessage = (NameQueryMessage)x$1;
        if (this.guid() != nameQueryMessage.guid()) return false;
        String string = this.name();
        String string2 = nameQueryMessage.name();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (this.charClass() != nameQueryMessage.charClass()) return false;
        if (!nameQueryMessage.canEqual(this)) return false;
        return true;
    }

    public NameQueryMessage(long guid, String name, byte charClass) {
        this.guid = guid;
        this.name = name;
        this.charClass = charClass;
        Product.$init$(this);
    }
}

