/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.lang.invoke.LambdaMetafactory;
import scala.Array$;
import scala.Function1;
import scala.Function2;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeq;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.TraversableLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.TreeSet;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.SetBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSet;
import scala.collection.parallel.ParSet$;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\tUaa\u0002\u0011\"!\u0003\r\tA\n\u0005\u00061\u0002!\t!\u0017\u0005\u0006;\u00021\tA\u0018\u0005\u0007?\u0002\u0001K\u0011\u000b1\t\r\u001d\u0004\u0001\u0015\"\u0015i\u0011\u0015a\u0007\u0001\"\u0011n\u0011\u0015\t\b\u0001\"\u0011s\u0011\u0015Y\b\u0001\"\u0011}\u0011\u001d\t)\u0004\u0001D\u0001\u0003oAq!a\u0011\u0001\r\u0003\t)\u0005C\u0004\u0002D\u0001!\t!!\u0013\t\u000f\u0005u\u0003\u0001\"\u0001\u0002`!9\u0011\u0011\u000e\u0001\u0007\u0002\u0005-\u0004bBA8\u0001\u0011\u0005\u0013\u0011\u000f\u0005\b\u0003g\u0002A\u0011AA;\u0011\u001d\t\t\t\u0001C\u0001\u0003\u0007Cq!a\"\u0001\t\u0003\tI\tC\u0004\u0002\b\u0002!\t!a'\u0007\r\u0005u\u0005\u0001BAP\u0011)\t9K\u0005B\u0001B\u0003%\u0011\u0011\u0016\u0005\u000b\u0003'\u0013\"\u0011!Q\u0001\n\u0005U\u0005bBAX%\u0011\u0005\u0011\u0011\u0017\u0005\n\u0003w\u0013\"\u0019!C\u0005\u0003{C\u0001\"!2\u0013A\u0003%\u0011q\u0018\u0005\n\u0003\u000f\u0014\u0002\u0019!C\u0005\u0003cB\u0011\"!3\u0013\u0001\u0004%I!a3\t\u0011\u0005E'\u0003)Q\u0005\u0003sAq!a5\u0013\t\u0003\t\t\bC\u0004\u0002VJ!\t!a6\t\u000f\u0005e\u0007\u0001\"\u0011\u0002\\\"9\u00111\u001f\u0001\u0005B\u0005U\bBDA|\u0001A\u0005\u0019\u0011!A\u0005\n\u0005e(q\u0002\u0002\b'\u0016$H*[6f\u0015\t\u00113%\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001J\u0001\u0006g\u000e\fG.Y\u0002\u0001+\r9#\u0007P\n\u0007\u0001!bc)S(\u0011\u0005%RS\"A\u0012\n\u0005-\u001a#AB!osJ+g\r\u0005\u0003.]AZT\"A\u0011\n\u0005=\n#\u0001D%uKJ\f'\r\\3MS.,\u0007CA\u00193\u0019\u0001!Qa\r\u0001C\u0002Q\u0012\u0011!Q\t\u0003ka\u0002\"!\u000b\u001c\n\u0005]\u001a#a\u0002(pi\"Lgn\u001a\t\u0003SeJ!AO\u0012\u0003\u0007\u0005s\u0017\u0010\u0005\u00022y\u00111Q\b\u0001CC\u0002y\u0012A\u0001\u00165jgF\u0011Qg\u0010\n\u0004\u0001\n\u001be\u0001B!\u0001\u0001}\u0012A\u0002\u0010:fM&tW-\\3oiz\u0002B!\f\u00011wA\u0019Q\u0006\u0012\u0019\n\u0005\u0015\u000b#aA*fiB!Qf\u0012\u0019<\u0013\tA\u0015E\u0001\u0006HK:\u001cV\r\u001e'jW\u0016\u0004BAS'1w5\t1J\u0003\u0002MC\u00059q-\u001a8fe&\u001c\u0017B\u0001(L\u00051\u0019VO\u0019;sC\u000e$\u0018M\u00197f!\u0011i\u0003\u000b\r*\n\u0005E\u000b#A\u0004)be\u0006dG.\u001a7ju\u0006\u0014G.\u001a\t\u0004'Z\u0003T\"\u0001+\u000b\u0005U\u000b\u0013\u0001\u00039be\u0006dG.\u001a7\n\u0005]#&A\u0002)beN+G/\u0001\u0004%S:LG\u000f\n\u000b\u00025B\u0011\u0011fW\u0005\u00039\u000e\u0012A!\u00168ji\u0006)Q-\u001c9usV\t1(\u0001\u0006oK^\u0014U/\u001b7eKJ,\u0012!\u0019\t\u0005E\u0016\u00044(D\u0001d\u0015\t!\u0017%A\u0004nkR\f'\r\\3\n\u0005\u0019\u001c'a\u0002\"vS2$WM]\u0001\fa\u0006\u00148i\\7cS:,'/F\u0001j!\u0011\u0019&\u000e\r*\n\u0005-$&\u0001C\"p[\nLg.\u001a:\u0002\u000bQ|7+Z9\u0016\u00039\u00042!L81\u0013\t\u0001\u0018EA\u0002TKF\f\u0001\u0002^8Ck\u001a4WM]\u000b\u0003gb,\u0012\u0001\u001e\t\u0004EV<\u0018B\u0001<d\u0005\u0019\u0011UO\u001a4feB\u0011\u0011\u0007\u001f\u0003\u0006s\u001a\u0011\rA\u001f\u0002\u0003\u0003F\n\"\u0001\r\u001d\u0002\u00075\f\u0007/F\u0003~\u0003#\t\t\u0001F\u0002\u007f\u0003+!2a`A\u0003!\r\t\u0014\u0011\u0001\u0003\u0007\u0003\u00079!\u0019\u0001\u001b\u0003\tQC\u0017\r\u001e\u0005\b\u0003\u000f9\u00019AA\u0005\u0003\t\u0011g\rE\u0004K\u0003\u0017Y\u0014qB@\n\u0007\u000551J\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000eE\u00022\u0003#!a!a\u0005\b\u0005\u0004!$!\u0001\"\t\u000f\u0005]q\u00011\u0001\u0002\u001a\u0005\ta\r\u0005\u0004*\u00037\u0001\u0014qB\u0005\u0004\u0003;\u0019#!\u0003$v]\u000e$\u0018n\u001c82Q\u001d9\u0011\u0011EA\u0017\u0003c\u0001B!a\t\u0002*5\u0011\u0011Q\u0005\u0006\u0004\u0003O\u0019\u0013AC1o]>$\u0018\r^5p]&!\u00111FA\u0013\u0005%i\u0017n\u001a:bi&|g.\t\u0002\u00020\u0005y4+\u001a;/[\u0006\u0004\bE\\8xAI,G/\u001e:og\u0002\n\u0007eU3uY\u0001\u001ax\u000eI5uA]LG\u000e\u001c\u0011eSN\u001c\u0017M\u001d3!IV\u0004H.[2bi\u0016\u0004c/\u00197vKNt\u0013EAA\u001a\u0003\u0015\u0011d\u0006\u000f\u00181\u0003!\u0019wN\u001c;bS:\u001cH\u0003BA\u001d\u0003\u007f\u00012!KA\u001e\u0013\r\tid\t\u0002\b\u0005>|G.Z1o\u0011\u0019\t\t\u0005\u0003a\u0001a\u0005!Q\r\\3n\u0003\u0015!\u0003\u000f\\;t)\rY\u0014q\t\u0005\u0007\u0003\u0003J\u0001\u0019\u0001\u0019\u0015\u000fm\nY%a\u0014\u0002T!1\u0011Q\n\u0006A\u0002A\nQ!\u001a7f[FBa!!\u0015\u000b\u0001\u0004\u0001\u0014!B3mK6\u0014\u0004bBA+\u0015\u0001\u0007\u0011qK\u0001\u0006K2,Wn\u001d\t\u0005S\u0005e\u0003'C\u0002\u0002\\\r\u0012!\u0002\u0010:fa\u0016\fG/\u001a3?\u0003)!\u0003\u000f\\;tIAdWo\u001d\u000b\u0004w\u0005\u0005\u0004bBA+\u0017\u0001\u0007\u00111\r\t\u0005[\u0005\u0015\u0004'C\u0002\u0002h\u0005\u0012!cR3o)J\fg/\u001a:tC\ndWm\u00148dK\u00061A%\\5okN$2aOA7\u0011\u0019\t\t\u0005\u0004a\u0001a\u00059\u0011n]#naRLXCAA\u001d\u0003\u0015)h.[8o)\rY\u0014q\u000f\u0005\b\u0003sr\u0001\u0019AA>\u0003\u0011!\b.\u0019;\u0011\t5\ni\bM\u0005\u0004\u0003\u007f\n#AB$f]N+G/\u0001\u0003eS\u001a4GcA\u001e\u0002\u0006\"9\u0011\u0011P\bA\u0002\u0005m\u0014aB:vEN,Go\u001d\u000b\u0005\u0003\u0017\u000b\t\n\u0005\u0003.\u0003\u001b[\u0014bAAHC\tA\u0011\n^3sCR|'\u000fC\u0004\u0002\u0014B\u0001\r!!&\u0002\u00071,g\u000eE\u0002*\u0003/K1!!'$\u0005\rIe\u000e\u001e\u000b\u0003\u0003\u0017\u0013!bU;cg\u0016$8/\u0013;s'\r\u0011\u0012\u0011\u0015\t\u0005[\u0005\r6(C\u0002\u0002&\u0006\u0012\u0001#\u00112tiJ\f7\r^%uKJ\fGo\u001c:\u0002\t\u0015dWn\u001d\t\u0005[\u0005-\u0006'C\u0002\u0002.\u0006\u0012!\"\u00138eKb,GmU3r\u0003\u0019a\u0014N\\5u}Q1\u00111WA\\\u0003s\u00032!!.\u0013\u001b\u0005\u0001\u0001bBAT+\u0001\u0007\u0011\u0011\u0016\u0005\b\u0003'+\u0002\u0019AAK\u0003\u0011IG\r_:\u0016\u0005\u0005}\u0006#B\u0015\u0002B\u0006U\u0015bAAbG\t)\u0011I\u001d:bs\u0006)\u0011\u000e\u001a=tA\u0005Aq\f[1t\u001d\u0016DH/\u0001\u0007`Q\u0006\u001ch*\u001a=u?\u0012*\u0017\u000fF\u0002[\u0003\u001bD\u0011\"a4\u001a\u0003\u0003\u0005\r!!\u000f\u0002\u0007a$\u0013'A\u0005`Q\u0006\u001ch*\u001a=uA\u00059\u0001.Y:OKb$\u0018\u0001\u00028fqR$\u0012aO\u0001\rgR\u0014\u0018N\\4Qe\u00164\u0017\u000e_\u000b\u0003\u0003;\u0004B!a8\u0002n:!\u0011\u0011]Au!\r\t\u0019oI\u0007\u0003\u0003KT1!a:&\u0003\u0019a$o\\8u}%\u0019\u00111^\u0012\u0002\rA\u0013X\rZ3g\u0013\u0011\ty/!=\u0003\rM#(/\u001b8h\u0015\r\tYoI\u0001\ti>\u001cFO]5oOR\u0011\u0011Q\\\u0001\ngV\u0004XM\u001d\u0013nCB,b!a?\u0003\n\t\u0005A\u0003BA\u007f\u0005\u0017!B!a@\u0003\u0004A\u0019\u0011G!\u0001\u0005\r\u0005\rqD1\u00015\u0011\u001d\t9a\ba\u0002\u0005\u000b\u0001\u0002BSA\u0006w\t\u001d\u0011q \t\u0004c\t%AABA\n?\t\u0007A\u0007C\u0004\u0002\u0018}\u0001\rA!\u0004\u0011\r%\nY\u0002\rB\u0004\u0013\rY(\u0011C\u0005\u0004\u0005'\t#a\u0004+sCZ,'o]1cY\u0016d\u0015n[3")
public interface SetLike<A, This extends SetLike<A, This> & Set<A>>
extends IterableLike<A, This>,
GenSetLike<A, This>,
Subtractable<A, This> {
    public /* synthetic */ Object scala$collection$SetLike$$super$map(Function1 var1, CanBuildFrom var2);

    public This empty();

    public static /* synthetic */ Builder newBuilder$(SetLike $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<A, This> newBuilder() {
        return new SetBuilder(this.empty());
    }

    public static /* synthetic */ Combiner parCombiner$(SetLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<A, ParSet<A>> parCombiner() {
        return ParSet$.MODULE$.newCombiner();
    }

    public static /* synthetic */ Seq toSeq$(SetLike $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<A> toSeq() {
        if (this.isEmpty()) {
            return package$.MODULE$.Vector().empty();
        }
        Builder vb = package$.MODULE$.Vector().newBuilder();
        this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x$1 -> vb.$plus$eq(x$1));
        return vb.result();
    }

    public static /* synthetic */ Buffer toBuffer$(SetLike $this) {
        return $this.toBuffer();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <A1> Buffer<A1> toBuffer() {
        void var1_1;
        ArrayBuffer result2 = new ArrayBuffer(this.size());
        this.foreach((Function1<Object, ArrayBuffer> & java.io.Serializable & Serializable)x$2 -> result2.$plus$eq(x$2));
        return var1_1;
    }

    public static /* synthetic */ Object map$(SetLike $this, Function1 f, CanBuildFrom bf) {
        return $this.map((Function1<A, B>)f, bf);
    }

    @Override
    default public <B, That> That map(Function1<A, B> f, CanBuildFrom<This, B, That> bf) {
        return (That)this.scala$collection$SetLike$$super$map(f, bf);
    }

    @Override
    public boolean contains(A var1);

    @Override
    public This $plus(A var1);

    public static /* synthetic */ Set $plus$(SetLike $this, Object elem1, Object elem2, Seq elems) {
        return $this.$plus(elem1, elem2, elems);
    }

    default public This $plus(A elem1, A elem2, Seq<A> elems) {
        return this.$plus(elem1).$plus(elem2).$plus$plus(elems);
    }

    public static /* synthetic */ Set $plus$plus$(SetLike $this, GenTraversableOnce elems) {
        return $this.$plus$plus(elems);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    default public This $plus$plus(GenTraversableOnce<A> elems) {
        block17: {
            block19: {
                block18: {
                    block16: {
                        if (this != Set$.MODULE$.empty()) break block16;
                        if (elems instanceof HashSet && (var6_2 = (HashSet)elems).size() > 4) {
                            var5_3 /* !! */  = var6_2;
                        } else if (elems instanceof Set.Set1) {
                            var5_3 /* !! */  = (Set.Set1)elems;
                        } else if (elems instanceof Set.Set2) {
                            var5_3 /* !! */  = (Set.Set2)elems;
                        } else if (elems instanceof Set.Set3) {
                            var5_3 /* !! */  = (Set.Set3)elems;
                        } else if (elems instanceof Set.Set4) {
                            var5_3 /* !! */  = (Set.Set4)elems;
                        } else {
                            if (elems.isEmpty()) {
                                v0 = (Set)this;
                            } else {
                                var7_4 = (Set)this.repr();
                                v0 = elems.seq().$div$colon(var7_4, (Function2<Set, Object, Set> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$$plus$plus$1(scala.collection.Set java.lang.Object ), (Lscala/collection/Set;Ljava/lang/Object;)Lscala/collection/Set;)());
                            }
                            var5_3 /* !! */  = v0;
                        }
                        var2_5 = var5_3 /* !! */ ;
                        break block17;
                    }
                    if (!(this instanceof HashSet)) break block18;
                    var8_6 = (HashSet)this;
                    if (elems instanceof GenSet) {
                        var9_7 = (GenSet)elems;
                        var4_8 = var8_6.union(var9_7);
                    } else {
                        var10_9 = (Set)this.repr();
                        var4_8 = elems.seq().$div$colon(var10_9, (Function2<Set, Object, Set> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$$plus$plus$2(scala.collection.Set java.lang.Object ), (Lscala/collection/Set;Ljava/lang/Object;)Lscala/collection/Set;)());
                    }
                    var2_5 = var4_8;
                    break block17;
                }
                if (!(this instanceof TreeSet)) break block19;
                var11_10 = (TreeSet)this;
                if (!(elems instanceof TreeSet)) ** GOTO lbl-1000
                var12_11 = (TreeSet)elems;
                v1 = var11_10.ordering();
                var13_12 = var12_11.ordering();
                if (!(v1 != null ? v1.equals(var13_12) == false : var13_12 != null)) {
                    var3_13 = var11_10.addAllTreeSetImpl(var12_11);
                } else lbl-1000:
                // 2 sources

                {
                    var14_14 = (Set)this.repr();
                    var3_13 = elems.seq().$div$colon(var14_14, (Function2<Set, Object, Set> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$$plus$plus$3(scala.collection.Set java.lang.Object ), (Lscala/collection/Set;Ljava/lang/Object;)Lscala/collection/Set;)());
                }
                var2_5 = var3_13;
                break block17;
            }
            var15_15 = (Set)this.repr();
            var2_5 = elems.seq().$div$colon(var15_15, (Function2<Set, Object, Set> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$$plus$plus$4(scala.collection.Set java.lang.Object ), (Lscala/collection/Set;Ljava/lang/Object;)Lscala/collection/Set;)());
        }
        return (This)var2_5;
    }

    @Override
    public This $minus(A var1);

    public static /* synthetic */ boolean isEmpty$(SetLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return this.size() == 0;
    }

    public static /* synthetic */ Set union$(SetLike $this, GenSet that) {
        return $this.union(that);
    }

    @Override
    default public This union(GenSet<A> that) {
        return this.$plus$plus(that);
    }

    public static /* synthetic */ Set diff$(SetLike $this, GenSet that) {
        return $this.diff(that);
    }

    @Override
    default public This diff(GenSet<A> that) {
        return (This)((Set)this.$minus$minus(that));
    }

    public static /* synthetic */ Iterator subsets$(SetLike $this, int len) {
        return $this.subsets(len);
    }

    default public Iterator<This> subsets(int len) {
        if (len < 0 || len > this.size()) {
            return Iterator$.MODULE$.empty();
        }
        return new SubsetsItr(this, this.toIndexedSeq(), len);
    }

    public static /* synthetic */ Iterator subsets$(SetLike $this) {
        return $this.subsets();
    }

    default public Iterator<This> subsets() {
        return new AbstractIterator<This>(this){
            private final scala.collection.immutable.IndexedSeq<A> elms;
            private int len;
            private Iterator<This> itr;
            private final /* synthetic */ SetLike $outer;

            private scala.collection.immutable.IndexedSeq<A> elms() {
                return this.elms;
            }

            private int len() {
                return this.len;
            }

            private void len_$eq(int x$1) {
                this.len = x$1;
            }

            private Iterator<This> itr() {
                return this.itr;
            }

            private void itr_$eq(Iterator<This> x$1) {
                this.itr = x$1;
            }

            public boolean hasNext() {
                return this.len() <= this.elms().size() || this.itr().hasNext();
            }

            public This next() {
                if (!this.itr().hasNext()) {
                    if (this.len() > this.elms().size()) {
                        Iterator$.MODULE$.empty().next();
                    } else {
                        this.itr_$eq(new SubsetsItr(this.$outer, this.elms(), this.len()));
                        this.len_$eq(this.len() + 1);
                    }
                }
                return (This)((Set)this.itr().next());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.elms = $outer.toIndexedSeq();
                this.len = 0;
                this.itr = Iterator$.MODULE$.empty();
            }
        };
    }

    public static /* synthetic */ String stringPrefix$(SetLike $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return "Set";
    }

    public static /* synthetic */ String toString$(SetLike $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        return TraversableLike.toString$(this);
    }

    public static /* synthetic */ Set $anonfun$$plus$plus$1(Set x$4, Object x$5) {
        return x$4.$plus(x$5);
    }

    public static /* synthetic */ Set $anonfun$$plus$plus$2(Set x$7, Object x$8) {
        return x$7.$plus(x$8);
    }

    public static /* synthetic */ Set $anonfun$$plus$plus$3(Set x$10, Object x$11) {
        return x$10.$plus(x$11);
    }

    public static /* synthetic */ Set $anonfun$$plus$plus$4(Set x$13, Object x$14) {
        return x$13.$plus(x$14);
    }

    public static void $init$(SetLike $this) {
    }

    public class SubsetsItr
    extends AbstractIterator<This> {
        private final IndexedSeq<A> elms;
        private final int len;
        private final int[] idxs;
        private boolean _hasNext;
        public final /* synthetic */ SetLike $outer;

        private int[] idxs() {
            return this.idxs;
        }

        private boolean _hasNext() {
            return this._hasNext;
        }

        private void _hasNext_$eq(boolean x$1) {
            this._hasNext = x$1;
        }

        @Override
        public boolean hasNext() {
            return this._hasNext();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public This next() {
            void var2_6;
            int i;
            if (!this.hasNext()) {
                Iterator$.MODULE$.empty().next();
            }
            Builder buf = this.scala$collection$SetLike$SubsetsItr$$$outer().newBuilder();
            ArrayOps.ofInt foreach_this = new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps((int[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(this.idxs())).slice(0, this.len)));
            int foreach_len = foreach_this.length();
            for (int foreach_i = 0; foreach_i < foreach_len; ++foreach_i) {
                Object a = foreach_this.apply(foreach_i);
                SubsetsItr.$anonfun$next$1(this, buf, BoxesRunTime.unboxToInt(a));
            }
            Set result2 = (Set)buf.result();
            for (i = this.len - 1; i >= 0 && this.idxs()[i] == this.idxs()[i + 1] - 1; --i) {
            }
            if (i < 0) {
                this._hasNext_$eq(false);
            } else {
                this.idxs()[i] = this.idxs()[i] + 1;
                int n = i + 1;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                Range range = RichInt$.MODULE$.until$extension0(n, this.len);
                if (range == null) {
                    throw null;
                }
                Range foreach$mVc$sp_this = range;
                if (!foreach$mVc$sp_this.isEmpty()) {
                    int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                    while (true) {
                        this.idxs()[foreach$mVc$sp_i] = this.idxs()[foreach$mVc$sp_i - 1] + 1;
                        if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                        foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                    }
                }
            }
            return var2_6;
        }

        public /* synthetic */ SetLike scala$collection$SetLike$SubsetsItr$$$outer() {
            return this.$outer;
        }

        public SubsetsItr(SetLike $outer, IndexedSeq<A> elms, int len) {
            this.elms = elms;
            this.len = len;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.idxs = Array$.MODULE$.range(0, len + 1);
            this._hasNext = true;
            this.idxs()[len] = elms.size();
        }
    }
}

