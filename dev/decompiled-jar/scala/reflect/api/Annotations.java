/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.Option;
import scala.Tuple3;
import scala.collection.immutable.List;
import scala.collection.immutable.ListMap;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Constants;
import scala.reflect.api.Names;
import scala.reflect.api.Trees;
import scala.reflect.api.Types;
import scala.reflect.api.Universe;

@ScalaSignature(bytes="\u0006\u0001\t]a!C\u0016-!\u0003\r\ta\rB\b\u0011\u0015A\u0004\u0001\"\u0001:\t\u0015i\u0004A!\u0001?\u0011%\ty\u0001\u0001b\u0001\u000e\u0003\t\tBB\u0004\u0002\u0016\u0001\t\t!a\u0006\t\u000f\u0005eA\u0001\"\u0001\u0002\u001c!9\u0011Q\u0004\u0003\u0005\u0002\u0005}\u0001bBA\u000f\t\u0019\u0005\u0011Q\u0005\u0005\b\u0003g!a\u0011AA\u001b\r\u001d9\u0005\u0001%A\u0002\u0002!CQ\u0001O\u0005\u0005\u0002eBQ!S\u0005\u0005\u0002)CQ\u0001U\u0005\u0007\u0002ECQaX\u0005\u0007\u0002\u0001DQa[\u0005\u0007\u00021D\u0001\"!\u0013\u0001\r#\u0001\u00141\n\u0005\t\u0003\u001f\u0002a\u0011\u0003\u0019\u0002R\u0011)1\u0010\u0001B\u0001y\u001aI\u0011\u0011\u0001\u0001\u0011\u0002G\u0005\u00111\u0001\u0003\b\u0003+\u0002!\u0011AA,\u0011%\t9\b\u0001b\u0001\u000e\u0003\tIHB\u0004\u0002~\u0001\t\t!a \t\u000f\u0005eQ\u0003\"\u0001\u0002\u0002\"9\u0011QD\u000b\u0007\u0002\u0005\r\u0005bBA\u001a+\u0019\u0005\u00111\u0012\u0004\n\u0003?\u0002\u0001\u0013aI\u0001\u0003CBq!a\u0019\u001a\r\u0003\t)\u0007B\u0004\u0002\u001a\u0002\u0011\t!a'\t\u0013\u0005]\u0006A1A\u0007\u0002\u0005efaBA_\u0001\u0005\u0005\u0011q\u0018\u0005\b\u00033iB\u0011AAa\u0011\u001d\ti\"\bD\u0001\u0003\u0007Dq!a\r\u001e\r\u0003\tYMB\u0005\u0002$\u0002\u0001\n1%\u0001\u0002&\"9\u0011qU\u0011\u0007\u0002\u0005%FaBAl\u0001\t\u0005\u0011\u0011\u001c\u0005\n\u0003_\u0004!\u0019!D\u0001\u0003c4q!!>\u0001\u0003\u0003\t9\u0010C\u0004\u0002\u001a\u0015\"\t!!?\t\u000f\u0005uQE\"\u0001\u0002|\"9\u00111G\u0013\u0007\u0002\t\ra!CAq\u0001A\u0005\u0019\u0013AAr\u0011\u001d\t)/\u000bD\u0001\u0003O\u00141\"\u00118o_R\fG/[8og*\u0011QFL\u0001\u0004CBL'BA\u00181\u0003\u001d\u0011XM\u001a7fGRT\u0011!M\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001A\u0007\u0005\u00026m5\t\u0001'\u0003\u00028a\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$C#\u0001\u001e\u0011\u0005UZ\u0014B\u0001\u001f1\u0005\u0011)f.\u001b;\u0003\u0015\u0005sgn\u001c;bi&|g.\u0005\u0002@\u0005B\u0011Q\u0007Q\u0005\u0003\u0003B\u0012AAT;mYJ\u00191\tN#\u0007\t\u0011\u0003\u0001A\u0011\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0003\r&i\u0011\u0001\u0001\u0002\u000e\u0003:tw\u000e^1uS>t\u0017\t]5\u0014\u0005%!\u0014\u0001\u0002;sK\u0016,\u0012a\u0013\t\u0003\r2K!!\u0014(\u0003\tQ\u0013X-Z\u0005\u0003\u001f2\u0012Q\u0001\u0016:fKN\f1\u0001\u001e9f+\u0005\u0011\u0006C\u0001$T\u0013\t!VK\u0001\u0003UsB,\u0017B\u0001,-\u0005\u0015!\u0016\u0010]3tQ\u0011a\u0001lW/\u0011\u0005UJ\u0016B\u0001.1\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u00029\u00061Ro]3!AR\u0014X-\u001a\u0018ua\u0016\u0004\u0007%\u001b8ti\u0016\fG-I\u0001_\u0003\u0019\u0011d&M\u0019/a\u0005I1oY1mC\u0006\u0013xm]\u000b\u0002CB\u0019!-Z&\u000f\u0005U\u001a\u0017B\u000131\u0003\u001d\u0001\u0018mY6bO\u0016L!AZ4\u0003\t1K7\u000f\u001e\u0006\u0003IBBC!\u0004-j;\u0006\n!.\u0001\u0011vg\u0016\u0004\u0003\r\u001e:fK:\u001a\u0007.\u001b7ee\u0016tg\u0006^1jY\u0002\u0004\u0013N\\:uK\u0006$\u0017\u0001\u00036bm\u0006\f%oZ:\u0016\u00035\u0004BA\\:vu6\tqN\u0003\u0002qc\u0006I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u0003eB\n!bY8mY\u0016\u001cG/[8o\u0013\t!xNA\u0004MSN$X*\u00199\u0011\u0005\u00193\u0018BA<y\u0005\u0011q\u0015-\\3\n\u0005ed#!\u0002(b[\u0016\u001c\bC\u0001$\u0012\u00051Q\u0015M^1Be\u001e,X.\u001a8u#\tyTPE\u0002\u007fi}4A\u0001\u0012\u0001\u0001{B\u0011aI\u0005\u0002\u0010\u0015\u00064\u0018-\u0011:hk6,g\u000e^!qSN\u0011!\u0003\u000e\u0015\u0006%a\u000b9!X\u0011\u0003\u0003\u0013\tQ'^:fA\u0001\feN\\8uCRLwN\u001c\u0018ue\u0016,\u0007\r\t;pA%t7\u000f]3di\u0002\ngN\\8uCRLwN\u001c\u0011be\u001e,X.\u001a8ug\"*\u0011\u0003WA\u0004;\"\"a\u0002W5^\u0003)\teN\\8uCRLwN\\\u000b\u0003\u0003'\u0001\"A\u0012\u0003\u0003'\u0005sgn\u001c;bi&|g.\u0012=ue\u0006\u001cGo\u001c:\u0014\u0005\u0011!\u0014A\u0002\u001fj]&$h\b\u0006\u0002\u0002\u0014\u0005)\u0011\r\u001d9msR!\u0011\u0011EA\u0012!\t1%\u0001C\u0003J\r\u0001\u00071\n\u0006\u0005\u0002\"\u0005\u001d\u0012\u0011FA\u0016\u0011\u0015\u0001v\u00011\u0001S\u0011\u0015yv\u00011\u0001b\u0011\u0015Yw\u00011\u0001nQ\u00159\u0001,a\f^C\t\t\t$A\u0016vg\u0016\u0004\u0003-\u00199qYfDCO]3fu\u0001\"&/Z3*u\u0001\neN\\8uCRLwN\u001c1!S:\u001cH/Z1e\u0003\u001d)h.\u00199qYf$B!a\u000e\u0002DA)Q'!\u000f\u0002>%\u0019\u00111\b\u0019\u0003\r=\u0003H/[8o!\u0019)\u0014q\b*b[&\u0019\u0011\u0011\t\u0019\u0003\rQ+\b\u000f\\34\u0011\u001d\t)\u0005\u0003a\u0001\u0003C\t1!\u00198oQ\u0015A\u0001,a\u0002^\u0003A\tgN\\8uCRLwN\u001c+p)J,W\rF\u0002L\u0003\u001bBq!!\u0012\u0010\u0001\u0004\t\t#\u0001\tue\u0016,Gk\\!o]>$\u0018\r^5p]R!\u0011\u0011EA*\u0011\u0015I\u0005\u00031\u0001L\u0005=a\u0015\u000e^3sC2\f%oZ;nK:$\u0018cA \u0002ZI)\u00111LA/u\u001a)A\t\u0001\u0001\u0002ZA\u0011a)\u0007\u0002\u0013\u0019&$XM]1m\u0003J<W/\\3oi\u0006\u0003\u0018n\u0005\u0002\u001ai\u0005)a/\u00197vKV\u0011\u0011q\r\t\u0004\r\u0006%\u0014\u0002BA6\u0003[\u0012\u0001bQ8ogR\fg\u000e^\u0005\u0004\u0003_b#!C\"p]N$\u0018M\u001c;tQ\u0015Q\u0002,a\u0002^Q\u0015I\u0002,a\u0002^Q\u0015\u0019\u0002,a\u0002^\u0003=a\u0015\u000e^3sC2\f%oZ;nK:$XCAA>!\t1UC\u0001\rMSR,'/\u00197Be\u001e,X.\u001a8u\u000bb$(/Y2u_J\u001c\"!\u0006\u001b\u0015\u0005\u0005mD\u0003BAC\u0003\u000f\u0003\"AR\n\t\u000f\u0005\rt\u00031\u0001\u0002h!*q\u0003WA\u0004;R!\u0011QRAH!\u0015)\u0014\u0011HA4\u0011\u001d\t\t\n\u0007a\u0001\u0003\u000b\u000b1!\u0019:hQ\u0015A\u0002,a\u0002^Q\u0015)\u0002,a\u0002^Q\u0015!\u0002,a\u0002^\u00055\t%O]1z\u0003J<W/\\3oiF\u0019q(!(\u0013\u000b\u0005}\u0015\u0011\u0015>\u0007\u000b\u0011\u0003\u0001!!(\u0011\u0005\u0019\u000b#\u0001E!se\u0006L\u0018I]4v[\u0016tG/\u00119j'\t\tC'\u0001\u0003be\u001e\u001cXCAAV!\u0011)\u0014Q\u0016>\n\u0007\u0005=\u0006GA\u0003BeJ\f\u0017\u0010K\u0003#1\u0006\u001dQ\fK\u0003\"1\u0006\u001dQ\fK\u0003\u001c1\u0006\u001dQ,A\u0007BeJ\f\u00170\u0011:hk6,g\u000e^\u000b\u0003\u0003w\u0003\"AR\u000f\u0003-\u0005\u0013(/Y=Be\u001e,X.\u001a8u\u000bb$(/Y2u_J\u001c\"!\b\u001b\u0015\u0005\u0005mF\u0003BAc\u0003\u000f\u0004\"AR\u000e\t\u000f\u0005\u001dv\u00041\u0001\u0002,\"*q\u0004WA\u0004;R!\u0011QZAh!\u0015)\u0014\u0011HAV\u0011\u001d\t\t\n\ta\u0001\u0003\u000bDS\u0001\t-\u0002\buCS!\b-\u0002\buCS\u0001\b-\u0002\bu\u0013aBT3ti\u0016$\u0017I]4v[\u0016tG/E\u0002@\u00037\u0014R!!8\u0002`j4Q\u0001\u0012\u0001\u0001\u00037\u0004\"AR\u0015\u0003#9+7\u000f^3e\u0003J<W/\\3oi\u0006\u0003\u0018n\u0005\u0002*i\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\u0016\u0005\u0005\u0005\u0002&\u0002\u0016Y\u0003\u000fi\u0006&B\u0015Y\u0003\u000fi\u0006&B\u0012Y\u0003\u000fi\u0016A\u0004(fgR,G-\u0011:hk6,g\u000e^\u000b\u0003\u0003g\u0004\"AR\u0013\u0003/9+7\u000f^3e\u0003J<W/\\3oi\u0016CHO]1di>\u00148CA\u00135)\t\t\u0019\u0010\u0006\u0003\u0002~\u0006}\bC\u0001$$\u0011\u001d\t)o\na\u0001\u0003CASa\n-\u0002\bu#BA!\u0002\u0003\bA)Q'!\u000f\u0002\"!9\u0011\u0011\u0013\u0015A\u0002\u0005u\b&\u0002\u0015Y\u0003\u000fi\u0006&B\u0013Y\u0003\u000fi\u0006&\u0002\u0013Y\u0003\u000fi\u0006\u0003\u0002B\t\u0005'i\u0011\u0001L\u0005\u0004\u0005+a#\u0001C+oSZ,'o]3")
public interface Annotations {
    public AnnotationExtractor Annotation();

