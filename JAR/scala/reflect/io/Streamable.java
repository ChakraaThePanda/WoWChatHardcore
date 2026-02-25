/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import scala.Function0;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.AbstractTraversable;
import scala.collection.Iterator;
import scala.collection.TraversableOnce;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayBuffer;
import scala.io.BufferedSource;
import scala.io.Codec;
import scala.io.Codec$;
import scala.io.Source$;
import scala.package$;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.io.Path$;
import scala.reflect.io.Streamable$;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.LazyRef;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction1$mcZI$sp;

@ScalaSignature(bytes="\u0006\u0001\u0005Uu!B\u000e\u001d\u0011\u0003\u0019c!B\u0013\u001d\u0011\u00031\u0003\"B\u0016\u0002\t\u0003acaB\u0017\u0002!\u0003\r\tA\f\u0005\u0006_\r!\t\u0001\r\u0005\u0006i\r1\t!\u000e\u0005\u0006{\r!\tA\u0010\u0005\u0006\u0005\u000e!\ta\u0011\u0005\u0006\u000f\u000e!\t\u0001\u0013\u0005\u0006'\u000e!\t\u0001\u0016\u0005\u00063\u000e!\tA\u0017\u0004\b=\u0006\u0001\n1!\u0001`\u0011\u0015y3\u0002\"\u00011\u0011\u0015\u00117\u0002\"\u0001d\u0011\u0015I7\u0002\"\u0001k\u0011\u0015\u00018\u0002\"\u0001r\u0011\u0015\u00018\u0002\"\u0001\u007f\u0011\u001d\t\ta\u0003C\u0001\u0003\u0007Aq!!\u0004\f\t\u0003\ty\u0001C\u0004\u0002\u000e-!\t!a\u0006\t\u000f\u0005m1\u0002\"\u0001\u0002\u001e!9\u0011\u0011I\u0006\u0005\u0002\u0005\r\u0003bBA!\u0017\u0011\u0005\u0011Q\t\u0005\b\u0003\u0013\nA\u0011AA&\u0011\u00199\u0015\u0001\"\u0001\u0002l!9\u0011\u0011I\u0001\u0005\u0002\u0005]\u0004bBA!\u0003\u0011\u0005\u0011qP\u0001\u000b'R\u0014X-Y7bE2,'BA\u000f\u001f\u0003\tIwN\u0003\u0002 A\u00059!/\u001a4mK\u000e$(\"A\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u0011A%A\u0007\u00029\tQ1\u000b\u001e:fC6\f'\r\\3\u0014\u0005\u00059\u0003C\u0001\u0015*\u001b\u0005\u0001\u0013B\u0001\u0016!\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012a\t\u0002\u0006\u0005f$Xm]\n\u0003\u0007\u001d\na\u0001J5oSR$C#A\u0019\u0011\u0005!\u0012\u0014BA\u001a!\u0005\u0011)f.\u001b;\u0002\u0017%t\u0007/\u001e;TiJ,\u0017-\u001c\u000b\u0002mA\u0011qgO\u0007\u0002q)\u0011Q$\u000f\u0006\u0002u\u0005!!.\u0019<b\u0013\ta\u0004HA\u0006J]B,Ho\u0015;sK\u0006l\u0017A\u00027f]\u001e$\b.F\u0001@!\tA\u0003)\u0003\u0002BA\t!Aj\u001c8h\u00035\u0011WO\u001a4fe\u0016$\u0017J\u001c9viR\tA\t\u0005\u00028\u000b&\u0011a\t\u000f\u0002\u0014\u0005V4g-\u001a:fI&s\u0007/\u001e;TiJ,\u0017-\\\u0001\u0006Ef$Xm\u001d\u000b\u0002\u0013B\u0019!*\u0014)\u000f\u0005!Z\u0015B\u0001'!\u0003\u001d\u0001\u0018mY6bO\u0016L!AT(\u0003\u0011%#XM]1u_JT!\u0001\u0014\u0011\u0011\u0005!\n\u0016B\u0001*!\u0005\u0011\u0011\u0015\u0010^3\u0002\u0017\tLH/Z:Bg&sGo\u001d\u000b\u0002+B\u0019!*\u0014,\u0011\u0005!:\u0016B\u0001-!\u0005\rIe\u000e^\u0001\fi>\u0014\u0015\u0010^3BeJ\f\u0017\u0010F\u0001\\!\rAC\fU\u0005\u0003;\u0002\u0012Q!\u0011:sCf\u0014Qa\u00115beN\u001c2aC\u0014a!\t\t7!D\u0001\u0002\u00035\u0019'/Z1uS>t7i\u001c3fGV\tA\r\u0005\u0002fO6\taM\u0003\u0002\u001eA%\u0011\u0001N\u001a\u0002\u0006\u0007>$WmY\u0001\u0006G\"\f'o\u001d\u000b\u0003W:\u0004\"!\u001a7\n\u000554'A\u0004\"vM\u001a,'/\u001a3T_V\u00148-\u001a\u0005\u0006_:\u0001\r\u0001Z\u0001\u0006G>$WmY\u0001\u0006Y&tWm\u001d\u000b\u0002eB\u0019!*T:\u0011\u0005Q\\hBA;z!\t1\b%D\u0001x\u0015\tA(%\u0001\u0004=e>|GOP\u0005\u0003u\u0002\na\u0001\u0015:fI\u00164\u0017B\u0001?~\u0005\u0019\u0019FO]5oO*\u0011!\u0010\t\u000b\u0003e~DQa\u001c\tA\u0002\u0011\faA]3bI\u0016\u0014H\u0003BA\u0003\u0003\u0017\u00012aNA\u0004\u0013\r\tI\u0001\u000f\u0002\u0012\u0013:\u0004X\u000f^*ue\u0016\fWNU3bI\u0016\u0014\b\"B8\u0012\u0001\u0004!\u0017A\u00042vM\u001a,'/\u001a3SK\u0006$WM\u001d\u000b\u0003\u0003#\u00012aNA\n\u0013\r\t)\u0002\u000f\u0002\u000f\u0005V4g-\u001a:fIJ+\u0017\rZ3s)\u0011\t\t\"!\u0007\t\u000b=\u001c\u0002\u0019\u00013\u0002\u0017\u0005\u0004\b\u000f\\=SK\u0006$WM]\u000b\u0005\u0003?\t)\u0003\u0006\u0003\u0002\"\u0005]\u0002\u0003BA\u0012\u0003Ka\u0001\u0001B\u0004\u0002(Q\u0011\r!!\u000b\u0003\u0003Q\u000bB!a\u000b\u00022A\u0019\u0001&!\f\n\u0007\u0005=\u0002EA\u0004O_RD\u0017N\\4\u0011\u0007!\n\u0019$C\u0002\u00026\u0001\u00121!\u00118z\u0011\u001d\tI\u0004\u0006a\u0001\u0003w\t\u0011A\u001a\t\bQ\u0005u\u0012\u0011CA\u0011\u0013\r\ty\u0004\t\u0002\n\rVt7\r^5p]F\nQa\u001d7veB$\u0012a\u001d\u000b\u0004g\u0006\u001d\u0003\"B8\u0017\u0001\u0004!\u0017aB2m_NLgnZ\u000b\u0007\u0003\u001b\ni&a\u0015\u0015\t\u0005=\u0013q\r\u000b\u0005\u0003#\n9\u0006\u0005\u0003\u0002$\u0005MCaBA+/\t\u0007\u0011\u0011\u0006\u0002\u0002+\"9\u0011\u0011H\fA\u0002\u0005e\u0003c\u0002\u0015\u0002>\u0005m\u0013\u0011\u000b\t\u0005\u0003G\ti\u0006B\u0004\u0002(]\u0011\r!a\u0018\u0012\t\u0005-\u0012\u0011\r\t\u0004o\u0005\r\u0014bAA3q\tI1\t\\8tK\u0006\u0014G.\u001a\u0005\b\u0003S:\u0002\u0019AA.\u0003\u0019\u0019HO]3b[R\u00191,!\u001c\t\u0011\u0005=\u0004\u0004\"a\u0001\u0003c\n!![:\u0011\t!\n\u0019HN\u0005\u0004\u0003k\u0002#\u0001\u0003\u001fcs:\fW.\u001a \u0015\t\u0005e\u0014Q\u0010\u000b\u0004g\u0006m\u0004\"B8\u001a\u0001\b!\u0007\u0002CA83\u0011\u0005\r!!\u001d\u0015\t\u0005\u0005\u0015Q\u0011\u000b\u0004g\u0006\r\u0005\"B8\u001b\u0001\b!\u0007bBAD5\u0001\u0007\u0011\u0011R\u0001\u0004kJd\u0007\u0003BAF\u0003#k!!!$\u000b\u0007\u0005=\u0015(A\u0002oKRLA!a%\u0002\u000e\n\u0019QK\u0015'")
public final class Streamable {
    public static String slurp(URL uRL, Codec codec) {
        return Streamable$.MODULE$.slurp(uRL, codec);
    }

