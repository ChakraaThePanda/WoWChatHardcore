/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Function2;
import scala.Serializable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.IterableProxyLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.Range;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\r}ba\u0002\u00180!\u0003\r\t\u0001\u000e\u0005\u0006-\u0002!\ta\u0016\u0005\u00067\u0002!\t\u0005\u0018\u0005\u0006A\u0002!\t%\u0019\u0005\u0006E\u0002!\t\u0005\u0018\u0005\u0006G\u0002!\t\u0005\u001a\u0005\u0006O\u0002!\t\u0005\u001b\u0005\u0006W\u0002!\t\u0005\u001c\u0005\u0006e\u0002!\te\u001d\u0005\u0006w\u0002!\t\u0005 \u0005\u0006}\u0002!\te \u0005\u0007}\u0002!\t%a\u0001\t\u000f\u0005%\u0001\u0001\"\u0011\u0002\f!9\u0011\u0011\u0002\u0001\u0005B\u0005m\u0001bBA\u0014\u0001\u0011\u0005\u0013\u0011\u0006\u0005\b\u0003O\u0001A\u0011IA\u001a\u0011\u001d\t\t\u0005\u0001C!\u0003\u0007Bq!!\u0011\u0001\t\u0003\n9\u0005C\u0004\u0002N\u0001!\t%a\u0014\t\u000f\u0005E\u0003\u0001\"\u0011\u0002T!9\u0011\u0011\u0010\u0001\u0005B\u0005m\u0004bBAB\u0001\u0011\u0005\u0013Q\u0011\u0005\b\u0003\u0007\u0003A\u0011IAN\u0011\u001d\t9\u000b\u0001C!\u0003SCq!!.\u0001\t\u0003\n9\fC\u0004\u00026\u0002!\t%a1\t\u000f\u0005E\u0007\u0001\"\u0011\u0002T\"9\u0011\u0011\u001b\u0001\u0005B\u0005}\u0007bBAw\u0001\u0011\u0005\u0013q\u001e\u0005\b\u0003w\u0004A\u0011IA\u007f\u0011\u001d\u0011I\u0001\u0001C!\u0005\u0017AqA!\t\u0001\t\u0003\u0012\u0019\u0003C\u0004\u00030\u0001!\tE!\r\t\u000f\tu\u0002\u0001\"\u0011\u0002P!9!q\b\u0001\u0005B\t\u0005\u0003b\u0002B/\u0001\u0011\u0005#q\f\u0005\b\u0005o\u0002A\u0011\tB=\u0011\u001d\u0011i\t\u0001C!\u0005\u001fCqAa)\u0001\t\u0003\u0012)\u000bC\u0004\u0003<\u0002!\tE!0\t\u000f\tM\u0007\u0001\"\u0011\u0003V\"9!Q\u001c\u0001\u0005B\t}\u0007b\u0002B\u0000\u0001\u0011\u00053\u0011\u0001\u0005\b\u0007\u001b\u0001A\u0011IB\b\u0011\u001d\u00199\u0002\u0001C!\u00073Aqaa\u0006\u0001\t\u0003\u001a9C\u0001\u0007TKF\u0004&o\u001c=z\u0019&\\WM\u0003\u00021c\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003I\nQa]2bY\u0006\u001c\u0001!F\u00026\u0001*\u001bB\u0001\u0001\u001c;'B\u0011q\u0007O\u0007\u0002c%\u0011\u0011(\r\u0002\u0007\u0003:L(+\u001a4\u0011\tmbd(S\u0007\u0002_%\u0011Qh\f\u0002\b'\u0016\fH*[6f!\ty\u0004\t\u0004\u0001\u0005\r\u0005\u0003AQ1\u0001C\u0005\u0005\t\u0015CA\"G!\t9D)\u0003\u0002Fc\t9aj\u001c;iS:<\u0007CA\u001cH\u0013\tA\u0015GA\u0002B]f\u0004\"a\u0010&\u0005\r-\u0003AQ1\u0001M\u0005\u0011\u0011V\r\u001d:\u0012\u0005\rk%c\u0001(;!\u001a!q\n\u0001\u0001N\u00051a$/\u001a4j]\u0016lWM\u001c;?!\rY\u0014KP\u0005\u0003%>\u00121aU3r!\u0011YDKP%\n\u0005U{#!E%uKJ\f'\r\\3Qe>D\u0018\u0010T5lK\u00061A%\u001b8ji\u0012\"\u0012\u0001\u0017\t\u0003oeK!AW\u0019\u0003\tUs\u0017\u000e^\u0001\u0005g&TX-F\u0001^!\t9d,\u0003\u0002`c\t\u0019\u0011J\u001c;\u0002\u000bQ|7+Z9\u0016\u0003A\u000ba\u0001\\3oORD\u0017!B1qa2LHC\u0001 f\u0011\u00151W\u00011\u0001^\u0003\rIG\r_\u0001\u000eY\u0016tw\r\u001e5D_6\u0004\u0018M]3\u0015\u0005uK\u0007\"\u00026\u0007\u0001\u0004i\u0016a\u00017f]\u0006Y\u0011n\u001d#fM&tW\rZ!u)\ti\u0007\u000f\u0005\u00028]&\u0011q.\r\u0002\b\u0005>|G.Z1o\u0011\u0015\tx\u00011\u0001^\u0003\u0005A\u0018!D:fO6,g\u000e\u001e'f]\u001e$\b\u000eF\u0002^ifDQ!\u001e\u0005A\u0002Y\f\u0011\u0001\u001d\t\u0005o]tT.\u0003\u0002yc\tIa)\u001e8di&|g.\r\u0005\u0006u\"\u0001\r!X\u0001\u0005MJ|W.\u0001\u0007qe\u00164\u0017\u000e\u001f'f]\u001e$\b\u000e\u0006\u0002^{\")Q/\u0003a\u0001m\u0006Q\u0011N\u001c3fq^CWM]3\u0015\u0007u\u000b\t\u0001C\u0003v\u0015\u0001\u0007a\u000fF\u0003^\u0003\u000b\t9\u0001C\u0003v\u0017\u0001\u0007a\u000fC\u0003{\u0017\u0001\u0007Q,A\u0004j]\u0012,\u0007p\u00144\u0016\t\u00055\u0011Q\u0003\u000b\u0004;\u0006=\u0001bBA\t\u0019\u0001\u0007\u00111C\u0001\u0005K2,W\u000eE\u0002@\u0003+!q!a\u0006\r\u0005\u0004\tIBA\u0001C#\tqd)\u0006\u0003\u0002\u001e\u0005\rB#B/\u0002 \u0005\u0015\u0002bBA\t\u001b\u0001\u0007\u0011\u0011\u0005\t\u0004\u007f\u0005\rBaBA\f\u001b\t\u0007\u0011\u0011\u0004\u0005\u0006u6\u0001\r!X\u0001\fY\u0006\u001cH/\u00138eKb|e-\u0006\u0003\u0002,\u0005EBcA/\u0002.!9\u0011\u0011\u0003\bA\u0002\u0005=\u0002cA \u00022\u00119\u0011q\u0003\bC\u0002\u0005eQ\u0003BA\u001b\u0003w!R!XA\u001c\u0003{Aq!!\u0005\u0010\u0001\u0004\tI\u0004E\u0002@\u0003w!q!a\u0006\u0010\u0005\u0004\tI\u0002\u0003\u0004\u0002@=\u0001\r!X\u0001\u0004K:$\u0017A\u00047bgRLe\u000eZ3y/\",'/\u001a\u000b\u0004;\u0006\u0015\u0003\"B;\u0011\u0001\u00041H#B/\u0002J\u0005-\u0003\"B;\u0012\u0001\u00041\bBBA #\u0001\u0007Q,A\u0004sKZ,'o]3\u0016\u0003%\u000b!B]3wKJ\u001cX-T1q+\u0019\t)&!\u001d\u0002\\Q!\u0011qKA:)\u0011\tI&a\u0018\u0011\u0007}\nY\u0006\u0002\u0004\u0002^M\u0011\rA\u0011\u0002\u0005)\"\fG\u000fC\u0004\u0002bM\u0001\u001d!a\u0019\u0002\u0005\t4\u0007#CA3\u0003WJ\u0015qNA-\u001b\t\t9GC\u0002\u0002j=\nqaZ3oKJL7-\u0003\u0003\u0002n\u0005\u001d$\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007cA \u0002r\u00111\u0011qC\nC\u0002\tCq!!\u001e\u0014\u0001\u0004\t9(A\u0001g!\u00159tOPA8\u0003=\u0011XM^3sg\u0016LE/\u001a:bi>\u0014XCAA?!\u0011Y\u0014q\u0010 \n\u0007\u0005\u0005uF\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003)\u0019H/\u0019:ug^KG\u000f[\u000b\u0005\u0003\u000f\u000b)\nF\u0003n\u0003\u0013\u000b9\nC\u0004\u0002\fV\u0001\r!!$\u0002\tQD\u0017\r\u001e\t\u0006w\u0005=\u00151S\u0005\u0004\u0003#{#AB$f]N+\u0017\u000fE\u0002@\u0003+#a!a\u0006\u0016\u0005\u0004\u0011\u0005BBAM+\u0001\u0007Q,\u0001\u0004pM\u001a\u001cX\r^\u000b\u0005\u0003;\u000b)\u000bF\u0002n\u0003?Cq!a#\u0017\u0001\u0004\t\t\u000bE\u0003<\u0003\u001f\u000b\u0019\u000bE\u0002@\u0003K#a!a\u0006\u0017\u0005\u0004\u0011\u0015\u0001C3oIN<\u0016\u000e\u001e5\u0016\t\u0005-\u00161\u0017\u000b\u0004[\u00065\u0006bBAF/\u0001\u0007\u0011q\u0016\t\u0006w\u0005=\u0015\u0011\u0017\t\u0004\u007f\u0005MFABA\f/\t\u0007!)\u0001\u0007j]\u0012,\u0007p\u00144TY&\u001cW-\u0006\u0003\u0002:\u0006\u0005GcA/\u0002<\"9\u00111\u0012\rA\u0002\u0005u\u0006#B\u001e\u0002\u0010\u0006}\u0006cA \u0002B\u00129\u0011q\u0003\rC\u0002\u0005eQ\u0003BAc\u0003\u001b$R!XAd\u0003\u001fDq!a#\u001a\u0001\u0004\tI\rE\u0003<\u0003\u001f\u000bY\rE\u0002@\u0003\u001b$q!a\u0006\u001a\u0005\u0004\tI\u0002C\u0003{3\u0001\u0007Q,\u0001\tmCN$\u0018J\u001c3fq>37\u000b\\5dKV!\u0011Q[Ao)\ri\u0016q\u001b\u0005\b\u0003\u0017S\u0002\u0019AAm!\u0015Y\u0014qRAn!\ry\u0014Q\u001c\u0003\b\u0003/Q\"\u0019AA\r+\u0011\t\t/!;\u0015\u000bu\u000b\u0019/a;\t\u000f\u0005-5\u00041\u0001\u0002fB)1(a$\u0002hB\u0019q(!;\u0005\u000f\u0005]1D1\u0001\u0002\u001a!1\u0011qH\u000eA\u0002u\u000bQbY8oi\u0006Lgn]*mS\u000e,W\u0003BAy\u0003s$2!\\Az\u0011\u001d\tY\t\ba\u0001\u0003k\u0004RaOAH\u0003o\u00042aPA}\t\u0019\t9\u0002\bb\u0001\u0005\u0006A1m\u001c8uC&t7/\u0006\u0003\u0002\u0000\n\u0015AcA7\u0003\u0002!9\u0011\u0011C\u000fA\u0002\t\r\u0001cA \u0003\u0006\u00119!qA\u000fC\u0002\u0005e!AA!2\u0003\u0015)h.[8o+\u0019\u0011iAa\u0007\u0003\u0014Q!!q\u0002B\u000f)\u0011\u0011\tB!\u0006\u0011\u0007}\u0012\u0019\u0002\u0002\u0004\u0002^y\u0011\rA\u0011\u0005\b\u0003Cr\u00029\u0001B\f!%\t)'a\u001bJ\u00053\u0011\t\u0002E\u0002@\u00057!q!a\u0006\u001f\u0005\u0004\tI\u0002C\u0004\u0002\fz\u0001\rAa\b\u0011\u000bm\nyI!\u0007\u0002\t\u0011LgMZ\u000b\u0005\u0005K\u0011i\u0003F\u0002J\u0005OAq!a# \u0001\u0004\u0011I\u0003E\u0003<\u0003\u001f\u0013Y\u0003E\u0002@\u0005[!q!a\u0006 \u0005\u0004\tI\"A\u0005j]R,'o]3diV!!1\u0007B\u001e)\rI%Q\u0007\u0005\b\u0003\u0017\u0003\u0003\u0019\u0001B\u001c!\u0015Y\u0014q\u0012B\u001d!\ry$1\b\u0003\b\u0003/\u0001#\u0019AA\r\u0003!!\u0017n\u001d;j]\u000e$\u0018!\u00029bi\u000eDWC\u0002B\"\u0005#\u0012I\u0005\u0006\u0005\u0003F\tM#Q\u000bB-)\u0011\u00119Ea\u0013\u0011\u0007}\u0012I\u0005\u0002\u0004\u0002^\t\u0012\rA\u0011\u0005\b\u0003C\u0012\u00039\u0001B'!%\t)'a\u001bJ\u0005\u001f\u00129\u0005E\u0002@\u0005#\"q!a\u0006#\u0005\u0004\tI\u0002C\u0003{E\u0001\u0007Q\fC\u0004\u0003@\t\u0002\rAa\u0016\u0011\u000bm\nyIa\u0014\t\r\tm#\u00051\u0001^\u0003!\u0011X\r\u001d7bG\u0016$\u0017aB;qI\u0006$X\rZ\u000b\u0007\u0005C\u0012yGa\u001a\u0015\r\t\r$\u0011\u000fB;)\u0011\u0011)G!\u001b\u0011\u0007}\u00129\u0007\u0002\u0004\u0002^\r\u0012\rA\u0011\u0005\b\u0003C\u001a\u00039\u0001B6!%\t)'a\u001bJ\u0005[\u0012)\u0007E\u0002@\u0005_\"q!a\u0006$\u0005\u0004\tI\u0002\u0003\u0004\u0003t\r\u0002\r!X\u0001\u0006S:$W\r\u001f\u0005\b\u0003#\u0019\u0003\u0019\u0001B7\u0003-!\u0003\u000f\\;tI\r|Gn\u001c8\u0016\r\tm$\u0011\u0012BA)\u0011\u0011iHa#\u0015\t\t}$1\u0011\t\u0004\u007f\t\u0005EABA/I\t\u0007!\tC\u0004\u0002b\u0011\u0002\u001dA!\"\u0011\u0013\u0005\u0015\u00141N%\u0003\b\n}\u0004cA \u0003\n\u00129\u0011q\u0003\u0013C\u0002\u0005e\u0001bBA\tI\u0001\u0007!qQ\u0001\fI\r|Gn\u001c8%a2,8/\u0006\u0004\u0003\u0012\n}%q\u0013\u000b\u0005\u0005'\u0013\t\u000b\u0006\u0003\u0003\u0016\ne\u0005cA \u0003\u0018\u00121\u0011QL\u0013C\u0002\tCq!!\u0019&\u0001\b\u0011Y\nE\u0005\u0002f\u0005-\u0014J!(\u0003\u0016B\u0019qHa(\u0005\u000f\u0005]QE1\u0001\u0002\u001a!9\u0011\u0011C\u0013A\u0002\tu\u0015!\u00029bIR{WC\u0002BT\u0005k\u0013i\u000b\u0006\u0004\u0003*\n]&\u0011\u0018\u000b\u0005\u0005W\u0013y\u000bE\u0002@\u0005[#a!!\u0018'\u0005\u0004\u0011\u0005bBA1M\u0001\u000f!\u0011\u0017\t\n\u0003K\nY'\u0013BZ\u0005W\u00032a\u0010B[\t\u001d\t9B\nb\u0001\u00033AQA\u001b\u0014A\u0002uCq!!\u0005'\u0001\u0004\u0011\u0019,A\u0006d_J\u0014Xm\u001d9p]\u0012\u001cX\u0003\u0002B`\u0005\u001b$BA!1\u0003PR\u0019QNa1\t\rU<\u0003\u0019\u0001Bc!\u001d9$q\u0019 \u0003L6L1A!32\u0005%1UO\\2uS>t'\u0007E\u0002@\u0005\u001b$a!a\u0006(\u0005\u0004\u0011\u0005bBAFO\u0001\u0007!\u0011\u001b\t\u0006w\u0005=%1Z\u0001\tg>\u0014HoV5uQR\u0019\u0011Ja6\t\u000f\te\u0007\u00061\u0001\u0003\\\u0006\u0011A\u000e\u001e\t\u0007o\t\u001dgHP7\u0002\rM|'\u000f\u001e\"z+\u0011\u0011\tO!?\u0015\t\t\r(1 \u000b\u0004\u0013\n\u0015\bb\u0002BtS\u0001\u000f!\u0011^\u0001\u0004_J$\u0007C\u0002Bv\u0005c\u00149PD\u00028\u0005[L1Aa<2\u0003\u001d\u0001\u0018mY6bO\u0016LAAa=\u0003v\nAqJ\u001d3fe&twMC\u0002\u0003pF\u00022a\u0010B}\t\u0019\t9\"\u000bb\u0001\u0005\"9\u0011QO\u0015A\u0002\tu\b#B\u001cx}\t]\u0018AB:peR,G-\u0006\u0003\u0004\u0004\r-AcA%\u0004\u0006!9!q\u001d\u0016A\u0004\r\u001d\u0001C\u0002Bv\u0005c\u001cI\u0001E\u0002@\u0007\u0017!q!a\u0006+\u0005\u0004\tI\"A\u0004j]\u0012L7-Z:\u0016\u0005\rE\u0001\u0003\u0002Bv\u0007'IAa!\u0006\u0003v\n)!+\u00198hK\u0006!a/[3x+\t\u0019YBE\u0003\u0004\u001eY\u001a\tCB\u0003P\u0001\u0001\u0019Y\"C\u0002\u0004\u0018q\u0002RaOB\u0012}%K1a!\n0\u0005\u001d\u0019V-\u001d,jK^$ba!\t\u0004*\r-\u0002\"\u0002>.\u0001\u0004i\u0006BBB\u0017[\u0001\u0007Q,A\u0003v]RLG\u000eK\u0004\u0001\u0007c\u00199da\u000f\u0011\u0007]\u001a\u0019$C\u0002\u00046E\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\u0019I$\u0001#qe>D\u00180\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eA\u0011,X\r\t;pA1\f7m\u001b\u0011pM\u0002*8/\u001a\u0011b]\u0012\u00043m\\7qS2,'/\f7fm\u0016d\u0007e];qa>\u0014H/\t\u0002\u0004>\u00051!GL\u00192]A\u0002")
public interface SeqProxyLike<A, Repr extends SeqLike<A, Repr> & Seq<A>>
extends SeqLike<A, Repr>,
IterableProxyLike<A, Repr> {
    public static /* synthetic */ int size$(SeqProxyLike $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        return ((SeqLike)this.self()).size();
    }

    public static /* synthetic */ Seq toSeq$(SeqProxyLike $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<A> toSeq() {
        return ((SeqLike)this.self()).toSeq();
    }

    public static /* synthetic */ int length$(SeqProxyLike $this) {
        return $this.length();
    }

    @Override
    default public int length() {
        return ((SeqLike)this.self()).length();
    }

    public static /* synthetic */ Object apply$(SeqProxyLike $this, int idx) {
        return $this.apply(idx);
    }

    @Override
    default public A apply(int idx) {
        return (A)((Function1)this.self()).apply(BoxesRunTime.boxToInteger(idx));
    }

    public static /* synthetic */ int lengthCompare$(SeqProxyLike $this, int len) {
        return $this.lengthCompare(len);
    }

    @Override
    default public int lengthCompare(int len) {
        return ((SeqLike)this.self()).lengthCompare(len);
    }

    public static /* synthetic */ boolean isDefinedAt$(SeqProxyLike $this, int x) {
        return $this.isDefinedAt(x);
    }

    @Override
    default public boolean isDefinedAt(int x) {
        return ((GenSeqLike)this.self()).isDefinedAt(x);
    }

    public static /* synthetic */ int segmentLength$(SeqProxyLike $this, Function1 p, int from) {
        return $this.segmentLength(p, from);
    }

    @Override
    default public int segmentLength(Function1<A, Object> p, int from) {
        return ((SeqLike)this.self()).segmentLength(p, from);
    }

    public static /* synthetic */ int prefixLength$(SeqProxyLike $this, Function1 p) {
        return $this.prefixLength(p);
    }

    @Override
    default public int prefixLength(Function1<A, Object> p) {
        return ((GenSeqLike)this.self()).prefixLength(p);
    }

    public static /* synthetic */ int indexWhere$(SeqProxyLike $this, Function1 p) {
        return $this.indexWhere(p);
    }

    @Override
    default public int indexWhere(Function1<A, Object> p) {
        return ((GenSeqLike)this.self()).indexWhere(p);
    }

    public static /* synthetic */ int indexWhere$(SeqProxyLike $this, Function1 p, int from) {
        return $this.indexWhere(p, from);
    }

    @Override
    default public int indexWhere(Function1<A, Object> p, int from) {
        return ((SeqLike)this.self()).indexWhere(p, from);
    }

    public static /* synthetic */ int indexOf$(SeqProxyLike $this, Object elem) {
        return $this.indexOf(elem);
    }

    @Override
    default public <B> int indexOf(B elem) {
        return ((GenSeqLike)this.self()).indexOf(elem);
    }

    public static /* synthetic */ int indexOf$(SeqProxyLike $this, Object elem, int from) {
        return $this.indexOf(elem, from);
    }

    @Override
    default public <B> int indexOf(B elem, int from) {
        return ((GenSeqLike)this.self()).indexOf(elem, from);
    }

    public static /* synthetic */ int lastIndexOf$(SeqProxyLike $this, Object elem) {
        return $this.lastIndexOf(elem);
    }

    @Override
    default public <B> int lastIndexOf(B elem) {
        return ((GenSeqLike)this.self()).lastIndexOf(elem);
    }

    public static /* synthetic */ int lastIndexOf$(SeqProxyLike $this, Object elem, int end) {
        return $this.lastIndexOf(elem, end);
    }

    @Override
    default public <B> int lastIndexOf(B elem, int end) {
        return ((SeqLike)this.self()).lastIndexWhere((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(SeqProxyLike.$anonfun$lastIndexOf$1(elem, x$1)), end);
    }

    public static /* synthetic */ int lastIndexWhere$(SeqProxyLike $this, Function1 p) {
        return $this.lastIndexWhere(p);
    }

    @Override
    default public int lastIndexWhere(Function1<A, Object> p) {
        return ((SeqLike)this.self()).lastIndexWhere(p, this.length() - 1);
    }

    public static /* synthetic */ int lastIndexWhere$(SeqProxyLike $this, Function1 p, int end) {
        return $this.lastIndexWhere(p, end);
    }

    @Override
    default public int lastIndexWhere(Function1<A, Object> p, int end) {
        return ((GenSeqLike)this.self()).lastIndexWhere(p);
    }

    public static /* synthetic */ Seq reverse$(SeqProxyLike $this) {
        return $this.reverse();
    }

    @Override
    default public Repr reverse() {
        return (Repr)((Seq)((SeqLike)this.self()).reverse());
    }

    public static /* synthetic */ Object reverseMap$(SeqProxyLike $this, Function1 f, CanBuildFrom bf) {
        return $this.reverseMap(f, bf);
    }

    @Override
    default public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<Repr, B, That> bf) {
        return ((SeqLike)this.self()).reverseMap(f, bf);
    }

    public static /* synthetic */ Iterator reverseIterator$(SeqProxyLike $this) {
        return $this.reverseIterator();
    }

    @Override
    default public Iterator<A> reverseIterator() {
        return ((SeqLike)this.self()).reverseIterator();
    }

    public static /* synthetic */ boolean startsWith$(SeqProxyLike $this, GenSeq that, int offset) {
        return $this.startsWith(that, offset);
    }

    @Override
    default public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return ((SeqLike)this.self()).startsWith(that, offset);
    }

    public static /* synthetic */ boolean startsWith$(SeqProxyLike $this, GenSeq that) {
        return $this.startsWith(that);
    }

    @Override
    default public <B> boolean startsWith(GenSeq<B> that) {
        return ((GenSeqLike)this.self()).startsWith(that);
    }

    public static /* synthetic */ boolean endsWith$(SeqProxyLike $this, GenSeq that) {
        return $this.endsWith(that);
    }

    @Override
    default public <B> boolean endsWith(GenSeq<B> that) {
        return ((SeqLike)this.self()).endsWith(that);
    }

    public static /* synthetic */ int indexOfSlice$(SeqProxyLike $this, GenSeq that) {
        return $this.indexOfSlice(that);
    }

    @Override
    default public <B> int indexOfSlice(GenSeq<B> that) {
        return ((SeqLike)this.self()).indexOfSlice(that);
    }

    public static /* synthetic */ int indexOfSlice$(SeqProxyLike $this, GenSeq that, int from) {
        return $this.indexOfSlice(that, from);
    }

    @Override
    default public <B> int indexOfSlice(GenSeq<B> that, int from) {
        return ((SeqLike)this.self()).indexOfSlice(that);
    }

    public static /* synthetic */ int lastIndexOfSlice$(SeqProxyLike $this, GenSeq that) {
        return $this.lastIndexOfSlice(that);
    }

    @Override
    default public <B> int lastIndexOfSlice(GenSeq<B> that) {
        return ((SeqLike)this.self()).lastIndexOfSlice(that);
    }

    public static /* synthetic */ int lastIndexOfSlice$(SeqProxyLike $this, GenSeq that, int end) {
        return $this.lastIndexOfSlice(that, end);
    }

    @Override
    default public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
        return ((SeqLike)this.self()).lastIndexOfSlice(that, end);
    }

    public static /* synthetic */ boolean containsSlice$(SeqProxyLike $this, GenSeq that) {
        return $this.containsSlice(that);
    }

    @Override
    default public <B> boolean containsSlice(GenSeq<B> that) {
        return ((SeqLike)this.self()).indexOfSlice(that) != -1;
    }

    public static /* synthetic */ boolean contains$(SeqProxyLike $this, Object elem) {
        return $this.contains(elem);
    }

    @Override
    default public <A1> boolean contains(A1 elem) {
        return ((SeqLike)this.self()).contains(elem);
    }

    public static /* synthetic */ Object union$(SeqProxyLike $this, GenSeq that, CanBuildFrom bf) {
        return $this.union(that, bf);
    }

    @Override
    default public <B, That> That union(GenSeq<B> that, CanBuildFrom<Repr, B, That> bf) {
        return ((SeqLike)this.self()).union(that, bf);
    }

    public static /* synthetic */ Seq diff$(SeqProxyLike $this, GenSeq that) {
        return $this.diff(that);
    }

    @Override
    default public <B> Repr diff(GenSeq<B> that) {
        return (Repr)((Seq)((SeqLike)this.self()).diff(that));
    }

    public static /* synthetic */ Seq intersect$(SeqProxyLike $this, GenSeq that) {
        return $this.intersect(that);
    }

    @Override
    default public <B> Repr intersect(GenSeq<B> that) {
        return (Repr)((Seq)((SeqLike)this.self()).intersect(that));
    }

    public static /* synthetic */ Seq distinct$(SeqProxyLike $this) {
        return $this.distinct();
    }

    @Override
    default public Repr distinct() {
        return (Repr)((Seq)((SeqLike)this.self()).distinct());
    }

    public static /* synthetic */ Object patch$(SeqProxyLike $this, int from, GenSeq patch, int replaced, CanBuildFrom bf) {
        return $this.patch(from, patch, replaced, bf);
    }

    @Override
    default public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<Repr, B, That> bf) {
        return ((SeqLike)this.self()).patch(from, patch, replaced, bf);
    }

    public static /* synthetic */ Object updated$(SeqProxyLike $this, int index, Object elem, CanBuildFrom bf) {
        return $this.updated(index, elem, bf);
    }

    @Override
    default public <B, That> That updated(int index, B elem, CanBuildFrom<Repr, B, That> bf) {
        return ((SeqLike)this.self()).updated(index, elem, bf);
    }

    public static /* synthetic */ Object $plus$colon$(SeqProxyLike $this, Object elem, CanBuildFrom bf) {
        return $this.$plus$colon(elem, bf);
    }

    @Override
    default public <B, That> That $plus$colon(B elem, CanBuildFrom<Repr, B, That> bf) {
        return ((SeqLike)this.self()).$plus$colon(elem, bf);
    }

    public static /* synthetic */ Object $colon$plus$(SeqProxyLike $this, Object elem, CanBuildFrom bf) {
        return $this.$colon$plus(elem, bf);
    }

    @Override
    default public <B, That> That $colon$plus(B elem, CanBuildFrom<Repr, B, That> bf) {
        return ((SeqLike)this.self()).$colon$plus(elem, bf);
    }

    public static /* synthetic */ Object padTo$(SeqProxyLike $this, int len, Object elem, CanBuildFrom bf) {
        return $this.padTo(len, elem, bf);
    }

    @Override
    default public <B, That> That padTo(int len, B elem, CanBuildFrom<Repr, B, That> bf) {
        return ((SeqLike)this.self()).padTo(len, elem, bf);
    }

    public static /* synthetic */ boolean corresponds$(SeqProxyLike $this, GenSeq that, Function2 p) {
        return $this.corresponds(that, p);
    }

    @Override
    default public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return ((SeqLike)this.self()).corresponds(that, p);
    }

    public static /* synthetic */ Seq sortWith$(SeqProxyLike $this, Function2 lt) {
        return $this.sortWith(lt);
    }

    @Override
    default public Repr sortWith(Function2<A, A, Object> lt) {
        return (Repr)((Seq)((SeqLike)this.self()).sortWith(lt));
    }

    public static /* synthetic */ Seq sortBy$(SeqProxyLike $this, Function1 f, Ordering ord) {
        return $this.sortBy(f, ord);
    }

    @Override
    default public <B> Repr sortBy(Function1<A, B> f, Ordering<B> ord) {
        return (Repr)((Seq)((SeqLike)this.self()).sortBy(f, ord));
    }

    public static /* synthetic */ Seq sorted$(SeqProxyLike $this, Ordering ord) {
        return $this.sorted(ord);
    }

    @Override
    default public <B> Repr sorted(Ordering<B> ord) {
        return (Repr)((Seq)((SeqLike)this.self()).sorted(ord));
    }

    public static /* synthetic */ Range indices$(SeqProxyLike $this) {
        return $this.indices();
    }

    @Override
    default public Range indices() {
        return ((SeqLike)this.self()).indices();
    }

    public static /* synthetic */ SeqView view$(SeqProxyLike $this) {
        return $this.view();
    }

    @Override
    default public SeqView<A, Repr> view() {
        return ((SeqLike)this.self()).view();
    }

    public static /* synthetic */ SeqView view$(SeqProxyLike $this, int from, int until) {
        return $this.view(from, until);
    }

    @Override
    default public SeqView<A, Repr> view(int from, int until) {
        return ((SeqLike)this.self()).view(from, until);
    }

    public static /* synthetic */ boolean $anonfun$lastIndexOf$1(Object elem$1, Object x$1) {
        return BoxesRunTime.equals(elem$1, x$1);
    }

    public static void $init$(SeqProxyLike $this) {
    }
}

