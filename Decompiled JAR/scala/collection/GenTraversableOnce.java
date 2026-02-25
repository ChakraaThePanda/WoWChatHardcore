/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Predef$;
import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenMap;
import scala.collection.GenSeq;
import scala.collection.GenSet;
import scala.collection.GenTraversable;
import scala.collection.Iterator;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0011eaa\u0002\u001a4!\u0003\r\t\u0001\u000f\u0005\u0006}\u0001!\ta\u0010\u0005\u0006\u0007\u00021\t\u0001\u0012\u0005\u0006-\u00021\ta\u0016\u0005\u00067\u00021\t\u0001\u0018\u0005\u0006C\u00021\tA\u0019\u0005\u0007M\u0002!\tb\r2\t\u000b\u001d\u0004a\u0011A,\t\u000b!\u0004a\u0011A,\t\u000b%\u0004a\u0011A,\t\u000b)\u0004a\u0011A6\t\u000bY\u0004a\u0011A<\t\u000f\u0005\u0005\u0001A\"\u0001\u0002\u0004!9\u0011Q\u0003\u0001\u0007\u0002\u0005]\u0001bBA\u001d\u0001\u0019\u0005\u00111\b\u0005\b\u0003#\u0002a\u0011AA*\u0011\u001d\t\u0019\u0007\u0001D\u0001\u0003KBq!!\u001e\u0001\r\u0003\t9\bC\u0004\u0002\u0016\u00021\t!a&\t\u000f\u0005\r\u0006A\"\u0001\u0002&\"9\u00111\u0017\u0001\u0007\u0002\u0005U\u0006bBAb\u0001\u0019\u0005\u0011Q\u0019\u0005\b\u0003\u001b\u0004a\u0011AAh\u0011\u001d\tI\u000f\u0001D\u0001\u0003WDq!a>\u0001\r\u0003\tI\u0010C\u0004\u0003\f\u00011\tA!\u0004\t\u000f\te\u0001A\"\u0001\u0003\u001c!9!q\u0006\u0001\u0007\u0002\tE\u0002b\u0002B\"\u0001\u0019\u0005!Q\t\u0005\b\u0005O\u0003a\u0011\u0001BU\u0011\u001d\u0011y\f\u0001D\u0001\u0005\u0003DqA!7\u0001\r\u0003\u0011Y\u000eC\u0004\u0003Z\u00021\tA!<\t\u000f\te\u0007A\"\u0001\u0003~\"91q\u0002\u0001\u0007\u0002\rE\u0001bBB\b\u0001\u0019\u00051Q\u0004\u0005\b\u0007\u001f\u0001a\u0011AB\u0011\u0011\u001d\u0019\u0019\u0003\u0001D\u0001\u0007KAqaa\u0010\u0001\r\u0003\u0019\t\u0005C\u0004\u0004J\u00011\taa\u0013\t\u000f\re\u0003A\"\u0001\u0004\\!911\r\u0001\u0007\u0002\r\u0015\u0004bBB7\u0001\u0019\u00051q\u000e\u0005\b\u0007\u0007\u0003a\u0011ABC\u0011\u001d\u0019i\t\u0001D\u0001\u0007\u001fCqaa&\u0001\r\u0003\u0019I\nC\u0004\u0004\"\u00021\taa)\t\u000f\rE\u0006A\"\u0001\u00044\"91\u0011\u001c\u0001\u0007\u0002\rm\u0007bBBr\u0001\u0019\u00051Q\u001d\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cWM\u0003\u00025k\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003Y\nQa]2bY\u0006\u001c\u0001!\u0006\u0002:\u001bN\u0011\u0001A\u000f\t\u0003wqj\u0011!N\u0005\u0003{U\u00121!\u00118z\u0003\u0019!\u0013N\\5uIQ\t\u0001\t\u0005\u0002<\u0003&\u0011!)\u000e\u0002\u0005+:LG/A\u0004g_J,\u0017m\u00195\u0016\u0005\u0015#FC\u0001!G\u0011\u00159%\u00011\u0001I\u0003\u00051\u0007\u0003B\u001eJ\u0017NK!AS\u001b\u0003\u0013\u0019+hn\u0019;j_:\f\u0004C\u0001'N\u0019\u0001!aA\u0014\u0001\u0005\u0006\u0004y%!A!\u0012\u0005AS\u0004CA\u001eR\u0013\t\u0011VGA\u0004O_RD\u0017N\\4\u0011\u00051#F!B+\u0003\u0005\u0004y%!A+\u0002\u001f!\f7\u000fR3gS:LG/Z*ju\u0016,\u0012\u0001\u0017\t\u0003weK!AW\u001b\u0003\u000f\t{w\u000e\\3b]\u0006\u00191/Z9\u0016\u0003u\u00032AX0L\u001b\u0005\u0019\u0014B\u000114\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0017\u0001B:ju\u0016,\u0012a\u0019\t\u0003w\u0011L!!Z\u001b\u0003\u0007%sG/A\btSj,\u0007*\u001b8u\u0013\u001a\u001c\u0005.Z1q\u0003\u001dI7/R7qif\f\u0001B\\8o\u000b6\u0004H/_\u0001\u0013SN$&/\u0019<feN\f'\r\\3BO\u0006Lg.\u0001\u0004sK\u0012,8-Z\u000b\u0003Y:$\"!\\9\u0011\u00051sG!B8\u000b\u0005\u0004\u0001(AA!2#\tY%\bC\u0003s\u0015\u0001\u00071/\u0001\u0002paB)1\b^7n[&\u0011Q/\u000e\u0002\n\rVt7\r^5p]J\nAB]3ek\u000e,w\n\u001d;j_:,\"\u0001_?\u0015\u0005et\bcA\u001e{y&\u001110\u000e\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u00051kH!B8\f\u0005\u0004\u0001\b\"\u0002:\f\u0001\u0004y\b#B\u001euyrd\u0018\u0001\u00024pY\u0012,B!!\u0002\u0002\fQ!\u0011qAA\t)\u0011\tI!!\u0004\u0011\u00071\u000bY\u0001B\u0003p\u0019\t\u0007\u0001\u000f\u0003\u0004s\u0019\u0001\u0007\u0011q\u0002\t\twQ\fI!!\u0003\u0002\n!9\u00111\u0003\u0007A\u0002\u0005%\u0011!\u0001>\u0002\u0015\u0011\"\u0017N\u001e\u0013d_2|g.\u0006\u0003\u0002\u001a\u0005}A\u0003BA\u000e\u0003O!B!!\b\u0002$A\u0019A*a\b\u0005\r\u0005\u0005RB1\u0001P\u0005\u0005\u0011\u0005B\u0002:\u000e\u0001\u0004\t)\u0003E\u0004<i\u0006u1*!\b\t\u000f\u0005MQ\u00021\u0001\u0002\u001e!:Q\"a\u000b\u00022\u0005U\u0002cA\u001e\u0002.%\u0019\u0011qF\u001b\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u00024\u0005QRk]3!M>dG\rT3gi\u0002Jgn\u001d;fC\u0012\u0004sN\u001a\u00110u\u0005\u0012\u0011qG\u0001\be9\n$GL\u00191\u00035!3m\u001c7p]\u0012\u00127\u000f\\1tQV!\u0011QHA\")\u0011\ty$!\u0013\u0015\t\u0005\u0005\u0013Q\t\t\u0004\u0019\u0006\rCABA\u0011\u001d\t\u0007q\n\u0003\u0004s\u001d\u0001\u0007\u0011q\t\t\bwQ\\\u0015\u0011IA!\u0011\u001d\t\u0019B\u0004a\u0001\u0003\u0003BsADA\u0016\u0003\u001b\n)$\t\u0002\u0002P\u0005YRk]3!M>dGMU5hQR\u0004\u0013N\\:uK\u0006$\u0007e\u001c4!uq\u000b\u0001BZ8mI2+g\r^\u000b\u0005\u0003+\nY\u0006\u0006\u0003\u0002X\u0005\u0005D\u0003BA-\u0003;\u00022\u0001TA.\t\u0019\t\tc\u0004b\u0001\u001f\"1!o\u0004a\u0001\u0003?\u0002ra\u000f;\u0002Z-\u000bI\u0006C\u0004\u0002\u0014=\u0001\r!!\u0017\u0002\u0013\u0019|G\u000e\u001a*jO\"$X\u0003BA4\u0003[\"B!!\u001b\u0002tQ!\u00111NA8!\ra\u0015Q\u000e\u0003\u0007\u0003C\u0001\"\u0019A(\t\rI\u0004\u0002\u0019AA9!\u001dYDoSA6\u0003WBq!a\u0005\u0011\u0001\u0004\tY'A\u0005bO\u001e\u0014XmZ1uKV!\u0011\u0011PA@)\u0011\tY(!$\u0015\r\u0005u\u0014\u0011QAD!\ra\u0015q\u0010\u0003\u0007\u0003C\t\"\u0019A(\t\u000f\u0005\r\u0015\u00031\u0001\u0002\u0006\u0006)1/Z9paB91\b^A?\u0017\u0006u\u0004bBAE#\u0001\u0007\u00111R\u0001\u0007G>l'm\u001c9\u0011\u0011m\"\u0018QPA?\u0003{B\u0001\"a\u0005\u0012\t\u0003\u0007\u0011q\u0012\t\u0006w\u0005E\u0015QP\u0005\u0004\u0003'+$\u0001\u0003\u001fcs:\fW.\u001a \u0002\u0017I,G-^2f%&<\u0007\u000e^\u000b\u0005\u00033\u000bi\n\u0006\u0003\u0002\u001c\u0006}\u0005c\u0001'\u0002\u001e\u00121\u0011\u0011\u0005\nC\u0002ADaA\u001d\nA\u0002\u0005\u0005\u0006cB\u001eu\u0017\u0006m\u00151T\u0001\u0011e\u0016$WoY3MK\u001a$x\n\u001d;j_:,B!a*\u0002.R!\u0011\u0011VAX!\u0011Y$0a+\u0011\u00071\u000bi\u000b\u0002\u0004\u0002\"M\u0011\r\u0001\u001d\u0005\u0007eN\u0001\r!!-\u0011\u000fm\"\u00181V&\u0002,\u0006\t\"/\u001a3vG\u0016\u0014\u0016n\u001a5u\u001fB$\u0018n\u001c8\u0016\t\u0005]\u0016Q\u0018\u000b\u0005\u0003s\u000by\f\u0005\u0003<u\u0006m\u0006c\u0001'\u0002>\u00121\u0011\u0011\u0005\u000bC\u0002ADaA\u001d\u000bA\u0002\u0005\u0005\u0007cB\u001eu\u0017\u0006m\u00161X\u0001\u0006G>,h\u000e\u001e\u000b\u0004G\u0006\u001d\u0007bBAe+\u0001\u0007\u00111Z\u0001\u0002aB!1(S&Y\u0003\r\u0019X/\\\u000b\u0005\u0003#\f)\u000e\u0006\u0003\u0002T\u0006]\u0007c\u0001'\u0002V\u0012)qN\u0006b\u0001a\"9\u0011\u0011\u001c\fA\u0004\u0005m\u0017a\u00018v[B1\u0011Q\\Ar\u0003't1aOAp\u0013\r\t\t/N\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\t)/a:\u0003\u000f9+X.\u001a:jG*\u0019\u0011\u0011]\u001b\u0002\u000fA\u0014x\u000eZ;diV!\u0011Q^Ay)\u0011\ty/a=\u0011\u00071\u000b\t\u0010B\u0003p/\t\u0007\u0001\u000fC\u0004\u0002Z^\u0001\u001d!!>\u0011\r\u0005u\u00171]Ax\u0003\ri\u0017N\\\u000b\u0005\u0003w\u0014I\u0001F\u0002L\u0003{Dq!a@\u0019\u0001\b\u0011\t!A\u0002pe\u0012\u0004b!!8\u0003\u0004\t\u001d\u0011\u0002\u0002B\u0003\u0003O\u0014\u0001b\u0014:eKJLgn\u001a\t\u0004\u0019\n%A!B8\u0019\u0005\u0004\u0001\u0018aA7bqV!!q\u0002B\f)\rY%\u0011\u0003\u0005\b\u0003\u007fL\u00029\u0001B\n!\u0019\tiNa\u0001\u0003\u0016A\u0019AJa\u0006\u0005\u000b=L\"\u0019\u00019\u0002\u000b5\f\u0007PQ=\u0016\t\tu!\u0011\u0006\u000b\u0005\u0005?\u0011Y\u0003F\u0002L\u0005CAqAa\t\u001b\u0001\b\u0011)#A\u0002d[B\u0004b!!8\u0003\u0004\t\u001d\u0002c\u0001'\u0003*\u00111\u0011\u0011\u0005\u000eC\u0002=Caa\u0012\u000eA\u0002\t5\u0002#B\u001eJ\u0017\n\u001d\u0012!B7j]\nKX\u0003\u0002B\u001a\u0005{!BA!\u000e\u0003@Q\u00191Ja\u000e\t\u000f\t\r2\u0004q\u0001\u0003:A1\u0011Q\u001cB\u0002\u0005w\u00012\u0001\u0014B\u001f\t\u0019\t\tc\u0007b\u0001\u001f\"1qi\u0007a\u0001\u0005\u0003\u0002RaO%L\u0005w\taAZ8sC2dGc\u0001-\u0003H!9\u0011\u0011\u001a\u000fA\u0002\u0005-\u0007\u0006\u0003B$\u0005\u0017\u0012\tFa%\u0011\u0007m\u0012i%C\u0002\u0003PU\u0012a\u0002Z3qe\u0016\u001c\u0017\r^3e\u001d\u0006lW-M\u0004 \u0005'\u0012IFa#\u0011\u0007m\u0012)&C\u0002\u0003XU\u0012aaU=nE>d\u0017'C\u0012\u0003\\\t\u0005$q\u0010B2)\u0011\u0011\u0019F!\u0018\t\u000f\t}s\u00071\u0001\u0003j\u0005!a.Y7f\u0013\u0011\u0011\u0019G!\u001a\u0002\u000b\u0005\u0004\b\u000f\\=\u000b\u0007\t\u001dT'\u0001\u0004Ts6\u0014w\u000e\u001c\t\u0005\u0005W\u0012IH\u0004\u0003\u0003n\tU\u0004c\u0001B8k5\u0011!\u0011\u000f\u0006\u0004\u0005g:\u0014A\u0002\u001fs_>$h(C\u0002\u0003xU\na\u0001\u0015:fI\u00164\u0017\u0002\u0002B>\u0005{\u0012aa\u0015;sS:<'b\u0001B<kEJ1E!!\u0003\b\n%%q\r\b\u0005\u0005\u0007\u00139I\u0004\u0003\u0003p\t\u0015\u0015\"\u0001\u001c\n\u0007\t\u001dT'\r\u0004%\u0005\u0007\u0013)IN\u0019\u0006K\t5%qR\b\u0003\u0005\u001f\u000b#A!%\u0002\tA\u0014X\rZ\u0019\nG\t%$Q\u0013BO\u0005/KAAa&\u0003\u001a\u0006YB\u0005\\3tg&t\u0017\u000e\u001e\u0013he\u0016\fG/\u001a:%I\u00164\u0017-\u001e7uIIR1Aa'6\u00039!W\r\u001d:fG\u0006$X\r\u001a(b[\u0016\f\u0014b\tBP\u0005C\u0013\u0019Ka'\u000f\u0007m\u0012\t+C\u0002\u0003\u001cV\nTAI\u001e6\u0005K\u0013Qa]2bY\u0006\fa!\u001a=jgR\u001cHc\u0001-\u0003,\"9\u0011\u0011Z\u000fA\u0002\u0005-\u0007\u0006\u0003BV\u0005\u0017\u0012yK!/2\u000f}\u0011\u0019F!-\u00038FJ1Ea\u0017\u0003b\tM&1M\u0019\nG\t\u0005%q\u0011B[\u0005O\nd\u0001\nBB\u0005\u000b3\u0014'B\u0013\u0003\u000e\n=\u0015'C\u0012\u0003j\tU%1\u0018BLc%\u0019#q\u0014BQ\u0005{\u0013Y*M\u0003#wU\u0012)+\u0001\u0003gS:$G\u0003\u0002Bb\u0005\u000b\u00042a\u000f>L\u0011\u001d\tIM\ba\u0001\u0003\u0017D\u0003B!2\u0003L\t%'1[\u0019\b?\tM#1\u001aBic%\u0019#1\fB1\u0005\u001b\u0014\u0019'M\u0005$\u0005\u0003\u00139Ia4\u0003hE2AEa!\u0003\u0006Z\nT!\nBG\u0005\u001f\u000b\u0014b\tB5\u0005+\u0013)Na&2\u0013\r\u0012yJ!)\u0003X\nm\u0015'\u0002\u0012<k\t\u0015\u0016aC2paf$v.\u0011:sCf,BA!8\u0003lR\u0019\u0001Ia8\t\u000f\t\u0005x\u00041\u0001\u0003d\u0006\u0011\u0001p\u001d\t\u0006w\t\u0015(\u0011^\u0005\u0004\u0005O,$!B!se\u0006L\bc\u0001'\u0003l\u00121\u0011\u0011E\u0010C\u0002A,BAa<\u0003xR)\u0001I!=\u0003z\"9!\u0011\u001d\u0011A\u0002\tM\b#B\u001e\u0003f\nU\bc\u0001'\u0003x\u00121\u0011\u0011\u0005\u0011C\u0002ADaAa?!\u0001\u0004\u0019\u0017!B:uCJ$X\u0003\u0002B\u0000\u0007\u000f!r\u0001QB\u0001\u0007\u0013\u0019Y\u0001C\u0004\u0003b\u0006\u0002\raa\u0001\u0011\u000bm\u0012)o!\u0002\u0011\u00071\u001b9\u0001\u0002\u0004\u0002\"\u0005\u0012\r\u0001\u001d\u0005\u0007\u0005w\f\u0003\u0019A2\t\r\r5\u0011\u00051\u0001d\u0003\raWM\\\u0001\t[.\u001cFO]5oORA!\u0011NB\n\u0007+\u0019I\u0002C\u0004\u0003|\n\u0002\rA!\u001b\t\u000f\r]!\u00051\u0001\u0003j\u0005\u00191/\u001a9\t\u000f\rm!\u00051\u0001\u0003j\u0005\u0019QM\u001c3\u0015\t\t%4q\u0004\u0005\b\u0007/\u0019\u0003\u0019\u0001B5+\t\u0011I'A\u0004u_\u0006\u0013(/Y=\u0016\t\r\u001d2Q\u0006\u000b\u0005\u0007S\u0019y\u0003E\u0003<\u0005K\u001cY\u0003E\u0002M\u0007[!Qa\\\u0013C\u0002AD\u0011b!\r&\u0003\u0003\u0005\u001daa\r\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$\u0013\u0007\u0005\u0004\u00046\rm21F\u0007\u0003\u0007oQ1a!\u000f6\u0003\u001d\u0011XM\u001a7fGRLAa!\u0010\u00048\tA1\t\\1tgR\u000bw-\u0001\u0004u_2K7\u000f^\u000b\u0003\u0007\u0007\u0002R!!8\u0004F-KAaa\u0012\u0002h\n!A*[:u\u00031!x.\u00138eKb,GmU3r+\t\u0019i\u0005E\u0003\u0004P\rU3*\u0004\u0002\u0004R)\u001911K\u001a\u0002\u0013%lW.\u001e;bE2,\u0017\u0002BB,\u0007#\u0012!\"\u00138eKb,GmU3r\u0003!!xn\u0015;sK\u0006lWCAB/!\u0015\tina\u0018L\u0013\u0011\u0019\t'a:\u0003\rM#(/Z1n\u0003)!x.\u0013;fe\u0006$xN]\u000b\u0003\u0007O\u0002BAXB5\u0017&\u001911N\u001a\u0003\u0011%#XM]1u_J\f\u0001\u0002^8Ck\u001a4WM]\u000b\u0005\u0007c\u001a\t)\u0006\u0002\u0004tA11QOB>\u0007\u007fj!aa\u001e\u000b\u0007\re4'A\u0004nkR\f'\r\\3\n\t\ru4q\u000f\u0002\u0007\u0005V4g-\u001a:\u0011\u00071\u001b\t\tB\u0003pU\t\u0007\u0001/A\u0007u_R\u0013\u0018M^3sg\u0006\u0014G.Z\u000b\u0003\u0007\u000f\u0003BAXBE\u0017&\u001911R\u001a\u0003\u001d\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK\u0006QAo\\%uKJ\f'\r\\3\u0016\u0005\rE\u0005\u0003\u00020\u0004\u0014.K1a!&4\u0005-9UM\\%uKJ\f'\r\\3\u0002\u000bQ|7+Z9\u0016\u0005\rm\u0005\u0003\u00020\u0004\u001e.K1aa(4\u0005\u00199UM\\*fc\u0006)Ao\\*fiV!1QUBX+\t\u00199\u000bE\u0003_\u0007S\u001bi+C\u0002\u0004,N\u0012aaR3o'\u0016$\bc\u0001'\u00040\u0012)qN\fb\u0001a\u0006)Ao\\'baV11QWB`\u0007\u000b$Baa.\u0004JB9al!/\u0004>\u000e\r\u0017bAB^g\t1q)\u001a8NCB\u00042\u0001TB`\t\u0019\u0019\tm\fb\u0001\u001f\n\t1\nE\u0002M\u0007\u000b$aaa20\u0005\u0004y%!\u0001,\t\u000f\r-w\u0006q\u0001\u0004N\u0006\u0011QM\u001e\t\b\u0005W\u001aymSBj\u0013\u0011\u0019\tN! \u0003!\u0011bWm]:%G>dwN\u001c\u0013mKN\u001c\bcB\u001e\u0004V\u000eu61Y\u0005\u0004\u0007/,$A\u0002+va2,''\u0001\u0005u_Z+7\r^8s+\t\u0019i\u000eE\u0003\u0002^\u000e}7*\u0003\u0003\u0004b\u0006\u001d(A\u0002,fGR|'/\u0001\u0002u_V!1q]Bv)\u0011\u0019I\u000f\"\u0003\u0011\u000b1\u001bYo!>\u0005\u000f\r5\u0018G1\u0001\u0004p\n\u00191i\u001c7\u0016\u0007=\u001b\t\u0010B\u0004\u0004t\u000e-(\u0019A(\u0003\u0003}S3aSB|W\t\u0019I\u0010\u0005\u0003\u0004|\u0012\u0015QBAB\u007f\u0015\u0011\u0019y\u0010\"\u0001\u0002\u0013Ut7\r[3dW\u0016$'b\u0001C\u0002k\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\t\u0011\u001d1Q \u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0007b\u0002C\u0006c\u0001\u000fAQB\u0001\u0004G\n4\u0007\u0003\u0003C\b\t+\u00016j!;\u000e\u0005\u0011E!b\u0001C\ng\u00059q-\u001a8fe&\u001c\u0017\u0002\u0002C\f\t#\u0011AbQ1o\u0005VLG\u000e\u001a$s_6\u0004")
public interface GenTraversableOnce<A> {
    public <U> void foreach(Function1<A, U> var1);

