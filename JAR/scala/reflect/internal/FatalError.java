/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.FatalError$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005b\u0001\u0002\u000b\u0016\u0001rA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\tq\u0001\u0011\t\u0012)A\u0005[!)\u0011\b\u0001C\u0001u!9a\bAA\u0001\n\u0003y\u0004bB!\u0001#\u0003%\tA\u0011\u0005\b\u001b\u0002\t\t\u0011\"\u0011O\u0011\u001d1\u0006!!A\u0005\u0002]Cqa\u0017\u0001\u0002\u0002\u0013\u0005A\fC\u0004c\u0001\u0005\u0005I\u0011I2\t\u000f)\u0004\u0011\u0011!C\u0001W\"9\u0001\u000fAA\u0001\n\u0003\n\bb\u0002:\u0001\u0003\u0003%\te]\u0004\bkV\t\t\u0011#\u0001w\r\u001d!R#!A\t\u0002]DQ!\u000f\b\u0005\u0002yD\u0001b \b\u0002\u0002\u0013\u0015\u0013\u0011\u0001\u0005\n\u0003\u0007q\u0011\u0011!CA\u0003\u000bA\u0011\"!\u0003\u000f\u0003\u0003%\t)a\u0003\t\u0013\u0005]a\"!A\u0005\n\u0005e!A\u0003$bi\u0006dWI\u001d:pe*\u0011acF\u0001\tS:$XM\u001d8bY*\u0011\u0001$G\u0001\be\u00164G.Z2u\u0015\u0005Q\u0012!B:dC2\f7\u0001A\n\u0005\u0001u)\u0003\u0006\u0005\u0002\u001fE9\u0011q\u0004I\u0007\u00023%\u0011\u0011%G\u0001\ba\u0006\u001c7.Y4f\u0013\t\u0019CEA\u0005Fq\u000e,\u0007\u000f^5p]*\u0011\u0011%\u0007\t\u0003?\u0019J!aJ\r\u0003\u000fA\u0013x\u000eZ;diB\u0011q$K\u0005\u0003Ue\u0011AbU3sS\u0006d\u0017N_1cY\u0016\f1!\\:h+\u0005i\u0003C\u0001\u00186\u001d\ty3\u0007\u0005\u0002135\t\u0011G\u0003\u000237\u00051AH]8pizJ!\u0001N\r\u0002\rA\u0013X\rZ3g\u0013\t1tG\u0001\u0004TiJLgn\u001a\u0006\u0003ie\tA!\\:hA\u00051A(\u001b8jiz\"\"aO\u001f\u0011\u0005q\u0002Q\"A\u000b\t\u000b-\u001a\u0001\u0019A\u0017\u0002\t\r|\u0007/\u001f\u000b\u0003w\u0001Cqa\u000b\u0003\u0011\u0002\u0003\u0007Q&\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0003\rS#!\f#,\u0003\u0015\u0003\"AR&\u000e\u0003\u001dS!\u0001S%\u0002\u0013Ut7\r[3dW\u0016$'B\u0001&\u001a\u0003)\tgN\\8uCRLwN\\\u0005\u0003\u0019\u001e\u0013\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\tq\n\u0005\u0002Q+6\t\u0011K\u0003\u0002S'\u0006!A.\u00198h\u0015\u0005!\u0016\u0001\u00026bm\u0006L!AN)\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0003a\u0003\"aH-\n\u0005iK\"aA%oi\u0006q\u0001O]8ek\u000e$X\t\\3nK:$HCA/a!\tyb,\u0003\u0002`3\t\u0019\u0011I\\=\t\u000f\u0005D\u0011\u0011!a\u00011\u0006\u0019\u0001\u0010J\u0019\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\u0012\u0001\u001a\t\u0004K\"lV\"\u00014\u000b\u0005\u001dL\u0012AC2pY2,7\r^5p]&\u0011\u0011N\u001a\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0002m_B\u0011q$\\\u0005\u0003]f\u0011qAQ8pY\u0016\fg\u000eC\u0004b\u0015\u0005\u0005\t\u0019A/\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012\u0001W\u0001\u0007KF,\u0018\r\\:\u0015\u00051$\bbB1\r\u0003\u0003\u0005\r!X\u0001\u000b\r\u0006$\u0018\r\\#se>\u0014\bC\u0001\u001f\u000f'\rq\u0001\u0010\u000b\t\u0005srl3(D\u0001{\u0015\tY\u0018$A\u0004sk:$\u0018.\\3\n\u0005uT(!E!cgR\u0014\u0018m\u0019;Gk:\u001cG/[8ocQ\ta/\u0001\u0005u_N#(/\u001b8h)\u0005y\u0015!B1qa2LHcA\u001e\u0002\b!)1&\u0005a\u0001[\u00059QO\\1qa2LH\u0003BA\u0007\u0003'\u0001BaHA\b[%\u0019\u0011\u0011C\r\u0003\r=\u0003H/[8o\u0011!\t)BEA\u0001\u0002\u0004Y\u0014a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\tY\u0002E\u0002Q\u0003;I1!a\bR\u0005\u0019y%M[3di\u0002")
public class FatalError
extends Exception
implements Product,
Serializable {
    private final String msg;

    public static Option<String> unapply(FatalError fatalError) {
        return FatalError$.MODULE$.unapply(fatalError);
    }

    public static FatalError apply(String string) {
        return FatalError$.MODULE$.apply(string);
    }

    public static <A> Function1<String, A> andThen(Function1<FatalError, A> function1) {
        FatalError$ fatalError$ = FatalError$.MODULE$;
        if (fatalError$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(fatalError$, function1, arg_0);
    }

    public static <A> Function1<A, FatalError> compose(Function1<A, String> function1) {
        FatalError$ fatalError$ = FatalError$.MODULE$;
        if (fatalError$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(fatalError$, function1, arg_0);
    }

    public String msg() {
        return this.msg;
    }

    public FatalError copy(String msg) {
        return new FatalError(msg);
    }

    public String copy$default$1() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "FatalError";
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
        throw new IndexOutOfBoundsException(Integer.toString(x$1));
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof FatalError;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof FatalError;
                if (!bl) break block3;
                FatalError fatalError = (FatalError)x$1;
                String string = this.msg();
                String string2 = fatalError.msg();
                if (!(!(string != null ? !string.equals(string2) : string2 != null) && fatalError.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public FatalError(String msg) {
        this.msg = msg;
        super(msg);
        Product.$init$(this);
    }
}

