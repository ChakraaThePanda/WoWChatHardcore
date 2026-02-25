/*
 * Decompiled with CFR 0.152.
 */
package com.vdurmont.emoji;

import com.vdurmont.emoji.Fitzpatrick;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Emoji {
    private final String description;
    private final boolean supportsFitzpatrick;
    private final List<String> aliases;
    private final List<String> tags;
    private final String unicode;
    private final String htmlDec;
    private final String htmlHex;

    protected Emoji(String description, boolean supportsFitzpatrick, List<String> aliases, List<String> tags, byte ... bytes) {
        this.description = description;
        this.supportsFitzpatrick = supportsFitzpatrick;
        this.aliases = Collections.unmodifiableList(aliases);
        this.tags = Collections.unmodifiableList(tags);
        int count = 0;
        try {
            int codePoint;
            this.unicode = new String(bytes, "UTF-8");
            int stringLength = this.getUnicode().length();
            String[] pointCodes = new String[stringLength];
            String[] pointCodesHex = new String[stringLength];
            for (int offset = 0; offset < stringLength; offset += Character.charCount(codePoint)) {
                codePoint = this.getUnicode().codePointAt(offset);
                pointCodes[count] = String.format("&#%d;", codePoint);
                pointCodesHex[count++] = String.format("&#x%x;", codePoint);
            }
            this.htmlDec = this.stringJoin(pointCodes, count);
            this.htmlHex = this.stringJoin(pointCodesHex, count);
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String stringJoin(String[] array, int count) {
        String joined = "";
        for (int i = 0; i < count; ++i) {
            joined = joined + array[i];
        }
        return joined;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean supportsFitzpatrick() {
        return this.supportsFitzpatrick;
    }

    public List<String> getAliases() {
        return this.aliases;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public String getUnicode(Fitzpatrick fitzpatrick) {
        if (!this.supportsFitzpatrick()) {
            throw new UnsupportedOperationException("Cannot get the unicode with a fitzpatrick modifier, the emoji doesn't support fitzpatrick.");
        }
        if (fitzpatrick == null) {
            return this.getUnicode();
        }
        return this.getUnicode() + fitzpatrick.unicode;
    }

    public String getHtmlDecimal() {
        return this.htmlDec;
    }

    public String getHtmlHexidecimal() {
        return this.getHtmlHexadecimal();
    }

    public String getHtmlHexadecimal() {
        return this.htmlHex;
    }

    public boolean equals(Object other) {
        return other != null && other instanceof Emoji && ((Emoji)other).getUnicode().equals(this.getUnicode());
    }

    public int hashCode() {
        return this.unicode.hashCode();
    }

    public String toString() {
        return "Emoji{description='" + this.description + '\'' + ", supportsFitzpatrick=" + this.supportsFitzpatrick + ", aliases=" + this.aliases + ", tags=" + this.tags + ", unicode='" + this.unicode + '\'' + ", htmlDec='" + this.htmlDec + '\'' + ", htmlHex='" + this.htmlHex + '\'' + '}';
    }
}

