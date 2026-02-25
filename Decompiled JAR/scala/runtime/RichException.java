/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.Predef$;
import scala.collection.mutable.ArrayOps;
import scala.compat.Platform$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001E2A\u0001B\u0003\u0003\u0015!Aq\u0002\u0001B\u0001B\u0003%\u0001\u0003C\u0003\u0018\u0001\u0011\u0005\u0001\u0004C\u0003\u001d\u0001\u0011\u0005QDA\u0007SS\u000eDW\t_2faRLwN\u001c\u0006\u0003\r\u001d\tqA];oi&lWMC\u0001\t\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001A\u0006\u0011\u00051iQ\"A\u0004\n\u000599!AB!osJ+g-A\u0002fq\u000e\u0004\"!\u0005\u000b\u000f\u00051\u0011\u0012BA\n\b\u0003\u001d\u0001\u0018mY6bO\u0016L!!\u0006\f\u0003\u0013QC'o\\<bE2,'BA\n\b\u0003\u0019a\u0014N\\5u}Q\u0011\u0011d\u0007\t\u00035\u0001i\u0011!\u0002\u0005\u0006\u001f\t\u0001\r\u0001E\u0001\u0014O\u0016$8\u000b^1dWR\u0013\u0018mY3TiJLgnZ\u000b\u0002=A\u0011qD\n\b\u0003A\u0011\u0002\"!I\u0004\u000e\u0003\tR!aI\u0005\u0002\rq\u0012xn\u001c;?\u0013\t)s!\u0001\u0004Qe\u0016$WMZ\u0005\u0003O!\u0012aa\u0015;sS:<'BA\u0013\bQ\u0011\u0001!&L\u0018\u0011\u00051Y\u0013B\u0001\u0017\b\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0002]\u0005YRo]3!)\"\u0014xn^1cY\u0016\u001cs-\u001a;Ti\u0006\u001c7\u000e\u0016:bG\u0016\f\u0013\u0001M\u0001\u0007e9\n\u0014G\f\u0019")
public final class RichException {
    private final Throwable exc;

    public String getStackTraceString() {
        return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.exc.getStackTrace())).mkString("", Platform$.MODULE$.EOL(), Platform$.MODULE$.EOL());
    }

    public RichException(Throwable exc) {
        this.exc = exc;
    }
}

