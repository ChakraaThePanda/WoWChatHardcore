/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.SliceInterval;
import scala.collection.generic.SliceInterval$;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream$;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\rufaB'O!\u0003\r\ta\u0015\u0005\u0007\u007f\u0002!\t!!\u0001\u0007\u0011\u0005%\u0001!!\u0001O\u0003\u0017Aq!a\u001b\u0003\t\u0003\tiGB\u0005\u0002\u001e\u0001\u0001\n1!\u0001\u0002\"!1q\u0010\u0002C\u0001\u0003\u0003Aq!!\f\u0005\r\u0003\ty\u0003C\u0004\u00028\u0011!\t%!\u000f\t\u000f\u00055C\u0001\"\u0011\u0002P!9\u0011\u0011\r\u0003\u0005B\u0005\rd!CA9\u0001A\u0005\u0019\u0011AA:\u0011\u0019y(\u0002\"\u0001\u0002\u0002!9\u0011Q\u0006\u0006\u0005\u0006\u0005md!CA@\u0001A\u0005\u0019\u0011AAA\u0011\u0019yX\u0002\"\u0001\u0002\u0002!9\u0011QF\u0007\u0005\u0002\u0005=e!CAJ\u0001A\u0005\u0019\u0011AAK\u0011\u0019y\b\u0003\"\u0001\u0002\u0002!9\u0011Q\u0006\t\u0005\u0002\u0005ue!CAQ\u0001A\u0005\u0019\u0011AAR\u0011\u0019y8\u0003\"\u0001\u0002\u0002!9\u0011QF\n\u0005\u0002\u0005Ef!CA[\u0001A\u0005\u0019\u0011AA\\\u0011\u0019yh\u0003\"\u0001\u0002\u0002!9\u0011Q\u0006\f\u0005\u0002\u0005\u0015g!CAe\u0001A\u0005\u0019\u0011AAf\u0011\u0019y\u0018\u0004\"\u0001\u0002\u0002!9\u0011QF\r\u0005\u0002\u0005mg!CAp\u0001A\u0005\u0019\u0011AAq\u0011\u0019yH\u0004\"\u0001\u0002\u0002!9\u0011Q\u0006\u000f\u0005\u0002\u0005=h!CAz\u0001A\u0005\u0019\u0011AA{\u0011\u0019yx\u0004\"\u0001\u0002\u0002!9\u0011QF\u0010\u0005\u0002\u0005ue!CA~\u0001A\u0005\u0019\u0011AA\u007f\u0011\u0019y(\u0005\"\u0001\u0002\u0002!9\u0011Q\u0006\u0012\u0005\u0002\u0005ue!\u0003B\u0002\u0001A\u0005\u0019\u0011\u0001B\u0003\u0011\u0019yX\u0005\"\u0001\u0002\u0002!9\u0011QF\u0013\u0005\u0002\u0005ue!\u0003B\u0006\u0001A\u0005\u0019\u0011\u0001B\u0007\u0011\u0019y\b\u0006\"\u0001\u0002\u0002!I!Q\u0004\u0015CB\u001bE!q\u0004\u0005\b\u0003[AC\u0011\u0001B\u0014\u0011!\u0011Y\u0003\u000bQ\u0005V\t5b!\u0003B\u0018\u0001A\u0005\u0019\u0011\u0001B\u0019\u0011\u0019yX\u0006\"\u0001\u0002\u0002!I!QD\u0017CB\u001bE!1\t\u0005\n\u0005\u000fj#\u0019)D\t\u0005\u0013B\u0011Ba\u0013.\u0005\u00046\tB!\u0014\t\u0011\t-R\u0006)C+\u0005[Aq!!\f.\t\u0003\u0011y\u0005\u0003\u0005\u0003T\u0001\u0001K1\u0002B+\u0011\u001d\u0011Y\u0006\u0001C\t\u0005;BqAa\u001c\u0001\t#\u0011\t\bC\u0004\u0003\u000e\u0002!\tFa$\t\u000f\t\u001d\u0006\u0001\"\u0015\u0003*\"9!1\u0018\u0001\u0005R\tu\u0006b\u0002Bf\u0001\u0011E#Q\u001a\u0005\b\u00057\u0004A\u0011\u000bBo\u0011\u001d\u0011\t\u0010\u0001C)\u0005gDqAa?\u0001\t#\u0012i\u0010C\u0004\u0004\u0010\u0001!\tf!\u0005\t\u000f\rU\u0001\u0001\"\u0015\u0004\u0018!911\u0004\u0001\u0005R\ru\u0001bBB\u0015\u0001\u0011E31\u0006\u0005\b\u0007_\u0001A\u0011IB\u0019\u0011\u001d\u0019)\u0004\u0001C!\u0007oAqaa\u000f\u0001\t\u0003\u001ai\u0004C\u0004\u0004b\u0001!\tea\u0019\t\u000f\rU\u0004\u0001\"\u0011\u0004x!91q\u0013\u0001\u0005B\re\u0005bBBQ\u0001\u0011\u000531\u0015\u0005\b\u0007C\u0003A\u0011IBV\u0011\u001d\u0019y\u000b\u0001C!\u0007cCqa!.\u0001\t\u0003\u001a9\fC\u0004\u0004<\u0002!\tE!\f\u0003!%#XM]1cY\u00164\u0016.Z<MS.,'BA(Q\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002#\u0006)1oY1mC\u000e\u0001Q\u0003\u0002+`m2\u001cb\u0001A+ZQfd\bC\u0001,X\u001b\u0005\u0001\u0016B\u0001-Q\u0005\u0019\te.\u001f*fMB\u0019!lW/\u000e\u00039K!\u0001\u0018(\u0003\u0011%#XM]1cY\u0016\u0004\"AX0\r\u0001\u00111\u0001\r\u0001CC\u0002\u0005\u0014\u0011!Q\t\u0003E\u0016\u0004\"AV2\n\u0005\u0011\u0004&a\u0002(pi\"Lgn\u001a\t\u0003-\u001aL!a\u001a)\u0003\u0007\u0005s\u0017\u0010\u0005\u0003[Sv[\u0017B\u00016O\u00051IE/\u001a:bE2,G*[6f!\tqF\u000e\u0002\u0004n\u0001\u0011\u0015\rA\u001c\u0002\u0005)\"L7/\u0005\u0002c_J\u0019\u0001O\u001d=\u0007\tE\u0004\u0001a\u001c\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u00055NlV/\u0003\u0002u\u001d\na\u0011\n^3sC\ndWMV5foB\u0011aL\u001e\u0003\u0007o\u0002!)\u0019A1\u0003\t\r{G\u000e\u001c\t\u00065\u0002iVo\u001b\t\u00055jlV/\u0003\u0002|\u001d\nyAK]1wKJ\u001c\u0018M\u00197f-&,w\u000fE\u0003[{v+8.\u0003\u0002\u007f\u001d\n\u0019BK]1wKJ\u001c\u0018M\u00197f-&,w\u000fT5lK\u00061A%\u001b8ji\u0012\"\"!a\u0001\u0011\u0007Y\u000b)!C\u0002\u0002\bA\u0013A!\u00168ji\n\u0019\u0012IY:ue\u0006\u001cG\u000f\u0016:b]N4wN]7fIV!\u0011QBA\n'!\u0011Q+a\u0004\u0002\u0018\u0005}\u0001\u0003\u0002.\\\u0003#\u00012AXA\n\t\u001d\t)B\u0001CC\u0002\u0005\u0014\u0011A\u0011\t\u0007\u00033\tY\"!\u0005\u000e\u0003\u0001I1!!\b~\u0005-!&/\u00198tM>\u0014X.\u001a3\u0011\u000b\u0005eA!!\u0005\u0016\t\u0005\r\u0012\u0011F\n\u0007\tU\u000b)#a\u000b\u0011\u000bi\u001b\u0018qE;\u0011\u0007y\u000bI\u0003B\u0004\u0002\u0016\u0011!)\u0019A1\u0011\r\u0005e\u00111DA\u0014\u0003!IG/\u001a:bi>\u0014XCAA\u0019!\u0015Q\u00161GA\u0014\u0013\r\t)D\u0014\u0002\t\u0013R,'/\u0019;pe\u00069am\u001c:fC\u000eDW\u0003BA\u001e\u0003\u0013\"B!a\u0001\u0002>!9\u0011qH\u0004A\u0002\u0005\u0005\u0013!\u00014\u0011\u000fY\u000b\u0019%a\n\u0002H%\u0019\u0011Q\t)\u0003\u0013\u0019+hn\u0019;j_:\f\u0004c\u00010\u0002J\u00111\u00111J\u0004C\u0002\u0005\u0014\u0011!V\u0001\ti>\u001cFO]5oOR\u0011\u0011\u0011\u000b\t\u0005\u0003'\ni&\u0004\u0002\u0002V)!\u0011qKA-\u0003\u0011a\u0017M\\4\u000b\u0005\u0005m\u0013\u0001\u00026bm\u0006LA!a\u0018\u0002V\t11\u000b\u001e:j]\u001e\fq![:F[B$\u00180\u0006\u0002\u0002fA\u0019a+a\u001a\n\u0007\u0005%\u0004KA\u0004C_>dW-\u00198\u0002\rqJg.\u001b;?)\t\ty\u0007E\u0003\u0002\u001a\t\t\tBA\u0005F[B$\u0018PV5foN1!\"VA;\u0003o\u0002B!!\u0007\u0005EB!\u0011\u0011DA=\u0013\r\t\t(`\u000b\u0003\u0003{\u0002BAWA\u001aE\n1ai\u001c:dK\u0012,B!a!\u0002\fN1Q\"VAC\u0003\u001b\u0003b!!\u0007\u0002\b\u0006%\u0015bAA@{B\u0019a,a#\u0005\r\u0005UQB1\u0001b!\u0015\tI\u0002BAE+\t\t\t\nE\u0003[\u0003g\tII\u0001\u0004TY&\u001cW\rZ\n\u0007!U\u000b9*a'\u0011\t\u0005e\u0011\u0011T\u0005\u0004\u0003'k\b\u0003BA\r\tu+\"!a(\u0011\ti\u000b\u0019$\u0018\u0002\u0007\u001b\u0006\u0004\b/\u001a3\u0016\t\u0005\u0015\u0016QV\n\u0007'U\u000b9+a,\u0011\r\u0005e\u0011\u0011VAV\u0013\r\t\t+ \t\u0004=\u00065FABA\u000b'\t\u0007\u0011\rE\u0003\u0002\u001a\u0011\tY+\u0006\u0002\u00024B)!,a\r\u0002,\nQa\t\\1u\u001b\u0006\u0004\b/\u001a3\u0016\t\u0005e\u0016\u0011Y\n\u0007-U\u000bY,a1\u0011\r\u0005e\u0011QXA`\u0013\r\t), \t\u0004=\u0006\u0005GABA\u000b-\t\u0007\u0011\rE\u0003\u0002\u001a\u0011\ty,\u0006\u0002\u0002HB)!,a\r\u0002@\nA\u0011\t\u001d9f]\u0012,G-\u0006\u0003\u0002N\u0006U7CB\rV\u0003\u001f\fI\u000e\u0005\u0004\u0002\u001a\u0005E\u00171[\u0005\u0004\u0003\u0013l\bc\u00010\u0002V\u00129\u0011QC\rC\u0002\u0005]\u0017CA/f!\u0015\tI\u0002BAj+\t\ti\u000eE\u0003[\u0003g\t\u0019NA\u0005Qe\u0016\u0004XM\u001c3fIV!\u00111]Av'\u0019aR+!:\u0002nB1\u0011\u0011DAt\u0003SL1!a8~!\rq\u00161\u001e\u0003\b\u0003+a\"\u0019AAl!\u0015\tI\u0002BAu+\t\t\t\u0010E\u0003[\u0003g\tIO\u0001\u0005GS2$XM]3e'\u0019yR+a>\u0002\u001cB!\u0011\u0011DA}\u0013\r\t\u00190 \u0002\u000b)\u0006\\WM\\,iS2,7C\u0002\u0012V\u0003\u007f\fY\n\u0005\u0003\u0002\u001a\t\u0005\u0011bAA~{\naAI]8qa\u0016$w\u000b[5mKN1Q%\u0016B\u0004\u00037\u0003B!!\u0007\u0003\n%\u0019!1A?\u0003\riK\u0007\u000f]3e+\u0011\u0011yAa\u0007\u0014\t!*&\u0011\u0003\t\u0006\u00033!!1\u0003\t\u0007-\nUQL!\u0007\n\u0007\t]\u0001K\u0001\u0004UkBdWM\r\t\u0004=\nmAABA\u000bQ\t\u0007\u0011-A\u0003pi\",'/\u0006\u0002\u0003\"A)!La\t\u0003\u001a%\u0019!Q\u0005(\u0003\u0017\u001d+g.\u0013;fe\u0006\u0014G.Z\u000b\u0003\u0005S\u0001RAWA\u001a\u0005'\taB^5fo&#WM\u001c;jM&,'/\u0006\u0002\u0002R\tI!,\u001b9qK\u0012\fE\u000e\\\u000b\u0007\u0005g\u0011YD!\u0011\u0014\t5*&Q\u0007\t\u0006\u00033!!q\u0007\t\b-\nU!\u0011\bB !\rq&1\b\u0003\b\u0005{i#\u0019AAl\u0005\t\t\u0015\u0007E\u0002_\u0005\u0003\"a!!\u0006.\u0005\u0004\tWC\u0001B#!\u0015Q&1\u0005B \u0003!!\b.[:FY\u0016lWC\u0001B\u001d\u0003!!\b.\u0019;FY\u0016lWC\u0001B +\t\u0011\t\u0006E\u0003[\u0003g\u00119$\u0001\u0004bgRC\u0017n\u001d\u000b\u0004W\n]\u0003b\u0002B-i\u0001\u0007\u00111T\u0001\u0003qN\f\u0011B\\3x5&\u0004\b/\u001a3\u0016\t\t}#q\r\u000b\u0005\u0005C\u0012I\u0007E\u0003\u0002\u001a\u0011\u0011\u0019\u0007\u0005\u0004W\u0005+i&Q\r\t\u0004=\n\u001dDABA\u000bk\t\u0007\u0011\rC\u0004\u0003lU\u0002\rA!\u001c\u0002\tQD\u0017\r\u001e\t\u00065\n\r\"QM\u0001\r]\u0016<(,\u001b9qK\u0012\fE\u000e\\\u000b\u0007\u0005g\u0012YHa \u0015\u0011\tU$\u0011\u0011BC\u0005\u0013\u0003R!!\u0007\u0005\u0005o\u0002rA\u0016B\u000b\u0005s\u0012i\bE\u0002_\u0005w\"qA!\u00107\u0005\u0004\t9\u000eE\u0002_\u0005\u007f\"a!!\u00067\u0005\u0004\t\u0007b\u0002B6m\u0001\u0007!1\u0011\t\u00065\n\r\"Q\u0010\u0005\b\u0005\u000f3\u0004\u0019\u0001B=\u0003%yF\u000f[5t\u000b2,W\u000eC\u0004\u0003\fZ\u0002\rA! \u0002\u0013}#\b.\u0019;FY\u0016l\u0017!\u00038fo\u001a{'oY3e+\u0011\u0011\tJa&\u0015\t\tM%\u0011\u0014\t\u0006\u00033!!Q\u0013\t\u0004=\n]EABA\u000bo\t\u0007\u0011\r\u0003\u0005\u0003Z]\"\t\u0019\u0001BN!\u00151&Q\u0014BQ\u0013\r\u0011y\n\u0015\u0002\ty\tLh.Y7f}A)!La)\u0003\u0016&\u0019!Q\u0015(\u0003\r\u001d+gnU3r\u0003-qWm^!qa\u0016tG-\u001a3\u0016\t\t-&\u0011\u0017\u000b\u0005\u0005[\u0013\u0019\fE\u0003\u0002\u001a\u0011\u0011y\u000bE\u0002_\u0005c#q!!\u00069\u0005\u0004\t9\u000eC\u0004\u0003la\u0002\rA!.\u0011\u000bi\u00139La,\n\u0007\tefJ\u0001\bHK:$&/\u0019<feN\f'\r\\3\u0002\u00199,w\u000f\u0015:fa\u0016tG-\u001a3\u0016\t\t}&Q\u0019\u000b\u0005\u0005\u0003\u00149\rE\u0003\u0002\u001a\u0011\u0011\u0019\rE\u0002_\u0005\u000b$q!!\u0006:\u0005\u0004\t9\u000eC\u0004\u0003le\u0002\rA!3\u0011\u000bi\u00139La1\u0002\u00139,w/T1qa\u0016$W\u0003\u0002Bh\u0005+$BA!5\u0003XB)\u0011\u0011\u0004\u0003\u0003TB\u0019aL!6\u0005\r\u0005U!H1\u0001b\u0011\u001d\tyD\u000fa\u0001\u00053\u0004bAVA\";\nM\u0017!\u00048fo\u001ac\u0017\r^'baB,G-\u0006\u0003\u0003`\n\u0015H\u0003\u0002Bq\u0005O\u0004R!!\u0007\u0005\u0005G\u00042A\u0018Bs\t\u0019\t)b\u000fb\u0001C\"9\u0011qH\u001eA\u0002\t%\bC\u0002,\u0002Du\u0013Y\u000fE\u0003[\u0005[\u0014\u0019/C\u0002\u0003p:\u0013!cR3o)J\fg/\u001a:tC\ndWm\u00148dK\u0006Ya.Z<GS2$XM]3e)\u0011\tYJ!>\t\u000f\t]H\b1\u0001\u0003z\u0006\t\u0001\u000f\u0005\u0004W\u0003\u0007j\u0016QM\u0001\n]\u0016<8\u000b\\5dK\u0012$B!a'\u0003\u0000\"91\u0011A\u001fA\u0002\r\r\u0011AC0f]\u0012\u0004x.\u001b8ugB!1QAB\u0006\u001b\t\u00199AC\u0002\u0004\n9\u000bqaZ3oKJL7-\u0003\u0003\u0004\u000e\r\u001d!!D*mS\u000e,\u0017J\u001c;feZ\fG.A\boK^$%o\u001c9qK\u0012<\u0006.\u001b7f)\u0011\tYja\u0005\t\u000f\t]h\b1\u0001\u0003z\u0006ia.Z<UC.,gn\u00165jY\u0016$B!a'\u0004\u001a!9!q_ A\u0002\te\u0018\u0001\u00038foR\u000b7.\u001a8\u0015\t\u0005m5q\u0004\u0005\b\u0007C\u0001\u0005\u0019AB\u0012\u0003\u0005q\u0007c\u0001,\u0004&%\u00191q\u0005)\u0003\u0007%sG/\u0001\u0006oK^$%o\u001c9qK\u0012$B!a'\u0004.!91\u0011E!A\u0002\r\r\u0012\u0001\u00023s_B$2a[B\u001a\u0011\u001d\u0019\tC\u0011a\u0001\u0007G\tA\u0001^1lKR\u00191n!\u000f\t\u000f\r\u00052\t1\u0001\u0004$\u0005\u0019!0\u001b9\u0016\u0011\r}2qKB.\u0007\u000b\"Ba!\u0011\u0004^Q!11IB%!\rq6Q\t\u0003\u0007\u0007\u000f\"%\u0019A1\u0003\tQC\u0017\r\u001e\u0005\b\u0007\u0017\"\u00059AB'\u0003\t\u0011g\rE\u0005\u0004\u0006\r=3na\u0015\u0004D%!1\u0011KB\u0004\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u001d1&QCB+\u00073\u00022AXB,\t\u001d\u0011i\u0004\u0012b\u0001\u0003/\u00042AXB.\t\u0019\t)\u0002\u0012b\u0001C\"9!1\u000e#A\u0002\r}\u0003#\u0002.\u0003$\re\u0013\u0001\u0004>ja^KG\u000f[%oI\u0016DXCBB3\u0007g\u001aI\u0007\u0006\u0003\u0004h\r-\u0004c\u00010\u0004j\u001111qI#C\u0002\u0005Dqaa\u0013F\u0001\b\u0019i\u0007E\u0005\u0004\u0006\r=3na\u001c\u0004hA9aK!\u0006\u0004r\r\r\u0002c\u00010\u0004t\u00119!QH#C\u0002\u0005]\u0017A\u0002>ja\u0006cG.\u0006\u0005\u0004z\r55\u0011RB@)!\u0019Yha$\u0004\u0014\u000eUE\u0003BB?\u0007\u0003\u00032AXB@\t\u0019\u00199E\u0012b\u0001C\"911\n$A\u0004\r\r\u0005#CB\u0003\u0007\u001fZ7QQB?!\u001d1&QCBD\u0007\u0017\u00032AXBE\t\u001d\u0011iD\u0012b\u0001\u0003/\u00042AXBG\t\u0019\t)B\u0012b\u0001C\"9!1\u000e$A\u0002\rE\u0005#\u0002.\u0003$\r-\u0005b\u0002B$\r\u0002\u00071q\u0011\u0005\b\u0005\u00172\u0005\u0019ABF\u0003\u001d9'o\\;qK\u0012$Baa'\u0004\u001eB!!,a\rl\u0011\u001d\u0019yj\u0012a\u0001\u0007G\tAa]5{K\u000691\u000f\\5eS:<GCBBN\u0007K\u001b9\u000bC\u0004\u0004 \"\u0003\raa\t\t\u000f\r%\u0006\n1\u0001\u0004$\u0005!1\u000f^3q)\u0011\u0019Yj!,\t\u000f\r}\u0015\n1\u0001\u0004$\u0005IAM]8q%&<\u0007\u000e\u001e\u000b\u0004W\u000eM\u0006bBB\u0011\u0015\u0002\u000711E\u0001\ni\u0006\\WMU5hQR$2a[B]\u0011\u001d\u0019\tc\u0013a\u0001\u0007G\tAb\u001d;sS:<\u0007K]3gSb\u0004")
public interface IterableViewLike<A, Coll, This extends IterableView<A, Coll> & IterableViewLike<A, Coll, This>>
extends Iterable<A>,
TraversableView<A, Coll> {
    private This asThis(Transformed<A> xs) {
        return (This)xs;
    }

    default public <B> Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
        return new Zipped<B>(this, that){
            private final GenIterable<B> other;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<Tuple2<A, B>> iterator() {
                return Zipped.iterator$(this);
            }

            public final String viewIdentifier() {
                return Zipped.viewIdentifier$(this);
            }

            public GenIterable<B> other() {
                return this.other;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Zipped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.other = that$1;
                Zipped.$init$(this);
            }
        };
    }

    default public <A1, B> Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
        return new ZippedAll<A1, B>(this, that, _thisElem, _thatElem){
            private final GenIterable<B> other;
            private final A1 thisElem;
            private final B thatElem;
            private final /* synthetic */ IterableViewLike $outer;

            public final String viewIdentifier() {
                return ZippedAll.viewIdentifier$(this);
            }

            public Iterator<Tuple2<A1, B>> iterator() {
                return ZippedAll.iterator$(this);
            }

            public GenIterable<B> other() {
                return this.other;
            }

            public A1 thisElem() {
                return this.thisElem;
            }

            public B thatElem() {
                return this.thatElem;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$ZippedAll$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.other = that$2;
                this.thisElem = _thisElem$1;
                this.thatElem = _thatElem$1;
                ZippedAll.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
        return new Forced<B>(this, xs){
            private final GenSeq<B> forced;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<B> iterator() {
                return Forced.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Forced.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Forced.viewIdentifier$(this);
            }

            public GenSeq<B> forced() {
                return this.forced;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Forced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Forced$$$outer() {
                return this.$outer;
            }
            {
                GenSeq forced;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.forced = forced = (GenSeq)xs$1.apply();
                TraversableViewLike.Forced.$init$(this);
                Forced.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newAppended(GenTraversable<B> that) {
        return new Appended<B>(this, that){
            private final GenTraversable<B> rest;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<B> iterator() {
                return Appended.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Appended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Appended.viewIdentifier$(this);
            }

            public GenTraversable<B> rest() {
                return this.rest;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Appended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Appended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.rest = that$3;
                TraversableViewLike.Appended.$init$(this);
                Appended.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
        return new Prepended<B>(this, that){
            private final GenTraversable<B> fst;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<B> iterator() {
                return Prepended.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Prepended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Prepended.viewIdentifier$(this);
            }

            public GenTraversable<B> fst() {
                return this.fst;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Prepended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Prepended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.fst = that$4;
                TraversableViewLike.Prepended.$init$(this);
                Prepended.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newMapped(Function1<A, B> f) {
        return new Mapped<B>(this, f){
            private final Function1<A, B> mapping;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<B> iterator() {
                return Mapped.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Mapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Mapped.viewIdentifier$(this);
            }

            public Function1<A, B> mapping() {
                return this.mapping;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Mapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Mapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$1;
                TraversableViewLike.Mapped.$init$(this);
                Mapped.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
        return new FlatMapped<B>(this, f){
            private final Function1<A, GenTraversableOnce<B>> mapping;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<B> iterator() {
                return FlatMapped.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.FlatMapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.FlatMapped.viewIdentifier$(this);
            }

            public Function1<A, GenTraversableOnce<B>> mapping() {
                return this.mapping;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$2;
                TraversableViewLike.FlatMapped.$init$(this);
                FlatMapped.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newFiltered(Function1<A, Object> p) {
        return new Filtered(this, p){
            private final Function1<A, Object> pred;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<A> iterator() {
                return Filtered.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.Filtered.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Filtered.viewIdentifier$(this);
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Filtered$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$1;
                TraversableViewLike.Filtered.$init$(this);
                Filtered.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newSliced(SliceInterval _endpoints) {
        return new Sliced(this, _endpoints){
            private final SliceInterval endpoints;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<A> iterator() {
                return Sliced.iterator$(this);
            }

            public int from() {
                return TraversableViewLike.Sliced.from$(this);
            }

            public int until() {
                return TraversableViewLike.Sliced.until$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.Sliced.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Sliced.viewIdentifier$(this);
            }

            public SliceInterval endpoints() {
                return this.endpoints;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Sliced$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.endpoints = _endpoints$1;
                TraversableViewLike.Sliced.$init$(this);
                Sliced.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newDroppedWhile(Function1<A, Object> p) {
        return new DroppedWhile(this, p){
            private final Function1<A, Object> pred;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<A> iterator() {
                return DroppedWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.DroppedWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.DroppedWhile.viewIdentifier$(this);
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$2;
                TraversableViewLike.DroppedWhile.$init$(this);
                DroppedWhile.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newTakenWhile(Function1<A, Object> p) {
        return new TakenWhile(this, p){
            private final Function1<A, Object> pred;
            private final /* synthetic */ IterableViewLike $outer;

            public Iterator<A> iterator() {
                return TakenWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.TakenWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.TakenWhile.viewIdentifier$(this);
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$3;
                TraversableViewLike.TakenWhile.$init$(this);
                TakenWhile.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newTaken(int n) {
        return this.newSliced(SliceInterval$.MODULE$.apply(0, n));
    }

    @Override
    default public Transformed<A> newDropped(int n) {
        return this.newSliced(SliceInterval$.MODULE$.apply(n, Integer.MAX_VALUE));
    }

    @Override
    default public This drop(int n) {
        return this.asThis(this.newDropped(n));
    }

    @Override
    default public This take(int n) {
        return this.asThis(this.newTaken(n));
    }

    @Override
    default public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<This, Tuple2<A1, B>, That> bf) {
        return (That)this.newZipped(that);
    }

    @Override
    default public <A1, That> That zipWithIndex(CanBuildFrom<This, Tuple2<A1, Object>, That> bf) {
        return this.zip((GenIterable<B>)Stream$.MODULE$.from(0), (CanBuildFrom)bf);
    }

    @Override
    default public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<This, Tuple2<A1, B>, That> bf) {
        return (That)this.newZippedAll(that, thisElem, thatElem);
    }

    @Override
    default public Iterator<This> grouped(int size) {
        return this.iterator().grouped(size).map((Function1<Seq, IterableView> & java.io.Serializable & Serializable)x -> this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> x));
    }

    @Override
    default public Iterator<This> sliding(int size, int step) {
        return this.iterator().sliding(size, step).map((Function1<Seq, IterableView> & java.io.Serializable & Serializable)x -> this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> x));
    }

    @Override
    default public Iterator<This> sliding(int size) {
        return this.sliding(size, 1);
    }

    @Override
    default public This dropRight(int n) {
        return this.take(this.thisSeq().length() - package$.MODULE$.max(n, 0));
    }

    @Override
    default public This takeRight(int n) {
        return this.drop(this.thisSeq().length() - package$.MODULE$.max(n, 0));
    }

    @Override
    default public String stringPrefix() {
        return "IterableView";
    }

    public static void $init$(IterableViewLike $this) {
    }

    public abstract class AbstractTransformed<B>
    implements Transformed<B> {
        private Coll underlying;
        private volatile boolean bitmap$0;

        @Override
        public <U> void foreach(Function1<B, U> f) {
            ((Transformed)this).foreach(f);
        }

        @Override
        public String toString() {
            return ((Transformed)this).toString();
        }

        @Override
        public boolean isEmpty() {
            return ((Transformed)this).isEmpty();
        }

        @Override
        public <B> Transformed<Tuple2<B, B>> newZipped(GenIterable<B> that) {
            return ((IterableViewLike)this).newZipped(that);
        }

        @Override
        public <A1, B> Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
            return ((IterableViewLike)this).newZippedAll(that, _thisElem, _thatElem);
        }

        @Override
        public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
            return ((IterableViewLike)this).newForced(xs);
        }

        @Override
        public <B> Transformed<B> newAppended(GenTraversable<B> that) {
            return ((IterableViewLike)this).newAppended(that);
        }

        @Override
        public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
            return ((IterableViewLike)this).newPrepended(that);
        }

        @Override
        public <B> Transformed<B> newMapped(Function1<B, B> f) {
            return ((IterableViewLike)this).newMapped(f);
        }

        @Override
        public <B> Transformed<B> newFlatMapped(Function1<B, GenTraversableOnce<B>> f) {
            return ((IterableViewLike)this).newFlatMapped(f);
        }

        @Override
        public Transformed<B> newFiltered(Function1<B, Object> p) {
            return ((IterableViewLike)this).newFiltered(p);
        }

        @Override
        public Transformed<B> newSliced(SliceInterval _endpoints) {
            return ((IterableViewLike)this).newSliced(_endpoints);
        }

        @Override
        public Transformed<B> newDroppedWhile(Function1<B, Object> p) {
            return ((IterableViewLike)this).newDroppedWhile(p);
        }

        @Override
        public Transformed<B> newTakenWhile(Function1<B, Object> p) {
            return ((IterableViewLike)this).newTakenWhile(p);
        }

        @Override
        public Transformed<B> newTaken(int n) {
            return ((IterableViewLike)this).newTaken(n);
        }

        @Override
        public Transformed<B> newDropped(int n) {
            return ((IterableViewLike)this).newDropped(n);
        }

        @Override
        public IterableView<B, Coll> drop(int n) {
            return ((IterableViewLike)this).drop(n);
        }

        @Override
        public IterableView<B, Coll> take(int n) {
            return ((IterableViewLike)this).take(n);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<IterableView<B, Coll>, Tuple2<A1, B>, That> bf) {
            return (That)((IterableViewLike)this).zip((GenIterable<B>)that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<IterableView<B, Coll>, Tuple2<A1, Object>, That> bf) {
            return (That)((IterableViewLike)this).zipWithIndex(bf);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<IterableView<B, Coll>, Tuple2<A1, B>, That> bf) {
            return (That)((IterableViewLike)this).zipAll((GenIterable<B>)that, (A1)thisElem, (B)thatElem, bf);
        }

        @Override
        public Iterator<IterableView<B, Coll>> grouped(int size) {
            return ((IterableViewLike)this).grouped(size);
        }

        @Override
        public Iterator<IterableView<B, Coll>> sliding(int size, int step) {
            return ((IterableViewLike)this).sliding(size, step);
        }

        @Override
        public Iterator<IterableView<B, Coll>> sliding(int size) {
            return ((IterableViewLike)this).sliding(size);
        }

        @Override
        public IterableView<B, Coll> dropRight(int n) {
            return ((IterableViewLike)this).dropRight(n);
        }

        @Override
        public IterableView<B, Coll> takeRight(int n) {
            return ((IterableViewLike)this).takeRight(n);
        }

        @Override
        public String stringPrefix() {
            return ((IterableViewLike)this).stringPrefix();
        }

        @Override
        public final String viewIdString() {
            return TraversableViewLike.Transformed.viewIdString$(this);
        }

        @Override
        public Option<B> headOption() {
            return TraversableViewLike.Transformed.headOption$(this);
        }

        @Override
        public B last() {
            return (B)TraversableViewLike.Transformed.last$(this);
        }

        @Override
        public Option<B> lastOption() {
            return TraversableViewLike.Transformed.lastOption$(this);
        }

        @Override
        public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
            return (TraversableView)TraversableLike.tail$(this);
        }

        @Override
        public String viewIdentifier() {
            return TraversableViewLike.viewIdentifier$(this);
        }

        @Override
        public String viewToString() {
            return TraversableViewLike.viewToString$(this);
        }

        @Override
        public Builder<B, IterableView<B, Coll>> newBuilder() {
            return TraversableViewLike.newBuilder$(this);
        }

        @Override
        public <B, That> That force(CanBuildFrom<Coll, B, That> bf) {
            return (That)TraversableViewLike.force$(this, bf);
        }

        @Override
        public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
        }

        @Override
        public <B, That> That map(Function1<B, B> f, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That collect(PartialFunction<B, B> pf, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.collect$(this, pf, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<B, GenTraversableOnce<B>> f, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.flatMap$(this, f, bf);
        }

        @Override
        public <B> TraversableViewLike.Transformed<B> flatten(Function1<B, GenTraversableOnce<B>> asTraversable) {
            return TraversableViewLike.flatten$(this, asTraversable);
        }

        @Override
        public TraversableView filter(Function1 p) {
            return TraversableViewLike.filter$(this, p);
        }

        @Override
        public TraversableView withFilter(Function1 p) {
            return TraversableViewLike.withFilter$(this, p);
        }

        @Override
        public Tuple2<IterableView<B, Coll>, IterableView<B, Coll>> partition(Function1<B, Object> p) {
            return TraversableViewLike.partition$(this, p);
        }

        @Override
        public TraversableView init() {
            return TraversableViewLike.init$(this);
        }

        @Override
        public TraversableView slice(int from, int until) {
            return TraversableViewLike.slice$(this, from, until);
        }

        @Override
        public TraversableView dropWhile(Function1 p) {
            return TraversableViewLike.dropWhile$(this, p);
        }

        @Override
        public TraversableView takeWhile(Function1 p) {
            return TraversableViewLike.takeWhile$(this, p);
        }

        @Override
        public Tuple2<IterableView<B, Coll>, IterableView<B, Coll>> span(Function1<B, Object> p) {
            return TraversableViewLike.span$(this, p);
        }

        @Override
        public Tuple2<IterableView<B, Coll>, IterableView<B, Coll>> splitAt(int n) {
            return TraversableViewLike.splitAt$(this, n);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, B, B> op, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<B, B, B> op, CanBuildFrom<IterableView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.scanRight$(this, z, op, bf);
        }

        @Override
        public <K> Map<K, IterableView<B, Coll>> groupBy(Function1<B, K> f) {
            return TraversableViewLike.groupBy$(this, f);
        }

        @Override
        public <A1, A2> Tuple2<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>> unzip(Function1<B, Tuple2<A1, A2>> asPair) {
            return TraversableViewLike.unzip$(this, asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>, TraversableViewLike.Transformed<A3>> unzip3(Function1<B, Tuple3<A1, A2, A3>> asTriple) {
            return TraversableViewLike.unzip3$(this, asTriple);
        }

        @Override
        public TraversableView filterNot(Function1 p) {
            return TraversableViewLike.filterNot$(this, p);
        }

        @Override
        public Iterator<IterableView<B, Coll>> inits() {
            return TraversableViewLike.inits$(this);
        }

        @Override
        public Iterator<IterableView<B, Coll>> tails() {
            return TraversableViewLike.tails$(this);
        }

        @Override
        public TraversableView tail() {
            return TraversableViewLike.tail$(this);
        }

        @Override
        public Seq<B> thisSeq() {
            return ViewMkString.thisSeq$(this);
        }

        @Override
        public String mkString() {
            return ViewMkString.mkString$(this);
        }

        @Override
        public String mkString(String sep) {
            return ViewMkString.mkString$(this, sep);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return ViewMkString.mkString$(this, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return ViewMkString.addString$(this, b, start, sep, end);
        }

        @Override
        public GenericCompanion<Iterable> companion() {
            return Iterable.companion$(this);
        }

        @Override
        public Iterable<B> seq() {
            return Iterable.seq$(this);
        }

        @Override
        public Iterable<B> thisCollection() {
            return IterableLike.thisCollection$(this);
        }

        @Override
        public Iterable toCollection(Object repr) {
            return IterableLike.toCollection$(this, repr);
        }

        @Override
        public boolean forall(Function1<B, Object> p) {
            return IterableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<B, Object> p) {
            return IterableLike.exists$(this, p);
        }

        @Override
        public Option<B> find(Function1<B, Object> p) {
            return IterableLike.find$(this, p);
        }

        @Override
        public <B> B foldRight(B z, Function2<B, B, B> op) {
            return (B)IterableLike.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceRight(Function2<B, B, B> op) {
            return (B)IterableLike.reduceRight$(this, op);
        }

        @Override
        public Iterable<B> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<B> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public B head() {
            return (B)IterableLike.head$(this);
        }

        @Override
        public <B> void copyToArray(Object xs, int start, int len) {
            IterableLike.copyToArray$(this, xs, start, len);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public Stream<B> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
        }

        @Override
        public IterableView<B, IterableView<B, Coll>> view() {
            return IterableLike.view$(this);
        }

        @Override
        public IterableView<B, IterableView<B, Coll>> view(int from, int until) {
            return IterableLike.view$(this, from, until);
        }

        @Override
        public <B> Builder<B, Iterable<B>> genericBuilder() {
            return GenericTraversableTemplate.genericBuilder$(this);
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
        public Combiner<B, ParIterable<B>> parCombiner() {
            return TraversableLike.parCombiner$(this);
        }

        @Override
        public boolean hasDefiniteSize() {
            return TraversableLike.hasDefiniteSize$(this);
        }

        @Override
        public Object filterImpl(Function1 p, boolean isFlipped) {
            return TraversableLike.filterImpl$(this, p, isFlipped);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<IterableView<B, Coll>, B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
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
        public Traversable<B> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, B, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public Parallel par() {
            return Parallelizable.par$(this);
        }

        @Override
        public List<B> reversed() {
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
        public int count(Function1<B, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<B, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, B, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, B, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<B, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, B, B> seqop, Function2<B, B, B> combop) {
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
        public <B> B min(Ordering<B> cmp) {
            return (B)TraversableOnce.min$(this, cmp);
        }

        @Override
        public <B> B max(Ordering<B> cmp) {
            return (B)TraversableOnce.max$(this, cmp);
        }

        @Override
        public <B> B maxBy(Function1<B, B> f, Ordering<B> cmp) {
            return (B)TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> B minBy(Function1<B, B> f, Ordering<B> cmp) {
            return (B)TraversableOnce.minBy$(this, f, cmp);
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
        public List<B> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public Seq<B> toSeq() {
            return TraversableOnce.toSeq$(this);
        }

        @Override
        public IndexedSeq<B> toIndexedSeq() {
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
        public Vector<B> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<B, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
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

        private Coll underlying$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.underlying = TraversableViewLike.Transformed.underlying$(this);
                    this.bitmap$0 = true;
                }
            }
            return this.underlying;
        }

        @Override
        public Coll underlying() {
            if (!this.bitmap$0) {
                return this.underlying$lzycompute();
            }
            return this.underlying;
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$AbstractTransformed$$$outer() {
            return IterableViewLike.this;
        }

        @Override
        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Transformed$$$outer() {
            return this.scala$collection$IterableViewLike$AbstractTransformed$$$outer();
        }

        @Override
        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Transformed$$$outer() {
            return this.scala$collection$IterableViewLike$AbstractTransformed$$$outer();
        }

        public AbstractTransformed() {
            if (IterableViewLike.this == null) {
                throw null;
            }
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
            ViewMkString.$init$(this);
            TraversableViewLike.$init$(this);
            TraversableViewLike.Transformed.$init$(this);
            IterableViewLike.$init$(this);
            Transformed.$init$(this);
        }
    }

    public interface Appended<B>
    extends TraversableViewLike.Appended<B>,
    Transformed<B> {
        public static /* synthetic */ Iterator iterator$(Appended $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<B> iterator() {
            return this.scala$collection$IterableViewLike$Appended$$$outer().iterator().$plus$plus((Function0<GenTraversable> & java.io.Serializable & Serializable)() -> this.rest());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Appended$$$outer();

        public static void $init$(Appended $this) {
        }
    }

    public interface DroppedWhile
    extends TraversableViewLike.DroppedWhile,
    Transformed<A> {
        public static /* synthetic */ Iterator iterator$(DroppedWhile $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<A> iterator() {
            return this.scala$collection$IterableViewLike$DroppedWhile$$$outer().iterator().dropWhile(this.pred());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$DroppedWhile$$$outer();

        public static void $init$(DroppedWhile $this) {
        }
    }

    public interface EmptyView
    extends Transformed<Nothing$>,
    TraversableViewLike.EmptyView {
        public static /* synthetic */ Iterator iterator$(EmptyView $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<Nothing$> iterator() {
            return Iterator$.MODULE$.empty();
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$EmptyView$$$outer();

        public static void $init$(EmptyView $this) {
        }
    }

    public interface Filtered
    extends TraversableViewLike.Filtered,
    Transformed<A> {
        public static /* synthetic */ Iterator iterator$(Filtered $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<A> iterator() {
            return this.scala$collection$IterableViewLike$Filtered$$$outer().iterator().filter(this.pred());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Filtered$$$outer();

        public static void $init$(Filtered $this) {
        }
    }

    public interface FlatMapped<B>
    extends TraversableViewLike.FlatMapped<B>,
    Transformed<B> {
        public static /* synthetic */ Iterator iterator$(FlatMapped $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<B> iterator() {
            return this.scala$collection$IterableViewLike$FlatMapped$$$outer().iterator().flatMap(this.mapping());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$FlatMapped$$$outer();

        public static void $init$(FlatMapped $this) {
        }
    }

    public interface Forced<B>
    extends TraversableViewLike.Forced<B>,
    Transformed<B> {
        public static /* synthetic */ Iterator iterator$(Forced $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<B> iterator() {
            return this.forced().iterator();
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Forced$$$outer();

        public static void $init$(Forced $this) {
        }
    }

    public interface Mapped<B>
    extends TraversableViewLike.Mapped<B>,
    Transformed<B> {
        public static /* synthetic */ Iterator iterator$(Mapped $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<B> iterator() {
            return this.scala$collection$IterableViewLike$Mapped$$$outer().iterator().map(this.mapping());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Mapped$$$outer();

        public static void $init$(Mapped $this) {
        }
    }

    public interface Prepended<B>
    extends TraversableViewLike.Prepended<B>,
    Transformed<B> {
        public static /* synthetic */ Iterator iterator$(Prepended $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<B> iterator() {
            return this.fst().toIterator().$plus$plus((Function0<IterableViewLike> & java.io.Serializable & Serializable)() -> this.scala$collection$IterableViewLike$Prepended$$$outer());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Prepended$$$outer();

        public static void $init$(Prepended $this) {
        }
    }

    public interface Sliced
    extends TraversableViewLike.Sliced,
    Transformed<A> {
        public static /* synthetic */ Iterator iterator$(Sliced $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<A> iterator() {
            return this.scala$collection$IterableViewLike$Sliced$$$outer().iterator().slice(this.from(), this.until());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Sliced$$$outer();

        public static void $init$(Sliced $this) {
        }
    }

    public interface TakenWhile
    extends TraversableViewLike.TakenWhile,
    Transformed<A> {
        public static /* synthetic */ Iterator iterator$(TakenWhile $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<A> iterator() {
            return this.scala$collection$IterableViewLike$TakenWhile$$$outer().iterator().takeWhile(this.pred());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$TakenWhile$$$outer();

        public static void $init$(TakenWhile $this) {
        }
    }

    public interface Transformed<B>
    extends IterableView<B, Coll>,
    TraversableViewLike.Transformed<B> {
        @Override
        public Iterator<B> iterator();

        @Override
        default public <U> void foreach(Function1<B, U> f) {
            this.iterator().foreach(f);
        }

        @Override
        default public String toString() {
            return this.viewToString();
        }

        @Override
        default public boolean isEmpty() {
            return !this.iterator().hasNext();
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Transformed$$$outer();

        public static void $init$(Transformed $this) {
        }
    }

    public interface Zipped<B>
    extends Transformed<Tuple2<A, B>> {
        public GenIterable<B> other();

        public static /* synthetic */ Iterator iterator$(Zipped $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<Tuple2<A, B>> iterator() {
            return this.scala$collection$IterableViewLike$Zipped$$$outer().iterator().zip(this.other().iterator());
        }

        public static /* synthetic */ String viewIdentifier$(Zipped $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "Z";
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Zipped$$$outer();

        public static void $init$(Zipped $this) {
        }
    }

    public interface ZippedAll<A1, B>
    extends Transformed<Tuple2<A1, B>> {
        public GenIterable<B> other();

        public A1 thisElem();

        public B thatElem();

        public static /* synthetic */ String viewIdentifier$(ZippedAll $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "Z";
        }

        public static /* synthetic */ Iterator iterator$(ZippedAll $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<Tuple2<A1, B>> iterator() {
            return this.scala$collection$IterableViewLike$ZippedAll$$$outer().iterator().zipAll(this.other().iterator(), this.thisElem(), this.thatElem());
        }

        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$ZippedAll$$$outer();

        public static void $init$(ZippedAll $this) {
        }
    }
}

