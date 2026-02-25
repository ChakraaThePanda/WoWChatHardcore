/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.reflect.internal.MissingRequirementError;
import scala.runtime.Nothing$;

public final class MissingRequirementError$
implements Serializable {
    public static MissingRequirementError$ MODULE$;
    private final String scala$reflect$internal$MissingRequirementError$$suffix;

    static {
        new MissingRequirementError$();
    }

    public String scala$reflect$internal$MissingRequirementError$$suffix() {
        return this.scala$reflect$internal$MissingRequirementError$$suffix;
    }

    public Nothing$ signal(String msg) {
        throw new MissingRequirementError(msg);
    }

    public Nothing$ notFound(String req) {
        return this.signal(new StringBuilder(0).append(req).append(this.scala$reflect$internal$MissingRequirementError$$suffix()).toString());
    }

    public Option<String> unapply(Throwable x) {
        Option option;
        if (x instanceof MissingRequirementError) {
            MissingRequirementError missingRequirementError = (MissingRequirementError)x;
            option = new Some<String>(missingRequirementError.req());
        } else {
            option = None$.MODULE$;
        }
        return option;
    }

    private Object readResolve() {
        return MODULE$;
    }

    private MissingRequirementError$() {
        MODULE$ = this;
        this.scala$reflect$internal$MissingRequirementError$$suffix = " not found.";
    }
}

