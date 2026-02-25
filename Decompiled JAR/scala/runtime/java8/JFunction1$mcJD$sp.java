/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcJD$sp
extends Function1,
Serializable {
    @Override
    public long apply$mcJD$sp(double var1);

    default public Object apply(Object t) {
        return BoxesRunTime.boxToLong(this.apply$mcJD$sp(BoxesRunTime.unboxToDouble(t)));
    }
}

