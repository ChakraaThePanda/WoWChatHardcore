/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterable;
import scala.collection.AbstractIterator;
import scala.collection.AbstractMap;
import scala.collection.AbstractSet;
import scala.collection.DefaultMap;
import scala.collection.GenMapLike;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.Set$;
import scala.collection.SetLike;
import scala.collection.TraversableLike;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.MapBuilder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParMap;
import scala.collection.parallel.ParMap$;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.ObjectRef;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\rEda\u0002\u001f>!\u0003\r\tA\u0011\u0005\u0006{\u0002!\tA \u0005\b\u0003\u000b\u0001a\u0011AA\u0004\u0011!\tI\u0001\u0001Q\u0005R\u0005-\u0001bBA\r\u0001\u0019\u0005\u00111\u0004\u0005\b\u0003O\u0001a\u0011AA\u0015\u0011\u001d\t\t\u0004\u0001D\u0001\u0003gAq!a\u0012\u0001\r\u0003\tI\u0005C\u0004\u0002N\u0001!\t%a\u0014\t\u000f\u0005]\u0003\u0001\"\u0001\u0002Z!9\u0011Q\u000e\u0001\u0005\u0002\u0005=\u0004bBA:\u0001\u0011\u0005\u0011Q\u000f\u0005\b\u0003s\u0002A\u0011AA>\u0011\u001d\ty\b\u0001C!\u0003\u0003Cq!!(\u0001\t\u0003\tyJ\u0002\u0004\u0002(\u0002A\u0011\u0011\u0016\u0005\b\u0003o{A\u0011AA]\u0011\u001d\t\u0019h\u0004C\u0001\u0003\u007fCq!a\n\u0010\t\u0003\t\u0019\rC\u0004\u00022=!\t!a2\t\u000f\u0005\u001ds\u0002\"\u0001\u0002N\"9\u0011\u0011[\b\u0005B\u0005M\u0007bBAn\u001f\u0011\u0005\u0013Q\u001c\u0005\b\u0003[\u0004A\u0011AAb\u0011\u001d\ty\u000f\u0001C\u0001\u0003cDqAa\u0004\u0001\t\u0003\u0011\tB\u0002\u0004\u0003\u001c\u0001A!Q\u0004\u0005\b\u0003oSB\u0011\u0001B\u0013\u0011\u001d\t9C\u0007C\u0001\u0005SAq!!5\u001b\t\u0003\n\u0019\u000eC\u0004\u0002\\j!\tE!\f\t\u000f\te\u0002\u0001\"\u0001\u0003*!9\u0011Q\r\u0001\u0005\u0002\tmbA\u0002B \u0001!\u0011\t\u0005\u0003\u0006\u0003P\u0005\u0012\t\u0011)A\u0005\u0005#Bq!a.\"\t\u0003\u0011\u0019\u0006C\u0004\u0002\\\u0006\"\tE!\u0017\t\u000f\u0005\u001d\u0012\u0005\"\u0001\u0002*!9\u00111O\u0011\u0005B\t\u0015\u0004bBA\rC\u0011\u0005!\u0011\u000e\u0005\b\u0005[\u0002A\u0011\u0001B8\r\u0019\u0011\u0019\b\u0001\u0005\u0003v!Q\u00111]\u0015\u0003\u0002\u0003\u0006IAa!\t\u000f\u0005]\u0016\u0006\"\u0001\u0003\u0006\"9\u00111\\\u0015\u0005B\t-\u0005bBA\u0014S\u0011\u0005!1\u0014\u0005\b\u0003#LC\u0011IAj\u0011\u001d\t\u0019(\u000bC!\u0005?Cq!!\u0007*\t\u0003\u0011\u0019\u000bC\u0004\u0003*\u0002!\tAa+\t\u000f\te\u0006\u0001\"\u0001\u0003<\"9\u0011\u0011\u0007\u0001\u0005\u0002\t-\u0007b\u0002Bu\u0001\u0011\u0005!1\u001e\u0005\b\u0007\u0003\u0001A\u0011IB\u0002\u0011\u001d\u0019I\u0001\u0001C!\u0007\u0017Aqaa\u0005\u0001\t\u0003\u001a)\u0002\u0003\u0005\u0004(\u0001\u0001K\u0011KB\u0015\u0011\u001d\u0019\t\u0004\u0001C!\u0007gAqa!\u001b\u0001\t\u0003\u001aY\u0007C\u0004\u0004n\u0001!\tea\u001c\u0003\u000f5\u000b\u0007\u000fT5lK*\u0011ahP\u0001\u000bG>dG.Z2uS>t'\"\u0001!\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U!1)T,b'\u001d\u0001A\tS-l]R\u0004\"!\u0012$\u000e\u0003}J!aR \u0003\r\u0005s\u0017PU3g!\u0011)\u0015j\u0013,\n\u0005){$a\u0004)beRL\u0017\r\u001c$v]\u000e$\u0018n\u001c8\u0011\u00051kE\u0002\u0001\u0003\u0006\u001d\u0002\u0011\ra\u0014\u0002\u0002\u0017F\u0011\u0001k\u0015\t\u0003\u000bFK!AU \u0003\u000f9{G\u000f[5oOB\u0011Q\tV\u0005\u0003+~\u00121!\u00118z!\tau\u000b\u0002\u0004Y\u0001\u0011\u0015\ra\u0014\u0002\u0002-B!!lW/a\u001b\u0005i\u0014B\u0001/>\u00051IE/\u001a:bE2,G*[6f!\u0011)el\u0013,\n\u0005}{$A\u0002+va2,'\u0007\u0005\u0002MC\u00121!\r\u0001CC\u0002\r\u0014A\u0001\u00165jgF\u0011\u0001\u000b\u001a\n\u0004K\u001eDg\u0001\u00024\u0001\u0001\u0011\u0014A\u0002\u0010:fM&tW-\\3oiz\u0002RA\u0017\u0001L-\u0002\u0004BAW5L-&\u0011!.\u0010\u0002\u0004\u001b\u0006\u0004\b#\u0002.m\u0017Z\u0003\u0017BA7>\u0005)9UM\\'ba2K7.\u001a\t\u0005_J\\\u0005-D\u0001q\u0015\t\tX(A\u0004hK:,'/[2\n\u0005M\u0004(\u0001D*vER\u0014\u0018m\u0019;bE2,\u0007\u0003\u0002.v;^L!A^\u001f\u0003\u001dA\u000b'/\u00197mK2L'0\u00192mKB!\u0001p_&W\u001b\u0005I(B\u0001>>\u0003!\u0001\u0018M]1mY\u0016d\u0017B\u0001?z\u0005\u0019\u0001\u0016M]'ba\u00061A%\u001b8ji\u0012\"\u0012a \t\u0004\u000b\u0006\u0005\u0011bAA\u0002\u007f\t!QK\\5u\u0003\u0015)W\u000e\u001d;z+\u0005\u0001\u0017A\u00038fo\n+\u0018\u000e\u001c3feV\u0011\u0011Q\u0002\t\u0007\u0003\u001f\t)\"\u00181\u000e\u0005\u0005E!bAA\n{\u00059Q.\u001e;bE2,\u0017\u0002BA\f\u0003#\u0011qAQ;jY\u0012,'/A\u0002hKR$B!!\b\u0002$A!Q)a\bW\u0013\r\t\tc\u0010\u0002\u0007\u001fB$\u0018n\u001c8\t\r\u0005\u0015B\u00011\u0001L\u0003\rYW-_\u0001\tSR,'/\u0019;peV\u0011\u00111\u0006\t\u00055\u00065R,C\u0002\u00020u\u0012\u0001\"\u0013;fe\u0006$xN]\u0001\u0006IAdWo]\u000b\u0005\u0003k\tY\u0004\u0006\u0003\u00028\u0005\u0005\u0003#\u0002.j\u0017\u0006e\u0002c\u0001'\u0002<\u00119\u0011Q\b\u0004C\u0002\u0005}\"A\u0001,2#\t16\u000bC\u0004\u0002D\u0019\u0001\r!!\u0012\u0002\u0005-4\b#B#_\u0017\u0006e\u0012A\u0002\u0013nS:,8\u000fF\u0002a\u0003\u0017Ba!!\n\b\u0001\u0004Y\u0015aB5t\u000b6\u0004H/_\u000b\u0003\u0003#\u00022!RA*\u0013\r\t)f\u0010\u0002\b\u0005>|G.Z1o\u0003%9W\r^(s\u000b2\u001cX-\u0006\u0003\u0002\\\u0005}CCBA/\u0003C\n\u0019\u0007E\u0002M\u0003?\"q!!\u0010\n\u0005\u0004\ty\u0004\u0003\u0004\u0002&%\u0001\ra\u0013\u0005\t\u0003KJA\u00111\u0001\u0002h\u00059A-\u001a4bk2$\b#B#\u0002j\u0005u\u0013bAA6\u007f\tAAHY=oC6,g(A\u0003baBd\u0017\u0010F\u0002W\u0003cBa!!\n\u000b\u0001\u0004Y\u0015\u0001C2p]R\f\u0017N\\:\u0015\t\u0005E\u0013q\u000f\u0005\u0007\u0003KY\u0001\u0019A&\u0002\u0017%\u001cH)\u001a4j]\u0016$\u0017\t\u001e\u000b\u0005\u0003#\ni\b\u0003\u0004\u0002&1\u0001\raS\u0001\fCB\u0004H._(s\u000b2\u001cX-\u0006\u0004\u0002\u0004\u0006=\u0015q\u0011\u000b\u0007\u0003\u000b\u000bI)!&\u0011\u00071\u000b9\tB\u0004\u0002>5\u0011\r!a\u0010\t\u000f\u0005-U\u00021\u0001\u0002\u000e\u0006\t\u0001\u0010E\u0002M\u0003\u001f#q!!%\u000e\u0005\u0004\t\u0019J\u0001\u0002LcE\u0011\u0001k\u0013\u0005\b\u0003Kj\u0001\u0019AAL!\u001d)\u0015\u0011TAG\u0003\u000bK1!a'@\u0005%1UO\\2uS>t\u0017'\u0001\u0004lKf\u001cV\r^\u000b\u0003\u0003C\u0003BAWAR\u0017&\u0019\u0011QU\u001f\u0003\u0007M+GOA\u0007EK\u001a\fW\u000f\u001c;LKf\u001cV\r^\n\b\u001f\u0005-\u0016\u0011UAY!\u0011Q\u0016QV&\n\u0007\u0005=VHA\u0006BEN$(/Y2u'\u0016$\bcA#\u00024&\u0019\u0011QW \u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rqJg.\u001b;?)\t\tY\fE\u0002\u0002>>i\u0011\u0001\u0001\u000b\u0005\u0003#\n\t\r\u0003\u0004\u0002&E\u0001\raS\u000b\u0003\u0003\u000b\u0004BAWA\u0017\u0017R!\u0011\u0011UAe\u0011\u0019\tYm\u0005a\u0001\u0017\u0006!Q\r\\3n)\u0011\t\t+a4\t\r\u0005-G\u00031\u0001L\u0003\u0011\u0019\u0018N_3\u0016\u0005\u0005U\u0007cA#\u0002X&\u0019\u0011\u0011\\ \u0003\u0007%sG/A\u0004g_J,\u0017m\u00195\u0016\t\u0005}\u0017\u0011\u001e\u000b\u0004\u007f\u0006\u0005\bbBAr-\u0001\u0007\u0011Q]\u0001\u0002MB1Q)!'L\u0003O\u00042\u0001TAu\t\u0019\tYO\u0006b\u0001\u001f\n\tQ+\u0001\u0007lKf\u001c\u0018\n^3sCR|'/\u0001\u0003lKf\u001cXCAAz!\u0011Q\u0016Q_&\n\u0007\u0005]XH\u0001\u0005Ji\u0016\u0014\u0018M\u00197fQ\u001dA\u00121 B\u0004\u0005\u0017\u0001B!!@\u0003\u00045\u0011\u0011q \u0006\u0004\u0005\u0003y\u0014AC1o]>$\u0018\r^5p]&!!QAA\u0000\u0005%i\u0017n\u001a:bi&|g.\t\u0002\u0003\n\u00059\u0004m[3zg\u0002\u0004#/\u001a;ve:\u001c\b\u0005Y%uKJ\f'\r\\3\\\u0017v\u0003\u0007E]1uQ\u0016\u0014\b\u0005\u001e5b]\u0002\u0002\u0017\n^3sCR|'oW&^A:\n#A!\u0004\u0002\u000bIr\u0003H\f\u0019\u0002\rY\fG.^3t+\t\u0011\u0019\u0002\u0005\u0003[\u0003k4\u0006fB\r\u0002|\n]!1B\u0011\u0003\u00053\t\u0011\b\u0019<bYV,7\u000f\u0019\u0011sKR,(O\\:!A&#XM]1cY\u0016\\f+\u00181!e\u0006$\b.\u001a:!i\"\fg\u000e\t1Ji\u0016\u0014\u0018\r^8s7Zk\u0006M\f\u0002\u0016\t\u00164\u0017-\u001e7u-\u0006dW/Z:Ji\u0016\u0014\u0018M\u00197f'\u001dQ\"q\u0004B\n\u0003c\u0003BA\u0017B\u0011-&\u0019!1E\u001f\u0003!\u0005\u00137\u000f\u001e:bGRLE/\u001a:bE2,GC\u0001B\u0014!\r\tiLG\u000b\u0003\u0005W\u0001BAWA\u0017-V!!q\u0006B\u001c)\ry(\u0011\u0007\u0005\b\u0003Gt\u0002\u0019\u0001B\u001a!\u0019)\u0015\u0011\u0014,\u00036A\u0019AJa\u000e\u0005\r\u0005-hD1\u0001P\u000391\u0018\r\\;fg&#XM]1u_J$2A\u0016B\u001f\u0011\u0019\t)\u0003\ta\u0001\u0017\naa)\u001b7uKJ,GmS3zgN)\u0011Ea\u0011\u0003JA)!L!\u0012L-&\u0019!qI\u001f\u0003\u0017\u0005\u00137\u000f\u001e:bGRl\u0015\r\u001d\t\u00065\n-3JV\u0005\u0004\u0005\u001bj$A\u0003#fM\u0006,H\u000e^'ba\u0006\t\u0001\u000f\u0005\u0004F\u00033[\u0015\u0011\u000b\u000b\u0005\u0005+\u00129\u0006E\u0002\u0002>\u0006BqAa\u0014$\u0001\u0004\u0011\t&\u0006\u0003\u0003\\\t\rDcA@\u0003^!9\u00111\u001d\u0013A\u0002\t}\u0003CB#\u0002\u001av\u0013\t\u0007E\u0002M\u0005G\"a!a;%\u0005\u0004yE\u0003BA)\u0005OBa!!\n'\u0001\u0004YE\u0003BA\u000f\u0005WBa!!\n(\u0001\u0004Y\u0015A\u00034jYR,'oS3zgR\u0019\u0001N!\u001d\t\u000f\t=\u0003\u00061\u0001\u0003R\taQ*\u00199qK\u00124\u0016\r\\;fgV!!q\u000fB?'\u0015I#\u0011\u0010BA!\u0019Q&QI&\u0003|A\u0019AJ! \u0005\r\t}\u0014F1\u0001P\u0005\u00059\u0006C\u0002.\u0003L-\u0013Y\b\u0005\u0004F\u000333&1\u0010\u000b\u0005\u0005\u000f\u0013I\tE\u0003\u0002>&\u0012Y\bC\u0004\u0002d.\u0002\rAa!\u0016\t\t5%\u0011\u0014\u000b\u0004\u007f\n=\u0005b\u0002BIY\u0001\u0007!1S\u0001\u0002OB9Q)!'\u0003\u0016\n]\u0005#B#_\u0017\nm\u0004c\u0001'\u0003\u001a\u00121\u00111\u001e\u0017C\u0002=+\"A!(\u0011\u000bi\u000biC!&\u0015\t\u0005E#\u0011\u0015\u0005\u0007\u0003Ky\u0003\u0019A&\u0015\t\t\u0015&q\u0015\t\u0006\u000b\u0006}!1\u0010\u0005\u0007\u0003K\u0001\u0004\u0019A&\u0002\u00135\f\u0007OV1mk\u0016\u001cX\u0003\u0002BW\u0005g#BAa,\u00036B)!,[&\u00032B\u0019AJa-\u0005\r\t}\u0014G1\u0001P\u0011\u001d\t\u0019/\ra\u0001\u0005o\u0003b!RAM-\nE\u0016aB;qI\u0006$X\rZ\u000b\u0005\u0005{\u0013\u0019\r\u0006\u0004\u0003@\n\u0015'q\u0019\t\u00065&\\%\u0011\u0019\t\u0004\u0019\n\rGaBA\u001fe\t\u0007\u0011q\b\u0005\u0007\u0003K\u0011\u0004\u0019A&\t\u000f\t%'\u00071\u0001\u0003B\u0006)a/\u00197vKV!!Q\u001aBj)!\u0011yM!6\u0003\\\n}\u0007#\u0002.j\u0017\nE\u0007c\u0001'\u0003T\u00129\u0011QH\u001aC\u0002\u0005}\u0002b\u0002Blg\u0001\u0007!\u0011\\\u0001\u0004WZ\f\u0004#B#_\u0017\nE\u0007b\u0002Bog\u0001\u0007!\u0011\\\u0001\u0004WZ\u0014\u0004b\u0002Bqg\u0001\u0007!1]\u0001\u0004WZ\u001c\b#B#\u0003f\ne\u0017b\u0001Bt\u007f\tQAH]3qK\u0006$X\r\u001a \u0002\u0015\u0011\u0002H.^:%a2,8/\u0006\u0003\u0003n\nMH\u0003\u0002Bx\u0005k\u0004RAW5L\u0005c\u00042\u0001\u0014Bz\t\u001d\ti\u0004\u000eb\u0001\u0003\u007fAqAa>5\u0001\u0004\u0011I0\u0001\u0002ygB)!La?\u0003\u0000&\u0019!Q`\u001f\u0003%\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK>s7-\u001a\t\u0006\u000bz[%\u0011_\u0001\nM&dG/\u001a:O_R$2\u0001YB\u0003\u0011\u001d\u0011y%\u000ea\u0001\u0007\u000f\u0001b!RAM;\u0006E\u0013!\u0002;p'\u0016\fXCAB\u0007!\u0011Q6qB/\n\u0007\rEQHA\u0002TKF\f\u0001\u0002^8Ck\u001a4WM]\u000b\u0005\u0007/\u0019\t#\u0006\u0002\u0004\u001aA1\u0011qBB\u000e\u0007?IAa!\b\u0002\u0012\t1!)\u001e4gKJ\u00042\u0001TB\u0011\t\u001d\u0019\u0019c\u000eb\u0001\u0007K\u0011\u0011!R\t\u0003;N\u000b1\u0002]1s\u0007>l'-\u001b8feV\u001111\u0006\t\u0006q\u000e5Rl^\u0005\u0004\u0007_I(\u0001C\"p[\nLg.\u001a:\u0002\u0013\u0005$Gm\u0015;sS:<GCCB\u001b\u0007\u0007\u001a9e!\u0019\u0004fA!1qGB\u001f\u001d\r)5\u0011H\u0005\u0004\u0007wy\u0014a\u00029bG.\fw-Z\u0005\u0005\u0007\u007f\u0019\tEA\u0007TiJLgn\u001a\"vS2$WM\u001d\u0006\u0004\u0007wy\u0004bBB#s\u0001\u00071QG\u0001\u0002E\"91\u0011J\u001dA\u0002\r-\u0013!B:uCJ$\b\u0003BB'\u00077rAaa\u0014\u0004XA\u00191\u0011K \u000e\u0005\rM#bAB+\u0003\u00061AH]8pizJ1a!\u0017@\u0003\u0019\u0001&/\u001a3fM&!1QLB0\u0005\u0019\u0019FO]5oO*\u00191\u0011L \t\u000f\r\r\u0014\b1\u0001\u0004L\u0005\u00191/\u001a9\t\u000f\r\u001d\u0014\b1\u0001\u0004L\u0005\u0019QM\u001c3\u0002\u0019M$(/\u001b8h!J,g-\u001b=\u0016\u0005\r-\u0013\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\r-\u0003")
public interface MapLike<K, V, This extends MapLike<K, V, This> & Map<K, V>>
extends PartialFunction<K, V>,
IterableLike<Tuple2<K, V>, This>,
GenMapLike<K, V, This>,
Subtractable<K, This> {
    public This empty();

    public static /* synthetic */ Builder newBuilder$(MapLike $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<Tuple2<K, V>, This> newBuilder() {
        return new MapBuilder(this.empty());
    }

    @Override
    public Option<V> get(K var1);

    @Override
    public Iterator<Tuple2<K, V>> iterator();

    @Override
    public <V1> Map<K, V1> $plus(Tuple2<K, V1> var1);

    @Override
    public This $minus(K var1);

    public static /* synthetic */ boolean isEmpty$(MapLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return this.size() == 0;
    }

    public static /* synthetic */ Object getOrElse$(MapLike $this, Object key, Function0 function0) {
        return $this.getOrElse(key, function0);
    }

    @Override
    default public <V1> V1 getOrElse(K key, Function0<V1> function0) {
        Object object;
        Option<V> option = this.get(key);
        if (option instanceof Some) {
            object = ((Some)option).value();
        } else if (None$.MODULE$.equals(option)) {
            object = function0.apply();
        } else {
            throw new MatchError(option);
        }
        return (V1)object;
    }

    public static /* synthetic */ Object apply$(MapLike $this, Object key) {
        return $this.apply((K)key);
    }

    @Override
    default public V apply(K key) {
        Object object;
        Option<V> option = this.get(key);
        if (None$.MODULE$.equals(option)) {
            object = this.default(key);
        } else if (option instanceof Some) {
            object = ((Some)option).value();
        } else {
            throw new MatchError(option);
        }
        return object;
    }

    public static /* synthetic */ boolean contains$(MapLike $this, Object key) {
        return $this.contains(key);
    }

    @Override
    default public boolean contains(K key) {
        return this.get(key).isDefined();
    }

    public static /* synthetic */ boolean isDefinedAt$(MapLike $this, Object key) {
        return $this.isDefinedAt((K)key);
    }

    @Override
    default public boolean isDefinedAt(K key) {
        return this.contains(key);
    }

    public static /* synthetic */ Object applyOrElse$(MapLike $this, Object x, Function1 function1) {
        return $this.applyOrElse((K1)x, function1);
    }

    @Override
    default public <K1 extends K, V1> V1 applyOrElse(K1 x, Function1<K1, V1> function1) {
        return this.getOrElse(x, (Function0<Object> & java.io.Serializable & Serializable)() -> function1.apply(x));
    }

    public static /* synthetic */ Set keySet$(MapLike $this) {
        return $this.keySet();
    }

    @Override
    default public Set<K> keySet() {
        return new DefaultKeySet();
    }

    public static /* synthetic */ Iterator keysIterator$(MapLike $this) {
        return $this.keysIterator();
    }

    @Override
    default public Iterator<K> keysIterator() {
        return new AbstractIterator<K>(this){
            private final Iterator<Tuple2<K, V>> iter;

            private Iterator<Tuple2<K, V>> iter() {
                return this.iter;
            }

            public boolean hasNext() {
                return this.iter().hasNext();
            }

            public K next() {
                return this.iter().next()._1();
            }
            {
                this.iter = $outer.iterator();
            }
        };
    }

    public static /* synthetic */ Iterable keys$(MapLike $this) {
        return $this.keys();
    }

    @Override
    default public Iterable<K> keys() {
        return this.keySet();
    }

    public static /* synthetic */ Iterable values$(MapLike $this) {
        return $this.values();
    }

    @Override
    default public Iterable<V> values() {
        return new DefaultValuesIterable();
    }

    public static /* synthetic */ Iterator valuesIterator$(MapLike $this) {
        return $this.valuesIterator();
    }

    @Override
    default public Iterator<V> valuesIterator() {
        return new AbstractIterator<V>(this){
            private final Iterator<Tuple2<K, V>> iter;

            private Iterator<Tuple2<K, V>> iter() {
                return this.iter;
            }

            public boolean hasNext() {
                return this.iter().hasNext();
            }

            public V next() {
                return this.iter().next()._2();
            }
            {
                this.iter = $outer.iterator();
            }
        };
    }

    public static /* synthetic */ Object default$(MapLike $this, Object key) {
        return $this.default(key);
    }

    @Override
    default public V default(K key) {
        throw new NoSuchElementException(new java.lang.StringBuilder(15).append("key not found: ").append(key).toString());
    }

    public static /* synthetic */ Map filterKeys$(MapLike $this, Function1 p) {
        return $this.filterKeys(p);
    }

    @Override
    default public Map<K, V> filterKeys(Function1<K, Object> p) {
        return new FilteredKeys(this, p);
    }

    public static /* synthetic */ Map mapValues$(MapLike $this, Function1 f) {
        return $this.mapValues(f);
    }

    @Override
    default public <W> Map<K, W> mapValues(Function1<V, W> f) {
        return new MappedValues<W>(this, f);
    }

    public static /* synthetic */ Map updated$(MapLike $this, Object key, Object value) {
        return $this.updated(key, value);
    }

    default public <V1> Map<K, V1> updated(K key, V1 value) {
        return this.$plus(new Tuple2<K, V1>(key, value));
    }

    public static /* synthetic */ Map $plus$(MapLike $this, Tuple2 kv1, Tuple2 kv2, Seq kvs) {
        return $this.$plus(kv1, kv2, kvs);
    }

    default public <V1> Map<K, V1> $plus(Tuple2<K, V1> kv1, Tuple2<K, V1> kv2, Seq<Tuple2<K, V1>> kvs) {
        return this.$plus(kv1).$plus(kv2).$plus$plus(kvs);
    }

    public static /* synthetic */ Map $plus$plus$(MapLike $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    default public <V1> Map<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
        Map map = (Map)this.repr();
        return xs.seq().$div$colon(map, (Function2<Map, Tuple2, Map> & java.io.Serializable & Serializable)(x$4, x$5) -> x$4.$plus((Tuple2)x$5));
    }

    public static /* synthetic */ Map filterNot$(MapLike $this, Function1 p) {
        return $this.filterNot(p);
    }

    @Override
    default public This filterNot(Function1<Tuple2<K, V>, Object> p) {
        ObjectRef<Map> res = ObjectRef.create((Map)this.repr());
        this.foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)kv -> {
            MapLike.$anonfun$filterNot$1(p, res, kv);
            return BoxedUnit.UNIT;
        });
        return (This)((Map)res.elem);
    }

    public static /* synthetic */ Seq toSeq$(MapLike $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<Tuple2<K, V>> toSeq() {
        if (this.isEmpty()) {
            return package$.MODULE$.Vector().empty();
        }
        Builder vb = package$.MODULE$.Vector().newBuilder();
        this.foreach((Function1<Tuple2, Builder> & java.io.Serializable & Serializable)x$6 -> vb.$plus$eq(x$6));
        return vb.result();
    }

    public static /* synthetic */ Buffer toBuffer$(MapLike $this) {
        return $this.toBuffer();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    default public <E> Buffer<E> toBuffer() {
        void var1_1;
        ArrayBuffer result2 = new ArrayBuffer(this.size());
        this.foreach((Function1<Tuple2, ArrayBuffer> & java.io.Serializable & Serializable)x$7 -> result2.$plus$eq(x$7));
        return var1_1;
    }

    public static /* synthetic */ Combiner parCombiner$(MapLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<Tuple2<K, V>, ParMap<K, V>> parCombiner() {
        return ParMap$.MODULE$.newCombiner();
    }

    public static /* synthetic */ StringBuilder addString$(MapLike $this, StringBuilder b, String start, String sep, String end) {
        return $this.addString(b, start, sep, end);
    }

    @Override
    default public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return this.iterator().map((Function1<Tuple2, String> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            Object k = x0$1._1();
            Object v = x0$1._2();
            String string = new java.lang.StringBuilder(0).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(k), " -> ")).append(v).toString();
            return string;
        }).addString(b, start, sep, end);
    }

    public static /* synthetic */ String stringPrefix$(MapLike $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return "Map";
    }

    public static /* synthetic */ String toString$(MapLike $this) {
        return $this.toString();
    }

    @Override
    default public String toString() {
        return TraversableLike.toString$(this);
    }

    public static /* synthetic */ void $anonfun$filterNot$1(Function1 p$1, ObjectRef res$1, Tuple2 kv) {
        if (BoxesRunTime.unboxToBoolean(p$1.apply(kv))) {
            res$1.elem = ((Map)res$1.elem).$minus(kv._1());
        }
    }

    public static void $init$(MapLike $this) {
    }

    public class DefaultKeySet
    extends AbstractSet<K>
    implements Serializable {
        @Override
        public boolean contains(K key) {
            return this.scala$collection$MapLike$DefaultKeySet$$$outer().contains(key);
        }

        @Override
        public Iterator<K> iterator() {
            return this.scala$collection$MapLike$DefaultKeySet$$$outer().keysIterator();
        }

        @Override
        public Set<K> $plus(K elem) {
            return ((SetLike)Set$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this).$plus(elem);
        }

        @Override
        public Set<K> $minus(K elem) {
            return ((SetLike)Set$.MODULE$.apply(Nil$.MODULE$)).$plus$plus(this).$minus(elem);
        }

        @Override
        public int size() {
            return this.scala$collection$MapLike$DefaultKeySet$$$outer().size();
        }

        @Override
        public <U> void foreach(Function1<K, U> f) {
            this.scala$collection$MapLike$DefaultKeySet$$$outer().keysIterator().foreach(f);
        }

        public /* synthetic */ MapLike scala$collection$MapLike$DefaultKeySet$$$outer() {
            return MapLike.this;
        }

        public DefaultKeySet() {
            if (MapLike.this == null) {
                throw null;
            }
        }
    }

    public class DefaultValuesIterable
    extends AbstractIterable<V>
    implements Serializable {
        @Override
        public Iterator<V> iterator() {
            return this.scala$collection$MapLike$DefaultValuesIterable$$$outer().valuesIterator();
        }

        @Override
        public int size() {
            return this.scala$collection$MapLike$DefaultValuesIterable$$$outer().size();
        }

        @Override
        public <U> void foreach(Function1<V, U> f) {
            this.scala$collection$MapLike$DefaultValuesIterable$$$outer().valuesIterator().foreach(f);
        }

        public /* synthetic */ MapLike scala$collection$MapLike$DefaultValuesIterable$$$outer() {
            return MapLike.this;
        }

        public DefaultValuesIterable() {
            if (MapLike.this == null) {
                throw null;
            }
        }
    }

    public class FilteredKeys
    extends AbstractMap<K, V>
    implements DefaultMap<K, V> {
        private final Function1<K, Object> p;
        public final /* synthetic */ MapLike $outer;

        @Override
        public <B1> Map<K, B1> $plus(Tuple2<K, B1> kv) {
            return DefaultMap.$plus$(this, kv);
        }

        @Override
        public Map<K, V> $minus(K key) {
            return DefaultMap.$minus$(this, key);
        }

        @Override
        public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
            this.scala$collection$MapLike$FilteredKeys$$$outer().foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A kv) -> {
                if (BoxesRunTime.unboxToBoolean($this.p.apply(kv._1()))) {
                    return f.apply((Tuple2)kv);
                }
                return BoxedUnit.UNIT;
            });
        }

        @Override
        public Iterator<Tuple2<K, V>> iterator() {
            return this.scala$collection$MapLike$FilteredKeys$$$outer().iterator().filter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A kv) -> BoxesRunTime.boxToBoolean(FilteredKeys.$anonfun$iterator$1(this, kv)));
        }

        @Override
        public boolean contains(K key) {
            return BoxesRunTime.unboxToBoolean(this.p.apply(key)) && this.scala$collection$MapLike$FilteredKeys$$$outer().contains(key);
        }

        @Override
        public Option<V> get(K key) {
            if (!BoxesRunTime.unboxToBoolean(this.p.apply(key))) {
                return None$.MODULE$;
            }
            return this.scala$collection$MapLike$FilteredKeys$$$outer().get(key);
        }

        public /* synthetic */ MapLike scala$collection$MapLike$FilteredKeys$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$iterator$1(FilteredKeys $this, Tuple2 kv) {
            return BoxesRunTime.unboxToBoolean($this.p.apply(kv._1()));
        }

        public FilteredKeys(MapLike $outer, Function1<K, Object> p) {
            this.p = p;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            DefaultMap.$init$(this);
        }
    }

    public class MappedValues<W>
    extends AbstractMap<K, W>
    implements DefaultMap<K, W> {
        private final Function1<V, W> f;
        public final /* synthetic */ MapLike $outer;

        @Override
        public <B1> Map<K, B1> $plus(Tuple2<K, B1> kv) {
            return DefaultMap.$plus$(this, kv);
        }

        @Override
        public Map<K, W> $minus(K key) {
            return DefaultMap.$minus$(this, key);
        }

        @Override
        public <U> void foreach(Function1<Tuple2<K, W>, U> g) {
            this.scala$collection$MapLike$MappedValues$$$outer().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$1 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x$1) -> {
                if (x$1 == null) {
                    throw new MatchError((Object)null);
                }
                Object k = x$1._1();
                Object v = x$1._2();
                Object r = g.apply(new Tuple2(k, $this.f.apply(v)));
                return r;
            });
        }

        @Override
        public Iterator<Tuple2<K, W>> iterator() {
            return this.scala$collection$MapLike$MappedValues$$$outer().iterator().withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$2 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$2 != null)).map((Function1<Tuple2, Tuple2> & java.io.Serializable & Serializable)x$2 -> {
                if (x$2 == null) {
                    throw new MatchError((Object)null);
                }
                Object k = x$2._1();
                Object v = x$2._2();
                Tuple2 tuple2 = new Tuple2(k, $this.f.apply(v));
                return tuple2;
            });
        }

        @Override
        public int size() {
            return this.scala$collection$MapLike$MappedValues$$$outer().size();
        }

        @Override
        public boolean contains(K key) {
            return this.scala$collection$MapLike$MappedValues$$$outer().contains(key);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public Option<W> get(K key) {
            void map_f;
            Option option = this.scala$collection$MapLike$MappedValues$$$outer().get(key);
            Function1 function1 = this.f;
            if (option == null) {
                throw null;
            }
            Option map_this = option;
            if (map_this.isEmpty()) {
                return None$.MODULE$;
            }
            return new Some(map_f.apply(map_this.get()));
        }

        public /* synthetic */ MapLike scala$collection$MapLike$MappedValues$$$outer() {
            return this.$outer;
        }

        public MappedValues(MapLike $outer, Function1<V, W> f) {
            this.f = f;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            DefaultMap.$init$(this);
        }
    }
}

