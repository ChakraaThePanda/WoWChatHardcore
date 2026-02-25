/*
 * Decompiled with CFR 0.152.
 */
package scala.util.matching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.GenTraversable;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.util.matching.Regex;

public final class Regex$
implements Serializable {
    public static Regex$ MODULE$;

    static {
        new Regex$();
    }

    public Option<List<String>> scala$util$matching$Regex$$extractGroupsFromMatch(Regex.Match m) {
        List<String> res = List$.MODULE$.empty();
        for (int index = m.groupCount(); index > 0; --index) {
            res = res.$colon$colon(m.group(index));
        }
        return new Some<GenTraversable>(res);
    }

    public Option<List<String>> scala$util$matching$Regex$$extractGroupsFromMatcher(Matcher m) {
        List<String> res = List$.MODULE$.empty();
        for (int index = m.groupCount(); index > 0; --index) {
            res = res.$colon$colon(m.group(index));
        }
        return new Some<GenTraversable>(res);
    }

    public String quote(String text) {
        return Pattern.quote(text);
    }

    public String quoteReplacement(String text) {
        return Matcher.quoteReplacement(text);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private Regex$() {
        MODULE$ = this;
    }
}

