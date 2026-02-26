/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.util.Either;
import scala.util.Failure$;
import scala.util.Left;
import scala.util.Success;
import scala.util.Try;
import scala.util.control.NonFatal$;

@ScalaSignature(bytes="\u0006\u0001\tEg\u0001B\u0014)\u00056B\u0001\"\u0012\u0001\u0003\u0016\u0004%\tA\u0012\u0005\t\u001d\u0002\u0011\t\u0012)A\u0005\u000f\")q\n\u0001C\u0001!\")1\u000b\u0001C!)\")\u0001\f\u0001C!)\")\u0011\f\u0001C!5\")1\f\u0001C!9\")q\r\u0001C!Q\")q\u000e\u0001C!a\")!\u0010\u0001C!w\"9\u00111\u0004\u0001\u0005B\u0005u\u0001bBA\u0018\u0001\u0011\u0005\u0013\u0011\u0007\u0005\b\u0003\u000b\u0002A\u0011IA$\u0011\u001d\t)\u0006\u0001C!\u0003/Bq!a\u001b\u0001\t\u0003\ni\u0007C\u0004\u0002v\u0001!\t%a\u001e\t\u000f\u0005M\u0007\u0001\"\u0011\u0002V\"9\u0011\u0011 \u0001\u0005B\u0005m\bbBA\u0000\u0001\u0011\u0005#\u0011\u0001\u0005\b\u0005\u0013\u0001A\u0011\tB\u0006\u0011\u001d\u0011\u0019\u0002\u0001C!\u0005+A\u0011B!\u000b\u0001\u0003\u0003%\tAa\u000b\t\u0013\t]\u0002!%A\u0005\u0002\te\u0002\"\u0003B*\u0001\u0005\u0005I\u0011\tB+\u0011%\u0011)\u0007AA\u0001\n\u0003\u00119\u0007C\u0005\u0003p\u0001\t\t\u0011\"\u0001\u0003r!I!q\u000f\u0001\u0002\u0002\u0013\u0005#\u0011\u0010\u0005\n\u0005\u000f\u0003\u0011\u0011!C\u0001\u0005\u0013C\u0011B!$\u0001\u0003\u0003%\tEa$\t\u0013\tE\u0005!!A\u0005B\tM\u0005\"\u0003BK\u0001\u0005\u0005I\u0011\tBL\u000f%\u0011Y\nKA\u0001\u0012\u0003\u0011iJ\u0002\u0005(Q\u0005\u0005\t\u0012\u0001BP\u0011\u0019y\u0015\u0005\"\u0001\u0003(\"I!\u0011S\u0011\u0002\u0002\u0013\u0015#1\u0013\u0005\n\u0003?\u000b\u0013\u0011!CA\u0005SC\u0011B!.\"\u0003\u0003%\tIa.\t\u0013\t\u001d\u0017%!A\u0005\n\t%'a\u0002$bS2,(/\u001a\u0006\u0003S)\nA!\u001e;jY*\t1&A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00059*4\u0003\u0002\u00010\u007f\t\u00032\u0001M\u00194\u001b\u0005A\u0013B\u0001\u001a)\u0005\r!&/\u001f\t\u0003iUb\u0001\u0001\u0002\u00047\u0001\u0011\u0015\ra\u000e\u0002\u0002)F\u0011\u0001\b\u0010\t\u0003sij\u0011AK\u0005\u0003w)\u0012qAT8uQ&tw\r\u0005\u0002:{%\u0011aH\u000b\u0002\u0004\u0003:L\bCA\u001dA\u0013\t\t%FA\u0004Qe>$Wo\u0019;\u0011\u0005e\u001a\u0015B\u0001#+\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003%)\u0007pY3qi&|g.F\u0001H!\tA5J\u0004\u0002:\u0013&\u0011!JK\u0001\ba\u0006\u001c7.Y4f\u0013\taUJA\u0005UQJ|w/\u00192mK*\u0011!JK\u0001\u000bKb\u001cW\r\u001d;j_:\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0002R%B\u0019\u0001\u0007A\u001a\t\u000b\u0015\u001b\u0001\u0019A$\u0002\u0013%\u001ch)Y5mkJ,W#A+\u0011\u0005e2\u0016BA,+\u0005\u001d\u0011un\u001c7fC:\f\u0011\"[:Tk\u000e\u001cWm]:\u0002\u0007\u001d,G/F\u00014\u0003%9W\r^(s\u000b2\u001cX-\u0006\u0002^?R\u0011aL\u0019\t\u0003i}#Q\u0001Y\u0004C\u0002\u0005\u0014\u0011!V\t\u0003gqBaaY\u0004\u0005\u0002\u0004!\u0017a\u00023fM\u0006,H\u000e\u001e\t\u0004s\u0015t\u0016B\u00014+\u0005!a$-\u001f8b[\u0016t\u0014AB8s\u000b2\u001cX-\u0006\u0002jYR\u0011!.\u001c\t\u0004aEZ\u0007C\u0001\u001bm\t\u0015\u0001\u0007B1\u0001b\u0011\u0019\u0019\u0007\u0002\"a\u0001]B\u0019\u0011(\u001a6\u0002\u000f\u0019d\u0017\r^'baV\u0011\u0011\u000f\u001e\u000b\u0003eV\u00042\u0001M\u0019t!\t!D\u000fB\u0003a\u0013\t\u0007q\u0007C\u0003w\u0013\u0001\u0007q/A\u0001g!\u0011I\u0004p\r:\n\u0005eT#!\u0003$v]\u000e$\u0018n\u001c82\u0003\u001d1G.\u0019;uK:,\"\u0001`@\u0015\u0007u\f\t\u0001E\u00021cy\u0004\"\u0001N@\u0005\u000b\u0001T!\u0019A\u001c\t\u000f\u0005\r!\u0002q\u0001\u0002\u0006\u0005\u0011QM\u001e\t\u0007\u0003\u000f\t)bM?\u000f\t\u0005%\u0011\u0011\u0003\t\u0004\u0003\u0017QSBAA\u0007\u0015\r\ty\u0001L\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005M!&\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003/\tIB\u0001\t%Y\u0016\u001c8\u000fJ2pY>tG\u0005\\3tg*\u0019\u00111\u0003\u0016\u0002\u000f\u0019|'/Z1dQV!\u0011qDA\u0017)\u0011\t\t#a\n\u0011\u0007e\n\u0019#C\u0002\u0002&)\u0012A!\u00168ji\"1ao\u0003a\u0001\u0003S\u0001R!\u000f=4\u0003W\u00012\u0001NA\u0017\t\u0015\u00017B1\u00018\u0003%!(/\u00198tM>\u0014X.\u0006\u0003\u00024\u0005eBCBA\u001b\u0003w\t\t\u0005\u0005\u00031c\u0005]\u0002c\u0001\u001b\u0002:\u0011)\u0001\r\u0004b\u0001o!9\u0011Q\b\u0007A\u0002\u0005}\u0012!A:\u0011\u000beB8'!\u000e\t\rYd\u0001\u0019AA\"!\u0015I\u0004pRA\u001b\u0003\ri\u0017\r]\u000b\u0005\u0003\u0013\ny\u0005\u0006\u0003\u0002L\u0005E\u0003\u0003\u0002\u00192\u0003\u001b\u00022\u0001NA(\t\u0015\u0001WB1\u00018\u0011\u00191X\u00021\u0001\u0002TA)\u0011\b_\u001a\u0002N\u000591m\u001c7mK\u000e$X\u0003BA-\u0003?\"B!a\u0017\u0002bA!\u0001'MA/!\r!\u0014q\f\u0003\u0006A:\u0011\ra\u000e\u0005\b\u0003Gr\u0001\u0019AA3\u0003\t\u0001h\r\u0005\u0004:\u0003O\u001a\u0014QL\u0005\u0004\u0003SR#a\u0004)beRL\u0017\r\u001c$v]\u000e$\u0018n\u001c8\u0002\r\u0019LG\u000e^3s)\ry\u0013q\u000e\u0005\b\u0003cz\u0001\u0019AA:\u0003\u0005\u0001\b\u0003B\u001dygU\u000bqA]3d_Z,'/\u0006\u0003\u0002z\u0005}D\u0003BA>\u0003\u0003\u0003B\u0001M\u0019\u0002~A\u0019A'a \u0005\u000b\u0001\u0004\"\u0019A1\t\u000f\u0005\r\u0004\u00031\u0001\u0002\u0004B1\u0011(a\u001aH\u0003{B\u0003\"!!\u0002\b\u00065\u0015q\u0018\t\u0004s\u0005%\u0015bAAFU\tqA-\u001a9sK\u000e\fG/\u001a3OC6,\u0017gB\u0010\u0002\u0010\u0006U\u0015q\u0017\t\u0004s\u0005E\u0015bAAJU\t11+_7c_2\f\u0014bIAL\u0003;\u000bY+a(\u0015\t\u0005=\u0015\u0011\u0014\u0005\b\u00037c\u0003\u0019AAS\u0003\u0011q\u0017-\\3\n\t\u0005}\u0015\u0011U\u0001\u0006CB\u0004H.\u001f\u0006\u0004\u0003GS\u0013AB*z[\n|G\u000e\u0005\u0003\u0002\b\u0005\u001d\u0016\u0002BAU\u00033\u0011aa\u0015;sS:<\u0017'C\u0012\u0002.\u0006M\u0016QWAR\u001d\u0011\ty+a-\u000f\t\u0005-\u0011\u0011W\u0005\u0002W%\u0019\u00111\u0015\u00162\r\u0011\ny+!-,c\u0015)\u0013\u0011XA^\u001f\t\tY,\t\u0002\u0002>\u0006y!/Z:dk\u0016,\u0005pY3qi&|g.M\u0005$\u0003K\u000b\t-!3\u0002D&!\u00111YAc\u0003m!C.Z:tS:LG\u000fJ4sK\u0006$XM\u001d\u0013eK\u001a\fW\u000f\u001c;%e)\u0019\u0011q\u0019\u0016\u0002\u001d\u0011,\u0007O]3dCR,GMT1nKFJ1%a3\u0002N\u0006=\u0017q\u0019\b\u0004s\u00055\u0017bAAdUE*!%\u000f\u0016\u0002R\n)1oY1mC\u0006Y!/Z2pm\u0016\u0014x+\u001b;i+\u0011\t9.!8\u0015\t\u0005e\u0017q\u001c\t\u0005aE\nY\u000eE\u00025\u0003;$Q\u0001Y\tC\u0002\u0005Dq!a\u0019\u0012\u0001\u0004\t\t\u000f\u0005\u0004:\u0003O:\u0015\u0011\u001c\u0015\t\u0003?\f9)!:\u0002tF:q$a$\u0002h\u00065\u0018'C\u0012\u0002\u0018\u0006u\u0015\u0011^APc%\u0019\u0013QVAZ\u0003W\f\u0019+\r\u0004%\u0003_\u000b\tlK\u0019\u0006K\u0005=\u0018\u0011_\b\u0003\u0003c\f\u0013A^\u0019\nG\u0005\u0015\u0016\u0011YA{\u0003\u0007\f\u0014bIAf\u0003\u001b\f90a22\u000b\tJ$&!5\u0002\r\u0019\f\u0017\u000e\\3e+\t\ti\u0010E\u00021c\u001d\u000b\u0001\u0002^8PaRLwN\\\u000b\u0003\u0005\u0007\u0001B!\u000fB\u0003g%\u0019!q\u0001\u0016\u0003\r=\u0003H/[8o\u0003!!x.R5uQ\u0016\u0014XC\u0001B\u0007!\u0015\u0001$qB$4\u0013\r\u0011\t\u0002\u000b\u0002\u0007\u000b&$\b.\u001a:\u0002\t\u0019|G\u000eZ\u000b\u0005\u0005/\u0011Y\u0002\u0006\u0004\u0003\u001a\tu!1\u0005\t\u0004i\tmA!\u00021\u0016\u0005\u00049\u0004b\u0002B\u0010+\u0001\u0007!\u0011E\u0001\u0003M\u0006\u0004R!\u000f=H\u00053AqA!\n\u0016\u0001\u0004\u00119#\u0001\u0002gEB)\u0011\b_\u001a\u0003\u001a\u0005!1m\u001c9z+\u0011\u0011iCa\r\u0015\t\t=\"Q\u0007\t\u0005a\u0001\u0011\t\u0004E\u00025\u0005g!QA\u000e\fC\u0002]Bq!\u0012\f\u0011\u0002\u0003\u0007q)\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\t\tm\"\u0011K\u000b\u0003\u0005{Q3a\u0012B W\t\u0011\t\u0005\u0005\u0003\u0003D\t5SB\u0001B#\u0015\u0011\u00119E!\u0013\u0002\u0013Ut7\r[3dW\u0016$'b\u0001B&U\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\t=#Q\t\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,G!\u0002\u001c\u0018\u0005\u00049\u0014!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070\u0006\u0002\u0003XA!!\u0011\fB2\u001b\t\u0011YF\u0003\u0003\u0003^\t}\u0013\u0001\u00027b]\u001eT!A!\u0019\u0002\t)\fg/Y\u0005\u0005\u0003S\u0013Y&\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0006\u0002\u0003jA\u0019\u0011Ha\u001b\n\u0007\t5$FA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000fF\u0002=\u0005gB\u0011B!\u001e\u001b\u0003\u0003\u0005\rA!\u001b\u0002\u0007a$\u0013'A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\t\u0011Y\bE\u0003\u0003~\t\rE(\u0004\u0002\u0003\u0000)\u0019!\u0011\u0011\u0016\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0003\u0003\u0006\n}$\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$2!\u0016BF\u0011!\u0011)\bHA\u0001\u0002\u0004a\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\t%\u0014\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\t]\u0013AB3rk\u0006d7\u000fF\u0002V\u00053C\u0001B!\u001e \u0003\u0003\u0005\r\u0001P\u0001\b\r\u0006LG.\u001e:f!\t\u0001\u0014e\u0005\u0003\"\u0005C\u0013\u0005cA\u001d\u0003$&\u0019!Q\u0015\u0016\u0003\r\u0005s\u0017PU3g)\t\u0011i*\u0006\u0003\u0003,\nEF\u0003\u0002BW\u0005g\u0003B\u0001\r\u0001\u00030B\u0019AG!-\u0005\u000bY\"#\u0019A\u001c\t\u000b\u0015#\u0003\u0019A$\u0002\u000fUt\u0017\r\u001d9msV!!\u0011\u0018Bc)\u0011\u0011YL!0\u0011\te\u0012)a\u0012\u0005\n\u0005\u007f+\u0013\u0011!a\u0001\u0005\u0003\f1\u0001\u001f\u00131!\u0011\u0001\u0004Aa1\u0011\u0007Q\u0012)\rB\u00037K\t\u0007q'A\u0006sK\u0006$'+Z:pYZ,GC\u0001Bf!\u0011\u0011IF!4\n\t\t='1\f\u0002\u0007\u001f\nTWm\u0019;")
public final class Failure<T>
extends Try<T> {
    private final Throwable exception;

    public static <T> Option<Throwable> unapply(Failure<T> failure) {
        return Failure$.MODULE$.unapply(failure);
    }

    public static <T> Failure<T> apply(Throwable throwable) {
        return Failure$.MODULE$.apply(throwable);
    }

    public Throwable exception() {
        return this.exception;
    }

    @Override
    public boolean isFailure() {
        return true;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public T get() {
        throw this.exception();
    }

    @Override
    public <U> U getOrElse(Function0<U> function0) {
        return function0.apply();
    }

    @Override
    public <U> Try<U> orElse(Function0<Try<U>> function0) {
        try {
            return function0.apply();
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure<T> failure = new Failure<T>(e);
            return failure;
        }
    }

    @Override
    public <U> Try<U> flatMap(Function1<T, Try<U>> f) {
        return this;
    }

    @Override
    public <U> Try<U> flatten(Predef$.less.colon.less<T, Try<U>> ev) {
        return this;
    }

    @Override
    public <U> void foreach(Function1<T, U> f) {
    }

    @Override
    public <U> Try<U> transform(Function1<T, Try<U>> s, Function1<Throwable, Try<U>> f) {
        try {
            return f.apply(this.exception());
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure<T> failure = new Failure<T>(e);
            return failure;
        }
    }

    @Override
    public <U> Try<U> map(Function1<T, U> f) {
        return this;
    }

    @Override
    public <U> Try<U> collect(PartialFunction<T, U> pf) {
        return this;
    }

    @Override
    public Try<T> filter(Function1<T, Object> p) {
        return this;
    }

    @Override
    public <U> Try<U> recover(PartialFunction<Throwable, U> pf) {
        Try try_;
        try {
            if (!pf.isDefinedAt(this.exception())) {
                return this;
            }
            try_ = new Success(pf.apply(this.exception()));
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure<T> failure = new Failure<T>(e);
            try_ = failure;
        }
        return try_;
    }

    @Override
    public <U> Try<U> recoverWith(PartialFunction<Throwable, Try<U>> pf) {
        Failure<T> failure;
        try {
            if (!pf.isDefinedAt(this.exception())) {
                return this;
            }
            failure = (Failure<T>)pf.apply(this.exception());
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure<T> failure2 = new Failure<T>(e);
            failure = failure2;
        }
        return failure;
    }

    @Override
    public Try<Throwable> failed() {
        return new Success<Throwable>(this.exception());
    }

    @Override
    public Option<T> toOption() {
        return None$.MODULE$;
    }

    @Override
    public Either<Throwable, T> toEither() {
        return new Left(this.exception());
    }

    @Override
    public <U> U fold(Function1<Throwable, U> fa, Function1<T, U> fb) {
        return fa.apply(this.exception());
    }

    public <T> Failure<T> copy(Throwable exception) {
        return new Failure<T>(exception);
    }

    public <T> Throwable copy$default$1() {
        return this.exception();
    }

    @Override
    public String productPrefix() {
        return "Failure";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.exception();
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
        return x$1 instanceof Failure;
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
                boolean bl = x$1 instanceof Failure;
                if (!bl) break block3;
                Failure failure = (Failure)x$1;
                Throwable throwable = this.exception();
                Throwable throwable2 = failure.exception();
                if (!(!(throwable != null ? !throwable.equals(throwable2) : throwable2 != null))) break block3;
            }
            return true;
        }
        return false;
    }

    public Failure(Throwable exception) {
        this.exception = exception;
    }
}

