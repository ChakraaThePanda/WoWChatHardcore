/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import scala.Function0;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.JavaConverters$;
import scala.collection.mutable.Map;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005UqAB\f\u0019\u0011\u0003QbD\u0002\u0004!1!\u0005!$\t\u0005\u0006M\u0005!\t\u0001\u000b\u0004\u0005S\u0005\u0001!\u0006\u0003\u0005-\u0007\t\u0005I\u0015!\u0003.\u0011\u001513\u0001\"\u0001<\u0011\u0015y4\u0001\"\u0001A\r\u0011\t\u0015\u0001\u0001\"\t\u00111:!\u0011!S\u0001\n\u0011CQAJ\u0004\u0005\u0002\u001dCQAS\u0004\u0005\u0002-3A\u0001T\u0001\u0001\u001b\"Aqj\u0003B\u0001B\u0003%\u0001\u000bC\u0003'\u0017\u0011\u0005a\u000bC\u0003Z\u0017\u0011\u0005!L\u0002\u0003d\u0003\u0001!\u0007\u0002C(\u0010\u0005\u0003\u0005\u000b\u0011\u00024\t\u000b\u0019zA\u0011A6\t\u000b9|A\u0011A8\u0007\tM\f\u0001\u0001\u001e\u0005\tmN\u0011\t\u0011)A\u0005o\"1ae\u0005C\u0001\u0003\u000bAq!a\u0003\u0014\t\u0003\ti!\u0001\u0006EK\u000e|'/\u0019;peNT!!\u0007\u000e\u0002\u000f\r|gN^3si*\u00111\u0004H\u0001\u000bG>dG.Z2uS>t'\"A\u000f\u0002\u000bM\u001c\u0017\r\\1\u0011\u0005}\tQ\"\u0001\r\u0003\u0015\u0011+7m\u001c:bi>\u00148o\u0005\u0002\u0002EA\u00111\u0005J\u0007\u00029%\u0011Q\u0005\b\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?\u0007\u0001!\u0012A\b\u0002\u0007\u0003NT\u0015M^1\u0016\u0005-\u00124CA\u0002#\u0003\ty\u0007\u000fE\u0002$]AJ!a\f\u000f\u0003\u0011q\u0012\u0017P\\1nKz\u0002\"!\r\u001a\r\u0001\u0011)1g\u0001b\u0001i\t\t\u0011)\u0005\u00026qA\u00111EN\u0005\u0003oq\u0011qAT8uQ&tw\r\u0005\u0002$s%\u0011!\b\b\u0002\u0004\u0003:LHC\u0001\u001f?!\ri4\u0001M\u0007\u0002\u0003!1A&\u0002CA\u00025\na!Y:KCZ\fW#\u0001\u0019\u0003\u000f\u0005\u001b8kY1mCV\u00111IR\n\u0003\u000f\t\u00022a\t\u0018F!\t\td\tB\u00034\u000f\t\u0007A\u0007\u0006\u0002I\u0013B\u0019QhB#\t\r1JA\u00111\u0001E\u0003\u001d\t7oU2bY\u0006,\u0012!\u0012\u0002\u0011\u0003NT\u0015M^1D_2dWm\u0019;j_:,\"AT+\u0014\u0005-\u0011\u0013!A5\u0011\u0007E\u0013F+D\u0001\u001b\u0013\t\u0019&D\u0001\u0005Ji\u0016\u0014\u0018M\u00197f!\t\tT\u000bB\u00034\u0017\t\u0007A\u0007\u0006\u0002X1B\u0019Qh\u0003+\t\u000b=k\u0001\u0019\u0001)\u0002!\u0005\u001c(*\u0019<b\u0007>dG.Z2uS>tW#A.\u0011\u0007q\u000bG+D\u0001^\u0015\tqv,\u0001\u0003vi&d'\"\u00011\u0002\t)\fg/Y\u0005\u0003Ev\u0013!bQ8mY\u0016\u001cG/[8o\u0005E\t5OS1wC\u0016sW/\\3sCRLwN\\\u000b\u0003K*\u001c\"a\u0004\u0012\u0011\u0007E;\u0017.\u0003\u0002i5\tA\u0011\n^3sCR|'\u000f\u0005\u00022U\u0012)1g\u0004b\u0001iQ\u0011A.\u001c\t\u0004{=I\u0007\"B(\u0012\u0001\u00041\u0017!E1t\u0015\u00064\u0018-\u00128v[\u0016\u0014\u0018\r^5p]V\t\u0001\u000fE\u0002]c&L!A]/\u0003\u0017\u0015sW/\\3sCRLwN\u001c\u0002\u0011\u0003NT\u0015M^1ES\u000e$\u0018n\u001c8bef,B!\u001e@\u0002\u0002M\u00111CI\u0001\u0002[B!\u0001p_?\u0000\u001b\u0005I(B\u0001>\u001b\u0003\u001diW\u000f^1cY\u0016L!\u0001`=\u0003\u00075\u000b\u0007\u000f\u0005\u00022}\u0012)1g\u0005b\u0001iA\u0019\u0011'!\u0001\u0005\r\u0005\r1C1\u00015\u0005\u0005\u0011E\u0003BA\u0004\u0003\u0013\u0001B!P\n~\u007f\")a/\u0006a\u0001o\u0006\u0001\u0012m\u001d&bm\u0006$\u0015n\u0019;j_:\f'/_\u000b\u0003\u0003\u001f\u0001R\u0001XA\t{~L1!a\u0005^\u0005)!\u0015n\u0019;j_:\f'/\u001f")
public final class Decorators {

    public static class AsJava<A> {
        private final Function0<A> op;

        public A asJava() {
            return this.op.apply();
        }

        public AsJava(Function0<A> op) {
            this.op = op;
        }
    }

    public static class AsJavaCollection<A> {
        private final Iterable<A> i;

        public Collection<A> asJavaCollection() {
            return JavaConverters$.MODULE$.asJavaCollection(this.i);
        }

        public AsJavaCollection(Iterable<A> i) {
            this.i = i;
        }
    }

    public static class AsJavaDictionary<A, B> {
        private final Map<A, B> m;

        public Dictionary<A, B> asJavaDictionary() {
            return JavaConverters$.MODULE$.asJavaDictionary(this.m);
        }

        public AsJavaDictionary(Map<A, B> m) {
            this.m = m;
        }
    }

    public static class AsJavaEnumeration<A> {
        private final Iterator<A> i;

        public Enumeration<A> asJavaEnumeration() {
            return JavaConverters$.MODULE$.asJavaEnumeration(this.i);
        }

        public AsJavaEnumeration(Iterator<A> i) {
            this.i = i;
        }
    }

    public static class AsScala<A> {
        private final Function0<A> op;

        public A asScala() {
            return this.op.apply();
        }

        public AsScala(Function0<A> op) {
            this.op = op;
        }
    }
}

