/*
 * Decompiled with CFR 0.152.
 */
package com.vdurmont.emoji;

import com.vdurmont.emoji.Emoji;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class EmojiTrie {
    private final Node root = new Node();
    final int maxDepth;

    public EmojiTrie(Collection<Emoji> emojis) {
        int maxDepth = 0;
        for (Emoji emoji : emojis) {
            Node tree = this.root;
            char[] chars = emoji.getUnicode().toCharArray();
            maxDepth = Math.max(maxDepth, chars.length);
            for (char c : chars) {
                if (!tree.hasChild(c)) {
                    tree.addChild(c);
                }
                tree = tree.getChild(c);
            }
            tree.setEmoji(emoji);
        }
        this.maxDepth = maxDepth;
    }

    public Matches isEmoji(char[] sequence2) {
        return this.isEmoji(sequence2, 0, sequence2.length);
    }

    public Matches isEmoji(char[] sequence2, int start, int end) {
        if (start < 0 || start > end || end > sequence2.length) {
            throw new ArrayIndexOutOfBoundsException("start " + start + ", end " + end + ", length " + sequence2.length);
        }
        if (sequence2 == null) {
            return Matches.POSSIBLY;
        }
        Node tree = this.root;
        for (int i = start; i < end; ++i) {
            if (!tree.hasChild(sequence2[i])) {
                return Matches.IMPOSSIBLE;
            }
            tree = tree.getChild(sequence2[i]);
        }
        return tree.isEndOfEmoji() ? Matches.EXACTLY : Matches.POSSIBLY;
    }

    public Emoji getEmoji(String unicode) {
        return this.getEmoji(unicode.toCharArray(), 0, unicode.length());
    }

    Emoji getEmoji(char[] sequence2, int start, int end) {
        if (start < 0 || start > end || end > sequence2.length) {
            throw new ArrayIndexOutOfBoundsException("start " + start + ", end " + end + ", length " + sequence2.length);
        }
        Node tree = this.root;
        for (int i = 0; i < end; ++i) {
            if (!tree.hasChild(sequence2[i])) {
                return null;
            }
            tree = tree.getChild(sequence2[i]);
        }
        return tree.getEmoji();
    }

    private class Node {
        private Map<Character, Node> children = new HashMap<Character, Node>();
        private Emoji emoji;

        private Node() {
        }

        private void setEmoji(Emoji emoji) {
            this.emoji = emoji;
        }

        private Emoji getEmoji() {
            return this.emoji;
        }

        private boolean hasChild(char child) {
            return this.children.containsKey(Character.valueOf(child));
        }

        private void addChild(char child) {
            this.children.put(Character.valueOf(child), new Node());
        }

        private Node getChild(char child) {
            return this.children.get(Character.valueOf(child));
        }

        private boolean isEndOfEmoji() {
            return this.emoji != null;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum Matches {
        EXACTLY,
        POSSIBLY,
        IMPOSSIBLE;


        public boolean exactMatch() {
            return this == EXACTLY;
        }

        public boolean impossibleMatch() {
            return this == IMPOSSIBLE;
        }
    }
}

