/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import scala.Console$;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.io.StdIn$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00055f\u0001C\r\u001b\u0003\u0003QB$a*\t\u000b\u0005\u0002A\u0011A\u0012\t\u000b\u0015\u0002a\u0011\u0003\u0014\t\u000bQ\u0002a\u0011C\u001b\t\u000ba\u0002a\u0011C\u001d\t\u000b}\u0002A\u0011\u0001!\t\u000b1\u0003A\u0011A'\t\u000bI\u0003A\u0011A*\t\u000ba\u0003A\u0011A-\t\u000by\u0003A\u0011A0\t\u000b\u0011\u0004A\u0011A3\t\u000b)\u0004A\u0011A6\t\u000b)\u0004A\u0011\u0001=\t\u000f\u0005%\u0001\u0001\"\u0001\u0002\f!9\u0011Q\u0003\u0001\u0005\u0002\u0005]\u0001bBA\u0011\u0001\u0011\u0005\u00111\u0005\u0005\b\u0003s\u0001A\u0011AA\u001e\u0011\u001d\t\t\u0005\u0001C\u0001\u0003\u0007Bq!a\u0014\u0001\t\u0003\t\t\u0006C\u0004\u0002^\u0001!\t!a\u0018\t\u000f\u0005u\u0003\u0001\"\u0001\u0002j!9\u0011Q\u000f\u0001\u0005\u0002\u0005]\u0004bBA;\u0001\u0011\u0005\u0011\u0011\u0011\u0005\b\u0003\u000f\u0003A\u0011AAE\u0011\u001d\t9\t\u0001C\u0001\u00037\u0013\u0011\u0003R3qe\u0016\u001c\u0017\r^3e\u0007>t7o\u001c7f\u0015\u0005Y\u0012!B:dC2\f7C\u0001\u0001\u001e!\tqr$D\u0001\u001b\u0013\t\u0001#D\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0004\u0001Q\tA\u0005\u0005\u0002\u001f\u0001\u0005a1/\u001a;PkR$\u0015N]3diR\u0011qE\u000b\t\u0003=!J!!\u000b\u000e\u0003\tUs\u0017\u000e\u001e\u0005\u0006W\t\u0001\r\u0001L\u0001\u0004_V$\bCA\u00173\u001b\u0005q#BA\u00181\u0003\tIwNC\u00012\u0003\u0011Q\u0017M^1\n\u0005Mr#a\u0003)sS:$8\u000b\u001e:fC6\fAb]3u\u000bJ\u0014H)\u001b:fGR$\"a\n\u001c\t\u000b]\u001a\u0001\u0019\u0001\u0017\u0002\u0007\u0015\u0014(/A\u0006tKRLe\u000eR5sK\u000e$HCA\u0014;\u0011\u0015YD\u00011\u0001=\u0003\tIg\u000e\u0005\u0002.{%\u0011aH\f\u0002\u000f\u0005V4g-\u001a:fIJ+\u0017\rZ3s\u0003-\u0011X-\u00193C_>dW-\u00198\u0015\u0003\u0005\u0003\"A\b\"\n\u0005\rS\"a\u0002\"p_2,\u0017M\u001c\u0015\u0005\u000b\u0015C%\n\u0005\u0002\u001f\r&\u0011qI\u0007\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%A%\u0002AU\u001cX\r\t;iK\u0002jW\r\u001e5pI\u0002Jg\u000eI:dC2\fg&[8/'R$\u0017J\\\u0011\u0002\u0017\u00061!GL\u00192]A\n\u0001B]3bI\nKH/\u001a\u000b\u0002\u001dB\u0011adT\u0005\u0003!j\u0011AAQ=uK\"\"a!\u0012%K\u0003!\u0011X-\u00193DQ\u0006\u0014H#\u0001+\u0011\u0005y)\u0016B\u0001,\u001b\u0005\u0011\u0019\u0005.\u0019:)\t\u001d)\u0005JS\u0001\u000be\u0016\fG\rR8vE2,G#\u0001.\u0011\u0005yY\u0016B\u0001/\u001b\u0005\u0019!u.\u001e2mK\"\"\u0001\"\u0012%K\u0003%\u0011X-\u00193GY>\fG\u000fF\u0001a!\tq\u0012-\u0003\u0002c5\t)a\t\\8bi\"\"\u0011\"\u0012%K\u0003\u001d\u0011X-\u00193J]R$\u0012A\u001a\t\u0003=\u001dL!\u0001\u001b\u000e\u0003\u0007%sG\u000f\u000b\u0003\u000b\u000b\"S\u0015\u0001\u0003:fC\u0012d\u0015N\\3\u0015\u00031\u0004\"!\u001c;\u000f\u00059\u0014\bCA8\u001b\u001b\u0005\u0001(BA9#\u0003\u0019a$o\\8u}%\u00111OG\u0001\u0007!J,G-\u001a4\n\u0005U4(AB*ue&twM\u0003\u0002t5!\"1\"\u0012%K)\ra\u0017p\u001f\u0005\u0006u2\u0001\r\u0001\\\u0001\u0005i\u0016DH\u000fC\u0003}\u0019\u0001\u0007Q0\u0001\u0003be\u001e\u001c\b\u0003\u0002\u0010\u007f\u0003\u0003I!a \u000e\u0003\u0015q\u0012X\r]3bi\u0016$g\bE\u0002\u001f\u0003\u0007I1!!\u0002\u001b\u0005\r\te.\u001f\u0015\u0005\u0019\u0015C%*\u0001\u0005sK\u0006$Gj\u001c8h)\t\ti\u0001E\u0002\u001f\u0003\u001fI1!!\u0005\u001b\u0005\u0011auN\\4)\t5)\u0005JS\u0001\ne\u0016\fGm\u00155peR$\"!!\u0007\u0011\u0007y\tY\"C\u0002\u0002\u001ei\u0011Qa\u00155peRDCAD#I\u0015\u0006)!/Z1eMR!\u0011QEA\u001a!\u0019\t9#!\f\u0002\u00029\u0019a$!\u000b\n\u0007\u0005-\"$A\u0004qC\u000e\\\u0017mZ3\n\t\u0005=\u0012\u0011\u0007\u0002\u0005\u0019&\u001cHOC\u0002\u0002,iAa!!\u000e\u0010\u0001\u0004a\u0017A\u00024pe6\fG\u000f\u000b\u0003\u0010\u000b\"S\u0015A\u0002:fC\u00124\u0017\u0007\u0006\u0003\u0002\u0002\u0005u\u0002BBA\u001b!\u0001\u0007A\u000e\u000b\u0003\u0011\u000b\"S\u0015A\u0002:fC\u00124'\u0007\u0006\u0003\u0002F\u0005-\u0003c\u0002\u0010\u0002H\u0005\u0005\u0011\u0011A\u0005\u0004\u0003\u0013R\"A\u0002+va2,'\u0007\u0003\u0004\u00026E\u0001\r\u0001\u001c\u0015\u0005#\u0015C%*\u0001\u0004sK\u0006$gm\r\u000b\u0005\u0003'\nI\u0006E\u0005\u001f\u0003+\n\t!!\u0001\u0002\u0002%\u0019\u0011q\u000b\u000e\u0003\rQ+\b\u000f\\34\u0011\u0019\t)D\u0005a\u0001Y\"\"!#\u0012%K\u0003\u0019\u0019X\r^(viR\u0019q%!\u0019\t\u000b-\u001a\u0002\u0019\u0001\u0017)\u000bM)\u0015Q\r&\"\u0005\u0005\u001d\u0014aC;tK\u0002:\u0018\u000e\u001e5PkR$2aJA6\u0011\u0019YC\u00031\u0001\u0002nA\u0019Q&a\u001c\n\u0007\u0005EdF\u0001\u0007PkR\u0004X\u000f^*ue\u0016\fW\u000eK\u0003\u0015\u000b\u0006\u0015$*\u0001\u0004tKR,%O\u001d\u000b\u0004O\u0005e\u0004\"B\u001c\u0016\u0001\u0004a\u0003&B\u000bF\u0003{R\u0015EAA@\u0003-)8/\u001a\u0011xSRDWI\u001d:\u0015\u0007\u001d\n\u0019\t\u0003\u00048-\u0001\u0007\u0011Q\u000e\u0015\u0006-\u0015\u000biHS\u0001\u0006g\u0016$\u0018J\u001c\u000b\u0004O\u0005-\u0005bBAG/\u0001\u0007\u0011qR\u0001\u0007e\u0016\fG-\u001a:\u0011\u00075\n\t*C\u0002\u0002\u0014:\u0012aAU3bI\u0016\u0014\b&B\fF\u0003/S\u0015EAAM\u0003))8/\u001a\u0011xSRD\u0017J\u001c\u000b\u0004O\u0005u\u0005BB\u001e\u0019\u0001\u0004\ty\nE\u0002.\u0003CK1!a)/\u0005-Ie\u000e];u'R\u0014X-Y7)\u000ba)\u0015q\u0013&\u000f\u0007y\tI+C\u0002\u0002,j\tqaQ8og>dW\r")
public abstract class DeprecatedConsole {
    public abstract void setOutDirect(PrintStream var1);

