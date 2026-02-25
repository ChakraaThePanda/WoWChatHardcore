/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.NoSuchElementException;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.AbstractMap;
import scala.collection.immutable.HasForeachEntry;
import scala.collection.immutable.List;
import scala.collection.immutable.ListMap$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001\t}u!\u0002\u001a4\u0011\u0003Qd!\u0002\u001f4\u0011\u0003i\u0004B\u00024\u0002\t\u0003\u0011\t\u0007C\u0004\u0003d\u0005!\u0019A!\u001a\t\u0011\t\u0015\u0015\u0001)A\u0005\u0005\u000fCa\u0001[\u0001\u0005\u0002\t5ua\u0002BN\u0003!%!1\n\u0004\b\u0005\u0007\n\u0001\u0012\u0002B#\u0011\u00191w\u0001\"\u0001\u0003J!I!qJ\u0004\u0002\u0002\u0013%!\u0011\u000b\u0005\n\u0005\u001f\n\u0011\u0011!C\u0005\u0005#2A\u0001P\u001a\u0011\u000b\")am\u0003C\u0001O\")\u0001n\u0003C!S\")1n\u0003C!Y\")\u0001o\u0003C!c\")Qo\u0003C\u0001m\"1Ap\u0003C\u0001guDq!!\u0006\f\t\u0003\n9\u0002C\u0004\u0002\u001a-!\t%a\u0007\t\u000f\u0005=2\u0002\"\u0001\u00022!9\u0011QI\u0006\u0005\u0002\u0005\u001d\u0003bBA&\u0017\u0011\u0005\u0013Q\n\u0005\b\u0003KZA\u0011AA4\u0011\u0019Y8\u0002\"\u0005\u0002r!9\u0011QF\u0006\u0005\u0012\u0005M\u0004bBA;\u0017\u0011E\u0011q\u000f\u0005\b\u0003sZA\u0011IA>\r\u0019\tii\u0003\u0005\u0002\u0010\"I1\u0010\bBC\u0002\u0013E\u0013\u0011\u000f\u0005\n\u00033c\"\u0011!Q\u0001\n)C!\"!\f\u001d\u0005\u000b\u0007I\u0011KAN\u0011)\ti\n\bB\u0001B\u0003%\u0011Q\u0013\u0005\u0007Mr!\t!a(\t\u000b-dB\u0011\t7\t\u0011\u0005%F\u0004)C\u0005\u0003WCQ\u0001\u001d\u000f\u0005BEDq!a1\u001d\t\u0003\n)\r\u0003\u0005\u0002Lr\u0001K\u0011BAg\u0011\u0019)H\u0004\"\u0011\u0002V\"A\u00111\u001c\u000f!\n\u0013\ti\u000eC\u0004\u0002fr!\t%a:\t\u0011\u0005-H\u0004)C\u0005\u0003[Dq!!\u0007\u001d\t\u0003\n)\u0010C\u0004\u00020q!\tE!\u0003\t\u000f\u0005\u0015C\u0004\"\u0011\u0003\u0018!A!1\u0004\u000f!\n\u0013\u0011i\u0002C\u0004\u0002vq!\tF!\f\t\u000f\t=B\u0004\"\u0011\u00032!9!Q\u0007\u000f\u0005B\t5\u0012a\u0002'jgRl\u0015\r\u001d\u0006\u0003iU\n\u0011\"[7nkR\f'\r\\3\u000b\u0005Y:\u0014AC2pY2,7\r^5p]*\t\u0001(A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005m\nQ\"A\u001a\u0003\u000f1K7\u000f^'baN\u0019\u0011A\u00101\u0011\u0007}\u0012E)D\u0001A\u0015\t\tU'A\u0004hK:,'/[2\n\u0005\r\u0003%aE%n[V$\u0018M\u00197f\u001b\u0006\u0004h)Y2u_JL\bCA\u001e\f+\r1EjV\n\u0007\u0017\u001dKF\fY2\u0011\tmB%JV\u0005\u0003\u0013N\u00121\"\u00112tiJ\f7\r^'baB\u00111\n\u0014\u0007\u0001\t\u0015i5B1\u0001O\u0005\u0005\t\u0015CA(T!\t\u0001\u0016+D\u00018\u0013\t\u0011vGA\u0004O_RD\u0017N\\4\u0011\u0005A#\u0016BA+8\u0005\r\te.\u001f\t\u0003\u0017^#a\u0001W\u0006\u0005\u0006\u0004q%!\u0001\"\u0011\tmR&JV\u0005\u00037N\u00121!T1q!\u0015YTL\u0013,`\u0013\tq6GA\u0004NCBd\u0015n[3\u0011\tmZ!J\u0016\t\u0003!\u0006L!AY\u001c\u0003\u0019M+'/[1mSj\f'\r\\3\u0011\tm\"'JV\u0005\u0003KN\u0012q\u0002S1t\r>\u0014X-Y2i\u000b:$(/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003}\u000bQ!Z7qif,\u0012A\u001b\t\u0005w-Qu*\u0001\u0003tSj,W#A7\u0011\u0005As\u0017BA88\u0005\rIe\u000e^\u0001\bSN,U\u000e\u001d;z+\u0005\u0011\bC\u0001)t\u0013\t!xGA\u0004C_>dW-\u00198\u0002\u0007\u001d,G\u000f\u0006\u0002xuB\u0019\u0001\u000b\u001f,\n\u0005e<$AB(qi&|g\u000eC\u0003|!\u0001\u0007!*A\u0002lKf\fABZ8sK\u0006\u001c\u0007.\u00128uef,2A`A\t)\ry\u0018Q\u0001\t\u0004!\u0006\u0005\u0011bAA\u0002o\t!QK\\5u\u0011\u001d\t9!\u0005a\u0001\u0003\u0013\t\u0011A\u001a\t\b!\u0006-!JVA\b\u0013\r\tia\u000e\u0002\n\rVt7\r^5p]J\u00022aSA\t\t\u0019\t\u0019\"\u0005b\u0001\u001d\n\tQ+\u0001\u0005iCND7i\u001c3f)\u0005i\u0017aB;qI\u0006$X\rZ\u000b\u0005\u0003;\t\u0019\u0003\u0006\u0004\u0002 \u0005%\u00121\u0006\t\u0006w-Q\u0015\u0011\u0005\t\u0004\u0017\u0006\rBaBA\u0013'\t\u0007\u0011q\u0005\u0002\u0003\u0005F\n\"AV*\t\u000bm\u001c\u0002\u0019\u0001&\t\u000f\u000552\u00031\u0001\u0002\"\u0005)a/\u00197vK\u0006)A\u0005\u001d7vgV!\u00111GA\u001d)\u0011\t)$a\u000f\u0011\u000bmZ!*a\u000e\u0011\u0007-\u000bI\u0004B\u0004\u0002&Q\u0011\r!a\n\t\u000f\u0005uB\u00031\u0001\u0002@\u0005\u00111N\u001e\t\u0007!\u0006\u0005#*a\u000e\n\u0007\u0005\rsG\u0001\u0004UkBdWMM\u0001\u0007I5Lg.^:\u0015\u0007}\u000bI\u0005C\u0003|+\u0001\u0007!*\u0001\u0006%a2,8\u000f\n9mkN,B!a\u0014\u0002VQ!\u0011\u0011KA,!\u0015Y4BSA*!\rY\u0015Q\u000b\u0003\b\u0003K1\"\u0019AA\u0014\u0011\u001d\tIF\u0006a\u0001\u00037\n!\u0001_:\u0011\r\u0005u\u0013qLA2\u001b\u0005)\u0014bAA1k\t\u0011r)\u001a8Ue\u00064XM]:bE2,wJ\\2f!\u0019\u0001\u0016\u0011\t&\u0002T\u0005A\u0011\u000e^3sCR|'/\u0006\u0002\u0002jA1\u0011QLA6\u0003_J1!!\u001c6\u0005!IE/\u001a:bi>\u0014\b#\u0002)\u0002B)3V#\u0001&\u0016\u0003Y\u000bAA\\3yiV\tq,\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070\u0006\u0002\u0002~A!\u0011qPAE\u001b\t\t\tI\u0003\u0003\u0002\u0004\u0006\u0015\u0015\u0001\u00027b]\u001eT!!a\"\u0002\t)\fg/Y\u0005\u0005\u0003\u0017\u000b\tI\u0001\u0004TiJLgn\u001a\u0002\u0005\u001d>$W-\u0006\u0003\u0002\u0012\u0006]5\u0003\u0002\u000f\u0002\u0014\u0002\u0004RaO\u0006K\u0003+\u00032aSAL\t\u001d\t)\u0003\bb\u0001\u0003O\tAa[3zAU\u0011\u0011QS\u0001\u0007m\u0006dW/\u001a\u0011\u0015\r\u0005\u0005\u0016QUAT!\u0015\t\u0019\u000bHAK\u001b\u0005Y\u0001\"B>\"\u0001\u0004Q\u0005bBA\u0017C\u0001\u0007\u0011QS\u0001\rg&TX-\u00138uKJt\u0017\r\u001c\u000b\u0006[\u00065\u0016\u0011\u0017\u0005\b\u0003_\u001b\u0003\u0019AAJ\u0003\r\u0019WO\u001d\u0005\u0007\u0003g\u001b\u0003\u0019A7\u0002\u0007\u0005\u001c7\rK\u0002$\u0003o\u0003B!!/\u0002@6\u0011\u00111\u0018\u0006\u0004\u0003{;\u0014AC1o]>$\u0018\r^5p]&!\u0011\u0011YA^\u0005\u001d!\u0018-\u001b7sK\u000e\fQ!\u00199qYf$B!!&\u0002H\"1\u0011\u0011Z\u0013A\u0002)\u000b\u0011a[\u0001\u000eCB\u0004H._%oi\u0016\u0014h.\u00197\u0015\r\u0005U\u0015qZAi\u0011\u001d\tyK\na\u0001\u0003'Ca!!3'\u0001\u0004Q\u0005f\u0001\u0014\u00028R!\u0011q[Am!\u0011\u0001\u00060!&\t\r\u0005%w\u00051\u0001K\u0003-9W\r^%oi\u0016\u0014h.\u00197\u0015\r\u0005]\u0017q\\Aq\u0011\u001d\ty\u000b\u000ba\u0001\u0003'Ca!!3)\u0001\u0004Q\u0005f\u0001\u0015\u00028\u0006A1m\u001c8uC&t7\u000fF\u0002s\u0003SDa!!3*\u0001\u0004Q\u0015\u0001E2p]R\f\u0017N\\:J]R,'O\\1m)\u0015\u0011\u0018q^Ay\u0011\u001d\tyK\u000ba\u0001\u0003'Ca!!3+\u0001\u0004Q\u0005f\u0001\u0016\u00028V!\u0011q_A\u007f)\u0019\tIPa\u0001\u0003\u0006A)1h\u0003&\u0002|B\u00191*!@\u0005\u000f\u0005}8F1\u0001\u0003\u0002\t\u0011!IM\t\u0004\u0003+\u001b\u0006BBAeW\u0001\u0007!\nC\u0004\u0003\b-\u0002\r!a?\u0002\u0003Y,BAa\u0003\u0003\u0012Q!!Q\u0002B\n!\u0015Y4B\u0013B\b!\rY%\u0011\u0003\u0003\b\u0003\u007fd#\u0019\u0001B\u0001\u0011\u001d\ti\u0004\fa\u0001\u0005+\u0001b\u0001UA!\u0015\n=A\u0003BAJ\u00053Aa!!3.\u0001\u0004Q\u0015A\u0004:f[>4X-\u00138uKJt\u0017\r\u001c\u000b\t\u0003'\u0013yB!\t\u0003$!1\u0011\u0011\u001a\u0018A\u0002)Cq!a,/\u0001\u0004\t\u0019\nC\u0004\u00024:\u0002\rA!\n\u0011\u000bm\u00129#a%\n\u0007\t%2G\u0001\u0003MSN$\bf\u0001\u0018\u00028V\u0011\u00111S\u0001\u0005Y\u0006\u001cH/\u0006\u0002\u00034A1\u0001+!\u0011K\u0003+\u000bA!\u001b8ji\":AD!\u000f\u0002.\t}\u0002c\u0001)\u0003<%\u0019!QH\u001c\u0003!M+'/[1m-\u0016\u00148/[8o+&#e\u0004\u0003TsGU\n7V@z*\u0007-9AD\u0001\u0007F[B$\u0018\u0010T5ti6\u000b\u0007oE\u0002\b\u0005\u000f\u0002BaO\u0006T\u001fR\u0011!1\n\t\u0004\u0005\u001b:Q\"A\u0001\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0005'\u0002B!a \u0003V%!!qKAA\u0005\u0019y%M[3di\":qA!\u000f\u0002.\tmc\u0004CGk7>\"kC\u0018\b)\u000f-\u0011I$!\f\u0003`yAA!\f1}\u0013SA5\u0016F\u0001;\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0019\u00119G! \u0003\u0002V\u0011!\u0011\u000e\t\n\u007f\t-$q\u000eB=\u0005\u0007K1A!\u001cA\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u0011\u0011iE!\u001d\n\t\tM$Q\u000f\u0002\u0005\u0007>dG.C\u0002\u0003x\u0001\u0013QbR3o\u001b\u0006\u0004h)Y2u_JL\bc\u0002)\u0002B\tm$q\u0010\t\u0004\u0017\nuD!B'\u0004\u0005\u0004q\u0005cA&\u0003\u0002\u0012)\u0001l\u0001b\u0001\u001dB11h\u0003B>\u0005\u007f\n1BU3vg\u0006\u0014G.Z\"C\rB1!Q\nBE'NKAAa#\u0003v\tyQ*\u00199DC:\u0014U/\u001b7e\rJ|W.\u0006\u0004\u0003\u0010\nU%\u0011T\u000b\u0003\u0005#\u0003baO\u0006\u0003\u0014\n]\u0005cA&\u0003\u0016\u0012)Q*\u0002b\u0001\u001dB\u00191J!'\u0005\u000ba+!\u0019\u0001(\u0002\u0019\u0015k\u0007\u000f^=MSN$X*\u00199)\u000f\u0019\u0011I$!\f\u0003\\\u0001")
public class ListMap<A, B>
extends AbstractMap<A, B>
implements Serializable,
HasForeachEntry<A, B> {
    public static final long serialVersionUID = 301002838095710379L;

    public static <A, B> CanBuildFrom<ListMap<?, ?>, Tuple2<A, B>, ListMap<A, B>> canBuildFrom() {
        return ListMap$.MODULE$.canBuildFrom();
    }

    @Override
    public ListMap<A, Nothing$> empty() {
        return ListMap$.MODULE$.empty();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Option<B> get(A key) {
        return None$.MODULE$;
    }

    @Override
    public <U> void foreachEntry(Function2<A, B, U> f) {
        ListMap<A, B> current = this;
        while (!current.isEmpty()) {
            f.apply(current.key(), current.value());
            current = current.next();
        }
    }

    @Override
    public int hashCode() {
        if (this.isEmpty()) {
            return MurmurHash3$.MODULE$.emptyMapHash();
        }
        Map.HashCodeAccumulator hasher = new Map.HashCodeAccumulator();
        this.foreachEntry(hasher);
        return hasher.finalizeHash();
    }

    @Override
    public <B1> ListMap<A, B1> updated(A key, B1 value) {
        return new Node<B1>(this, key, value);
    }

    @Override
    public <B1> ListMap<A, B1> $plus(Tuple2<A, B1> kv) {
        return new Node<B1>(this, kv._1(), kv._2());
    }

    @Override
    public ListMap<A, B> $minus(A key) {
        return this;
    }

    @Override
    public <B1> ListMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        if (xs.isEmpty()) {
            return this;
        }
        ListMap listMap = (ListMap)this.repr();
        return xs.$div$colon(listMap, (Function2<ListMap, Tuple2, ListMap> & java.io.Serializable & Serializable)(x$2, x$3) -> x$2.$plus((Tuple2)x$3));
    }

    @Override
    public Iterator<Tuple2<A, B>> iterator() {
        return this.reverseList$1().iterator();
    }

    public A key() {
        throw new NoSuchElementException("key of empty map");
    }

    public B value() {
        throw new NoSuchElementException("value of empty map");
    }

    public ListMap<A, B> next() {
        throw new NoSuchElementException("next of empty map");
    }

    @Override
    public String stringPrefix() {
        return "ListMap";
    }

    /*
     * WARNING - void declaration
     */
    private final List reverseList$1() {
        void var2_2;
        ListMap<A, B> curr = this;
        List res = Nil$.MODULE$;
        while (!curr.isEmpty()) {
            Tuple2<A, B> tuple2 = new Tuple2<A, B>(curr.key(), curr.value());
            res = res.$colon$colon(tuple2);
            curr = curr.next();
        }
        return var2_2;
    }

    public class Node<B1>
    extends ListMap<A, B1> {
        public static final long serialVersionUID = -6453056603889598734L;
        private final A key;
        private final B1 value;
        public final /* synthetic */ ListMap $outer;

        @Override
        public A key() {
            return this.key;
        }

        @Override
        public B1 value() {
            return this.value;
        }

        @Override
        public int size() {
            return this.sizeInternal(this, 0);
        }

        private int sizeInternal(ListMap<A, B1> cur, int acc) {
            while (!cur.isEmpty()) {
                ++acc;
                cur = cur.next();
            }
            return acc;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public B1 apply(A k) {
            return this.applyInternal(this, k);
        }

        private B1 applyInternal(ListMap<A, B1> cur, A k) {
            while (true) {
                if (cur.isEmpty()) {
                    throw new NoSuchElementException(new StringBuilder(15).append("key not found: ").append(k).toString());
                }
                if (BoxesRunTime.equals(k, cur.key())) {
                    return cur.value();
                }
                cur = cur.next();
            }
        }

        @Override
        public Option<B1> get(A k) {
            return this.getInternal(this, k);
        }

        private Option<B1> getInternal(ListMap<A, B1> cur, A k) {
            while (!cur.isEmpty()) {
                if (BoxesRunTime.equals(k, cur.key())) {
                    return new Some<B1>(cur.value());
                }
                cur = cur.next();
            }
            return None$.MODULE$;
        }

        @Override
        public boolean contains(A k) {
            return this.containsInternal(this, k);
        }

        private boolean containsInternal(ListMap<A, B1> cur, A k) {
            while (!cur.isEmpty()) {
                if (BoxesRunTime.equals(k, cur.key())) {
                    return true;
                }
                cur = cur.next();
            }
            return false;
        }

        @Override
        public <B2> ListMap<A, B2> updated(A k, B2 v) {
            Object m = this.$minus(k);
            return new Node<B2>((ListMap)m, k, v);
        }

        @Override
        public <B2> ListMap<A, B2> $plus(Tuple2<A, B2> kv) {
            Object m = this.$minus(kv._1());
            return new Node<B2>((ListMap)m, kv._1(), kv._2());
        }

        @Override
        public ListMap<A, B1> $minus(A k) {
            return this.removeInternal(k, this, Nil$.MODULE$);
        }

        private ListMap<A, B1> removeInternal(A k, ListMap<A, B1> cur, List<ListMap<A, B1>> acc) {
            while (!cur.isEmpty()) {
                if (BoxesRunTime.equals(k, cur.key())) {
                    ListMap listMap = cur.next();
                    return acc.$div$colon(listMap, (Function2<ListMap, ListMap, ListMap> & java.io.Serializable & Serializable)(x0$1, x1$1) -> {
                        ListMap t = x0$1;
                        ListMap h = x1$1;
                        return new Node(t, h.key(), h.value());
                    });
                }
                acc = acc.$colon$colon(cur);
                cur = cur.next();
            }
            return acc.last();
        }

        @Override
        public ListMap<A, B1> next() {
            return this.scala$collection$immutable$ListMap$Node$$$outer();
        }

        @Override
        public Tuple2<A, B1> last() {
            return new Tuple2(this.key(), this.value());
        }

        @Override
        public ListMap<A, B1> init() {
            return this.next();
        }

        public /* synthetic */ ListMap scala$collection$immutable$ListMap$Node$$$outer() {
            return this.$outer;
        }

        public Node(ListMap $outer, A key, B1 value) {
            this.key = key;
            this.value = value;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

