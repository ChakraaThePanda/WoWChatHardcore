/*
 * Decompiled with CFR 0.152.
 */
package scala.util.hashing;

import scala.reflect.ScalaSignature;
import scala.runtime.Statics;
import scala.util.hashing.ByteswapHashing$;
import scala.util.hashing.Hashing;
import scala.util.hashing.package$;

@ScalaSignature(bytes="\u0006\u0001a3A\u0001D\u0007\u0003)!)\u0011\u0006\u0001C\u0001U!)A\u0006\u0001C\u0001[\u001d)1'\u0004E\u0001i\u0019)A\"\u0004E\u0001k!)\u0011\u0006\u0002C\u0001s\u0019!!\b\u0002\u0003<\u0011!\u0001eA!A!\u0002\u0013i\u0004\"B\u0015\u0007\t\u0003\t\u0005\"\u0002\u0017\u0007\t\u0003)\u0005\"B$\u0005\t\u0003A\u0005b\u0002(\u0005\u0003\u0003%Ia\u0014\u0002\u0010\u0005f$Xm]<ba\"\u000b7\u000f[5oO*\u0011abD\u0001\bQ\u0006\u001c\b.\u001b8h\u0015\t\u0001\u0012#\u0001\u0003vi&d'\"\u0001\n\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011Q\u0003I\n\u0004\u0001YQ\u0002CA\f\u0019\u001b\u0005\t\u0012BA\r\u0012\u0005\u0019\te.\u001f*fMB\u00191\u0004\b\u0010\u000e\u00035I!!H\u0007\u0003\u000f!\u000b7\u000f[5oOB\u0011q\u0004\t\u0007\u0001\t\u0015\t\u0003A1\u0001#\u0005\u0005!\u0016CA\u0012'!\t9B%\u0003\u0002&#\t9aj\u001c;iS:<\u0007CA\f(\u0013\tA\u0013CA\u0002B]f\fa\u0001P5oSRtD#A\u0016\u0011\u0007m\u0001a$\u0001\u0003iCNDGC\u0001\u00182!\t9r&\u0003\u00021#\t\u0019\u0011J\u001c;\t\u000bI\u0012\u0001\u0019\u0001\u0010\u0002\u0003Y\fqBQ=uKN<\u0018\r\u001d%bg\"Lgn\u001a\t\u00037\u0011\u00192\u0001\u0002\f7!\t9r'\u0003\u00029#\ta1+\u001a:jC2L'0\u00192mKR\tAGA\u0004DQ\u0006Lg.\u001a3\u0016\u0005qz4c\u0001\u0004\u0017{A\u00191\u0004\b \u0011\u0005}yD!B\u0011\u0007\u0005\u0004\u0011\u0013!\u00015\u0015\u0005\t#\u0005cA\"\u0007}5\tA\u0001C\u0003A\u0011\u0001\u0007Q\b\u0006\u0002/\r\")!'\u0003a\u0001}\u0005)1\r[1j]V\u0011\u0011\n\u0014\u000b\u0003\u00156\u00032a\u0007\u000fL!\tyB\nB\u0003\"\u0015\t\u0007!\u0005C\u0003A\u0015\u0001\u0007!*A\u0006sK\u0006$'+Z:pYZ,G#\u0001)\u0011\u0005E3V\"\u0001*\u000b\u0005M#\u0016\u0001\u00027b]\u001eT\u0011!V\u0001\u0005U\u00064\u0018-\u0003\u0002X%\n1qJ\u00196fGR\u0004")
public final class ByteswapHashing<T>
implements Hashing<T> {
    public static <T> Hashing<T> chain(Hashing<T> hashing) {
        return ByteswapHashing$.MODULE$.chain(hashing);
    }

    @Override
    public int hash(T v) {
        return package$.MODULE$.byteswap32(Statics.anyHash(v));
    }

    public static class Chained<T>
    implements Hashing<T> {
        private final Hashing<T> h;

        @Override
        public int hash(T v) {
            return package$.MODULE$.byteswap32(this.h.hash(v));
        }

        public Chained(Hashing<T> h) {
            this.h = h;
        }
    }
}

