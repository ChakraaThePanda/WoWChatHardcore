/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.StringContext;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolPairs$SymbolPair$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.HashSet;
import scala.reflect.internal.util.HashSet$;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.StripMarginInterpolator;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r\u001da!B,Y\u0003\u0003y\u0006\"\u00023\u0001\t\u0003)\u0007b\u00025\u0001\u0005\u00045\t!\u001b\u0005\u0006[\u0002!\tA\u001c\u0004\u0007\u0003\u0017\u0001!)!\u0004\t\u0015\u0005mAA!f\u0001\n\u0003\ti\u0002\u0003\u0006\u0002 \u0011\u0011\t\u0012)A\u0005\u0003\u0003A!\"!\t\u0005\u0005+\u0007I\u0011AA\u000f\u0011)\t\u0019\u0003\u0002B\tB\u0003%\u0011\u0011\u0001\u0005\u000b\u0003K!!Q3A\u0005\u0002\u0005u\u0001BCA\u0014\t\tE\t\u0015!\u0003\u0002\u0002!1A\r\u0002C\u0001\u0003SAq!a\r\u0005A\u0003%Q\u000fC\u0004\u00026\u0011!\t!a\u000e\t\u000f\u0005\rC\u0001\"\u0001\u0002F!9\u0011q\t\u0003\u0005\u0002\u0005\u0015\u0003bBA%\t\u0011\u0005\u0011Q\t\u0005\b\u0003\u0017\"A\u0011AA#\u0011\u001d\ti\u0005\u0002C\u0001\u0003\u000bBq!a\u0014\u0005\t\u0003\t)\u0005C\u0004\u0002R\u0011!\t!!\u0012\t\u000f\u0005MC\u0001\"\u0001\u0002F!9\u0011Q\u000b\u0003\u0005\u0002\u0005]\u0003bBA-\t\u0011\u0005\u0011q\u000b\u0005\b\u00037\"A\u0011BA/\u0011\u001d\t\u0019\u0007\u0002C\u0005\u0003KBq!a \u0005\t\u0013\t\t\tC\u0004\u0002\u0006\u0012!\t!a\"\t\u000f\u0005%E\u0001\"\u0001\u0002\b\"9\u00111\u0012\u0003\u0005B\u00055\u0005\"CAH\t\u0005\u0005I\u0011AAI\u0011%\tI\nBI\u0001\n\u0003\tY\nC\u0005\u00022\u0012\t\n\u0011\"\u0001\u0002\u001c\"I\u00111\u0017\u0003\u0012\u0002\u0013\u0005\u00111\u0014\u0005\n\u0003k#\u0011\u0011!C!\u0003\u000fC\u0011\"a.\u0005\u0003\u0003%\t!!/\t\u0013\u0005\u0005G!!A\u0005\u0002\u0005\r\u0007\"CAh\t\u0005\u0005I\u0011IAi\u0011%\ty\u000eBA\u0001\n\u0003\t\t\u000fC\u0005\u0002f\u0012\t\t\u0011\"\u0011\u0002h\"I\u0011\u0011\u001e\u0003\u0002\u0002\u0013\u0005\u00131^\u0004\n\u0003_\u0004\u0011\u0011!E\u0001\u0003c4\u0011\"a\u0003\u0001\u0003\u0003E\t!a=\t\r\u0011TC\u0011\u0001B\u0001\u0011%\tYIKA\u0001\n\u000b\ni\tC\u0005\u0003\u0004)\n\t\u0011\"!\u0003\u0006!I!Q\u0002\u0016\u0002\u0002\u0013\u0005%q\u0002\u0004\b\u0005C\u0001\u0011\u0011\u0001B\u0012\u0011)\tYb\fBC\u0002\u0013\u0005\u0011Q\u0004\u0005\u000b\u0003?y#\u0011!Q\u0001\n\u0005\u0005\u0001B\u000230\t\u0003\u0011)\u0003C\u0005\u00024=\u0012\r\u0011\"\u0002\u0002F!9!1F\u0018!\u0002\u001b)\b\"\u0003B\u0017_\t\u0007I\u0011\u0002B\u0018\u0011!\u0011Yd\fQ\u0001\n\tE\u0002\"\u0003B\u001f_\t\u0007I\u0011BA]\u0011!\u0011yd\fQ\u0001\n\u0005m\u0006b\u0002B!_\u0019E!1\t\u0005\b\u0005\u000fzc\u0011\u0003B%\u0011\u001d\u0011ie\fC\t\u0005\u001fBqAa\u00180\t#\u0011\t'\u0002\u0004\u0003f=\"!q\r\u0005\n\u0005[z#\u0019!C\u0005\u0005_B\u0001Ba\u001e0A\u0003%!\u0011\u000f\u0005\n\u0005sz#\u0019!C\u0005\u0005wB\u0001B!#0A\u0003%!Q\u0010\u0005\n\u0005\u0017{#\u0019!C\u0005\u0005\u001bC\u0001B!)0A\u0003%!q\u0012\u0005\f\u0005G{\u0003\u0019!A!B\u0013\t\t\u0001C\u0006\u0003&>\u0002\r\u0011!Q!\n\u0005\u0005\u0001b\u0002BT_\u0011\u0005\u0011Q\t\u0005\u000b\u0005S{\u0003\u0019!A!B\u0013)\bb\u0003BV_\u0001\u0007\t\u0011)Q\u0005\u0003\u0003A\u0001B!,0A\u0003&!1\u0014\u0005\t\u0005_{\u0003\u0015)\u0003\u0003\u001c\"9!\u0011W\u0018\u0005\n\tM\u0006b\u0002B^_\u0011%!Q\u0018\u0005\b\u0005\u000f|C\u0011\u0002Be\u0011\u001d\u0011)n\fC\u0005\u0005/DqA!90\t\u0013\u0011\u0019\fC\u0004\u0003n>\"IAa-\t\u000f\u0005\u0005r\u0006\"\u0001\u0002\u001e!9\u0011QE\u0018\u0005\u0002\u0005u\u0001b\u0002By_\u0011\u0005\u0011q\u000b\u0005\b\u0005g|C\u0011\u0001B{\u0011\u001d\u00119p\fC\u0001\u0005sDqa!\u00020\t\u0003\u0011\u0019LA\u0006Ts6\u0014w\u000e\u001c)bSJ\u001c(BA-[\u0003!Ig\u000e^3s]\u0006d'BA.]\u0003\u001d\u0011XM\u001a7fGRT\u0011!X\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001\u0001\r\u0005\u0002bE6\tA,\u0003\u0002d9\n1\u0011I\\=SK\u001a\fa\u0001P5oSRtD#\u00014\u0011\u0005\u001d\u0004Q\"\u0001-\u0002\r\u001ddwNY1m+\u0005Q\u0007CA4l\u0013\ta\u0007LA\u0006Ts6\u0014w\u000e\u001c+bE2,\u0017aD:b[\u0016LeNQ1tK\u000ec\u0017m]:\u0015\u0005=tHc\u00019tyB\u0011\u0011-]\u0005\u0003er\u0013qAQ8pY\u0016\fg\u000eC\u0003u\u0007\u0001\u0007Q/A\u0002uaF\u0002\"A\u001e=\u000f\u0005]\u0014Q\"\u0001\u0001\n\u0005eT(\u0001\u0002+za\u0016L!a\u001f-\u0003\u000bQK\b/Z:\t\u000bu\u001c\u0001\u0019A;\u0002\u0007Q\u0004(\u0007\u0003\u0004\u0000\u0007\u0001\u0007\u0011\u0011A\u0001\nE\u0006\u001cXm\u00117bgN\u00042A^A\u0002\u0013\u0011\t)!a\u0002\u0003\rMKXNY8m\u0013\r\tI\u0001\u0017\u0002\b'fl'm\u001c7t\u0005)\u0019\u00160\u001c2pYB\u000b\u0017N]\n\u0007\t\u0001\fy!!\u0006\u0011\u0007\u0005\f\t\"C\u0002\u0002\u0014q\u0013q\u0001\u0015:pIV\u001cG\u000fE\u0002b\u0003/I1!!\u0007]\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u0011\u0011\u0017m]3\u0016\u0005\u0005\u0005\u0011!\u00022bg\u0016\u0004\u0013a\u00017po\u0006!An\\<!\u0003\u0011A\u0017n\u001a5\u0002\u000b!Lw\r\u001b\u0011\u0015\u0011\u0005-\u0012QFA\u0018\u0003c\u0001\"a\u001e\u0003\t\u000f\u0005m1\u00021\u0001\u0002\u0002!9\u0011\u0011E\u0006A\u0002\u0005\u0005\u0001bBA\u0013\u0017\u0001\u0007\u0011\u0011A\u0001\u0005g\u0016dg-A\u0002q_N,\"!!\u000f\u0011\u0007Y\fY$\u0003\u0003\u0002>\u0005}\"\u0001\u0003)pg&$\u0018n\u001c8\n\u0007\u0005\u0005\u0003LA\u0005Q_NLG/[8og\u0006A!o\\8u)f\u0004X-F\u0001v\u0003\u001dawn\u001e+za\u0016\f\u0011\u0002\\8x\u000bJ\f7/\u001a3\u0002\u001b1|wo\u00117bgN\u0014u.\u001e8e\u0003!A\u0017n\u001a5UsB,\u0017\u0001\u00035jO\"LeNZ8\u0002\u0015!Lw\r[#sCN,G-\u0001\biS\u001eD7\t\\1tg\n{WO\u001c3\u0002\u0017%\u001cXI\u001d:p]\u0016|Wo]\u000b\u0002a\u0006A1/Y7f\u0017&tG-\u0001\tdY\u0006\u001c8OQ8v]\u0012\f5oU3f]R\u0019Q/a\u0018\t\u000f\u0005\u0005\u0004\u00041\u0001\u0002\u0002\u0005!Ao]=n\u0003=iW-\u001c2fe\u0012+gm\u0015;sS:<GCBA4\u0003o\nY\b\u0005\u0003\u0002j\u0005MTBAA6\u0015\u0011\ti'a\u001c\u0002\t1\fgn\u001a\u0006\u0003\u0003c\nAA[1wC&!\u0011QOA6\u0005\u0019\u0019FO]5oO\"9\u0011\u0011P\rA\u0002\u0005\u0005\u0011aA:z[\"1\u0011QP\rA\u0002A\fQa\u001e5fe\u0016\f1b\u001e5fe\u0016\u001cFO]5oOR!\u0011qMAB\u0011\u001d\tIH\u0007a\u0001\u0003\u0003\t\u0011\u0002\\8x'R\u0014\u0018N\\4\u0016\u0005\u0005\u001d\u0014A\u00035jO\"\u001cFO]5oO\u0006AAo\\*ue&tw\r\u0006\u0002\u0002h\u0005!1m\u001c9z)!\tY#a%\u0002\u0016\u0006]\u0005\"CA\u000e=A\u0005\t\u0019AA\u0001\u0011%\t\tC\bI\u0001\u0002\u0004\t\t\u0001C\u0005\u0002&y\u0001\n\u00111\u0001\u0002\u0002\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\nTCAAOU\u0011\t\t!a(,\u0005\u0005\u0005\u0006\u0003BAR\u0003[k!!!*\u000b\t\u0005\u001d\u0016\u0011V\u0001\nk:\u001c\u0007.Z2lK\u0012T1!a+]\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003_\u000b)KA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fabY8qs\u0012\"WMZ1vYR$#'\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001a\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\t\tY\fE\u0002b\u0003{K1!a0]\u0005\rIe\u000e^\u0001\u000faJ|G-^2u\u000b2,W.\u001a8u)\u0011\t)-a3\u0011\u0007\u0005\f9-C\u0002\u0002Jr\u00131!\u00118z\u0011%\ti\rJA\u0001\u0002\u0004\tY,A\u0002yIE\nq\u0002\u001d:pIV\u001cG/\u0013;fe\u0006$xN]\u000b\u0003\u0003'\u0004b!!6\u0002\\\u0006\u0015WBAAl\u0015\r\tI\u000eX\u0001\u000bG>dG.Z2uS>t\u0017\u0002BAo\u0003/\u0014\u0001\"\u0013;fe\u0006$xN]\u0001\tG\u0006tW)];bYR\u0019\u0001/a9\t\u0013\u00055g%!AA\u0002\u0005\u0015\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005m\u0016AB3rk\u0006d7\u000fF\u0002q\u0003[D\u0011\"!4)\u0003\u0003\u0005\r!!2\u0002\u0015MKXNY8m!\u0006L'\u000f\u0005\u0002xUM)!&!>\u0002\u0016Aa\u0011q_A\u007f\u0003\u0003\t\t!!\u0001\u0002,5\u0011\u0011\u0011 \u0006\u0004\u0003wd\u0016a\u0002:v]RLW.Z\u0005\u0005\u0003\u007f\fIPA\tBEN$(/Y2u\rVt7\r^5p]N\"\"!!=\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0011\u0005-\"q\u0001B\u0005\u0005\u0017Aq!a\u0007.\u0001\u0004\t\t\u0001C\u0004\u0002\"5\u0002\r!!\u0001\t\u000f\u0005\u0015R\u00061\u0001\u0002\u0002\u00059QO\\1qa2LH\u0003\u0002B\t\u0005;\u0001R!\u0019B\n\u0005/I1A!\u0006]\u0005\u0019y\u0005\u000f^5p]BI\u0011M!\u0007\u0002\u0002\u0005\u0005\u0011\u0011A\u0005\u0004\u00057a&A\u0002+va2,7\u0007C\u0005\u0003 9\n\t\u00111\u0001\u0002,\u0005\u0019\u0001\u0010\n\u0019\u0003\r\r+(o]8s'\ty\u0003\r\u0006\u0003\u0003(\t%\u0002CA<0\u0011\u001d\tYB\ra\u0001\u0003\u0003\tQa]3mM\u0002\nQ\u0001Z3dYN,\"A!\r\u0011\u0007Y\u0014\u0019$\u0003\u0003\u00036\t]\"!B*d_B,\u0017b\u0001B\u001d1\n11kY8qKN\fa\u0001Z3dYN\u0004\u0013\u0001B:ju\u0016\fQa]5{K\u0002\nq!\u001a=dYV$W\rF\u0002q\u0005\u000bBq!!\u001f:\u0001\u0004\t\t!A\u0004nCR\u001c\u0007.Z:\u0015\u0007A\u0014Y\u0005C\u0004\u0002&i\u0002\r!!\u0001\u0002\u000fA\f'/\u001a8ugV\u0011!\u0011\u000b\t\u0006\u0005'\u0012I&\u001e\b\u0004C\nU\u0013b\u0001B,9\u00069\u0001/Y2lC\u001e,\u0017\u0002\u0002B.\u0005;\u0012A\u0001T5ti*\u0019!q\u000b/\u0002\u000b\t\f7/Z:\u0016\u0005\t\r\u0004C\u0002B*\u00053\n\tA\u0001\u0004CSR\u001cV\r\u001e\t\u0006C\n%\u00141X\u0005\u0004\u0005Wb&!B!se\u0006L\u0018AC:vEB\u000b'/\u001a8ugV\u0011!\u0011\u000f\t\u0006C\n%$1\u000f\t\u0004\u0005kjT\"A\u0018\u0002\u0017M,(\rU1sK:$8\u000fI\u0001\u0006S:$W\r_\u000b\u0003\u0005{\u0002\u0002Ba \u0003\u0006\u0006\u0005\u00111X\u0007\u0003\u0005\u0003SAAa!\u0002X\u00069Q.\u001e;bE2,\u0017\u0002\u0002BD\u0005\u0003\u0013q\u0001S1tQ6\u000b\u0007/\u0001\u0004j]\u0012,\u0007\u0010I\u0001\bm&\u001c\u0018\u000e^3e+\t\u0011y\t\u0005\u0004\u0003\u0012\n]%1T\u0007\u0003\u0005'S1A!&Y\u0003\u0011)H/\u001b7\n\t\te%1\u0013\u0002\b\u0011\u0006\u001c\bnU3u!\r1(QT\u0005\u0005\u0005?\u00139D\u0001\u0006TG>\u0004X-\u00128uef\f\u0001B^5tSR,G\rI\u0001\nY><8+_7c_2\f!\u0002[5hQNKXNY8m\u00035awn^'f[\n,'\u000fV=qK\u0006\u0011Bn\\<NK6\u0014WM\u001d+za\u0016\u001c\u0015m\u00195f\u0003Uawn^'f[\n,'\u000fV=qK\u000e\u000b7\r[3Ts6\f\u0001bY;s\u000b:$(/_\u0001\n]\u0016DH/\u00128uef\fA!\u001b8jiR\u0011!Q\u0017\t\u0004C\n]\u0016b\u0001B]9\n!QK\\5u\u0003\u001dIgn\u00197vI\u0016$bA!.\u0003@\n\r\u0007b\u0002Ba\u0019\u0002\u0007!1O\u0001\u0003ENDqA!2M\u0001\u0004\tY,A\u0001o\u0003yIg\u000e^3sg\u0016\u001cG/[8o\u0007>tG/Y5og\u0016cW-\\3oi2+\u0017\u000fF\u0004q\u0005\u0017\u0014yMa5\t\u000f\t5W\n1\u0001\u0003t\u0005\u0019!m]\u0019\t\u000f\tEW\n1\u0001\u0003t\u0005\u0019!m\u001d\u001a\t\u000f\t\u0015W\n1\u0001\u0002<\u0006I\u0002.Y:D_6lwN\u001c)be\u0016tG/Q:Tk\n\u001cG.Y:t)\u0015\u0001(\u0011\u001cBo\u0011\u001d\u0011YN\u0014a\u0001\u0003\u0003\tAa]=nc!9!q\u001c(A\u0002\u0005\u0005\u0011\u0001B:z[J\n\u0001#\u00193wC:\u001cWMT3yi\u0016sGO]=)\u0007=\u0013)\u000f\u0005\u0003\u0003h\n%XBAAU\u0013\u0011\u0011Y/!+\u0003\u000fQ\f\u0017\u000e\u001c:fG\u0006y\u0011\r\u001a<b]\u000e,7)\u001e:F]R\u0014\u0018\u0010K\u0002Q\u0005K\fq\u0001[1t\u001d\u0016DH/A\u0006dkJ\u0014XM\u001c;QC&\u0014XCAA\u0016\u0003!IG/\u001a:bi>\u0014XC\u0001B~%\u0015\u0011i\u0010YB\u0001\r\u0019\u0011y0\u0016\u0001\u0003|\naAH]3gS:,W.\u001a8u}A1!1KB\u0002\u0003WIA!!8\u0003^\u0005!a.\u001a=u\u0001")
public abstract class SymbolPairs {
    private volatile SymbolPairs$SymbolPair$ SymbolPair$module;

