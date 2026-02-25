/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Tuple3;
import scala.collection.Iterator;
import scala.collection.concurrent.INode;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.RDCSS_Descriptor$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u00055f!\u0002\u0010 \u0001~)\u0003\u0002C\u0019\u0001\u0005+\u0007I\u0011A\u001a\t\u0011\u0019\u0003!\u0011#Q\u0001\nQB\u0001b\u0012\u0001\u0003\u0016\u0004%\t\u0001\u0013\u0005\t\u0019\u0002\u0011\t\u0012)A\u0005\u0013\"AQ\n\u0001BK\u0002\u0013\u00051\u0007\u0003\u0005O\u0001\tE\t\u0015!\u00035\u0011\u0015y\u0005\u0001\"\u0001Q\u0011\u001d)\u0006\u00011A\u0005\u0002YCqA\u0017\u0001A\u0002\u0013\u00051\f\u0003\u0004b\u0001\u0001\u0006Ka\u0016\u0005\bM\u0002\t\t\u0011\"\u0001h\u0011\u001d\u0019\b!%A\u0005\u0002QD\u0011\"!\u0002\u0001#\u0003%\t!a\u0002\t\u0013\u0005E\u0001!%A\u0005\u0002\u0005M\u0001\"CA\r\u0001\u0005\u0005I\u0011IA\u000e\u0011%\ti\u0003AA\u0001\n\u0003\ty\u0003C\u0005\u00028\u0001\t\t\u0011\"\u0001\u0002:!I\u0011Q\b\u0001\u0002\u0002\u0013\u0005\u0013q\b\u0005\n\u0003\u0013\u0002\u0011\u0011!C\u0001\u0003\u0017B\u0011\"a\u0014\u0001\u0003\u0003%\t%!\u0015\t\u0013\u0005M\u0003!!A\u0005B\u0005U\u0003\"CA,\u0001\u0005\u0005I\u0011IA-\u000f)\tifHA\u0001\u0012\u0003y\u0012q\f\u0004\n=}\t\t\u0011#\u0001 \u0003CBaa\u0014\r\u0005\u0002\u0005\r\u0004\"CA*1\u0005\u0005IQIA+\u0011%\t)\u0007GA\u0001\n\u0003\u000b9\u0007C\u0005\u0002\u0000a\t\t\u0011\"!\u0002\u0002\"I\u00111\u0015\r\u0002\u0002\u0013%\u0011Q\u0015\u0002\u0011%\u0012\u001b5kU0EKN\u001c'/\u001b9u_JT!\u0001I\u0011\u0002\u0015\r|gnY;se\u0016tGO\u0003\u0002#G\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003\u0011\nQa]2bY\u0006,2A\n\u001eE'\u0011\u0001qe\u000b\u0018\u0011\u0005!JS\"A\u0012\n\u0005)\u001a#AB!osJ+g\r\u0005\u0002)Y%\u0011Qf\t\u0002\b!J|G-^2u!\tAs&\u0003\u00021G\ta1+\u001a:jC2L'0\u00192mK\u0006\u0019q\u000e\u001c3\u0004\u0001U\tA\u0007\u0005\u00036ma\u001aU\"A\u0010\n\u0005]z\"!B%O_\u0012,\u0007CA\u001d;\u0019\u0001!Qa\u000f\u0001C\u0002q\u0012\u0011aS\t\u0003{\u0001\u0003\"\u0001\u000b \n\u0005}\u001a#a\u0002(pi\"Lgn\u001a\t\u0003Q\u0005K!AQ\u0012\u0003\u0007\u0005s\u0017\u0010\u0005\u0002:\t\u0012)Q\t\u0001b\u0001y\t\ta+\u0001\u0003pY\u0012\u0004\u0013\u0001D3ya\u0016\u001cG/\u001a3nC&tW#A%\u0011\tUR\u0005hQ\u0005\u0003\u0017~\u0011\u0001\"T1j]:{G-Z\u0001\u000eKb\u0004Xm\u0019;fI6\f\u0017N\u001c\u0011\u0002\u000594\u0018a\u00018wA\u00051A(\u001b8jiz\"B!\u0015*T)B!Q\u0007\u0001\u001dD\u0011\u0015\tt\u00011\u00015\u0011\u00159u\u00011\u0001J\u0011\u0015iu\u00011\u00015\u0003%\u0019w.\\7jiR,G-F\u0001X!\tA\u0003,\u0003\u0002ZG\t9!i\\8mK\u0006t\u0017!D2p[6LG\u000f^3e?\u0012*\u0017\u000f\u0006\u0002]?B\u0011\u0001&X\u0005\u0003=\u000e\u0012A!\u00168ji\"9\u0001-CA\u0001\u0002\u00049\u0016a\u0001=%c\u0005Q1m\\7nSR$X\r\u001a\u0011)\u0005)\u0019\u0007C\u0001\u0015e\u0013\t)7E\u0001\u0005w_2\fG/\u001b7f\u0003\u0011\u0019w\u000e]=\u0016\u0007!\\W\u000e\u0006\u0003j]B\u0014\b\u0003B\u001b\u0001U2\u0004\"!O6\u0005\u000bmZ!\u0019\u0001\u001f\u0011\u0005ejG!B#\f\u0005\u0004a\u0004bB\u0019\f!\u0003\u0005\ra\u001c\t\u0005kYRG\u000eC\u0004H\u0017A\u0005\t\u0019A9\u0011\tUR%\u000e\u001c\u0005\b\u001b.\u0001\n\u00111\u0001p\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*R!^A\u0001\u0003\u0007)\u0012A\u001e\u0016\u0003i]\\\u0013\u0001\u001f\t\u0003szl\u0011A\u001f\u0006\u0003wr\f\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005u\u001c\u0013AC1o]>$\u0018\r^5p]&\u0011qP\u001f\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,G!B\u001e\r\u0005\u0004aD!B#\r\u0005\u0004a\u0014AD2paf$C-\u001a4bk2$HEM\u000b\u0007\u0003\u0013\ti!a\u0004\u0016\u0005\u0005-!FA%x\t\u0015YTB1\u0001=\t\u0015)UB1\u0001=\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIM*R!^A\u000b\u0003/!Qa\u000f\bC\u0002q\"Q!\u0012\bC\u0002q\nQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAA\u000f!\u0011\ty\"!\u000b\u000e\u0005\u0005\u0005\"\u0002BA\u0012\u0003K\tA\u0001\\1oO*\u0011\u0011qE\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002,\u0005\u0005\"AB*ue&tw-\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0006\u0002\u00022A\u0019\u0001&a\r\n\u0007\u0005U2EA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000fF\u0002A\u0003wA\u0001\u0002Y\t\u0002\u0002\u0003\u0007\u0011\u0011G\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011\u0011\u0011\t\t\u0006\u0003\u0007\n)\u0005Q\u0007\u0002C%\u0019\u0011qI\u0011\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0004/\u00065\u0003b\u00021\u0014\u0003\u0003\u0005\r\u0001Q\u0001\tQ\u0006\u001c\bnQ8eKR\u0011\u0011\u0011G\u0001\ti>\u001cFO]5oOR\u0011\u0011QD\u0001\u0007KF,\u0018\r\\:\u0015\u0007]\u000bY\u0006C\u0004a-\u0005\u0005\t\u0019\u0001!\u0002!I#5iU*`\t\u0016\u001c8M]5qi>\u0014\bCA\u001b\u0019'\rArE\f\u000b\u0003\u0003?\nQ!\u00199qYf,b!!\u001b\u0002p\u0005MD\u0003CA6\u0003k\nI(! \u0011\rU\u0002\u0011QNA9!\rI\u0014q\u000e\u0003\u0006wm\u0011\r\u0001\u0010\t\u0004s\u0005MD!B#\u001c\u0005\u0004a\u0004BB\u0019\u001c\u0001\u0004\t9\b\u0005\u00046m\u00055\u0014\u0011\u000f\u0005\u0007\u000fn\u0001\r!a\u001f\u0011\rUR\u0015QNA9\u0011\u0019i5\u00041\u0001\u0002x\u00059QO\\1qa2LXCBAB\u0003+\u000bI\n\u0006\u0003\u0002\u0006\u0006u\u0005#\u0002\u0015\u0002\b\u0006-\u0015bAAEG\t1q\n\u001d;j_:\u0004\u0012\u0002KAG\u0003#\u000bY*!%\n\u0007\u0005=5E\u0001\u0004UkBdWm\r\t\u0007kY\n\u0019*a&\u0011\u0007e\n)\nB\u0003<9\t\u0007A\bE\u0002:\u00033#Q!\u0012\u000fC\u0002q\u0002b!\u000e&\u0002\u0014\u0006]\u0005\"CAP9\u0005\u0005\t\u0019AAQ\u0003\rAH\u0005\r\t\u0007k\u0001\t\u0019*a&\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0003O\u0003B!a\b\u0002*&!\u00111VA\u0011\u0005\u0019y%M[3di\u0002")
public class RDCSS_Descriptor<K, V>
implements Product,
Serializable {
    private final INode<K, V> old;
    private final MainNode<K, V> expectedmain;
    private final INode<K, V> nv;
    private volatile boolean committed;

    public static <K, V> Option<Tuple3<INode<K, V>, MainNode<K, V>, INode<K, V>>> unapply(RDCSS_Descriptor<K, V> rDCSS_Descriptor) {
        return RDCSS_Descriptor$.MODULE$.unapply(rDCSS_Descriptor);
    }

    public static <K, V> RDCSS_Descriptor<K, V> apply(INode<K, V> iNode, MainNode<K, V> mainNode, INode<K, V> iNode2) {
        return RDCSS_Descriptor$.MODULE$.apply(iNode, mainNode, iNode2);
    }

    public INode<K, V> old() {
        return this.old;
    }

    public MainNode<K, V> expectedmain() {
        return this.expectedmain;
    }

    public INode<K, V> nv() {
        return this.nv;
    }

    public boolean committed() {
        return this.committed;
    }

    public void committed_$eq(boolean x$1) {
        this.committed = x$1;
    }

    public <K, V> RDCSS_Descriptor<K, V> copy(INode<K, V> old, MainNode<K, V> expectedmain, INode<K, V> nv) {
        return new RDCSS_Descriptor<K, V>(old, expectedmain, nv);
    }

    public <K, V> INode<K, V> copy$default$1() {
        return this.old();
    }

    public <K, V> MainNode<K, V> copy$default$2() {
        return this.expectedmain();
    }

    public <K, V> INode<K, V> copy$default$3() {
        return this.nv();
    }

    @Override
    public String productPrefix() {
        return "RDCSS_Descriptor";
    }

    @Override
    public int productArity() {
        return 3;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.old();
            }
            case 1: {
                return this.expectedmain();
            }
            case 2: {
                return this.nv();
            }
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof RDCSS_Descriptor;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        if (!(x$1 instanceof RDCSS_Descriptor)) return false;
        boolean bl = true;
        if (!bl) return false;
        RDCSS_Descriptor rDCSS_Descriptor = (RDCSS_Descriptor)x$1;
        INode<K, V> iNode = this.old();
        INode<K, V> iNode2 = rDCSS_Descriptor.old();
        if (iNode == null) {
            if (iNode2 != null) {
                return false;
            }
        } else if (!iNode.equals(iNode2)) return false;
        MainNode<K, V> mainNode = this.expectedmain();
        MainNode<K, V> mainNode2 = rDCSS_Descriptor.expectedmain();
        if (mainNode == null) {
            if (mainNode2 != null) {
                return false;
            }
        } else if (!mainNode.equals(mainNode2)) return false;
        INode<K, V> iNode3 = this.nv();
        INode<K, V> iNode4 = rDCSS_Descriptor.nv();
        if (iNode3 == null) {
            if (iNode4 != null) {
                return false;
            }
        } else if (!iNode3.equals(iNode4)) return false;
        if (!rDCSS_Descriptor.canEqual(this)) return false;
        return true;
    }

    public RDCSS_Descriptor(INode<K, V> old, MainNode<K, V> expectedmain, INode<K, V> nv) {
        this.old = old;
        this.expectedmain = expectedmain;
        this.nv = nv;
        Product.$init$(this);
        this.committed = false;
    }
}

