/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.collection.immutable.List;
import scala.math.Ordered;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Depth$;
import scala.reflect.internal.DepthFunction;

@ScalaSignature(bytes="\u0006\u0001\u0005ue\u0001B\u0014)\u0005=B\u0001\"\u0010\u0001\u0003\u0006\u0004%\tA\u0010\u0005\t\u0005\u0002\u0011\t\u0011)A\u0005\u007f!a1\t\u0001C\u0001\u0002\u0003\u0005\t\u0011!C\u0005\t\")a\t\u0001C\u0001\u000f\")!\n\u0001C\u0001\u0017\")a\n\u0001C\u0001\u001f\")!\n\u0001C\u0001#\")a\n\u0001C\u0001#\")!\u000b\u0001C\u0001'\")q\u000b\u0001C\u0001'\")\u0001\f\u0001C\u0001'\")\u0011\f\u0001C\u00015\")A\f\u0001C!;\"9\u0011\u000eAA\u0001\n\u0003R\u0007bB6\u0001\u0003\u0003%\t\u0005\\\u0004\u0006e\"B\ta\u001d\u0004\u0006O!B\t\u0001\u001e\u0005\u0006\u0007F!\t\u0001\u001f\u0005\bsF\u0011\r\u0011\"\u0002{\u0011\u0019i\u0018\u0003)A\u0007w\"9a0\u0005b\u0001\n\u000b\t\u0006BB@\u0012A\u000351\b\u0003\u0005\u0002\u0002E\u0011\r\u0011\"\u0002R\u0011\u001d\t\u0019!\u0005Q\u0001\u000emBq!!\u0002\u0012\t\u000b\t9\u0001C\u0004\u0002\u0014E!\t!!\u0006\t\u000f\u0005}\u0012\u0003\"\u0002\u0002B!9\u00111J\t\u0005\u0006\u00055\u0003bBA+#\u0011\u0015\u0011q\u000b\u0005\b\u0003?\nBQAA1\u0011\u001d\t)'\u0005C\u0003\u0003OBq!a\u001b\u0012\t\u000b\ti\u0007C\u0004\u0002rE!)!a\u001d\t\u000f\u0005]\u0014\u0003\"\u0002\u0002z!9\u0011QP\t\u0005\u0006\u0005}\u0004bBAD#\u0011\u0015\u0011\u0011\u0012\u0005\n\u0003\u001b\u000b\u0012\u0011!C\u0003\u0003\u001fC\u0011\"a%\u0012\u0003\u0003%)!!&\u0003\u000b\u0011+\u0007\u000f\u001e5\u000b\u0005%R\u0013\u0001C5oi\u0016\u0014h.\u00197\u000b\u0005-b\u0013a\u0002:fM2,7\r\u001e\u0006\u0002[\u0005)1oY1mC\u000e\u00011c\u0001\u00011iA\u0011\u0011GM\u0007\u0002Y%\u00111\u0007\f\u0002\u0007\u0003:Lh+\u00197\u0011\u0007UB4H\u0004\u00022m%\u0011q\u0007L\u0001\ba\u0006\u001c7.Y4f\u0013\tI$HA\u0004Pe\u0012,'/\u001a3\u000b\u0005]b\u0003C\u0001\u001f\u0001\u001b\u0005A\u0013!\u00023faRDW#A \u0011\u0005E\u0002\u0015BA!-\u0005\rIe\u000e^\u0001\u0007I\u0016\u0004H\u000f\u001b\u0011\u0002\rqJg.\u001b;?)\tYT\tC\u0003>\u0007\u0001\u0007q(A\u0002nCb$\"a\u000f%\t\u000b%#\u0001\u0019A\u001e\u0002\tQD\u0017\r^\u0001\u0005I\u0016\u001c'\u000f\u0006\u0002<\u0019\")Q*\u0002a\u0001\u007f\u0005\ta.\u0001\u0003j]\u000e\u0014HCA\u001eQ\u0011\u0015ie\u00011\u0001@+\u0005Y\u0014AC5t\u001d\u0016<\u0017\r^5wKV\tA\u000b\u0005\u00022+&\u0011a\u000b\f\u0002\b\u0005>|G.Z1o\u0003\u0019I7OW3s_\u0006Q\u0011n]!os\u0012+\u0007\u000f\u001e5\u0002\u000f\r|W\u000e]1sKR\u0011qh\u0017\u0005\u0006\u00132\u0001\raO\u0001\ti>\u001cFO]5oOR\ta\f\u0005\u0002`M:\u0011\u0001\r\u001a\t\u0003C2j\u0011A\u0019\u0006\u0003G:\na\u0001\u0010:p_Rt\u0014BA3-\u0003\u0019\u0001&/\u001a3fM&\u0011q\r\u001b\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005\u0015d\u0013\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0003}\na!Z9vC2\u001cHC\u0001+n\u0011\u001dqw\"!AA\u0002=\f1\u0001\u001f\u00132!\t\t\u0004/\u0003\u0002rY\t\u0019\u0011I\\=\u0002\u000b\u0011+\u0007\u000f\u001e5\u0011\u0005q\n2CA\tv!\t\td/\u0003\u0002xY\t1\u0011I\\=SK\u001a$\u0012a]\u0001\u000e\u0003:LH)\u001a9uQZ\u000bG.^3\u0016\u0003m|\u0011\u0001`\u000f\u0002{\bq\u0011I\\=EKB$\bNV1mk\u0016\u0004\u0013\u0001C!os\u0012+\u0007\u000f\u001e5\u0002\u0013\u0005s\u0017\u0010R3qi\"\u0004\u0013\u0001\u0002.fe>\fQAW3s_\u0002\nQ!\u00199qYf$2aOA\u0005\u0011\u0015i\u0014\u00041\u0001@Q\rI\u0012Q\u0002\t\u0004c\u0005=\u0011bAA\tY\t1\u0011N\u001c7j]\u0016\f\u0011\"\\1yS6,XNQ=\u0016\t\u0005]\u0011\u0011\u0006\u000b\u0005\u00033\t)\u0004F\u0002<\u00037Aq!!\b\u001b\u0001\u0004\ty\"\u0001\u0002gMB)A(!\t\u0002&%\u0019\u00111\u0005\u0015\u0003\u001b\u0011+\u0007\u000f\u001e5Gk:\u001cG/[8o!\u0011\t9#!\u000b\r\u0001\u00119\u00111\u0006\u000eC\u0002\u00055\"!A!\u0012\u0007\u0005=r\u000eE\u00022\u0003cI1!a\r-\u0005\u001dqu\u000e\u001e5j]\u001eDq!a\u000e\u001b\u0001\u0004\tI$\u0001\u0002ygB)Q'a\u000f\u0002&%\u0019\u0011Q\b\u001e\u0003\t1K7\u000f^\u0001\u000e[\u0006DH%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u0005\r\u0013q\t\u000b\u0004w\u0005\u0015\u0003\"B%\u001c\u0001\u0004Y\u0004BBA%7\u0001\u00071(A\u0003%i\"L7/A\beK\u000e\u0014H%\u001a=uK:\u001c\u0018n\u001c81)\u0011\ty%a\u0015\u0015\u0007m\n\t\u0006C\u0003N9\u0001\u0007q\b\u0003\u0004\u0002Jq\u0001\raO\u0001\u0010S:\u001c'\u000fJ3yi\u0016t7/[8oaQ!\u0011\u0011LA/)\rY\u00141\f\u0005\u0006\u001bv\u0001\ra\u0010\u0005\u0007\u0003\u0013j\u0002\u0019A\u001e\u0002\u001f\u0011,7M\u001d\u0013fqR,gn]5p]F\"2aOA2\u0011\u0019\tIE\ba\u0001w\u0005y\u0011N\\2sI\u0015DH/\u001a8tS>t\u0017\u0007F\u0002<\u0003SBa!!\u0013 \u0001\u0004Y\u0014\u0001F5t\u001d\u0016<\u0017\r^5wK\u0012*\u0007\u0010^3og&|g\u000eF\u0002U\u0003_Ba!!\u0013!\u0001\u0004Y\u0014\u0001E5t5\u0016\u0014x\u000eJ3yi\u0016t7/[8o)\r!\u0016Q\u000f\u0005\u0007\u0003\u0013\n\u0003\u0019A\u001e\u0002)%\u001c\u0018I\\=EKB$\b\u000eJ3yi\u0016t7/[8o)\r!\u00161\u0010\u0005\u0007\u0003\u0013\u0012\u0003\u0019A\u001e\u0002#\r|W\u000e]1sK\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0002\u0002\u0006\u0015EcA \u0002\u0004\")\u0011j\ta\u0001w!1\u0011\u0011J\u0012A\u0002m\n!\u0003^8TiJLgn\u001a\u0013fqR,gn]5p]R\u0019Q,a#\t\r\u0005%C\u00051\u0001<\u0003IA\u0017m\u001d5D_\u0012,G%\u001a=uK:\u001c\u0018n\u001c8\u0015\u0007)\f\t\n\u0003\u0004\u0002J\u0015\u0002\raO\u0001\u0011KF,\u0018\r\\:%Kb$XM\\:j_:$B!a&\u0002\u001cR\u0019A+!'\t\u000f94\u0013\u0011!a\u0001_\"1\u0011\u0011\n\u0014A\u0002m\u0002")
public final class Depth
implements Ordered<Depth> {
    private final int depth;

    public static boolean equals$extension(int n, Object object) {
        return Depth$.MODULE$.equals$extension(n, object);
    }

    public static int hashCode$extension(int n) {
        return Depth$.MODULE$.hashCode$extension(n);
    }

    public static String toString$extension(int n) {
        return Depth$.MODULE$.toString$extension(n);
    }

    public static int compare$extension(int n, int n2) {
        return Depth$.MODULE$.compare$extension(n, n2);
    }

    public static boolean isAnyDepth$extension(int n) {
        return Depth$.MODULE$.isAnyDepth$extension(n);
    }

    public static boolean isZero$extension(int n) {
        return Depth$.MODULE$.isZero$extension(n);
    }

    public static boolean isNegative$extension(int n) {
        return Depth$.MODULE$.isNegative$extension(n);
    }

    public static int incr$extension1(int n) {
        return Depth$.MODULE$.incr$extension1(n);
    }

    public static int decr$extension1(int n) {
        return Depth$.MODULE$.decr$extension1(n);
    }

    public static int incr$extension0(int n, int n2) {
        return Depth$.MODULE$.incr$extension0(n, n2);
    }

    public static int decr$extension0(int n, int n2) {
        return Depth$.MODULE$.decr$extension0(n, n2);
    }

    public static int max$extension(int n, int n2) {
        return Depth$.MODULE$.max$extension(n, n2);
    }

    public static int maximumBy(List list, DepthFunction depthFunction) {
        return Depth$.MODULE$.maximumBy(list, depthFunction);
    }

    public static int apply(int n) {
        Depth$ depth$ = Depth$.MODULE$;
        if (depth$ == null) {
            throw null;
        }
        Depth$ apply_this = depth$;
        if (n < -3) {
            return apply_this.AnyDepth();
        }
        return n;
    }

    public static int Zero() {
        return Depth$.MODULE$.Zero();
    }

    public static int AnyDepth() {
        return Depth$.MODULE$.AnyDepth();
    }

    public static int AnyDepthValue() {
        return Depth$.MODULE$.AnyDepthValue();
    }

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    public int depth() {
        return this.depth;
    }

    public int max(int that) {
        return Depth$.MODULE$.max$extension(this.depth(), that);
    }

    public int decr(int n) {
        return Depth$.MODULE$.decr$extension0(this.depth(), n);
    }

    public int incr(int n) {
        return Depth$.MODULE$.incr$extension0(this.depth(), n);
    }

    public int decr() {
        return Depth$.MODULE$.decr$extension1(this.depth());
    }

    public int incr() {
        return Depth$.MODULE$.incr$extension1(this.depth());
    }

    public boolean isNegative() {
        return Depth$.MODULE$.isNegative$extension(this.depth());
    }

    public boolean isZero() {
        return Depth$.MODULE$.isZero$extension(this.depth());
    }

    public boolean isAnyDepth() {
        return Depth$.MODULE$.isAnyDepth$extension(this.depth());
    }

    @Override
    public int compare(int that) {
        return Depth$.MODULE$.compare$extension(this.depth(), that);
    }

    public String toString() {
        return Depth$.MODULE$.toString$extension(this.depth());
    }

    public int hashCode() {
        return Depth$.MODULE$.hashCode$extension(this.depth());
    }

    public boolean equals(Object x$1) {
        return Depth$.MODULE$.equals$extension(this.depth(), x$1);
    }

    public Depth(int depth) {
        this.depth = depth;
        Ordered.$init$(this);
    }
}