    public SymbolPairs$SymbolPair$ SymbolPair() {
        if (this.SymbolPair$module == null) {
            this.SymbolPair$lzycompute$1();
        }
        return this.SymbolPair$module;
    }

    public abstract SymbolTable global();

    public boolean sameInBaseClass(Symbols.Symbol baseClass, Types.Type tp1, Types.Type tp2) {
        return tp1.baseType(baseClass).$eq$colon$eq(tp2.baseType(baseClass));
    }

    private final void SymbolPair$lzycompute$1() {
        synchronized (this) {
            if (this.SymbolPair$module == null) {
                this.SymbolPair$module = new SymbolPairs$SymbolPair$(this);
            }
            return;
        }
    }

    public abstract class Cursor {
        private final Symbols.Symbol base;
        private final Types.Type self;
        private final Scopes.Scope decls;
        private final int size;
        private final int[][] subParents;
        private final HashMap<Symbols.Symbol, Object> index;
        private final HashSet<Scopes.ScopeEntry> visited;
        private Symbols.Symbol lowSymbol;
        private Symbols.Symbol highSymbol;
        private Types.Type lowMemberTypeCache;
        private Symbols.Symbol lowMemberTypeCacheSym;
        private Scopes.ScopeEntry curEntry;
        private Scopes.ScopeEntry nextEntry;
        public final /* synthetic */ SymbolPairs $outer;

