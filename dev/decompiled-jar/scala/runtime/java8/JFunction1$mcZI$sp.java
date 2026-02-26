/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcZI$sp
extends Function1,
Serializable {
    @Override
    public boolean apply$mcZI$sp(int var1);

    default public Object apply(Object t) {
        return BoxesRunTime.boxToBoolean(this.apply$mcZI$sp(BoxesRunTime.unboxToInt(t)));
    }
}

