/*
 * Decompiled with CFR 0.152.
 */
package gnu.trove.iterator;

import gnu.trove.iterator.TIterator;

public interface TPrimitiveIterator
extends TIterator {
    @Override
    public boolean hasNext();

    @Override
    public void remove();
}

