/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.lang.reflect.Array;
import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.ArrayLike;
import scala.collection.mutable.ArrayOps$ofBoolean$;
import scala.collection.mutable.ArrayOps$ofByte$;
import scala.collection.mutable.ArrayOps$ofChar$;
import scala.collection.mutable.ArrayOps$ofDouble$;
import scala.collection.mutable.ArrayOps$ofFloat$;
import scala.collection.mutable.ArrayOps$ofInt$;
import scala.collection.mutable.ArrayOps$ofLong$;
import scala.collection.mutable.ArrayOps$ofRef$;
import scala.collection.mutable.ArrayOps$ofShort$;
import scala.collection.mutable.ArrayOps$ofUnit$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.IndexedSeqView;
import scala.collection.mutable.StringBuilder;
import scala.collection.mutable.WrappedArray;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParArray;
import scala.collection.parallel.mutable.ParArray$;
import scala.math.Numeric;
import scala.math.Numeric$IntIsIntegral$;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001!\u0015eACAy\u0003g\u0004\n1!\t\u0003\u0002!9!\u0011\t\u0001\u0005\u0002\t\r\u0003b\u0002B&\u0001\u0011%!Q\n\u0005\b\u0005[\u0002A\u0011\tB8\u0011\u001d\u0011y\t\u0001C!\u0005#CqAa'\u0001\t\u0003\u0012i\nC\u0004\u00038\u0002!\tA!/\t\u000f\tE\u0007\u0001\"\u0001\u0003T\"9!q\u001d\u0001\u0005B\t%\bb\u0002Bv\u0001\u0011\u0005!Q\u001e\u0005\b\u0007\u001b\u0001A\u0011AB\b\u0011\u001d\u0019\t\u0003\u0001C\u0001\u0007GAqa!\u0015\u0001\t\u0003\u0019\u0019\u0006C\u0004\u0004\b\u0002!\ta!#\t\u001d\rE\u0005\u0001%A\u0002\u0002\u0003%Iaa%\u0004\"\u001eA\u00012QAz\u0011\u0003\u00199L\u0002\u0005\u0002r\u0006M\b\u0012ABV\u0011\u001d\u0019\u0019\f\u0005C\u0001\u0007k3aa!/\u0011\u0005\rm\u0006BCBi%\t\u0015\r\u0011\"\u0011\u0004T\"Q1Q\u001b\n\u0003\u0002\u0003\u0006Iaa4\t\u000f\rM&\u0003\"\u0001\u0004X\"A1q\u001c\n!\n#\u001a\t\u000f\u0003\u0005\u0004jJ\u0001K\u0011KBv\u0011!\u0019yO\u0005Q\u0005R\rE\bbBB\u0000%\u0011\u0005A\u0011\u0001\u0005\b\t\u0007\u0011B\u0011\u0001C\u0003\u0011\u001d!YA\u0005C\u0001\t\u001bA\u0011\u0002b\u0005\u0013\u0003\u0003%\t\u0005\"\u0006\t\u0013\u0011]!#!A\u0005B\u0011eaA\u0002C\u0013!\t!9\u0003\u0003\u0006\u0004Rz\u0011)\u0019!C!\tkA!b!6\u001f\u0005\u0003\u0005\u000b\u0011\u0002C\u001a\u0011\u001d\u0019\u0019L\bC\u0001\toA\u0001ba8\u001fA\u0013ECQ\b\u0005\t\u0007St\u0002\u0015\"\u0015\u0005B!A1q\u001e\u0010!\n#\")\u0005C\u0004\u0004\u0000z!\t\u0001\"\u0001\t\u000f\u0011\ra\u0004\"\u0001\u0005L!9A1\u0002\u0010\u0005\u0002\u0011=\u0003\"\u0003C\n=\u0005\u0005I\u0011\tC\u000b\u0011%!9BHA\u0001\n\u0003\")F\u0002\u0004\u0005ZA\u0011A1\f\u0005\u000b\u0007#T#Q1A\u0005B\u0011%\u0004BCBkU\t\u0005\t\u0015!\u0003\u0005h!911\u0017\u0016\u0005\u0002\u0011-\u0004\u0002CBpU\u0001&\t\u0006\"\u001d\t\u0011\r%(\u0006)C)\tkB\u0001ba<+A\u0013EC\u0011\u0010\u0005\b\u0007\u007fTC\u0011\u0001C\u0001\u0011\u001d!\u0019A\u000bC\u0001\t\u007fBq\u0001b\u0003+\t\u0003!\u0019\tC\u0005\u0005\u0014)\n\t\u0011\"\u0011\u0005\u0016!IAq\u0003\u0016\u0002\u0002\u0013\u0005C\u0011\u0012\u0004\u0007\t\u001b\u0003\"\u0001b$\t\u0015\rEgG!b\u0001\n\u0003\"i\n\u0003\u0006\u0004VZ\u0012\t\u0011)A\u0005\t7Cqaa-7\t\u0003!y\n\u0003\u0005\u0004`Z\u0002K\u0011\u000bCS\u0011!\u0019IO\u000eQ\u0005R\u0011%\u0006\u0002CBxm\u0001&\t\u0006\",\t\u000f\r}h\u0007\"\u0001\u0005\u0002!9A1\u0001\u001c\u0005\u0002\u0011M\u0006b\u0002C\u0006m\u0011\u0005Aq\u0017\u0005\n\t'1\u0014\u0011!C!\t+A\u0011\u0002b\u00067\u0003\u0003%\t\u0005\"0\u0007\r\u0011\u0005\u0007C\u0001Cb\u0011)\u0019\tN\u0011BC\u0002\u0013\u0005C1\u001a\u0005\u000b\u0007+\u0014%\u0011!Q\u0001\n\u0011%\u0007bBBZ\u0005\u0012\u0005AQ\u001a\u0005\t\u0007?\u0014\u0005\u0015\"\u0015\u0005T\"A1\u0011\u001e\"!\n#\"9\u000e\u0003\u0005\u0004p\n\u0003K\u0011\u000bCn\u0011\u001d\u0019yP\u0011C\u0001\t\u0003Aq\u0001b\u0001C\t\u0003!\t\u000fC\u0004\u0005\f\t#\t\u0001\":\t\u0013\u0011M!)!A\u0005B\u0011U\u0001\"\u0003C\f\u0005\u0006\u0005I\u0011\tCv\r\u0019!y\u000f\u0005\u0002\u0005r\"Q1\u0011\u001b(\u0003\u0006\u0004%\t\u0005b@\t\u0015\rUgJ!A!\u0002\u0013!i\u0010C\u0004\u00044:#\t!\"\u0001\t\u0011\r}g\n)C)\u000b\u000fA\u0001b!;OA\u0013ES1\u0002\u0005\t\u0007_t\u0005\u0015\"\u0015\u0006\u0010!91q (\u0005\u0002\u0011\u0005\u0001b\u0002C\u0002\u001d\u0012\u0005QQ\u0003\u0005\b\t\u0017qE\u0011AC\r\u0011%!\u0019BTA\u0001\n\u0003\")\u0002C\u0005\u0005\u00189\u000b\t\u0011\"\u0011\u0006 \u00191Q1\u0005\t\u0003\u000bKA!b!5[\u0005\u000b\u0007I\u0011IC\u001a\u0011)\u0019)N\u0017B\u0001B\u0003%Q\u0011\u0007\u0005\b\u0007gSF\u0011AC\u001b\u0011!\u0019yN\u0017Q\u0005R\u0015m\u0002\u0002CBu5\u0002&\t&b\u0010\t\u0011\r=(\f)C)\u000b\u0007Bqaa@[\t\u0003!\t\u0001C\u0004\u0005\u0004i#\t!\"\u0013\t\u000f\u0011-!\f\"\u0001\u0006N!IA1\u0003.\u0002\u0002\u0013\u0005CQ\u0003\u0005\n\t/Q\u0016\u0011!C!\u000b'2a!b\u0016\u0011\u0005\u0015e\u0003BCBiM\n\u0015\r\u0011\"\u0011\u0006h!Q1Q\u001b4\u0003\u0002\u0003\u0006I!\"\u001a\t\u000f\rMf\r\"\u0001\u0006j!A1q\u001c4!\n#*y\u0007\u0003\u0005\u0004j\u001a\u0004K\u0011KC:\u0011!\u0019yO\u001aQ\u0005R\u0015]\u0004bBB\u0000M\u0012\u0005A\u0011\u0001\u0005\b\t\u00071G\u0011AC?\u0011\u001d!YA\u001aC\u0001\u000b\u0003C\u0011\u0002b\u0005g\u0003\u0003%\t\u0005\"\u0006\t\u0013\u0011]a-!A\u0005B\u0015\u001deABBU!\tA\t\u0007\u0003\u0006\u0004RJ\u0014)\u0019!C!\u0011OB!b!6s\u0005\u0003\u0005\u000b\u0011\u0002E\u001a\u0011\u001d\u0019\u0019L\u001dC\u0001\u0011SB\u0001ba8sA\u0013E\u0003R\u000e\u0005\t\u0007S\u0014\b\u0015\"\u0015\tp!A1q\u001e:!\n#B\u0019\bC\u0004\u0004\u0000J$\t\u0001\"\u0001\t\u000f\u0011\r!\u000f\"\u0001\tv!9A1\u0002:\u0005\u0002!e\u0004\"\u0003C\ne\u0006\u0005I\u0011\tC\u000b\u0011%!9B]A\u0001\n\u0003ByH\u0002\u0004\u0006\fB\u0011QQ\u0012\u0005\u000b\u0007#t(Q1A\u0005B\u0015U\u0005BCBk}\n\u0005\t\u0015!\u0003\u0006\u0014\"911\u0017@\u0005\u0002\u0015]\u0005\u0002CBp}\u0002&\t&\"(\t\u0011\r%h\u0010)C)\u000bCC\u0001ba<\u007fA\u0013ESQ\u0015\u0005\b\u0007\u007ftH\u0011\u0001C\u0001\u0011\u001d!\u0019A C\u0001\u000bWCq\u0001b\u0003\u007f\t\u0003)y\u000bC\u0005\u0005\u0014y\f\t\u0011\"\u0011\u0005\u0016!IAq\u0003@\u0002\u0002\u0013\u0005SQW\u0004\n\u000bs\u0003\u0012\u0011!E\u0001\u000bw3\u0011\"b#\u0011\u0003\u0003E\t!\"0\t\u0011\rM\u0016q\u0003C\u0001\u000b\u007fC\u0001\"\"1\u0002\u0018\u0011\u0015Q1\u0019\u0005\t\u000b\u0013\f9\u0002\"\u0002\u0006L\"AQ1[A\f\t\u000b))\u000e\u0003\u0005\u0006Z\u0006]AQACn\u0011!)y.a\u0006\u0005\u0006\u0015\u0005\b\u0002CCu\u0003/!)!b;\t\u0015\u0015U\u0018qCA\u0001\n\u000b)9\u0010\u0003\u0006\u0006|\u0006]\u0011\u0011!C\u0003\u000b{<\u0011B\"\u0002\u0011\u0003\u0003E\tAb\u0002\u0007\u0013\u0011e\u0003#!A\t\u0002\u0019%\u0001\u0002CBZ\u0003[!\tAb\u0003\t\u0011\u0015\u0005\u0017Q\u0006C\u0003\r\u001bA\u0001\"\"3\u0002.\u0011\u0015a\u0011\u0003\u0005\t\u000b'\fi\u0003\"\u0002\u0007\u001a!AQ\u0011\\A\u0017\t\u000b1i\u0002\u0003\u0005\u0006`\u00065BQ\u0001D\u0011\u0011!)I/!\f\u0005\u0006\u0019%\u0002BCC{\u0003[\t\t\u0011\"\u0002\u00074!QQ1`A\u0017\u0003\u0003%)Ab\u000e\b\u0013\u0019}\u0002#!A\t\u0002\u0019\u0005c!CB]!\u0005\u0005\t\u0012\u0001D\"\u0011!\u0019\u0019,a\u0011\u0005\u0002\u0019\u0015\u0003\u0002CCa\u0003\u0007\")Ab\u0012\t\u0011\u0015%\u00171\tC\u0003\r+B\u0001\"b5\u0002D\u0011\u0015a\u0011\u000e\u0005\t\u000b3\f\u0019\u0005\"\u0002\u0007x!AQq\\A\"\t\u000b1\u0019\t\u0003\u0005\u0006j\u0006\rCQ\u0001DJ\u0011)))0a\u0011\u0002\u0002\u0013\u0015aQ\u0015\u0005\u000b\u000bw\f\u0019%!A\u0005\u0006\u0019Ev!\u0003Da!\u0005\u0005\t\u0012\u0001Db\r%!y\u000fEA\u0001\u0012\u00031)\r\u0003\u0005\u00044\u0006eC\u0011\u0001Dd\u0011!)\t-!\u0017\u0005\u0006\u0019%\u0007\u0002CCe\u00033\")A\"4\t\u0011\u0015M\u0017\u0011\fC\u0003\r+D\u0001\"\"7\u0002Z\u0011\u0015a\u0011\u001c\u0005\t\u000b?\fI\u0006\"\u0002\u0007^\"AQ\u0011^A-\t\u000b1)\u000f\u0003\u0006\u0006v\u0006e\u0013\u0011!C\u0003\r_D!\"b?\u0002Z\u0005\u0005IQ\u0001Dz\u000f%1Y\u0010EA\u0001\u0012\u00031iPB\u0005\u0005BB\t\t\u0011#\u0001\u0007\u0000\"A11WA8\t\u00039\t\u0001\u0003\u0005\u0006B\u0006=DQAD\u0002\u0011!)I-a\u001c\u0005\u0006\u001d\u001d\u0001\u0002CCj\u0003_\")ab\u0004\t\u0011\u0015e\u0017q\u000eC\u0003\u000f'A\u0001\"b8\u0002p\u0011\u0015qq\u0003\u0005\t\u000bS\fy\u0007\"\u0002\b !QQQ_A8\u0003\u0003%)a\"\u000b\t\u0015\u0015m\u0018qNA\u0001\n\u000b9icB\u0005\b6A\t\t\u0011#\u0001\b8\u0019IQ1\u0005\t\u0002\u0002#\u0005q\u0011\b\u0005\t\u0007g\u000b)\t\"\u0001\b<!AQ\u0011YAC\t\u000b9i\u0004\u0003\u0005\u0006J\u0006\u0015EQAD!\u0011!)\u0019.!\"\u0005\u0006\u001d%\u0003\u0002CCm\u0003\u000b#)a\"\u0014\t\u0011\u0015}\u0017Q\u0011C\u0003\u000f#B\u0001\"\";\u0002\u0006\u0012\u0015q\u0011\f\u0005\u000b\u000bk\f))!A\u0005\u0006\u001d\r\u0004BCC~\u0003\u000b\u000b\t\u0011\"\u0002\bh\u001dIqq\u000e\t\u0002\u0002#\u0005q\u0011\u000f\u0004\n\u000b/\u0002\u0012\u0011!E\u0001\u000fgB\u0001ba-\u0002\u001c\u0012\u0005qQ\u000f\u0005\t\u000b\u0003\fY\n\"\u0002\bx!AQ\u0011ZAN\t\u000b9Y\b\u0003\u0005\u0006T\u0006mEQADB\u0011!)I.a'\u0005\u0006\u001d\u001d\u0005\u0002CCp\u00037#)ab#\t\u0011\u0015%\u00181\u0014C\u0003\u000f'C!\"\">\u0002\u001c\u0006\u0005IQADO\u0011))Y0a'\u0002\u0002\u0013\u0015q\u0011U\u0004\n\u000fS\u0003\u0012\u0011!E\u0001\u000fW3\u0011\u0002\"$\u0011\u0003\u0003E\ta\",\t\u0011\rM\u0016\u0011\u0017C\u0001\u000f_C\u0001\"\"1\u00022\u0012\u0015q\u0011\u0017\u0005\t\u000b\u0013\f\t\f\"\u0002\b6\"AQ1[AY\t\u000b9i\f\u0003\u0005\u0006Z\u0006EFQADa\u0011!)y.!-\u0005\u0006\u001d\u0015\u0007\u0002CCu\u0003c#)a\"4\t\u0015\u0015U\u0018\u0011WA\u0001\n\u000b99\u000e\u0003\u0006\u0006|\u0006E\u0016\u0011!C\u0003\u000f7<\u0011bb9\u0011\u0003\u0003E\ta\":\u0007\u0013\u0011\u0015\u0002#!A\t\u0002\u001d\u001d\b\u0002CBZ\u0003\u000f$\ta\";\t\u0011\u0015\u0005\u0017q\u0019C\u0003\u000fWD\u0001\"\"3\u0002H\u0012\u0015qq\u001e\u0005\t\u000b'\f9\r\"\u0002\bx\"AQ\u0011\\Ad\t\u000b9Y\u0010\u0003\u0005\u0006`\u0006\u001dGQAD\u0000\u0011!)I/a2\u0005\u0006!\u001d\u0001BCC{\u0003\u000f\f\t\u0011\"\u0002\t\u0012!QQ1`Ad\u0003\u0003%)\u0001#\u0006\b\u0013!u\u0001#!A\t\u0002!}a!CBU!\u0005\u0005\t\u0012\u0001E\u0011\u0011!\u0019\u0019,!8\u0005\u0002!\r\u0002\u0002CCa\u0003;$)\u0001#\n\t\u0011\u0015%\u0017Q\u001cC\u0003\u0011[A\u0001\"b5\u0002^\u0012\u0015\u0001r\u0007\u0005\t\u000b3\fi\u000e\"\u0002\t@!AQq\\Ao\t\u000bA\u0019\u0005\u0003\u0005\u0006j\u0006uGQ\u0001E&\u0011)))0!8\u0002\u0002\u0013\u0015\u0001R\u000b\u0005\u000b\u000bw\fi.!A\u0005\u0006!e#\u0001C!se\u0006Lx\n]:\u000b\t\u0005U\u0018q_\u0001\b[V$\u0018M\u00197f\u0015\u0011\tI0a?\u0002\u0015\r|G\u000e\\3di&|gN\u0003\u0002\u0002~\u0006)1oY1mC\u000e\u0001Q\u0003\u0002B\u0002\u00053\u0019r\u0001\u0001B\u0003\u0005\u001b\u0011Y\u0003\u0005\u0003\u0003\b\t%QBAA~\u0013\u0011\u0011Y!a?\u0003\u0007\u0005s\u0017\u0010\u0005\u0005\u0003\u0010\tE!Q\u0003B\u0013\u001b\t\t\u00190\u0003\u0003\u0003\u0014\u0005M(!C!se\u0006LH*[6f!\u0011\u00119B!\u0007\r\u0001\u00119!1\u0004\u0001C\u0002\tu!!\u0001+\u0012\t\t}!Q\u0001\t\u0005\u0005\u000f\u0011\t#\u0003\u0003\u0003$\u0005m(a\u0002(pi\"Lgn\u001a\t\u0007\u0005\u000f\u00119C!\u0006\n\t\t%\u00121 \u0002\u0006\u0003J\u0014\u0018-\u001f\t\t\u0005[\u0011yC!\u0006\u000345\u0011\u0011q_\u0005\u0005\u0005c\t9P\u0001\u000bDkN$x.\u001c)be\u0006dG.\u001a7ju\u0006\u0014G.\u001a\t\u0007\u0005k\u0011iD!\u0006\u000e\u0005\t]\"\u0002BA{\u0005sQAAa\u000f\u0002x\u0006A\u0001/\u0019:bY2,G.\u0003\u0003\u0003@\t]\"\u0001\u0003)be\u0006\u0013(/Y=\u0002\r\u0011Jg.\u001b;%)\t\u0011)\u0005\u0005\u0003\u0003\b\t\u001d\u0013\u0002\u0002B%\u0003w\u0014A!\u00168ji\u0006aQ\r\\3nK:$8\t\\1tgV\u0011!q\n\u0019\u0005\u0005#\u0012I\u0007\u0005\u0004\u0003T\t\u0005$q\r\b\u0005\u0005+\u0012i\u0006\u0005\u0003\u0003X\u0005mXB\u0001B-\u0015\u0011\u0011Y&a@\u0002\rq\u0012xn\u001c;?\u0013\u0011\u0011y&a?\u0002\rA\u0013X\rZ3g\u0013\u0011\u0011\u0019G!\u001a\u0003\u000b\rc\u0017m]:\u000b\t\t}\u00131 \t\u0005\u0005/\u0011I\u0007B\u0006\u0003l\t\t\t\u0011!A\u0003\u0002\tu!aA0%c\u0005Y1m\u001c9z)>\f%O]1z+\u0011\u0011\tHa\u001f\u0015\u0011\t\u0015#1\u000fBA\u0005\u0017CqA!\u001e\u0004\u0001\u0004\u00119(\u0001\u0002ygB1!q\u0001B\u0014\u0005s\u0002BAa\u0006\u0003|\u00119!QP\u0002C\u0002\t}$!A+\u0012\t\tU!Q\u0001\u0005\b\u0005\u0007\u001b\u0001\u0019\u0001BC\u0003\u0015\u0019H/\u0019:u!\u0011\u00119Aa\"\n\t\t%\u00151 \u0002\u0004\u0013:$\bb\u0002BG\u0007\u0001\u0007!QQ\u0001\u0004Y\u0016t\u0017!B:mS\u000e,GC\u0002B\u0013\u0005'\u00139\nC\u0004\u0003\u0016\u0012\u0001\rA!\"\u0002\t\u0019\u0014x.\u001c\u0005\b\u00053#\u0001\u0019\u0001BC\u0003\u0015)h\u000e^5m\u0003\u001d!x.\u0011:sCf,BAa(\u0003&R!!\u0011\u0015BT!\u0019\u00119Aa\n\u0003$B!!q\u0003BS\t\u001d\u0011i(\u0002b\u0001\u0005\u007fB\u0011B!+\u0006\u0003\u0003\u0005\u001dAa+\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$\u0013\u0007\u0005\u0004\u0003.\nM&1U\u0007\u0003\u0005_SAA!-\u0002|\u00069!/\u001a4mK\u000e$\u0018\u0002\u0002B[\u0005_\u0013\u0001b\u00117bgN$\u0016mZ\u0001\fI\r|Gn\u001c8%a2,8/\u0006\u0003\u0003<\n\rG\u0003\u0002B_\u0005\u001b$BAa0\u0003HB1!q\u0001B\u0014\u0005\u0003\u0004BAa\u0006\u0003D\u00129!Q\u0019\u0004C\u0002\t}$!\u0001\"\t\u0013\t%g!!AA\u0004\t-\u0017AC3wS\u0012,gnY3%eA1!Q\u0016BZ\u0005\u0003DqAa4\u0007\u0001\u0004\u0011\t-\u0001\u0003fY\u0016l\u0017a\u0003\u0013qYV\u001cHeY8m_:,BA!6\u0003^R!!q\u001bBs)\u0011\u0011INa8\u0011\r\t\u001d!q\u0005Bn!\u0011\u00119B!8\u0005\u000f\t\u0015wA1\u0001\u0003\u0000!I!\u0011]\u0004\u0002\u0002\u0003\u000f!1]\u0001\u000bKZLG-\u001a8dK\u0012\u001a\u0004C\u0002BW\u0005g\u0013Y\u000eC\u0004\u0003P\u001e\u0001\rAa7\u0002\u0007A\f'/\u0006\u0002\u00034\u00059a\r\\1ui\u0016tW\u0003\u0002Bx\u0005k$bA!=\u0003x\u000e\u001d\u0001C\u0002B\u0004\u0005O\u0011\u0019\u0010\u0005\u0003\u0003\u0018\tUHa\u0002B?\u0013\t\u0007!Q\u0004\u0005\b\u0005sL\u00019\u0001B~\u0003\u0019\t7\u000f\u0016:bmBA!q\u0001B\u007f\u0005+\u0019\t!\u0003\u0003\u0003\u0000\u0006m(!\u0003$v]\u000e$\u0018n\u001c82!\u0019\u0011ica\u0001\u0003t&!1QAA|\u0005-!&/\u0019<feN\f'\r\\3\t\u000f\r%\u0011\u0002q\u0001\u0004\f\u0005\tQ\u000e\u0005\u0004\u0003.\nM&1_\u0001\niJ\fgn\u001d9pg\u0016,Ba!\u0005\u0004\u001aQ!11CB\u000e!\u0019\u00119Aa\n\u0004\u0016A1!q\u0001B\u0014\u0007/\u0001BAa\u0006\u0004\u001a\u00119!Q\u0010\u0006C\u0002\tu\u0001bBB\u000f\u0015\u0001\u000f1qD\u0001\bCN\f%O]1z!!\u00119A!@\u0003\u0016\rU\u0011!B;ou&\u0004XCBB\u0013\u0007c\u0019I\u0004\u0006\u0005\u0004(\ru2QIB&!!\u00119a!\u000b\u0004.\rU\u0012\u0002BB\u0016\u0003w\u0014a\u0001V;qY\u0016\u0014\u0004C\u0002B\u0004\u0005O\u0019y\u0003\u0005\u0003\u0003\u0018\rEBaBB\u001a\u0017\t\u0007!Q\u0004\u0002\u0003)F\u0002bAa\u0002\u0003(\r]\u0002\u0003\u0002B\f\u0007s!qaa\u000f\f\u0005\u0004\u0011iB\u0001\u0002Ue!91qH\u0006A\u0004\r\u0005\u0013AB1t!\u0006L'\u000f\u0005\u0005\u0003\b\tu(QCB\"!!\u00119a!\u000b\u00040\r]\u0002bBB$\u0017\u0001\u000f1\u0011J\u0001\u0004GR\f\u0004C\u0002BW\u0005g\u001by\u0003C\u0004\u0004N-\u0001\u001daa\u0014\u0002\u0007\r$(\u0007\u0005\u0004\u0003.\nM6qG\u0001\u0007k:T\u0018\u000e]\u001a\u0016\u0011\rU3\u0011MB4\u0007[\"\"ba\u0016\u0004r\re4QPBA!)\u00119a!\u0017\u0004^\r\r4\u0011N\u0005\u0005\u00077\nYP\u0001\u0004UkBdWm\r\t\u0007\u0005\u000f\u00119ca\u0018\u0011\t\t]1\u0011\r\u0003\b\u0007ga!\u0019\u0001B\u000f!\u0019\u00119Aa\n\u0004fA!!qCB4\t\u001d\u0019Y\u0004\u0004b\u0001\u0005;\u0001bAa\u0002\u0003(\r-\u0004\u0003\u0002B\f\u0007[\"qaa\u001c\r\u0005\u0004\u0011iB\u0001\u0002Ug!911\u000f\u0007A\u0004\rU\u0014\u0001C1t)JL\u0007\u000f\\3\u0011\u0011\t\u001d!Q B\u000b\u0007o\u0002\"Ba\u0002\u0004Z\r}3QMB6\u0011\u001d\u00199\u0005\u0004a\u0002\u0007w\u0002bA!,\u00034\u000e}\u0003bBB'\u0019\u0001\u000f1q\u0010\t\u0007\u0005[\u0013\u0019l!\u001a\t\u000f\r\rE\u0002q\u0001\u0004\u0006\u0006\u00191\r^\u001a\u0011\r\t5&1WB6\u0003\r\u0019X-]\u000b\u0003\u0007\u0017\u0003bAa\u0004\u0004\u000e\nU\u0011\u0002BBH\u0003g\u0014!\"\u00138eKb,GmU3r\u00035\u0019X\u000f]3sIQ|\u0017I\u001d:bsV!1QSBN)\u0011\u00199j!(\u0011\r\t\u001d!qEBM!\u0011\u00119ba'\u0005\u000f\t\u0015gB1\u0001\u0003\u0000!I!\u0011\u0016\b\u0002\u0002\u0003\u000f1q\u0014\t\u0007\u0005[\u0013\u0019l!'\n\t\tm51U\u0005\u0005\u0007K\u000b9PA\bUe\u00064XM]:bE2,wJ\\2fS-\u0001!O\b\u001cg5\ns%C\u000b@\u0003\u0013=4'i\\8mK\u0006t7c\u0001\t\u0004.B!!qABX\u0013\u0011\u0019\t,a?\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\u00111q\u0017\t\u0004\u0005\u001f\u0001\"!B8g%\u00164W\u0003BB_\u0007\u0013\u001crAEB`\u0007\u000b\u001ci\r\u0005\u0003\u0003\b\r\u0005\u0017\u0002BBb\u0003w\u0014a!\u00118z-\u0006d\u0007#\u0002B\b\u0001\r\u001d\u0007\u0003\u0002B\f\u0007\u0013$qAa\u0007\u0013\u0005\u0004\u0019Y-\u0005\u0003\u0003 \r5\u0006\u0003\u0003B\b\u0005#\u00199ma4\u0011\r\t\u001d!qEBd\u0003\u0011\u0011X\r\u001d:\u0016\u0005\r=\u0017!\u0002:faJ\u0004C\u0003BBm\u0007;\u0004Raa7\u0013\u0007\u000fl\u0011\u0001\u0005\u0005\b\u0007#,\u0002\u0019ABh\u00039!\b.[:D_2dWm\u0019;j_:,\"aa9\u0011\r\t=1Q]Bd\u0013\u0011\u00199/a=\u0003\u0019]\u0013\u0018\r\u001d9fI\u0006\u0013(/Y=\u0002\u0019Q|7i\u001c7mK\u000e$\u0018n\u001c8\u0015\t\r\r8Q\u001e\u0005\b\u0007#<\u0002\u0019ABh\u0003)qWm\u001e\"vS2$WM]\u000b\u0003\u0007g\u0004ba!>\u0004|\u000e\u001dg\u0002\u0002B\b\u0007oLAa!?\u0002t\u0006a\u0011I\u001d:bs\n+\u0018\u000e\u001c3fe&!1\u0011XB\u007f\u0015\u0011\u0019I0a=\u0002\r1,gn\u001a;i+\t\u0011))A\u0003baBd\u0017\u0010\u0006\u0003\u0004H\u0012\u001d\u0001b\u0002C\u00055\u0001\u0007!QQ\u0001\u0006S:$W\r_\u0001\u0007kB$\u0017\r^3\u0015\r\t\u0015Cq\u0002C\t\u0011\u001d!Ia\u0007a\u0001\u0005\u000bCqAa4\u001c\u0001\u0004\u00199-\u0001\u0005iCND7i\u001c3f)\t\u0011))\u0001\u0004fcV\fGn\u001d\u000b\u0005\t7!\t\u0003\u0005\u0003\u0003\b\u0011u\u0011\u0002\u0002C\u0010\u0003w\u0014qAQ8pY\u0016\fg\u000eC\u0005\u0005$u\t\t\u00111\u0001\u0003\u0006\u0005\u0019\u0001\u0010J\u0019\u0003\r=4')\u001f;f'\u001dq2q\u0018C\u0015\tc\u0001RAa\u0004\u0001\tW\u0001BAa\u0002\u0005.%!AqFA~\u0005\u0011\u0011\u0015\u0010^3\u0011\u0011\t=!\u0011\u0003C\u0016\tg\u0001bAa\u0002\u0003(\u0011-RC\u0001C\u001a)\u0011!I\u0004b\u000f\u0011\u0007\rmg\u0004C\u0004\u0004R\u0006\u0002\r\u0001b\r\u0016\u0005\u0011}\u0002C\u0002B\b\u0007K$Y\u0003\u0006\u0003\u0005@\u0011\r\u0003bBBiG\u0001\u0007A1G\u000b\u0003\t\u000f\u0002Ba!>\u0005J%!AQEB\u007f)\u0011!Y\u0003\"\u0014\t\u000f\u0011%a\u00051\u0001\u0003\u0006R1!Q\tC)\t'Bq\u0001\"\u0003(\u0001\u0004\u0011)\tC\u0004\u0003P\u001e\u0002\r\u0001b\u000b\u0015\t\u0011mAq\u000b\u0005\n\tGI\u0013\u0011!a\u0001\u0005\u000b\u0011qa\u001c4TQ>\u0014HoE\u0004+\u0007\u007f#i\u0006\"\u001a\u0011\u000b\t=\u0001\u0001b\u0018\u0011\t\t\u001dA\u0011M\u0005\u0005\tG\nYPA\u0003TQ>\u0014H\u000f\u0005\u0005\u0003\u0010\tEAq\fC4!\u0019\u00119Aa\n\u0005`U\u0011Aq\r\u000b\u0005\t[\"y\u0007E\u0002\u0004\\*Bqa!5.\u0001\u0004!9'\u0006\u0002\u0005tA1!qBBs\t?\"B\u0001b\u001d\u0005x!91\u0011[\u0018A\u0002\u0011\u001dTC\u0001C>!\u0011\u0019)\u0010\" \n\t\u0011e3Q \u000b\u0005\t?\"\t\tC\u0004\u0005\nI\u0002\rA!\"\u0015\r\t\u0015CQ\u0011CD\u0011\u001d!Ia\ra\u0001\u0005\u000bCqAa44\u0001\u0004!y\u0006\u0006\u0003\u0005\u001c\u0011-\u0005\"\u0003C\u0012k\u0005\u0005\t\u0019\u0001B\u0003\u0005\u0019ygm\u00115beN9aga0\u0005\u0012\u0012e\u0005#\u0002B\b\u0001\u0011M\u0005\u0003\u0002B\u0004\t+KA\u0001b&\u0002|\n!1\t[1s!!\u0011yA!\u0005\u0005\u0014\u0012m\u0005C\u0002B\u0004\u0005O!\u0019*\u0006\u0002\u0005\u001cR!A\u0011\u0015CR!\r\u0019YN\u000e\u0005\b\u0007#L\u0004\u0019\u0001CN+\t!9\u000b\u0005\u0004\u0003\u0010\r\u0015H1\u0013\u000b\u0005\tO#Y\u000bC\u0004\u0004Rn\u0002\r\u0001b'\u0016\u0005\u0011=\u0006\u0003BB{\tcKA\u0001\"$\u0004~R!A1\u0013C[\u0011\u001d!IA\u0010a\u0001\u0005\u000b#bA!\u0012\u0005:\u0012m\u0006b\u0002C\u0005\u007f\u0001\u0007!Q\u0011\u0005\b\u0005\u001f|\u0004\u0019\u0001CJ)\u0011!Y\u0002b0\t\u0013\u0011\r\u0012)!AA\u0002\t\u0015!!B8g\u0013:$8c\u0002\"\u0004@\u0012\u0015Gq\u0019\t\u0006\u0005\u001f\u0001!Q\u0011\t\t\u0005\u001f\u0011\tB!\"\u0005JB1!q\u0001B\u0014\u0005\u000b+\"\u0001\"3\u0015\t\u0011=G\u0011\u001b\t\u0004\u00077\u0014\u0005bBBi\u000b\u0002\u0007A\u0011Z\u000b\u0003\t+\u0004bAa\u0004\u0004f\n\u0015E\u0003\u0002Ck\t3Dqa!5H\u0001\u0004!I-\u0006\u0002\u0005^B!1Q\u001fCp\u0013\u0011!\tm!@\u0015\t\t\u0015E1\u001d\u0005\b\t\u0013Q\u0005\u0019\u0001BC)\u0019\u0011)\u0005b:\u0005j\"9A\u0011B&A\u0002\t\u0015\u0005b\u0002Bh\u0017\u0002\u0007!Q\u0011\u000b\u0005\t7!i\u000fC\u0005\u0005$5\u000b\t\u00111\u0001\u0003\u0006\t1qN\u001a'p]\u001e\u001crATB`\tg$Y\u0010E\u0003\u0003\u0010\u0001!)\u0010\u0005\u0003\u0003\b\u0011]\u0018\u0002\u0002C}\u0003w\u0014A\u0001T8oOBA!q\u0002B\t\tk$i\u0010\u0005\u0004\u0003\b\t\u001dBQ_\u000b\u0003\t{$B!b\u0001\u0006\u0006A\u001911\u001c(\t\u000f\rE\u0017\u000b1\u0001\u0005~V\u0011Q\u0011\u0002\t\u0007\u0005\u001f\u0019)\u000f\">\u0015\t\u0015%QQ\u0002\u0005\b\u0007#\u001c\u0006\u0019\u0001C\u007f+\t)\t\u0002\u0005\u0003\u0004v\u0016M\u0011\u0002\u0002Cx\u0007{$B\u0001\">\u0006\u0018!9A\u0011\u0002,A\u0002\t\u0015EC\u0002B#\u000b7)i\u0002C\u0004\u0005\n]\u0003\rA!\"\t\u000f\t=w\u000b1\u0001\u0005vR!A1DC\u0011\u0011%!\u0019#WA\u0001\u0002\u0004\u0011)AA\u0004pM\u001acw.\u0019;\u0014\u000fi\u001by,b\n\u00060A)!q\u0002\u0001\u0006*A!!qAC\u0016\u0013\u0011)i#a?\u0003\u000b\u0019cw.\u0019;\u0011\u0011\t=!\u0011CC\u0015\u000bc\u0001bAa\u0002\u0003(\u0015%RCAC\u0019)\u0011)9$\"\u000f\u0011\u0007\rm'\fC\u0004\u0004Rv\u0003\r!\"\r\u0016\u0005\u0015u\u0002C\u0002B\b\u0007K,I\u0003\u0006\u0003\u0006>\u0015\u0005\u0003bBBi?\u0002\u0007Q\u0011G\u000b\u0003\u000b\u000b\u0002Ba!>\u0006H%!Q1EB\u007f)\u0011)I#b\u0013\t\u000f\u0011%!\r1\u0001\u0003\u0006R1!QIC(\u000b#Bq\u0001\"\u0003d\u0001\u0004\u0011)\tC\u0004\u0003P\u000e\u0004\r!\"\u000b\u0015\t\u0011mQQ\u000b\u0005\n\tG)\u0017\u0011!a\u0001\u0005\u000b\u0011\u0001b\u001c4E_V\u0014G.Z\n\bM\u000e}V1LC2!\u0015\u0011y\u0001AC/!\u0011\u00119!b\u0018\n\t\u0015\u0005\u00141 \u0002\u0007\t>,(\r\\3\u0011\u0011\t=!\u0011CC/\u000bK\u0002bAa\u0002\u0003(\u0015uSCAC3)\u0011)Y'\"\u001c\u0011\u0007\rmg\rC\u0004\u0004R&\u0004\r!\"\u001a\u0016\u0005\u0015E\u0004C\u0002B\b\u0007K,i\u0006\u0006\u0003\u0006r\u0015U\u0004bBBiW\u0002\u0007QQM\u000b\u0003\u000bs\u0002Ba!>\u0006|%!QqKB\u007f)\u0011)i&b \t\u000f\u0011%a\u000e1\u0001\u0003\u0006R1!QICB\u000b\u000bCq\u0001\"\u0003p\u0001\u0004\u0011)\tC\u0004\u0003P>\u0004\r!\"\u0018\u0015\t\u0011mQ\u0011\u0012\u0005\n\tG\t\u0018\u0011!a\u0001\u0005\u000b\u0011aa\u001c4V]&$8c\u0002@\u0004@\u0016=U\u0011\u0013\t\u0006\u0005\u001f\u0001!Q\t\t\t\u0005\u001f\u0011\tB!\u0012\u0006\u0014B1!q\u0001B\u0014\u0005\u000b*\"!b%\u0015\t\u0015eU1\u0014\t\u0004\u00077t\b\u0002CBi\u0003\u0007\u0001\r!b%\u0016\u0005\u0015}\u0005C\u0002B\b\u0007K\u0014)\u0005\u0006\u0003\u0006 \u0016\r\u0006\u0002CBi\u0003\u000f\u0001\r!b%\u0016\u0005\u0015\u001d\u0006\u0003BB{\u000bSKA!b#\u0004~R!!QICW\u0011!!I!!\u0004A\u0002\t\u0015EC\u0002B#\u000bc+\u0019\f\u0003\u0005\u0005\n\u0005=\u0001\u0019\u0001BC\u0011!\u0011y-a\u0004A\u0002\t\u0015C\u0003\u0002C\u000e\u000boC!\u0002b\t\u0002\u0014\u0005\u0005\t\u0019\u0001B\u0003\u0003\u0019yg-\u00168jiB!11\\A\f'\u0011\t9b!,\u0015\u0005\u0015m\u0016\u0001\u0007;iSN\u001cu\u000e\u001c7fGRLwN\u001c\u0013fqR,gn]5p]R!QqTCc\u0011!)9-a\u0007A\u0002\u0015e\u0015!\u0002\u0013uQ&\u001c\u0018A\u0006;p\u0007>dG.Z2uS>tG%\u001a=uK:\u001c\u0018n\u001c8\u0015\t\u00155W\u0011\u001b\u000b\u0005\u000b?+y\r\u0003\u0005\u0004R\u0006u\u0001\u0019ACJ\u0011!)9-!\bA\u0002\u0015e\u0015\u0001\u00068fo\n+\u0018\u000e\u001c3fe\u0012*\u0007\u0010^3og&|g\u000e\u0006\u0003\u0006(\u0016]\u0007\u0002CCd\u0003?\u0001\r!\"'\u0002!1,gn\u001a;iI\u0015DH/\u001a8tS>tG\u0003\u0002BC\u000b;D\u0001\"b2\u0002\"\u0001\u0007Q\u0011T\u0001\u0010CB\u0004H.\u001f\u0013fqR,gn]5p]R!Q1]Ct)\u0011\u0011)%\":\t\u0011\u0011%\u00111\u0005a\u0001\u0005\u000bC\u0001\"b2\u0002$\u0001\u0007Q\u0011T\u0001\u0011kB$\u0017\r^3%Kb$XM\\:j_:$B!\"<\u0006tR1!QICx\u000bcD\u0001\u0002\"\u0003\u0002&\u0001\u0007!Q\u0011\u0005\t\u0005\u001f\f)\u00031\u0001\u0003F!AQqYA\u0013\u0001\u0004)I*\u0001\niCND7i\u001c3fI\u0015DH/\u001a8tS>tG\u0003\u0002C\u000b\u000bsD\u0001\"b2\u0002(\u0001\u0007Q\u0011T\u0001\u0011KF,\u0018\r\\:%Kb$XM\\:j_:$B!b@\u0007\u0004Q!A1\u0004D\u0001\u0011)!\u0019#!\u000b\u0002\u0002\u0003\u0007!Q\u0001\u0005\t\u000b\u000f\fI\u00031\u0001\u0006\u001a\u00069qNZ*i_J$\b\u0003BBn\u0003[\u0019B!!\f\u0004.R\u0011aq\u0001\u000b\u0005\tg2y\u0001\u0003\u0005\u0006H\u0006E\u0002\u0019\u0001C7)\u00111\u0019Bb\u0006\u0015\t\u0011MdQ\u0003\u0005\t\u0007#\f\u0019\u00041\u0001\u0005h!AQqYA\u001a\u0001\u0004!i\u0007\u0006\u0003\u0005|\u0019m\u0001\u0002CCd\u0003k\u0001\r\u0001\"\u001c\u0015\t\t\u0015eq\u0004\u0005\t\u000b\u000f\f9\u00041\u0001\u0005nQ!a1\u0005D\u0014)\u0011!yF\"\n\t\u0011\u0011%\u0011\u0011\ba\u0001\u0005\u000bC\u0001\"b2\u0002:\u0001\u0007AQ\u000e\u000b\u0005\rW1\t\u0004\u0006\u0004\u0003F\u00195bq\u0006\u0005\t\t\u0013\tY\u00041\u0001\u0003\u0006\"A!qZA\u001e\u0001\u0004!y\u0006\u0003\u0005\u0006H\u0006m\u0002\u0019\u0001C7)\u0011!)B\"\u000e\t\u0011\u0015\u001d\u0017Q\ba\u0001\t[\"BA\"\u000f\u0007>Q!A1\u0004D\u001e\u0011)!\u0019#a\u0010\u0002\u0002\u0003\u0007!Q\u0001\u0005\t\u000b\u000f\fy\u00041\u0001\u0005n\u0005)qN\u001a*fMB!11\\A\"'\u0011\t\u0019e!,\u0015\u0005\u0019\u0005S\u0003\u0002D%\r\u001f\"BAb\u0013\u0007RA1!qBBs\r\u001b\u0002BAa\u0006\u0007P\u0011A!1DA$\u0005\u0004\u0019Y\r\u0003\u0005\u0006H\u0006\u001d\u0003\u0019\u0001D*!\u0015\u0019YN\u0005D'+\u001119Fb\u0018\u0015\t\u0019ecQ\r\u000b\u0005\r72\t\u0007\u0005\u0004\u0003\u0010\r\u0015hQ\f\t\u0005\u0005/1y\u0006\u0002\u0005\u0003\u001c\u0005%#\u0019ABf\u0011!\u0019\t.!\u0013A\u0002\u0019\r\u0004C\u0002B\u0004\u0005O1i\u0006\u0003\u0005\u0006H\u0006%\u0003\u0019\u0001D4!\u0015\u0019YN\u0005D/+\u00111YG\"\u001d\u0015\t\u00195d1\u000f\t\u0007\u0007k\u001cYPb\u001c\u0011\t\t]a\u0011\u000f\u0003\t\u00057\tYE1\u0001\u0004L\"AQqYA&\u0001\u00041)\bE\u0003\u0004\\J1y'\u0006\u0003\u0007z\u0019\u0005E\u0003\u0002BC\rwB\u0001\"b2\u0002N\u0001\u0007aQ\u0010\t\u0006\u00077\u0014bq\u0010\t\u0005\u0005/1\t\t\u0002\u0005\u0003\u001c\u00055#\u0019ABf+\u00111)Ib#\u0015\t\u0019\u001deq\u0012\u000b\u0005\r\u00133i\t\u0005\u0003\u0003\u0018\u0019-E\u0001\u0003B\u000e\u0003\u001f\u0012\raa3\t\u0011\u0011%\u0011q\na\u0001\u0005\u000bC\u0001\"b2\u0002P\u0001\u0007a\u0011\u0013\t\u0006\u00077\u0014b\u0011R\u000b\u0005\r+3y\n\u0006\u0003\u0007\u0018\u001a\u0005FC\u0002B#\r33Y\n\u0003\u0005\u0005\n\u0005E\u0003\u0019\u0001BC\u0011!\u0011y-!\u0015A\u0002\u0019u\u0005\u0003\u0002B\f\r?#\u0001Ba\u0007\u0002R\t\u000711\u001a\u0005\t\u000b\u000f\f\t\u00061\u0001\u0007$B)11\u001c\n\u0007\u001eV!aq\u0015DX)\u0011!)B\"+\t\u0011\u0015\u001d\u00171\u000ba\u0001\rW\u0003Raa7\u0013\r[\u0003BAa\u0006\u00070\u0012A!1DA*\u0005\u0004\u0019Y-\u0006\u0003\u00074\u001a}F\u0003\u0002D[\rs#B\u0001b\u0007\u00078\"QA1EA+\u0003\u0003\u0005\rA!\u0002\t\u0011\u0015\u001d\u0017Q\u000ba\u0001\rw\u0003Raa7\u0013\r{\u0003BAa\u0006\u0007@\u0012A!1DA+\u0005\u0004\u0019Y-\u0001\u0004pM2{gn\u001a\t\u0005\u00077\fIf\u0005\u0003\u0002Z\r5FC\u0001Db)\u0011)IAb3\t\u0011\u0015\u001d\u0017Q\fa\u0001\u000b\u0007!BAb4\u0007TR!Q\u0011\u0002Di\u0011!\u0019\t.a\u0018A\u0002\u0011u\b\u0002CCd\u0003?\u0002\r!b\u0001\u0015\t\u0015Eaq\u001b\u0005\t\u000b\u000f\f\t\u00071\u0001\u0006\u0004Q!!Q\u0011Dn\u0011!)9-a\u0019A\u0002\u0015\rA\u0003\u0002Dp\rG$B\u0001\">\u0007b\"AA\u0011BA3\u0001\u0004\u0011)\t\u0003\u0005\u0006H\u0006\u0015\u0004\u0019AC\u0002)\u001119O\"<\u0015\r\t\u0015c\u0011\u001eDv\u0011!!I!a\u001aA\u0002\t\u0015\u0005\u0002\u0003Bh\u0003O\u0002\r\u0001\">\t\u0011\u0015\u001d\u0017q\ra\u0001\u000b\u0007!B\u0001\"\u0006\u0007r\"AQqYA5\u0001\u0004)\u0019\u0001\u0006\u0003\u0007v\u001aeH\u0003\u0002C\u000e\roD!\u0002b\t\u0002l\u0005\u0005\t\u0019\u0001B\u0003\u0011!)9-a\u001bA\u0002\u0015\r\u0011!B8g\u0013:$\b\u0003BBn\u0003_\u001aB!a\u001c\u0004.R\u0011aQ \u000b\u0005\t+<)\u0001\u0003\u0005\u0006H\u0006M\u0004\u0019\u0001Ch)\u00119Ia\"\u0004\u0015\t\u0011Uw1\u0002\u0005\t\u0007#\f)\b1\u0001\u0005J\"AQqYA;\u0001\u0004!y\r\u0006\u0003\u0005^\u001eE\u0001\u0002CCd\u0003o\u0002\r\u0001b4\u0015\t\t\u0015uQ\u0003\u0005\t\u000b\u000f\fI\b1\u0001\u0005PR!q\u0011DD\u000f)\u0011\u0011)ib\u0007\t\u0011\u0011%\u00111\u0010a\u0001\u0005\u000bC\u0001\"b2\u0002|\u0001\u0007Aq\u001a\u000b\u0005\u000fC99\u0003\u0006\u0004\u0003F\u001d\rrQ\u0005\u0005\t\t\u0013\ti\b1\u0001\u0003\u0006\"A!qZA?\u0001\u0004\u0011)\t\u0003\u0005\u0006H\u0006u\u0004\u0019\u0001Ch)\u0011!)bb\u000b\t\u0011\u0015\u001d\u0017q\u0010a\u0001\t\u001f$Bab\f\b4Q!A1DD\u0019\u0011)!\u0019#!!\u0002\u0002\u0003\u0007!Q\u0001\u0005\t\u000b\u000f\f\t\t1\u0001\u0005P\u00069qN\u001a$m_\u0006$\b\u0003BBn\u0003\u000b\u001bB!!\"\u0004.R\u0011qq\u0007\u000b\u0005\u000b{9y\u0004\u0003\u0005\u0006H\u0006%\u0005\u0019AC\u001c)\u00119\u0019eb\u0012\u0015\t\u0015urQ\t\u0005\t\u0007#\fY\t1\u0001\u00062!AQqYAF\u0001\u0004)9\u0004\u0006\u0003\u0006F\u001d-\u0003\u0002CCd\u0003\u001b\u0003\r!b\u000e\u0015\t\t\u0015uq\n\u0005\t\u000b\u000f\fy\t1\u0001\u00068Q!q1KD,)\u0011)Ic\"\u0016\t\u0011\u0011%\u0011\u0011\u0013a\u0001\u0005\u000bC\u0001\"b2\u0002\u0012\u0002\u0007Qq\u0007\u000b\u0005\u000f7:\t\u0007\u0006\u0004\u0003F\u001dusq\f\u0005\t\t\u0013\t\u0019\n1\u0001\u0003\u0006\"A!qZAJ\u0001\u0004)I\u0003\u0003\u0005\u0006H\u0006M\u0005\u0019AC\u001c)\u0011!)b\"\u001a\t\u0011\u0015\u001d\u0017Q\u0013a\u0001\u000bo!Ba\"\u001b\bnQ!A1DD6\u0011)!\u0019#a&\u0002\u0002\u0003\u0007!Q\u0001\u0005\t\u000b\u000f\f9\n1\u0001\u00068\u0005AqN\u001a#pk\ndW\r\u0005\u0003\u0004\\\u0006m5\u0003BAN\u0007[#\"a\"\u001d\u0015\t\u0015Et\u0011\u0010\u0005\t\u000b\u000f\fy\n1\u0001\u0006lQ!qQPDA)\u0011)\thb \t\u0011\rE\u0017\u0011\u0015a\u0001\u000bKB\u0001\"b2\u0002\"\u0002\u0007Q1\u000e\u000b\u0005\u000bs:)\t\u0003\u0005\u0006H\u0006\r\u0006\u0019AC6)\u0011\u0011)i\"#\t\u0011\u0015\u001d\u0017Q\u0015a\u0001\u000bW\"Ba\"$\b\u0012R!QQLDH\u0011!!I!a*A\u0002\t\u0015\u0005\u0002CCd\u0003O\u0003\r!b\u001b\u0015\t\u001dUu1\u0014\u000b\u0007\u0005\u000b:9j\"'\t\u0011\u0011%\u0011\u0011\u0016a\u0001\u0005\u000bC\u0001Ba4\u0002*\u0002\u0007QQ\f\u0005\t\u000b\u000f\fI\u000b1\u0001\u0006lQ!AQCDP\u0011!)9-a+A\u0002\u0015-D\u0003BDR\u000fO#B\u0001b\u0007\b&\"QA1EAW\u0003\u0003\u0005\rA!\u0002\t\u0011\u0015\u001d\u0017Q\u0016a\u0001\u000bW\naa\u001c4DQ\u0006\u0014\b\u0003BBn\u0003c\u001bB!!-\u0004.R\u0011q1\u0016\u000b\u0005\tO;\u0019\f\u0003\u0005\u0006H\u0006U\u0006\u0019\u0001CQ)\u001199lb/\u0015\t\u0011\u001dv\u0011\u0018\u0005\t\u0007#\f9\f1\u0001\u0005\u001c\"AQqYA\\\u0001\u0004!\t\u000b\u0006\u0003\u00050\u001e}\u0006\u0002CCd\u0003s\u0003\r\u0001\")\u0015\t\t\u0015u1\u0019\u0005\t\u000b\u000f\fY\f1\u0001\u0005\"R!qqYDf)\u0011!\u0019j\"3\t\u0011\u0011%\u0011Q\u0018a\u0001\u0005\u000bC\u0001\"b2\u0002>\u0002\u0007A\u0011\u0015\u000b\u0005\u000f\u001f<)\u000e\u0006\u0004\u0003F\u001dEw1\u001b\u0005\t\t\u0013\ty\f1\u0001\u0003\u0006\"A!qZA`\u0001\u0004!\u0019\n\u0003\u0005\u0006H\u0006}\u0006\u0019\u0001CQ)\u0011!)b\"7\t\u0011\u0015\u001d\u0017\u0011\u0019a\u0001\tC#Ba\"8\bbR!A1DDp\u0011)!\u0019#a1\u0002\u0002\u0003\u0007!Q\u0001\u0005\t\u000b\u000f\f\u0019\r1\u0001\u0005\"\u00061qN\u001a\"zi\u0016\u0004Baa7\u0002HN!\u0011qYBW)\t9)\u000f\u0006\u0003\u0005@\u001d5\b\u0002CCd\u0003\u0017\u0004\r\u0001\"\u000f\u0015\t\u001dExQ\u001f\u000b\u0005\t\u007f9\u0019\u0010\u0003\u0005\u0004R\u00065\u0007\u0019\u0001C\u001a\u0011!)9-!4A\u0002\u0011eB\u0003\u0002C$\u000fsD\u0001\"b2\u0002P\u0002\u0007A\u0011\b\u000b\u0005\u0005\u000b;i\u0010\u0003\u0005\u0006H\u0006E\u0007\u0019\u0001C\u001d)\u0011A\t\u0001#\u0002\u0015\t\u0011-\u00022\u0001\u0005\t\t\u0013\t\u0019\u000e1\u0001\u0003\u0006\"AQqYAj\u0001\u0004!I\u0004\u0006\u0003\t\n!=AC\u0002B#\u0011\u0017Ai\u0001\u0003\u0005\u0005\n\u0005U\u0007\u0019\u0001BC\u0011!\u0011y-!6A\u0002\u0011-\u0002\u0002CCd\u0003+\u0004\r\u0001\"\u000f\u0015\t\u0011U\u00012\u0003\u0005\t\u000b\u000f\f9\u000e1\u0001\u0005:Q!\u0001r\u0003E\u000e)\u0011!Y\u0002#\u0007\t\u0015\u0011\r\u0012\u0011\\A\u0001\u0002\u0004\u0011)\u0001\u0003\u0005\u0006H\u0006e\u0007\u0019\u0001C\u001d\u0003%ygMQ8pY\u0016\fg\u000e\u0005\u0003\u0004\\\u0006u7\u0003BAo\u0007[#\"\u0001c\b\u0015\t!\u001d\u0002\u0012\u0006\t\u0007\u0005\u001f\u0019)\u000fb\u0007\t\u0011\u0015\u001d\u0017\u0011\u001da\u0001\u0011W\u00012aa7s)\u0011Ay\u0003#\u000e\u0015\t!\u001d\u0002\u0012\u0007\u0005\t\u0007#\f\u0019\u000f1\u0001\t4A1!q\u0001B\u0014\t7A\u0001\"b2\u0002d\u0002\u0007\u00012\u0006\u000b\u0005\u0011sAi\u0004\u0005\u0003\u0004v\"m\u0012\u0002BBU\u0007{D\u0001\"b2\u0002f\u0002\u0007\u00012\u0006\u000b\u0005\u0005\u000bC\t\u0005\u0003\u0005\u0006H\u0006\u001d\b\u0019\u0001E\u0016)\u0011A)\u0005#\u0013\u0015\t\u0011m\u0001r\t\u0005\t\t\u0013\tI\u000f1\u0001\u0003\u0006\"AQqYAu\u0001\u0004AY\u0003\u0006\u0003\tN!MCC\u0002B#\u0011\u001fB\t\u0006\u0003\u0005\u0005\n\u0005-\b\u0019\u0001BC\u0011!\u0011y-a;A\u0002\u0011m\u0001\u0002CCd\u0003W\u0004\r\u0001c\u000b\u0015\t\u0011U\u0001r\u000b\u0005\t\u000b\u000f\fi\u000f1\u0001\t,Q!\u00012\fE0)\u0011!Y\u0002#\u0018\t\u0015\u0011\r\u0012q^A\u0001\u0002\u0004\u0011)\u0001\u0003\u0005\u0006H\u0006=\b\u0019\u0001E\u0016'\u001d\u00118q\u0018E2\u0011K\u0002RAa\u0004\u0001\t7\u0001\u0002Ba\u0004\u0003\u0012\u0011m\u00012G\u000b\u0003\u0011g!B\u0001c\u000b\tl!91\u0011[;A\u0002!MRC\u0001E\u0014)\u0011A9\u0003#\u001d\t\u000f\rEw\u000f1\u0001\t4U\u0011\u0001\u0012\b\u000b\u0005\t7A9\bC\u0004\u0005\ni\u0004\rA!\"\u0015\r\t\u0015\u00032\u0010E?\u0011\u001d!Ia\u001fa\u0001\u0005\u000bCqAa4|\u0001\u0004!Y\u0002\u0006\u0003\u0005\u001c!\u0005\u0005\"\u0003C\u0012{\u0006\u0005\t\u0019\u0001B\u0003\u0003!\t%O]1z\u001fB\u001c\b")
public interface ArrayOps<T>
extends ArrayLike<T, Object>,
CustomParallelizable<T, ParArray<T>> {
    public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag var1);

    private Class<?> elementClass() {
        return this.repr().getClass().getComponentType();
    }

    @Override
    default public <U> void copyToArray(Object xs, int start, int len) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int n = RichInt$.MODULE$.min$extension(len, ScalaRunTime$.MODULE$.array_length(this.repr()));
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int l = RichInt$.MODULE$.min$extension(n, ScalaRunTime$.MODULE$.array_length(xs) - start);
        if (l > 0) {
            Array$.MODULE$.copy(this.repr(), 0, xs, start, l);
        }
    }

    @Override
    default public Object slice(int from, int until) {
        Object reprVal = this.repr();
        int lo = package$.MODULE$.max(from, 0);
        int hi = package$.MODULE$.min(package$.MODULE$.max(until, 0), ScalaRunTime$.MODULE$.array_length(reprVal));
        int size = package$.MODULE$.max(hi - lo, 0);
        Object result2 = Array.newInstance(this.elementClass(), size);
        if (size > 0) {
            Array$.MODULE$.copy(reprVal, lo, result2, 0, size);
        }
        return result2;
    }

    @Override
    default public <U> Object toArray(ClassTag<U> evidence$1) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Class<?> thatElementClass = evidence$1.runtimeClass();
        if (this.elementClass() == thatElementClass) {
            return this.repr();
        }
        return this.scala$collection$mutable$ArrayOps$$super$toArray(evidence$1);
    }

    default public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
        int currentLength = ScalaRunTime$.MODULE$.array_length(this.repr());
        Object result2 = evidence$2.newArray(currentLength + 1);
        Array$.MODULE$.copy(this.repr(), 0, result2, 0, currentLength);
        ScalaRunTime$.MODULE$.array_update(result2, currentLength, elem);
        return result2;
    }

    default public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
        int currentLength = ScalaRunTime$.MODULE$.array_length(this.repr());
        Object result2 = evidence$3.newArray(currentLength + 1);
        ScalaRunTime$.MODULE$.array_update(result2, 0, elem);
        Array$.MODULE$.copy(this.repr(), 0, result2, 1, currentLength);
        return result2;
    }

    @Override
    default public ParArray<T> par() {
        return ParArray$.MODULE$.handoff(this.repr());
    }

    default public <U> Object flatten(Function1<T, Traversable<U>> asTrav, ClassTag<U> m) {
        ArrayBuilder b = Array$.MODULE$.newBuilder(m);
        b.sizeHint(BoxesRunTime.unboxToInt(new ofInt(Predef$.MODULE$.intArrayOps((int[])this.map((Function1<Object, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToInteger(n = x0$1 instanceof IndexedSeq ? ((SeqLike)x0$1).size() : 0), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Int())))).sum(Numeric$IntIsIntegral$.MODULE$)));
        this.foreach((Function1<Object, ArrayBuilder> & java.io.Serializable & Serializable)xs -> (ArrayBuilder)b.$plus$plus$eq((TraversableOnce)asTrav.apply(xs)));
        return b.result();
    }

    default public <U> Object[] transpose(Function1<T, Object> asArray) {
        ArrayBuilder bb = Array$.MODULE$.newBuilder(ClassTag$.MODULE$.apply(this.elementClass()));
        if (this.isEmpty()) {
            return (Object[])bb.result();
        }
        ArrayBuilder[] bs = (ArrayBuilder[])Predef$.MODULE$.genericArrayOps(asArray.apply(this.head())).map((Function1<Object, ArrayBuilder> & java.io.Serializable & Serializable)x$1 -> this.mkRowBuilder$1(), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(ArrayBuilder.class)));
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)xs -> {
            ArrayOps.$anonfun$transpose$2(asArray, bs, xs);
            return BoxedUnit.UNIT;
        });
        ofRef<Object> foreach_this = new ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])bs));
        int foreach_len = foreach_this.length();
        for (int foreach_i = 0; foreach_i < foreach_len; ++foreach_i) {
            ArrayBuilder arrayBuilder = (ArrayBuilder)foreach_this.apply(foreach_i);
            bb.$plus$eq(arrayBuilder.result());
        }
        return (Object[])bb.result();
    }

    default public <T1, T2> Tuple2<Object, Object> unzip(Function1<T, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
        Object a1 = ct1.newArray(this.length());
        Object a2 = ct2.newArray(this.length());
        for (int i = 0; i < this.length(); ++i) {
            Object e = this.apply(i);
            ScalaRunTime$.MODULE$.array_update(a1, i, asPair.apply(e)._1());
            ScalaRunTime$.MODULE$.array_update(a2, i, asPair.apply(e)._2());
        }
        return new Tuple2<Object, Object>(a1, a2);
    }

    default public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<T, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
        Object a1 = ct1.newArray(this.length());
        Object a2 = ct2.newArray(this.length());
        Object a3 = ct3.newArray(this.length());
        for (int i = 0; i < this.length(); ++i) {
            Object e = this.apply(i);
            ScalaRunTime$.MODULE$.array_update(a1, i, asTriple.apply(e)._1());
            ScalaRunTime$.MODULE$.array_update(a2, i, asTriple.apply(e)._2());
            ScalaRunTime$.MODULE$.array_update(a3, i, asTriple.apply(e)._3());
        }
        return new Tuple3<Object, Object, Object>(a1, a2, a3);
    }

    @Override
    default public scala.collection.mutable.IndexedSeq<T> seq() {
        return this.thisCollection();
    }

    private ArrayBuilder mkRowBuilder$1() {
        return Array$.MODULE$.newBuilder(ClassTag$.MODULE$.apply(this.elementClass().getComponentType()));
    }

    public static /* synthetic */ void $anonfun$transpose$3(ArrayBuilder[] bs$1, IntRef i$1, Object x) {
        bs$1[i$1.elem].$plus$eq(x);
        ++i$1.elem;
    }

    public static /* synthetic */ void $anonfun$transpose$2(Function1 asArray$1, ArrayBuilder[] bs$1, Object xs) {
        IntRef i = IntRef.create(0);
        Predef$.MODULE$.genericArrayOps(asArray$1.apply(xs)).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            ArrayOps.$anonfun$transpose$3(bs$1, i, x);
            return BoxedUnit.UNIT;
        });
    }

    public static void $init$(ArrayOps $this) {
    }

    public static final class ofBoolean
    implements ArrayOps<Object> {
        private final boolean[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<boolean[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<boolean[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<boolean[], boolean[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<boolean[], boolean[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, boolean[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, boolean[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<boolean[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<boolean[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<boolean[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<boolean[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<boolean[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<boolean[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<boolean[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<boolean[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<boolean[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<boolean[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<boolean[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<boolean[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<boolean[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<boolean[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<boolean[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<boolean[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<boolean[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<boolean[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<boolean[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<boolean[], boolean[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, boolean[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<boolean[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<boolean[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<boolean[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<boolean[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<boolean[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, boolean[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public boolean[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofBoolean$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(boolean[] repr) {
            return ArrayOps$ofBoolean$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofBoolean newBuilder() {
            return ArrayOps$ofBoolean$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofBoolean$.MODULE$.length$extension(this.repr());
        }

        @Override
        public boolean apply(int index) {
            return ArrayOps$ofBoolean$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, boolean elem) {
            ArrayOps$ofBoolean$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofBoolean$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofBoolean$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofBoolean(boolean[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofByte
    implements ArrayOps<Object> {
        private final byte[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<byte[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<byte[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<byte[], byte[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<byte[], byte[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, byte[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, byte[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<byte[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<byte[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<byte[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<byte[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<byte[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<byte[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<byte[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<byte[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<byte[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<byte[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<byte[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<byte[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<byte[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<byte[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<byte[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<byte[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<byte[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<byte[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<byte[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<byte[], byte[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, byte[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<byte[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<byte[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<byte[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<byte[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<byte[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, byte[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public byte[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofByte$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(byte[] repr) {
            return ArrayOps$ofByte$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofByte newBuilder() {
            return ArrayOps$ofByte$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofByte$.MODULE$.length$extension(this.repr());
        }

        @Override
        public byte apply(int index) {
            return ArrayOps$ofByte$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, byte elem) {
            ArrayOps$ofByte$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofByte$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofByte$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofByte(byte[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofChar
    implements ArrayOps<Object> {
        private final char[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<char[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<char[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<char[], char[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<char[], char[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, char[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, char[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<char[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<char[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<char[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<char[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<char[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<char[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<char[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<char[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<char[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<char[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<char[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<char[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<char[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<char[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<char[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<char[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<char[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<char[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<char[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<char[], char[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, char[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<char[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<char[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<char[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<char[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<char[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, char[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public char[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofChar$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(char[] repr) {
            return ArrayOps$ofChar$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofChar newBuilder() {
            return ArrayOps$ofChar$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofChar$.MODULE$.length$extension(this.repr());
        }

        @Override
        public char apply(int index) {
            return ArrayOps$ofChar$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, char elem) {
            ArrayOps$ofChar$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofChar$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofChar$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofChar(char[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofDouble
    implements ArrayOps<Object> {
        private final double[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<double[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<double[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<double[], double[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<double[], double[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, double[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, double[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<double[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<double[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<double[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<double[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<double[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<double[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<double[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<double[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<double[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<double[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<double[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<double[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<double[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<double[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<double[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<double[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<double[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<double[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<double[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<double[], double[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, double[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<double[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<double[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<double[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<double[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<double[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, double[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public double[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofDouble$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(double[] repr) {
            return ArrayOps$ofDouble$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofDouble newBuilder() {
            return ArrayOps$ofDouble$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofDouble$.MODULE$.length$extension(this.repr());
        }

        @Override
        public double apply(int index) {
            return ArrayOps$ofDouble$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, double elem) {
            ArrayOps$ofDouble$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofDouble$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofDouble$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofDouble(double[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofFloat
    implements ArrayOps<Object> {
        private final float[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<float[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<float[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<float[], float[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<float[], float[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, float[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, float[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<float[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<float[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<float[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<float[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<float[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<float[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<float[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<float[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<float[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<float[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<float[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<float[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<float[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<float[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<float[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<float[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<float[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<float[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<float[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<float[], float[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, float[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<float[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<float[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<float[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<float[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<float[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, float[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public float[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofFloat$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(float[] repr) {
            return ArrayOps$ofFloat$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofFloat newBuilder() {
            return ArrayOps$ofFloat$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofFloat$.MODULE$.length$extension(this.repr());
        }

        @Override
        public float apply(int index) {
            return ArrayOps$ofFloat$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, float elem) {
            ArrayOps$ofFloat$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofFloat$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofFloat$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofFloat(float[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofInt
    implements ArrayOps<Object> {
        private final int[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<int[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<int[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<int[], int[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<int[], int[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, int[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, int[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<int[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<int[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<int[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<int[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<int[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<int[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<int[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<int[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<int[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<int[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<int[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<int[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<int[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<int[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<int[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<int[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<int[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<int[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<int[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<int[], int[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, int[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<int[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<int[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<int[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<int[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<int[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, int[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public int[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofInt$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(int[] repr) {
            return ArrayOps$ofInt$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofInt newBuilder() {
            return ArrayOps$ofInt$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofInt$.MODULE$.length$extension(this.repr());
        }

        @Override
        public int apply(int index) {
            return ArrayOps$ofInt$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, int elem) {
            ArrayOps$ofInt$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofInt$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofInt$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofInt(int[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofLong
    implements ArrayOps<Object> {
        private final long[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<long[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<long[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<long[], long[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<long[], long[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, long[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, long[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<long[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<long[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<long[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<long[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<long[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<long[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<long[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<long[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<long[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<long[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<long[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<long[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<long[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<long[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<long[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<long[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<long[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<long[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<long[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<long[], long[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, long[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<long[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<long[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<long[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<long[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<long[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, long[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public long[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofLong$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(long[] repr) {
            return ArrayOps$ofLong$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofLong newBuilder() {
            return ArrayOps$ofLong$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofLong$.MODULE$.length$extension(this.repr());
        }

        @Override
        public long apply(int index) {
            return ArrayOps$ofLong$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, long elem) {
            ArrayOps$ofLong$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofLong$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofLong$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofLong(long[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofRef<T>
    implements ArrayOps<T> {
        private final T[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<T> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<T, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<T, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<T, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<T, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<T> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<T, ParArray<T>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<T, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<T, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<T, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<T> find(Function1<T, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, T, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<T, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, T, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<T, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<T[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<T[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public T head() {
            return (T)IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public T last() {
            return (T)IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<T[], T[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<T[], T[]> span(Function1<T, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<T, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<T, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<T, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<T> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<T> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<T, T[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<T, T[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<T> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<T[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<T[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<T, B> f, CanBuildFrom<T[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<T[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<T[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<T[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<T[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<T[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<T[], B, That> bf) {
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
        public String toString() {
            return SeqLike.toString$(this);
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
        public Iterable<T> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<T> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<T[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<T[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<T[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<T[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
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
        public final boolean isTraversableAgain() {
            return TraversableLike.isTraversableAgain$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return TraversableLike.hasDefiniteSize$(this);
        }

        @Override
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<T[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<T[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<T[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<T, B> f, CanBuildFrom<T[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<T, GenTraversableOnce<B>> f, CanBuildFrom<T[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<T, B> pf, CanBuildFrom<T[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<T[], T[]> partition(Function1<T, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, T[]> groupBy(Function1<T, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<T[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, T, B> op, CanBuildFrom<T[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<T, B, B> op, CanBuildFrom<T[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<T> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<T> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<T[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<T[]> inits() {
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
        public FilterMonadic<T, T[]> withFilter(Function1<T, Object> p) {
            return TraversableLike.withFilter$(this, p);
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
            return (T)TraversableOnce.min$(this, cmp);
        }

        @Override
        public <B> T max(Ordering<B> cmp) {
            return (T)TraversableOnce.max$(this, cmp);
        }

        @Override
        public <B> T maxBy(Function1<T, B> f, Ordering<B> cmp) {
            return (T)TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> T minBy(Function1<T, B> f, Ordering<B> cmp) {
            return (T)TraversableOnce.minBy$(this, f, cmp);
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
        public scala.collection.immutable.IndexedSeq<T> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
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
        public T[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<T> thisCollection() {
            return ArrayOps$ofRef$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<T> toCollection(T[] repr) {
            return ArrayOps$ofRef$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofRef<T> newBuilder() {
            return ArrayOps$ofRef$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofRef$.MODULE$.length$extension(this.repr());
        }

        @Override
        public T apply(int index) {
            return ArrayOps$ofRef$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, T elem) {
            ArrayOps$ofRef$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofRef$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofRef$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofRef(T[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofShort
    implements ArrayOps<Object> {
        private final short[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<Object> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<Object, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<Object, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<Object, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<Object, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<Object> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<Object, ParArray<Object>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<Object, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<Object, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Object, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<Object> find(Function1<Object, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Object, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<Object, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<short[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<short[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<short[], short[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<short[], short[]> span(Function1<Object, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<Object, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<Object> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<Object> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<Object, short[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<Object, short[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<Object> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<short[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<short[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<Object, B> f, CanBuildFrom<short[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<short[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<short[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<short[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<short[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<short[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<short[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<Object, B, Object> p) {
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
        public Seq<Object> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<Object, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<Object, Object> p) {
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
        public int lastIndexWhere(Function1<Object, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<Object> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Object> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<short[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<short[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<short[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<short[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<Object> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<short[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<short[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<short[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Object, B> f, CanBuildFrom<short[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Object, GenTraversableOnce<B>> f, CanBuildFrom<short[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<Object, B> pf, CanBuildFrom<short[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<short[], short[]> partition(Function1<Object, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, short[]> groupBy(Function1<Object, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<short[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Object, B> op, CanBuildFrom<short[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Object, B, B> op, CanBuildFrom<short[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Object> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<Object> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<short[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<short[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Object> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Object, short[]> withFilter(Function1<Object, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<Object> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Object, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Object, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Object, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Object, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Object, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Object, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Object, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<Object> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Object, Tuple2<T, U>> ev) {
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
        public short[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<Object> thisCollection() {
            return ArrayOps$ofShort$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<Object> toCollection(short[] repr) {
            return ArrayOps$ofShort$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofShort newBuilder() {
            return ArrayOps$ofShort$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofShort$.MODULE$.length$extension(this.repr());
        }

        @Override
        public short apply(int index) {
            return ArrayOps$ofShort$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, short elem) {
            ArrayOps$ofShort$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofShort$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofShort$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofShort(short[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }

    public static final class ofUnit
    implements ArrayOps<BoxedUnit> {
        private final BoxedUnit[] repr;

        @Override
        public /* synthetic */ Object scala$collection$mutable$ArrayOps$$super$toArray(ClassTag evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public <U> void copyToArray(Object xs, int start, int len) {
            ((ArrayOps)this).copyToArray(xs, start, len);
        }

        @Override
        public Object slice(int from, int until) {
            return ((ArrayOps)this).slice(from, until);
        }

        @Override
        public <U> Object toArray(ClassTag<U> evidence$1) {
            return ((ArrayOps)this).toArray(evidence$1);
        }

        @Override
        public <B> Object $colon$plus(B elem, ClassTag<B> evidence$2) {
            return ((ArrayOps)this).$colon$plus(elem, evidence$2);
        }

        @Override
        public <B> Object $plus$colon(B elem, ClassTag<B> evidence$3) {
            return ((ArrayOps)this).$plus$colon(elem, evidence$3);
        }

        @Override
        public ParArray<BoxedUnit> par() {
            return ((ArrayOps)this).par();
        }

        @Override
        public <U> Object flatten(Function1<BoxedUnit, Traversable<U>> asTrav, ClassTag<U> m) {
            return ((ArrayOps)this).flatten(asTrav, m);
        }

        @Override
        public <U> Object[] transpose(Function1<BoxedUnit, Object> asArray) {
            return ((ArrayOps)this).transpose(asArray);
        }

        @Override
        public <T1, T2> Tuple2<Object, Object> unzip(Function1<BoxedUnit, Tuple2<T1, T2>> asPair, ClassTag<T1> ct1, ClassTag<T2> ct2) {
            return ((ArrayOps)this).unzip(asPair, ct1, ct2);
        }

        @Override
        public <T1, T2, T3> Tuple3<Object, Object, Object> unzip3(Function1<BoxedUnit, Tuple3<T1, T2, T3>> asTriple, ClassTag<T1> ct1, ClassTag<T2> ct2, ClassTag<T3> ct3) {
            return ((ArrayOps)this).unzip3(asTriple, ct1, ct2, ct3);
        }

        @Override
        public scala.collection.mutable.IndexedSeq<BoxedUnit> seq() {
            return ((ArrayOps)this).seq();
        }

        @Override
        public Combiner<BoxedUnit, ParArray<BoxedUnit>> parCombiner() {
            return CustomParallelizable.parCombiner$(this);
        }

        @Override
        public IndexedSeq<Object> deep() {
            return ArrayLike.deep$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceLeft(Function2 op) {
            return TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$reduceRight(Function2 op) {
            return this.iterator().reduceRight(op);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$zip(GenIterable that, CanBuildFrom bf) {
            return IterableLike.zip$(this, that, bf);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$head() {
            return IterableLike.head$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$last() {
            return TraversableLike.last$(this);
        }

        @Override
        public /* synthetic */ Object scala$collection$IndexedSeqOptimized$$super$init() {
            return TraversableLike.init$(this);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$sameElements(GenIterable that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public /* synthetic */ boolean scala$collection$IndexedSeqOptimized$$super$endsWith(GenSeq that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public boolean isEmpty() {
            return IndexedSeqOptimized.isEmpty$(this);
        }

        @Override
        public <U> void foreach(Function1<BoxedUnit, U> f) {
            IndexedSeqOptimized.foreach$(this, f);
        }

        @Override
        public boolean forall(Function1<BoxedUnit, Object> p) {
            return IndexedSeqOptimized.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<BoxedUnit, Object> p) {
            return IndexedSeqOptimized.exists$(this, p);
        }

        @Override
        public Option<BoxedUnit> find(Function1<BoxedUnit, Object> p) {
            return IndexedSeqOptimized.find$(this, p);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, BoxedUnit, B> op) {
            return (B)IndexedSeqOptimized.foldLeft$(this, z, op);
        }

        @Override
        public <B> B foldRight(B z, Function2<BoxedUnit, B, B> op) {
            return (B)IndexedSeqOptimized.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, BoxedUnit, B> op) {
            return (B)IndexedSeqOptimized.reduceLeft$(this, op);
        }

        @Override
        public <B> B reduceRight(Function2<BoxedUnit, B, B> op) {
            return (B)IndexedSeqOptimized.reduceRight$(this, op);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<BoxedUnit[], Tuple2<A1, B>, That> bf) {
            return (That)IndexedSeqOptimized.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<BoxedUnit[], Tuple2<A1, Object>, That> bf) {
            return (That)IndexedSeqOptimized.zipWithIndex$(this, bf);
        }

        @Override
        public Object head() {
            return IndexedSeqOptimized.head$(this);
        }

        @Override
        public Object tail() {
            return IndexedSeqOptimized.tail$(this);
        }

        @Override
        public Object last() {
            return IndexedSeqOptimized.last$(this);
        }

        @Override
        public Object init() {
            return IndexedSeqOptimized.init$(this);
        }

        @Override
        public Object take(int n) {
            return IndexedSeqOptimized.take$(this, n);
        }

        @Override
        public Object drop(int n) {
            return IndexedSeqOptimized.drop$(this, n);
        }

        @Override
        public Object takeRight(int n) {
            return IndexedSeqOptimized.takeRight$(this, n);
        }

        @Override
        public Object dropRight(int n) {
            return IndexedSeqOptimized.dropRight$(this, n);
        }

        @Override
        public Tuple2<BoxedUnit[], BoxedUnit[]> splitAt(int n) {
            return IndexedSeqOptimized.splitAt$(this, n);
        }

        @Override
        public Object takeWhile(Function1 p) {
            return IndexedSeqOptimized.takeWhile$(this, p);
        }

        @Override
        public Object dropWhile(Function1 p) {
            return IndexedSeqOptimized.dropWhile$(this, p);
        }

        @Override
        public Tuple2<BoxedUnit[], BoxedUnit[]> span(Function1<BoxedUnit, Object> p) {
            return IndexedSeqOptimized.span$(this, p);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IndexedSeqOptimized.sameElements$(this, that);
        }

        @Override
        public int lengthCompare(int len) {
            return IndexedSeqOptimized.lengthCompare$(this, len);
        }

        @Override
        public int segmentLength(Function1<BoxedUnit, Object> p, int from) {
            return IndexedSeqOptimized.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<BoxedUnit, Object> p, int from) {
            return IndexedSeqOptimized.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<BoxedUnit, Object> p, int end) {
            return IndexedSeqOptimized.lastIndexWhere$(this, p, end);
        }

        @Override
        public Object reverse() {
            return IndexedSeqOptimized.reverse$(this);
        }

        @Override
        public Iterator<BoxedUnit> reverseIterator() {
            return IndexedSeqOptimized.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return IndexedSeqOptimized.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return IndexedSeqOptimized.endsWith$(this, that);
        }

        @Override
        public List<BoxedUnit> toList() {
            return IndexedSeqOptimized.toList$(this);
        }

        @Override
        public IndexedSeqView<BoxedUnit, BoxedUnit[]> view() {
            return scala.collection.mutable.IndexedSeqLike.view$(this);
        }

        @Override
        public IndexedSeqView<BoxedUnit, BoxedUnit[]> view(int from, int until) {
            return scala.collection.mutable.IndexedSeqLike.view$(this, from, until);
        }

        @Override
        public Iterator<BoxedUnit> iterator() {
            return IndexedSeqLike.iterator$(this);
        }

        @Override
        public <A1> Buffer<A1> toBuffer() {
            return IndexedSeqLike.toBuffer$(this);
        }

        @Override
        public int sizeHintIfCheap() {
            return IndexedSeqLike.sizeHintIfCheap$(this);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public Iterator<BoxedUnit[]> permutations() {
            return SeqLike.permutations$(this);
        }

        @Override
        public Iterator<BoxedUnit[]> combinations(int n) {
            return SeqLike.combinations$(this, n);
        }

        @Override
        public <B, That> That reverseMap(Function1<BoxedUnit, B> f, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)SeqLike.reverseMap$(this, f, bf);
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
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<BoxedUnit[], B, That> bf) {
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
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)SeqLike.patch$(this, from, patch, replaced, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)SeqLike.updated$(this, index, elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)SeqLike.$plus$colon$(this, elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)SeqLike.$colon$plus$(this, elem, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)SeqLike.padTo$(this, len, elem, bf);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<BoxedUnit, B, Object> p) {
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
        public Seq<BoxedUnit> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public String toString() {
            return SeqLike.toString$(this);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<BoxedUnit, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<BoxedUnit, Object> p) {
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
        public int lastIndexWhere(Function1<BoxedUnit, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public Iterable<BoxedUnit> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<BoxedUnit> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Iterator<BoxedUnit[]> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<BoxedUnit[]> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<BoxedUnit[]> sliding(int size, int step) {
            return IterableLike.sliding$(this, size, step);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<BoxedUnit[], Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Stream<BoxedUnit> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
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
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<BoxedUnit, B> f, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<BoxedUnit, GenTraversableOnce<B>> f, CanBuildFrom<BoxedUnit[], B, That> bf) {
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
        public <B, That> That collect(PartialFunction<BoxedUnit, B> pf, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<BoxedUnit[], BoxedUnit[]> partition(Function1<BoxedUnit, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, BoxedUnit[]> groupBy(Function1<BoxedUnit, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<BoxedUnit[], B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, BoxedUnit, B> op, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<BoxedUnit, B, B> op, CanBuildFrom<BoxedUnit[], B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<BoxedUnit> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Option<BoxedUnit> lastOption() {
            return TraversableLike.lastOption$(this);
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
        public Iterator<BoxedUnit[]> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<BoxedUnit[]> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<BoxedUnit> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, BoxedUnit, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<BoxedUnit, BoxedUnit[]> withFilter(Function1<BoxedUnit, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public List<BoxedUnit> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<BoxedUnit, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<BoxedUnit, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, BoxedUnit, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<BoxedUnit, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, BoxedUnit, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<BoxedUnit, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, BoxedUnit, B> seqop, Function2<B, B, B> combop) {
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
        public Object min(Ordering cmp) {
            return TraversableOnce.min$(this, cmp);
        }

        @Override
        public Object max(Ordering cmp) {
            return TraversableOnce.max$(this, cmp);
        }

        @Override
        public Object maxBy(Function1 f, Ordering cmp) {
            return TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public Object minBy(Function1 f, Ordering cmp) {
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
        public scala.collection.immutable.IndexedSeq<BoxedUnit> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<BoxedUnit> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<BoxedUnit, Tuple2<T, U>> ev) {
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
        public BoxedUnit[] repr() {
            return this.repr;
        }

        @Override
        public WrappedArray<BoxedUnit> thisCollection() {
            return ArrayOps$ofUnit$.MODULE$.thisCollection$extension(this.repr());
        }

        @Override
        public WrappedArray<BoxedUnit> toCollection(BoxedUnit[] repr) {
            return ArrayOps$ofUnit$.MODULE$.toCollection$extension(this.repr(), repr);
        }

        public ArrayBuilder.ofUnit newBuilder() {
            return ArrayOps$ofUnit$.MODULE$.newBuilder$extension(this.repr());
        }

        @Override
        public int length() {
            return ArrayOps$ofUnit$.MODULE$.length$extension(this.repr());
        }

        @Override
        public void apply(int index) {
            ArrayOps$ofUnit$.MODULE$.apply$extension(this.repr(), index);
        }

        @Override
        public void update(int index, BoxedUnit elem) {
            ArrayOps$ofUnit$.MODULE$.update$extension(this.repr(), index, elem);
        }

        @Override
        public int hashCode() {
            return ArrayOps$ofUnit$.MODULE$.hashCode$extension(this.repr());
        }

        @Override
        public boolean equals(Object x$1) {
            return ArrayOps$ofUnit$.MODULE$.equals$extension(this.repr(), x$1);
        }

        public ofUnit(BoxedUnit[] repr) {
            this.repr = repr;
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            IterableLike.$init$(this);
            GenSeqLike.$init$(this);
            SeqLike.$init$(this);
            IndexedSeqLike.$init$(this);
            scala.collection.mutable.IndexedSeqLike.$init$(this);
            IndexedSeqOptimized.$init$(this);
            ArrayLike.$init$(this);
            CustomParallelizable.$init$(this);
            ArrayOps.$init$(this);
        }
    }
}

