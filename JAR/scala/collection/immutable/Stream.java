/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import scala.Console$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractSeq;
import scala.collection.AbstractTraversable;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.IterableViewLike;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.SeqViewLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.SliceInterval;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.LinearSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.Stream$;
import scala.collection.immutable.Stream$Empty$;
import scala.collection.immutable.Stream$cons$;
import scala.collection.immutable.StreamIterator;
import scala.collection.immutable.StreamView;
import scala.collection.immutable.StreamViewLike;
import scala.collection.immutable.Traversable;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.LazyBuilder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSeq;
import scala.math.Integral;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0019ehAB>}\u0003C\t9\u0001C\u0004\u0002P\u0001!\t!!\u0015\t\u000f\u0005M\u0003\u0001\"\u0011\u0002V!9\u0011Q\f\u0001\u0007\u0002\u0005}\u0003bBA4\u0001\u0019\u0005\u0011\u0011\u000e\u0005\b\u0003W\u0002a\u0011AA7\u0011\u001d\ty\u0007\u0001D\t\u0003?Bq!!\u001d\u0001\t\u0003\t\u0019\bC\u0004\u0002\u0012\u0002!\t!!\u001c\t\u000f\u0005M\u0005\u0001\"\u0001\u0002\u0016\"9\u00111\u0013\u0001\u0005\u0002\u0005u\u0005bBA]\u0001\u0011\u0005\u00131\u0018\u0005\b\u0003\u0007\u0004A\u0011BAc\u0011\u001d\t\t\u000f\u0001C\u0005\u0003GDq!!=\u0001\t\u0013\t\u0019\u0010C\u0004\u0003\f\u0001!\t%!\u001c\t\u000f\t5\u0001\u0001\"\u0011\u0002`!9!q\u0002\u0001\u0005B\tE\u0001b\u0002B\u0017\u0001\u0011\u0005#q\u0006\u0005\b\u0005\u000b\u0002AQ\tB$\u0011\u001d\u0011I\u0007\u0001C#\u0005WBqAa\"\u0001\t\u000b\u0012I\tC\u0004\u0003&\u0002!)Ea*\t\u0013\t}\u0006\u0001\"\u0011\u0002\u0002\t\u0005\u0007b\u0002Bg\u0001\u0011\u0015#q\u001a\u0005\b\u0005C\u0004A\u0011\tBr\u0011\u001d\u0011Y\u000f\u0001C#\u0005[Dqa!\u0003\u0001\t\u000b\u001aY\u0001C\u0004\u0004\u001e\u0001!)ea\b\t\u000f\r-\u0002\u0001\"\u0011\u0004.!91q\u0007\u0001\u0005F\re\u0002bBB.\u0001\u0011\u00053Q\f\u0005\b\u0007_\u0002A\u0011IB9\u0011\u001d\u0019i\t\u0001C!\u0007\u001fCqa!$\u0001\t\u0003\u001a\u0019\nC\u0004\u0004\u000e\u0002!\te!&\t\u000f\ru\u0005\u0001\"\u0011\u0004 \"91\u0011\u0015\u0001\u0005B\r\r\u0006bBBU\u0001\u0011\u000531\u0016\u0005\b\u0007_\u0003AQIBY\u0011\u001d\u00199\f\u0001C!\u0007sCqaa1\u0001\t\u0003\ni\u0007C\u0004\u0004F\u0002!\tea2\t\u000f\r-\u0007\u0001\"\u0011\u0004N\"91\u0011\u001b\u0001\u0005B\rM\u0007bBBl\u0001\u0011\u00053\u0011\u001c\u0005\b\u0007;\u0004A\u0011IA7\u0011\u001d\u0019y\u000e\u0001C!\u0007CDqa!?\u0001\t\u0003\ni\u0007C\u0004\u0004|\u0002!\te!@\t\u000f\u0011=\u0001\u0001\"\u0011\u0005\u0012!9Aq\u0004\u0001\u0005B\u0011\u0005\u0002b\u0002C\u0019\u0001\u0011\u0005C1G\u0004\b\rod\b\u0012\u0001C#\r\u0019YH\u0010#\u0001\u0005<!9\u0011q\n\u001c\u0005\u0002\u0011\rcA\u0002C$m\u0001!I\u0005C\u0004\u0002Pa\"\t\u0001\"\u0018\t\u000f\u0011\u0005d\u0007b\u0001\u0005d!AAQ\u000f\u001c!\u0002\u0013!9\bC\u0004\u0005zY\"\t\u0001b\u001f\u0007\r\u0011-e\u0007\u0001CG\u0011\u001d\ty%\u0010C\u0001\t;Cq\u0001\")>\t\u0003!\u0019kB\u0004\u0005&ZB\t\u0001b*\u0007\u000f\u0011%f\u0007#\u0001\u0005,\"9\u0011qJ!\u0005\u0002\u0011=\u0006bBA/\u0003\u0012\u0005\u0013q\f\u0005\b\u0003O\nE\u0011\tCY\u0011\u001d\tY'\u0011C!\tcCq!a\u001cB\t\u0003\ty\u0006C\u0005\u00054\u0006\u000b\t\u0011\"\u0003\u00056\"9AQ\u0018\u001c\u0005B\u0011}\u0006b\u0002Cem\u0011\u0005C1\u001a\u0004\u0007\t?4\u0004\u0001\"9\t\u0015\u0011\u0015(J!A%\u0002\u0013!9\u000fC\u0004\u0002P)#\t\u0001b<\t\u000f\u0011U(\n\"\u0001\u0005x\"9Qq\u0001&\u0005\u0002\u0015%\u0001bBC\fm\u0011\rQ\u0011D\u0004\b\tk4\u0004\u0012AC\u0016\r\u001d)iC\u000eE\u0001\u000b_Aq!a\u0014R\t\u0003)\t\u0004C\u0004\u00064E#\t!\"\u000e\b\u000f\u0015%c\u0007#\u0001\u0006L\u00199QQ\n\u001c\t\u0002\u0015=\u0003bBA(+\u0012\u0005Q\u0011\u000b\u0005\b\t\u0013,F\u0011AC*\u0011\u001d)\u0019$\u0016C\u0001\u000bK2a\u0001\"\u000f7\u0005\u0019=\u0006BCC\u00033\n\u0005\t\u0015!\u0003\u00076\"QAQ]-\u0003\u0002\u0013\u0006IA\"/\t\u000f\u0005=\u0013\f\"\u0001\u0007<\"9\u0011QL-\u0005B\u0005}\u0003bBA43\u0012\u0005c1\u0019\u0005\f\r\u000bL\u0006\u0019!A!B\u00131\u0019\f\u0003\u0005\u0007Pf\u0003\u000b\u0015\u0002Di\u0011\u001d\ty'\u0017C\u0001\u0003?Bq!a\u001bZ\t\u00032I\u000eC\u0004\u0007\\f#\tE\"8\t\u000f\u0015Ud\u0007\"\u0001\u0006x!9QQ\u000f\u001c\u0005B\u0015%\u0005bBB_m\u0011\u0005QQ\u0014\u0005\b\u0007{3D\u0011ACT\u0011\u001d)YK\u000eC\u0001\u000b[Cq!b/7\t\u0003*i\fC\u0004\u0006PZ\"\t%\"5\t\u000f\u0015\rh\u0007\"\u0011\u0006f\"Aa1\u0002\u001c\u0005\u0002q4i\u0001\u0003\u0005\u0007\"Y\"\t\u0001 D\u0012\r\u001d1\u0019E\u000e\u0002}\r\u000bB!B\"\u0015o\u0005\u0003%\u000b\u0011\u0002D*\u0011)\u0011)M\u001cB\u0001B\u0003%aQ\u000b\u0005\b\u0003\u001frG\u0011\u0001D,\u0011%1yF\u001ca\u0001\n\u00131\t\u0007C\u0005\u0007d9\u0004\r\u0011\"\u0003\u0007f!Aa1\u000e8!B\u00131y\u0005\u0003\u0006\u0007n9D)\u0019!C\u0005\rCBqA!\u001bo\t\u00031y\u0007C\u0004\u0003&:$\tA\"\"\t\u000f\t-h\u000e\"\u0001\u0007\u001e\"9!Q\u001a8\u0005\u0002\u0019%\u0006\"\u0003CZm\u0005\u0005I\u0011\u0002C[\u0005\u0019\u0019FO]3b[*\u0011QP`\u0001\nS6lW\u000f^1cY\u0016T1a`A\u0001\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0003\u0003\u0007\tQa]2bY\u0006\u001c\u0001!\u0006\u0003\u0002\n\u0005]1c\u0003\u0001\u0002\f\u0005-\u00121GA!\u0003\u0013\u0002b!!\u0004\u0002\u0010\u0005MQ\"\u0001@\n\u0007\u0005EaPA\u0006BEN$(/Y2u'\u0016\f\b\u0003BA\u000b\u0003/a\u0001\u0001\u0002\u0005\u0002\u001a\u0001!)\u0019AA\u000e\u0005\u0005\t\u0015\u0003BA\u000f\u0003K\u0001B!a\b\u0002\"5\u0011\u0011\u0011A\u0005\u0005\u0003G\t\tAA\u0004O_RD\u0017N\\4\u0011\t\u0005}\u0011qE\u0005\u0005\u0003S\t\tAA\u0002B]f\u0004b!!\f\u00020\u0005MQ\"\u0001?\n\u0007\u0005EBPA\u0005MS:,\u0017M]*fcBA\u0011QGA\u001e\u0003'\ty$\u0004\u0002\u00028)\u0019\u0011\u0011\b@\u0002\u000f\u001d,g.\u001a:jG&!\u0011QHA\u001c\u0005i9UM\\3sS\u000e$&/\u0019<feN\f'\r\\3UK6\u0004H.\u0019;f!\r\ti\u0003\u0001\t\t\u0003\u001b\t\u0019%a\u0005\u0002H%\u0019\u0011Q\t@\u0003%1Kg.Z1s'\u0016\fx\n\u001d;j[&TX\r\u001a\t\u0006\u0003[\u0001\u00111\u0003\t\u0005\u0003?\tY%\u0003\u0003\u0002N\u0005\u0005!\u0001D*fe&\fG.\u001b>bE2,\u0017A\u0002\u001fj]&$h\b\u0006\u0002\u0002H\u0005I1m\\7qC:LwN\\\u000b\u0003\u0003/\u0002b!!\u000e\u0002Z\u0005}\u0012\u0002BA.\u0003o\u0011\u0001cR3oKJL7mQ8na\u0006t\u0017n\u001c8\u0002\u000f%\u001cX)\u001c9usV\u0011\u0011\u0011\r\t\u0005\u0003?\t\u0019'\u0003\u0003\u0002f\u0005\u0005!a\u0002\"p_2,\u0017M\\\u0001\u0005Q\u0016\fG-\u0006\u0002\u0002\u0014\u0005!A/Y5m+\t\t9%A\u0006uC&dG)\u001a4j]\u0016$\u0017AB1qa\u0016tG-\u0006\u0003\u0002v\u0005mD\u0003BA<\u0003\u0003\u0003R!!\f\u0001\u0003s\u0002B!!\u0006\u0002|\u00119\u0011QP\u0004C\u0002\u0005}$!\u0001\"\u0012\t\u0005M\u0011Q\u0005\u0005\t\u0003\u0007;A\u00111\u0001\u0002\u0006\u0006!!/Z:u!\u0019\ty\"a\"\u0002\f&!\u0011\u0011RA\u0001\u0005!a$-\u001f8b[\u0016t\u0004CBA\u0007\u0003\u001b\u000bI(C\u0002\u0002\u0010z\u0014q\u0002\u0016:bm\u0016\u00148/\u00192mK>s7-Z\u0001\u0006M>\u00148-Z\u0001\u0006aJLg\u000e\u001e\u000b\u0003\u0003/\u0003B!a\b\u0002\u001a&!\u00111TA\u0001\u0005\u0011)f.\u001b;\u0015\t\u0005]\u0015q\u0014\u0005\b\u0003CS\u0001\u0019AAR\u0003\r\u0019X\r\u001d\t\u0005\u0003K\u000b\u0019L\u0004\u0003\u0002(\u0006=\u0006\u0003BAU\u0003\u0003i!!a+\u000b\t\u00055\u0016QA\u0001\u0007yI|w\u000e\u001e \n\t\u0005E\u0016\u0011A\u0001\u0007!J,G-\u001a4\n\t\u0005U\u0016q\u0017\u0002\u0007'R\u0014\u0018N\\4\u000b\t\u0005E\u0016\u0011A\u0001\u0007Y\u0016tw\r\u001e5\u0016\u0005\u0005u\u0006\u0003BA\u0010\u0003\u007fKA!!1\u0002\u0002\t\u0019\u0011J\u001c;\u0002\r\u0005\u001cH\u000b[1u+\u0011\t9-a3\u0015\t\u0005%\u0017q\u001a\t\u0005\u0003+\tY\rB\u0004\u0002N2\u0011\r!a\u0007\u0003\tQC\u0017\r\u001e\u0005\b\u0003#d\u0001\u0019AAj\u0003\u0005A\b\u0003BA\u0010\u0003+LA!a6\u0002\u0002\t1\u0011I\\=SK\u001aD3\u0001DAn!\u0011\ty\"!8\n\t\u0005}\u0017\u0011\u0001\u0002\u0007S:d\u0017N\\3\u0002\u0011\u0005\u001c8\u000b\u001e:fC6,B!!:\u0002lR!\u0011q]Aw!\u0015\ti\u0003AAu!\u0011\t)\"a;\u0005\u000f\u0005uTB1\u0001\u0002\u001c!9\u0011\u0011[\u0007A\u0002\u0005M\u0007fA\u0007\u0002\\\u0006y\u0011n]*ue\u0016\fWNQ;jY\u0012,'/\u0006\u0004\u0002v\n\r!q\u0001\u000b\u0005\u0003C\n9\u0010C\u0004\u0002z:\u0001\r!a?\u0002\u0005\t4\u0007CCA\u001b\u0003{\f9E!\u0001\u0003\u0006%!\u0011q`A\u001c\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u0011\t)Ba\u0001\u0005\u000f\u0005udB1\u0001\u0002\u001cA!\u0011Q\u0003B\u0004\t\u001d\tiM\u0004b\u0001\u00037A3ADAn\u0003!!xn\u0015;sK\u0006l\u0017a\u00045bg\u0012+g-\u001b8ji\u0016\u001c\u0016N_3\u0002\u0015\u0011\u0002H.^:%a2,8/\u0006\u0004\u0003\u0014\t\u0005\"\u0011\u0004\u000b\u0005\u0005+\u0011\u0019\u0003\u0006\u0003\u0003\u0018\tm\u0001\u0003BA\u000b\u00053!q!!4\u0012\u0005\u0004\tY\u0002C\u0004\u0002zF\u0001\u001dA!\b\u0011\u0015\u0005U\u0012Q`A$\u0005?\u00119\u0002\u0005\u0003\u0002\u0016\t\u0005BaBA?#\t\u0007\u0011q\u0010\u0005\b\u0005K\t\u0002\u0019\u0001B\u0014\u0003\u0011!\b.\u0019;\u0011\r\u00055!\u0011\u0006B\u0010\u0013\r\u0011YC \u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-A\u0006%a2,8\u000fJ2pY>tWC\u0002B\u0019\u0005\u007f\u00119\u0004\u0006\u0003\u00034\t\u0005C\u0003\u0002B\u001b\u0005s\u0001B!!\u0006\u00038\u00119\u0011Q\u001a\nC\u0002\u0005m\u0001bBA}%\u0001\u000f!1\b\t\u000b\u0003k\ti0a\u0012\u0003>\tU\u0002\u0003BA\u000b\u0005\u007f!q!! \u0013\u0005\u0004\ty\bC\u0004\u0003DI\u0001\rA!\u0010\u0002\t\u0015dW-\\\u0001\tg\u000e\fg\u000eT3giV1!\u0011\nB-\u0005#\"BAa\u0013\u0003fQ!!Q\nB.)\u0011\u0011yEa\u0015\u0011\t\u0005U!\u0011\u000b\u0003\b\u0003\u001b\u001c\"\u0019AA\u000e\u0011\u001d\tIp\u0005a\u0002\u0005+\u0002\"\"!\u000e\u0002~\u0006\u001d#q\u000bB(!\u0011\t)B!\u0017\u0005\u000f\u0005u4C1\u0001\u0002\u001c!9!QL\nA\u0002\t}\u0013AA8q!)\tyB!\u0019\u0003X\u0005M!qK\u0005\u0005\u0005G\n\tAA\u0005Gk:\u001cG/[8oe!9!qM\nA\u0002\t]\u0013!\u0001>\u0002\u00075\f\u0007/\u0006\u0004\u0003n\tm$1\u000f\u000b\u0005\u0005_\u0012i\b\u0006\u0003\u0003r\tU\u0004\u0003BA\u000b\u0005g\"q!!4\u0015\u0005\u0004\tY\u0002C\u0004\u0002zR\u0001\u001dAa\u001e\u0011\u0015\u0005U\u0012Q`A$\u0005s\u0012\t\b\u0005\u0003\u0002\u0016\tmDaBA?)\t\u0007\u00111\u0004\u0005\b\u0005\u007f\"\u0002\u0019\u0001BA\u0003\u00051\u0007\u0003CA\u0010\u0005\u0007\u000b\u0019B!\u001f\n\t\t\u0015\u0015\u0011\u0001\u0002\n\rVt7\r^5p]F\nqaY8mY\u0016\u001cG/\u0006\u0004\u0003\f\ne%\u0011\u0013\u000b\u0005\u0005\u001b\u0013Y\n\u0006\u0003\u0003\u0010\nM\u0005\u0003BA\u000b\u0005##q!!4\u0016\u0005\u0004\tY\u0002C\u0004\u0002zV\u0001\u001dA!&\u0011\u0015\u0005U\u0012Q`A$\u0005/\u0013y\t\u0005\u0003\u0002\u0016\teEaBA?+\t\u0007\u00111\u0004\u0005\b\u0005;+\u0002\u0019\u0001BP\u0003\t\u0001h\r\u0005\u0005\u0002 \t\u0005\u00161\u0003BL\u0013\u0011\u0011\u0019+!\u0001\u0003\u001fA\u000b'\u000f^5bY\u001a+hn\u0019;j_:\fqA\u001a7bi6\u000b\u0007/\u0006\u0004\u0003*\n]&q\u0016\u000b\u0005\u0005W\u0013I\f\u0006\u0003\u0003.\nE\u0006\u0003BA\u000b\u0005_#q!!4\u0017\u0005\u0004\tY\u0002C\u0004\u0002zZ\u0001\u001dAa-\u0011\u0015\u0005U\u0012Q`A$\u0005k\u0013i\u000b\u0005\u0003\u0002\u0016\t]FaBA?-\t\u0007\u00111\u0004\u0005\b\u0005\u007f2\u0002\u0019\u0001B^!!\tyBa!\u0002\u0014\tu\u0006CBA\u0007\u0005S\u0011),\u0001\u0006gS2$XM]%na2$b!a\u0012\u0003D\n%\u0007b\u0002Bc/\u0001\u0007!qY\u0001\u0002aBA\u0011q\u0004BB\u0003'\t\t\u0007C\u0004\u0003L^\u0001\r!!\u0019\u0002\u0013%\u001ch\t\\5qa\u0016$\u0017AC<ji\"4\u0015\u000e\u001c;feR!!\u0011\u001bBl!!\t)Da5\u0002\u0014\u0005\u001d\u0013\u0002\u0002Bk\u0003o\u0011QBR5mi\u0016\u0014Xj\u001c8bI&\u001c\u0007b\u0002Bc1\u0001\u0007!q\u0019\u0015\u00041\tm\u0007\u0003BA\u0010\u0005;LAAa8\u0002\u0002\tAan\\5oY&tW-\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\u0011)\u000f\u0005\u0004\u0002\u000e\t\u001d\u00181C\u0005\u0004\u0005St(\u0001C%uKJ\fGo\u001c:\u0002\u000f\u0019|'/Z1dQV!!q\u001eB|)\u0011\t9J!=\t\u000f\t}$\u00041\u0001\u0003tBA\u0011q\u0004BB\u0003'\u0011)\u0010\u0005\u0003\u0002\u0016\t]Ha\u0002B}5\t\u0007\u00111\u0004\u0002\u0002+\"\u001a!D!@\u0011\t\t}8QA\u0007\u0003\u0007\u0003QAaa\u0001\u0002\u0002\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\r\u001d1\u0011\u0001\u0002\bi\u0006LGN]3d\u0003!1w\u000e\u001c3MK\u001a$X\u0003BB\u0007\u0007'!Baa\u0004\u0004\u001aQ!1\u0011CB\u000b!\u0011\t)ba\u0005\u0005\u000f\u0005u4D1\u0001\u0002\u001c!9!QL\u000eA\u0002\r]\u0001CCA\u0010\u0005C\u001a\t\"a\u0005\u0004\u0012!9!qM\u000eA\u0002\rE\u0001fA\u000e\u0003~\u0006Q!/\u001a3vG\u0016dUM\u001a;\u0016\t\r\u00052Q\u0005\u000b\u0005\u0007G\u00199\u0003\u0005\u0003\u0002\u0016\r\u0015BaBA?9\t\u0007\u0011q\u0010\u0005\b\u0005\u007fb\u0002\u0019AB\u0015!)\tyB!\u0019\u0004$\u0005M11E\u0001\na\u0006\u0014H/\u001b;j_:$Baa\f\u00046AA\u0011qDB\u0019\u0003\u000f\n9%\u0003\u0003\u00044\u0005\u0005!A\u0002+va2,'\u0007C\u0004\u0003Fv\u0001\rAa2\u0002\u0007iL\u0007/\u0006\u0005\u0004<\r-3\u0011KB!)\u0011\u0019ida\u0015\u0015\t\r}21\t\t\u0005\u0003+\u0019\t\u0005B\u0004\u0002Nz\u0011\r!a\u0007\t\u000f\u0005eh\u0004q\u0001\u0004FAQ\u0011QGA\u007f\u0003\u000f\u001a9ea\u0010\u0011\u0011\u0005}1\u0011GB%\u0007\u001f\u0002B!!\u0006\u0004L\u001191Q\n\u0010C\u0002\u0005}$AA!2!\u0011\t)b!\u0015\u0005\u000f\u0005udD1\u0001\u0002\u001c!9!Q\u0005\u0010A\u0002\rU\u0003CBA\u0007\u0007/\u001ay%C\u0002\u0004Zy\u00141bR3o\u0013R,'/\u00192mK\u0006a!0\u001b9XSRD\u0017J\u001c3fqV11qLB7\u0007G\"Ba!\u0019\u0004fA!\u0011QCB2\t\u001d\tim\bb\u0001\u00037Aq!!? \u0001\b\u00199\u0007\u0005\u0006\u00026\u0005u\u0018qIB5\u0007C\u0002\u0002\"a\b\u00042\r-\u0014Q\u0018\t\u0005\u0003+\u0019i\u0007B\u0004\u0004N}\u0011\r!a \u0002\u0013\u0005$Gm\u0015;sS:<GCCB:\u0007\u007f\u001a\u0019ia\"\u0004\nB!1QOB>\u001b\t\u00199HC\u0002\u0004zy\fq!\\;uC\ndW-\u0003\u0003\u0004~\r]$!D*ue&twMQ;jY\u0012,'\u000fC\u0004\u0004\u0002\u0002\u0002\raa\u001d\u0002\u0003\tDqa!\"!\u0001\u0004\t\u0019+A\u0003ti\u0006\u0014H\u000fC\u0004\u0002\"\u0002\u0002\r!a)\t\u000f\r-\u0005\u00051\u0001\u0002$\u0006\u0019QM\u001c3\u0002\u00115\\7\u000b\u001e:j]\u001e$B!a)\u0004\u0012\"9\u0011\u0011U\u0011A\u0002\u0005\rVCAAR)!\t\u0019ka&\u0004\u001a\u000em\u0005bBBCG\u0001\u0007\u00111\u0015\u0005\b\u0003C\u001b\u0003\u0019AAR\u0011\u001d\u0019Yi\ta\u0001\u0003G\u000b\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0003G\u000bqa\u001d9mSR\fE\u000f\u0006\u0003\u00040\r\u0015\u0006bBBTK\u0001\u0007\u0011QX\u0001\u0002]\u0006!A/Y6f)\u0011\t9e!,\t\u000f\r\u001df\u00051\u0001\u0002>\u0006!AM]8q)\u0011\t9ea-\t\u000f\r\u001dv\u00051\u0001\u0002>\"\u001aqE!@\u0002\u000bMd\u0017nY3\u0015\r\u0005\u001d31XB`\u0011\u001d\u0019i\f\u000ba\u0001\u0003{\u000bAA\u001a:p[\"91\u0011\u0019\u0015A\u0002\u0005u\u0016!B;oi&d\u0017\u0001B5oSR\f\u0011\u0002^1lKJKw\r\u001b;\u0015\t\u0005\u001d3\u0011\u001a\u0005\b\u0007OS\u0003\u0019AA_\u0003%!'o\u001c9SS\u001eDG\u000f\u0006\u0003\u0002H\r=\u0007bBBTW\u0001\u0007\u0011QX\u0001\ni\u0006\\Wm\u00165jY\u0016$B!a\u0012\u0004V\"9!Q\u0019\u0017A\u0002\t\u001d\u0017!\u00033s_B<\u0006.\u001b7f)\u0011\t9ea7\t\u000f\t\u0015W\u00061\u0001\u0003H\u0006AA-[:uS:\u001cG/A\u0003qC\u0012$v.\u0006\u0004\u0004d\u000eE8\u0011\u001e\u000b\u0007\u0007K\u001c\u0019pa>\u0015\t\r\u001d81\u001e\t\u0005\u0003+\u0019I\u000fB\u0004\u0002N>\u0012\r!a\u0007\t\u000f\u0005ex\u0006q\u0001\u0004nBQ\u0011QGA\u007f\u0003\u000f\u001ayoa:\u0011\t\u0005U1\u0011\u001f\u0003\b\u0003{z#\u0019AA@\u0011\u001d\u0019)p\fa\u0001\u0003{\u000b1\u0001\\3o\u0011\u001d\u0011\u0019e\fa\u0001\u0007_\fqA]3wKJ\u001cX-A\u0004gY\u0006$H/\u001a8\u0016\t\r}HQ\u0001\u000b\u0005\t\u0003!9\u0001E\u0003\u0002.\u0001!\u0019\u0001\u0005\u0003\u0002\u0016\u0011\u0015AaBA?c\t\u0007\u00111\u0004\u0005\b\t\u0013\t\u00049\u0001C\u0006\u00035\t7\u000f\u0016:bm\u0016\u00148/\u00192mKBA\u0011q\u0004BB\u0003'!i\u0001\u0005\u0004\u0002\u000e\t%B1A\u0001\u0005m&,w/\u0006\u0002\u0005\u0014I1AQCAj\t31a\u0001b\u00063\u0001\u0011M!\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004\u0003CA\u0017\t7\t\u0019\"a\u0012\n\u0007\u0011uAP\u0001\u0006TiJ,\u0017-\u001c,jK^\fAb\u001d;sS:<\u0007K]3gSb,\"\u0001b\t\u0011\t\u0011\u0015BqF\u0007\u0003\tOQA\u0001\"\u000b\u0005,\u0005!A.\u00198h\u0015\t!i#\u0001\u0003kCZ\f\u0017\u0002BA[\tO\ta!Z9vC2\u001cH\u0003BA1\tkAqA!\n5\u0001\u0004\t)#K\u0002\u00013\u0006\u0013AaQ8ogN)a\u0007\"\u0010\u0002JA1\u0011Q\u0007C \u0003\u007fIA\u0001\"\u0011\u00028\tQ1+Z9GC\u000e$xN]=\u0015\u0005\u0011\u0015\u0003cAA\u0017m\t\u00112\u000b\u001e:fC6\u001c\u0015M\u001c\"vS2$gI]8n+\u0011!Y\u0005b\u0017\u0014\u0007a\"i\u0005\u0005\u0004\u0005P\u0011EC\u0011L\u0007\u0002m%!A1\u000bC+\u0005M9UM\\3sS\u000e\u001c\u0015M\u001c\"vS2$gI]8n\u0013\u0011!9&a\u000e\u0003+\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK\u001a\u000b7\r^8ssB!\u0011Q\u0003C.\t\u001d\tI\u0002\u000fb\u0001\u00037!\"\u0001b\u0018\u0011\u000b\u0011=\u0003\b\"\u0017\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\t\u0011\u0015D\u0011O\u000b\u0003\tO\u0002\"\"!\u000e\u0002~\u0012%Dq\u000eC:!\u0011!y\u0005b\u001b\n\t\u00115\u0014\u0011\f\u0002\u0005\u0007>dG\u000e\u0005\u0003\u0002\u0016\u0011EDaBA\ru\t\u0007\u00111\u0004\t\u0006\u0003[\u0001AqN\u0001\f%\u0016,8/\u00192mK\u000e\u0013e\tE\u0003\u0005Pa\n)#\u0001\u0006oK^\u0014U/\u001b7eKJ,B\u0001\" \u0005\bV\u0011Aq\u0010\t\t\u0007k\"\t\t\"\"\u0005\n&!A1QB<\u0005\u001d\u0011U/\u001b7eKJ\u0004B!!\u0006\u0005\b\u00129\u0011\u0011\u0004\u001fC\u0002\u0005m\u0001#BA\u0017\u0001\u0011\u0015%!D*ue\u0016\fWNQ;jY\u0012,'/\u0006\u0003\u0005\u0010\u0012e5cA\u001f\u0005\u0012BA1Q\u000fCJ\t/#Y*\u0003\u0003\u0005\u0016\u000e]$a\u0003'buf\u0014U/\u001b7eKJ\u0004B!!\u0006\u0005\u001a\u00129\u0011\u0011D\u001fC\u0002\u0005m\u0001#BA\u0017\u0001\u0011]EC\u0001CP!\u0015!y%\u0010CL\u0003\u0019\u0011Xm];miR\u0011A1T\u0001\u0006\u000b6\u0004H/\u001f\t\u0004\t\u001f\n%!B#naRL8cA!\u0005.B)\u0011Q\u0006\u0001\u0002\u001eQ\u0011AqU\u000b\u0003\u0003;\t1B]3bIJ+7o\u001c7wKR\u0011Aq\u0017\t\u0005\tK!I,\u0003\u0003\u0005<\u0012\u001d\"AB(cU\u0016\u001cG/A\u0003f[B$\u00180\u0006\u0003\u0005B\u0012\u001dWC\u0001Cb!\u0015\ti\u0003\u0001Cc!\u0011\t)\u0002b2\u0005\u000f\u0005e\u0001J1\u0001\u0002\u001c\u0005)\u0011\r\u001d9msV!AQ\u001aCj)\u0011!y\r\"6\u0011\u000b\u00055\u0002\u0001\"5\u0011\t\u0005UA1\u001b\u0003\b\u00033I%\u0019AA\u000e\u0011\u001d!9.\u0013a\u0001\t3\f!\u0001_:\u0011\r\u0005}A1\u001cCi\u0013\u0011!i.!\u0001\u0003\u0015q\u0012X\r]3bi\u0016$gHA\u0006D_:\u001cxK]1qa\u0016\u0014X\u0003\u0002Cr\t[\u001c2ASAj\u0003\t!H\u000e\u0005\u0004\u0002 \u0005\u001dE\u0011\u001e\t\u0006\u0003[\u0001A1\u001e\t\u0005\u0003+!i\u000fB\u0004\u0002\u001a)\u0013\r!a\u0007\u0015\t\u0011EH1\u001f\t\u0006\t\u001fRE1\u001e\u0005\t\tKdE\u00111\u0001\u0005h\u0006\tB\u0005[1tQ\u0012\u001aw\u000e\\8oI\r|Gn\u001c8\u0016\t\u0011eHq \u000b\u0005\tw,\u0019\u0001E\u0003\u0002.\u0001!i\u0010\u0005\u0003\u0002\u0016\u0011}HaBA?\u001b\n\u0007Q\u0011A\t\u0005\tW\f)\u0003C\u0004\u0006\u00065\u0003\r\u0001\"@\u0002\u0005!$\u0017a\u0006\u0013iCNDGeY8m_:$3m\u001c7p]\u0012\u001aw\u000e\\8o+\u0011)Y!\"\u0005\u0015\t\u00155Q1\u0003\t\u0006\u0003[\u0001Qq\u0002\t\u0005\u0003+)\t\u0002B\u0004\u0002~9\u0013\r!\"\u0001\t\u000f\u0015Ua\n1\u0001\u0006\u000e\u00051\u0001O]3gSb\f1bY8og^\u0013\u0018\r\u001d9feV!Q1DC\u0011)\u0011)i\"b\t\u0011\u000b\u0011=#*b\b\u0011\t\u0005UQ\u0011\u0005\u0003\b\u00033y%\u0019AA\u000e\u0011!))c\u0014CA\u0002\u0015\u001d\u0012AB:ue\u0016\fW\u000e\u0005\u0004\u0002 \u0005\u001dU\u0011\u0006\t\u0006\u0003[\u0001Qq\u0004\t\u0004\t\u001f\n&!\u0005\u0013iCNDGeY8m_:$3m\u001c7p]N\u0019\u0011+a5\u0015\u0005\u0015-\u0012aB;oCB\u0004H._\u000b\u0005\u000bo)\u0019\u0005\u0006\u0003\u0006:\u0015\u001d\u0003CBA\u0010\u000bw)y$\u0003\u0003\u0006>\u0005\u0005!AB(qi&|g\u000e\u0005\u0005\u0002 \rER\u0011IC#!\u0011\t)\"b\u0011\u0005\u000f\u0005e1K1\u0001\u0002\u001cA)\u0011Q\u0006\u0001\u0006B!9Aq[*A\u0002\u0015\u0015\u0013\u0001B2p]N\u00042\u0001b\u0014V\u0005\u0011\u0019wN\\:\u0014\u0007U\u000b\u0019\u000e\u0006\u0002\u0006LU!QQKC.)\u0019)9&\"\u0018\u0006`A)AqJ-\u0006ZA!\u0011QCC.\t\u001d\tIb\u0016b\u0001\u00037Aq!\"\u0002X\u0001\u0004)I\u0006\u0003\u0005\u0005f^#\t\u0019AC1!\u0019\ty\"a\"\u0006dA)\u0011Q\u0006\u0001\u0006ZU!QqMC8)\u0011)I'b\u001d\u0011\r\u0005}Q1HC6!!\tyb!\r\u0006n\u0015E\u0004\u0003BA\u000b\u000b_\"q!!\u0007Y\u0005\u0004\tY\u0002E\u0003\u0002.\u0001)i\u0007C\u0004\u0005Xb\u0003\r!\"\u001d\u0002\u000f%$XM]1uKV!Q\u0011PCA)\u0011)Y(b\"\u0015\t\u0015uT1\u0011\t\u0006\u0003[\u0001Qq\u0010\t\u0005\u0003+)\t\tB\u0004\u0002\u001a\u0011\u0014\r!a\u0007\t\u000f\t}D\r1\u0001\u0006\u0006BA\u0011q\u0004BB\u000b\u007f*y\bC\u0004\u0004\u0006\u0012\u0004\r!b \u0016\t\u0015-U1\u0013\u000b\u0007\u000b\u001b+I*b'\u0015\t\u0015=UQ\u0013\t\u0006\u0003[\u0001Q\u0011\u0013\t\u0005\u0003+)\u0019\nB\u0004\u0002\u001a\u0015\u0014\r!a\u0007\t\u000f\t}T\r1\u0001\u0006\u0018BA\u0011q\u0004BB\u000b#+\t\nC\u0004\u0004\u0006\u0016\u0004\r!\"%\t\u000f\rUX\r1\u0001\u0002>R1QqTCQ\u000bG\u0003R!!\f\u0001\u0003{Cqa!\"g\u0001\u0004\ti\fC\u0004\u0006&\u001a\u0004\r!!0\u0002\tM$X\r\u001d\u000b\u0005\u000b?+I\u000bC\u0004\u0004\u0006\u001e\u0004\r!!0\u0002\u0017\r|g\u000e^5ok\u0006dG._\u000b\u0005\u000b_+)\f\u0006\u0003\u00062\u0016]\u0006#BA\u0017\u0001\u0015M\u0006\u0003BA\u000b\u000bk#q!!\u0007i\u0005\u0004\tY\u0002\u0003\u0005\u0003D!$\t\u0019AC]!\u0019\ty\"a\"\u00064\u0006!a-\u001b7m+\u0011)y,b2\u0015\t\u0015\u0005WQ\u001a\u000b\u0005\u000b\u0007,I\rE\u0003\u0002.\u0001))\r\u0005\u0003\u0002\u0016\u0015\u001dGaBA\rS\n\u0007\u00111\u0004\u0005\t\u0005\u0007JG\u00111\u0001\u0006LB1\u0011qDAD\u000b\u000bDqaa*j\u0001\u0004\ti,\u0001\u0005uC\n,H.\u0019;f+\u0011)\u0019.b7\u0015\t\u0015UW\u0011\u001d\u000b\u0005\u000b/,i\u000eE\u0003\u0002.\u0001)I\u000e\u0005\u0003\u0002\u0016\u0015mGaBA\rU\n\u0007\u00111\u0004\u0005\b\u0005\u007fR\u0007\u0019ACp!!\tyBa!\u0002>\u0016e\u0007bBBTU\u0002\u0007\u0011QX\u0001\u0006e\u0006tw-Z\u000b\u0005\u000bO,y\u000f\u0006\u0005\u0006j\u001a\u0015aq\u0001D\u0005)\u0011)Y/b=\u0011\u000b\u00055\u0002!\"<\u0011\t\u0005UQq\u001e\u0003\b\u000bc\\'\u0019AA\u000e\u0005\u0005!\u0006\"CC{W\u0006\u0005\t9AC|\u0003))g/\u001b3f]\u000e,G%\r\t\u0007\u000bs,y0\"<\u000f\t\u0005}Q1`\u0005\u0005\u000b{\f\t!A\u0004qC\u000e\\\u0017mZ3\n\t\u0019\u0005a1\u0001\u0002\t\u0013:$Xm\u001a:bY*!QQ`A\u0001\u0011\u001d\u0019)i\u001ba\u0001\u000b[Dqaa#l\u0001\u0004)i\u000fC\u0004\u0006&.\u0004\r!\"<\u0002\u0019\u0019LG\u000e^3sK\u0012$\u0016-\u001b7\u0016\t\u0019=aQ\u0003\u000b\t\r#19Bb\u0007\u0007 A)AqJ-\u0007\u0014A!\u0011Q\u0003D\u000b\t\u001d\tI\u0002\u001cb\u0001\u00037Aq!\"\nm\u0001\u00041I\u0002E\u0003\u0002.\u00011\u0019\u0002C\u0004\u0003F2\u0004\rA\"\b\u0011\u0011\u0005}!1\u0011D\n\u0003CBqAa3m\u0001\u0004\t\t'A\u0007d_2dWm\u0019;fIR\u000b\u0017\u000e\\\u000b\t\rK1)Db\u000b\u0007BQQaq\u0005D\u0017\r_19Db\u000f\u0011\u000b\u0011=\u0013L\"\u000b\u0011\t\u0005Ua1\u0006\u0003\b\u0003{j'\u0019AA\u000e\u0011\u001d\t9'\u001ca\u0001\rSAq!\"\nn\u0001\u00041\t\u0004E\u0003\u0002.\u00011\u0019\u0004\u0005\u0003\u0002\u0016\u0019UBaBA\r[\n\u0007\u00111\u0004\u0005\b\u0005;k\u0007\u0019\u0001D\u001d!!\tyB!)\u00074\u0019%\u0002bBA}[\u0002\u0007aQ\b\t\u000b\u0003k\tiP\"\r\u0007*\u0019}\u0002\u0003BA\u000b\r\u0003\"q!!4n\u0005\u0004\tYB\u0001\tTiJ,\u0017-\\,ji\"4\u0015\u000e\u001c;feV!aq\tD''\u0015q\u00171\u001bD%!!\t)Da5\u0007L\u0019=\u0003\u0003BA\u000b\r\u001b\"q!!\u0007o\u0005\u0004\tY\u0002E\u0003\u0002.\u00011Y%\u0001\u0002tYB1\u0011qDAD\r\u001f\u0002\u0002\"a\b\u0003\u0004\u001a-\u0013\u0011\r\u000b\u0007\r32YF\"\u0018\u0011\u000b\u0011=cNb\u0013\t\u0011\u0019E\u0013\u000f\"a\u0001\r'BqA!2r\u0001\u00041)&A\u0001t+\t1y%A\u0003t?\u0012*\u0017\u000f\u0006\u0003\u0002\u0018\u001a\u001d\u0004\"\u0003D5g\u0006\u0005\t\u0019\u0001D(\u0003\rAH%M\u0001\u0003g\u0002\n\u0001BZ5mi\u0016\u0014X\rZ\u000b\u0007\rc2yHb\u001e\u0015\t\u0019Md\u0011\u0011\u000b\u0005\rk2I\b\u0005\u0003\u0002\u0016\u0019]DaBAgm\n\u0007\u00111\u0004\u0005\b\u0003s4\b9\u0001D>!)\t)$!@\u0007P\u0019udQ\u000f\t\u0005\u0003+1y\bB\u0004\u0002~Y\u0014\r!a\u0007\t\u000f\t}d\u000f1\u0001\u0007\u0004BA\u0011q\u0004BB\r\u00172i(\u0006\u0004\u0007\b\u001aUeQ\u0012\u000b\u0005\r\u001339\n\u0006\u0003\u0007\f\u001a=\u0005\u0003BA\u000b\r\u001b#q!!4x\u0005\u0004\tY\u0002C\u0004\u0002z^\u0004\u001dA\"%\u0011\u0015\u0005U\u0012Q D(\r'3Y\t\u0005\u0003\u0002\u0016\u0019UEaBA?o\n\u0007\u00111\u0004\u0005\b\u0005\u007f:\b\u0019\u0001DM!!\tyBa!\u0007L\u0019m\u0005CBA\u0007\u0005S1\u0019*\u0006\u0003\u0007 \u001a\u001dF\u0003BAL\rCCqAa y\u0001\u00041\u0019\u000b\u0005\u0005\u0002 \t\re1\nDS!\u0011\t)Bb*\u0005\u000f\te\bP1\u0001\u0002\u001cQ!a\u0011\nDV\u0011\u001d1i+\u001fa\u0001\r+\n\u0011!]\u000b\u0005\rc39lE\u0002Z\rg\u0003R!!\f\u0001\rk\u0003B!!\u0006\u00078\u0012A\u0011\u0011D-\u0005\u0006\u0004\tY\u0002\u0005\u0004\u0002 \u0005\u001de1\u0017\u000b\u0007\r{3yL\"1\u0011\u000b\u0011=\u0013L\".\t\u000f\u0015\u0015A\f1\u0001\u00076\"AAQ\u001d/\u0005\u0002\u00041I,\u0006\u0002\u00076\u0006)A\u000f\u001c,bY\"\u001aqL\"3\u0011\t\u0005}a1Z\u0005\u0005\r\u001b\f\tA\u0001\u0005w_2\fG/\u001b7f\u0003\u0015!HnR3o!\u0019\tyBb5\u00074&!aQ[A\u0001\u0005%1UO\\2uS>t\u0007\u0007K\u0002a\r\u0013,\"Ab-\u0002\u0019M\fW.Z#mK6,g\u000e^:\u0016\t\u0019}gq\u001d\u000b\u0005\u0003C2\t\u000fC\u0004\u0003&\r\u0004\rAb9\u0011\r\u000551q\u000bDs!\u0011\t)Bb:\u0005\u000f\u0005u4M1\u0001\u0007jF!aQWA\u0013Q\u001dIfQ\u001eDz\rk\u0004B!a\b\u0007p&!a\u0011_A\u0001\u0005A\u0019VM]5bYZ+'o]5p]VKE)A\u0003wC2,XM\b\u0005xJ3-B:x\u001dF\u0003\u0019\u0019FO]3b[\u0002")
public abstract class Stream<A>
extends AbstractSeq<A>
implements LinearSeq<A>,
LinearSeqOptimized<A, Stream<A>>,
Serializable {
    public static <T> Stream<T> range(T t, T t2, T t3, Integral<T> integral) {
        return Stream$.MODULE$.range((Object)t, (Object)t2, (Object)t3, (Integral)integral);
    }

    public static <A> Stream<A> tabulate(int n, Function1<Object, A> function1) {
        return Stream$.MODULE$.tabulate(n, (Function1)function1);
    }

    /*
     * WARNING - void declaration
     */
    public static <A> Stream<A> fill(int n, Function0<A> function0) {
        void fill_apply_tl;
        void fill_apply_hd;
        if (Stream$.MODULE$ == null) {
            throw null;
        }
        if (n <= 0) {
            return Stream$Empty$.MODULE$;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$fill$1(n, function0);
        A a = function0.apply();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(fill_apply_hd, (Function0<Stream<void>>)fill_apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    public static <A> Stream<A> continually(Function0<A> function0) {
        void continually_apply_tl;
        void continually_apply_hd;
        if (Stream$.MODULE$ == null) {
            throw null;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$continually$1(function0);
        A a = function0.apply();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(continually_apply_hd, (Function0<Stream<void>>)continually_apply_tl);
    }

    public static Stream<Object> from(int n) {
        return Stream$.MODULE$.from(n);
    }

    public static Stream<Object> from(int n, int n2) {
        return Stream$.MODULE$.from(n, n2);
    }

    /*
     * WARNING - void declaration
     */
    public static <A> Stream<A> iterate(A a, int n, Function1<A, A> function1) {
        void iterate_iterate_apply_tl;
        if (Stream$.MODULE$ == null) {
            throw null;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$iterate$1(function1, a);
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<A>(a, iterate_iterate_apply_tl).take(n);
    }

    /*
     * WARNING - void declaration
     */
    public static <A> Stream<A> iterate(A a, Function1<A, A> function1) {
        void iterate_apply_tl;
        if (Stream$.MODULE$ == null) {
            throw null;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$iterate$1(function1, a);
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<A>(a, iterate_apply_tl);
    }

    public static <A> ConsWrapper<A> consWrapper(Function0<Stream<A>> function0) {
        if (Stream$.MODULE$ == null) {
            throw null;
        }
        return new ConsWrapper<A>(function0);
    }

    public static <A> Stream<A> empty() {
        return Stream$.MODULE$.empty();
    }

    public static <A> CanBuildFrom<Stream<?>, A, Stream<A>> canBuildFrom() {
        return Stream$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return Stream$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Stream$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ tabulate_this = stream$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ tabulate_this = stream$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ tabulate_this = stream$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ tabulate_this = stream$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ fill_this = stream$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ fill_this = stream$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ fill_this = stream$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Stream$ stream$ = Stream$.MODULE$;
        if (stream$ == null) {
            throw null;
        }
        Stream$ fill_this = stream$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable concat(Seq seq) {
        return Stream$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Stream$.MODULE$.ReusableCBF();
    }

    @Override
    public /* synthetic */ boolean scala$collection$LinearSeqOptimized$$super$sameElements(GenIterable that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public A apply(int n) {
        return (A)LinearSeqOptimized.apply$(this, n);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return LinearSeqOptimized.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return LinearSeqOptimized.exists$(this, p);
    }

    @Override
    public <A1> boolean contains(A1 elem) {
        return LinearSeqOptimized.contains$(this, elem);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return LinearSeqOptimized.find$(this, p);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)LinearSeqOptimized.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)LinearSeqOptimized.reduceRight$(this, op);
    }

    @Override
    public A last() {
        return (A)LinearSeqOptimized.last$(this);
    }

    @Override
    public Tuple2<Stream<A>, Stream<A>> span(Function1<A, Object> p) {
        return LinearSeqOptimized.span$(this, p);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return LinearSeqOptimized.sameElements$(this, that);
    }

    @Override
    public int lengthCompare(int len) {
        return LinearSeqOptimized.lengthCompare$(this, len);
    }

    @Override
    public boolean isDefinedAt(int x) {
        return LinearSeqOptimized.isDefinedAt$(this, x);
    }

    @Override
    public int segmentLength(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.segmentLength$(this, p, from);
    }

    @Override
    public int indexWhere(Function1<A, Object> p, int from) {
        return LinearSeqOptimized.indexWhere$(this, p, from);
    }

    @Override
    public int lastIndexWhere(Function1<A, Object> p, int end) {
        return LinearSeqOptimized.lastIndexWhere$(this, p, end);
    }

    @Override
    public Iterator<Stream<A>> tails() {
        return LinearSeqOptimized.tails$(this);
    }

    @Override
    public LinearSeq<A> seq() {
        return LinearSeq.seq$(this);
    }

    @Override
    public scala.collection.LinearSeq<A> thisCollection() {
        return LinearSeqLike.thisCollection$(this);
    }

    @Override
    public scala.collection.LinearSeq toCollection(LinearSeqLike repr) {
        return LinearSeqLike.toCollection$(this, repr);
    }

    @Override
    public int hashCode() {
        return LinearSeqLike.hashCode$(this);
    }

    @Override
    public final <B> boolean corresponds(GenSeq<B> that, Function2<A, B, Object> p) {
        return LinearSeqLike.corresponds$(this, that, p);
    }

    @Override
    public scala.collection.immutable.Seq<A> toSeq() {
        return scala.collection.immutable.Seq.toSeq$(this);
    }

    @Override
    public Combiner<A, scala.collection.parallel.immutable.ParSeq<A>> parCombiner() {
        return scala.collection.immutable.Seq.parCombiner$(this);
    }

    @Override
    public GenericCompanion<Stream> companion() {
        return Stream$.MODULE$;
    }

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract A head();

    public abstract boolean tailDefined();

    /*
     * WARNING - void declaration
     */
    public <B> Stream<B> append(Function0<TraversableOnce<B>> rest) {
        void apply_tl;
        void apply_hd;
        if (this.isEmpty()) {
            return ((GenTraversableOnce)rest.apply()).toStream();
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> {
            void append_apply_tl;
            void append_apply_hd;
            Stream stream = (Stream)this.tail();
            if (stream == null) {
                throw null;
            }
            Stream append_this = stream;
            if (append_this.isEmpty()) {
                return ((GenTraversableOnce)rest.apply()).toStream();
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream.$anonfun$append$1(append_this, rest);
            Object a = append_this.head();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Cons<void>(append_apply_hd, (Function0<Stream<void>>)append_apply_tl);
        };
        A a = this.head();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    public Stream<A> force() {
        Stream these = this;
        Stream those = this;
        if (!this.isEmpty()) {
            these = (Stream)this.tail();
        }
        while (those != these) {
            if (these.isEmpty()) {
                return this;
            }
            if ((these = (Stream)these.tail()).isEmpty()) {
                return this;
            }
            if ((these = (Stream)these.tail()) == those) {
                return this;
            }
            those = (Stream)those.tail();
        }
        return this;
    }

    public void print() {
        this.print(", ");
    }

    public void print(String sep) {
        this.loop$1(this, "", sep);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public int length() {
        void var1_1;
        int len = 0;
        Stream left = this;
        while (!left.isEmpty()) {
            ++len;
            left = (Stream)left.tail();
        }
        return (int)var1_1;
    }

    private <That> That asThat(Object x) {
        return (That)x;
    }

    private <B> Stream<B> asStream(Object x) {
        return (Stream)x;
    }

    private <B, That> boolean isStreamBuilder(CanBuildFrom<Stream<A>, B, That> bf) {
        return bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder;
    }

    @Override
    public Stream<A> toStream() {
        return this;
    }

    @Override
    public boolean hasDefiniteSize() {
        block11: {
            block10: {
                boolean bl;
                if (this.isEmpty()) break block10;
                if (!this.tailDefined()) {
                    bl = false;
                } else {
                    Stream these = (Stream)this.tail();
                    for (Stream those = this; those != these; those = (Stream)those.tail()) {
                        if (these.isEmpty()) {
                            return true;
                        }
                        if (!these.tailDefined()) {
                            return false;
                        }
                        if ((these = (Stream)these.tail()).isEmpty()) {
                            return true;
                        }
                        if (!these.tailDefined()) {
                            return false;
                        }
                        if (those != (these = (Stream)these.tail())) continue;
                        return false;
                    }
                    bl = false;
                }
                if (!bl) break block11;
            }
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Stream<A>, B, That> bf) {
        if (bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder) {
            void apply_tl;
            void apply_hd;
            if (this.isEmpty()) {
                return (That)that.toStream();
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)this.tail()).$plus$plus((GenTraversableOnce<B>)that, Stream$.MODULE$.canBuildFrom());
            A a = this.head();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return (That)new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
        }
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <B, That> That $plus$colon(B elem, CanBuildFrom<Stream<A>, B, That> bf) {
        if (bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder) {
            void apply_tl;
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> this;
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return (That)new Cons<B>(elem, apply_tl);
        }
        return (That)SeqLike.$plus$colon$(this, elem, bf);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<Stream<A>, B, That> bf) {
        if (bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder) {
            void apply_tl;
            if (this.isEmpty()) {
                return (That)Stream$.MODULE$.apply((Seq)Predef$.MODULE$.genericWrapArray(new Object[]{z}));
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> {
                Object object;
                void scanLeft_z;
                void scanLeft_bf;
                Stream stream = (Stream)this.tail();
                CanBuildFrom canBuildFrom = Stream$.MODULE$.canBuildFrom();
                Object r = op.apply(z, this.head());
                if (stream == null) {
                    throw null;
                }
                Stream scanLeft_this = stream;
                if (scanLeft_bf.apply(scanLeft_this.repr()) instanceof StreamBuilder) {
                    if (scanLeft_this.isEmpty()) {
                        object = Stream$.MODULE$.apply((Seq)Predef$.MODULE$.genericWrapArray(new Object[]{scanLeft_z}));
                    } else {
                        void scanLeft_apply_tl;
                        Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream.$anonfun$scanLeft$1(scanLeft_this, op, scanLeft_z);
                        if (Stream$cons$.MODULE$ == null) {
                            throw null;
                        }
                        object = new Cons<void>(scanLeft_z, (Function0<Stream<void>>)scanLeft_apply_tl);
                    }
                } else {
                    object = TraversableLike.scanLeft$(scanLeft_this, scanLeft_z, op, (CanBuildFrom)scanLeft_bf);
                }
                return (Stream)object;
            };
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return (That)new Cons<B>(z, apply_tl);
        }
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <B, That> That map(Function1<A, B> f, CanBuildFrom<Stream<A>, B, That> bf) {
        if (bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder) {
            void apply_tl;
            void apply_hd;
            if (this.isEmpty()) {
                return (That)Stream$Empty$.MODULE$;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> {
                Object object;
                void map_bf;
                Stream stream = (Stream)this.tail();
                CanBuildFrom canBuildFrom = Stream$.MODULE$.canBuildFrom();
                if (stream == null) {
                    throw null;
                }
                Stream map_this = stream;
                if (map_bf.apply(map_this.repr()) instanceof StreamBuilder) {
                    if (map_this.isEmpty()) {
                        object = Stream$Empty$.MODULE$;
                    } else {
                        void map_apply_tl;
                        void map_apply_hd;
                        Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream.$anonfun$map$1(map_this, f);
                        Object r = f.apply(map_this.head());
                        if (Stream$cons$.MODULE$ == null) {
                            throw null;
                        }
                        object = new Cons<void>(map_apply_hd, (Function0<Stream<void>>)map_apply_tl);
                    }
                } else {
                    object = TraversableLike.map$(map_this, f, (CanBuildFrom)map_bf);
                }
                return (Stream)object;
            };
            B b = f.apply(this.head());
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return (That)new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
        }
        return (That)TraversableLike.map$(this, f, bf);
    }

    @Override
    public final <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<Stream<A>, B, That> bf) {
        if (!(bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder)) {
            return (That)TraversableLike.collect$(this, pf, bf);
        }
        Stream rest = this;
        ObjectRef<Object> newHead = ObjectRef.create(null);
        Function1<A, Object> runWith = pf.runWith((Function1<Object, Object> & java.io.Serializable & Serializable)(B b) -> {
            newHead.elem = b;
            return BoxedUnit.UNIT;
        });
        while (rest.nonEmpty() && !BoxesRunTime.unboxToBoolean(runWith.apply(rest.head()))) {
            rest = (Stream)rest.tail();
        }
        if (rest.isEmpty()) {
            return (That)Stream$Empty$.MODULE$;
        }
        return (That)Stream$.MODULE$.collectedTail(newHead.elem, rest, pf, bf);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<Stream<A>, B, That> bf) {
        if (bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder) {
            void append_apply_tl;
            void append_apply_hd;
            void append_rest;
            if (this.isEmpty()) {
                return (That)Stream$Empty$.MODULE$;
            }
            ObjectRef<Stream> nonEmptyPrefix = ObjectRef.create(this);
            Stream<B> prefix = f.apply(((Stream)nonEmptyPrefix.elem).head()).toStream();
            while (!((Stream)nonEmptyPrefix.elem).isEmpty() && prefix.isEmpty()) {
                nonEmptyPrefix.elem = (Stream)((Stream)nonEmptyPrefix.elem).tail();
                if (((Stream)nonEmptyPrefix.elem).isEmpty()) continue;
                prefix = f.apply(((Stream)nonEmptyPrefix.elem).head()).toStream();
            }
            if (((Stream)nonEmptyPrefix.elem).isEmpty()) {
                return (That)Stream$.MODULE$.empty();
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)((Stream)nonEmptyPrefix$1.elem).tail()).flatMap((Function1<A, GenTraversableOnce<B>>)f, Stream$.MODULE$.canBuildFrom());
            if (prefix == null) {
                throw null;
            }
            if (prefix.isEmpty()) {
                return (That)Stream.$anonfun$flatMap$1(this, nonEmptyPrefix, f).toStream();
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect2 = () -> Stream.$anonfun$append$1(prefix, (Function0)append_rest);
            B b = prefix.head();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return (That)new Cons<void>(append_apply_hd, (Function0<Stream<void>>)append_apply_tl);
        }
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> filterImpl(Function1<A, Object> p, boolean isFlipped) {
        Stream rest = this;
        while (!rest.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(rest.head())) == isFlipped) {
            rest = (Stream)rest.tail();
        }
        if (rest.nonEmpty()) {
            void filteredTail_apply_tl;
            void filteredTail_apply_hd;
            if (Stream$.MODULE$ == null) {
                throw null;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream$.$anonfun$filteredTail$1(rest, p, isFlipped);
            A a = rest.head();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Cons<void>(filteredTail_apply_hd, (Function0<Stream<void>>)filteredTail_apply_tl);
        }
        return Stream$Empty$.MODULE$;
    }

    @Override
    public final FilterMonadic<A, Stream<A>> withFilter(Function1<A, Object> p) {
        return new StreamWithFilter<A>((Function0<Stream> & java.io.Serializable & Serializable)() -> this, p);
    }

    @Override
    public Iterator<A> iterator() {
        return new StreamIterator(this);
    }

    @Override
    public final <U> void foreach(Function1<A, U> f) {
        while (!this_.isEmpty()) {
            f.apply(this_.head());
            Stream this_ = (Stream)this_.tail();
        }
    }

    @Override
    public final <B> B foldLeft(B z, Function2<B, A, B> op) {
        while (!this_.isEmpty()) {
            B b = op.apply(z, this_.head());
            z = b;
            Stream this_ = (Stream)this_.tail();
        }
        return z;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <B> B reduceLeft(Function2<B, A, B> f) {
        void var2_2;
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.reduceLeft");
        }
        Object reducedRes = this.head();
        Stream left = (Stream)this.tail();
        while (!left.isEmpty()) {
            reducedRes = f.apply(reducedRes, left.head());
            left = (Stream)left.tail();
        }
        return var2_2;
    }

    @Override
    public Tuple2<Stream<A>, Stream<A>> partition(Function1<A, Object> p) {
        return new Tuple2<Object, Object>(this.filter((Function1<Object, Object> & java.io.Serializable & Serializable)(T1 x$1) -> BoxesRunTime.boxToBoolean(Stream.$anonfun$partition$1(p, x$1))), this.filterNot((Function1<Object, Object> & java.io.Serializable & Serializable)(T1 x$2) -> BoxesRunTime.boxToBoolean(Stream.$anonfun$partition$2(p, x$2))));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Stream<A>, Tuple2<A1, B>, That> bf) {
        if (bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder) {
            void apply_tl;
            void apply_hd;
            if (this.isEmpty() || that.isEmpty()) {
                return (That)Stream$Empty$.MODULE$;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)this.tail()).zip((GenIterable<B>)((GenIterable)that.tail()), Stream$.MODULE$.canBuildFrom());
            Tuple2 tuple2 = new Tuple2(this.head(), that.head());
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return (That)new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
        }
        return (That)IterableLike.zip$(this, that, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<Stream<A>, Tuple2<A1, Object>, That> bf) {
        return this.zip((GenIterable<B>)Stream$.MODULE$.from(0), (CanBuildFrom)bf);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        b.append(start);
        if (!this.isEmpty()) {
            b.append(this.head());
            Stream cursor = this;
            int n = 1;
            if (this.tailDefined()) {
                Stream scout = (Stream)this.tail();
                if (scout.isEmpty()) {
                    b.append(end);
                    return b;
                }
                if (this != scout) {
                    cursor = scout;
                    if (scout.tailDefined()) {
                        scout = (Stream)scout.tail();
                        while (cursor != scout && scout.tailDefined()) {
                            b.append(sep).append(cursor.head());
                            ++n;
                            cursor = (Stream)cursor.tail();
                            if (!(scout = (Stream)scout.tail()).tailDefined()) continue;
                            scout = (Stream)scout.tail();
                        }
                    }
                }
                if (!scout.tailDefined()) {
                    while (cursor != scout) {
                        b.append(sep).append(cursor.head());
                        ++n;
                        cursor = (Stream)cursor.tail();
                    }
                    if (cursor.nonEmpty()) {
                        b.append(sep).append(cursor.head());
                    }
                } else {
                    Stream runner = this;
                    int k = 0;
                    while (runner != scout) {
                        runner = (Stream)runner.tail();
                        scout = (Stream)scout.tail();
                        ++k;
                    }
                    if (cursor == scout && k > 0) {
                        b.append(sep).append(cursor.head());
                        ++n;
                        cursor = (Stream)cursor.tail();
                    }
                    while (cursor != scout) {
                        b.append(sep).append(cursor.head());
                        ++n;
                        cursor = (Stream)cursor.tail();
                    }
                }
            }
            if (!cursor.isEmpty()) {
                if (!cursor.tailDefined()) {
                    b.append(sep).append("?");
                } else {
                    b.append(sep).append("...");
                }
            }
        }
        b.append(end);
        return b;
    }

    @Override
    public String mkString(String sep) {
        return this.mkString("", sep, "");
    }

    @Override
    public String mkString() {
        return this.mkString("");
    }

    @Override
    public String mkString(String start, String sep, String end) {
        this.force();
        return TraversableOnce.mkString$(this, start, sep, end);
    }

    @Override
    public String toString() {
        return TraversableOnce.mkString$(this, new java.lang.StringBuilder(1).append(this.stringPrefix()).append("(").toString(), ", ", ")");
    }

    @Override
    public Tuple2<Stream<A>, Stream<A>> splitAt(int n) {
        return new Tuple2<Object, Object>(this.take(n), this.drop(n));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> take(int n) {
        void apply_tl;
        void apply_hd;
        if (n <= 0 || this.isEmpty()) {
            return Stream$.MODULE$.empty();
        }
        if (n == 1) {
            void apply_tl2;
            void apply_hd2;
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> Stream$.MODULE$.empty();
            A a = this.head();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Cons<void>(apply_hd2, (Function0<Stream<void>>)apply_tl2);
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)this.tail()).take(n - 1);
        A a = this.head();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    @Override
    public final Stream<A> drop(int n) {
        while (n > 0 && !this_.isEmpty()) {
            --n;
            Stream this_ = (Stream)this_.tail();
        }
        return this_;
    }

    @Override
    public Stream<A> slice(int from, int until) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int lo = RichInt$.MODULE$.max$extension(from, 0);
        if (until <= lo || this.isEmpty()) {
            return Stream$.MODULE$.empty();
        }
        return ((Stream)this.drop(lo)).take(until - lo);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> init() {
        void apply_tl;
        void apply_hd;
        if (this.isEmpty()) {
            return (Stream)TraversableLike.init$(this);
        }
        if (((SeqLike)this.tail()).isEmpty()) {
            return Stream$Empty$.MODULE$;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)this.tail()).init();
        A a = this.head();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> takeRight(int n) {
        void var2_2;
        Stream these = this;
        Object lead = this.drop(n);
        while (!((Stream)lead).isEmpty()) {
            these = (Stream)these.tail();
            lead = (Stream)((AbstractTraversable)lead).tail();
        }
        return var2_2;
    }

    @Override
    public Stream<A> dropRight(int n) {
        if (n <= 0) {
            return this;
        }
        return this.advance$1(((AbstractTraversable)this.take(n)).toList(), Nil$.MODULE$, (Stream)this.drop(n));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> takeWhile(Function1<A, Object> p) {
        if (!this.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(this.head()))) {
            void apply_tl;
            void apply_hd;
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)this.tail()).takeWhile(p);
            A a = this.head();
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
        }
        return Stream$Empty$.MODULE$;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> dropWhile(Function1<A, Object> p) {
        void var2_2;
        Stream these = this;
        while (!these.isEmpty() && BoxesRunTime.unboxToBoolean(p.apply(these.head()))) {
            these = (Stream)these.tail();
        }
        return var2_2;
    }

    @Override
    public Stream<A> distinct() {
        return this.loop$2((Set)Set$.MODULE$.apply(Nil$.MODULE$), this);
    }

    @Override
    public <B, That> That padTo(int len, B elem, CanBuildFrom<Stream<A>, B, That> bf) {
        if (bf.apply((Stream<A>)this.repr()) instanceof StreamBuilder) {
            return (That)Stream.loop$3(len, this, elem);
        }
        return (That)SeqLike.padTo$(this, len, elem, bf);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Stream<A> reverse() {
        ObjectRef<Stream$Empty$> result2 = ObjectRef.create(Stream$Empty$.MODULE$);
        Stream these = this;
        while (!these.isEmpty()) {
            void consWrapper_stream;
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> (Stream)result$1.elem;
            if (Stream$.MODULE$ == null) {
                throw null;
            }
            Stream<A> r = new ConsWrapper(consWrapper_stream).$hash$colon$colon(these.head());
            r.tail();
            result2.elem = r;
            these = (Stream)these.tail();
        }
        return (Stream)result2.elem;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <B> Stream<B> flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
        ObjectRef<Stream> st = ObjectRef.create(this);
        while (((Stream)st.elem).nonEmpty()) {
            void consWrapper_stream;
            GenTraversableOnce<B> h = asTraversable.apply(((Stream)st.elem).head());
            if (h.isEmpty()) {
                st.elem = (Stream)((Stream)st.elem).tail();
                continue;
            }
            Stream<B> stream = h.toStream();
            Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> ((Stream)((Stream)st$1.elem).tail()).flatten(asTraversable);
            if (Stream$.MODULE$ == null) {
                throw null;
            }
            return new ConsWrapper(consWrapper_stream).$hash$colon$colon$colon(stream);
        }
        return Stream$.MODULE$.empty();
    }

    @Override
    public StreamView<A, Stream<A>> view() {
        return new StreamView<A, Stream<A>>(this){
            private Stream<A> underlying;
            private volatile boolean bitmap$0;
            private final /* synthetic */ Stream $outer;

            public <B, That> That force(CanBuildFrom<Stream<A>, B, That> bf) {
                return (That)StreamViewLike.force$(this, bf);
            }

            public <B> StreamViewLike.Transformed<B> newForced(Function0<GenSeq<B>> xs) {
                return StreamViewLike.newForced$(this, xs);
            }

            public <B> StreamViewLike.Transformed<B> newAppended(GenTraversable<B> that) {
                return StreamViewLike.newAppended$(this, that);
            }

            public <B> StreamViewLike.Transformed<B> newPrepended(GenTraversable<B> that) {
                return StreamViewLike.newPrepended$(this, that);
            }

            public <B> StreamViewLike.Transformed<B> newMapped(Function1<A, B> f) {
                return StreamViewLike.newMapped$(this, f);
            }

            public <B> StreamViewLike.Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
                return StreamViewLike.newFlatMapped$(this, f);
            }

            public StreamViewLike.Transformed<A> newFiltered(Function1<A, Object> p) {
                return StreamViewLike.newFiltered$(this, p);
            }

            public StreamViewLike.Transformed<A> newSliced(SliceInterval _endpoints) {
                return StreamViewLike.newSliced$(this, _endpoints);
            }

            public StreamViewLike.Transformed<A> newDroppedWhile(Function1<A, Object> p) {
                return StreamViewLike.newDroppedWhile$(this, p);
            }

            public StreamViewLike.Transformed<A> newTakenWhile(Function1<A, Object> p) {
                return StreamViewLike.newTakenWhile$(this, p);
            }

            public <B> StreamViewLike.Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
                return StreamViewLike.newZipped$(this, that);
            }

            public <A1, B> StreamViewLike.Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
                return StreamViewLike.newZippedAll$(this, that, _thisElem, _thatElem);
            }

            public StreamViewLike.Transformed<A> newReversed() {
                return StreamViewLike.newReversed$(this);
            }

            public <B> StreamViewLike.Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
                return StreamViewLike.newPatched$(this, _from, _patch, _replaced);
            }

            public String stringPrefix() {
                return StreamViewLike.stringPrefix$(this);
            }

            public SeqViewLike.Transformed<A> newTaken(int n) {
                return SeqViewLike.newTaken$(this, n);
            }

            public SeqViewLike.Transformed<A> newDropped(int n) {
                return SeqViewLike.newDropped$(this, n);
            }

            public SeqView reverse() {
                return SeqViewLike.reverse$(this);
            }

            public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)SeqViewLike.patch$(this, from, patch, replaced, bf);
            }

            public <B, That> That padTo(int len, B elem, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)SeqViewLike.padTo$(this, len, elem, bf);
            }

            public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)SeqViewLike.reverseMap$(this, f, bf);
            }

            public <B, That> That updated(int index, B elem, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)SeqViewLike.updated$(this, index, elem, bf);
            }

            public <B, That> That $plus$colon(B elem, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)SeqViewLike.$plus$colon$(this, elem, bf);
            }

            public <B, That> That $colon$plus(B elem, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)SeqViewLike.$colon$plus$(this, elem, bf);
            }

            public <B, That> That union(GenSeq<B> that, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)SeqViewLike.union$(this, that, bf);
            }

            public SeqView diff(GenSeq that) {
                return SeqViewLike.diff$(this, that);
            }

            public SeqView intersect(GenSeq that) {
                return SeqViewLike.intersect$(this, that);
            }

            public SeqView sorted(Ordering ord) {
                return SeqViewLike.sorted$(this, ord);
            }

            public SeqView sortWith(Function2 lt) {
                return SeqViewLike.sortWith$(this, lt);
            }

            public SeqView sortBy(Function1 f, Ordering ord) {
                return SeqViewLike.sortBy$(this, f, ord);
            }

            public Iterator<StreamView<A, Stream<A>>> combinations(int n) {
                return SeqViewLike.combinations$(this, n);
            }

            public Iterator<StreamView<A, Stream<A>>> permutations() {
                return SeqViewLike.permutations$(this);
            }

            public SeqView distinct() {
                return SeqViewLike.distinct$(this);
            }

            public IterableView drop(int n) {
                return IterableViewLike.drop$(this, n);
            }

            public IterableView take(int n) {
                return IterableViewLike.take$(this, n);
            }

            public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<StreamView<A, Stream<A>>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zip$(this, that, bf);
            }

            public <A1, That> That zipWithIndex(CanBuildFrom<StreamView<A, Stream<A>>, Tuple2<A1, Object>, That> bf) {
                return (That)IterableViewLike.zipWithIndex$(this, bf);
            }

            public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<StreamView<A, Stream<A>>, Tuple2<A1, B>, That> bf) {
                return (That)IterableViewLike.zipAll$(this, that, thisElem, thatElem, bf);
            }

            public Iterator<StreamView<A, Stream<A>>> grouped(int size) {
                return IterableViewLike.grouped$(this, size);
            }

            public Iterator<StreamView<A, Stream<A>>> sliding(int size, int step) {
                return IterableViewLike.sliding$(this, size, step);
            }

            public Iterator<StreamView<A, Stream<A>>> sliding(int size) {
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

            public Builder<A, StreamView<A, Stream<A>>> newBuilder() {
                return TraversableViewLike.newBuilder$(this);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(scala.collection.Traversable<B> xs, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)TraversableViewLike.map$(this, f, bf);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)TraversableViewLike.collect$(this, pf, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
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

            public Tuple2<StreamView<A, Stream<A>>, StreamView<A, Stream<A>>> partition(Function1<A, Object> p) {
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

            public Tuple2<StreamView<A, Stream<A>>, StreamView<A, Stream<A>>> span(Function1<A, Object> p) {
                return TraversableViewLike.span$(this, p);
            }

            public Tuple2<StreamView<A, Stream<A>>, StreamView<A, Stream<A>>> splitAt(int n) {
                return TraversableViewLike.splitAt$(this, n);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<StreamView<A, Stream<A>>, B, That> bf) {
                return (That)TraversableViewLike.scanRight$(this, z, op, bf);
            }

            public <K> Map<K, StreamView<A, Stream<A>>> groupBy(Function1<A, K> f) {
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

            public Iterator<StreamView<A, Stream<A>>> inits() {
                return TraversableViewLike.inits$(this);
            }

            public Iterator<StreamView<A, Stream<A>>> tails() {
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

            public SeqView<A, StreamView<A, Stream<A>>> view() {
                return SeqLike.view$(this);
            }

            public SeqView<A, StreamView<A, Stream<A>>> view(int from, int until) {
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

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<StreamView<A, Stream<A>>, B, That> cbf) {
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

            public scala.collection.Traversable<A> toTraversable() {
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

            public IndexedSeq<A> toIndexedSeq() {
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

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
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

            private Stream<A> underlying$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.underlying = (Stream)this.$outer.repr();
                        this.bitmap$0 = true;
                    }
                }
                return this.underlying;
            }

            public Stream<A> underlying() {
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
                scala.collection.Traversable.$init$(this);
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
                StreamViewLike.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableViewLike scala.collection.Seq ), $anonfun$sortBy$1(scala.collection.SeqViewLike scala.Function1 scala.math.Ordering ), $anonfun$sortWith$1(scala.collection.SeqViewLike scala.Function2 )}, serializedLambda);
            }
        };
    }

    @Override
    public String stringPrefix() {
        return "Stream";
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        return GenSeqLike.equals$(this, that);
    }

    private final void loop$1(Stream these, String start, String sep$1) {
        while (true) {
            Console$.MODULE$.print(start);
            if (these.isEmpty()) {
                Console$.MODULE$.print("empty");
                return;
            }
            Console$.MODULE$.print(these.head());
            start = sep$1;
            these = (Stream)these.tail();
        }
    }

    public static final /* synthetic */ boolean $anonfun$partition$1(Function1 p$1, Object x$1) {
        return BoxesRunTime.unboxToBoolean(p$1.apply(x$1));
    }

    public static final /* synthetic */ boolean $anonfun$partition$2(Function1 p$1, Object x$2) {
        return BoxesRunTime.unboxToBoolean(p$1.apply(x$2));
    }

    public static final /* synthetic */ Stream $anonfun$dropRight$1(Stream $this, List stub0$1, Stream rest$2, List stub1$1) {
        Object a = rest$2.head();
        return $this.advance$1((List)stub0$1.tail(), stub1$1.$colon$colon(a), (Stream)rest$2.tail());
    }

    /*
     * WARNING - void declaration
     */
    private final Stream advance$1(List stub0, List stub1, Stream rest) {
        void apply_tl;
        void apply_hd;
        while (true) {
            if (rest.isEmpty()) {
                return Stream$.MODULE$.empty();
            }
            if (!((List)stub0).isEmpty()) break;
            Object object = stub1.reverse();
            stub1 = Nil$.MODULE$;
            stub0 = object;
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream.$anonfun$dropRight$1(this, (List)stub0, rest, stub1);
        Object a = ((List)stub0).head();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    private final Stream loop$2(Set seen, Stream rest) {
        void apply_tl;
        void apply_hd;
        while (true) {
            if (rest.isEmpty()) {
                return rest;
            }
            if (!seen.apply(rest.head())) break;
            rest = (Stream)rest.tail();
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> this.loop$2((Set)seen.$plus(rest.head()), (Stream)rest.tail());
        A a = rest.head();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    /*
     * WARNING - void declaration
     */
    private static final Stream loop$3(int len, Stream these, Object elem$1) {
        void apply_tl;
        void apply_hd;
        if (these.isEmpty()) {
            void fill_apply_tl;
            void fill_apply_hd;
            void fill_elem;
            Function0<Object> & java.io.Serializable & Serializable intersect = (Function0<Object> & java.io.Serializable & Serializable)() -> elem$1;
            if (Stream$.MODULE$ == null) {
                throw null;
            }
            if (len <= 0) {
                return Stream$Empty$.MODULE$;
            }
            Function0<Stream> & java.io.Serializable & Serializable intersect2 = () -> Stream$.$anonfun$fill$1(len, (Function0)fill_elem);
            Object object = elem$1;
            if (Stream$cons$.MODULE$ == null) {
                throw null;
            }
            return new Cons<void>(fill_apply_hd, (Function0<Stream<void>>)fill_apply_tl);
        }
        Function0<Stream> & java.io.Serializable & Serializable intersect = (Function0<Stream> & java.io.Serializable & Serializable)() -> Stream.loop$3(len - 1, (Stream)these.tail(), elem$1);
        Object a = these.head();
        if (Stream$cons$.MODULE$ == null) {
            throw null;
        }
        return new Cons<void>(apply_hd, (Function0<Stream<void>>)apply_tl);
    }

    public Stream() {
        Traversable.$init$(this);
        scala.collection.immutable.Iterable.$init$(this);
        scala.collection.immutable.Seq.$init$(this);
        LinearSeqLike.$init$(this);
        scala.collection.LinearSeq.$init$(this);
        LinearSeq.$init$(this);
        LinearSeqOptimized.$init$(this);
    }

    public static final class Cons<A>
    extends Stream<A> {
        public static final long serialVersionUID = -602202424901551803L;
        private final A hd;
        private volatile Stream<A> tlVal;
        private volatile Function0<Stream<A>> tlGen;

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public A head() {
            return this.hd;
        }

        @Override
        public boolean tailDefined() {
            return this.tlGen == null;
        }

        @Override
        public Stream<A> tail() {
            if (!this.tailDefined()) {
                synchronized (this) {
                    if (!this.tailDefined()) {
                        this.tlVal = this.tlGen.apply();
                        this.tlGen = null;
                    }
                }
            }
            return this.tlVal;
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            boolean bl;
            if (that instanceof Cons) {
                Cons cons = (Cons)that;
                bl = this.consEq$1(this, cons);
            } else {
                bl = LinearSeqOptimized.sameElements$(this, that);
            }
            return bl;
        }

        private final boolean consEq$1(Cons a, Cons b) {
            boolean bl;
            block5: {
                block2: {
                    boolean bl2;
                    block4: {
                        block3: {
                            while (true) {
                                if (!BoxesRunTime.equals(a.head(), b.head())) {
                                    return false;
                                }
                                LinearSeqOptimized linearSeqOptimized = a.tail();
                                if (!(linearSeqOptimized instanceof Cons)) break block2;
                                Cons cons = (Cons)linearSeqOptimized;
                                LinearSeqOptimized linearSeqOptimized2 = b.tail();
                                if (!(linearSeqOptimized2 instanceof Cons)) break block3;
                                Cons cons2 = (Cons)linearSeqOptimized2;
                                if (cons == cons2) break;
                                b = cons2;
                                a = cons;
                            }
                            bl2 = true;
                            break block4;
                        }
                        bl2 = false;
                    }
                    bl = bl2;
                    break block5;
                }
                bl = ((Stream)b.tail()).isEmpty();
            }
            return bl;
        }

        public Cons(A hd, Function0<Stream<A>> tl) {
            this.hd = hd;
            this.tlGen = tl;
        }
    }

    public static class ConsWrapper<A> {
        private final Function0<Stream<A>> tl;

        public <B> Stream<B> $hash$colon$colon(B hd) {
            return Stream$cons$.MODULE$.apply(hd, this.tl);
        }

        public <B> Stream<B> $hash$colon$colon$colon(Stream<B> prefix) {
            return prefix.append(this.tl);
        }

        public ConsWrapper(Function0<Stream<A>> tl) {
            this.tl = tl;
        }
    }

    public static class StreamBuilder<A>
    extends LazyBuilder<A, Stream<A>> {
        @Override
        public Stream<A> result() {
            return this.parts().toStream().flatMap((Function1<TraversableOnce, Stream> & java.io.Serializable & Serializable)x$5 -> x$5.toStream(), Stream$.MODULE$.canBuildFrom());
        }
    }

    public static class StreamCanBuildFrom<A>
    extends GenTraversableFactory.GenericCanBuildFrom<A> {
    }

    public static final class StreamWithFilter<A>
    implements FilterMonadic<A, Stream<A>> {
        private Stream<A> filtered;
        private final Function1<A, Object> p;
        private Stream<A> s;
        private volatile boolean bitmap$0;

        private Stream<A> s() {
            return this.s;
        }

        private void s_$eq(Stream<A> x$1) {
            this.s = x$1;
        }

        /*
         * WARNING - void declaration
         */
        private Stream<A> filtered$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    void var1_1;
                    Stream f = (Stream)this.s().filter((Function1)this.p);
                    this.s_$eq(null);
                    this.filtered = var1_1;
                    this.bitmap$0 = true;
                }
            }
            return this.filtered;
        }

        private Stream<A> filtered() {
            if (!this.bitmap$0) {
                return this.filtered$lzycompute();
            }
            return this.filtered;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public <B, That> That map(Function1<A, B> f, CanBuildFrom<Stream<A>, B, That> bf) {
            Stream<A> stream = this.filtered();
            if (stream == null) {
                throw null;
            }
            Stream<A> map_this = stream;
            if (bf.apply((Stream<A>)map_this.repr()) instanceof StreamBuilder) {
                void map_apply_tl;
                void map_apply_hd;
                if (map_this.isEmpty()) {
                    return (That)Stream$Empty$.MODULE$;
                }
                Function0<Stream> & java.io.Serializable & Serializable intersect = () -> Stream.$anonfun$map$1(map_this, f);
                B b = f.apply(map_this.head());
                if (Stream$cons$.MODULE$ == null) {
                    throw null;
                }
                return (That)new Cons<void>(map_apply_hd, (Function0<Stream<void>>)map_apply_tl);
            }
            return (That)TraversableLike.map$(map_this, f, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<Stream<A>, B, That> bf) {
            return this.filtered().flatMap(f, bf);
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            this.filtered().foreach(f);
        }

        @Override
        public FilterMonadic<A, Stream<A>> withFilter(Function1<A, Object> q) {
            return new StreamWithFilter<A>((Function0<Stream> & java.io.Serializable & Serializable)() -> this.filtered(), q);
        }

        public StreamWithFilter(Function0<Stream<A>> sl, Function1<A, Object> p) {
            this.p = p;
            this.s = sl.apply();
        }
    }
}

