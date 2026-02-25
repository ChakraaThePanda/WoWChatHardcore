/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import net.dv8tion.jda.internal.utils.Checks;

public class SplitUtil {
    @Nonnull
    public static List<String> split(@Nonnull String input, int limit, Strategy ... strategies) {
        return SplitUtil.split(input, limit, false, strategies);
    }

    @Nonnull
    public static List<String> split(@Nonnull String input, int limit, boolean trim, Strategy ... strategies) {
        Checks.notNull(input, "Input string");
        if (input.isEmpty() || input.length() <= limit) {
            return Collections.singletonList(input);
        }
        if (strategies.length == 0) {
            strategies = new Strategy[]{Strategy.ANYWHERE};
        }
        int offset = 0;
        LinkedList<String> chunks = new LinkedList<String>();
        while (offset < input.length()) {
            String chunk = null;
            if (input.length() - offset <= limit) {
                chunk = input.substring(offset);
                offset = input.length();
            } else {
                for (Strategy strategy : strategies) {
                    int newOffset = strategy.apply(input, offset, limit);
                    if (newOffset <= offset) continue;
                    newOffset = Math.min(newOffset, input.length());
                    chunk = input.substring(offset, newOffset);
                    offset = newOffset;
                    break;
                }
            }
            if (chunk == null) {
                throw new IllegalStateException("None of the strategies successfully split the string. Try adding Strategy.ANYWHERE to the end of your strategy list.");
            }
            if (trim) {
                chunk = chunk.trim();
            }
            if (chunk.isEmpty()) continue;
            chunks.add(chunk);
        }
        return chunks;
    }

    public static interface Strategy {
        public static final Strategy ANYWHERE = (string, offset, limit) -> offset + limit;
        public static final Strategy NEWLINE = Strategy.onChar('\n');
        public static final Strategy WHITESPACE = Strategy.onChar(Character::isWhitespace);

        public int apply(@Nonnull String var1, int var2, int var3);

        @Nonnull
        public static Strategy onChar(char c) {
            return (string, offset, limit) -> string.lastIndexOf(c, offset + limit);
        }

        @Nonnull
        public static Strategy onChar(@Nonnull Predicate<Character> predicate) {
            Checks.notNull(predicate, "Predicate");
            return (string, offset, limit) -> {
                for (int i = offset + limit; i > offset; --i) {
                    if (!predicate.test(Character.valueOf(string.charAt(i)))) continue;
                    return i;
                }
                return -1;
            };
        }
    }
}

