/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.reflect.ScalaSignature;
import scala.reflect.api.Exprs;
import scala.runtime.BoxedUnit;
import scala.runtime.Null$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ma!\u0003\b\u0010!\u0003\r\nAFA\u0004\u0011\u0015Y\u0002A\"\u0001\u001d\u0011\u0015q\u0003A\"\u00010\u0011\u0015)\u0004A\"\u00017\u0011\u0015a\u0004A\"\u00017\u0011\u0015q\u0004A\"\u0001@\u0011\u0015q\u0004A\"\u0001D\u0011\u0015q\u0004A\"\u0001K\u0011\u0015q\u0004A\"\u0001R\u0011\u0015q\u0004A\"\u0001Y\u0011\u0015q\u0004A\"\u0001`\u0011\u0015q\u0004A\"\u0001g\u0011\u0015q\u0004A\"\u0001n\u0011\u0015q\u0004A\"\u0001}\u0005%)\u0005\u0010\u001d:Vi&d7O\u0003\u0002\u0011#\u00051Q.Y2s_NT!AE\n\u0002\u000fI,g\r\\3di*\tA#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u00019\u0002C\u0001\r\u001a\u001b\u0005\u0019\u0012B\u0001\u000e\u0014\u0005\u0019\te.\u001f*fM\u0006YA.\u001b;fe\u0006dg*\u001e7m+\u0005i\u0002c\u0001\u0010 G5\t\u0001!\u0003\u0002!C\t!Q\t\u001f9s\u0013\t\u0011sBA\u0004BY&\f7/Z:\u0011\u0005a!\u0013BA\u0013\u0014\u0005\u0011qU\u000f\u001c7)\t\u00059#\u0006\f\t\u00031!J!!K\n\u0003\u0015\u0011,\u0007O]3dCR,G-I\u0001,\u0003])8/\u001a\u0011rk\u0006\u001c\u0018.];pi\u0016\u001c\b%\u001b8ti\u0016\fG-I\u0001.\u0003\u0019\u0011d&M\u0019/a\u0005YA.\u001b;fe\u0006dWK\\5u+\u0005\u0001\u0004c\u0001\u0010 cA\u0011\u0001DM\u0005\u0003gM\u0011A!\u00168ji\"\"!a\n\u0016-\u0003-a\u0017\u000e^3sC2$&/^3\u0016\u0003]\u00022AH\u00109!\tA\u0012(\u0003\u0002;'\t9!i\\8mK\u0006t\u0007\u0006B\u0002(U1\nA\u0002\\5uKJ\fGNR1mg\u0016DC\u0001B\u0014+Y\u00059A.\u001b;fe\u0006dGCA\u001cA\u0011\u0015\tU\u00011\u00019\u0003\u0005A\b\u0006B\u0003(U1\"\"\u0001\u0012%\u0011\u0007yyR\t\u0005\u0002\u0019\r&\u0011qi\u0005\u0002\u0005\u0005f$X\rC\u0003B\r\u0001\u0007Q\t\u000b\u0003\u0007O)bCCA&P!\rqr\u0004\u0014\t\u000315K!AT\n\u0003\u000bMCwN\u001d;\t\u000b\u0005;\u0001\u0019\u0001')\t\u001d9#\u0006\f\u000b\u0003%Z\u00032AH\u0010T!\tAB+\u0003\u0002V'\t\u0019\u0011J\u001c;\t\u000b\u0005C\u0001\u0019A*)\t!9#\u0006\f\u000b\u00033v\u00032AH\u0010[!\tA2,\u0003\u0002]'\t!Aj\u001c8h\u0011\u0015\t\u0015\u00021\u0001[Q\u0011IqE\u000b\u0017\u0015\u0005\u0001$\u0007c\u0001\u0010 CB\u0011\u0001DY\u0005\u0003GN\u0011QA\u00127pCRDQ!\u0011\u0006A\u0002\u0005DCAC\u0014+YQ\u0011qm\u001b\t\u0004=}A\u0007C\u0001\rj\u0013\tQ7C\u0001\u0004E_V\u0014G.\u001a\u0005\u0006\u0003.\u0001\r\u0001\u001b\u0015\u0005\u0017\u001dRC\u0006\u0006\u0002ouB\u0019adH8\u0011\u0005A<hBA9v!\t\u00118#D\u0001t\u0015\t!X#\u0001\u0004=e>|GOP\u0005\u0003mN\ta\u0001\u0015:fI\u00164\u0017B\u0001=z\u0005\u0019\u0019FO]5oO*\u0011ao\u0005\u0005\u0006\u00032\u0001\ra\u001c\u0015\u0005\u0019\u001dRC\u0006F\u0002~\u0003\u0007\u00012AH\u0010\u007f!\tAr0C\u0002\u0002\u0002M\u0011Aa\u00115be\")\u0011)\u0004a\u0001}\"\"Qb\n\u0016-!\u0011\tI!a\u0004\u000e\u0005\u0005-!bAA\u0007\u001f\u0005A!\r\\1dW\n|\u00070\u0003\u0003\u0002\u0012\u0005-!aB\"p]R,\u0007\u0010\u001e")
public interface ExprUtils {
    public Exprs.Expr<Null$> literalNull();

    public Exprs.Expr<BoxedUnit> literalUnit();

    public Exprs.Expr<Object> literalTrue();

    public Exprs.Expr<Object> literalFalse();

    public Exprs.Expr<Object> literal(boolean var1);

    public Exprs.Expr<Object> literal(byte var1);

    public Exprs.Expr<Object> literal(short var1);

    public Exprs.Expr<Object> literal(int var1);

    public Exprs.Expr<Object> literal(long var1);

    public Exprs.Expr<Object> literal(float var1);

    public Exprs.Expr<Object> literal(double var1);

    public Exprs.Expr<String> literal(String var1);

    public Exprs.Expr<Object> literal(char var1);
}

