/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.convert.ToJavaImplicits;
import scala.collection.mutable.Buffer;

public final class ImplicitConversionsToJava$
implements ToJavaImplicits {
    public static ImplicitConversionsToJava$ MODULE$;

    static {
        new ImplicitConversionsToJava$();
    }

    @Override
    public <A> java.util.Iterator<A> iterator$u0020asJava(Iterator<A> it) {
        return ToJavaImplicits.iterator$u0020asJava$(this, it);
    }

    @Override
    public <A> Enumeration<A> enumeration$u0020asJava(Iterator<A> it) {
        return ToJavaImplicits.enumeration$u0020asJava$(this, it);
    }

    @Override
    public <A> java.lang.Iterable<A> iterable$u0020asJava(Iterable<A> i) {
        return ToJavaImplicits.iterable$u0020asJava$(this, i);
    }

    @Override
    public <A> Collection<A> collection$u0020asJava(Iterable<A> it) {
        return ToJavaImplicits.collection$u0020asJava$(this, it);
    }

    @Override
    public <A> List<A> buffer$u0020AsJavaList(Buffer<A> b) {
        return ToJavaImplicits.buffer$u0020AsJavaList$(this, b);
    }

    @Override
    public <A> List<A> mutableSeq$u0020AsJavaList(scala.collection.mutable.Seq<A> seq) {
        return ToJavaImplicits.mutableSeq$u0020AsJavaList$(this, seq);
    }

    @Override
    public <A> List<A> seq$u0020AsJavaList(Seq<A> seq) {
        return ToJavaImplicits.seq$u0020AsJavaList$(this, seq);
    }

    @Override
    public <A> java.util.Set<A> mutableSet$u0020AsJavaSet(scala.collection.mutable.Set<A> s) {
        return ToJavaImplicits.mutableSet$u0020AsJavaSet$(this, s);
    }

    @Override
    public <A> java.util.Set<A> set$u0020AsJavaSet(Set<A> s) {
        return ToJavaImplicits.set$u0020AsJavaSet$(this, s);
    }

    @Override
    public <A, B> java.util.Map<A, B> mutableMap$u0020AsJavaMap(scala.collection.mutable.Map<A, B> m) {
        return ToJavaImplicits.mutableMap$u0020AsJavaMap$(this, m);
    }

    @Override
    public <A, B> Dictionary<A, B> dictionary$u0020asJava(scala.collection.mutable.Map<A, B> m) {
        return ToJavaImplicits.dictionary$u0020asJava$(this, m);
    }

    @Override
    public <A, B> java.util.Map<A, B> map$u0020AsJavaMap(Map<A, B> m) {
        return ToJavaImplicits.map$u0020AsJavaMap$(this, m);
    }

    @Override
    public <A, B> ConcurrentMap<A, B> map$u0020AsJavaConcurrentMap(scala.collection.concurrent.Map<A, B> m) {
        return ToJavaImplicits.map$u0020AsJavaConcurrentMap$(this, m);
    }

    private ImplicitConversionsToJava$() {
        MODULE$ = this;
        ToJavaImplicits.$init$(this);
    }
}

