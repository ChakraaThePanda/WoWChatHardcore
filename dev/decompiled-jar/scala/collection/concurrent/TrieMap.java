/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.CustomParallelizable;
import scala.collection.GenIterable;
import scala.collection.GenMapLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.MapLike;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.concurrent.Gen;
import scala.collection.concurrent.INode;
import scala.collection.concurrent.INode$;
import scala.collection.concurrent.INodeBase;
import scala.collection.concurrent.MainNode;
import scala.collection.concurrent.RDCSS_Descriptor;
import scala.collection.concurrent.TrieMap$;
import scala.collection.concurrent.TrieMapIterator;
import scala.collection.concurrent.TrieMapIterator$;
import scala.collection.concurrent.TrieMapSerializationEnd$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.mutable.ParTrieMap;
import scala.math.Equiv;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;
import scala.runtime.Statics;
import scala.util.hashing.Hashing;
import scala.util.hashing.Hashing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u0011Eb\u0001\u0002(P\u0005YC\u0011\"!\u0004\u0001\u0005\u0003\u0005\u000b\u0011\u0002-\t\u0015\u0005=\u0001A!A!\u0002\u0013\t\t\u0002\u0003\u0006\u0002(\u0001\u0011\t\u0011)A\u0005\u0003SA!\"a\u000e\u0001\u0005\u0003\u0005\u000b\u0011BA\u001d\u0011\u001d\t9\u0005\u0001C\u0005\u0003\u0013B\u0011\"a\u0015\u0001\u0001\u0004%I!!\u0016\t\u0013\u0005]\u0003\u00011A\u0005\n\u0005e\u0003\u0002CA3\u0001\u0001\u0006K!!\u000b\t\u0013\u0005\u001d\u0004\u00011A\u0005\n\u0005%\u0004\"CA6\u0001\u0001\u0007I\u0011BA7\u0011!\t\t\b\u0001Q!\n\u0005e\u0002\"CA:\u0001\u0001\u0007I\u0011BA;\u0011%\t9\b\u0001a\u0001\n\u0013\tI\b\u0003\u0005\u0002~\u0001\u0001\u000b\u0015BA\t\u0011\u001d\ty\u0003\u0001C\u0001\u0003+Bq!a \u0001\t\u0003\tI\u0007C\u0005\u0002\u0002\u0002\u0001\r\u0011\"\u0001\u0002\u0004\"I\u0011Q\u0013\u0001A\u0002\u0013\u0005\u0011q\u0013\u0005\b\u0003;\u0003\u0001\u0015)\u0003Y\u0011\u001d\t9\u0005\u0001C\u0001\u0003SCq!a\u0012\u0001\t\u0003\ty\u000bC\u0004\u00022\u0002!I!a-\t\u000f\u0005\u0015\u0007\u0001\"\u0003\u0002H\"9\u00111\u001b\u0001\u0005\u0002\u0005U\u0007bBAv\u0001\u0011\u0005\u0011Q\u001e\u0005\n\u0003w\u0004\u0011\u0013!C\u0001\u0003{DqAa\u0005\u0001\t\u0003\u0011)\u0002C\u0005\u0003\u001c\u0001\t\n\u0011\"\u0001\u0002~\"9!Q\u0004\u0001\u0005\n\t}\u0001b\u0002B\u0017\u0001\u0011%!q\u0006\u0005\b\u0005\u007f\u0001A\u0011\u0002B!\u0011\u001d\u00119\u0006\u0001C\u0005\u00053BqA!\u001c\u0001\t\u0013\u0011y\u0007C\u0004\u0003x\u0001!IA!\u001f\t\u000f\t\r\u0005\u0001\"\u0001\u0003\u0006\"9!Q\u0014\u0001\u0005B\t}\u0005b\u0002BQ\u0001\u0011\u0005#1\u0015\u0005\b\u0005K\u0003A\u0011\tBP\u0011\u001d\u00119\u000b\u0001C\u0001\u0005SCqAa+\u0001\t\u0003\u0011I\u000bC\u0004\u0003.\u0002!\t!a,\t\u000f\tE\u0006\u0001\"\u0001\u00034\"9!1\u0018\u0001\u0005B\tu\u0006b\u0002Ba\u0001\u0011\u0005!1\u0019\u0005\b\u0005\u000f\u0004A\u0011\u0001Be\u0011\u001d\u0011i\r\u0001C!\u0005\u001fDqAa5\u0001\t\u0003\u0011)\u000eC\u0004\u0003Z\u0002!\tEa7\t\u000f\t\u0015\b\u0001\"\u0011\u0003h\"9!Q\u001e\u0001\u0005\u0002\t=\bb\u0002B|\u0001\u0011\u0005#\u0011 \u0005\b\u0005{\u0004A\u0011\u0001B\u0000\u0011\u001d\u0019\u0019\u0001\u0001C\u0001\u0007\u000bAqaa\u0003\u0001\t\u0003\u001ai\u0001C\u0004\u0003x\u0002!\taa\u0007\t\u000f\r\u0005\u0002\u0001\"\u0001\u0004$!91\u0011\u0005\u0001\u0005\u0002\r=\u0002bBB\u001b\u0001\u0011\u00051q\u0007\u0005\b\u0007\u007f\u0001A\u0011IB!\u0011\u001d\u0019I\u0005\u0001C!\u0007\u0017Bqaa\u0015\u0001\t\u0003\u001a)\u0006C\u0004\u0004b\u0001!\tea\u0019\t\u000f\rU\u0004\u0001\"\u0003\u0004x!91\u0011\u0010\u0001\u0005B\rm\u0004bBB?\u0001\u0011\u00053qP\u0004\b\u0007+{\u0005\u0012ABL\r\u0019qu\n#\u0001\u0004\u001a\"9\u0011qI\"\u0005\u0002\r%\u0006\"CBV\u0007\n\u0007I\u0011ABW\u0011!\u0019yl\u0011Q\u0001\n\r=\u0006bBBl\u0007\u0012\r1\u0011\u001c\u0005\t\u0007w\u001c\u0005\u0015!\u0003\u0004~\"9!QU\"\u0005\u0002\u0011\raA\u0002C\t\u0007\u0002!\u0019\u0002C\u0004\u0002H)#\t\u0001\"\b\t\u000f\u0011\u0005\"\n\"\u0001\u0005$!IAqE\"\u0002\u0002\u0013%A\u0011\u0006\u0002\b)JLW-T1q\u0015\t\u0001\u0016+\u0001\u0006d_:\u001cWO\u001d:f]RT!AU*\u0002\u0015\r|G\u000e\\3di&|gNC\u0001U\u0003\u0015\u00198-\u00197b\u0007\u0001)2a\u00162m'\u001d\u0001\u0001\f\u00188v\u0003\u000f\u0001\"!\u0017.\u000e\u0003MK!aW*\u0003\r\u0005s\u0017PU3g!\u0011if\fY6\u000e\u0003=K!aX(\u0003\u00075\u000b\u0007\u000f\u0005\u0002bE2\u0001A!B2\u0001\u0005\u0004!'!A&\u0012\u0005\u0015D\u0007CA-g\u0013\t97KA\u0004O_RD\u0017N\\4\u0011\u0005eK\u0017B\u00016T\u0005\r\te.\u001f\t\u0003C2$Q!\u001c\u0001C\u0002\u0011\u0014\u0011A\u0016\t\u0006_J\u00047\u000e^\u0007\u0002a*\u0011\u0011/U\u0001\b[V$\u0018M\u00197f\u0013\t\u0019\bOA\u0004NCBd\u0015n[3\u0011\tu\u0003\u0001m\u001b\t\u0005m^LH0D\u0001R\u0013\tA\u0018K\u0001\u000bDkN$x.\u001c)be\u0006dG.\u001a7ju\u0006\u0014G.\u001a\t\u00053j\u00047.\u0003\u0002|'\n1A+\u001e9mKJ\u0002R!`A\u0002A.l\u0011A \u0006\u0003c~T1!!\u0001R\u0003!\u0001\u0018M]1mY\u0016d\u0017bAA\u0003}\nQ\u0001+\u0019:Ue&,W*\u00199\u0011\u0007e\u000bI!C\u0002\u0002\fM\u0013AbU3sS\u0006d\u0017N_1cY\u0016\f\u0011A]\u0001\u0006eR,\b\u000f\u001a\t\u0007\u0003'\t\u0019\u0003\u001e-\u000e\u0005\u0005U!\u0002BA\f\u00033\ta!\u0019;p[&\u001c'b\u0001)\u0002\u001c)!\u0011QDA\u0010\u0003\u0011)H/\u001b7\u000b\u0005\u0005\u0005\u0012\u0001\u00026bm\u0006LA!!\n\u0002\u0016\tY\u0012\t^8nS\u000e\u0014VMZ3sK:\u001cWMR5fY\u0012,\u0006\u000fZ1uKJ\fQ\u0001[1tQ\u001a\u0004R!a\u000b\u00024\u0001l!!!\f\u000b\t\u0005=\u0012\u0011G\u0001\bQ\u0006\u001c\b.\u001b8h\u0015\r\tibU\u0005\u0005\u0003k\tiCA\u0004ICND\u0017N\\4\u0002\u0005\u00154\u0007#BA\u001e\u0003\u0003\u0002gbA-\u0002>%\u0019\u0011qH*\u0002\u000fA\f7m[1hK&!\u00111IA#\u0005\u0015)\u0015/^5w\u0015\r\tydU\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0013Q\fY%!\u0014\u0002P\u0005E\u0003BBA\u0007\u000b\u0001\u0007\u0001\fC\u0004\u0002\u0010\u0015\u0001\r!!\u0005\t\u000f\u0005\u001dR\u00011\u0001\u0002*!9\u0011qG\u0003A\u0002\u0005e\u0012A\u00035bg\"LgnZ8cUV\u0011\u0011\u0011F\u0001\u000fQ\u0006\u001c\b.\u001b8h_\nTw\fJ3r)\u0011\tY&!\u0019\u0011\u0007e\u000bi&C\u0002\u0002`M\u0013A!\u00168ji\"I\u00111M\u0004\u0002\u0002\u0003\u0007\u0011\u0011F\u0001\u0004q\u0012\n\u0014a\u00035bg\"LgnZ8cU\u0002\n1\"Z9vC2LG/_8cUV\u0011\u0011\u0011H\u0001\u0010KF,\u0018\r\\5us>\u0014'n\u0018\u0013fcR!\u00111LA8\u0011%\t\u0019GCA\u0001\u0002\u0004\tI$\u0001\u0007fcV\fG.\u001b;z_\nT\u0007%A\u0006s_>$X\u000f\u001d3bi\u0016\u0014XCAA\t\u0003=\u0011xn\u001c;va\u0012\fG/\u001a:`I\u0015\fH\u0003BA.\u0003wB\u0011\"a\u0019\u000e\u0003\u0003\u0005\r!!\u0005\u0002\u0019I|w\u000e^;qI\u0006$XM\u001d\u0011\u0002\u0011\u0015\fX/\u00197jif\fAA]8piV\t\u0001\fK\u0004\u0012\u0003\u000f\u000bi)!%\u0011\u0007e\u000bI)C\u0002\u0002\fN\u0013!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\ty)A\u0010uQ&\u001c\bEZ5fY\u0012\u0004s/\u001b7mA\t,\u0007%\\1eK\u0002\u0002(/\u001b<bi\u0016\f#!a%\u0002\rIr\u0013G\r\u00181\u0003!\u0011xn\u001c;`I\u0015\fH\u0003BA.\u00033C\u0001\"a\u0019\u0013\u0003\u0003\u0005\r\u0001\u0017\u0015\b%\u0005\u001d\u0015QRAI\u0003\u0015\u0011xn\u001c;!Q\r\u0019\u0012\u0011\u0015\t\u00043\u0006\r\u0016bAAS'\nAao\u001c7bi&dW\rK\u0004\u0014\u0003\u000f\u000bi)!%\u0015\u000bQ\fY+!,\t\u000f\u0005\u001dB\u00031\u0001\u0002*!9\u0011q\u0007\u000bA\u0002\u0005eB#\u0001;\u0002\u0017]\u0014\u0018\u000e^3PE*,7\r\u001e\u000b\u0005\u00037\n)\fC\u0004\u00028Z\u0001\r!!/\u0002\u0007=,H\u000f\u0005\u0003\u0002<\u0006\u0005WBAA_\u0015\u0011\ty,a\b\u0002\u0005%|\u0017\u0002BAb\u0003{\u0013!c\u00142kK\u000e$x*\u001e;qkR\u001cFO]3b[\u0006Q!/Z1e\u001f\nTWm\u0019;\u0015\t\u0005m\u0013\u0011\u001a\u0005\b\u0003\u0017<\u0002\u0019AAg\u0003\tIg\u000e\u0005\u0003\u0002<\u0006=\u0017\u0002BAi\u0003{\u0013\u0011c\u00142kK\u000e$\u0018J\u001c9viN#(/Z1n\u0003!\u0019\u0015iU0S\u001f>#FCBAl\u0003;\f\t\u000fE\u0002Z\u00033L1!a7T\u0005\u001d\u0011un\u001c7fC:Da!a8\u0019\u0001\u0004A\u0016AA8w\u0011\u0019\t\u0019\u000f\u0007a\u00011\u0006\u0011aN\u001e\u0015\b1\u0005\u001d\u0015q]AIC\t\tI/\u0001\u0011uQ&\u001c\b%\\3uQ>$\u0007e^5mY\u0002\u0012W\rI7bI\u0016\u0004\u0003O]5wCR,\u0017\u0001\u0003:fC\u0012\u0014vn\u001c;\u0015\t\u0005=\u0018Q\u001f\t\u0006;\u0006E\bm[\u0005\u0004\u0003g|%!B%O_\u0012,\u0007\"CA|3A\u0005\t\u0019AAl\u0003\u0015\t'm\u001c:uQ\u001dI\u0012qQAt\u0003#\u000b!C]3bIJ{w\u000e\u001e\u0013eK\u001a\fW\u000f\u001c;%cU\u0011\u0011q \u0016\u0005\u0003/\u0014\ta\u000b\u0002\u0003\u0004A!!Q\u0001B\b\u001b\t\u00119A\u0003\u0003\u0003\n\t-\u0011!C;oG\",7m[3e\u0015\r\u0011iaU\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002\u0002B\t\u0005\u000f\u0011\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u0003=\u0011FiQ*T?J+\u0015\tR0S\u001f>#F\u0003BAx\u0005/A\u0011\"a>\u001c!\u0003\u0005\r!a6)\u000fm\t9)a:\u0002\u0012\u0006I\"\u000bR\"T'~\u0013V)\u0011#`%>{E\u000b\n3fM\u0006,H\u000e\u001e\u00132\u00039\u0011FiQ*T?\u000e{W\u000e\u001d7fi\u0016$B!a<\u0003\"!9\u0011q_\u000fA\u0002\u0005]\u0007fA\u000f\u0003&A!!q\u0005B\u0015\u001b\t\u0011Y!\u0003\u0003\u0003,\t-!a\u0002;bS2\u0014XmY\u0001\u000b%\u0012\u001b5kU0S\u001f>#F\u0003CAl\u0005c\u0011\u0019D!\u0010\t\u000f\u0005}g\u00041\u0001\u0002p\"9!Q\u0007\u0010A\u0002\t]\u0012\u0001D3ya\u0016\u001cG/\u001a3nC&t\u0007#B/\u0003:\u0001\\\u0017b\u0001B\u001e\u001f\nAQ*Y5o\u001d>$W\rC\u0004\u0002dz\u0001\r!a<\u0002\u0011%t7/\u001a:uQ\u000e$\u0002\"a\u0017\u0003D\t\u001d#\u0011\u000b\u0005\u0007\u0005\u000bz\u0002\u0019\u00011\u0002\u0003-DqA!\u0013 \u0001\u0004\u0011Y%\u0001\u0002iGB\u0019\u0011L!\u0014\n\u0007\t=3KA\u0002J]RDaAa\u0015 \u0001\u0004Y\u0017!\u0001<)\u0007}\u0011)#\u0001\u0006j]N,'\u000f^5gQ\u000e$\"Ba\u0017\u0003b\t\r$Q\rB4!\u0011I&QL6\n\u0007\t}3K\u0001\u0004PaRLwN\u001c\u0005\u0007\u0005\u000b\u0002\u0003\u0019\u00011\t\u000f\t%\u0003\u00051\u0001\u0003L!1!1\u000b\u0011A\u0002-DaA!\u001b!\u0001\u0004A\u0016\u0001B2p]\u0012D3\u0001\tB\u0013\u0003!awn\\6va\"\u001cG#\u0002-\u0003r\tM\u0004B\u0002B#C\u0001\u0007\u0001\rC\u0004\u0003J\u0005\u0002\rAa\u0013)\u0007\u0005\u0012)#\u0001\u0005sK6|g/\u001a5d)!\u0011YFa\u001f\u0003~\t}\u0004B\u0002B#E\u0001\u0007\u0001\r\u0003\u0004\u0003T\t\u0002\ra\u001b\u0005\b\u0005\u0013\u0012\u0003\u0019\u0001B&Q\r\u0011#QE\u0001\u0007gR\u0014\u0018N\\4\u0016\u0005\t\u001d\u0005\u0003\u0002BE\u0005/sAAa#\u0003\u0014B\u0019!QR*\u000e\u0005\t=%b\u0001BI+\u00061AH]8pizJ1A!&T\u0003\u0019\u0001&/\u001a3fM&!!\u0011\u0014BN\u0005\u0019\u0019FO]5oO*\u0019!QS*\u0002\u0007M,\u0017/F\u0001u\u0003\r\u0001\u0018M]\u000b\u0002y\u0006)Q-\u001c9us\u0006Q\u0011n\u001d*fC\u0012|e\u000e\\=\u0016\u0005\u0005]\u0017a\u00038p]J+\u0017\rZ(oYf\f\u0001b\u001d8baNDw\u000e\u001e\u0015\u0004S\t\u0015\u0012\u0001\u0005:fC\u0012|e\u000e\\=T]\u0006\u00048\u000f[8u)\t\u0011)\fE\u0003w\u0005o\u00037.\u0003\u0002`#\"\u001a!F!\n\u0002\u000b\rdW-\u0019:\u0015\u0005\u0005m\u0003fA\u0016\u0003&\u0005Y1m\\7qkR,\u0007*Y:i)\u0011\u0011YE!2\t\r\t\u0015C\u00061\u0001a\u0003\u0019awn\\6vaR\u00191Na3\t\r\t\u0015S\u00061\u0001a\u0003\u0015\t\u0007\u000f\u001d7z)\rY'\u0011\u001b\u0005\u0007\u0005\u000br\u0003\u0019\u00011\u0002\u0007\u001d,G\u000f\u0006\u0003\u0003\\\t]\u0007B\u0002B#_\u0001\u0007\u0001-A\u0002qkR$bAa\u0017\u0003^\n\u0005\bB\u0002Bpa\u0001\u0007\u0001-A\u0002lKfDaAa91\u0001\u0004Y\u0017!\u0002<bYV,\u0017AB;qI\u0006$X\r\u0006\u0004\u0002\\\t%(1\u001e\u0005\u0007\u0005\u000b\n\u0004\u0019\u00011\t\r\tM\u0013\u00071\u0001l\u0003!!\u0003\u000f\\;tI\u0015\fH\u0003\u0002By\u0005gl\u0011\u0001\u0001\u0005\u0007\u0005k\u0014\u0004\u0019A=\u0002\u0005-4\u0018A\u0002:f[>4X\r\u0006\u0003\u0003\\\tm\bB\u0002B#g\u0001\u0007\u0001-A\u0005%[&tWo\u001d\u0013fcR!!\u0011_B\u0001\u0011\u0019\u0011)\u0005\u000ea\u0001A\u0006Y\u0001/\u001e;JM\u0006\u00137/\u001a8u)\u0019\u0011Yfa\u0002\u0004\n!1!QI\u001bA\u0002\u0001DaAa\u00156\u0001\u0004Y\u0017aD4fi>\u0013X\t\\:f+B$\u0017\r^3\u0015\u000b-\u001cya!\u0005\t\r\t\u0015c\u00071\u0001a\u0011!\u0019\u0019B\u000eCA\u0002\rU\u0011AA8q!\u0011I6qC6\n\u0007\re1K\u0001\u0005=Eft\u0017-\\3?)\u0019\t9n!\b\u0004 !1!QI\u001cA\u0002\u0001DaAa\u00158\u0001\u0004Y\u0017a\u0002:fa2\f7-\u001a\u000b\t\u0003/\u001c)ca\n\u0004,!1!Q\t\u001dA\u0002\u0001Daa!\u000b9\u0001\u0004Y\u0017\u0001C8mIZ\fG.^3\t\r\r5\u0002\b1\u0001l\u0003!qWm\u001e<bYV,GC\u0002B.\u0007c\u0019\u0019\u0004\u0003\u0004\u0003Fe\u0002\r\u0001\u0019\u0005\u0007\u0005'J\u0004\u0019A6\u0002\u0011%$XM]1u_J,\"a!\u000f\u0011\tY\u001cY$_\u0005\u0004\u0007{\t&\u0001C%uKJ\fGo\u001c:\u0002\rY\fG.^3t+\t\u0019\u0019\u0005\u0005\u0003w\u0007\u000bZ\u0017bAB$#\nA\u0011\n^3sC\ndW-\u0001\u0004lKf\u001cV\r^\u000b\u0003\u0007\u001b\u0002BA^B(A&\u00191\u0011K)\u0003\u0007M+G/\u0001\u0006gS2$XM]&fsN$BA!.\u0004X!91\u0011L\u001fA\u0002\rm\u0013!\u00019\u0011\re\u001bi\u0006YAl\u0013\r\u0019yf\u0015\u0002\n\rVt7\r^5p]F\n\u0011\"\\1q-\u0006dW/Z:\u0016\t\r\u001541\u000e\u000b\u0005\u0007O\u001ay\u0007\u0005\u0004w\u0005o\u00037\u0011\u000e\t\u0004C\u000e-DABB7}\t\u0007AMA\u0001X\u0011\u001d\u0019\tH\u0010a\u0001\u0007g\n\u0011A\u001a\t\u00073\u000eu3n!\u001b\u0002\u0015\r\f7\r[3e'&TX\r\u0006\u0002\u0003L\u0005!1/\u001b>f+\t\u0011Y%\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070\u0006\u0002\u0004\u0002B!11QBE\u001b\t\u0019)I\u0003\u0003\u0004\b\u0006}\u0011\u0001\u00027b]\u001eLAA!'\u0004\u0006\":\u0001a!$\u0003d\u000eM\u0005cA-\u0004\u0010&\u00191\u0011S*\u0003!M+'/[1m-\u0016\u00148/[8o+&#e\u0004CT%\rdu\u0011%ah\u0002\u000fQ\u0013\u0018.Z'baB\u0011QlQ\n\u0006\u0007\u000em\u0015q\u0001\t\u0007\u0007;\u001b\u0019ka*\u000e\u0005\r}%bABQ#\u00069q-\u001a8fe&\u001c\u0017\u0002BBS\u0007?\u0013\u0011#T;uC\ndW-T1q\r\u0006\u001cGo\u001c:z!\ti\u0006\u0001\u0006\u0002\u0004\u0018\u0006a\u0011N\\8eKV\u0004H-\u0019;feV\u00111q\u0016\t\t\u0003'\t\u0019c!-\u0004HB211WB^\u0007\u0007\u0004r!XB[\u0007s\u001b\t-C\u0002\u00048>\u0013\u0011\"\u0013(pI\u0016\u0014\u0015m]3\u0011\u0007\u0005\u001cY\f\u0002\u0006\u0004>\u001a\u000b\t\u0011!A\u0003\u0002\u0011\u00141a\u0018\u00135\u00035Ign\u001c3fkB$\u0017\r^3sAA\u0019\u0011ma1\u0005\u0015\r\u0015g)!A\u0001\u0002\u000b\u0005AMA\u0002`IU\u0002da!3\u0004N\u000eM\u0007cB/\u0003:\r-7\u0011\u001b\t\u0004C\u000e5GACBh\r\u0006\u0005\t\u0011!B\u0001I\n\u0019q\f\n\u001c\u0011\u0007\u0005\u001c\u0019\u000e\u0002\u0006\u0004V\u001a\u000b\t\u0011!A\u0003\u0002\u0011\u00141a\u0018\u00138\u00031\u0019\u0017M\u001c\"vS2$gI]8n+\u0019\u0019Yna=\u0004xV\u00111Q\u001c\t\u000b\u0007;\u001byna9\u0004p\u000ee\u0018\u0002BBq\u0007?\u0013AbQ1o\u0005VLG\u000e\u001a$s_6\u0004Ba!:\u0004h6\t1)\u0003\u0003\u0004j\u000e-(\u0001B\"pY2LAa!<\u0004 \niq)\u001a8NCB4\u0015m\u0019;pef\u0004b!\u0017>\u0004r\u000eU\bcA1\u0004t\u0012)1m\u0012b\u0001IB\u0019\u0011ma>\u0005\u000b5<%\u0019\u00013\u0011\ru\u00031\u0011_B{\u0003-\u0011V-^:bE2,7I\u0011$\u0011\r\r\u00158q`3f\u0013\u0011!\taa;\u0003\u001f5\u000b\u0007oQ1o\u0005VLG\u000e\u001a$s_6,b\u0001\"\u0002\u0005\f\u0011=QC\u0001C\u0004!\u0019i\u0006\u0001\"\u0003\u0005\u000eA\u0019\u0011\rb\u0003\u0005\u000b\rL%\u0019\u00013\u0011\u0007\u0005$y\u0001B\u0003n\u0013\n\u0007AM\u0001\bNC:<G.\u001a3ICND\u0017N\\4\u0016\t\u0011UA1D\n\u0005\u0015b#9\u0002\u0005\u0004\u0002,\u0005MB\u0011\u0004\t\u0004C\u0012mA!B2K\u0005\u0004!GC\u0001C\u0010!\u0015\u0019)O\u0013C\r\u0003\u0011A\u0017m\u001d5\u0015\t\t-CQ\u0005\u0005\b\u0005\u000bb\u0005\u0019\u0001C\r\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0011-\u0002\u0003BBB\t[IA\u0001b\f\u0004\u0006\n1qJ\u00196fGR\u0004")
public final class TrieMap<K, V>
implements scala.collection.concurrent.Map<K, V>,
CustomParallelizable<Tuple2<K, V>, ParTrieMap<K, V>>,
Serializable {
    public static final long serialVersionUID = -6402774413839597105L;
    private Hashing<K> hashingobj;
    private Equiv<K> equalityobj;
    private AtomicReferenceFieldUpdater<TrieMap<K, V>, Object> rootupdater;
    private volatile Object root;

    public static <K, V> CanBuildFrom<TrieMap<?, ?>, Tuple2<K, V>, TrieMap<K, V>> canBuildFrom() {
        return TrieMap$.MODULE$.canBuildFrom();
    }

    public static AtomicReferenceFieldUpdater<INodeBase<?, ?>, MainNode<?, ?>> inodeupdater() {
        return TrieMap$.MODULE$.inodeupdater();
    }

    @Override
    public Combiner<Tuple2<K, V>, ParTrieMap<K, V>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public scala.collection.mutable.Map<K, V> withDefault(Function1<K, V> d) {
        return scala.collection.mutable.Map.withDefault$(this, d);
    }

    @Override
    public scala.collection.mutable.Map<K, V> withDefaultValue(V d) {
        return scala.collection.mutable.Map.withDefaultValue$(this, d);
    }

    @Override
    public Builder<Tuple2<K, V>, TrieMap<K, V>> newBuilder() {
        return scala.collection.mutable.MapLike.newBuilder$(this);
    }

    @Override
    public Seq<Tuple2<K, V>> toSeq() {
        return scala.collection.mutable.MapLike.toSeq$(this);
    }

    @Override
    public <V1> scala.collection.mutable.Map<K, V1> updated(K key, V1 value) {
        return scala.collection.mutable.MapLike.updated$(this, key, value);
    }

    @Override
    public <V1> scala.collection.mutable.Map<K, V1> $plus(Tuple2<K, V1> kv) {
        return scala.collection.mutable.MapLike.$plus$(this, kv);
    }

    @Override
    public <V1> scala.collection.mutable.Map<K, V1> $plus(Tuple2<K, V1> elem1, Tuple2<K, V1> elem2, Seq<Tuple2<K, V1>> elems) {
        return scala.collection.mutable.MapLike.$plus$(this, elem1, elem2, elems);
    }

    @Override
    public <V1> scala.collection.mutable.Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
        return scala.collection.mutable.MapLike.$plus$plus$(this, xs);
    }

    @Override
    public scala.collection.mutable.Map $minus(Object key) {
        return scala.collection.mutable.MapLike.$minus$(this, key);
    }

    @Override
    public scala.collection.mutable.MapLike<K, V, TrieMap<K, V>> transform(Function2<K, V, V> f) {
        return scala.collection.mutable.MapLike.transform$(this, f);
    }

    @Override
    public scala.collection.mutable.MapLike<K, V, TrieMap<K, V>> retain(Function2<K, V, Object> p) {
        return scala.collection.mutable.MapLike.retain$(this, p);
    }

    @Override
    public scala.collection.mutable.Map clone() {
        return scala.collection.mutable.MapLike.clone$(this);
    }

    @Override
    public scala.collection.mutable.Map result() {
        return scala.collection.mutable.MapLike.result$(this);
    }

    @Override
    public scala.collection.mutable.Map $minus(Object elem1, Object elem2, Seq elems) {
        return scala.collection.mutable.MapLike.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public scala.collection.mutable.Map $minus$minus(GenTraversableOnce xs) {
        return scala.collection.mutable.MapLike.$minus$minus$(this, xs);
    }

    @Override
    public /* synthetic */ Object scala$collection$mutable$Cloneable$$super$clone() {
        return super.clone();
    }

    @Override
    public Shrinkable<K> $minus$eq(K elem1, K elem2, Seq<K> elems) {
        return Shrinkable.$minus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Shrinkable<K> $minus$minus$eq(TraversableOnce<K> xs) {
        return Shrinkable.$minus$minus$eq$(this, xs);
    }

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
    public <NewTo> Builder<Tuple2<K, V>, NewTo> mapResult(Function1<TrieMap<K, V>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<Tuple2<K, V>> $plus$plus$eq(TraversableOnce<Tuple2<K, V>> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public boolean isEmpty() {
        return MapLike.isEmpty$(this);
    }

    @Override
    public <V1> V1 getOrElse(K key, Function0<V1> function0) {
        return (V1)MapLike.getOrElse$(this, key, function0);
    }

    @Override
    public boolean contains(K key) {
        return MapLike.contains$(this, key);
    }

    @Override
    public boolean isDefinedAt(K key) {
        return MapLike.isDefinedAt$(this, key);
    }

    @Override
    public <K1 extends K, V1> V1 applyOrElse(K1 x, Function1<K1, V1> function1) {
        return (V1)MapLike.applyOrElse$(this, x, function1);
    }

    @Override
    public Iterator<K> keysIterator() {
        return MapLike.keysIterator$(this);
    }

    @Override
    public Iterable<K> keys() {
        return MapLike.keys$(this);
    }

    @Override
    public Iterator<V> valuesIterator() {
        return MapLike.valuesIterator$(this);
    }

    @Override
    public V default(K key) {
        return (V)MapLike.default$(this, key);
    }

    @Override
    public Map filterNot(Function1 p) {
        return MapLike.filterNot$(this, p);
    }

    @Override
    public <E> Buffer<E> toBuffer() {
        return MapLike.toBuffer$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return MapLike.addString$(this, b, start, sep, end);
    }

    @Override
    public String toString() {
        return MapLike.toString$(this);
    }

    @Override
    public <A1 extends K, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
        return PartialFunction.orElse$(this, that);
    }

    @Override
    public <C> PartialFunction<K, C> andThen(Function1<V, C> k) {
        return PartialFunction.andThen$(this, k);
    }

    @Override
    public Function1<K, Option<V>> lift() {
        return PartialFunction.lift$(this);
    }

    @Override
    public <U> Function1<K, Object> runWith(Function1<V, U> action) {
        return PartialFunction.runWith$(this, action);
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, V> compose(Function1<A, K> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public int hashCode() {
        return GenMapLike.hashCode$(this);
    }

    @Override
    public boolean equals(Object that) {
        return GenMapLike.equals$(this, that);
    }

    @Override
    public GenericCompanion<scala.collection.mutable.Iterable> companion() {
        return scala.collection.mutable.Iterable.companion$(this);
    }

    @Override
    public Iterable<Tuple2<K, V>> thisCollection() {
        return IterableLike.thisCollection$(this);
    }

    @Override
    public Iterable toCollection(Object repr) {
        return IterableLike.toCollection$(this, repr);
    }

    @Override
    public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
        IterableLike.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<Tuple2<K, V>, Object> p) {
        return IterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Tuple2<K, V>, Object> p) {
        return IterableLike.exists$(this, p);
    }

    @Override
    public Option<Tuple2<K, V>> find(Function1<Tuple2<K, V>, Object> p) {
        return IterableLike.find$(this, p);
    }

    @Override
    public <B> B foldRight(B z, Function2<Tuple2<K, V>, B, B> op) {
        return (B)IterableLike.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceRight(Function2<Tuple2<K, V>, B, B> op) {
        return (B)IterableLike.reduceRight$(this, op);
    }

    @Override
    public Iterable<Tuple2<K, V>> toIterable() {
        return IterableLike.toIterable$(this);
    }

    @Override
    public Iterator<Tuple2<K, V>> toIterator() {
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
    public Iterator<TrieMap<K, V>> grouped(int size) {
        return IterableLike.grouped$(this, size);
    }

    @Override
    public Iterator<TrieMap<K, V>> sliding(int size) {
        return IterableLike.sliding$(this, size);
    }

    @Override
    public Iterator<TrieMap<K, V>> sliding(int size, int step) {
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
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<TrieMap<K, V>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zip$(this, that, bf);
    }

    @Override
    public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<TrieMap<K, V>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<TrieMap<K, V>, Tuple2<A1, Object>, That> bf) {
        return (That)IterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public Stream<Tuple2<K, V>> toStream() {
        return IterableLike.toStream$(this);
    }

    @Override
    public boolean canEqual(Object that) {
        return IterableLike.canEqual$(this, that);
    }

    @Override
    public IterableView<Tuple2<K, V>, TrieMap<K, V>> view() {
        return IterableLike.view$(this);
    }

    @Override
    public IterableView<Tuple2<K, V>, TrieMap<K, V>> view(int from, int until) {
        return IterableLike.view$(this, from, until);
    }

    @Override
    public <B> Builder<B, scala.collection.mutable.Iterable<B>> genericBuilder() {
        return GenericTraversableTemplate.genericBuilder$(this);
    }

    @Override
    public <A1, A2> Tuple2<scala.collection.mutable.Iterable<A1>, scala.collection.mutable.Iterable<A2>> unzip(Function1<Tuple2<K, V>, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<scala.collection.mutable.Iterable<A1>, scala.collection.mutable.Iterable<A2>, scala.collection.mutable.Iterable<A3>> unzip3(Function1<Tuple2<K, V>, Tuple3<A1, A2, A3>> asTriple) {
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
    public boolean hasDefiniteSize() {
        return TraversableLike.hasDefiniteSize$(this);
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That map(Function1<Tuple2<K, V>, B> f, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
        return (That)TraversableLike.map$(this, f, bf);
    }

    @Override
    public <B, That> That flatMap(Function1<Tuple2<K, V>, GenTraversableOnce<B>> f, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
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
    public <B, That> That collect(PartialFunction<Tuple2<K, V>, B> pf, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public Tuple2<TrieMap<K, V>, TrieMap<K, V>> partition(Function1<Tuple2<K, V>, Object> p) {
        return TraversableLike.partition$(this, p);
    }

    @Override
    public <K> scala.collection.immutable.Map<K, TrieMap<K, V>> groupBy(Function1<Tuple2<K, V>, K> f) {
        return TraversableLike.groupBy$(this, f);
    }

    @Override
    public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<TrieMap<K, V>, B, That> cbf) {
        return (That)TraversableLike.scan$(this, z, op, cbf);
    }

    @Override
    public <B, That> That scanLeft(B z, Function2<B, Tuple2<K, V>, B> op, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <B, That> That scanRight(B z, Function2<Tuple2<K, V>, B, B> op, CanBuildFrom<TrieMap<K, V>, B, That> bf) {
        return (That)TraversableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public Option<Tuple2<K, V>> headOption() {
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
    public Option<Tuple2<K, V>> lastOption() {
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
    public Tuple2<TrieMap<K, V>, TrieMap<K, V>> span(Function1<Tuple2<K, V>, Object> p) {
        return TraversableLike.span$(this, p);
    }

    @Override
    public Tuple2<TrieMap<K, V>, TrieMap<K, V>> splitAt(int n) {
        return TraversableLike.splitAt$(this, n);
    }

    @Override
    public Iterator<TrieMap<K, V>> tails() {
        return TraversableLike.tails$(this);
    }

    @Override
    public Iterator<TrieMap<K, V>> inits() {
        return TraversableLike.inits$(this);
    }

    @Override
    public Traversable<Tuple2<K, V>> toTraversable() {
        return TraversableLike.toTraversable$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<K, V>, Col> cbf) {
        return (Col)TraversableLike.to$(this, cbf);
    }

    @Override
    public FilterMonadic<Tuple2<K, V>, TrieMap<K, V>> withFilter(Function1<Tuple2<K, V>, Object> p) {
        return TraversableLike.withFilter$(this, p);
    }

    @Override
    public List<Tuple2<K, V>> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<Tuple2<K, V>, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<Tuple2<K, V>, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, Tuple2<K, V>, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<Tuple2<K, V>, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, Tuple2<K, V>, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, Tuple2<K, V>, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<K, V>, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<Tuple2<K, V>, B, B> op) {
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
    public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<K, V>, B> seqop, Function2<B, B, B> combop) {
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
    public List<Tuple2<K, V>> toList() {
        return TraversableOnce.toList$(this);
    }

    @Override
    public IndexedSeq<Tuple2<K, V>> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public <B> scala.collection.immutable.Set<B> toSet() {
        return TraversableOnce.toSet$(this);
    }

    @Override
    public Vector<Tuple2<K, V>> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<T, U>> ev) {
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

    private Hashing<K> hashingobj() {
        return this.hashingobj;
    }

    private void hashingobj_$eq(Hashing<K> x$1) {
        this.hashingobj = x$1;
    }

    private Equiv<K> equalityobj() {
        return this.equalityobj;
    }

    private void equalityobj_$eq(Equiv<K> x$1) {
        this.equalityobj = x$1;
    }

    private AtomicReferenceFieldUpdater<TrieMap<K, V>, Object> rootupdater() {
        return this.rootupdater;
    }

    private void rootupdater_$eq(AtomicReferenceFieldUpdater<TrieMap<K, V>, Object> x$1) {
        this.rootupdater = x$1;
    }

    public Hashing<K> hashing() {
        return this.hashingobj();
    }

    public Equiv<K> equality() {
        return this.equalityobj();
    }

    public Object root() {
        return this.root;
    }

    public void root_$eq(Object x$1) {
        this.root = x$1;
    }

    private void writeObject(ObjectOutputStream out) {
        out.writeObject(this.hashingobj());
        out.writeObject(this.equalityobj());
        Iterator<Tuple2<K, V>> it = this.iterator();
        while (it.hasNext()) {
            Tuple2<K, V> tuple2 = it.next();
            if (tuple2 == null) {
                throw new MatchError((Object)null);
            }
            K k = tuple2._1();
            V v = tuple2._2();
            out.writeObject(k);
            out.writeObject(v);
        }
        out.writeObject(TrieMapSerializationEnd$.MODULE$);
    }

    private void readObject(ObjectInputStream in) {
        TrieMapSerializationEnd$ trieMapSerializationEnd$;
        Object object;
        this.root_$eq(INode$.MODULE$.newRootNode());
        this.rootupdater_$eq(AtomicReferenceFieldUpdater.newUpdater(TrieMap.class, Object.class, "root"));
        this.hashingobj_$eq((Hashing)in.readObject());
        this.equalityobj_$eq((Equiv)in.readObject());
        do {
            Object obj;
            Object object2 = obj = in.readObject();
            TrieMapSerializationEnd$ trieMapSerializationEnd$2 = TrieMapSerializationEnd$.MODULE$;
            if (object2 == null ? trieMapSerializationEnd$2 != null : !object2.equals(trieMapSerializationEnd$2)) {
                Object v = in.readObject();
                this.update(obj, v);
            }
            object = obj;
            trieMapSerializationEnd$ = TrieMapSerializationEnd$.MODULE$;
        } while (object != null ? !object.equals(trieMapSerializationEnd$) : trieMapSerializationEnd$ != null);
    }

    public boolean CAS_ROOT(Object ov, Object nv) {
        return this.rootupdater().compareAndSet(this, ov, nv);
    }

    public INode<K, V> readRoot(boolean abort) {
        return this.RDCSS_READ_ROOT(abort);
    }

    public boolean readRoot$default$1() {
        return false;
    }

    public INode<K, V> RDCSS_READ_ROOT(boolean abort) {
        INode<K, V> iNode;
        Object r = this.root();
        if (r instanceof INode) {
            iNode = (INode<K, V>)r;
        } else if (r instanceof RDCSS_Descriptor) {
            iNode = this.RDCSS_Complete(abort);
        } else {
            throw new MatchError(r);
        }
        return iNode;
    }

    public boolean RDCSS_READ_ROOT$default$1() {
        return false;
    }

    private INode<K, V> RDCSS_Complete(boolean abort) {
        INode iNode;
        block5: {
            Object v;
            block6: {
                INode iNode2;
                while (true) {
                    if ((v = this.root()) instanceof INode) {
                        iNode = (INode)v;
                        break block5;
                    }
                    if (!(v instanceof RDCSS_Descriptor)) break block6;
                    RDCSS_Descriptor rDCSS_Descriptor = (RDCSS_Descriptor)v;
                    if (rDCSS_Descriptor == null) {
                        throw new MatchError((Object)null);
                    }
                    INode iNode3 = rDCSS_Descriptor.old();
                    MainNode mainNode = rDCSS_Descriptor.expectedmain();
                    INode iNode4 = rDCSS_Descriptor.nv();
                    INode ov = iNode3;
                    MainNode exp = mainNode;
                    INode nv = iNode4;
                    if (abort) {
                        if (!this.CAS_ROOT(rDCSS_Descriptor, ov)) continue;
                        iNode2 = ov;
                        break;
                    }
                    if (ov.gcasRead(this) == exp) {
                        if (!this.CAS_ROOT(rDCSS_Descriptor, nv)) continue;
                        rDCSS_Descriptor.committed_$eq(true);
                        iNode2 = nv;
                        break;
                    }
                    if (!this.CAS_ROOT(rDCSS_Descriptor, ov)) continue;
                    iNode2 = ov;
                    break;
                }
                iNode = iNode2;
                break block5;
            }
            throw new MatchError(v);
        }
        return iNode;
    }

    private boolean RDCSS_ROOT(INode<K, V> ov, MainNode<K, V> expectedmain, INode<K, V> nv) {
        RDCSS_Descriptor<K, V> desc = new RDCSS_Descriptor<K, V>(ov, expectedmain, nv);
        if (this.CAS_ROOT(ov, desc)) {
            this.RDCSS_Complete(false);
            return desc.committed();
        }
        return false;
    }

    private void inserthc(K k, int hc, V v) {
        INode<K, V> r;
        while (!(r = this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1())).rec_insert(k, v, hc, 0, null, r.gen, this)) {
        }
    }

    private Option<V> insertifhc(K k, int hc, V v, Object cond) {
        INode<K, V> r;
        Option<V> ret;
        while ((ret = (r = this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1())).rec_insertif(k, v, hc, cond, 0, null, r.gen, this)) == null) {
        }
        return ret;
    }

    private Object lookuphc(K k, int hc) {
        INode r;
        Object res;
        while ((res = (r = this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1())).rec_lookup(k, hc, 0, null, r.gen, this)) == INodeBase.RESTART) {
        }
        return res;
    }

    private Option<V> removehc(K k, V v, int hc) {
        while (true) {
            INode<K, V> r;
            Option<V> res;
            if ((res = (r = this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1())).rec_remove(k, v, hc, 0, null, r.gen, this)) == null) continue;
            return res;
        }
    }

    public String string() {
        return this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1()).string(0);
    }

    @Override
    public TrieMap<K, V> seq() {
        return this;
    }

    @Override
    public ParTrieMap<K, V> par() {
        return new ParTrieMap(this);
    }

    @Override
    public TrieMap<K, V> empty() {
        return new TrieMap<K, V>();
    }

    public boolean isReadOnly() {
        return this.rootupdater() == null;
    }

    public boolean nonReadOnly() {
        return this.rootupdater() != null;
    }

    public TrieMap<K, V> snapshot() {
        MainNode<K, V> expmain;
        INode<K, V> r;
        while (!this.RDCSS_ROOT(r = this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1()), expmain = r.gcasRead(this), r.copyToGen(new Gen(), this))) {
        }
        return new TrieMap<K, V>(r.copyToGen(new Gen(), this), this.rootupdater(), this.hashing(), this.equality());
    }

    public Map<K, V> readOnlySnapshot() {
        MainNode<K, V> expmain;
        INode<K, V> r;
        while (!this.RDCSS_ROOT(r = this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1()), expmain = r.gcasRead(this), r.copyToGen(new Gen(), this))) {
        }
        return new TrieMap<K, V>(r, null, this.hashing(), this.equality());
    }

    @Override
    public void clear() {
        INode<K, V> r;
        while (!this.RDCSS_ROOT(r = this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1()), r.gcasRead(this), INode$.MODULE$.newRootNode())) {
        }
    }

    public int computeHash(K k) {
        return this.hashingobj().hash(k);
    }

    public V lookup(K k) {
        int hc = this.computeHash(k);
        return (V)this.lookuphc(k, hc);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public V apply(K k) {
        void var3_3;
        int hc = this.computeHash(k);
        Object res = this.lookuphc(k, hc);
        if (res == null) {
            throw new NoSuchElementException();
        }
        return var3_3;
    }

    @Override
    public Option<V> get(K k) {
        int hc = this.computeHash(k);
        return Option$.MODULE$.apply(this.lookuphc(k, hc));
    }

    @Override
    public Option<V> put(K key, V value) {
        int hc = this.computeHash(key);
        return this.insertifhc(key, hc, value, null);
    }

    @Override
    public void update(K k, V v) {
        int hc = this.computeHash(k);
        this.inserthc(k, hc, v);
    }

    @Override
    public TrieMap<K, V> $plus$eq(Tuple2<K, V> kv) {
        this.update(kv._1(), kv._2());
        return this;
    }

    @Override
    public Option<V> remove(K k) {
        int hc = this.computeHash(k);
        return this.removehc(k, null, hc);
    }

    public TrieMap<K, V> $minus$eq(K k) {
        this.remove(k);
        return this;
    }

    @Override
    public Option<V> putIfAbsent(K k, V v) {
        int hc = this.computeHash(k);
        return this.insertifhc(k, hc, v, INode$.MODULE$.KEY_ABSENT());
    }

    @Override
    public V getOrElseUpdate(K k, Function0<V> op) {
        Object object;
        V oldv = this.lookup(k);
        if (oldv != null) {
            return oldv;
        }
        V v = op.apply();
        if (v == null) {
            throw new NullPointerException("Concurrent TrieMap values cannot be null.");
        }
        int hc = this.computeHash(k);
        Option<V> option = this.insertifhc(k, hc, v, INode$.MODULE$.KEY_ABSENT());
        if (option instanceof Some) {
            object = ((Some)option).value();
        } else if (None$.MODULE$.equals(option)) {
            object = v;
        } else {
            throw new MatchError(option);
        }
        return (V)object;
    }

    @Override
    public boolean remove(K k, V v) {
        int hc = this.computeHash(k);
        return this.removehc(k, v, hc).nonEmpty();
    }

    @Override
    public boolean replace(K k, V oldvalue, V newvalue) {
        int hc = this.computeHash(k);
        return this.insertifhc(k, hc, newvalue, oldvalue).nonEmpty();
    }

    @Override
    public Option<V> replace(K k, V v) {
        int hc = this.computeHash(k);
        return this.insertifhc(k, hc, v, INode$.MODULE$.KEY_PRESENT());
    }

    @Override
    public Iterator<Tuple2<K, V>> iterator() {
        if (this.nonReadOnly()) {
            return this.readOnlySnapshot().iterator();
        }
        return new TrieMapIterator(0, this, TrieMapIterator$.MODULE$.$lessinit$greater$default$3());
    }

    @Override
    public Iterable<V> values() {
        if (this.nonReadOnly()) {
            return this.readOnlySnapshot().values();
        }
        return MapLike.values$(this);
    }

    @Override
    public Set<K> keySet() {
        if (this.nonReadOnly()) {
            return this.readOnlySnapshot().keySet();
        }
        return MapLike.keySet$(this);
    }

    @Override
    public Map<K, V> filterKeys(Function1<K, Object> p) {
        if (this.nonReadOnly()) {
            return this.readOnlySnapshot().filterKeys(p);
        }
        return new MapLike.FilteredKeys(this, p);
    }

    @Override
    public <W> Map<K, W> mapValues(Function1<V, W> f) {
        if (this.nonReadOnly()) {
            return this.readOnlySnapshot().mapValues(f);
        }
        return new MapLike.MappedValues<W>(this, f);
    }

    private int cachedSize() {
        return this.RDCSS_READ_ROOT(this.RDCSS_READ_ROOT$default$1()).cachedSize(this);
    }

    @Override
    public int size() {
        if (this.nonReadOnly()) {
            return this.readOnlySnapshot().size();
        }
        return this.cachedSize();
    }

    @Override
    public String stringPrefix() {
        return "TrieMap";
    }

    private TrieMap(Object r, AtomicReferenceFieldUpdater<TrieMap<K, V>, Object> rtupd, Hashing<K> hashf, Equiv<K> ef) {
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        TraversableLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        Traversable.$init$(this);
        scala.collection.mutable.Traversable.$init$(this);
        GenIterable.$init$(this);
        IterableLike.$init$(this);
        Iterable.$init$(this);
        scala.collection.mutable.Iterable.$init$(this);
        GenMapLike.$init$(this);
        PartialFunction.$init$(this);
        Subtractable.$init$(this);
        MapLike.$init$(this);
        Map.$init$(this);
        Growable.$init$(this);
        Builder.$init$(this);
        Shrinkable.$init$(this);
        Cloneable.$init$(this);
        scala.collection.mutable.MapLike.$init$(this);
        scala.collection.mutable.Map.$init$(this);
        scala.collection.concurrent.Map.$init$(this);
        CustomParallelizable.$init$(this);
        this.hashingobj = hashf instanceof Hashing.Default ? new MangledHashing() : hashf;
        this.equalityobj = ef;
        this.rootupdater = rtupd;
        this.root = r;
    }

    public TrieMap(Hashing<K> hashf, Equiv<K> ef) {
        this(INode$.MODULE$.newRootNode(), AtomicReferenceFieldUpdater.newUpdater(TrieMap.class, Object.class, "root"), hashf, ef);
    }

    public TrieMap() {
        this(Hashing$.MODULE$.default(), package$.MODULE$.Equiv().universal());
    }

    public static class MangledHashing<K>
    implements Hashing<K> {
        @Override
        public int hash(K k) {
            return scala.util.hashing.package$.MODULE$.byteswap32(Statics.anyHash(k));
        }
    }
}

