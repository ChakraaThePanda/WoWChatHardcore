/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Tuple2;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenMapFactory;
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParMap;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005]a!B\u0005\u000b\u0003\u0003\t\u0002\"B \u0001\t\u0003\u0001U\u0001\u0002\"\u0001\u0001\rCQa\u0013\u0001\u0005B1CQA\u0018\u0001\u0007\u0002}3AA\u001b\u0001\u0001W\"1q(\u0002C\u0001\u0003\u0007Aq!!\u0003\u0006\t\u0003\tY\u0001C\u0004\u0002\n\u0015!\t!!\u0006\u0003\u001bA\u000b'/T1q\r\u0006\u001cGo\u001c:z\u0015\tYA\"A\u0004hK:,'/[2\u000b\u00055q\u0011AC2pY2,7\r^5p]*\tq\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005II2c\u0001\u0001\u0014yA\u0019A#F\f\u000e\u0003)I!A\u0006\u0006\u0003\u001b\u001d+g.T1q\r\u0006\u001cGo\u001c:z!\tA\u0012\u0004\u0004\u0001\u0005\u000bi\u0001!\u0019A\u000e\u0003\u0005\r\u001bUc\u0001\u000f,eE\u0011Q$\t\t\u0003=}i\u0011AD\u0005\u0003A9\u0011qAT8uQ&twME\u0002#IQ2Aa\t\u0001\u0001C\taAH]3gS:,W.\u001a8u}A!Q\u0005\u000b\u00162\u001b\u00051#BA\u0014\r\u0003!\u0001\u0018M]1mY\u0016d\u0017BA\u0015'\u0005\u0019\u0001\u0016M]'baB\u0011\u0001d\u000b\u0003\u0006Ye\u0011\r!\f\u0002\u00021F\u0011QD\f\t\u0003==J!\u0001\r\b\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u0019e\u0011)1'\u0007b\u0001[\t\t\u0011\f\r\u00026uA1QE\u000e\u00162qeJ!a\u000e\u0014\u0003\u0015A\u000b'/T1q\u0019&\\W\r\u0005\u0003\u00193)\n\u0004C\u0001\r;\t%Y\u0014$!A\u0001\u0002\u000b\u0005QFA\u0002`IE\u00022\u0001F\u001f\u0018\u0013\tq$B\u0001\fHK:,'/[2QCJl\u0015\r]\"p[B\fg.[8o\u0003\u0019a\u0014N\\5u}Q\t\u0011\tE\u0002\u0015\u0001]\u0011q!T1q\u0007>dG\u000eM\u0002E\r&\u0003B\u0001G\rF\u0011B\u0011\u0001D\u0012\u0003\n\u000f\n\t\t\u0011!A\u0003\u00025\u00121a\u0018\u00133!\tA\u0012\nB\u0005K\u0005\u0005\u0005\t\u0011!B\u0001[\t\u0019q\fJ\u001a\u0002\u00159,wOQ;jY\u0012,'/F\u0002N1n+\u0012A\u0014\t\u0005\u001fJ#V,D\u0001Q\u0015\t\tF\"A\u0004nkR\f'\r\\3\n\u0005M\u0003&a\u0002\"vS2$WM\u001d\t\u0005=U;&,\u0003\u0002W\u001d\t1A+\u001e9mKJ\u0002\"\u0001\u0007-\u0005\u000be\u001b!\u0019A\u0017\u0003\u0003-\u0003\"\u0001G.\u0005\u000bq\u001b!\u0019A\u0017\u0003\u0003Y\u0003B\u0001G\rX5\u0006Ya.Z<D_6\u0014\u0017N\\3s+\r\u0001g\r[\u000b\u0002CB!QE\u00193j\u0013\t\u0019gE\u0001\u0005D_6\u0014\u0017N\\3s!\u0011qR+Z4\u0011\u0005a1G!B-\u0005\u0005\u0004i\u0003C\u0001\ri\t\u0015aFA1\u0001.!\u0011A\u0012$Z4\u0003#\r\u000bgnQ8nE&tWM\u0012:p[6\u000b\u0007/F\u0002m{~\u001c2!B7q!\tqb.\u0003\u0002p\u001d\t1\u0011I\\=SK\u001a\u0004b\u0001F9tw\u0006\u0005\u0011B\u0001:\u000b\u00059\u0019\u0015M\\\"p[\nLg.\u001a$s_6\u00044\u0001\u001e<z!\u0011A\u0012$\u001e=\u0011\u0005a1H!C<\u0006\u0003\u0003\u0005\tQ!\u0001.\u0005\ryF\u0005\u000e\t\u00031e$\u0011B_\u0003\u0002\u0002\u0003\u0005)\u0011A\u0017\u0003\u0007}#S\u0007\u0005\u0003\u001f+rt\bC\u0001\r~\t\u0015IVA1\u0001.!\tAr\u0010B\u0003]\u000b\t\u0007Q\u0006\u0005\u0003\u00193qtHCAA\u0003!\u0015\t9!\u0002?\u007f\u001b\u0005\u0001\u0011!B1qa2LH\u0003BA\u0007\u0003\u001f\u0001R!\n2|\u0003\u0003Aq!!\u0005\b\u0001\u0004\t\u0019\"\u0001\u0003ge>l\u0007cAA\u0004\u0005Q\u0011\u0011Q\u0002")
public abstract class ParMapFactory<CC extends ParMap<Object, Object>>
extends GenMapFactory<CC>
implements GenericParMapCompanion<CC> {
    @Override
    public <K, V> Builder<Tuple2<K, V>, CC> newBuilder() {
        return this.newCombiner();
    }

    @Override
    public abstract <K, V> Combiner<Tuple2<K, V>, CC> newCombiner();

    public class CanCombineFromMap<K, V>
    implements CanCombineFrom<CC, Tuple2<K, V>, CC> {
        @Override
        public Combiner<Tuple2<K, V>, CC> apply(CC from) {
            return from.genericMapCombiner();
        }

        @Override
        public Combiner<Tuple2<K, V>, CC> apply() {
            return this.scala$collection$generic$ParMapFactory$CanCombineFromMap$$$outer().newCombiner();
        }

        public /* synthetic */ ParMapFactory scala$collection$generic$ParMapFactory$CanCombineFromMap$$$outer() {
            return ParMapFactory.this;
        }

        public CanCombineFromMap() {
            if (ParMapFactory.this == null) {
                throw null;
            }
        }
    }
}

