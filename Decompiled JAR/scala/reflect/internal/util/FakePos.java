/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.FakePos$;
import scala.reflect.internal.util.UndefinedPosition;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005b\u0001B\u000b\u0017\u0001~A\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\tq\u0001\u0011\t\u0012)A\u0005[!)\u0011\b\u0001C\u0001u!)Q\b\u0001C!}!9q\bAA\u0001\n\u0003\u0001\u0005b\u0002\"\u0001#\u0003%\ta\u0011\u0005\b\u001d\u0002\t\t\u0011\"\u0011P\u0011\u001d9\u0006!!A\u0005\u0002aCq\u0001\u0018\u0001\u0002\u0002\u0013\u0005Q\fC\u0004d\u0001\u0005\u0005I\u0011\t3\t\u000f-\u0004\u0011\u0011!C\u0001Y\"9\u0011\u000fAA\u0001\n\u0003\u0012\bbB:\u0001\u0003\u0003%\t\u0005^\u0004\bmZ\t\t\u0011#\u0001x\r\u001d)b#!A\t\u0002aDQ!O\b\u0005\u0002}D\u0001\"P\b\u0002\u0002\u0013\u0015\u0013\u0011\u0001\u0005\n\u0003\u0007y\u0011\u0011!CA\u0003\u000bA\u0011\"!\u0003\u0010\u0003\u0003%\t)a\u0003\t\u0013\u0005]q\"!A\u0005\n\u0005e!a\u0002$bW\u0016\u0004vn\u001d\u0006\u0003/a\tA!\u001e;jY*\u0011\u0011DG\u0001\tS:$XM\u001d8bY*\u00111\u0004H\u0001\be\u00164G.Z2u\u0015\u0005i\u0012!B:dC2\f7\u0001A\n\u0005\u0001\u0001\"\u0003\u0006\u0005\u0002\"E5\ta#\u0003\u0002$-\t\tRK\u001c3fM&tW\r\u001a)pg&$\u0018n\u001c8\u0011\u0005\u00152S\"\u0001\u000f\n\u0005\u001db\"a\u0002)s_\u0012,8\r\u001e\t\u0003K%J!A\u000b\u000f\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u00075\u001cx-F\u0001.!\tqSG\u0004\u00020gA\u0011\u0001\u0007H\u0007\u0002c)\u0011!GH\u0001\u0007yI|w\u000e\u001e \n\u0005Qb\u0012A\u0002)sK\u0012,g-\u0003\u00027o\t11\u000b\u001e:j]\u001eT!\u0001\u000e\u000f\u0002\t5\u001cx\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005mb\u0004CA\u0011\u0001\u0011\u0015Y3\u00011\u0001.\u0003!!xn\u0015;sS:<G#A\u0017\u0002\t\r|\u0007/\u001f\u000b\u0003w\u0005CqaK\u0003\u0011\u0002\u0003\u0007Q&\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0003\u0011S#!L#,\u0003\u0019\u0003\"a\u0012'\u000e\u0003!S!!\u0013&\u0002\u0013Ut7\r[3dW\u0016$'BA&\u001d\u0003)\tgN\\8uCRLwN\\\u0005\u0003\u001b\"\u0013\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\t\u0001\u000b\u0005\u0002R-6\t!K\u0003\u0002T)\u0006!A.\u00198h\u0015\u0005)\u0016\u0001\u00026bm\u0006L!A\u000e*\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0003e\u0003\"!\n.\n\u0005mc\"aA%oi\u0006q\u0001O]8ek\u000e$X\t\\3nK:$HC\u00010b!\t)s,\u0003\u0002a9\t\u0019\u0011I\\=\t\u000f\tL\u0011\u0011!a\u00013\u0006\u0019\u0001\u0010J\u0019\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\u0012!\u001a\t\u0004M&tV\"A4\u000b\u0005!d\u0012AC2pY2,7\r^5p]&\u0011!n\u001a\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0002naB\u0011QE\\\u0005\u0003_r\u0011qAQ8pY\u0016\fg\u000eC\u0004c\u0017\u0005\u0005\t\u0019\u00010\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012!W\u0001\u0007KF,\u0018\r\\:\u0015\u00055,\bb\u00022\u000e\u0003\u0003\u0005\rAX\u0001\b\r\u0006\\W\rU8t!\t\tsbE\u0002\u0010s\"\u0002BA_?.w5\t1P\u0003\u0002}9\u00059!/\u001e8uS6,\u0017B\u0001@|\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|g.\r\u000b\u0002oR\t\u0001+A\u0003baBd\u0017\u0010F\u0002<\u0003\u000fAQa\u000b\nA\u00025\nq!\u001e8baBd\u0017\u0010\u0006\u0003\u0002\u000e\u0005M\u0001\u0003B\u0013\u0002\u00105J1!!\u0005\u001d\u0005\u0019y\u0005\u000f^5p]\"A\u0011QC\n\u0002\u0002\u0003\u00071(A\u0002yIA\n1B]3bIJ+7o\u001c7wKR\u0011\u00111\u0004\t\u0004#\u0006u\u0011bAA\u0010%\n1qJ\u00196fGR\u0004")
public class FakePos
extends UndefinedPosition
implements Product,
Serializable {
    private final String msg;

    public static Option<String> unapply(FakePos fakePos) {
        return FakePos$.MODULE$.unapply(fakePos);
    }

    public static FakePos apply(String string) {
        return FakePos$.MODULE$.apply(string);
    }

    public static <A> Function1<String, A> andThen(Function1<FakePos, A> function1) {
        FakePos$ fakePos$ = FakePos$.MODULE$;
        if (fakePos$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(fakePos$, function1, arg_0);
    }

    public static <A> Function1<A, FakePos> compose(Function1<A, String> function1) {
        FakePos$ fakePos$ = FakePos$.MODULE$;
        if (fakePos$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(fakePos$, function1, arg_0);
    }

    public String msg() {
        return this.msg;
    }

    public String toString() {
        return this.msg();
    }

    public FakePos copy(String msg) {
        return new FakePos(msg);
    }

    public String copy$default$1() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "FakePos";
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
        return x$1 instanceof FakePos;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof FakePos;
                if (!bl) break block3;
                FakePos fakePos = (FakePos)x$1;
                String string = this.msg();
                String string2 = fakePos.msg();
                if (!(!(string != null ? !string.equals(string2) : string2 != null) && fakePos.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public FakePos(String msg) {
        this.msg = msg;
        Product.$init$(this);
    }
}

