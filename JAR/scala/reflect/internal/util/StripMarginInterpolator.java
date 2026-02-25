/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.StringContext;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001I2q\u0001B\u0003\u0011\u0002\u0007\u0005a\u0002C\u0003\u0014\u0001\u0011\u0005A\u0003C\u0003\u0019\u0001\u0019\u0005\u0011\u0004C\u0003\u001e\u0001\u0011\u0015aDA\fTiJL\u0007/T1sO&t\u0017J\u001c;feB|G.\u0019;pe*\u0011aaB\u0001\u0005kRLGN\u0003\u0002\t\u0013\u0005A\u0011N\u001c;fe:\fGN\u0003\u0002\u000b\u0017\u00059!/\u001a4mK\u000e$(\"\u0001\u0007\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001a\u0004\t\u0003!Ei\u0011aC\u0005\u0003%-\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001\u0016!\t\u0001b#\u0003\u0002\u0018\u0017\t!QK\\5u\u00035\u0019HO]5oO\u000e{g\u000e^3yiV\t!\u0004\u0005\u0002\u00117%\u0011Ad\u0003\u0002\u000e'R\u0014\u0018N\\4D_:$X\r\u001f;\u0002\u0005MlGCA\u0010+!\t\u0001sE\u0004\u0002\"KA\u0011!eC\u0007\u0002G)\u0011A%D\u0001\u0007yI|w\u000e\u001e \n\u0005\u0019Z\u0011A\u0002)sK\u0012,g-\u0003\u0002)S\t11\u000b\u001e:j]\u001eT!AJ\u0006\t\u000b-\u001a\u0001\u0019\u0001\u0017\u0002\t\u0005\u0014xm\u001d\t\u0004!5z\u0013B\u0001\u0018\f\u0005)a$/\u001a9fCR,GM\u0010\t\u0003!AJ!!M\u0006\u0003\u0007\u0005s\u0017\u0010")
public interface StripMarginInterpolator {
    public StringContext stringContext();

    public static /* synthetic */ String sm$(StripMarginInterpolator $this, Seq args2) {
        return $this.sm(args2);
    }

    default public String sm(Seq<Object> args2) {
        List list;
        List list2 = this.stringContext().parts().toList();
        if (list2 instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)list2;
            String head = (String)$colon$colon.head();
            List tail = $colon$colon.tl$access$1();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            String string = new StringOps(head).stripMargin();
            list = tail.map((Function1<String, String> & java.io.Serializable & Serializable)s -> StripMarginInterpolator.stripTrailingPart$1(s), List$.MODULE$.canBuildFrom()).$colon$colon(string);
        } else if (((Object)Nil$.MODULE$).equals(list2)) {
            list = Nil$.MODULE$;
        } else {
            throw new MatchError(list2);
        }
        return new StringContext(list).raw(args2);
    }

    private static boolean isLineBreak$1(char c) {
        return c == '\n' || c == '\f';
    }

    public static /* synthetic */ boolean $anonfun$sm$1(char c) {
        return !StripMarginInterpolator.isLineBreak$1(c);
    }

    /*
     * WARNING - void declaration
     */
    private static String stripTrailingPart$1(String s) {
        void var2_5;
        void var1_4;
        void span_p;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Function1<Object, Object> & java.io.Serializable & Serializable intersect = (Function1<Object, Object> & java.io.Serializable & Serializable)c -> BoxesRunTime.boxToBoolean(StripMarginInterpolator.$anonfun$sm$1(BoxesRunTime.unboxToChar(c)));
        StringOps span_this = new StringOps(s);
        Tuple2 tuple2 = span_this.splitAt(span_this.prefixLength(span_p));
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        String pre = (String)tuple2._1();
        String post = (String)tuple2._2();
        void pre2 = var1_4;
        void post2 = var2_5;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringBuilder(0).append((String)pre2).append(new StringOps((String)post2).stripMargin()).toString();
    }

    public static void $init$(StripMarginInterpolator $this) {
    }
}

