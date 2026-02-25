/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

public final class RealmPackets$ {
    public static RealmPackets$ MODULE$;
    private final int CMD_AUTH_LOGON_CHALLENGE;
    private final int CMD_AUTH_LOGON_PROOF;
    private final int CMD_REALM_LIST;

    static {
        new RealmPackets$();
    }

    public int CMD_AUTH_LOGON_CHALLENGE() {
        return this.CMD_AUTH_LOGON_CHALLENGE;
    }

    public int CMD_AUTH_LOGON_PROOF() {
        return this.CMD_AUTH_LOGON_PROOF;
    }

    public int CMD_REALM_LIST() {
        return this.CMD_REALM_LIST;
    }

    private RealmPackets$() {
        MODULE$ = this;
        this.CMD_AUTH_LOGON_CHALLENGE = 0;
        this.CMD_AUTH_LOGON_PROOF = 1;
        this.CMD_REALM_LIST = 16;
    }
}