    public Trees.TreeApi annotationToTree(AnnotationApi var1);

    public AnnotationApi treeToAnnotation(Trees.TreeApi var1);

    public LiteralArgumentExtractor LiteralArgument();

    public ArrayArgumentExtractor ArrayArgument();

    public NestedArgumentExtractor NestedArgument();

    public static void $init$(Annotations $this) {
    }

    public interface AnnotationApi {
        public static /* synthetic */ Trees.TreeApi tree$(AnnotationApi $this) {
            return $this.tree();
        }

        default public Trees.TreeApi tree() {
            return this.scala$reflect$api$Annotations$AnnotationApi$$$outer().annotationToTree(this);
        }

        public Types.TypeApi tpe();

        public List<Trees.TreeApi> scalaArgs();

        public ListMap<Names.NameApi, JavaArgumentApi> javaArgs();

        public /* synthetic */ Annotations scala$reflect$api$Annotations$AnnotationApi$$$outer();

        public static void $init$(AnnotationApi $this) {
        }
    }

    public static abstract class AnnotationExtractor {
        public final /* synthetic */ Universe $outer;

        public AnnotationApi apply(Trees.TreeApi tree) {
            return this.scala$reflect$api$Annotations$AnnotationExtractor$$$outer().treeToAnnotation(tree);
        }

