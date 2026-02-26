/*
 * Decompiled with CFR 0.152.
 */
package com.vdurmont.emoji;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiLoader;
import com.vdurmont.emoji.EmojiParser;
import com.vdurmont.emoji.EmojiTrie;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class EmojiManager {
    private static final String PATH = "/emojis.json";
    private static final Map<String, Emoji> EMOJIS_BY_ALIAS = new HashMap<String, Emoji>();
    private static final Map<String, Set<Emoji>> EMOJIS_BY_TAG = new HashMap<String, Set<Emoji>>();
    private static final List<Emoji> ALL_EMOJIS;
    static final EmojiTrie EMOJI_TRIE;

    private EmojiManager() {
    }

    public static Set<Emoji> getForTag(String tag) {
        if (tag == null) {
            return null;
        }
        return EMOJIS_BY_TAG.get(tag);
    }

    public static Emoji getForAlias(String alias) {
        if (alias == null || alias.isEmpty()) {
            return null;
        }
        return EMOJIS_BY_ALIAS.get(EmojiManager.trimAlias(alias));
    }

    private static String trimAlias(String alias) {
        int len = alias.length();
        return alias.substring(alias.charAt(0) == ':' ? 1 : 0, alias.charAt(len - 1) == ':' ? len - 1 : len);
    }

    public static Emoji getByUnicode(String unicode) {
        if (unicode == null) {
            return null;
        }
        return EMOJI_TRIE.getEmoji(unicode);
    }

    public static Collection<Emoji> getAll() {
        return ALL_EMOJIS;
    }

    public static boolean isEmoji(String string) {
        if (string == null) {
            return false;
        }
        EmojiParser.UnicodeCandidate unicodeCandidate = EmojiParser.getNextUnicodeCandidate(string.toCharArray(), 0);
        return unicodeCandidate != null && unicodeCandidate.getEmojiStartIndex() == 0 && unicodeCandidate.getFitzpatrickEndIndex() == string.length();
    }

    public static boolean containsEmoji(String string) {
        if (string == null) {
            return false;
        }
        return EmojiParser.getNextUnicodeCandidate(string.toCharArray(), 0) != null;
    }

    public static boolean isOnlyEmojis(String string) {
        return string != null && EmojiParser.removeAllEmojis(string).isEmpty();
    }

    public static EmojiTrie.Matches isEmoji(char[] sequence2) {
        return EMOJI_TRIE.isEmoji(sequence2);
    }

    public static Collection<String> getAllTags() {
        return EMOJIS_BY_TAG.keySet();
    }

    static {
        try {
            InputStream stream = EmojiLoader.class.getResourceAsStream(PATH);
            List<Emoji> emojis = EmojiLoader.loadEmojis(stream);
            ALL_EMOJIS = emojis;
            for (Emoji emoji : emojis) {
                for (String tag : emoji.getTags()) {
                    if (EMOJIS_BY_TAG.get(tag) == null) {
                        EMOJIS_BY_TAG.put(tag, new HashSet());
                    }
                    EMOJIS_BY_TAG.get(tag).add(emoji);
                }
                for (String alias : emoji.getAliases()) {
                    EMOJIS_BY_ALIAS.put(alias, emoji);
                }
            }
            EMOJI_TRIE = new EmojiTrie(emojis);
            Collections.sort(ALL_EMOJIS, new Comparator<Emoji>(){

                @Override
                public int compare(Emoji e1, Emoji e2) {
                    return e2.getUnicode().length() - e1.getUnicode().length();
                }
            });
            stream.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

