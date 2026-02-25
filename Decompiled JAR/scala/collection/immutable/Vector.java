/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.MatchError;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.AbstractSeq;
import scala.collection.CustomParallelizable;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.SeqLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Seq$;
import scala.collection.immutable.Traversable;
import scala.collection.immutable.Vector$;
import scala.collection.immutable.VectorIterator;
import scala.collection.immutable.VectorPointer;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParVector;
import scala.math.Integral;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;

@ScalaSignature(bytes="\u0006\u0001\rMu!\u0002\"D\u0011\u0003Qe!\u0002'D\u0011\u0003i\u0005bBA\u0015\u0003\u0011\u00051q\u0004\u0005\b\u0007C\tA\u0011AB\u0012\u0011\u001d\u0019I$\u0001C\u0002\u0007wA!ba\u0014\u0002\u0005\u0004%\taQB)\u0011!\u0019)&\u0001Q\u0001\n\rM\u0003bBB,\u0003\u0011\u00053\u0011\f\u0005\n\u0007G\n!\u0019!C\u0007\u0007KB\u0001ba\u001b\u0002A\u000351q\r\u0005\n\u0007[\n!\u0019!C\u0007\u0007_B\u0001b!\u001e\u0002A\u000351\u0011\u000f\u0005\n\u0007o\n!\u0019!C\u0005\u0007sB\u0001b! \u0002A\u0003%11\u0010\u0005\n\u0007\u007f\n\u0011\u0011!C\u0005\u0007\u00033A\u0001T\"\u0003+\"Y\u0011qC\b\u0003\u0006\u0004%\t!RA\r\u0011)\t\tc\u0004B\u0001B\u0003%\u00111\u0004\u0005\f\u0003Gy!Q1A\u0005\u0002\u0015\u000bI\u0002\u0003\u0006\u0002&=\u0011\t\u0011)A\u0005\u00037A!\"a\n\u0010\u0005\u0003\u0005\u000b\u0011BA\u000e\u0011!\tIc\u0004C\u0001\u0007\u0006-\u0002bBA\u001a\u001f\u0011\u0005\u0013Q\u0007\u0005\u000b\u0003{y\u0001\u0019!C\u0001\u0007\u0006}\u0002BCA$\u001f\u0001\u0007I\u0011A\"\u0002J!A\u0011QK\b!B\u0013\t\t\u0005C\u0004\u0002X=!\t!!\u0007\t\u000f\u0005es\u0002\"\u0011\u0002\\!9\u0011QL\b\u0005B\u0005}\u0003bBA1\u001f\u0011\u0005\u00131\r\u0005\t\u0003SzAQA#\u0002l!9\u0011\u0011Q\b\u0005B\u0005\r\u0005bBAD\u001f\u0011\u0005\u0013\u0011\u0012\u0005\b\u0003#{A\u0011AAJ\u0011\u001d\tIj\u0004C\u0005\u00037C\u0001\"a(\u0010A\u0013%\u0011\u0011\u0015\u0005\b\u0003\u000f|A\u0011IAe\u0011\u001d\t\to\u0004C!\u0003GDq!a>\u0010\t\u0003\nI\u0010C\u0004\u0003\u000e=!\tEa\u0004\t\u000f\tUq\u0002\"\u0011\u0003\u0018!9!1D\b\u0005B\tu\u0001b\u0002B\u0011\u001f\u0011\u0005#1\u0005\u0005\b\u0005OyA\u0011\tB\u0015\u0011\u001d\u0011Yc\u0004C!\u0003?BqA!\f\u0010\t\u0003\u0012I\u0003C\u0004\u00030=!\t%a\u0018\t\u000f\tEr\u0002\"\u0011\u00034!9!QH\b\u0005B\t}\u0002b\u0002B%\u001f\u0011\u0005#1\n\u0005\t\u0005OzA\u0011A\"\u0003j!9!qO\b\u0005\n\te\u0004b\u0002BD\u001f\u0011%!\u0011\u0012\u0005\t\u0005#{A\u0011A\"\u0003\u0014\"A!\u0011U\b\u0005\u0002\r\u0013\u0019\u000bC\u0004\u00030>!IA!-\t\u000f\tmv\u0002\"\u0003\u0003>\"9!\u0011[\b\u0005\n\tM\u0007b\u0002Bm\u001f\u0011%!1\u001c\u0005\b\u0005G|A\u0011\u0002Bs\u0011\u001d\u0011io\u0004C\u0005\u0005_DqA!>\u0010\t\u0013\u00119\u0010C\u0004\u0003~>!IAa@\t\u000f\r\rq\u0002\"\u0003\u0004\u0006!91\u0011B\b\u0005\n\r-\u0001bBB\b\u001f\u0011%1\u0011C\u0001\u0007-\u0016\u001cGo\u001c:\u000b\u0005\u0011+\u0015!C5n[V$\u0018M\u00197f\u0015\t1u)\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001S\u0001\u0006g\u000e\fG.Y\u0002\u0001!\tY\u0015!D\u0001D\u0005\u00191Vm\u0019;peN\u0019\u0011A\u0014@\u0011\u0007=\u0013F+D\u0001Q\u0015\t\tV)A\u0004hK:,'/[2\n\u0005M\u0003&!E%oI\u0016DX\rZ*fc\u001a\u000b7\r^8ssB\u00111jD\u000b\u0003-v\u001b\u0012bD,hU6\fh0a\u0001\u0011\u0007aK6,D\u0001F\u0013\tQVIA\u0006BEN$(/Y2u'\u0016\f\bC\u0001/^\u0019\u0001!aAX\b\u0005\u0006\u0004y&!A!\u0012\u0005\u0001$\u0007CA1c\u001b\u00059\u0015BA2H\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!Y3\n\u0005\u0019<%aA!osB\u00191\n[.\n\u0005%\u001c%AC%oI\u0016DX\rZ*fcB!qj[.U\u0013\ta\u0007K\u0001\u000eHK:,'/[2Ue\u00064XM]:bE2,G+Z7qY\u0006$X\r\u0005\u0003Y]n\u0003\u0018BA8F\u00059Ie\u000eZ3yK\u0012\u001cV-\u001d'jW\u0016\u00042aS\b\\!\rY%\u000f^\u0005\u0003g\u000e\u0013QBV3di>\u0014\bk\\5oi\u0016\u0014(FA.vW\u00051\bCA<}\u001b\u0005A(BA={\u0003%)hn\u00195fG.,GM\u0003\u0002|\u000f\u0006Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005uD(!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dKB\u0011\u0011m`\u0005\u0004\u0003\u00039%\u0001D*fe&\fG.\u001b>bE2,\u0007C\u0002-\u0002\u0006m\u000bI!C\u0002\u0002\b\u0015\u0013AcQ;ti>l\u0007+\u0019:bY2,G.\u001b>bE2,\u0007#BA\u0006\u0003'YVBAA\u0007\u0015\r!\u0015q\u0002\u0006\u0004\u0003#)\u0015\u0001\u00039be\u0006dG.\u001a7\n\t\u0005U\u0011Q\u0002\u0002\n!\u0006\u0014h+Z2u_J\f!b\u001d;beRLe\u000eZ3y+\t\tY\u0002E\u0002b\u0003;I1!a\bH\u0005\rIe\u000e^\u0001\fgR\f'\u000f^%oI\u0016D\b%\u0001\u0005f]\u0012Le\u000eZ3y\u0003%)g\u000eZ%oI\u0016D\b%A\u0003g_\u000e,8/\u0001\u0004=S:LGO\u0010\u000b\ba\u00065\u0012qFA\u0019\u0011\u001d\t9\"\u0006a\u0001\u00037Aq!a\t\u0016\u0001\u0004\tY\u0002C\u0004\u0002(U\u0001\r!a\u0007\u0002\u0013\r|W\u000e]1oS>tWCAA\u001c!\u0011y\u0015\u0011\b+\n\u0007\u0005m\u0002K\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]\u0006)A-\u001b:usV\u0011\u0011\u0011\t\t\u0004C\u0006\r\u0013bAA#\u000f\n9!i\\8mK\u0006t\u0017!\u00033jeRLx\fJ3r)\u0011\tY%!\u0015\u0011\u0007\u0005\fi%C\u0002\u0002P\u001d\u0013A!\u00168ji\"I\u00111\u000b\r\u0002\u0002\u0003\u0007\u0011\u0011I\u0001\u0004q\u0012\n\u0014A\u00023jeRL\b%\u0001\u0004mK:<G\u000f[\u0001\u0004a\u0006\u0014XCAA\u0005\u0003!!xNV3di>\u0014X#\u00019\u0002\u001b1,gn\u001a;i\u0007>l\u0007/\u0019:f)\u0011\tY\"!\u001a\t\u000f\u0005\u001dT\u00041\u0001\u0002\u001c\u0005\u0019A.\u001a8\u0002\u0019%t\u0017\u000e^%uKJ\fGo\u001c:\u0016\t\u00055\u00141\u0010\u000b\u0005\u0003\u0017\ny\u0007C\u0004\u0002ry\u0001\r!a\u001d\u0002\u0003M\u0004RaSA;\u0003sJ1!a\u001eD\u000591Vm\u0019;pe&#XM]1u_J\u00042\u0001XA>\t\u001d\tiH\bb\u0001\u0003\u007f\u0012\u0011AQ\t\u00037\u0012\f\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0003\u000b\u0003BaSA;7\u0006y!/\u001a<feN,\u0017\n^3sCR|'/\u0006\u0002\u0002\fB!\u0001,!$\\\u0013\r\ty)\u0012\u0002\t\u0013R,'/\u0019;pe\u0006)\u0011\r\u001d9msR\u00191,!&\t\u000f\u0005]\u0015\u00051\u0001\u0002\u001c\u0005)\u0011N\u001c3fq\u0006\t2\r[3dWJ\u000bgnZ3D_:4XM\u001d;\u0015\t\u0005m\u0011Q\u0014\u0005\b\u0003/\u0013\u0003\u0019AA\u000e\u00031I7\u000fR3gCVdGo\u0011\"G+!\t\u0019+a-\u00028\u0006mF\u0003BA!\u0003KCq!a*$\u0001\u0004\tI+\u0001\u0002cMBIq*a+\u00020\u0006U\u0016\u0011X\u0005\u0004\u0003[\u0003&\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007\u0003B&\u0010\u0003c\u00032\u0001XAZ\t\u0015q6E1\u0001`!\ra\u0016q\u0017\u0003\u0007\u0003{\u001a#\u0019A0\u0011\u0007q\u000bY\f\u0002\u0004\u0002>\u000e\u0012\ra\u0018\u0002\u0005)\"\fG\u000fK\u0002$\u0003\u0003\u00042!YAb\u0013\r\t)m\u0012\u0002\u0007S:d\u0017N\\3\u0002\u000fU\u0004H-\u0019;fIV1\u00111ZAm\u0003#$b!!4\u0002\\\u0006uG\u0003BAh\u0003'\u00042\u0001XAi\t\u0019\ti\f\nb\u0001?\"9\u0011q\u0015\u0013A\u0004\u0005U\u0007\u0003C(\u0002,B\f9.a4\u0011\u0007q\u000bI\u000eB\u0004\u0002~\u0011\u0012\r!a \t\u000f\u0005]E\u00051\u0001\u0002\u001c!9\u0011q\u001c\u0013A\u0002\u0005]\u0017\u0001B3mK6\f1\u0002\n9mkN$3m\u001c7p]V1\u0011Q]Az\u0003W$B!a:\u0002vR!\u0011\u0011^Aw!\ra\u00161\u001e\u0003\u0007\u0003{+#\u0019A0\t\u000f\u0005\u001dV\u0005q\u0001\u0002pBAq*a+q\u0003c\fI\u000fE\u0002]\u0003g$q!! &\u0005\u0004\ty\bC\u0004\u0002`\u0016\u0002\r!!=\u0002\u0017\u0011\u001aw\u000e\\8oIAdWo]\u000b\u0007\u0003w\u0014IA!\u0001\u0015\t\u0005u(1\u0002\u000b\u0005\u0003\u007f\u0014\u0019\u0001E\u0002]\u0005\u0003!a!!0'\u0005\u0004y\u0006bBATM\u0001\u000f!Q\u0001\t\t\u001f\u0006-\u0006Oa\u0002\u0002\u0000B\u0019AL!\u0003\u0005\u000f\u0005udE1\u0001\u0002\u0000!9\u0011q\u001c\u0014A\u0002\t\u001d\u0011\u0001\u0002;bW\u0016$2\u0001\u001dB\t\u0011\u001d\u0011\u0019b\na\u0001\u00037\t\u0011A\\\u0001\u0005IJ|\u0007\u000fF\u0002q\u00053AqAa\u0005)\u0001\u0004\tY\"A\u0005uC.,'+[4iiR\u0019\u0001Oa\b\t\u000f\tM\u0011\u00061\u0001\u0002\u001c\u0005IAM]8q%&<\u0007\u000e\u001e\u000b\u0004a\n\u0015\u0002b\u0002B\nU\u0001\u0007\u00111D\u0001\u0005Q\u0016\fG-F\u0001\\\u0003\u0011!\u0018-\u001b7\u0002\t1\f7\u000f^\u0001\u0005S:LG/A\u0003tY&\u001cW\rF\u0003q\u0005k\u0011I\u0004C\u0004\u00038=\u0002\r!a\u0007\u0002\t\u0019\u0014x.\u001c\u0005\b\u0005wy\u0003\u0019AA\u000e\u0003\u0015)h\u000e^5m\u0003\u001d\u0019\b\u000f\\5u\u0003R$BA!\u0011\u0003HA)\u0011Ma\u0011qa&\u0019!QI$\u0003\rQ+\b\u000f\\33\u0011\u001d\u0011\u0019\u0002\ra\u0001\u00037\t!\u0002\n9mkN$\u0003\u000f\\;t+\u0019\u0011iEa\u0017\u0003TQ!!q\nB/)\u0011\u0011\tF!\u0016\u0011\u0007q\u0013\u0019\u0006\u0002\u0004\u0002>F\u0012\ra\u0018\u0005\b\u0003O\u000b\u00049\u0001B,!!y\u00151\u00169\u0003Z\tE\u0003c\u0001/\u0003\\\u00119\u0011QP\u0019C\u0002\u0005}\u0004b\u0002B0c\u0001\u0007!\u0011M\u0001\u0005i\"\fG\u000fE\u0003Y\u0005G\u0012I&C\u0002\u0003f\u0015\u0013!cR3o)J\fg/\u001a:tC\ndWm\u00148dK\u0006AQ\u000f\u001d3bi\u0016\fE/\u0006\u0003\u0003l\tEDC\u0002B7\u0005g\u0012)\b\u0005\u0003L\u001f\t=\u0004c\u0001/\u0003r\u00119\u0011Q\u0010\u001aC\u0002\u0005}\u0004bBALe\u0001\u0007\u00111\u0004\u0005\b\u0003?\u0014\u0004\u0019\u0001B8\u0003=9w\u000e^8Q_N<&/\u001b;bE2,G\u0003CA&\u0005w\u0012yHa!\t\u000f\tu4\u00071\u0001\u0002\u001c\u0005Aq\u000e\u001c3J]\u0012,\u0007\u0010C\u0004\u0003\u0002N\u0002\r!a\u0007\u0002\u00119,w/\u00138eKbDqA!\"4\u0001\u0004\tY\"A\u0002y_J\fAcZ8u_\u001a\u0013Xm\u001d5Q_N<&/\u001b;bE2,G\u0003CA&\u0005\u0017\u0013iIa$\t\u000f\tuD\u00071\u0001\u0002\u001c!9!\u0011\u0011\u001bA\u0002\u0005m\u0001b\u0002BCi\u0001\u0007\u00111D\u0001\fCB\u0004XM\u001c3Ge>tG/\u0006\u0003\u0003\u0016\nmE\u0003\u0002BL\u0005;\u0003BaS\b\u0003\u001aB\u0019ALa'\u0005\u000f\u0005uTG1\u0001\u0002\u0000!9!qT\u001bA\u0002\te\u0015!\u0002<bYV,\u0017AC1qa\u0016tGMQ1dWV!!Q\u0015BV)\u0011\u00119K!,\u0011\t-{!\u0011\u0016\t\u00049\n-FaBA?m\t\u0007\u0011q\u0010\u0005\b\u0005?3\u0004\u0019\u0001BU\u00035\u0019\b.\u001b4u)>\u0004H*\u001a<fYR1\u00111\nBZ\u0005oCqA!.8\u0001\u0004\tY\"A\u0004pY\u0012dUM\u001a;\t\u000f\tev\u00071\u0001\u0002\u001c\u00059a.Z<MK\u001a$\u0018\u0001\u0003>fe>dUM\u001a;\u0015\r\u0005-#q\u0018Bh\u0011\u001d\u0011\t\r\u000fa\u0001\u0005\u0007\fQ!\u0019:sCf\u0004R!\u0019Bc\u0005\u0013L1Aa2H\u0005\u0015\t%O]1z!\r\t'1Z\u0005\u0004\u0005\u001b<%AB!osJ+g\rC\u0004\u0002\u0018b\u0002\r!a\u0007\u0002\u0013i,'o\u001c*jO\"$HCBA&\u0005+\u00149\u000eC\u0004\u0003Bf\u0002\rAa1\t\u000f\u0005]\u0015\b1\u0001\u0002\u001c\u0005A1m\u001c9z\u0019\u00164G\u000f\u0006\u0004\u0003D\nu'q\u001c\u0005\b\u0005\u0003T\u0004\u0019\u0001Bb\u0011\u001d\u0011\tO\u000fa\u0001\u00037\tQA]5hQR\f\u0011bY8qsJKw\r\u001b;\u0015\r\t\r'q\u001dBu\u0011\u001d\u0011\tm\u000fa\u0001\u0005\u0007DqAa;<\u0001\u0004\tY\"\u0001\u0003mK\u001a$\u0018\u0001\u00039sK\u000ecW-\u00198\u0015\t\u0005-#\u0011\u001f\u0005\b\u0005gd\u0004\u0019AA\u000e\u0003\u0015!W\r\u001d;i\u00035\u0019G.Z1o\u0019\u00164G/\u00123hKR!\u00111\nB}\u0011\u001d\u0011Y0\u0010a\u0001\u00037\t\u0001bY;u\u0013:$W\r_\u0001\u000fG2,\u0017M\u001c*jO\"$X\tZ4f)\u0011\tYe!\u0001\t\u000f\tmh\b1\u0001\u0002\u001c\u0005i!/Z9vSJ,G\rR3qi\"$B!a\u0007\u0004\b!9!QQ A\u0002\u0005m\u0011A\u00033s_B4%o\u001c8uaQ\u0019\u0001o!\u0004\t\u000f\tm\b\t1\u0001\u0002\u001c\u0005IAM]8q\u0005\u0006\u001c7\u000e\r\u000b\u0004a\u000eM\u0001b\u0002B~\u0003\u0002\u0007\u00111\u0004\u0015\b\u001f\r]!qTB\u000f!\r\t7\u0011D\u0005\u0004\u000779%\u0001E*fe&\fGNV3sg&|g.V%E=!i?\u0010TxY]|\fE#\u0001&\u0002\u00159,wOQ;jY\u0012,'/\u0006\u0003\u0004&\rURCAB\u0014!!\u0019Ica\f\u00044\r]RBAB\u0016\u0015\r\u0019i#R\u0001\b[V$\u0018M\u00197f\u0013\u0011\u0019\tda\u000b\u0003\u000f\t+\u0018\u000e\u001c3feB\u0019Al!\u000e\u0005\u000by\u001b!\u0019A0\u0011\t-{11G\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0005\u0007{\u0019Y%\u0006\u0002\u0004@AIq*a+\u0004B\r%3Q\n\t\u0005\u0007\u0007\u001a)%D\u0001\u0002\u0013\u0011\u00199%!\u000f\u0003\t\r{G\u000e\u001c\t\u00049\u000e-C!\u00020\u0005\u0005\u0004y\u0006\u0003B&\u0010\u0007\u0013\n1AT%M+\t\u0019\u0019\u0006E\u0002L\u001f\u0001\fAAT%MA\u0005)Q-\u001c9usV!11LB1+\t\u0019i\u0006\u0005\u0003L\u001f\r}\u0003c\u0001/\u0004b\u0011)al\u0002b\u0001?\u0006\u0001Bj\\43\u0007>t7-\u0019;GCN$XM]\u000b\u0003\u0007Oz!a!\u001b\u001e\u0003\u0015\t\u0011\u0003T8he\r{gnY1u\r\u0006\u001cH/\u001a:!\u0003A!\u0016N\\=BaB,g\u000e\u001a$bgR,'/\u0006\u0002\u0004r=\u001111O\u000f\u0002\u0005\u0005\tB+\u001b8z\u0003B\u0004XM\u001c3GCN$XM\u001d\u0011\u0002\u001b\u0015l\u0007\u000f^=Ji\u0016\u0014\u0018\r^8s+\t\u0019Y\b\u0005\u0003L\u0003k\u0002\u0017AD3naRL\u0018\n^3sCR|'\u000fI\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0004\u0004B!1QQBH\u001b\t\u00199I\u0003\u0003\u0004\n\u000e-\u0015\u0001\u00027b]\u001eT!a!$\u0002\t)\fg/Y\u0005\u0005\u0007#\u001b9I\u0001\u0004PE*,7\r\u001e")
public final class Vector<A>
extends AbstractSeq<A>
implements scala.collection.immutable.IndexedSeq<A>,
VectorPointer<A>,
Serializable,
CustomParallelizable<A, ParVector<A>> {
    public static final long serialVersionUID = -1334388273712300479L;
    private final int startIndex;
    private final int endIndex;
    private final int focus;
    private boolean dirty;
    private int depth;
    private Object[] display0;
    private Object[] display1;
    private Object[] display2;
    private Object[] display3;
    private Object[] display4;
    private Object[] display5;

    public static <A> Vector<A> empty() {
        return Vector$.MODULE$.empty();
    }

    public static <A> CanBuildFrom<Vector<?>, A, Vector<A>> canBuildFrom() {
        return Vector$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return Vector$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)vector$).newBuilder();
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
        return Vector$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return Vector$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ tabulate_this = vector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ tabulate_this = vector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ tabulate_this = vector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ tabulate_this = vector$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return Vector$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ fill_this = vector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ fill_this = vector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ fill_this = vector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Vector$ fill_this = vector$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        Vector$ vector$ = Vector$.MODULE$;
        if (vector$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)vector$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return Vector$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return Vector$.MODULE$.ReusableCBF();
    }

    @Override
    public Combiner<A, ParVector<A>> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public final <U> void initFrom(VectorPointer<U> that) {
        VectorPointer.initFrom$(this, that);
    }

    @Override
    public final <U> void initFrom(VectorPointer<U> that, int depth) {
        VectorPointer.initFrom$(this, that, depth);
    }

    @Override
    public final A getElem(int index, int xor) {
        return (A)VectorPointer.getElem$(this, index, xor);
    }

    @Override
    public final void gotoPos(int index, int xor) {
        VectorPointer.gotoPos$(this, index, xor);
    }

    @Override
    public final void gotoNextBlockStart(int index, int xor) {
        VectorPointer.gotoNextBlockStart$(this, index, xor);
    }

    @Override
    public final void gotoNextBlockStartWritable(int index, int xor) {
        VectorPointer.gotoNextBlockStartWritable$(this, index, xor);
    }

    @Override
    public final Object[] copyOf(Object[] a) {
        return VectorPointer.copyOf$(this, a);
    }

    @Override
    public final Object[] nullSlotAndCopy(Object[] array, int index) {
        return VectorPointer.nullSlotAndCopy$(this, array, index);
    }

    @Override
    public final void stabilize(int index) {
        VectorPointer.stabilize$(this, index);
    }

    @Override
    public final void gotoPosWritable0(int newIndex, int xor) {
        VectorPointer.gotoPosWritable0$(this, newIndex, xor);
    }

    @Override
    public final void gotoPosWritable1(int oldIndex, int newIndex, int xor) {
        VectorPointer.gotoPosWritable1$(this, oldIndex, newIndex, xor);
    }

    @Override
    public final Object[] copyRange(Object[] array, int oldLeft, int newLeft) {
        return VectorPointer.copyRange$(this, array, oldLeft, newLeft);
    }

    @Override
    public final void gotoFreshPosWritable0(int oldIndex, int newIndex, int xor) {
        VectorPointer.gotoFreshPosWritable0$(this, oldIndex, newIndex, xor);
    }

    @Override
    public final void gotoFreshPosWritable1(int oldIndex, int newIndex, int xor) {
        VectorPointer.gotoFreshPosWritable1$(this, oldIndex, newIndex, xor);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<A> toIndexedSeq() {
        return scala.collection.immutable.IndexedSeq.toIndexedSeq$(this);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<A> seq() {
        return scala.collection.immutable.IndexedSeq.seq$(this);
    }

    @Override
    public int hashCode() {
        return IndexedSeqLike.hashCode$(this);
    }

    @Override
    public IndexedSeq<A> thisCollection() {
        return IndexedSeqLike.thisCollection$(this);
    }

    @Override
    public IndexedSeq toCollection(Object repr) {
        return IndexedSeqLike.toCollection$(this, repr);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return IndexedSeqLike.sizeHintIfCheap$(this);
    }

    @Override
    public scala.collection.immutable.Seq<A> toSeq() {
        return scala.collection.immutable.Seq.toSeq$(this);
    }

    @Override
    public int depth() {
        return this.depth;
    }

    @Override
    public void depth_$eq(int x$1) {
        this.depth = x$1;
    }

    @Override
    public Object[] display0() {
        return this.display0;
    }

    @Override
    public void display0_$eq(Object[] x$1) {
        this.display0 = x$1;
    }

    @Override
    public Object[] display1() {
        return this.display1;
    }

    @Override
    public void display1_$eq(Object[] x$1) {
        this.display1 = x$1;
    }

    @Override
    public Object[] display2() {
        return this.display2;
    }

    @Override
    public void display2_$eq(Object[] x$1) {
        this.display2 = x$1;
    }

    @Override
    public Object[] display3() {
        return this.display3;
    }

    @Override
    public void display3_$eq(Object[] x$1) {
        this.display3 = x$1;
    }

    @Override
    public Object[] display4() {
        return this.display4;
    }

    @Override
    public void display4_$eq(Object[] x$1) {
        this.display4 = x$1;
    }

    @Override
    public Object[] display5() {
        return this.display5;
    }

    @Override
    public void display5_$eq(Object[] x$1) {
        this.display5 = x$1;
    }

    public int startIndex() {
        return this.startIndex;
    }

    public int endIndex() {
        return this.endIndex;
    }

    @Override
    public GenericCompanion<Vector> companion() {
        return Vector$.MODULE$;
    }

    public boolean dirty() {
        return this.dirty;
    }

    public void dirty_$eq(boolean x$1) {
        this.dirty = x$1;
    }

    @Override
    public int length() {
        return this.endIndex() - this.startIndex();
    }

    @Override
    public ParVector<A> par() {
        return new ParVector(this);
    }

    @Override
    public Vector<A> toVector() {
        return this;
    }

    @Override
    public int lengthCompare(int len) {
        return this.length() - len;
    }

    public final <B> void initIterator(VectorIterator<B> s) {
        s.initFrom(this);
        if (this.dirty()) {
            s.stabilize(this.focus);
        }
        if (s.depth() > 1) {
            s.gotoPos(this.startIndex(), this.startIndex() ^ this.focus);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public VectorIterator<A> iterator() {
        void var1_1;
        if (this.length() == 0) {
            return Vector$.MODULE$.scala$collection$immutable$Vector$$emptyIterator();
        }
        VectorIterator s = new VectorIterator(this.startIndex(), this.endIndex());
        this.initIterator(s);
        return var1_1;
    }

    @Override
    public Iterator<A> reverseIterator() {
        return new AbstractIterator<A>(this){
            private int i;
            private final /* synthetic */ Vector $outer;

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                return 0 < this.i();
            }

            public A next() {
                if (0 < this.i()) {
                    this.i_$eq(this.i() - 1);
                    return this.$outer.apply(this.i());
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.i = $outer.length();
            }
        };
    }

    @Override
    public A apply(int index) {
        int idx = this.checkRangeConvert(index);
        return this.getElem(idx, idx ^ this.focus);
    }

    private int checkRangeConvert(int index) {
        int idx = index + this.startIndex();
        if (index >= 0 && idx < this.endIndex()) {
            return idx;
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(index)).toString());
    }

    private <A, B, That> boolean isDefaultCBF(CanBuildFrom<Vector<A>, B, That> bf) {
        return bf == Vector$.MODULE$.ReusableCBF() || bf == IndexedSeq$.MODULE$.ReusableCBF() || bf == scala.collection.IndexedSeq$.MODULE$.ReusableCBF() || bf == Seq$.MODULE$.ReusableCBF() || bf == scala.collection.Seq$.MODULE$.ReusableCBF();
    }

    @Override
    public <B, That> That updated(int index, B elem, CanBuildFrom<Vector<A>, B, That> bf) {
        if (bf == Vector$.MODULE$.ReusableCBF() || bf == IndexedSeq$.MODULE$.ReusableCBF() || bf == scala.collection.IndexedSeq$.MODULE$.ReusableCBF() || bf == Seq$.MODULE$.ReusableCBF() || bf == scala.collection.Seq$.MODULE$.ReusableCBF()) {
            return (That)this.updateAt(index, elem);
        }
        return (That)SeqLike.updated$(this, index, elem, bf);
    }

    @Override
    public <B, That> That $plus$colon(B elem, CanBuildFrom<Vector<A>, B, That> bf) {
        if (bf == Vector$.MODULE$.ReusableCBF() || bf == IndexedSeq$.MODULE$.ReusableCBF() || bf == scala.collection.IndexedSeq$.MODULE$.ReusableCBF() || bf == Seq$.MODULE$.ReusableCBF() || bf == scala.collection.Seq$.MODULE$.ReusableCBF()) {
            return (That)this.appendFront(elem);
        }
        return (That)SeqLike.$plus$colon$(this, elem, bf);
    }

    @Override
    public <B, That> That $colon$plus(B elem, CanBuildFrom<Vector<A>, B, That> bf) {
        if (bf == Vector$.MODULE$.ReusableCBF() || bf == IndexedSeq$.MODULE$.ReusableCBF() || bf == scala.collection.IndexedSeq$.MODULE$.ReusableCBF() || bf == Seq$.MODULE$.ReusableCBF() || bf == scala.collection.Seq$.MODULE$.ReusableCBF()) {
            return (That)this.appendBack(elem);
        }
        return (That)SeqLike.$colon$plus$(this, elem, bf);
    }

    @Override
    public Vector<A> take(int n) {
        if (n <= 0) {
            return Vector$.MODULE$.empty();
        }
        if (this.startIndex() < this.endIndex() - n) {
            return this.dropBack0(this.startIndex() + n);
        }
        return this;
    }

    @Override
    public Vector<A> drop(int n) {
        if (n <= 0) {
            return this;
        }
        if (this.startIndex() < this.endIndex() - n) {
            return this.dropFront0(this.startIndex() + n);
        }
        return Vector$.MODULE$.empty();
    }

    @Override
    public Vector<A> takeRight(int n) {
        if (n <= 0) {
            return Vector$.MODULE$.empty();
        }
        if (this.endIndex() - n > this.startIndex()) {
            return this.dropFront0(this.endIndex() - n);
        }
        return this;
    }

    @Override
    public Vector<A> dropRight(int n) {
        if (n <= 0) {
            return this;
        }
        if (this.endIndex() - n > this.startIndex()) {
            return this.dropBack0(this.endIndex() - n);
        }
        return Vector$.MODULE$.empty();
    }

    @Override
    public A head() {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.head");
        }
        return this.apply(0);
    }

    @Override
    public Vector<A> tail() {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.tail");
        }
        return this.drop(1);
    }

    @Override
    public A last() {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.last");
        }
        return this.apply(this.length() - 1);
    }

    @Override
    public Vector<A> init() {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.init");
        }
        return this.dropRight(1);
    }

    @Override
    public Vector<A> slice(int from, int until) {
        return ((Vector)this.take(until)).drop(from);
    }

    @Override
    public Tuple2<Vector<A>, Vector<A>> splitAt(int n) {
        return new Tuple2<Object, Object>(this.take(n), this.drop(n));
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Vector<A>, B, That> bf) {
        if (bf == Vector$.MODULE$.ReusableCBF() || bf == IndexedSeq$.MODULE$.ReusableCBF() || bf == scala.collection.IndexedSeq$.MODULE$.ReusableCBF() || bf == Seq$.MODULE$.ReusableCBF() || bf == scala.collection.Seq$.MODULE$.ReusableCBF()) {
            if (that.isEmpty()) {
                return (That)this;
            }
            TraversableOnce<B> again = !that.isTraversableAgain() ? that.toVector() : that.seq();
            int n = again.size();
            switch (n) {
                default: 
            }
            if (n <= 2 || n < this.size() >>> 5) {
                ObjectRef<Vector> v = ObjectRef.create(this);
                again.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                    v.elem = ((Vector)v.elem).$colon$plus((B)x, Vector$.MODULE$.canBuildFrom());
                    return BoxedUnit.UNIT;
                });
                return (That)((Vector)v.elem);
            }
            if (this.size() < n >>> 5 && again instanceof Vector) {
                Vector<?> v = (Vector<?>)again;
                Iterator<A> ri = this.reverseIterator();
                while (ri.hasNext()) {
                    A a = ri.next();
                    v = v.$plus$colon((B)a, Vector$.MODULE$.canBuildFrom());
                }
                return (That)v;
            }
            return (That)TraversableLike.$plus$plus$(this, again, bf);
        }
        return (That)TraversableLike.$plus$plus$(this, that.seq(), bf);
    }

    public <B> Vector<B> updateAt(int index, B elem) {
        int idx = this.checkRangeConvert(index);
        Vector<A> s = new Vector<A>(this.startIndex(), this.endIndex(), idx);
        s.initFrom(this);
        s.dirty_$eq(this.dirty());
        super.gotoPosWritable(this.focus, idx, this.focus ^ idx);
        s.display0()[idx & 0x1F] = elem;
        return s;
    }

    private void gotoPosWritable(int oldIndex, int newIndex, int xor) {
        if (this.dirty()) {
            this.gotoPosWritable1(oldIndex, newIndex, xor);
            return;
        }
        this.gotoPosWritable0(newIndex, xor);
        this.dirty_$eq(true);
    }

    private void gotoFreshPosWritable(int oldIndex, int newIndex, int xor) {
        if (this.dirty()) {
            this.gotoFreshPosWritable1(oldIndex, newIndex, xor);
            return;
        }
        this.gotoFreshPosWritable0(oldIndex, newIndex, xor);
        this.dirty_$eq(true);
    }

    public <B> Vector<B> appendFront(B value) {
        if (this.endIndex() != this.startIndex()) {
            int blockIndex = this.startIndex() - 1 & ~31;
            int lo = this.startIndex() - 1 & 0x1F;
            if (this.startIndex() != blockIndex + 32) {
                Vector<A> s = new Vector<A>(this.startIndex() - 1, this.endIndex(), blockIndex);
                s.initFrom(this);
                s.dirty_$eq(this.dirty());
                super.gotoPosWritable(this.focus, blockIndex, this.focus ^ blockIndex);
                s.display0()[lo] = value;
                return s;
            }
            int freeSpace = (1 << 5 * this.depth()) - this.endIndex();
            int shift = freeSpace & ~((1 << 5 * (this.depth() - 1)) - 1);
            int shiftBlocks = freeSpace >>> 5 * (this.depth() - 1);
            if (shift != 0) {
                if (this.depth() > 1) {
                    int newBlockIndex = blockIndex + shift;
                    int newFocus = this.focus + shift;
                    Vector<A> s = new Vector<A>(this.startIndex() - 1 + shift, this.endIndex() + shift, newBlockIndex);
                    s.initFrom(this);
                    s.dirty_$eq(this.dirty());
                    super.shiftTopLevel(0, shiftBlocks);
                    super.gotoFreshPosWritable(newFocus, newBlockIndex, newFocus ^ newBlockIndex);
                    s.display0()[lo] = value;
                    return s;
                }
                int newBlockIndex = blockIndex + 32;
                int newFocus = this.focus;
                Vector<A> s = new Vector<A>(this.startIndex() - 1 + shift, this.endIndex() + shift, newBlockIndex);
                s.initFrom(this);
                s.dirty_$eq(this.dirty());
                super.shiftTopLevel(0, shiftBlocks);
                super.gotoPosWritable(newFocus, newBlockIndex, newFocus ^ newBlockIndex);
                s.display0()[shift - 1] = value;
                return s;
            }
            if (blockIndex < 0) {
                int move = (1 << 5 * (this.depth() + 1)) - (1 << 5 * this.depth());
                int newBlockIndex = blockIndex + move;
                int newFocus = this.focus + move;
                Vector<A> s = new Vector<A>(this.startIndex() - 1 + move, this.endIndex() + move, newBlockIndex);
                s.initFrom(this);
                s.dirty_$eq(this.dirty());
                super.gotoFreshPosWritable(newFocus, newBlockIndex, newFocus ^ newBlockIndex);
                s.display0()[lo] = value;
                return s;
            }
            int newFocus = this.focus;
            Vector<A> s = new Vector<A>(this.startIndex() - 1, this.endIndex(), blockIndex);
            s.initFrom(this);
            s.dirty_$eq(this.dirty());
            super.gotoFreshPosWritable(newFocus, blockIndex, newFocus ^ blockIndex);
            s.display0()[lo] = value;
            return s;
        }
        Object[] elems = new Object[32];
        elems[31] = value;
        Vector<A> s = new Vector<A>(31, 32, 0);
        s.depth_$eq(1);
        s.display0_$eq(elems);
        return s;
    }

    public <B> Vector<B> appendBack(B value) {
        if (this.endIndex() != this.startIndex()) {
            int blockIndex = this.endIndex() & ~31;
            int lo = this.endIndex() & 0x1F;
            if (this.endIndex() != blockIndex) {
                Vector<A> s = new Vector<A>(this.startIndex(), this.endIndex() + 1, blockIndex);
                s.initFrom(this);
                s.dirty_$eq(this.dirty());
                super.gotoPosWritable(this.focus, blockIndex, this.focus ^ blockIndex);
                s.display0()[lo] = value;
                return s;
            }
            int shift = this.startIndex() & ~((1 << 5 * (this.depth() - 1)) - 1);
            int shiftBlocks = this.startIndex() >>> 5 * (this.depth() - 1);
            if (shift != 0) {
                if (this.depth() > 1) {
                    int newBlockIndex = blockIndex - shift;
                    int newFocus = this.focus - shift;
                    Vector<A> s = new Vector<A>(this.startIndex() - shift, this.endIndex() + 1 - shift, newBlockIndex);
                    s.initFrom(this);
                    s.dirty_$eq(this.dirty());
                    super.shiftTopLevel(shiftBlocks, 0);
                    super.gotoFreshPosWritable(newFocus, newBlockIndex, newFocus ^ newBlockIndex);
                    s.display0()[lo] = value;
                    return s;
                }
                int newBlockIndex = blockIndex - 32;
                int newFocus = this.focus;
                Vector<A> s = new Vector<A>(this.startIndex() - shift, this.endIndex() + 1 - shift, newBlockIndex);
                s.initFrom(this);
                s.dirty_$eq(this.dirty());
                super.shiftTopLevel(shiftBlocks, 0);
                super.gotoPosWritable(newFocus, newBlockIndex, newFocus ^ newBlockIndex);
                s.display0()[32 - shift] = value;
                return s;
            }
            int newFocus = this.focus;
            Vector<A> s = new Vector<A>(this.startIndex(), this.endIndex() + 1, blockIndex);
            s.initFrom(this);
            s.dirty_$eq(this.dirty());
            super.gotoFreshPosWritable(newFocus, blockIndex, newFocus ^ blockIndex);
            s.display0()[lo] = value;
            return s;
        }
        Object[] elems = new Object[32];
        elems[0] = value;
        Vector<A> s = new Vector<A>(0, 1, 0);
        s.depth_$eq(1);
        s.display0_$eq(elems);
        return s;
    }

    private void shiftTopLevel(int oldLeft, int newLeft) {
        int n = this.depth() - 1;
        switch (n) {
            case 0: {
                this.display0_$eq(this.copyRange(this.display0(), oldLeft, newLeft));
                return;
            }
            case 1: {
                this.display1_$eq(this.copyRange(this.display1(), oldLeft, newLeft));
                return;
            }
            case 2: {
                this.display2_$eq(this.copyRange(this.display2(), oldLeft, newLeft));
                return;
            }
            case 3: {
                this.display3_$eq(this.copyRange(this.display3(), oldLeft, newLeft));
                return;
            }
            case 4: {
                this.display4_$eq(this.copyRange(this.display4(), oldLeft, newLeft));
                return;
            }
            case 5: {
                this.display5_$eq(this.copyRange(this.display5(), oldLeft, newLeft));
                return;
            }
        }
        throw new MatchError(BoxesRunTime.boxToInteger(n));
    }

    private void zeroLeft(Object[] array, int index) {
        for (int i = 0; i < index; ++i) {
            array[i] = null;
        }
    }

    private void zeroRight(Object[] array, int index) {
        for (int i = index; i < array.length; ++i) {
            array[i] = null;
        }
    }

    /*
     * WARNING - void declaration
     */
    private Object[] copyLeft(Object[] array, int right) {
        void var3_3;
        Object[] copy = new Object[array.length];
        System.arraycopy(array, 0, copy, 0, right);
        return var3_3;
    }

    /*
     * WARNING - void declaration
     */
    private Object[] copyRight(Object[] array, int left) {
        void var3_3;
        Object[] copy = new Object[array.length];
        System.arraycopy(array, left, copy, left, copy.length - left);
        return var3_3;
    }

    private void preClean(int depth) {
        this.depth_$eq(depth);
        int n = depth - 1;
        switch (n) {
            case 0: {
                this.display1_$eq(null);
                this.display2_$eq(null);
                this.display3_$eq(null);
                this.display4_$eq(null);
                this.display5_$eq(null);
                return;
            }
            case 1: {
                this.display2_$eq(null);
                this.display3_$eq(null);
                this.display4_$eq(null);
                this.display5_$eq(null);
                return;
            }
            case 2: {
                this.display3_$eq(null);
                this.display4_$eq(null);
                this.display5_$eq(null);
                return;
            }
            case 3: {
                this.display4_$eq(null);
                this.display5_$eq(null);
                return;
            }
            case 4: {
                this.display5_$eq(null);
                return;
            }
            case 5: {
                return;
            }
        }
        throw new MatchError(BoxesRunTime.boxToInteger(n));
    }

    private void cleanLeftEdge(int cutIndex) {
        if (cutIndex < 32) {
            this.zeroLeft(this.display0(), cutIndex);
            return;
        }
        if (cutIndex < 1024) {
            this.zeroLeft(this.display0(), cutIndex & 0x1F);
            this.display1_$eq(this.copyRight(this.display1(), cutIndex >>> 5));
            return;
        }
        if (cutIndex < 32768) {
            this.zeroLeft(this.display0(), cutIndex & 0x1F);
            this.display1_$eq(this.copyRight(this.display1(), cutIndex >>> 5 & 0x1F));
            this.display2_$eq(this.copyRight(this.display2(), cutIndex >>> 10));
            return;
        }
        if (cutIndex < 0x100000) {
            this.zeroLeft(this.display0(), cutIndex & 0x1F);
            this.display1_$eq(this.copyRight(this.display1(), cutIndex >>> 5 & 0x1F));
            this.display2_$eq(this.copyRight(this.display2(), cutIndex >>> 10 & 0x1F));
            this.display3_$eq(this.copyRight(this.display3(), cutIndex >>> 15));
            return;
        }
        if (cutIndex < 0x2000000) {
            this.zeroLeft(this.display0(), cutIndex & 0x1F);
            this.display1_$eq(this.copyRight(this.display1(), cutIndex >>> 5 & 0x1F));
            this.display2_$eq(this.copyRight(this.display2(), cutIndex >>> 10 & 0x1F));
            this.display3_$eq(this.copyRight(this.display3(), cutIndex >>> 15 & 0x1F));
            this.display4_$eq(this.copyRight(this.display4(), cutIndex >>> 20));
            return;
        }
        if (cutIndex < 0x40000000) {
            this.zeroLeft(this.display0(), cutIndex & 0x1F);
            this.display1_$eq(this.copyRight(this.display1(), cutIndex >>> 5 & 0x1F));
            this.display2_$eq(this.copyRight(this.display2(), cutIndex >>> 10 & 0x1F));
            this.display3_$eq(this.copyRight(this.display3(), cutIndex >>> 15 & 0x1F));
            this.display4_$eq(this.copyRight(this.display4(), cutIndex >>> 20 & 0x1F));
            this.display5_$eq(this.copyRight(this.display5(), cutIndex >>> 25));
            return;
        }
        throw new IllegalArgumentException();
    }

    private void cleanRightEdge(int cutIndex) {
        if (cutIndex <= 32) {
            this.zeroRight(this.display0(), cutIndex);
            return;
        }
        if (cutIndex <= 1024) {
            this.zeroRight(this.display0(), (cutIndex - 1 & 0x1F) + 1);
            this.display1_$eq(this.copyLeft(this.display1(), cutIndex >>> 5));
            return;
        }
        if (cutIndex <= 32768) {
            this.zeroRight(this.display0(), (cutIndex - 1 & 0x1F) + 1);
            this.display1_$eq(this.copyLeft(this.display1(), (cutIndex - 1 >>> 5 & 0x1F) + 1));
            this.display2_$eq(this.copyLeft(this.display2(), cutIndex >>> 10));
            return;
        }
        if (cutIndex <= 0x100000) {
            this.zeroRight(this.display0(), (cutIndex - 1 & 0x1F) + 1);
            this.display1_$eq(this.copyLeft(this.display1(), (cutIndex - 1 >>> 5 & 0x1F) + 1));
            this.display2_$eq(this.copyLeft(this.display2(), (cutIndex - 1 >>> 10 & 0x1F) + 1));
            this.display3_$eq(this.copyLeft(this.display3(), cutIndex >>> 15));
            return;
        }
        if (cutIndex <= 0x2000000) {
            this.zeroRight(this.display0(), (cutIndex - 1 & 0x1F) + 1);
            this.display1_$eq(this.copyLeft(this.display1(), (cutIndex - 1 >>> 5 & 0x1F) + 1));
            this.display2_$eq(this.copyLeft(this.display2(), (cutIndex - 1 >>> 10 & 0x1F) + 1));
            this.display3_$eq(this.copyLeft(this.display3(), (cutIndex - 1 >>> 15 & 0x1F) + 1));
            this.display4_$eq(this.copyLeft(this.display4(), cutIndex >>> 20));
            return;
        }
        if (cutIndex <= 0x40000000) {
            this.zeroRight(this.display0(), (cutIndex - 1 & 0x1F) + 1);
            this.display1_$eq(this.copyLeft(this.display1(), (cutIndex - 1 >>> 5 & 0x1F) + 1));
            this.display2_$eq(this.copyLeft(this.display2(), (cutIndex - 1 >>> 10 & 0x1F) + 1));
            this.display3_$eq(this.copyLeft(this.display3(), (cutIndex - 1 >>> 15 & 0x1F) + 1));
            this.display4_$eq(this.copyLeft(this.display4(), (cutIndex - 1 >>> 20 & 0x1F) + 1));
            this.display5_$eq(this.copyLeft(this.display5(), cutIndex >>> 25));
            return;
        }
        throw new IllegalArgumentException();
    }

    private int requiredDepth(int xor) {
        if (xor < 32) {
            return 1;
        }
        if (xor < 1024) {
            return 2;
        }
        if (xor < 32768) {
            return 3;
        }
        if (xor < 0x100000) {
            return 4;
        }
        if (xor < 0x2000000) {
            return 5;
        }
        if (xor < 0x40000000) {
            return 6;
        }
        throw new IllegalArgumentException();
    }

    private Vector<A> dropFront0(int cutIndex) {
        int blockIndex = cutIndex & ~31;
        int xor = cutIndex ^ this.endIndex() - 1;
        int d = this.requiredDepth(xor);
        int shift = cutIndex & ~((1 << 5 * d) - 1);
        Vector<A> s = new Vector<A>(cutIndex - shift, this.endIndex() - shift, blockIndex - shift);
        s.initFrom(this);
        s.dirty_$eq(this.dirty());
        super.gotoPosWritable(this.focus, blockIndex, this.focus ^ blockIndex);
        super.preClean(d);
        super.cleanLeftEdge(cutIndex - shift);
        return s;
    }

    private Vector<A> dropBack0(int cutIndex) {
        int blockIndex = cutIndex - 1 & ~31;
        int xor = this.startIndex() ^ cutIndex - 1;
        int d = this.requiredDepth(xor);
        int shift = this.startIndex() & ~((1 << 5 * d) - 1);
        Vector<A> s = new Vector<A>(this.startIndex() - shift, cutIndex - shift, blockIndex - shift);
        s.initFrom(this);
        s.dirty_$eq(this.dirty());
        super.gotoPosWritable(this.focus, blockIndex, this.focus ^ blockIndex);
        super.preClean(d);
        super.cleanRightEdge(cutIndex - shift);
        return s;
    }

    public Vector(int startIndex, int endIndex, int focus) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.focus = focus;
        Traversable.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Seq.$init$(this);
        IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        scala.collection.immutable.IndexedSeq.$init$(this);
        VectorPointer.$init$(this);
        CustomParallelizable.$init$(this);
        this.dirty = false;
    }
}

