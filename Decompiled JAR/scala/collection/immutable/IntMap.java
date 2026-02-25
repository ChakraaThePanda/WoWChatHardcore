/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.AbstractMap;
import scala.collection.immutable.IntMap$;
import scala.collection.immutable.IntMap$Nil$;
import scala.collection.immutable.IntMapEntryIterator;
import scala.collection.immutable.IntMapKeyIterator;
import scala.collection.immutable.IntMapUtils$;
import scala.collection.immutable.IntMapValueIterator;
import scala.collection.immutable.List;
import scala.collection.mutable.ListBuffer;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\u0011Et!B0a\u0011\u00039g!B5a\u0011\u0003Q\u0007\"B8\u0002\t\u0003\u0001\b\"B9\u0002\t\u0007\u0011\b\"CBg\u0003\t\u0007I\u0011BBh\u0011!\u00199.\u0001Q\u0001\n\rE\u0007bBA\u001d\u0003\u0011\u00051q\u001c\u0005\b\u0007S\fA\u0011ABv\u0011\u001d\t90\u0001C\u0001\u0007s<\u0001\u0002b\u0004\u0002\u0011\u0003\u00037Q\f\u0004\t\u0007+\n\u0001\u0012\u00111\u0004X!1qN\u0003C\u0001\u00077Bqaa\u0018\u000b\t\u0003\u001a\t\u0007C\u0005\u0004>)\t\t\u0011\"\u0011\u0002\u0014\"I1q\b\u0006\u0002\u0002\u0013\u00051\u0011\t\u0005\n\u0007\u000fR\u0011\u0011!C\u0001\u0007KB\u0011ba\u0014\u000b\u0003\u0003%\te!\u0015\t\u0013\r%$\"!A\u0005\n\r-daBB:\u0003\u0001\u00037Q\u000f\u0005\u000b\u0003;\u0014\"Q3A\u0005\u0002\u0005=\u0007BCB@%\tE\t\u0015!\u0003\u0002\u0002!Q!q\u0004\n\u0003\u0016\u0004%\ta!!\t\u0015\r\r%C!E!\u0002\u0013\u0019Y\b\u0003\u0004p%\u0011\u00051Q\u0011\u0005\b\u0007\u001b\u0013B\u0011ABH\u0011%\u0011IPEA\u0001\n\u0003\u0019y\nC\u0005\u0004\u0010I\t\n\u0011\"\u0001\u0004.\"I1q\u0005\n\u0012\u0002\u0013\u00051\u0011\u0017\u0005\n\u0007{\u0011\u0012\u0011!C!\u0003'C\u0011ba\u0010\u0013\u0003\u0003%\ta!\u0011\t\u0013\r\u001d##!A\u0005\u0002\re\u0006\"CB(%\u0005\u0005I\u0011IB)\u000f)!\t\"AA\u0001\u0012\u0003\u0001G1\u0003\u0004\u000b\u0007g\n\u0011\u0011!E\u0001A\u0012U\u0001BB8\"\t\u0003!9\u0002C\u0005\u0005\u001a\u0005\n\t\u0011\"\u0012\u0005\u001c!I\u0011q_\u0011\u0002\u0002\u0013\u0005EQ\u0004\u0005\n\tW\t\u0013\u0011!CA\t[A\u0011b!\u001b\"\u0003\u0003%Iaa\u001b\u0007\u000f\tE\u0016\u0001\u00111\u00034\"Q!\u0011Z\u0014\u0003\u0016\u0004%\t!a4\t\u0015\t-wE!E!\u0002\u0013\t\t\u0001\u0003\u0006\u0003N\u001e\u0012)\u001a!C\u0001\u0003\u001fD!Ba4(\u0005#\u0005\u000b\u0011BA\u0001\u0011)\u0011\tn\nBK\u0002\u0013\u0005!1\u001b\u0005\u000b\u0005+<#\u0011#Q\u0001\n\t]\u0006B\u0003BlO\tU\r\u0011\"\u0001\u0003T\"Q!\u0011\\\u0014\u0003\u0012\u0003\u0006IAa.\t\r=<C\u0011\u0001Bn\u0011\u001d\u0011Io\nC\u0001\u0005WD\u0011B!?(\u0003\u0003%\tAa?\t\u0013\r=q%%A\u0005\u0002\rE\u0001\"CB\u0014OE\u0005I\u0011AB\u0015\u0011%\u0019icJI\u0001\n\u0003\u0019y\u0003C\u0005\u00048\u001d\n\n\u0011\"\u0001\u0004:!I1QH\u0014\u0002\u0002\u0013\u0005\u00131\u0013\u0005\n\u0007\u007f9\u0013\u0011!C\u0001\u0007\u0003B\u0011ba\u0012(\u0003\u0003%\ta!\u0013\t\u0013\r=s%!A\u0005B\rEsA\u0003C \u0003\u0005\u0005\t\u0012\u00011\u0005B\u0019Q!\u0011W\u0001\u0002\u0002#\u0005\u0001\rb\u0011\t\r=dD\u0011\u0001C#\u0011%!I\u0002PA\u0001\n\u000b\"Y\u0002C\u0005\u0002xr\n\t\u0011\"!\u0005H!IA1\u0006\u001f\u0002\u0002\u0013\u0005E1\f\u0005\n\u0007Sb\u0014\u0011!C\u0005\u0007W2Q!\u001b1\u0002\"mDaa\u001c\"\u0005\u0002\u0005]\u0002bBA\u001d\u0005\u0012\u0005\u00131\b\u0005\b\u0003{\u0011E\u0011IA \u0011\u001d\tiE\u0011C\u0001\u0003\u001fBq!!\u0017C\t\u000b\nY\u0006C\u0004\u0002v\t#\t%a\u001e\t\u000f\u0005m$\t\"\u0002\u0002~!9\u00111\u0011\"\u0005B\u0005\u0015\u0005bBAE\u0005\u0012\u0015\u00111\u0012\u0005\b\u0003#\u0013E\u0011IAJ\u0011\u001d\t)K\u0011C!\u0003OCq!a,C\t\u0003\n\t\fC\u0004\u00028\n#\t!!/\t\u000f\u00055'\t\"\u0012\u0002P\"9\u0011\u0011\u001b\"\u0005\u0006\u0005M\u0007bBAp\u0005\u0012\u0015\u0013\u0011\u001d\u0005\b\u0003o\u0014EQIA}\u0011\u001d\tiP\u0011C\u0001\u0003\u007fDqAa\u0004C\t\u0003\u0012\t\u0002C\u0004\u0003\"\t#\tAa\t\t\u000f\tU\"\t\"\u0001\u00038!9!1\b\"\u0005\u0002\tu\u0002b\u0002B'\u0005\u0012\u0005!q\n\u0005\b\u0005K\u0012E\u0011\u0001B4\u0011\u001d\u0011yH\u0011C\u0001\u0005\u0003CqA!$C\t\u0003\u0011y\tC\u0004\u0003\u001c\n#)!a4\t\u000f\t-&\t\"\u0002\u0002P\u00061\u0011J\u001c;NCBT!!\u00192\u0002\u0013%lW.\u001e;bE2,'BA2e\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002K\u0006)1oY1mC\u000e\u0001\u0001C\u00015\u0002\u001b\u0005\u0001'AB%oi6\u000b\u0007o\u0005\u0002\u0002WB\u0011A.\\\u0007\u0002I&\u0011a\u000e\u001a\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u00059\u0017\u0001D2b]\n+\u0018\u000e\u001c3Ge>lW#B:\u0004@\u000e\u001dW#\u0001;\u0011\u000fUD(pa1\u0004L6\taO\u0003\u0002xE\u00069q-\u001a8fe&\u001c\u0017BA=w\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u0011A'i!0\u0016\u0007q\f9b\u0005\u0004C{\u0006%\u0012q\u0006\t\u0007Qz\f\t!a\u0005\n\u0005}\u0004'aC!cgR\u0014\u0018m\u0019;NCB\u0004B!a\u0001\u0002\n9\u0019\u0001.!\u0002\n\u0007\u0005\u001d\u0001-A\u0006J]Rl\u0015\r]+uS2\u001c\u0018\u0002BA\u0006\u0003\u001b\u00111!\u00138u\u0013\u0011\tY!a\u0004\u000b\u0007\u0005Ea/A\u0007CSR|\u0005/\u001a:bi&|gn\u001d\t\u0005\u0003+\t9\u0002\u0004\u0001\u0005\u0011\u0005e!\t\"b\u0001\u00037\u0011\u0011\u0001V\t\u0005\u0003;\t\u0019\u0003E\u0002m\u0003?I1!!\te\u0005\u001dqu\u000e\u001e5j]\u001e\u00042\u0001\\A\u0013\u0013\r\t9\u0003\u001a\u0002\u0004\u0003:L\bc\u00025\u0002,\u0005\u0005\u00111C\u0005\u0004\u0003[\u0001'aA'baBI\u0001.!\r\u0002\u0002\u0005M\u0011QG\u0005\u0004\u0003g\u0001'aB'ba2K7.\u001a\t\u0005Q\n\u000b\u0019\u0002\u0006\u0002\u00026\u0005)Q-\u001c9usV\u0011\u0011QG\u0001\u0007i>d\u0015n\u001d;\u0016\u0005\u0005\u0005\u0003#\u00025\u0002D\u0005\u001d\u0013bAA#A\n!A*[:u!\u001da\u0017\u0011JA\u0001\u0003'I1!a\u0013e\u0005\u0019!V\u000f\u001d7fe\u0005A\u0011\u000e^3sCR|'/\u0006\u0002\u0002RA1\u00111KA+\u0003\u000fj\u0011AY\u0005\u0004\u0003/\u0012'\u0001C%uKJ\fGo\u001c:\u0002\u000f\u0019|'/Z1dQV!\u0011QLA9)\u0011\ty&!\u001a\u0011\u00071\f\t'C\u0002\u0002d\u0011\u0014A!\u00168ji\"9\u0011qM$A\u0002\u0005%\u0014!\u00014\u0011\u000f1\fY'a\u0012\u0002p%\u0019\u0011Q\u000e3\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\u0003BA\u000b\u0003c\"q!a\u001dH\u0005\u0004\tYBA\u0001V\u00031YW-_:Ji\u0016\u0014\u0018\r^8s+\t\tI\b\u0005\u0004\u0002T\u0005U\u0013\u0011A\u0001\u000bM>\u0014X-Y2i\u0017\u0016LH\u0003BA0\u0003\u007fBq!a\u001aJ\u0001\u0004\t\t\tE\u0004m\u0003W\n\t!a\u0018\u0002\u001dY\fG.^3t\u0013R,'/\u0019;peV\u0011\u0011q\u0011\t\u0007\u0003'\n)&a\u0005\u0002\u0019\u0019|'/Z1dQZ\u000bG.^3\u0015\t\u0005}\u0013Q\u0012\u0005\b\u0003OZ\u0005\u0019AAH!\u001da\u00171NA\n\u0003?\nAb\u001d;sS:<\u0007K]3gSb,\"!!&\u0011\t\u0005]\u0015\u0011U\u0007\u0003\u00033SA!a'\u0002\u001e\u0006!A.\u00198h\u0015\t\ty*\u0001\u0003kCZ\f\u0017\u0002BAR\u00033\u0013aa\u0015;sS:<\u0017aB5t\u000b6\u0004H/_\u000b\u0003\u0003S\u00032\u0001\\AV\u0013\r\ti\u000b\u001a\u0002\b\u0005>|G.Z1o\u0003\u00191\u0017\u000e\u001c;feR!\u0011QGAZ\u0011\u001d\t9G\u0014a\u0001\u0003k\u0003r\u0001\\A6\u0003\u000f\nI+A\u0005ue\u0006t7OZ8s[V!\u00111XAa)\u0011\ti,!2\u0011\t!\u0014\u0015q\u0018\t\u0005\u0003+\t\t\rB\u0004\u0002D>\u0013\r!a\u0007\u0003\u0003MCq!a\u001aP\u0001\u0004\t9\rE\u0005m\u0003\u0013\f\t!a\u0005\u0002@&\u0019\u00111\u001a3\u0003\u0013\u0019+hn\u0019;j_:\u0014\u0014\u0001B:ju\u0016,\"!!\u0001\u0002\u0007\u001d,G\u000f\u0006\u0003\u0002V\u0006m\u0007#\u00027\u0002X\u0006M\u0011bAAmI\n1q\n\u001d;j_:Dq!!8R\u0001\u0004\t\t!A\u0002lKf\f\u0011bZ3u\u001fJ,En]3\u0016\t\u0005\r\u0018q\u001d\u000b\u0007\u0003K\fY/!<\u0011\t\u0005U\u0011q\u001d\u0003\b\u0003\u0007\u0014&\u0019AAu#\u0011\t\u0019\"a\t\t\u000f\u0005u'\u000b1\u0001\u0002\u0002!A\u0011q\u001e*\u0005\u0002\u0004\t\t0A\u0004eK\u001a\fW\u000f\u001c;\u0011\u000b1\f\u00190!:\n\u0007\u0005UHM\u0001\u0005=Eft\u0017-\\3?\u0003\u0015\t\u0007\u000f\u001d7z)\u0011\t\u0019\"a?\t\u000f\u0005u7\u000b1\u0001\u0002\u0002\u0005)A\u0005\u001d7vgV!!\u0011\u0001B\u0004)\u0011\u0011\u0019A!\u0003\u0011\t!\u0014%Q\u0001\t\u0005\u0003+\u00119\u0001B\u0004\u0002DR\u0013\r!!;\t\u000f\t-A\u000b1\u0001\u0003\u000e\u0005\u00111N\u001e\t\bY\u0006%\u0013\u0011\u0001B\u0003\u0003\u001d)\b\u000fZ1uK\u0012,BAa\u0005\u0003\u001aQ1!Q\u0003B\u000e\u0005;\u0001B\u0001\u001b\"\u0003\u0018A!\u0011Q\u0003B\r\t\u001d\t\u0019-\u0016b\u0001\u0003SDq!!8V\u0001\u0004\t\t\u0001C\u0004\u0003 U\u0003\rAa\u0006\u0002\u000bY\fG.^3\u0002\u0015U\u0004H-\u0019;f/&$\b.\u0006\u0003\u0003&\t-B\u0003\u0003B\u0014\u0005[\u0011yC!\r\u0011\t!\u0014%\u0011\u0006\t\u0005\u0003+\u0011Y\u0003B\u0004\u0002DZ\u0013\r!!;\t\u000f\u0005ug\u000b1\u0001\u0002\u0002!9!q\u0004,A\u0002\t%\u0002bBA4-\u0002\u0007!1\u0007\t\nY\u0006%\u00171\u0003B\u0015\u0005S\ta\u0001J7j]V\u001cH\u0003BA\u001b\u0005sAq!!8X\u0001\u0004\t\t!\u0001\bn_\u0012Lg-_(s%\u0016lwN^3\u0016\t\t}\"Q\t\u000b\u0005\u0005\u0003\u00129\u0005\u0005\u0003i\u0005\n\r\u0003\u0003BA\u000b\u0005\u000b\"q!a1Y\u0005\u0004\tY\u0002C\u0004\u0002ha\u0003\rA!\u0013\u0011\u00131\fI-!\u0001\u0002\u0014\t-\u0003#\u00027\u0002X\n\r\u0013!C;oS>tw+\u001b;i+\u0011\u0011\tFa\u0016\u0015\r\tM#\u0011\fB/!\u0011A'I!\u0016\u0011\t\u0005U!q\u000b\u0003\b\u0003\u0007L&\u0019AAu\u0011\u001d\u0011Y&\u0017a\u0001\u0005'\nA\u0001\u001e5bi\"9\u0011qM-A\u0002\t}\u0003c\u00037\u0003b\u0005\u0005!Q\u000bB+\u0005+J1Aa\u0019e\u0005%1UO\\2uS>t7'\u0001\tj]R,'o]3di&|gnV5uQV1!\u0011\u000eB=\u0005_\"bAa\u001b\u0003t\tm\u0004\u0003\u00025C\u0005[\u0002B!!\u0006\u0003p\u00119!\u0011\u000f.C\u0002\u0005m!!\u0001*\t\u000f\tm#\f1\u0001\u0003vA!\u0001N\u0011B<!\u0011\t)B!\u001f\u0005\u000f\u0005\r'L1\u0001\u0002\u001c!9\u0011q\r.A\u0002\tu\u0004c\u00037\u0003b\u0005\u0005\u00111\u0003B<\u0005[\nA\"\u001b8uKJ\u001cXm\u0019;j_:,BAa!\u0003\fR!\u0011Q\u0007BC\u0011\u001d\u0011Yf\u0017a\u0001\u0005\u000f\u0003B\u0001\u001b\"\u0003\nB!\u0011Q\u0003BF\t\u001d\u0011\th\u0017b\u0001\u00037\t!\u0002\n9mkN$\u0003\u000f\\;t+\u0011\u0011\tJa&\u0015\t\tM%\u0011\u0014\t\u0005Q\n\u0013)\n\u0005\u0003\u0002\u0016\t]EaBAb9\n\u0007\u0011\u0011\u001e\u0005\b\u00057b\u0006\u0019\u0001BJ\u0003!1\u0017N]:u\u0017\u0016L\bfA/\u0003 B!!\u0011\u0015BT\u001b\t\u0011\u0019KC\u0002\u0003&\u0012\f!\"\u00198o_R\fG/[8o\u0013\u0011\u0011IKa)\u0003\u000fQ\f\u0017\u000e\u001c:fG\u00069A.Y:u\u0017\u0016L\bf\u00010\u0003 &\"!i\n\u0006\u0013\u0005\r\u0011\u0015N\\\u000b\u0005\u0005k\u0013YlE\u0004(\u0005o\u0013iLa1\u0011\t!\u0014%\u0011\u0018\t\u0005\u0003+\u0011Y\f\u0002\u0005\u0002\u001a\u001d\")\u0019AA\u000e!\ra'qX\u0005\u0004\u0005\u0003$'a\u0002)s_\u0012,8\r\u001e\t\u0004Y\n\u0015\u0017b\u0001BdI\na1+\u001a:jC2L'0\u00192mK\u00061\u0001O]3gSb\fq\u0001\u001d:fM&D\b%\u0001\u0003nCN\\\u0017!B7bg.\u0004\u0013\u0001\u00027fMR,\"Aa.\u0002\u000b1,g\r\u001e\u0011\u0002\u000bILw\r\u001b;\u0002\rILw\r\u001b;!))\u0011iN!9\u0003d\n\u0015(q\u001d\t\u0006\u0005?<#\u0011X\u0007\u0002\u0003!9!\u0011\u001a\u0019A\u0002\u0005\u0005\u0001b\u0002Bga\u0001\u0007\u0011\u0011\u0001\u0005\b\u0005#\u0004\u0004\u0019\u0001B\\\u0011\u001d\u00119\u000e\ra\u0001\u0005o\u000b1AY5o+\u0011\u0011iOa=\u0015\r\t=(Q\u001fB|!\u0011A'I!=\u0011\t\u0005U!1\u001f\u0003\b\u0003\u0007\f$\u0019AA\u000e\u0011\u001d\u0011\t.\ra\u0001\u0005_DqAa62\u0001\u0004\u0011y/\u0001\u0003d_BLX\u0003\u0002B\u007f\u0007\u0007!\"Ba@\u0004\u0006\r\u001d1\u0011BB\u0007!\u0015\u0011ynJB\u0001!\u0011\t)ba\u0001\u0005\u000f\u0005e!G1\u0001\u0002\u001c!I!\u0011\u001a\u001a\u0011\u0002\u0003\u0007\u0011\u0011\u0001\u0005\n\u0005\u001b\u0014\u0004\u0013!a\u0001\u0003\u0003A\u0011B!53!\u0003\u0005\raa\u0003\u0011\t!\u00145\u0011\u0001\u0005\n\u0005/\u0014\u0004\u0013!a\u0001\u0007\u0017\tabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0003\u0004\u0014\r\u0015RCAB\u000bU\u0011\t\taa\u0006,\u0005\re\u0001\u0003BB\u000e\u0007Ci!a!\b\u000b\t\r}!1U\u0001\nk:\u001c\u0007.Z2lK\u0012LAaa\t\u0004\u001e\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u000f\u0005e1G1\u0001\u0002\u001c\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012T\u0003BB\n\u0007W!q!!\u00075\u0005\u0004\tY\"\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001a\u0016\t\rE2QG\u000b\u0003\u0007gQCAa.\u0004\u0018\u00119\u0011\u0011D\u001bC\u0002\u0005m\u0011AD2paf$C-\u001a4bk2$H\u0005N\u000b\u0005\u0007c\u0019Y\u0004B\u0004\u0002\u001aY\u0012\r!a\u0007\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\t\u0019\u0019\u0005E\u0002m\u0007\u000bJ1!a\u0003e\u00039\u0001(o\u001c3vGR,E.Z7f]R$B!a\t\u0004L!I1QJ\u001d\u0002\u0002\u0003\u000711I\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\rM\u0003CBA*\u0003+\n\u0019CA\u0002OS2\u001crACB-\u0005{\u0013\u0019\r\u0005\u0003i\u0005\u0006uACAB/!\r\u0011yNC\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005%61\r\u0005\b\u00057b\u0001\u0019AA\u0012)\u0011\t\u0019ca\u001a\t\u0013\r5s\"!AA\u0002\r\r\u0013a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"a!\u001c\u0011\t\u0005]5qN\u0005\u0005\u0007c\nIJ\u0001\u0004PE*,7\r\u001e\u0002\u0004)&\u0004X\u0003BB<\u0007{\u001arAEB=\u0005{\u0013\u0019\r\u0005\u0003i\u0005\u000em\u0004\u0003BA\u000b\u0007{\"\u0001\"!\u0007\u0013\t\u000b\u0007\u00111D\u0001\u0005W\u0016L\b%\u0006\u0002\u0004|\u00051a/\u00197vK\u0002\"baa\"\u0004\n\u000e-\u0005#\u0002Bp%\rm\u0004bBAo/\u0001\u0007\u0011\u0011\u0001\u0005\b\u0005?9\u0002\u0019AB>\u0003%9\u0018\u000e\u001e5WC2,X-\u0006\u0003\u0004\u0012\u000eeE\u0003BBJ\u00077\u0003Ra!&\u0013\u0007/s!\u0001\u001b\u0001\u0011\t\u0005U1\u0011\u0014\u0003\b\u0003\u0007D\"\u0019AA\u000e\u0011\u001d\u0019i\n\u0007a\u0001\u0007/\u000b\u0011a]\u000b\u0005\u0007C\u001b9\u000b\u0006\u0004\u0004$\u000e%61\u0016\t\u0006\u0005?\u00142Q\u0015\t\u0005\u0003+\u00199\u000bB\u0004\u0002\u001ae\u0011\r!a\u0007\t\u0013\u0005u\u0017\u0004%AA\u0002\u0005\u0005\u0001\"\u0003B\u00103A\u0005\t\u0019ABS+\u0011\u0019\u0019ba,\u0005\u000f\u0005e!D1\u0001\u0002\u001cU!11WB\\+\t\u0019)L\u000b\u0003\u0004|\r]AaBA\r7\t\u0007\u00111\u0004\u000b\u0005\u0003G\u0019Y\fC\u0005\u0004Ny\t\t\u00111\u0001\u0004DA!\u0011QCB`\t\u001d\u0019\tm\u0001b\u0001\u00037\u0011\u0011!\u0011\t\bY\u0006%\u0013\u0011ABc!\u0011\t)ba2\u0005\u000f\r%7A1\u0001\u0002\u001c\t\t!\t\u0005\u0003i\u0005\u000e\u0015\u0017a\u0003*fkN\f'\r\\3D\u0005\u001a+\"a!5\u0013\u000b\rM7n!7\u0007\r\rUW\u0001ABi\u00051a$/\u001a4j]\u0016lWM\u001c;?\u00031\u0011V-^:bE2,7I\u0011$!!!)\bpa7\u0004^\u000em\u0007\u0003\u00025C\u0003G\u0001r\u0001\\A%\u0003\u0003\t\u0019#\u0006\u0003\u0004b\u000e\u001dXCABr!\u0011A'i!:\u0011\t\u0005U1q\u001d\u0003\b\u000331!\u0019AA\u000e\u0003%\u0019\u0018N\\4mKR|g.\u0006\u0003\u0004n\u000eMHCBBx\u0007k\u001c9\u0010\u0005\u0003i\u0005\u000eE\b\u0003BA\u000b\u0007g$q!!\u0007\b\u0005\u0004\tY\u0002C\u0004\u0002^\u001e\u0001\r!!\u0001\t\u000f\t}q\u00011\u0001\u0004rV!11 C\u0001)\u0011\u0019i\u0010b\u0001\u0011\t!\u00145q \t\u0005\u0003+!\t\u0001B\u0004\u0002\u001a!\u0011\r!a\u0007\t\u000f\u0011\u0015\u0001\u00021\u0001\u0005\b\u0005)Q\r\\3ngB)A\u000e\"\u0003\u0005\u000e%\u0019A1\u00023\u0003\u0015q\u0012X\r]3bi\u0016$g\bE\u0004m\u0003\u0013\n\taa@\u0002\u00079KG.A\u0002USB\u00042Aa8\"'\u0011\t3Na1\u0015\u0005\u0011M\u0011\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0005UU\u0003\u0002C\u0010\tK!b\u0001\"\t\u0005(\u0011%\u0002#\u0002Bp%\u0011\r\u0002\u0003BA\u000b\tK!q!!\u0007%\u0005\u0004\tY\u0002C\u0004\u0002^\u0012\u0002\r!!\u0001\t\u000f\t}A\u00051\u0001\u0005$\u00059QO\\1qa2LX\u0003\u0002C\u0018\to!B\u0001\"\r\u0005:A)A.a6\u00054A9A.!\u0013\u0002\u0002\u0011U\u0002\u0003BA\u000b\to!q!!\u0007&\u0005\u0004\tY\u0002C\u0005\u0005<\u0015\n\t\u00111\u0001\u0005>\u0005\u0019\u0001\u0010\n\u0019\u0011\u000b\t}'\u0003\"\u000e\u0002\u0007\tKg\u000eE\u0002\u0003`r\u001aB\u0001P6\u0003DR\u0011A\u0011I\u000b\u0005\t\u0013\"y\u0005\u0006\u0006\u0005L\u0011EC1\u000bC+\t3\u0002RAa8(\t\u001b\u0002B!!\u0006\u0005P\u00119\u0011\u0011D C\u0002\u0005m\u0001b\u0002Be\u007f\u0001\u0007\u0011\u0011\u0001\u0005\b\u0005\u001b|\u0004\u0019AA\u0001\u0011\u001d\u0011\tn\u0010a\u0001\t/\u0002B\u0001\u001b\"\u0005N!9!q[ A\u0002\u0011]S\u0003\u0002C/\tW\"B\u0001b\u0018\u0005nA)A.a6\u0005bAYA\u000eb\u0019\u0002\u0002\u0005\u0005Aq\rC4\u0013\r!)\u0007\u001a\u0002\u0007)V\u0004H.\u001a\u001b\u0011\t!\u0014E\u0011\u000e\t\u0005\u0003+!Y\u0007B\u0004\u0002\u001a\u0001\u0013\r!a\u0007\t\u0013\u0011m\u0002)!AA\u0002\u0011=\u0004#\u0002BpO\u0011%\u0004")
public abstract class IntMap<T>
extends AbstractMap<Object, T> {
    public static <T> IntMap<T> singleton(int n, T t) {
        return IntMap$.MODULE$.singleton(n, t);
    }

    public static <A, B> CanBuildFrom<IntMap<A>, Tuple2<Object, B>, IntMap<B>> canBuildFrom() {
        return IntMap$.MODULE$.canBuildFrom();
    }

    @Override
    public IntMap<T> empty() {
        return IntMap$Nil$.MODULE$;
    }

    @Override
    public List<Tuple2<Object, T>> toList() {
        ListBuffer buffer = new ListBuffer();
        this.foreach((Function1)(Function1<Tuple2, ListBuffer> & java.io.Serializable & Serializable)x$1 -> buffer.$plus$eq(x$1));
        return buffer.toList();
    }

    @Override
    public Iterator<Tuple2<Object, T>> iterator() {
        Iterator<Nothing$> iterator2 = ((Object)IntMap$Nil$.MODULE$).equals(this) ? Iterator$.MODULE$.empty() : new IntMapEntryIterator(this);
        return iterator2;
    }

    @Override
    public final <U> void foreach(Function1<Tuple2<Object, T>, U> f) {
        while (this_ instanceof Bin) {
            Bin bin = (Bin)this_;
            IntMap<T> left = bin.left();
            IntMap right = bin.right();
            left.foreach(f);
            IntMap this_ = right;
        }
        if (this_ instanceof Tip) {
            Tip tip = (Tip)this_;
            int key = tip.key();
            Object value = tip.value();
            f.apply(new Tuple2(BoxesRunTime.boxToInteger(key), value));
            return;
        }
        if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
            return;
        }
        throw new MatchError(this_);
    }

    @Override
    public Iterator<Object> keysIterator() {
        Iterator<Object> iterator2 = ((Object)IntMap$Nil$.MODULE$).equals(this) ? Iterator$.MODULE$.empty() : new IntMapKeyIterator(this);
        return iterator2;
    }

    public final void foreachKey(Function1<Object, BoxedUnit> f) {
        while (this_ instanceof Bin) {
            Bin bin = (Bin)this_;
            IntMap left = bin.left();
            IntMap right = bin.right();
            left.foreachKey(f);
            IntMap this_ = right;
        }
        if (this_ instanceof Tip) {
            int key = ((Tip)this_).key();
            f.apply$mcVI$sp(key);
            return;
        }
        if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
            return;
        }
        throw new MatchError(this_);
    }

    @Override
    public Iterator<T> valuesIterator() {
        Iterator<Nothing$> iterator2 = ((Object)IntMap$Nil$.MODULE$).equals(this) ? Iterator$.MODULE$.empty() : new IntMapValueIterator<Nothing$>(this);
        return iterator2;
    }

    public final void foreachValue(Function1<T, BoxedUnit> f) {
        while (this_ instanceof Bin) {
            Bin bin = (Bin)this_;
            IntMap<T> left = bin.left();
            IntMap right = bin.right();
            left.foreachValue(f);
            IntMap this_ = right;
        }
        if (this_ instanceof Tip) {
            Object value = ((Tip)this_).value();
            f.apply(value);
            return;
        }
        if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
            return;
        }
        throw new MatchError(this_);
    }

    @Override
    public String stringPrefix() {
        return "IntMap";
    }

    @Override
    public boolean isEmpty() {
        return ((Object)this).equals(IntMap$Nil$.MODULE$);
    }

    @Override
    public IntMap<T> filter(Function1<Tuple2<Object, T>, Object> f) {
        IntMap intMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            int prefix = bin.prefix();
            int mask = bin.mask();
            IntMap left = bin.left();
            IntMap right = bin.right();
            Object object = right.filter((Function1)f);
            Object object2 = left.filter((Function1)f);
            Object object3 = object;
            Object newleft = object2;
            Object newright = object3;
            intMap = left == newleft && right == newright ? this : IntMapUtils$.MODULE$.bin(prefix, mask, newleft, newright);
        } else if (this instanceof Tip) {
            Tip tip = (Tip)this;
            int key = tip.key();
            Object value = tip.value();
            intMap = BoxesRunTime.unboxToBoolean(f.apply(new Tuple2(BoxesRunTime.boxToInteger(key), value))) ? this : IntMap$Nil$.MODULE$;
        } else if (((Object)IntMap$Nil$.MODULE$).equals(this)) {
            intMap = IntMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return intMap;
    }

    public <S> IntMap<S> transform(Function2<Object, T, S> f) {
        IntMap intMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            IntMap<T> left = bin.left();
            IntMap<T> right = bin.right();
            intMap = bin.bin(left.transform(f), right.transform(f));
        } else if (this instanceof Tip) {
            Tip tip = (Tip)this;
            int key = tip.key();
            Object value = tip.value();
            intMap = tip.withValue(f.apply(BoxesRunTime.boxToInteger(key), value));
        } else if (((Object)IntMap$Nil$.MODULE$).equals(this)) {
            intMap = IntMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return intMap;
    }

    @Override
    public final int size() {
        int n;
        if (((Object)IntMap$Nil$.MODULE$).equals(this)) {
            n = 0;
        } else if (this instanceof Tip) {
            n = 1;
        } else if (this instanceof Bin) {
            Bin bin = (Bin)this;
            IntMap left = bin.left();
            IntMap right = bin.right();
            n = left.size() + right.size();
        } else {
            throw new MatchError(this);
        }
        return n;
    }

    @Override
    public final Option<T> get(int key) {
        None$ none$;
        while (this_ instanceof Bin) {
            IntMap this_;
            Bin bin = (Bin)this_;
            int mask = bin.mask();
            IntMap left = bin.left();
            IntMap right = bin.right();
            if (IntMapUtils$.MODULE$.zero(key, mask)) {
                this_ = left;
                continue;
            }
            this_ = right;
        }
        if (this_ instanceof Tip) {
            Tip tip = (Tip)this_;
            int key2 = tip.key();
            Object value = tip.value();
            none$ = key == key2 ? new Some(value) : None$.MODULE$;
        } else if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
            none$ = None$.MODULE$;
        } else {
            throw new MatchError(this_);
        }
        return none$;
    }

    @Override
    public final <S> S getOrElse(int key, Function0<S> function0) {
        Object object;
        block4: {
            while (true) {
                IntMap this_;
                if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
                    object = function0.apply();
                    break block4;
                }
                if (this_ instanceof Tip) {
                    Tip tip = (Tip)this_;
                    int key2 = tip.key();
                    Object value = tip.value();
                    object = key == key2 ? value : function0.apply();
                    break block4;
                }
                if (!(this_ instanceof Bin)) break;
                Bin bin = (Bin)this_;
                int mask = bin.mask();
                IntMap left = bin.left();
                IntMap right = bin.right();
                if (IntMapUtils$.MODULE$.zero(key, mask)) {
                    this_ = left;
                    continue;
                }
                this_ = right;
            }
            throw new MatchError(this_);
        }
        return object;
    }

    @Override
    public final T apply(int key) {
        Object t;
        while (this_ instanceof Bin) {
            IntMap this_;
            Bin bin = (Bin)this_;
            int mask = bin.mask();
            IntMap left = bin.left();
            IntMap right = bin.right();
            if (IntMapUtils$.MODULE$.zero(key, mask)) {
                this_ = left;
                continue;
            }
            this_ = right;
        }
        if (this_ instanceof Tip) {
            Tip tip = (Tip)this_;
            int key2 = tip.key();
            t = tip.value();
            if (key != key2) {
                throw package$.MODULE$.error("Key not found");
            }
        } else {
            if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
                throw package$.MODULE$.error("key not found");
            }
            throw new MatchError(this_);
        }
        return t;
    }

    public <S> IntMap<S> $plus(Tuple2<Object, S> kv) {
        return this.updated(kv._1$mcI$sp(), kv._2());
    }

    public <S> IntMap<S> updated(int key, S value) {
        IntMap intMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            int prefix = bin.prefix();
            int mask = bin.mask();
            IntMap left = bin.left();
            IntMap right = bin.right();
            intMap = !IntMapUtils$.MODULE$.hasMatch(key, prefix, mask) ? IntMapUtils$.MODULE$.join(key, new Tip<S>(key, value), prefix, this) : (IntMapUtils$.MODULE$.zero(key, mask) ? new Bin<S>(prefix, mask, left.updated(key, value), right) : new Bin(prefix, mask, left, right.updated(key, value)));
        } else if (this instanceof Tip) {
            int key2 = ((Tip)this).key();
            intMap = key == key2 ? new Tip<S>(key, value) : IntMapUtils$.MODULE$.join(key, new Tip<S>(key, value), key2, this);
        } else if (((Object)IntMap$Nil$.MODULE$).equals(this)) {
            intMap = new Tip<S>(key, value);
        } else {
            throw new MatchError(this);
        }
        return intMap;
    }

    public <S> IntMap<S> updateWith(int key, S value, Function2<T, S, S> f) {
        IntMap intMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            int prefix = bin.prefix();
            int mask = bin.mask();
            IntMap<T> left = bin.left();
            IntMap<T> right = bin.right();
            intMap = !IntMapUtils$.MODULE$.hasMatch(key, prefix, mask) ? IntMapUtils$.MODULE$.join(key, new Tip<S>(key, value), prefix, this) : (IntMapUtils$.MODULE$.zero(key, mask) ? new Bin<S>(prefix, mask, left.updateWith(key, value, f), right) : new Bin(prefix, mask, left, right.updateWith(key, value, f)));
        } else if (this instanceof Tip) {
            Tip tip = (Tip)this;
            int key2 = tip.key();
            Object value2 = tip.value();
            intMap = key == key2 ? new Tip<S>(key, f.apply(value2, value)) : IntMapUtils$.MODULE$.join(key, new Tip<S>(key, value), key2, this);
        } else if (((Object)IntMap$Nil$.MODULE$).equals(this)) {
            intMap = new Tip<S>(key, value);
        } else {
            throw new MatchError(this);
        }
        return intMap;
    }

    @Override
    public IntMap<T> $minus(int key) {
        IntMap intMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            int prefix = bin.prefix();
            int mask = bin.mask();
            IntMap left = bin.left();
            IntMap right = bin.right();
            intMap = !IntMapUtils$.MODULE$.hasMatch(key, prefix, mask) ? this : (IntMapUtils$.MODULE$.zero(key, mask) ? IntMapUtils$.MODULE$.bin(prefix, mask, left.$minus(key), right) : IntMapUtils$.MODULE$.bin(prefix, mask, left, right.$minus(key)));
        } else if (this instanceof Tip) {
            int key2 = ((Tip)this).key();
            intMap = key == key2 ? IntMap$Nil$.MODULE$ : this;
        } else if (((Object)IntMap$Nil$.MODULE$).equals(this)) {
            intMap = IntMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return intMap;
    }

    public <S> IntMap<S> modifyOrRemove(Function2<Object, T, Option<S>> f) {
        IntMap intMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)((Object)this);
            int prefix = bin.prefix();
            int mask = bin.mask();
            IntMap<T> left = bin.left();
            IntMap<T> right = bin.right();
            IntMap<S> newleft = left.modifyOrRemove(f);
            IntMap<S> newright = right.modifyOrRemove(f);
            intMap = left == newleft && right == newright ? this : IntMapUtils$.MODULE$.bin(prefix, mask, newleft, newright);
        } else if (this instanceof Tip) {
            IntMap intMap2;
            Tip tip = this;
            int key = tip.key();
            Object value = tip.value();
            Option<S> option = f.apply(BoxesRunTime.boxToInteger(key), value);
            if (None$.MODULE$.equals(option)) {
                intMap2 = IntMap$Nil$.MODULE$;
            } else if (option instanceof Some) {
                Object value2 = ((Some)option).value();
                intMap2 = value == value2 ? this : new Tip(key, value2);
            } else {
                throw new MatchError(option);
            }
            intMap = intMap2;
        } else if (((Object)IntMap$Nil$.MODULE$).equals(this)) {
            intMap = IntMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return intMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public <S> IntMap<S> unionWith(IntMap<S> that, Function3<Object, S, S, S> f) {
        Tuple2<IntMap, IntMap> tuple2 = new Tuple2<IntMap, IntMap>(this, that);
        IntMap intMap = this;
        IntMap that2 = that;
        if (intMap instanceof Bin) {
            Bin bin = (Bin)intMap;
            int p1 = bin.prefix();
            int m1 = bin.mask();
            IntMap l1 = bin.left();
            IntMap r1 = bin.right();
            if (that2 instanceof Bin) {
                Bin bin2 = (Bin)that2;
                int p2 = bin2.prefix();
                int m2 = bin2.mask();
                IntMap l2 = bin2.left();
                IntMap r2 = bin2.right();
                return IntMapUtils$.MODULE$.shorter(m1, m2) ? (!IntMapUtils$.MODULE$.hasMatch(p2, p1, m1) ? IntMapUtils$.MODULE$.join(p1, this, p2, bin2) : (IntMapUtils$.MODULE$.zero(p2, m1) ? new Bin<S>(p1, m1, l1.unionWith(bin2, f), r1) : new Bin(p1, m1, l1, r1.unionWith(bin2, f)))) : (IntMapUtils$.MODULE$.shorter(m2, m1) ? (!IntMapUtils$.MODULE$.hasMatch(p1, p2, m2) ? IntMapUtils$.MODULE$.join(p1, this, p2, bin2) : (IntMapUtils$.MODULE$.zero(p1, m2) ? new Bin(p2, m2, this.unionWith(l2, f), r2) : new Bin(p2, m2, l2, this.unionWith(r2, f)))) : (p1 == p2 ? new Bin(p1, m1, l1.unionWith(l2, f), r1.unionWith(r2, f)) : IntMapUtils$.MODULE$.join(p1, this, p2, bin2)));
            }
        }
        IntMap intMap2 = this;
        IntMap x2 = that;
        if (intMap2 instanceof Tip) {
            Tip tip = (Tip)intMap2;
            int key = tip.key();
            Object value = tip.value();
            return x2.updateWith(key, value, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> f.apply(BoxesRunTime.boxToInteger(key), y, x));
        }
        if (tuple2 != null) {
            IntMap x3 = this;
            IntMap intMap3 = that;
            if (intMap3 instanceof Tip) {
                Tip tip = (Tip)intMap3;
                int key = tip.key();
                Object value = tip.value();
                return x3.updateWith(key, value, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> f.apply(BoxesRunTime.boxToInteger(key), x, y));
            }
        }
        if (tuple2 != null) {
            IntMap intMap4 = this;
            IntMap x4 = that;
            if (((Object)IntMap$Nil$.MODULE$).equals(intMap4)) {
                return x4;
            }
        }
        if (tuple2 == null) throw new MatchError(tuple2);
        IntMap x5 = this;
        IntMap intMap5 = that;
        if (!((Object)IntMap$Nil$.MODULE$).equals(intMap5)) throw new MatchError(tuple2);
        return x5;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public <S, R> IntMap<R> intersectionWith(IntMap<S> that, Function3<Object, T, S, R> f) {
        IntMap<S> intMap;
        Tuple2<IntMap, IntMap<S>> tuple2 = new Tuple2<IntMap, IntMap<S>>(this, that);
        IntMap intMap2 = this;
        IntMap<S> that2 = that;
        if (intMap2 instanceof Bin) {
            Bin bin = (Bin)intMap2;
            int p1 = bin.prefix();
            int m1 = bin.mask();
            IntMap<T> l1 = bin.left();
            IntMap<T> r1 = bin.right();
            if (that2 instanceof Bin) {
                Bin bin2 = (Bin)that2;
                int p2 = bin2.prefix();
                int m2 = bin2.mask();
                IntMap l2 = bin2.left();
                IntMap r2 = bin2.right();
                return IntMapUtils$.MODULE$.shorter(m1, m2) ? (!IntMapUtils$.MODULE$.hasMatch(p2, p1, m1) ? IntMap$Nil$.MODULE$ : (IntMapUtils$.MODULE$.zero(p2, m1) ? l1.intersectionWith(bin2, f) : r1.intersectionWith(bin2, f))) : (m1 == m2 ? IntMapUtils$.MODULE$.bin(p1, m1, l1.intersectionWith(l2, f), r1.intersectionWith(r2, f)) : (!IntMapUtils$.MODULE$.hasMatch(p1, p2, m2) ? IntMap$Nil$.MODULE$ : (IntMapUtils$.MODULE$.zero(p1, m2) ? this.intersectionWith(l2, f) : this.intersectionWith(r2, f))));
            }
        }
        IntMap intMap3 = this;
        IntMap<S> that3 = that;
        if (intMap3 instanceof Tip) {
            void var5_25;
            Tip tip = (Tip)intMap3;
            int key = tip.key();
            Object value = tip.value();
            Option<S> option = that3.get(key);
            if (None$.MODULE$.equals(option)) {
                IntMap$Nil$ intMap$Nil$ = IntMap$Nil$.MODULE$;
                return var5_25;
            } else {
                if (!(option instanceof Some)) throw new MatchError(option);
                Object value2 = ((Some)option).value();
                Tip<R> tip2 = new Tip<R>(key, f.apply(BoxesRunTime.boxToInteger(key), value, value2));
            }
            return var5_25;
        }
        if (tuple2 != null && (intMap = that) instanceof Tip) {
            void var4_34;
            Tip tip = (Tip)intMap;
            int key = tip.key();
            Object value = tip.value();
            Option<T> option = this.get(key);
            if (None$.MODULE$.equals(option)) {
                IntMap$Nil$ intMap$Nil$ = IntMap$Nil$.MODULE$;
                return var4_34;
            } else {
                if (!(option instanceof Some)) throw new MatchError(option);
                Object value2 = ((Some)option).value();
                Tip<R> tip3 = new Tip<R>(key, f.apply(BoxesRunTime.boxToInteger(key), value2, value));
            }
            return var4_34;
        }
        if (tuple2 == null) throw new MatchError((Object)null);
        return IntMap$Nil$.MODULE$;
    }

    public <R> IntMap<T> intersection(IntMap<R> that) {
        return this.intersectionWith(that, (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(key, value, value2) -> value);
    }

    public <S> IntMap<S> $plus$plus(IntMap<S> that) {
        return this.unionWith(that, (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(key, x, y) -> y);
    }

    public final int firstKey() {
        while (this_ instanceof Bin) {
            IntMap this_ = ((Bin)this_).left();
        }
        if (!(this_ instanceof Tip)) {
            if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
                throw package$.MODULE$.error("Empty set");
            }
            throw new MatchError(this_);
        }
        int n = ((Tip)this_).key();
        return n;
    }

    public final int lastKey() {
        while (this_ instanceof Bin) {
            IntMap this_ = ((Bin)this_).right();
        }
        if (!(this_ instanceof Tip)) {
            if (((Object)IntMap$Nil$.MODULE$).equals(this_)) {
                throw package$.MODULE$.error("Empty set");
            }
            throw new MatchError(this_);
        }
        int n = ((Tip)this_).key();
        return n;
    }

    public static class Bin<T>
    extends IntMap<T>
    implements Product,
    Serializable {
        private final int prefix;
        private final int mask;
        private final IntMap<T> left;
        private final IntMap<T> right;

        public int prefix() {
            return this.prefix;
        }

        public int mask() {
            return this.mask;
        }

        public IntMap<T> left() {
            return this.left;
        }

        public IntMap<T> right() {
            return this.right;
        }

        public <S> IntMap<S> bin(IntMap<S> left, IntMap<S> right) {
            if (this.left() == left && this.right() == right) {
                return this;
            }
            return new Bin<S>(this.prefix(), this.mask(), left, right);
        }

        public <T> Bin<T> copy(int prefix, int mask, IntMap<T> left, IntMap<T> right) {
            return new Bin<T>(prefix, mask, left, right);
        }

        public <T> int copy$default$1() {
            return this.prefix();
        }

        public <T> int copy$default$2() {
            return this.mask();
        }

        public <T> IntMap<T> copy$default$3() {
            return this.left();
        }

        public <T> IntMap<T> copy$default$4() {
            return this.right();
        }

        @Override
        public String productPrefix() {
            return "Bin";
        }

        @Override
        public int productArity() {
            return 4;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return BoxesRunTime.boxToInteger(this.prefix());
                }
                case 1: {
                    return BoxesRunTime.boxToInteger(this.mask());
                }
                case 2: {
                    return this.left();
                }
                case 3: {
                    return this.right();
                }
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        public Bin(int prefix, int mask, IntMap<T> left, IntMap<T> right) {
            this.prefix = prefix;
            this.mask = mask;
            this.left = left;
            this.right = right;
            Product.$init$(this);
        }
    }

    public static class Tip<T>
    extends IntMap<T>
    implements Product,
    Serializable {
        private final int key;
        private final T value;

        public int key() {
            return this.key;
        }

        public T value() {
            return this.value;
        }

        public <S> Tip<S> withValue(S s) {
            if (s == this.value()) {
                return this;
            }
            return new Tip<S>(this.key(), s);
        }

        public <T> Tip<T> copy(int key, T value) {
            return new Tip<T>(key, value);
        }

        public <T> int copy$default$1() {
            return this.key();
        }

        public <T> T copy$default$2() {
            return this.value();
        }

        @Override
        public String productPrefix() {
            return "Tip";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return BoxesRunTime.boxToInteger(this.key());
                }
                case 1: {
                    return this.value();
                }
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        public Tip(int key, T value) {
            this.key = key;
            this.value = value;
            Product.$init$(this);
        }
    }
}

