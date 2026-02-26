/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Position;
import scala.reflect.macros.ParseException$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005-c\u0001B\f\u0019\u0001~A\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\tm\u0001\u0011\t\u0012)A\u0005a!Aq\u0007\u0001BK\u0002\u0013\u0005\u0001\b\u0003\u0005E\u0001\tE\t\u0015!\u0003:\u0011\u0015)\u0005\u0001\"\u0001G\u0011\u001dY\u0005!!A\u0005\u00021Cqa\u0014\u0001\u0012\u0002\u0013\u0005\u0001\u000bC\u0004\\\u0001E\u0005I\u0011\u0001/\t\u000fy\u0003\u0011\u0011!C!?\"9q\rAA\u0001\n\u0003A\u0007b\u00027\u0001\u0003\u0003%\t!\u001c\u0005\bg\u0002\t\t\u0011\"\u0011u\u0011\u001dY\b!!A\u0005\u0002qD\u0011\"a\u0001\u0001\u0003\u0003%\t%!\u0002\t\u0013\u0005\u001d\u0001!!A\u0005B\u0005%q!CA\u00071\u0005\u0005\t\u0012AA\b\r!9\u0002$!A\t\u0002\u0005E\u0001BB#\u0012\t\u0003\ty\u0002C\u0005\u0002\"E\t\t\u0011\"\u0012\u0002$!I\u0011QE\t\u0002\u0002\u0013\u0005\u0015q\u0005\u0005\n\u0003[\t\u0012\u0011!CA\u0003_A\u0011\"!\u0011\u0012\u0003\u0003%I!a\u0011\u0003\u001dA\u000b'o]3Fq\u000e,\u0007\u000f^5p]*\u0011\u0011DG\u0001\u0007[\u0006\u001c'o\\:\u000b\u0005ma\u0012a\u0002:fM2,7\r\u001e\u0006\u0002;\u0005)1oY1mC\u000e\u00011\u0003\u0002\u0001!Q-\u0002\"!I\u0013\u000f\u0005\t\u001aS\"\u0001\u000f\n\u0005\u0011b\u0012a\u00029bG.\fw-Z\u0005\u0003M\u001d\u0012\u0011\"\u0012=dKB$\u0018n\u001c8\u000b\u0005\u0011b\u0002C\u0001\u0012*\u0013\tQCDA\u0004Qe>$Wo\u0019;\u0011\u0005\tb\u0013BA\u0017\u001d\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\r\u0001xn]\u000b\u0002aA\u0011\u0011\u0007N\u0007\u0002e)\u00111GG\u0001\u0004CBL\u0017BA\u001b3\u0005!\u0001vn]5uS>t\u0017\u0001\u00029pg\u0002\n1!\\:h+\u0005I\u0004C\u0001\u001eB\u001d\tYt\b\u0005\u0002=95\tQH\u0003\u0002?=\u00051AH]8pizJ!\u0001\u0011\u000f\u0002\rA\u0013X\rZ3g\u0013\t\u00115I\u0001\u0004TiJLgn\u001a\u0006\u0003\u0001r\tA!\\:hA\u00051A(\u001b8jiz\"2aR%K!\tA\u0005!D\u0001\u0019\u0011\u0015qS\u00011\u00011\u0011\u00159T\u00011\u0001:\u0003\u0011\u0019w\u000e]=\u0015\u0007\u001dke\nC\u0004/\rA\u0005\t\u0019\u0001\u0019\t\u000f]2\u0001\u0013!a\u0001s\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#A)+\u0005A\u00126&A*\u0011\u0005QKV\"A+\u000b\u0005Y;\u0016!C;oG\",7m[3e\u0015\tAF$\u0001\u0006b]:|G/\u0019;j_:L!AW+\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0003uS#!\u000f*\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\u0005\u0001\u0007CA1g\u001b\u0005\u0011'BA2e\u0003\u0011a\u0017M\\4\u000b\u0003\u0015\fAA[1wC&\u0011!IY\u0001\raJ|G-^2u\u0003JLG/_\u000b\u0002SB\u0011!E[\u0005\u0003Wr\u00111!\u00138u\u00039\u0001(o\u001c3vGR,E.Z7f]R$\"A\\9\u0011\u0005\tz\u0017B\u00019\u001d\u0005\r\te.\u001f\u0005\be.\t\t\u00111\u0001j\u0003\rAH%M\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\tQ\u000fE\u0002ws:l\u0011a\u001e\u0006\u0003qr\t!bY8mY\u0016\u001cG/[8o\u0013\tQxO\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dGcA?\u0002\u0002A\u0011!E`\u0005\u0003\u007fr\u0011qAQ8pY\u0016\fg\u000eC\u0004s\u001b\u0005\u0005\t\u0019\u00018\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012![\u0001\u0007KF,\u0018\r\\:\u0015\u0007u\fY\u0001C\u0004s\u001f\u0005\u0005\t\u0019\u00018\u0002\u001dA\u000b'o]3Fq\u000e,\u0007\u000f^5p]B\u0011\u0001*E\n\u0005#\u0005M1\u0006E\u0004\u0002\u0016\u0005m\u0001'O$\u000e\u0005\u0005]!bAA\r9\u00059!/\u001e8uS6,\u0017\u0002BA\u000f\u0003/\u0011\u0011#\u00112tiJ\f7\r\u001e$v]\u000e$\u0018n\u001c83)\t\ty!\u0001\u0005u_N#(/\u001b8h)\u0005\u0001\u0017!B1qa2LH#B$\u0002*\u0005-\u0002\"\u0002\u0018\u0015\u0001\u0004\u0001\u0004\"B\u001c\u0015\u0001\u0004I\u0014aB;oCB\u0004H.\u001f\u000b\u0005\u0003c\ti\u0004E\u0003#\u0003g\t9$C\u0002\u00026q\u0011aa\u00149uS>t\u0007#\u0002\u0012\u0002:AJ\u0014bAA\u001e9\t1A+\u001e9mKJB\u0001\"a\u0010\u0016\u0003\u0003\u0005\raR\u0001\u0004q\u0012\u0002\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!!\u0012\u0011\u0007\u0005\f9%C\u0002\u0002J\t\u0014aa\u00142kK\u000e$\b")
public class ParseException
extends Exception
implements Product,
Serializable {
    private final Position pos;
    private final String msg;

    public static Option<Tuple2<Position, String>> unapply(ParseException parseException) {
        return ParseException$.MODULE$.unapply(parseException);
    }

    public static ParseException apply(Position position, String string) {
        return ParseException$.MODULE$.apply(position, string);
    }

    public static Function1<Tuple2<Position, String>, ParseException> tupled() {
        return ParseException$.MODULE$.tupled();
    }

    public static Function1<Position, Function1<String, ParseException>> curried() {
        return ParseException$.MODULE$.curried();
    }

    public Position pos() {
        return this.pos;
    }

    public String msg() {
        return this.msg;
    }

    public ParseException copy(Position pos, String msg) {
        return new ParseException(pos, msg);
    }

    public Position copy$default$1() {
        return this.pos();
    }

    public String copy$default$2() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "ParseException";
    }

    @Override
    public int productArity() {
        return 2;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.pos();
            }
            case 1: {
                return this.msg();
            }
        }
        throw new IndexOutOfBoundsException(Integer.toString(x$1));
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof ParseException;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        if (!(x$1 instanceof ParseException)) return false;
        boolean bl = true;
        if (!bl) return false;
        ParseException parseException = (ParseException)x$1;
        Position position = this.pos();
        Position position2 = parseException.pos();
        if (position == null) {
            if (position2 != null) {
                return false;
            }
        } else if (!position.equals(position2)) return false;
        String string = this.msg();
        String string2 = parseException.msg();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (!parseException.canEqual(this)) return false;
        return true;
    }

    public ParseException(Position pos, String msg) {
        this.pos = pos;
        this.msg = msg;
        super(msg);
        Product.$init$(this);
    }
}

