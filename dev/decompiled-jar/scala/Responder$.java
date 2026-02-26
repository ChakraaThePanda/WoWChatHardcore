/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Responder;
import scala.Serializable;
import scala.Some;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;

public final class Responder$
implements Serializable {
    public static Responder$ MODULE$;

    static {
        new Responder$();
    }

    public <A> Responder<A> constant(A x) {
        return new Responder<A>(x){
            private final Object x$1;

            public void respond(Function1<A, BoxedUnit> k) {
                k.apply(this.x$1);
            }
            {
                this.x$1 = x$1;
            }
        };
    }

    public <A> boolean exec(Function0<BoxedUnit> x) {
        x.apply$mcV$sp();
        return true;
    }

    public <A> Option<A> run(Responder<A> r) {
        ObjectRef<None$> result2 = ObjectRef.create(None$.MODULE$);
        r.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            result2.elem = new Some<Object>(x);
            return BoxedUnit.UNIT;
        });
        return (Option)result2.elem;
    }

    public <A> Responder<Nothing$> loop(Responder<BoxedUnit> r) {
        return r.flatMap((Function1<BoxedUnit, Responder> & java.io.Serializable & Serializable)_ -> MODULE$.loop(r).map((Function1<Nothing$, Nothing$> & java.io.Serializable & Serializable)y -> y));
    }

    public <A> Responder<BoxedUnit> loopWhile(Function0<Object> cond, Responder<BoxedUnit> r) {
        if (cond.apply$mcZ$sp()) {
            return r.flatMap((Function1<BoxedUnit, Responder> & java.io.Serializable & Serializable)_ -> MODULE$.loopWhile(cond, r).map((Function1<BoxedUnit, Object> & java.io.Serializable & Serializable)y -> {
                Responder$.$anonfun$loopWhile$2(y);
                return BoxedUnit.UNIT;
            }));
        }
        return this.constant(BoxedUnit.UNIT);
    }

    private Object readResolve() {
        return MODULE$;
    }

    public static final /* synthetic */ void $anonfun$loopWhile$2(BoxedUnit y) {
    }

    private Responder$() {
        MODULE$ = this;
    }
}

