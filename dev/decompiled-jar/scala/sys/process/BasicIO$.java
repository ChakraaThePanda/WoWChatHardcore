/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.runtime.BoxedUnit;
import scala.runtime.Null$;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.sys.process.BasicIO$Uncloseable$;
import scala.sys.process.ProcessIO;
import scala.sys.process.ProcessLogger;
import scala.sys.process.package$;
import scala.sys.process.processInternal$;

public final class BasicIO$ {
    public static BasicIO$ MODULE$;
    private final String Newline;

    static {
        new BasicIO$();
    }

    public final int BufferSize() {
        return 8192;
    }

    public final String Newline() {
        return this.Newline;
    }

    public ProcessIO apply(boolean withIn, Function1<String, BoxedUnit> output, Option<ProcessLogger> log) {
        return new ProcessIO(this.input(withIn), (Function1<InputStream, BoxedUnit>)(Function1<InputStream, Object> & java.io.Serializable & Serializable)in -> {
            try (BufferedReader $anonfun$processFully$1_reader = new BufferedReader(new InputStreamReader((InputStream)in));){
                void $anonfun$processFully$1_processLinesFully_readLine;
                BasicIO$ basicIO$ = MODULE$;
                Function0<String> & java.io.Serializable & Serializable intersect = (Function0<String> & java.io.Serializable & Serializable)() -> reader.readLine();
                if (basicIO$ == null) {
                    throw null;
                }
                basicIO$.readFully$1((Function0)$anonfun$processFully$1_processLinesFully_readLine, output);
            }
            return BoxedUnit.UNIT;
        }, this.getErr(log));
    }

    public ProcessIO apply(boolean withIn, StringBuffer buffer, Option<ProcessLogger> log) {
        return new ProcessIO(this.input(withIn), this.processFully(buffer), this.getErr(log));
    }

    public ProcessIO apply(boolean withIn, ProcessLogger log) {
        return new ProcessIO(this.input(withIn), this.processOutFully(log), this.processErrFully(log));
    }

    public Function1<InputStream, BoxedUnit> getErr(Option<ProcessLogger> log) {
        Function1<InputStream, BoxedUnit> function1;
        if (log instanceof Some) {
            ProcessLogger lg = (ProcessLogger)((Some)log).value();
            function1 = this.processErrFully(lg);
        } else if (None$.MODULE$.equals(log)) {
            function1 = this.toStdErr();
        } else {
            throw new MatchError(log);
        }
        return function1;
    }

    private Function1<InputStream, BoxedUnit> processErrFully(ProcessLogger log) {
        return arg_0 -> BasicIO$.$anonfun$processFully$1$adapted((Function1<String, Object> & java.io.Serializable & Serializable)x$1 -> {
            log.err((Function0<String> & java.io.Serializable & Serializable)() -> x$1);
            return BoxedUnit.UNIT;
        }, arg_0);
    }

    private Function1<InputStream, BoxedUnit> processOutFully(ProcessLogger log) {
        return arg_0 -> BasicIO$.$anonfun$processFully$1$adapted((Function1<String, Object> & java.io.Serializable & Serializable)x$2 -> {
            log.out((Function0<String> & java.io.Serializable & Serializable)() -> x$2);
            return BoxedUnit.UNIT;
        }, arg_0);
    }

