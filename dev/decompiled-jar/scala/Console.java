/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import scala.Console$;
import scala.Function0;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005ut!\u0002\u000e\u001c\u0011\u0003qb!\u0002\u0011\u001c\u0011\u0003\t\u0003\"B\u0016\u0002\t\u0003a\u0003bB\u0017\u0002\u0005\u0004%IA\f\u0005\u0007y\u0005\u0001\u000b\u0011B\u0018\t\u000fu\n!\u0019!C\u0005]!1a(\u0001Q\u0001\n=BqaP\u0001C\u0002\u0013%\u0001\t\u0003\u0004F\u0003\u0001\u0006I!\u0011\u0005\u0006\r\u0006!\tb\u0012\u0005\u0006\u001b\u0006!\tB\u0014\u0005\u0006#\u0006!\tB\u0015\u0005\u0006\u0019\u0006!\t!\u0016\u0005\u0006!\u0006!\t!\u0016\u0005\u0006)\u0006!\tA\u0016\u0005\u0006/\u0006!\t\u0001\u0017\u0005\u0006/\u0006!\t\u0001\u001c\u0005\u0006o\u0006!\t\u0001\u001f\u0005\u0007o\u0006!\t!!\u0001\t\u000f\u0005E\u0011\u0001\"\u0001\u0002\u0014!9\u0011\u0011C\u0001\u0005\u0002\u0005-\u0002bBA!\u0003\u0011\u0005\u00111\t\u0005\b\u0003\u0013\nA\u0011AA&\u0011\u001d\ti%\u0001C\u0001\u0003\u0017Bq!!\u0014\u0002\t\u0003\ty\u0005C\u0004\u0002V\u0005!\t!a\u0016\u0002\u000f\r{gn]8mK*\tA$A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005}\tQ\"A\u000e\u0003\u000f\r{gn]8mKN\u0019\u0011AI\u0013\u0011\u0005}\u0019\u0013B\u0001\u0013\u001c\u0005E!U\r\u001d:fG\u0006$X\rZ\"p]N|G.\u001a\t\u0003M%j\u0011a\n\u0006\u0003Qm\t!![8\n\u0005):#!C!og&\u001cu\u000e\\8s\u0003\u0019a\u0014N\\5u}Q\ta$\u0001\u0004pkR4\u0016M]\u000b\u0002_A\u0019\u0001gM\u001b\u000e\u0003ER!AM\u000e\u0002\tU$\u0018\u000e\\\u0005\u0003iE\u0012q\u0002R=oC6L7MV1sS\u0006\u0014G.\u001a\t\u0003mij\u0011a\u000e\u0006\u0003QaR\u0011!O\u0001\u0005U\u00064\u0018-\u0003\u0002<o\tY\u0001K]5oiN#(/Z1n\u0003\u001dyW\u000f\u001e,be\u0002\na!\u001a:s-\u0006\u0014\u0018aB3seZ\u000b'\u000fI\u0001\u0006S:4\u0016M]\u000b\u0002\u0003B\u0019\u0001g\r\"\u0011\u0005Y\u001a\u0015B\u0001#8\u00059\u0011UO\u001a4fe\u0016$'+Z1eKJ\fa!\u001b8WCJ\u0004\u0013\u0001D:fi>+H\u000fR5sK\u000e$HC\u0001%L!\ty\u0012*\u0003\u0002K7\t!QK\\5u\u0011\u0015a\u0015\u00021\u00016\u0003\ryW\u000f^\u0001\rg\u0016$XI\u001d:ESJ,7\r\u001e\u000b\u0003\u0011>CQ\u0001\u0015\u0006A\u0002U\n1!\u001a:s\u0003-\u0019X\r^%o\t&\u0014Xm\u0019;\u0015\u0005!\u001b\u0006\"\u0002+\f\u0001\u0004\u0011\u0015AA5o+\u0005)T#\u0001\"\u0002\u000f]LG\u000f[(viV\u0011\u0011,\u0018\u000b\u00035.$\"a\u00174\u0011\u0005qkF\u0002\u0001\u0003\u0006=>\u0011\ra\u0018\u0002\u0002)F\u0011\u0001m\u0019\t\u0003?\u0005L!AY\u000e\u0003\u000f9{G\u000f[5oOB\u0011q\u0004Z\u0005\u0003Kn\u00111!\u00118z\u0011\u00199w\u0002\"a\u0001Q\u0006)A\u000f[;oWB\u0019q$[.\n\u0005)\\\"\u0001\u0003\u001fcs:\fW.\u001a \t\u000b1{\u0001\u0019A\u001b\u0016\u00055\u0004HC\u00018t)\ty\u0017\u000f\u0005\u0002]a\u0012)a\f\u0005b\u0001?\"1q\r\u0005CA\u0002I\u00042aH5p\u0011\u0015a\u0005\u00031\u0001u!\t1T/\u0003\u0002wo\taq*\u001e;qkR\u001cFO]3b[\u00069q/\u001b;i\u000bJ\u0014XCA=})\tQx\u0010\u0006\u0002|{B\u0011A\f \u0003\u0006=F\u0011\ra\u0018\u0005\u0007OF!\t\u0019\u0001@\u0011\u0007}I7\u0010C\u0003Q#\u0001\u0007Q'\u0006\u0003\u0002\u0004\u0005%A\u0003BA\u0003\u0003\u001f!B!a\u0002\u0002\fA\u0019A,!\u0003\u0005\u000by\u0013\"\u0019A0\t\u000f\u001d\u0014B\u00111\u0001\u0002\u000eA!q$[A\u0004\u0011\u0015\u0001&\u00031\u0001u\u0003\u00199\u0018\u000e\u001e5J]V!\u0011QCA\u000e)\u0011\t9\"!\t\u0015\t\u0005e\u0011Q\u0004\t\u00049\u0006mA!\u00020\u0014\u0005\u0004y\u0006bB4\u0014\t\u0003\u0007\u0011q\u0004\t\u0005?%\fI\u0002C\u0004\u0002$M\u0001\r!!\n\u0002\rI,\u0017\rZ3s!\r1\u0014qE\u0005\u0004\u0003S9$A\u0002*fC\u0012,'/\u0006\u0003\u0002.\u0005MB\u0003BA\u0018\u0003s!B!!\r\u00026A\u0019A,a\r\u0005\u000by#\"\u0019A0\t\u000f\u001d$B\u00111\u0001\u00028A!q$[A\u0019\u0011\u0019!F\u00031\u0001\u0002<A\u0019a'!\u0010\n\u0007\u0005}rGA\u0006J]B,Ho\u0015;sK\u0006l\u0017!\u00029sS:$Hc\u0001%\u0002F!1\u0011qI\u000bA\u0002\r\f1a\u001c2k\u0003\u00151G.^:i)\u0005A\u0015a\u00029sS:$HN\u001c\u000b\u0004\u0011\u0006E\u0003BBA*1\u0001\u00071-A\u0001y\u0003\u0019\u0001(/\u001b8uMR)\u0001*!\u0017\u0002t!9\u00111L\rA\u0002\u0005u\u0013\u0001\u0002;fqR\u0004B!a\u0018\u0002n9!\u0011\u0011MA5!\r\t\u0019gG\u0007\u0003\u0003KR1!a\u001a\u001e\u0003\u0019a$o\\8u}%\u0019\u00111N\u000e\u0002\rA\u0013X\rZ3g\u0013\u0011\ty'!\u001d\u0003\rM#(/\u001b8h\u0015\r\tYg\u0007\u0005\b\u0003kJ\u0002\u0019AA<\u0003\u0011\t'oZ:\u0011\t}\tIhY\u0005\u0004\u0003wZ\"A\u0003\u001fsKB,\u0017\r^3e}\u0001")
public final class Console {
    public static void printf(String string, Seq<Object> seq) {
        Console$.MODULE$.printf(string, seq);
    }

