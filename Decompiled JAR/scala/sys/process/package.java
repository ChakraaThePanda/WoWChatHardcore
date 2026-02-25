/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import scala.Function1;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.sys.process.ProcessBuilder;
import scala.sys.process.package$;

@ScalaSignature(bytes="\u0006\u0001%;Qa\u0002\u0005\t\u0002=1Q!\u0005\u0005\t\u0002IAQAG\u0001\u0005\u0002mAQ\u0001H\u0001\u0005\u0002uAQ!O\u0001\u0005\u0002iBQaQ\u0001\u0005\u0002\u0011CQ\u0001S\u0001\u0005\u0002\u0011\u000bq\u0001]1dW\u0006<WM\u0003\u0002\n\u0015\u00059\u0001O]8dKN\u001c(BA\u0006\r\u0003\r\u0019\u0018p\u001d\u0006\u0002\u001b\u0005)1oY1mC\u000e\u0001\u0001C\u0001\t\u0002\u001b\u0005A!a\u00029bG.\fw-Z\n\u0004\u0003M9\u0002C\u0001\u000b\u0016\u001b\u0005a\u0011B\u0001\f\r\u0005\u0019\te.\u001f*fMB\u0011\u0001\u0003G\u0005\u00033!\u0011\u0001\u0003\u0015:pG\u0016\u001c8/S7qY&\u001c\u0017\u000e^:\u0002\rqJg.\u001b;?)\u0005y\u0011a\u00046bm\u00064V.\u0011:hk6,g\u000e^:\u0016\u0003y\u00012a\b\u0014*\u001d\t\u0001SE\u0004\u0002\"I5\t!E\u0003\u0002$\u001d\u00051AH]8pizJ\u0011!D\u0005\u0003\u000f1I!a\n\u0015\u0003\t1K7\u000f\u001e\u0006\u0003\u000f1\u0001\"A\u000b\u0018\u000f\u0005-b\u0003CA\u0011\r\u0013\tiC\"\u0001\u0004Qe\u0016$WMZ\u0005\u0003_A\u0012aa\u0015;sS:<'BA\u0017\rQ\u0011\u0019!'N\u001c\u0011\u0005Q\u0019\u0014B\u0001\u001b\r\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0002m\u0005iDo\u001c\u0011bI\",'/\u001a\u0011u_\u0002\"\b.\u001a\u0011d_6\u0004\u0018m\u0019;2AA\u0014xNZ5mK\u0002\"\b.[:![\u0016$\bn\u001c3!o&dG\u000e\t2fAI,Wn\u001c<fI\u0006\n\u0001(\u0001\u00043]E\u0012d&N\u0001\u0006gR$\u0017N\\\u000b\u0002wA\u0011A(Q\u0007\u0002{)\u0011ahP\u0001\u0003S>T\u0011\u0001Q\u0001\u0005U\u00064\u0018-\u0003\u0002C{\tY\u0011J\u001c9viN#(/Z1n\u0003\u0019\u0019H\u000fZ8viV\tQ\t\u0005\u0002=\r&\u0011q)\u0010\u0002\f!JLg\u000e^*ue\u0016\fW.\u0001\u0004ti\u0012,'O\u001d")
public final class package {
    public static PrintStream stderr() {
        return package$.MODULE$.stderr();
    }

    public static PrintStream stdout() {
        return package$.MODULE$.stdout();
    }

    public static InputStream stdin() {
        return package$.MODULE$.stdin();
    }

    public static List<String> javaVmArguments() {
        return package$.MODULE$.javaVmArguments();
    }

    public static ProcessBuilder stringSeqToProcess(Seq<String> seq) {
        return package$.MODULE$.stringSeqToProcess(seq);
    }

    public static ProcessBuilder stringToProcess(String string) {
        return package$.MODULE$.stringToProcess(string);
    }

    public static ProcessBuilder.URLBuilder urlToProcess(URL uRL) {
        return package$.MODULE$.urlToProcess(uRL);
    }

    public static ProcessBuilder.FileBuilder fileToProcess(File file) {
        return package$.MODULE$.fileToProcess(file);
    }

    public static ProcessBuilder builderToProcess(java.lang.ProcessBuilder processBuilder) {
        return package$.MODULE$.builderToProcess(processBuilder);
    }

    public static <T> Seq<ProcessBuilder.Source> buildersToProcess(Seq<T> seq, Function1<T, ProcessBuilder.Source> function1) {
        return package$.MODULE$.buildersToProcess(seq, function1);
    }
}

