/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.MatchError;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeq$;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.HasNewBuilder;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005EdaB\u0007\u000f!\u0003\r\t!\u0006\u0005\u0006\u0001\u0002!\t!\u0011\u0005\u0006\u000b\u00021\tA\u0012\u0005\u0006!\u00021\t!\u0015\u0005\u0006%\u00021\ta\u0015\u0005\u0006/\u00021\t\u0001\u0017\u0005\u0007;\u0002\u0001K\u0011\u00030\t\u000b\u0015\u0004A\u0011\u00014\t\u000b5\u0004A\u0011\u00028\t\u000bI\u0004A\u0011A:\t\u000f\u0005%\u0001\u0001\"\u0001\u0002\f!9\u0011\u0011\u0007\u0001\u0005\u0002\u0005M\u0002bBA%\u0001\u0011\u0005\u00111\n\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\u0006\u0003\u001fA\tqaZ3oKJL7M\u0003\u0002\u0012%\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003M\tQa]2bY\u0006\u001c\u0001!F\u0002\u0017C1\u001a2\u0001A\f\u001c!\tA\u0012$D\u0001\u0013\u0013\tQ\"C\u0001\u0004B]f\u0014VM\u001a\t\u00059uy\"&D\u0001\u000f\u0013\tqbBA\u0007ICNtUm\u001e\"vS2$WM\u001d\t\u0003A\u0005b\u0001\u0001\u0002\u0004#\u0001\u0011\u0015\ra\t\u0002\u0002\u0003F\u0011Ae\n\t\u00031\u0015J!A\n\n\u0003\u000f9{G\u000f[5oOB\u0011\u0001\u0004K\u0005\u0003SI\u00111!\u00118zU\tYs\u0007E\u0002!Y}!a!\f\u0001\u0005\u0006\u0004q#AA\"D+\tyS'\u0005\u0002%aA\u0019\u0011G\r\u001b\u000e\u0003AI!a\r\t\u0003\u001d\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mKB\u0011\u0001%\u000e\u0003\u0006m1\u0012\ra\t\u0002\u00021.\n\u0001\b\u0005\u0002:}5\t!H\u0003\u0002<y\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0003{I\t!\"\u00198o_R\fG/[8o\u0013\ty$HA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fa\u0001J5oSR$C#\u0001\"\u0011\u0005a\u0019\u0015B\u0001#\u0013\u0005\u0011)f.\u001b;\u0002\u000f\u0019|'/Z1dQV\u0011qI\u0014\u000b\u0003\u0005\"CQ!\u0013\u0002A\u0002)\u000b\u0011A\u001a\t\u00051-{R*\u0003\u0002M%\tIa)\u001e8di&|g.\r\t\u0003A9#Qa\u0014\u0002C\u0002\r\u0012\u0011!V\u0001\u0005Q\u0016\fG-F\u0001 \u0003\u001dI7/R7qif,\u0012\u0001\u0016\t\u00031UK!A\u0016\n\u0003\u000f\t{w\u000e\\3b]\u0006I1m\\7qC:LwN\\\u000b\u00023B\u0019AD\u0017/\n\u0005ms!\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o!\t\u0001C&\u0001\u0006oK^\u0014U/\u001b7eKJ,\u0012a\u0018\t\u0005A\u000e|2&D\u0001b\u0015\t\u0011\u0007#A\u0004nkR\f'\r\\3\n\u0005\u0011\f'a\u0002\"vS2$WM]\u0001\u000fO\u0016tWM]5d\u0005VLG\u000eZ3s+\t9'.F\u0001i!\u0011\u00017-\u001b7\u0011\u0005\u0001RG!B6\b\u0005\u0004\u0019#!\u0001\"\u0011\u0007\u0001b\u0013.\u0001\u0006tKF,XM\u001c;jC2,\u0012a\u001c\t\u0004cA|\u0012BA9\u0011\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0017!B;ou&\u0004Xc\u0001;{}R\u0019Q/!\u0001\u0011\ta1\b\u0010`\u0005\u0003oJ\u0011a\u0001V;qY\u0016\u0014\u0004c\u0001\u0011-sB\u0011\u0001E\u001f\u0003\u0006w&\u0011\ra\t\u0002\u0003\u0003F\u00022\u0001\t\u0017~!\t\u0001c\u0010B\u0003\u0000\u0013\t\u00071E\u0001\u0002Be!9\u00111A\u0005A\u0004\u0005\u0015\u0011AB1t!\u0006L'\u000fE\u0003\u0019\u0017~\t9\u0001\u0005\u0003\u0019mfl\u0018AB;ou&\u00048'\u0006\u0005\u0002\u000e\u0005e\u0011qDA\u0013)\u0011\ty!!\u000b\u0011\u0013a\t\t\"!\u0006\u0002\u001c\u0005\u0005\u0012bAA\n%\t1A+\u001e9mKN\u0002B\u0001\t\u0017\u0002\u0018A\u0019\u0001%!\u0007\u0005\u000bmT!\u0019A\u0012\u0011\t\u0001b\u0013Q\u0004\t\u0004A\u0005}A!B@\u000b\u0005\u0004\u0019\u0003\u0003\u0002\u0011-\u0003G\u00012\u0001IA\u0013\t\u0019\t9C\u0003b\u0001G\t\u0011\u0011i\r\u0005\b\u0003WQ\u00019AA\u0017\u0003!\t7\u000f\u0016:ja2,\u0007#\u0002\rL?\u0005=\u0002#\u0003\r\u0002\u0012\u0005]\u0011QDA\u0012\u0003\u001d1G.\u0019;uK:,B!!\u000e\u0002<Q!\u0011qGA\u001f!\u0011\u0001C&!\u000f\u0011\u0007\u0001\nY\u0004B\u0003l\u0017\t\u00071\u0005C\u0004\u0002@-\u0001\u001d!!\u0011\u0002\u001b\u0005\u001cHK]1wKJ\u001c\u0018M\u00197f!\u0015A2jHA\"!\u0015\t\u0014QIA\u001d\u0013\r\t9\u0005\u0005\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-A\u0005ue\u0006t7\u000f]8tKV!\u0011QJA,)\u0011\ty%!\u0017\u0011\t\u0001b\u0013\u0011\u000b\u0016\u0004\u0003':\u0004\u0003\u0002\u0011-\u0003+\u00022\u0001IA,\t\u0015YGB1\u0001$\u0011\u001d\ty\u0004\u0004a\u0002\u00037\u0002R\u0001G& \u0003;\u0002R!MA#\u0003+Bs\u0001DA1\u0003S\ni\u0007\u0005\u0003\u0002d\u0005\u0015T\"\u0001\u001f\n\u0007\u0005\u001dDHA\u0005nS\u001e\u0014\u0018\r^5p]\u0006\u0012\u00111N\u0001YAR\u0014\u0018M\\:q_N,\u0007\r\t;ie><8\u000fI1oA\u0001LE\u000e\\3hC2\f%oZ;nK:$X\t_2faRLwN\u001c1!S\u001a\u00043m\u001c7mK\u000e$\u0018n\u001c8tA\u0005\u0014X\r\t8pi\u0002*h.\u001b4pe6d\u0017\u0010I:ju\u0016$g&\t\u0002\u0002p\u0005)!GL\u001d/a\u0001")
public interface GenericTraversableTemplate<A, CC extends GenTraversable<Object>>
extends HasNewBuilder<A, CC> {
    public <U> void foreach(Function1<A, U> var1);

    public A head();

    public boolean isEmpty();

    public GenericCompanion<CC> companion();

    public static /* synthetic */ Builder newBuilder$(GenericTraversableTemplate $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<A, CC> newBuilder() {
        return this.companion().newBuilder();
    }

    public static /* synthetic */ Builder genericBuilder$(GenericTraversableTemplate $this) {
        return $this.genericBuilder();
    }

    default public <B> Builder<B, CC> genericBuilder() {
        return this.companion().newBuilder();
    }

    private TraversableOnce<A> sequential() {
        return ((GenTraversableOnce)((Object)this)).seq();
    }

    public static /* synthetic */ Tuple2 unzip$(GenericTraversableTemplate $this, Function1 asPair) {
        return $this.unzip(asPair);
    }

    default public <A1, A2> Tuple2<CC, CC> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
        Builder b1 = this.genericBuilder();
        Builder b2 = this.genericBuilder();
        this.sequential().foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)xy -> {
            Tuple2 tuple2 = (Tuple2)asPair.apply(xy);
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Object T1 = tuple2._1();
            Object T2 = tuple2._2();
            b1.$plus$eq((Object)T1);
            return b2.$plus$eq((Object)T2);
        });
        return new Tuple2<CC, CC>(b1.result(), b2.result());
    }

    public static /* synthetic */ Tuple3 unzip3$(GenericTraversableTemplate $this, Function1 asTriple) {
        return $this.unzip3(asTriple);
    }

    default public <A1, A2, A3> Tuple3<CC, CC, CC> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
        Builder b1 = this.genericBuilder();
        Builder b2 = this.genericBuilder();
        Builder b3 = this.genericBuilder();
        this.sequential().foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)xyz -> {
            Tuple3 tuple3 = (Tuple3)asTriple.apply(xyz);
            if (tuple3 == null) {
                throw new MatchError((Object)null);
            }
            Object T1 = tuple3._1();
            Object T2 = tuple3._2();
            Object T3 = tuple3._3();
            b1.$plus$eq((Object)T1);
            b2.$plus$eq((Object)T2);
            return b3.$plus$eq((Object)T3);
        });
        return new Tuple3<CC, CC, CC>(b1.result(), b2.result(), b3.result());
    }

    public static /* synthetic */ GenTraversable flatten$(GenericTraversableTemplate $this, Function1 asTraversable) {
        return $this.flatten(asTraversable);
    }

    default public <B> CC flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
        Builder b = this.genericBuilder();
        this.sequential().foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)xs -> (Builder)b.$plus$plus$eq(((GenTraversableOnce)asTraversable.apply(xs)).seq()));
        return (CC)((GenTraversable)b.result());
    }

    public static /* synthetic */ GenTraversable transpose$(GenericTraversableTemplate $this, Function1 asTraversable) {
        return $this.transpose(asTraversable);
    }

    default public <B> CC transpose(Function1<A, GenTraversableOnce<B>> asTraversable) {
        if (this.isEmpty()) {
            return (CC)((GenTraversable)this.genericBuilder().result());
        }
        int headSize = asTraversable.apply(this.head()).size();
        IndexedSeq$ indexedSeq$ = IndexedSeq$.MODULE$;
        if (indexedSeq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)indexedSeq$).newBuilder();
        fill_b.sizeHint(headSize);
        for (int fill_i = 0; fill_i < headSize; ++fill_i) {
            fill_b.$plus$eq(this.genericBuilder());
        }
        IndexedSeq bs = (IndexedSeq)((GenTraversable)fill_b.result());
        this.sequential().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)xs -> {
            GenericTraversableTemplate.$anonfun$transpose$2(asTraversable, headSize, bs, xs);
            return BoxedUnit.UNIT;
        });
        Builder bb = this.genericBuilder();
        bs.foreach((Function1<Builder, Builder> & java.io.Serializable & Serializable)b -> bb.$plus$eq((Object)b.result()));
        return (CC)((GenTraversable)bb.result());
    }

    private static Nothing$ fail$1() {
        throw new IllegalArgumentException("transpose requires all collections have the same size");
    }

    public static /* synthetic */ void $anonfun$transpose$3(IntRef i$1, int headSize$1, IndexedSeq bs$1, Object x) {
        if (i$1.elem >= headSize$1) {
            throw GenericTraversableTemplate.fail$1();
        }
        ((Builder)bs$1.apply(i$1.elem)).$plus$eq(x);
        ++i$1.elem;
    }

    public static /* synthetic */ void $anonfun$transpose$2(Function1 asTraversable$2, int headSize$1, IndexedSeq bs$1, Object xs) {
        IntRef i = IntRef.create(0);
        ((GenTraversableOnce)asTraversable$2.apply(xs)).seq().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            GenericTraversableTemplate.$anonfun$transpose$3(i, headSize$1, bs$1, x);
            return BoxedUnit.UNIT;
        });
        if (i.elem != headSize$1) {
            throw GenericTraversableTemplate.fail$1();
        }
    }

    public static void $init$(GenericTraversableTemplate $this) {
    }
}

