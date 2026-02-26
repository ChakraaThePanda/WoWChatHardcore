/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import java.io.ObjectStreamException;
import scala.Equals;
import scala.Predef$;
import scala.Serializable;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Exprs$Expr$;
import scala.reflect.api.Mirror;
import scala.reflect.api.Mirrors;
import scala.reflect.api.SerializedExpr;
import scala.reflect.api.TreeCreator;
import scala.reflect.api.Trees;
import scala.reflect.api.TypeTags;
import scala.reflect.api.Types;
import scala.reflect.api.Universe;
import scala.reflect.runtime.package$;

@ScalaSignature(bytes="\u0006\u0001\u0005]g\u0001\u0003\u0012$!\u0003\r\tA\u000b+\t\u000b=\u0002A\u0011\u0001\u0019\u0007\u000fQ\u0002\u0001\u0013aA\u0001k!)qF\u0001C\u0001a!9QH\u0001b\u0001\u000e\u0003q\u0004\"B#\u0003\r\u00031\u0005\"\u00024\u0003\r\u00039\u0007\"B7\u0003\r\u0003q\u0007\"\u0002;\u0003\r\u0003q\u0007\"B;\u0003\r\u00031\b\u0002CA\u0001\u0005\t\u0007i\u0011\u0001<\t\u000f\u0005%!\u0001\"\u0011\u0002\f!9\u0011q\u0003\u0002\u0005B\u0005e\u0001bBA\u000f\u0005\u0011\u0005\u0013q\u0004\u0005\b\u0003O\u0011A\u0011IA\u0015\u000f\u001d\tY\u0004\u0001E\u0001\u0003{1a\u0001\u000e\u0001\t\u0002\u0005}\u0002bBA!!\u0011\u0005\u00111\t\u0005\b\u0003\u000b\u0002B\u0011AA$\u0011\u001d\ty\u0007\u0005C\u0001\u0003c2a!!\"\u0001\t\u0005\u001d\u0005\u0002C\u001f\u0015\u0005\u000b\u0007I\u0011\u0001 \t\u0013\u0005EEC!A!\u0002\u0013y\u0004BCA4)\t\u0015\r\u0011\"\u0001\u0002\u0014\"Q\u0011Q\u0013\u000b\u0003\u0002\u0003\u0006I!!\u001b\t\u0015\u0005]ECaA!\u0002\u0017\tI\nC\u0004\u0002BQ!\t!a'\t\r\u0015#B\u0011AAT\u0011!1G\u0003#b\u0001\n\u00039\u0007\u0002C7\u0015\u0011\u000b\u0007I\u0011\u00018\t\u000bQ$B\u0011\u00018\t\rU$B\u0011AA^\u0011)\t\t\u0001\u0006EC\u0002\u0013\u0005\u00111\u0018\u0005\b\u0003{#B\u0011BA`\u0005\u0015)\u0005\u0010\u001d:t\u0015\t!S%A\u0002ba&T!AJ\u0014\u0002\u000fI,g\r\\3di*\t\u0001&A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001Y\u0003C\u0001\u0017.\u001b\u00059\u0013B\u0001\u0018(\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012!\r\t\u0003YIJ!aM\u0014\u0003\tUs\u0017\u000e\u001e\u0002\u0005\u000bb\u0004(/\u0006\u000279N!!aK\u001c;!\ta\u0003(\u0003\u0002:O\t1Q)];bYN\u0004\"\u0001L\u001e\n\u0005q:#\u0001D*fe&\fG.\u001b>bE2,\u0017AB7jeJ|'/F\u0001@!\t\u0001\u0015)D\u0001\u0001\u0013\t\u00115I\u0001\u0004NSJ\u0014xN]\u0005\u0003\t\u000e\u0012q!T5se>\u00148/\u0001\u0002j]V\u0011qi\u0013\u000b\u0003\u0011\n\u00042!\u0013\u0002\\!\tQ5\n\u0004\u0001\u0005\u000b1+!\u0019A'\u0003\u0003U\u000b\"AT)\u0011\u00051z\u0015B\u0001)(\u0005\u001dqu\u000e\u001e5j]\u001e\u00142A\u0015+Y\r\u0011\u0019&\u0001A)\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0005U3V\"A\u0012\n\u0005]\u001b#\u0001C+oSZ,'o]3\u0011\u00051J\u0016B\u0001.(\u0005%\u0019\u0016N\\4mKR|g\u000e\u0005\u0002K9\u00121QL\u0001CC\u0002y\u0013\u0011\u0001V\t\u0003\u001d~\u0003\"\u0001\f1\n\u0005\u0005<#aA!os\")1-\u0002a\u0001I\u0006Yq\u000e\u001e5fe6K'O]8s!\r)V-S\u0005\u0003\u0005\u000e\nA\u0001\u001e:fKV\t\u0001\u000e\u0005\u0002AS&\u0011!n\u001b\u0002\u0005)J,W-\u0003\u0002mG\t)AK]3fg\u0006Q1\u000f^1uS\u000e$\u0016\u0010]3\u0016\u0003=\u0004\"\u0001\u00119\n\u0005E\u0014(\u0001\u0002+za\u0016L!a]\u0012\u0003\u000bQK\b/Z:\u0002\u0015\u0005\u001cG/^1m)f\u0004X-\u0001\u0004ta2L7-Z\u000b\u00027\"\u001a\u0011\u0002\u001f@\u0011\u0005edX\"\u0001>\u000b\u0005m<\u0013AC1o]>$\u0018\r^5p]&\u0011QP\u001f\u0002\u0010G>l\u0007/\u001b7f)&lWm\u00148ms\u0006\nq0A\u0018ta2L7-\u001a\u0011nkN$\bEY3!K:\u001cGn\\:fI\u0002:\u0018\u000e\u001e5j]\u0002\n\u0007E]3jMf\u000430 \u0011cY>\u001c7.A\u0003wC2,X\r\u000b\u0003\u000bq\u0006\u0015\u0011EAA\u0004\u0003}\u001a\u0017M\u001c8pi\u0002*8/\u001a\u0011wC2,X\rI3yG\u0016\u0004H\u000f\t4pe\u0002\u001a\u0018n\u001a8biV\u0014Xm\u001d\u0011pM\u0002j\u0017m\u0019:pA%l\u0007\u000f\\3nK:$\u0018\r^5p]N\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0003\u001b\t\u0019\u0002E\u0002-\u0003\u001fI1!!\u0005(\u0005\u001d\u0011un\u001c7fC:Da!!\u0006\f\u0001\u0004y\u0016!\u0001=\u0002\r\u0015\fX/\u00197t)\u0011\ti!a\u0007\t\r\u0005UA\u00021\u0001`\u0003!A\u0017m\u001d5D_\u0012,GCAA\u0011!\ra\u00131E\u0005\u0004\u0003K9#aA%oi\u0006AAo\\*ue&tw\r\u0006\u0002\u0002,A!\u0011QFA\u001c\u001b\t\tyC\u0003\u0003\u00022\u0005M\u0012\u0001\u00027b]\u001eT!!!\u000e\u0002\t)\fg/Y\u0005\u0005\u0003s\tyC\u0001\u0004TiJLgnZ\u0001\u0005\u000bb\u0004(\u000f\u0005\u0002A!M\u0019\u0001c\u000b\u001e\u0002\rqJg.\u001b;?)\t\ti$A\u0003baBd\u00170\u0006\u0003\u0002J\u0005ECCBA&\u0003C\n)\u0007\u0006\u0003\u0002N\u0005M\u0003\u0003\u0002!\u0003\u0003\u001f\u00022ASA)\t\u0015i&C1\u0001_\u0011%\t)FEA\u0001\u0002\b\t9&\u0001\u0006fm&$WM\\2fIE\u0002R\u0001QA-\u0003\u001fJA!a\u0017\u0002^\tYq+Z1l)f\u0004X\rV1h\u0013\r\tyf\t\u0002\t)f\u0004X\rV1hg\"1QH\u0005a\u0001\u0003G\u00022!V3A\u0011\u001d\t9G\u0005a\u0001\u0003S\nQ\u0001\u001e:fK\u000e\u00042!VA6\u0013\r\tig\t\u0002\f)J,Wm\u0011:fCR|'/A\u0004v]\u0006\u0004\b\u000f\\=\u0016\t\u0005M\u00141\u0011\u000b\u0005\u0003k\nY\b\u0005\u0003-\u0003oB\u0017bAA=O\t1q\n\u001d;j_:Dq!! \u0014\u0001\u0004\ty(\u0001\u0003fqB\u0014\b\u0003\u0002!\u0003\u0003\u0003\u00032ASAB\t\u0015i6C1\u0001_\u0005!)\u0005\u0010\u001d:J[BdW\u0003BAE\u0003\u001f\u001bB\u0001F\u0016\u0002\fB!\u0001IAAG!\rQ\u0015q\u0012\u0003\u0007;R!)\u0019\u00010\u0002\u000f5L'O]8sAU\u0011\u0011\u0011N\u0001\u0007iJ,Wm\u0019\u0011\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$#\u0007E\u0003A\u00033\ni\t\u0006\u0004\u0002\u001e\u0006\r\u0016Q\u0015\u000b\u0005\u0003?\u000b\t\u000b\u0005\u0003A)\u00055\u0005bBAL5\u0001\u000f\u0011\u0011\u0014\u0005\u0006{i\u0001\ra\u0010\u0005\b\u0003OR\u0002\u0019AA5+\u0011\tI+a,\u0015\t\u0005-\u0016q\u0017\t\u0006\u0003[\u0013\u0011Q\u0012\t\u0004\u0015\u0006=FA\u0002'\u001c\u0005\u0004\t\t,E\u0002O\u0003g\u0013B!!.U1\u001a)1\u000b\u0006\u0001\u00024\"11m\u0007a\u0001\u0003s\u0003B!V3\u0002.V\u0011\u0011QR\u0001\roJLG/\u001a*fa2\f7-\u001a\u000b\u0002W!*\u0011%a1\u0002VB)A&!2\u0002J&\u0019\u0011qY\u0014\u0003\rQD'o\\<t!\u0011\tY-!5\u000e\u0005\u00055'\u0002BAh\u0003g\t!![8\n\t\u0005M\u0017Q\u001a\u0002\u0016\u001f\nTWm\u0019;TiJ,\u0017-\\#yG\u0016\u0004H/[8oG\t\tI\r")
public interface Exprs {
    public Exprs$Expr$ Expr();

