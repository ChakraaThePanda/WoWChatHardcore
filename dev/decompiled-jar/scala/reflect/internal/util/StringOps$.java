/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.Option;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.reflect.internal.util.StringOps;

public final class StringOps$
implements StringOps {
    public static StringOps$ MODULE$;

    static {
        new StringOps$();
    }

    @Override
    public Seq<String> oempty(Seq<String> xs) {
        return StringOps.oempty$(this, xs);
    }

    @Override
    public String ojoin(Seq<String> xs) {
        return StringOps.ojoin$(this, xs);
    }

    @Override
    public String longestCommonPrefix(List<String> xs) {
        return StringOps.longestCommonPrefix$(this, xs);
    }

    @Override
    public String trimTrailingSpace(String s) {
        return StringOps.trimTrailingSpace$(this, s);
    }

    @Override
    public String trimAllTrailingSpace(String s) {
        return StringOps.trimAllTrailingSpace$(this, s);
    }

    @Override
    public List<String> decompose(String str, char sep) {
        return StringOps.decompose$(this, str, sep);
    }

    @Override
    public List<String> words(String str) {
        return StringOps.words$(this, str);
    }

    @Override
    public Option<Tuple2<String, String>> splitWhere(String str, Function1<Object, Object> f, boolean doDropIndex) {
        return StringOps.splitWhere$(this, str, f, doDropIndex);
    }

    @Override
    public boolean splitWhere$default$3() {
        return StringOps.splitWhere$default$3$(this);
    }

    @Override
    public Option<Tuple2<String, String>> splitAt(String str, int idx, boolean doDropIndex) {
        return StringOps.splitAt$(this, str, idx, doDropIndex);
    }

    @Override
    public boolean splitAt$default$3() {
        return StringOps.splitAt$default$3$(this);
    }

    @Override
    public String countElementsAsString(int n, String element) {
        return StringOps.countElementsAsString$(this, n, element);
    }

    @Override
    public String countAsString(int n) {
        return StringOps.countAsString$(this, n);
    }

    private StringOps$() {
        MODULE$ = this;
        StringOps.$init$(this);
    }
}

