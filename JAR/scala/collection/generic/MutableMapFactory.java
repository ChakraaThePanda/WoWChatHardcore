/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Tuple2;
import scala.collection.generic.MapFactory;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Map;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\r3Qa\u0001\u0003\u0002\u0002-AQA\r\u0001\u0005\u0002MBQ!\u000e\u0001\u0005BY\u0012\u0011#T;uC\ndW-T1q\r\u0006\u001cGo\u001c:z\u0015\t)a!A\u0004hK:,'/[2\u000b\u0005\u001dA\u0011AC2pY2,7\r^5p]*\t\u0011\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00051\u00192C\u0001\u0001\u000e!\rqq\"E\u0007\u0002\t%\u0011\u0001\u0003\u0002\u0002\u000b\u001b\u0006\u0004h)Y2u_JL\bC\u0001\n\u0014\u0019\u0001!Q\u0001\u0006\u0001C\u0002U\u0011!aQ\"\u0016\u0007Y)C&\u0005\u0002\u00187A\u0011\u0001$G\u0007\u0002\u0011%\u0011!\u0004\u0003\u0002\b\u001d>$\b.\u001b8h%\rabD\f\u0004\u0005;\u0001\u00011D\u0001\u0007=e\u00164\u0017N\\3nK:$h\b\u0005\u0003 E\u0011ZS\"\u0001\u0011\u000b\u0005\u00052\u0011aB7vi\u0006\u0014G.Z\u0005\u0003G\u0001\u00121!T1q!\t\u0011R\u0005B\u0003''\t\u0007qEA\u0001B#\t9\u0002\u0006\u0005\u0002\u0019S%\u0011!\u0006\u0003\u0002\u0004\u0003:L\bC\u0001\n-\t\u0015i3C1\u0001(\u0005\u0005\u0011\u0005#B\u00100I-\n\u0014B\u0001\u0019!\u0005\u001di\u0015\r\u001d'jW\u0016\u0004BAE\n%W\u00051A(\u001b8jiz\"\u0012\u0001\u000e\t\u0004\u001d\u0001\t\u0012A\u00038fo\n+\u0018\u000e\u001c3feV\u0019qgP!\u0016\u0003a\u0002BaH\u001d<\u0005&\u0011!\b\t\u0002\b\u0005VLG\u000eZ3s!\u0011ABH\u0010!\n\u0005uB!A\u0002+va2,'\u0007\u0005\u0002\u0013\u007f\u0011)aE\u0001b\u0001OA\u0011!#\u0011\u0003\u0006[\t\u0011\ra\n\t\u0005%Mq\u0004\t")
public abstract class MutableMapFactory<CC extends Map<Object, Object>>
extends MapFactory<CC> {
    @Override
    public <A, B> Builder<Tuple2<A, B>, CC> newBuilder() {
        return (Builder)this.empty();
    }
}

