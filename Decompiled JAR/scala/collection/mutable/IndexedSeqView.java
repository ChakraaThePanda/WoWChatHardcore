/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Predef$;
import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.IterableViewLike;
import scala.collection.Iterator;
import scala.collection.SeqView;
import scala.collection.SeqViewLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.SliceInterval;
import scala.collection.generic.SliceInterval$;
import scala.collection.immutable.List;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqView$;
import scala.collection.mutable.Iterable;
import scala.collection.mutable.Seq;
import scala.collection.mutable.SeqLike;
import scala.collection.mutable.Traversable;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSeq;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\t-daB\u00193!\u0003\r\t!\u000f\u0005\u00069\u0002!\t!X\u0003\u0007C\u0002\u0001\u000b\u0011B)\t\u000b\t\u0004a\u0011A2\u0007\u000f-\u0004\u0001\u0013aA\u0001Y\")A\f\u0002C\u0001;\")!\r\u0002D\u0001k\")\u0001\u0010\u0002C!s\u001aA\u0011Q\u0001\u0001\u0002\u0002Q\n9\u0001C\u0004\u0002\u0016!!\t!a\u0006\u0007\u0013\u0005m\u0001\u0001%A\u0002\u0002\u0005u\u0001\"\u0002/\u000b\t\u0003i\u0006bBA\u0013\u0015\u0011\u0005\u0013q\u0005\u0005\u0007E*!\t!!\u000b\u0007\u0013\u0005=\u0002\u0001%A\u0002\u0002\u0005E\u0002\"\u0002/\u000f\t\u0003i\u0006B\u00022\u000f\t\u0003\t9DB\u0005\u0002>\u0001\u0001\n1!\u0001\u0002@!)A,\u0005C\u0001;\"1!-\u0005C\u0001\u0003\u000b2\u0011\"a\u0013\u0001!\u0003\r\t!!\u0014\t\u000bq#B\u0011A/\t\r\t$B\u0011AA*\r%\tI\u0006\u0001I\u0001\u0004\u0003\tY\u0006C\u0003]/\u0011\u0005Q\f\u0003\u0004c/\u0011\u0005\u0011\u0011\r\u0005\b\u0003O\u0002A\u0011KA5\u0011\u001d\tY\b\u0001C)\u0003{Bq!a$\u0001\t#\n\t\nC\u0004\u0002\u0016\u0002!\t&a&\t\u000f\u0005m\u0005\u0001\"\u0015\u0002\u001e\"9\u0011q\u0014\u0001\u0005B\u0005\u0005\u0006bBAT\u0001\u0011\u0005\u0013\u0011\u0016\u0005\b\u0003W\u0003A\u0011IAW\u0011\u001d\t\u0019\f\u0001C!\u0003kCq!!/\u0001\t\u0003\nY\fC\u0004\u0002F\u0002!\t%a2\t\u000f\u0005-\u0007\u0001\"\u0011\u0002N\"9\u0011\u0011\u001b\u0001\u0005B\u0005M\u0007bBAo\u0001\u0011\u0005\u0013q\u001c\u0005\b\u0003G\u0004A\u0011IAU\u0011\u001d\t)\u000f\u0001C!\u0003ODa\"!;\u0001!\u0003\r\t\u0011!C\u0005\u0003O\fYoB\u0004\u0002rJB\t!a=\u0007\rE\u0012\u0004\u0012AA{\u0011\u001d\t)\u0002\fC\u0001\u0003o,Q\u0001\u0016\u0017\u0001\u0003sDqAa\b-\t\u0007\u0011\t\u0003C\u0004\u0003D1\"\u0019A!\u0012\u0003\u001d%sG-\u001a=fIN+\u0017OV5fo*\u00111\u0007N\u0001\b[V$\u0018M\u00197f\u0015\t)d'\u0001\u0006d_2dWm\u0019;j_:T\u0011aN\u0001\u0006g\u000e\fG.Y\u0002\u0001+\rQTiU\n\u0007\u0001mzd*V-\u0011\u0005qjT\"\u0001\u001c\n\u0005y2$AB!osJ+g\rE\u0002A\u0003\u000ek\u0011AM\u0005\u0003\u0005J\u0012!\"\u00138eKb,GmU3r!\t!U\t\u0004\u0001\u0005\u000b\u0019\u0003!\u0019A$\u0003\u0003\u0005\u000b\"\u0001S&\u0011\u0005qJ\u0015B\u0001&7\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u0010'\n\u000553$aA!osB!\u0001iT\"R\u0013\t\u0001&GA\nJ]\u0012,\u00070\u001a3TKF|\u0005\u000f^5nSj,G\r\u0005\u0003A\u0001\r\u0013\u0006C\u0001#T\t\u0019!\u0006\u0001\"b\u0001\u000f\n!1i\u001c7m!\u00111vk\u0011*\u000e\u0003QJ!\u0001\u0017\u001b\u0003\u000fM+\u0017OV5foB)aKW\"S#&\u00111\f\u000e\u0002\f'\u0016\fh+[3x\u0019&\\W-\u0001\u0004%S:LG\u000f\n\u000b\u0002=B\u0011AhX\u0005\u0003AZ\u0012A!\u00168ji\n!A\u000b[5t\u0003\u0019)\b\u000fZ1uKR\u0019a\fZ5\t\u000b\u0015\u001c\u0001\u0019\u00014\u0002\u0007%$\u0007\u0010\u0005\u0002=O&\u0011\u0001N\u000e\u0002\u0004\u0013:$\b\"\u00026\u0004\u0001\u0004\u0019\u0015\u0001B3mK6\u00141\u0002\u0016:b]N4wN]7fIV\u0011Q\u000e]\n\u0005\tmr'\u000f\u0005\u0003A\u0001=\u0014\u0006C\u0001#q\t\u0015\tHA1\u0001H\u0005\u0005\u0011\u0005cA:u_6\t\u0001!\u0003\u0002l5R\u0019aL^<\t\u000b\u00154\u0001\u0019\u00014\t\u000b)4\u0001\u0019A8\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012A\u001f\t\u0004w\u0006\u0005Q\"\u0001?\u000b\u0005ut\u0018\u0001\u00027b]\u001eT\u0011a`\u0001\u0005U\u00064\u0018-C\u0002\u0002\u0004q\u0014aa\u0015;sS:<'aE!cgR\u0014\u0018m\u0019;Ue\u0006t7OZ8s[\u0016$W\u0003BA\u0005\u0003#\u0019R\u0001CA\u0006\u0003'\u0001Ra]A\u0007\u0003\u001fI1!!\u0002[!\r!\u0015\u0011\u0003\u0003\u0006c\"\u0011\ra\u0012\t\u0005g\u0012\ty!\u0001\u0004=S:LGO\u0010\u000b\u0003\u00033\u0001Ba\u001d\u0005\u0002\u0010\t11\u000b\\5dK\u0012\u001cbAC\u001e\u0002 \u0005\r\u0002cA:\u0002\"%\u0019\u00111\u0004.\u0011\u0007M$1)\u0001\u0004mK:<G\u000f[\u000b\u0002MR)a,a\u000b\u0002.!)Q-\u0004a\u0001M\")!.\u0004a\u0001\u0007\nAa)\u001b7uKJ,Gm\u0005\u0004\u000fw\u0005M\u00121\u0005\t\u0004g\u0006U\u0012bAA\u00185R)a,!\u000f\u0002<!)Q\r\u0005a\u0001M\")!\u000e\u0005a\u0001\u0007\nQA+Y6f]^C\u0017\u000e\\3\u0014\rEY\u0014\u0011IA\u0012!\r\u0019\u00181I\u0005\u0004\u0003{QF#\u00020\u0002H\u0005%\u0003\"B3\u0014\u0001\u00041\u0007\"\u00026\u0014\u0001\u0004\u0019%\u0001\u0004#s_B\u0004X\rZ,iS2,7C\u0002\u000b<\u0003\u001f\n\u0019\u0003E\u0002t\u0003#J1!a\u0013[)\u0015q\u0016QKA,\u0011\u0015)g\u00031\u0001g\u0011\u0015Qg\u00031\u0001D\u0005!\u0011VM^3sg\u0016$7CB\f<\u0003;\n\u0019\u0003E\u0002t\u0003?J1!!\u0017[)\u0015q\u00161MA3\u0011\u0015)\u0017\u00041\u0001g\u0011\u0015Q\u0017\u00041\u0001D\u0003-qWm\u001e$jYR,'/\u001a3\u0015\t\u0005\r\u00121\u000e\u0005\b\u0003[R\u0002\u0019AA8\u0003\u0005\u0001\bC\u0002\u001f\u0002r\r\u000b)(C\u0002\u0002tY\u0012\u0011BR;oGRLwN\\\u0019\u0011\u0007q\n9(C\u0002\u0002zY\u0012qAQ8pY\u0016\fg.A\u0005oK^\u001cF.[2fIR!\u00111EA@\u0011\u001d\t\ti\u0007a\u0001\u0003\u0007\u000b!bX3oIB|\u0017N\u001c;t!\u0011\t))a#\u000e\u0005\u0005\u001d%bAAEi\u00059q-\u001a8fe&\u001c\u0017\u0002BAG\u0003\u000f\u0013Qb\u00157jG\u0016Le\u000e^3sm\u0006d\u0017a\u00048fo\u0012\u0013x\u000e\u001d9fI^C\u0017\u000e\\3\u0015\t\u0005\r\u00121\u0013\u0005\b\u0003[b\u0002\u0019AA8\u00035qWm\u001e+bW\u0016tw\u000b[5mKR!\u00111EAM\u0011\u001d\ti'\ba\u0001\u0003_\n1B\\3x%\u00164XM]:fIV\u0011\u00111E\u0001\u0007M&dG/\u001a:\u0015\t\u0005\r\u0016Q\u0015\t\u0003g\nAq!!\u001c \u0001\u0004\ty'\u0001\u0003j]&$XCAAR\u0003\u0011!'o\u001c9\u0015\t\u0005\r\u0016q\u0016\u0005\u0007\u0003c\u000b\u0003\u0019\u00014\u0002\u00039\fA\u0001^1lKR!\u00111UA\\\u0011\u0019\t\tL\ta\u0001M\u0006)1\u000f\\5dKR1\u00111UA_\u0003\u0003Da!a0$\u0001\u00041\u0017\u0001\u00024s_6Da!a1$\u0001\u00041\u0017!B;oi&d\u0017!\u00033s_B<\u0006.\u001b7f)\u0011\t\u0019+!3\t\u000f\u00055D\u00051\u0001\u0002p\u0005IA/Y6f/\"LG.\u001a\u000b\u0005\u0003G\u000by\rC\u0004\u0002n\u0015\u0002\r!a\u001c\u0002\tM\u0004\u0018M\u001c\u000b\u0005\u0003+\fY\u000eE\u0004=\u0003/\f\u0019+a)\n\u0007\u0005egG\u0001\u0004UkBdWM\r\u0005\b\u0003[2\u0003\u0019AA8\u0003\u001d\u0019\b\u000f\\5u\u0003R$B!!6\u0002b\"1\u0011\u0011W\u0014A\u0002\u0019\fqA]3wKJ\u001cX-\u0001\u0003uC&dW#A)\u0002\u0015M,\b/\u001a:%i\u0006LG.\u0003\u0003\u0002f\u00065\u0018bAAxi\t\u0019BK]1wKJ\u001c\u0018M\u00197f-&,w\u000fT5lK\u0006q\u0011J\u001c3fq\u0016$7+Z9WS\u0016<\bC\u0001!-'\ta3\b\u0006\u0002\u0002tB2\u00111 B\u0005\u0005\u0007\u0001rAVA\u007f\u0005\u0003\u00119!C\u0002\u0002\u0000R\u0012q\u0002\u0016:bm\u0016\u00148/\u00192mKZKWm\u001e\t\u0004\t\n\rAA\u0003B\u0003]\u0005\u0005\t\u0011!B\u0001\u000f\n\u0019q\fJ\u0019\u0011\u0007\u0011\u0013I\u0001B\u0006\u0003\f9\n\t\u0011!A\u0003\u0002\t5!!A\"\u0012\u0007!\u0013y\u0001\r\u0003\u0003\u0012\te\u0001#\u0002!\u0003\u0014\t]\u0011b\u0001B\u000be\tYAK]1wKJ\u001c\u0018M\u00197f!\r!%\u0011\u0004\u0003\f\u00057\u0011i\"!A\u0001\u0002\u000b\u0005qIA\u0002`II\"1Ba\u0003/\u0003\u0003\u0005\tQ!\u0001\u0003\u000e\u0005a1-\u00198Ck&dGM\u0012:p[V!!1\u0005B\u0019+\t\u0011)\u0003\u0005\u0006\u0002\u0006\n\u001d\"1\u0006B\u0018\u0005gIAA!\u000b\u0002\b\na1)\u00198Ck&dGM\u0012:p[B\u0019!Q\u0006\u0018\u000e\u00031\u00022\u0001\u0012B\u0019\t\u00151uF1\u0001H!\u00191vKa\f\u00036A\"!q\u0007B !\u0015\u0001%\u0011\bB\u001f\u0013\r\u0011YD\r\u0002\u0004'\u0016\f\bc\u0001#\u0003@\u0011Q!\u0011I\u0018\u0002\u0002\u0003\u0005)\u0011A$\u0003\u0007}#3'A\bbeJ\u001c\u0015M\u001c\"vS2$gI]8n+\u0011\u00119E!\u001a\u0016\u0005\t%\u0003CCAC\u0005O\u0011YEa\u0019\u0003hA\"!Q\nB)!\u001d1\u0016Q B(\u0005+\u00022\u0001\u0012B)\t)\u0011\u0019\u0006MA\u0001\u0002\u0003\u0015\ta\u0012\u0002\u0004?\u0012*\u0004\u0007\u0002B,\u0005?\u0002R\u0001\u0010B-\u0005;J1Aa\u00177\u0005\u0015\t%O]1z!\r!%q\f\u0003\u000b\u0005C\u0002\u0014\u0011!A\u0001\u0006\u00039%aA0%mA\u0019AI!\u001a\u0005\u000b\u0019\u0003$\u0019A$\u0011\rY;&1\rB5!\u0015a$\u0011\fB2\u0001")
public interface IndexedSeqView<A, Coll>
extends IndexedSeq<A>,
scala.collection.mutable.IndexedSeqOptimized<A, IndexedSeqView<A, Coll>>,
SeqView<A, Coll> {
    public static <A> CanBuildFrom<TraversableView<?, Object>, A, SeqView<A, Object>> arrCanBuildFrom() {
        return IndexedSeqView$.MODULE$.arrCanBuildFrom();
    }

    public static <A> CanBuildFrom<TraversableView<?, ? extends Traversable<?>>, A, SeqView<A, Seq<?>>> canBuildFrom() {
        return IndexedSeqView$.MODULE$.canBuildFrom();
    }

    public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$$super$tail();

    @Override
    public void update(int var1, A var2);

    @Override
    default public Transformed<A> newFiltered(Function1<A, Object> p) {
        return new Filtered(this, p){
            private final Function1<A, Object> pred;
            private int[] index;
            private volatile boolean bitmap$0;
            private final /* synthetic */ IndexedSeqView $outer;

            public void update(int idx, A elem) {
                Filtered.update$(this, idx, elem);
            }

            public int length() {
                return SeqViewLike.Filtered.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.Filtered.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.Filtered.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.Filtered.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Filtered.viewIdentifier$(this);
            }

            private int[] index$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.index = SeqViewLike.Filtered.index$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.index;
            }

            public int[] index() {
                if (!this.bitmap$0) {
                    return this.index$lzycompute();
                }
                return this.index;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Filtered$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$1;
                super($outer);
                TraversableViewLike.Filtered.$init$(this);
                IterableViewLike.Filtered.$init$(this);
                SeqViewLike.Filtered.$init$(this);
                Filtered.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newSliced(SliceInterval _endpoints) {
        return new Sliced(this, _endpoints){
            private final SliceInterval endpoints;
            private final /* synthetic */ IndexedSeqView $outer;

            public int length() {
                return Sliced.length$(this);
            }

            public void update(int idx, A elem) {
                Sliced.update$(this, idx, elem);
            }

            public Object apply(int idx) {
                return SeqViewLike.Sliced.apply$(this, idx);
            }

            public <U> void foreach(Function1<Object, U> f) {
                SeqViewLike.Sliced.foreach$(this, f);
            }

            public Iterator<Object> iterator() {
                return SeqViewLike.Sliced.iterator$(this);
            }

            public int from() {
                return TraversableViewLike.Sliced.from$(this);
            }

            public int until() {
                return TraversableViewLike.Sliced.until$(this);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Sliced.viewIdentifier$(this);
            }

            public SliceInterval endpoints() {
                return this.endpoints;
            }

            public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Sliced$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.endpoints = _endpoints$1;
                super($outer);
                TraversableViewLike.Sliced.$init$(this);
                IterableViewLike.Sliced.$init$(this);
                SeqViewLike.Sliced.$init$(this);
                Sliced.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newDroppedWhile(Function1<A, Object> p) {
        return new DroppedWhile(this, p){
            private final Function1<A, Object> pred;
            private int start;
            private volatile boolean bitmap$0;
            private final /* synthetic */ IndexedSeqView $outer;

            public void update(int idx, A elem) {
                DroppedWhile.update$(this, idx, elem);
            }

            public int length() {
                return SeqViewLike.DroppedWhile.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.DroppedWhile.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.DroppedWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.DroppedWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.DroppedWhile.viewIdentifier$(this);
            }

            private int start$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.start = SeqViewLike.DroppedWhile.start$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.start;
            }

            public int start() {
                if (!this.bitmap$0) {
                    return this.start$lzycompute();
                }
                return this.start;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$2;
                super($outer);
                TraversableViewLike.DroppedWhile.$init$(this);
                IterableViewLike.DroppedWhile.$init$(this);
                SeqViewLike.DroppedWhile.$init$(this);
                DroppedWhile.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newTakenWhile(Function1<A, Object> p) {
        return new TakenWhile(this, p){
            private final Function1<A, Object> pred;
            private int len;
            private volatile boolean bitmap$0;
            private final /* synthetic */ IndexedSeqView $outer;

            public void update(int idx, A elem) {
                TakenWhile.update$(this, idx, elem);
            }

            public int length() {
                return SeqViewLike.TakenWhile.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.TakenWhile.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.TakenWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.TakenWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.TakenWhile.viewIdentifier$(this);
            }

            private int len$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.len = SeqViewLike.TakenWhile.len$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.len;
            }

            public int len() {
                if (!this.bitmap$0) {
                    return this.len$lzycompute();
                }
                return this.len;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$3;
                super($outer);
                TraversableViewLike.TakenWhile.$init$(this);
                IterableViewLike.TakenWhile.$init$(this);
                SeqViewLike.TakenWhile.$init$(this);
                TakenWhile.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newReversed() {
        return new Reversed(this){
            private final /* synthetic */ IndexedSeqView $outer;

            public void update(int idx, A elem) {
                Reversed.update$(this, idx, elem);
            }

            public Iterator<Object> iterator() {
                return SeqViewLike.Reversed.iterator$(this);
            }

            public int length() {
                return SeqViewLike.Reversed.length$(this);
            }

            public Object apply(int idx) {
                return SeqViewLike.Reversed.apply$(this, idx);
            }

            public final String viewIdentifier() {
                return SeqViewLike.Reversed.viewIdentifier$(this);
            }

            public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Reversed$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Reversed$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super($outer);
                SeqViewLike.Reversed.$init$(this);
                Reversed.$init$(this);
            }
        };
    }

    @Override
    default public IndexedSeqView<A, Coll> filter(Function1<A, Object> p) {
        return this.newFiltered(p);
    }

    @Override
    default public IndexedSeqView<A, Coll> init() {
        return this.newSliced(SliceInterval$.MODULE$.apply(0, this.length() - 1));
    }

    @Override
    default public IndexedSeqView<A, Coll> drop(int n) {
        return this.newSliced(SliceInterval$.MODULE$.apply(n, this.length()));
    }

    @Override
    default public IndexedSeqView<A, Coll> take(int n) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return this.newSliced(SliceInterval$.MODULE$.apply(0, RichInt$.MODULE$.min$extension(n, this.length())));
    }

    @Override
    default public IndexedSeqView<A, Coll> slice(int from, int until) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return this.newSliced(SliceInterval$.MODULE$.apply(from, RichInt$.MODULE$.min$extension(until, this.length())));
    }

    @Override
    default public IndexedSeqView<A, Coll> dropWhile(Function1<A, Object> p) {
        return this.newDroppedWhile(p);
    }

    @Override
    default public IndexedSeqView<A, Coll> takeWhile(Function1<A, Object> p) {
        return this.newTakenWhile(p);
    }

    @Override
    default public Tuple2<IndexedSeqView<A, Coll>, IndexedSeqView<A, Coll>> span(Function1<A, Object> p) {
        return new Tuple2<IndexedSeqView<A, Coll>, IndexedSeqView<A, Coll>>(this.newTakenWhile(p), this.newDroppedWhile(p));
    }

    @Override
    default public Tuple2<IndexedSeqView<A, Coll>, IndexedSeqView<A, Coll>> splitAt(int n) {
        return new Tuple2<IndexedSeqView<A, Coll>, IndexedSeqView<A, Coll>>(this.take(n), this.drop(n));
    }

    @Override
    default public IndexedSeqView<A, Coll> reverse() {
        return this.newReversed();
    }

    @Override
    default public IndexedSeqView<A, Coll> tail() {
        if (this.isEmpty()) {
            return this.scala$collection$mutable$IndexedSeqView$$super$tail();
        }
        return this.slice(1, this.length());
    }

    public static void $init$(IndexedSeqView $this) {
    }

    public abstract class AbstractTransformed<B>
    extends SeqViewLike.AbstractTransformed<B>
    implements Transformed<B> {
        @Override
        public String toString() {
            return ((Transformed)this).toString();
        }

        @Override
        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$$super$tail() {
            return (IndexedSeqView)IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Transformed<B> newFiltered(Function1<B, Object> p) {
            return ((IndexedSeqView)this).newFiltered(p);
        }

        @Override
        public Transformed<B> newSliced(SliceInterval _endpoints) {
            return ((IndexedSeqView)this).newSliced(_endpoints);
        }

        @Override
        public Transformed<B> newDroppedWhile(Function1<B, Object> p) {
            return ((IndexedSeqView)this).newDroppedWhile(p);
        }

        @Override
        public Transformed<B> newTakenWhile(Function1<B, Object> p) {
            return ((IndexedSeqView)this).newTakenWhile(p);
        }

        @Override
        public Transformed<B> newReversed() {
            return ((IndexedSeqView)this).newReversed();
        }

        @Override
        public IndexedSeqView<B, Coll> filter(Function1<B, Object> p) {
            return ((IndexedSeqView)this).filter(p);
        }

        @Override
        public IndexedSeqView<B, Coll> init() {
            return ((IndexedSeqView)this).init();
        }

        @Override
        public IndexedSeqView<B, Coll> drop(int n) {
            return ((IndexedSeqView)this).drop(n);
        }

        @Override
        public IndexedSeqView<B, Coll> take(int n) {
            return ((IndexedSeqView)this).take(n);
        }

        @Override
        public IndexedSeqView<B, Coll> slice(int from, int until) {
            return ((IndexedSeqView)this).slice(from, until);
        }

        @Override
        public IndexedSeqView<B, Coll> dropWhile(Function1<B, Object> p) {
            return ((IndexedSeqView)this).dropWhile(p);
        }

        @Override
        public IndexedSeqView<B, Coll> takeWhile(Function1<B, Object> p) {
            return ((IndexedSeqView)this).takeWhile(p);
        }

        @Override
        public Tuple2<IndexedSeqView<B, Coll>, IndexedSeqView<B, Coll>> span(Function1<B, Object> p) {
            return ((IndexedSeqView)this).span(p);
        }

        @Override
        public Tuple2<IndexedSeqView<B, Coll>, IndexedSeqView<B, Coll>> splitAt(int n) {
            return ((IndexedSeqView)this).splitAt(n);
        }

        @Override
        public IndexedSeqView<B, Coll> reverse() {
            return ((IndexedSeqView)this).reverse();
        }

        @Override
        public IndexedSeqView<B, Coll> tail() {
            return ((IndexedSeqView)this).tail();
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableViewLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableViewLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableViewLike.Transformed.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableViewLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return scala.collection.SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<B, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<B, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<B, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<B> find(Function1<B, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, B, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<B, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, B, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<B, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<IndexedSeqView<B, Coll>, Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<IndexedSeqView<B, Coll>, Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public B head() {
            return (B)IndexedSeqOptimized.head$(this);
        }

        @Override
        public B last() {
            return (B)IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public <B> void copyToArray(Object xs, int start, int len) {
            IndexedSeqOptimized.copyToArray$(this, xs, start, len);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<B, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<B, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<B, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Iterator<B> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<B> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public GenericCompanion<IndexedSeq> companion() {
            return IndexedSeq.companion$(this);
        }

        @Override
        public IndexedSeq<B> seq() {
            return IndexedSeq.seq$(this);
        }

        @Override
        public IndexedSeq<B> thisCollection() {
            return scala.collection.mutable.IndexedSeqLike.thisCollection$(this);
        }

        @Override
        public IndexedSeq toCollection(Object repr) {
            return scala.collection.mutable.IndexedSeqLike.toCollection$(this, repr);
        }

        @Override
        public IndexedSeqView<B, IndexedSeqView<B, Coll>> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<B, IndexedSeqView<B, Coll>> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public int hashCode() {
            return IndexedSeqLike.hashCode$(this);
        }

        @Override
        public Iterator<B> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public Combiner<B, ParSeq<B>> parCombiner() {
            return SeqLike.parCombiner$(this);
        }

        @Override
        public SeqLike<B, Seq<B>> transform(Function1<B, B> f) {
            return SeqLike.transform$(this, f);
        }

        @Override
        public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
            return super.clone();
        }

        @Override
        public Object clone() {
            return Cloneable.clone$(this);
        }

        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$AbstractTransformed$$$outer() {
            return (IndexedSeqView)this.$outer;
        }

        @Override
        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Transformed$$$outer() {
            return this.scala$collection$mutable$IndexedSeqView$AbstractTransformed$$$outer();
        }

        public AbstractTransformed(IndexedSeqView $outer) {
            Traversable.$init$(this);
            Iterable.$init$(this);
            Cloneable.$init$(this);
            SeqLike.$init$(this);
            Seq.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.IndexedSeq.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeq.$init$(this);
            IndexedSeqOptimized.$init$(this);
            IndexedSeqView.$init$(this);
            Transformed.$init$(this);
        }
    }

    public interface DroppedWhile
    extends SeqViewLike.DroppedWhile,
    Transformed<A> {
        public static /* synthetic */ void update$(DroppedWhile $this, int idx, Object elem) {
            $this.update(idx, (A)elem);
        }

        @Override
        default public void update(int idx, A elem) {
            if (idx >= 0) {
                this.scala$collection$mutable$IndexedSeqView$DroppedWhile$$$outer().update(idx + this.start(), elem);
                return;
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }

        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$DroppedWhile$$$outer();

        public static void $init$(DroppedWhile $this) {
        }
    }

    public interface Filtered
    extends SeqViewLike.Filtered,
    Transformed<A> {
        public static /* synthetic */ void update$(Filtered $this, int idx, Object elem) {
            $this.update(idx, (A)elem);
        }

        @Override
        default public void update(int idx, A elem) {
            this.scala$collection$mutable$IndexedSeqView$Filtered$$$outer().update(this.index()[idx], elem);
        }

        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Filtered$$$outer();

        public static void $init$(Filtered $this) {
        }
    }

    public interface Reversed
    extends SeqViewLike.Reversed,
    Transformed<A> {
        public static /* synthetic */ void update$(Reversed $this, int idx, Object elem) {
            $this.update(idx, (A)elem);
        }

        @Override
        default public void update(int idx, A elem) {
            this.scala$collection$mutable$IndexedSeqView$Reversed$$$outer().update(this.scala$collection$mutable$IndexedSeqView$Reversed$$$outer().length() - 1 - idx, elem);
        }

        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Reversed$$$outer();

        public static void $init$(Reversed $this) {
        }
    }

    public interface Sliced
    extends SeqViewLike.Sliced,
    Transformed<A> {
        public static /* synthetic */ int length$(Sliced $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.endpoints().width();
        }

        public static /* synthetic */ void update$(Sliced $this, int idx, Object elem) {
            $this.update(idx, (A)elem);
        }

        @Override
        default public void update(int idx, A elem) {
            if (idx >= 0 && idx + this.from() < this.until()) {
                this.scala$collection$mutable$IndexedSeqView$Sliced$$$outer().update(idx + this.from(), elem);
                return;
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }

        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Sliced$$$outer();

        public static void $init$(Sliced $this) {
        }
    }

    public interface TakenWhile
    extends SeqViewLike.TakenWhile,
    Transformed<A> {
        public static /* synthetic */ void update$(TakenWhile $this, int idx, Object elem) {
            $this.update(idx, (A)elem);
        }

        @Override
        default public void update(int idx, A elem) {
            if (idx < this.len()) {
                this.scala$collection$mutable$IndexedSeqView$TakenWhile$$$outer().update(idx, elem);
                return;
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }

        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$TakenWhile$$$outer();

        public static void $init$(TakenWhile $this) {
        }
    }

    public interface Transformed<B>
    extends IndexedSeqView<B, Coll>,
    SeqViewLike.Transformed<B> {
        @Override
        public void update(int var1, B var2);

        @Override
        default public String toString() {
            return this.viewToString();
        }

        public /* synthetic */ IndexedSeqView scala$collection$mutable$IndexedSeqView$Transformed$$$outer();

        public static void $init$(Transformed $this) {
        }
    }
}

