/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.collection.GenTraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.parallel.FactoryOps;
import scala.collection.parallel.ParallelCollectionImplicits$;
import scala.collection.parallel.ThrowableOps;
import scala.collection.parallel.TraversableOps;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001m;aAB\u0004\t\u0002%iaAB\b\b\u0011\u0003I\u0001\u0003C\u0003\u0016\u0003\u0011\u0005q\u0003C\u0003\u0019\u0003\u0011\r\u0011\u0004C\u0003;\u0003\u0011\r1\bC\u0003L\u0003\u0011\rA*A\u000eQCJ\fG\u000e\\3m\u0007>dG.Z2uS>t\u0017*\u001c9mS\u000eLGo\u001d\u0006\u0003\u0011%\t\u0001\u0002]1sC2dW\r\u001c\u0006\u0003\u0015-\t!bY8mY\u0016\u001cG/[8o\u0015\u0005a\u0011!B:dC2\f\u0007C\u0001\b\u0002\u001b\u00059!a\u0007)be\u0006dG.\u001a7D_2dWm\u0019;j_:LU\u000e\u001d7jG&$8o\u0005\u0002\u0002#A\u0011!cE\u0007\u0002\u0017%\u0011Ac\u0003\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?\u0007\u0001!\u0012!D\u0001\fM\u0006\u001cGo\u001c:ze=\u00048/\u0006\u0003\u001bG5\u0002DCA\u000e3%\ra\u0012C\b\u0004\u0005;\r\u00011D\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0003\u000f?\u0005bs&\u0003\u0002!\u000f\tQa)Y2u_JLx\n]:\u0011\u0005\t\u001aC\u0002\u0001\u0003\u0006I\r\u0011\r!\n\u0002\u0005\rJ|W.\u0005\u0002'SA\u0011!cJ\u0005\u0003Q-\u0011qAT8uQ&tw\r\u0005\u0002\u0013U%\u00111f\u0003\u0002\u0004\u0003:L\bC\u0001\u0012.\t\u0015q3A1\u0001&\u0005\u0011)E.Z7\u0011\u0005\t\u0002D!B\u0019\u0004\u0005\u0004)#A\u0001+p\u0011\u0015\u00194\u00011\u00015\u0003\t\u0011g\rE\u00036q\u0005bs&D\u00017\u0015\t9\u0014\"A\u0004hK:,'/[2\n\u0005e2$\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0017a\u0004;sCZ,'o]1cY\u0016\u0014t\u000e]:\u0016\u0005q\u001aECA\u001fF%\rq\u0014c\u0010\u0004\u0005;\u0011\u0001Q\bE\u0002\u000f\u0001\nK!!Q\u0004\u0003\u001dQ\u0013\u0018M^3sg\u0006\u0014G.Z(qgB\u0011!e\u0011\u0003\u0006\t\u0012\u0011\r!\n\u0002\u0002)\")a\t\u0002a\u0001\u000f\u0006\tA\u000fE\u0002I\u0013\nk\u0011!C\u0005\u0003\u0015&\u0011!cR3o)J\fg/\u001a:tC\ndWm\u00148dK\u0006iA\u000f\u001b:po\u0006\u0014G.\u001a\u001apaN$\"!\u0014*\u0013\u00079\u000brJ\u0002\u0003\u001e\u000b\u0001i\u0005C\u0001\bQ\u0013\t\tvA\u0001\u0007UQJ|w/\u00192mK>\u00038\u000fC\u0003T\u000b\u0001\u0007A+\u0001\u0003tK24\u0007CA+Y\u001d\t\u0011b+\u0003\u0002X\u0017\u00059\u0001/Y2lC\u001e,\u0017BA-[\u0005%!\u0006N]8xC\ndWM\u0003\u0002X\u0017\u0001")
public final class ParallelCollectionImplicits {
    public static ThrowableOps throwable2ops(Throwable throwable) {
        return ParallelCollectionImplicits$.MODULE$.throwable2ops(throwable);
    }

    public static <T> TraversableOps<T> traversable2ops(GenTraversableOnce<T> genTraversableOnce) {
        return ParallelCollectionImplicits$.MODULE$.traversable2ops(genTraversableOnce);
    }

    public static <From, Elem, To> FactoryOps<From, Elem, To> factory2ops(CanBuildFrom<From, Elem, To> canBuildFrom) {
        return ParallelCollectionImplicits$.MODULE$.factory2ops(canBuildFrom);
    }
}

