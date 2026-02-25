/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function0;
import scala.Function1;
import scala.collection.generic.CanCombineFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001E3qa\u0002\u0005\u0011\u0002\u0007\u0005q\u0002C\u0003\u0016\u0001\u0011\u0005aCB\u0004\u001b\u0001A\u0005\u0019\u0013A\u000e\t\u000bu\u0011a\u0011\u0001\u0010\t\u000b=\u0002a\u0011\u0001\u0019\t\u000bQ\u0002a\u0011A\u001b\t\u000b\u0015\u0003a\u0011\u0001$\u0003\u0015\u0019\u000b7\r^8ss>\u00038O\u0003\u0002\n\u0015\u0005A\u0001/\u0019:bY2,GN\u0003\u0002\f\u0019\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u00035\tQa]2bY\u0006\u001c\u0001!\u0006\u0003\u0011{\u0001\u001b5C\u0001\u0001\u0012!\t\u00112#D\u0001\r\u0013\t!BB\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003]\u0001\"A\u0005\r\n\u0005ea!\u0001B+oSR\u0014\u0011b\u0014;iKJ<\u0018n]3\u0016\u0005q\t3C\u0001\u0002\u0012\u0003%yG\u000f[3so&\u001cX\r\u0006\u0002 UA\u0011\u0001%\t\u0007\u0001\t\u0015\u0011#A1\u0001$\u0005\u0005\u0011\u0016C\u0001\u0013(!\t\u0011R%\u0003\u0002'\u0019\t9aj\u001c;iS:<\u0007C\u0001\n)\u0013\tICBA\u0002B]fDaaK\u0002\u0005\u0002\u0004a\u0013a\u00028pi\n|G-\u001f\t\u0004%5z\u0012B\u0001\u0018\r\u0005!a$-\u001f8b[\u0016t\u0014AC5t!\u0006\u0014\u0018\r\u001c7fYV\t\u0011\u0007\u0005\u0002\u0013e%\u00111\u0007\u0004\u0002\b\u0005>|G.Z1o\u0003)\t7\u000fU1sC2dW\r\\\u000b\u0002mA)qG\u000f\u001f@\u00056\t\u0001H\u0003\u0002:\u0015\u00059q-\u001a8fe&\u001c\u0017BA\u001e9\u00059\u0019\u0015M\\\"p[\nLg.\u001a$s_6\u0004\"\u0001I\u001f\u0005\u000by\u0002!\u0019A\u0012\u0003\t\u0019\u0013x.\u001c\t\u0003A\u0001#Q!\u0011\u0001C\u0002\r\u0012A!\u00127f[B\u0011\u0001e\u0011\u0003\u0006\t\u0002\u0011\ra\t\u0002\u0003)>\f!\"\u001b4QCJ\fG\u000e\\3m+\t95\n\u0006\u0002I\u0019B\u0019\u0011J\u0001&\u000e\u0003\u0001\u0001\"\u0001I&\u0005\u000b\t2!\u0019A\u0012\t\u000b53\u0001\u0019\u0001(\u0002\r%\u001c(m\u001c3z!\u0011\u0011rJ\u000e&\n\u0005Ac!!\u0003$v]\u000e$\u0018n\u001c82\u0001")
public interface FactoryOps<From, Elem, To> {
    public boolean isParallel();

    public CanCombineFrom<From, Elem, To> asParallel();

    public <R> Otherwise<R> ifParallel(Function1<CanCombineFrom<From, Elem, To>, R> var1);

    public static void $init$(FactoryOps $this) {
    }

    public interface Otherwise<R> {
        public R otherwise(Function0<R> var1);
    }
}

