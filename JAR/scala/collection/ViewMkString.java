/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Serializable;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.StringBuilder;
import scala.reflect.ScalaSignature;
import scala.runtime.BooleanRef;

@ScalaSignature(bytes="\u0006\u0001Q3\u0001b\u0002\u0005\u0011\u0002\u0007\u0005Q\"\u0014\u0005\u0006'\u0001!\t\u0001\u0006\u0005\u00071\u0001\u0001K\u0011C\r\t\u000b%\u0002A\u0011\t\u0016\t\u000b%\u0002A\u0011\t\u001c\t\u000b%\u0002A\u0011I\u001d\t\u000b}\u0002A\u0011\t!\u0003\u0019YKWm^'l'R\u0014\u0018N\\4\u000b\u0005%Q\u0011AC2pY2,7\r^5p]*\t1\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00059\u00013C\u0001\u0001\u0010!\t\u0001\u0012#D\u0001\u000b\u0013\t\u0011\"B\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003U\u0001\"\u0001\u0005\f\n\u0005]Q!\u0001B+oSR\fq\u0001\u001e5jgN+\u0017/F\u0001\u001b!\rYBDH\u0007\u0002\u0011%\u0011Q\u0004\u0003\u0002\u0004'\u0016\f\bCA\u0010!\u0019\u0001!a!\t\u0001\u0005\u0006\u0004\u0011#!A!\u0012\u0005\r2\u0003C\u0001\t%\u0013\t)#BA\u0004O_RD\u0017N\\4\u0011\u0005A9\u0013B\u0001\u0015\u000b\u0005\r\te._\u0001\t[.\u001cFO]5oOV\t1\u0006\u0005\u0002-g9\u0011Q&\r\t\u0003])i\u0011a\f\u0006\u0003a1\ta\u0001\u0010:p_Rt\u0014B\u0001\u001a\u000b\u0003\u0019\u0001&/\u001a3fM&\u0011A'\u000e\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005IRACA\u00168\u0011\u0015AD\u00011\u0001,\u0003\r\u0019X\r\u001d\u000b\u0005WibT\bC\u0003<\u000b\u0001\u00071&A\u0003ti\u0006\u0014H\u000fC\u00039\u000b\u0001\u00071\u0006C\u0003?\u000b\u0001\u00071&A\u0002f]\u0012\f\u0011\"\u00193e'R\u0014\u0018N\\4\u0015\u000b\u0005C%j\u0013'\u0011\u0005\t+eB\u0001\tD\u0013\t!%\"A\u0004qC\u000e\\\u0017mZ3\n\u0005\u0019;%!D*ue&twMQ;jY\u0012,'O\u0003\u0002E\u0015!)\u0011J\u0002a\u0001\u0003\u0006\t!\rC\u0003<\r\u0001\u00071\u0006C\u00039\r\u0001\u00071\u0006C\u0003?\r\u0001\u00071FE\u0002O!F3Aa\u0014\u0001\u0001\u001b\naAH]3gS:,W.\u001a8u}A\u00191\u0004\u0001\u0010\u0011\u0007m\u0011f$\u0003\u0002T\u0011\tYAK]1wKJ\u001c\u0018M\u00197f\u0001")
public interface ViewMkString<A> {
    public static /* synthetic */ Seq thisSeq$(ViewMkString $this) {
        return $this.thisSeq();
    }

    default public Seq<A> thisSeq() {
        return ((ArrayBuffer)new ArrayBuffer().$plus$plus$eq((TraversableOnce)((Object)this))).result();
    }

    public static /* synthetic */ String mkString$(ViewMkString $this) {
        return $this.mkString();
    }

    default public String mkString() {
        return ((TraversableOnce)((Object)this)).mkString("");
    }

    public static /* synthetic */ String mkString$(ViewMkString $this, String sep) {
        return $this.mkString(sep);
    }

    default public String mkString(String sep) {
        return ((TraversableOnce)((Object)this)).mkString("", sep, "");
    }

    public static /* synthetic */ String mkString$(ViewMkString $this, String start, String sep, String end) {
        return $this.mkString(start, sep, end);
    }

    default public String mkString(String start, String sep, String end) {
        return this.thisSeq().addString(new StringBuilder(), start, sep, end).toString();
    }

    public static /* synthetic */ StringBuilder addString$(ViewMkString $this, StringBuilder b, String start, String sep, String end) {
        return $this.addString(b, start, sep, end);
    }

    default public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        BooleanRef first = BooleanRef.create(true);
        b.append(start);
        ((GenericTraversableTemplate)((Object)this)).foreach((Function1<Object, StringBuilder> & java.io.Serializable & Serializable)x -> {
            if (first$1.elem) {
                first$1.elem = false;
            } else {
                b.append(sep);
            }
            return b.append(x);
        });
        b.append(end);
        return b;
    }

    public static void $init$(ViewMkString $this) {
    }
}

