/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.List;

final class ApplicationProtocolUtil {
    private static final int DEFAULT_LIST_SIZE = 2;

    private ApplicationProtocolUtil() {
    }

    static List<String> toList(Iterable<String> protocols) {
        return ApplicationProtocolUtil.toList(2, protocols);
    }

    static List<String> toList(int initialListSize, Iterable<String> protocols) {
        if (protocols == null) {
            return null;
        }
        ArrayList<String> result2 = new ArrayList<String>(initialListSize);
        for (String p : protocols) {
            result2.add(ObjectUtil.checkNonEmpty(p, "p"));
        }
        return ObjectUtil.checkNonEmpty(result2, "result");
    }

    static List<String> toList(String ... protocols) {
        return ApplicationProtocolUtil.toList(2, protocols);
    }

    static List<String> toList(int initialListSize, String ... protocols) {
        if (protocols == null) {
            return null;
        }
        ArrayList<String> result2 = new ArrayList<String>(initialListSize);
        for (String p : protocols) {
            result2.add(ObjectUtil.checkNonEmpty(p, "p"));
        }
        return ObjectUtil.checkNonEmpty(result2, "result");
    }
}

