/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.generic.Growable;
import scala.collection.generic.SetFactory;
import scala.collection.mutable.Builder;
import scala.collection.mutable.GrowingBuilder;
import scala.collection.mutable.Set;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001q2Qa\u0001\u0003\u0002\u0002-AQa\f\u0001\u0005\u0002ABQA\r\u0001\u0005\u0002M\u0012\u0011#T;uC\ndWmU3u\r\u0006\u001cGo\u001c:z\u0015\t)a!A\u0004hK:,'/[2\u000b\u0005\u001dA\u0011AC2pY2,7\r^5p]*\t\u0011\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00051\u00192C\u0001\u0001\u000e!\rqq\"E\u0007\u0002\t%\u0011\u0001\u0003\u0002\u0002\u000b'\u0016$h)Y2u_JL\bC\u0001\n\u0014\u0019\u0001!Q\u0001\u0006\u0001C\u0002U\u0011!aQ\"\u0016\u0005Y)\u0013CA\f\u001c!\tA\u0012$D\u0001\t\u0013\tQ\u0002BA\u0004O_RD\u0017N\\4\u0013\u0007qq2F\u0002\u0003\u001e\u0001\u0001Y\"\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004cA\u0010#I5\t\u0001E\u0003\u0002\"\r\u00059Q.\u001e;bE2,\u0017BA\u0012!\u0005\r\u0019V\r\u001e\t\u0003%\u0015\"QAJ\nC\u0002\u001d\u0012\u0011\u0001W\t\u0003/!\u0002\"\u0001G\u0015\n\u0005)B!aA!osB!q\u0004\f\u0013/\u0013\ti\u0003EA\u0004TKRd\u0015n[3\u0011\u0007I\u0019B%\u0001\u0004=S:LGO\u0010\u000b\u0002cA\u0019a\u0002A\t\u0002\u00159,wOQ;jY\u0012,'/\u0006\u00025sU\tQ\u0007\u0005\u0003 maZ\u0014BA\u001c!\u0005\u001d\u0011U/\u001b7eKJ\u0004\"AE\u001d\u0005\u000bi\u0012!\u0019A\u0014\u0003\u0003\u0005\u00032AE\n9\u0001")
public abstract class MutableSetFactory<CC extends Set<Object>>
extends SetFactory<CC> {
    @Override
    public <A> Builder<A, CC> newBuilder() {
        return new GrowingBuilder((Growable)this.empty());
    }
}

