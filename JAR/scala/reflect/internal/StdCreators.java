/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Product;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Mirror;
import scala.reflect.api.TreeCreator;
import scala.reflect.api.Trees;
import scala.reflect.api.TypeCreator;
import scala.reflect.api.Types;
import scala.reflect.api.Universe;
import scala.reflect.internal.StdCreators$FixedMirrorTreeCreator$;
import scala.reflect.internal.StdCreators$FixedMirrorTypeCreator$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\tma!\u0003\u001a4!\u0003\r\tA\u000fB\n\u0011\u0015y\u0004\u0001\"\u0001A\r\u0011!\u0005\u0001Q#\t\u0011I\u0013!Q3A\u0005\u0002MC\u0001\u0002\u0017\u0002\u0003\u0012\u0003\u0006I\u0001\u0016\u0005\t3\n\u0011)\u001a!C\u00015\"A\u0001M\u0001B\tB\u0003%1\fC\u0003b\u0005\u0011\u0005!\rC\u0003g\u0005\u0011\u0005q\rC\u0005\u0002\u0002\t\t\t\u0011\"\u0001\u0002\u0004!I\u0011\u0011\u0002\u0002\u0012\u0002\u0013\u0005\u00111\u0002\u0005\n\u0003C\u0011\u0011\u0013!C\u0001\u0003GA\u0011\"a\n\u0003\u0003\u0003%\t%!\u000b\t\u0013\u0005m\"!!A\u0005\u0002\u0005u\u0002\"CA#\u0005\u0005\u0005I\u0011AA$\u0011%\t\u0019FAA\u0001\n\u0003\n)\u0006C\u0005\u0002d\t\t\t\u0011\"\u0001\u0002f!I\u0011q\u000e\u0002\u0002\u0002\u0013\u0005\u0013\u0011\u000f\u0005\n\u0003g\u0012\u0011\u0011!C!\u0003kB\u0011\"a\u001e\u0003\u0003\u0003%\t%!\u001f\b\u0013\u0005u\u0004!!A\t\u0002\u0005}d\u0001\u0003#\u0001\u0003\u0003E\t!!!\t\r\u0005,B\u0011AAH\u0011%\t\u0019(FA\u0001\n\u000b\n)\b\u0003\u0005g+\u0005\u0005I\u0011QAI\u0011%\t9*FA\u0001\n\u0003\u000bIJ\u0002\u0004\u0002,\u0002\u0001\u0015Q\u0016\u0005\t%j\u0011)\u001a!C\u0001'\"A\u0001L\u0007B\tB\u0003%A\u000b\u0003\u0006\u00026j\u0011)\u001a!C\u0001\u0003oC!\"a1\u001b\u0005#\u0005\u000b\u0011BA]\u0011\u0019\t'\u0004\"\u0001\u0002F\"1aM\u0007C\u0001\u0003\u001bD\u0011\"!\u0001\u001b\u0003\u0003%\t!!:\t\u0013\u0005%!$%A\u0005\u0002\u0005-\u0001\"CA\u00115E\u0005I\u0011AAv\u0011%\t9CGA\u0001\n\u0003\nI\u0003C\u0005\u0002<i\t\t\u0011\"\u0001\u0002>!I\u0011Q\t\u000e\u0002\u0002\u0013\u0005\u0011q\u001e\u0005\n\u0003'R\u0012\u0011!C!\u0003+B\u0011\"a\u0019\u001b\u0003\u0003%\t!a=\t\u0013\u0005=$$!A\u0005B\u0005E\u0004\"CA:5\u0005\u0005I\u0011IA;\u0011%\t9HGA\u0001\n\u0003\n9pB\u0005\u0002|\u0002\t\t\u0011#\u0001\u0002~\u001aI\u00111\u0016\u0001\u0002\u0002#\u0005\u0011q \u0005\u0007C6\"\tAa\u0001\t\u0013\u0005MT&!A\u0005F\u0005U\u0004\u0002\u00034.\u0003\u0003%\tI!\u0002\t\u0013\u0005]U&!A\u0005\u0002\n-!aC*uI\u000e\u0013X-\u0019;peNT!\u0001N\u001b\u0002\u0011%tG/\u001a:oC2T!AN\u001c\u0002\u000fI,g\r\\3di*\t\u0001(A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001Y\u0004C\u0001\u001f>\u001b\u00059\u0014B\u0001 8\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012!\u0011\t\u0003y\tK!aQ\u001c\u0003\tUs\u0017\u000e\u001e\u0002\u0017\r&DX\rZ'jeJ|'\u000f\u0016:fK\u000e\u0013X-\u0019;peN!!A\u0012'P!\t9%*D\u0001I\u0015\tIU'A\u0002ba&L!a\u0013%\u0003\u0017Q\u0013X-Z\"sK\u0006$xN\u001d\t\u0003y5K!AT\u001c\u0003\u000fA\u0013x\u000eZ;diB\u0011A\bU\u0005\u0003#^\u0012AbU3sS\u0006d\u0017N_1cY\u0016\fa!\\5se>\u0014X#\u0001+\u0011\u0007\u001d+v+\u0003\u0002W\u0011\n1Q*\u001b:s_Jl\u0011\u0001A\u0001\b[&\u0014(o\u001c:!\u0003\u0011!(/Z3\u0016\u0003m\u0003\"a\u0016/\n\u0005us&\u0001\u0002+sK\u0016L!aX\u001a\u0003\u000bQ\u0013X-Z:\u0002\u000bQ\u0014X-\u001a\u0011\u0002\rqJg.\u001b;?)\r\u0019G-\u001a\t\u0003/\nAQAU\u0004A\u0002QCQ!W\u0004A\u0002m\u000bQ!\u00199qYf,\"\u0001\u001b7\u0015\u0005%l\bC\u00016|!\tYG\u000e\u0004\u0001\u0005\u000b5D!\u0019\u00018\u0003\u0003U\u000b\"a\u001c:\u0011\u0005q\u0002\u0018BA98\u0005\u001dqu\u000e\u001e5j]\u001e\u00142a];y\r\u0011!(\u0001\u0001:\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0005\u001d3\u0018BA<I\u0005!)f.\u001b<feN,\u0007C\u0001\u001fz\u0013\tQxGA\u0005TS:<G.\u001a;p]&\u0011Q\f`\u0005\u0003?\"CQA \u0005A\u0002}\f\u0011!\u001c\t\u0004\u000fVS\u0017\u0001B2paf$RaYA\u0003\u0003\u000fAqAU\u0005\u0011\u0002\u0003\u0007A\u000bC\u0004Z\u0013A\u0005\t\u0019A.\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\u0011\u0011Q\u0002\u0016\u0004)\u0006=1FAA\t!\u0011\t\u0019\"!\b\u000e\u0005\u0005U!\u0002BA\f\u00033\t\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0007\u0005mq'\u0001\u0006b]:|G/\u0019;j_:LA!a\b\u0002\u0016\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU\u0011\u0011Q\u0005\u0016\u00047\u0006=\u0011!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070\u0006\u0002\u0002,A!\u0011QFA\u001c\u001b\t\tyC\u0003\u0003\u00022\u0005M\u0012\u0001\u00027b]\u001eT!!!\u000e\u0002\t)\fg/Y\u0005\u0005\u0003s\tyC\u0001\u0004TiJLgnZ\u0001\raJ|G-^2u\u0003JLG/_\u000b\u0003\u0003\u007f\u00012\u0001PA!\u0013\r\t\u0019e\u000e\u0002\u0004\u0013:$\u0018A\u00049s_\u0012,8\r^#mK6,g\u000e\u001e\u000b\u0005\u0003\u0013\ny\u0005E\u0002=\u0003\u0017J1!!\u00148\u0005\r\te.\u001f\u0005\n\u0003#r\u0011\u0011!a\u0001\u0003\u007f\t1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XCAA,!\u0019\tI&a\u0018\u0002J5\u0011\u00111\f\u0006\u0004\u0003;:\u0014AC2pY2,7\r^5p]&!\u0011\u0011MA.\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\u0005\u001d\u0014Q\u000e\t\u0004y\u0005%\u0014bAA6o\t9!i\\8mK\u0006t\u0007\"CA)!\u0005\u0005\t\u0019AA%\u0003!A\u0017m\u001d5D_\u0012,GCAA \u0003!!xn\u0015;sS:<GCAA\u0016\u0003\u0019)\u0017/^1mgR!\u0011qMA>\u0011%\t\tfEA\u0001\u0002\u0004\tI%\u0001\fGSb,G-T5se>\u0014HK]3f\u0007J,\u0017\r^8s!\t9Vc\u0005\u0003\u0016\u0003\u0007{\u0005cBAC\u0003\u0017#6lY\u0007\u0003\u0003\u000fS1!!#8\u0003\u001d\u0011XO\u001c;j[\u0016LA!!$\u0002\b\n\t\u0012IY:ue\u0006\u001cGOR;oGRLwN\u001c\u001a\u0015\u0005\u0005}D#B2\u0002\u0014\u0006U\u0005\"\u0002*\u0019\u0001\u0004!\u0006\"B-\u0019\u0001\u0004Y\u0016aB;oCB\u0004H.\u001f\u000b\u0005\u00037\u000b9\u000bE\u0003=\u0003;\u000b\t+C\u0002\u0002 ^\u0012aa\u00149uS>t\u0007#\u0002\u001f\u0002$R[\u0016bAASo\t1A+\u001e9mKJB\u0001\"!+\u001a\u0003\u0003\u0005\raY\u0001\u0004q\u0012\u0002$A\u0006$jq\u0016$W*\u001b:s_J$\u0016\u0010]3De\u0016\fGo\u001c:\u0014\u000bi\ty\u000bT(\u0011\u0007\u001d\u000b\t,C\u0002\u00024\"\u00131\u0002V=qK\u000e\u0013X-\u0019;pe\u0006\u0019A\u000f]3\u0016\u0005\u0005e\u0006cA,\u0002<&!\u0011QXA`\u0005\u0011!\u0016\u0010]3\n\u0007\u0005\u00057GA\u0003UsB,7/\u0001\u0003ua\u0016\u0004CCBAd\u0003\u0013\fY\r\u0005\u0002X5!)!k\ba\u0001)\"9\u0011QW\u0010A\u0002\u0005eV\u0003BAh\u0003+$B!!5\u0002bB!\u00111[Ao!\rY\u0017Q\u001b\u0003\u0007[\u0002\u0012\r!a6\u0012\u0007=\fIN\u0005\u0003\u0002\\VDh!\u0002;\u001b\u0001\u0005e\u0017\u0002BA_\u0003?L1!!1I\u0011\u0019q\b\u00051\u0001\u0002dB!q)VAj)\u0019\t9-a:\u0002j\"9!+\tI\u0001\u0002\u0004!\u0006\"CA[CA\u0005\t\u0019AA]+\t\tiO\u000b\u0003\u0002:\u0006=A\u0003BA%\u0003cD\u0011\"!\u0015'\u0003\u0003\u0005\r!a\u0010\u0015\t\u0005\u001d\u0014Q\u001f\u0005\n\u0003#B\u0013\u0011!a\u0001\u0003\u0013\"B!a\u001a\u0002z\"I\u0011\u0011K\u0016\u0002\u0002\u0003\u0007\u0011\u0011J\u0001\u0017\r&DX\rZ'jeJ|'\u000fV=qK\u000e\u0013X-\u0019;peB\u0011q+L\n\u0005[\t\u0005q\nE\u0005\u0002\u0006\u0006-E+!/\u0002HR\u0011\u0011Q \u000b\u0007\u0003\u000f\u00149A!\u0003\t\u000bI\u0003\u0004\u0019\u0001+\t\u000f\u0005U\u0006\u00071\u0001\u0002:R!!Q\u0002B\t!\u0015a\u0014Q\u0014B\b!\u0019a\u00141\u0015+\u0002:\"I\u0011\u0011V\u0019\u0002\u0002\u0003\u0007\u0011q\u0019\t\u0005\u0005+\u00119\"D\u00014\u0013\r\u0011Ib\r\u0002\f'fl'm\u001c7UC\ndW\r")
public interface StdCreators {
    public StdCreators$FixedMirrorTreeCreator$ FixedMirrorTreeCreator();

