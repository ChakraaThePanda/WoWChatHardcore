/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  scala.collection.TraversableOnce$counter$2
 */
package scala.reflect.internal.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.BufferedIterator;
import scala.collection.GenIterable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeq;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.SetLike;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParSet;
import scala.collection.script.Message;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.Set;
import scala.reflect.internal.util.WeakHashSet$;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichDouble$;

@ScalaSignature(bytes="\u0006\u0001\t-c\u0001B\u001e=\u0005\u0015C\u0001\u0002\u001a\u0001\u0003\u0006\u0004%\t!\u001a\u0005\tS\u0002\u0011\t\u0011)A\u0005M\"A!\u000e\u0001BC\u0002\u0013\u00051\u000e\u0003\u0005p\u0001\t\u0005\t\u0015!\u0003m\u0011\u0015\u0001\b\u0001\"\u0001r\u0011\u0015\u0001\b\u0001\"\u0001v\u000b\u00111\b\u0001\u0001:\t\r]\u0004\u0001\u0015!\u0003y\u0011\u001d\t)\u0001\u0001Q!\n\u0019Da!a\u0002\u0001\t\u0013)\u0007\u0002CA\u0005\u0001\u0001\u0006K!a\u0003\t\u000f\u0005u\u0005\u0001)Q\u0005M\"9\u0011q\u0014\u0001!\n\u0013)\u0007\u0002CAQ\u0001\u0001&I!a)\t\u0011\u0005\u001d\u0006\u0001)C\u0005\u0003SC\u0001\"a.\u0001A\u0013%\u0011\u0011\u0018\u0005\t\u0003w\u0003\u0001\u0015\"\u0003\u0002:\"9\u0011Q\u0018\u0001\u0005B\u0005}\u0006bBAc\u0001\u0011\u0005\u0011q\u0019\u0005\b\u0003\u0017\u0004A\u0011IAg\u0011\u001d\t\u0019\u000e\u0001C\u0001\u0003+Dq!!7\u0001\t\u0003\nY\u000eC\u0004\u0002b\u0002!\t%a9\t\u000f\u0005\u001d\b\u0001\"\u0001\u0002j\"9\u0011Q\u001e\u0001\u0005B\u0005e\u0006bBAx\u0001\u0011\u0005\u0013\u0011\u001f\u0005\u0007\u0003k\u0004A\u0011I3\t\u000f\u0005\u001d\u0004\u0001\"\u0011\u0002x\"9\u00111 \u0001\u0005B\u0005u\bb\u0002B\u0007\u0001\u0011\u0005#q\u0002\u0005\b\u0005?\u0001A\u0011\tB\u0011\r\u001d\u0011I\u0003\u0001\u0001=\u0005WAa\u0001\u001d\u0011\u0005\u0002\t5\u0002b\u0002B\u0019A\u0011\u0005!1\u0007\u0005\b\u0005k\u0001C\u0011\u0001B\u001c\u0011\u0019\u0011\t\u0005\tC\u0001K\"1!1\t\u0011\u0005\u0002\u0015DaA!\u0012!\t\u0003)\u0007\u0002\u0003B$\u0001\u0011\u0005AH!\u0013\b\u000f\u0005UA\b#\u0001\u0002\u0018\u001911\b\u0010E\u0001\u00033Aa\u0001]\u0015\u0005\u0002\u0005maABA\u000fS\u0011\ty\u0002\u0003\u0006\u00026-\u0012\t\u0011)A\u0005\u0003SA\u0011\"a\u000e,\u0005\u000b\u0007I\u0011A3\t\u0013\u0005e2F!A!\u0002\u00131\u0007BCA\u001eW\t\u0005\r\u0011\"\u0001\u0002>!Q\u00111I\u0016\u0003\u0002\u0004%\t!!\u0012\t\u0015\u0005E3F!A!B\u0013\ty\u0004C\u0005xW\t\u0005\t\u0015!\u0003\u0002T!1\u0001o\u000bC\u0001\u0003+B\u0001\"a\u0018*\u0005\u0004%\t!\u001a\u0005\b\u0003CJ\u0003\u0015!\u0003g\u0011!\t\u0019'\u000bb\u0001\n\u0003Y\u0007bBA3S\u0001\u0006I\u0001\u001c\u0005\b\u0003OJC\u0011AA5\u0011%\t9(KI\u0001\n\u0003\tI\bC\u0005\u0002\u0014&\n\n\u0011\"\u0001\u0002\u0016\nYq+Z1l\u0011\u0006\u001c\bnU3u\u0015\tid(\u0001\u0003vi&d'BA A\u0003!Ig\u000e^3s]\u0006d'BA!C\u0003\u001d\u0011XM\u001a7fGRT\u0011aQ\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t1Uj\u0005\u0003\u0001\u000f^k\u0006c\u0001%J\u00176\tA(\u0003\u0002Ky\t\u00191+\u001a;\u0011\u00051kE\u0002\u0001\u0003\u0006\u001d\u0002\u0011\ra\u0014\u0002\u0002\u0003F\u0011\u0001\u000b\u0016\t\u0003#Jk\u0011AQ\u0005\u0003'\n\u0013qAT8uQ&tw\r\u0005\u0002R+&\u0011aK\u0011\u0002\u0007\u0003:L(+\u001a4\u0011\tEC6JW\u0005\u00033\n\u0013\u0011BR;oGRLwN\\\u0019\u0011\u0005E[\u0016B\u0001/C\u0005\u001d\u0011un\u001c7fC:\u00042AX2L\u001b\u0005y&B\u00011b\u0003\u001diW\u000f^1cY\u0016T!A\u0019\"\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0002K?\u0006y\u0011N\\5uS\u0006d7)\u00199bG&$\u00180F\u0001g!\t\tv-\u0003\u0002i\u0005\n\u0019\u0011J\u001c;\u0002!%t\u0017\u000e^5bY\u000e\u000b\u0007/Y2jif\u0004\u0013A\u00037pC\u00124\u0015m\u0019;peV\tA\u000e\u0005\u0002R[&\u0011aN\u0011\u0002\u0007\t>,(\r\\3\u0002\u00171|\u0017\r\u001a$bGR|'\u000fI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007I\u001cH\u000fE\u0002I\u0001-CQ\u0001Z\u0003A\u0002\u0019DQA[\u0003A\u00021$\u0012A\u001d\u0002\u0005)\"L7/A\u0003rk\u0016,X\r\u0005\u0003z\u0003\u0003YU\"\u0001>\u000b\u0005md\u0018a\u0001:fM*\u0011QP`\u0001\u0005Y\u0006twMC\u0001\u0000\u0003\u0011Q\u0017M^1\n\u0007\u0005\r!P\u0001\bSK\u001a,'/\u001a8dKF+X-^3\u0002\u000b\r|WO\u001c;\u0002\u001f\r|W\u000e];uK\u000e\u000b\u0007/Y2jif\fQ\u0001^1cY\u0016\u0004R!UA\u0007\u0003#I1!a\u0004C\u0005\u0015\t%O]1z!\u0011\t\u0019bK&\u000f\u0005!C\u0013aC,fC.D\u0015m\u001d5TKR\u0004\"\u0001S\u0015\u0014\u0005%\"FCAA\f\u0005\u0015)e\u000e\u001e:z+\u0011\t\t#a\u000b\u0014\u0007-\n\u0019\u0003E\u0003z\u0003K\tI#C\u0002\u0002(i\u0014QbV3bWJ+g-\u001a:f]\u000e,\u0007c\u0001'\u0002,\u00111aj\u000bb\u0001\u0003[\t2\u0001UA\u0018!\r\t\u0016\u0011G\u0005\u0004\u0003g\u0011%aA!os\u00069Q\r\\3nK:$\u0018\u0001\u00025bg\"\fQ\u0001[1tQ\u0002\nA\u0001^1jYV\u0011\u0011q\b\t\u0006\u0003\u0003Z\u0013\u0011F\u0007\u0002S\u0005AA/Y5m?\u0012*\u0017\u000f\u0006\u0003\u0002H\u00055\u0003cA)\u0002J%\u0019\u00111\n\"\u0003\tUs\u0017\u000e\u001e\u0005\n\u0003\u001f\u0002\u0014\u0011!a\u0001\u0003\u007f\t1\u0001\u001f\u00132\u0003\u0015!\u0018-\u001b7!!\u0015I\u0018\u0011AA\u0015))\ty$a\u0016\u0002Z\u0005m\u0013Q\f\u0005\b\u0003k\u0019\u0004\u0019AA\u0015\u0011\u0019\t9d\ra\u0001M\"9\u00111H\u001aA\u0002\u0005}\u0002BB<4\u0001\u0004\t\u0019&\u0001\feK\u001a\fW\u000f\u001c;J]&$\u0018.\u00197DCB\f7-\u001b;z\u0003]!WMZ1vYRLe.\u001b;jC2\u001c\u0015\r]1dSRL\b%A\teK\u001a\fW\u000f\u001c;M_\u0006$g)Y2u_J\f!\u0003Z3gCVdG\u000fT8bI\u001a\u000b7\r^8sA\u0005)\u0011\r\u001d9msV!\u00111NA9)\u0019\ti'a\u001d\u0002vA!\u0001\nAA8!\ra\u0015\u0011\u000f\u0003\u0006\u001db\u0012\ra\u0014\u0005\bIb\u0002\n\u00111\u0001g\u0011\u001dQ\u0007\b%AA\u00021\fq\"\u00199qYf$C-\u001a4bk2$H%M\u000b\u0005\u0003w\n\t*\u0006\u0002\u0002~)\u001aa-a ,\u0005\u0005\u0005\u0005\u0003BAB\u0003\u001bk!!!\"\u000b\t\u0005\u001d\u0015\u0011R\u0001\nk:\u001c\u0007.Z2lK\u0012T1!a#C\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003\u001f\u000b)IA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016$QAT\u001dC\u0002=\u000bq\"\u00199qYf$C-\u001a4bk2$HEM\u000b\u0005\u0003/\u000bY*\u0006\u0002\u0002\u001a*\u001aA.a \u0005\u000b9S$\u0019A(\u0002\u0013QD'/Z:i_2$\u0017\u0001E2p[B,H/\u001a+ie\u0016\u001c\bn\u001c7e\u0003%\u0011WoY6fi\u001a{'\u000fF\u0002g\u0003KCa!a\u000e\u000f\u0001\u00041\u0017A\u0002:f[>4X\r\u0006\u0005\u0002H\u0005-\u0016qVAZ\u0011\u0019\tik\u0004a\u0001M\u00061!-^2lKRDq!!-\u0010\u0001\u0004\t\t\"A\u0005qe\u00164XI\u001c;ss\"9\u0011QW\bA\u0002\u0005E\u0011!B3oiJL\u0018A\u0005:f[>4Xm\u0015;bY\u0016,e\u000e\u001e:jKN$\"!a\u0012\u0002\rI,7/\u001b>f\u0003%1\u0017N\u001c3F]R\u0014\u0018\u0010F\u0002L\u0003\u0003Da!a1\u0013\u0001\u0004Y\u0015\u0001B3mK6\f\u0011CZ5oI\u0016sGO]=PeV\u0003H-\u0019;f)\rY\u0015\u0011\u001a\u0005\u0007\u0003\u0007\u001c\u0002\u0019A&\u0002\u000b\u0011\u0002H.^:\u0015\t\u0005=\u0017\u0011[\u0007\u0002\u0001!1\u00111\u0019\u000bA\u0002-\u000b\u0001\u0002\n9mkN$S-\u001d\u000b\u0005\u0003\u001f\f9\u000e\u0003\u0004\u0002DV\u0001\raS\u0001\tC\u0012$WI\u001c;ssR!\u0011qIAo\u0011\u0019\tyN\u0006a\u0001\u0017\u0006\t\u00010\u0001\u0004%[&tWo\u001d\u000b\u0005\u0003\u001f\f)\u000f\u0003\u0004\u0002D^\u0001\raS\u0001\nI5Lg.^:%KF$B!a4\u0002l\"1\u00111\u0019\rA\u0002-\u000bQa\u00197fCJ\fQ!Z7qif,\"!a=\u0011\u0007\u0005=w!\u0001\u0003tSj,Gc\u0001.\u0002z\"1\u0011q\u001c\u000fA\u0002-\u000bqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0002\u0000\n%A\u0003BA$\u0005\u0003AqAa\u0001\u001e\u0001\u0004\u0011)!A\u0001g!\u0015\t\u0006l\u0013B\u0004!\ra%\u0011\u0002\u0003\b\u0005\u0017i\"\u0019AA\u0017\u0005\u0005)\u0016A\u0002;p\u0019&\u001cH\u000f\u0006\u0002\u0003\u0012A)!1\u0003B\r\u0017:\u0019\u0011K!\u0006\n\u0007\t]!)A\u0004qC\u000e\\\u0017mZ3\n\t\tm!Q\u0004\u0002\u0005\u0019&\u001cHOC\u0002\u0003\u0018\t\u000b\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0005G\u0001RAa\u0005\u0003&-KAAa\n\u0003\u001e\tA\u0011\n^3sCR|'OA\u0006ES\u0006<gn\\:uS\u000e\u001c8C\u0001\u0011U)\t\u0011y\u0003E\u0002\u0002P\u0002\nQBZ;mYf4\u0016\r\\5eCR,WCAA$\u0003\u0011!W/\u001c9\u0016\u0005\te\u0002C\u0002B\u001e\u0005{\ty#D\u0001b\u0013\r\u0011y$\u0019\u0002\u000b\u0013:$W\r_3e'\u0016\f\u0018!F2pY2L7/[8o\u0005V\u001c7.\u001a;t\u0007>,h\u000e^\u0001\u0011MVdGNQ;dW\u0016$8oQ8v]R\fABY;dW\u0016$8oQ8v]R\f1\u0002Z5bO:|7\u000f^5dgV\u0011!q\u0006")
public final class WeakHashSet<A>
extends Set<A>
implements scala.collection.mutable.Set<A> {
    private final int initialCapacity;
    private final double loadFactor;
    private final ReferenceQueue<A> queue;
    public int scala$reflect$internal$util$WeakHashSet$$count;
    public Entry<A>[] scala$reflect$internal$util$WeakHashSet$$table;
    private int threshold;

    public static <A> double apply$default$2() {
        return WeakHashSet$.MODULE$.apply$default$2();
    }

    public static <A> int apply$default$1() {
        return WeakHashSet$.MODULE$.apply$default$1();
    }

    public static double defaultLoadFactor() {
        return WeakHashSet$.MODULE$.defaultLoadFactor();
    }

    public static int defaultInitialCapacity() {
        return WeakHashSet$.MODULE$.defaultInitialCapacity();
    }

    @Override
    public GenericCompanion<scala.collection.mutable.Set> companion() {
        return scala.collection.mutable.Set.companion$(this);
    }

    @Override
    public scala.collection.mutable.Set<A> seq() {
        return scala.collection.mutable.Set.seq$(this);
    }

    @Override
    public Builder<A, scala.collection.mutable.Set<A>> newBuilder() {
        return SetLike.newBuilder$(this);
    }

    @Override
    public Combiner<A, ParSet<A>> parCombiner() {
        return SetLike.parCombiner$(this);
    }

    @Override
    public Seq<A> toSeq() {
        return SetLike.toSeq$(this);
    }

    @Override
    public boolean add(A elem) {
        return SetLike.add$(this, elem);
    }

    @Override
    public boolean remove(A elem) {
        return SetLike.remove$(this, elem);
    }

    @Override
    public void update(A elem, boolean included) {
        SetLike.update$(this, elem, included);
    }

    @Override
    public void retain(Function1<A, Object> p) {
        SetLike.retain$(this, p);
    }

    @Override
    public scala.collection.mutable.Set<A> clone() {
        return SetLike.clone$(this);
    }

    @Override
    public scala.collection.mutable.Set<A> result() {
        return SetLike.result$(this);
    }

    @Override
    public scala.collection.mutable.Set<A> $plus(A elem1, A elem2, Seq<A> elems) {
        return SetLike.$plus$(this, elem1, elem2, elems);
    }

    @Override
    public scala.collection.mutable.Set<A> $plus$plus(GenTraversableOnce<A> xs) {
        return SetLike.$plus$plus$(this, xs);
    }

    @Override
    public scala.collection.mutable.Set<A> $minus(A elem1, A elem2, Seq<A> elems) {
        return SetLike.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public scala.collection.mutable.Set<A> $minus$minus(GenTraversableOnce<A> xs) {
        return SetLike.$minus$minus$(this, xs);
    }

    @Override
    public void $less$less(Message<A> cmd) {
        SetLike.$less$less$(this, cmd);
    }

    @Override
    public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
        return super.clone();
    }

    @Override
    public Shrinkable<A> $minus$eq(A elem1, A elem2, Seq<A> elems) {
        return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Shrinkable<A> $minus$minus$eq(TraversableOnce<A> xs) {
        return Shrinkable.$minus$minus$eq$(this, xs);
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
    public <NewTo> Builder<A, NewTo> mapResult(Function1<scala.collection.mutable.Set<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<A> $plus$plus$eq(TraversableOnce<A> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public /* synthetic */ Object scala$collection$SetLike$$super$map(Function1 f, CanBuildFrom bf) {
        return TraversableLike.map$(this, f, bf);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return scala.collection.SetLike.toBuffer$(this);
    }

    @Override
    public <B, That> That map(Function1<A, B> f, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)scala.collection.SetLike.map$(this, f, bf);
    }

    @Override
    public boolean isEmpty() {
        return scala.collection.SetLike.isEmpty$(this);
    }

    @Override
    public scala.collection.Set union(GenSet that) {
        return scala.collection.SetLike.union$(this, that);
    }

    @Override
    public scala.collection.Set diff(GenSet that) {
        return scala.collection.SetLike.diff$(this, that);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> subsets(int len) {
        return scala.collection.SetLike.subsets$(this, len);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> subsets() {
        return scala.collection.SetLike.subsets$(this);
    }

    @Override
    public String stringPrefix() {
        return scala.collection.SetLike.stringPrefix$(this);
    }

    @Override
    public String toString() {
        return scala.collection.SetLike.toString$(this);
    }

    @Override
    public Object intersect(GenSet that) {
        return GenSetLike.intersect$(this, that);
    }

    @Override
    public Object $amp(GenSet that) {
        return GenSetLike.$amp$(this, that);
    }

    @Override
    public Object $bar(GenSet that) {
        return GenSetLike.$bar$(this, that);
    }

    @Override
    public Object $amp$tilde(GenSet that) {
        return GenSetLike.$amp$tilde$(this, that);
    }

    @Override
    public boolean subsetOf(GenSet<A> that) {
        return GenSetLike.subsetOf$(this, that);
    }

    @Override
    public boolean equals(Object that) {
        return GenSetLike.equals$(this, that);
    }

    @Override
    public int hashCode() {
        return GenSetLike.hashCode$(this);
    }

    @Override
    public Iterable<A> thisCollection() {
        return IterableLike.thisCollection$(this);
    }

    @Override
    public Iterable toCollection(Object repr) {
        return IterableLike.toCollection$(this, repr);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return IterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return IterableLike.exists$(this, p);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return IterableLike.find$(this, p);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)IterableLike.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)IterableLike.reduceRight$(this, op);
    }

    @Override
    public Iterable<A> toIterable() {
        return IterableLike.toIterable$(this);
    }

    @Override
    public Iterator<A> toIterator() {
        return IterableLike.toIterator$(this);
    }

    @Override
    public A head() {
        return (A)IterableLike.head$(this);
    }

    @Override
    public Object slice(int from, int until) {
        return IterableLike.slice$(this, from, until);
    }

    @Override
    public Object take(int n) {
        return IterableLike.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return IterableLike.drop$(this, n);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return IterableLike.takeWhile$(this, p);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> grouped(int size) {
        return IterableLike.grouped$(this, size);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> sliding(int size) {
        return IterableLike.sliding$(this, size);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> sliding(int size, int step) {
        return IterableLike.sliding$(this, size, step);
    }

    @Override
    public Object takeRight(int n) {
        return IterableLike.takeRight$(this, n);
    }

    @Override
    public Object dropRight(int n) {
        return IterableLike.dropRight$(this, n);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IterableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<scala.collection.mutable.Set<A>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zip$(this, that, bf);
    }

    @Override
    public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<scala.collection.mutable.Set<A>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<scala.collection.mutable.Set<A>, Tuple2<A1, Object>, That> bf) {
        return (That)IterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public Stream<A> toStream() {
        return IterableLike.toStream$(this);
    }

    @Override
    public boolean canEqual(Object that) {
        return IterableLike.canEqual$(this, that);
    }

    @Override
    public IterableView<A, scala.collection.mutable.Set<A>> view() {
        return IterableLike.view$(this);
    }

    @Override
    public IterableView<A, scala.collection.mutable.Set<A>> view(int from, int until) {
        return IterableLike.view$(this, from, until);
    }

    @Override
    public <B> Builder<B, scala.collection.mutable.Set<B>> genericBuilder() {
        return GenericTraversableTemplate.genericBuilder$(this);
    }

    @Override
    public <A1, A2> Tuple2<scala.collection.mutable.Set<A1>, scala.collection.mutable.Set<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<scala.collection.mutable.Set<A1>, scala.collection.mutable.Set<A2>, scala.collection.mutable.Set<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
        return GenericTraversableTemplate.unzip3$(this, asTriple);
    }

    @Override
    public GenTraversable flatten(Function1 asTraversable) {
        return GenericTraversableTemplate.flatten$(this, asTraversable);
    }

    @Override
    public GenTraversable transpose(Function1 asTraversable) {
        return GenericTraversableTemplate.transpose$(this, asTraversable);
    }

    @Override
    public Object repr() {
        return TraversableLike.repr$(this);
    }

    @Override
    public final boolean isTraversableAgain() {
        return TraversableLike.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return TraversableLike.hasDefiniteSize$(this);
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    @Override
    public Object filterImpl(Function1 p, boolean isFlipped) {
        return TraversableLike.filterImpl$(this, p, isFlipped);
    }

    @Override
    public Object filter(Function1 p) {
        return TraversableLike.filter$(this, p);
    }

    @Override
    public Object filterNot(Function1 p) {
        return TraversableLike.filterNot$(this, p);
    }

    @Override
    public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public Tuple2<scala.collection.mutable.Set<A>, scala.collection.mutable.Set<A>> partition(Function1<A, Object> p) {
        return TraversableLike.partition$(this, p);
    }

    @Override
    public <K> Map<K, scala.collection.mutable.Set<A>> groupBy(Function1<A, K> f) {
        return TraversableLike.groupBy$(this, f);
    }

    @Override
    public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> cbf) {
        return (That)TraversableLike.scan$(this, z, op, cbf);
    }

    @Override
    public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<scala.collection.mutable.Set<A>, B, That> bf) {
        return (That)TraversableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public Option<A> headOption() {
        return TraversableLike.headOption$(this);
    }

    @Override
    public Object tail() {
        return TraversableLike.tail$(this);
    }

    @Override
    public A last() {
        return (A)TraversableLike.last$(this);
    }

    @Override
    public Option<A> lastOption() {
        return TraversableLike.lastOption$(this);
    }

    @Override
    public Object init() {
        return TraversableLike.init$(this);
    }

    @Override
    public Object sliceWithKnownDelta(int from, int until, int delta) {
        return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
    }

    @Override
    public Object sliceWithKnownBound(int from, int until) {
        return TraversableLike.sliceWithKnownBound$(this, from, until);
    }

    @Override
    public Object dropWhile(Function1 p) {
        return TraversableLike.dropWhile$(this, p);
    }

    @Override
    public Tuple2<scala.collection.mutable.Set<A>, scala.collection.mutable.Set<A>> span(Function1<A, Object> p) {
        return TraversableLike.span$(this, p);
    }

    @Override
    public Tuple2<scala.collection.mutable.Set<A>, scala.collection.mutable.Set<A>> splitAt(int n) {
        return TraversableLike.splitAt$(this, n);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> tails() {
        return TraversableLike.tails$(this);
    }

    @Override
    public Iterator<scala.collection.mutable.Set<A>> inits() {
        return TraversableLike.inits$(this);
    }

    @Override
    public Traversable<A> toTraversable() {
        return TraversableLike.toTraversable$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
        return (Col)TraversableLike.to$(this, cbf);
    }

    @Override
    public FilterMonadic<A, scala.collection.mutable.Set<A>> withFilter(Function1<A, Object> p) {
        return TraversableLike.withFilter$(this, p);
    }

    @Override
    public Parallel par() {
        return Parallelizable.par$(this);
    }

    @Override
    public List<A> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<A, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, A, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
        return TraversableOnce.reduceRightOption$(this, op);
    }

    @Override
    public <A1> A1 reduce(Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.reduce$(this, op);
    }

    @Override
    public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
        return TraversableOnce.reduceOption$(this, op);
    }

    @Override
    public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.fold$(this, z, op);
    }

    @Override
    public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
        return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <B> B sum(Numeric<B> num) {
        return (B)TraversableOnce.sum$(this, num);
    }

    @Override
    public <B> B product(Numeric<B> num) {
        return (B)TraversableOnce.product$(this, num);
    }

    @Override
    public <B> A min(Ordering<B> cmp) {
        return (A)TraversableOnce.min$(this, cmp);
    }

    @Override
    public <B> A max(Ordering<B> cmp) {
        return (A)TraversableOnce.max$(this, cmp);
    }

    @Override
    public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
        return (A)TraversableOnce.maxBy$(this, f, cmp);
    }

    @Override
    public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
        return (A)TraversableOnce.minBy$(this, f, cmp);
    }

    @Override
    public <B> void copyToBuffer(Buffer<B> dest) {
        TraversableOnce.copyToBuffer$(this, dest);
    }

    @Override
    public <B> void copyToArray(Object xs, int start) {
        TraversableOnce.copyToArray$(this, xs, start);
    }

    @Override
    public <B> void copyToArray(Object xs) {
        TraversableOnce.copyToArray$(this, xs);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<A> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public <B> scala.collection.immutable.Set<B> toSet() {
        return TraversableOnce.toSet$(this);
    }

    @Override
    public Vector<A> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
        return TraversableOnce.toMap$(this, ev);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return TraversableOnce.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return TraversableOnce.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return TraversableOnce.mkString$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return TraversableOnce.addString$(this, b, start, sep, end);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String sep) {
        return TraversableOnce.addString$(this, b, sep);
    }

    @Override
    public StringBuilder addString(StringBuilder b) {
        return TraversableOnce.addString$(this, b);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, Object> compose(Function1<A, A> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public <A> Function1<A, A> andThen(Function1<Object, A> g) {
        return Function1.andThen$(this, g);
    }

    public int initialCapacity() {
        return this.initialCapacity;
    }

    public double loadFactor() {
        return this.loadFactor;
    }

    /*
     * WARNING - void declaration
     */
    private int computeCapacity() {
        void var1_1;
        if (this.initialCapacity() < 0) {
            throw new IllegalArgumentException("initial capacity cannot be less than 0");
        }
        for (int candidate = 1; candidate < this.initialCapacity(); candidate *= 2) {
        }
        return (int)var1_1;
    }

    private int computeThreshold() {
        double d = (double)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$util$WeakHashSet$$table)).size() * this.loadFactor();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return (int)RichDouble$.MODULE$.ceil$extension(d);
    }

    public int scala$reflect$internal$util$WeakHashSet$$bucketFor(int hash) {
        int h = hash ^ (hash >>> 20 ^ hash >>> 12);
        h ^= h >>> 7 ^ h >>> 4;
        return h & this.scala$reflect$internal$util$WeakHashSet$$table.length - 1;
    }

    private void remove(int bucket, Entry<A> prevEntry, Entry<A> entry) {
        if (prevEntry == null) {
            this.scala$reflect$internal$util$WeakHashSet$$table[bucket] = entry.tail();
        } else {
            prevEntry.tail_$eq(entry.tail());
        }
        --this.scala$reflect$internal$util$WeakHashSet$$count;
    }

    private void removeStaleEntries() {
        this.queueLoop$1();
    }

    private void resize() {
        Entry[] oldTable = this.scala$reflect$internal$util$WeakHashSet$$table;
        this.scala$reflect$internal$util$WeakHashSet$$table = new Entry[new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])oldTable)).size() * 2];
        this.threshold = this.computeThreshold();
        this.tableLoop$1(0, oldTable);
    }

    @Override
    public A findEntry(A elem) {
        if (elem == null) {
            throw new NullPointerException("WeakHashSet cannot hold nulls");
        }
        this.removeStaleEntries();
        int hash = elem.hashCode();
        int bucket = this.scala$reflect$internal$util$WeakHashSet$$bucketFor(hash);
        return (A)this.linkedListLoop$3(this.scala$reflect$internal$util$WeakHashSet$$table[bucket], elem);
    }

    public A findEntryOrUpdate(A elem) {
        if (elem == null) {
            throw new NullPointerException("WeakHashSet cannot hold nulls");
        }
        this.removeStaleEntries();
        int hash = elem.hashCode();
        int bucket = this.scala$reflect$internal$util$WeakHashSet$$bucketFor(hash);
        Entry<A> oldHead = this.scala$reflect$internal$util$WeakHashSet$$table[bucket];
        return (A)this.linkedListLoop$4(oldHead, elem, bucket, hash, oldHead);
    }

    @Override
    public WeakHashSet<A> $plus(A elem) {
        if (elem == null) {
            throw new NullPointerException("WeakHashSet cannot hold nulls");
        }
        this.removeStaleEntries();
        int hash = elem.hashCode();
        int bucket = this.scala$reflect$internal$util$WeakHashSet$$bucketFor(hash);
        Entry<A> oldHead = this.scala$reflect$internal$util$WeakHashSet$$table[bucket];
        this.linkedListLoop$5(oldHead, elem, bucket, hash, oldHead);
        return this;
    }

    @Override
    public WeakHashSet<A> $plus$eq(A elem) {
        return this.$plus((Object)elem);
    }

    @Override
    public void addEntry(A x) {
        this.$plus$eq((Object)x);
    }

    @Override
    public WeakHashSet<A> $minus(A elem) {
        if (elem != null) {
            this.removeStaleEntries();
            int bucket = this.scala$reflect$internal$util$WeakHashSet$$bucketFor(elem.hashCode());
            this.linkedListLoop$6(null, this.scala$reflect$internal$util$WeakHashSet$$table[bucket], elem, bucket);
        }
        return this;
    }

    @Override
    public WeakHashSet<A> $minus$eq(A elem) {
        return this.$minus((Object)elem);
    }

    @Override
    public void clear() {
        this.scala$reflect$internal$util$WeakHashSet$$table = new Entry[new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$util$WeakHashSet$$table)).size()];
        this.threshold = this.computeThreshold();
        this.scala$reflect$internal$util$WeakHashSet$$count = 0;
        this.queueLoop$2();
    }

    @Override
    public WeakHashSet<A> empty() {
        return new WeakHashSet<A>(this.initialCapacity(), this.loadFactor());
    }

    @Override
    public int size() {
        this.removeStaleEntries();
        return this.scala$reflect$internal$util$WeakHashSet$$count;
    }

    @Override
    public boolean apply(A x) {
        return this.contains(x);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        this.iterator().foreach(f);
    }

    @Override
    public List<A> toList() {
        return this.iterator().toList();
    }

    @Override
    public Iterator<A> iterator() {
        this.removeStaleEntries();
        return new Iterator<A>(this){
            private int currentBucket;
            private Entry<A> entry;
            private A lookaheadelement;
            private final /* synthetic */ WeakHashSet $outer;

            public Iterator<A> seq() {
                return Iterator.seq$(this);
            }

            public boolean isEmpty() {
                return Iterator.isEmpty$(this);
            }

            public boolean isTraversableAgain() {
                return Iterator.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return Iterator.hasDefiniteSize$(this);
            }

            public Iterator<A> take(int n) {
                return Iterator.take$(this, n);
            }

            public Iterator<A> drop(int n) {
                return Iterator.drop$(this, n);
            }

            public Iterator<A> slice(int from, int until) {
                return Iterator.slice$(this, from, until);
            }

            public Iterator<A> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> map(Function1<A, B> f) {
                return Iterator.map$(this, f);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<A, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<A> filter(Function1<A, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<A, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<A> withFilter(Function1<A, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<A> filterNot(Function1<A, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<A, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, A, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<A, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<A> takeWhile(Function1<A, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<A>, Iterator<A>> partition(Function1<A, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<A>, Iterator<A>> span(Function1<A, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<A> dropWhile(Function1<A, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<A, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<A, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<A, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<A, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<A> find(Function1<A, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<A, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<A, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<A> buffered() {
                return Iterator.buffered$(this);
            }

            public <B> Iterator.GroupedIterator<B> grouped(int size) {
                return Iterator.grouped$(this, size);
            }

            public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
                return Iterator.sliding$(this, size, step);
            }

            public <B> int sliding$default$2() {
                return Iterator.sliding$default$2$(this);
            }

            public int length() {
                return Iterator.length$(this);
            }

            public Tuple2<Iterator<A>, Iterator<A>> duplicate() {
                return Iterator.duplicate$(this);
            }

            public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                return Iterator.patch$(this, from, patchElems, replaced);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                Iterator.copyToArray$(this, xs, start, len);
            }

            public boolean sameElements(Iterator<?> that) {
                return Iterator.sameElements$(this, that);
            }

            public Traversable<A> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<A> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<A> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<A, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableOnce.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableOnce.max$(this, cmp);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public List<A> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<A> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<A> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public scala.collection.immutable.IndexedSeq<A> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> scala.collection.immutable.Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableOnce.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableOnce.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableOnce.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableOnce.addString$(this, b, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            public boolean hasNext() {
                while (true) {
                    if (this.entry == null && this.currentBucket > 0) {
                        --this.currentBucket;
                        this.entry = this.$outer.scala$reflect$internal$util$WeakHashSet$$table[this.currentBucket];
                        continue;
                    }
                    if (this.entry == null) {
                        return false;
                    }
                    this.lookaheadelement = this.entry.get();
                    if (this.lookaheadelement != null) break;
                    this.entry = this.entry.tail();
                }
                return true;
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                void var1_1;
                if (this.lookaheadelement == null) {
                    throw new IndexOutOfBoundsException("next on an empty iterator");
                }
                A result2 = this.lookaheadelement;
                this.lookaheadelement = null;
                this.entry = this.entry.tail();
                return var1_1;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Iterator.$init$(this);
                this.currentBucket = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])$outer.scala$reflect$internal$util$WeakHashSet$$table)).size();
                this.entry = null;
                this.lookaheadelement = null;
            }
        };
    }

    public Diagnostics diagnostics() {
        return new Diagnostics();
    }

    private final Entry poll$1() {
        return (Entry)this.queue.poll();
    }

    private final void linkedListLoop$1(Entry prevEntry, Entry entry, Entry stale$1, int bucket$1) {
        while (true) {
            if (stale$1 == entry) {
                this.remove(bucket$1, prevEntry, entry);
                return;
            }
            if (entry == null) break;
            Entry entry2 = entry;
            entry = entry.tail();
            prevEntry = entry2;
        }
    }

    private final void queueLoop$1() {
        Entry stale;
        while ((stale = this.poll$1()) != null) {
            int bucket = this.scala$reflect$internal$util$WeakHashSet$$bucketFor(stale.hash());
            this.linkedListLoop$1(null, this.scala$reflect$internal$util$WeakHashSet$$table[bucket], stale, bucket);
        }
    }

    private final void linkedListLoop$2(Entry entry) {
        while (entry != null) {
            int bucket = this.scala$reflect$internal$util$WeakHashSet$$bucketFor(entry.hash());
            Entry<A> oldNext = entry.tail();
            entry.tail_$eq(this.scala$reflect$internal$util$WeakHashSet$$table[bucket]);
            this.scala$reflect$internal$util$WeakHashSet$$table[bucket] = entry;
            entry = oldNext;
        }
        return;
    }

    private final void tableLoop$1(int oldBucket, Entry[] oldTable$1) {
        while (oldBucket < new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])oldTable$1)).size()) {
            this.linkedListLoop$2(oldTable$1[oldBucket]);
            ++oldBucket;
        }
    }

    private final Object linkedListLoop$3(Entry entry, Object elem$1) {
        Object var3_4;
        block2: {
            Object entryElem;
            while (true) {
                if (entry == null) {
                    var3_4 = null;
                    break block2;
                }
                entryElem = entry.get();
                if (elem$1.equals(entryElem)) break;
                entry = entry.tail();
            }
            var3_4 = entryElem;
        }
        return var3_4;
    }

    private final Object add$1(int bucket$2, Object elem$2, int hash$1, Entry oldHead$1) {
        this.scala$reflect$internal$util$WeakHashSet$$table[bucket$2] = new Entry<Object>(elem$2, hash$1, oldHead$1, this.queue);
        ++this.scala$reflect$internal$util$WeakHashSet$$count;
        if (this.scala$reflect$internal$util$WeakHashSet$$count > this.threshold) {
            this.resize();
        }
        return elem$2;
    }

    private final Object linkedListLoop$4(Entry entry, Object elem$2, int bucket$2, int hash$1, Entry oldHead$1) {
        Object object;
        block2: {
            Object entryElem;
            while (true) {
                if (entry == null) {
                    object = this.add$1(bucket$2, elem$2, hash$1, oldHead$1);
                    break block2;
                }
                entryElem = entry.get();
                if (elem$2.equals(entryElem)) break;
                entry = entry.tail();
            }
            object = entryElem;
        }
        return object;
    }

    private final void add$2(int bucket$3, Object elem$3, int hash$2, Entry oldHead$2) {
        this.scala$reflect$internal$util$WeakHashSet$$table[bucket$3] = new Entry<Object>(elem$3, hash$2, oldHead$2, this.queue);
        ++this.scala$reflect$internal$util$WeakHashSet$$count;
        if (this.scala$reflect$internal$util$WeakHashSet$$count > this.threshold) {
            this.resize();
        }
    }

    private final void linkedListLoop$5(Entry entry, Object elem$3, int bucket$3, int hash$2, Entry oldHead$2) {
        while (true) {
            if (entry == null) {
                this.add$2(bucket$3, elem$3, hash$2, oldHead$2);
                return;
            }
            if (elem$3.equals(entry.get())) {
                return;
            }
            entry = entry.tail();
        }
    }

    private final void linkedListLoop$6(Entry prevEntry, Entry entry, Object elem$4, int bucket$4) {
        while (entry != null) {
            if (elem$4.equals(entry.get())) {
                this.remove(bucket$4, prevEntry, entry);
                return;
            }
            Entry entry2 = entry;
            entry = entry.tail();
            prevEntry = entry2;
        }
        return;
    }

    private final void queueLoop$2() {
        while (this.queue.poll() != null) {
        }
    }

    public WeakHashSet(int initialCapacity, double loadFactor) {
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        TraversableLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        Traversable.$init$(this);
        scala.collection.mutable.Traversable.$init$(this);
        GenIterable.$init$(this);
        IterableLike.$init$(this);
        Iterable.$init$(this);
        scala.collection.mutable.Iterable.$init$(this);
        GenSetLike.$init$(this);
        GenericSetTemplate.$init$(this);
        GenSet.$init$(this);
        Subtractable.$init$(this);
        scala.collection.SetLike.$init$(this);
        scala.collection.Set.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
        Shrinkable.$init$(this);
        Cloneable.$init$(this);
        SetLike.$init$(this);
        scala.collection.mutable.Set.$init$(this);
        this.queue = new ReferenceQueue();
        this.scala$reflect$internal$util$WeakHashSet$$count = 0;
        this.scala$reflect$internal$util$WeakHashSet$$table = new Entry[this.computeCapacity()];
        this.threshold = this.computeThreshold();
    }

    public WeakHashSet() {
        this(WeakHashSet$.MODULE$.defaultInitialCapacity(), WeakHashSet$.MODULE$.defaultLoadFactor());
    }

    public class Diagnostics {
        /*
         * WARNING - void declaration
         */
        public void fullyValidate() {
            void assert_assertion;
            boolean bl;
            IntRef computedCount = IntRef.create(0);
            IntRef bucket = IntRef.create(0);
            while (bucket.elem < new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$table)).size()) {
                ObjectRef entry = ObjectRef.create(this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$table[bucket.elem]);
                while ((Entry)entry.elem != null) {
                    void assert_assertion2;
                    boolean bl2;
                    void assert_assertion3;
                    int realHash;
                    boolean bl3;
                    void assert_assertion4;
                    boolean bl4;
                    boolean bl5 = bl4 = ((Entry)entry.elem).get() != null;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (assert_assertion4 == false) {
                        throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)Diagnostics.$anonfun$fullyValidate$1(entry)).toString());
                    }
                    ++computedCount.elem;
                    int cachedHash = ((Entry)entry.elem).hash();
                    boolean bl6 = bl3 = cachedHash == (realHash = ((Entry)entry.elem).get().hashCode());
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (assert_assertion3 == false) {
                        throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)Diagnostics.$anonfun$fullyValidate$2(entry, cachedHash, realHash)).toString());
                    }
                    int computedBucket = this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$bucketFor(realHash);
                    boolean bl7 = bl2 = computedBucket == bucket.elem;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (assert_assertion2 == false) {
                        throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)Diagnostics.$anonfun$fullyValidate$3(entry, computedBucket, bucket)).toString());
                    }
                    entry.elem = ((Entry)entry.elem).tail();
                }
                ++bucket.elem;
            }
            boolean bl8 = bl = computedCount.elem == this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$count;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)Diagnostics.$anonfun$fullyValidate$4(this, computedCount)).toString());
            }
        }

        public IndexedSeq<Object> dump() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$table)).deep();
        }

        public int collisionBucketsCount() {
            Function1<Entry, Object> & java.io.Serializable & Serializable count_p = (Function1<Entry, Object> & java.io.Serializable & Serializable)entry -> BoxesRunTime.boxToBoolean(Diagnostics.$anonfun$collisionBucketsCount$1(entry));
            ArrayOps.ofRef<Object> count_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$table));
            Scala_collection_TraversableOnce$counter$2 count_counter = new Scala_collection_TraversableOnce$counter$2(null, (Function1)count_p);
            count_this.foreach(count_counter);
            return count_counter.result();
        }

        public int fullBucketsCount() {
            Function1<Entry, Object> & java.io.Serializable & Serializable count_p = (Function1<Entry, Object> & java.io.Serializable & Serializable)entry -> BoxesRunTime.boxToBoolean(Diagnostics.$anonfun$fullBucketsCount$1(entry));
            ArrayOps.ofRef<Object> count_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$table));
            Scala_collection_TraversableOnce$counter$2 count_counter = new Scala_collection_TraversableOnce$counter$2(null, (Function1)count_p);
            count_this.foreach(count_counter);
            return count_counter.result();
        }

        public int bucketsCount() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$table)).size();
        }

        public /* synthetic */ WeakHashSet scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer() {
            return WeakHashSet.this;
        }

        public static final /* synthetic */ String $anonfun$fullyValidate$1(ObjectRef entry$1) {
            return new java.lang.StringBuilder(121).append((Entry)entry$1.elem).append(" had a null value indicated that gc activity was happening during diagnostic validation or that a null value was inserted").toString();
        }

        public static final /* synthetic */ String $anonfun$fullyValidate$2(ObjectRef entry$1, int cachedHash$1, int realHash$1) {
            return new java.lang.StringBuilder(43).append("for ").append((Entry)entry$1.elem).append(" cached hash was ").append(cachedHash$1).append(" but should have been ").append(realHash$1).toString();
        }

        public static final /* synthetic */ String $anonfun$fullyValidate$3(ObjectRef entry$1, int computedBucket$1, IntRef bucket$5) {
            return new java.lang.StringBuilder(51).append("for ").append((Entry)entry$1.elem).append(" the computed bucket was ").append(computedBucket$1).append(" but should have been ").append(bucket$5.elem).toString();
        }

        public static final /* synthetic */ String $anonfun$fullyValidate$4(Diagnostics $this, IntRef computedCount$1) {
            return new java.lang.StringBuilder(45).append("The computed count was ").append(computedCount$1.elem).append(" but should have been ").append($this.scala$reflect$internal$util$WeakHashSet$Diagnostics$$$outer().scala$reflect$internal$util$WeakHashSet$$count).toString();
        }

        public static final /* synthetic */ boolean $anonfun$collisionBucketsCount$1(Entry entry) {
            return entry != null && entry.tail() != null;
        }

        public static final /* synthetic */ boolean $anonfun$fullBucketsCount$1(Entry entry) {
            return entry != null;
        }

        public Diagnostics() {
            if (WeakHashSet.this == null) {
                throw null;
            }
        }
    }

    private static class Entry<A>
    extends WeakReference<A> {
        private final int hash;
        private Entry<A> tail;

        public int hash() {
            return this.hash;
        }

        public Entry<A> tail() {
            return this.tail;
        }

        public void tail_$eq(Entry<A> x$1) {
            this.tail = x$1;
        }

        public Entry(A element, int hash, Entry<A> tail, ReferenceQueue<A> queue) {
            this.hash = hash;
            this.tail = tail;
            super(element, queue);
        }
    }
}

