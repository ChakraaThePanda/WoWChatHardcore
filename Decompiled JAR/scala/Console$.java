/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import scala.DeprecatedConsole;
import scala.Function0;
import scala.Predef$;
import scala.collection.Seq;
import scala.collection.immutable.StringOps;
import scala.io.AnsiColor;
import scala.util.DynamicVariable;

public final class Console$
extends DeprecatedConsole
implements AnsiColor {
    public static Console$ MODULE$;
    private final DynamicVariable<PrintStream> outVar;
    private final DynamicVariable<PrintStream> errVar;
    private final DynamicVariable<BufferedReader> inVar;

    static {
        new Console$();
    }

    private DynamicVariable<PrintStream> outVar() {
        return this.outVar;
    }

    private DynamicVariable<PrintStream> errVar() {
        return this.errVar;
    }

    private DynamicVariable<BufferedReader> inVar() {
        return this.inVar;
    }

    @Override
    public void setOutDirect(PrintStream out) {
        this.outVar().value_$eq(out);
    }

    @Override
    public void setErrDirect(PrintStream err) {
        this.errVar().value_$eq(err);
    }

    @Override
    public void setInDirect(BufferedReader in) {
        this.inVar().value_$eq(in);
    }

    public PrintStream out() {
        return this.outVar().value();
    }

    public PrintStream err() {
        return this.errVar().value();
    }

    public BufferedReader in() {
        return this.inVar().value();
    }

    public <T> T withOut(PrintStream out, Function0<T> thunk) {
        return this.outVar().withValue(out, thunk);
    }

    public <T> T withOut(OutputStream out, Function0<T> thunk) {
        PrintStream withOut_out = new PrintStream(out);
        return this.outVar().withValue(withOut_out, thunk);
    }

    public <T> T withErr(PrintStream err, Function0<T> thunk) {
        return this.errVar().withValue(err, thunk);
    }

    public <T> T withErr(OutputStream err, Function0<T> thunk) {
        PrintStream withErr_err = new PrintStream(err);
        return this.errVar().withValue(withErr_err, thunk);
    }

    public <T> T withIn(Reader reader, Function0<T> thunk) {
        return this.inVar().withValue(new BufferedReader(reader), thunk);
    }

    public <T> T withIn(InputStream in, Function0<T> thunk) {
        InputStreamReader withIn_reader = new InputStreamReader(in);
        return this.inVar().withValue(new BufferedReader(withIn_reader), thunk);
    }

    public void print(Object obj) {
        this.out().print(obj == null ? "null" : obj.toString());
    }

    public void flush() {
        this.out().flush();
    }

    public void println() {
        this.out().println();
    }

    public void println(Object x) {
        this.out().println(x);
    }

    public void printf(String text, Seq<Object> args2) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        this.out().print(new StringOps(text).format(args2));
    }

    private Console$() {
        MODULE$ = this;
        AnsiColor.$init$(this);
        this.outVar = new DynamicVariable<PrintStream>(System.out);
        this.errVar = new DynamicVariable<PrintStream>(System.err);
        this.inVar = new DynamicVariable<BufferedReader>(new BufferedReader(new InputStreamReader(System.in)));
    }
}

