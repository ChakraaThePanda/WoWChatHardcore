/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product7;
import scala.Serializable;
import scala.Tuple7$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\t}d\u0001B\u0013'\u0005&B\u0001\"\u0016\u0001\u0003\u0016\u0004%\tA\u0016\u0005\t/\u0002\u0011\t\u0012)A\u0005e!A\u0001\f\u0001BK\u0002\u0013\u0005\u0011\f\u0003\u0005[\u0001\tE\t\u0015!\u0003>\u0011!Y\u0006A!f\u0001\n\u0003a\u0006\u0002C/\u0001\u0005#\u0005\u000b\u0011\u0002!\t\u0011y\u0003!Q3A\u0005\u0002}C\u0001\u0002\u0019\u0001\u0003\u0012\u0003\u0006Ia\u0011\u0005\tC\u0002\u0011)\u001a!C\u0001E\"A1\r\u0001B\tB\u0003%a\t\u0003\u0005e\u0001\tU\r\u0011\"\u0001f\u0011!1\u0007A!E!\u0002\u0013I\u0005\u0002C4\u0001\u0005+\u0007I\u0011\u00015\t\u0011%\u0004!\u0011#Q\u0001\n1CQA\u001b\u0001\u0005\u0002-DQ\u0001\u001e\u0001\u0005BUDqA \u0001\u0002\u0002\u0013\u0005q\u0010C\u0005\u00020\u0001\t\n\u0011\"\u0001\u00022!I\u0011q\u000b\u0001\u0012\u0002\u0013\u0005\u0011\u0011\f\u0005\n\u0003[\u0002\u0011\u0013!C\u0001\u0003_B\u0011\"a!\u0001#\u0003%\t!!\"\t\u0013\u0005e\u0005!%A\u0005\u0002\u0005m\u0005\"CAX\u0001E\u0005I\u0011AAY\u0011%\t)\rAI\u0001\n\u0003\t9\rC\u0005\u0002\\\u0002\t\t\u0011\"\u0011\u0002^\"I\u0011q\u001c\u0001\u0002\u0002\u0013\u0005\u0013\u0011\u001d\u0005\n\u0003_\u0004\u0011\u0011!C\u0001\u0003cD\u0011\"!@\u0001\u0003\u0003%\t%a@\t\u0013\t\u001d\u0001!!A\u0005B\t%q!\u0003B\u0007M\u0005\u0005\t\u0012\u0001B\b\r!)c%!A\t\u0002\tE\u0001B\u00026 \t\u0003\u0011\u0019\u0002C\u0004u?\u0005\u0005IQI;\t\u0013\tUq$!A\u0005\u0002\n]\u0001\"\u0003B$?\u0005\u0005I\u0011\u0011B%\u0011%\u0011)hHA\u0001\n\u0013\u00119H\u0001\u0004UkBdWm\u000e\u0006\u0002O\u0005)1oY1mC\u000e\u0001Q\u0003\u0003\u00165}\u0005#uIS'\u0014\u000b\u0001Ysf\u0014*\u0011\u00051jS\"\u0001\u0014\n\u000592#AB!osJ+g\rE\u0005-aIj\u0004i\u0011$J\u0019&\u0011\u0011G\n\u0002\t!J|G-^2uoA\u00111\u0007\u000e\u0007\u0001\t\u0019)\u0004\u0001\"b\u0001m\t\u0011A+M\t\u0003oi\u0002\"\u0001\f\u001d\n\u0005e2#a\u0002(pi\"Lgn\u001a\t\u0003YmJ!\u0001\u0010\u0014\u0003\u0007\u0005s\u0017\u0010\u0005\u00024}\u00111q\b\u0001CC\u0002Y\u0012!\u0001\u0016\u001a\u0011\u0005M\nEA\u0002\"\u0001\t\u000b\u0007aG\u0001\u0002UgA\u00111\u0007\u0012\u0003\u0007\u000b\u0002!)\u0019\u0001\u001c\u0003\u0005Q#\u0004CA\u001aH\t\u0019A\u0005\u0001\"b\u0001m\t\u0011A+\u000e\t\u0003g)#aa\u0013\u0001\u0005\u0006\u00041$A\u0001+7!\t\u0019T\n\u0002\u0004O\u0001\u0011\u0015\rA\u000e\u0002\u0003)^\u0002\"\u0001\f)\n\u0005E3#a\u0002)s_\u0012,8\r\u001e\t\u0003YMK!\u0001\u0016\u0014\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u0005}\u000bT#\u0001\u001a\u0002\u0007}\u000b\u0004%\u0001\u0002`eU\tQ(A\u0002`e\u0001\n!aX\u001a\u0016\u0003\u0001\u000b1aX\u001a!\u0003\tyF'F\u0001D\u0003\ryF\u0007I\u0001\u0003?V*\u0012AR\u0001\u0004?V\u0002\u0013AA07+\u0005I\u0015aA07A\u0005\u0011qlN\u000b\u0002\u0019\u0006\u0019ql\u000e\u0011\u0002\rqJg.\u001b;?)!aWN\\8qcJ\u001c\b#\u0003\u0017\u0001eu\u00025IR%M\u0011\u0015)v\u00021\u00013\u0011\u0015Av\u00021\u0001>\u0011\u0015Yv\u00021\u0001A\u0011\u0015qv\u00021\u0001D\u0011\u0015\tw\u00021\u0001G\u0011\u0015!w\u00021\u0001J\u0011\u00159w\u00021\u0001M\u0003!!xn\u0015;sS:<G#\u0001<\u0011\u0005]dX\"\u0001=\u000b\u0005eT\u0018\u0001\u00027b]\u001eT\u0011a_\u0001\u0005U\u00064\u0018-\u0003\u0002~q\n11\u000b\u001e:j]\u001e\fAaY8qsV\u0001\u0012\u0011AA\u0004\u0003\u0017\ty!a\u0005\u0002\u0018\u0005m\u0011q\u0004\u000b\u0011\u0003\u0007\t\t#a\t\u0002&\u0005\u001d\u0012\u0011FA\u0016\u0003[\u0001\u0002\u0003\f\u0001\u0002\u0006\u0005%\u0011QBA\t\u0003+\tI\"!\b\u0011\u0007M\n9\u0001B\u00036#\t\u0007a\u0007E\u00024\u0003\u0017!QaP\tC\u0002Y\u00022aMA\b\t\u0015\u0011\u0015C1\u00017!\r\u0019\u00141\u0003\u0003\u0006\u000bF\u0011\rA\u000e\t\u0004g\u0005]A!\u0002%\u0012\u0005\u00041\u0004cA\u001a\u0002\u001c\u0011)1*\u0005b\u0001mA\u00191'a\b\u0005\u000b9\u000b\"\u0019\u0001\u001c\t\u0011U\u000b\u0002\u0013!a\u0001\u0003\u000bA\u0001\u0002W\t\u0011\u0002\u0003\u0007\u0011\u0011\u0002\u0005\t7F\u0001\n\u00111\u0001\u0002\u000e!Aa,\u0005I\u0001\u0002\u0004\t\t\u0002\u0003\u0005b#A\u0005\t\u0019AA\u000b\u0011!!\u0017\u0003%AA\u0002\u0005e\u0001\u0002C4\u0012!\u0003\u0005\r!!\b\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\u0001\u00121GA%\u0003\u0017\ni%a\u0014\u0002R\u0005M\u0013QK\u000b\u0003\u0003kQ3AMA\u001cW\t\tI\u0004\u0005\u0003\u0002<\u0005\u0015SBAA\u001f\u0015\u0011\ty$!\u0011\u0002\u0013Ut7\r[3dW\u0016$'bAA\"M\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\u0005\u001d\u0013Q\b\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,G!B\u001b\u0013\u0005\u00041D!B \u0013\u0005\u00041D!\u0002\"\u0013\u0005\u00041D!B#\u0013\u0005\u00041D!\u0002%\u0013\u0005\u00041D!B&\u0013\u0005\u00041D!\u0002(\u0013\u0005\u00041\u0014AD2paf$C-\u001a4bk2$HEM\u000b\u0011\u00037\ny&!\u0019\u0002d\u0005\u0015\u0014qMA5\u0003W*\"!!\u0018+\u0007u\n9\u0004B\u00036'\t\u0007a\u0007B\u0003@'\t\u0007a\u0007B\u0003C'\t\u0007a\u0007B\u0003F'\t\u0007a\u0007B\u0003I'\t\u0007a\u0007B\u0003L'\t\u0007a\u0007B\u0003O'\t\u0007a'\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001a\u0016!\u0005E\u0014QOA<\u0003s\nY(! \u0002\u0000\u0005\u0005UCAA:U\r\u0001\u0015q\u0007\u0003\u0006kQ\u0011\rA\u000e\u0003\u0006\u007fQ\u0011\rA\u000e\u0003\u0006\u0005R\u0011\rA\u000e\u0003\u0006\u000bR\u0011\rA\u000e\u0003\u0006\u0011R\u0011\rA\u000e\u0003\u0006\u0017R\u0011\rA\u000e\u0003\u0006\u001dR\u0011\rAN\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00135+A\t9)a#\u0002\u000e\u0006=\u0015\u0011SAJ\u0003+\u000b9*\u0006\u0002\u0002\n*\u001a1)a\u000e\u0005\u000bU*\"\u0019\u0001\u001c\u0005\u000b}*\"\u0019\u0001\u001c\u0005\u000b\t+\"\u0019\u0001\u001c\u0005\u000b\u0015+\"\u0019\u0001\u001c\u0005\u000b!+\"\u0019\u0001\u001c\u0005\u000b-+\"\u0019\u0001\u001c\u0005\u000b9+\"\u0019\u0001\u001c\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%kU\u0001\u0012QTAQ\u0003G\u000b)+a*\u0002*\u0006-\u0016QV\u000b\u0003\u0003?S3ARA\u001c\t\u0015)dC1\u00017\t\u0015ydC1\u00017\t\u0015\u0011eC1\u00017\t\u0015)eC1\u00017\t\u0015AeC1\u00017\t\u0015YeC1\u00017\t\u0015qeC1\u00017\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIY*\u0002#a-\u00028\u0006e\u00161XA_\u0003\u007f\u000b\t-a1\u0016\u0005\u0005U&fA%\u00028\u0011)Qg\u0006b\u0001m\u0011)qh\u0006b\u0001m\u0011)!i\u0006b\u0001m\u0011)Qi\u0006b\u0001m\u0011)\u0001j\u0006b\u0001m\u0011)1j\u0006b\u0001m\u0011)aj\u0006b\u0001m\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012:T\u0003EAe\u0003\u001b\fy-!5\u0002T\u0006U\u0017q[Am+\t\tYMK\u0002M\u0003o!Q!\u000e\rC\u0002Y\"Qa\u0010\rC\u0002Y\"QA\u0011\rC\u0002Y\"Q!\u0012\rC\u0002Y\"Q\u0001\u0013\rC\u0002Y\"Qa\u0013\rC\u0002Y\"QA\u0014\rC\u0002Y\nQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DX#\u0001<\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\"!a9\u0011\u000b\u0005\u0015\u00181\u001e\u001e\u000e\u0005\u0005\u001d(bAAuM\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u00055\u0018q\u001d\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002t\u0006e\bc\u0001\u0017\u0002v&\u0019\u0011q\u001f\u0014\u0003\u000f\t{w\u000e\\3b]\"A\u00111`\u000e\u0002\u0002\u0003\u0007!(A\u0002yIE\n\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0003\u0005\u0003\u00012\u0001\fB\u0002\u0013\r\u0011)A\n\u0002\u0004\u0013:$\u0018AB3rk\u0006d7\u000f\u0006\u0003\u0002t\n-\u0001\u0002CA~;\u0005\u0005\t\u0019\u0001\u001e\u0002\rQ+\b\u000f\\38!\tasdE\u0002 WI#\"Aa\u0004\u0002\u000b\u0005\u0004\b\u000f\\=\u0016!\te!q\u0004B\u0012\u0005O\u0011YCa\f\u00034\t]B\u0003\u0005B\u000e\u0005s\u0011YD!\u0010\u0003@\t\u0005#1\tB#!Aa\u0003A!\b\u0003\"\t\u0015\"\u0011\u0006B\u0017\u0005c\u0011)\u0004E\u00024\u0005?!Q!\u000e\u0012C\u0002Y\u00022a\rB\u0012\t\u0015y$E1\u00017!\r\u0019$q\u0005\u0003\u0006\u0005\n\u0012\rA\u000e\t\u0004g\t-B!B##\u0005\u00041\u0004cA\u001a\u00030\u0011)\u0001J\tb\u0001mA\u00191Ga\r\u0005\u000b-\u0013#\u0019\u0001\u001c\u0011\u0007M\u00129\u0004B\u0003OE\t\u0007a\u0007\u0003\u0004VE\u0001\u0007!Q\u0004\u0005\u00071\n\u0002\rA!\t\t\rm\u0013\u0003\u0019\u0001B\u0013\u0011\u0019q&\u00051\u0001\u0003*!1\u0011M\ta\u0001\u0005[Aa\u0001\u001a\u0012A\u0002\tE\u0002BB4#\u0001\u0004\u0011)$A\u0004v]\u0006\u0004\b\u000f\\=\u0016!\t-#q\u000bB.\u0005?\u0012\u0019Ga\u001a\u0003l\t=D\u0003\u0002B'\u0005c\u0002R\u0001\fB(\u0005'J1A!\u0015'\u0005\u0019y\u0005\u000f^5p]B\u0001B\u0006\u0001B+\u00053\u0012iF!\u0019\u0003f\t%$Q\u000e\t\u0004g\t]C!B\u001b$\u0005\u00041\u0004cA\u001a\u0003\\\u0011)qh\tb\u0001mA\u00191Ga\u0018\u0005\u000b\t\u001b#\u0019\u0001\u001c\u0011\u0007M\u0012\u0019\u0007B\u0003FG\t\u0007a\u0007E\u00024\u0005O\"Q\u0001S\u0012C\u0002Y\u00022a\rB6\t\u0015Y5E1\u00017!\r\u0019$q\u000e\u0003\u0006\u001d\u000e\u0012\rA\u000e\u0005\n\u0005g\u001a\u0013\u0011!a\u0001\u0005'\n1\u0001\u001f\u00131\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\te\u0004cA<\u0003|%\u0019!Q\u0010=\u0003\r=\u0013'.Z2u\u0001")
public final class Tuple7<T1, T2, T3, T4, T5, T6, T7>
implements Product7<T1, T2, T3, T4, T5, T6, T7>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;
    private final T6 _6;
    private final T7 _7;

    public static <T1, T2, T3, T4, T5, T6, T7> Option<Tuple7<T1, T2, T3, T4, T5, T6, T7>> unapply(Tuple7<T1, T2, T3, T4, T5, T6, T7> tuple7) {
        return Tuple7$.MODULE$.unapply(tuple7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6, T7 T7) {
        return Tuple7$.MODULE$.apply(T1, T2, T3, T4, T5, T6, T7);
    }

    @Override
    public int productArity() {
        return Product7.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product7.productElement$(this, n);
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

    @Override
    public T4 _4() {
        return this._4;
    }

    @Override
    public T5 _5() {
        return this._5;
    }

    @Override
    public T6 _6() {
        return this._6;
    }

    @Override
    public T7 _7() {
        return this._7;
    }

    public String toString() {
        return new StringBuilder(8).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(",").append(this._7()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7) {
        return new Tuple7<T1, T2, T3, T4, T5, T6, T7>(_1, _2, _3, _4, _5, _6, _7);
    }

    public <T1, T2, T3, T4, T5, T6, T7> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6, T7> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6, T7> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6, T7> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6, T7> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6, T7> T6 copy$default$6() {
        return this._6();
    }

    public <T1, T2, T3, T4, T5, T6, T7> T7 copy$default$7() {
        return this._7();
    }

    @Override
    public String productPrefix() {
        return "Tuple7";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple7;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple7;
                if (!bl) break block3;
                Tuple7 tuple7 = (Tuple7)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple7._1()) && BoxesRunTime.equals(this._2(), tuple7._2()) && BoxesRunTime.equals(this._3(), tuple7._3()) && BoxesRunTime.equals(this._4(), tuple7._4()) && BoxesRunTime.equals(this._5(), tuple7._5()) && BoxesRunTime.equals(this._6(), tuple7._6()) && BoxesRunTime.equals(this._7(), tuple7._7()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple7(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        Product.$init$(this);
        Product7.$init$(this);
    }
}

