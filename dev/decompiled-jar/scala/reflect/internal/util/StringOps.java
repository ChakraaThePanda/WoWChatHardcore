/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichChar$;

@ScalaSignature(bytes="\u0006\u0001\u0005=ba\u0002\n\u0014!\u0003\r\t\u0001\b\u0005\u0006C\u0001!\tA\t\u0005\u0006M\u0001!\ta\n\u0005\u0006}\u0001!\ta\u0010\u0005\u0006\u0003\u0002!\tA\u0011\u0005\u0006\u0017\u0002!\t\u0001\u0014\u0005\u0006\u001f\u0002!\t\u0001\u0015\u0005\u0006%\u0002!\ta\u0015\u0005\u00067\u0002!\t\u0001\u0018\u0005\u0006=\u0002!\ta\u0018\u0005\bc\u0002\t\n\u0011\"\u0001s\u0011\u0015i\b\u0001\"\u0001\u007f\u0011!\ti\u0001AI\u0001\n\u0003\u0011\bbBA\b\u0001\u0011\u0005\u0011\u0011\u0003\u0005\b\u00037\u0001A\u0011AA\u000f\u000f\u001d\t\tc\u0005E\u0001\u0003G1aAE\n\t\u0002\u0005\u001d\u0002bBA\u0016!\u0011\u0005\u0011Q\u0006\u0002\n'R\u0014\u0018N\\4PaNT!\u0001F\u000b\u0002\tU$\u0018\u000e\u001c\u0006\u0003-]\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u00031e\tqA]3gY\u0016\u001cGOC\u0001\u001b\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001A\u000f\u0011\u0005yyR\"A\r\n\u0005\u0001J\"AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0002GA\u0011a\u0004J\u0005\u0003Ke\u0011A!\u00168ji\u00061q.Z7qif$\"\u0001K\u001d\u0011\u0007%bc&D\u0001+\u0015\tY\u0013$\u0001\u0006d_2dWm\u0019;j_:L!!\f\u0016\u0003\u0007M+\u0017\u000f\u0005\u00020m9\u0011\u0001\u0007\u000e\t\u0003cei\u0011A\r\u0006\u0003gm\ta\u0001\u0010:p_Rt\u0014BA\u001b\u001a\u0003\u0019\u0001&/\u001a3fM&\u0011q\u0007\u000f\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005UJ\u0002\"\u0002\u001e\u0003\u0001\u0004Y\u0014A\u0001=t!\rqBHL\u0005\u0003{e\u0011!\u0002\u0010:fa\u0016\fG/\u001a3?\u0003\u0015y'n\\5o)\tq\u0003\tC\u0003;\u0007\u0001\u00071(A\nm_:<Wm\u001d;D_6lwN\u001c)sK\u001aL\u0007\u0010\u0006\u0002/\u0007\")!\b\u0002a\u0001\tB\u0019Q\t\u0013\u0018\u000f\u0005y1\u0015BA$\u001a\u0003\u001d\u0001\u0018mY6bO\u0016L!!\u0013&\u0003\t1K7\u000f\u001e\u0006\u0003\u000ff\t\u0011\u0003\u001e:j[R\u0013\u0018-\u001b7j]\u001e\u001c\u0006/Y2f)\tqS\nC\u0003O\u000b\u0001\u0007a&A\u0001t\u0003Q!(/[7BY2$&/Y5mS:<7\u000b]1dKR\u0011a&\u0015\u0005\u0006\u001d\u001a\u0001\rAL\u0001\nI\u0016\u001cw.\u001c9pg\u0016$2\u0001\u0012+W\u0011\u0015)v\u00011\u0001/\u0003\r\u0019HO\u001d\u0005\u0006/\u001e\u0001\r\u0001W\u0001\u0004g\u0016\u0004\bC\u0001\u0010Z\u0013\tQ\u0016D\u0001\u0003DQ\u0006\u0014\u0018!B<pe\u0012\u001cHC\u0001#^\u0011\u0015)\u0006\u00021\u0001/\u0003)\u0019\b\u000f\\5u/\",'/\u001a\u000b\u0005A\u001a<w\u000eE\u0002\u001fC\u000eL!AY\r\u0003\r=\u0003H/[8o!\u0011qBM\f\u0018\n\u0005\u0015L\"A\u0002+va2,'\u0007C\u0003V\u0013\u0001\u0007a\u0006C\u0003i\u0013\u0001\u0007\u0011.A\u0001g!\u0011q\"\u000e\u00177\n\u0005-L\"!\u0003$v]\u000e$\u0018n\u001c82!\tqR.\u0003\u0002o3\t9!i\\8mK\u0006t\u0007b\u00029\n!\u0003\u0005\r\u0001\\\u0001\fI>$%o\u001c9J]\u0012,\u00070\u0001\u000bta2LGo\u00165fe\u0016$C-\u001a4bk2$HeM\u000b\u0002g*\u0012A\u000e^\u0016\u0002kB\u0011ao_\u0007\u0002o*\u0011\u00010_\u0001\nk:\u001c\u0007.Z2lK\u0012T!A_\r\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002}o\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u000fM\u0004H.\u001b;BiR1\u0001m`A\u0001\u0003\u0017AQ!V\u0006A\u00029Bq!a\u0001\f\u0001\u0004\t)!A\u0002jIb\u00042AHA\u0004\u0013\r\tI!\u0007\u0002\u0004\u0013:$\bb\u00029\f!\u0003\u0005\r\u0001\\\u0001\u0012gBd\u0017\u000e^!uI\u0011,g-Y;mi\u0012\u001a\u0014!F2pk:$X\t\\3nK:$8/Q:TiJLgn\u001a\u000b\u0006]\u0005M\u0011q\u0003\u0005\b\u0003+i\u0001\u0019AA\u0003\u0003\u0005q\u0007BBA\r\u001b\u0001\u0007a&A\u0004fY\u0016lWM\u001c;\u0002\u001b\r|WO\u001c;BgN#(/\u001b8h)\rq\u0013q\u0004\u0005\b\u0003+q\u0001\u0019AA\u0003\u0003%\u0019FO]5oO>\u00038\u000fE\u0002\u0002&Ai\u0011aE\n\u0005!u\tI\u0003E\u0002\u0002&\u0001\ta\u0001P5oSRtDCAA\u0012\u0001")
public interface StringOps {
    public static /* synthetic */ Seq oempty$(StringOps $this, Seq xs) {
        return $this.oempty(xs);
    }

