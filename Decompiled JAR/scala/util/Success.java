/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Some;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.util.Either;
import scala.util.Failure;
import scala.util.Right;
import scala.util.Success$;
import scala.util.Try;
import scala.util.Try$;
import scala.util.control.NonFatal$;

@ScalaSignature(bytes="\u0006\u0001\t=g\u0001B\u0014)\u00056B\u0001\"\u0012\u0001\u0003\u0016\u0004%\tA\u0012\u0005\t\u000f\u0002\u0011\t\u0012)A\u0005g!)\u0001\n\u0001C\u0001\u0013\")A\n\u0001C!\u001b\")\u0011\u000b\u0001C!\u001b\")!\u000b\u0001C!\r\")1\u000b\u0001C!)\")q\f\u0001C!A\")q\r\u0001C!Q\")!\u000f\u0001C!g\"9\u00111\u0002\u0001\u0005B\u00055\u0001bBA\u0010\u0001\u0011\u0005\u0013\u0011\u0005\u0005\b\u0003\u0007\u0002A\u0011IA#\u0011\u001d\t\u0019\u0006\u0001C!\u0003+Bq!!\u001b\u0001\t\u0003\nY\u0007C\u0004\u0002t\u0001!\t%!\u001e\t\u000f\u0005E\u0007\u0001\"\u0011\u0002T\"9\u0011q\u001f\u0001\u0005B\u0005e\bbBA\u007f\u0001\u0011\u0005\u0013q \u0005\b\u0005\u000f\u0001A\u0011\tB\u0005\u0011\u001d\u0011\t\u0002\u0001C!\u0005'A\u0011Ba\n\u0001\u0003\u0003%\tA!\u000b\t\u0013\tU\u0002!%A\u0005\u0002\t]\u0002\"\u0003B)\u0001\u0005\u0005I\u0011\tB*\u0011%\u0011\u0019\u0007AA\u0001\n\u0003\u0011)\u0007C\u0005\u0003n\u0001\t\t\u0011\"\u0001\u0003p!I!Q\u000f\u0001\u0002\u0002\u0013\u0005#q\u000f\u0005\n\u0005\u000b\u0003\u0011\u0011!C\u0001\u0005\u000fC\u0011Ba#\u0001\u0003\u0003%\tE!$\t\u0013\t=\u0005!!A\u0005B\tE\u0005\"\u0003BJ\u0001\u0005\u0005I\u0011\tBK\u000f%\u0011I\nKA\u0001\u0012\u0003\u0011YJ\u0002\u0005(Q\u0005\u0005\t\u0012\u0001BO\u0011\u0019A\u0015\u0005\"\u0001\u0003&\"I!qR\u0011\u0002\u0002\u0013\u0015#\u0011\u0013\u0005\n\u0003;\u000b\u0013\u0011!CA\u0005OC\u0011Ba-\"\u0003\u0003%\tI!.\t\u0013\t\u0015\u0017%!A\u0005\n\t\u001d'aB*vG\u000e,7o\u001d\u0006\u0003S)\nA!\u001e;jY*\t1&A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00059*4\u0003\u0002\u00010\u007f\t\u00032\u0001M\u00194\u001b\u0005A\u0013B\u0001\u001a)\u0005\r!&/\u001f\t\u0003iUb\u0001\u0001\u0002\u00047\u0001\u0011\u0015\ra\u000e\u0002\u0002)F\u0011\u0001\b\u0010\t\u0003sij\u0011AK\u0005\u0003w)\u0012qAT8uQ&tw\r\u0005\u0002:{%\u0011aH\u000b\u0002\u0004\u0003:L\bCA\u001dA\u0013\t\t%FA\u0004Qe>$Wo\u0019;\u0011\u0005e\u001a\u0015B\u0001#+\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u00151\u0018\r\\;f+\u0005\u0019\u0014A\u0002<bYV,\u0007%\u0001\u0004=S:LGO\u0010\u000b\u0003\u0015.\u00032\u0001\r\u00014\u0011\u0015)5\u00011\u00014\u0003%I7OR1jYV\u0014X-F\u0001O!\tIt*\u0003\u0002QU\t9!i\\8mK\u0006t\u0017!C5t'V\u001c7-Z:t\u0003\r9W\r^\u0001\nO\u0016$xJ]#mg\u0016,\"!V,\u0015\u0005YS\u0006C\u0001\u001bX\t\u0015AvA1\u0001Z\u0005\u0005)\u0016CA\u001a=\u0011\u0019Yv\u0001\"a\u00019\u00069A-\u001a4bk2$\bcA\u001d^-&\u0011aL\u000b\u0002\ty\tLh.Y7f}\u00051qN]#mg\u0016,\"!\u00193\u0015\u0005\t,\u0007c\u0001\u00192GB\u0011A\u0007\u001a\u0003\u00061\"\u0011\r!\u0017\u0005\u00077\"!\t\u0019\u00014\u0011\u0007ej&-A\u0004gY\u0006$X*\u00199\u0016\u0005%dGC\u00016n!\r\u0001\u0014g\u001b\t\u0003i1$Q\u0001W\u0005C\u0002]BQA\\\u0005A\u0002=\f\u0011A\u001a\t\u0005sA\u001c$.\u0003\u0002rU\tIa)\u001e8di&|g.M\u0001\bM2\fG\u000f^3o+\t!x\u000f\u0006\u0002vqB\u0019\u0001'\r<\u0011\u0005Q:H!\u0002-\u000b\u0005\u00049\u0004\"B=\u000b\u0001\bQ\u0018AA3w!\u0015Y\u0018QA\u001av\u001d\ra\u0018\u0011\u0001\t\u0003{*j\u0011A \u0006\u0003\u007f2\na\u0001\u0010:p_Rt\u0014bAA\u0002U\u00051\u0001K]3eK\u001aLA!a\u0002\u0002\n\t\u0001B\u0005\\3tg\u0012\u001aw\u000e\\8oI1,7o\u001d\u0006\u0004\u0003\u0007Q\u0013a\u00024pe\u0016\f7\r[\u000b\u0005\u0003\u001f\ti\u0002\u0006\u0003\u0002\u0012\u0005]\u0001cA\u001d\u0002\u0014%\u0019\u0011Q\u0003\u0016\u0003\tUs\u0017\u000e\u001e\u0005\u0007].\u0001\r!!\u0007\u0011\u000be\u00028'a\u0007\u0011\u0007Q\ni\u0002B\u0003Y\u0017\t\u0007q'A\u0005ue\u0006t7OZ8s[V!\u00111EA\u0015)\u0019\t)#a\u000b\u00022A!\u0001'MA\u0014!\r!\u0014\u0011\u0006\u0003\u000612\u0011\ra\u000e\u0005\b\u0003[a\u0001\u0019AA\u0018\u0003\u0005\u0019\b#B\u001dqg\u0005\u0015\u0002B\u00028\r\u0001\u0004\t\u0019\u0004\u0005\u0004:a\u0006U\u0012Q\u0005\t\u0005\u0003o\tiDD\u0002:\u0003sI1!a\u000f+\u0003\u001d\u0001\u0018mY6bO\u0016LA!a\u0010\u0002B\tIA\u000b\u001b:po\u0006\u0014G.\u001a\u0006\u0004\u0003wQ\u0013aA7baV!\u0011qIA')\u0011\tI%a\u0014\u0011\tA\n\u00141\n\t\u0004i\u00055C!\u0002-\u000e\u0005\u00049\u0004B\u00028\u000e\u0001\u0004\t\t\u0006E\u0003:aN\nY%A\u0004d_2dWm\u0019;\u0016\t\u0005]\u0013Q\f\u000b\u0005\u00033\ny\u0006\u0005\u00031c\u0005m\u0003c\u0001\u001b\u0002^\u0011)\u0001L\u0004b\u0001o!9\u0011\u0011\r\bA\u0002\u0005\r\u0014A\u00019g!\u0019I\u0014QM\u001a\u0002\\%\u0019\u0011q\r\u0016\u0003\u001fA\u000b'\u000f^5bY\u001a+hn\u0019;j_:\faAZ5mi\u0016\u0014HcA\u0018\u0002n!9\u0011qN\bA\u0002\u0005E\u0014!\u00019\u0011\te\u00028GT\u0001\be\u0016\u001cwN^3s+\u0011\t9(! \u0015\t\u0005e\u0014q\u0010\t\u0005aE\nY\bE\u00025\u0003{\"Q\u0001\u0017\tC\u0002eCq!!\u0019\u0011\u0001\u0004\t\t\tE\u0004:\u0003K\n)$a\u001f)\u0011\u0005}\u0014QQAF\u0003{\u00032!OAD\u0013\r\tII\u000b\u0002\u000fI\u0016\u0004(/Z2bi\u0016$g*Y7fc\u001dy\u0012QRAJ\u0003k\u00032!OAH\u0013\r\t\tJ\u000b\u0002\u0007'fl'm\u001c72\u0013\r\n)*a'\u0002*\u0006uE\u0003BAG\u0003/Cq!!'-\u0001\u0004\t\u0019+\u0001\u0003oC6,\u0017\u0002BAO\u0003?\u000bQ!\u00199qYfT1!!)+\u0003\u0019\u0019\u00160\u001c2pYB\u001910!*\n\t\u0005\u001d\u0016\u0011\u0002\u0002\u0007'R\u0014\u0018N\\42\u0013\r\nY+!-\u00024\u0006\u0005f\u0002BAW\u0003cs1!`AX\u0013\u0005Y\u0013bAAQUE2A%!,\u00020.\nT!JA\\\u0003s{!!!/\"\u0005\u0005m\u0016a\u0004:fg\u000e,X-\u0012=dKB$\u0018n\u001c82\u0013\r\n\u0019+a0\u0002H\u0006\u0005\u0017\u0002BAa\u0003\u0007\f1\u0004\n7fgNLg.\u001b;%OJ,\u0017\r^3sI\u0011,g-Y;mi\u0012\u0012$bAAcU\u0005qA-\u001a9sK\u000e\fG/\u001a3OC6,\u0017'C\u0012\u0002J\u0006-\u0017QZAc\u001d\rI\u00141Z\u0005\u0004\u0003\u000bT\u0013'\u0002\u0012:U\u0005='!B:dC2\f\u0017a\u0003:fG>4XM],ji\",B!!6\u0002\\R!\u0011q[Ao!\u0011\u0001\u0014'!7\u0011\u0007Q\nY\u000eB\u0003Y#\t\u0007\u0011\fC\u0004\u0002bE\u0001\r!a8\u0011\u000fe\n)'!\u000e\u0002X\"B\u0011Q\\AC\u0003G\f\t0M\u0004 \u0003\u001b\u000b)/a;2\u0013\r\n)*a'\u0002h\u0006u\u0015'C\u0012\u0002,\u0006E\u0016\u0011^AQc\u0019!\u0013QVAXWE*Q%!<\u0002p>\u0011\u0011q^\u0011\u0002]FJ1%a)\u0002@\u0006M\u0018\u0011Y\u0019\nG\u0005%\u00171ZA{\u0003\u000b\fTAI\u001d+\u0003\u001f\faAZ1jY\u0016$WCAA~!\u0011\u0001\u0014'!\u000e\u0002\u0011Q|w\n\u001d;j_:,\"A!\u0001\u0011\te\u0012\u0019aM\u0005\u0004\u0005\u000bQ#AB(qi&|g.\u0001\u0005u_\u0016KG\u000f[3s+\t\u0011Y\u0001\u0005\u00041\u0005\u001b\t)dM\u0005\u0004\u0005\u001fA#AB#ji\",'/\u0001\u0003g_2$W\u0003\u0002B\u000b\u00053!bAa\u0006\u0003\u001c\t\u0005\u0002c\u0001\u001b\u0003\u001a\u0011)\u0001,\u0006b\u0001o!9!QD\u000bA\u0002\t}\u0011A\u00014b!\u0019I\u0004/!\u000e\u0003\u0018!9!1E\u000bA\u0002\t\u0015\u0012A\u00014c!\u0015I\u0004o\rB\f\u0003\u0011\u0019w\u000e]=\u0016\t\t-\"\u0011\u0007\u000b\u0005\u0005[\u0011\u0019\u0004\u0005\u00031\u0001\t=\u0002c\u0001\u001b\u00032\u0011)aG\u0006b\u0001o!AQI\u0006I\u0001\u0002\u0004\u0011y#\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\t\te\"qJ\u000b\u0003\u0005wQ3a\rB\u001fW\t\u0011y\u0004\u0005\u0003\u0003B\t-SB\u0001B\"\u0015\u0011\u0011)Ea\u0012\u0002\u0013Ut7\r[3dW\u0016$'b\u0001B%U\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\t5#1\t\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,G!\u0002\u001c\u0018\u0005\u00049\u0014!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070\u0006\u0002\u0003VA!!q\u000bB1\u001b\t\u0011IF\u0003\u0003\u0003\\\tu\u0013\u0001\u00027b]\u001eT!Aa\u0018\u0002\t)\fg/Y\u0005\u0005\u0003O\u0013I&\u0001\u0007qe>$Wo\u0019;Be&$\u00180\u0006\u0002\u0003hA\u0019\u0011H!\u001b\n\u0007\t-$FA\u0002J]R\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000fF\u0002=\u0005cB\u0011Ba\u001d\u001b\u0003\u0003\u0005\rAa\u001a\u0002\u0007a$\u0013'A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\t\u0011I\bE\u0003\u0003|\t\u0005E(\u0004\u0002\u0003~)\u0019!q\u0010\u0016\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0003\u0003\u0004\nu$\u0001C%uKJ\fGo\u001c:\u0002\u0011\r\fg.R9vC2$2A\u0014BE\u0011!\u0011\u0019\bHA\u0001\u0002\u0004a\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\t\u001d\u0014\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\tU\u0013AB3rk\u0006d7\u000fF\u0002O\u0005/C\u0001Ba\u001d \u0003\u0003\u0005\r\u0001P\u0001\b'V\u001c7-Z:t!\t\u0001\u0014e\u0005\u0003\"\u0005?\u0013\u0005cA\u001d\u0003\"&\u0019!1\u0015\u0016\u0003\r\u0005s\u0017PU3g)\t\u0011Y*\u0006\u0003\u0003*\n=F\u0003\u0002BV\u0005c\u0003B\u0001\r\u0001\u0003.B\u0019AGa,\u0005\u000bY\"#\u0019A\u001c\t\r\u0015#\u0003\u0019\u0001BW\u0003\u001d)h.\u00199qYf,BAa.\u0003>R!!\u0011\u0018B`!\u0015I$1\u0001B^!\r!$Q\u0018\u0003\u0006m\u0015\u0012\ra\u000e\u0005\n\u0005\u0003,\u0013\u0011!a\u0001\u0005\u0007\f1\u0001\u001f\u00131!\u0011\u0001\u0004Aa/\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0003\u0005\u0013\u0004BAa\u0016\u0003L&!!Q\u001aB-\u0005\u0019y%M[3di\u0002")
public final class Success<T>
extends Try<T> {
    private final T value;

    public static <T> Option<T> unapply(Success<T> success) {
        return Success$.MODULE$.unapply(success);
    }

    public static <T> Success<T> apply(T t) {
        return Success$.MODULE$.apply(t);
    }

    public T value() {
        return this.value;
    }

    @Override
    public boolean isFailure() {
        return false;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public T get() {
        return this.value();
    }

    @Override
    public <U> U getOrElse(Function0<U> function0) {
        return (U)this.get();
    }

    @Override
    public <U> Try<U> orElse(Function0<Try<U>> function0) {
        return this;
    }

    @Override
    public <U> Try<U> flatMap(Function1<T, Try<U>> f) {
        try {
            return f.apply(this.value());
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure failure = new Failure(e);
            return failure;
        }
    }

    @Override
    public <U> Try<U> flatten(Predef$.less.colon.less<T, Try<U>> ev) {
        return (Try)ev.apply(this.value());
    }

    @Override
    public <U> void foreach(Function1<T, U> f) {
        f.apply(this.value());
    }

    @Override
    public <U> Try<U> transform(Function1<T, Try<U>> s, Function1<Throwable, Try<U>> f) {
        try {
            return s.apply(this.value());
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable flatMap_e = option.get();
            Failure failure = new Failure(flatMap_e);
            return failure;
        }
    }

    @Override
    public <U> Try<U> map(Function1<T, U> f) {
        if (Try$.MODULE$ == null) {
            throw null;
        }
        try {
            return new Success<Object>(f.apply(this.value()));
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable apply_e = option.get();
            Failure failure = new Failure(apply_e);
            return failure;
        }
    }

    @Override
    public <U> Try<U> collect(PartialFunction<T, U> pf) {
        Try try_;
        try {
            if (!pf.isDefinedAt(this.value())) {
                return new Failure(new NoSuchElementException(new StringBuilder(28).append("Predicate does not hold for ").append(this.value()).toString()));
            }
            try_ = new Success(pf.apply(this.value()));
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure failure = new Failure(e);
            try_ = failure;
        }
        return try_;
    }

    @Override
    public Try<T> filter(Function1<T, Object> p) {
        Try try_;
        try {
            if (!BoxesRunTime.unboxToBoolean(p.apply(this.value()))) {
                return new Failure(new NoSuchElementException(new StringBuilder(28).append("Predicate does not hold for ").append(this.value()).toString()));
            }
            try_ = this;
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            Failure failure = new Failure(e);
            try_ = failure;
        }
        return try_;
    }

    @Override
    public <U> Try<U> recover(PartialFunction<Throwable, U> pf) {
        return this;
    }

    @Override
    public <U> Try<U> recoverWith(PartialFunction<Throwable, Try<U>> pf) {
        return this;
    }

    @Override
    public Try<Throwable> failed() {
        return new Failure<Throwable>(new UnsupportedOperationException("Success.failed"));
    }

    @Override
    public Option<T> toOption() {
        return new Some<T>(this.value());
    }

    @Override
    public Either<Throwable, T> toEither() {
        return new Right(this.value());
    }

    @Override
    public <U> U fold(Function1<Throwable, U> fa, Function1<T, U> fb) {
        try {
            return fb.apply(this.value());
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable e = option.get();
            U u = fa.apply(e);
            return u;
        }
    }

    public <T> Success<T> copy(T value) {
        return new Success<T>(value);
    }

    public <T> T copy$default$1() {
        return this.value();
    }

    @Override
    public String productPrefix() {
        return "Success";
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
        return x$1 instanceof Success;
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
                boolean bl = x$1 instanceof Success;
                if (!bl) break block3;
                Success success = (Success)x$1;
                if (!BoxesRunTime.equals(this.value(), success.value())) break block3;
            }
            return true;
        }
        return false;
    }

    public Success(T value) {
        this.value = value;
    }
}

