/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.collection.immutable.Set;
import scala.reflect.ScalaSignature;
import scala.reflect.macros.Attachments;

@ScalaSignature(bytes="\u0006\u0001\u00153A!\u0003\u0006\u0007#!Aq\u0003\u0001BC\u0002\u0013\u0005\u0003\u0004\u0003\u0005&\u0001\t\u0005\t\u0015!\u0003\u001a\u0011!1\u0003A!b\u0001\n\u0003:\u0003\u0002C\u001a\u0001\u0005\u0003\u0005\u000b\u0011\u0002\u0015\t\u000bQ\u0002A\u0011A\u001b\u0006\te\u0002\u0001!\u0007\u0005\u0006u\u0001!\ta\u000f\u0005\u0006\u0001\u0002!\t%\u0011\u0002\u0014\u001d>tW-\u001c9us\u0006#H/Y2i[\u0016tGo\u001d\u0006\u0003\u00171\ta!\\1de>\u001c(BA\u0007\u000f\u0003\u001d\u0011XM\u001a7fGRT\u0011aD\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u00112d\u0005\u0002\u0001'A\u0011A#F\u0007\u0002\u0015%\u0011aC\u0003\u0002\f\u0003R$\u0018m\u00195nK:$8/A\u0002q_N,\u0012!\u0007\t\u00035ma\u0001\u0001B\u0003\u001d\u0001\t\u0007QDA\u0001Q#\tq\"\u0005\u0005\u0002 A5\ta\"\u0003\u0002\"\u001d\t!a*\u001e7m!\ty2%\u0003\u0002%\u001d\t\u0019\u0011I\\=\u0002\tA|7\u000fI\u0001\u0004C2dW#\u0001\u0015\u0011\u0007%\u0002$E\u0004\u0002+]A\u00111FD\u0007\u0002Y)\u0011Q\u0006E\u0001\u0007yI|w\u000e\u001e \n\u0005=r\u0011A\u0002)sK\u0012,g-\u0003\u00022e\t\u00191+\u001a;\u000b\u0005=r\u0011\u0001B1mY\u0002\na\u0001P5oSRtDc\u0001\u001c8qA\u0019A\u0003A\r\t\u000b])\u0001\u0019A\r\t\u000b\u0019*\u0001\u0019\u0001\u0015\u0003\u0007A{7/A\u0004xSRD\u0007k\\:\u0015\u0005Yb\u0004\"B\u001f\b\u0001\u0004q\u0014A\u00028foB{7\u000f\u0005\u0002@\r5\t\u0001!A\u0004jg\u0016k\u0007\u000f^=\u0016\u0003\t\u0003\"aH\"\n\u0005\u0011s!a\u0002\"p_2,\u0017M\u001c")
public final class NonemptyAttachments<P>
extends Attachments {
    private final P pos;
    private final Set<Object> all;

    public P pos() {
        return this.pos;
    }

    @Override
    public Set<Object> all() {
        return this.all;
    }

    public NonemptyAttachments<P> withPos(P newPos) {
        return new NonemptyAttachments<P>(newPos, this.all());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public NonemptyAttachments(P pos, Set<Object> all) {
        this.pos = pos;
        this.all = all;
    }
}

