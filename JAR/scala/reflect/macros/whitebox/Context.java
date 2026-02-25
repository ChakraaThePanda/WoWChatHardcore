/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros.whitebox;

import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.Types;
import scala.reflect.macros.whitebox.Context$ImplicitCandidate$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005faB\u0012%!\u0003\r\t!\f\u0005\u0006o\u0001!\t\u0001\u000f\u0005\u0006y\u00011\t!\u0010\u0005\u0006\u000f\u00021\t!\u0010\u0004\u0005\u0011\u0002\u0001\u0015\n\u0003\u0005Q\t\tU\r\u0011\"\u0001R\u0011!AFA!E!\u0002\u0013\u0011\u0006\u0002C-\u0005\u0005+\u0007I\u0011\u0001.\t\u0011y#!\u0011#Q\u0001\nmC\u0001b\u0018\u0003\u0003\u0016\u0004%\t!\u0015\u0005\tA\u0012\u0011\t\u0012)A\u0005%\"A\u0011\r\u0002BK\u0002\u0013\u0005!\r\u0003\u0005g\t\tE\t\u0015!\u0003d\u0011\u00159G\u0001\"\u0001i\u0011\u001dqG!!A\u0005\u0002=Dq\u0001\u001e\u0003\u0012\u0002\u0013\u0005Q\u000fC\u0005\u0002\u0002\u0011\t\n\u0011\"\u0001\u0002\u0004!A\u0011q\u0001\u0003\u0012\u0002\u0013\u0005Q\u000fC\u0005\u0002\n\u0011\t\n\u0011\"\u0001\u0002\f!I\u0011q\u0002\u0003\u0002\u0002\u0013\u0005\u0013\u0011\u0003\u0005\n\u0003G!\u0011\u0011!C\u0001\u0003KA\u0011\"!\f\u0005\u0003\u0003%\t!a\f\t\u0013\u0005mB!!A\u0005B\u0005u\u0002\"CA&\t\u0005\u0005I\u0011AA'\u0011%\t9\u0006BA\u0001\n\u0003\nI\u0006C\u0005\u0002\\\u0011\t\t\u0011\"\u0011\u0002^!I\u0011q\f\u0003\u0002\u0002\u0013\u0005\u0013\u0011M\u0004\n\u0003K\u0002\u0011\u0011!E\u0001\u0003O2\u0001\u0002\u0013\u0001\u0002\u0002#\u0005\u0011\u0011\u000e\u0005\u0007Or!\t!a\u001e\t\u0013\u0005mC$!A\u0005F\u0005u\u0003\"CA=9\u0005\u0005I\u0011QA>\u0011%\t)\tHA\u0001\n\u0003\u000b9\tC\u0004\u0002\u001a\u00021\t!a'\t\u000f\u0005}\u0005A\"\u0001\u0002\u001c\n91i\u001c8uKb$(BA\u0013'\u0003!9\b.\u001b;fE>D(BA\u0014)\u0003\u0019i\u0017m\u0019:pg*\u0011\u0011FK\u0001\be\u00164G.Z2u\u0015\u0005Y\u0013!B:dC2\f7\u0001A\n\u0004\u00019\u0012\u0004CA\u00181\u001b\u0005Q\u0013BA\u0019+\u0005\u0019\te.\u001f*fMB\u00111GN\u0007\u0002i)\u0011QGJ\u0001\tE2\f7m\u001b2pq&\u00111\u0005N\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003e\u0002\"a\f\u001e\n\u0005mR#\u0001B+oSR\f!b\u001c9f]6\u000b7M]8t+\u0005q\u0004cA C\u000b:\u0011q\u0006Q\u0005\u0003\u0003*\nq\u0001]1dW\u0006<W-\u0003\u0002D\t\n!A*[:u\u0015\t\t%\u0006\u0005\u0002G\u00015\tA%A\bf]\u000edwn]5oO6\u000b7M]8t\u0005EIU\u000e\u001d7jG&$8)\u00198eS\u0012\fG/Z\n\u0005\t9RU\n\u0005\u00020\u0017&\u0011AJ\u000b\u0002\b!J|G-^2u!\tyc*\u0003\u0002PU\ta1+\u001a:jC2L'0\u00192mK\u0006\u0019\u0001O]3\u0016\u0003I\u0003\"a\u0015+\u000e\u0003\u0001I!!\u0016,\u0003\tQK\b/Z\u0005\u0003/\u001a\u0012q!\u00117jCN,7/\u0001\u0003qe\u0016\u0004\u0013aA:z[V\t1\f\u0005\u0002T9&\u0011QL\u0016\u0002\u0007'fl'm\u001c7\u0002\tMLX\u000eI\u0001\u0003aR\f1\u0001\u001d;!\u0003\u0011!(/Z3\u0016\u0003\r\u0004\"a\u00153\n\u0005\u00154&\u0001\u0002+sK\u0016\fQ\u0001\u001e:fK\u0002\na\u0001P5oSRtD#B5kW2l\u0007CA*\u0005\u0011\u0015\u0001V\u00021\u0001S\u0011\u0015IV\u00021\u0001\\\u0011\u0015yV\u00021\u0001S\u0011\u0015\tW\u00021\u0001d\u0003\u0011\u0019w\u000e]=\u0015\u000b%\u0004\u0018O]:\t\u000fAs\u0001\u0013!a\u0001%\"9\u0011L\u0004I\u0001\u0002\u0004Y\u0006bB0\u000f!\u0003\u0005\rA\u0015\u0005\bC:\u0001\n\u00111\u0001d\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\u0012A\u001e\u0016\u0003%^\\\u0013\u0001\u001f\t\u0003szl\u0011A\u001f\u0006\u0003wr\f\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005uT\u0013AC1o]>$\u0018\r^5p]&\u0011qP\u001f\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017AD2paf$C-\u001a4bk2$HEM\u000b\u0003\u0003\u000bQ#aW<\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%g\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\"TCAA\u0007U\t\u0019w/A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0003\u0003'\u0001B!!\u0006\u0002 5\u0011\u0011q\u0003\u0006\u0005\u00033\tY\"\u0001\u0003mC:<'BAA\u000f\u0003\u0011Q\u0017M^1\n\t\u0005\u0005\u0012q\u0003\u0002\u0007'R\u0014\u0018N\\4\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0005\u0005\u001d\u0002cA\u0018\u0002*%\u0019\u00111\u0006\u0016\u0003\u0007%sG/\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\t\u0005E\u0012q\u0007\t\u0004_\u0005M\u0012bAA\u001bU\t\u0019\u0011I\\=\t\u0013\u0005eR#!AA\u0002\u0005\u001d\u0012a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/\u0006\u0002\u0002@A1\u0011\u0011IA$\u0003ci!!a\u0011\u000b\u0007\u0005\u0015#&\u0001\u0006d_2dWm\u0019;j_:LA!!\u0013\u0002D\tA\u0011\n^3sCR|'/\u0001\u0005dC:,\u0015/^1m)\u0011\ty%!\u0016\u0011\u0007=\n\t&C\u0002\u0002T)\u0012qAQ8pY\u0016\fg\u000eC\u0005\u0002:]\t\t\u00111\u0001\u00022\u0005A\u0001.Y:i\u0007>$W\r\u0006\u0002\u0002(\u0005AAo\\*ue&tw\r\u0006\u0002\u0002\u0014\u00051Q-];bYN$B!a\u0014\u0002d!I\u0011\u0011\b\u000e\u0002\u0002\u0003\u0007\u0011\u0011G\u0001\u0012\u00136\u0004H.[2ji\u000e\u000bg\u000eZ5eCR,\u0007CA*\u001d'\u0011a\u00121N'\u0011\u0013\u00055\u00141\u000f*\\%\u000eLWBAA8\u0015\r\t\tHK\u0001\beVtG/[7f\u0013\u0011\t)(a\u001c\u0003#\u0005\u00137\u000f\u001e:bGR4UO\\2uS>tG\u0007\u0006\u0002\u0002h\u0005)\u0011\r\u001d9msRI\u0011.! \u0002\u0000\u0005\u0005\u00151\u0011\u0005\u0006!~\u0001\rA\u0015\u0005\u00063~\u0001\ra\u0017\u0005\u0006?~\u0001\rA\u0015\u0005\u0006C~\u0001\raY\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\tI)!&\u0011\u000b=\nY)a$\n\u0007\u00055%F\u0001\u0004PaRLwN\u001c\t\b_\u0005E%k\u0017*d\u0013\r\t\u0019J\u000b\u0002\u0007)V\u0004H.\u001a\u001b\t\u0011\u0005]\u0005%!AA\u0002%\f1\u0001\u001f\u00131\u00035y\u0007/\u001a8J[Bd\u0017nY5ugV\u0011\u0011Q\u0014\t\u0004\u007f\tK\u0017AE3oG2|7/\u001b8h\u00136\u0004H.[2jiN\u0004")
public interface Context
extends scala.reflect.macros.blackbox.Context {
    public Context$ImplicitCandidate$ ImplicitCandidate();

    public List<Context> openMacros();

    public List<Context> enclosingMacros();

    public List<ImplicitCandidate> openImplicits();

    public List<ImplicitCandidate> enclosingImplicits();

    public static void $init$(Context $this) {
    }

    public class ImplicitCandidate
    implements Product,
    Serializable {
        private final Types.TypeApi pre;
        private final Symbols.SymbolApi sym;
        private final Types.TypeApi pt;
        private final Trees.TreeApi tree;
        public final /* synthetic */ Context $outer;

        public Types.TypeApi pre() {
            return this.pre;
        }

        public Symbols.SymbolApi sym() {
            return this.sym;
        }

        public Types.TypeApi pt() {
            return this.pt;
        }

        public Trees.TreeApi tree() {
            return this.tree;
        }

        public ImplicitCandidate copy(Types.TypeApi pre, Symbols.SymbolApi sym, Types.TypeApi pt, Trees.TreeApi tree) {
            return new ImplicitCandidate(this.scala$reflect$macros$whitebox$Context$ImplicitCandidate$$$outer(), pre, sym, pt, tree);
        }

        public Types.TypeApi copy$default$1() {
            return this.pre();
        }

        public Symbols.SymbolApi copy$default$2() {
            return this.sym();
        }

        public Types.TypeApi copy$default$3() {
            return this.pt();
        }

        public Trees.TreeApi copy$default$4() {
            return this.tree();
        }

        @Override
        public String productPrefix() {
            return "ImplicitCandidate";
        }

        @Override
        public int productArity() {
            return 4;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.pre();
                }
                case 1: {
                    return this.sym();
                }
                case 2: {
                    return this.pt();
                }
                case 3: {
                    return this.tree();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof ImplicitCandidate;
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
            if (!(x$1 instanceof ImplicitCandidate)) return false;
            if (((ImplicitCandidate)x$1).scala$reflect$macros$whitebox$Context$ImplicitCandidate$$$outer() != this.scala$reflect$macros$whitebox$Context$ImplicitCandidate$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            ImplicitCandidate implicitCandidate = (ImplicitCandidate)x$1;
            Types.TypeApi typeApi = this.pre();
            Types.TypeApi typeApi2 = implicitCandidate.pre();
            if (typeApi == null) {
                if (typeApi2 != null) {
                    return false;
                }
            } else if (!typeApi.equals(typeApi2)) return false;
            Symbols.SymbolApi symbolApi = this.sym();
            Symbols.SymbolApi symbolApi2 = implicitCandidate.sym();
            if (symbolApi == null) {
                if (symbolApi2 != null) {
                    return false;
                }
            } else if (!symbolApi.equals(symbolApi2)) return false;
            Types.TypeApi typeApi3 = this.pt();
            Types.TypeApi typeApi4 = implicitCandidate.pt();
            if (typeApi3 == null) {
                if (typeApi4 != null) {
                    return false;
                }
            } else if (!typeApi3.equals(typeApi4)) return false;
            Trees.TreeApi treeApi = this.tree();
            Trees.TreeApi treeApi2 = implicitCandidate.tree();
            if (treeApi == null) {
                if (treeApi2 != null) {
                    return false;
                }
            } else if (!treeApi.equals(treeApi2)) return false;
            if (!implicitCandidate.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ Context scala$reflect$macros$whitebox$Context$ImplicitCandidate$$$outer() {
            return this.$outer;
        }

        public ImplicitCandidate(Context $outer, Types.TypeApi pre, Symbols.SymbolApi sym, Types.TypeApi pt, Trees.TreeApi tree) {
            this.pre = pre;
            this.sym = sym;
            this.pt = pt;
            this.tree = tree;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }
}

