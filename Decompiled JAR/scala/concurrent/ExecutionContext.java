/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import scala.Function1;
import scala.Option;
import scala.Option$;
import scala.Serializable;
import scala.concurrent.ExecutionContext$;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.ExecutionContextExecutorService;
import scala.concurrent.impl.ExecutionContextImpl;
import scala.concurrent.impl.ExecutionContextImpl$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u0005uca\u0002\n\u0014!\u0003\r\t\u0001\u0007\u0005\u0006;\u0001!\tA\b\u0005\u0006E\u00011\ta\t\u0005\u0006]\u00011\ta\f\u0005\u0006Q\u0002!\t![\u0004\u0006{NA\tA \u0004\u0006%MA\ta \u0005\b\u0003\u00031A\u0011AA\u0002\u0011\u001d\t)A\u0002C\u0001\u0003\u000f9q!a\u0004\u0007\u0011\u0003\t\tBB\u0004\u0002\u0016\u0019A\t!a\u0006\t\u000f\u0005\u0005!\u0002\"\u0001\u0002\u001a!Q\u0011Q\u0001\u0006\t\u0006\u0004%\u0019!a\u0007\t\u000f\u0005ua\u0001\"\u0001\u0002 !9\u0011Q\u0004\u0004\u0005\u0002\u0005\r\u0003bBA$\r\u0011\u0005\u0011\u0011\n\u0005\b\u0003\u000f2A\u0011AA+\u0011\u001d\tIF\u0002C\u0001\u00037\u0012\u0001#\u0012=fGV$\u0018n\u001c8D_:$X\r\u001f;\u000b\u0005Q)\u0012AC2p]\u000e,(O]3oi*\ta#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001I\u0002C\u0001\u000e\u001c\u001b\u0005)\u0012B\u0001\u000f\u0016\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012a\b\t\u00035\u0001J!!I\u000b\u0003\tUs\u0017\u000e^\u0001\bKb,7-\u001e;f)\tyB\u0005C\u0003&\u0005\u0001\u0007a%\u0001\u0005sk:t\u0017M\u00197f!\t9C&D\u0001)\u0015\tI#&\u0001\u0003mC:<'\"A\u0016\u0002\t)\fg/Y\u0005\u0003[!\u0012\u0001BU;o]\u0006\u0014G.Z\u0001\u000ee\u0016\u0004xN\u001d;GC&dWO]3\u0015\u0005}\u0001\u0004\"B\u0019\u0004\u0001\u0004\u0011\u0014!B2bkN,\u0007CA\u001a<\u001d\t!\u0014H\u0004\u00026q5\taG\u0003\u00028/\u00051AH]8pizJ\u0011AF\u0005\u0003uU\tq\u0001]1dW\u0006<W-\u0003\u0002={\tIA\u000b\u001b:po\u0006\u0014G.\u001a\u0006\u0003uUAC\u0001M C=B\u0011!\u0004Q\u0005\u0003\u0003V\u0011a\u0002Z3qe\u0016\u001c\u0017\r^3e\u001d\u0006lW-\r\u0003 \u0007\u001aS\u0006C\u0001\u000eE\u0013\t)UC\u0001\u0004Ts6\u0014w\u000e\\\u0019\u0006G\u001dSek\u0013\u000b\u0003\u0007\"CQ!S\fA\u00029\u000bAA\\1nK&\u00111\nT\u0001\u0006CB\u0004H.\u001f\u0006\u0003\u001bV\taaU=nE>d\u0007CA(T\u001d\t\u0001\u0016\u000b\u0005\u00026+%\u0011!+F\u0001\u0007!J,G-\u001a4\n\u0005Q+&AB*ue&twM\u0003\u0002S+E*1e\u0016-Z\u001b:\u0011A\u0007W\u0005\u0003\u001bV\tD\u0001\n\u001b9-E\u001aQe\u0017/\u0010\u0003q\u000b\u0013!X\u0001\u0002iF*1ET0dA&\u0011\u0001-Y\u0001\u001cI1,7o]5oSR$sM]3bi\u0016\u0014H\u0005Z3gCVdG\u000f\n\u001a\u000b\u0005\t,\u0012A\u00043faJ,7-\u0019;fI:\u000bW.Z\u0019\u0006G\u0011,gM\u0019\b\u00035\u0015L!AY\u000b2\t\tRRc\u001a\u0002\u0006g\u000e\fG.Y\u0001\baJ,\u0007/\u0019:f)\u0005Q\u0007CA6\u0001\u001b\u0005\u0019\u0002\u0006\u0002\u0003naJ\u0004\"A\u00078\n\u0005=,\"A\u00033faJ,7-\u0019;fI\u0006\n\u0011/\u0001\u0019qe\u0016\u0004\u0018M]1uS>t\u0007e\u001c4!\u000bb,7-\u001e;j_:\u001cuN\u001c;fqR\u001c\be^5mY\u0002\u0012W\r\t:f[>4X\rZ\u0011\u0002g\u00061!GL\u00193]AB3\u0001A;|!\t1\u00180D\u0001x\u0015\tAX#\u0001\u0006b]:|G/\u0019;j_:L!A_<\u0003!%l\u0007\u000f\\5dSRtu\u000e\u001e$pk:$\u0017%\u0001?\u0002\u0007w\u001c\u0015M\u001c8pi\u00022\u0017N\u001c3!C:\u0004\u0013.\u001c9mS\u000eLG\u000fI#yK\u000e,H/[8o\u0007>tG/\u001a=u]\u0001Jv.\u001e\u0011nS\u001eDG\u000f\t9bgNT\u0011M\u001c\u0011)S6\u0004H.[2ji\u0002*7M\u000f\u0011Fq\u0016\u001cW\u000f^5p]\u000e{g\u000e^3yi&\u0002\u0003/\u0019:b[\u0016$XM\u001d\u0011u_\u0002Jx.\u001e:![\u0016$\bn\u001c3/\u0015)!\u0006.\u001a\u0011Fq\u0016\u001cW\u000f^5p]\u000e{g\u000e^3yi\u0002J7\u000fI;tK\u0012\u0004Co\u001c\u0011d_:4\u0017nZ;sK\u0002Bwn\u001e\u0011b]\u0012\u0004sN\u001c\u0011xQ&\u001c\u0007N\u0003;ie\u0016\fG\r\t9p_2\u001c\bER;ukJ,7\u000fI<jY2\u0004#/\u001e8-AM|\u0007\u0005\u001e5fAM\u0004XmY5gS\u000e\u0004S\t_3dkRLwN\\\"p]R,\u0007\u0010\u001e\u0006uQ\u0006$\b%[:!g\u0016dWm\u0019;fI\u0002J7\u000fI5na>\u0014H/\u00198u])Q\u0011J\u001a\u0011z_V\u0014\b%\u00199qY&\u001c\u0017\r^5p]\u0002\"w.Z:!]>$\b\u0005Z3gS:,\u0007%\u00198!\u000bb,7-\u001e;j_:\u001cuN\u001c;fqR\u0004S\r\\:fo\",'/\u001a\u0017\u000bG>t7/\u001b3fe\u0002*8/\u001b8hAM\u001b\u0017\r\\1(g\u0002:Gn\u001c2bY\u0002*\u00050Z2vi&|gnQ8oi\u0016DH\u000f\t2zA\u0011,g-\u001b8j]\u001eTA\u000f[3!M>dGn\\<j]\u001eT$BC5na2L7-\u001b;!m\u0006d\u0007%Z2;AM\u001c\u0017\r\\1/G>t7-\u001e:sK:$h&\u0012=fGV$\u0018n\u001c8D_:$X\r\u001f;!{\u0001\u001a8-\u00197b]\r|gnY;se\u0016tGOL#yK\u000e,H/[8o\u0007>tG/\u001a=u]\u001ddwNY1m\u0003A)\u00050Z2vi&|gnQ8oi\u0016DH\u000f\u0005\u0002l\rM\u0011a!G\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003y\faa\u001a7pE\u0006dWCAA\u0005!\rY\u00171B\u0005\u0004\u0003\u001b\u0019\"\u0001G#yK\u000e,H/[8o\u0007>tG/\u001a=u\u000bb,7-\u001e;pe\u0006I\u0011*\u001c9mS\u000eLGo\u001d\t\u0004\u0003'QQ\"\u0001\u0004\u0003\u0013%k\u0007\u000f\\5dSR\u001c8C\u0001\u0006\u001a)\t\t\t\"F\u0001k\u0003M1'o\\7Fq\u0016\u001cW\u000f^8s'\u0016\u0014h/[2f)\u0019\t\t#a\n\u0002:A\u00191.a\t\n\u0007\u0005\u00152CA\u0010Fq\u0016\u001cW\u000f^5p]\u000e{g\u000e^3yi\u0016CXmY;u_J\u001cVM\u001d<jG\u0016Dq!!\u000b\u000e\u0001\u0004\tY#A\u0001f!\u0011\ti#!\u000e\u000e\u0005\u0005=\"b\u0001\u000b\u00022)\u0019\u00111\u0007\u0016\u0002\tU$\u0018\u000e\\\u0005\u0005\u0003o\tyCA\bFq\u0016\u001cW\u000f^8s'\u0016\u0014h/[2f\u0011\u001d\tY$\u0004a\u0001\u0003{\t\u0001B]3q_J$XM\u001d\t\u00065\u0005}\"gH\u0005\u0004\u0003\u0003*\"!\u0003$v]\u000e$\u0018n\u001c82)\u0011\t\t#!\u0012\t\u000f\u0005%b\u00021\u0001\u0002,\u0005aaM]8n\u000bb,7-\u001e;peR1\u0011\u0011BA&\u0003'Bq!!\u000b\u0010\u0001\u0004\ti\u0005\u0005\u0003\u0002.\u0005=\u0013\u0002BA)\u0003_\u0011\u0001\"\u0012=fGV$xN\u001d\u0005\b\u0003wy\u0001\u0019AA\u001f)\u0011\tI!a\u0016\t\u000f\u0005%\u0002\u00031\u0001\u0002N\u0005yA-\u001a4bk2$(+\u001a9peR,'/\u0006\u0002\u0002>\u0001")
public interface ExecutionContext {
    public static Function1<Throwable, BoxedUnit> defaultReporter() {
        return ExecutionContext$.MODULE$.defaultReporter();
    }