    public static void $init$(Exprs $this) {
    }

    public interface Expr<T>
    extends Equals,
    Serializable {
        public Mirror mirror();

        public <U extends Universe> Expr<T> in(Mirror<U> var1);

        public Trees.TreeApi tree();

        public Types.TypeApi staticType();

        public Types.TypeApi actualType();

        public T splice();

        public T value();

        @Override
        default public boolean canEqual(Object x) {
            return x instanceof Expr;
        }

        @Override
        default public boolean equals(Object x) {
            if (x instanceof Expr) {
                Mirror mirror = this.mirror();
                Mirror mirror2 = ((Expr)x).mirror();
                if (!(mirror != null ? !mirror.equals(mirror2) : mirror2 != null)) {
                    Trees.TreeApi treeApi = this.tree();
                    Trees.TreeApi treeApi2 = ((Expr)x).tree();
                    if (!(treeApi != null ? !treeApi.equals(treeApi2) : treeApi2 != null)) {
                        return true;
                    }
                }
            }
            return false;
        }

        default public int hashCode() {
            return this.mirror().hashCode() * 31 + this.tree().hashCode();
        }

        default public String toString() {
            return new StringBuilder(8).append("Expr[").append(this.staticType()).append("](").append(this.tree()).append(")").toString();
        }

        public /* synthetic */ Exprs scala$reflect$api$Exprs$Expr$$$outer();

        public static void $init$(Expr $this) {
        }
    }

