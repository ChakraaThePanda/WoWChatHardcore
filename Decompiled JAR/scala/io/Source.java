/*
 * Decompiled with CFR 0.152.
 */
package scala.io;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URL;
import scala.Console$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.io.BufferedSource;
import scala.io.Codec;
import scala.io.Position;
import scala.io.Position$;
import scala.io.Source$;
import scala.io.Source$NoPositioner$;
import scala.io.Source$RelaxedPosition$;
import scala.io.Source$RelaxedPositioner$;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\rmx!B6m\u0011\u0003\th!B:m\u0011\u0003!\b\"B=\u0002\t\u0003Q\bbB>\u0002\u0005\u0004%\t\u0001 \u0005\b\u0003\u0003\t\u0001\u0015!\u0003~\u0011\u001d\t\u0019!\u0001C\u0001\u0003\u000bAq!!\u0004\u0002\t\u0003\ty\u0001C\u0004\u0003T\u0006!\tA!6\t\u000f\tm\u0017\u0001\"\u0001\u0003^\"9!\u0011^\u0001\u0005\u0002\t-\bb\u0002By\u0003\u0011\u0005!1\u001f\u0005\b\u0005c\fA\u0011AB\u0003\u0011\u001d\u0011\t0\u0001C\u0001\u0007\u001bAqA!=\u0002\t\u0003\u0019\u0019\u0003C\u0004\u0003r\u0006!\ta!\u000b\t\u000f\tE\u0018\u0001\"\u0001\u0004:!9!\u0011_\u0001\u0005\u0002\r}\u0002b\u0002By\u0003\u0011\u00051\u0011\n\u0005\b\u0007'\nA\u0011AB+\u0011\u001d\u0019\u0019&\u0001C\u0001\u0007OBqa!\u001c\u0002\t\u0003\u0019y\u0007C\u0004\u0004t\u0005!\ta!\u001e\t\u000f\ru\u0014\u0001\"\u0001\u0004\u0000!91QP\u0001\u0005\u0002\r\u0015\u0005bBB?\u0003\u0011\u00051Q\u0012\u0005\b\u0007{\nA\u0011ABN\u0011\u001d\u0019\u0019+\u0001C\u0001\u0007KC\u0011ba/\u0002#\u0003%\ta!0\t\u0013\r\u0005\u0017!%A\u0005\u0002\r\r\u0007\"CBd\u0003E\u0005I\u0011ABe\u0011\u001d\u0019i-\u0001C\u0001\u0007\u001fDqa!4\u0002\t\u0003\u00199\u000eC\u0004\u0004`\u0006!\ta!9\t\u0013\rU\u0018!%A\u0005\u0002\r]hAB:m\u0003\u0003\t\u0019\u0002\u0003\u0004zE\u0011\u0005\u0011q\u0007\u0005\n\u0003s\u0011#\u0019!D\t\u0003wA\u0011\"!\u0010#\u0001\u0004%\t!a\u0010\t\u0013\u0005]#\u00051A\u0005\u0002\u0005e\u0003\u0002CA3E\u0001\u0006K!!\u0011\t\u0011\u0005\u001d$\u00051A\u0005\u0002qD\u0011\"!\u001b#\u0001\u0004%\t!a\u001b\t\u000f\u0005=$\u0005)Q\u0005{\"A\u0011\u0011\u000f\u0012A\u0002\u0013\u0005A\u0010C\u0005\u0002t\t\u0002\r\u0011\"\u0001\u0002v!9\u0011\u0011\u0010\u0012!B\u0013i\bbBA>E\u0011%\u0011Q\u0010\u0004\u0007\u0003\u0007\u0013\u0003!!\"\t\re|C\u0011AAK\u0011!\tYj\fQ\u0001\n\u0005u\u0005BCA\u001d_!\u0015\r\u0011\"\u0001\u0002*\"9\u0011\u0011W\u0018\u0005\u0002\u0005M\u0006bBA`_\u0011\u0005\u0011\u0011\u0019\u0005\b\u0003\u0007|C\u0011AAc\u0011\u001d\t9m\fC\u0001\u0003\u0013Dq!!6#\t\u0003\t9\u000eC\u0004\u0002D\n\"\t!!2\t\u000f\u0005\u001d'\u0005\"\u0001\u0002Z\u001a1\u00111\u001c\u0012\u0001\u0003;D!\"a8;\u0005\u0003\u0005\u000b\u0011BAq\u0011\u0019I(\b\"\u0001\u0002h\"1\u0011P\u000fC\u0001\u0003[D1\"!0;\u0001\u0004\u0005\r\u0011\"\u0001\u0002p\"Y\u0011\u0011\u001f\u001eA\u0002\u0003\u0007I\u0011AAz\u0011-\t9P\u000fa\u0001\u0002\u0003\u0006K!a\t\t\u0011\u0005e(\b1A\u0005\u0002qD\u0011\"a?;\u0001\u0004%\t!!@\t\u000f\t\u0005!\b)Q\u0005{\"A!1\u0001\u001eA\u0002\u0013\u0005A\u0010C\u0005\u0003\u0006i\u0002\r\u0011\"\u0001\u0003\b!9!1\u0002\u001e!B\u0013i\b\u0002\u0003B\u0007u\u0001\u0007I\u0011\u0001?\t\u0013\t=!\b1A\u0005\u0002\tE\u0001b\u0002B\u000bu\u0001\u0006K! \u0005\t\u0005/Q\u0004\u0019!C\u0001y\"I!\u0011\u0004\u001eA\u0002\u0013\u0005!1\u0004\u0005\b\u0005?Q\u0004\u0015)\u0003~\u0011\u001d\t9M\u000fC\u0001\u00033<qA!\t#\u0011\u0003\u0011\u0019CB\u0004\u0003&\tB\tAa\n\t\re|E\u0011\u0001B\u0015\u0011\u001d\u0011Yc\u0014C\u0001\u0005[9qA!\u000e#\u0011\u0003\u00119DB\u0004\u0003:\tB\tAa\u000f\t\re\u001cF\u0011\u0001B\u001f\u000f\u001d\u0011yD\tE\u0001\u0005\u00032qAa\u0011#\u0011\u0003\u0011)\u0005\u0003\u0004z-\u0012\u0005!q\t\u0005\b\u0003\u000f4F\u0011IAm\u0011\u001d\tiL\tC\u0001\u0003_Da!!?#\t\u0003a\bb\u0002B%E\u0011\u0005!1\n\u0005\n\u0005;\u0012\u0013\u0013!C\u0001\u0005?BqA!\u001e#\t\u0013\u00119\bC\u0004\u0003~\t\"\tAa \t\u000f\t\u001d%\u0005\"\u0001\u0003\n\"I!\u0011\u0013\u0012\u0012\u0002\u0013\u0005!q\f\u0005\t\u0005'\u0013\u0003\u0015)\u0003\u0003\u0016\"A!1\u0014\u0012!B\u0013\u0011i\n\u0003\u0005\u0003 \n\u0002\u000b\u0015BAu\u0011\u001d\u0011\tK\tC\u0001\u0005GCqA!+#\t\u0003\u0011Y\u000bC\u0004\u00030\n\"\tA!-\t\u000f\t]&\u0005\"\u0001\u0003:\"9!q\u0017\u0012\u0005\u0002\t}\u0006b\u0002BbE\u0011\u0005!Q\u0019\u0005\b\u0005\u000f\u0014C\u0011AA\u001c\u0003\u0019\u0019v.\u001e:dK*\u0011QN\\\u0001\u0003S>T\u0011a\\\u0001\u0006g\u000e\fG.Y\u0002\u0001!\t\u0011\u0018!D\u0001m\u0005\u0019\u0019v.\u001e:dKN\u0011\u0011!\u001e\t\u0003m^l\u0011A\\\u0005\u0003q:\u0014a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001r\u00039!UMZ1vYR\u0014UOZ*ju\u0016,\u0012! \t\u0003mzL!a 8\u0003\u0007%sG/A\bEK\u001a\fW\u000f\u001c;Ck\u001a\u001c\u0016N_3!\u0003\u0015\u0019H\u000fZ5o+\t\t9\u0001E\u0002s\u0003\u0013I1!a\u0003m\u00059\u0011UO\u001a4fe\u0016$7k\\;sG\u0016\fAB\u001a:p[&#XM]1cY\u0016$B!!\u0005\u0003JB\u0011!OI\n\u0007EU\f)\"!\u000b\u0011\r\u0005]\u0011QDA\u0012\u001d\r1\u0018\u0011D\u0005\u0004\u00037q\u0017a\u00029bG.\fw-Z\u0005\u0005\u0003?\t\tC\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0015\r\tYB\u001c\t\u0004m\u0006\u0015\u0012bAA\u0014]\n!1\t[1s!\u0011\tY#a\r\u000e\u0005\u00055\"bA7\u00020)\u0011\u0011\u0011G\u0001\u0005U\u00064\u0018-\u0003\u0003\u00026\u00055\"!C\"m_N,\u0017M\u00197f)\t\t\t\"\u0001\u0003ji\u0016\u0014XCAA\u000b\u0003\u0015!Wm]2s+\t\t\t\u0005\u0005\u0003\u0002D\u0005Ec\u0002BA#\u0003\u001b\u00022!a\u0012o\u001b\t\tIEC\u0002\u0002LA\fa\u0001\u0010:p_Rt\u0014bAA(]\u00061\u0001K]3eK\u001aLA!a\u0015\u0002V\t11\u000b\u001e:j]\u001eT1!a\u0014o\u0003%!Wm]2s?\u0012*\u0017\u000f\u0006\u0003\u0002\\\u0005\u0005\u0004c\u0001<\u0002^%\u0019\u0011q\f8\u0003\tUs\u0017\u000e\u001e\u0005\n\u0003G2\u0013\u0011!a\u0001\u0003\u0003\n1\u0001\u001f\u00132\u0003\u0019!Wm]2sA\u00059a.\u001a:s_J\u001c\u0018a\u00038feJ|'o]0%KF$B!a\u0017\u0002n!A\u00111M\u0015\u0002\u0002\u0003\u0007Q0\u0001\u0005oKJ\u0014xN]:!\u0003%qw/\u0019:oS:<7/A\u0007oo\u0006\u0014h.\u001b8hg~#S-\u001d\u000b\u0005\u00037\n9\b\u0003\u0005\u0002d1\n\t\u00111\u0001~\u0003)qw/\u0019:oS:<7\u000fI\u0001\bY&tWMT;n)\u0011\t\t%a \t\r\u0005\u0005e\u00061\u0001~\u0003\u0011a\u0017N\\3\u0003\u00191Kg.Z%uKJ\fGo\u001c:\u0014\u000b=\n9)a%\u0011\r\u0005%\u0015qRA!\u001b\t\tYIC\u0002\u0002\u000e:\f!bY8mY\u0016\u001cG/[8o\u0013\u0011\t\t*a#\u0003!\u0005\u00137\u000f\u001e:bGRLE/\u001a:bi>\u0014\bCBA\f\u0003;\t\t\u0005\u0006\u0002\u0002\u0018B\u0019\u0011\u0011T\u0018\u000e\u0003\t\n!a\u001d2\u0011\t\u0005}\u0015QU\u0007\u0003\u0003CSA!a)\u0002\f\u00069Q.\u001e;bE2,\u0017\u0002BAT\u0003C\u0013Qb\u0015;sS:<')^5mI\u0016\u0014XCAAV!\u0019\t9\"!,\u0002$%!\u0011qVA\u0011\u0005A\u0011UO\u001a4fe\u0016$\u0017\n^3sCR|'/A\u0005jg:+w\u000f\\5oKR!\u0011QWA^!\r1\u0018qW\u0005\u0004\u0003ss'a\u0002\"p_2,\u0017M\u001c\u0005\b\u0003{\u001b\u0004\u0019AA\u0012\u0003\t\u0019\u0007.\u0001\u0003hKR\u001cGCAA[\u0003\u001dA\u0017m\u001d(fqR,\"!!.\u0002\t9,\u0007\u0010\u001e\u000b\u0003\u0003\u0017\u0004B!!4\u0002T6\u0011\u0011q\u001a\u0006\u0005\u0003#\fy#\u0001\u0003mC:<\u0017\u0002BA*\u0003\u001f\f\u0001bZ3u\u0019&tWm\u001d\u000b\u0003\u0003'#\"!a\t\u0003\u0015A{7/\u001b;j_:,'o\u0005\u0002;k\u00069QM\\2pI\u0016\u0014\bc\u0001:\u0002d&\u0019\u0011Q\u001d7\u0003\u0011A{7/\u001b;j_:$B!!;\u0002lB\u0019\u0011\u0011\u0014\u001e\t\u000f\u0005}G\b1\u0001\u0002bR\u0011\u0011\u0011^\u000b\u0003\u0003G\taa\u00195`I\u0015\fH\u0003BA.\u0003kD\u0011\"a\u0019@\u0003\u0003\u0005\r!a\t\u0002\u0007\rD\u0007%A\u0002q_N\fq\u0001]8t?\u0012*\u0017\u000f\u0006\u0003\u0002\\\u0005}\b\u0002CA2\u0005\u0006\u0005\t\u0019A?\u0002\tA|7\u000fI\u0001\u0006G2Lg.Z\u0001\nG2Lg.Z0%KF$B!a\u0017\u0003\n!A\u00111M#\u0002\u0002\u0003\u0007Q0\u0001\u0004dY&tW\rI\u0001\u0005G\u000e|G.\u0001\u0005dG>dw\fJ3r)\u0011\tYFa\u0005\t\u0011\u0005\r\u0004*!AA\u0002u\fQaY2pY\u0002\na\u0001^1cS:\u001c\u0017A\u0003;bE&t7m\u0018\u0013fcR!\u00111\fB\u000f\u0011!\t\u0019gSA\u0001\u0002\u0004i\u0018a\u0002;bE&t7\rI\u0001\u0010%\u0016d\u0017\r_3e!>\u001c\u0018\u000e^5p]B\u0019\u0011\u0011T(\u0003\u001fI+G.\u0019=fIB{7/\u001b;j_:\u001c2aTAq)\t\u0011\u0019#\u0001\u0006dQ\u0016\u001c7.\u00138qkR$b!a\u0017\u00030\tE\u0002BBAA#\u0002\u0007Q\u0010\u0003\u0004\u00034E\u0003\r!`\u0001\u0007G>dW/\u001c8\u0002#I+G.\u0019=fIB{7/\u001b;j_:,'\u000fE\u0002\u0002\u001aN\u0013\u0011CU3mCb,G\rU8tSRLwN\\3s'\r\u0019\u0016\u0011\u001e\u000b\u0003\u0005o\tABT8Q_NLG/[8oKJ\u00042!!'W\u00051qu\u000eU8tSRLwN\\3s'\r1\u0016\u0011\u001e\u000b\u0003\u0005\u0003\n1B]3q_J$XI\u001d:peRA\u00111\fB'\u0005\u001f\u0012\u0019\u0006\u0003\u0004\u0002zn\u0003\r! \u0005\b\u0005#Z\u0006\u0019AA!\u0003\ri7o\u001a\u0005\n\u0005+Z\u0006\u0013!a\u0001\u0005/\n1a\\;u!\u0011\tYC!\u0017\n\t\tm\u0013Q\u0006\u0002\f!JLg\u000e^*ue\u0016\fW.A\u000bsKB|'\u000f^#se>\u0014H\u0005Z3gCVdG\u000fJ\u001a\u0016\u0005\t\u0005$\u0006\u0002B,\u0005GZ#A!\u001a\u0011\t\t\u001d$\u0011O\u0007\u0003\u0005SRAAa\u001b\u0003n\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0004\u0005_r\u0017AC1o]>$\u0018\r^5p]&!!1\u000fB5\u0005E)hn\u00195fG.,GMV1sS\u0006t7-Z\u0001\u0007gB\f7-Z:\u0015\t\u0005\u0005#\u0011\u0010\u0005\u0007\u0005wj\u0006\u0019A?\u0002\u00039\faA]3q_J$H\u0003CA.\u0005\u0003\u0013\u0019I!\"\t\r\u0005eh\f1\u0001~\u0011\u001d\u0011\tF\u0018a\u0001\u0003\u0003BqA!\u0016_\u0001\u0004\u00119&A\u0007sKB|'\u000f^,be:Lgn\u001a\u000b\t\u00037\u0012YI!$\u0003\u0010\"1\u0011\u0011`0A\u0002uDqA!\u0015`\u0001\u0004\t\t\u0005C\u0005\u0003V}\u0003\n\u00111\u0001\u0003X\u00059\"/\u001a9peR<\u0016M\u001d8j]\u001e$C-\u001a4bk2$HeM\u0001\u000ee\u0016\u001cX\r\u001e$v]\u000e$\u0018n\u001c8\u0011\u000bY\u00149*!\u0005\n\u0007\teeNA\u0005Gk:\u001cG/[8oa\u0005i1\r\\8tK\u001a+hn\u0019;j_:\u0004RA\u001eBL\u00037\n!\u0002]8tSRLwN\\3s\u0003%9\u0018\u000e\u001e5SKN,G\u000f\u0006\u0003\u0002\u001a\n\u0015\u0006b\u0002BTI\u0002\u0007!QS\u0001\u0002M\u0006Iq/\u001b;i\u00072|7/\u001a\u000b\u0005\u00033\u0013i\u000bC\u0004\u0003(\u0016\u0004\rA!(\u0002\u001f]LG\u000f\u001b#fg\u000e\u0014\u0018\u000e\u001d;j_:$B!!'\u00034\"9!Q\u00174A\u0002\u0005\u0005\u0013\u0001\u0002;fqR\fqb^5uQB{7/\u001b;j_:Lgn\u001a\u000b\u0005\u00033\u0013Y\fC\u0004\u0003>\u001e\u0004\r!!.\u0002\u0005=tG\u0003BAM\u0005\u0003Dq!!?i\u0001\u0004\tI/A\u0003dY>\u001cX\r\u0006\u0002\u0002\\\u0005)!/Z:fi\"9!1\u001a\u0004A\u0002\t5\u0017\u0001C5uKJ\f'\r\\3\u0011\r\u0005]!qZA\u0012\u0013\u0011\u0011\t.!\t\u0003\u0011%#XM]1cY\u0016\f\u0001B\u001a:p[\u000eC\u0017M\u001d\u000b\u0005\u0003#\u00119\u000eC\u0004\u0003Z\u001e\u0001\r!a\t\u0002\u0003\r\f\u0011B\u001a:p[\u000eC\u0017M]:\u0015\t\u0005E!q\u001c\u0005\b\u0005CD\u0001\u0019\u0001Br\u0003\u0015\u0019\u0007.\u0019:t!\u00151(Q]A\u0012\u0013\r\u00119O\u001c\u0002\u0006\u0003J\u0014\u0018-_\u0001\u000bMJ|Wn\u0015;sS:<G\u0003BA\t\u0005[DqAa<\n\u0001\u0004\t\t%A\u0001t\u0003!1'o\\7GS2,G\u0003\u0002B{\u0007\u0003!B!a\u0002\u0003x\"9!\u0011 \u0006A\u0004\tm\u0018!B2pI\u0016\u001c\u0007c\u0001:\u0003~&\u0019!q 7\u0003\u000b\r{G-Z2\t\u000f\r\r!\u00021\u0001\u0002B\u0005!a.Y7f)\u0019\t9aa\u0002\u0004\n!911A\u0006A\u0002\u0005\u0005\u0003bBB\u0006\u0017\u0001\u0007\u0011\u0011I\u0001\u0004K:\u001cG\u0003BB\b\u0007'!B!a\u0002\u0004\u0012!9!\u0011 \u0007A\u0004\tm\bbBB\u000b\u0019\u0001\u00071qC\u0001\u0004kJL\u0007\u0003BB\r\u0007?i!aa\u0007\u000b\t\ru\u0011qF\u0001\u0004]\u0016$\u0018\u0002BB\u0011\u00077\u00111!\u0016*J)\u0019\t9a!\n\u0004(!91QC\u0007A\u0002\r]\u0001bBB\u0006\u001b\u0001\u0007\u0011\u0011\t\u000b\u0005\u0007W\u0019y\u0003\u0006\u0003\u0002\b\r5\u0002b\u0002B}\u001d\u0001\u000f!1 \u0005\b\u0007cq\u0001\u0019AB\u001a\u0003\u00111\u0017\u000e\\3\u0011\t\u0005-2QG\u0005\u0005\u0007o\tiC\u0001\u0003GS2,GCBA\u0004\u0007w\u0019i\u0004C\u0004\u00042=\u0001\raa\r\t\u000f\r-q\u00021\u0001\u0002BQA\u0011qAB!\u0007\u0007\u001a)\u0005C\u0004\u00042A\u0001\raa\r\t\u000f\r-\u0001\u00031\u0001\u0002B!11q\t\tA\u0002u\f!BY;gM\u0016\u00148+\u001b>f)\u0019\u0019Yea\u0014\u0004RQ!\u0011qAB'\u0011\u001d\u0011I0\u0005a\u0002\u0005wDqa!\r\u0012\u0001\u0004\u0019\u0019\u0004\u0003\u0004\u0004HE\u0001\r!`\u0001\nMJ|WNQ=uKN$Baa\u0016\u0004\\Q!\u0011\u0011CB-\u0011\u001d\u0011IP\u0005a\u0002\u0005wDqa!\u0018\u0013\u0001\u0004\u0019y&A\u0003csR,7\u000fE\u0003w\u0005K\u001c\t\u0007E\u0002w\u0007GJ1a!\u001ao\u0005\u0011\u0011\u0015\u0010^3\u0015\r\u0005E1\u0011NB6\u0011\u001d\u0019if\u0005a\u0001\u0007?Bqaa\u0003\u0014\u0001\u0004\t\t%\u0001\u0007ge>l'+Y<CsR,7\u000f\u0006\u0003\u0002\u0012\rE\u0004bBB/)\u0001\u00071qL\u0001\bMJ|W.\u0016*J)\u0011\u00199ha\u001f\u0015\t\u0005\u001d1\u0011\u0010\u0005\b\u0005s,\u00029\u0001B~\u0011\u001d\u0019)\"\u0006a\u0001\u0007/\tqA\u001a:p[V\u0013F\n\u0006\u0004\u0002\b\r\u000551\u0011\u0005\b\u0005_4\u0002\u0019AA!\u0011\u001d\u0019YA\u0006a\u0001\u0003\u0003\"Baa\"\u0004\fR!\u0011qABE\u0011\u001d\u0011Ip\u0006a\u0002\u0005wDqAa<\u0018\u0001\u0004\t\t\u0005\u0006\u0004\u0002\b\r=5\u0011\u0014\u0005\b\u0007#C\u0002\u0019ABJ\u0003\r)(\u000f\u001c\t\u0005\u00073\u0019)*\u0003\u0003\u0004\u0018\u000em!aA+S\u0019\"911\u0002\rA\u0002\u0005\u0005C\u0003BBO\u0007C#B!a\u0002\u0004 \"9!\u0011`\rA\u0004\tm\bbBBI3\u0001\u000711S\u0001\u0015GJ,\u0017\r^3Ck\u001a4WM]3e'>,(oY3\u0015\u0015\r\u001d61VB[\u0007o\u001bI\f\u0006\u0003\u0002\b\r%\u0006b\u0002B}5\u0001\u000f!1 \u0005\b\u0007[S\u0002\u0019ABX\u0003-Ig\u000e];u'R\u0014X-Y7\u0011\t\u0005-2\u0011W\u0005\u0005\u0007g\u000biCA\u0006J]B,Ho\u0015;sK\u0006l\u0007\u0002CB$5A\u0005\t\u0019A?\t\u0013\t\u001d'\u0004%AA\u0002\tU\u0005\"\u0003Bb5A\u0005\t\u0019\u0001BO\u0003y\u0019'/Z1uK\n+hMZ3sK\u0012\u001cv.\u001e:dK\u0012\"WMZ1vYR$#'\u0006\u0002\u0004@*\u001aQPa\u0019\u0002=\r\u0014X-\u0019;f\u0005V4g-\u001a:fIN{WO]2fI\u0011,g-Y;mi\u0012\u001aTCABcU\u0011\u0011)Ja\u0019\u0002=\r\u0014X-\u0019;f\u0005V4g-\u001a:fIN{WO]2fI\u0011,g-Y;mi\u0012\"TCABfU\u0011\u0011iJa\u0019\u0002\u001f\u0019\u0014x.\\%oaV$8\u000b\u001e:fC6$b!a\u0002\u0004R\u000eU\u0007bBBj=\u0001\u00071qV\u0001\u0003SNDqaa\u0003\u001f\u0001\u0004\t\t\u0005\u0006\u0003\u0004Z\u000euG\u0003BA\u0004\u00077DqA!? \u0001\b\u0011Y\u0010C\u0004\u0004T~\u0001\raa,\u0002\u0019\u0019\u0014x.\u001c*fg>,(oY3\u0015\r\r\r8q]Bv)\u0011\t9a!:\t\u000f\te\b\u0005q\u0001\u0003|\"91\u0011\u001e\u0011A\u0002\u0005\u0005\u0013\u0001\u0003:fg>,(oY3\t\u0013\r5\b\u0005%AA\u0002\r=\u0018aC2mCN\u001cHj\\1eKJ\u0004B!!4\u0004r&!11_Ah\u0005-\u0019E.Y:t\u0019>\fG-\u001a:\u0002-\u0019\u0014x.\u001c*fg>,(oY3%I\u00164\u0017-\u001e7uII*\"a!?+\t\r=(1\r")
public abstract class Source
implements Iterator<Object>,
Closeable {
    private volatile Source$RelaxedPosition$ RelaxedPosition$module;
    private volatile Source$RelaxedPositioner$ RelaxedPositioner$module;
    private volatile Source$NoPositioner$ NoPositioner$module;
    private String descr;
    private int nerrors;
    private int nwarnings;
    private Function0<Source> resetFunction;
    private Function0<BoxedUnit> closeFunction;
    private Positioner positioner;

    public static ClassLoader fromResource$default$2() {
        return Source$.MODULE$.fromResource$default$2();
    }

    public static BufferedSource fromResource(String string, ClassLoader classLoader, Codec codec) {
        return Source$.MODULE$.fromResource(string, classLoader, codec);
    }

    public static BufferedSource fromInputStream(InputStream inputStream2, Codec codec) {
        return Source$.MODULE$.fromInputStream(inputStream2, codec);
    }

    public static BufferedSource fromInputStream(InputStream inputStream2, String string) {
        return Source$.MODULE$.fromInputStream(inputStream2, string);
    }

    public static Function0<BoxedUnit> createBufferedSource$default$4() {
        return Source$.MODULE$.createBufferedSource$default$4();
    }

    public static Function0<Source> createBufferedSource$default$3() {
        return Source$.MODULE$.createBufferedSource$default$3();
    }

    public static int createBufferedSource$default$2() {
        return Source$.MODULE$.createBufferedSource$default$2();
    }

    public static BufferedSource createBufferedSource(InputStream inputStream2, int n, Function0<Source> intersect, Function0<BoxedUnit> function0, Codec codec) {
        if (Source$.MODULE$ == null) {
            throw null;
        }
        Function0<BufferedSource> & java.io.Serializable & Serializable createBufferedSource_resetFn = intersect == null ? () -> Source$.$anonfun$createBufferedSource$1(inputStream2, n, null, function0, codec) : intersect;
        return (BufferedSource)new BufferedSource(inputStream2, n, codec).withReset((Function0<Source>)createBufferedSource_resetFn).withClose(function0);
    }

    public static BufferedSource fromURL(URL uRL, Codec codec) {
        return Source$.MODULE$.fromURL(uRL, codec);
    }

    public static BufferedSource fromURL(URL uRL, String string) {
        return Source$.MODULE$.fromURL(uRL, string);
    }

    public static BufferedSource fromURL(String string, Codec codec) {
        return Source$.MODULE$.fromURL(string, codec);
    }

    public static BufferedSource fromURL(String string, String string2) {
        return Source$.MODULE$.fromURL(string, string2);
    }

    public static BufferedSource fromURI(URI uRI, Codec codec) {
        return Source$.MODULE$.fromURI(uRI, codec);
    }

    public static Source fromRawBytes(byte[] byArray) {
        return Source$.MODULE$.fromRawBytes(byArray);
    }

    public static Source fromBytes(byte[] byArray, String string) {
        return Source$.MODULE$.fromBytes(byArray, string);
    }

    public static Source fromBytes(byte[] byArray, Codec codec) {
        return Source$.MODULE$.fromBytes(byArray, codec);
    }

    public static BufferedSource fromFile(File file, int n, Codec codec) {
        return Source$.MODULE$.fromFile(file, n, codec);
    }

    public static BufferedSource fromFile(File file, String string, int n) {
        return Source$.MODULE$.fromFile(file, string, n);
    }

    public static BufferedSource fromFile(File file, String string) {
        return Source$.MODULE$.fromFile(file, string);
    }

    public static BufferedSource fromFile(File file, Codec codec) {
        return Source$.MODULE$.fromFile(file, codec);
    }

    public static BufferedSource fromFile(URI uRI, String string) {
        return Source$.MODULE$.fromFile(uRI, string);
    }

    public static BufferedSource fromFile(URI uRI, Codec codec) {
        return Source$.MODULE$.fromFile(uRI, codec);
    }

    public static BufferedSource fromFile(String string, String string2) {
        return Source$.MODULE$.fromFile(string, string2);
    }

    public static BufferedSource fromFile(String string, Codec codec) {
        return Source$.MODULE$.fromFile(string, codec);
    }

    public static Source fromString(String string) {
        return Source$.MODULE$.fromString(string);
    }

    public static Source fromChars(char[] cArray) {
        return Source$.MODULE$.fromChars(cArray);
    }

    public static Source fromChar(char c) {
        return Source$.MODULE$.fromChar(c);
    }

    public static Source fromIterable(Iterable<Object> iterable) {
        return Source$.MODULE$.fromIterable(iterable);
    }

    public static BufferedSource stdin() {
        return Source$.MODULE$.stdin();
    }

    public static int DefaultBufSize() {
        return Source$.MODULE$.DefaultBufSize();
    }

    @Override
    public Iterator<Object> seq() {
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
    public Iterator<Object> take(int n) {
        return Iterator.take$(this, n);
    }

    @Override
    public Iterator<Object> drop(int n) {
        return Iterator.drop$(this, n);
    }

    @Override
    public Iterator<Object> slice(int from, int until) {
        return Iterator.slice$(this, from, until);
    }

    @Override
    public Iterator<Object> sliceIterator(int from, int until) {
        return Iterator.sliceIterator$(this, from, until);
    }

    @Override
    public <B> Iterator<B> map(Function1<Object, B> f) {
        return Iterator.map$(this, f);
    }

    @Override
    public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
        return Iterator.$plus$plus$(this, that);
    }

    @Override
    public <B> Iterator<B> flatMap(Function1<Object, GenTraversableOnce<B>> f) {
        return Iterator.flatMap$(this, f);
    }

    @Override
    public Iterator<Object> filter(Function1<Object, Object> p) {
        return Iterator.filter$(this, p);
    }

    @Override
    public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Object, B, Object> p) {
        return Iterator.corresponds$(this, that, p);
    }

    @Override
    public Iterator<Object> withFilter(Function1<Object, Object> p) {
        return Iterator.withFilter$(this, p);
    }

    @Override
    public Iterator<Object> filterNot(Function1<Object, Object> p) {
        return Iterator.filterNot$(this, p);
    }

    @Override
    public <B> Iterator<B> collect(PartialFunction<Object, B> pf) {
        return Iterator.collect$(this, pf);
    }

    @Override
    public <B> Iterator<B> scanLeft(B z, Function2<B, Object, B> op) {
        return Iterator.scanLeft$(this, z, op);
    }

    @Override
    public <B> Iterator<B> scanRight(B z, Function2<Object, B, B> op) {
        return Iterator.scanRight$(this, z, op);
    }

    @Override
    public Iterator<Object> takeWhile(Function1<Object, Object> p) {
        return Iterator.takeWhile$(this, p);
    }

    @Override
    public Tuple2<Iterator<Object>, Iterator<Object>> partition(Function1<Object, Object> p) {
        return Iterator.partition$(this, p);
    }

    @Override
    public Tuple2<Iterator<Object>, Iterator<Object>> span(Function1<Object, Object> p) {
        return Iterator.span$(this, p);
    }

    @Override
    public Iterator<Object> dropWhile(Function1<Object, Object> p) {
        return Iterator.dropWhile$(this, p);
    }

    @Override
    public <B> Iterator<Tuple2<Object, B>> zip(Iterator<B> that) {
        return Iterator.zip$(this, that);
    }

    @Override
    public <A1> Iterator<A1> padTo(int len, A1 elem) {
        return Iterator.padTo$(this, len, elem);
    }

    @Override
    public Iterator<Tuple2<Object, Object>> zipWithIndex() {
        return Iterator.zipWithIndex$(this);
    }

    @Override
    public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
        return Iterator.zipAll$(this, that, thisElem, thatElem);
    }

    @Override
    public <U> void foreach(Function1<Object, U> f) {
        Iterator.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<Object, Object> p) {
        return Iterator.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Object, Object> p) {
        return Iterator.exists$(this, p);
    }

    @Override
    public boolean contains(Object elem) {
        return Iterator.contains$(this, elem);
    }

    @Override
    public Option<Object> find(Function1<Object, Object> p) {
        return Iterator.find$(this, p);
    }

    @Override
    public int indexWhere(Function1<Object, Object> p) {
        return Iterator.indexWhere$(this, p);
    }

    @Override
    public int indexWhere(Function1<Object, Object> p, int from) {
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
    public BufferedIterator<Object> buffered() {
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
    public Tuple2<Iterator<Object>, Iterator<Object>> duplicate() {
        return Iterator.duplicate$(this);
    }

    @Override
    public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
        return Iterator.patch$(this, from, patchElems, replaced);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        Iterator.copyToArray$(this, xs, start, len);
    }

    @Override
    public boolean sameElements(Iterator<?> that) {
        return Iterator.sameElements$(this, that);
    }

    @Override
    public Traversable<Object> toTraversable() {
        return Iterator.toTraversable$(this);
    }

    @Override
    public Iterator<Object> toIterator() {
        return Iterator.toIterator$(this);
    }

    @Override
    public Stream<Object> toStream() {
        return Iterator.toStream$(this);
    }

    @Override
    public String toString() {
        return Iterator.toString$(this);
    }

    @Override
    public List<Object> reversed() {
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
    public <B> B foldLeft(B z, Function2<B, Object, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B foldRight(B z, Function2<Object, B, B> op) {
        return (B)TraversableOnce.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, Object, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> B reduceRight(Function2<Object, B, B> op) {
        return (B)TraversableOnce.reduceRight$(this, op);
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
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public List<Object> toList() {
        return TraversableOnce.toList$(this);
    }

    @Override
    public Iterable<Object> toIterable() {
        return TraversableOnce.toIterable$(this);
    }

    @Override
    public Seq<Object> toSeq() {
        return TraversableOnce.toSeq$(this);
    }

    @Override
    public IndexedSeq<Object> toIndexedSeq() {
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
    public Vector<Object> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, Object, Col> cbf) {
        return (Col)TraversableOnce.to$(this, cbf);
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
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    public Source$RelaxedPosition$ RelaxedPosition() {
        if (this.RelaxedPosition$module == null) {
            this.RelaxedPosition$lzycompute$1();
        }
        return this.RelaxedPosition$module;
    }

    public Source$RelaxedPositioner$ RelaxedPositioner() {
        if (this.RelaxedPositioner$module == null) {
            this.RelaxedPositioner$lzycompute$1();
        }
        return this.RelaxedPositioner$module;
    }

    public Source$NoPositioner$ NoPositioner() {
        if (this.NoPositioner$module == null) {
            this.NoPositioner$lzycompute$1();
        }
        return this.NoPositioner$module;
    }

    public abstract Iterator<Object> iter();

    public String descr() {
        return this.descr;
    }

    public void descr_$eq(String x$1) {
        this.descr = x$1;
    }

    public int nerrors() {
        return this.nerrors;
    }

    public void nerrors_$eq(int x$1) {
        this.nerrors = x$1;
    }

    public int nwarnings() {
        return this.nwarnings;
    }

    public void nwarnings_$eq(int x$1) {
        this.nwarnings = x$1;
    }

    private String lineNum(int line) {
        return this.getLines().drop(line - 1).take(1).mkString();
    }

    public Iterator<String> getLines() {
        return new LineIterator();
    }

    @Override
    public boolean hasNext() {
        return this.iter().hasNext();
    }

    @Override
    public char next() {
        return this.positioner.next();
    }

    public char ch() {
        return this.positioner.ch();
    }

    public int pos() {
        return this.positioner.pos();
    }

    public void reportError(int pos, String msg, PrintStream out) {
        this.nerrors_$eq(this.nerrors() + 1);
        this.report(pos, msg, out);
    }

    private String spaces(int n) {
        List$ list$ = List$.MODULE$;
        if (list$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)list$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(BoxesRunTime.boxToCharacter(Source.$anonfun$spaces$1()));
        }
        return ((TraversableOnce)((Object)((GenTraversable)fill_b.result()))).mkString();
    }

    public void report(int pos, String msg, PrintStream out) {
        int line = Position$.MODULE$.line(pos);
        int col = Position$.MODULE$.column(pos);
        String string = "%s:%d:%d: %s%s%s^";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        out.println(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{this.descr(), BoxesRunTime.boxToInteger(line), BoxesRunTime.boxToInteger(col), msg, this.lineNum(line), this.spaces(col - 1)})));
    }

    public PrintStream reportError$default$3() {
        return Console$.MODULE$.err();
    }

    public void reportWarning(int pos, String msg, PrintStream out) {
        this.nwarnings_$eq(this.nwarnings() + 1);
        this.report(pos, new java.lang.StringBuilder(9).append("warning! ").append(msg).toString(), out);
    }

    public PrintStream reportWarning$default$3() {
        return Console$.MODULE$.out();
    }

    public Source withReset(Function0<Source> f) {
        this.resetFunction = f;
        return this;
    }

    public Source withClose(Function0<BoxedUnit> f) {
        this.closeFunction = f;
        return this;
    }

    public Source withDescription(String text) {
        this.descr_$eq(text);
        return this;
    }

    public Source withPositioning(boolean on) {
        this.positioner = on ? this.RelaxedPositioner() : this.NoPositioner();
        return this;
    }

    public Source withPositioning(Positioner pos) {
        this.positioner = pos;
        return this;
    }

    @Override
    public void close() {
        if (this.closeFunction != null) {
            this.closeFunction.apply$mcV$sp();
        }
    }

    public Source reset() {
        if (this.resetFunction != null) {
            return this.resetFunction.apply();
        }
        throw new UnsupportedOperationException("Source's reset() method was not set.");
    }

    private final void RelaxedPosition$lzycompute$1() {
        synchronized (this) {
            if (this.RelaxedPosition$module == null) {
                this.RelaxedPosition$module = new Source$RelaxedPosition$(this);
            }
            return;
        }
    }

    private final void RelaxedPositioner$lzycompute$1() {
        synchronized (this) {
            if (this.RelaxedPositioner$module == null) {
                this.RelaxedPositioner$module = new Source$RelaxedPositioner$(this);
            }
            return;
        }
    }

    private final void NoPositioner$lzycompute$1() {
        synchronized (this) {
            if (this.NoPositioner$module == null) {
                this.NoPositioner$module = new Source$NoPositioner$(this);
            }
            return;
        }
    }

    public static final /* synthetic */ char $anonfun$spaces$1() {
        return ' ';
    }

    public Source() {
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Iterator.$init$(this);
        this.descr = "";
        this.nerrors = 0;
        this.nwarnings = 0;
        this.resetFunction = null;
        this.closeFunction = null;
        this.positioner = this.RelaxedPositioner();
    }

    public class LineIterator
    extends AbstractIterator<String> {
        private BufferedIterator<Object> iter;
        private final StringBuilder sb;
        private volatile boolean bitmap$0;

        private BufferedIterator<Object> iter$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.iter = this.scala$io$Source$LineIterator$$$outer().iter().buffered();
                    this.bitmap$0 = true;
                }
            }
            return this.iter;
        }

        public BufferedIterator<Object> iter() {
            if (!this.bitmap$0) {
                return this.iter$lzycompute();
            }
            return this.iter;
        }

        public boolean isNewline(char ch) {
            return ch == '\r' || ch == '\n';
        }

        public boolean getc() {
            if (this.iter().hasNext()) {
                boolean bl;
                char ch = BoxesRunTime.unboxToChar(this.iter().next());
                if (ch == '\n') {
                    bl = false;
                } else if (ch == '\r') {
                    if (this.iter().hasNext() && BoxesRunTime.unboxToChar(this.iter().head()) == '\n') {
                        this.iter().next();
                    }
                    bl = false;
                } else {
                    this.sb.append(ch);
                    bl = true;
                }
                if (bl) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean hasNext() {
            return this.iter().hasNext();
        }

        @Override
        public String next() {
            this.sb.clear();
            while (this.getc()) {
            }
            return this.sb.toString();
        }

        public /* synthetic */ Source scala$io$Source$LineIterator$$$outer() {
            return Source.this;
        }

        public LineIterator() {
            if (Source.this == null) {
                throw null;
            }
            this.sb = new StringBuilder();
        }
    }

    public class Positioner {
        private final Position encoder;
        private char ch;
        private int pos;
        private int cline;
        private int ccol;
        private int tabinc;
        public final /* synthetic */ Source $outer;

        public char ch() {
            return this.ch;
        }

        public void ch_$eq(char x$1) {
            this.ch = x$1;
        }

        public int pos() {
            return this.pos;
        }

        public void pos_$eq(int x$1) {
            this.pos = x$1;
        }

        public int cline() {
            return this.cline;
        }

        public void cline_$eq(int x$1) {
            this.cline = x$1;
        }

        public int ccol() {
            return this.ccol;
        }

        public void ccol_$eq(int x$1) {
            this.ccol = x$1;
        }

        public int tabinc() {
            return this.tabinc;
        }

        public void tabinc_$eq(int x$1) {
            this.tabinc = x$1;
        }

        public char next() {
            this.ch_$eq(BoxesRunTime.unboxToChar(this.scala$io$Source$Positioner$$$outer().iter().next()));
            this.pos_$eq(this.encoder.encode(this.cline(), this.ccol()));
            switch (this.ch()) {
                case '\n': {
                    this.ccol_$eq(1);
                    this.cline_$eq(this.cline() + 1);
                    break;
                }
                case '\t': {
                    this.ccol_$eq(this.ccol() + this.tabinc());
                    break;
                }
                default: {
                    this.ccol_$eq(this.ccol() + 1);
                }
            }
            return this.ch();
        }

        public /* synthetic */ Source scala$io$Source$Positioner$$$outer() {
            return this.$outer;
        }

        public Positioner(Source $outer, Position encoder) {
            this.encoder = encoder;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.pos = 0;
            this.cline = 1;
            this.ccol = 1;
            this.tabinc = 4;
        }

        public Positioner(Source $outer) {
            this($outer, $outer.RelaxedPosition());
        }
    }
}

