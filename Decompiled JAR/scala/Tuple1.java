/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product1;
import scala.Serializable;
import scala.Tuple1$;
import scala.Tuple1$mcD$sp;
import scala.Tuple1$mcI$sp;
import scala.Tuple1$mcJ$sp;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005]c\u0001B\n\u0015\u0005^A\u0001\"\u0011\u0001\u0003\u0016\u0004%\tA\u0011\u0005\t\u0007\u0002\u0011\t\u0012)A\u0005A!)A\t\u0001C\u0001\u000b\")\u0001\n\u0001C!\u0013\"9!\u000bAA\u0001\n\u0003\u0019\u0006bB/\u0001#\u0003%\tA\u0018\u0005\b_\u0002\t\t\u0011\"\u0011q\u0011\u001d\t\b!!A\u0005BIDq!\u001f\u0001\u0002\u0002\u0013\u0005!\u0010C\u0005\u0002\u0002\u0001\t\t\u0011\"\u0011\u0002\u0004!I\u00111\u0002\u0001\u0002\u0002\u0013\u0005\u0013QB\u0004\n\u0003#!\u0012\u0011!E\u0001\u0003'1\u0001b\u0005\u000b\u0002\u0002#\u0005\u0011Q\u0003\u0005\u0007\t6!\t!a\u0006\t\u000f!k\u0011\u0011!C#\u0013\"I\u0011\u0011D\u0007\u0002\u0002\u0013\u0005\u00151\u0004\u0005\n\u0003_i\u0011\u0011!CA\u0003cA\u0011\"!\u0014\u000e\u0003\u0003%I!a\u0014\u0003\rQ+\b\u000f\\32\u0015\u0005)\u0012!B:dC2\f7\u0001A\u000b\u00031\t\u001aR\u0001A\r\u001ewy\u0002\"AG\u000e\u000e\u0003QI!\u0001\b\u000b\u0003\r\u0005s\u0017PU3g!\rQb\u0004I\u0005\u0003?Q\u0011\u0001\u0002\u0015:pIV\u001cG/\r\t\u0003C\tb\u0001\u0001B\u0005$\u0001\u0001\u0006\t\u0011\"b\u0001I\t\u0011A+M\t\u0003K!\u0002\"A\u0007\u0014\n\u0005\u001d\"\"a\u0002(pi\"Lgn\u001a\t\u00035%J!A\u000b\u000b\u0003\u0007\u0005s\u0017\u0010K\u0003#Y=\u001at\u0007\u0005\u0002\u001b[%\u0011a\u0006\u0006\u0002\fgB,7-[1mSj,G-\r\u0003%aE\u0012dB\u0001\u000e2\u0013\t\u0011D#A\u0002J]R\fD\u0001\n\u001b6m9\u0011!$N\u0005\u0003mQ\tA\u0001T8oOF\"A\u0005O\u001d;\u001d\tQ\u0012(\u0003\u0002;)\u00051Ai\\;cY\u0016\u0004\"A\u0007\u001f\n\u0005u\"\"a\u0002)s_\u0012,8\r\u001e\t\u00035}J!\u0001\u0011\u000b\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u0005}\u000bT#\u0001\u0011\u0002\u0007}\u000b\u0004%\u0001\u0004=S:LGO\u0010\u000b\u0003\r\u001e\u00032A\u0007\u0001!\u0011\u0015\t5\u00011\u0001!\u0003!!xn\u0015;sS:<G#\u0001&\u0011\u0005-\u0003V\"\u0001'\u000b\u00055s\u0015\u0001\u00027b]\u001eT\u0011aT\u0001\u0005U\u00064\u0018-\u0003\u0002R\u0019\n11\u000b\u001e:j]\u001e\fAaY8qsV\u0011Ak\u0016\u000b\u0003+r\u00032A\u0007\u0001W!\t\ts\u000bB\u0005$\u000b\u0001\u0006\t\u0011!b\u0001I!*q\u000bL-[7F\"A\u0005M\u00193c\u0011!C'\u000e\u001c2\t\u0011B\u0014H\u000f\u0005\b\u0003\u0016\u0001\n\u00111\u0001W\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\"a\u00186\u0016\u0003\u0001T#\u0001I1,\u0003\t\u0004\"a\u00195\u000e\u0003\u0011T!!\u001a4\u0002\u0013Ut7\r[3dW\u0016$'BA4\u0015\u0003)\tgN\\8uCRLwN\\\u0005\u0003S\u0012\u0014\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\t%\u0019c\u0001)A\u0001\u0002\u000b\u0007A\u0005K\u0003kY1lg.\r\u0003%aE\u0012\u0014\u0007\u0002\u00135kY\nD\u0001\n\u001d:u\u0005i\u0001O]8ek\u000e$\bK]3gSb,\u0012AS\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\t1\u000fE\u0002uo\"j\u0011!\u001e\u0006\u0003mR\t!bY8mY\u0016\u001cG/[8o\u0013\tAXO\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dGCA>\u007f!\tQB0\u0003\u0002~)\t9!i\\8mK\u0006t\u0007bB@\n\u0003\u0003\u0005\r\u0001K\u0001\u0004q\u0012\n\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005\u0015\u0001c\u0001\u000e\u0002\b%\u0019\u0011\u0011\u0002\u000b\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0004w\u0006=\u0001bB@\f\u0003\u0003\u0005\r\u0001K\u0001\u0007)V\u0004H.Z\u0019\u0011\u0005ii1cA\u0007\u001a}Q\u0011\u00111C\u0001\u0006CB\u0004H._\u000b\u0005\u0003;\t\u0019\u0003\u0006\u0003\u0002 \u00055\u0002\u0003\u0002\u000e\u0001\u0003C\u00012!IA\u0012\t%\u0019\u0003\u0003)A\u0001\u0002\u000b\u0007A\u0005K\u0005\u0002$1\n9#!\u000b\u0002,E\"A\u0005M\u00193c\u0011!C'\u000e\u001c2\t\u0011B\u0014H\u000f\u0005\u0007\u0003B\u0001\r!!\t\u0002\u000fUt\u0017\r\u001d9msV!\u00111GA\u001f)\u0011\t)$a\u0012\u0011\u000bi\t9$a\u000f\n\u0007\u0005eBC\u0001\u0004PaRLwN\u001c\t\u0004C\u0005uB!C\u0012\u0012A\u0003\u0005\tQ1\u0001%Q%\ti\u0004LA!\u0003\u0007\n)%\r\u0003%aE\u0012\u0014\u0007\u0002\u00135kY\nD\u0001\n\u001d:u!I\u0011\u0011J\t\u0002\u0002\u0003\u0007\u00111J\u0001\u0004q\u0012\u0002\u0004\u0003\u0002\u000e\u0001\u0003w\t1B]3bIJ+7o\u001c7wKR\u0011\u0011\u0011\u000b\t\u0004\u0017\u0006M\u0013bAA+\u0019\n1qJ\u00196fGR\u0004")
public class Tuple1<T1>
implements Product1<T1>,
Serializable {
    public final T1 _1;

    public static <T1> Option<T1> unapply(Tuple1<T1> tuple1) {
        return Tuple1$.MODULE$.unapply(tuple1);
    }

    public static <T1> Tuple1<T1> apply(T1 T1) {
        return Tuple1$.MODULE$.apply(T1);
    }

    @Override
    public int productArity() {
        return Product1.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product1.productElement$(this, n);
    }

    @Override
    public T1 _1() {
        return this._1;
    }

    public String toString() {
        return new StringBuilder(2).append("(").append(this._1()).append(")").toString();
    }

    public <T1> Tuple1<T1> copy(T1 _1) {
        return new Tuple1<T1>(_1);
    }

    public <T1> T1 copy$default$1() {
        return this._1();
    }

    @Override
    public String productPrefix() {
        return "Tuple1";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple1;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple1;
                if (!bl) break block3;
                Tuple1 tuple1 = (Tuple1)x$1;
                if (!BoxesRunTime.equals(this._1(), tuple1._1())) break block3;
            }
            return true;
        }
        return false;
    }

    @Override
    public double _1$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this._1());
    }

    @Override
    public int _1$mcI$sp() {
        return BoxesRunTime.unboxToInt(this._1());
    }

    @Override
    public long _1$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this._1());
    }

    public Tuple1<Object> copy$mDc$sp(double _1) {
        return new Tuple1$mcD$sp(_1);
    }

    public Tuple1<Object> copy$mIc$sp(int _1) {
        return new Tuple1$mcI$sp(_1);
    }

    public Tuple1<Object> copy$mJc$sp(long _1) {
        return new Tuple1$mcJ$sp(_1);
    }

    public <T1> double copy$default$1$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this.copy$default$1());
    }

    public <T1> int copy$default$1$mcI$sp() {
        return BoxesRunTime.unboxToInt(this.copy$default$1());
    }

    public <T1> long copy$default$1$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this.copy$default$1());
    }

    public boolean specInstance$() {
        return false;
    }

    public Tuple1(T1 _1) {
        this._1 = _1;
        Product.$init$(this);
        Product1.$init$(this);
    }
}

