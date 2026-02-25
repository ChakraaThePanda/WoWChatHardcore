/*
 * Decompiled with CFR 0.152.
 */
package scala.util.matching;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.MapLike;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcII$sp;
import scala.util.matching.Regex$;
import scala.util.matching.UnanchoredRegex;

@ScalaSignature(bytes="\u0006\u0001\r\u0005e\u0001\u00027n\u0001QD\u0001\u0002 \u0001\u0003\u0006\u0004%\t! \u0005\n\u0003\u001f\u0001!\u0011!Q\u0001\nyD!\"!\u0005\u0001\u0005\u0003\u0005\u000b\u0011BA\n\u0011!\ty\u0003\u0001C\u0001[\u0006E\u0002bBA\u0018\u0001\u0011\u0005\u00111\b\u0005\b\u0003\u0003\u0002A\u0011AA\"\u0011\u001d\t\t\u0005\u0001C\u0001\u0003[Bq!!\u0011\u0001\t\u0003\ti\bC\u0004\u0002B\u0001!\tAa:\t\u000f\r\r\u0001\u0001\"\u0005\u0004\u0006!91\u0011\u0002\u0001\u0005\u0002\r-\u0001bBB\t\u0001\u0011\u000511\u0003\u0005\b\u00073\u0001A\u0011AB\u000e\u0011\u001d\u0019\t\u0003\u0001C\u0001\u0007GAqa!\u000b\u0001\t\u0003\u0019Y\u0003C\u0004\u00040\u0001!\ta!\r\t\u000f\rU\u0002\u0001\"\u0001\u00048!91Q\u0007\u0001\u0005\u0002\r}\u0002bBB'\u0001\u0011\u00051q\n\u0005\b\u0007/\u0002A\u0011AB-\u0011\u001d\u0019y\u0006\u0001C\u0001\u0007CBqa!\u001b\u0001\t\u0003\u0019Y\u0007C\u0004\u0004t\u0001!\tA!\u001e\t\u000f\u0005\r\u0001\u0001\"\u0001\u0002N\"9\u0011Q\u001f\u0001\u0005B\u0005]xaBAD[\"\u0005\u0011\u0011\u0012\u0004\u0007Y6D\t!a#\t\u000f\u0005=2\u0004\"\u0001\u0002\u000e\u001aI\u0011qR\u000e\u0011\u0002\u0007\u0005\u0011\u0011\u0013\u0005\b\u0003'kB\u0011AAK\u0011\u001d\ti*\bD\t\u0003?C\u0011\"a*\u001e\u0005\u00045\t!!+\t\u0013\u0005EQD1A\u0007\u0002\u0005-\u0006bBAZ;\u0019\u0005\u0011Q\u0017\u0005\b\u0003{kb\u0011AA[\u0011\u001d\ti,\bD\u0001\u0003\u007fCq!!2\u001e\r\u0003\t)\fC\u0004\u0002Fv1\t!a2\t\u000f\u0005-W\u0004\"\u0001\u0002N\"9\u0011qZ\u000f\u0005\u0002\u0005E\u0007bBAk;\u0011\u0005\u0011q\u001b\u0005\b\u00033lB\u0011AAU\u0011\u001d\tI.\bC\u0001\u00037Dq!a8\u001e\t\u0003\tI\u000bC\u0004\u0002`v!\t!!9\t\u0015\u0005\u0015X\u0004#b\u0001\n\u0013\t9\u000fC\u0004\u0002Pv!\t!a<\t\u000f\u0005UX\u0004\"\u0011\u0002x\u001a1\u0011\u0011`\u000e\u0001\u0003wD!\"a*2\u0005\u000b\u0007I\u0011AAU\u0011)\u0011\t!\rB\u0001B\u0003%\u0011\u0011\r\u0005\f\u0003;\u000b$Q1A\u0005\u00125\fy\n\u0003\u0006\u0003\u0004E\u0012\t\u0011)A\u0005\u0003CC!\"!\u00052\u0005\u000b\u0007I\u0011AAV\u0011)\u0011)!\rB\u0001B\u0003%\u0011Q\u0016\u0005\b\u0003_\tD\u0011\u0001B\u0004\u0011%\ti,\rb\u0001\n\u0003\t)\f\u0003\u0005\u0003\u0012E\u0002\u000b\u0011BA\\\u0011%\t)-\rb\u0001\n\u0003\t)\f\u0003\u0005\u0003\u0014E\u0002\u000b\u0011BA\\\u0011\u001d\t\u0019,\rC\u0001\u0003kC!B!\u00062\u0011\u000b\u0007I\u0011\u0002B\f\u0011)\u0011y\"\rEC\u0002\u0013%!q\u0003\u0005\b\u0003{\u000bD\u0011\u0001B\u0011\u0011\u001d\t)-\rC\u0001\u0005KAqA!\u000b2\t\u0003\u0011YcB\u0004\u00030mA\tA!\r\u0007\u000f\u0005e8\u0004#\u0001\u00034!9\u0011q\u0006#\u0005\u0002\tU\u0002b\u0002B\u001c\t\u0012\u0005!\u0011H\u0004\b\u0005\u0007Z\u0002\u0012\u0001B#\r\u001d\u00119e\u0007E\u0001\u0005\u0013Bq!a\fI\t\u0003\u0011Y\u0005C\u0004\u0002B!#\tA!\u0014\t\u000f\tM3\u0004\"\u0003\u0003V!9!\u0011L\u000e\u0005\n\tmcA\u0002B07\u0001\u0011\t\u0007\u0003\u0006\u0002(6\u0013)\u0019!C\u0001\u0003SC!B!\u0001N\u0005\u0003\u0005\u000b\u0011BA1\u0011)\t\u0019!\u0014BC\u0002\u0013\u0005!Q\u000f\u0005\u000b\u0005oj%\u0011!Q\u0001\n\u0005M\u0002BCA\t\u001b\n\u0015\r\u0011\"\u0001\u0002,\"Q!QA'\u0003\u0002\u0003\u0006I!!,\t\u000f\u0005=R\n\"\u0001\u0003z!Q\u0011QT'C\u0002\u0013E1$a(\t\u0011\t\rQ\n)A\u0005\u0003CC\u0001Ba!NA\u0003&\u0011q\u0017\u0005\b\u0005\u000bkE\u0011\u0001BD\u0011\u001d\u0011y)\u0014C\u0001\u0003oDq!!>N\t\u0003\u0012\t\n\u0003\u0005\u0003\u00186\u0003K\u0011BAK\u0011\u001d\ti,\u0014C\u0001\u0003kCq!!0N\t\u0003\u0011I\nC\u0004\u0002F6#\t!!.\t\u000f\u0005\u0015W\n\"\u0001\u0003\u001e\"9\u00111W'\u0005\u0002\u0005U\u0006b\u0002BQ\u001b\u0012\u0005!1\u0015\u0005\t\u0005OkE\u0011A7\u0003*\u001aQ!QW\u000e\u0011\u0002\u0007\u0005QNa.\t\u000f\u0005M5\r\"\u0001\u0002\u0016\"9\u0011QT2\u0007\u0012\u0005}\u0005\"\u0003B]G\n\u0007I\u0011\u0002B^\u0011\u001d\u0011\u0019m\u0019C\u0001\u0005\u000bDqAa2d\t\u0003\u0011I\rC\u0004\u0003Pn!\tA!5\t\u000f\t]7\u0004\"\u0001\u0003Z\"I!Q\\\u000e\u0002\u0002\u0013%!q\u001c\u0002\u0006%\u0016<W\r\u001f\u0006\u0003]>\f\u0001\"\\1uG\"Lgn\u001a\u0006\u0003aF\fA!\u001e;jY*\t!/A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u0001)\u0018\u0010\u0005\u0002wo6\t\u0011/\u0003\u0002yc\n1\u0011I\\=SK\u001a\u0004\"A\u001e>\n\u0005m\f(\u0001D*fe&\fG.\u001b>bE2,\u0017a\u00029biR,'O\\\u000b\u0002}B\u0019q0a\u0003\u000e\u0005\u0005\u0005!\u0002BA\u0002\u0003\u000b\tQA]3hKbT1\u0001]A\u0004\u0015\t\tI!\u0001\u0003kCZ\f\u0017\u0002BA\u0007\u0003\u0003\u0011q\u0001U1ui\u0016\u0014h.\u0001\u0005qCR$XM\u001d8!\u0003)9'o\\;q\u001d\u0006lWm\u001d\t\u0006m\u0006U\u0011\u0011D\u0005\u0004\u0003/\t(A\u0003\u001fsKB,\u0017\r^3e}A!\u00111DA\u0015\u001d\u0011\ti\"!\n\u0011\u0007\u0005}\u0011/\u0004\u0002\u0002\")\u0019\u00111E:\u0002\rq\u0012xn\u001c;?\u0013\r\t9#]\u0001\u0007!J,G-\u001a4\n\t\u0005-\u0012Q\u0006\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005\u001d\u0012/\u0001\u0004=S:LGO\u0010\u000b\u0007\u0003g\t9$!\u000f\u0011\u0007\u0005U\u0002!D\u0001n\u0011\u0015aH\u00011\u0001\u007f\u0011\u001d\t\t\u0002\u0002a\u0001\u0003'!b!a\r\u0002>\u0005}\u0002bBA\u0002\u000b\u0001\u0007\u0011\u0011\u0004\u0005\b\u0003#)\u0001\u0019AA\n\u0003))h.\u00199qYf\u001cV-\u001d\u000b\u0005\u0003\u000b\ni\u0006E\u0003w\u0003\u000f\nY%C\u0002\u0002JE\u0014aa\u00149uS>t\u0007CBA'\u0003/\nIB\u0004\u0003\u0002P\u0005Mc\u0002BA\u0010\u0003#J\u0011A]\u0005\u0004\u0003+\n\u0018a\u00029bG.\fw-Z\u0005\u0005\u00033\nYF\u0001\u0003MSN$(bAA+c\"9\u0011q\f\u0004A\u0002\u0005\u0005\u0014!A:\u0011\t\u0005\r\u0014\u0011N\u0007\u0003\u0003KRA!a\u001a\u0002\b\u0005!A.\u00198h\u0013\u0011\tY'!\u001a\u0003\u0019\rC\u0017M]*fcV,gnY3\u0015\t\u0005=\u0014\u0011\u0010\t\u0006m\u0006\u001d\u0013\u0011\u000f\t\u0007\u0003\u001b\n9&a\u001d\u0011\u0007Y\f)(C\u0002\u0002xE\u0014Aa\u00115be\"9\u00111P\u0004A\u0002\u0005M\u0014!A2\u0015\t\u0005\u0015\u0013q\u0010\u0005\b\u0003\u0003C\u0001\u0019AAB\u0003\u0005i\u0007cAACc9\u0019\u0011Q\u0007\u000e\u0002\u000bI+w-\u001a=\u0011\u0007\u0005U2dE\u0002\u001ckf$\"!!#\u0003\u00135\u000bGo\u00195ECR\f7CA\u000fv\u0003\u0019!\u0013N\\5uIQ\u0011\u0011q\u0013\t\u0004m\u0006e\u0015bAANc\n!QK\\5u\u0003\u001di\u0017\r^2iKJ,\"!!)\u0011\u0007}\f\u0019+\u0003\u0003\u0002&\u0006\u0005!aB'bi\u000eDWM]\u0001\u0007g>,(oY3\u0016\u0005\u0005\u0005TCAAW!\u0019\ti%a,\u0002\u001a%!\u0011\u0011WA.\u0005\r\u0019V-]\u0001\u000bOJ|W\u000f]\"pk:$XCAA\\!\r1\u0018\u0011X\u0005\u0004\u0003w\u000b(aA%oi\u0006)1\u000f^1siR!\u0011qWAa\u0011\u001d\t\u0019\r\na\u0001\u0003o\u000b\u0011![\u0001\u0004K:$G\u0003BA\\\u0003\u0013Dq!a1'\u0001\u0004\t9,A\u0004nCR\u001c\u0007.\u001a3\u0016\u0005\u0005e\u0011!B4s_V\u0004H\u0003BA\r\u0003'Dq!a1)\u0001\u0004\t9,A\u0005tk\n<'o\\;qgV\u0011\u00111J\u0001\u0007E\u00164wN]3\u0015\t\u0005\u0005\u0014Q\u001c\u0005\b\u0003\u0007\\\u0003\u0019AA\\\u0003\u0015\tg\r^3s)\u0011\t\t'a9\t\u000f\u0005\rW\u00061\u0001\u00028\u0006Ya.Y7f)>Le\u000eZ3y+\t\tI\u000f\u0005\u0005\u0002\u001c\u0005-\u0018\u0011DA\\\u0013\u0011\ti/!\f\u0003\u00075\u000b\u0007\u000f\u0006\u0003\u0002\u001a\u0005E\bbBAz_\u0001\u0007\u0011\u0011D\u0001\u0003S\u0012\f\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u00033\u0011Q!T1uG\"\u001cB!M;\u0002~B\u0019\u0011q`\u000f\u000e\u0003m\tqa]8ve\u000e,\u0007%\u0001\u0005nCR\u001c\u0007.\u001a:!\u0003-9'o\\;q\u001d\u0006lWm\u001d\u0011\u0015\u0011\t%!1\u0002B\u0007\u0005\u001f\u00012!a@2\u0011\u001d\t9\u000b\u000fa\u0001\u0003CBq!!(9\u0001\u0004\t\t\u000bC\u0004\u0002\u0012a\u0002\r!!,\u0002\rM$\u0018M\u001d;!\u0003\u0011)g\u000e\u001a\u0011\u0002\rM$\u0018M\u001d;t+\t\u0011I\u0002E\u0003w\u00057\t9,C\u0002\u0003\u001eE\u0014Q!\u0011:sCf\fA!\u001a8egR!\u0011q\u0017B\u0012\u0011\u001d\t\u0019\r\u0011a\u0001\u0003o#B!a.\u0003(!9\u00111Y!A\u0002\u0005]\u0016!\u00024pe\u000e,WC\u0001B\u0017\u001b\u0005\t\u0014!B'bi\u000eD\u0007cAA\u0000\tN\u0011A)\u001e\u000b\u0003\u0005c\tq!\u001e8baBd\u0017\u0010\u0006\u0003\u0003<\t\u0005\u0003#\u0002<\u0003>\u0005e\u0011b\u0001B c\n!1k\\7f\u0011\u001d\t\tI\u0012a\u0001\u0005\u0013\taa\u0012:pkB\u001c\bcAA\u0000\u0011\n1qI]8vaN\u001c\"\u0001S;\u0015\u0005\t\u0015C\u0003\u0002B(\u0005#\u0002RA^A$\u0003[Cq!!!K\u0001\u0004\u0011I!\u0001\ffqR\u0014\u0018m\u0019;He>,\bo\u001d$s_6l\u0015\r^2i)\u0011\t)Ea\u0016\t\u000f\u0005\u00055\n1\u0001\u0003\n\u0005AR\r\u001f;sC\u000e$xI]8vaN4%o\\7NCR\u001c\u0007.\u001a:\u0015\t\u0005\u0015#Q\f\u0005\b\u0003\u0003c\u0005\u0019AAQ\u00055i\u0015\r^2i\u0013R,'/\u0019;peN9QJa\u0019\u0003p\u0005u\bC\u0002B3\u0005W\nI\"\u0004\u0002\u0003h)\u0019!\u0011N9\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0003\u0003n\t\u001d$\u0001E!cgR\u0014\u0018m\u0019;Ji\u0016\u0014\u0018\r^8s!\u0019\tiE!\u001d\u0002\u001a%!!1OA.\u0005!IE/\u001a:bi>\u0014XCAA\u001a\u0003\u0019\u0011XmZ3yAQA!1\u0010B?\u0005\u007f\u0012\t\tE\u0002\u0002\u00006Cq!a*U\u0001\u0004\t\t\u0007C\u0004\u0002\u0004Q\u0003\r!a\r\t\u000f\u0005EA\u000b1\u0001\u0002.\u0006Aa.\u001a=u'\u0016,g.A\u0004iCNtU\r\u001f;\u0016\u0005\t%\u0005c\u0001<\u0003\f&\u0019!QR9\u0003\u000f\t{w\u000e\\3b]\u0006!a.\u001a=u)\t\u0011\u0019\n\u0005\u0003\u0002d\tU\u0015\u0002BA\u0016\u0003K\na!\u001a8tkJ,G\u0003BA\\\u00057Cq!a1^\u0001\u0004\t9\f\u0006\u0003\u00028\n}\u0005bBAb?\u0002\u0007\u0011qW\u0001\n[\u0006$8\r\u001b#bi\u0006,\"A!*\u0011\r\u00055#\u0011\u000fB\u0005\u0003=\u0011X\r\u001d7bG\u0016lWM\u001c;ECR\fWC\u0001BV%\u0019\u0011iK!-\u00034\u001a1!q\u00162\u0001\u0005W\u0013A\u0002\u0010:fM&tW-\\3oiz\u0002bA!\u001a\u0003l\t%\u0001cAA\u0000G\nY!+\u001a9mC\u000e,W.\u001a8u'\t\u0019W/\u0001\u0002tEV\u0011!Q\u0018\t\u0005\u0003G\u0012y,\u0003\u0003\u0003B\u0006\u0015$\u0001D*ue&twMQ;gM\u0016\u0014\u0018\u0001\u0003:fa2\f7-\u001a3\u0016\u0005\tM\u0015a\u0002:fa2\f7-\u001a\u000b\u0005\u0003C\u0013Y\rC\u0004\u0003N\"\u0004\r!!\u0007\u0002\u0005I\u001c\u0018!B9v_R,G\u0003BA\r\u0005'DqA!6j\u0001\u0004\tI\"\u0001\u0003uKb$\u0018\u0001E9v_R,'+\u001a9mC\u000e,W.\u001a8u)\u0011\tIBa7\t\u000f\tU'\u000e1\u0001\u0002\u001a\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0011\t\u000f\u0005\u0003\u0002d\t\r\u0018\u0002\u0002Bs\u0003K\u0012aa\u00142kK\u000e$H\u0003BA#\u0005SDqAa;\n\u0001\u0004\u0011i/\u0001\u0004uCJ<W\r\u001e\t\u0004m\n=\u0018b\u0001Byc\n\u0019\u0011I\\=)\u000f%\u0011)Pa?\u0003\u0000B\u0019aOa>\n\u0007\te\u0018O\u0001\u0006eKB\u0014XmY1uK\u0012\f#A!@\u0002#\u0016DHO]1di&tw\rI1![\u0006$8\r\u001b\u0011sKN,H\u000e\u001e\u0011ge>l\u0007%\u00198zi\"Lgn\u001a\u0011ckR\u0004\u0013\rI\"iCJ\u001cV-];f]\u000e,\u0007e\u001c:!\u001b\u0006$8\r\u001b\u0011jg\u0002\"W\r\u001d:fG\u0006$X\rZ\u0011\u0003\u0007\u0003\taA\r\u00182c9\u0002\u0014A\u0003:v]6\u000bGo\u00195feR!!\u0011RB\u0004\u0011\u001d\t\tI\u0003a\u0001\u0003C\u000b\u0011BZ5oI\u0006cG.\u00138\u0015\t\r51q\u0002\t\u0004\u0003\u000bk\u0005bBAT\u0017\u0001\u0007\u0011\u0011M\u0001\u000fM&tG-\u00117m\u001b\u0006$8\r[%o)\u0011\u0019)ba\u0006\u0011\r\u00055#\u0011OAB\u0011\u001d\t9\u000b\u0004a\u0001\u0003C\n1BZ5oI\u001aK'o\u001d;J]R!1QDB\u0010!\u00151\u0018qIA\r\u0011\u001d\t9+\u0004a\u0001\u0003C\n\u0001CZ5oI\u001aK'o\u001d;NCR\u001c\u0007.\u00138\u0015\t\r\u00152q\u0005\t\u0006m\u0006\u001d\u00131\u0011\u0005\b\u0003Os\u0001\u0019AA1\u000311\u0017N\u001c3Qe\u00164\u0017\u000e_(g)\u0011\u0019ib!\f\t\u000f\u0005\u001dv\u00021\u0001\u0002b\u0005\tb-\u001b8e!J,g-\u001b=NCR\u001c\u0007n\u00144\u0015\t\r\u001521\u0007\u0005\b\u0003O\u0003\u0002\u0019AA1\u00031\u0011X\r\u001d7bG\u0016\fE\u000e\\%o)\u0019\tIb!\u000f\u0004<!9!1^\tA\u0002\u0005\u0005\u0004bBB\u001f#\u0001\u0007\u0011\u0011D\u0001\fe\u0016\u0004H.Y2f[\u0016tG\u000f\u0006\u0004\u0002\u001a\r\u000531\t\u0005\b\u0005W\u0014\u0002\u0019AA1\u0011\u001d\u0019)E\u0005a\u0001\u0007\u000f\n\u0001B]3qY\u0006\u001cWM\u001d\t\bm\u000e%\u00131QA\r\u0013\r\u0019Y%\u001d\u0002\n\rVt7\r^5p]F\nQB]3qY\u0006\u001cWmU8nK&sGCBA\r\u0007#\u001a\u0019\u0006C\u0004\u0003lN\u0001\r!!\u0019\t\u000f\r\u00153\u00031\u0001\u0004VA9ao!\u0013\u0002\u0004\u000eu\u0011A\u0004:fa2\f7-\u001a$jeN$\u0018J\u001c\u000b\u0007\u00033\u0019Yf!\u0018\t\u000f\t-H\u00031\u0001\u0002b!91Q\b\u000bA\u0002\u0005e\u0011!B:qY&$H\u0003BB2\u0007K\u0002RA\u001eB\u000e\u00033Aqaa\u001a\u0016\u0001\u0004\t\t'A\u0004u_N\u0003H.\u001b;\u0002\u0015Ut\u0017M\\2i_J,G-\u0006\u0002\u0004nA!\u0011QGB8\u0013\r\u0019\t(\u001c\u0002\u0010+:\fgn\u00195pe\u0016$'+Z4fq\u0006A\u0011M\\2i_J,G\rK\u0004\u0001\u0007o\u001aiha \u0011\u0007Y\u001cI(C\u0002\u0004|E\u0014\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u0002\u000bY\fG.^3\u001f\u0011\tp_[\u001bPqD}\u0006")
public class Regex
implements Serializable {
    public static final long serialVersionUID = -2094783597747625537L;
    private final Pattern pattern;
    public final Seq<String> scala$util$matching$Regex$$groupNames;

    public static String quoteReplacement(String string) {
        return Regex$.MODULE$.quoteReplacement(string);
    }

    public static String quote(String string) {
        return Regex$.MODULE$.quote(string);
    }

    public Pattern pattern() {
        return this.pattern;
    }

    public Option<List<String>> unapplySeq(CharSequence s) {
        Matcher m;
        Option option = s == null ? None$.MODULE$ : (this.runMatcher(m = this.pattern().matcher(s)) ? Regex$.MODULE$.scala$util$matching$Regex$$extractGroupsFromMatcher(m) : None$.MODULE$);
        return option;
    }

    public Option<List<Object>> unapplySeq(char c) {
        Matcher m = this.pattern().matcher(((Object)BoxesRunTime.boxToCharacter(c)).toString());
        if (this.runMatcher(m)) {
            if (m.groupCount() > 0) {
                String string = m.group(1);
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new Some<List<Object>>(new StringOps(string).toList());
            }
            return new Some<List<Object>>(Nil$.MODULE$);
        }
        return None$.MODULE$;
    }

    public Option<List<String>> unapplySeq(Match m) {
        if (m == null || m.matched() == null) {
            return None$.MODULE$;
        }
        Pattern pattern = m.matcher().pattern();
        Pattern pattern2 = this.pattern();
        if (!(pattern != null ? !pattern.equals(pattern2) : pattern2 != null)) {
            return Regex$.MODULE$.scala$util$matching$Regex$$extractGroupsFromMatch(m);
        }
        return this.unapplySeq(m.matched());
    }

    public Option<List<String>> unapplySeq(Object target) {
        Option option;
        if (target instanceof CharSequence) {
            CharSequence charSequence = (CharSequence)target;
            Matcher m = this.pattern().matcher(charSequence);
            option = this.runMatcher(m) ? Regex$.MODULE$.scala$util$matching$Regex$$extractGroupsFromMatcher(m) : None$.MODULE$;
        } else if (target instanceof Match) {
            Match match = (Match)target;
            option = this.unapplySeq(match.matched());
        } else {
            option = None$.MODULE$;
        }
        return option;
    }

    public boolean runMatcher(Matcher m) {
        return m.matches();
    }

    public MatchIterator findAllIn(CharSequence source2) {
        return new MatchIterator(source2, this, this.scala$util$matching$Regex$$groupNames);
    }

    public Iterator<Match> findAllMatchIn(CharSequence source2) {
        MatchIterator matchIterator = this.findAllIn(source2);
        return new Iterator<Match>(null, matchIterator){
            private final MatchIterator matchIterator$1;

            public Iterator<Match> seq() {
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

            public Iterator<Match> take(int n) {
                return Iterator.take$(this, n);
            }

            public Iterator<Match> drop(int n) {
                return Iterator.drop$(this, n);
            }

            public Iterator<Match> slice(int from, int until) {
                return Iterator.slice$(this, from, until);
            }

            public Iterator<Match> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> map(Function1<Match, B> f) {
                return Iterator.map$(this, f);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<Match, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<Match> filter(Function1<Match, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Match, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<Match> withFilter(Function1<Match, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<Match> filterNot(Function1<Match, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<Match, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, Match, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<Match, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<Match> takeWhile(Function1<Match, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<Match>, Iterator<Match>> partition(Function1<Match, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<Match>, Iterator<Match>> span(Function1<Match, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<Match> dropWhile(Function1<Match, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<Match, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<Match, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<Match, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<Match, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<Match, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<Match> find(Function1<Match, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<Match, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<Match, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<Match> buffered() {
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

            public Tuple2<Iterator<Match>, Iterator<Match>> duplicate() {
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

            public Traversable<Match> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<Match> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<Match> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<Match> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<Match, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<Match, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, Match, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<Match, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, Match, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<Match, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, Match, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<Match, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, Match, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<Match, B, B> op) {
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

            public <B> B aggregate(Function0<B> z, Function2<B, Match, B> seqop, Function2<B, B, B> combop) {
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

            public List<Match> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<Match> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<Match> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<Match> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<Match> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Match, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Match, Tuple2<T, U>> ev) {
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
                return this.matchIterator$1.hasNext();
            }

            public Match next() {
                this.matchIterator$1.next();
                return new Match(this.matchIterator$1.source(), this.matchIterator$1.matcher(), this.matchIterator$1.groupNames()).force();
            }
            {
                this.matchIterator$1 = matchIterator$1;
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Iterator.$init$(this);
            }
        };
    }

    public Option<String> findFirstIn(CharSequence source2) {
        Matcher m = this.pattern().matcher(source2);
        if (m.find()) {
            return new Some<String>(m.group());
        }
        return None$.MODULE$;
    }

    public Option<Match> findFirstMatchIn(CharSequence source2) {
        Matcher m = this.pattern().matcher(source2);
        if (m.find()) {
            return new Some<Match>(new Match(source2, m, this.scala$util$matching$Regex$$groupNames));
        }
        return None$.MODULE$;
    }

    public Option<String> findPrefixOf(CharSequence source2) {
        Matcher m = this.pattern().matcher(source2);
        if (m.lookingAt()) {
            return new Some<String>(m.group());
        }
        return None$.MODULE$;
    }

    public Option<Match> findPrefixMatchOf(CharSequence source2) {
        Matcher m = this.pattern().matcher(source2);
        if (m.lookingAt()) {
            return new Some<Match>(new Match(source2, m, this.scala$util$matching$Regex$$groupNames));
        }
        return None$.MODULE$;
    }

    public String replaceAllIn(CharSequence target, String replacement) {
        return this.pattern().matcher(target).replaceAll(replacement);
    }

    public String replaceAllIn(CharSequence target, Function1<Match, String> replacer) {
        AbstractIterator<Match> it = new MatchIterator(target, this, this.scala$util$matching$Regex$$groupNames).replacementData();
        it.foreach((Function1<Match, Matcher> & java.io.Serializable & Serializable)md -> ((Replacement)((Object)it)).replace((String)replacer.apply((Match)md)));
        return ((Replacement)((Object)it)).replaced();
    }

    public String replaceSomeIn(CharSequence target, Function1<Match, Option<String>> replacer) {
        AbstractIterator<Match> it = new MatchIterator(target, this, this.scala$util$matching$Regex$$groupNames).replacementData();
        it.foreach((Function1<Match, Object> & java.io.Serializable & Serializable)matchdata -> {
            Option option = (Option)replacer.apply((Match)matchdata);
            if (option == null) {
                throw null;
            }
            Option $anonfun$replaceSomeIn$1_foreach_this = option;
            if (!$anonfun$replaceSomeIn$1_foreach_this.isEmpty()) {
                String string = (String)$anonfun$replaceSomeIn$1_foreach_this.get();
                Regex.$anonfun$replaceSomeIn$2(it, string);
            }
            return BoxedUnit.UNIT;
        });
        return ((Replacement)((Object)it)).replaced();
    }

    public String replaceFirstIn(CharSequence target, String replacement) {
        return this.pattern().matcher(target).replaceFirst(replacement);
    }

    public String[] split(CharSequence toSplit) {
        return this.pattern().split(toSplit);
    }

    public UnanchoredRegex unanchored() {
        return new UnanchoredRegex(this){
            private final /* synthetic */ Regex $outer;

            public boolean runMatcher(Matcher m) {
                return UnanchoredRegex.runMatcher$(this, m);
            }

            public UnanchoredRegex unanchored() {
                return UnanchoredRegex.unanchored$(this);
            }

            public Regex anchored() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super($outer.pattern(), $outer.scala$util$matching$Regex$$groupNames);
                UnanchoredRegex.$init$(this);
            }
        };
    }

    public Regex anchored() {
        return this;
    }

    public String regex() {
        return this.pattern().pattern();
    }

    public String toString() {
        return this.regex();
    }

    public static final /* synthetic */ Matcher $anonfun$replaceSomeIn$2(AbstractIterator it$2, String replacement) {
        return ((Replacement)((Object)it$2)).replace(replacement);
    }

    public static final /* synthetic */ void $anonfun$replaceSomeIn$1(Function1 replacer$2, AbstractIterator it$2, Match matchdata) {
        Option option = (Option)replacer$2.apply(matchdata);
        if (option == null) {
            throw null;
        }
        Option foreach_this = option;
        if (!foreach_this.isEmpty()) {
            String string = (String)foreach_this.get();
            Regex.$anonfun$replaceSomeIn$2(it$2, string);
            return;
        }
    }

    public Regex(Pattern pattern, Seq<String> groupNames) {
        this.pattern = pattern;
        this.scala$util$matching$Regex$$groupNames = groupNames;
    }

    public Regex(String regex, Seq<String> groupNames) {
        this(Pattern.compile(regex), groupNames);
    }

    public static class Match
    implements MatchData {
        private int[] starts;
        private int[] ends;
        private final CharSequence source;
        private final Matcher matcher;
        private final Seq<String> groupNames;
        private final int start;
        private final int end;
        private Map<String, Object> scala$util$matching$Regex$MatchData$$nameToIndex;
        private volatile byte bitmap$0;

        @Override
        public String matched() {
            return ((MatchData)this).matched();
        }

        @Override
        public String group(int i) {
            return ((MatchData)this).group(i);
        }

        @Override
        public List<String> subgroups() {
            return ((MatchData)this).subgroups();
        }

        @Override
        public CharSequence before() {
            return ((MatchData)this).before();
        }

        @Override
        public CharSequence before(int i) {
            return ((MatchData)this).before(i);
        }

        @Override
        public CharSequence after() {
            return ((MatchData)this).after();
        }

        @Override
        public CharSequence after(int i) {
            return ((MatchData)this).after(i);
        }

        @Override
        public String group(String id) {
            return ((MatchData)this).group(id);
        }

        @Override
        public String toString() {
            return ((MatchData)this).toString();
        }

        private Map<String, Object> scala$util$matching$Regex$MatchData$$nameToIndex$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 4) == 0) {
                    this.scala$util$matching$Regex$MatchData$$nameToIndex = ((MatchData)this).scala$util$matching$Regex$MatchData$$nameToIndex();
                    this.bitmap$0 = (byte)(this.bitmap$0 | 4);
                }
            }
            return this.scala$util$matching$Regex$MatchData$$nameToIndex;
        }

        @Override
        public Map<String, Object> scala$util$matching$Regex$MatchData$$nameToIndex() {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                return this.scala$util$matching$Regex$MatchData$$nameToIndex$lzycompute();
            }
            return this.scala$util$matching$Regex$MatchData$$nameToIndex;
        }

        @Override
        public CharSequence source() {
            return this.source;
        }

        @Override
        public Matcher matcher() {
            return this.matcher;
        }

        @Override
        public Seq<String> groupNames() {
            return this.groupNames;
        }

        @Override
        public int start() {
            return this.start;
        }

        @Override
        public int end() {
            return this.end;
        }

        @Override
        public int groupCount() {
            return this.matcher().groupCount();
        }

        /*
         * WARNING - void declaration
         */
        private int[] starts$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 1) == 0) {
                    void map_bf;
                    void map_f;
                    int n = 0;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(n, this.groupCount());
                    CanBuildFrom canBuildFrom = IndexedSeq$.MODULE$.canBuildFrom();
                    JFunction1$mcII$sp & Serializable intersect = (JFunction1$mcII$sp & Serializable)x$1 -> this.matcher().start(x$1);
                    if (inclusive == null) {
                        throw null;
                    }
                    this.starts = (int[])((TraversableOnce)TraversableLike.map$(inclusive, (Function1)map_f, (CanBuildFrom)map_bf)).toArray(ClassTag$.MODULE$.Int());
                    this.bitmap$0 = (byte)(this.bitmap$0 | 1);
                }
            }
            return this.starts;
        }

        private int[] starts() {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                return this.starts$lzycompute();
            }
            return this.starts;
        }

        /*
         * WARNING - void declaration
         */
        private int[] ends$lzycompute() {
            synchronized (this) {
                if ((byte)(this.bitmap$0 & 2) == 0) {
                    void map_bf;
                    void map_f;
                    int n = 0;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(n, this.groupCount());
                    CanBuildFrom canBuildFrom = IndexedSeq$.MODULE$.canBuildFrom();
                    JFunction1$mcII$sp & Serializable intersect = (JFunction1$mcII$sp & Serializable)x$1 -> this.matcher().end(x$1);
                    if (inclusive == null) {
                        throw null;
                    }
                    this.ends = (int[])((TraversableOnce)TraversableLike.map$(inclusive, (Function1)map_f, (CanBuildFrom)map_bf)).toArray(ClassTag$.MODULE$.Int());
                    this.bitmap$0 = (byte)(this.bitmap$0 | 2);
                }
            }
            return this.ends;
        }

        private int[] ends() {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                return this.ends$lzycompute();
            }
            return this.ends;
        }

        @Override
        public int start(int i) {
            return this.starts()[i];
        }

        @Override
        public int end(int i) {
            return this.ends()[i];
        }

        public Match force() {
            this.starts();
            this.ends();
            return this;
        }

        public Match(CharSequence source2, Matcher matcher, Seq<String> groupNames) {
            this.source = source2;
            this.matcher = matcher;
            this.groupNames = groupNames;
            MatchData.$init$(this);
            this.start = matcher.start();
            this.end = matcher.end();
        }
    }

    public static interface MatchData {
        public Matcher matcher();

        public CharSequence source();

        public Seq<String> groupNames();

        public int groupCount();

        public int start();

        public int start(int var1);

        public int end();

        public int end(int var1);

        default public String matched() {
            if (this.start() >= 0) {
                return ((Object)this.source().subSequence(this.start(), this.end())).toString();
            }
            return null;
        }

        default public String group(int i) {
            if (this.start(i) >= 0) {
                return ((Object)this.source().subSequence(this.start(i), this.end(i))).toString();
            }
            return null;
        }

        default public List<String> subgroups() {
            int n = 1;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.to$extension0(n, this.groupCount()).toList().map((Function1<Object, String> & java.io.Serializable & Serializable)i -> this.group(BoxesRunTime.unboxToInt(i)), List$.MODULE$.canBuildFrom());
        }

        default public CharSequence before() {
            if (this.start() >= 0) {
                return this.source().subSequence(0, this.start());
            }
            return null;
        }

        default public CharSequence before(int i) {
            if (this.start(i) >= 0) {
                return this.source().subSequence(0, this.start(i));
            }
            return null;
        }

        default public CharSequence after() {
            if (this.end() >= 0) {
                return this.source().subSequence(this.end(), this.source().length());
            }
            return null;
        }

        default public CharSequence after(int i) {
            if (this.end(i) >= 0) {
                return this.source().subSequence(this.end(i), this.source().length());
            }
            return null;
        }

        default public Map<String, Object> scala$util$matching$Regex$MatchData$$nameToIndex() {
            String string = "";
            return ((MapLike)Predef$.MODULE$.Map().apply(Nil$.MODULE$)).$plus$plus(this.groupNames().toList().$colon$colon(string).zipWithIndex(List$.MODULE$.canBuildFrom()));
        }

        default public String group(String id) {
            String string;
            if (this.groupNames().isEmpty()) {
                return this.matcher().group(id);
            }
            Option option = this.scala$util$matching$Regex$MatchData$$nameToIndex().get(id);
            if (option instanceof Some) {
                int index = BoxesRunTime.unboxToInt(((Some)option).value());
                string = this.group(index);
            } else if (None$.MODULE$.equals(option)) {
                string = this.matcher().group(id);
            } else {
                throw new MatchError(option);
            }
            return string;
        }

        default public String toString() {
            return this.matched();
        }

        public static void $init$(MatchData $this) {
        }
    }

    public static class MatchIterator
    extends AbstractIterator<String>
    implements MatchData {
        private final CharSequence source;
        private final Regex regex;
        private final Seq<String> groupNames;
        private final Matcher matcher;
        private int nextSeen;
        private Map<String, Object> scala$util$matching$Regex$MatchData$$nameToIndex;
        private volatile boolean bitmap$0;

        @Override
        public String matched() {
            return ((MatchData)this).matched();
        }

        @Override
        public String group(int i) {
            return ((MatchData)this).group(i);
        }

        @Override
        public List<String> subgroups() {
            return ((MatchData)this).subgroups();
        }

        @Override
        public CharSequence before() {
            return ((MatchData)this).before();
        }

        @Override
        public CharSequence before(int i) {
            return ((MatchData)this).before(i);
        }

        @Override
        public CharSequence after() {
            return ((MatchData)this).after();
        }

        @Override
        public CharSequence after(int i) {
            return ((MatchData)this).after(i);
        }

        @Override
        public String group(String id) {
            return ((MatchData)this).group(id);
        }

        private Map<String, Object> scala$util$matching$Regex$MatchData$$nameToIndex$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.scala$util$matching$Regex$MatchData$$nameToIndex = ((MatchData)this).scala$util$matching$Regex$MatchData$$nameToIndex();
                    this.bitmap$0 = true;
                }
            }
            return this.scala$util$matching$Regex$MatchData$$nameToIndex;
        }

        @Override
        public Map<String, Object> scala$util$matching$Regex$MatchData$$nameToIndex() {
            if (!this.bitmap$0) {
                return this.scala$util$matching$Regex$MatchData$$nameToIndex$lzycompute();
            }
            return this.scala$util$matching$Regex$MatchData$$nameToIndex;
        }

        @Override
        public CharSequence source() {
            return this.source;
        }

        public Regex regex() {
            return this.regex;
        }

        @Override
        public Seq<String> groupNames() {
            return this.groupNames;
        }

        @Override
        public Matcher matcher() {
            return this.matcher;
        }

        @Override
        public boolean hasNext() {
            int n = this.nextSeen;
            switch (n) {
                case 0: {
                    this.nextSeen = this.matcher().find() ? 1 : 3;
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    this.nextSeen = 0;
                    this.hasNext();
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    throw new MatchError(BoxesRunTime.boxToInteger(n));
                }
            }
            return this.nextSeen == 1;
        }

        @Override
        public String next() {
            int n = this.nextSeen;
            switch (n) {
                case 0: {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.next();
                    break;
                }
                case 1: {
                    this.nextSeen = 2;
                    break;
                }
                case 2: {
                    this.nextSeen = 0;
                    this.next();
                    break;
                }
                case 3: {
                    throw new NoSuchElementException();
                }
                default: {
                    throw new MatchError(BoxesRunTime.boxToInteger(n));
                }
            }
            return this.matcher().group();
        }

        @Override
        public String toString() {
            return Iterator.toString$(this);
        }

        private void ensure() {
            int n = this.nextSeen;
            switch (n) {
                case 0: {
                    if (this.hasNext()) break;
                    throw new IllegalStateException();
                }
                case 1: {
                    return;
                }
                case 2: {
                    return;
                }
                case 3: {
                    throw new IllegalStateException();
                }
                default: {
                    throw new MatchError(BoxesRunTime.boxToInteger(n));
                }
            }
        }

        @Override
        public int start() {
            this.ensure();
            return this.matcher().start();
        }

        @Override
        public int start(int i) {
            this.ensure();
            return this.matcher().start(i);
        }

        @Override
        public int end() {
            this.ensure();
            return this.matcher().end();
        }

        @Override
        public int end(int i) {
            this.ensure();
            return this.matcher().end(i);
        }

        @Override
        public int groupCount() {
            this.ensure();
            return this.matcher().groupCount();
        }

        public Iterator<Match> matchData() {
            return new AbstractIterator<Match>(this){
                private final /* synthetic */ MatchIterator $outer;

                public boolean hasNext() {
                    return this.$outer.hasNext();
                }

                public Match next() {
                    this.$outer.next();
                    return new Match(this.$outer.source(), this.$outer.matcher(), this.$outer.groupNames()).force();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                }
            };
        }

        public AbstractIterator<Match> replacementData() {
            return new Replacement(this){
                private final StringBuffer scala$util$matching$Regex$Replacement$$sb;
                private final /* synthetic */ MatchIterator $outer;

                public String replaced() {
                    return Replacement.replaced$(this);
                }

                public Matcher replace(String rs) {
                    return Replacement.replace$(this, rs);
                }

                public StringBuffer scala$util$matching$Regex$Replacement$$sb() {
                    return this.scala$util$matching$Regex$Replacement$$sb;
                }

                public final void scala$util$matching$Regex$Replacement$_setter_$scala$util$matching$Regex$Replacement$$sb_$eq(StringBuffer x$1) {
                    this.scala$util$matching$Regex$Replacement$$sb = x$1;
                }

                public Matcher matcher() {
                    return this.$outer.matcher();
                }

                public boolean hasNext() {
                    return this.$outer.hasNext();
                }

                public Match next() {
                    this.$outer.next();
                    return new Match(this.$outer.source(), this.matcher(), this.$outer.groupNames()).force();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    Replacement.$init$(this);
                }
            };
        }

        public MatchIterator(CharSequence source2, Regex regex, Seq<String> groupNames) {
            this.source = source2;
            this.regex = regex;
            this.groupNames = groupNames;
            MatchData.$init$(this);
            this.matcher = regex.pattern().matcher(source2);
            this.nextSeen = 0;
        }
    }

    public static interface Replacement {
        public void scala$util$matching$Regex$Replacement$_setter_$scala$util$matching$Regex$Replacement$$sb_$eq(StringBuffer var1);

        public Matcher matcher();

        public StringBuffer scala$util$matching$Regex$Replacement$$sb();

        public static /* synthetic */ String replaced$(Replacement $this) {
            return $this.replaced();
        }

        default public String replaced() {
            StringBuffer newsb = new StringBuffer(this.scala$util$matching$Regex$Replacement$$sb());
            this.matcher().appendTail(newsb);
            return newsb.toString();
        }

        public static /* synthetic */ Matcher replace$(Replacement $this, String rs) {
            return $this.replace(rs);
        }

        default public Matcher replace(String rs) {
            return this.matcher().appendReplacement(this.scala$util$matching$Regex$Replacement$$sb(), rs);
        }

        public static void $init$(Replacement $this) {
            $this.scala$util$matching$Regex$Replacement$_setter_$scala$util$matching$Regex$Replacement$$sb_$eq(new StringBuffer());
        }
    }
}

