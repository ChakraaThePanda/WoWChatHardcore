/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime.java8;

import java.io.Serializable;
import scala.Function1;
import scala.runtime.BoxesRunTime;

@FunctionalInterface
public interface JFunction1$mcJJ$sp
extends Function1,
Serializable {
    @Override
    public long apply$mcJJ$sp(long var1);

    default public Object apply(Object t) {
        return BoxesRunTime.boxToLong(this.apply$mcJJ$sp(BoxesRunTime.unboxToLong(t)));
    }
}

