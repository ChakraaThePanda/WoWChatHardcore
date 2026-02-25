/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.AbstractTraversable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.generic.IterableForwarder;
import scala.collection.generic.SeqForwarder;
import scala.collection.generic.TraversableForwarder;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.ListSerializeEnd$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.mutable.AbstractBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.BufferLike;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ListBuffer$;
import scala.collection.mutable.ReusableBuilder;
import scala.collection.mutable.StringBuilder;
import scala.math.Integral;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\tMd\u0001\u0002\u001a4\u0005iBQ!\u001b\u0001\u0005\u0002)DQa\u001b\u0001\u0005B1Dq\u0001\u001d\u0001A\u0002\u0013%\u0011\u000fC\u0004s\u0001\u0001\u0007I\u0011B:\t\re\u0004\u0001\u0015)\u0003^\u0011%Q\b\u00011AA\u0002\u0013%1\u0010\u0003\u0006\u0000\u0001\u0001\u0007\t\u0019!C\u0005\u0003\u0003A!\"!\u0002\u0001\u0001\u0004\u0005\t\u0015)\u0003}\u0011!\t9\u0001\u0001Q!\n\u0005%\u0001\u0002CA\b\u0001\u0001\u0006K!!\u0005\t\r\u0005]\u0001\u0001\"\u0005r\u0011\u001d\tI\u0002\u0001C\u0005\u00037Aq!!\r\u0001\t\u0013\t\u0019\u0004C\u0004\u0002@\u0001!\t%!\u0011\t\u000f\u0005\r\u0003\u0001\"\u0011\u0002B!9\u0011Q\t\u0001\u0005B\u0005\u001d\u0003bBA%\u0001\u0011\u0005\u0013q\t\u0005\b\u0003\u0017\u0002A\u0011IA'\u0011\u001d\t\u0019\u0006\u0001C\u0001\u0003+Bq!!\u0018\u0001\t\u0003\ty\u0006C\u0004\u0002f\u0001!\t%a\u001a\t\u000f\u0005U\u0004\u0001\"\u0011\u0002x!9\u00111\u0010\u0001\u0005\u0002\u0005u\u0004bBA@\u0001\u0011\u0005\u0011\u0011\u0011\u0005\b\u0003\u000b\u0003A\u0011AAD\u0011\u001d\t)\n\u0001C\u0005\u0003/Cq!!(\u0001\t\u0003\ny\nC\u0004\u0002(\u0002!\t!!+\t\r\u0005-\u0006\u0001\"\u0011r\u0011\u001d\ti\u000b\u0001C!\u0003_Cq!a.\u0001\t\u0003\nI\fC\u0004\u0002B\u0002!\t%a1\t\u000f\u0005-\u0007\u0001\"\u0001\u0002N\"9\u0011Q\u0014\u0001\u0005\u0002\u0005E\u0007bBAk\u0001\u0011\u0005\u0013q\u001b\u0005\b\u0003;\u0004A\u0011IAp\u0011\u001d\t\t\u000f\u0001C!\u0003GDq!a;\u0001\t\u0003\ni\u000fC\u0004\u0002v\u0002!I!! \t\u000f\u0005]\b\u0001\"\u0003\u0002~!9\u0011\u0011 \u0001\u0005B\u0005m\bB\u0002B\u0001\u0001\u0011\u0005#\u000eC\u0004\u0003\u0004\u0001!\tE!\u0002\b\u000f\t%2\u0007#\u0001\u0003,\u00191!g\rE\u0001\u0005[Aa![\u0017\u0005\u0002\tU\u0002b\u0002B\u001c[\u0011\r!\u0011\b\u0005\b\u0005#jC\u0011\u0001B*\u0011%\u0011\u0019'LA\u0001\n\u0013\u0011)G\u0001\u0006MSN$()\u001e4gKJT!\u0001N\u001b\u0002\u000f5,H/\u00192mK*\u0011agN\u0001\u000bG>dG.Z2uS>t'\"\u0001\u001d\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u00111HQ\n\t\u0001qbuJ\u0016.dMB\u0019QH\u0010!\u000e\u0003MJ!aP\u001a\u0003\u001d\u0005\u00137\u000f\u001e:bGR\u0014UO\u001a4feB\u0011\u0011I\u0011\u0007\u0001\t\u0015\u0019\u0005A1\u0001E\u0005\u0005\t\u0015CA#J!\t1u)D\u00018\u0013\tAuGA\u0004O_RD\u0017N\\4\u0011\u0005\u0019S\u0015BA&8\u0005\r\te.\u001f\t\u0004{5\u0003\u0015B\u0001(4\u0005\u0019\u0011UO\u001a4feB!\u0001k\u0015!V\u001b\u0005\t&B\u0001*6\u0003\u001d9WM\\3sS\u000eL!\u0001V)\u00035\u001d+g.\u001a:jGR\u0013\u0018M^3sg\u0006\u0014G.\u001a+f[Bd\u0017\r^3\u0011\u0005u\u0002\u0001\u0003B\u001fX\u0001fK!\u0001W\u001a\u0003\u0015\t+hMZ3s\u0019&\\W\rE\u0002>\u0001\u0001\u0003B!P.A;&\u0011Al\r\u0002\u0010%\u0016,8/\u00192mK\n+\u0018\u000e\u001c3feB\u0019a,\u0019!\u000e\u0003}S!\u0001Y\u001b\u0002\u0013%lW.\u001e;bE2,\u0017B\u00012`\u0005\u0011a\u0015n\u001d;\u0011\u0007A#\u0007)\u0003\u0002f#\na1+Z9G_J<\u0018M\u001d3feB\u0011aiZ\u0005\u0003Q^\u0012AbU3sS\u0006d\u0017N_1cY\u0016\fa\u0001P5oSRtD#A-\u0002\u0013\r|W\u000e]1oS>tW#A7\u0011\u0007AsW+\u0003\u0002p#\n\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0006gR\f'\u000f^\u000b\u0002;\u0006I1\u000f^1si~#S-\u001d\u000b\u0003i^\u0004\"AR;\n\u0005Y<$\u0001B+oSRDq\u0001\u001f\u0003\u0002\u0002\u0003\u0007Q,A\u0002yIE\naa\u001d;beR\u0004\u0013!\u00027bgR\u0004T#\u0001?\u0011\u0007yk\b)\u0003\u0002\u007f?\naAeY8m_:$3m\u001c7p]\u0006IA.Y:ua}#S-\u001d\u000b\u0004i\u0006\r\u0001b\u0002=\b\u0003\u0003\u0005\r\u0001`\u0001\u0007Y\u0006\u001cH\u000f\r\u0011\u0002\u0011\u0015D\bo\u001c:uK\u0012\u00042ARA\u0006\u0013\r\tia\u000e\u0002\b\u0005>|G.Z1o\u0003\raWM\u001c\t\u0004\r\u0006M\u0011bAA\u000bo\t\u0019\u0011J\u001c;\u0002\u0015UtG-\u001a:ms&tw-A\u0006xe&$Xm\u00142kK\u000e$Hc\u0001;\u0002\u001e!9\u0011q\u0004\u0007A\u0002\u0005\u0005\u0012aA8viB!\u00111EA\u0017\u001b\t\t)C\u0003\u0003\u0002(\u0005%\u0012AA5p\u0015\t\tY#\u0001\u0003kCZ\f\u0017\u0002BA\u0018\u0003K\u0011!c\u00142kK\u000e$x*\u001e;qkR\u001cFO]3b[\u0006Q!/Z1e\u001f\nTWm\u0019;\u0015\u0007Q\f)\u0004C\u0004\u000285\u0001\r!!\u000f\u0002\u0005%t\u0007\u0003BA\u0012\u0003wIA!!\u0010\u0002&\t\trJ\u00196fGRLe\u000e];u'R\u0014X-Y7\u0002\r1,gn\u001a;i+\t\t\t\"\u0001\u0003tSj,\u0017aB5t\u000b6\u0004H/_\u000b\u0003\u0003\u0013\t\u0001B\\8o\u000b6\u0004H/_\u0001\u0006CB\u0004H.\u001f\u000b\u0004\u0001\u0006=\u0003bBA)%\u0001\u0007\u0011\u0011C\u0001\u0002]\u00061Q\u000f\u001d3bi\u0016$R\u0001^A,\u00033Bq!!\u0015\u0014\u0001\u0004\t\t\u0002\u0003\u0004\u0002\\M\u0001\r\u0001Q\u0001\u0002q\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0003\u0002b\u0005\rT\"\u0001\u0001\t\r\u0005mC\u00031\u0001A\u00035!\u0003\u000f\\;tIAdWo\u001d\u0013fcR!\u0011\u0011MA5\u0011\u001d\tY'\u0006a\u0001\u0003[\n!\u0001_:\u0011\u000b\u0005=\u0014\u0011\u000f!\u000e\u0003UJ1!a\u001d6\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0017a\u0005\u0013qYV\u001cH\u0005\u001d7vg\u0012*\u0017\u000fJ2pY>tG\u0003BA1\u0003sBq!a\u001b\u0017\u0001\u0004\ti'A\u0003dY\u0016\f'\u000fF\u0001u\u00039!\u0003\u000f\\;tI\u0015\fHeY8m_:$B!!\u0019\u0002\u0004\"1\u00111\f\rA\u0002\u0001\u000b\u0011\"\u001b8tKJ$\u0018\t\u001c7\u0015\u000bQ\fI)a#\t\u000f\u0005E\u0013\u00041\u0001\u0002\u0012!9\u0011QR\rA\u0002\u0005=\u0015aA:fcB)\u0011qNAI\u0001&\u0019\u00111S\u001b\u0003\u0017Q\u0013\u0018M^3sg\u0006\u0014G.Z\u0001\u000fe\u0016$WoY3MK:<G\u000f\u001b\"z)\r!\u0018\u0011\u0014\u0005\b\u00037S\u0002\u0019AA\t\u0003\rqW/\\\u0001\u0007e\u0016lwN^3\u0015\u000bQ\f\t+a)\t\u000f\u0005E3\u00041\u0001\u0002\u0012!9\u0011QU\u000eA\u0002\u0005E\u0011!B2pk:$\u0018A\u0002:fgVdG\u000fF\u0001^\u0003\u0019!x\u000eT5ti\u0006)Ao\\*fcV\u0011\u0011\u0011\u0017\t\u0006\u0003_\n\u0019\fQ\u0005\u0004\u0003k+$aA*fc\u0006QAo\\%uKJ\f'\r\\3\u0016\u0005\u0005m\u0006#BA8\u0003{\u0003\u0015bAA`k\tA\u0011\n^3sC\ndW-\u0001\u0005u_N#(/Z1n+\t\t)\r\u0005\u0003_\u0003\u000f\u0004\u0015bAAe?\n11\u000b\u001e:fC6\fQ\u0002\u001d:fa\u0016tG\rV8MSN$HcA/\u0002P\"1\u00111N\u0011A\u0002u#2\u0001QAj\u0011\u001d\t\tF\ta\u0001\u0003#\t\u0011\u0002J7j]V\u001cH%Z9\u0015\t\u0005\u0005\u0014\u0011\u001c\u0005\u0007\u00037\u001c\u0003\u0019\u0001!\u0002\t\u0015dW-\\\u0001\u0005Y\u0006\u001cH/F\u0001A\u0003)a\u0017m\u001d;PaRLwN\\\u000b\u0003\u0003K\u0004BARAt\u0001&\u0019\u0011\u0011^\u001c\u0003\r=\u0003H/[8o\u0003!IG/\u001a:bi>\u0014XCAAx!\u0015\ty'!=A\u0013\r\t\u00190\u000e\u0002\t\u0013R,'/\u0019;pe\u0006yQM\\:ve\u0016,f.\u00197jCN,G-\u0001\u0003d_BL\u0018AB3rk\u0006d7\u000f\u0006\u0003\u0002\n\u0005u\bBBA\u0000S\u0001\u0007\u0011*\u0001\u0003uQ\u0006$\u0018!B2m_:,\u0017\u0001D:ue&tw\r\u0015:fM&DXC\u0001B\u0004!\u0011\u0011IAa\u0006\u000f\t\t-!1\u0003\t\u0004\u0005\u001b9TB\u0001B\b\u0015\r\u0011\t\"O\u0001\u0007yI|w\u000e\u001e \n\u0007\tUq'\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u00053\u0011YB\u0001\u0004TiJLgn\u001a\u0006\u0004\u0005+9\u0004f\u0002\u0001\u0003 \t\u0015\"q\u0005\t\u0004\r\n\u0005\u0012b\u0001B\u0012o\t\u00012+\u001a:jC24VM]:j_:,\u0016\nR\u0001\u0006m\u0006dW/\u001a\u0010\t_I$p\u0012uem\r\bQA*[:u\u0005V4g-\u001a:\u0011\u0005uj3\u0003B\u0017\u00030\u0019\u0004B\u0001\u0015B\u0019+&\u0019!1G)\u0003\u0015M+\u0017OR1di>\u0014\u0018\u0010\u0006\u0002\u0003,\u0005a1-\u00198Ck&dGM\u0012:p[V!!1\bB'+\t\u0011i\u0004E\u0005Q\u0005\u007f\u0011\u0019Ea\u0013\u0003P%\u0019!\u0011I)\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\t\t\u0015#qI\u0007\u0002[%\u0019!\u0011\n8\u0003\t\r{G\u000e\u001c\t\u0004\u0003\n5C!B\"0\u0005\u0004!\u0005\u0003B\u001f\u0001\u0005\u0017\n!B\\3x\u0005VLG\u000eZ3s+\u0011\u0011)Fa\u0018\u0016\u0005\t]\u0003cB\u001f\u0003Z\tu#\u0011M\u0005\u0004\u00057\u001a$a\u0002\"vS2$WM\u001d\t\u0004\u0003\n}C!B\"1\u0005\u0004!\u0005\u0003B\u001f\u0001\u0005;\n1B]3bIJ+7o\u001c7wKR\u0011!q\r\t\u0005\u0005S\u0012y'\u0004\u0002\u0003l)!!QNA\u0015\u0003\u0011a\u0017M\\4\n\t\tE$1\u000e\u0002\u0007\u001f\nTWm\u0019;")
public final class ListBuffer<A>
extends AbstractBuffer<A>
implements ReusableBuilder<A, List<A>>,
SeqForwarder<A>,
Serializable {
    public static final long serialVersionUID = 3419063961353022662L;
    private List<A> scala$collection$mutable$ListBuffer$$start;
    private $colon$colon<A> last0;
    private boolean exported;
    private int len;

    public static <A> CanBuildFrom<ListBuffer<?>, A, ListBuffer<A>> canBuildFrom() {
        return ListBuffer$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return ListBuffer$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)listBuffer$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return ListBuffer$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ListBuffer$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ tabulate_this = listBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ tabulate_this = listBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ tabulate_this = listBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ tabulate_this = listBuffer$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ListBuffer$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ fill_this = listBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ fill_this = listBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ fill_this = listBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        ListBuffer$ fill_this = listBuffer$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ListBuffer$ listBuffer$ = ListBuffer$.MODULE$;
        if (listBuffer$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)listBuffer$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ListBuffer$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ListBuffer$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ListBuffer$.MODULE$.empty();
    }

    @Override
    public int lengthCompare(int len) {
        return SeqForwarder.lengthCompare$(this, len);
    }

    @Override
    public boolean isDefinedAt(int x) {
        return SeqForwarder.isDefinedAt$(this, x);
    }

    @Override
    public int segmentLength(Function1<A, Object> p, int from) {
        return SeqForwarder.segmentLength$(this, p, from);
    }

    @Override
    public int prefixLength(Function1<A, Object> p) {
        return SeqForwarder.prefixLength$(this, p);
    }

    @Override
    public int indexWhere(Function1<A, Object> p) {
        return SeqForwarder.indexWhere$(this, p);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return SeqForwarder.indexWhere$(this, p, from);
    }

    @Override
    public <B> int indexOf(B elem) {
        return SeqForwarder.indexOf$(this, elem);
    }

    @Override
    public <B> int indexOf(B elem, int from) {
        return SeqForwarder.indexOf$(this, elem, from);
    }

    @Override
    public <B> int lastIndexOf(B elem) {
        return SeqForwarder.lastIndexOf$(this, elem);
    }

    @Override
    public <B> int lastIndexOf(B elem, int end) {
        return SeqForwarder.lastIndexOf$(this, elem, end);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p) {
        return SeqForwarder.lastIndexWhere$(this, p);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p, int end) {
        return SeqForwarder.lastIndexWhere$(this, p, end);
    }

    @Override
    public Iterator<A> reverseIterator() {
        return SeqForwarder.reverseIterator$(this);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that, int offset) {
        return SeqForwarder.startsWith$(this, that, offset);
    }

    @Override
    public <B> boolean startsWith(GenSeq<B> that) {
        return SeqForwarder.startsWith$(this, that);
    }

    @Override
    public <B> boolean endsWith(GenSeq<B> that) {
        return SeqForwarder.endsWith$(this, that);
    }

    @Override
    public <B> int indexOfSlice(GenSeq<B> that) {
        return SeqForwarder.indexOfSlice$(this, that);
    }

    @Override
    public <B> int indexOfSlice(GenSeq<B> that, int from) {
        return SeqForwarder.indexOfSlice$(this, that, from);
    }

    @Override
    public <B> int lastIndexOfSlice(GenSeq<B> that) {
        return SeqForwarder.lastIndexOfSlice$(this, that);
    }

    @Override
    public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
        return SeqForwarder.lastIndexOfSlice$(this, that, end);
    }

    @Override
    public <B> boolean containsSlice(GenSeq<B> that) {
        return SeqForwarder.containsSlice$(this, that);
    }

    @Override
    public <A1> boolean contains(A1 elem) {
        return SeqForwarder.contains$(this, elem);
    }

    @Override
    public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return SeqForwarder.corresponds$(this, that, p);
    }

    @Override
    public Range indices() {
        return SeqForwarder.indices$(this);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IterableForwarder.sameElements$(this, that);
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        TraversableForwarder.foreach$(this, f);
    }

    @Override
    public boolean hasDefiniteSize() {
        return TraversableForwarder.hasDefiniteSize$(this);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return TraversableForwarder.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return TraversableForwarder.exists$(this, p);
    }

    @Override
    public int count(Function1<A, Object> p) {
        return TraversableForwarder.count$(this, p);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return TraversableForwarder.find$(this, p);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)TraversableForwarder.foldLeft$(this, z, op);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, A, B> op) {
        return (B)TraversableForwarder.$div$colon$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)TraversableForwarder.foldRight$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
        return (B)TraversableForwarder.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)TraversableForwarder.reduceLeft$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
        return TraversableForwarder.reduceLeftOption$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)TraversableForwarder.reduceRight$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
        return TraversableForwarder.reduceRightOption$(this, op);
    }

    @Override
    public <B> B sum(Numeric<B> num) {
        return (B)TraversableForwarder.sum$(this, num);
    }

    @Override
    public <B> B product(Numeric<B> num) {
        return (B)TraversableForwarder.product$(this, num);
    }

    @Override
    public <B> A min(Ordering<B> cmp) {
        return (A)TraversableForwarder.min$(this, cmp);
    }

    @Override
    public <B> A max(Ordering<B> cmp) {
        return (A)TraversableForwarder.max$(this, cmp);
    }

    @Override
    public A head() {
        return (A)TraversableForwarder.head$(this);
    }

    @Override
    public Option<A> headOption() {
        return TraversableForwarder.headOption$(this);
    }

    @Override
    public <B> void copyToBuffer(Buffer<B> dest) {
        TraversableForwarder.copyToBuffer$(this, dest);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        TraversableForwarder.copyToArray$(this, xs, start, len);
    }

    @Override
    public <B> void copyToArray(Object xs, int start) {
        TraversableForwarder.copyToArray$(this, xs, start);
    }

    @Override
    public <B> void copyToArray(Object xs) {
        TraversableForwarder.copyToArray$(this, xs);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableForwarder.toArray$(this, evidence$1);
    }

    @Override
    public IndexedSeq<A> toIndexedSeq() {
        return TraversableForwarder.toIndexedSeq$(this);
    }

    @Override
    public <B> Buffer<B> toBuffer() {
        return TraversableForwarder.toBuffer$(this);
    }

    @Override
    public <B> Set<B> toSet() {
        return TraversableForwarder.toSet$(this);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
        return TraversableForwarder.toMap$(this, ev);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return TraversableForwarder.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return TraversableForwarder.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return TraversableForwarder.mkString$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return TraversableForwarder.addString$(this, b, start, sep, end);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String sep) {
        return TraversableForwarder.addString$(this, b, sep);
    }

    @Override
    public StringBuilder addString(StringBuilder b) {
        return TraversableForwarder.addString$(this, b);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<A, NewTo> mapResult(Function1<List<A>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public GenericCompanion<ListBuffer> companion() {
        return ListBuffer$.MODULE$;
    }

    public List<A> scala$collection$mutable$ListBuffer$$start() {
        return this.scala$collection$mutable$ListBuffer$$start;
    }

    private void scala$collection$mutable$ListBuffer$$start_$eq(List<A> x$1) {
        this.scala$collection$mutable$ListBuffer$$start = x$1;
    }

    private $colon$colon<A> last0() {
        return this.last0;
    }

    private void last0_$eq($colon$colon<A> x$1) {
        this.last0 = x$1;
    }

    @Override
    public List<A> underlying() {
        return this.scala$collection$mutable$ListBuffer$$start();
    }

    private void writeObject(ObjectOutputStream out) {
        List xs = this.scala$collection$mutable$ListBuffer$$start();
        while (!xs.isEmpty()) {
            out.writeObject(xs.head());
            xs = (List)xs.tail();
        }
        out.writeObject(ListSerializeEnd$.MODULE$);
        out.writeBoolean(this.exported);
        out.writeInt(this.len);
    }

    private void readObject(ObjectInputStream in) {
        Object elem;
        Object object = elem = in.readObject();
        ListSerializeEnd$ listSerializeEnd$ = ListSerializeEnd$.MODULE$;
        if (!(object != null ? !object.equals(listSerializeEnd$) : listSerializeEnd$ != null)) {
            this.scala$collection$mutable$ListBuffer$$start_$eq(Nil$.MODULE$);
            this.last0_$eq(null);
        } else {
            $colon$colon<Nothing$> current = new $colon$colon<Nothing$>((Nothing$)elem, Nil$.MODULE$);
            this.scala$collection$mutable$ListBuffer$$start_$eq(current);
            elem = in.readObject();
            while (true) {
                Object object2 = elem;
                ListSerializeEnd$ listSerializeEnd$2 = ListSerializeEnd$.MODULE$;
                if (!(object2 == null ? listSerializeEnd$2 != null : !object2.equals(listSerializeEnd$2))) break;
                $colon$colon<Nothing$> list = new $colon$colon<Nothing$>((Nothing$)elem, Nil$.MODULE$);
                current.tl_$eq(list);
                current = list;
                elem = in.readObject();
            }
            this.last0_$eq(current);
            this.scala$collection$mutable$ListBuffer$$start();
        }
        this.exported = in.readBoolean();
        this.len = in.readInt();
    }

    @Override
    public int length() {
        return this.len;
    }

    @Override
    public int size() {
        return this.length();
    }

    @Override
    public boolean isEmpty() {
        return this.len == 0;
    }

    @Override
    public boolean nonEmpty() {
        return this.len > 0;
    }

    @Override
    public A apply(int n) {
        if (n < 0 || n >= this.len) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
        }
        return (A)SeqForwarder.apply$(this, n);
    }

    @Override
    public void update(int n, A x) {
        if (n < 0 || n >= this.len) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
        }
        this.ensureUnaliased();
        if (n == 0) {
            $colon$colon<A> newElem = new $colon$colon<A>(x, (List)this.scala$collection$mutable$ListBuffer$$start().tail());
            if (this.last0() == this.scala$collection$mutable$ListBuffer$$start()) {
                this.last0_$eq(newElem);
            }
            this.scala$collection$mutable$ListBuffer$$start_$eq(newElem);
            return;
        }
        List cursor = this.scala$collection$mutable$ListBuffer$$start();
        for (int i = 1; i < n; ++i) {
            cursor = (List)cursor.tail();
        }
        $colon$colon<A> newElem = new $colon$colon<A>(x, (List)((TraversableLike)cursor.tail()).tail());
        if (this.last0() == cursor.tail()) {
            this.last0_$eq(newElem);
        }
        (($colon$colon)cursor).tl_$eq(newElem);
    }

    @Override
    public ListBuffer<A> $plus$eq(A x) {
        this.ensureUnaliased();
        $colon$colon<Nothing$> last1 = new $colon$colon<Nothing$>((Nothing$)x, Nil$.MODULE$);
        if (this.len == 0) {
            this.scala$collection$mutable$ListBuffer$$start_$eq(last1);
        } else {
            this.last0().tl_$eq(last1);
        }
        this.last0_$eq(last1);
        ++this.len;
        return this;
    }

    @Override
    public ListBuffer<A> $plus$plus$eq(TraversableOnce<A> xs) {
        while (xs instanceof Object && xs == this) {
            xs = (TraversableOnce)this.take(this.size());
        }
        return (ListBuffer)Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public ListBuffer<A> $plus$plus$eq$colon(TraversableOnce<A> xs) {
        while (xs == this) {
            xs = (TraversableOnce)this.take(this.size());
        }
        return (ListBuffer)BufferLike.$plus$plus$eq$colon$(this, xs);
    }

    @Override
    public void clear() {
        this.scala$collection$mutable$ListBuffer$$start_$eq(Nil$.MODULE$);
        this.last0_$eq(null);
        this.exported = false;
        this.len = 0;
    }

    @Override
    public ListBuffer<A> $plus$eq$colon(A x) {
        this.ensureUnaliased();
        $colon$colon<A> newElem = new $colon$colon<A>(x, this.scala$collection$mutable$ListBuffer$$start());
        if (this.isEmpty()) {
            this.last0_$eq(newElem);
        }
        this.scala$collection$mutable$ListBuffer$$start_$eq(newElem);
        ++this.len;
        return this;
    }

    @Override
    public void insertAll(int n, Traversable<A> seq) {
        if (n < 0 || n > this.len) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
        }
        this.ensureUnaliased();
        Object elems = seq.toList().reverse();
        this.len += ((List)elems).length();
        if (n == 0) {
            while (!((List)elems).isEmpty()) {
                $colon$colon newElem = new $colon$colon(((List)elems).head(), this.scala$collection$mutable$ListBuffer$$start());
                if (this.scala$collection$mutable$ListBuffer$$start().isEmpty()) {
                    this.last0_$eq(newElem);
                }
                this.scala$collection$mutable$ListBuffer$$start_$eq(newElem);
                elems = (List)((AbstractTraversable)elems).tail();
            }
        } else {
            List cursor = this.scala$collection$mutable$ListBuffer$$start();
            for (int i = 1; i < n; ++i) {
                cursor = (List)cursor.tail();
            }
            while (!((List)elems).isEmpty()) {
                $colon$colon newElem = new $colon$colon(((List)elems).head(), (List)cursor.tail());
                if (((SeqLike)cursor.tail()).isEmpty()) {
                    this.last0_$eq(newElem);
                }
                (($colon$colon)cursor).tl_$eq(newElem);
                elems = (List)((AbstractTraversable)elems).tail();
            }
        }
    }

    private void reduceLengthBy(int num) {
        this.len -= num;
        if (this.len <= 0) {
            this.last0_$eq(null);
        }
    }

    @Override
    public void remove(int n, int count) {
        if (count < 0) {
            throw new IllegalArgumentException(new java.lang.StringBuilder(38).append("removing negative number of elements: ").append(((Object)BoxesRunTime.boxToInteger(count)).toString()).toString());
        }
        if (count == 0) {
            return;
        }
        if (n < 0 || n > this.len - count) {
            throw new IndexOutOfBoundsException(new java.lang.StringBuilder(13).append("at ").append(((Object)BoxesRunTime.boxToInteger(n)).toString()).append(" deleting ").append(((Object)BoxesRunTime.boxToInteger(count)).toString()).toString());
        }
        this.ensureUnaliased();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int n1 = RichInt$.MODULE$.max$extension(n, 0);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int count1 = RichInt$.MODULE$.min$extension(count, this.len - n1);
        if (n1 == 0) {
            for (int c = count1; c > 0; --c) {
                this.scala$collection$mutable$ListBuffer$$start_$eq((List)this.scala$collection$mutable$ListBuffer$$start().tail());
            }
        } else {
            List cursor = this.scala$collection$mutable$ListBuffer$$start();
            for (int i = 1; i < n1; ++i) {
                cursor = (List)cursor.tail();
            }
            for (int c = count1; c > 0; --c) {
                if (this.last0() == cursor.tail()) {
                    this.last0_$eq(($colon$colon)cursor);
                }
                (($colon$colon)cursor).tl_$eq((List)((TraversableLike)cursor.tail()).tail());
            }
        }
        this.reduceLengthBy(count1);
    }

    @Override
    public List<A> result() {
        return this.toList();
    }

    @Override
    public List<A> toList() {
        this.exported = !this.isEmpty();
        return this.scala$collection$mutable$ListBuffer$$start();
    }

    @Override
    public Seq<A> toSeq() {
        return this.toList();
    }

    @Override
    public Iterable<A> toIterable() {
        return this.toList();
    }

    @Override
    public Stream<A> toStream() {
        return this.toList().toStream();
    }

    public List<A> prependToList(List<A> xs) {
        if (this.isEmpty()) {
            return xs;
        }
        this.ensureUnaliased();
        this.last0().tl_$eq(xs);
        return this.toList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public A remove(int n) {
        void var2_2;
        if (n < 0 || n >= this.len) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(n)).toString());
        }
        this.ensureUnaliased();
        A old = this.scala$collection$mutable$ListBuffer$$start().head();
        if (n == 0) {
            this.scala$collection$mutable$ListBuffer$$start_$eq((List)this.scala$collection$mutable$ListBuffer$$start().tail());
        } else {
            List cursor = this.scala$collection$mutable$ListBuffer$$start();
            for (int i = 1; i < n; ++i) {
                cursor = (List)cursor.tail();
            }
            old = ((IterableLike)cursor.tail()).head();
            if (this.last0() == cursor.tail()) {
                this.last0_$eq(($colon$colon)cursor);
            }
            (($colon$colon)cursor).tl_$eq((List)((TraversableLike)cursor.tail()).tail());
        }
        this.reduceLengthBy(1);
        return var2_2;
    }

    @Override
    public ListBuffer<A> $minus$eq(A elem) {
        this.ensureUnaliased();
        if (!this.isEmpty()) {
            if (BoxesRunTime.equals(this.scala$collection$mutable$ListBuffer$$start().head(), elem)) {
                this.scala$collection$mutable$ListBuffer$$start_$eq((List)this.scala$collection$mutable$ListBuffer$$start().tail());
                this.reduceLengthBy(1);
            } else {
                List cursor = this.scala$collection$mutable$ListBuffer$$start();
                while (!((SeqLike)cursor.tail()).isEmpty() && !BoxesRunTime.equals(((IterableLike)cursor.tail()).head(), elem)) {
                    cursor = (List)cursor.tail();
                }
                if (!((SeqLike)cursor.tail()).isEmpty()) {
                    $colon$colon z = ($colon$colon)cursor;
                    List list = z.tl();
                    $colon$colon<A> $colon$colon = this.last0();
                    if (!(list != null ? !((Object)list).equals($colon$colon) : $colon$colon != null)) {
                        this.last0_$eq(z);
                    }
                    z.tl_$eq((List)((TraversableLike)cursor.tail()).tail());
                    this.reduceLengthBy(1);
                }
            }
        }
        return this;
    }

    @Override
    public A last() {
        if (this.last0() == null) {
            throw new NoSuchElementException("last of empty ListBuffer");
        }
        return this.last0().head();
    }

    @Override
    public Option<A> lastOption() {
        if (this.last0() == null) {
            return None$.MODULE$;
        }
        return new Some<A>(this.last0().head());
    }

    @Override
    public Iterator<A> iterator() {
        return new AbstractIterator<A>(this){
            private List<A> cursor;

            private List<A> cursor() {
                return this.cursor;
            }

            private void cursor_$eq(List<A> x$1) {
                this.cursor = x$1;
            }

            public boolean hasNext() {
                return this.cursor() != Nil$.MODULE$;
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                void var1_1;
                if (!this.hasNext()) {
                    throw new NoSuchElementException("next on empty Iterator");
                }
                A ans = this.cursor().head();
                this.cursor_$eq((List)this.cursor().tail());
                return var1_1;
            }
            {
                this.cursor = $outer.isEmpty() ? Nil$.MODULE$ : $outer.scala$collection$mutable$ListBuffer$$start();
            }
        };
    }

    private void ensureUnaliased() {
        if (this.exported) {
            this.copy();
        }
    }

    private void copy() {
        if (this.isEmpty()) {
            return;
        }
        LinearSeqOptimized limit = this.last0().tail();
        this.clear();
        for (List cursor = this.scala$collection$mutable$ListBuffer$$start(); cursor != limit; cursor = (List)cursor.tail()) {
            this.$plus$eq((Object)cursor.head());
        }
    }

    @Override
    public boolean equals(Object that) {
        boolean bl;
        if (that instanceof ListBuffer) {
            ListBuffer listBuffer = (ListBuffer)that;
            bl = this.scala$collection$mutable$ListBuffer$$start().equals(listBuffer.scala$collection$mutable$ListBuffer$$start());
        } else {
            bl = GenSeqLike.equals$(this, that);
        }
        return bl;
    }

    @Override
    public ListBuffer<A> clone() {
        return new ListBuffer<A>().$plus$plus$eq((TraversableOnce)this);
    }

    @Override
    public String stringPrefix() {
        return "ListBuffer";
    }

    public ListBuffer() {
        Builder.$init$(this);
        TraversableForwarder.$init$(this);
        IterableForwarder.$init$(this);
        SeqForwarder.$init$(this);
        this.scala$collection$mutable$ListBuffer$$start = Nil$.MODULE$;
        this.exported = false;
        this.len = 0;
    }
}

