/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.collection.GenTraversableLike;
import scala.collection.generic.IsTraversableLike$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001y3q!\u0003\u0006\u0011\u0002G\u0005\u0011\u0003B\u0003\u0018\u0001\t\u0005\u0001\u0004C\u0004 \u0001\t\u0007i\u0011\u0001\u0011\b\u000b9R\u0001\u0012A\u0018\u0007\u000b%Q\u0001\u0012A\u0019\t\u000bI\"A\u0011A\u001a\t\u000fQ\"!\u0019!C\u0002k!1\u0011\n\u0002Q\u0001\nYBQA\u0013\u0003\u0005\u0004-\u0013\u0011#S:Ue\u00064XM]:bE2,G*[6f\u0015\tYA\"A\u0004hK:,'/[2\u000b\u00055q\u0011AC2pY2,7\r^5p]*\tq\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005I13C\u0001\u0001\u0014!\t!R#D\u0001\u000f\u0013\t1bB\u0001\u0004B]f\u0014VM\u001a\u0002\u0002\u0003F\u0011\u0011\u0004\b\t\u0003)iI!a\u0007\b\u0003\u000f9{G\u000f[5oOB\u0011A#H\u0005\u0003=9\u00111!\u00118z\u0003)\u0019wN\u001c<feNLwN\\\u000b\u0002CA!AC\t\u0013)\u0013\t\u0019cBA\u0005Gk:\u001cG/[8ocA\u0011QE\n\u0007\u0001\t\u00159\u0003A1\u0001\u0019\u0005\u0011\u0011V\r\u001d:\u0011\t%RC\u0006J\u0007\u0002\u0019%\u00111\u0006\u0004\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u0019&\\W\r\u0005\u0002.\u00035\t\u0001!A\tJgR\u0013\u0018M^3sg\u0006\u0014G.\u001a'jW\u0016\u0004\"\u0001\r\u0003\u000e\u0003)\u0019\"\u0001B\n\u0002\rqJg.\u001b;?)\u0005y\u0013AC:ue&twMU3qeV\taG\u0005\u00028s\u0019!\u0001\b\u0002\u00017\u00051a$/\u001a4j]\u0016lWM\u001c;?!\r\u0001\u0004A\u000f\t\u0003w\ts!\u0001\u0010!\u0011\u0005urQ\"\u0001 \u000b\u0005}\u0002\u0012A\u0002\u001fs_>$h(\u0003\u0002B\u001d\u00051\u0001K]3eK\u001aL!a\u0011#\u0003\rM#(/\u001b8h\u0015\t\te\"\u0002\u0003\u0018o\u00012\u0005C\u0001\u000bH\u0013\tAeB\u0001\u0003DQ\u0006\u0014\u0018aC:ue&twMU3qe\u0002\nacZ3o)J\fg/\u001a:tC\ndW\rT5lKJ+\u0007O]\u000b\u0004\u0019F;FCA'[%\tquJ\u0002\u00039\t\u0001i\u0005c\u0001\u0019\u0001!B\u0019Q%\u0015,\u0005\u000bIC!\u0019A*\u0003\u0003\r+\"\u0001\u0007+\u0005\u000bU\u000b&\u0019\u0001\r\u0003\u0003}\u0003\"!J,\u0005\u000baC!\u0019\u0001\r\u0003\u0005\u0005\u0003T\u0001B\fO\u0001YCQa\u0017\u0005A\u0004q\u000bAaY8omB!AC\t)^!\u0011I#F\u0016)")
public interface IsTraversableLike<Repr> {
    public static <C, A0> IsTraversableLike<C> genTraversableLikeRepr(Function1<C, GenTraversableLike<A0, C>> function1) {
        if (IsTraversableLike$.MODULE$ == null) {
            throw null;
        }
        return new IsTraversableLike<C>(function1){
            private final Function1<C, GenTraversableLike<A0, C>> conversion;

            public Function1<C, GenTraversableLike<A0, C>> conversion() {
                return this.conversion;
            }
            {
                this.conversion = conv$1;
            }
        };
    }

    public static IsTraversableLike<String> stringRepr() {
        return IsTraversableLike$.MODULE$.stringRepr();
    }

    public Function1<Repr, GenTraversableLike<Object, Repr>> conversion();
}

