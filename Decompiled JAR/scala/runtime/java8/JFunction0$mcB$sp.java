/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function0;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction0$mcB$sp
extends Function0,
Serializable {
    @Override
    public byte apply$mcB$sp();

    default public Object apply() {
        return BoxesRunTime.boxToByte(this.apply$mcB$sp());
    }
}

