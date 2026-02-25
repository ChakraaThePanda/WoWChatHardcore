/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;

public final class WowExpansion$
extends Enumeration {
    public static WowExpansion$ MODULE$;
    private final Enumeration.Value Vanilla;
    private final Enumeration.Value TBC;
    private final Enumeration.Value WotLK;
    private final Enumeration.Value Cataclysm;
    private final Enumeration.Value MoP;

    static {
        new WowExpansion$();
    }

    public Enumeration.Value Vanilla() {
        return this.Vanilla;
    }

    public Enumeration.Value TBC() {
        return this.TBC;
    }

    public Enumeration.Value WotLK() {
        return this.WotLK;
    }

    public Enumeration.Value Cataclysm() {
        return this.Cataclysm;
    }

    public Enumeration.Value MoP() {
        return this.MoP;
    }

    public Enumeration.Value valueOf(String version) {
        Enumeration.Value value;
        if (version.startsWith("1.")) {
            value = this.Vanilla();
        } else if (version.startsWith("2.")) {
            value = this.TBC();
        } else if (version.startsWith("3.")) {
            value = this.WotLK();
        } else {
            String string = version;
            String string2 = "4.3.4";
            if (!(string != null ? !string.equals(string2) : string2 != null)) {
                value = this.Cataclysm();
            } else {
                String string3 = version;
                String string4 = "5.4.8";
                if (!(string3 != null ? !string3.equals(string4) : string4 != null)) {
                    value = this.MoP();
                } else {
                    throw new IllegalArgumentException(new StringBuilder(23).append("Version ").append(version).append(" not supported!").toString());
                }
            }
        }
        return value;
    }

    private WowExpansion$() {
        MODULE$ = this;
        this.Vanilla = this.Value();
        this.TBC = this.Value();
        this.WotLK = this.Value();
        this.Cataclysm = this.Value();
        this.MoP = this.Value();
    }
}

