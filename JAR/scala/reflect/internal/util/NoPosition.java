/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Option;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.immutable.Set;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.NoSourceFile$;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.SourceFile;
import scala.reflect.macros.Attachments;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001I;Qa\u0003\u0007\t\u0002V1Qa\u0006\u0007\t\u0002bAQaI\u0001\u0005\u0002\u0011Bq!J\u0001\u0002\u0002\u0013\u0005c\u0005C\u00040\u0003\u0005\u0005I\u0011\u0001\u0019\t\u000fQ\n\u0011\u0011!C\u0001k!91(AA\u0001\n\u0003b\u0004bB\"\u0002\u0003\u0003%\t\u0001\u0012\u0005\b\u0013\u0006\t\t\u0011\"\u0011K\u0011\u001dY\u0015!!A\u0005B1Cq!T\u0001\u0002\u0002\u0013%a*\u0001\u0006O_B{7/\u001b;j_:T!!\u0004\b\u0002\tU$\u0018\u000e\u001c\u0006\u0003\u001fA\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0003#I\tqA]3gY\u0016\u001cGOC\u0001\u0014\u0003\u0015\u00198-\u00197b\u0007\u0001\u0001\"AF\u0001\u000e\u00031\u0011!BT8Q_NLG/[8o'\u0011\t\u0011\u0004\b\u0011\u0011\u0005YQ\u0012BA\u000e\r\u0005E)f\u000eZ3gS:,G\rU8tSRLwN\u001c\t\u0003;yi\u0011AE\u0005\u0003?I\u0011q\u0001\u0015:pIV\u001cG\u000f\u0005\u0002\u001eC%\u0011!E\u0005\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003U\tQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DX#A\u0014\u0011\u0005!jS\"A\u0015\u000b\u0005)Z\u0013\u0001\u00027b]\u001eT\u0011\u0001L\u0001\u0005U\u00064\u0018-\u0003\u0002/S\t11\u000b\u001e:j]\u001e\fA\u0002\u001d:pIV\u001cG/\u0011:jif,\u0012!\r\t\u0003;IJ!a\r\n\u0003\u0007%sG/\u0001\bqe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\u0005YJ\u0004CA\u000f8\u0013\tA$CA\u0002B]fDqAO\u0003\u0002\u0002\u0003\u0007\u0011'A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0002{A\u0019a(\u0011\u001c\u000e\u0003}R!\u0001\u0011\n\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0002C\u007f\tA\u0011\n^3sCR|'/\u0001\u0005dC:,\u0015/^1m)\t)\u0005\n\u0005\u0002\u001e\r&\u0011qI\u0005\u0002\b\u0005>|G.Z1o\u0011\u001dQt!!AA\u0002Y\n\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0002c\u0005AAo\\*ue&tw\rF\u0001(\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0003=\u0003\"\u0001\u000b)\n\u0005EK#AB(cU\u0016\u001cG\u000f")
public final class NoPosition {
    public static String toString() {
        return NoPosition$.MODULE$.toString();
    }

    public static int hashCode() {
        return NoPosition$.MODULE$.hashCode();
    }

    public static boolean canEqual(Object object) {
        return NoPosition$.MODULE$.canEqual(object);
    }

    public static Iterator<Object> productIterator() {
        return NoPosition$.MODULE$.productIterator();
    }

    public static Object productElement(int n) {
        return NoPosition$.MODULE$.productElement(n);
    }

    public static int productArity() {
        return NoPosition$.MODULE$.productArity();
    }

    public static String productPrefix() {
        return NoPosition$.MODULE$.productPrefix();
    }

    public static boolean samePointAs(Position position) {
        return NoPosition$.MODULE$.samePointAs(position);
    }

    public static Nothing$ end() {
        return NoPosition$.MODULE$.end();
    }

    public static Nothing$ point() {
        return NoPosition$.MODULE$.point();
    }

    public static Nothing$ start() {
        return NoPosition$.MODULE$.start();
    }

    public static NoSourceFile$ source() {
        return NoPosition$.MODULE$.source();
    }

    public static boolean isRange() {
        return NoPosition$.MODULE$.isRange();
    }

    public static boolean isDefined() {
        return NoPosition$.MODULE$.isDefined();
    }

    public static Attachments withPos(Position position) {
        return NoPosition$.MODULE$.withPos(position);
    }

    public static Position pos() {
        return NoPosition$.MODULE$.pos();
    }

    public static int endOrPoint() {
        return NoPosition$.MODULE$.endOrPoint();
    }

    public static int startOrPoint() {
        return NoPosition$.MODULE$.startOrPoint();
    }

    public static Position withSource(SourceFile sourceFile, int n) {
        return NoPosition$.MODULE$.withSource(sourceFile, n);
    }

    public static Tuple2<String, String> lineWithCarat(int n) {
        return NoPosition$.MODULE$.lineWithCarat(n);
    }

