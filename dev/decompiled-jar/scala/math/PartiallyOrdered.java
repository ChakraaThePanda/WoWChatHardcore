/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import scala.Function1;
import scala.Option;
import scala.Some;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001%4qa\u0002\u0005\u0011\u0002\u0007\u0005Q\u0002C\u0003\u0014\u0001\u0011\u0005A\u0003C\u0003\u0019\u0001\u0019\u0005\u0011\u0004C\u0003;\u0001\u0011\u00051\bC\u0003I\u0001\u0011\u0005\u0011\nC\u0003T\u0001\u0011\u0005A\u000bC\u0003_\u0001\u0011\u0005qL\u0001\tQCJ$\u0018.\u00197ms>\u0013H-\u001a:fI*\u0011\u0011BC\u0001\u0005[\u0006$\bNC\u0001\f\u0003\u0015\u00198-\u00197b\u0007\u0001)\"AD\u0017\u0014\u0005\u0001y\u0001C\u0001\t\u0012\u001b\u0005Q\u0011B\u0001\n\u000b\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012!\u0006\t\u0003!YI!a\u0006\u0006\u0003\tUs\u0017\u000e^\u0001\riJL8i\\7qCJ,Gk\\\u000b\u00035%\"\"a\u0007\u001d\u0015\u0005q\u0011\u0003c\u0001\t\u001e?%\u0011aD\u0003\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u0005A\u0001\u0013BA\u0011\u000b\u0005\rIe\u000e\u001e\u0005\bG\t\t\t\u0011q\u0001%\u0003))g/\u001b3f]\u000e,G%\r\t\u0005!\u0015:c'\u0003\u0002'\u0015\tIa)\u001e8di&|g.\r\t\u0003Q%b\u0001\u0001B\u0003+\u0005\t\u00071FA\u0001C#\ta3\u0007\u0005\u0002)[\u00111a\u0006\u0001CC\u0002=\u0012\u0011!Q\t\u0003aM\u0002\"\u0001E\u0019\n\u0005IR!a\u0002(pi\"Lgn\u001a\t\u0003!QJ!!\u000e\u0006\u0003\u0007\u0005s\u0017\u0010E\u00028\u0001\u001dj\u0011\u0001\u0003\u0005\u0006s\t\u0001\raJ\u0001\u0005i\"\fG/A\u0003%Y\u0016\u001c8/\u0006\u0002=\u000bR\u0011Qh\u0012\u000b\u0003}\u0005\u0003\"\u0001E \n\u0005\u0001S!a\u0002\"p_2,\u0017M\u001c\u0005\b\u0005\u000e\t\t\u0011q\u0001D\u0003))g/\u001b3f]\u000e,GE\r\t\u0005!\u0015\"e\t\u0005\u0002)\u000b\u0012)!f\u0001b\u0001WA\u0019q\u0007\u0001#\t\u000be\u001a\u0001\u0019\u0001#\u0002\u0011\u0011:'/Z1uKJ,\"A\u0013)\u0015\u0005-\u0013FC\u0001 M\u0011\u001diE!!AA\u00049\u000b!\"\u001a<jI\u0016t7-\u001a\u00134!\u0011\u0001ReT)\u0011\u0005!\u0002F!\u0002\u0016\u0005\u0005\u0004Y\u0003cA\u001c\u0001\u001f\")\u0011\b\u0002a\u0001\u001f\u0006AA\u0005\\3tg\u0012*\u0017/\u0006\u0002V7R\u0011a+\u0018\u000b\u0003}]Cq\u0001W\u0003\u0002\u0002\u0003\u000f\u0011,\u0001\u0006fm&$WM\\2fIQ\u0002B\u0001E\u0013[9B\u0011\u0001f\u0017\u0003\u0006U\u0015\u0011\ra\u000b\t\u0004o\u0001Q\u0006\"B\u001d\u0006\u0001\u0004Q\u0016a\u0003\u0013he\u0016\fG/\u001a:%KF,\"\u0001\u00194\u0015\u0005\u0005DGC\u0001 c\u0011\u001d\u0019g!!AA\u0004\u0011\f!\"\u001a<jI\u0016t7-\u001a\u00136!\u0011\u0001R%Z4\u0011\u0005!2G!\u0002\u0016\u0007\u0005\u0004Y\u0003cA\u001c\u0001K\")\u0011H\u0002a\u0001K\u0002")
public interface PartiallyOrdered<A> {
    public <B> Option<Object> tryCompareTo(B var1, Function1<B, PartiallyOrdered<B>> var2);

    public static /* synthetic */ boolean $less$(PartiallyOrdered $this, Object that, Function1 evidence$2) {
        return $this.$less(that, evidence$2);
    }

    default public <B> boolean $less(B that, Function1<B, PartiallyOrdered<B>> evidence$2) {
        Option<Object> option = this.tryCompareTo(that, evidence$2);
        boolean bl = option instanceof Some && BoxesRunTime.unboxToInt(((Some)option).value()) < 0;
        return bl;
    }

    public static /* synthetic */ boolean $greater$(PartiallyOrdered $this, Object that, Function1 evidence$3) {
        return $this.$greater(that, evidence$3);
    }

    default public <B> boolean $greater(B that, Function1<B, PartiallyOrdered<B>> evidence$3) {
        Option<Object> option = this.tryCompareTo(that, evidence$3);
        boolean bl = option instanceof Some && BoxesRunTime.unboxToInt(((Some)option).value()) > 0;
        return bl;
    }

    public static /* synthetic */ boolean $less$eq$(PartiallyOrdered $this, Object that, Function1 evidence$4) {
        return $this.$less$eq(that, evidence$4);
    }

    default public <B> boolean $less$eq(B that, Function1<B, PartiallyOrdered<B>> evidence$4) {
        Option<Object> option = this.tryCompareTo(that, evidence$4);
        boolean bl = option instanceof Some && BoxesRunTime.unboxToInt(((Some)option).value()) <= 0;
        return bl;
    }

    public static /* synthetic */ boolean $greater$eq$(PartiallyOrdered $this, Object that, Function1 evidence$5) {
        return $this.$greater$eq(that, evidence$5);
    }

    default public <B> boolean $greater$eq(B that, Function1<B, PartiallyOrdered<B>> evidence$5) {
        Option<Object> option = this.tryCompareTo(that, evidence$5);
        boolean bl = option instanceof Some && BoxesRunTime.unboxToInt(((Some)option).value()) >= 0;
        return bl;
    }

    public static void $init$(PartiallyOrdered $this) {
    }
}

