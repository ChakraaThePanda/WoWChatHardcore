/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import scala.MatchError;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Tuple2;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.TNode;
import scala.collection.concurrent.TrieMap;
import scala.collection.immutable.ListMap;
import scala.collection.immutable.ListMap$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001)4Qa\u0003\u0007\u0003\u001dIA\u0001\u0002\u000b\u0001\u0003\u0006\u0004%)!\u000b\u0005\ta\u0001\u0011\t\u0011)A\u0007U!)\u0011\u0007\u0001C\u0001e!)\u0011\u0007\u0001C\u0001k!)\u0011\u0007\u0001C\u0001u!)1\t\u0001C\u0001\t\")q\t\u0001C\u0001\u0011\")q\n\u0001C\u0001!\")Q\u000b\u0001C\u0001-\")a\f\u0001C\u0001?\n)AJT8eK*\u0011QBD\u0001\u000bG>t7-\u001e:sK:$(BA\b\u0011\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002#\u0005)1oY1mCV\u00191C\u0007\u0014\u0014\u0005\u0001!\u0002\u0003B\u000b\u00171\u0015j\u0011\u0001D\u0005\u0003/1\u0011\u0001\"T1j]:{G-\u001a\t\u00033ia\u0001\u0001B\u0003\u001c\u0001\t\u0007QDA\u0001L\u0007\u0001\t\"A\b\u0012\u0011\u0005}\u0001S\"\u0001\t\n\u0005\u0005\u0002\"a\u0002(pi\"Lgn\u001a\t\u0003?\rJ!\u0001\n\t\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u001aM\u0011)q\u0005\u0001b\u0001;\t\ta+A\u0004mSN$X.\u00199\u0016\u0003)\u0002Ba\u000b\u0018\u0019K5\tAF\u0003\u0002.\u001d\u0005I\u0011.\\7vi\u0006\u0014G.Z\u0005\u0003_1\u0012q\u0001T5ti6\u000b\u0007/\u0001\u0005mSN$X.\u00199!\u0003\u0019a\u0014N\\5u}Q\u00111\u0007\u000e\t\u0005+\u0001AR\u0005C\u0003)\u0007\u0001\u0007!\u0006F\u00024maBQa\u000e\u0003A\u0002a\t\u0011a\u001b\u0005\u0006s\u0011\u0001\r!J\u0001\u0002mR)1gO\u001f@\u0003\")A(\u0002a\u00011\u0005\u00111.\r\u0005\u0006}\u0015\u0001\r!J\u0001\u0003mFBQ\u0001Q\u0003A\u0002a\t!a\u001b\u001a\t\u000b\t+\u0001\u0019A\u0013\u0002\u0005Y\u0014\u0014\u0001C5og\u0016\u0014H/\u001a3\u0015\u0007M*e\tC\u00038\r\u0001\u0007\u0001\u0004C\u0003:\r\u0001\u0007Q%A\u0004sK6|g/\u001a3\u0015\u0007QI%\nC\u00038\u000f\u0001\u0007\u0001\u0004C\u0003L\u000f\u0001\u0007A*\u0001\u0002diB!Q#\u0014\r&\u0013\tqEBA\u0004Ue&,W*\u00199\u0002\u0007\u001d,G\u000f\u0006\u0002R)B\u0019qDU\u0013\n\u0005M\u0003\"AB(qi&|g\u000eC\u00038\u0011\u0001\u0007\u0001$\u0001\u0006dC\u000eDW\rZ*ju\u0016$\"a\u0016.\u0011\u0005}A\u0016BA-\u0011\u0005\rIe\u000e\u001e\u0005\u0006\u0017&\u0001\ra\u0017\t\u0003?qK!!\u0018\t\u0003\r\u0005s\u0017PU3g\u0003\u0019\u0019HO]5oOR\u0011\u0001\r\u001b\t\u0003C\u001al\u0011A\u0019\u0006\u0003G\u0012\fA\u0001\\1oO*\tQ-\u0001\u0003kCZ\f\u0017BA4c\u0005\u0019\u0019FO]5oO\")\u0011N\u0003a\u0001/\u0006\u0019A.\u001a<")
public final class LNode<K, V>
extends MainNode<K, V> {
    private final ListMap<K, V> listmap;

    public final ListMap<K, V> listmap() {
        return this.listmap;
    }

    public LNode<K, V> inserted(K k, V v) {
        return new LNode<K, V>(this.listmap().$plus(new Tuple2<K, V>(k, v)));
    }

    public MainNode<K, V> removed(K k, TrieMap<K, V> ct) {
        Object updmap = this.listmap().$minus((Object)k);
        if (((ListMap)updmap).size() > 1) {
            return new LNode<K, V>(updmap);
        }
        Tuple2 tuple2 = ((ListMap)updmap).iterator().next();
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        Object a = tuple2._1();
        Object b = tuple2._2();
        return new TNode(a, b, ct.computeHash(a));
    }

    public Option<V> get(K k) {
        return this.listmap().get(k);
    }

    @Override
    public int cachedSize(Object ct) {
        return this.listmap().size();
    }

    @Override
    public String string(int lev) {
        String string = " ";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        String string2 = "LNode(%s)";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringBuilder(0).append(new StringOps(string).$times(lev)).append(new StringOps(string2).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.listmap().mkString(", ")}))).toString();
    }

    public LNode(ListMap<K, V> listmap) {
        this.listmap = listmap;
    }

    /*
     * WARNING - void declaration
     */
    public LNode(K k, V v) {
        void $minus$greater$extension_$this;
        Tuple2[] tuple2Array = new Tuple2[1];
        K k2 = Predef$.MODULE$.ArrowAssoc(k);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[0] = new Tuple2<void, V>($minus$greater$extension_$this, v);
        this((ListMap)ListMap$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array)));
    }

    /*
     * WARNING - void declaration
     */
    public LNode(K k1, V v1, K k2, V v2) {
        void $minus$greater$extension_$this;
        void $minus$greater$extension_$this2;
        Tuple2[] tuple2Array = new Tuple2[2];
        K k = Predef$.MODULE$.ArrowAssoc(k1);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[0] = new Tuple2<void, V>($minus$greater$extension_$this2, v1);
        K k3 = Predef$.MODULE$.ArrowAssoc(k2);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[1] = new Tuple2<void, V>($minus$greater$extension_$this, v2);
        this((ListMap)ListMap$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array)));
    }
}

