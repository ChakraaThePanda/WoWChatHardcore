/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Tuple2;
import scala.collection.GenMap;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;
import scala.collection.mutable.MapBuilder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}4QAC\u0006\u0002\u0002IAQ\u0001\u0007\u0001\u0005\u0002e)AA\u000f\u0001\u0001w!)1\t\u0001D\u0001\t\")1\n\u0001C\u0001\u0019\")1\f\u0001C\u00019\u001a!!\u000e\u0001\u0001l\u0011\u0015Ab\u0001\"\u0001y\u0011\u0015Ye\u0001\"\u0001{\u0011\u0015Ye\u0001\"\u0001\u007f\u000559UM\\'ba\u001a\u000b7\r^8ss*\u0011A\"D\u0001\bO\u0016tWM]5d\u0015\tqq\"\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001E\u0001\u0006g\u000e\fG.Y\u0002\u0001+\t\u0019bd\u0005\u0002\u0001)A\u0011QCF\u0007\u0002\u001f%\u0011qc\u0004\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005Q\u0002cA\u000e\u000195\t1\u0002\u0005\u0002\u001e=1\u0001A!B\u0010\u0001\u0005\u0004\u0001#AA\"D+\r\tS\u0006N\t\u0003E\u0015\u0002\"!F\u0012\n\u0005\u0011z!a\u0002(pi\"Lgn\u001a\n\u0004M!2d\u0001B\u0014\u0001\u0001\u0015\u0012A\u0002\u0010:fM&tW-\\3oiz\u0002B!\u000b\u0016-g5\tQ\"\u0003\u0002,\u001b\t1q)\u001a8NCB\u0004\"!H\u0017\u0005\u000b9r\"\u0019A\u0018\u0003\u0003\u0005\u000b\"A\t\u0019\u0011\u0005U\t\u0014B\u0001\u001a\u0010\u0005\r\te.\u001f\t\u0003;Q\"Q!\u000e\u0010C\u0002=\u0012\u0011A\u0011\t\u0006S]b3'O\u0005\u0003q5\u0011!bR3o\u001b\u0006\u0004H*[6f!\u0011ib\u0004L\u001a\u0003\t\r{G\u000e\u001c\u0019\u0004yy\n\u0005\u0003B\u000f\u001f{\u0001\u0003\"!\b \u0005\u0013}\u0012\u0011\u0011!A\u0001\u0006\u0003y#aA0%cA\u0011Q$\u0011\u0003\n\u0005\n\t\t\u0011!A\u0003\u0002=\u00121a\u0018\u00133\u0003\u0015)W\u000e\u001d;z+\r)\u0005JS\u000b\u0002\rB!QDH$J!\ti\u0002\nB\u0003/\u0007\t\u0007q\u0006\u0005\u0002\u001e\u0015\u0012)Qg\u0001b\u0001_\u0005)\u0011\r\u001d9msV\u0019Q\n\u0015*\u0015\u00059\u001b\u0006\u0003B\u000f\u001f\u001fF\u0003\"!\b)\u0005\u000b9\"!\u0019A\u0018\u0011\u0005u\u0011F!B\u001b\u0005\u0005\u0004y\u0003\"\u0002+\u0005\u0001\u0004)\u0016!B3mK6\u001c\bcA\u000bW1&\u0011qk\u0004\u0002\u000byI,\u0007/Z1uK\u0012t\u0004\u0003B\u000bZ\u001fFK!AW\b\u0003\rQ+\b\u000f\\33\u0003)qWm\u001e\"vS2$WM]\u000b\u0004;\u001aDW#\u00010\u0011\t}\u0013G-[\u0007\u0002A*\u0011\u0011-D\u0001\b[V$\u0018M\u00197f\u0013\t\u0019\u0007MA\u0004Ck&dG-\u001a:\u0011\tUIVm\u001a\t\u0003;\u0019$QAL\u0003C\u0002=\u0002\"!\b5\u0005\u000bU*!\u0019A\u0018\u0011\tuqRm\u001a\u0002\u0010\u001b\u0006\u00048)\u00198Ck&dGM\u0012:p[V\u0019A\u000e\u001e<\u0014\u0007\u0019!R\u000eE\u0003\u001c]B\u0014x/\u0003\u0002p\u0017\ta1)\u00198Ck&dGM\u0012:p[B\u0011\u0011OA\u0007\u0002\u0001A!Q#W:v!\tiB\u000fB\u0003/\r\t\u0007q\u0006\u0005\u0002\u001em\u0012)QG\u0002b\u0001_A!QDH:v)\u0005I\b\u0003B9\u0007gV$\"a\u001f?\u0011\t}\u0013'o\u001e\u0005\u0006{\"\u0001\r\u0001]\u0001\u0005MJ|W\u000eF\u0001|\u0001")
public abstract class GenMapFactory<CC extends GenMap<Object, Object>> {
    public abstract <A, B> CC empty();

    public <A, B> CC apply(Seq<Tuple2<A, B>> elems) {
        return (CC)((GenMap)((Builder)this.newBuilder().$plus$plus$eq(elems)).result());
    }

    public <A, B> Builder<Tuple2<A, B>, CC> newBuilder() {
        return new MapBuilder(this.empty());
    }

    public class MapCanBuildFrom<A, B>
    implements CanBuildFrom<CC, Tuple2<A, B>, CC> {
        @Override
        public Builder<Tuple2<A, B>, CC> apply(CC from) {
            return this.scala$collection$generic$GenMapFactory$MapCanBuildFrom$$$outer().newBuilder();
        }

        @Override
        public Builder<Tuple2<A, B>, CC> apply() {
            return this.scala$collection$generic$GenMapFactory$MapCanBuildFrom$$$outer().newBuilder();
        }

        public /* synthetic */ GenMapFactory scala$collection$generic$GenMapFactory$MapCanBuildFrom$$$outer() {
            return GenMapFactory.this;
        }

        public MapCanBuildFrom() {
            if (GenMapFactory.this == null) {
                throw null;
            }
        }
    }
}

