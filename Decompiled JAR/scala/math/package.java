/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.math.package$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005%x!\u0002\u001c8\u0011\u0003ad!\u0002 8\u0011\u0003y\u0004\"\u0002#\u0002\t\u0003)\u0005b\u0002$\u0002\u0005\u0004%)a\u0012\u0005\u0007\u0015\u0006\u0001\u000bQ\u0002%\t\u000f=\u000b!\u0019!C\u0003!\"11+\u0001Q\u0001\u000eECQ!V\u0001\u0005\u0002YCQAW\u0001\u0005\u0002mCQAX\u0001\u0005\u0002}CQ!Y\u0001\u0005\u0002\tDQ\u0001Z\u0001\u0005\u0002\u0015DQaZ\u0001\u0005\u0002!DQA[\u0001\u0005\u0002-DQ!\\\u0001\u0005\u00029DQ\u0001]\u0001\u0005\u0002EDQa]\u0001\u0005\u0002QDQ\u0001_\u0001\u0005\u0002eDQ\u0001`\u0001\u0005\u0002uDaa`\u0001\u0005\u0002\u0005\u0005\u0001bBA\u0003\u0003\u0011\u0005\u0011q\u0001\u0005\b\u0003\u0017\tA\u0011AA\u0007\u0011\u001d\tY!\u0001C\u0001\u0003OAq!a\u0003\u0002\t\u0003\t9\u0004C\u0004\u0002<\u0005!\t!!\u0010\t\u000f\u0005m\u0012\u0001\"\u0001\u0002B!9\u00111H\u0001\u0005\u0002\u0005\u0015\u0003bBA\u001e\u0003\u0011\u0005\u0011\u0011\n\u0005\b\u0003\u001b\nA\u0011AA(\u0011\u001d\ti%\u0001C\u0001\u0003+Bq!!\u0014\u0002\t\u0003\tY\u0006C\u0004\u0002N\u0005!\t!!\u0019\t\u000f\u0005\u001d\u0014\u0001\"\u0001\u0002j!9\u0011qM\u0001\u0005\u0002\u0005=\u0004bBA4\u0003\u0011\u0005\u0011Q\u000f\u0005\b\u0003O\nA\u0011AA>\u0011\u001d\t\t)\u0001C\u0001\u0003\u0007Cq!!!\u0002\t\u0003\t9\tC\u0004\u0002\u0002\u0006!\t!a#\t\u000f\u0005\u0005\u0015\u0001\"\u0001\u0002\u0010\"9\u00111S\u0001\u0005\u0002\u0005U\u0005bBAM\u0003\u0011\u0005\u00111\u0014\u0005\b\u0003?\u000bA\u0011AAQ\u0011\u001d\t9+\u0001C\u0001\u0003SCq!!,\u0002\t\u0003\ty\u000bC\u0004\u00024\u0006!\t!!.\t\u000f\u0005e\u0016\u0001\"\u0001\u0002<\"9\u0011qX\u0001\u0005\u0002\u0005\u0005\u0007bBAc\u0003\u0011\u0005\u0011q\u0019\u0005\b\u0003\u0017\fA\u0011AAg\u0011\u001d\t\t.\u0001C\u0001\u0003'Dq!a6\u0002\t\u0003\tI\u000eC\u0004\u0002X\u0006!\t!!8\t\u000f\u0005\u0005\u0018\u0001\"\u0001\u0002d\u00069\u0001/Y2lC\u001e,'B\u0001\u001d:\u0003\u0011i\u0017\r\u001e5\u000b\u0003i\nQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002>\u00035\tqGA\u0004qC\u000e\\\u0017mZ3\u0014\u0005\u0005\u0001\u0005CA!C\u001b\u0005I\u0014BA\":\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012\u0001P\u0001\u0002\u000bV\t\u0001jD\u0001JA!\u0001Ua0\u0006\f*]K\u0017AA#!Q\t!A\n\u0005\u0002B\u001b&\u0011a*\u000f\u0002\u0007S:d\u0017N\\3\u0002\u0005AKW#A)\u0010\u0003I\u0003\u0003\u0002Q\u0005\"wT#U\u0006G\u0001\u0004!&\u0004\u0003F\u0001\u0004M\u0003\u0019\u0011\u0018M\u001c3p[R\tq\u000b\u0005\u0002B1&\u0011\u0011,\u000f\u0002\u0007\t>,(\r\\3\u0002\u0007MLg\u000e\u0006\u0002X9\")Q\f\u0003a\u0001/\u0006\t\u00010A\u0002d_N$\"a\u00161\t\u000buK\u0001\u0019A,\u0002\u0007Q\fg\u000e\u0006\u0002XG\")QL\u0003a\u0001/\u0006!\u0011m]5o)\t9f\rC\u0003^\u0017\u0001\u0007q+\u0001\u0003bG>\u001cHCA,j\u0011\u0015iF\u00021\u0001X\u0003\u0011\tG/\u00198\u0015\u0005]c\u0007\"B/\u000e\u0001\u00049\u0016!\u0003;p%\u0006$\u0017.\u00198t)\t9v\u000eC\u0003^\u001d\u0001\u0007q+A\u0005u_\u0012+wM]3fgR\u0011qK\u001d\u0005\u0006;>\u0001\raV\u0001\u0006CR\fgN\r\u000b\u0004/V<\b\"\u0002<\u0011\u0001\u00049\u0016!A=\t\u000bu\u0003\u0002\u0019A,\u0002\u000b!L\bo\u001c;\u0015\u0007]S8\u0010C\u0003^#\u0001\u0007q\u000bC\u0003w#\u0001\u0007q+\u0001\u0003dK&dGCA,\u007f\u0011\u0015i&\u00031\u0001X\u0003\u00151Gn\\8s)\r9\u00161\u0001\u0005\u0006;N\u0001\raV\u0001\u0005e&tG\u000fF\u0002X\u0003\u0013AQ!\u0018\u000bA\u0002]\u000bQA]8v]\u0012$B!a\u0004\u0002\u0016A\u0019\u0011)!\u0005\n\u0007\u0005M\u0011H\u0001\u0003M_:<\u0007BB/\u0016\u0001\u0004\ty\u0001K\u0004\u0016\u00033\ty\"a\t\u0011\u0007\u0005\u000bY\"C\u0002\u0002\u001ee\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\t\t#\u0001;UQ&\u001c\b%[:!C:\u0004\u0013N\u001c;fO\u0016\u0014\b\u0005^=qKn\u0002C\u000f[3sK\u0002J7\u000f\t8pAI,\u0017m]8oAQ|\u0007E]8v]\u0012\u0004\u0013\u000e\u001e\u0018!!\u0016\u0014\b.\u00199tAe|W\u000fI7fC:$\b\u0005^8!G\u0006dG\u000e\t;iSN\u0004s/\u001b;iA\u0005\u0004c\r\\8bi&tw-\f9pS:$\bE^1mk\u0016|\u0014EAA\u0013\u0003\u0019\u0011d&M\u0019/aQ!\u0011\u0011FA\u0018!\r\t\u00151F\u0005\u0004\u0003[I$aA%oi\"1QL\u0006a\u0001\u0003c\u00012!QA\u001a\u0013\r\t)$\u000f\u0002\u0006\r2|\u0017\r\u001e\u000b\u0005\u0003\u001f\tI\u0004C\u0003^/\u0001\u0007q+A\u0002bEN$B!!\u000b\u0002@!1Q\f\u0007a\u0001\u0003S!B!a\u0004\u0002D!1Q,\u0007a\u0001\u0003\u001f!B!!\r\u0002H!1QL\u0007a\u0001\u0003c!2aVA&\u0011\u0015i6\u00041\u0001X\u0003\ri\u0017\r\u001f\u000b\u0007\u0003S\t\t&a\u0015\t\ruc\u0002\u0019AA\u0015\u0011\u00191H\u00041\u0001\u0002*Q1\u0011qBA,\u00033Ba!X\u000fA\u0002\u0005=\u0001B\u0002<\u001e\u0001\u0004\ty\u0001\u0006\u0004\u00022\u0005u\u0013q\f\u0005\u0007;z\u0001\r!!\r\t\rYt\u0002\u0019AA\u0019)\u00159\u00161MA3\u0011\u0015iv\u00041\u0001X\u0011\u00151x\u00041\u0001X\u0003\ri\u0017N\u001c\u000b\u0007\u0003S\tY'!\u001c\t\ru\u0003\u0003\u0019AA\u0015\u0011\u00191\b\u00051\u0001\u0002*Q1\u0011qBA9\u0003gBa!X\u0011A\u0002\u0005=\u0001B\u0002<\"\u0001\u0004\ty\u0001\u0006\u0004\u00022\u0005]\u0014\u0011\u0010\u0005\u0007;\n\u0002\r!!\r\t\rY\u0014\u0003\u0019AA\u0019)\u00159\u0016QPA@\u0011\u0015i6\u00051\u0001X\u0011\u001518\u00051\u0001X\u0003\u0019\u0019\u0018n\u001a8v[R!\u0011\u0011FAC\u0011\u0019iF\u00051\u0001\u0002*Q!\u0011qBAE\u0011\u0019iV\u00051\u0001\u0002\u0010Q!\u0011\u0011GAG\u0011\u0019if\u00051\u0001\u00022Q\u0019q+!%\t\u000bu;\u0003\u0019A,\u0002\tM\f(\u000f\u001e\u000b\u0004/\u0006]\u0005\"B/)\u0001\u00049\u0016\u0001B2ceR$2aVAO\u0011\u0015i\u0016\u00061\u0001X\u0003\r\u0001xn\u001e\u000b\u0006/\u0006\r\u0016Q\u0015\u0005\u0006;*\u0002\ra\u0016\u0005\u0006m*\u0002\raV\u0001\u0004Kb\u0004HcA,\u0002,\")Ql\u000ba\u0001/\u0006)Q\r\u001f9ncQ\u0019q+!-\t\u000buc\u0003\u0019A,\u0002\u00071|w\rF\u0002X\u0003oCQ!X\u0017A\u0002]\u000bQ\u0001\\8hcA$2aVA_\u0011\u0015if\u00061\u0001X\u0003\u0015awnZ\u00191)\r9\u00161\u0019\u0005\u0006;>\u0002\raV\u0001\u0005g&t\u0007\u000eF\u0002X\u0003\u0013DQ!\u0018\u0019A\u0002]\u000bAaY8tQR\u0019q+a4\t\u000bu\u000b\u0004\u0019A,\u0002\tQ\fg\u000e\u001b\u000b\u0004/\u0006U\u0007\"B/3\u0001\u00049\u0016aA;maR\u0019q+a7\t\u000bu\u001b\u0004\u0019A,\u0015\t\u0005E\u0012q\u001c\u0005\u0007;R\u0002\r!!\r\u0002\u001b%+U)\u0012:f[\u0006Lg\u000eZ3s)\u00159\u0016Q]At\u0011\u0015iV\u00071\u0001X\u0011\u00151X\u00071\u0001X\u0001")
public final class package {
    public static double IEEEremainder(double d, double d2) {
        return package$.MODULE$.IEEEremainder(d, d2);
    }

