/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcDD$sp
extends Function1,
Serializable {
    @Override
    public double apply$mcDD$sp(double var1);

    default public Object apply(Object t) {
        return BoxesRunTime.boxToDouble(this.apply$mcDD$sp(BoxesRunTime.unboxToDouble(t)));
    }
}

