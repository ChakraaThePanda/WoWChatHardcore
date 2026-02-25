/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.Function1;
import scala.Serializable;
import scala.concurrent.Future;
import scala.concurrent.Future$InternalCallbackExecutor$;
import scala.concurrent.Promise$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;

@ScalaSignature(bytes="\u0006\u0001\u0005MeaB\n\u0015!\u0003\r\t!\u0007\u0005\u0006?\u0001!\t\u0001\t\u0005\u0006I\u00011\t!\n\u0005\u0006k\u00011\tA\u000e\u0005\u0006u\u0001!\ta\u000f\u0005\u0006\u000b\u00021\tA\u0012\u0005\u0006\u0011\u0002!)!\u0013\u0005\u0006\u0019\u0002!)!\u0014\u0005\u0006\u001f\u0002!\t\u0001\u0015\u0005\b\u0003\u000b\u0001A\u0011AA\u0004\u0011\u001d\tY\u0001\u0001C\u0001\u0003\u001bAq!!\u000f\u0001\t\u0003\tYdB\u0004\u0002RQA\t!a\u0015\u0007\rM!\u0002\u0012AA+\u0011\u001d\t9&\u0004C\u0001\u00033Ba\u0001Y\u0007\u0005\u0002\u0005m\u0003bBA3\u001b\u0011\u0005\u0011q\r\u0005\b\u0003kjA\u0011AA<\u0011\u001d\t\u0019)\u0004C\u0001\u0003\u000b\u0013q\u0001\u0015:p[&\u001cXM\u0003\u0002\u0016-\u0005Q1m\u001c8dkJ\u0014XM\u001c;\u000b\u0003]\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u001bYM\u0011\u0001a\u0007\t\u00039ui\u0011AF\u0005\u0003=Y\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001\"!\ta\"%\u0003\u0002$-\t!QK\\5u\u0003\u00191W\u000f^;sKV\ta\u0005E\u0002(Q)j\u0011\u0001F\u0005\u0003SQ\u0011aAR;ukJ,\u0007CA\u0016-\u0019\u0001!Q!\f\u0001C\u00029\u0012\u0011\u0001V\t\u0003_I\u0002\"\u0001\b\u0019\n\u0005E2\"a\u0002(pi\"Lgn\u001a\t\u00039MJ!\u0001\u000e\f\u0003\u0007\u0005s\u00170A\u0006jg\u000e{W\u000e\u001d7fi\u0016$W#A\u001c\u0011\u0005qA\u0014BA\u001d\u0017\u0005\u001d\u0011un\u001c7fC:\f\u0001bY8na2,G/\u001a\u000b\u0003yuj\u0011\u0001\u0001\u0005\u0006}\u0011\u0001\raP\u0001\u0007e\u0016\u001cX\u000f\u001c;\u0011\u0007\u0001\u001b%&D\u0001B\u0015\t\u0011e#\u0001\u0003vi&d\u0017B\u0001#B\u0005\r!&/_\u0001\fiJL8i\\7qY\u0016$X\r\u0006\u00028\u000f\")a(\u0002a\u0001\u007f\u0005a1m\\7qY\u0016$XmV5uQR\u0011AH\u0013\u0005\u0006\u0017\u001a\u0001\rAJ\u0001\u0006_RDWM]\u0001\u0010iJL8i\\7qY\u0016$XmV5uQR\u0011AH\u0014\u0005\u0006\u0017\u001e\u0001\rAJ\u0001\bgV\u001c7-Z:t)\ta\u0014\u000bC\u0003S\u0011\u0001\u0007!&A\u0003wC2,X\r\u000b\u0003R)^C\bC\u0001\u000fV\u0013\t1fC\u0001\beKB\u0014XmY1uK\u0012t\u0015-\\32\t}A6\f\u001e\t\u00039eK!A\u0017\f\u0003\rMKXNY8mc\u0015\u0019Cl\u00188a)\tAV\fC\u0003_1\u0001\u00071-\u0001\u0003oC6,\u0017B\u00011b\u0003\u0015\t\u0007\u000f\u001d7z\u0015\t\u0011g#\u0001\u0004Ts6\u0014w\u000e\u001c\t\u0003I.t!!Z5\u0011\u0005\u00194R\"A4\u000b\u0005!D\u0012A\u0002\u001fs_>$h(\u0003\u0002k-\u00051\u0001K]3eK\u001aL!\u0001\\7\u0003\rM#(/\u001b8h\u0015\tQg#M\u0003$_J\u001c(M\u0004\u0002qe:\u0011a-]\u0005\u0002/%\u0011!MF\u0019\u0005IA\fx#M\u0002&kZ|\u0011A^\u0011\u0002o\u0006\ta/M\u0003$Gfl(0\u0003\u0002{w\u0006YB\u0005\\3tg&t\u0017\u000e\u001e\u0013he\u0016\fG/\u001a:%I\u00164\u0017-\u001e7uIIR!\u0001 \f\u0002\u001d\u0011,\u0007O]3dCR,GMT1nKF21E`@\u0002\u0002qt!\u0001H@\n\u0005q4\u0012'\u0002\u0012\u001d-\u0005\r!!B:dC2\f\u0017A\u0003;ssN+8mY3tgR\u0019q'!\u0003\t\u000bIK\u0001\u0019\u0001\u0016\u0002\u000f\u0019\f\u0017\u000e\\;sKR\u0019A(a\u0004\t\u000f\u0005E!\u00021\u0001\u0002\u0014\u0005)1-Y;tKB!\u0011QCA\u000e\u001d\r\u0001\u0018qC\u0005\u0004\u000331\u0012a\u00029bG.\fw-Z\u0005\u0005\u0003;\tyBA\u0005UQJ|w/\u00192mK*\u0019\u0011\u0011\u0004\f)\u000f\u0005=A+a\t\u00024E2q\u0004WA\u0013\u0003W\tda\t/`\u0003O\u0001\u0017GB\u0012pe\u0006%\"-\r\u0003%aF<\u0012'B\u0013\u0002.\u0005=rBAA\u0018C\t\t\t$A\u0001uc\u0019\u00193-_A\u001buF21E`@\u00028q\fTA\t\u000f\u0017\u0003\u0007\t!\u0002\u001e:z\r\u0006LG.\u001e:f)\r9\u0014Q\b\u0005\b\u0003#Y\u0001\u0019AA\nQ\u001d\ti\u0004VA!\u0003\u0017\nda\b-\u0002D\u0005%\u0013GB\u0012]?\u0006\u0015\u0003-\r\u0004$_J\f9EY\u0019\u0005IA\fx#M\u0003&\u0003[\ty#\r\u0004$Gf\fiE_\u0019\u0007Gy|\u0018q\n?2\u000b\tbb#a\u0001\u0002\u000fA\u0013x.\\5tKB\u0011q%D\n\u0003\u001bm\ta\u0001P5oSRtDCAA*+\u0011\ti&a\u0019\u0015\u0005\u0005}\u0003\u0003B\u0014\u0001\u0003C\u00022aKA2\t\u0015isB1\u0001/\u0003\u00191\u0017-\u001b7fIV!\u0011\u0011NA8)\u0011\tY'!\u001d\u0011\t\u001d\u0002\u0011Q\u000e\t\u0004W\u0005=D!B\u0017\u0011\u0005\u0004q\u0003bBA:!\u0001\u0007\u00111C\u0001\nKb\u001cW\r\u001d;j_:\f!b];dG\u0016\u001c8OZ;m+\u0011\tI(a \u0015\t\u0005m\u0014\u0011\u0011\t\u0005O\u0001\ti\bE\u0002,\u0003\u007f\"Q!L\tC\u00029BaAP\tA\u0002\u0005u\u0014a\u00024s_6$&/_\u000b\u0005\u0003\u000f\u000bi\t\u0006\u0003\u0002\n\u0006=\u0005\u0003B\u0014\u0001\u0003\u0017\u00032aKAG\t\u0015i#C1\u0001/\u0011\u0019q$\u00031\u0001\u0002\u0012B!\u0001iQAF\u0001")
public interface Promise<T> {
    public static <T> Promise<T> fromTry(Try<T> try_) {
        return Promise$.MODULE$.fromTry(try_);
    }