    public static String slurp(Function0<InputStream> function0, Codec codec) {
        return Streamable$.MODULE$.slurp(function0, codec);
    }

    public static byte[] bytes(Function0<InputStream> function0) {
        return Streamable$.MODULE$.bytes(function0);
    }

    public static <T extends Closeable, U> U closing(T t, Function1<T, U> function1) {
        return Streamable$.MODULE$.closing(t, function1);
    }

    public static interface Bytes {
        public InputStream inputStream();

        public static /* synthetic */ long length$(Bytes $this) {
            return $this.length();
        }

        default public long length() {
            return -1L;
        }

        public static /* synthetic */ BufferedInputStream bufferedInput$(Bytes $this) {
            return $this.bufferedInput();
        }

        default public BufferedInputStream bufferedInput() {
            return new BufferedInputStream(this.inputStream());
        }

        public static /* synthetic */ Iterator bytes$(Bytes $this) {
            return $this.bytes();
        }

        default public Iterator<Object> bytes() {
            return this.bytesAsInts().map((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToByte(Bytes.$anonfun$bytes$1(BoxesRunTime.unboxToInt(x$1))));
        }

        public static /* synthetic */ Iterator bytesAsInts$(Bytes $this) {
            return $this.bytesAsInts();
        }

        /*
         * WARNING - void declaration
         */
        default public Iterator<Object> bytesAsInts() {
            void continually_elem;
            BufferedInputStream in = this.bufferedInput();
            JFunction0$mcI$sp & Serializable intersect = (JFunction0$mcI$sp & Serializable)() -> in.read();
            if (package$.MODULE$.Iterator() == null) {
                throw null;
            }
            return new AbstractIterator<A>((Function0)continually_elem){
                private final Function0 elem$3;

                public boolean hasNext() {
                    return true;
                }

                public A next() {
                    return (A)this.elem$3.apply();
                }
                {
                    this.elem$3 = elem$3;
                }
            }.takeWhile((JFunction1$mcZI$sp & Serializable)x$2 -> x$2 != -1);
        }

        public static /* synthetic */ byte[] toByteArray$(Bytes $this) {
            return $this.toByteArray();
        }

        default public byte[] toByteArray() {
            LazyRef in$lzy = new LazyRef();
            if (this.length() == -1L) {
                return (byte[])((AbstractTraversable)((Object)new ArrayBuffer().$plus$plus$eq((TraversableOnce)this.bytes()))).toArray(ClassTag$.MODULE$.Byte());
            }
            byte[] arr = new byte[(int)this.length()];
            int len = arr.length;
            IntRef offset = IntRef.create(0);
            try {
                this.loop$1(offset, len, arr, in$lzy);
            }
            finally {
                this.in$2(in$lzy).close();
            }
            if (offset.elem == arr.length) {
                return arr;
            }
            String string = "Could not read entire source (%d of %d bytes)";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            throw Path$.MODULE$.fail(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(offset.elem), BoxesRunTime.boxToInteger(len)})));
        }

        public static /* synthetic */ byte $anonfun$bytes$1(int x$1) {
            return (byte)x$1;
        }

        private /* synthetic */ BufferedInputStream in$lzycompute$1(LazyRef in$lzy$1) {
            synchronized (in$lzy$1) {
                BufferedInputStream bufferedInputStream = in$lzy$1.initialized() ? (BufferedInputStream)in$lzy$1.value() : in$lzy$1.initialize(this.bufferedInput());
                return bufferedInputStream;
            }
        }

        private BufferedInputStream in$2(LazyRef in$lzy$1) {
            if (in$lzy$1.initialized()) {
                return (BufferedInputStream)in$lzy$1.value();
            }
            return this.in$lzycompute$1(in$lzy$1);
        }

        private void loop$1(IntRef offset$1, int len$1, byte[] arr$1, LazyRef in$lzy$1) {
            int read;
            while (offset$1.elem < len$1 && (read = this.in$2(in$lzy$1).read(arr$1, offset$1.elem, len$1 - offset$1.elem)) >= 0) {
                offset$1.elem += read;
            }
        }

        public static void $init$(Bytes $this) {
        }
    }

    public static interface Chars
    extends Bytes {
        public static /* synthetic */ Codec creationCodec$(Chars $this) {
            return $this.creationCodec();
        }

        default public Codec creationCodec() {
            Codec codec = Codec$.MODULE$.fallbackSystemCodec();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return codec;
        }

        public static /* synthetic */ BufferedSource chars$(Chars $this, Codec codec) {
            return $this.chars(codec);
        }

        default public BufferedSource chars(Codec codec) {
            return Source$.MODULE$.fromInputStream(this.inputStream(), codec);
        }

        public static /* synthetic */ Iterator lines$(Chars $this) {
            return $this.lines();
        }

        default public Iterator<String> lines() {
            return this.lines(this.creationCodec());
        }

        public static /* synthetic */ Iterator lines$(Chars $this, Codec codec) {
            return $this.lines(codec);
        }

        default public Iterator<String> lines(Codec codec) {
            return this.chars(codec).getLines();
        }

        public static /* synthetic */ InputStreamReader reader$(Chars $this, Codec codec) {
            return $this.reader(codec);
        }

        default public InputStreamReader reader(Codec codec) {
            return new InputStreamReader(this.inputStream(), codec.charSet());
        }

        public static /* synthetic */ BufferedReader bufferedReader$(Chars $this) {
            return $this.bufferedReader();
        }

        default public BufferedReader bufferedReader() {
            return this.bufferedReader(this.creationCodec());
        }

        public static /* synthetic */ BufferedReader bufferedReader$(Chars $this, Codec codec) {
            return $this.bufferedReader(codec);
        }

        default public BufferedReader bufferedReader(Codec codec) {
            return new BufferedReader(this.reader(codec));
        }

        public static /* synthetic */ Object applyReader$(Chars $this, Function1 f) {
            return $this.applyReader(f);
        }

        default public <T> T applyReader(Function1<BufferedReader, T> f) {
            T t;
            try (BufferedReader in = this.bufferedReader();){
                t = f.apply(in);
            }
            return t;
        }

        public static /* synthetic */ String slurp$(Chars $this) {
            return $this.slurp();
        }

        default public String slurp() {
            return this.slurp(this.creationCodec());
        }

        public static /* synthetic */ String slurp$(Chars $this, Codec codec) {
            return $this.slurp(codec);
        }

        default public String slurp(Codec codec) {
            String string;
            try (BufferedSource src = this.chars(codec);){
                string = src.mkString();
            }
            return string;
        }

        public static void $init$(Chars $this) {
        }
    }
}

