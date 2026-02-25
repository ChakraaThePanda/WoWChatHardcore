/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.GenSetFactory;
import scala.collection.generic.GenericParCompanion;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSet;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001E4Q\u0001C\u0005\u0002\u0002AAQA\u0010\u0001\u0005\u0002}BQ!\u0011\u0001\u0005\u0002\tCQa\u0013\u0001\u0007\u000213AA\u0015\u0001\u0001'\")a\b\u0002C\u0001G\")a\r\u0002C!O\")a\r\u0002C!a\ni\u0001+\u0019:TKR4\u0015m\u0019;pefT!AC\u0006\u0002\u000f\u001d,g.\u001a:jG*\u0011A\"D\u0001\u000bG>dG.Z2uS>t'\"\u0001\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011\u0011\u0003G\n\u0004\u0001IY\u0004cA\n\u0015-5\t\u0011\"\u0003\u0002\u0016\u0013\tiq)\u001a8TKR4\u0015m\u0019;pef\u0004\"a\u0006\r\r\u0001\u0011)\u0011\u0004\u0001b\u00015\t\u00111iQ\u000b\u00037)\n\"\u0001\b\u0011\u0011\u0005uqR\"A\u0007\n\u0005}i!a\u0002(pi\"Lgn\u001a\n\u0005C\r\u0002\u0004H\u0002\u0003#\u0001\u0001\u0001#\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004c\u0001\u0013(S5\tQE\u0003\u0002'\u0017\u0005A\u0001/\u0019:bY2,G.\u0003\u0002)K\t1\u0001+\u0019:TKR\u0004\"a\u0006\u0016\u0005\u000b-B\"\u0019\u0001\u0017\u0003\u0003a\u000b\"\u0001H\u0017\u0011\u0005uq\u0013BA\u0018\u000e\u0005\r\te.\u001f\u0019\u0003cY\u0002R\u0001\n\u001a*iUJ!aM\u0013\u0003\u0015A\u000b'oU3u\u0019&\\W\rE\u0002\u00181%\u0002\"a\u0006\u001c\u0005\u0013]B\u0012\u0011!A\u0001\u0006\u0003a#aA0%cA!1#O\u0015\u0017\u0013\tQ\u0014B\u0001\nHK:,'/[2QCJ$V-\u001c9mCR,\u0007cA\n=-%\u0011Q(\u0003\u0002\u0014\u000f\u0016tWM]5d!\u0006\u00148i\\7qC:LwN\\\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003\u0001\u00032a\u0005\u0001\u0017\u0003)qWm\u001e\"vS2$WM]\u000b\u0003\u0007\"+\u0012\u0001\u0012\t\u0005I\u0015;%*\u0003\u0002GK\tA1i\\7cS:,'\u000f\u0005\u0002\u0018\u0011\u0012)\u0011J\u0001b\u0001Y\t\t\u0011\tE\u0002\u00181\u001d\u000b1B\\3x\u0007>l'-\u001b8feV\u0011Q\nU\u000b\u0002\u001dB!A%R(R!\t9\u0002\u000bB\u0003J\u0007\t\u0007A\u0006E\u0002\u00181=\u0013QcR3oKJL7mQ1o\u0007>l'-\u001b8f\rJ|W.\u0006\u0002UCN\u0019A!\u0016-\u0011\u0005u1\u0016BA,\u000e\u0005\u0019\te.\u001f*fMB)1#W.aE&\u0011!,\u0003\u0002\u000f\u0007\u0006t7i\\7cS:,gI]8na\taf\fE\u0002\u00181u\u0003\"a\u00060\u0005\u0013}#\u0011\u0011!A\u0001\u0006\u0003a#aA0%eA\u0011q#\u0019\u0003\u0006\u0013\u0012\u0011\r\u0001\f\t\u0004/a\u0001G#\u00013\u0011\u0007\u0015$\u0001-D\u0001\u0001\u0003\u0015\t\u0007\u000f\u001d7z)\tA\u0017\u000e\u0005\u0003%\u000b\u0002\u0014\u0007\"\u00026\u0007\u0001\u0004Y\u0017\u0001\u00024s_6\u0004\"!\u001a7\n\u00055t'\u0001B\"pY2L!a\\\u0005\u0003!\u001d+g.\u001a:jG\u000e{W\u000e]1oS>tG#\u00015")
public abstract class ParSetFactory<CC extends ParSet<Object>>
extends GenSetFactory<CC>
implements GenericParCompanion<CC> {
    @Override
    public <A> Combiner<A, CC> newBuilder() {
        return this.newCombiner();
    }

    @Override
    public abstract <A> Combiner<A, CC> newCombiner();

    public class GenericCanCombineFrom<A>
    implements CanCombineFrom<CC, A, CC> {
        @Override
        public Combiner<A, CC> apply(CC from) {
            return from.genericCombiner();
        }

        @Override
        public Combiner<A, CC> apply() {
            return this.scala$collection$generic$ParSetFactory$GenericCanCombineFrom$$$outer().newCombiner();
        }

        public /* synthetic */ ParSetFactory scala$collection$generic$ParSetFactory$GenericCanCombineFrom$$$outer() {
            return ParSetFactory.this;
        }

        public GenericCanCombineFrom() {
            if (ParSetFactory.this == null) {
                throw null;
            }
        }
    }
}