    public static float ulp(float f) {
        return package$.MODULE$.ulp(f);
    }

    public static double ulp(double d) {
        return package$.MODULE$.ulp(d);
    }

    public static double tanh(double d) {
        return package$.MODULE$.tanh(d);
    }

    public static double cosh(double d) {
        return package$.MODULE$.cosh(d);
    }

    public static double sinh(double d) {
        return package$.MODULE$.sinh(d);
    }

    public static double log10(double d) {
        return package$.MODULE$.log10(d);
    }

    public static double log1p(double d) {
        return package$.MODULE$.log1p(d);
    }

    public static double log(double d) {
        return package$.MODULE$.log(d);
    }

    public static double expm1(double d) {
        return package$.MODULE$.expm1(d);
    }

    public static double exp(double d) {
        return package$.MODULE$.exp(d);
    }

    public static double pow(double d, double d2) {
        return package$.MODULE$.pow(d, d2);
    }

    public static double cbrt(double d) {
        return package$.MODULE$.cbrt(d);
    }

    public static double sqrt(double d) {
        return package$.MODULE$.sqrt(d);
    }

    public static double signum(double d) {
        return package$.MODULE$.signum(d);
    }

    public static float signum(float f) {
        return package$.MODULE$.signum(f);
    }

    public static long signum(long l) {
        return package$.MODULE$.signum(l);
    }

