/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.ListMap$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005e\u0001\u0002\f\u0018\u0001yAQ!\u0010\u0001\u0005\u0002yBQa\u0010\u0001\u0005B\u0001Cq!\u0011\u0001A\u0002\u0013%!\tC\u0004N\u0001\u0001\u0007I\u0011\u0002(\t\rQ\u0003\u0001\u0015)\u0003D\u0011\u001d)\u0006\u00011A\u0005\nYCqA\u0017\u0001A\u0002\u0013%1\f\u0003\u0004^\u0001\u0001\u0006Ka\u0016\u0005\u0006=\u0002!\ta\u0018\u0005\u0006K\u0002!\tA\u001a\u0005\u0006W\u0002!\t\u0001\u001c\u0005\u0006q\u0002!\t!\u001f\u0005\u0006}\u0002!Ia \u0005\b\u0003/\u0001A\u0011IA\r\u0011\u0019\t\t\u0003\u0001C!-\u001e9\u0011QE\f\t\u0002\u0005\u001dbA\u0002\f\u0018\u0011\u0003\tI\u0003\u0003\u0004>#\u0011\u0005\u0011\u0011\b\u0005\b\u0003w\tB1AA\u001f\u0011\u0019y\u0014\u0003\"\u0001\u0002`!I\u0011QN\t\u0002\u0002\u0013%\u0011q\u000e\u0002\b\u0019&\u001cH/T1q\u0015\tA\u0012$A\u0004nkR\f'\r\\3\u000b\u0005iY\u0012AC2pY2,7\r^5p]*\tA$A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0007}1\u0013gE\u0003\u0001AM2$\b\u0005\u0003\"E\u0011\u0002T\"A\f\n\u0005\r:\"aC!cgR\u0014\u0018m\u0019;NCB\u0004\"!\n\u0014\r\u0001\u0011)q\u0005\u0001b\u0001Q\t\t\u0011)\u0005\u0002*[A\u0011!fK\u0007\u00027%\u0011Af\u0007\u0002\b\u001d>$\b.\u001b8h!\tQc&\u0003\u000207\t\u0019\u0011I\\=\u0011\u0005\u0015\nD!\u0002\u001a\u0001\u0005\u0004A#!\u0001\"\u0011\t\u0005\"D\u0005M\u0005\u0003k]\u00111!T1q!\u0015\ts\u0007\n\u0019:\u0013\tAtCA\u0004NCBd\u0015n[3\u0011\t\u0005\u0002A\u0005\r\t\u0003UmJ!\u0001P\u000e\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\u0005I\u0014!B3naRLX#A\u001d\u0002\u000b\u0015dW-\\:\u0016\u0003\r\u00032\u0001R$K\u001d\tQS)\u0003\u0002G7\u00059\u0001/Y2lC\u001e,\u0017B\u0001%J\u0005\u0011a\u0015n\u001d;\u000b\u0005\u0019[\u0002\u0003\u0002\u0016LIAJ!\u0001T\u000e\u0003\rQ+\b\u000f\\33\u0003%)G.Z7t?\u0012*\u0017\u000f\u0006\u0002P%B\u0011!\u0006U\u0005\u0003#n\u0011A!\u00168ji\"91\u000bBA\u0001\u0002\u0004\u0019\u0015a\u0001=%c\u00051Q\r\\3ng\u0002\n1a]5{+\u00059\u0006C\u0001\u0016Y\u0013\tI6DA\u0002J]R\fqa]5{?\u0012*\u0017\u000f\u0006\u0002P9\"91kBA\u0001\u0002\u00049\u0016\u0001B:ju\u0002\n1aZ3u)\t\u00017\rE\u0002+CBJ!AY\u000e\u0003\r=\u0003H/[8o\u0011\u0015!\u0017\u00021\u0001%\u0003\rYW-_\u0001\tSR,'/\u0019;peV\tq\rE\u0002iS*k\u0011!G\u0005\u0003Uf\u0011\u0001\"\u0013;fe\u0006$xN]\u0001\tIAdWo\u001d\u0013fcR\u0011QN\\\u0007\u0002\u0001!)qn\u0003a\u0001\u0015\u0006\u00111N\u001e\u0015\u0005\u0017E$h\u000f\u0005\u0002+e&\u00111o\u0007\u0002\u0015I\u0016\u0004(/Z2bi\u0016$wJ^3se&$\u0017N\\4\"\u0003U\fqKT8!g\u0016t7/\u001b2mK\u0002:\u0018-\u001f\u0011u_\u0002zg/\u001a:sS\u0012,\u0007eK\u001f!CN\u0004\u0003O]5wCR,\u0007E]3n_Z,\u0007%[:!kN,G\rI5oA5,H\u000e^5qY\u0016\u0004\u0003\u000f\\1dKN\u0004\u0013N\u001c;fe:\fG\u000e\\=/C\u00059\u0018A\u0002\u001a/cEr\u0003'A\u0005%[&tWo\u001d\u0013fcR\u0011QN\u001f\u0005\u0006I2\u0001\r\u0001\n\u0015\u0005\u0019Edh/I\u0001~\u0003]su\u000eI:f]NL'\r\\3!o\u0006L\b\u0005^8!_Z,'O]5eK\u0002jS\bI1tAA\u0014\u0018N^1uK\u0002\u0012X-\\8wK\u0002J7\u000fI;tK\u0012\u0004\u0013N\u001c\u0011nk2$\u0018\u000e\u001d7fAAd\u0017mY3tA%tG/\u001a:oC2d\u0017PL\u0001\u0007e\u0016lwN^3\u0015\u000f\r\u000b\t!a\u0001\u0002\u0006!)A-\u0004a\u0001I!)\u0011)\u0004a\u0001\u0007\"1\u0011qA\u0007A\u0002\r\u000b1!Y2dQ\ri\u00111\u0002\t\u0005\u0003\u001b\t\u0019\"\u0004\u0002\u0002\u0010)\u0019\u0011\u0011C\u000e\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002\u0016\u0005=!a\u0002;bS2\u0014XmY\u0001\u0006G2,\u0017M\u001d\u000b\u0002\u001f\"*a\"]A\u000fm\u0006\u0012\u0011qD\u0001Y\u001d>\u00043/\u001a8tS\ndW\rI<bs\u0002\"x\u000eI8wKJ\u0014\u0018\u000eZ3!CN\u0004C\u000f[5tA\u0019,hn\u0019;j_:\fG.\u001b;zAI,G.[3tAU\u0004xN\u001c\u0011bG\u000e,7o\u001d\u0011u_\u0002\u0002(/\u001b<bi\u0016\u0004S.\u001a;i_\u0012\u001ch&\u0001\u0003tSj,\u0007&B\br\u0003;1\u0018a\u0002'jgRl\u0015\r\u001d\t\u0003CE\u0019B!EA\u0016uA1\u0011QFA\u001a\u0003oi!!a\f\u000b\u0007\u0005E\u0012$A\u0004hK:,'/[2\n\t\u0005U\u0012q\u0006\u0002\u0012\u001bV$\u0018M\u00197f\u001b\u0006\u0004h)Y2u_JL\bCA\u0011\u0001)\t\t9#\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0004\u0002@\u0005]\u00131L\u000b\u0003\u0003\u0003\u0002\"\"!\f\u0002D\u0005\u001d\u00131KA/\u0013\u0011\t)%a\f\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\t\u0005%\u00131J\u0007\u0002#%!\u0011QJA(\u0005\u0011\u0019u\u000e\u001c7\n\t\u0005E\u0013q\u0006\u0002\u000e\u000f\u0016tW*\u00199GC\u000e$xN]=\u0011\r)Z\u0015QKA-!\r)\u0013q\u000b\u0003\u0006OM\u0011\r\u0001\u000b\t\u0004K\u0005mC!\u0002\u001a\u0014\u0005\u0004A\u0003CB\u0011\u0001\u0003+\nI&\u0006\u0004\u0002b\u0005\u001d\u00141N\u000b\u0003\u0003G\u0002b!\t\u0001\u0002f\u0005%\u0004cA\u0013\u0002h\u0011)q\u0005\u0006b\u0001QA\u0019Q%a\u001b\u0005\u000bI\"\"\u0019\u0001\u0015\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0003c\u0002B!a\u001d\u0002~5\u0011\u0011Q\u000f\u0006\u0005\u0003o\nI(\u0001\u0003mC:<'BAA>\u0003\u0011Q\u0017M^1\n\t\u0005}\u0014Q\u000f\u0002\u0007\u001f\nTWm\u0019;")
public class ListMap<A, B>
extends AbstractMap<A, B>
implements Serializable {
    private List<Tuple2<A, B>> elems = Nil$.MODULE$;
    private int siz = 0;

    public static <A, B> CanBuildFrom<ListMap<?, ?>, Tuple2<A, B>, ListMap<A, B>> canBuildFrom() {
        return ListMap$.MODULE$.canBuildFrom();
    }

    @Override
    public ListMap<A, B> empty() {
        return ListMap$.MODULE$.empty();
    }

    private List<Tuple2<A, B>> elems() {
        return this.elems;
    }

    private void elems_$eq(List<Tuple2<A, B>> x$1) {
        this.elems = x$1;
    }

    private int siz() {
        return this.siz;
    }

    private void siz_$eq(int x$1) {
        this.siz = x$1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Option<B> get(A key) {
        void find_p;
        List<Tuple2<A, B>> list = this.elems();
        Function1<Tuple2, Object> & java.io.Serializable & Serializable intersect = (Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(ListMap.$anonfun$get$1(key, x$1));
        if (list == null) {
            throw null;
        }
        Option option = LinearSeqOptimized.find$(list, (Function1)find_p);
        if (option == null) {
            throw null;
        }
        if (option.isEmpty()) {
            return None$.MODULE$;
        }
        return new Some<Object>(((Tuple2)option.get())._2());
    }

    @Override
    public Iterator<Tuple2<A, B>> iterator() {
        return this.elems().iterator();
    }

    @Override
    public ListMap<A, B> $plus$eq(Tuple2<A, B> kv) {
        this.elems_$eq(this.remove(kv._1(), this.elems(), Nil$.MODULE$));
        this.elems_$eq(this.elems().$colon$colon(kv));
        this.siz_$eq(this.siz() + 1);
        return this;
    }

    public ListMap<A, B> $minus$eq(A key) {
        this.elems_$eq(this.remove(key, this.elems(), Nil$.MODULE$));
        return this;
    }

    private List<Tuple2<A, B>> remove(A key, List<Tuple2<A, B>> elems, List<Tuple2<A, B>> acc) {
        while (!elems.isEmpty()) {
            if (BoxesRunTime.equals(elems.head()._1(), key)) {
                this.siz_$eq(this.siz() - 1);
                return ((List)elems.tail()).$colon$colon$colon(acc);
            }
            Tuple2<A, B> tuple2 = elems.head();
            acc = acc.$colon$colon(tuple2);
            elems = (List)elems.tail();
        }
        return acc;
    }

    @Override
    public void clear() {
        this.elems_$eq(Nil$.MODULE$);
        this.siz_$eq(0);
    }

    @Override
    public int size() {
        return this.siz();
    }

    public static final /* synthetic */ boolean $anonfun$get$1(Object key$1, Tuple2 x$1) {
        return BoxesRunTime.equals(x$1._1(), key$1);
    }
}

