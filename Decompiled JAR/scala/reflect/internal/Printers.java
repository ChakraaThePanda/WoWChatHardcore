/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.invoke.LambdaMetafactory;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractTraversable;
import scala.collection.GenTraversable;
import scala.collection.IndexedSeqOptimized;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.Map;
import scala.collection.mutable.Map$;
import scala.collection.mutable.SortedSet;
import scala.collection.mutable.SortedSet$;
import scala.collection.mutable.Stack;
import scala.collection.mutable.Stack$;
import scala.collection.mutable.WeakHashMap;
import scala.collection.mutable.WeakHashMap$;
import scala.compat.Platform$;
import scala.math.Ordering$Int$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Exprs;
import scala.reflect.api.Mirror;
import scala.reflect.api.Printers;
import scala.reflect.api.TypeTags;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Chars$;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.FlagSets;
import scala.reflect.internal.Flags$;
import scala.reflect.internal.Names;
import scala.reflect.internal.Printers$CodePrinter$EmptyTypeTree$;
import scala.reflect.internal.Printers$ConsoleWriter$;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.StdNames;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.util.Position;
import scala.reflect.package$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.runtime.java8.JFunction1$mcZI$sp;
import scala.util.Properties$;
import scala.util.matching.Regex;

@ScalaSignature(bytes="\u0006\u0001\u001dug\u0001DA1\u0003G\u0002\n1!\u0001\u0002r\u001dU\u0007bBAC\u0001\u0011\u0005\u0011q\u0011\u0005\b\u0003\u001f\u0003A\u0011AAI\u0011\u001d\ty\t\u0001C\u0001\u0003\u0007Dq!a$\u0001\t\u0003\t9\rC\u0004\u0002L\u0002!I!!4\t\u000f\u0005\r\b\u0001\"\u0001\u0002f\"9\u00111\u001e\u0001\u0005\u0002\u00055\bbBAz\u0001\u0011\u0005\u0011Q\u001f\u0004\u0007\u0003w\u0004\u0001!!@\t\u0015\t\r\u0011B!A!\u0002\u0013\u0011)\u0001C\u0004\u0003\u0016%!\tAa\u0006\t\u0013\tu\u0011\u00021A\u0005\u0012\t}\u0001\"\u0003B\u0014\u0013\u0001\u0007I\u0011\u0003B\u0015\u0011!\u0011y#\u0003Q!\n\t\u0005\u0002\"\u0003B\u0019\u0013\t\u0007I\u0011\u0003B\u0010\u0011!\u0011\u0019$\u0003Q\u0001\n\t\u0005\u0002\"\u0003B\u001b\u0013\u0001\u0007I\u0011\u0003B\u001c\u0011%\u0011\u0019%\u0003a\u0001\n#\u0011)\u0005\u0003\u0005\u0003J%\u0001\u000b\u0015\u0002B\u001d\u0011\u001d\u0011Y%\u0003C\u0001\u0003\u000fCqA!\u0014\n\t\u0003\t9\tC\u0004\u0003P%!\tA!\u0015\t\u000f\tU\u0013\u0002\"\u0005\u0003X!9!1L\u0005\u0005\u0002\u0005\u001d\u0005b\u0002B/\u0013\u0011\u0005!q\f\u0005\b\u0005GKA\u0011\u0001BS\u0011\u001d\u0011I,\u0003C\u0001\u0005wCqA!/\n\t\u0003\u0011)\rC\u0004\u0003L&!\tA!4\t\u000f\te\u0017\u0002\"\u0001\u0003\\\"9!\u0011^\u0005\u0005\u0002\t-\bb\u0002By\u0013\u0011E!1\u001f\u0005\n\u0007\u000fI\u0011\u0013!C\t\u0007\u0013A\u0011ba\b\n#\u0003%\tb!\t\t\u0013\r\u0015\u0012\"%A\u0005\u0012\r\u0005\u0002\"CB\u0014\u0013\t\u0007I\u0011CB\u0015\u0011!\u0019Y#\u0003Q\u0001\n\u0005u\u0006bBB\u0017\u0013\u0011E1q\u0006\u0005\b\u0007gIA\u0011CB\u001b\u0011\u001d\u0019\u0019%\u0003C\u0001\u0007\u000bB\u0011b!\u0014\n#\u0003%\ta!\u0003\t\u000f\r=\u0013\u0002\"\u0001\u0004R!91QK\u0005\u0005\u0002\r]\u0003bBB.\u0013\u0011%1Q\f\u0005\b\u0007\u007fJA\u0011BBA\u0011\u001d\u0019I)\u0003C\u0001\u0007\u0017Cqaa%\n\t\u0003\u0019)\nC\u0004\u0004$&!\ta!*\t\u000f\rU\u0016\u0002\"\u0001\u00048\"I1\u0011Y\u0005A\u0002\u0013%11\u0019\u0005\n\u0007\u000bL\u0001\u0019!C\u0005\u0007\u000fD\u0001ba3\nA\u0003&1q\u000e\u0005\n\u0007\u001bL\u0001\u0019!C\u0005\u0007\u001fD\u0011ba7\n\u0001\u0004%Ia!8\t\u0011\r\u0005\u0018\u0002)Q\u0005\u0007#Dqaa9\n\t#\u0019)\u000fC\u0004\u0004t&!\tb!>\t\u000f\u0011-\u0011\u0002\"\u0005\u0005\u000e!9A\u0011E\u0005\u0005\u0012\u0011\r\u0002b\u0002C\u0015\u0013\u0011EA1\u0006\u0005\b\tsIA\u0011\u0003C\u001e\u0011\u001d!)%\u0003C\t\t\u000fBq\u0001\"\u0016\n\t#!9\u0006C\u0005\u0005h%\t\n\u0011\"\u0005\u0004\n!9A\u0011N\u0005\u0005\u0012\u0011-\u0004bBB+\u0013\u0011EAq\u000f\u0005\b\t\u0003KA\u0011\u0001CB\u0011\u001d!9)\u0003C\u0001\t\u00133a\u0001\"&\u0001\u0001\u0011]\u0005B\u0003B\u0002\u000b\n\u0005\t\u0015!\u0003\u0003\u0006!QA\u0011T#\u0003\u0002\u0003\u0006I!!0\t\u000f\tUQ\t\"\u0001\u0005\u001c\"IA1U#C\u0002\u0013EAQ\u0015\u0005\t\to+\u0005\u0015!\u0003\u0005(\"9A\u0011X#\u0005\u0012\u0011m\u0006b\u0002Cb\u000b\u0012EA1\u0018\u0005\b\t\u000b,E\u0011\u0003Cd\u0011%!i-RI\u0001\n#\u0019I\u0001C\u0004\u0005P\u0016#\t\u0002\"5\t\u0013\r\u001dRI1A\u0005R\r%\u0002\u0002CB\u0016\u000b\u0002\u0006I!!0\t\u000f\u0011eW\t\"\u0005\u0005\\\"IAq`#\u0012\u0002\u0013EQ\u0011\u0001\u0005\n\u000b\u000b)\u0015\u0013!C\t\u000b\u000fA\u0011\"b\u0003F#\u0003%\t\"\"\u0004\t\u0013\u0015EQ)%A\u0005\u0012\u0015M\u0001\"CC\f\u000bF\u0005I\u0011CC\r\u0011%)i\"RI\u0001\n#)y\u0002C\u0005\u0006$\u0015\u000b\n\u0011\"\u0005\u0006&!9Q\u0011F#\u0005\u0012\u0015-\u0002bBC\u0019\u000b\u0012EQ1\u0007\u0005\b\u000bo)E\u0011CC\u001d\u0011\u001d)i$\u0012C\t\u000b\u007f9q!b\u0011F\u0011\u0003))EB\u0004\u0006J\u0015C\t!b\u0013\t\u000f\tUq\f\"\u0001\u0006N!9QqJ0\u0005\u0002\u0015E\u0003bBC/\u000b\u0012EQq\f\u0005\b\u000bG*E\u0011CC3\u0011%))(\u0012b\u0001\n\u0003)9\b\u0003\u0005\u0006\u0002\u0016\u0003\u000b\u0011BC=\u0011%)\u0019)\u0012b\u0001\n\u0003)9\b\u0003\u0005\u0006\u0006\u0016\u0003\u000b\u0011BC=\u0011\u001d)9)\u0012C\t\u000b\u0013C\u0011\"b'F#\u0003%\t\"\"(\t\u000f\u0015\rV\t\"\u0005\u0006&\"IQ1V#\u0012\u0002\u0013EQQ\u0016\u0005\b\u000b_+E\u0011CCY\u0011\u001d\u0019I)\u0012C!\u000bkCqAa)F\t\u0003*Y\fC\u0004\u0004$\u0016#\t!\"2\t\u0013\u00155W)%A\u0005\u0002\r%\u0001bBBJ\u000b\u0012\u0005Sq\u001a\u0005\b\u0007'+E\u0011ACk\u0011\u001d\u0019y%\u0012C\u0001\u000b7Dqaa\u0014F\t\u0003*\t\u000fC\u0004\u0006f\u0016#\t\"b:\t\u000f\rUV\t\"\u0011\u0006p\"9Q1_#\u0005\u0012\u0015U\bb\u0002CA\u000b\u0012\u0005S\u0011 \u0005\b\u000b{,E\u0011AC\u0000\u0011\u001d1\u0019\u0001\u0001C\u0001\r\u000bAqA\"\u0004\u0001\t\u00031y\u0001C\u0004\u0007\u001a\u0001!\tAb\u0007\t\u000f\u0019e\u0001\u0001\"\u0001\u0007 !9a\u0011\u0004\u0001\u0005\u0002\u0019-ra\u0002D\u0017\u0001!\u0005aq\u0006\u0004\b\rc\u0001\u0001\u0012\u0001D\u001a\u0011!\u0011)\"!\u0001\u0005\u0002\u0019m\u0002\u0002\u0003D\u001f\u0003\u0003!\tEb\u0010\t\u0011\u0019u\u0012\u0011\u0001C\u0001\r\u000bB\u0001b!\u0002\u0002\u0002\u0011\u0005\u0011q\u0011\u0005\t\r?\n\t\u0001\"\u0001\u0002\b\"9a\u0011\r\u0001\u0005\u0002\u0019\rdA\u0002DJ\u0001\u00111)\n\u0003\u0005\u0003\u0016\u0005=A\u0011\u0001DL\u0011)1I*a\u0004C\u0002\u0013%a1\u0014\u0005\n\rc\u000by\u0001)A\u0005\r;C\u0001B\"/\u0002\u0010\u0011%a1\u0018\u0005\u000b\r\u001f\fyA1A\u0005\n\u0019E\u0007\"\u0003Dp\u0003\u001f\u0001\u000b\u0011\u0002Dj\u0011!1\t/a\u0004\u0005\n\u0019\r\bB\u0003DG\u0003\u001f\u0011\r\u0011\"\u0003\u0007r\"Iaq`A\bA\u0003%a1\u001f\u0005\t\u000f\u000f\ty\u0001\"\u0003\b\n!AqqCA\b\t\u00039I\u0002\u0003\u0005\b.\u0005=A\u0011AD\u0018\u0011!!9)a\u0004\u0005\u0002\u001d\u0015cA\u0002D4\u0001\u00011I\u0007C\u0006\u0003\u0004\u0005-\"\u0011!Q\u0001\n\t\u0015\u0001\u0002\u0003B\u000b\u0003W!\tAb\u001b\t\u0015\u0019=\u00141\u0006a\u0001\n\u0013\u0011y\u0002\u0003\u0006\u0007r\u0005-\u0002\u0019!C\u0005\rgB\u0011Bb\u001e\u0002,\u0001\u0006KA!\t\t\u0015\u0019e\u00141\u0006a\u0001\n\u0013\u0019I\u0003\u0003\u0006\u0007|\u0005-\u0002\u0019!C\u0005\r{B\u0011B\"!\u0002,\u0001\u0006K!!0\t\u0015\u0019\r\u00151\u0006a\u0001\n\u0013\u0019I\u0003\u0003\u0006\u0007\u0006\u0006-\u0002\u0019!C\u0005\r\u000fC\u0011Bb#\u0002,\u0001\u0006K!!0\t\u0015\u00195\u00151\u0006b\u0001\n\u00131y\tC\u0005\u0007\u0000\u0006-\u0002\u0015!\u0003\u0007\u0012\"AAqQA\u0016\t\u00039I\u0006\u0003\u0005\b^\u0005-B\u0011AD0\u0011)99(a\u000b\u0012\u0002\u0013\u0005q\u0011\u0010\u0005\u000b\u000f{\nY#%A\u0005\u0002\u001d}\u0004BCDB\u0003W\t\n\u0011\"\u0001\bz!AqQQA\u0016\t\u000399\t\u0003\u0006\b\u001e\u0006-\u0012\u0013!C\u0001\u000f?C!bb)\u0002,E\u0005I\u0011AD@\u0011)9)+a\u000b\u0012\u0002\u0013\u0005qq\u0014\u0005\b\u000fS\u0003A\u0011ADV\u0011\u001d9I\u000b\u0001C\u0001\u000f_Cqa\"+\u0001\t\u00039i\fC\u0004\bN\u0002!\tab4\u0003\u0011A\u0013\u0018N\u001c;feNTA!!\u001a\u0002h\u0005A\u0011N\u001c;fe:\fGN\u0003\u0003\u0002j\u0005-\u0014a\u0002:fM2,7\r\u001e\u0006\u0003\u0003[\nQa]2bY\u0006\u001c\u0001aE\u0003\u0001\u0003g\nY\b\u0005\u0003\u0002v\u0005]TBAA6\u0013\u0011\tI(a\u001b\u0003\r\u0005s\u0017PU3g!\u0011\ti(a!\u000e\u0005\u0005}$\u0002BAA\u0003O\n1!\u00199j\u0013\u0011\t\t'a \u0002\r\u0011Jg.\u001b;%)\t\tI\t\u0005\u0003\u0002v\u0005-\u0015\u0002BAG\u0003W\u0012A!\u00168ji\u0006Q\u0011/^8uK\u0012t\u0015-\\3\u0015\r\u0005M\u0015\u0011VA]!\u0011\t)*a)\u000f\t\u0005]\u0015q\u0014\t\u0005\u00033\u000bY'\u0004\u0002\u0002\u001c*!\u0011QTA8\u0003\u0019a$o\\8u}%!\u0011\u0011UA6\u0003\u0019\u0001&/\u001a3fM&!\u0011QUAT\u0005\u0019\u0019FO]5oO*!\u0011\u0011UA6\u0011\u001d\tYK\u0001a\u0001\u0003[\u000bAA\\1nKB!\u0011qVAY\u001b\u0005\u0001\u0011\u0002BAZ\u0003k\u0013AAT1nK&!\u0011qWA2\u0005\u0015q\u0015-\\3t\u0011\u001d\tYL\u0001a\u0001\u0003{\u000ba\u0001Z3d_\u0012,\u0007\u0003BA;\u0003\u007fKA!!1\u0002l\t9!i\\8mK\u0006tG\u0003BAJ\u0003\u000bDq!a+\u0004\u0001\u0004\ti\u000b\u0006\u0003\u0002\u0014\u0006%\u0007bBAV\t\u0001\u0007\u00111S\u0001\u0010gflg*Y7f\u0013:$XM\u001d8bYRA\u00111SAh\u0003;\fy\u000eC\u0004\u0002R\u0016\u0001\r!a5\u0002\tQ\u0014X-\u001a\t\u0005\u0003_\u000b).\u0003\u0003\u0002X\u0006e'\u0001\u0002+sK\u0016LA!a7\u0002d\t)AK]3fg\"9\u00111V\u0003A\u0002\u00055\u0006bBAq\u000b\u0001\u0007\u0011QX\u0001\bI\u0016\u001cw\u000eZ3e\u00039!WmY8eK\u0012\u001c\u00160\u001c(b[\u0016$b!a%\u0002h\u0006%\bbBAi\r\u0001\u0007\u00111\u001b\u0005\b\u0003W3\u0001\u0019AAW\u0003\u001d\u0019\u00180\u001c(b[\u0016$b!a%\u0002p\u0006E\bbBAi\u000f\u0001\u0007\u00111\u001b\u0005\b\u0003W;\u0001\u0019AAW\u00039\u0011\u0017mY6rk>$X\r\u001a)bi\"$B!a%\u0002x\"9\u0011\u0011 \u0005A\u0002\u0005M\u0017!\u0001;\u0003\u0017Q\u0013X-\u001a)sS:$XM]\n\u0006\u0013\u0005M\u0014q \t\u0005\u0003_\u0013\t!\u0003\u0003\u0002|\u0006\r\u0015aA8viB!!q\u0001B\t\u001b\t\u0011IA\u0003\u0003\u0003\f\t5\u0011AA5p\u0015\t\u0011y!\u0001\u0003kCZ\f\u0017\u0002\u0002B\n\u0005\u0013\u00111\u0002\u0015:j]R<&/\u001b;fe\u00061A(\u001b8jiz\"BA!\u0007\u0003\u001cA\u0019\u0011qV\u0005\t\u000f\t\r1\u00021\u0001\u0003\u0006\u0005a\u0011N\u001c3f]Rl\u0015M]4j]V\u0011!\u0011\u0005\t\u0005\u0003k\u0012\u0019#\u0003\u0003\u0003&\u0005-$aA%oi\u0006\u0001\u0012N\u001c3f]Rl\u0015M]4j]~#S-\u001d\u000b\u0005\u0003\u0013\u0013Y\u0003C\u0005\u0003.5\t\t\u00111\u0001\u0003\"\u0005\u0019\u0001\u0010J\u0019\u0002\u001b%tG-\u001a8u\u001b\u0006\u0014x-\u001b8!\u0003)Ig\u000eZ3oiN#X\r]\u0001\fS:$WM\u001c;Ti\u0016\u0004\b%\u0001\u0007j]\u0012,g\u000e^*ue&tw-\u0006\u0002\u0003:A!!1\bB!\u001b\t\u0011iD\u0003\u0003\u0003@\t5\u0011\u0001\u00027b]\u001eLA!!*\u0003>\u0005\u0001\u0012N\u001c3f]R\u001cFO]5oO~#S-\u001d\u000b\u0005\u0003\u0013\u00139\u0005C\u0005\u0003.I\t\t\u00111\u0001\u0003:\u0005i\u0011N\u001c3f]R\u001cFO]5oO\u0002\na!\u001b8eK:$\u0018AB;oI\u0016tG/A\u0007qe&tG\u000fU8tSRLwN\u001c\u000b\u0005\u0003\u0013\u0013\u0019\u0006C\u0004\u0002RZ\u0001\r!a5\u0002\u001dA\u0014\u0018N\u001c;UsB,7/\u00138g_R!\u0011\u0011\u0012B-\u0011\u001d\t\tn\u0006a\u0001\u0003'\fq\u0001\u001d:j]Rdg.\u0001\u0005qe&tGoU3r+\u0011\u0011\tGa \u0015\t\t\r$\u0011\u0013\u000b\u0005\u0005K\u0012\t\b\u0006\u0003\u0002\n\n\u001d\u0004\u0002\u0003B53\u0011\u0005\rAa\u001b\u0002\u0011A\u0014\u0018N\u001c;tKB\u0004b!!\u001e\u0003n\u0005%\u0015\u0002\u0002B8\u0003W\u0012\u0001\u0002\u00102z]\u0006lWM\u0010\u0005\b\u0005gJ\u0002\u0019\u0001B;\u0003%\u0001(/\u001b8uK2,W\u000e\u0005\u0005\u0002v\t]$1PAE\u0013\u0011\u0011I(a\u001b\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\u0003\u0002B?\u0005\u007fb\u0001\u0001B\u0004\u0003\u0002f\u0011\rAa!\u0003\u0003\u0005\fBA!\"\u0003\fB!\u0011Q\u000fBD\u0013\u0011\u0011I)a\u001b\u0003\u000f9{G\u000f[5oOB!\u0011Q\u000fBG\u0013\u0011\u0011y)a\u001b\u0003\u0007\u0005s\u0017\u0010C\u0004\u0003\u0014f\u0001\rA!&\u0002\u00051\u001c\bC\u0002BL\u0005;\u0013YH\u0004\u0003\u0002v\te\u0015\u0002\u0002BN\u0003W\nq\u0001]1dW\u0006<W-\u0003\u0003\u0003 \n\u0005&\u0001\u0002'jgRTAAa'\u0002l\u0005Y\u0001O]5oi\u000e{G.^7o))\tIIa*\u0003.\nE&Q\u0017\u0005\b\u0005SS\u0002\u0019\u0001BV\u0003\t!8\u000f\u0005\u0004\u0003\u0018\nu\u00151\u001b\u0005\b\u0005_S\u0002\u0019AAJ\u0003\u0015\u0019H/\u0019:u\u0011\u001d\u0011\u0019L\u0007a\u0001\u0003'\u000b1a]3q\u0011\u001d\u00119L\u0007a\u0001\u0003'\u000b1!\u001a8e\u0003!\u0001(/\u001b8u%><HCCAE\u0005{\u0013yL!1\u0003D\"9!\u0011V\u000eA\u0002\t-\u0006b\u0002BX7\u0001\u0007\u00111\u0013\u0005\b\u0005g[\u0002\u0019AAJ\u0011\u001d\u00119l\u0007a\u0001\u0003'#b!!#\u0003H\n%\u0007b\u0002BU9\u0001\u0007!1\u0016\u0005\b\u0005gc\u0002\u0019AAJ\u0003=\u0001(/\u001b8u)f\u0004X\rU1sC6\u001cH\u0003BAE\u0005\u001fDqA!+\u001e\u0001\u0004\u0011\t\u000e\u0005\u0004\u0003\u0018\nu%1\u001b\t\u0005\u0003_\u0013).\u0003\u0003\u0003X\u0006e'a\u0002+za\u0016$UMZ\u0001\u0011aJLg\u000e\u001e'bE\u0016d\u0007+\u0019:b[N$B!!#\u0003^\"9!q\u001c\u0010A\u0002\t\u0005\u0018A\u00019t!\u0019\u00119J!(\u0003dB!\u0011q\u0016Bs\u0013\u0011\u00119/!7\u0003\u000b%#WM\u001c;\u0002\u001fA\u0014\u0018N\u001c;MC\n,G\u000eU1sC6$B!!#\u0003n\"9!q^\u0010A\u0002\t\r\u0018!\u00019\u0002\u0019A\f'/\u001a8uQ\u0016\u001c\u0018N_3\u0015\u0011\tU(1 B\u0000\u0007\u0007!B!!#\u0003x\"A!\u0011 \u0011\u0005\u0002\u0004\u0011Y'\u0001\u0003c_\u0012L\b\"\u0003B\u007fAA\u0005\t\u0019AA_\u0003%\u0019wN\u001c3ji&|g\u000eC\u0005\u0004\u0002\u0001\u0002\n\u00111\u0001\u0002\u0014\u0006!q\u000e]3o\u0011%\u0019)\u0001\tI\u0001\u0002\u0004\t\u0019*A\u0003dY>\u001cX-\u0001\fqCJ,g\u000e\u001e5fg&TX\r\n3fM\u0006,H\u000e\u001e\u00132+\t\u0019YA\u000b\u0003\u0002>\u000e51FAB\b!\u0011\u0019\tba\u0007\u000e\u0005\rM!\u0002BB\u000b\u0007/\t\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\t\re\u00111N\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002BB\u000f\u0007'\u0011\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u0003Y\u0001\u0018M]3oi\",7/\u001b>fI\u0011,g-Y;mi\u0012\u0012TCAB\u0012U\u0011\t\u0019j!\u0004\u0002-A\f'/\u001a8uQ\u0016\u001c\u0018N_3%I\u00164\u0017-\u001e7uIM\n\u0001cY8n[\u0016tGo\u001d*fcVL'/\u001a3\u0016\u0005\u0005u\u0016!E2p[6,g\u000e^:SKF,\u0018N]3eA\u000591m\\7nK:$H\u0003BAE\u0007cA\u0001B!?'\t\u0003\u0007!1N\u0001\u001aaJLg\u000e^%na2L7-\u001b;J]B\u000b'/Y7t\u0019&\u001cH\u000f\u0006\u0003\u0002\n\u000e]\u0002bBB\u001dO\u0001\u000711H\u0001\u0004m\u0012\u001c\bC\u0002BL\u0005;\u001bi\u0004\u0005\u0003\u00020\u000e}\u0012\u0002BB!\u00033\u0014aAV1m\t\u00164\u0017\u0001\u00059sS:$h+\u00197vKB\u000b'/Y7t)\u0019\tIia\u0012\u0004J!9!\u0011\u0016\u0015A\u0002\rm\u0002\"CB&QA\u0005\t\u0019AA_\u00035Ig\u000eU1sK:$\b.Z:fg\u0006Q\u0002O]5oiZ\u000bG.^3QCJ\fWn\u001d\u0013eK\u001a\fW\u000f\u001c;%e\u0005Q\u0001O]5oiB\u000b'/Y7\u0015\t\u0005%51\u000b\u0005\b\u0003#T\u0003\u0019AAj\u0003)\u0001(/\u001b8u\u00052|7m\u001b\u000b\u0005\u0003\u0013\u001bI\u0006C\u0004\u0002R.\u0002\r!a5\u0002\u000bMLXN\u00128\u0016\t\r}31\r\u000b\t\u0007C\u001a9g!\u001b\u0004zA!!QPB2\t\u001d\u0019)\u0007\fb\u0001\u0005\u0007\u0013\u0011\u0001\u0016\u0005\b\u0003#d\u0003\u0019AAj\u0011\u001d\u0019Y\u0007\fa\u0001\u0007[\n\u0011A\u001a\t\t\u0003k\u00129ha\u001c\u0004bA!\u0011qVB9\u0013\u0011\u0019\u0019h!\u001e\u0003\rMKXNY8m\u0013\u0011\u00199(a\u0019\u0003\u000fMKXNY8mg\"A11\u0010\u0017\u0005\u0002\u0004\u0019i(\u0001\u0004pe\u0016c7/\u001a\t\u0007\u0003k\u0012ig!\u0019\u0002\u000b%47+_7\u0015\r\u0005u61QBC\u0011\u001d\t\t.\fa\u0001\u0003'DqAa<.\u0001\u0004\u00199\t\u0005\u0005\u0002v\t]4qNA_\u0003!\u0001(/\u001b8u\u001fB$HCBAE\u0007\u001b\u001b\t\nC\u0004\u0004\u0010:\u0002\r!a%\u0002\rA\u0014XMZ5y\u0011\u001d\t\tN\fa\u0001\u0003'\fa\u0002\u001d:j]Rlu\u000eZ5gS\u0016\u00148\u000f\u0006\u0004\u0002\n\u000e]5\u0011\u0014\u0005\b\u0003#|\u0003\u0019AAj\u0011\u001d\u0019Yj\fa\u0001\u0007;\u000bA!\\8egB!\u0011qVBP\u0013\u0011\u0019\t+!7\u0003\u00135{G-\u001b4jKJ\u001c\u0018A\u00039sS:$h\t\\1hgR1\u0011\u0011RBT\u0007cCqa!+1\u0001\u0004\u0019Y+A\u0003gY\u0006<7\u000f\u0005\u0003\u0002v\r5\u0016\u0002BBX\u0003W\u0012A\u0001T8oO\"911\u0017\u0019A\u0002\u0005M\u0015!\u00049sSZ\fG/Z,ji\"Lg.\u0001\tqe&tG/\u00118o_R\fG/[8ogR!\u0011\u0011RB]\u0011\u001d\t\t.\ra\u0001\u0007w\u0003B!a,\u0004>&!1qXAm\u0005%iU-\u001c2fe\u0012+g-\u0001\u0007dkJ\u0014XM\u001c;Po:,'/\u0006\u0002\u0004p\u0005\u00012-\u001e:sK:$xj\u001e8fe~#S-\u001d\u000b\u0005\u0003\u0013\u001bI\rC\u0005\u0003.M\n\t\u00111\u0001\u0004p\u0005i1-\u001e:sK:$xj\u001e8fe\u0002\nAb]3mK\u000e$xN\u001d+za\u0016,\"a!5\u0011\t\u0005=61[\u0005\u0005\u0007+\u001c9N\u0001\u0003UsB,\u0017\u0002BBm\u0003G\u0012Q\u0001V=qKN\f\u0001c]3mK\u000e$xN\u001d+za\u0016|F%Z9\u0015\t\u0005%5q\u001c\u0005\n\u0005[1\u0014\u0011!a\u0001\u0007#\fQb]3mK\u000e$xN\u001d+za\u0016\u0004\u0013a\u00049sS:$\b+Y2lC\u001e,G)\u001a4\u0015\r\u0005%5q]Bx\u0011\u001d\t\t\u000e\u000fa\u0001\u0007S\u0004B!a,\u0004l&!1Q^Am\u0005)\u0001\u0016mY6bO\u0016$UM\u001a\u0005\b\u0007cD\u0004\u0019AAJ\u0003%\u0019X\r]1sCR|'/A\u0006qe&tGOV1m\t\u00164GCBB|\t\u0007!)\u0001\u0006\u0003\u0004z\u000e}H\u0003BAE\u0007wD\u0001b!@:\t\u0003\u0007!1N\u0001\taJLg\u000e\u001e*ig\"AA\u0011A\u001d\u0005\u0002\u0004\u0011Y'\u0001\nqe&tG\u000fV=qKNKwM\\1ukJ,\u0007bBAis\u0001\u00071Q\b\u0005\t\t\u000fID\u00111\u0001\u0005\n\u0005Q!/Z:vYRt\u0015-\\3\u0011\r\u0005U$QNAJ\u0003-\u0001(/\u001b8u\t\u00164G)\u001a4\u0015\r\u0011=Aq\u0003C\u0010)\u0011!\t\u0002\"\u0006\u0015\t\u0005%E1\u0003\u0005\t\u0007{TD\u00111\u0001\u0003l!AA\u0011\u0001\u001e\u0005\u0002\u0004\u0011Y\u0007C\u0004\u0002Rj\u0002\r\u0001\"\u0007\u0011\t\u0005=F1D\u0005\u0005\t;\tIN\u0001\u0004EK\u001a$UM\u001a\u0005\t\t\u000fQD\u00111\u0001\u0005\n\u0005a\u0001O]5oiRK\b/\u001a#fMR1\u0011\u0011\u0012C\u0013\tOAq!!5<\u0001\u0004\u0011\u0019\u000e\u0003\u0005\u0005\bm\"\t\u0019\u0001C\u0005\u0003-\u0001(/\u001b8u\u00136\u0004xN\u001d;\u0015\r\u0005%EQ\u0006C\u001b\u0011\u001d\t\t\u000e\u0010a\u0001\t_\u0001B!a,\u00052%!A1GAm\u0005\u0019IU\u000e]8si\"AAq\u0007\u001f\u0005\u0002\u0004!I!A\u0005sKN\u001cV\r\\3di\u0006a\u0001O]5oi\u000e\u000b7/\u001a#fMR!\u0011\u0011\u0012C\u001f\u0011\u001d\t\t.\u0010a\u0001\t\u007f\u0001B!a,\u0005B%!A1IAm\u0005\u001d\u0019\u0015m]3EK\u001a\fQ\u0002\u001d:j]R4UO\\2uS>tG\u0003\u0002C%\t\u001b\"B!!#\u0005L!A11\t \u0005\u0002\u0004\u0011Y\u0007C\u0004\u0002Rz\u0002\r\u0001b\u0014\u0011\t\u0005=F\u0011K\u0005\u0005\t'\nIN\u0001\u0005Gk:\u001cG/[8o\u0003)\u0001(/\u001b8u'V\u0004XM\u001d\u000b\t\u0003\u0013#I\u0006\"\u0019\u0005d!9\u0011\u0011[ A\u0002\u0011m\u0003\u0003BAX\t;JA\u0001b\u0018\u0002Z\n)1+\u001e9fe\"AAqA \u0005\u0002\u0004!I\u0001C\u0005\u0005f}\u0002\n\u00111\u0001\u0002>\u0006Y1\r[3dWNKXNY8m\u0003Q\u0001(/\u001b8u'V\u0004XM\u001d\u0013eK\u001a\fW\u000f\u001c;%g\u0005I\u0001O]5oiRC\u0017n\u001d\u000b\u0007\u0003\u0013#i\u0007\"\u001e\t\u000f\u0005E\u0017\t1\u0001\u0005pA!\u0011q\u0016C9\u0013\u0011!\u0019(!7\u0003\tQC\u0017n\u001d\u0005\t\t\u000f\tE\u00111\u0001\u0005\nQ1\u0011\u0011\u0012C=\t{Bq\u0001b\u001fC\u0001\u0004\u0011Y+A\u0003ti\u0006$8\u000fC\u0004\u0005\u0000\t\u0003\r!a5\u0002\t\u0015D\bO]\u0001\naJLg\u000e\u001e+sK\u0016$B!!#\u0005\u0006\"9\u0011\u0011[\"A\u0002\u0005M\u0017!\u00029sS:$H\u0003BAE\t\u0017Cq\u0001\"$E\u0001\u0004!y)\u0001\u0003be\u001e\u001c\bCBA;\t#\u0013Y)\u0003\u0003\u0005\u0014\u0006-$A\u0003\u001fsKB,\u0017\r^3e}\tY1i\u001c3f!JLg\u000e^3s'\r)%\u0011D\u0001\raJLg\u000e\u001e*p_R\u00046n\u001a\u000b\u0007\t;#y\n\")\u0011\u0007\u0005=V\tC\u0004\u0003\u0004!\u0003\rA!\u0002\t\u000f\u0011e\u0005\n1\u0001\u0002>\u0006a\u0001/\u0019:f]R\u001c8\u000b^1dWV\u0011Aq\u0015\t\u0007\tS#\u0019,a5\u000e\u0005\u0011-&\u0002\u0002CW\t_\u000bq!\\;uC\ndWM\u0003\u0003\u00052\u0006-\u0014AC2pY2,7\r^5p]&!AQ\u0017CV\u0005\u0015\u0019F/Y2l\u00035\u0001\u0018M]3oiN\u001cF/Y2lA\u0005Y1-\u001e:sK:$HK]3f+\t!i\f\u0005\u0004\u0002v\u0011}\u00161[\u0005\u0005\t\u0003\fYG\u0001\u0004PaRLwN\\\u0001\u000eGV\u0014(/\u001a8u!\u0006\u0014XM\u001c;\u0002\u0017A\u0014\u0018N\u001c;fI:\u000bW.\u001a\u000b\u0007\u0005s!I\rb3\t\u000f\u0005-V\n1\u0001\u0002.\"I\u0011\u0011]'\u0011\u0002\u0003\u0007\u0011QX\u0001\u0016aJLg\u000e^3e\u001d\u0006lW\r\n3fM\u0006,H\u000e\u001e\u00133\u0003UI7/\u00138u\u0019&$x+\u001b;i\t\u0016\u001cw\u000eZ3e\u001fB$b!!0\u0005T\u0012]\u0007b\u0002Ck\u001f\u0002\u0007\u00111[\u0001\u0005cV\fG\u000eC\u0004\u0002,>\u0003\r!!,\u0002!9,W\rZ:QCJ,g\u000e\u001e5fg\u0016\u001cH\u0003\u0002Co\tw$\u0002#!0\u0005`\u0012\rHq\u001dCv\t_$\u0019\u0010b>\t\u0013\u0011\u0005(\u000b%AA\u0002\u0005u\u0016\u0001C5og&$W-\u00134\t\u0013\u0011\u0015(\u000b%AA\u0002\u0005u\u0016aC5og&$W-T1uG\"D\u0011\u0002\";S!\u0003\u0005\r!!0\u0002\u0013%t7/\u001b3f)JL\b\"\u0003Cw%B\u0005\t\u0019AA_\u0003=Ign]5eK\u0006sgn\u001c;bi\u0016$\u0007\"\u0003Cy%B\u0005\t\u0019AA_\u0003-Ign]5eK\ncwnY6\t\u0013\u0011U(\u000b%AA\u0002\u0005u\u0016AD5og&$W\rT1cK2$UM\u001a\u0005\n\ts\u0014\u0006\u0013!a\u0001\u0003{\u000bA\"\u001b8tS\u0012,\u0017i]:jO:Dq\u0001\"@S\u0001\u0004\t\u0019.\u0001\u0004qCJ,g\u000e^\u0001\u001b]\u0016,Gm\u001d)be\u0016tG\u000f[3tKN$C-\u001a4bk2$HE\r\u000b\u0005\u0007\u0017)\u0019\u0001C\u0004\u0005~N\u0003\r!a5\u000259,W\rZ:QCJ,g\u000e\u001e5fg\u0016\u001cH\u0005Z3gCVdG\u000fJ\u001a\u0015\t\r-Q\u0011\u0002\u0005\b\t{$\u0006\u0019AAj\u0003iqW-\u001a3t!\u0006\u0014XM\u001c;iKN,7\u000f\n3fM\u0006,H\u000e\u001e\u00135)\u0011\u0019Y!b\u0004\t\u000f\u0011uX\u000b1\u0001\u0002T\u0006Qb.Z3egB\u000b'/\u001a8uQ\u0016\u001cXm\u001d\u0013eK\u001a\fW\u000f\u001c;%kQ!11BC\u000b\u0011\u001d!iP\u0016a\u0001\u0003'\f!D\\3fIN\u0004\u0016M]3oi\",7/Z:%I\u00164\u0017-\u001e7uIY\"Baa\u0003\u0006\u001c!9AQ`,A\u0002\u0005M\u0017A\u00078fK\u0012\u001c\b+\u0019:f]RDWm]3tI\u0011,g-Y;mi\u0012:D\u0003BB\u0006\u000bCAq\u0001\"@Y\u0001\u0004\t\u0019.\u0001\u000eoK\u0016$7\u000fU1sK:$\b.Z:fg\u0012\"WMZ1vYR$\u0003\b\u0006\u0003\u0004\f\u0015\u001d\u0002b\u0002C\u007f3\u0002\u0007\u00111[\u0001\u000eG\",7m\u001b$pe\nc\u0017M\\6\u0015\t\teRQ\u0006\u0005\b\u000b_Q\u0006\u0019AA_\u0003\u0011\u0019wN\u001c3\u0002)\td\u0017M\\6G_J|\u0005/\u001a:bi>\u0014h*Y7f)\u0011\u0011I$\"\u000e\t\u000f\u0005-6\f1\u0001\u0002.\u0006a!\r\\1oW\u001a{'OT1nKR!!\u0011HC\u001e\u0011\u001d\tY\u000b\u0018a\u0001\u0003[\u000bQB]3t_24XmU3mK\u000e$H\u0003BAJ\u000b\u0003Bq!!?^\u0001\u0004\t\u0019.A\u0007F[B$\u0018\u0010V=qKR\u0013X-\u001a\t\u0004\u000b\u000fzV\"A#\u0003\u001b\u0015k\u0007\u000f^=UsB,GK]3f'\ry\u00161\u000f\u000b\u0003\u000b\u000b\nq!\u001e8baBd\u0017\u0010\u0006\u0003\u0002>\u0016M\u0003bBC+C\u0002\u0007QqK\u0001\u0003iR\u0004B!a,\u0006Z%!Q1LAm\u0005!!\u0016\u0010]3Ue\u0016,\u0017aC5t\u000b6\u0004H/\u001f+sK\u0016$B!!0\u0006b!9\u0011\u0011\u001b2A\u0002\u0005M\u0017!E8sS\u001eLg.\u00197UsB,GK]3fgR!QqMC9!\u0019)I'b\u001c\u0002T6\u0011Q1\u000e\u0006\u0005\u000b[\"y+A\u0005j[6,H/\u00192mK&!!qTC6\u0011\u001d)\u0019h\u0019a\u0001\u0005W\u000bQ\u0001\u001e:fKN\fa\u0002Z3gCVdGo\u00117bgN,7/\u0006\u0002\u0006zA1Q\u0011NC8\u000bw\u0002B!a,\u0006~%!QqPA[\u0005!!\u0016\u0010]3OC6,\u0017a\u00043fM\u0006,H\u000e^\"mCN\u001cXm\u001d\u0011\u0002)\u0011,g-Y;miR\u0013\u0018-\u001b;t\r>\u00148)Y:f\u0003U!WMZ1vYR$&/Y5ug\u001a{'oQ1tK\u0002\n!D]3n_Z,G)\u001a4bk2$H+\u001f9fg\u001a\u0013x.\u001c'jgR$B!b#\u0006\u001aR!QQRCK)\u0011\u0011Y+b$\t\u000f\u0015E\u0005\u000e1\u0001\u0006\u0014\u0006qAO]1jiN$vNU3n_Z,\u0007C\u0002BL\u0005;\u000bi\u000bC\u0005\u0006\u0018\"\u0004\n\u00111\u0001\u0006\u0014\u0006y1\r\\1tg\u0016\u001cHk\u001c*f[>4X\rC\u0004\u0006t!\u0004\rAa+\u0002II,Wn\u001c<f\t\u00164\u0017-\u001e7u)f\u0004Xm\u001d$s_6d\u0015n\u001d;%I\u00164\u0017-\u001e7uII\"B!b(\u0006\"*\"Q1SB\u0007\u0011\u001d)\u0019(\u001ba\u0001\u0005W\u000bAD]3n_Z,G)\u001a4bk2$8\t\\1tg\u0016\u001chI]8n\u0019&\u001cH\u000f\u0006\u0004\u0006h\u0015\u001dV\u0011\u0016\u0005\b\u000bgR\u0007\u0019\u0001BV\u0011%)9J\u001bI\u0001\u0002\u0004)\u0019*\u0001\u0014sK6|g/\u001a#fM\u0006,H\u000e^\"mCN\u001cXm\u001d$s_6d\u0015n\u001d;%I\u00164\u0017-\u001e7uII*\"!b(\u0002#MLh\u000e\u001e5fi&\u001cGk\u001c*f[>4X\r\u0006\u0003\u0002>\u0016M\u0006bBAiY\u0002\u0007\u00111\u001b\u000b\u0007\u0003\u0013+9,\"/\t\u000f\r=U\u000e1\u0001\u0002\u0014\"9\u0011\u0011[7A\u0002\u0005MGCCAE\u000b{+y,\"1\u0006D\"9!\u0011\u00168A\u0002\t-\u0006b\u0002BX]\u0002\u0007\u00111\u0013\u0005\b\u0005gs\u0007\u0019AAJ\u0011\u001d\u00119L\u001ca\u0001\u0003'#b!!#\u0006H\u0016%\u0007bBBN_\u0002\u00071Q\u0014\u0005\n\u000b\u0017|\u0007\u0013!a\u0001\u0003{\u000b\u0001\u0003\u001d:j[\u0006\u0014\u0018p\u0011;peB\u000b'/Y7\u0002)A\u0014\u0018N\u001c;GY\u0006<7\u000f\n3fM\u0006,H\u000e\u001e\u00133)\u0019\tI)\"5\u0006T\"9\u0011\u0011[9A\u0002\u0005M\u0007bBBNc\u0002\u00071Q\u0014\u000b\u0007\u0003\u0013+9.\"7\t\u000f\rm%\u000f1\u0001\u0004\u001e\"9Q1\u001a:A\u0002\u0005uFCBAE\u000b;,y\u000eC\u0004\u0002RN\u0004\r!a5\t\u000f\u0015-7\u000f1\u0001\u0002>R!\u0011\u0011RCr\u0011\u001d\t\t\u000e\u001ea\u0001\u0003'\f!\u0002\u001d:j]R\f%oZ:t)\u0011\tI)\";\t\u000f\u0015-X\u000f1\u0001\u0006n\u0006)\u0011M]4tgB1!q\u0013BO\u0005W#B!!#\u0006r\"9\u0011\u0011\u001b<A\u0002\rm\u0016A\u00039sS:$\u0018I\u001c8piR!\u0011\u0011RC|\u0011\u001d\t\tn\u001ea\u0001\u0003'$B!!#\u0006|\"9\u0011\u0011\u001b=A\u0002\u0005M\u0017a\u00059s_\u000e,7o\u001d+sK\u0016\u0004&/\u001b8uS:<G\u0003BAE\r\u0003Aq!!5z\u0001\u0004\t\u0019.\u0001\u0006yaJLg\u000e\u001e+sK\u0016$b!!#\u0007\b\u0019-\u0001b\u0002D\u0005u\u0002\u0007!\u0011D\u0001\fiJ,W\r\u0015:j]R,'\u000fC\u0004\u0002Rj\u0004\r!a5\u0002\u001d9,woQ8eKB\u0013\u0018N\u001c;feRA!\u0011\u0004D\t\r+19\u0002C\u0004\u0007\u0014m\u0004\rA!\u0002\u0002\r]\u0014\u0018\u000e^3s\u0011\u001d\t\tn\u001fa\u0001\u0003'Dq\u0001\"'|\u0001\u0004\ti,\u0001\boK^$&/Z3Qe&tG/\u001a:\u0015\t\teaQ\u0004\u0005\b\r'a\b\u0019\u0001B\u0003)\u0011\u0011IB\"\t\t\u000f\u0019\rR\u00101\u0001\u0007&\u000511\u000f\u001e:fC6\u0004BAa\u0002\u0007(%!a\u0011\u0006B\u0005\u00051yU\u000f\u001e9viN#(/Z1n)\t\u0011I\"A\u0007D_:\u001cx\u000e\\3Xe&$XM\u001d\t\u0005\u0003_\u000b\tAA\u0007D_:\u001cx\u000e\\3Xe&$XM]\n\u0005\u0003\u00031)\u0004\u0005\u0003\u0003\b\u0019]\u0012\u0002\u0002D\u001d\u0005\u0013\u0011aa\u0016:ji\u0016\u0014HC\u0001D\u0018\u0003\u00159(/\u001b;f)\u0011\tII\"\u0011\t\u0011\u0019\r\u0013Q\u0001a\u0001\u0003'\u000b1a\u001d;s)!\tIIb\u0012\u0007X\u0019m\u0003\u0002\u0003D%\u0003\u000f\u0001\rAb\u0013\u0002\t\r\u0014WO\u001a\t\u0007\u0003k2iE\"\u0015\n\t\u0019=\u00131\u000e\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0005\u0003k2\u0019&\u0003\u0003\u0007V\u0005-$\u0001B\"iCJD\u0001B\"\u0017\u0002\b\u0001\u0007!\u0011E\u0001\u0004_\u001a4\u0007\u0002\u0003D/\u0003\u000f\u0001\rA!\t\u0002\u00071,g.A\u0003gYV\u001c\b.A\toK^\u0014\u0016m\u001e+sK\u0016\u0004&/\u001b8uKJ$BA\"\u001a\b(B!\u0011qVA\u0016\u00059\u0011\u0016m\u001e+sK\u0016\u0004&/\u001b8uKJ\u001cb!a\u000b\u0002t\u0005}H\u0003\u0002D3\r[B\u0001Ba\u0001\u00020\u0001\u0007!QA\u0001\u0006I\u0016\u0004H\u000f[\u0001\nI\u0016\u0004H\u000f[0%KF$B!!#\u0007v!Q!QFA\u001a\u0003\u0003\u0005\rA!\t\u0002\r\u0011,\u0007\u000f\u001e5!\u0003U\u0001(/\u001b8u)f\u0004Xm]%o\r>|GO\\8uKN\f\u0011\u0004\u001d:j]R$\u0016\u0010]3t\u0013:4un\u001c;o_R,7o\u0018\u0013fcR!\u0011\u0011\u0012D@\u0011)\u0011i#!\u000f\u0002\u0002\u0003\u0007\u0011QX\u0001\u0017aJLg\u000e\u001e+za\u0016\u001c\u0018J\u001c$p_Rtw\u000e^3tA\u0005\t\u0002O]5oi&twMR8pi:|G/Z:\u0002+A\u0014\u0018N\u001c;j]\u001e4un\u001c;o_R,7o\u0018\u0013fcR!\u0011\u0011\u0012DE\u0011)\u0011i#a\u0010\u0002\u0002\u0003\u0007\u0011QX\u0001\u0013aJLg\u000e^5oO\u001a{w\u000e\u001e8pi\u0016\u001c\b%A\u0005g_>$hn\u001c;fgV\u0011a\u0011\u0013\t\u0005\u0003_\u000byAA\u0005G_>$hn\u001c;fgN!\u0011qBA:)\t1\t*A\u0003j]\u0012,\u00070\u0006\u0002\u0007\u001eBAA\u0011\u0016DP\rG3\u0019,\u0003\u0003\u0007\"\u0012-&aA'baB\"aQ\u0015DW!\u0019\u0011YDb*\u0007,&!a\u0011\u0016B\u001f\u0005\u0015\u0019E.Y:t!\u0011\u0011iH\",\u0005\u0019\u0019=\u0016QCA\u0001\u0002\u0003\u0015\tAa!\u0003\u0007}#\u0013'\u0001\u0004j]\u0012,\u0007\u0010\t\t\t\tS3)La#\u0003\"%!aq\u0017CV\u0005-9V-Y6ICNDW*\u00199\u0002\u0015\rd\u0017m]:J]\u0012,\u00070\u0006\u0003\u0007>\u001a5G\u0003\u0002DZ\r\u007fC!B\"1\u0002\u0018\u0005\u0005\t9\u0001Db\u0003))g/\u001b3f]\u000e,G%\r\t\u0007\r\u000b49Mb3\u000e\u0005\u0005\u001d\u0014\u0002\u0002De\u0003O\u0012\u0001b\u00117bgN$\u0016m\u001a\t\u0005\u0005{2i\r\u0002\u0005\u0004f\u0005]!\u0019\u0001BB\u0003!\u0019w.\u001e8uKJ\u001cXC\u0001Dj!!!IKb(\u0007V\n\u0005\u0002\u0007\u0002Dl\r7\u0004bAa\u000f\u0007(\u001ae\u0007\u0003\u0002B?\r7$AB\"8\u0002\u001c\u0005\u0005\t\u0011!B\u0001\u0005\u0007\u00131a\u0018\u00133\u0003%\u0019w.\u001e8uKJ\u001c\b%A\u0006oKb$8i\\;oi\u0016\u0014X\u0003\u0002Ds\r_$BA!\t\u0007h\"Qa\u0011^A\u000f\u0003\u0003\u0005\u001dAb;\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$#\u0007\u0005\u0004\u0007F\u001a\u001dgQ\u001e\t\u0005\u0005{2y\u000f\u0002\u0005\u0004f\u0005u!\u0019\u0001BB+\t1\u0019\u0010\u0005\u0005\u0005*\u001a}eQ_D\u0001a\u001119Pb?\u0011\r\tmbq\u0015D}!\u0011\u0011iHb?\u0005\u0019\u0019u\u0018\u0011EA\u0001\u0002\u0003\u0015\tAa!\u0003\u0007}#3'\u0001\u0006g_>$hn\u001c;fg\u0002\u0002b\u0001\"+\b\u0004\t\u0005\u0012\u0002BD\u0003\tW\u0013\u0011bU8si\u0016$7+\u001a;\u0002\u001d\rd\u0017m]:G_>$hn\u001c;fgV!q1BD\u000b)\u00119\ta\"\u0004\t\u0015\u001d=\u00111EA\u0001\u0002\b9\t\"\u0001\u0006fm&$WM\\2fIM\u0002bA\"2\u0007H\u001eM\u0001\u0003\u0002B?\u000f+!\u0001b!\u001a\u0002$\t\u0007!1Q\u0001\u0004aV$X\u0003BD\u000e\u000fO!Ba\"\b\b*Q!!\u0011ED\u0010\u0011)9\t#!\n\u0002\u0002\u0003\u000fq1E\u0001\u000bKZLG-\u001a8dK\u0012\"\u0004C\u0002Dc\r\u000f<)\u0003\u0005\u0003\u0003~\u001d\u001dB\u0001CB3\u0003K\u0011\rAa!\t\u0011\u001d-\u0012Q\u0005a\u0001\u000fK\t1!\u00198z\u0003\r9W\r^\u000b\u0005\u000fc9\u0019\u0005\u0006\u0003\b4\u001dm\u0002C\u0002BL\u0005;;)\u0004\u0005\u0005\u0002v\u001d]\"\u0011\u0005BF\u0013\u00119I$a\u001b\u0003\rQ+\b\u000f\\33\u0011)9i$a\n\u0002\u0002\u0003\u000fqqH\u0001\u000bKZLG-\u001a8dK\u0012*\u0004C\u0002Dc\r\u000f<\t\u0005\u0005\u0003\u0003~\u001d\rC\u0001CB3\u0003O\u0011\rAa!\u0016\t\u001d\u001ds1\u000b\u000b\u0005\u000f\u0013:)\u0006\u0006\u0003\u0002\n\u001e-\u0003BCD'\u0003S\t\t\u0011q\u0001\bP\u0005QQM^5eK:\u001cW\r\n\u001c\u0011\r\u0019\u0015gqYD)!\u0011\u0011ihb\u0015\u0005\u0011\r\u0015\u0014\u0011\u0006b\u0001\u0005\u0007C\u0001bb\u0016\u0002*\u0001\u0007\u0011q`\u0001\baJLg\u000e^3s)\u0011\tIib\u0017\t\u0011\u00115\u0015q\ta\u0001\t\u001f\u000bA\u0002\u001d:j]R\u0004&o\u001c3vGR$\"\"!#\bb\u001d%tqND:\u0011!\u0011y/!\u0013A\u0002\u001d\r\u0004\u0003BA;\u000fKJAab\u001a\u0002l\t9\u0001K]8ek\u000e$\bBCD6\u0003\u0013\u0002\n\u00111\u0001\bn\u0005A\u0001O]3b[\ndW\r\u0005\u0005\u0002v\t]t1MAE\u0011)\u0011I0!\u0013\u0011\u0002\u0003\u0007q\u0011\u000f\t\t\u0003k\u00129Ha#\u0002\n\"QqQOA%!\u0003\u0005\ra\"\u001c\u0002\u0013A|7\u000f^1nE2,\u0017A\u00069sS:$\bK]8ek\u000e$H\u0005Z3gCVdG\u000f\n\u001a\u0016\u0005\u001dm$\u0006BD7\u0007\u001b\ta\u0003\u001d:j]R\u0004&o\u001c3vGR$C-\u001a4bk2$HeM\u000b\u0003\u000f\u0003SCa\"\u001d\u0004\u000e\u00051\u0002O]5oiB\u0013x\u000eZ;di\u0012\"WMZ1vYR$C'A\u0007qe&tG/\u0013;fe\u0006\u0014G.\u001a\u000b\u000b\u0003\u0013;Iib&\b\u001a\u001em\u0005\u0002CDF\u0003#\u0002\ra\"$\u0002\u0011%$XM]1cY\u0016\u0004Dab$\b\u0014B1!q\u0013BO\u000f#\u0003BA! \b\u0014\u0012aqQSDE\u0003\u0003\u0005\tQ!\u0001\u0003\u0004\n\u0019q\f\n\u001c\t\u0015\u001d-\u0014\u0011\u000bI\u0005\u0002\u0004\u0011Y\u0007\u0003\u0006\u0003z\u0006E\u0003\u0013!a\u0001\u000fcB!b\"\u001e\u0002RA%\t\u0019\u0001B6\u0003]\u0001(/\u001b8u\u0013R,'/\u00192mK\u0012\"WMZ1vYR$#'\u0006\u0002\b\"*\"\u0011\u0011RB\u0007\u0003]\u0001(/\u001b8u\u0013R,'/\u00192mK\u0012\"WMZ1vYR$3'A\fqe&tG/\u0013;fe\u0006\u0014G.\u001a\u0013eK\u001a\fW\u000f\u001c;%i!Aa1CA\u0007\u0001\u0004\u0011)!\u0001\u0003tQ><H\u0003BAJ\u000f[C\u0001\"a+\u0002Z\u0001\u0007\u0011Q\u0016\u000b\u0005\u0003';\t\f\u0003\u0005\u0004*\u0006m\u0003\u0019ADZ!\u0011\tyk\".\n\t\u001d]v\u0011\u0018\u0002\b\r2\fwmU3u\u0013\u00119Y,a\u0019\u0003\u0011\u0019c\u0017mZ*fiN$B!a%\b@\"Aq\u0011YA/\u0001\u00049\u0019-\u0001\u0005q_NLG/[8o!\u0011\tyk\"2\n\t\u001d\u001dw\u0011\u001a\u0002\t!>\u001c\u0018\u000e^5p]&!q1ZA2\u0005%\u0001vn]5uS>t7/\u0001\u0005tQ><H)Z2m)\u0011\t\u0019j\"5\t\u0011\u001dM\u0017q\fa\u0001\u0007_\n1a]=n!\u001199n\"7\u000e\u0005\u0005\r\u0014\u0002BDn\u0003G\u00121bU=nE>dG+\u00192mK\u0002")
public interface Printers
extends scala.reflect.api.Printers {
    public Printers$ConsoleWriter$ ConsoleWriter();

    public static /* synthetic */ String quotedName$(Printers $this, Names.Name name, boolean decode) {
        return $this.quotedName(name, decode);
    }

    /*
     * WARNING - void declaration
     */
    default public String quotedName(Names.Name name, boolean decode) {
        void var3_3;
        String s = decode ? name.decode() : name.toString();
        Names.TermName term = name.toTermName();
        if (((StdNames)((Object)this)).nme().keywords().apply(term)) {
            Names.TermName termName = term;
            Names.TermName termName2 = ((StdNames)((Object)this)).nme().USCOREkw();
            if (termName == null ? termName2 != null : !termName.equals(termName2)) {
                String string = "`%s`";
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{s}));
            }
        }
        return var3_3;
    }

    public static /* synthetic */ String quotedName$(Printers $this, Names.Name name) {
        return $this.quotedName(name);
    }

    default public String quotedName(Names.Name name) {
        return this.quotedName(name, false);
    }

    public static /* synthetic */ String quotedName$(Printers $this, String name) {
        return $this.quotedName(name);
    }

    default public String quotedName(String name) {
        return this.quotedName(((Names)((Object)this)).newTermName(name), false);
    }

    private String symNameInternal(Trees.Tree tree, Names.Name name, boolean decoded) {
        Symbols.Symbol sym = tree.symbol();
        if (sym == null || sym.equals(((Symbols)((Object)this)).NoSymbol())) {
            return this.qname$1(name, decoded);
        }
        if (sym.isErroneous()) {
            return new StringBuilder(9).append("<").append(this.qname$1(name, decoded)).append(": error>").toString();
        }
        if (sym.isMixinConstructor()) {
            return new StringBuilder(4).append("/*").append(this.qowner$1(sym, decoded)).append("*/").append(this.qsymbol$1(sym)).toString();
        }
        return this.qsymbol$1(sym);
    }

    public static /* synthetic */ String decodedSymName$(Printers $this, Trees.Tree tree, Names.Name name) {
        return $this.decodedSymName(tree, name);
    }

    default public String decodedSymName(Trees.Tree tree, Names.Name name) {
        return this.symNameInternal(tree, name, true);
    }

    public static /* synthetic */ String symName$(Printers $this, Trees.Tree tree, Names.Name name) {
        return $this.symName(tree, name);
    }

    default public String symName(Trees.Tree tree, Names.Name name) {
        return this.symNameInternal(tree, name, false);
    }

    public static /* synthetic */ String backquotedPath$(Printers $this, Trees.Tree t) {
        return $this.backquotedPath(t);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public String backquotedPath(Trees.Tree t) {
        boolean bl = false;
        Trees.Select select = null;
        if (t instanceof Trees.Select) {
            bl = true;
            select = (Trees.Select)t;
            Trees.Tree qual = select.qualifier();
            Names.Name name = select.name();
            if (name.isTermName()) {
                return new StringBuilder(1).append(this.backquotedPath(qual)).append(".").append(this.symName(t, name)).toString();
            }
        }
        if (bl) {
            Trees.Tree qual = select.qualifier();
            Names.Name name = select.name();
            if (name.isTypeName()) {
                return new StringBuilder(1).append(this.backquotedPath(qual)).append("#").append(this.symName(t, name)).toString();
            }
        }
        if (!(t instanceof Trees.Ident)) return t.toString();
        Names.Name name = ((Trees.Ident)t).name();
        return this.symName(t, name);
    }

    public static /* synthetic */ void xprintTree$(Printers $this, TreePrinter treePrinter, Trees.Tree tree) {
        $this.xprintTree(treePrinter, tree);
    }

    default public void xprintTree(TreePrinter treePrinter, Trees.Tree tree) {
        treePrinter.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(0).append(tree.productPrefix()).append(tree.productIterator().mkString("(", ", ", ")")).toString()}));
    }

    public static /* synthetic */ TreePrinter newCodePrinter$(Printers $this, PrintWriter writer, Trees.Tree tree, boolean printRootPkg) {
        return $this.newCodePrinter(writer, tree, printRootPkg);
    }

    default public TreePrinter newCodePrinter(PrintWriter writer, Trees.Tree tree, boolean printRootPkg) {
        return new CodePrinter((SymbolTable)this, writer, printRootPkg);
    }

    public static /* synthetic */ TreePrinter newTreePrinter$(Printers $this, PrintWriter writer) {
        return $this.newTreePrinter(writer);
    }

    @Override
    default public TreePrinter newTreePrinter(PrintWriter writer) {
        return new TreePrinter((SymbolTable)this, writer);
    }

    public static /* synthetic */ TreePrinter newTreePrinter$(Printers $this, OutputStream stream) {
        return $this.newTreePrinter(stream);
    }

    default public TreePrinter newTreePrinter(OutputStream stream) {
        return this.newTreePrinter(new PrintWriter(stream));
    }

    public static /* synthetic */ TreePrinter newTreePrinter$(Printers $this) {
        return $this.newTreePrinter();
    }

    default public TreePrinter newTreePrinter() {
        return this.newTreePrinter(new PrintWriter(this.ConsoleWriter()));
    }

    public static /* synthetic */ RawTreePrinter newRawTreePrinter$(Printers $this, PrintWriter writer) {
        return $this.newRawTreePrinter(writer);
    }

    @Override
    default public RawTreePrinter newRawTreePrinter(PrintWriter writer) {
        return new RawTreePrinter((SymbolTable)this, writer);
    }

    public static /* synthetic */ String show$(Printers $this, Names.Name name) {
        return $this.show(name);
    }

    default public String show(Names.Name name) {
        String string;
        Names.Name name2 = ((StdNames)((Object)this)).tpnme().WILDCARD();
        if (!(name2 != null ? !name2.equals(name) : name != null)) {
            string = "typeNames.WILDCARD";
        } else {
            Names.Name name3 = ((StdNames)((Object)this)).tpnme().EMPTY();
            if (!(name3 != null ? !name3.equals(name) : name != null)) {
                string = "typeNames.EMPTY";
            } else {
                Names.Name name4 = ((StdNames)((Object)this)).tpnme().ERROR();
                if (!(name4 != null ? !name4.equals(name) : name != null)) {
                    string = "typeNames.ERROR";
                } else {
                    Names.Name name5 = ((StdNames)((Object)this)).tpnme().PACKAGE();
                    if (!(name5 != null ? !name5.equals(name) : name != null)) {
                        string = "typeNames.PACKAGE";
                    } else {
                        Names.TypeName typeName = ((StdNames)((Object)this)).tpnme().WILDCARD_STAR();
                        if (!(typeName != null ? !typeName.equals(name) : name != null)) {
                            string = "typeNames.WILDCARD_STAR";
                        } else {
                            Names.Name name6 = ((StdNames)((Object)this)).nme().WILDCARD();
                            if (!(name6 != null ? !name6.equals(name) : name != null)) {
                                string = "termNames.WILDCARD";
                            } else {
                                Names.Name name7 = ((StdNames)((Object)this)).nme().EMPTY();
                                if (!(name7 != null ? !name7.equals(name) : name != null)) {
                                    string = "termNames.EMPTY";
                                } else {
                                    Names.Name name8 = ((StdNames)((Object)this)).nme().ERROR();
                                    if (!(name8 != null ? !name8.equals(name) : name != null)) {
                                        string = "termNames.ERROR";
                                    } else {
                                        Names.Name name9 = ((StdNames)((Object)this)).nme().PACKAGE();
                                        if (!(name9 != null ? !name9.equals(name) : name != null)) {
                                            string = "termNames.PACKAGE";
                                        } else {
                                            Names.TermName termName = ((StdNames)((Object)this)).nme().CONSTRUCTOR();
                                            if (!(termName != null ? !termName.equals(name) : name != null)) {
                                                string = "termNames.CONSTRUCTOR";
                                            } else {
                                                Names.TermName termName2 = ((StdNames)((Object)this)).nme().ROOTPKG();
                                                if (!(termName2 != null ? !termName2.equals(name) : name != null)) {
                                                    string = "termNames.ROOTPKG";
                                                } else {
                                                    String prefix = name.isTermName() ? "TermName(\"" : "TypeName(\"";
                                                    string = new StringBuilder(2).append(prefix).append(name.toString()).append("\")").toString();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return string;
    }

    public static /* synthetic */ String show$(Printers $this, long flags) {
        return $this.show(flags);
    }

    /*
     * WARNING - void declaration
     */
    default public String show(long flags) {
        void withFilter_p;
        if (flags == ((FlagSets)((Object)this)).NoFlags()) {
            return ((StdNames)((Object)this)).nme().NoFlags().toString();
        }
        ListBuffer s_flags = new ListBuffer();
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(n, 63);
        JFunction1$mcZI$sp & Serializable intersect = (JFunction1$mcZI$sp & Serializable)i -> Printers.hasFlag$1(flags, 1L << i);
        if (inclusive == null) {
            throw null;
        }
        Range.Inclusive withFilter_this = inclusive;
        new TraversableLike.WithFilter(withFilter_this, withFilter_p).foreach((Function1<Object, ListBuffer> & java.io.Serializable & Serializable)i -> s_flags.$plus$eq(Flags$.MODULE$.flagToString(1L << BoxesRunTime.unboxToInt(i)).replace("<", "").replace(">", "").toUpperCase()));
        return s_flags.mkString(" | ");
    }

    public static /* synthetic */ String show$(Printers $this, Position position) {
        return $this.show(position);
    }

    default public String show(Position position) {
        return position.show();
    }

    public static /* synthetic */ String showDecl$(Printers $this, Symbols.Symbol sym) {
        return $this.showDecl(sym);
    }

    default public String showDecl(Symbols.Symbol sym) {
        if (!((SymbolTable)this).isCompilerUniverse()) {
            ((Definitions)((Object)this)).definitions().fullyInitializeSymbol(sym);
        }
        return sym.defString();
    }

    private String qname$1(Names.Name name$1, boolean decoded$1) {
        return this.quotedName(((Names)((Object)this)).AnyNameOps(name$1).dropLocal(), decoded$1);
    }

    private String qowner$1(Symbols.Symbol sym$1, boolean decoded$1) {
        return this.quotedName(((Names)((Object)this)).AnyNameOps(sym$1.owner().name()).dropLocal(), decoded$1);
    }

    private String qsymbol$1(Symbols.Symbol sym$1) {
        return this.quotedName(sym$1.nameString());
    }

    private static boolean hasFlag$1(long left, long right) {
        return (left & right) != 0L;
    }

    public static void $init$(Printers $this) {
    }

    public class CodePrinter
    extends TreePrinter {
        private volatile Printers$CodePrinter$EmptyTypeTree$ EmptyTypeTree$module;
        private final boolean printRootPkg;
        private final Stack<Trees.Tree> parentsStack;
        private final boolean commentsRequired;
        private final List<Names.TypeName> defaultClasses;
        private final List<Names.TypeName> defaultTraitsForCase;

        public Printers$CodePrinter$EmptyTypeTree$ EmptyTypeTree() {
            if (this.EmptyTypeTree$module == null) {
                this.EmptyTypeTree$lzycompute$1();
            }
            return this.EmptyTypeTree$module;
        }

        public Stack<Trees.Tree> parentsStack() {
            return this.parentsStack;
        }

        public Option<Trees.Tree> currentTree() {
            if (this.parentsStack().nonEmpty()) {
                return new Some<Trees.Tree>(this.parentsStack().top());
            }
            return None$.MODULE$;
        }

        public Option<Trees.Tree> currentParent() {
            if (this.parentsStack().length() > 1) {
                return new Some<Trees.Tree>(this.parentsStack().apply(1));
            }
            return None$.MODULE$;
        }

        public String printedName(Names.Name name, boolean decoded) {
            String addBackquotes$1_s;
            block8: {
                block9: {
                    String decName = name.decoded();
                    char bslash = '\\';
                    Function1<Object, Object> & java.io.Serializable & Serializable isDot = (Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$printedName$1(BoxesRunTime.unboxToChar(x)));
                    GenTraversable brackets = List$.MODULE$.apply(Predef$.MODULE$.wrapCharArray(new char[]{'[', ']', '(', ')', '{', '}'}));
                    if (name.equals(this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().CONSTRUCTOR())) {
                        return "this";
                    }
                    addBackquotes$1_s = this.scala$reflect$internal$Printers$CodePrinter$$$outer().quotedName(name, decoded);
                    if (!decoded) break block8;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (IndexedSeqOptimized.exists$(new StringOps(decName), arg_0 -> CodePrinter.$anonfun$printedName$2$adapted((List)brackets, isDot, arg_0))) break block9;
                    if (!name.isOperatorName()) break block8;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (!IndexedSeqOptimized.exists$(new StringOps(decName), (Function1<Object, Object> & java.io.Serializable & Serializable)c -> BoxesRunTime.boxToBoolean(Chars$.MODULE$.isOperatorPart(BoxesRunTime.unboxToChar(c))))) break block8;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (!IndexedSeqOptimized.exists$(new StringOps(decName), (Function1<Object, Object> & java.io.Serializable & Serializable)ch -> BoxesRunTime.boxToBoolean(Chars$.MODULE$.isScalaLetter(BoxesRunTime.unboxToChar(ch))))) break block8;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (new StringOps(decName).contains(BoxesRunTime.boxToCharacter(bslash))) break block8;
                }
                return new StringBuilder(2).append("`").append(addBackquotes$1_s).append("`").toString();
            }
            return addBackquotes$1_s;
        }

        public boolean printedName$default$2() {
            return true;
        }

        public boolean isIntLitWithDecodedOp(Trees.Tree qual, Names.Name name) {
            Constants.Constant constant;
            boolean bl = qual instanceof Trees.Literal && (constant = ((Trees.Literal)qual).value()) != null && constant.value() instanceof Integer;
            return bl && name.isOperatorName();
        }

        @Override
        public boolean commentsRequired() {
            return this.commentsRequired;
        }

        public boolean needsParentheses(Trees.Tree parent, boolean insideIf, boolean insideMatch, boolean insideTry, boolean insideAnnotated, boolean insideBlock, boolean insideLabelDef, boolean insideAssign) {
            boolean bl = parent instanceof Trees.If ? insideIf : (parent instanceof Trees.Match ? insideMatch : (parent instanceof Trees.Try ? insideTry : (parent instanceof Trees.Annotated ? insideAnnotated : (parent instanceof Trees.Block ? insideBlock : (parent instanceof Trees.LabelDef ? insideLabelDef : (parent instanceof Trees.Assign ? insideAssign : false))))));
            return bl;
        }

        public boolean needsParentheses$default$2(Trees.Tree parent) {
            return true;
        }

        public boolean needsParentheses$default$3(Trees.Tree parent) {
            return true;
        }

        public boolean needsParentheses$default$4(Trees.Tree parent) {
            return true;
        }

        public boolean needsParentheses$default$5(Trees.Tree parent) {
            return true;
        }

        public boolean needsParentheses$default$6(Trees.Tree parent) {
            return true;
        }

        public boolean needsParentheses$default$7(Trees.Tree parent) {
            return true;
        }

        public boolean needsParentheses$default$8(Trees.Tree parent) {
            return true;
        }

        public String checkForBlank(boolean cond) {
            if (cond) {
                return " ";
            }
            return "";
        }

        public String blankForOperatorName(Names.Name name) {
            return this.checkForBlank(name.isOperatorName());
        }

        public String blankForName(Names.Name name) {
            return this.checkForBlank(name.isOperatorName() || name.endsWith("_"));
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public String resolveSelect(Trees.Tree t) {
            boolean bl = false;
            Trees.Select select = null;
            if (t instanceof Trees.Select) {
                bl = true;
                select = (Trees.Select)t;
                Trees.Tree qual = select.qualifier();
                Names.Name name = select.name();
                if (name.isTermName()) {
                    boolean x$8;
                    boolean x$7;
                    boolean x$6;
                    boolean x$5;
                    boolean x$4;
                    boolean x$2 = false;
                    boolean x$3 = this.needsParentheses$default$2(qual);
                    if (this.needsParentheses(qual, x$3, x$4 = this.needsParentheses$default$3(qual), x$5 = this.needsParentheses$default$4(qual), x$6 = this.needsParentheses$default$5(qual), x$7 = this.needsParentheses$default$6(qual), x$2, x$8 = this.needsParentheses$default$8(qual))) return new StringBuilder(3).append("(").append(this.resolveSelect(qual)).append(").").append(this.printedName(name, this.printedName$default$2())).toString();
                }
                if (this.isIntLitWithDecodedOp(qual, name)) {
                    return new StringBuilder(3).append("(").append(this.resolveSelect(qual)).append(").").append(this.printedName(name, this.printedName$default$2())).toString();
                }
            }
            if (bl) {
                Trees.Tree qual = select.qualifier();
                Names.Name name = select.name();
                if (name.isTermName()) {
                    return new StringBuilder(1).append(this.resolveSelect(qual)).append(".").append(this.printedName(name, this.printedName$default$2())).toString();
                }
            }
            if (bl) {
                Trees.Tree qual = select.qualifier();
                Names.Name name = select.name();
                if (name.isTypeName()) {
                    return new StringBuilder(2).append(this.resolveSelect(qual)).append("#").append(this.blankForOperatorName(name)).append("%").append(this.printedName(name, this.printedName$default$2())).toString();
                }
            }
            if (!(t instanceof Trees.Ident)) return this.scala$reflect$internal$Printers$CodePrinter$$$outer().render(t, (Function1<PrintWriter, Printers.TreePrinter>)(Function1<PrintWriter, CodePrinter> & java.io.Serializable & Serializable)x$14 -> new CodePrinter(this.scala$reflect$internal$Printers$CodePrinter$$$outer(), (PrintWriter)x$14, $this.printRootPkg), this.scala$reflect$internal$Printers$CodePrinter$$$outer().render$default$3(), this.scala$reflect$internal$Printers$CodePrinter$$$outer().render$default$4(), this.scala$reflect$internal$Printers$CodePrinter$$$outer().render$default$5(), this.scala$reflect$internal$Printers$CodePrinter$$$outer().render$default$6(), this.scala$reflect$internal$Printers$CodePrinter$$$outer().render$default$7(), this.scala$reflect$internal$Printers$CodePrinter$$$outer().render$default$8());
            Names.Name name = ((Trees.Ident)t).name();
            return this.printedName(name, this.printedName$default$2());
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean isEmptyTree(Trees.Tree tree) {
            if (((Object)this.scala$reflect$internal$Printers$CodePrinter$$$outer().EmptyTree()).equals(tree)) {
                return true;
            }
            if (!(tree instanceof Trees.TypeTree)) return false;
            Trees.TypeTree typeTree = (Trees.TypeTree)tree;
            if (!this.EmptyTypeTree().unapply(typeTree)) return false;
            return true;
        }

        public List<Trees.Tree> originalTypeTrees(List<Trees.Tree> trees) {
            return ((List)trees.filter((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x$15 -> BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$originalTypeTrees$1(this, x$15)))).map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)x0$1 -> {
                Trees.TypeTree typeTree;
                Trees.Tree tree = x0$1 instanceof Trees.TypeTree && (typeTree = (Trees.TypeTree)x0$1).original() != null ? typeTree.original() : x0$1;
                return tree;
            }, List$.MODULE$.canBuildFrom());
        }

        public List<Names.TypeName> defaultClasses() {
            return this.defaultClasses;
        }

        public List<Names.TypeName> defaultTraitsForCase() {
            return this.defaultTraitsForCase;
        }

        public List<Trees.Tree> removeDefaultTypesFromList(List<Trees.Tree> trees, List<Names.Name> classesToRemove, List<Names.Name> traitsToRemove) {
            return this.removeDefaultTraitsFromList$1(this.removeDefaultClassesFromList(trees, classesToRemove), traitsToRemove);
        }

        public List<Names.Name> removeDefaultTypesFromList$default$2(List<Trees.Tree> trees) {
            return this.defaultClasses();
        }

        public List<Trees.Tree> removeDefaultClassesFromList(List<Trees.Tree> trees, List<Names.Name> classesToRemove) {
            return (List)this.originalTypeTrees(trees).filter((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$removeDefaultClassesFromList$1(this, classesToRemove, x0$1)));
        }

        public List<Names.Name> removeDefaultClassesFromList$default$2() {
            return this.defaultClasses();
        }

        public boolean syntheticToRemove(Trees.Tree tree) {
            boolean bl = tree instanceof Trees.ValDef ? true : tree instanceof Trees.TypeDef;
            boolean bl2 = bl ? false : tree instanceof Trees.MemberDef && ((Trees.MemberDef)tree).mods().isSynthetic();
            return bl2;
        }

        @Override
        public void printOpt(String prefix, Trees.Tree tree) {
            if (!this.isEmptyTree(tree)) {
                super.printOpt(prefix, tree);
            }
        }

        @Override
        public void printColumn(List<Trees.Tree> ts, String start, String sep, String end) {
            super.printColumn((List)ts.filter((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x$16 -> BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$printColumn$3(this, x$16))), start, sep, end);
        }

        public void printFlags(Trees.Modifiers mods, boolean primaryCtorParam) {
            String s;
            long base = 2148009007L;
            long mask = primaryCtorParam ? base : base | 0x200L;
            String string = s = mods.flagString(mask);
            String string2 = "";
            if (string == null || !string.equals(string2)) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append(s).append(" ").toString()}));
            }
            if (mods.isCase()) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append(mods.flagBitsToString(2048L)).append(" ").toString()}));
            }
            if (mods.isAbstractOverride()) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"abstract override "}));
            }
        }

        public boolean printFlags$default$2() {
            return false;
        }

        @Override
        public void printModifiers(Trees.Tree tree, Trees.Modifiers mods) {
            this.printModifiers(mods, false);
        }

        public void printModifiers(Trees.Modifiers mods, boolean primaryCtorParam) {
            if (this.currentParent().isEmpty() || this.modsAccepted$1()) {
                this.printFlags(mods, primaryCtorParam);
                return;
            }
            GenTraversable genTraversable = List$.MODULE$.apply(Predef$.MODULE$.wrapLongArray(new long[]{512L, 2048L, 0x80000000L, 1024L}));
            if (genTraversable == null) {
                throw null;
            }
            GenTraversable foreach_these = genTraversable;
            while (!((List)foreach_these).isEmpty()) {
                long l = BoxesRunTime.unboxToLong(((List)foreach_these).head());
                CodePrinter.$anonfun$printModifiers$4(this, mods, l);
                foreach_these = (List)((AbstractTraversable)foreach_these).tail();
            }
        }

        public void printParam(Trees.Tree tree, boolean primaryCtorParam) {
            if (tree instanceof Trees.ValDef) {
                boolean hideCaseCtorMods;
                Trees.ValDef valDef = (Trees.ValDef)tree;
                Trees.Modifiers mods = valDef.mods();
                Names.TermName name = valDef.name();
                Trees.Tree tp = valDef.tpt();
                Trees.Tree rhs = valDef.rhs();
                this.printPosition(tree);
                this.printAnnotations(valDef);
                boolean mutableOrOverride = mods.isOverride() || mods.isMutable();
                boolean hideCtorMods = mods.isParamAccessor() && mods.isPrivateLocal() && !mutableOrOverride;
                boolean bl = hideCaseCtorMods = mods.isCaseAccessor() && mods.isPublic() && !mutableOrOverride;
                if (primaryCtorParam && !hideCtorMods && !hideCaseCtorMods) {
                    this.printModifiers(mods, primaryCtorParam);
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{mods.isMutable() ? "var " : "val "}));
                }
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.printedName(name, this.printedName$default$2()), this.blankForName(name)}));
                this.printOpt(": ", tp);
                this.printOpt(" = ", rhs);
                return;
            }
            if (tree instanceof Trees.TypeDef) {
                Trees.TypeDef typeDef = (Trees.TypeDef)tree;
                Names.TypeName name = typeDef.name();
                List<Trees.TypeDef> tparams = typeDef.tparams();
                Trees.Tree rhs = typeDef.rhs();
                this.printPosition(tree);
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.printedName(name, this.printedName$default$2())}));
                this.printTypeParams(tparams);
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{rhs}));
                return;
            }
            super.printParam(tree);
        }

        @Override
        public void printParam(Trees.Tree tree) {
            this.printParam(tree, false);
        }

        public void printArgss(List<List<Trees.Tree>> argss) {
            if (argss == null) {
                throw null;
            }
            List foreach_these = argss;
            while (!foreach_these.isEmpty()) {
                List<Trees.Tree> list = foreach_these.head();
                CodePrinter.$anonfun$printArgss$1(this, argss, list);
                foreach_these = (List)foreach_these.tail();
            }
        }

        @Override
        public void printAnnotations(Trees.MemberDef tree) {
            List annots = tree.mods().annotations();
            if (annots == null) {
                throw null;
            }
            List foreach_these = annots;
            while (!foreach_these.isEmpty()) {
                Trees.Tree tree2 = foreach_these.head();
                CodePrinter.$anonfun$printAnnotations$2(this, tree2);
                foreach_these = (List)foreach_these.tail();
            }
        }

        public void printAnnot(Trees.Tree tree) {
            Option<Tuple3<Trees.Tree, List<Trees.Tree>, List<List<Trees.Tree>>>> option = this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().Applied().unapply(tree);
            if (!option.isEmpty()) {
                Trees.Tree tree2;
                Trees.Tree core = option.get()._1();
                List<List<Trees.Tree>> argss = option.get()._3();
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"@"}));
                if (core instanceof Trees.Select && (tree2 = ((Trees.Select)core).qualifier()) instanceof Trees.New) {
                    Trees.Tree tree3 = ((Trees.New)tree2).tpt();
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree3}));
                }
                this.printArgss(argss);
                return;
            }
            super.printTree(tree);
        }

        @Override
        public void printTree(Trees.Tree tree) {
            this.parentsStack().push(tree);
            try {
                this.processTreePrinting(tree);
                this.printTypesInfo(tree);
            }
            finally {
                this.parentsStack().pop();
            }
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        public void processTreePrinting(Trees.Tree tree) {
            block130: {
                block134: {
                    block137: {
                        block135: {
                            block136: {
                                block131: {
                                    block133: {
                                        block132: {
                                            block128: {
                                                block129: {
                                                    block124: {
                                                        block125: {
                                                            block127: {
                                                                block126: {
                                                                    var8_2 = false;
                                                                    var9_3 = null;
                                                                    var10_4 = false;
                                                                    var11_5 = null;
                                                                    if (this.syntheticToRemove(tree)) {
                                                                        return;
                                                                    }
                                                                    if (tree instanceof Trees.ClassDef) {
                                                                        var12_6 = (Trees.ClassDef)tree;
                                                                        mods = var12_6.mods();
                                                                        name = var12_6.name();
                                                                        tparams = var12_6.tparams();
                                                                        impl = var12_6.impl();
                                                                        if (mods.isJavaDefined()) {
                                                                            super.printTree(var12_6);
                                                                        }
                                                                        this.printAnnotations(var12_6);
                                                                        if (mods.isTrait()) {
                                                                            this.printModifiers(tree, mods.$amp$tilde(8L));
                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"trait ", this.printedName(name, this.printedName$default$2())}));
                                                                            this.printTypeParams(tparams);
                                                                            var18_11 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().build().SyntacticTraitDef().unapply(tree);
                                                                            if (var18_11.isEmpty()) {
                                                                                throw new MatchError(tree);
                                                                            }
                                                                            parents = var18_11.get()._5();
                                                                            v0 = var19_12;
                                                                        } else {
                                                                            this.printModifiers(tree, mods);
                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"class ", this.printedName(name, this.printedName$default$2())}));
                                                                            this.printTypeParams(tparams);
                                                                            var20_13 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().build().SyntacticClassDef().unapply(var12_6);
                                                                            if (var20_13.isEmpty()) {
                                                                                throw new MatchError(var12_6);
                                                                            }
                                                                            ctorMods = var20_13.get()._4();
                                                                            vparamss = var20_13.get()._5();
                                                                            var20_13.get()._6();
                                                                            parents = var20_13.get()._7();
                                                                            var20_13.get()._8();
                                                                            var20_13.get()._9();
                                                                            ctorMods = var21_14;
                                                                            vparamss = var22_15;
                                                                            parents = var23_16;
                                                                            if (ctorMods.hasFlag(524293L) || ctorMods.hasAccessBoundary()) {
                                                                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" "}));
                                                                                this.printModifiers((Trees.Modifiers)ctorMods, false);
                                                                            }
                                                                            if (!(var7_20 = Nil$.MODULE$.equals(vparamss) != false ? true : (var27_21 = List$.MODULE$.unapplySeq(vparamss)).isEmpty() == false && var27_21.get() != null && ((LinearSeqOptimized)var27_21.get()).lengthCompare(1) == 0 && Nil$.MODULE$.equals(var28_22 = (List)((LinearSeqOptimized)var27_21.get()).apply(0)) != false) || mods.isCase() || ctorMods.hasFlag(524293L)) {
                                                                                if (vparamss == null) {
                                                                                    throw null;
                                                                                }
                                                                                foreach_these = vparamss;
                                                                                while (!foreach_these.isEmpty()) {
                                                                                    var241_24 = (List)foreach_these.head();
                                                                                    CodePrinter.$anonfun$processTreePrinting$4(this, var241_24);
                                                                                    foreach_these = (List)foreach_these.tail();
                                                                                }
                                                                            }
                                                                            v0 = parents;
                                                                        }
                                                                        clParents = v0;
                                                                        x$2 = this.removeDefaultTypesFromList$default$2((List<Trees.Tree>)clParents);
                                                                        x$3 /* !! */  = mods.hasFlag(2048L) != false ? this.defaultTraitsForCase() : Nil$.MODULE$;
                                                                        printedParents = this.removeDefaultTypesFromList((List<Trees.Tree>)clParents, x$2, x$3 /* !! */ );
                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{mods.isDeferred() != false ? "<: " : (printedParents.nonEmpty() != false ? " extends " : ""), impl}));
                                                                        return;
                                                                    }
                                                                    if (tree instanceof Trees.PackageDef) {
                                                                        var32_29 = (Trees.PackageDef)tree;
                                                                        packaged = var32_29.pid();
                                                                        stats = var32_29.stats();
                                                                        if (packaged instanceof Trees.Ident) {
                                                                            v1 = ((Trees.Ident)packaged).name();
                                                                            var35_32 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().EMPTY_PACKAGE_NAME();
                                                                            if (!(v1 != null ? v1.equals(var35_32) == false : var35_32 != null)) {
                                                                                this.printSeq(stats, (Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$processTreePrinting$5$adapted(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Tree ), (Lscala/reflect/internal/Trees$Tree;)Ljava/lang/Object;)((CodePrinter)this), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$6(scala.reflect.internal.Printers$CodePrinter ), ()V)((CodePrinter)this));
                                                                                return;
                                                                            }
                                                                        }
                                                                        this.printPackageDef(var32_29, Properties$.MODULE$.lineSeparator());
                                                                        return;
                                                                    }
                                                                    if (tree instanceof Trees.ModuleDef) {
                                                                        var36_33 = (Trees.ModuleDef)tree;
                                                                        mods = var36_33.mods();
                                                                        name = var36_33.name();
                                                                        impl = var36_33.impl();
                                                                        this.printAnnotations(var36_33);
                                                                        this.printModifiers(tree, mods);
                                                                        if (impl == null) {
                                                                            throw new MatchError((Object)null);
                                                                        }
                                                                        parents = impl.parents();
                                                                        impl.self();
                                                                        impl.body();
                                                                        parents = var40_37;
                                                                        parWithoutAnyRef = this.removeDefaultClassesFromList((List<Trees.Tree>)parents, this.removeDefaultClassesFromList$default$2());
                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(7).append("object ").append(this.printedName(name, this.printedName$default$2())).toString(), parWithoutAnyRef.nonEmpty() != false ? " extends " : "", impl}));
                                                                        return;
                                                                    }
                                                                    if (tree instanceof Trees.ValDef) {
                                                                        var43_40 = (Trees.ValDef)tree;
                                                                        mods = var43_40.mods();
                                                                        name = var43_40.name();
                                                                        tp = var43_40.tpt();
                                                                        rhs = var43_40.rhs();
                                                                        this.printValDef(var43_40, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$processTreePrinting$7(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Names$TermName ), ()Ljava/lang/String;)((CodePrinter)this, (Names.TermName)name), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$8(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Names$TermName scala.reflect.internal.Trees$Tree ), ()V)((CodePrinter)this, (Names.TermName)name, (Trees.Tree)tp), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$9(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Modifiers scala.reflect.internal.Trees$Tree ), ()V)((CodePrinter)this, (Trees.Modifiers)mods, (Trees.Tree)rhs));
                                                                        return;
                                                                    }
                                                                    if (tree instanceof Trees.DefDef) {
                                                                        var48_45 = (Trees.DefDef)tree;
                                                                        mods = var48_45.mods();
                                                                        name = var48_45.name();
                                                                        tparams = var48_45.tparams();
                                                                        vparamss = var48_45.vparamss();
                                                                        tp = var48_45.tpt();
                                                                        rhs = var48_45.rhs();
                                                                        this.printDefDef(var48_45, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$processTreePrinting$10(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Names$TermName ), ()Ljava/lang/String;)((CodePrinter)this, (Names.TermName)name), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$11(scala.reflect.internal.Printers$CodePrinter scala.collection.immutable.List scala.collection.immutable.List scala.reflect.internal.Names$TermName scala.reflect.internal.Trees$Tree ), ()V)((CodePrinter)this, tparams, vparamss, (Names.TermName)name, (Trees.Tree)tp), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$12(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Modifiers scala.reflect.internal.Trees$Tree ), ()V)((CodePrinter)this, (Trees.Modifiers)mods, (Trees.Tree)rhs));
                                                                        return;
                                                                    }
                                                                    if (tree instanceof Trees.TypeDef) {
                                                                        var55_52 = (Trees.TypeDef)tree;
                                                                        name = var55_52.name();
                                                                        this.printTypeDef(var55_52, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$processTreePrinting$13(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Names$TypeName ), ()Ljava/lang/String;)((CodePrinter)this, (Names.TypeName)name));
                                                                        return;
                                                                    }
                                                                    if (!(tree instanceof Trees.LabelDef)) break block124;
                                                                    var57_54 = (Trees.LabelDef)tree;
                                                                    name = var57_54.name();
                                                                    params = var57_54.params();
                                                                    rhs = var57_54.rhs();
                                                                    if (name.startsWith(this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().WHILE_PREFIX())) {
                                                                        if (!(rhs instanceof Trees.If)) {
                                                                            throw new MatchError(rhs);
                                                                        }
                                                                        var61_58 = (Trees.If)rhs;
                                                                        cond = var61_58.cond();
                                                                        thenp = var61_58.thenp();
                                                                        var61_58.elsep();
                                                                        cond = var62_59;
                                                                        thenp = var63_60;
                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"while (", cond, ") "}));
                                                                        if (!(thenp instanceof Trees.Block)) {
                                                                            throw new MatchError(thenp);
                                                                        }
                                                                        var66_63 = (Trees.Block)thenp;
                                                                        list = var66_63.stats();
                                                                        var66_63.expr();
                                                                        list = var67_64;
                                                                        this.printColumn((List<Trees.Tree>)list, "", ";", "");
                                                                        return;
                                                                    }
                                                                    if (!name.startsWith(this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().DO_WHILE_PREFIX())) break block125;
                                                                    if (!(rhs instanceof Trees.Block)) break block126;
                                                                    var69_66 = (Trees.Block)rhs;
                                                                    bodyList = var69_66.stats();
                                                                    ifCond = var69_66.expr();
                                                                    if (ifCond instanceof Trees.If) break block127;
                                                                }
                                                                throw new MatchError(rhs);
                                                            }
                                                            var72_69 = (Trees.If)ifCond;
                                                            cond = var72_69.cond();
                                                            var72_69.thenp();
                                                            var72_69.elsep();
                                                            bodyList = var70_67;
                                                            cond = var73_70;
                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"do "}));
                                                            this.printColumn((List<Trees.Tree>)bodyList, "", ";", "");
                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" while (", cond, ") "}));
                                                            return;
                                                        }
                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.printedName(name, this.printedName$default$2())}));
                                                        this.printLabelParams(params);
                                                        this.printBlock(rhs);
                                                        return;
                                                    }
                                                    if (tree instanceof Trees.Import) {
                                                        var76_73 = (Trees.Import)tree;
                                                        expr = var76_73.expr();
                                                        this.printImport(var76_73, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$processTreePrinting$14(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Tree ), ()Ljava/lang/String;)((CodePrinter)this, (Trees.Tree)expr));
                                                        return;
                                                    }
                                                    if (!(tree instanceof Trees.Template)) break block128;
                                                    var78_75 = (Trees.Template)tree;
                                                    parents = var78_75.parents();
                                                    self = var78_75.self();
                                                    body = this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().untypecheckedTemplBody(var78_75);
                                                    v2 = this.currentParent();
                                                    if (v2 == null) {
                                                        throw null;
                                                    }
                                                    map_this = v2;
                                                    if (map_this.isEmpty()) {
                                                        var230_80 /* !! */  = None$.MODULE$;
                                                    } else {
                                                        var242_81 = map_this.get();
                                                        var230_80 /* !! */  = new Some<List>(CodePrinter.$anonfun$processTreePrinting$15(this, parents, var242_81));
                                                    }
                                                    if (var230_80 /* !! */  == null) {
                                                        throw null;
                                                    }
                                                    var231_82 = var230_80 /* !! */ .isEmpty() != false ? CodePrinter.$anonfun$processTreePrinting$16(parents) : var230_80 /* !! */ .get();
                                                    printedParents = var231_82;
                                                    primaryCtr = this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().firstConstructor(body);
                                                    if (primaryCtr instanceof Trees.DefDef && (var84_85 = ((Trees.DefDef)primaryCtr).rhs()) instanceof Trees.Block) {
                                                        ctBody = ((Trees.Block)var84_85).stats();
                                                        var87_87 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().preSuperFields(ctBody);
                                                        earlyDefs = ((List)body.filter((Function1)(Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$processTreePrinting$17$adapted(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Tree ), (Lscala/reflect/internal/Trees$Tree;)Ljava/lang/Object;)((CodePrinter)this))).$colon$colon$colon(var87_87);
                                                        if (earlyDefs.nonEmpty()) {
                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"{"}));
                                                            this.printColumn(earlyDefs, "", ";", "");
                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(2).append("} ").append((Object)(printedParents.nonEmpty() != false ? "with " : "")).toString()}));
                                                        }
                                                        var6_89 /* !! */  = ctBody.collectFirst(new Serializable(null){
                                                            public static final long serialVersionUID = 0L;

                                                            public final <A1 extends Trees.Tree, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                                                                Trees.Apply apply2 = x1 instanceof Trees.Apply ? (Trees.Apply)x1 : function1.apply(x1);
                                                                return (B1)apply2;
                                                            }

                                                            public final boolean isDefinedAt(Trees.Tree x1) {
                                                                boolean bl = x1 instanceof Trees.Apply;
                                                                return bl;
                                                            }
                                                        });
                                                    } else {
                                                        var6_89 /* !! */  = None$.MODULE$;
                                                    }
                                                    if (!printedParents.nonEmpty()) break block129;
                                                    if (!(printedParents instanceof $colon$colon)) {
                                                        throw new MatchError(printedParents);
                                                    }
                                                    var88_90 = ($colon$colon)printedParents;
                                                    clParent = (Trees.Tree)var88_90.head();
                                                    traits = var88_90.tl$access$1();
                                                    clParent = var89_91;
                                                    traits = var90_92;
                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{clParent}));
                                                    if (!(var6_89 /* !! */  instanceof Some)) ** GOTO lbl-1000
                                                    var93_95 = (Trees.Apply)((Some)var6_89 /* !! */ ).value();
                                                    var94_96 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().Applied().unapply(var93_95);
                                                    if (!var94_96.isEmpty()) {
                                                        var5_97 /* !! */  = var94_96.get()._3();
                                                    } else lbl-1000:
                                                    // 2 sources

                                                    {
                                                        var5_97 /* !! */  = Nil$.MODULE$;
                                                    }
                                                    this.printArgss(var5_97 /* !! */ );
                                                    if (traits.nonEmpty()) {
                                                        this.printRow((List<Trees.Tree>)traits, " with ", " with ", "");
                                                    }
                                                }
                                                v3 = (List)body.filter((Function1)(Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$processTreePrinting$18$adapted(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Tree ), (Lscala/reflect/internal/Trees$Tree;)Ljava/lang/Object;)((CodePrinter)this));
                                                if (v3 == null) {
                                                    throw null;
                                                }
                                                span_this = v3;
                                                span_b = new ListBuffer<A>();
                                                span_these = span_this;
                                                while (!span_these.isEmpty() && CodePrinter.$anonfun$processTreePrinting$19(this, var243_101 = (Trees.Tree)span_these.head())) {
                                                    span_b.$plus$eq((Object)span_these.head());
                                                    span_these = (List)span_these.tail();
                                                }
                                                left = span_b.toList();
                                                right = var234_100;
                                                left = var95_102;
                                                modBody = var96_103.drop(1).$colon$colon$colon(left);
                                                if (!modBody.isEmpty()) ** GOTO lbl-1000
                                                v4 = self;
                                                var99_106 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().noSelfType();
                                                if ((v4 == null ? var99_106 != null : v4.equals(var99_106) == false) && !self.isEmpty()) lbl-1000:
                                                // 2 sources

                                                {
                                                    v5 = true;
                                                } else {
                                                    v5 = false;
                                                }
                                                if (v5) {
                                                    v6 = self.name();
                                                    var100_107 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().WILDCARD();
                                                    if (v6 == null ? var100_107 != null : v6.equals(var100_107) == false) {
                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" { ", self.name()}));
                                                        this.printOpt(": ", self.tpt());
                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" =>"}));
                                                    } else if (self.tpt().nonEmpty()) {
                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" { _ : ", self.tpt(), " =>"}));
                                                    } else {
                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" {"}));
                                                    }
                                                    this.printColumn(modBody, "", ";", "}");
                                                    return;
                                                }
                                                break block130;
                                            }
                                            if (tree instanceof Trees.Block) {
                                                var101_108 = (Trees.Block)tree;
                                                expr = var101_108.expr();
                                                this.printBlock(this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().untypecheckedBlockBody(var101_108), expr);
                                                return;
                                            }
                                            if (tree instanceof Trees.Match) {
                                                var103_110 = (Trees.Match)tree;
                                                selector = var103_110.selector();
                                                cases = var103_110.cases();
                                                x$8 = false;
                                                x$9 = this.needsParentheses$default$2(selector);
                                                x$10 = this.needsParentheses$default$3(selector);
                                                x$11 = this.needsParentheses$default$4(selector);
                                                x$12 = this.needsParentheses$default$5(selector);
                                                x$13 = this.needsParentheses$default$6(selector);
                                                x$14 = this.needsParentheses$default$8(selector);
                                                printParentheses = this.needsParentheses(selector, x$9, x$10, x$11, x$12, x$13, x$8, x$14);
                                                if (tree instanceof Trees.Match) {
                                                    var114_121 = ((Trees.Match)tree).selector();
                                                    if (this.scala$reflect$internal$Printers$CodePrinter$$$outer().EmptyTree().equals(var114_121)) {
                                                        this.printColumn(cases, "{", "", "}");
                                                        return;
                                                    }
                                                }
                                                if (this.parentsStack().nonEmpty() && ((IterableLike)this.parentsStack().tail()).exists((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$processTreePrinting$20$adapted(scala.reflect.internal.Trees$Tree ), (Lscala/reflect/internal/Trees$Tree;)Ljava/lang/Object;)())) {
                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"("}));
                                                    CodePrinter.$anonfun$processTreePrinting$21(this, printParentheses, selector, cases);
                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{")"}));
                                                    return;
                                                }
                                                CodePrinter.$anonfun$processTreePrinting$21(this, printParentheses, selector, cases);
                                                return;
                                            }
                                            if (tree instanceof Trees.CaseDef) {
                                                var115_122 = (Trees.CaseDef)tree;
                                                this.printCaseDef(var115_122);
                                                return;
                                            }
                                            if (tree instanceof Trees.Star) {
                                                elem = ((Trees.Star)tree).elem();
                                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{elem, "*"}));
                                                return;
                                            }
                                            if (tree instanceof Trees.Bind) {
                                                var117_124 = (Trees.Bind)tree;
                                                name = var117_124.name();
                                                v7 = t = var117_124.body();
                                                var120_127 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().EmptyTree();
                                                if (!(v7 != null ? v7.equals(var120_127) == false : var120_127 != null)) {
                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", this.printedName(name, this.printedName$default$2()), ")"}));
                                                    return;
                                                }
                                                if (t.exists((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$processTreePrinting$23$adapted(scala.reflect.internal.Trees$Tree ), (Lscala/reflect/internal/Trees$Tree;)Ljava/lang/Object;)())) {
                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.printedName(name, this.printedName$default$2()), " @ ", t}));
                                                    return;
                                                }
                                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", this.printedName(name, this.printedName$default$2()), " @ ", t, ")"}));
                                                return;
                                            }
                                            if (tree instanceof Trees.Function) {
                                                var121_128 = (Trees.Function)tree;
                                                vparams = var121_128.vparams();
                                                var4_130 = vparams instanceof $colon$colon != false ? ((Trees.ValDef)(($colon$colon)vparams).head()).mods().isImplicit() == false : true;
                                                this.printFunction(var121_128, (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$24(scala.reflect.internal.Printers$CodePrinter scala.collection.immutable.List boolean ), ()V)((CodePrinter)this, vparams, (boolean)var4_130));
                                                return;
                                            }
                                            if (!(tree instanceof Trees.Typed)) break block131;
                                            var123_131 = (Trees.Typed)tree;
                                            expr = var123_131.expr();
                                            tp = var123_131.tpt();
                                            if (!this.scala$reflect$internal$Printers$CodePrinter$$$outer().EmptyTree().equals(tp)) break block132;
                                            var3_134 = true;
                                            break block133;
                                        }
                                        if (!(tp instanceof Trees.TypeTree)) ** GOTO lbl-1000
                                        var126_135 = (Trees.TypeTree)tp;
                                        if (this.EmptyTypeTree().unapply(var126_135)) {
                                            var3_134 = true;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var3_134 = false;
                                        }
                                    }
                                    if (var3_134) {
                                        this.printTp$1(tp);
                                        return;
                                    }
                                    if (tp instanceof Trees.Annotated) {
                                        arg = ((Trees.Annotated)tp).arg();
                                        if (expr != null && arg != null && expr.equalsStructure(arg)) {
                                            this.printTp$1(tp);
                                            return;
                                        }
                                    }
                                    if (tp instanceof Trees.TypeTree && ((Trees.TypeTree)tp).original() instanceof Trees.Annotated) {
                                        this.printTp$1(tp);
                                        return;
                                    }
                                    if (tp instanceof Trees.Function) {
                                        var128_137 = (Trees.Function)tp;
                                        var129_138 = var128_137.vparams();
                                        var130_139 = var128_137.body();
                                        var131_140 = List$.MODULE$.unapplySeq(var129_138);
                                        if (!var131_140.isEmpty() && var131_140.get() != null && ((LinearSeqOptimized)var131_140.get()).lengthCompare(0) == 0 && this.scala$reflect$internal$Printers$CodePrinter$$$outer().EmptyTree().equals(var130_139)) {
                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", expr, " _)"}));
                                            return;
                                        }
                                    }
                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"((", expr, "): ", tp, ")"}));
                                    return;
                                }
                                if (tree instanceof Trees.TypeApply) {
                                    block122: {
                                        var132_141 = (Trees.TypeApply)tree;
                                        fun = var132_141.fun();
                                        targs = var132_141.args();
                                        if (targs == null) {
                                            throw null;
                                        }
                                        exists_these /* !! */  = targs;
                                        while (!exists_these /* !! */ .isEmpty()) {
                                            var244_145 = (Trees.Tree)exists_these /* !! */ .head();
                                            if (CodePrinter.$anonfun$processTreePrinting$25(this, var244_145)) {
                                                var236_146 = true;
                                                break block122;
                                            }
                                            exists_these /* !! */  = (LinearSeqOptimized)exists_these /* !! */ .tail();
                                        }
                                        var236_146 = false;
                                    }
                                    if (var236_146) {
                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{fun}));
                                        return;
                                    }
                                    super.printTree(tree);
                                    return;
                                }
                                if (tree instanceof Trees.Apply) {
                                    var135_147 = (Trees.Apply)tree;
                                    fun = var135_147.fun();
                                    vargs = var135_147.args();
                                    var138_150 = false;
                                    var139_151 = null;
                                    if (tree instanceof Trees.Apply) {
                                        var138_150 = true;
                                        var139_151 = (Trees.Apply)tree;
                                        var140_152 = var139_151.fun();
                                        l3 = var139_151.args();
                                        if (var140_152 instanceof Trees.Block) {
                                            var142_154 = (Trees.Block)var140_152;
                                            l1 = var142_154.stats();
                                            a1 = var142_154.expr();
                                            var145_157 = List$.MODULE$.unapplySeq(l1);
                                            if (!var145_157.isEmpty() && var145_157.get() != null && ((LinearSeqOptimized)var145_157.get()).lengthCompare(1) == 0 && (sVD = (Trees.Tree)((LinearSeqOptimized)var145_157.get()).apply(0)) instanceof Trees.ValDef) {
                                                var147_159 = (Trees.ValDef)sVD;
                                                if (a1 instanceof Trees.Apply) {
                                                    var148_160 = (Trees.Apply)a1;
                                                    var149_161 = var148_160.fun();
                                                    l2 = var148_160.args();
                                                    if (var149_161 instanceof Trees.Select) {
                                                        methodName = ((Trees.Select)var149_161).name();
                                                        var152_164 = List$.MODULE$.unapplySeq(l2);
                                                        if (!var152_164.isEmpty() && var152_164.get() != null && ((LinearSeqOptimized)var152_164.get()).lengthCompare(1) == 0 && (var153_165 = (Trees.Tree)((LinearSeqOptimized)var152_164.get()).apply(0)) instanceof Trees.Ident) {
                                                            iVDName = ((Trees.Ident)var153_165).name();
                                                            if (var147_159.mods().isSynthetic() && this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().isLeftAssoc(methodName)) {
                                                                v8 = var147_159.name();
                                                                if (!(v8 != null ? v8.equals(iVDName) == false : iVDName != null)) {
                                                                    printBlock = new Trees.Block(this.scala$reflect$internal$Printers$CodePrinter$$$outer(), l1, new Trees.Apply(this.scala$reflect$internal$Printers$CodePrinter$$$outer(), var148_160, l3));
                                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{printBlock}));
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (var138_150) {
                                        tree1 = var139_151.fun();
                                        x$16 = false;
                                        x$17 = this.needsParentheses$default$2(tree1);
                                        if (this.needsParentheses(tree1, x$17, x$18 = this.needsParentheses$default$3(tree1), x$19 = this.needsParentheses$default$4(tree1), x$16, x$20 = this.needsParentheses$default$6(tree1), x$21 = this.needsParentheses$default$7(tree1), x$22 = this.needsParentheses$default$8(tree1))) {
                                            this.parenthesize(this.parenthesize$default$1(), this.parenthesize$default$2(), this.parenthesize$default$3(), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$26(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Tree ), ()V)((CodePrinter)this, (Trees.Tree)fun));
                                            this.printRow(vargs, "(", ", ", ")");
                                            return;
                                        }
                                    }
                                    super.printTree(tree);
                                    return;
                                }
                                if (!(tree instanceof Trees.UnApply)) break block134;
                                var164_176 = (Trees.UnApply)tree;
                                fun = var164_176.fun();
                                args = var164_176.args();
                                var167_179 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().Unapplied().unapply(fun);
                                if (var167_179.isEmpty()) break block135;
                                body = var167_179.get();
                                if (!(body instanceof Trees.Select)) break block136;
                                var169_181 = (Trees.Select)body;
                                qual = var169_181.qualifier();
                                v9 = var169_181.name();
                                var171_183 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().unapply();
                                if (v9 != null ? v9.equals(var171_183) == false : var171_183 != null) break block136;
                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{qual}));
                                break block137;
                            }
                            if (!(body instanceof Trees.TypeApply) || !((var172_184 = ((Trees.TypeApply)body).fun()) instanceof Trees.Select)) ** GOTO lbl-1000
                            var173_185 = (Trees.Select)var172_184;
                            qual = var173_185.qualifier();
                            v10 = name = var173_185.name();
                            var176_188 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().unapply();
                            if (!(v10 == null ? var176_188 != null : v10.equals(var176_188) == false)) ** GOTO lbl-1000
                            v11 = name;
                            var177_189 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().unapplySeq();
                            if (!(v11 != null ? v11.equals(var177_189) == false : var177_189 != null)) lbl-1000:
                            // 2 sources

                            {
                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{qual}));
                            } else lbl-1000:
                            // 2 sources

                            {
                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{body}));
                            }
                            break block137;
                        }
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{fun}));
                    }
                    this.printRow(args, "(", ", ", ")");
                    return;
                }
                if (tree instanceof Trees.Super && (var179_191 = (var178_190 = (Trees.Super)tree).qual()) instanceof Trees.This) {
                    qual = ((Trees.This)var179_191).qual();
                    this.printSuper(var178_190, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$processTreePrinting$27(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Names$TypeName ), ()Ljava/lang/String;)((CodePrinter)this, (Names.TypeName)qual), false);
                    return;
                }
                if (tree instanceof Trees.This) {
                    var181_193 = (Trees.This)tree;
                    qual = var181_193.qual();
                    if (tree.hasExistingSymbol() && tree.symbol().hasPackageFlag()) {
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree.symbol().fullName()}));
                        return;
                    }
                    this.printThis(var181_193, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$processTreePrinting$28(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Names$TypeName ), ()Ljava/lang/String;)((CodePrinter)this, (Names.TypeName)qual));
                    return;
                }
                if (tree instanceof Trees.Select) {
                    var8_2 = true;
                    var9_3 = (Trees.Select)tree;
                    var183_195 = var9_3.qualifier();
                    name = var9_3.name();
                    if (var183_195 instanceof Trees.This) {
                        v12 = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().CONSTRUCTOR();
                        if (!(v12 != null ? v12.equals(name) == false : name != null)) {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.printedName(name, this.printedName$default$2())}));
                            return;
                        }
                    }
                }
                if (var8_2 && (qual = var9_3.qualifier()) instanceof Trees.New) {
                    var186_198 = (Trees.New)qual;
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{var186_198}));
                    return;
                }
                if (var8_2) {
                    qual = var9_3.qualifier();
                    name = var9_3.name();
                    if (this.printRootPkg && this.checkRootPackage$1(tree)) {
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append(this.printedName(this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().ROOTPKG(), this.printedName$default$2())).append(".").toString()}));
                    }
                    x$24 = false;
                    x$25 = this.needsParentheses$default$2(qual);
                    if (this.needsParentheses(qual, x$25, x$26 = this.needsParentheses$default$3(qual), x$27 = this.needsParentheses$default$4(qual), x$24, x$28 = this.needsParentheses$default$6(qual), x$29 = this.needsParentheses$default$7(qual), x$30 = this.needsParentheses$default$8(qual)) != false || this.isIntLitWithDecodedOp(qual, name) != false) {
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", this.resolveSelect(qual), ").", this.printedName(name, this.printedName$default$2())}));
                        return;
                    }
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.resolveSelect(qual), ".", this.printedName(name, this.printedName$default$2())}));
                    return;
                }
                if (tree instanceof Trees.Ident) {
                    var196_208 = (Trees.Ident)tree;
                    name = var196_208.name();
                    if (name.nonEmpty()) {
                        if (name.equals(this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().dollarScope())) {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(10).append("scala.xml.").append(this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().TopScope()).toString()}));
                            return;
                        }
                        str = this.printedName(name, this.printedName$default$2());
                        strIsBackquoted = str.startsWith("`") != false && str.endsWith("`") != false;
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{var196_208.isBackquoted() != false && strIsBackquoted == false ? new StringBuilder(2).append("`").append(str).append("`").toString() : str}));
                        return;
                    }
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{""}));
                    return;
                }
                if (tree instanceof Trees.Literal) {
                    var10_4 = true;
                    var11_5 = (Trees.Literal)tree;
                    k = var11_5.value();
                    if (k != null && (s = k.value()) instanceof String) {
                        var202_214 = (String)s;
                        if (Predef$.MODULE$ == null) {
                            throw null;
                        }
                        if (new StringOps(var202_214).contains(BoxesRunTime.boxToCharacter('\n'))) {
                            var237_215 = "\"";
                            if (Predef$.MODULE$ == null) {
                                throw null;
                            }
                            tq = new StringOps(var237_215).$times(3);
                            if (Predef$.MODULE$ == null) {
                                throw null;
                            }
                            lines = new StringOps(var202_214).linesIterator().toList();
                            if (lines.lengthCompare(1) <= 0) {
                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{k.escapedStringValue()}));
                                return;
                            }
                            var238_218 = "[\"]{3}";
                            if (Predef$.MODULE$ == null) {
                                throw null;
                            }
                            tqp = new StringOps(var238_218).r();
                            tqq = "\"\"\\\\\"";
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tq}));
                            this.printSeq(lines.map((Function1<String, String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$processTreePrinting$29(scala.util.matching.Regex java.lang.String java.lang.String ), (Ljava/lang/String;)Ljava/lang/String;)((Regex)tqp, (String)tqq), List$.MODULE$.canBuildFrom()), (Function1<String, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$processTreePrinting$30$adapted(scala.reflect.internal.Printers$CodePrinter java.lang.String ), (Ljava/lang/String;)Ljava/lang/Object;)((CodePrinter)this), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$31(scala.reflect.internal.Printers$CodePrinter ), ()V)((CodePrinter)this));
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tq}));
                            return;
                        }
                    }
                }
                if (var10_4) {
                    x = var11_5.value();
                    var2_222 = x.value() instanceof Float != false ? "F" : "";
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(0).append(x.escapedStringValue()).append(var2_222).toString()}));
                    return;
                }
                if (tree instanceof Trees.Annotated) {
                    var208_223 = (Trees.Annotated)tree;
                    ap = var208_223.annot();
                    tree = var208_223.arg();
                    x$32 = this.needsParentheses$default$2(tree);
                    x$33 = this.needsParentheses$default$3(tree);
                    x$34 = this.needsParentheses$default$4(tree);
                    x$35 = this.needsParentheses$default$5(tree);
                    x$36 = this.needsParentheses$default$6(tree);
                    x$37 = this.needsParentheses$default$7(tree);
                    x$38 = this.needsParentheses$default$8(tree);
                    printParentheses = this.needsParentheses(tree, x$32, x$33, x$34, x$35, x$36, x$37, x$38);
                    this.parenthesize(printParentheses, this.parenthesize$default$2(), this.parenthesize$default$3(), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$processTreePrinting$32(scala.reflect.internal.Printers$CodePrinter scala.reflect.internal.Trees$Tree ), ()V)((CodePrinter)this, (Trees.Tree)tree));
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree.isType() != false ? " " : ": "}));
                    this.printAnnot(ap);
                    return;
                }
                if (tree instanceof Trees.SelectFromTypeTree) {
                    var219_234 = (Trees.SelectFromTypeTree)tree;
                    qualifier = var219_234.qualifier();
                    selector = var219_234.name();
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", qualifier, ")#", this.blankForOperatorName(selector), this.printedName(selector, this.printedName$default$2())}));
                    return;
                }
                if (tree instanceof Trees.TypeTree) {
                    var222_237 = (Trees.TypeTree)tree;
                    if (!this.isEmptyTree(var222_237)) {
                        original = var222_237.original();
                        if (original != null) {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{original}));
                            return;
                        }
                        super.printTree(tree);
                        return;
                    }
                } else {
                    if (tree instanceof Trees.AppliedTypeTree) {
                        block123: {
                            args = ((Trees.AppliedTypeTree)tree).args();
                            if (args == null) {
                                throw null;
                            }
                            exists_these /* !! */  = args;
                            while (!exists_these /* !! */ .isEmpty()) {
                                var245_241 = (Trees.Tree)exists_these /* !! */ .head();
                                if (CodePrinter.$anonfun$processTreePrinting$33(this, var245_241)) {
                                    var240_242 = true;
                                    break block123;
                                }
                                exists_these /* !! */  = (LinearSeqOptimized)exists_these /* !! */ .tail();
                            }
                            var240_242 = false;
                        }
                        if (var240_242) {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"("}));
                            this.printRow((List)args.init(), "(", ", ", ")");
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" => ", args.last(), ")"}));
                            return;
                        }
                        if (this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().isRepeatedParamType(tree) && args.nonEmpty()) {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{args.apply(0), "*"}));
                            return;
                        }
                        if (this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().isByNameParamType(tree)) {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"=> ", args.isEmpty() != false ? "()" : args.apply(0)}));
                            return;
                        }
                        super.printTree(tree);
                        return;
                    }
                    if (tree instanceof Trees.ExistentialTypeTree) {
                        var225_243 = (Trees.ExistentialTypeTree)tree;
                        tpt = var225_243.tpt();
                        whereClauses = var225_243.whereClauses();
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", tpt}));
                        this.printColumn(whereClauses, " forSome { ", ";", "})");
                        return;
                    }
                    if (this.scala$reflect$internal$Printers$CodePrinter$$$outer().EmptyTree().equals(tree)) {
                        return;
                    }
                    super.printTree(tree);
                }
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Printers$CodePrinter$$$outer() {
            return this.$outer;
        }

        private final void EmptyTypeTree$lzycompute$1() {
            synchronized (this) {
                if (this.EmptyTypeTree$module == null) {
                    this.EmptyTypeTree$module = new Printers$CodePrinter$EmptyTypeTree$(this);
                }
                return;
            }
        }

        public static final /* synthetic */ boolean $anonfun$printedName$1(char x) {
            return x == '.';
        }

        public static final /* synthetic */ boolean $anonfun$printedName$2(List brackets$1, Function1 isDot$1, char ch) {
            return brackets$1.contains(BoxesRunTime.boxToCharacter(ch)) || Chars$.MODULE$.isWhitespace(ch) || BoxesRunTime.unboxToBoolean(isDot$1.apply(BoxesRunTime.boxToCharacter(ch)));
        }

        private static final String addBackquotes$1(String s, boolean decoded$2, String decName$1, List brackets$1, Function1 isDot$1, Names.Name name$5, char bslash$1) {
            block7: {
                block8: {
                    if (!decoded$2) break block7;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (IndexedSeqOptimized.exists$(new StringOps(decName$1), (Function1<Object, Object> & java.io.Serializable & Serializable)ch -> {
                        char $anonfun$printedName$2_ch = BoxesRunTime.unboxToChar(ch);
                        return BoxesRunTime.boxToBoolean(brackets$1.contains(BoxesRunTime.boxToCharacter($anonfun$printedName$2_ch)) || Chars$.MODULE$.isWhitespace($anonfun$printedName$2_ch) || BoxesRunTime.unboxToBoolean(isDot$1.apply(BoxesRunTime.boxToCharacter($anonfun$printedName$2_ch))));
                    })) break block8;
                    if (!name$5.isOperatorName()) break block7;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (!IndexedSeqOptimized.exists$(new StringOps(decName$1), (Function1<Object, Object> & java.io.Serializable & Serializable)c -> BoxesRunTime.boxToBoolean(Chars$.MODULE$.isOperatorPart(BoxesRunTime.unboxToChar(c))))) break block7;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (!IndexedSeqOptimized.exists$(new StringOps(decName$1), (Function1<Object, Object> & java.io.Serializable & Serializable)ch -> BoxesRunTime.boxToBoolean(Chars$.MODULE$.isScalaLetter(BoxesRunTime.unboxToChar(ch))))) break block7;
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    if (new StringOps(decName$1).contains(BoxesRunTime.boxToCharacter(bslash$1))) break block7;
                }
                return new StringBuilder(2).append("`").append(s).append("`").toString();
            }
            return s;
        }

        public static final /* synthetic */ boolean $anonfun$originalTypeTrees$1(CodePrinter $this, Trees.Tree x$15) {
            return !$this.isEmptyTree(x$15);
        }

        private final List removeDefaultTraitsFromList$1(List trees, List traitsToRemove) {
            while (!((Object)Nil$.MODULE$).equals(trees)) {
                Option option = scala.package$.MODULE$.$colon$plus().unapply(trees);
                if (!option.isEmpty()) {
                    List init = option.get()._1();
                    Trees.Tree last = (Trees.Tree)option.get()._2();
                    if (!(last instanceof Trees.Select)) break;
                    Trees.Select select = (Trees.Select)last;
                    Trees.Tree tree = select.qualifier();
                    Names.Name name = select.name();
                    if (!(tree instanceof Trees.Ident)) break;
                    Names.Name sc = ((Trees.Ident)tree).name();
                    if (!traitsToRemove.contains(name)) break;
                    Names.Name name2 = sc;
                    Names.TermName termName = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().scala_();
                    if (name2 != null ? !name2.equals(termName) : termName != null) break;
                    trees = init;
                    continue;
                }
                throw new MatchError(trees);
            }
            return trees;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public static final /* synthetic */ boolean $anonfun$removeDefaultClassesFromList$1(CodePrinter $this, List classesToRemove$1, Trees.Tree x0$1) {
            if (x0$1 instanceof Trees.Select) {
                Trees.Select select = (Trees.Select)x0$1;
                Trees.Tree tree = select.qualifier();
                Names.Name name = select.name();
                if (tree instanceof Trees.Ident) {
                    Names.Name sc = ((Trees.Ident)tree).name();
                    if (!classesToRemove$1.contains(name)) return true;
                    Names.Name name2 = sc;
                    Names.TermName termName = $this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().scala_();
                    if (name2 == null) {
                        if (termName == null) return false;
                        return true;
                    } else if (name2.equals(termName)) return false;
                    return true;
                }
            }
            if (!(x0$1 instanceof Trees.TypeTree)) return true;
            Trees.TypeTree typeTree = (Trees.TypeTree)x0$1;
            if (typeTree.tpe() == null) return true;
            if (classesToRemove$1.contains($this.scala$reflect$internal$Printers$CodePrinter$$$outer().newTypeName(typeTree.tpe().toString()))) return false;
            return true;
        }

        public static final /* synthetic */ boolean $anonfun$printColumn$3(CodePrinter $this, Trees.Tree x$16) {
            return !$this.syntheticToRemove(x$16);
        }

        public static final /* synthetic */ boolean $anonfun$printModifiers$2(Trees.Tree x0$1) {
            boolean bl = x0$1 instanceof Trees.ClassDef ? true : (x0$1 instanceof Trees.ModuleDef ? true : (x0$1 instanceof Trees.Template ? true : x0$1 instanceof Trees.PackageDef));
            boolean bl2 = bl;
            return bl2;
        }

        public static final /* synthetic */ boolean $anonfun$printModifiers$3() {
            return false;
        }

        public static final /* synthetic */ boolean $anonfun$printModifiers$1(Option x$17) {
            if (x$17 == null) {
                throw null;
            }
            Option option = x$17.isEmpty() ? None$.MODULE$ : new Some<Boolean>(BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$printModifiers$2((Trees.Tree)x$17.get())));
            if (option == null) {
                throw null;
            }
            Boolean bl = ((Option)option).isEmpty() ? BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$printModifiers$3()) : ((Option)option).get();
            return BoxesRunTime.unboxToBoolean(bl);
        }

        private final boolean modsAccepted$1() {
            boolean bl;
            block2: {
                LinearSeqOptimized exists_these = new $colon$colon<Nothing$>((Nothing$)((Object)this.currentTree()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.currentParent()), Nil$.MODULE$));
                while (!exists_these.isEmpty()) {
                    if (CodePrinter.$anonfun$printModifiers$1((Option)exists_these.head())) {
                        bl = true;
                        break block2;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            return bl;
        }

        public static final /* synthetic */ void $anonfun$printModifiers$4(CodePrinter $this, Trees.Modifiers mods$2, long flag) {
            if (mods$2.hasFlag(flag)) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append(mods$2.flagBitsToString(flag)).append(" ").toString()}));
            }
        }

        public static final /* synthetic */ void $anonfun$printArgss$1(CodePrinter $this, List argss$1, List x) {
            if (!x.isEmpty() || argss$1.size() != 1) {
                $this.printRow(x, "(", ", ", ")");
            }
        }

        public static final /* synthetic */ void $anonfun$printAnnotations$2(CodePrinter $this, Trees.Tree annot) {
            $this.printAnnot(annot);
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" "}));
        }

        private final void printConstrParams$1(List ts) {
            this.parenthesize(this.parenthesize$default$1(), this.parenthesize$default$2(), this.parenthesize$default$3(), (JFunction0$mcV$sp & Serializable)() -> {
                this.printImplicitInParamsList(ts);
                this.printSeq(ts, (Function1<Trees.ValDef, Object> & java.io.Serializable & Serializable)x$19 -> {
                    this.printParam(x$19, true);
                    return BoxedUnit.UNIT;
                }, (JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{", "})));
            });
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$6(CodePrinter $this) {
            $this.println();
            $this.println();
        }

        public static final /* synthetic */ String $anonfun$processTreePrinting$7(CodePrinter $this, Names.TermName name$6) {
            return $this.printedName(name$6, $this.printedName$default$2());
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$8(CodePrinter $this, Names.TermName name$6, Trees.Tree tp$3) {
            $this.printOpt(new StringBuilder(2).append($this.blankForName(name$6)).append(": ").toString(), tp$3);
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$9(CodePrinter $this, Trees.Modifiers mods$3, Trees.Tree rhs$3) {
            if (!mods$3.isDeferred()) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" = ", rhs$3.isEmpty() ? "_" : rhs$3}));
            }
        }

        public static final /* synthetic */ String $anonfun$processTreePrinting$10(CodePrinter $this, Names.TermName name$7) {
            return $this.printedName(name$7, $this.printedName$default$2());
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$11(CodePrinter $this, List tparams$1, List vparamss$1, Names.TermName name$7, Trees.Tree tp$4) {
            if (tparams$1.isEmpty() && (vparamss$1.isEmpty() || ((SeqLike)vparamss$1.apply(0)).isEmpty())) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{$this.blankForName(name$7)}));
            }
            $this.printOpt(": ", tp$4);
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$12(CodePrinter $this, Trees.Modifiers mods$4, Trees.Tree rhs$4) {
            $this.printOpt(new StringBuilder(3).append(" = ").append((Object)(mods$4.isMacro() ? "macro " : "")).toString(), rhs$4);
        }

        public static final /* synthetic */ String $anonfun$processTreePrinting$13(CodePrinter $this, Names.TypeName name$8) {
            return $this.printedName(name$8, $this.printedName$default$2());
        }

        public static final /* synthetic */ String $anonfun$processTreePrinting$14(CodePrinter $this, Trees.Tree expr$2) {
            return $this.resolveSelect(expr$2);
        }

        public static final /* synthetic */ List $anonfun$processTreePrinting$15(CodePrinter $this, List parents$1, Trees.Tree x0$1) {
            List<Trees.Tree> list;
            if (x0$1 instanceof Trees.CompoundTypeTree) {
                list = parents$1;
            } else if (x0$1 instanceof Trees.ClassDef && ((Trees.ClassDef)x0$1).mods().isCase()) {
                List<Names.Name> x$5 = $this.removeDefaultTypesFromList$default$2(parents$1);
                $colon$colon<Nothing$> x$6 = new $colon$colon<Nothing$>((Nothing$)((Object)$this.scala$reflect$internal$Printers$CodePrinter$$$outer().tpnme().Product()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)$this.scala$reflect$internal$Printers$CodePrinter$$$outer().tpnme().Serializable()), Nil$.MODULE$));
                list = $this.removeDefaultTypesFromList(parents$1, x$5, x$6);
            } else {
                list = $this.removeDefaultClassesFromList(parents$1, $this.removeDefaultClassesFromList$default$2());
            }
            return list;
        }

        public static final /* synthetic */ List $anonfun$processTreePrinting$16(List parents$1) {
            return parents$1;
        }

        public static final /* synthetic */ boolean $anonfun$processTreePrinting$17(CodePrinter $this, Trees.Tree x0$2) {
            boolean bl;
            if (x0$2 instanceof Trees.TypeDef) {
                Trees.TypeDef typeDef = (Trees.TypeDef)x0$2;
                bl = $this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().isEarlyDef(typeDef);
            } else {
                bl = false;
            }
            return bl;
        }

        public static final /* synthetic */ boolean $anonfun$processTreePrinting$18(CodePrinter $this, Trees.Tree x0$3) {
            boolean bl;
            if (x0$3 instanceof Trees.ValDef) {
                Trees.ValDef valDef = (Trees.ValDef)x0$3;
                bl = !valDef.mods().isParamAccessor() && !$this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().isEarlyValDef(valDef);
            } else if (x0$3 instanceof Trees.DefDef) {
                Names.TermName termName = ((Trees.DefDef)x0$3).name();
                Names.TermName termName2 = $this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().MIXIN_CONSTRUCTOR();
                bl = termName == null ? termName2 != null : !termName.equals(termName2);
            } else if (x0$3 instanceof Trees.TypeDef) {
                Trees.TypeDef typeDef = (Trees.TypeDef)x0$3;
                bl = !$this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().isEarlyDef(typeDef);
            } else {
                bl = !((Object)$this.scala$reflect$internal$Printers$CodePrinter$$$outer().EmptyTree()).equals(x0$3);
            }
            return bl;
        }

        public static final /* synthetic */ boolean $anonfun$processTreePrinting$19(CodePrinter $this, Trees.Tree x0$4) {
            boolean bl;
            if (x0$4 instanceof Trees.DefDef) {
                Names.TermName termName = ((Trees.DefDef)x0$4).name();
                Names.TermName termName2 = $this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().CONSTRUCTOR();
                bl = termName == null ? termName2 != null : !termName.equals(termName2);
            } else {
                bl = true;
            }
            return bl;
        }

        public static final /* synthetic */ boolean $anonfun$processTreePrinting$20(Trees.Tree x$29) {
            return x$29 instanceof Trees.Match;
        }

        private final void insertBraces$1(Function0 body) {
            if (this.parentsStack().nonEmpty() && ((IterableLike)this.parentsStack().tail()).exists((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x$29 -> BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$processTreePrinting$20(x$29)))) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"("}));
                body.apply$mcV$sp();
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{")"}));
                return;
            }
            body.apply$mcV$sp();
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$21(CodePrinter $this, boolean printParentheses$1, Trees.Tree selector$1, List cases$1) {
            $this.parenthesize(printParentheses$1, $this.parenthesize$default$2(), $this.parenthesize$default$3(), (JFunction0$mcV$sp & Serializable)() -> $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{selector$1})));
            $this.printColumn(cases$1, " match {", "", "}");
        }

        public static final /* synthetic */ boolean $anonfun$processTreePrinting$23(Trees.Tree x$30) {
            return x$30 instanceof Trees.Star;
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$24(CodePrinter $this, List vparams$2, boolean printParentheses$2) {
            $this.printValueParams(vparams$2, printParentheses$2);
        }

        private final void printTp$1(Trees.Tree tp$5) {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", tp$5, ")"}));
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$26(CodePrinter $this, Trees.Tree fun$1) {
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{fun$1}));
        }

        public static final /* synthetic */ String $anonfun$processTreePrinting$27(CodePrinter $this, Names.TypeName qual$3) {
            return $this.printedName(qual$3, $this.printedName$default$2());
        }

        public static final /* synthetic */ String $anonfun$processTreePrinting$28(CodePrinter $this, Names.TypeName qual$4) {
            return $this.printedName(qual$4, $this.printedName$default$2());
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private final boolean checkRootPackage$1(Trees.Tree tr) {
            boolean bl;
            while (true) {
                Option<Trees.Tree> option;
                if ((option = this.currentParent()) instanceof Some && ((Some)option).value() instanceof Trees.PackageDef) {
                    return false;
                }
                boolean bl2 = true;
                if (!bl2) return false;
                if (!(tr instanceof Trees.Select)) break;
                tr = ((Trees.Select)tr).qualifier();
            }
            if (tr instanceof Trees.Ident) {
                bl = true;
            } else {
                if (!(tr instanceof Trees.This)) return false;
                bl = true;
            }
            if (!bl) return false;
            Symbols.Symbol sym = tr.symbol();
            if (!tr.hasExistingSymbol()) return false;
            if (!sym.hasPackageFlag()) return false;
            Names.Name name = sym.name();
            Names.TermName termName = this.scala$reflect$internal$Printers$CodePrinter$$$outer().nme().ROOTPKG();
            if (name == null) {
                if (termName == null) return false;
                return true;
            } else if (name.equals(termName)) return false;
            return true;
        }

        public static final /* synthetic */ String $anonfun$processTreePrinting$29(Regex tqp$1, String tqq$1, String x) {
            return tqp$1.replaceAllIn((CharSequence)x, tqq$1);
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$31(CodePrinter $this) {
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToCharacter('\n')}));
        }

        public static final /* synthetic */ void $anonfun$processTreePrinting$32(CodePrinter $this, Trees.Tree tree$5) {
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree$5}));
        }

        public static final /* synthetic */ boolean $anonfun$processTreePrinting$33(CodePrinter $this, Trees.Tree tpt) {
            return $this.scala$reflect$internal$Printers$CodePrinter$$$outer().treeInfo().isByNameParamType(tpt);
        }

        public CodePrinter(SymbolTable $outer, PrintWriter out, boolean printRootPkg) {
            this.printRootPkg = printRootPkg;
            super($outer, out);
            this.parentsStack = (Stack)Stack$.MODULE$.apply(Nil$.MODULE$);
            this.commentsRequired = true;
            this.defaultClasses = new $colon$colon<Nothing$>((Nothing$)((Object)((Names.TypeName)$outer.tpnme().AnyRef())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)$outer.tpnme().Object()), Nil$.MODULE$));
            this.defaultTraitsForCase = new $colon$colon<Nothing$>((Nothing$)((Object)$outer.tpnme().Product()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)$outer.tpnme().Serializable()), Nil$.MODULE$));
        }

        public static final /* synthetic */ Object $anonfun$printArgss$1$adapted(CodePrinter $this, List argss$1, List x) {
            CodePrinter.$anonfun$printArgss$1($this, argss$1, x);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$printAnnotations$2$adapted(CodePrinter $this, Trees.Tree annot) {
            CodePrinter.$anonfun$printAnnotations$2($this, annot);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$4$adapted(CodePrinter $this, List ts) {
            $this.printConstrParams$1(ts);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$5$adapted(CodePrinter $this, Trees.Tree x$20) {
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x$20}));
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$17$adapted(CodePrinter $this, Trees.Tree x0$2) {
            return BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$processTreePrinting$17($this, x0$2));
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$18$adapted(CodePrinter $this, Trees.Tree x0$3) {
            return BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$processTreePrinting$18($this, x0$3));
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$19$adapted(CodePrinter $this, Trees.Tree x0$4) {
            return BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$processTreePrinting$19($this, x0$4));
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$23$adapted(Trees.Tree x$30) {
            return BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$processTreePrinting$23(x$30));
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$25$adapted(CodePrinter $this, Trees.Tree x$31) {
            return BoxesRunTime.boxToBoolean($this.isEmptyTree(x$31));
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$30$adapted(CodePrinter $this, String x$32) {
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x$32}));
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$processTreePrinting$33$adapted(CodePrinter $this, Trees.Tree tpt) {
            return BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$processTreePrinting$33($this, tpt));
        }

        public static final /* synthetic */ Object $anonfun$printModifiers$2$adapted(Trees.Tree x0$1) {
            return BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$printModifiers$2(x0$1));
        }

        public static final /* synthetic */ Object $anonfun$printModifiers$1$adapted(Option x$17) {
            return BoxesRunTime.boxToBoolean(CodePrinter.$anonfun$printModifiers$1(x$17));
        }
    }

    private static class Footnotes {
        private final Map<Class<?>, WeakHashMap<Object, Object>> index;
        private final Map<Class<?>, Object> counters;
        private final Map<Class<?>, SortedSet<Object>> footnotes;
        public final /* synthetic */ SymbolTable $outer;

        private Map<Class<?>, WeakHashMap<Object, Object>> index() {
            return this.index;
        }

        private <T> WeakHashMap<Object, Object> classIndex(ClassTag<T> evidence$1) {
            return (WeakHashMap)this.index().getOrElseUpdate(package$.MODULE$.classTag(evidence$1).runtimeClass(), (Function0<WeakHashMap> & java.io.Serializable & Serializable)() -> (WeakHashMap)WeakHashMap$.MODULE$.apply(Nil$.MODULE$));
        }

        private Map<Class<?>, Object> counters() {
            return this.counters;
        }

        private <T> int nextCounter(ClassTag<T> evidence$2) {
            Class<?> clazz = package$.MODULE$.classTag(evidence$2).runtimeClass();
            this.counters().getOrElseUpdate(clazz, (JFunction0$mcI$sp & Serializable)() -> 0);
            this.counters().update(clazz, BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt(this.counters().apply(clazz)) + 1));
            return BoxesRunTime.unboxToInt(this.counters().apply(clazz));
        }

        private Map<Class<?>, SortedSet<Object>> footnotes() {
            return this.footnotes;
        }

        private <T> SortedSet<Object> classFootnotes(ClassTag<T> evidence$3) {
            return (SortedSet)this.footnotes().getOrElseUpdate(package$.MODULE$.classTag(evidence$3).runtimeClass(), (Function0<SortedSet> & java.io.Serializable & Serializable)() -> (SortedSet)SortedSet$.MODULE$.apply(Nil$.MODULE$, Ordering$Int$.MODULE$));
        }

        /*
         * WARNING - void declaration
         */
        public <T> int put(T any, ClassTag<T> evidence$4) {
            void var3_3;
            int index = BoxesRunTime.unboxToInt(this.classIndex(evidence$4).getOrElseUpdate(any, (JFunction0$mcI$sp & Serializable)() -> this.nextCounter(evidence$4)));
            this.classFootnotes(evidence$4).$plus$eq(BoxesRunTime.boxToInteger(index));
            return (int)var3_3;
        }

        public <T> List<Tuple2<Object, Object>> get(ClassTag<T> evidence$5) {
            return this.classFootnotes(evidence$5).toList().map((Function1<Object, Tuple2> & java.io.Serializable & Serializable)fi -> Footnotes.$anonfun$get$1(this, evidence$5, BoxesRunTime.unboxToInt(fi)), List$.MODULE$.canBuildFrom());
        }

        public <T> void print(Printers.TreePrinter printer, ClassTag<T> evidence$6) {
            List<Tuple2<Object, Object>> footnotes = this.get(evidence$6);
            if (footnotes.nonEmpty()) {
                printer.print(Predef$.MODULE$.genericWrapArray(new Object[]{Platform$.MODULE$.EOL()}));
                List list = footnotes.zipWithIndex(List$.MODULE$.canBuildFrom());
                if (list == null) {
                    throw null;
                }
                List foreach_these = list;
                while (!foreach_these.isEmpty()) {
                    Tuple2 tuple2 = (Tuple2)foreach_these.head();
                    Footnotes.$anonfun$print$2(printer, footnotes, tuple2);
                    foreach_these = (List)foreach_these.tail();
                }
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Printers$Footnotes$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$get$2(int fi$1, Tuple2 x0$1) {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            boolean bl = x0$1._2$mcI$sp() == fi$1;
            return bl;
        }

        public static final /* synthetic */ Tuple2 $anonfun$get$1(Footnotes $this, ClassTag evidence$5$1, int fi) {
            return new Tuple2(BoxesRunTime.boxToInteger(fi), ((Tuple2)$this.classIndex(evidence$5$1).find((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(Footnotes.$anonfun$get$2(fi, x0$1))).get())._1());
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public static final /* synthetic */ void $anonfun$print$2(Printers.TreePrinter printer$1, List footnotes$1, Tuple2 x0$1) {
            if (x0$1 == null) throw new MatchError(x0$1);
            Tuple2 tuple2 = (Tuple2)x0$1._1();
            int ii = x0$1._2$mcI$sp();
            if (tuple2 == null) throw new MatchError(x0$1);
            int fi = tuple2._1$mcI$sp();
            Object any = tuple2._2();
            printer$1.print(Predef$.MODULE$.genericWrapArray(new Object[]{"[", BoxesRunTime.boxToInteger(fi), "] ", any}));
            if (ii >= footnotes$1.length() - 1) return;
            printer$1.print(Predef$.MODULE$.genericWrapArray(new Object[]{Platform$.MODULE$.EOL()}));
        }

        public Footnotes(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.index = (Map)Map$.MODULE$.apply(Nil$.MODULE$);
            this.counters = (Map)Map$.MODULE$.apply(Nil$.MODULE$);
            this.footnotes = (Map)Map$.MODULE$.apply(Nil$.MODULE$);
        }

        public static final /* synthetic */ Object $anonfun$print$2$adapted(Printers.TreePrinter printer$1, List footnotes$1, Tuple2 x0$1) {
            Footnotes.$anonfun$print$2(printer$1, footnotes$1, x0$1);
            return BoxedUnit.UNIT;
        }
    }

    public class RawTreePrinter
    implements Printers.TreePrinter {
        private final PrintWriter out;
        private int depth;
        private boolean printTypesInFootnotes;
        private boolean printingFootnotes;
        private final Footnotes footnotes;
        private boolean printTypes;
        private boolean printIds;
        private boolean printOwners;
        private boolean printKinds;
        private boolean printMirrors;
        private boolean printPositions;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public Printers.TreePrinter withTypes() {
            return Printers.TreePrinter.withTypes$(this);
        }

        @Override
        public Printers.TreePrinter withoutTypes() {
            return Printers.TreePrinter.withoutTypes$(this);
        }

        @Override
        public Printers.TreePrinter withIds() {
            return Printers.TreePrinter.withIds$(this);
        }

        @Override
        public Printers.TreePrinter withoutIds() {
            return Printers.TreePrinter.withoutIds$(this);
        }

        @Override
        public Printers.TreePrinter withOwners() {
            return Printers.TreePrinter.withOwners$(this);
        }

        @Override
        public Printers.TreePrinter withoutOwners() {
            return Printers.TreePrinter.withoutOwners$(this);
        }

        @Override
        public Printers.TreePrinter withKinds() {
            return Printers.TreePrinter.withKinds$(this);
        }

        @Override
        public Printers.TreePrinter withoutKinds() {
            return Printers.TreePrinter.withoutKinds$(this);
        }

        @Override
        public Printers.TreePrinter withMirrors() {
            return Printers.TreePrinter.withMirrors$(this);
        }

        @Override
        public Printers.TreePrinter withoutMirrors() {
            return Printers.TreePrinter.withoutMirrors$(this);
        }

        @Override
        public Printers.TreePrinter withPositions() {
            return Printers.TreePrinter.withPositions$(this);
        }

        @Override
        public Printers.TreePrinter withoutPositions() {
            return Printers.TreePrinter.withoutPositions$(this);
        }

        @Override
        public boolean printTypes() {
            return this.printTypes;
        }

        @Override
        public void printTypes_$eq(boolean x$1) {
            this.printTypes = x$1;
        }

        @Override
        public boolean printIds() {
            return this.printIds;
        }

        @Override
        public void printIds_$eq(boolean x$1) {
            this.printIds = x$1;
        }

        @Override
        public boolean printOwners() {
            return this.printOwners;
        }

        @Override
        public void printOwners_$eq(boolean x$1) {
            this.printOwners = x$1;
        }

        @Override
        public boolean printKinds() {
            return this.printKinds;
        }

        @Override
        public void printKinds_$eq(boolean x$1) {
            this.printKinds = x$1;
        }

        @Override
        public boolean printMirrors() {
            return this.printMirrors;
        }

        @Override
        public void printMirrors_$eq(boolean x$1) {
            this.printMirrors = x$1;
        }

        @Override
        public boolean printPositions() {
            return this.printPositions;
        }

        @Override
        public void printPositions_$eq(boolean x$1) {
            this.printPositions = x$1;
        }

        private int depth() {
            return this.depth;
        }

        private void depth_$eq(int x$1) {
            this.depth = x$1;
        }

        private boolean printTypesInFootnotes() {
            return this.printTypesInFootnotes;
        }

        private void printTypesInFootnotes_$eq(boolean x$1) {
            this.printTypesInFootnotes = x$1;
        }

        private boolean printingFootnotes() {
            return this.printingFootnotes;
        }

        private void printingFootnotes_$eq(boolean x$1) {
            this.printingFootnotes = x$1;
        }

        private Footnotes footnotes() {
            return this.footnotes;
        }

        @Override
        public void print(Seq<Object> args2) {
            if (this.depth() == 0 && args2.length() == 1 && args2.apply(false) != null && args2.apply(false) instanceof Types.Type) {
                this.printTypesInFootnotes_$eq(false);
            }
            this.depth_$eq(this.depth() + 1);
            args2.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x0$1 -> {
                RawTreePrinter.$anonfun$print$3(this, x0$1);
                return BoxedUnit.UNIT;
            });
            this.depth_$eq(this.depth() - 1);
            if (this.depth() == 0 && !this.printingFootnotes()) {
                this.printingFootnotes_$eq(true);
                this.footnotes().print(this, this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().TypeTagg());
                this.footnotes().print(this, ClassTag$.MODULE$.apply(Mirror.class));
                this.printingFootnotes_$eq(false);
            }
        }

        public void printProduct(Product p, Function1<Product, BoxedUnit> preamble, Function1<Object, BoxedUnit> body, Function1<Product, BoxedUnit> postamble) {
            preamble.apply(p);
            List x$1 = p.productIterator().toList();
            JFunction0$mcV$sp & Serializable x$3 = (JFunction0$mcV$sp & Serializable)() -> this.printIterable$default$2();
            JFunction0$mcV$sp & Serializable x$4 = (JFunction0$mcV$sp & Serializable)() -> this.printIterable$default$4();
            this.printIterable(x$1, x$3, body, x$4);
            postamble.apply(p);
        }

        public Function1<Product, BoxedUnit> printProduct$default$2() {
            return (Function1<Product, Object> & java.io.Serializable & Serializable)p -> {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{p.productPrefix()}));
                return BoxedUnit.UNIT;
            };
        }

        public Function1<Object, BoxedUnit> printProduct$default$3() {
            return (Function1<Object, Object> & java.io.Serializable & Serializable)x$34 -> {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x$34}));
                return BoxedUnit.UNIT;
            };
        }

        public Function1<Product, BoxedUnit> printProduct$default$4() {
            return (Function1<Product, Object> & java.io.Serializable & Serializable)p -> {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{""}));
                return BoxedUnit.UNIT;
            };
        }

        public void printIterable(List<?> iterable, Function0<BoxedUnit> preamble, Function1<Object, BoxedUnit> body, Function0<BoxedUnit> postamble) {
            preamble.apply$mcV$sp();
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"("}));
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                body.apply(it.next());
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{it.hasNext() ? ", " : ""}));
            }
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{")"}));
            postamble.apply$mcV$sp();
        }

        public void printIterable$default$2() {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{""}));
        }

        public Function1<Object, BoxedUnit> printIterable$default$3() {
            return (Function1<Object, Object> & java.io.Serializable & Serializable)x$35 -> {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x$35}));
                return BoxedUnit.UNIT;
            };
        }

        public void printIterable$default$4() {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{""}));
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Printers$RawTreePrinter$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ scala.reflect.api.Printers scala$reflect$api$Printers$TreePrinter$$$outer() {
            return this.scala$reflect$internal$Printers$RawTreePrinter$$$outer();
        }

        private final boolean hasSymbolField$1(Trees.Tree x6$1) {
            if (x6$1.hasSymbolField()) {
                Symbols.Symbol symbol = x6$1.symbol();
                Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().NoSymbol();
                if (symbol == null ? noSymbol != null : !symbol.equals(noSymbol)) {
                    return true;
                }
            }
            return false;
        }

        public static final /* synthetic */ void $anonfun$print$4(RawTreePrinter $this, Trees.Tree x6$1, Product x$33) {
            if ($this.printPositions()) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x6$1.pos().show()}));
            }
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x6$1.productPrefix()}));
            if ($this.printTypes() && x6$1.tpe() != null) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x6$1.tpe()}));
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public static final /* synthetic */ void $anonfun$print$5(RawTreePrinter $this, boolean isError$1, Trees.Tree x6$1, Object x0$2) {
            boolean bl = false;
            Constants.Constant constant = null;
            if (x0$2 instanceof Names.Name && ((Names.Name)x0$2).scala$reflect$internal$Names$Name$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                Names.Name name = (Names.Name)x0$2;
                if (isError$1) {
                    if (isError$1) {
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"<"}));
                    }
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{name}));
                    if (!isError$1) return;
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{": error>"}));
                    return;
                }
                if ($this.hasSymbolField$1(x6$1)) {
                    if (x6$1 instanceof Trees.RefTree) {
                        Trees.RefTree refTree = (Trees.RefTree)((Object)x6$1);
                        Names.Name name2 = x6$1.symbol().name();
                        Names.Name name3 = refTree.name();
                        if (name2 == null ? name3 != null : !name2.equals(name3)) {
                            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"[", x6$1.symbol(), " aka ", refTree.name(), "]"}));
                            return;
                        }
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x6$1.symbol()}));
                        return;
                    }
                    if (x6$1 instanceof Trees.DefTree) {
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x6$1.symbol()}));
                        return;
                    }
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x6$1.symbol().name()}));
                    return;
                }
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{name}));
                return;
            }
            if (x0$2 instanceof Constants.Constant && ((Constants.Constant)x0$2).scala$reflect$internal$Constants$Constant$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                bl = true;
                constant = (Constants.Constant)x0$2;
                Object s = constant.value();
                if (s instanceof String) {
                    String string = (String)s;
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(12).append("Constant(\"").append(string).append("\")").toString()}));
                    return;
                }
            }
            if (bl && constant.value() == null) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"Constant(null)"}));
                return;
            }
            if (bl) {
                Object value = constant.value();
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(10).append("Constant(").append(value).append(")").toString()}));
                return;
            }
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x0$2}));
        }

        public static final /* synthetic */ void $anonfun$print$6(RawTreePrinter $this, Product x0$3) {
            Trees.TypeTree typeTree;
            if (x0$3 instanceof Trees.TypeTree && ((Trees.TypeTree)x0$3).scala$reflect$internal$Trees$TypeTree$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer() && (typeTree = (Trees.TypeTree)x0$3).original() != null) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{".setOriginal(", typeTree.original(), ")"}));
                return;
            }
        }

        public static final /* synthetic */ void $anonfun$print$3(RawTreePrinter $this, Object x0$1) {
            block31: {
                block32: {
                    Trees.Modifiers modifiers;
                    block34: {
                        block33: {
                            block30: {
                                Symbols.Symbol symbol;
                                if (x0$1 instanceof Exprs.Expr && ((Exprs.Expr)x0$1).scala$reflect$api$Exprs$Expr$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                                    Exprs.Expr expr = (Exprs.Expr)x0$1;
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"Expr"}));
                                    if ($this.printTypes()) {
                                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{expr.staticType()}));
                                    }
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"("}));
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{expr.tree()}));
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{")"}));
                                    return;
                                }
                                if (((Object)$this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().EmptyTree()).equals(x0$1)) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"EmptyTree"}));
                                    return;
                                }
                                if (((Object)$this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().noSelfType()).equals(x0$1)) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"noSelfType"}));
                                    return;
                                }
                                if (((Object)$this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().pendingSuperCall()).equals(x0$1)) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"pendingSuperCall"}));
                                    return;
                                }
                                if (x0$1 instanceof Trees.Tree && ((Trees.Tree)x0$1).scala$reflect$internal$Trees$Tree$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                                    Trees.Tree tree = (Trees.Tree)x0$1;
                                    boolean isError = $this.hasSymbolField$1(tree) && tree.symbol().name().string_$eq$eq($this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().nme().ERROR());
                                    $this.printProduct(tree, (Function1<Product, BoxedUnit>)(Function1<Product, Object> & java.io.Serializable & Serializable)x$33 -> {
                                        RawTreePrinter.$anonfun$print$4($this, tree, x$33);
                                        return BoxedUnit.UNIT;
                                    }, (Function1<Object, BoxedUnit>)(Function1<Object, Object> & java.io.Serializable & Serializable)x0$2 -> {
                                        RawTreePrinter.$anonfun$print$5($this, isError, tree, x0$2);
                                        return BoxedUnit.UNIT;
                                    }, (Function1<Product, BoxedUnit>)(Function1<Product, Object> & java.io.Serializable & Serializable)x0$3 -> {
                                        RawTreePrinter.$anonfun$print$6($this, x0$3);
                                        return BoxedUnit.UNIT;
                                    });
                                    return;
                                }
                                if (!(x0$1 instanceof Symbols.Symbol) || ((Symbols.Symbol)x0$1).scala$reflect$internal$Symbols$Symbol$$$outer() != $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) break block30;
                                Symbols.Symbol symbol2 = symbol = (Symbols.Symbol)x0$1;
                                Symbols.NoSymbol noSymbol = $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().NoSymbol();
                                if (!(symbol2 != null ? !symbol2.equals(noSymbol) : noSymbol != null)) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"NoSymbol"}));
                                } else if (symbol.isStatic() && (symbol.isClass() || symbol.isModule())) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{symbol.fullName()}));
                                } else {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{symbol.name()}));
                                }
                                if ($this.printIds()) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"#", BoxesRunTime.boxToInteger(symbol.id())}));
                                }
                                if ($this.printOwners()) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"@", BoxesRunTime.boxToInteger(symbol.owner().id())}));
                                }
                                if ($this.printKinds()) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"#", symbol.abbreviatedKindString()}));
                                }
                                if ($this.printMirrors()) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"%M", BoxesRunTime.boxToInteger($this.footnotes().put($this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().mirrorThatLoaded(symbol), ClassTag$.MODULE$.apply(Mirror.class)))}));
                                    return;
                                }
                                break block31;
                            }
                            if (x0$1 instanceof TypeTags.TypeTag && ((TypeTags.TypeTag)x0$1).scala$reflect$api$TypeTags$TypeTag$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                                TypeTags.TypeTag typeTag = (TypeTags.TypeTag)x0$1;
                                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"TypeTag(", typeTag.tpe(), ")"}));
                                return;
                            }
                            if (x0$1 instanceof TypeTags.WeakTypeTag && ((TypeTags.WeakTypeTag)x0$1).scala$reflect$api$TypeTags$WeakTypeTag$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                                TypeTags.WeakTypeTag weakTypeTag = (TypeTags.WeakTypeTag)x0$1;
                                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"WeakTypeTag(", weakTypeTag.tpe(), ")"}));
                                return;
                            }
                            if (x0$1 instanceof Types.Type && ((Types.Type)x0$1).scala$reflect$internal$Types$Type$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                                Types.Type type = (Types.Type)x0$1;
                                if ($this.printTypesInFootnotes() && !$this.printingFootnotes()) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"[", BoxesRunTime.boxToInteger($this.footnotes().put(type, $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().TypeTagg())), "]"}));
                                    return;
                                }
                                if ($this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().NoType().equals(type)) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"NoType"}));
                                    return;
                                }
                                if ($this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().NoPrefix().equals(type)) {
                                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"NoPrefix"}));
                                    return;
                                }
                                $this.printProduct((Product)((Object)type), $this.printProduct$default$2(), $this.printProduct$default$3(), $this.printProduct$default$4());
                                return;
                            }
                            if (!(x0$1 instanceof Trees.Modifiers) || ((Trees.Modifiers)x0$1).scala$reflect$internal$Trees$Modifiers$$$outer() != $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) break block32;
                            modifiers = (Trees.Modifiers)x0$1;
                            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"Modifiers("}));
                            if (modifiers.flags() != $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().NoFlags()) break block33;
                            Names.Name name = modifiers.privateWithin();
                            Names.Name name2 = $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().tpnme().EMPTY();
                            if (!(name != null ? !name.equals(name2) : name2 != null) && !modifiers.annotations().nonEmpty()) break block34;
                        }
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{$this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().show(modifiers.flags())}));
                    }
                    Names.Name name = modifiers.privateWithin();
                    Names.Name name3 = $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().tpnme().EMPTY();
                    if ((name != null ? !name.equals(name3) : name3 != null) || modifiers.annotations().nonEmpty()) {
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{", "}));
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{modifiers.privateWithin()}));
                    }
                    if (modifiers.annotations().nonEmpty()) {
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{", "}));
                        $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{modifiers.annotations()}));
                    }
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{")"}));
                    return;
                }
                if (x0$1 instanceof Names.Name && ((Names.Name)x0$1).scala$reflect$internal$Names$Name$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                    Names.Name name = (Names.Name)x0$1;
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{$this.scala$reflect$internal$Printers$RawTreePrinter$$$outer().show(name)}));
                    return;
                }
                if (x0$1 instanceof Scopes.Scope && ((Scopes.Scope)x0$1).scala$reflect$internal$Scopes$Scope$$$outer() == $this.scala$reflect$internal$Printers$RawTreePrinter$$$outer()) {
                    Scopes.Scope scope = (Scopes.Scope)x0$1;
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"Scope"}));
                    $this.printIterable(scope.toList(), (JFunction0$mcV$sp & Serializable)() -> $this.printIterable$default$2(), $this.printIterable$default$3(), (JFunction0$mcV$sp & Serializable)() -> $this.printIterable$default$4());
                    return;
                }
                if (x0$1 instanceof List) {
                    List list = (List)x0$1;
                    $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"List"}));
                    $this.printIterable(list, (JFunction0$mcV$sp & Serializable)() -> $this.printIterable$default$2(), $this.printIterable$default$3(), (JFunction0$mcV$sp & Serializable)() -> $this.printIterable$default$4());
                    return;
                }
                if (x0$1 instanceof Product) {
                    Product product = (Product)x0$1;
                    $this.printProduct(product, $this.printProduct$default$2(), $this.printProduct$default$3(), $this.printProduct$default$4());
                    return;
                }
                $this.out.print(x0$1);
            }
        }

        public RawTreePrinter(SymbolTable $outer, PrintWriter out) {
            this.out = out;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Printers.TreePrinter.$init$(this);
            this.depth = 0;
            this.printTypesInFootnotes = true;
            this.printingFootnotes = false;
            this.footnotes = new Footnotes($outer);
        }
    }

    public class TreePrinter
    implements Printers.TreePrinter {
        private final PrintWriter out;
        private int indentMargin;
        private final int indentStep;
        private String indentString;
        private final boolean commentsRequired;
        private Symbols.Symbol currentOwner;
        private Types.Type selectorType;
        private boolean printTypes;
        private boolean printIds;
        private boolean printOwners;
        private boolean printKinds;
        private boolean printMirrors;
        private boolean printPositions;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public Printers.TreePrinter withTypes() {
            return Printers.TreePrinter.withTypes$(this);
        }

        @Override
        public Printers.TreePrinter withoutTypes() {
            return Printers.TreePrinter.withoutTypes$(this);
        }

        @Override
        public Printers.TreePrinter withIds() {
            return Printers.TreePrinter.withIds$(this);
        }

        @Override
        public Printers.TreePrinter withoutIds() {
            return Printers.TreePrinter.withoutIds$(this);
        }

        @Override
        public Printers.TreePrinter withOwners() {
            return Printers.TreePrinter.withOwners$(this);
        }

        @Override
        public Printers.TreePrinter withoutOwners() {
            return Printers.TreePrinter.withoutOwners$(this);
        }

        @Override
        public Printers.TreePrinter withKinds() {
            return Printers.TreePrinter.withKinds$(this);
        }

        @Override
        public Printers.TreePrinter withoutKinds() {
            return Printers.TreePrinter.withoutKinds$(this);
        }

        @Override
        public Printers.TreePrinter withMirrors() {
            return Printers.TreePrinter.withMirrors$(this);
        }

        @Override
        public Printers.TreePrinter withoutMirrors() {
            return Printers.TreePrinter.withoutMirrors$(this);
        }

        @Override
        public Printers.TreePrinter withPositions() {
            return Printers.TreePrinter.withPositions$(this);
        }

        @Override
        public Printers.TreePrinter withoutPositions() {
            return Printers.TreePrinter.withoutPositions$(this);
        }

        @Override
        public boolean printTypes() {
            return this.printTypes;
        }

        @Override
        public void printTypes_$eq(boolean x$1) {
            this.printTypes = x$1;
        }

        @Override
        public boolean printIds() {
            return this.printIds;
        }

        @Override
        public void printIds_$eq(boolean x$1) {
            this.printIds = x$1;
        }

        @Override
        public boolean printOwners() {
            return this.printOwners;
        }

        @Override
        public void printOwners_$eq(boolean x$1) {
            this.printOwners = x$1;
        }

        @Override
        public boolean printKinds() {
            return this.printKinds;
        }

        @Override
        public void printKinds_$eq(boolean x$1) {
            this.printKinds = x$1;
        }

        @Override
        public boolean printMirrors() {
            return this.printMirrors;
        }

        @Override
        public void printMirrors_$eq(boolean x$1) {
            this.printMirrors = x$1;
        }

        @Override
        public boolean printPositions() {
            return this.printPositions;
        }

        @Override
        public void printPositions_$eq(boolean x$1) {
            this.printPositions = x$1;
        }

        public int indentMargin() {
            return this.indentMargin;
        }

        public void indentMargin_$eq(int x$1) {
            this.indentMargin = x$1;
        }

        public int indentStep() {
            return this.indentStep;
        }

        public String indentString() {
            return this.indentString;
        }

        public void indentString_$eq(String x$1) {
            this.indentString = x$1;
        }

        public void indent() {
            this.indentMargin_$eq(this.indentMargin() + this.indentStep());
        }

        public void undent() {
            this.indentMargin_$eq(this.indentMargin() - this.indentStep());
        }

        public void printPosition(Trees.Tree tree) {
            if (this.printPositions()) {
                this.comment((JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree.pos().show()})));
            }
        }

        public void printTypesInfo(Trees.Tree tree) {
            if (this.printTypes() && tree.isTerm() && tree.canHaveAttrs()) {
                this.comment((JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"{", tree.tpe() == null ? "<null>" : tree.tpe().toString(), "}"})));
            }
        }

        public void println() {
            this.out.println();
            while (this.indentMargin() > this.indentString().length()) {
                this.indentString_$eq(new StringBuilder(0).append(this.indentString()).append(this.indentString()).toString());
            }
            if (this.indentMargin() > 0) {
                this.out.write(this.indentString(), 0, this.indentMargin());
            }
        }

        public <a> void printSeq(List<a> ls, Function1<a, BoxedUnit> printelem, Function0<BoxedUnit> printsep) {
            Some<List<a>> some = List$.MODULE$.unapplySeq(ls);
            if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
                return;
            }
            Some<List<a>> some2 = List$.MODULE$.unapplySeq(ls);
            if (!some2.isEmpty() && some2.get() != null && ((LinearSeqOptimized)some2.get()).lengthCompare(1) == 0) {
                Object x = ((LinearSeqOptimized)some2.get()).apply(0);
                printelem.apply(x);
                return;
            }
            if (ls instanceof $colon$colon) {
                $colon$colon $colon$colon = ($colon$colon)ls;
                Object x = $colon$colon.head();
                List rest = $colon$colon.tl$access$1();
                printelem.apply(x);
                printsep.apply$mcV$sp();
                this.printSeq(rest, printelem, printsep);
                return;
            }
            throw new MatchError(ls);
        }

        public void printColumn(List<Trees.Tree> ts, String start, String sep, String end) {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{start}));
            this.indent();
            this.println();
            this.printSeq(ts, (Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x$1 -> {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x$1}));
                return BoxedUnit.UNIT;
            }, (JFunction0$mcV$sp & Serializable)() -> {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{sep}));
                this.println();
            });
            this.undent();
            this.println();
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{end}));
        }

        public void printRow(List<Trees.Tree> ts, String start, String sep, String end) {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{start}));
            this.printSeq(ts, (Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x$2 -> {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x$2}));
                return BoxedUnit.UNIT;
            }, (JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{sep})));
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{end}));
        }

        public void printRow(List<Trees.Tree> ts, String sep) {
            this.printRow(ts, "", sep, "");
        }

        public void printTypeParams(List<Trees.TypeDef> ts) {
            if (ts.nonEmpty()) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"["}));
                this.printSeq(ts, (Function1<Trees.TypeDef, Object> & java.io.Serializable & Serializable)t -> {
                    TreePrinter.$anonfun$printTypeParams$1(this, t);
                    return BoxedUnit.UNIT;
                }, (JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{", "})));
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"]"}));
            }
        }

        public void printLabelParams(List<Trees.Ident> ps) {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"("}));
            this.printSeq(ps, (Function1<Trees.Ident, Object> & java.io.Serializable & Serializable)p -> {
                this.printLabelParam(p);
                return BoxedUnit.UNIT;
            }, (JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{", "})));
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{")"}));
        }

        public void printLabelParam(Trees.Ident p) {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(p, p.name())}));
            this.printOpt(": ", new Trees.TypeTree(this.scala$reflect$internal$Printers$TreePrinter$$$outer()).setType(p.tpe()));
        }

        public void parenthesize(boolean condition, String open, String close, Function0<BoxedUnit> body) {
            if (condition) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{open}));
            }
            body.apply$mcV$sp();
            if (condition) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{close}));
            }
        }

        public boolean parenthesize$default$1() {
            return true;
        }

        public String parenthesize$default$2() {
            return "(";
        }

        public String parenthesize$default$3() {
            return ")";
        }

        public boolean commentsRequired() {
            return this.commentsRequired;
        }

        public void comment(Function0<BoxedUnit> body) {
            this.parenthesize(this.commentsRequired(), "/*", "*/", body);
        }

        public void printImplicitInParamsList(List<Trees.ValDef> vds) {
            if (vds.nonEmpty()) {
                this.printFlags(vds.head().mods().flags() & 0x200L, "");
            }
        }

        public void printValueParams(List<Trees.ValDef> ts, boolean inParentheses) {
            this.parenthesize(inParentheses, this.parenthesize$default$2(), this.parenthesize$default$3(), (JFunction0$mcV$sp & Serializable)() -> {
                this.printImplicitInParamsList(ts);
                this.printSeq(ts, (Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)tree -> {
                    this.printParam(tree);
                    return BoxedUnit.UNIT;
                }, (JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{", "})));
            });
        }

        public void printParam(Trees.Tree tree) {
            if (tree instanceof Trees.ValDef) {
                Trees.ValDef valDef = (Trees.ValDef)tree;
                Names.TermName name = valDef.name();
                Trees.Tree tp = valDef.tpt();
                Trees.Tree rhs = valDef.rhs();
                this.printPosition(tree);
                this.printAnnotations(valDef);
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name)}));
                this.printOpt(": ", tp);
                this.printOpt(" = ", rhs);
                return;
            }
            if (tree instanceof Trees.TypeDef) {
                Trees.TypeDef typeDef = (Trees.TypeDef)tree;
                Names.TypeName name = typeDef.name();
                List<Trees.TypeDef> tparams = typeDef.tparams();
                Trees.Tree rhs = typeDef.rhs();
                this.printPosition(tree);
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name)}));
                this.printTypeParams(tparams);
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{rhs}));
                return;
            }
            throw new MatchError(tree);
        }

        public void printBlock(Trees.Tree tree) {
            if (tree instanceof Trees.Block) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree}));
                return;
            }
            this.printColumn(new $colon$colon<Nothing$>((Nothing$)((Object)tree), Nil$.MODULE$), "{", ";", "}");
        }

        private <T> T symFn(Trees.Tree tree, Function1<Symbols.Symbol, T> f, Function0<T> orElse) {
            boolean bl;
            Symbols.Symbol symbol = tree.symbol();
            if (symbol == null) {
                bl = true;
            } else {
                Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Printers$TreePrinter$$$outer().NoSymbol();
                bl = noSymbol != null && noSymbol.equals(symbol);
            }
            T t = bl ? orElse.apply() : f.apply(symbol);
            return t;
        }

        private boolean ifSym(Trees.Tree tree, Function1<Symbols.Symbol, Object> p) {
            boolean bl;
            Symbols.Symbol symbol = tree.symbol();
            if (symbol == null) {
                bl = true;
            } else {
                Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Printers$TreePrinter$$$outer().NoSymbol();
                bl = noSymbol != null && noSymbol.equals(symbol);
            }
            Object object = bl ? BoxesRunTime.boxToBoolean(TreePrinter.$anonfun$ifSym$1()) : p.apply(symbol);
            return BoxesRunTime.unboxToBoolean(object);
        }

        public void printOpt(String prefix, Trees.Tree tree) {
            if (tree.nonEmpty()) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{prefix, tree}));
            }
        }

        public void printModifiers(Trees.Tree tree, Trees.Modifiers mods) {
            Symbols.Symbol symbol = tree.symbol();
            Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Printers$TreePrinter$$$outer().NoSymbol();
            Symbols.Symbol symbol2 = tree.symbol();
            Symbols.NoSymbol noSymbol2 = this.scala$reflect$internal$Printers$TreePrinter$$$outer().NoSymbol();
            this.printFlags(!(symbol != null ? !symbol.equals(noSymbol) : noSymbol != null) ? mods.flags() : tree.symbol().flags(), String.valueOf(!(symbol2 != null ? !symbol2.equals(noSymbol2) : noSymbol2 != null) ? mods.privateWithin() : (tree.symbol().hasAccessBoundary() ? tree.symbol().privateWithin().name() : "")));
        }

        /*
         * WARNING - void declaration
         */
        public void printFlags(long flags, String privateWithin) {
            String s;
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$Printers$TreePrinter$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            long mask = BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) ? -1L : 577838443559423535L;
            String string = s = Flags$.MODULE$.flagsToString(flags & mask, privateWithin);
            String string2 = "";
            if (string == null || !string.equals(string2)) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append(s).append(" ").toString()}));
            }
        }

        public void printAnnotations(Trees.MemberDef tree) {
            List<AnnotationInfos.AnnotationInfo> list = tree.symbol().annotations();
            List<Object> list2 = ((Object)Nil$.MODULE$).equals(list) ? tree.mods().annotations() : list;
            if (list2 == null) {
                throw null;
            }
            List<Object> foreach_these = list2;
            while (!foreach_these.isEmpty()) {
                Object object = foreach_these.head();
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(2).append("@").append(object).append(" ").toString()}));
                foreach_these = (List)foreach_these.tail();
            }
        }

        private Symbols.Symbol currentOwner() {
            return this.currentOwner;
        }

        private void currentOwner_$eq(Symbols.Symbol x$1) {
            this.currentOwner = x$1;
        }

        private Types.Type selectorType() {
            return this.selectorType;
        }

        private void selectorType_$eq(Types.Type x$1) {
            this.selectorType = x$1;
        }

        /*
         * WARNING - void declaration
         */
        public void printPackageDef(Trees.PackageDef tree, String separator) {
            void var4_4;
            void var3_3;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            Trees.RefTree packaged = tree.pid();
            List<Trees.Tree> stats = tree.stats();
            void packaged2 = var3_3;
            void stats2 = var4_4;
            this.printAnnotations(tree);
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"package ", packaged2}));
            this.printColumn((List<Trees.Tree>)stats2, " {", separator, "}");
        }

        /*
         * WARNING - void declaration
         */
        public void printValDef(Trees.ValDef tree, Function0<String> resultName, Function0<BoxedUnit> printTypeSignature, Function0<BoxedUnit> printRhs) {
            void var5_5;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            Trees.Modifiers mods = tree.mods();
            tree.name();
            tree.tpt();
            tree.rhs();
            void mods2 = var5_5;
            this.printAnnotations(tree);
            this.printModifiers(tree, (Trees.Modifiers)mods2);
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{mods2.isMutable() ? "var " : "val ", resultName.apply()}));
            printTypeSignature.apply$mcV$sp();
            printRhs.apply$mcV$sp();
        }

        /*
         * WARNING - void declaration
         */
        public void printDefDef(Trees.DefDef tree, Function0<String> resultName, Function0<BoxedUnit> printTypeSignature, Function0<BoxedUnit> printRhs) {
            void var7_7;
            void var6_6;
            void var5_5;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            Trees.Modifiers mods = tree.mods();
            tree.name();
            List<Trees.TypeDef> tparams = tree.tparams();
            List<List<Trees.ValDef>> vparamss = tree.vparamss();
            tree.tpt();
            tree.rhs();
            void mods2 = var5_5;
            void tparams2 = var6_6;
            void vparamss2 = var7_7;
            this.printAnnotations(tree);
            this.printModifiers(tree, (Trees.Modifiers)mods2);
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(4).append("def ").append((Object)resultName.apply()).toString()}));
            this.printTypeParams((List<Trees.TypeDef>)tparams2);
            if (vparamss2 == null) {
                throw null;
            }
            List foreach_these = vparamss2;
            while (!foreach_these.isEmpty()) {
                List list = (List)foreach_these.head();
                this.printValueParams(list, this.printValueParams$default$2());
                foreach_these = (List)foreach_these.tail();
            }
            printTypeSignature.apply$mcV$sp();
            printRhs.apply$mcV$sp();
        }

        /*
         * WARNING - void declaration
         */
        public void printTypeDef(Trees.TypeDef tree, Function0<String> resultName) {
            void var5_5;
            void var4_4;
            void var3_3;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            Trees.Modifiers mods = tree.mods();
            tree.name();
            List<Trees.TypeDef> tparams = tree.tparams();
            Trees.Tree rhs = tree.rhs();
            void mods2 = var3_3;
            void tparams2 = var4_4;
            void rhs2 = var5_5;
            if (mods2.hasFlag(8208L)) {
                this.printAnnotations(tree);
                this.printModifiers(tree, (Trees.Modifiers)mods2);
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"type "}));
                this.printParam(tree);
                return;
            }
            this.printAnnotations(tree);
            this.printModifiers(tree, (Trees.Modifiers)mods2);
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(5).append("type ").append((Object)resultName.apply()).toString()}));
            this.printTypeParams((List<Trees.TypeDef>)tparams2);
            this.printOpt(" = ", (Trees.Tree)rhs2);
        }

        /*
         * WARNING - void declaration
         */
        public void printImport(Trees.Import tree, Function0<String> resSelect) {
            void var3_3;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            tree.expr();
            List<Trees.ImportSelector> selectors = tree.selectors();
            void selectors2 = var3_3;
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"import ", resSelect.apply(), "."}));
            Some<void> some = List$.MODULE$.unapplySeq(selectors2);
            if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0) {
                Trees.ImportSelector s2 = (Trees.ImportSelector)((LinearSeqOptimized)some.get()).apply(0);
                if (this.isNotRename$1(s2)) {
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.selectorToString$1(s2)}));
                    return;
                }
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"{", this.selectorToString$1(s2), "}"}));
                return;
            }
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{((TraversableOnce)selectors2.map((Function1<Trees.ImportSelector, String> & java.io.Serializable & Serializable)s -> this.selectorToString$1((Trees.ImportSelector)s), List$.MODULE$.canBuildFrom())).mkString("{", ", ", "}")}));
        }

        /*
         * WARNING - void declaration
         */
        public void printCaseDef(Trees.CaseDef tree) {
            void var4_4;
            void var3_3;
            void var2_2;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            Trees.Tree pat = tree.pat();
            Trees.Tree guard = tree.guard();
            Trees.Tree body = tree.body();
            void pat2 = var2_2;
            void guard2 = var3_3;
            void body2 = var4_4;
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"case "}));
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{pat2}));
            this.printOpt(" if ", (Trees.Tree)guard2);
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" => ", body2}));
        }

        /*
         * WARNING - void declaration
         */
        public void printFunction(Trees.Function tree, Function0<BoxedUnit> printValueParams) {
            void var3_3;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            tree.vparams();
            Trees.Tree body = tree.body();
            void body2 = var3_3;
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"("}));
            printValueParams.apply$mcV$sp();
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" => ", body2, ")"}));
            if (this.printIds() && tree.symbol() != null) {
                this.comment((JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append("#").append(tree.symbol().id()).toString()})));
            }
            if (this.printOwners() && tree.symbol() != null) {
                this.comment((JFunction0$mcV$sp & Serializable)() -> this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append("@").append(tree.symbol().owner().id()).toString()})));
            }
        }

        /*
         * WARNING - void declaration
         */
        public void printSuper(Trees.Super tree, Function0<String> resultName, boolean checkSymbol) {
            void mix;
            block10: {
                block9: {
                    void var5_5;
                    void var6_6;
                    Trees.Tree tree2;
                    block8: {
                        block7: {
                            if (tree == null) break block7;
                            tree2 = tree.qual();
                            Names.TypeName mix2 = tree.mix();
                            if (tree2 instanceof Trees.This) break block8;
                        }
                        throw new MatchError(tree);
                    }
                    Names.TypeName qual = ((Trees.This)tree2).qual();
                    void qual2 = var6_6;
                    mix = var5_5;
                    if (qual2.nonEmpty()) break block9;
                    if (!checkSymbol) break block10;
                    Symbols.Symbol symbol = tree.symbol();
                    Symbols.NoSymbol noSymbol = this.scala$reflect$internal$Printers$TreePrinter$$$outer().NoSymbol();
                    if (!(symbol == null ? noSymbol != null : !symbol.equals(noSymbol))) break block10;
                }
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append(resultName.apply()).append(".").toString()}));
            }
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"super"}));
            if (mix.nonEmpty()) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(2).append("[").append((CharSequence)mix).append("]").toString()}));
            }
        }

        /*
         * WARNING - void declaration
         */
        public void printThis(Trees.This tree, Function0<String> resultName) {
            void var3_3;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            Names.TypeName qual = tree.qual();
            if (var3_3.nonEmpty()) {
                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(1).append(resultName.apply()).append(".").toString()}));
            }
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"this"}));
        }

        public void printBlock(List<Trees.Tree> stats, Trees.Tree expr) {
            this.printColumn(new $colon$colon<Nothing$>((Nothing$)((Object)expr), Nil$.MODULE$).$colon$colon$colon(stats), "{", ";", "}");
        }

        /*
         * Unable to fully structure code
         */
        public void printTree(Trees.Tree tree) {
            block37: {
                block74: {
                    block73: {
                        block72: {
                            block71: {
                                block70: {
                                    block69: {
                                        block68: {
                                            block67: {
                                                block66: {
                                                    block65: {
                                                        block64: {
                                                            block63: {
                                                                block62: {
                                                                    block61: {
                                                                        block60: {
                                                                            block59: {
                                                                                block58: {
                                                                                    block57: {
                                                                                        block56: {
                                                                                            block55: {
                                                                                                block54: {
                                                                                                    block53: {
                                                                                                        block52: {
                                                                                                            block51: {
                                                                                                                block50: {
                                                                                                                    block49: {
                                                                                                                        block48: {
                                                                                                                            block47: {
                                                                                                                                block46: {
                                                                                                                                    block45: {
                                                                                                                                        block44: {
                                                                                                                                            block43: {
                                                                                                                                                block42: {
                                                                                                                                                    block41: {
                                                                                                                                                        block40: {
                                                                                                                                                            block39: {
                                                                                                                                                                block38: {
                                                                                                                                                                    block36: {
                                                                                                                                                                        var2_2 = false;
                                                                                                                                                                        var3_3 = null;
                                                                                                                                                                        var4_4 = false;
                                                                                                                                                                        var5_5 = null;
                                                                                                                                                                        if (!this.scala$reflect$internal$Printers$TreePrinter$$$outer().EmptyTree().equals(tree)) break block36;
                                                                                                                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"<empty>"}));
                                                                                                                                                                        break block37;
                                                                                                                                                                    }
                                                                                                                                                                    if (!(tree instanceof Trees.ClassDef)) break block38;
                                                                                                                                                                    var6_6 = (Trees.ClassDef)tree;
                                                                                                                                                                    mods = var6_6.mods();
                                                                                                                                                                    name = var6_6.name();
                                                                                                                                                                    tparams = var6_6.tparams();
                                                                                                                                                                    impl = var6_6.impl();
                                                                                                                                                                    this.printAnnotations(var6_6);
                                                                                                                                                                    this.printModifiers(tree, mods);
                                                                                                                                                                    if (mods.isTrait()) {
                                                                                                                                                                        v0 = "trait";
                                                                                                                                                                    } else {
                                                                                                                                                                        var133_11 = tree.symbol();
                                                                                                                                                                        if (var133_11 == null) {
                                                                                                                                                                            var132_12 = true;
                                                                                                                                                                        } else {
                                                                                                                                                                            v1 = this.scala$reflect$internal$Printers$TreePrinter$$$outer().NoSymbol();
                                                                                                                                                                            var132_12 = v1 != null && v1.equals(var133_11) != false;
                                                                                                                                                                        }
                                                                                                                                                                        var131_13 = var132_12 != false ? TreePrinter.$anonfun$ifSym$1() : TreePrinter.$anonfun$printTree$1(var133_11);
                                                                                                                                                                        v0 = var131_13 != false ? "object" : "class";
                                                                                                                                                                    }
                                                                                                                                                                    word = v0;
                                                                                                                                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{word, " ", this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name)}));
                                                                                                                                                                    this.printTypeParams(tparams);
                                                                                                                                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{mods.isDeferred() != false ? " <: " : " extends ", impl}));
                                                                                                                                                                    break block37;
                                                                                                                                                                }
                                                                                                                                                                if (!(tree instanceof Trees.PackageDef)) break block39;
                                                                                                                                                                var12_15 = (Trees.PackageDef)tree;
                                                                                                                                                                this.printPackageDef(var12_15, ";");
                                                                                                                                                                break block37;
                                                                                                                                                            }
                                                                                                                                                            if (!(tree instanceof Trees.ModuleDef)) break block40;
                                                                                                                                                            var13_16 = (Trees.ModuleDef)tree;
                                                                                                                                                            mods = var13_16.mods();
                                                                                                                                                            name = var13_16.name();
                                                                                                                                                            impl = var13_16.impl();
                                                                                                                                                            this.printAnnotations(var13_16);
                                                                                                                                                            this.printModifiers(tree, mods);
                                                                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(7).append("object ").append(this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name)).toString(), " extends ", impl}));
                                                                                                                                                            break block37;
                                                                                                                                                        }
                                                                                                                                                        if (!(tree instanceof Trees.ValDef)) break block41;
                                                                                                                                                        var17_20 = (Trees.ValDef)tree;
                                                                                                                                                        mods = var17_20.mods();
                                                                                                                                                        name = var17_20.name();
                                                                                                                                                        tp = var17_20.tpt();
                                                                                                                                                        rhs = var17_20.rhs();
                                                                                                                                                        this.printValDef(var17_20, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$printTree$2(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree scala.reflect.internal.Names$TermName ), ()Ljava/lang/String;)((TreePrinter)this, (Trees.Tree)tree, (Names.TermName)name), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$printTree$3(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree ), ()V)((TreePrinter)this, (Trees.Tree)tp), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$printTree$4(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Modifiers scala.reflect.internal.Trees$Tree ), ()V)((TreePrinter)this, (Trees.Modifiers)mods, (Trees.Tree)rhs));
                                                                                                                                                        break block37;
                                                                                                                                                    }
                                                                                                                                                    if (!(tree instanceof Trees.DefDef)) break block42;
                                                                                                                                                    var22_25 = (Trees.DefDef)tree;
                                                                                                                                                    name = var22_25.name();
                                                                                                                                                    tp = var22_25.tpt();
                                                                                                                                                    rhs = var22_25.rhs();
                                                                                                                                                    this.printDefDef(var22_25, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$printTree$5(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree scala.reflect.internal.Names$TermName ), ()Ljava/lang/String;)((TreePrinter)this, (Trees.Tree)tree, (Names.TermName)name), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$printTree$6(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree ), ()V)((TreePrinter)this, (Trees.Tree)tp), (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$printTree$7(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree ), ()V)((TreePrinter)this, (Trees.Tree)rhs));
                                                                                                                                                    break block37;
                                                                                                                                                }
                                                                                                                                                if (!(tree instanceof Trees.TypeDef)) break block43;
                                                                                                                                                var26_29 = (Trees.TypeDef)tree;
                                                                                                                                                name = var26_29.name();
                                                                                                                                                this.printTypeDef(var26_29, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$printTree$8(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree scala.reflect.internal.Names$TypeName ), ()Ljava/lang/String;)((TreePrinter)this, (Trees.Tree)tree, (Names.TypeName)name));
                                                                                                                                                break block37;
                                                                                                                                            }
                                                                                                                                            if (!(tree instanceof Trees.LabelDef)) break block44;
                                                                                                                                            var28_31 = (Trees.LabelDef)tree;
                                                                                                                                            name = var28_31.name();
                                                                                                                                            params = var28_31.params();
                                                                                                                                            rhs = var28_31.rhs();
                                                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name)}));
                                                                                                                                            this.printLabelParams(params);
                                                                                                                                            this.printBlock(rhs);
                                                                                                                                            break block37;
                                                                                                                                        }
                                                                                                                                        if (!(tree instanceof Trees.Import)) break block45;
                                                                                                                                        var32_35 = (Trees.Import)tree;
                                                                                                                                        expr = var32_35.expr();
                                                                                                                                        this.printImport(var32_35, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$printTree$9(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree ), ()Ljava/lang/String;)((TreePrinter)this, (Trees.Tree)expr));
                                                                                                                                        break block37;
                                                                                                                                    }
                                                                                                                                    if (!(tree instanceof Trees.Template)) break block46;
                                                                                                                                    var34_37 = (Trees.Template)tree;
                                                                                                                                    parents = var34_37.parents();
                                                                                                                                    self = var34_37.self();
                                                                                                                                    body = var34_37.body();
                                                                                                                                    currentOwner1 = this.currentOwner();
                                                                                                                                    v2 = tree.symbol();
                                                                                                                                    var39_42 = this.scala$reflect$internal$Printers$TreePrinter$$$outer().NoSymbol();
                                                                                                                                    if (v2 == null ? var39_42 != null : v2.equals(var39_42) == false) {
                                                                                                                                        this.currentOwner_$eq(tree.symbol().owner());
                                                                                                                                    }
                                                                                                                                    this.printRow(parents, " with ");
                                                                                                                                    if (body.nonEmpty()) {
                                                                                                                                        v3 = self.name();
                                                                                                                                        var40_43 = this.scala$reflect$internal$Printers$TreePrinter$$$outer().nme().WILDCARD();
                                                                                                                                        if (v3 == null ? var40_43 != null : v3.equals(var40_43) == false) {
                                                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" { ", self.name()}));
                                                                                                                                            this.printOpt(": ", self.tpt());
                                                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" => "}));
                                                                                                                                        } else if (self.tpt().nonEmpty()) {
                                                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" { _ : ", self.tpt(), " => "}));
                                                                                                                                        } else {
                                                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" {"}));
                                                                                                                                        }
                                                                                                                                        this.printColumn(body, "", ";", "}");
                                                                                                                                    }
                                                                                                                                    this.currentOwner_$eq(currentOwner1);
                                                                                                                                    break block37;
                                                                                                                                }
                                                                                                                                if (!(tree instanceof Trees.Block)) break block47;
                                                                                                                                var41_44 = (Trees.Block)tree;
                                                                                                                                stats = var41_44.stats();
                                                                                                                                expr = var41_44.expr();
                                                                                                                                this.printBlock(stats, expr);
                                                                                                                                break block37;
                                                                                                                            }
                                                                                                                            if (!(tree instanceof Trees.Match)) break block48;
                                                                                                                            var44_47 = (Trees.Match)tree;
                                                                                                                            selector = var44_47.selector();
                                                                                                                            cases = var44_47.cases();
                                                                                                                            selectorType1 = this.selectorType();
                                                                                                                            this.selectorType_$eq(selector.tpe());
                                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{selector}));
                                                                                                                            this.printColumn(cases, " match {", "", "}");
                                                                                                                            this.selectorType_$eq(selectorType1);
                                                                                                                            break block37;
                                                                                                                        }
                                                                                                                        if (!(tree instanceof Trees.CaseDef)) break block49;
                                                                                                                        var48_51 = (Trees.CaseDef)tree;
                                                                                                                        this.printCaseDef(var48_51);
                                                                                                                        break block37;
                                                                                                                    }
                                                                                                                    if (!(tree instanceof Trees.Alternative)) break block50;
                                                                                                                    trees = ((Trees.Alternative)tree).trees();
                                                                                                                    this.printRow(trees, "(", "| ", ")");
                                                                                                                    break block37;
                                                                                                                }
                                                                                                                if (!(tree instanceof Trees.Star)) break block51;
                                                                                                                elem = ((Trees.Star)tree).elem();
                                                                                                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", elem, ")*"}));
                                                                                                                break block37;
                                                                                                            }
                                                                                                            if (!(tree instanceof Trees.Bind)) break block52;
                                                                                                            var51_54 = (Trees.Bind)tree;
                                                                                                            name = var51_54.name();
                                                                                                            t = var51_54.body();
                                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name), " @ ", t, ")"}));
                                                                                                            break block37;
                                                                                                        }
                                                                                                        if (!(tree instanceof Trees.UnApply)) break block53;
                                                                                                        var54_57 = (Trees.UnApply)tree;
                                                                                                        fun = var54_57.fun();
                                                                                                        args = var54_57.args();
                                                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{fun, " <unapply> "}));
                                                                                                        this.printRow(args, "(", ", ", ")");
                                                                                                        break block37;
                                                                                                    }
                                                                                                    if (!(tree instanceof Trees.ArrayValue)) break block54;
                                                                                                    var57_60 = (Trees.ArrayValue)tree;
                                                                                                    elemtpt = var57_60.elemtpt();
                                                                                                    trees = var57_60.elems();
                                                                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"Array[", elemtpt}));
                                                                                                    this.printRow(trees, "]{", ", ", "}");
                                                                                                    break block37;
                                                                                                }
                                                                                                if (!(tree instanceof Trees.Function)) break block55;
                                                                                                var60_63 = (Trees.Function)tree;
                                                                                                vparams = var60_63.vparams();
                                                                                                this.printFunction(var60_63, (JFunction0$mcV$sp & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()V, $anonfun$printTree$10(scala.reflect.internal.Printers$TreePrinter scala.collection.immutable.List ), ()V)((TreePrinter)this, vparams));
                                                                                                break block37;
                                                                                            }
                                                                                            if (!(tree instanceof Trees.Assign)) break block56;
                                                                                            var62_65 = (Trees.Assign)tree;
                                                                                            lhs = var62_65.lhs();
                                                                                            rhs = var62_65.rhs();
                                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{lhs, " = ", rhs}));
                                                                                            break block37;
                                                                                        }
                                                                                        if (!(tree instanceof Trees.AssignOrNamedArg)) break block57;
                                                                                        var65_68 = (Trees.AssignOrNamedArg)tree;
                                                                                        lhs = var65_68.lhs();
                                                                                        rhs = var65_68.rhs();
                                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{lhs, " = ", rhs}));
                                                                                        break block37;
                                                                                    }
                                                                                    if (!(tree instanceof Trees.If)) break block58;
                                                                                    var68_71 = (Trees.If)tree;
                                                                                    cond = var68_71.cond();
                                                                                    thenp = var68_71.thenp();
                                                                                    elsep = var68_71.elsep();
                                                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"if (", cond, ")"}));
                                                                                    this.indent();
                                                                                    this.println();
                                                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{thenp}));
                                                                                    this.undent();
                                                                                    if (elsep.nonEmpty()) {
                                                                                        this.println();
                                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"else"}));
                                                                                        this.indent();
                                                                                        this.println();
                                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{elsep}));
                                                                                        this.undent();
                                                                                    }
                                                                                    break block37;
                                                                                }
                                                                                if (!(tree instanceof Trees.Return)) break block59;
                                                                                expr = ((Trees.Return)tree).expr();
                                                                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"return ", expr}));
                                                                                break block37;
                                                                            }
                                                                            if (!(tree instanceof Trees.Try)) break block60;
                                                                            var73_76 = (Trees.Try)tree;
                                                                            block = var73_76.block();
                                                                            catches = var73_76.catches();
                                                                            finalizer = var73_76.finalizer();
                                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"try "}));
                                                                            this.printBlock(block);
                                                                            if (catches.nonEmpty()) {
                                                                                this.printColumn(catches, " catch {", "", "}");
                                                                            }
                                                                            this.printOpt(" finally ", finalizer);
                                                                            break block37;
                                                                        }
                                                                        if (!(tree instanceof Trees.Throw)) break block61;
                                                                        expr = ((Trees.Throw)tree).expr();
                                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"throw ", expr}));
                                                                        break block37;
                                                                    }
                                                                    if (!(tree instanceof Trees.New)) break block62;
                                                                    tpe = ((Trees.New)tree).tpt();
                                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"new ", tpe}));
                                                                    break block37;
                                                                }
                                                                if (!(tree instanceof Trees.Typed)) break block63;
                                                                var79_82 = (Trees.Typed)tree;
                                                                expr = var79_82.expr();
                                                                tp = var79_82.tpt();
                                                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"(", expr, ": ", tp, ")"}));
                                                                break block37;
                                                            }
                                                            if (!(tree instanceof Trees.TypeApply)) break block64;
                                                            var82_85 = (Trees.TypeApply)tree;
                                                            fun = var82_85.fun();
                                                            targs = var82_85.args();
                                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{fun}));
                                                            this.printRow(targs, "[", ", ", "]");
                                                            break block37;
                                                        }
                                                        if (!(tree instanceof Trees.Apply)) break block65;
                                                        var85_88 = (Trees.Apply)tree;
                                                        fun = var85_88.fun();
                                                        vargs = var85_88.args();
                                                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{fun}));
                                                        this.printRow(vargs, "(", ", ", ")");
                                                        break block37;
                                                    }
                                                    if (!(tree instanceof Trees.ApplyDynamic)) break block66;
                                                    var88_91 = (Trees.ApplyDynamic)tree;
                                                    qual = var88_91.qual();
                                                    vargs = var88_91.args();
                                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"<apply-dynamic>(", qual, "#", tree.symbol().nameString()}));
                                                    this.printRow(vargs, ", (", ", ", "))");
                                                    break block37;
                                                }
                                                if (!(tree instanceof Trees.Super)) break block67;
                                                var2_2 = true;
                                                var3_3 = (Trees.Super)tree;
                                                var91_94 = var3_3.qual();
                                                if (!(var91_94 instanceof Trees.This)) break block67;
                                                qual = ((Trees.This)var91_94).qual();
                                                this.printSuper(var3_3, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$printTree$11(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree scala.reflect.internal.Names$TypeName ), ()Ljava/lang/String;)((TreePrinter)this, (Trees.Tree)tree, (Names.TypeName)qual), this.printSuper$default$3());
                                                break block37;
                                            }
                                            if (!var2_2) break block68;
                                            qual = var3_3.qual();
                                            mix = var3_3.mix();
                                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{qual, ".super"}));
                                            if (mix.nonEmpty()) {
                                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(2).append("[").append(mix).append("]").toString()}));
                                            }
                                            break block37;
                                        }
                                        if (!(tree instanceof Trees.This)) break block69;
                                        var95_98 = (Trees.This)tree;
                                        qual = var95_98.qual();
                                        this.printThis(var95_98, (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$printTree$12(scala.reflect.internal.Printers$TreePrinter scala.reflect.internal.Trees$Tree scala.reflect.internal.Names$TypeName ), ()Ljava/lang/String;)((TreePrinter)this, (Trees.Tree)tree, (Names.TypeName)qual));
                                        break block37;
                                    }
                                    if (!(tree instanceof Trees.Select)) break block70;
                                    var4_4 = true;
                                    var5_5 = (Trees.Select)tree;
                                    qual = var5_5.qualifier();
                                    if (!(qual instanceof Trees.New)) break block70;
                                    var98_101 = (Trees.New)qual;
                                    var130_102 = this.scala$reflect$internal$Printers$TreePrinter$$$outer().settings().debug();
                                    if (MutableSettings$.MODULE$ == null) {
                                        throw null;
                                    }
                                    if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) break block70;
                                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{var98_101}));
                                    break block37;
                                }
                                if (!var4_4) break block71;
                                qualifier = var5_5.qualifier();
                                name = var5_5.name();
                                this.print(Predef$.MODULE$.genericWrapArray(new Object[]{this.scala$reflect$internal$Printers$TreePrinter$$$outer().backquotedPath(qualifier), ".", this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name)}));
                                break block37;
                            }
                            if (!(tree instanceof Trees.Ident)) break block72;
                            var101_105 = (Trees.Ident)tree;
                            name = var101_105.name();
                            str = this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, name);
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{var101_105.isBackquoted() != false ? new StringBuilder(2).append("`").append(str).append("`").toString() : str}));
                            break block37;
                        }
                        if (!(tree instanceof Trees.Literal)) break block73;
                        x = ((Trees.Literal)tree).value();
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{x.escapedStringValue()}));
                        break block37;
                    }
                    if (!(tree instanceof Trees.TypeTree)) break block74;
                    var105_109 = (Trees.TypeTree)tree;
                    if (tree.tpe() == null || this.printPositions() && var105_109.original() != null) {
                        if (var105_109.original() != null) {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"<type: ", var105_109.original(), ">"}));
                        } else {
                            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"<type ?>"}));
                        }
                    } else if (tree.tpe().typeSymbol() != null && tree.tpe().typeSymbol().isAnonymousClass()) {
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree.tpe().typeSymbol().toString()}));
                    } else {
                        this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree.tpe().toString()}));
                    }
                    break block37;
                }
                if (!(tree instanceof Trees.Annotated)) ** GOTO lbl-1000
                var106_110 = (Trees.Annotated)tree;
                var107_111 = var106_110.annot();
                tree = var106_110.arg();
                if (!(var107_111 instanceof Trees.Apply)) ** GOTO lbl-1000
                var109_113 = (Trees.Apply)var107_111;
                var110_114 = var109_113.fun();
                args = var109_113.args();
                if (!(var110_114 instanceof Trees.Select)) ** GOTO lbl-1000
                var112_116 = (Trees.Select)var110_114;
                var113_117 = var112_116.qualifier();
                var114_118 = var112_116.name();
                if (!(var113_117 instanceof Trees.New)) ** GOTO lbl-1000
                tpt = ((Trees.New)var113_117).tpt();
                v4 = this.scala$reflect$internal$Printers$TreePrinter$$$outer().nme().CONSTRUCTOR();
                if (!(v4 != null ? v4.equals(var114_118) == false : var114_118 != null)) {
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tree, tree.isType() != false ? " " : ": "}));
                    this.printAnnot$1(tpt, args);
                } else if (tree instanceof Trees.SingletonTypeTree) {
                    ref = ((Trees.SingletonTypeTree)tree).ref();
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{ref, ".type"}));
                } else if (tree instanceof Trees.SelectFromTypeTree) {
                    var117_121 = (Trees.SelectFromTypeTree)tree;
                    qualifier = var117_121.qualifier();
                    selector = var117_121.name();
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{qualifier, "#", this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree, selector)}));
                } else if (tree instanceof Trees.CompoundTypeTree) {
                    templ = ((Trees.CompoundTypeTree)tree).templ();
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{templ}));
                } else if (tree instanceof Trees.AppliedTypeTree) {
                    var121_125 = (Trees.AppliedTypeTree)tree;
                    tp = var121_125.tpt();
                    args = var121_125.args();
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tp}));
                    this.printRow(args, "[", ", ", "]");
                } else if (tree instanceof Trees.TypeBoundsTree) {
                    var124_128 = (Trees.TypeBoundsTree)tree;
                    lo = var124_128.lo();
                    hi = var124_128.hi();
                    if (lo.tpe() == null || !lo.tpe().$eq$colon$eq(this.scala$reflect$internal$Printers$TreePrinter$$$outer().definitions().NothingTpe())) {
                        this.printOpt(" >: ", lo);
                    }
                    if (hi.tpe() == null || !hi.tpe().$eq$colon$eq(this.scala$reflect$internal$Printers$TreePrinter$$$outer().definitions().AnyTpe())) {
                        this.printOpt(" <: ", hi);
                    }
                } else if (tree instanceof Trees.ExistentialTypeTree) {
                    var127_131 = (Trees.ExistentialTypeTree)tree;
                    tpt = var127_131.tpt();
                    whereClauses = var127_131.whereClauses();
                    this.print(Predef$.MODULE$.genericWrapArray(new Object[]{tpt}));
                    this.printColumn(whereClauses, " forSome { ", ";", "}");
                } else {
                    this.scala$reflect$internal$Printers$TreePrinter$$$outer().xprintTree(this, tree);
                }
            }
            this.printTypesInfo(tree);
        }

        @Override
        public void print(Seq<Object> args2) {
            args2.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x0$1 -> {
                TreePrinter.$anonfun$print$1(this, x0$1);
                return BoxedUnit.UNIT;
            });
        }

        public boolean printValueParams$default$2() {
            return true;
        }

        public boolean printSuper$default$3() {
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Printers$TreePrinter$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ scala.reflect.api.Printers scala$reflect$api$Printers$TreePrinter$$$outer() {
            return this.scala$reflect$internal$Printers$TreePrinter$$$outer();
        }

        public static final /* synthetic */ void $anonfun$printTypeParams$1(TreePrinter $this, Trees.TypeDef t) {
            $this.printAnnotations(t);
            if (t.mods().hasFlag(131072L)) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"-"}));
            } else if (t.mods().hasFlag(65536L)) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"+"}));
            }
            $this.printParam(t);
        }

        public static final /* synthetic */ boolean $anonfun$ifSym$1() {
            return false;
        }

        private final boolean isNotRename$1(Trees.ImportSelector s) {
            block3: {
                block2: {
                    Names.Name name = s.name();
                    Names.Name name2 = this.scala$reflect$internal$Printers$TreePrinter$$$outer().nme().WILDCARD();
                    if (!(name == null ? name2 != null : !name.equals(name2))) break block2;
                    Names.Name name3 = s.name();
                    Names.Name name4 = s.rename();
                    if (name3 != null ? !name3.equals(name4) : name4 != null) break block3;
                }
                return true;
            }
            return false;
        }

        private final String selectorToString$1(Trees.ImportSelector s) {
            String from = this.scala$reflect$internal$Printers$TreePrinter$$$outer().quotedName(s.name());
            if (this.isNotRename$1(s)) {
                return from;
            }
            return new StringBuilder(2).append(from).append("=>").append(this.scala$reflect$internal$Printers$TreePrinter$$$outer().quotedName(s.rename())).toString();
        }

        private final Trees.Tree patConstr$1(Trees.Tree pat) {
            while (pat instanceof Trees.Apply) {
                pat = ((Trees.Apply)pat).fun();
            }
            return pat;
        }

        public static final /* synthetic */ String $anonfun$printTree$2(TreePrinter $this, Trees.Tree tree$4, Names.TermName name$2) {
            return $this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree$4, name$2);
        }

        public static final /* synthetic */ void $anonfun$printTree$3(TreePrinter $this, Trees.Tree tp$1) {
            $this.printOpt(": ", tp$1);
        }

        public static final /* synthetic */ void $anonfun$printTree$4(TreePrinter $this, Trees.Modifiers mods$1, Trees.Tree rhs$1) {
            if (!mods$1.isDeferred()) {
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{" = ", rhs$1.isEmpty() ? "_" : rhs$1}));
            }
        }

        public static final /* synthetic */ String $anonfun$printTree$5(TreePrinter $this, Trees.Tree tree$4, Names.TermName name$3) {
            return $this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree$4, name$3);
        }

        public static final /* synthetic */ void $anonfun$printTree$6(TreePrinter $this, Trees.Tree tp$2) {
            $this.printOpt(": ", tp$2);
        }

        public static final /* synthetic */ void $anonfun$printTree$7(TreePrinter $this, Trees.Tree rhs$2) {
            $this.printOpt(" = ", rhs$2);
        }

        public static final /* synthetic */ String $anonfun$printTree$8(TreePrinter $this, Trees.Tree tree$4, Names.TypeName name$4) {
            return $this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree$4, name$4);
        }

        public static final /* synthetic */ String $anonfun$printTree$9(TreePrinter $this, Trees.Tree expr$1) {
            return $this.scala$reflect$internal$Printers$TreePrinter$$$outer().backquotedPath(expr$1);
        }

        public static final /* synthetic */ void $anonfun$printTree$10(TreePrinter $this, List vparams$1) {
            $this.printValueParams(vparams$1, $this.printValueParams$default$2());
        }

        public static final /* synthetic */ String $anonfun$printTree$11(TreePrinter $this, Trees.Tree tree$4, Names.TypeName qual$1) {
            return $this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree$4, qual$1);
        }

        public static final /* synthetic */ String $anonfun$printTree$12(TreePrinter $this, Trees.Tree tree$4, Names.TypeName qual$2) {
            return $this.scala$reflect$internal$Printers$TreePrinter$$$outer().symName(tree$4, qual$2);
        }

        private final void printAnnot$1(Trees.Tree tpt$1, List args$1) {
            this.print(Predef$.MODULE$.genericWrapArray(new Object[]{"@", tpt$1}));
            if (args$1.nonEmpty()) {
                this.printRow(args$1, "(", ",", ")");
            }
        }

        public static final /* synthetic */ void $anonfun$print$1(TreePrinter $this, Object x0$1) {
            if (x0$1 instanceof Trees.Tree && ((Trees.Tree)x0$1).scala$reflect$internal$Trees$Tree$$$outer() == $this.scala$reflect$internal$Printers$TreePrinter$$$outer()) {
                Trees.Tree tree = (Trees.Tree)x0$1;
                $this.printPosition(tree);
                $this.printTree(tree);
                return;
            }
            if (x0$1 instanceof Names.Name && ((Names.Name)x0$1).scala$reflect$internal$Names$Name$$$outer() == $this.scala$reflect$internal$Printers$TreePrinter$$$outer()) {
                Names.Name name = (Names.Name)x0$1;
                $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{$this.scala$reflect$internal$Printers$TreePrinter$$$outer().quotedName(name)}));
                return;
            }
            $this.out.print(x0$1 == null ? "null" : x0$1.toString());
        }

        public TreePrinter(SymbolTable $outer, PrintWriter out) {
            this.out = out;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Printers.TreePrinter.$init$(this);
            this.indentMargin = 0;
            this.indentStep = 2;
            this.indentString = "                                        ";
            this.printTypes_$eq(BoxesRunTime.unboxToBoolean($outer.settings().printtypes().value()));
            this.printIds_$eq(BoxesRunTime.unboxToBoolean($outer.settings().uniqid().value()));
            this.printOwners_$eq(BoxesRunTime.unboxToBoolean($outer.settings().Yshowsymowners().value()));
            this.printKinds_$eq(BoxesRunTime.unboxToBoolean($outer.settings().Yshowsymkinds().value()));
            this.printMirrors_$eq(false);
            this.printPositions_$eq(BoxesRunTime.unboxToBoolean($outer.settings().Xprintpos().value()));
            this.commentsRequired = false;
            this.currentOwner = $outer.NoSymbol();
            this.selectorType = $outer.NoType();
        }

        public static final /* synthetic */ Object $anonfun$printAnnotations$1$adapted(TreePrinter $this, Object annot) {
            $this.print(Predef$.MODULE$.genericWrapArray(new Object[]{new StringBuilder(2).append("@").append(annot).append(" ").toString()}));
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$printDefDef$1$adapted(TreePrinter $this, List x$6) {
            $this.printValueParams(x$6, $this.printValueParams$default$2());
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$printTree$1$adapted(Symbols.Symbol x$13) {
            return BoxesRunTime.boxToBoolean(x$13.isModuleClass());
        }
    }
}

