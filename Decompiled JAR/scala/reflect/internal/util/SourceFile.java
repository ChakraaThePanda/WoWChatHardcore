/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.Position$;
import scala.reflect.io.AbstractFile;
import scala.runtime.RichChar$;

@ScalaSignature(bytes="\u0006\u0001\u0005Eb!\u0002\f\u0018\u0003\u0003\u0001\u0003\"B\u0013\u0001\t\u00031\u0003\"B\u0015\u0001\r\u0003Q\u0003\"B\u0019\u0001\r\u0003\u0011\u0004\"B\u001d\u0001\r\u0003Q\u0004\"B\"\u0001\r\u0003!\u0005\"\u0002$\u0001\r\u00039\u0005\"\u0002%\u0001\r\u0003I\u0005\"\u0002&\u0001\r\u0003I\u0005\"B&\u0001\t\u0003a\u0005\"\u0002*\u0001\r\u0003\u0019\u0006\"B+\u0001\r\u00031\u0006\"B-\u0001\t\u0003Q\u0006\"\u0002/\u0001\t\u0003j\u0006\"B5\u0001\t\u0003Q\u0007\"B6\u0001\t\u0003a\u0007\"\u00028\u0001\t\u000by\u0007\"\u0002=\u0001\t\u0003I\bBB@\u0001\r\u0003\t\t\u0001C\u0005\u0002\u001a\u0001\t\n\u0011\"\u0001\u0002\u001c!I\u0011Q\u0006\u0001\u0012\u0002\u0013\u0005\u00111\u0004\u0005\u0007\u0003_\u0001AQA$\u0003\u0015M{WO]2f\r&dWM\u0003\u0002\u00193\u0005!Q\u000f^5m\u0015\tQ2$\u0001\u0005j]R,'O\\1m\u0015\taR$A\u0004sK\u001adWm\u0019;\u000b\u0003y\tQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001CA\u0011!eI\u0007\u0002;%\u0011A%\b\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u00059\u0003C\u0001\u0015\u0001\u001b\u00059\u0012aB2p]R,g\u000e^\u000b\u0002WA\u0019!\u0005\f\u0018\n\u00055j\"!B!se\u0006L\bC\u0001\u00120\u0013\t\u0001TD\u0001\u0003DQ\u0006\u0014\u0018\u0001\u00024jY\u0016,\u0012a\r\t\u0003i]j\u0011!\u000e\u0006\u0003mm\t!![8\n\u0005a*$\u0001D!cgR\u0014\u0018m\u0019;GS2,\u0017aC5t\u0019&tWM\u0011:fC.$\"a\u000f \u0011\u0005\tb\u0014BA\u001f\u001e\u0005\u001d\u0011un\u001c7fC:DQa\u0010\u0003A\u0002\u0001\u000b1!\u001b3y!\t\u0011\u0013)\u0003\u0002C;\t\u0019\u0011J\u001c;\u0002\u0017%\u001cXI\u001c3PM2Kg.\u001a\u000b\u0003w\u0015CQaP\u0003A\u0002\u0001\u000bq\"[:TK247i\u001c8uC&tW\rZ\u000b\u0002w\u00051A.\u001a8hi\",\u0012\u0001Q\u0001\nY&tWmQ8v]R\f\u0001\u0002]8tSRLwN\u001c\u000b\u0003\u001bB\u0003\"\u0001\u000b(\n\u0005=;\"\u0001\u0003)pg&$\u0018n\u001c8\t\u000bEK\u0001\u0019\u0001!\u0002\r=4gm]3u\u00031ygMZ:fiR{G*\u001b8f)\t\u0001E\u000bC\u0003R\u0015\u0001\u0007\u0001)\u0001\u0007mS:,Gk\\(gMN,G\u000f\u0006\u0002A/\")\u0001l\u0003a\u0001\u0001\u0006)\u0011N\u001c3fq\u0006A\u0002o\\:ji&|g.\u00138VYRLW.\u0019;f'>,(oY3\u0015\u00055[\u0006\"B&\r\u0001\u0004i\u0015\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003y\u0003\"a\u00184\u000f\u0005\u0001$\u0007CA1\u001e\u001b\u0005\u0011'BA2 \u0003\u0019a$o\\8u}%\u0011Q-H\u0001\u0007!J,G-\u001a4\n\u0005\u001dD'AB*ue&twM\u0003\u0002f;\u0005!\u0001/\u0019;i+\u0005q\u0016\u0001\u00047j]\u0016$vn\u0015;sS:<GC\u00010n\u0011\u0015Av\u00021\u0001A\u00039\u00198.\u001b9XQ&$Xm\u001d9bG\u0016$\"\u0001\u00119\t\u000bE\u0003\u0002\u0019\u0001!)\u0005A\u0011\bCA:w\u001b\u0005!(BA;\u001e\u0003)\tgN\\8uCRLwN\\\u0005\u0003oR\u0014q\u0001^1jYJ,7-\u0001\u0006jI\u0016tG/\u001b4jKJ$\"A_?\u0011\u0007\tZh,\u0003\u0002};\t1q\n\u001d;j_:DQA`\tA\u00025\u000b1\u0001]8t\u0003\u0015a\u0017N\\3t)\u0019\t\u0019!!\u0005\u0002\u0016A)\u0011QAA\u0006=:\u0019!%a\u0002\n\u0007\u0005%Q$A\u0004qC\u000e\\\u0017mZ3\n\t\u00055\u0011q\u0002\u0002\t\u0013R,'/\u0019;pe*\u0019\u0011\u0011B\u000f\t\u0011\u0005M!\u0003%AA\u0002\u0001\u000bQa\u001d;beRD\u0001\"a\u0006\u0013!\u0003\u0005\r\u0001Q\u0001\u0004K:$\u0017a\u00047j]\u0016\u001cH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0005\u0005u!f\u0001!\u0002 -\u0012\u0011\u0011\u0005\t\u0005\u0003G\tI#\u0004\u0002\u0002&)\u0019\u0011q\u0005;\u0002\u0013Ut7\r[3dW\u0016$\u0017\u0002BA\u0016\u0003K\u0011\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u0003=a\u0017N\\3tI\u0011,g-Y;mi\u0012\u0012\u0014AB5t\u0015\u00064\u0018\r")
public abstract class SourceFile {
    public abstract char[] content();