        public Symbols.Symbol base() {
            return this.base;
        }

        public final Types.Type self() {
            return this.self;
        }

        private Scopes.Scope decls() {
            return this.decls;
        }

        private int size() {
            return this.size;
        }

        public abstract boolean exclude(Symbols.Symbol var1);

        public abstract boolean matches(Symbols.Symbol var1);

        public List<Types.Type> parents() {
            return this.base().info().parents();
        }

        public List<Symbols.Symbol> bases() {
            return this.base().info().baseClasses();
        }

        private int[][] subParents() {
            return this.subParents;
        }

        private HashMap<Symbols.Symbol, Object> index() {
            return this.index;
        }

        private HashSet<Scopes.ScopeEntry> visited() {
            return this.visited;
        }

        public Types.Type lowMemberType() {
            if (this.lowSymbol != this.lowMemberTypeCacheSym) {
                this.lowMemberTypeCache = this.self().memberType(this.lowSymbol);
                this.lowMemberTypeCacheSym = this.lowSymbol;
            }
            return this.lowMemberTypeCache;
        }

        private void init() {
            IntRef i = IntRef.create(0);
            List list = this.bases();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Symbols.Symbol symbol = foreach_these.head();
                Cursor.$anonfun$init$1(this, i, symbol);
                foreach_these = (List)foreach_these.tail();
            }
            List list2 = this.parents();
            if (list2 == null) {
                throw null;
            }
            List foreach_these2 = list2;
            while (!foreach_these2.isEmpty()) {
                Types.Type type = foreach_these2.head();
                Cursor.$anonfun$init$2(this, type);
                foreach_these2 = (List)foreach_these2.tail();
            }
            this.fillDecls$1(this.bases(), true);
            this.fillDecls$1(this.bases(), false);
        }