    public static Position inUltimateSource(SourceFile sourceFile) {
        return NoPosition$.MODULE$.inUltimateSource(sourceFile);
    }

    public static String dbgString() {
        return NoPosition$.MODULE$.dbgString();
    }

    public static int safeLine() {
        return NoPosition$.MODULE$.safeLine();
    }

    public static Position toSingleLine() {
        return NoPosition$.MODULE$.toSingleLine();
    }

    public static Option<Object> offset() {
        return NoPosition$.MODULE$.offset();
    }

    public static String show() {
        return NoPosition$.MODULE$.show();
    }

    public static String showDebug() {
        return NoPosition$.MODULE$.showDebug();
    }

    public static String showError(String string) {
        return NoPosition$.MODULE$.showError(string);
    }

    public static String lineCarat() {
        return NoPosition$.MODULE$.lineCarat();
    }

    public static String lineCaret() {
        return NoPosition$.MODULE$.lineCaret();
    }

    public static String lineContent() {
        return NoPosition$.MODULE$.lineContent();
    }

    public static int column() {
        return NoPosition$.MODULE$.column();
    }

    public static int line() {
        return NoPosition$.MODULE$.line();
    }

    public static boolean overlaps(Position position) {
        return NoPosition$.MODULE$.overlaps(position);
    }

    public static boolean sameRange(Position position) {
        return NoPosition$.MODULE$.sameRange(position);
    }

    public static boolean properlyPrecedes(Position position) {
        return NoPosition$.MODULE$.properlyPrecedes(position);
    }

    public static boolean precedes(Position position) {
        return NoPosition$.MODULE$.precedes(position);
    }

    public static boolean properlyIncludes(Position position) {
        return NoPosition$.MODULE$.properlyIncludes(position);
    }

    public static boolean includes(Position position) {
        return NoPosition$.MODULE$.includes(position);
    }

    public static Position union(Position position) {
        return NoPosition$.MODULE$.union(position);
    }

    public static Position $up$bar(Position position) {
        return NoPosition$.MODULE$.$up$bar(position);
    }

    public static Position $bar$up(Position position) {
        return NoPosition$.MODULE$.$bar$up(position);
    }

    public static Position $up(int n) {
        return NoPosition$.MODULE$.$up(n);
    }

    public static Position $bar(Position position) {
        return NoPosition$.MODULE$.$bar(position);
    }

    public static Position $bar(Position position, Seq<Position> seq) {
        return NoPosition$.MODULE$.$bar(position, seq);
    }

    public static Position focusEnd() {
        return NoPosition$.MODULE$.focusEnd();
    }

    public static Position focus() {
        return NoPosition$.MODULE$.focus();
    }

    public static Position focusStart() {
        return NoPosition$.MODULE$.focusStart();
    }

    public static Position withShift(int n) {
        return NoPosition$.MODULE$.withShift(n);
    }

    public static Position withSource(SourceFile sourceFile) {
        return NoPosition$.MODULE$.withSource(sourceFile);
    }

    public static Position withEnd(int n) {
        return NoPosition$.MODULE$.withEnd(n);
    }

    public static Position withPoint(int n) {
        return NoPosition$.MODULE$.withPoint(n);
    }

    public static Position withStart(int n) {
        return NoPosition$.MODULE$.withStart(n);
    }

    public static Position makeTransparent() {
        return NoPosition$.MODULE$.makeTransparent();
    }

    public static int pointOrElse(int n) {
        return NoPosition$.MODULE$.pointOrElse(n);
    }

    public static boolean isOpaqueRange() {
        return NoPosition$.MODULE$.isOpaqueRange();
    }

    public static boolean isOffset() {
        return NoPosition$.MODULE$.isOffset();
    }

    public static boolean isTransparent() {
        return NoPosition$.MODULE$.isTransparent();
    }

    public static Position finalPosition() {
        return NoPosition$.MODULE$.finalPosition();
    }

    public static boolean isEmpty() {
        return NoPosition$.MODULE$.isEmpty();
    }

    public static <T> Attachments remove(ClassTag<T> classTag) {
        return NoPosition$.MODULE$.remove(classTag);
    }

    public static <T> Attachments update(T t, ClassTag<T> classTag) {
        return NoPosition$.MODULE$.update(t, classTag);
    }

    public static <T> boolean contains(ClassTag<T> classTag) {
        return NoPosition$.MODULE$.contains(classTag);
    }

    public static <T> Option<T> get(ClassTag<T> classTag) {
        return NoPosition$.MODULE$.get(classTag);
    }

    public static Set<Object> all() {
        return NoPosition$.MODULE$.all();
    }

    public static boolean containsElement(Object object) {
        return NoPosition$.MODULE$.containsElement(object);
    }

    public static <T> Attachments addElement(T t) {
        return NoPosition$.MODULE$.addElement(t);
    }

    public static <T> Attachments removeElement(T t) {
        return NoPosition$.MODULE$.removeElement(t);
    }
}

