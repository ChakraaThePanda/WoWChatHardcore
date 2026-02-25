/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001]2q\u0001B\u0003\u0011\u0002G\u0005!\u0002C\u0003\u0012\u0001\u0019\u0005!\u0003C\u00035\u0001\u0019\u0005Q\u0007C\u00037\u0001\u0019\u0005QGA\fSK\u0006dWnQ8o]\u0016\u001cG/[8o\u0007\u0006dGNY1dW*\u0011aaB\u0001\u0006e\u0016\fG.\u001c\u0006\u0002\u0011\u00059qo\\<dQ\u0006$8\u0001A\n\u0003\u0001-\u0001\"\u0001D\b\u000e\u00035Q\u0011AD\u0001\u0006g\u000e\fG.Y\u0005\u0003!5\u0011a!\u00118z%\u00164\u0017aB:vG\u000e,7o\u001d\u000b\u0007'Y\u0019\u0003F\u000b\u0017\u0011\u00051!\u0012BA\u000b\u000e\u0005\u0011)f.\u001b;\t\u000b]\t\u0001\u0019\u0001\r\u0002\t!|7\u000f\u001e\t\u00033\u0001r!A\u0007\u0010\u0011\u0005miQ\"\u0001\u000f\u000b\u0005uI\u0011A\u0002\u001fs_>$h(\u0003\u0002 \u001b\u00051\u0001K]3eK\u001aL!!\t\u0012\u0003\rM#(/\u001b8h\u0015\tyR\u0002C\u0003%\u0003\u0001\u0007Q%\u0001\u0003q_J$\bC\u0001\u0007'\u0013\t9SBA\u0002J]RDQ!K\u0001A\u0002a\t\u0011B]3bY6t\u0015-\\3\t\u000b-\n\u0001\u0019A\u0013\u0002\u000fI,\u0017\r\\7JI\")Q&\u0001a\u0001]\u0005Q1/Z:tS>t7*Z=\u0011\u00071y\u0013'\u0003\u00021\u001b\t)\u0011I\u001d:bsB\u0011ABM\u0005\u0003g5\u0011AAQ=uK\u0006aA-[:d_:tWm\u0019;fIV\t1#A\u0003feJ|'\u000f")
public interface RealmConnectionCallback {
    public void success(String var1, int var2, String var3, int var4, byte[] var5);

    public void disconnected();

    public void error();
}