        private void include(int[] bs, int n) {
            int nshifted = n >> 5;
            int nmask = 1 << (n & 0x1F);
            bs[nshifted] = bs[nshifted] | nmask;
        }

        private boolean intersectionContainsElementLeq(int[] bs1, int[] bs2, int n) {
            int nshifted = n >> 5;
            int nmask = 1 << (n & 0x1F);
            for (int i = 0; i < nshifted; ++i) {
                if ((bs1[i] & bs2[i]) == 0) continue;
                return true;
            }
            return (bs1[nshifted] & bs2[nshifted] & (nmask | nmask - 1)) != 0;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean hasCommonParentAsSubclass(Symbols.Symbol sym1, Symbols.Symbol sym2) {
            int index1 = BoxesRunTime.unboxToInt(this.index().apply(sym1.owner()));
            if (index1 < 0) return false;
            int index2 = BoxesRunTime.unboxToInt(this.index().apply(sym2.owner()));
            if (index2 < 0) return false;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (!this.intersectionContainsElementLeq(this.subParents()[index1], this.subParents()[index2], RichInt$.MODULE$.min$extension(index1, index2))) return false;
            return true;
        }

        private void advanceNextEntry() {
            while (this.nextEntry != null) {
                boolean bl;
                this.nextEntry = this.decls().lookupNextEntry(this.nextEntry);
                if (this.nextEntry == null) break;
                Symbols.Symbol high = this.nextEntry.sym();
                if (this.matches(high)) {
                    this.visited().addEntry(this.nextEntry);
                    bl = true;
                } else {
                    bl = false;
                }
                if (!bl || this.hasCommonParentAsSubclass(this.lowSymbol, high)) continue;
                this.highSymbol = high;
                return;
            }
        }

        private void advanceCurEntry() {
            while (this.curEntry != null) {
                this.curEntry = this.curEntry.next();
                if (this.curEntry == null) break;
                if (this.visited().apply(this.curEntry) || this.exclude(this.curEntry.sym())) continue;
                this.nextEntry = this.curEntry;
                return;
            }
        }

        public Symbols.Symbol low() {
            return this.lowSymbol;
        }

        public Symbols.Symbol high() {
            return this.highSymbol;
        }

        public boolean hasNext() {
            return this.curEntry != null;
        }

        public SymbolPair currentPair() {
            return new SymbolPair(this.scala$reflect$internal$SymbolPairs$Cursor$$$outer(), this.base(), this.low(), this.high());
        }

        public Iterator<SymbolPair> iterator() {
            return new Iterator<SymbolPair>(this){
                private final /* synthetic */ Cursor $outer;

                public Iterator<SymbolPair> seq() {
                    return Iterator.seq$(this);
                }

                public boolean isEmpty() {
                    return Iterator.isEmpty$(this);
                }

                public boolean isTraversableAgain() {
                    return Iterator.isTraversableAgain$(this);
                }

                public boolean hasDefiniteSize() {
                    return Iterator.hasDefiniteSize$(this);
                }

                public Iterator<SymbolPair> take(int n) {
                    return Iterator.take$(this, n);
                }

                public Iterator<SymbolPair> drop(int n) {
                    return Iterator.drop$(this, n);
                }

                public Iterator<SymbolPair> slice(int from, int until) {
                    return Iterator.slice$(this, from, until);
                }

                public Iterator<SymbolPair> sliceIterator(int from, int until) {
                    return Iterator.sliceIterator$(this, from, until);
                }

                public <B> Iterator<B> map(Function1<SymbolPair, B> f) {
                    return Iterator.map$(this, f);
                }

                public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                    return Iterator.$plus$plus$(this, that);
                }

                public <B> Iterator<B> flatMap(Function1<SymbolPair, GenTraversableOnce<B>> f) {
                    return Iterator.flatMap$(this, f);
                }

                public Iterator<SymbolPair> filter(Function1<SymbolPair, Object> p) {
                    return Iterator.filter$(this, p);
                }

                public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<SymbolPair, B, Object> p) {
                    return Iterator.corresponds$(this, that, p);
                }

                public Iterator<SymbolPair> withFilter(Function1<SymbolPair, Object> p) {
                    return Iterator.withFilter$(this, p);
                }

                public Iterator<SymbolPair> filterNot(Function1<SymbolPair, Object> p) {
                    return Iterator.filterNot$(this, p);
                }

                public <B> Iterator<B> collect(PartialFunction<SymbolPair, B> pf) {
                    return Iterator.collect$(this, pf);
                }

                public <B> Iterator<B> scanLeft(B z, Function2<B, SymbolPair, B> op) {
                    return Iterator.scanLeft$(this, z, op);
                }

                public <B> Iterator<B> scanRight(B z, Function2<SymbolPair, B, B> op) {
                    return Iterator.scanRight$(this, z, op);
                }

                public Iterator<SymbolPair> takeWhile(Function1<SymbolPair, Object> p) {
                    return Iterator.takeWhile$(this, p);
                }

                public Tuple2<Iterator<SymbolPair>, Iterator<SymbolPair>> partition(Function1<SymbolPair, Object> p) {
                    return Iterator.partition$(this, p);
                }

                public Tuple2<Iterator<SymbolPair>, Iterator<SymbolPair>> span(Function1<SymbolPair, Object> p) {
                    return Iterator.span$(this, p);
                }

                public Iterator<SymbolPair> dropWhile(Function1<SymbolPair, Object> p) {
                    return Iterator.dropWhile$(this, p);
                }

                public <B> Iterator<Tuple2<SymbolPair, B>> zip(Iterator<B> that) {
                    return Iterator.zip$(this, that);
                }

                public <A1> Iterator<A1> padTo(int len, A1 elem) {
                    return Iterator.padTo$(this, len, elem);
                }

                public Iterator<Tuple2<SymbolPair, Object>> zipWithIndex() {
                    return Iterator.zipWithIndex$(this);
                }

                public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                    return Iterator.zipAll$(this, that, thisElem, thatElem);
                }