    public static void println(Object object) {
        Console$.MODULE$.println(object);
    }

    public static void println() {
        Console$.MODULE$.println();
    }

    public static void flush() {
        Console$.MODULE$.flush();
    }

    public static void print(Object object) {
        Console$.MODULE$.print(object);
    }

    public static <T> T withIn(InputStream inputStream2, Function0<T> function0) {
        return Console$.MODULE$.withIn(inputStream2, function0);
    }

    public static <T> T withIn(Reader reader, Function0<T> function0) {
        return Console$.MODULE$.withIn(reader, function0);
    }

    public static <T> T withErr(OutputStream outputStream2, Function0<T> function0) {
        return Console$.MODULE$.withErr(outputStream2, function0);
    }

    public static <T> T withErr(PrintStream printStream, Function0<T> function0) {
        return Console$.MODULE$.withErr(printStream, function0);
    }

    public static <T> T withOut(OutputStream outputStream2, Function0<T> function0) {
        return Console$.MODULE$.withOut(outputStream2, function0);
    }

    public static <T> T withOut(PrintStream printStream, Function0<T> function0) {
        return Console$.MODULE$.withOut(printStream, function0);
    }

    public static BufferedReader in() {
        return Console$.MODULE$.in();
    }

    public static PrintStream err() {
        return Console$.MODULE$.err();
    }

