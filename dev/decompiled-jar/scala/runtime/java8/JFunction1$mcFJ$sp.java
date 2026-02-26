/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcFJ$sp
extends Function1,
Serializable {
    @Override
    public float apply$mcFJ$sp(long var1);

    default public Object apply(Object t) {
        return BoxesRunTime.boxToFloat(this.apply$mcFJ$sp(BoxesRunTime.unboxToLong(t)));
    }
}