    public static ExecutionContextExecutor fromExecutor(Executor executor) {
        return ExecutionContext$.MODULE$.fromExecutor(executor);
    }

    public static ExecutionContextExecutor fromExecutor(Executor executor, Function1<Throwable, BoxedUnit> function1) {
        if (ExecutionContext$.MODULE$ == null) {
            throw null;
        }
        if (ExecutionContextImpl$.MODULE$ == null) {
            throw null;
        }
        Option<Executor> option = Option$.MODULE$.apply(executor);
        if (option == null) {
            throw null;
        }
        Option<Executor> fromExecutor_fromExecutor_getOrElse_this = option;
        return new ExecutionContextImpl(fromExecutor_fromExecutor_getOrElse_this.isEmpty() ? ExecutionContextImpl$.$anonfun$fromExecutor$1(function1) : fromExecutor_fromExecutor_getOrElse_this.get(), function1);
    }

    public static ExecutionContextExecutorService fromExecutorService(ExecutorService executorService) {
        return ExecutionContext$.MODULE$.fromExecutorService(executorService);
    }

    public static ExecutionContextExecutorService fromExecutorService(ExecutorService executorService, Function1<Throwable, BoxedUnit> function1) {
        if (ExecutionContext$.MODULE$ == null) {
            throw null;
        }
        if (ExecutionContextImpl$.MODULE$ == null) {
            throw null;
        }
        return new ExecutionContextExecutorService(executorService, function1){

            private final ExecutorService asExecutorService() {
                return (ExecutorService)this.executor();
            }

            public void execute(Runnable command) {
                this.executor().execute(command);
            }

            public void shutdown() {
                this.asExecutorService().shutdown();
            }

            public List<Runnable> shutdownNow() {
                return this.asExecutorService().shutdownNow();
            }

            public boolean isShutdown() {
                return this.asExecutorService().isShutdown();
            }

            public boolean isTerminated() {
                return this.asExecutorService().isTerminated();
            }

            public boolean awaitTermination(long l, TimeUnit timeUnit) {
                return this.asExecutorService().awaitTermination(l, timeUnit);
            }

            public <T> Future<T> submit(Callable<T> callable) {
                return this.asExecutorService().submit(callable);
            }

            public <T> Future<T> submit(Runnable runnable2, T t) {
                return this.asExecutorService().submit(runnable2, t);
            }

            public Future<?> submit(Runnable runnable2) {
                return this.asExecutorService().submit(runnable2);
            }

            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> callables) {
                return this.asExecutorService().invokeAll(callables);
            }

            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> callables, long l, TimeUnit timeUnit) {
                return this.asExecutorService().invokeAll(callables, l, timeUnit);
            }

