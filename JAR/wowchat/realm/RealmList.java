/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

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
import wowchat.realm.RealmList$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ec!B\u000e\u001d\u0001r\u0001\u0003\u0002C\u0017\u0001\u0005+\u0007I\u0011A\u0018\t\u0011m\u0002!\u0011#Q\u0001\nAB\u0001\u0002\u0010\u0001\u0003\u0016\u0004%\ta\f\u0005\t{\u0001\u0011\t\u0012)A\u0005a!Aa\b\u0001BK\u0002\u0013\u0005q\b\u0003\u0005D\u0001\tE\t\u0015!\u0003A\u0011\u0015!\u0005\u0001\"\u0001F\u0011\u001dY\u0005!!A\u0005\u00021Cq\u0001\u0015\u0001\u0012\u0002\u0013\u0005\u0011\u000bC\u0004]\u0001E\u0005I\u0011A)\t\u000fu\u0003\u0011\u0013!C\u0001=\"9\u0001\rAA\u0001\n\u0003\n\u0007bB5\u0001\u0003\u0003%\tA\u001b\u0005\b]\u0002\t\t\u0011\"\u0001p\u0011\u001d)\b!!A\u0005BYDq! \u0001\u0002\u0002\u0013\u0005a\u0010C\u0005\u0002\b\u0001\t\t\u0011\"\u0011\u0002\n!I\u00111\u0002\u0001\u0002\u0002\u0013\u0005\u0013Q\u0002\u0005\n\u0003\u001f\u0001\u0011\u0011!C!\u0003#9!\"!\u0006\u001d\u0003\u0003E\t\u0001HA\f\r%YB$!A\t\u0002q\tI\u0002\u0003\u0004E+\u0011\u0005\u0011q\u0005\u0005\n\u0003\u0017)\u0012\u0011!C#\u0003\u001bA\u0011\"!\u000b\u0016\u0003\u0003%\t)a\u000b\t\u0013\u0005MR#!A\u0005\u0002\u0006U\u0002\"CA$+\u0005\u0005I\u0011BA%\u0005%\u0011V-\u00197n\u0019&\u001cHO\u0003\u0002\u001e=\u0005)!/Z1m[*\tq$A\u0004x_^\u001c\u0007.\u0019;\u0014\t\u0001\tsE\u000b\t\u0003E\u0015j\u0011a\t\u0006\u0002I\u0005)1oY1mC&\u0011ae\t\u0002\u0007\u0003:L(+\u001a4\u0011\u0005\tB\u0013BA\u0015$\u0005\u001d\u0001&o\u001c3vGR\u0004\"AI\u0016\n\u00051\u001a#\u0001D*fe&\fG.\u001b>bE2,\u0017\u0001\u00028b[\u0016\u001c\u0001!F\u00011!\t\t\u0004H\u0004\u00023mA\u00111gI\u0007\u0002i)\u0011QGL\u0001\u0007yI|w\u000e\u001e \n\u0005]\u001a\u0013A\u0002)sK\u0012,g-\u0003\u0002:u\t11\u000b\u001e:j]\u001eT!aN\u0012\u0002\u000b9\fW.\u001a\u0011\u0002\u000f\u0005$GM]3tg\u0006A\u0011\r\u001a3sKN\u001c\b%A\u0004sK\u0006dW.\u00133\u0016\u0003\u0001\u0003\"AI!\n\u0005\t\u001b#\u0001\u0002\"zi\u0016\f\u0001B]3bY6LE\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\t\u0019C\u0015J\u0013\t\u0003\u000f\u0002i\u0011\u0001\b\u0005\u0006[\u001d\u0001\r\u0001\r\u0005\u0006y\u001d\u0001\r\u0001\r\u0005\u0006}\u001d\u0001\r\u0001Q\u0001\u0005G>\u0004\u0018\u0010\u0006\u0003G\u001b:{\u0005bB\u0017\t!\u0003\u0005\r\u0001\r\u0005\by!\u0001\n\u00111\u00011\u0011\u001dq\u0004\u0002%AA\u0002\u0001\u000babY8qs\u0012\"WMZ1vYR$\u0013'F\u0001SU\t\u00014kK\u0001U!\t)&,D\u0001W\u0015\t9\u0006,A\u0005v]\u000eDWmY6fI*\u0011\u0011lI\u0001\u000bC:tw\u000e^1uS>t\u0017BA.W\u0005E)hn\u00195fG.,GMV1sS\u0006t7-Z\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00133\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIM*\u0012a\u0018\u0016\u0003\u0001N\u000bQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DX#\u00012\u0011\u0005\rDW\"\u00013\u000b\u0005\u00154\u0017\u0001\u00027b]\u001eT\u0011aZ\u0001\u0005U\u00064\u0018-\u0003\u0002:I\u0006a\u0001O]8ek\u000e$\u0018I]5usV\t1\u000e\u0005\u0002#Y&\u0011Qn\t\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u0003aN\u0004\"AI9\n\u0005I\u001c#aA!os\"9AODA\u0001\u0002\u0004Y\u0017a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/F\u0001x!\rA8\u0010]\u0007\u0002s*\u0011!pI\u0001\u000bG>dG.Z2uS>t\u0017B\u0001?z\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\u0007}\f)\u0001E\u0002#\u0003\u0003I1!a\u0001$\u0005\u001d\u0011un\u001c7fC:Dq\u0001\u001e\t\u0002\u0002\u0003\u0007\u0001/\u0001\u0005iCND7i\u001c3f)\u0005Y\u0017\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003\t\fa!Z9vC2\u001cHcA@\u0002\u0014!9AoEA\u0001\u0002\u0004\u0001\u0018!\u0003*fC2lG*[:u!\t9Uc\u0005\u0003\u0016\u00037Q\u0003\u0003CA\u000f\u0003G\u0001\u0004\u0007\u0011$\u000e\u0005\u0005}!bAA\u0011G\u00059!/\u001e8uS6,\u0017\u0002BA\u0013\u0003?\u0011\u0011#\u00112tiJ\f7\r\u001e$v]\u000e$\u0018n\u001c84)\t\t9\"A\u0003baBd\u0017\u0010F\u0004G\u0003[\ty#!\r\t\u000b5B\u0002\u0019\u0001\u0019\t\u000bqB\u0002\u0019\u0001\u0019\t\u000byB\u0002\u0019\u0001!\u0002\u000fUt\u0017\r\u001d9msR!\u0011qGA\"!\u0015\u0011\u0013\u0011HA\u001f\u0013\r\tYd\t\u0002\u0007\u001fB$\u0018n\u001c8\u0011\r\t\ny\u0004\r\u0019A\u0013\r\t\te\t\u0002\u0007)V\u0004H.Z\u001a\t\u0011\u0005\u0015\u0013$!AA\u0002\u0019\u000b1\u0001\u001f\u00131\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005-\u0003cA2\u0002N%\u0019\u0011q\n3\u0003\r=\u0013'.Z2u\u0001")
public class RealmList
implements Product,
Serializable {
    private final String name;
    private final String address;
    private final byte realmId;

    public static Option<Tuple3<String, String, Object>> unapply(RealmList realmList) {
        return RealmList$.MODULE$.unapply(realmList);
    }

    public static RealmList apply(String string, String string2, byte by) {
        return RealmList$.MODULE$.apply(string, string2, by);
    }

    public static Function1<Tuple3<String, String, Object>, RealmList> tupled() {
        return RealmList$.MODULE$.tupled();
    }

    public static Function1<String, Function1<String, Function1<Object, RealmList>>> curried() {
        return RealmList$.MODULE$.curried();
    }

    public String name() {
        return this.name;
    }

    public String address() {
        return this.address;
    }

    public byte realmId() {
        return this.realmId;
    }

    public RealmList copy(String name, String address, byte realmId) {
        return new RealmList(name, address, realmId);
    }

    public String copy$default$1() {
        return this.name();
    }

    public String copy$default$2() {
        return this.address();
    }

    public byte copy$default$3() {
        return this.realmId();
    }

    @Override
    public String productPrefix() {
        return "RealmList";
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
                object = this.name();
                break;
            }
            case 1: {
                object = this.address();
                break;
            }
            case 2: {
                object = BoxesRunTime.boxToByte(this.realmId());
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
        return x$1 instanceof RealmList;
    }

    public int hashCode() {
        int n = -889275714;
        n = Statics.mix(n, Statics.anyHash(this.name()));
        n = Statics.mix(n, Statics.anyHash(this.address()));
        n = Statics.mix(n, this.realmId());
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
        if (!(object instanceof RealmList)) return false;
        boolean bl = true;
        if (!bl) return false;
        RealmList realmList = (RealmList)x$1;
        String string = this.name();
        String string2 = realmList.name();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        String string3 = this.address();
        String string4 = realmList.address();
        if (string3 == null) {
            if (string4 != null) {
                return false;
            }
        } else if (!string3.equals(string4)) return false;
        if (this.realmId() != realmList.realmId()) return false;
        if (!realmList.canEqual(this)) return false;
        return true;
    }

    public RealmList(String name, String address, byte realmId) {
        this.name = name;
        this.address = address;
        this.realmId = realmId;
        Product.$init$(this);
    }
}

