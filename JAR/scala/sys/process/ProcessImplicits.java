/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.File;
import java.net.URL;
import scala.Function1;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.reflect.ScalaSignature;
import scala.sys.process.Process$;
import scala.sys.process.ProcessBuilder;

@ScalaSignature(bytes="\u0006\u0001U4q\u0001C\u0005\u0011\u0002\u0007\u0005\u0001\u0003C\u0003\u0016\u0001\u0011\u0005a\u0003C\u0003\u001b\u0001\u0011\r1\u0004C\u0003A\u0001\u0011\r\u0011\tC\u0003O\u0001\u0011\rq\nC\u0003Y\u0001\u0011\r\u0011\fC\u0003c\u0001\u0011\r1\rC\u0003r\u0001\u0011\r!O\u0001\tQe>\u001cWm]:J[Bd\u0017nY5ug*\u0011!bC\u0001\baJ|7-Z:t\u0015\taQ\"A\u0002tsNT\u0011AD\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001\u0011\u0003\u0005\u0002\u0013'5\tQ\"\u0003\u0002\u0015\u001b\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$C#A\f\u0011\u0005IA\u0012BA\r\u000e\u0005\u0011)f.\u001b;\u0002#\t,\u0018\u000e\u001c3feN$v\u000e\u0015:pG\u0016\u001c8/\u0006\u0002\u001diQ\u0011Q$\u0010\u000b\u0003=5\u00022a\b\u0012&\u001d\t\u0011\u0002%\u0003\u0002\"\u001b\u00059\u0001/Y2lC\u001e,\u0017BA\u0012%\u0005\r\u0019V-\u001d\u0006\u0003C5\u0001\"A\n\u0016\u000f\u0005\u001dBS\"A\u0005\n\u0005%J\u0011A\u0004)s_\u000e,7o\u001d\"vS2$WM]\u0005\u0003W1\u0012aaU8ve\u000e,'BA\u0015\n\u0011\u0015q#\u0001q\u00010\u0003\u001d\u0019wN\u001c<feR\u0004BA\u0005\u00193K%\u0011\u0011'\u0004\u0002\n\rVt7\r^5p]F\u0002\"a\r\u001b\r\u0001\u0011)QG\u0001b\u0001m\t\tA+\u0005\u00028uA\u0011!\u0003O\u0005\u0003s5\u0011qAT8uQ&tw\r\u0005\u0002\u0013w%\u0011A(\u0004\u0002\u0004\u0003:L\b\"\u0002 \u0003\u0001\u0004y\u0014\u0001\u00032vS2$WM]:\u0011\u0007}\u0011#'\u0001\tck&dG-\u001a:U_B\u0013xnY3tgR\u0011!)\u0012\t\u0003O\rK!\u0001R\u0005\u0003\u001dA\u0013xnY3tg\n+\u0018\u000e\u001c3fe\")ai\u0001a\u0001\u000f\u00069!-^5mI\u0016\u0014\bC\u0001%L\u001d\t9\u0013*\u0003\u0002K\u0013\u0005y\u0001O]8dKN\u001c\u0018J\u001c;fe:\fG.\u0003\u0002M\u001b\ny!\n\u0015:pG\u0016\u001c8OQ;jY\u0012,'O\u0003\u0002K\u0013\u0005ia-\u001b7f)>\u0004&o\\2fgN$\"\u0001U*\u0011\u0005\u0019\n\u0016B\u0001*-\u0005-1\u0015\u000e\\3Ck&dG-\u001a:\t\u000bQ#\u0001\u0019A+\u0002\t\u0019LG.\u001a\t\u0003\u0011ZK!aV'\u0003\t\u0019KG.Z\u0001\rkJdGk\u001c)s_\u000e,7o\u001d\u000b\u00035v\u0003\"AJ.\n\u0005qc#AC+S\u0019\n+\u0018\u000e\u001c3fe\")a,\u0002a\u0001?\u0006\u0019QO\u001d7\u0011\u0005!\u0003\u0017BA1N\u0005\r)&\u000bT\u0001\u0010gR\u0014\u0018N\\4U_B\u0013xnY3tgR\u0011!\t\u001a\u0005\u0006K\u001a\u0001\rAZ\u0001\bG>lW.\u00198e!\t9gN\u0004\u0002iYB\u0011\u0011.D\u0007\u0002U*\u00111nD\u0001\u0007yI|w\u000e\u001e \n\u00055l\u0011A\u0002)sK\u0012,g-\u0003\u0002pa\n11\u000b\u001e:j]\u001eT!!\\\u0007\u0002%M$(/\u001b8h'\u0016\fHk\u001c)s_\u000e,7o\u001d\u000b\u0003\u0005NDQ!Z\u0004A\u0002Q\u00042a\b\u0012g\u0001")
public interface ProcessImplicits {
    public static /* synthetic */ Seq buildersToProcess$(ProcessImplicits $this, Seq builders, Function1 convert) {
        return $this.buildersToProcess(builders, convert);
    }

    default public <T> Seq<ProcessBuilder.Source> buildersToProcess(Seq<T> builders, Function1<T, ProcessBuilder.Source> convert) {
        if (Process$.MODULE$ == null) {
            throw null;
        }
        return builders.map(convert, Seq$.MODULE$.canBuildFrom());
    }

    public static /* synthetic */ ProcessBuilder builderToProcess$(ProcessImplicits $this, java.lang.ProcessBuilder builder) {
        return $this.builderToProcess(builder);
    }

    default public ProcessBuilder builderToProcess(java.lang.ProcessBuilder builder) {
        return Process$.MODULE$.apply(builder);
    }

    public static /* synthetic */ ProcessBuilder.FileBuilder fileToProcess$(ProcessImplicits $this, File file) {
        return $this.fileToProcess(file);
    }

    default public ProcessBuilder.FileBuilder fileToProcess(File file) {
        return Process$.MODULE$.apply(file);
    }

    public static /* synthetic */ ProcessBuilder.URLBuilder urlToProcess$(ProcessImplicits $this, URL url) {
        return $this.urlToProcess(url);
    }

    default public ProcessBuilder.URLBuilder urlToProcess(URL url) {
        return Process$.MODULE$.apply(url);
    }

    public static /* synthetic */ ProcessBuilder stringToProcess$(ProcessImplicits $this, String command) {
        return $this.stringToProcess(command);
    }

    default public ProcessBuilder stringToProcess(String command) {
        return Process$.MODULE$.apply(command);
    }

    public static /* synthetic */ ProcessBuilder stringSeqToProcess$(ProcessImplicits $this, Seq command) {
        return $this.stringSeqToProcess(command);
    }

    default public ProcessBuilder stringSeqToProcess(Seq<String> command) {
        return Process$.MODULE$.apply(command);
    }

    public static void $init$(ProcessImplicits $this) {
    }
}

