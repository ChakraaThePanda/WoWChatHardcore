/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Predef;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.IndexedSeq;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.io.StdIn$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005MgA\u0003\f\u0018!\u0003\r\taF\r\u0002R\")a\u0004\u0001C\u0001A!)A\u0005\u0001C\u0001K!)!\t\u0001C\u0001\u0007\")a\n\u0001C\u0001\u001f\")q\u000b\u0001C\u00011\")\u0001\u000e\u0001C\u0001S\"9\u0011\u0011\u0001\u0001\u0005\u0002\u0005\r\u0001bBA\n\u0001\u0011\u0005\u0011Q\u0003\u0005\b\u0003'\u0001A\u0011AA\u0012\u0011\u001d\t\u0019\u0005\u0001C\u0001\u0003\u000bBq!a\u0014\u0001\t\u0003\t\t\u0006C\u0004\u0002\\\u0001!\t!!\u0018\t\u000f\u0005\u001d\u0004\u0001\"\u0001\u0002j!9\u0011Q\u000e\u0001\u0005\u0002\u0005=\u0004bBA=\u0001\u0011\u0005\u00111\u0010\u0005\b\u0003\u000b\u0003A\u0011AAD\u0011\u001d\t\t\n\u0001C\u0001\u0003'Cq!!(\u0001\t\u0003\ty\nC\u0004\u0002.\u0002!\t!a,\t\u000f\u0005U\u0006\u0001\"\u0001\u00028\"9\u00111\u0019\u0001\u0005\u0002\u0005\u0015'\u0001\u0005#faJ,7-\u0019;fIB\u0013X\rZ3g\u0015\u0005A\u0012!B:dC2\f7C\u0001\u0001\u001b!\tYB$D\u0001\u0018\u0013\tirC\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0004\u0001Q\t\u0011\u0005\u0005\u0002\u001cE%\u00111e\u0006\u0002\u0005+:LG/\u0001\bb]f\u0014\u0014I\u001d:po\u0006\u001b8o\\2\u0016\u0005\u0019zCCA\u00149!\rA\u0013&L\u0007\u0002\u0001%\u0011!f\u000b\u0002\u000b\u0003J\u0014xn^!tg>\u001c'B\u0001\u0017\u0018\u0003\u0019\u0001&/\u001a3fMB\u0011af\f\u0007\u0001\t\u0015\u0001$A1\u00012\u0005\u0005\t\u0015C\u0001\u001a6!\tY2'\u0003\u00025/\t9aj\u001c;iS:<\u0007CA\u000e7\u0013\t9tCA\u0002B]fDQ!\u000f\u0002A\u00025\n\u0011\u0001\u001f\u0015\u0005\u0005mr\u0004\t\u0005\u0002\u001cy%\u0011Qh\u0006\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%A \u0002!U\u001cX\r\t1BeJ|w/Q:t_\u000e\u0004\u0017%A!\u0002\rIr\u0013'\r\u00181\u00031\tg.\u001f\u001aF]N,(/\u001b8h+\t!\u0015\n\u0006\u0002F\u0015B\u0019\u0001F\u0012%\n\u0005\u001d[#\u0001C#ogV\u0014\u0018N\\4\u0011\u00059JE!\u0002\u0019\u0004\u0005\u0004\t\u0004\"B\u001d\u0004\u0001\u0004A\u0005\u0006B\u0002<\u0019\u0002\u000b\u0013!T\u0001\u000fkN,\u0007\u0005Y#ogV\u0014\u0018N\\4a\u00035\tg.\u001f\u001atiJLgn\u001a4niR\u0011\u0001k\u0015\t\u0004QE+\u0014B\u0001*,\u00051\u0019FO]5oO\u001a{'/\\1u\u0011\u0015ID\u00011\u00016Q\u0011!1(\u0016!\"\u0003Y\u000b!#^:fA\u0001\u001cFO]5oO\u001a{'/\\1uA\u0006\u0001R\r_2faRLwN\\,sCB\u0004XM\u001d\u000b\u00033r\u0003\"\u0001\u000b.\n\u0005m[#!\u0004*jG\",\u0005pY3qi&|g\u000eC\u0003^\u000b\u0001\u0007a,A\u0002fq\u000e\u0004\"a\u00182\u000f\u0005m\u0001\u0017BA1\u0018\u0003\u001d\u0001\u0018mY6bO\u0016L!a\u00193\u0003\u0013QC'o\\<bE2,'BA1\u0018Q\u0011)1H\u001a!\"\u0003\u001d\f\u0001$^:fA\u0001$\u0006N]8xC\ndW\r\u0019\u0011eSJ,7\r\u001e7z\u0003E\u0019X-\u001d+p\u0007\"\f'oU3rk\u0016t7-\u001a\u000b\u0003UJ\u0004\"a\u001b9\u000e\u00031T!!\u001c8\u0002\t1\fgn\u001a\u0006\u0002_\u0006!!.\u0019<b\u0013\t\tHN\u0001\u0007DQ\u0006\u00148+Z9vK:\u001cW\rC\u0003t\r\u0001\u0007A/\u0001\u0002ygB\u0019Q\u000f\u001f>\u000e\u0003YT!a^\f\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0002zm\nQ\u0011J\u001c3fq\u0016$7+Z9\u0011\u0005mY\u0018B\u0001?\u0018\u0005\u0011\u0019\u0005.\u0019:)\t\u0019Yd\u0010Q\u0011\u0002\u007f\u0006)Ro]3!AN+\u0017o\u00115beN+\u0017/^3oG\u0016\u0004\u0017aE1se\u0006LHk\\\"iCJ\u001cV-];f]\u000e,Gc\u00016\u0002\u0006!11o\u0002a\u0001\u0003\u000f\u0001BaGA\u0005u&\u0019\u00111B\f\u0003\u000b\u0005\u0013(/Y=)\u000b\u001dY\u0014q\u0002!\"\u0005\u0005E\u0011aF;tK\u0002\u0002\u0017I\u001d:bs\u000eC\u0017M]*fcV,gnY3a\u0003!\u0011X-\u00193MS:,GCAA\f!\rA\u0013\u0011D\u0005\u0004\u00037Y#AB*ue&tw\rK\u0003\tw\u0005}\u0001)\t\u0002\u0002\"\u0005\u0011So]3!i\",\u0007%\\3uQ>$\u0007%\u001b8!AN\u001c\u0017\r\\1/S>t3\u000b\u001e3J]\u0002$b!!\n\u00024\u0005]\u0002\u0003BA\u0014\u00033qA!!\u000b\u00022A\u0019\u00111F\f\u000e\u0005\u00055\"bAA\u0018?\u00051AH]8pizJ!\u0001L\f\t\u000f\u0005U\u0012\u00021\u0001\u0002\u0018\u0005!A/\u001a=u\u0011\u001d\tI$\u0003a\u0001\u0003w\tA!\u0019:hgB!1$!\u00106\u0013\r\tyd\u0006\u0002\u000byI,\u0007/Z1uK\u0012t\u0004&B\u0005<\u0003?\u0001\u0015a\u0003:fC\u0012\u0014un\u001c7fC:$\"!a\u0012\u0011\u0007m\tI%C\u0002\u0002L]\u0011qAQ8pY\u0016\fg\u000eK\u0003\u000bw\u0005}\u0001)\u0001\u0005sK\u0006$')\u001f;f)\t\t\u0019\u0006E\u0002\u001c\u0003+J1!a\u0016\u0018\u0005\u0011\u0011\u0015\u0010^3)\u000b-Y\u0014q\u0004!\u0002\u0013I,\u0017\rZ*i_J$HCAA0!\rY\u0012\u0011M\u0005\u0004\u0003G:\"!B*i_J$\b&\u0002\u0007<\u0003?\u0001\u0015\u0001\u0003:fC\u0012\u001c\u0005.\u0019:\u0015\u0003iDS!D\u001e\u0002 \u0001\u000bqA]3bI&sG\u000f\u0006\u0002\u0002rA\u00191$a\u001d\n\u0007\u0005UtCA\u0002J]RDSAD\u001e\u0002 \u0001\u000b\u0001B]3bI2{gn\u001a\u000b\u0003\u0003{\u00022aGA@\u0013\r\t\ti\u0006\u0002\u0005\u0019>tw\rK\u0003\u0010w\u0005}\u0001)A\u0005sK\u0006$g\t\\8biR\u0011\u0011\u0011\u0012\t\u00047\u0005-\u0015bAAG/\t)a\t\\8bi\"*\u0001cOA\u0010\u0001\u0006Q!/Z1e\t>,(\r\\3\u0015\u0005\u0005U\u0005cA\u000e\u0002\u0018&\u0019\u0011\u0011T\f\u0003\r\u0011{WO\u00197fQ\u0015\t2(a\bA\u0003\u0015\u0011X-\u00193g)\u0011\t\t+a*\u0011\t}\u000b\u0019+N\u0005\u0004\u0003K#'\u0001\u0002'jgRDq!!+\u0013\u0001\u0004\t9\"\u0001\u0004g_Jl\u0017\r\u001e\u0015\u0006%m\ny\u0002Q\u0001\u0007e\u0016\fGMZ\u0019\u0015\u0007U\n\t\fC\u0004\u0002*N\u0001\r!a\u0006)\u000bMY\u0014q\u0004!\u0002\rI,\u0017\r\u001a43)\u0011\tI,a0\u0011\u000bm\tY,N\u001b\n\u0007\u0005uvC\u0001\u0004UkBdWM\r\u0005\b\u0003S#\u0002\u0019AA\fQ\u0015!2(a\bA\u0003\u0019\u0011X-\u00193ggQ!\u0011qYAg!\u0019Y\u0012\u0011Z\u001b6k%\u0019\u00111Z\f\u0003\rQ+\b\u000f\\34\u0011\u001d\tI+\u0006a\u0001\u0003/AS!F\u001e\u0002 \u0001s1aGA\u0019\u0001")
public interface DeprecatedPredef {
    public static /* synthetic */ Object any2ArrowAssoc$(DeprecatedPredef $this, Object x) {
        return $this.any2ArrowAssoc(x);
    }

