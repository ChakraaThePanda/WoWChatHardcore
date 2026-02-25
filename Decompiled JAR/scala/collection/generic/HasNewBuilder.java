/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\r2qAA\u0002\u0011\u0002G\u0005!\u0002\u0003\u0004\u0011\u0001\u00016\t\"\u0005\u0002\u000e\u0011\u0006\u001ch*Z<Ck&dG-\u001a:\u000b\u0005\u0011)\u0011aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003\r\u001d\t!bY8mY\u0016\u001cG/[8o\u0015\u0005A\u0011!B:dC2\f7\u0001A\u000b\u0004\u0017i\t3C\u0001\u0001\r!\tia\"D\u0001\b\u0013\tyqAA\u0002B]f\f!B\\3x\u0005VLG\u000eZ3s+\u0005\u0011\u0002\u0003B\n\u00171\u0001j\u0011\u0001\u0006\u0006\u0003+\u0015\tq!\\;uC\ndW-\u0003\u0002\u0018)\t9!)^5mI\u0016\u0014\bCA\r\u001b\u0019\u0001!aa\u0007\u0001\u0005\u0006\u0004a\"!A!\u0012\u0005ua\u0001CA\u0007\u001f\u0013\tyrAA\u0004O_RD\u0017N\\4\u0011\u0005e\tCA\u0002\u0012\u0001\t\u000b\u0007AD\u0001\u0003SKB\u0014\b")
public interface HasNewBuilder<A, Repr> {
    public Builder<A, Repr> newBuilder();
}