    public abstract void setErrDirect(PrintStream var1);

    public abstract void setInDirect(BufferedReader var1);

    public boolean readBoolean() {
        return StdIn$.MODULE$.readBoolean();
    }

    public byte readByte() {
        return StdIn$.MODULE$.readByte();
    }

    public char readChar() {
        return StdIn$.MODULE$.readChar();
    }

    public double readDouble() {
        return StdIn$.MODULE$.readDouble();
    }

    public float readFloat() {
        return StdIn$.MODULE$.readFloat();
    }

    public int readInt() {
        return StdIn$.MODULE$.readInt();
    }

    public String readLine() {
        return StdIn$.MODULE$.readLine();
    }

    public String readLine(String text, Seq<Object> args2) {
        return StdIn$.MODULE$.readLine(text, args2);
    }

    public long readLong() {
        return StdIn$.MODULE$.readLong();
    }

    public short readShort() {
        return StdIn$.MODULE$.readShort();
    }

    public List<Object> readf(String format) {
        return StdIn$.MODULE$.readf(format);
    }

    public Object readf1(String format) {
        return StdIn$.MODULE$.readf1(format);
    }

    public Tuple2<Object, Object> readf2(String format) {
        return StdIn$.MODULE$.readf2(format);
    }

    public Tuple3<Object, Object, Object> readf3(String format) {
        return StdIn$.MODULE$.readf3(format);
    }

    public void setOut(PrintStream out) {
        ((Console$)this).setOutDirect(out);
    }

    public void setOut(OutputStream out) {
        ((Console$)this).setOutDirect(new PrintStream(out));
    }

    public void setErr(PrintStream err) {
        ((Console$)this).setErrDirect(err);
    }

    public void setErr(OutputStream err) {
        ((Console$)this).setErrDirect(new PrintStream(err));
    }

    public void setIn(Reader reader) {
        ((Console$)this).setInDirect(new BufferedReader(reader));
    }

    public void setIn(InputStream in) {
        ((Console$)this).setInDirect(new BufferedReader(new InputStreamReader(in)));
    }
}