    public StdCreators$FixedMirrorTypeCreator$ FixedMirrorTypeCreator();

    public static void $init$(StdCreators $this) {
    }

    public class FixedMirrorTreeCreator
    extends TreeCreator
    implements Product {
        private final Mirror<SymbolTable> mirror;
        private final Trees.Tree tree;
        public final /* synthetic */ SymbolTable $outer;

        public Mirror<SymbolTable> mirror() {
            return this.mirror;
        }

        public Trees.Tree tree() {
            return this.tree;
        }

        @Override
        public <U extends Universe> Trees.TreeApi apply(Mirror<U> m) {
            if (m == this.mirror()) {
                return this.tree();
            }
            throw new IllegalArgumentException(new StringBuilder(53).append("Expr defined in ").append(this.mirror()).append(" cannot be migrated to other mirrors.").toString());
        }

        public FixedMirrorTreeCreator copy(Mirror<SymbolTable> mirror, Trees.Tree tree) {
            return new FixedMirrorTreeCreator(this.scala$reflect$internal$StdCreators$FixedMirrorTreeCreator$$$outer(), mirror, tree);
        }

        public Mirror<SymbolTable> copy$default$1() {
            return this.mirror();
        }

        public Trees.Tree copy$default$2() {
            return this.tree();
        }

        @Override
        public String productPrefix() {
            return "FixedMirrorTreeCreator";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.mirror();
                }
                case 1: {
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
            return x$1 instanceof FixedMirrorTreeCreator;
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
            if (!(x$1 instanceof FixedMirrorTreeCreator)) return false;
            if (((FixedMirrorTreeCreator)x$1).scala$reflect$internal$StdCreators$FixedMirrorTreeCreator$$$outer() != this.scala$reflect$internal$StdCreators$FixedMirrorTreeCreator$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            FixedMirrorTreeCreator fixedMirrorTreeCreator = (FixedMirrorTreeCreator)x$1;
            Mirror<SymbolTable> mirror = this.mirror();
            Mirror<SymbolTable> mirror2 = fixedMirrorTreeCreator.mirror();
            if (mirror == null) {
                if (mirror2 != null) {
                    return false;
                }
            } else if (!mirror.equals(mirror2)) return false;
            Trees.Tree tree = this.tree();
            Trees.Tree tree2 = fixedMirrorTreeCreator.tree();
            if (tree == null) {
                if (tree2 != null) {
                    return false;
                }
            } else if (!((Object)tree).equals(tree2)) return false;
            if (!fixedMirrorTreeCreator.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdCreators$FixedMirrorTreeCreator$$$outer() {
            return this.$outer;
        }

        public FixedMirrorTreeCreator(SymbolTable $outer, Mirror<SymbolTable> mirror, Trees.Tree tree) {
            this.mirror = mirror;
            this.tree = tree;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }

    public class FixedMirrorTypeCreator
    extends TypeCreator
    implements Product {
        private final Mirror<SymbolTable> mirror;
        private final Types.Type tpe;
        public final /* synthetic */ SymbolTable $outer;

        public Mirror<SymbolTable> mirror() {
            return this.mirror;
        }

        public Types.Type tpe() {
            return this.tpe;
        }

        @Override
        public <U extends Universe> Types.TypeApi apply(Mirror<U> m) {
            if (m == this.mirror()) {
                return this.tpe();
            }
            throw new IllegalArgumentException(new StringBuilder(57).append("Type tag defined in ").append(this.mirror()).append(" cannot be migrated to other mirrors.").toString());
        }

        public FixedMirrorTypeCreator copy(Mirror<SymbolTable> mirror, Types.Type tpe) {
            return new FixedMirrorTypeCreator(this.scala$reflect$internal$StdCreators$FixedMirrorTypeCreator$$$outer(), mirror, tpe);
        }

        public Mirror<SymbolTable> copy$default$1() {
            return this.mirror();
        }

        public Types.Type copy$default$2() {
            return this.tpe();
        }

        @Override
        public String productPrefix() {
            return "FixedMirrorTypeCreator";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.mirror();
                }
                case 1: {
                    return this.tpe();
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
            return x$1 instanceof FixedMirrorTypeCreator;
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
            if (!(x$1 instanceof FixedMirrorTypeCreator)) return false;
            if (((FixedMirrorTypeCreator)x$1).scala$reflect$internal$StdCreators$FixedMirrorTypeCreator$$$outer() != this.scala$reflect$internal$StdCreators$FixedMirrorTypeCreator$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            FixedMirrorTypeCreator fixedMirrorTypeCreator = (FixedMirrorTypeCreator)x$1;
            Mirror<SymbolTable> mirror = this.mirror();
            Mirror<SymbolTable> mirror2 = fixedMirrorTypeCreator.mirror();
            if (mirror == null) {
                if (mirror2 != null) {
                    return false;
                }
            } else if (!mirror.equals(mirror2)) return false;
            Types.Type type = this.tpe();
            Types.Type type2 = fixedMirrorTypeCreator.tpe();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            if (!fixedMirrorTypeCreator.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdCreators$FixedMirrorTypeCreator$$$outer() {
            return this.$outer;
        }

        public FixedMirrorTypeCreator(SymbolTable $outer, Mirror<SymbolTable> mirror, Types.Type tpe) {
            this.mirror = mirror;
            this.tpe = tpe;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }
}

