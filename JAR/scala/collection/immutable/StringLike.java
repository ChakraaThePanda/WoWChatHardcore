/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.regex.PatternSyntaxException;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableOnce;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.WrappedString;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Builder;
import scala.math.Ordered;
import scala.math.ScalaNumber;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichChar$;
import scala.runtime.RichInt$;
import scala.util.matching.Regex;

@ScalaSignature(bytes="\u0006\u0001\t=t!\u0002\u00192\u0011\u0003Ad!\u0002\u001e2\u0011\u0003Y\u0004\"\u0002!\u0002\t\u0003\t\u0005b\u0002\"\u0002\u0005\u0004%ia\u0011\u0005\u0007\r\u0006\u0001\u000bQ\u0002#\t\u000f\u001d\u000b!\u0019!C\u0007\u0011\"11*\u0001Q\u0001\u000e%Cq\u0001T\u0001C\u0002\u00135Q\n\u0003\u0004Q\u0003\u0001\u0006iA\u0014\u0005\b#\u0006\u0011\r\u0011\"\u0004S\u0011\u0019)\u0016\u0001)A\u0007'\u001a9!(\rI\u0001\u0004\u00031\u0006\"\u0002?\f\t\u0003i\b\u0002CA\u0002\u0017\u00016\t\"!\u0002\t\u000f\u0005M1\u0002\"\u0001\u0002\u0016!9\u0011\u0011E\u0006\u0005\u0002\u0005\r\u0002bBA\u0013\u0017\u0011\u0005\u0013q\u0005\u0005\b\u0003SYA\u0011IA\u0016\u0011\u001d\t)d\u0003C\u0001\u0003oAq!a\u000f\f\t\u0003\ni\u0004C\u0004\u0002D-!I!!\u0012\t\u000f\u0005E3\u0002\"\u0001\u0002(!9\u00111K\u0006\u0005\u0002\u0005U\u0003bBA/\u0017\u0011\u0005\u0011Q\u000b\u0005\b\u0003?ZA\u0011AA+\u0011\u001d\t\tg\u0003C\u0001\u0003OAq!a\u0019\f\t\u0003\t)\u0007C\u0004\u0002z-!\t!a\u001f\t\u000f\u0005\u00055\u0002\"\u0001\u0002\u0004\"9\u0011QR\u0006\u0005\u0002\u0005=\u0005bBAG\u0017\u0011\u0005\u0011q\u0005\u0005\b\u0003+[A\u0011BAL\u0011\u001d\tij\u0003C\u0001\u0003?Cq!!(\f\t\u0003\tY\u000bC\u0004\u0002N.!\t!a4\t\u000f\u000557\u0002\"\u0001\u0002`\"9\u00111^\u0006\u0005\u0002\u00055\bbBAx\u0017\u0011\u0005\u0011\u0011\u001f\u0005\b\u0003s\\A\u0011AA~\u0011\u001d\u0011\u0019a\u0003C\u0001\u0003GAqA!\u0002\f\t\u0003\u00119\u0001C\u0004\u0003\u0010-!\tA!\u0005\t\u000f\te1\u0002\"\u0001\u0003\u001c!9!1E\u0006\u0005\n\t\u0015\u0002b\u0002B\u0016\u0017\u0011\u0005#Q\u0006\u0005\b\u0005\u0017ZA\u0011\u0002B'\u0011\u001d\u0011\u0019f\u0003C\u0001\u0005+BqA!\u0018\f\t\u0003\u0011y&\u0001\u0006TiJLgn\u001a'jW\u0016T!AM\u001a\u0002\u0013%lW.\u001e;bE2,'B\u0001\u001b6\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002m\u0005)1oY1mC\u000e\u0001\u0001CA\u001d\u0002\u001b\u0005\t$AC*ue&tw\rT5lKN\u0011\u0011\u0001\u0010\t\u0003{yj\u0011!N\u0005\u0003\u007fU\u0012a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u00019\u0003\tae)F\u0001E\u001f\u0005)U$\u0001\u0006\u0002\u000713\u0005%\u0001\u0002G\rV\t\u0011jD\u0001K;\u0005a\u0011a\u0001$GA\u0005\u00111IU\u000b\u0002\u001d>\tq*H\u0001\u000e\u0003\r\u0019%\u000bI\u0001\u0003'V+\u0012aU\b\u0002)v\t!$A\u0002T+\u0002*\"a\u00163\u0014\t-A6L\u001b\t\u0003{eK!AW\u001b\u0003\u0007\u0005s\u0017\u0010\u0005\u0003];~\u0013W\"A\u001a\n\u0005y\u001b$aE%oI\u0016DX\rZ*fc>\u0003H/[7ju\u0016$\u0007CA\u001fa\u0013\t\tWG\u0001\u0003DQ\u0006\u0014\bCA2e\u0019\u0001!a!Z\u0006\u0005\u0006\u00041'\u0001\u0002*faJ\f\"a\u001a-\u0011\u0005uB\u0017BA56\u0005\u001dqu\u000e\u001e5j]\u001e\u00042a\u001b8r\u001d\tiD.\u0003\u0002nk\u00059\u0001/Y2lC\u001e,\u0017BA8q\u0005\u001dy%\u000fZ3sK\u0012T!!\\\u001b\u0011\u0005ILhBA:x!\t!X'D\u0001v\u0015\t1x'\u0001\u0004=e>|GOP\u0005\u0003qV\na\u0001\u0015:fI\u00164\u0017B\u0001>|\u0005\u0019\u0019FO]5oO*\u0011\u00010N\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003y\u0004\"!P@\n\u0007\u0005\u0005QG\u0001\u0003V]&$\u0018A\u00038fo\n+\u0018\u000e\u001c3feV\u0011\u0011q\u0001\t\u0007\u0003\u0013\tya\u00182\u000e\u0005\u0005-!bAA\u0007g\u00059Q.\u001e;bE2,\u0017\u0002BA\t\u0003\u0017\u0011qAQ;jY\u0012,'/A\u0003baBd\u0017\u0010F\u0002`\u0003/Aq!!\u0007\u000f\u0001\u0004\tY\"A\u0001o!\ri\u0014QD\u0005\u0004\u0003?)$aA%oi\u00061A.\u001a8hi\",\"!a\u0007\u0002\u00115\\7\u000b\u001e:j]\u001e,\u0012!]\u0001\u0006g2L7-\u001a\u000b\u0006E\u00065\u0012\u0011\u0007\u0005\b\u0003_\t\u0002\u0019AA\u000e\u0003\u00111'o\\7\t\u000f\u0005M\u0012\u00031\u0001\u0002\u001c\u0005)QO\u001c;jY\u00061A\u0005^5nKN$2!]A\u001d\u0011\u001d\tIB\u0005a\u0001\u00037\tqaY8na\u0006\u0014X\r\u0006\u0003\u0002\u001c\u0005}\u0002BBA!'\u0001\u0007\u0011/A\u0003pi\",'/A\u0006jg2Kg.\u001a\"sK\u0006\\G\u0003BA$\u0003\u001b\u00022!PA%\u0013\r\tY%\u000e\u0002\b\u0005>|G.Z1o\u0011\u0019\ty\u0005\u0006a\u0001?\u0006\t1-\u0001\u0007tiJL\u0007\u000fT5oK\u0016sG-A\nmS:,7oV5uQN+\u0007/\u0019:bi>\u00148/\u0006\u0002\u0002XA!A,!\u0017r\u0013\r\tYf\r\u0002\t\u0013R,'/\u0019;pe\u0006)A.\u001b8fg\u0006iA.\u001b8fg&#XM]1u_J\f!bY1qSR\fG.\u001b>f\u0003-\u0019HO]5q!J,g-\u001b=\u0015\t\u0005\u001d\u0014Q\u000f\t\u0005\u0003S\n\u0019(\u0004\u0002\u0002l)!\u0011QNA8\u0003\u0011a\u0017M\\4\u000b\u0005\u0005E\u0014\u0001\u00026bm\u0006L1A_A6\u0011\u0019\t9H\u0007a\u0001c\u00061\u0001O]3gSb\f1b\u001d;sSB\u001cVO\u001a4jqR!\u0011qMA?\u0011\u0019\tyh\u0007a\u0001c\u000611/\u001e4gSb\f1C]3qY\u0006\u001cW-\u00117m\u0019&$XM]1mYf$R!]AC\u0003\u0013Ca!a\"\u001d\u0001\u0004\t\u0018a\u00027ji\u0016\u0014\u0018\r\u001c\u0005\u0007\u0003\u0017c\u0002\u0019A9\u0002\u0017I,\u0007\u000f\\1dK6,g\u000e^\u0001\fgR\u0014\u0018\u000e]'be\u001eLg\u000eF\u0002r\u0003#Ca!a%\u001e\u0001\u0004y\u0016AC7be\u001eLgn\u00115be\u00061Qm]2ba\u0016$2!]AM\u0011\u0019\tYj\ba\u0001?\u0006\u00111\r[\u0001\u0006gBd\u0017\u000e\u001e\u000b\u0005\u0003C\u000b9\u000b\u0005\u0003>\u0003G\u000b\u0018bAASk\t)\u0011I\u001d:bs\"1\u0011\u0011\u0016\u0011A\u0002}\u000b\u0011b]3qCJ\fGo\u001c:\u0015\t\u0005\u0005\u0016Q\u0016\u0005\b\u0003_\u000b\u0003\u0019AAY\u0003)\u0019X\r]1sCR|'o\u001d\t\u0005{\u0005\rv\fK\u0003\"\u0003k\u000bY\rE\u0003>\u0003o\u000bY,C\u0002\u0002:V\u0012a\u0001\u001e5s_^\u001c\b\u0003BA_\u0003\u000fl!!a0\u000b\t\u0005\u0005\u00171Y\u0001\u0006e\u0016<W\r\u001f\u0006\u0005\u0003\u000b\fy'\u0001\u0003vi&d\u0017\u0002BAe\u0003\u007f\u0013a\u0003U1ui\u0016\u0014hnU=oi\u0006DX\t_2faRLwN\\\u0012\u0003\u0003w\u000b\u0011A]\u000b\u0003\u0003#\u0004B!a5\u0002\\6\u0011\u0011Q\u001b\u0006\u0005\u0003/\fI.\u0001\u0005nCR\u001c\u0007.\u001b8h\u0015\r\t)-N\u0005\u0005\u0003;\f)NA\u0003SK\u001e,\u0007\u0010\u0006\u0003\u0002R\u0006\u0005\bbBArG\u0001\u0007\u0011Q]\u0001\u000bOJ|W\u000f\u001d(b[\u0016\u001c\b\u0003B\u001f\u0002hFL1!!;6\u0005)a$/\u001a9fCR,GMP\u0001\ni>\u0014un\u001c7fC:,\"!a\u0012\u0002\rQ|')\u001f;f+\t\t\u0019\u0010E\u0002>\u0003kL1!a>6\u0005\u0011\u0011\u0015\u0010^3\u0002\u000fQ|7\u000b[8siV\u0011\u0011Q \t\u0004{\u0005}\u0018b\u0001B\u0001k\t)1\u000b[8si\u0006)Ao\\%oi\u00061Ao\u001c'p]\u001e,\"A!\u0003\u0011\u0007u\u0012Y!C\u0002\u0003\u000eU\u0012A\u0001T8oO\u00069Ao\u001c$m_\u0006$XC\u0001B\n!\ri$QC\u0005\u0004\u0005/)$!\u0002$m_\u0006$\u0018\u0001\u0003;p\t>,(\r\\3\u0016\u0005\tu\u0001cA\u001f\u0003 %\u0019!\u0011E\u001b\u0003\r\u0011{WO\u00197f\u00031\u0001\u0018M]:f\u0005>|G.Z1o)\u0011\t9Ea\n\t\r\t%2\u00061\u0001r\u0003\u0005\u0019\u0018a\u0002;p\u0003J\u0014\u0018-_\u000b\u0005\u0005_\u0011)\u0004\u0006\u0003\u00032\tm\u0002#B\u001f\u0002$\nM\u0002cA2\u00036\u00119!q\u0007\u0017C\u0002\te\"!\u0001\"\u0012\u0005}C\u0006\"\u0003B\u001fY\u0005\u0005\t9\u0001B \u0003))g/\u001b3f]\u000e,G%\r\t\u0007\u0005\u0003\u00129Ea\r\u000e\u0005\t\r#b\u0001B#k\u00059!/\u001a4mK\u000e$\u0018\u0002\u0002B%\u0005\u0007\u0012\u0001b\u00117bgN$\u0016mZ\u0001\nk:<(/\u00199Be\u001e$2\u0001\u0010B(\u0011\u0019\u0011\t&\fa\u00011\u0006\u0019\u0011M]4\u0002\r\u0019|'/\\1u)\r\t(q\u000b\u0005\b\u00053r\u0003\u0019\u0001B.\u0003\u0011\t'oZ:\u0011\tu\n9\u000fW\u0001\fM>\u0014X.\u0019;M_\u000e\fG\u000eF\u0003r\u0005C\u0012i\u0007C\u0004\u0003d=\u0002\rA!\u001a\u0002\u00031\u0004BAa\u001a\u0003j5\u0011\u00111Y\u0005\u0005\u0005W\n\u0019M\u0001\u0004M_\u000e\fG.\u001a\u0005\b\u00053z\u0003\u0019\u0001B.\u0001")
public interface StringLike<Repr>
extends IndexedSeqOptimized<Object, Repr>,
Ordered<String> {
    @Override
    public Builder<Object, Repr> newBuilder();

    public static /* synthetic */ char apply$(StringLike $this, int n) {
        return $this.apply(n);
    }

    @Override
    default public char apply(int n) {
        return this.toString().charAt(n);
    }

    public static /* synthetic */ int length$(StringLike $this) {
        return $this.length();
    }

    @Override
    default public int length() {
        return this.toString().length();
    }

    public static /* synthetic */ String mkString$(StringLike $this) {
        return $this.mkString();
    }

    @Override
    default public String mkString() {
        return this.toString();
    }

    public static /* synthetic */ Object slice$(StringLike $this, int from, int until) {
        return $this.slice(from, until);
    }

    @Override
    default public Repr slice(int from, int until) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int start = RichInt$.MODULE$.max$extension(from, 0);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int end = RichInt$.MODULE$.min$extension(until, this.length());
        if (start >= end) {
            return this.newBuilder().result();
        }
        String string = this.toString().substring(start, end);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return (Repr)((Builder)this.newBuilder().$plus$plus$eq(new StringOps(string))).result();
    }

    public static /* synthetic */ String $times$(StringLike $this, int n) {
        return $this.$times(n);
    }

    default public String $times(int n) {
        scala.collection.mutable.StringBuilder buf = new scala.collection.mutable.StringBuilder();
        int n2 = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        RichInt$.MODULE$.until$extension0(n2, n).foreach((Function1<Object, scala.collection.mutable.StringBuilder> & java.io.Serializable & Serializable)(Object i) -> buf.append(this.toString()));
        return buf.toString();
    }

    public static /* synthetic */ int compare$(StringLike $this, String other) {
        return $this.compare(other);
    }

    @Override
    default public int compare(String other) {
        return this.toString().compareTo(other);
    }

    public static /* synthetic */ boolean scala$collection$immutable$StringLike$$isLineBreak$(StringLike $this, char c) {
        return $this.scala$collection$immutable$StringLike$$isLineBreak(c);
    }

    default public boolean scala$collection$immutable$StringLike$$isLineBreak(char c) {
        return c == '\n' || c == '\f';
    }

    public static /* synthetic */ String stripLineEnd$(StringLike $this) {
        return $this.stripLineEnd();
    }

    default public String stripLineEnd() {
        int len = this.toString().length();
        if (len == 0) {
            return this.toString();
        }
        char last = this.apply(len - 1);
        if (this.scala$collection$immutable$StringLike$$isLineBreak(last)) {
            return this.toString().substring(0, last == '\n' && len >= 2 && this.apply(len - 2) == '\r' ? len - 2 : len - 1);
        }
        return this.toString();
    }

    public static /* synthetic */ Iterator linesWithSeparators$(StringLike $this) {
        return $this.linesWithSeparators();
    }

    default public Iterator<String> linesWithSeparators() {
        return new AbstractIterator<String>(this){
            private final String str;
            private final int len;
            private int index;
            private final /* synthetic */ StringLike $outer;

            private String str() {
                return this.str;
            }

            private int len() {
                return this.len;
            }

            private int index() {
                return this.index;
            }

            private void index_$eq(int x$1) {
                this.index = x$1;
            }

            public boolean hasNext() {
                return this.index() < this.len();
            }

            public String next() {
                if (this.index() >= this.len()) {
                    throw new NoSuchElementException("next on empty iterator");
                }
                int start = this.index();
                while (this.index() < this.len() && !this.$outer.scala$collection$immutable$StringLike$$isLineBreak(this.$outer.apply(this.index()))) {
                    this.index_$eq(this.index() + 1);
                }
                this.index_$eq(this.index() + 1);
                int n = this.index();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return this.str().substring(start, RichInt$.MODULE$.min$extension(n, this.len()));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.str = $outer.toString();
                this.len = this.str().length();
                this.index = 0;
            }
        };
    }

    public static /* synthetic */ Iterator lines$(StringLike $this) {
        return $this.lines();
    }

    default public Iterator<String> lines() {
        return this.linesWithSeparators().map((Function1<String, String> & java.io.Serializable & Serializable)line -> new WrappedString((String)line).stripLineEnd());
    }

    public static /* synthetic */ Iterator linesIterator$(StringLike $this) {
        return $this.linesIterator();
    }

    default public Iterator<String> linesIterator() {
        return this.linesWithSeparators().map((Function1<String, String> & java.io.Serializable & Serializable)line -> new WrappedString((String)line).stripLineEnd());
    }

    public static /* synthetic */ String capitalize$(StringLike $this) {
        return $this.capitalize();
    }

    default public String capitalize() {
        if (this.toString() == null) {
            return null;
        }
        if (this.toString().length() == 0) {
            return "";
        }
        char c = this.toString().charAt(0);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (RichChar$.MODULE$.isUpper$extension(c)) {
            return this.toString();
        }
        char[] chars = this.toString().toCharArray();
        char c2 = chars[0];
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        chars[0] = RichChar$.MODULE$.toUpper$extension(c2);
        return new String(chars);
    }

    public static /* synthetic */ String stripPrefix$(StringLike $this, String prefix) {
        return $this.stripPrefix(prefix);
    }

    default public String stripPrefix(String prefix) {
        if (this.toString().startsWith(prefix)) {
            return this.toString().substring(prefix.length());
        }
        return this.toString();
    }

    public static /* synthetic */ String stripSuffix$(StringLike $this, String suffix) {
        return $this.stripSuffix(suffix);
    }

    default public String stripSuffix(String suffix) {
        if (this.toString().endsWith(suffix)) {
            return this.toString().substring(0, this.toString().length() - suffix.length());
        }
        return this.toString();
    }

    public static /* synthetic */ String replaceAllLiterally$(StringLike $this, String literal, String replacement) {
        return $this.replaceAllLiterally(literal, replacement);
    }

    default public String replaceAllLiterally(String literal, String replacement) {
        return this.toString().replace(literal, replacement);
    }

    public static /* synthetic */ String stripMargin$(StringLike $this, char marginChar) {
        return $this.stripMargin(marginChar);
    }

    default public String stripMargin(char marginChar) {
        scala.collection.mutable.StringBuilder buf = new scala.collection.mutable.StringBuilder();
        this.linesWithSeparators().foreach((Function1<String, scala.collection.mutable.StringBuilder> & java.io.Serializable & Serializable)line -> {
            int index;
            int len = line.length();
            for (index = 0; index < len && line.charAt(index) <= ' '; ++index) {
            }
            return buf.append(index < len && line.charAt(index) == marginChar ? line.substring(index + 1) : line);
        });
        return buf.toString();
    }

    public static /* synthetic */ String stripMargin$(StringLike $this) {
        return $this.stripMargin();
    }

    default public String stripMargin() {
        return this.stripMargin('|');
    }

    private String escape(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9') {
            return ((Object)BoxesRunTime.boxToCharacter(ch)).toString();
        }
        return new StringBuilder(1).append("\\").append(ch).toString();
    }

    public static /* synthetic */ String[] split$(StringLike $this, char separator) {
        return $this.split(separator);
    }

    default public String[] split(char separator) {
        return this.toString().split(this.escape(separator));
    }

    public static /* synthetic */ String[] split$(StringLike $this, char[] separators) {
        return $this.split(separators);
    }

    /*
     * WARNING - void declaration
     */
    default public String[] split(char[] separators) throws PatternSyntaxException {
        void foldLeft_foldl_end;
        void foldLeft_z;
        StringBuilder stringBuilder = new StringBuilder(1);
        String string = "[";
        ArrayOps.ofChar foldLeft_this = new ArrayOps.ofChar(Predef$.MODULE$.charArrayOps(separators));
        void var7_4 = foldLeft_z;
        int n = foldLeft_this.length();
        for (int foldLeft_foldl_start = 0; foldLeft_foldl_start != foldLeft_foldl_end; ++foldLeft_foldl_start) {
            String foldLeft_foldl_z;
            Object a = foldLeft_this.apply(foldLeft_foldl_start);
            void var8_7 = foldLeft_foldl_z;
            foldLeft_foldl_z = StringLike.$anonfun$split$1(this, (String)var8_7, BoxesRunTime.unboxToChar(a));
        }
        String re = stringBuilder.append((String)var7_4).append("]").toString();
        return this.toString().split(re);
    }

    public static /* synthetic */ Regex r$(StringLike $this) {
        return $this.r();
    }

    default public Regex r() {
        return this.r(Nil$.MODULE$);
    }

    public static /* synthetic */ Regex r$(StringLike $this, Seq groupNames) {
        return $this.r(groupNames);
    }

    default public Regex r(Seq<String> groupNames) {
        return new Regex(this.toString(), groupNames);
    }

    public static /* synthetic */ boolean toBoolean$(StringLike $this) {
        return $this.toBoolean();
    }

    default public boolean toBoolean() {
        return this.parseBoolean(this.toString());
    }

    public static /* synthetic */ byte toByte$(StringLike $this) {
        return $this.toByte();
    }

    default public byte toByte() {
        return Byte.parseByte(this.toString());
    }

    public static /* synthetic */ short toShort$(StringLike $this) {
        return $this.toShort();
    }

    default public short toShort() {
        return Short.parseShort(this.toString());
    }

    public static /* synthetic */ int toInt$(StringLike $this) {
        return $this.toInt();
    }

    default public int toInt() {
        return Integer.parseInt(this.toString());
    }

    public static /* synthetic */ long toLong$(StringLike $this) {
        return $this.toLong();
    }

    default public long toLong() {
        return Long.parseLong(this.toString());
    }

    public static /* synthetic */ float toFloat$(StringLike $this) {
        return $this.toFloat();
    }

    default public float toFloat() {
        return Float.parseFloat(this.toString());
    }

    public static /* synthetic */ double toDouble$(StringLike $this) {
        return $this.toDouble();
    }

    default public double toDouble() {
        return Double.parseDouble(this.toString());
    }

    private boolean parseBoolean(String s) {
        if (s != null) {
            boolean bl;
            String string = s.toLowerCase();
            if ("true".equals(string)) {
                bl = true;
            } else if ("false".equals(string)) {
                bl = false;
            } else {
                throw new IllegalArgumentException(new StringBuilder(20).append("For input string: \"").append(s).append("\"").toString());
            }
            return bl;
        }
        throw new IllegalArgumentException("For input string: \"null\"");
    }

    public static /* synthetic */ Object toArray$(StringLike $this, ClassTag evidence$1) {
        return $this.toArray(evidence$1);
    }

    @Override
    default public <B> Object toArray(ClassTag<B> evidence$1) {
        return this.toString().toCharArray();
    }

    private Object unwrapArg(Object arg) {
        Object object = arg instanceof ScalaNumber ? ((ScalaNumber)arg).underlying() : arg;
        return object;
    }

    public static /* synthetic */ String format$(StringLike $this, Seq args2) {
        return $this.format(args2);
    }

    default public String format(Seq<Object> args2) {
        return String.format(this.toString(), (Object[])((TraversableOnce)args2.map((Function1<Object, Object> & java.io.Serializable & Serializable)arg -> this.unwrapArg(arg), Seq$.MODULE$.canBuildFrom())).toArray(ClassTag$.MODULE$.AnyRef()));
    }

    public static /* synthetic */ String formatLocal$(StringLike $this, Locale l, Seq args2) {
        return $this.formatLocal(l, args2);
    }

    default public String formatLocal(Locale l, Seq<Object> args2) {
        return String.format(l, this.toString(), (Object[])((TraversableOnce)args2.map((Function1<Object, Object> & java.io.Serializable & Serializable)arg -> this.unwrapArg(arg), Seq$.MODULE$.canBuildFrom())).toArray(ClassTag$.MODULE$.AnyRef()));
    }

    public static /* synthetic */ String $anonfun$split$1(StringLike $this, String x$1, char x$2) {
        return new StringBuilder(0).append(x$1).append($this.escape(x$2)).toString();
    }

    public static void $init$(StringLike $this) {
    }
}

