/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.parallel.Combiner;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00192qAA\u0002\u0011\u0002G\u0005!\u0002\u0003\u0004\u0011\u0001\u00016\t\"\u0005\u0002\u000f\u0011\u0006\u001ch*Z<D_6\u0014\u0017N\\3s\u0015\t!Q!A\u0004hK:,'/[2\u000b\u0005\u00199\u0011AC2pY2,7\r^5p]*\t\u0001\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0007-QBe\u0005\u0002\u0001\u0019A\u0011QBD\u0007\u0002\u000f%\u0011qb\u0002\u0002\u0007\u0003:L(+\u001a4\u0002\u00179,woQ8nE&tWM]\u000b\u0002%A!1C\u0006\r$\u001b\u0005!\"BA\u000b\u0006\u0003!\u0001\u0018M]1mY\u0016d\u0017BA\f\u0015\u0005!\u0019u.\u001c2j]\u0016\u0014\bCA\r\u001b\u0019\u0001!aa\u0007\u0001\u0005\u0006\u0004a\"!\u0001+\u0012\u0005u\u0001\u0003CA\u0007\u001f\u0013\tyrAA\u0004O_RD\u0017N\\4\u0011\u00055\t\u0013B\u0001\u0012\b\u0005\r\te.\u001f\t\u00033\u0011\"a!\n\u0001\u0005\u0006\u0004a\"\u0001\u0002*faJ\u0004")
public interface HasNewCombiner<T, Repr> {
    public Combiner<T, Repr> newCombiner();
}

