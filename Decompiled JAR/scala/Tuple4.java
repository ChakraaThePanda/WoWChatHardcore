/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product4;
import scala.Serializable;
import scala.Tuple4$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005ef\u0001\u0002\u000f\u001e\u0005\u0002B\u0001b\u0011\u0001\u0003\u0016\u0004%\t\u0001\u0012\u0005\t\u000b\u0002\u0011\t\u0012)A\u0005S!Aa\t\u0001BK\u0002\u0013\u0005q\t\u0003\u0005I\u0001\tE\t\u0015!\u00035\u0011!I\u0005A!f\u0001\n\u0003Q\u0005\u0002C&\u0001\u0005#\u0005\u000b\u0011B\u001c\t\u00111\u0003!Q3A\u0005\u00025C\u0001B\u0014\u0001\u0003\u0012\u0003\u0006IA\u000f\u0005\u0006\u001f\u0002!\t\u0001\u0015\u0005\u0006-\u0002!\te\u0016\u0005\bA\u0002\t\t\u0011\"\u0001b\u0011\u001d\u0001\b!%A\u0005\u0002ED\u0011\"a\u0001\u0001#\u0003%\t!!\u0002\t\u0013\u0005M\u0001!%A\u0005\u0002\u0005U\u0001\"CA\u0012\u0001E\u0005I\u0011AA\u0013\u0011%\t\u0019\u0004AA\u0001\n\u0003\n)\u0004C\u0005\u00028\u0001\t\t\u0011\"\u0011\u0002:!I\u0011q\t\u0001\u0002\u0002\u0013\u0005\u0011\u0011\n\u0005\n\u0003+\u0002\u0011\u0011!C!\u0003/B\u0011\"a\u0018\u0001\u0003\u0003%\t%!\u0019\b\u0013\u0005\u0015T$!A\t\u0002\u0005\u001dd\u0001\u0003\u000f\u001e\u0003\u0003E\t!!\u001b\t\r=3B\u0011AA6\u0011\u001d1f#!A\u0005F]C\u0011\"!\u001c\u0017\u0003\u0003%\t)a\u001c\t\u0013\u00055e#!A\u0005\u0002\u0006=\u0005\"CAX-\u0005\u0005I\u0011BAY\u0005\u0019!V\u000f\u001d7fi)\ta$A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u000b\u0005ZS\u0007O\u001e\u0014\u000b\u0001\u0011c%\u0010!\u0011\u0005\r\"S\"A\u000f\n\u0005\u0015j\"AB!osJ+g\r\u0005\u0004$O%\"tGO\u0005\u0003Qu\u0011\u0001\u0002\u0015:pIV\u001cG\u000f\u000e\t\u0003U-b\u0001\u0001\u0002\u0004-\u0001\u0011\u0015\r!\f\u0002\u0003)F\n\"AL\u0019\u0011\u0005\rz\u0013B\u0001\u0019\u001e\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"a\t\u001a\n\u0005Mj\"aA!osB\u0011!&\u000e\u0003\u0007m\u0001!)\u0019A\u0017\u0003\u0005Q\u0013\u0004C\u0001\u00169\t\u0019I\u0004\u0001\"b\u0001[\t\u0011Ak\r\t\u0003Um\"a\u0001\u0010\u0001\u0005\u0006\u0004i#A\u0001+5!\t\u0019c(\u0003\u0002@;\t9\u0001K]8ek\u000e$\bCA\u0012B\u0013\t\u0011UD\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0002`cU\t\u0011&A\u0002`c\u0001\n!a\u0018\u001a\u0016\u0003Q\n1a\u0018\u001a!\u0003\ty6'F\u00018\u0003\ry6\u0007I\u0001\u0003?R*\u0012AO\u0001\u0004?R\u0002\u0013A\u0002\u001fj]&$h\bF\u0003R%N#V\u000b\u0005\u0004$\u0001%\"tG\u000f\u0005\u0006\u0007&\u0001\r!\u000b\u0005\u0006\r&\u0001\r\u0001\u000e\u0005\u0006\u0013&\u0001\ra\u000e\u0005\u0006\u0019&\u0001\rAO\u0001\ti>\u001cFO]5oOR\t\u0001\f\u0005\u0002Z=6\t!L\u0003\u0002\\9\u0006!A.\u00198h\u0015\u0005i\u0016\u0001\u00026bm\u0006L!a\u0018.\u0003\rM#(/\u001b8h\u0003\u0011\u0019w\u000e]=\u0016\u000b\t,w-[6\u0015\u000b\rdWN\\8\u0011\r\r\u0002AM\u001a5k!\tQS\rB\u0003-\u0017\t\u0007Q\u0006\u0005\u0002+O\u0012)ag\u0003b\u0001[A\u0011!&\u001b\u0003\u0006s-\u0011\r!\f\t\u0003U-$Q\u0001P\u0006C\u00025BqaQ\u0006\u0011\u0002\u0003\u0007A\rC\u0004G\u0017A\u0005\t\u0019\u00014\t\u000f%[\u0001\u0013!a\u0001Q\"9Aj\u0003I\u0001\u0002\u0004Q\u0017AD2paf$C-\u001a4bk2$H%M\u000b\u0007evtx0!\u0001\u0016\u0003MT#!\u000b;,\u0003U\u0004\"A^>\u000e\u0003]T!\u0001_=\u0002\u0013Ut7\r[3dW\u0016$'B\u0001>\u001e\u0003)\tgN\\8uCRLwN\\\u0005\u0003y^\u0014\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\t\u0015aCB1\u0001.\t\u00151DB1\u0001.\t\u0015IDB1\u0001.\t\u0015aDB1\u0001.\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uII*\"\"a\u0002\u0002\f\u00055\u0011qBA\t+\t\tIA\u000b\u00025i\u0012)A&\u0004b\u0001[\u0011)a'\u0004b\u0001[\u0011)\u0011(\u0004b\u0001[\u0011)A(\u0004b\u0001[\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u001aTCCA\f\u00037\ti\"a\b\u0002\"U\u0011\u0011\u0011\u0004\u0016\u0003oQ$Q\u0001\f\bC\u00025\"QA\u000e\bC\u00025\"Q!\u000f\bC\u00025\"Q\u0001\u0010\bC\u00025\nabY8qs\u0012\"WMZ1vYR$C'\u0006\u0006\u0002(\u0005-\u0012QFA\u0018\u0003c)\"!!\u000b+\u0005i\"H!\u0002\u0017\u0010\u0005\u0004iC!\u0002\u001c\u0010\u0005\u0004iC!B\u001d\u0010\u0005\u0004iC!\u0002\u001f\u0010\u0005\u0004i\u0013!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001Y\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XCAA\u001e!\u0015\ti$a\u00112\u001b\t\tyDC\u0002\u0002Bu\t!bY8mY\u0016\u001cG/[8o\u0013\u0011\t)%a\u0010\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0003\u0017\n\t\u0006E\u0002$\u0003\u001bJ1!a\u0014\u001e\u0005\u001d\u0011un\u001c7fC:D\u0001\"a\u0015\u0013\u0003\u0003\u0005\r!M\u0001\u0004q\u0012\n\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005e\u0003cA\u0012\u0002\\%\u0019\u0011QL\u000f\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003\u0017\n\u0019\u0007\u0003\u0005\u0002TQ\t\t\u00111\u00012\u0003\u0019!V\u000f\u001d7fiA\u00111EF\n\u0004-\t\u0002ECAA4\u0003\u0015\t\u0007\u000f\u001d7z+)\t\t(a\u001e\u0002|\u0005}\u00141\u0011\u000b\u000b\u0003g\n))a\"\u0002\n\u0006-\u0005CC\u0012\u0001\u0003k\nI(! \u0002\u0002B\u0019!&a\u001e\u0005\u000b1J\"\u0019A\u0017\u0011\u0007)\nY\bB\u000373\t\u0007Q\u0006E\u0002+\u0003\u007f\"Q!O\rC\u00025\u00022AKAB\t\u0015a\u0014D1\u0001.\u0011\u0019\u0019\u0015\u00041\u0001\u0002v!1a)\u0007a\u0001\u0003sBa!S\rA\u0002\u0005u\u0004B\u0002'\u001a\u0001\u0004\t\t)A\u0004v]\u0006\u0004\b\u000f\\=\u0016\u0015\u0005E\u0015QTAQ\u0003K\u000bI\u000b\u0006\u0003\u0002\u0014\u0006-\u0006#B\u0012\u0002\u0016\u0006e\u0015bAAL;\t1q\n\u001d;j_:\u0004\"b\t\u0001\u0002\u001c\u0006}\u00151UAT!\rQ\u0013Q\u0014\u0003\u0006Yi\u0011\r!\f\t\u0004U\u0005\u0005F!\u0002\u001c\u001b\u0005\u0004i\u0003c\u0001\u0016\u0002&\u0012)\u0011H\u0007b\u0001[A\u0019!&!+\u0005\u000bqR\"\u0019A\u0017\t\u0013\u00055&$!AA\u0002\u0005e\u0015a\u0001=%a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\t\u0019\fE\u0002Z\u0003kK1!a.[\u0005\u0019y%M[3di\u0002")
public final class Tuple4<T1, T2, T3, T4>
implements Product4<T1, T2, T3, T4>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;

    public static <T1, T2, T3, T4> Option<Tuple4<T1, T2, T3, T4>> unapply(Tuple4<T1, T2, T3, T4> tuple4) {
        return Tuple4$.MODULE$.unapply(tuple4);
    }

    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> apply(T1 T1, T2 T2, T3 T3, T4 T4) {
        return Tuple4$.MODULE$.apply(T1, T2, T3, T4);
    }

    @Override
    public int productArity() {
        return Product4.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product4.productElement$(this, n);
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

    public String toString() {
        return new StringBuilder(5).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(")").toString();
    }

    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> copy(T1 _1, T2 _2, T3 _3, T4 _4) {
        return new Tuple4<T1, T2, T3, T4>(_1, _2, _3, _4);
    }

    public <T1, T2, T3, T4> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4> T4 copy$default$4() {
        return this._4();
    }

    @Override
    public String productPrefix() {
        return "Tuple4";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple4;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple4;
                if (!bl) break block3;
                Tuple4 tuple4 = (Tuple4)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple4._1()) && BoxesRunTime.equals(this._2(), tuple4._2()) && BoxesRunTime.equals(this._3(), tuple4._3()) && BoxesRunTime.equals(this._4(), tuple4._4()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple4(T1 _1, T2 _2, T3 _3, T4 _4) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        Product.$init$(this);
        Product4.$init$(this);
    }
}

