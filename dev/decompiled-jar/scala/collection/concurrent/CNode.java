/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import java.util.concurrent.ThreadLocalRandom;
import scala.Array$;
import scala.Function1;
import scala.MatchError;
import scala.Option$;
import scala.Predef$;
import scala.Predef$DummyImplicit$;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.concurrent.BasicNode;
import scala.collection.concurrent.CNode$;
import scala.collection.concurrent.CNodeBase;
import scala.collection.concurrent.Gen;
import scala.collection.concurrent.INode;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.SNode;
import scala.collection.concurrent.TNode;
import scala.collection.concurrent.TrieMap;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.math.Ordering$String$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005Md!\u0002\r\u001a\u0005my\u0002\u0002C\u001b\u0001\u0005\u000b\u0007I\u0011\u0001\u001c\t\u0011i\u0002!\u0011!Q\u0001\n]B\u0001b\u000f\u0001\u0003\u0006\u0004%\t\u0001\u0010\u0005\t\u0007\u0002\u0011\t\u0011)A\u0005{!AA\t\u0001BC\u0002\u0013\u0005Q\t\u0003\u0005J\u0001\t\u0005\t\u0015!\u0003G\u0011\u0015Q\u0005\u0001\"\u0001L\u0011\u0015\u0001\u0006\u0001\"\u0001R\u0011\u00159\u0006\u0001\"\u0003Y\u0011\u0015i\u0006\u0001\"\u0001_\u0011\u0015!\u0007\u0001\"\u0001f\u0011\u0015Q\u0007\u0001\"\u0001l\u0011\u0015\u0001\b\u0001\"\u0001r\u0011\u0015)\b\u0001\"\u0003w\u0011\u0015q\b\u0001\"\u0001\u0000\u0011\u001d\tY\u0001\u0001C\u0001\u0003\u001bA\u0001\"!\u0006\u0001\t\u0003I\u0012q\u0003\u0005\b\u0003c\u0001A\u0011BA\u001a\u0011\u001d\ti\u0004\u0001C!\u0003\u007f9\u0001\"!\u0011\u001a\u0011\u0003I\u00121\t\u0004\b1eA\t!GA#\u0011\u0019QU\u0003\"\u0001\u0002H!9\u0011\u0011J\u000b\u0005\u0002\u0005-#!B\"O_\u0012,'B\u0001\u000e\u001c\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u00039u\t!bY8mY\u0016\u001cG/[8o\u0015\u0005q\u0012!B:dC2\fWc\u0001\u0011(gM\u0011\u0001!\t\t\u0005E\r*#'D\u0001\u001a\u0013\t!\u0013DA\u0005D\u001d>$WMQ1tKB\u0011ae\n\u0007\u0001\t\u0015A\u0003A1\u0001+\u0005\u0005Y5\u0001A\t\u0003W=\u0002\"\u0001L\u0017\u000e\u0003uI!AL\u000f\u0003\u000f9{G\u000f[5oOB\u0011A\u0006M\u0005\u0003cu\u00111!\u00118z!\t13\u0007B\u00035\u0001\t\u0007!FA\u0001W\u0003\u0019\u0011\u0017\u000e^7baV\tq\u0007\u0005\u0002-q%\u0011\u0011(\b\u0002\u0004\u0013:$\u0018a\u00022ji6\f\u0007\u000fI\u0001\u0006CJ\u0014\u0018-_\u000b\u0002{A\u0019AF\u0010!\n\u0005}j\"!B!se\u0006L\bC\u0001\u0012B\u0013\t\u0011\u0015DA\u0005CCNL7MT8eK\u00061\u0011M\u001d:bs\u0002\n1aZ3o+\u00051\u0005C\u0001\u0012H\u0013\tA\u0015DA\u0002HK:\fAaZ3oA\u00051A(\u001b8jiz\"B\u0001T'O\u001fB!!\u0005A\u00133\u0011\u0015)t\u00011\u00018\u0011\u0015Yt\u00011\u0001>\u0011\u0015!u\u00011\u0001G\u0003)\u0019\u0017m\u00195fINK'0\u001a\u000b\u0003oICQa\u0015\u0005A\u0002Q\u000b!a\u0019;\u0011\u00051*\u0016B\u0001,\u001e\u0005\u0019\te.\u001f*fM\u0006Y1m\\7qkR,7+\u001b>f)\t9\u0014\fC\u0003T\u0013\u0001\u0007!\f\u0005\u0003#7\u0016\u0012\u0014B\u0001/\u001a\u0005\u001d!&/[3NCB\f\u0011\"\u001e9eCR,G-\u0011;\u0015\t1{\u0016m\u0019\u0005\u0006A*\u0001\raN\u0001\u0004a>\u001c\b\"\u00022\u000b\u0001\u0004\u0001\u0015A\u00018o\u0011\u0015!%\u00021\u0001G\u0003%\u0011X-\\8wK\u0012\fE\u000f\u0006\u0003MM\u001eL\u0007\"\u00021\f\u0001\u00049\u0004\"\u00025\f\u0001\u00049\u0014\u0001\u00024mC\u001eDQ\u0001R\u0006A\u0002\u0019\u000b!\"\u001b8tKJ$X\rZ!u)\u0015aE.\u001c8p\u0011\u0015\u0001G\u00021\u00018\u0011\u0015AG\u00021\u00018\u0011\u0015\u0011G\u00021\u0001A\u0011\u0015!E\u00021\u0001G\u0003\u001d\u0011XM\\3xK\u0012$2\u0001\u0014:u\u0011\u0015\u0019X\u00021\u0001G\u0003\u0011qw-\u001a8\t\u000bMk\u0001\u0019\u0001.\u0002\u0013I,7/\u001e:sK\u000e$Hc\u0001!xy\")\u0001P\u0004a\u0001s\u0006)\u0011N\\8eKB!!E_\u00133\u0013\tY\u0018DA\u0003J\u001d>$W\rC\u0003~\u001d\u0001\u0007A+A\u0005j]>$W-\\1j]\u0006aAo\\\"p]R\u0014\u0018m\u0019;fIR!\u0011\u0011AA\u0004!\u0015\u0011\u00131A\u00133\u0013\r\t)!\u0007\u0002\t\u001b\u0006LgNT8eK\"1\u0011\u0011B\bA\u0002]\n1\u0001\\3w\u00031!xnQ8naJ,7o]3e)!\t\t!a\u0004\u0002\u0012\u0005M\u0001\"B*\u0011\u0001\u0004Q\u0006BBA\u0005!\u0001\u0007q\u0007C\u0003E!\u0001\u0007a)\u0001\u0004tiJLgn\u001a\u000b\u0005\u00033\ty\u0003\u0005\u0003\u0002\u001c\u0005%b\u0002BA\u000f\u0003K\u00012!a\b\u001e\u001b\t\t\tCC\u0002\u0002$%\na\u0001\u0010:p_Rt\u0014bAA\u0014;\u00051\u0001K]3eK\u001aLA!a\u000b\u0002.\t11\u000b\u001e:j]\u001eT1!a\n\u001e\u0011\u0019\tI!\u0005a\u0001o\u0005\t2m\u001c7mK\u000e$Hj\\2bY\u0016cW-\\:\u0016\u0005\u0005U\u0002CBA\u001c\u0003s\tI\"D\u0001\u001c\u0013\r\tYd\u0007\u0002\u0004'\u0016\f\u0018\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0005e\u0011!B\"O_\u0012,\u0007C\u0001\u0012\u0016'\t)B\u000b\u0006\u0002\u0002D\u0005!A-^1m+\u0019\ti%a\u0015\u0002XQq\u0011qJA-\u0003G\n9'a\u001b\u0002p\u0005E\u0004c\u0002\u0012\u0002\u0004\u0005E\u0013Q\u000b\t\u0004M\u0005MC!\u0002\u0015\u0018\u0005\u0004Q\u0003c\u0001\u0014\u0002X\u0011)Ag\u0006b\u0001U!9\u00111L\fA\u0002\u0005u\u0013!\u0001=\u0011\u000f\t\ny&!\u0015\u0002V%\u0019\u0011\u0011M\r\u0003\u000bMsu\u000eZ3\t\r\u0005\u0015t\u00031\u00018\u0003\rA\bn\u0019\u0005\b\u0003S:\u0002\u0019AA/\u0003\u0005I\bBBA7/\u0001\u0007q'A\u0002zQ\u000eDa!!\u0003\u0018\u0001\u00049\u0004\"\u0002#\u0018\u0001\u00041\u0005")
public final class CNode<K, V>
extends CNodeBase<K, V> {
    private final int bitmap;
    private final BasicNode[] array;
    private final Gen gen;

    public static <K, V> MainNode<K, V> dual(SNode<K, V> sNode, int n, SNode<K, V> sNode2, int n2, int n3, Gen gen) {
        return CNode$.MODULE$.dual(sNode, n, sNode2, n2, n3, gen);
    }

    public int bitmap() {
        return this.bitmap;
    }

    public BasicNode[] array() {
        return this.array;
    }

    public Gen gen() {
        return this.gen;
    }

    @Override
    public int cachedSize(Object ct) {
        int currsz = this.READ_SIZE();
        if (currsz != -1) {
            return currsz;
        }
        int sz = this.computeSize((TrieMap)ct);
        while (this.READ_SIZE() == -1) {
            this.CAS_SIZE(-1, sz);
        }
        return this.READ_SIZE();
    }

    /*
     * WARNING - void declaration
     */
    private int computeSize(TrieMap<K, V> ct) {
        void var3_3;
        int offset;
        int sz = 0;
        int n = offset = this.array().length > 0 ? ThreadLocalRandom.current().nextInt(0, this.array().length) : 0;
        for (int i = 0; i < this.array().length; ++i) {
            int pos = (i + offset) % this.array().length;
            BasicNode basicNode = this.array()[pos];
            if (basicNode instanceof SNode) {
                ++sz;
                continue;
            }
            if (basicNode instanceof INode) {
                INode iNode = (INode)basicNode;
                sz += iNode.cachedSize(ct);
                continue;
            }
            throw new MatchError(basicNode);
        }
        return (int)var3_3;
    }

    public CNode<K, V> updatedAt(int pos, BasicNode nn, Gen gen) {
        int len = this.array().length;
        BasicNode[] narr = new BasicNode[len];
        Array$.MODULE$.copy(this.array(), 0, narr, 0, len);
        narr[pos] = nn;
        return new CNode<K, V>(this.bitmap(), narr, gen);
    }

    public CNode<K, V> removedAt(int pos, int flag, Gen gen) {
        BasicNode[] arr = this.array();
        int len = arr.length;
        BasicNode[] narr = new BasicNode[len - 1];
        Array$.MODULE$.copy(arr, 0, narr, 0, pos);
        Array$.MODULE$.copy(arr, pos + 1, narr, pos, len - pos - 1);
        return new CNode<K, V>(this.bitmap() ^ flag, narr, gen);
    }

    public CNode<K, V> insertedAt(int pos, int flag, BasicNode nn, Gen gen) {
        int len = this.array().length;
        int bmp = this.bitmap();
        BasicNode[] narr = new BasicNode[len + 1];
        Array$.MODULE$.copy(this.array(), 0, narr, 0, pos);
        narr[pos] = nn;
        Array$.MODULE$.copy(this.array(), pos, narr, pos + 1, len - pos);
        return new CNode<K, V>(bmp | flag, narr, gen);
    }

    public CNode<K, V> renewed(Gen ngen, TrieMap<K, V> ct) {
        BasicNode[] arr = this.array();
        int len = arr.length;
        BasicNode[] narr = new BasicNode[len];
        for (int i = 0; i < len; ++i) {
            BasicNode basicNode = arr[i];
            if (basicNode instanceof INode) {
                INode iNode = (INode)basicNode;
                narr[i] = iNode.copyToGen(ngen, ct);
                continue;
            }
            if (basicNode != null) {
                narr[i] = basicNode;
                continue;
            }
            throw new MatchError((Object)null);
        }
        return new CNode<K, V>(this.bitmap(), narr, ngen);
    }

    private BasicNode resurrect(INode<K, V> inode, Object inodemain) {
        BasicNode basicNode = inodemain instanceof TNode ? ((TNode)inodemain).copyUntombed() : inode;
        return basicNode;
    }

    public MainNode<K, V> toContracted(int lev) {
        if (this.array().length == 1 && lev > 0) {
            BasicNode basicNode = this.array()[0];
            MainNode mainNode = basicNode instanceof SNode ? ((SNode)basicNode).copyTombed() : this;
            return mainNode;
        }
        return this;
    }

    public MainNode<K, V> toCompressed(TrieMap<K, V> ct, int lev, Gen gen) {
        int bmp = this.bitmap();
        BasicNode[] arr = this.array();
        BasicNode[] tmparray = new BasicNode[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            BasicNode sub = arr[i];
            if (sub instanceof INode) {
                INode iNode = (INode)sub;
                MainNode<K, V> inodemain = iNode.gcasRead(ct);
                Predef$.MODULE$.assert(inodemain != null);
                tmparray[i] = this.resurrect(iNode, inodemain);
                continue;
            }
            if (sub instanceof SNode) {
                SNode sNode = (SNode)sub;
                tmparray[i] = sNode;
                continue;
            }
            throw new MatchError(sub);
        }
        return new CNode<K, V>(bmp, tmparray, gen).toContracted(lev);
    }

    @Override
    public String string(int lev) {
        String string = "CNode %x\n%s";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(this.bitmap()), new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.array())), (Function1<BasicNode, String> & java.io.Serializable & Serializable)x$2 -> x$2.string(lev + 1), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(String.class))))).mkString("\n")}));
    }

    private Seq<String> collectLocalElems() {
        return (Seq)TraversableLike.flatMap$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.array())), (Function1<BasicNode, Iterable> & java.io.Serializable & Serializable)x0$1 -> {
            Iterable<String> iterable;
            if (x0$1 instanceof SNode) {
                SNode sNode = (SNode)x0$1;
                iterable = Option$.MODULE$.option2Iterable(new Some<String>(sNode.kvPair()._2().toString()));
            } else if (x0$1 instanceof INode) {
                INode iNode = (INode)x0$1;
                String string = iNode.toString();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                iterable = Option$.MODULE$.option2Iterable(new Some<String>(new StringBuilder(2).append((String)new StringOps(string).drop(14)).append("(").append(iNode.gen).append(")").toString()));
            } else {
                throw new MatchError(x0$1);
            }
            return iterable;
        }, Array$.MODULE$.fallbackCanBuildFrom(Predef$DummyImplicit$.MODULE$.dummyImplicit()));
    }

    public String toString() {
        Seq<String> elems = this.collectLocalElems();
        String string = "CNode(sz: %d; %s)";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(elems.size()), ((TraversableOnce)elems.sorted(Ordering$String$.MODULE$)).mkString(", ")}));
    }

    public CNode(int bitmap, BasicNode[] array, Gen gen) {
        this.bitmap = bitmap;
        this.array = array;
        this.gen = gen;
    }
}

