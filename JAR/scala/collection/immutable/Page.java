/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function3;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001u4AAG\u000e\u0005E!A\u0001\u0006\u0001BC\u0002\u0013\u0005\u0011\u0006\u0003\u0005.\u0001\t\u0005\t\u0015!\u0003+\u0011!q\u0003AaA!\u0002\u0017y\u0003\"\u0002!\u0001\t\u0003\t\u0005bB$\u0001\u0005\u0004%i\u0001\u0013\u0005\u0007\u0017\u0002\u0001\u000bQB%\t\u000f1\u0003\u0001\u0019!C\u0001\u001b\"9a\n\u0001a\u0001\n\u0003y\u0005BB+\u0001A\u0003&1\tC\u0004W\u0001\u0001\u0007I\u0011A'\t\u000f]\u0003\u0001\u0019!C\u00011\"1!\f\u0001Q!\n\rCqa\u0017\u0001A\u0002\u0013\u0005\u0011\u0006C\u0004]\u0001\u0001\u0007I\u0011A/\t\r}\u0003\u0001\u0015)\u0003+\u0011\u001d\u0001\u0007\u00011A\u0005\u0002\u0005Dq!\u001a\u0001A\u0002\u0013\u0005a\r\u0003\u0004i\u0001\u0001\u0006KA\u0019\u0005\bS\u0002\u0011\r\u0011\"\u0002k\u0011\u0019q\u0007\u0001)A\u0007W\")q\u000e\u0001C\u0003S!)\u0001\u000f\u0001C\u0003S!)\u0011\u000f\u0001C\u0003\u001b\")!\u000f\u0001C\u0001g\")a\u000f\u0001C\u0003o\n!\u0001+Y4f\u0015\taR$A\u0005j[6,H/\u00192mK*\u0011adH\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u00111eN\n\u0003\u0001\u0011\u0002\"!\n\u0014\u000e\u0003}I!aJ\u0010\u0003\r\u0005s\u0017PU3g\u0003\rqW/\\\u000b\u0002UA\u0011QeK\u0005\u0003Y}\u00111!\u00138u\u0003\u0011qW/\u001c\u0011\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$S\u0007E\u00021gUj\u0011!\r\u0006\u0003e}\tqA]3gY\u0016\u001cG/\u0003\u00025c\tA1\t\\1tgR\u000bw\r\u0005\u00027o1\u0001A!\u0002\u001d\u0001\u0005\u0004I$!\u0001+\u0012\u0005ij\u0004CA\u0013<\u0013\tatDA\u0004O_RD\u0017N\\4\u0011\u0005\u0015r\u0014BA  \u0005\r\te._\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\t3ECA\"F!\r!\u0005!N\u0007\u00027!)a\u0006\u0002a\u0002_!)\u0001\u0006\u0002a\u0001U\u0005A\u0001+Y4f'&TX-F\u0001J\u001f\u0005QUD\u0001\t\u0001\u0003%\u0001\u0016mZ3TSj,\u0007%\u0001\u0003oKb$X#A\"\u0002\u00119,\u0007\u0010^0%KF$\"\u0001U*\u0011\u0005\u0015\n\u0016B\u0001* \u0005\u0011)f.\u001b;\t\u000fQC\u0011\u0011!a\u0001\u0007\u0006\u0019\u0001\u0010J\u0019\u0002\u000b9,\u0007\u0010\u001e\u0011\u0002\u000b1\fG/\u001a:\u0002\u00131\fG/\u001a:`I\u0015\fHC\u0001)Z\u0011\u001d!6\"!AA\u0002\r\u000ba\u0001\\1uKJ\u0004\u0013A\u00024jY2,G-\u0001\u0006gS2dW\rZ0%KF$\"\u0001\u00150\t\u000fQs\u0011\u0011!a\u0001U\u00059a-\u001b7mK\u0012\u0004\u0013AB5t\u0019\u0006\u001cH/F\u0001c!\t)3-\u0003\u0002e?\t9!i\\8mK\u0006t\u0017AC5t\u0019\u0006\u001cHo\u0018\u0013fcR\u0011\u0001k\u001a\u0005\b)F\t\t\u00111\u0001c\u0003\u001dI7\u000fT1ti\u0002\nA\u0001Z1uCV\t1\u000eE\u0002&YVJ!!\\\u0010\u0003\u000b\u0005\u0013(/Y=\u0002\u000b\u0011\fG/\u0019\u0011\u0002\u000bM$\u0018M\u001d;\u0002\u0007\u0015tG-\u0001\u0004mCR,7\u000f^\u0001\u0006CB\u0004H.\u001f\u000b\u0003kQDQ!\u001e\rA\u0002)\nQ!\u001b8eKb\fq!\u00193e\u001b>\u0014X\r\u0006\u0002Dq\")\u00110\u0007a\u0001u\u0006!Qn\u001c:f!\u0019)3p\u001b\u0016+U%\u0011Ap\b\u0002\n\rVt7\r^5p]N\u0002")
public class Page<T> {
    private final int num;
    private final ClassTag<T> evidence$5;
    private Page<T> next;
    private Page<T> later;
    private int filled;
    private boolean isLast;
    private final Object data;

    public int num() {
        return this.num;
    }

    private final int PageSize() {
        return 4096;
    }

    public Page<T> next() {
        return this.next;
    }

    public void next_$eq(Page<T> x$1) {
        this.next = x$1;
    }

    public Page<T> later() {
        return this.later;
    }

    public void later_$eq(Page<T> x$1) {
        this.later = x$1;
    }

    public int filled() {
        return this.filled;
    }

    public void filled_$eq(int x$1) {
        this.filled = x$1;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void isLast_$eq(boolean x$1) {
        this.isLast = x$1;
    }

    public final Object data() {
        return this.data;
    }

    public final int start() {
        return this.num() * 4096;
    }

    public final int end() {
        return this.start() + this.filled();
    }

    public final Page<T> latest() {
        if (this.later().next() != null) {
            this.later_$eq(this.later().next().latest());
        }
        return this.later();
    }

    public T apply(int index) {
        if (index < this.start() || index - this.start() >= this.filled()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(index)).toString());
        }
        return (T)ScalaRunTime$.MODULE$.array_apply(this.data(), index - this.start());
    }

    public final Page<T> addMore(Function3<Object, Object, Object, Object> more) {
        while (this_.filled() == 4096) {
            this_.next_$eq(new Page<T>(this_.num() + 1, this_.evidence$5));
            Page<T> this_ = this_.next();
        }
        int count = BoxesRunTime.unboxToInt(more.apply(this_.data(), BoxesRunTime.boxToInteger(this_.filled()), BoxesRunTime.boxToInteger(4096 - this_.filled())));
        if (count < 0) {
            this_.isLast_$eq(true);
        } else {
            this_.filled_$eq(this_.filled() + count);
        }
        return this_;
    }

    public Page(int num, ClassTag<T> evidence$5) {
        this.num = num;
        this.evidence$5 = evidence$5;
        this.next = null;
        this.later = this;
        this.filled = 0;
        this.isLast = false;
        this.data = evidence$5.newArray(4096);
    }
}

