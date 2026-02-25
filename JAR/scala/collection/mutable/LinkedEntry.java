/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Serializable;
import scala.collection.mutable.HashEntry;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000153A!\u0004\b\u0003+!A\u0011\u0007\u0001BC\u0002\u0013\u0005!\u0007\u0003\u00054\u0001\t\u0005\t\u0015!\u0003 \u0011!!\u0004A!a\u0001\n\u0003)\u0004\u0002\u0003\u001c\u0001\u0005\u0003\u0007I\u0011A\u001c\t\u0011u\u0002!\u0011!Q!\n-BQA\u0010\u0001\u0005\u0002}BqA\u0011\u0001A\u0002\u0013\u00051\tC\u0004E\u0001\u0001\u0007I\u0011A#\t\r\u001d\u0003\u0001\u0015)\u0003+\u0011\u001dA\u0005\u00011A\u0005\u0002\rCq!\u0013\u0001A\u0002\u0013\u0005!\n\u0003\u0004M\u0001\u0001\u0006KA\u000b\u0002\f\u0019&t7.\u001a3F]R\u0014\u0018P\u0003\u0002\u0010!\u00059Q.\u001e;bE2,'BA\t\u0013\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002'\u0005)1oY1mC\u000e\u0001Qc\u0001\f\"YM!\u0001aF\u000e/!\tA\u0012$D\u0001\u0013\u0013\tQ\"C\u0001\u0004B]f\u0014VM\u001a\t\u00059uy\"&D\u0001\u000f\u0013\tqbBA\u0005ICNDWI\u001c;ssB\u0011\u0001%\t\u0007\u0001\t\u0015\u0011\u0003A1\u0001$\u0005\u0005\t\u0015C\u0001\u0013(!\tAR%\u0003\u0002'%\t9aj\u001c;iS:<\u0007C\u0001\r)\u0013\tI#CA\u0002B]f\u0004B\u0001\b\u0001 WA\u0011\u0001\u0005\f\u0003\u0006[\u0001\u0011\ra\t\u0002\u0002\u0005B\u0011\u0001dL\u0005\u0003aI\u0011AbU3sS\u0006d\u0017N_1cY\u0016\f1a[3z+\u0005y\u0012\u0001B6fs\u0002\nQA^1mk\u0016,\u0012aK\u0001\nm\u0006dW/Z0%KF$\"\u0001O\u001e\u0011\u0005aI\u0014B\u0001\u001e\u0013\u0005\u0011)f.\u001b;\t\u000fq\"\u0011\u0011!a\u0001W\u0005\u0019\u0001\u0010J\u0019\u0002\rY\fG.^3!\u0003\u0019a\u0014N\\5u}Q\u0019!\u0006Q!\t\u000bE2\u0001\u0019A\u0010\t\u000bQ2\u0001\u0019A\u0016\u0002\u000f\u0015\f'\u000f\\5feV\t!&A\u0006fCJd\u0017.\u001a:`I\u0015\fHC\u0001\u001dG\u0011\u001da\u0004\"!AA\u0002)\n\u0001\"Z1sY&,'\u000fI\u0001\u0006Y\u0006$XM]\u0001\nY\u0006$XM]0%KF$\"\u0001O&\t\u000fqZ\u0011\u0011!a\u0001U\u00051A.\u0019;fe\u0002\u0002")
public final class LinkedEntry<A, B>
implements HashEntry<A, LinkedEntry<A, B>>,
Serializable {
    private final A key;
    private B value;
    private LinkedEntry<A, B> earlier;
    private LinkedEntry<A, B> later;
    private LinkedEntry<A, B> next;

    @Override
    public LinkedEntry<A, B> next() {
        return this.next;
    }

    @Override
    public void next_$eq(LinkedEntry<A, B> x$1) {
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

    public LinkedEntry<A, B> earlier() {
        return this.earlier;
    }

    public void earlier_$eq(LinkedEntry<A, B> x$1) {
        this.earlier = x$1;
    }

    public LinkedEntry<A, B> later() {
        return this.later;
    }

    public void later_$eq(LinkedEntry<A, B> x$1) {
        this.later = x$1;
    }

    public LinkedEntry(A key, B value) {
        this.key = key;
        this.value = value;
        HashEntry.$init$(this);
        this.earlier = null;
        this.later = null;
    }
}

