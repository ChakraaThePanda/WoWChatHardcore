/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import scala.Predef$;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.reflect.internal.util.BatchSourceFile;
import scala.reflect.internal.util.ScriptSourceFile;
import scala.reflect.io.AbstractFile;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

public final class ScriptSourceFile$ {
    public static ScriptSourceFile$ MODULE$;

    static {
        new ScriptSourceFile$();
    }

    public int headerLength(char[] cs) {
        boolean bl;
        Pattern headerPattern;
        block4: {
            headerPattern = Pattern.compile("((?m)^(::)?!#.*|^.*/env .*)(\\r|\\n|\\r\\n)");
            LinearSeqOptimized exists_these = new $colon$colon<Nothing$>((Nothing$)((Object)"#!"), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"::#!"), Nil$.MODULE$));
            while (!exists_these.isEmpty()) {
                String string = (String)exists_these.head();
                if (ScriptSourceFile$.$anonfun$headerLength$1(cs, string)) {
                    bl = true;
                    break block4;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        if (bl) {
            Matcher matcher = headerPattern.matcher(new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(cs)).mkString());
            if (matcher.find()) {
                return matcher.end();
            }
            throw new IOException("script file does not close its header with !# or ::!#");
        }
        return 0;
    }

    public ScriptSourceFile apply(AbstractFile file, char[] content) {
        BatchSourceFile underlying = new BatchSourceFile(file, content);
        int headerLen = this.headerLength(content);
        return new ScriptSourceFile(underlying, (char[])new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(content)).drop(headerLen), headerLen);
    }

    public ScriptSourceFile apply(BatchSourceFile underlying) {
        int headerLen = this.headerLength(underlying.content());
        return new ScriptSourceFile(underlying, (char[])new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(underlying.content())).drop(headerLen), headerLen);
    }

    public static final /* synthetic */ boolean $anonfun$headerLength$1(char[] cs$1, String x$1) {
        return new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(cs$1)).startsWith(Predef$.MODULE$.wrapString(x$1));
    }

    private ScriptSourceFile$() {
        MODULE$ = this;
    }

    public static final /* synthetic */ Object $anonfun$headerLength$1$adapted(char[] cs$1, String x$1) {
        return BoxesRunTime.boxToBoolean(ScriptSourceFile$.$anonfun$headerLength$1(cs$1, x$1));
    }
}