    private class ExprImpl<T>
    implements Expr<T> {
        private Trees.TreeApi tree;
        private Types.TypeApi staticType;
        private T value;
        private final Mirror mirror;
        private final TreeCreator treec;
        private final TypeTags.WeakTypeTag<T> evidence$2;
        private volatile byte bitmap$0;
        public final /* synthetic */ Universe $outer;

        @Override
        public boolean canEqual(Object x) {
            return ((Expr)this).canEqual(x);
        }

        @Override
        public boolean equals(Object x) {
            return ((Expr)this).equals(x);
        }

        @Override
        public int hashCode() {
            return ((Expr)this).hashCode();
        }

        @Override
        public String toString() {
            return ((Expr)this).toString();
        }

        @Override
        public Mirror mirror() {
            return this.mirror;
        }

        public TreeCreator treec() {
            return this.treec;
        }

        @Override
        public <U extends Universe> Expr<T> in(Mirror<U> otherMirror) {
            TypeTags.WeakTypeTag<T> weakTypeTag = this.evidence$2;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            TypeTags.WeakTypeTag<T> tag1 = weakTypeTag.in(otherMirror);
            return ((Universe)otherMirror.universe()).Expr().apply(otherMirror, this.treec(), tag1);
        }

        private Trees.TreeApi tree$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 1) == 0) {
                    this.tree = this.treec().apply(this.mirror());
                    this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                }
            }
            return this.tree;
        }

        @Override
        public Trees.TreeApi tree() {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                return this.tree$lzycompute();
            }
            return this.tree;
        }

        private Types.TypeApi staticType$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 2) == 0) {
                    TypeTags.WeakTypeTag<T> weakTypeTag = this.evidence$2;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    this.staticType = weakTypeTag.tpe();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                }
            }
            return this.staticType;
        }

        @Override
        public Types.TypeApi staticType() {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                return this.staticType$lzycompute();
            }
            return this.staticType;
        }

        @Override
        public Types.TypeApi actualType() {
            return this.tree().tpe();
        }

        @Override
        public T splice() {
            String string = "\n      |the function you're calling has not been spliced by the compiler.\n      |this means there is a cross-stage evaluation involved, and it needs to be invoked explicitly.\n      |if you're sure this is not an oversight, add scala-compiler.jar to the classpath,\n      |import `scala.tools.reflect.Eval` and call `<your expr>.eval` instead.".trim();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            throw new UnsupportedOperationException(new StringOps(string).stripMargin());
        }

        private T value$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 4) == 0) {
                    ExprImpl exprImpl = this;
                    String string = "\n      |the value you're calling is only meant to be used in cross-stage path-dependent types.\n      |if you want to splice the underlying expression, use `<your expr>.splice`.\n      |if you want to get a value of the underlying expression, add scala-compiler.jar to the classpath,\n      |import `scala.tools.reflect.Eval` and call `<your expr>.eval` instead.".trim();
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    throw new UnsupportedOperationException(new StringOps(string).stripMargin());
                }
            }
            return this.value;
        }

        @Override
        public T value() {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                return this.value$lzycompute();
            }
            return this.value;
        }

        private Object writeReplace() throws ObjectStreamException {
            TypeTags.WeakTypeTag<T> weakTypeTag = this.evidence$2;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new SerializedExpr(this.treec(), weakTypeTag.in(((Mirrors)((Object)package$.MODULE$.universe())).rootMirror()));
        }

        public /* synthetic */ Universe scala$reflect$api$Exprs$ExprImpl$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Exprs scala$reflect$api$Exprs$Expr$$$outer() {
            return this.scala$reflect$api$Exprs$ExprImpl$$$outer();
        }

        public ExprImpl(Universe $outer, Mirror mirror, TreeCreator treec, TypeTags.WeakTypeTag<T> evidence$2) {
            this.mirror = mirror;
            this.treec = treec;
            this.evidence$2 = evidence$2;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Expr.$init$(this);
        }
    }
}

