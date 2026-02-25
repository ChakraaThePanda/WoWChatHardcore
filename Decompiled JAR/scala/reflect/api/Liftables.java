/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.Option;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Liftables$Liftable$;
import scala.reflect.api.Liftables$Unliftable$;
import scala.reflect.api.Trees;

@ScalaSignature(bytes="\u0006\u000154\u0001BD\b\u0011\u0002\u0007\u0005a#\u001b\u0005\u00067\u0001!\t\u0001\b\u0004\bA\u0001\u0001\n1%\u0001\"\u0011\u0015\u0019#A\"\u0001%\u000f\u0015A\u0004\u0001#\u0001:\r\u0015\u0001\u0003\u0001#\u0001;\u0011\u0015\u0001U\u0001\"\u0001B\u0011\u0015\u0019S\u0001\"\u0001C\r\u001da\u0005\u0001%A\u0012\u00025CQa\u0014\u0005\u0007\u0002A;Q\u0001\u0017\u0001\t\u0002e3Q\u0001\u0014\u0001\t\u0002iCQ\u0001Q\u0006\u0005\u0002yCQaI\u0006\u0005\u0002}\u0013\u0011\u0002T5gi\u0006\u0014G.Z:\u000b\u0005A\t\u0012aA1qS*\u0011!cE\u0001\be\u00164G.Z2u\u0015\u0005!\u0012!B:dC2\f7\u0001A\n\u0003\u0001]\u0001\"\u0001G\r\u000e\u0003MI!AG\n\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\tQ\u0004\u0005\u0002\u0019=%\u0011qd\u0005\u0002\u0005+:LGO\u0001\u0005MS\u001a$\u0018M\u00197f+\t\u0011sf\u0005\u0002\u0003/\u0005)\u0011\r\u001d9msR\u0011Qe\u000b\t\u0003M\u001dj\u0011\u0001A\u0005\u0003Q%\u0012A\u0001\u0016:fK&\u0011!f\u0004\u0002\u0006)J,Wm\u001d\u0005\u0006Y\r\u0001\r!L\u0001\u0006m\u0006dW/\u001a\t\u0003]=b\u0001\u0001B\u00031\u0005\t\u0007\u0011GA\u0001U#\t\u0011T\u0007\u0005\u0002\u0019g%\u0011Ag\u0005\u0002\b\u001d>$\b.\u001b8h!\tAb'\u0003\u00028'\t\u0019\u0011I\\=\u0002\u00111Kg\r^1cY\u0016\u0004\"AJ\u0003\u0014\u0007\u001592\b\u0005\u0002'y%\u0011QH\u0010\u0002\u001a'R\fg\u000eZ1sI2Kg\r^1cY\u0016Len\u001d;b]\u000e,7/\u0003\u0002@\u001f\t\t2\u000b^1oI\u0006\u0014H\rT5gi\u0006\u0014G.Z:\u0002\rqJg.\u001b;?)\u0005ITCA\"G)\t!u\tE\u0002'\u0005\u0015\u0003\"A\f$\u0005\u000bA:!\u0019A\u0019\t\u000b!;\u0001\u0019A%\u0002\u0003\u0019\u0004B\u0001\u0007&FK%\u00111j\u0005\u0002\n\rVt7\r^5p]F\u0012!\"\u00168mS\u001a$\u0018M\u00197f+\tqUk\u0005\u0002\t/\u00059QO\\1qa2LHCA)W!\rA\"\u000bV\u0005\u0003'N\u0011aa\u00149uS>t\u0007C\u0001\u0018V\t\u0015\u0001\u0004B1\u00012\u0011\u00159\u0016\u00021\u0001&\u0003\u0011!(/Z3\u0002\u0015UsG.\u001b4uC\ndW\r\u0005\u0002'\u0017M\u00191bF.\u0011\u0005\u0019b\u0016BA/?\u0005m\u0019F/\u00198eCJ$WK\u001c7jMR\f'\r\\3J]N$\u0018M\\2fgR\t\u0011,\u0006\u0002aGR\u0011\u0011\r\u001a\t\u0004M!\u0011\u0007C\u0001\u0018d\t\u0015\u0001TB1\u00012\u0011\u0015)W\u00021\u0001g\u0003\t\u0001h\r\u0005\u0003\u0019O\u0016\u0012\u0017B\u00015\u0014\u0005=\u0001\u0016M\u001d;jC24UO\\2uS>t\u0007C\u00016l\u001b\u0005y\u0011B\u00017\u0010\u0005!)f.\u001b<feN,\u0007")
public interface Liftables {
    public Liftables$Liftable$ Liftable();

    public Liftables$Unliftable$ Unliftable();

    public static void $init$(Liftables $this) {
    }

    public interface Liftable<T> {
        public Trees.TreeApi apply(T var1);
    }

    public interface Unliftable<T> {
        public Option<T> unapply(Trees.TreeApi var1);
    }
}

