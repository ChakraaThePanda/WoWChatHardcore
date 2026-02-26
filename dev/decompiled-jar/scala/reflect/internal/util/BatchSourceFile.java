/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.Option;
import scala.PartialFunction$;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.immutable.Range;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Chars$;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.SourceFile;
import scala.reflect.io.AbstractFile;
import scala.reflect.io.VirtualFile;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichChar$;
import scala.runtime.RichInt$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u0005-c\u0001\u0002\u000e\u001c\u0001\u0011B\u0001\"\u000b\u0001\u0003\u0006\u0004%\tA\u000b\u0005\tc\u0001\u0011\t\u0011)A\u0005W!A!\u0007\u0001B\u0001B\u0003%1\u0007C\u0003;\u0001\u0011\u00051\bC\u0003;\u0001\u0011\u0005q\bC\u0003;\u0001\u0011\u0005!\tC\u0003;\u0001\u0011\u0005\u0011\fC\u0004]\u0001\t\u0007I\u0011A/\t\ry\u0003\u0001\u0015!\u00034\u0011\u0015y\u0006\u0001\"\u0001a\u0011\u0015!\u0007\u0001\"\u0001a\u0011\u0015)\u0007\u0001\"\u0001a\u0011\u00151\u0007\u0001\"\u0001h\u0011\u0015Y\u0007\u0001\"\u0011m\u0011\u0015)\b\u0001\"\u0003w\u0011\u0019y\b\u0001\"\u0001\u0002\u0002!9\u0011Q\u0001\u0001\u0005\u0002\u0005\u001d\u0001bBA\u0006\u0001\u0011\u0005\u0011Q\u0002\u0005\u000b\u0003#\u0001\u0001R1A\u0005\n\u0005M\u0001bBA\f\u0001\u0011\u0005\u0011\u0011\u0004\u0005\b\u0003?\u0001\u0001\u0015)\u0003b\u0011\u001d\t\t\u0003\u0001C\u0001\u0003GAq!!\u000b\u0001\t\u0003\nY\u0003C\u0004\u0002:\u0001!\t%a\u000f\t\u000f\u0005\u001d\u0003\u0001\"\u0011\u0002J\ty!)\u0019;dQN{WO]2f\r&dWM\u0003\u0002\u001d;\u0005!Q\u000f^5m\u0015\tqr$\u0001\u0005j]R,'O\\1m\u0015\t\u0001\u0013%A\u0004sK\u001adWm\u0019;\u000b\u0003\t\nQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001KA\u0011aeJ\u0007\u00027%\u0011\u0001f\u0007\u0002\u000b'>,(oY3GS2,\u0017\u0001\u00024jY\u0016,\u0012a\u000b\t\u0003Y=j\u0011!\f\u0006\u0003]}\t!![8\n\u0005Aj#\u0001D!cgR\u0014\u0018m\u0019;GS2,\u0017!\u00024jY\u0016\u0004\u0013\u0001C2p]R,g\u000e\u001e\u0019\u0011\u0007Q*t'D\u0001\"\u0013\t1\u0014EA\u0003BeJ\f\u0017\u0010\u0005\u00025q%\u0011\u0011(\t\u0002\u0005\u0007\"\f'/\u0001\u0004=S:LGO\u0010\u000b\u0004yur\u0004C\u0001\u0014\u0001\u0011\u0015IC\u00011\u0001,\u0011\u0015\u0011D\u00011\u00014)\ta\u0004\tC\u0003B\u000b\u0001\u00071&A\u0003`M&dW\rF\u0002=\u0007BCQ\u0001\u0012\u0004A\u0002\u0015\u000b!b]8ve\u000e,g*Y7f!\t1UJ\u0004\u0002H\u0017B\u0011\u0001*I\u0007\u0002\u0013*\u0011!jI\u0001\u0007yI|w\u000e\u001e \n\u00051\u000b\u0013A\u0002)sK\u0012,g-\u0003\u0002O\u001f\n11\u000b\u001e:j]\u001eT!\u0001T\u0011\t\u000bE3\u0001\u0019\u0001*\u0002\u0005\r\u001c\bcA*Wo9\u0011A\u0007V\u0005\u0003+\u0006\nq\u0001]1dW\u0006<W-\u0003\u0002X1\n\u00191+Z9\u000b\u0005U\u000bCc\u0001\u001f[7\")\u0011f\u0002a\u0001W!)\u0011k\u0002a\u0001%\u000691m\u001c8uK:$X#A\u001a\u0002\u0011\r|g\u000e^3oi\u0002\na\u0001\\3oORDW#A1\u0011\u0005Q\u0012\u0017BA2\"\u0005\rIe\u000e^\u0001\nY&tWmQ8v]R\fQa\u001d;beR\fq\"[:TK247i\u001c8uC&tW\rZ\u000b\u0002QB\u0011A'[\u0005\u0003U\u0006\u0012qAQ8pY\u0016\fg.\u0001\u0006jI\u0016tG/\u001b4jKJ$\"!\u001c9\u0011\u0007QrW)\u0003\u0002pC\t1q\n\u001d;j_:DQ!\u001d\bA\u0002I\f1\u0001]8t!\t13/\u0003\u0002u7\tA\u0001k\\:ji&|g.A\u0006dQ\u0006\u0014\u0018\t^%t\u000b>cECA<~)\tA\u0007\u0010C\u0003z\u001f\u0001\u0007!0A\u0001q!\u0011!4p\u000e5\n\u0005q\f#!\u0003$v]\u000e$\u0018n\u001c82\u0011\u0015qx\u00021\u0001b\u0003\rIG\r_\u0001\fSNd\u0015N\\3Ce\u0016\f7\u000eF\u0002i\u0003\u0007AQA \tA\u0002\u0005\f1\"[:F]\u0012|e\rT5oKR\u0019\u0001.!\u0003\t\u000by\f\u0002\u0019A1\u0002\u001b%\u001c\u0018\t^#oI>3G*\u001b8f)\rA\u0017q\u0002\u0005\u0006}J\u0001\r!Y\u0001\fY&tW-\u00138eS\u000e,7/\u0006\u0002\u0002\u0016A\u0019A'N1\u0002\u00191Lg.\u001a+p\u001f\u001a47/\u001a;\u0015\u0007\u0005\fY\u0002\u0003\u0004\u0002\u001eQ\u0001\r!Y\u0001\u0006S:$W\r_\u0001\tY\u0006\u001cH\u000fT5oK\u0006aqN\u001a4tKR$v\u000eT5oKR\u0019\u0011-!\n\t\r\u0005\u001db\u00031\u0001b\u0003\u0019ygMZ:fi\u0006)A.\u001b8fgR1\u0011QFA\u001a\u0003k\u0001BaUA\u0018\u000b&\u0019\u0011\u0011\u0007-\u0003\u0011%#XM]1u_JDq!Z\f\u0011\u0002\u0003\u0007\u0011\r\u0003\u0005\u00028]\u0001\n\u00111\u0001b\u0003\r)g\u000eZ\u0001\u0007KF,\u0018\r\\:\u0015\u0007!\fi\u0004C\u0004\u0002@a\u0001\r!!\u0011\u0002\tQD\u0017\r\u001e\t\u0004i\u0005\r\u0013bAA#C\t\u0019\u0011I\\=\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012!\u0019")
public class BatchSourceFile
extends SourceFile {
    private int[] lineIndices;
    private final AbstractFile file;
    private final char[] content;
    private int lastLine;
    private volatile boolean bitmap$0;

    @Override
    public AbstractFile file() {
        return this.file;
    }

    @Override
    public char[] content() {
        return this.content;
    }

    @Override
    public int length() {
        return this.content().length;
    }

    @Override
    public int lineCount() {
        return this.lineIndices().length - 1;
    }

    public int start() {
        return 0;
    }

    @Override
    public boolean isSelfContained() {
        return true;
    }

    @Override
    public Option<String> identifier(Position pos) {
        if (pos.isDefined()) {
            SourceFile sourceFile = pos.source();
            if (sourceFile != null && sourceFile.equals(this) && pos.point() != -1) {
                Function1<Object, Object> & java.io.Serializable & Serializable takeWhile_p = (Function1<Object, Object> & java.io.Serializable & Serializable)c -> BoxesRunTime.boxToBoolean(BatchSourceFile.isOK$1(BoxesRunTime.unboxToChar(c)));
                ArrayOps.ofChar takeWhile_this = new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps((char[])new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(this.content())).drop(pos.point())));
                return new Some<String>(new String((char[])takeWhile_this.take(takeWhile_this.prefixLength(takeWhile_p))));
            }
        }
        return super.identifier(pos);
    }

    private boolean charAtIsEOL(int idx, Function1<Object, Object> p) {
        return idx < this.length() && this.notCRLF0$1(idx) && BoxesRunTime.unboxToBoolean(p.apply(BoxesRunTime.boxToCharacter(this.content()[idx])));
    }

    @Override
    public boolean isLineBreak(int idx) {
        return idx < this.length() && this.notCRLF0$1(idx) && Chars$.MODULE$.isLineBreakChar(this.content()[idx]);
    }

    @Override
    public boolean isEndOfLine(int idx) {
        return new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(this.content())).isDefinedAt(idx) && PartialFunction$.MODULE$.cond(BoxesRunTime.boxToCharacter(this.content()[idx]), new Serializable(null){
            public static final long serialVersionUID = 0L;

            public final <A1, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                boolean bl = 13 == x1 ? true : 10 == x1;
                Boolean bl2 = bl ? BoxesRunTime.boxToBoolean(true) : function1.apply(BoxesRunTime.boxToCharacter(x1));
                return (B1)bl2;
            }

            public final boolean isDefinedAt(char x1) {
                boolean bl = '\r' == x1 ? true : '\n' == x1;
                boolean bl2 = bl;
                return bl2;
            }
        });
    }

    public boolean isAtEndOfLine(int idx) {
        return idx < this.length() && this.notCRLF0$1(idx) && BatchSourceFile.$anonfun$isAtEndOfLine$1(this.content()[idx]);
    }

    private int[] lineIndices$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                this.lineIndices = this.calculateLineIndices$1(this.content());
                this.bitmap$0 = true;
            }
        }
        return this.lineIndices;
    }

    private int[] lineIndices() {
        if (!this.bitmap$0) {
            return this.lineIndices$lzycompute();
        }
        return this.lineIndices;
    }

    @Override
    public int lineToOffset(int index) {
        int offset = this.lineIndices()[index];
        if (offset < this.length()) {
            return offset;
        }
        throw new IndexOutOfBoundsException(Integer.toString(index));
    }

    @Override
    public int offsetToLine(int offset) {
        int[] lines = this.lineIndices();
        this.lastLine = this.findLine$1(0, lines.length, this.lastLine, offset, lines);
        return this.lastLine;
    }

    @Override
    public Iterator<String> lines(int start, int end) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int n = RichInt$.MODULE$.max$extension(start, 0);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichInt$.MODULE$.until$extension0(n, RichInt$.MODULE$.min$extension(end, this.lineCount())).iterator().map((Function1<Object, String> & java.io.Serializable & Serializable)ix -> BatchSourceFile.$anonfun$lines$1(this, BoxesRunTime.unboxToInt(ix)));
    }

    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof BatchSourceFile) {
            BatchSourceFile batchSourceFile = (BatchSourceFile)that;
            String string = this.file().path();
            String string2 = batchSourceFile.file().path();
            bl = !(string != null ? !string.equals(string2) : string2 != null) && this.start() == batchSourceFile.start();
        } else {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return Statics.anyHash(this.file().path()) + this.start();
    }

    private static final boolean isOK$1(char c) {
        return Chars$.MODULE$.isIdentifierPart(c) || Chars$.MODULE$.isOperatorPart(c);
    }

    private final boolean notCRLF0$1(int idx$1) {
        return this.content()[idx$1] != '\r' || !new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(this.content())).isDefinedAt(idx$1 + 1) || this.content()[idx$1 + 1] != '\n';
    }

    public static final /* synthetic */ boolean $anonfun$isAtEndOfLine$1(char x0$1) {
        switch (x0$1) {
            case '\n': 
            case '\r': {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ Object $anonfun$lineIndices$1(BatchSourceFile $this, ArrayBuffer buf$1, int i) {
        if ($this.isAtEndOfLine(i)) {
            return buf$1.$plus$eq(BoxesRunTime.boxToInteger(i + 1));
        }
        return BoxedUnit.UNIT;
    }

    private final int[] calculateLineIndices$1(char[] cs) {
        ArrayBuffer buf = new ArrayBuffer();
        buf.$plus$eq(BoxesRunTime.boxToInteger(0));
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, cs.length);
        if (range == null) {
            throw null;
        }
        Range foreach_this = range;
        if (!foreach_this.isEmpty()) {
            int foreach_i = foreach_this.start();
            while (true) {
                BatchSourceFile.$anonfun$lineIndices$1(this, buf, foreach_i);
                if (foreach_i == foreach_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach_i += foreach_this.step();
            }
        }
        buf.$plus$eq(BoxesRunTime.boxToInteger(cs.length));
        return (int[])buf.toArray(ClassTag$.MODULE$.Int());
    }

    private final int findLine$1(int lo, int hi, int mid, int offset$2, int[] lines$1) {
        while (true) {
            if (mid < lo || hi < mid) {
                return mid;
            }
            if (offset$2 < lines$1[mid]) {
                int n = mid - 1;
                mid = (lo + mid - 1) / 2;
                hi = n;
                continue;
            }
            if (offset$2 < lines$1[mid + 1]) break;
            int n = mid + 1;
            mid = (mid + 1 + hi) / 2;
            lo = n;
        }
        return mid;
    }

    public static final /* synthetic */ String $anonfun$lines$1(BatchSourceFile $this, int ix) {
        int off = $this.lineIndices()[ix];
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int len = RichInt$.MODULE$.max$extension(n, $this.lineIndices()[ix + 1] - off - 1);
        return String.valueOf($this.content(), off, len);
    }

    /*
     * Unable to fully structure code
     */
    public BatchSourceFile(AbstractFile file, char[] content0) {
        this.file = file;
        super();
        if (content0.length == 0) ** GOTO lbl-1000
        var3_3 = BoxesRunTime.unboxToChar(new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(content0)).last());
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (!RichChar$.MODULE$.isWhitespace$extension(var3_3)) lbl-1000:
        // 2 sources

        {
            v0 = (char[])new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(content0)).$colon$plus(BoxesRunTime.boxToCharacter('\n'), ClassTag$.MODULE$.Char());
        } else {
            v0 = content0;
        }
        this.content = v0;
        this.lastLine = 0;
    }

    public BatchSourceFile(AbstractFile _file) {
        this(_file, _file.toCharArray());
    }

    public BatchSourceFile(String sourceName, Seq<Object> cs) {
        this((AbstractFile)new VirtualFile(sourceName), (char[])cs.toArray(ClassTag$.MODULE$.Char()));
    }

    public BatchSourceFile(AbstractFile file, Seq<Object> cs) {
        this(file, (char[])cs.toArray(ClassTag$.MODULE$.Char()));
    }

    public static final /* synthetic */ Object $anonfun$isLineBreak$1$adapted(Object c) {
        return BoxesRunTime.boxToBoolean(Chars$.MODULE$.isLineBreakChar(BoxesRunTime.unboxToChar(c)));
    }

    public static final /* synthetic */ Object $anonfun$isAtEndOfLine$1$adapted(Object x0$1) {
        return BoxesRunTime.boxToBoolean(BatchSourceFile.$anonfun$isAtEndOfLine$1(BoxesRunTime.unboxToChar(x0$1)));
    }

    public static final /* synthetic */ Object $anonfun$lineIndices$1$adapted(BatchSourceFile $this, ArrayBuffer buf$1, Object i) {
        return BatchSourceFile.$anonfun$lineIndices$1($this, buf$1, BoxesRunTime.unboxToInt(i));
    }
}

