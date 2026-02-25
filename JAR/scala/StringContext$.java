/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.StringContext;
import scala.collection.Seq;
import scala.collection.immutable.StringOps$;

public final class StringContext$
implements Serializable {
    public static StringContext$ MODULE$;

    static {
        new StringContext$();
    }

    public String treatEscapes(String str) {
        return this.treatEscapes0(str, false);
    }

    public String processEscapes(String str) {
        return this.treatEscapes0(str, true);
    }

    private String treatEscapes0(String str, boolean strict) {
        int len = str.length();
        int n = str.indexOf(92);
        switch (n) {
            case -1: {
                return str;
            }
        }
        return this.replace$1(n, str, len, strict);
    }

    public StringContext apply(Seq<String> parts) {
        return new StringContext(parts);
    }

    public Option<Seq<String>> unapplySeq(StringContext x$0) {
        if (x$0 == null) {
            return None$.MODULE$;
        }
        return new Some<Seq<String>>(x$0.parts());
    }

    private Object readResolve() {
        return MODULE$;
    }

    private final String loop$1(int i, int next, StringBuilder b$1, String str$1, int len$1, boolean strict$1) {
        while (next >= 0) {
            char c;
            int idx;
            if (next > i) {
                b$1.append(str$1, i, next);
            }
            if ((idx = next + 1) >= len$1) {
                throw new StringContext.InvalidEscapeException(str$1, next);
            }
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            char c2 = StringOps$.MODULE$.apply$extension(str$1, idx);
            switch (c2) {
                case 'b': {
                    c = '\b';
                    break;
                }
                case 't': {
                    c = '\t';
                    break;
                }
                case 'n': {
                    c = '\n';
                    break;
                }
                case 'f': {
                    c = '\f';
                    break;
                }
                case 'r': {
                    c = '\r';
                    break;
                }
                case '\"': {
                    c = '\"';
                    break;
                }
                case '\'': {
                    c = '\'';
                    break;
                }
                case '\\': {
                    c = '\\';
                    break;
                }
                default: {
                    if ('0' <= c2 && c2 <= '7') {
                        if (strict$1) {
                            throw new StringContext.InvalidEscapeException(str$1, next);
                        }
                        if (Predef$.MODULE$ == null) {
                            throw null;
                        }
                        char leadch = StringOps$.MODULE$.apply$extension(str$1, idx);
                        int oct = leadch - 48;
                        if (++idx < len$1) {
                            if (Predef$.MODULE$ == null) {
                                throw null;
                            }
                            if ('0' <= StringOps$.MODULE$.apply$extension(str$1, idx)) {
                                if (Predef$.MODULE$ == null) {
                                    throw null;
                                }
                                if (StringOps$.MODULE$.apply$extension(str$1, idx) <= '7') {
                                    if (Predef$.MODULE$ == null) {
                                        throw null;
                                    }
                                    oct = oct * 8 + StringOps$.MODULE$.apply$extension(str$1, idx) - 48;
                                    if (++idx < len$1 && leadch <= '3') {
                                        if (Predef$.MODULE$ == null) {
                                            throw null;
                                        }
                                        if ('0' <= StringOps$.MODULE$.apply$extension(str$1, idx)) {
                                            if (Predef$.MODULE$ == null) {
                                                throw null;
                                            }
                                            if (StringOps$.MODULE$.apply$extension(str$1, idx) <= '7') {
                                                if (Predef$.MODULE$ == null) {
                                                    throw null;
                                                }
                                                oct = oct * 8 + StringOps$.MODULE$.apply$extension(str$1, idx) - 48;
                                                ++idx;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        --idx;
                        c = (char)oct;
                        break;
                    }
                    throw new StringContext.InvalidEscapeException(str$1, next);
                }
            }
            char c3 = c;
            b$1.append(c3);
            next = str$1.indexOf(92, ++idx);
            i = idx;
        }
        if (i < len$1) {
            b$1.append(str$1, i, len$1);
        }
        return b$1.toString();
    }

    private final String replace$1(int first, String str$1, int len$1, boolean strict$1) {
        StringBuilder b = new StringBuilder();
        return this.loop$1(0, first, b, str$1, len$1, strict$1);
    }

    private StringContext$() {
        MODULE$ = this;
    }
}

