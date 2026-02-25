/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import scala.Predef$;
import scala.Tuple2;
import scala.collection.concurrent.KVNode;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.SNode;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u00014QAD\b\u0003#UA\u0001B\f\u0001\u0003\u0006\u0004%)a\f\u0005\ta\u0001\u0011\t\u0011)A\u00077!A\u0011\u0007\u0001BC\u0002\u0013\u0015!\u0007\u0003\u00054\u0001\t\u0005\t\u0015!\u0004)\u0011!!\u0004A!b\u0001\n\u000b)\u0004\u0002C\u001d\u0001\u0005\u0003\u0005\u000bQ\u0002\u001c\t\u000bi\u0002A\u0011A\u001e\t\u000b\u0001\u0003AQA!\t\u000b\t\u0003AQA!\t\u000b\r\u0003AQ\u0001#\t\u000b!\u0003AQA%\t\u000b5\u0003AQ\u0001(\t\u000bQ\u0003AQA+\u0003\u000bQsu\u000eZ3\u000b\u0005A\t\u0012AC2p]\u000e,(O]3oi*\u0011!cE\u0001\u000bG>dG.Z2uS>t'\"\u0001\u000b\u0002\u000bM\u001c\u0017\r\\1\u0016\u0007Yi\u0012fE\u0002\u0001/-\u0002B\u0001G\r\u001cQ5\tq\"\u0003\u0002\u001b\u001f\tAQ*Y5o\u001d>$W\r\u0005\u0002\u001d;1\u0001A!\u0002\u0010\u0001\u0005\u0004\u0001#!A&\u0004\u0001E\u0011\u0011%\n\t\u0003E\rj\u0011aE\u0005\u0003IM\u0011qAT8uQ&tw\r\u0005\u0002#M%\u0011qe\u0005\u0002\u0004\u0003:L\bC\u0001\u000f*\t\u0015Q\u0003A1\u0001!\u0005\u00051\u0006\u0003\u0002\r-7!J!!L\b\u0003\r-3fj\u001c3f\u0003\u0005YW#A\u000e\u0002\u0005-\u0004\u0013!\u0001<\u0016\u0003!\n!A\u001e\u0011\u0002\u0005!\u001cW#\u0001\u001c\u0011\u0005\t:\u0014B\u0001\u001d\u0014\u0005\rIe\u000e^\u0001\u0004Q\u000e\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0003={yz\u0004\u0003\u0002\r\u00017!BQAL\u0004A\u0002mAQ!M\u0004A\u0002!BQ\u0001N\u0004A\u0002Y\nAaY8qsV\tA(\u0001\u0006d_BLHk\\7cK\u0012\fAbY8qsVsGo\\7cK\u0012,\u0012!\u0012\t\u00051\u0019[\u0002&\u0003\u0002H\u001f\t)1KT8eK\u000611N\u001e)bSJ,\u0012A\u0013\t\u0005E-[\u0002&\u0003\u0002M'\t1A+\u001e9mKJ\n!bY1dQ\u0016$7+\u001b>f)\t1t\nC\u0003Q\u0019\u0001\u0007\u0011+\u0001\u0002diB\u0011!EU\u0005\u0003'N\u0011a!\u00118z%\u00164\u0017AB:ue&tw\r\u0006\u0002W=B\u0011q\u000bX\u0007\u00021*\u0011\u0011LW\u0001\u0005Y\u0006twMC\u0001\\\u0003\u0011Q\u0017M^1\n\u0005uC&AB*ue&tw\rC\u0003`\u001b\u0001\u0007a'A\u0002mKZ\u0004")
public final class TNode<K, V>
extends MainNode<K, V>
implements KVNode<K, V> {
    private final K k;
    private final V v;
    private final int hc;

    public final K k() {
        return this.k;
    }

    public final V v() {
        return this.v;
    }

    public final int hc() {
        return this.hc;
    }

    public final TNode<K, V> copy() {
        return new TNode<K, V>(this.k(), this.v(), this.hc());
    }

    public final TNode<K, V> copyTombed() {
        return new TNode<K, V>(this.k(), this.v(), this.hc());
    }

    public final SNode<K, V> copyUntombed() {
        return new SNode<K, V>(this.k(), this.v(), this.hc());
    }

    @Override
    public final Tuple2<K, V> kvPair() {
        return new Tuple2<K, V>(this.k(), this.v());
    }

    @Override
    public final int cachedSize(Object ct) {
        return 1;
    }

    @Override
    public final String string(int lev) {
        String string = "  ";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        String string2 = "TNode(%s, %s, %x, !)";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringBuilder(0).append(new StringOps(string).$times(lev)).append(new StringOps(string2).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.k(), this.v(), BoxesRunTime.boxToInteger(this.hc())}))).toString();
    }

    public TNode(K k, V v, int hc) {
        this.k = k;
        this.v = v;
        this.hc = hc;
    }
}

