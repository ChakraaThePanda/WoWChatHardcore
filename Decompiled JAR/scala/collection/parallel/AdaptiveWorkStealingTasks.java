/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function1;
import scala.None$;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Serializable;
import scala.Some;
import scala.collection.IterableLike;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.parallel.Task;
import scala.collection.parallel.Tasks;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.ObjectRef;

@ScalaSignature(bytes="\u0006\u0001\u001d4qAD\b\u0011\u0002\u0007\u0005a\u0003C\u0003 \u0001\u0011\u0005\u0001EB\u0004%\u0001A\u0005\u0019\u0011A\u0013\t\u000b}\u0011A\u0011\u0001\u0011\t\u000fa\u0012\u0001\u0019!C\u0001s!9qH\u0001a\u0001\n\u0003\u0001\u0005bB\"\u0003\u0001\u0004%\t\u0001\u0012\u0005\b\u0013\n\u0001\r\u0011\"\u0001K\u0011\u0015a%A\"\u0001N\u0011\u0015)&\u0001\"\u0001!\u0011\u00151&\u0001\"\u0001!\u0011\u00159&\u0001\"\u0001Y\u0011\u0015I&\u0001\"\u0001!\u0011\u0015Q\u0006A\"\u0005\\\u0005e\tE-\u00199uSZ,wk\u001c:l'R,\u0017\r\\5oOR\u000b7o[:\u000b\u0005A\t\u0012\u0001\u00039be\u0006dG.\u001a7\u000b\u0005I\u0019\u0012AC2pY2,7\r^5p]*\tA#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u000192\u0004\u0005\u0002\u001935\t1#\u0003\u0002\u001b'\t1\u0011I\\=SK\u001a\u0004\"\u0001H\u000f\u000e\u0003=I!AH\b\u0003\u000bQ\u000b7o[:\u0002\r\u0011Jg.\u001b;%)\u0005\t\u0003C\u0001\r#\u0013\t\u00193C\u0001\u0003V]&$(aC,sCB\u0004X\r\u001a+bg.,2A\n\u00177'\r\u0011qc\n\t\u0005Q%RS'D\u0001\u0001\u0013\t!S\u0004\u0005\u0002,Y1\u0001A!B\u0017\u0003\u0005\u0004q#!\u0001*\u0012\u0005=\u0012\u0004C\u0001\r1\u0013\t\t4CA\u0004O_RD\u0017N\\4\u0011\u0005a\u0019\u0014B\u0001\u001b\u0014\u0005\r\te.\u001f\t\u0003WY\"Qa\u000e\u0002C\u00029\u0012!\u0001\u00169\u0002\t9,\u0007\u0010^\u000b\u0002uA!\u0001F\u0001\u00166Q\t!A\b\u0005\u0002\u0019{%\u0011ah\u0005\u0002\tm>d\u0017\r^5mK\u0006Aa.\u001a=u?\u0012*\u0017\u000f\u0006\u0002\"\u0003\"9!)BA\u0001\u0002\u0004Q\u0014a\u0001=%c\u0005i1\u000f[8vY\u0012<\u0016-\u001b;G_J,\u0012!\u0012\t\u00031\u0019K!aR\n\u0003\u000f\t{w\u000e\\3b]\"\u0012a\u0001P\u0001\u0012g\"|W\u000f\u001c3XC&$hi\u001c:`I\u0015\fHCA\u0011L\u0011\u001d\u0011u!!AA\u0002\u0015\u000bQa\u001d9mSR,\u0012A\u0014\t\u0004\u001fJSdB\u0001\rQ\u0013\t\t6#A\u0004qC\u000e\\\u0017mZ3\n\u0005M#&aA*fc*\u0011\u0011kE\u0001\bG>l\u0007/\u001e;f\u0003!Ig\u000e^3s]\u0006d\u0017!D:qC^t7+\u001e2uCN\\7\u000fF\u0001;\u0003)\u0001(/\u001b8u\u0007\"\f\u0017N\\\u0001\u000f]\u0016<xK]1qa\u0016$G+Y:l+\rav,\u0019\u000b\u0003;\n\u0004B\u0001\u000b\u0002_AB\u00111f\u0018\u0003\u0006[5\u0011\rA\f\t\u0003W\u0005$QaN\u0007C\u00029BQaY\u0007A\u0002\u0011\f\u0011A\u0019\t\u00059\u0015t\u0006-\u0003\u0002g\u001f\t!A+Y:l\u0001")
public interface AdaptiveWorkStealingTasks
extends Tasks {
    public <R, Tp> WrappedTask<R, Tp> newWrappedTask(Task<R, Tp> var1);

    public static void $init$(AdaptiveWorkStealingTasks $this) {
    }

    public interface WrappedTask<R, Tp>
    extends Tasks.WrappedTask<R, Tp> {
        public WrappedTask<R, Tp> next();

        public void next_$eq(WrappedTask<R, Tp> var1);

        public boolean shouldWaitFor();

        public void shouldWaitFor_$eq(boolean var1);

        @Override
        public Seq<WrappedTask<R, Tp>> split();

        public static /* synthetic */ void compute$(WrappedTask $this) {
            $this.compute();
        }

        @Override
        default public void compute() {
            if (this.body().shouldSplitFurther()) {
                this.internal();
                this.release();
                return;
            }
            this.body().tryLeaf(None$.MODULE$);
            this.release();
        }

        public static /* synthetic */ void internal$(WrappedTask $this) {
            $this.internal();
        }

        default public void internal() {
            WrappedTask<R, Tp> last = this.spawnSubtasks();
            last.body().tryLeaf(None$.MODULE$);
            last.release();
            this.body().result_$eq(last.body().result());
            this.body().throwable_$eq(last.body().throwable());
            while (last.next() != null) {
                if ((last = last.next()).tryCancel()) {
                    last.body().tryLeaf(new Some(this.body().result()));
                    last.release();
                } else {
                    last.sync();
                }
                this.body().tryMerge(last.body().repr());
            }
        }

        public static /* synthetic */ WrappedTask spawnSubtasks$(WrappedTask $this) {
            return $this.spawnSubtasks();
        }

        /*
         * WARNING - void declaration
         */
        default public WrappedTask<R, Tp> spawnSubtasks() {
            void var2_2;
            ObjectRef<Object> last = ObjectRef.create(null);
            WrappedTask head = this;
            do {
                Seq<WrappedTask<R, Tp>> subtasks = head.split();
                head = (WrappedTask)subtasks.head();
                ((IterableLike)((SeqLike)subtasks.tail()).reverse()).foreach((Function1<WrappedTask, Object> & java.io.Serializable & Serializable)t -> {
                    WrappedTask.$anonfun$spawnSubtasks$1(last, t);
                    return BoxedUnit.UNIT;
                });
            } while (head.body().shouldSplitFurther());
            head.next_$eq((WrappedTask)last.elem);
            return var2_2;
        }

        public static /* synthetic */ void printChain$(WrappedTask $this) {
            $this.printChain();
        }

        default public void printChain() {
            String chain = "chain: ";
            for (WrappedTask<R, Tp> curr = this; curr != null; curr = curr.next()) {
                chain = new StringBuilder(0).append(chain).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(curr), " ---> ")).toString();
            }
            Predef$.MODULE$.println(chain);
        }

        public /* synthetic */ AdaptiveWorkStealingTasks scala$collection$parallel$AdaptiveWorkStealingTasks$WrappedTask$$$outer();

        public static /* synthetic */ void $anonfun$spawnSubtasks$1(ObjectRef last$1, WrappedTask t) {
            t.next_$eq((WrappedTask)last$1.elem);
            last$1.elem = t;
            t.start();
        }

        public static void $init$(WrappedTask $this) {
            $this.next_$eq(null);
            $this.shouldWaitFor_$eq(true);
        }
    }
}

