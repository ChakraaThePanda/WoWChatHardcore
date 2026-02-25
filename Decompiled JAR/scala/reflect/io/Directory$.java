/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import scala.None$;
import scala.Option;
import scala.Some;
import scala.reflect.io.Directory;
import scala.reflect.io.File;
import scala.reflect.io.File$;
import scala.reflect.io.Path;
import scala.reflect.io.Path$;
import scala.util.Properties$;

public final class Directory$ {
    public static Directory$ MODULE$;

    static {
        new Directory$();
    }

    private Some<Directory> normalizePath(String s) {
        return new Some<Directory>(this.apply(Path$.MODULE$.apply(s).normalize()));
    }

    public Option<Directory> Current() {
        String string = Properties$.MODULE$.userDir();
        String string2 = "";
        if (string != null && string.equals(string2)) {
            return None$.MODULE$;
        }
        return this.normalizePath(Properties$.MODULE$.userDir());
    }

    public Directory apply(Path path) {
        return path.toDirectory();
    }

    public Directory makeTemp(String prefix, String suffix, java.io.File dir) {
        File path = File$.MODULE$.makeTemp(prefix, suffix, dir);
        path.delete();
        return path.createDirectory(path.createDirectory$default$1(), path.createDirectory$default$2());
    }

    public String makeTemp$default$1() {
        return Path$.MODULE$.randomPrefix();
    }

    public String makeTemp$default$2() {
        return null;
    }

    public java.io.File makeTemp$default$3() {
        return null;
    }

    private Directory$() {
        MODULE$ = this;
    }
}

