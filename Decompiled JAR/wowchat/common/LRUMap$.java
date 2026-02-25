/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Serializable;
import scala.collection.mutable.Map;
import wowchat.common.LRUMap;

public final class LRUMap$
implements Serializable {
    public static LRUMap$ MODULE$;

    static {
        new LRUMap$();
    }

    public <K, V> Map<K, V> empty() {
        return this.empty(10000);
    }

    public <K, V> Map<K, V> empty(int maxSize) {
        return new LRUMap(maxSize);
    }

    private Object readResolve() {
        return MODULE$;
    }

    private LRUMap$() {
        MODULE$ = this;
    }
}