    public static int signum(int n) {
        return package$.MODULE$.signum(n);
    }

    public static double min(double d, double d2) {
        return package$.MODULE$.min(d, d2);
    }

    public static float min(float f, float f2) {
        return package$.MODULE$.min(f, f2);
    }

    public static long min(long l, long l2) {
        return package$.MODULE$.min(l, l2);
    }

    public static int min(int n, int n2) {
        return package$.MODULE$.min(n, n2);
    }

    public static double max(double d, double d2) {
        return package$.MODULE$.max(d, d2);
    }

    public static float max(float f, float f2) {
        return package$.MODULE$.max(f, f2);
    }

    public static long max(long l, long l2) {
        return package$.MODULE$.max(l, l2);
    }

    public static int max(int n, int n2) {
        return package$.MODULE$.max(n, n2);
    }

    public static double abs(double d) {
        return package$.MODULE$.abs(d);
    }

    public static float abs(float f) {
        return package$.MODULE$.abs(f);
    }

    public static long abs(long l) {
        return package$.MODULE$.abs(l);
    }

    public static int abs(int n) {
        return package$.MODULE$.abs(n);
    }

    public static long round(double d) {
        return package$.MODULE$.round(d);
    }

    public static int round(float f) {
        return package$.MODULE$.round(f);
    }

    public static long round(long l) {
        return package$.MODULE$.round(l);
    }

    public static double rint(double d) {
        return package$.MODULE$.rint(d);
    }

    public static double floor(double d) {
        return package$.MODULE$.floor(d);
    }

    public static double ceil(double d) {
        return package$.MODULE$.ceil(d);
    }

    public static double hypot(double d, double d2) {
        return package$.MODULE$.hypot(d, d2);
    }

    public static double atan2(double d, double d2) {
        return package$.MODULE$.atan2(d, d2);
    }

    public static double toDegrees(double d) {
        return package$.MODULE$.toDegrees(d);
    }

    public static double toRadians(double d) {
        return package$.MODULE$.toRadians(d);
    }

    public static double atan(double d) {
        return package$.MODULE$.atan(d);
    }

    public static double acos(double d) {
        return package$.MODULE$.acos(d);
    }

    public static double asin(double d) {
        return package$.MODULE$.asin(d);
    }

    public static double tan(double d) {
        return package$.MODULE$.tan(d);
    }

    public static double cos(double d) {
        return package$.MODULE$.cos(d);
    }

    public static double sin(double d) {
        return package$.MODULE$.sin(d);
    }

    public static double random() {
        return package$.MODULE$.random();
    }

    public static double Pi() {
        return package$.MODULE$.Pi();
    }

    public static double E() {
        return package$.MODULE$.E();
    }
}

