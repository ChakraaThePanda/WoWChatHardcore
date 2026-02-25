/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import java.util.concurrent.atomic.AtomicInteger;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple2$mcIZ$sp;
import scala.collection.BufferedIterator;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.AtomicIndexFlag;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.DefaultSignalling;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.AugmentedSeqIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParSeq;
import scala.collection.parallel.ParallelCollectionImplicits$;
import scala.collection.parallel.PreciseSplitter;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.Task;
import scala.collection.parallel.immutable.Repetition;
import scala.collection.parallel.mutable.ParArray$;
import scala.collection.parallel.package$;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction0$mcZ$sp;
import scala.runtime.java8.JFunction2$mcIII$sp;

@ScalaSignature(bytes="\u0006\u0001\u0019meACA.\u0003;\u0002\n1!\u0001\u0002l!9\u0011Q\u001a\u0001\u0005\u0002\u0005=W\u0001CAl\u0001\u0001\u0006\t\"!7\t\u0013\u0005}\u0007A\"\u0005\u0002^\u0005\u0005\bbBAu\u0001\u0011\u0005\u00131\u001e\u0005\b\u0003g\u0004A\u0011IA{\r\u001d\ti\u0010AA\t\u0003\u007fD!Ba\u0002\u0007\u0005\u0003\u0005\u000b\u0011BA|\u0011)\u0011IA\u0002BC\u0002\u0013\u0005\u0011Q\u001f\u0005\u000b\u0005\u00171!\u0011!Q\u0001\n\u0005]\bb\u0002B\u0007\r\u0011\u0005!q\u0002\u0005\n\u000531\u0001\u0019!C\u0005\u0003kD\u0011Ba\u0007\u0007\u0001\u0004%IA!\b\t\u0011\t\rb\u0001)Q\u0005\u0003oDqA!\n\u0007\t\u0003\u00119\u0003C\u0004\u00030\u0019!\tA!\r\t\u000f\tMb\u0001\"\u0001\u00036!9!q\u0007\u0004\u0005\u0006\u0005U\bb\u0002B\u001d\r\u0011\u0005!1\b\u0005\b\u0005{1A\u0011\u0001B \u0011\u001d\u0011)E\u0002C\u0001\u0005\u000fBqA!\u0016\u0007\t\u0003\u00129\u0006C\u0004\u0003j\u0001!\tAa\u001b\t\u000f\tm\u0004\u0001\"\u0001\u0003~!9!1\u0011\u0001\u0005\u0002\t\u0015\u0005b\u0002BF\u0001\u0011\u0005!Q\u0012\u0005\b\u0005\u001f\u0003A\u0011\u0001BI\u0011\u001d\u0011I\f\u0001C\u0001\u0005wCqA!5\u0001\t\u0003\u0012\u0019\u000eC\u0004\u0003h\u0002!\tA!;\t\u000f\tU\b\u0001\"\u0001\u0003x\"911\u0003\u0001\u0005\n\rU\u0001bBB\u001a\u0001\u0011\u00051Q\u0007\u0005\b\u0007\u001f\u0002A\u0011AB)\u0011\u001d\u0019)\u0007\u0001C\u0001\u0007OBqaa\u001f\u0001\t\u0003\u0019i\bC\u0004\u0004\u0016\u0002!\tea&\t\u000f\r]\u0006\u0001\"\u0001\u0004:\"91q\u001a\u0001\u0005\u0002\rE\u0007bBBo\u0001\u0011\u00051q\u001c\u0005\b\u0007W\u0004A\u0011\u0001BG\u0011\u001d\u0011)\u0006\u0001C!\u0007[Dq\u0001b\u0001\u0001\t\u0003\")\u0001C\u0004\u0005\b\u0001!\t\u0005\"\u0003\t\u0011\u0011\u001d\u0002\u0001)C\t\tS1\u0011\u0002b\u000e\u0001!\u0003\r\n\u0002\"\u000f\t\u0013\u00115SF1Q\u0007\u0012\u0005\u0005h!\u0003C(\u0001A\u0005\u0019\u0013\u0003C)\r!!\u0019\u0007\u0001Q\u0001\u0012\u0011\u0015\u0004B\u0003C7a\t\u0005\t\u0015!\u0003\u0003r!Q!\u0011\u0010\u0019\u0003\u0002\u0003\u0006I!a>\t\u0015\u00115\u0003G!b!\n#\t\t\u000f\u0003\u0006\u0005pA\u0012\t\u0011)A\u0005\u0003GDqA!\u00041\t\u0003!\t\bC\u0005\u0005zA\u0002\r\u0011\"\u0001\u0005|!IAQ\u0010\u0019A\u0002\u0013\u0005Aq\u0010\u0005\t\t\u0007\u0003\u0004\u0015)\u0003\u0005j!9AQ\u0012\u0019\u0005\u0002\u0011=\u0005\u0002\u0003CNa\u0001&\t\u0002\"(\t\u000f\tu\u0002\u0007\"\u0011\u0005$\"9AQ\u0016\u0019\u0005B\u0011=\u0006b\u0002CZa\u0011\u0005#q\u0005\u0004\t\tk\u0003\u0001\u0015!\u0005\u00058\"QAQ\u000e \u0003\u0002\u0003\u0006IA!\u001d\t\u0015\tedH!A!\u0002\u0013\t9\u0010\u0003\u0006\u0005Ny\u0012)\u0019)C\t\u0003CD!\u0002b\u001c?\u0005\u0003\u0005\u000b\u0011BAr\u0011\u001d\u0011iA\u0010C\u0001\t{C\u0011\u0002\"\u001f?\u0001\u0004%\t!!>\t\u0013\u0011ud\b1A\u0005\u0002\u0011\u0015\u0007\u0002\u0003CB}\u0001\u0006K!a>\t\u000f\u00115e\b\"\u0001\u0005L\"AA1\u0014 !\n#!\t\u000eC\u0004\u0003>y\"\t\u0005\"6\t\u000f\u00115f\b\"\u0011\u0005\\\"9A1\u0017 \u0005B\t\u001db\u0001\u0003Cp\u0001\u0001\u0006\t\u0002\"9\t\u0015\u00115DJ!A!\u0002\u0013\u0011\t\b\u0003\u0006\u0005h2\u0013\t\u0011)A\u0005\u0003oD!\u0002\"\u0014M\u0005\u000b\u0007K\u0011CAq\u0011)!y\u0007\u0014B\u0001B\u0003%\u00111\u001d\u0005\b\u0005\u001baE\u0011\u0001Cu\u0011%!I\b\u0014a\u0001\n\u0003\t)\u0010C\u0005\u0005~1\u0003\r\u0011\"\u0001\u0005r\"AA1\u0011'!B\u0013\t9\u0010C\u0004\u0005\u000e2#\t\u0001b>\t\u0011\u0011mE\n)C\t\twDqA!\u0010M\t\u0003\"y\u0010C\u0004\u0005.2#\t%\"\u0002\t\u000f\u0011MF\n\"\u0011\u0003(\u0019AQ\u0011\u0002\u0001!\u0002#)Y\u0001\u0003\u0006\u0006&i\u0013\t\u0011)A\u0005\u000bOA!\u0002\"\u0014[\u0005\u000b\u0007K\u0011CAq\u0011)!yG\u0017B\u0001B\u0003%\u00111\u001d\u0005\b\u0005\u001bQF\u0011AC\u0017\u0011%!IH\u0017a\u0001\n\u0003)\u0019\u0004C\u0005\u0005~i\u0003\r\u0011\"\u0001\u00066!AA1\u0011.!B\u0013)\t\u0002C\u0004\u0005\u000ej#\t!b\u000f\t\u0011\u0011m%\f)C\t\u000b\u0003Bq\u0001\",[\t\u0003*)E\u0002\u0005\u0006J\u0001\u0001\u000b\u0011CC&\u0011)\u0011),\u001aB\u0001B\u0003%QQ\f\u0005\u000b\u000b?*'\u0011!Q\u0001\n\u0015\u0005\u0004B\u0003C'K\n\u0015\r\u0015\"\u0005\u0002b\"QAqN3\u0003\u0002\u0003\u0006I!a9\t\u000f\t5Q\r\"\u0001\u0006d!IA\u0011P3A\u0002\u0013\u0005Q1\u000e\u0005\n\t{*\u0007\u0019!C\u0001\u000b[B\u0001\u0002b!fA\u0003&Q\u0011\u000b\u0005\b\t\u001b+G\u0011AC:\u0011!!Y*\u001aQ\u0005\u0012\u0015e\u0004b\u0002CWK\u0012\u0005SQ\u0010\u0004\t\u000b\u0003\u0003\u0001\u0015!\u0005\u0006\u0004\"QAQJ9\u0003\u0006\u0004&\t\"!9\t\u0015\u0011=\u0014O!A!\u0002\u0013\t\u0019\u000f\u0003\u0006\u0006\u0010F\u0014)\u0019!C\u0001\u000b#C!\"\"&r\u0005\u0003\u0005\u000b\u0011BCJ\u0011\u001d\u0011i!\u001dC\u0001\u000b/C\u0011\u0002\"\u001fr\u0001\u0004%\tAa\n\t\u0013\u0011u\u0014\u000f1A\u0005\u0002\u0015u\u0005\u0002\u0003CBc\u0002\u0006KA!\u000b\t\u000f\u00115\u0015\u000f\"\u0001\u0006$\"AA1T9!\n#)I\u000bC\u0004\u0003>E$\t%\",\t\u000f\u00115\u0016\u000f\"\u0011\u00064\"9A1W9\u0005B\t\u001db\u0001CC\\\u0001\u0001\u0006\t\"\"/\t\u0015\u0011\u001dxP!A!\u0002\u0013\t9\u0010\u0003\u0006\u0004N}\u0014\t\u0011)A\u0005\u000b\u0003D!\"b\u0018\u0000\u0005\u0003\u0005\u000b\u0011BCf\u0011)!ie BCB\u0013E\u0011\u0011\u001d\u0005\u000b\t_z(\u0011!Q\u0001\n\u0005\r\bb\u0002B\u0007\u007f\u0012\u0005Q\u0011\u001b\u0005\n\tsz\b\u0019!C\u0001\u000b7D\u0011\u0002\" \u0000\u0001\u0004%\t!\"8\t\u0011\u0011\ru\u0010)Q\u0005\u000b\u007fCq\u0001\"$\u0000\t\u0003)\u0019\u000f\u0003\u0005\u0005\u001c~\u0004K\u0011CCu\u0011\u001d\u0011id C!\u000b[Dq\u0001\",\u0000\t\u0003*\u0019\u0010C\u0004\u00054~$\tEa\n\u0007\u0011\u0015]\b\u0001)A\t\u000bsD1b!%\u0002\u001e\t\u0005\t\u0015!\u0003\u0002x\"Ya\u0011CA\u000f\u0005\u0003\u0005\u000b\u0011\u0002D\n\u0011-!i%!\b\u0003\u0006\u0004&\t\"!9\t\u0017\u0011=\u0014Q\u0004B\u0001B\u0003%\u00111\u001d\u0005\f\u000b\u001f\u000biB!b\u0001\n\u00031)\u0002C\u0006\u0006\u0016\u0006u!\u0011!Q\u0001\n\u0019]\u0001\u0002\u0003B\u0007\u0003;!\tA\"\u0007\t\u0015\u0011e\u0014Q\u0004a\u0001\n\u00031\u0019\u0003\u0003\u0006\u0005~\u0005u\u0001\u0019!C\u0001\r[A\u0011\u0002b!\u0002\u001e\u0001\u0006KA\"\n\t\u0011\u00115\u0015Q\u0004C\u0001\rgA\u0011\u0002b'\u0002\u001e\u0001&\tB\"\u000f\t\u0011\tu\u0012Q\u0004C!\r{A\u0001\u0002\",\u0002\u001e\u0011\u0005c\u0011\t\u0004\t\r\u000b\u0002\u0001\u0015!\u0005\u0007H!Ya1KA\u001e\u0005\u0003\u0005\u000b\u0011\u0002D+\u0011-!i%a\u000f\u0003\u0006\u0004&\t\"!9\t\u0017\u0011=\u00141\bB\u0001B\u0003%\u00111\u001d\u0005\f\u000b\u001f\u000bYD!b\u0001\n\u000319\u0006C\u0006\u0006\u0016\u0006m\"\u0011!Q\u0001\n\u0019e\u0003\u0002\u0003B\u0007\u0003w!\tAb\u0017\t\u0015\u0011e\u00141\ba\u0001\n\u0003\u00119\u0003\u0003\u0006\u0005~\u0005m\u0002\u0019!C\u0001\rGB\u0011\u0002b!\u0002<\u0001\u0006KA!\u000b\t\u0011\u00115\u00151\bC\u0001\rSB\u0011\u0002b'\u0002<\u0001&\tB\"\u001c\t\u0011\tu\u00121\bC!\rcB\u0001\u0002\",\u0002<\u0011\u0005cq\u000f\u0005\t\tg\u000bY\u0004\"\u0011\u0003(!qa1\u0010\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0007~\u0019e%A\u0003)beN+\u0017\u000fT5lK*!\u0011qLA1\u0003!\u0001\u0018M]1mY\u0016d'\u0002BA2\u0003K\n!bY8mY\u0016\u001cG/[8o\u0015\t\t9'A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0011\u00055\u00141QAL\u0003[\u001br\u0001AA8\u0003o\n)\u000b\u0005\u0003\u0002r\u0005MTBAA3\u0013\u0011\t)(!\u001a\u0003\r\u0005s\u0017PU3g!!\tI(a\u001f\u0002\u0000\u0005UUBAA1\u0013\u0011\ti(!\u0019\u0003\u0015\u001d+gnU3r\u0019&\\W\r\u0005\u0003\u0002\u0002\u0006\rE\u0002\u0001\u0003\t\u0003\u000b\u0003AQ1\u0001\u0002\b\n\tA+\u0005\u0003\u0002\n\u0006=\u0005\u0003BA9\u0003\u0017KA!!$\u0002f\t9aj\u001c;iS:<\u0007\u0003BA9\u0003#KA!a%\u0002f\t\u0019\u0011I\\=\u0011\t\u0005\u0005\u0015q\u0013\u0003\t\u00033\u0003AQ1\u0001\u0002\u001c\n!!+\u001a9s#\u0011\tI)!(\u0011\r\u0005}\u0015\u0011UA@\u001b\t\ti&\u0003\u0003\u0002$\u0006u#A\u0002)beN+\u0017\u000f\u0005\u0006\u0002 \u0006\u001d\u0016qPAK\u0003WKA!!+\u0002^\ty\u0001+\u0019:Ji\u0016\u0014\u0018M\u00197f\u0019&\\W\r\u0005\u0003\u0002\u0002\u00065F\u0001CAX\u0001\u0011\u0015\r!!-\u0003\u0015M+\u0017/^3oi&\fG.\u0005\u0003\u0002\n\u0006M&CBA[\u0003s\u000b9M\u0002\u0004\u00028\u0002\u0001\u00111\u0017\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u0007\u0003w\u000b\t-a \u000f\t\u0005E\u0014QX\u0005\u0005\u0003\u007f\u000b)'A\u0004qC\u000e\\\u0017mZ3\n\t\u0005\r\u0017Q\u0019\u0002\u0004'\u0016\f(\u0002BA`\u0003K\u0002\u0002\"!\u001f\u0002J\u0006}\u00141V\u0005\u0005\u0003\u0017\f\tGA\u0004TKFd\u0015n[3\u0002\r\u0011Jg.\u001b;%)\t\t\t\u000e\u0005\u0003\u0002r\u0005M\u0017\u0002BAk\u0003K\u0012A!\u00168ji\n\u00012+\u001e9feB\u000b'/\u0013;fe\u0006$xN\u001d\t\u0007\u0003?\u000bY.a \n\t\u0005u\u0017Q\f\u0002\u0011\u0013R,'/\u00192mKN\u0003H.\u001b;uKJ\f\u0001b\u001d9mSR$XM]\u000b\u0003\u0003G\u0004b!a(\u0002f\u0006}\u0014\u0002BAt\u0003;\u00121bU3r'Bd\u0017\u000e\u001e;fe\u0006A\u0011\u000e^3sCR|'/\u0006\u0002\u0002nB1\u0011qTAx\u0003\u007fJA!!=\u0002^\ty\u0001K]3dSN,7\u000b\u001d7jiR,'/\u0001\u0003tSj,WCAA|!\u0011\t\t(!?\n\t\u0005m\u0018Q\r\u0002\u0004\u0013:$(\u0001C#mK6,g\u000e^:\u0014\u000f\u0019\ty'a9\u0003\u0002A1\u00111\u0018B\u0002\u0003\u007fJAA!\u0002\u0002F\n\u0001\")\u001e4gKJ,G-\u0013;fe\u0006$xN]\u0001\u0006gR\f'\u000f^\u0001\u0004K:$\u0017\u0001B3oI\u0002\na\u0001P5oSRtDC\u0002B\t\u0005+\u00119\u0002E\u0002\u0003\u0014\u0019i\u0011\u0001\u0001\u0005\b\u0005\u000fQ\u0001\u0019AA|\u0011\u001d\u0011IA\u0003a\u0001\u0003o\f\u0011![\u0001\u0006S~#S-\u001d\u000b\u0005\u0003#\u0014y\u0002C\u0005\u0003\"1\t\t\u00111\u0001\u0002x\u0006\u0019\u0001\u0010J\u0019\u0002\u0005%\u0004\u0013a\u00025bg:+\u0007\u0010^\u000b\u0003\u0005S\u0001B!!\u001d\u0003,%!!QFA3\u0005\u001d\u0011un\u001c7fC:\fAA\\3yiR\u0011\u0011qP\u0001\u0005Q\u0016\fG-\u0006\u0002\u0002\u0000\u0005I!/Z7bS:LgnZ\u0001\u0004IV\u0004XC\u0001B\t\u0003\u0015\u0019\b\u000f\\5u+\t\u0011\t\u0005\u0005\u0004\u0002z\t\r\u00131]\u0005\u0005\u0003\u0007\f\t'\u0001\u0004qgBd\u0017\u000e\u001e\u000b\u0005\u0005\u0013\u0012Y\u0005\u0005\u0004\u0002<\u0006\u0005\u00171\u001d\u0005\b\u0005\u001b\"\u0002\u0019\u0001B(\u0003\u0015\u0019\u0018N_3t!\u0019\t\tH!\u0015\u0002x&!!1KA3\u0005)a$/\u001a9fCR,GMP\u0001\ti>\u001cFO]5oOR\u0011!\u0011\f\t\u0005\u00057\u0012)'\u0004\u0002\u0003^)!!q\fB1\u0003\u0011a\u0017M\\4\u000b\u0005\t\r\u0014\u0001\u00026bm\u0006LAAa\u001a\u0003^\t11\u000b\u001e:j]\u001e\fQb]3h[\u0016tG\u000fT3oORDGCBA|\u0005[\u00129\bC\u0004\u0003pY\u0001\rA!\u001d\u0002\u0003A\u0004\u0002\"!\u001d\u0003t\u0005}$\u0011F\u0005\u0005\u0005k\n)GA\u0005Gk:\u001cG/[8oc!9!\u0011\u0010\fA\u0002\u0005]\u0018\u0001\u00024s_6\f!\"\u001b8eKb<\u0006.\u001a:f)\u0019\t9Pa \u0003\u0002\"9!qN\fA\u0002\tE\u0004b\u0002B=/\u0001\u0007\u0011q_\u0001\u000fY\u0006\u001cH/\u00138eKb<\u0006.\u001a:f)\u0019\t9Pa\"\u0003\n\"9!q\u000e\rA\u0002\tE\u0004b\u0002B\u00051\u0001\u0007\u0011q_\u0001\be\u00164XM]:f+\t\t)*\u0001\u0006sKZ,'o]3NCB,bAa%\u00030\neE\u0003\u0002BK\u0005g#BAa&\u0003\u001eB!\u0011\u0011\u0011BM\t\u001d\u0011YJ\u0007b\u0001\u0003\u000f\u0013A\u0001\u00165bi\"9!q\u0014\u000eA\u0004\t\u0005\u0016A\u00012g!)\u0011\u0019K!+\u0002\u0016\n5&qS\u0007\u0003\u0005KSAAa*\u0002b\u00059q-\u001a8fe&\u001c\u0017\u0002\u0002BV\u0005K\u0013AbQ1o\u0005VLG\u000e\u001a$s_6\u0004B!!!\u00030\u00129!\u0011\u0017\u000eC\u0002\u0005\u001d%!A*\t\u000f\tU&\u00041\u0001\u00038\u0006\ta\r\u0005\u0005\u0002r\tM\u0014q\u0010BW\u0003)\u0019H/\u0019:ug^KG\u000f[\u000b\u0005\u0005{\u0013Y\r\u0006\u0004\u0003*\t}&Q\u001a\u0005\b\u0005\u0003\\\u0002\u0019\u0001Bb\u0003\u0011!\b.\u0019;\u0011\r\u0005e$Q\u0019Be\u0013\u0011\u00119-!\u0019\u0003\r\u001d+gnU3r!\u0011\t\tIa3\u0005\u000f\tE6D1\u0001\u0002\b\"9!qZ\u000eA\u0002\u0005]\u0018AB8gMN,G/\u0001\u0007tC6,W\t\\3nK:$8/\u0006\u0003\u0003V\n\u0005H\u0003\u0002B\u0015\u0005/DqA!1\u001d\u0001\u0004\u0011I\u000e\u0005\u0004\u0002z\tm'q\\\u0005\u0005\u0005;\f\tGA\u0006HK:LE/\u001a:bE2,\u0007\u0003BAA\u0005C$qAa9\u001d\u0005\u0004\u0011)OA\u0001V#\u0011\ty(a$\u0002\u0011\u0015tGm],ji\",BAa;\u0003tR!!\u0011\u0006Bw\u0011\u001d\u0011\t-\ba\u0001\u0005_\u0004b!!\u001f\u0003F\nE\b\u0003BAA\u0005g$qA!-\u001e\u0005\u0004\t9)A\u0003qCR\u001c\u0007.\u0006\u0004\u0003z\u000e\u001d!q \u000b\t\u0005w\u001cIaa\u0003\u0004\u0010Q!!Q`B\u0001!\u0011\t\tIa@\u0005\u000f\tmeD1\u0001\u0002\b\"9!q\u0014\u0010A\u0004\r\r\u0001C\u0003BR\u0005S\u000b)j!\u0002\u0003~B!\u0011\u0011QB\u0004\t\u001d\u0011\u0019O\bb\u0001\u0005KDqA!\u001f\u001f\u0001\u0004\t9\u0010C\u0004\u0003vz\u0001\ra!\u0004\u0011\r\u0005e$QYB\u0003\u0011\u001d\u0019\tB\ba\u0001\u0003o\f\u0001B]3qY\u0006\u001cW\rZ\u0001\u0011a\u0006$8\r[0tKF,XM\u001c;jC2,baa\u0006\u0004&\ruA\u0003CB\r\u0007O\u0019Yca\f\u0015\t\rm1q\u0004\t\u0005\u0003\u0003\u001bi\u0002B\u0004\u0003\u001c~\u0011\r!a\"\t\u000f\t}u\u0004q\u0001\u0004\"AQ!1\u0015BU\u0003+\u001b\u0019ca\u0007\u0011\t\u0005\u00055Q\u0005\u0003\b\u0005G|\"\u0019\u0001Bs\u0011\u001d\u0019Ic\ba\u0001\u0003o\fqA\u001a:p[\u0006\u0014x\rC\u0004\u0003v~\u0001\ra!\f\u0011\r\u0005m\u0016\u0011YB\u0012\u0011\u001d\u0019\td\ba\u0001\u0003o\f\u0011A]\u0001\bkB$\u0017\r^3e+\u0019\u00199d!\u0012\u0004>Q11\u0011HB$\u0007\u0017\"Baa\u000f\u0004@A!\u0011\u0011QB\u001f\t\u001d\u0011Y\n\tb\u0001\u0003\u000fCqAa(!\u0001\b\u0019\t\u0005\u0005\u0006\u0003$\n%\u0016QSB\"\u0007w\u0001B!!!\u0004F\u00119!1\u001d\u0011C\u0002\t\u0015\bbBB%A\u0001\u0007\u0011q_\u0001\u0006S:$W\r\u001f\u0005\b\u0007\u001b\u0002\u0003\u0019AB\"\u0003\u0011)G.Z7\u0002\u0017\u0011\u0002H.^:%G>dwN\\\u000b\u0007\u0007'\u001a\tg!\u0017\u0015\t\rU31\r\u000b\u0005\u0007/\u001aY\u0006\u0005\u0003\u0002\u0002\u000eeCa\u0002BNC\t\u0007\u0011q\u0011\u0005\b\u0005?\u000b\u00039AB/!)\u0011\u0019K!+\u0002\u0016\u000e}3q\u000b\t\u0005\u0003\u0003\u001b\t\u0007B\u0004\u0003d\u0006\u0012\rA!:\t\u000f\r5\u0013\u00051\u0001\u0004`\u0005YAeY8m_:$\u0003\u000f\\;t+\u0019\u0019Iga\u001e\u0004pQ!11NB=)\u0011\u0019ig!\u001d\u0011\t\u0005\u00055q\u000e\u0003\b\u00057\u0013#\u0019AAD\u0011\u001d\u0011yJ\ta\u0002\u0007g\u0002\"Ba)\u0003*\u0006U5QOB7!\u0011\t\tia\u001e\u0005\u000f\t\r(E1\u0001\u0003f\"91Q\n\u0012A\u0002\rU\u0014!\u00029bIR{WCBB@\u0007\u001b\u001b)\t\u0006\u0004\u0004\u0002\u000e=51\u0013\u000b\u0005\u0007\u0007\u001b9\t\u0005\u0003\u0002\u0002\u000e\u0015Ea\u0002BNG\t\u0007\u0011q\u0011\u0005\b\u0005?\u001b\u00039ABE!)\u0011\u0019K!+\u0002\u0016\u000e-51\u0011\t\u0005\u0003\u0003\u001bi\tB\u0004\u0003d\u000e\u0012\rA!:\t\u000f\rE5\u00051\u0001\u0002x\u0006\u0019A.\u001a8\t\u000f\r53\u00051\u0001\u0004\f\u0006\u0019!0\u001b9\u0016\u0011\re5QVBY\u0007?#Baa'\u00044R!1QTBQ!\u0011\t\tia(\u0005\u000f\tmEE1\u0001\u0002\b\"9!q\u0014\u0013A\u0004\r\r\u0006C\u0003BR\u0005S\u000b)j!*\u0004\u001eBA\u0011\u0011OBT\u0007W\u001by+\u0003\u0003\u0004*\u0006\u0015$A\u0002+va2,'\u0007\u0005\u0003\u0002\u0002\u000e5Fa\u0002BrI\t\u0007!Q\u001d\t\u0005\u0003\u0003\u001b\t\fB\u0004\u00032\u0012\u0012\r!a\"\t\u000f\t\u0005G\u00051\u0001\u00046B1\u0011\u0011\u0010Bn\u0007_\u000b1bY8se\u0016\u001c\bo\u001c8egV!11XBe)\u0011\u0019ila3\u0015\t\t%2q\u0018\u0005\b\u0005_*\u0003\u0019ABa!)\t\tha1\u0002\u0000\r\u001d'\u0011F\u0005\u0005\u0007\u000b\f)GA\u0005Gk:\u001cG/[8oeA!\u0011\u0011QBe\t\u001d\u0011\t,\nb\u0001\u0003\u000fCqA!1&\u0001\u0004\u0019i\r\u0005\u0004\u0002z\t\u00157qY\u0001\u0005I&4g-\u0006\u0003\u0004T\u000emG\u0003BAK\u0007+DqA!1'\u0001\u0004\u00199\u000e\u0005\u0004\u0002z\t\u00157\u0011\u001c\t\u0005\u0003\u0003\u001bY\u000eB\u0004\u0003d\u001a\u0012\rA!:\u0002\u0013%tG/\u001a:tK\u000e$X\u0003BBq\u0007S$B!!&\u0004d\"9!\u0011Y\u0014A\u0002\r\u0015\bCBA=\u0005\u000b\u001c9\u000f\u0005\u0003\u0002\u0002\u000e%Ha\u0002BrO\t\u0007!Q]\u0001\tI&\u001cH/\u001b8diR\u00111q\u001e\t\u0005\u0007c\u001cyP\u0004\u0003\u0004t\u000em\b\u0003BB{\u0003Kj!aa>\u000b\t\re\u0018\u0011N\u0001\u0007yI|w\u000e\u001e \n\t\ru\u0018QM\u0001\u0007!J,G-\u001a4\n\t\t\u001dD\u0011\u0001\u0006\u0005\u0007{\f)'A\u0003u_N+\u0017/\u0006\u0002\u0002\u001e\u0006!a/[3x+\t!YA\u0005\u0004\u0005\u000e\u0005=D\u0011\u0003\u0004\u0007\u0003o\u0003\u0001\u0001b\u0003\n\t\u0011\u001d\u0011\u0011\u001a\t\t\u0003s\"\u0019\"a \u0002,&!AQCA1\u0005\u001d\u0019V-\u001d,jK^Dsa\u000bC\r\t?!\u0019\u0003\u0005\u0003\u0002r\u0011m\u0011\u0002\u0002C\u000f\u0003K\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t!\t#A\u0007vg\u0016\u0004cf]3r]YLWm^\u0011\u0003\tK\taA\r\u00182c9\u0002\u0014\u0001\u00023po:$B!a9\u0005,!9!q\u000e\u0017A\u0002\u00115\u0002\u0007\u0002C\u0018\tg\u0001b!a(\u0002\\\u0012E\u0002\u0003BAA\tg!A\u0002\"\u000e\u0005,\u0005\u0005\t\u0011!B\u0001\u0003\u000f\u00131a\u0018\u00132\u0005!\t5mY3tg>\u0014XC\u0002C\u001e\t\u0007\"IeE\u0003.\u0003_\"i\u0004\u0005\u0005\u0003\u0014\u0011}B\u0011\tC$\u0013\u0011!9$a*\u0011\t\u0005\u0005E1\t\u0003\b\t\u000bj#\u0019AAD\u0005\u0005\u0011\u0006\u0003BAA\t\u0013\"q\u0001b\u0013.\u0005\u0004\t9I\u0001\u0002Ua\u0006\u0019\u0001/\u001b;\u0003\u0017Q\u0013\u0018M\\:g_JlWM]\u000b\u0007\t'\"I\u0006\"\u0018\u0014\u000f=\ny\u0007\"\u0016\u0005`A9!1C\u0017\u0005X\u0011m\u0003\u0003BAA\t3\"q\u0001\"\u00120\u0005\u0004\t9\t\u0005\u0003\u0002\u0002\u0012uCa\u0002C&_\t\u0007\u0011q\u0011\t\t\u0005'!\t\u0007b\u0016\u0005\\%!AqJAT\u00055\u0019VmZ7f]RdUM\\4uQN)\u0001'a\u001c\u0005hA9!1C\u0017\u0005j\u0011-\u0004\u0003CA9\u0007O\u000b9P!\u000b\u0011\u0007\tM\u0001'\u0001\u0003qe\u0016$\u0017\u0001\u00029ji\u0002\"\u0002\u0002b\u001b\u0005t\u0011UDq\u000f\u0005\b\t[*\u0004\u0019\u0001B9\u0011\u001d\u0011I(\u000ea\u0001\u0003oDq\u0001\"\u00146\u0001\u0004\t\u0019/\u0001\u0004sKN,H\u000e^\u000b\u0003\tS\n!B]3tk2$x\fJ3r)\u0011\t\t\u000e\"!\t\u0013\t\u0005r'!AA\u0002\u0011%\u0014a\u0002:fgVdG\u000f\t\u0015\u0004q\u0011\u001d\u0005\u0003BA9\t\u0013KA\u0001b#\u0002f\tAao\u001c7bi&dW-\u0001\u0003mK\u00064G\u0003BAi\t#Cq\u0001b%:\u0001\u0004!)*\u0001\u0003qe\u00164\bCBA9\t/#I'\u0003\u0003\u0005\u001a\u0006\u0015$AB(qi&|g.\u0001\u0006oK^\u001cVO\u0019;bg.$B!!#\u0005 \"9!q\u000e\u001eA\u0002\u0011\u0005\u0006c\u0001B\n\u0005U\u0011AQ\u0015\t\u0007\u0003w\u000b\t\rb*\u0011\u0011\u0005}E\u0011\u0016C5\tWJA\u0001b+\u0002^\t!A+Y:l\u0003\u0015iWM]4f)\u0011\t\t\u000e\"-\t\u000f\t\u0005G\b1\u0001\u0005l\u00059\"/Z9vSJ,7o\u0015;sS\u000e$8\u000b\u001d7jiR,'o\u001d\u0002\u000b\u0013:$W\r_,iKJ,7#\u0002 \u0002p\u0011e\u0006c\u0002B\n[\u0005]H1\u0018\t\u0004\u0005'qD\u0003\u0003C^\t\u007f#\t\rb1\t\u000f\u001154\t1\u0001\u0003r!9!\u0011P\"A\u0002\u0005]\bb\u0002C'\u0007\u0002\u0007\u00111\u001d\u000b\u0005\u0003#$9\rC\u0005\u0003\"\u0015\u000b\t\u00111\u0001\u0002x\"\u001aa\tb\"\u0015\t\u0005EGQ\u001a\u0005\b\t';\u0005\u0019\u0001Ch!\u0019\t\t\bb&\u0002xR!\u0011\u0011\u0012Cj\u0011\u001d\u0011y\u0007\u0013a\u0001\tC+\"\u0001b6\u0011\r\u0005m\u0016\u0011\u0019Cm!!\ty\n\"+\u0002x\u0012mF\u0003BAi\t;DqA!1K\u0001\u0004!YL\u0001\bMCN$\u0018J\u001c3fq^CWM]3\u0014\u000b1\u000by\u0007b9\u0011\u000f\tMQ&a>\u0005fB\u0019!1\u0003'\u0002\u0007A|7\u000f\u0006\u0005\u0005f\u0012-HQ\u001eCx\u0011\u001d!i'\u0015a\u0001\u0005cBq\u0001b:R\u0001\u0004\t9\u0010C\u0004\u0005NE\u0003\r!a9\u0015\t\u0005EG1\u001f\u0005\n\u0005C\u0019\u0016\u0011!a\u0001\u0003oD3\u0001\u0016CD)\u0011\t\t\u000e\"?\t\u000f\u0011MU\u000b1\u0001\u0005PR!\u0011\u0011\u0012C\u007f\u0011\u001d\u0011yG\u0016a\u0001\tC+\"!\"\u0001\u0011\r\u0005m\u0016\u0011YC\u0002!!\ty\n\"+\u0002x\u0012\u0015H\u0003BAi\u000b\u000fAqA!1Y\u0001\u0004!)OA\u0004SKZ,'o]3\u0016\r\u00155Q\u0011DC\u000f'\u0015Q\u0016qNC\b!\u001d\u0011\u0019bLC\t\u000bG\u0001\u0002\"a(\u0006\u0014\u0015]Q1D\u0005\u0005\u000b+\tiF\u0001\u0005D_6\u0014\u0017N\\3s!\u0011\t\t)\"\u0007\u0005\u000f\t\r(L1\u0001\u0003fB!\u0011\u0011QC\u000f\t\u001d)yB\u0017b\u0001\u000bC\u0011A\u0001\u00165jgF!\u0011QSAH!\u001d\u0011\u0019BWC\f\u000b7\t1a\u00192g!\u0019\t\t(\"\u000b\u0006\u0012%!Q1FA3\u0005%1UO\\2uS>t\u0007\u0007\u0006\u0004\u0006$\u0015=R\u0011\u0007\u0005\b\u000bKq\u0006\u0019AC\u0014\u0011\u001d!iE\u0018a\u0001\u0003G,\"!\"\u0005\u0015\t\u0005EWq\u0007\u0005\n\u0005C\u0001\u0017\u0011!a\u0001\u000b#A3!\u0019CD)\u0011\t\t.\"\u0010\t\u000f\u0011M%\r1\u0001\u0006@A1\u0011\u0011\u000fCL\u000b#!B!b\t\u0006D!9!qN2A\u0002\u0011\u0005F\u0003BAi\u000b\u000fBqA!1e\u0001\u0004)\u0019C\u0001\u0006SKZ,'o]3NCB,b!\"\u0014\u0006V\u0015e3#B3\u0002p\u0015=\u0003c\u0002B\n_\u0015ES1\f\t\t\u0003?+\u0019\"b\u0015\u0006XA!\u0011\u0011QC+\t\u001d\u0011\t,\u001ab\u0001\u0003\u000f\u0003B!!!\u0006Z\u00119!1T3C\u0002\u0005\u001d\u0005c\u0002B\nK\u0016MSq\u000b\t\t\u0003c\u0012\u0019(a \u0006T\u0005\u0019\u0001O\u00194\u0011\r\u0005ET\u0011FC))!)Y&\"\u001a\u0006h\u0015%\u0004b\u0002B[U\u0002\u0007QQ\f\u0005\b\u000b?R\u0007\u0019AC1\u0011\u001d!iE\u001ba\u0001\u0003G,\"!\"\u0015\u0015\t\u0005EWq\u000e\u0005\n\u0005Ca\u0017\u0011!a\u0001\u000b#B3!\u001cCD)\u0011\t\t.\"\u001e\t\u000f\u0011Me\u000e1\u0001\u0006xA1\u0011\u0011\u000fCL\u000b#\"B!b\u0017\u0006|!9!qN8A\u0002\u0011\u0005F\u0003BAi\u000b\u007fBqA!1q\u0001\u0004)YF\u0001\u0007TC6,W\t\\3nK:$8/\u0006\u0003\u0006\u0006\u001655#B9\u0002p\u0015\u001d\u0005c\u0002B\n[\t%R\u0011\u0012\t\u0006\u0005'\tX1\u0012\t\u0005\u0003\u0003+i\tB\u0004\u0003dF\u0014\rA!:\u0002\u0011=$\b.\u001a:qSR,\"!b%\u0011\r\u0005}\u0015Q]CF\u0003%yG\u000f[3sa&$\b\u0005\u0006\u0004\u0006\n\u0016eU1\u0014\u0005\b\t\u001b2\b\u0019AAr\u0011\u001d)yI\u001ea\u0001\u000b'#B!!5\u0006 \"I!\u0011\u0005=\u0002\u0002\u0003\u0007!\u0011\u0006\u0015\u0004s\u0012\u001dE\u0003BAi\u000bKCq\u0001b%{\u0001\u0004)9\u000b\u0005\u0004\u0002r\u0011]%\u0011\u0006\u000b\u0005\u0003\u0013+Y\u000bC\u0004\u0003pm\u0004\r\u0001\")\u0016\u0005\u0015=\u0006CBA^\u0003\u0003,\t\f\u0005\u0005\u0002 \u0012%&\u0011FCE)\u0011\t\t.\".\t\u000f\t\u0005W\u00101\u0001\u0006\n\n9Q\u000b\u001d3bi\u0016$WCBC^\u000b\u0007,9mE\u0003\u0000\u0003_*i\fE\u0004\u0003\u0014=*y,\"3\u0011\u0011\u0005}U1CCa\u000b\u000b\u0004B!!!\u0006D\u00129!1]@C\u0002\t\u0015\b\u0003BAA\u000b\u000f$qAa'\u0000\u0005\u0004\t9\tE\u0004\u0003\u0014},\t-\"2\u0011\u0011\u0005}UQZCa\u000b\u000bLA!b4\u0002^\ty1i\\7cS:,'OR1di>\u0014\u0018\u0010\u0006\u0006\u0006J\u0016MWQ[Cl\u000b3D\u0001\u0002b:\u0002\f\u0001\u0007\u0011q\u001f\u0005\t\u0007\u001b\nY\u00011\u0001\u0006B\"AQqLA\u0006\u0001\u0004)Y\r\u0003\u0005\u0005N\u0005-\u0001\u0019AAr+\t)y\f\u0006\u0003\u0002R\u0016}\u0007B\u0003B\u0011\u0003\u001f\t\t\u00111\u0001\u0006@\"\"\u0011\u0011\u0003CD)\u0011\t\t.\":\t\u0011\u0011M\u00151\u0003a\u0001\u000bO\u0004b!!\u001d\u0005\u0018\u0016}F\u0003BAE\u000bWD\u0001Ba\u001c\u0002\u0016\u0001\u0007A\u0011U\u000b\u0003\u000b_\u0004b!a/\u0002B\u0016E\b\u0003CAP\tS+y,\"3\u0015\t\u0005EWQ\u001f\u0005\t\u0005\u0003\fI\u00021\u0001\u0006J\n\u0019!,\u001b9\u0016\u0011\u0015mhQ\u0001D\u0005\r\u001b\u0019b!!\b\u0002p\u0015u\bc\u0002B\n_\u0015}hq\u0002\t\t\u0003?+\u0019B\"\u0001\u0007\fAA\u0011\u0011OBT\r\u000719\u0001\u0005\u0003\u0002\u0002\u001a\u0015A\u0001\u0003Br\u0003;\u0011\rA!:\u0011\t\u0005\u0005e\u0011\u0002\u0003\t\u0005c\u000biB1\u0001\u0002\bB!\u0011\u0011\u0011D\u0007\t!\u0011Y*!\bC\u0002\u0005\u001d\u0005C\u0003B\n\u0003;1\u0019Ab\u0002\u0007\f\u0005\u00111M\u001a\t\t\u0003?+iM\"\u0001\u0007\fU\u0011aq\u0003\t\u0007\u0003?\u000b)Ob\u0002\u0015\u0015\u0019=a1\u0004D\u000f\r?1\t\u0003\u0003\u0005\u0004\u0012\u0006-\u0002\u0019AA|\u0011!1\t\"a\u000bA\u0002\u0019M\u0001\u0002\u0003C'\u0003W\u0001\r!a9\t\u0011\u0015=\u00151\u0006a\u0001\r/)\"A\"\n\u0011\t\u0019\u001db\u0011F\u0007\u0003\u0003;IAAb\u000b\u0005*\n1!+Z:vYR$B!!5\u00070!Q!\u0011EA\u0018\u0003\u0003\u0005\rA\"\n)\t\u0005EBq\u0011\u000b\u0005\u0003#4)\u0004\u0003\u0005\u0005\u0014\u0006M\u0002\u0019\u0001D\u001c!\u0019\t\t\bb&\u0007&Q!\u0011\u0011\u0012D\u001e\u0011!\u0011y'!\u000eA\u0002\u0011\u0005VC\u0001D !\u0019\tIHa\u0011\u0007\u0010Q!\u0011\u0011\u001bD\"\u0011!\u0011\t-!\u000fA\u0002\u0019=!aC\"peJ,7\u000f]8oIN,BA\"\u0013\u0007RM1\u00111HA8\r\u0017\u0002rAa\u0005.\u0005S1i\u0005\u0005\u0004\u0003\u0014\u0005mbq\n\t\u0005\u0003\u00033\t\u0006\u0002\u0005\u00032\u0006m\"\u0019AAD\u0003\u0011\u0019wN\u001d:\u0011\u0015\u0005E41YA@\r\u001f\u0012I#\u0006\u0002\u0007ZA1\u0011qTAs\r\u001f\"\u0002B\"\u0014\u0007^\u0019}c\u0011\r\u0005\t\r'\n9\u00051\u0001\u0007V!AAQJA$\u0001\u0004\t\u0019\u000f\u0003\u0005\u0006\u0010\u0006\u001d\u0003\u0019\u0001D-)\u0011\t\tN\"\u001a\t\u0015\t\u0005\u00121JA\u0001\u0002\u0004\u0011I\u0003\u000b\u0003\u0002N\u0011\u001dE\u0003BAi\rWB\u0001\u0002b%\u0002P\u0001\u0007Qq\u0015\u000b\u0005\u0003\u00133y\u0007\u0003\u0005\u0003p\u0005E\u0003\u0019\u0001CQ+\t1\u0019\b\u0005\u0004\u0002<\u0006\u0005gQ\u000f\t\t\u0003?#IK!\u000b\u0007NQ!\u0011\u0011\u001bD=\u0011!\u0011\t-!\u0016A\u0002\u00195\u0013!C:va\u0016\u0014HE_5q+!1yHb$\u0007\u0014\u001a\u0015E\u0003\u0002DA\r+#BAb!\u0007\bB!\u0011\u0011\u0011DC\t!\u0011Y*!\u0017C\u0002\u0005\u001d\u0005\u0002\u0003BP\u00033\u0002\u001dA\"#\u0011\u0015\t\r&\u0011VAK\r\u00173\u0019\t\u0005\u0005\u0002r\r\u001dfQ\u0012DI!\u0011\t\tIb$\u0005\u0011\t\r\u0018\u0011\fb\u0001\u0005K\u0004B!!!\u0007\u0014\u0012A!\u0011WA-\u0005\u0004\t9\t\u0003\u0005\u0003B\u0006e\u0003\u0019\u0001DL!\u0019\tIHa7\u0007\u0012&!1QSAT\u0001")
public interface ParSeqLike<T, Repr extends ParSeq<T>, Sequential extends Seq<T> & SeqLike<T, Sequential>>
extends GenSeqLike<T, Repr>,
ParIterableLike<T, Repr, Sequential> {
    public /* synthetic */ Object scala$collection$parallel$ParSeqLike$$super$zip(GenIterable var1, CanBuildFrom var2);

    @Override
    public SeqSplitter<T> splitter();

    public static /* synthetic */ PreciseSplitter iterator$(ParSeqLike $this) {
        return $this.iterator();
    }

    @Override
    default public PreciseSplitter<T> iterator() {
        return this.splitter();
    }

    public static /* synthetic */ int size$(ParSeqLike $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        return this.length();
    }

    public static /* synthetic */ int segmentLength$(ParSeqLike $this, Function1 p, int from) {
        return $this.segmentLength(p, from);
    }

    @Override
    default public int segmentLength(Function1<T, Object> p, int from) {
        if (from >= this.length()) {
            return 0;
        }
        int realfrom = from < 0 ? 0 : from;
        AtomicIndexFlag ctx = new AtomicIndexFlag(null){
            private final AtomicInteger scala$collection$generic$AtomicIndexFlag$$intflag;

            public int indexFlag() {
                return AtomicIndexFlag.indexFlag$(this);
            }

            public void setIndexFlag(int f) {
                AtomicIndexFlag.setIndexFlag$(this, f);
            }

            public void setIndexFlagIfGreater(int f) {
                AtomicIndexFlag.setIndexFlagIfGreater$(this, f);
            }

            public void setIndexFlagIfLesser(int f) {
                AtomicIndexFlag.setIndexFlagIfLesser$(this, f);
            }

            public AtomicInteger scala$collection$generic$AtomicIndexFlag$$intflag() {
                return this.scala$collection$generic$AtomicIndexFlag$$intflag;
            }

            public final void scala$collection$generic$AtomicIndexFlag$_setter_$scala$collection$generic$AtomicIndexFlag$$intflag_$eq(AtomicInteger x$1) {
                this.scala$collection$generic$AtomicIndexFlag$$intflag = x$1;
            }
            {
                AtomicIndexFlag.$init$(this);
            }
        };
        ctx.setIndexFlag(Integer.MAX_VALUE);
        return this.tasksupport().executeAndWaitResult(new SegmentLength(this, p, 0, (SeqSplitter)this.delegatedSignalling2ops((DelegatedSignalling)this.splitter().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{realfrom, this.length() - realfrom})).apply(true)).assign(ctx)))._1$mcI$sp();
    }

    public static /* synthetic */ int indexWhere$(ParSeqLike $this, Function1 p, int from) {
        return $this.indexWhere(p, from);
    }

    @Override
    default public int indexWhere(Function1<T, Object> p, int from) {
        if (from >= this.length()) {
            return -1;
        }
        int realfrom = from < 0 ? 0 : from;
        AtomicIndexFlag ctx = new AtomicIndexFlag(null){
            private final AtomicInteger scala$collection$generic$AtomicIndexFlag$$intflag;

            public int indexFlag() {
                return AtomicIndexFlag.indexFlag$(this);
            }

            public void setIndexFlag(int f) {
                AtomicIndexFlag.setIndexFlag$(this, f);
            }

            public void setIndexFlagIfGreater(int f) {
                AtomicIndexFlag.setIndexFlagIfGreater$(this, f);
            }

            public void setIndexFlagIfLesser(int f) {
                AtomicIndexFlag.setIndexFlagIfLesser$(this, f);
            }

            public AtomicInteger scala$collection$generic$AtomicIndexFlag$$intflag() {
                return this.scala$collection$generic$AtomicIndexFlag$$intflag;
            }

            public final void scala$collection$generic$AtomicIndexFlag$_setter_$scala$collection$generic$AtomicIndexFlag$$intflag_$eq(AtomicInteger x$1) {
                this.scala$collection$generic$AtomicIndexFlag$$intflag = x$1;
            }
            {
                AtomicIndexFlag.$init$(this);
            }
        };
        ctx.setIndexFlag(Integer.MAX_VALUE);
        return BoxesRunTime.unboxToInt(this.tasksupport().executeAndWaitResult(new IndexWhere(this, p, realfrom, (SeqSplitter)this.delegatedSignalling2ops((DelegatedSignalling)this.splitter().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{realfrom, this.length() - realfrom})).apply(true)).assign(ctx))));
    }

    public static /* synthetic */ int lastIndexWhere$(ParSeqLike $this, Function1 p, int end) {
        return $this.lastIndexWhere(p, end);
    }

    @Override
    default public int lastIndexWhere(Function1<T, Object> p, int end) {
        if (end < 0) {
            return -1;
        }
        int until = end >= this.length() ? this.length() : end + 1;
        AtomicIndexFlag ctx = new AtomicIndexFlag(null){
            private final AtomicInteger scala$collection$generic$AtomicIndexFlag$$intflag;

            public int indexFlag() {
                return AtomicIndexFlag.indexFlag$(this);
            }

            public void setIndexFlag(int f) {
                AtomicIndexFlag.setIndexFlag$(this, f);
            }

            public void setIndexFlagIfGreater(int f) {
                AtomicIndexFlag.setIndexFlagIfGreater$(this, f);
            }

            public void setIndexFlagIfLesser(int f) {
                AtomicIndexFlag.setIndexFlagIfLesser$(this, f);
            }

            public AtomicInteger scala$collection$generic$AtomicIndexFlag$$intflag() {
                return this.scala$collection$generic$AtomicIndexFlag$$intflag;
            }

            public final void scala$collection$generic$AtomicIndexFlag$_setter_$scala$collection$generic$AtomicIndexFlag$$intflag_$eq(AtomicInteger x$1) {
                this.scala$collection$generic$AtomicIndexFlag$$intflag = x$1;
            }
            {
                AtomicIndexFlag.$init$(this);
            }
        };
        ctx.setIndexFlag(Integer.MIN_VALUE);
        return BoxesRunTime.unboxToInt(this.tasksupport().executeAndWaitResult(new LastIndexWhere(this, p, 0, (SeqSplitter)this.delegatedSignalling2ops((DelegatedSignalling)this.splitter().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{until, this.length() - until})).apply(false)).assign(ctx))));
    }

    public static /* synthetic */ ParSeq reverse$(ParSeqLike $this) {
        return $this.reverse();
    }

    @Override
    default public Repr reverse() {
        return (Repr)((ParSeq)this.tasksupport().executeAndWaitResult(this.task2ops(new Reverse(this, (Function0<Combiner> & java.io.Serializable & Serializable)() -> this.newCombiner(), this.splitter())).mapResult((Function1<Combiner, ParSeq> & java.io.Serializable & Serializable)x$4 -> (ParSeq)x$4.resultWithTaskSupport())));
    }

    public static /* synthetic */ Object reverseMap$(ParSeqLike $this, Function1 f, CanBuildFrom bf) {
        return $this.reverseMap(f, bf);
    }

    @Override
    default public <S, That> That reverseMap(Function1<T, S> f, CanBuildFrom<Repr, S, That> bf) {
        if (this.builder2ops(bf.apply(this.repr())).isCombiner()) {
            return (That)this.tasksupport().executeAndWaitResult(this.task2ops(new ReverseMap(this, f, (Function0<Combiner> & java.io.Serializable & Serializable)() -> this.builder2ops(bf.apply(this.repr())).asCombiner(), this.splitter())).mapResult((Function1<Combiner, Object> & java.io.Serializable & Serializable)x$5 -> x$5.resultWithTaskSupport()));
        }
        return package$.MODULE$.setTaskSupport(((SeqLike)this.seq()).reverseMap(f, this.bf2seq(bf)), this.tasksupport());
    }

    public static /* synthetic */ boolean startsWith$(ParSeqLike $this, GenSeq that, int offset) {
        return $this.startsWith(that, offset);
    }

    @Override
    default public <S> boolean startsWith(GenSeq<S> that, int offset) {
        return BoxesRunTime.unboxToBoolean(ParallelCollectionImplicits$.MODULE$.traversable2ops(that).ifParSeq((Function1<ParSeq, Object> & java.io.Serializable & Serializable)pthat -> BoxesRunTime.boxToBoolean(ParSeqLike.$anonfun$startsWith$1(this, offset, pthat))).otherwise((JFunction0$mcZ$sp & Serializable)() -> ((SeqLike)this.seq()).startsWith(that, offset)));
    }

    public static /* synthetic */ boolean sameElements$(ParSeqLike $this, GenIterable that) {
        return $this.sameElements(that);
    }

    @Override
    default public <U> boolean sameElements(GenIterable<U> that) {
        return BoxesRunTime.unboxToBoolean(ParallelCollectionImplicits$.MODULE$.traversable2ops(that).ifParSeq((Function1<ParSeq, Object> & java.io.Serializable & Serializable)pthat -> BoxesRunTime.boxToBoolean(ParSeqLike.$anonfun$sameElements$1(this, pthat))).otherwise((JFunction0$mcZ$sp & Serializable)() -> this.seq().sameElements(that)));
    }

    public static /* synthetic */ boolean endsWith$(ParSeqLike $this, GenSeq that) {
        return $this.endsWith(that);
    }

    @Override
    default public <S> boolean endsWith(GenSeq<S> that) {
        return BoxesRunTime.unboxToBoolean(ParallelCollectionImplicits$.MODULE$.traversable2ops(that).ifParSeq((Function1<ParSeq, Object> & java.io.Serializable & Serializable)pthat -> BoxesRunTime.boxToBoolean(ParSeqLike.$anonfun$endsWith$1(this, that, pthat))).otherwise((JFunction0$mcZ$sp & Serializable)() -> ((SeqLike)this.seq()).endsWith(that)));
    }

    public static /* synthetic */ Object patch$(ParSeqLike $this, int from, GenSeq patch, int replaced, CanBuildFrom bf) {
        return $this.patch(from, patch, replaced, bf);
    }

    @Override
    default public <U, That> That patch(int from, GenSeq<U> patch, int replaced, CanBuildFrom<Repr, U, That> bf) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int realreplaced = RichInt$.MODULE$.min$extension(replaced, this.length() - from);
        if (ParallelCollectionImplicits$.MODULE$.traversable2ops(patch).isParSeq() && this.builder2ops(bf.apply(this.repr())).isCombiner() && this.size() - realreplaced + patch.size() > package$.MODULE$.MIN_FOR_COPY()) {
            ParSeq that = ParallelCollectionImplicits$.MODULE$.traversable2ops(patch).asParSeq();
            Seq<SeqSplitter<T>> pits = this.splitter().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{from, replaced, this.length() - from - realreplaced}));
            CombinerFactory cfactory = this.combinerFactory((Function0<Combiner> & java.io.Serializable & Serializable)() -> this.builder2ops(bf.apply(this.repr())).asCombiner());
            ParIterableLike.Copy copystart = new ParIterableLike.Copy(this, cfactory, (IterableSplitter)pits.apply(false));
            ParIterableLike.NonDivisible copymiddle = this.wrap((Function0<Combiner> & java.io.Serializable & Serializable)() -> {
                ParIterableLike.Copy tsk = new ParIterableLike.Copy(that, cfactory, that.splitter());
                return (Combiner)this.tasksupport().executeAndWaitResult(tsk);
            });
            ParIterableLike.Copy copyend = new ParIterableLike.Copy(this, cfactory, (IterableSplitter)pits.apply(2));
            return (That)this.tasksupport().executeAndWaitResult(this.task2ops(this.task2ops(this.task2ops(copystart).parallel(copymiddle, (Function2<Combiner, Combiner, Combiner> & java.io.Serializable & Serializable)(x$6, x$7) -> x$6.combine(x$7))).parallel(copyend, (Function2<Combiner, Combiner, Combiner> & java.io.Serializable & Serializable)(x$8, x$9) -> x$8.combine(x$9))).mapResult((Function1<Combiner, Object> & java.io.Serializable & Serializable)x$10 -> x$10.resultWithTaskSupport()));
        }
        return this.patch_sequential(from, patch.seq(), replaced, bf);
    }

    private <U, That> That patch_sequential(int fromarg, Seq<U> patch, int r, CanBuildFrom<Repr, U, That> bf) {
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int from = RichInt$.MODULE$.max$extension(n, fromarg);
        Builder<U, That> b = bf.apply(this.repr());
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int n2 = RichInt$.MODULE$.min$extension(r, this.length() - from);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int repl = RichInt$.MODULE$.max$extension(n2, 0);
        Seq<SeqSplitter<T>> pits = this.splitter().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{from, repl, this.length() - from - repl}));
        b.$plus$plus$eq((TraversableOnce)pits.apply(false));
        b.$plus$plus$eq(patch);
        b.$plus$plus$eq((TraversableOnce)pits.apply(2));
        return package$.MODULE$.setTaskSupport(b.result(), this.tasksupport());
    }

    public static /* synthetic */ Object updated$(ParSeqLike $this, int index, Object elem, CanBuildFrom bf) {
        return $this.updated(index, (U)elem, bf);
    }

    @Override
    default public <U, That> That updated(int index, U elem, CanBuildFrom<Repr, U, That> bf) {
        if (this.builder2ops(bf.apply(this.repr())).isCombiner()) {
            return (That)this.tasksupport().executeAndWaitResult(this.task2ops(new Updated(this, index, elem, this.combinerFactory((Function0<Combiner> & java.io.Serializable & Serializable)() -> this.builder2ops(bf.apply(this.repr())).asCombiner()), this.splitter())).mapResult((Function1<Combiner, Object> & java.io.Serializable & Serializable)x$11 -> x$11.resultWithTaskSupport()));
        }
        return package$.MODULE$.setTaskSupport(((SeqLike)this.seq()).updated(index, elem, this.bf2seq(bf)), this.tasksupport());
    }

    public static /* synthetic */ Object $plus$colon$(ParSeqLike $this, Object elem, CanBuildFrom bf) {
        return $this.$plus$colon((U)elem, bf);
    }

    @Override
    default public <U, That> That $plus$colon(U elem, CanBuildFrom<Repr, U, That> bf) {
        return this.patch(0, (GenSeq)ParArray$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{elem})), 0, bf);
    }

    public static /* synthetic */ Object $colon$plus$(ParSeqLike $this, Object elem, CanBuildFrom bf) {
        return $this.$colon$plus((U)elem, bf);
    }

    @Override
    default public <U, That> That $colon$plus(U elem, CanBuildFrom<Repr, U, That> bf) {
        return this.patch(this.length(), (GenSeq)ParArray$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{elem})), 0, bf);
    }

    public static /* synthetic */ Object padTo$(ParSeqLike $this, int len, Object elem, CanBuildFrom bf) {
        return $this.padTo(len, (U)elem, bf);
    }

    @Override
    default public <U, That> That padTo(int len, U elem, CanBuildFrom<Repr, U, That> bf) {
        if (this.length() < len) {
            return this.patch(this.length(), (GenSeq<U>)new Repetition<U>(elem, len - this.length()), 0, bf);
        }
        return this.patch(this.length(), Nil$.MODULE$, 0, bf);
    }

    public static /* synthetic */ Object zip$(ParSeqLike $this, GenIterable that, CanBuildFrom bf) {
        return $this.zip(that, bf);
    }

    @Override
    default public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<Repr, Tuple2<U, S>, That> bf) {
        if (this.builder2ops(bf.apply(this.repr())).isCombiner() && ParallelCollectionImplicits$.MODULE$.traversable2ops(that).isParSeq()) {
            ParSeq<S> thatseq = ParallelCollectionImplicits$.MODULE$.traversable2ops(that).asParSeq();
            int n = this.length();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return (That)this.tasksupport().executeAndWaitResult(this.task2ops(new Zip(this, RichInt$.MODULE$.min$extension(n, thatseq.length()), this.combinerFactory((Function0<Combiner> & java.io.Serializable & Serializable)() -> this.builder2ops(bf.apply(this.repr())).asCombiner()), this.splitter(), thatseq.splitter())).mapResult((Function1<Combiner, Object> & java.io.Serializable & Serializable)x$12 -> x$12.resultWithTaskSupport()));
        }
        return (That)this.scala$collection$parallel$ParSeqLike$$super$zip(that, bf);
    }

    public static /* synthetic */ boolean corresponds$(ParSeqLike $this, GenSeq that, Function2 p) {
        return $this.corresponds(that, p);
    }

    @Override
    default public <S> boolean corresponds(GenSeq<S> that, Function2<T, S, Object> p) {
        return BoxesRunTime.unboxToBoolean(ParallelCollectionImplicits$.MODULE$.traversable2ops(that).ifParSeq((Function1<ParSeq, Object> & java.io.Serializable & Serializable)pthat -> BoxesRunTime.boxToBoolean(ParSeqLike.$anonfun$corresponds$1(this, p, pthat))).otherwise((JFunction0$mcZ$sp & Serializable)() -> ((SeqLike)this.seq()).corresponds(that, p)));
    }

    public static /* synthetic */ ParSeq diff$(ParSeqLike $this, GenSeq that) {
        return $this.diff(that);
    }

    @Override
    default public <U> Repr diff(GenSeq<U> that) {
        return (Repr)((ParSeq)this.sequentially((Function1<Seq, Seq> & java.io.Serializable & Serializable)x$13 -> (Seq)x$13.diff(that)));
    }

    public static /* synthetic */ ParSeq intersect$(ParSeqLike $this, GenSeq that) {
        return $this.intersect(that);
    }

    @Override
    default public <U> Repr intersect(GenSeq<U> that) {
        return (Repr)((ParSeq)this.sequentially((Function1<Seq, Seq> & java.io.Serializable & Serializable)x$14 -> (Seq)x$14.intersect(that)));
    }

    public static /* synthetic */ ParSeq distinct$(ParSeqLike $this) {
        return $this.distinct();
    }

    @Override
    default public Repr distinct() {
        return (Repr)((ParSeq)this.sequentially((Function1<Seq, Seq> & java.io.Serializable & Serializable)x$15 -> (Seq)x$15.distinct()));
    }

    public static /* synthetic */ String toString$(ParSeqLike $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        return this.seq().mkString(new java.lang.StringBuilder(1).append(this.stringPrefix()).append("(").toString(), ", ", ")");
    }

    public static /* synthetic */ ParSeq toSeq$(ParSeqLike $this) {
        return $this.toSeq();
    }

    @Override
    default public ParSeq<T> toSeq() {
        return (ParSeq)this;
    }

    public static /* synthetic */ SeqView view$(ParSeqLike $this) {
        return $this.view();
    }

    @Override
    default public SeqView<T, Sequential> view() {
        return ((SeqLike)this.seq()).view();
    }

    public static /* synthetic */ SeqSplitter down$(ParSeqLike $this, IterableSplitter p) {
        return $this.down(p);
    }

    default public SeqSplitter<T> down(IterableSplitter<?> p) {
        return (SeqSplitter)p;
    }

    public static /* synthetic */ boolean $anonfun$startsWith$1(ParSeqLike $this, int offset$1, ParSeq pthat) {
        if (offset$1 < 0 || offset$1 >= $this.length()) {
            return offset$1 == $this.length() && pthat.length() == 0;
        }
        if (pthat.length() == 0) {
            return true;
        }
        if (pthat.length() > $this.length() - offset$1) {
            return false;
        }
        DefaultSignalling ctx = new DefaultSignalling(null){};
        return BoxesRunTime.unboxToBoolean($this.tasksupport().executeAndWaitResult(new SameElements($this, (SeqSplitter)$this.delegatedSignalling2ops((DelegatedSignalling)$this.splitter().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{offset$1, pthat.length()})).apply(true)).assign(ctx), pthat.splitter())));
    }

    public static /* synthetic */ boolean $anonfun$sameElements$1(ParSeqLike $this, ParSeq pthat) {
        DefaultSignalling ctx = new DefaultSignalling(null){};
        return $this.length() == pthat.length() && BoxesRunTime.unboxToBoolean($this.tasksupport().executeAndWaitResult(new SameElements($this, $this.delegatedSignalling2ops($this.splitter()).assign(ctx), pthat.splitter())));
    }

    public static /* synthetic */ boolean $anonfun$endsWith$1(ParSeqLike $this, GenSeq that$3, ParSeq pthat) {
        if (that$3.length() == 0) {
            return true;
        }
        if (that$3.length() > $this.length()) {
            return false;
        }
        DefaultSignalling ctx = new DefaultSignalling(null){};
        int tlen = that$3.length();
        return BoxesRunTime.unboxToBoolean($this.tasksupport().executeAndWaitResult(new SameElements($this, (SeqSplitter)$this.delegatedSignalling2ops((DelegatedSignalling)$this.splitter().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{$this.length() - tlen, tlen})).apply(true)).assign(ctx), pthat.splitter())));
    }

    public static /* synthetic */ boolean $anonfun$corresponds$1(ParSeqLike $this, Function2 p$1, ParSeq pthat) {
        DefaultSignalling ctx = new DefaultSignalling(null){};
        return $this.length() == pthat.length() && BoxesRunTime.unboxToBoolean($this.tasksupport().executeAndWaitResult(new Corresponds($this, p$1, $this.delegatedSignalling2ops($this.splitter()).assign(ctx), pthat.splitter())));
    }

    public static void $init$(ParSeqLike $this) {
    }

    public interface Accessor<R, Tp>
    extends ParIterableLike.Accessor<R, Tp> {
        @Override
        public SeqSplitter<T> pit();
    }

    public class Corresponds<S>
    implements Accessor<Object, Corresponds<S>> {
        private final Function2<T, S, Object> corr;
        private final SeqSplitter<T> pit;
        private final SeqSplitter<S> otherpit;
        private volatile boolean result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Object> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        public SeqSplitter<S> otherpit() {
            return this.otherpit;
        }

        @Override
        public boolean result() {
            return this.result;
        }

        @Override
        public void result_$eq(boolean x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Object> prev) {
            if (!this.pit().isAborted()) {
                this.result_$eq(this.pit().corresponds(this.corr, this.otherpit()));
                if (!this.result()) {
                    this.pit().abort();
                    return;
                }
            }
        }

        public Nothing$ newSubtask(IterableSplitter<T> p) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Seq<Task<Object, Corresponds<S>>> split() {
            int fp = this.pit().remaining() / 2;
            int sp2 = this.pit().remaining() - fp;
            return ((TraversableLike)this.pit().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{fp, sp2})).zip(this.otherpit().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{fp, sp2})), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$7 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$7 != null)).map((Function1<Tuple2, Corresponds> & java.io.Serializable & Serializable)x$29 -> {
                if (x$29 == null) {
                    throw new MatchError((Object)null);
                }
                SeqSplitter p = (SeqSplitter)x$29._1();
                SeqSplitter op = (SeqSplitter)x$29._2();
                Corresponds corresponds = new Corresponds(this.scala$collection$parallel$ParSeqLike$Corresponds$$$outer(), $this.corr, p, op);
                return corresponds;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public void merge(Corresponds<S> that) {
            this.result_$eq(this.result() && that.result());
        }

        @Override
        public boolean requiresStrictSplitters() {
            return true;
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$Corresponds$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Corresponds$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Corresponds$$$outer();
        }

        public Corresponds(ParSeqLike $outer, Function2<T, S, Object> corr, SeqSplitter<T> pit, SeqSplitter<S> otherpit) {
            this.corr = corr;
            this.pit = pit;
            this.otherpit = otherpit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = true;
        }
    }

    public abstract class Elements
    implements SeqSplitter<T>,
    BufferedIterator<T> {
        public final int scala$collection$parallel$ParSeqLike$Elements$$start;
        private final int end;
        private int scala$collection$parallel$ParSeqLike$Elements$$i;
        private Signalling signalDelegate;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public Option<T> headOption() {
            return BufferedIterator.headOption$(this);
        }

        @Override
        public BufferedIterator<T> buffered() {
            return BufferedIterator.buffered$(this);
        }

        @Override
        public Seq<SeqSplitter<T>> splitWithSignalling() {
            return SeqSplitter.splitWithSignalling$(this);
        }

        @Override
        public Seq<SeqSplitter<T>> psplitWithSignalling(Seq<Object> sizes) {
            return SeqSplitter.psplitWithSignalling$(this, sizes);
        }

        @Override
        public SeqSplitter.Taken newTaken(int until) {
            return SeqSplitter.newTaken$(this, until);
        }

        @Override
        public SeqSplitter<T> take(int n) {
            return SeqSplitter.take$(this, n);
        }

        @Override
        public SeqSplitter<T> slice(int from1, int until1) {
            return SeqSplitter.slice$(this, from1, until1);
        }

        @Override
        public <S> SeqSplitter.Mapped<S> map(Function1<T, S> f) {
            return SeqSplitter.map$(this, f);
        }

        @Override
        public <U, PI extends SeqSplitter<U>> SeqSplitter.Appended<U, PI> appendParSeq(PI that) {
            return SeqSplitter.appendParSeq$(this, that);
        }

        @Override
        public <S> SeqSplitter.Zipped<S> zipParSeq(SeqSplitter<S> that) {
            return SeqSplitter.zipParSeq$(this, that);
        }

        @Override
        public <S, U, R> SeqSplitter.ZippedAll<U, R> zipAllParSeq(SeqSplitter<S> that, U thisElem, R thatElem) {
            return SeqSplitter.zipAllParSeq$(this, that, thisElem, thatElem);
        }

        @Override
        public SeqSplitter<T> reverse() {
            return SeqSplitter.reverse$(this);
        }

        @Override
        public <U> SeqSplitter.Patched<U> patchParSeq(int from, SeqSplitter<U> patchElems, int replaced) {
            return SeqSplitter.patchParSeq$(this, from, patchElems, replaced);
        }

        @Override
        public int prefixLength(Function1<T, Object> pred) {
            return AugmentedSeqIterator.prefixLength$(this, pred);
        }

        @Override
        public int indexWhere(Function1<T, Object> pred) {
            return AugmentedSeqIterator.indexWhere$(this, pred);
        }

        @Override
        public int lastIndexWhere(Function1<T, Object> pred) {
            return AugmentedSeqIterator.lastIndexWhere$(this, pred);
        }

        @Override
        public <S> boolean corresponds(Function2<T, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        @Override
        public <S, That> Combiner<S, That> reverseMap2combiner(Function1<T, S> f, Combiner<S, That> cb) {
            return AugmentedSeqIterator.reverseMap2combiner$(this, f, cb);
        }

        @Override
        public <U, That> Combiner<U, That> updated2combiner(int index, U elem, Combiner<U, That> cb) {
            return AugmentedSeqIterator.updated2combiner$(this, index, elem, cb);
        }

        @Override
        public <S> boolean shouldSplitFurther(ParIterable<S> coll, int parallelismLevel) {
            return IterableSplitter.shouldSplitFurther$(this, coll, parallelismLevel);
        }

        @Override
        public String buildString(Function1<Function1<String, BoxedUnit>, BoxedUnit> closure) {
            return IterableSplitter.buildString$(this, closure);
        }

        @Override
        public String debugInformation() {
            return IterableSplitter.debugInformation$(this);
        }

        @Override
        public <U extends IterableSplitter.Taken> U newSliceInternal(U it, int from1) {
            return (U)IterableSplitter.newSliceInternal$(this, it, from1);
        }

        @Override
        public IterableSplitter<T> drop(int n) {
            return IterableSplitter.drop$(this, n);
        }

        @Override
        public <U, PI extends IterableSplitter<U>> IterableSplitter.Appended<U, PI> appendParIterable(PI that) {
            return IterableSplitter.appendParIterable$(this, that);
        }

        @Override
        public boolean isAborted() {
            return DelegatedSignalling.isAborted$(this);
        }

        @Override
        public void abort() {
            DelegatedSignalling.abort$(this);
        }

        @Override
        public int indexFlag() {
            return DelegatedSignalling.indexFlag$(this);
        }

        @Override
        public void setIndexFlag(int f) {
            DelegatedSignalling.setIndexFlag$(this, f);
        }

        @Override
        public void setIndexFlagIfGreater(int f) {
            DelegatedSignalling.setIndexFlagIfGreater$(this, f);
        }

        @Override
        public void setIndexFlagIfLesser(int f) {
            DelegatedSignalling.setIndexFlagIfLesser$(this, f);
        }

        @Override
        public int tag() {
            return DelegatedSignalling.tag$(this);
        }

        @Override
        public int count(Function1<T, Object> p) {
            return AugmentedIterableIterator.count$(this, p);
        }

        @Override
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.fold$(this, z, op);
        }

        @Override
        public <U> U sum(Numeric<U> num) {
            return (U)AugmentedIterableIterator.sum$(this, num);
        }

        @Override
        public <U> U product(Numeric<U> num) {
            return (U)AugmentedIterableIterator.product$(this, num);
        }

        @Override
        public <U> T min(Ordering<U> ord) {
            return AugmentedIterableIterator.min$(this, ord);
        }

        @Override
        public <U> T max(Ordering<U> ord) {
            return AugmentedIterableIterator.max$(this, ord);
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            AugmentedIterableIterator.copyToArray$(this, array, from, len);
        }

        @Override
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
        }

        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<T, S> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.map2combiner$(this, f, cb);
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<T, S> pf, Combiner<S, That> cb) {
            return AugmentedIterableIterator.collect2combiner$(this, pf, cb);
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<T, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            return AugmentedIterableIterator.flatmap2combiner$(this, f, cb);
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld b) {
            return (Bld)AugmentedIterableIterator.copy2builder$(this, b);
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filter2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            return AugmentedIterableIterator.filterNot2combiner$(this, pred, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<T, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            return AugmentedIterableIterator.partition2combiners$(this, pred, btrue, bfalse);
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.take2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            return AugmentedIterableIterator.drop2combiner$(this, n, cb);
        }

        @Override
        public <U, This> Combiner<U, This> slice2combiner(int from, int until, Combiner<U, This> cb) {
            return AugmentedIterableIterator.slice2combiner$(this, from, until, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> splitAt2combiners(int at, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.splitAt2combiners$(this, at, before, after);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Object> takeWhile2combiner(Function1<T, Object> p, Combiner<U, This> cb) {
            return AugmentedIterableIterator.takeWhile2combiner$(this, p, cb);
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> span2combiners(Function1<T, Object> p, Combiner<U, This> before, Combiner<U, This> after) {
            return AugmentedIterableIterator.span2combiners$(this, p, before, after);
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object array, int from) {
            AugmentedIterableIterator.scanToArray$(this, z, op, array, from);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, startValue, op, cb);
        }

        @Override
        public <U, That> Combiner<U, That> scanToCombiner(int howmany, U startValue, Function2<U, U, U> op, Combiner<U, That> cb) {
            return AugmentedIterableIterator.scanToCombiner$(this, howmany, startValue, op, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zip2combiner(RemainsIterator<S> otherpit, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zip2combiner$(this, otherpit, cb);
        }

        @Override
        public <U, S, That> Combiner<Tuple2<U, S>, That> zipAll2combiner(RemainsIterator<S> that, U thiselem, S thatelem, Combiner<Tuple2<U, S>, That> cb) {
            return AugmentedIterableIterator.zipAll2combiner$(this, that, thiselem, thatelem, cb);
        }

        @Override
        public boolean isRemainingCheap() {
            return RemainsIterator.isRemainingCheap$(this);
        }

        @Override
        public Iterator<T> seq() {
            return Iterator.seq$(this);
        }

        @Override
        public boolean isEmpty() {
            return Iterator.isEmpty$(this);
        }

        @Override
        public boolean isTraversableAgain() {
            return Iterator.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return Iterator.hasDefiniteSize$(this);
        }

        @Override
        public Iterator<T> sliceIterator(int from, int until) {
            return Iterator.sliceIterator$(this, from, until);
        }

        @Override
        public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
            return Iterator.$plus$plus$(this, that);
        }

        @Override
        public <B> Iterator<B> flatMap(Function1<T, GenTraversableOnce<B>> f) {
            return Iterator.flatMap$(this, f);
        }

        @Override
        public Iterator<T> filter(Function1<T, Object> p) {
            return Iterator.filter$(this, p);
        }

        @Override
        public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<T, B, Object> p) {
            return Iterator.corresponds$(this, that, p);
        }

        @Override
        public Iterator<T> withFilter(Function1<T, Object> p) {
            return Iterator.withFilter$(this, p);
        }

        @Override
        public Iterator<T> filterNot(Function1<T, Object> p) {
            return Iterator.filterNot$(this, p);
        }

        @Override
        public <B> Iterator<B> collect(PartialFunction<T, B> pf) {
            return Iterator.collect$(this, pf);
        }

        @Override
        public <B> Iterator<B> scanLeft(B z, Function2<B, T, B> op) {
            return Iterator.scanLeft$(this, z, op);
        }

        @Override
        public <B> Iterator<B> scanRight(B z, Function2<T, B, B> op) {
            return Iterator.scanRight$(this, z, op);
        }

        @Override
        public Iterator<T> takeWhile(Function1<T, Object> p) {
            return Iterator.takeWhile$(this, p);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> partition(Function1<T, Object> p) {
            return Iterator.partition$(this, p);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> span(Function1<T, Object> p) {
            return Iterator.span$(this, p);
        }

        @Override
        public Iterator<T> dropWhile(Function1<T, Object> p) {
            return Iterator.dropWhile$(this, p);
        }

        @Override
        public <B> Iterator<Tuple2<T, B>> zip(Iterator<B> that) {
            return Iterator.zip$(this, that);
        }

        @Override
        public <A1> Iterator<A1> padTo(int len, A1 elem) {
            return Iterator.padTo$(this, len, elem);
        }

        @Override
        public Iterator<Tuple2<T, Object>> zipWithIndex() {
            return Iterator.zipWithIndex$(this);
        }

        @Override
        public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
            return Iterator.zipAll$(this, that, thisElem, thatElem);
        }

        @Override
        public <U> void foreach(Function1<T, U> f) {
            Iterator.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<T, Object> p) {
            return Iterator.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<T, Object> p) {
            return Iterator.exists$(this, p);
        }

        @Override
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
        }

        @Override
        public Option<T> find(Function1<T, Object> p) {
            return Iterator.find$(this, p);
        }

        @Override
        public int indexWhere(Function1<T, Object> p, int from) {
            return Iterator.indexWhere$(this, p, from);
        }

        @Override
        public <B> int indexOf(B elem) {
            return Iterator.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return Iterator.indexOf$(this, elem, from);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> grouped(int size) {
            return Iterator.grouped$(this, size);
        }

        @Override
        public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
            return Iterator.sliding$(this, size, step);
        }

        @Override
        public <B> int sliding$default$2() {
            return Iterator.sliding$default$2$(this);
        }

        @Override
        public int length() {
            return Iterator.length$(this);
        }

        @Override
        public Tuple2<Iterator<T>, Iterator<T>> duplicate() {
            return Iterator.duplicate$(this);
        }

        @Override
        public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
            return Iterator.patch$(this, from, patchElems, replaced);
        }

        @Override
        public boolean sameElements(Iterator<?> that) {
            return Iterator.sameElements$(this, that);
        }

        @Override
        public Traversable<T> toTraversable() {
            return Iterator.toTraversable$(this);
        }

        @Override
        public Iterator<T> toIterator() {
            return Iterator.toIterator$(this);
        }

        @Override
        public Stream<T> toStream() {
            return Iterator.toStream$(this);
        }

        @Override
        public List<T> reversed() {
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
        public <B> B foldRight(B z, Function2<T, B, B> op) {
            return (B)TraversableOnce.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, T, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<T, B, B> op) {
            return (B)TraversableOnce.reduceRight$(this, op);
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
        public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
            return TraversableOnce.reduceOption$(this, op);
        }

        @Override
        public <B> B aggregate(Function0<B> z, Function2<B, T, B> seqop, Function2<B, B, B> combop) {
            return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
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
        public Iterable<T> toIterable() {
            return TraversableOnce.toIterable$(this);
        }

        @Override
        public Seq<T> toSeq() {
            return TraversableOnce.toSeq$(this);
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
        public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
            return (Col)TraversableOnce.to$(this, cbf);
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
        public Signalling signalDelegate() {
            return this.signalDelegate;
        }

        @Override
        public void signalDelegate_$eq(Signalling x$1) {
            this.signalDelegate = x$1;
        }

        public int end() {
            return this.end;
        }

        public int scala$collection$parallel$ParSeqLike$Elements$$i() {
            return this.scala$collection$parallel$ParSeqLike$Elements$$i;
        }

        private void scala$collection$parallel$ParSeqLike$Elements$$i_$eq(int x$1) {
            this.scala$collection$parallel$ParSeqLike$Elements$$i = x$1;
        }

        @Override
        public boolean hasNext() {
            return this.scala$collection$parallel$ParSeqLike$Elements$$i() < this.end();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public T next() {
            if (this.scala$collection$parallel$ParSeqLike$Elements$$i() < this.end()) {
                void var1_1;
                Object x = this.scala$collection$parallel$ParSeqLike$Elements$$$outer().apply(this.scala$collection$parallel$ParSeqLike$Elements$$i());
                this.scala$collection$parallel$ParSeqLike$Elements$$i_$eq(this.scala$collection$parallel$ParSeqLike$Elements$$i() + 1);
                return var1_1;
            }
            return Iterator$.MODULE$.empty().next();
        }

        @Override
        public T head() {
            return this.scala$collection$parallel$ParSeqLike$Elements$$$outer().apply(this.scala$collection$parallel$ParSeqLike$Elements$$i());
        }

        @Override
        public final int remaining() {
            return this.end() - this.scala$collection$parallel$ParSeqLike$Elements$$i();
        }

        public Elements dup() {
            return new Elements(this){};
        }

        @Override
        public Seq<SeqSplitter<T>> split() {
            return this.psplit(Predef$.MODULE$.wrapIntArray(new int[]{this.remaining() / 2, this.remaining() - this.remaining() / 2}));
        }

        @Override
        public Seq<SeqSplitter<T>> psplit(Seq<Object> sizes) {
            Seq incr = sizes.scanLeft(BoxesRunTime.boxToInteger(0), (JFunction2$mcIII$sp & Serializable)(x$1, x$2) -> x$1 + x$2, Seq$.MODULE$.canBuildFrom());
            return ((TraversableLike)((IterableLike)incr.init()).zip((GenIterable)incr.tail(), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A check$ifrefutable$1) -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).map((Function1<Tuple2, Elements> & java.io.Serializable & Serializable)x$3 -> {
                if (x$3 == null) {
                    throw new MatchError((Object)null);
                }
                int from = x$3._1$mcI$sp();
                int until = x$3._2$mcI$sp();
                Elements elements = new Elements(this, from, until){
                    {
                        int n = $outer.scala$collection$parallel$ParSeqLike$Elements$$start + until$1;
                        if (Predef$.MODULE$ == null) {
                            throw null;
                        }
                        super($outer.scala$collection$parallel$ParSeqLike$Elements$$$outer(), $outer.scala$collection$parallel$ParSeqLike$Elements$$start + from$1, RichInt$.MODULE$.min$extension(n, $outer.end()));
                    }
                };
                return elements;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public String toString() {
            return new java.lang.StringBuilder(12).append("Elements(").append(this.scala$collection$parallel$ParSeqLike$Elements$$start).append(", ").append(this.end()).append(")").toString();
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$Elements$$$outer() {
            return this.$outer;
        }

        public Elements(ParSeqLike $outer, int start, int end) {
            this.scala$collection$parallel$ParSeqLike$Elements$$start = start;
            this.end = end;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Iterator.$init$(this);
            RemainsIterator.$init$(this);
            AugmentedIterableIterator.$init$(this);
            DelegatedSignalling.$init$(this);
            IterableSplitter.$init$(this);
            AugmentedSeqIterator.$init$(this);
            SeqSplitter.$init$(this);
            BufferedIterator.$init$(this);
            this.scala$collection$parallel$ParSeqLike$Elements$$i = start;
        }
    }

    public class IndexWhere
    implements Accessor<Object, IndexWhere> {
        private final Function1<T, Object> pred;
        private final int from;
        private final SeqSplitter<T> pit;
        private volatile int result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Object> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        @Override
        public int result() {
            return this.result;
        }

        @Override
        public void result_$eq(int x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Object> prev) {
            int r;
            if (this.from < this.pit().indexFlag() && (r = this.pit().indexWhere(this.pred)) != -1) {
                this.result_$eq(this.from + r);
                this.pit().setIndexFlagIfLesser(this.from);
                return;
            }
        }

        public Nothing$ newSubtask(IterableSplitter<T> p) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Seq<Task<Object, IndexWhere>> split() {
            Seq pits = this.pit().splitWithSignalling();
            return ((TraversableLike)pits.zip(pits.scanLeft(BoxesRunTime.boxToInteger(this.from), (Function2<Object, SeqSplitter, Object> & java.io.Serializable & Serializable)(x$19, x$20) -> BoxesRunTime.boxToInteger(IndexWhere.$anonfun$split$4(BoxesRunTime.unboxToInt(x$19), x$20)), Seq$.MODULE$.canBuildFrom()), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$3 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$3 != null)).map((Function1<Tuple2, IndexWhere> & java.io.Serializable & Serializable)x$21 -> {
                if (x$21 == null) {
                    throw new MatchError((Object)null);
                }
                SeqSplitter p = (SeqSplitter)x$21._1();
                int untilp = x$21._2$mcI$sp();
                IndexWhere indexWhere = new IndexWhere(this.scala$collection$parallel$ParSeqLike$IndexWhere$$$outer(), $this.pred, untilp, p);
                return indexWhere;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public void merge(IndexWhere that) {
            int n;
            if (this.result() == -1) {
                n = that.result();
            } else if (that.result() != -1) {
                int n2 = this.result();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                n = RichInt$.MODULE$.min$extension(n2, that.result());
            } else {
                n = this.result();
            }
            this.result_$eq(n);
        }

        @Override
        public boolean requiresStrictSplitters() {
            return true;
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$IndexWhere$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$IndexWhere$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$IndexWhere$$$outer();
        }

        public static final /* synthetic */ int $anonfun$split$4(int x$19, SeqSplitter x$20) {
            return x$19 + x$20.remaining();
        }

        public IndexWhere(ParSeqLike $outer, Function1<T, Object> pred, int from, SeqSplitter<T> pit) {
            this.pred = pred;
            this.from = from;
            this.pit = pit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = -1;
        }
    }

    public class LastIndexWhere
    implements Accessor<Object, LastIndexWhere> {
        private final Function1<T, Object> pred;
        private final int pos;
        private final SeqSplitter<T> pit;
        private volatile int result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Object> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        @Override
        public int result() {
            return this.result;
        }

        @Override
        public void result_$eq(int x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Object> prev) {
            int r;
            if (this.pos > this.pit().indexFlag() && (r = this.pit().lastIndexWhere(this.pred)) != -1) {
                this.result_$eq(this.pos + r);
                this.pit().setIndexFlagIfGreater(this.pos);
                return;
            }
        }

        public Nothing$ newSubtask(IterableSplitter<T> p) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Seq<Task<Object, LastIndexWhere>> split() {
            Seq pits = this.pit().splitWithSignalling();
            return ((TraversableLike)pits.zip(pits.scanLeft(BoxesRunTime.boxToInteger(this.pos), (Function2<Object, SeqSplitter, Object> & java.io.Serializable & Serializable)(x$22, x$23) -> BoxesRunTime.boxToInteger(LastIndexWhere.$anonfun$split$7(BoxesRunTime.unboxToInt(x$22), x$23)), Seq$.MODULE$.canBuildFrom()), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$4 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$4 != null)).map((Function1<Tuple2, LastIndexWhere> & java.io.Serializable & Serializable)x$24 -> {
                if (x$24 == null) {
                    throw new MatchError((Object)null);
                }
                SeqSplitter p = (SeqSplitter)x$24._1();
                int untilp = x$24._2$mcI$sp();
                LastIndexWhere lastIndexWhere = new LastIndexWhere(this.scala$collection$parallel$ParSeqLike$LastIndexWhere$$$outer(), $this.pred, untilp, p);
                return lastIndexWhere;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public void merge(LastIndexWhere that) {
            int n;
            if (this.result() == -1) {
                n = that.result();
            } else if (that.result() != -1) {
                int n2 = this.result();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                n = RichInt$.MODULE$.max$extension(n2, that.result());
            } else {
                n = this.result();
            }
            this.result_$eq(n);
        }

        @Override
        public boolean requiresStrictSplitters() {
            return true;
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$LastIndexWhere$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$LastIndexWhere$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$LastIndexWhere$$$outer();
        }

        public static final /* synthetic */ int $anonfun$split$7(int x$22, SeqSplitter x$23) {
            return x$22 + x$23.remaining();
        }

        public LastIndexWhere(ParSeqLike $outer, Function1<T, Object> pred, int pos, SeqSplitter<T> pit) {
            this.pred = pred;
            this.pos = pos;
            this.pit = pit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = -1;
        }
    }

    public class Reverse<U, This>
    implements Transformer<Combiner<U, This>, Reverse<U, This>> {
        private final Function0<Combiner<U, This>> cbf;
        private final SeqSplitter<T> pit;
        private volatile Combiner<U, This> result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public Seq<Task<Combiner<U, This>, Reverse<U, This>>> split() {
            return ParIterableLike.Accessor.split$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public boolean requiresStrictSplitters() {
            return ParIterableLike.StrictSplitterCheckTask.requiresStrictSplitters$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Combiner<U, This>> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        @Override
        public Combiner<U, This> result() {
            return this.result;
        }

        @Override
        public void result_$eq(Combiner<U, This> x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Combiner<U, This>> prev) {
            this.result_$eq(this.pit().reverse2combiner(this.scala$collection$parallel$ParSeqLike$Reverse$$$outer().reuse(prev, this.cbf.apply())));
        }

        @Override
        public Reverse<U, This> newSubtask(IterableSplitter<T> p) {
            return new Reverse<U, This>(this.scala$collection$parallel$ParSeqLike$Reverse$$$outer(), this.cbf, this.scala$collection$parallel$ParSeqLike$Reverse$$$outer().down(p));
        }

        @Override
        public void merge(Reverse<U, This> that) {
            this.result_$eq(that.result().combine(this.result()));
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$Reverse$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Reverse$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Reverse$$$outer();
        }

        public Reverse(ParSeqLike $outer, Function0<Combiner<U, This>> cbf, SeqSplitter<T> pit) {
            this.cbf = cbf;
            this.pit = pit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = null;
        }
    }

    public class ReverseMap<S, That>
    implements Transformer<Combiner<S, That>, ReverseMap<S, That>> {
        private final Function1<T, S> f;
        private final Function0<Combiner<S, That>> pbf;
        private final SeqSplitter<T> pit;
        private volatile Combiner<S, That> result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public Seq<Task<Combiner<S, That>, ReverseMap<S, That>>> split() {
            return ParIterableLike.Accessor.split$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public boolean requiresStrictSplitters() {
            return ParIterableLike.StrictSplitterCheckTask.requiresStrictSplitters$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Combiner<S, That>> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        @Override
        public Combiner<S, That> result() {
            return this.result;
        }

        @Override
        public void result_$eq(Combiner<S, That> x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Combiner<S, That>> prev) {
            this.result_$eq(this.pit().reverseMap2combiner(this.f, this.pbf.apply()));
        }

        @Override
        public ReverseMap<S, That> newSubtask(IterableSplitter<T> p) {
            return new ReverseMap<S, That>(this.scala$collection$parallel$ParSeqLike$ReverseMap$$$outer(), this.f, this.pbf, this.scala$collection$parallel$ParSeqLike$ReverseMap$$$outer().down(p));
        }

        @Override
        public void merge(ReverseMap<S, That> that) {
            this.result_$eq(that.result().combine(this.result()));
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$ReverseMap$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$ReverseMap$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$ReverseMap$$$outer();
        }

        public ReverseMap(ParSeqLike $outer, Function1<T, S> f, Function0<Combiner<S, That>> pbf, SeqSplitter<T> pit) {
            this.f = f;
            this.pbf = pbf;
            this.pit = pit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = null;
        }
    }

    public class SameElements<U>
    implements Accessor<Object, SameElements<U>> {
        private final SeqSplitter<T> pit;
        private final SeqSplitter<U> otherpit;
        private volatile boolean result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Object> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        public SeqSplitter<U> otherpit() {
            return this.otherpit;
        }

        @Override
        public boolean result() {
            return this.result;
        }

        @Override
        public void result_$eq(boolean x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Object> prev) {
            if (!this.pit().isAborted()) {
                this.result_$eq(this.pit().sameElements(this.otherpit()));
                if (!this.result()) {
                    this.pit().abort();
                    return;
                }
            }
        }

        public Nothing$ newSubtask(IterableSplitter<T> p) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Seq<Task<Object, SameElements<U>>> split() {
            int fp = this.pit().remaining() / 2;
            int sp2 = this.pit().remaining() - fp;
            return ((TraversableLike)this.pit().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{fp, sp2})).zip(this.otherpit().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{fp, sp2})), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$5 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$5 != null)).map((Function1<Tuple2, SameElements> & java.io.Serializable & Serializable)x$25 -> {
                if (x$25 == null) {
                    throw new MatchError((Object)null);
                }
                SeqSplitter p = (SeqSplitter)x$25._1();
                SeqSplitter op = (SeqSplitter)x$25._2();
                SameElements sameElements = new SameElements(this.scala$collection$parallel$ParSeqLike$SameElements$$$outer(), p, op);
                return sameElements;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public void merge(SameElements<U> that) {
            this.result_$eq(this.result() && that.result());
        }

        @Override
        public boolean requiresStrictSplitters() {
            return true;
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$SameElements$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$SameElements$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$SameElements$$$outer();
        }

        public SameElements(ParSeqLike $outer, SeqSplitter<T> pit, SeqSplitter<U> otherpit) {
            this.pit = pit;
            this.otherpit = otherpit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = true;
        }
    }

    public class SegmentLength
    implements Accessor<Tuple2<Object, Object>, SegmentLength> {
        private final Function1<T, Object> pred;
        private final int from;
        private final SeqSplitter<T> pit;
        private volatile Tuple2<Object, Object> result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Tuple2<Object, Object>> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        @Override
        public Tuple2<Object, Object> result() {
            return this.result;
        }

        @Override
        public void result_$eq(Tuple2<Object, Object> x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Tuple2<Object, Object>> prev) {
            if (this.from < this.pit().indexFlag()) {
                int seglen;
                int itsize = this.pit().remaining();
                this.result_$eq(new Tuple2$mcIZ$sp(seglen, itsize == (seglen = this.pit().prefixLength(this.pred))));
                if (!((Tuple2)this.result())._2$mcZ$sp()) {
                    this.pit().setIndexFlagIfLesser(this.from);
                    return;
                }
            } else {
                this.result_$eq(new Tuple2$mcIZ$sp(0, false));
            }
        }

        public Nothing$ newSubtask(IterableSplitter<T> p) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Seq<Task<Tuple2<Object, Object>, SegmentLength>> split() {
            Seq pits = this.pit().splitWithSignalling();
            return ((TraversableLike)pits.zip(pits.scanLeft(BoxesRunTime.boxToInteger(0), (Function2<Object, SeqSplitter, Object> & java.io.Serializable & Serializable)(x$16, x$17) -> BoxesRunTime.boxToInteger(SegmentLength.$anonfun$split$1(BoxesRunTime.unboxToInt(x$16), x$17)), Seq$.MODULE$.canBuildFrom()), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$2 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$2 != null)).map((Function1<Tuple2, SegmentLength> & java.io.Serializable & Serializable)x$18 -> {
                if (x$18 == null) {
                    throw new MatchError((Object)null);
                }
                SeqSplitter p = (SeqSplitter)x$18._1();
                int untilp = x$18._2$mcI$sp();
                SegmentLength segmentLength = new SegmentLength(this.scala$collection$parallel$ParSeqLike$SegmentLength$$$outer(), $this.pred, $this.from + untilp, p);
                return segmentLength;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public void merge(SegmentLength that) {
            if (((Tuple2)this.result())._2$mcZ$sp()) {
                this.result_$eq(new Tuple2$mcIZ$sp(((Tuple2)this.result())._1$mcI$sp() + ((Tuple2)that.result())._1$mcI$sp(), ((Tuple2)that.result())._2$mcZ$sp()));
            }
        }

        @Override
        public boolean requiresStrictSplitters() {
            return true;
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$SegmentLength$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$SegmentLength$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$SegmentLength$$$outer();
        }

        public static final /* synthetic */ int $anonfun$split$1(int x$16, SeqSplitter x$17) {
            return x$16 + x$17.remaining();
        }

        public SegmentLength(ParSeqLike $outer, Function1<T, Object> pred, int from, SeqSplitter<T> pit) {
            this.pred = pred;
            this.from = from;
            this.pit = pit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = null;
        }
    }

    public interface Transformer<R, Tp>
    extends Accessor<R, Tp>,
    ParIterableLike.Transformer<R, Tp> {
    }

    public class Updated<U, That>
    implements Transformer<Combiner<U, That>, Updated<U, That>> {
        private final int pos;
        private final U elem;
        private final CombinerFactory<U, That> pbf;
        private final SeqSplitter<T> pit;
        private volatile Combiner<U, That> result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Combiner<U, That>> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        @Override
        public Combiner<U, That> result() {
            return this.result;
        }

        @Override
        public void result_$eq(Combiner<U, That> x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Combiner<U, That>> prev) {
            this.result_$eq(this.pit().updated2combiner(this.pos, this.elem, this.pbf.apply()));
        }

        public Nothing$ newSubtask(IterableSplitter<T> p) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Seq<Task<Combiner<U, That>, Updated<U, That>>> split() {
            Seq pits = this.pit().splitWithSignalling();
            return ((TraversableLike)pits.zip(pits.scanLeft(BoxesRunTime.boxToInteger(0), (Function2<Object, SeqSplitter, Object> & java.io.Serializable & Serializable)(x$26, x$27) -> BoxesRunTime.boxToInteger(Updated.$anonfun$split$12(BoxesRunTime.unboxToInt(x$26), x$27)), Seq$.MODULE$.canBuildFrom()), Seq$.MODULE$.canBuildFrom())).withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$6 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$6 != null)).map((Function1<Tuple2, Updated> & java.io.Serializable & Serializable)x$28 -> {
                if (x$28 == null) {
                    throw new MatchError((Object)null);
                }
                SeqSplitter p = (SeqSplitter)x$28._1();
                int untilp = x$28._2$mcI$sp();
                Updated updated = new Updated(this.scala$collection$parallel$ParSeqLike$Updated$$$outer(), $this.pos - untilp, $this.elem, $this.pbf, p);
                return updated;
            }, Seq$.MODULE$.canBuildFrom());
        }

        @Override
        public void merge(Updated<U, That> that) {
            this.result_$eq(this.result().combine(that.result()));
        }

        @Override
        public boolean requiresStrictSplitters() {
            return true;
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$Updated$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Updated$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Updated$$$outer();
        }

        public static final /* synthetic */ int $anonfun$split$12(int x$26, SeqSplitter x$27) {
            return x$26 + x$27.remaining();
        }

        public Updated(ParSeqLike $outer, int pos, U elem, CombinerFactory<U, That> pbf, SeqSplitter<T> pit) {
            this.pos = pos;
            this.elem = elem;
            this.pbf = pbf;
            this.pit = pit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = null;
        }
    }

    public class Zip<U, S, That>
    implements Transformer<Combiner<Tuple2<U, S>, That>, Zip<U, S, That>> {
        private final int len;
        private final CombinerFactory<Tuple2<U, S>, That> cf;
        private final SeqSplitter<T> pit;
        private final SeqSplitter<S> otherpit;
        private volatile Combiner<Tuple2<U, S>, That> result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParSeqLike $outer;

        @Override
        public /* synthetic */ String scala$collection$parallel$ParIterableLike$Accessor$$super$toString() {
            return super.toString();
        }

        @Override
        public boolean shouldSplitFurther() {
            return ParIterableLike.Accessor.shouldSplitFurther$(this);
        }

        @Override
        public void signalAbort() {
            ParIterableLike.Accessor.signalAbort$(this);
        }

        @Override
        public String toString() {
            return ParIterableLike.Accessor.toString$(this);
        }

        @Override
        public boolean requiresStrictSplitters() {
            return ParIterableLike.StrictSplitterCheckTask.requiresStrictSplitters$(this);
        }

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<Combiner<Tuple2<U, S>, That>> lastres) {
            Task.tryLeaf$(this, lastres);
        }

        @Override
        public void tryMerge(Object t) {
            Task.tryMerge$(this, t);
        }

        @Override
        public void mergeThrowables(Task<?, ?> that) {
            Task.mergeThrowables$(this, that);
        }

        @Override
        public Throwable throwable() {
            return this.throwable;
        }

        @Override
        public void throwable_$eq(Throwable x$1) {
            this.throwable = x$1;
        }

        @Override
        public SeqSplitter<T> pit() {
            return this.pit;
        }

        public SeqSplitter<S> otherpit() {
            return this.otherpit;
        }

        @Override
        public Combiner<Tuple2<U, S>, That> result() {
            return this.result;
        }

        @Override
        public void result_$eq(Combiner<Tuple2<U, S>, That> x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<Combiner<Tuple2<U, S>, That>> prev) {
            this.result_$eq(this.pit().zip2combiner(this.otherpit(), this.cf.apply()));
        }

        public Nothing$ newSubtask(IterableSplitter<T> p) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Seq<Zip<U, S, That>> split() {
            int fp = this.len / 2;
            int sp2 = this.len - this.len / 2;
            Seq pits = this.pit().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{fp, sp2}));
            Seq<SeqSplitter<S>> opits = this.otherpit().psplitWithSignalling(Predef$.MODULE$.wrapIntArray(new int[]{fp, sp2}));
            return new $colon$colon<Nothing$>((Nothing$)((Object)new Zip<U, S, That>(this.scala$collection$parallel$ParSeqLike$Zip$$$outer(), fp, this.cf, (SeqSplitter)pits.apply(false), (SeqSplitter)opits.apply(false))), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Zip<U, S, That>(this.scala$collection$parallel$ParSeqLike$Zip$$$outer(), sp2, this.cf, (SeqSplitter)pits.apply(true), (SeqSplitter)opits.apply(true))), Nil$.MODULE$));
        }

        @Override
        public void merge(Zip<U, S, That> that) {
            this.result_$eq(this.result().combine(that.result()));
        }

        public /* synthetic */ ParSeqLike scala$collection$parallel$ParSeqLike$Zip$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$Accessor$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Zip$$$outer();
        }

        @Override
        public /* synthetic */ ParIterableLike scala$collection$parallel$ParIterableLike$StrictSplitterCheckTask$$$outer() {
            return this.scala$collection$parallel$ParSeqLike$Zip$$$outer();
        }

        public Zip(ParSeqLike $outer, int len, CombinerFactory<Tuple2<U, S>, That> cf, SeqSplitter<T> pit, SeqSplitter<S> otherpit) {
            this.len = len;
            this.cf = cf;
            this.pit = pit;
            this.otherpit = otherpit;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            ParIterableLike.StrictSplitterCheckTask.$init$(this);
            ParIterableLike.Accessor.$init$(this);
            this.result = null;
        }
    }
}

