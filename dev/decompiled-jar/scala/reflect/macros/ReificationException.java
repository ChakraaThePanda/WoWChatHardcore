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
import scala.reflect.macros.ReificationException$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005-c\u0001B\f\u0019\u0001~A\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\tm\u0001\u0011\t\u0012)A\u0005a!Aq\u0007\u0001BK\u0002\u0013\u0005\u0001\b\u0003\u0005E\u0001\tE\t\u0015!\u0003:\u0011\u0015)\u0005\u0001\"\u0001G\u0011\u001dY\u0005!!A\u0005\u00021Cqa\u0014\u0001\u0012\u0002\u0013\u0005\u0001\u000bC\u0004\\\u0001E\u0005I\u0011\u0001/\t\u000fy\u0003\u0011\u0011!C!?\"9q\rAA\u0001\n\u0003A\u0007b\u00027\u0001\u0003\u0003%\t!\u001c\u0005\bg\u0002\t\t\u0011\"\u0011u\u0011\u001dY\b!!A\u0005\u0002qD\u0011\"a\u0001\u0001\u0003\u0003%\t%!\u0002\t\u0013\u0005\u001d\u0001!!A\u0005B\u0005%q!CA\u00071\u0005\u0005\t\u0012AA\b\r!9\u0002$!A\t\u0002\u0005E\u0001BB#\u0012\t\u0003\ty\u0002C\u0005\u0002\"E\t\t\u0011\"\u0012\u0002$!I\u0011QE\t\u0002\u0002\u0013\u0005\u0015q\u0005\u0005\n\u0003[\t\u0012\u0011!CA\u0003_A\u0011\"!\u0011\u0012\u0003\u0003%I!a\u0011\u0003)I+\u0017NZ5dCRLwN\\#yG\u0016\u0004H/[8o\u0015\tI\"$\u0001\u0004nC\u000e\u0014xn\u001d\u0006\u00037q\tqA]3gY\u0016\u001cGOC\u0001\u001e\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019B\u0001\u0001\u0011)WA\u0011\u0011%\n\b\u0003E\rj\u0011\u0001H\u0005\u0003Iq\tq\u0001]1dW\u0006<W-\u0003\u0002'O\tIQ\t_2faRLwN\u001c\u0006\u0003Iq\u0001\"AI\u0015\n\u0005)b\"a\u0002)s_\u0012,8\r\u001e\t\u0003E1J!!\f\u000f\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u0007A|7/F\u00011!\t\tD'D\u00013\u0015\t\u0019$$A\u0002ba&L!!\u000e\u001a\u0003\u0011A{7/\u001b;j_:\fA\u0001]8tA\u0005\u0019Qn]4\u0016\u0003e\u0002\"AO!\u000f\u0005mz\u0004C\u0001\u001f\u001d\u001b\u0005i$B\u0001 \u001f\u0003\u0019a$o\\8u}%\u0011\u0001\tH\u0001\u0007!J,G-\u001a4\n\u0005\t\u001b%AB*ue&twM\u0003\u0002A9\u0005!Qn]4!\u0003\u0019a\u0014N\\5u}Q\u0019q)\u0013&\u0011\u0005!\u0003Q\"\u0001\r\t\u000b9*\u0001\u0019\u0001\u0019\t\u000b]*\u0001\u0019A\u001d\u0002\t\r|\u0007/\u001f\u000b\u0004\u000f6s\u0005b\u0002\u0018\u0007!\u0003\u0005\r\u0001\r\u0005\bo\u0019\u0001\n\u00111\u0001:\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\u0012!\u0015\u0016\u0003aI[\u0013a\u0015\t\u0003)fk\u0011!\u0016\u0006\u0003-^\u000b\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005ac\u0012AC1o]>$\u0018\r^5p]&\u0011!,\u0016\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017AD2paf$C-\u001a4bk2$HEM\u000b\u0002;*\u0012\u0011HU\u0001\u000eaJ|G-^2u!J,g-\u001b=\u0016\u0003\u0001\u0004\"!\u00194\u000e\u0003\tT!a\u00193\u0002\t1\fgn\u001a\u0006\u0002K\u0006!!.\u0019<b\u0013\t\u0011%-\u0001\u0007qe>$Wo\u0019;Be&$\u00180F\u0001j!\t\u0011#.\u0003\u0002l9\t\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u0011a.\u001d\t\u0003E=L!\u0001\u001d\u000f\u0003\u0007\u0005s\u0017\u0010C\u0004s\u0017\u0005\u0005\t\u0019A5\u0002\u0007a$\u0013'A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\u0005)\bc\u0001<z]6\tqO\u0003\u0002y9\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005i<(\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$2!`A\u0001!\t\u0011c0\u0003\u0002\u00009\t9!i\\8mK\u0006t\u0007b\u0002:\u000e\u0003\u0003\u0005\rA\\\u0001\tQ\u0006\u001c\bnQ8eKR\t\u0011.\u0001\u0004fcV\fGn\u001d\u000b\u0004{\u0006-\u0001b\u0002:\u0010\u0003\u0003\u0005\rA\\\u0001\u0015%\u0016Lg-[2bi&|g.\u0012=dKB$\u0018n\u001c8\u0011\u0005!\u000b2\u0003B\t\u0002\u0014-\u0002r!!\u0006\u0002\u001cAJt)\u0004\u0002\u0002\u0018)\u0019\u0011\u0011\u0004\u000f\u0002\u000fI,h\u000e^5nK&!\u0011QDA\f\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gN\r\u000b\u0003\u0003\u001f\t\u0001\u0002^8TiJLgn\u001a\u000b\u0002A\u0006)\u0011\r\u001d9msR)q)!\u000b\u0002,!)a\u0006\u0006a\u0001a!)q\u0007\u0006a\u0001s\u00059QO\\1qa2LH\u0003BA\u0019\u0003{\u0001RAIA\u001a\u0003oI1!!\u000e\u001d\u0005\u0019y\u0005\u000f^5p]B)!%!\u000f1s%\u0019\u00111\b\u000f\u0003\rQ+\b\u000f\\33\u0011!\ty$FA\u0001\u0002\u00049\u0015a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t)\u0005E\u0002b\u0003\u000fJ1!!\u0013c\u0005\u0019y%M[3di\u0002")
public class ReificationException
extends Exception
implements Product,
Serializable {
    private final Position pos;
    private final String msg;

    public static Option<Tuple2<Position, String>> unapply(ReificationException reificationException) {
        return ReificationException$.MODULE$.unapply(reificationException);
    }

    public static ReificationException apply(Position position, String string) {
        return ReificationException$.MODULE$.apply(position, string);
    }

    public static Function1<Tuple2<Position, String>, ReificationException> tupled() {
        return ReificationException$.MODULE$.tupled();
    }

    public static Function1<Position, Function1<String, ReificationException>> curried() {
        return ReificationException$.MODULE$.curried();
    }

    public Position pos() {
        return this.pos;
    }

    public String msg() {
        return this.msg;
    }

    public ReificationException copy(Position pos, String msg) {
        return new ReificationException(pos, msg);
    }

    public Position copy$default$1() {
        return this.pos();
    }

    public String copy$default$2() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "ReificationException";
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
        return x$1 instanceof ReificationException;
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
        if (!(x$1 instanceof ReificationException)) return false;
        boolean bl = true;
        if (!bl) return false;
        ReificationException reificationException = (ReificationException)x$1;
        Position position = this.pos();
        Position position2 = reificationException.pos();
        if (position == null) {
            if (position2 != null) {
                return false;
            }
        } else if (!position.equals(position2)) return false;
        String string = this.msg();
        String string2 = reificationException.msg();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (!reificationException.canEqual(this)) return false;
        return true;
    }

    public ReificationException(Position pos, String msg) {
        this.pos = pos;
        this.msg = msg;
        super(msg);
        Product.$init$(this);
    }
}