    public abstract AbstractFile file();

    public abstract boolean isLineBreak(int var1);

    public abstract boolean isEndOfLine(int var1);

    public abstract boolean isSelfContained();

    public abstract int length();

    public abstract int lineCount();

    /*
     * WARNING - void declaration
     */
    public Position position(int offset) {
        void assert_assertion;
        boolean bl;
        boolean bl2 = bl = offset < this.length();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)SourceFile.$anonfun$position$1(this, offset)).toString());
        }
        return Position$.MODULE$.offset(this, offset);
    }

    public abstract int offsetToLine(int var1);

    public abstract int lineToOffset(int var1);

    public Position positionInUltimateSource(Position position) {
        return position;
    }

    public String toString() {
        return this.file().name();
    }

    public String path() {
        return this.file().path();
    }

    public String lineToString(int index) {
        int start;
        int end;
        for (end = start = this.lineToOffset(index); end < this.length() && !this.isEndOfLine(end); ++end) {
        }
        return new String(this.content(), start, end - start);
    }

    public final int skipWhitespace(int offset) {
        while (true) {
            char c = this.content()[offset];
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (!RichChar$.MODULE$.isWhitespace$extension(c)) break;
            ++offset;
        }
        return offset;
    }

    public Option<String> identifier(Position pos) {
        return None$.MODULE$;
    }

    public abstract Iterator<String> lines(int var1, int var2);

    public int lines$default$1() {
        return 0;
    }

    public int lines$default$2() {
        return this.lineCount();
    }

    public final boolean isJava() {
        return this.file().name().endsWith(".java");
    }

    public static final /* synthetic */ String $anonfun$position$1(SourceFile $this, int offset$1) {
        return new StringBuilder(4).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd($this.file()), ": ")).append(offset$1).append(" >= ").append($this.length()).toString();
    }
}

