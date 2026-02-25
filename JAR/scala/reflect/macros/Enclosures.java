/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Position;
import scala.reflect.api.Trees;
import scala.reflect.macros.Enclosures$EnclosureException$;
import scala.reflect.macros.Universe;
import scala.reflect.macros.blackbox.Context;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\tub\u0001C\u0012%!\u0003\r\ta\u000b$\t\u000bA\u0002A\u0011A\u0019\t\u000bU\u0002a\u0011\u0001\u001c\t\u000bu\u0002a\u0011\u0001 \t\u000b1\u0003a\u0011A'\t\u000bE\u0003a\u0011\u0001\u001c\t\u000bi\u0003a\u0011\u0001\u001c\t\u000bq\u0003a\u0011A/\t\u000b%\u0004a\u0011\u00016\t\u000b=\u0004a\u0011\u00019\t\u000bU\u0004a\u0011\u0001<\t\u000bm\u0004a\u0011\u0001?\t\u000f\u0005\r\u0001A\"\u0001\u0002\u0006\u00191\u0011q\u0002\u0001A\u0003#A!\"!\n\u000e\u0005+\u0007I\u0011AA\u0014\u0011)\tI%\u0004B\tB\u0003%\u0011\u0011\u0006\u0005\u000b\u00033j!Q3A\u0005\u0002\u0005m\u0003BCA0\u001b\tE\t\u0015!\u0003\u0002^!9\u0011\u0011M\u0007\u0005\u0002\u0005\r\u0004\"CA:\u001b\u0005\u0005I\u0011AA;\u0011%\tY(DI\u0001\n\u0003\ti\bC\u0005\u0002\u00146\t\n\u0011\"\u0001\u0002\u0016\"I\u00111V\u0007\u0002\u0002\u0013\u0005\u0013Q\u0016\u0005\n\u0003kk\u0011\u0011!C\u0001\u0003oC\u0011\"a0\u000e\u0003\u0003%\t!!1\t\u0013\u0005\u001dW\"!A\u0005B\u0005%\u0007\"CAl\u001b\u0005\u0005I\u0011AAm\u0011%\t\u0019/DA\u0001\n\u0003\n)\u000fC\u0005\u0002h6\t\t\u0011\"\u0011\u0002j\u001eI\u0011q\u001e\u0001\u0002\u0002#\u0005\u0011\u0011\u001f\u0004\n\u0003\u001f\u0001\u0011\u0011!E\u0001\u0003gDq!!\u0019\u001f\t\u0003\u0011I\u0001C\u0005\u0003\fy\t\t\u0011\"\u0012\u0003\u000e!I!q\u0002\u0010\u0002\u0002\u0013\u0005%\u0011\u0003\u0005\n\u0005?q\u0012\u0011!CA\u0005C\u0011!\"\u00128dY>\u001cXO]3t\u0015\t)c%\u0001\u0004nC\u000e\u0014xn\u001d\u0006\u0003O!\nqA]3gY\u0016\u001cGOC\u0001*\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001\u0001\u0017\u0011\u00055rS\"\u0001\u0015\n\u0005=B#AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0002eA\u0011QfM\u0005\u0003i!\u0012A!\u00168ji\u0006\u0001R.Y2s_\u0006\u0003\b\u000f\\5dCRLwN\\\u000b\u0002oA\u0011\u0001(O\u0007\u0002\u0001%\u0011!h\u000f\u0002\u0005)J,W-\u0003\u0002=I\t9\u0011\t\\5bg\u0016\u001c\u0018aD3oG2|7/\u001b8h\u001b\u0006\u001c'o\\:\u0016\u0003}\u00022\u0001Q\"G\u001d\ti\u0013)\u0003\u0002CQ\u00059\u0001/Y2lC\u001e,\u0017B\u0001#F\u0005\u0011a\u0015n\u001d;\u000b\u0005\tC\u0003CA$K\u001b\u0005A%BA%%\u0003!\u0011G.Y2lE>D\u0018BA&I\u0005\u001d\u0019uN\u001c;fqR\f\u0011#\u001a8dY>\u001c\u0018N\\4Q_NLG/[8o+\u0005q\u0005C\u0001\u001dP\u0013\t\u00016H\u0001\u0005Q_NLG/[8o\u0003=)gn\u00197pg&tw-T3uQ>$\u0007\u0006B\u0003T-b\u0003\"!\f+\n\u0005UC#A\u00033faJ,7-\u0019;fI\u0006\nq+\u0001-d]\u0015t7\r\\8tS:<GK]3f[M$\u0018\u0010\\3!\u0003BK5\u000fI1sK\u0002rwn\u001e\u0011eKB\u0014XmY1uK\u0012\\\u0004eY8ogVdG\u000f\t;iK\u0002\u001a8-\u00197bI>\u001c\u0007EZ8sA5|'/\u001a\u0011j]\u001a|'/\\1uS>t\u0017%A-\u0002\rIr\u0013'\r\u00181\u00039)gn\u00197pg&twm\u00117bgNDCAB*W1\u0006aQM\\2m_NLgn\u001a#fMV\ta\f\u0005\u0002`E:\u0011\u0001\bY\u0005\u0003C*\u000b\u0001\"\u001e8jm\u0016\u00148/Z\u0005\u0003G\u0012\u0014a\u0001R3g\t\u00164\u0017BA3g\u0005\u0015!&/Z3t\u0015\t9g%A\u0002ba&DCaB*W1\u0006\tRM\\2m_NLgn\u001a+f[Bd\u0017\r^3\u0016\u0003-\u0004\"a\u00187\n\u00055$'\u0001\u0003+f[Bd\u0017\r^3)\t!\u0019f\u000bW\u0001\u000eK:\u001cGn\\:j]\u001eLU\u000e\u001d7\u0016\u0003E\u0004\"a\u0018:\n\u0005M$'aB%na2$UM\u001a\u0015\u0005\u0013M3\u0006,\u0001\tf]\u000edwn]5oOB\u000b7m[1hKV\tq\u000f\u0005\u0002`q&\u0011\u0011\u0010\u001a\u0002\u000b!\u0006\u001c7.Y4f\t\u00164\u0007\u0006\u0002\u0006T-b\u000bQ\"\u001a8dY>\u001c\u0018N\\4V]&$X#A?\u0011\u0005ar\u0018BA@<\u0005=\u0019u.\u001c9jY\u0006$\u0018n\u001c8V]&$\b\u0006B\u0006T-b\u000bA\"\u001a8dY>\u001c\u0018N\\4Sk:,\"!a\u0002\u0011\u0007a\nI!C\u0002\u0002\fm\u00121AU;oQ\u0011a1K\u0016-\u0003%\u0015s7\r\\8tkJ,W\t_2faRLwN\\\n\b\u001b\u0005M\u0011\u0011DA\u0010!\r\u0001\u0015QC\u0005\u0004\u0003/)%!C#yG\u0016\u0004H/[8o!\ri\u00131D\u0005\u0004\u0003;A#a\u0002)s_\u0012,8\r\u001e\t\u0004[\u0005\u0005\u0012bAA\u0012Q\ta1+\u001a:jC2L'0\u00192mK\u0006AQ\r\u001f9fGR,G-\u0006\u0002\u0002*A\"\u00111FA#!\u0019\ti#a\u000f\u0002B9!\u0011qFA\u001c!\r\t\t\u0004K\u0007\u0003\u0003gQ1!!\u000e+\u0003\u0019a$o\\8u}%\u0019\u0011\u0011\b\u0015\u0002\rA\u0013X\rZ3g\u0013\u0011\ti$a\u0010\u0003\u000b\rc\u0017m]:\u000b\u0007\u0005e\u0002\u0006\u0005\u0003\u0002D\u0005\u0015C\u0002\u0001\u0003\f\u0003\u000fz\u0011\u0011!A\u0001\u0006\u0003\tYEA\u0002`IE\n\u0011\"\u001a=qK\u000e$X\r\u001a\u0011\u0012\t\u00055\u00131\u000b\t\u0004[\u0005=\u0013bAA)Q\t9aj\u001c;iS:<\u0007cA\u0017\u0002V%\u0019\u0011q\u000b\u0015\u0003\u0007\u0005s\u00170\u0001\bf]\u000edwn]5oOR\u0013X-Z:\u0016\u0005\u0005u\u0003c\u0001!Do\u0005yQM\\2m_NLgn\u001a+sK\u0016\u001c\b%\u0001\u0004=S:LGO\u0010\u000b\u0007\u0003K\n9'!\u001d\u0011\u0005aj\u0001bBA\u0013%\u0001\u0007\u0011\u0011\u000e\u0019\u0005\u0003W\ny\u0007\u0005\u0004\u0002.\u0005m\u0012Q\u000e\t\u0005\u0003\u0007\ny\u0007\u0002\u0007\u0002H\u0005\u001d\u0014\u0011!A\u0001\u0006\u0003\tY\u0005C\u0004\u0002ZI\u0001\r!!\u0018\u0002\t\r|\u0007/\u001f\u000b\u0007\u0003K\n9(!\u001f\t\u0013\u0005\u00152\u0003%AA\u0002\u0005%\u0004\"CA-'A\u0005\t\u0019AA/\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uIE*\"!a 1\t\u0005\u0005\u0015\u0011\u0013\t\u0007\u0003\u0007\u000bi)a$\u000e\u0005\u0005\u0015%\u0002BAD\u0003\u0013\u000bA\u0001\\1oO*\u0011\u00111R\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002>\u0005\u0015\u0005\u0003BA\"\u0003##1\"a\u0012\u0015\u0003\u0003\u0005\tQ!\u0001\u0002L\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012TCAALU\u0011\ti&!',\u0005\u0005m\u0005\u0003BAO\u0003Ok!!a(\u000b\t\u0005\u0005\u00161U\u0001\nk:\u001c\u0007.Z2lK\u0012T1!!*)\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003S\u000byJA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAAX!\u0011\t\u0019)!-\n\t\u0005M\u0016Q\u0011\u0002\u0007'R\u0014\u0018N\\4\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0005\u0005e\u0006cA\u0017\u0002<&\u0019\u0011Q\u0018\u0015\u0003\u0007%sG/\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\t\u0005M\u00131\u0019\u0005\n\u0003\u000bD\u0012\u0011!a\u0001\u0003s\u000b1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XCAAf!\u0019\ti-a5\u0002T5\u0011\u0011q\u001a\u0006\u0004\u0003#D\u0013AC2pY2,7\r^5p]&!\u0011Q[Ah\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\u0005m\u0017\u0011\u001d\t\u0004[\u0005u\u0017bAApQ\t9!i\\8mK\u0006t\u0007\"CAc5\u0005\u0005\t\u0019AA*\u0003!A\u0017m\u001d5D_\u0012,GCAA]\u0003\u0019)\u0017/^1mgR!\u00111\\Av\u0011%\t)\rHA\u0001\u0002\u0004\t\u0019\u0006\u000b\u0003\u000e'ZC\u0016AE#oG2|7/\u001e:f\u000bb\u001cW\r\u001d;j_:\u0004\"\u0001\u000f\u0010\u0014\u000by\t)0a\b\u0011\u0015\u0005]\u0018Q B\u0001\u0003;\n)'\u0004\u0002\u0002z*\u0019\u00111 \u0015\u0002\u000fI,h\u000e^5nK&!\u0011q`A}\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gN\r\u0019\u0005\u0005\u0007\u00119\u0001\u0005\u0004\u0002.\u0005m\"Q\u0001\t\u0005\u0003\u0007\u00129\u0001B\u0006\u0002Hy\t\t\u0011!A\u0003\u0002\u0005-CCAAy\u0003!!xn\u0015;sS:<GCAAX\u0003\u0015\t\u0007\u000f\u001d7z)\u0019\t)Ga\u0005\u0003\u001e!9\u0011QE\u0011A\u0002\tU\u0001\u0007\u0002B\f\u00057\u0001b!!\f\u0002<\te\u0001\u0003BA\"\u00057!A\"a\u0012\u0003\u0014\u0005\u0005\t\u0011!B\u0001\u0003\u0017Bq!!\u0017\"\u0001\u0004\ti&A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\t\r\"q\u0007\t\u0006[\t\u0015\"\u0011F\u0005\u0004\u0005OA#AB(qi&|g\u000eE\u0004.\u0005W\u0011y#!\u0018\n\u0007\t5\u0002F\u0001\u0004UkBdWM\r\u0019\u0005\u0005c\u0011)\u0004\u0005\u0004\u0002.\u0005m\"1\u0007\t\u0005\u0003\u0007\u0012)\u0004B\u0006\u0002H\t\n\t\u0011!A\u0003\u0002\u0005-\u0003\"\u0003B\u001dE\u0005\u0005\t\u0019AA3\u0003\rAH\u0005\r\u0015\u0005=M3\u0006\f")
public interface Enclosures {
    public Enclosures$EnclosureException$ EnclosureException();

