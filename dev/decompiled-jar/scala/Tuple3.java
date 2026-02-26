/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product3;
import scala.Serializable;
import scala.Tuple3$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005}d\u0001B\r\u001b\u0005vA\u0001\"\u0010\u0001\u0003\u0016\u0004%\tA\u0010\u0005\t\u007f\u0001\u0011\t\u0012)A\u0005M!A\u0001\t\u0001BK\u0002\u0013\u0005\u0011\t\u0003\u0005C\u0001\tE\t\u0015!\u00032\u0011!\u0019\u0005A!f\u0001\n\u0003!\u0005\u0002C#\u0001\u0005#\u0005\u000b\u0011\u0002\u001b\t\u000b\u0019\u0003A\u0011A$\t\u000b1\u0003A\u0011I'\t\u000fY\u0003\u0011\u0011!C\u0001/\"91\rAI\u0001\n\u0003!\u0007bB:\u0001#\u0003%\t\u0001\u001e\u0005\bu\u0002\t\n\u0011\"\u0001|\u0011%\t\u0019\u0001AA\u0001\n\u0003\n)\u0001C\u0005\u0002\b\u0001\t\t\u0011\"\u0011\u0002\n!I\u0011q\u0003\u0001\u0002\u0002\u0013\u0005\u0011\u0011\u0004\u0005\n\u0003K\u0001\u0011\u0011!C!\u0003OA\u0011\"a\f\u0001\u0003\u0003%\t%!\r\b\u0013\u0005U\"$!A\t\u0002\u0005]b\u0001C\r\u001b\u0003\u0003E\t!!\u000f\t\r\u0019\u001bB\u0011AA\u001e\u0011\u001da5#!A\u0005F5C\u0011\"!\u0010\u0014\u0003\u0003%\t)a\u0010\t\u0013\u0005]3#!A\u0005\u0002\u0006e\u0003\"CA;'\u0005\u0005I\u0011BA<\u0005\u0019!V\u000f\u001d7fg)\t1$A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\tyA#'N\n\u0006\u0001}\u0019sG\u000f\t\u0003A\u0005j\u0011AG\u0005\u0003Ei\u0011a!\u00118z%\u00164\u0007#\u0002\u0011%ME\"\u0014BA\u0013\u001b\u0005!\u0001&o\u001c3vGR\u001c\u0004CA\u0014)\u0019\u0001!a!\u000b\u0001\u0005\u0006\u0004Q#A\u0001+2#\tYc\u0006\u0005\u0002!Y%\u0011QF\u0007\u0002\b\u001d>$\b.\u001b8h!\t\u0001s&\u0003\u000215\t\u0019\u0011I\\=\u0011\u0005\u001d\u0012DAB\u001a\u0001\t\u000b\u0007!F\u0001\u0002UeA\u0011q%\u000e\u0003\u0007m\u0001!)\u0019\u0001\u0016\u0003\u0005Q\u001b\u0004C\u0001\u00119\u0013\tI$DA\u0004Qe>$Wo\u0019;\u0011\u0005\u0001Z\u0014B\u0001\u001f\u001b\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\ty\u0016'F\u0001'\u0003\ry\u0016\u0007I\u0001\u0003?J*\u0012!M\u0001\u0004?J\u0002\u0013AA04+\u0005!\u0014aA04A\u00051A(\u001b8jiz\"B\u0001S%K\u0017B)\u0001\u0005\u0001\u00142i!)Qh\u0002a\u0001M!)\u0001i\u0002a\u0001c!)1i\u0002a\u0001i\u0005AAo\\*ue&tw\rF\u0001O!\tyE+D\u0001Q\u0015\t\t&+\u0001\u0003mC:<'\"A*\u0002\t)\fg/Y\u0005\u0003+B\u0013aa\u0015;sS:<\u0017\u0001B2paf,B\u0001W.^?R!\u0011\fY1c!\u0015\u0001\u0003A\u0017/_!\t93\fB\u0003*\u0013\t\u0007!\u0006\u0005\u0002(;\u0012)1'\u0003b\u0001UA\u0011qe\u0018\u0003\u0006m%\u0011\rA\u000b\u0005\b{%\u0001\n\u00111\u0001[\u0011\u001d\u0001\u0015\u0002%AA\u0002qCqaQ\u0005\u0011\u0002\u0003\u0007a,\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\t\u0015\u0004\u0018O]\u000b\u0002M*\u0012aeZ\u0016\u0002QB\u0011\u0011N\\\u0007\u0002U*\u00111\u000e\\\u0001\nk:\u001c\u0007.Z2lK\u0012T!!\u001c\u000e\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002pU\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u000b%R!\u0019\u0001\u0016\u0005\u000bMR!\u0019\u0001\u0016\u0005\u000bYR!\u0019\u0001\u0016\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU!Qo\u001e=z+\u00051(FA\u0019h\t\u0015I3B1\u0001+\t\u0015\u00194B1\u0001+\t\u001514B1\u0001+\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIM*R\u0001 @\u0000\u0003\u0003)\u0012! \u0016\u0003i\u001d$Q!\u000b\u0007C\u0002)\"Qa\r\u0007C\u0002)\"QA\u000e\u0007C\u0002)\nQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DX#\u0001(\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\"!a\u0003\u0011\u000b\u00055\u00111\u0003\u0018\u000e\u0005\u0005=!bAA\t5\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u0005U\u0011q\u0002\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002\u001c\u0005\u0005\u0002c\u0001\u0011\u0002\u001e%\u0019\u0011q\u0004\u000e\u0003\u000f\t{w\u000e\\3b]\"A\u00111E\b\u0002\u0002\u0003\u0007a&A\u0002yIE\n\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0003\u0003S\u00012\u0001IA\u0016\u0013\r\tiC\u0007\u0002\u0004\u0013:$\u0018AB3rk\u0006d7\u000f\u0006\u0003\u0002\u001c\u0005M\u0002\u0002CA\u0012#\u0005\u0005\t\u0019\u0001\u0018\u0002\rQ+\b\u000f\\34!\t\u00013cE\u0002\u0014?i\"\"!a\u000e\u0002\u000b\u0005\u0004\b\u000f\\=\u0016\u0011\u0005\u0005\u0013qIA&\u0003\u001f\"\u0002\"a\u0011\u0002R\u0005M\u0013Q\u000b\t\tA\u0001\t)%!\u0013\u0002NA\u0019q%a\u0012\u0005\u000b%2\"\u0019\u0001\u0016\u0011\u0007\u001d\nY\u0005B\u00034-\t\u0007!\u0006E\u0002(\u0003\u001f\"QA\u000e\fC\u0002)Ba!\u0010\fA\u0002\u0005\u0015\u0003B\u0002!\u0017\u0001\u0004\tI\u0005\u0003\u0004D-\u0001\u0007\u0011QJ\u0001\bk:\f\u0007\u000f\u001d7z+!\tY&a\u001a\u0002l\u0005=D\u0003BA/\u0003c\u0002R\u0001IA0\u0003GJ1!!\u0019\u001b\u0005\u0019y\u0005\u000f^5p]BA\u0001\u0005AA3\u0003S\ni\u0007E\u0002(\u0003O\"Q!K\fC\u0002)\u00022aJA6\t\u0015\u0019tC1\u0001+!\r9\u0013q\u000e\u0003\u0006m]\u0011\rA\u000b\u0005\n\u0003g:\u0012\u0011!a\u0001\u0003G\n1\u0001\u001f\u00131\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005e\u0004cA(\u0002|%\u0019\u0011Q\u0010)\u0003\r=\u0013'.Z2u\u0001")
public final class Tuple3<T1, T2, T3>
implements Product3<T1, T2, T3>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;

    public static <T1, T2, T3> Option<Tuple3<T1, T2, T3>> unapply(Tuple3<T1, T2, T3> tuple3) {
        return Tuple3$.MODULE$.unapply(tuple3);
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> apply(T1 T1, T2 T2, T3 T3) {
        return Tuple3$.MODULE$.apply(T1, T2, T3);
    }

    @Override
    public int productArity() {
        return Product3.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product3.productElement$(this, n);
    }

    @Override
    public T1 _1() {
        return this._1;
    }

    @Override
    public T2 _2() {
        return this._2;
    }

    @Override
    public T3 _3() {
        return this._3;
    }

    public String toString() {
        return new StringBuilder(4).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(")").toString();
    }

    public <T1, T2, T3> Tuple3<T1, T2, T3> copy(T1 _1, T2 _2, T3 _3) {
        return new Tuple3<T1, T2, T3>(_1, _2, _3);
    }

    public <T1, T2, T3> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3> T3 copy$default$3() {
        return this._3();
    }

    @Override
    public String productPrefix() {
        return "Tuple3";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple3;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple3;
                if (!bl) break block3;
                Tuple3 tuple3 = (Tuple3)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple3._1()) && BoxesRunTime.equals(this._2(), tuple3._2()) && BoxesRunTime.equals(this._3(), tuple3._3()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple3(T1 _1, T2 _2, T3 _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        Product.$init$(this);
        Product3.$init$(this);
    }
}

