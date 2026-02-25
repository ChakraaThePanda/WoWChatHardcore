/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Option;
import scala.Tuple2;
import scala.collection.$colon$plus$;
import scala.collection.SeqLike;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001Q:Q\u0001B\u0003\t\u0002)1Q\u0001D\u0003\t\u00025AQAE\u0001\u0005\u0002MAQ\u0001F\u0001\u0005\u0002U\t1\u0002J2pY>tG\u0005\u001d7vg*\u0011aaB\u0001\u000bG>dG.Z2uS>t'\"\u0001\u0005\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u00111\"A\u0007\u0002\u000b\tYAeY8m_:$\u0003\u000f\\;t'\t\ta\u0002\u0005\u0002\u0010!5\tq!\u0003\u0002\u0012\u000f\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#\u0001\u0006\u0002\u000fUt\u0017\r\u001d9msV\u0019a#K\u0010\u0015\u0005]y\u0003cA\b\u00195%\u0011\u0011d\u0002\u0002\u0007\u001fB$\u0018n\u001c8\u0011\t=YR\u0004K\u0005\u00039\u001d\u0011a\u0001V;qY\u0016\u0014\u0004C\u0001\u0010 \u0019\u0001!Q\u0001I\u0002C\u0002\u0005\u0012AaQ8mYF\u0011!%\n\t\u0003\u001f\rJ!\u0001J\u0004\u0003\u000f9{G\u000f[5oOB!1B\n\u0015\u001e\u0013\t9SAA\u0004TKFd\u0015n[3\u0011\u0005yIC!\u0002\u0016\u0004\u0005\u0004Y#!\u0001+\u0012\u0005\tb\u0003CA\b.\u0013\tqsAA\u0002B]fDQ\u0001M\u0002A\u0002E\n\u0011\u0001\u001e\n\u0004eu)c\u0001B\u001a\u0002\u0001E\u0012A\u0002\u0010:fM&tW-\\3oiz\u0002")
public final class $colon$plus {
    public static <T, Coll extends SeqLike<T, Coll>> Option<Tuple2<Coll, T>> unapply(Coll Coll) {
        return $colon$plus$.MODULE$.unapply(Coll);
    }
}