    default public Seq<String> oempty(Seq<String> xs) {
        return (Seq)xs.filterNot((Function1<String, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(StringOps.$anonfun$oempty$1(x)));
    }

    public static /* synthetic */ String ojoin$(StringOps $this, Seq xs) {
        return $this.ojoin(xs);
    }

    default public String ojoin(Seq<String> xs) {
        return this.oempty(xs).mkString(" ");
    }

    public static /* synthetic */ String longestCommonPrefix$(StringOps $this, List xs) {
        return $this.longestCommonPrefix(xs);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public String longestCommonPrefix(List<String> xs) {
        if (((Object)Nil$.MODULE$).equals(xs)) {
            return "";
        }
        if (!(xs instanceof $colon$colon)) return StringOps.lcp$1(xs);
        $colon$colon $colon$colon = ($colon$colon)xs;
        String w = (String)$colon$colon.head();
        List list = $colon$colon.tl$access$1();
        if (!((Object)Nil$.MODULE$).equals(list)) return StringOps.lcp$1(xs);
        return w;
    }

    public static /* synthetic */ String trimTrailingSpace$(StringOps $this, String s) {
        return $this.trimTrailingSpace(s);
    }

    default public String trimTrailingSpace(String s) {
        int end;
        for (end = s.length(); end > 0; --end) {
            char c = s.charAt(end - 1);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (!RichChar$.MODULE$.isWhitespace$extension(c)) break;
        }
        if (end == s.length()) {
            return s;
        }
        return s.substring(0, end);
    }

    public static /* synthetic */ String trimAllTrailingSpace$(StringOps $this, String s) {
        return $this.trimAllTrailingSpace(s);
    }

    default public String trimAllTrailingSpace(String s2) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new scala.collection.immutable.StringOps(s2).linesIterator().map((Function1<String, String> & java.io.Serializable & Serializable)s -> this.trimTrailingSpace((String)s)).mkString(System.lineSeparator());
    }

    public static /* synthetic */ List decompose$(StringOps $this, String str, char sep) {
        return $this.decompose(str, sep);
    }

    default public List<String> decompose(String str, char sep) {
        return this.ws$1(0, str, sep);
    }

    public static /* synthetic */ List words$(StringOps $this, String str) {
        return $this.words(str);
    }

    default public List<String> words(String str) {
        return this.decompose(str, ' ');
    }

    public static /* synthetic */ Option splitWhere$(StringOps $this, String str, Function1 f, boolean doDropIndex) {
        return $this.splitWhere(str, f, doDropIndex);
    }

    default public Option<Tuple2<String, String>> splitWhere(String str, Function1<Object, Object> f, boolean doDropIndex) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return this.splitAt(str, new scala.collection.immutable.StringOps(str).indexWhere(f, 0), doDropIndex);
    }

