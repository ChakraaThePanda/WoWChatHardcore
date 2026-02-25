/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple3;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Position;
import scala.reflect.macros.UnexpectedReificationException$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ed\u0001\u0002\u000f\u001e\u0001\u0012B\u0001b\r\u0001\u0003\u0016\u0004%\t\u0001\u000e\u0005\tw\u0001\u0011\t\u0012)A\u0005k!AA\b\u0001BK\u0002\u0013\u0005Q\b\u0003\u0005J\u0001\tE\t\u0015!\u0003?\u0011!Q\u0005A!f\u0001\n\u0003Y\u0005\u0002C(\u0001\u0005#\u0005\u000b\u0011\u0002'\t\u000bA\u0003A\u0011A)\t\u000f]\u0003\u0011\u0011!C\u00011\"9A\fAI\u0001\n\u0003i\u0006b\u00025\u0001#\u0003%\t!\u001b\u0005\bW\u0002\t\n\u0011\"\u0001m\u0011\u001dq\u0007!!A\u0005B=Dqa\u001e\u0001\u0002\u0002\u0013\u0005\u0001\u0010C\u0004}\u0001\u0005\u0005I\u0011A?\t\u0013\u0005\u001d\u0001!!A\u0005B\u0005%\u0001\"CA\f\u0001\u0005\u0005I\u0011AA\r\u0011%\t\u0019\u0003AA\u0001\n\u0003\n)\u0003C\u0005\u0002(\u0001\t\t\u0011\"\u0011\u0002*\u001dI\u0011QF\u000f\u0002\u0002#\u0005\u0011q\u0006\u0004\t9u\t\t\u0011#\u0001\u00022!1\u0001\u000b\u0006C\u0001\u0003\u007fA\u0011\"!\u0011\u0015\u0003\u0003%)%a\u0011\t\u0013\u0005\u0015C#!A\u0005\u0002\u0006\u001d\u0003\u0002CA()E\u0005I\u0011\u00017\t\u0013\u0005EC#!A\u0005\u0002\u0006M\u0003\u0002CA3)E\u0005I\u0011\u00017\t\u0013\u0005\u001dD#!A\u0005\n\u0005%$AH+oKb\u0004Xm\u0019;fIJ+\u0017NZ5dCRLwN\\#yG\u0016\u0004H/[8o\u0015\tqr$\u0001\u0004nC\u000e\u0014xn\u001d\u0006\u0003A\u0005\nqA]3gY\u0016\u001cGOC\u0001#\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019B\u0001A\u0013.aA\u0011aE\u000b\b\u0003O!j\u0011!I\u0005\u0003S\u0005\nq\u0001]1dW\u0006<W-\u0003\u0002,Y\tIQ\t_2faRLwN\u001c\u0006\u0003S\u0005\u0002\"a\n\u0018\n\u0005=\n#a\u0002)s_\u0012,8\r\u001e\t\u0003OEJ!AM\u0011\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u0007A|7/F\u00016!\t1\u0014(D\u00018\u0015\tAt$A\u0002ba&L!AO\u001c\u0003\u0011A{7/\u001b;j_:\fA\u0001]8tA\u0005\u0019Qn]4\u0016\u0003y\u0002\"a\u0010$\u000f\u0005\u0001#\u0005CA!\"\u001b\u0005\u0011%BA\"$\u0003\u0019a$o\\8u}%\u0011Q)I\u0001\u0007!J,G-\u001a4\n\u0005\u001dC%AB*ue&twM\u0003\u0002FC\u0005!Qn]4!\u0003\u0015\u0019\u0017-^:f+\u0005a\u0005C\u0001\u0014N\u0013\tqEFA\u0005UQJ|w/\u00192mK\u000611-Y;tK\u0002\na\u0001P5oSRtD\u0003\u0002*U+Z\u0003\"a\u0015\u0001\u000e\u0003uAQaM\u0004A\u0002UBQ\u0001P\u0004A\u0002yBqAS\u0004\u0011\u0002\u0003\u0007A*\u0001\u0003d_BLH\u0003\u0002*Z5nCqa\r\u0005\u0011\u0002\u0003\u0007Q\u0007C\u0004=\u0011A\u0005\t\u0019\u0001 \t\u000f)C\u0001\u0013!a\u0001\u0019\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#\u00010+\u0005Uz6&\u00011\u0011\u0005\u00054W\"\u00012\u000b\u0005\r$\u0017!C;oG\",7m[3e\u0015\t)\u0017%\u0001\u0006b]:|G/\u0019;j_:L!a\u001a2\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0003)T#AP0\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%gU\tQN\u000b\u0002M?\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012\u0001\u001d\t\u0003cZl\u0011A\u001d\u0006\u0003gR\fA\u0001\\1oO*\tQ/\u0001\u0003kCZ\f\u0017BA$s\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005I\bCA\u0014{\u0013\tY\u0018EA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000fF\u0002\u007f\u0003\u0007\u0001\"aJ@\n\u0007\u0005\u0005\u0011EA\u0002B]fD\u0001\"!\u0002\u000f\u0003\u0003\u0005\r!_\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\u0005-\u0001#BA\u0007\u0003'qXBAA\b\u0015\r\t\t\"I\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA\u000b\u0003\u001f\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!\u00111DA\u0011!\r9\u0013QD\u0005\u0004\u0003?\t#a\u0002\"p_2,\u0017M\u001c\u0005\t\u0003\u000b\u0001\u0012\u0011!a\u0001}\u0006A\u0001.Y:i\u0007>$W\rF\u0001z\u0003\u0019)\u0017/^1mgR!\u00111DA\u0016\u0011!\t)AEA\u0001\u0002\u0004q\u0018AH+oKb\u0004Xm\u0019;fIJ+\u0017NZ5dCRLwN\\#yG\u0016\u0004H/[8o!\t\u0019Fc\u0005\u0003\u0015\u0003g\u0001\u0004\u0003CA\u001b\u0003w)d\b\u0014*\u000e\u0005\u0005]\"bAA\u001dC\u00059!/\u001e8uS6,\u0017\u0002BA\u001f\u0003o\u0011\u0011#\u00112tiJ\f7\r\u001e$v]\u000e$\u0018n\u001c84)\t\ty#\u0001\u0005u_N#(/\u001b8h)\u0005\u0001\u0018!B1qa2LHc\u0002*\u0002J\u0005-\u0013Q\n\u0005\u0006g]\u0001\r!\u000e\u0005\u0006y]\u0001\rA\u0010\u0005\b\u0015^\u0001\n\u00111\u0001M\u0003=\t\u0007\u000f\u001d7zI\u0011,g-Y;mi\u0012\u001a\u0014aB;oCB\u0004H.\u001f\u000b\u0005\u0003+\n\t\u0007E\u0003(\u0003/\nY&C\u0002\u0002Z\u0005\u0012aa\u00149uS>t\u0007CB\u0014\u0002^UrD*C\u0002\u0002`\u0005\u0012a\u0001V;qY\u0016\u001c\u0004\u0002CA23\u0005\u0005\t\u0019\u0001*\u0002\u0007a$\u0003'A\u000e%Y\u0016\u001c8/\u001b8ji\u0012:'/Z1uKJ$C-\u001a4bk2$HeM\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002lA\u0019\u0011/!\u001c\n\u0007\u0005=$O\u0001\u0004PE*,7\r\u001e")
public class UnexpectedReificationException
extends Exception
implements Product,
Serializable {
    private final Position pos;
    private final String msg;
    private final Throwable cause;

    public static Throwable $lessinit$greater$default$3() {
        return UnexpectedReificationException$.MODULE$.$lessinit$greater$default$3();
    }

    public static Option<Tuple3<Position, String, Throwable>> unapply(UnexpectedReificationException unexpectedReificationException) {
        return UnexpectedReificationException$.MODULE$.unapply(unexpectedReificationException);
    }

    public static Throwable apply$default$3() {
        return UnexpectedReificationException$.MODULE$.apply$default$3();
    }

    public static UnexpectedReificationException apply(Position position, String string, Throwable throwable) {
        return UnexpectedReificationException$.MODULE$.apply(position, string, throwable);
    }

    public static Function1<Tuple3<Position, String, Throwable>, UnexpectedReificationException> tupled() {
        return UnexpectedReificationException$.MODULE$.tupled();
    }

    public static Function1<Position, Function1<String, Function1<Throwable, UnexpectedReificationException>>> curried() {
        return UnexpectedReificationException$.MODULE$.curried();
    }

    public Position pos() {
        return this.pos;
    }

    public String msg() {
        return this.msg;
    }

    public Throwable cause() {
        return this.cause;
    }

    public UnexpectedReificationException copy(Position pos, String msg, Throwable cause) {
        return new UnexpectedReificationException(pos, msg, cause);
    }

    public Position copy$default$1() {
        return this.pos();
    }

    public String copy$default$2() {
        return this.msg();
    }

    public Throwable copy$default$3() {
        return this.cause();
    }

    @Override
    public String productPrefix() {
        return "UnexpectedReificationException";
    }

    @Override
    public int productArity() {
        return 3;
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
            case 2: {
                return this.cause();
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
        return x$1 instanceof UnexpectedReificationException;
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
        if (!(x$1 instanceof UnexpectedReificationException)) return false;
        boolean bl = true;
        if (!bl) return false;
        UnexpectedReificationException unexpectedReificationException = (UnexpectedReificationException)x$1;
        Position position = this.pos();
        Position position2 = unexpectedReificationException.pos();
        if (position == null) {
            if (position2 != null) {
                return false;
            }
        } else if (!position.equals(position2)) return false;
        String string = this.msg();
        String string2 = unexpectedReificationException.msg();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        Throwable throwable = this.cause();
        Throwable throwable2 = unexpectedReificationException.cause();
        if (throwable == null) {
            if (throwable2 != null) {
                return false;
            }
        } else if (!throwable.equals(throwable2)) return false;
        if (!unexpectedReificationException.canEqual(this)) return false;
        return true;
    }

    public UnexpectedReificationException(Position pos, String msg, Throwable cause) {
        this.pos = pos;
        this.msg = msg;
        this.cause = cause;
        super(msg, cause);
        Product.$init$(this);
    }
}

