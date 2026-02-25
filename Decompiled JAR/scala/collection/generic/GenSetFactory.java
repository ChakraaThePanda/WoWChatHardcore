/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.GenSet;
import scala.collection.Set;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u001d4Q\u0001B\u0003\u0002\u00021AQA\f\u0001\u0005\u0002=BQ!\r\u0001\u0007\u0002IBQA\u0010\u0001\u0005\u0002}\u0012QbR3o'\u0016$h)Y2u_JL(B\u0001\u0004\b\u0003\u001d9WM\\3sS\u000eT!\u0001C\u0005\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u000b\u0003\u0015\u00198-\u00197b\u0007\u0001)\"!\u0004\u000b\u0014\u0005\u0001q\u0001cA\b\u0011%5\tQ!\u0003\u0002\u0012\u000b\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\u001c\t\u0003'Qa\u0001\u0001B\u0003\u0016\u0001\t\u0007aC\u0001\u0002D\u0007V\u0011q\u0003J\t\u00031q\u0001\"!\u0007\u000e\u000e\u0003%I!aG\u0005\u0003\u000f9{G\u000f[5oOJ\u0019Qd\b\u0016\u0007\ty\u0001\u0001\u0001\b\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0004A\u0005\u001aS\"A\u0004\n\u0005\t:!AB$f]N+G\u000f\u0005\u0002\u0014I\u0011)Q\u0005\u0006b\u0001M\t\t\u0001,\u0005\u0002\u0019OA\u0011\u0011\u0004K\u0005\u0003S%\u00111!\u00118z!\u0011\u00013fI\u0017\n\u00051:!AC$f]N+G\u000fT5lKB\u00191\u0003F\u0012\u0002\rqJg.\u001b;?)\u0005\u0001\u0004cA\b\u0001%\u0005Qa.Z<Ck&dG-\u001a:\u0016\u0005MZT#\u0001\u001b\u0011\tUB$(P\u0007\u0002m)\u0011qgB\u0001\b[V$\u0018M\u00197f\u0013\tIdGA\u0004Ck&dG-\u001a:\u0011\u0005MYD!\u0002\u001f\u0003\u0005\u00041#!A!\u0011\u0007M!\"(A\btKR\u001c\u0015M\u001c\"vS2$gI]8n+\t\u00015+F\u0001B%\r\u00115I\u0012\u0004\u0005=\r\u0001\u0011\t\u0005\u0002\u001a\t&\u0011Q)\u0003\u0002\u0007\u0003:L(+\u001a4\u0011\u000b=9\u0015*\u001a4\n\u0005!+!\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007G\u0001&M!\r\u0019Bc\u0013\t\u0003'1#\u0011\"\u0014(\u0002\u0002\u0003\u0005)\u0011\u0001\u0014\u0003\u0007}#\u0013G\u0002\u0003P\u0007\t\u0001&!\u0002\u0013b]>t7c\u0001(D#B)qbR%S)B\u00111c\u0015\u0003\u0006y\r\u0011\rA\n\t\u0004'Q\u0011\u0006\"\u0002\u0018O\t\u00031F#A,\u0011\u0005Mq\u0005\"B-O\t\u0003Q\u0016!B1qa2LHCA.]!\u0011)\u0004H\u0015+\t\u000buC\u0006\u0019\u00010\u0002\t\u0019\u0014x.\u001c\u0019\u0003?\u0006\u00042a\u0005\u000ba!\t\u0019\u0012\rB\u0005c9\u0006\u0005\t\u0011!B\u0001M\t\u0019q\f\n\u001a\t\u000besE\u0011\u00013\u0015\u0003m\u0003\"aE*\u0011\u0007M!R\r")
public abstract class GenSetFactory<CC extends GenSet<Object>>
extends GenericCompanion<CC> {
    @Override
    public abstract <A> Builder<A, CC> newBuilder();

    public <A> CanBuildFrom<CC, A, CC> setCanBuildFrom() {
        return new CanBuildFrom<CC, A, CC>(this){
            private final /* synthetic */ GenSetFactory $outer;

            public Builder<A, CC> apply(CC from) {
                Builder<Object, CC> builder = from instanceof Set ? from.genericBuilder() : this.$outer.newBuilder();
                return builder;
            }

            public Builder<A, CC> apply() {
                return this.$outer.newBuilder();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        };
    }
}

