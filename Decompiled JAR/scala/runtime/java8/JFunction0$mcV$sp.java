/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function0;
import scala.runtime.BoxedUnit;

@FunctionalInterface
public interface JFunction0$mcV$sp
extends Function0,
Serializable {
    @Override
    public void apply$mcV$sp();

    default public Object apply() {
        this.apply$mcV$sp();
        return BoxedUnit.UNIT;
    }
}

