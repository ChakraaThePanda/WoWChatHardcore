/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericParCompanion;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001e3QAB\u0004\u0002\u00029AQ\u0001\u000e\u0001\u0005\u0002U2Aa\u000e\u0001\u0001q!)AG\u0001C\u0001\u0015\")AJ\u0001C!\u001b\")AJ\u0001C!1\nQ\u0001+\u0019:GC\u000e$xN]=\u000b\u0005!I\u0011aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003\u0015-\t!bY8mY\u0016\u001cG/[8o\u0015\u0005a\u0011!B:dC2\f7\u0001A\u000b\u0003\u001fY\u00192\u0001\u0001\t2!\r\t\"\u0003F\u0007\u0002\u000f%\u00111c\u0002\u0002\u0016\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\r\u0006\u001cGo\u001c:z!\t)b\u0003\u0004\u0001\u0005\u000b]\u0001!\u0019\u0001\r\u0003\u0005\r\u001bUCA\r)#\tQb\u0004\u0005\u0002\u001c95\t1\"\u0003\u0002\u001e\u0017\t9aj\u001c;iS:<'cA\u0010\"]\u0019!\u0001\u0005\u0001\u0001\u001f\u00051a$/\u001a4j]\u0016lWM\u001c;?!\r\u0011SeJ\u0007\u0002G)\u0011A%C\u0001\ta\u0006\u0014\u0018\r\u001c7fY&\u0011ae\t\u0002\f!\u0006\u0014\u0018\n^3sC\ndW\r\u0005\u0002\u0016Q\u0011)\u0011F\u0006b\u0001U\t\t\u0001,\u0005\u0002\u001bWA\u00111\u0004L\u0005\u0003[-\u00111!\u00118z!\u0011\trf\n\u000b\n\u0005A:!AE$f]\u0016\u0014\u0018n\u0019)beR+W\u000e\u001d7bi\u0016\u00042!\u0005\u001a\u0015\u0013\t\u0019tAA\nHK:,'/[2QCJ\u001cu.\u001c9b]&|g.\u0001\u0004=S:LGO\u0010\u000b\u0002mA\u0019\u0011\u0003\u0001\u000b\u0003+\u001d+g.\u001a:jG\u000e\u000bgnQ8nE&tWM\u0012:p[V\u0011\u0011hP\n\u0004\u0005i\n\u0005cA\u001e=}5\t\u0001!\u0003\u0002>%\t\u0019r)\u001a8fe&\u001c7)\u00198Ck&dGM\u0012:p[B\u0011Qc\u0010\u0003\u0006\u0001\n\u0011\rA\u000b\u0002\u0002\u0003B)\u0011C\u0011#?\u0013&\u00111i\u0002\u0002\u000f\u0007\u0006t7i\\7cS:,gI]8na\t)u\tE\u0002\u0016-\u0019\u0003\"!F$\u0005\u0013!\u0013\u0011\u0011!A\u0001\u0006\u0003Q#aA0%cA\u0019QC\u0006 \u0015\u0003-\u00032a\u000f\u0002?\u0003\u0015\t\u0007\u000f\u001d7z)\tq\u0015\u000b\u0005\u0003#\u001fzJ\u0015B\u0001)$\u0005!\u0019u.\u001c2j]\u0016\u0014\b\"\u0002*\u0005\u0001\u0004\u0019\u0016\u0001\u00024s_6\u0004\"a\u000f+\n\u0005U3&\u0001B\"pY2L!aV\u0004\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>tG#\u0001(")
public abstract class ParFactory<CC extends ParIterable<Object>>
extends GenTraversableFactory<CC>
implements GenericParCompanion<CC> {

    public class GenericCanCombineFrom<A>
    extends GenTraversableFactory.GenericCanBuildFrom<A>
    implements CanCombineFrom<CC, A, CC> {
        @Override
        public Combiner<A, CC> apply(CC from) {
            return from.genericCombiner();
        }

        @Override
        public Combiner<A, CC> apply() {
            return this.scala$collection$generic$ParFactory$GenericCanCombineFrom$$$outer().newBuilder();
        }

        public /* synthetic */ ParFactory scala$collection$generic$ParFactory$GenericCanCombineFrom$$$outer() {
            return (ParFactory)this.$outer;
        }

        public GenericCanCombineFrom(ParFactory $outer) {
        }
    }
}

