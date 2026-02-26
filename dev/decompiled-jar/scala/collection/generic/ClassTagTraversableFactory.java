/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Traversable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericClassTagCompanion;
import scala.collection.generic.GenericClassTagTraversableTemplate;
import scala.collection.mutable.Builder;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00054Qa\u0002\u0005\u0002\u0002=AQ\u0001\r\u0001\u0005\u0002E2Aa\r\u0001\u0001i!AQI\u0001B\u0001B\u0003-a\tC\u00031\u0005\u0011\u0005A\nC\u0003R\u0005\u0011\u0005!\u000bC\u0003R\u0005\u0011\u0005\u0001M\u0001\u000eDY\u0006\u001c8\u000fV1h)J\fg/\u001a:tC\ndWMR1di>\u0014\u0018P\u0003\u0002\n\u0015\u00059q-\u001a8fe&\u001c'BA\u0006\r\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u001b\u0005)1oY1mC\u000e\u0001QC\u0001\t\u0018'\t\u0001\u0011\u0003E\u0002\u0013'Ui\u0011\u0001C\u0005\u0003)!\u0011\u0001dR3oKJL7m\u00117bgN$\u0016mZ\"p[B\fg.[8o!\t1r\u0003\u0004\u0001\u0005\u000ba\u0001!\u0019A\r\u0003\u0005\r\u001bUC\u0001\u000e(#\tYr\u0004\u0005\u0002\u001d;5\tA\"\u0003\u0002\u001f\u0019\t9aj\u001c;iS:<'c\u0001\u0011#[\u0019!\u0011\u0005\u0001\u0001 \u00051a$/\u001a4j]\u0016lWM\u001c;?!\r\u0019CEJ\u0007\u0002\u0015%\u0011QE\u0003\u0002\f)J\fg/\u001a:tC\ndW\r\u0005\u0002\u0017O\u0011)\u0001f\u0006b\u0001S\t\t\u0001,\u0005\u0002\u001cUA\u0011AdK\u0005\u0003Y1\u00111!\u00118z!\u0011\u0011bFJ\u000b\n\u0005=B!AI$f]\u0016\u0014\u0018nY\"mCN\u001cH+Y4Ue\u00064XM]:bE2,G+Z7qY\u0006$X-\u0001\u0004=S:LGO\u0010\u000b\u0002eA\u0019!\u0003A\u000b\u0003'\u001d+g.\u001a:jG\u000e\u000bgNQ;jY\u00124%o\\7\u0016\u0005U\u00125c\u0001\u00027sA\u0011AdN\u0005\u0003q1\u0011a!\u00118z%\u00164\u0007#\u0002\n;y\u0005#\u0015BA\u001e\t\u00051\u0019\u0015M\u001c\"vS2$gI]8na\tit\bE\u0002\u0017/y\u0002\"AF \u0005\u0013\u0001\u0013\u0011\u0011!A\u0001\u0006\u0003I#aA0%cA\u0011aC\u0011\u0003\u0006\u0007\n\u0011\r!\u000b\u0002\u0002\u0003B\u0019acF!\u0002\u0007Q\fw\rE\u0002H\u0015\u0006k\u0011\u0001\u0013\u0006\u0003\u00132\tqA]3gY\u0016\u001cG/\u0003\u0002L\u0011\nA1\t\\1tgR\u000bw\rF\u0001N)\tq\u0005\u000bE\u0002P\u0005\u0005k\u0011\u0001\u0001\u0005\u0006\u000b\u0012\u0001\u001dAR\u0001\u0006CB\u0004H.\u001f\u000b\u0003'f\u0003B\u0001V,B\t6\tQK\u0003\u0002W\u0015\u00059Q.\u001e;bE2,\u0017B\u0001-V\u0005\u001d\u0011U/\u001b7eKJDQAW\u0003A\u0002m\u000bAA\u001a:p[B\u0012AL\u0018\t\u0004-]i\u0006C\u0001\f_\t%y\u0016,!A\u0001\u0002\u000b\u0005\u0011FA\u0002`II\"\u0012a\u0015")
public abstract class ClassTagTraversableFactory<CC extends Traversable<Object>>
extends GenericClassTagCompanion<CC> {

    public class GenericCanBuildFrom<A>
    implements CanBuildFrom<CC, A, CC> {
        private final ClassTag<A> tag;
        public final /* synthetic */ ClassTagTraversableFactory $outer;

        @Override
        public Builder<A, CC> apply(CC from) {
            return ((GenericClassTagTraversableTemplate)from).genericClassTagBuilder(this.tag);
        }

        @Override
        public Builder<A, CC> apply() {
            return this.scala$collection$generic$ClassTagTraversableFactory$GenericCanBuildFrom$$$outer().newBuilder(this.tag);
        }

        public /* synthetic */ ClassTagTraversableFactory scala$collection$generic$ClassTagTraversableFactory$GenericCanBuildFrom$$$outer() {
            return this.$outer;
        }

        public GenericCanBuildFrom(ClassTagTraversableFactory $outer, ClassTag<A> tag) {
            this.tag = tag;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

