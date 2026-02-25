/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.Function0;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import scala.concurrent.package$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005Er!B\u0005\u000b\u0011\u0003ya!B\t\u000b\u0011\u0003\u0011\u0002\"B\f\u0002\t\u0003AR\u0001B\r\u0002\u0001i)AAI\u0001\u0001G\u0015!Q%\u0001\u0001'\u0011\u0015A\u0013\u0001\"\u0001*\u0011\u0015Y\u0018\u0001\"\u0001}\u0011\u001d\ti!\u0001C\u0001\u0003\u001f\tq\u0001]1dW\u0006<WM\u0003\u0002\f\u0019\u0005Q1m\u001c8dkJ\u0014XM\u001c;\u000b\u00035\tQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002\u0011\u00035\t!BA\u0004qC\u000e\\\u0017mZ3\u0014\u0005\u0005\u0019\u0002C\u0001\u000b\u0016\u001b\u0005a\u0011B\u0001\f\r\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012a\u0004\u0002\u0013\u000bb,7-\u001e;j_:,\u0005pY3qi&|g\u000e\u0005\u0002\u001cC5\tAD\u0003\u0002\f;)\u0011adH\u0001\u0005kRLGNC\u0001!\u0003\u0011Q\u0017M^1\n\u0005ea\"!F\"b]\u000e,G\u000e\\1uS>tW\t_2faRLwN\u001c\t\u00037\u0011J!A\t\u000f\u0003!QKW.Z8vi\u0016C8-\u001a9uS>t\u0007CA\u000e(\u0013\t)C$\u0001\u0004gkR,(/Z\u000b\u0003UE\"\"a\u000b8\u0015\u00051R\u0004c\u0001\t._%\u0011aF\u0003\u0002\u0007\rV$XO]3\u0011\u0005A\nD\u0002\u0001\u0003\u0006e\u0019\u0011\ra\r\u0002\u0002)F\u0011Ag\u000e\t\u0003)UJ!A\u000e\u0007\u0003\u000f9{G\u000f[5oOB\u0011A\u0003O\u0005\u0003s1\u00111!\u00118z\u0011\u0015Yd\u0001q\u0001=\u0003!)\u00070Z2vi>\u0014\bC\u0001\t>\u0013\tq$B\u0001\tFq\u0016\u001cW\u000f^5p]\u000e{g\u000e^3yi\"\"!\bQ\"e!\t!\u0012)\u0003\u0002C\u0019\tqA-\u001a9sK\u000e\fG/\u001a3OC6,\u0017\u0007B\u0010E\u000f\u0002\u0004\"\u0001F#\n\u0005\u0019c!AB*z[\n|G.M\u0003$\u0011.SF\n\u0006\u0002E\u0013\")!\n\u0001a\u0001\u001f\u0006!a.Y7f\u0013\taU*A\u0003baBd\u0017P\u0003\u0002O\u0019\u000511+_7c_2\u0004\"\u0001U,\u000f\u0005E+\u0006C\u0001*\r\u001b\u0005\u0019&B\u0001+\u000f\u0003\u0019a$o\\8u}%\u0011a\u000bD\u0001\u0007!J,G-\u001a4\n\u0005aK&AB*ue&twM\u0003\u0002W\u0019E*1e\u00170`\u001d:\u0011AL\u0018\b\u0003%vK\u0011!D\u0005\u0003\u001d2\tD\u0001\n/^\u001bE\u001aQ%\u00192\u0010\u0003\t\f\u0013aY\u0001\bKb,7m\u0019;yc\u0015\u0019s*Z5g\u0013\t1w-A\u000e%Y\u0016\u001c8/\u001b8ji\u0012:'/Z1uKJ$C-\u001a4bk2$HE\r\u0006\u0003Q2\ta\u0002Z3qe\u0016\u001c\u0017\r^3e\u001d\u0006lW-M\u0003$U.d\u0007N\u0004\u0002\u0015W&\u0011\u0001\u000eD\u0019\u0005EQaQNA\u0003tG\u0006d\u0017\r\u0003\u0004p\r\u0011\u0005\r\u0001]\u0001\u0005E>$\u0017\u0010E\u0002\u0015c>J!A\u001d\u0007\u0003\u0011q\u0012\u0017P\\1nKzBCA\u0002;xsB\u0011A#^\u0005\u0003m2\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005A\u0018\u0001H;tK\u0002\u0002g)\u001e;ve\u0016\u00043\u0010\t\u0018/]\u0001j\b\rI5ogR,\u0017\rZ\u0011\u0002u\u00061!GL\u00192]A\nq\u0001\u001d:p[&\u001cX-F\u0002~\u0003\u000b!\u0012A \t\u0005!}\f\u0019!C\u0002\u0002\u0002)\u0011q\u0001\u0015:p[&\u001cX\rE\u00021\u0003\u000b!QAM\u0004C\u0002MBSa\u0002;\u0002\ne\f#!a\u0003\u00025U\u001cX\r\t1Qe>l\u0017n]3\\)vC\u0013\u0006\u0019\u0011j]N$X-\u00193\u0002\u0011\tdwnY6j]\u001e,B!!\u0005\u0002\u0016Q!\u00111CA\f!\r\u0001\u0014Q\u0003\u0003\u0006e!\u0011\ra\r\u0005\b_\"!\t\u0019AA\r!\u0011!\u0012/a\u0005)\u000b!\ti\"a\f\u0011\u000bQ\ty\"a\t\n\u0007\u0005\u0005BB\u0001\u0004uQJ|wo\u001d\t\u0005\u0003K\tICD\u0002\u0015\u0003OI!!\u0003\u0007\n\t\u0005-\u0012Q\u0006\u0002\n\u000bb\u001cW\r\u001d;j_:T!!\u0003\u0007$\u0005\u0005\r\u0002")
public final class package {
    public static <T> T blocking(Function0<T> function0) throws Exception {
        return package$.MODULE$.blocking(function0);
    }

    public static <T> Promise<T> promise() {
        return package$.MODULE$.promise();
    }

    public static <T> Future<T> future(Function0<T> function0, ExecutionContext executionContext) {
        return package$.MODULE$.future(function0, executionContext);
    }
}

