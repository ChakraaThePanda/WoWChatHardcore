/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.languageFeature;
import scala.languageFeature$dynamics$;
import scala.languageFeature$existentials$;
import scala.languageFeature$higherKinds$;
import scala.languageFeature$implicitConversions$;
import scala.languageFeature$postfixOps$;
import scala.languageFeature$reflectiveCalls$;

public final class language$ {
    public static language$ MODULE$;
    private languageFeature.dynamics dynamics;
    private languageFeature.postfixOps postfixOps;
    private languageFeature.reflectiveCalls reflectiveCalls;
    private languageFeature.implicitConversions implicitConversions;
    private languageFeature.higherKinds higherKinds;
    private languageFeature.existentials existentials;
    private volatile byte bitmap$0;

    static {
        new language$();
    }

    private languageFeature.dynamics dynamics$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                this.dynamics = languageFeature$dynamics$.MODULE$;
                this.bitmap$0 = (byte)(this.bitmap$0 | 1);
            }
        }
        return this.dynamics;
    }

    public languageFeature.dynamics dynamics() {
        if ((byte)(this.bitmap$0 & 1) == 0) {
            return this.dynamics$lzycompute();
        }
        return this.dynamics;
    }

    private languageFeature.postfixOps postfixOps$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                this.postfixOps = languageFeature$postfixOps$.MODULE$;
                this.bitmap$0 = (byte)(this.bitmap$0 | 2);
            }
        }
        return this.postfixOps;
    }

    public languageFeature.postfixOps postfixOps() {
        if ((byte)(this.bitmap$0 & 2) == 0) {
            return this.postfixOps$lzycompute();
        }
        return this.postfixOps;
    }

    private languageFeature.reflectiveCalls reflectiveCalls$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                this.reflectiveCalls = languageFeature$reflectiveCalls$.MODULE$;
                this.bitmap$0 = (byte)(this.bitmap$0 | 4);
            }
        }
        return this.reflectiveCalls;
    }

    public languageFeature.reflectiveCalls reflectiveCalls() {
        if ((byte)(this.bitmap$0 & 4) == 0) {
            return this.reflectiveCalls$lzycompute();
        }
        return this.reflectiveCalls;
    }

    private languageFeature.implicitConversions implicitConversions$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 8) == 0) {
                this.implicitConversions = languageFeature$implicitConversions$.MODULE$;
                this.bitmap$0 = (byte)(this.bitmap$0 | 8);
            }
        }
        return this.implicitConversions;
    }

    public languageFeature.implicitConversions implicitConversions() {
        if ((byte)(this.bitmap$0 & 8) == 0) {
            return this.implicitConversions$lzycompute();
        }
        return this.implicitConversions;
    }

    private languageFeature.higherKinds higherKinds$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 0x10) == 0) {
                this.higherKinds = languageFeature$higherKinds$.MODULE$;
                this.bitmap$0 = (byte)(this.bitmap$0 | 0x10);
            }
        }
        return this.higherKinds;
    }

    public languageFeature.higherKinds higherKinds() {
        if ((byte)(this.bitmap$0 & 0x10) == 0) {
            return this.higherKinds$lzycompute();
        }
        return this.higherKinds;
    }

    private languageFeature.existentials existentials$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 0x20) == 0) {
                this.existentials = languageFeature$existentials$.MODULE$;
                this.bitmap$0 = (byte)(this.bitmap$0 | 0x20);
            }
        }
        return this.existentials;
    }

    public languageFeature.existentials existentials() {
        if ((byte)(this.bitmap$0 & 0x20) == 0) {
            return this.existentials$lzycompute();
        }
        return this.existentials;
    }

    private language$() {
        MODULE$ = this;
    }
}