            public <T> T invokeAny(Collection<? extends Callable<T>> callables) {
                return this.asExecutorService().invokeAny(callables);
            }

            public <T> T invokeAny(Collection<? extends Callable<T>> callables, long l, TimeUnit timeUnit) {
                return this.asExecutorService().invokeAny(callables, l, timeUnit);
            }
            {
                void getOrElse_default;
                Option<ExecutorService> option = Option$.MODULE$.apply(es$1);
                Serializable serializable = new Serializable(reporter$3){
                    public static final long serialVersionUID = 0L;
                    private final Function1 reporter$3;

                    public final ExecutorService apply() {
                        return ExecutionContextImpl$.MODULE$.createDefaultExecutorService(this.reporter$3);
                    }
                    {
                        this.reporter$3 = reporter$3;
                    }
                };
                if (option == null) {
                    throw null;
                }
                Option<ExecutorService> getOrElse_this = option;
                super((Executor)(getOrElse_this.isEmpty() ? getOrElse_default.apply() : getOrElse_this.get()), reporter$3);
            }
        };
    }

    public static ExecutionContextExecutor global() {
        return ExecutionContext$.MODULE$.global();
    }

    public void execute(Runnable var1);

    public void reportFailure(Throwable var1);

    public static /* synthetic */ ExecutionContext prepare$(ExecutionContext $this) {
        return $this.prepare();
    }

    default public ExecutionContext prepare() {
        return this;
    }

    public static void $init$(ExecutionContext $this) {
    }
}

