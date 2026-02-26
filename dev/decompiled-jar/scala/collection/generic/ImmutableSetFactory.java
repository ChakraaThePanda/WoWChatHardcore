/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.generic.SetFactory;
import scala.collection.immutable.Set;
import scala.collection.mutable.Builder;
import scala.collection.mutable.SetBuilder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001-3Q!\u0002\u0004\u0002\u00025AQA\r\u0001\u0005\u0002MBa!\u000e\u0001\u0007\u0002!1\u0004\"\u0002\u001d\u0001\t\u0003J\u0004\"B \u0001\t\u0003\u0001%aE%n[V$\u0018M\u00197f'\u0016$h)Y2u_JL(BA\u0004\t\u0003\u001d9WM\\3sS\u000eT!!\u0003\u0006\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\f\u0003\u0015\u00198-\u00197b\u0007\u0001)\"AD\u000b\u0014\u0005\u0001y\u0001c\u0001\t\u0012'5\ta!\u0003\u0002\u0013\r\tQ1+\u001a;GC\u000e$xN]=\u0011\u0005Q)B\u0002\u0001\u0003\u0006-\u0001\u0011\ra\u0006\u0002\u0003\u0007\u000e+\"\u0001G\u0014\u0012\u0005ei\u0002C\u0001\u000e\u001c\u001b\u0005Q\u0011B\u0001\u000f\u000b\u0005\u001dqu\u000e\u001e5j]\u001e\u00142A\b\u0011.\r\u0011y\u0002\u0001A\u000f\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0007\u0005\"c%D\u0001#\u0015\t\u0019\u0003\"A\u0005j[6,H/\u00192mK&\u0011QE\t\u0002\u0004'\u0016$\bC\u0001\u000b(\t\u0015ASC1\u0001*\u0005\u0005A\u0016CA\r+!\tQ2&\u0003\u0002-\u0015\t\u0019\u0011I\\=\u0011\t9zc%M\u0007\u0002\u0011%\u0011\u0001\u0007\u0003\u0002\b'\u0016$H*[6f!\r!RCJ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003Q\u00022\u0001\u0005\u0001\u0014\u00035)W\u000e\u001d;z\u0013:\u001cH/\u00198dKV\tq\u0007E\u0002\u0015+)\nQ!Z7qif,\"AO\u001f\u0016\u0003m\u00022\u0001F\u000b=!\t!R\bB\u0003?\u0007\t\u0007\u0011FA\u0001B\u0003)qWm\u001e\"vS2$WM]\u000b\u0003\u0003&+\u0012A\u0011\t\u0005\u0007\u001aC%*D\u0001E\u0015\t)\u0005\"A\u0004nkR\f'\r\\3\n\u0005\u001d#%a\u0002\"vS2$WM\u001d\t\u0003)%#QA\u0010\u0003C\u0002%\u00022\u0001F\u000bI\u0001")
public abstract class ImmutableSetFactory<CC extends Set<Object>>
extends SetFactory<CC> {
    public abstract CC emptyInstance();

    @Override
    public <A> CC empty() {
        return this.emptyInstance();
    }

    @Override
    public <A> Builder<A, CC> newBuilder() {
        return new SetBuilder(this.empty());
    }
}

