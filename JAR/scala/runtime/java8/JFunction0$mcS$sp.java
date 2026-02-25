/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function0;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction0$mcS$sp
extends Function0,
Serializable {
    @Override
    public short apply$mcS$sp();

    default public Object apply() {
        return BoxesRunTime.boxToShort(this.apply$mcS$sp());
    }
}

