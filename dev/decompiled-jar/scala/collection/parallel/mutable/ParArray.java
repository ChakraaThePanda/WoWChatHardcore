/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.BufferedIterator;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.CanCombineFrom;
import scala.collection.generic.DelegatedSignalling;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Signalling;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArraySeq;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.AugmentedIterableIterator;
import scala.collection.parallel.AugmentedSeqIterator;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.CombinerFactory;
import scala.collection.parallel.IterableSplitter;
import scala.collection.parallel.ParIterableLike;
import scala.collection.parallel.ParIterableLike$ScanLeaf$;
import scala.collection.parallel.ParIterableLike$ScanNode$;
import scala.collection.parallel.ParSeq;
import scala.collection.parallel.ParSeqLike;
import scala.collection.parallel.PreciseSplitter;
import scala.collection.parallel.RemainsIterator;
import scala.collection.parallel.SeqSplitter;
import scala.collection.parallel.Task;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.immutable.ParMap;
import scala.collection.parallel.immutable.ParSet;
import scala.collection.parallel.mutable.ExposedArrayBuffer;
import scala.collection.parallel.mutable.ParArray$;
import scala.collection.parallel.mutable.ParArray$ParArrayIterator$;
import scala.collection.parallel.mutable.ParIterable;
import scala.collection.parallel.mutable.ResizableParArrayCombiner;
import scala.collection.parallel.mutable.UnrolledParArrayCombiner;
import scala.collection.parallel.package$;
import scala.math.Integral;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.runtime.java8.JFunction2$mcIII$sp;