    public Trees.TreeApi macroApplication();

    public List<Context> enclosingMacros();

    public Position enclosingPosition();

    public Trees.TreeApi enclosingMethod();

    public Trees.TreeApi enclosingClass();

    public Trees.DefDefApi enclosingDef();

    public Trees.TemplateApi enclosingTemplate();

    public Trees.ImplDefApi enclosingImpl();

    public Trees.PackageDefApi enclosingPackage();

    public Universe.CompilationUnitContextApi enclosingUnit();

    public Universe.RunContextApi enclosingRun();

    public static void $init$(Enclosures $this) {
    }

    public class EnclosureException
    extends Exception
    implements Product,
    Serializable {
        private final Class<?> expected;
        private final List<Trees.TreeApi> enclosingTrees;
        public final /* synthetic */ Context $outer;

        public Class<?> expected() {
            return this.expected;
        }

        public List<Trees.TreeApi> enclosingTrees() {
            return this.enclosingTrees;
        }

        public EnclosureException copy(Class<?> expected, List<Trees.TreeApi> enclosingTrees) {
            return new EnclosureException(this.scala$reflect$macros$Enclosures$EnclosureException$$$outer(), expected, enclosingTrees);
        }

        public Class<?> copy$default$1() {
            return this.expected();
        }

        public List<Trees.TreeApi> copy$default$2() {
            return this.enclosingTrees();
        }

        @Override
        public String productPrefix() {
            return "EnclosureException";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.expected();
                }
                case 1: {
                    return this.enclosingTrees();
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
            return x$1 instanceof EnclosureException;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof EnclosureException)) return false;
            if (((EnclosureException)x$1).scala$reflect$macros$Enclosures$EnclosureException$$$outer() != this.scala$reflect$macros$Enclosures$EnclosureException$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            EnclosureException enclosureException = (EnclosureException)x$1;
            Class<?> clazz = this.expected();
            Class<?> clazz2 = enclosureException.expected();
            if (clazz == null) {
                if (clazz2 != null) {
                    return false;
                }
            } else if (!clazz.equals(clazz2)) return false;
            List<Trees.TreeApi> list = this.enclosingTrees();
            List<Trees.TreeApi> list2 = enclosureException.enclosingTrees();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            if (!enclosureException.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ Context scala$reflect$macros$Enclosures$EnclosureException$$$outer() {
            return this.$outer;
        }

        public EnclosureException(Context $outer, Class<?> expected, List<Trees.TreeApi> enclosingTrees) {
            this.expected = expected;
            this.enclosingTrees = enclosingTrees;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super(new StringBuilder(52).append("Couldn't find a tree of type ").append(expected).append(" among enclosing trees ").append(enclosingTrees).toString());
            Product.$init$(this);
        }
    }
}

