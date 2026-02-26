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
import scala.util.Right$;

@ScalaSignature(bytes="\u0006\u0001\u00055f\u0001\u0002\r\u001a\u0005zA\u0001\"\u000f\u0001\u0003\u0016\u0004%\tA\u000f\u0005\tw\u0001\u0011\t\u0012)A\u0005a!)A\b\u0001C\u0001{!)q\r\u0001C\u0001Q\")A\u000e\u0001C\u0001Q\")A\r\u0001C\u0001u!91\u000fAA\u0001\n\u0003!\bb\u0002?\u0001#\u0003%\t! \u0005\n\u0003/\u0001\u0011\u0011!C!\u00033A\u0011\"!\u000b\u0001\u0003\u0003%\t!a\u000b\t\u0013\u0005M\u0002!!A\u0005\u0002\u0005U\u0002\"CA\u001e\u0001\u0005\u0005I\u0011IA\u001f\u0011%\tY\u0005AA\u0001\n\u0003\ti\u0005C\u0005\u0002R\u0001\t\t\u0011\"\u0011\u0002T!I\u0011Q\u000b\u0001\u0002\u0002\u0013\u0005\u0013q\u000b\u0005\n\u00033\u0002\u0011\u0011!C!\u00037:\u0011\"a\u0018\u001a\u0003\u0003E\t!!\u0019\u0007\u0011aI\u0012\u0011!E\u0001\u0003GBa\u0001\u0010\n\u0005\u0002\u0005-\u0004\"CA+%\u0005\u0005IQIA,\u0011!i%#!A\u0005\u0002\u00065\u0004\"CAE%\u0005\u0005I\u0011QAF\u0011%\t\u0019KEA\u0001\n\u0013\t)KA\u0003SS\u001eDGO\u0003\u0002\u001b7\u0005!Q\u000f^5m\u0015\u0005a\u0012!B:dC2\f7\u0001A\u000b\u0004?\u0019\n4\u0003\u0002\u0001!gY\u0002B!\t\u0012%a5\t\u0011$\u0003\u0002$3\t1Q)\u001b;iKJ\u0004\"!\n\u0014\r\u0001\u00111q\u0005\u0001CC\u0002!\u0012\u0011!Q\t\u0003S5\u0002\"AK\u0016\u000e\u0003mI!\u0001L\u000e\u0003\u000f9{G\u000f[5oOB\u0011!FL\u0005\u0003_m\u00111!\u00118z!\t)\u0013\u0007\u0002\u00043\u0001\u0011\u0015\r\u0001\u000b\u0002\u0002\u0005B\u0011!\u0006N\u0005\u0003km\u0011q\u0001\u0015:pIV\u001cG\u000f\u0005\u0002+o%\u0011\u0001h\u0007\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0006m\u0006dW/Z\u000b\u0002a\u00051a/\u00197vK\u0002\na\u0001P5oSRtDC\u0001 @!\u0011\t\u0003\u0001\n\u0019\t\u000be\u001a\u0001\u0019\u0001\u0019)\t}\nE)\u001a\t\u0003U\tK!aQ\u000e\u0003\u001d\u0011,\u0007O]3dCR,GMT1nKF\"q$\u0012%b!\tQc)\u0003\u0002H7\t11+_7c_2\fTaI%M76#\"!\u0012&\t\u000b-k\u0002\u0019\u0001)\u0002\t9\fW.Z\u0005\u0003\u001b:\u000bQ!\u00199qYfT!aT\u000e\u0002\rMKXNY8m!\t\t\u0006L\u0004\u0002S-B\u00111kG\u0007\u0002)*\u0011Q+H\u0001\u0007yI|w\u000e\u001e \n\u0005][\u0012A\u0002)sK\u0012,g-\u0003\u0002Z5\n11\u000b\u001e:j]\u001eT!aV\u000e2\u000b\rbv\fY(\u000f\u0005u{fBA*_\u0013\u0005a\u0012BA(\u001cc\u0011!SL\u0018\u000f2\u0007\u0015\u00127mD\u0001dC\u0005!\u0017!\u00012\"\u0003\u0019\faA\r\u00182e9\u0002\u0014AB5t\u0019\u00164G/F\u0001j!\tQ#.\u0003\u0002l7\t9!i\\8mK\u0006t\u0017aB5t%&<\u0007\u000e\u001e\u0015\u0005\r9\fX\r\u0005\u0002+_&\u0011\u0001o\u0007\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%\u0001:\u0002'U\u001bX\r\t\u0018wC2,X\rI5ogR,\u0017\r\u001a\u0018\u0002\t\r|\u0007/_\u000b\u0004kbTHC\u0001<|!\u0011\t\u0003a^=\u0011\u0005\u0015BH!B\u0014\b\u0005\u0004A\u0003CA\u0013{\t\u0015\u0011tA1\u0001)\u0011\u001dIt\u0001%AA\u0002e\fabY8qs\u0012\"WMZ1vYR$\u0013'F\u0003\u007f\u0003'\t)\"F\u0001\u0000U\r\u0001\u0014\u0011A\u0016\u0003\u0003\u0007\u0001B!!\u0002\u0002\u00105\u0011\u0011q\u0001\u0006\u0005\u0003\u0013\tY!A\u0005v]\u000eDWmY6fI*\u0019\u0011QB\u000e\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002\u0012\u0005\u001d!!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0012)q\u0005\u0003b\u0001Q\u0011)!\u0007\u0003b\u0001Q\u0005i\u0001O]8ek\u000e$\bK]3gSb,\"!a\u0007\u0011\t\u0005u\u0011qE\u0007\u0003\u0003?QA!!\t\u0002$\u0005!A.\u00198h\u0015\t\t)#\u0001\u0003kCZ\f\u0017bA-\u0002 \u0005a\u0001O]8ek\u000e$\u0018I]5usV\u0011\u0011Q\u0006\t\u0004U\u0005=\u0012bAA\u00197\t\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u0019Q&a\u000e\t\u0013\u0005e2\"!AA\u0002\u00055\u0012a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/\u0006\u0002\u0002@A)\u0011\u0011IA$[5\u0011\u00111\t\u0006\u0004\u0003\u000bZ\u0012AC2pY2,7\r^5p]&!\u0011\u0011JA\"\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\u0007%\fy\u0005\u0003\u0005\u0002:5\t\t\u00111\u0001.\u0003!A\u0017m\u001d5D_\u0012,GCAA\u0017\u0003!!xn\u0015;sS:<GCAA\u000e\u0003\u0019)\u0017/^1mgR\u0019\u0011.!\u0018\t\u0011\u0005e\u0002#!AA\u00025\nQAU5hQR\u0004\"!\t\n\u0014\tI\t)G\u000e\t\u0004U\u0005\u001d\u0014bAA57\t1\u0011I\\=SK\u001a$\"!!\u0019\u0016\r\u0005=\u0014QOA=)\u0011\t\t(a\u001f\u0011\r\u0005\u0002\u00111OA<!\r)\u0013Q\u000f\u0003\u0006OU\u0011\r\u0001\u000b\t\u0004K\u0005eD!\u0002\u001a\u0016\u0005\u0004A\u0003BB\u001d\u0016\u0001\u0004\t9\b\u000b\u0004\u0002|\u0005\u000by(Z\u0019\u0007?\u0015\u000b\t)a\"2\r\rJE*a!Nc\u0019\u0019ClXAC\u001fF\"A%\u00180\u001dc\r)#mY\u0001\bk:\f\u0007\u000f\u001d7z+\u0019\ti)!)\u0002\u0018R!\u0011qRAM!\u0015Q\u0013\u0011SAK\u0013\r\t\u0019j\u0007\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u0007\u0015\n9\nB\u00033-\t\u0007\u0001\u0006C\u0005\u0002\u001cZ\t\t\u00111\u0001\u0002\u001e\u0006\u0019\u0001\u0010\n\u0019\u0011\r\u0005\u0002\u0011qTAK!\r)\u0013\u0011\u0015\u0003\u0006OY\u0011\r\u0001K\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002(B!\u0011QDAU\u0013\u0011\tY+a\b\u0003\r=\u0013'.Z2u\u0001")
public final class Right<A, B>
extends Either<A, B> {
    private final B value;

    public static <A, B> Option<B> unapply(Right<A, B> right) {
        return Right$.MODULE$.unapply(right);
    }

    public static <A, B> Right<A, B> apply(B b) {
        return Right$.MODULE$.apply(b);
    }

    public B value() {
        return this.value;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    public B b() {
        return this.value();
    }

    public <A, B> Right<A, B> copy(B value) {
        return new Right<A, B>(value);
    }

    public <A, B> B copy$default$1() {
        return this.value();
    }

    @Override
    public String productPrefix() {
        return "Right";
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
        return x$1 instanceof Right;
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
                boolean bl = x$1 instanceof Right;
                if (!bl) break block3;
                Right right = (Right)x$1;
                if (!BoxesRunTime.equals(this.value(), right.value())) break block3;
            }
            return true;
        }
        return false;
    }

    public Right(B value) {
        this.value = value;
    }
}

