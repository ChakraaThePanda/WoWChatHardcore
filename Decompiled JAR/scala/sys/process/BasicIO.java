/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.collection.immutable.Stream;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.sys.process.BasicIO$;
import scala.sys.process.ProcessIO;
import scala.sys.process.ProcessLogger;

@ScalaSignature(bytes="\u0006\u0001\t5r!\u0002\u00192\u0011\u0003Ad!\u0002\u001e2\u0011\u0003Y\u0004\"\u0002!\u0002\t\u0003\t\u0005b\u0002\"\u0002\u0005\u0004%)a\u0011\u0005\u0007\r\u0006\u0001\u000bQ\u0002#\t\u000f\u001d\u000b!\u0019!C\u0003\u0011\"1\u0011+\u0001Q\u0001\u000e%3QAU\u0001\u0003cMC\u0001BM\u0004\u0003\u0006\u0004%\t!\u0016\u0005\tO\u001e\u0011\t\u0011)A\u0005-\"A\u0001n\u0002BC\u0002\u0013\u0005\u0011\u000e\u0003\u0005o\u000f\t\u0005\t\u0015!\u0003k\u0011!ywA!b\u0001\n\u0003\u0001\b\u0002\u0003?\b\u0005\u0003\u0005\u000b\u0011B9\t\u000b\u0001;A\u0011A?\b\u0011\u0005\u001d\u0011\u0001#\u00012\u0003\u00131qAU\u0001\t\u0002E\nY\u0001\u0003\u0004A!\u0011\u0005\u0011Q\u0002\u0005\b\u0003\u001f\u0001B\u0011AA\t\r)\t)#\u0001I\u0001\u0004\u0003\t\u0014q\u0005\u0005\b\u0003{\u0019B\u0011AA \u0011\u001d\t\te\u0005C#\u0003\u007f9\u0001\"a\u0011\u0002\u0011\u0003\t\u0014Q\t\u0004\t\u0003K\t\u0001\u0012A\u0019\u0002H!1\u0001i\u0006C\u0001\u0003\u0013Bq!a\u0004\u0018\t\u0003\tY\u0005C\u0004\u0002\u0010]!\t!a\u0016\t\u000f\u0005\rt\u0003\"\u0001\u0002f!9\u00111M\f\u0005\u0002\u0005%\u0004bBA\b\u0003\u0011\u0005\u0011Q\u000e\u0005\b\u0003\u001f\tA\u0011AAR\u0011\u001d\ty!\u0001C\u0001\u0003gCq!!/\u0002\t\u0003\tY\fC\u0004\u0002B\u0006!I!a1\t\u000f\u0005\u001d\u0017\u0001\"\u0003\u0002J\"9\u0011\u0011I\u0001\u0005\u0002\u00055\u0007bBAj\u0003\u0011\u0005\u0011Q\u001b\u0005\b\u0003'\fA\u0011AAp\u0011\u001d\t)/\u0001C\u0001\u0003ODq!a=\u0002\t\u0003\t)\u0010C\u0004\u0002|\u0006!\t!!@\t\u000f\t\u0015\u0011\u0001\"\u0001\u0003\b!9!QA\u0001\u0005\u0002\t5\u0001b\u0002B\t\u0003\u0011\u0005!1\u0003\u0005\b\u0005+\tA\u0011\u0001B\n\u0011\u001d\u00119\"\u0001C\u0001\u00053A\u0001Ba\b\u0002A\u0013%!\u0011\u0005\u0005\t\u0005K\t\u0001\u0015\"\u0003\u0003(\u00059!)Y:jG&{%B\u0001\u001a4\u0003\u001d\u0001(o\\2fgNT!\u0001N\u001b\u0002\u0007ML8OC\u00017\u0003\u0015\u00198-\u00197b\u0007\u0001\u0001\"!O\u0001\u000e\u0003E\u0012qAQ1tS\u000eLuj\u0005\u0002\u0002yA\u0011QHP\u0007\u0002k%\u0011q(\u000e\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005A\u0014A\u0003\"vM\u001a,'oU5{KV\tAiD\u0001F;\t\u0001\u0003!A\u0006Ck\u001a4WM]*ju\u0016\u0004\u0013a\u0002(fo2Lg.Z\u000b\u0002\u0013B\u0011!jT\u0007\u0002\u0017*\u0011A*T\u0001\u0005Y\u0006twMC\u0001O\u0003\u0011Q\u0017M^1\n\u0005A[%AB*ue&tw-\u0001\u0005OK^d\u0017N\\3!\u0005!\u0019FO]3b[\u0016$WC\u0001+\\'\t9A(F\u0001W!\u0011it+\u00173\n\u0005a+$!\u0003$v]\u000e$\u0018n\u001c82!\tQ6\f\u0004\u0001\u0005\u000bq;!\u0019A/\u0003\u0003Q\u000b\"AX1\u0011\u0005uz\u0016B\u000116\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!\u00102\n\u0005\r,$aA!osB\u0011Q(Z\u0005\u0003MV\u0012A!\u00168ji\u0006A\u0001O]8dKN\u001c\b%\u0001\u0003e_:,W#\u00016\u0011\tu:6\u000e\u001a\t\u0003{1L!!\\\u001b\u0003\u0007%sG/A\u0003e_:,\u0007%\u0001\u0004tiJ,\u0017-\\\u000b\u0002cB\u0019QH\u001d;\n\u0005M,$!\u0003$v]\u000e$\u0018n\u001c81!\r)(0W\u0007\u0002m*\u0011q\u000f_\u0001\nS6lW\u000f^1cY\u0016T!!_\u001b\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0002|m\n11\u000b\u001e:fC6\fqa\u001d;sK\u0006l\u0007\u0005F\u0004\u007f\u0003\u0003\t\u0019!!\u0002\u0011\u0007}<\u0011,D\u0001\u0002\u0011\u0015\u0011d\u00021\u0001W\u0011\u0015Ag\u00021\u0001k\u0011\u0015yg\u00021\u0001r\u0003!\u0019FO]3b[\u0016$\u0007CA@\u0011'\t\u0001B\b\u0006\u0002\u0002\n\u0005)\u0011\r\u001d9msV!\u00111CA\r)\u0011\t)\"a\u0007\u0011\t}<\u0011q\u0003\t\u00045\u0006eA!\u0002/\u0013\u0005\u0004i\u0006bBA\u000f%\u0001\u0007\u0011qD\u0001\u0011]>t'0\u001a:p\u000bb\u001cW\r\u001d;j_:\u00042!PA\u0011\u0013\r\t\u0019#\u000e\u0002\b\u0005>|G.Z1o\u0005-)fn\u00197pg\u0016\f'\r\\3\u0014\u000bM\tI#a\f\u0011\u0007)\u000bY#C\u0002\u0002.-\u0013aa\u00142kK\u000e$\b\u0003BA\u0019\u0003oq1!OA\u001a\u0013\r\t)$M\u0001\u0010aJ|7-Z:t\u0013:$XM\u001d8bY&!\u0011\u0011HA\u001e\u0005%\u0019En\\:fC\ndWMC\u0002\u00026E\na\u0001J5oSR$C#\u00013\u0002\u000b\rdwn]3\u0002\u0017Us7\r\\8tK\u0006\u0014G.\u001a\t\u0003\u007f^\u0019\"a\u0006\u001f\u0015\u0005\u0005\u0015C\u0003BA'\u0003'\u0002B!!\r\u0002P%!\u0011\u0011KA\u001e\u0005-Ie\u000e];u'R\u0014X-Y7\t\u000f\u0005U\u0013\u00041\u0001\u0002N\u0005\u0011\u0011N\u001c\u000b\u0005\u00033\ny\u0006\u0005\u0003\u00022\u0005m\u0013\u0002BA/\u0003w\u0011AbT;uaV$8\u000b\u001e:fC6Dq!!\u0019\u001b\u0001\u0004\tI&A\u0002pkR\fq\u0001\u001d:pi\u0016\u001cG\u000f\u0006\u0003\u0002N\u0005\u001d\u0004bBA+7\u0001\u0007\u0011Q\n\u000b\u0005\u00033\nY\u0007C\u0004\u0002bq\u0001\r!!\u0017\u0015\u0011\u0005=\u0014QOA=\u0003'\u00032!OA9\u0013\r\t\u0019(\r\u0002\n!J|7-Z:t\u0013>Cq!a\u001e\u001e\u0001\u0004\ty\"\u0001\u0004xSRD\u0017J\u001c\u0005\b\u0003wj\u0002\u0019AA?\u0003\u0019yW\u000f\u001e9viB)QhVA@IB!\u0011\u0011QAH\u001d\u0011\t\u0019)a#\u0011\u0007\u0005\u0015U'\u0004\u0002\u0002\b*\u0019\u0011\u0011R\u001c\u0002\rq\u0012xn\u001c;?\u0013\r\ti)N\u0001\u0007!J,G-\u001a4\n\u0007A\u000b\tJC\u0002\u0002\u000eVBq!!&\u001e\u0001\u0004\t9*A\u0002m_\u001e\u0004R!PAM\u0003;K1!a'6\u0005\u0019y\u0005\u000f^5p]B\u0019\u0011(a(\n\u0007\u0005\u0005\u0016GA\u0007Qe>\u001cWm]:M_\u001e<WM\u001d\u000b\t\u0003_\n)+a*\u00022\"9\u0011q\u000f\u0010A\u0002\u0005}\u0001bBAU=\u0001\u0007\u00111V\u0001\u0007EV4g-\u001a:\u0011\u0007)\u000bi+C\u0002\u00020.\u0013Ab\u0015;sS:<')\u001e4gKJDq!!&\u001f\u0001\u0004\t9\n\u0006\u0004\u0002p\u0005U\u0016q\u0017\u0005\b\u0003oz\u0002\u0019AA\u0010\u0011\u001d\t)j\ba\u0001\u0003;\u000baaZ3u\u000bJ\u0014H\u0003BA_\u0003\u007f\u0003R!P,\u0002N\u0011Dq!!&!\u0001\u0004\t9*A\bqe>\u001cWm]:FeJ4U\u000f\u001c7z)\u0011\ti,!2\t\u000f\u0005U\u0015\u00051\u0001\u0002\u001e\u0006y\u0001O]8dKN\u001cx*\u001e;Gk2d\u0017\u0010\u0006\u0003\u0002>\u0006-\u0007bBAKE\u0001\u0007\u0011Q\u0014\u000b\u0004I\u0006=\u0007bBAiG\u0001\u0007\u0011qF\u0001\u0002G\u0006a\u0001O]8dKN\u001ch)\u001e7msR!\u0011QXAl\u0011\u001d\tI\u000b\na\u0001\u00033\u00042ASAn\u0013\r\tin\u0013\u0002\u000b\u0003B\u0004XM\u001c3bE2,G\u0003BA_\u0003CDq!a9&\u0001\u0004\ti(A\u0006qe>\u001cWm]:MS:,\u0017!\u00059s_\u000e,7o\u001d'j]\u0016\u001ch)\u001e7msR!\u0011\u0011^Ay)\r!\u00171\u001e\u0005\b\u0003[4\u0003\u0019AAx\u0003!\u0011X-\u00193MS:,\u0007\u0003B\u001fs\u0003\u007fBq!a9'\u0001\u0004\ti(A\u0006d_:tWm\u0019;U_&sGc\u00013\u0002x\"9\u0011\u0011`\u0014A\u0002\u0005e\u0013!A8\u0002\u000b%t\u0007/\u001e;\u0015\t\u0005}(\u0011\u0001\t\u0006{]\u000bI\u0006\u001a\u0005\b\u0005\u0007A\u0003\u0019AA\u0010\u0003\u001d\u0019wN\u001c8fGR\f\u0001b\u001d;b]\u0012\f'\u000f\u001a\u000b\u0005\u0003_\u0012I\u0001C\u0004\u0003\f%\u0002\r!a\b\u0002\u0019\r|gN\\3di&s\u0007/\u001e;\u0015\t\u0005=$q\u0002\u0005\b\u0003+R\u0003\u0019AA\u0000\u0003!!xn\u0015;e\u000bJ\u0014XCAA_\u0003!!xn\u0015;e\u001fV$\u0018!\u0004;sC:\u001ch-\u001a:Gk2d\u0017\u0010F\u0003e\u00057\u0011i\u0002C\u0004\u0002V5\u0002\r!!\u0014\t\u000f\u0005\u0005T\u00061\u0001\u0002Z\u0005Q\u0011\r\u001d9f]\u0012d\u0015N\\3\u0015\t\u0005u$1\u0005\u0005\b\u0003Ss\u0003\u0019AAm\u0003E!(/\u00198tM\u0016\u0014h)\u001e7ms&k\u0007\u000f\u001c\u000b\u0006I\n%\"1\u0006\u0005\b\u0003+z\u0003\u0019AA'\u0011\u001d\t\tg\fa\u0001\u00033\u0002")
public final class BasicIO {
    public static void transferFully(InputStream inputStream2, OutputStream outputStream2) {
        BasicIO$.MODULE$.transferFully(inputStream2, outputStream2);
    }

