/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.ScalaReflectionException$;
import scala.Serializable;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005]a\u0001\u0002\u000b\u0016\u0001bA\u0001b\n\u0001\u0003\u0016\u0004%\t\u0001\u000b\u0005\ti\u0001\u0011\t\u0012)A\u0005S!)Q\u0007\u0001C\u0001m!9\u0011\bAA\u0001\n\u0003Q\u0004b\u0002\u001f\u0001#\u0003%\t!\u0010\u0005\b\u0011\u0002\t\t\u0011\"\u0011J\u0011\u001d\t\u0006!!A\u0005\u0002ICqA\u0016\u0001\u0002\u0002\u0013\u0005q\u000bC\u0004^\u0001\u0005\u0005I\u0011\t0\t\u000f\u0015\u0004\u0011\u0011!C\u0001M\"91\u000eAA\u0001\n\u0003b\u0007bB7\u0001\u0003\u0003%\tE\\\u0004\baV\t\t\u0011#\u0001r\r\u001d!R#!A\t\u0002IDQ!\u000e\b\u0005\u0002eDqA\u001f\b\u0002\u0002\u0013\u00153\u0010C\u0004}\u001d\u0005\u0005I\u0011Q?\t\u0011}t\u0011\u0011!CA\u0003\u0003A\u0011\"!\u0004\u000f\u0003\u0003%I!a\u0004\u00031M\u001b\u0017\r\\1SK\u001adWm\u0019;j_:,\u0005pY3qi&|gNC\u0001\u0017\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019B\u0001A\r\"IA\u0011!D\b\b\u00037qi\u0011!F\u0005\u0003;U\tq\u0001]1dW\u0006<W-\u0003\u0002 A\tIQ\t_2faRLwN\u001c\u0006\u0003;U\u0001\"a\u0007\u0012\n\u0005\r*\"a\u0002)s_\u0012,8\r\u001e\t\u00037\u0015J!AJ\u000b\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u00075\u001cx-F\u0001*!\tQ\u0013G\u0004\u0002,_A\u0011A&F\u0007\u0002[)\u0011afF\u0001\u0007yI|w\u000e\u001e \n\u0005A*\u0012A\u0002)sK\u0012,g-\u0003\u00023g\t11\u000b\u001e:j]\u001eT!\u0001M\u000b\u0002\t5\u001cx\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005]B\u0004CA\u000e\u0001\u0011\u001593\u00011\u0001*\u0003\u0011\u0019w\u000e]=\u0015\u0005]Z\u0004bB\u0014\u0005!\u0003\u0005\r!K\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0005q$FA\u0015@W\u0005\u0001\u0005CA!G\u001b\u0005\u0011%BA\"E\u0003%)hn\u00195fG.,GM\u0003\u0002F+\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005\u001d\u0013%!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006i\u0001O]8ek\u000e$\bK]3gSb,\u0012A\u0013\t\u0003\u0017Bk\u0011\u0001\u0014\u0006\u0003\u001b:\u000bA\u0001\\1oO*\tq*\u0001\u0003kCZ\f\u0017B\u0001\u001aM\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\u0005\u0019\u0006CA\u000eU\u0013\t)VCA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0002Y7B\u00111$W\u0005\u00035V\u00111!\u00118z\u0011\u001da\u0006\"!AA\u0002M\u000b1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014X#A0\u0011\u0007\u0001\u001c\u0007,D\u0001b\u0015\t\u0011W#\u0001\u0006d_2dWm\u0019;j_:L!\u0001Z1\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0003O*\u0004\"a\u00075\n\u0005%,\"a\u0002\"p_2,\u0017M\u001c\u0005\b9*\t\t\u00111\u0001Y\u0003!A\u0017m\u001d5D_\u0012,G#A*\u0002\r\u0015\fX/\u00197t)\t9w\u000eC\u0004]\u0019\u0005\u0005\t\u0019\u0001-\u00021M\u001b\u0017\r\\1SK\u001adWm\u0019;j_:,\u0005pY3qi&|g\u000e\u0005\u0002\u001c\u001dM\u0019ab\u001d\u0013\u0011\tQ<\u0018fN\u0007\u0002k*\u0011a/F\u0001\beVtG/[7f\u0013\tAXOA\tBEN$(/Y2u\rVt7\r^5p]F\"\u0012!]\u0001\ti>\u001cFO]5oOR\t!*A\u0003baBd\u0017\u0010\u0006\u00028}\")q%\u0005a\u0001S\u00059QO\\1qa2LH\u0003BA\u0002\u0003\u0013\u0001BaGA\u0003S%\u0019\u0011qA\u000b\u0003\r=\u0003H/[8o\u0011!\tYAEA\u0001\u0002\u00049\u0014a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t\t\u0002E\u0002L\u0003'I1!!\u0006M\u0005\u0019y%M[3di\u0002")
public class ScalaReflectionException
extends Exception
implements Product,
Serializable {
    private final String msg;

    public static Option<String> unapply(ScalaReflectionException scalaReflectionException) {
        return ScalaReflectionException$.MODULE$.unapply(scalaReflectionException);
    }

    public static ScalaReflectionException apply(String string) {
        return ScalaReflectionException$.MODULE$.apply(string);
    }

    public static <A> Function1<String, A> andThen(Function1<ScalaReflectionException, A> function1) {
        ScalaReflectionException$ scalaReflectionException$ = ScalaReflectionException$.MODULE$;
        if (scalaReflectionException$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(scalaReflectionException$, function1, arg_0);
    }

    public static <A> Function1<A, ScalaReflectionException> compose(Function1<A, String> function1) {
        ScalaReflectionException$ scalaReflectionException$ = ScalaReflectionException$.MODULE$;
        if (scalaReflectionException$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(scalaReflectionException$, function1, arg_0);
    }

    public String msg() {
        return this.msg;
    }

    public ScalaReflectionException copy(String msg) {
        return new ScalaReflectionException(msg);
    }

    public String copy$default$1() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "ScalaReflectionException";
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
        return x$1 instanceof ScalaReflectionException;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof ScalaReflectionException;
                if (!bl) break block3;
                ScalaReflectionException scalaReflectionException = (ScalaReflectionException)x$1;
                String string = this.msg();
                String string2 = scalaReflectionException.msg();
                if (!(!(string != null ? !string.equals(string2) : string2 != null) && scalaReflectionException.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public ScalaReflectionException(String msg) {
        this.msg = msg;
        super(msg);
        Product.$init$(this);
    }
}

