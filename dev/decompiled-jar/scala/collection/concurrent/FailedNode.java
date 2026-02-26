/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import scala.Predef$;
import scala.collection.concurrent.MainNode;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\r3QAB\u0004\u0003\u000f5A\u0001b\t\u0001\u0003\u0002\u0003\u0006Ia\u0004\u0005\u0006I\u0001!\t!\n\u0005\u0006Q\u0001!\t!\u000b\u0005\u0006_\u0001!\t\u0001\r\u0005\u0006m\u0001!\te\u000e\u0002\u000b\r\u0006LG.\u001a3O_\u0012,'B\u0001\u0005\n\u0003)\u0019wN\\2veJ,g\u000e\u001e\u0006\u0003\u0015-\t!bY8mY\u0016\u001cG/[8o\u0015\u0005a\u0011!B:dC2\fWc\u0001\b\u0016CM\u0011\u0001a\u0004\t\u0005!E\u0019\u0002%D\u0001\b\u0013\t\u0011rA\u0001\u0005NC&tgj\u001c3f!\t!R\u0003\u0004\u0001\u0005\u000bY\u0001!\u0019\u0001\r\u0003\u0003-\u001b\u0001!\u0005\u0002\u001a;A\u0011!dG\u0007\u0002\u0017%\u0011Ad\u0003\u0002\b\u001d>$\b.\u001b8h!\tQb$\u0003\u0002 \u0017\t\u0019\u0011I\\=\u0011\u0005Q\tC!\u0002\u0012\u0001\u0005\u0004A\"!\u0001,\u0002\u0003A\fa\u0001P5oSRtDC\u0001\u0014(!\u0011\u0001\u0002a\u0005\u0011\t\u000b\r\u0012\u0001\u0019A\b\u0002\rM$(/\u001b8h)\tI\"\u0006C\u0003,\u0007\u0001\u0007A&A\u0002mKZ\u0004\"AG\u0017\n\u00059Z!aA%oi\u0006Q1-Y2iK\u0012\u001c\u0016N_3\u0015\u00051\n\u0004\"\u0002\u001a\u0005\u0001\u0004\u0019\u0014AA2u!\tQB'\u0003\u00026\u0017\t1\u0011I\\=SK\u001a\f\u0001\u0002^8TiJLgn\u001a\u000b\u0002qA\u0011\u0011\b\u0011\b\u0003uy\u0002\"aO\u0006\u000e\u0003qR!!P\f\u0002\rq\u0012xn\u001c;?\u0013\ty4\"\u0001\u0004Qe\u0016$WMZ\u0005\u0003\u0003\n\u0013aa\u0015;sS:<'BA \f\u0001")
public final class FailedNode<K, V>
extends MainNode<K, V> {
    private final MainNode<K, V> p;

    public Nothing$ string(int lev) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int cachedSize(Object ct) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        String string = "FailedNode(%s)";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.p}));
    }

    public FailedNode(MainNode<K, V> p) {
        this.p = p;
        this.WRITE_PREV(p);
    }
}

