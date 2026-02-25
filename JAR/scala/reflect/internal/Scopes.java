/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import java.util.Arrays;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractTraversable;
import scala.collection.BufferedIterator;
import scala.collection.GenIterable;
import scala.collection.GenMap;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.package$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Scopes;
import scala.reflect.internal.Names;
import scala.reflect.internal.ScopeStats;
import scala.reflect.internal.Scopes$;
import scala.reflect.internal.Scopes$EmptyScope$;
import scala.reflect.internal.Scopes$LookupAmbiguous$;
import scala.reflect.internal.Scopes$LookupInaccessible$;
import scala.reflect.internal.Scopes$LookupNotFound$;
import scala.reflect.internal.Scopes$LookupSucceeded$;
import scala.reflect.internal.Scopes$Scope$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.Statistics;
import scala.reflect.internal.util.StatisticsStatics;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0015uf\u0001DA>\u0003{\u0002\n1!\u0001\u0002\f\u0016U\u0006bBAP\u0001\u0011\u0005\u0011\u0011\u0015\u0005\f\u0003S\u0003\u0001\u0019!C\u0001\u0003\u000b\u000bY\u000bC\u0006\u00024\u0002\u0001\r\u0011\"\u0001\u0002\u0006\u0006Uf!CA^\u0001A\u0005\u0019\u0011EA_\u0011\u001d\ty\n\u0002C\u0001\u0003CCq!a0\u0005\r\u0003\t\t\rC\u0004\u0002P\u0012!\t!!5\u0007\r\tE\u0006\u0001\u0011BZ\u0011)\u0011)\f\u0003BK\u0002\u0013\u0005!q\u0017\u0005\u000b\u0005\u0007D!\u0011#Q\u0001\n\te\u0006BCA`\u0011\tU\r\u0011\"\u0001\u0002B\"Q!q\u0010\u0005\u0003\u0012\u0003\u0006I!a1\t\u000f\t%\u0001\u0002\"\u0001\u0003F\"9\u0011q\u001a\u0005\u0005B\u0005E\u0007\"\u0003B\r\u0011\u0005\u0005I\u0011\u0001Bg\u0011%\u0011y\u0002CI\u0001\n\u0003\u0011\u0019\u000eC\u0005\u0003\u0014\"\t\n\u0011\"\u0001\u0003\u0010\"I!q\u0007\u0005\u0002\u0002\u0013\u0005#\u0011\b\u0005\n\u0005\u0013B\u0011\u0011!C\u0001\u0003WC\u0011Ba\u0013\t\u0003\u0003%\tAa6\t\u0013\t]\u0003\"!A\u0005B\te\u0003\"\u0003B4\u0011\u0005\u0005I\u0011\u0001Bn\u0011%\u0011i\u0007CA\u0001\n\u0003\u0012y\u0007C\u0005\u0003r!\t\t\u0011\"\u0011\u0003t!I!Q\u000f\u0005\u0002\u0002\u0013\u0005#q\\\u0004\n\u0005G\u0004\u0011\u0011!E\u0001\u0005K4\u0011B!-\u0001\u0003\u0003E\tAa:\t\u000f\t%1\u0004\"\u0001\u0003v\"I!\u0011O\u000e\u0002\u0002\u0013\u0015#1\u000f\u0005\n\u0005o\\\u0012\u0011!CA\u0005sD\u0011Ba@\u001c\u0003\u0003%\ti!\u0001\u0007\r\u0005m\u0007\u0001QAo\u0011)\ti\u000f\tBK\u0002\u0013\u0005\u0011q\u001e\u0005\u000b\u0005\u000f\u0001#\u0011#Q\u0001\n\u0005E\bb\u0002B\u0005A\u0011\u0005!1\u0002\u0005\b\u0003\u007f\u0003C\u0011\u0001B\t\u0011%\u0011I\u0002IA\u0001\n\u0003\u0011Y\u0002C\u0005\u0003 \u0001\n\n\u0011\"\u0001\u0003\"!I!q\u0007\u0011\u0002\u0002\u0013\u0005#\u0011\b\u0005\n\u0005\u0013\u0002\u0013\u0011!C\u0001\u0003WC\u0011Ba\u0013!\u0003\u0003%\tA!\u0014\t\u0013\t]\u0003%!A\u0005B\te\u0003\"\u0003B4A\u0005\u0005I\u0011\u0001B5\u0011%\u0011i\u0007IA\u0001\n\u0003\u0012y\u0007C\u0005\u0003r\u0001\n\t\u0011\"\u0011\u0003t!I!Q\u000f\u0011\u0002\u0002\u0013\u0005#qO\u0004\n\u0007'\u0001\u0011\u0011!E\u0001\u0007+1\u0011\"a7\u0001\u0003\u0003E\taa\u0006\t\u000f\t%\u0001\u0007\"\u0001\u0004 !I!\u0011\u000f\u0019\u0002\u0002\u0013\u0015#1\u000f\u0005\n\u0005o\u0004\u0014\u0011!CA\u0007CA\u0011Ba@1\u0003\u0003%\ti!\n\u0007\r\tm\u0004\u0001\u0011B?\u0011)\ty,\u000eBK\u0002\u0013\u0005\u0011\u0011\u0019\u0005\u000b\u0005\u007f*$\u0011#Q\u0001\n\u0005\r\u0007BCAwk\tU\r\u0011\"\u0001\u0002p\"Q!qA\u001b\u0003\u0012\u0003\u0006I!!=\t\u000f\t%Q\u0007\"\u0001\u0003\u0002\"I!\u0011D\u001b\u0002\u0002\u0013\u0005!\u0011\u0012\u0005\n\u0005?)\u0014\u0013!C\u0001\u0005\u001fC\u0011Ba%6#\u0003%\tA!\t\t\u0013\t]R'!A\u0005B\te\u0002\"\u0003B%k\u0005\u0005I\u0011AAV\u0011%\u0011Y%NA\u0001\n\u0003\u0011)\nC\u0005\u0003XU\n\t\u0011\"\u0011\u0003Z!I!qM\u001b\u0002\u0002\u0013\u0005!\u0011\u0014\u0005\n\u0005[*\u0014\u0011!C!\u0005_B\u0011B!\u001d6\u0003\u0003%\tEa\u001d\t\u0013\tUT'!A\u0005B\tuu!CB\u0016\u0001\u0005\u0005\t\u0012AB\u0017\r%\u0011Y\bAA\u0001\u0012\u0003\u0019y\u0003C\u0004\u0003\n\u001d#\taa\r\t\u0013\tEt)!A\u0005F\tM\u0004\"\u0003B|\u000f\u0006\u0005I\u0011QB\u001b\u0011%\u0011ypRA\u0001\n\u0003\u001bYdB\u0004\u0004D\u0001A\tIa*\u0007\u000f\t\u0005\u0006\u0001#!\u0003$\"9!\u0011B'\u0005\u0002\t\u0015\u0006bBA`\u001b\u0012\u0005!\u0011\u0003\u0005\n\u0005oi\u0015\u0011!C!\u0005sA\u0011B!\u0013N\u0003\u0003%\t!a+\t\u0013\t-S*!A\u0005\u0002\t%\u0006\"\u0003B,\u001b\u0006\u0005I\u0011\tB-\u0011%\u00119'TA\u0001\n\u0003\u0011i\u000bC\u0005\u0003n5\u000b\t\u0011\"\u0011\u0003p!I!\u0011O'\u0002\u0002\u0013\u0005#1\u000f\u0004\u0007\u0007\u000b\u0002\u0001aa\u0012\t\u0015\r%sK!a\u0001\n\u0003\t\t\r\u0003\u0006\u0004L]\u0013\t\u0019!C\u0001\u0007\u001bB!b!\u0015X\u0005\u0003\u0005\u000b\u0015BAb\u0011)\u0019\u0019f\u0016BC\u0002\u0013\u00051Q\u000b\u0005\u000b\u000b\u000f9&\u0011!Q\u0001\n\r]\u0003b\u0002B\u0005/\u0012\u0005Q\u0011\u0002\u0005\n\u000b\u001f9\u0006\u0019!C\u0001\u0007[B\u0011\"\"\u0005X\u0001\u0004%\t!b\u0005\t\u0011\u0015]q\u000b)Q\u0005\u0007_B\u0011\u0002\"\u0003X\u0001\u0004%\ta!\u001c\t\u0013\u0015eq\u000b1A\u0005\u0002\u0015m\u0001\u0002CC\u0010/\u0002\u0006Kaa\u001c\t\u000f\u0015\u0005r\u000b\"\u0001\u0002,\"9!QN,\u0005B\t=\u0004b\u0002B9/\u0012\u0005Cq \u0005\b\t':FQAC\u0012\u0011\u001d)I\u0003\u0001C\u0005\u000bW9q!\"\r\u0001\u0011\u0003)\u0019DB\u0004\u0004Z\u0001A\t!\"\u000e\t\u000f\t%!\u000e\"\u0001\u00068!9Q\u0011\b6\u0005\u0002\u0015mbABB-\u0001\u0001\u0019Y\u0006\u0003\u0005\u0003\n5$\t\u0002AB5\u00115\u0019Y'\u001ca\u0001\u0002\u0004%\t!!\"\u0004n!i1\u0011O7A\u0002\u0003\u0007I\u0011AAC\u0007gB1ba\u001en\u0001\u0004\u0005\t\u0015)\u0003\u0004p!a1\u0011P7\u0003\u0002\u0003\u0007I\u0011\u0001\u0001\u0004|!Y1qP7\u0003\u0002\u0003\u0005\u000b\u0015BAW\u00111\u0019\t)\u001cB\u0001\u0002\u0004%\t\u0001ABB\u0011-\u0019i)\u001cB\u0001\u0002\u0003\u0006Kaa\"\t\u0013\r=U\u000e1A\u0005\n\rE\u0005\"CBQ[\u0002\u0007I\u0011BBR\u0011!\u00199+\u001cQ!\n\rM\u0005\"CBU[\u0002\u0007I\u0011BAV\u0011%\u0019Y+\u001ca\u0001\n\u0013\u0019i\u000b\u0003\u0005\u000426\u0004\u000b\u0015BAW\u0011\u001d\u0019\u0019,\u001cC\u0005\u0003CC\u0011b!.n\u0005\u0004%iaa.\t\u0011\ruV\u000e)A\u0007\u0007sC\u0011ba0n\u0005\u0004%ia!1\t\u0011\r\u001dW\u000e)A\u0007\u0007\u0007D\u0011b!3n\u0005\u0004%iaa3\t\u0011\rEW\u000e)A\u0007\u0007\u001bDqaa5n\t\u0003\u0019)\u0006C\u0004\u0004V6$\t%!5\t\u000f\r]W\u000e\"\u0011\u0002,\"91\u0011\\7\u0005\n\u0005-\u0006bBBn[\u0012E1Q\u001c\u0005\b\u0007GlG\u0011BBs\u0011\u001d\u0019I/\u001cC\u0001\u0007WDq\u0001\"\u0001n\t\u000b!\u0019\u0001C\u0004\u0005\f5$\t\u0001\"\u0004\t\u000f\u0011EQ\u000e\"\u0001\u0005\u0014!9AQD7\u0005\n\u0005\u0005\u0006b\u0002C\u0010[\u0012%A\u0011\u0005\u0005\n\tSi\u0017\u0013!C\u0005\tWAq\u0001b\fn\t\u0003!\t\u0004C\u0004\u0005D5$\t\u0001\"\u0012\t\u000f\u0011\rS\u000e\"\u0001\u0005J!9AQJ7\u0005\u0002\u0011=\u0003b\u0002C+[\u0012\u0005Aq\u000b\u0005\b\t7jG\u0011\u0001C/\u0011\u001d!\t'\u001cC\u0001\tGBq\u0001b\u001an\t\u0003!I\u0007C\u0004\u0005r5$\t\u0001b\u001d\t\u000f\u0011eT\u000e\"\u0001\u0005|!9AqP7\u0005\u0006\u0011\u0005\u0005b\u0002CC[\u0012\u0005Aq\u0011\u0005\b\t\u0017kG\u0011\u0001CG\u0011\u001d!\u0019*\u001cC\u0003\t+Cq\u0001b(n\t\u0003!\t\u000bC\u0004\u0005(6$\t\u0001\"+\t\u000f\u00115V\u000e\"\u0011\u0004\u0012\"9AqV7\u0005\u0002\rE\u0005b\u0002CY[\u0012\u0005\u00111\u0016\u0005\b\tgkG\u0011\u0001C[\u0011\u001d!9,\u001cC!\tsCq\u0001b4n\t\u0003\"\t\u000eC\u0004\u0005X6$\t\u0005\"7\t\u000f\u0011uW\u000e\"\u0001\u0004\u0012\"9Aq^7\u0005B\u0011E\bb\u0002B9[\u0012\u0005Cq \u0005\r\u000b\u0003i'\u0011!a\u0001\n\u0003\u0001\u00111\u0016\u0005\r\u000b\u0007i'\u0011!a\u0001\n\u0003\u0001QQ\u0001\u0005\n\u000b\u001b\u0002!\u0019!C\u0002\u000b\u001f*a!\"\u0017\u0001\u0001\r]\u0003\"CC.\u0001\t\u0007I1AC/\u0011\u001d)\u0019\u0007\u0001C\u0001\u0007+B\u0011\"\"\u001a\u0001\t\u0003\t)i!\u0016\t\u000f\u0015\u001d\u0004\u0001\"\u0002\u0006j!9Qq\u000e\u0001\u0005\u0002\u0015E\u0004bBC>\u0001\u0011\u0005QQ\u0010\u0005\b\u000b\u0007\u0003A\u0011ACC\u000f\u001d))\n\u0001E\u0001\u000b/3q!\"'\u0001\u0011\u0003)Y\n\u0003\u0005\u0003\n\u00055D\u0011ACO\u0011!\u0019Y.!\u001c\u0005B\u0015}eABCR\u0001\u0001))\u000bC\u0006\u0004T\u0005M$\u0011!Q\u0001\n\u0005\r\u0007\u0002\u0003B\u0005\u0003g\"\t!b*\t\u0013\u00155\u0006A1A\u0005\u000e\u0015=&AB*d_B,7O\u0003\u0003\u0002\u0000\u0005\u0005\u0015\u0001C5oi\u0016\u0014h.\u00197\u000b\t\u0005\r\u0015QQ\u0001\be\u00164G.Z2u\u0015\t\t9)A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u000b\u0001\ti)!&\u0011\t\u0005=\u0015\u0011S\u0007\u0003\u0003\u000bKA!a%\u0002\u0006\n1\u0011I\\=SK\u001a\u0004B!a&\u0002\u001e6\u0011\u0011\u0011\u0014\u0006\u0005\u00037\u000b\t)A\u0002ba&LA!a\u001f\u0002\u001a\u00061A%\u001b8ji\u0012\"\"!a)\u0011\t\u0005=\u0015QU\u0005\u0005\u0003O\u000b)I\u0001\u0003V]&$\u0018AC:d_B,7i\\;oiV\u0011\u0011Q\u0016\t\u0005\u0003\u001f\u000by+\u0003\u0003\u00022\u0006\u0015%aA%oi\u0006q1oY8qK\u000e{WO\u001c;`I\u0015\fH\u0003BAR\u0003oC\u0011\"!/\u0004\u0003\u0003\u0005\r!!,\u0002\u0007a$\u0013G\u0001\u0006OC6,Gj\\8lkB\u001c2\u0001BAG\u0003\u0019\u0019\u00180\u001c2pYV\u0011\u00111\u0019\t\u0005\u0003\u000b\f9-D\u0001\u0001\u0013\u0011\tI-a3\u0003\rMKXNY8m\u0013\u0011\ti-! \u0003\u000fMKXNY8mg\u0006I\u0011n]*vG\u000e,7o]\u000b\u0003\u0003'\u0004B!a$\u0002V&!\u0011q[AC\u0005\u001d\u0011un\u001c7fC:LS\u0001\u0002\u00116\u001b\"\u0011q\u0002T8pWV\u0004\u0018)\u001c2jOV|Wo]\n\nA\u00055\u0015q\\Aq\u0003O\u00042!!2\u0005!\u0011\ty)a9\n\t\u0005\u0015\u0018Q\u0011\u0002\b!J|G-^2u!\u0011\ty)!;\n\t\u0005-\u0018Q\u0011\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0004[N<WCAAy!\u0011\t\u0019P!\u0001\u000f\t\u0005U\u0018Q \t\u0005\u0003o\f))\u0004\u0002\u0002z*!\u00111`AE\u0003\u0019a$o\\8u}%!\u0011q`AC\u0003\u0019\u0001&/\u001a3fM&!!1\u0001B\u0003\u0005\u0019\u0019FO]5oO*!\u0011q`AC\u0003\u0011i7o\u001a\u0011\u0002\rqJg.\u001b;?)\u0011\u0011iAa\u0004\u0011\u0007\u0005\u0015\u0007\u0005C\u0004\u0002n\u000e\u0002\r!!=\u0016\u0005\tM\u0001\u0003BAc\u0005+IAAa\u0006\u0002L\nAaj\\*z[\n|G.\u0001\u0003d_BLH\u0003\u0002B\u0007\u0005;A\u0011\"!<&!\u0003\u0005\r!!=\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\u0011!1\u0005\u0016\u0005\u0003c\u0014)c\u000b\u0002\u0003(A!!\u0011\u0006B\u001a\u001b\t\u0011YC\u0003\u0003\u0003.\t=\u0012!C;oG\",7m[3e\u0015\u0011\u0011\t$!\"\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u00036\t-\"!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0006i\u0001O]8ek\u000e$\bK]3gSb,\"Aa\u000f\u0011\t\tu\"qI\u0007\u0003\u0005\u007fQAA!\u0011\u0003D\u0005!A.\u00198h\u0015\t\u0011)%\u0001\u0003kCZ\f\u0017\u0002\u0002B\u0002\u0005\u007f\tA\u0002\u001d:pIV\u001cG/\u0011:jif\fa\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0003\u0003P\tU\u0003\u0003BAH\u0005#JAAa\u0015\u0002\u0006\n\u0019\u0011I\\=\t\u0013\u0005e\u0016&!AA\u0002\u00055\u0016a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\tm\u0003C\u0002B/\u0005G\u0012y%\u0004\u0002\u0003`)!!\u0011MAC\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0005K\u0012yF\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dG\u0003BAj\u0005WB\u0011\"!/,\u0003\u0003\u0005\rAa\u0014\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!,\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"Aa\u000f\u0002\r\u0015\fX/\u00197t)\u0011\t\u0019N!\u001f\t\u0013\u0005ef&!AA\u0002\t=#A\u0005'p_.,\b/\u00138bG\u000e,7o]5cY\u0016\u001c\u0012\"NAG\u0003?\f\t/a:\u0002\u000fMLXNY8mAQ1!1\u0011BC\u0005\u000f\u00032!!26\u0011\u001d\tyL\u000fa\u0001\u0003\u0007Dq!!<;\u0001\u0004\t\t\u0010\u0006\u0004\u0003\u0004\n-%Q\u0012\u0005\n\u0003\u007f[\u0004\u0013!a\u0001\u0003\u0007D\u0011\"!<<!\u0003\u0005\r!!=\u0016\u0005\tE%\u0006BAb\u0005K\tabY8qs\u0012\"WMZ1vYR$#\u0007\u0006\u0003\u0003P\t]\u0005\"CA]\u0001\u0006\u0005\t\u0019AAW)\u0011\t\u0019Na'\t\u0013\u0005e&)!AA\u0002\t=C\u0003BAj\u0005?C\u0011\"!/F\u0003\u0003\u0005\rAa\u0014\u0003\u001d1{wn[;q\u001d>$hi\\;oINIQ*!$\u0002`\u0006\u0005\u0018q\u001d\u000b\u0003\u0005O\u00032!!2N)\u0011\u0011yEa+\t\u0013\u0005e&+!AA\u0002\u00055F\u0003BAj\u0005_C\u0011\"!/U\u0003\u0003\u0005\rAa\u0014\u0003\u001f1{wn[;q'V\u001c7-Z3eK\u0012\u001c\u0012\u0002CAG\u0003?\f\t/a:\u0002\u0013E,\u0018\r\\5gS\u0016\u0014XC\u0001B]!\u0011\t)Ma/\n\t\tu&q\u0018\u0002\u0005)J,W-\u0003\u0003\u0003B\u0006u$!\u0002+sK\u0016\u001c\u0018AC9vC2Lg-[3sAQ1!q\u0019Be\u0005\u0017\u00042!!2\t\u0011\u001d\u0011),\u0004a\u0001\u0005sCq!a0\u000e\u0001\u0004\t\u0019\r\u0006\u0004\u0003H\n='\u0011\u001b\u0005\n\u0005k{\u0001\u0013!a\u0001\u0005sC\u0011\"a0\u0010!\u0003\u0005\r!a1\u0016\u0005\tU'\u0006\u0002B]\u0005K!BAa\u0014\u0003Z\"I\u0011\u0011\u0018\u000b\u0002\u0002\u0003\u0007\u0011Q\u0016\u000b\u0005\u0003'\u0014i\u000eC\u0005\u0002:Z\t\t\u00111\u0001\u0003PQ!\u00111\u001bBq\u0011%\tI,GA\u0001\u0002\u0004\u0011y%A\bM_>\\W\u000f]*vG\u000e,W\rZ3e!\r\t)mG\n\u00067\t%\u0018q\u001d\t\u000b\u0005W\u0014\tP!/\u0002D\n\u001dWB\u0001Bw\u0015\u0011\u0011y/!\"\u0002\u000fI,h\u000e^5nK&!!1\u001fBw\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gN\r\u000b\u0003\u0005K\fQ!\u00199qYf$bAa2\u0003|\nu\bb\u0002B[=\u0001\u0007!\u0011\u0018\u0005\b\u0003\u007fs\u0002\u0019AAb\u0003\u001d)h.\u00199qYf$Baa\u0001\u0004\u0010A1\u0011qRB\u0003\u0007\u0013IAaa\u0002\u0002\u0006\n1q\n\u001d;j_:\u0004\u0002\"a$\u0004\f\te\u00161Y\u0005\u0005\u0007\u001b\t)I\u0001\u0004UkBdWM\r\u0005\n\u0007#y\u0012\u0011!a\u0001\u0005\u000f\f1\u0001\u001f\u00131\u0003=aun\\6va\u0006k'-[4v_V\u001c\bcAAcaM)\u0001g!\u0007\u0002hBA!1^B\u000e\u0003c\u0014i!\u0003\u0003\u0004\u001e\t5(!E!cgR\u0014\u0018m\u0019;Gk:\u001cG/[8ocQ\u00111Q\u0003\u000b\u0005\u0005\u001b\u0019\u0019\u0003C\u0004\u0002nN\u0002\r!!=\u0015\t\r\u001d2\u0011\u0006\t\u0007\u0003\u001f\u001b)!!=\t\u0013\rEA'!AA\u0002\t5\u0011A\u0005'p_.,\b/\u00138bG\u000e,7o]5cY\u0016\u00042!!2H'\u001595\u0011GAt!)\u0011YO!=\u0002D\u0006E(1\u0011\u000b\u0003\u0007[!bAa!\u00048\re\u0002bBA`\u0015\u0002\u0007\u00111\u0019\u0005\b\u0003[T\u0005\u0019AAy)\u0011\u0019id!\u0011\u0011\r\u0005=5QAB !!\tyia\u0003\u0002D\u0006E\b\"CB\t\u0017\u0006\u0005\t\u0019\u0001BB\u00039aun\\6va:{GOR8v]\u0012\u0014!bU2pa\u0016,e\u000e\u001e:z'\r9\u0016QR\u0001\u0004gfl\u0017aB:z[~#S-\u001d\u000b\u0005\u0003G\u001by\u0005C\u0005\u0002:f\u000b\t\u00111\u0001\u0002D\u0006!1/_7!\u0003\u0015ywO\\3s+\t\u00199\u0006E\u0002\u0002F6\u0014QaU2pa\u0016\u001cr!\\AG\u0007;\u001a\u0019\u0007\u0005\u0003\u0002F\u000e}\u0013\u0002BB1\u0003;\u0013\u0001bU2pa\u0016\f\u0005/\u001b\t\u0005\u0003\u000b\u001c)'\u0003\u0003\u0004h\u0005u%AD'f[\n,'oU2pa\u0016\f\u0005/\u001b\u000b\u0003\u0007/\nQ!\u001a7f[N,\"aa\u001c\u0011\u0007\u0005\u0015w+A\u0005fY\u0016l7o\u0018\u0013fcR!\u00111UB;\u0011%\tI\f]A\u0001\u0002\u0004\u0019y'\u0001\u0004fY\u0016l7\u000fI\u00010g\u000e\fG.\u0019\u0013sK\u001adWm\u0019;%S:$XM\u001d8bY\u0012\u001a6m\u001c9fg\u0012\"c.Z:uS:<G.\u001a<fY~#S-\u001d\u000b\u0005\u0003G\u001bi\bC\u0005\u0002:J\f\t\u00111\u0001\u0002.\u0006a3oY1mC\u0012\u0012XM\u001a7fGR$\u0013N\u001c;fe:\fG\u000eJ*d_B,7\u000f\n\u0013oKN$\u0018N\\4mKZ,G\u000eI\u0001-g\u000e\fG.\u0019\u0013sK\u001adWm\u0019;%S:$XM\u001d8bY\u0012\u001a6m\u001c9fg\u0012\"\u0003.Y:ii\u0006\u0014G.Z0%KF$B!a)\u0004\u0006\"I\u0011\u0011\u0018;\u0002\u0002\u0003\u00071q\u0011\t\u0007\u0003\u001f\u001bIia\u001c\n\t\r-\u0015Q\u0011\u0002\u0006\u0003J\u0014\u0018-_\u0001*g\u000e\fG.\u0019\u0013sK\u001adWm\u0019;%S:$XM\u001d8bY\u0012\u001a6m\u001c9fg\u0012\"\u0003.Y:ii\u0006\u0014G.\u001a\u0011\u0002\u0015\u0015dW-\\:DC\u000eDW-\u0006\u0002\u0004\u0014B11QSBN\u0003\u0007tA!a$\u0004\u0018&!1\u0011TAC\u0003\u001d\u0001\u0018mY6bO\u0016LAa!(\u0004 \n!A*[:u\u0015\u0011\u0019I*!\"\u0002\u001d\u0015dW-\\:DC\u000eDWm\u0018\u0013fcR!\u00111UBS\u0011%\tIl^A\u0001\u0002\u0004\u0019\u0019*A\u0006fY\u0016l7oQ1dQ\u0016\u0004\u0013AC2bG\",GmU5{K\u0006q1-Y2iK\u0012\u001c\u0016N_3`I\u0015\fH\u0003BAR\u0007_C\u0011\"!/{\u0003\u0003\u0005\r!!,\u0002\u0017\r\f7\r[3e'&TX\rI\u0001\u0010M2,8\u000f[#mK6\u001c8)Y2iK\u0006A\u0001*Q*I'&SV)\u0006\u0002\u0004:>\u001111X\u000f\u0003\u0001\u0001\r\u0011\u0002S!T\u0011NK%,\u0012\u0011\u0002\u0011!\u000b5\u000bS'B'.+\"aa1\u0010\u0005\r\u0015W$A@\u0002\u0013!\u000b5\u000bS'B'.\u0003\u0013\u0001C'J\u001d~C\u0015i\u0015%\u0016\u0005\r5wBABh;\u0005A\u0011!C'J\u001d~C\u0015i\u0015%!\u0003)\u0019Gn\u001c8f'\u000e|\u0007/Z\u0001\bSN,U\u000e\u001d;z\u0003\u0011\u0019\u0018N_3\u0002\u0015\u0011L'/Z2u'&TX-\u0001\u0006f]R,'/\u00128uef$B!a)\u0004`\"A1\u0011]A\b\u0001\u0004\u0019y'A\u0001f\u0003-)g\u000e^3s\u0013:D\u0015m\u001d5\u0015\t\u0005\r6q\u001d\u0005\t\u0007C\f\t\u00021\u0001\u0004p\u0005)QM\u001c;feV!1Q^Bz)\u0011\u0019yoa@\u0011\t\rE81\u001f\u0007\u0001\t!\u0019)0a\u0005C\u0002\r](!\u0001+\u0012\t\re\u00181\u0019\t\u0005\u0003\u001f\u001bY0\u0003\u0003\u0004~\u0006\u0015%a\u0002(pi\"Lgn\u001a\u0005\t\u0007\u0013\n\u0019\u00021\u0001\u0004p\u0006YQM\u001c;fe\n+gm\u001c:f)\u0019\t\u0019\r\"\u0002\u0005\b!A1\u0011JA\u000b\u0001\u0004\t\u0019\r\u0003\u0005\u0005\n\u0005U\u0001\u0019AB8\u0003\u0011qW\r\u001f;\u0002\u0017\u0015tG/\u001a:V]&\fX/\u001a\u000b\u0005\u0003G#y\u0001\u0003\u0005\u0004J\u0005]\u0001\u0019AAb\u0003))g\u000e^3s\u0013\u001atUm^\u000b\u0005\t+!I\u0002\u0006\u0003\u0005\u0018\u0011m\u0001\u0003BBy\t3!\u0001b!>\u0002\u001a\t\u00071q\u001f\u0005\t\u0007\u0013\nI\u00021\u0001\u0005\u0018\u0005Q1M]3bi\u0016D\u0015m\u001d5\u0002\u001d\u0015tG/\u001a:BY2Le\u000eS1tQR1\u00111\u0015C\u0012\tKA\u0001b!9\u0002\u001e\u0001\u00071q\u000e\u0005\u000b\tO\ti\u0002%AA\u0002\u00055\u0016!\u00018\u00021\u0015tG/\u001a:BY2Le\u000eS1tQ\u0012\"WMZ1vYR$#'\u0006\u0002\u0005.)\"\u0011Q\u0016B\u0013\u0003\u0019\u0011X\r[1tQR1\u00111\u0015C\u001a\tkA\u0001b!\u0013\u0002\"\u0001\u0007\u00111\u0019\u0005\t\to\t\t\u00031\u0001\u0005:\u00059a.Z<oC6,\u0007\u0003BAc\twIA\u0001\"\u0010\u0005@\t!a*Y7f\u0013\u0011!\t%! \u0003\u000b9\u000bW.Z:\u0002\rUtG.\u001b8l)\u0011\t\u0019\u000bb\u0012\t\u0011\r\u0005\u00181\u0005a\u0001\u0007_\"B!a)\u0005L!A1\u0011JA\u0013\u0001\u0004\t\u0019-\u0001\u0007m_>\\W\u000f]'pIVdW\r\u0006\u0003\u0002D\u0012E\u0003\u0002\u0003C*\u0003O\u0001\r\u0001\"\u000f\u0002\t9\fW.Z\u0001\fY>|7.\u001e9DY\u0006\u001c8\u000f\u0006\u0003\u0002D\u0012e\u0003\u0002\u0003C*\u0003S\u0001\r\u0001\"\u000f\u0002\u0019\r|g\u000e^1j]Nt\u0015-\\3\u0015\t\u0005MGq\f\u0005\t\t'\nY\u00031\u0001\u0005:\u00051An\\8lkB$B!a1\u0005f!AA1KA\u0017\u0001\u0004!I$A\u0005m_>\\W\u000f]!mYR!A1\u000eC8!\u0019\u0019)\n\"\u001c\u0002D&!!QMBP\u0011!!\u0019&a\fA\u0002\u0011e\u0012\u0001\u00057p_.,\b/\u00117m\u000b:$(/[3t)\u0011!)\bb\u001e\u0011\r\rUEQNB8\u0011!!\u0019&!\rA\u0002\u0011e\u0012a\u00067p_.,\b/\u00168tQ\u0006$wn^3e\u000b:$(/[3t)\u0011!)\b\" \t\u0011\u0011M\u00131\u0007a\u0001\ts\t\u0011\u0003\\8pWV\u00048+_7c_2,e\u000e\u001e:z)\u0011\u0019y\u0007b!\t\u0011\r%\u0013Q\u0007a\u0001\u0003\u0007\f1\u0002\\8pWV\u0004XI\u001c;ssR!1q\u000eCE\u0011!!\u0019&a\u000eA\u0002\u0011e\u0012a\u00047p_.,\bOT3yi\u0016sGO]=\u0015\t\r=Dq\u0012\u0005\t\t#\u000bI\u00041\u0001\u0004p\u0005)QM\u001c;ss\u00069Bn\\8lkBt\u0015-\\3J]N\u000bW.Z*d_B,\u0017i\u001d\u000b\u0007\u0003\u0007$9\nb'\t\u0011\u0011e\u00151\ba\u0001\u0003\u0007\f\u0001b\u001c:jO&t\u0017\r\u001c\u0005\t\t;\u000bY\u00041\u0001\u0005:\u0005i1m\\7qC:LwN\u001c(b[\u0016\f1\"[:TC6,7kY8qKR!\u00111\u001bCR\u0011!!)+!\u0010A\u0002\r]\u0013!B8uQ\u0016\u0014\u0018AC5t'V\u00147kY8qKR!\u00111\u001bCV\u0011!!)+a\u0010A\u0002\r]\u0013A\u0002;p\u0019&\u001cH/\u0001\u0004t_J$X\rZ\u0001\r]\u0016\u001cH/\u001b8h\u0019\u00164X\r\\\u0001\tSR,'/\u0019;peV\u0011A1N\u0001\bM>\u0014X-Y2i+\u0011!Y\f\"3\u0015\t\u0005\rFQ\u0018\u0005\t\t\u007f\u000bI\u00051\u0001\u0005B\u0006\t\u0001\u000f\u0005\u0005\u0002\u0010\u0012\r\u00171\u0019Cd\u0013\u0011!)-!\"\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\u0003BBy\t\u0013$\u0001\u0002b3\u0002J\t\u0007AQ\u001a\u0002\u0002+F!1\u0011 B(\u0003%1\u0017\u000e\u001c;fe:{G\u000f\u0006\u0003\u0004X\u0011M\u0007\u0002\u0003C`\u0003\u0017\u0002\r\u0001\"6\u0011\u0011\u0005=E1YAb\u0003'\faAZ5mi\u0016\u0014H\u0003BB,\t7D\u0001\u0002b0\u0002N\u0001\u0007AQ[\u0001\be\u00164XM]:fQ!\ty\u0005\"9\u0005h\u0012-\b\u0003BAH\tGLA\u0001\":\u0002\u0006\nQA-\u001a9sK\u000e\fG/\u001a3\"\u0005\u0011%\u0018\u0001H;tK\u0002\u0002Go\u001c'jgRt#/\u001a<feN,\u0007\rI5ogR,\u0017\rZ\u0011\u0003\t[\faA\r\u00182a9\u0002\u0014\u0001C7l'R\u0014\u0018N\\4\u0015\u0011\u0005EH1\u001fC|\twD\u0001\u0002\">\u0002R\u0001\u0007\u0011\u0011_\u0001\u0006gR\f'\u000f\u001e\u0005\t\ts\f\t\u00061\u0001\u0002r\u0006\u00191/\u001a9\t\u0011\u0011u\u0018\u0011\u000ba\u0001\u0003c\f1!\u001a8e)\t\t\t0A\u0016tG\u0006d\u0017\r\n:fM2,7\r\u001e\u0013j]R,'O\\1mIM\u001bw\u000e]3tI\u0011rWm\u001d;j]\u001edWM^3m\u0003!\u001a8-\u00197bII,g\r\\3di\u0012Jg\u000e^3s]\u0006dGeU2pa\u0016\u001cH\u0005\n5bg\"$\u0018M\u00197f+\t\u00199)\u0001\u0004po:,'\u000f\t\u000b\u0007\u0007_*Y!\"\u0004\t\u000f\r%S\f1\u0001\u0002D\"911K/A\u0002\r]\u0013\u0001\u0002;bS2\f\u0001\u0002^1jY~#S-\u001d\u000b\u0005\u0003G+)\u0002C\u0005\u0002:~\u000b\t\u00111\u0001\u0004p\u0005)A/Y5mA\u0005Aa.\u001a=u?\u0012*\u0017\u000f\u0006\u0003\u0002$\u0016u\u0001\"CA]E\u0006\u0005\t\u0019AB8\u0003\u0015qW\r\u001f;!\u0003\u0015!W\r\u001d;i)\u0011!I$\"\n\t\u000f\u0015\u001dr\r1\u0001\u0002T\u0006!a\r\\1u\u00035qWm^*d_B,WI\u001c;ssR11qNC\u0017\u000b_Aqa!\u0013i\u0001\u0004\t\u0019\rC\u0004\u0004T!\u0004\raa\u0016\u0002\u000bM\u001bw\u000e]3\u0011\u0007\u0005\u0015'nE\u0002k\u0003\u001b#\"!b\r\u0002\u0015Ut\u0017\r\u001d9msN+\u0017\u000f\u0006\u0003\u0006>\u0015%\u0003CBAH\u000b\u007f)\u0019%\u0003\u0003\u0006B\u0005\u0015%\u0001B*p[\u0016\u0004ba!&\u0006F\u0005\r\u0017\u0002BC$\u0007?\u00131aU3r\u0011\u001d)Y\u0005\u001ca\u0001\u0007/\nQ\u0001Z3dYN\f\u0001bU2pa\u0016$\u0016mZ\u000b\u0003\u000b#\u0002b!b\u0015\u0006V\r]SBAAA\u0013\u0011)9&!!\u0003\u0011\rc\u0017m]:UC\u001e\u00141\"T3nE\u0016\u00148kY8qK\u0006qQ*Z7cKJ\u001c6m\u001c9f)\u0006<WCAC0!\u0019)\u0019&\"\u0016\u0006bA!\u0011QYA.\u0003!qWm^*d_B,\u0017A\u00058fo\u001aKg\u000eZ'f[\n,'oU2pa\u0016\faB\\3x\u001d\u0016\u001cH/\u001a3TG>\u0004X\r\u0006\u0003\u0004X\u0015-\u0004\u0002CC7\u0003G\u0002\raa\u0016\u0002\u000b=,H/\u001a:\u0002\u00199,woU2pa\u0016<\u0016\u000e\u001e5\u0015\t\r]S1\u000f\u0005\t\u0007W\n)\u00071\u0001\u0006vA1\u0011qRC<\u0003\u0007LA!\"\u001f\u0002\u0006\nQAH]3qK\u0006$X\r\u001a \u0002\u001f9,w\u000fU1dW\u0006<WmU2pa\u0016$Baa\u0016\u0006\u0000!AQ\u0011QA4\u0001\u0004\t\u0019-\u0001\u0005qW\u001e\u001cE.Y:t\u00039\u00198m\u001c9f)J\fgn\u001d4pe6$B!b\"\u0006\u0014R!1qKCE\u0011%)Y)!\u001b\u0005\u0002\u0004)i)\u0001\u0002paB1\u0011qRCH\u0007/JA!\"%\u0002\u0006\nAAHY=oC6,g\b\u0003\u0005\u0004T\u0005%\u0004\u0019AAb\u0003))U\u000e\u001d;z'\u000e|\u0007/\u001a\t\u0005\u0003\u000b\fiG\u0001\u0006F[B$\u0018pU2pa\u0016\u001cB!!\u001c\u0004XQ\u0011Qq\u0013\u000b\u0005\u0003G+\t\u000b\u0003\u0005\u0004b\u0006E\u0004\u0019AB8\u0005))%O]8s'\u000e|\u0007/Z\n\u0005\u0003g\u001a9\u0006\u0006\u0003\u0006*\u0016-\u0006\u0003BAc\u0003gB\u0001ba\u0015\u0002x\u0001\u0007\u00111Y\u0001\u000e[\u0006D(+Z2veNLwN\\:\u0016\u0005\u0015EvBACZ;\t\u0019\u0001\u001e\u0005\u0003\u00068\u0016eVBAA?\u0013\u0011)Y,! \u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface Scopes
extends scala.reflect.api.Scopes {
    public Scopes$LookupSucceeded$ LookupSucceeded();

    public Scopes$LookupAmbiguous$ LookupAmbiguous();

    public Scopes$LookupInaccessible$ LookupInaccessible();

    public Scopes$LookupNotFound$ LookupNotFound();

    public Scopes$Scope$ Scope();

    public Scopes$EmptyScope$ EmptyScope();

    public void scala$reflect$internal$Scopes$_setter_$ScopeTag_$eq(ClassTag<Scope> var1);

    public void scala$reflect$internal$Scopes$_setter_$MemberScopeTag_$eq(ClassTag<Scope> var1);

    public int scopeCount();

    public void scopeCount_$eq(int var1);

    public static /* synthetic */ ScopeEntry scala$reflect$internal$Scopes$$newScopeEntry$(Scopes $this, Symbols.Symbol sym, Scope owner) {
        return $this.scala$reflect$internal$Scopes$$newScopeEntry(sym, owner);
    }

    /*
     * WARNING - void declaration
     */
    default public ScopeEntry scala$reflect$internal$Scopes$$newScopeEntry(Symbols.Symbol sym, Scope owner) {
        void var3_3;
        ScopeEntry e = new ScopeEntry((SymbolTable)this, sym, owner);
        e.next_$eq(owner.elems());
        owner.elems_$eq(e);
        return var3_3;
    }

    public ClassTag<Scope> ScopeTag();

    public ClassTag<Scope> MemberScopeTag();

    public static /* synthetic */ Scope newScope$(Scopes $this) {
        return $this.newScope();
    }

    default public Scope newScope() {
        return new Scope((SymbolTable)this);
    }

    public static /* synthetic */ Scope newFindMemberScope$(Scopes $this) {
        return $this.newFindMemberScope();
    }

    default public Scope newFindMemberScope() {
        return new Scope((SymbolTable)this){

            public List<Symbols.Symbol> sorted() {
                List<Symbols.Symbol> members = this.toList();
                List owners = (List)((SeqLike)members.map((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)(A x$5) -> x$5.owner(), List$.MODULE$.canBuildFrom())).distinct();
                GenMap grouped = members.groupBy((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)(T1 x$6) -> x$6.owner());
                return owners.flatMap(arg_0 -> $anon$3.$anonfun$sorted$3((Map)grouped, arg_0), List$.MODULE$.canBuildFrom());
            }

            public static final /* synthetic */ List $anonfun$sorted$3(Map grouped$1, Symbols.Symbol owner) {
                return ((List)grouped$1.apply(owner)).reverse();
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$sorted$1(scala.reflect.internal.Symbols$Symbol ), $anonfun$sorted$2(scala.reflect.internal.Symbols$Symbol ), $anonfun$sorted$3(scala.collection.immutable.Map scala.reflect.internal.Symbols$Symbol )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ Scope newNestedScope$(Scopes $this, Scope outer) {
        return $this.newNestedScope(outer);
    }

    /*
     * WARNING - void declaration
     */
    default public Scope newNestedScope(Scope outer) {
        void var3_4;
        Tuple2<Object, Object> tuple2;
        if (StatisticsStatics.areSomeColdStatsEnabled()) {
            void startTimer_tm;
            Statistics statistics = ((SymbolTable)this).statistics();
            Statistics.Timer timer = ((ScopeStats)((Object)((SymbolTable)this).statistics())).scopePopulationTime();
            if (statistics == null) {
                throw null;
            }
            tuple2 = statistics.areColdStatsLocallyEnabled() && startTimer_tm != null ? startTimer_tm.start() : null;
        } else {
            tuple2 = null;
        }
        Tuple2<Object, Object> startTime = tuple2;
        Scope nested = this.newScope();
        nested.elems_$eq(outer.elems());
        nested.scala$reflect$internal$Scopes$$nestinglevel_$eq(outer.scala$reflect$internal$Scopes$$nestinglevel() + 1);
        if (outer.scala$reflect$internal$Scopes$$hashtable() != null) {
            nested.scala$reflect$internal$Scopes$$hashtable_$eq((ScopeEntry[])Arrays.copyOf((Object[])outer.scala$reflect$internal$Scopes$$hashtable(), outer.scala$reflect$internal$Scopes$$hashtable().length));
        }
        if (StatisticsStatics.areSomeColdStatsEnabled()) {
            void stopTimer_tm;
            Statistics statistics = ((SymbolTable)this).statistics();
            Statistics.Timer timer = ((ScopeStats)((Object)((SymbolTable)this).statistics())).scopePopulationTime();
            if (statistics == null) {
                throw null;
            }
            if (statistics.areColdStatsLocallyEnabled() && stopTimer_tm != null) {
                stopTimer_tm.stop(startTime);
            }
        }
        return var3_4;
    }

    public static /* synthetic */ Scope newScopeWith$(Scopes $this, Seq elems) {
        return $this.newScopeWith(elems);
    }

    /*
     * WARNING - void declaration
     */
    default public Scope newScopeWith(Seq<Symbols.Symbol> elems) {
        void var3_4;
        Tuple2<Object, Object> tuple2;
        if (StatisticsStatics.areSomeColdStatsEnabled()) {
            void startTimer_tm;
            Statistics statistics = ((SymbolTable)this).statistics();
            Statistics.Timer timer = ((ScopeStats)((Object)((SymbolTable)this).statistics())).scopePopulationTime();
            if (statistics == null) {
                throw null;
            }
            tuple2 = statistics.areColdStatsLocallyEnabled() && startTimer_tm != null ? startTimer_tm.start() : null;
        } else {
            tuple2 = null;
        }
        Tuple2<Object, Object> startTime = tuple2;
        Scope scope = this.newScope();
        elems.foreach((Function1<Symbols.Symbol, Symbols.Symbol> & java.io.Serializable & Serializable)sym -> scope.enter(sym));
        if (StatisticsStatics.areSomeColdStatsEnabled()) {
            void stopTimer_tm;
            Statistics statistics = ((SymbolTable)this).statistics();
            Statistics.Timer timer = ((ScopeStats)((Object)((SymbolTable)this).statistics())).scopePopulationTime();
            if (statistics == null) {
                throw null;
            }
            if (statistics.areColdStatsLocallyEnabled() && stopTimer_tm != null) {
                stopTimer_tm.stop(startTime);
            }
        }
        return var3_4;
    }

    public static /* synthetic */ Scope newPackageScope$(Scopes $this, Symbols.Symbol pkgClass) {
        return $this.newPackageScope(pkgClass);
    }

    default public Scope newPackageScope(Symbols.Symbol pkgClass) {
        return this.newScope();
    }

    public static /* synthetic */ Scope scopeTransform$(Scopes $this, Symbols.Symbol owner, Function0 op) {
        return $this.scopeTransform(owner, op);
    }

    default public Scope scopeTransform(Symbols.Symbol owner, Function0<Scope> op) {
        return op.apply();
    }

    private int maxRecursions() {
        return 1000;
    }

    public static void $init$(Scopes $this) {
        $this.scopeCount_$eq(0);
        ((SymbolTable)$this).perRunCaches().recordCache(() -> $this.scopeCount_$eq(0));
        $this.scala$reflect$internal$Scopes$_setter_$ScopeTag_$eq(ClassTag$.MODULE$.apply(Scope.class));
        $this.scala$reflect$internal$Scopes$_setter_$MemberScopeTag_$eq(ClassTag$.MODULE$.apply(Scope.class));
    }

    public class ErrorScope
    extends Scope {
        public /* synthetic */ SymbolTable scala$reflect$internal$Scopes$ErrorScope$$$outer() {
            return this.$outer;
        }

        public ErrorScope(SymbolTable $outer, Symbols.Symbol owner) {
            super($outer);
        }
    }

    public class LookupAmbiguous
    implements NameLookup,
    Product,
    Serializable {
        private final String msg;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public boolean isSuccess() {
            return ((NameLookup)this).isSuccess();
        }

        public String msg() {
            return this.msg;
        }

        @Override
        public Symbols.NoSymbol symbol() {
            return this.scala$reflect$internal$Scopes$LookupAmbiguous$$$outer().NoSymbol();
        }

        public LookupAmbiguous copy(String msg) {
            return new LookupAmbiguous(this.scala$reflect$internal$Scopes$LookupAmbiguous$$$outer(), msg);
        }

        public String copy$default$1() {
            return this.msg();
        }

        @Override
        public String productPrefix() {
            return "LookupAmbiguous";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.msg();
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
            return x$1 instanceof LookupAmbiguous;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof LookupAmbiguous && ((LookupAmbiguous)x$1).scala$reflect$internal$Scopes$LookupAmbiguous$$$outer() == this.scala$reflect$internal$Scopes$LookupAmbiguous$$$outer();
                    if (!bl) break block3;
                    LookupAmbiguous lookupAmbiguous = (LookupAmbiguous)x$1;
                    String string = this.msg();
                    String string2 = lookupAmbiguous.msg();
                    if (!(!(string != null ? !string.equals(string2) : string2 != null) && lookupAmbiguous.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Scopes$LookupAmbiguous$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Scopes scala$reflect$internal$Scopes$NameLookup$$$outer() {
            return this.scala$reflect$internal$Scopes$LookupAmbiguous$$$outer();
        }

        public LookupAmbiguous(SymbolTable $outer, String msg) {
            this.msg = msg;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            NameLookup.$init$(this);
            Product.$init$(this);
        }
    }

    public class LookupInaccessible
    implements NameLookup,
    Product,
    Serializable {
        private final Symbols.Symbol symbol;
        private final String msg;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public boolean isSuccess() {
            return ((NameLookup)this).isSuccess();
        }

        @Override
        public Symbols.Symbol symbol() {
            return this.symbol;
        }

        public String msg() {
            return this.msg;
        }

        public LookupInaccessible copy(Symbols.Symbol symbol, String msg) {
            return new LookupInaccessible(this.scala$reflect$internal$Scopes$LookupInaccessible$$$outer(), symbol, msg);
        }

        public Symbols.Symbol copy$default$1() {
            return this.symbol();
        }

        public String copy$default$2() {
            return this.msg();
        }

        @Override
        public String productPrefix() {
            return "LookupInaccessible";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.symbol();
                }
                case 1: {
                    return this.msg();
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
            return x$1 instanceof LookupInaccessible;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof LookupInaccessible)) return false;
            if (((LookupInaccessible)x$1).scala$reflect$internal$Scopes$LookupInaccessible$$$outer() != this.scala$reflect$internal$Scopes$LookupInaccessible$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            LookupInaccessible lookupInaccessible = (LookupInaccessible)x$1;
            Symbols.Symbol symbol = this.symbol();
            Symbols.Symbol symbol2 = lookupInaccessible.symbol();
            if (symbol == null) {
                if (symbol2 != null) {
                    return false;
                }
            } else if (!symbol.equals(symbol2)) return false;
            String string = this.msg();
            String string2 = lookupInaccessible.msg();
            if (string == null) {
                if (string2 != null) {
                    return false;
                }
            } else if (!string.equals(string2)) return false;
            if (!lookupInaccessible.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Scopes$LookupInaccessible$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Scopes scala$reflect$internal$Scopes$NameLookup$$$outer() {
            return this.scala$reflect$internal$Scopes$LookupInaccessible$$$outer();
        }

        public LookupInaccessible(SymbolTable $outer, Symbols.Symbol symbol, String msg) {
            this.symbol = symbol;
            this.msg = msg;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            NameLookup.$init$(this);
            Product.$init$(this);
        }
    }

    public class LookupSucceeded
    implements NameLookup,
    Product,
    Serializable {
        private final Trees.Tree qualifier;
        private final Symbols.Symbol symbol;
        public final /* synthetic */ SymbolTable $outer;

        public Trees.Tree qualifier() {
            return this.qualifier;
        }

        @Override
        public Symbols.Symbol symbol() {
            return this.symbol;
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        public LookupSucceeded copy(Trees.Tree qualifier, Symbols.Symbol symbol) {
            return new LookupSucceeded(this.scala$reflect$internal$Scopes$LookupSucceeded$$$outer(), qualifier, symbol);
        }

        public Trees.Tree copy$default$1() {
            return this.qualifier();
        }

        public Symbols.Symbol copy$default$2() {
            return this.symbol();
        }

        @Override
        public String productPrefix() {
            return "LookupSucceeded";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.qualifier();
                }
                case 1: {
                    return this.symbol();
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
            return x$1 instanceof LookupSucceeded;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof LookupSucceeded)) return false;
            if (((LookupSucceeded)x$1).scala$reflect$internal$Scopes$LookupSucceeded$$$outer() != this.scala$reflect$internal$Scopes$LookupSucceeded$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            LookupSucceeded lookupSucceeded = (LookupSucceeded)x$1;
            Trees.Tree tree = this.qualifier();
            Trees.Tree tree2 = lookupSucceeded.qualifier();
            if (tree == null) {
                if (tree2 != null) {
                    return false;
                }
            } else if (!((Object)tree).equals(tree2)) return false;
            Symbols.Symbol symbol = this.symbol();
            Symbols.Symbol symbol2 = lookupSucceeded.symbol();
            if (symbol == null) {
                if (symbol2 != null) {
                    return false;
                }
            } else if (!symbol.equals(symbol2)) return false;
            if (!lookupSucceeded.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Scopes$LookupSucceeded$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Scopes scala$reflect$internal$Scopes$NameLookup$$$outer() {
            return this.scala$reflect$internal$Scopes$LookupSucceeded$$$outer();
        }

        public LookupSucceeded(SymbolTable $outer, Trees.Tree qualifier, Symbols.Symbol symbol) {
            this.qualifier = qualifier;
            this.symbol = symbol;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            NameLookup.$init$(this);
            Product.$init$(this);
        }
    }

    public interface NameLookup {
        public Symbols.Symbol symbol();

        default public boolean isSuccess() {
            return false;
        }

        public /* synthetic */ Scopes scala$reflect$internal$Scopes$NameLookup$$$outer();

        public static void $init$(NameLookup $this) {
        }
    }

    public static class Scope
    implements Scopes.MemberScopeApi {
        private ScopeEntry elems;
        private int scala$reflect$internal$Scopes$$nestinglevel;
        private ScopeEntry[] scala$reflect$internal$Scopes$$hashtable;
        private List<Symbols.Symbol> elemsCache;
        private int cachedSize;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public GenericCompanion<Iterable> companion() {
            return Iterable.companion$(this);
        }

        @Override
        public Iterable<Symbols.Symbol> seq() {
            return Iterable.seq$(this);
        }

        @Override
        public Iterable<Symbols.Symbol> thisCollection() {
            return IterableLike.thisCollection$(this);
        }

        @Override
        public Iterable toCollection(Object repr) {
            return IterableLike.toCollection$(this, repr);
        }

        @Override
        public boolean forall(Function1<Symbols.Symbol, Object> p) {
            return IterableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<Symbols.Symbol, Object> p) {
            return IterableLike.exists$(this, p);
        }

        @Override
        public Option<Symbols.Symbol> find(Function1<Symbols.Symbol, Object> p) {
            return IterableLike.find$(this, p);
        }

        @Override
        public <B> B foldRight(B z, Function2<Symbols.Symbol, B, B> op) {
            return (B)IterableLike.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceRight(Function2<Symbols.Symbol, B, B> op) {
            return (B)IterableLike.reduceRight$(this, op);
        }

        @Override
        public Iterable<Symbols.Symbol> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<Symbols.Symbol> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public Object head() {
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
        public Iterator<Iterable<Symbols.Symbol>> grouped(int size) {
            return IterableLike.grouped$(this, size);
        }

        @Override
        public Iterator<Iterable<Symbols.Symbol>> sliding(int size) {
            return IterableLike.sliding$(this, size);
        }

        @Override
        public Iterator<Iterable<Symbols.Symbol>> sliding(int size, int step) {
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
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Iterable<Symbols.Symbol>, Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zip$(this, that, bf);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<Iterable<Symbols.Symbol>, Tuple2<A1, B>, That> bf) {
            return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<Iterable<Symbols.Symbol>, Tuple2<A1, Object>, That> bf) {
            return (That)IterableLike.zipWithIndex$(this, bf);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public Stream<Symbols.Symbol> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
        }

        @Override
        public IterableView<Symbols.Symbol, Iterable<Symbols.Symbol>> view() {
            return IterableLike.view$(this);
        }

        @Override
        public IterableView<Symbols.Symbol, Iterable<Symbols.Symbol>> view(int from, int until) {
            return IterableLike.view$(this, from, until);
        }

        @Override
        public Builder<Symbols.Symbol, Iterable<Symbols.Symbol>> newBuilder() {
            return GenericTraversableTemplate.newBuilder$(this);
        }

        @Override
        public <B> Builder<B, Iterable<B>> genericBuilder() {
            return GenericTraversableTemplate.genericBuilder$(this);
        }

        @Override
        public <A1, A2> Tuple2<Iterable<A1>, Iterable<A2>> unzip(Function1<Symbols.Symbol, Tuple2<A1, A2>> asPair) {
            return GenericTraversableTemplate.unzip$(this, asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<Iterable<A1>, Iterable<A2>, Iterable<A3>> unzip3(Function1<Symbols.Symbol, Tuple3<A1, A2, A3>> asTriple) {
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
        public Combiner<Symbols.Symbol, ParIterable<Symbols.Symbol>> parCombiner() {
            return TraversableLike.parCombiner$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return TraversableLike.hasDefiniteSize$(this);
        }

        @Override
        public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.$plus$plus$(this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
        }

        @Override
        public <B, That> That map(Function1<Symbols.Symbol, B> f, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<Symbols.Symbol, GenTraversableOnce<B>> f, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.flatMap$(this, f, bf);
        }

        @Override
        public Object filterImpl(Function1 p, boolean isFlipped) {
            return TraversableLike.filterImpl$(this, p, isFlipped);
        }

        @Override
        public <B, That> That collect(PartialFunction<Symbols.Symbol, B> pf, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }

        @Override
        public Tuple2<Iterable<Symbols.Symbol>, Iterable<Symbols.Symbol>> partition(Function1<Symbols.Symbol, Object> p) {
            return TraversableLike.partition$(this, p);
        }

        @Override
        public <K> Map<K, Iterable<Symbols.Symbol>> groupBy(Function1<Symbols.Symbol, K> f) {
            return TraversableLike.groupBy$(this, f);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, Symbols.Symbol, B> op, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<Symbols.Symbol, B, B> op, CanBuildFrom<Iterable<Symbols.Symbol>, B, That> bf) {
            return (That)TraversableLike.scanRight$(this, z, op, bf);
        }

        @Override
        public Option<Symbols.Symbol> headOption() {
            return TraversableLike.headOption$(this);
        }

        @Override
        public Object tail() {
            return TraversableLike.tail$(this);
        }

        @Override
        public Object last() {
            return TraversableLike.last$(this);
        }

        @Override
        public Option<Symbols.Symbol> lastOption() {
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
        public Tuple2<Iterable<Symbols.Symbol>, Iterable<Symbols.Symbol>> span(Function1<Symbols.Symbol, Object> p) {
            return TraversableLike.span$(this, p);
        }

        @Override
        public Tuple2<Iterable<Symbols.Symbol>, Iterable<Symbols.Symbol>> splitAt(int n) {
            return TraversableLike.splitAt$(this, n);
        }

        @Override
        public Iterator<Iterable<Symbols.Symbol>> tails() {
            return TraversableLike.tails$(this);
        }

        @Override
        public Iterator<Iterable<Symbols.Symbol>> inits() {
            return TraversableLike.inits$(this);
        }

        @Override
        public Traversable<Symbols.Symbol> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, Symbols.Symbol, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public String stringPrefix() {
            return TraversableLike.stringPrefix$(this);
        }

        @Override
        public FilterMonadic<Symbols.Symbol, Iterable<Symbols.Symbol>> withFilter(Function1<Symbols.Symbol, Object> p) {
            return TraversableLike.withFilter$(this, p);
        }

        @Override
        public Parallel par() {
            return Parallelizable.par$(this);
        }

        @Override
        public List<Symbols.Symbol> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<Symbols.Symbol, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<Symbols.Symbol, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, Symbols.Symbol, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<Symbols.Symbol, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, Symbols.Symbol, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, Symbols.Symbol, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, Symbols.Symbol, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<Symbols.Symbol, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, Symbols.Symbol, B> seqop, Function2<B, B, B> combop) {
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
        public <B> Object toArray(ClassTag<B> evidence$1) {
            return TraversableOnce.toArray$(this, evidence$1);
        }

        @Override
        public Seq<Symbols.Symbol> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<Symbols.Symbol> toIndexedSeq() {
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
        public Vector<Symbols.Symbol> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Symbols.Symbol, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
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

        public ScopeEntry elems() {
            return this.elems;
        }

        public void elems_$eq(ScopeEntry x$1) {
            this.elems = x$1;
        }

        public int scala$reflect$internal$Scopes$$nestinglevel() {
            return this.scala$reflect$internal$Scopes$$nestinglevel;
        }

        public void scala$reflect$internal$Scopes$$nestinglevel_$eq(int x$1) {
            this.scala$reflect$internal$Scopes$$nestinglevel = x$1;
        }

        public ScopeEntry[] scala$reflect$internal$Scopes$$hashtable() {
            return this.scala$reflect$internal$Scopes$$hashtable;
        }

        public void scala$reflect$internal$Scopes$$hashtable_$eq(ScopeEntry[] x$1) {
            this.scala$reflect$internal$Scopes$$hashtable = x$1;
        }

        private List<Symbols.Symbol> elemsCache() {
            return this.elemsCache;
        }

        private void elemsCache_$eq(List<Symbols.Symbol> x$1) {
            this.elemsCache = x$1;
        }

        private int cachedSize() {
            return this.cachedSize;
        }

        private void cachedSize_$eq(int x$1) {
            this.cachedSize = x$1;
        }

        private void flushElemsCache() {
            this.elemsCache_$eq(null);
            this.cachedSize_$eq(-1);
        }

        private final int HASHSIZE() {
            return 128;
        }

        private final int HASHMASK() {
            return 127;
        }

        private final int MIN_HASH() {
            return 8;
        }

        public Scope cloneScope() {
            return this.scala$reflect$internal$Scopes$Scope$$$outer().newScopeWith(this.toList());
        }

        @Override
        public boolean isEmpty() {
            return this.elems() == null;
        }

        @Override
        public int size() {
            if (this.cachedSize() < 0) {
                this.cachedSize_$eq(this.directSize());
            }
            return this.cachedSize();
        }

        /*
         * WARNING - void declaration
         */
        private int directSize() {
            void var1_1;
            int s = 0;
            for (ScopeEntry e = this.elems(); e != null; e = e.next()) {
                ++s;
            }
            return (int)var1_1;
        }

        public void enterEntry(ScopeEntry e) {
            this.flushElemsCache();
            if (this.scala$reflect$internal$Scopes$$hashtable() != null) {
                this.enterInHash(e);
                return;
            }
            if (this.size() >= 8) {
                this.createHash();
            }
        }

        private void enterInHash(ScopeEntry e) {
            int i = e.sym().name().start() & 0x7F;
            e.tail_$eq(this.scala$reflect$internal$Scopes$$hashtable()[i]);
            this.scala$reflect$internal$Scopes$$hashtable()[i] = e;
        }

        public <T extends Symbols.Symbol> T enter(T sym) {
            this.enterEntry(this.scala$reflect$internal$Scopes$Scope$$$outer().scala$reflect$internal$Scopes$$newScopeEntry(sym, this));
            return sym;
        }

        /*
         * WARNING - void declaration
         */
        public final Symbols.Symbol enterBefore(Symbols.Symbol sym, ScopeEntry next) {
            void require_requirement;
            boolean bl;
            void require_requirement2;
            boolean bl2;
            void assert_assertion;
            boolean bl3;
            SymbolTable symbolTable = this.scala$reflect$internal$Scopes$Scope$$$outer();
            boolean bl4 = bl3 = !this.equals(this.scala$reflect$internal$Scopes$Scope$$$outer().EmptyScope());
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(sym);
            }
            SymbolTable symbolTable2 = this.scala$reflect$internal$Scopes$Scope$$$outer();
            boolean bl5 = bl2 = sym.name().hashCode() == next.sym().name().hashCode();
            if (symbolTable2 == null) {
                throw null;
            }
            SymbolTable require_this = symbolTable2;
            if (require_requirement2 == false) {
                throw require_this.throwRequirementError(Scope.$anonfun$enterBefore$2(sym, next));
            }
            SymbolTable symbolTable3 = this.scala$reflect$internal$Scopes$Scope$$$outer();
            boolean bl6 = bl = !sym.equals(next.sym());
            if (symbolTable3 == null) {
                throw null;
            }
            SymbolTable require_this2 = symbolTable3;
            if (require_requirement == false) {
                throw require_this2.throwRequirementError(Scope.$anonfun$enterBefore$3(sym, next));
            }
            ScopeEntry newNext = new ScopeEntry(this.scala$reflect$internal$Scopes$Scope$$$outer(), next.sym(), this);
            boolean hasHashTable = this.scala$reflect$internal$Scopes$$hashtable() != null;
            newNext.next_$eq(next.next());
            if (hasHashTable) {
                newNext.tail_$eq(next.tail());
            }
            next.sym_$eq(sym);
            next.next_$eq(newNext);
            if (hasHashTable) {
                next.tail_$eq(newNext);
            }
            this.flushElemsCache();
            return sym;
        }

        /*
         * WARNING - void declaration
         */
        public void enterUnique(Symbols.Symbol sym) {
            void assert_assertion;
            boolean bl;
            SymbolTable symbolTable = this.scala$reflect$internal$Scopes$Scope$$$outer();
            Symbols.Symbol symbol = this.lookup(sym.name());
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Scopes$Scope$$$outer().NoSymbol();
            boolean bl2 = !(symbol != null ? !symbol.equals(noSymbol) : noSymbol != null) ? true : (bl = false);
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(Scope.$anonfun$enterUnique$1(this, sym));
            }
            this.enter(sym);
        }

        public <T extends Symbols.Symbol> T enterIfNew(T sym) {
            ScopeEntry existing = this.lookupEntry(sym.name());
            if (existing == null) {
                return this.enter(sym);
            }
            return (T)existing.sym();
        }

        private void createHash() {
            this.scala$reflect$internal$Scopes$$hashtable_$eq(new ScopeEntry[128]);
            this.enterAllInHash(this.elems(), this.enterAllInHash$default$2());
        }

        private void enterAllInHash(ScopeEntry e, int n) {
            if (e != null) {
                if (n < 1000) {
                    this.enterAllInHash(e.next(), n + 1);
                    this.enterInHash(e);
                    return;
                }
                List entries = Nil$.MODULE$;
                for (ScopeEntry ee = e; ee != null; ee = ee.next()) {
                    entries = entries.$colon$colon(ee);
                }
                if (entries == null) {
                    throw null;
                }
                List foreach_these = entries;
                while (!((List)foreach_these).isEmpty()) {
                    ScopeEntry scopeEntry = (ScopeEntry)((List)foreach_these).head();
                    this.enterInHash(scopeEntry);
                    foreach_these = (List)((AbstractTraversable)foreach_these).tail();
                }
            }
        }

        private int enterAllInHash$default$2() {
            return 0;
        }

        public void rehash(Symbols.Symbol sym, Names.Name newname) {
            if (this.scala$reflect$internal$Scopes$$hashtable() != null) {
                int index = sym.name().start() & 0x7F;
                ScopeEntry e1 = this.scala$reflect$internal$Scopes$$hashtable()[index];
                ScopeEntry e = null;
                if (e1 != null) {
                    Symbols.Symbol symbol = e1.sym();
                    if (symbol != null && symbol.equals(sym)) {
                        this.scala$reflect$internal$Scopes$$hashtable()[index] = e1.tail();
                        e = e1;
                    } else {
                        while (e1.tail() != null) {
                            Symbols.Symbol symbol2 = e1.tail().sym();
                            if (symbol2 != null && symbol2.equals(sym)) break;
                            e1 = e1.tail();
                        }
                        if (e1.tail() != null) {
                            e = e1.tail();
                            e1.tail_$eq(e.tail());
                        }
                    }
                }
                if (e != null) {
                    int newindex = newname.start() & 0x7F;
                    e.tail_$eq(this.scala$reflect$internal$Scopes$$hashtable()[newindex]);
                    this.scala$reflect$internal$Scopes$$hashtable()[newindex] = e;
                    return;
                }
            }
        }

        public void unlink(ScopeEntry e) {
            ScopeEntry scopeEntry = this.elems();
            if (!(scopeEntry != null ? !scopeEntry.equals(e) : e != null)) {
                this.elems_$eq(e.next());
            } else {
                ScopeEntry e1 = this.elems();
                while (true) {
                    ScopeEntry scopeEntry2 = e1.next();
                    if (!(scopeEntry2 == null ? e != null : !scopeEntry2.equals(e))) break;
                    e1 = e1.next();
                }
                e1.next_$eq(e.next());
            }
            if (this.scala$reflect$internal$Scopes$$hashtable() != null) {
                ScopeEntry e1;
                int index = e.sym().name().start() & 0x7F;
                ScopeEntry scopeEntry3 = e1 = this.scala$reflect$internal$Scopes$$hashtable()[index];
                if (scopeEntry3 != null && scopeEntry3.equals(e)) {
                    this.scala$reflect$internal$Scopes$$hashtable()[index] = e.tail();
                } else {
                    while (true) {
                        ScopeEntry scopeEntry4 = e1.tail();
                        if (scopeEntry4 != null && scopeEntry4.equals(e)) break;
                        e1 = e1.tail();
                    }
                    e1.tail_$eq(e.tail());
                }
            }
            this.flushElemsCache();
        }

        public void unlink(Symbols.Symbol sym) {
            ScopeEntry e = this.lookupEntry(sym.name());
            while (e != null) {
                Symbols.Symbol symbol = e.sym();
                if (!(symbol != null ? !symbol.equals(sym) : sym != null)) {
                    this.unlink(e);
                }
                e = this.lookupNextEntry(e);
            }
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol lookupModule(Names.Name name) {
            void findSymbol_p;
            void findSymbol_xs;
            SymbolTable symbolTable = this.scala$reflect$internal$Scopes$Scope$$$outer();
            Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.isModule());
            Iterator<Symbols.Symbol> iterator2 = this.lookupAll(name.toTermName());
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable findSymbol_this = symbolTable;
            Option option = findSymbol_xs.find(findSymbol_p);
            if (option == null) {
                throw null;
            }
            Option findSymbol_getOrElse_this = option;
            Symbols.NoSymbol noSymbol = findSymbol_getOrElse_this.isEmpty() ? SymbolTable.$anonfun$findSymbol$1(findSymbol_this) : findSymbol_getOrElse_this.get();
            return noSymbol;
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol lookupClass(Names.Name name) {
            void findSymbol_p;
            void findSymbol_xs;
            SymbolTable symbolTable = this.scala$reflect$internal$Scopes$Scope$$$outer();
            Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable intersect = (Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(x$3.isClass());
            Iterator<Symbols.Symbol> iterator2 = this.lookupAll(name.toTypeName());
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable findSymbol_this = symbolTable;
            Option option = findSymbol_xs.find(findSymbol_p);
            if (option == null) {
                throw null;
            }
            Option findSymbol_getOrElse_this = option;
            Symbols.NoSymbol noSymbol = findSymbol_getOrElse_this.isEmpty() ? SymbolTable.$anonfun$findSymbol$1(findSymbol_this) : findSymbol_getOrElse_this.get();
            return noSymbol;
        }

        public boolean containsName(Names.Name name) {
            return this.lookupEntry(name) != null;
        }

        public Symbols.Symbol lookup(Names.Name name) {
            ScopeEntry e = this.lookupEntry(name);
            if (e == null) {
                return this.scala$reflect$internal$Scopes$Scope$$$outer().NoSymbol();
            }
            if (this.lookupNextEntry(e) == null) {
                return e.sym();
            }
            List<Symbols.Symbol> alts = this.lookupAll(name).toList();
            this.scala$reflect$internal$Scopes$Scope$$$outer().devWarning((Function0<String> & java.io.Serializable & Serializable)() -> new java.lang.StringBuilder(41).append("scope lookup of ").append(name).append(" found multiple symbols: ").append(Scope.alts_s$1(alts)).toString());
            return this.scala$reflect$internal$Scopes$Scope$$$outer().NoSymbol().newOverloaded(this.scala$reflect$internal$Scopes$Scope$$$outer().NoPrefix(), alts);
        }

        public Iterator<Symbols.Symbol> lookupAll(Names.Name name) {
            return new Iterator<Symbols.Symbol>(this, name){
                private ScopeEntry e;
                private final /* synthetic */ Scope $outer;

                public Iterator<Symbols.Symbol> seq() {
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

                public Iterator<Symbols.Symbol> take(int n) {
                    return Iterator.take$(this, n);
                }

                public Iterator<Symbols.Symbol> drop(int n) {
                    return Iterator.drop$(this, n);
                }

                public Iterator<Symbols.Symbol> slice(int from, int until) {
                    return Iterator.slice$(this, from, until);
                }

                public Iterator<Symbols.Symbol> sliceIterator(int from, int until) {
                    return Iterator.sliceIterator$(this, from, until);
                }

                public <B> Iterator<B> map(Function1<Symbols.Symbol, B> f) {
                    return Iterator.map$(this, f);
                }

                public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                    return Iterator.$plus$plus$(this, that);
                }

                public <B> Iterator<B> flatMap(Function1<Symbols.Symbol, GenTraversableOnce<B>> f) {
                    return Iterator.flatMap$(this, f);
                }

                public Iterator<Symbols.Symbol> filter(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.filter$(this, p);
                }

                public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Symbols.Symbol, B, Object> p) {
                    return Iterator.corresponds$(this, that, p);
                }

                public Iterator<Symbols.Symbol> withFilter(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.withFilter$(this, p);
                }

                public Iterator<Symbols.Symbol> filterNot(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.filterNot$(this, p);
                }

                public <B> Iterator<B> collect(PartialFunction<Symbols.Symbol, B> pf) {
                    return Iterator.collect$(this, pf);
                }

                public <B> Iterator<B> scanLeft(B z, Function2<B, Symbols.Symbol, B> op) {
                    return Iterator.scanLeft$(this, z, op);
                }

                public <B> Iterator<B> scanRight(B z, Function2<Symbols.Symbol, B, B> op) {
                    return Iterator.scanRight$(this, z, op);
                }

                public Iterator<Symbols.Symbol> takeWhile(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.takeWhile$(this, p);
                }

                public Tuple2<Iterator<Symbols.Symbol>, Iterator<Symbols.Symbol>> partition(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.partition$(this, p);
                }

                public Tuple2<Iterator<Symbols.Symbol>, Iterator<Symbols.Symbol>> span(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.span$(this, p);
                }

                public Iterator<Symbols.Symbol> dropWhile(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.dropWhile$(this, p);
                }

                public <B> Iterator<Tuple2<Symbols.Symbol, B>> zip(Iterator<B> that) {
                    return Iterator.zip$(this, that);
                }

                public <A1> Iterator<A1> padTo(int len, A1 elem) {
                    return Iterator.padTo$(this, len, elem);
                }

                public Iterator<Tuple2<Symbols.Symbol, Object>> zipWithIndex() {
                    return Iterator.zipWithIndex$(this);
                }

                public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                    return Iterator.zipAll$(this, that, thisElem, thatElem);
                }

                public <U> void foreach(Function1<Symbols.Symbol, U> f) {
                    Iterator.foreach$(this, f);
                }

                public boolean forall(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.forall$(this, p);
                }

                public boolean exists(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.exists$(this, p);
                }

                public boolean contains(Object elem) {
                    return Iterator.contains$(this, elem);
                }

                public Option<Symbols.Symbol> find(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.find$(this, p);
                }

                public int indexWhere(Function1<Symbols.Symbol, Object> p) {
                    return Iterator.indexWhere$(this, p);
                }

                public int indexWhere(Function1<Symbols.Symbol, Object> p, int from) {
                    return Iterator.indexWhere$(this, p, from);
                }

                public <B> int indexOf(B elem) {
                    return Iterator.indexOf$(this, elem);
                }

                public <B> int indexOf(B elem, int from) {
                    return Iterator.indexOf$(this, elem, from);
                }

                public BufferedIterator<Symbols.Symbol> buffered() {
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

                public Tuple2<Iterator<Symbols.Symbol>, Iterator<Symbols.Symbol>> duplicate() {
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

                public Traversable<Symbols.Symbol> toTraversable() {
                    return Iterator.toTraversable$(this);
                }

                public Iterator<Symbols.Symbol> toIterator() {
                    return Iterator.toIterator$(this);
                }

                public Stream<Symbols.Symbol> toStream() {
                    return Iterator.toStream$(this);
                }

                public String toString() {
                    return Iterator.toString$(this);
                }

                public List<Symbols.Symbol> reversed() {
                    return TraversableOnce.reversed$(this);
                }

                public int size() {
                    return TraversableOnce.size$(this);
                }

                public boolean nonEmpty() {
                    return TraversableOnce.nonEmpty$(this);
                }

                public int count(Function1<Symbols.Symbol, Object> p) {
                    return TraversableOnce.count$(this, p);
                }

                public <B> Option<B> collectFirst(PartialFunction<Symbols.Symbol, B> pf) {
                    return TraversableOnce.collectFirst$(this, pf);
                }

                public <B> B $div$colon(B z, Function2<B, Symbols.Symbol, B> op) {
                    return (B)TraversableOnce.$div$colon$(this, z, op);
                }

                public <B> B $colon$bslash(B z, Function2<Symbols.Symbol, B, B> op) {
                    return (B)TraversableOnce.$colon$bslash$(this, z, op);
                }

                public <B> B foldLeft(B z, Function2<B, Symbols.Symbol, B> op) {
                    return (B)TraversableOnce.foldLeft$(this, z, op);
                }

                public <B> B foldRight(B z, Function2<Symbols.Symbol, B, B> op) {
                    return (B)TraversableOnce.foldRight$(this, z, op);
                }

                public <B> B reduceLeft(Function2<B, Symbols.Symbol, B> op) {
                    return (B)TraversableOnce.reduceLeft$(this, op);
                }

                public <B> B reduceRight(Function2<Symbols.Symbol, B, B> op) {
                    return (B)TraversableOnce.reduceRight$(this, op);
                }

                public <B> Option<B> reduceLeftOption(Function2<B, Symbols.Symbol, B> op) {
                    return TraversableOnce.reduceLeftOption$(this, op);
                }

                public <B> Option<B> reduceRightOption(Function2<Symbols.Symbol, B, B> op) {
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

                public <B> B aggregate(Function0<B> z, Function2<B, Symbols.Symbol, B> seqop, Function2<B, B, B> combop) {
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

                public List<Symbols.Symbol> toList() {
                    return TraversableOnce.toList$(this);
                }

                public Iterable<Symbols.Symbol> toIterable() {
                    return TraversableOnce.toIterable$(this);
                }

                public Seq<Symbols.Symbol> toSeq() {
                    return TraversableOnce.toSeq$(this);
                }

                public IndexedSeq<Symbols.Symbol> toIndexedSeq() {
                    return TraversableOnce.toIndexedSeq$(this);
                }

                public <B> Buffer<B> toBuffer() {
                    return TraversableOnce.toBuffer$(this);
                }

                public <B> Set<B> toSet() {
                    return TraversableOnce.toSet$(this);
                }

                public Vector<Symbols.Symbol> toVector() {
                    return TraversableOnce.toVector$(this);
                }

                public <Col> Col to(CanBuildFrom<Nothing$, Symbols.Symbol, Col> cbf) {
                    return (Col)TraversableOnce.to$(this, cbf);
                }

                public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Symbols.Symbol, Tuple2<T, U>> ev) {
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

                private ScopeEntry e() {
                    return this.e;
                }

                private void e_$eq(ScopeEntry x$1) {
                    this.e = x$1;
                }

                public boolean hasNext() {
                    return this.e() != null;
                }

                public Symbols.Symbol next() {
                    Symbols.Symbol symbol;
                    try {
                        symbol = this.e().sym();
                    }
                    finally {
                        this.e_$eq(this.$outer.lookupNextEntry(this.e()));
                    }
                    return symbol;
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    GenTraversableOnce.$init$(this);
                    TraversableOnce.$init$(this);
                    Iterator.$init$(this);
                    this.e = $outer.lookupEntry(name$2);
                }
            };
        }

        public Iterator<ScopeEntry> lookupAllEntries(Names.Name name) {
            return new Iterator<ScopeEntry>(this, name){
                private ScopeEntry e;
                private final /* synthetic */ Scope $outer;

                public Iterator<ScopeEntry> seq() {
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

                public Iterator<ScopeEntry> take(int n) {
                    return Iterator.take$(this, n);
                }

                public Iterator<ScopeEntry> drop(int n) {
                    return Iterator.drop$(this, n);
                }

                public Iterator<ScopeEntry> slice(int from, int until) {
                    return Iterator.slice$(this, from, until);
                }

                public Iterator<ScopeEntry> sliceIterator(int from, int until) {
                    return Iterator.sliceIterator$(this, from, until);
                }

                public <B> Iterator<B> map(Function1<ScopeEntry, B> f) {
                    return Iterator.map$(this, f);
                }

                public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                    return Iterator.$plus$plus$(this, that);
                }

                public <B> Iterator<B> flatMap(Function1<ScopeEntry, GenTraversableOnce<B>> f) {
                    return Iterator.flatMap$(this, f);
                }

                public Iterator<ScopeEntry> filter(Function1<ScopeEntry, Object> p) {
                    return Iterator.filter$(this, p);
                }

                public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<ScopeEntry, B, Object> p) {
                    return Iterator.corresponds$(this, that, p);
                }

                public Iterator<ScopeEntry> withFilter(Function1<ScopeEntry, Object> p) {
                    return Iterator.withFilter$(this, p);
                }

                public Iterator<ScopeEntry> filterNot(Function1<ScopeEntry, Object> p) {
                    return Iterator.filterNot$(this, p);
                }

                public <B> Iterator<B> collect(PartialFunction<ScopeEntry, B> pf) {
                    return Iterator.collect$(this, pf);
                }

                public <B> Iterator<B> scanLeft(B z, Function2<B, ScopeEntry, B> op) {
                    return Iterator.scanLeft$(this, z, op);
                }

                public <B> Iterator<B> scanRight(B z, Function2<ScopeEntry, B, B> op) {
                    return Iterator.scanRight$(this, z, op);
                }

                public Iterator<ScopeEntry> takeWhile(Function1<ScopeEntry, Object> p) {
                    return Iterator.takeWhile$(this, p);
                }

                public Tuple2<Iterator<ScopeEntry>, Iterator<ScopeEntry>> partition(Function1<ScopeEntry, Object> p) {
                    return Iterator.partition$(this, p);
                }

                public Tuple2<Iterator<ScopeEntry>, Iterator<ScopeEntry>> span(Function1<ScopeEntry, Object> p) {
                    return Iterator.span$(this, p);
                }

                public Iterator<ScopeEntry> dropWhile(Function1<ScopeEntry, Object> p) {
                    return Iterator.dropWhile$(this, p);
                }

                public <B> Iterator<Tuple2<ScopeEntry, B>> zip(Iterator<B> that) {
                    return Iterator.zip$(this, that);
                }

                public <A1> Iterator<A1> padTo(int len, A1 elem) {
                    return Iterator.padTo$(this, len, elem);
                }

                public Iterator<Tuple2<ScopeEntry, Object>> zipWithIndex() {
                    return Iterator.zipWithIndex$(this);
                }

                public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                    return Iterator.zipAll$(this, that, thisElem, thatElem);
                }

                public <U> void foreach(Function1<ScopeEntry, U> f) {
                    Iterator.foreach$(this, f);
                }

                public boolean forall(Function1<ScopeEntry, Object> p) {
                    return Iterator.forall$(this, p);
                }

                public boolean exists(Function1<ScopeEntry, Object> p) {
                    return Iterator.exists$(this, p);
                }

                public boolean contains(Object elem) {
                    return Iterator.contains$(this, elem);
                }

                public Option<ScopeEntry> find(Function1<ScopeEntry, Object> p) {
                    return Iterator.find$(this, p);
                }

                public int indexWhere(Function1<ScopeEntry, Object> p) {
                    return Iterator.indexWhere$(this, p);
                }

                public int indexWhere(Function1<ScopeEntry, Object> p, int from) {
                    return Iterator.indexWhere$(this, p, from);
                }

                public <B> int indexOf(B elem) {
                    return Iterator.indexOf$(this, elem);
                }

                public <B> int indexOf(B elem, int from) {
                    return Iterator.indexOf$(this, elem, from);
                }

                public BufferedIterator<ScopeEntry> buffered() {
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

                public Tuple2<Iterator<ScopeEntry>, Iterator<ScopeEntry>> duplicate() {
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

                public Traversable<ScopeEntry> toTraversable() {
                    return Iterator.toTraversable$(this);
                }

                public Iterator<ScopeEntry> toIterator() {
                    return Iterator.toIterator$(this);
                }

                public Stream<ScopeEntry> toStream() {
                    return Iterator.toStream$(this);
                }

                public String toString() {
                    return Iterator.toString$(this);
                }

                public List<ScopeEntry> reversed() {
                    return TraversableOnce.reversed$(this);
                }

                public int size() {
                    return TraversableOnce.size$(this);
                }

                public boolean nonEmpty() {
                    return TraversableOnce.nonEmpty$(this);
                }

                public int count(Function1<ScopeEntry, Object> p) {
                    return TraversableOnce.count$(this, p);
                }

                public <B> Option<B> collectFirst(PartialFunction<ScopeEntry, B> pf) {
                    return TraversableOnce.collectFirst$(this, pf);
                }

                public <B> B $div$colon(B z, Function2<B, ScopeEntry, B> op) {
                    return (B)TraversableOnce.$div$colon$(this, z, op);
                }

                public <B> B $colon$bslash(B z, Function2<ScopeEntry, B, B> op) {
                    return (B)TraversableOnce.$colon$bslash$(this, z, op);
                }

                public <B> B foldLeft(B z, Function2<B, ScopeEntry, B> op) {
                    return (B)TraversableOnce.foldLeft$(this, z, op);
                }

                public <B> B foldRight(B z, Function2<ScopeEntry, B, B> op) {
                    return (B)TraversableOnce.foldRight$(this, z, op);
                }

                public <B> B reduceLeft(Function2<B, ScopeEntry, B> op) {
                    return (B)TraversableOnce.reduceLeft$(this, op);
                }

                public <B> B reduceRight(Function2<ScopeEntry, B, B> op) {
                    return (B)TraversableOnce.reduceRight$(this, op);
                }

                public <B> Option<B> reduceLeftOption(Function2<B, ScopeEntry, B> op) {
                    return TraversableOnce.reduceLeftOption$(this, op);
                }

                public <B> Option<B> reduceRightOption(Function2<ScopeEntry, B, B> op) {
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

                public <B> B aggregate(Function0<B> z, Function2<B, ScopeEntry, B> seqop, Function2<B, B, B> combop) {
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

                public List<ScopeEntry> toList() {
                    return TraversableOnce.toList$(this);
                }

                public Iterable<ScopeEntry> toIterable() {
                    return TraversableOnce.toIterable$(this);
                }

                public Seq<ScopeEntry> toSeq() {
                    return TraversableOnce.toSeq$(this);
                }

                public IndexedSeq<ScopeEntry> toIndexedSeq() {
                    return TraversableOnce.toIndexedSeq$(this);
                }

                public <B> Buffer<B> toBuffer() {
                    return TraversableOnce.toBuffer$(this);
                }

                public <B> Set<B> toSet() {
                    return TraversableOnce.toSet$(this);
                }

                public Vector<ScopeEntry> toVector() {
                    return TraversableOnce.toVector$(this);
                }

                public <Col> Col to(CanBuildFrom<Nothing$, ScopeEntry, Col> cbf) {
                    return (Col)TraversableOnce.to$(this, cbf);
                }

                public <T, U> Map<T, U> toMap(Predef$.less.colon.less<ScopeEntry, Tuple2<T, U>> ev) {
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

                private ScopeEntry e() {
                    return this.e;
                }

                private void e_$eq(ScopeEntry x$1) {
                    this.e = x$1;
                }

                public boolean hasNext() {
                    return this.e() != null;
                }

                public ScopeEntry next() {
                    ScopeEntry scopeEntry;
                    try {
                        scopeEntry = this.e();
                    }
                    finally {
                        this.e_$eq(this.$outer.lookupNextEntry(this.e()));
                    }
                    return scopeEntry;
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    GenTraversableOnce.$init$(this);
                    TraversableOnce.$init$(this);
                    Iterator.$init$(this);
                    this.e = $outer.lookupEntry(name$3);
                }
            };
        }

        public Iterator<ScopeEntry> lookupUnshadowedEntries(Names.Name name) {
            ScopeEntry scopeEntry = this.lookupEntry(name);
            Iterator<Object> iterator2 = scopeEntry == null ? package$.MODULE$.Iterator().empty() : this.lookupAllEntries(name).filter((Function1<ScopeEntry, Object> & java.io.Serializable & Serializable)(A e1) -> BoxesRunTime.boxToBoolean(Scope.$anonfun$lookupUnshadowedEntries$1(scopeEntry, e1)));
            return iterator2;
        }

        public final ScopeEntry lookupSymbolEntry(Symbols.Symbol sym) {
            ScopeEntry e = this.lookupEntry(sym.name());
            while (e != null) {
                Symbols.Symbol symbol = e.sym();
                if (symbol != null && symbol.equals(sym)) {
                    return e;
                }
                e = this.lookupNextEntry(e);
            }
            return null;
        }

        /*
         * WARNING - void declaration
         */
        public ScopeEntry lookupEntry(Names.Name name) {
            void var2_3;
            ScopeEntry e;
            boolean flat = this.scala$reflect$internal$Scopes$Scope$$$outer().phase().flatClasses();
            if (this.scala$reflect$internal$Scopes$$hashtable() != null) {
                for (e = this.scala$reflect$internal$Scopes$$hashtable()[name.start() & 0x7F]; e != null && e.name(flat) != name; e = e.tail()) {
                }
            } else {
                for (e = this.elems(); e != null && e.name(flat) != name; e = e.next()) {
                }
            }
            return var2_3;
        }

        /*
         * WARNING - void declaration
         */
        public ScopeEntry lookupNextEntry(ScopeEntry entry) {
            void var2_2;
            ScopeEntry e = entry;
            boolean flat = this.scala$reflect$internal$Scopes$Scope$$$outer().phase().flatClasses();
            Names.Name entryName = entry.name(flat);
            if (this.scala$reflect$internal$Scopes$$hashtable() != null) {
                while ((e = e.tail()) != null) {
                    Names.Name name = e.name(flat);
                    if (name == null ? entryName != null : !name.equals(entryName)) {
                        continue;
                    }
                    break;
                }
            } else {
                while ((e = e.next()) != null) {
                    Names.Name name = e.name(flat);
                    if (name != null ? !name.equals(entryName) : entryName != null) continue;
                    break;
                }
            }
            return var2_2;
        }

        public final Symbols.Symbol lookupNameInSameScopeAs(Symbols.Symbol original, Names.Name companionName) {
            ScopeEntry scopeEntry = this.lookupSymbolEntry(original);
            if (scopeEntry != null) {
                ScopeEntry e = this.lookupEntry(companionName);
                while (e != null) {
                    if (e.owner() == scopeEntry.owner()) {
                        return e.sym();
                    }
                    e = this.lookupNextEntry(e);
                }
            }
            return this.scala$reflect$internal$Scopes$Scope$$$outer().NoSymbol();
        }

        public boolean isSameScope(Scope other) {
            return this.size() == other.size() && this.isSubScope(other) && other.isSubScope(this);
        }

        public boolean isSubScope(Scope other) {
            boolean bl;
            block3: {
                List<Symbols.Symbol> list = other.toList();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized forall_these = list;
                while (!forall_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)forall_these.head();
                    if (!this.scopeContainsSym$1(symbol)) {
                        bl = false;
                        break block3;
                    }
                    forall_these = (LinearSeqOptimized)forall_these.tail();
                }
                bl = true;
            }
            return bl;
        }

        @Override
        public List<Symbols.Symbol> toList() {
            if (this.elemsCache() == null) {
                List symbols = Nil$.MODULE$;
                int count = 0;
                for (ScopeEntry e = this.elems(); e != null; e = e.next()) {
                    Scope scope = e.owner();
                    if (scope != null ? !scope.equals(this) : this != null) break;
                    ++count;
                    symbols = symbols.$colon$colon(e.sym());
                }
                this.elemsCache_$eq(symbols);
                this.cachedSize_$eq(count);
            }
            return this.elemsCache();
        }

        public List<Symbols.Symbol> sorted() {
            return this.toList();
        }

        public int nestingLevel() {
            return this.scala$reflect$internal$Scopes$$nestinglevel();
        }

        @Override
        public Iterator<Symbols.Symbol> iterator() {
            return this.toList().iterator();
        }

        @Override
        public <U> void foreach(Function1<Symbols.Symbol, U> p) {
            List list = this.toList();
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                p.apply(foreach_these.head());
                foreach_these = (List)foreach_these.tail();
            }
        }

        @Override
        public Scope filterNot(Function1<Symbols.Symbol, Object> p) {
            List<Symbols.Symbol> result2 = this.toList();
            List filtered = (List)result2.filterNot((Function1)p);
            if (this.scala$reflect$internal$Scopes$Scope$$$outer().sameLength(result2, filtered)) {
                return this;
            }
            return this.scala$reflect$internal$Scopes$Scope$$$outer().newScopeWith(filtered);
        }

        @Override
        public Scope filter(Function1<Symbols.Symbol, Object> p) {
            List<Symbols.Symbol> result2 = this.toList();
            List filtered = (List)result2.filter((Function1)p);
            if (this.scala$reflect$internal$Scopes$Scope$$$outer().sameLength(result2, filtered)) {
                return this;
            }
            return this.scala$reflect$internal$Scopes$Scope$$$outer().newScopeWith(filtered);
        }

        public List<Symbols.Symbol> reverse() {
            return this.toList().reverse();
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return ((TraversableOnce)this.toList().map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)(A x$4) -> x$4.defString(), List$.MODULE$.canBuildFrom())).mkString(start, sep, end);
        }

        @Override
        public String toString() {
            return this.mkString("Scope{\n  ", ";\n  ", "\n}");
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Scopes$Scope$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ Tuple2 $anonfun$enterBefore$2(Symbols.Symbol sym$1, ScopeEntry next$1) {
            return new Tuple2<Symbols.Symbol, Symbols.Symbol>(sym$1, next$1.sym());
        }

        public static final /* synthetic */ Tuple2 $anonfun$enterBefore$3(Symbols.Symbol sym$1, ScopeEntry next$1) {
            return new Tuple2<Symbols.Symbol, Symbols.Symbol>(sym$1, next$1.sym());
        }

        public static final /* synthetic */ Tuple2 $anonfun$enterUnique$1(Scope $this, Symbols.Symbol sym$2) {
            return new Tuple2<String, String>(sym$2.fullLocationString(), $this.lookup(sym$2.name()).fullLocationString());
        }

        private static final String alts_s$1(List alts$1) {
            return ((TraversableOnce)alts$1.map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)(A s) -> s.defString(), List$.MODULE$.canBuildFrom())).mkString(" <and> ");
        }

        public static final /* synthetic */ boolean $anonfun$lookupUnshadowedEntries$1(ScopeEntry x1$1, ScopeEntry e1) {
            block3: {
                block2: {
                    if (x1$1 == e1) break block2;
                    if (x1$1.depth() != e1.depth()) break block3;
                    Symbols.Symbol symbol = x1$1.sym();
                    Symbols.Symbol symbol2 = e1.sym();
                    if (!(symbol == null ? symbol2 != null : !symbol.equals(symbol2))) break block3;
                }
                return true;
            }
            return false;
        }

        private final boolean entryContainsSym$1(ScopeEntry e, Symbols.Symbol sym$3) {
            boolean bl;
            block2: {
                while (true) {
                    if (e == null) {
                        bl = false;
                        break block2;
                    }
                    Types.Type comparableInfo = sym$3.info().substThis(sym$3.owner(), e.sym().owner());
                    if (e.sym().info().$eq$colon$eq(comparableInfo)) break;
                    e = this.lookupNextEntry(e);
                }
                bl = true;
            }
            return bl;
        }

        private final boolean scopeContainsSym$1(Symbols.Symbol sym) {
            return this.entryContainsSym$1(this.lookupEntry(sym.name()), sym);
        }

        public Scope(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
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
            $outer.scopeCount_$eq($outer.scopeCount() + 1);
            this.scala$reflect$internal$Scopes$$nestinglevel = 0;
            this.scala$reflect$internal$Scopes$$hashtable = null;
            this.elemsCache = null;
            this.cachedSize = -1;
        }

        public static final /* synthetic */ Object $anonfun$enterAllInHash$1$adapted(Scope $this, ScopeEntry e) {
            $this.enterInHash(e);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$isSubScope$1$adapted(Scope $this, Symbols.Symbol sym) {
            return BoxesRunTime.boxToBoolean($this.scopeContainsSym$1(sym));
        }
    }

    public class ScopeEntry {
        private Symbols.Symbol sym;
        private final Scope owner;
        private ScopeEntry tail;
        private ScopeEntry next;
        public final /* synthetic */ SymbolTable $outer;

        public Symbols.Symbol sym() {
            return this.sym;
        }

        public void sym_$eq(Symbols.Symbol x$1) {
            this.sym = x$1;
        }

        public Scope owner() {
            return this.owner;
        }

        public ScopeEntry tail() {
            return this.tail;
        }

        public void tail_$eq(ScopeEntry x$1) {
            this.tail = x$1;
        }

        public ScopeEntry next() {
            return this.next;
        }

        public void next_$eq(ScopeEntry x$1) {
            this.next = x$1;
        }

        public int depth() {
            return this.owner().nestingLevel();
        }

        public int hashCode() {
            return this.sym().name().start();
        }

        public String toString() {
            return new java.lang.StringBuilder(9).append(this.sym()).append(" (depth=").append(this.depth()).append(")").toString();
        }

        public final Names.Name name(boolean flat) {
            if (flat) {
                return this.sym().name();
            }
            return this.sym().rawname();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Scopes$ScopeEntry$$$outer() {
            return this.$outer;
        }

        public ScopeEntry(SymbolTable $outer, Symbols.Symbol sym, Scope owner) {
            this.sym = sym;
            this.owner = owner;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.tail = null;
            this.next = null;
        }
    }
}

