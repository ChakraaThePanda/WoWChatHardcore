/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream$;
import scala.collection.immutable.Stream$cons$;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayBuffer$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Buffer$;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Queue;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.LazyBoolean;
import scala.runtime.LazyInt;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0015%x\u0001CA\u0002\u0003\u000bA\t!a\u0004\u0007\u0011\u0005M\u0011Q\u0001E\u0001\u0003+Aq!a\b\u0002\t\u0003\t\t\u0003C\u0004\u0002$\u0005!\u0019!!\n\t\u0013\u0011u\u0014A1A\u0005\u0002\u0011}\u0004\u0002\u0003CB\u0003\u0001\u0006I\u0001\"!\t\u000f\u0011\u0015\u0015\u0001\"\u0001\u0005\b\"9A1S\u0001\u0005\u0002\u0011U\u0005bBBc\u0003\u0011\u0005A\u0011\u0016\u0005\b\tw\u000bA\u0011\u0001C_\u0011\u001d!\t.\u0001C\u0001\t'Dq\u0001\"5\u0002\t\u0003!Y\u000eC\u0004\u0005d\u0006!\t\u0001\":\t\u000f\u0005m\u0015\u0001\"\u0001\u0005z\"9\u00111T\u0001\u0005\u0002\u0011u\bbBC\u0002\u0003\u0011\u0005QQ\u0001\u0004\u0007\u000b'\ta!\"\u0006\t\u0015\u0015}\u0001C!a\u0001\n\u0013)\t\u0003\u0003\u0006\u0006(A\u0011\t\u0019!C\u0005\u000bSA!\"b\f\u0011\u0005\u0003\u0005\u000b\u0015BC\u0012\u0011\u001d\ty\u0002\u0005C\u0001\u000bcA\u0011\"\"\u000f\u0011\u0001\u0004%I!b\u000f\t\u0013\u0015M\u0003\u00031A\u0005\n\u0015\u001d\u0004\u0002CC-!\u0001\u0006K!\"\u0010\t\u0013\u0015-\u0004\u00031A\u0005\n\u0015m\u0002\"CC7!\u0001\u0007I\u0011BC8\u0011!)\u0019\b\u0005Q!\n\u0015u\u0002\"CC;!\u0001\u0007I\u0011BA8\u0011%)9\b\u0005a\u0001\n\u0013)I\b\u0003\u0005\u0006~A\u0001\u000b\u0015BA9\u0011!)y\b\u0005Q\u0005\n\r\u001d\u0007\u0002CCE!\u0001&I!a\u0018\t\u000f\u00055\u0004\u0003\"\u0001\u0002p!9\u0011q\u000f\t\u0005\u0002\u00155\u0005bBAa!\u0011\u0005Sq\u0012\u0004\t\u000b\u007f\t\u0001\u0015!\u0004\u0006B!QQQI\u0012\u0003\u0002\u0013\u0006I!b\u0012\t\u0015\u0015e2E!a\u0001\n\u0003)y\u0005\u0003\u0006\u0006T\r\u0012\t\u0019!C\u0001\u000b+B!\"\"\u0017$\u0005\u0003\u0005\u000b\u0015BC)\u0011\u001d\tyb\tC\u0001\u000b7Bq!\"\u0019$\t\u0003)\u0019G\u0002\u0005\u0006\"\u0006\u0011\u0011\u0011BCR\u0011))iK\u000bBC\u0002\u0013\u0005Qq\u0016\u0005\u000b\u000bgS#\u0011!Q\u0001\n\u0015E\u0006B\u0003C U\t\u0005\t\u0015!\u0003\u0002\n\"QQQ\u0017\u0016\u0003\u0002\u0003\u0006I!!#\t\u000f\u0005}!\u0006\"\u0001\u00068\"qQ\u0011\u0019\u0016\u0005\u0002\u0003\u0015\t\u00111A\u0005\n\rm\u0006bCCbU\t\u0005\t\u0019!C\u0005\u000b\u000bD1\"\"3+\u0005\u0003\u0005\t\u0015)\u0003\u0002\n\"IQ1\u001a\u0016A\u0002\u0013%11\u0018\u0005\n\u000b\u001bT\u0003\u0019!C\u0005\u000b\u001fD\u0001\"b5+A\u0003&\u0011\u0011\u0012\u0005\b\u000b+TC\u0011BA8\u0011\u001d)yN\u000bC\u0005\u0003?Bq!!\u001c+\t\u0003\ty\u0007C\u0004\u0002x)\"\t!\"9\t\u000f\u0005\u0005&\u0006\"\u0015\u0006d\u001aQ\u00111CA\u0003!\u0003\r\t!a\u0014\t\u000f\u0005u3\b\"\u0001\u0002`!9\u0011qM\u001e\u0005\u0002\u0005%\u0004bBA7w\u0019\u0005\u0011q\u000e\u0005\b\u0003oZd\u0011AA=\u0011\u001d\tYh\u000fC\u0001\u0003_Bq!! <\t\u0003\ty\u0007C\u0004\u0002\u0000m\"\t!a\u001c\t\u000f\u0005\u00055\b\"\u0001\u0002\u0004\"9\u0011qR\u001e\u0005\u0002\u0005E\u0005bBAKw\u0011\u0005\u0011q\u0013\u0005\b\u0003C[D\u0011CAR\u0011\u001d\tIk\u000fC\u0001\u0003WCq!!1<\t\u0003\t\u0019\rC\u0004\u0002`n\"\t!!9\t\u000f\u0005E8\b\"\u0001\u0002t\"9\u00111`\u001e\u0005\u0002\u0005u\bb\u0002B\nw\u0011\u0005!Q\u0003\u0005\b\u00053YD\u0011\u0001B\u000e\u0011\u001d\u0011yb\u000fC\u0001\u0005CAqAa\u0013<\t\u0003\u0011i\u0005C\u0004\u0003dm\"\tA!\u001a\t\u000f\t]4\b\"\u0001\u0003z!9!QP\u001e\u0005\u0002\t}\u0004b\u0002BEw\u0011\u0005!1\u0012\u0005\b\u0005\u001f[D\u0011\u0001BI\u0011\u001d\u0011)j\u000fC\u0001\u0005/CqAa*<\t\u0003\u0011I\u000bC\u0004\u0003>n\"\tAa0\t\u000f\t\u00157\b\"\u0001\u0003H\"9!1^\u001e\u0005\u0002\t5\bb\u0002B~w\u0011\u0005!Q \u0005\b\u0007\u0003YD\u0011AB\u0002\u0011\u001d\u00199a\u000fC\u0001\u0007\u0013Aqa!\u0004<\t\u0003\u0019y\u0001C\u0004\u0004\u001am\"\taa\u0007\t\u000f\re1\b\"\u0001\u0004 !91QE\u001e\u0005\u0002\r\u001d\u0002bBB\u0013w\u0011\u00051\u0011\u0007\u0005\b\u0007{YD\u0011AB \r\u0019\u00199e\u000f\u0001\u0004J!Q1qL2\u0003\u0002\u0003\u0006I!a\u001b\t\u0015\r\u00054M!A!\u0002\u0013\tI\t\u0003\u0006\u0004d\r\u0014\t\u0011)A\u0005\u0003\u0013Cq!a\bd\t\u0003\u0019)\u0007\u0003\u0005\u0004r\r\u0004\u000b\u0015BB:\u0011!\u0019yh\u0019Q!\n\u0005E\u0004\u0002CBAG\u0002\u0006K!!\u001d\t\u0011\r\r5\r)Q\u0005\u0007\u000bCqa!$d\t\u0003\u0019y\tC\u0004\u0004\u001a\u000e$\taa'\t\u000f\r}5\r\"\u0003\u0004\"\"91qU2\u0005\n\r%\u0006bBB]G\u0012%11\u0018\u0005\b\u0007{\u001bG\u0011BB`\u0011\u001d\u0019)m\u0019C\u0005\u0007\u000fDq!!\u001cd\t\u0003\ty\u0007C\u0004\u0002x\r$\ta!3\t\u000f\r]7\b\"\u0001\u0004Z\"91Q]\u001e\u0005\u0002\r\u001d\b\"CB{wE\u0005I\u0011AB|\u0011\u001d!ia\u000fC\u0001\u0007wCq\u0001b\u0004<\t\u0003!\t\u0002C\u0004\u0005\u0014m\"\t\u0001\"\u0006\t\u000f\u0011%2\b\"\u0001\u0005,!9A1I\u001e\u0005\u0002\u0011\u0015\u0003b\u0002C*w\u0011\u0005AQ\u000b\u0005\b\t;ZD\u0011AA5\u0011\u001d!yf\u000fC\u0001\tCBq\u0001\"\u001b<\t\u0003\"Y'\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0015\u0011\t9!!\u0003\u0002\u0015\r|G\u000e\\3di&|gN\u0003\u0002\u0002\f\u0005)1oY1mC\u000e\u0001\u0001cAA\t\u00035\u0011\u0011Q\u0001\u0002\t\u0013R,'/\u0019;peN\u0019\u0011!a\u0006\u0011\t\u0005e\u00111D\u0007\u0003\u0003\u0013IA!!\b\u0002\n\t1\u0011I\\=SK\u001a\fa\u0001P5oSRtDCAA\b\u0003QIE/\u001a:bi>\u00148)\u00198Ck&dGM\u0012:p[V!\u0011qEA\u001e+\t\tI\u0003\u0005\u0005\u0002,\u0005E\u0012qGA'\u001d\u0011\t\t\"!\f\n\t\u0005=\u0012QA\u0001\u0010)J\fg/\u001a:tC\ndWm\u00148dK&!\u00111GA\u001b\u0005Q\u0011UO\u001a4fe\u0016$7)\u00198Ck&dGM\u0012:p[*!\u0011qFA\u0003!\u0011\tI$a\u000f\r\u0001\u00119\u0011QH\u0002C\u0002\u0005}\"!A!\u0012\t\u0005\u0005\u0013q\t\t\u0005\u00033\t\u0019%\u0003\u0003\u0002F\u0005%!a\u0002(pi\"Lgn\u001a\t\u0005\u00033\tI%\u0003\u0003\u0002L\u0005%!aA!osB\u0019\u0011\u0011C\u001e\u0016\t\u0005E\u00131L\n\u0006w\u0005]\u00111\u000b\t\u0007\u0003#\t)&!\u0017\n\t\u0005]\u0013Q\u0001\u0002\u0010)J\fg/\u001a:tC\ndWm\u00148dKB!\u0011\u0011HA.\t!\tid\u000fCC\u0002\u0005}\u0012A\u0002\u0013j]&$H\u0005\u0006\u0002\u0002bA!\u0011\u0011DA2\u0013\u0011\t)'!\u0003\u0003\tUs\u0017\u000e^\u0001\u0004g\u0016\fXCAA6!\u0015\t\tbOA-\u0003\u001dA\u0017m\u001d(fqR,\"!!\u001d\u0011\t\u0005e\u00111O\u0005\u0005\u0003k\nIAA\u0004C_>dW-\u00198\u0002\t9,\u0007\u0010\u001e\u000b\u0003\u00033\nq![:F[B$\u00180\u0001\njgR\u0013\u0018M^3sg\u0006\u0014G.Z!hC&t\u0017a\u00045bg\u0012+g-\u001b8ji\u0016\u001c\u0016N_3\u0002\tQ\f7.\u001a\u000b\u0005\u0003W\n)\tC\u0004\u0002\b\u000e\u0003\r!!#\u0002\u00039\u0004B!!\u0007\u0002\f&!\u0011QRA\u0005\u0005\rIe\u000e^\u0001\u0005IJ|\u0007\u000f\u0006\u0003\u0002l\u0005M\u0005bBAD\t\u0002\u0007\u0011\u0011R\u0001\u0006g2L7-\u001a\u000b\u0007\u0003W\nI*!(\t\u000f\u0005mU\t1\u0001\u0002\n\u0006!aM]8n\u0011\u001d\ty*\u0012a\u0001\u0003\u0013\u000bQ!\u001e8uS2\fQb\u001d7jG\u0016LE/\u001a:bi>\u0014HCBA6\u0003K\u000b9\u000bC\u0004\u0002\u001c\u001a\u0003\r!!#\t\u000f\u0005}e\t1\u0001\u0002\n\u0006\u0019Q.\u00199\u0016\t\u00055\u00161\u0017\u000b\u0005\u0003_\u000b9\fE\u0003\u0002\u0012m\n\t\f\u0005\u0003\u0002:\u0005MFaBA[\u000f\n\u0007\u0011q\b\u0002\u0002\u0005\"9\u0011\u0011X$A\u0002\u0005m\u0016!\u00014\u0011\u0011\u0005e\u0011QXA-\u0003cKA!a0\u0002\n\tIa)\u001e8di&|g.M\u0001\u000bIAdWo\u001d\u0013qYV\u001cX\u0003BAc\u0003\u0017$B!a2\u0002PB)\u0011\u0011C\u001e\u0002JB!\u0011\u0011HAf\t\u001d\t)\f\u0013b\u0001\u0003\u001b\fB!!\u0017\u0002H!A\u0011\u0011\u001b%\u0005\u0002\u0004\t\u0019.\u0001\u0003uQ\u0006$\bCBA\r\u0003+\fI.\u0003\u0003\u0002X\u0006%!\u0001\u0003\u001fcs:\fW.\u001a \u0011\r\u0005E\u00111\\Ae\u0013\u0011\ti.!\u0002\u0003%\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK>s7-Z\u0001\bM2\fG/T1q+\u0011\t\u0019/!;\u0015\t\u0005\u0015\u00181\u001e\t\u0006\u0003#Y\u0014q\u001d\t\u0005\u0003s\tI\u000fB\u0004\u00026&\u0013\r!a\u0010\t\u000f\u0005e\u0016\n1\u0001\u0002nBA\u0011\u0011DA_\u00033\ny\u000f\u0005\u0004\u0002\u0012\u0005m\u0017q]\u0001\u0007M&dG/\u001a:\u0015\t\u0005-\u0014Q\u001f\u0005\b\u0003oT\u0005\u0019AA}\u0003\u0005\u0001\b\u0003CA\r\u0003{\u000bI&!\u001d\u0002\u0017\r|'O]3ta>tGm]\u000b\u0005\u0003\u007f\u0014i\u0001\u0006\u0003\u0003\u0002\t=A\u0003BA9\u0005\u0007Aq!a>L\u0001\u0004\u0011)\u0001\u0005\u0006\u0002\u001a\t\u001d\u0011\u0011\fB\u0006\u0003cJAA!\u0003\u0002\n\tIa)\u001e8di&|gN\r\t\u0005\u0003s\u0011i\u0001B\u0004\u00026.\u0013\r!a\u0010\t\u000f\u0005E7\n1\u0001\u0003\u0012A1\u0011\u0011CAn\u0005\u0017\t!b^5uQ\u001aKG\u000e^3s)\u0011\tYGa\u0006\t\u000f\u0005]H\n1\u0001\u0002z\u0006Ia-\u001b7uKJtu\u000e\u001e\u000b\u0005\u0003W\u0012i\u0002C\u0004\u0002x6\u0003\r!!?\u0002\u000f\r|G\u000e\\3diV!!1\u0005B\u0015)\u0011\u0011)Ca\u000b\u0011\u000b\u0005E1Ha\n\u0011\t\u0005e\"\u0011\u0006\u0003\b\u0003ks%\u0019AA \u0011\u001d\u0011iC\u0014a\u0001\u0005_\t!\u0001\u001d4\u0011\u0011\u0005e!\u0011GA-\u0005OIAAa\r\u0002\n\ty\u0001+\u0019:uS\u0006dg)\u001e8di&|g\u000eK\u0004O\u0005o\u0011\u0019Ea\u0012\u0011\t\te\"qH\u0007\u0003\u0005wQAA!\u0010\u0002\n\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\t\u0005#1\b\u0002\n[&<'/\u0019;j_:\f#A!\u0012\u0002\u0019\u0002\u001cw\u000e\u001c7fGR\u0004\u0007\u0005[1tA\rD\u0017M\\4fI:\u0002C\u000b[3!aJ,g/[8vg\u0002\u0012W\r[1wS>\u0014\beY1oA\t,\u0007E]3qe>$WoY3eA]LG\u000f\u001b\u0011ai>\u001cV-\u001d1/C\t\u0011I%A\u00033]ar\u0003'\u0001\u0005tG\u0006tG*\u001a4u+\u0011\u0011yEa\u0016\u0015\t\tE#q\f\u000b\u0005\u0005'\u0012I\u0006E\u0003\u0002\u0012m\u0012)\u0006\u0005\u0003\u0002:\t]CaBA[\u001f\n\u0007\u0011q\b\u0005\b\u00057z\u0005\u0019\u0001B/\u0003\ty\u0007\u000f\u0005\u0006\u0002\u001a\t\u001d!QKA-\u0005+BqA!\u0019P\u0001\u0004\u0011)&A\u0001{\u0003%\u00198-\u00198SS\u001eDG/\u0006\u0003\u0003h\t=D\u0003\u0002B5\u0005k\"BAa\u001b\u0003rA)\u0011\u0011C\u001e\u0003nA!\u0011\u0011\bB8\t\u001d\t)\f\u0015b\u0001\u0003\u007fAqAa\u0017Q\u0001\u0004\u0011\u0019\b\u0005\u0006\u0002\u001a\t\u001d\u0011\u0011\fB7\u0005[BqA!\u0019Q\u0001\u0004\u0011i'A\u0005uC.,w\u000b[5mKR!\u00111\u000eB>\u0011\u001d\t90\u0015a\u0001\u0003s\f\u0011\u0002]1si&$\u0018n\u001c8\u0015\t\t\u0005%q\u0011\t\t\u00033\u0011\u0019)a\u001b\u0002l%!!QQA\u0005\u0005\u0019!V\u000f\u001d7fe!9\u0011q\u001f*A\u0002\u0005e\u0018\u0001B:qC:$BA!!\u0003\u000e\"9\u0011q_*A\u0002\u0005e\u0018!\u00033s_B<\u0006.\u001b7f)\u0011\tYGa%\t\u000f\u0005]H\u000b1\u0001\u0002z\u0006\u0019!0\u001b9\u0016\t\te%\u0011\u0015\u000b\u0005\u00057\u0013\u0019\u000bE\u0003\u0002\u0012m\u0012i\n\u0005\u0005\u0002\u001a\t\r\u0015\u0011\fBP!\u0011\tID!)\u0005\u000f\u0005UVK1\u0001\u0002@!9\u0011\u0011[+A\u0002\t\u0015\u0006#BA\tw\t}\u0015!\u00029bIR{W\u0003\u0002BV\u0005c#bA!,\u00036\ne\u0006#BA\tw\t=\u0006\u0003BA\u001d\u0005c#qAa-W\u0005\u0004\tiM\u0001\u0002Bc!9!q\u0017,A\u0002\u0005%\u0015a\u00017f]\"9!1\u0018,A\u0002\t=\u0016\u0001B3mK6\fAB_5q/&$\b.\u00138eKb,\"A!1\u0011\u000b\u0005E1Ha1\u0011\u0011\u0005e!1QA-\u0003\u0013\u000baA_5q\u00032dW\u0003\u0003Be\u0005;\u0014\tN!6\u0015\u0011\t-'q\u001cBr\u0005O\u0004R!!\u0005<\u0005\u001b\u0004\u0002\"!\u0007\u0003\u0004\n='1\u001b\t\u0005\u0003s\u0011\t\u000eB\u0004\u00034b\u0013\r!!4\u0011\t\u0005e\"Q\u001b\u0003\b\u0005/D&\u0019\u0001Bm\u0005\t\u0011\u0015'\u0005\u0003\u0003\\\u0006\u001d\u0003\u0003BA\u001d\u0005;$q!!.Y\u0005\u0004\ty\u0004C\u0004\u0002Rb\u0003\rA!9\u0011\u000b\u0005E1Ha7\t\u000f\t\u0015\b\f1\u0001\u0003P\u0006AA\u000f[5t\u000b2,W\u000eC\u0004\u0003jb\u0003\rAa5\u0002\u0011QD\u0017\r^#mK6\fqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0003p\n]H\u0003BA1\u0005cDq!!/Z\u0001\u0004\u0011\u0019\u0010\u0005\u0005\u0002\u001a\u0005u\u0016\u0011\fB{!\u0011\tIDa>\u0005\u000f\te\u0018L1\u0001\u0002@\t\tQ+\u0001\u0004g_J\fG\u000e\u001c\u000b\u0005\u0003c\u0012y\u0010C\u0004\u0002xj\u0003\r!!?\u0002\r\u0015D\u0018n\u001d;t)\u0011\t\th!\u0002\t\u000f\u0005]8\f1\u0001\u0002z\u0006A1m\u001c8uC&t7\u000f\u0006\u0003\u0002r\r-\u0001b\u0002B^9\u0002\u0007\u0011qI\u0001\u0005M&tG\r\u0006\u0003\u0004\u0012\r]\u0001CBA\r\u0007'\tI&\u0003\u0003\u0004\u0016\u0005%!AB(qi&|g\u000eC\u0004\u0002xv\u0003\r!!?\u0002\u0015%tG-\u001a=XQ\u0016\u0014X\r\u0006\u0003\u0002\n\u000eu\u0001bBA|=\u0002\u0007\u0011\u0011 \u000b\u0007\u0003\u0013\u001b\tca\t\t\u000f\u0005]x\f1\u0001\u0002z\"9\u00111T0A\u0002\u0005%\u0015aB5oI\u0016DxJZ\u000b\u0005\u0007S\u0019y\u0003\u0006\u0003\u0002\n\u000e-\u0002b\u0002B^A\u0002\u00071Q\u0006\t\u0005\u0003s\u0019y\u0003B\u0004\u00026\u0002\u0014\r!!4\u0016\t\rM2\u0011\b\u000b\u0007\u0003\u0013\u001b)da\u000f\t\u000f\tm\u0016\r1\u0001\u00048A!\u0011\u0011HB\u001d\t\u001d\t),\u0019b\u0001\u0003\u001bDq!a'b\u0001\u0004\tI)\u0001\u0005ck\u001a4WM]3e+\t\u0019\t\u0005\u0005\u0004\u0002\u0012\r\r\u0013\u0011L\u0005\u0005\u0007\u000b\n)A\u0001\tCk\u001a4WM]3e\u0013R,'/\u0019;pe\nyqI]8va\u0016$\u0017\n^3sCR|'/\u0006\u0003\u0004L\rm3#B2\u0004N\ru\u0003CBA\t\u0007\u001f\u001a\u0019&\u0003\u0003\u0004R\u0005\u0015!\u0001E!cgR\u0014\u0018m\u0019;Ji\u0016\u0014\u0018\r^8s!\u0019\t\tb!\u0016\u0004Z%!1qKA\u0003\u0005\r\u0019V-\u001d\t\u0005\u0003s\u0019Y\u0006B\u0004\u00026\u000e\u0014\r!!4\u0011\u000b\u0005E1ha\u0015\u0002\tM,GNZ\u0001\u0005g&TX-\u0001\u0003ti\u0016\u0004H\u0003CB4\u0007W\u001aiga\u001c\u0011\u000b\r%4m!\u0017\u000e\u0003mBqaa\u0018h\u0001\u0004\tY\u0007C\u0004\u0004b\u001d\u0004\r!!#\t\u000f\r\rt\r1\u0001\u0002\n\u00061!-\u001e4gKJ\u0004ba!\u001e\u0004|\reSBAB<\u0015\u0011\u0019I(!\u0002\u0002\u000f5,H/\u00192mK&!1QPB<\u0005-\t%O]1z\u0005V4g-\u001a:\u0002\r\u0019LG\u000e\\3e\u0003!y\u0006/\u0019:uS\u0006d\u0017a\u00019bIB1\u0011\u0011DB\n\u0007\u000f\u0003b!!\u0007\u0004\n\u000ee\u0013\u0002BBF\u0003\u0013\u0011\u0011BR;oGRLwN\u001c\u0019\u0002\u0017]LG\u000f\u001b)bI\u0012Lgn\u001a\u000b\u0005\u0007#\u001b\u0019*D\u0001d\u0011!\u0019)\n\u001cCA\u0002\r]\u0015!\u0001=\u0011\r\u0005e\u0011Q[B-\u0003-9\u0018\u000e\u001e5QCJ$\u0018.\u00197\u0015\t\rE5Q\u0014\u0005\b\u0007+k\u0007\u0019AA9\u0003E!\u0018m[3EKN$(/^2uSZ,G.\u001f\u000b\u0005\u0007G\u001b)\u000b\u0005\u0004\u0002\u0012\rU\u0013\u0011\f\u0005\b\u0007Cr\u0007\u0019AAE\u0003\u001d\u0001\u0018\r\u001a3j]\u001e$Baa+\u00048B11QVBZ\u00073j!aa,\u000b\t\rE\u0016QA\u0001\nS6lW\u000f^1cY\u0016LAa!.\u00040\n!A*[:u\u0011\u001d\u0019)j\u001ca\u0001\u0003\u0013\u000b1aZ1q+\t\tI)\u0001\u0002h_R!\u0011\u0011OBa\u0011\u001d\u0019\u0019-\u001da\u0001\u0003\u0013\u000bQaY8v]R\fAAZ5mYR\u0011\u0011\u0011\u000f\u000b\u0003\u0007\u0017\u0004ba!4\u0004T\u000eec\u0002BA\r\u0007\u001fLAa!5\u0002\n\u00059\u0001/Y2lC\u001e,\u0017\u0002BB[\u0007+TAa!5\u0002\n\u00059qM]8va\u0016$W\u0003BBn\u0007C$Ba!8\u0004dB)1\u0011N2\u0004`B!\u0011\u0011HBq\t\u001d\t),\u001eb\u0001\u0003\u001bDqa!\u0019v\u0001\u0004\tI)A\u0004tY&$\u0017N\\4\u0016\t\r%8q\u001e\u000b\u0007\u0007W\u001c\tpa=\u0011\u000b\r%4m!<\u0011\t\u0005e2q\u001e\u0003\b\u0003k3(\u0019AAg\u0011\u001d\u0019\tG\u001ea\u0001\u0003\u0013C\u0011ba\u0019w!\u0003\u0005\r!!#\u0002#Md\u0017\u000eZ5oO\u0012\"WMZ1vYR$#'\u0006\u0003\u0004z\u0012-QCAB~U\u0011\tIi!@,\u0005\r}\b\u0003\u0002C\u0001\t\u000fi!\u0001b\u0001\u000b\t\u0011\u0015!1H\u0001\nk:\u001c\u0007.Z2lK\u0012LA\u0001\"\u0003\u0005\u0004\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u000f\u0005UvO1\u0001\u0002N\u00061A.\u001a8hi\"\f\u0011\u0002Z;qY&\u001c\u0017\r^3\u0016\u0005\t\u0005\u0015!\u00029bi\u000eDW\u0003\u0002C\f\t;!\u0002\u0002\"\u0007\u0005 \u0011\u0005BQ\u0005\t\u0006\u0003#YD1\u0004\t\u0005\u0003s!i\u0002B\u0004\u00026j\u0014\r!!4\t\u000f\u0005m%\u00101\u0001\u0002\n\"9A1\u0005>A\u0002\u0011e\u0011A\u00039bi\u000eDW\t\\3ng\"9Aq\u0005>A\u0002\u0005%\u0015\u0001\u0003:fa2\f7-\u001a3\u0002\u0017\r|\u0007/\u001f+p\u0003J\u0014\u0018-_\u000b\u0005\t[!Y\u0004\u0006\u0005\u0002b\u0011=BQ\bC!\u0011\u001d!\td\u001fa\u0001\tg\t!\u0001_:\u0011\r\u0005eAQ\u0007C\u001d\u0013\u0011!9$!\u0003\u0003\u000b\u0005\u0013(/Y=\u0011\t\u0005eB1\b\u0003\b\u0003k[(\u0019AAg\u0011\u001d!yd\u001fa\u0001\u0003\u0013\u000bQa\u001d;beRDqAa.|\u0001\u0004\tI)\u0001\u0007tC6,W\t\\3nK:$8\u000f\u0006\u0003\u0002r\u0011\u001d\u0003bBAiy\u0002\u0007A\u0011\n\u0019\u0005\t\u0017\"y\u0005E\u0003\u0002\u0012m\"i\u0005\u0005\u0003\u0002:\u0011=C\u0001\u0004C)\t\u000f\n\t\u0011!A\u0003\u0002\u0005}\"aA0%e\u0005iAo\u001c+sCZ,'o]1cY\u0016,\"\u0001b\u0016\u0011\r\u0005EA\u0011LA-\u0013\u0011!Y&!\u0002\u0003\u0017Q\u0013\u0018M^3sg\u0006\u0014G.Z\u0001\u000bi>LE/\u001a:bi>\u0014\u0018\u0001\u0003;p'R\u0014X-Y7\u0016\u0005\u0011\r\u0004CBBW\tK\nI&\u0003\u0003\u0005h\r=&AB*ue\u0016\fW.\u0001\u0005u_N#(/\u001b8h)\t!i\u0007\u0005\u0003\u0005p\u0011eTB\u0001C9\u0015\u0011!\u0019\b\"\u001e\u0002\t1\fgn\u001a\u0006\u0003\to\nAA[1wC&!A1\u0010C9\u0005\u0019\u0019FO]5oO\u0006)Q-\u001c9usV\u0011A\u0011\u0011\t\u0006\u0003#Y\u0014\u0011I\u0001\u0007K6\u0004H/\u001f\u0011\u0002\rMLgn\u001a7f+\u0011!I\tb$\u0015\t\u0011-E\u0011\u0013\t\u0006\u0003#YDQ\u0012\t\u0005\u0003s!y\tB\u0004\u0002>\u0019\u0011\r!a\u0010\t\u000f\tmf\u00011\u0001\u0005\u000e\u0006)\u0011\r\u001d9msV!Aq\u0013CO)\u0011!I\nb(\u0011\u000b\u0005E1\bb'\u0011\t\u0005eBQ\u0014\u0003\b\u0003{9!\u0019AA \u0011\u001d!\tk\u0002a\u0001\tG\u000bQ!\u001a7f[N\u0004b!!\u0007\u0005&\u0012m\u0015\u0002\u0002CT\u0003\u0013\u0011!\u0002\u0010:fa\u0016\fG/\u001a3?+\u0011!Y\u000bb-\u0015\t\u00115F\u0011\u0018\u000b\u0005\t_#)\fE\u0003\u0002\u0012m\"\t\f\u0005\u0003\u0002:\u0011MFaBA\u001f\u0011\t\u0007\u0011q\b\u0005\t\u0005wCA\u00111\u0001\u00058B1\u0011\u0011DAk\tcCqAa.\t\u0001\u0004\tI)\u0001\u0005uC\n,H.\u0019;f+\u0011!y\fb2\u0015\t\u0011\u0005GQ\u001a\u000b\u0005\t\u0007$I\rE\u0003\u0002\u0012m\")\r\u0005\u0003\u0002:\u0011\u001dGaBA\u001f\u0013\t\u0007\u0011q\b\u0005\b\u0003sK\u0001\u0019\u0001Cf!!\tI\"!0\u0002\n\u0012\u0015\u0007b\u0002Ch\u0013\u0001\u0007\u0011\u0011R\u0001\u0004K:$\u0017!\u0002:b]\u001e,GC\u0002Ck\t/$I\u000eE\u0003\u0002\u0012m\nI\tC\u0004\u0005@)\u0001\r!!#\t\u000f\u0011='\u00021\u0001\u0002\nRAAQ\u001bCo\t?$\t\u000fC\u0004\u0005@-\u0001\r!!#\t\u000f\u0011=7\u00021\u0001\u0002\n\"911M\u0006A\u0002\u0005%\u0015aB5uKJ\fG/Z\u000b\u0005\tO$y\u000f\u0006\u0003\u0005j\u0012]H\u0003\u0002Cv\tg\u0004R!!\u0005<\t[\u0004B!!\u000f\u0005p\u00129A\u0011\u001f\u0007C\u0002\u0005}\"!\u0001+\t\u000f\u0005eF\u00021\u0001\u0005vBA\u0011\u0011DA_\t[$i\u000fC\u0004\u0005@1\u0001\r\u0001\"<\u0015\t\u0011UG1 \u0005\b\t\u007fi\u0001\u0019AAE)\u0019!)\u000eb@\u0006\u0002!9Aq\b\bA\u0002\u0005%\u0005bBB2\u001d\u0001\u0007\u0011\u0011R\u0001\fG>tG/\u001b8vC2d\u00170\u0006\u0003\u0006\b\u00155A\u0003BC\u0005\u000b\u001f\u0001R!!\u0005<\u000b\u0017\u0001B!!\u000f\u0006\u000e\u00119\u0011QH\bC\u0002\u0005}\u0002\u0002\u0003B^\u001f\u0011\u0005\r!\"\u0005\u0011\r\u0005e\u0011Q[C\u0006\u00059\u0019uN\\2bi&#XM]1u_J,B!b\u0006\u0006\u001eM)\u0001#a\u0006\u0006\u001aA)\u0011\u0011C\u001e\u0006\u001cA!\u0011\u0011HC\u000f\t!\ti\u0004\u0005CC\u0002\u0005}\u0012aB2veJ,g\u000e^\u000b\u0003\u000bG\u0001R!!\u0005<\u000bKQC!b\u0007\u0004~\u0006Y1-\u001e:sK:$x\fJ3r)\u0011\t\t'b\u000b\t\u0013\u00155\"#!AA\u0002\u0015\r\u0012a\u0001=%c\u0005A1-\u001e:sK:$\b\u0005\u0006\u0003\u00064\u0015]\u0002#BC\u001b!\u0015mQ\"A\u0001\t\u000f\u0015}A\u00031\u0001\u0006$\u0005!A/Y5m+\t)i\u0004E\u0003\u00066\r*)C\u0001\nD_:\u001c\u0017\r^%uKJ\fGo\u001c:DK2dW\u0003BC\"\u000b\u001b\u001a2aIA\f\u0003\u0011AW-\u00193\u0011\r\u0005e\u0011Q[C%!\u0019\t\t\"a7\u0006LA!\u0011\u0011HC'\t\u001d\tid\tb\u0001\u0003\u007f)\"!\"\u0015\u0011\u000b\u0015U2%b\u0013\u0002\u0011Q\f\u0017\u000e\\0%KF$B!!\u0019\u0006X!IQQ\u0006\u0014\u0002\u0002\u0003\u0007Q\u0011K\u0001\u0006i\u0006LG\u000e\t\u000b\u0007\u000b#*i&b\u0018\t\u0011\u0015\u0015\u0003\u0006\"a\u0001\u000b\u000fBq!\"\u000f)\u0001\u0004)\t&\u0001\u0007iK\u0006$\u0017\n^3sCR|'/\u0006\u0002\u0006fA)\u0011\u0011C\u001e\u0006LQ!\u0011\u0011MC5\u0011%)iCFA\u0001\u0002\u0004)i$\u0001\u0003mCN$\u0018\u0001\u00037bgR|F%Z9\u0015\t\u0005\u0005T\u0011\u000f\u0005\n\u000b[I\u0012\u0011!a\u0001\u000b{\tQ\u0001\\1ti\u0002\nQcY;se\u0016tG\u000fS1t\u001d\u0016DHo\u00115fG.,G-A\rdkJ\u0014XM\u001c;ICNtU\r\u001f;DQ\u0016\u001c7.\u001a3`I\u0015\fH\u0003BA1\u000bwB\u0011\"\"\f\u001d\u0003\u0003\u0005\r!!\u001d\u0002-\r,(O]3oi\"\u000b7OT3yi\u000eCWmY6fI\u0002\nq!\u00193wC:\u001cW\rK\u0002\u001f\u000b\u0007\u0003BA!\u000f\u0006\u0006&!Qq\u0011B\u001e\u0005\u001d!\u0018-\u001b7sK\u000e\fQ!\\3sO\u0016D3aHCB)\t)Y\"\u0006\u0003\u0006\u0012\u0016]E\u0003BCJ\u000b7\u0003R!!\u0005<\u000b+\u0003B!!\u000f\u0006\u0018\u00129\u0011Q\u0017\u0012C\u0002\u0015e\u0015\u0003BC\u000e\u0003\u000fB\u0001\"!5#\t\u0003\u0007QQ\u0014\t\u0007\u00033\t).b(\u0011\r\u0005E\u00111\\CK\u00055\u0019F.[2f\u0013R,'/\u0019;peV!QQUCV'\rQSq\u0015\t\u0007\u0003#\u0019y%\"+\u0011\t\u0005eR1\u0016\u0003\b\u0003{Q#\u0019AA \u0003))h\u000eZ3sYfLgnZ\u000b\u0003\u000bc\u0003R!!\u0005<\u000bS\u000b1\"\u001e8eKJd\u00170\u001b8hA\u0005)A.[7jiRAQ\u0011XC^\u000b{+y\fE\u0003\u00066)*I\u000bC\u0004\u0006.>\u0002\r!\"-\t\u000f\u0011}r\u00061\u0001\u0002\n\"9QQW\u0018A\u0002\u0005%\u0015AM:dC2\fGeY8mY\u0016\u001cG/[8oI%#XM]1u_J$3\u000b\\5dK&#XM]1u_J$CE]3nC&t\u0017N\\4\u0002mM\u001c\u0017\r\\1%G>dG.Z2uS>tG%\u0013;fe\u0006$xN\u001d\u0013TY&\u001cW-\u0013;fe\u0006$xN\u001d\u0013%e\u0016l\u0017-\u001b8j]\u001e|F%Z9\u0015\t\u0005\u0005Tq\u0019\u0005\n\u000b[\t\u0014\u0011!a\u0001\u0003\u0013\u000b1g]2bY\u0006$3m\u001c7mK\u000e$\u0018n\u001c8%\u0013R,'/\u0019;pe\u0012\u001aF.[2f\u0013R,'/\u0019;pe\u0012\"#/Z7bS:Lgn\u001a\u0011\u0002\u0011\u0011\u0014x\u000e\u001d9j]\u001e\fA\u0002\u001a:paBLgnZ0%KF$B!!\u0019\u0006R\"IQQ\u0006\u001b\u0002\u0002\u0003\u0007\u0011\u0011R\u0001\nIJ|\u0007\u000f]5oO\u0002\n\u0011\"\u001e8c_VtG-\u001a3)\u0007Y*I\u000e\u0005\u0003\u0002\u001a\u0015m\u0017\u0002BCo\u0003\u0013\u0011a!\u001b8mS:,\u0017\u0001B:lSB$\"!\"+\u0015\r\u0015EVQ]Ct\u0011\u001d\tYJ\u000fa\u0001\u0003\u0013Cq!a(;\u0001\u0004\tI\t")
public interface Iterator<A>
extends TraversableOnce<A> {
    public static <A> Iterator<A> continually(Function0<A> function0) {
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new AbstractIterator<A>(function0){
            private final Function0 elem$3;

            public boolean hasNext() {
                return true;
            }

            public A next() {
                return (A)this.elem$3.apply();
            }
            {
                this.elem$3 = elem$3;
            }
        };
    }

    public static Iterator<Object> from(int n, int n2) {
        return Iterator$.MODULE$.from(n, n2);
    }

    public static Iterator<Object> from(int n) {
        return Iterator$.MODULE$.from(n);
    }

    public static <T> Iterator<T> iterate(T t, Function1<T, T> function1) {
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new AbstractIterator<T>(t, function1){
            private boolean first;
            private T acc;
            private final Function1 f$2;

            public boolean hasNext() {
                return true;
            }

            public T next() {
                if (this.first) {
                    this.first = false;
                } else {
                    this.acc = this.f$2.apply(this.acc);
                }
                return this.acc;
            }
            {
                this.f$2 = f$2;
                this.first = true;
                this.acc = start$2;
            }
        };
    }

    public static Iterator<Object> range(int n, int n2, int n3) {
        return Iterator$.MODULE$.range(n, n2, n3);
    }

    public static Iterator<Object> range(int n, int n2) {
        return Iterator$.MODULE$.range(n, n2);
    }

    public static <A> Iterator<A> tabulate(int n, Function1<Object, A> function1) {
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new AbstractIterator<A>(n, function1){
            private int i;
            private final int end$1;
            private final Function1 f$1;

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                return this.i() < this.end$1;
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                if (this.hasNext()) {
                    void var1_1;
                    R result2 = this.f$1.apply(BoxesRunTime.boxToInteger(this.i()));
                    this.i_$eq(this.i() + 1);
                    return var1_1;
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                this.end$1 = end$1;
                this.f$1 = f$1;
                this.i = 0;
            }
        };
    }

    public static <A> Iterator<A> fill(int n, Function0<A> function0) {
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new AbstractIterator<A>(n, function0){
            private int i;
            private final int len$1;
            private final Function0 elem$2;

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                return this.i() < this.len$1;
            }

            public A next() {
                if (this.hasNext()) {
                    this.i_$eq(this.i() + 1);
                    return (A)this.elem$2.apply();
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                this.len$1 = len$1;
                this.elem$2 = elem$2;
                this.i = 0;
            }
        };
    }

    public static <A> Iterator<A> apply(Seq<A> seq) {
        return Iterator$.MODULE$.apply(seq);
    }

    public static <A> Iterator<A> single(A a) {
        return Iterator$.MODULE$.single(a);
    }

    public static Iterator<Nothing$> empty() {
        return Iterator$.MODULE$.empty();
    }

    public static <A> TraversableOnce.BufferedCanBuildFrom<A, Iterator> IteratorCanBuildFrom() {
        return Iterator$.MODULE$.IteratorCanBuildFrom();
    }

    @Override
    default public Iterator<A> seq() {
        return this;
    }

    public boolean hasNext();

    public A next();

    @Override
    default public boolean isEmpty() {
        return !this.hasNext();
    }

    @Override
    default public boolean isTraversableAgain() {
        return false;
    }

    @Override
    default public boolean hasDefiniteSize() {
        return this.isEmpty();
    }

    default public Iterator<A> take(int n) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return this.sliceIterator(0, RichInt$.MODULE$.max$extension(n, 0));
    }

    default public Iterator<A> drop(int n) {
        for (int j = 0; j < n && this.hasNext(); ++j) {
            this.next();
        }
        return this;
    }

    default public Iterator<A> slice(int from, int until) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return this.sliceIterator(from, RichInt$.MODULE$.max$extension(until, 0));
    }

    default public Iterator<A> sliceIterator(int from, int until) {
        int rest;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int lo = RichInt$.MODULE$.max$extension(from, 0);
        int n = until < 0 ? -1 : (rest = until <= lo ? 0 : until - lo);
        if (rest == 0) {
            return Iterator$.MODULE$.empty();
        }
        return new SliceIterator(this, lo, rest);
    }

    default public <B> Iterator<B> map(Function1<A, B> f) {
        return new AbstractIterator<B>(this, f){
            private final /* synthetic */ Iterator $outer;
            private final Function1 f$3;

            public boolean hasNext() {
                return this.$outer.hasNext();
            }

            public B next() {
                return (B)this.f$3.apply(this.$outer.next());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.f$3 = f$3;
            }
        };
    }

    public static /* synthetic */ Iterator $plus$plus$(Iterator $this, Function0 that) {
        return $this.$plus$plus(that);
    }

    default public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
        return new ConcatIterator(this).$plus$plus(that);
    }

    default public <B> Iterator<B> flatMap(Function1<A, GenTraversableOnce<B>> f) {
        return new AbstractIterator<B>(this, f){
            private Iterator<B> cur;
            private final /* synthetic */ Iterator $outer;
            private final Function1 f$4;

            private Iterator<B> cur() {
                return this.cur;
            }

            private void cur_$eq(Iterator<B> x$1) {
                this.cur = x$1;
            }

            private void nextCur() {
                this.cur_$eq(null);
                this.cur_$eq(((GenTraversableOnce)this.f$4.apply(this.$outer.next())).toIterator());
            }

            public boolean hasNext() {
                while (!this.cur().hasNext()) {
                    if (!this.$outer.hasNext()) {
                        return false;
                    }
                    this.nextCur();
                }
                return true;
            }

            public B next() {
                return (B)(this.hasNext() ? this.cur() : Iterator$.MODULE$.empty()).next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.f$4 = f$4;
                this.cur = Iterator$.MODULE$.empty();
            }
        };
    }

    default public Iterator<A> filter(Function1<A, Object> p) {
        return new AbstractIterator<A>(this, p){
            private A hd;
            private boolean hdDefined;
            private final /* synthetic */ Iterator $outer;
            private final Function1 p$1;

            private A hd() {
                return this.hd;
            }

            private void hd_$eq(A x$1) {
                this.hd = x$1;
            }

            private boolean hdDefined() {
                return this.hdDefined;
            }

            private void hdDefined_$eq(boolean x$1) {
                this.hdDefined = x$1;
            }

            public boolean hasNext() {
                if (!this.hdDefined()) {
                    do {
                        if (!this.$outer.hasNext()) {
                            return false;
                        }
                        this.hd_$eq(this.$outer.next());
                    } while (!BoxesRunTime.unboxToBoolean(this.p$1.apply(this.hd())));
                    this.hdDefined_$eq(true);
                }
                return true;
            }

            public A next() {
                if (this.hasNext()) {
                    this.hdDefined_$eq(false);
                    return this.hd();
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.p$1 = p$1;
                this.hdDefined = false;
            }
        };
    }

    default public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<A, B, Object> p) {
        Iterator<B> that0 = that.toIterator();
        while (this.hasNext() && that0.hasNext()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(this.next(), that0.next()))) continue;
            return false;
        }
        return this.hasNext() == that0.hasNext();
    }

    default public Iterator<A> withFilter(Function1<A, Object> p) {
        return this.filter(p);
    }

    default public Iterator<A> filterNot(Function1<A, Object> p) {
        return this.filter((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(Iterator.$anonfun$filterNot$1(p, x$1)));
    }

    default public <B> Iterator<B> collect(PartialFunction<A, B> pf) {
        return new AbstractIterator<B>(this, pf){
            private A hd;
            private int status;
            private final /* synthetic */ Iterator $outer;
            private final PartialFunction pf$1;

            public boolean hasNext() {
                while (this.status == 0) {
                    if (this.$outer.hasNext()) {
                        this.hd = this.$outer.next();
                        if (!this.pf$1.isDefinedAt(this.hd)) continue;
                        this.status = 1;
                        continue;
                    }
                    this.status = -1;
                }
                return this.status == 1;
            }

            public B next() {
                if (this.hasNext()) {
                    this.status = 0;
                    return (B)this.pf$1.apply(this.hd);
                }
                return (B)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pf$1 = pf$1;
                this.status = 0;
            }
        };
    }

    default public <B> Iterator<B> scanLeft(B z, Function2<B, A, B> op) {
        return new AbstractIterator<B>(this, z, op){
            private int state;
            private B accum;
            private final /* synthetic */ Iterator $outer;
            private final Function2 op$1;

            /*
             * WARNING - void declaration
             */
            private B gen() {
                void var1_1;
                R res = this.op$1.apply(this.accum, this.$outer.next());
                this.accum = res;
                return var1_1;
            }

            public boolean hasNext() {
                switch (this.state) {
                    case 0: 
                    case 2: {
                        return true;
                    }
                    case 3: {
                        return false;
                    }
                }
                if (this.$outer.hasNext()) {
                    this.state = 2;
                    return true;
                }
                this.state = 3;
                return false;
            }

            public B next() {
                int n = this.state;
                switch (n) {
                    case 0: {
                        this.state = 1;
                        return this.accum;
                    }
                    case 1: {
                        return this.gen();
                    }
                    case 2: {
                        this.state = 1;
                        return this.gen();
                    }
                    case 3: {
                        return (B)Iterator$.MODULE$.empty().next();
                    }
                }
                throw new MatchError(BoxesRunTime.boxToInteger(n));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.op$1 = op$1;
                this.state = 0;
                this.accum = z$1;
            }
        };
    }

    default public <B> Iterator<B> scanRight(B z, Function2<A, B, B> op) {
        return ((IterableLike)this.toBuffer().scanRight(z, op, Buffer$.MODULE$.canBuildFrom())).iterator();
    }

    default public Iterator<A> takeWhile(Function1<A, Object> p) {
        return new AbstractIterator<A>(this, p){
            private A hd;
            private boolean hdDefined;
            private Iterator<A> tail;
            private final Function1 p$3;

            private A hd() {
                return this.hd;
            }

            private void hd_$eq(A x$1) {
                this.hd = x$1;
            }

            private boolean hdDefined() {
                return this.hdDefined;
            }

            private void hdDefined_$eq(boolean x$1) {
                this.hdDefined = x$1;
            }

            private Iterator<A> tail() {
                return this.tail;
            }

            private void tail_$eq(Iterator<A> x$1) {
                this.tail = x$1;
            }

            public boolean hasNext() {
                block6: {
                    block5: {
                        if (this.hdDefined()) break block5;
                        if (!this.tail().hasNext()) break block6;
                        this.hd_$eq(this.tail().next());
                        if (BoxesRunTime.unboxToBoolean(this.p$3.apply(this.hd()))) {
                            this.hdDefined_$eq(true);
                        } else {
                            this.tail_$eq(Iterator$.MODULE$.empty());
                        }
                        if (!this.hdDefined()) break block6;
                    }
                    return true;
                }
                return false;
            }

            public A next() {
                if (this.hasNext()) {
                    this.hdDefined_$eq(false);
                    return this.hd();
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                this.p$3 = p$3;
                this.hdDefined = false;
                this.tail = $outer;
            }
        };
    }

    default public Tuple2<Iterator<A>, Iterator<A>> partition(Function1<A, Object> p) {
        BufferedIterator<A> self = this.buffered();
        public class Scala_collection_Iterator$PartitionIterator$1
        extends AbstractIterator<A> {
            private final Function1<A, Object> p;
            private Scala_collection_Iterator$PartitionIterator$1 other;
            private final Queue<A> lookahead;
            private final BufferedIterator self$1;

            public Scala_collection_Iterator$PartitionIterator$1 other() {
                return this.other;
            }

            public void other_$eq(Scala_collection_Iterator$PartitionIterator$1 x$1) {
                this.other = x$1;
            }

            public Queue<A> lookahead() {
                return this.lookahead;
            }

            public void skip() {
                while (this.self$1.hasNext() && !BoxesRunTime.unboxToBoolean(this.p.apply(this.self$1.head()))) {
                    this.other().lookahead().$plus$eq((Object)this.self$1.next());
                }
            }

            public boolean hasNext() {
                block3: {
                    block2: {
                        if (!this.lookahead().isEmpty()) break block2;
                        this.skip();
                        if (!this.self$1.hasNext()) break block3;
                    }
                    return true;
                }
                return false;
            }

            public A next() {
                if (!this.lookahead().isEmpty()) {
                    return this.lookahead().dequeue();
                }
                this.skip();
                return this.self$1.next();
            }

            /*
             * WARNING - void declaration
             */
            public Scala_collection_Iterator$PartitionIterator$1(Function1<A, Object> p) {
                void var3_3;
                this.p = p;
                this.self$1 = var3_3;
                this.lookahead = new Queue<A>();
            }
        }
        Scala_collection_Iterator$PartitionIterator$1 l = new Scala_collection_Iterator$PartitionIterator$1(null, p, self);
        Scala_collection_Iterator$PartitionIterator$1 r = new Scala_collection_Iterator$PartitionIterator$1(null, (Function1<Object, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(Iterator.$anonfun$partition$1(p, x$2)), self);
        l.other_$eq(r);
        r.other_$eq(l);
        return new Tuple2<Iterator<A>, Iterator<A>>(l, r);
    }

    default public Tuple2<Iterator<A>, Iterator<A>> span(Function1<A, Object> p) {
        public class Scala_collection_Iterator$Leading$1
        extends AbstractIterator<A> {
            private Queue<A> lookahead;
            private A hd;
            private int status;
            private final /* synthetic */ Iterator $outer;
            private final Function1 p$5;

            private void store(A a) {
                if (this.lookahead == null) {
                    this.lookahead = new Queue<A>();
                }
                this.lookahead.$plus$eq((Object)a);
            }

            public boolean hasNext() {
                if (this.status < 0) {
                    return this.lookahead != null && this.lookahead.nonEmpty();
                }
                if (this.status > 0) {
                    return true;
                }
                if (this.$outer.hasNext()) {
                    this.hd = this.$outer.next();
                    this.status = BoxesRunTime.unboxToBoolean(this.p$5.apply(this.hd)) ? 1 : -2;
                } else {
                    this.status = -1;
                }
                return this.status > 0;
            }

            public A next() {
                if (this.hasNext()) {
                    if (this.status == 1) {
                        this.status = 0;
                        return this.hd;
                    }
                    return this.lookahead.dequeue();
                }
                return (A)Iterator$.MODULE$.empty().next();
            }

            public boolean finish() {
                int n;
                block6: while (true) {
                    n = this.status;
                    switch (n) {
                        case -2: {
                            this.status = -1;
                            return true;
                        }
                        case -1: {
                            return false;
                        }
                        case 1: {
                            this.store(this.hd);
                            this.status = 0;
                            continue block6;
                        }
                        case 0: {
                            this.status = -1;
                            while (this.$outer.hasNext()) {
                                A a = this.$outer.next();
                                if (BoxesRunTime.unboxToBoolean(this.p$5.apply(a))) {
                                    this.store(a);
                                    continue;
                                }
                                this.hd = a;
                                return true;
                            }
                            return false;
                        }
                    }
                    break;
                }
                throw new MatchError(BoxesRunTime.boxToInteger(n));
            }

            public A trailer() {
                return this.hd;
            }

            public Scala_collection_Iterator$Leading$1(Iterator $outer, Function1 p$5) {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.p$5 = p$5;
                this.lookahead = null;
                this.status = 0;
            }
        }
        Scala_collection_Iterator$Leading$1 leading = new Scala_collection_Iterator$Leading$1(this, p);
        AbstractIterator trailing = new AbstractIterator<A>(this, leading){
            private Scala_collection_Iterator$Leading$1 myLeading;
            private int status;
            private final /* synthetic */ Iterator $outer;

            public boolean hasNext() {
                while (true) {
                    switch (this.status) {
                        case 3: {
                            return false;
                        }
                        case 2: {
                            return true;
                        }
                        case 1: {
                            if (this.$outer.hasNext()) {
                                this.status = 2;
                                return true;
                            }
                            this.status = 3;
                            return false;
                        }
                        case 0: {
                            return true;
                        }
                    }
                    if (this.myLeading.finish()) {
                        this.status = 0;
                        return true;
                    }
                    this.status = 1;
                    this.myLeading = null;
                }
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                if (this.hasNext()) {
                    if (this.status == 0) {
                        void var1_1;
                        this.status = 1;
                        A res = this.myLeading.trailer();
                        this.myLeading = null;
                        return var1_1;
                    }
                    this.status = 1;
                    return this.$outer.next();
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.myLeading = leading$1;
                this.status = -1;
            }
        };
        return new Tuple2<Iterator<A>, Iterator<A>>(leading, trailing);
    }

    default public Iterator<A> dropWhile(Function1<A, Object> p) {
        return new AbstractIterator<A>(this, p){
            private int status;
            private A fst;
            private final /* synthetic */ Iterator $outer;
            private final Function1 p$6;

            public boolean hasNext() {
                if (this.status == 1) {
                    return this.$outer.hasNext();
                }
                if (this.status == 0) {
                    return true;
                }
                while (this.$outer.hasNext()) {
                    A a = this.$outer.next();
                    if (BoxesRunTime.unboxToBoolean(this.p$6.apply(a))) continue;
                    this.fst = a;
                    this.status = 0;
                    return true;
                }
                this.status = 1;
                return false;
            }

            public A next() {
                if (this.hasNext()) {
                    if (this.status == 1) {
                        return this.$outer.next();
                    }
                    this.status = 1;
                    return this.fst;
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.p$6 = p$6;
                this.status = -1;
            }
        };
    }

    default public <B> Iterator<Tuple2<A, B>> zip(Iterator<B> that) {
        return new AbstractIterator<Tuple2<A, B>>(this, that){
            private final /* synthetic */ Iterator $outer;
            private final Iterator that$1;

            public boolean hasNext() {
                return this.$outer.hasNext() && this.that$1.hasNext();
            }

            public Tuple2<A, B> next() {
                return new Tuple2<A, A>(this.$outer.next(), this.that$1.next());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.that$1 = that$1;
            }
        };
    }

    default public <A1> Iterator<A1> padTo(int len, A1 elem) {
        return new AbstractIterator<A1>(this, len, elem){
            private int count;
            private final /* synthetic */ Iterator $outer;
            private final int len$2;
            private final Object elem$4;

            private int count() {
                return this.count;
            }

            private void count_$eq(int x$1) {
                this.count = x$1;
            }

            public boolean hasNext() {
                return this.$outer.hasNext() || this.count() < this.len$2;
            }

            public A1 next() {
                this.count_$eq(this.count() + 1);
                if (this.$outer.hasNext()) {
                    return (A1)this.$outer.next();
                }
                if (this.count() <= this.len$2) {
                    return (A1)this.elem$4;
                }
                return (A1)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.len$2 = len$2;
                this.elem$4 = elem$4;
                this.count = 0;
            }
        };
    }

    default public Iterator<Tuple2<A, Object>> zipWithIndex() {
        return new AbstractIterator<Tuple2<A, Object>>(this){
            private int idx;
            private final /* synthetic */ Iterator $outer;

            private int idx() {
                return this.idx;
            }

            private void idx_$eq(int x$1) {
                this.idx = x$1;
            }

            public boolean hasNext() {
                return this.$outer.hasNext();
            }

            /*
             * WARNING - void declaration
             */
            public Tuple2<A, Object> next() {
                void var1_1;
                Tuple2<A, Integer> ret = new Tuple2<A, Integer>(this.$outer.next(), BoxesRunTime.boxToInteger(this.idx()));
                this.idx_$eq(this.idx() + 1);
                return var1_1;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.idx = 0;
            }
        };
    }

    default public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
        return new AbstractIterator<Tuple2<A1, B1>>(this, that, thatElem, thisElem){
            private final /* synthetic */ Iterator $outer;
            private final Iterator that$2;
            private final Object thatElem$1;
            private final Object thisElem$1;

            public boolean hasNext() {
                return this.$outer.hasNext() || this.that$2.hasNext();
            }

            public Tuple2<A1, B1> next() {
                if (this.$outer.hasNext()) {
                    if (this.that$2.hasNext()) {
                        return new Tuple2<A, A>(this.$outer.next(), this.that$2.next());
                    }
                    return new Tuple2<A, Object>(this.$outer.next(), this.thatElem$1);
                }
                if (this.that$2.hasNext()) {
                    return new Tuple2<Object, A>(this.thisElem$1, this.that$2.next());
                }
                return (Tuple2)((Object)Iterator$.MODULE$.empty().next());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.that$2 = that$2;
                this.thatElem$1 = thatElem$1;
                this.thisElem$1 = thisElem$1;
            }
        };
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        while (this.hasNext()) {
            f.apply(this.next());
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public boolean forall(Function1<A, Object> p) {
        void var2_2;
        boolean res = true;
        while (res && this.hasNext()) {
            res = BoxesRunTime.unboxToBoolean(p.apply(this.next()));
        }
        return (boolean)var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public boolean exists(Function1<A, Object> p) {
        void var2_2;
        boolean res = false;
        while (!res && this.hasNext()) {
            res = BoxesRunTime.unboxToBoolean(p.apply(this.next()));
        }
        return (boolean)var2_2;
    }

    default public boolean contains(Object elem) {
        return this.exists((Function1<Object, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(Iterator.$anonfun$contains$1(elem, x$3)));
    }

    @Override
    default public Option<A> find(Function1<A, Object> p) {
        while (this.hasNext()) {
            A a = this.next();
            if (!BoxesRunTime.unboxToBoolean(p.apply(a))) continue;
            return new Some<A>(a);
        }
        return None$.MODULE$;
    }

    default public int indexWhere(Function1<A, Object> p) {
        return this.indexWhere(p, 0);
    }

    default public int indexWhere(Function1<A, Object> p, int from) {
        int i;
        for (i = 0; i < from && this.hasNext(); ++i) {
            this.next();
        }
        while (this.hasNext()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(this.next()))) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    default public <B> int indexOf(B elem) {
        return this.indexOf(elem, 0);
    }

    default public <B> int indexOf(B elem, int from) {
        int i;
        for (i = 0; i < from && this.hasNext(); ++i) {
            this.next();
        }
        while (this.hasNext()) {
            if (BoxesRunTime.equals(this.next(), elem)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    default public BufferedIterator<A> buffered() {
        return new BufferedIterator<A>(this){
            private A hd;
            private boolean hdDefined;
            private final /* synthetic */ Iterator $outer;

            public Option<A> headOption() {
                return BufferedIterator.headOption$(this);
            }

            public BufferedIterator<A> buffered() {
                return BufferedIterator.buffered$(this);
            }

            private A hd() {
                return this.hd;
            }

            private void hd_$eq(A x$1) {
                this.hd = x$1;
            }

            private boolean hdDefined() {
                return this.hdDefined;
            }

            private void hdDefined_$eq(boolean x$1) {
                this.hdDefined = x$1;
            }

            public A head() {
                if (!this.hdDefined()) {
                    this.hd_$eq(this.next());
                    this.hdDefined_$eq(true);
                }
                return this.hd();
            }

            public boolean hasNext() {
                return this.hdDefined() || this.$outer.hasNext();
            }

            public A next() {
                if (this.hdDefined()) {
                    this.hdDefined_$eq(false);
                    return this.hd();
                }
                return this.$outer.next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                BufferedIterator.$init$(this);
                this.hdDefined = false;
            }
        };
    }

    default public <B> GroupedIterator<B> grouped(int size) {
        return new GroupedIterator(this, this, size, size);
    }

    default public <B> GroupedIterator<B> sliding(int size, int step) {
        return new GroupedIterator(this, this, size, step);
    }

    default public <B> int sliding$default$2() {
        return 1;
    }

    default public int length() {
        return this.size();
    }

    default public Tuple2<Iterator<A>, Iterator<A>> duplicate() {
        Queue gap = new Queue();
        ObjectRef<Object> ahead = ObjectRef.create(null);
        public class Scala_collection_Iterator$Partner$1
        extends AbstractIterator<A> {
            private final /* synthetic */ Iterator $outer;
            private final ObjectRef ahead$1;
            private final Queue gap$1;

            public boolean hasNext() {
                Iterator iterator2 = this.$outer;
                synchronized (iterator2) {
                    boolean bl = this != (Iterator)this.ahead$1.elem && !this.gap$1.isEmpty() || this.$outer.hasNext();
                    return bl;
                }
            }

            /*
             * WARNING - void declaration
             */
            public A next() {
                Iterator iterator2 = this.$outer;
                synchronized (iterator2) {
                    A a;
                    if (this.gap$1.isEmpty()) {
                        this.ahead$1.elem = this;
                    }
                    if (this == (Iterator)this.ahead$1.elem) {
                        void var3_2;
                        A e = this.$outer.next();
                        this.gap$1.enqueue(Predef$.MODULE$.genericWrapArray(new Object[]{e}));
                        a = var3_2;
                    } else {
                        a = this.gap$1.dequeue();
                    }
                    A a2 = a;
                    return a2;
                }
            }

            private boolean compareGap(Queue<A> queue) {
                return this.gap$1 == queue;
            }

            public int hashCode() {
                return this.gap$1.hashCode();
            }

            public boolean equals(Object other) {
                boolean bl = other instanceof Scala_collection_Iterator$Partner$1 ? ((Scala_collection_Iterator$Partner$1)other).compareGap(this.gap$1) && this.gap$1.isEmpty() : super.equals(other);
                return bl;
            }

            public Scala_collection_Iterator$Partner$1(Iterator $outer, ObjectRef ahead$1, Queue gap$1) {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.ahead$1 = ahead$1;
                this.gap$1 = gap$1;
            }
        }
        return new Tuple2<Iterator<A>, Iterator<A>>(new Scala_collection_Iterator$Partner$1(this, ahead, gap), new Scala_collection_Iterator$Partner$1(this, ahead, gap));
    }

    default public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
        return new AbstractIterator<B>(this, from, replaced, patchElems){
            private Iterator<A> origElems;
            private int i;
            private final int replaced$1;
            private final Iterator patchElems$1;

            private Iterator<A> origElems() {
                return this.origElems;
            }

            private void origElems_$eq(Iterator<A> x$1) {
                this.origElems = x$1;
            }

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                if (this.i() == 0) {
                    this.origElems_$eq(this.origElems().drop(this.replaced$1));
                    this.i_$eq(-1);
                }
                return this.origElems().hasNext() || this.patchElems$1.hasNext();
            }

            public B next() {
                if (this.i() == 0) {
                    this.origElems_$eq(this.origElems().drop(this.replaced$1));
                    this.i_$eq(-1);
                }
                if (this.i() < 0) {
                    if (this.patchElems$1.hasNext()) {
                        return (B)this.patchElems$1.next();
                    }
                    return (B)this.origElems().next();
                }
                if (this.origElems().hasNext()) {
                    this.i_$eq(this.i() - 1);
                    return (B)this.origElems().next();
                }
                this.i_$eq(-1);
                return (B)this.patchElems$1.next();
            }
            {
                this.replaced$1 = replaced$1;
                this.patchElems$1 = patchElems$1;
                this.origElems = $outer;
                this.i = from$1 > 0 ? from$1 : 0;
            }
        };
    }

    @Override
    default public <B> void copyToArray(Object xs, int start, int len) {
        int end = start + package$.MODULE$.min(len, ScalaRunTime$.MODULE$.array_length(xs) - start);
        for (int i = start; i < end && this.hasNext(); ++i) {
            ScalaRunTime$.MODULE$.array_update(xs, i, this.next());
        }
    }

    default public boolean sameElements(Iterator<?> that) {
        while (this.hasNext() && that.hasNext()) {
            if (BoxesRunTime.equals(this.next(), that.next())) continue;
            return false;
        }
        return !this.hasNext() && !that.hasNext();
    }

    @Override
    default public Traversable<A> toTraversable() {
        return this.toStream();
    }

    @Override
    default public Iterator<A> toIterator() {
        return this;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public Stream<A> toStream() {
        if (this.hasNext()) {
            void apply_tl;
            void apply_hd;
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> this.toStream();
            A a = this.next();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Stream.Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
        }
        return Stream$.MODULE$.empty();
    }

    default public String toString() {
        return "<iterator>";
    }

    public static /* synthetic */ boolean $anonfun$filterNot$1(Function1 p$2, Object x$1) {
        return !BoxesRunTime.unboxToBoolean(p$2.apply(x$1));
    }

    public static /* synthetic */ boolean $anonfun$partition$1(Function1 p$4, Object x$2) {
        return !BoxesRunTime.unboxToBoolean(p$4.apply(x$2));
    }

    public static /* synthetic */ boolean $anonfun$contains$1(Object elem$5, Object x$3) {
        return BoxesRunTime.equals(x$3, elem$5);
    }

    public static void $init$(Iterator $this) {
    }

    public static final class ConcatIterator<A>
    implements Iterator<A> {
        private Iterator<A> current;
        private ConcatIteratorCell<A> tail;
        private ConcatIteratorCell<A> last;
        private boolean currentHasNextChecked;

        @Override
        public Iterator<A> seq() {
            return ((Iterator)this).seq();
        }

        @Override
        public boolean isEmpty() {
            return ((Iterator)this).isEmpty();
        }

        @Override
        public boolean isTraversableAgain() {
            return ((Iterator)this).isTraversableAgain();
        }

        @Override
        public boolean hasDefiniteSize() {
            return ((Iterator)this).hasDefiniteSize();
        }

        @Override
        public Iterator<A> take(int n) {
            return ((Iterator)this).take(n);
        }

        @Override
        public Iterator<A> drop(int n) {
            return ((Iterator)this).drop(n);
        }

        @Override
        public Iterator<A> slice(int from, int until) {
            return ((Iterator)this).slice(from, until);
        }

        @Override
        public Iterator<A> sliceIterator(int from, int until) {
            return ((Iterator)this).sliceIterator(from, until);
        }

        @Override
        public <B> Iterator<B> map(Function1<A, B> f) {
            return ((Iterator)this).map(f);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<A, GenTraversableOnce<B>> f) {
            return ((Iterator)this).flatMap(f);
        }

        @Override
        public Iterator<A> filter(Function1<A, Object> p) {
            return ((Iterator)this).filter(p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<A, B, Object> p) {
            return ((Iterator)this).corresponds(that, p);
        }

        @Override
        public Iterator<A> withFilter(Function1<A, Object> p) {
            return ((Iterator)this).withFilter(p);
        }

        @Override
        public Iterator<A> filterNot(Function1<A, Object> p) {
            return ((Iterator)this).filterNot(p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<A, B> pf) {
            return ((Iterator)this).collect(pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, A, B> op) {
            return ((Iterator)this).scanLeft(z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<A, B, B> op) {
            return ((Iterator)this).scanRight(z, op);
        }

        @Override
        public Iterator<A> takeWhile(Function1<A, Object> p) {
            return ((Iterator)this).takeWhile(p);
        }

        @Override
        public Tuple2<Iterator<A>, Iterator<A>> partition(Function1<A, Object> p) {
            return ((Iterator)this).partition(p);
        }

        @Override
        public Tuple2<Iterator<A>, Iterator<A>> span(Function1<A, Object> p) {
            return ((Iterator)this).span(p);
        }

        @Override
        public Iterator<A> dropWhile(Function1<A, Object> p) {
            return ((Iterator)this).dropWhile(p);
        }

        @Override
        public <B> Iterator<Tuple2<A, B>> zip(Iterator<B> that) {
            return ((Iterator)this).zip((Iterator)that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return ((Iterator)this).padTo(len, elem);
        }

        @Override
        public Iterator<Tuple2<A, Object>> zipWithIndex() {
            return ((Iterator)this).zipWithIndex();
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return ((Iterator)this).zipAll((Iterator)that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            ((Iterator)this).foreach(f);
        }

        @Override
        public boolean forall(Function1<A, Object> p) {
            return ((Iterator)this).forall(p);
        }

        @Override
        public boolean exists(Function1<A, Object> p) {
            return ((Iterator)this).exists(p);
        }

        @Override
        public boolean contains(Object elem) {
            return ((Iterator)this).contains(elem);
        }

        @Override
        public Option<A> find(Function1<A, Object> p) {
            return ((Iterator)this).find(p);
        }

        @Override
        public int indexWhere(Function1<A, Object> p) {
            return ((Iterator)this).indexWhere(p);
        }

        @Override
        public int indexWhere(Function1<A, Object> p, int from) {
            return ((Iterator)this).indexWhere(p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return ((Iterator)this).indexOf(elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return ((Iterator)this).indexOf(elem, from);
        }

        @Override
        public BufferedIterator<A> buffered() {
            return ((Iterator)this).buffered();
        }

        @Override
        public <B> GroupedIterator<B> grouped(int size) {
            return ((Iterator)this).grouped(size);
        }

        @Override
        public <B> GroupedIterator<B> sliding(int size, int step) {
            return ((Iterator)this).sliding(size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return ((Iterator)this).sliding$default$2();
        }

        @Override
        public int length() {
            return ((Iterator)this).length();
        }

        @Override
        public Tuple2<Iterator<A>, Iterator<A>> duplicate() {
            return ((Iterator)this).duplicate();
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return ((Iterator)this).patch(from, (Iterator)patchElems, replaced);
        }

        @Override
        public <B> void copyToArray(Object xs, int start, int len) {
            ((Iterator)this).copyToArray(xs, start, len);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return ((Iterator)this).sameElements((Iterator)that);
        }

        @Override
        public Traversable<A> toTraversable() {
            return ((Iterator)this).toTraversable();
        }

        @Override
        public Iterator<A> toIterator() {
            return ((Iterator)this).toIterator();
        }

        @Override
        public Stream<A> toStream() {
            return ((Iterator)this).toStream();
        }

        @Override
        public String toString() {
            return ((Iterator)this).toString();
        }

        @Override
        public List<A> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public int size() {
            return TraversableOnce.size$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<A, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, A, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, A, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<A, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, A, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<A, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
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
        public <B> A min(Ordering<B> cmp) {
            return (A)TraversableOnce.min$(this, cmp);
        }

        @Override
        public <B> A max(Ordering<B> cmp) {
            return (A)TraversableOnce.max$(this, cmp);
        }

        @Override
        public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
            return (A)TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
            return (A)TraversableOnce.minBy$(this, f, cmp);
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
        public List<A> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Iterable<A> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<A> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<A> toIndexedSeq() {
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
        public Vector<A> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
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

        private Iterator<A> current() {
            return this.current;
        }

        private void current_$eq(Iterator<A> x$1) {
            this.current = x$1;
        }

        private ConcatIteratorCell<A> tail() {
            return this.tail;
        }

        private void tail_$eq(ConcatIteratorCell<A> x$1) {
            this.tail = x$1;
        }

        private ConcatIteratorCell<A> last() {
            return this.last;
        }

        private void last_$eq(ConcatIteratorCell<A> x$1) {
            this.last = x$1;
        }

        private boolean currentHasNextChecked() {
            return this.currentHasNextChecked;
        }

        private void currentHasNextChecked_$eq(boolean x$1) {
            this.currentHasNextChecked = x$1;
        }

        private boolean advance() {
            do {
                if (this.tail() == null) {
                    this.current_$eq(null);
                    this.last_$eq(null);
                    return false;
                }
                this.current_$eq(this.tail().headIterator());
                if (this.last() == this.tail()) {
                    this.last_$eq(this.last().tail());
                }
                this.tail_$eq(this.tail().tail());
                this.merge();
                if (!this.currentHasNextChecked()) continue;
                return true;
            } while (this.current() == null || !this.current().hasNext());
            this.currentHasNextChecked_$eq(true);
            return true;
        }

        private void merge() {
            while (this.current() instanceof ConcatIterator) {
                ConcatIterator c = (ConcatIterator)this.current();
                this.current_$eq(c.current());
                this.currentHasNextChecked_$eq(c.currentHasNextChecked());
                if (c.tail() == null) continue;
                if (this.last() == null) {
                    this.last_$eq(c.last());
                }
                c.last().tail_$eq(this.tail());
                this.tail_$eq(c.tail());
            }
        }

        @Override
        public boolean hasNext() {
            if (this.currentHasNextChecked()) {
                return true;
            }
            if (this.current() == null) {
                return false;
            }
            if (this.current().hasNext()) {
                this.currentHasNextChecked_$eq(true);
                return true;
            }
            return this.advance();
        }

        @Override
        public A next() {
            if (this.hasNext()) {
                this.currentHasNextChecked_$eq(false);
                return this.current().next();
            }
            return (A)Iterator$.MODULE$.empty().next();
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            ConcatIteratorCell c = new ConcatIteratorCell(that, null);
            if (this.tail() == null) {
                this.tail_$eq(c);
                this.last_$eq(c);
            } else {
                this.last().tail_$eq(c);
                this.last_$eq(c);
            }
            if (this.current() == null) {
                this.current_$eq(Iterator$.MODULE$.empty());
            }
            return this;
        }

        public ConcatIterator(Iterator<A> current) {
            this.current = current;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            this.tail = null;
            this.last = null;
            this.currentHasNextChecked = false;
        }
    }

    public static final class ConcatIteratorCell<A> {
        private final Function0<GenTraversableOnce<A>> head;
        private ConcatIteratorCell<A> tail;

        public ConcatIteratorCell<A> tail() {
            return this.tail;
        }

        public void tail_$eq(ConcatIteratorCell<A> x$1) {
            this.tail = x$1;
        }

        public Iterator<A> headIterator() {
            return this.head.apply().toIterator();
        }

        public ConcatIteratorCell(Function0<GenTraversableOnce<A>> head, ConcatIteratorCell<A> tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public class GroupedIterator<B>
    extends AbstractIterator<Seq<B>> {
        private final Iterator<A> self;
        private final int size;
        private final int step;
        private ArrayBuffer<B> buffer;
        private boolean filled;
        private boolean _partial;
        private Option<Function0<B>> pad;
        public final /* synthetic */ Iterator $outer;

        public GroupedIterator<B> withPadding(Function0<B> x) {
            this.pad = new Some<Function0<B>>(x);
            return this;
        }

        public GroupedIterator<B> withPartial(boolean x) {
            this._partial = x;
            if (this._partial) {
                this.pad = None$.MODULE$;
            }
            return this;
        }

        /*
         * WARNING - void declaration
         */
        private Seq<A> takeDestructively(int size) {
            void var2_2;
            ArrayBuffer buf = new ArrayBuffer();
            for (int i = 0; i < size && this.self.hasNext(); ++i) {
                buf.$plus$eq(this.self.next());
            }
            return var2_2;
        }

        private List<B> padding(int x) {
            List$ list$ = List$.MODULE$;
            if (list$ == null) {
                throw null;
            }
            Builder fill_b = ((GenericCompanion)list$).newBuilder();
            fill_b.sizeHint(x);
            for (int fill_i = 0; fill_i < x; ++fill_i) {
                fill_b.$plus$eq(GroupedIterator.$anonfun$padding$1(this));
            }
            return (List)((GenTraversable)fill_b.result());
        }

        private int gap() {
            int n = this.step - this.size;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.max$extension(n, 0);
        }

        private boolean go(int count) {
            Seq xs;
            LazyInt len$lzy = new LazyInt();
            LazyBoolean incomplete$lzy = new LazyBoolean();
            int prevSize = this.buffer.size();
            Seq res = this.takeDestructively(count);
            int shortBy = count - res.length();
            Seq seq = xs = shortBy > 0 && this.pad.isDefined() ? res.$plus$plus(this.padding(shortBy), Seq$.MODULE$.canBuildFrom()) : res;
            if (xs.isEmpty()) {
                return false;
            }
            if (this._partial) {
                int n = GroupedIterator.len$3(len$lzy, xs);
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return this.deliver$1(RichInt$.MODULE$.min$extension(n, this.size), prevSize, xs, len$lzy);
            }
            if (GroupedIterator.incomplete$1(incomplete$lzy, count, len$lzy, xs)) {
                return false;
            }
            if (GroupedIterator.isFirst$1(prevSize)) {
                return this.deliver$1(GroupedIterator.len$3(len$lzy, xs), prevSize, xs, len$lzy);
            }
            int n = this.step;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return this.deliver$1(RichInt$.MODULE$.min$extension(n, this.size), prevSize, xs, len$lzy);
        }

        private boolean fill() {
            if (!this.self.hasNext()) {
                return false;
            }
            if (this.buffer.isEmpty()) {
                return this.go(this.size);
            }
            return this.go(this.step);
        }

        @Override
        public boolean hasNext() {
            return this.filled || this.fill();
        }

        @Override
        public List<B> next() {
            if (!this.filled) {
                this.fill();
            }
            if (!this.filled) {
                throw new NoSuchElementException("next on empty iterator");
            }
            this.filled = false;
            return this.buffer.toList();
        }

        public /* synthetic */ Iterator scala$collection$Iterator$GroupedIterator$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$new$1(GroupedIterator $this) {
            int arg$macro$1 = $this.size;
            int arg$macro$2 = $this.step;
            return new StringOps("size=%d and step=%d, but both must be positive").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(arg$macro$1), BoxesRunTime.boxToInteger(arg$macro$2)}));
        }

        public static final /* synthetic */ Object $anonfun$padding$1(GroupedIterator $this) {
            return $this.pad.get().apply();
        }

        private static final boolean isFirst$1(int prevSize$1) {
            return prevSize$1 == 0;
        }

        private static final /* synthetic */ int len$lzycompute$1(LazyInt len$lzy$1, Seq xs$1) {
            synchronized (len$lzy$1) {
                int n = len$lzy$1.initialized() ? len$lzy$1.value() : len$lzy$1.initialize(xs$1.length());
                return n;
            }
        }

        private static final int len$3(LazyInt len$lzy$1, Seq xs$1) {
            if (len$lzy$1.initialized()) {
                return len$lzy$1.value();
            }
            return GroupedIterator.len$lzycompute$1(len$lzy$1, xs$1);
        }

        private static final /* synthetic */ boolean incomplete$lzycompute$1(LazyBoolean incomplete$lzy$1, int count$1, LazyInt len$lzy$1, Seq xs$1) {
            synchronized (incomplete$lzy$1) {
                boolean bl = incomplete$lzy$1.initialized() ? incomplete$lzy$1.value() : incomplete$lzy$1.initialize(GroupedIterator.len$3(len$lzy$1, xs$1) < count$1);
                return bl;
            }
        }

        private static final boolean incomplete$1(LazyBoolean incomplete$lzy$1, int count$1, LazyInt len$lzy$1, Seq xs$1) {
            if (incomplete$lzy$1.initialized()) {
                return incomplete$lzy$1.value();
            }
            return GroupedIterator.incomplete$lzycompute$1(incomplete$lzy$1, count$1, len$lzy$1, xs$1);
        }

        private final boolean deliver$1(int howMany, int prevSize$1, Seq xs$1, LazyInt len$lzy$1) {
            if (howMany > 0 && (GroupedIterator.isFirst$1(prevSize$1) || GroupedIterator.len$3(len$lzy$1, xs$1) > this.gap())) {
                int n;
                if (!GroupedIterator.isFirst$1(prevSize$1)) {
                    int n2 = this.step;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    this.buffer.trimStart(RichInt$.MODULE$.min$extension(n2, prevSize$1));
                }
                if (GroupedIterator.isFirst$1(prevSize$1)) {
                    n = GroupedIterator.len$3(len$lzy$1, xs$1);
                } else {
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    n = RichInt$.MODULE$.min$extension(howMany, GroupedIterator.len$3(len$lzy$1, xs$1) - this.gap());
                }
                int available = n;
                this.buffer.$plus$plus$eq((TraversableOnce)xs$1.takeRight(available));
                this.filled = true;
                return true;
            }
            return false;
        }

        /*
         * WARNING - void declaration
         */
        public GroupedIterator(Iterator $outer, Iterator<A> self, int size, int step) {
            void require_requirement;
            boolean bl;
            this.self = self;
            this.size = size;
            this.step = step;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            boolean bl2 = bl = size >= 1 && step >= 1;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (require_requirement == false) {
                throw new IllegalArgumentException(new java.lang.StringBuilder(20).append("requirement failed: ").append((Object)GroupedIterator.$anonfun$new$1(this)).toString());
            }
            this.buffer = (ArrayBuffer)ArrayBuffer$.MODULE$.apply(Nil$.MODULE$);
            this.filled = false;
            this._partial = true;
            this.pad = None$.MODULE$;
        }
    }

    public static final class SliceIterator<A>
    extends AbstractIterator<A> {
        private final Iterator<A> underlying;
        private int scala$collection$Iterator$SliceIterator$$remaining;
        private int dropping;

        public Iterator<A> underlying() {
            return this.underlying;
        }

        public int scala$collection$Iterator$SliceIterator$$remaining() {
            return this.scala$collection$Iterator$SliceIterator$$remaining;
        }

        private void scala$collection$Iterator$SliceIterator$$remaining_$eq(int x$1) {
            this.scala$collection$Iterator$SliceIterator$$remaining = x$1;
        }

        private int dropping() {
            return this.dropping;
        }

        private void dropping_$eq(int x$1) {
            this.dropping = x$1;
        }

        private boolean unbounded() {
            return this.scala$collection$Iterator$SliceIterator$$remaining() < 0;
        }

        private void skip() {
            while (this.dropping() > 0) {
                if (this.underlying().hasNext()) {
                    this.underlying().next();
                    this.dropping_$eq(this.dropping() - 1);
                    continue;
                }
                this.dropping_$eq(0);
            }
        }

        @Override
        public boolean hasNext() {
            this.skip();
            return this.scala$collection$Iterator$SliceIterator$$remaining() != 0 && this.underlying().hasNext();
        }

        @Override
        public A next() {
            this.skip();
            if (this.scala$collection$Iterator$SliceIterator$$remaining() > 0) {
                this.scala$collection$Iterator$SliceIterator$$remaining_$eq(this.scala$collection$Iterator$SliceIterator$$remaining() - 1);
                return this.underlying().next();
            }
            if (this.scala$collection$Iterator$SliceIterator$$remaining() < 0) {
                return this.underlying().next();
            }
            return (A)Iterator$.MODULE$.empty().next();
        }

        @Override
        public Iterator<A> sliceIterator(int from, int until) {
            int rest;
            int n;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int lo = RichInt$.MODULE$.max$extension(from, 0);
            if (until < 0) {
                n = this.adjustedBound$1(lo);
            } else if (until <= lo) {
                n = 0;
            } else if (this.scala$collection$Iterator$SliceIterator$$remaining() < 0) {
                n = until - lo;
            } else {
                int n2 = this.adjustedBound$1(lo);
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                n = rest = RichInt$.MODULE$.min$extension(n2, until - lo);
            }
            if (rest == 0) {
                return Iterator$.MODULE$.empty();
            }
            this.dropping_$eq(this.dropping() + lo);
            this.scala$collection$Iterator$SliceIterator$$remaining_$eq(rest);
            return this;
        }

        private final int adjustedBound$1(int lo$1) {
            if (this.scala$collection$Iterator$SliceIterator$$remaining() < 0) {
                return -1;
            }
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.max$extension(n, this.scala$collection$Iterator$SliceIterator$$remaining() - lo$1);
        }

        public SliceIterator(Iterator<A> underlying, int start, int limit) {
            this.underlying = underlying;
            this.scala$collection$Iterator$SliceIterator$$remaining = limit;
            this.dropping = start;
        }
    }
}

