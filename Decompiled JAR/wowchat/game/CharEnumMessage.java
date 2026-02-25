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
import wowchat.game.CharEnumMessage$;

@ScalaSignature(bytes="\u0006\u0001\u0005=d\u0001\u0002\u0010 \u0001\u0012B\u0001\"\r\u0001\u0003\u0016\u0004%\tA\r\u0005\t}\u0001\u0011\t\u0012)A\u0005g!Aq\b\u0001BK\u0002\u0013\u0005\u0001\t\u0003\u0005E\u0001\tE\t\u0015!\u0003B\u0011!)\u0005A!f\u0001\n\u00031\u0005\u0002\u0003&\u0001\u0005#\u0005\u000b\u0011B$\t\u0011-\u0003!Q3A\u0005\u0002\u0001C\u0001\u0002\u0014\u0001\u0003\u0012\u0003\u0006I!\u0011\u0005\u0006\u001b\u0002!\tA\u0014\u0005\b+\u0002\t\t\u0011\"\u0001W\u0011\u001dY\u0006!%A\u0005\u0002qCqa\u001a\u0001\u0012\u0002\u0013\u0005\u0001\u000eC\u0004k\u0001E\u0005I\u0011A6\t\u000f5\u0004\u0011\u0013!C\u0001Q\"9a\u000eAA\u0001\n\u0003z\u0007bB<\u0001\u0003\u0003%\t\u0001\u001f\u0005\by\u0002\t\t\u0011\"\u0001~\u0011%\t9\u0001AA\u0001\n\u0003\nI\u0001C\u0005\u0002\u0018\u0001\t\t\u0011\"\u0001\u0002\u001a!I\u00111\u0005\u0001\u0002\u0002\u0013\u0005\u0013Q\u0005\u0005\n\u0003O\u0001\u0011\u0011!C!\u0003SA\u0011\"a\u000b\u0001\u0003\u0003%\t%!\f\b\u0013\u0005Er$!A\t\u0002\u0005Mb\u0001\u0003\u0010 \u0003\u0003E\t!!\u000e\t\r5CB\u0011AA\"\u0011%\t9\u0003GA\u0001\n\u000b\nI\u0003C\u0005\u0002Fa\t\t\u0011\"!\u0002H!I\u0011\u0011\u000b\r\u0002\u0002\u0013\u0005\u00151\u000b\u0005\n\u0003KB\u0012\u0011!C\u0005\u0003O\u0012qb\u00115be\u0016sW/\\'fgN\fw-\u001a\u0006\u0003A\u0005\nAaZ1nK*\t!%A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M!\u0001!J\u0016/!\t1\u0013&D\u0001(\u0015\u0005A\u0013!B:dC2\f\u0017B\u0001\u0016(\u0005\u0019\te.\u001f*fMB\u0011a\u0005L\u0005\u0003[\u001d\u0012q\u0001\u0015:pIV\u001cG\u000f\u0005\u0002'_%\u0011\u0001g\n\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0005]\u0006lW-F\u00014!\t!4H\u0004\u00026sA\u0011agJ\u0007\u0002o)\u0011\u0001hI\u0001\u0007yI|w\u000e\u001e \n\u0005i:\u0013A\u0002)sK\u0012,g-\u0003\u0002={\t11\u000b\u001e:j]\u001eT!AO\u0014\u0002\u000b9\fW.\u001a\u0011\u0002\t\u001d,\u0018\u000eZ\u000b\u0002\u0003B\u0011aEQ\u0005\u0003\u0007\u001e\u0012A\u0001T8oO\u0006)q-^5eA\u0005!!/Y2f+\u00059\u0005C\u0001\u0014I\u0013\tIuE\u0001\u0003CsR,\u0017!\u0002:bG\u0016\u0004\u0013!C4vS2$w)^5e\u0003)9W/\u001b7e\u000fVLG\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u000b=\u000b&k\u0015+\u0011\u0005A\u0003Q\"A\u0010\t\u000bEJ\u0001\u0019A\u001a\t\u000b}J\u0001\u0019A!\t\u000b\u0015K\u0001\u0019A$\t\u000b-K\u0001\u0019A!\u0002\t\r|\u0007/\u001f\u000b\u0006\u001f^C\u0016L\u0017\u0005\bc)\u0001\n\u00111\u00014\u0011\u001dy$\u0002%AA\u0002\u0005Cq!\u0012\u0006\u0011\u0002\u0003\u0007q\tC\u0004L\u0015A\u0005\t\u0019A!\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\tQL\u000b\u00024=.\nq\f\u0005\u0002aK6\t\u0011M\u0003\u0002cG\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0003I\u001e\n!\"\u00198o_R\fG/[8o\u0013\t1\u0017MA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fabY8qs\u0012\"WMZ1vYR$#'F\u0001jU\t\te,\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001a\u0016\u00031T#a\u00120\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%i\u0005i\u0001O]8ek\u000e$\bK]3gSb,\u0012\u0001\u001d\t\u0003cZl\u0011A\u001d\u0006\u0003gR\fA\u0001\\1oO*\tQ/\u0001\u0003kCZ\f\u0017B\u0001\u001fs\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005I\bC\u0001\u0014{\u0013\tYxEA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000fF\u0002\u007f\u0003\u0007\u0001\"AJ@\n\u0007\u0005\u0005qEA\u0002B]fD\u0001\"!\u0002\u0012\u0003\u0003\u0005\r!_\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\u0005-\u0001#BA\u0007\u0003'qXBAA\b\u0015\r\t\tbJ\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA\u000b\u0003\u001f\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!\u00111DA\u0011!\r1\u0013QD\u0005\u0004\u0003?9#a\u0002\"p_2,\u0017M\u001c\u0005\t\u0003\u000b\u0019\u0012\u0011!a\u0001}\u0006A\u0001.Y:i\u0007>$W\rF\u0001z\u0003!!xn\u0015;sS:<G#\u00019\u0002\r\u0015\fX/\u00197t)\u0011\tY\"a\f\t\u0011\u0005\u0015a#!AA\u0002y\fqb\u00115be\u0016sW/\\'fgN\fw-\u001a\t\u0003!b\u0019B\u0001GA\u001c]AI\u0011\u0011HA g\u0005;\u0015iT\u0007\u0003\u0003wQ1!!\u0010(\u0003\u001d\u0011XO\u001c;j[\u0016LA!!\u0011\u0002<\t\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001b\u0015\u0005\u0005M\u0012!B1qa2LH#C(\u0002J\u0005-\u0013QJA(\u0011\u0015\t4\u00041\u00014\u0011\u0015y4\u00041\u0001B\u0011\u0015)5\u00041\u0001H\u0011\u0015Y5\u00041\u0001B\u0003\u001d)h.\u00199qYf$B!!\u0016\u0002bA)a%a\u0016\u0002\\%\u0019\u0011\u0011L\u0014\u0003\r=\u0003H/[8o!\u001d1\u0013QL\u001aB\u000f\u0006K1!a\u0018(\u0005\u0019!V\u000f\u001d7fi!A\u00111\r\u000f\u0002\u0002\u0003\u0007q*A\u0002yIA\n1B]3bIJ+7o\u001c7wKR\u0011\u0011\u0011\u000e\t\u0004c\u0006-\u0014bAA7e\n1qJ\u00196fGR\u0004")
public class CharEnumMessage
implements Product,
Serializable {
    private final String name;
    private final long guid;
    private final byte race;
    private final long guildGuid;

    public static Option<Tuple4<String, Object, Object, Object>> unapply(CharEnumMessage charEnumMessage) {
        return CharEnumMessage$.MODULE$.unapply(charEnumMessage);
    }

    public static CharEnumMessage apply(String string, long l, byte by, long l2) {
        return CharEnumMessage$.MODULE$.apply(string, l, by, l2);
    }

    public static Function1<Tuple4<String, Object, Object, Object>, CharEnumMessage> tupled() {
        return CharEnumMessage$.MODULE$.tupled();
    }

    public static Function1<String, Function1<Object, Function1<Object, Function1<Object, CharEnumMessage>>>> curried() {
        return CharEnumMessage$.MODULE$.curried();
    }

    public String name() {
        return this.name;
    }

    public long guid() {
        return this.guid;
    }

    public byte race() {
        return this.race;
    }

    public long guildGuid() {
        return this.guildGuid;
    }

    public CharEnumMessage copy(String name, long guid, byte race, long guildGuid) {
        return new CharEnumMessage(name, guid, race, guildGuid);
    }

    public String copy$default$1() {
        return this.name();
    }

    public long copy$default$2() {
        return this.guid();
    }

    public byte copy$default$3() {
        return this.race();
    }

    public long copy$default$4() {
        return this.guildGuid();
    }

    @Override
    public String productPrefix() {
        return "CharEnumMessage";
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
                object = this.name();
                break;
            }
            case 1: {
                object = BoxesRunTime.boxToLong(this.guid());
                break;
            }
            case 2: {
                object = BoxesRunTime.boxToByte(this.race());
                break;
            }
            case 3: {
                object = BoxesRunTime.boxToLong(this.guildGuid());
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
        return x$1 instanceof CharEnumMessage;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.name()));
        n = Statics.mix(n, Statics.longHash(this.guid()));
        n = Statics.mix(n, this.race());
        n = Statics.mix(n, Statics.longHash(this.guildGuid()));
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
        if (!(object instanceof CharEnumMessage)) return false;
        boolean bl = true;
        if (!bl) return false;
        CharEnumMessage charEnumMessage = (CharEnumMessage)x$1;
        String string = this.name();
        String string2 = charEnumMessage.name();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (this.guid() != charEnumMessage.guid()) return false;
        if (this.race() != charEnumMessage.race()) return false;
        if (this.guildGuid() != charEnumMessage.guildGuid()) return false;
        if (!charEnumMessage.canEqual(this)) return false;
        return true;
    }

    public CharEnumMessage(String name, long guid, byte race, long guildGuid) {
        this.name = name;
        this.guid = guid;
        this.race = race;
        this.guildGuid = guildGuid;
        Product.$init$(this);
    }
}

