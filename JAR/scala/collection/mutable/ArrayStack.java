/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.List;
import scala.collection.mutable.AbstractSeq;
import scala.collection.mutable.ArrayStack$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqLike;
import scala.collection.mutable.IndexedSeqView;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\tEr!B\u0015+\u0011\u0003\td!B\u001a+\u0011\u0003!\u0004B\u0002?\u0002\t\u0003\t9\fC\u0004\u0002:\u0006!\u0019!a/\t\u000f\u0005e\u0017\u0001\"\u0001\u0002\\\"9\u0011q]\u0001\u0005\u0002\u0005%\bbBA\u0002\u0003\u0011\u0005\u0011Q\u001e\u0005\t\u0005'\tA\u0011\u0001\u0016\u0003\u0016!A\u0011\u0011V\u0001\u0005\u0002)\u0012I\u0002C\u0005\u0003\u001e\u0005\t\t\u0011\"\u0003\u0003 \u0019!1G\u000b\u0001=\u0011!\u0019'B!a\u0001\n\u0013!\u0007\u0002C6\u000b\u0005\u0003\u0007I\u0011\u00027\t\u0011IT!\u0011!Q!\n\u0015D\u0001b\u001d\u0006\u0003\u0002\u0004%I\u0001\u001e\u0005\tq*\u0011\t\u0019!C\u0005s\"A1P\u0003B\u0001B\u0003&Q\u000fC\u0003}\u0015\u0011%Q\u0010\u0003\u0004}\u0015\u0011\u0005\u0011\u0011\u0001\u0005\b\u0003\u0007QA\u0011AA\u0003\u0011\u0019\tYA\u0003C\u0001i\"9\u0011Q\u0002\u0006\u0005B\u0005=\u0001bBA\n\u0015\u0011\u0005\u0011Q\u0003\u0005\b\u0003;QA\u0011AA\u0010\u0011\u001d\t)C\u0003C\u0001\u0003OAq!!\u000b\u000b\t\u0003\tY\u0003C\u0004\u0002.)!\t!a\f\t\u000f\u0005E\"\u0002\"\u0001\u00020!9\u00111\u0007\u0006\u0005\u0002\u0005U\u0002bBA!\u0015\u0011\u0005\u00131\t\u0005\b\u0003'RA\u0011AA+\u0011\u001d\tIF\u0003C\u0001\u0003\u0003Aq!a\u0017\u000b\t\u0013\ty\u0003C\u0004\u0002^)!\t!a\u0018\t\u000f\u0005%$\u0002\"\u0001\u0002l!1\u0011q\u000e\u0006\u0005BQDq!!\u001d\u000b\t\u0003\t\u0019\bC\u0004\u0002\u0006*!\t%a\"\t\u000f\u0005=%\u0002\"\u0011\u0002\u0012\"9\u0011\u0011\u0014\u0006\u0005B\u0005m\u0005bBAU\u0015\u0011\u0005\u0013\u0011A\u0001\u000b\u0003J\u0014\u0018-_*uC\u000e\\'BA\u0016-\u0003\u001diW\u000f^1cY\u0016T!!\f\u0018\u0002\u0015\r|G\u000e\\3di&|gNC\u00010\u0003\u0015\u00198-\u00197b\u0007\u0001\u0001\"AM\u0001\u000e\u0003)\u0012!\"\u0011:sCf\u001cF/Y2l'\r\tQ\u0007\u0019\t\u0004meZT\"A\u001c\u000b\u0005ab\u0013aB4f]\u0016\u0014\u0018nY\u0005\u0003u]\u0012!bU3r\r\u0006\u001cGo\u001c:z!\t\u0011$\"\u0006\u0002>\u0007NI!BP'Q)^SV\f\u0019\t\u0004e}\n\u0015B\u0001!+\u0005-\t%m\u001d;sC\u000e$8+Z9\u0011\u0005\t\u001bE\u0002\u0001\u0003\u0006\t*\u0011\r!\u0012\u0002\u0002)F\u0011aI\u0013\t\u0003\u000f\"k\u0011AL\u0005\u0003\u0013:\u0012qAT8uQ&tw\r\u0005\u0002H\u0017&\u0011AJ\f\u0002\u0004\u0003:L\bc\u0001\u001aO\u0003&\u0011qJ\u000b\u0002\u000b\u0013:$W\r_3e'\u0016\f\b\u0003\u0002\u001aR\u0003NK!A\u0015\u0016\u0003\u001d%sG-\u001a=fIN+\u0017\u000fT5lKB\u0019!GC!\u0011\tY*\u0016iO\u0005\u0003-^\u0012!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u0004BA\r-B'&\u0011\u0011L\u000b\u0002\u0014\u0013:$W\r_3e'\u0016\fx\n\u001d;j[&TX\r\u001a\t\u0004em\u001b\u0016B\u0001/+\u0005%\u0019En\u001c8fC\ndW\r\u0005\u00033=\u0006\u001b\u0016BA0+\u0005\u001d\u0011U/\u001b7eKJ\u0004\"aR1\n\u0005\tt#\u0001D*fe&\fG.\u001b>bE2,\u0017!\u0002;bE2,W#A3\u0011\u0007\u001d3\u0007.\u0003\u0002h]\t)\u0011I\u001d:bsB\u0011q)[\u0005\u0003U:\u0012a!\u00118z%\u00164\u0017!\u0003;bE2,w\fJ3r)\ti\u0007\u000f\u0005\u0002H]&\u0011qN\f\u0002\u0005+:LG\u000fC\u0004r\u0019\u0005\u0005\t\u0019A3\u0002\u0007a$\u0013'\u0001\u0004uC\ndW\rI\u0001\u0006S:$W\r_\u000b\u0002kB\u0011qI^\u0005\u0003o:\u00121!\u00138u\u0003%Ig\u000eZ3y?\u0012*\u0017\u000f\u0006\u0002nu\"9\u0011oDA\u0001\u0002\u0004)\u0018AB5oI\u0016D\b%\u0001\u0004=S:LGO\u0010\u000b\u0004'z|\b\"B2\u0012\u0001\u0004)\u0007\"B:\u0012\u0001\u0004)H#A*\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0007\u0005\u000b9\u0001\u0003\u0004\u0002\nM\u0001\r!^\u0001\u0002]\u00061A.\u001a8hi\"\f\u0011bY8na\u0006t\u0017n\u001c8\u0016\u0005\u0005EaB\u0001\u001a\u0001\u0003\u0019)\b\u000fZ1uKR)Q.a\u0006\u0002\u001a!1\u0011\u0011\u0002\fA\u0002UDa!a\u0007\u0017\u0001\u0004\t\u0015a\u00028fo\u0016dW-\\\u0001\u0005aV\u001c\b\u000eF\u0002n\u0003CAa!a\t\u0018\u0001\u0004\t\u0015!\u0001=\u0002\u0007A|\u0007\u000fF\u0001B\u0003\r!x\u000e]\u000b\u0002\u0003\u0006\u0019A-\u001e9\u0015\u00035\fQa\u00197fCJ\fQ\u0001\u001a:bS:$2!\\A\u001c\u0011\u001d\tI\u0004\ba\u0001\u0003w\t\u0011A\u001a\t\u0006\u000f\u0006u\u0012)\\\u0005\u0004\u0003\u007fq#!\u0003$v]\u000e$\u0018n\u001c82\u00035!\u0003\u000f\\;tIAdWo\u001d\u0013fcR!\u0011QIA$\u001b\u0005Q\u0001bBA%;\u0001\u0007\u00111J\u0001\u0003qN\u0004R!!\u0014\u0002P\u0005k\u0011\u0001L\u0005\u0004\u0003#b#a\u0004+sCZ,'o]1cY\u0016|enY3\u0002\u0011\u0011\u0002H.^:%KF$B!!\u0012\u0002X!1\u00111\u0005\u0010A\u0002\u0005\u000baA]3tk2$\u0018\u0001\u0004:fm\u0016\u00148/\u001a+bE2,\u0017aB2p[\nLg.\u001a\u000b\u0004[\u0006\u0005\u0004bBA\u001dC\u0001\u0007\u00111\r\t\u0007\u000f\u0006\u0015\u0014)Q!\n\u0007\u0005\u001ddFA\u0005Gk:\u001cG/[8oe\u0005Q!/\u001a3vG\u0016<\u0016\u000e\u001e5\u0015\u00075\fi\u0007C\u0004\u0002:\t\u0002\r!a\u0019\u0002\tML'0Z\u0001\u000baJ,7/\u001a:wS:<W\u0003BA;\u0003s\"B!a\u001e\u0002|A\u0019!)!\u001f\u0005\u000b\u0011##\u0019A#\t\u0011\u0005uD\u0005\"a\u0001\u0003\u007f\na!Y2uS>t\u0007#B$\u0002\u0002\u0006]\u0014bAAB]\tAAHY=oC6,g(A\u0004jg\u0016k\u0007\u000f^=\u0016\u0005\u0005%\u0005cA$\u0002\f&\u0019\u0011Q\u0012\u0018\u0003\u000f\t{w\u000e\\3b]\u0006A\u0011\u000e^3sCR|'/\u0006\u0002\u0002\u0014B)\u0011QJAK\u0003&\u0019\u0011q\u0013\u0017\u0003\u0011%#XM]1u_J\fqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0002\u001e\u0006\u0015FcA7\u0002 \"9\u0011\u0011H\u0014A\u0002\u0005\u0005\u0006CB$\u0002>\u0005\u000b\u0019\u000bE\u0002C\u0003K#a!a*(\u0005\u0004)%!A+\u0002\u000b\rdwN\\3)\u000f)\ti+a-\u00026B\u0019q)a,\n\u0007\u0005EfF\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\t\u0006)a/\u00197vKzAa/xcw9t\u0005l\fF\u00012\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0011\ti,a5\u0016\u0005\u0005}\u0006#\u0003\u001c\u0002B\u0006\u0015\u0017\u0011[Al\u0013\r\t\u0019m\u000e\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0005\u0003\u000f\fI-D\u0001\u0002\u0013\u0011\tY-!4\u0003\t\r{G\u000e\\\u0005\u0004\u0003\u001f<$\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o!\r\u0011\u00151\u001b\u0003\u0007\u0003+\u001c!\u0019A#\u0003\u0003\u0005\u0003BA\r\u0006\u0002R\u0006Qa.Z<Ck&dG-\u001a:\u0016\t\u0005u\u00171]\u000b\u0003\u0003?\u0004bA\r0\u0002b\u0006\u0015\bc\u0001\"\u0002d\u00121\u0011Q\u001b\u0003C\u0002\u0015\u0003BA\r\u0006\u0002b\u0006)Q-\u001c9usV\u0011\u00111\u001e\t\u0004e)1U\u0003BAx\u0003o$B!!=\u0003\nQ!\u00111_A}!\u0011\u0011$\"!>\u0011\u0007\t\u000b9\u0010\u0002\u0004\u0002V\u001a\u0011\r!\u0012\u0005\n\u0003w4\u0011\u0011!a\u0002\u0003{\f!\"\u001a<jI\u0016t7-\u001a\u00132!\u0019\tyP!\u0002\u0002v6\u0011!\u0011\u0001\u0006\u0004\u0005\u0007q\u0013a\u0002:fM2,7\r^\u0005\u0005\u0005\u000f\u0011\tA\u0001\u0005DY\u0006\u001c8\u000fV1h\u0011\u001d\u0011YA\u0002a\u0001\u0005\u001b\tQ!\u001a7f[N\u0004Ra\u0012B\b\u0003kL1A!\u0005/\u0005)a$/\u001a9fCR,GMP\u0001\nOJ|w/\u0011:sCf$2!\u001aB\f\u0011\u0019\t\u0019c\u0002a\u0001KR\u0019QMa\u0007\t\r\u0005\r\u0002\u00021\u0001f\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\t\u0005\u0002\u0003\u0002B\u0012\u0005[i!A!\n\u000b\t\t\u001d\"\u0011F\u0001\u0005Y\u0006twM\u0003\u0002\u0003,\u0005!!.\u0019<b\u0013\u0011\u0011yC!\n\u0003\r=\u0013'.Z2u\u0001")
public class ArrayStack<T>
extends AbstractSeq<T>
implements IndexedSeq<T>,
scala.collection.mutable.IndexedSeqOptimized<T, ArrayStack<T>>,
Builder<T, ArrayStack<T>>,
Serializable {
    public static final long serialVersionUID = 8565219180626620510L;
    private Object[] scala$collection$mutable$ArrayStack$$table;
    private int scala$collection$mutable$ArrayStack$$index;

    public static ArrayStack<Nothing$> empty() {
        return ArrayStack$.MODULE$.empty();
    }

    public static <A> CanBuildFrom<ArrayStack<?>, A, ArrayStack<A>> canBuildFrom() {
        return ArrayStack$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return ArrayStack$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)arrayStack$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return ArrayStack$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ArrayStack$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ tabulate_this = arrayStack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ tabulate_this = arrayStack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ tabulate_this = arrayStack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ tabulate_this = arrayStack$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ArrayStack$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ fill_this = arrayStack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ fill_this = arrayStack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ fill_this = arrayStack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        ArrayStack$ fill_this = arrayStack$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ArrayStack$ arrayStack$ = ArrayStack$.MODULE$;
        if (arrayStack$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)arrayStack$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ArrayStack$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ArrayStack$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ArrayStack$.MODULE$.empty();
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
    public <NewTo> Builder<T, NewTo> mapResult(Function1<ArrayStack<T>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<T> $plus$eq(T elem1, T elem2, Seq<T> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
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
    public boolean forall(Function1<T, Object> p) {
        return IndexedSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<T, Object> p) {
        return IndexedSeqOptimized.exists$(this, p);
    }

    @Override
    public Option<T> find(Function1<T, Object> p) {
        return IndexedSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, T, B> op) {
        return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<T, B, B> op) {
        return (B)IndexedSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, T, B> op) {
        return (B)IndexedSeqOptimized.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<T, B, B> op) {
        return (B)IndexedSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<ArrayStack<T>, Tuple2<A1, B>, That> bf) {
        return (That)IndexedSeqOptimized.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<ArrayStack<T>, Tuple2<A1, Object>, That> bf) {
        return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
    }

    @Override
    public Object slice(int from, int until) {
        return IndexedSeqOptimized.slice$(this, from, until);
    }

    @Override
    public T head() {
        return (T)IndexedSeqOptimized.head$(this);
    }

    @Override
    public Object tail() {
        return IndexedSeqOptimized.tail$(this);
    }

    @Override
    public T last() {
        return (T)IndexedSeqOptimized.last$(this);
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
    public Tuple2<ArrayStack<T>, ArrayStack<T>> splitAt(int n) {
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
    public Tuple2<ArrayStack<T>, ArrayStack<T>> span(Function1<T, Object> p) {
        return IndexedSeqOptimized.span$(this, p);
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
    public int segmentLength(Function1<T, Object> p, int from) {
        return IndexedSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<T, Object> p, int from) {
        return IndexedSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<T, Object> p, int end) {
        return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Object reverse() {
        return IndexedSeqOptimized.reverse$(this);
    }

    @Override
    public Iterator<T> reverseIterator() {
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
    public List<T> toList() {
        return IndexedSeqOptimized.toList$(this);
    }

    @Override
    public IndexedSeq<T> seq() {
        return IndexedSeq.seq$(this);
    }

    @Override
    public IndexedSeq<T> thisCollection() {
        return IndexedSeqLike.thisCollection$(this);
    }

    @Override
    public IndexedSeq toCollection(Object repr) {
        return IndexedSeqLike.toCollection$(this, repr);
    }

    @Override
    public IndexedSeqView<T, ArrayStack<T>> view() {
        return IndexedSeqLike.view$(this);
    }

    @Override
    public IndexedSeqView<T, ArrayStack<T>> view(int from, int until) {
        return IndexedSeqLike.view$(this, from, until);
    }

    @Override
    public int hashCode() {
        return scala.collection.IndexedSeqLike.hashCode$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return scala.collection.IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return scala.collection.IndexedSeqLike.sizeHintIfCheap$(this);
    }

    public Object[] scala$collection$mutable$ArrayStack$$table() {
        return this.scala$collection$mutable$ArrayStack$$table;
    }

    private void scala$collection$mutable$ArrayStack$$table_$eq(Object[] x$1) {
        this.scala$collection$mutable$ArrayStack$$table = x$1;
    }

    public int scala$collection$mutable$ArrayStack$$index() {
        return this.scala$collection$mutable$ArrayStack$$index;
    }

    private void scala$collection$mutable$ArrayStack$$index_$eq(int x$1) {
        this.scala$collection$mutable$ArrayStack$$index = x$1;
    }

    @Override
    public T apply(int n) {
        return (T)this.scala$collection$mutable$ArrayStack$$table()[this.scala$collection$mutable$ArrayStack$$index() - 1 - n];
    }

    @Override
    public int length() {
        return this.scala$collection$mutable$ArrayStack$$index();
    }

    public ArrayStack$ companion() {
        return ArrayStack$.MODULE$;
    }

    @Override
    public void update(int n, T newelem) {
        this.scala$collection$mutable$ArrayStack$$table()[this.scala$collection$mutable$ArrayStack$$index() - 1 - n] = newelem;
    }

    public void push(T x) {
        if (this.scala$collection$mutable$ArrayStack$$index() == this.scala$collection$mutable$ArrayStack$$table().length) {
            this.scala$collection$mutable$ArrayStack$$table_$eq(ArrayStack$.MODULE$.growArray(this.scala$collection$mutable$ArrayStack$$table()));
        }
        this.scala$collection$mutable$ArrayStack$$table()[this.scala$collection$mutable$ArrayStack$$index()] = x;
        this.scala$collection$mutable$ArrayStack$$index_$eq(this.scala$collection$mutable$ArrayStack$$index() + 1);
    }

    /*
     * WARNING - void declaration
     */
    public T pop() {
        void var1_1;
        if (this.scala$collection$mutable$ArrayStack$$index() == 0) {
            throw package$.MODULE$.error("Stack empty");
        }
        this.scala$collection$mutable$ArrayStack$$index_$eq(this.scala$collection$mutable$ArrayStack$$index() - 1);
        Object x = this.scala$collection$mutable$ArrayStack$$table()[this.scala$collection$mutable$ArrayStack$$index()];
        this.scala$collection$mutable$ArrayStack$$table()[this.scala$collection$mutable$ArrayStack$$index()] = null;
        return var1_1;
    }

    public T top() {
        return (T)this.scala$collection$mutable$ArrayStack$$table()[this.scala$collection$mutable$ArrayStack$$index() - 1];
    }

    public void dup() {
        this.push(this.top());
    }

    @Override
    public void clear() {
        this.scala$collection$mutable$ArrayStack$$index_$eq(0);
        this.scala$collection$mutable$ArrayStack$$table_$eq(new Object[1]);
    }

    public void drain(Function1<T, BoxedUnit> f) {
        while (!this.isEmpty()) {
            f.apply(this.pop());
        }
    }

    @Override
    public ArrayStack<T> $plus$plus$eq(TraversableOnce<T> xs) {
        xs.foreach((Function1<Object, ArrayStack> & java.io.Serializable & Serializable)(A x) -> this.$plus$eq(x));
        return this;
    }

    @Override
    public ArrayStack<T> $plus$eq(T x) {
        this.push(x);
        return this;
    }

    @Override
    public ArrayStack<T> result() {
        this.reverseTable();
        return this;
    }

    private void reverseTable() {
        int until = this.scala$collection$mutable$ArrayStack$$index() / 2;
        for (int i = 0; i < until; ++i) {
            int revi = this.scala$collection$mutable$ArrayStack$$index() - i - 1;
            Object tmp = this.scala$collection$mutable$ArrayStack$$table()[i];
            this.scala$collection$mutable$ArrayStack$$table()[i] = this.scala$collection$mutable$ArrayStack$$table()[revi];
            this.scala$collection$mutable$ArrayStack$$table()[revi] = tmp;
        }
    }

    public void combine(Function2<T, T, T> f) {
        this.push(f.apply(this.pop(), this.pop()));
    }

    public void reduceWith(Function2<T, T, T> f) {
        while (this.size() > 1) {
            this.combine(f);
        }
    }

    @Override
    public int size() {
        return this.scala$collection$mutable$ArrayStack$$index();
    }

    public <T> T preserving(Function0<T> action) {
        T t;
        int oldIndex = this.scala$collection$mutable$ArrayStack$$index();
        Object[] oldTable = ArrayStack$.MODULE$.clone(this.scala$collection$mutable$ArrayStack$$table());
        try {
            t = action.apply();
        }
        finally {
            this.scala$collection$mutable$ArrayStack$$index_$eq(oldIndex);
            this.scala$collection$mutable$ArrayStack$$table_$eq(oldTable);
        }
        return t;
    }

    @Override
    public boolean isEmpty() {
        return this.scala$collection$mutable$ArrayStack$$index() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this){
            private int currentIndex;
            private final /* synthetic */ ArrayStack $outer;

            private int currentIndex() {
                return this.currentIndex;
            }

            private void currentIndex_$eq(int x$1) {
                this.currentIndex = x$1;
            }

            public boolean hasNext() {
                return this.currentIndex() > 0;
            }

            public T next() {
                this.currentIndex_$eq(this.currentIndex() - 1);
                return (T)this.$outer.scala$collection$mutable$ArrayStack$$table()[this.currentIndex()];
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.currentIndex = $outer.scala$collection$mutable$ArrayStack$$index();
            }
        };
    }

    @Override
    public <U> void foreach(Function1<T, U> f) {
        int currentIndex = this.scala$collection$mutable$ArrayStack$$index();
        while (currentIndex > 0) {
            f.apply(this.scala$collection$mutable$ArrayStack$$table()[--currentIndex]);
        }
    }

    @Override
    public ArrayStack<T> clone() {
        return new ArrayStack<T>(ArrayStack$.MODULE$.clone(this.scala$collection$mutable$ArrayStack$$table()), this.scala$collection$mutable$ArrayStack$$index());
    }

    public ArrayStack(Object[] table, int index) {
        this.scala$collection$mutable$ArrayStack$$table = table;
        this.scala$collection$mutable$ArrayStack$$index = index;
        scala.collection.IndexedSeqLike.$init$(this);
        scala.collection.IndexedSeq.$init$(this);
        IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        IndexedSeqOptimized.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
    }

    public ArrayStack() {
        this(new Object[1], 0);
    }
}