        public abstract AnnotationApi apply(Types.TypeApi var1, List<Trees.TreeApi> var2, ListMap<Names.NameApi, JavaArgumentApi> var3);

        public abstract Option<Tuple3<Types.TypeApi, List<Trees.TreeApi>, ListMap<Names.NameApi, JavaArgumentApi>>> unapply(AnnotationApi var1);

        public /* synthetic */ Universe scala$reflect$api$Annotations$AnnotationExtractor$$$outer() {
            return this.$outer;
        }

        public AnnotationExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface ArrayArgumentApi {
        public JavaArgumentApi[] args();
    }

    public static abstract class ArrayArgumentExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract ArrayArgumentApi apply(JavaArgumentApi[] var1);

        public abstract Option<JavaArgumentApi[]> unapply(ArrayArgumentApi var1);

        public /* synthetic */ Universe scala$reflect$api$Annotations$ArrayArgumentExtractor$$$outer() {
            return this.$outer;
        }

        public ArrayArgumentExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface JavaArgumentApi {
    }

    public interface LiteralArgumentApi {
        public Constants.ConstantApi value();
    }

    public static abstract class LiteralArgumentExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract LiteralArgumentApi apply(Constants.ConstantApi var1);

        public abstract Option<Constants.ConstantApi> unapply(LiteralArgumentApi var1);

        public /* synthetic */ Universe scala$reflect$api$Annotations$LiteralArgumentExtractor$$$outer() {
            return this.$outer;
        }

        public LiteralArgumentExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public interface NestedArgumentApi {
        public AnnotationApi annotation();
    }

    public static abstract class NestedArgumentExtractor {
        public final /* synthetic */ Universe $outer;

        public abstract NestedArgumentApi apply(AnnotationApi var1);

        public abstract Option<AnnotationApi> unapply(NestedArgumentApi var1);

        public /* synthetic */ Universe scala$reflect$api$Annotations$NestedArgumentExtractor$$$outer() {
            return this.$outer;
        }

        public NestedArgumentExtractor(Universe $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

