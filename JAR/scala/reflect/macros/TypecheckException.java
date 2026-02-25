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
import scala.reflect.macros.TypecheckException$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005-c\u0001B\f\u0019\u0001~A\u0001B\f\u0001\u0003\u0016\u0004%\ta\f\u0005\tm\u0001\u0011\t\u0012)A\u0005a!Aq\u0007\u0001BK\u0002\u0013\u0005\u0001\b\u0003\u0005E\u0001\tE\t\u0015!\u0003:\u0011\u0015)\u0005\u0001\"\u0001G\u0011\u001dY\u0005!!A\u0005\u00021Cqa\u0014\u0001\u0012\u0002\u0013\u0005\u0001\u000bC\u0004\\\u0001E\u0005I\u0011\u0001/\t\u000fy\u0003\u0011\u0011!C!?\"9q\rAA\u0001\n\u0003A\u0007b\u00027\u0001\u0003\u0003%\t!\u001c\u0005\bg\u0002\t\t\u0011\"\u0011u\u0011\u001dY\b!!A\u0005\u0002qD\u0011\"a\u0001\u0001\u0003\u0003%\t%!\u0002\t\u0013\u0005\u001d\u0001!!A\u0005B\u0005%q!CA\u00071\u0005\u0005\t\u0012AA\b\r!9\u0002$!A\t\u0002\u0005E\u0001BB#\u0012\t\u0003\ty\u0002C\u0005\u0002\"E\t\t\u0011\"\u0012\u0002$!I\u0011QE\t\u0002\u0002\u0013\u0005\u0015q\u0005\u0005\n\u0003[\t\u0012\u0011!CA\u0003_A\u0011\"!\u0011\u0012\u0003\u0003%I!a\u0011\u0003%QK\b/Z2iK\u000e\\W\t_2faRLwN\u001c\u0006\u00033i\ta!\\1de>\u001c(BA\u000e\u001d\u0003\u001d\u0011XM\u001a7fGRT\u0011!H\u0001\u0006g\u000e\fG.Y\u0002\u0001'\u0011\u0001\u0001\u0005K\u0016\u0011\u0005\u0005*cB\u0001\u0012$\u001b\u0005a\u0012B\u0001\u0013\u001d\u0003\u001d\u0001\u0018mY6bO\u0016L!AJ\u0014\u0003\u0013\u0015C8-\u001a9uS>t'B\u0001\u0013\u001d!\t\u0011\u0013&\u0003\u0002+9\t9\u0001K]8ek\u000e$\bC\u0001\u0012-\u0013\tiCD\u0001\u0007TKJL\u0017\r\\5{C\ndW-A\u0002q_N,\u0012\u0001\r\t\u0003cQj\u0011A\r\u0006\u0003gi\t1!\u00199j\u0013\t)$G\u0001\u0005Q_NLG/[8o\u0003\u0011\u0001xn\u001d\u0011\u0002\u00075\u001cx-F\u0001:!\tQ\u0014I\u0004\u0002<\u007fA\u0011A\bH\u0007\u0002{)\u0011aHH\u0001\u0007yI|w\u000e\u001e \n\u0005\u0001c\u0012A\u0002)sK\u0012,g-\u0003\u0002C\u0007\n11\u000b\u001e:j]\u001eT!\u0001\u0011\u000f\u0002\t5\u001cx\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007\u001dK%\n\u0005\u0002I\u00015\t\u0001\u0004C\u0003/\u000b\u0001\u0007\u0001\u0007C\u00038\u000b\u0001\u0007\u0011(\u0001\u0003d_BLHcA$N\u001d\"9aF\u0002I\u0001\u0002\u0004\u0001\u0004bB\u001c\u0007!\u0003\u0005\r!O\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0005\t&F\u0001\u0019SW\u0005\u0019\u0006C\u0001+Z\u001b\u0005)&B\u0001,X\u0003%)hn\u00195fG.,GM\u0003\u0002Y9\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005i+&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012T#A/+\u0005e\u0012\u0016!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001a!\t\tg-D\u0001c\u0015\t\u0019G-\u0001\u0003mC:<'\"A3\u0002\t)\fg/Y\u0005\u0003\u0005\n\fA\u0002\u001d:pIV\u001cG/\u0011:jif,\u0012!\u001b\t\u0003E)L!a\u001b\u000f\u0003\u0007%sG/\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\u00059\f\bC\u0001\u0012p\u0013\t\u0001HDA\u0002B]fDqA]\u0006\u0002\u0002\u0003\u0007\u0011.A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0002kB\u0019a/\u001f8\u000e\u0003]T!\u0001\u001f\u000f\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0002{o\nA\u0011\n^3sCR|'/\u0001\u0005dC:,\u0015/^1m)\ri\u0018\u0011\u0001\t\u0003EyL!a \u000f\u0003\u000f\t{w\u000e\\3b]\"9!/DA\u0001\u0002\u0004q\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003%\fa!Z9vC2\u001cHcA?\u0002\f!9!oDA\u0001\u0002\u0004q\u0017A\u0005+za\u0016\u001c\u0007.Z2l\u000bb\u001cW\r\u001d;j_:\u0004\"\u0001S\t\u0014\tE\t\u0019b\u000b\t\b\u0003+\tY\u0002M\u001dH\u001b\t\t9BC\u0002\u0002\u001aq\tqA];oi&lW-\u0003\u0003\u0002\u001e\u0005]!!E!cgR\u0014\u0018m\u0019;Gk:\u001cG/[8oeQ\u0011\u0011qB\u0001\ti>\u001cFO]5oOR\t\u0001-A\u0003baBd\u0017\u0010F\u0003H\u0003S\tY\u0003C\u0003/)\u0001\u0007\u0001\u0007C\u00038)\u0001\u0007\u0011(A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\u0005E\u0012Q\b\t\u0006E\u0005M\u0012qG\u0005\u0004\u0003ka\"AB(qi&|g\u000eE\u0003#\u0003s\u0001\u0014(C\u0002\u0002<q\u0011a\u0001V;qY\u0016\u0014\u0004\u0002CA +\u0005\u0005\t\u0019A$\u0002\u0007a$\u0003'A\u0006sK\u0006$'+Z:pYZ,GCAA#!\r\t\u0017qI\u0005\u0004\u0003\u0013\u0012'AB(cU\u0016\u001cG\u000f")
public class TypecheckException
extends Exception
implements Product,
Serializable {
    private final Position pos;
    private final String msg;

    public static Option<Tuple2<Position, String>> unapply(TypecheckException typecheckException) {
        return TypecheckException$.MODULE$.unapply(typecheckException);
    }

    public static TypecheckException apply(Position position, String string) {
        return TypecheckException$.MODULE$.apply(position, string);
    }

    public static Function1<Tuple2<Position, String>, TypecheckException> tupled() {
        return TypecheckException$.MODULE$.tupled();
    }

    public static Function1<Position, Function1<String, TypecheckException>> curried() {
        return TypecheckException$.MODULE$.curried();
    }

    public Position pos() {
        return this.pos;
    }

    public String msg() {
        return this.msg;
    }

    public TypecheckException copy(Position pos, String msg) {
        return new TypecheckException(pos, msg);
    }

    public Position copy$default$1() {
        return this.pos();
    }

    public String copy$default$2() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "TypecheckException";
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
        return x$1 instanceof TypecheckException;
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
        if (!(x$1 instanceof TypecheckException)) return false;
        boolean bl = true;
        if (!bl) return false;
        TypecheckException typecheckException = (TypecheckException)x$1;
        Position position = this.pos();
        Position position2 = typecheckException.pos();
        if (position == null) {
            if (position2 != null) {
                return false;
            }
        } else if (!position.equals(position2)) return false;
        String string = this.msg();
        String string2 = typecheckException.msg();
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else if (!string.equals(string2)) return false;
        if (!typecheckException.canEqual(this)) return false;
        return true;
    }

    public TypecheckException(Position pos, String msg) {
        this.pos = pos;
        this.msg = msg;
        super(msg);
        Product.$init$(this);
    }
}

