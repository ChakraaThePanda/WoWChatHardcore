/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Traversable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericOrderedCompanion;
import scala.collection.generic.GenericOrderedTraversableTemplate;
import scala.collection.mutable.Builder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t4Qa\u0002\u0005\u0002\u0002=AQ\u0001\r\u0001\u0005\u0002E2Aa\r\u0001\u0001i!AQI\u0001B\u0001B\u0003-a\tC\u00031\u0005\u0011\u0005Q\nC\u0003S\u0005\u0011\u00051\u000bC\u0003S\u0005\u0011\u0005\u0011MA\rPe\u0012,'/\u001a3Ue\u00064XM]:bE2,g)Y2u_JL(BA\u0005\u000b\u0003\u001d9WM\\3sS\u000eT!a\u0003\u0007\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u000e\u0003\u0015\u00198-\u00197b\u0007\u0001)\"\u0001E\f\u0014\u0005\u0001\t\u0002c\u0001\n\u0014+5\t\u0001\"\u0003\u0002\u0015\u0011\t9r)\u001a8fe&\u001cwJ\u001d3fe\u0016$7i\\7qC:LwN\u001c\t\u0003-]a\u0001\u0001B\u0003\u0019\u0001\t\u0007\u0011D\u0001\u0002D\u0007V\u0011!dJ\t\u00037}\u0001\"\u0001H\u000f\u000e\u00031I!A\b\u0007\u0003\u000f9{G\u000f[5oOJ\u0019\u0001EI\u0017\u0007\t\u0005\u0002\u0001a\b\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0004G\u00112S\"\u0001\u0006\n\u0005\u0015R!a\u0003+sCZ,'o]1cY\u0016\u0004\"AF\u0014\u0005\u000b!:\"\u0019A\u0015\u0003\u0003a\u000b\"a\u0007\u0016\u0011\u0005qY\u0013B\u0001\u0017\r\u0005\r\te.\u001f\t\u0005%92S#\u0003\u00020\u0011\t\ts)\u001a8fe&\u001cwJ\u001d3fe\u0016$GK]1wKJ\u001c\u0018M\u00197f)\u0016l\u0007\u000f\\1uK\u00061A(\u001b8jiz\"\u0012A\r\t\u0004%\u0001)\"aE$f]\u0016\u0014\u0018nY\"b]\n+\u0018\u000e\u001c3Ge>lWCA\u001bC'\r\u0011a'\u000f\t\u00039]J!\u0001\u000f\u0007\u0003\r\u0005s\u0017PU3g!\u0015\u0011\"\bP!E\u0013\tY\u0004B\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\r\u0002>\u007fA\u0019ac\u0006 \u0011\u0005YyD!\u0003!\u0003\u0003\u0003\u0005\tQ!\u0001*\u0005\ryF%\r\t\u0003-\t#Qa\u0011\u0002C\u0002%\u0012\u0011!\u0011\t\u0004-]\t\u0015aA8sIB\u0019qIS!\u000f\u0005qA\u0015BA%\r\u0003\u001d\u0001\u0018mY6bO\u0016L!a\u0013'\u0003\u0011=\u0013H-\u001a:j]\u001eT!!\u0013\u0007\u0015\u00039#\"aT)\u0011\u0007A\u0013\u0011)D\u0001\u0001\u0011\u0015)E\u0001q\u0001G\u0003\u0015\t\u0007\u000f\u001d7z)\t!&\f\u0005\u0003V1\u0006#U\"\u0001,\u000b\u0005]S\u0011aB7vi\u0006\u0014G.Z\u0005\u00033Z\u0013qAQ;jY\u0012,'\u000fC\u0003\\\u000b\u0001\u0007A,\u0001\u0003ge>l\u0007GA/`!\r1rC\u0018\t\u0003-}#\u0011\u0002\u0019.\u0002\u0002\u0003\u0005)\u0011A\u0015\u0003\u0007}##\u0007F\u0001U\u0001")
public abstract class OrderedTraversableFactory<CC extends Traversable<Object>>
extends GenericOrderedCompanion<CC> {

    public class GenericCanBuildFrom<A>
    implements CanBuildFrom<CC, A, CC> {
        private final Ordering<A> ord;
        public final /* synthetic */ OrderedTraversableFactory $outer;

        @Override
        public Builder<A, CC> apply(CC from) {
            return ((GenericOrderedTraversableTemplate)from).genericOrderedBuilder(this.ord);
        }

        @Override
        public Builder<A, CC> apply() {
            return this.scala$collection$generic$OrderedTraversableFactory$GenericCanBuildFrom$$$outer().newBuilder(this.ord);
        }

        public /* synthetic */ OrderedTraversableFactory scala$collection$generic$OrderedTraversableFactory$GenericCanBuildFrom$$$outer() {
            return this.$outer;
        }

        public GenericCanBuildFrom(OrderedTraversableFactory $outer, Ordering<A> ord) {
            this.ord = ord;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