    public static Function1<InputStream, BoxedUnit> toStdOut() {
        return BasicIO$.MODULE$.toStdOut();
    }

    public static Function1<InputStream, BoxedUnit> toStdErr() {
        return BasicIO$.MODULE$.toStdErr();
    }

    public static ProcessIO standard(Function1<OutputStream, BoxedUnit> function1) {
        return BasicIO$.MODULE$.standard(function1);
    }

    public static ProcessIO standard(boolean bl) {
        return BasicIO$.MODULE$.standard(bl);
    }

    public static Function1<OutputStream, BoxedUnit> input(boolean bl) {
        return BasicIO$.MODULE$.input(bl);
    }

    public static void connectToIn(OutputStream outputStream2) {
        BasicIO$.MODULE$.connectToIn(outputStream2);
    }

    public static void processLinesFully(Function1<String, BoxedUnit> function1, Function0<String> function0) {
        BasicIO$.MODULE$.processLinesFully(function1, function0);
    }

    public static Function1<InputStream, BoxedUnit> processFully(Function1<String, BoxedUnit> function1) {
        return BasicIO$.MODULE$.processFully(function1);
    }

    public static Function1<InputStream, BoxedUnit> processFully(Appendable appendable) {
        return BasicIO$.MODULE$.processFully(appendable);
    }

