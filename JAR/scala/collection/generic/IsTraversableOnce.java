/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.collection.GenTraversableOnce;
import scala.collection.generic.IsTraversableOnce$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001y3q!\u0003\u0006\u0011\u0002G\u0005\u0011\u0003B\u0003\u0018\u0001\t\u0005\u0001\u0004C\u0004 \u0001\t\u0007i\u0011\u0001\u0011\b\u000b9R\u0001\u0012A\u0018\u0007\u000b%Q\u0001\u0012A\u0019\t\u000bI\"A\u0011A\u001a\t\u000fQ\"!\u0019!C\u0002k!1\u0011\n\u0002Q\u0001\nYBQA\u0013\u0003\u0005\u0004-\u0013\u0011#S:Ue\u00064XM]:bE2,wJ\\2f\u0015\tYA\"A\u0004hK:,'/[2\u000b\u00055q\u0011AC2pY2,7\r^5p]*\tq\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005I13C\u0001\u0001\u0014!\t!R#D\u0001\u000f\u0013\t1bB\u0001\u0004B]f\u0014VM\u001a\u0002\u0002\u0003F\u0011\u0011\u0004\b\t\u0003)iI!a\u0007\b\u0003\u000f9{G\u000f[5oOB\u0011A#H\u0005\u0003=9\u00111!\u00118z\u0003)\u0019wN\u001c<feNLwN\\\u000b\u0002CA!AC\t\u0013)\u0013\t\u0019cBA\u0005Gk:\u001cG/[8ocA\u0011QE\n\u0007\u0001\t\u00159\u0003A1\u0001\u0019\u0005\u0011\u0011V\r\u001d:\u0011\u0007%RC&D\u0001\r\u0013\tYCB\u0001\nHK:$&/\u0019<feN\f'\r\\3P]\u000e,\u0007CA\u0017\u0002\u001b\u0005\u0001\u0011!E%t)J\fg/\u001a:tC\ndWm\u00148dKB\u0011\u0001\u0007B\u0007\u0002\u0015M\u0011AaE\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003=\n!b\u001d;sS:<'+\u001a9s+\u00051$CA\u001c:\r\u0011AD\u0001\u0001\u001c\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0007A\u0002!\b\u0005\u0002<\u0005:\u0011A\b\u0011\t\u0003{9i\u0011A\u0010\u0006\u0003\u007fA\ta\u0001\u0010:p_Rt\u0014BA!\u000f\u0003\u0019\u0001&/\u001a3fM&\u00111\t\u0012\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005\u0005sQ\u0001B\f8A\u0019\u0003\"\u0001F$\n\u0005!s!\u0001B\"iCJ\f1b\u001d;sS:<'+\u001a9sA\u00051r-\u001a8Ue\u00064XM]:bE2,G*[6f%\u0016\u0004(/F\u0002M#^#\"!\u0014.\u0013\u00059{e\u0001\u0002\u001d\u0005\u00015\u00032\u0001\r\u0001Q!\r)\u0013K\u0016\u0003\u0006%\"\u0011\ra\u0015\u0002\u0002\u0007V\u0011\u0001\u0004\u0016\u0003\u0006+F\u0013\r\u0001\u0007\u0002\u0002?B\u0011Qe\u0016\u0003\u00061\"\u0011\r\u0001\u0007\u0002\u0003\u0003B*Aa\u0006(\u0001-\")1\f\u0003a\u00029\u0006!1m\u001c8w!\u0011!\"\u0005U/\u0011\u0007%Rc\u000b")
public interface IsTraversableOnce<Repr> {
    public static <C, A0> IsTraversableOnce<C> genTraversableLikeRepr(Function1<C, GenTraversableOnce<A0>> function1) {
        if (IsTraversableOnce$.MODULE$ == null) {
            throw null;
        }
        return new IsTraversableOnce<C>(function1){
            private final Function1<C, GenTraversableOnce<A0>> conversion;

            public Function1<C, GenTraversableOnce<A0>> conversion() {
                return this.conversion;
            }
            {
                this.conversion = conv$1;
            }
        };
    }

    public static IsTraversableOnce<String> stringRepr() {
        return IsTraversableOnce$.MODULE$.stringRepr();
    }

    public Function1<Repr, GenTraversableOnce<Object>> conversion();
}

