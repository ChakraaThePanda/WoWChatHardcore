/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001a2q\u0001B\u0003\u0011\u0002\u0007\u0005A\u0002C\u0003\u0015\u0001\u0011\u0005Q\u0003C\u0003\u001a\u0001\u0019\u0005!\u0004C\u00036\u0001\u0011\u0005aG\u0001\u0004DC:dun\u001a\u0006\u0003\r\u001d\tAb]2bY\u0006dwnZ4j]\u001eT!\u0001C\u0005\u0002\u0011QL\b/Z:bM\u0016T\u0011AC\u0001\u0004G>l7\u0001A\u000b\u0003\u001b1\u001a\"\u0001\u0001\b\u0011\u0005=\u0011R\"\u0001\t\u000b\u0003E\tQa]2bY\u0006L!a\u0005\t\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\ta\u0003\u0005\u0002\u0010/%\u0011\u0001\u0004\u0005\u0002\u0005+:LG/\u0001\u0006m_\u001elUm]:bO\u0016$2a\u0007\u0014)!\ta2E\u0004\u0002\u001eCA\u0011a\u0004E\u0007\u0002?)\u0011\u0001eC\u0001\u0007yI|w\u000e\u001e \n\u0005\t\u0002\u0012A\u0002)sK\u0012,g-\u0003\u0002%K\t11\u000b\u001e:j]\u001eT!A\t\t\t\u000b\u001d\u0012\u0001\u0019A\u000e\u0002\u0017=\u0014\u0018nZ5oC2l5o\u001a\u0005\u0006S\t\u0001\rAK\u0001\u0002CB\u00111\u0006\f\u0007\u0001\t\u0015i\u0003A1\u0001/\u0005\u0005\t\u0015CA\u00183!\ty\u0001'\u0003\u00022!\t9aj\u001c;iS:<\u0007CA\b4\u0013\t!\u0004CA\u0002B]f\f\u0001\"\u00194uKJdun\u001a\u000b\u0003-]BQ!K\u0002A\u0002)\u0002")
public interface CanLog<A> {
    public String logMessage(String var1, A var2);

    public static /* synthetic */ void afterLog$(CanLog $this, Object a) {
        $this.afterLog(a);
    }

    default public void afterLog(A a) {
        A a2 = a;
    }

    public static void $init$(CanLog $this) {
    }
}

