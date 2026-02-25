/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcJI$sp
extends Function1,
Serializable {
    @Override
    public long apply$mcJI$sp(int var1);

    default public Object apply(Object t) {
        return BoxesRunTime.boxToLong(this.apply$mcJI$sp(BoxesRunTime.unboxToInt(t)));
    }
}