    public boolean hasDefiniteSize();

    public TraversableOnce<A> seq();

    public int size();

    public static /* synthetic */ int sizeHintIfCheap$(GenTraversableOnce $this) {
        return $this.sizeHintIfCheap();
    }

    default public int sizeHintIfCheap() {
        return -1;
    }

    public boolean isEmpty();

    public boolean nonEmpty();

    public boolean isTraversableAgain();

    public <A1> A1 reduce(Function2<A1, A1, A1> var1);

    public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> var1);

    public <A1> A1 fold(A1 var1, Function2<A1, A1, A1> var2);

    public <B> B $div$colon(B var1, Function2<B, A, B> var2);

    public <B> B $colon$bslash(B var1, Function2<A, B, B> var2);

    public <B> B foldLeft(B var1, Function2<B, A, B> var2);

    public <B> B foldRight(B var1, Function2<A, B, B> var2);

    public <B> B aggregate(Function0<B> var1, Function2<B, A, B> var2, Function2<B, B, B> var3);

    public <B> B reduceRight(Function2<A, B, B> var1);

    public <B> Option<B> reduceLeftOption(Function2<B, A, B> var1);

    public <B> Option<B> reduceRightOption(Function2<A, B, B> var1);

    public int count(Function1<A, Object> var1);

    public <A1> A1 sum(Numeric<A1> var1);

    public <A1> A1 product(Numeric<A1> var1);

    public <A1> A min(Ordering<A1> var1);

    public <A1> A max(Ordering<A1> var1);

    public <B> A maxBy(Function1<A, B> var1, Ordering<B> var2);

    public <B> A minBy(Function1<A, B> var1, Ordering<B> var2);

    public boolean forall(Function1<A, Object> var1);

    public boolean exists(Function1<A, Object> var1);

    public Option<A> find(Function1<A, Object> var1);

    public <B> void copyToArray(Object var1);

    public <B> void copyToArray(Object var1, int var2);

    public <B> void copyToArray(Object var1, int var2, int var3);

    public String mkString(String var1, String var2, String var3);

    public String mkString(String var1);

    public String mkString();

    public <A1> Object toArray(ClassTag<A1> var1);

    public List<A> toList();

    public IndexedSeq<A> toIndexedSeq();

    public Stream<A> toStream();

    public Iterator<A> toIterator();

    public <A1> Buffer<A1> toBuffer();

    public GenTraversable<A> toTraversable();

    public GenIterable<A> toIterable();

    public GenSeq<A> toSeq();

    public <A1> GenSet<A1> toSet();

    public <K, V> GenMap<K, V> toMap(Predef$.less.colon.less<A, Tuple2<K, V>> var1);

    public Vector<A> toVector();

    public <Col> Col to(CanBuildFrom<Nothing$, A, Col> var1);

    public static void $init$(GenTraversableOnce $this) {
    }
}

