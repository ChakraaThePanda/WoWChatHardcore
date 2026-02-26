/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product5;
import scala.Serializable;
import scala.Tuple5$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005]h\u0001B\u0010!\u0005\u000eB\u0001\"\u0013\u0001\u0003\u0016\u0004%\tA\u0013\u0005\t\u0017\u0002\u0011\t\u0012)A\u0005Y!AA\n\u0001BK\u0002\u0013\u0005Q\n\u0003\u0005O\u0001\tE\t\u0015!\u00038\u0011!y\u0005A!f\u0001\n\u0003\u0001\u0006\u0002C)\u0001\u0005#\u0005\u000b\u0011\u0002\u001e\t\u0011I\u0003!Q3A\u0005\u0002MC\u0001\u0002\u0016\u0001\u0003\u0012\u0003\u0006I!\u0010\u0005\t+\u0002\u0011)\u001a!C\u0001-\"Aq\u000b\u0001B\tB\u0003%\u0001\tC\u0003Y\u0001\u0011\u0005\u0011\fC\u0003a\u0001\u0011\u0005\u0013\rC\u0004k\u0001\u0005\u0005I\u0011A6\t\u000fu\u0004\u0011\u0013!C\u0001}\"I\u0011q\u0004\u0001\u0012\u0002\u0013\u0005\u0011\u0011\u0005\u0005\n\u0003c\u0001\u0011\u0013!C\u0001\u0003gA\u0011\"a\u0011\u0001#\u0003%\t!!\u0012\t\u0013\u0005U\u0003!%A\u0005\u0002\u0005]\u0003\"CA4\u0001\u0005\u0005I\u0011IA5\u0011%\tY\u0007AA\u0001\n\u0003\ni\u0007C\u0005\u0002|\u0001\t\t\u0011\"\u0001\u0002~!I\u0011\u0011\u0012\u0001\u0002\u0002\u0013\u0005\u00131\u0012\u0005\n\u0003'\u0003\u0011\u0011!C!\u0003+;\u0011\"!'!\u0003\u0003E\t!a'\u0007\u0011}\u0001\u0013\u0011!E\u0001\u0003;Ca\u0001W\r\u0005\u0002\u0005}\u0005b\u00021\u001a\u0003\u0003%)%\u0019\u0005\n\u0003CK\u0012\u0011!CA\u0003GC\u0011\"a2\u001a\u0003\u0003%\t)!3\t\u0013\u00055\u0018$!A\u0005\n\u0005=(A\u0002+va2,WGC\u0001\"\u0003\u0015\u00198-\u00197b\u0007\u0001)b\u0001\n\u00189wy\n5#\u0002\u0001&S\r3\u0005C\u0001\u0014(\u001b\u0005\u0001\u0013B\u0001\u0015!\u0005\u0019\te.\u001f*fMB9aE\u000b\u00178uu\u0002\u0015BA\u0016!\u0005!\u0001&o\u001c3vGR,\u0004CA\u0017/\u0019\u0001!aa\f\u0001\u0005\u0006\u0004\u0001$A\u0001+2#\t\tD\u0007\u0005\u0002'e%\u00111\u0007\t\u0002\b\u001d>$\b.\u001b8h!\t1S'\u0003\u00027A\t\u0019\u0011I\\=\u0011\u00055BDAB\u001d\u0001\t\u000b\u0007\u0001G\u0001\u0002UeA\u0011Qf\u000f\u0003\u0007y\u0001!)\u0019\u0001\u0019\u0003\u0005Q\u001b\u0004CA\u0017?\t\u0019y\u0004\u0001\"b\u0001a\t\u0011A\u000b\u000e\t\u0003[\u0005#aA\u0011\u0001\u0005\u0006\u0004\u0001$A\u0001+6!\t1C)\u0003\u0002FA\t9\u0001K]8ek\u000e$\bC\u0001\u0014H\u0013\tA\u0005E\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0002`cU\tA&A\u0002`c\u0001\n!a\u0018\u001a\u0016\u0003]\n1a\u0018\u001a!\u0003\ty6'F\u0001;\u0003\ry6\u0007I\u0001\u0003?R*\u0012!P\u0001\u0004?R\u0002\u0013AA06+\u0005\u0001\u0015aA06A\u00051A(\u001b8jiz\"bAW.];z{\u0006c\u0002\u0014\u0001Y]RT\b\u0011\u0005\u0006\u0013.\u0001\r\u0001\f\u0005\u0006\u0019.\u0001\ra\u000e\u0005\u0006\u001f.\u0001\rA\u000f\u0005\u0006%.\u0001\r!\u0010\u0005\u0006+.\u0001\r\u0001Q\u0001\ti>\u001cFO]5oOR\t!\r\u0005\u0002dQ6\tAM\u0003\u0002fM\u0006!A.\u00198h\u0015\u00059\u0017\u0001\u00026bm\u0006L!!\u001b3\u0003\rM#(/\u001b8h\u0003\u0011\u0019w\u000e]=\u0016\r1|\u0017o];x)\u0019i\u00070\u001f>|yB9a\u0005\u00018qeR4\bCA\u0017p\t\u0015ySB1\u00011!\ti\u0013\u000fB\u0003:\u001b\t\u0007\u0001\u0007\u0005\u0002.g\u0012)A(\u0004b\u0001aA\u0011Q&\u001e\u0003\u0006\u007f5\u0011\r\u0001\r\t\u0003[]$QAQ\u0007C\u0002ABq!S\u0007\u0011\u0002\u0003\u0007a\u000eC\u0004M\u001bA\u0005\t\u0019\u00019\t\u000f=k\u0001\u0013!a\u0001e\"9!+\u0004I\u0001\u0002\u0004!\bbB+\u000e!\u0003\u0005\rA^\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+-y\u0018QCA\f\u00033\tY\"!\b\u0016\u0005\u0005\u0005!f\u0001\u0017\u0002\u0004-\u0012\u0011Q\u0001\t\u0005\u0003\u000f\t\t\"\u0004\u0002\u0002\n)!\u00111BA\u0007\u0003%)hn\u00195fG.,GMC\u0002\u0002\u0010\u0001\n!\"\u00198o_R\fG/[8o\u0013\u0011\t\u0019\"!\u0003\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW\rB\u00030\u001d\t\u0007\u0001\u0007B\u0003:\u001d\t\u0007\u0001\u0007B\u0003=\u001d\t\u0007\u0001\u0007B\u0003@\u001d\t\u0007\u0001\u0007B\u0003C\u001d\t\u0007\u0001'\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0019\u0005\r\u0012qEA\u0015\u0003W\ti#a\f\u0016\u0005\u0005\u0015\"fA\u001c\u0002\u0004\u0011)qf\u0004b\u0001a\u0011)\u0011h\u0004b\u0001a\u0011)Ah\u0004b\u0001a\u0011)qh\u0004b\u0001a\u0011)!i\u0004b\u0001a\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u001aT\u0003DA\u001b\u0003s\tY$!\u0010\u0002@\u0005\u0005SCAA\u001cU\rQ\u00141\u0001\u0003\u0006_A\u0011\r\u0001\r\u0003\u0006sA\u0011\r\u0001\r\u0003\u0006yA\u0011\r\u0001\r\u0003\u0006\u007fA\u0011\r\u0001\r\u0003\u0006\u0005B\u0011\r\u0001M\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00135+1\t9%a\u0013\u0002N\u0005=\u0013\u0011KA*+\t\tIEK\u0002>\u0003\u0007!QaL\tC\u0002A\"Q!O\tC\u0002A\"Q\u0001P\tC\u0002A\"QaP\tC\u0002A\"QAQ\tC\u0002A\nabY8qs\u0012\"WMZ1vYR$S'\u0006\u0007\u0002Z\u0005u\u0013qLA1\u0003G\n)'\u0006\u0002\u0002\\)\u001a\u0001)a\u0001\u0005\u000b=\u0012\"\u0019\u0001\u0019\u0005\u000be\u0012\"\u0019\u0001\u0019\u0005\u000bq\u0012\"\u0019\u0001\u0019\u0005\u000b}\u0012\"\u0019\u0001\u0019\u0005\u000b\t\u0013\"\u0019\u0001\u0019\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\u0005\u0011\u0017a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\u0005=\u0004#BA9\u0003o\"TBAA:\u0015\r\t)\bI\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA=\u0003g\u0012\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR!\u0011qPAC!\r1\u0013\u0011Q\u0005\u0004\u0003\u0007\u0003#a\u0002\"p_2,\u0017M\u001c\u0005\t\u0003\u000f+\u0012\u0011!a\u0001i\u0005\u0019\u0001\u0010J\u0019\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!$\u0011\u0007\u0019\ny)C\u0002\u0002\u0012\u0002\u00121!\u00138u\u0003\u0019)\u0017/^1mgR!\u0011qPAL\u0011!\t9iFA\u0001\u0002\u0004!\u0014A\u0002+va2,W\u0007\u0005\u0002'3M\u0019\u0011$\n$\u0015\u0005\u0005m\u0015!B1qa2LX\u0003DAS\u0003W\u000by+a-\u00028\u0006mF\u0003DAT\u0003{\u000by,!1\u0002D\u0006\u0015\u0007\u0003\u0004\u0014\u0001\u0003S\u000bi+!-\u00026\u0006e\u0006cA\u0017\u0002,\u0012)q\u0006\bb\u0001aA\u0019Q&a,\u0005\u000beb\"\u0019\u0001\u0019\u0011\u00075\n\u0019\fB\u0003=9\t\u0007\u0001\u0007E\u0002.\u0003o#Qa\u0010\u000fC\u0002A\u00022!LA^\t\u0015\u0011ED1\u00011\u0011\u0019IE\u00041\u0001\u0002*\"1A\n\ba\u0001\u0003[Caa\u0014\u000fA\u0002\u0005E\u0006B\u0002*\u001d\u0001\u0004\t)\f\u0003\u0004V9\u0001\u0007\u0011\u0011X\u0001\bk:\f\u0007\u000f\u001d7z+1\tY-a6\u0002\\\u0006}\u00171]At)\u0011\ti-!;\u0011\u000b\u0019\ny-a5\n\u0007\u0005E\u0007E\u0001\u0004PaRLwN\u001c\t\rM\u0001\t).!7\u0002^\u0006\u0005\u0018Q\u001d\t\u0004[\u0005]G!B\u0018\u001e\u0005\u0004\u0001\u0004cA\u0017\u0002\\\u0012)\u0011(\bb\u0001aA\u0019Q&a8\u0005\u000bqj\"\u0019\u0001\u0019\u0011\u00075\n\u0019\u000fB\u0003@;\t\u0007\u0001\u0007E\u0002.\u0003O$QAQ\u000fC\u0002AB\u0011\"a;\u001e\u0003\u0003\u0005\r!a5\u0002\u0007a$\u0003'A\u0006sK\u0006$'+Z:pYZ,GCAAy!\r\u0019\u00171_\u0005\u0004\u0003k$'AB(cU\u0016\u001cG\u000f")
public final class Tuple5<T1, T2, T3, T4, T5>
implements Product5<T1, T2, T3, T4, T5>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;

    public static <T1, T2, T3, T4, T5> Option<Tuple5<T1, T2, T3, T4, T5>> unapply(Tuple5<T1, T2, T3, T4, T5> tuple5) {
        return Tuple5$.MODULE$.unapply(tuple5);
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5) {
        return Tuple5$.MODULE$.apply(T1, T2, T3, T4, T5);
    }

    @Override
    public int productArity() {
        return Product5.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product5.productElement$(this, n);
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

    public String toString() {
        return new StringBuilder(6).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
        return new Tuple5<T1, T2, T3, T4, T5>(_1, _2, _3, _4, _5);
    }

    public <T1, T2, T3, T4, T5> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5> T5 copy$default$5() {
        return this._5();
    }

    @Override
    public String productPrefix() {
        return "Tuple5";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple5;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple5;
                if (!bl) break block3;
                Tuple5 tuple5 = (Tuple5)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple5._1()) && BoxesRunTime.equals(this._2(), tuple5._2()) && BoxesRunTime.equals(this._3(), tuple5._3()) && BoxesRunTime.equals(this._4(), tuple5._4()) && BoxesRunTime.equals(this._5(), tuple5._5()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple5(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        Product.$init$(this);
        Product5.$init$(this);
    }
}

