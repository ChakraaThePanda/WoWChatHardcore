/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.NoSuchElementException;
import scala.Cloneable;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeqLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericOrderedTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.immutable.List;
import scala.collection.immutable.Range;
import scala.collection.mutable.AbstractIterable;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqView;
import scala.collection.mutable.PriorityQueue$;
import scala.collection.mutable.Queue;
import scala.collection.mutable.Queue$;
import scala.collection.mutable.ResizableArray;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcZI$sp;

@ScalaSignature(bytes="\u0006\u0001\t=e\u0001B\u00181!]B\u0001\u0002\u001a\u0001\u0003\u0006\u0004%\u0019!\u001a\u0005\t[\u0002\u0011\t\u0011)A\u0005M\")a\u000e\u0001C\u0001_\u001a!!\u000f\u0001\u0003t\u0011\u0015qG\u0001\"\u0001~\u0011\u001d\t\t\u0001\u0002C\u0001\u0003\u0007Aq!a\u0003\u0005\t\u0003\ti\u0001C\u0004\u0002\u001a\u0011!\t!a\u0007\t\u000f\u0005%B\u0001\"\u0001\u0002,!9\u0011\u0011\u0007\u0003\u0005\u0002\u0005M\u0002\u0002CA\u001f\u0001\u0001&\t&a\u0010\t\u0013\u0005\u0005\u0003A1A\u0005\n\u0005\r\u0003\u0002CA$\u0001\u0001\u0006I!!\u0012\t\u000f\u0005%\u0003\u0001\"\u0001\u0002\u0004!9\u00111\n\u0001\u0005B\u0005\r\u0001bBA'\u0001\u0011\u0005\u0013q\n\u0005\b\u0003/\u0002A\u0011IA-\u0011\u001d\tY\u0006\u0001C\u0001\u0003;Bq!a\u0018\u0001\t\u0003\n\t\u0007C\u0004\u0002:\u0002!I!a/\t\u000f\u0005\u0005\u0007\u0001\"\u0005\u0002D\"9\u0011Q\u001a\u0001\u0005\u0012\u0005=\u0007bBAl\u0001\u0011\u0005\u0011\u0011\u001c\u0005\b\u0003?\u0004A\u0011IAq\u0011\u001d\ti\u000f\u0001C\u0005\u0003_Dq!a=\u0001\t\u0013\t)\u0010C\u0004\u0002|\u0002!\t!!@\t\u000f\t\u001d\u0001\u0001\"\u0001\u0003\n!9!Q\u0003\u0001\u0005\u0002\t]\u0001b\u0002B\r\u0001\u0011\u0005!1\u0004\u0005\b\u0005w\u0001A\u0011\tB\u001f\u0011\u001d\u0011y\u0004\u0001C\u0001\u0005\u0003BqAa\u0011\u0001\t\u0003\u0012)\u0005C\u0004\u0003N\u0001!\t!!\u0017\t\u000f\t=\u0003\u0001\"\u0001\u0003F!9!\u0011\u000b\u0001\u0005B\tM\u0003b\u0002B+\u0001\u0011\u0005!q\u000b\u0005\b\u0005?\u0002A\u0011\tB1\u0011\u001d\u0011I\b\u0001C!\u0005wBqAa!\u0001\t\u0003\nifB\u0004\u0002fAB\t!a\u001a\u0007\r=\u0002\u0004\u0012AA5\u0011\u0019q'\u0006\"\u0001\u0002r!9\u0011Q\b\u0016\u0005\u0002\u0005M\u0004bBABU\u0011\r\u0011Q\u0011\u0005\n\u0003KS\u0013\u0011!C\u0005\u0003O\u0013Q\u0002\u0015:j_JLG/_)vKV,'BA\u00193\u0003\u001diW\u000f^1cY\u0016T!a\r\u001b\u0002\u0015\r|G\u000e\\3di&|gNC\u00016\u0003\u0015\u00198-\u00197b\u0007\u0001)\"\u0001O \u0014\u0013\u0001I\u0014\nT*Y7z\u000b\u0007c\u0001\u001e<{5\t\u0001'\u0003\u0002=a\t\u0001\u0012IY:ue\u0006\u001cG/\u0013;fe\u0006\u0014G.\u001a\t\u0003}}b\u0001\u0001B\u0003A\u0001\t\u0007\u0011IA\u0001B#\t\u0011e\t\u0005\u0002D\t6\tA'\u0003\u0002Fi\t9aj\u001c;iS:<\u0007CA\"H\u0013\tAEGA\u0002B]f\u00042A\u000f&>\u0013\tY\u0005G\u0001\u0005Ji\u0016\u0014\u0018M\u00197f!\u0011i\u0005+\u0010*\u000e\u00039S!a\u0014\u001a\u0002\u000f\u001d,g.\u001a:jG&\u0011\u0011K\u0014\u0002\"\u000f\u0016tWM]5d\u001fJ$WM]3e)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u0003u\u0001\u0001B\u0001V+>/6\t!'\u0003\u0002We\ta\u0011\n^3sC\ndW\rT5lKB\u0019!\bA\u001f\u0011\u00075KV(\u0003\u0002[\u001d\nAqI]8xC\ndW\r\u0005\u0003;9v:\u0016BA/1\u0005\u001d\u0011U/\u001b7eKJ\u0004\"aQ0\n\u0005\u0001$$\u0001D*fe&\fG.\u001b>bE2,\u0007CA\"c\u0013\t\u0019GGA\u0005DY>tW-\u00192mK\u0006\u0019qN\u001d3\u0016\u0003\u0019\u00042a\u001a6>\u001d\t\u0019\u0005.\u0003\u0002ji\u00059\u0001/Y2lC\u001e,\u0017BA6m\u0005!y%\u000fZ3sS:<'BA55\u0003\u0011y'\u000f\u001a\u0011\u0002\rqJg.\u001b;?)\u0005\u0001HCA,r\u0011\u0015!7\u0001q\u0001g\u0005Q\u0011Vm]5{C\ndW-\u0011:sCf\f5mY3tgV\u0011A/_\n\u0005\tUTh\fE\u0002;mbL!a\u001e\u0019\u0003\u0017\u0005\u00137\u000f\u001e:bGR\u001cV-\u001d\t\u0003}e$Q\u0001\u0011\u0003C\u0002\u0005\u00032AO>y\u0013\ta\bG\u0001\bSKNL'0\u00192mK\u0006\u0013(/Y=\u0015\u0003y\u00042a \u0003y\u001b\u0005\u0001\u0011a\u00029`g&TX\rM\u000b\u0003\u0003\u000b\u00012aQA\u0004\u0013\r\tI\u0001\u000e\u0002\u0004\u0013:$\u0018a\u00039`g&TX\rM0%KF$B!a\u0004\u0002\u0016A\u00191)!\u0005\n\u0007\u0005MAG\u0001\u0003V]&$\bbBA\f\u000f\u0001\u0007\u0011QA\u0001\u0002g\u00069\u0001oX1se\u0006LXCAA\u000f!\u0015\u0019\u0015qDA\u0012\u0013\r\t\t\u0003\u000e\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0004\u0007\u0006\u0015\u0012bAA\u0014i\t1\u0011I\\=SK\u001a\fA\u0002]0f]N,(/Z*ju\u0016$B!a\u0004\u0002.!9\u0011qF\u0005A\u0002\u0005\u0015\u0011!\u00018\u0002\rA|6o^1q)\u0019\ty!!\u000e\u0002:!9\u0011q\u0007\u0006A\u0002\u0005\u0015\u0011!A1\t\u000f\u0005m\"\u00021\u0001\u0002\u0006\u0005\t!-\u0001\u0006oK^\u0014U/\u001b7eKJ,\u0012aW\u0001\u0007e\u0016\u001c\u0018M\u001d:\u0016\u0005\u0005\u0015\u0003cA@\u0005{\u00059!/Z:beJ\u0004\u0013A\u00027f]\u001e$\b.\u0001\u0003tSj,\u0017aB5t\u000b6\u0004H/_\u000b\u0003\u0003#\u00022aQA*\u0013\r\t)\u0006\u000e\u0002\b\u0005>|G.Z1o\u0003\u0011\u0011X\r\u001d:\u0016\u0003]\u000baA]3tk2$H#A,\u0002!=\u0014H-\u001a:fI\u000e{W\u000e]1oS>tWCAA2\u001d\tQ\u0014&A\u0007Qe&|'/\u001b;z#V,W/\u001a\t\u0003u)\u001aBAKA6=B!Q*!\u001cS\u0013\r\tyG\u0014\u0002\u001a\u001fJ$WM]3e)J\fg/\u001a:tC\ndWMR1di>\u0014\u0018\u0010\u0006\u0002\u0002hU!\u0011QOA>)\u0011\t9(a \u0011\rib\u0016\u0011PA?!\rq\u00141\u0010\u0003\u0006\u00012\u0012\r!\u0011\t\u0005u\u0001\tI\b\u0003\u0004eY\u0001\u000f\u0011\u0011\u0011\t\u0005O*\fI(\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0003\u0002\b\u0006uE\u0003BAE\u0003C\u0003\u0012\"TAF\u0003\u001f\u000bY*a(\n\u0007\u00055eJ\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0003\u0002\u0012\u0006MU\"\u0001\u0016\n\t\u0005U\u0015q\u0013\u0002\u0005\u0007>dG.C\u0002\u0002\u001a:\u0013qcR3oKJL7m\u0014:eKJ,GmQ8na\u0006t\u0017n\u001c8\u0011\u0007y\ni\nB\u0003A[\t\u0007\u0011\t\u0005\u0003;\u0001\u0005m\u0005B\u00023.\u0001\b\t\u0019\u000b\u0005\u0003hU\u0006m\u0015a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!!+\u0011\t\u0005-\u0016QW\u0007\u0003\u0003[SA!a,\u00022\u0006!A.\u00198h\u0015\t\t\u0019,\u0001\u0003kCZ\f\u0017\u0002BA\\\u0003[\u0013aa\u00142kK\u000e$\u0018a\u0001;p\u0003R\u0019Q(!0\t\u000f\u0005}F\u00031\u0001\u0002$\u0005\t\u00010A\u0003gSb,\u0006\u000f\u0006\u0004\u0002\u0010\u0005\u0015\u0017\u0011\u001a\u0005\b\u0003\u000f,\u0002\u0019AA\u000f\u0003\t\t7\u000fC\u0004\u0002LV\u0001\r!!\u0002\u0002\u00035\fqAZ5y\t><h\u000e\u0006\u0005\u0002R\u0005E\u00171[Ak\u0011\u001d\t9M\u0006a\u0001\u0003;Aq!a3\u0017\u0001\u0004\t)\u0001C\u0004\u00020Y\u0001\r!!\u0002\u0002\u0011\u0011\u0002H.^:%KF$2a`An\u0011\u0019\tin\u0006a\u0001{\u0005!Q\r\\3n\u00035!\u0003\u000f\\;tIAdWo\u001d\u0013fcR\u0019q0a9\t\u000f\u0005\u0015\b\u00041\u0001\u0002h\u0006\u0011\u0001p\u001d\t\u0005)\u0006%X(C\u0002\u0002lJ\u0012q\u0002\u0016:bm\u0016\u00148/\u00192mK>s7-Z\u0001\nk:\u001c\u0018MZ3BI\u0012$B!a\u0004\u0002r\"1\u0011Q\\\rA\u0002u\nq\u0001[3ba&4\u0017\u0010\u0006\u0003\u0002\u0010\u0005]\bbBA}5\u0001\u0007\u0011QA\u0001\u0005MJ|W.\u0001\u0006%a2,8\u000f\n9mkN$2aVA\u0000\u0011\u001d\t)o\u0007a\u0001\u0005\u0003\u0001B\u0001\u0016B\u0002{%\u0019!Q\u0001\u001a\u0003%\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK>s7-Z\u0001\bK:\fX/Z;f)\u0011\tyAa\u0003\t\u000f\t5A\u00041\u0001\u0003\u0010\u0005)Q\r\\3ngB!1I!\u0005>\u0013\r\u0011\u0019\u0002\u000e\u0002\u000byI,\u0007/Z1uK\u0012t\u0014a\u00023fcV,W/\u001a\u000b\u0002{\u0005QA-Z9vKV,\u0017\t\u001c7\u0016\r\tu!Q\u0007B\u0011)\u0011\u0011yB!\n\u0011\u0007y\u0012\t\u0003\u0002\u0004\u0003$y\u0011\r!\u0011\u0002\u0005)\"\fG\u000fC\u0004\u0003(y\u0001\u001dA!\u000b\u0002\u0005\t4\u0007\u0007\u0002B\u0016\u0005_\u0001\u0012\"TAF\u0005[\u0011\u0019Da\b\u0011\u0007y\u0012y\u0003B\u0006\u00032\t\u0015\u0012\u0011!A\u0001\u0006\u0003\t%aA0%cA\u0019aH!\u000e\u0005\u000f\t]bD1\u0001\u0003:\t\u0011\u0011)M\t\u0003{\u0019\u000bA\u0001[3bIV\tQ(A\u0003dY\u0016\f'\u000f\u0006\u0002\u0002\u0010\u0005A\u0011\u000e^3sCR|'/\u0006\u0002\u0003HA!AK!\u0013>\u0013\r\u0011YE\r\u0002\t\u0013R,'/\u0019;pe\u00069!/\u001a<feN,\u0017a\u0004:fm\u0016\u00148/Z%uKJ\fGo\u001c:\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!\u0002\u0002\u000fQ|\u0017+^3vKV\u0011!\u0011\f\t\u0005u\tmS(C\u0002\u0003^A\u0012Q!U;fk\u0016\f\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0005G\u0002BA!\u001a\u0003t9!!q\rB8!\r\u0011I\u0007N\u0007\u0003\u0005WR1A!\u001c7\u0003\u0019a$o\\8u}%\u0019!\u0011\u000f\u001b\u0002\rA\u0013X\rZ3g\u0013\u0011\u0011)Ha\u001e\u0003\rM#(/\u001b8h\u0015\r\u0011\t\bN\u0001\u0007i>d\u0015n\u001d;\u0016\u0005\tu\u0004\u0003B4\u0003\u0000uJ1A!!m\u0005\u0011a\u0015n\u001d;\u0002\u000b\rdwN\\3*\u000b\u0001\u00119Ia#\n\u0007\t%\u0005G\u0001\nQe&|'/\u001b;z#V,W/\u001a)s_bL\u0018b\u0001BGa\tI2+\u001f8dQJ|g.\u001b>fIB\u0013\u0018n\u001c:jif\fV/Z;f\u0001")
public class PriorityQueue<A>
extends AbstractIterable<A>
implements GenericOrderedTraversableTemplate<A, PriorityQueue>,
Builder<A, PriorityQueue<A>>,
Serializable,
Cloneable {
    private final Ordering<A> ord;
    private final ResizableArrayAccess<A> scala$collection$mutable$PriorityQueue$$resarr;

    public static <A> CanBuildFrom<PriorityQueue<?>, A, PriorityQueue<A>> canBuildFrom(Ordering<A> ordering) {
        return PriorityQueue$.MODULE$.canBuildFrom(ordering);
    }

    public static Traversable apply(Seq seq, Ordering ordering) {
        return PriorityQueue$.MODULE$.apply(seq, ordering);
    }

    public static Traversable empty(Ordering ordering) {
        return PriorityQueue$.MODULE$.empty(ordering);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<A, NewTo> mapResult(Function1<PriorityQueue<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public <B> Builder<B, PriorityQueue<B>> genericOrderedBuilder(Ordering<B> ord) {
        return GenericOrderedTraversableTemplate.genericOrderedBuilder$(this, ord);
    }

    @Override
    public Ordering<A> ord() {
        return this.ord;
    }

    @Override
    public Builder<A, PriorityQueue<A>> newBuilder() {
        return PriorityQueue$.MODULE$.newBuilder(this.ord());
    }

    public ResizableArrayAccess<A> scala$collection$mutable$PriorityQueue$$resarr() {
        return this.scala$collection$mutable$PriorityQueue$$resarr;
    }

    public int length() {
        return this.scala$collection$mutable$PriorityQueue$$resarr().length() - 1;
    }

    @Override
    public int size() {
        return this.length();
    }

    @Override
    public boolean isEmpty() {
        return this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() < 2;
    }

    @Override
    public PriorityQueue<A> repr() {
        return this;
    }

    @Override
    public PriorityQueue<A> result() {
        return this;
    }

    public PriorityQueue$ orderedCompanion() {
        return PriorityQueue$.MODULE$;
    }

    public A scala$collection$mutable$PriorityQueue$$toA(Object x) {
        return (A)x;
    }

    public void fixUp(Object[] as, int m) {
        for (int k = m; k > 1 && this.ord().mkOrderingOps(this.scala$collection$mutable$PriorityQueue$$toA(as[k / 2])).$less(this.scala$collection$mutable$PriorityQueue$$toA(as[k])); k /= 2) {
            this.scala$collection$mutable$PriorityQueue$$resarr().p_swap(k, k / 2);
        }
    }

    public boolean fixDown(Object[] as, int m, int n) {
        int k = m;
        while (n >= 2 * k) {
            int j = 2 * k;
            if (j < n && this.ord().mkOrderingOps(this.scala$collection$mutable$PriorityQueue$$toA(as[j])).$less(this.scala$collection$mutable$PriorityQueue$$toA(as[j + 1]))) {
                ++j;
            }
            if (this.ord().mkOrderingOps(this.scala$collection$mutable$PriorityQueue$$toA(as[k])).$greater$eq(this.scala$collection$mutable$PriorityQueue$$toA(as[j]))) {
                return k != m;
            }
            Object h = as[k];
            as[k] = as[j];
            as[j] = h;
            k = j;
        }
        return k != m;
    }

    @Override
    public PriorityQueue<A> $plus$eq(A elem) {
        this.scala$collection$mutable$PriorityQueue$$resarr().p_ensureSize(this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() + 1);
        this.scala$collection$mutable$PriorityQueue$$resarr().p_array()[this.scala$collection$mutable$PriorityQueue$$resarr().p_size0()] = elem;
        this.fixUp(this.scala$collection$mutable$PriorityQueue$$resarr().p_array(), this.scala$collection$mutable$PriorityQueue$$resarr().p_size0());
        this.scala$collection$mutable$PriorityQueue$$resarr().p_size0_$eq(this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() + 1);
        return this;
    }

    @Override
    public PriorityQueue<A> $plus$plus$eq(TraversableOnce<A> xs) {
        int from = this.scala$collection$mutable$PriorityQueue$$resarr().p_size0();
        xs.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            this.scala$collection$mutable$PriorityQueue$$unsafeAdd(x);
            return BoxedUnit.UNIT;
        });
        this.scala$collection$mutable$PriorityQueue$$heapify(from);
        return this;
    }

    public void scala$collection$mutable$PriorityQueue$$unsafeAdd(A elem) {
        this.scala$collection$mutable$PriorityQueue$$resarr().p_ensureSize(this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() + 1);
        this.scala$collection$mutable$PriorityQueue$$resarr().p_array()[this.scala$collection$mutable$PriorityQueue$$resarr().p_size0()] = elem;
        this.scala$collection$mutable$PriorityQueue$$resarr().p_size0_$eq(this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() + 1);
    }

    public void scala$collection$mutable$PriorityQueue$$heapify(int from) {
        int n = this.length();
        if (from <= 2) {
            int n2 = n / 2;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            RichInt$.MODULE$.to$extension0(n2, 1).by(-1).foreach((JFunction1$mcZI$sp & Serializable)(Object i) -> this.fixDown(this.scala$collection$mutable$PriorityQueue$$resarr().p_array(), i, n));
            return;
        }
        if (n - from < 4) {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(from, n);
            if (inclusive == null) {
                throw null;
            }
            Range.Inclusive foreach$mVc$sp_this = inclusive;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    this.fixUp(this.scala$collection$mutable$PriorityQueue$$resarr().p_array(), foreach$mVc$sp_i);
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
                return;
            }
        } else {
            IntRef min = IntRef.create(from / 2);
            Queue queue = (Queue)Queue$.MODULE$.apply(Predef$.MODULE$.wrapIntArray(new int[]{min.elem}));
            int n3 = n / 2;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            RichInt$.MODULE$.until$extension0(n3, min.elem).by(-1).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(Object i) -> PriorityQueue.$anonfun$heapify$3(this, n, min, queue, BoxesRunTime.unboxToInt(i)));
            while (queue.nonEmpty()) {
                int parent;
                int i2 = BoxesRunTime.unboxToInt(queue.dequeue());
                if (!this.fixDown(this.scala$collection$mutable$PriorityQueue$$resarr().p_array(), i2, n) || (parent = i2 / 2) >= min.elem || parent <= 0) continue;
                min.elem = parent;
                queue.$plus$eq(BoxesRunTime.boxToInteger(parent));
            }
        }
    }

    public PriorityQueue<A> $plus$plus(GenTraversableOnce<A> xs) {
        return ((PriorityQueue)this.clone()).$plus$plus$eq((TraversableOnce)xs.seq());
    }

    public void enqueue(Seq<A> elems) {
        this.$plus$plus$eq((TraversableOnce)elems);
    }

    public A dequeue() {
        if (this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() > 1) {
            this.scala$collection$mutable$PriorityQueue$$resarr().p_size0_$eq(this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() - 1);
            Object result2 = this.scala$collection$mutable$PriorityQueue$$resarr().p_array()[1];
            this.scala$collection$mutable$PriorityQueue$$resarr().p_array()[1] = this.scala$collection$mutable$PriorityQueue$$resarr().p_array()[this.scala$collection$mutable$PriorityQueue$$resarr().p_size0()];
            this.scala$collection$mutable$PriorityQueue$$resarr().p_array()[this.scala$collection$mutable$PriorityQueue$$resarr().p_size0()] = null;
            this.fixDown(this.scala$collection$mutable$PriorityQueue$$resarr().p_array(), 1, this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() - 1);
            return this.scala$collection$mutable$PriorityQueue$$toA(result2);
        }
        throw new NoSuchElementException("no element to remove from heap");
    }

    public <A1, That> That dequeueAll(CanBuildFrom<?, A1, That> bf) {
        Builder<A1, That> b = bf.apply();
        while (this.nonEmpty()) {
            b.$plus$eq((A1)this.dequeue());
        }
        return b.result();
    }

    @Override
    public A head() {
        if (this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() > 1) {
            return this.scala$collection$mutable$PriorityQueue$$toA(this.scala$collection$mutable$PriorityQueue$$resarr().p_array()[1]);
        }
        throw new NoSuchElementException("queue is empty");
    }

    @Override
    public void clear() {
        this.scala$collection$mutable$PriorityQueue$$resarr().p_size0_$eq(1);
    }

    @Override
    public Iterator<A> iterator() {
        return new AbstractIterator<A>(this){
            private int i;
            private final /* synthetic */ PriorityQueue $outer;

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                return this.i() < this.$outer.scala$collection$mutable$PriorityQueue$$resarr().p_size0();
            }

            public A next() {
                Object n = this.$outer.scala$collection$mutable$PriorityQueue$$resarr().p_array()[this.i()];
                this.i_$eq(this.i() + 1);
                return this.$outer.scala$collection$mutable$PriorityQueue$$toA(n);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.i = 1;
            }
        };
    }

    /*
     * WARNING - void declaration
     */
    public PriorityQueue<A> reverse() {
        void var1_1;
        PriorityQueue<A> revq = new PriorityQueue<A>(this.ord().reverse());
        int n = this.scala$collection$mutable$PriorityQueue$$resarr().p_size0();
        revq.scala$collection$mutable$PriorityQueue$$resarr().p_ensureSize(n);
        revq.scala$collection$mutable$PriorityQueue$$resarr().p_size0_$eq(n);
        Object[] from = this.scala$collection$mutable$PriorityQueue$$resarr().p_array();
        Object[] to = revq.scala$collection$mutable$PriorityQueue$$resarr().p_array();
        int n2 = 1;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n2, n);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                to[foreach$mVc$sp_i] = from[n - foreach$mVc$sp_i];
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
        revq.scala$collection$mutable$PriorityQueue$$heapify(1);
        return var1_1;
    }

    public Iterator<A> reverseIterator() {
        return new AbstractIterator<A>(this){
            private int i;
            private final /* synthetic */ PriorityQueue $outer;

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                return this.i() >= 1;
            }

            public A next() {
                Object n = this.$outer.scala$collection$mutable$PriorityQueue$$resarr().p_array()[this.i()];
                this.i_$eq(this.i() - 1);
                return this.$outer.scala$collection$mutable$PriorityQueue$$toA(n);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.i = $outer.scala$collection$mutable$PriorityQueue$$resarr().p_size0() - 1;
            }
        };
    }

    public int hashCode() {
        throw new UnsupportedOperationException("unsuitable as hash key");
    }

    public Queue<A> toQueue() {
        return (Queue)new Queue<A>().$plus$plus$eq(this.iterator());
    }

    @Override
    public String toString() {
        return this.toList().mkString("PriorityQueue(", ", ", ")");
    }

    @Override
    public List<A> toList() {
        return this.iterator().toList();
    }

    /*
     * WARNING - void declaration
     */
    public PriorityQueue<A> clone() {
        void var1_1;
        PriorityQueue<A> pq = new PriorityQueue<A>(this.ord());
        int n = this.scala$collection$mutable$PriorityQueue$$resarr().p_size0();
        pq.scala$collection$mutable$PriorityQueue$$resarr().p_ensureSize(n);
        System.arraycopy(this.scala$collection$mutable$PriorityQueue$$resarr().p_array(), 1, pq.scala$collection$mutable$PriorityQueue$$resarr().p_array(), 1, n - 1);
        pq.scala$collection$mutable$PriorityQueue$$resarr().p_size0_$eq(n);
        return var1_1;
    }

    public static final /* synthetic */ Object $anonfun$heapify$3(PriorityQueue $this, int n$1, IntRef min$1, Queue queue$1, int i) {
        if ($this.fixDown($this.scala$collection$mutable$PriorityQueue$$resarr().p_array(), i, n$1)) {
            int parent = i / 2;
            if (parent < min$1.elem) {
                min$1.elem = parent;
                return queue$1.$plus$eq(BoxesRunTime.boxToInteger(parent));
            }
            return BoxedUnit.UNIT;
        }
        return BoxedUnit.UNIT;
    }

    public PriorityQueue(Ordering<A> ord) {
        this.ord = ord;
        GenericOrderedTraversableTemplate.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
        this.scala$collection$mutable$PriorityQueue$$resarr = new ResizableArrayAccess();
        this.scala$collection$mutable$PriorityQueue$$resarr().p_size0_$eq(this.scala$collection$mutable$PriorityQueue$$resarr().p_size0() + 1);
    }

    public class ResizableArrayAccess<A>
    extends AbstractSeq<A>
    implements ResizableArray<A>,
    Serializable {
        private Object[] array;
        private int size0;

        @Override
        public GenericCompanion<ResizableArray> companion() {
            return ResizableArray.companion$(this);
        }

        @Override
        public int initialSize() {
            return ResizableArray.initialSize$(this);
        }

        @Override
        public int length() {
            return ResizableArray.length$(this);
        }

        @Override
        public A apply(int idx) {
            return (A)ResizableArray.apply$(this, idx);
        }

        @Override
        public void update(int idx, A elem) {
            ResizableArray.update$(this, idx, elem);
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            ResizableArray.foreach$(this, f);
        }

        @Override
        public <B> void copyToArray(Object xs, int start, int len) {
            ResizableArray.copyToArray$(this, xs, start, len);
        }

        @Override
        public void reduceToSize(int sz) {
            ResizableArray.reduceToSize$(this, sz);
        }

        @Override
        public void ensureSize(int n) {
            ResizableArray.ensureSize$(this, n);
        }

        @Override
        public void swap(int a, int b) {
            ResizableArray.swap$(this, a, b);
        }

        @Override
        public void copy(int m, int n, int len) {
            ResizableArray.copy$(this, m, n, len);
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
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public boolean forall(Function1<A, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<A, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<A> find(Function1<A, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, A, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<A, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, A, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<A, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<ResizableArray<A>, Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<ResizableArray<A>, Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object slice(int from, int until) {
            return IndexedSeqOptimized.slice$(this, from, until);
        }

        @Override
        public A head() {
            return (A)IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public A last() {
            return (A)IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
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
        public Tuple2<ResizableArray<A>, ResizableArray<A>> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<ResizableArray<A>, ResizableArray<A>> span(Function1<A, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<A, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<A, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<A, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<A> reverseIterator() {
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
        public List<A> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeq<A> seq() {
            return IndexedSeq.seq$(this);
        }

        @Override
        public IndexedSeq<A> thisCollection() {
            return scala.collection.mutable.IndexedSeqLike.thisCollection$(this);
        }

        @Override
        public IndexedSeq toCollection(Object repr) {
            return scala.collection.mutable.IndexedSeqLike.toCollection$(this, repr);
        }

        @Override
        public IndexedSeqView<A, ResizableArray<A>> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<A, ResizableArray<A>> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public int hashCode() {
            return IndexedSeqLike.hashCode$(this);
        }

        @Override
        public Iterator<A> iterator() {
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
        public Object[] array() {
            return this.array;
        }

        @Override
        public void array_$eq(Object[] x$1) {
            this.array = x$1;
        }

        @Override
        public int size0() {
            return this.size0;
        }

        @Override
        public void size0_$eq(int x$1) {
            this.size0 = x$1;
        }

        public int p_size0() {
            return this.size0();
        }

        public void p_size0_$eq(int s) {
            this.size0_$eq(s);
        }

        public Object[] p_array() {
            return this.array();
        }

        public void p_ensureSize(int n) {
            ResizableArray.ensureSize$(this, n);
        }

        public void p_swap(int a, int b) {
            ResizableArray.swap$(this, a, b);
        }

        public /* synthetic */ PriorityQueue scala$collection$mutable$PriorityQueue$ResizableArrayAccess$$$outer() {
            return PriorityQueue.this;
        }

        public ResizableArrayAccess() {
            if (PriorityQueue.this == null) {
                throw null;
            }
            IndexedSeqLike.$init$(this);
            scala.collection.IndexedSeq.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeq.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ResizableArray.$init$(this);
        }
    }
}