@ScalaSignature(bytes="\u0006\u0001\u001dmg!\u0002@\u0000\u0001\u0005E\u0001BCA2\u0001\t\u0015\r\u0011\"\u0001\u0002f!Q\u0011q\r\u0001\u0003\u0002\u0003\u0006I!a\u0015\t\u0011\u0005%\u0004\u0001\"\u0001\u0000\u0003WB\u0011\"a\u001c\u0001\u0001\u0004%I!!\u001d\t\u0013\u0005e\u0004\u00011A\u0005\n\u0005m\u0004\u0002CAD\u0001\u0001\u0006K!a\u001d\t\u000f\u0005E\u0005\u0001\"\u0011\u0002\u0014\"9\u0011\u0011\u000e\u0001\u0005\u0002\u0005\u001d\u0006bBAZ\u0001\u0011\u0005\u0011Q\u0017\u0005\b\u0003w\u0003A\u0011AA_\u0011\u001d\t)\r\u0001C\u0001\u0003\u000fDq!!3\u0001\t\u0003\n)\u0007C\u0005\u0002L\u0002!\t\"a\u0001\u0002N\u001a1\u00111\u001b\u0001\u0001\u0003+D!\"!/\u000f\u0005\u0003\u0007I\u0011AAd\u0011)\tiN\u0004BA\u0002\u0013\u0005\u0011q\u001c\u0005\u000b\u0003Gt!\u0011!Q!\n\u00055\u0006BCAs\u001d\t\u0015\r\u0011\"\u0001\u0002H\"Q\u0011q\u001d\b\u0003\u0002\u0003\u0006I!!,\t\u0015\u0005%hB!b\u0001\n\u0003\t\t\b\u0003\u0006\u0002l:\u0011\t\u0011)A\u0005\u0003gBq!!\u001b\u000f\t\u0003\ti\u000fC\u0004\u0002v:!\t!a>\t\u000f\u0005}h\u0002\"\u0001\u0003\u0002!9!1\u0001\b\u0005\u0002\u0005\u001d\u0007b\u0002B\u0003\u001d\u0011\u0005\u0011Q\u001a\u0005\b\u0005\u000fqA\u0011\u0001B\u0005\u0011\u001d\u0011\u0019C\u0004C!\u0005KAqAa\n\u000f\t\u0003\u0012I\u0003C\u0004\u0003<9!\tE!\u0010\t\u000f\tEc\u0002\"\u0003\u0003T!9!1\u000e\b\u0005B\t5\u0004b\u0002B;\u001d\u0011%!q\u000f\u0005\b\u0005\u0003sA\u0011\tBB\u0011\u001d\u0011iJ\u0004C\u0005\u0005?CqA!-\u000f\t\u0003\u0012\u0019\fC\u0004\u0003F:!\tEa2\t\u000f\t\u0015h\u0002\"\u0011\u0003h\"9!\u0011 \b\u0005\n\tm\bbBB\t\u001d\u0011\u000531\u0003\u0005\b\u0007?qA\u0011BB\u0011\u0011\u001d\u00199D\u0004C!\u0007sAqa!\u0010\u000f\t\u0013\u0019y\u0004C\u0004\u0004N9!\tea\u0014\t\u000f\rMc\u0002\"\u0003\u0004V!91q\f\b\u0005B\r\u0005\u0004bBB6\u001d\u0011%1Q\u000e\u0005\b\u0007orA\u0011IB=\u0011\u001d\u0019yH\u0004C!\u0007\u0003Cqaa%\u000f\t\u0003\u001a)\nC\u0004\u0004\u001c:!Ia!(\t\u000f\r%f\u0002\"\u0011\u0004,\"91q\u0016\b\u0005\n\rE\u0006bBB^\u001d\u0011\u00053Q\u0018\u0005\b\u0007\u0003tA\u0011BBb\u0011\u001d\u0019iM\u0004C!\u0007\u001fDqaa9\u000f\t\u0003\u001a)\u000fC\u0004\u0005\u00029!I\u0001b\u0001\t\u000f\u0011\u0005b\u0002\"\u0011\u0005$!9AQ\b\b\u0005\n\u0011}\u0002b\u0002C-\u001d\u0011\u0005C1\f\u0005\b\torA\u0011\tC=\u0011\u001d!iI\u0004C\u0005\t\u001fCq\u0001b*\u000f\t\u0003\"I\u000bC\u0004\u0005<:!I\u0001\"0\t\u000f\u0011Ug\u0002\"\u0011\u0005X\"9A\u0011\u001f\b\u0005\n\u0011M\bbBC\u0006\u001d\u0011\u0005SQ\u0002\u0005\b\u000bWqA\u0011BC\u0017\u0011\u001d)9E\u0004C!\u000b\u0013Bq!b\u0017\u000f\t\u0003*i\u0006C\u0004\u0006p9!\t%\"\u001d\t\u000f\u0015\u0005e\u0002\"\u0003\u0006\u0004\"9Qq\u0013\b\u0005B\u0015e\u0005bBC\\\u001d\u0011EQ\u0011\u0018\u0005\u000f\u000b/t\u0001\u0013aA\u0001\u0002\u0013%Q\u0011\\Cu\u000f%)y\u000fAA\u0001\u0012\u0003)\tPB\u0005\u0002T\u0002\t\t\u0011#\u0001\u0006t\"9\u0011\u0011\u000e(\u0005\u0002\u0015U\b\"CC|\u001dF\u0005I\u0011AC}\u0011%1yATI\u0001\n\u0003)I\u0010C\u0005\u0007\u00129\u000b\n\u0011\"\u0001\u0007\u0014!9aq\u0003\u0001\u0005\n\u0019e\u0001b\u0002D\u0016\u0001\u0011\u0005cQ\u0006\u0005\b\r\u0013\u0002A\u0011\tD&\r\u001919\u0007\u0001\u0001\u0007j!Qa\u0011\u0010,\u0003\u0002\u0003\u0006IAb\u001f\t\u0015\tmeK!A!\u0002\u00131)\b\u0003\u0006\u0003\u0012Z\u0013\t\u0011)A\u0005\r\u000bC!Bb\"W\u0005\u0003\u0005\u000b\u0011BA:\u0011\u001d\tIG\u0016C\u0001\r\u0013C\u0011Bb%W\u0001\u0004%\tA\"&\t\u0013\u0019]e\u000b1A\u0005\u0002\u0019e\u0005\u0002\u0003DO-\u0002\u0006K!! \t\u000f\u0019}e\u000b\"\u0001\u0007\"\"9a\u0011\u0016,\u0005\n\u0019-\u0006b\u0002DX-\u0012%a\u0011\u0017\u0005\b\u0005G1F\u0011\u0001D`\u0011\u001d1\u0019M\u0016C\u0001\u0003o4aA\"2\u0001\u0001\u0019\u001d\u0007B\u0003B\"I\n\u0005\t\u0015!\u0003\u0007T\"Qaq\u00113\u0003\u0002\u0003\u0006I!a\u001d\t\u0015\u0019UGM!A!\u0002\u0013\ti\u000b\u0003\u0006\u0007X\u0012\u0014\t\u0011)A\u0005\u0003[Cq!!\u001be\t\u00031I\u000eC\u0005\u0007\u0014\u0012\u0004\r\u0011\"\u0001\u0007\u0016\"Iaq\u00133A\u0002\u0013\u0005a1\u001d\u0005\t\r;#\u0007\u0015)\u0003\u0002~!9aq\u00143\u0005\u0002\u0019\u001d\bb\u0002B\u0012I\u0012\u0005a1\u001e\u0005\b\r\u0007$G\u0011AA|\u0011\u001d1I\u0010\u0001C\u0005\rwDqa\"\u0004\u0001\t\u00139yaB\u0004\b(}D\ta\"\u000b\u0007\ry|\b\u0012AD\u0016\u0011\u001d\tIg\u001dC\u0001\u000fgAqa\"\u000et\t\u000799\u0004C\u0004\bNM$\tab\u0014\t\u000f\u001dm3\u000f\"\u0001\b^!9q\u0011N:\u0005\u0002\u001d-\u0004bBD5g\u0012\u0005q\u0011\u0010\u0005\b\u000f\u0013\u001bH\u0011BDF\u0011\u001d9Ij\u001dC\u0001\u000f7Cqa\"0t\t\u00039y\fC\u0005\bRN\f\t\u0011\"\u0003\bT\nA\u0001+\u0019:BeJ\f\u0017P\u0003\u0003\u0002\u0002\u0005\r\u0011aB7vi\u0006\u0014G.\u001a\u0006\u0005\u0003\u000b\t9!\u0001\u0005qCJ\fG\u000e\\3m\u0015\u0011\tI!a\u0003\u0002\u0015\r|G\u000e\\3di&|gN\u0003\u0002\u0002\u000e\u0005)1oY1mC\u000e\u0001Q\u0003BA\n\u0003S\u00192\u0002AA\u000b\u0003;\tY$!\u0013\u0002^A!\u0011qCA\r\u001b\t\tY!\u0003\u0003\u0002\u001c\u0005-!AB!osJ+g\r\u0005\u0004\u0002 \u0005\u0005\u0012QE\u0007\u0002\u007f&\u0019\u00111E@\u0003\rA\u000b'oU3r!\u0011\t9#!\u000b\r\u0001\u00119\u00111\u0006\u0001C\u0002\u00055\"!\u0001+\u0012\t\u0005=\u0012Q\u0007\t\u0005\u0003/\t\t$\u0003\u0003\u00024\u0005-!a\u0002(pi\"Lgn\u001a\t\u0005\u0003/\t9$\u0003\u0003\u0002:\u0005-!aA!osBA\u0011QHA\"\u0003K\t9%\u0004\u0002\u0002@)!\u0011\u0011IA\u0004\u0003\u001d9WM\\3sS\u000eLA!!\u0012\u0002@\t\u0011r)\u001a8fe&\u001c\u0007+\u0019:UK6\u0004H.\u0019;f!\r\ty\u0002\u0001\t\u000b\u0003\u0017\ni%!\n\u0002R\u0005MSBAA\u0002\u0013\u0011\ty%a\u0001\u0003\u0015A\u000b'oU3r\u0019&\\W\rE\u0003\u0002 \u0001\t)\u0003\u0005\u0004\u0002V\u0005e\u0013QE\u0007\u0003\u0003/RA!!\u0001\u0002\b%!\u00111LA,\u0005!\t%O]1z'\u0016\f\b\u0003BA\f\u0003?JA!!\u0019\u0002\f\ta1+\u001a:jC2L'0\u00192mK\u0006A\u0011M\u001d:bsN,\u0017/\u0006\u0002\u0002T\u0005I\u0011M\u001d:bsN,\u0017\u000fI\u0001\u0007y%t\u0017\u000e\u001e \u0015\t\u0005E\u0013Q\u000e\u0005\b\u0003G\u001a\u0001\u0019AA*\u0003\u0015\t'O]1z+\t\t\u0019\b\u0005\u0004\u0002\u0018\u0005U\u0014QG\u0005\u0005\u0003o\nYAA\u0003BeJ\f\u00170A\u0005beJ\f\u0017p\u0018\u0013fcR!\u0011QPAB!\u0011\t9\"a \n\t\u0005\u0005\u00151\u0002\u0002\u0005+:LG\u000fC\u0005\u0002\u0006\u0016\t\t\u00111\u0001\u0002t\u0005\u0019\u0001\u0010J\u0019\u0002\r\u0005\u0014(/Y=!Q\r1\u00111\u0012\t\u0005\u0003/\ti)\u0003\u0003\u0002\u0010\u0006-!!\u0003;sC:\u001c\u0018.\u001a8u\u0003%\u0019w.\u001c9b]&|g.\u0006\u0002\u0002\u0016J1\u0011qSAN\u0003C3a!!'\u0001\u0001\u0005U%\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004CBA\u001f\u0003;\u000b9%\u0003\u0003\u0002 \u0006}\"\u0001E$f]\u0016\u0014\u0018nY\"p[B\fg.[8o!\u0019\ti$a)\u0002H%!\u0011QUA \u0005M9UM\\3sS\u000e\u0004\u0016M]\"p[B\fg.[8o)\u0011\t\t&!+\t\u000f\u0005-\u0006\u00021\u0001\u0002.\u0006\u00111O\u001f\t\u0005\u0003/\ty+\u0003\u0003\u00022\u0006-!aA%oi\u0006)\u0011\r\u001d9msR!\u0011QEA\\\u0011\u001d\tI,\u0003a\u0001\u0003[\u000b\u0011![\u0001\u0007kB$\u0017\r^3\u0015\r\u0005u\u0014qXAa\u0011\u001d\tIL\u0003a\u0001\u0003[Cq!a1\u000b\u0001\u0004\t)#\u0001\u0003fY\u0016l\u0017A\u00027f]\u001e$\b.\u0006\u0002\u0002.\u0006\u00191/Z9\u0002\u0011M\u0004H.\u001b;uKJ,\"!a4\u0011\u0007\u0005Eg\"D\u0001\u0001\u0005A\u0001\u0016M]!se\u0006L\u0018\n^3sCR|'oE\u0003\u000f\u0003+\t9\u000e\u0005\u0004\u0002L\u0005e\u0017QE\u0005\u0005\u00037\f\u0019AA\u0006TKF\u001c\u0006\u000f\\5ui\u0016\u0014\u0018!B5`I\u0015\fH\u0003BA?\u0003CD\u0011\"!\"\u0011\u0003\u0003\u0005\r!!,\u0002\u0005%\u0004\u0013!B;oi&d\u0017AB;oi&d\u0007%A\u0002beJ\fA!\u0019:sAQA\u0011qZAx\u0003c\f\u0019\u0010C\u0005\u0002:Z\u0001\n\u00111\u0001\u0002.\"I\u0011Q\u001d\f\u0011\u0002\u0003\u0007\u0011Q\u0016\u0005\n\u0003S4\u0002\u0013!a\u0001\u0003g\nq\u0001[1t\u001d\u0016DH/\u0006\u0002\u0002zB!\u0011qCA~\u0013\u0011\ti0a\u0003\u0003\u000f\t{w\u000e\\3b]\u0006!a.\u001a=u)\t\t)#A\u0005sK6\f\u0017N\\5oO\u0006\u0019A-\u001e9\u0002\rA\u001c\b\u000f\\5u)\u0011\u0011YA!\u0007\u0011\r\t5!1CAh\u001d\u0011\t9Ba\u0004\n\t\tE\u00111B\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\u0011)Ba\u0006\u0003\u0007M+\u0017O\u0003\u0003\u0003\u0012\u0005-\u0001b\u0002B\u000e7\u0001\u0007!QD\u0001\u0010g&TXm]%oG>l\u0007\u000f\\3uKB1\u0011q\u0003B\u0010\u0003[KAA!\t\u0002\f\tQAH]3qK\u0006$X\r\u001a \u0002\u000bM\u0004H.\u001b;\u0016\u0005\t-\u0011\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\t-\u0002\u0003\u0002B\u0017\u0005oi!Aa\f\u000b\t\tE\"1G\u0001\u0005Y\u0006twM\u0003\u0002\u00036\u0005!!.\u0019<b\u0013\u0011\u0011IDa\f\u0003\rM#(/\u001b8h\u0003\u001d1wN]3bG\",BAa\u0010\u0003NQ!\u0011Q\u0010B!\u0011\u001d\u0011\u0019E\ba\u0001\u0005\u000b\n\u0011A\u001a\t\t\u0003/\u00119%!\n\u0003L%!!\u0011JA\u0006\u0005%1UO\\2uS>t\u0017\u0007\u0005\u0003\u0002(\t5Ca\u0002B(=\t\u0007\u0011Q\u0006\u0002\u0002+\u0006iam\u001c:fC\u000eDw,];jG.,BA!\u0016\u0003^QQ\u0011Q\u0010B,\u0005?\u0012\u0019Ga\u001a\t\u000f\t\rs\u00041\u0001\u0003ZAA\u0011q\u0003B$\u0003K\u0011Y\u0006\u0005\u0003\u0002(\tuCa\u0002B(?\t\u0007\u0011Q\u0006\u0005\b\u0005Cz\u0002\u0019AA:\u0003\u0005\t\u0007b\u0002B3?\u0001\u0007\u0011QV\u0001\u0005]RLG\u000eC\u0004\u0003j}\u0001\r!!,\u0002\t\u0019\u0014x.\\\u0001\u0006G>,h\u000e\u001e\u000b\u0005\u0003[\u0013y\u0007C\u0004\u0003r\u0001\u0002\rAa\u001d\u0002\u0003A\u0004\u0002\"a\u0006\u0003H\u0005\u0015\u0012\u0011`\u0001\fG>,h\u000e^0rk&\u001c7\u000e\u0006\u0006\u0002.\ne$1\u0010B?\u0005\u007fBqA!\u001d\"\u0001\u0004\u0011\u0019\bC\u0004\u0003b\u0005\u0002\r!a\u001d\t\u000f\t\u0015\u0014\u00051\u0001\u0002.\"9!\u0011N\u0011A\u0002\u00055\u0016\u0001\u00034pY\u0012dUM\u001a;\u0016\t\t\u0015%1\u0012\u000b\u0005\u0005\u000f\u0013I\n\u0006\u0003\u0003\n\n=\u0005\u0003BA\u0014\u0005\u0017#qA!$#\u0005\u0004\tiCA\u0001T\u0011\u001d\u0011\tJ\ta\u0001\u0005'\u000b!a\u001c9\u0011\u0015\u0005]!Q\u0013BE\u0003K\u0011I)\u0003\u0003\u0003\u0018\u0006-!!\u0003$v]\u000e$\u0018n\u001c83\u0011\u001d\u0011YJ\ta\u0001\u0005\u0013\u000b\u0011A_\u0001\u000fM>dG\rT3gi~\u000bX/[2l+\u0011\u0011\tK!*\u0015\u0015\t\r&q\u0015BU\u0005W\u0013y\u000b\u0005\u0003\u0002(\t\u0015Fa\u0002BGG\t\u0007\u0011Q\u0006\u0005\b\u0005C\u001a\u0003\u0019AA:\u0011\u001d\u0011)g\ta\u0001\u0003[CqA!%$\u0001\u0004\u0011i\u000b\u0005\u0006\u0002\u0018\tU%1UA\u0013\u0005GCqAa'$\u0001\u0004\u0011\u0019+\u0001\u0003g_2$W\u0003\u0002B[\u0005w#BAa.\u0003DR!!\u0011\u0018B`!\u0011\t9Ca/\u0005\u000f\t=CE1\u0001\u0003>F!\u0011QEA\u001b\u0011\u001d\u0011\t\n\na\u0001\u0005\u0003\u0004\"\"a\u0006\u0003\u0016\ne&\u0011\u0018B]\u0011\u001d\u0011Y\n\na\u0001\u0005s\u000b\u0011\"Y4he\u0016<\u0017\r^3\u0016\t\t%'q\u001a\u000b\u0005\u0005\u0017\u0014i\u000e\u0006\u0004\u0003N\nE'q\u001b\t\u0005\u0003O\u0011y\rB\u0004\u0003\u000e\u0016\u0012\r!!\f\t\u000f\tMW\u00051\u0001\u0003V\u0006)1/Z9paBQ\u0011q\u0003BK\u0005\u001b\f)C!4\t\u000f\teW\u00051\u0001\u0003\\\u000611m\\7c_B\u0004\"\"a\u0006\u0003\u0016\n5'Q\u001aBg\u0011!\u0011Y*\nCA\u0002\t}\u0007CBA\f\u0005C\u0014i-\u0003\u0003\u0003d\u0006-!\u0001\u0003\u001fcs:\fW.\u001a \u0002\u0007M,X.\u0006\u0003\u0003j\n5H\u0003\u0002Bv\u0005_\u0004B!a\n\u0003n\u00129!q\n\u0014C\u0002\tu\u0006b\u0002ByM\u0001\u000f!1_\u0001\u0004]Vl\u0007C\u0002B\u0007\u0005k\u0014Y/\u0003\u0003\u0003x\n]!a\u0002(v[\u0016\u0014\u0018nY\u0001\ngVlw,];jG.,BA!@\u0004\u0002Qa!q`B\u0002\u0007\u000f\u0019Iaa\u0003\u0004\u000eA!\u0011qEB\u0001\t\u001d\u0011ye\nb\u0001\u0005{CqA!=(\u0001\u0004\u0019)\u0001\u0005\u0004\u0003\u000e\tU(q \u0005\b\u0005C:\u0003\u0019AA:\u0011\u001d\u0011)g\na\u0001\u0003[CqA!\u001b(\u0001\u0004\ti\u000bC\u0004\u0004\u0010\u001d\u0002\rAa@\u0002\ti,'o\\\u0001\baJ|G-^2u+\u0011\u0019)b!\u0007\u0015\t\r]11\u0004\t\u0005\u0003O\u0019I\u0002B\u0004\u0003P!\u0012\rA!0\t\u000f\tE\b\u0006q\u0001\u0004\u001eA1!Q\u0002B{\u0007/\tQ\u0002\u001d:pIV\u001cGoX9vS\u000e\\W\u0003BB\u0012\u0007O!Bb!\n\u0004*\r52qFB\u0019\u0007g\u0001B!a\n\u0004(\u00119!qJ\u0015C\u0002\tu\u0006b\u0002ByS\u0001\u000711\u0006\t\u0007\u0005\u001b\u0011)p!\n\t\u000f\t\u0005\u0014\u00061\u0001\u0002t!9!QM\u0015A\u0002\u00055\u0006b\u0002B5S\u0001\u0007\u0011Q\u0016\u0005\b\u0007kI\u0003\u0019AB\u0013\u0003\ryg.Z\u0001\u0007M>\u0014\u0018\r\u001c7\u0015\t\u0005e81\b\u0005\b\u0005cR\u0003\u0019\u0001B:\u000311wN]1mY~\u000bX/[2l))\tIp!\u0011\u0004D\r\u00153\u0011\n\u0005\b\u0005cZ\u0003\u0019\u0001B:\u0011\u001d\u0011\tg\u000ba\u0001\u0003gBqaa\u0012,\u0001\u0004\ti+A\u0005oKb$XO\u001c;jY\"911J\u0016A\u0002\u00055\u0016!B:uCJ$\u0018AB3ySN$8\u000f\u0006\u0003\u0002z\u000eE\u0003b\u0002B9Y\u0001\u0007!1O\u0001\rKbL7\u000f^:`cVL7m\u001b\u000b\u000b\u0003s\u001c9f!\u0017\u0004\\\ru\u0003b\u0002B9[\u0001\u0007!1\u000f\u0005\b\u0005Cj\u0003\u0019AA:\u0011\u001d\u00199%\fa\u0001\u0003[Cqaa\u0013.\u0001\u0004\ti+\u0001\u0003gS:$G\u0003BB2\u0007S\u0002b!a\u0006\u0004f\u0005\u0015\u0012\u0002BB4\u0003\u0017\u0011aa\u00149uS>t\u0007b\u0002B9]\u0001\u0007!1O\u0001\u000bM&tGmX9vS\u000e\\GCCB2\u0007_\u001a\tha\u001d\u0004v!9!\u0011O\u0018A\u0002\tM\u0004b\u0002B1_\u0001\u0007\u00111\u000f\u0005\b\u0007\u000fz\u0003\u0019AAW\u0011\u001d\u0019Ye\fa\u0001\u0003[\u000bA\u0001\u001a:paR!\u0011qZB>\u0011\u001d\u0019i\b\ra\u0001\u0003[\u000b\u0011A\\\u0001\fG>\u0004\u0018\u0010V8BeJ\f\u00170\u0006\u0003\u0004\u0004\u000e-E\u0003CA?\u0007\u000b\u001biia$\t\u000f\u0005=\u0014\u00071\u0001\u0004\bB1\u0011qCA;\u0007\u0013\u0003B!a\n\u0004\f\u00129!qJ\u0019C\u0002\tu\u0006b\u0002B5c\u0001\u0007\u0011Q\u0016\u0005\b\u0007#\u000b\u0004\u0019AAW\u0003\raWM\\\u0001\raJ,g-\u001b=MK:<G\u000f\u001b\u000b\u0005\u0003[\u001b9\nC\u0004\u0004\u001aJ\u0002\rAa\u001d\u0002\tA\u0014X\rZ\u0001\u0013aJ,g-\u001b=MK:<G\u000f[0rk&\u001c7\u000e\u0006\u0006\u0002.\u000e}5\u0011UBR\u0007KCqa!'4\u0001\u0004\u0011\u0019\bC\u0004\u0003bM\u0002\r!a\u001d\t\u000f\t\u00154\u00071\u0001\u0002.\"91qU\u001aA\u0002\u00055\u0016\u0001C:uCJ$\bo\\:\u0002\u0015%tG-\u001a=XQ\u0016\u0014X\r\u0006\u0003\u0002.\u000e5\u0006bBBMi\u0001\u0007!1O\u0001\u0011S:$W\r_,iKJ,w,];jG.$\"\"!,\u00044\u000eU6qWB]\u0011\u001d\u0019I*\u000ea\u0001\u0005gBqA!\u00196\u0001\u0004\t\u0019\bC\u0004\u0003fU\u0002\r!!,\t\u000f\t%T\u00071\u0001\u0002.\u0006qA.Y:u\u0013:$W\r_,iKJ,G\u0003BAW\u0007\u007fCqa!'7\u0001\u0004\u0011\u0019(\u0001\u000bmCN$\u0018J\u001c3fq^CWM]3`cVL7m\u001b\u000b\u000b\u0003[\u001b)ma2\u0004J\u000e-\u0007bBBMo\u0001\u0007!1\u000f\u0005\b\u0005C:\u0004\u0019AA:\u0011\u001d\u0011Ig\u000ea\u0001\u0003[CqA!\u001a8\u0001\u0004\ti+\u0001\u0007tC6,W\t\\3nK:$8\u000f\u0006\u0003\u0002z\u000eE\u0007bBBjq\u0001\u00071Q[\u0001\u0005i\"\fG\u000f\r\u0003\u0004X\u000e}\u0007C\u0002B\u0007\u00073\u001ci.\u0003\u0003\u0004\\\n]!\u0001C%uKJ\fGo\u001c:\u0011\t\u0005\u001d2q\u001c\u0003\r\u0007C\u001c\t.!A\u0001\u0002\u000b\u0005\u0011Q\u0006\u0002\u0004?\u0012\n\u0014\u0001D7baJ\u001aw.\u001c2j]\u0016\u0014XCBBt\u0007c\u001c)\u0010\u0006\u0004\u0004j\u000ee8Q \t\t\u0003\u0017\u001aYoa<\u0004t&!1Q^A\u0002\u0005!\u0019u.\u001c2j]\u0016\u0014\b\u0003BA\u0014\u0007c$qA!$:\u0005\u0004\ti\u0003\u0005\u0003\u0002(\rUHaBB|s\t\u0007\u0011Q\u0006\u0002\u0005)\"\fG\u000fC\u0004\u0003De\u0002\raa?\u0011\u0011\u0005]!qIA\u0013\u0007_Dqaa@:\u0001\u0004\u0019I/\u0001\u0002dE\u0006\u0011R.\u001993G>l'-\u001b8fe~\u000bX/[2l+\u0019!)\u0001\"\u0004\u0005\u001cQa\u0011Q\u0010C\u0004\t\u001f!\t\u0002\"\b\u0005 !9!1\t\u001eA\u0002\u0011%\u0001\u0003CA\f\u0005\u000f\n)\u0003b\u0003\u0011\t\u0005\u001dBQ\u0002\u0003\b\u0005\u001bS$\u0019AA\u0017\u0011\u001d\u0011\tG\u000fa\u0001\u0003gBqaa@;\u0001\u0004!\u0019\u0002\u0005\u0005\u0002V\u0011UA1\u0002C\r\u0013\u0011!9\"a\u0016\u0003\u000f\t+\u0018\u000e\u001c3feB!\u0011q\u0005C\u000e\t\u001d\u00199P\u000fb\u0001\u0003[AqA!\u001a;\u0001\u0004\ti\u000bC\u0004\u0003ji\u0002\r!!,\u0002!\r|G\u000e\\3diJ\u001aw.\u001c2j]\u0016\u0014XC\u0002C\u0013\tW!y\u0003\u0006\u0004\u0005(\u0011EB1\b\t\t\u0003\u0017\u001aY\u000f\"\u000b\u0005.A!\u0011q\u0005C\u0016\t\u001d\u0011ii\u000fb\u0001\u0003[\u0001B!a\n\u00050\u001191q_\u001eC\u0002\u00055\u0002b\u0002C\u001aw\u0001\u0007AQG\u0001\u0003a\u001a\u0004\u0002\"a\u0006\u00058\u0005\u0015B\u0011F\u0005\u0005\ts\tYAA\bQCJ$\u0018.\u00197Gk:\u001cG/[8o\u0011\u001d\u0019yp\u000fa\u0001\tO\tacY8mY\u0016\u001cGOM2p[\nLg.\u001a:`cVL7m[\u000b\u0007\t\u0003\"I\u0005b\u0015\u0015\u0019\u0005uD1\tC&\t\u001b\")\u0006b\u0016\t\u000f\u0011MB\b1\u0001\u0005FAA\u0011q\u0003C\u001c\u0003K!9\u0005\u0005\u0003\u0002(\u0011%Ca\u0002BGy\t\u0007\u0011Q\u0006\u0005\b\u0005Cb\u0004\u0019AA:\u0011\u001d\u0019y\u0010\u0010a\u0001\t\u001f\u0002\u0002\"!\u0016\u0005\u0016\u0011\u001dC\u0011\u000b\t\u0005\u0003O!\u0019\u0006B\u0004\u0004xr\u0012\r!!\f\t\u000f\t\u0015D\b1\u0001\u0002.\"9!\u0011\u000e\u001fA\u0002\u00055\u0016\u0001\u00054mCRl\u0017\r\u001d\u001ad_6\u0014\u0017N\\3s+\u0019!i\u0006b\u0019\u0005hQ1Aq\fC5\tk\u0002\u0002\"a\u0013\u0004l\u0012\u0005DQ\r\t\u0005\u0003O!\u0019\u0007B\u0004\u0003\u000ev\u0012\r!!\f\u0011\t\u0005\u001dBq\r\u0003\b\u0007ol$\u0019AA\u0017\u0011\u001d\u0011\u0019%\u0010a\u0001\tW\u0002\u0002\"a\u0006\u0003H\u0005\u0015BQ\u000e\t\u0007\t_\"\t\b\"\u0019\u000e\u0005\u0005\u001d\u0011\u0002\u0002C:\u0003\u000f\u0011!cR3o)J\fg/\u001a:tC\ndWm\u00148dK\"91q`\u001fA\u0002\u0011}\u0013a\u00044jYR,'OM2p[\nLg.\u001a:\u0016\r\u0011mD\u0011\u0011CC)\u0019!i\b\"#\u0005\fBA\u00111JBv\t\u007f\"\u0019\t\u0005\u0003\u0002(\u0011\u0005Ea\u0002B(}\t\u0007!Q\u0018\t\u0005\u0003O!)\tB\u0004\u0005\bz\u0012\r!!\f\u0003\tQC\u0017n\u001d\u0005\b\u00073s\u0004\u0019\u0001B:\u0011\u001d\u0019yP\u0010a\u0001\t{\nQCZ5mi\u0016\u0014(gY8nE&tWM]0rk&\u001c7.\u0006\u0004\u0005\u0012\u0012mEq\u0014\u000b\r\u0003{\"\u0019\n\"&\u0005\"\u0012\rFQ\u0015\u0005\b\u00073{\u0004\u0019\u0001B:\u0011\u001d\u0019yp\u0010a\u0001\t/\u0003\u0002\"!\u0016\u0005\u0016\u0011eEQ\u0014\t\u0005\u0003O!Y\nB\u0004\u0003P}\u0012\rA!0\u0011\t\u0005\u001dBq\u0014\u0003\b\t\u000f{$\u0019AA\u0017\u0011\u001d\u0011\tg\u0010a\u0001\u0003gBqA!\u001a@\u0001\u0004\ti\u000bC\u0004\u0003j}\u0002\r!!,\u0002%\u0019LG\u000e^3s\u001d>$(gY8nE&tWM]\u000b\u0007\tW#\t\f\".\u0015\r\u00115Fq\u0017C]!!\tYea;\u00050\u0012M\u0006\u0003BA\u0014\tc#qAa\u0014A\u0005\u0004\u0011i\f\u0005\u0003\u0002(\u0011UFa\u0002CD\u0001\n\u0007\u0011Q\u0006\u0005\b\u00073\u0003\u0005\u0019\u0001B:\u0011\u001d\u0019y\u0010\u0011a\u0001\t[\u000b\u0001DZ5mi\u0016\u0014hj\u001c;3G>l'-\u001b8fe~\u000bX/[2l+\u0019!y\f\"3\u0005NRa\u0011Q\u0010Ca\t\u0007$y\r\"5\u0005T\"91\u0011T!A\u0002\tM\u0004bBB\u0000\u0003\u0002\u0007AQ\u0019\t\t\u0003+\")\u0002b2\u0005LB!\u0011q\u0005Ce\t\u001d\u0011y%\u0011b\u0001\u0005{\u0003B!a\n\u0005N\u00129AqQ!C\u0002\u00055\u0002b\u0002B1\u0003\u0002\u0007\u00111\u000f\u0005\b\u0005K\n\u0005\u0019AAW\u0011\u001d\u0011I'\u0011a\u0001\u0003[\u000bAbY8qsJ\u0012W/\u001b7eKJ,\u0002\u0002\"7\u0005h\u0012-HQ\u001c\u000b\u0005\t7$y\u000f\u0005\u0003\u0002(\u0011uGa\u0002Cp\u0005\n\u0007A\u0011\u001d\u0002\u0004\u00052$\u0017\u0003BA\u0018\tG\u0004\u0002\"!\u0016\u0005\u0016\u0011\u0015H\u0011\u001e\t\u0005\u0003O!9\u000fB\u0004\u0003P\t\u0013\rA!0\u0011\t\u0005\u001dB1\u001e\u0003\b\t[\u0014%\u0019AA\u0017\u0005\u0011\u0019u\u000e\u001c7\t\u000f\r}(\t1\u0001\u0005\\\u0006\u00112m\u001c9ze\t,\u0018\u000e\u001c3fe~\u000bX/[2l+\u0019!)\u0010b@\u0006\u0004QQ\u0011Q\u0010C|\u000b\u000b)9!\"\u0003\t\u000f\u0011e8\t1\u0001\u0005|\u0006\t!\r\u0005\u0005\u0002V\u0011UAQ`C\u0001!\u0011\t9\u0003b@\u0005\u000f\t=3I1\u0001\u0003>B!\u0011qEC\u0002\t\u001d!io\u0011b\u0001\u0003[AqA!\u0019D\u0001\u0004\t\u0019\bC\u0004\u0003f\r\u0003\r!!,\t\u000f\t%4\t1\u0001\u0002.\u0006\u0019\u0002/\u0019:uSRLwN\u001c\u001ad_6\u0014\u0017N\\3sgV1QqBC\u000e\u000b?!\u0002\"\"\u0005\u0006\"\u0015\rRq\u0005\t\t\u0003/)\u0019\"b\u0006\u0006\u0018%!QQCA\u0006\u0005\u0019!V\u000f\u001d7feAA\u00111JBv\u000b3)i\u0002\u0005\u0003\u0002(\u0015mAa\u0002B(\t\n\u0007!Q\u0018\t\u0005\u0003O)y\u0002B\u0004\u0005\b\u0012\u0013\r!!\f\t\u000f\reE\t1\u0001\u0003t!9QQ\u0005#A\u0002\u0015]\u0011!\u00022ueV,\u0007bBC\u0015\t\u0002\u0007QqC\u0001\u0007E\u001a\fGn]3\u00023A\f'\u000f^5uS>t'gY8nE&tWM]:`cVL7m[\u000b\u0007\u000b_)I$\"\u0010\u0015\u001d\u0005uT\u0011GC\u001a\u000b\u007f)\t%b\u0011\u0006F!9!\u0011O#A\u0002\tM\u0004bBC\u0013\u000b\u0002\u0007QQ\u0007\t\t\u0003+\")\"b\u000e\u0006<A!\u0011qEC\u001d\t\u001d\u0011y%\u0012b\u0001\u0005{\u0003B!a\n\u0006>\u00119AqQ#C\u0002\u00055\u0002bBC\u0015\u000b\u0002\u0007QQ\u0007\u0005\b\u0005C*\u0005\u0019AA:\u0011\u001d\u0011)'\u0012a\u0001\u0003[CqA!\u001bF\u0001\u0004\ti+A\u0007uC.,'gY8nE&tWM]\u000b\u0007\u000b\u0017*\t&\"\u0016\u0015\r\u00155SqKC-!!\tYea;\u0006P\u0015M\u0003\u0003BA\u0014\u000b#\"qAa\u0014G\u0005\u0004\u0011i\f\u0005\u0003\u0002(\u0015UCa\u0002CD\r\n\u0007\u0011Q\u0006\u0005\b\u0007{2\u0005\u0019AAW\u0011\u001d\u0019yP\u0012a\u0001\u000b\u001b\nQ\u0002\u001a:paJ\u001aw.\u001c2j]\u0016\u0014XCBC0\u000bK*I\u0007\u0006\u0004\u0006b\u0015-TQ\u000e\t\t\u0003\u0017\u001aY/b\u0019\u0006hA!\u0011qEC3\t\u001d\u0011ye\u0012b\u0001\u0005{\u0003B!a\n\u0006j\u00119AqQ$C\u0002\u00055\u0002bBB?\u000f\u0002\u0007\u0011Q\u0016\u0005\b\u0007\u007f<\u0005\u0019AC1\u0003A\u0011XM^3sg\u0016\u00144m\\7cS:,'/\u0006\u0004\u0006t\u0015eTQ\u0010\u000b\u0005\u000bk*y\b\u0005\u0005\u0002L\r-XqOC>!\u0011\t9#\"\u001f\u0005\u000f\t=\u0003J1\u0001\u0003>B!\u0011qEC?\t\u001d!9\t\u0013b\u0001\u0003[Aqaa@I\u0001\u0004))(\u0001\fsKZ,'o]33G>l'-\u001b8fe~\u000bX/[2l)1\ti(\"\"\u0006\n\u0016-UqRCJ\u0011\u001d)9)\u0013a\u0001\u0003g\nA\u0001^1sO\"9!\u0011M%A\u0002\u0005M\u0004bBCG\u0013\u0002\u0007\u0011QV\u0001\ti\u0006\u0014xM\u001a:p[\"9Q\u0011S%A\u0002\u00055\u0016aB:sG\u001a\u0014x.\u001c\u0005\b\u000b+K\u0005\u0019AAW\u0003!\u0019(oY;oi&d\u0017aC:dC:$v.\u0011:sCf,b!b'\u0006\"\u0016=FCCA?\u000b;+\u0019+b*\u00066\"9!1\u0014&A\u0002\u0015}\u0005\u0003BA\u0014\u000bC#qAa\u0014K\u0005\u0004\u0011i\fC\u0004\u0003\u0012*\u0003\r!\"*\u0011\u0015\u0005]!QSCP\u000b?+y\nC\u0004\u0006**\u0003\r!b+\u0002\u000f\u0011,7\u000f^1seB1\u0011qCA;\u000b[\u0003B!a\n\u00060\u00129Q\u0011\u0017&C\u0002\u0015M&!A!\u0012\t\u0015}\u0015Q\u0007\u0005\b\u0005SR\u0005\u0019AAW\u0003E\u00198-\u00198U_\u0006\u0013(/Y=`cVL7m[\u000b\u0005\u000bw+I\r\u0006\t\u0002~\u0015uV\u0011YCb\u000b\u0017,i-b4\u0006T\"9QqX&A\u0002\u0005M\u0014AB:sG\u0006\u0014(\u000fC\u0004\u0006*.\u0003\r!a\u001d\t\u000f\tE5\n1\u0001\u0006FBQ\u0011q\u0003BK\u000b\u000f,9-b2\u0011\t\u0005\u001dR\u0011\u001a\u0003\b\u0005\u001fZ%\u0019AA\u0017\u0011\u001d\u0011Yj\u0013a\u0001\u000b\u000fDq!\"%L\u0001\u0004\ti\u000bC\u0004\u0006R.\u0003\r!!,\u0002\u000fM\u00148M\u001c;jY\"9QQ[&A\u0002\u00055\u0016\u0001\u00033fgR4'o\\7\u0002-M,\b/\u001a:%e\u00164XM]:fe\r|WNY5oKJ,b!b7\u0006b\u0016\u0015H\u0003BCo\u000bO\u0004\u0002\"a\u0013\u0004l\u0016}W1\u001d\t\u0005\u0003O)\t\u000fB\u0004\u0003P1\u0013\rA!0\u0011\t\u0005\u001dRQ\u001d\u0003\b\t\u000fc%\u0019AA\u0017\u0011\u001d\u0019y\u0010\u0014a\u0001\u000b;LA!b\u001c\u0006l&!QQ^A\u0002\u0005Q\tUoZ7f]R,GmU3r\u0013R,'/\u0019;pe\u0006\u0001\u0002+\u0019:BeJ\f\u00170\u0013;fe\u0006$xN\u001d\t\u0004\u0003#t5c\u0001(\u0002\u0016Q\u0011Q\u0011_\u0001\u001cI1,7o]5oSR$sM]3bi\u0016\u0014H\u0005Z3gCVdG\u000fJ\u0019\u0016\u0005\u0015m(\u0006BAW\u000b{\\#!b@\u0011\t\u0019\u0005a1B\u0007\u0003\r\u0007QAA\"\u0002\u0007\b\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0005\r\u0013\tY!\u0001\u0006b]:|G/\u0019;j_:LAA\"\u0004\u0007\u0004\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u00027\u0011bWm]:j]&$He\u001a:fCR,'\u000f\n3fM\u0006,H\u000e\u001e\u00133\u0003m!C.Z:tS:LG\u000fJ4sK\u0006$XM\u001d\u0013eK\u001a\fW\u000f\u001c;%gU\u0011aQ\u0003\u0016\u0005\u0003g*i0A\u0006ck&dGm]!se\u0006LXC\u0002D\u000e\rK1I\u0003\u0006\u0003\u0002z\u001au\u0001b\u0002D\u0010'\u0002\u0007a\u0011E\u0001\u0002GBA\u0011Q\u000bC\u000b\rG19\u0003\u0005\u0003\u0002(\u0019\u0015Ba\u0002BG'\n\u0007\u0011Q\u0006\t\u0005\u0003O1I\u0003B\u0004\u0004xN\u0013\r!!\f\u0002\u00075\f\u0007/\u0006\u0004\u00070\u0019\rcQ\u0007\u000b\u0005\rc1)\u0005\u0006\u0003\u00074\u0019]\u0002\u0003BA\u0014\rk!qaa>U\u0005\u0004\ti\u0003C\u0004\u0007:Q\u0003\u001dAb\u000f\u0002\u0005\t4\u0007CCA\u001f\r{\t\tF\"\u0011\u00074%!aqHA \u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u0011\t9Cb\u0011\u0005\u000f\t5EK1\u0001\u0002.!9!1\t+A\u0002\u0019\u001d\u0003\u0003CA\f\u0005\u000f\n)C\"\u0011\u0002\tM\u001c\u0017M\\\u000b\u0007\r\u001b2yF\"\u0016\u0015\t\u0019=cQ\r\u000b\u0005\r#2\t\u0007\u0006\u0003\u0007T\u0019]\u0003\u0003BA\u0014\r+\"qaa>V\u0005\u0004\ti\u0003C\u0004\u0007ZU\u0003\u001dAb\u0017\u0002\u0007\r\u0014g\r\u0005\u0006\u0002>\u0019u\u0012\u0011\u000bD/\r'\u0002B!a\n\u0007`\u00119!qJ+C\u0002\tu\u0006b\u0002BI+\u0002\u0007a1\r\t\u000b\u0003/\u0011)J\"\u0018\u0007^\u0019u\u0003b\u0002BN+\u0002\u0007aQ\f\u0002\f'\u000e\fg\u000eV8BeJ\f\u00170\u0006\u0003\u0007l\u0019]4#\u0002,\u0002\u0016\u00195\u0004\u0003CA&\r_\niHb\u001d\n\t\u0019E\u00141\u0001\u0002\u0005)\u0006\u001c8\u000eE\u0003\u0002RZ3)\b\u0005\u0003\u0002(\u0019]Da\u0002B(-\n\u0007!QX\u0001\u0005iJ,W\r\u0005\u0004\u0002R\u001audQO\u0005\u0005\r\u007f2\tI\u0001\u0005TG\u0006tGK]3f\u0013\u00111\u0019)a\u0001\u0003\u001fA\u000b'/\u0013;fe\u0006\u0014G.\u001a'jW\u0016\u0004\"\"a\u0006\u0003\u0016\u001aUdQ\u000fD;\u0003%!\u0018M]4fi\u0006\u0014(\u000f\u0006\u0006\u0007t\u0019-eQ\u0012DH\r#CqA\"\u001f\\\u0001\u00041Y\bC\u0004\u0003\u001cn\u0003\rA\"\u001e\t\u000f\tE5\f1\u0001\u0007\u0006\"9aqQ.A\u0002\u0005M\u0014A\u0002:fgVdG/\u0006\u0002\u0002~\u0005Q!/Z:vYR|F%Z9\u0015\t\u0005ud1\u0014\u0005\n\u0003\u000bk\u0016\u0011!a\u0001\u0003{\nqA]3tk2$\b%\u0001\u0003mK\u00064G\u0003BA?\rGCqA\"*`\u0001\u000419+\u0001\u0003qe\u00164\bCBA\f\u0007K\ni(A\u0004ji\u0016\u0014\u0018\r^3\u0015\t\u0005udQ\u0016\u0005\b\rs\u0002\u0007\u0019\u0001D>\u0003!\u00198-\u00198MK\u00064G\u0003DA?\rg3)Lb.\u0007:\u001am\u0006bBC`C\u0002\u0007\u00111\u000f\u0005\b\r\u000f\u000b\u0007\u0019AA:\u0011\u001d\u0011I'\u0019a\u0001\u0003[Cqa!%b\u0001\u0004\ti\u000bC\u0004\u0007>\u0006\u0004\rA\"\u001e\u0002\u0011M$\u0018M\u001d;wC2,\"A\"1\u0011\r\t5!1\u0003D7\u0003I\u0019\bn\\;mIN\u0003H.\u001b;GkJ$\b.\u001a:\u0003\u00075\u000b\u0007/\u0006\u0003\u0007J\u001aE7#\u00023\u0002\u0016\u0019-\u0007\u0003CA&\r_\niH\"4\u0011\u000b\u0005EGMb4\u0011\t\u0005\u001db\u0011\u001b\u0003\b\u0005\u001b#'\u0019AA\u0017!!\t9Ba\u0012\u0002&\u0019=\u0017AB8gMN,G/A\u0004i_^l\u0017M\\=\u0015\u0015\u00195g1\u001cDo\r?4\t\u000fC\u0004\u0003D%\u0004\rAb5\t\u000f\u0019\u001d\u0015\u000e1\u0001\u0002t!9aQ[5A\u0002\u00055\u0006b\u0002DlS\u0002\u0007\u0011Q\u0016\u000b\u0005\u0003{2)\u000fC\u0005\u0002\u0006.\f\t\u00111\u0001\u0002~Q!\u0011Q\u0010Du\u0011\u001d1)+\u001ca\u0001\rO+\"A\"<\u0011\r\u0019=hQ\u001fDg\u001b\t1\tP\u0003\u0003\u0007t\u0006\u001d\u0011!C5n[V$\u0018M\u00197f\u0013\u001119P\"=\u0003\t1K7\u000f^\u0001\foJLG/Z(cU\u0016\u001cG\u000f\u0006\u0003\u0002~\u0019u\bb\u0002D\u0000a\u0002\u0007q\u0011A\u0001\u0004_V$\b\u0003BD\u0002\u000f\u0013i!a\"\u0002\u000b\t\u001d\u001d!1G\u0001\u0003S>LAab\u0003\b\u0006\t\u0011rJ\u00196fGR|U\u000f\u001e9viN#(/Z1n\u0003)\u0011X-\u00193PE*,7\r\u001e\u000b\u0005\u0003{:\t\u0002C\u0004\b\u0014E\u0004\ra\"\u0006\u0002\u0005%t\u0007\u0003BD\u0002\u000f/IAa\"\u0007\b\u0006\t\trJ\u00196fGRLe\u000e];u'R\u0014X-Y7)\u000f\u00019ibb\t\b&A!\u0011qCD\u0010\u0013\u00119\t#a\u0003\u0003!M+'/[1m-\u0016\u00148/[8o+&#\u0015!\u0002<bYV,g$A\u0001\u0002\u0011A\u000b'/\u0011:sCf\u00042!a\bt'\u0015\u0019xQFA/!\u0019\tidb\f\u0002H%!q\u0011GA \u0005)\u0001\u0016M\u001d$bGR|'/\u001f\u000b\u0003\u000fS\tAbY1o\u0005VLG\u000e\u001a$s_6,Ba\"\u000f\bJU\u0011q1\b\t\u000b\u0003{9id\"\u0011\bH\u001d-\u0013\u0002BD \u0003\u007f\u0011abQ1o\u0007>l'-\u001b8f\rJ|W\u000e\u0005\u0003\bD\u001d\u0015S\"A:\n\t\u00115\u0018Q\u0014\t\u0005\u0003O9I\u0005B\u0004\u0002,U\u0014\r!!\f\u0011\u000b\u0005}\u0001ab\u0012\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0003\bR\u001d]SCAD*!!\tYea;\bV\u001de\u0003\u0003BA\u0014\u000f/\"q!a\u000bw\u0005\u0004\ti\u0003E\u0003\u0002 \u00019)&A\u0006oK^\u001cu.\u001c2j]\u0016\u0014X\u0003BD0\u000fK*\"a\"\u0019\u0011\u0011\u0005-31^D2\u000fO\u0002B!a\n\bf\u00119\u00111F<C\u0002\u00055\u0002#BA\u0010\u0001\u001d\r\u0014a\u00025b]\u0012|gMZ\u000b\u0005\u000f[:\u0019\b\u0006\u0003\bp\u001dU\u0004#BA\u0010\u0001\u001dE\u0004\u0003BA\u0014\u000fg\"q!a\u000by\u0005\u0004\ti\u0003C\u0004\u0002jb\u0004\rab\u001e\u0011\r\u0005]\u0011QOD9+\u00119Yh\"!\u0015\r\u001dut1QDD!\u0015\ty\u0002AD@!\u0011\t9c\"!\u0005\u000f\u0005-\u0012P1\u0001\u0002.!9\u0011\u0011^=A\u0002\u001d\u0015\u0005CBA\f\u0003k:y\bC\u0004\u0002,f\u0004\r!!,\u0002\u001b]\u0014\u0018\r](s%\u0016\u0014W/\u001b7e+\u00119iib%\u0015\r\u001d=uQSDL!\u0015\ty\u0002ADI!\u0011\t9cb%\u0005\u000f\u0005-\"P1\u0001\u0002.!9\u0011\u0011\u001e>A\u0002\u0005U\u0001bBAVu\u0002\u0007\u0011QV\u0001\u000fGJ,\u0017\r^3Ge>l7i\u001c9z+\u00119ij\"*\u0015\t\u001d}u\u0011\u0018\u000b\u0005\u000fC;I\u000bE\u0003\u0002 \u00019\u0019\u000b\u0005\u0003\u0002(\u001d\u0015FaBA\u0016w\n\u0007qqU\t\u0005\u0003_\t)\u0002C\u0005\b,n\f\t\u0011q\u0001\b.\u0006QQM^5eK:\u001cW\rJ\u0019\u0011\r\u001d=vQWDR\u001b\t9\tL\u0003\u0003\b4\u0006-\u0011a\u0002:fM2,7\r^\u0005\u0005\u000fo;\tL\u0001\u0005DY\u0006\u001c8\u000fV1h\u0011\u001d\tIo\u001fa\u0001\u000fw\u0003b!a\u0006\u0002v\u001d\r\u0016\u0001\u00054s_6$&/\u0019<feN\f'\r\\3t+\u00119\tmb2\u0015\t\u001d\rw\u0011\u001a\t\u0006\u0003?\u0001qQ\u0019\t\u0005\u0003O99\rB\u0004\u0002,q\u0014\r!!\f\t\u000f\u001d-G\u00101\u0001\bN\u0006\u0019\u0001p]:\u0011\r\u0005]!qDDh!\u0019!y\u0007\"\u001d\bF\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t9)\u000e\u0005\u0003\u0003.\u001d]\u0017\u0002BDm\u0005_\u0011aa\u00142kK\u000e$\b")
public class ParArray<T>
implements scala.collection.parallel.mutable.ParSeq<T>,
Serializable {
    public static final long serialVersionUID = 1L;
    private volatile ParArray$ParArrayIterator$ ParArrayIterator$module;
    private final ArraySeq<T> arrayseq;
    private transient Object[] scala$collection$parallel$mutable$ParArray$$array;
    private volatile transient TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport;
    private volatile ParIterableLike$ScanNode$ ScanNode$module;
    private volatile ParIterableLike$ScanLeaf$ ScanLeaf$module;

    public static <T> ParArray<T> fromTraversables(Seq<GenTraversableOnce<T>> seq) {
        return ParArray$.MODULE$.fromTraversables(seq);
    }

    public static <T> ParArray<T> createFromCopy(T[] TArray, ClassTag<T> classTag) {
        return ParArray$.MODULE$.createFromCopy(TArray, classTag);
    }

    public static <T> ParArray<T> handoff(Object object, int n) {
        return ParArray$.MODULE$.handoff(object, n);
    }

    public static <T> ParArray<T> handoff(Object object) {
        return ParArray$.MODULE$.handoff(object);
    }

    public static <T> CanCombineFrom<ParArray<?>, T, ParArray<T>> canBuildFrom() {
        return ParArray$.MODULE$.canBuildFrom();
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)parArray$).newBuilder();
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
        return ParArray$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ParArray$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ tabulate_this = parArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ tabulate_this = parArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ tabulate_this = parArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ tabulate_this = parArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ParArray$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ fill_this = parArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ fill_this = parArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ fill_this = parArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        ParArray$ fill_this = parArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ParArray$ parArray$ = ParArray$.MODULE$;
        if (parArray$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)parArray$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ParArray$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ParArray$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ParArray$.MODULE$.empty();
    }

    @Override
    public scala.collection.parallel.mutable.ParSeq<T> toSeq() {
        return scala.collection.parallel.mutable.ParSeq.toSeq$(this);
    }

    @Override
    public String toString() {
        return ParSeq.toString$(this);
    }

    @Override
    public String stringPrefix() {
        return ParSeq.stringPrefix$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$parallel$ParSeqLike$$super$zip(GenIterable that, CanBuildFrom bf) {
        return ParIterableLike.zip$(this, that, bf);
    }

    @Override
    public PreciseSplitter<T> iterator() {
        return ParSeqLike.iterator$(this);
    }

    @Override
    public int size() {
        return ParSeqLike.size$(this);
    }

    @Override
    public int segmentLength(Function1<T, Object> p, int from) {
        return ParSeqLike.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<T, Object> p, int from) {
        return ParSeqLike.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<T, Object> p, int end) {
        return ParSeqLike.lastIndexWhere$(this, p, end);
    }

    @Override
    public ParSeq reverse() {
        return ParSeqLike.reverse$(this);
    }

    @Override
    public <S, That> That reverseMap(Function1<T, S> f, CanBuildFrom<ParArray<T>, S, That> bf) {
        return (That)ParSeqLike.reverseMap$(this, f, bf);
    }

    @Override
    public <S> boolean startsWith(GenSeq<S> that, int offset) {
        return ParSeqLike.startsWith$(this, that, offset);
    }

    @Override
    public <U> boolean sameElements(GenIterable<U> that) {
        return ParSeqLike.sameElements$(this, that);
    }

    @Override
    public <S> boolean endsWith(GenSeq<S> that) {
        return ParSeqLike.endsWith$(this, that);
    }

    @Override
    public <U, That> That patch(int from, GenSeq<U> patch, int replaced, CanBuildFrom<ParArray<T>, U, That> bf) {
        return (That)ParSeqLike.patch$(this, from, patch, replaced, bf);
    }

    @Override
    public <U, That> That updated(int index, U elem, CanBuildFrom<ParArray<T>, U, That> bf) {
        return (That)ParSeqLike.updated$(this, index, elem, bf);
    }

    @Override
    public <U, That> That $plus$colon(U elem, CanBuildFrom<ParArray<T>, U, That> bf) {
        return (That)ParSeqLike.$plus$colon$(this, elem, bf);
    }

    @Override
    public <U, That> That $colon$plus(U elem, CanBuildFrom<ParArray<T>, U, That> bf) {
        return (That)ParSeqLike.$colon$plus$(this, elem, bf);
    }

    @Override
    public <U, That> That padTo(int len, U elem, CanBuildFrom<ParArray<T>, U, That> bf) {
        return (That)ParSeqLike.padTo$(this, len, elem, bf);
    }

    @Override
    public <U, S, That> That zip(GenIterable<S> that, CanBuildFrom<ParArray<T>, Tuple2<U, S>, That> bf) {
        return (That)ParSeqLike.zip$(this, that, bf);
    }

    @Override
    public <S> boolean corresponds(GenSeq<S> that, Function2<T, S, Object> p) {
        return ParSeqLike.corresponds$(this, that, p);
    }

    @Override
    public ParSeq diff(GenSeq that) {
        return ParSeqLike.diff$(this, that);
    }

    @Override
    public ParSeq intersect(GenSeq that) {
        return ParSeqLike.intersect$(this, that);
    }

    @Override
    public ParSeq distinct() {
        return ParSeqLike.distinct$(this);
    }

    @Override
    public SeqView<T, ArraySeq<T>> view() {
        return ParSeqLike.view$(this);
    }

    @Override
    public SeqSplitter<T> down(IterableSplitter<?> p) {
        return ParSeqLike.down$(this, p);
    }

    @Override
    public ParIterable<T> toIterable() {
        return ParIterable.toIterable$(this);
    }

    @Override
    public void initTaskSupport() {
        ParIterableLike.initTaskSupport$(this);
    }

    @Override
    public TaskSupport tasksupport() {
        return ParIterableLike.tasksupport$(this);
    }

    @Override
    public void tasksupport_$eq(TaskSupport ts) {
        ParIterableLike.tasksupport_$eq$(this, ts);
    }

    @Override
    public scala.collection.parallel.ParIterable repr() {
        return ParIterableLike.repr$(this);
    }

    @Override
    public final boolean isTraversableAgain() {
        return ParIterableLike.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return ParIterableLike.hasDefiniteSize$(this);
    }

    @Override
    public boolean isEmpty() {
        return ParIterableLike.isEmpty$(this);
    }

    @Override
    public boolean nonEmpty() {
        return ParIterableLike.nonEmpty$(this);
    }

    @Override
    public T head() {
        return (T)ParIterableLike.head$(this);
    }

    @Override
    public Option<T> headOption() {
        return ParIterableLike.headOption$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable tail() {
        return ParIterableLike.tail$(this);
    }

    @Override
    public T last() {
        return (T)ParIterableLike.last$(this);
    }

    @Override
    public Option<T> lastOption() {
        return ParIterableLike.lastOption$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable init() {
        return ParIterableLike.init$(this);
    }

    @Override
    public scala.collection.parallel.ParIterable par() {
        return ParIterableLike.par$(this);
    }

    @Override
    public boolean isStrictSplitterCollection() {
        return ParIterableLike.isStrictSplitterCollection$(this);
    }

    @Override
    public <S, That> Combiner<S, That> reuse(Option<Combiner<S, That>> oldc, Combiner<S, That> newc) {
        return ParIterableLike.reuse$(this, oldc, newc);
    }

    @Override
    public <R, Tp> ParIterableLike.TaskOps<R, Tp> task2ops(ParIterableLike.StrictSplitterCheckTask<R, Tp> tsk) {
        return ParIterableLike.task2ops$(this, tsk);
    }

    @Override
    public <R> ParIterableLike.NonDivisible<R> wrap(Function0<R> body) {
        return ParIterableLike.wrap$(this, body);
    }

    @Override
    public <PI extends DelegatedSignalling> ParIterableLike.SignallingOps<PI> delegatedSignalling2ops(PI it) {
        return ParIterableLike.delegatedSignalling2ops$(this, it);
    }

    @Override
    public <Elem, To> ParIterableLike.BuilderOps<Elem, To> builder2ops(Builder<Elem, To> cb) {
        return ParIterableLike.builder2ops$(this, cb);
    }

    @Override
    public <S, That> CanBuildFrom<ArraySeq<T>, S, That> bf2seq(CanBuildFrom<ParArray<T>, S, That> bf) {
        return ParIterableLike.bf2seq$(this, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable sequentially(Function1 b) {
        return ParIterableLike.sequentially$(this, b);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return ParIterableLike.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return ParIterableLike.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return ParIterableLike.mkString$(this);
    }

    @Override
    public boolean canEqual(Object other) {
        return ParIterableLike.canEqual$(this, other);
    }

    @Override
    public <U> U reduce(Function2<U, U, U> op) {
        return (U)ParIterableLike.reduce$(this, op);
    }

    @Override
    public <U> Option<U> reduceOption(Function2<U, U, U> op) {
        return ParIterableLike.reduceOption$(this, op);
    }

    @Override
    public <U> U fold(U z, Function2<U, U, U> op) {
        return (U)ParIterableLike.fold$(this, z, op);
    }

    @Override
    public <S> S aggregate(Function0<S> z, Function2<S, T, S> seqop, Function2<S, S, S> combop) {
        return (S)ParIterableLike.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <S> S foldLeft(S z, Function2<S, T, S> op) {
        return (S)ParIterableLike.foldLeft$(this, z, op);
    }

    @Override
    public <S> S foldRight(S z, Function2<T, S, S> op) {
        return (S)ParIterableLike.foldRight$(this, z, op);
    }

    @Override
    public <U> U reduceLeft(Function2<U, T, U> op) {
        return (U)ParIterableLike.reduceLeft$(this, op);
    }

    @Override
    public <U> U reduceRight(Function2<T, U, U> op) {
        return (U)ParIterableLike.reduceRight$(this, op);
    }

    @Override
    public <U> Option<U> reduceLeftOption(Function2<U, T, U> op) {
        return ParIterableLike.reduceLeftOption$(this, op);
    }

    @Override
    public <U> Option<U> reduceRightOption(Function2<T, U, U> op) {
        return ParIterableLike.reduceRightOption$(this, op);
    }

    @Override
    public <U> void foreach(Function1<T, U> f) {
        ParIterableLike.foreach$(this, f);
    }

    @Override
    public int count(Function1<T, Object> p) {
        return ParIterableLike.count$(this, p);
    }

    @Override
    public <U> U sum(Numeric<U> num) {
        return (U)ParIterableLike.sum$(this, num);
    }

    @Override
    public <U> U product(Numeric<U> num) {
        return (U)ParIterableLike.product$(this, num);
    }

    @Override
    public <U> T min(Ordering<U> ord) {
        return (T)ParIterableLike.min$(this, ord);
    }

    @Override
    public <U> T max(Ordering<U> ord) {
        return (T)ParIterableLike.max$(this, ord);
    }

    @Override
    public <S> T maxBy(Function1<T, S> f, Ordering<S> cmp) {
        return (T)ParIterableLike.maxBy$(this, f, cmp);
    }

    @Override
    public <S> T minBy(Function1<T, S> f, Ordering<S> cmp) {
        return (T)ParIterableLike.minBy$(this, f, cmp);
    }

    @Override
    public <S, That> That collect(PartialFunction<T, S> pf, CanBuildFrom<ParArray<T>, S, That> bf) {
        return (That)ParIterableLike.collect$(this, pf, bf);
    }

    @Override
    public <S, That> That flatMap(Function1<T, GenTraversableOnce<S>> f, CanBuildFrom<ParArray<T>, S, That> bf) {
        return (That)ParIterableLike.flatMap$(this, f, bf);
    }

    @Override
    public boolean forall(Function1<T, Object> p) {
        return ParIterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<T, Object> p) {
        return ParIterableLike.exists$(this, p);
    }

    @Override
    public Option<T> find(Function1<T, Object> p) {
        return ParIterableLike.find$(this, p);
    }

    @Override
    public CombinerFactory<T, ParArray<T>> combinerFactory() {
        return ParIterableLike.combinerFactory$(this);
    }

    @Override
    public <S, That> CombinerFactory<S, That> combinerFactory(Function0<Combiner<S, That>> cbf) {
        return ParIterableLike.combinerFactory$(this, cbf);
    }

    @Override
    public scala.collection.parallel.ParIterable withFilter(Function1 pred) {
        return ParIterableLike.withFilter$(this, pred);
    }

    @Override
    public scala.collection.parallel.ParIterable filter(Function1 pred) {
        return ParIterableLike.filter$(this, pred);
    }

    @Override
    public scala.collection.parallel.ParIterable filterNot(Function1 pred) {
        return ParIterableLike.filterNot$(this, pred);
    }

    @Override
    public <U, That> That $plus$plus(GenTraversableOnce<U> that, CanBuildFrom<ParArray<T>, U, That> bf) {
        return (That)ParIterableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public Tuple2<ParArray<T>, ParArray<T>> partition(Function1<T, Object> pred) {
        return ParIterableLike.partition$(this, pred);
    }

    @Override
    public <K> ParMap<K, ParArray<T>> groupBy(Function1<T, K> f) {
        return ParIterableLike.groupBy$(this, f);
    }

    @Override
    public scala.collection.parallel.ParIterable take(int n) {
        return ParIterableLike.take$(this, n);
    }

    @Override
    public scala.collection.parallel.ParIterable drop(int n) {
        return ParIterableLike.drop$(this, n);
    }

    @Override
    public scala.collection.parallel.ParIterable slice(int unc_from, int unc_until) {
        return ParIterableLike.slice$(this, unc_from, unc_until);
    }

    @Override
    public Tuple2<ParArray<T>, ParArray<T>> splitAt(int n) {
        return ParIterableLike.splitAt$(this, n);
    }

    @Override
    public <S, That> That scanLeft(S z, Function2<S, T, S> op, CanBuildFrom<ParArray<T>, S, That> bf) {
        return (That)ParIterableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <S, That> That scanRight(S z, Function2<T, S, S> op, CanBuildFrom<ParArray<T>, S, That> bf) {
        return (That)ParIterableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public scala.collection.parallel.ParIterable takeWhile(Function1 pred) {
        return ParIterableLike.takeWhile$(this, pred);
    }

    @Override
    public Tuple2<ParArray<T>, ParArray<T>> span(Function1<T, Object> pred) {
        return ParIterableLike.span$(this, pred);
    }

    @Override
    public scala.collection.parallel.ParIterable dropWhile(Function1 pred) {
        return ParIterableLike.dropWhile$(this, pred);
    }

    @Override
    public <U> void copyToArray(Object xs) {
        ParIterableLike.copyToArray$(this, xs);
    }

    @Override
    public <U> void copyToArray(Object xs, int start) {
        ParIterableLike.copyToArray$(this, xs, start);
    }

    @Override
    public <U> void copyToArray(Object xs, int start, int len) {
        ParIterableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public <U, That> That zipWithIndex(CanBuildFrom<ParArray<T>, Tuple2<U, Object>, That> bf) {
        return (That)ParIterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <S, U, That> That zipAll(GenIterable<S> that, U thisElem, S thatElem, CanBuildFrom<ParArray<T>, Tuple2<U, S>, That> bf) {
        return (That)ParIterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <U, That> That toParCollection(Function0<Combiner<U, That>> cbf) {
        return (That)ParIterableLike.toParCollection$(this, cbf);
    }

    @Override
    public <K, V, That> That toParMap(Function0<Combiner<Tuple2<K, V>, That>> cbf, Predef$.less.colon.less<T, Tuple2<K, V>> ev) {
        return (That)ParIterableLike.toParMap$(this, cbf, ev);
    }

    @Override
    public <U> Object toArray(ClassTag<U> evidence$1) {
        return ParIterableLike.toArray$(this, evidence$1);
    }

    @Override
    public List<T> toList() {
        return ParIterableLike.toList$(this);
    }

    @Override
    public IndexedSeq<T> toIndexedSeq() {
        return ParIterableLike.toIndexedSeq$(this);
    }

    @Override
    public Stream<T> toStream() {
        return ParIterableLike.toStream$(this);
    }

    @Override
    public Iterator<T> toIterator() {
        return ParIterableLike.toIterator$(this);
    }

    @Override
    public <U> Buffer<U> toBuffer() {
        return ParIterableLike.toBuffer$(this);
    }

    @Override
    public GenTraversable<T> toTraversable() {
        return ParIterableLike.toTraversable$(this);
    }

    @Override
    public <U> ParSet<U> toSet() {
        return ParIterableLike.toSet$(this);
    }

    @Override
    public <K, V> ParMap<K, V> toMap(Predef$.less.colon.less<T, Tuple2<K, V>> ev) {
        return ParIterableLike.toMap$(this, ev);
    }

    @Override
    public Vector<T> toVector() {
        return ParIterableLike.toVector$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, T, Col> cbf) {
        return (Col)ParIterableLike.to$(this, cbf);
    }

    @Override
    public int scanBlockSize() {
        return ParIterableLike.scanBlockSize$(this);
    }

    @Override
    public <S> S $div$colon(S z, Function2<S, T, S> op) {
        return (S)ParIterableLike.$div$colon$(this, z, op);
    }

    @Override
    public <S> S $colon$bslash(S z, Function2<T, S, S> op) {
        return (S)ParIterableLike.$colon$bslash$(this, z, op);
    }

    @Override
    public String debugInformation() {
        return ParIterableLike.debugInformation$(this);
    }

    @Override
    public Seq<String> brokenInvariants() {
        return ParIterableLike.brokenInvariants$(this);
    }

    @Override
    public ArrayBuffer<String> debugBuffer() {
        return ParIterableLike.debugBuffer$(this);
    }

    @Override
    public void debugclear() {
        ParIterableLike.debugclear$(this);
    }

    @Override
    public ArrayBuffer<String> debuglog(String s) {
        return ParIterableLike.debuglog$(this, s);
    }

    @Override
    public void printDebugBuffer() {
        ParIterableLike.printDebugBuffer$(this);
    }

    @Override
    public Combiner<T, ParArray<T>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public Builder<T, ParArray<T>> newBuilder() {
        return GenericParTemplate.newBuilder$(this);
    }

    @Override
    public Combiner<T, ParArray<T>> newCombiner() {
        return GenericParTemplate.newCombiner$(this);
    }

    @Override
    public <B> Combiner<B, ParArray<B>> genericBuilder() {
        return GenericParTemplate.genericBuilder$(this);
    }

    @Override
    public <B> Combiner<B, ParArray<B>> genericCombiner() {
        return GenericParTemplate.genericCombiner$(this);
    }

    @Override
    public <A1, A2> Tuple2<ParArray<A1>, ParArray<A2>> unzip(Function1<T, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<ParArray<A1>, ParArray<A2>, ParArray<A3>> unzip3(Function1<T, Tuple3<A1, A2, A3>> asTriple) {
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
    public <B, That> That union(GenSeq<B> that, CanBuildFrom<ParArray<T>, B, That> bf) {
        return (That)GenSeqLike.union$(this, that, bf);
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
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    public ParArray$ParArrayIterator$ ParArrayIterator() {
        if (this.ParArrayIterator$module == null) {
            this.ParArrayIterator$lzycompute$1();
        }
        return this.ParArrayIterator$module;
    }

    @Override
    public TaskSupport scala$collection$parallel$ParIterableLike$$_tasksupport() {
        return this.scala$collection$parallel$ParIterableLike$$_tasksupport;
    }

    @Override
    public void scala$collection$parallel$ParIterableLike$$_tasksupport_$eq(TaskSupport x$1) {
        this.scala$collection$parallel$ParIterableLike$$_tasksupport = x$1;
    }

    @Override
    public ParIterableLike$ScanNode$ ScanNode() {
        if (this.ScanNode$module == null) {
            this.ScanNode$lzycompute$1();
        }
        return this.ScanNode$module;
    }

    @Override
    public ParIterableLike$ScanLeaf$ ScanLeaf() {
        if (this.ScanLeaf$module == null) {
            this.ScanLeaf$lzycompute$1();
        }
        return this.ScanLeaf$module;
    }

    public ArraySeq<T> arrayseq() {
        return this.arrayseq;
    }

    public Object[] scala$collection$parallel$mutable$ParArray$$array() {
        return this.scala$collection$parallel$mutable$ParArray$$array;
    }

    private void scala$collection$parallel$mutable$ParArray$$array_$eq(Object[] x$1) {
        this.scala$collection$parallel$mutable$ParArray$$array = x$1;
    }

    @Override
    public GenericCompanion<ParArray> companion() {
        return ParArray$.MODULE$;
    }

    @Override
    public T apply(int i) {
        return (T)this.scala$collection$parallel$mutable$ParArray$$array()[i];
    }

    @Override
    public void update(int i, T elem) {
        this.scala$collection$parallel$mutable$ParArray$$array()[i] = elem;
    }

    @Override
    public int length() {
        return this.arrayseq().length();
    }

    @Override
    public ArraySeq<T> seq() {
        return this.arrayseq();
    }

    public ParArrayIterator splitter() {
        return new ParArrayIterator(this, this.ParArrayIterator().$lessinit$greater$default$1(), this.ParArrayIterator().$lessinit$greater$default$2(), this.ParArrayIterator().$lessinit$greater$default$3());
    }

    private <S, That> boolean buildsArray(Builder<S, That> c) {
        return c instanceof ResizableParArrayCombiner;
    }

    @Override
    public <S, That> That map(Function1<T, S> f, CanBuildFrom<ParArray<T>, S, That> bf) {
        if (this.buildsArray(bf.apply((ParArray<T>)this.repr()))) {
            ArraySeq targarrseq = new ArraySeq(this.length());
            Object[] targetarr = targarrseq.array();
            this.tasksupport().executeAndWaitResult(new Map<S>(this, f, targetarr, 0, this.length()));
            return (That)new ParArray(targarrseq);
        }
        if (this.builder2ops(bf.apply((ParArray<T>)this.repr())).isCombiner()) {
            return (That)this.tasksupport().executeAndWaitResult(this.task2ops(new ParIterableLike.Map(this, f, this.combinerFactory(() -> ParIterableLike.$anonfun$map$1(this, bf)), this.splitter())).mapResult(ParIterableLike::$anonfun$map$2));
        }
        return package$.MODULE$.setTaskSupport(this.seq().map(f, this.bf2seq(bf)), this.tasksupport());
    }

    @Override
    public <U, That> That scan(U z, Function2<U, U, U> op, CanBuildFrom<ParArray<T>, U, That> cbf) {
        if (this.tasksupport().parallelismLevel() > 1 && this.buildsArray(cbf.apply((ParArray<T>)this.repr()))) {
            ArraySeq targarrseq = new ArraySeq(this.length() + 1);
            Object[] targetarr = targarrseq.array();
            targetarr[0] = z;
            if (this.length() > 0) {
                this.tasksupport().executeAndWaitResult(this.task2ops(new ParIterableLike.CreateScanTree<U>(this, 0, this.size(), z, op, this.splitter())).mapResult((Function1<ParIterableLike.ScanTree, Object> & java.io.Serializable & Serializable)tree -> {
                    this.tasksupport().executeAndWaitResult(new ScanToArray<Object>(this, (ParIterableLike.ScanTree<Object>)tree, z, op, targetarr));
                    return BoxedUnit.UNIT;
                }));
            }
            return (That)new ParArray(targarrseq);
        }
        if (this.builder2ops(cbf.apply((ParArray<T>)this.repr())).isCombiner()) {
            if (this.tasksupport().parallelismLevel() > 1) {
                if (this.size() > 0) {
                    return (That)this.tasksupport().executeAndWaitResult(this.task2ops(new ParIterableLike.CreateScanTree<U>(this, 0, this.size(), z, op, this.splitter())).mapResult(arg_0 -> ParIterableLike.$anonfun$scan$1(this, z, op, cbf, arg_0)));
                }
                return package$.MODULE$.setTaskSupport(cbf.apply((ParArray<T>)this.repr()).$plus$eq(z).result(), this.tasksupport());
            }
            return package$.MODULE$.setTaskSupport(this.seq().scan(z, op, this.bf2seq(cbf)), this.tasksupport());
        }
        return package$.MODULE$.setTaskSupport(this.seq().scan(z, op, this.bf2seq(cbf)), this.tasksupport());
    }

    private void writeObject(ObjectOutputStream out) {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) {
        in.defaultReadObject();
        this.scala$collection$parallel$mutable$ParArray$$array_$eq(this.arrayseq().array());
    }

    private final void ParArrayIterator$lzycompute$1() {
        synchronized (this) {
            if (this.ParArrayIterator$module == null) {
                this.ParArrayIterator$module = new ParArray$ParArrayIterator$(this);
            }
            return;
        }
    }

    private final void ScanNode$lzycompute$1() {
        synchronized (this) {
            if (this.ScanNode$module == null) {
                this.ScanNode$module = new ParIterableLike$ScanNode$(this);
            }
            return;
        }
    }

    private final void ScanLeaf$lzycompute$1() {
        synchronized (this) {
            if (this.ScanLeaf$module == null) {
                this.ScanLeaf$module = new ParIterableLike$ScanLeaf$(this);
            }
            return;
        }
    }

    public static final /* synthetic */ void $anonfun$scan$1(ParArray $this, Object z$1, Function2 op$1, Object[] targetarr$1, ParIterableLike.ScanTree tree) {
        $this.tasksupport().executeAndWaitResult(new ScanToArray<Object>($this, tree, z$1, op$1, targetarr$1));
    }

    public ParArray(ArraySeq<T> arrayseq) {
        this.arrayseq = arrayseq;
        GenTraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        GenSeqLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        GenIterable.$init$(this);
        GenSeq.$init$(this);
        GenericParTemplate.$init$(this);
        CustomParallelizable.$init$(this);
        ParIterableLike.$init$(this);
        scala.collection.parallel.ParIterable.$init$(this);
        ParIterable.$init$(this);
        ParSeqLike.$init$(this);
        ParSeq.$init$(this);
        scala.collection.parallel.mutable.ParSeq.$init$(this);
        this.scala$collection$parallel$mutable$ParArray$$array = arrayseq.array();
    }

    public ParArray(int sz) {
        Predef$.MODULE$.require(sz >= 0);
        this(new ArraySeq(sz));
    }

    public class Map<S>
    implements Task<BoxedUnit, Map<S>> {
        private final Function1<T, S> f;
        private final Object[] targetarr;
        private final int offset;
        private final int howmany;
        private BoxedUnit result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParArray $outer;

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void merge(Object that) {
            Task.merge$(this, that);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<BoxedUnit> lastres) {
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
        public void signalAbort() {
            Task.signalAbort$(this);
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
        public void result() {
        }

        @Override
        public void result_$eq(BoxedUnit x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<BoxedUnit> prev) {
            Object[] tarr = this.targetarr;
            Object[] sarr = this.scala$collection$parallel$mutable$ParArray$Map$$$outer().scala$collection$parallel$mutable$ParArray$$array();
            int until = this.offset + this.howmany;
            for (int i = this.offset; i < until; ++i) {
                tarr[i] = this.f.apply(sarr[i]);
            }
        }

        public List<Map<S>> split() {
            int fp = this.howmany / 2;
            return new $colon$colon<Nothing$>((Nothing$)((Object)new Map<S>(this.scala$collection$parallel$mutable$ParArray$Map$$$outer(), this.f, this.targetarr, this.offset, fp)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new Map<S>(this.scala$collection$parallel$mutable$ParArray$Map$$$outer(), this.f, this.targetarr, this.offset + fp, this.howmany - fp)), Nil$.MODULE$));
        }

        @Override
        public boolean shouldSplitFurther() {
            return this.howmany > package$.MODULE$.thresholdFromSize(this.scala$collection$parallel$mutable$ParArray$Map$$$outer().length(), this.scala$collection$parallel$mutable$ParArray$Map$$$outer().tasksupport().parallelismLevel());
        }

        public /* synthetic */ ParArray scala$collection$parallel$mutable$ParArray$Map$$$outer() {
            return this.$outer;
        }

        public Map(ParArray $outer, Function1<T, S> f, Object[] targetarr, int offset, int howmany) {
            this.f = f;
            this.targetarr = targetarr;
            this.offset = offset;
            this.howmany = howmany;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            this.result = BoxedUnit.UNIT;
        }
    }

    public class ParArrayIterator
    implements SeqSplitter<T> {
        private int i;
        private final int until;
        private final Object[] arr;
        private Signalling signalDelegate;
        public final /* synthetic */ ParArray $outer;

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
        public <S> boolean corresponds(Function2<T, S, Object> corr, Iterator<S> that) {
            return AugmentedSeqIterator.corresponds$(this, corr, that);
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
        public <S> boolean shouldSplitFurther(scala.collection.parallel.ParIterable<S> coll, int parallelismLevel) {
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
        public <U> U reduce(Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduce$(this, op);
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
        public <U> U reduceLeft(int howmany, Function2<U, U, U> op) {
            return (U)AugmentedIterableIterator.reduceLeft$(this, howmany, op);
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
        public boolean contains(Object elem) {
            return Iterator.contains$(this, elem);
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
        public BufferedIterator<T> buffered() {
            return Iterator.buffered$(this);
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
        public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<T, Tuple2<T, U>> ev) {
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

        private /* synthetic */ Combiner super$reverse2combiner(Combiner cb) {
            return AugmentedSeqIterator.reverse2combiner$(this, cb);
        }

        public int i() {
            return this.i;
        }

        public void i_$eq(int x$1) {
            this.i = x$1;
        }

        public int until() {
            return this.until;
        }

        public Object[] arr() {
            return this.arr;
        }

        @Override
        public boolean hasNext() {
            return this.i() < this.until();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public T next() {
            void var1_1;
            Object elem = this.arr()[this.i()];
            this.i_$eq(this.i() + 1);
            return var1_1;
        }

        @Override
        public int remaining() {
            return this.until() - this.i();
        }

        public ParArrayIterator dup() {
            return new ParArrayIterator(this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer(), this.i(), this.until(), this.arr());
        }

        @Override
        public Seq<ParArrayIterator> psplit(Seq<Object> sizesIncomplete) {
            int left;
            IntRef traversed = IntRef.create(this.i());
            int total = BoxesRunTime.unboxToInt(sizesIncomplete.reduceLeft((JFunction2$mcIII$sp & Serializable)(B x$1, A x$2) -> x$1 + x$2));
            return (total >= (left = this.remaining()) ? sizesIncomplete : sizesIncomplete.$colon$plus(BoxesRunTime.boxToInteger(left - total), Seq$.MODULE$.canBuildFrom())).map((Function1<Object, ParArrayIterator> & java.io.Serializable & Serializable)sz -> ParArrayIterator.$anonfun$psplit$2(this, traversed, BoxesRunTime.unboxToInt(sz)), Seq$.MODULE$.canBuildFrom());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Seq<ParArrayIterator> split() {
            int left = this.remaining();
            if (left >= 2) {
                void var3_3;
                int splitpoint = left / 2;
                $colon$colon<Nothing$> sq = new $colon$colon<Nothing$>((Nothing$)((Object)new ParArrayIterator(this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer(), this.i(), this.i() + splitpoint, this.arr())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new ParArrayIterator(this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer(), this.i() + splitpoint, this.until(), this.arr())), Nil$.MODULE$));
                this.i_$eq(this.until());
                return var3_3;
            }
            return new $colon$colon<Nothing$>((Nothing$)((Object)this), Nil$.MODULE$);
        }

        @Override
        public String toString() {
            return new java.lang.StringBuilder(20).append("ParArrayIterator(").append(this.i()).append(", ").append(this.until()).append(")").toString();
        }

        @Override
        public <U> void foreach(Function1<T, U> f) {
            int n = this.i();
            int foreach_quick_ntil = this.until();
            Object[] foreach_quick_a = this.arr();
            for (void foreach_quick_j = foreach_quick_from; foreach_quick_j < foreach_quick_ntil; ++foreach_quick_j) {
                f.apply(foreach_quick_a[foreach_quick_j]);
            }
            this.i_$eq(this.until());
        }

        private <U> void foreach_quick(Function1<T, U> f, Object[] a, int ntil, int from) {
            for (int j = from; j < ntil; ++j) {
                f.apply(a[j]);
            }
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int count(Function1<T, Object> p) {
            void var2_2;
            int c = this.count_quick(p, this.arr(), this.until(), this.i());
            this.i_$eq(this.until());
            return (int)var2_2;
        }

        private int count_quick(Function1<T, Object> p, Object[] a, int ntil, int from) {
            int cnt = 0;
            for (int j = from; j < ntil; ++j) {
                if (!BoxesRunTime.unboxToBoolean(p.apply(a[j]))) continue;
                ++cnt;
            }
            return cnt;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <S> S foldLeft(S z, Function2<S, T, S> op) {
            void var6_6;
            void foldLeft_quick_ntil;
            int n = this.until();
            Object[] foldLeft_quick_a = this.arr();
            S foldLeft_quick_sum = z;
            for (int foldLeft_quick_j = this.i(); foldLeft_quick_j < foldLeft_quick_ntil; ++foldLeft_quick_j) {
                foldLeft_quick_sum = op.apply(foldLeft_quick_sum, foldLeft_quick_a[foldLeft_quick_j]);
            }
            this.i_$eq(this.until());
            return var6_6;
        }

        private <S> S foldLeft_quick(Object[] a, int ntil, Function2<S, T, S> op, S z) {
            S sum = z;
            for (int j = this.i(); j < ntil; ++j) {
                sum = op.apply(sum, a[j]);
            }
            return sum;
        }

        @Override
        public <U> U fold(U z, Function2<U, U, U> op) {
            return this.foldLeft((S)z, (Function2)op);
        }

        @Override
        public <S> S aggregate(Function0<S> z, Function2<S, T, S> seqop, Function2<S, S, S> combop) {
            return this.foldLeft(z.apply(), seqop);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <U> U sum(Numeric<U> num) {
            void var2_2;
            U s = this.sum_quick(num, this.arr(), this.until(), this.i(), num.zero());
            this.i_$eq(this.until());
            return var2_2;
        }

        private <U> U sum_quick(Numeric<U> num, Object[] a, int ntil, int from, U zero) {
            Object sum = zero;
            for (int j = from; j < ntil; ++j) {
                sum = num.plus(sum, a[j]);
            }
            return sum;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <U> U product(Numeric<U> num) {
            void var2_2;
            U p = this.product_quick(num, this.arr(), this.until(), this.i(), num.one());
            this.i_$eq(this.until());
            return var2_2;
        }

        private <U> U product_quick(Numeric<U> num, Object[] a, int ntil, int from, U one) {
            Object prod = one;
            for (int j = from; j < ntil; ++j) {
                prod = num.times(prod, a[j]);
            }
            return prod;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean forall(Function1<T, Object> p) {
            void var2_2;
            if (this.isAborted()) {
                return false;
            }
            boolean all = true;
            while (this.i() < this.until()) {
                int nextuntil = this.i() + package$.MODULE$.CHECK_RATE() > this.until() ? this.until() : this.i() + package$.MODULE$.CHECK_RATE();
                all = this.forall_quick(p, this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().scala$collection$parallel$mutable$ParArray$$array(), nextuntil, this.i());
                if (all) {
                    this.i_$eq(nextuntil);
                } else {
                    this.i_$eq(this.until());
                    this.abort();
                }
                if (!this.isAborted()) continue;
                return false;
            }
            return (boolean)var2_2;
        }

        private boolean forall_quick(Function1<T, Object> p, Object[] a, int nextuntil, int start) {
            for (int j = start; j < nextuntil; ++j) {
                if (BoxesRunTime.unboxToBoolean(p.apply(a[j]))) {
                    continue;
                }
                return false;
            }
            return true;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean exists(Function1<T, Object> p) {
            void var2_2;
            if (this.isAborted()) {
                return true;
            }
            boolean some = false;
            while (this.i() < this.until()) {
                int nextuntil = this.i() + package$.MODULE$.CHECK_RATE() > this.until() ? this.until() : this.i() + package$.MODULE$.CHECK_RATE();
                some = this.exists_quick(p, this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().scala$collection$parallel$mutable$ParArray$$array(), nextuntil, this.i());
                if (some) {
                    this.i_$eq(this.until());
                    this.abort();
                } else {
                    this.i_$eq(nextuntil);
                }
                if (!this.isAborted()) continue;
                return true;
            }
            return (boolean)var2_2;
        }

        private boolean exists_quick(Function1<T, Object> p, Object[] a, int nextuntil, int start) {
            for (int j = start; j < nextuntil; ++j) {
                if (!BoxesRunTime.unboxToBoolean(p.apply(a[j]))) continue;
                return true;
            }
            return false;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Option<T> find(Function1<T, Object> p) {
            void var2_2;
            if (this.isAborted()) {
                return None$.MODULE$;
            }
            Option r = None$.MODULE$;
            while (this.i() < this.until()) {
                int nextuntil = this.i() + package$.MODULE$.CHECK_RATE() < this.until() ? this.i() + package$.MODULE$.CHECK_RATE() : this.until();
                Option option = r = this.find_quick(p, this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().scala$collection$parallel$mutable$ParArray$$array(), nextuntil, this.i());
                None$ none$ = None$.MODULE$;
                if (option == null ? none$ != null : !option.equals(none$)) {
                    this.i_$eq(this.until());
                    this.abort();
                } else {
                    this.i_$eq(nextuntil);
                }
                if (!this.isAborted()) continue;
                return r;
            }
            return var2_2;
        }

        private Option<T> find_quick(Function1<T, Object> p, Object[] a, int nextuntil, int start) {
            for (int j = start; j < nextuntil; ++j) {
                Object elem = a[j];
                if (!BoxesRunTime.unboxToBoolean(p.apply(elem))) continue;
                return new Some<Object>(elem);
            }
            return None$.MODULE$;
        }

        public ParArrayIterator drop(int n) {
            this.i_$eq(this.i() + n);
            return this;
        }

        @Override
        public <U> void copyToArray(Object array, int from, int len) {
            int n = this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().length() - this.i();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int n2 = RichInt$.MODULE$.min$extension(n, len);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int totallen = RichInt$.MODULE$.min$extension(n2, ScalaRunTime$.MODULE$.array_length(array) - from);
            Array$.MODULE$.copy(this.arr(), this.i(), array, from, totallen);
            this.i_$eq(this.i() + totallen);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int prefixLength(Function1<T, Object> pred) {
            void var2_2;
            int r = this.prefixLength_quick(pred, this.arr(), this.until(), this.i());
            this.i_$eq(this.i() + (r + 1));
            return (int)var2_2;
        }

        private int prefixLength_quick(Function1<T, Object> pred, Object[] a, int ntil, int startpos) {
            int j = startpos;
            int endpos = ntil;
            while (j < endpos) {
                if (BoxesRunTime.unboxToBoolean(pred.apply(a[j]))) {
                    ++j;
                    continue;
                }
                endpos = j;
            }
            return endpos - startpos;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int indexWhere(Function1<T, Object> pred) {
            void var3_3;
            int r = this.indexWhere_quick(pred, this.arr(), this.until(), this.i());
            int ret = r != -1 ? r - this.i() : r;
            this.i_$eq(this.until());
            return (int)var3_3;
        }

        private int indexWhere_quick(Function1<T, Object> pred, Object[] a, int ntil, int from) {
            int j = from;
            int pos = -1;
            while (j < ntil) {
                if (BoxesRunTime.unboxToBoolean(pred.apply(a[j]))) {
                    pos = j;
                    j = ntil;
                    continue;
                }
                ++j;
            }
            return pos;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public int lastIndexWhere(Function1<T, Object> pred) {
            void var3_3;
            int r = this.lastIndexWhere_quick(pred, this.arr(), this.i(), this.until());
            int ret = r != -1 ? r - this.i() : r;
            this.i_$eq(this.until());
            return (int)var3_3;
        }

        private int lastIndexWhere_quick(Function1<T, Object> pred, Object[] a, int from, int ntil) {
            int pos = -1;
            int j = ntil - 1;
            while (j >= from) {
                if (BoxesRunTime.unboxToBoolean(pred.apply(a[j]))) {
                    pos = j;
                    j = -1;
                    continue;
                }
                --j;
            }
            return pos;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public boolean sameElements(Iterator<?> that) {
            void var2_2;
            boolean same = true;
            while (this.i() < this.until() && that.hasNext()) {
                if (!BoxesRunTime.equals(this.arr()[this.i()], that.next())) {
                    this.i_$eq(this.until());
                    same = false;
                }
                this.i_$eq(this.i() + 1);
            }
            return (boolean)var2_2;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <S, That> Combiner<S, That> map2combiner(Function1<T, S> f, Combiner<S, That> cb) {
            void map2combiner_quick_ntil;
            cb.sizeHint(this.remaining());
            int n = this.i();
            int n2 = this.until();
            Object[] map2combiner_quick_a = this.arr();
            for (void map2combiner_quick_j = map2combiner_quick_from; map2combiner_quick_j < map2combiner_quick_ntil; ++map2combiner_quick_j) {
                cb.$plus$eq(f.apply(map2combiner_quick_a[map2combiner_quick_j]));
            }
            this.i_$eq(this.until());
            return cb;
        }

        private <S, That> void map2combiner_quick(Function1<T, S> f, Object[] a, Builder<S, That> cb, int ntil, int from) {
            for (int j = from; j < ntil; ++j) {
                cb.$plus$eq(f.apply(a[j]));
            }
        }

        @Override
        public <S, That> Combiner<S, That> collect2combiner(PartialFunction<T, S> pf, Combiner<S, That> cb) {
            this.collect2combiner_quick(pf, this.arr(), cb, this.until(), this.i());
            this.i_$eq(this.until());
            return cb;
        }

        private <S, That> void collect2combiner_quick(PartialFunction<T, S> pf, Object[] a, Builder<S, That> cb, int ntil, int from) {
            Function1 runWith = pf.runWith((Function1<Object, Builder> & java.io.Serializable & Serializable)b -> cb.$plus$eq((Object)b));
            for (int j = from; j < ntil; ++j) {
                Object curr = a[j];
                runWith.apply(curr);
            }
        }

        @Override
        public <S, That> Combiner<S, That> flatmap2combiner(Function1<T, GenTraversableOnce<S>> f, Combiner<S, That> cb) {
            while (this.i() < this.until()) {
                GenTraversableOnce<S> traversable = f.apply(this.arr()[this.i()]);
                if (traversable instanceof Iterable) {
                    cb.$plus$plus$eq(((Iterable)traversable).iterator());
                } else {
                    cb.$plus$plus$eq(traversable.seq());
                }
                this.i_$eq(this.i() + 1);
            }
            return cb;
        }

        @Override
        public <U, This> Combiner<U, This> filter2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            this.filter2combiner_quick(pred, cb, this.arr(), this.until(), this.i());
            this.i_$eq(this.until());
            return cb;
        }

        private <U, This> void filter2combiner_quick(Function1<T, Object> pred, Builder<U, This> cb, Object[] a, int ntil, int from) {
            for (int j = this.i(); j < ntil; ++j) {
                Object curr = a[j];
                if (!BoxesRunTime.unboxToBoolean(pred.apply(curr))) continue;
                cb.$plus$eq((U)curr);
            }
        }

        @Override
        public <U, This> Combiner<U, This> filterNot2combiner(Function1<T, Object> pred, Combiner<U, This> cb) {
            this.filterNot2combiner_quick(pred, cb, this.arr(), this.until(), this.i());
            this.i_$eq(this.until());
            return cb;
        }

        private <U, This> void filterNot2combiner_quick(Function1<T, Object> pred, Builder<U, This> cb, Object[] a, int ntil, int from) {
            for (int j = this.i(); j < ntil; ++j) {
                Object curr = a[j];
                if (BoxesRunTime.unboxToBoolean(pred.apply(curr))) continue;
                cb.$plus$eq((U)curr);
            }
        }

        @Override
        public <U, Coll, Bld extends Builder<U, Coll>> Bld copy2builder(Bld cb) {
            cb.sizeHint(this.remaining());
            this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().builder2ops(cb).ifIs((Function1<ResizableParArrayCombiner, Object> & java.io.Serializable & Serializable)pac -> {
                ParArrayIterator.$anonfun$copy2builder$1(this, pac);
                return BoxedUnit.UNIT;
            }).otherwise((JFunction0$mcV$sp & Serializable)() -> this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().builder2ops(cb).ifIs((Function1<UnrolledParArrayCombiner, Object> & java.io.Serializable & Serializable)pac -> {
                ParArrayIterator.$anonfun$copy2builder$3(this, pac);
                return BoxedUnit.UNIT;
            }).otherwise((JFunction0$mcV$sp & Serializable)() -> {
                this.copy2builder_quick(cb, this.arr(), this.until(), this.i());
                this.i_$eq(this.until());
            }, ClassTag$.MODULE$.apply(UnrolledParArrayCombiner.class)), ClassTag$.MODULE$.apply(ResizableParArrayCombiner.class));
            return cb;
        }

        private <U, Coll> void copy2builder_quick(Builder<U, Coll> b, Object[] a, int ntil, int from) {
            for (int j = from; j < ntil; ++j) {
                b.$plus$eq((U)a[j]);
            }
        }

        @Override
        public <U, This> Tuple2<Combiner<U, This>, Combiner<U, This>> partition2combiners(Function1<T, Object> pred, Combiner<U, This> btrue, Combiner<U, This> bfalse) {
            this.partition2combiners_quick(pred, btrue, bfalse, this.arr(), this.until(), this.i());
            this.i_$eq(this.until());
            return new Tuple2<Combiner<U, This>, Combiner<U, This>>(btrue, bfalse);
        }

        private <U, This> void partition2combiners_quick(Function1<T, Object> p, Builder<U, This> btrue, Builder<U, This> bfalse, Object[] a, int ntil, int from) {
            for (int j = from; j < ntil; ++j) {
                Object curr = a[j];
                if (BoxesRunTime.unboxToBoolean(p.apply(curr))) {
                    btrue.$plus$eq((U)curr);
                    continue;
                }
                bfalse.$plus$eq((U)curr);
            }
        }

        @Override
        public <U, This> Combiner<U, This> take2combiner(int n, Combiner<U, This> cb) {
            cb.sizeHint(n);
            int ntil = this.i() + n;
            Object[] a = this.arr();
            while (this.i() < ntil) {
                cb.$plus$eq((U)a[this.i()]);
                this.i_$eq(this.i() + 1);
            }
            return cb;
        }

        @Override
        public <U, This> Combiner<U, This> drop2combiner(int n, Combiner<U, This> cb) {
            this.drop(n);
            cb.sizeHint(this.remaining());
            while (this.i() < this.until()) {
                cb.$plus$eq((U)this.arr()[this.i()]);
                this.i_$eq(this.i() + 1);
            }
            return cb;
        }

        @Override
        public <U, This> Combiner<U, This> reverse2combiner(Combiner<U, This> cb) {
            this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().builder2ops(cb).ifIs((Function1<ResizableParArrayCombiner, Object> & java.io.Serializable & Serializable)pac -> {
                ParArrayIterator.$anonfun$reverse2combiner$1(this, pac);
                return BoxedUnit.UNIT;
            }).otherwise((JFunction0$mcV$sp & Serializable)() -> this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().builder2ops(cb).ifIs((Function1<UnrolledParArrayCombiner, Object> & java.io.Serializable & Serializable)pac -> {
                ParArrayIterator.$anonfun$reverse2combiner$3(this, pac);
                return BoxedUnit.UNIT;
            }).otherwise((JFunction0$mcV$sp & Serializable)() -> this.super$reverse2combiner(cb), ClassTag$.MODULE$.apply(UnrolledParArrayCombiner.class)), ClassTag$.MODULE$.apply(ResizableParArrayCombiner.class));
            return cb;
        }

        private void reverse2combiner_quick(Object[] targ, Object[] a, int targfrom, int srcfrom, int srcuntil) {
            int j = srcfrom;
            int k = targfrom + srcuntil - srcfrom - 1;
            while (j < srcuntil) {
                targ[k] = a[j];
                ++j;
                --k;
            }
        }

        @Override
        public <U, A> void scanToArray(U z, Function2<U, U, U> op, Object destarr, int from) {
            this.scanToArray_quick(this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer().scala$collection$parallel$mutable$ParArray$$array(), (Object[])destarr, op, z, this.i(), this.until(), from);
            this.i_$eq(this.until());
        }

        public <U> void scanToArray_quick(Object[] srcarr, Object[] destarr, Function2<U, U, U> op, U z, int srcfrom, int srcntil, int destfrom) {
            U last = z;
            int j = srcfrom;
            int k = destfrom;
            while (j < srcntil) {
                last = op.apply(last, srcarr[j]);
                destarr[k] = last;
                ++j;
                ++k;
            }
        }

        public /* synthetic */ ParArray scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ ParArrayIterator $anonfun$psplit$2(ParArrayIterator $this, IntRef traversed$1, int sz) {
            if (traversed$1.elem < $this.until()) {
                int end;
                int start = traversed$1.elem;
                int n = traversed$1.elem + sz;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                traversed$1.elem = end = RichInt$.MODULE$.min$extension(n, $this.until());
                return new ParArrayIterator($this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer(), start, end, $this.arr());
            }
            return new ParArrayIterator($this.scala$collection$parallel$mutable$ParArray$ParArrayIterator$$$outer(), traversed$1.elem, traversed$1.elem, $this.arr());
        }

        public static final /* synthetic */ void $anonfun$copy2builder$1(ParArrayIterator $this, ResizableParArrayCombiner pac) {
            Object[] targetarr = ((ExposedArrayBuffer)pac.lastbuff()).internalArray();
            Array$.MODULE$.copy($this.arr(), $this.i(), targetarr, ((SeqLike)pac.lastbuff()).size(), $this.until() - $this.i());
            ((ExposedArrayBuffer)pac.lastbuff()).setInternalSize($this.remaining());
        }

        public static final /* synthetic */ void $anonfun$copy2builder$3(ParArrayIterator $this, UnrolledParArrayCombiner pac) {
            Object[] targetarr = (Object[])pac.buff().lastPtr().array();
            Array$.MODULE$.copy($this.arr(), $this.i(), targetarr, 0, $this.until() - $this.i());
            pac.buff().size_$eq(pac.buff().size() + $this.until() - $this.i());
            pac.buff().lastPtr().size_$eq($this.until() - $this.i());
        }

        public static final /* synthetic */ void $anonfun$reverse2combiner$1(ParArrayIterator $this, ResizableParArrayCombiner pac) {
            int sz = $this.remaining();
            pac.sizeHint(sz);
            Object[] targetarr = ((ExposedArrayBuffer)pac.lastbuff()).internalArray();
            $this.reverse2combiner_quick(targetarr, $this.arr(), 0, $this.i(), $this.until());
            ((ExposedArrayBuffer)pac.lastbuff()).setInternalSize(sz);
        }

        public static final /* synthetic */ void $anonfun$reverse2combiner$3(ParArrayIterator $this, UnrolledParArrayCombiner pac) {
            int sz = $this.remaining();
            pac.sizeHint(sz);
            Object[] targetarr = (Object[])pac.buff().lastPtr().array();
            $this.reverse2combiner_quick(targetarr, $this.arr(), 0, $this.i(), $this.until());
            pac.buff().size_$eq(pac.buff().size() + sz);
            pac.buff().lastPtr().size_$eq(sz);
        }

        public ParArrayIterator(ParArray $outer, int i, int until, Object[] arr) {
            this.i = i;
            this.until = until;
            this.arr = arr;
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
        }
    }

    public class ScanToArray<U>
    implements Task<BoxedUnit, ScanToArray<U>> {
        private final ParIterableLike.ScanTree<U> tree;
        private final U z;
        private final Function2<U, U, U> op;
        private final Object[] targetarr;
        private BoxedUnit result;
        private volatile Throwable throwable;
        public final /* synthetic */ ParArray $outer;

        @Override
        public Object repr() {
            return Task.repr$(this);
        }

        @Override
        public void merge(Object that) {
            Task.merge$(this, that);
        }

        @Override
        public void forwardThrowable() {
            Task.forwardThrowable$(this);
        }

        @Override
        public void tryLeaf(Option<BoxedUnit> lastres) {
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
        public void signalAbort() {
            Task.signalAbort$(this);
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
        public void result() {
        }

        @Override
        public void result_$eq(BoxedUnit x$1) {
            this.result = x$1;
        }

        @Override
        public void leaf(Option<BoxedUnit> prev) {
            this.iterate(this.tree);
        }

        private void iterate(ParIterableLike.ScanTree<U> tree) {
            ParIterableLike.ScanLeaf scanLeaf;
            boolean bl;
            while (true) {
                bl = false;
                scanLeaf = null;
                if (!(tree instanceof ParIterableLike.ScanNode)) break;
                ParIterableLike.ScanNode scanNode = (ParIterableLike.ScanNode)tree;
                ParIterableLike.ScanTree left = scanNode.left();
                ParIterableLike.ScanTree right = scanNode.right();
                this.iterate(left);
                tree = right;
            }
            if (tree instanceof ParIterableLike.ScanLeaf) {
                bl = true;
                scanLeaf = (ParIterableLike.ScanLeaf)tree;
                int from = scanLeaf.from();
                int len = scanLeaf.len();
                Option option = scanLeaf.prev();
                if (option instanceof Some) {
                    ParIterableLike.ScanLeaf prev = (ParIterableLike.ScanLeaf)((Some)option).value();
                    this.scanLeaf(this.scala$collection$parallel$mutable$ParArray$ScanToArray$$$outer().scala$collection$parallel$mutable$ParArray$$array(), this.targetarr, from, len, prev.acc());
                    return;
                }
            }
            if (bl) {
                int from = scanLeaf.from();
                int len = scanLeaf.len();
                Option option = scanLeaf.prev();
                if (None$.MODULE$.equals(option)) {
                    this.scanLeaf(this.scala$collection$parallel$mutable$ParArray$ScanToArray$$$outer().scala$collection$parallel$mutable$ParArray$$array(), this.targetarr, from, len, this.z);
                    return;
                }
            }
            throw new MatchError(tree);
        }

        private void scanLeaf(Object[] srcarr, Object[] targetarr, int from, int len, U startval) {
            int i = from;
            int until = from + len;
            U curr = startval;
            Function2<U, U, U> operation = this.op;
            while (i < until) {
                curr = operation.apply(curr, srcarr[i]);
                targetarr[++i] = curr;
            }
        }

        @Override
        public Seq<Task<BoxedUnit, ScanToArray<U>>> split() {
            ParIterableLike.ScanTree<U> scanTree = this.tree;
            if (!(scanTree instanceof ParIterableLike.ScanNode)) {
                throw scala.sys.package$.MODULE$.error("Can only split scan tree internal nodes.");
            }
            ParIterableLike.ScanNode scanNode = (ParIterableLike.ScanNode)scanTree;
            ParIterableLike.ScanTree left = scanNode.left();
            ParIterableLike.ScanTree right = scanNode.right();
            $colon$colon<Nothing$> $colon$colon = new $colon$colon<Nothing$>((Nothing$)((Object)new ScanToArray(this.scala$collection$parallel$mutable$ParArray$ScanToArray$$$outer(), left, this.z, this.op, this.targetarr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)new ScanToArray(this.scala$collection$parallel$mutable$ParArray$ScanToArray$$$outer(), right, this.z, this.op, this.targetarr)), Nil$.MODULE$));
            return $colon$colon;
        }

        @Override
        public boolean shouldSplitFurther() {
            boolean bl = this.tree instanceof ParIterableLike.ScanNode;
            return bl;
        }

        public /* synthetic */ ParArray scala$collection$parallel$mutable$ParArray$ScanToArray$$$outer() {
            return this.$outer;
        }

        public ScanToArray(ParArray $outer, ParIterableLike.ScanTree<U> tree, U z, Function2<U, U, U> op, Object[] targetarr) {
            this.tree = tree;
            this.z = z;
            this.op = op;
            this.targetarr = targetarr;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Task.$init$(this);
            this.result = BoxedUnit.UNIT;
        }
    }
}

