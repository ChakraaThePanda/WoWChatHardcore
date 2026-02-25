/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;

public final class Platform$
extends Enumeration {
    public static Platform$ MODULE$;
    private final Enumeration.Value Windows;
    private final Enumeration.Value Mac;

    static {
        new Platform$();
    }

    public Enumeration.Value Windows() {
        return this.Windows;
    }

    public Enumeration.Value Mac() {
        return this.Mac;
    }

    public Enumeration.Value valueOf(String platform) {
        String string = platform.toLowerCase();
        boolean bl = "win".equals(string) ? true : "windows".equals(string);
        Enumeration.Value value = bl ? this.Windows() : this.Mac();
        return value;
    }

    private Platform$() {
        MODULE$ = this;
        this.Windows = this.Value();
        this.Mac = this.Value();
    }
}

