/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.generic.Growable;
import scala.collection.generic.SortedSetFactory;
import scala.collection.mutable.Builder;
import scala.collection.mutable.GrowingBuilder;
import scala.collection.mutable.SortedSet;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001-3Qa\u0001\u0003\u0002\u0002-AQA\u000e\u0001\u0005\u0002]BQ!\u000f\u0001\u0005Bi\u0012q#T;uC\ndWmU8si\u0016$7+\u001a;GC\u000e$xN]=\u000b\u0005\u00151\u0011aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003\u000f!\t!bY8mY\u0016\u001cG/[8o\u0015\u0005I\u0011!B:dC2\f7\u0001A\u000b\u0003\u0019M\u0019\"\u0001A\u0007\u0011\u00079y\u0011#D\u0001\u0005\u0013\t\u0001BA\u0001\tT_J$X\rZ*fi\u001a\u000b7\r^8ssB\u0011!c\u0005\u0007\u0001\t\u0015!\u0002A1\u0001\u0016\u0005\t\u00195)\u0006\u0002\u0017KE\u0011qc\u0007\t\u00031ei\u0011\u0001C\u0005\u00035!\u0011qAT8uQ&twME\u0003\u001d=-\u00024G\u0002\u0003\u001e\u0001\u0001Y\"\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004cA\u0010#I5\t\u0001E\u0003\u0002\"\r\u00059Q.\u001e;bE2,\u0017BA\u0012!\u0005%\u0019vN\u001d;fIN+G\u000f\u0005\u0002\u0013K\u0011)ae\u0005b\u0001O\t\t\u0011)\u0005\u0002\u0018QA\u0011\u0001$K\u0005\u0003U!\u00111!\u00118z!\u0011aS\u0006J\u0018\u000e\u0003\u0019I!A\f\u0004\u0003\u001bM{'\u000f^3e'\u0016$H*[6f!\r\u00112\u0003\n\t\u0004?E\"\u0013B\u0001\u001a!\u0005\r\u0019V\r\u001e\t\u0005?Q\"s&\u0003\u00026A\t91+\u001a;MS.,\u0017A\u0002\u001fj]&$h\bF\u00019!\rq\u0001!E\u0001\u000b]\u0016<()^5mI\u0016\u0014XCA\u001eA)\ta$\t\u0005\u0003 {}\n\u0015B\u0001 !\u0005\u001d\u0011U/\u001b7eKJ\u0004\"A\u0005!\u0005\u000b\u0019\u0012!\u0019A\u0014\u0011\u0007I\u0019r\bC\u0003D\u0005\u0001\u000fA)A\u0002pe\u0012\u00042!\u0012%@\u001d\tAb)\u0003\u0002H\u0011\u00059\u0001/Y2lC\u001e,\u0017BA%K\u0005!y%\u000fZ3sS:<'BA$\t\u0001")
public abstract class MutableSortedSetFactory<CC extends SortedSet<Object>>
extends SortedSetFactory<CC> {
    @Override
    public <A> Builder<A, CC> newBuilder(Ordering<A> ord) {
        return new GrowingBuilder((Growable)this.empty(ord));
    }
}

