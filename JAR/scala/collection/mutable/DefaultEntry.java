/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Serializable;
import scala.collection.mutable.HashEntry;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001)3A!\u0003\u0006\u0003#!AQ\u0006\u0001BC\u0002\u0013\u0005a\u0006\u0003\u00050\u0001\t\u0005\t\u0015!\u0003\u001c\u0011!\u0001\u0004A!a\u0001\n\u0003\t\u0004\u0002\u0003\u001a\u0001\u0005\u0003\u0007I\u0011A\u001a\t\u0011e\u0002!\u0011!Q!\n\u001dBQA\u000f\u0001\u0005\u0002mBQA\u0010\u0001\u0005B}BQ\u0001\u0013\u0001\u0005\u0002%\u0013A\u0002R3gCVdG/\u00128uefT!a\u0003\u0007\u0002\u000f5,H/\u00192mK*\u0011QBD\u0001\u000bG>dG.Z2uS>t'\"A\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019!#\b\u0015\u0014\t\u0001\u0019rC\u000b\t\u0003)Ui\u0011AD\u0005\u0003-9\u0011a!\u00118z%\u00164\u0007\u0003\u0002\r\u001a7\u0019j\u0011AC\u0005\u00035)\u0011\u0011\u0002S1tQ\u0016sGO]=\u0011\u0005qiB\u0002\u0001\u0003\u0006=\u0001\u0011\ra\b\u0002\u0002\u0003F\u0011\u0001e\t\t\u0003)\u0005J!A\t\b\u0003\u000f9{G\u000f[5oOB\u0011A\u0003J\u0005\u0003K9\u00111!\u00118z!\u0011A\u0002aG\u0014\u0011\u0005qAC!B\u0015\u0001\u0005\u0004y\"!\u0001\"\u0011\u0005QY\u0013B\u0001\u0017\u000f\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\rYW-_\u000b\u00027\u0005!1.Z=!\u0003\u00151\u0018\r\\;f+\u00059\u0013!\u0003<bYV,w\fJ3r)\t!t\u0007\u0005\u0002\u0015k%\u0011aG\u0004\u0002\u0005+:LG\u000fC\u00049\t\u0005\u0005\t\u0019A\u0014\u0002\u0007a$\u0013'\u0001\u0004wC2,X\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007\u0019bT\bC\u0003.\r\u0001\u00071\u0004C\u00031\r\u0001\u0007q%\u0001\u0005u_N#(/\u001b8h)\u0005\u0001\u0005CA!G\u001b\u0005\u0011%BA\"E\u0003\u0011a\u0017M\\4\u000b\u0003\u0015\u000bAA[1wC&\u0011qI\u0011\u0002\u0007'R\u0014\u0018N\\4\u0002\u0017\rD\u0017-\u001b8TiJLgnZ\u000b\u0002\u0001\u0002")
public final class DefaultEntry<A, B>
implements HashEntry<A, DefaultEntry<A, B>>,
Serializable {
    private final A key;
    private B value;
    private DefaultEntry<A, B> next;

    @Override
    public DefaultEntry<A, B> next() {
        return this.next;
    }

    @Override
    public void next_$eq(DefaultEntry<A, B> x$1) {
        this.next = x$1;
    }

    @Override
    public A key() {
        return this.key;
    }

    public B value() {
        return this.value;
    }

    public void value_$eq(B x$1) {
        this.value = x$1;
    }

    public String toString() {
        return this.chainString();
    }

    public String chainString() {
        return new StringBuilder(8).append("(kv: ").append(this.key()).append(", ").append(this.value()).append(")").append((Object)(this.next() != null ? new StringBuilder(4).append(" -> ").append(((DefaultEntry)this.next()).toString()).toString() : "")).toString();
    }

    public DefaultEntry(A key, B value) {
        this.key = key;
        this.value = value;
        HashEntry.$init$(this);
    }
}

