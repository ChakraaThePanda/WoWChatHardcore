/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Array$;
import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.AbstractIterable;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.HashMap;
import scala.collection.immutable.HashMap$;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.HashSet$;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Iterable$;
import scala.collection.immutable.ListSet$;
import scala.collection.immutable.Range;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.math.Numeric$IntIsIntegral$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0005%eA\u0002\u00180\u0003\u0003\tT\u0007\u0003\u0005I\u0001\t\u0005\t\u0015!\u0003J\u0011\u0015\u0001\u0006\u0001\"\u0001R\u0011\u0019!\u0006A\"\u00010+\")1\f\u0001C\u00019\")\u0001\r\u0001C\u0001C\")q\u000e\u0001C\u0001a\")!\u000f\u0001C\u0001g\")A\u000f\u0001C\u00019\")Q\u000f\u0001C\u0001m\"1!\u0010\u0001Q!\nuCaa\u001f\u0001!B\u0013\u0011\u0007B\u0002?\u0001A\u0003&\u0011\u000f\u0003\u0004~\u0001\u0001\u0006Ka\u0019\u0005\u0007}\u0002\u0001\u000b\u0015B/\t\r}\u0004\u0001\u0015)\u0003x\u0011!\t\t\u0001\u0001Q\u0005\n\u0005\r\u0001\u0002CA\u0004\u0001\u0001&I!!\u0003\u0006\u0011\u00055\u0001\u0001)A\u0005\u0003\u001fAq!a\u0006\u0001\t\u0013\tI\u0002C\u0004\u0002$\u0001!I!!\n\u0007\r\u0005%\u0002AAA\u0016\u0011\u001dYVC1A\u0005BqC!\"!\f\u0016\t\u0003\u0005\t\u0015!\u0003^\u0011\u001d\u0001WC1A\u0005B\u0005D!\"a\f\u0016\t\u0003\u0005\t\u0015!\u0003c\u0011\u001dyWC1A\u0005BAD!\"!\r\u0016\t\u0003\u0005\t\u0015!\u0003r\u0011\u001d\u0011XC1A\u0005BMD!\"a\r\u0016\t\u0003\u0005\t\u0015!\u0003d\u0011\u001d!XC1A\u0005BqC!\"!\u000e\u0016\t\u0003\u0005\t\u0015!\u0003^\u0011\u001d)XC1A\u0005BYD!\"a\u000e\u0016\t\u0003\u0005\t\u0015!\u0003x\u0011%\tI$\u0006B\u0001B\u0003%\u0011\n\u0003\u0004Q+\u0011\u0005\u00111\b\u0005\u0007)V!)%a\u0011\t\u000f\u0005\u001d\u0003\u0001\"\u0001\u0002J!A\u00111\n\u0001!\n\u0013\ti\u0005\u0003\u0005\u0002R\u0001\u0001K\u0011BA*\u0011!\tI\u0006\u0001Q\u0005\n\u0005m\u0003\u0002CA1\u0001\u0001&I!a\u0019\t\u000f\u0005%\u0004\u0001\"\u0001\u0002l!9\u0011Q\u000e\u0001\u0005\u0002\u0005=\u0004\u0002CA9\u0001\u0001&I!a\u001d\t\u000f\u0005\u0015\u0005\u0001\"\u0001\u0002\b\naAK]5f\u0013R,'/\u0019;pe*\u0011\u0001'M\u0001\nS6lW\u000f^1cY\u0016T!AM\u001a\u0002\u0015\r|G\u000e\\3di&|gNC\u00015\u0003\u0015\u00198-\u00197b+\t1Th\u0005\u0002\u0001oA\u0019\u0001(O\u001e\u000e\u0003EJ!AO\u0019\u0003!\u0005\u00137\u000f\u001e:bGRLE/\u001a:bi>\u0014\bC\u0001\u001f>\u0019\u0001!aA\u0010\u0001\u0005\u0006\u0004\u0001%!\u0001+\u0004\u0001E\u0011\u0011)\u0012\t\u0003\u0005\u000ek\u0011aM\u0005\u0003\tN\u0012qAT8uQ&tw\r\u0005\u0002C\r&\u0011qi\r\u0002\u0004\u0003:L\u0018!B3mK6\u001c\bc\u0001\"K\u0019&\u00111j\r\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0004\u001b:[T\"A\u0018\n\u0005={#\u0001C%uKJ\f'\r\\3\u0002\rqJg.\u001b;?)\t\u00116\u000bE\u0002N\u0001mBQ\u0001\u0013\u0002A\u0002%\u000bqaZ3u\u000b2,W\u000e\u0006\u0002<-\")qk\u0001a\u00011\u0006\t\u0001\u0010\u0005\u0002C3&\u0011!l\r\u0002\u0007\u0003:L(+\u001a4\u0002\u0013%t\u0017\u000e\u001e#faRDW#A/\u0011\u0005\ts\u0016BA04\u0005\rIe\u000e^\u0001\u000fS:LG/\u0011:sCf\u001cF/Y2l+\u0005\u0011\u0007c\u0001\"KGB\u0019!I\u00133\u0011\u00075sUM\u000b\u0002<M.\nq\r\u0005\u0002i[6\t\u0011N\u0003\u0002kW\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0003YN\n!\"\u00198o_R\fG/[8o\u0013\tq\u0017NA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fA\"\u001b8jiB{7o\u0015;bG.,\u0012!\u001d\t\u0004\u0005*k\u0016AC5oSR\f%O]1z\tV\t1-\u0001\u0005j]&$\bk\\:E\u0003-Ig.\u001b;Tk\nLE/\u001a:\u0016\u0003]\u00042\u0001\u000f=<\u0013\tI\u0018G\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u0015!W\r\u001d;i\u0003)\t'O]1z'R\f7m[\u0001\ta>\u001c8\u000b^1dW\u00061\u0011M\u001d:bs\u0012\u000bA\u0001]8t\t\u000691/\u001e2Ji\u0016\u0014\u0018\u0001C4fi\u0016cW-\\:\u0015\u0007%\u000b)\u0001C\u0003X!\u0001\u0007A*\u0001\td_2d\u0017n]5p]R{\u0017I\u001d:bsR\u0019\u0011*a\u0003\t\u000b]\u000b\u0002\u0019\u0001'\u0003\u001dM\u0003H.\u001b;Ji\u0016\u0014\u0018\r^8sgB1!)!\u0005\u0002\u0016]L1!a\u00054\u0005\u0019!V\u000f\u001d7feA)!)!\u0005x;\u00061\u0011n\u001d+sS\u0016$B!a\u0007\u0002\"A\u0019!)!\b\n\u0007\u0005}1GA\u0004C_>dW-\u00198\t\u000b]\u001b\u0002\u0019\u0001-\u0002\u0017%\u001c8i\u001c8uC&tWM\u001d\u000b\u0005\u00037\t9\u0003C\u0003X)\u0001\u0007\u0001LA\u0006EkBLE/\u001a:bi>\u00148CA\u000bS\u0003)Ig.\u001b;EKB$\b\u000eI\u0001\u0010S:LG/\u0011:sCf\u001cF/Y2lA\u0005i\u0011N\\5u!>\u001c8\u000b^1dW\u0002\n1\"\u001b8ji\u0006\u0013(/Y=EA\u0005I\u0011N\\5u!>\u001cH\tI\u0001\rS:LGoU;c\u0013R,'\u000fI\u0001\u0003qN$B!!\u0010\u0002BA\u0019\u0011qH\u000b\u000e\u0003\u0001Aa!!\u000f$\u0001\u0004IEcA\u001e\u0002F!)q\u000b\na\u00011\u0006YA-\u001e9Ji\u0016\u0014\u0018\r^8s+\u0005\u0011\u0016a\u00038fo&#XM]1u_J$2AUA(\u0011\u0019\tID\na\u0001\u0013\u0006\u0001\u0012\u000e^3sCR|'oV5uQNK'0\u001a\u000b\u0005\u0003+\t)\u0006\u0003\u0004\u0002X\u001d\u0002\r!S\u0001\u0004CJ\u0014\u0018\u0001E1se\u0006LHk\\%uKJ\fGo\u001c:t)\u0011\ti&a\u0018\u0011\u0007\u0005}\"\u0003\u0003\u0004\u0002X!\u0002\r!S\u0001\u000bgBd\u0017\u000e^!se\u0006LH\u0003BA/\u0003KBa!a\u001a*\u0001\u0004I\u0015AA1e\u0003\u001dA\u0017m\u001d(fqR,\"!a\u0007\u0002\t9,\u0007\u0010\u001e\u000b\u0002w\u0005)a.\u001a=uaQ)1(!\u001e\u0002x!)\u0001\n\fa\u0001\u0013\"1\u0011\u0011\u0010\u0017A\u0002u\u000b\u0011!\u001b\u0015\u0004Y\u0005u\u0004\u0003BA@\u0003\u0003k\u0011a[\u0005\u0004\u0003\u0007['a\u0002;bS2\u0014XmY\u0001\u0006gBd\u0017\u000e^\u000b\u0003\u0003;\u0002")
public abstract class TrieIterator<T>
extends AbstractIterator<T> {
    private final Iterable<T>[] elems;
    public int scala$collection$immutable$TrieIterator$$depth;
    public Iterable<T>[][] scala$collection$immutable$TrieIterator$$arrayStack;
    public int[] scala$collection$immutable$TrieIterator$$posStack;
    public Iterable<T>[] scala$collection$immutable$TrieIterator$$arrayD;
    public int scala$collection$immutable$TrieIterator$$posD;
    public Iterator<T> scala$collection$immutable$TrieIterator$$subIter;

    public abstract T getElem(Object var1);

    public int initDepth() {
        return 0;
    }

    public Iterable<T>[][] initArrayStack() {
        return new Iterable[6][];
    }

    public int[] initPosStack() {
        return new int[6];
    }

    public Iterable<T>[] initArrayD() {
        return this.elems;
    }

    public int initPosD() {
        return 0;
    }

    public Iterator<T> initSubIter() {
        return null;
    }

    private Iterable<T>[] getElems(Iterable<T> x) {
        AbstractIterable[] abstractIterableArray;
        if (x instanceof HashMap.HashTrieMap) {
            HashMap.HashTrieMap hashTrieMap = (HashMap.HashTrieMap)x;
            if (hashTrieMap == null) {
                throw null;
            }
            abstractIterableArray = hashTrieMap.elems0();
        } else if (x instanceof HashSet.HashTrieSet) {
            abstractIterableArray = ((HashSet.HashTrieSet)x).elems();
        } else {
            throw new MatchError(x);
        }
        return (Iterable[])abstractIterableArray;
    }

    private Iterable<T>[] collisionToArray(Iterable<T> x2) {
        AbstractIterable[] abstractIterableArray;
        if (x2 instanceof HashMap.HashMapCollision1) {
            abstractIterableArray = (AbstractIterable[])((TraversableOnce)((HashMap.HashMapCollision1)x2).kvs().map((Function1<Tuple2, HashMap> & java.io.Serializable & Serializable)x -> (HashMap)HashMap$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new Tuple2[]{x})), Iterable$.MODULE$.canBuildFrom())).toArray(ClassTag$.MODULE$.apply(HashMap.class));
        } else if (x2 instanceof HashSet.HashSetCollision1) {
            abstractIterableArray = (AbstractIterable[])((TraversableOnce)((HashSet.HashSetCollision1)x2).ks().map((Function1<Object, HashSet> & java.io.Serializable & Serializable)x -> (HashSet)HashSet$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{x})), ListSet$.MODULE$.canBuildFrom())).toArray(ClassTag$.MODULE$.apply(HashSet.class));
        } else {
            throw new MatchError(x2);
        }
        return (Iterable[])abstractIterableArray;
    }

    private boolean isTrie(Object x) {
        boolean bl = x instanceof HashMap.HashTrieMap ? true : x instanceof HashSet.HashTrieSet;
        boolean bl2 = bl;
        return bl2;
    }

    private boolean isContainer(Object x) {
        boolean bl = x instanceof HashMap.HashMap1 ? true : x instanceof HashSet.HashSet1;
        boolean bl2 = bl;
        return bl2;
    }

    public TrieIterator<T> dupIterator() {
        return new DupIterator(this.elems);
    }

    private TrieIterator<T> newIterator(Iterable<T>[] xs) {
        return new TrieIterator<T>(this, xs){
            private final /* synthetic */ TrieIterator $outer;

            public final T getElem(Object x) {
                return this.$outer.getElem(x);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super(xs$1);
            }
        };
    }

    private Tuple2<Iterator<T>, Object> iteratorWithSize(Iterable<T>[] arr) {
        return new Tuple2<Iterator<T>, Object>(this.newIterator(arr), new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps((int[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])arr)), (Function1<Iterable, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToInteger(x$1.size()), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Int())))).sum(Numeric$IntIsIntegral$.MODULE$));
    }

    private Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>> arrayToIterators(Iterable<T>[] arr) {
        Tuple2<Object[], Object[]> tuple2 = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])arr)).splitAt(arr.length / 2);
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        Iterable[] iterableArray = (Iterable[])tuple2._1();
        Iterable[] iterableArray2 = (Iterable[])tuple2._2();
        Iterable[] fst = iterableArray;
        Iterable[] snd = iterableArray2;
        return new Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>>(this.iteratorWithSize(snd), this.newIterator(fst));
    }

    private Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>> splitArray(Iterable<T>[] ad) {
        while (true) {
            if (ad.length > 1) {
                return this.arrayToIterators(ad);
            }
            Iterable<T> iterable = ad[0];
            boolean bl = iterable instanceof HashMap.HashMapCollision1 ? true : iterable instanceof HashSet.HashSetCollision1;
            if (bl) break;
            ad = this.getElems(ad[0]);
        }
        Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>> tuple2 = this.arrayToIterators(this.collisionToArray(ad[0]));
        return tuple2;
    }

    @Override
    public boolean hasNext() {
        return this.scala$collection$immutable$TrieIterator$$subIter != null || this.scala$collection$immutable$TrieIterator$$depth >= 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public T next() {
        if (this.scala$collection$immutable$TrieIterator$$subIter != null) {
            void var1_1;
            T el = this.scala$collection$immutable$TrieIterator$$subIter.next();
            if (!this.scala$collection$immutable$TrieIterator$$subIter.hasNext()) {
                this.scala$collection$immutable$TrieIterator$$subIter = null;
            }
            return var1_1;
        }
        return this.next0(this.scala$collection$immutable$TrieIterator$$arrayD, this.scala$collection$immutable$TrieIterator$$posD);
    }

    private T next0(Iterable<T>[] elems, int i) {
        Iterable<T> m;
        while (true) {
            if (i == elems.length - 1) {
                --this.scala$collection$immutable$TrieIterator$$depth;
                if (this.scala$collection$immutable$TrieIterator$$depth >= 0) {
                    this.scala$collection$immutable$TrieIterator$$arrayD = this.scala$collection$immutable$TrieIterator$$arrayStack[this.scala$collection$immutable$TrieIterator$$depth];
                    this.scala$collection$immutable$TrieIterator$$posD = this.scala$collection$immutable$TrieIterator$$posStack[this.scala$collection$immutable$TrieIterator$$depth];
                    this.scala$collection$immutable$TrieIterator$$arrayStack[this.scala$collection$immutable$TrieIterator$$depth] = null;
                } else {
                    this.scala$collection$immutable$TrieIterator$$arrayD = null;
                    this.scala$collection$immutable$TrieIterator$$posD = 0;
                }
            } else {
                ++this.scala$collection$immutable$TrieIterator$$posD;
            }
            m = elems[i];
            if (this.isContainer(m)) {
                return this.getElem(m);
            }
            if (!this.isTrie(m)) break;
            if (this.scala$collection$immutable$TrieIterator$$depth >= 0) {
                this.scala$collection$immutable$TrieIterator$$arrayStack[this.scala$collection$immutable$TrieIterator$$depth] = this.scala$collection$immutable$TrieIterator$$arrayD;
                this.scala$collection$immutable$TrieIterator$$posStack[this.scala$collection$immutable$TrieIterator$$depth] = this.scala$collection$immutable$TrieIterator$$posD;
            }
            ++this.scala$collection$immutable$TrieIterator$$depth;
            this.scala$collection$immutable$TrieIterator$$arrayD = this.getElems(m);
            this.scala$collection$immutable$TrieIterator$$posD = 0;
            i = 0;
            elems = this.getElems(m);
        }
        this.scala$collection$immutable$TrieIterator$$subIter = m.iterator();
        return this.next();
    }

    public Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>> split() {
        if (this.scala$collection$immutable$TrieIterator$$arrayD != null && this.scala$collection$immutable$TrieIterator$$depth == 0 && this.scala$collection$immutable$TrieIterator$$posD == 0) {
            return this.splitArray(this.scala$collection$immutable$TrieIterator$$arrayD);
        }
        if (this.scala$collection$immutable$TrieIterator$$subIter != null) {
            Buffer buff = this.scala$collection$immutable$TrieIterator$$subIter.toBuffer();
            this.scala$collection$immutable$TrieIterator$$subIter = null;
            return new Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>>(new Tuple2(buff.iterator(), BoxesRunTime.boxToInteger(buff.length())), this);
        }
        if (this.scala$collection$immutable$TrieIterator$$depth > 0) {
            if (this.scala$collection$immutable$TrieIterator$$posStack[0] == this.scala$collection$immutable$TrieIterator$$arrayStack[0].length - 1) {
                Iterable[] snd = (Iterable[])((Object[])new Iterable[]{(Iterable)new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$immutable$TrieIterator$$arrayStack[0])).last()});
                int szsnd = snd[0].size();
                --this.scala$collection$immutable$TrieIterator$$depth;
                int n = 1;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                Range range = RichInt$.MODULE$.until$extension0(n, this.scala$collection$immutable$TrieIterator$$arrayStack.length);
                if (range == null) {
                    throw null;
                }
                Range foreach$mVc$sp_this = range;
                if (!foreach$mVc$sp_this.isEmpty()) {
                    int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                    while (true) {
                        this.scala$collection$immutable$TrieIterator$$arrayStack[foreach$mVc$sp_i - 1] = this.scala$collection$immutable$TrieIterator$$arrayStack[foreach$mVc$sp_i];
                        if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                        foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                    }
                }
                this.scala$collection$immutable$TrieIterator$$arrayStack[this.scala$collection$immutable$TrieIterator$$arrayStack.length - 1] = (Iterable[])((Object[])new Iterable[]{null});
                this.scala$collection$immutable$TrieIterator$$posStack = (int[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps((int[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(this.scala$collection$immutable$TrieIterator$$posStack)).tail())).$plus$plus(new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps((int[])Array$.MODULE$.apply(Predef$.MODULE$.wrapIntArray(new int[]{0}), ClassTag$.MODULE$.Int()))), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Int()));
                return new Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>>(new Tuple2<TrieIterator<T>, Integer>(this.newIterator(snd), BoxesRunTime.boxToInteger(szsnd)), this);
            }
            Tuple2<Object[], Object[]> tuple2 = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$immutable$TrieIterator$$arrayStack[0])).splitAt(this.scala$collection$immutable$TrieIterator$$arrayStack[0].length - (this.scala$collection$immutable$TrieIterator$$arrayStack[0].length - this.scala$collection$immutable$TrieIterator$$posStack[0] + 1) / 2);
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Iterable[] iterableArray = (Iterable[])tuple2._1();
            Iterable[] iterableArray2 = (Iterable[])tuple2._2();
            Iterable[] fst = iterableArray;
            Iterable[] snd = iterableArray2;
            this.scala$collection$immutable$TrieIterator$$arrayStack[0] = fst;
            return new Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>>(this.iteratorWithSize(snd), this);
        }
        if (this.scala$collection$immutable$TrieIterator$$posD == this.scala$collection$immutable$TrieIterator$$arrayD.length - 1) {
            Iterable<T> m = this.scala$collection$immutable$TrieIterator$$arrayD[this.scala$collection$immutable$TrieIterator$$posD];
            return this.arrayToIterators(this.isTrie(m) ? this.getElems(m) : this.collisionToArray(m));
        }
        Tuple2<Object[], Object[]> tuple2 = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$immutable$TrieIterator$$arrayD)).splitAt(this.scala$collection$immutable$TrieIterator$$arrayD.length - (this.scala$collection$immutable$TrieIterator$$arrayD.length - this.scala$collection$immutable$TrieIterator$$posD + 1) / 2);
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        Iterable[] iterableArray = (Iterable[])tuple2._1();
        Iterable[] iterableArray3 = (Iterable[])tuple2._2();
        Iterable[] fst = iterableArray;
        Iterable[] snd = iterableArray3;
        this.scala$collection$immutable$TrieIterator$$arrayD = fst;
        return new Tuple2<Tuple2<Iterator<T>, Object>, Iterator<T>>(this.iteratorWithSize(snd), this);
    }

    public TrieIterator(Iterable<T>[] elems) {
        this.elems = elems;
        this.scala$collection$immutable$TrieIterator$$depth = this.initDepth();
        this.scala$collection$immutable$TrieIterator$$arrayStack = this.initArrayStack();
        this.scala$collection$immutable$TrieIterator$$posStack = this.initPosStack();
        this.scala$collection$immutable$TrieIterator$$arrayD = this.initArrayD();
        this.scala$collection$immutable$TrieIterator$$posD = this.initPosD();
        this.scala$collection$immutable$TrieIterator$$subIter = this.initSubIter();
    }

    public final class DupIterator
    extends TrieIterator<T> {
        private final int initDepth;
        private final Iterable<T>[][] initArrayStack;
        private final int[] initPosStack;
        private final Iterable<T>[] initArrayD;
        private final int initPosD;
        private final Iterator<T> initSubIter;

        @Override
        public int initDepth() {
            return this.initDepth;
        }

        @Override
        public Iterable<T>[][] initArrayStack() {
            return this.initArrayStack;
        }

        @Override
        public int[] initPosStack() {
            return this.initPosStack;
        }

        @Override
        public Iterable<T>[] initArrayD() {
            return this.initArrayD;
        }

        @Override
        public int initPosD() {
            return this.initPosD;
        }

        @Override
        public Iterator<T> initSubIter() {
            return this.initSubIter;
        }

        @Override
        public final T getElem(Object x) {
            return TrieIterator.this.getElem(x);
        }

        public DupIterator(Iterable<T>[] xs) {
            int initPosD;
            int initDepth;
            if (TrieIterator.this == null) {
                throw null;
            }
            this.initDepth = initDepth = TrieIterator.this.scala$collection$immutable$TrieIterator$$depth;
            Iterable<T>[][] initArrayStack = TrieIterator.this.scala$collection$immutable$TrieIterator$$arrayStack;
            this.initArrayStack = initArrayStack;
            int[] initPosStack = TrieIterator.this.scala$collection$immutable$TrieIterator$$posStack;
            this.initPosStack = initPosStack;
            Iterable<T>[] initArrayD = TrieIterator.this.scala$collection$immutable$TrieIterator$$arrayD;
            this.initArrayD = initArrayD;
            this.initPosD = initPosD = TrieIterator.this.scala$collection$immutable$TrieIterator$$posD;
            Iterator initSubIter = TrieIterator.this.scala$collection$immutable$TrieIterator$$subIter;
            this.initSubIter = initSubIter;
            super(xs);
        }
    }
}

