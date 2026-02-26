/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Option;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.util.Either;
import scala.util.Left$;

@ScalaSignature(bytes="\u0006\u0001\u00055f\u0001\u0002\r\u001a\u0005zA\u0001\"\u000f\u0001\u0003\u0016\u0004%\tA\u000f\u0005\tw\u0001\u0011\t\u0012)A\u0005I!)A\b\u0001C\u0001{!)q\r\u0001C\u0001Q\")A\u000e\u0001C\u0001Q\")A\r\u0001C\u0001u!91\u000fAA\u0001\n\u0003!\bb\u0002?\u0001#\u0003%\t! \u0005\n\u0003/\u0001\u0011\u0011!C!\u00033A\u0011\"!\u000b\u0001\u0003\u0003%\t!a\u000b\t\u0013\u0005M\u0002!!A\u0005\u0002\u0005U\u0002\"CA\u001e\u0001\u0005\u0005I\u0011IA\u001f\u0011%\tY\u0005AA\u0001\n\u0003\ti\u0005C\u0005\u0002R\u0001\t\t\u0011\"\u0011\u0002T!I\u0011Q\u000b\u0001\u0002\u0002\u0013\u0005\u0013q\u000b\u0005\n\u00033\u0002\u0011\u0011!C!\u00037:\u0011\"a\u0018\u001a\u0003\u0003E\t!!\u0019\u0007\u0011aI\u0012\u0011!E\u0001\u0003GBa\u0001\u0010\n\u0005\u0002\u0005-\u0004\"CA+%\u0005\u0005IQIA,\u0011!i%#!A\u0005\u0002\u00065\u0004\"CAE%\u0005\u0005I\u0011QAF\u0011%\t\u0019KEA\u0001\n\u0013\t)K\u0001\u0003MK\u001a$(B\u0001\u000e\u001c\u0003\u0011)H/\u001b7\u000b\u0003q\tQa]2bY\u0006\u001c\u0001!F\u0002 ME\u001aB\u0001\u0001\u00114mA!\u0011E\t\u00131\u001b\u0005I\u0012BA\u0012\u001a\u0005\u0019)\u0015\u000e\u001e5feB\u0011QE\n\u0007\u0001\t\u00199\u0003\u0001\"b\u0001Q\t\t\u0011)\u0005\u0002*[A\u0011!fK\u0007\u00027%\u0011Af\u0007\u0002\b\u001d>$\b.\u001b8h!\tQc&\u0003\u000207\t\u0019\u0011I\\=\u0011\u0005\u0015\nDA\u0002\u001a\u0001\t\u000b\u0007\u0001FA\u0001C!\tQC'\u0003\u000267\t9\u0001K]8ek\u000e$\bC\u0001\u00168\u0013\tA4D\u0001\u0007TKJL\u0017\r\\5{C\ndW-A\u0003wC2,X-F\u0001%\u0003\u00191\u0018\r\\;fA\u00051A(\u001b8jiz\"\"AP \u0011\t\u0005\u0002A\u0005\r\u0005\u0006s\r\u0001\r\u0001\n\u0015\u0005\u007f\u0005#U\r\u0005\u0002+\u0005&\u00111i\u0007\u0002\u000fI\u0016\u0004(/Z2bi\u0016$g*Y7fc\u0011yR\tS1\u0011\u0005)2\u0015BA$\u001c\u0005\u0019\u0019\u00160\u001c2pYF*1%\u0013'\\\u001bR\u0011QI\u0013\u0005\u0006\u0017v\u0001\r\u0001U\u0001\u0005]\u0006lW-\u0003\u0002N\u001d\u0006)\u0011\r\u001d9ms*\u0011qjG\u0001\u0007'fl'm\u001c7\u0011\u0005ECfB\u0001*W!\t\u00196$D\u0001U\u0015\t)V$\u0001\u0004=e>|GOP\u0005\u0003/n\ta\u0001\u0015:fI\u00164\u0017BA-[\u0005\u0019\u0019FO]5oO*\u0011qkG\u0019\u0006Gq{\u0006m\u0014\b\u0003;~s!a\u00150\n\u0003qI!aT\u000e2\t\u0011jf\fH\u0019\u0004K\t\u001cw\"A2\"\u0003\u0011\f\u0011!Y\u0011\u0002M\u00061!GL\u00193]A\na![:MK\u001a$X#A5\u0011\u0005)R\u0017BA6\u001c\u0005\u001d\u0011un\u001c7fC:\fq![:SS\u001eDG\u000f\u000b\u0003\u0007]F,\u0007C\u0001\u0016p\u0013\t\u00018D\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013A]\u0001\u0014+N,\u0007E\f<bYV,\u0007%\u001b8ti\u0016\fGML\u0001\u0005G>\u0004\u00180F\u0002vqj$\"A^>\u0011\t\u0005\u0002q/\u001f\t\u0003Ka$QaJ\u0004C\u0002!\u0002\"!\n>\u0005\u000bI:!\u0019\u0001\u0015\t\u000fe:\u0001\u0013!a\u0001o\u0006q1m\u001c9zI\u0011,g-Y;mi\u0012\nT#\u0002@\u0002\u0014\u0005UQ#A@+\u0007\u0011\n\ta\u000b\u0002\u0002\u0004A!\u0011QAA\b\u001b\t\t9A\u0003\u0003\u0002\n\u0005-\u0011!C;oG\",7m[3e\u0015\r\tiaG\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002BA\t\u0003\u000f\u0011\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\t\u00159\u0003B1\u0001)\t\u0015\u0011\u0004B1\u0001)\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\u0011\u00111\u0004\t\u0005\u0003;\t9#\u0004\u0002\u0002 )!\u0011\u0011EA\u0012\u0003\u0011a\u0017M\\4\u000b\u0005\u0005\u0015\u0012\u0001\u00026bm\u0006L1!WA\u0010\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\t\ti\u0003E\u0002+\u0003_I1!!\r\u001c\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\ri\u0013q\u0007\u0005\n\u0003sY\u0011\u0011!a\u0001\u0003[\t1\u0001\u001f\u00132\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XCAA !\u0015\t\t%a\u0012.\u001b\t\t\u0019EC\u0002\u0002Fm\t!bY8mY\u0016\u001cG/[8o\u0013\u0011\tI%a\u0011\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0004S\u0006=\u0003\u0002CA\u001d\u001b\u0005\u0005\t\u0019A\u0017\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!\f\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!a\u0007\u0002\r\u0015\fX/\u00197t)\rI\u0017Q\f\u0005\t\u0003s\u0001\u0012\u0011!a\u0001[\u0005!A*\u001a4u!\t\t#c\u0005\u0003\u0013\u0003K2\u0004c\u0001\u0016\u0002h%\u0019\u0011\u0011N\u000e\u0003\r\u0005s\u0017PU3g)\t\t\t'\u0006\u0004\u0002p\u0005U\u0014\u0011\u0010\u000b\u0005\u0003c\nY\b\u0005\u0004\"\u0001\u0005M\u0014q\u000f\t\u0004K\u0005UD!B\u0014\u0016\u0005\u0004A\u0003cA\u0013\u0002z\u0011)!'\u0006b\u0001Q!1\u0011(\u0006a\u0001\u0003gBc!a\u001fB\u0003\u007f*\u0017GB\u0010F\u0003\u0003\u000b9)\r\u0004$\u00132\u000b\u0019)T\u0019\u0007Gq{\u0016QQ(2\t\u0011jf\fH\u0019\u0004K\t\u001c\u0017aB;oCB\u0004H._\u000b\u0007\u0003\u001b\u000b9*!)\u0015\t\u0005=\u0015\u0011\u0014\t\u0006U\u0005E\u0015QS\u0005\u0004\u0003'[\"AB(qi&|g\u000eE\u0002&\u0003/#Qa\n\fC\u0002!B\u0011\"a'\u0017\u0003\u0003\u0005\r!!(\u0002\u0007a$\u0003\u0007\u0005\u0004\"\u0001\u0005U\u0015q\u0014\t\u0004K\u0005\u0005F!\u0002\u001a\u0017\u0005\u0004A\u0013a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!a*\u0011\t\u0005u\u0011\u0011V\u0005\u0005\u0003W\u000byB\u0001\u0004PE*,7\r\u001e")
public final class Left<A, B>
extends Either<A, B> {
    private final A value;

    public static <A, B> Option<A> unapply(Left<A, B> left) {
        return Left$.MODULE$.unapply(left);
    }

    public static <A, B> Left<A, B> apply(A a) {
        return Left$.MODULE$.apply(a);
    }

    public A value() {
        return this.value;
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    public A a() {
        return this.value();
    }

    public <A, B> Left<A, B> copy(A value) {
        return new Left<A, B>(value);
    }

    public <A, B> A copy$default$1() {
        return this.value();
    }

    @Override
    public String productPrefix() {
        return "Left";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.value();
            }
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Left;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Left;
                if (!bl) break block3;
                Left left = (Left)x$1;
                if (!BoxesRunTime.equals(this.value(), left.value())) break block3;
            }
            return true;
        }
        return false;
    }

    public Left(A value) {
        this.value = value;
    }
}

