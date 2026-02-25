/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public final class InternCache
extends ConcurrentHashMap<String, String> {
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_MAX_ENTRIES = 280;
    public static final InternCache instance = new InternCache();
    private final ReentrantLock lock = new ReentrantLock();

    public InternCache() {
        this(280, 0.8f, 4);
    }

    public InternCache(int maxSize, float loadFactor, int concurrency) {
        super(maxSize, loadFactor, concurrency);
    }

    public String intern(String input) {
        String result2 = (String)this.get(input);
        if (result2 != null) {
            return result2;
        }
        if (this.size() >= 280 && this.lock.tryLock()) {
            try {
                if (this.size() >= 280) {
                    this.clear();
                }
            }
            finally {
                this.lock.unlock();
            }
        }
        result2 = input.intern();
        this.put(result2, result2);
        return result2;
    }
}

