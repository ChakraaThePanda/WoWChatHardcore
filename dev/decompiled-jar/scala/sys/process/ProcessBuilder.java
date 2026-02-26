/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import scala.Function0;
import scala.collection.immutable.Stream;
import scala.reflect.ScalaSignature;
import scala.sys.process.Process;
import scala.sys.process.ProcessBuilder$;
import scala.sys.process.ProcessBuilderImpl;
import scala.sys.process.ProcessIO;
import scala.sys.process.ProcessLogger;

@ScalaSignature(bytes="\u0006\u0001\t=aa\u0002\u001c8!\u0003\r\tA\u0010\u0005\u0006)\u0002!\t!\u0016\u0005\b\u0003\u000f\u0002a\u0011AA%\u0011\u001d\t9\u0005\u0001D\u0001\u0003CBq!!\u001c\u0001\r\u0003\tI\u0005C\u0004\u0002n\u00011\t!a\u001c\t\u000f\u0005M\u0004A\"\u0001\u0002v!9\u0011Q\u0011\u0001\u0005\u0002\u0005U\u0004bBA:\u0001\u0019\u0005\u0011q\u0013\u0005\b\u0003\u000b\u0003A\u0011AAN\u0011\u001d\t\t\u000b\u0001D\u0001\u0003kBq!a)\u0001\t\u0003\t)\bC\u0004\u0002\"\u00021\t!a+\t\u000f\u0005\r\u0006\u0001\"\u0001\u00020\"9\u0011Q\u0017\u0001\u0007\u0002\u0005]\u0006bBA[\u0001\u0019\u0005\u0011q\u0018\u0005\b\u0003\u0007\u0004a\u0011AA\\\u0011\u001d\t\u0019\r\u0001D\u0001\u0003\u000bDq!!3\u0001\r\u0003\tY\rC\u0004\u0002J\u00021\t!a5\t\u000f\u0005%\u0007A\"\u0001\u0002X\"9\u0011\u0011\u001a\u0001\u0007\u0002\u0005\r\bbBAe\u0001\u0019\u0005\u0011\u0011\u001e\u0005\b\u0003_\u0004a\u0011AAy\u0011\u001d\t9\u0010\u0001D\u0001\u0003sDq!!@\u0001\r\u0003\ty\u0010C\u0004\u0003\u0004\u00011\tA!\u0002\t\u000f\t%\u0001A\"\u0001\u0003\f!9!Q\u0002\u0001\u0007\u0002\t-q!\u0002$8\u0011\u00039e!\u0002\u001c8\u0011\u0003A\u0005\"\u0002'\u001f\t\u0003iea\u0002(\u001f!\u0003\r\na\u0014\u0004\t\u007fz\u0001\n1%\u0001\u0002\u0002!9\u0011QF\u0011\u0007\u0002\u0005=\u0002bBA\u0017C\u0019\u0005\u00111\u0007\u0005\b\u0003[\tc\u0011AA\u001d\u0011\u001d\ti#\tD\u0001\u0003\u007f1qA\u0015\u0010\u0011\u0002\u0007\u00051\u000bC\u0003UM\u0011\u0005Q\u000bC\u0003ZM\u0019E!\fC\u0003]M\u0011\u0005Q\fC\u0003hM\u0011\u0005\u0001\u000eC\u0003]M\u0011\u0005!\u000eC\u0003]M\u0011\u00051\u000fC\u0003wM\u0011\u0005!\fC\u0003xM\u0011%\u0001PB\u0005\u0002\u0006y\u0001\n1!\u0001\u0002\b!)Ak\fC\u0001+\"1\u0011\u0011B\u0018\u0007\u0012iCq!a\u00030\t\u0003\ti\u0001C\u0004\u0002\f=\"\t!!\u0005\t\u000f\u0005-q\u0006\"\u0001\u0002\u001c!9\u00111B\u0018\u0005\u0002\u0005%\"A\u0004)s_\u000e,7o\u001d\"vS2$WM\u001d\u0006\u0003qe\nq\u0001\u001d:pG\u0016\u001c8O\u0003\u0002;w\u0005\u00191/_:\u000b\u0003q\nQa]2bY\u0006\u001c\u0001aE\u0003\u0001\u007f\r\u000b)\u0005\u0005\u0002A\u00036\t1(\u0003\u0002Cw\t1\u0011I\\=SK\u001a\u0004\"\u0001\u0012\u0014\u000f\u0005\u0015kR\"A\u001c\u0002\u001dA\u0013xnY3tg\n+\u0018\u000e\u001c3feB\u0011QIH\n\u0004=}J\u0005CA#K\u0013\tYuG\u0001\nQe>\u001cWm]:Ck&dG-\u001a:J[Bd\u0017A\u0002\u001fj]&$h\bF\u0001H\u0005))&\u000b\u0014\"vS2$WM]\n\u0004A}\u0002\u0006CA)'\u001b\u0005q\"AB*pkJ\u001cWm\u0005\u0002'\u007f\u00051A%\u001b8ji\u0012\"\u0012A\u0016\t\u0003\u0001^K!\u0001W\u001e\u0003\tUs\u0017\u000e^\u0001\ti>\u001cv.\u001e:dKV\t1\f\u0005\u0002F\u0001\u0005iA\u0005[1tQ\u0012:'/Z1uKJ$\"a\u00170\t\u000b}K\u0003\u0019\u00011\u0002\u0003\u0019\u0004\"!\u00193\u000f\u0005\u0015\u0013\u0017BA28\u0003=\u0001(o\\2fgNLe\u000e^3s]\u0006d\u0017BA3g\u0005\u00111\u0015\u000e\\3\u000b\u0005\r<\u0014!\u0006\u0013iCNDGe\u001a:fCR,'\u000fJ4sK\u0006$XM\u001d\u000b\u00037&DQa\u0018\u0016A\u0002\u0001$\"aW6\t\r1\\C\u00111\u0001n\u0003\ryW\u000f\u001e\t\u0004\u0001:\u0004\u0018BA8<\u0005!a$-\u001f8b[\u0016t\u0004CA1r\u0013\t\u0011hM\u0001\u0007PkR\u0004X\u000f^*ue\u0016\fW\u000e\u0006\u0002\\i\")Q\u000f\fa\u00017\u0006\t!-A\u0002dCR\fa\u0001^8GS2,GcA.zu\")qL\fa\u0001A\")1P\fa\u0001y\u00061\u0011\r\u001d9f]\u0012\u0004\"\u0001Q?\n\u0005y\\$a\u0002\"p_2,\u0017M\u001c\u0002\f\r&dWMQ;jY\u0012,'oE\u0003\"\u007f\u0005\r\u0001\u000b\u0005\u0002R_\t!1+\u001b8l'\tys(\u0001\u0004u_NKgn[\u0001\u000bI!\f7\u000f\u001b\u0013mKN\u001cHcA.\u0002\u0010!)qL\ra\u0001AR\u00191,a\u0005\t\r}\u001b\u0004\u0019AA\u000b!\r\t\u0017qC\u0005\u0004\u000331'aA+S\u0019R\u00191,!\b\t\u0011\u0005}A\u0007\"a\u0001\u0003C\t!!\u001b8\u0011\t\u0001s\u00171\u0005\t\u0004C\u0006\u0015\u0012bAA\u0014M\nY\u0011J\u001c9viN#(/Z1n)\rY\u00161\u0006\u0005\u0006kV\u0002\raW\u0001\u0010I!\f7\u000f\u001b\u0013mKN\u001cH\u0005\\3tgR\u00191,!\r\t\u000b}\u0013\u0003\u0019\u00011\u0015\u0007m\u000b)\u0004C\u0004\u00028\r\u0002\r!!\u0006\u0002\u0003U$2aWA\u001e\u0011!\ti\u0004\nCA\u0002\u0005\u0005\u0012!A5\u0015\u0007m\u000b\t\u0005\u0003\u0004\u0002D\u0015\u0002\raW\u0001\u0002aB\u0011AiL\u0001\u000bI\t\fgn\u001a\u0013cC:<WCAA&!\u0011\ti%a\u0017\u000f\t\u0005=\u0013q\u000b\t\u0004\u0003#ZTBAA*\u0015\r\t)&P\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005e3(\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003;\nyF\u0001\u0004TiJLgn\u001a\u0006\u0004\u00033ZD\u0003BA&\u0003GBq!!\u001a\u0004\u0001\u0004\t9'A\u0002m_\u001e\u00042!RA5\u0013\r\tYg\u000e\u0002\u000e!J|7-Z:t\u0019><w-\u001a:\u0002\u001f\u0011\u0012\u0017M\\4%E\u0006tw\r\n7fgN$B!a\u0013\u0002r!9\u0011QM\u0003A\u0002\u0005\u001d\u0014A\u00037j]\u0016\u001cFO]3b[V\u0011\u0011q\u000f\t\u0007\u0003s\ny(a\u0013\u000f\u0007\u0001\u000bY(C\u0002\u0002~m\nq\u0001]1dW\u0006<W-\u0003\u0003\u0002\u0002\u0006\r%AB*ue\u0016\fWNC\u0002\u0002~m\nQ\u0001\\5oKNDsaBAE\u0003\u001f\u000b\u0019\nE\u0002A\u0003\u0017K1!!$<\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0003\u0003#\u000ba#^:fA1Lg.Z*ue\u0016\fW\u000eI5ogR,\u0017\rZ\u0011\u0003\u0003+\u000baA\r\u00182c9\u0002D\u0003BA<\u00033Cq!!\u001a\t\u0001\u0004\t9\u0007\u0006\u0003\u0002x\u0005u\u0005bBA3\u0013\u0001\u0007\u0011q\r\u0015\b\u0013\u0005%\u0015qRAJ\u0003Aa\u0017N\\3TiJ,\u0017-\\0%E\u0006tw-A\u0006mS:,7o\u0018\u0013cC:<\u0007fB\u0006\u0002\n\u0006\u001d\u00161S\u0011\u0003\u0003S\u000b\u0001$^:fA1Lg.Z*ue\u0016\fWnX\u0011!S:\u001cH/Z1e)\u0011\t9(!,\t\u000f\u0005\u0015D\u00021\u0001\u0002hQ!\u0011qOAY\u0011\u001d\t)'\u0004a\u0001\u0003OBs!DAE\u0003O\u000b\u0019*A\u0003%E\u0006tw-\u0006\u0002\u0002:B\u0019\u0001)a/\n\u0007\u0005u6HA\u0002J]R$B!!/\u0002B\"9\u0011QM\bA\u0002\u0005\u001d\u0014A\u0003\u0013cC:<G\u0005\\3tgR!\u0011\u0011XAd\u0011\u001d\t)'\u0005a\u0001\u0003O\n1A];o)\t\ti\rE\u0002F\u0003\u001fL1!!58\u0005\u001d\u0001&o\\2fgN$B!!4\u0002V\"9\u0011QM\nA\u0002\u0005\u001dD\u0003BAg\u00033Dq!a7\u0015\u0001\u0004\ti.\u0001\u0002j_B\u0019Q)a8\n\u0007\u0005\u0005xGA\u0005Qe>\u001cWm]:J\u001fR!\u0011QZAs\u0011\u0019\t9/\u0006a\u0001y\u0006a1m\u001c8oK\u000e$\u0018J\u001c9viR1\u0011QZAv\u0003[Dq!!\u001a\u0017\u0001\u0004\t9\u0007\u0003\u0004\u0002hZ\u0001\r\u0001`\u0001\u000eI!\f7\u000f\u001b\u0013b[B$\u0013-\u001c9\u0015\u0007m\u000b\u0019\u0010\u0003\u0004\u0002v^\u0001\raW\u0001\u0006_RDWM]\u0001\u000eI!\f7\u000f\u001b\u0013cCJ$#-\u0019:\u0015\u0007m\u000bY\u0010\u0003\u0004\u0002vb\u0001\raW\u0001\nI!\f7\u000f\u001b\u0013cCJ$2a\u0017B\u0001\u0011\u0019\t)0\u0007a\u00017\u0006yA\u0005[1tQ\u0012B\u0017m\u001d5%Q\u0006\u001c\b\u000eF\u0002\\\u0005\u000fAa!!>\u001b\u0001\u0004Y\u0016!C2b]BK\u0007/\u001a+p+\u0005a\u0018\u0001\u00045bg\u0016C\u0018\u000e\u001e,bYV,\u0007")
public interface ProcessBuilder
extends Source,
Sink {
    public String $bang$bang();

    public String $bang$bang(ProcessLogger var1);

    public String $bang$bang$less();

    public String $bang$bang$less(ProcessLogger var1);

    public Stream<String> lineStream();

    public static /* synthetic */ Stream lines$(ProcessBuilder $this) {
        return $this.lines();
    }

    default public Stream<String> lines() {
        return this.lineStream();
    }

    public Stream<String> lineStream(ProcessLogger var1);

    public static /* synthetic */ Stream lines$(ProcessBuilder $this, ProcessLogger log) {
        return $this.lines(log);
    }

    default public Stream<String> lines(ProcessLogger log) {
        return this.lineStream(log);
    }

    public Stream<String> lineStream_$bang();

    public static /* synthetic */ Stream lines_$bang$(ProcessBuilder $this) {
        return $this.lines_$bang();
    }

    default public Stream<String> lines_$bang() {
        return this.lineStream_$bang();
    }

    public Stream<String> lineStream_$bang(ProcessLogger var1);

    public static /* synthetic */ Stream lines_$bang$(ProcessBuilder $this, ProcessLogger log) {
        return $this.lines_$bang(log);
    }

    default public Stream<String> lines_$bang(ProcessLogger log) {
        return this.lineStream_$bang(log);
    }

    public int $bang();

    public int $bang(ProcessLogger var1);

    public int $bang$less();

    public int $bang$less(ProcessLogger var1);

    public Process run();

    public Process run(ProcessLogger var1);

    public Process run(ProcessIO var1);

    public Process run(boolean var1);

    public Process run(ProcessLogger var1, boolean var2);

    public ProcessBuilder $hash$amp$amp(ProcessBuilder var1);

    public ProcessBuilder $hash$bar$bar(ProcessBuilder var1);

    public ProcessBuilder $hash$bar(ProcessBuilder var1);

    public ProcessBuilder $hash$hash$hash(ProcessBuilder var1);

    public boolean canPipeTo();

    public boolean hasExitValue();

    public static void $init$(ProcessBuilder $this) {
    }

    public static interface FileBuilder
    extends Sink,
    Source {
        public ProcessBuilder $hash$less$less(File var1);

        public ProcessBuilder $hash$less$less(URL var1);

        public ProcessBuilder $hash$less$less(Function0<InputStream> var1);

        public ProcessBuilder $hash$less$less(ProcessBuilder var1);
    }

    public static interface Sink {
        public ProcessBuilder toSink();

        public static /* synthetic */ ProcessBuilder $hash$less$(Sink $this, File f) {
            return $this.$hash$less(f);
        }

        default public ProcessBuilder $hash$less(File f) {
            return this.$hash$less(new ProcessBuilderImpl.FileInput(ProcessBuilder$.MODULE$, f));
        }

        public static /* synthetic */ ProcessBuilder $hash$less$(Sink $this, URL f) {
            return $this.$hash$less(f);
        }

        default public ProcessBuilder $hash$less(URL f) {
            return this.$hash$less(new ProcessBuilderImpl.URLInput(ProcessBuilder$.MODULE$, f));
        }

        public static /* synthetic */ ProcessBuilder $hash$less$(Sink $this, Function0 in) {
            return $this.$hash$less(in);
        }

        default public ProcessBuilder $hash$less(Function0<InputStream> in) {
            return this.$hash$less(new ProcessBuilderImpl.IStreamBuilder(ProcessBuilder$.MODULE$, in, "<input stream>"));
        }

        public static /* synthetic */ ProcessBuilder $hash$less$(Sink $this, ProcessBuilder b) {
            return $this.$hash$less(b);
        }

        default public ProcessBuilder $hash$less(ProcessBuilder b) {
            return new ProcessBuilderImpl.PipedBuilder(ProcessBuilder$.MODULE$, b, this.toSink(), false);
        }

        public static void $init$(Sink $this) {
        }
    }

    public static interface Source {
        public ProcessBuilder toSource();

        public static /* synthetic */ ProcessBuilder $hash$greater$(Source $this, File f) {
            return $this.$hash$greater(f);
        }

        default public ProcessBuilder $hash$greater(File f) {
            return this.toFile(f, false);
        }

        public static /* synthetic */ ProcessBuilder $hash$greater$greater$(Source $this, File f) {
            return $this.$hash$greater$greater(f);
        }

        default public ProcessBuilder $hash$greater$greater(File f) {
            return this.toFile(f, true);
        }

        public static /* synthetic */ ProcessBuilder $hash$greater$(Source $this, Function0 out) {
            return $this.$hash$greater(out);
        }

        default public ProcessBuilder $hash$greater(Function0<OutputStream> out) {
            return this.$hash$greater(new ProcessBuilderImpl.OStreamBuilder(ProcessBuilder$.MODULE$, out, "<output stream>"));
        }

        public static /* synthetic */ ProcessBuilder $hash$greater$(Source $this, ProcessBuilder b) {
            return $this.$hash$greater(b);
        }

        default public ProcessBuilder $hash$greater(ProcessBuilder b) {
            return new ProcessBuilderImpl.PipedBuilder(ProcessBuilder$.MODULE$, this.toSource(), b, false);
        }

        public static /* synthetic */ ProcessBuilder cat$(Source $this) {
            return $this.cat();
        }

        default public ProcessBuilder cat() {
            return this.toSource();
        }

        private ProcessBuilder toFile(File f, boolean append) {
            return this.$hash$greater(new ProcessBuilderImpl.FileOutput(ProcessBuilder$.MODULE$, f, append));
        }

        public static void $init$(Source $this) {
        }
    }

    public static interface URLBuilder
    extends Source {
    }
}

