/*
 * Decompiled with CFR 0.152.
 */
package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UnknownFieldSet;

public final class LegacyUnredactedTextFormat {
    private LegacyUnredactedTextFormat() {
    }

    static String legacyUnredactedMultilineString(MessageOrBuilder message) {
        return TextFormat.printer().printToString(message);
    }

    static String legacyUnredactedMultilineString(UnknownFieldSet fields) {
        return TextFormat.printer().printToString(fields);
    }

    static String legacyUnredactedSingleLineString(MessageOrBuilder message) {
        return TextFormat.printer().emittingSingleLine(true).printToString(message);
    }

    static String legacyUnredactedSingleLineString(UnknownFieldSet fields) {
        return TextFormat.printer().emittingSingleLine(true).printToString(fields);
    }
}