    public static /* synthetic */ boolean splitWhere$default$3$(StringOps $this) {
        return $this.splitWhere$default$3();
    }

    default public boolean splitWhere$default$3() {
        return false;
    }

    public static /* synthetic */ Option splitAt$(StringOps $this, String str, int idx, boolean doDropIndex) {
        return $this.splitAt(str, idx, doDropIndex);
    }

    default public Option<Tuple2<String, String>> splitAt(String str, int idx, boolean doDropIndex) {
        if (idx == -1) {
            return None$.MODULE$;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new Some<Tuple2<String, String>>(new Tuple2<Object, Object>(new scala.collection.immutable.StringOps(str).take(idx), new scala.collection.immutable.StringOps(str).drop(doDropIndex ? idx + 1 : idx)));
    }

    public static /* synthetic */ boolean splitAt$default$3$(StringOps $this) {
        return $this.splitAt$default$3();
    }

    default public boolean splitAt$default$3() {
        return false;
    }

    public static /* synthetic */ String countElementsAsString$(StringOps $this, int n, String element) {
        return $this.countElementsAsString(n, element);
    }

    default public String countElementsAsString(int n, String element) {
        switch (n) {
            case 0: {
                return new StringBuilder(4).append("no ").append(element).append("s").toString();
            }
            case 1: {
                return new StringBuilder(4).append("one ").append(element).toString();
            }
        }
        return new StringBuilder(2).append(this.countAsString(n)).append(" ").append(element).append("s").toString();
    }

    public static /* synthetic */ String countAsString$(StringOps $this, int n) {
        return $this.countAsString(n);
    }

    default public String countAsString(int n) {
        switch (n) {
            case 0: {
                return "none";
            }
            case 1: {
                return "one";
            }
            case 2: {
                return "two";
            }
            case 3: {
                return "three";
            }
            case 4: {
                return "four";
            }
        }
        return Integer.toString(n);
    }

    public static /* synthetic */ boolean $anonfun$oempty$1(String x) {
        return x == null || x.equals("");
    }

    public static /* synthetic */ boolean $anonfun$longestCommonPrefix$1(String w$1, String s) {
        String string = s;
        String string2 = "";
        return string != null && string.equals(string2) || s.charAt(0) != w$1.charAt(0);
    }

    /*
     * WARNING - void declaration
     */
    private static String lcp$1(List ss) {
        boolean bl;
        void w;
        block6: {
            void var3_3;
            void var2_2;
            if (!(ss instanceof $colon$colon)) {
                throw new MatchError(ss);
            }
            $colon$colon $colon$colon = ($colon$colon)ss;
            String w2 = (String)$colon$colon.head();
            List ws = $colon$colon.tl$access$1();
            w = var2_2;
            void ws2 = var3_3;
            void v0 = w;
            String string = "";
            if (v0 != null && v0.equals(string)) {
                return "";
            }
            if (ws2 == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = ws2;
            while (!exists_these.isEmpty()) {
                String string2 = (String)exists_these.head();
                if (StringOps.$anonfun$longestCommonPrefix$1((String)w, string2)) {
                    bl = true;
                    break block6;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        if (bl) {
            return "";
        }
        return new StringBuilder(0).append(w.substring(0, 1)).append(StringOps.lcp$1(ss.map((Function1<String, String> & java.io.Serializable & Serializable)x$2 -> x$2.substring(1), List$.MODULE$.canBuildFrom()))).toString();
    }

    private List ws$1(int start, String str$1, char sep$1) {
        while (true) {
            if (start == str$1.length()) {
                return Nil$.MODULE$;
            }
            if (str$1.charAt(start) != sep$1) break;
            ++start;
        }
        int end = str$1.indexOf(sep$1, start);
        if (end < 0) {
            return new $colon$colon<Nothing$>((Nothing$)((Object)str$1.substring(start)), Nil$.MODULE$);
        }
        String string = str$1.substring(start, end);
        return this.ws$1(end + 1, str$1, sep$1).$colon$colon(string);
    }

    public static void $init$(StringOps $this) {
    }

    public static /* synthetic */ Object $anonfun$longestCommonPrefix$1$adapted(String w$1, String s) {
        return BoxesRunTime.boxToBoolean(StringOps.$anonfun$longestCommonPrefix$1(w$1, s));
    }
}

