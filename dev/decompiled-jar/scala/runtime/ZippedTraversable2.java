/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function2;
import scala.Tuple2;
import scala.collection.Traversable;
import scala.reflect.ScalaSignature;
import scala.runtime.ZippedTraversable2$;

@ScalaSignature(bytes="\u0006\u0001!3qAB\u0004\u0011\u0002G\u0005A\u0002C\u0003\u0013\u0001\u0019\u00051cB\u0003,\u000f!\u0005AFB\u0003\u0007\u000f!\u0005a\u0006C\u00033\u0007\u0011\u00051\u0007C\u00035\u0007\u0011\rQG\u0001\n[SB\u0004X\r\u001a+sCZ,'o]1cY\u0016\u0014$B\u0001\u0005\n\u0003\u001d\u0011XO\u001c;j[\u0016T\u0011AC\u0001\u0006g\u000e\fG.Y\u0002\u0001+\riqDJ\n\u0003\u00019\u0001\"a\u0004\t\u000e\u0003%I!!E\u0005\u0003\u0007\u0005s\u00170A\u0004g_J,\u0017m\u00195\u0016\u0005QICCA\u000b\u0019!\tya#\u0003\u0002\u0018\u0013\t!QK\\5u\u0011\u0015I\u0012\u00011\u0001\u001b\u0003\u00051\u0007#B\b\u001c;\u0015B\u0013B\u0001\u000f\n\u0005%1UO\\2uS>t'\u0007\u0005\u0002\u001f?1\u0001AA\u0002\u0011\u0001\t\u000b\u0007\u0011EA\u0002FYF\n\"A\t\b\u0011\u0005=\u0019\u0013B\u0001\u0013\n\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"A\b\u0014\u0005\r\u001d\u0002AQ1\u0001\"\u0005\r)EN\r\t\u0003=%\"QAK\u0001C\u0002\u0005\u0012\u0011!V\u0001\u00135&\u0004\b/\u001a3Ue\u00064XM]:bE2,'\u0007\u0005\u0002.\u00075\tqa\u0005\u0002\u0004_A\u0011q\u0002M\u0005\u0003c%\u0011a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001-\u0003}Q\u0018\u000e\u001d9fIR\u0013\u0018M^3sg\u0006\u0014G.\u001a\u001aU_R\u0013\u0018M^3sg\u0006\u0014G.Z\u000b\u0004m\t#ECA\u001cF!\rA4H\u0010\b\u0003\u001feJ!AO\u0005\u0002\u000fA\f7m[1hK&\u0011A(\u0010\u0002\f)J\fg/\u001a:tC\ndWM\u0003\u0002;\u0013A!qbP!D\u0013\t\u0001\u0015B\u0001\u0004UkBdWM\r\t\u0003=\t#Q\u0001I\u0003C\u0002\u0005\u0002\"A\b#\u0005\u000b\u001d*!\u0019A\u0011\t\u000b\u0019+\u0001\u0019A$\u0002\u0005iT\b\u0003B\u0017\u0001\u0003\u000e\u0003")
public interface ZippedTraversable2<El1, El2> {
    public static <El1, El2> Traversable<Tuple2<El1, El2>> zippedTraversable2ToTraversable(ZippedTraversable2<El1, El2> zippedTraversable2) {
        return ZippedTraversable2$.MODULE$.zippedTraversable2ToTraversable(zippedTraversable2);
    }

    public <U> void foreach(Function2<El1, El2, U> var1);
}

