/*
 * Decompiled with CFR 0.152.
 */
package com.vdurmont.emoji;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public enum Fitzpatrick {
    TYPE_1_2("\ud83c\udffb"),
    TYPE_3("\ud83c\udffc"),
    TYPE_4("\ud83c\udffd"),
    TYPE_5("\ud83c\udffe"),
    TYPE_6("\ud83c\udfff");

    public final String unicode;

    private Fitzpatrick(String unicode) {
        this.unicode = unicode;
    }

    public static Fitzpatrick fitzpatrickFromUnicode(String unicode) {
        for (Fitzpatrick v : Fitzpatrick.values()) {
            if (!v.unicode.equals(unicode)) continue;
            return v;
        }
        return null;
    }

    public static Fitzpatrick fitzpatrickFromType(String type) {
        try {
            return Fitzpatrick.valueOf(type.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return null;
        }
    }
}