    default public <A> A any2ArrowAssoc(A x) {
        return x;
    }

    public static /* synthetic */ Object any2Ensuring$(DeprecatedPredef $this, Object x) {
        return $this.any2Ensuring(x);
    }

    default public <A> A any2Ensuring(A x) {
        return x;
    }

    public static /* synthetic */ Object any2stringfmt$(DeprecatedPredef $this, Object x) {
        return $this.any2stringfmt(x);
    }

    default public Object any2stringfmt(Object x) {
        return x;
    }

    public static /* synthetic */ Throwable exceptionWrapper$(DeprecatedPredef $this, Throwable exc) {
        return $this.exceptionWrapper(exc);
    }

    default public Throwable exceptionWrapper(Throwable exc) {
        return exc;
    }

    public static /* synthetic */ CharSequence seqToCharSequence$(DeprecatedPredef $this, IndexedSeq xs) {
        return $this.seqToCharSequence(xs);
    }

    default public CharSequence seqToCharSequence(IndexedSeq<Object> xs) {
        return new Predef.SeqCharSequence(xs);
    }

    public static /* synthetic */ CharSequence arrayToCharSequence$(DeprecatedPredef $this, char[] xs) {
        return $this.arrayToCharSequence(xs);
    }

    default public CharSequence arrayToCharSequence(char[] xs) {
        return new Predef.ArrayCharSequence(xs);
    }

