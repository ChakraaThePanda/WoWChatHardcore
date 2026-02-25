/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001]2qa\u0001\u0003\u0011\u0002G\u00051\u0002C\u0003\u0012\u0001\u0019\u0005!\u0003C\u00031\u0001\u0019\u0005\u0011GA\nHK:,'/[2QCJ\u001cu.\u001c9b]&|gN\u0003\u0002\u0006\r\u00059q-\u001a8fe&\u001c'BA\u0004\t\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u0013\u0005)1oY1mC\u000e\u0001QC\u0001\u0007''\t\u0001Q\u0002\u0005\u0002\u000f\u001f5\t\u0001\"\u0003\u0002\u0011\u0011\t1\u0011I\\=SK\u001a\f!B\\3x\u0005VLG\u000eZ3s+\t\u0019B$F\u0001\u0015!\u0011)\u0002DG\u0013\u000e\u0003YQ!a\u0006\u0004\u0002\u0011A\f'/\u00197mK2L!!\u0007\f\u0003\u0011\r{WNY5oKJ\u0004\"a\u0007\u000f\r\u0001\u0011)Q$\u0001b\u0001=\t\t\u0011)\u0005\u0002 EA\u0011a\u0002I\u0005\u0003C!\u0011qAT8uQ&tw\r\u0005\u0002\u000fG%\u0011A\u0005\u0003\u0002\u0004\u0003:L\bcA\u000e'5\u00111q\u0005\u0001CC\u0002!\u0012!aQ\"\u0016\u0005%r\u0013CA\u0010+!\r)2&L\u0005\u0003YY\u00111\u0002U1s\u0013R,'/\u00192mKB\u00111D\f\u0003\u0006_\u0019\u0012\rA\b\u0002\u00021\u0006Ya.Z<D_6\u0014\u0017N\\3s+\t\u0011T'F\u00014!\u0011)\u0002\u0004\u000e\u001c\u0011\u0005m)D!B\u000f\u0003\u0005\u0004q\u0002cA\u000e'i\u0001")
public interface GenericParCompanion<CC extends ParIterable<Object>> {
    public <A> Combiner<A, CC> newBuilder();

    public <A> Combiner<A, CC> newCombiner();
}

