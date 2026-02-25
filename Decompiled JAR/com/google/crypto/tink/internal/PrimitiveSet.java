/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.internal;

import com.google.crypto.tink.CryptoFormat;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.KeysetHandleInterface;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public final class PrimitiveSet<P> {
    private final Map<Bytes, List<Entry<P>>> entries;
    private final List<Entry<P>> entriesInKeysetOrder;
    private final Entry<P> primary;
    private final Class<P> primitiveClass;
    private final MonitoringAnnotations annotations;
    private final PrimitiveConstructor.PrimitiveConstructionFunction<Key, P> primitiveConstructionFunction;

    private static <P> void storeEntryInPrimitiveSet(Entry<P> entry, Map<Bytes, List<Entry<P>>> entries, List<Entry<P>> entriesInKeysetOrder) {
        ArrayList<Entry<P>> list = new ArrayList<Entry<P>>();
        list.add(entry);
        List existing = entries.put(entry.getOutputPrefix(), Collections.unmodifiableList(list));
        if (existing != null) {
            ArrayList newList = new ArrayList();
            newList.addAll(existing);
            newList.add(entry);
            entries.put(entry.getOutputPrefix(), Collections.unmodifiableList(newList));
        }
        entriesInKeysetOrder.add(entry);
    }

    @Nullable
    Entry<P> getPrimary() {
        return this.primary;
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    public KeysetHandleInterface getKeysetHandle() {
        return new KeysetHandleImpl();
    }

    public P getPrimitiveForEntry(KeysetHandleInterface.Entry entry) throws GeneralSecurityException {
        return this.primitiveConstructionFunction.constructPrimitive(entry.getKey());
    }

    Collection<List<Entry<P>>> getAll() {
        return this.entries.values();
    }

    List<Entry<P>> getAllInKeysetOrder() {
        return Collections.unmodifiableList(this.entriesInKeysetOrder);
    }

    private PrimitiveSet(Map<Bytes, List<Entry<P>>> entries, List<Entry<P>> entriesInKeysetOrder, Entry<P> primary, MonitoringAnnotations annotations, PrimitiveConstructor.PrimitiveConstructionFunction<Key, P> primitiveConstructionFunction, Class<P> primitiveClass) {
        this.entries = entries;
        this.entriesInKeysetOrder = entriesInKeysetOrder;
        this.primary = primary;
        this.primitiveConstructionFunction = primitiveConstructionFunction;
        this.primitiveClass = primitiveClass;
        this.annotations = annotations;
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public static <P> Builder<P> newBuilder(Class<P> primitiveClass) {
        return new Builder(primitiveClass);
    }

    public static class Builder<P> {
        private final Class<P> primitiveClass;
        private Map<Bytes, List<Entry<P>>> entries = new HashMap<Bytes, List<Entry<P>>>();
        private final List<Entry<P>> entriesInKeysetOrder = new ArrayList<Entry<P>>();
        private Entry<P> primary;
        private MonitoringAnnotations annotations;
        private PrimitiveConstructor.PrimitiveConstructionFunction<Key, P> primitiveConstructionFunction = key -> {
            throw new GeneralSecurityException("No PrimitiveConstructionFunction specified");
        };

        @CanIgnoreReturnValue
        private Builder<P> addEntry(Key key, Keyset.Key protoKey, boolean asPrimary) throws GeneralSecurityException {
            if (this.entries == null) {
                throw new IllegalStateException("addEntry cannot be called after build");
            }
            if (protoKey.getStatus() != KeyStatusType.ENABLED) {
                throw new GeneralSecurityException("only ENABLED key is allowed");
            }
            Entry entry = new Entry(Bytes.copyFrom(CryptoFormat.getOutputPrefix(protoKey)), KeyStatus.ENABLED, protoKey.getKeyId(), key, asPrimary);
            PrimitiveSet.storeEntryInPrimitiveSet(entry, this.entries, this.entriesInKeysetOrder);
            if (asPrimary) {
                if (this.primary != null) {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
                this.primary = entry;
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<P> add(Key key, Keyset.Key protoKey) throws GeneralSecurityException {
            return this.addEntry(key, protoKey, false);
        }

        @CanIgnoreReturnValue
        public Builder<P> addPrimary(Key key, Keyset.Key protoKey) throws GeneralSecurityException {
            return this.addEntry(key, protoKey, true);
        }

        @CanIgnoreReturnValue
        public Builder<P> setAnnotations(MonitoringAnnotations annotations) {
            if (this.entries == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build");
            }
            this.annotations = annotations;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<P> addPrimitiveConstructor(PrimitiveConstructor.PrimitiveConstructionFunction<Key, P> primitiveConstructionFunction) {
            this.primitiveConstructionFunction = primitiveConstructionFunction;
            return this;
        }

        public PrimitiveSet<P> build() throws GeneralSecurityException {
            if (this.entries == null) {
                throw new IllegalStateException("build cannot be called twice");
            }
            PrimitiveSet output = new PrimitiveSet(this.entries, this.entriesInKeysetOrder, this.primary, this.annotations, this.primitiveConstructionFunction, this.primitiveClass);
            this.entries = null;
            return output;
        }

        private Builder(Class<P> primitiveClass) {
            this.primitiveClass = primitiveClass;
            this.annotations = MonitoringAnnotations.EMPTY;
        }
    }

    private class KeysetHandleImpl
    implements KeysetHandleInterface {
        private KeysetHandleImpl() {
        }

        @Override
        public KeysetHandleInterface.Entry getPrimary() {
            return PrimitiveSet.this.primary;
        }

        @Override
        public int size() {
            return PrimitiveSet.this.entriesInKeysetOrder.size();
        }

        @Override
        public KeysetHandleInterface.Entry getAt(int i) {
            return (KeysetHandleInterface.Entry)PrimitiveSet.this.entriesInKeysetOrder.get(i);
        }
    }

    public static final class Entry<P>
    implements KeysetHandleInterface.Entry {
        private final Bytes outputPrefix;
        private final KeyStatus status;
        private final int keyId;
        private final Key key;
        private final boolean isPrimary;

        private Entry(Bytes outputPrefix, KeyStatus status, int keyId, Key key, boolean isPrimary) {
            this.outputPrefix = outputPrefix;
            this.status = status;
            this.keyId = keyId;
            this.key = key;
            this.isPrimary = isPrimary;
        }

        @Override
        public KeyStatus getStatus() {
            return this.status;
        }

        final Bytes getOutputPrefix() {
            return this.outputPrefix;
        }

        @Override
        public int getId() {
            return this.keyId;
        }

        @Override
        public Key getKey() {
            return this.key;
        }

        @Nullable
        public Parameters getParameters() {
            if (this.key == null) {
                return null;
            }
            return this.key.getParameters();
        }

        @Override
        public boolean isPrimary() {
            return this.isPrimary;
        }
    }
}

