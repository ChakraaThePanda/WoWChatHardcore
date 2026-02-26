/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcII$sp
extends Function1,
Serializable {
    @Override
    public int apply$mcII$sp(int var1);

    default public Object apply(Object t) {
        return BoxesRunTime.boxToInteger(this.apply$mcII$sp(BoxesRunTime.unboxToInt(t)));
    }
}