    public static <T> Promise<T> successful(T t) {
        return Promise$.MODULE$.successful(t);
    }

    public static <T> Promise<T> failed(Throwable throwable) {
        return Promise$.MODULE$.failed(throwable);
    }

    public static <T> Promise<T> apply() {
        return Promise$.MODULE$.apply();
    }

    public Future<T> future();

    public boolean isCompleted();

    public static /* synthetic */ Promise complete$(Promise $this, Try result2) {
        return $this.complete(result2);
    }

    default public Promise<T> complete(Try<T> result2) {
        if (this.tryComplete(result2)) {
            return this;
        }
        throw new IllegalStateException("Promise already completed.");
    }

    public boolean tryComplete(Try<T> var1);

    public static /* synthetic */ Promise completeWith$(Promise $this, Future other) {
        return $this.completeWith(other);
    }

    default public Promise<T> completeWith(Future<T> other) {
        return this.tryCompleteWith(other);
    }

    public static /* synthetic */ Promise tryCompleteWith$(Promise $this, Future other) {
        return $this.tryCompleteWith(other);
    }

    default public Promise<T> tryCompleteWith(Future<T> other) {
        if (other != this.future()) {
            other.onComplete((Function1<Try, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(this.tryComplete(x$1)), Future$InternalCallbackExecutor$.MODULE$);
        }
        return this;
    }

    public static /* synthetic */ Promise success$(Promise $this, Object value) {
        return $this.success(value);
    }

    default public Promise<T> success(T value) {
        return this.complete(new Success<T>(value));
    }

    public static /* synthetic */ boolean trySuccess$(Promise $this, Object value) {
        return $this.trySuccess(value);
    }

    default public boolean trySuccess(T value) {
        return this.tryComplete(new Success<T>(value));
    }

    public static /* synthetic */ Promise failure$(Promise $this, Throwable cause) {
        return $this.failure(cause);
    }

    default public Promise<T> failure(Throwable cause) {
        return this.complete(new Failure(cause));
    }

    public static /* synthetic */ boolean tryFailure$(Promise $this, Throwable cause) {
        return $this.tryFailure(cause);
    }

    default public boolean tryFailure(Throwable cause) {
        return this.tryComplete(new Failure(cause));
    }

    public static void $init$(Promise $this) {
    }
}

