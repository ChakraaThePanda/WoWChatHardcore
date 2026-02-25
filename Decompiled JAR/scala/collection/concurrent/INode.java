/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.collection.concurrent.BasicNode;
import scala.collection.concurrent.CNode;
import scala.collection.concurrent.CNode$;
import scala.collection.concurrent.FailedNode;
import scala.collection.concurrent.Gen;
import scala.collection.concurrent.INode$;
import scala.collection.concurrent.INodeBase;
import scala.collection.concurrent.LNode;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.SNode;
import scala.collection.concurrent.TNode;
import scala.collection.concurrent.TrieMap;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005}g!\u0002\u0010 \u0005\u0005*\u0003\u0002C\u001e\u0001\u0005\u0003\u0005\u000b\u0011\u0002\u001f\t\u0011}\u0002!\u0011!Q\u0001\n\u0001CQa\u0011\u0001\u0005\u0002\u0011CQa\u0011\u0001\u0005\u0002!CQA\u0013\u0001\u0005\u0002-CQ!\u0015\u0001\u0005\u0002ICQA\u0017\u0001\u0005\u0002mCQ!\u0019\u0001\u0005\u0002\tDQ\u0001\u001a\u0001\u0005\n\u0015DQ\u0001\u001d\u0001\u0005\u0002EDQ!\u001e\u0001\u0005\nYDQ\u0001 \u0001\u0005\nuDq!!\u0001\u0001\t\u0003\t\u0019\u0001C\u0004\u0002\f\u0001!\t!!\u0004\t\u000f\u0005E\u0002\u0001\"\u0001\u00024!9\u0011Q\u000b\u0001\u0005\u0002\u0005]\u0003bBA4\u0001\u0011\u0005\u0011\u0011\u000e\u0005\b\u0003s\u0002A\u0011BA>\u0011\u001d\t)\t\u0001C\u0001\u0003\u000fCq!a#\u0001\t\u0003\ti\tC\u0004\u0002\u0012\u0002!\t!a%\b\u0011\u00055v\u0004#\u0001 \u0003_3qAH\u0010\t\u0002}\t\t\f\u0003\u0004D/\u0011\u0005\u00111\u0017\u0005\n\u0003k;\"\u0019!C\u0001\u0003oC\u0001\"!3\u0018A\u0003%\u0011\u0011\u0018\u0005\n\u0003\u0017<\"\u0019!C\u0001\u0003oC\u0001\"!4\u0018A\u0003%\u0011\u0011\u0018\u0005\b\u0003\u001f<B\u0011AAi\u0005\u0015Iej\u001c3f\u0015\t\u0001\u0013%\u0001\u0006d_:\u001cWO\u001d:f]RT!AI\u0012\u0002\u0015\r|G\u000e\\3di&|gNC\u0001%\u0003\u0015\u00198-\u00197b+\r1S&O\n\u0003\u0001\u001d\u0002B\u0001K\u0015,q5\tq$\u0003\u0002+?\tI\u0011JT8eK\n\u000b7/\u001a\t\u0003Y5b\u0001\u0001B\u0003/\u0001\t\u0007\u0001GA\u0001L\u0007\u0001\t\"!M\u001b\u0011\u0005I\u001aT\"A\u0012\n\u0005Q\u001a#a\u0002(pi\"Lgn\u001a\t\u0003eYJ!aN\u0012\u0003\u0007\u0005s\u0017\u0010\u0005\u0002-s\u0011)!\b\u0001b\u0001a\t\ta+\u0001\u0002c]B!\u0001&P\u00169\u0013\tqtD\u0001\u0005NC&tgj\u001c3f\u0003\u00059\u0007C\u0001\u0015B\u0013\t\u0011uDA\u0002HK:\fa\u0001P5oSRtDcA#G\u000fB!\u0001\u0006A\u00169\u0011\u0015Y4\u00011\u0001=\u0011\u0015y4\u00011\u0001A)\t)\u0015\nC\u0003@\t\u0001\u0007\u0001)A\u0003X%&#V\t\u0006\u0002M\u001fB\u0011!'T\u0005\u0003\u001d\u000e\u0012A!\u00168ji\")\u0001+\u0002a\u0001y\u0005!aN^1m\u0003\r\u0019\u0015i\u0015\u000b\u0004'ZC\u0006C\u0001\u001aU\u0013\t)6EA\u0004C_>dW-\u00198\t\u000b]3\u0001\u0019\u0001\u001f\u0002\u0007=dG\rC\u0003Z\r\u0001\u0007A(A\u0001o\u0003!97-Y:SK\u0006$GC\u0001\u001f]\u0011\u0015iv\u00011\u0001_\u0003\t\u0019G\u000f\u0005\u0003)?.B\u0014B\u00011 \u0005\u001d!&/[3NCB\f\u0011bR\"B'~\u0013V)\u0011#\u0015\u0005q\u001a\u0007\"B/\t\u0001\u0004q\u0016!D$D\u0003N{6i\\7qY\u0016$X\rF\u0002=M\"DQaZ\u0005A\u0002q\n\u0011!\u001c\u0005\u0006;&\u0001\rA\u0018\u0015\u0003\u0013)\u0004\"a\u001b8\u000e\u00031T!!\\\u0012\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002pY\n9A/Y5me\u0016\u001c\u0017\u0001B$D\u0003N#Ba\u0015:ti\")qK\u0003a\u0001y!)\u0011L\u0003a\u0001y!)QL\u0003a\u0001=\u0006)Q-];bYR!1k^=|\u0011\u0015A8\u00021\u0001,\u0003\tY\u0017\u0007C\u0003{\u0017\u0001\u00071&\u0001\u0002le!)Ql\u0003a\u0001=\u0006)\u0011N\\8eKR\u0011QI \u0005\u0006\u007f2\u0001\r\u0001P\u0001\u0003G:\f\u0011bY8qsR{w)\u001a8\u0015\u000b\u0015\u000b)!!\u0003\t\r\u0005\u001dQ\u00021\u0001A\u0003\u0011qw-\u001a8\t\u000buk\u0001\u0019\u00010\u0002\u0015I,7mX5og\u0016\u0014H\u000fF\bT\u0003\u001f\t\u0019\"a\u0006\u0002\"\u0005\u0015\u0012\u0011FA\u0017\u0011\u0019\t\tB\u0004a\u0001W\u0005\t1\u000e\u0003\u0004\u0002\u00169\u0001\r\u0001O\u0001\u0002m\"9\u0011\u0011\u0004\bA\u0002\u0005m\u0011A\u00015d!\r\u0011\u0014QD\u0005\u0004\u0003?\u0019#aA%oi\"9\u00111\u0005\bA\u0002\u0005m\u0011a\u00017fm\"1\u0011q\u0005\bA\u0002\u0015\u000ba\u0001]1sK:$\bBBA\u0016\u001d\u0001\u0007\u0001)\u0001\u0005ti\u0006\u0014HoZ3o\u0011\u0015if\u00021\u0001_Q\tq!.\u0001\u0007sK\u000e|\u0016N\\:feRLg\r\u0006\n\u00026\u0005m\u0012QHA \u0003\u0003\nY%!\u0014\u0002P\u0005E\u0003\u0003\u0002\u001a\u00028aJ1!!\u000f$\u0005\u0019y\u0005\u000f^5p]\"1\u0011\u0011C\bA\u0002-Ba!!\u0006\u0010\u0001\u0004A\u0004bBA\r\u001f\u0001\u0007\u00111\u0004\u0005\b\u0003\u0007z\u0001\u0019AA#\u0003\u0011\u0019wN\u001c3\u0011\u0007I\n9%C\u0002\u0002J\r\u0012a!\u00118z%\u00164\u0007bBA\u0012\u001f\u0001\u0007\u00111\u0004\u0005\u0007\u0003Oy\u0001\u0019A#\t\r\u0005-r\u00021\u0001A\u0011\u0015iv\u00021\u0001_Q\ty!.\u0001\u0006sK\u000e|Fn\\8lkB$b\"!\u0012\u0002Z\u0005m\u0013QLA0\u0003C\n\u0019\u0007\u0003\u0004\u0002\u0012A\u0001\ra\u000b\u0005\b\u00033\u0001\u0002\u0019AA\u000e\u0011\u001d\t\u0019\u0003\u0005a\u0001\u00037Aa!a\n\u0011\u0001\u0004)\u0005BBA\u0016!\u0001\u0007\u0001\tC\u0003^!\u0001\u0007a\f\u000b\u0002\u0011U\u0006Q!/Z2`e\u0016lwN^3\u0015!\u0005U\u00121NA7\u0003_\n\t(a\u001d\u0002v\u0005]\u0004BBA\t#\u0001\u00071\u0006\u0003\u0004\u0002\u0016E\u0001\r\u0001\u000f\u0005\b\u00033\t\u0002\u0019AA\u000e\u0011\u001d\t\u0019#\u0005a\u0001\u00037Aa!a\n\u0012\u0001\u0004)\u0005BBA\u0016#\u0001\u0007\u0001\tC\u0003^#\u0001\u0007a,A\u0003dY\u0016\fg\u000eF\u0004M\u0003{\n\t)a!\t\r\u0005}$\u00031\u0001F\u0003\tqG\rC\u0003^%\u0001\u0007a\fC\u0004\u0002$I\u0001\r!a\u0007\u0002\u0017%\u001ch*\u001e7m\u0013:|G-\u001a\u000b\u0004'\u0006%\u0005\"B/\u0014\u0001\u0004q\u0016AC2bG\",GmU5{KR!\u00111DAH\u0011\u0015iF\u00031\u0001_\u0003\u0019\u0019HO]5oOR!\u0011QSAV!\u0011\t9*!*\u000f\t\u0005e\u0015\u0011\u0015\t\u0004\u00037\u001bSBAAO\u0015\r\tyjL\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005\r6%\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003O\u000bIK\u0001\u0004TiJLgn\u001a\u0006\u0004\u0003G\u001b\u0003bBA\u0012+\u0001\u0007\u00111D\u0001\u0006\u0013:{G-\u001a\t\u0003Q]\u00192aFA#)\t\ty+A\u0006L\u000bf{\u0006KU#T\u000b:#VCAA]!\u0011\tY,!2\u000e\u0005\u0005u&\u0002BA`\u0003\u0003\fA\u0001\\1oO*\u0011\u00111Y\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002H\u0006u&AB(cU\u0016\u001cG/\u0001\u0007L\u000bf{\u0006KU#T\u000b:#\u0006%\u0001\u0006L\u000bf{\u0016IQ*F\u001dR\u000b1bS#Z?\u0006\u00135+\u0012(UA\u0005Ya.Z<S_>$hj\u001c3f+\u0019\t\u0019.!7\u0002^V\u0011\u0011Q\u001b\t\u0007Q\u0001\t9.a7\u0011\u00071\nI\u000eB\u0003/;\t\u0007\u0001\u0007E\u0002-\u0003;$QAO\u000fC\u0002A\u0002")
public final class INode<K, V>
extends INodeBase<K, V> {
    public static <K, V> INode<K, V> newRootNode() {
        return INode$.MODULE$.newRootNode();
    }

    public static Object KEY_ABSENT() {
        return INode$.MODULE$.KEY_ABSENT();
    }

    public static Object KEY_PRESENT() {
        return INode$.MODULE$.KEY_PRESENT();
    }

    public void WRITE(MainNode<K, V> nval) {
        INodeBase.updater.set(this, nval);
    }

    public boolean CAS(MainNode<K, V> old, MainNode<K, V> n) {
        return INodeBase.updater.compareAndSet(this, old, n);
    }

    public MainNode<K, V> gcasRead(TrieMap<K, V> ct) {
        return this.GCAS_READ(ct);
    }

    public MainNode<K, V> GCAS_READ(TrieMap<K, V> ct) {
        MainNode m = this.mainnode;
        if (m.prev == null) {
            return m;
        }
        return this.GCAS_Complete(m, ct);
    }

    private MainNode<K, V> GCAS_Complete(MainNode<K, V> m, TrieMap<K, V> ct) {
        MainNode mainNode;
        block6: {
            while (true) {
                if (m == null) {
                    return null;
                }
                MainNode prev = m.prev;
                INode<K, V> ctr = ct.readRoot(true);
                if (prev == null) {
                    mainNode = m;
                    break block6;
                }
                if (prev instanceof FailedNode) {
                    FailedNode failedNode = (FailedNode)prev;
                    if (!this.CAS(m, failedNode.prev)) {
                        m = this.mainnode;
                        continue;
                    }
                    mainNode = failedNode.prev;
                    break block6;
                }
                if (ctr.gen == this.gen && ct.nonReadOnly()) {
                    if (m.CAS_PREV(prev, null)) break;
                    continue;
                }
                m.CAS_PREV(prev, new FailedNode(prev));
                m = this.mainnode;
            }
            mainNode = m;
        }
        return mainNode;
    }

    public boolean GCAS(MainNode<K, V> old, MainNode<K, V> n, TrieMap<K, V> ct) {
        n.WRITE_PREV(old);
        if (this.CAS(old, n)) {
            this.GCAS_Complete(n, ct);
            return n.prev == null;
        }
        return false;
    }

    private boolean equal(K k1, K k2, TrieMap<K, V> ct) {
        return ct.equality().equiv(k1, k2);
    }

    /*
     * WARNING - void declaration
     */
    private INode<K, V> inode(MainNode<K, V> cn) {
        void var2_2;
        INode<K, V> nin = new INode<K, V>(this.gen);
        nin.WRITE(cn);
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    public INode<K, V> copyToGen(Gen ngen, TrieMap<K, V> ct) {
        void var3_3;
        INode<K, V> nin = new INode<K, V>(ngen);
        MainNode<K, V> main = this.GCAS_READ(ct);
        nin.WRITE(main);
        return var3_3;
    }

    public boolean rec_insert(K k, V v, int hc, int lev, INode<K, V> parent, Gen startgen, TrieMap<K, V> ct) {
        boolean bl;
        block14: {
            MainNode<K, V> m;
            while ((m = this_.GCAS_READ(ct)) instanceof CNode) {
                boolean bl2;
                CNode<K, V> cNode = (CNode<K, V>)m;
                int idx = hc >>> lev & 0x1F;
                int flag = 1 << idx;
                int bmp = cNode.bitmap();
                int mask = flag - 1;
                int pos = Integer.bitCount(bmp & mask);
                if ((bmp & flag) != 0) {
                    boolean bl3;
                    BasicNode basicNode = cNode.array()[pos];
                    if (basicNode instanceof INode) {
                        INode iNode = (INode)basicNode;
                        if (startgen == iNode.gen) {
                            parent = this_;
                            lev += 5;
                            INode this_ = iNode;
                            continue;
                        }
                        if (this_.GCAS(cNode, cNode.renewed(startgen, ct), ct)) continue;
                        bl3 = false;
                    } else if (basicNode instanceof SNode) {
                        boolean bl4;
                        SNode sNode = (SNode)basicNode;
                        if (sNode.hc() == hc && this_.equal(sNode.k(), k, ct)) {
                            bl4 = this_.GCAS(cNode, cNode.updatedAt(pos, new SNode<K, V>(k, v, hc), this_.gen), ct);
                        } else {
                            CNode<K, V> nn = (cNode.gen() == this_.gen ? cNode : cNode.renewed(this_.gen, ct)).updatedAt(pos, this_.inode(CNode$.MODULE$.dual(sNode, sNode.hc(), new SNode<K, V>(k, v, hc), hc, lev + 5, this_.gen)), this_.gen);
                            bl4 = this_.GCAS(cNode, nn, ct);
                        }
                        bl3 = bl4;
                    } else {
                        throw new MatchError(basicNode);
                    }
                    bl2 = bl3;
                } else {
                    CNode<K, V> ncnode = (cNode.gen() == this_.gen ? cNode : cNode.renewed(this_.gen, ct)).insertedAt(pos, flag, new SNode<K, V>(k, v, hc), this_.gen);
                    bl2 = this_.GCAS(cNode, ncnode, ct);
                }
                bl = bl2;
                break block14;
            }
            if (m instanceof TNode) {
                this_.clean(parent, ct, lev - 5);
                bl = false;
            } else if (m instanceof LNode) {
                LNode lNode = (LNode)m;
                LNode<K, V> nn = lNode.inserted(k, v);
                bl = this_.GCAS(lNode, nn, ct);
            } else {
                throw new MatchError(m);
            }
        }
        return bl;
    }

    public Option<V> rec_insertif(K k, V v, int hc, Object cond, int lev, INode<K, V> parent, Gen startgen, TrieMap<K, V> ct) {
        None$ none$;
        block32: {
            MainNode<K, V> m;
            while ((m = this_.GCAS_READ(ct)) instanceof CNode) {
                None$ none$2;
                CNode<K, V> cNode = (CNode<K, V>)m;
                int idx = hc >>> lev & 0x1F;
                int flag = 1 << idx;
                int bmp = cNode.bitmap();
                int mask = flag - 1;
                int pos = Integer.bitCount(bmp & mask);
                if ((bmp & flag) != 0) {
                    None$ none$3;
                    BasicNode basicNode = cNode.array()[pos];
                    if (basicNode instanceof INode) {
                        INode iNode = (INode)basicNode;
                        if (startgen == iNode.gen) {
                            parent = this_;
                            lev += 5;
                            INode this_ = iNode;
                            continue;
                        }
                        if (this_.GCAS(cNode, cNode.renewed(startgen, ct), ct)) continue;
                        none$3 = null;
                    } else if (basicNode instanceof SNode) {
                        Option option;
                        SNode sNode = (SNode)basicNode;
                        if (cond == null) {
                            Option option2;
                            if (sNode.hc() == hc && this_.equal(sNode.k(), k, ct)) {
                                option2 = this_.GCAS(cNode, cNode.updatedAt(pos, new SNode<K, V>(k, v, hc), this_.gen), ct) ? new Some(sNode.v()) : null;
                            } else {
                                CNode<K, V> nn = (cNode.gen() == this_.gen ? cNode : cNode.renewed(this_.gen, ct)).updatedAt(pos, this_.inode(CNode$.MODULE$.dual(sNode, sNode.hc(), new SNode<K, V>(k, v, hc), hc, lev + 5, this_.gen)), this_.gen);
                                option2 = this_.GCAS(cNode, nn, ct) ? None$.MODULE$ : null;
                            }
                            option = option2;
                        } else if (BoxesRunTime.equals(INode$.MODULE$.KEY_ABSENT(), cond)) {
                            Option option3;
                            if (sNode.hc() == hc && this_.equal(sNode.k(), k, ct)) {
                                option3 = new Some(sNode.v());
                            } else {
                                CNode<K, V> nn = (cNode.gen() == this_.gen ? cNode : cNode.renewed(this_.gen, ct)).updatedAt(pos, this_.inode(CNode$.MODULE$.dual(sNode, sNode.hc(), new SNode<K, V>(k, v, hc), hc, lev + 5, this_.gen)), this_.gen);
                                option3 = this_.GCAS(cNode, nn, ct) ? None$.MODULE$ : null;
                            }
                            option = option3;
                        } else {
                            option = BoxesRunTime.equals(INode$.MODULE$.KEY_PRESENT(), cond) ? (sNode.hc() == hc && this_.equal(sNode.k(), k, ct) ? (this_.GCAS(cNode, cNode.updatedAt(pos, new SNode<K, V>(k, v, hc), this_.gen), ct) ? new Some(sNode.v()) : null) : None$.MODULE$) : (sNode.hc() == hc && this_.equal(sNode.k(), k, ct) && BoxesRunTime.equals(sNode.v(), cond) ? (this_.GCAS(cNode, cNode.updatedAt(pos, new SNode<K, V>(k, v, hc), this_.gen), ct) ? new Some(sNode.v()) : null) : None$.MODULE$);
                        }
                        none$3 = option;
                    } else {
                        throw new MatchError(basicNode);
                    }
                    none$2 = none$3;
                } else {
                    None$ none$4;
                    boolean bl = cond == null ? true : BoxesRunTime.equals(INode$.MODULE$.KEY_ABSENT(), cond);
                    if (bl) {
                        CNode<K, V> ncnode = (cNode.gen() == this_.gen ? cNode : cNode.renewed(this_.gen, ct)).insertedAt(pos, flag, new SNode<K, V>(k, v, hc), this_.gen);
                        none$4 = this_.GCAS(cNode, ncnode, ct) ? None$.MODULE$ : null;
                    } else {
                        none$4 = BoxesRunTime.equals(INode$.MODULE$.KEY_PRESENT(), cond) ? None$.MODULE$ : None$.MODULE$;
                    }
                    none$2 = none$4;
                }
                none$ = none$2;
                break block32;
            }
            if (m instanceof TNode) {
                this_.clean(parent, ct, lev - 5);
                none$ = null;
            } else if (m instanceof LNode) {
                None$ none$5;
                LNode lNode = (LNode)m;
                if (cond == null) {
                    None$ optv = lNode.get(k);
                    none$5 = this_.insertln$1(lNode, k, v, ct) ? optv : null;
                } else if (BoxesRunTime.equals(INode$.MODULE$.KEY_ABSENT(), cond)) {
                    None$ none$6 = lNode.get(k);
                    None$ none$7 = None$.MODULE$.equals(none$6) ? (this_.insertln$1(lNode, k, v, ct) ? None$.MODULE$ : null) : none$6;
                    none$5 = none$7;
                } else if (BoxesRunTime.equals(INode$.MODULE$.KEY_PRESENT(), cond)) {
                    Option option;
                    Option option4 = lNode.get(k);
                    if (option4 instanceof Some) {
                        Object v0 = ((Some)option4).value();
                        option = this_.insertln$1(lNode, k, v, ct) ? new Some(v0) : null;
                    } else if (None$.MODULE$.equals(option4)) {
                        option = None$.MODULE$;
                    } else {
                        throw new MatchError(option4);
                    }
                    none$5 = option;
                } else {
                    Option option = lNode.get(k);
                    Option option5 = option instanceof Some && BoxesRunTime.equals(((Some)option).value(), cond) ? (this_.insertln$1(lNode, k, v, ct) ? new Some<Object>(cond) : null) : None$.MODULE$;
                    none$5 = option5;
                }
                none$ = none$5;
            } else {
                throw new MatchError(m);
            }
        }
        return none$;
    }

    /*
     * WARNING - void declaration
     */
    public Object rec_lookup(K k, int hc, int lev, INode<K, V> parent, Gen startgen, TrieMap<K, V> ct) {
        Object object;
        block13: {
            MainNode<K, V> m;
            while ((m = this_.GCAS_READ(ct)) instanceof CNode) {
                Object object2;
                CNode cNode = (CNode)m;
                int idx = hc >>> lev & 0x1F;
                int flag = 1 << idx;
                int bmp = cNode.bitmap();
                if ((bmp & flag) == 0) {
                    object2 = null;
                } else {
                    Object object3;
                    int pos = bmp == -1 ? idx : Integer.bitCount(bmp & flag - 1);
                    BasicNode sub = cNode.array()[pos];
                    if (sub instanceof INode) {
                        INode iNode = (INode)sub;
                        if (ct.isReadOnly() || startgen == iNode.gen) {
                            parent = this_;
                            lev += 5;
                            INode this_ = iNode;
                            continue;
                        }
                        if (this_.GCAS(cNode, cNode.renewed(startgen, ct), ct)) continue;
                        object3 = INodeBase.RESTART;
                    } else if (sub instanceof SNode) {
                        SNode sNode = (SNode)sub;
                        object3 = sNode.hc() == hc && this_.equal(sNode.k(), k, ct) ? (Object)sNode.v() : null;
                    } else {
                        throw new MatchError(sub);
                    }
                    object2 = object3;
                }
                object = object2;
                break block13;
            }
            if (m instanceof TNode) {
                TNode tNode = (TNode)m;
                object = this_.cleanReadOnly$1(tNode, ct, parent, lev, hc, k);
            } else if (m instanceof LNode) {
                void orNull_ev;
                Option option = ((LNode)m).get(k);
                Predef$.less.colon.less less2 = Predef$.MODULE$.$conforms();
                if (option == null) {
                    throw null;
                }
                Option orNull_this = option;
                object = orNull_this.isEmpty() ? Option.$anonfun$orNull$1((Predef$.less.colon.less)orNull_ev) : orNull_this.get();
            } else {
                throw new MatchError(m);
            }
        }
        return object;
    }

    public Option<V> rec_remove(K k, V v, int hc, int lev, INode<K, V> parent, Gen startgen, TrieMap<K, V> ct) {
        None$ none$;
        MainNode<K, V> m = this.GCAS_READ(ct);
        if (m instanceof CNode) {
            None$ none$2;
            int flag;
            CNode cNode = (CNode)m;
            int idx = hc >>> lev & 0x1F;
            int bmp = cNode.bitmap();
            if ((bmp & (flag = 1 << idx)) == 0) {
                none$2 = None$.MODULE$;
            } else {
                Option option;
                int pos = Integer.bitCount(bmp & flag - 1);
                BasicNode sub = cNode.array()[pos];
                if (sub instanceof INode) {
                    INode iNode = (INode)sub;
                    option = startgen == iNode.gen ? iNode.rec_remove(k, v, hc, lev + 5, this, startgen, ct) : (this.GCAS(cNode, cNode.renewed(startgen, ct), ct) ? this.rec_remove(k, v, hc, lev, parent, startgen, ct) : null);
                } else if (sub instanceof SNode) {
                    MainNode ncn;
                    SNode sNode = (SNode)sub;
                    option = sNode.hc() == hc && this.equal(sNode.k(), k, ct) && (v == null || BoxesRunTime.equals(sNode.v(), v)) ? (this.GCAS(cNode, ncn = cNode.removedAt(pos, flag, this.gen).toContracted(lev), ct) ? new Some(sNode.v()) : null) : None$.MODULE$;
                } else {
                    throw new MatchError(sub);
                }
                None$ none$3 = option;
                None$ none$4 = None$.MODULE$;
                if (!(none$3 == null ? none$4 != null : !none$3.equals(none$4)) || option == null) {
                    none$2 = option;
                } else {
                    MainNode<K, V> n;
                    if (parent != null && (n = this.GCAS_READ(ct)) instanceof TNode) {
                        this.cleanParent$1(n, parent, ct, hc, lev, startgen);
                    }
                    none$2 = option;
                }
            }
            none$ = none$2;
        } else if (m instanceof TNode) {
            this.clean(parent, ct, lev - 5);
            none$ = null;
        } else if (m instanceof LNode) {
            Option option;
            LNode lNode = (LNode)m;
            if (v == null) {
                Option optv = lNode.get(k);
                MainNode<K, V> nn = lNode.removed(k, ct);
                option = this.GCAS(lNode, nn, ct) ? optv : null;
            } else {
                MainNode<K, V> nn;
                Some some;
                Option option2 = lNode.get(k);
                Option option3 = option2 instanceof Some && BoxesRunTime.equals((some = (Some)option2).value(), v) ? (this.GCAS(lNode, nn = lNode.removed(k, ct), ct) ? some : null) : None$.MODULE$;
                option = option3;
            }
            none$ = option;
        } else {
            throw new MatchError(m);
        }
        return none$;
    }

    private void clean(INode<K, V> nd, TrieMap<K, V> ct, int lev) {
        MainNode<K, V> m = nd.GCAS_READ(ct);
        if (m instanceof CNode) {
            CNode cNode = (CNode)m;
            nd.GCAS(cNode, cNode.toCompressed(ct, lev, this.gen), ct);
            return;
        }
    }

    public boolean isNullInode(TrieMap<K, V> ct) {
        return this.GCAS_READ(ct) == null;
    }

    public int cachedSize(TrieMap<K, V> ct) {
        return this.GCAS_READ(ct).cachedSize(ct);
    }

    @Override
    public String string(int lev) {
        String string;
        String string2 = "%sINode -> %s";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        StringOps stringOps = new StringOps(string2);
        Object[] objectArray = new Object[2];
        String string3 = "  ";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        objectArray[0] = new StringOps(string3).$times(lev);
        MainNode mainNode = this.mainnode;
        if (mainNode == null) {
            string = "<null>";
        } else if (mainNode instanceof TNode) {
            TNode tNode = (TNode)mainNode;
            String string4 = "TNode(%s, %s, %d, !)";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            string = new StringOps(string4).format(Predef$.MODULE$.genericWrapArray(new Object[]{tNode.k(), tNode.v(), BoxesRunTime.boxToInteger(tNode.hc())}));
        } else if (mainNode instanceof CNode) {
            string = ((CNode)mainNode).string(lev);
        } else if (mainNode instanceof LNode) {
            string = ((LNode)mainNode).string(lev);
        } else {
            String string5 = "<elem: %s>";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            string = new StringOps(string5).format(Predef$.MODULE$.genericWrapArray(new Object[]{mainNode}));
        }
        objectArray[1] = string;
        return stringOps.format(Predef$.MODULE$.genericWrapArray(objectArray));
    }

    private final boolean insertln$1(LNode x4$1, Object k$1, Object v$1, TrieMap ct$1) {
        LNode<Object, Object> nn = x4$1.inserted(k$1, v$1);
        return this.GCAS(x4$1, nn, ct$1);
    }

    private final Object cleanReadOnly$1(TNode tn, TrieMap ct$2, INode parent$1, int lev$1, int hc$1, Object k$2) {
        if (ct$2.nonReadOnly()) {
            this.clean(parent$1, ct$2, lev$1 - 5);
            return INodeBase.RESTART;
        }
        if (tn.hc() == hc$1 && BoxesRunTime.equals(tn.k(), k$2)) {
            return tn.v();
        }
        return null;
    }

    private final void cleanParent$1(Object nonlive, INode parent$2, TrieMap ct$3, int hc$2, int lev$2, Gen startgen$1) {
        MainNode<K, V> pm;
        while ((pm = parent$2.GCAS_READ(ct$3)) instanceof CNode) {
            int flag;
            CNode cNode = (CNode)pm;
            int idx = hc$2 >>> lev$2 - 5 & 0x1F;
            int bmp = cNode.bitmap();
            if ((bmp & (flag = 1 << idx)) != 0) {
                int pos = Integer.bitCount(bmp & flag - 1);
                if (cNode.array()[pos] != this) break;
                if (nonlive instanceof TNode) {
                    TNode tNode = (TNode)nonlive;
                    MainNode ncn = cNode.updatedAt(pos, tNode.copyUntombed(), this.gen).toContracted(lev$2 - 5);
                    if (parent$2.GCAS(cNode, ncn, ct$3)) break;
                    Gen gen = ct$3.readRoot((boolean)ct$3.readRoot$default$1()).gen;
                    if (gen == null) {
                        if (startgen$1 == null) continue;
                        return;
                    }
                    if (!gen.equals(startgen$1)) break;
                    continue;
                }
                throw new MatchError(nonlive);
            }
            return;
        }
    }

    public INode(MainNode<K, V> bn, Gen g) {
        super(g);
        this.WRITE(bn);
    }

    public INode(Gen g) {
        this(null, g);
    }
}

