/*
 * Decompiled with CFR 0.152.
 */
package com.google.crypto.tink.internal;

import com.google.crypto.tink.internal.MonitoringClient;

public final class MonitoringUtil {
    public static final MonitoringClient.Logger DO_NOTHING_LOGGER = new DoNothingLogger();

    private MonitoringUtil() {
    }

    private static class DoNothingLogger
    implements MonitoringClient.Logger {
        private DoNothingLogger() {
        }

        @Override
        public void log(int keyId, long numBytesAsInput) {
        }

        @Override
        public void logFailure() {
        }
    }
}

