/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.collection.mutable.ArraySeq;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001!3Q!\u0003\u0006\u0001\u0015IA\u0001B\n\u0001\u0003\u0002\u0003\u0006Ia\n\u0005\n[\u0001\u0011\t\u0011)A\u0005]EBQa\r\u0001\u0005\u0002QBq!\u000f\u0001C\u0002\u0013\u0005#\b\u0003\u0004<\u0001\u0001\u0006Ia\n\u0005\be\u0001\u0011\r\u0011\"\u0011=\u0011\u0019i\u0004\u0001)A\u0005]!)a\b\u0001C!\u007f\tyQ\t\u001f9pg\u0016$\u0017I\u001d:bsN+\u0017O\u0003\u0002\f\u0019\u00059Q.\u001e;bE2,'BA\u0007\u000f\u0003!\u0001\u0018M]1mY\u0016d'BA\b\u0011\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002#\u0005)1oY1mCV\u00111cG\n\u0003\u0001Q\u00012!F\f\u001a\u001b\u00051\"BA\u0006\u000f\u0013\tAbC\u0001\u0005BeJ\f\u0017pU3r!\tQ2\u0004\u0004\u0001\u0005\u000bq\u0001!\u0019\u0001\u0010\u0003\u0003Q\u001b\u0001!\u0005\u0002 GA\u0011\u0001%I\u0007\u0002!%\u0011!\u0005\u0005\u0002\b\u001d>$\b.\u001b8h!\t\u0001C%\u0003\u0002&!\t\u0019\u0011I\\=\u0002\u0007\u0005\u0014(\u000fE\u0002!Q)J!!\u000b\t\u0003\u000b\u0005\u0013(/Y=\u0011\u0005\u0001Z\u0013B\u0001\u0017\u0011\u0005\u0019\te.\u001f*fM\u0006\u00111O\u001f\t\u0003A=J!\u0001\r\t\u0003\u0007%sG/\u0003\u00023/\u00051A.\u001a8hi\"\fa\u0001P5oSRtDcA\u001b8qA\u0019a\u0007A\r\u000e\u0003)AQAJ\u0002A\u0002\u001dBQ!L\u0002A\u00029\nQ!\u0019:sCf,\u0012aJ\u0001\u0007CJ\u0014\u0018-\u001f\u0011\u0016\u00039\nq\u0001\\3oORD\u0007%\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070F\u0001A!\t\te)D\u0001C\u0015\t\u0019E)\u0001\u0003mC:<'\"A#\u0002\t)\fg/Y\u0005\u0003\u000f\n\u0013aa\u0015;sS:<\u0007")
public class ExposedArraySeq<T>
extends ArraySeq<T> {
    private final Object[] array;
    private final int length;

    @Override
    public Object[] array() {
        return this.array;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public String stringPrefix() {
        return "ArraySeq";
    }

    public ExposedArraySeq(Object[] arr, int sz) {
        super(sz);
        this.array = arr;
        this.length = super.length();
    }
}

