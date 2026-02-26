/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Proxy;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableView;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0011]eaB$I!\u0003\r\t!\u0014\u0005\u0006_\u0002!\t\u0001\u001d\u0005\u0006i\u00021\t!\u001e\u0005\u0006m\u0002!\te\u001e\u0005\b\u0003\u0007\u0001A\u0011IA\u0003\u0011\u001d\ti\u0001\u0001C!\u0003\u000bAq!a\u0004\u0001\t\u0003\n\t\u0002C\u0004\u0002\u001a\u0001!\t%!\u0002\t\u000f\u0005m\u0001\u0001\"\u0011\u0002\u001e!9\u00111\n\u0001\u0005B\u00055\u0003bBA2\u0001\u0011\u0005\u0013Q\r\u0005\b\u0003{\u0002A\u0011IA@\u0011\u001d\t9\t\u0001C!\u0003\u0013Cq!!$\u0001\t\u0003\ny\tC\u0004\u0002,\u0002!\t%!,\t\u000f\u0005]\u0006\u0001\"\u0011\u0002:\"9\u00111\u001b\u0001\u0005B\u0005U\u0007bBAm\u0001\u0011\u0005\u00131\u001c\u0005\b\u0003?\u0004A\u0011IAq\u0011\u001d\t)\u000f\u0001C!\u0003ODq!!=\u0001\t\u0003\n\u0019\u0010C\u0004\u0003\f\u0001!\tE!\u0004\t\u000f\tu\u0001\u0001\"\u0011\u0003 !9!q\u0006\u0001\u0005B\tE\u0002b\u0002B!\u0001\u0011\u0005#1\t\u0005\b\u0005\u001f\u0002A\u0011\tB)\u0011\u001d\u0011y\u0006\u0001C!\u0005CBqA!\u001c\u0001\t\u0003\u0012y\u0007C\u0004\u0003~\u0001!\tEa \t\u000f\te\u0005\u0001\"\u0011\u0003\u001c\"9!Q\u0017\u0001\u0005B\t]\u0006b\u0002Bi\u0001\u0011\u0005#1\u001b\u0005\b\u0005?\u0004A\u0011\tBq\u0011\u001d\u0011\u0019\u0010\u0001C!\u0005kDqa!\u0001\u0001\t\u0003\u001a\u0019\u0001C\u0004\u0004\u0006\u0001!\tea\u0002\t\r\r%\u0001\u0001\"\u0011v\u0011\u001d\u0019Y\u0001\u0001C!\u0007\u0007Aqa!\u0004\u0001\t\u0003\u001a9\u0001\u0003\u0004\u0004\u0010\u0001!\t%\u001e\u0005\b\u0007#\u0001A\u0011IB\n\u0011\u001d\u0019I\u0002\u0001C!\u00077Aqaa\b\u0001\t\u0003\u001a\t\u0003C\u0004\u0004,\u0001!\te!\f\t\u000f\rE\u0002\u0001\"\u0011\u00044!91q\u0007\u0001\u0005B\re\u0002bBB\u001f\u0001\u0011\u00053q\b\u0005\b\u0007\u0007\u0002A\u0011IB#\u0011\u001d\u0019i\u0006\u0001C!\u0007?Bqa!\u0018\u0001\t\u0003\u001a9\bC\u0004\u0004^\u0001!\te!\"\t\u000f\rE\u0005\u0001\"\u0011\u0004\u0014\"91Q\u0016\u0001\u0005B\r=\u0006bBB\\\u0001\u0011\u00053\u0011\u0018\u0005\b\u0007\u0003\u0004A\u0011IBb\u0011\u001d\u0019Y\r\u0001C!\u0007\u001bDqa!6\u0001\t\u0003\u001a9\u000eC\u0004\u0004b\u0002!\tea9\t\u000f\r-\b\u0001\"\u0011\u0004n\"911 \u0001\u0005B\ru\bb\u0002C\u0015\u0001\u0011\u0005C1\u0006\u0005\b\t[\u0001A\u0011\tC\u0018\u0011\u001d!9\u0004\u0001C!\tsAq\u0001b\u000e\u0001\t\u0003\"Y\u0005C\u0004\u00058\u0001!\t\u0005b\u0014\t\u000f\u0011E\u0003\u0001\"\u0011\u0005T!9A\u0011\u000b\u0001\u0005B\u0011\u0015\u0004b\u0002C)\u0001\u0011\u0005C1\u000e\u0005\b\t_\u0002A\u0011\tC(\u0011\u001d!\t\b\u0001C!\tgBq\u0001\"\u001d\u0001\t\u0003\"\tI\u0001\u000bUe\u00064XM]:bE2,\u0007K]8ys2K7.\u001a\u0006\u0003\u0013*\u000b!bY8mY\u0016\u001cG/[8o\u0015\u0005Y\u0015!B:dC2\f7\u0001A\u000b\u0004\u001df\u001b7\u0003\u0002\u0001P'2\u0004\"\u0001U)\u000e\u0003)K!A\u0015&\u0003\r\u0005s\u0017PU3g!\u0011!Vk\u00162\u000e\u0003!K!A\u0016%\u0003\u001fQ\u0013\u0018M^3sg\u0006\u0014G.\u001a'jW\u0016\u0004\"\u0001W-\r\u0001\u00111!\f\u0001CC\u0002m\u0013\u0011!Q\t\u00039~\u0003\"\u0001U/\n\u0005yS%a\u0002(pi\"Lgn\u001a\t\u0003!\u0002L!!\u0019&\u0003\u0007\u0005s\u0017\u0010\u0005\u0002YG\u00121A\r\u0001CC\u0002\u0015\u0014AAU3qeF\u0011AL\u001a\n\u0004ONKg\u0001\u00025\u0001\u0001\u0019\u0014A\u0002\u0010:fM&tW-\\3oiz\u00022\u0001\u00166X\u0013\tY\u0007JA\u0006Ue\u00064XM]:bE2,\u0007C\u0001)n\u0013\tq'JA\u0003Qe>D\u00180\u0001\u0004%S:LG\u000f\n\u000b\u0002cB\u0011\u0001K]\u0005\u0003g*\u0013A!\u00168ji\u0006!1/\u001a7g+\u0005\u0011\u0017a\u00024pe\u0016\f7\r[\u000b\u0003q~$\"!]=\t\u000bi\u001c\u0001\u0019A>\u0002\u0003\u0019\u0004B\u0001\u0015?X}&\u0011QP\u0013\u0002\n\rVt7\r^5p]F\u0002\"\u0001W@\u0005\r\u0005\u00051A1\u0001\\\u0005\u0005)\u0016aB5t\u000b6\u0004H/_\u000b\u0003\u0003\u000f\u00012\u0001UA\u0005\u0013\r\tYA\u0013\u0002\b\u0005>|G.Z1o\u0003!qwN\\#naRL\u0018\u0001B:ju\u0016,\"!a\u0005\u0011\u0007A\u000b)\"C\u0002\u0002\u0018)\u00131!\u00138u\u0003=A\u0017m\u001d#fM&t\u0017\u000e^3TSj,\u0017A\u0003\u0013qYV\u001cH\u0005\u001d7vgV1\u0011qDA\u001e\u0003K!B!!\t\u0002BQ!\u00111EA\u0015!\rA\u0016Q\u0005\u0003\u0007\u0003OA!\u0019A.\u0003\tQC\u0017\r\u001e\u0005\b\u0003WA\u00019AA\u0017\u0003\t\u0011g\rE\u0005\u00020\u0005U\"-!\u000f\u0002$5\u0011\u0011\u0011\u0007\u0006\u0004\u0003gA\u0015aB4f]\u0016\u0014\u0018nY\u0005\u0005\u0003o\t\tD\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000eE\u0002Y\u0003w!q!!\u0010\t\u0005\u0004\tyDA\u0001C#\t9v\fC\u0004\u0002D!\u0001\r!!\u0012\u0002\u0005a\u001c\b#\u0002+\u0002H\u0005e\u0012bAA%\u0011\n\u0011r)\u001a8Ue\u00064XM]:bE2,wJ\\2f\u0003\ri\u0017\r]\u000b\u0007\u0003\u001f\ni&!\u0016\u0015\t\u0005E\u0013q\f\u000b\u0005\u0003'\n9\u0006E\u0002Y\u0003+\"a!a\n\n\u0005\u0004Y\u0006bBA\u0016\u0013\u0001\u000f\u0011\u0011\f\t\n\u0003_\t)DYA.\u0003'\u00022\u0001WA/\t\u0019\ti$\u0003b\u00017\"1!0\u0003a\u0001\u0003C\u0002R\u0001\u0015?X\u00037\nqA\u001a7bi6\u000b\u0007/\u0006\u0004\u0002h\u0005U\u0014Q\u000e\u000b\u0005\u0003S\n9\b\u0006\u0003\u0002l\u0005=\u0004c\u0001-\u0002n\u00111\u0011q\u0005\u0006C\u0002mCq!a\u000b\u000b\u0001\b\t\t\bE\u0005\u00020\u0005U\"-a\u001d\u0002lA\u0019\u0001,!\u001e\u0005\r\u0005u\"B1\u0001\\\u0011\u0019Q(\u00021\u0001\u0002zA)\u0001\u000b`,\u0002|A)A+a\u0012\u0002t\u00051a-\u001b7uKJ$2AYAA\u0011\u001d\t\u0019i\u0003a\u0001\u0003\u000b\u000b\u0011\u0001\u001d\t\u0006!r<\u0016qA\u0001\nM&dG/\u001a:O_R$2AYAF\u0011\u001d\t\u0019\t\u0004a\u0001\u0003\u000b\u000bqaY8mY\u0016\u001cG/\u0006\u0004\u0002\u0012\u0006}\u0015q\u0013\u000b\u0005\u0003'\u000b\t\u000b\u0006\u0003\u0002\u0016\u0006e\u0005c\u0001-\u0002\u0018\u00121\u0011qE\u0007C\u0002mCq!a\u000b\u000e\u0001\b\tY\nE\u0005\u00020\u0005U\"-!(\u0002\u0016B\u0019\u0001,a(\u0005\r\u0005uRB1\u0001\\\u0011\u001d\t\u0019+\u0004a\u0001\u0003K\u000b!\u0001\u001d4\u0011\rA\u000b9kVAO\u0013\r\tIK\u0013\u0002\u0010!\u0006\u0014H/[1m\rVt7\r^5p]\u0006I\u0001/\u0019:uSRLwN\u001c\u000b\u0005\u0003_\u000b)\fE\u0003Q\u0003c\u0013'-C\u0002\u00024*\u0013a\u0001V;qY\u0016\u0014\u0004bBAB\u001d\u0001\u0007\u0011QQ\u0001\bOJ|W\u000f\u001d\"z+\u0011\tY,a3\u0015\t\u0005u\u0016q\u001a\t\b\u0003\u007f\u000b)-!3c\u001b\t\t\tMC\u0002\u0002D\"\u000b\u0011\"[7nkR\f'\r\\3\n\t\u0005\u001d\u0017\u0011\u0019\u0002\u0004\u001b\u0006\u0004\bc\u0001-\u0002L\u00121\u0011QZ\bC\u0002m\u0013\u0011a\u0013\u0005\u0007u>\u0001\r!!5\u0011\u000bAcx+!3\u0002\r\u0019|'/\u00197m)\u0011\t9!a6\t\u000f\u0005\r\u0005\u00031\u0001\u0002\u0006\u00061Q\r_5tiN$B!a\u0002\u0002^\"9\u00111Q\tA\u0002\u0005\u0015\u0015!B2pk:$H\u0003BA\n\u0003GDq!a!\u0013\u0001\u0004\t))\u0001\u0003gS:$G\u0003BAu\u0003_\u0004B\u0001UAv/&\u0019\u0011Q\u001e&\u0003\r=\u0003H/[8o\u0011\u001d\t\u0019i\u0005a\u0001\u0003\u000b\u000b\u0001BZ8mI2+g\r^\u000b\u0005\u0003k\fY\u0010\u0006\u0003\u0002x\n\u001dA\u0003BA}\u0003{\u00042\u0001WA~\t\u0019\ti\u0004\u0006b\u00017\"9\u0011q \u000bA\u0002\t\u0005\u0011AA8q!!\u0001&1AA}/\u0006e\u0018b\u0001B\u0003\u0015\nIa)\u001e8di&|gN\r\u0005\b\u0005\u0013!\u0002\u0019AA}\u0003\u0005Q\u0018A\u0003\u0013eSZ$3m\u001c7p]V!!q\u0002B\u000b)\u0011\u0011\tBa\u0007\u0015\t\tM!q\u0003\t\u00041\nUAABA\u001f+\t\u00071\fC\u0004\u0002\u0000V\u0001\rA!\u0007\u0011\u0011A\u0013\u0019Aa\u0005X\u0005'AqA!\u0003\u0016\u0001\u0004\u0011\u0019\"A\u0005g_2$'+[4iiV!!\u0011\u0005B\u0014)\u0011\u0011\u0019C!\f\u0015\t\t\u0015\"\u0011\u0006\t\u00041\n\u001dBABA\u001f-\t\u00071\fC\u0004\u0002\u0000Z\u0001\rAa\u000b\u0011\u0011A\u0013\u0019a\u0016B\u0013\u0005KAqA!\u0003\u0017\u0001\u0004\u0011)#A\u0007%G>dwN\u001c\u0013cg2\f7\u000f[\u000b\u0005\u0005g\u0011I\u0004\u0006\u0003\u00036\t}B\u0003\u0002B\u001c\u0005w\u00012\u0001\u0017B\u001d\t\u0019\tid\u0006b\u00017\"9\u0011q`\fA\u0002\tu\u0002\u0003\u0003)\u0003\u0004]\u00139Da\u000e\t\u000f\t%q\u00031\u0001\u00038\u0005Q!/\u001a3vG\u0016dUM\u001a;\u0016\t\t\u0015#\u0011\n\u000b\u0005\u0005\u000f\u0012Y\u0005E\u0002Y\u0005\u0013\"q!!\u0010\u0019\u0005\u0004\ty\u0004C\u0004\u0002\u0000b\u0001\rA!\u0014\u0011\u0011A\u0013\u0019Aa\u0012X\u0005\u000f\n\u0001C]3ek\u000e,G*\u001a4u\u001fB$\u0018n\u001c8\u0016\t\tM#\u0011\f\u000b\u0005\u0005+\u0012Y\u0006E\u0003Q\u0003W\u00149\u0006E\u0002Y\u00053\"q!!\u0010\u001a\u0005\u0004\ty\u0004C\u0004\u0002\u0000f\u0001\rA!\u0018\u0011\u0011A\u0013\u0019Aa\u0016X\u0005/\n1B]3ek\u000e,'+[4iiV!!1\rB4)\u0011\u0011)G!\u001b\u0011\u0007a\u00139\u0007B\u0004\u0002>i\u0011\r!a\u0010\t\u000f\u0005}(\u00041\u0001\u0003lAA\u0001Ka\u0001X\u0005K\u0012)'A\tsK\u0012,8-\u001a*jO\"$x\n\u001d;j_:,BA!\u001d\u0003xQ!!1\u000fB=!\u0015\u0001\u00161\u001eB;!\rA&q\u000f\u0003\b\u0003{Y\"\u0019AA \u0011\u001d\typ\u0007a\u0001\u0005w\u0002\u0002\u0002\u0015B\u0002/\nU$QO\u0001\tg\u000e\fg\u000eT3giV1!\u0011\u0011BI\u0005\u0013#BAa!\u0003\u0018R!!Q\u0011BJ)\u0011\u00119Ia#\u0011\u0007a\u0013I\t\u0002\u0004\u0002(q\u0011\ra\u0017\u0005\b\u0003Wa\u00029\u0001BG!%\ty#!\u000ec\u0005\u001f\u00139\tE\u0002Y\u0005##a!!\u0010\u001d\u0005\u0004Y\u0006bBA\u00009\u0001\u0007!Q\u0013\t\t!\n\r!qR,\u0003\u0010\"9!\u0011\u0002\u000fA\u0002\t=\u0015!C:dC:\u0014\u0016n\u001a5u+\u0019\u0011iJ!,\u0003&R!!q\u0014BZ)\u0011\u0011\tKa,\u0015\t\t\r&q\u0015\t\u00041\n\u0015FABA\u0014;\t\u00071\fC\u0004\u0002,u\u0001\u001dA!+\u0011\u0013\u0005=\u0012Q\u00072\u0003,\n\r\u0006c\u0001-\u0003.\u00121\u0011QH\u000fC\u0002mCq!a@\u001e\u0001\u0004\u0011\t\f\u0005\u0005Q\u0005\u00079&1\u0016BV\u0011\u001d\u0011I!\ba\u0001\u0005W\u000b1a];n+\u0011\u0011IL!0\u0015\t\tm&q\u0018\t\u00041\nuFaBA\u001f=\t\u0007\u0011q\b\u0005\b\u0005\u0003t\u00029\u0001Bb\u0003\rqW/\u001c\t\u0007\u0005\u000b\u0014YMa/\u000f\u0007A\u00139-C\u0002\u0003J*\u000bq\u0001]1dW\u0006<W-\u0003\u0003\u0003N\n='a\u0002(v[\u0016\u0014\u0018n\u0019\u0006\u0004\u0005\u0013T\u0015a\u00029s_\u0012,8\r^\u000b\u0005\u0005+\u0014I\u000e\u0006\u0003\u0003X\nm\u0007c\u0001-\u0003Z\u00129\u0011QH\u0010C\u0002\u0005}\u0002b\u0002Ba?\u0001\u000f!Q\u001c\t\u0007\u0005\u000b\u0014YMa6\u0002\u00075Lg.\u0006\u0003\u0003d\nEHcA,\u0003f\"9!q\u001d\u0011A\u0004\t%\u0018aA2naB1!Q\u0019Bv\u0005_LAA!<\u0003P\nAqJ\u001d3fe&tw\rE\u0002Y\u0005c$q!!\u0010!\u0005\u0004\ty$A\u0002nCb,BAa>\u0003\u0000R\u0019qK!?\t\u000f\t\u001d\u0018\u0005q\u0001\u0003|B1!Q\u0019Bv\u0005{\u00042\u0001\u0017B\u0000\t\u001d\ti$\tb\u0001\u0003\u007f\tA\u0001[3bIV\tq+\u0001\u0006iK\u0006$w\n\u001d;j_:,\"!!;\u0002\tQ\f\u0017\u000e\\\u0001\u0005Y\u0006\u001cH/\u0001\u0006mCN$x\n\u001d;j_:\fA!\u001b8ji\u0006!A/Y6f)\r\u00117Q\u0003\u0005\b\u0007/A\u0003\u0019AA\n\u0003\u0005q\u0017\u0001\u00023s_B$2AYB\u000f\u0011\u001d\u00199\"\u000ba\u0001\u0003'\tQa\u001d7jG\u0016$RAYB\u0012\u0007OAqa!\n+\u0001\u0004\t\u0019\"\u0001\u0003ge>l\u0007bBB\u0015U\u0001\u0007\u00111C\u0001\u0006k:$\u0018\u000e\\\u0001\ni\u0006\\Wm\u00165jY\u0016$2AYB\u0018\u0011\u001d\t\u0019i\u000ba\u0001\u0003\u000b\u000b\u0011\u0002\u001a:pa^C\u0017\u000e\\3\u0015\u0007\t\u001c)\u0004C\u0004\u0002\u00042\u0002\r!!\"\u0002\tM\u0004\u0018M\u001c\u000b\u0005\u0003_\u001bY\u0004C\u0004\u0002\u00046\u0002\r!!\"\u0002\u000fM\u0004H.\u001b;BiR!\u0011qVB!\u0011\u001d\u00199B\fa\u0001\u0003'\tAbY8qsR{')\u001e4gKJ,Baa\u0012\u0004\\Q\u0019\u0011o!\u0013\t\u000f\r-s\u00061\u0001\u0004N\u0005!A-Z:u!\u0019\u0019ye!\u0016\u0004Z5\u00111\u0011\u000b\u0006\u0004\u0007'B\u0015aB7vi\u0006\u0014G.Z\u0005\u0005\u0007/\u001a\tF\u0001\u0004Ck\u001a4WM\u001d\t\u00041\u000emCaBA\u001f_\t\u0007\u0011qH\u0001\fG>\u0004\u0018\u0010V8BeJ\f\u00170\u0006\u0003\u0004b\r5DcB9\u0004d\r=41\u000f\u0005\b\u0003\u0007\u0002\u0004\u0019AB3!\u0015\u00016qMB6\u0013\r\u0019IG\u0013\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u00041\u000e5DaBA\u001fa\t\u0007\u0011q\b\u0005\b\u0007c\u0002\u0004\u0019AA\n\u0003\u0015\u0019H/\u0019:u\u0011\u001d\u0019)\b\ra\u0001\u0003'\t1\u0001\\3o+\u0011\u0019Ih!!\u0015\u000bE\u001cYha!\t\u000f\u0005\r\u0013\u00071\u0001\u0004~A)\u0001ka\u001a\u0004\u0000A\u0019\u0001l!!\u0005\u000f\u0005u\u0012G1\u0001\u0002@!91\u0011O\u0019A\u0002\u0005MQ\u0003BBD\u0007\u001f#2!]BE\u0011\u001d\t\u0019E\ra\u0001\u0007\u0017\u0003R\u0001UB4\u0007\u001b\u00032\u0001WBH\t\u001d\tiD\rb\u0001\u0003\u007f\tq\u0001^8BeJ\f\u00170\u0006\u0003\u0004\u0016\u000emE\u0003BBL\u0007;\u0003R\u0001UB4\u00073\u00032\u0001WBN\t\u001d\tid\rb\u0001\u0003\u007fA\u0011ba(4\u0003\u0003\u0005\u001da!)\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$\u0013\u0007\u0005\u0004\u0004$\u000e%6\u0011T\u0007\u0003\u0007KS1aa*K\u0003\u001d\u0011XM\u001a7fGRLAaa+\u0004&\nA1\t\\1tgR\u000bw-\u0001\u0004u_2K7\u000f^\u000b\u0003\u0007c\u0003RA!2\u00044^KAa!.\u0003P\n!A*[:u\u0003)!x.\u0013;fe\u0006\u0014G.Z\u000b\u0003\u0007w\u0003B\u0001VB_/&\u00191q\u0018%\u0003\u0011%#XM]1cY\u0016\fQ\u0001^8TKF,\"a!2\u0011\tQ\u001b9mV\u0005\u0004\u0007\u0013D%aA*fc\u0006aAo\\%oI\u0016DX\rZ*fcV\u00111q\u001a\t\u0006\u0003\u007f\u001b\tnV\u0005\u0005\u0007'\f\tM\u0001\u0006J]\u0012,\u00070\u001a3TKF\f\u0001\u0002^8Ck\u001a4WM]\u000b\u0005\u00073\u001cy.\u0006\u0002\u0004\\B11qJB+\u0007;\u00042\u0001WBp\t\u001d\ti\u0004\u000fb\u0001\u0003\u007f\t\u0001\u0002^8TiJ,\u0017-\\\u000b\u0003\u0007K\u0004RA!2\u0004h^KAa!;\u0003P\n11\u000b\u001e:fC6\fQ\u0001^8TKR,Baa<\u0004zV\u00111\u0011\u001f\t\u0007\u0003\u007f\u001b\u0019pa>\n\t\rU\u0018\u0011\u0019\u0002\u0004'\u0016$\bc\u0001-\u0004z\u00129\u0011Q\b\u001eC\u0002\u0005}\u0012!\u0002;p\u001b\u0006\u0004XCBB\u0000\t\u000b!Y\u0001\u0006\u0003\u0005\u0002\u00115\u0001\u0003CA`\u0003\u000b$\u0019\u0001\"\u0003\u0011\u0007a#)\u0001\u0002\u0004\u0005\bm\u0012\ra\u0017\u0002\u0002)B\u0019\u0001\fb\u0003\u0005\r\u0005\u00051H1\u0001\\\u0011\u001d!ya\u000fa\u0002\t#\t!!\u001a<\u0011\u000f\u0011MA\u0011E,\u0005(9!AQ\u0003C\u000f!\r!9BS\u0007\u0003\t3Q1\u0001b\u0007M\u0003\u0019a$o\\8u}%\u0019Aq\u0004&\u0002\rA\u0013X\rZ3g\u0013\u0011!\u0019\u0003\"\n\u0003!\u0011bWm]:%G>dwN\u001c\u0013mKN\u001c(b\u0001C\u0010\u0015B9\u0001+!-\u0005\u0004\u0011%\u0011!\u0004;p)J\fg/\u001a:tC\ndW-F\u0001j\u0003)!x.\u0013;fe\u0006$xN]\u000b\u0003\tc\u0001B\u0001\u0016C\u001a/&\u0019AQ\u0007%\u0003\u0011%#XM]1u_J\f\u0001\"\\6TiJLgn\u001a\u000b\t\tw!\t\u0005b\u0011\u0005HA!A1\u0003C\u001f\u0013\u0011!y\u0004\"\n\u0003\rM#(/\u001b8h\u0011\u001d\u0019\tH\u0010a\u0001\twAq\u0001\"\u0012?\u0001\u0004!Y$A\u0002tKBDq\u0001\"\u0013?\u0001\u0004!Y$A\u0002f]\u0012$B\u0001b\u000f\u0005N!9AQI A\u0002\u0011mRC\u0001C\u001e\u0003%\tG\rZ*ue&tw\r\u0006\u0006\u0005V\u0011mCq\fC1\tG\u0002Baa\u0014\u0005X%!A\u0011LB)\u00055\u0019FO]5oO\n+\u0018\u000e\u001c3fe\"9AQL!A\u0002\u0011U\u0013!\u00012\t\u000f\rE\u0014\t1\u0001\u0005<!9AQI!A\u0002\u0011m\u0002b\u0002C%\u0003\u0002\u0007A1\b\u000b\u0007\t+\"9\u0007\"\u001b\t\u000f\u0011u#\t1\u0001\u0005V!9AQ\t\"A\u0002\u0011mB\u0003\u0002C+\t[Bq\u0001\"\u0018D\u0001\u0004!)&\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070\u0001\u0003wS\u0016<XC\u0001C;%\u0015!9h\u0014C>\r\u0015A\u0007\u0001\u0001C;\u0013\r!\t(\u0016\t\u0006)\u0012utKY\u0005\u0004\t\u007fB%a\u0004+sCZ,'o]1cY\u00164\u0016.Z<\u0015\r\u0011mD1\u0011CC\u0011\u001d\u0019)C\u0012a\u0001\u0003'Aqa!\u000bG\u0001\u0004\t\u0019\u0002K\u0004\u0001\t\u0013#y\tb%\u0011\u0007A#Y)C\u0002\u0005\u000e*\u0013!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t!\t*\u0001#qe>D\u00180\u001b8hA%\u001c\b\u0005Z3qe\u0016\u001c\u0017\r^3eA\u0011,X\r\t;pA1\f7m\u001b\u0011pM\u0002*8/\u001a\u0011b]\u0012\u00043m\\7qS2,'/\f7fm\u0016d\u0007e];qa>\u0014H/\t\u0002\u0005\u0016\u00061!GL\u00192]A\u0002")
public interface TraversableProxyLike<A, Repr extends TraversableLike<A, Repr> & Traversable<A>>
extends TraversableLike<A, Repr>,
Proxy {
    public Repr self();

    public static /* synthetic */ void foreach$(TraversableProxyLike $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        this.self().foreach(f);
    }

    public static /* synthetic */ boolean isEmpty$(TraversableProxyLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return this.self().isEmpty();
    }

    public static /* synthetic */ boolean nonEmpty$(TraversableProxyLike $this) {
        return $this.nonEmpty();
    }

    @Override
    default public boolean nonEmpty() {
        return this.self().nonEmpty();
    }

    public static /* synthetic */ int size$(TraversableProxyLike $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        return this.self().size();
    }

    public static /* synthetic */ boolean hasDefiniteSize$(TraversableProxyLike $this) {
        return $this.hasDefiniteSize();
    }

    @Override
    default public boolean hasDefiniteSize() {
        return this.self().hasDefiniteSize();
    }

    public static /* synthetic */ Object $plus$plus$(TraversableProxyLike $this, GenTraversableOnce xs, CanBuildFrom bf) {
        return $this.$plus$plus(xs, bf);
    }

    @Override
    default public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<Repr, B, That> bf) {
        return this.self().$plus$plus(xs, bf);
    }

    public static /* synthetic */ Object map$(TraversableProxyLike $this, Function1 f, CanBuildFrom bf) {
        return $this.map(f, bf);
    }

    @Override
    default public <B, That> That map(Function1<A, B> f, CanBuildFrom<Repr, B, That> bf) {
        return this.self().map(f, bf);
    }

    public static /* synthetic */ Object flatMap$(TraversableProxyLike $this, Function1 f, CanBuildFrom bf) {
        return $this.flatMap(f, bf);
    }

    @Override
    default public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<Repr, B, That> bf) {
        return this.self().flatMap(f, bf);
    }

    public static /* synthetic */ Traversable filter$(TraversableProxyLike $this, Function1 p) {
        return $this.filter(p);
    }

    @Override
    default public Repr filter(Function1<A, Object> p) {
        return (Repr)((Traversable)this.self().filter(p));
    }

    public static /* synthetic */ Traversable filterNot$(TraversableProxyLike $this, Function1 p) {
        return $this.filterNot(p);
    }

    @Override
    default public Repr filterNot(Function1<A, Object> p) {
        return (Repr)((Traversable)this.self().filterNot(p));
    }

    public static /* synthetic */ Object collect$(TraversableProxyLike $this, PartialFunction pf, CanBuildFrom bf) {
        return $this.collect(pf, bf);
    }

    @Override
    default public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<Repr, B, That> bf) {
        return this.self().collect(pf, bf);
    }

    public static /* synthetic */ Tuple2 partition$(TraversableProxyLike $this, Function1 p) {
        return $this.partition(p);
    }

    @Override
    default public Tuple2<Repr, Repr> partition(Function1<A, Object> p) {
        return this.self().partition(p);
    }

    public static /* synthetic */ Map groupBy$(TraversableProxyLike $this, Function1 f) {
        return $this.groupBy(f);
    }

    @Override
    default public <K> Map<K, Repr> groupBy(Function1<A, K> f) {
        return this.self().groupBy(f);
    }

    public static /* synthetic */ boolean forall$(TraversableProxyLike $this, Function1 p) {
        return $this.forall(p);
    }

    @Override
    default public boolean forall(Function1<A, Object> p) {
        return this.self().forall(p);
    }

    public static /* synthetic */ boolean exists$(TraversableProxyLike $this, Function1 p) {
        return $this.exists(p);
    }

    @Override
    default public boolean exists(Function1<A, Object> p) {
        return this.self().exists(p);
    }

    public static /* synthetic */ int count$(TraversableProxyLike $this, Function1 p) {
        return $this.count(p);
    }

    @Override
    default public int count(Function1<A, Object> p) {
        return this.self().count(p);
    }

    public static /* synthetic */ Option find$(TraversableProxyLike $this, Function1 p) {
        return $this.find(p);
    }

    @Override
    default public Option<A> find(Function1<A, Object> p) {
        return this.self().find(p);
    }

    public static /* synthetic */ Object foldLeft$(TraversableProxyLike $this, Object z, Function2 op) {
        return $this.foldLeft(z, op);
    }

    @Override
    default public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return this.self().foldLeft(z, op);
    }

    public static /* synthetic */ Object $div$colon$(TraversableProxyLike $this, Object z, Function2 op) {
        return $this.$div$colon(z, op);
    }

    @Override
    default public <B> B $div$colon(B z, Function2<B, A, B> op) {
        return this.self().$div$colon(z, op);
    }

    public static /* synthetic */ Object foldRight$(TraversableProxyLike $this, Object z, Function2 op) {
        return $this.foldRight(z, op);
    }

    @Override
    default public <B> B foldRight(B z, Function2<A, B, B> op) {
        return this.self().foldRight(z, op);
    }

    public static /* synthetic */ Object $colon$bslash$(TraversableProxyLike $this, Object z, Function2 op) {
        return $this.$colon$bslash(z, op);
    }

    @Override
    default public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
        return this.self().$colon$bslash(z, op);
    }

    public static /* synthetic */ Object reduceLeft$(TraversableProxyLike $this, Function2 op) {
        return $this.reduceLeft(op);
    }

    @Override
    default public <B> B reduceLeft(Function2<B, A, B> op) {
        return this.self().reduceLeft(op);
    }

    public static /* synthetic */ Option reduceLeftOption$(TraversableProxyLike $this, Function2 op) {
        return $this.reduceLeftOption(op);
    }

    @Override
    default public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
        return this.self().reduceLeftOption(op);
    }

    public static /* synthetic */ Object reduceRight$(TraversableProxyLike $this, Function2 op) {
        return $this.reduceRight(op);
    }

    @Override
    default public <B> B reduceRight(Function2<A, B, B> op) {
        return this.self().reduceRight(op);
    }

    public static /* synthetic */ Option reduceRightOption$(TraversableProxyLike $this, Function2 op) {
        return $this.reduceRightOption(op);
    }

    @Override
    default public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
        return this.self().reduceRightOption(op);
    }

    public static /* synthetic */ Object scanLeft$(TraversableProxyLike $this, Object z, Function2 op, CanBuildFrom bf) {
        return $this.scanLeft(z, op, bf);
    }

    @Override
    default public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<Repr, B, That> bf) {
        return this.self().scanLeft(z, op, bf);
    }

    public static /* synthetic */ Object scanRight$(TraversableProxyLike $this, Object z, Function2 op, CanBuildFrom bf) {
        return $this.scanRight(z, op, bf);
    }

    @Override
    default public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<Repr, B, That> bf) {
        return this.self().scanRight(z, op, bf);
    }

    public static /* synthetic */ Object sum$(TraversableProxyLike $this, Numeric num) {
        return $this.sum(num);
    }

    @Override
    default public <B> B sum(Numeric<B> num) {
        return this.self().sum(num);
    }

    public static /* synthetic */ Object product$(TraversableProxyLike $this, Numeric num) {
        return $this.product(num);
    }

    @Override
    default public <B> B product(Numeric<B> num) {
        return this.self().product(num);
    }

    public static /* synthetic */ Object min$(TraversableProxyLike $this, Ordering cmp) {
        return $this.min(cmp);
    }

    @Override
    default public <B> A min(Ordering<B> cmp) {
        return this.self().min(cmp);
    }

    public static /* synthetic */ Object max$(TraversableProxyLike $this, Ordering cmp) {
        return $this.max(cmp);
    }

    @Override
    default public <B> A max(Ordering<B> cmp) {
        return this.self().max(cmp);
    }

    public static /* synthetic */ Object head$(TraversableProxyLike $this) {
        return $this.head();
    }

    @Override
    default public A head() {
        return this.self().head();
    }

    public static /* synthetic */ Option headOption$(TraversableProxyLike $this) {
        return $this.headOption();
    }

    @Override
    default public Option<A> headOption() {
        return this.self().headOption();
    }

    public static /* synthetic */ Traversable tail$(TraversableProxyLike $this) {
        return $this.tail();
    }

    @Override
    default public Repr tail() {
        return (Repr)((Traversable)this.self().tail());
    }

    public static /* synthetic */ Object last$(TraversableProxyLike $this) {
        return $this.last();
    }

    @Override
    default public A last() {
        return this.self().last();
    }

    public static /* synthetic */ Option lastOption$(TraversableProxyLike $this) {
        return $this.lastOption();
    }

    @Override
    default public Option<A> lastOption() {
        return this.self().lastOption();
    }

    public static /* synthetic */ Traversable init$(TraversableProxyLike $this) {
        return $this.init();
    }

    @Override
    default public Repr init() {
        return (Repr)((Traversable)this.self().init());
    }

    public static /* synthetic */ Traversable take$(TraversableProxyLike $this, int n) {
        return $this.take(n);
    }

    @Override
    default public Repr take(int n) {
        return (Repr)((Traversable)this.self().take(n));
    }

    public static /* synthetic */ Traversable drop$(TraversableProxyLike $this, int n) {
        return $this.drop(n);
    }

    @Override
    default public Repr drop(int n) {
        return (Repr)((Traversable)this.self().drop(n));
    }

    public static /* synthetic */ Traversable slice$(TraversableProxyLike $this, int from, int until) {
        return $this.slice(from, until);
    }

    @Override
    default public Repr slice(int from, int until) {
        return (Repr)((Traversable)this.self().slice(from, until));
    }

    public static /* synthetic */ Traversable takeWhile$(TraversableProxyLike $this, Function1 p) {
        return $this.takeWhile(p);
    }

    @Override
    default public Repr takeWhile(Function1<A, Object> p) {
        return (Repr)((Traversable)this.self().takeWhile(p));
    }

    public static /* synthetic */ Traversable dropWhile$(TraversableProxyLike $this, Function1 p) {
        return $this.dropWhile(p);
    }

    @Override
    default public Repr dropWhile(Function1<A, Object> p) {
        return (Repr)((Traversable)this.self().dropWhile(p));
    }

    public static /* synthetic */ Tuple2 span$(TraversableProxyLike $this, Function1 p) {
        return $this.span(p);
    }

    @Override
    default public Tuple2<Repr, Repr> span(Function1<A, Object> p) {
        return this.self().span(p);
    }

    public static /* synthetic */ Tuple2 splitAt$(TraversableProxyLike $this, int n) {
        return $this.splitAt(n);
    }

    @Override
    default public Tuple2<Repr, Repr> splitAt(int n) {
        return this.self().splitAt(n);
    }

    public static /* synthetic */ void copyToBuffer$(TraversableProxyLike $this, Buffer dest) {
        $this.copyToBuffer(dest);
    }

    @Override
    default public <B> void copyToBuffer(Buffer<B> dest) {
        this.self().copyToBuffer(dest);
    }

    public static /* synthetic */ void copyToArray$(TraversableProxyLike $this, Object xs, int start, int len) {
        $this.copyToArray(xs, start, len);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start, int len) {
        this.self().copyToArray(xs, start, len);
    }

    public static /* synthetic */ void copyToArray$(TraversableProxyLike $this, Object xs, int start) {
        $this.copyToArray(xs, start);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start) {
        this.self().copyToArray(xs, start);
    }

    public static /* synthetic */ void copyToArray$(TraversableProxyLike $this, Object xs) {
        $this.copyToArray(xs);
    }

    @Override
    default public <B> void copyToArray(Object xs) {
        this.self().copyToArray(xs);
    }

    public static /* synthetic */ Object toArray$(TraversableProxyLike $this, ClassTag evidence$1) {
        return $this.toArray(evidence$1);
    }

    @Override
    default public <B> Object toArray(ClassTag<B> evidence$1) {
        return this.self().toArray(evidence$1);
    }

    public static /* synthetic */ List toList$(TraversableProxyLike $this) {
        return $this.toList();
    }

    @Override
    default public List<A> toList() {
        return this.self().toList();
    }

    public static /* synthetic */ Iterable toIterable$(TraversableProxyLike $this) {
        return $this.toIterable();
    }

    @Override
    default public Iterable<A> toIterable() {
        return this.self().toIterable();
    }

    public static /* synthetic */ Seq toSeq$(TraversableProxyLike $this) {
        return $this.toSeq();
    }

    @Override
    default public Seq<A> toSeq() {
        return this.self().toSeq();
    }

    public static /* synthetic */ IndexedSeq toIndexedSeq$(TraversableProxyLike $this) {
        return $this.toIndexedSeq();
    }

    @Override
    default public IndexedSeq<A> toIndexedSeq() {
        return this.self().toIndexedSeq();
    }

    public static /* synthetic */ Buffer toBuffer$(TraversableProxyLike $this) {
        return $this.toBuffer();
    }

    @Override
    default public <B> Buffer<B> toBuffer() {
        return this.self().toBuffer();
    }

    public static /* synthetic */ Stream toStream$(TraversableProxyLike $this) {
        return $this.toStream();
    }

    @Override
    default public Stream<A> toStream() {
        return this.self().toStream();
    }

    public static /* synthetic */ Set toSet$(TraversableProxyLike $this) {
        return $this.toSet();
    }

    @Override
    default public <B> Set<B> toSet() {
        return this.self().toSet();
    }

    public static /* synthetic */ Map toMap$(TraversableProxyLike $this, Predef$.less.colon.less ev) {
        return $this.toMap(ev);
    }

    @Override
    default public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
        return this.self().toMap(ev);
    }

    public static /* synthetic */ Traversable toTraversable$(TraversableProxyLike $this) {
        return $this.toTraversable();
    }

    @Override
    default public Traversable<A> toTraversable() {
        return this.self().toTraversable();
    }

    public static /* synthetic */ Iterator toIterator$(TraversableProxyLike $this) {
        return $this.toIterator();
    }

    @Override
    default public Iterator<A> toIterator() {
        return this.self().toIterator();
    }

    public static /* synthetic */ String mkString$(TraversableProxyLike $this, String start, String sep, String end) {
        return $this.mkString(start, sep, end);
    }

    @Override
    default public String mkString(String start, String sep, String end) {
        return this.self().mkString(start, sep, end);
    }

    public static /* synthetic */ String mkString$(TraversableProxyLike $this, String sep) {
        return $this.mkString(sep);
    }

    @Override
    default public String mkString(String sep) {
        return this.self().mkString(sep);
    }

    public static /* synthetic */ String mkString$(TraversableProxyLike $this) {
        return $this.mkString();
    }

    @Override
    default public String mkString() {
        return this.self().mkString();
    }

    public static /* synthetic */ StringBuilder addString$(TraversableProxyLike $this, StringBuilder b, String start, String sep, String end) {
        return $this.addString(b, start, sep, end);
    }

    @Override
    default public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return this.self().addString(b, start, sep, end);
    }

    public static /* synthetic */ StringBuilder addString$(TraversableProxyLike $this, StringBuilder b, String sep) {
        return $this.addString(b, sep);
    }

    @Override
    default public StringBuilder addString(StringBuilder b, String sep) {
        return this.self().addString(b, sep);
    }

    public static /* synthetic */ StringBuilder addString$(TraversableProxyLike $this, StringBuilder b) {
        return $this.addString(b);
    }

    @Override
    default public StringBuilder addString(StringBuilder b) {
        return this.self().addString(b);
    }

    public static /* synthetic */ String stringPrefix$(TraversableProxyLike $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return this.self().stringPrefix();
    }

    public static /* synthetic */ TraversableView view$(TraversableProxyLike $this) {
        return $this.view();
    }

    @Override
    default public TraversableView<A, Repr> view() {
        return this.self().view();
    }

    public static /* synthetic */ TraversableView view$(TraversableProxyLike $this, int from, int until) {
        return $this.view(from, until);
    }

    @Override
    default public TraversableView<A, Repr> view(int from, int until) {
        return this.self().view(from, until);
    }

    public static void $init$(TraversableProxyLike $this) {
    }
}

