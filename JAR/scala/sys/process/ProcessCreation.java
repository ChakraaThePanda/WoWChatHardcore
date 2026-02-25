/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.File;
import java.net.URL;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableOnce;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.sys.process.ProcessBuilder;
import scala.sys.process.ProcessBuilder$;
import scala.sys.process.ProcessBuilderImpl;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015daB\t\u0013!\u0003\r\t!\u0007\u0005\u0006=\u0001!\ta\b\u0005\u0006G\u0001!\t\u0001\n\u0005\u0006G\u0001!\tA\u000e\u0005\u0006G\u0001!\ta\u0010\u0005\u0006G\u0001!\ta\u0011\u0005\u0006G\u0001!\tA\u0016\u0005\u0006G\u0001!\tA\u0017\u0005\u0006G\u0001!\t!\u0019\u0005\u0006G\u0001!\t!\u001a\u0005\u0006G\u0001!\ta\u001b\u0005\u0006G\u0001!\t!\u001e\u0005\u0006G\u0001!\tA \u0005\u0007G\u0001!\t!!\u0003\t\u000f\u0005}\u0001\u0001\"\u0001\u0002\"!9\u0011Q\u000b\u0001\u0005\u0002\u0005]\u0003bBA+\u0001\u0011\u0005\u0011\u0011\r\u0002\u0010!J|7-Z:t\u0007J,\u0017\r^5p]*\u00111\u0003F\u0001\baJ|7-Z:t\u0015\t)b#A\u0002tsNT\u0011aF\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001!\u0004\u0005\u0002\u001c95\ta#\u0003\u0002\u001e-\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$C#\u0001\u0011\u0011\u0005m\t\u0013B\u0001\u0012\u0017\u0005\u0011)f.\u001b;\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0005\u0015J\u0003C\u0001\u0014(\u001b\u0005\u0011\u0012B\u0001\u0015\u0013\u00059\u0001&o\\2fgN\u0014U/\u001b7eKJDQA\u000b\u0002A\u0002-\nqaY8n[\u0006tG\r\u0005\u0002-g9\u0011Q&\r\t\u0003]Yi\u0011a\f\u0006\u0003aa\ta\u0001\u0010:p_Rt\u0014B\u0001\u001a\u0017\u0003\u0019\u0001&/\u001a3fM&\u0011A'\u000e\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005I2BCA\u00138\u0011\u0015Q3\u00011\u00019!\rIDh\u000b\b\u00037iJ!a\u000f\f\u0002\u000fA\f7m[1hK&\u0011QH\u0010\u0002\u0004'\u0016\f(BA\u001e\u0017)\r)\u0003)\u0011\u0005\u0006U\u0011\u0001\ra\u000b\u0005\u0006\u0005\u0012\u0001\r\u0001O\u0001\nCJ<W/\\3oiN$B!\n#F\u001d\")!&\u0002a\u0001W!)a)\u0002a\u0001\u000f\u0006\u00191m\u001e3\u0011\u0005![eB\u0001\u0014J\u0013\tQ%#A\bqe>\u001cWm]:J]R,'O\\1m\u0013\taUJ\u0001\u0003GS2,'B\u0001&\u0013\u0011\u0015yU\u00011\u0001Q\u0003!)\u0007\u0010\u001e:b\u000b:4\bcA\u000eR'&\u0011!K\u0006\u0002\u000byI,\u0007/Z1uK\u0012t\u0004\u0003B\u000eUW-J!!\u0016\f\u0003\rQ+\b\u000f\\33)\u0011)s\u000bW-\t\u000b)2\u0001\u0019\u0001\u001d\t\u000b\u00193\u0001\u0019A$\t\u000b=3\u0001\u0019\u0001)\u0015\t\u0015ZF\f\u0019\u0005\u0006U\u001d\u0001\ra\u000b\u0005\u0006\r\u001e\u0001\r!\u0018\t\u00047y;\u0015BA0\u0017\u0005\u0019y\u0005\u000f^5p]\")qj\u0002a\u0001!R!QEY2e\u0011\u0015Q\u0003\u00021\u00019\u0011\u00151\u0005\u00021\u0001^\u0011\u0015y\u0005\u00021\u0001Q)\t)c\rC\u0003h\u0013\u0001\u0007\u0001.A\u0004ck&dG-\u001a:\u0011\u0005!K\u0017B\u00016N\u0005=Q\u0005K]8dKN\u001c()^5mI\u0016\u0014HC\u00017t!\ti\u0007O\u0004\u0002']&\u0011qNE\u0001\u000f!J|7-Z:t\u0005VLG\u000eZ3s\u0013\t\t(OA\u0006GS2,')^5mI\u0016\u0014(BA8\u0013\u0011\u0015!(\u00021\u0001H\u0003\u00111\u0017\u000e\\3\u0015\u0005YL\bCA7x\u0013\tA(O\u0001\u0006V%2\u0013U/\u001b7eKJDQA_\u0006A\u0002m\f1!\u001e:m!\tAE0\u0003\u0002~\u001b\n\u0019QK\u0015'\u0015\u0005\u0015z\bbBA\u0001\u0019\u0001\u0007\u00111A\u0001\u0006m\u0006dW/\u001a\t\u00047\u0005\u0015\u0011bAA\u0004-\t9!i\\8mK\u0006tG#B\u0013\u0002\f\u0005=\u0001BBA\u0007\u001b\u0001\u00071&\u0001\u0003oC6,\u0007\u0002CA\t\u001b\u0011\u0005\r!a\u0005\u0002\u0013\u0015D\u0018\u000e\u001e,bYV,\u0007#B\u000e\u0002\u0016\u0005e\u0011bAA\f-\tAAHY=oC6,g\bE\u0002\u001c\u00037I1!!\b\u0017\u0005\rIe\u000e^\u0001\tCB\u0004H._*fcV!\u00111EA\u001f)\u0011\t)#a\u0014\u0015\t\u0005\u001d\u0012q\u0006\t\u0005sq\nI\u0003E\u0002n\u0003WI1!!\fs\u0005\u0019\u0019v.\u001e:dK\"9\u0011\u0011\u0007\bA\u0004\u0005M\u0012aB2p]Z,'\u000f\u001e\t\b7\u0005U\u0012\u0011HA\u0015\u0013\r\t9D\u0006\u0002\n\rVt7\r^5p]F\u0002B!a\u000f\u0002>1\u0001AaBA \u001d\t\u0007\u0011\u0011\t\u0002\u0002)F!\u00111IA%!\rY\u0012QI\u0005\u0004\u0003\u000f2\"a\u0002(pi\"Lgn\u001a\t\u00047\u0005-\u0013bAA'-\t\u0019\u0011I\\=\t\u000f\u0005Ec\u00021\u0001\u0002T\u0005A!-^5mI\u0016\u00148\u000f\u0005\u0003:y\u0005e\u0012aA2biR)Q%!\u0017\u0002\\!1Ao\u0004a\u0001\u0003SAq!!\u0018\u0010\u0001\u0004\ty&A\u0003gS2,7\u000f\u0005\u0003\u001c#\u0006%BcA\u0013\u0002d!9\u0011Q\f\tA\u0002\u0005\u001d\u0002")
public interface ProcessCreation {
    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, String command) {
        return $this.apply(command);
    }

    default public ProcessBuilder apply(String command) {
        return this.apply(command, (Option<File>)None$.MODULE$, Predef$.MODULE$.wrapRefArray((Object[])new Tuple2[0]));
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, Seq command) {
        return $this.apply(command);
    }

    default public ProcessBuilder apply(Seq<String> command) {
        return this.apply(command, (Option<File>)None$.MODULE$, Predef$.MODULE$.wrapRefArray((Object[])new Tuple2[0]));
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, String command, Seq arguments) {
        return $this.apply(command, arguments);
    }

    default public ProcessBuilder apply(String command, Seq<String> arguments) {
        return this.apply(arguments.$plus$colon(command, Seq$.MODULE$.canBuildFrom()), (Option<File>)None$.MODULE$, Predef$.MODULE$.wrapRefArray((Object[])new Tuple2[0]));
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, String command, File cwd, Seq extraEnv) {
        return $this.apply(command, cwd, (Seq<Tuple2<String, String>>)extraEnv);
    }

    default public ProcessBuilder apply(String command, File cwd, Seq<Tuple2<String, String>> extraEnv) {
        return this.apply(command, new Some<File>(cwd), extraEnv);
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, Seq command, File cwd, Seq extraEnv) {
        return $this.apply((Seq<String>)command, cwd, (Seq<Tuple2<String, String>>)extraEnv);
    }

    default public ProcessBuilder apply(Seq<String> command, File cwd, Seq<Tuple2<String, String>> extraEnv) {
        return this.apply(command, new Some<File>(cwd), extraEnv);
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, String command, Option cwd, Seq extraEnv) {
        return $this.apply(command, (Option<File>)cwd, (Seq<Tuple2<String, String>>)extraEnv);
    }

    default public ProcessBuilder apply(String command, Option<File> cwd, Seq<Tuple2<String, String>> extraEnv) {
        return this.apply(Predef$.MODULE$.wrapRefArray((Object[])command.split("\\s+")), cwd, extraEnv);
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, Seq command, Option cwd, Seq extraEnv) {
        return $this.apply((Seq<String>)command, (Option<File>)cwd, (Seq<Tuple2<String, String>>)extraEnv);
    }

    default public ProcessBuilder apply(Seq<String> command, Option<File> cwd, Seq<Tuple2<String, String>> extraEnv) {
        java.lang.ProcessBuilder jpb = new java.lang.ProcessBuilder((String[])command.toArray(ClassTag$.MODULE$.apply(String.class)));
        if (cwd == null) {
            throw null;
        }
        if (!cwd.isEmpty()) {
            File file = cwd.get();
            jpb.directory(file);
        }
        extraEnv.foreach((Function1<Tuple2, String> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            String k = (String)x0$1._1();
            String v = (String)x0$1._2();
            String string = jpb.environment().put(k, v);
            return string;
        });
        return this.apply(jpb);
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, java.lang.ProcessBuilder builder) {
        return $this.apply(builder);
    }

    default public ProcessBuilder apply(java.lang.ProcessBuilder builder) {
        return new ProcessBuilderImpl.Simple(ProcessBuilder$.MODULE$, builder);
    }

    public static /* synthetic */ ProcessBuilder.FileBuilder apply$(ProcessCreation $this, File file) {
        return $this.apply(file);
    }

    default public ProcessBuilder.FileBuilder apply(File file) {
        return new ProcessBuilderImpl.FileImpl(ProcessBuilder$.MODULE$, file);
    }

    public static /* synthetic */ ProcessBuilder.URLBuilder apply$(ProcessCreation $this, URL url) {
        return $this.apply(url);
    }

    default public ProcessBuilder.URLBuilder apply(URL url) {
        return new ProcessBuilderImpl.URLImpl(ProcessBuilder$.MODULE$, url);
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, boolean value) {
        return $this.apply(value);
    }

    default public ProcessBuilder apply(boolean value) {
        return this.apply(((Object)BoxesRunTime.boxToBoolean(value)).toString(), (JFunction0$mcI$sp & Serializable)() -> {
            if (value) {
                return 0;
            }
            return 1;
        });
    }

    public static /* synthetic */ ProcessBuilder apply$(ProcessCreation $this, String name, Function0 exitValue) {
        return $this.apply(name, exitValue);
    }

    default public ProcessBuilder apply(String name, Function0<Object> exitValue) {
        return new ProcessBuilderImpl.Dummy(ProcessBuilder$.MODULE$, name, exitValue);
    }

    public static /* synthetic */ Seq applySeq$(ProcessCreation $this, Seq builders, Function1 convert) {
        return $this.applySeq(builders, convert);
    }

    default public <T> Seq<ProcessBuilder.Source> applySeq(Seq<T> builders, Function1<T, ProcessBuilder.Source> convert) {
        return builders.map(convert, Seq$.MODULE$.canBuildFrom());
    }

    public static /* synthetic */ ProcessBuilder cat$(ProcessCreation $this, ProcessBuilder.Source file, Seq files2) {
        return $this.cat(file, files2);
    }

    default public ProcessBuilder cat(ProcessBuilder.Source file, Seq<ProcessBuilder.Source> files2) {
        return this.cat(files2.$plus$colon(file, Seq$.MODULE$.canBuildFrom()));
    }

    public static /* synthetic */ ProcessBuilder cat$(ProcessCreation $this, Seq files2) {
        return $this.cat(files2);
    }

    default public ProcessBuilder cat(Seq<ProcessBuilder.Source> files2) {
        Predef$.MODULE$.require(files2.nonEmpty());
        return (ProcessBuilder)((TraversableOnce)files2.map((Function1<ProcessBuilder.Source, ProcessBuilder> & java.io.Serializable & Serializable)x$4 -> x$4.cat(), Seq$.MODULE$.canBuildFrom())).reduceLeft((Function2<ProcessBuilder, ProcessBuilder, ProcessBuilder> & java.io.Serializable & Serializable)(x$5, x$6) -> x$5.$hash$amp$amp((ProcessBuilder)x$6));
    }

    public static void $init$(ProcessCreation $this) {
    }
}

