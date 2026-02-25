/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterable;
import scala.collection.AbstractSet;
import scala.collection.CustomParallelizable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.SetLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.HashSet$;
import scala.collection.immutable.HashSet$acc$1$;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.ListSet;
import scala.collection.immutable.ListSet$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Traversable;
import scala.collection.immutable.TrieIterator;
import scala.collection.immutable.VM;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParHashSet;
import scala.collection.parallel.immutable.ParHashSet$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LazyRef;
import scala.runtime.RichInt$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u0019\u0015eaBA\u0013\u0003O\u0001\u0012Q\u0007\u0005\b\u0003#\u0003A\u0011AAJ\u0011\u001d\t)\n\u0001C!\u0003/Cq!a(\u0001\t\u0003\n\t\u000bC\u0004\u0002$\u0002!\t%!*\t\u000f\u00055\u0006\u0001\"\u0011\u00020\"9\u0011\u0011\u0017\u0001\u0005\u0002\u0005M\u0006bBA^\u0001\u0011\u0005\u0013Q\u0018\u0005\b\u0003/\u0004A\u0011AAm\u0011\u001d\t)\u000f\u0001C!\u0003ODq!a=\u0001\t#\t)\u0010C\u0004\u0002~\u0002!\t%a@\t\u000f\u0005u\b\u0001\"\u0011\u0003\u0004!9!q\u0003\u0001\u0005B\te\u0001b\u0002B\u000f\u0001\u0011\u0005#q\u0004\u0005\b\u0005G\u0001A\u0011\tB\u0013\u0011%\u0011I\u0003\u0001C\u0001\u0003O\u0011Y\u0003C\u0005\u00032\u0001!\t!a\n\u00034!I!q\t\u0001\u0005\u0002\u0005\u001d\"\u0011\n\u0005\b\u0005'\u0002A\u0011\u0001B+\u0011\u001d\u0011I\u0006\u0001C!\u0003_CqAa\u0017\u0001\t\u0003\u0012i\u0006C\u0004\u0003f\u0001!\tEa\u001a\t\u000f\t-\u0004\u0001\"\u0005\u0003n!9!1\u0010\u0001\u0005\u0012\tu\u0004b\u0002BB\u0001\u0011U!Q\u0011\u0005\n\u0005\u0017\u0003A\u0011AA\u0016\u0005\u001bCqA!%\u0001\t#\u0011\u0019\nC\u0005\u0003\u001e\u0002!\t!a\u000b\u0003 \"9!q\u0015\u0001\u0005\u0012\t%\u0006b\u0002BY\u0001\u0011E!1\u0017\u0005\b\u0005w\u0003A\u0011\tB_\u000f!1\u0019)a\n\t\u0002\teg\u0001CA\u0013\u0003OA\tAa4\t\u000f\u0005E\u0015\u0005\"\u0001\u0003X\"9!1\\\u0011\u0005B\tu\u0007b\u0002BzC\u0011\r!Q\u001f\u0005\t\u0007\u001b\t\u0003\u0015!\u0003\u0004\u0010\u001d91qF\u0011\t\n\rEba\u0002BgC!%a\u0011\u0010\u0005\b\u0003#;C\u0011\u0001D>\u0011\u001d1ih\nC!\r\u007fBqA!\u0017(\t\u0003\u001a)\u0004C\u0005\u0006\u001a\u001e\n\t\u0011\"\u0003\u0007l!I11G\u0011\u0005\u0002\u0005-2Q\u0007\u0005\b\u0007o\tC\u0011BB\u001d\r!\u0019Y0IA\u0011C\ru\bb\u0003BM]\t\u0015\r\u0011\"\u0002\"\u0003KC!\u0002b\u0002/\u0005\u0003\u0005\u000bQBAT\u0011\u001d\t\tJ\fC\u0001\t\u00131a\u0001\"\u0005\"\u0001\u0011M\u0001b\u0003BAe\t\u0015\r\u0011\"\u0001\"\t;A!\u0002b\b3\u0005\u0003\u0005\u000b\u0011\u0002C\r\u0011-\u0011IJ\rB\u0001B\u0003%\u0011qU\u0018\t\u000f\u0005E%\u0007\"\u0001\u0005\"!9\u00111\u0015\u001a\u0005B\u0005\u0015\u0006b\u0002BIe\u0011EC\u0011\u0006\u0005\b\u0007c\u0013D\u0011\tC\u0019\u0011\u001d\t\u0019P\rC)\tkA\u0011B!(3\t\u0003\nY\u0003\"\u0010\t\u0013\t%\"\u0007\"\u0011\u0002(\u0011\u0015\u0003\"\u0003B\u0019e\u0011\u0005\u0013q\u0005C&\u0011%\u00119E\rC!\u0003O!9\u0006C\u0004\u0003(J\"\t\u0006\"\u0019\t\u000f\t-$\u0007\"\u0015\u0005j!9\u0011\u0011\u0017\u001a\u0005B\u0011]\u0004bBA^e\u0011\u0005C1\u0010\u0004\t\t\u000f\u000b\u0003!a\n\u0005\n\"Y!\u0011T\"\u0003\u0002\u0003\u0006I!a*0\u0011)!\u0019j\u0011BC\u0002\u0013\u0005AQ\u0013\u0005\u000b\t;\u001b%\u0011!Q\u0001\n\u0011]\u0005BCAR\u0007\n\u0015\r\u0011\"\u0011\u0002&\"QAqT\"\u0003\u0002\u0003\u0006I!a*\t\u000f\u0005E5\t\"\u0001\u0005\"\"9!\u0011S\"\u0005R\u0011-\u0006bBBY\u0007\u0012\u0005C1\u0017\u0005\b\u0003g\u001cE\u0011\u000bC\\\u0011%\u0011ij\u0011C!\u0003W!y\fC\u0005\u0003*\r#\t%a\n\u0005H\"I!\u0011G\"\u0005B\u0005\u001dBQ\u001a\u0005\n\u0005\u000f\u001aE\u0011IA\u0014\t3DqAa*D\t#\"\u0019\u000fC\u0004\u0003l\r#\t\u0006b;\t\u000f\u0005E6\t\"\u0011\u0005z\"9\u00111X\"\u0005B\u0011u\b\"DC\u0005\u0007B\u0005\u0019\u0011!A\u0005\n\u0005\u0015vF\u0002\u0004\u0004@\u0005\u00021\u0011\t\u0005\f\u0007\u00172&\u00111A\u0005\u0002\u0005\n)\u000bC\u0006\u0004NY\u0013\t\u0019!C\u0001C\r=\u0003BCB+-\n\u0005\t\u0015)\u0003\u0002(\"a!q\u0002,\u0003\u0002\u0004%\t!a\u000b\u0004X!a11\f,\u0003\u0002\u0004%\t!a\u000b\u0004^!Q1\u0011\r,\u0003\u0002\u0003\u0006Ka!\u0017\t\u0017\r\rdK!a\u0001\n\u0003\t\u0013Q\u0015\u0005\f\u0007K2&\u00111A\u0005\u0002\u0005\u001a9\u0007\u0003\u0006\u0004lY\u0013\t\u0011)Q\u0005\u0003OCq!!%W\t\u0003\u0019i\u0007C\u0004\u0002$Z#)%!*\t\u000f\tEe\u000b\"\u0015\u0004\u0000!I!Q\u0014,\u0005B\u0005-2q\u0011\u0005\n\u0005S1F\u0011IA\u0014\u0007\u001fC\u0011B!\rW\t\u0003\n9c!&\t\u0013\t\u001dc\u000b\"\u0011\u0002(\r}\u0005b\u0002BT-\u0012E3\u0011\u0016\u0005\b\u0007c3F\u0011IBZ\u0011\u001d\t\u0019P\u0016C)\u0007sCqAa\u001bW\t#\u001ay\fC\u0004\u00022Z#\te!4\t\u000f\u0005mf\u000b\"\u0011\u0004V\"9!1P\u0011\u0005\u0012\u0015-\u0001b\u0002BBC\u0011UQq\u0002\u0005\n\u0005\u0017\u000bC\u0011AA\u0016\u000b'Aq!b\u0006\"\t\u0013)I\u0002C\u0004\u0006 \u0005\"I!\"\t\t\u000f\u0015E\u0012\u0005\"\u0003\u00064!AQ1H\u0011!\n\u0013)iD\u0002\u0004\u0006J\u0005\"Q1\n\u0005\u000b\u000b\u001f\"(\u00111A\u0005\n\u0015E\u0003BCC-i\n\u0005\r\u0011\"\u0003\u0006\\!QQq\f;\u0003\u0002\u0003\u0006K!b\u0015\t\u000f\u0005EE\u000f\"\u0001\u0006j!9Q1\u000f;\u0005\n\u0015U\u0004bBCFi\u0012%QQ\u0012\u0005\b\u000b3#H\u0011\u0002BZ\r!)9+\t\u0002\u0002,\u0015%\u0006bBAIy\u0012\u0005Q\u0011\u0018\u0005\n\u000b{c\b\u0019!C\u0005\u000b\u007fC\u0011\"\"1}\u0001\u0004%I!b1\t\u0011\u0015\u001dG\u0010)Q\u0005\u000boCq!\"3}\t\u0013)Y\rC\u0004\u0006Rr$I!b5\t\u000f\u0015eG\u0010\"\u0003\u0006\\\"9Qq\u001c?\u0005B\u0015\u0005\bbBCry\u0012\u0005SQ\u001d\u0005\b\u000bOdH\u0011ICu\u0011\u001d)9\u000f C!\u000bkDq!b?}\t\u0003*i\u0010C\u0004\u0007\nq$\tAb\u0003\t\u000f\u0019%A\u0010\"\u0001\u0007\u001a!9aq\u0005?\u0005\n\u0019%\u0002b\u0002D\u001cy\u0012%a\u0011\b\u0005\b\r\u0007bH\u0011\u0002D#\u0011\u001d1Y\u0005 C\u0005\r\u001bBqAb\u0016}\t\u00131I\u0006C\u0004\u0007bq$IAb\u0019\t\u0013\u0015e\u0015%!A\u0005\n\u0019-$a\u0002%bg\"\u001cV\r\u001e\u0006\u0005\u0003S\tY#A\u0005j[6,H/\u00192mK*!\u0011QFA\u0018\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0003\u0003c\tQa]2bY\u0006\u001c\u0001!\u0006\u0003\u00028\u0005\u00153#\u0004\u0001\u0002:\u0005e\u0013\u0011MA8\u0003o\nY\t\u0005\u0004\u0002<\u0005u\u0012\u0011I\u0007\u0003\u0003WIA!a\u0010\u0002,\tY\u0011IY:ue\u0006\u001cGoU3u!\u0011\t\u0019%!\u0012\r\u0001\u00119\u0011q\t\u0001C\u0002\u0005%#!A!\u0012\t\u0005-\u00131\u000b\t\u0005\u0003\u001b\ny%\u0004\u0002\u00020%!\u0011\u0011KA\u0018\u0005\u001dqu\u000e\u001e5j]\u001e\u0004B!!\u0014\u0002V%!\u0011qKA\u0018\u0005\r\te.\u001f\t\u0007\u00037\ni&!\u0011\u000e\u0005\u0005\u001d\u0012\u0002BA0\u0003O\u00111aU3u!!\t\u0019'!\u001b\u0002B\u00055TBAA3\u0015\u0011\t9'a\u000b\u0002\u000f\u001d,g.\u001a:jG&!\u00111NA3\u0005I9UM\\3sS\u000e\u001cV\r\u001e+f[Bd\u0017\r^3\u0011\u0007\u0005m\u0003\u0001\u0005\u0005\u0002<\u0005E\u0014\u0011IA;\u0013\u0011\t\u0019(a\u000b\u0003\u000fM+G\u000fT5lKB)\u00111\f\u0001\u0002BAA\u00111HA=\u0003\u0003\ni(\u0003\u0003\u0002|\u0005-\"\u0001F\"vgR|W\u000eU1sC2dW\r\\5{C\ndW\r\u0005\u0004\u0002\u0000\u0005\u001d\u0015\u0011I\u0007\u0003\u0003\u0003SA!!\u000b\u0002\u0004*!\u0011QQA\u0016\u0003!\u0001\u0018M]1mY\u0016d\u0017\u0002BAE\u0003\u0003\u0013!\u0002U1s\u0011\u0006\u001c\bnU3u!\u0011\ti%!$\n\t\u0005=\u0015q\u0006\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\u0005U\u0014!C2p[B\fg.[8o+\t\tI\n\u0005\u0004\u0002d\u0005m\u0015QN\u0005\u0005\u0003;\u000b)G\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006\u0019\u0001/\u0019:\u0016\u0005\u0005u\u0014\u0001B:ju\u0016,\"!a*\u0011\t\u00055\u0013\u0011V\u0005\u0005\u0003W\u000byCA\u0002J]R\fQ!Z7qif,\"!!\u001e\u0002\u0011%$XM]1u_J,\"!!.\u0011\r\u0005m\u0012qWA!\u0013\u0011\tI,a\u000b\u0003\u0011%#XM]1u_J\fqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0002@\u0006MG\u0003BAa\u0003\u000f\u0004B!!\u0014\u0002D&!\u0011QYA\u0018\u0005\u0011)f.\u001b;\t\u000f\u0005%w\u00011\u0001\u0002L\u0006\ta\r\u0005\u0005\u0002N\u00055\u0017\u0011IAi\u0013\u0011\ty-a\f\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\u0003BA\"\u0003'$q!!6\b\u0005\u0004\tIEA\u0001V\u0003!\u0019wN\u001c;bS:\u001cH\u0003BAn\u0003C\u0004B!!\u0014\u0002^&!\u0011q\\A\u0018\u0005\u001d\u0011un\u001c7fC:Dq!a9\t\u0001\u0004\t\t%A\u0001f\u0003!\u0019XOY:fi>3G\u0003BAn\u0003SDq!a;\n\u0001\u0004\ti/\u0001\u0003uQ\u0006$\bCBA\u001e\u0003_\f\t%\u0003\u0003\u0002r\u0006-\"AB$f]N+G/A\u0005tk\n\u001cX\r^(gaQ1\u00111\\A|\u0003sDq!a;\u000b\u0001\u0004\t)\bC\u0004\u0002|*\u0001\r!a*\u0002\u000b1,g/\u001a7\u0002\u000b\u0011\u0002H.^:\u0015\t\u0005U$\u0011\u0001\u0005\b\u0003G\\\u0001\u0019AA!)!\t)H!\u0002\u0003\n\t5\u0001b\u0002B\u0004\u0019\u0001\u0007\u0011\u0011I\u0001\u0006K2,W.\r\u0005\b\u0005\u0017a\u0001\u0019AA!\u0003\u0015)G.Z73\u0011\u001d\u0011y\u0001\u0004a\u0001\u0005#\tQ!\u001a7f[N\u0004b!!\u0014\u0003\u0014\u0005\u0005\u0013\u0002\u0002B\u000b\u0003_\u0011!\u0002\u0010:fa\u0016\fG/\u001a3?\u0003\u0015)h.[8o)\u0011\t)Ha\u0007\t\u000f\u0005-X\u00021\u0001\u0002n\u0006I\u0011N\u001c;feN,7\r\u001e\u000b\u0005\u0003k\u0012\t\u0003C\u0004\u0002l:\u0001\r!!<\u0002\t\u0011LgM\u001a\u000b\u0005\u0003k\u00129\u0003C\u0004\u0002l>\u0001\r!!<\u0002\rUt\u0017n\u001c81)\u0019\t)H!\f\u00030!9\u00111\u001e\tA\u0002\u0005U\u0004bBA~!\u0001\u0007\u0011qU\u0001\u000bS:$XM]:fGR\u0004DCCA;\u0005k\u00119D!\u000f\u0003D!9\u00111^\tA\u0002\u0005U\u0004bBA~#\u0001\u0007\u0011q\u0015\u0005\b\u0005w\t\u0002\u0019\u0001B\u001f\u0003\u0019\u0011WO\u001a4feB1\u0011Q\nB \u0003kJAA!\u0011\u00020\t)\u0011I\u001d:bs\"9!QI\tA\u0002\u0005\u001d\u0016aB8gMN,G\u000fM\u0001\u0006I&4g\r\r\u000b\u000b\u0003k\u0012YE!\u0014\u0003P\tE\u0003bBAv%\u0001\u0007\u0011Q\u000f\u0005\b\u0003w\u0014\u0002\u0019AAT\u0011\u001d\u0011YD\u0005a\u0001\u0005{AqA!\u0012\u0013\u0001\u0004\t9+\u0001\u0004%[&tWo\u001d\u000b\u0005\u0003k\u00129\u0006C\u0004\u0002dN\u0001\r!!\u0011\u0002\tQ\f\u0017\u000e\\\u0001\u0007M&dG/\u001a:\u0015\t\u0005U$q\f\u0005\b\u0005C*\u0002\u0019\u0001B2\u0003\u0005\u0001\b\u0003CA'\u0003\u001b\f\t%a7\u0002\u0013\u0019LG\u000e^3s\u001d>$H\u0003BA;\u0005SBqA!\u0019\u0017\u0001\u0004\u0011\u0019'A\u0004gS2$XM\u001d\u0019\u0015\u0019\u0005U$q\u000eB9\u0005k\u00129H!\u001f\t\u000f\t\u0005t\u00031\u0001\u0003d!9!1O\fA\u0002\u0005m\u0017A\u00028fO\u0006$X\rC\u0004\u0002|^\u0001\r!a*\t\u000f\tmr\u00031\u0001\u0003>!9!QI\fA\u0002\u0005\u001d\u0016\u0001D3mK6D\u0015m\u001d5D_\u0012,G\u0003BAT\u0005\u007fBqA!!\u0019\u0001\u0004\t\t%A\u0002lKf\fq![7qe>4X\r\u0006\u0003\u0002(\n\u001d\u0005b\u0002BE3\u0001\u0007\u0011qU\u0001\u0006Q\u000e|G-Z\u0001\fG>l\u0007/\u001e;f\u0011\u0006\u001c\b\u000e\u0006\u0003\u0002(\n=\u0005b\u0002BA5\u0001\u0007\u0011\u0011I\u0001\u0005O\u0016$\b\u0007\u0006\u0005\u0002\\\nU%q\u0013BN\u0011\u001d\u0011\ti\u0007a\u0001\u0003\u0003BqA!'\u001c\u0001\u0004\t9+\u0001\u0003iCND\u0007bBA~7\u0001\u0007\u0011qU\u0001\tkB$\u0017\r^3eaQA\u0011Q\u000fBQ\u0005G\u0013)\u000bC\u0004\u0003\u0002r\u0001\r!!\u0011\t\u000f\teE\u00041\u0001\u0002(\"9\u00111 \u000fA\u0002\u0005\u001d\u0016\u0001\u0003:f[>4X\r\u001a\u0019\u0015\u0011\u0005U$1\u0016BW\u0005_CqA!!\u001e\u0001\u0004\t\t\u0005C\u0004\u0003\u001av\u0001\r!a*\t\u000f\u0005mX\u00041\u0001\u0002(\u0006aqO]5uKJ+\u0007\u000f\\1dKR\u0011!Q\u0017\t\u0005\u0003\u001b\u00129,\u0003\u0003\u0003:\u0006=\"AB!osJ+g-A\u0003u_N+G/\u0006\u0003\u0003@\n\u0015WC\u0001Ba!\u0019\tY&!\u0018\u0003DB!\u00111\tBc\t\u001d\u00119m\bb\u0001\u0005\u0013\u0014\u0011AQ\t\u0005\u0003\u0003\n\u0019&\u000b\u0003\u0001OYs#\u0001D#naRL\b*Y:i'\u0016$8#B\u0011\u0003R\u0006-\u0005CBA2\u0005'\fi'\u0003\u0003\u0003V\u0006\u0015$aE%n[V$\u0018M\u00197f'\u0016$h)Y2u_JLHC\u0001Bm!\r\tY&I\u0001\u000b]\u0016<()^5mI\u0016\u0014X\u0003\u0002Bp\u0005_,\"A!9\u0011\u0011\t\r(\u0011\u001eBw\u0005cl!A!:\u000b\t\t\u001d\u00181F\u0001\b[V$\u0018M\u00197f\u0013\u0011\u0011YO!:\u0003\u000f\t+\u0018\u000e\u001c3feB!\u00111\tBx\t\u001d\t9e\tb\u0001\u0003\u0013\u0002R!a\u0017\u0001\u0005[\fAbY1o\u0005VLG\u000e\u001a$s_6,BAa>\u0004\nU\u0011!\u0011 \t\u000b\u0003G\u0012YPa@\u0004\b\r-\u0011\u0002\u0002B\u007f\u0003K\u0012AbQ1o\u0005VLG\u000e\u001a$s_6\u0004Ba!\u0001\u0004\u00045\t\u0011%\u0003\u0003\u0004\u0006\u0005m%\u0001B\"pY2\u0004B!a\u0011\u0004\n\u00119\u0011q\t\u0013C\u0002\u0005%\u0003#BA.\u0001\r\u001d\u0011a\u0003*fkN\f'\r\\3D\u0005\u001a\u0013ba!\u0005\u00036\u000euaABB\n\u0001\u0001\u0019yA\u0001\u0007=e\u00164\u0017N\\3nK:$h(\u0003\u0003\u0004\u0018\re\u0011aD:fi\u000e\u000bgNQ;jY\u00124%o\\7\n\t\rm\u0011Q\r\u0002\u000e\u000f\u0016t7+\u001a;GC\u000e$xN]=\u0011\u0015\u0005\r$1`B\u0010\u0003'\u001ai\u0003\r\u0003\u0004\"\r\u0015\u0002#BA.\u0001\r\r\u0002\u0003BA\"\u0007K!1ba\n\u0001\u0003\u0003\u0005\tQ!\u0001\u0002J\t\u0019q\fJ\u0019\n\t\r-2Q\u0003\u0002\u0006I\u0005twN\u001c\t\u0006\u00037\u0002\u00111K\u0001\r\u000b6\u0004H/\u001f%bg\"\u001cV\r\u001e\t\u0004\u0007\u00039\u0013!D3naRL\u0018J\\:uC:\u001cW-\u0006\u0002\u0004.\u0005yQ.Y6f\u0011\u0006\u001c\b\u000e\u0016:jKN+G/\u0006\u0003\u0004<\r\rHCDB\u001f\u0007K\u001cIoa<\u0004t\u000eU8q\u001f\t\u0006\u0007\u000316\u0011\u001d\u0002\f\u0011\u0006\u001c\b\u000e\u0016:jKN+G/\u0006\u0003\u0004D\r%3c\u0001,\u0004FA)\u00111\f\u0001\u0004HA!\u00111IB%\t\u001d\t9E\u0016b\u0001\u0003\u0013\naAY5u[\u0006\u0004\u0018A\u00032ji6\f\u0007o\u0018\u0013fcR!\u0011\u0011YB)\u0011%\u0019\u0019\u0006WA\u0001\u0002\u0004\t9+A\u0002yIE\nqAY5u[\u0006\u0004\b%\u0006\u0002\u0004ZA1\u0011Q\nB \u0007\u000b\n\u0011\"\u001a7f[N|F%Z9\u0015\t\u0005\u00057q\f\u0005\n\u0007'Z\u0016\u0011!a\u0001\u00073\na!\u001a7f[N\u0004\u0013!B:ju\u0016\u0004\u0014!C:ju\u0016\u0004t\fJ3r)\u0011\t\tm!\u001b\t\u0013\rMc,!AA\u0002\u0005\u001d\u0016AB:ju\u0016\u0004\u0004\u0005\u0006\u0005\u0004p\rE41OB;!\u0015\u0019\tAVB$\u0011\u001d\u0019Y\u0005\u0019a\u0001\u0003OCqAa\u0004a\u0001\u0004\u0019I\u0006C\u0004\u0004d\u0001\u0004\r!a*)\u0007\u0005\u001cI\b\u0005\u0003\u0002N\rm\u0014\u0002BB?\u0003_\u0011a!\u001b8mS:,G\u0003CAn\u0007\u0003\u001b\u0019i!\"\t\u000f\t\u0005%\r1\u0001\u0004H!9!\u0011\u00142A\u0002\u0005\u001d\u0006bBA~E\u0002\u0007\u0011q\u0015\u000b\t\u0007\u000b\u001aIia#\u0004\u000e\"9!\u0011Q2A\u0002\r\u001d\u0003b\u0002BMG\u0002\u0007\u0011q\u0015\u0005\b\u0003w\u001c\u0007\u0019AAT)\u0019\u0019)e!%\u0004\u0014\"9\u00111\u001e3A\u0002\r\u0015\u0003bBA~I\u0002\u0007\u0011q\u0015\u000b\u000b\u0007\u000b\u001a9j!'\u0004\u001c\u000eu\u0005bBAvK\u0002\u00071Q\t\u0005\b\u0003w,\u0007\u0019AAT\u0011\u001d\u0011Y$\u001aa\u0001\u00073BqA!\u0012f\u0001\u0004\t9\u000b\u0006\u0006\u0004F\r\u000561UBS\u0007OCq!a;g\u0001\u0004\u0019)\u0005C\u0004\u0002|\u001a\u0004\r!a*\t\u000f\tmb\r1\u0001\u0004Z!9!Q\t4A\u0002\u0005\u001dF\u0003CB#\u0007W\u001bika,\t\u000f\t\u0005u\r1\u0001\u0004H!9!\u0011T4A\u0002\u0005\u001d\u0006bBA~O\u0002\u0007\u0011qU\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005m7Q\u0017\u0005\b\u0007oC\u0007\u0019AA*\u0003\u0015yG\u000f[3s)\u0019\tYna/\u0004>\"9\u00111^5A\u0002\r\u0015\u0003bBA~S\u0002\u0007\u0011q\u0015\u000b\r\u0007\u000b\u001a\tm!2\u0004H\u000e%71\u001a\u0005\b\u0005CR\u0007\u0019ABb!!\ti%!4\u0004H\u0005m\u0007b\u0002B:U\u0002\u0007\u00111\u001c\u0005\b\u0003wT\u0007\u0019AAT\u0011\u001d\u0011YD\u001ba\u0001\u00073BqA!\u0012k\u0001\u0004\t9+\u0006\u0002\u0004PB1\u00111LBi\u0007\u000fJAaa5\u0002(\taAK]5f\u0013R,'/\u0019;peV!1q[Bp)\u0011\t\tm!7\t\u000f\u0005%G\u000e1\u0001\u0004\\BA\u0011QJAg\u0007\u000f\u001ai\u000e\u0005\u0003\u0002D\r}GaBAkY\n\u0007\u0011\u0011\n\t\u0005\u0003\u0007\u001a\u0019\u000fB\u0004\u0002H5\u0012\r!!\u0013\t\u000f\r\u001dX\u00061\u0001\u0002(\u0006)\u0001.Y:ia!911^\u0017A\u0002\r5\u0018!B3mK6\u0004\u0004#BA.\u0001\r\u0005\bbBBy[\u0001\u0007\u0011qU\u0001\u0006Q\u0006\u001c\b.\r\u0005\b\u0005\u000fi\u0003\u0019ABw\u0011\u001d\tY0\fa\u0001\u0003OCqa!?.\u0001\u0004\t9+A\u0004oK^\u001c\u0016N_3\u0003\u00171+\u0017M\u001a%bg\"\u001cV\r^\u000b\u0005\u0007\u007f$)aE\u0002/\t\u0003\u0001R!a\u0017\u0001\t\u0007\u0001B!a\u0011\u0005\u0006\u00119\u0011q\t\u0018C\u0002\u0005%\u0013!\u00025bg\"\u0004C\u0003\u0002C\u0006\t\u001b\u0001Ra!\u0001/\t\u0007AqA!'2\u0001\u0004\t9+K\u0002/e\r\u0013\u0001\u0002S1tQN+G/M\u000b\u0005\t+!YbE\u00023\t/\u0001Ra!\u0001/\t3\u0001B!a\u0011\u0005\u001c\u00119\u0011q\t\u001aC\u0002\u0005%SC\u0001C\r\u0003\u0011YW-\u001f\u0011\u0015\r\u0011\rBQ\u0005C\u0014!\u0015\u0019\tA\rC\r\u0011\u001d\u0011\tI\u000ea\u0001\t3AqA!'7\u0001\u0004\t9\u000b\u0006\u0005\u0002\\\u0012-BQ\u0006C\u0018\u0011\u001d\u0011\t\t\u000fa\u0001\t3AqA!'9\u0001\u0004\t9\u000bC\u0004\u0002|b\u0002\r!a*\u0015\t\u0005mG1\u0007\u0005\b\u0007oK\u0004\u0019AA*)\u0019\tY\u000eb\u000e\u0005<!9\u00111\u001e\u001eA\u0002\u0011e\u0002#BA.\u0001\u0011e\u0001bBA~u\u0001\u0007\u0011q\u0015\u000b\t\ts!y\u0004\"\u0011\u0005D!9!\u0011Q\u001eA\u0002\u0011e\u0001b\u0002BMw\u0001\u0007\u0011q\u0015\u0005\b\u0003w\\\u0004\u0019AAT)\u0019!I\u0004b\u0012\u0005J!9\u00111\u001e\u001fA\u0002\u0011e\u0002bBA~y\u0001\u0007\u0011q\u0015\u000b\u000b\ts!i\u0005b\u0014\u0005R\u0011U\u0003bBAv{\u0001\u0007A\u0011\b\u0005\b\u0003wl\u0004\u0019AAT\u0011\u001d\u0011Y$\u0010a\u0001\t'\u0002b!!\u0014\u0003@\u0011e\u0002b\u0002B#{\u0001\u0007\u0011q\u0015\u000b\u000b\ts!I\u0006b\u0017\u0005^\u0011}\u0003bBAv}\u0001\u0007A\u0011\b\u0005\b\u0003wt\u0004\u0019AAT\u0011\u001d\u0011YD\u0010a\u0001\t'BqA!\u0012?\u0001\u0004\t9\u000b\u0006\u0005\u0005:\u0011\rDQ\rC4\u0011\u001d\u0011\ti\u0010a\u0001\t3AqA!'@\u0001\u0004\t9\u000bC\u0004\u0002|~\u0002\r!a*\u0015\u0019\u0011eB1\u000eC8\tc\"\u0019\b\"\u001e\t\u000f\t\u0005\u0004\t1\u0001\u0005nAA\u0011QJAg\t3\tY\u000eC\u0004\u0003t\u0001\u0003\r!a7\t\u000f\u0005m\b\t1\u0001\u0002(\"9!1\b!A\u0002\u0011M\u0003b\u0002B#\u0001\u0002\u0007\u0011qU\u000b\u0003\ts\u0002b!a\u000f\u00028\u0012eQ\u0003\u0002C?\t\u000b#B!!1\u0005\u0000!9\u0011\u0011\u001a\"A\u0002\u0011\u0005\u0005\u0003CA'\u0003\u001b$I\u0002b!\u0011\t\u0005\rCQ\u0011\u0003\b\u0003+\u0014%\u0019AA%\u0005EA\u0015m\u001d5TKR\u001cu\u000e\u001c7jg&|g.M\u000b\u0005\t\u0017#\tjE\u0002D\t\u001b\u0003Ra!\u0001/\t\u001f\u0003B!a\u0011\u0005\u0012\u00129\u0011qI\"C\u0002\u0005%\u0013AA6t+\t!9\n\u0005\u0004\u0002\\\u0011eEqR\u0005\u0005\t7\u000b9CA\u0004MSN$8+\u001a;\u0002\u0007-\u001c\b%A\u0003tSj,\u0007\u0005\u0006\u0005\u0005$\u0012\u0015Fq\u0015CU!\u0015\u0019\ta\u0011CH\u0011\u001d\u0011I*\u0013a\u0001\u0003OCq\u0001b%J\u0001\u0004!9\nC\u0004\u0002$&\u0003\r!a*\u0015\u0011\u0005mGQ\u0016CX\tcCqA!!K\u0001\u0004!y\tC\u0004\u0003\u001a*\u0003\r!a*\t\u000f\u0005m(\n1\u0001\u0002(R!\u00111\u001cC[\u0011\u001d\u00199l\u0013a\u0001\u0003'\"b!a7\u0005:\u0012u\u0006bBAv\u0019\u0002\u0007A1\u0018\t\u0006\u00037\u0002Aq\u0012\u0005\b\u0003wd\u0005\u0019AAT)!!Y\f\"1\u0005D\u0012\u0015\u0007b\u0002BA\u001b\u0002\u0007Aq\u0012\u0005\b\u00053k\u0005\u0019AAT\u0011\u001d\tY0\u0014a\u0001\u0003O#b\u0001b/\u0005J\u0012-\u0007bBAv\u001d\u0002\u0007A1\u0018\u0005\b\u0003wt\u0005\u0019AAT))!Y\fb4\u0005R\u0012MGq\u001b\u0005\b\u0003W|\u0005\u0019\u0001C^\u0011\u001d\tYp\u0014a\u0001\u0003OCqAa\u000fP\u0001\u0004!)\u000e\u0005\u0004\u0002N\t}B1\u0018\u0005\b\u0005\u000bz\u0005\u0019AAT))!Y\fb7\u0005^\u0012}G\u0011\u001d\u0005\b\u0003W\u0004\u0006\u0019\u0001C^\u0011\u001d\tY\u0010\u0015a\u0001\u0003OCqAa\u000fQ\u0001\u0004!)\u000eC\u0004\u0003FA\u0003\r!a*\u0015\u0011\u0011mFQ\u001dCt\tSDqA!!R\u0001\u0004!y\tC\u0004\u0003\u001aF\u0003\r!a*\t\u000f\u0005m\u0018\u000b1\u0001\u0002(RaA1\u0018Cw\tc$\u0019\u0010\">\u0005x\"9!\u0011\r*A\u0002\u0011=\b\u0003CA'\u0003\u001b$y)a7\t\u000f\tM$\u000b1\u0001\u0002\\\"9\u00111 *A\u0002\u0005\u001d\u0006b\u0002B\u001e%\u0002\u0007AQ\u001b\u0005\b\u0005\u000b\u0012\u0006\u0019AAT+\t!Y\u0010\u0005\u0004\u0002<\u0005]FqR\u000b\u0005\t\u007f,9\u0001\u0006\u0003\u0002B\u0016\u0005\u0001bBAe)\u0002\u0007Q1\u0001\t\t\u0003\u001b\ni\rb$\u0006\u0006A!\u00111IC\u0004\t\u001d\t)\u000e\u0016b\u0001\u0003\u0013\n!b];qKJ$\u0003.Y:i)\u0011\t9+\"\u0004\t\u000f\t\u0005U\u000e1\u0001\u0002TQ!\u0011qUC\t\u0011\u001d\u0011II\u001ca\u0001\u0003O#B!a*\u0006\u0016!9!\u0011Q8A\u0002\u0005M\u0013A\u00032vM\u001a,'oU5{KR!\u0011qUC\u000e\u0011\u001d\t\u0019\u000b\u001da\u0001\u0003OC3\u0001]B=\u0003-qW\u000f\u001c7U_\u0016k\u0007\u000f^=\u0016\t\u0015\rR\u0011\u0006\u000b\u0005\u000bK)Y\u0003E\u0003\u0002\\\u0001)9\u0003\u0005\u0003\u0002D\u0015%BaBA$c\n\u0007\u0011\u0011\n\u0005\b\u000b[\t\b\u0019AC\u0013\u0003\u0005\u0019\bfA9\u0004z\u0005A1.Z3q\u0005&$8\u000f\u0006\u0004\u0002(\u0016URq\u0007\u0005\b\u0007\u0017\u0012\b\u0019AAT\u0011\u001d)ID\u001da\u0001\u0003O\u000bAa[3fa\u0006yQO\\:jO:,GmQ8na\u0006\u0014X\r\u0006\u0004\u0002\\\u0016}R1\t\u0005\b\u000b\u0003\u001a\b\u0019AAT\u0003\u0005I\u0007bBC#g\u0002\u0007\u0011qU\u0001\u0002U\"\u001a1o!\u001f\u0003%M+'/[1mSj\fG/[8o!J|\u00070_\u000b\u0007\u000b\u001b*9&b\u001c\u0014\u000bQ\u0014),a#\u0002\t=\u0014\u0018nZ\u000b\u0003\u000b'\u0002R!a\u0017\u0001\u000b+\u0002B!a\u0011\u0006X\u00119\u0011q\t;C\u0002\u0005%\u0013\u0001C8sS\u001e|F%Z9\u0015\t\u0005\u0005WQ\f\u0005\n\u0007'2\u0018\u0011!a\u0001\u000b'\nQa\u001c:jO\u0002B3a^C2!\u0011\ti%\"\u001a\n\t\u0015\u001d\u0014q\u0006\u0002\niJ\fgn]5f]R$B!b\u001b\u0006rA91\u0011\u0001;\u0006V\u00155\u0004\u0003BA\"\u000b_\"qAa2u\u0005\u0004\tI\u0005C\u0004\u0006Pa\u0004\r!b\u0015\u0002\u0017]\u0014\u0018\u000e^3PE*,7\r\u001e\u000b\u0005\u0003\u0003,9\bC\u0004\u0006ze\u0004\r!b\u001f\u0002\u0007=,H\u000f\u0005\u0003\u0006~\u0015\u001dUBAC@\u0015\u0011)\t)b!\u0002\u0005%|'BACC\u0003\u0011Q\u0017M^1\n\t\u0015%Uq\u0010\u0002\u0013\u001f\nTWm\u0019;PkR\u0004X\u000f^*ue\u0016\fW.\u0001\u0006sK\u0006$wJ\u00196fGR$B!!1\u0006\u0010\"9Q\u0011\u0013>A\u0002\u0015M\u0015AA5o!\u0011)i(\"&\n\t\u0015]Uq\u0010\u0002\u0012\u001f\nTWm\u0019;J]B,Ho\u0015;sK\u0006l\u0017a\u0003:fC\u0012\u0014Vm]8mm\u0016Ds\u0001^CO\u000bG+)\u000b\u0005\u0003\u0002N\u0015}\u0015\u0002BCQ\u0003_\u0011\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u0002\u000bY\fG.^3\u001f\u0003\t\u0011a\u0002S1tQN+GOQ;jY\u0012,'/\u0006\u0003\u0006,\u0016U6#\u0002?\u00036\u00165\u0006\u0003\u0003Br\u000b_+\u0019,b.\n\t\u0015E&Q\u001d\u0002\u0010%\u0016,8/\u00192mK\n+\u0018\u000e\u001c3feB!\u00111IC[\t\u001d\t9\u0005 b\u0001\u0003\u0013\u0002R!a\u0017\u0001\u000bg#\"!b/\u0011\u000b\r\u0005A0b-\u0002\u0011I|w\u000e\u001e(pI\u0016,\"!b.\u0002\u0019I|w\u000e\u001e(pI\u0016|F%Z9\u0015\t\u0005\u0005WQ\u0019\u0005\n\u0007'z\u0018\u0011!a\u0001\u000bo\u000b\u0011B]8pi:{G-\u001a\u0011\u0002\u0013%\u001cX*\u001e;bE2,G\u0003BAn\u000b\u001bD\u0001\"b4\u0002\u0004\u0001\u0007QqW\u0001\u0003QN\f1\"\\1lK6+H/\u00192mKR!QQ[Cl!\u0015\u0019\tAVCZ\u0011!)y-!\u0002A\u0002\u0015U\u0017!D7bW\u0016LU.\\;uC\ndW\r\u0006\u0003\u00068\u0016u\u0007\u0002CCh\u0003\u000f\u0001\r!b.\u0002\u000b\rdW-\u0019:\u0015\u0005\u0005\u0005\u0017A\u0002:fgVdG\u000f\u0006\u0002\u00068\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0005\u0006l\u00165Xq^Cy\u001b\u0005a\b\u0002\u0003B\u0004\u0003\u001b\u0001\r!b-\t\u0011\t-\u0011Q\u0002a\u0001\u000bgC\u0001Ba\u0004\u0002\u000e\u0001\u0007Q1\u001f\t\u0007\u0003\u001b\u0012\u0019\"b-\u0015\t\u0015-Xq\u001f\u0005\t\u000bs\fy\u00011\u0001\u00064\u0006!Q\r\\3n\u00035!\u0003\u000f\\;tIAdWo\u001d\u0013fcR!Q1^C\u0000\u0011!1\t!!\u0005A\u0002\u0019\r\u0011A\u0001=t!\u0019\tYD\"\u0002\u00064&!aqAA\u0016\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0017aD7bW\u0016lU\u000f^1cY\u0016$&/[3\u0015\u0011\u0015UgQ\u0002D\n\r/A\u0001Bb\u0004\u0002\u0014\u0001\u0007a\u0011C\u0001\u0006C2+\u0017M\u001a\t\u0006\u0007\u0003qS1\u0017\u0005\t\r+\t\u0019\u00021\u0001\u0007\u0012\u0005)!\rT3bM\"A\u00111`A\n\u0001\u0004\t9\u000b\u0006\u0006\u0006V\u001amaq\u0004D\u0011\rKA\u0001B\"\b\u0002\u0016\u0001\u0007a\u0011C\u0001\u0005Y\u0016\fg\r\u0003\u0005\u0006z\u0006U\u0001\u0019ACZ\u0011!1\u0019#!\u0006A\u0002\u0005\u001d\u0016\u0001E3mK6LU\u000e\u001d:pm\u0016$\u0007*Y:i\u0011!\tY0!\u0006A\u0002\u0005\u001d\u0016AB1eI>sW\r\u0006\u0006\u00068\u001a-bq\u0006D\u0019\rkA\u0001B\"\f\u0002\u0018\u0001\u0007QqW\u0001\u0007i>tu\u000eZ3\t\u0011\u0015e\u0018q\u0003a\u0001\u000bgC\u0001Bb\r\u0002\u0018\u0001\u0007\u0011qU\u0001\rS6\u0004(o\u001c<fI\"\u000b7\u000f\u001b\u0005\t\u0003w\f9\u00021\u0001\u0002(\u0006y1m\\7qe\u0016\u001c8/\u001a3J]\u0012,\u0007\u0010\u0006\u0004\u0002(\u001ambq\b\u0005\t\r{\tI\u00021\u0001\u0006V\u0006!AO]5f\u0011!1\t%!\u0007A\u0002\u0005\u001d\u0016\u0001\u0003:bo&sG-\u001a=\u0002\u0013Q\u0014\u0018.Z%oI\u0016DHCBAT\r\u000f2I\u0005\u0003\u0005\u0007>\u0005m\u0001\u0019ACk\u0011!1\t%a\u0007A\u0002\u0005\u001d\u0016AC1eI\"\u000b7\u000f[*fiRAQq\u0017D(\r#2)\u0006\u0003\u0005\u0007.\u0005u\u0001\u0019AC\\\u0011!1\u0019&!\bA\u0002\u0015]\u0016!\u0003;p\u0005\u0016\fE\rZ3e\u0011!\tY0!\bA\u0002\u0005\u001d\u0016\u0001E1eIR{GK]5f\u0011\u0006\u001c\bnU3u)!)9Lb\u0017\u0007^\u0019}\u0003\u0002\u0003D\u0017\u0003?\u0001\r!\"6\t\u0011\u0019M\u0013q\u0004a\u0001\u000boC\u0001\"a?\u0002 \u0001\u0007\u0011qU\u0001\u0011C\u0012$Gk\u001c'fC\u001aD\u0015m\u001d5TKR$\u0002\"b.\u0007f\u0019\u001dd\u0011\u000e\u0005\t\r[\t\t\u00031\u0001\u0007\u0012!Aa1KA\u0011\u0001\u0004)9\f\u0003\u0005\u0002|\u0006\u0005\u0002\u0019AAT)\t1i\u0007\u0005\u0003\u0007p\u0019UTB\u0001D9\u0015\u00111\u0019(b!\u0002\t1\fgnZ\u0005\u0005\ro2\tH\u0001\u0004PE*,7\r^\n\u0004O\r5BCAB\u0019\u0003\u0011AW-\u00193\u0016\u0005\u0005M\u0003f\u0002\u0001\u0006\u001e\u0016\rVQU\u0001\b\u0011\u0006\u001c\bnU3u\u0001")
public class HashSet<A>
extends AbstractSet<A>
implements scala.collection.immutable.Set<A>,
CustomParallelizable<A, ParHashSet<A>>,
Serializable {
    public static final long serialVersionUID = 2L;

    public static <A> CanBuildFrom<HashSet<?>, A, HashSet<A>> canBuildFrom() {
        return HashSet$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<HashSet<?>, A, HashSet<A>> setCanBuildFrom() {
        return HashSet$.MODULE$.setCanBuildFrom();
    }

    @Override
    public Combiner<A, ParHashSet<A>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public scala.collection.immutable.Set<A> seq() {
        return scala.collection.immutable.Set.seq$(this);
    }

    @Override
    public GenericCompanion<HashSet> companion() {
        return HashSet$.MODULE$;
    }

    @Override
    public ParHashSet<A> par() {
        return ParHashSet$.MODULE$.fromTrie(this);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public HashSet<A> empty() {
        return (HashSet)HashSet$.MODULE$.empty();
    }

    @Override
    public Iterator<A> iterator() {
        return Iterator$.MODULE$.empty();
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
    }

    @Override
    public boolean contains(A e) {
        return this.get0(e, this.computeHash(e), 0);
    }

    @Override
    public boolean subsetOf(GenSet<A> that) {
        boolean bl;
        if (that instanceof HashSet) {
            HashSet hashSet = (HashSet)that;
            bl = this.subsetOf0(hashSet, 0);
        } else {
            bl = GenSetLike.subsetOf$(this, that);
        }
        return bl;
    }

    public boolean subsetOf0(HashSet<A> that, int level) {
        return true;
    }

    @Override
    public HashSet<A> $plus(A e) {
        return this.updated0(e, this.computeHash(e), 0);
    }

    @Override
    public HashSet<A> $plus(A elem1, A elem2, Seq<A> elems) {
        return (HashSet)((AbstractSet)((HashSet)this.$plus((Object)elem1)).$plus((Object)elem2)).$plus$plus(elems);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public HashSet<A> union(GenSet<A> that) {
        HashSet hashSet;
        if (that instanceof HashSet) {
            Object object;
            HashSet hashSet2 = (HashSet)that;
            if (this == hashSet2) {
                object = this;
            } else {
                void scala$collection$immutable$HashSet$$nullToEmpty_s;
                HashSet$ hashSet$ = HashSet$.MODULE$;
                HashSet<A> hashSet3 = this.union0(hashSet2, 0);
                if (hashSet$ == null) {
                    throw null;
                }
                HashSet$ scala$collection$immutable$HashSet$$nullToEmpty_this = hashSet$;
                object = scala$collection$immutable$HashSet$$nullToEmpty_s == null ? (HashSet)scala$collection$immutable$HashSet$$nullToEmpty_this.empty() : scala$collection$immutable$HashSet$$nullToEmpty_s;
            }
            hashSet = object;
        } else {
            HashSet hashSet4;
            if (that.isEmpty()) {
                hashSet4 = this;
            } else {
                LazyRef acc$module = new LazyRef();
                if (that instanceof scala.collection.immutable.Set) {
                    that.foreach(this.acc$2(acc$module));
                } else {
                    that.iterator().foreach(this.acc$2(acc$module));
                }
                hashSet4 = this.acc$2(acc$module).res();
            }
            hashSet = hashSet4;
        }
        return hashSet;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public HashSet<A> intersect(GenSet<A> that) {
        HashSet hashSet;
        if (that instanceof HashSet) {
            void scala$collection$immutable$HashSet$$nullToEmpty_s;
            void scala$collection$immutable$HashSet$$bufferSize_size;
            HashSet hashSet2 = (HashSet)that;
            int n = this.size();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int n2 = RichInt$.MODULE$.min$extension(n, hashSet2.size());
            if (HashSet$.MODULE$ == null) {
                throw null;
            }
            void var9_5 = scala$collection$immutable$HashSet$$bufferSize_size + 6;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            HashSet[] buffer = new HashSet[RichInt$.MODULE$.min$extension((int)var9_5, 224)];
            HashSet$ hashSet$ = HashSet$.MODULE$;
            HashSet<A> hashSet3 = this.intersect0(hashSet2, 0, buffer, 0);
            if (hashSet$ == null) {
                throw null;
            }
            HashSet$ scala$collection$immutable$HashSet$$nullToEmpty_this = hashSet$;
            hashSet = scala$collection$immutable$HashSet$$nullToEmpty_s == null ? (HashSet)scala$collection$immutable$HashSet$$nullToEmpty_this.empty() : scala$collection$immutable$HashSet$$nullToEmpty_s;
        } else {
            hashSet = (HashSet)GenSetLike.intersect$(this, that);
        }
        return hashSet;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public HashSet<A> diff(GenSet<A> that) {
        HashSet hashSet;
        if (that instanceof HashSet) {
            void scala$collection$immutable$HashSet$$nullToEmpty_s;
            void scala$collection$immutable$HashSet$$bufferSize_size;
            HashSet hashSet2 = (HashSet)that;
            int n = this.size();
            if (HashSet$.MODULE$ == null) {
                throw null;
            }
            void var8_4 = scala$collection$immutable$HashSet$$bufferSize_size + 6;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            HashSet[] buffer = new HashSet[RichInt$.MODULE$.min$extension((int)var8_4, 224)];
            HashSet$ hashSet$ = HashSet$.MODULE$;
            HashSet<A> hashSet3 = this.diff0(hashSet2, 0, buffer, 0);
            if (hashSet$ == null) {
                throw null;
            }
            HashSet$ scala$collection$immutable$HashSet$$nullToEmpty_this = hashSet$;
            hashSet = scala$collection$immutable$HashSet$$nullToEmpty_s == null ? (HashSet)scala$collection$immutable$HashSet$$nullToEmpty_this.empty() : scala$collection$immutable$HashSet$$nullToEmpty_s;
        } else {
            hashSet = (HashSet)SetLike.diff$(this, that);
        }
        return hashSet;
    }

    public HashSet<A> union0(HashSet<A> that, int level) {
        return that;
    }

    public HashSet<A> intersect0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
        return null;
    }

    public HashSet<A> diff0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public HashSet<A> $minus(A e) {
        void scala$collection$immutable$HashSet$$nullToEmpty_s;
        HashSet$ hashSet$ = HashSet$.MODULE$;
        HashSet<A> hashSet = this.removed0(e, this.computeHash(e), 0);
        if (hashSet$ == null) {
            throw null;
        }
        HashSet$ scala$collection$immutable$HashSet$$nullToEmpty_this = hashSet$;
        if (scala$collection$immutable$HashSet$$nullToEmpty_s == null) {
            return (HashSet)scala$collection$immutable$HashSet$$nullToEmpty_this.empty();
        }
        return hashSet;
    }

    @Override
    public HashSet<A> tail() {
        return this.$minus(this.head());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public HashSet<A> filter(Function1<A, Object> p) {
        Object object;
        if (p instanceof HashSet) {
            HashSet hashSet = (HashSet)p;
            object = this.intersect((GenSet)hashSet);
        } else {
            void scala$collection$immutable$HashSet$$nullToEmpty_s;
            void scala$collection$immutable$HashSet$$bufferSize_size;
            int n = this.size();
            if (HashSet$.MODULE$ == null) {
                throw null;
            }
            void var8_5 = scala$collection$immutable$HashSet$$bufferSize_size + 6;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            HashSet[] buffer = new HashSet[RichInt$.MODULE$.min$extension((int)var8_5, 224)];
            HashSet$ hashSet$ = HashSet$.MODULE$;
            HashSet<A> hashSet = this.filter0(p, false, 0, buffer, 0);
            if (hashSet$ == null) {
                throw null;
            }
            HashSet$ scala$collection$immutable$HashSet$$nullToEmpty_this = hashSet$;
            object = scala$collection$immutable$HashSet$$nullToEmpty_s == null ? (HashSet)scala$collection$immutable$HashSet$$nullToEmpty_this.empty() : scala$collection$immutable$HashSet$$nullToEmpty_s;
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public HashSet<A> filterNot(Function1<A, Object> p) {
        Object object;
        if (p instanceof HashSet) {
            HashSet hashSet = (HashSet)p;
            object = this.diff((GenSet)hashSet);
        } else {
            void scala$collection$immutable$HashSet$$nullToEmpty_s;
            void scala$collection$immutable$HashSet$$bufferSize_size;
            int n = this.size();
            if (HashSet$.MODULE$ == null) {
                throw null;
            }
            void var8_5 = scala$collection$immutable$HashSet$$bufferSize_size + 6;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            HashSet[] buffer = new HashSet[RichInt$.MODULE$.min$extension((int)var8_5, 224)];
            HashSet$ hashSet$ = HashSet$.MODULE$;
            HashSet<A> hashSet = this.filter0(p, true, 0, buffer, 0);
            if (hashSet$ == null) {
                throw null;
            }
            HashSet$ scala$collection$immutable$HashSet$$nullToEmpty_this = hashSet$;
            object = scala$collection$immutable$HashSet$$nullToEmpty_s == null ? (HashSet)scala$collection$immutable$HashSet$$nullToEmpty_this.empty() : scala$collection$immutable$HashSet$$nullToEmpty_s;
        }
        return object;
    }

    public HashSet<A> filter0(Function1<A, Object> p, boolean negate, int level, HashSet<A>[] buffer, int offset0) {
        return null;
    }

    public int elemHashCode(A key) {
        return Statics.anyHash(key);
    }

    public final int improve(int hcode) {
        int h = hcode + ~(hcode << 9);
        h ^= h >>> 14;
        h += h << 4;
        return h ^ h >>> 10;
    }

    public int computeHash(A key) {
        return this.improve(this.elemHashCode(key));
    }

    public boolean get0(A key, int hash, int level) {
        return false;
    }

    public HashSet<A> updated0(A key, int hash, int level) {
        return new HashSet1<A>(key, hash);
    }

    public HashSet<A> removed0(A key, int hash, int level) {
        return this;
    }

    public Object writeReplace() {
        return new SerializationProxy(this);
    }

    @Override
    public <B> scala.collection.immutable.Set<B> toSet() {
        return this;
    }

    private final /* synthetic */ HashSet$acc$1$ acc$lzycompute$1(LazyRef acc$module$1) {
        synchronized (acc$module$1) {
            HashSet$acc$1$ hashSet$acc$1$ = acc$module$1.initialized() ? (HashSet$acc$1$)acc$module$1.value() : acc$module$1.initialize(new HashSet$acc$1$(this));
            return hashSet$acc$1$;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private final HashSet$acc$1$ acc$2(LazyRef acc$module$1) {
        if (acc$module$1.initialized()) {
            return (HashSet$acc$1$)acc$module$1.value();
        }
        return this.acc$lzycompute$1(acc$module$1);
    }

    public HashSet() {
        Traversable.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Set.$init$(this);
        CustomParallelizable.$init$(this);
    }

    public static class HashSet1<A>
    extends LeafHashSet<A> {
        private final A key;

        public A key() {
            return this.key;
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public boolean get0(A key, int hash, int level) {
            return hash == super.hash() && BoxesRunTime.equals(key, this.key());
        }

        @Override
        public boolean equals(Object other) {
            HashSet1 hashSet1;
            boolean bl = other instanceof HashSet1 ? this == (hashSet1 = (HashSet1)other) || super.hash() == hashSet1.hash() && BoxesRunTime.equals(this.key(), hashSet1.key()) : (other instanceof HashSet ? false : GenSetLike.equals$(this, other));
            return bl;
        }

        @Override
        public boolean subsetOf0(HashSet<A> that, int level) {
            return this == that || that.get0(this.key(), super.hash(), level);
        }

        @Override
        public HashSet<A> updated0(A key, int hash, int level) {
            if (hash == super.hash()) {
                if (BoxesRunTime.equals(key, this.key())) {
                    return this;
                }
                return new HashSetCollision1(hash, ((ListSet)((ListSet)ListSet$.MODULE$.empty()).$plus((Object)this.key())).$plus((Object)key), 2);
            }
            return HashSet$.MODULE$.scala$collection$immutable$HashSet$$makeHashTrieSet(super.hash(), this, hash, new HashSet1<A>(key, hash), level, 2);
        }

        @Override
        public HashSet<A> union0(HashSet<A> that, int level) {
            LeafHashSet leafHashSet;
            if (that instanceof HashSet1) {
                HashSet1 hashSet1 = (HashSet1)that;
                leafHashSet = super.hash() == hashSet1.hash() ? (BoxesRunTime.equals(this.key(), hashSet1.key()) ? this : new HashSetCollision1(super.hash(), ((ListSet)((ListSet)ListSet$.MODULE$.empty()).$plus((Object)this.key())).$plus((Object)hashSet1.key()), 2)) : HashSet$.MODULE$.scala$collection$immutable$HashSet$$makeHashTrieSet(super.hash(), this, hashSet1.hash(), hashSet1, level, 2);
            } else {
                leafHashSet = that.union0(this, level);
            }
            return leafHashSet;
        }

        @Override
        public HashSet<A> intersect0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
            if (that.get0(this.key(), super.hash(), level)) {
                return this;
            }
            return null;
        }

        @Override
        public HashSet<A> diff0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
            if (that.get0(this.key(), super.hash(), level)) {
                return null;
            }
            return this;
        }

        @Override
        public HashSet<A> removed0(A key, int hash, int level) {
            if (hash == super.hash() && BoxesRunTime.equals(key, this.key())) {
                return null;
            }
            return this;
        }

        @Override
        public HashSet<A> filter0(Function1<A, Object> p, boolean negate, int level, HashSet<A>[] buffer, int offset0) {
            if (negate ^ BoxesRunTime.unboxToBoolean(p.apply(this.key()))) {
                return this;
            }
            return null;
        }

        @Override
        public Iterator<A> iterator() {
            return Iterator$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{this.key()}));
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            f.apply(this.key());
        }

        public HashSet1(A key, int hash) {
            this.key = key;
            super(hash);
        }
    }

    public static final class HashSetBuilder<A>
    implements ReusableBuilder<A, HashSet<A>> {
        private HashSet<A> rootNode;

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
        public <NewTo> Builder<A, NewTo> mapResult(Function1<HashSet<A>, NewTo> f) {
            return Builder.mapResult$(this, f);
        }

        private HashSet<A> rootNode() {
            return this.rootNode;
        }

        private void rootNode_$eq(HashSet<A> x$1) {
            this.rootNode = x$1;
        }

        private boolean isMutable(HashSet<A> hs) {
            return hs instanceof HashTrieSet && hs.size() == -1;
        }

        private HashTrieSet<A> makeMutable(HashTrieSet<A> hs) {
            if (this.isMutable(hs)) {
                return hs;
            }
            HashSet[] elems = new HashSet[32];
            int iBit = 0;
            for (int bit = 0; bit < 32; ++bit) {
                if ((hs.bitmap() & 1 << bit) == 0) continue;
                elems[bit] = hs.elems()[iBit];
                ++iBit;
            }
            return new HashTrieSet(-1, elems, -1);
        }

        private HashSet<A> makeImmutable(HashSet<A> hs) {
            HashSet<A> hashSet;
            HashTrieSet hashTrieSet;
            if (hs instanceof HashTrieSet && this.isMutable(hashTrieSet = (HashTrieSet)hs)) {
                HashTrieSet hashTrieSet2;
                int bit;
                int bitmap = 0;
                int size = 0;
                for (bit = 0; bit < 32; ++bit) {
                    if (hashTrieSet.elems()[bit] != null) {
                        hashTrieSet.elems()[bit] = this.makeImmutable(hashTrieSet.elems()[bit]);
                    }
                    if (hashTrieSet.elems()[bit] == null) continue;
                    bitmap |= 1 << bit;
                    size += hashTrieSet.elems()[bit].size();
                }
                int n = Integer.bitCount(bitmap);
                switch (n) {
                    case 0: {
                        hashTrieSet2 = null;
                        break;
                    }
                    case 1: {
                        if (hashTrieSet.elems()[Integer.numberOfTrailingZeros(bitmap)] instanceof LeafHashSet) {
                            hashTrieSet2 = hashTrieSet.elems()[Integer.numberOfTrailingZeros(bitmap)];
                            break;
                        }
                    }
                    default: {
                        HashSet<A>[] hashSetArray;
                        if (n == 32) {
                            hashSetArray = hashTrieSet.elems();
                        } else {
                            HashSet[] elems = new HashSet[n];
                            int oBit = 0;
                            for (bit = 0; bit < 32; ++bit) {
                                if (hashTrieSet.elems()[bit] == null) continue;
                                elems[oBit] = hashTrieSet.elems()[bit];
                                ++oBit;
                            }
                            Predef$.MODULE$.assert(oBit == n);
                            hashSetArray = elems;
                        }
                        HashSet<A>[] elems = hashSetArray;
                        hashTrieSet.size0_$eq(size);
                        hashTrieSet.elems_$eq(elems);
                        hashTrieSet.bitmap_$eq(bitmap);
                        hashTrieSet2 = hashTrieSet;
                    }
                }
                hashSet = hashTrieSet2;
            } else {
                hashSet = hs;
            }
            return hashSet;
        }

        @Override
        public void clear() {
            HashTrieSet hashTrieSet;
            HashSet<A> hashSet = this.rootNode();
            if (hashSet instanceof HashTrieSet && this.isMutable(hashTrieSet = (HashTrieSet)hashSet)) {
                Arrays.fill(hashTrieSet.elems(), null);
                return;
            }
            this.rootNode_$eq((HashSet)HashSet$.MODULE$.empty());
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public HashSet<A> result() {
            void scala$collection$immutable$HashSet$$nullToEmpty_s;
            HashSet$ hashSet$ = HashSet$.MODULE$;
            HashSet hashSet = this.makeImmutable(this.rootNode());
            if (hashSet$ == null) {
                throw null;
            }
            HashSet$ scala$collection$immutable$HashSet$$nullToEmpty_this = hashSet$;
            this.rootNode_$eq(scala$collection$immutable$HashSet$$nullToEmpty_s == null ? (HashSet)scala$collection$immutable$HashSet$$nullToEmpty_this.empty() : hashSet);
            VM.releaseFence();
            return this.rootNode();
        }

        @Override
        public HashSetBuilder<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
            this.$plus$eq((Object)elem1);
            this.$plus$eq((Object)elem2);
            return this.$plus$plus$eq((TraversableOnce)elems);
        }

        @Override
        public HashSetBuilder<A> $plus$eq(A elem) {
            int hash = HashSet$.MODULE$.computeHash(elem);
            this.rootNode_$eq(this.addOne(this.rootNode(), elem, hash, 0));
            return this;
        }

        @Override
        public HashSetBuilder<A> $plus$plus$eq(TraversableOnce<A> xs) {
            HashSetBuilder hashSetBuilder;
            if (xs instanceof HashSet) {
                HashSet hashSet = (HashSet)xs;
                if (this.rootNode().isEmpty()) {
                    if (!hashSet.isEmpty()) {
                        this.rootNode_$eq(hashSet);
                    }
                } else {
                    this.rootNode_$eq(this.addHashSet(this.rootNode(), hashSet, 0));
                }
                hashSetBuilder = this;
            } else {
                hashSetBuilder = xs instanceof scala.collection.mutable.HashSet ? (HashSetBuilder)Growable.$plus$plus$eq$(this, xs) : (HashSetBuilder)Growable.$plus$plus$eq$(this, xs);
            }
            return hashSetBuilder;
        }

        public HashTrieSet<A> makeMutableTrie(LeafHashSet<A> aLeaf, LeafHashSet<A> bLeaf, int level) {
            int bRawIndex;
            HashSet[] elems = new HashSet[32];
            int aRawIndex = aLeaf.hash() >>> level & 0x1F;
            if (aRawIndex == (bRawIndex = bLeaf.hash() >>> level & 0x1F)) {
                elems[aRawIndex] = this.makeMutableTrie(aLeaf, bLeaf, level + 5);
            } else {
                elems[aRawIndex] = aLeaf;
                elems[bRawIndex] = bLeaf;
            }
            return new HashTrieSet(-1, elems, -1);
        }

        public HashTrieSet<A> makeMutableTrie(LeafHashSet<A> leaf, A elem, int elemImprovedHash, int level) {
            return this.makeMutableTrie(leaf, new HashSet1<A>(elem, elemImprovedHash), level);
        }

        private HashSet<A> addOne(HashSet<A> toNode, A elem, int improvedHash, int level) {
            HashTrieSet<A> hashTrieSet;
            block8: {
                block9: {
                    HashTrieSet<A> hashTrieSet2;
                    HashSet1<A> merged;
                    int arrayIndex;
                    HashTrieSet<A> hashTrieSet3;
                    while (true) {
                        boolean bl = false;
                        hashTrieSet3 = null;
                        if (toNode instanceof LeafHashSet) {
                            LeafHashSet leafHashSet = (LeafHashSet)toNode;
                            hashTrieSet = leafHashSet.hash() == improvedHash ? leafHashSet.updated0(elem, improvedHash, level) : this.makeMutableTrie(leafHashSet, elem, improvedHash, level);
                            break block8;
                        }
                        if (toNode instanceof HashTrieSet) {
                            bl = true;
                            hashTrieSet3 = (HashTrieSet<A>)toNode;
                            if (this.isMutable(hashTrieSet3)) {
                                int arrayIndex2 = improvedHash >>> level & 0x1F;
                                HashSet old = hashTrieSet3.elems()[arrayIndex2];
                                hashTrieSet3.elems()[arrayIndex2] = old == null ? new HashSet1<A>(elem, improvedHash) : this.addOne(old, elem, improvedHash, level + 5);
                                hashTrieSet = hashTrieSet3;
                                break block8;
                            }
                        }
                        if (!bl) break block9;
                        int rawIndex = improvedHash >>> level & 0x1F;
                        arrayIndex = this.compressedIndex(hashTrieSet3, rawIndex);
                        if (arrayIndex != -1) break;
                        toNode = this.makeMutable(hashTrieSet3);
                    }
                    HashSet old = hashTrieSet3.elems()[arrayIndex];
                    HashSet hashSet = merged = old == null ? new HashSet1<A>(elem, improvedHash) : this.addOne(old, elem, improvedHash, level + 5);
                    if (merged == old) {
                        hashTrieSet2 = hashTrieSet3;
                    } else {
                        HashTrieSet<A> newMutableTrie = this.makeMutable(hashTrieSet3);
                        newMutableTrie.elems()[rawIndex] = merged;
                        hashTrieSet2 = newMutableTrie;
                    }
                    hashTrieSet = hashTrieSet2;
                    break block8;
                }
                if (toNode.isEmpty()) {
                    hashTrieSet = toNode.updated0(elem, improvedHash, level);
                } else {
                    throw new MatchError(toNode);
                }
            }
            return hashTrieSet;
        }

        private int compressedIndex(HashTrieSet<A> trie, int rawIndex) {
            if (trie.bitmap() == -1) {
                return rawIndex;
            }
            if ((trie.bitmap() & 1 << rawIndex) == 0) {
                return -1;
            }
            return Integer.bitCount((1 << rawIndex) - 1 & trie.bitmap());
        }

        private int trieIndex(HashTrieSet<A> trie, int rawIndex) {
            if (this.isMutable(trie) || trie.bitmap() == -1) {
                return rawIndex;
            }
            return this.compressedIndex(trie, rawIndex);
        }

        private HashSet<A> addHashSet(HashSet<A> toNode, HashSet<A> toBeAdded, int level) {
            HashSet<A> hashSet;
            if (toNode instanceof LeafHashSet) {
                LeafHashSet leafHashSet = (LeafHashSet)toNode;
                hashSet = this.addToLeafHashSet(leafHashSet, toBeAdded, level);
            } else if (toNode instanceof HashTrieSet) {
                HashTrieSet hashTrieSet = (HashTrieSet)toNode;
                hashSet = this.addToTrieHashSet(hashTrieSet, toBeAdded, level);
            } else if (toNode.isEmpty()) {
                hashSet = toNode;
            } else {
                throw new MatchError(toNode);
            }
            return hashSet;
        }

        private HashSet<A> addToTrieHashSet(HashTrieSet<A> toNode, HashSet<A> toBeAdded, int level) {
            HashTrieSet<A> hashTrieSet;
            if (toNode == toBeAdded) {
                return toNode;
            }
            if (toBeAdded instanceof LeafHashSet) {
                HashTrieSet<A> hashTrieSet2;
                int rawIndex = ((LeafHashSet)toBeAdded).hash() >>> level & 0x1F;
                int arrayIndex = this.trieIndex(toNode, rawIndex);
                if (arrayIndex == -1) {
                    HashTrieSet<A> newToNode = this.makeMutable(toNode);
                    newToNode.elems()[rawIndex] = toBeAdded;
                    hashTrieSet2 = newToNode;
                } else {
                    HashSet<A> old = toNode.elems()[arrayIndex];
                    if (old == toBeAdded) {
                        hashTrieSet2 = toNode;
                    } else if (old == null) {
                        Predef$.MODULE$.assert(this.isMutable(toNode));
                        toNode.elems()[arrayIndex] = toBeAdded;
                        hashTrieSet2 = toNode;
                    } else {
                        HashSet<A> result2 = this.addHashSet(old, toBeAdded, level + 5);
                        if (result2 == old) {
                            hashTrieSet2 = toNode;
                        } else {
                            HashTrieSet<A> newToNode = this.makeMutable(toNode);
                            newToNode.elems()[rawIndex] = result2;
                            hashTrieSet2 = newToNode;
                        }
                    }
                }
                hashTrieSet = hashTrieSet2;
            } else if (toBeAdded instanceof HashTrieSet) {
                HashTrieSet hashTrieSet3 = (HashTrieSet)toBeAdded;
                HashTrieSet<A> result3 = toNode;
                int bBitSet = hashTrieSet3.bitmap();
                int bArrayIndex = 0;
                while (bBitSet != 0) {
                    HashSet bValue = hashTrieSet3.elems()[bArrayIndex];
                    int rawIndex = Integer.numberOfTrailingZeros(bBitSet);
                    int aArrayIndex = this.trieIndex(result3, rawIndex);
                    if (aArrayIndex == -1) {
                        result3 = this.makeMutable(result3);
                        result3.elems()[rawIndex] = bValue;
                    } else {
                        HashSet<A> aValue = result3.elems()[aArrayIndex];
                        if (aValue != bValue) {
                            if (aValue == null) {
                                Predef$.MODULE$.assert(this.isMutable(result3));
                                result3.elems()[rawIndex] = bValue;
                            } else {
                                HashSet<A> resultAtIndex = this.addHashSet(aValue, bValue, level + 5);
                                if (resultAtIndex != aValue) {
                                    result3 = this.makeMutable(result3);
                                    result3.elems()[rawIndex] = resultAtIndex;
                                }
                            }
                        }
                    }
                    bBitSet ^= 1 << rawIndex;
                    ++bArrayIndex;
                }
                hashTrieSet = result3;
            } else if (toBeAdded.isEmpty()) {
                hashTrieSet = toNode;
            } else {
                throw new MatchError(toBeAdded);
            }
            return hashTrieSet;
        }

        private HashSet<A> addToLeafHashSet(LeafHashSet<A> toNode, HashSet<A> toBeAdded, int level) {
            HashSet hashSet;
            if (toNode == toBeAdded) {
                return toNode;
            }
            if (toBeAdded instanceof LeafHashSet) {
                LeafHashSet leafHashSet = (LeafHashSet)toBeAdded;
                hashSet = toNode.hash() == leafHashSet.hash() ? toNode.union0(leafHashSet, level) : this.makeMutableTrie(toNode, leafHashSet, level);
            } else if (toBeAdded instanceof HashTrieSet) {
                HashSet hashSet2;
                HashTrieSet hashTrieSet = (HashTrieSet)toBeAdded;
                int rawIndex = toNode.hash() >>> level & 0x1F;
                int arrayIndex = this.compressedIndex(hashTrieSet, rawIndex);
                if (arrayIndex == -1) {
                    HashTrieSet<A> result2 = this.makeMutable(hashTrieSet);
                    result2.elems()[rawIndex] = toNode;
                    hashSet2 = result2;
                } else {
                    HashSet<A> newEle = this.addToLeafHashSet(toNode, hashTrieSet.elems()[arrayIndex], level + 5);
                    if (newEle == toBeAdded) {
                        hashSet2 = toBeAdded;
                    } else {
                        HashTrieSet<A> result3 = this.makeMutable(hashTrieSet);
                        result3.elems()[rawIndex] = newEle;
                        hashSet2 = result3;
                    }
                }
                hashSet = hashSet2;
            } else if (toBeAdded.isEmpty()) {
                hashSet = toNode;
            } else {
                throw new MatchError(toBeAdded);
            }
            return hashSet;
        }

        public HashSetBuilder() {
            Growable.$init$(this);
            Builder.$init$(this);
            this.rootNode = (HashSet)HashSet$.MODULE$.empty();
        }
    }

    public static class HashSetCollision1<A>
    extends LeafHashSet<A> {
        private final ListSet<A> ks;
        private final int size;

        private /* synthetic */ int super$hash() {
            return super.hash();
        }

        public ListSet<A> ks() {
            return this.ks;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean get0(A key, int hash, int level) {
            if (hash == super.hash()) {
                return this.ks().contains(key);
            }
            return false;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object other) {
            if (other instanceof HashSetCollision1) {
                HashSetCollision1 hashSetCollision1 = (HashSetCollision1)other;
                if (this == hashSetCollision1) return true;
                if (super.hash() != hashSetCollision1.hash()) return false;
                ListSet<A> listSet = this.ks();
                ListSet<A> listSet2 = hashSetCollision1.ks();
                if (listSet != null) {
                    if (!((Object)listSet).equals(listSet2)) return false;
                    return true;
                }
                if (listSet2 == null) return true;
                return false;
            }
            if (!(other instanceof HashSet)) return GenSetLike.equals$(this, other);
            return false;
        }

        @Override
        public boolean subsetOf0(HashSet<A> that, int level) {
            return this == that || this.ks().forall((Function1<Object, Object> & java.io.Serializable & Serializable)key -> BoxesRunTime.boxToBoolean(that.get0(key, this.super$hash(), level)));
        }

        @Override
        public HashSet<A> updated0(A key, int hash, int level) {
            if (hash == super.hash()) {
                Object ks1 = this.ks().$plus((Object)key);
                if (ks1 == this.ks()) {
                    return this;
                }
                return new HashSetCollision1<A>(hash, ks1, this.size() + 1);
            }
            return HashSet$.MODULE$.scala$collection$immutable$HashSet$$makeHashTrieSet(super.hash(), this, hash, new HashSet1<A>(key, hash), level, this.size() + 1);
        }

        @Override
        public HashSet<A> union0(HashSet<A> that, int level) {
            int newSize;
            Set ks1;
            HashSetCollision1 hashSetCollision1;
            Object ks12;
            HashSet1 hashSet1;
            HashSet hashSet = that instanceof HashSet1 ? ((hashSet1 = (HashSet1)that).hash() != super.hash() ? HashSet$.MODULE$.scala$collection$immutable$HashSet$$makeHashTrieSet(super.hash(), this, hashSet1.hash(), hashSet1, level, this.size() + 1) : ((ks12 = this.ks().$plus(hashSet1.key())) == this.ks() ? this : new HashSetCollision1<A>(super.hash(), ks12, this.size() + 1))) : (that instanceof HashSetCollision1 ? ((hashSetCollision1 = (HashSetCollision1)that).hash() != super.hash() ? HashSet$.MODULE$.scala$collection$immutable$HashSet$$makeHashTrieSet(super.hash(), this, hashSetCollision1.hash(), hashSetCollision1, level, this.size() + hashSetCollision1.size()) : (this == hashSetCollision1 ? this : ((ks1 = this.ks().$plus$plus((GenTraversableOnce)hashSetCollision1.ks())) == this.ks() ? this : ((newSize = ((ListSet)ks1).size()) == hashSetCollision1.size() ? hashSetCollision1 : new HashSetCollision1<A>(super.hash(), ks1, newSize))))) : that.union0(this, level));
            return hashSet;
        }

        @Override
        public HashSet<A> intersect0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
            if (this == that) {
                return this;
            }
            ListSet ks1 = (ListSet)this.ks().filter((Function1<Object, Object> & java.io.Serializable & Serializable)(T1 x$1) -> BoxesRunTime.boxToBoolean(that.get0(x$1, this.super$hash(), level)));
            int n = ks1.size();
            HashSet hashSet = 0 == n ? null : (n == this.size() ? this : (n == that.size() ? that : (1 == n ? new HashSet1(ks1.head(), super.hash()) : new HashSetCollision1<A>(super.hash(), ks1, n))));
            return hashSet;
        }

        @Override
        public HashSet<A> diff0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
            if (this == that) {
                return null;
            }
            ListSet ks1 = (ListSet)this.ks().filterNot((Function1<Object, Object> & java.io.Serializable & Serializable)(T1 x$2) -> BoxesRunTime.boxToBoolean(that.get0(x$2, this.super$hash(), level)));
            int n = ks1.size();
            LeafHashSet leafHashSet = 0 == n ? null : (n == this.size() ? this : (1 == n ? new HashSet1(ks1.head(), super.hash()) : new HashSetCollision1<A>(super.hash(), ks1, n)));
            return leafHashSet;
        }

        @Override
        public HashSet<A> removed0(A key, int hash, int level) {
            if (hash == super.hash()) {
                Object ks1 = this.ks().$minus((Object)key);
                if (ks1 == this.ks()) {
                    return this;
                }
                if (this.size() == 2) {
                    return new HashSet1(((AbstractIterable)ks1).head(), hash);
                }
                return new HashSetCollision1<A>(hash, ks1, this.size() - 1);
            }
            return this;
        }

        @Override
        public HashSet<A> filter0(Function1<A, Object> p, boolean negate, int level, HashSet<A>[] buffer, int offset0) {
            ListSet ks1;
            ListSet listSet = ks1 = negate ? (ListSet)this.ks().filterNot((Function1)p) : (ListSet)this.ks().filter((Function1)p);
            if (ks1 == this.ks()) {
                return this;
            }
            int n = ks1.size();
            switch (n) {
                case 0: {
                    return null;
                }
                case 1: {
                    return new HashSet1(ks1.head(), super.hash());
                }
            }
            if (n == this.size()) {
                return this;
            }
            return new HashSetCollision1<A>(super.hash(), ks1, n);
        }

        @Override
        public Iterator<A> iterator() {
            return this.ks().iterator();
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            this.ks().foreach(f);
        }

        public HashSetCollision1(int hash, ListSet<A> ks, int size) {
            this.ks = ks;
            this.size = size;
            super(hash);
        }
    }

    public static class HashTrieSet<A>
    extends HashSet<A> {
        private int bitmap;
        private HashSet<A>[] elems;
        private int size0;

        public int bitmap() {
            return this.bitmap;
        }

        public void bitmap_$eq(int x$1) {
            this.bitmap = x$1;
        }

        public HashSet<A>[] elems() {
            return this.elems;
        }

        public void elems_$eq(HashSet<A>[] x$1) {
            this.elems = x$1;
        }

        public int size0() {
            return this.size0;
        }

        public void size0_$eq(int x$1) {
            this.size0 = x$1;
        }

        @Override
        public final int size() {
            return this.size0();
        }

        @Override
        public boolean get0(A key, int hash, int level) {
            int index = hash >>> level & 0x1F;
            int mask = 1 << index;
            if (this.bitmap() == -1) {
                return this.elems()[index & 0x1F].get0(key, hash, level + 5);
            }
            if ((this.bitmap() & mask) != 0) {
                int offset = Integer.bitCount(this.bitmap() & mask - 1);
                return this.elems()[offset].get0(key, hash, level + 5);
            }
            return false;
        }

        @Override
        public HashSet<A> updated0(A key, int hash, int level) {
            int index = hash >>> level & 0x1F;
            int mask = 1 << index;
            int offset = Integer.bitCount(this.bitmap() & mask - 1);
            if ((this.bitmap() & mask) != 0) {
                HashSet<A> subNew;
                HashSet<A> sub = this.elems()[offset];
                if (sub == (subNew = sub.updated0(key, hash, level + 5))) {
                    return this;
                }
                HashSet[] elemsNew = new HashSet[this.elems().length];
                System.arraycopy(this.elems(), 0, elemsNew, 0, this.elems().length);
                elemsNew[offset] = subNew;
                return new HashTrieSet<A>(this.bitmap(), elemsNew, this.size0() + 1);
            }
            HashSet[] elemsNew = new HashSet[this.elems().length + 1];
            System.arraycopy(this.elems(), 0, elemsNew, 0, offset);
            elemsNew[offset] = new HashSet1<A>(key, hash);
            System.arraycopy(this.elems(), offset, elemsNew, offset + 1, this.elems().length - offset);
            int bitmapNew = this.bitmap() | mask;
            return new HashTrieSet<A>(bitmapNew, elemsNew, this.size0() + 1);
        }

        @Override
        public HashSet<A> union0(HashSet<A> that, int level) {
            HashTrieSet hashTrieSet;
            if (that == this) {
                hashTrieSet = this;
            } else if (that instanceof LeafHashSet) {
                HashTrieSet hashTrieSet2;
                LeafHashSet leafHashSet = (LeafHashSet)that;
                int index = leafHashSet.hash() >>> level & 0x1F;
                int mask = 1 << index;
                int offset = Integer.bitCount(this.bitmap() & mask - 1);
                if ((this.bitmap() & mask) != 0) {
                    HashSet<A> sub = this.elems()[offset];
                    if (sub == leafHashSet) {
                        hashTrieSet2 = this;
                    } else {
                        HashSet<A> sub1 = sub.union0(leafHashSet, level + 5);
                        if (sub == sub1) {
                            hashTrieSet2 = this;
                        } else {
                            HashSet[] elems1 = (HashSet[])this.elems().clone();
                            elems1[offset] = sub1;
                            hashTrieSet2 = new HashTrieSet<A>(this.bitmap(), elems1, this.size0() + (sub1.size() - sub.size()));
                        }
                    }
                } else {
                    HashSet[] elems1 = new HashSet[this.elems().length + 1];
                    System.arraycopy(this.elems(), 0, elems1, 0, offset);
                    elems1[offset] = leafHashSet;
                    System.arraycopy(this.elems(), offset, elems1, offset + 1, this.elems().length - offset);
                    int bitmap1 = this.bitmap() | mask;
                    hashTrieSet2 = new HashTrieSet<A>(bitmap1, elems1, this.size0() + leafHashSet.size());
                }
                hashTrieSet = hashTrieSet2;
            } else if (that instanceof HashTrieSet) {
                int bbm;
                HashTrieSet hashTrieSet3 = (HashTrieSet)that;
                int abm = this.bitmap();
                int allBits = abm | (bbm = hashTrieSet3.bitmap());
                hashTrieSet = allBits == abm && (allBits != bbm || this.size0() >= hashTrieSet3.size0()) ? HashTrieSet.addMaybeSubset$1(this, hashTrieSet3, level) : (allBits == bbm ? HashTrieSet.addMaybeSubset$1(hashTrieSet3, this, level) : ((abm & bbm) == 0 ? this.addDistinct$1(hashTrieSet3) : this.addCommon$1(hashTrieSet3, level)));
            } else {
                hashTrieSet = this;
            }
            return hashTrieSet;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public HashSet<A> intersect0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
            HashSet hashSet;
            if (that == this) {
                hashSet = this;
            } else if (that instanceof LeafHashSet) {
                hashSet = ((LeafHashSet)that).intersect0(this, level, buffer, offset0);
            } else if (that instanceof HashTrieSet) {
                HashSet hashSet2;
                HashTrieSet hashTrieSet = (HashTrieSet)that;
                HashSet<A>[] a = this.elems();
                int abm = this.bitmap();
                int ai = 0;
                HashSet<A>[] b = hashTrieSet.elems();
                int bbm = hashTrieSet.bitmap();
                int bi = 0;
                if ((abm & bbm) == 0) {
                    return null;
                }
                int offset = offset0;
                int rs = 0;
                int rbm = 0;
                while ((abm & bbm) != 0) {
                    void scala$collection$immutable$HashSet$$unsignedCompare_j;
                    void scala$collection$immutable$HashSet$$unsignedCompare_i;
                    int alsb = abm ^ abm & abm - 1;
                    int blsb = bbm ^ bbm & bbm - 1;
                    if (alsb == blsb) {
                        HashSet<A> sub1 = a[ai].intersect0(b[bi], level + 5, buffer, offset);
                        if (sub1 != null) {
                            rs += sub1.size();
                            rbm |= alsb;
                            buffer[offset] = sub1;
                            ++offset;
                        }
                        abm &= ~alsb;
                        ++ai;
                        bbm &= ~blsb;
                        ++bi;
                        continue;
                    }
                    int n = blsb - 1;
                    int n2 = alsb - 1;
                    if (HashSet$.MODULE$ == null) {
                        throw null;
                    }
                    if (scala$collection$immutable$HashSet$$unsignedCompare_i < scala$collection$immutable$HashSet$$unsignedCompare_j ^ scala$collection$immutable$HashSet$$unsignedCompare_i < false ^ scala$collection$immutable$HashSet$$unsignedCompare_j < false) {
                        abm &= ~alsb;
                        ++ai;
                        continue;
                    }
                    bbm &= ~blsb;
                    ++bi;
                }
                if (rbm == 0) {
                    hashSet2 = null;
                } else if (rs == this.size0()) {
                    hashSet2 = this;
                } else if (rs == hashTrieSet.size0()) {
                    hashSet2 = hashTrieSet;
                } else {
                    int length = offset - offset0;
                    if (length == 1 && !(buffer[offset0] instanceof HashTrieSet)) {
                        hashSet2 = buffer[offset0];
                    } else {
                        HashSet[] elems = new HashSet[length];
                        System.arraycopy(buffer, offset0, elems, 0, length);
                        hashSet2 = new HashTrieSet<A>(rbm, elems, rs);
                    }
                }
                hashSet = hashSet2;
            } else {
                hashSet = null;
            }
            return hashSet;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public HashSet<A> diff0(HashSet<A> that, int level, HashSet<A>[] buffer, int offset0) {
            HashSet hashSet;
            if (that == this) {
                hashSet = null;
            } else if (that instanceof HashSet1) {
                HashSet1 hashSet1 = (HashSet1)that;
                hashSet = this.removed0(hashSet1.key(), hashSet1.hash(), level);
            } else if (that instanceof HashTrieSet) {
                HashSet hashSet2;
                HashTrieSet hashTrieSet = (HashTrieSet)that;
                HashSet<A>[] a = this.elems();
                int abm = this.bitmap();
                int ai = 0;
                HashSet<A>[] b = hashTrieSet.elems();
                int bbm = hashTrieSet.bitmap();
                int bi = 0;
                int offset = offset0;
                int rs = 0;
                int rbm = 0;
                while (abm != 0) {
                    void scala$collection$immutable$HashSet$$unsignedCompare_j;
                    void scala$collection$immutable$HashSet$$unsignedCompare_i;
                    int alsb = abm ^ abm & abm - 1;
                    int blsb = bbm ^ bbm & bbm - 1;
                    if (alsb == blsb) {
                        HashSet<A> sub1 = a[ai].diff0(b[bi], level + 5, buffer, offset);
                        if (sub1 != null) {
                            rs += sub1.size();
                            rbm |= alsb;
                            buffer[offset] = sub1;
                            ++offset;
                        }
                        abm &= ~alsb;
                        ++ai;
                        bbm &= ~blsb;
                        ++bi;
                        continue;
                    }
                    int n = blsb - 1;
                    int n2 = alsb - 1;
                    if (HashSet$.MODULE$ == null) {
                        throw null;
                    }
                    if (scala$collection$immutable$HashSet$$unsignedCompare_i < scala$collection$immutable$HashSet$$unsignedCompare_j ^ scala$collection$immutable$HashSet$$unsignedCompare_i < false ^ scala$collection$immutable$HashSet$$unsignedCompare_j < false) {
                        HashSet<A> sub1 = a[ai];
                        rs += sub1.size();
                        rbm |= alsb;
                        buffer[offset] = sub1;
                        ++offset;
                        abm &= ~alsb;
                        ++ai;
                        continue;
                    }
                    bbm &= ~blsb;
                    ++bi;
                }
                if (rbm == 0) {
                    hashSet2 = null;
                } else if (rs == this.size0()) {
                    hashSet2 = this;
                } else {
                    int length = offset - offset0;
                    if (length == 1 && !(buffer[offset0] instanceof HashTrieSet)) {
                        hashSet2 = buffer[offset0];
                    } else {
                        HashSet[] elems = new HashSet[length];
                        System.arraycopy(buffer, offset0, elems, 0, length);
                        hashSet2 = new HashTrieSet<A>(rbm, elems, rs);
                    }
                }
                hashSet = hashSet2;
            } else if (that instanceof HashSetCollision1) {
                HashSetCollision1 hashSetCollision1 = (HashSetCollision1)that;
                hashSet = this.removeAll$1(this, hashSetCollision1.ks(), hashSetCollision1, level);
            } else {
                hashSet = this;
            }
            return hashSet;
        }

        @Override
        public HashSet<A> removed0(A key, int hash, int level) {
            int index = hash >>> level & 0x1F;
            int mask = 1 << index;
            int offset = Integer.bitCount(this.bitmap() & mask - 1);
            if ((this.bitmap() & mask) != 0) {
                HashSet<A> subNew;
                HashSet<A> sub = this.elems()[offset];
                if (sub == (subNew = sub.removed0(key, hash, level + 5))) {
                    return this;
                }
                if (subNew == null) {
                    int bitmapNew = this.bitmap() ^ mask;
                    if (bitmapNew != 0) {
                        if (this.elems().length == 2 && !(this.elems()[offset ^ 1] instanceof HashTrieSet)) {
                            return this.elems()[offset ^ 1];
                        }
                        HashSet[] elemsNew = new HashSet[this.elems().length - 1];
                        System.arraycopy(this.elems(), 0, elemsNew, 0, offset);
                        System.arraycopy(this.elems(), offset + 1, elemsNew, offset, this.elems().length - offset - 1);
                        int sizeNew = this.size0() - 1;
                        return new HashTrieSet<A>(bitmapNew, elemsNew, sizeNew);
                    }
                    return null;
                }
                if (this.elems().length == 1 && !(subNew instanceof HashTrieSet)) {
                    return subNew;
                }
                HashSet[] elemsNew = new HashSet[this.elems().length];
                System.arraycopy(this.elems(), 0, elemsNew, 0, this.elems().length);
                elemsNew[offset] = subNew;
                int sizeNew = this.size0() - 1;
                return new HashTrieSet<A>(this.bitmap(), elemsNew, sizeNew);
            }
            return this;
        }

        @Override
        public boolean equals(Object other) {
            HashTrieSet hashTrieSet;
            boolean bl = other instanceof HashTrieSet ? this == (hashTrieSet = (HashTrieSet)other) || this.bitmap() == hashTrieSet.bitmap() && this.size0() == hashTrieSet.size0() && Arrays.equals(this.elems(), hashTrieSet.elems()) : (other instanceof HashSet ? false : GenSetLike.equals$(this, other));
            return bl;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean subsetOf0(HashSet<A> that, int level) {
            if (that == this) return true;
            if (!(that instanceof HashTrieSet)) return false;
            HashTrieSet hashTrieSet = (HashTrieSet)that;
            if ((this.bitmap() & ~hashTrieSet.bitmap()) != 0) return false;
            if (this.size0() > hashTrieSet.size0()) return false;
            int abm = this.bitmap();
            HashSet<A>[] a = this.elems();
            int ai = 0;
            HashSet<A>[] b = hashTrieSet.elems();
            int bbm = hashTrieSet.bitmap();
            int bi = 0;
            if ((abm & bbm) != abm) return false;
            while (abm != 0) {
                int alsb = abm ^ abm & abm - 1;
                int blsb = bbm ^ bbm & bbm - 1;
                if (alsb == blsb) {
                    if (!a[ai].subsetOf0(b[bi], level + 5)) {
                        return false;
                    }
                    abm &= ~alsb;
                    ++ai;
                }
                bbm &= ~blsb;
                ++bi;
            }
            return true;
        }

        @Override
        public HashSet<A> filter0(Function1<A, Object> p, boolean negate, int level, HashSet<A>[] buffer, int offset0) {
            int offset = offset0;
            int rs = 0;
            int kept = 0;
            for (int i = 0; i < this.elems().length; ++i) {
                HashSet<A> result2 = this.elems()[i].filter0(p, negate, level + 5, buffer, offset);
                if (result2 == null) continue;
                buffer[offset] = result2;
                ++offset;
                rs += result2.size();
                kept |= 1 << i;
            }
            if (offset == offset0) {
                return null;
            }
            if (rs == this.size0()) {
                return this;
            }
            if (offset == offset0 + 1 && !(buffer[offset0] instanceof HashTrieSet)) {
                return buffer[offset0];
            }
            int length = offset - offset0;
            HashSet[] elems1 = new HashSet[length];
            System.arraycopy(buffer, offset0, elems1, 0, length);
            int bitmap1 = length == this.elems().length ? this.bitmap() : HashSet$.MODULE$.scala$collection$immutable$HashSet$$keepBits(this.bitmap(), kept);
            return new HashTrieSet<A>(bitmap1, elems1, rs);
        }

        @Override
        public TrieIterator<A> iterator() {
            return new TrieIterator<A>(this){

                public final A getElem(Object cc) {
                    return ((HashSet1)cc).key();
                }
            };
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            for (int i = 0; i < this.elems().length; ++i) {
                this.elems()[i].foreach(f);
            }
        }

        private static final HashTrieSet addMaybeSubset$1(HashTrieSet larger, HashTrieSet smaller, int level$4) {
            HashSet[] resultElems = null;
            int ai = 0;
            int bi = 0;
            int abm = larger.bitmap();
            int bbm = smaller.bitmap();
            HashSet<A>[] a = larger.elems();
            HashSet<A>[] b = smaller.elems();
            int additionalSize = 0;
            int bsb = bbm ^ bbm & bbm - 1;
            while (bsb != 0) {
                HashSet bbi;
                HashSet result2;
                int skippedBitsInA = abm & bsb - 1;
                abm ^= skippedBitsInA;
                HashSet aai = a[ai += Integer.bitCount(skippedBitsInA)];
                HashSet hashSet = result2 = aai == (bbi = b[bi]) ? aai : aai.union0(bbi, level$4 + 5);
                if (result2 != aai) {
                    if (resultElems == null) {
                        resultElems = (HashSet[])a.clone();
                    }
                    additionalSize += result2.size() - aai.size();
                    resultElems[ai] = result2;
                }
                abm ^= bsb;
                bsb = (bbm ^= bsb) ^ bbm & bbm - 1;
                ++ai;
                ++bi;
            }
            if (resultElems == null) {
                return larger;
            }
            return new HashTrieSet(larger.bitmap(), resultElems, larger.size0() + additionalSize);
        }

        private final HashTrieSet addDistinct$1(HashTrieSet that) {
            int ai = 0;
            int bi = 0;
            int offset = 0;
            int abm = this.bitmap();
            int bbm = that.bitmap();
            HashSet<A>[] a = this.elems();
            HashSet<A>[] b = that.elems();
            int allBits = abm | bbm;
            HashSet[] resultElems = new HashSet[Integer.bitCount(allBits)];
            int lsb = allBits ^ allBits & allBits - 1;
            while (lsb != 0) {
                if ((lsb & abm) != 0) {
                    resultElems[offset] = a[ai];
                    ++ai;
                } else {
                    resultElems[offset] = b[bi];
                    ++bi;
                }
                ++offset;
                lsb = (allBits ^= lsb) ^ allBits & allBits - 1;
            }
            return new HashTrieSet<A>(abm | bbm, resultElems, this.size0() + that.size0());
        }

        private final HashTrieSet addCommon$1(HashTrieSet that, int level$4) {
            int ai = 0;
            int bi = 0;
            int abm = this.bitmap();
            int bbm = that.bitmap();
            HashSet<A>[] a = this.elems();
            HashSet<A>[] b = that.elems();
            int allBits = abm | bbm;
            HashSet[] resultElems = new HashSet[Integer.bitCount(allBits)];
            int offset = 0;
            int rs = 0;
            int lsb = allBits ^ allBits & allBits - 1;
            while (lsb != 0) {
                HashSet<A> result2;
                if ((lsb & abm) != 0) {
                    if ((lsb & bbm) != 0) {
                        HashSet<A> aai = a[ai];
                        HashSet<A> bbi = b[bi];
                        result2 = aai == bbi ? aai : aai.union0(bbi, level$4 + 5);
                        ++ai;
                        ++bi;
                    } else {
                        result2 = a[ai];
                        ++ai;
                    }
                } else {
                    result2 = b[bi];
                    ++bi;
                }
                lsb = (allBits ^= lsb) ^ allBits & allBits - 1;
                resultElems[offset] = result2;
                rs += result2.size();
                ++offset;
            }
            return new HashTrieSet<A>(abm | bbm, resultElems, rs);
        }

        private final HashSet removeAll$1(HashSet s, ListSet r, HashSetCollision1 x4$1, int level$5) {
            while (!r.isEmpty() && s != null) {
                HashSet hashSet = s.removed0(r.head(), x4$1.hash(), level$5);
                r = (ListSet)r.tail();
                s = hashSet;
            }
            return s;
        }

        public HashTrieSet(int bitmap, HashSet<A>[] elems, int size0) {
            this.bitmap = bitmap;
            this.elems = elems;
            this.size0 = size0;
        }
    }

    public static abstract class LeafHashSet<A>
    extends HashSet<A> {
        private final int hash;

        public final int hash() {
            return this.hash;
        }

        public LeafHashSet(int hash) {
            this.hash = hash;
        }
    }

    public static class SerializationProxy<A, B>
    implements Serializable {
        public static final long serialVersionUID = 2L;
        private transient HashSet<A> orig;

        private HashSet<A> orig() {
            return this.orig;
        }

        private void orig_$eq(HashSet<A> x$1) {
            this.orig = x$1;
        }

        private void writeObject(ObjectOutputStream out) {
            int s = this.orig().size();
            out.writeInt(s);
            this.orig().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)e -> {
                out.writeObject(e);
                return BoxedUnit.UNIT;
            });
        }

        private void readObject(ObjectInputStream in) {
            this.orig_$eq((HashSet)HashSet$.MODULE$.empty());
            int s = in.readInt();
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Range range = RichInt$.MODULE$.until$extension0(n, s);
            if (range == null) {
                throw null;
            }
            Range foreach$mVc$sp_this = range;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    SerializationProxy.$anonfun$readObject$1(this, in, foreach$mVc$sp_i);
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
            }
        }

        private Object readResolve() {
            return this.orig();
        }

        public static final /* synthetic */ void $anonfun$readObject$1(SerializationProxy $this, ObjectInputStream in$1, int i) {
            Object e = in$1.readObject();
            $this.orig_$eq((HashSet)$this.orig().$plus(e));
        }

        public SerializationProxy(HashSet<A> orig) {
            this.orig = orig;
        }
    }
}

