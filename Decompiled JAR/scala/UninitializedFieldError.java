/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.UninitializedFieldError$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005}a\u0001B\u000b\u0017\u0005fA\u0001\u0002\u000b\u0001\u0003\u0016\u0004%\t!\u000b\u0005\tk\u0001\u0011\t\u0012)A\u0005U!)a\u0007\u0001C\u0001o!)a\u0007\u0001C\u0001u!9\u0001\tAA\u0001\n\u0003\t\u0005bB\"\u0001#\u0003%\t\u0001\u0012\u0005\b\u001f\u0002\t\t\u0011\"\u0011Q\u0011\u001dA\u0006!!A\u0005\u0002eCq!\u0018\u0001\u0002\u0002\u0013\u0005a\fC\u0004b\u0001\u0005\u0005I\u0011\t2\t\u000f%\u0004\u0011\u0011!C\u0001U\"9q\u000eAA\u0001\n\u0003\u0002\bbB9\u0001\u0003\u0003%\tE]\u0004\biZ\t\t\u0011#\u0001v\r\u001d)b#!A\t\u0002YDQAN\b\u0005\u0002uDqA`\b\u0002\u0002\u0013\u0015s\u0010C\u0005\u0002\u0002=\t\t\u0011\"!\u0002\u0004!I\u0011qA\b\u0002\u0002\u0013\u0005\u0015\u0011\u0002\u0005\n\u0003+y\u0011\u0011!C\u0005\u0003/\u0011q#\u00168j]&$\u0018.\u00197ju\u0016$g)[3mI\u0016\u0013(o\u001c:\u000b\u0003]\tQa]2bY\u0006\u001c\u0001a\u0005\u0003\u00015\t*\u0003CA\u000e \u001d\taR$D\u0001\u0017\u0013\tqb#A\u0004qC\u000e\\\u0017mZ3\n\u0005\u0001\n#\u0001\u0005*v]RLW.Z#yG\u0016\u0004H/[8o\u0015\tqb\u0003\u0005\u0002\u001dG%\u0011AE\u0006\u0002\b!J|G-^2u!\tab%\u0003\u0002(-\ta1+\u001a:jC2L'0\u00192mK\u0006\u0019Qn]4\u0016\u0003)\u0002\"a\u000b\u001a\u000f\u00051\u0002\u0004CA\u0017\u0017\u001b\u0005q#BA\u0018\u0019\u0003\u0019a$o\\8u}%\u0011\u0011GF\u0001\u0007!J,G-\u001a4\n\u0005M\"$AB*ue&twM\u0003\u00022-\u0005!Qn]4!\u0003\u0019a\u0014N\\5u}Q\u0011\u0001(\u000f\t\u00039\u0001AQ\u0001K\u0002A\u0002)\"\"\u0001O\u001e\t\u000bq\"\u0001\u0019A\u001f\u0002\u0007=\u0014'\u000e\u0005\u0002\u001d}%\u0011qH\u0006\u0002\u0004\u0003:L\u0018\u0001B2paf$\"\u0001\u000f\"\t\u000f!*\u0001\u0013!a\u0001U\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#A#+\u0005)25&A$\u0011\u0005!kU\"A%\u000b\u0005)[\u0015!C;oG\",7m[3e\u0015\tae#\u0001\u0006b]:|G/\u0019;j_:L!AT%\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0002#B\u0011!kV\u0007\u0002'*\u0011A+V\u0001\u0005Y\u0006twMC\u0001W\u0003\u0011Q\u0017M^1\n\u0005M\u001a\u0016\u0001\u00049s_\u0012,8\r^!sSRLX#\u0001.\u0011\u0005qY\u0016B\u0001/\u0017\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\tit\fC\u0004a\u0013\u0005\u0005\t\u0019\u0001.\u0002\u0007a$\u0013'A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\u0005\u0019\u0007c\u00013h{5\tQM\u0003\u0002g-\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005!,'\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$\"a\u001b8\u0011\u0005qa\u0017BA7\u0017\u0005\u001d\u0011un\u001c7fC:Dq\u0001Y\u0006\u0002\u0002\u0003\u0007Q(\u0001\u0005iCND7i\u001c3f)\u0005Q\u0016AB3rk\u0006d7\u000f\u0006\u0002lg\"9\u0001-DA\u0001\u0002\u0004i\u0014aF+oS:LG/[1mSj,GMR5fY\u0012,%O]8s!\tarbE\u0002\u0010o\u0016\u0002B\u0001_>+q5\t\u0011P\u0003\u0002{-\u00059!/\u001e8uS6,\u0017B\u0001?z\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|g.\r\u000b\u0002k\u0006AAo\\*ue&tw\rF\u0001R\u0003\u0015\t\u0007\u000f\u001d7z)\rA\u0014Q\u0001\u0005\u0006QI\u0001\rAK\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\tY!!\u0005\u0011\tq\tiAK\u0005\u0004\u0003\u001f1\"AB(qi&|g\u000e\u0003\u0005\u0002\u0014M\t\t\u00111\u00019\u0003\rAH\u0005M\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002\u001aA\u0019!+a\u0007\n\u0007\u0005u1K\u0001\u0004PE*,7\r\u001e")
public final class UninitializedFieldError
extends RuntimeException
implements Product,
Serializable {
    private final String msg;

    public static Option<String> unapply(UninitializedFieldError uninitializedFieldError) {
        return UninitializedFieldError$.MODULE$.unapply(uninitializedFieldError);
    }

    public static UninitializedFieldError apply(String string) {
        return UninitializedFieldError$.MODULE$.apply(string);
    }

    public static <A> Function1<String, A> andThen(Function1<UninitializedFieldError, A> function1) {
        UninitializedFieldError$ uninitializedFieldError$ = UninitializedFieldError$.MODULE$;
        if (uninitializedFieldError$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(uninitializedFieldError$, function1, arg_0);
    }

    public static <A> Function1<A, UninitializedFieldError> compose(Function1<A, String> function1) {
        UninitializedFieldError$ uninitializedFieldError$ = UninitializedFieldError$.MODULE$;
        if (uninitializedFieldError$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(uninitializedFieldError$, function1, arg_0);
    }

    public String msg() {
        return this.msg;
    }

    public UninitializedFieldError copy(String msg) {
        return new UninitializedFieldError(msg);
    }

    public String copy$default$1() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "UninitializedFieldError";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.msg();
            }
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof UninitializedFieldError;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof UninitializedFieldError;
                if (!bl) break block3;
                UninitializedFieldError uninitializedFieldError = (UninitializedFieldError)x$1;
                String string = this.msg();
                String string2 = uninitializedFieldError.msg();
                if (!(!(string != null ? !string.equals(string2) : string2 != null))) break block3;
            }
            return true;
        }
        return false;
    }

    public UninitializedFieldError(String msg) {
        this.msg = msg;
        super(msg);
        Product.$init$(this);
    }

    public UninitializedFieldError(Object obj) {
        this(String.valueOf(obj));
    }
}

