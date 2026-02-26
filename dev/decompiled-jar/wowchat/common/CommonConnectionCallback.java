/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}1qa\u0002\u0005\u0011\u0002\u0007\u0005Q\u0002C\u0003\u0015\u0001\u0011\u0005Q\u0003C\u0003\u001a\u0001\u0011\u0005!\u0004C\u0003\u001c\u0001\u0011\u0005!\u0004C\u0003\u001d\u0001\u0011\u0005!\u0004C\u0003\u001e\u0001\u0011\u0005!\u0004C\u0003\u001f\u0001\u0011\u0005!D\u0001\rD_6lwN\\\"p]:,7\r^5p]\u000e\u000bG\u000e\u001c2bG.T!!\u0003\u0006\u0002\r\r|W.\\8o\u0015\u0005Y\u0011aB<po\u000eD\u0017\r^\u0002\u0001'\t\u0001a\u0002\u0005\u0002\u0010%5\t\u0001CC\u0001\u0012\u0003\u0015\u00198-\u00197b\u0013\t\u0019\u0002C\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003Y\u0001\"aD\f\n\u0005a\u0001\"\u0001B+oSR\fqaY8o]\u0016\u001cG/F\u0001\u0017\u0003%\u0019wN\u001c8fGR,G-A\u0006sK\u000e|gN\\3di\u0016$\u0017\u0001\u00043jg\u000e|gN\\3di\u0016$\u0017!B3se>\u0014\b")
public interface CommonConnectionCallback {
    public static /* synthetic */ void connect$(CommonConnectionCallback $this) {
        $this.connect();
    }

    default public void connect() {
    }

    public static /* synthetic */ void connected$(CommonConnectionCallback $this) {
        $this.connected();
    }

    default public void connected() {
    }

    public static /* synthetic */ void reconnected$(CommonConnectionCallback $this) {
        $this.reconnected();
    }

    default public void reconnected() {
    }

    public static /* synthetic */ void disconnected$(CommonConnectionCallback $this) {
        $this.disconnected();
    }

    default public void disconnected() {
    }

    public static /* synthetic */ void error$(CommonConnectionCallback $this) {
        $this.error();
    }

    default public void error() {
    }

    public static void $init$(CommonConnectionCallback $this) {
    }
}

