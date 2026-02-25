/*
 * Decompiled with CFR 0.152.
 */
package com.vdurmont.emoji;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiTrie;
import com.vdurmont.emoji.Fitzpatrick;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class EmojiParser {
    public static String parseToAliases(String input) {
        return EmojiParser.parseToAliases(input, FitzpatrickAction.PARSE);
    }

    public static String parseToAliases(String input, final FitzpatrickAction fitzpatrickAction) {
        EmojiTransformer emojiTransformer = new EmojiTransformer(){

            public String transform(UnicodeCandidate unicodeCandidate) {
                switch (fitzpatrickAction) {
                    default: {
                        if (unicodeCandidate.hasFitzpatrick()) {
                            return ":" + unicodeCandidate.getEmoji().getAliases().get(0) + "|" + unicodeCandidate.getFitzpatrickType() + ":";
                        }
                    }
                    case REMOVE: {
                        return ":" + unicodeCandidate.getEmoji().getAliases().get(0) + ":";
                    }
                    case IGNORE: 
                }
                return ":" + unicodeCandidate.getEmoji().getAliases().get(0) + ":" + unicodeCandidate.getFitzpatrickUnicode();
            }
        };
        return EmojiParser.parseFromUnicode(input, emojiTransformer);
    }

    public static String replaceAllEmojis(String str, final String replacementString) {
        EmojiTransformer emojiTransformer = new EmojiTransformer(){

            public String transform(UnicodeCandidate unicodeCandidate) {
                return replacementString;
            }
        };
        return EmojiParser.parseFromUnicode(str, emojiTransformer);
    }

    public static String parseToUnicode(String input) {
        StringBuilder sb = new StringBuilder(input.length());
        for (int last = 0; last < input.length(); ++last) {
            AliasCandidate alias = EmojiParser.getAliasAt(input, last);
            if (alias == null) {
                alias = EmojiParser.getHtmlEncodedEmojiAt(input, last);
            }
            if (alias != null) {
                sb.append(alias.emoji.getUnicode());
                last = alias.endIndex;
                if (alias.fitzpatrick == null) continue;
                sb.append(alias.fitzpatrick.unicode);
                continue;
            }
            sb.append(input.charAt(last));
        }
        return sb.toString();
    }

    protected static AliasCandidate getAliasAt(String input, int start) {
        if (input.length() < start + 2 || input.charAt(start) != ':') {
            return null;
        }
        int aliasEnd = input.indexOf(58, start + 2);
        if (aliasEnd == -1) {
            return null;
        }
        int fitzpatrickStart = input.indexOf(124, start + 2);
        if (fitzpatrickStart != -1 && fitzpatrickStart < aliasEnd) {
            Emoji emoji = EmojiManager.getForAlias(input.substring(start, fitzpatrickStart));
            if (emoji == null) {
                return null;
            }
            if (!emoji.supportsFitzpatrick()) {
                return null;
            }
            Fitzpatrick fitzpatrick = Fitzpatrick.fitzpatrickFromType(input.substring(fitzpatrickStart + 1, aliasEnd));
            return new AliasCandidate(emoji, fitzpatrick, start, aliasEnd);
        }
        Emoji emoji = EmojiManager.getForAlias(input.substring(start, aliasEnd));
        if (emoji == null) {
            return null;
        }
        return new AliasCandidate(emoji, null, start, aliasEnd);
    }

    protected static AliasCandidate getHtmlEncodedEmojiAt(String input, int start) {
        int codePointEnd;
        if (input.length() < start + 4 || input.charAt(start) != '&' || input.charAt(start + 1) != '#') {
            return null;
        }
        Emoji longestEmoji = null;
        int longestCodePointEnd = -1;
        char[] chars = new char[EmojiManager.EMOJI_TRIE.maxDepth];
        int charsIndex = 0;
        int codePointStart = start;
        while ((codePointEnd = input.indexOf(59, codePointStart + 3)) != -1) {
            try {
                int radix = input.charAt(codePointStart + 2) == 'x' ? 16 : 10;
                int codePoint = Integer.parseInt(input.substring(codePointStart + 2 + radix / 16, codePointEnd), radix);
                charsIndex += Character.toChars(codePoint, chars, charsIndex);
            }
            catch (NumberFormatException e) {
                break;
            }
            catch (IllegalArgumentException e) {
                break;
            }
            Emoji foundEmoji = EmojiManager.EMOJI_TRIE.getEmoji(chars, 0, charsIndex);
            if (foundEmoji != null) {
                longestEmoji = foundEmoji;
                longestCodePointEnd = codePointEnd;
            }
            codePointStart = codePointEnd + 1;
            if (input.length() > codePointStart + 4 && input.charAt(codePointStart) == '&' && input.charAt(codePointStart + 1) == '#' && charsIndex < chars.length && !EmojiManager.EMOJI_TRIE.isEmoji(chars, 0, charsIndex).impossibleMatch()) continue;
        }
        if (longestEmoji == null) {
            return null;
        }
        return new AliasCandidate(longestEmoji, null, start, longestCodePointEnd);
    }

    public static String parseToHtmlDecimal(String input) {
        return EmojiParser.parseToHtmlDecimal(input, FitzpatrickAction.PARSE);
    }

    public static String parseToHtmlDecimal(String input, final FitzpatrickAction fitzpatrickAction) {
        EmojiTransformer emojiTransformer = new EmojiTransformer(){

            public String transform(UnicodeCandidate unicodeCandidate) {
                switch (fitzpatrickAction) {
                    default: {
                        return unicodeCandidate.getEmoji().getHtmlDecimal();
                    }
                    case IGNORE: 
                }
                return unicodeCandidate.getEmoji().getHtmlDecimal() + unicodeCandidate.getFitzpatrickUnicode();
            }
        };
        return EmojiParser.parseFromUnicode(input, emojiTransformer);
    }

    public static String parseToHtmlHexadecimal(String input) {
        return EmojiParser.parseToHtmlHexadecimal(input, FitzpatrickAction.PARSE);
    }

    public static String parseToHtmlHexadecimal(String input, final FitzpatrickAction fitzpatrickAction) {
        EmojiTransformer emojiTransformer = new EmojiTransformer(){

            public String transform(UnicodeCandidate unicodeCandidate) {
                switch (fitzpatrickAction) {
                    default: {
                        return unicodeCandidate.getEmoji().getHtmlHexadecimal();
                    }
                    case IGNORE: 
                }
                return unicodeCandidate.getEmoji().getHtmlHexadecimal() + unicodeCandidate.getFitzpatrickUnicode();
            }
        };
        return EmojiParser.parseFromUnicode(input, emojiTransformer);
    }

    public static String removeAllEmojis(String str) {
        EmojiTransformer emojiTransformer = new EmojiTransformer(){

            public String transform(UnicodeCandidate unicodeCandidate) {
                return "";
            }
        };
        return EmojiParser.parseFromUnicode(str, emojiTransformer);
    }

    public static String removeEmojis(String str, final Collection<Emoji> emojisToRemove) {
        EmojiTransformer emojiTransformer = new EmojiTransformer(){

            public String transform(UnicodeCandidate unicodeCandidate) {
                if (!emojisToRemove.contains(unicodeCandidate.getEmoji())) {
                    return unicodeCandidate.getEmoji().getUnicode() + unicodeCandidate.getFitzpatrickUnicode();
                }
                return "";
            }
        };
        return EmojiParser.parseFromUnicode(str, emojiTransformer);
    }

    public static String removeAllEmojisExcept(String str, final Collection<Emoji> emojisToKeep) {
        EmojiTransformer emojiTransformer = new EmojiTransformer(){

            public String transform(UnicodeCandidate unicodeCandidate) {
                if (emojisToKeep.contains(unicodeCandidate.getEmoji())) {
                    return unicodeCandidate.getEmoji().getUnicode() + unicodeCandidate.getFitzpatrickUnicode();
                }
                return "";
            }
        };
        return EmojiParser.parseFromUnicode(str, emojiTransformer);
    }

    public static String parseFromUnicode(String input, EmojiTransformer transformer) {
        int prev = 0;
        StringBuilder sb = new StringBuilder(input.length());
        List<UnicodeCandidate> replacements = EmojiParser.getUnicodeCandidates(input);
        for (UnicodeCandidate candidate : replacements) {
            sb.append(input, prev, candidate.getEmojiStartIndex());
            sb.append(transformer.transform(candidate));
            prev = candidate.getFitzpatrickEndIndex();
        }
        return sb.append(input.substring(prev)).toString();
    }

    public static List<String> extractEmojis(String input) {
        List<UnicodeCandidate> emojis = EmojiParser.getUnicodeCandidates(input);
        ArrayList<String> result2 = new ArrayList<String>();
        for (UnicodeCandidate emoji : emojis) {
            if (emoji.getEmoji().supportsFitzpatrick() && emoji.hasFitzpatrick()) {
                result2.add(emoji.getEmoji().getUnicode(emoji.getFitzpatrick()));
                continue;
            }
            result2.add(emoji.getEmoji().getUnicode());
        }
        return result2;
    }

    protected static List<UnicodeCandidate> getUnicodeCandidates(String input) {
        UnicodeCandidate next;
        char[] inputCharArray = input.toCharArray();
        ArrayList<UnicodeCandidate> candidates = new ArrayList<UnicodeCandidate>();
        int i = 0;
        while ((next = EmojiParser.getNextUnicodeCandidate(inputCharArray, i)) != null) {
            candidates.add(next);
            i = next.getFitzpatrickEndIndex();
        }
        return candidates;
    }

    protected static UnicodeCandidate getNextUnicodeCandidate(char[] chars, int start) {
        for (int i = start; i < chars.length; ++i) {
            int emojiEnd = EmojiParser.getEmojiEndPos(chars, i);
            if (emojiEnd == -1) continue;
            Emoji emoji = EmojiManager.getByUnicode(new String(chars, i, emojiEnd - i));
            String fitzpatrickString = emojiEnd + 2 <= chars.length ? new String(chars, emojiEnd, 2) : null;
            return new UnicodeCandidate(emoji, fitzpatrickString, i);
        }
        return null;
    }

    protected static int getEmojiEndPos(char[] text, int startPos) {
        int best = -1;
        for (int j = startPos + 1; j <= text.length; ++j) {
            EmojiTrie.Matches status = EmojiManager.EMOJI_TRIE.isEmoji(text, startPos, j);
            if (status.exactMatch()) {
                best = j;
                continue;
            }
            if (!status.impossibleMatch()) continue;
            return best;
        }
        return best;
    }

    public static interface EmojiTransformer {
        public String transform(UnicodeCandidate var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum FitzpatrickAction {
        PARSE,
        REMOVE,
        IGNORE;

    }

    protected static class AliasCandidate {
        public final Emoji emoji;
        public final Fitzpatrick fitzpatrick;
        public final int startIndex;
        public final int endIndex;

        private AliasCandidate(Emoji emoji, Fitzpatrick fitzpatrick, int startIndex, int endIndex) {
            this.emoji = emoji;
            this.fitzpatrick = fitzpatrick;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public static class UnicodeCandidate {
        private final Emoji emoji;
        private final Fitzpatrick fitzpatrick;
        private final int startIndex;

        private UnicodeCandidate(Emoji emoji, String fitzpatrick, int startIndex) {
            this.emoji = emoji;
            this.fitzpatrick = Fitzpatrick.fitzpatrickFromUnicode(fitzpatrick);
            this.startIndex = startIndex;
        }

        public Emoji getEmoji() {
            return this.emoji;
        }

        public boolean hasFitzpatrick() {
            return this.getFitzpatrick() != null;
        }

        public Fitzpatrick getFitzpatrick() {
            return this.fitzpatrick;
        }

        public String getFitzpatrickType() {
            return this.hasFitzpatrick() ? this.fitzpatrick.name().toLowerCase() : "";
        }

        public String getFitzpatrickUnicode() {
            return this.hasFitzpatrick() ? this.fitzpatrick.unicode : "";
        }

        public int getEmojiStartIndex() {
            return this.startIndex;
        }

        public int getEmojiEndIndex() {
            return this.startIndex + this.emoji.getUnicode().length();
        }

        public int getFitzpatrickEndIndex() {
            return this.getEmojiEndIndex() + (this.fitzpatrick != null ? 2 : 0);
        }
    }
}

