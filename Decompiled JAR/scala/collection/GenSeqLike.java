/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Equals;
import scala.Function1;
import scala.Function2;
import scala.Serializable;
import scala.collection.GenIterableLike;
import scala.collection.GenSeq;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001\t\u001dda\u0002\u0012$!\u0003\r\t\u0001\u000b\u0005\u0006\u0013\u0002!\tA\u0013\u0005\u0006\u001d\u00021\ta\u0014\u0005\u0006'\u00021\t\u0001\u0016\u0005\u00065\u00021\ta\u0017\u0005\u00069\u0002!\t!\u0018\u0005\u0006E\u00021\ta\u0019\u0005\u0006W\u0002!\t\u0001\u001c\u0005\u0006]\u00021\ta\u001c\u0005\u0006]\u0002!\tA\u001d\u0005\u0006i\u0002!\t!\u001e\u0005\u0006i\u0002!\t! \u0005\b\u0003\u000f\u0001A\u0011AA\u0005\u0011\u001d\t9\u0001\u0001C\u0001\u0003'Aq!!\t\u0001\t\u0003\t\u0019\u0003C\u0004\u0002\"\u00011\t!a\n\t\u000f\u00055\u0002A\"\u0001\u00020!9\u0011\u0011\u0007\u0001\u0007\u0002\u0005M\u0002bBA-\u0001\u0011\u0005\u00111\f\u0005\b\u00033\u0002a\u0011AA7\u0011\u001d\ti\b\u0001D\u0001\u0003\u007fBq!a#\u0001\r\u0003\ti\tC\u0004\u0002*\u00021\t!a+\t\u000f\u0005\r\u0007A\"\u0001\u0002F\"9\u0011\u0011\u001c\u0001\u0007\u0002\u0005m\u0007bBAx\u0001\u0019\u0005\u0011\u0011\u001f\u0005\b\u0005\u0013\u0001a\u0011\u0001B\u0006\u0011\u001d\u0011\t\u0003\u0001D\u0001\u0005GAqAa\n\u0001\t\u0003\u0011I\u0003C\u0004\u0003@\u00011\tA!\u0011\t\u000f\t5\u0003A\"\u0001\u0003P!9!1\f\u0001\u0007\u0002\u0005=\u0002b\u0002B/\u0001\u0011\u0005#q\f\u0005\b\u0005C\u0002A\u0011\tB2\u0005)9UM\\*fc2K7.\u001a\u0006\u0003I\u0015\n!bY8mY\u0016\u001cG/[8o\u0015\u00051\u0013!B:dC2\f7\u0001A\u000b\u0004SQZ4#\u0002\u0001+]u\u0002\u0005CA\u0016-\u001b\u0005)\u0013BA\u0017&\u0005\r\te.\u001f\t\u0005_A\u0012$(D\u0001$\u0013\t\t4EA\bHK:LE/\u001a:bE2,G*[6f!\t\u0019D\u0007\u0004\u0001\u0005\rU\u0002AQ1\u00017\u0005\u0005\t\u0015CA\u001c+!\tY\u0003(\u0003\u0002:K\t9aj\u001c;iS:<\u0007CA\u001a<\t\u0019a\u0004\u0001\"b\u0001m\t!!+\u001a9s!\tYc(\u0003\u0002@K\t1Q)];bYN\u0004BaL!3\u0007&\u0011!i\t\u0002\u000f!\u0006\u0014\u0018\r\u001c7fY&T\u0018M\u00197f!\r!uIM\u0007\u0002\u000b*\u0011aiI\u0001\ta\u0006\u0014\u0018\r\u001c7fY&\u0011\u0001*\u0012\u0002\u0007!\u0006\u00148+Z9\u0002\r\u0011Jg.\u001b;%)\u0005Y\u0005CA\u0016M\u0013\tiUE\u0001\u0003V]&$\u0018aA:fcV\t\u0001\u000bE\u00020#JJ!AU\u0012\u0003\u0007M+\u0017/A\u0003baBd\u0017\u0010\u0006\u00023+\")ak\u0001a\u0001/\u0006\u0019\u0011\u000e\u001a=\u0011\u0005-B\u0016BA-&\u0005\rIe\u000e^\u0001\u0007Y\u0016tw\r\u001e5\u0016\u0003]\u000b1\"[:EK\u001aLg.\u001a3BiR\u0011a,\u0019\t\u0003W}K!\u0001Y\u0013\u0003\u000f\t{w\u000e\\3b]\")a+\u0002a\u0001/\u0006i1/Z4nK:$H*\u001a8hi\"$2a\u00163j\u0011\u0015)g\u00011\u0001g\u0003\u0005\u0001\b\u0003B\u0016heyK!\u0001[\u0013\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\"\u00026\u0007\u0001\u00049\u0016\u0001\u00024s_6\fA\u0002\u001d:fM&DH*\u001a8hi\"$\"aV7\t\u000b\u0015<\u0001\u0019\u00014\u0002\u0015%tG-\u001a=XQ\u0016\u0014X\rF\u0002XaFDQ!\u001a\u0005A\u0002\u0019DQA\u001b\u0005A\u0002]#\"aV:\t\u000b\u0015L\u0001\u0019\u00014\u0002\u000f%tG-\u001a=PMV\u0011aO\u001f\u000b\u0003/^DQ\u0001\u001f\u0006A\u0002e\fA!\u001a7f[B\u00111G\u001f\u0003\u0006w*\u0011\r\u0001 \u0002\u0002\u0005F\u0011!GK\u000b\u0004}\u0006\rA\u0003B,\u0000\u0003\u000bAa\u0001_\u0006A\u0002\u0005\u0005\u0001cA\u001a\u0002\u0004\u0011)1p\u0003b\u0001y\")!n\u0003a\u0001/\u0006YA.Y:u\u0013:$W\r_(g+\u0011\tY!!\u0005\u0015\u0007]\u000bi\u0001\u0003\u0004y\u0019\u0001\u0007\u0011q\u0002\t\u0004g\u0005EA!B>\r\u0005\u0004aX\u0003BA\u000b\u00037!RaVA\f\u0003;Aa\u0001_\u0007A\u0002\u0005e\u0001cA\u001a\u0002\u001c\u0011)10\u0004b\u0001y\"1\u0011qD\u0007A\u0002]\u000b1!\u001a8e\u00039a\u0017m\u001d;J]\u0012,\u0007p\u00165fe\u0016$2aVA\u0013\u0011\u0015)g\u00021\u0001g)\u00159\u0016\u0011FA\u0016\u0011\u0015)w\u00021\u0001g\u0011\u0019\tyb\u0004a\u0001/\u00069!/\u001a<feN,W#\u0001\u001e\u0002\u0015I,g/\u001a:tK6\u000b\u0007/\u0006\u0004\u00026\u0005E\u00131\b\u000b\u0005\u0003o\t\u0019\u0006\u0006\u0003\u0002:\u0005}\u0002cA\u001a\u0002<\u00111\u0011QH\tC\u0002Y\u0012A\u0001\u00165bi\"9\u0011\u0011I\tA\u0004\u0005\r\u0013A\u00012g!%\t)%a\u0013;\u0003\u001f\nI$\u0004\u0002\u0002H)\u0019\u0011\u0011J\u0012\u0002\u000f\u001d,g.\u001a:jG&!\u0011QJA$\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\r\u0019\u0014\u0011\u000b\u0003\u0006wF\u0011\rA\u000e\u0005\b\u0003+\n\u0002\u0019AA,\u0003\u00051\u0007#B\u0016he\u0005=\u0013AC:uCJ$8oV5uQV!\u0011QLA6)\rq\u0016q\f\u0005\b\u0003C\u0012\u0002\u0019AA2\u0003\u0011!\b.\u0019;\u0011\u000b=\n)'!\u001b\n\u0007\u0005\u001d4E\u0001\u0004HK:\u001cV-\u001d\t\u0004g\u0005-D!B>\u0013\u0005\u00041T\u0003BA8\u0003o\"RAXA9\u0003sBq!!\u0019\u0014\u0001\u0004\t\u0019\bE\u00030\u0003K\n)\bE\u00024\u0003o\"Qa_\nC\u0002YBa!a\u001f\u0014\u0001\u00049\u0016AB8gMN,G/\u0001\u0005f]\u0012\u001cx+\u001b;i+\u0011\t\t)!#\u0015\u0007y\u000b\u0019\tC\u0004\u0002bQ\u0001\r!!\"\u0011\u000b=\n)'a\"\u0011\u0007M\nI\tB\u0003|)\t\u0007a'A\u0003qCR\u001c\u0007.\u0006\u0004\u0002\u0010\u0006u\u0015Q\u0013\u000b\t\u0003#\u000by*!)\u0002&R!\u00111SAL!\r\u0019\u0014Q\u0013\u0003\u0007\u0003{)\"\u0019\u0001\u001c\t\u000f\u0005\u0005S\u0003q\u0001\u0002\u001aBI\u0011QIA&u\u0005m\u00151\u0013\t\u0004g\u0005uE!B>\u0016\u0005\u0004a\b\"\u00026\u0016\u0001\u00049\u0006bBAF+\u0001\u0007\u00111\u0015\t\u0006_\u0005\u0015\u00141\u0014\u0005\u0007\u0003O+\u0002\u0019A,\u0002\u0011I,\u0007\u000f\\1dK\u0012\fq!\u001e9eCR,G-\u0006\u0004\u0002.\u0006m\u00161\u0017\u000b\u0007\u0003_\u000bi,!1\u0015\t\u0005E\u0016Q\u0017\t\u0004g\u0005MFABA\u001f-\t\u0007a\u0007C\u0004\u0002BY\u0001\u001d!a.\u0011\u0013\u0005\u0015\u00131\n\u001e\u0002:\u0006E\u0006cA\u001a\u0002<\u0012)1P\u0006b\u0001y\"1\u0011q\u0018\fA\u0002]\u000bQ!\u001b8eKbDa\u0001\u001f\fA\u0002\u0005e\u0016a\u0003\u0013qYV\u001cHeY8m_:,b!a2\u0002V\u00065G\u0003BAe\u0003/$B!a3\u0002PB\u00191'!4\u0005\r\u0005urC1\u00017\u0011\u001d\t\te\u0006a\u0002\u0003#\u0004\u0012\"!\u0012\u0002Li\n\u0019.a3\u0011\u0007M\n)\u000eB\u0003|/\t\u0007A\u0010\u0003\u0004y/\u0001\u0007\u00111[\u0001\fI\r|Gn\u001c8%a2,8/\u0006\u0004\u0002^\u0006-\u00181\u001d\u000b\u0005\u0003?\fi\u000f\u0006\u0003\u0002b\u0006\u0015\bcA\u001a\u0002d\u00121\u0011Q\b\rC\u0002YBq!!\u0011\u0019\u0001\b\t9\u000fE\u0005\u0002F\u0005-#(!;\u0002bB\u00191'a;\u0005\u000bmD\"\u0019\u0001?\t\raD\u0002\u0019AAu\u0003\u0015\u0001\u0018\r\u001a+p+\u0019\t\u0019P!\u0001\u0002zR1\u0011Q\u001fB\u0002\u0005\u000f!B!a>\u0002|B\u00191'!?\u0005\r\u0005u\u0012D1\u00017\u0011\u001d\t\t%\u0007a\u0002\u0003{\u0004\u0012\"!\u0012\u0002Li\ny0a>\u0011\u0007M\u0012\t\u0001B\u0003|3\t\u0007A\u0010\u0003\u0004\u0003\u0006e\u0001\raV\u0001\u0004Y\u0016t\u0007B\u0002=\u001a\u0001\u0004\ty0A\u0006d_J\u0014Xm\u001d9p]\u0012\u001cX\u0003\u0002B\u0007\u00057!BAa\u0004\u0003\u001eQ\u0019aL!\u0005\t\r\u0015T\u0002\u0019\u0001B\n!\u001dY#Q\u0003\u001a\u0003\u001ayK1Aa\u0006&\u0005%1UO\\2uS>t'\u0007E\u00024\u00057!Qa\u001f\u000eC\u0002YBq!!\u0019\u001b\u0001\u0004\u0011y\u0002E\u00030\u0003K\u0012I\"A\u0003u_N+\u0017/\u0006\u0002\u0003&A!q&!\u001a3\u0003\u0015)h.[8o+\u0019\u0011YC!\u000f\u00032Q!!Q\u0006B\u001e)\u0011\u0011yCa\r\u0011\u0007M\u0012\t\u0004\u0002\u0004\u0002>q\u0011\rA\u000e\u0005\b\u0003\u0003b\u00029\u0001B\u001b!%\t)%a\u0013;\u0005o\u0011y\u0003E\u00024\u0005s!Qa\u001f\u000fC\u0002qDq!!\u0019\u001d\u0001\u0004\u0011i\u0004E\u00030\u0003K\u00129$\u0001\u0003eS\u001a4W\u0003\u0002B\"\u0005\u0017\"2A\u000fB#\u0011\u001d\t\t'\ba\u0001\u0005\u000f\u0002RaLA3\u0005\u0013\u00022a\rB&\t\u0015YXD1\u0001}\u0003%Ig\u000e^3sg\u0016\u001cG/\u0006\u0003\u0003R\teCc\u0001\u001e\u0003T!9\u0011\u0011\r\u0010A\u0002\tU\u0003#B\u0018\u0002f\t]\u0003cA\u001a\u0003Z\u0011)1P\bb\u0001y\u0006AA-[:uS:\u001cG/\u0001\u0005iCND7i\u001c3f)\u00059\u0016AB3rk\u0006d7\u000fF\u0002_\u0005KBa!!\u0019\"\u0001\u0004Q\u0003")
public interface GenSeqLike<A, Repr>
extends GenIterableLike<A, Repr>,
Equals {
    @Override
    public Seq<A> seq();

    public A apply(int var1);

    public int length();

    public static /* synthetic */ boolean isDefinedAt$(GenSeqLike $this, int idx) {
        return $this.isDefinedAt(idx);
    }

    default public boolean isDefinedAt(int idx) {
        return idx >= 0 && idx < this.length();
    }

    public int segmentLength(Function1<A, Object> var1, int var2);

    public static /* synthetic */ int prefixLength$(GenSeqLike $this, Function1 p) {
        return $this.prefixLength(p);
    }

    default public int prefixLength(Function1<A, Object> p) {
        return this.segmentLength(p, 0);
    }

    public int indexWhere(Function1<A, Object> var1, int var2);

    public static /* synthetic */ int indexWhere$(GenSeqLike $this, Function1 p) {
        return $this.indexWhere(p);
    }

    default public int indexWhere(Function1<A, Object> p) {
        return this.indexWhere(p, 0);
    }

    public static /* synthetic */ int indexOf$(GenSeqLike $this, Object elem) {
        return $this.indexOf(elem);
    }

    default public <B> int indexOf(B elem) {
        return this.indexOf(elem, 0);
    }

    public static /* synthetic */ int indexOf$(GenSeqLike $this, Object elem, int from) {
        return $this.indexOf(elem, from);
    }

    default public <B> int indexOf(B elem, int from) {
        return this.indexWhere((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(GenSeqLike.$anonfun$indexOf$1(elem, x$1)), from);
    }

    public static /* synthetic */ int lastIndexOf$(GenSeqLike $this, Object elem) {
        return $this.lastIndexOf(elem);
    }

    default public <B> int lastIndexOf(B elem) {
        return this.lastIndexWhere((Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(GenSeqLike.$anonfun$lastIndexOf$1(elem, x$2)));
    }

    public static /* synthetic */ int lastIndexOf$(GenSeqLike $this, Object elem, int end) {
        return $this.lastIndexOf(elem, end);
    }

    default public <B> int lastIndexOf(B elem, int end) {
        return this.lastIndexWhere((Function1<Object, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(GenSeqLike.$anonfun$lastIndexOf$2(elem, x$3)), end);
    }

    public static /* synthetic */ int lastIndexWhere$(GenSeqLike $this, Function1 p) {
        return $this.lastIndexWhere(p);
    }

    default public int lastIndexWhere(Function1<A, Object> p) {
        return this.lastIndexWhere(p, this.length() - 1);
    }

    public int lastIndexWhere(Function1<A, Object> var1, int var2);

    public Repr reverse();

    public <B, That> That reverseMap(Function1<A, B> var1, CanBuildFrom<Repr, B, That> var2);

    public static /* synthetic */ boolean startsWith$(GenSeqLike $this, GenSeq that) {
        return $this.startsWith(that);
    }

    default public <B> boolean startsWith(GenSeq<B> that) {
        return this.startsWith(that, 0);
    }

    public <B> boolean startsWith(GenSeq<B> var1, int var2);

    public <B> boolean endsWith(GenSeq<B> var1);

    public <B, That> That patch(int var1, GenSeq<B> var2, int var3, CanBuildFrom<Repr, B, That> var4);

    public <B, That> That updated(int var1, B var2, CanBuildFrom<Repr, B, That> var3);

    public <B, That> That $plus$colon(B var1, CanBuildFrom<Repr, B, That> var2);

    public <B, That> That $colon$plus(B var1, CanBuildFrom<Repr, B, That> var2);

    public <B, That> That padTo(int var1, B var2, CanBuildFrom<Repr, B, That> var3);

    public <B> boolean corresponds(GenSeq<B> var1, Function2<A, B, Object> var2);

    @Override
    public GenSeq<A> toSeq();

    public static /* synthetic */ Object union$(GenSeqLike $this, GenSeq that, CanBuildFrom bf) {
        return $this.union(that, bf);
    }

    default public <B, That> That union(GenSeq<B> that, CanBuildFrom<Repr, B, That> bf) {
        return this.$plus$plus(that, bf);
    }

    public <B> Repr diff(GenSeq<B> var1);

    public <B> Repr intersect(GenSeq<B> var1);

    public Repr distinct();

    public static /* synthetic */ int hashCode$(GenSeqLike $this) {
        return $this.hashCode();
    }

    default public int hashCode() {
        return MurmurHash3$.MODULE$.seqHash(this.seq());
    }

    public static /* synthetic */ boolean equals$(GenSeqLike $this, Object that) {
        return $this.equals(that);
    }

    @Override
    default public boolean equals(Object that) {
        GenSeq genSeq;
        boolean bl = that instanceof GenSeq ? (genSeq = (GenSeq)that) == this || genSeq.canEqual(this) && this.sameElements(genSeq) : false;
        return bl;
    }

    public static /* synthetic */ boolean $anonfun$indexOf$1(Object elem$1, Object x$1) {
        return BoxesRunTime.equals(elem$1, x$1);
    }

    public static /* synthetic */ boolean $anonfun$lastIndexOf$1(Object elem$2, Object x$2) {
        return BoxesRunTime.equals(elem$2, x$2);
    }

    public static /* synthetic */ boolean $anonfun$lastIndexOf$2(Object elem$3, Object x$3) {
        return BoxesRunTime.equals(elem$3, x$3);
    }

    public static void $init$(GenSeqLike $this) {
    }
}

