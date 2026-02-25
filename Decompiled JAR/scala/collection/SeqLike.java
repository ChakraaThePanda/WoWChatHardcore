/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import java.util.Arrays;
import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractIterator;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.IterableViewLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqLike$;
import scala.collection.SeqView;
import scala.collection.SeqViewLike;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.SliceInterval;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashMap$;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.Map;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSeq;
import scala.collection.parallel.ParSeq$;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.Ordering$;
import scala.math.Ordering$Int$;
import scala.math.PartialOrdering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction1$mcVI$sp;
import scala.runtime.java8.JFunction1$mcZI$sp;
import scala.runtime.java8.JFunction2$mcIII$sp;

@ScalaSignature(bytes="\u0006\u0001\u0011\u001dfaB*U!\u0003\r\t!\u0017\u0005\u0006u\u0002!\ta\u001f\u0005\b\u007f\u0002\u0001K\u0011KA\u0001\u0011!\tI\u0001\u0001Q\u0005R\u0005-\u0001bBA\t\u0001\u0019\u0005\u00111\u0003\u0005\b\u00037\u0001a\u0011AA\u000f\u0011!\t\u0019\u0003\u0001Q\u0005R\u0005\u0015\u0002bBA\u0017\u0001\u0011\u0005\u0011q\u0006\u0005\b\u0003k\u0001A\u0011IA\u001c\u0011\u001d\ty\u0004\u0001C!\u0003'Aq!!\u0011\u0001\t\u0003\t\u0019\u0005C\u0004\u0002T\u0001!\t!!\u0016\t\u000f\u0005m\u0003\u0001\"\u0001\u0002^!9\u0011Q\r\u0001\u0005\u0002\u0005\u001d\u0004bBA8\u0001\u0011\u0005\u0011\u0011\u000f\u0004\u0007\u0003o\u0002A!!\u001f\t\u000f\u0005\u0005u\u0002\"\u0001\u0002\u0004\"a\u0011\u0011R\b\u0011\u0002\u0003\r\t\u0015!\u0003\u0002\f\"A\u00111U\b!\u0002\u0013\t\t\n\u0003\u0005\u0002&>\u0001\u000b\u0011BAO\u0011%\t9k\u0004a\u0001\n\u0013\t9\u0004C\u0005\u0002*>\u0001\r\u0011\"\u0003\u0002,\"A\u0011qV\b!B\u0013\tI\u0004C\u0004\u00022>!\t!a\u000e\t\u000f\u0005Mv\u0002\"\u0001\u00026\"9\u0011qW\b\u0005\n\u0005e\u0006\u0002CAb\u001f\u0001&I!!2\u0007\r\u0005\u001d\u0007\u0001BAe\u0011)\t)h\u0007B\u0001B\u0003%\u0011Q\u0003\u0005\b\u0003\u0003[B\u0011AAf\u00111\t\tn\u0007I\u0001\u0002\u0007\u0005\u000b\u0011BAj\u0011%\t\u0019k\u0007b\u0001\n\u0013\ty\u000e\u0003\u0005\u0002bn\u0001\u000b\u0011BAm\u0011%\t\u0019o\u0007b\u0001\n\u0013\t)\u000f\u0003\u0005\u0002hn\u0001\u000b\u0011BAO\u0011%\tIo\u0007b\u0001\n\u0013\t)\u000f\u0003\u0005\u0002ln\u0001\u000b\u0011BAO\u0011%\tio\u0007b\u0001\n\u0013\t)\u000f\u0003\u0005\u0002pn\u0001\u000b\u0011BAO\u0011%\t9k\u0007a\u0001\n\u0013\t9\u0004C\u0005\u0002*n\u0001\r\u0011\"\u0003\u0002r\"A\u0011qV\u000e!B\u0013\tI\u0004C\u0004\u00022n!\t!a\u000e\t\u000f\u0005M6\u0004\"\u0001\u00026\"9\u00111Y\u000e\u0005\n\u0005U\bbBA|\u0001\u0011\u0005\u0011\u0011 \u0005\b\u0003w\u0004A\u0011AA\u007f\u0011\u001d\u0011)\u0003\u0001C\u0001\u0005OAqAa\u000b\u0001\t\u0003\u0011i\u0003C\u0004\u0003D\u0001!\tA!\u0012\t\u000f\tE\u0003\u0001\"\u0001\u0003T!9!\u0011\u000b\u0001\u0005\u0002\t\u0005\u0004b\u0002B8\u0001\u0011\u0005!\u0011\u000f\u0005\b\u0005_\u0002A\u0011\u0001B?\u0011\u001d\u0011Y\t\u0001C\u0001\u0005\u001bCqA!'\u0001\t\u0003\u0011Y\nC\u0004\u0003*\u0002!\tEa+\t\u000f\t\u0005\u0007\u0001\"\u0001\u0003D\"9!q\u001a\u0001\u0005\u0002\tE\u0007b\u0002Bo\u0001\u0011%!q\u001c\u0005\b\u0005g\u0004A\u0011AA}\u0011\u001d\u0011)\u0010\u0001C\u0001\u0005oDqaa\u0005\u0001\t\u0003\u0019)\u0002C\u0004\u0004.\u0001!\taa\f\t\u000f\r\r\u0003\u0001\"\u0001\u0004F!91\u0011\f\u0001\u0005\u0002\rm\u0003bBB9\u0001\u0011\u000511\u000f\u0005\b\u0007\u0013\u0003A\u0011ABF\u0011\u001d\u0019\u0019\n\u0001C\u0001\u0007+Cqaa-\u0001\t\u0003\u0019)\fC\u0004\u0004B\u0002!\t%!\u0001\t\u000f\r\r\u0007\u0001\"\u0001\u0004F\"911\u001b\u0001\u0005B\rU\u0007bBBj\u0001\u0011\u00053\u0011\u001e\u0005\b\u0007c\u0004A\u0011IBz\u000f\u001d!Y\u0001\u0016E\u0001\t\u001b1aa\u0015+\t\u0002\u0011=\u0001bBAA\u0019\u0012\u0005A\u0011\u0003\u0005\b\t'aE\u0011\u0002C\u000b\u0011\u001d!\t\u0004\u0014C\u0005\tgAq\u0001\"\u0012M\t\u0013!9\u0005C\u0004\u0005f1#\t\u0001b\u001a\t\u000f\u00115E\n\"\u0001\u0005\u0010\n91+Z9MS.,'BA+W\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002/\u0006)1oY1mC\u000e\u0001Qc\u0001.fYN)\u0001aW0ocB\u0011A,X\u0007\u0002-&\u0011aL\u0016\u0002\u0004\u0003:L\b\u0003\u00021bG.l\u0011\u0001V\u0005\u0003ER\u0013A\"\u0013;fe\u0006\u0014G.\u001a'jW\u0016\u0004\"\u0001Z3\r\u0001\u00111a\r\u0001CC\u0002\u001d\u0014\u0011!Q\t\u0003Qn\u0003\"\u0001X5\n\u0005)4&a\u0002(pi\"Lgn\u001a\t\u0003I2$a!\u001c\u0001\u0005\u0006\u00049'\u0001\u0002*faJ\u0004B\u0001Y8dW&\u0011\u0001\u000f\u0016\u0002\u000b\u000f\u0016t7+Z9MS.,\u0007\u0003\u00021sGRL!a\u001d+\u0003\u001dA\u000b'/\u00197mK2L'0\u00192mKB\u0019Q\u000f_2\u000e\u0003YT!a\u001e+\u0002\u0011A\f'/\u00197mK2L!!\u001f<\u0003\rA\u000b'oU3r\u0003\u0019!\u0013N\\5uIQ\tA\u0010\u0005\u0002]{&\u0011aP\u0016\u0002\u0005+:LG/\u0001\buQ&\u001c8i\u001c7mK\u000e$\u0018n\u001c8\u0016\u0005\u0005\r\u0001\u0003\u00021\u0002\u0006\rL1!a\u0002U\u0005\r\u0019V-]\u0001\ri>\u001cu\u000e\u001c7fGRLwN\u001c\u000b\u0005\u0003\u0007\ti\u0001\u0003\u0004\u0002\u0010\r\u0001\ra[\u0001\u0005e\u0016\u0004(/\u0001\u0004mK:<G\u000f[\u000b\u0003\u0003+\u00012\u0001XA\f\u0013\r\tIB\u0016\u0002\u0004\u0013:$\u0018!B1qa2LHcA2\u0002 !9\u0011\u0011E\u0003A\u0002\u0005U\u0011aA5eq\u0006Y\u0001/\u0019:D_6\u0014\u0017N\\3s+\t\t9\u0003E\u0003v\u0003S\u0019G/C\u0002\u0002,Y\u0014\u0001bQ8nE&tWM]\u0001\u000eY\u0016tw\r\u001e5D_6\u0004\u0018M]3\u0015\t\u0005U\u0011\u0011\u0007\u0005\b\u0003g9\u0001\u0019AA\u000b\u0003\raWM\\\u0001\bSN,U\u000e\u001d;z+\t\tI\u0004E\u0002]\u0003wI1!!\u0010W\u0005\u001d\u0011un\u001c7fC:\fAa]5{K\u0006i1/Z4nK:$H*\u001a8hi\"$b!!\u0006\u0002F\u0005=\u0003bBA$\u0015\u0001\u0007\u0011\u0011J\u0001\u0002aB1A,a\u0013d\u0003sI1!!\u0014W\u0005%1UO\\2uS>t\u0017\u0007C\u0004\u0002R)\u0001\r!!\u0006\u0002\t\u0019\u0014x.\\\u0001\u000bS:$W\r_,iKJ,GCBA\u000b\u0003/\nI\u0006C\u0004\u0002H-\u0001\r!!\u0013\t\u000f\u0005E3\u00021\u0001\u0002\u0016\u0005qA.Y:u\u0013:$W\r_,iKJ,GCBA\u000b\u0003?\n\t\u0007C\u0004\u0002H1\u0001\r!!\u0013\t\u000f\u0005\rD\u00021\u0001\u0002\u0016\u0005\u0019QM\u001c3\u0002\u0019A,'/\\;uCRLwN\\:\u0016\u0005\u0005%\u0004\u0003\u00021\u0002l-L1!!\u001cU\u0005!IE/\u001a:bi>\u0014\u0018\u0001D2p[\nLg.\u0019;j_:\u001cH\u0003BA5\u0003gBq!!\u001e\u000f\u0001\u0004\t)\"A\u0001o\u0005=\u0001VM]7vi\u0006$\u0018n\u001c8t\u0013R\u00148cA\b\u0002|A!\u0001-! l\u0013\r\ty\b\u0016\u0002\u0011\u0003\n\u001cHO]1di&#XM]1u_J\fa\u0001P5oSRtDCAAC!\r\t9iD\u0007\u0002\u0001\u0005\u0019\u0001\u0010J\u0019\u0011\u000fq\u000bi)!%\u0002\u001e&\u0019\u0011q\u0012,\u0003\rQ+\b\u000f\\33!\u0015\t\u0019*!'d\u001b\t\t)JC\u0002\u0002\u0018R\u000bq!\\;uC\ndW-\u0003\u0003\u0002\u001c\u0006U%A\u0002\"vM\u001a,'\u000fE\u0003]\u0003?\u000b)\"C\u0002\u0002\"Z\u0013Q!\u0011:sCf\fA!\u001a7ng\u0006!\u0011\u000e\u001a=t\u0003!y\u0006.Y:OKb$\u0018\u0001D0iCNtU\r\u001f;`I\u0015\fHc\u0001?\u0002.\"I\u0011\u0011R\u000b\u0002\u0002\u0003\u0007\u0011\u0011H\u0001\n?\"\f7OT3yi\u0002\nq\u0001[1t\u001d\u0016DH/\u0001\u0003oKb$H#A6\u0002\tM<\u0018\r\u001d\u000b\u0006y\u0006m\u0016q\u0018\u0005\b\u0003{K\u0002\u0019AA\u000b\u0003\u0005I\u0007bBAa3\u0001\u0007\u0011QC\u0001\u0002U\u0006!\u0011N\\5u)\t\tYIA\bD_6\u0014\u0017N\\1uS>t7/\u0013;s'\rY\u00121\u0010\u000b\u0005\u0003\u001b\fy\rE\u0002\u0002\bnAq!!\u001e\u001e\u0001\u0004\t)\"A\u0002yIQ\u0002\u0012\u0002XAk\u00033\fi*!(\n\u0007\u0005]gK\u0001\u0004UkBdWm\r\t\u0005A\u0006m7-C\u0002\u0002^R\u0013!\"\u00138eKb,GmU3r+\t\tI.A\u0003fY6\u001c\b%\u0001\u0003d]R\u001cXCAAO\u0003\u0015\u0019g\u000e^:!\u0003\u0011qW/\\:\u0002\u000b9,Xn\u001d\u0011\u0002\t=4gm]\u0001\u0006_\u001a47\u000f\t\u000b\u0004y\u0006M\b\"CAEQ\u0005\u0005\t\u0019AA\u001d)\t\t\u0019.A\u0004sKZ,'o]3\u0016\u0003-\f!B]3wKJ\u001cX-T1q+\u0019\tyPa\u0007\u0003\u0006Q!!\u0011\u0001B\u0010)\u0011\u0011\u0019A!\u0003\u0011\u0007\u0011\u0014)\u0001\u0002\u0004\u0003\b9\u0012\ra\u001a\u0002\u0005)\"\fG\u000fC\u0004\u0003\f9\u0002\u001dA!\u0004\u0002\u0005\t4\u0007#\u0003B\b\u0005+Y'\u0011\u0004B\u0002\u001b\t\u0011\tBC\u0002\u0003\u0014Q\u000bqaZ3oKJL7-\u0003\u0003\u0003\u0018\tE!\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007c\u00013\u0003\u001c\u00111!Q\u0004\u0018C\u0002\u001d\u0014\u0011A\u0011\u0005\b\u0005Cq\u0003\u0019\u0001B\u0012\u0003\u00051\u0007C\u0002/\u0002L\r\u0014I\"A\bsKZ,'o]3Ji\u0016\u0014\u0018\r^8s+\t\u0011I\u0003\u0005\u0003a\u0003W\u001a\u0017AC:uCJ$8oV5uQV!!q\u0006B\u001f)\u0019\tID!\r\u0003@!9!1\u0007\u0019A\u0002\tU\u0012\u0001\u0002;iCR\u0004R\u0001\u0019B\u001c\u0005wI1A!\u000fU\u0005\u00199UM\\*fcB\u0019AM!\u0010\u0005\r\tu\u0001G1\u0001h\u0011\u001d\u0011\t\u0005\ra\u0001\u0003+\taa\u001c4gg\u0016$\u0018\u0001C3oIN<\u0016\u000e\u001e5\u0016\t\t\u001d#q\n\u000b\u0005\u0003s\u0011I\u0005C\u0004\u00034E\u0002\rAa\u0013\u0011\u000b\u0001\u00149D!\u0014\u0011\u0007\u0011\u0014y\u0005\u0002\u0004\u0003\u001eE\u0012\raZ\u0001\rS:$W\r_(g'2L7-Z\u000b\u0005\u0005+\u0012i\u0006\u0006\u0003\u0002\u0016\t]\u0003b\u0002B\u001ae\u0001\u0007!\u0011\f\t\u0006A\n]\"1\f\t\u0004I\nuCa\u0002B\u000fe\t\u0007!qL\t\u0003Gn+BAa\u0019\u0003lQ1\u0011Q\u0003B3\u0005[BqAa\r4\u0001\u0004\u00119\u0007E\u0003a\u0005o\u0011I\u0007E\u0002e\u0005W\"qA!\b4\u0005\u0004\u0011y\u0006C\u0004\u0002RM\u0002\r!!\u0006\u0002!1\f7\u000f^%oI\u0016DxJZ*mS\u000e,W\u0003\u0002B:\u0005w\"B!!\u0006\u0003v!9!1\u0007\u001bA\u0002\t]\u0004#\u00021\u00038\te\u0004c\u00013\u0003|\u00119!Q\u0004\u001bC\u0002\t}S\u0003\u0002B@\u0005\u000f#b!!\u0006\u0003\u0002\n%\u0005b\u0002B\u001ak\u0001\u0007!1\u0011\t\u0006A\n]\"Q\u0011\t\u0004I\n\u001dEa\u0002B\u000fk\t\u0007!q\f\u0005\b\u0003G*\u0004\u0019AA\u000b\u00035\u0019wN\u001c;bS:\u001c8\u000b\\5dKV!!q\u0012BL)\u0011\tID!%\t\u000f\tMb\u00071\u0001\u0003\u0014B)\u0001Ma\u000e\u0003\u0016B\u0019AMa&\u0005\r\tuaG1\u0001h\u0003!\u0019wN\u001c;bS:\u001cX\u0003\u0002BO\u0005K#B!!\u000f\u0003 \"9!\u0011U\u001cA\u0002\t\r\u0016\u0001B3mK6\u00042\u0001\u001aBS\t\u001d\u00119k\u000eb\u0001\u0005?\u0012!!Q\u0019\u0002\u000bUt\u0017n\u001c8\u0016\r\t5&1\u0018BZ)\u0011\u0011yK!0\u0015\t\tE&Q\u0017\t\u0004I\nMFA\u0002B\u0004q\t\u0007q\rC\u0004\u0003\fa\u0002\u001dAa.\u0011\u0013\t=!QC6\u0003:\nE\u0006c\u00013\u0003<\u00129!Q\u0004\u001dC\u0002\t}\u0003b\u0002B\u001aq\u0001\u0007!q\u0018\t\u0006A\n]\"\u0011X\u0001\u0005I&4g-\u0006\u0003\u0003F\n5GcA6\u0003H\"9!1G\u001dA\u0002\t%\u0007#\u00021\u00038\t-\u0007c\u00013\u0003N\u00129!QD\u001dC\u0002\t}\u0013!C5oi\u0016\u00148/Z2u+\u0011\u0011\u0019Na7\u0015\u0007-\u0014)\u000eC\u0004\u00034i\u0002\rAa6\u0011\u000b\u0001\u00149D!7\u0011\u0007\u0011\u0014Y\u000eB\u0004\u0003\u001ei\u0012\rAa\u0018\u0002\u0013=\u001c7mQ8v]R\u001cX\u0003\u0002Bq\u0005W$BAa9\u0003nBA\u00111\u0013Bs\u0005S\f)\"\u0003\u0003\u0003h\u0006U%aA'baB\u0019AMa;\u0005\r\tu1H1\u0001h\u0011\u001d\u0011yo\u000fa\u0001\u0005c\f!a]9\u0011\u000b\u0001\f)A!;\u0002\u0011\u0011L7\u000f^5oGR\fQ\u0001]1uG\",bA!?\u0004\b\t}H\u0003\u0003B~\u0007\u0013\u0019Yaa\u0004\u0015\t\tu8\u0011\u0001\t\u0004I\n}HA\u0002B\u0004{\t\u0007q\rC\u0004\u0003\fu\u0002\u001daa\u0001\u0011\u0013\t=!QC6\u0004\u0006\tu\bc\u00013\u0004\b\u00119!QD\u001fC\u0002\t}\u0003bBA){\u0001\u0007\u0011Q\u0003\u0005\b\u0005kl\u0004\u0019AB\u0007!\u0015\u0001'qGB\u0003\u0011\u001d\u0019\t\"\u0010a\u0001\u0003+\t\u0001B]3qY\u0006\u001cW\rZ\u0001\bkB$\u0017\r^3e+\u0019\u00199b!\n\u0004\u001eQ11\u0011DB\u0014\u0007W!Baa\u0007\u0004 A\u0019Am!\b\u0005\r\t\u001daH1\u0001h\u0011\u001d\u0011YA\u0010a\u0002\u0007C\u0001\u0012Ba\u0004\u0003\u0016-\u001c\u0019ca\u0007\u0011\u0007\u0011\u001c)\u0003B\u0004\u0003\u001ey\u0012\rAa\u0018\t\u000f\r%b\b1\u0001\u0002\u0016\u0005)\u0011N\u001c3fq\"9!\u0011\u0015 A\u0002\r\r\u0012a\u0003\u0013qYV\u001cHeY8m_:,ba!\r\u0004@\r]B\u0003BB\u001a\u0007\u0003\"Ba!\u000e\u0004:A\u0019Ama\u000e\u0005\r\t\u001dqH1\u0001h\u0011\u001d\u0011Ya\u0010a\u0002\u0007w\u0001\u0012Ba\u0004\u0003\u0016-\u001cid!\u000e\u0011\u0007\u0011\u001cy\u0004B\u0004\u0003\u001e}\u0012\rAa\u0018\t\u000f\t\u0005v\b1\u0001\u0004>\u0005YAeY8m_:$\u0003\u000f\\;t+\u0019\u00199e!\u0016\u0004NQ!1\u0011JB,)\u0011\u0019Yea\u0014\u0011\u0007\u0011\u001ci\u0005\u0002\u0004\u0003\b\u0001\u0013\ra\u001a\u0005\b\u0005\u0017\u0001\u00059AB)!%\u0011yA!\u0006l\u0007'\u001aY\u0005E\u0002e\u0007+\"qA!\bA\u0005\u0004\u0011y\u0006C\u0004\u0003\"\u0002\u0003\raa\u0015\u0002\u000bA\fG\rV8\u0016\r\ru31NB2)\u0019\u0019yf!\u001c\u0004pQ!1\u0011MB3!\r!71\r\u0003\u0007\u0005\u000f\t%\u0019A4\t\u000f\t-\u0011\tq\u0001\u0004hAI!q\u0002B\u000bW\u000e%4\u0011\r\t\u0004I\u000e-Da\u0002B\u000f\u0003\n\u0007!q\f\u0005\b\u0003g\t\u0005\u0019AA\u000b\u0011\u001d\u0011\t+\u0011a\u0001\u0007S\n1bY8se\u0016\u001c\bo\u001c8egV!1QOBB)\u0011\u00199h!\"\u0015\t\u0005e2\u0011\u0010\u0005\b\u0003\u000f\u0012\u0005\u0019AB>!!a6QP2\u0004\u0002\u0006e\u0012bAB@-\nIa)\u001e8di&|gN\r\t\u0004I\u000e\rEA\u0002B\u000f\u0005\n\u0007q\rC\u0004\u00034\t\u0003\raa\"\u0011\u000b\u0001\u00149d!!\u0002\u0011M|'\u000f^,ji\"$2a[BG\u0011\u001d\u0019yi\u0011a\u0001\u0007#\u000b!\u0001\u001c;\u0011\u000fq\u001bihY2\u0002:\u000511o\u001c:u\u0005f,Baa&\u0004.R!1\u0011TBX)\rY71\u0014\u0005\b\u0007;#\u00059ABP\u0003\ry'\u000f\u001a\t\u0007\u0007C\u001b9ka+\u000e\u0005\r\r&bABS-\u0006!Q.\u0019;i\u0013\u0011\u0019Ika)\u0003\u0011=\u0013H-\u001a:j]\u001e\u00042\u0001ZBW\t\u0019\u0011i\u0002\u0012b\u0001O\"9!\u0011\u0005#A\u0002\rE\u0006C\u0002/\u0002L\r\u001cY+\u0001\u0004t_J$X\rZ\u000b\u0005\u0007o\u001by\fF\u0002l\u0007sCqa!(F\u0001\b\u0019Y\f\u0005\u0004\u0004\"\u000e\u001d6Q\u0018\t\u0004I\u000e}Fa\u0002B\u000f\u000b\n\u0007!qL\u0001\u0006i>\u001cV-]\u0001\bS:$\u0017nY3t+\t\u00199\r\u0005\u0003\u0004J\u000e=WBABf\u0015\r\u0019i\rV\u0001\nS6lW\u000f^1cY\u0016LAa!5\u0004L\n)!+\u00198hK\u0006!a/[3x+\t\u00199N\u0005\u0004\u0004Z\u000eu71\u001d\u0004\u0007\u00077D\u0005aa6\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\u0007q\u001by.C\u0002\u0004bZ\u0013a!\u00118z%\u00164\u0007#\u00021\u0004f\u000e\\\u0017bABt)\n91+Z9WS\u0016<HCBBr\u0007W\u001ci\u000fC\u0004\u0002R%\u0003\r!!\u0006\t\u000f\r=\u0018\n1\u0001\u0002\u0016\u0005)QO\u001c;jY\u0006AAo\\*ue&tw\r\u0006\u0002\u0004vB!1q\u001fC\u0003\u001d\u0011\u0019I\u0010\"\u0001\u0011\u0007\rmh+\u0004\u0002\u0004~*\u00191q -\u0002\rq\u0012xn\u001c;?\u0013\r!\u0019AV\u0001\u0007!J,G-\u001a4\n\t\u0011\u001dA\u0011\u0002\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0011\ra+A\u0004TKFd\u0015n[3\u0011\u0005\u0001d5c\u0001'\u0004^R\u0011AQB\u0001\u0010W6\u0004x\n\u001d;j[&TXmV8sIV!Aq\u0003C\u000f))!I\u0002b\b\u0005&\u0011%BQ\u0006\t\u0006A\u0006mG1\u0004\t\u0004I\u0012uAA\u0002B\u000f\u001d\n\u0007q\rC\u0004\u0005\"9\u0003\r\u0001b\t\u0002\u0003]\u0003R\u0001YA\u0003\t7Aq\u0001b\nO\u0001\u0004\t)\"\u0001\u0002oa!9A1\u0006(A\u0002\u0005U\u0011A\u000182\u0011\u001d!yC\u0014a\u0001\u0003s\tqAZ8so\u0006\u0014H-\u0001\u0007l[BTU/\u001c9UC\ndW-\u0006\u0003\u00056\u0011}BCBAO\to!\t\u0005C\u0004\u0005:=\u0003\r\u0001b\u000f\u0002\t]{\u0007\u000f\u001e\t\u0006A\u0006mGQ\b\t\u0004I\u0012}BA\u0002B\u000f\u001f\n\u0007q\rC\u0004\u0005D=\u0003\r!!\u0006\u0002\t]dWM\\\u0001\nW6\u00048+Z1sG\",B\u0001\"\u0013\u0005TQ\u0001\u0012Q\u0003C&\t+\"I\u0006\"\u0018\u0005`\u0011\u0005D1\r\u0005\b\t\u001b\u0002\u0006\u0019\u0001C(\u0003\u0005\u0019\u0006#\u00021\u0002\u0006\u0011E\u0003c\u00013\u0005T\u00111!Q\u0004)C\u0002\u001dDq\u0001b\u0016Q\u0001\u0004\t)\"\u0001\u0002na!9A1\f)A\u0002\u0005U\u0011AA72\u0011\u001d!\t\u0003\u0015a\u0001\t\u001fBq\u0001b\nQ\u0001\u0004\t)\u0002C\u0004\u0005,A\u0003\r!!\u0006\t\u000f\u0011=\u0002\u000b1\u0001\u0002:\u00059\u0011N\u001c3fq>3W\u0003\u0002C5\tg\"\u0002#!\u0006\u0005l\u0011UD\u0011\u0010C?\t\u0003#)\t\"#\t\u000f\u00115\u0014\u000b1\u0001\u0005p\u000511o\\;sG\u0016\u0004R\u0001YA\u0003\tc\u00022\u0001\u001aC:\t\u0019\u0011i\"\u0015b\u0001O\"9AqO)A\u0002\u0005U\u0011\u0001D:pkJ\u001cWm\u00144gg\u0016$\bb\u0002C>#\u0002\u0007\u0011QC\u0001\fg>,(oY3D_VtG\u000fC\u0004\u0005\u0000E\u0003\r\u0001b\u001c\u0002\rQ\f'oZ3u\u0011\u001d!\u0019)\u0015a\u0001\u0003+\tA\u0002^1sO\u0016$xJ\u001a4tKRDq\u0001b\"R\u0001\u0004\t)\"A\u0006uCJ<W\r^\"pk:$\bb\u0002CF#\u0002\u0007\u0011QC\u0001\nMJ|W.\u00138eKb\f1\u0002\\1ti&sG-\u001a=PMV!A\u0011\u0013CM)A\t)\u0002b%\u0005\u001c\u0012uEq\u0014CQ\tG#)\u000bC\u0004\u0005nI\u0003\r\u0001\"&\u0011\u000b\u0001\f)\u0001b&\u0011\u0007\u0011$I\n\u0002\u0004\u0003\u001eI\u0013\ra\u001a\u0005\b\to\u0012\u0006\u0019AA\u000b\u0011\u001d!YH\u0015a\u0001\u0003+Aq\u0001b S\u0001\u0004!)\nC\u0004\u0005\u0004J\u0003\r!!\u0006\t\u000f\u0011\u001d%\u000b1\u0001\u0002\u0016!9A1\u0012*A\u0002\u0005U\u0001")
public interface SeqLike<A, Repr>
extends IterableLike<A, Repr>,
GenSeqLike<A, Repr> {
    public static /* synthetic */ Seq thisCollection$(SeqLike $this) {
        return $this.thisCollection();
    }

    @Override
    default public Seq<A> thisCollection() {
        return (Seq)this;
    }

    public static /* synthetic */ Seq toCollection$(SeqLike $this, Object repr) {
        return $this.toCollection(repr);
    }

    @Override
    default public Seq<A> toCollection(Repr repr) {
        return (Seq)repr;
    }

    @Override
    public int length();

    @Override
    public A apply(int var1);

    public static /* synthetic */ Combiner parCombiner$(SeqLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<A, ParSeq<A>> parCombiner() {
        return ParSeq$.MODULE$.newCombiner();
    }

    public static /* synthetic */ int lengthCompare$(SeqLike $this, int len) {
        return $this.lengthCompare(len);
    }

    default public int lengthCompare(int len) {
        if (len < 0) {
            return 1;
        }
        int i = 0;
        Iterator it = this.iterator();
        while (it.hasNext()) {
            if (i == len) {
                if (it.hasNext()) {
                    return 1;
                }
                return 0;
            }
            it.next();
            ++i;
        }
        return i - len;
    }

    public static /* synthetic */ boolean isEmpty$(SeqLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return this.lengthCompare(0) == 0;
    }

    public static /* synthetic */ int size$(SeqLike $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        return this.length();
    }

    public static /* synthetic */ int segmentLength$(SeqLike $this, Function1 p, int from) {
        return $this.segmentLength(p, from);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public int segmentLength(Function1<A, Object> p, int from) {
        void var3_3;
        int i = 0;
        Iterator it = this.iterator().drop(from);
        while (it.hasNext() && BoxesRunTime.unboxToBoolean(p.apply(it.next()))) {
            ++i;
        }
        return (int)var3_3;
    }

    public static /* synthetic */ int indexWhere$(SeqLike $this, Function1 p, int from) {
        return $this.indexWhere(p, from);
    }

    @Override
    default public int indexWhere(Function1<A, Object> p, int from) {
        int i = package$.MODULE$.max(from, 0);
        Iterator it = this.iterator().drop(from);
        while (it.hasNext()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(it.next()))) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexWhere$(SeqLike $this, Function1 p, int end) {
        return $this.lastIndexWhere(p, end);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public int lastIndexWhere(Function1<A, Object> p, int end) {
        void var3_3;
        int i = this.length() - 1;
        Iterator<A> it = this.reverseIterator();
        while (it.hasNext()) {
            A elem = it.next();
            if (!(i > end || !BoxesRunTime.unboxToBoolean(p.apply(elem)))) break;
            --i;
        }
        return (int)var3_3;
    }

    public static /* synthetic */ Iterator permutations$(SeqLike $this) {
        return $this.permutations();
    }

    default public Iterator<Repr> permutations() {
        if (this.isEmpty()) {
            return Iterator$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{this.repr()}));
        }
        return new PermutationsItr();
    }

    public static /* synthetic */ Iterator combinations$(SeqLike $this, int n) {
        return $this.combinations(n);
    }

    default public Iterator<Repr> combinations(int n) {
        if (n < 0 || n > this.size()) {
            return Iterator$.MODULE$.empty();
        }
        return new CombinationsItr(this, n);
    }

    public static /* synthetic */ Object reverse$(SeqLike $this) {
        return $this.reverse();
    }

    @Override
    default public Repr reverse() {
        ObjectRef<Nil$> xs = ObjectRef.create(Nil$.MODULE$);
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            xs.elem = ((List)xs.elem).$colon$colon(x);
            return BoxedUnit.UNIT;
        });
        Builder b = this.newBuilder();
        b.sizeHint(this);
        List list = (List)xs.elem;
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Object a = foreach_these.head();
            b.$plus$eq(a);
            foreach_these = (List)foreach_these.tail();
        }
        return b.result();
    }

    public static /* synthetic */ Object reverseMap$(SeqLike $this, Function1 f, CanBuildFrom bf) {
        return $this.reverseMap(f, bf);
    }

    @Override
    default public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<Repr, B, That> bf) {
        ObjectRef<Nil$> xs = ObjectRef.create(Nil$.MODULE$);
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            xs.elem = ((List)xs.elem).$colon$colon(x);
            return BoxedUnit.UNIT;
        });
        Builder<B, That> b = bf.apply(this.repr());
        List list = (List)xs.elem;
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Object a = foreach_these.head();
            b.$plus$eq(f.apply(a));
            foreach_these = (List)foreach_these.tail();
        }
        return b.result();
    }

    public static /* synthetic */ Iterator reverseIterator$(SeqLike $this) {
        return $this.reverseIterator();
    }

    default public Iterator<A> reverseIterator() {
        return this.toCollection(this.reverse()).iterator();
    }

    public static /* synthetic */ boolean startsWith$(SeqLike $this, GenSeq that, int offset) {
        return $this.startsWith(that, offset);
    }

    @Override
    default public <B> boolean startsWith(GenSeq<B> that, int offset) {
        Iterator i = this.iterator().drop(offset);
        Iterator j = that.iterator();
        while (j.hasNext() && i.hasNext()) {
            if (BoxesRunTime.equals(i.next(), j.next())) continue;
            return false;
        }
        return !j.hasNext();
    }

    public static /* synthetic */ boolean endsWith$(SeqLike $this, GenSeq that) {
        return $this.endsWith(that);
    }

    @Override
    default public <B> boolean endsWith(GenSeq<B> that) {
        Iterator i = this.iterator().drop(this.length() - that.length());
        Iterator j = that.iterator();
        while (i.hasNext() && j.hasNext()) {
            if (BoxesRunTime.equals(i.next(), j.next())) continue;
            return false;
        }
        return !j.hasNext();
    }

    public static /* synthetic */ int indexOfSlice$(SeqLike $this, GenSeq that) {
        return $this.indexOfSlice(that);
    }

    default public <B> int indexOfSlice(GenSeq<B> that) {
        return this.indexOfSlice(that, 0);
    }

    public static /* synthetic */ int indexOfSlice$(SeqLike $this, GenSeq that, int from) {
        return $this.indexOfSlice(that, from);
    }

    default public <B> int indexOfSlice(GenSeq<B> that, int from) {
        if (this.hasDefiniteSize() && that.hasDefiniteSize()) {
            int l = this.length();
            int tl = that.length();
            int clippedFrom = package$.MODULE$.max(0, from);
            if (from > l) {
                return -1;
            }
            if (tl < 1) {
                return clippedFrom;
            }
            if (l < tl) {
                return -1;
            }
            return SeqLike$.MODULE$.scala$collection$SeqLike$$kmpSearch(this.thisCollection(), clippedFrom, l, that.seq(), 0, tl, true);
        }
        int i = from;
        Seq s = (Seq)this.thisCollection().drop(from);
        while (!s.isEmpty()) {
            if (s.startsWith(that)) {
                return i;
            }
            ++i;
            s = (Seq)s.tail();
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfSlice$(SeqLike $this, GenSeq that) {
        return $this.lastIndexOfSlice(that);
    }

    default public <B> int lastIndexOfSlice(GenSeq<B> that) {
        return this.lastIndexOfSlice(that, this.length());
    }

    public static /* synthetic */ int lastIndexOfSlice$(SeqLike $this, GenSeq that, int end) {
        return $this.lastIndexOfSlice(that, end);
    }

    default public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
        int l = this.length();
        int tl = that.length();
        int clippedL = package$.MODULE$.min(l - tl, end);
        if (end < 0) {
            return -1;
        }
        if (tl < 1) {
            return clippedL;
        }
        if (l < tl) {
            return -1;
        }
        return SeqLike$.MODULE$.scala$collection$SeqLike$$kmpSearch(this.thisCollection(), 0, clippedL + tl, that.seq(), 0, tl, false);
    }

    public static /* synthetic */ boolean containsSlice$(SeqLike $this, GenSeq that) {
        return $this.containsSlice(that);
    }

    default public <B> boolean containsSlice(GenSeq<B> that) {
        return this.indexOfSlice(that) != -1;
    }

    public static /* synthetic */ boolean contains$(SeqLike $this, Object elem) {
        return $this.contains(elem);
    }

    default public <A1> boolean contains(A1 elem) {
        return this.exists((Function1<Object, Object> & java.io.Serializable & Serializable)x$12 -> BoxesRunTime.boxToBoolean(SeqLike.$anonfun$contains$1(elem, x$12)));
    }

    public static /* synthetic */ Object union$(SeqLike $this, GenSeq that, CanBuildFrom bf) {
        return $this.union(that, bf);
    }

    @Override
    default public <B, That> That union(GenSeq<B> that, CanBuildFrom<Repr, B, That> bf) {
        return this.$plus$plus(that, bf);
    }

    public static /* synthetic */ Object diff$(SeqLike $this, GenSeq that) {
        return $this.diff(that);
    }

    @Override
    default public <B> Repr diff(GenSeq<B> that) {
        Map occ = this.occCounts(that.seq());
        Builder b = this.newBuilder();
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            int ox = BoxesRunTime.unboxToInt(occ.apply((Object)x));
            if (ox == 0) {
                return b.$plus$eq(x);
            }
            occ.update(x, BoxesRunTime.boxToInteger(ox - 1));
            return BoxedUnit.UNIT;
        });
        return b.result();
    }

    public static /* synthetic */ Object intersect$(SeqLike $this, GenSeq that) {
        return $this.intersect(that);
    }

    @Override
    default public <B> Repr intersect(GenSeq<B> that) {
        Map occ = this.occCounts(that.seq());
        Builder b = this.newBuilder();
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            SeqLike.$anonfun$intersect$1(occ, b, x);
            return BoxedUnit.UNIT;
        });
        return b.result();
    }

    /*
     * WARNING - void declaration
     */
    private <B> Map<B, Object> occCounts(Seq<B> sq) {
        void var2_2;
        HashMap occ = new HashMap<B, Object>(null){

            public int default(B k) {
                return 0;
            }
        };
        sq.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)y -> {
            occ.update(y, BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(occ.apply(y)) + 1));
            return BoxedUnit.UNIT;
        });
        return var2_2;
    }

    public static /* synthetic */ Object distinct$(SeqLike $this) {
        return $this.distinct();
    }

    @Override
    default public Repr distinct() {
        boolean isImmutable = this instanceof scala.collection.immutable.Seq;
        if (isImmutable && this.lengthCompare(1) <= 0) {
            return this.repr();
        }
        Builder b = this.newBuilder();
        HashSet seen = new HashSet();
        Iterator it = this.iterator();
        boolean different = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (seen.add(next)) {
                b.$plus$eq(next);
                continue;
            }
            different = true;
        }
        if (different || !isImmutable) {
            return b.result();
        }
        return this.repr();
    }

    public static /* synthetic */ Object patch$(SeqLike $this, int from, GenSeq patch, int replaced, CanBuildFrom bf) {
        return $this.patch(from, patch, replaced, bf);
    }

    @Override
    default public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<Repr, B, That> bf) {
        int i;
        Builder<B, That> b = bf.apply(this.repr());
        Iterator it = this.iterator();
        for (i = 0; i < from && it.hasNext(); ++i) {
            b.$plus$eq((B)it.next());
        }
        b.$plus$plus$eq(patch.seq());
        for (i = replaced; i > 0 && it.hasNext(); --i) {
            it.next();
        }
        while (it.hasNext()) {
            b.$plus$eq((B)it.next());
        }
        return b.result();
    }

    public static /* synthetic */ Object updated$(SeqLike $this, int index, Object elem, CanBuildFrom bf) {
        return $this.updated(index, elem, bf);
    }

    @Override
    default public <B, That> That updated(int index, B elem, CanBuildFrom<Repr, B, That> bf) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(index)).toString());
        }
        Builder<B, That> b = bf.apply(this.repr());
        Iterator it = this.iterator();
        for (int i = 0; i < index && it.hasNext(); ++i) {
            b.$plus$eq((B)it.next());
        }
        if (!it.hasNext()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(index)).toString());
        }
        b.$plus$eq(elem);
        it.next();
        while (it.hasNext()) {
            b.$plus$eq((B)it.next());
        }
        return b.result();
    }

    public static /* synthetic */ Object $plus$colon$(SeqLike $this, Object elem, CanBuildFrom bf) {
        return $this.$plus$colon(elem, bf);
    }

    @Override
    default public <B, That> That $plus$colon(B elem, CanBuildFrom<Repr, B, That> bf) {
        Builder<B, That> b = bf.apply(this.repr());
        b.$plus$eq(elem);
        b.$plus$plus$eq(this.thisCollection());
        return b.result();
    }

    public static /* synthetic */ Object $colon$plus$(SeqLike $this, Object elem, CanBuildFrom bf) {
        return $this.$colon$plus(elem, bf);
    }

    @Override
    default public <B, That> That $colon$plus(B elem, CanBuildFrom<Repr, B, That> bf) {
        Builder<B, That> b = bf.apply(this.repr());
        b.$plus$plus$eq(this.thisCollection());
        b.$plus$eq(elem);
        return b.result();
    }

    public static /* synthetic */ Object padTo$(SeqLike $this, int len, Object elem, CanBuildFrom bf) {
        return $this.padTo(len, elem, bf);
    }

    @Override
    default public <B, That> That padTo(int len, B elem, CanBuildFrom<Repr, B, That> bf) {
        Builder<B, That> b = bf.apply(this.repr());
        int L = this.length();
        b.sizeHint(package$.MODULE$.max(L, len));
        b.$plus$plus$eq(this.thisCollection());
        for (int diff = len - L; diff > 0; --diff) {
            b.$plus$eq(elem);
        }
        return b.result();
    }

    public static /* synthetic */ boolean corresponds$(SeqLike $this, GenSeq that, Function2 p) {
        return $this.corresponds(that, p);
    }

    @Override
    default public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        Iterator i = this.iterator();
        Iterator j = that.iterator();
        while (i.hasNext() && j.hasNext()) {
            if (BoxesRunTime.unboxToBoolean(p.apply(i.next(), j.next()))) continue;
            return false;
        }
        return !i.hasNext() && !j.hasNext();
    }

    public static /* synthetic */ Object sortWith$(SeqLike $this, Function2 lt) {
        return $this.sortWith(lt);
    }

    default public Repr sortWith(Function2<A, A, Object> lt) {
        if (Ordering$.MODULE$ == null) {
            throw null;
        }
        return this.sorted(new Ordering<T>(lt){
            private final Function2 cmp$2;

            public Some<Object> tryCompare(T x, T y) {
                return Ordering.tryCompare$(this, x, y);
            }

            public boolean equiv(T x, T y) {
                return Ordering.equiv$(this, x, y);
            }

            public T max(T x, T y) {
                return (T)Ordering.max$(this, x, y);
            }

            public T min(T x, T y) {
                return (T)Ordering.min$(this, x, y);
            }

            public Ordering<T> reverse() {
                return Ordering.reverse$(this);
            }

            public <U> Ordering<U> on(Function1<U, T> f) {
                return Ordering.on$(this, f);
            }

            public Ordering.Ops mkOrderingOps(T lhs) {
                return Ordering.mkOrderingOps$(this, lhs);
            }

            public int compare(T x, T y) {
                if (BoxesRunTime.unboxToBoolean(this.cmp$2.apply(x, y))) {
                    return -1;
                }
                if (BoxesRunTime.unboxToBoolean(this.cmp$2.apply(y, x))) {
                    return 1;
                }
                return 0;
            }

            public boolean lt(T x, T y) {
                return BoxesRunTime.unboxToBoolean(this.cmp$2.apply(x, y));
            }

            public boolean gt(T x, T y) {
                return BoxesRunTime.unboxToBoolean(this.cmp$2.apply(y, x));
            }

            public boolean gteq(T x, T y) {
                return !BoxesRunTime.unboxToBoolean(this.cmp$2.apply(x, y));
            }

            public boolean lteq(T x, T y) {
                return !BoxesRunTime.unboxToBoolean(this.cmp$2.apply(y, x));
            }
            {
                this.cmp$2 = cmp$2;
                PartialOrdering.$init$(this);
                Ordering.$init$(this);
            }
        });
    }

    public static /* synthetic */ Object sortBy$(SeqLike $this, Function1 f, Ordering ord) {
        return $this.sortBy(f, ord);
    }

    default public <B> Repr sortBy(Function1<A, B> f, Ordering<B> ord) {
        return this.sorted(ord.on(f));
    }

    public static /* synthetic */ Object sorted$(SeqLike $this, Ordering ord) {
        return $this.sorted(ord);
    }

    default public <B> Repr sorted(Ordering<B> ord) {
        int len = this.length();
        Builder b = this.newBuilder();
        if (len == 1) {
            b.$plus$plus$eq(this);
        } else if (len > 1) {
            b.sizeHint(len);
            Object[] arr = new Object[len];
            IntRef i = IntRef.create(0);
            this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                SeqLike.$anonfun$sorted$1(arr, i, x);
                return BoxedUnit.UNIT;
            });
            Arrays.sort(arr, ord);
            i.elem = 0;
            while (i.elem < arr.length) {
                b.$plus$eq(arr[i.elem]);
                ++i.elem;
            }
        }
        return b.result();
    }

    public static /* synthetic */ Seq toSeq$(SeqLike $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<A> toSeq() {
        return this.thisCollection();
    }

    public static /* synthetic */ Range indices$(SeqLike $this) {
        return $this.indices();
    }

    default public Range indices() {
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichInt$.MODULE$.until$extension0(n, this.length());
    }

    public static /* synthetic */ SeqView view$(SeqLike $this) {
        return $this.view();
    }

    @Override
    default public SeqView<A, Repr> view() {
        return new SeqView<A, Repr>(this){
            private Repr underlying;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqLike $outer;

            public <B> SeqViewLike.Transformed<B> newForced(Function0<GenSeq<B>> xs) {
                return SeqViewLike.newForced$(this, xs);
            }

            public <B> SeqViewLike.Transformed<B> newAppended(GenTraversable<B> that) {
                return SeqViewLike.newAppended$(this, that);
            }

            public <B> SeqViewLike.Transformed<B> newPrepended(GenTraversable<B> that) {
                return SeqViewLike.newPrepended$(this, that);
            }

            public <B> SeqViewLike.Transformed<B> newMapped(Function1<A, B> f) {
                return SeqViewLike.newMapped$(this, f);
            }

            public <B> SeqViewLike.Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
                return SeqViewLike.newFlatMapped$(this, f);
            }

            public SeqViewLike.Transformed<A> newFiltered(Function1<A, Object> p) {
                return SeqViewLike.newFiltered$(this, p);
            }

            public SeqViewLike.Transformed<A> newSliced(SliceInterval _endpoints) {
                return SeqViewLike.newSliced$(this, _endpoints);
            }

            public SeqViewLike.Transformed<A> newDroppedWhile(Function1<A, Object> p) {
                return SeqViewLike.newDroppedWhile$(this, p);
            }

            public SeqViewLike.Transformed<A> newTakenWhile(Function1<A, Object> p) {
                return SeqViewLike.newTakenWhile$(this, p);
            }

            public <B> SeqViewLike.Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
                return SeqViewLike.newZipped$(this, that);
            }

            public <A1, B> SeqViewLike.Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
                return SeqViewLike.newZippedAll$(this, that, _thisElem, _thatElem);
            }

            public SeqViewLike.Transformed<A> newReversed() {
                return SeqViewLike.newReversed$(this);
            }

            public <B> SeqViewLike.Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
                return SeqViewLike.newPatched$(this, _from, _patch, _replaced);
            }

            public SeqViewLike.Transformed<A> newTaken(int n) {
                return SeqViewLike.newTaken$(this, n);
            }

            public SeqViewLike.Transformed<A> newDropped(int n) {
                return SeqViewLike.newDropped$(this, n);
            }

            public SeqView<A, Repr> reverse() {
                return SeqViewLike.reverse$(this);
            }

            public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.patch$(this, from, patch, replaced, bf);
            }

            public <B, That> That padTo(int len, B elem, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.padTo$(this, len, elem, bf);
            }

            public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.reverseMap$(this, f, bf);
            }

            public <B, That> That updated(int index, B elem, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.updated$(this, index, elem, bf);
            }

            public <B, That> That $plus$colon(B elem, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.$plus$colon$(this, elem, bf);
            }

            public <B, That> That $colon$plus(B elem, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.$colon$plus$(this, elem, bf);
            }

            public <B, That> That union(GenSeq<B> that, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)SeqViewLike.union$(this, that, bf);
            }

            public <B> SeqView<A, Repr> diff(GenSeq<B> that) {
                return SeqViewLike.diff$(this, that);
            }

            public <B> SeqView<A, Repr> intersect(GenSeq<B> that) {
                return SeqViewLike.intersect$(this, that);
            }

            public <B> SeqView<A, Repr> sorted(Ordering<B> ord) {
                return SeqViewLike.sorted$(this, ord);
            }

            public SeqView<A, Repr> sortWith(Function2<A, A, Object> lt) {
                return SeqViewLike.sortWith$(this, lt);
            }

            public <B> SeqView<A, Repr> sortBy(Function1<A, B> f, Ordering<B> ord) {
                return SeqViewLike.sortBy$(this, f, ord);
            }

            public Iterator<SeqView<A, Repr>> combinations(int n) {
                return SeqViewLike.combinations$(this, n);
            }

            public Iterator<SeqView<A, Repr>> permutations() {
                return SeqViewLike.permutations$(this);
            }

            public SeqView<A, Repr> distinct() {
                return SeqViewLike.distinct$(this);
            }

            public String stringPrefix() {
                return SeqViewLike.stringPrefix$(this);
            }

            public IterableView drop(int n) {
                return IterableViewLike.drop$(this, n);
            }

            public IterableView take(int n) {
                return IterableViewLike.take$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<SeqView<A, Repr>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zip$(this, that, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<SeqView<A, Repr>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableViewLike.zipWithIndex$(this, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<SeqView<A, Repr>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public Iterator<SeqView<A, Repr>> grouped(int size) {
                return IterableViewLike.grouped$(this, size);
            }

            public Iterator<SeqView<A, Repr>> sliding(int size, int step) {
                return IterableViewLike.sliding$(this, size, step);
            }

            public Iterator<SeqView<A, Repr>> sliding(int size) {
                return IterableViewLike.sliding$(this, size);
            }

            public IterableView dropRight(int n) {
                return IterableViewLike.dropRight$(this, n);
            }

            public IterableView takeRight(int n) {
                return IterableViewLike.takeRight$(this, n);
            }

            public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
                return (TraversableView)TraversableLike.tail$(this);
            }

            public String viewIdentifier() {
                return TraversableViewLike.viewIdentifier$(this);
            }

            public String viewIdString() {
                return TraversableViewLike.viewIdString$(this);
            }

            public String viewToString() {
                return TraversableViewLike.viewToString$(this);
            }

            public Builder<A, SeqView<A, Repr>> newBuilder() {
                return TraversableViewLike.newBuilder$(this);
            }

            public <B, That> That force(CanBuildFrom<Repr, B, That> bf) {
                return (That)TraversableViewLike.force$(this, bf);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.map$(this, f, bf);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.collect$(this, pf, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.flatMap$(this, f, bf);
            }

            public <B> TraversableViewLike.Transformed<B> flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
                return TraversableViewLike.flatten$(this, asTraversable);
            }

            public TraversableView filter(Function1 p) {
                return TraversableViewLike.filter$(this, p);
            }

            public TraversableView withFilter(Function1 p) {
                return TraversableViewLike.withFilter$(this, p);
            }

            public Tuple2<SeqView<A, Repr>, SeqView<A, Repr>> partition(Function1<A, Object> p) {
                return TraversableViewLike.partition$(this, p);
            }

            public TraversableView init() {
                return TraversableViewLike.init$(this);
            }

            public TraversableView slice(int from, int until) {
                return TraversableViewLike.slice$(this, from, until);
            }

            public TraversableView dropWhile(Function1 p) {
                return TraversableViewLike.dropWhile$(this, p);
            }

            public TraversableView takeWhile(Function1 p) {
                return TraversableViewLike.takeWhile$(this, p);
            }

            public Tuple2<SeqView<A, Repr>, SeqView<A, Repr>> span(Function1<A, Object> p) {
                return TraversableViewLike.span$(this, p);
            }

            public Tuple2<SeqView<A, Repr>, SeqView<A, Repr>> splitAt(int n) {
                return TraversableViewLike.splitAt$(this, n);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<SeqView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanRight$(this, z, op, bf);
            }

            public <K> scala.collection.immutable.Map<K, SeqView<A, Repr>> groupBy(Function1<A, K> f) {
                return TraversableViewLike.groupBy$(this, f);
            }

            public <A1, A2> Tuple2<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return TraversableViewLike.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>, TraversableViewLike.Transformed<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
                return TraversableViewLike.unzip3$(this, asTriple);
            }

            public TraversableView filterNot(Function1 p) {
                return TraversableViewLike.filterNot$(this, p);
            }

            public Iterator<SeqView<A, Repr>> inits() {
                return TraversableViewLike.inits$(this);
            }

            public Iterator<SeqView<A, Repr>> tails() {
                return TraversableViewLike.tails$(this);
            }

            public TraversableView tail() {
                return TraversableViewLike.tail$(this);
            }

            public String toString() {
                return TraversableViewLike.toString$(this);
            }

            public Seq<A> thisSeq() {
                return ViewMkString.thisSeq$(this);
            }

            public String mkString() {
                return ViewMkString.mkString$(this);
            }

            public String mkString(String sep) {
                return ViewMkString.mkString$(this, sep);
            }

            public String mkString(String start, String sep, String end) {
                return ViewMkString.mkString$(this, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return ViewMkString.addString$(this, b, start, sep, end);
            }

            public GenericCompanion<Seq> companion() {
                return Seq.companion$(this);
            }

            public Seq<A> seq() {
                return Seq.seq$(this);
            }

            public Seq<A> thisCollection() {
                return SeqLike.thisCollection$(this);
            }

            public Seq toCollection(Object repr) {
                return SeqLike.toCollection$(this, repr);
            }

            public Combiner<A, ParSeq<A>> parCombiner() {
                return SeqLike.parCombiner$(this);
            }

            public int lengthCompare(int len) {
                return SeqLike.lengthCompare$(this, len);
            }

            public boolean isEmpty() {
                return SeqLike.isEmpty$(this);
            }

            public int size() {
                return SeqLike.size$(this);
            }

            public int segmentLength(Function1<A, Object> p, int from) {
                return SeqLike.segmentLength$(this, p, from);
            }

            public int indexWhere(Function1<A, Object> p, int from) {
                return SeqLike.indexWhere$(this, p, from);
            }

            public int lastIndexWhere(Function1<A, Object> p, int end) {
                return SeqLike.lastIndexWhere$(this, p, end);
            }

            public Iterator<A> reverseIterator() {
                return SeqLike.reverseIterator$(this);
            }

            public <B> boolean startsWith(GenSeq<B> that, int offset) {
                return SeqLike.startsWith$(this, that, offset);
            }

            public <B> boolean endsWith(GenSeq<B> that) {
                return SeqLike.endsWith$(this, that);
            }

            public <B> int indexOfSlice(GenSeq<B> that) {
                return SeqLike.indexOfSlice$(this, that);
            }

            public <B> int indexOfSlice(GenSeq<B> that, int from) {
                return SeqLike.indexOfSlice$(this, that, from);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that) {
                return SeqLike.lastIndexOfSlice$(this, that);
            }

            public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
                return SeqLike.lastIndexOfSlice$(this, that, end);
            }

            public <B> boolean containsSlice(GenSeq<B> that) {
                return SeqLike.containsSlice$(this, that);
            }

            public <A1> boolean contains(A1 elem) {
                return SeqLike.contains$(this, elem);
            }

            public <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
                return SeqLike.corresponds$(this, that, p);
            }

            public Seq<A> toSeq() {
                return SeqLike.toSeq$(this);
            }

            public Range indices() {
                return SeqLike.indices$(this);
            }

            public SeqView<A, SeqView<A, Repr>> view() {
                return SeqLike.view$(this);
            }

            public SeqView<A, SeqView<A, Repr>> view(int from, int until) {
                return SeqLike.view$(this, from, until);
            }

            public boolean isDefinedAt(int idx) {
                return GenSeqLike.isDefinedAt$(this, idx);
            }

            public int prefixLength(Function1<A, Object> p) {
                return GenSeqLike.prefixLength$(this, p);
            }

            public int indexWhere(Function1<A, Object> p) {
                return GenSeqLike.indexWhere$(this, p);
            }

            public <B> int indexOf(B elem) {
                return GenSeqLike.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return GenSeqLike.indexOf$(this, elem, from);
            }

            public <B> int lastIndexOf(B elem) {
                return GenSeqLike.lastIndexOf$(this, elem);
            }

            public <B> int lastIndexOf(B elem, int end) {
                return GenSeqLike.lastIndexOf$(this, elem, end);
            }

            public int lastIndexWhere(Function1<A, Object> p) {
                return GenSeqLike.lastIndexWhere$(this, p);
            }

            public <B> boolean startsWith(GenSeq<B> that) {
                return GenSeqLike.startsWith$(this, that);
            }

            public int hashCode() {
                return GenSeqLike.hashCode$(this);
            }

            public boolean equals(Object that) {
                return GenSeqLike.equals$(this, that);
            }

            public <U> void foreach(Function1<A, U> f) {
                IterableLike.foreach$(this, f);
            }

            public boolean forall(Function1<A, Object> p) {
                return IterableLike.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return IterableLike.exists$(this, p);
            }

            public Option<A> find(Function1<A, Object> p) {
                return IterableLike.find$(this, p);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)IterableLike.foldRight$(this, z, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)IterableLike.reduceRight$(this, op);
            }

            public Iterable<A> toIterable() {
                return IterableLike.toIterable$(this);
            }

            public Iterator<A> toIterator() {
                return IterableLike.toIterator$(this);
            }

            public A head() {
                return (A)IterableLike.head$(this);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                IterableLike.copyToArray$(this, xs, start, len);
            }

            public <B> boolean sameElements(GenIterable<B> that) {
                return IterableLike.sameElements$(this, that);
            }

            public Stream<A> toStream() {
                return IterableLike.toStream$(this);
            }

            public boolean canEqual(Object that) {
                return IterableLike.canEqual$(this, that);
            }

            public <B> Builder<B, Seq<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public Object repr() {
                return TraversableLike.repr$(this);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableLike.hasDefiniteSize$(this);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<SeqView<A, Repr>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public Option<A> headOption() {
                return TraversableLike.headOption$(this);
            }

            public A last() {
                return (A)TraversableLike.last$(this);
            }

            public Option<A> lastOption() {
                return TraversableLike.lastOption$(this);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public Traversable<A> toTraversable() {
                return TraversableLike.toTraversable$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<A, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
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

            public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableOnce.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableOnce.max$(this, cmp);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
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

            public List<A> toList() {
                return TraversableOnce.toList$(this);
            }

            public scala.collection.immutable.IndexedSeq<A> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
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

            public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                return PartialFunction.orElse$(this, that);
            }

            public <C> PartialFunction<Object, C> andThen(Function1<A, C> k) {
                return PartialFunction.andThen$(this, k);
            }

            public Function1<Object, Option<A>> lift() {
                return PartialFunction.lift$(this);
            }

            public Object applyOrElse(Object x, Function1 function1) {
                return PartialFunction.applyOrElse$(this, x, function1);
            }

            public <U> Function1<Object, Object> runWith(Function1<A, U> action) {
                return PartialFunction.runWith$(this, action);
            }

            public boolean apply$mcZD$sp(double v1) {
                return Function1.apply$mcZD$sp$(this, v1);
            }

            public double apply$mcDD$sp(double v1) {
                return Function1.apply$mcDD$sp$(this, v1);
            }

            public float apply$mcFD$sp(double v1) {
                return Function1.apply$mcFD$sp$(this, v1);
            }

            public int apply$mcID$sp(double v1) {
                return Function1.apply$mcID$sp$(this, v1);
            }

            public long apply$mcJD$sp(double v1) {
                return Function1.apply$mcJD$sp$(this, v1);
            }

            public void apply$mcVD$sp(double v1) {
                Function1.apply$mcVD$sp$(this, v1);
            }

            public boolean apply$mcZF$sp(float v1) {
                return Function1.apply$mcZF$sp$(this, v1);
            }

            public double apply$mcDF$sp(float v1) {
                return Function1.apply$mcDF$sp$(this, v1);
            }

            public float apply$mcFF$sp(float v1) {
                return Function1.apply$mcFF$sp$(this, v1);
            }

            public int apply$mcIF$sp(float v1) {
                return Function1.apply$mcIF$sp$(this, v1);
            }

            public long apply$mcJF$sp(float v1) {
                return Function1.apply$mcJF$sp$(this, v1);
            }

            public void apply$mcVF$sp(float v1) {
                Function1.apply$mcVF$sp$(this, v1);
            }

            public boolean apply$mcZI$sp(int v1) {
                return Function1.apply$mcZI$sp$(this, v1);
            }

            public double apply$mcDI$sp(int v1) {
                return Function1.apply$mcDI$sp$(this, v1);
            }

            public float apply$mcFI$sp(int v1) {
                return Function1.apply$mcFI$sp$(this, v1);
            }

            public int apply$mcII$sp(int v1) {
                return Function1.apply$mcII$sp$(this, v1);
            }

            public long apply$mcJI$sp(int v1) {
                return Function1.apply$mcJI$sp$(this, v1);
            }

            public void apply$mcVI$sp(int v1) {
                Function1.apply$mcVI$sp$(this, v1);
            }

            public boolean apply$mcZJ$sp(long v1) {
                return Function1.apply$mcZJ$sp$(this, v1);
            }

            public double apply$mcDJ$sp(long v1) {
                return Function1.apply$mcDJ$sp$(this, v1);
            }

            public float apply$mcFJ$sp(long v1) {
                return Function1.apply$mcFJ$sp$(this, v1);
            }

            public int apply$mcIJ$sp(long v1) {
                return Function1.apply$mcIJ$sp$(this, v1);
            }

            public long apply$mcJJ$sp(long v1) {
                return Function1.apply$mcJJ$sp$(this, v1);
            }

            public void apply$mcVJ$sp(long v1) {
                Function1.apply$mcVJ$sp$(this, v1);
            }

            public <A> Function1<A, A> compose(Function1<A, Object> g) {
                return Function1.compose$(this, g);
            }

            private Repr underlying$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.underlying = this.$outer.repr();
                        this.bitmap$0 = true;
                    }
                }
                return this.underlying;
            }

            public Repr underlying() {
                if (!this.bitmap$0) {
                    return this.underlying$lzycompute();
                }
                return this.underlying;
            }

            public Iterator<A> iterator() {
                return this.$outer.iterator();
            }

            public int length() {
                return this.$outer.length();
            }

            public A apply(int idx) {
                return this.$outer.apply(idx);
            }
            {
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
                ViewMkString.$init$(this);
                TraversableViewLike.$init$(this);
                IterableViewLike.$init$(this);
                SeqViewLike.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableViewLike scala.collection.Seq ), $anonfun$sortBy$1(scala.collection.SeqViewLike scala.Function1 scala.math.Ordering ), $anonfun$sortWith$1(scala.collection.SeqViewLike scala.Function2 )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ SeqView view$(SeqLike $this, int from, int until) {
        return $this.view(from, until);
    }

    @Override
    default public SeqView<A, Repr> view(int from, int until) {
        return (SeqView)this.view().slice(from, until);
    }

    public static /* synthetic */ String toString$(SeqLike $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        return TraversableLike.toString$(this);
    }

    public static /* synthetic */ boolean $anonfun$contains$1(Object elem$1, Object x$12) {
        return BoxesRunTime.equals(x$12, elem$1);
    }

    public static /* synthetic */ void $anonfun$intersect$1(Map occ$2, Builder b$4, Object x) {
        int ox = BoxesRunTime.unboxToInt(occ$2.apply(x));
        if (ox > 0) {
            b$4.$plus$eq(x);
            occ$2.update(x, BoxesRunTime.boxToInteger(ox - 1));
        }
    }

    public static /* synthetic */ void $anonfun$sorted$1(Object[] arr$1, IntRef i$1, Object x) {
        arr$1[i$1.elem] = x;
        ++i$1.elem;
    }

    public static void $init$(SeqLike $this) {
    }

    public class CombinationsItr
    extends AbstractIterator<Repr> {
        private final int n;
        private final /* synthetic */ Tuple3 x$4;
        private final IndexedSeq<A> elms;
        private final int[] cnts;
        private final int[] nums;
        private final int[] offs;
        private boolean _hasNext;
        public final /* synthetic */ SeqLike $outer;

        private IndexedSeq<A> elms() {
            return this.elms;
        }

        private int[] cnts() {
            return this.cnts;
        }

        private int[] nums() {
            return this.nums;
        }

        private int[] offs() {
            return this.offs;
        }

        private boolean _hasNext() {
            return this._hasNext;
        }

        private void _hasNext_$eq(boolean x$1) {
            this._hasNext = x$1;
        }

        @Override
        public boolean hasNext() {
            return this._hasNext();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Repr next() {
            void var2_5;
            int idx;
            if (!this.hasNext()) {
                Iterator$.MODULE$.empty().next();
            }
            Builder buf = this.scala$collection$SeqLike$CombinationsItr$$$outer().newBuilder();
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Range range = RichInt$.MODULE$.until$extension0(n, this.nums().length);
            if (range == null) {
                throw null;
            }
            Range foreach$mVc$sp_this = range;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    CombinationsItr.$anonfun$next$1(this, buf, foreach$mVc$sp_i);
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
            }
            Object res = buf.result();
            for (idx = this.nums().length - 1; idx >= 0 && this.nums()[idx] == this.cnts()[idx]; --idx) {
            }
            int n2 = IndexedSeqOptimized.lastIndexWhere$(new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(this.nums())), (JFunction1$mcZI$sp & Serializable)x$7 -> x$7 > 0, idx - 1);
            idx = n2;
            if (idx < 0) {
                this._hasNext_$eq(false);
            } else {
                IntRef sum = IntRef.create(1);
                for (int i = idx + 1; i < this.nums().length; ++i) {
                    sum.elem += this.nums()[i];
                }
                this.nums()[n2] = this.nums()[n2] - 1;
                int n3 = idx + 1;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                Range range2 = RichInt$.MODULE$.until$extension0(n3, this.nums().length);
                if (range2 == null) {
                    throw null;
                }
                Range foreach$mVc$sp_this2 = range2;
                if (!foreach$mVc$sp_this2.isEmpty()) {
                    int foreach$mVc$sp_i = foreach$mVc$sp_this2.start();
                    while (true) {
                        CombinationsItr.$anonfun$next$4(this, sum, foreach$mVc$sp_i);
                        if (foreach$mVc$sp_i == foreach$mVc$sp_this2.scala$collection$immutable$Range$$lastElement()) break;
                        foreach$mVc$sp_i += foreach$mVc$sp_this2.step();
                    }
                }
            }
            return var2_5;
        }

        private Tuple3<IndexedSeq<A>, int[], int[]> init() {
            HashMap m = (HashMap)HashMap$.MODULE$.apply(Nil$.MODULE$);
            Tuple2 tuple2 = ((GenericTraversableTemplate)((SeqLike)this.scala$collection$SeqLike$CombinationsItr$$$outer().thisCollection().map((Function1<Object, Tuple2> & java.io.Serializable & Serializable)e -> new Tuple2(e, m.getOrElseUpdate(e, (JFunction0$mcI$sp & Serializable)() -> m.size())), Seq$.MODULE$.canBuildFrom())).sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$8 -> BoxesRunTime.boxToInteger(x$8._2$mcI$sp()), Ordering$Int$.MODULE$)).unzip(Predef$.MODULE$.$conforms());
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Seq seq = (Seq)tuple2._1();
            Seq seq2 = (Seq)tuple2._2();
            Seq es = seq;
            Seq is = seq2;
            int[] cs = new int[m.size()];
            is.foreach((JFunction1$mcVI$sp & Serializable)i -> {
                cs$1[i] = cs[i] + 1;
            });
            int[] ns = new int[cs.length];
            IntRef r = IntRef.create(this.n);
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Range range = RichInt$.MODULE$.until$extension0(n, ns.length);
            if (range == null) {
                throw null;
            }
            Range foreach$mVc$sp_this = range;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    CombinationsItr.$anonfun$init$8(ns, r, cs, foreach$mVc$sp_i);
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
            }
            return new Tuple3(es.toIndexedSeq(), cs, ns);
        }

        public /* synthetic */ SeqLike scala$collection$SeqLike$CombinationsItr$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ void $anonfun$next$1(CombinationsItr $this, Builder buf$1, int k) {
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            RichInt$.MODULE$.until$extension0(n, $this.nums()[k]).foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)(Object j) -> buf$1.$plus$eq($this.elms().apply($this.offs()[k] + BoxesRunTime.unboxToInt(j))));
        }

        public static final /* synthetic */ void $anonfun$next$4(CombinationsItr $this, IntRef sum$1, int k) {
            int n = sum$1.elem;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            $this.nums()[k] = RichInt$.MODULE$.min$extension(n, $this.cnts()[k]);
            sum$1.elem -= $this.nums()[k];
        }

        public static final /* synthetic */ void $anonfun$init$8(int[] ns$1, IntRef r$1, int[] cs$1, int k) {
            int n = r$1.elem;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            ns$1[k] = RichInt$.MODULE$.min$extension(n, cs$1[k]);
            r$1.elem -= ns$1[k];
        }

        public CombinationsItr(SeqLike $outer, int n) {
            this.n = n;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Tuple3 tuple3 = this.init();
            if (tuple3 == null) {
                throw new MatchError((Object)null);
            }
            IndexedSeq elms = tuple3._1();
            int[] cnts = tuple3._2();
            int[] nums = tuple3._3();
            Tuple3 tuple32 = new Tuple3(elms, cnts, nums);
            this.x$4 = tuple32;
            this.elms = (IndexedSeq)this.x$4._1();
            this.cnts = (int[])this.x$4._2();
            this.nums = (int[])this.x$4._3();
            this.offs = (int[])TraversableLike.scanLeft$(new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(this.cnts())), BoxesRunTime.boxToInteger(0), (JFunction2$mcIII$sp & Serializable)(x$5, x$6) -> x$5 + x$6, Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Int()));
            this._hasNext = true;
        }
    }

    public class PermutationsItr
    extends AbstractIterator<Repr> {
        private final /* synthetic */ Tuple2 x$1;
        private final Buffer<A> elms;
        private final int[] idxs;
        private boolean _hasNext;

        private boolean _hasNext() {
            return this._hasNext;
        }

        private void _hasNext_$eq(boolean x$1) {
            this._hasNext = x$1;
        }

        @Override
        public boolean hasNext() {
            return this._hasNext();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Repr next() {
            void var2_2;
            int i;
            if (!this.hasNext()) {
                Iterator$.MODULE$.empty().next();
            }
            Growable forcedElms = new ArrayBuffer(this.elms.size()).$plus$plus$eq((TraversableOnce)this.elms);
            Object result2 = ((Builder)this.scala$collection$SeqLike$PermutationsItr$$$outer().newBuilder().$plus$plus$eq(forcedElms)).result();
            for (i = this.idxs.length - 2; i >= 0 && this.idxs[i] >= this.idxs[i + 1]; --i) {
            }
            if (i < 0) {
                this._hasNext_$eq(false);
            } else {
                int j = this.idxs.length - 1;
                while (this.idxs[j] <= this.idxs[i]) {
                    --j;
                }
                this.swap(i, j);
                int len = (this.idxs.length - i) / 2;
                for (int k = 1; k <= len; ++k) {
                    this.swap(i + k, this.idxs.length - k);
                }
            }
            return var2_2;
        }

        private void swap(int i, int j) {
            int tmpI = this.idxs[i];
            this.idxs[i] = this.idxs[j];
            this.idxs[j] = tmpI;
            Object tmpE = this.elms.apply(i);
            this.elms.update(i, this.elms.apply(j));
            this.elms.update(j, tmpE);
        }

        private Tuple2<Buffer<A>, int[]> init() {
            HashMap m = (HashMap)HashMap$.MODULE$.apply(Nil$.MODULE$);
            Tuple2 tuple2 = ((GenericTraversableTemplate)((SeqLike)this.scala$collection$SeqLike$PermutationsItr$$$outer().thisCollection().map((Function1<Object, Tuple2> & java.io.Serializable & Serializable)e -> new Tuple2(e, m.getOrElseUpdate(e, (JFunction0$mcI$sp & Serializable)() -> m.size())), Seq$.MODULE$.canBuildFrom())).sortBy((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToInteger(x$2._2$mcI$sp()), Ordering$Int$.MODULE$)).unzip(Predef$.MODULE$.$conforms());
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Seq seq = (Seq)tuple2._1();
            Seq seq2 = (Seq)tuple2._2();
            Seq es = seq;
            Seq is = seq2;
            return new Tuple2(es.toBuffer(), is.toArray(ClassTag$.MODULE$.Int()));
        }

        public /* synthetic */ SeqLike scala$collection$SeqLike$PermutationsItr$$$outer() {
            return SeqLike.this;
        }

        public PermutationsItr() {
            if (SeqLike.this == null) {
                throw null;
            }
            Tuple2 tuple2 = this.init();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            Buffer elms = tuple2._1();
            int[] idxs = tuple2._2();
            Tuple2 tuple22 = new Tuple2(elms, idxs);
            this.x$1 = tuple22;
            this.elms = (Buffer)this.x$1._1();
            this.idxs = (int[])this.x$1._2();
            this._hasNext = true;
        }
    }
}

