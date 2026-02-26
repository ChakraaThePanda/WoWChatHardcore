/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.concurrent.INodeBase;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.TrieMap;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.MutableMapFactory;
import scala.runtime.Nothing$;

public final class TrieMap$
extends MutableMapFactory<TrieMap>
implements Serializable {
    public static TrieMap$ MODULE$;
    private final AtomicReferenceFieldUpdater<INodeBase<?, ?>, MainNode<?, ?>> inodeupdater;
    private final GenMapFactory.MapCanBuildFrom<Nothing$, Nothing$> ReusableCBF;

    static {
        new TrieMap$();
    }

    public AtomicReferenceFieldUpdater<INodeBase<?, ?>, MainNode<?, ?>> inodeupdater() {
        return this.inodeupdater;
    }

    public <K, V> CanBuildFrom<TrieMap<?, ?>, Tuple2<K, V>, TrieMap<K, V>> canBuildFrom() {
        return this.ReusableCBF;
    }

    @Override
    public <K, V> TrieMap<K, V> empty() {
        return new TrieMap();
    }

    private Object readResolve() {
        return MODULE$;
    }

    private TrieMap$() {
        MODULE$ = this;
        this.inodeupdater = AtomicReferenceFieldUpdater.newUpdater(INodeBase.class, MainNode.class, "mainnode");
        this.ReusableCBF = new GenMapFactory.MapCanBuildFrom(this);
    }
}