    public static PrintStream out() {
        return Console$.MODULE$.out();
    }

    public static String INVISIBLE() {
        return Console$.MODULE$.INVISIBLE();
    }

    public static String REVERSED() {
        return Console$.MODULE$.REVERSED();
    }

    public static String BLINK() {
        return Console$.MODULE$.BLINK();
    }

    public static String UNDERLINED() {
        return Console$.MODULE$.UNDERLINED();
    }

    public static String BOLD() {
        return Console$.MODULE$.BOLD();
    }

    public static String RESET() {
        return Console$.MODULE$.RESET();
    }

    public static String WHITE_B() {
        return Console$.MODULE$.WHITE_B();
    }

    public static String CYAN_B() {
        return Console$.MODULE$.CYAN_B();
    }

    public static String MAGENTA_B() {
        return Console$.MODULE$.MAGENTA_B();
    }

    public static String BLUE_B() {
        return Console$.MODULE$.BLUE_B();
    }

    public static String YELLOW_B() {
        return Console$.MODULE$.YELLOW_B();
    }

    public static String GREEN_B() {
        return Console$.MODULE$.GREEN_B();
    }

    public static String RED_B() {
        return Console$.MODULE$.RED_B();
    }

    public static String BLACK_B() {
        return Console$.MODULE$.BLACK_B();
    }

    public static String WHITE() {
        return Console$.MODULE$.WHITE();
    }

    public static String CYAN() {
        return Console$.MODULE$.CYAN();
    }

    public static String MAGENTA() {
        return Console$.MODULE$.MAGENTA();
    }

    public static String BLUE() {
        return Console$.MODULE$.BLUE();
    }

    public static String YELLOW() {
        return Console$.MODULE$.YELLOW();
    }

    public static String GREEN() {
        return Console$.MODULE$.GREEN();
    }

    public static String RED() {
        return Console$.MODULE$.RED();
    }

    public static String BLACK() {
        return Console$.MODULE$.BLACK();
    }

    public static void setIn(InputStream inputStream2) {
        Console$.MODULE$.setIn(inputStream2);
    }

    public static void setIn(Reader reader) {
        Console$.MODULE$.setIn(reader);
    }

    public static void setErr(OutputStream outputStream2) {
        Console$.MODULE$.setErr(outputStream2);
    }

    public static void setErr(PrintStream printStream) {
        Console$.MODULE$.setErr(printStream);
    }

    public static void setOut(OutputStream outputStream2) {
        Console$.MODULE$.setOut(outputStream2);
    }

    public static void setOut(PrintStream printStream) {
        Console$.MODULE$.setOut(printStream);
    }

    public static Tuple3<Object, Object, Object> readf3(String string) {
        return Console$.MODULE$.readf3(string);
    }

    public static Tuple2<Object, Object> readf2(String string) {
        return Console$.MODULE$.readf2(string);
    }

    public static Object readf1(String string) {
        return Console$.MODULE$.readf1(string);
    }

    public static List<Object> readf(String string) {
        return Console$.MODULE$.readf(string);
    }

    public static short readShort() {
        return Console$.MODULE$.readShort();
    }

    public static long readLong() {
        return Console$.MODULE$.readLong();
    }

    public static String readLine(String string, Seq<Object> seq) {
        return Console$.MODULE$.readLine(string, seq);
    }

    public static String readLine() {
        return Console$.MODULE$.readLine();
    }

    public static int readInt() {
        return Console$.MODULE$.readInt();
    }

    public static float readFloat() {
        return Console$.MODULE$.readFloat();
    }

    public static double readDouble() {
        return Console$.MODULE$.readDouble();
    }

    public static char readChar() {
        return Console$.MODULE$.readChar();
    }

    public static byte readByte() {
        return Console$.MODULE$.readByte();
    }

    public static boolean readBoolean() {
        return Console$.MODULE$.readBoolean();
    }
}

