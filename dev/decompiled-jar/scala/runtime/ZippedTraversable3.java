/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Function3;
import scala.Tuple3;
import scala.collection.Traversable;
import scala.reflect.ScalaSignature;
import scala.runtime.ZippedTraversable3$;

@ScalaSignature(bytes="\u0006\u000153qAB\u0004\u0011\u0002G\u0005A\u0002C\u0003\u0013\u0001\u0019\u00051cB\u0003/\u000f!\u0005qFB\u0003\u0007\u000f!\u0005\u0011\u0007C\u00036\u0007\u0011\u0005a\u0007C\u00038\u0007\u0011\r\u0001H\u0001\n[SB\u0004X\r\u001a+sCZ,'o]1cY\u0016\u001c$B\u0001\u0005\n\u0003\u001d\u0011XO\u001c;j[\u0016T\u0011AC\u0001\u0006g\u000e\fG.Y\u0002\u0001+\u0011iqDJ\u0015\u0014\u0005\u0001q\u0001CA\b\u0011\u001b\u0005I\u0011BA\t\n\u0005\r\te._\u0001\bM>\u0014X-Y2i+\t!B\u0006\u0006\u0002\u00161A\u0011qBF\u0005\u0003/%\u0011A!\u00168ji\")\u0011$\u0001a\u00015\u0005\ta\r\u0005\u0004\u00107u)\u0003fK\u0005\u00039%\u0011\u0011BR;oGRLwN\\\u001a\u0011\u0005yyB\u0002\u0001\u0003\u0007A\u0001!)\u0019A\u0011\u0003\u0007\u0015c\u0017'\u0005\u0002#\u001dA\u0011qbI\u0005\u0003I%\u0011qAT8uQ&tw\r\u0005\u0002\u001fM\u00111q\u0005\u0001CC\u0002\u0005\u00121!\u001273!\tq\u0012\u0006\u0002\u0004+\u0001\u0011\u0015\r!\t\u0002\u0004\u000b2\u001c\u0004C\u0001\u0010-\t\u0015i\u0013A1\u0001\"\u0005\u0005)\u0016A\u0005.jaB,G\r\u0016:bm\u0016\u00148/\u00192mKN\u0002\"\u0001M\u0002\u000e\u0003\u001d\u0019\"a\u0001\u001a\u0011\u0005=\u0019\u0014B\u0001\u001b\n\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012aL\u0001 u&\u0004\b/\u001a3Ue\u00064XM]:bE2,7\u0007V8Ue\u00064XM]:bE2,W\u0003B\u001dF\u000f&#\"A\u000f&\u0011\u0007mr\u0014I\u0004\u0002\u0010y%\u0011Q(C\u0001\ba\u0006\u001c7.Y4f\u0013\ty\u0004IA\u0006Ue\u00064XM]:bE2,'BA\u001f\n!\u0015y!\t\u0012$I\u0013\t\u0019\u0015B\u0001\u0004UkBdWm\r\t\u0003=\u0015#Q\u0001I\u0003C\u0002\u0005\u0002\"AH$\u0005\u000b\u001d*!\u0019A\u0011\u0011\u0005yIE!\u0002\u0016\u0006\u0005\u0004\t\u0003\"B&\u0006\u0001\u0004a\u0015A\u0001>{!\u0015\u0001\u0004\u0001\u0012$I\u0001")
public interface ZippedTraversable3<El1, El2, El3> {
    public static <El1, El2, El3> Traversable<Tuple3<El1, El2, El3>> zippedTraversable3ToTraversable(ZippedTraversable3<El1, El2, El3> zippedTraversable3) {
        return ZippedTraversable3$.MODULE$.zippedTraversable3ToTraversable(zippedTraversable3);
    }

    public <U> void foreach(Function3<El1, El2, El3, U> var1);
}

