/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product6;
import scala.Serializable;
import scala.Tuple6$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\teb\u0001\u0002\u0012$\u0005\u001aB\u0001b\u0014\u0001\u0003\u0016\u0004%\t\u0001\u0015\u0005\t#\u0002\u0011\t\u0012)A\u0005_!A!\u000b\u0001BK\u0002\u0013\u00051\u000b\u0003\u0005U\u0001\tE\t\u0015!\u0003;\u0011!)\u0006A!f\u0001\n\u00031\u0006\u0002C,\u0001\u0005#\u0005\u000b\u0011B\u001f\t\u0011a\u0003!Q3A\u0005\u0002eC\u0001B\u0017\u0001\u0003\u0012\u0003\u0006I\u0001\u0011\u0005\t7\u0002\u0011)\u001a!C\u00019\"AQ\f\u0001B\tB\u0003%1\t\u0003\u0005_\u0001\tU\r\u0011\"\u0001`\u0011!\u0001\u0007A!E!\u0002\u00131\u0005\"B1\u0001\t\u0003\u0011\u0007\"\u00026\u0001\t\u0003Z\u0007b\u0002;\u0001\u0003\u0003%\t!\u001e\u0005\n\u0003+\u0001\u0011\u0013!C\u0001\u0003/A\u0011\"a\u000f\u0001#\u0003%\t!!\u0010\t\u0013\u0005=\u0003!%A\u0005\u0002\u0005E\u0003\"CA2\u0001E\u0005I\u0011AA3\u0011%\t9\bAI\u0001\n\u0003\tI\bC\u0005\u0002\f\u0002\t\n\u0011\"\u0001\u0002\u000e\"I\u0011q\u0014\u0001\u0002\u0002\u0013\u0005\u0013\u0011\u0015\u0005\n\u0003G\u0003\u0011\u0011!C!\u0003KC\u0011\"a-\u0001\u0003\u0003%\t!!.\t\u0013\u0005\u0005\u0007!!A\u0005B\u0005\r\u0007\"CAf\u0001\u0005\u0005I\u0011IAg\u000f%\t\tnIA\u0001\u0012\u0003\t\u0019N\u0002\u0005#G\u0005\u0005\t\u0012AAk\u0011\u0019\tG\u0004\"\u0001\u0002X\"9!\u000eHA\u0001\n\u000bZ\u0007\"CAm9\u0005\u0005I\u0011QAn\u0011%\u0011)\u0001HA\u0001\n\u0003\u00139\u0001C\u0005\u00030q\t\t\u0011\"\u0003\u00032\t1A+\u001e9mKZR\u0011\u0001J\u0001\u0006g\u000e\fG.Y\u0002\u0001+\u001d9\u0013g\u000f B\t\u001e\u001bR\u0001\u0001\u0015-\u00132\u0003\"!\u000b\u0016\u000e\u0003\rJ!aK\u0012\u0003\r\u0005s\u0017PU3g!!ISf\f\u001e>\u0001\u000e3\u0015B\u0001\u0018$\u0005!\u0001&o\u001c3vGR4\u0004C\u0001\u00192\u0019\u0001!aA\r\u0001\u0005\u0006\u0004\u0019$A\u0001+2#\t!t\u0007\u0005\u0002*k%\u0011ag\t\u0002\b\u001d>$\b.\u001b8h!\tI\u0003(\u0003\u0002:G\t\u0019\u0011I\\=\u0011\u0005AZDA\u0002\u001f\u0001\t\u000b\u00071G\u0001\u0002UeA\u0011\u0001G\u0010\u0003\u0007\u007f\u0001!)\u0019A\u001a\u0003\u0005Q\u001b\u0004C\u0001\u0019B\t\u0019\u0011\u0005\u0001\"b\u0001g\t\u0011A\u000b\u000e\t\u0003a\u0011#a!\u0012\u0001\u0005\u0006\u0004\u0019$A\u0001+6!\t\u0001t\t\u0002\u0004I\u0001\u0011\u0015\ra\r\u0002\u0003)Z\u0002\"!\u000b&\n\u0005-\u001b#a\u0002)s_\u0012,8\r\u001e\t\u0003S5K!AT\u0012\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u0005}\u000bT#A\u0018\u0002\u0007}\u000b\u0004%\u0001\u0002`eU\t!(A\u0002`e\u0001\n!aX\u001a\u0016\u0003u\n1aX\u001a!\u0003\tyF'F\u0001A\u0003\ryF\u0007I\u0001\u0003?V*\u0012aQ\u0001\u0004?V\u0002\u0013AA07+\u00051\u0015aA07A\u00051A(\u001b8jiz\"ra\u00193fM\u001eD\u0017\u000e\u0005\u0005*\u0001=RT\bQ\"G\u0011\u0015yU\u00021\u00010\u0011\u0015\u0011V\u00021\u0001;\u0011\u0015)V\u00021\u0001>\u0011\u0015AV\u00021\u0001A\u0011\u0015YV\u00021\u0001D\u0011\u0015qV\u00021\u0001G\u0003!!xn\u0015;sS:<G#\u00017\u0011\u00055\u0014X\"\u00018\u000b\u0005=\u0004\u0018\u0001\u00027b]\u001eT\u0011!]\u0001\u0005U\u00064\u0018-\u0003\u0002t]\n11\u000b\u001e:j]\u001e\fAaY8qsVIa/_>~\u007f\u0006\r\u0011q\u0001\u000b\u000eo\u0006%\u00111BA\u0007\u0003\u001f\t\t\"a\u0005\u0011\u0015%\u0002\u0001P\u001f?\u007f\u0003\u0003\t)\u0001\u0005\u00021s\u0012)!g\u0004b\u0001gA\u0011\u0001g\u001f\u0003\u0006y=\u0011\ra\r\t\u0003au$QaP\bC\u0002M\u0002\"\u0001M@\u0005\u000b\t{!\u0019A\u001a\u0011\u0007A\n\u0019\u0001B\u0003F\u001f\t\u00071\u0007E\u00021\u0003\u000f!Q\u0001S\bC\u0002MBqaT\b\u0011\u0002\u0003\u0007\u0001\u0010C\u0004S\u001fA\u0005\t\u0019\u0001>\t\u000fU{\u0001\u0013!a\u0001y\"9\u0001l\u0004I\u0001\u0002\u0004q\b\u0002C.\u0010!\u0003\u0005\r!!\u0001\t\u0011y{\u0001\u0013!a\u0001\u0003\u000b\tabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\b\u0002\u001a\u0005=\u0012\u0011GA\u001a\u0003k\t9$!\u000f\u0016\u0005\u0005m!fA\u0018\u0002\u001e-\u0012\u0011q\u0004\t\u0005\u0003C\tY#\u0004\u0002\u0002$)!\u0011QEA\u0014\u0003%)hn\u00195fG.,GMC\u0002\u0002*\r\n!\"\u00198o_R\fG/[8o\u0013\u0011\ti#a\t\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW\rB\u00033!\t\u00071\u0007B\u0003=!\t\u00071\u0007B\u0003@!\t\u00071\u0007B\u0003C!\t\u00071\u0007B\u0003F!\t\u00071\u0007B\u0003I!\t\u00071'\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u001d\u0005}\u00121IA#\u0003\u000f\nI%a\u0013\u0002NU\u0011\u0011\u0011\t\u0016\u0004u\u0005uA!\u0002\u001a\u0012\u0005\u0004\u0019D!\u0002\u001f\u0012\u0005\u0004\u0019D!B \u0012\u0005\u0004\u0019D!\u0002\"\u0012\u0005\u0004\u0019D!B#\u0012\u0005\u0004\u0019D!\u0002%\u0012\u0005\u0004\u0019\u0014AD2paf$C-\u001a4bk2$HeM\u000b\u000f\u0003'\n9&!\u0017\u0002\\\u0005u\u0013qLA1+\t\t)FK\u0002>\u0003;!QA\r\nC\u0002M\"Q\u0001\u0010\nC\u0002M\"Qa\u0010\nC\u0002M\"QA\u0011\nC\u0002M\"Q!\u0012\nC\u0002M\"Q\u0001\u0013\nC\u0002M\nabY8qs\u0012\"WMZ1vYR$C'\u0006\b\u0002h\u0005-\u0014QNA8\u0003c\n\u0019(!\u001e\u0016\u0005\u0005%$f\u0001!\u0002\u001e\u0011)!g\u0005b\u0001g\u0011)Ah\u0005b\u0001g\u0011)qh\u0005b\u0001g\u0011)!i\u0005b\u0001g\u0011)Qi\u0005b\u0001g\u0011)\u0001j\u0005b\u0001g\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012*TCDA>\u0003\u007f\n\t)a!\u0002\u0006\u0006\u001d\u0015\u0011R\u000b\u0003\u0003{R3aQA\u000f\t\u0015\u0011DC1\u00014\t\u0015aDC1\u00014\t\u0015yDC1\u00014\t\u0015\u0011EC1\u00014\t\u0015)EC1\u00014\t\u0015AEC1\u00014\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIY*b\"a$\u0002\u0014\u0006U\u0015qSAM\u00037\u000bi*\u0006\u0002\u0002\u0012*\u001aa)!\b\u0005\u000bI*\"\u0019A\u001a\u0005\u000bq*\"\u0019A\u001a\u0005\u000b}*\"\u0019A\u001a\u0005\u000b\t+\"\u0019A\u001a\u0005\u000b\u0015+\"\u0019A\u001a\u0005\u000b!+\"\u0019A\u001a\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\u0005a\u0017a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\u0005\u001d\u0006#BAU\u0003_;TBAAV\u0015\r\tikI\u0001\u000bG>dG.Z2uS>t\u0017\u0002BAY\u0003W\u0013\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!\u0011qWA_!\rI\u0013\u0011X\u0005\u0004\u0003w\u001b#a\u0002\"p_2,\u0017M\u001c\u0005\t\u0003\u007fC\u0012\u0011!a\u0001o\u0005\u0019\u0001\u0010J\u0019\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!2\u0011\u0007%\n9-C\u0002\u0002J\u000e\u00121!\u00138u\u0003\u0019)\u0017/^1mgR!\u0011qWAh\u0011!\tyLGA\u0001\u0002\u00049\u0014A\u0002+va2,g\u0007\u0005\u0002*9M\u0019A\u0004\u000b'\u0015\u0005\u0005M\u0017!B1qa2LXCDAo\u0003G\f9/a;\u0002p\u0006M\u0018q\u001f\u000b\u000f\u0003?\fI0a?\u0002~\u0006}(\u0011\u0001B\u0002!9I\u0003!!9\u0002f\u0006%\u0018Q^Ay\u0003k\u00042\u0001MAr\t\u0015\u0011tD1\u00014!\r\u0001\u0014q\u001d\u0003\u0006y}\u0011\ra\r\t\u0004a\u0005-H!B  \u0005\u0004\u0019\u0004c\u0001\u0019\u0002p\u0012)!i\bb\u0001gA\u0019\u0001'a=\u0005\u000b\u0015{\"\u0019A\u001a\u0011\u0007A\n9\u0010B\u0003I?\t\u00071\u0007\u0003\u0004P?\u0001\u0007\u0011\u0011\u001d\u0005\u0007%~\u0001\r!!:\t\rU{\u0002\u0019AAu\u0011\u0019Av\u00041\u0001\u0002n\"11l\ba\u0001\u0003cDaAX\u0010A\u0002\u0005U\u0018aB;oCB\u0004H._\u000b\u000f\u0005\u0013\u0011)B!\u0007\u0003\u001e\t\u0005\"Q\u0005B\u0015)\u0011\u0011YAa\u000b\u0011\u000b%\u0012iA!\u0005\n\u0007\t=1E\u0001\u0004PaRLwN\u001c\t\u000fS\u0001\u0011\u0019Ba\u0006\u0003\u001c\t}!1\u0005B\u0014!\r\u0001$Q\u0003\u0003\u0006e\u0001\u0012\ra\r\t\u0004a\teA!\u0002\u001f!\u0005\u0004\u0019\u0004c\u0001\u0019\u0003\u001e\u0011)q\b\tb\u0001gA\u0019\u0001G!\t\u0005\u000b\t\u0003#\u0019A\u001a\u0011\u0007A\u0012)\u0003B\u0003FA\t\u00071\u0007E\u00021\u0005S!Q\u0001\u0013\u0011C\u0002MB\u0011B!\f!\u0003\u0003\u0005\rA!\u0005\u0002\u0007a$\u0003'A\u0006sK\u0006$'+Z:pYZ,GC\u0001B\u001a!\ri'QG\u0005\u0004\u0005oq'AB(cU\u0016\u001cG\u000f")
public final class Tuple6<T1, T2, T3, T4, T5, T6>
implements Product6<T1, T2, T3, T4, T5, T6>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;
    private final T6 _6;

    public static <T1, T2, T3, T4, T5, T6> Option<Tuple6<T1, T2, T3, T4, T5, T6>> unapply(Tuple6<T1, T2, T3, T4, T5, T6> tuple6) {
        return Tuple6$.MODULE$.unapply(tuple6);
    }

    public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6) {
        return Tuple6$.MODULE$.apply(T1, T2, T3, T4, T5, T6);
    }

    @Override
    public int productArity() {
        return Product6.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product6.productElement$(this, n);
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

    public String toString() {
        return new StringBuilder(7).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
        return new Tuple6<T1, T2, T3, T4, T5, T6>(_1, _2, _3, _4, _5, _6);
    }

    public <T1, T2, T3, T4, T5, T6> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6> T6 copy$default$6() {
        return this._6();
    }

    @Override
    public String productPrefix() {
        return "Tuple6";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple6;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple6;
                if (!bl) break block3;
                Tuple6 tuple6 = (Tuple6)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple6._1()) && BoxesRunTime.equals(this._2(), tuple6._2()) && BoxesRunTime.equals(this._3(), tuple6._3()) && BoxesRunTime.equals(this._4(), tuple6._4()) && BoxesRunTime.equals(this._5(), tuple6._5()) && BoxesRunTime.equals(this._6(), tuple6._6()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple6(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        Product.$init$(this);
        Product6.$init$(this);
    }
}