    public static void close(Closeable closeable) {
        BasicIO$.MODULE$.close(closeable);
    }

    public static Function1<InputStream, BoxedUnit> getErr(Option<ProcessLogger> option) {
        return BasicIO$.MODULE$.getErr(option);
    }

    public static ProcessIO apply(boolean bl, ProcessLogger processLogger) {
        return BasicIO$.MODULE$.apply(bl, processLogger);
    }

    public static ProcessIO apply(boolean bl, StringBuffer stringBuffer, Option<ProcessLogger> option) {
        return BasicIO$.MODULE$.apply(bl, stringBuffer, option);
    }

    public static ProcessIO apply(boolean bl, Function1<String, BoxedUnit> function1, Option<ProcessLogger> option) {
        return BasicIO$.MODULE$.apply(bl, function1, option);
    }

    public static String Newline() {
        return BasicIO$.MODULE$.Newline();
    }

    public static int BufferSize() {
        return BasicIO$.MODULE$.BufferSize();
    }

    public static final class Streamed<T> {
        private final Function1<T, BoxedUnit> process;
        private final Function1<Object, BoxedUnit> done;
        private final Function0<Stream<T>> stream;

        public Function1<T, BoxedUnit> process() {
            return this.process;
        }

        public Function1<Object, BoxedUnit> done() {
            return this.done;
        }

        public Function0<Stream<T>> stream() {
            return this.stream;
        }

        public Streamed(Function1<T, BoxedUnit> process, Function1<Object, BoxedUnit> done, Function0<Stream<T>> stream) {
            this.process = process;
            this.done = done;
            this.stream = stream;
        }
    }

    public static interface Uncloseable
    extends Closeable {
        public static /* synthetic */ void close$(Uncloseable $this) {
            $this.close();
        }

        @Override
        default public void close() {
        }

        public static void $init$(Uncloseable $this) {
        }
    }
}

