/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.Responder$;
import scala.Serializable;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005ur!B\t\u0013\u0011\u0003)b!B\f\u0013\u0011\u0003A\u0002\"B\u0010\u0002\t\u0003\u0001\u0003\"B\u0011\u0002\t\u0003\u0011\u0003\"B9\u0002\t\u0003\u0011\b\"B=\u0002\t\u0003Q\bbBA\u0005\u0003\u0011\u0005\u00111\u0002\u0005\b\u0003/\tA\u0011AA\r\u0011%\tI#AA\u0001\n\u0013\tYCB\u0003\u0018%\u0005\u0005Q\u0005C\u0003 \u0013\u0011\u0005q\u0005C\u00035\u0013\u0019\u0005Q\u0007C\u0003?\u0013\u0011\u0005q\bC\u0003B\u0013\u0011\u0005!\tC\u0003L\u0013\u0011\u0005A\nC\u0003T\u0013\u0011\u0005A\u000bC\u0003\\\u0013\u0011\u0005C,A\u0005SKN\u0004xN\u001c3fe*\t1#A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005Y\tQ\"\u0001\n\u0003\u0013I+7\u000f]8oI\u0016\u00148cA\u0001\u001a9A\u0011aCG\u0005\u00037I\u0011a!\u00118z%\u00164\u0007C\u0001\f\u001e\u0013\tq\"C\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0004=S:LGO\u0010\u000b\u0002+\u0005A1m\u001c8ti\u0006tG/\u0006\u0002$]R\u0011Ae\u001c\t\u0004-%iWC\u0001\u0014,'\rI\u0011\u0004\b\u000b\u0002QA\u0019a#C\u0015\u0011\u0005)ZC\u0002\u0001\u0003\u0007Y%!)\u0019A\u0017\u0003\u0003\u0005\u000b\"AL\u0019\u0011\u0005Yy\u0013B\u0001\u0019\u0013\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"A\u0006\u001a\n\u0005M\u0012\"aA!os\u00069!/Z:q_:$GC\u0001\u001c:!\t1r'\u0003\u00029%\t!QK\\5u\u0011\u0015Q4\u00021\u0001<\u0003\u0005Y\u0007\u0003\u0002\f=SYJ!!\u0010\n\u0003\u0013\u0019+hn\u0019;j_:\f\u0014a\u00024pe\u0016\f7\r\u001b\u000b\u0003m\u0001CQA\u000f\u0007A\u0002m\n1!\\1q+\t\u0019e\t\u0006\u0002E\u0011B\u0019a#C#\u0011\u0005)2E!B$\u000e\u0005\u0004i#!\u0001\"\t\u000b%k\u0001\u0019\u0001&\u0002\u0003\u0019\u0004BA\u0006\u001f*\u000b\u00069a\r\\1u\u001b\u0006\u0004XCA'Q)\tq\u0015\u000bE\u0002\u0017\u0013=\u0003\"A\u000b)\u0005\u000b\u001ds!\u0019A\u0017\t\u000b%s\u0001\u0019\u0001*\u0011\tYa\u0014FT\u0001\u0007M&dG/\u001a:\u0015\u0005!*\u0006\"\u0002,\u0010\u0001\u00049\u0016!\u00019\u0011\tYa\u0014\u0006\u0017\t\u0003-eK!A\u0017\n\u0003\u000f\t{w\u000e\\3b]\u0006AAo\\*ue&tw\rF\u0001^!\tq6-D\u0001`\u0015\t\u0001\u0017-\u0001\u0003mC:<'\"\u00012\u0002\t)\fg/Y\u0005\u0003I~\u0013aa\u0015;sS:<\u0007\u0006B\u0005gS.\u0004\"AF4\n\u0005!\u0014\"A\u00033faJ,7-\u0019;fI\u0006\n!.\u0001\u000euQ&\u001c\be\u00197bgN\u0004s/\u001b7mA\t,\u0007E]3n_Z,G-I\u0001m\u0003\u0019\u0011d&M\u0019/aA\u0011!F\u001c\u0003\u0006Y\r\u0011\r!\f\u0005\u0006a\u000e\u0001\r!\\\u0001\u0002q\u0006!Q\r_3d+\t\u0019\b\u0010\u0006\u0002Yi\"1\u0001\u000f\u0002CA\u0002U\u00042A\u0006<7\u0013\t9(C\u0001\u0005=Eft\u0017-\\3?\t\u0015aCA1\u0001.\u0003\r\u0011XO\\\u000b\u0004w\u0006\u0005Ac\u0001?\u0002\u0004A\u0019a#`@\n\u0005y\u0014\"AB(qi&|g\u000eE\u0002+\u0003\u0003!Q\u0001L\u0003C\u00025Bq!!\u0002\u0006\u0001\u0004\t9!A\u0001s!\r1\u0012b`\u0001\u0005Y>|\u0007/\u0006\u0003\u0002\u000e\u0005UA\u0003BA\b\u0003#\u00012AF\u0005/\u0011\u001d\t)A\u0002a\u0001\u0003'\u00012AF\u00057\t\u0015acA1\u0001.\u0003%awn\u001c9XQ&dW-\u0006\u0003\u0002\u001c\u0005\u001dB\u0003BA\u000f\u0003C!B!a\u0005\u0002 !9\u0011QA\u0004A\u0002\u0005M\u0001\u0002CA\u0012\u000f\u0011\u0005\r!!\n\u0002\t\r|g\u000e\u001a\t\u0004-YDF!\u0002\u0017\b\u0005\u0004i\u0013a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"!!\f\u0011\u0007y\u000by#C\u0002\u00022}\u0013aa\u00142kK\u000e$\b&B\u0001g\u0003kY\u0017EAA\u001c\u0003m!\b.[:!_\nTWm\u0019;!o&dG\u000e\t2fAI,Wn\u001c<fI\"\"\u0011AZ5lQ\u0015\u0001a-!\u000el\u0001")
public abstract class Responder<A>
implements Serializable {
    public static <A> Responder<BoxedUnit> loopWhile(Function0<Object> function0, Responder<BoxedUnit> responder) {
        return Responder$.MODULE$.loopWhile(function0, responder);
    }

    public static <A> Responder<Nothing$> loop(Responder<BoxedUnit> responder) {
        return Responder$.MODULE$.loop(responder);
    }

    public static <A> Option<A> run(Responder<A> responder) {
        return Responder$.MODULE$.run(responder);
    }

    public static <A> boolean exec(Function0<BoxedUnit> function0) {
        if (Responder$.MODULE$ == null) {
            throw null;
        }
        function0.apply$mcV$sp();
        return true;
    }

    public static <A> Responder<A> constant(A a) {
        return Responder$.MODULE$.constant(a);
    }

    public abstract void respond(Function1<A, BoxedUnit> var1);

    public void foreach(Function1<A, BoxedUnit> k) {
        this.respond(k);
    }

    public <B> Responder<B> map(Function1<A, B> f) {
        return new Responder<B>(this, f){
            private final /* synthetic */ Responder $outer;
            private final Function1 f$1;

            public void respond(Function1<B, BoxedUnit> k) {
                this.$outer.respond((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
                    k.apply($this.f$1.apply(x));
                    return BoxedUnit.UNIT;
                });
            }

            public static final /* synthetic */ void $anonfun$respond$1($anon$2 $this, Function1 k$1, Object x) {
                k$1.apply($this.f$1.apply(x));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.f$1 = f$1;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$respond$1$adapted(scala.Responder$$anon$2 scala.Function1 java.lang.Object )}, serializedLambda);
            }
        };
    }

    public <B> Responder<B> flatMap(Function1<A, Responder<B>> f) {
        return new Responder<B>(this, f){
            private final /* synthetic */ Responder $outer;
            private final Function1 f$2;

            public void respond(Function1<B, BoxedUnit> k) {
                this.$outer.respond((Function1<Object, Object> & java.io.Serializable & Serializable)(A x) -> {
                    ((Responder)$this.f$2.apply(x)).respond(k);
                    return BoxedUnit.UNIT;
                });
            }

            public static final /* synthetic */ void $anonfun$respond$2($anon$3 $this, Function1 k$2, Object x) {
                ((Responder)$this.f$2.apply(x)).respond(k$2);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.f$2 = f$2;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$respond$2$adapted(scala.Responder$$anon$3 scala.Function1 java.lang.Object )}, serializedLambda);
            }
        };
    }

    public Responder<A> filter(Function1<A, Object> p) {
        return new Responder<A>(this, p){
            private final /* synthetic */ Responder $outer;
            private final Function1 p$1;

            public void respond(Function1<A, BoxedUnit> k) {
                this.$outer.respond((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                    $anon$4.$anonfun$respond$3(this, k, x);
                    return BoxedUnit.UNIT;
                });
            }

            public static final /* synthetic */ void $anonfun$respond$3($anon$4 $this, Function1 k$3, Object x) {
                if (BoxesRunTime.unboxToBoolean($this.p$1.apply(x))) {
                    k$3.apply(x);
                }
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.p$1 = p$1;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$respond$3$adapted(scala.Responder$$anon$4 scala.Function1 java.lang.Object )}, serializedLambda);
            }
        };
    }

    public String toString() {
        return "Responder";
    }
}

