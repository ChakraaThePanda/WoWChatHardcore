/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSeq;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.Ordering$Int$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.TableDef$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import scala.runtime.Tuple2Zipped$;
import scala.runtime.Tuple2Zipped$Ops$;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.runtime.java8.JFunction1$mcII$sp;

@ScalaSignature(bytes="\u0006\u0001\r\u0005a\u0001\u0002%J\u0001IC\u0001\u0002\u0017\u0001\u0003\u0002\u0003\u0006I!\u0017\u0005\u0007E\u0002!\tAa\r\t\u000f\te\u0002\u0001\"\u0001\u0003<!I!\u0011\u0006\u0001A\u0002\u0013%!\u0011\t\u0005\n\u0005\u0013\u0002\u0001\u0019!C\u0005\u0005\u0017B\u0001B!\u0016\u0001A\u0003&!1\t\u0005\b\u0005/\u0002A\u0011\u0001B-\u0011\u001d\u0011y\u0006\u0001C\u0001\u0005CBqAa\u001a\u0001\t\u0003\u0011I\u0007C\u0004\u0003x\u0001!\tA!\u001f\t\u000f\t}\u0004\u0001\"\u0001\u0003\u0002\"9!q\u0011\u0001\u0005\u0002\t%\u0005b\u0002BI\u0001\u0011\u0005!1\u0013\u0004\u0007\u0005C\u0003\u0001Aa)\t\u0015\t\u001dfB!b\u0001\n\u0003\u0011I\u000b\u0003\u0006\u0003,:\u0011\t\u0011)A\u0005\u0005KCaA\u0019\b\u0005\u0002\t5\u0006b\u0002BZ\u001d\u0011\u0005!Q\u0017\u0005\b\u0003CtA\u0011\u0001B]\u0011\u001d\u0011iL\u0004C\u0001\u0003_CqAa0\u000f\t\u0003\u0011\t\rC\u0004\u0003H:!\tA!\u001f\t\u0013\t%gB1A\u0005\u0002\t-\u0007\u0002\u0003Bh\u001d\u0001\u0006IA!4\t\u0011\tEgB1A\u0005\u00029DqAa5\u000fA\u0003%q\u000e\u0003\u0005\u0003V:\u0011\r\u0011\"\u0001o\u0011\u001d\u00119N\u0004Q\u0001\n=D\u0011B!7\u000f\u0005\u0004%\tAa7\t\u0011\t\u0005h\u0002)A\u0005\u0005;D\u0011Ba9\u000f\u0005\u0004%\tA!\u001f\t\u0011\t\u0015h\u0002)A\u0005\u0005wBqAa:\u000f\t\u0003\u0011I\u000fC\u0004\u0003r:!\tAa=\t\u000f\t]h\u0002\"\u0001\u0003z!9\u00111\u000b\b\u0005B\te\bb\u0002B~\u0001\u0011\u0005!Q \u0005\b\u0003'\u0002A\u0011\tB}\u000f\u0015y\u0016\n#\u0001a\r\u0015A\u0015\n#\u0001b\u0011\u0015\u0011\u0007\u0006\"\u0001d\r\u0011!\u0007\u0006Q3\t\u00115T#Q3A\u0005\u00029D\u0001B\u001f\u0016\u0003\u0012\u0003\u0006Ia\u001c\u0005\tw*\u0012)\u001a!C\u0001y\"I\u0011q\u0003\u0016\u0003\u0012\u0003\u0006I! \u0005\u000b\u00033Q#Q3A\u0005\u0002\u0005m\u0001BCA\u0012U\tE\t\u0015!\u0003\u0002\u001e!1!M\u000bC\u0001\u0003KAq!!\r+\t\u0003\t\u0019\u0004C\u0004\u0002N)\"\t!a\u0014\t\u000f\u0005M#\u0006\"\u0011\u0002V!I\u0011Q\r\u0016\u0002\u0002\u0013\u0005\u0011q\r\u0005\n\u0003sR\u0013\u0013!C\u0001\u0003wB\u0011\"!&+#\u0003%\t!a&\t\u0013\u0005}%&%A\u0005\u0002\u0005\u0005\u0006\"CAUU\u0005\u0005I\u0011IAV\u0011%\tiKKA\u0001\n\u0003\ty\u000bC\u0005\u00022*\n\t\u0011\"\u0001\u00024\"I\u0011\u0011\u0018\u0016\u0002\u0002\u0013\u0005\u00131\u0018\u0005\n\u0003\u0013T\u0013\u0011!C\u0001\u0003\u0017D\u0011\"a4+\u0003\u0003%\t%!5\t\u0013\u0005M'&!A\u0005B\u0005Uw!CAmQ\u0005\u0005\t\u0012AAn\r!!\u0007&!A\t\u0002\u0005u\u0007B\u00022B\t\u0003\ty\u000eC\u0005\u0002T\u0005\u000b\t\u0011\"\u0012\u0002V!I\u0011\u0011]!\u0002\u0002\u0013\u0005\u00151\u001d\u0005\n\u0003k\f\u0015\u0011!CA\u0003oD\u0011Ba\u0005B\u0003\u0003%IA!\u0006\t\u000f\u0005\u0005\b\u0006\"\u0001\u0003\u001e\tAA+\u00192mK\u0012+gM\u0003\u0002K\u0017\u0006!Q\u000f^5m\u0015\taU*\u0001\u0005j]R,'O\\1m\u0015\tqu*A\u0004sK\u001adWm\u0019;\u000b\u0003A\u000bQa]2bY\u0006\u001c\u0001!F\u0002T\u0005c\u0019\"\u0001\u0001+\u0011\u0005U3V\"A(\n\u0005]{%AB!osJ+g-A\u0003`G>d7\u000fE\u0002V5rK!aW(\u0003\u0015q\u0012X\r]3bi\u0016$g\b\u0005\u0003^U\t=bB\u00010(\u001b\u0005I\u0015\u0001\u0003+bE2,G)\u001a4\u0011\u0005yC3C\u0001\u0015U\u0003\u0019a\u0014N\\5u}Q\t\u0001M\u0001\u0004D_2,XN\\\u000b\u0004M\u0006\u00151\u0003\u0002\u0016UO*\u0004\"!\u00165\n\u0005%|%a\u0002)s_\u0012,8\r\u001e\t\u0003+.L!\u0001\\(\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\t9\fW.Z\u000b\u0002_B\u0011\u0001o\u001e\b\u0003cV\u0004\"A](\u000e\u0003MT!\u0001^)\u0002\rq\u0012xn\u001c;?\u0013\t1x*\u0001\u0004Qe\u0016$WMZ\u0005\u0003qf\u0014aa\u0015;sS:<'B\u0001<P\u0003\u0015q\u0017-\\3!\u0003\u00051W#A?\u0011\rUs\u0018\u0011AA\t\u0013\tyxJA\u0005Gk:\u001cG/[8ocA!\u00111AA\u0003\u0019\u0001!\u0001\"a\u0002+\u0011\u000b\u0007\u0011\u0011\u0002\u0002\u0002)F!\u00111BA\t!\r)\u0016QB\u0005\u0004\u0003\u001fy%a\u0002(pi\"Lgn\u001a\t\u0004+\u0006M\u0011bAA\u000b\u001f\n\u0019\u0011I\\=\u0002\u0005\u0019\u0004\u0013\u0001\u00027fMR,\"!!\b\u0011\u0007U\u000by\"C\u0002\u0002\"=\u0013qAQ8pY\u0016\fg.A\u0003mK\u001a$\b\u0005\u0006\u0005\u0002(\u0005-\u0012QFA\u0018!\u0015\tICKA\u0001\u001b\u0005A\u0003\"B72\u0001\u0004y\u0007\"B>2\u0001\u0004i\bbBA\rc\u0001\u0007\u0011QD\u0001\t[\u0006Dx+\u001b3uQR!\u0011QGA\u001e!\r)\u0016qG\u0005\u0004\u0003sy%aA%oi\"9\u0011Q\b\u001aA\u0002\u0005}\u0012!B3mK6\u001c\bCBA!\u0003\u000f\n\tAD\u0002V\u0003\u0007J1!!\u0012P\u0003\u001d\u0001\u0018mY6bO\u0016LA!!\u0013\u0002L\t\u00191+Z9\u000b\u0007\u0005\u0015s*\u0001\u0006g_Jl\u0017\r^*qK\u000e$2a\\A)\u0011\u001d\tid\ra\u0001\u0003\u007f\t\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0003/\u0002B!!\u0017\u0002d5\u0011\u00111\f\u0006\u0005\u0003;\ny&\u0001\u0003mC:<'BAA1\u0003\u0011Q\u0017M^1\n\u0007a\fY&\u0001\u0003d_BLX\u0003BA5\u0003_\"\u0002\"a\u001b\u0002r\u0005M\u0014q\u000f\t\u0006\u0003SQ\u0013Q\u000e\t\u0005\u0003\u0007\ty\u0007B\u0004\u0002\bU\u0012\r!!\u0003\t\u000f5,\u0004\u0013!a\u0001_\"A10\u000eI\u0001\u0002\u0004\t)\b\u0005\u0004V}\u00065\u0014\u0011\u0003\u0005\n\u00033)\u0004\u0013!a\u0001\u0003;\tabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0003\u0002~\u0005MUCAA@U\ry\u0017\u0011Q\u0016\u0003\u0003\u0007\u0003B!!\"\u0002\u00106\u0011\u0011q\u0011\u0006\u0005\u0003\u0013\u000bY)A\u0005v]\u000eDWmY6fI*\u0019\u0011QR(\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002\u0012\u0006\u001d%!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u00129\u0011q\u0001\u001cC\u0002\u0005%\u0011AD2paf$C-\u001a4bk2$HEM\u000b\u0005\u00033\u000bi*\u0006\u0002\u0002\u001c*\u001aQ0!!\u0005\u000f\u0005\u001dqG1\u0001\u0002\n\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u001aT\u0003BAR\u0003O+\"!!*+\t\u0005u\u0011\u0011\u0011\u0003\b\u0003\u000fA$\u0019AA\u0005\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\u0011\u0011qK\u0001\raJ|G-^2u\u0003JLG/_\u000b\u0003\u0003k\ta\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0003\u0002\u0012\u0005U\u0006\"CA\\w\u0005\u0005\t\u0019AA\u001b\u0003\rAH%M\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011\u0011Q\u0018\t\u0007\u0003\u007f\u000b)-!\u0005\u000e\u0005\u0005\u0005'bAAb\u001f\u0006Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u0005\u001d\u0017\u0011\u0019\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002\u001e\u00055\u0007\"CA\\{\u0005\u0005\t\u0019AA\t\u0003!A\u0017m\u001d5D_\u0012,GCAA\u001b\u0003\u0019)\u0017/^1mgR!\u0011QDAl\u0011%\t9lPA\u0001\u0002\u0004\t\t\"\u0001\u0004D_2,XN\u001c\t\u0004\u0003S\t5cA!UUR\u0011\u00111\\\u0001\u0006CB\u0004H._\u000b\u0005\u0003K\fY\u000f\u0006\u0005\u0002h\u00065\u0018q^Az!\u0015\tICKAu!\u0011\t\u0019!a;\u0005\u000f\u0005\u001dAI1\u0001\u0002\n!)Q\u000e\u0012a\u0001_\"11\u0010\u0012a\u0001\u0003c\u0004b!\u0016@\u0002j\u0006E\u0001bBA\r\t\u0002\u0007\u0011QD\u0001\bk:\f\u0007\u000f\u001d7z+\u0011\tIPa\u0003\u0015\t\u0005m(Q\u0002\t\u0006+\u0006u(\u0011A\u0005\u0004\u0003\u007f|%AB(qi&|g\u000e\u0005\u0005V\u0005\u0007y'qAA\u000f\u0013\r\u0011)a\u0014\u0002\u0007)V\u0004H.Z\u001a\u0011\rUs(\u0011BA\t!\u0011\t\u0019Aa\u0003\u0005\u000f\u0005\u001dQI1\u0001\u0002\n!I!qB#\u0002\u0002\u0003\u0007!\u0011C\u0001\u0004q\u0012\u0002\u0004#BA\u0015U\t%\u0011a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"Aa\u0006\u0011\t\u0005e#\u0011D\u0005\u0005\u00057\tYF\u0001\u0004PE*,7\r^\u000b\u0005\u0005?\u0011)\u0003\u0006\u0003\u0003\"\t\u001d\u0002\u0003\u00020\u0001\u0005G\u0001B!a\u0001\u0003&\u00119\u0011qA$C\u0002\u0005%\u0001b\u0002B\u0015\u000f\u0002\u0007!1F\u0001\u0005G>d7\u000f\u0005\u0003V5\n5\u0002#BA\u0015U\t\r\u0002\u0003BA\u0002\u0005c!q!a\u0002\u0001\u0005\u0004\tI\u0001\u0006\u0003\u00036\t]\u0002\u0003\u00020\u0001\u0005_AQ\u0001\u0017\u0002A\u0002e\u000ba\u0001\n;jY\u0012,G\u0003\u0002B\u001b\u0005{AaAa\u0010\u0004\u0001\u0004a\u0016\u0001\u00028fqR,\"Aa\u0011\u0011\u000b\u0005\u0005#Q\t/\n\t\t\u001d\u00131\n\u0002\u0005\u0019&\u001cH/\u0001\u0005d_2\u001cx\fJ3r)\u0011\u0011iEa\u0015\u0011\u0007U\u0013y%C\u0002\u0003R=\u0013A!\u00168ji\"I\u0011qW\u0003\u0002\u0002\u0003\u0007!1I\u0001\u0006G>d7\u000fI\u0001\u000bI\u00164\u0017-\u001e7u'\u0016\u0004H\u0003BA,\u00057BqA!\u0018\b\u0001\u0004\t)$A\u0003j]\u0012,\u00070\u0001\u0005tKB\fe\r^3s)\ry'1\r\u0005\b\u0005KB\u0001\u0019AA\u001b\u0003\u0005I\u0017!C:fa^KG\r\u001e5t+\t\u0011Y\u0007\u0005\u0004\u0003n\tM\u0014QG\u0007\u0003\u0005_RAA!\u001d\u0002B\u0006I\u0011.\\7vi\u0006\u0014G.Z\u0005\u0005\u0005k\u0012yG\u0001\u0006J]\u0012,\u00070\u001a3TKF\f\u0001bY8m\u001d\u0006lWm]\u000b\u0003\u0005w\u0002RA!\u001c\u0003~=LAAa\u0012\u0003p\u0005a1m\u001c7Gk:\u001cG/[8ogV\u0011!1\u0011\t\u0007\u0005[\u0012iH!\"\u0011\rUs(qFA\t\u0003!\u0019w\u000e\\!qa2LH\u0003\u0002BF\u0005\u001b\u0003bA!\u001c\u0003~\u0005E\u0001b\u0002BH\u0019\u0001\u0007!qF\u0001\u0003K2\fqA]3u)\"L7\u000f\u0006\u0003\u0003\u0016\n]U\"\u0001\u0001\t\u0011\teU\u0002\"a\u0001\u00057\u000bAAY8esB)QK!(\u0003N%\u0019!qT(\u0003\u0011q\u0012\u0017P\\1nKz\u0012Q\u0001V1cY\u0016\u001cBA\u0004+\u0003&B1\u0011\u0011IA$\u0005_\tAA]8xgV\u0011!QU\u0001\u0006e><8\u000f\t\u000b\u0005\u0005_\u0013\t\fE\u0002\u0003\u0016:AqAa*\u0012\u0001\u0004\u0011)+\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\u00119\f\u0005\u0004\u0002@\u0006\u0015'q\u0006\u000b\u0005\u0005_\u0011Y\fC\u0004\u0003^M\u0001\r!!\u000e\u0002\r1,gn\u001a;i\u0003-i\u0017\r_\"pY^KG\r\u001e5\u0015\t\u0005U\"1\u0019\u0005\u0007\u0005\u000b,\u0002\u0019\u0001/\u0002\u0007\r|G.A\u0003ta\u0016\u001c7/A\u0005d_2<\u0016\u000e\u001a;igV\u0011!Q\u001a\t\u0007\u0005[\u0012i(!\u000e\u0002\u0015\r|GnV5ei\"\u001c\b%A\u0005s_^4uN]7bi\u0006Q!o\\<G_Jl\u0017\r\u001e\u0011\u0002\u0015!,\u0017\r\u001a$pe6\fG/A\u0006iK\u0006$gi\u001c:nCR\u0004\u0013\u0001C1sO2K7\u000f^:\u0016\u0005\tu\u0007CBA`\u0005?\u0014Y)\u0003\u0003\u0002J\u0005\u0005\u0017!C1sO2K7\u000f^:!\u0003\u001dAW-\u00193feN\f\u0001\u0002[3bI\u0016\u00148\u000fI\u0001\u000f[.4uN]7biN#(/\u001b8h)\ry'1\u001e\u0005\b\u0005[\f\u0003\u0019\u0001Bx\u0003\u0011\u0019X\r\u001d4\u0011\u000bUs\u0018QG8\u0002\u001dQ|gi\u001c:nCR$X\rZ*fcV\u0011!Q\u001f\t\u0006\u0003\u007f\u0013yn\\\u0001\tC2dGk\\*fcR\tq.A\u0003uC\ndW\r\u0006\u0003\u00030\n}\bb\u0002BTK\u0001\u0007!Q\u0015")
public class TableDef<T> {
    private List<Column<T>> scala$reflect$internal$util$TableDef$$cols;

    public static <T> TableDef<T> apply(Seq<Column<T>> seq) {
        return TableDef$.MODULE$.apply(seq);
    }

    public TableDef<T> $tilde(Column<T> next) {
        return this.retThis((JFunction0$mcV$sp & Serializable)() -> this.scala$reflect$internal$util$TableDef$$cols_$eq(this.scala$reflect$internal$util$TableDef$$cols().$colon$plus(next, List$.MODULE$.canBuildFrom())));
    }

    public List<Column<T>> scala$reflect$internal$util$TableDef$$cols() {
        return this.scala$reflect$internal$util$TableDef$$cols;
    }

    private void scala$reflect$internal$util$TableDef$$cols_$eq(List<Column<T>> x$1) {
        this.scala$reflect$internal$util$TableDef$$cols = x$1;
    }

    public String defaultSep(int index) {
        if (index > this.scala$reflect$internal$util$TableDef$$cols().size() - 2) {
            return "";
        }
        return " ";
    }

    public String sepAfter(int i) {
        return this.defaultSep(i);
    }

    public IndexedSeq<Object> sepWidths() {
        return this.scala$reflect$internal$util$TableDef$$cols().indices().map((JFunction1$mcII$sp & Serializable)i -> this.sepAfter(i).length(), IndexedSeq$.MODULE$.canBuildFrom());
    }

    public List<String> colNames() {
        return this.scala$reflect$internal$util$TableDef$$cols().map((Function1<Column, String> & java.io.Serializable & Serializable)x$1 -> x$1.name(), List$.MODULE$.canBuildFrom());
    }

    public List<Function1<T, Object>> colFunctions() {
        return this.scala$reflect$internal$util$TableDef$$cols().map((Function1<Column, Function1> & java.io.Serializable & Serializable)x$2 -> x$2.f(), List$.MODULE$.canBuildFrom());
    }

    public List<Object> colApply(T el) {
        return this.colFunctions().map((Function1<Function1, Object> & java.io.Serializable & Serializable)f -> f.apply(el), List$.MODULE$.canBuildFrom());
    }

    public TableDef<T> retThis(Function0<BoxedUnit> body) {
        body.apply$mcV$sp();
        return this;
    }

    public Table table(Seq<T> rows) {
        return new Table(this, rows);
    }

    public String toString() {
        return this.scala$reflect$internal$util$TableDef$$cols().mkString("TableDef(", ", ", ")");
    }

    public TableDef(Seq<Column<T>> _cols) {
        this.scala$reflect$internal$util$TableDef$$cols = _cols.toList();
    }

    public static class Column<T>
    implements Product,
    Serializable {
        private final String name;
        private final Function1<T, Object> f;
        private final boolean left;

        public String name() {
            return this.name;
        }

        public Function1<T, Object> f() {
            return this.f;
        }

        public boolean left() {
            return this.left;
        }

        public int maxWidth(Seq<T> elems) {
            String string = this.name();
            return BoxesRunTime.unboxToInt(((TraversableOnce)((TraversableLike)((SeqLike)elems.map(this.f(), Seq$.MODULE$.canBuildFrom())).$plus$colon(string, Seq$.MODULE$.canBuildFrom())).map((Function1<Object, Object> & java.io.Serializable & Serializable)x$7 -> BoxesRunTime.boxToInteger(Column.$anonfun$maxWidth$1(x$7)), Seq$.MODULE$.canBuildFrom())).max(Ordering$Int$.MODULE$));
        }

        public String formatSpec(Seq<T> elems) {
            String justify = this.left() ? "-" : "";
            return new java.lang.StringBuilder(2).append("%").append(justify).append(this.maxWidth(elems)).append("s").toString();
        }

        public String toString() {
            String justify = this.left() ? "<<" : ">>";
            return new java.lang.StringBuilder(2).append(justify).append("(").append(this.name()).append(")").toString();
        }

        public <T> Column<T> copy(String name, Function1<T, Object> f, boolean left) {
            return new Column<T>(name, f, left);
        }

        public <T> String copy$default$1() {
            return this.name();
        }

        public <T> Function1<T, Object> copy$default$2() {
            return this.f();
        }

        public <T> boolean copy$default$3() {
            return this.left();
        }

        @Override
        public String productPrefix() {
            return "Column";
        }

        @Override
        public int productArity() {
            return 3;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.name();
                }
                case 1: {
                    return this.f();
                }
                case 2: {
                    return BoxesRunTime.boxToBoolean(this.left());
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
            return x$1 instanceof Column;
        }

        public int hashCode() {
            return Statics.finalizeHash(Statics.mix(Statics.mix(Statics.mix(-889275714, Statics.anyHash(this.name())), Statics.anyHash(this.f())), this.left() ? 1231 : 1237), 3);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof Column)) return false;
            boolean bl = true;
            if (!bl) return false;
            Column column = (Column)x$1;
            String string = this.name();
            String string2 = column.name();
            if (string == null) {
                if (string2 != null) {
                    return false;
                }
            } else if (!string.equals(string2)) return false;
            Function1<T, Object> function1 = this.f();
            Function1<T, Object> function12 = column.f();
            if (function1 == null) {
                if (function12 != null) {
                    return false;
                }
            } else if (!function1.equals(function12)) return false;
            if (this.left() != column.left()) return false;
            if (!column.canEqual(this)) return false;
            return true;
        }

        public static final /* synthetic */ int $anonfun$maxWidth$1(Object x$7) {
            return x$7.toString().length();
        }

        public Column(String name, Function1<T, Object> f, boolean left) {
            this.name = name;
            this.f = f;
            this.left = left;
            Product.$init$(this);
        }
    }

    public class Table
    implements Seq<T> {
        private final Seq<T> rows;
        private final List<Object> colWidths;
        private final String rowFormat;
        private final String headFormat;
        private final Seq<List<Object>> argLists;
        private final List<String> headers;
        public final /* synthetic */ TableDef $outer;

        @Override
        public GenericCompanion<Seq> companion() {
            return Seq.companion$(this);
        }

        @Override
        public Seq<T> seq() {
            return Seq.seq$(this);
        }

        @Override
        public Seq<T> thisCollection() {
            return SeqLike.thisCollection$(this);
        }

        @Override
        public Seq toCollection(Object repr) {
            return SeqLike.toCollection$(this, repr);
        }

        @Override
        public Combiner<T, ParSeq<T>> parCombiner() {
            return SeqLike.parCombiner$(this);
        }

        @Override
        public int lengthCompare(int len) {
            return SeqLike.lengthCompare$(this, len);
        }

        @Override
        public boolean isEmpty() {
            return SeqLike.isEmpty$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public int segmentLength(Function1<T, Object> p, int from) {
            return SeqLike.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<T, Object> p, int from) {
            return SeqLike.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<T, Object> p, int end) {
            return SeqLike.lastIndexWhere$(this, p, end);
        }

        @Override
        public Iterator<Seq<T>> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<Seq<T>> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public Object reverse() {
            return SeqLike.reverse$(this);
        }

        @Override
        public <B, That> That reverseMap(Function1<T, B> f, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
        }

        @Override
        public Iterator<T> reverseIterator() {
            return SeqLike.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return SeqLike.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public <B> int indexOfSlice(GenSeq<B> that) {
            return SeqLike.indexOfSlice$(this, that);
        }

        @Override
        public <B> int indexOfSlice(GenSeq<B> that, int from) {
            return SeqLike.indexOfSlice$(this, that, from);
        }

        @Override
        public <B> int lastIndexOfSlice(GenSeq<B> that) {
            return SeqLike.lastIndexOfSlice$(this, that);
        }

        @Override
        public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
            return SeqLike.lastIndexOfSlice$(this, that, end);
        }

        @Override
        public <B> boolean containsSlice(GenSeq<B> that) {
            return SeqLike.containsSlice$(this, that);
        }

        @Override
        public <A1> boolean contains(A1 elem) {
            return SeqLike.contains$(this, elem);
        }

        @Override
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)SeqLike.union$(this, that, bf);
        }

        @Override
        public Object diff(GenSeq that) {
            return SeqLike.diff$(this, that);
        }

        @Override
        public Object intersect(GenSeq that) {
            return SeqLike.intersect$(this, that);
        }

        @Override
        public Object distinct() {
            return SeqLike.distinct$(this);
        }

        @Override
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<T, B, Object> p) {
            return SeqLike.corresponds$(this, that, p);
        }

        @Override
        public Object sortWith(Function2 lt) {
            return SeqLike.sortWith$(this, lt);
        }

        @Override
        public Object sortBy(Function1 f, Ordering ord) {
            return SeqLike.sortBy$(this, f, ord);
        }

        @Override
        public Object sorted(Ordering ord) {
            return SeqLike.sorted$(this, ord);
        }

        @Override
        public Seq<T> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public SeqView<T, Seq<T>> view() {
            return SeqLike.view$(this);
        }

        @Override
        public SeqView<T, Seq<T>> view(int from, int until) {
            return SeqLike.view$(this, from, until);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<T, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<T, Object> p) {
            return GenSeqLike.indexWhere$(this, p);
        }

        @Override
        public <B> int indexOf(B elem) {
            return GenSeqLike.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return GenSeqLike.indexOf$(this, elem, from);
        }

        @Override
        public <B> int lastIndexOf(B elem) {
            return GenSeqLike.lastIndexOf$(this, elem);
        }

        @Override
        public <B> int lastIndexOf(B elem, int end) {
            return GenSeqLike.lastIndexOf$(this, elem, end);
        }

        @Override
        public int lastIndexWhere(Function1<T, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public int hashCode() {
            return GenSeqLike.hashCode$(this);
        }

        @Override
        public boolean equals(Object that) {
            return GenSeqLike.equals$(this, that);
        }

        @Override
        public <U> void foreach(Function1<T, U> f) {
            IterableLike.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<T, Object> p) {
            return IterableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<T, Object> p) {
            return IterableLike.exists$(this, p);
        }

        @Override
        public Option<T> find(Function1<T, Object> p) {
            return IterableLike.find$(this, p);
        }

        @Override
        public <B> B foldRight(B z, Function2<T, B, B> op) {
            return (B)IterableLike.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceRight(Function2<T, B, B> op) {
            return (B)IterableLike.reduceRight$(this, op);
        }

        @Override
        public Iterable<T> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<T> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public T head() {
            return IterableLike.head$(this);
        }

        @Override
        public Object slice(int from, int until) {
            return IterableLike.slice$(this, from, until);
        }

        @Override
        public Object take(int n) {
            return IterableLike.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IterableLike.drop$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IterableLike.takeWhile$(this, p);
        }

        @Override
        public Iterator<Seq<T>> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<Seq<T>> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<Seq<T>> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public Object takeRight(int n) {
            return IterableLike.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IterableLike.dropRight$(this, n);
        }

        @Override
        public <B> void copyToArray(Object xs, int start, int len) {
            IterableLike.copyToArray$(this, xs, start, len);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Seq<T>, Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zip$(this, that, bf);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<Seq<T>, Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<Seq<T>, Tuple2<A1, Object>, That> bf) {
            return (That)IterableLike.zipWithIndex$(this, bf);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public Stream<T> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
        }

        @Override
        public Builder<T, Seq<T>> newBuilder() {
            return GenericTraversableTemplate.newBuilder$(this);
        }

        @Override
        public <B> Builder<B, Seq<B>> genericBuilder() {
            return GenericTraversableTemplate.genericBuilder$(this);
        }

        @Override
        public <A1, A2> Tuple2<Seq<A1>, Seq<A2>> unzip(Function1<T, Tuple2<A1, A2>> asPair) {
            return GenericTraversableTemplate.unzip$(this, asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<Seq<A1>, Seq<A2>, Seq<A3>> unzip3(Function1<T, Tuple3<A1, A2, A3>> asTriple) {
            return GenericTraversableTemplate.unzip3$(this, asTriple);
        }

        @Override
        public GenTraversable flatten(Function1 asTraversable) {
            return GenericTraversableTemplate.flatten$(this, asTraversable);
        }

        @Override
        public GenTraversable transpose(Function1 asTraversable) {
            return GenericTraversableTemplate.transpose$(this, asTraversable);
        }

        @Override
        public Object repr() {
            return TraversableLike.repr$(this);
        }

        @Override
        public final boolean isTraversableAgain() {
            return TraversableLike.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return TraversableLike.hasDefiniteSize$(this);
        }

        @Override
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<T, B> f, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<T, GenTraversableOnce<B>> f, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.flatMap$(this, f, bf);
        }

        @Override
        public Object filterImpl(Function1 p, boolean isFlipped) {
            return TraversableLike.filterImpl$(this, p, isFlipped);
        }

        @Override
        public Object filter(Function1 p) {
            return TraversableLike.filter$(this, p);
        }

        @Override
        public Object filterNot(Function1 p) {
            return TraversableLike.filterNot$(this, p);
        }

        @Override
        public <B, That> That collect(PartialFunction<T, B> pf, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<Seq<T>, Seq<T>> partition(Function1<T, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, Seq<T>> groupBy(Function1<T, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<Seq<T>, B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, T, B> op, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<T, B, B> op, CanBuildFrom<Seq<T>, B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<T> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Object tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public T last() {
            return TraversableLike.last$(this);
        }

        @Override
        public Option<T> lastOption() {
            return TraversableLike.lastOption$(this);
        }

        @Override
        public Object init() {
            return TraversableLike.init$(this);
        }

        @Override
        public Object sliceWithKnownDelta(int from, int until, int delta) {
            return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
        }

        @Override
        public Object sliceWithKnownBound(int from, int until) {
            return TraversableLike.sliceWithKnownBound$(this, from, until);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return TraversableLike.dropWhile$(this, p);
        }

        @Override
        public Tuple2<Seq<T>, Seq<T>> span(Function1<T, Object> p) {
            return TraversableLike.span$(this, p);
        }

        @Override
        public Tuple2<Seq<T>, Seq<T>> splitAt(int n) {
            return TraversableLike.splitAt$(this, n);
        }

        @Override
        public Iterator<Seq<T>> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<Seq<T>> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<T> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<T, Seq<T>> withFilter(Function1<T, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public Parallel par() {
            return Parallelizable.par$(this);
        }

        @Override
        public List<T> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<T, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<T, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, T, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<T, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, T, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, T, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, T, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<T, B, B> op) {
            return TraversableOnce.reduceRightOption$(this, op);
        }

        @Override
        public <A1> A1 reduce(Function2<A1, A1, A1> op) {
            return (A1)TraversableOnce.reduce$(this, op);
        }

        @Override
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
            return (A1)TraversableOnce.fold$(this, z, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, T, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
        }

        @Override
        public <B> B sum(Numeric<B> num) {
            return (B)TraversableOnce.sum$(this, num);
        }

        @Override
        public <B> B product(Numeric<B> num) {
            return (B)TraversableOnce.product$(this, num);
        }

        @Override
        public <B> T min(Ordering<B> cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public <B> T max(Ordering<B> cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public <B> T maxBy(Function1<T, B> f, Ordering<B> cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> T minBy(Function1<T, B> f, Ordering<B> cmp) {
            return TraversableOnce.minBy$(this, f, cmp);
        }

        @Override
        public <B> void copyToBuffer(Buffer<B> dest) {
            TraversableOnce.copyToBuffer$(this, dest);
        }

        @Override
        public <B> void copyToArray(Object xs, int start) {
            TraversableOnce.copyToArray$(this, xs, start);
        }

        @Override
        public <B> void copyToArray(Object xs) {
            TraversableOnce.copyToArray$(this, xs);
        }

        @Override
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public List<T> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public IndexedSeq<T> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<T> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<T, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return TraversableOnce.mkString$(this, start, sep, end);
        }

        @Override
        public String mkString(String sep) {
            return TraversableOnce.mkString$(this, sep);
        }

        @Override
        public String mkString() {
            return TraversableOnce.mkString$(this);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return TraversableOnce.addString$(this, b, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String sep) {
            return TraversableOnce.addString$(this, b, sep);
        }

        @Override
        public StringBuilder addString(StringBuilder b) {
            return TraversableOnce.addString$(this, b);
        }

        @Override
        public int sizeHintIfCheap() {
            return GenTraversableOnce.sizeHintIfCheap$(this);
        }

        @Override
        public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
            return PartialFunction.orElse$(this, that);
        }

        @Override
        public <C> PartialFunction<Object, C> andThen(Function1<T, C> k) {
            return PartialFunction.andThen$(this, k);
        }

        @Override
        public Function1<Object, Option<T>> lift() {
            return PartialFunction.lift$(this);
        }

        @Override
        public Object applyOrElse(Object x, Function1 function1) {
            return PartialFunction.applyOrElse$(this, x, function1);
        }

        @Override
        public <U> Function1<Object, Object> runWith(Function1<T, U> action) {
            return PartialFunction.runWith$(this, action);
        }

        @Override
        public boolean apply$mcZD$sp(double v1) {
            return Function1.apply$mcZD$sp$(this, v1);
        }

        @Override
        public double apply$mcDD$sp(double v1) {
            return Function1.apply$mcDD$sp$(this, v1);
        }

        @Override
        public float apply$mcFD$sp(double v1) {
            return Function1.apply$mcFD$sp$(this, v1);
        }

        @Override
        public int apply$mcID$sp(double v1) {
            return Function1.apply$mcID$sp$(this, v1);
        }

        @Override
        public long apply$mcJD$sp(double v1) {
            return Function1.apply$mcJD$sp$(this, v1);
        }

        @Override
        public void apply$mcVD$sp(double v1) {
            Function1.apply$mcVD$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZF$sp(float v1) {
            return Function1.apply$mcZF$sp$(this, v1);
        }

        @Override
        public double apply$mcDF$sp(float v1) {
            return Function1.apply$mcDF$sp$(this, v1);
        }

        @Override
        public float apply$mcFF$sp(float v1) {
            return Function1.apply$mcFF$sp$(this, v1);
        }

        @Override
        public int apply$mcIF$sp(float v1) {
            return Function1.apply$mcIF$sp$(this, v1);
        }

        @Override
        public long apply$mcJF$sp(float v1) {
            return Function1.apply$mcJF$sp$(this, v1);
        }

        @Override
        public void apply$mcVF$sp(float v1) {
            Function1.apply$mcVF$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZI$sp(int v1) {
            return Function1.apply$mcZI$sp$(this, v1);
        }

        @Override
        public double apply$mcDI$sp(int v1) {
            return Function1.apply$mcDI$sp$(this, v1);
        }

        @Override
        public float apply$mcFI$sp(int v1) {
            return Function1.apply$mcFI$sp$(this, v1);
        }

        @Override
        public int apply$mcII$sp(int v1) {
            return Function1.apply$mcII$sp$(this, v1);
        }

        @Override
        public long apply$mcJI$sp(int v1) {
            return Function1.apply$mcJI$sp$(this, v1);
        }

        @Override
        public void apply$mcVI$sp(int v1) {
            Function1.apply$mcVI$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZJ$sp(long v1) {
            return Function1.apply$mcZJ$sp$(this, v1);
        }

        @Override
        public double apply$mcDJ$sp(long v1) {
            return Function1.apply$mcDJ$sp$(this, v1);
        }

        @Override
        public float apply$mcFJ$sp(long v1) {
            return Function1.apply$mcFJ$sp$(this, v1);
        }

        @Override
        public int apply$mcIJ$sp(long v1) {
            return Function1.apply$mcIJ$sp$(this, v1);
        }

        @Override
        public long apply$mcJJ$sp(long v1) {
            return Function1.apply$mcJJ$sp$(this, v1);
        }

        @Override
        public void apply$mcVJ$sp(long v1) {
            Function1.apply$mcVJ$sp$(this, v1);
        }

        @Override
        public <A> Function1<A, T> compose(Function1<A, Object> g) {
            return Function1.compose$(this, g);
        }

        public Seq<T> rows() {
            return this.rows;
        }

        @Override
        public Iterator<T> iterator() {
            return this.rows().iterator();
        }

        @Override
        public T apply(int index) {
            return this.rows().apply(index);
        }

        @Override
        public int length() {
            return this.rows().length();
        }

        public int maxColWidth(Column<T> col) {
            String string = col.name();
            return BoxesRunTime.unboxToInt(((TraversableOnce)((TraversableLike)((SeqLike)this.rows().map(col.f(), Seq$.MODULE$.canBuildFrom())).$plus$colon(string, Seq$.MODULE$.canBuildFrom())).map((Function1<Object, Object> & java.io.Serializable & Serializable)(A x$4) -> BoxesRunTime.boxToInteger(Table.$anonfun$maxColWidth$1(x$4)), Seq$.MODULE$.canBuildFrom())).max(Ordering$Int$.MODULE$));
        }

        public List<String> specs() {
            return this.scala$reflect$internal$util$TableDef$Table$$$outer().scala$reflect$internal$util$TableDef$$cols().map((Function1<Column, String> & java.io.Serializable & Serializable)(A x$5) -> x$5.formatSpec(this.rows()), List$.MODULE$.canBuildFrom());
        }

        public List<Object> colWidths() {
            return this.colWidths;
        }

        public String rowFormat() {
            return this.rowFormat;
        }

        public String headFormat() {
            return this.headFormat;
        }

        public Seq<List<Object>> argLists() {
            return this.argLists;
        }

        public List<String> headers() {
            return this.headers;
        }

        public String mkFormatString(Function1<Object, String> sepf) {
            return ((TraversableOnce)this.specs().zipWithIndex(List$.MODULE$.canBuildFrom()).map((Function1<Tuple2, String> & java.io.Serializable & Serializable)(A x0$1) -> {
                if (x0$1 == null) {
                    throw new MatchError((Object)null);
                }
                String c = (String)x0$1._1();
                int i = x0$1._2$mcI$sp();
                String string = new java.lang.StringBuilder(0).append(c).append(sepf.apply(BoxesRunTime.boxToInteger(i))).toString();
                return string;
            }, List$.MODULE$.canBuildFrom())).mkString();
        }

        public Seq<String> toFormattedSeq() {
            return this.argLists().map((Function1<List, String> & java.io.Serializable & Serializable)(A xs) -> {
                String string = this.rowFormat();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new StringOps(string).format((Seq<Object>)xs);
            }, Seq$.MODULE$.canBuildFrom());
        }

        public List<String> allToSeq() {
            return this.headers().$plus$plus(this.toFormattedSeq(), List$.MODULE$.canBuildFrom());
        }

        @Override
        public String toString() {
            return this.allToSeq().mkString("\n");
        }

        public /* synthetic */ TableDef scala$reflect$internal$util$TableDef$Table$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ int $anonfun$maxColWidth$1(Object x$4) {
            return x$4.toString().length();
        }

        public static final /* synthetic */ String $anonfun$rowFormat$1(Table $this, int i) {
            return $this.scala$reflect$internal$util$TableDef$Table$$$outer().sepAfter(i);
        }

        public static final /* synthetic */ String $anonfun$headFormat$1(Table $this, int i) {
            String string = " ";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).$times(BoxesRunTime.unboxToInt($this.scala$reflect$internal$util$TableDef$Table$$$outer().sepWidths().apply(i)));
        }

        public static final /* synthetic */ String $anonfun$headers$1(int w1, int w2) {
            String string = "-";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            String string2 = " ";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new java.lang.StringBuilder(0).append(new StringOps(string).$times(w1)).append(new StringOps(string2).$times(w2)).toString();
        }

        public Table(TableDef $outer, Seq<T> rows) {
            this.rows = rows;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            PartialFunction.$init$(this);
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            GenericTraversableTemplate.$init$(this);
            GenTraversable.$init$(this);
            Traversable.$init$(this);
            GenIterable.$init$(this);
            IterableLike.$init$(this);
            Iterable.$init$(this);
            GenSeqLike.$init$(this);
            GenSeq.$init$(this);
            SeqLike.$init$(this);
            Seq.$init$(this);
            this.colWidths = $outer.scala$reflect$internal$util$TableDef$$cols().map((Function1<Column, Object> & java.io.Serializable & Serializable)(A col) -> BoxesRunTime.boxToInteger(this.maxColWidth(col)), List$.MODULE$.canBuildFrom());
            this.rowFormat = this.mkFormatString((Function1<Object, String> & java.io.Serializable & Serializable)i -> Table.$anonfun$rowFormat$1(this, BoxesRunTime.unboxToInt(i)));
            this.headFormat = this.mkFormatString((Function1<Object, String> & java.io.Serializable & Serializable)i -> Table.$anonfun$headFormat$1(this, BoxesRunTime.unboxToInt(i)));
            this.argLists = rows.map((Function1<Object, List> & java.io.Serializable & Serializable)(A el) -> this.scala$reflect$internal$util$TableDef$Table$$$outer().colApply(el), Seq$.MODULE$.canBuildFrom());
            String string = this.headFormat();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            this.headers = new $colon$colon<Nothing$>((Nothing$)((Object)new StringOps(string).format($outer.colNames())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)((TraversableOnce)Tuple2Zipped$.MODULE$.map$extension(Tuple2Zipped$Ops$.MODULE$.zipped$extension(Predef$.MODULE$.tuple2ToZippedOps(new Tuple2<List<Object>, IndexedSeq<Object>>(this.colWidths(), $outer.sepWidths())), Predef$.MODULE$.$conforms(), Predef$.MODULE$.$conforms()), (Function2<Object, Object, String> & java.io.Serializable & Serializable)(w1, w2) -> Table.$anonfun$headers$1(BoxesRunTime.unboxToInt(w1), BoxesRunTime.unboxToInt(w2)), List$.MODULE$.canBuildFrom())).mkString()), Nil$.MODULE$));
        }
    }
}

