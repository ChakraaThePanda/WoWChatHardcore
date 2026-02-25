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
import scala.collection.immutable.List;
import scala.collection.immutable.LongMap$;
import scala.collection.immutable.LongMap$Nil$;
import scala.collection.immutable.LongMapEntryIterator;
import scala.collection.immutable.LongMapKeyIterator;
import scala.collection.immutable.LongMapUtils$;
import scala.collection.immutable.LongMapValueIterator;
import scala.collection.mutable.ListBuffer;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\u00115t!\u00020`\u0011\u00031g!\u00025`\u0011\u0003I\u0007\"\u00028\u0002\t\u0003y\u0007\"\u00029\u0002\t\u0007\t\b\u0002CBg\u0003\u0001\u0006Iaa4\t\u000f\u0005]\u0012\u0001\"\u0001\u0004\\\"91Q]\u0001\u0005\u0002\r\u001d\bbBA~\u0003\u0011\u00051Q_\u0004\t\t\u0017\t\u0001\u0012Q0\u0004^\u0019A1QK\u0001\t\u0002~\u001b9\u0006\u0003\u0004o\u0013\u0011\u000511\f\u0005\b\u0007?JA\u0011IB1\u0011%\u0019\u0019%CA\u0001\n\u0003\n\t\nC\u0005\u0004F%\t\t\u0011\"\u0001\u0002N\"I1qI\u0005\u0002\u0002\u0013\u00051Q\r\u0005\n\u0007\u001fJ\u0011\u0011!C!\u0007#B\u0011b!\u001b\n\u0003\u0003%Iaa\u001b\u0007\u000f\rM\u0014\u0001Q0\u0004v!Q\u0011\u0011]\t\u0003\u0016\u0004%\tA!)\t\u0013\r}\u0014C!E!\u0002\u0013y\bB\u0003B\u0012#\tU\r\u0011\"\u0001\u0004\u0002\"Q11Q\t\u0003\u0012\u0003\u0006Iaa\u001f\t\r9\fB\u0011ABC\u0011\u001d\u0019i)\u0005C\u0001\u0007\u001fC\u0011Ba@\u0012\u0003\u0003%\taa(\t\u0013\rU\u0011#%A\u0005\u0002\r5\u0006\"CB\u0017#E\u0005I\u0011ABY\u0011%\u0019\u0019%EA\u0001\n\u0003\n\t\nC\u0005\u0004FE\t\t\u0011\"\u0001\u0002N\"I1qI\t\u0002\u0002\u0013\u00051\u0011\u0018\u0005\n\u0007\u001f\n\u0012\u0011!C!\u0007#:!\u0002\"\u0004\u0002\u0003\u0003E\ta\u0018C\b\r)\u0019\u0019(AA\u0001\u0012\u0003yF\u0011\u0003\u0005\u0007]\u0002\"\t\u0001b\u0005\t\u0013\u0011U\u0001%!A\u0005F\u0011]\u0001\"CA~A\u0005\u0005I\u0011\u0011C\r\u0011%!9\u0003IA\u0001\n\u0003#I\u0003C\u0005\u0004j\u0001\n\t\u0011\"\u0003\u0004l\u00199!qW\u0001A?\ne\u0006B\u0003BhM\tU\r\u0011\"\u0001\u0003\"\"I!\u0011\u001b\u0014\u0003\u0012\u0003\u0006Ia \u0005\u000b\u0005'4#Q3A\u0005\u0002\t\u0005\u0006\"\u0003BkM\tE\t\u0015!\u0003\u0000\u0011)\u00119N\nBK\u0002\u0013\u0005!\u0011\u001c\u0005\u000b\u000574#\u0011#Q\u0001\n\tu\u0006B\u0003BoM\tU\r\u0011\"\u0001\u0003Z\"Q!q\u001c\u0014\u0003\u0012\u0003\u0006IA!0\t\r94C\u0011\u0001Bq\u0011\u001d\u0011yO\nC\u0001\u0005cD\u0011Ba@'\u0003\u0003%\ta!\u0001\t\u0013\rUa%%A\u0005\u0002\r]\u0001\"CB\u0017ME\u0005I\u0011AB\u0018\u0011%\u0019\u0019DJI\u0001\n\u0003\u0019)\u0004C\u0005\u0004>\u0019\n\n\u0011\"\u0001\u0004@!I11\t\u0014\u0002\u0002\u0013\u0005\u0013\u0011\u0013\u0005\n\u0007\u000b2\u0013\u0011!C\u0001\u0003\u001bD\u0011ba\u0012'\u0003\u0003%\ta!\u0013\t\u0013\r=c%!A\u0005B\rEsA\u0003C\u001e\u0003\u0005\u0005\t\u0012A0\u0005>\u0019Q!qW\u0001\u0002\u0002#\u0005q\fb\u0010\t\r9\\D\u0011\u0001C!\u0011%!)bOA\u0001\n\u000b\"9\u0002C\u0005\u0002|n\n\t\u0011\"!\u0005D!IAqE\u001e\u0002\u0002\u0013\u0005Eq\u000b\u0005\n\u0007SZ\u0014\u0011!C\u0005\u0007W2Q\u0001[0\u0002\"iDaA\\!\u0005\u0002\u0005U\u0002bBA\u001c\u0003\u0012\u0005\u0013\u0011\b\u0005\b\u0003w\tE\u0011IA\u001f\u0011\u001d\tY%\u0011C\u0001\u0003\u001bBq!a\u0016B\t\u000b\nI\u0006C\u0004\u0002t\u0005#\t%!\u001e\t\u000f\u0005e\u0014\t\"\u0002\u0002|!9\u0011\u0011Q!\u0005B\u0005\r\u0005bBAD\u0003\u0012\u0015\u0011\u0011\u0012\u0005\b\u0003\u001f\u000bE\u0011IAI\u0011\u001d\t\u0019+\u0011C!\u0003KCq!!,B\t\u0003\ny\u000bC\u0004\u00026\u0006#\t!a.\t\u000f\u0005-\u0017\t\"\u0012\u0002N\"9\u0011Q[!\u0005\u0006\u0005]\u0007bBAr\u0003\u0012\u0015\u0013Q\u001d\u0005\b\u0003w\fEQIA\u007f\u0011\u001d\u0011\t!\u0011C\u0001\u0005\u0007AqAa\u0005B\t\u0003\u0012)\u0002C\u0004\u0003&\u0005#\tAa\n\t\u000f\te\u0012\t\"\u0001\u0003<!9!qH!\u0005\u0002\t\u0005\u0003b\u0002B)\u0003\u0012\u0005!1\u000b\u0005\b\u0005S\nE\u0011\u0001B6\u0011\u001d\u0011\u0019)\u0011C\u0001\u0005\u000bCqA!%B\t\u0003\u0011\u0019\nC\u0004\u0003 \u0006#)A!)\t\u000f\tE\u0016\t\"\u0002\u0003\"\u00069Aj\u001c8h\u001b\u0006\u0004(B\u00011b\u0003%IW.\\;uC\ndWM\u0003\u0002cG\u0006Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003\u0011\fQa]2bY\u0006\u001c\u0001\u0001\u0005\u0002h\u00035\tqLA\u0004M_:<W*\u00199\u0014\u0005\u0005Q\u0007CA6m\u001b\u0005\u0019\u0017BA7d\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012AZ\u0001\rG\u0006t')^5mI\u001a\u0013x.\\\u000b\u0006e\u000e}6qY\u000b\u0002gB9Ao^=\u0004D\u000e-W\"A;\u000b\u0005Y\f\u0017aB4f]\u0016\u0014\u0018nY\u0005\u0003qV\u0014AbQ1o\u0005VLG\u000e\u001a$s_6\u0004BaZ!\u0004>V\u001910!\u0006\u0014\r\u0005c\u0018qEA\u0017!\u00159Wp`A\t\u0013\tqxLA\u0006BEN$(/Y2u\u001b\u0006\u0004\b\u0003BA\u0001\u0003\u000fq1aZA\u0002\u0013\r\t)aX\u0001\r\u0019>tw-T1q+RLGn]\u0005\u0005\u0003\u0013\tYA\u0001\u0003M_:<\u0017\u0002BA\u0005\u0003\u001bQ1!a\u0004v\u00035\u0011\u0015\u000e^(qKJ\fG/[8ogB!\u00111CA\u000b\u0019\u0001!\u0001\"a\u0006B\t\u000b\u0007\u0011\u0011\u0004\u0002\u0002)F!\u00111DA\u0011!\rY\u0017QD\u0005\u0004\u0003?\u0019'a\u0002(pi\"Lgn\u001a\t\u0004W\u0006\r\u0012bAA\u0013G\n\u0019\u0011I\\=\u0011\r\u001d\fIc`A\t\u0013\r\tYc\u0018\u0002\u0004\u001b\u0006\u0004\b\u0003C4\u00020}\f\t\"a\r\n\u0007\u0005ErLA\u0004NCBd\u0015n[3\u0011\t\u001d\f\u0015\u0011\u0003\u000b\u0003\u0003g\tQ!Z7qif,\"!a\r\u0002\rQ|G*[:u+\t\ty\u0004E\u0003h\u0003\u0003\n)%C\u0002\u0002D}\u0013A\u0001T5tiB11.a\u0012\u0000\u0003#I1!!\u0013d\u0005\u0019!V\u000f\u001d7fe\u0005A\u0011\u000e^3sCR|'/\u0006\u0002\u0002PA1\u0011\u0011KA*\u0003\u000bj\u0011!Y\u0005\u0004\u0003+\n'\u0001C%uKJ\fGo\u001c:\u0002\u000f\u0019|'/Z1dQV!\u00111LA8)\u0011\ti&a\u0019\u0011\u0007-\fy&C\u0002\u0002b\r\u0014A!\u00168ji\"9\u0011Q\r$A\u0002\u0005\u001d\u0014!\u00014\u0011\u000f-\fI'!\u0012\u0002n%\u0019\u00111N2\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\u0003BA\n\u0003_\"q!!\u001dG\u0005\u0004\tIBA\u0001V\u00031YW-_:Ji\u0016\u0014\u0018\r^8s+\t\t9\bE\u0003\u0002R\u0005Ms0\u0001\u0006g_J,\u0017m\u00195LKf$B!!\u0018\u0002~!9\u0011Q\r%A\u0002\u0005}\u0004CB6\u0002j}\fi&\u0001\bwC2,Xm]%uKJ\fGo\u001c:\u0016\u0005\u0005\u0015\u0005CBA)\u0003'\n\t\"\u0001\u0007g_J,\u0017m\u00195WC2,X\r\u0006\u0003\u0002^\u0005-\u0005bBA3\u0015\u0002\u0007\u0011Q\u0012\t\bW\u0006%\u0014\u0011CA/\u00031\u0019HO]5oOB\u0013XMZ5y+\t\t\u0019\n\u0005\u0003\u0002\u0016\u0006}UBAAL\u0015\u0011\tI*a'\u0002\t1\fgn\u001a\u0006\u0003\u0003;\u000bAA[1wC&!\u0011\u0011UAL\u0005\u0019\u0019FO]5oO\u00069\u0011n]#naRLXCAAT!\rY\u0017\u0011V\u0005\u0004\u0003W\u001b'a\u0002\"p_2,\u0017M\\\u0001\u0007M&dG/\u001a:\u0015\t\u0005M\u0012\u0011\u0017\u0005\b\u0003Kj\u0005\u0019AAZ!\u001dY\u0017\u0011NA#\u0003O\u000b\u0011\u0002\u001e:b]N4wN]7\u0016\t\u0005e\u0016q\u0018\u000b\u0005\u0003w\u000b\u0019\r\u0005\u0003h\u0003\u0006u\u0006\u0003BA\n\u0003\u007f#q!!1O\u0005\u0004\tIBA\u0001T\u0011\u001d\t)G\u0014a\u0001\u0003\u000b\u0004\u0002b[Ad\u007f\u0006E\u0011QX\u0005\u0004\u0003\u0013\u001c'!\u0003$v]\u000e$\u0018n\u001c83\u0003\u0011\u0019\u0018N_3\u0016\u0005\u0005=\u0007cA6\u0002R&\u0019\u00111[2\u0003\u0007%sG/A\u0002hKR$B!!7\u0002`B)1.a7\u0002\u0012%\u0019\u0011Q\\2\u0003\r=\u0003H/[8o\u0011\u0019\t\t\u000f\u0015a\u0001\u007f\u0006\u00191.Z=\u0002\u0013\u001d,Go\u0014:FYN,W\u0003BAt\u0003W$b!!;\u0002p\u0006E\b\u0003BA\n\u0003W$q!!1R\u0005\u0004\ti/\u0005\u0003\u0002\u0012\u0005\u0005\u0002BBAq#\u0002\u0007q\u0010\u0003\u0005\u0002tF#\t\u0019AA{\u0003\u001d!WMZ1vYR\u0004Ra[A|\u0003SL1!!?d\u0005!a$-\u001f8b[\u0016t\u0014!B1qa2LH\u0003BA\t\u0003\u007fDa!!9S\u0001\u0004y\u0018!\u0002\u0013qYV\u001cX\u0003\u0002B\u0003\u0005\u0017!BAa\u0002\u0003\u000eA!q-\u0011B\u0005!\u0011\t\u0019Ba\u0003\u0005\u000f\u0005\u00057K1\u0001\u0002n\"9!qB*A\u0002\tE\u0011AA6w!\u0019Y\u0017qI@\u0003\n\u00059Q\u000f\u001d3bi\u0016$W\u0003\u0002B\f\u0005;!bA!\u0007\u0003 \t\u0005\u0002\u0003B4B\u00057\u0001B!a\u0005\u0003\u001e\u00119\u0011\u0011\u0019+C\u0002\u00055\bBBAq)\u0002\u0007q\u0010C\u0004\u0003$Q\u0003\rAa\u0007\u0002\u000bY\fG.^3\u0002\u0015U\u0004H-\u0019;f/&$\b.\u0006\u0003\u0003*\t=B\u0003\u0003B\u0016\u0005c\u0011\u0019D!\u000e\u0011\t\u001d\f%Q\u0006\t\u0005\u0003'\u0011y\u0003B\u0004\u0002BV\u0013\r!!<\t\r\u0005\u0005X\u000b1\u0001\u0000\u0011\u001d\u0011\u0019#\u0016a\u0001\u0005[Aq!!\u001aV\u0001\u0004\u00119\u0004E\u0005l\u0003\u000f\f\tB!\f\u0003.\u00051A%\\5okN$B!a\r\u0003>!1\u0011\u0011\u001d,A\u0002}\fa\"\\8eS\u001aLxJ\u001d*f[>4X-\u0006\u0003\u0003D\t%C\u0003\u0002B#\u0005\u0017\u0002BaZ!\u0003HA!\u00111\u0003B%\t\u001d\t\tm\u0016b\u0001\u00033Aq!!\u001aX\u0001\u0004\u0011i\u0005\u0005\u0005l\u0003\u000f|\u0018\u0011\u0003B(!\u0015Y\u00171\u001cB$\u0003%)h.[8o/&$\b.\u0006\u0003\u0003V\tmCC\u0002B,\u0005;\u0012\t\u0007\u0005\u0003h\u0003\ne\u0003\u0003BA\n\u00057\"q!!1Y\u0005\u0004\ti\u000fC\u0004\u0003`a\u0003\rAa\u0016\u0002\tQD\u0017\r\u001e\u0005\b\u0003KB\u0006\u0019\u0001B2!)Y'QM@\u0003Z\te#\u0011L\u0005\u0004\u0005O\u001a'!\u0003$v]\u000e$\u0018n\u001c84\u0003AIg\u000e^3sg\u0016\u001cG/[8o/&$\b.\u0006\u0004\u0003n\tu$1\u000f\u000b\u0007\u0005_\u00129Ha \u0011\t\u001d\f%\u0011\u000f\t\u0005\u0003'\u0011\u0019\bB\u0004\u0003ve\u0013\r!!\u0007\u0003\u0003ICqAa\u0018Z\u0001\u0004\u0011I\b\u0005\u0003h\u0003\nm\u0004\u0003BA\n\u0005{\"q!!1Z\u0005\u0004\tI\u0002C\u0004\u0002fe\u0003\rA!!\u0011\u0015-\u0014)g`A\t\u0005w\u0012\t(\u0001\u0007j]R,'o]3di&|g.\u0006\u0003\u0003\b\n=E\u0003BA\u001a\u0005\u0013CqAa\u0018[\u0001\u0004\u0011Y\t\u0005\u0003h\u0003\n5\u0005\u0003BA\n\u0005\u001f#qA!\u001e[\u0005\u0004\tI\"\u0001\u0006%a2,8\u000f\n9mkN,BA!&\u0003\u001cR!!q\u0013BO!\u00119\u0017I!'\u0011\t\u0005M!1\u0014\u0003\b\u0003\u0003\\&\u0019AAw\u0011\u001d\u0011yf\u0017a\u0001\u0005/\u000b\u0001BZ5sgR\\U-_\u000b\u0002\u007f\"\u001aAL!*\u0011\t\t\u001d&QV\u0007\u0003\u0005SS1Aa+d\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0005_\u0013IKA\u0004uC&d'/Z2\u0002\u000f1\f7\u000f^&fs\"\u001aQL!**\t\u00053\u0013\"\u0005\u0002\u0004\u0005&tW\u0003\u0002B^\u0005\u0003\u001crA\nB_\u0005\u0007\u0014I\r\u0005\u0003h\u0003\n}\u0006\u0003BA\n\u0005\u0003$\u0001\"a\u0006'\t\u000b\u0007\u0011\u0011\u0004\t\u0004W\n\u0015\u0017b\u0001BdG\n9\u0001K]8ek\u000e$\bcA6\u0003L&\u0019!QZ2\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\rA\u0014XMZ5y\u0003\u001d\u0001(/\u001a4jq\u0002\nA!\\1tW\u0006)Q.Y:lA\u0005!A.\u001a4u+\t\u0011i,A\u0003mK\u001a$\b%A\u0003sS\u001eDG/\u0001\u0004sS\u001eDG\u000f\t\u000b\u000b\u0005G\u00149O!;\u0003l\n5\b#\u0002BsM\t}V\"A\u0001\t\r\t=w\u00061\u0001\u0000\u0011\u0019\u0011\u0019n\fa\u0001\u007f\"9!q[\u0018A\u0002\tu\u0006b\u0002Bo_\u0001\u0007!QX\u0001\u0004E&tW\u0003\u0002Bz\u0005s$bA!>\u0003|\nu\b\u0003B4B\u0005o\u0004B!a\u0005\u0003z\u00129\u0011\u0011\u0019\u0019C\u0002\u0005e\u0001b\u0002Bla\u0001\u0007!Q\u001f\u0005\b\u0005;\u0004\u0004\u0019\u0001B{\u0003\u0011\u0019w\u000e]=\u0016\t\r\r1\u0011\u0002\u000b\u000b\u0007\u000b\u0019Ya!\u0004\u0004\u0010\rM\u0001#\u0002BsM\r\u001d\u0001\u0003BA\n\u0007\u0013!q!a\u00062\u0005\u0004\tI\u0002\u0003\u0005\u0003PF\u0002\n\u00111\u0001\u0000\u0011!\u0011\u0019.\rI\u0001\u0002\u0004y\b\"\u0003BlcA\u0005\t\u0019AB\t!\u00119\u0017ia\u0002\t\u0013\tu\u0017\u0007%AA\u0002\rE\u0011AD2paf$C-\u001a4bk2$H%M\u000b\u0005\u00073\u0019Y#\u0006\u0002\u0004\u001c)\u001aqp!\b,\u0005\r}\u0001\u0003BB\u0011\u0007Oi!aa\t\u000b\t\r\u0015\"\u0011V\u0001\nk:\u001c\u0007.Z2lK\u0012LAa!\u000b\u0004$\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u000f\u0005]!G1\u0001\u0002\u001a\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012T\u0003BB\r\u0007c!q!a\u00064\u0005\u0004\tI\"\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u001a\u0016\t\r]21H\u000b\u0003\u0007sQCA!0\u0004\u001e\u00119\u0011q\u0003\u001bC\u0002\u0005e\u0011AD2paf$C-\u001a4bk2$H\u0005N\u000b\u0005\u0007o\u0019\t\u0005B\u0004\u0002\u0018U\u0012\r!!\u0007\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y\u00031\u0001(o\u001c3vGR\f%/\u001b;z\u00039\u0001(o\u001c3vGR,E.Z7f]R$B!!\t\u0004L!I1Q\n\u001d\u0002\u0002\u0003\u0007\u0011qZ\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\rM\u0003CBA)\u0003'\n\tCA\u0002OS2\u001cr!CB-\u0005\u0007\u0014I\r\u0005\u0003h\u0003\u0006mACAB/!\r\u0011)/C\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005\u001d61\r\u0005\b\u0005?Z\u0001\u0019AA\u0011)\u0011\t\tca\u001a\t\u0013\r5c\"!AA\u0002\u0005=\u0017a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"a!\u001c\u0011\t\u0005U5qN\u0005\u0005\u0007c\n9J\u0001\u0004PE*,7\r\u001e\u0002\u0004)&\u0004X\u0003BB<\u0007{\u001ar!EB=\u0005\u0007\u0014I\r\u0005\u0003h\u0003\u000em\u0004\u0003BA\n\u0007{\"\u0001\"a\u0006\u0012\t\u000b\u0007\u0011\u0011D\u0001\u0005W\u0016L\b%\u0006\u0002\u0004|\u00051a/\u00197vK\u0002\"baa\"\u0004\n\u000e-\u0005#\u0002Bs#\rm\u0004BBAq-\u0001\u0007q\u0010C\u0004\u0003$Y\u0001\raa\u001f\u0002\u0013]LG\u000f\u001b,bYV,W\u0003BBI\u00073#Baa%\u0004\u001cB)1QS\t\u0004\u0018:\u0011q\r\u0001\t\u0005\u0003'\u0019I\nB\u0004\u0002B^\u0011\r!!\u0007\t\u000f\ruu\u00031\u0001\u0004\u0018\u0006\t1/\u0006\u0003\u0004\"\u000e\u001dFCBBR\u0007S\u001bY\u000bE\u0003\u0003fF\u0019)\u000b\u0005\u0003\u0002\u0014\r\u001dFaBA\f1\t\u0007\u0011\u0011\u0004\u0005\t\u0003CD\u0002\u0013!a\u0001\u007f\"I!1\u0005\r\u0011\u0002\u0003\u00071QU\u000b\u0005\u00073\u0019y\u000bB\u0004\u0002\u0018e\u0011\r!!\u0007\u0016\t\rM6qW\u000b\u0003\u0007kSCaa\u001f\u0004\u001e\u00119\u0011q\u0003\u000eC\u0002\u0005eA\u0003BA\u0011\u0007wC\u0011b!\u0014\u001e\u0003\u0003\u0005\r!a4\u0011\t\u0005M1q\u0018\u0003\b\u0007\u0003\u001c!\u0019AA\r\u0005\u0005\t\u0005CB6\u0002H}\u001c)\r\u0005\u0003\u0002\u0014\r\u001dGaBBe\u0007\t\u0007\u0011\u0011\u0004\u0002\u0002\u0005B!q-QBc\u0003-\u0011V-^:bE2,7I\u0011$\u0013\u000b\rE'n!6\u0007\r\rMG\u0001ABh\u00051a$/\u001a4j]\u0016lWM\u001c;?!!!xoa6\u0004Z\u000e]\u0007\u0003B4B\u0003C\u0001ba[A$\u007f\u0006\u0005R\u0003BBo\u0007G,\"aa8\u0011\t\u001d\f5\u0011\u001d\t\u0005\u0003'\u0019\u0019\u000fB\u0004\u0002\u0018\u0015\u0011\r!!\u0007\u0002\u0013MLgn\u001a7fi>tW\u0003BBu\u0007_$baa;\u0004r\u000eM\b\u0003B4B\u0007[\u0004B!a\u0005\u0004p\u00129\u0011q\u0003\u0004C\u0002\u0005e\u0001BBAq\r\u0001\u0007q\u0010C\u0004\u0003$\u0019\u0001\ra!<\u0016\t\r]8Q \u000b\u0005\u0007s\u001cy\u0010\u0005\u0003h\u0003\u000em\b\u0003BA\n\u0007{$q!a\u0006\b\u0005\u0004\tI\u0002C\u0004\u0005\u0002\u001d\u0001\r\u0001b\u0001\u0002\u000b\u0015dW-\\:\u0011\u000b-$)\u0001\"\u0003\n\u0007\u0011\u001d1M\u0001\u0006=e\u0016\u0004X-\u0019;fIz\u0002ba[A$\u007f\u000em\u0018a\u0001(jY\u0006\u0019A+\u001b9\u0011\u0007\t\u0015\be\u0005\u0003!U\n%GC\u0001C\b\u0003!!xn\u0015;sS:<GCAAJ+\u0011!Y\u0002\"\t\u0015\r\u0011uA1\u0005C\u0013!\u0015\u0011)/\u0005C\u0010!\u0011\t\u0019\u0002\"\t\u0005\u000f\u0005]1E1\u0001\u0002\u001a!1\u0011\u0011]\u0012A\u0002}DqAa\t$\u0001\u0004!y\"A\u0004v]\u0006\u0004\b\u000f\\=\u0016\t\u0011-B1\u0007\u000b\u0005\t[!)\u0004E\u0003l\u00037$y\u0003\u0005\u0004l\u0003\u000fzH\u0011\u0007\t\u0005\u0003'!\u0019\u0004B\u0004\u0002\u0018\u0011\u0012\r!!\u0007\t\u0013\u0011]B%!AA\u0002\u0011e\u0012a\u0001=%aA)!Q]\t\u00052\u0005\u0019!)\u001b8\u0011\u0007\t\u00158h\u0005\u0003<U\n%GC\u0001C\u001f+\u0011!)\u0005b\u0013\u0015\u0015\u0011\u001dCQ\nC(\t#\")\u0006E\u0003\u0003f\u001a\"I\u0005\u0005\u0003\u0002\u0014\u0011-CaBA\f}\t\u0007\u0011\u0011\u0004\u0005\u0007\u0005\u001ft\u0004\u0019A@\t\r\tMg\b1\u0001\u0000\u0011\u001d\u00119N\u0010a\u0001\t'\u0002BaZ!\u0005J!9!Q\u001c A\u0002\u0011MS\u0003\u0002C-\tO\"B\u0001b\u0017\u0005jA)1.a7\u0005^AI1\u000eb\u0018\u0000\u007f\u0012\rD1M\u0005\u0004\tC\u001a'A\u0002+va2,G\u0007\u0005\u0003h\u0003\u0012\u0015\u0004\u0003BA\n\tO\"q!a\u0006@\u0005\u0004\tI\u0002C\u0005\u00058}\n\t\u00111\u0001\u0005lA)!Q\u001d\u0014\u0005f\u0001")
public abstract class LongMap<T>
extends AbstractMap<Object, T> {
    public static <T> LongMap<T> singleton(long l, T t) {
        return LongMap$.MODULE$.singleton(l, t);
    }

    public static <A, B> CanBuildFrom<LongMap<A>, Tuple2<Object, B>, LongMap<B>> canBuildFrom() {
        return LongMap$.MODULE$.canBuildFrom();
    }

    @Override
    public LongMap<T> empty() {
        return LongMap$Nil$.MODULE$;
    }

    @Override
    public List<Tuple2<Object, T>> toList() {
        ListBuffer buffer = new ListBuffer();
        this.foreach((Function1)(Function1<Tuple2, ListBuffer> & java.io.Serializable & Serializable)x$1 -> buffer.$plus$eq(x$1));
        return buffer.toList();
    }

    @Override
    public Iterator<Tuple2<Object, T>> iterator() {
        Iterator<Nothing$> iterator2 = ((Object)LongMap$Nil$.MODULE$).equals(this) ? Iterator$.MODULE$.empty() : new LongMapEntryIterator(this);
        return iterator2;
    }

    @Override
    public final <U> void foreach(Function1<Tuple2<Object, T>, U> f) {
        while (this_ instanceof Bin) {
            Bin bin = (Bin)this_;
            LongMap<T> left = bin.left();
            LongMap right = bin.right();
            left.foreach(f);
            LongMap this_ = right;
        }
        if (this_ instanceof Tip) {
            Tip tip = (Tip)this_;
            long key = tip.key();
            Object value = tip.value();
            f.apply(new Tuple2(BoxesRunTime.boxToLong(key), value));
            return;
        }
        if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
            return;
        }
        throw new MatchError(this_);
    }

    @Override
    public Iterator<Object> keysIterator() {
        Iterator<Object> iterator2 = ((Object)LongMap$Nil$.MODULE$).equals(this) ? Iterator$.MODULE$.empty() : new LongMapKeyIterator(this);
        return iterator2;
    }

    public final void foreachKey(Function1<Object, BoxedUnit> f) {
        while (this_ instanceof Bin) {
            Bin bin = (Bin)this_;
            LongMap left = bin.left();
            LongMap right = bin.right();
            left.foreachKey(f);
            LongMap this_ = right;
        }
        if (this_ instanceof Tip) {
            long key = ((Tip)this_).key();
            f.apply$mcVJ$sp(key);
            return;
        }
        if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
            return;
        }
        throw new MatchError(this_);
    }

    @Override
    public Iterator<T> valuesIterator() {
        Iterator<Nothing$> iterator2 = ((Object)LongMap$Nil$.MODULE$).equals(this) ? Iterator$.MODULE$.empty() : new LongMapValueIterator<Nothing$>(this);
        return iterator2;
    }

    public final void foreachValue(Function1<T, BoxedUnit> f) {
        while (this_ instanceof Bin) {
            Bin bin = (Bin)this_;
            LongMap<T> left = bin.left();
            LongMap right = bin.right();
            left.foreachValue(f);
            LongMap this_ = right;
        }
        if (this_ instanceof Tip) {
            Object value = ((Tip)this_).value();
            f.apply(value);
            return;
        }
        if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
            return;
        }
        throw new MatchError(this_);
    }

    @Override
    public String stringPrefix() {
        return "LongMap";
    }

    @Override
    public boolean isEmpty() {
        return ((Object)this).equals(LongMap$Nil$.MODULE$);
    }

    @Override
    public LongMap<T> filter(Function1<Tuple2<Object, T>, Object> f) {
        LongMap longMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            long prefix = bin.prefix();
            long mask = bin.mask();
            LongMap left = bin.left();
            LongMap right = bin.right();
            Object object = right.filter((Function1)f);
            Object object2 = left.filter((Function1)f);
            Object object3 = object;
            Object newleft = object2;
            Object newright = object3;
            longMap = left == newleft && right == newright ? this : LongMapUtils$.MODULE$.bin(prefix, mask, newleft, newright);
        } else if (this instanceof Tip) {
            Tip tip = (Tip)this;
            long key = tip.key();
            Object value = tip.value();
            longMap = BoxesRunTime.unboxToBoolean(f.apply(new Tuple2(BoxesRunTime.boxToLong(key), value))) ? this : LongMap$Nil$.MODULE$;
        } else if (((Object)LongMap$Nil$.MODULE$).equals(this)) {
            longMap = LongMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return longMap;
    }

    public <S> LongMap<S> transform(Function2<Object, T, S> f) {
        LongMap longMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            LongMap<T> left = bin.left();
            LongMap<T> right = bin.right();
            longMap = bin.bin(left.transform(f), right.transform(f));
        } else if (this instanceof Tip) {
            Tip tip = (Tip)this;
            long key = tip.key();
            Object value = tip.value();
            longMap = tip.withValue(f.apply(BoxesRunTime.boxToLong(key), value));
        } else if (((Object)LongMap$Nil$.MODULE$).equals(this)) {
            longMap = LongMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return longMap;
    }

    @Override
    public final int size() {
        int n;
        if (((Object)LongMap$Nil$.MODULE$).equals(this)) {
            n = 0;
        } else if (this instanceof Tip) {
            n = 1;
        } else if (this instanceof Bin) {
            Bin bin = (Bin)this;
            LongMap left = bin.left();
            LongMap right = bin.right();
            n = left.size() + right.size();
        } else {
            throw new MatchError(this);
        }
        return n;
    }

    @Override
    public final Option<T> get(long key) {
        None$ none$;
        while (this_ instanceof Bin) {
            LongMap this_;
            Bin bin = (Bin)this_;
            long mask = bin.mask();
            LongMap left = bin.left();
            LongMap right = bin.right();
            if (LongMapUtils$.MODULE$.zero(key, mask)) {
                this_ = left;
                continue;
            }
            this_ = right;
        }
        if (this_ instanceof Tip) {
            Tip tip = (Tip)this_;
            long key2 = tip.key();
            Object value = tip.value();
            none$ = key == key2 ? new Some(value) : None$.MODULE$;
        } else if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
            none$ = None$.MODULE$;
        } else {
            throw new MatchError(this_);
        }
        return none$;
    }

    @Override
    public final <S> S getOrElse(long key, Function0<S> function0) {
        Object object;
        block4: {
            while (true) {
                LongMap this_;
                if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
                    object = function0.apply();
                    break block4;
                }
                if (this_ instanceof Tip) {
                    Tip tip = (Tip)this_;
                    long key2 = tip.key();
                    Object value = tip.value();
                    object = key == key2 ? value : function0.apply();
                    break block4;
                }
                if (!(this_ instanceof Bin)) break;
                Bin bin = (Bin)this_;
                long mask = bin.mask();
                LongMap left = bin.left();
                LongMap right = bin.right();
                if (LongMapUtils$.MODULE$.zero(key, mask)) {
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
    public final T apply(long key) {
        Object t;
        while (this_ instanceof Bin) {
            LongMap this_;
            Bin bin = (Bin)this_;
            long mask = bin.mask();
            LongMap left = bin.left();
            LongMap right = bin.right();
            if (LongMapUtils$.MODULE$.zero(key, mask)) {
                this_ = left;
                continue;
            }
            this_ = right;
        }
        if (this_ instanceof Tip) {
            Tip tip = (Tip)this_;
            long key2 = tip.key();
            t = tip.value();
            if (key != key2) {
                throw package$.MODULE$.error("Key not found");
            }
        } else {
            if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
                throw package$.MODULE$.error("key not found");
            }
            throw new MatchError(this_);
        }
        return t;
    }

    public <S> LongMap<S> $plus(Tuple2<Object, S> kv) {
        return this.updated(kv._1$mcJ$sp(), kv._2());
    }

    public <S> LongMap<S> updated(long key, S value) {
        LongMap longMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            long prefix = bin.prefix();
            long mask = bin.mask();
            LongMap left = bin.left();
            LongMap right = bin.right();
            longMap = !LongMapUtils$.MODULE$.hasMatch(key, prefix, mask) ? LongMapUtils$.MODULE$.join(key, new Tip<S>(key, value), prefix, this) : (LongMapUtils$.MODULE$.zero(key, mask) ? new Bin<S>(prefix, mask, left.updated(key, value), right) : new Bin(prefix, mask, left, right.updated(key, value)));
        } else if (this instanceof Tip) {
            long key2 = ((Tip)this).key();
            longMap = key == key2 ? new Tip<S>(key, value) : LongMapUtils$.MODULE$.join(key, new Tip<S>(key, value), key2, this);
        } else if (((Object)LongMap$Nil$.MODULE$).equals(this)) {
            longMap = new Tip<S>(key, value);
        } else {
            throw new MatchError(this);
        }
        return longMap;
    }

    public <S> LongMap<S> updateWith(long key, S value, Function2<T, S, S> f) {
        LongMap longMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            long prefix = bin.prefix();
            long mask = bin.mask();
            LongMap<T> left = bin.left();
            LongMap<T> right = bin.right();
            longMap = !LongMapUtils$.MODULE$.hasMatch(key, prefix, mask) ? LongMapUtils$.MODULE$.join(key, new Tip<S>(key, value), prefix, this) : (LongMapUtils$.MODULE$.zero(key, mask) ? new Bin<S>(prefix, mask, left.updateWith(key, value, f), right) : new Bin(prefix, mask, left, right.updateWith(key, value, f)));
        } else if (this instanceof Tip) {
            Tip tip = (Tip)this;
            long key2 = tip.key();
            Object value2 = tip.value();
            longMap = key == key2 ? new Tip<S>(key, f.apply(value2, value)) : LongMapUtils$.MODULE$.join(key, new Tip<S>(key, value), key2, this);
        } else if (((Object)LongMap$Nil$.MODULE$).equals(this)) {
            longMap = new Tip<S>(key, value);
        } else {
            throw new MatchError(this);
        }
        return longMap;
    }

    @Override
    public LongMap<T> $minus(long key) {
        LongMap longMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)this;
            long prefix = bin.prefix();
            long mask = bin.mask();
            LongMap left = bin.left();
            LongMap right = bin.right();
            longMap = !LongMapUtils$.MODULE$.hasMatch(key, prefix, mask) ? this : (LongMapUtils$.MODULE$.zero(key, mask) ? LongMapUtils$.MODULE$.bin(prefix, mask, left.$minus(key), right) : LongMapUtils$.MODULE$.bin(prefix, mask, left, right.$minus(key)));
        } else if (this instanceof Tip) {
            long key2 = ((Tip)this).key();
            longMap = key == key2 ? LongMap$Nil$.MODULE$ : this;
        } else if (((Object)LongMap$Nil$.MODULE$).equals(this)) {
            longMap = LongMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return longMap;
    }

    public <S> LongMap<S> modifyOrRemove(Function2<Object, T, Option<S>> f) {
        LongMap longMap;
        if (this instanceof Bin) {
            Bin bin = (Bin)((Object)this);
            long prefix = bin.prefix();
            long mask = bin.mask();
            LongMap<T> left = bin.left();
            LongMap<T> right = bin.right();
            LongMap<S> newleft = left.modifyOrRemove(f);
            LongMap<S> newright = right.modifyOrRemove(f);
            longMap = left == newleft && right == newright ? this : LongMapUtils$.MODULE$.bin(prefix, mask, newleft, newright);
        } else if (this instanceof Tip) {
            LongMap longMap2;
            Tip tip = this;
            long key = tip.key();
            Object value = tip.value();
            Option<S> option = f.apply(BoxesRunTime.boxToLong(key), value);
            if (None$.MODULE$.equals(option)) {
                longMap2 = LongMap$Nil$.MODULE$;
            } else if (option instanceof Some) {
                Object value2 = ((Some)option).value();
                longMap2 = value == value2 ? this : new Tip(key, value2);
            } else {
                throw new MatchError(option);
            }
            longMap = longMap2;
        } else if (((Object)LongMap$Nil$.MODULE$).equals(this)) {
            longMap = LongMap$Nil$.MODULE$;
        } else {
            throw new MatchError(this);
        }
        return longMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public <S> LongMap<S> unionWith(LongMap<S> that, Function3<Object, S, S, S> f) {
        Tuple2<LongMap, LongMap> tuple2 = new Tuple2<LongMap, LongMap>(this, that);
        LongMap longMap = this;
        LongMap that2 = that;
        if (longMap instanceof Bin) {
            Bin bin = (Bin)longMap;
            long p1 = bin.prefix();
            long m1 = bin.mask();
            LongMap l1 = bin.left();
            LongMap r1 = bin.right();
            if (that2 instanceof Bin) {
                Bin bin2 = (Bin)that2;
                long p2 = bin2.prefix();
                long m2 = bin2.mask();
                LongMap l2 = bin2.left();
                LongMap r2 = bin2.right();
                return LongMapUtils$.MODULE$.shorter(m1, m2) ? (!LongMapUtils$.MODULE$.hasMatch(p2, p1, m1) ? LongMapUtils$.MODULE$.join(p1, this, p2, bin2) : (LongMapUtils$.MODULE$.zero(p2, m1) ? new Bin<S>(p1, m1, l1.unionWith(bin2, f), r1) : new Bin(p1, m1, l1, r1.unionWith(bin2, f)))) : (LongMapUtils$.MODULE$.shorter(m2, m1) ? (!LongMapUtils$.MODULE$.hasMatch(p1, p2, m2) ? LongMapUtils$.MODULE$.join(p1, this, p2, bin2) : (LongMapUtils$.MODULE$.zero(p1, m2) ? new Bin(p2, m2, this.unionWith(l2, f), r2) : new Bin(p2, m2, l2, this.unionWith(r2, f)))) : (p1 == p2 ? new Bin(p1, m1, l1.unionWith(l2, f), r1.unionWith(r2, f)) : LongMapUtils$.MODULE$.join(p1, this, p2, bin2)));
            }
        }
        LongMap longMap2 = this;
        LongMap x2 = that;
        if (longMap2 instanceof Tip) {
            Tip tip = (Tip)longMap2;
            long key = tip.key();
            Object value = tip.value();
            return x2.updateWith(key, value, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> f.apply(BoxesRunTime.boxToLong(key), y, x));
        }
        if (tuple2 != null) {
            LongMap x3 = this;
            LongMap longMap3 = that;
            if (longMap3 instanceof Tip) {
                Tip tip = (Tip)longMap3;
                long key = tip.key();
                Object value = tip.value();
                return x3.updateWith(key, value, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x, y) -> f.apply(BoxesRunTime.boxToLong(key), x, y));
            }
        }
        if (tuple2 != null) {
            LongMap longMap4 = this;
            LongMap x4 = that;
            if (((Object)LongMap$Nil$.MODULE$).equals(longMap4)) {
                return x4;
            }
        }
        if (tuple2 == null) throw new MatchError(tuple2);
        LongMap x5 = this;
        LongMap longMap5 = that;
        if (!((Object)LongMap$Nil$.MODULE$).equals(longMap5)) throw new MatchError(tuple2);
        return x5;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public <S, R> LongMap<R> intersectionWith(LongMap<S> that, Function3<Object, T, S, R> f) {
        LongMap<S> longMap;
        Tuple2<LongMap, LongMap<S>> tuple2 = new Tuple2<LongMap, LongMap<S>>(this, that);
        LongMap longMap2 = this;
        LongMap<S> that2 = that;
        if (longMap2 instanceof Bin) {
            Bin bin = (Bin)longMap2;
            long p1 = bin.prefix();
            long m1 = bin.mask();
            LongMap<T> l1 = bin.left();
            LongMap<T> r1 = bin.right();
            if (that2 instanceof Bin) {
                Bin bin2 = (Bin)that2;
                long p2 = bin2.prefix();
                long m2 = bin2.mask();
                LongMap l2 = bin2.left();
                LongMap r2 = bin2.right();
                return LongMapUtils$.MODULE$.shorter(m1, m2) ? (!LongMapUtils$.MODULE$.hasMatch(p2, p1, m1) ? LongMap$Nil$.MODULE$ : (LongMapUtils$.MODULE$.zero(p2, m1) ? l1.intersectionWith(bin2, f) : r1.intersectionWith(bin2, f))) : (m1 == m2 ? LongMapUtils$.MODULE$.bin(p1, m1, l1.intersectionWith(l2, f), r1.intersectionWith(r2, f)) : (!LongMapUtils$.MODULE$.hasMatch(p1, p2, m2) ? LongMap$Nil$.MODULE$ : (LongMapUtils$.MODULE$.zero(p1, m2) ? this.intersectionWith(l2, f) : this.intersectionWith(r2, f))));
            }
        }
        LongMap longMap3 = this;
        LongMap<S> that3 = that;
        if (longMap3 instanceof Tip) {
            void var5_25;
            Tip tip = (Tip)longMap3;
            long key = tip.key();
            Object value = tip.value();
            Option<S> option = that3.get(key);
            if (None$.MODULE$.equals(option)) {
                LongMap$Nil$ longMap$Nil$ = LongMap$Nil$.MODULE$;
                return var5_25;
            } else {
                if (!(option instanceof Some)) throw new MatchError(option);
                Object value2 = ((Some)option).value();
                Tip<R> tip2 = new Tip<R>(key, f.apply(BoxesRunTime.boxToLong(key), value, value2));
            }
            return var5_25;
        }
        if (tuple2 != null && (longMap = that) instanceof Tip) {
            void var4_34;
            Tip tip = (Tip)longMap;
            long key = tip.key();
            Object value = tip.value();
            Option<T> option = this.get(key);
            if (None$.MODULE$.equals(option)) {
                LongMap$Nil$ longMap$Nil$ = LongMap$Nil$.MODULE$;
                return var4_34;
            } else {
                if (!(option instanceof Some)) throw new MatchError(option);
                Object value2 = ((Some)option).value();
                Tip<R> tip3 = new Tip<R>(key, f.apply(BoxesRunTime.boxToLong(key), value2, value));
            }
            return var4_34;
        }
        if (tuple2 == null) throw new MatchError((Object)null);
        return LongMap$Nil$.MODULE$;
    }

    public <R> LongMap<T> intersection(LongMap<R> that) {
        return this.intersectionWith(that, (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(key, value, value2) -> value);
    }

    public <S> LongMap<S> $plus$plus(LongMap<S> that) {
        return this.unionWith(that, (Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(key, x, y) -> y);
    }

    public final long firstKey() {
        while (this_ instanceof Bin) {
            LongMap this_ = ((Bin)this_).left();
        }
        if (!(this_ instanceof Tip)) {
            if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
                throw package$.MODULE$.error("Empty set");
            }
            throw new MatchError(this_);
        }
        long l = ((Tip)this_).key();
        return l;
    }

    public final long lastKey() {
        while (this_ instanceof Bin) {
            LongMap this_ = ((Bin)this_).right();
        }
        if (!(this_ instanceof Tip)) {
            if (((Object)LongMap$Nil$.MODULE$).equals(this_)) {
                throw package$.MODULE$.error("Empty set");
            }
            throw new MatchError(this_);
        }
        long l = ((Tip)this_).key();
        return l;
    }

    public static class Bin<T>
    extends LongMap<T>
    implements Product,
    Serializable {
        private final long prefix;
        private final long mask;
        private final LongMap<T> left;
        private final LongMap<T> right;

        public long prefix() {
            return this.prefix;
        }

        public long mask() {
            return this.mask;
        }

        public LongMap<T> left() {
            return this.left;
        }

        public LongMap<T> right() {
            return this.right;
        }

        public <S> LongMap<S> bin(LongMap<S> left, LongMap<S> right) {
            if (this.left() == left && this.right() == right) {
                return this;
            }
            return new Bin<S>(this.prefix(), this.mask(), left, right);
        }

        public <T> Bin<T> copy(long prefix, long mask, LongMap<T> left, LongMap<T> right) {
            return new Bin<T>(prefix, mask, left, right);
        }

        public <T> long copy$default$1() {
            return this.prefix();
        }

        public <T> long copy$default$2() {
            return this.mask();
        }

        public <T> LongMap<T> copy$default$3() {
            return this.left();
        }

        public <T> LongMap<T> copy$default$4() {
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
                    return BoxesRunTime.boxToLong(this.prefix());
                }
                case 1: {
                    return BoxesRunTime.boxToLong(this.mask());
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

        public Bin(long prefix, long mask, LongMap<T> left, LongMap<T> right) {
            this.prefix = prefix;
            this.mask = mask;
            this.left = left;
            this.right = right;
            Product.$init$(this);
        }
    }

    public static class Tip<T>
    extends LongMap<T>
    implements Product,
    Serializable {
        private final long key;
        private final T value;

        public long key() {
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

        public <T> Tip<T> copy(long key, T value) {
            return new Tip<T>(key, value);
        }

        public <T> long copy$default$1() {
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
                    return BoxesRunTime.boxToLong(this.key());
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

        public Tip(long key, T value) {
            this.key = key;
            this.value = value;
            Product.$init$(this);
        }
    }
}

