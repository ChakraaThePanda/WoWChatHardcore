/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game.warden;

public final class WardenPackets$ {
    public static WardenPackets$ MODULE$;
    private final int WARDEN_CMSG_MODULE_MISSING;
    private final int WARDEN_CMSG_MODULE_OK;
    private final int WARDEN_CMSG_CHEAT_CHECKS_RESULT;
    private final int WARDEN_CMSG_MEM_CHECKS_RESULT;
    private final int WARDEN_CMSG_HASH_RESULT;
    private final int WARDEN_CMSG_MODULE_FAILED;
    private final int WARDEN_SMSG_MODULE_USE;
    private final int WARDEN_SMSG_MODULE_CACHE;
    private final int WARDEN_SMSG_CHEAT_CHECKS_REQUEST;
    private final int WARDEN_SMSG_MODULE_INITIALIZE;
    private final int WARDEN_SMSG_MEM_CHECKS_REQUEST;
    private final int WARDEN_SMSG_HASH_REQUEST;

    static {
        new WardenPackets$();
    }

    public int WARDEN_CMSG_MODULE_MISSING() {
        return this.WARDEN_CMSG_MODULE_MISSING;
    }

    public int WARDEN_CMSG_MODULE_OK() {
        return this.WARDEN_CMSG_MODULE_OK;
    }

    public int WARDEN_CMSG_CHEAT_CHECKS_RESULT() {
        return this.WARDEN_CMSG_CHEAT_CHECKS_RESULT;
    }

    public int WARDEN_CMSG_MEM_CHECKS_RESULT() {
        return this.WARDEN_CMSG_MEM_CHECKS_RESULT;
    }

    public int WARDEN_CMSG_HASH_RESULT() {
        return this.WARDEN_CMSG_HASH_RESULT;
    }

    public int WARDEN_CMSG_MODULE_FAILED() {
        return this.WARDEN_CMSG_MODULE_FAILED;
    }

    public int WARDEN_SMSG_MODULE_USE() {
        return this.WARDEN_SMSG_MODULE_USE;
    }

    public int WARDEN_SMSG_MODULE_CACHE() {
        return this.WARDEN_SMSG_MODULE_CACHE;
    }

    public int WARDEN_SMSG_CHEAT_CHECKS_REQUEST() {
        return this.WARDEN_SMSG_CHEAT_CHECKS_REQUEST;
    }

    public int WARDEN_SMSG_MODULE_INITIALIZE() {
        return this.WARDEN_SMSG_MODULE_INITIALIZE;
    }

    public int WARDEN_SMSG_MEM_CHECKS_REQUEST() {
        return this.WARDEN_SMSG_MEM_CHECKS_REQUEST;
    }

    public int WARDEN_SMSG_HASH_REQUEST() {
        return this.WARDEN_SMSG_HASH_REQUEST;
    }

    private WardenPackets$() {
        MODULE$ = this;
        this.WARDEN_CMSG_MODULE_MISSING = 0;
        this.WARDEN_CMSG_MODULE_OK = 1;
        this.WARDEN_CMSG_CHEAT_CHECKS_RESULT = 2;
        this.WARDEN_CMSG_MEM_CHECKS_RESULT = 3;
        this.WARDEN_CMSG_HASH_RESULT = 4;
        this.WARDEN_CMSG_MODULE_FAILED = 5;
        this.WARDEN_SMSG_MODULE_USE = 0;
        this.WARDEN_SMSG_MODULE_CACHE = 1;
        this.WARDEN_SMSG_CHEAT_CHECKS_REQUEST = 2;
        this.WARDEN_SMSG_MODULE_INITIALIZE = 3;
        this.WARDEN_SMSG_MEM_CHECKS_REQUEST = 4;
        this.WARDEN_SMSG_HASH_REQUEST = 5;
    }
}

