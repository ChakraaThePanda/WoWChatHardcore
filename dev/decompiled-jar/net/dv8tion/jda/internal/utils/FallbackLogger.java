/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.utils;

import java.time.LocalDateTime;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.helpers.MessageFormatter;

public class FallbackLogger
extends LegacyAbstractLogger {
    private final String name;

    public FallbackLogger(String name) {
        this.name = name;
    }

    @Override
    protected String getFullyQualifiedCallerName() {
        return null;
    }

    @Override
    protected void handleNormalizedLoggingCall(Level level, Marker marker, String messagePattern, Object[] arguments, Throwable throwable) {
        LocalDateTime now = LocalDateTime.now();
        FormattingTuple result2 = MessageFormatter.arrayFormat(messagePattern, arguments);
        System.err.printf("%1$tF %1$tT [%2$s] [%3$s] %4$s%n", new Object[]{now, this.name, level, result2.getMessage()});
        if (throwable != null) {
            throwable.printStackTrace(System.err);
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }
}

