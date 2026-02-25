/*
 * Decompiled with CFR 0.152.
 */
package gnu.trove.impl.sync;

import gnu.trove.impl.sync.TSynchronizedCharCollection;
import gnu.trove.set.TCharSet;

public class TSynchronizedCharSet
extends TSynchronizedCharCollection
implements TCharSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedCharSet(TCharSet s) {
        super(s);
    }

    public TSynchronizedCharSet(TCharSet s, Object mutex) {
        super(s, mutex);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean equals(Object o) {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.equals(o);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int hashCode() {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.hashCode();
        }
    }
}

