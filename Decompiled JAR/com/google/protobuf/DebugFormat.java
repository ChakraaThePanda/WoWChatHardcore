/*
 * Decompiled with CFR 0.152.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UnknownFieldSet;

public final class DebugFormat {
    private final boolean isSingleLine;

    private DebugFormat(boolean singleLine) {
        this.isSingleLine = singleLine;
    }

    public static DebugFormat singleLine() {
        return new DebugFormat(true);
    }

    public static DebugFormat multiline() {
        return new DebugFormat(false);
    }

    public String toString(MessageOrBuilder message) {
        return TextFormat.printer().emittingSingleLine(this.isSingleLine).enablingSafeDebugFormat(true).printToString(message);
    }

    public String toString(Descriptors.FieldDescriptor field2, Object value) {
        return TextFormat.printer().emittingSingleLine(this.isSingleLine).enablingSafeDebugFormat(true).printFieldToString(field2, value);
    }

    public String toString(UnknownFieldSet fields) {
        return TextFormat.printer().emittingSingleLine(this.isSingleLine).enablingSafeDebugFormat(true).printToString(fields);
    }

    public Object lazyToString(MessageOrBuilder message) {
        return new LazyDebugOutput(message, this);
    }

    public Object lazyToString(UnknownFieldSet fields) {
        return new LazyDebugOutput(fields, this);
    }

    private static class LazyDebugOutput {
        private final MessageOrBuilder message;
        private final UnknownFieldSet fields;
        private final DebugFormat format;

        LazyDebugOutput(MessageOrBuilder message, DebugFormat format) {
            this.message = message;
            this.fields = null;
            this.format = format;
        }

        LazyDebugOutput(UnknownFieldSet fields, DebugFormat format) {
            this.message = null;
            this.fields = fields;
            this.format = format;
        }

        public String toString() {
            if (this.message != null) {
                return this.format.toString(this.message);
            }
            return this.format.toString(this.fields);
        }
    }
}

