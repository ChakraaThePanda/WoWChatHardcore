/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.transform;

import scala.reflect.ScalaSignature;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.transform.PostErasure$elimErasedValueType$;

@ScalaSignature(bytes="\u0006\u0001\u00113q\u0001C\u0005\u0011\u0002\u0007\u0005!\u0003C\u0003\u0018\u0001\u0011\u0005\u0001\u0004C\u0004\u001d\u0001\t\u0007i\u0011A\u000f\b\u000b\t\u0002\u0001\u0012A\u0012\u0007\u000b\u0015\u0002\u0001\u0012\u0001\u0014\t\u000b=\"A\u0011\u0001\u0019\t\u000bE\"A\u0011\u0001\u001a\t\u000bi\u0002A\u0011A\u001e\u0003\u0017A{7\u000f^#sCN,(/\u001a\u0006\u0003\u0015-\t\u0011\u0002\u001e:b]N4wN]7\u000b\u00051i\u0011\u0001C5oi\u0016\u0014h.\u00197\u000b\u00059y\u0011a\u0002:fM2,7\r\u001e\u0006\u0002!\u0005)1oY1mC\u000e\u00011C\u0001\u0001\u0014!\t!R#D\u0001\u0010\u0013\t1rB\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003e\u0001\"\u0001\u0006\u000e\n\u0005my!\u0001B+oSR\faa\u001a7pE\u0006dW#\u0001\u0010\u0011\u0005}\u0001S\"A\u0006\n\u0005\u0005Z!aC*z[\n|G\u000eV1cY\u0016\f1#\u001a7j[\u0016\u0013\u0018m]3e-\u0006dW/\u001a+za\u0016\u0004\"\u0001\n\u0003\u000e\u0003\u0001\u00111#\u001a7j[\u0016\u0013\u0018m]3e-\u0006dW/\u001a+za\u0016\u001c\"\u0001B\u0014\u0011\u0005!JcB\u0001\u0013\u0003\u0013\tQ3FA\u0004UsB,W*\u00199\n\u00051j#\u0001\u0003+za\u0016l\u0015\r]:\u000b\u00059Z\u0011a\u0001;qK\u00061A(\u001b8jiz\"\u0012aI\u0001\u0006CB\u0004H.\u001f\u000b\u0003ga\u0002\"\u0001\u000b\u001b\n\u0005U2$\u0001\u0002+za\u0016L!aN\u0006\u0003\u000bQK\b/Z:\t\u000be2\u0001\u0019A\u001a\u0002\u0005Q\u0004\u0018!\u0004;sC:\u001chm\u001c:n\u0013:4w\u000eF\u00024y\rCQ!P\u0004A\u0002y\n1a]=n!\tAs(\u0003\u0002A\u0003\n11+_7c_2L!AQ\u0006\u0003\u000fMKXNY8mg\")\u0011h\u0002a\u0001g\u0001")
public interface PostErasure {
    public PostErasure$elimErasedValueType$ elimErasedValueType();

    public SymbolTable global();

    public static /* synthetic */ Types.Type transformInfo$(PostErasure $this, Symbols.Symbol sym, Types.Type tp) {
        return $this.transformInfo(sym, tp);
    }

    default public Types.Type transformInfo(Symbols.Symbol sym, Types.Type tp) {
        return this.elimErasedValueType().apply(tp);
    }

    public static void $init$(PostErasure $this) {
    }
}

