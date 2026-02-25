/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000192q\u0001B\u0003\u0011\u0002\u0007\u0005A\u0002C\u0003\u001a\u0001\u0011\u0005!\u0004C\u0003\u001f\u0001\u0011\u0005s\u0004C\u0006,\u0001A\u0005\u0019\u0011!A\u0005\n1j#!C\"m_:,\u0017M\u00197f\u0015\t1q!A\u0004nkR\f'\r\\3\u000b\u0005!I\u0011AC2pY2,7\r^5p]*\t!\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00055\u00113c\u0001\u0001\u000f-A\u0011q\u0002F\u0007\u0002!)\u0011\u0011CE\u0001\u0005Y\u0006twMC\u0001\u0014\u0003\u0011Q\u0017M^1\n\u0005U\u0001\"AB(cU\u0016\u001cG\u000f\u0005\u0002\u001815\t\u0011\"\u0003\u0002\u0005\u0013\u00051A%\u001b8ji\u0012\"\u0012a\u0007\t\u0003/qI!!H\u0005\u0003\tUs\u0017\u000e^\u0001\u0006G2|g.\u001a\u000b\u0002AA\u0011\u0011E\t\u0007\u0001\t\u0019\u0019\u0003\u0001\"b\u0001I\t\t\u0011)\u0005\u0002&QA\u0011qCJ\u0005\u0003O%\u0011qAT8uQ&tw\r\u0005\u0002\u0018S%\u0011!&\u0003\u0002\u0007\u0003:L(+\u001a4\u0002\u0017M,\b/\u001a:%G2|g.\u001a\u000b\u0002\u001d%\u0011a\u0004\u0006")
public interface Cloneable<A>
extends scala.Cloneable {
    public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone();

    public static /* synthetic */ Object clone$(Cloneable $this) {
        return $this.clone();
    }

    default public A clone() {
        return (A)this.scala$collection$mutable$Cloneable$$super$clone();
    }

    public static void $init$(Cloneable $this) {
    }
}

