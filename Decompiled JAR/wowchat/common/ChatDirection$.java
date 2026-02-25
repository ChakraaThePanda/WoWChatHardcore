/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;

public final class ChatDirection$
extends Enumeration {
    public static ChatDirection$ MODULE$;
    private final Enumeration.Value both;
    private final Enumeration.Value wow_to_discord;
    private final Enumeration.Value discord_to_wow;

    static {
        new ChatDirection$();
    }

    public Enumeration.Value both() {
        return this.both;
    }

    public Enumeration.Value wow_to_discord() {
        return this.wow_to_discord;
    }

    public Enumeration.Value discord_to_wow() {
        return this.discord_to_wow;
    }

    private ChatDirection$() {
        MODULE$ = this;
        this.both = this.Value();
        this.wow_to_discord = this.Value();
        this.discord_to_wow = this.Value();
    }
}