                public <U> void foreach(Function1<SymbolPair, U> f) {
                    Iterator.foreach$(this, f);
                }

                public boolean forall(Function1<SymbolPair, Object> p) {
                    return Iterator.forall$(this, p);
                }

                public boolean exists(Function1<SymbolPair, Object> p) {
                    return Iterator.exists$(this, p);
                }

                public boolean contains(Object elem) {
                    return Iterator.contains$(this, elem);
                }

                public Option<SymbolPair> find(Function1<SymbolPair, Object> p) {
                    return Iterator.find$(this, p);
                }

                public int indexWhere(Function1<SymbolPair, Object> p) {
                    return Iterator.indexWhere$(this, p);
                }

                public int indexWhere(Function1<SymbolPair, Object> p, int from) {
                    return Iterator.indexWhere$(this, p, from);
                }

                public <B> int indexOf(B elem) {
                    return Iterator.indexOf$(this, elem);
                }

                public <B> int indexOf(B elem, int from) {
                    return Iterator.indexOf$(this, elem, from);
                }

                public BufferedIterator<SymbolPair> buffered() {
                    return Iterator.buffered$(this);
                }

                public <B> Iterator.GroupedIterator<B> grouped(int size) {
                    return Iterator.grouped$(this, size);
                }

                public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
                    return Iterator.sliding$(this, size, step);
                }

                public <B> int sliding$default$2() {
                    return Iterator.sliding$default$2$(this);
                }

                public int length() {
                    return Iterator.length$(this);
                }

                public Tuple2<Iterator<SymbolPair>, Iterator<SymbolPair>> duplicate() {
                    return Iterator.duplicate$(this);
                }

                public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                    return Iterator.patch$(this, from, patchElems, replaced);
                }

                public <B> void copyToArray(Object xs, int start, int len) {
                    Iterator.copyToArray$(this, xs, start, len);
                }

                public boolean sameElements(Iterator<?> that) {
                    return Iterator.sameElements$(this, that);
                }

                public Traversable<SymbolPair> toTraversable() {
                    return Iterator.toTraversable$(this);
                }

                public Iterator<SymbolPair> toIterator() {
                    return Iterator.toIterator$(this);
                }

                public Stream<SymbolPair> toStream() {
                    return Iterator.toStream$(this);
                }

                public String toString() {
                    return Iterator.toString$(this);
                }

                public List<SymbolPair> reversed() {
                    return TraversableOnce.reversed$(this);
                }

                public int size() {
                    return TraversableOnce.size$(this);
                }

                public boolean nonEmpty() {
                    return TraversableOnce.nonEmpty$(this);
                }

                public int count(Function1<SymbolPair, Object> p) {
                    return TraversableOnce.count$(this, p);
                }

                public <B> Option<B> collectFirst(PartialFunction<SymbolPair, B> pf) {
                    return TraversableOnce.collectFirst$(this, pf);
                }

                public <B> B $div$colon(B z, Function2<B, SymbolPair, B> op) {
                    return (B)TraversableOnce.$div$colon$(this, z, op);
                }

                public <B> B $colon$bslash(B z, Function2<SymbolPair, B, B> op) {
                    return (B)TraversableOnce.$colon$bslash$(this, z, op);
                }

                public <B> B foldLeft(B z, Function2<B, SymbolPair, B> op) {
                    return (B)TraversableOnce.foldLeft$(this, z, op);
                }

                public <B> B foldRight(B z, Function2<SymbolPair, B, B> op) {
                    return (B)TraversableOnce.foldRight$(this, z, op);
                }

                public <B> B reduceLeft(Function2<B, SymbolPair, B> op) {
                    return (B)TraversableOnce.reduceLeft$(this, op);
                }

                public <B> B reduceRight(Function2<SymbolPair, B, B> op) {
                    return (B)TraversableOnce.reduceRight$(this, op);
                }

                public <B> Option<B> reduceLeftOption(Function2<B, SymbolPair, B> op) {
                    return TraversableOnce.reduceLeftOption$(this, op);
                }

                public <B> Option<B> reduceRightOption(Function2<SymbolPair, B, B> op) {
                    return TraversableOnce.reduceRightOption$(this, op);
                }

                public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                    return (A1)TraversableOnce.reduce$(this, op);
                }

                public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                    return TraversableOnce.reduceOption$(this, op);
                }

                public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                    return (A1)TraversableOnce.fold$(this, z, op);
                }

                public <B> B aggregate(Function0<B> z, Function2<B, SymbolPair, B> seqop, Function2<B, B, B> combop) {
                    return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
                }

                public <B> B sum(Numeric<B> num) {
                    return (B)TraversableOnce.sum$(this, num);
                }

                public <B> B product(Numeric<B> num) {
                    return (B)TraversableOnce.product$(this, num);
                }

                public Object min(Ordering cmp) {
                    return TraversableOnce.min$(this, cmp);
                }

                public Object max(Ordering cmp) {
                    return TraversableOnce.max$(this, cmp);
                }

                public Object maxBy(Function1 f, Ordering cmp) {
                    return TraversableOnce.maxBy$(this, f, cmp);
                }

                public Object minBy(Function1 f, Ordering cmp) {
                    return TraversableOnce.minBy$(this, f, cmp);
                }

                public <B> void copyToBuffer(Buffer<B> dest) {
                    TraversableOnce.copyToBuffer$(this, dest);
                }

                public <B> void copyToArray(Object xs, int start) {
                    TraversableOnce.copyToArray$(this, xs, start);
                }

                public <B> void copyToArray(Object xs) {
                    TraversableOnce.copyToArray$(this, xs);
                }

                public <B> Object toArray(ClassTag<B> evidence$1) {
                    return TraversableOnce.toArray$(this, evidence$1);
                }

                public List<SymbolPair> toList() {
                    return TraversableOnce.toList$(this);
                }

                public Iterable<SymbolPair> toIterable() {
                    return TraversableOnce.toIterable$(this);
                }

                public Seq<SymbolPair> toSeq() {
                    return TraversableOnce.toSeq$(this);
                }

                public IndexedSeq<SymbolPair> toIndexedSeq() {
                    return TraversableOnce.toIndexedSeq$(this);
                }

                public <B> Buffer<B> toBuffer() {
                    return TraversableOnce.toBuffer$(this);
                }

                public <B> Set<B> toSet() {
                    return TraversableOnce.toSet$(this);
                }

                public Vector<SymbolPair> toVector() {
                    return TraversableOnce.toVector$(this);
                }

                public <Col> Col to(CanBuildFrom<Nothing$, SymbolPair, Col> cbf) {
                    return (Col)TraversableOnce.to$(this, cbf);
                }

                public <T, U> Map<T, U> toMap(Predef$.less.colon.less<SymbolPair, Tuple2<T, U>> ev) {
                    return TraversableOnce.toMap$(this, ev);
                }

                public String mkString(String start, String sep, String end) {
                    return TraversableOnce.mkString$(this, start, sep, end);
                }

                public String mkString(String sep) {
                    return TraversableOnce.mkString$(this, sep);
                }

                public String mkString() {
                    return TraversableOnce.mkString$(this);
                }

                public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                    return TraversableOnce.addString$(this, b, start, sep, end);
                }

                public StringBuilder addString(StringBuilder b, String sep) {
                    return TraversableOnce.addString$(this, b, sep);
                }

                public StringBuilder addString(StringBuilder b) {
                    return TraversableOnce.addString$(this, b);
                }

                public int sizeHintIfCheap() {
                    return GenTraversableOnce.sizeHintIfCheap$(this);
                }

                public boolean hasNext() {
                    return this.$outer.hasNext();
                }

                public SymbolPair next() {
                    SymbolPair symbolPair;
                    try {
                        symbolPair = this.$outer.currentPair();
                    }
                    finally {
                        this.$outer.next();
                    }
                    return symbolPair;
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    GenTraversableOnce.$init$(this);
                    TraversableOnce.$init$(this);
                    Iterator.$init$(this);
                }
            };
        }

        public void next() {
            if (this.curEntry != null) {
                this.lowSymbol = this.curEntry.sym();
                this.advanceNextEntry();
                if (this.nextEntry == null) {
                    this.advanceCurEntry();
                    this.next();
                    return;
                }
            }
        }

        public /* synthetic */ SymbolPairs scala$reflect$internal$SymbolPairs$Cursor$$$outer() {
            return this.$outer;
        }

        private final void fillDecls$1(List bcs, boolean deferred) {
            if (!bcs.isEmpty()) {
                this.fillDecls$1((List)bcs.tail(), deferred);
                for (Scopes.ScopeEntry e = ((Symbols.Symbol)bcs.head()).info().decls().elems(); e != null; e = e.next()) {
                    if (e.sym().initialize().isDeferred() != deferred || this.exclude(e.sym())) continue;
                    this.decls().enter(e.sym());
                }
            }
        }

        public static final /* synthetic */ void $anonfun$init$1(Cursor $this, IntRef i$1, Symbols.Symbol bc) {
            $this.index().update(bc, BoxesRunTime.boxToInteger(i$1.elem));
            $this.subParents()[i$1.elem] = new int[$this.size()];
            ++i$1.elem;
        }

        public static final /* synthetic */ boolean $anonfun$init$3(Cursor $this, Types.Type p$1, Symbols.Symbol bc) {
            return $this.scala$reflect$internal$SymbolPairs$Cursor$$$outer().sameInBaseClass(bc, p$1, $this.self());
        }

        public static final /* synthetic */ void $anonfun$init$4(Cursor $this, int pIndex$1, Symbols.Symbol bc) {
            int bcIndex = BoxesRunTime.unboxToInt($this.index().apply(bc));
            if (bcIndex >= 0) {
                $this.include($this.subParents()[bcIndex], pIndex$1);
            }
        }

        public static final /* synthetic */ void $anonfun$init$2(Cursor $this, Types.Type p) {
            int pIndex = BoxesRunTime.unboxToInt($this.index().apply(p.typeSymbol()));
            if (pIndex >= 0) {
                p.baseClasses().withFilter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)bc -> BoxesRunTime.boxToBoolean(Cursor.$anonfun$init$3($this, p, bc))).foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)bc -> {
                    Cursor.$anonfun$init$4($this, pIndex, bc);
                    return BoxedUnit.UNIT;
                });
            }
        }

        public Cursor(SymbolPairs $outer, Symbols.Symbol base) {
            this.base = base;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.self = base.thisType();
            this.decls = $outer.global().newScope();
            this.size = this.bases().length();
            this.subParents = new int[this.size()][];
            this.index = new HashMap<Symbols.Symbol, Object>(null){

                public int default(Symbols.Symbol key) {
                    return -1;
                }
            };
            this.visited = HashSet$.MODULE$.apply("visited", 64);
            this.init();
            this.nextEntry = this.curEntry = this.decls().elems();
            this.next();
        }

        public static final /* synthetic */ Object $anonfun$init$1$adapted(Cursor $this, IntRef i$1, Symbols.Symbol bc) {
            Cursor.$anonfun$init$1($this, i$1, bc);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$init$2$adapted(Cursor $this, Types.Type p) {
            Cursor.$anonfun$init$2($this, p);
            return BoxedUnit.UNIT;
        }
    }

    public final class SymbolPair
    implements Product,
    Serializable {
        private final Symbols.Symbol base;
        private final Symbols.Symbol low;
        private final Symbols.Symbol high;
        private final Types.Type self;
        private final /* synthetic */ SymbolPairs $outer;

        public Symbols.Symbol base() {
            return this.base;
        }

        public Symbols.Symbol low() {
            return this.low;
        }

        public Symbols.Symbol high() {
            return this.high;
        }

        public Position pos() {
            Symbols.Symbol symbol = this.low().owner();
            Symbols.Symbol symbol2 = this.base();
            if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                return this.low().pos();
            }
            Symbols.Symbol symbol3 = this.high().owner();
            Symbols.Symbol symbol4 = this.base();
            if (!(symbol3 != null ? !symbol3.equals(symbol4) : symbol4 != null)) {
                return this.high().pos();
            }
            return this.base().pos();
        }

        public Types.Type rootType() {
            return this.self;
        }

        public Types.Type lowType() {
            return this.self.memberType(this.low());
        }

        public Types.Type lowErased() {
            return this.$outer.global().erasure().specialErasure(this.base(), this.low().tpe());
        }

        public Types.Type lowClassBound() {
            return this.classBoundAsSeen(this.low().tpe().typeSymbol());
        }

        public Types.Type highType() {
            return this.self.memberType(this.high());
        }

        public Types.Type highInfo() {
            return this.self.memberInfo(this.high());
        }

        public Types.Type highErased() {
            return this.$outer.global().erasure().specialErasure(this.base(), this.high().tpe());
        }

        public Types.Type highClassBound() {
            return this.classBoundAsSeen(this.high().tpe().typeSymbol());
        }

        public boolean isErroneous() {
            return this.low().tpe().isErroneous() || this.high().tpe().isErroneous();
        }

        public boolean sameKind() {
            return this.$outer.global().sameLength(this.low().typeParams(), this.high().typeParams());
        }

        private Types.Type classBoundAsSeen(Symbols.Symbol tsym) {
            return tsym.classBound().asSeenFrom(this.rootType(), tsym.owner());
        }

        private String memberDefString(Symbols.Symbol sym, boolean where) {
            String def_s = sym.isConstructor() ? new java.lang.StringBuilder(2).append(sym).append(": ").append(this.self.memberType(sym)).toString() : sym.defStringSeenAs(this.self.memberType(sym));
            return new java.lang.StringBuilder(0).append(def_s).append(this.whereString(sym)).toString();
        }

        private String whereString(Symbols.Symbol sym) {
            Symbols.Symbol symbol = sym.owner();
            Symbols.Symbol symbol2 = this.base();
            if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                return new java.lang.StringBuilder(9).append(" at line ").append(sym.pos().line()).toString();
            }
            return sym.locationString();
        }

        public String lowString() {
            return this.memberDefString(this.low(), true);
        }

        public String highString() {
            return this.memberDefString(this.high(), true);
        }

        public String toString() {
            return ((StripMarginInterpolator)this.$outer.global().StringContextStripMarginOps().apply(new StringContext(Predef$.MODULE$.wrapRefArray((Object[])new String[]{"\n      |Cursor(in ", ") {\n      |   high  ", "\n      | erased  ", "\n      |  infos  ", "\n      |    low  ", "\n      | erased  ", "\n      |  infos  ", "\n      |}"})))).sm(Predef$.MODULE$.genericWrapArray(new Object[]{this.base(), this.highString(), this.highErased(), this.high().infosString(), this.lowString(), this.lowErased(), this.low().infosString()})).trim();
        }

        public SymbolPair copy(Symbols.Symbol base, Symbols.Symbol low, Symbols.Symbol high) {
            return new SymbolPair(this.$outer, base, low, high);
        }

        public Symbols.Symbol copy$default$1() {
            return this.base();
        }

        public Symbols.Symbol copy$default$2() {
            return this.low();
        }

        public Symbols.Symbol copy$default$3() {
            return this.high();
        }

        @Override
        public String productPrefix() {
            return "SymbolPair";
        }

        @Override
        public int productArity() {
            return 3;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.base();
                }
                case 1: {
                    return this.low();
                }
                case 2: {
                    return this.high();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof SymbolPair;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof SymbolPair)) return false;
            boolean bl = true;
            if (!bl) return false;
            SymbolPair symbolPair = (SymbolPair)x$1;
            Symbols.Symbol symbol = this.base();
            Symbols.Symbol symbol2 = symbolPair.base();
            if (symbol == null) {
                if (symbol2 != null) {
                    return false;
                }
            } else if (!symbol.equals(symbol2)) return false;
            Symbols.Symbol symbol3 = this.low();
            Symbols.Symbol symbol4 = symbolPair.low();
            if (symbol3 == null) {
                if (symbol4 != null) {
                    return false;
                }
            } else if (!symbol3.equals(symbol4)) return false;
            Symbols.Symbol symbol5 = this.high();
            Symbols.Symbol symbol6 = symbolPair.high();
            if (symbol5 == null) {
                if (symbol6 == null) return true;
                return false;
            } else {
                if (!symbol5.equals(symbol6)) return false;
                return true;
            }
        }

        public SymbolPair(SymbolPairs $outer, Symbols.Symbol base, Symbols.Symbol low, Symbols.Symbol high) {
            this.base = base;
            this.low = low;
            this.high = high;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
            this.self = base.thisType();
        }
    }
}