    public void close(Closeable c) {
        try {
            c.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public Function1<InputStream, BoxedUnit> processFully(Appendable buffer) {
        return this.processFully(this.appendLine(buffer));
    }

    public Function1<InputStream, BoxedUnit> processFully(Function1<String, BoxedUnit> processLine) {
        return (Function1<InputStream, Object> & java.io.Serializable & Serializable)in -> {
            try (BufferedReader $anonfun$processFully$1_reader = new BufferedReader(new InputStreamReader((InputStream)in));){
                void $anonfun$processFully$1_processLinesFully_readLine;
                BasicIO$ basicIO$ = MODULE$;
                Function0<String> & java.io.Serializable & Serializable intersect = (Function0<String> & java.io.Serializable & Serializable)() -> reader.readLine();
                if (basicIO$ == null) {
                    throw null;
                }
                basicIO$.readFully$1((Function0)$anonfun$processFully$1_processLinesFully_readLine, output);
            }
            return BoxedUnit.UNIT;
        };
    }

    public void processLinesFully(Function1<String, BoxedUnit> processLine, Function0<String> readLine) {
        this.readFully$1(readLine, processLine);
    }

    public void connectToIn(OutputStream o) {
        this.transferFully(BasicIO$Uncloseable$.MODULE$.protect(package$.MODULE$.stdin()), o);
    }

    public Function1<OutputStream, BoxedUnit> input(boolean connect2) {
        return (Function1<OutputStream, Object> & java.io.Serializable & Serializable)outputToProcess -> {
            BasicIO$.$anonfun$input$1(connect2, outputToProcess);
            return BoxedUnit.UNIT;
        };
    }

    public ProcessIO standard(boolean connectInput) {
        return this.standard(this.input(connectInput));
    }

    public ProcessIO standard(Function1<OutputStream, BoxedUnit> in) {
        return new ProcessIO(in, this.toStdOut(), this.toStdErr());
    }

    public Function1<InputStream, BoxedUnit> toStdErr() {
        return (Function1<InputStream, Object> & java.io.Serializable & Serializable)in -> {
            BasicIO$.MODULE$.transferFully(in, package$.MODULE$.stderr());
            return BoxedUnit.UNIT;
        };
    }

    public Function1<InputStream, BoxedUnit> toStdOut() {
        return (Function1<InputStream, Object> & java.io.Serializable & Serializable)in -> {
            BasicIO$.MODULE$.transferFully(in, package$.MODULE$.stdout());
            return BoxedUnit.UNIT;
        };
    }

    /*
     * WARNING - void declaration
     */
    public void transferFully(InputStream in, OutputStream out) {
        try {
            this.transferFullyImpl(in, out);
            return;
        }
        catch (Throwable x$3) {
            void onIOInterrupt_handler;
            JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> {};
            if (processInternal$.MODULE$ == null) {
                throw null;
            }
            Serializable serializable = new Serializable((Function0)onIOInterrupt_handler){
                public static final long serialVersionUID = 0L;
                private final Function0 handler$2;

                public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                    Object object = x1 instanceof InterruptedIOException ? this.handler$2.apply() : function1.apply(x1);
                    return (B1)object;
                }

                public final boolean isDefinedAt(Throwable x1) {
                    boolean bl = x1 instanceof InterruptedIOException;
                    return bl;
                }
                {
                    this.handler$2 = handler$2;
                }
            };
            if (serializable.isDefinedAt(x$3)) {
                serializable.apply(x$3);
                return;
            }
            throw x$3;
        }
    }

    private Function1<String, BoxedUnit> appendLine(Appendable buffer) {
        return (Function1<String, Object> & java.io.Serializable & Serializable)line -> {
            BasicIO$.$anonfun$appendLine$1(buffer, line);
            return BoxedUnit.UNIT;
        };
    }

    private void transferFullyImpl(InputStream in, OutputStream out) {
        byte[] buffer = new byte[8192];
        this.loop$1(in, buffer, out);
        in.close();
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ void $anonfun$processFully$1(Function1 processLine$1, InputStream in) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));){
            void processLinesFully_readLine;
            BasicIO$ basicIO$ = MODULE$;
            Function0<String> & java.io.Serializable & Serializable intersect = (Function0<String> & java.io.Serializable & Serializable)() -> reader.readLine();
            if (basicIO$ == null) {
                throw null;
            }
            basicIO$.readFully$1((Function0)processLinesFully_readLine, processLine$1);
        }
    }

    private static final boolean working$1() {
        return !Thread.currentThread().isInterrupted();
    }

    private static final Null$ halting$1() {
        Thread.currentThread().interrupt();
        return null;
    }

    private final void readFully$1(Function0 readLine$1, Function1 processLine$2) {
        while (BasicIO$.working$1()) {
            String line;
            String string;
            try {
                string = (String)readLine$1.apply();
            }
            catch (Throwable throwable) {
                if (throwable instanceof InterruptedException) {
                    BasicIO$.halting$1();
                } else if (throwable instanceof IOException && !BasicIO$.working$1()) {
                    BasicIO$.halting$1();
                } else {
                    throw throwable;
                }
                string = line = null;
            }
            if (line == null) break;
            processLine$2.apply(line);
        }
    }

    public static final /* synthetic */ void $anonfun$input$1(boolean connect$1, OutputStream outputToProcess) {
        if (connect$1) {
            MODULE$.connectToIn(outputToProcess);
        }
        outputToProcess.close();
    }

    public static final /* synthetic */ void $anonfun$appendLine$1(Appendable buffer$1, String line) {
        buffer$1.append(line);
        buffer$1.append(MODULE$.Newline());
    }

    private final void loop$1(InputStream in$2, byte[] buffer$2, OutputStream out$2) {
        int byteCount;
        while ((byteCount = in$2.read(buffer$2)) > 0) {
            boolean bl;
            out$2.write(buffer$2, 0, byteCount);
            try {
                out$2.flush();
                bl = true;
            }
            catch (IOException iOException) {
                bl = false;
            }
            if (bl) continue;
        }
    }

    private BasicIO$() {
        MODULE$ = this;
        this.Newline = System.lineSeparator();
    }
}

