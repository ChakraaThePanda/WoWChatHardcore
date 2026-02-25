/*
 * Decompiled with CFR 0.152.
 */
package scala.sys.process;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import scala.Function0;
import scala.reflect.ScalaSignature;
import scala.sys.process.ProcessLogger;

@ScalaSignature(bytes="\u0006\u0001\u00014AAC\u0006\u0001%!Aa\u0005\u0001B\u0001B\u0003%q\u0005C\u0003+\u0001\u0011\u00051\u0006C\u0004/\u0001\t\u0007I\u0011B\u0018\t\rM\u0002\u0001\u0015!\u00031\u0011\u0015!\u0004\u0001\"\u00016\u0011\u0015I\u0005\u0001\"\u0001K\u0011\u0015a\u0005\u0001\"\u0001N\u0011\u0015i\u0006\u0001\"\u0001_\u0011\u0015y\u0006\u0001\"\u0001_\u0005E1\u0015\u000e\\3Qe>\u001cWm]:M_\u001e<WM\u001d\u0006\u0003\u00195\tq\u0001\u001d:pG\u0016\u001c8O\u0003\u0002\u000f\u001f\u0005\u00191/_:\u000b\u0003A\tQa]2bY\u0006\u001c\u0001aE\u0003\u0001']Y2\u0005\u0005\u0002\u0015+5\tq\"\u0003\u0002\u0017\u001f\t1\u0011I\\=SK\u001a\u0004\"\u0001G\r\u000e\u0003-I!AG\u0006\u0003\u001bA\u0013xnY3tg2{wmZ3s!\ta\u0012%D\u0001\u001e\u0015\tqr$\u0001\u0002j_*\t\u0001%\u0001\u0003kCZ\f\u0017B\u0001\u0012\u001e\u0005%\u0019En\\:fC\ndW\r\u0005\u0002\u001dI%\u0011Q%\b\u0002\n\r2,8\u000f[1cY\u0016\fAAZ5mKB\u0011A\u0004K\u0005\u0003Su\u0011AAR5mK\u00061A(\u001b8jiz\"\"\u0001L\u0017\u0011\u0005a\u0001\u0001\"\u0002\u0014\u0003\u0001\u00049\u0013AB<sSR,'/F\u00011!\ta\u0012'\u0003\u00023;\tY\u0001K]5oi^\u0013\u0018\u000e^3s\u0003\u001d9(/\u001b;fe\u0002\n1a\\;u)\t1\u0014\b\u0005\u0002\u0015o%\u0011\u0001h\u0004\u0002\u0005+:LG\u000f\u0003\u0004;\u000b\u0011\u0005\raO\u0001\u0002gB\u0019A\u0003\u0010 \n\u0005uz!\u0001\u0003\u001fcs:\fW.\u001a \u0011\u0005}2eB\u0001!E!\t\tu\"D\u0001C\u0015\t\u0019\u0015#\u0001\u0004=e>|GOP\u0005\u0003\u000b>\ta\u0001\u0015:fI\u00164\u0017BA$I\u0005\u0019\u0019FO]5oO*\u0011QiD\u0001\u0004KJ\u0014HC\u0001\u001cL\u0011\u0019Qd\u0001\"a\u0001w\u00051!-\u001e4gKJ,\"AT)\u0015\u0005=S\u0006C\u0001)R\u0019\u0001!QAU\u0004C\u0002M\u0013\u0011\u0001V\t\u0003)^\u0003\"\u0001F+\n\u0005Y{!a\u0002(pi\"Lgn\u001a\t\u0003)aK!!W\b\u0003\u0007\u0005s\u0017\u0010\u0003\u0004\\\u000f\u0011\u0005\r\u0001X\u0001\u0002MB\u0019A\u0003P(\u0002\u000b\rdwn]3\u0015\u0003Y\nQA\u001a7vg\"\u0004")
public class FileProcessLogger
implements ProcessLogger,
Closeable,
Flushable {
    private final PrintWriter writer;

    private PrintWriter writer() {
        return this.writer;
    }

    @Override
    public void out(Function0<String> s) {
        this.writer().println(s.apply());
    }

    @Override
    public void err(Function0<String> s) {
        this.writer().println(s.apply());
    }

    @Override
    public <T> T buffer(Function0<T> f) {
        return f.apply();
    }

    @Override
    public void close() {
        this.writer().close();
    }

    @Override
    public void flush() {
        this.writer().flush();
    }

    public FileProcessLogger(File file) {
        this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true))));
    }
}