    public static /* synthetic */ String readLine$(DeprecatedPredef $this) {
        return $this.readLine();
    }

    default public String readLine() {
        return StdIn$.MODULE$.readLine();
    }

    public static /* synthetic */ String readLine$(DeprecatedPredef $this, String text, Seq args2) {
        return $this.readLine(text, args2);
    }

    default public String readLine(String text, Seq<Object> args2) {
        return StdIn$.MODULE$.readLine(text, args2);
    }

    public static /* synthetic */ boolean readBoolean$(DeprecatedPredef $this) {
        return $this.readBoolean();
    }

    default public boolean readBoolean() {
        return StdIn$.MODULE$.readBoolean();
    }

    public static /* synthetic */ byte readByte$(DeprecatedPredef $this) {
        return $this.readByte();
    }

    default public byte readByte() {
        return StdIn$.MODULE$.readByte();
    }

    public static /* synthetic */ short readShort$(DeprecatedPredef $this) {
        return $this.readShort();
    }

    default public short readShort() {
        return StdIn$.MODULE$.readShort();
    }

    public static /* synthetic */ char readChar$(DeprecatedPredef $this) {
        return $this.readChar();
    }

    default public char readChar() {
        return StdIn$.MODULE$.readChar();
    }

    public static /* synthetic */ int readInt$(DeprecatedPredef $this) {
        return $this.readInt();
    }

    default public int readInt() {
        return StdIn$.MODULE$.readInt();
    }

    public static /* synthetic */ long readLong$(DeprecatedPredef $this) {
        return $this.readLong();
    }

    default public long readLong() {
        return StdIn$.MODULE$.readLong();
    }

    public static /* synthetic */ float readFloat$(DeprecatedPredef $this) {
        return $this.readFloat();
    }

    default public float readFloat() {
        return StdIn$.MODULE$.readFloat();
    }

    public static /* synthetic */ double readDouble$(DeprecatedPredef $this) {
        return $this.readDouble();
    }

    default public double readDouble() {
        return StdIn$.MODULE$.readDouble();
    }

    public static /* synthetic */ List readf$(DeprecatedPredef $this, String format) {
        return $this.readf(format);
    }

    default public List<Object> readf(String format) {
        return StdIn$.MODULE$.readf(format);
    }

    public static /* synthetic */ Object readf1$(DeprecatedPredef $this, String format) {
        return $this.readf1(format);
    }

    default public Object readf1(String format) {
        return StdIn$.MODULE$.readf1(format);
    }

    public static /* synthetic */ Tuple2 readf2$(DeprecatedPredef $this, String format) {
        return $this.readf2(format);
    }

    default public Tuple2<Object, Object> readf2(String format) {
        return StdIn$.MODULE$.readf2(format);
    }

    public static /* synthetic */ Tuple3 readf3$(DeprecatedPredef $this, String format) {
        return $this.readf3(format);
    }

    default public Tuple3<Object, Object, Object> readf3(String format) {
        return StdIn$.MODULE$.readf3(format);
    }

    public static void $init$(DeprecatedPredef $this) {
    }
}

