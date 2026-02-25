/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.IOException;
import scala.Function0;
import scala.Function1;
import scala.PartialFunction;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.sys.process.processInternal$;

@ScalaSignature(bytes="\u0006\u0001\u0005UtA\u0002\f\u0018\u0011\u00039RD\u0002\u0004 /!\u0005q\u0003\t\u0005\u0006K\u0005!\ta\n\u0005\bQ\u0005\u0011\r\u0011\"\u0002*\u0011\u0019i\u0013\u0001)A\u0007U\u0015!a&\u0001\u00010\u000b\u0011\t\u0015\u0001\u0001\"\u0006\t%\u000b\u0001AS\u0003\u0005\u0019\u0006\u0001Q*\u0002\u0003P\u0003\u0001\u0001V\u0001\u0002*\u0002\u0001M+A!V\u0001\u0001-\u0016!A,\u0001\u0001^\u000b\u0011\u0001\u0017\u0001A1\u0006\t1\f\u0001!\\\u0003\u0005_\u0006\u0001\u0001/\u0002\u0003x\u0003\u0001A\b\"B?\u0002\t\u0003q\bbBA\u0016\u0003\u0011\u0005\u0011Q\u0006\u0005\b\u0003\u007f\tA\u0011AA!\u0011\u001d\ty%\u0001C\u0001\u0003#Bq!!\u0019\u0002\t\u0003\t\u0019'A\bqe>\u001cWm]:J]R,'O\\1m\u0015\tA\u0012$A\u0004qe>\u001cWm]:\u000b\u0005iY\u0012aA:zg*\tA$A\u0003tG\u0006d\u0017\r\u0005\u0002\u001f\u00035\tqCA\bqe>\u001cWm]:J]R,'O\\1m'\t\t\u0011\u0005\u0005\u0002#G5\t1$\u0003\u0002%7\t1\u0011I\\=SK\u001a\fa\u0001P5oSRt4\u0001\u0001\u000b\u0002;\u0005a\u0001O]8dKN\u001cH)\u001a2vOV\t!\u0006\u0005\u0002#W%\u0011Af\u0007\u0002\b\u0005>|G.Z1o\u00035\u0001(o\\2fgN$UMY;hA\t\tB%Z9%c6\f'o\u001b\u0013he\u0016\fG/\u001a:\u0016\u0007A*t\b\u0005\u0003#cMr\u0014B\u0001\u001a\u001c\u0005=\u0001\u0016M\u001d;jC24UO\\2uS>t\u0007C\u0001\u001b6\u0019\u0001!aAN\u0003\t\u0006\u00049$!A!\u0012\u0005aZ\u0004C\u0001\u0012:\u0013\tQ4DA\u0004O_RD\u0017N\\4\u0011\u0005\tb\u0014BA\u001f\u001c\u0005\r\te.\u001f\t\u0003i}\"a\u0001Q\u0003\u0005\u0006\u00049$!\u0001\"\u0003\u0013\rcwn]3bE2,\u0007CA\"I\u001b\u0005!%BA#G\u0003\tIwNC\u0001H\u0003\u0011Q\u0017M^1\n\u0005\u0005#%\u0001\u0002$jY\u0016\u0004\"aQ&\n\u0005%#%aC%P\u000bb\u001cW\r\u001d;j_:\u0004\"a\u0011(\n\u00051#%AF%oi\u0016\u0014(/\u001e9uK\u0012Lu*\u0012=dKB$\u0018n\u001c8\u0011\u0005\r\u000b\u0016BA(E\u0005-Ie\u000e];u'R\u0014X-Y7\u0011\u0005\r#\u0016B\u0001*E\u0005!Q\u0005K]8dKN\u001c\bCA,[\u001b\u0005A&BA-G\u0003\u0011a\u0017M\\4\n\u0005mC&a\u0002)s_\u000e,7o\u001d\u0002\u0010\u0015B\u0013xnY3tg\n+\u0018\u000e\u001c3feB\u0011qKX\u0005\u0003?b\u0013a\u0002\u0015:pG\u0016\u001c8OQ;jY\u0012,'OA\nMS:\\W\r\u001a\"m_\u000e\\\u0017N\\4Rk\u0016,X-\u0006\u0002cUB\u00191\r[5\u000e\u0003\u0011T!!\u001a4\u0002\u0015\r|gnY;se\u0016tGO\u0003\u0002h\r\u0006!Q\u000f^5m\u0013\t\u0001G\r\u0005\u00025U\u0012)1.\u0004b\u0001o\t\tAK\u0001\u0007PkR\u0004X\u000f^*ue\u0016\fW\u000e\u0005\u0002D]&\u0011A\u000e\u0012\u0002\b'ft7MV1s+\t\th\u000fE\u0002siVl\u0011a\u001d\u0006\u0003KnI!a\\:\u0011\u0005Q2H!B6\u0010\u0005\u00049$aA+S\u0019B\u0011\u0011\u0010`\u0007\u0002u*\u00111PR\u0001\u0004]\u0016$\u0018BA<{\u0003\u001dyg.\u0012:s_J,2a`A\u0010)\u0011\t\t!!\t\u0011\u000f\u0005\rQ!!\u0002\u0002\u001e5\t\u0011\u0001\u0005\u0003\u0002\b\u0005]a\u0002BA\u0005\u0003'qA!a\u0003\u0002\u00125\u0011\u0011Q\u0002\u0006\u0004\u0003\u001f1\u0013A\u0002\u001fs_>$h(C\u0001\u001d\u0013\r\t)bG\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\tI\"a\u0007\u0003\u0013QC'o\\<bE2,'bAA\u000b7A\u0019A'a\b\u0005\u000b-\f\"\u0019A\u001c\t\u000f\u0005\r\u0012\u00031\u0001\u0002&\u00059\u0001.\u00198eY\u0016\u0014\bc\u0002\u0012\u0002(\u0005\u0015\u0011QD\u0005\u0004\u0003SY\"!\u0003$v]\u000e$\u0018n\u001c82\u00035yg.S(J]R,'O];qiV!\u0011qFA\u001b)\u0011\t\t$a\u000e\u0011\u000f\u0005\rQ!!\u0002\u00024A\u0019A'!\u000e\u0005\u000b-\u0014\"\u0019A\u001c\t\u0011\u0005\r\"\u0003\"a\u0001\u0003s\u0001RAIA\u001e\u0003gI1!!\u0010\u001c\u0005!a$-\u001f8b[\u0016t\u0014aC8o\u0013:$XM\u001d:vaR,B!a\u0011\u0002JQ!\u0011QIA&!\u001d\t\u0019!BA\u0003\u0003\u000f\u00022\u0001NA%\t\u0015Y7C1\u00018\u0011!\t\u0019c\u0005CA\u0002\u00055\u0003#\u0002\u0012\u0002<\u0005\u001d\u0013!C5p\r\u0006LG.\u001e:f+\u0011\t\u0019&!\u0017\u0015\t\u0005U\u00131\f\t\b\u0003\u0007)\u0011QAA,!\r!\u0014\u0011\f\u0003\u0006WR\u0011\ra\u000e\u0005\b\u0003G!\u0002\u0019AA/!\u001d\u0011\u0013qEA0\u0003/\u00022!a\u0001\t\u0003\r!'m\u001a\u000b\u0005\u0003K\nY\u0007E\u0002#\u0003OJ1!!\u001b\u001c\u0005\u0011)f.\u001b;\t\u000f\u00055T\u00031\u0001\u0002p\u0005!Qn]4t!\u0011\u0011\u0013\u0011O\u001e\n\u0007\u0005M4D\u0001\u0006=e\u0016\u0004X-\u0019;fIz\u0002")
public final class processInternal {
    public static void dbg(Seq<Object> seq) {
        processInternal$.MODULE$.dbg(seq);
    }

    public static <T> PartialFunction<Throwable, T> ioFailure(Function1<IOException, T> function1) {
        return processInternal$.MODULE$.ioFailure(function1);
    }

    public static <T> PartialFunction<Throwable, T> onInterrupt(Function0<T> function0) {
        return processInternal$.MODULE$.onInterrupt(function0);
    }

    public static <T> PartialFunction<Throwable, T> onIOInterrupt(Function0<T> function0) {
        return processInternal$.MODULE$.onIOInterrupt(function0);
    }

    public static <T> PartialFunction<Throwable, T> onError(Function1<Throwable, T> function1) {
        return processInternal$.MODULE$.onError(function1);
    }

    public static boolean processDebug() {
        return processInternal$.MODULE$.processDebug();
    }
}

