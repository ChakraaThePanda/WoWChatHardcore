/*
 * Decompiled with CFR 0.152.
 */
package scala.sys;

import scala.Function1;
import scala.Serializable;
import scala.runtime.BoxesRunTime;
import scala.sys.BooleanProp;

public final class BooleanProp$ {
    public static BooleanProp$ MODULE$;

    static {
        new BooleanProp$();
    }

    public <T> BooleanProp valueIsTrue(String key) {
        return new BooleanProp.BooleanPropImpl(key, (Function1<String, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(BooleanProp$.$anonfun$valueIsTrue$1(x$1)));
    }

    public <T> BooleanProp keyExists(String key) {
        return new BooleanProp.BooleanPropImpl(key, (Function1<String, Object> & java.io.Serializable & Serializable)s -> BoxesRunTime.boxToBoolean(BooleanProp$.$anonfun$keyExists$1(s)));
    }

    public BooleanProp constant(String key, boolean isOn) {
        return new BooleanProp.ConstantImpl(key, isOn);
    }

    public boolean booleanPropAsBoolean(BooleanProp b) {
        return b.value();
    }

    public static final /* synthetic */ boolean $anonfun$valueIsTrue$1(String x$1) {
        String string = x$1.toLowerCase();
        String string2 = "true";
        return string != null && string.equals(string2);
    }

    public static final /* synthetic */ boolean $anonfun$keyExists$1(String s) {
        String string = s;
        String string2 = "";
        return string != null && string.equals(string2) || s.equalsIgnoreCase("true");
    }

    private BooleanProp$() {
        MODULE$ = this;
    }
}

