/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.collection.Parallel;
import scala.collection.generic.Sizing;
import scala.collection.mutable.Builder;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.package$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00194q!\u0003\u0006\u0011\u0002\u0007\u0005\u0011\u0003C\u00036\u0001\u0011\u0005a\u0007C\u0004;\u0001\u0001\u0007I\u0011A\u001e\t\u000f!\u0003\u0001\u0019!C\u0001\u0013\")A\n\u0001C\u0001w!)Q\n\u0001C\u0001\u001d\")\u0011\u000b\u0001D\u0001%\")q\f\u0001C\u0001A\")A\r\u0001C\u0001K\nA1i\\7cS:,'O\u0003\u0002\f\u0019\u0005A\u0001/\u0019:bY2,GN\u0003\u0002\u000e\u001d\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003=\tQa]2bY\u0006\u001c\u0001!F\u0002\u0013?%\u001aR\u0001A\n\u0018WE\u0002\"\u0001F\u000b\u000e\u00039I!A\u0006\b\u0003\r\u0005s\u0017PU3g!\u0011A2$\b\u0015\u000e\u0003eQ!A\u0007\u0007\u0002\u000f5,H/\u00192mK&\u0011A$\u0007\u0002\b\u0005VLG\u000eZ3s!\tqr\u0004\u0004\u0001\u0005\r\u0001\u0002\u0001R1\u0001\"\u0005\u0011)E.Z7\u0012\u0005\t*\u0003C\u0001\u000b$\u0013\t!cBA\u0004O_RD\u0017N\\4\u0011\u0005Q1\u0013BA\u0014\u000f\u0005\r\te.\u001f\t\u0003=%\"aA\u000b\u0001\u0005\u0006\u0004\t#A\u0001+p!\tas&D\u0001.\u0015\tqC\"A\u0004hK:,'/[2\n\u0005Aj#AB*ju&tw\r\u0005\u00023g5\tA\"\u0003\u00025\u0019\tA\u0001+\u0019:bY2,G.\u0001\u0004%S:LG\u000f\n\u000b\u0002oA\u0011A\u0003O\u0005\u0003s9\u0011A!\u00168ji\u0006!rlY8nE&tWM\u001d+bg.\u001cV\u000f\u001d9peR,\u0012\u0001\u0010\t\u0003{yj\u0011AC\u0005\u0003\u007f)\u00111\u0002V1tWN+\b\u000f]8si\"\u0012!!\u0011\t\u0003)\tK!a\u0011\b\u0003\u0011Y|G.\u0019;jY\u0016D#AA#\u0011\u0005Q1\u0015BA$\u000f\u0005%!(/\u00198tS\u0016tG/\u0001\r`G>l'-\u001b8feR\u000b7o[*vaB|'\u000f^0%KF$\"a\u000e&\t\u000f-\u001b\u0011\u0011!a\u0001y\u0005\u0019\u0001\u0010J\u0019\u0002'\r|WNY5oKJ$\u0016m]6TkB\u0004xN\u001d;\u0002/\r|WNY5oKJ$\u0016m]6TkB\u0004xN\u001d;`I\u0015\fHCA\u001cP\u0011\u0015\u0001V\u00011\u0001=\u0003\r\u0019Go]\u0001\bG>l'-\u001b8f+\r\u0019fK\u0017\u000b\u0003)v\u0003B!\u0010\u0001V3B\u0011aD\u0016\u0003\u0006/\u001a\u0011\r\u0001\u0017\u0002\u0002\u001dF\u0011!%\b\t\u0003=i#Qa\u0017\u0004C\u0002q\u0013QAT3x)>\f\"\u0001K\u0013\t\u000by3\u0001\u0019\u0001+\u0002\u000b=$\b.\u001a:\u0002\u0017\r\fgNQ3TQ\u0006\u0014X\rZ\u000b\u0002CB\u0011ACY\u0005\u0003G:\u0011qAQ8pY\u0016\fg.A\u000bsKN,H\u000e^,ji\"$\u0016m]6TkB\u0004xN\u001d;\u0016\u0003!\u0002")
public interface Combiner<Elem, To>
extends Builder<Elem, To>,
Sizing,
Parallel {
    public TaskSupport _combinerTaskSupport();

    public void _combinerTaskSupport_$eq(TaskSupport var1);

    public static /* synthetic */ TaskSupport combinerTaskSupport$(Combiner $this) {
        return $this.combinerTaskSupport();
    }

    /*
     * WARNING - void declaration
     */
    default public TaskSupport combinerTaskSupport() {
        void var1_1;
        TaskSupport cts = this._combinerTaskSupport();
        if (cts == null) {
            this._combinerTaskSupport_$eq(package$.MODULE$.defaultTaskSupport());
            return package$.MODULE$.defaultTaskSupport();
        }
        return var1_1;
    }

    public static /* synthetic */ void combinerTaskSupport_$eq$(Combiner $this, TaskSupport cts) {
        $this.combinerTaskSupport_$eq(cts);
    }

    default public void combinerTaskSupport_$eq(TaskSupport cts) {
        this._combinerTaskSupport_$eq(cts);
    }

    public <N extends Elem, NewTo> Combiner<N, NewTo> combine(Combiner<N, NewTo> var1);

    public static /* synthetic */ boolean canBeShared$(Combiner $this) {
        return $this.canBeShared();
    }

    default public boolean canBeShared() {
        return false;
    }

    public static /* synthetic */ Object resultWithTaskSupport$(Combiner $this) {
        return $this.resultWithTaskSupport();
    }

    default public To resultWithTaskSupport() {
        Object res = this.result();
        return package$.MODULE$.setTaskSupport(res, this.combinerTaskSupport());
    }

    public static void $init$(Combiner $this) {
        $this._combinerTaskSupport_$eq(package$.MODULE$.defaultTaskSupport());
    }
}

