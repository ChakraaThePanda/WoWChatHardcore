/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.TraversableOnce;
import scala.collection.TraversableOnce$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.Iterable;
import scala.collection.mutable.Buffer;
import scala.concurrent.Awaitable;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future$;
import scala.concurrent.Future$InternalCallbackExecutor$;
import scala.concurrent.Promise;
import scala.concurrent.Promise$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;
import scala.util.Try$;
import scala.util.control.NonFatal$;

@ScalaSignature(bytes="\u0006\u0001\u001dmfaB(Q!\u0003\r\t!\u0016\u0005\u0006U\u0002!\ta\u001b\u0005\u0006_\u0002!\t\u0001\u001d\u0005\b\u0003#\u0001A\u0011AA\n\u0011\u001d\t)\n\u0001D\u0001\u0003/Cq!!5\u0001\r\u0003\t\u0019\u000eC\u0004\u0002\\\u00021\t!!8\t\u000f\u0005\u0015\b\u0001\"\u0001\u0002h\"9\u00111\u001e\u0001\u0005\u0002\u00055\bbBA\u007f\u0001\u0011\u0005\u0011q \u0005\b\u0003{\u0004a\u0011\u0001B\r\u0011\u001d\u0011i\u0003\u0001D\u0001\u0005_AqA!\u0011\u0001\t\u0003\u0011\u0019\u0005C\u0004\u0003V\u0001!\tAa\u0016\t\u000f\t%\u0004\u0001\"\u0001\u0003l!9!q\u0010\u0001\u0005\u0002\t\u0005\u0005b\u0002BT\u0001\u0011\u0015!\u0011\u0016\u0005\b\u0005c\u0003A\u0011\u0001BZ\u0011\u001d\u0011)\r\u0001C\u0001\u0005\u000fDqAa7\u0001\t\u0003\u0011i\u000eC\u0004\u0003p\u0002!\tA!=\t\u000f\r\u001d\u0001\u0001\"\u0001\u0004\n!911\u0006\u0001\u0005\u0002\r5\u0002bBB\u001d\u0001\u0011\u000511\b\u0005\b\u0007+\u0002A\u0011AB,\u000f\u001d\u00199\u0007\u0015E\u0001\u0007S2aa\u0014)\t\u0002\r-\u0004bBB75\u0011\u00051q\u000e\u0005\u000b\u0007cR\"\u0019!C\u0001!\u000eM\u0004\u0002CBO5\u0001\u0006Ia!\u001e\b\u000f\r%&\u0004#\u0002\u0004,\u001a91q\u0016\u000e\t\u0006\rE\u0006bBB7?\u0011\u00051Q\u0017\u0005\b\u0007o{B\u0011IB]\u0011\u001d\u0019Yp\bC!\u0007{Daa\\\u0010\u0005B\u0011%\u0001bBA\t?\u0011\u0005C\u0011\u0004\u0005\b\u0003+{B\u0011\tC\u0015\u0011\u001d\t\tn\bC!\u0003'Dq!a7 \t\u0003\"Y\u0004C\u0004\u0002f~!\t%a:\t\u000f\u0005-x\u0004\"\u0011\u0005@!9\u0011Q`\u0010\u0005B\u0011=\u0003bBA\u007f?\u0011\u0005C1\r\u0005\b\u0005[yB\u0011\tC<\u0011\u001d\u0011\te\bC!\t\u0013CqA!\u0016 \t\u0003\"Y\nC\u0004\u0003j}!\t\u0005\",\t\u000f\t}t\u0004\"\u0011\u0005<\"9!\u0011W\u0010\u0005B\u0011\u0015\u0007b\u0002Bc?\u0011\u0005Cq\u001b\u0005\b\u00057|B\u0011\tCu\u0011\u001d\u0011yo\bC!\twDqaa\u0002 \t\u0003*Y\u0001C\u0004\u0004,}!\t%b\n\t\u000f\rer\u0004\"\u0011\u00064!91QK\u0010\u0005B\u0015\u0005\u0003bBC)?\u0011\u0005S1\u000b\u0005\n\u000b+R\"\u0019!C\u0001\u000b/B\u0001\"b\u0017\u001bA\u0003%Q\u0011\f\u0005\b\u0003KTB\u0011AC/\u0011\u001d)YG\u0007C\u0001\u000b[Bq!\"\u001f\u001b\t\u0003)Y\bC\u0004\u0002Vi!\t!\"#\t\u000f\u0015e&\u0004\"\u0001\u0006<\"9Q\u0011 \u000e\u0005\u0002\u0015m\bb\u0002D\b5\u0011\u0005a\u0011\u0003\u0005\b\r\u001fQB\u0011\u0001D2\u0011\u001d1\u0019I\u0007C\u0001\r\u000bC\u0001Bb+\u001bA\u0013%aQ\u0016\u0005\b\r'TB\u0011\u0001Dk\u0011\u001d9)B\u0007C\u0001\u000f/Aqa\"\u0010\u001b\t\u00039y\u0004C\u0004\b`i!\ta\"\u0019\b\u0011\u001dU%\u0004#\u0001Q\u000f/3\u0001b\"'\u001b\u0011\u0003\u0001v1\u0014\u0005\b\u0007[ZE\u0011ADR\u0011\u001d9)k\u0013C)\u000fOCqab-L\t\u0003:)L\u0001\u0004GkR,(/\u001a\u0006\u0003#J\u000b!bY8oGV\u0014(/\u001a8u\u0015\u0005\u0019\u0016!B:dC2\f7\u0001A\u000b\u0003-\u0006\u001c2\u0001A,\\!\tA\u0016,D\u0001S\u0013\tQ&K\u0001\u0004B]f\u0014VM\u001a\t\u00049v{V\"\u0001)\n\u0005y\u0003&!C!xC&$\u0018M\u00197f!\t\u0001\u0017\r\u0004\u0001\u0005\r\t\u0004AQ1\u0001d\u0005\u0005!\u0016C\u00013h!\tAV-\u0003\u0002g%\n9aj\u001c;iS:<\u0007C\u0001-i\u0013\tI'KA\u0002B]f\fa\u0001J5oSR$C#\u00017\u0011\u0005ak\u0017B\u00018S\u0005\u0011)f.\u001b;\u0002\u0013=t7+^2dKN\u001cXCA9\u007f)\t\u0011\b\u0010\u0006\u0002mg\")AO\u0001a\u0002k\u0006AQ\r_3dkR|'\u000f\u0005\u0002]m&\u0011q\u000f\u0015\u0002\u0011\u000bb,7-\u001e;j_:\u001cuN\u001c;fqRDQ!\u001f\u0002A\u0002i\f!\u0001\u001d4\u0011\ta[x,`\u0005\u0003yJ\u0013q\u0002U1si&\fGNR;oGRLwN\u001c\t\u0003Az$Qa \u0002C\u0002\r\u0014\u0011!\u0016\u0015\b\u0005\u0005\r\u0011\u0011BA\u0007!\rA\u0016QA\u0005\u0004\u0003\u000f\u0011&A\u00033faJ,7-\u0019;fI\u0006\u0012\u00111B\u0001hkN,\u0007\u0005\u00194pe\u0016\f7\r\u001b1!_J\u0004\u0003m\u001c8D_6\u0004H.\u001a;fA\u0002Jgn\u001d;fC\u0012\u0004\u0003f[3fa\u0002Jg\u000eI7j]\u0012\u0004C\u000f[1uAQDW-\u001f\u0011uC.,\u0007\u0005^8uC2\u0004#/\u0019;iKJ\u0004C\u000f[1oAA\f'\u000f^5bY\u00022WO\\2uS>t7/K\u0011\u0003\u0003\u001f\taA\r\u00182e9\u0002\u0014!C8o\r\u0006LG.\u001e:f+\u0011\t)\"!\u000f\u0015\t\u0005]\u00111\u0004\u000b\u0004Y\u0006e\u0001\"\u0002;\u0004\u0001\b)\bBB=\u0004\u0001\u0004\ti\u0002\u0005\u0004Yw\u0006}\u0011q\u0007\t\u0005\u0003C\t\tD\u0004\u0003\u0002$\u00055b\u0002BA\u0013\u0003Wi!!a\n\u000b\u0007\u0005%B+\u0001\u0004=e>|GOP\u0005\u0002'&\u0019\u0011q\u0006*\u0002\u000fA\f7m[1hK&!\u00111GA\u001b\u0005%!\u0006N]8xC\ndWMC\u0002\u00020I\u00032\u0001YA\u001d\t\u0015y8A1\u0001dQ!\tY\"!\u0010\u0002D\u0005m\u0004c\u0001-\u0002@%\u0019\u0011\u0011\t*\u0003\u001d\u0011,\u0007O]3dCR,GMT1nKF:q$!\u0012\u0002L\u0005M\u0004c\u0001-\u0002H%\u0019\u0011\u0011\n*\u0003\rMKXNY8mc%\u0019\u0013QJA*\u0003W\n)\u0006\u0006\u0003\u0002F\u0005=\u0003bBA))\u0002\u0007\u00111L\u0001\u0005]\u0006lW-\u0003\u0003\u0002V\u0005]\u0013!B1qa2L(bAA-%\u000611+_7c_2\u0004B!!\u0018\u0002f9!\u0011qLA1!\r\t)CU\u0005\u0004\u0003G\u0012\u0016A\u0002)sK\u0012,g-\u0003\u0003\u0002h\u0005%$AB*ue&twMC\u0002\u0002dI\u000b\u0014bIA7\u0003_\n\t(!\u0017\u000f\t\u0005\r\u0012qN\u0005\u0004\u00033\u0012\u0016G\u0002\u0013\u0002$\u0005-2+M\u0003&\u0003k\n9h\u0004\u0002\u0002x\u0005\u0012\u0011\u0011P\u0001\tG\u0006dGNY1dWFJ1%a\u0017\u0002~\u0005\u0015\u0015qP\u0005\u0005\u0003\u007f\n\t)A\u000e%Y\u0016\u001c8/\u001b8ji\u0012:'/Z1uKJ$C-\u001a4bk2$HE\r\u0006\u0004\u0003\u0007\u0013\u0016A\u00043faJ,7-\u0019;fI:\u000bW.Z\u0019\nG\u0005\u001d\u0015\u0011RAF\u0003\u0007s1\u0001WAE\u0013\r\t\u0019IU\u0019\u0006Ea\u0013\u0016Q\u0012\u0002\u0006g\u000e\fG.\u0019\u0015\b\u0007\u0005\r\u0011\u0011SA\u0007C\t\t\u0019*\u00018vg\u0016\u0004\u0003m\u001c8D_6\u0004H.\u001a;fA\u0002z'\u000f\t1gC&dW\r\u001a\u0018g_J,\u0017m\u00195aA%t7\u000f^3bI\u0002B3.Z3qA%t\u0007%\\5oI\u0002\"\b.\u0019;!i\",\u0017\u0010\t;bW\u0016\u0004Co\u001c;bY\u0002\u0012\u0018\r\u001e5fe\u0002\"\b.\u00198!a\u0006\u0014H/[1mA\u0019,hn\u0019;j_:\u001c\u0018&\u0001\u0006p]\u000e{W\u000e\u001d7fi\u0016,B!!'\u00028R!\u00111TAP)\ra\u0017Q\u0014\u0005\u0006i\u0012\u0001\u001d!\u001e\u0005\b\u0003C#\u0001\u0019AAR\u0003\u00051\u0007c\u0002-\u0002&\u0006%\u0016QW\u0005\u0004\u0003O\u0013&!\u0003$v]\u000e$\u0018n\u001c82!\u0015\tY+!-`\u001b\t\tiKC\u0002\u00020J\u000bA!\u001e;jY&!\u00111WAW\u0005\r!&/\u001f\t\u0004A\u0006]F!B@\u0005\u0005\u0004\u0019\u0007\u0006CAP\u0003{\tY,a32\u000f}\t)%!0\u0002DFJ1%!\u0014\u0002T\u0005}\u0016QK\u0019\nG\u00055\u0014qNAa\u00033\nd\u0001JA\u0012\u0003W\u0019\u0016'B\u0013\u0002F\u0006\u001dwBAAdC\t\tI-\u0001\u0003gk:\u001c\u0017'C\u0012\u0002\\\u0005u\u0014QZA@c%\u0019\u0013qQAE\u0003\u001f\f\u0019)M\u0003#1J\u000bi)A\u0006jg\u000e{W\u000e\u001d7fi\u0016$WCAAk!\rA\u0016q[\u0005\u0004\u00033\u0014&a\u0002\"p_2,\u0017M\\\u0001\u0006m\u0006dW/Z\u000b\u0003\u0003?\u0004R\u0001WAq\u0003SK1!a9S\u0005\u0019y\u0005\u000f^5p]\u00061a-Y5mK\u0012,\"!!;\u0011\tq\u0003\u0011qD\u0001\bM>\u0014X-Y2i+\u0011\ty/a?\u0015\t\u0005E\u0018Q\u001f\u000b\u0004Y\u0006M\b\"\u0002;\t\u0001\b)\bbBAQ\u0011\u0001\u0007\u0011q\u001f\t\u00071\u0006\u0015v,!?\u0011\u0007\u0001\fY\u0010B\u0003\u0000\u0011\t\u00071-A\u0005ue\u0006t7OZ8s[V!!\u0011\u0001B\u0005)\u0019\u0011\u0019Aa\u0004\u0003\u0016Q!!Q\u0001B\u0007!\u0011a\u0006Aa\u0002\u0011\u0007\u0001\u0014I\u0001\u0002\u0004\u0003\f%\u0011\ra\u0019\u0002\u0002'\")A/\u0003a\u0002k\"9!\u0011C\u0005A\u0002\tM\u0011!A:\u0011\ra\u000b)k\u0018B\u0004\u0011\u001d\t\t+\u0003a\u0001\u0005/\u0001r\u0001WAS\u0003?\ty\"\u0006\u0003\u0003\u001c\t\rB\u0003\u0002B\u000f\u0005O!BAa\b\u0003&A!A\f\u0001B\u0011!\r\u0001'1\u0005\u0003\u0007\u0005\u0017Q!\u0019A2\t\u000bQT\u00019A;\t\u000f\u0005\u0005&\u00021\u0001\u0003*A9\u0001,!*\u0002*\n-\u0002CBAV\u0003c\u0013\t#A\u0007ue\u0006t7OZ8s[^KG\u000f[\u000b\u0005\u0005c\u0011I\u0004\u0006\u0003\u00034\tuB\u0003\u0002B\u001b\u0005w\u0001B\u0001\u0018\u0001\u00038A\u0019\u0001M!\u000f\u0005\r\t-1B1\u0001d\u0011\u0015!8\u0002q\u0001v\u0011\u001d\t\tk\u0003a\u0001\u0005\u007f\u0001r\u0001WAS\u0003S\u0013)$A\u0002nCB,BA!\u0012\u0003NQ!!q\tB))\u0011\u0011IEa\u0014\u0011\tq\u0003!1\n\t\u0004A\n5CA\u0002B\u0006\u0019\t\u00071\rC\u0003u\u0019\u0001\u000fQ\u000fC\u0004\u0002\"2\u0001\rAa\u0015\u0011\ra\u000b)k\u0018B&\u0003\u001d1G.\u0019;NCB,BA!\u0017\u0003bQ!!1\fB3)\u0011\u0011iFa\u0019\u0011\tq\u0003!q\f\t\u0004A\n\u0005DA\u0002B\u0006\u001b\t\u00071\rC\u0003u\u001b\u0001\u000fQ\u000fC\u0004\u0002\"6\u0001\rAa\u001a\u0011\ra\u000b)k\u0018B/\u0003\u001d1G.\u0019;uK:,BA!\u001c\u0003tQ!!q\u000eB;!\u0011a\u0006A!\u001d\u0011\u0007\u0001\u0014\u0019\b\u0002\u0004\u0003\f9\u0011\ra\u0019\u0005\b\u0005or\u00019\u0001B=\u0003\t)g\u000fE\u0004\u0002^\tmtLa\u001c\n\t\tu\u0014\u0011\u000e\u0002\u0011I1,7o\u001d\u0013d_2|g\u000e\n7fgN\faAZ5mi\u0016\u0014H\u0003\u0002BB\u0005\u0013#BA!\"\u0003\bB\u0019A\fA0\t\u000bQ|\u00019A;\t\u000f\t-u\u00021\u0001\u0003\u000e\u0006\t\u0001\u000f\u0005\u0004Y\u0003K{\u0016Q\u001b\u0015\t\u0005\u0013\u000biD!%\u0003\"F:q$!\u0012\u0003\u0014\ne\u0015'C\u0012\u0002N\u0005M#QSA+c%\u0019\u0013QNA8\u0005/\u000bI&\r\u0004%\u0003G\tYcU\u0019\u0006K\tm%QT\b\u0003\u0005;\u000b#Aa(\u0002\tA\u0014X\rZ\u0019\nG\u0005m\u0013Q\u0010BR\u0003\u007f\n\u0014bIAD\u0003\u0013\u0013)+a!2\u000b\tB&+!$\u0002\u0015]LG\u000f\u001b$jYR,'\u000f\u0006\u0003\u0003,\n=F\u0003\u0002BC\u0005[CQ\u0001\u001e\tA\u0004UDqAa#\u0011\u0001\u0004\u0011i)A\u0004d_2dWm\u0019;\u0016\t\tU&Q\u0018\u000b\u0005\u0005o\u0013\t\r\u0006\u0003\u0003:\n}\u0006\u0003\u0002/\u0001\u0005w\u00032\u0001\u0019B_\t\u0019\u0011Y!\u0005b\u0001G\")A/\u0005a\u0002k\"1\u00110\u0005a\u0001\u0005\u0007\u0004R\u0001W>`\u0005w\u000bqA]3d_Z,'/\u0006\u0003\u0003J\nEG\u0003\u0002Bf\u0005/$BA!4\u0003VB!A\f\u0001Bh!\r\u0001'\u0011\u001b\u0003\u0007\u007fJ\u0011\rAa5\u0012\u0005};\u0007\"\u0002;\u0013\u0001\b)\bBB=\u0013\u0001\u0004\u0011I\u000e\u0005\u0004Yw\u0006}!qZ\u0001\fe\u0016\u001cwN^3s/&$\b.\u0006\u0003\u0003`\n\u001dH\u0003\u0002Bq\u0005W$BAa9\u0003jB!A\f\u0001Bs!\r\u0001'q\u001d\u0003\u0007\u007fN\u0011\rAa5\t\u000bQ\u001c\u00029A;\t\re\u001c\u0002\u0019\u0001Bw!\u0019A60a\b\u0003d\u0006\u0019!0\u001b9\u0016\t\tM(q \u000b\u0005\u0005k\u001c\t\u0001\u0005\u0003]\u0001\t]\bC\u0002-\u0003z~\u0013i0C\u0002\u0003|J\u0013a\u0001V;qY\u0016\u0014\u0004c\u00011\u0003\u0000\u0012)q\u0010\u0006b\u0001G\"911\u0001\u000bA\u0002\r\u0015\u0011\u0001\u0002;iCR\u0004B\u0001\u0018\u0001\u0003~\u00069!0\u001b9XSRDWCBB\u0006\u0007K\u0019)\u0002\u0006\u0003\u0004\u000e\r\u001dB\u0003BB\b\u00077!Ba!\u0005\u0004\u001aA!A\fAB\n!\r\u00017Q\u0003\u0003\u0007\u0007/)\"\u0019A2\u0003\u0003ICQ\u0001^\u000bA\u0004UDq!!)\u0016\u0001\u0004\u0019i\u0002\u0005\u0005Y\u0007?y61EB\n\u0013\r\u0019\tC\u0015\u0002\n\rVt7\r^5p]J\u00022\u0001YB\u0013\t\u0015yXC1\u0001d\u0011\u001d\u0019\u0019!\u0006a\u0001\u0007S\u0001B\u0001\u0018\u0001\u0004$\u0005Qa-\u00197mE\u0006\u001c7\u000eV8\u0016\t\r=2Q\u0007\u000b\u0005\u0007c\u00199\u0004\u0005\u0003]\u0001\rM\u0002c\u00011\u00046\u00111qP\u0006b\u0001\u0005'Dqaa\u0001\u0017\u0001\u0004\u0019\t$A\u0003nCB$v.\u0006\u0003\u0004>\r\rC\u0003BB \u0007\u000b\u0002B\u0001\u0018\u0001\u0004BA\u0019\u0001ma\u0011\u0005\r\t-qC1\u0001d\u0011\u001d\u00199e\u0006a\u0002\u0007\u0013\n1\u0001^1h!\u0019\u0019Ye!\u0015\u0004B5\u00111Q\n\u0006\u0004\u0007\u001f\u0012\u0016a\u0002:fM2,7\r^\u0005\u0005\u0007'\u001aiE\u0001\u0005DY\u0006\u001c8\u000fV1h\u0003\u001d\tg\u000e\u001a+iK:,Ba!\u0017\u0004fQ!11LB0)\u0011\u0011)i!\u0018\t\u000bQD\u00029A;\t\reD\u0002\u0019AB1!\u0019A60!+\u0004dA\u0019\u0001m!\u001a\u0005\u000b}D\"\u0019A2\u0002\r\u0019+H/\u001e:f!\ta&d\u0005\u0002\u001b/\u00061A(\u001b8jiz\"\"a!\u001b\u0002\u000fQ|'i\u001c=fIV\u00111Q\u000f\t\t\u0007o\u001a\ti!\"\u0004 6\u00111\u0011\u0010\u0006\u0005\u0007w\u001ai(A\u0005j[6,H/\u00192mK*\u00191q\u0010*\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0003\u0004\u0004\u000ee$aA'baB\"1qQBM!\u0019\u0019Iia%\u0004\u00186\u001111\u0012\u0006\u0005\u0007\u001b\u001by)\u0001\u0003mC:<'BABI\u0003\u0011Q\u0017M^1\n\t\rU51\u0012\u0002\u0006\u00072\f7o\u001d\t\u0004A\u000eeEACBN;\u0005\u0005\t\u0011!B\u0001G\n\u0019q\fJ\u0019\u0002\u0011Q|'i\u001c=fI\u0002\u0002Da!)\u0004&B11\u0011RBJ\u0007G\u00032\u0001YBS\t)\u00199+HA\u0001\u0002\u0003\u0015\ta\u0019\u0002\u0004?\u0012\u0012\u0014!\u00028fm\u0016\u0014\bcABW?5\t!DA\u0003oKZ,'o\u0005\u0003 /\u000eM\u0006c\u0001/\u0001IR\u001111V\u0001\u0006e\u0016\fG-\u001f\u000b\u0005\u0007w\u001bI\r\u0006\u0003\u0004>\u000e}V\"A\u0010\t\u000f\r\u0005\u0017\u0005q\u0001\u0004D\u00061\u0001/\u001a:nSR\u00042\u0001XBc\u0013\r\u00199\r\u0015\u0002\t\u0007\u0006t\u0017i^1ji\"911Z\u0011A\u0002\r5\u0017AB1u\u001b>\u001cH\u000f\u0005\u0003\u0004P\u000eUWBABi\u0015\r\u0019\u0019\u000eU\u0001\tIV\u0014\u0018\r^5p]&!1q[Bi\u0005!!UO]1uS>t\u0007&B\u0011\u0004\\\u000e\u001d\b#\u0002-\u0004^\u000e\u0005\u0018bABp%\n1A\u000f\u001b:poN\u0004B!!\t\u0004d&!1Q]A\u001b\u0005QIe\u000e^3seV\u0004H/\u001a3Fq\u000e,\u0007\u000f^5p]\u000e\u00121\u0011\u001d\u0015\u0006C\r-8\u0011 \t\u00061\u000eu7Q\u001e\t\u0005\u0007_\u001c\u0019PD\u0002]\u0007cL1!a\fQ\u0013\u0011\u0019)pa>\u0003!QKW.Z8vi\u0016C8-\u001a9uS>t'bAA\u0018!\u000e\u00121Q^\u0001\u0007e\u0016\u001cX\u000f\u001c;\u0015\t\r}H1\u0001\u000b\u0004I\u0012\u0005\u0001bBBaE\u0001\u000f11\u0019\u0005\b\u0007\u0017\u0014\u0003\u0019ABgQ\u0015\u001131\\BtQ\u0015\u001131^B}+\u0011!Y\u0001b\u0006\u0015\t\u00115A\u0011\u0003\u000b\u0004Y\u0012=\u0001\"\u0002;$\u0001\b)\bBB=$\u0001\u0004!\u0019\u0002E\u0003Yw\u0012$)\u0002E\u0002a\t/!Qa`\u0012C\u0002\r,B\u0001b\u0007\u0005(Q!AQ\u0004C\u0011)\raGq\u0004\u0005\u0006i\u0012\u0002\u001d!\u001e\u0005\u0007s\u0012\u0002\r\u0001b\t\u0011\ra[\u0018q\u0004C\u0013!\r\u0001Gq\u0005\u0003\u0006\u007f\u0012\u0012\raY\u000b\u0005\tW!I\u0004\u0006\u0003\u0005.\u0011EBc\u00017\u00050!)A/\na\u0002k\"9\u0011\u0011U\u0013A\u0002\u0011M\u0002c\u0002-\u0002&\u0012UBq\u0007\t\u0006\u0003W\u000b\t\f\u001a\t\u0004A\u0012eB!B@&\u0005\u0004\u0019WC\u0001C\u001f!\u0015A\u0016\u0011\u001dC\u001b+\u0011!\t\u0005\"\u0014\u0015\t\u0011\rCq\t\u000b\u0004Y\u0012\u0015\u0003\"\u0002;*\u0001\b)\bbBAQS\u0001\u0007A\u0011\n\t\u00071\u0006\u0015F\rb\u0013\u0011\u0007\u0001$i\u0005B\u0003\u0000S\t\u00071-\u0006\u0003\u0005R\u0011eCC\u0002C*\t;\"\t\u0007\u0006\u0003\u0005V\u0011m\u0003\u0003\u0002/\u0001\t/\u00022\u0001\u0019C-\t\u0019\u0011YA\u000bb\u0001G\")AO\u000ba\u0002k\"9!\u0011\u0003\u0016A\u0002\u0011}\u0003C\u0002-\u0002&\u0012$9\u0006C\u0004\u0002\"*\u0002\rAa\u0006\u0016\t\u0011\u0015DQ\u000e\u000b\u0005\tO\"\t\b\u0006\u0003\u0005j\u0011=\u0004\u0003\u0002/\u0001\tW\u00022\u0001\u0019C7\t\u0019\u0011Ya\u000bb\u0001G\")Ao\u000ba\u0002k\"9\u0011\u0011U\u0016A\u0002\u0011M\u0004c\u0002-\u0002&\u0012UBQ\u000f\t\u0007\u0003W\u000b\t\fb\u001b\u0016\t\u0011eD\u0011\u0011\u000b\u0005\tw\")\t\u0006\u0003\u0005~\u0011\r\u0005\u0003\u0002/\u0001\t\u007f\u00022\u0001\u0019CA\t\u0019\u0011Y\u0001\fb\u0001G\")A\u000f\fa\u0002k\"9\u0011\u0011\u0015\u0017A\u0002\u0011\u001d\u0005c\u0002-\u0002&\u0012UBQP\u000b\u0005\t\u0017#\u0019\n\u0006\u0003\u0005\u000e\u0012]E\u0003\u0002CH\t+\u0003B\u0001\u0018\u0001\u0005\u0012B\u0019\u0001\rb%\u0005\r\t-QF1\u0001d\u0011\u0015!X\u0006q\u0001v\u0011\u001d\t\t+\fa\u0001\t3\u0003b\u0001WASI\u0012EU\u0003\u0002CO\tK#B\u0001b(\u0005*R!A\u0011\u0015CT!\u0011a\u0006\u0001b)\u0011\u0007\u0001$)\u000b\u0002\u0004\u0003\f9\u0012\ra\u0019\u0005\u0006i:\u0002\u001d!\u001e\u0005\b\u0003Cs\u0003\u0019\u0001CV!\u0019A\u0016Q\u00153\u0005\"V!Aq\u0016C[)\u0011!\t\fb.\u0011\tq\u0003A1\u0017\t\u0004A\u0012UFA\u0002B\u0006_\t\u00071\rC\u0004\u0003x=\u0002\u001d\u0001\"/\u0011\u000f\u0005u#1\u00103\u00052R!AQ\u0018Ca)\u0011\u0019\u0019\fb0\t\u000bQ\u0004\u00049A;\t\u000f\t-\u0005\u00071\u0001\u0005DB1\u0001,!*e\u0003+,B\u0001b2\u0005PR!A\u0011\u001aCj)\u0011!Y\r\"5\u0011\tq\u0003AQ\u001a\t\u0004A\u0012=GA\u0002B\u0006c\t\u00071\rC\u0003uc\u0001\u000fQ\u000f\u0003\u0004zc\u0001\u0007AQ\u001b\t\u00061n$GQZ\u000b\u0005\t3$\t\u000f\u0006\u0003\u0005\\\u0012\u0015H\u0003\u0002Co\tG\u0004B\u0001\u0018\u0001\u0005`B\u0019\u0001\r\"9\u0005\u000b}\u0014$\u0019A2\t\u000bQ\u0014\u00049A;\t\re\u0014\u0004\u0019\u0001Ct!\u0019A60a\b\u0005`V!A1\u001eCz)\u0011!i\u000fb>\u0015\t\u0011=HQ\u001f\t\u00059\u0002!\t\u0010E\u0002a\tg$Qa`\u001aC\u0002\rDQ\u0001^\u001aA\u0004UDa!_\u001aA\u0002\u0011e\bC\u0002-|\u0003?!y/\u0006\u0003\u0005~\u0016\u0015A\u0003\u0002C\u0000\u000b\u000f\u0001B\u0001\u0018\u0001\u0006\u0002A1\u0001L!?e\u000b\u0007\u00012\u0001YC\u0003\t\u0015yHG1\u0001d\u0011\u001d\u0019\u0019\u0001\u000ea\u0001\u000b\u0013\u0001B\u0001\u0018\u0001\u0006\u0004U1QQBC\u0011\u000b/!B!b\u0004\u0006$Q!Q\u0011CC\u000e)\u0011)\u0019\"\"\u0007\u0011\tq\u0003QQ\u0003\t\u0004A\u0016]AABB\fk\t\u00071\rC\u0003uk\u0001\u000fQ\u000fC\u0004\u0002\"V\u0002\r!\"\b\u0011\u0011a\u001by\u0002ZC\u0010\u000b+\u00012\u0001YC\u0011\t\u0015yXG1\u0001d\u0011\u001d\u0019\u0019!\u000ea\u0001\u000bK\u0001B\u0001\u0018\u0001\u0006 U!Q\u0011FC\u0018)\u0011)Y#\"\r\u0011\tq\u0003QQ\u0006\t\u0004A\u0016=B!B@7\u0005\u0004\u0019\u0007bBB\u0002m\u0001\u0007Q1F\u000b\u0005\u000bk)Y\u0004\u0006\u0003\u00068\u0015u\u0002\u0003\u0002/\u0001\u000bs\u00012\u0001YC\u001e\t\u0019\u0011Ya\u000eb\u0001G\"91qI\u001cA\u0004\u0015}\u0002CBB&\u0007#*I$\u0006\u0003\u0006D\u0015=C\u0003BC#\u000b\u0013\"Baa-\u0006H!)A\u000f\u000fa\u0002k\"1\u0011\u0010\u000fa\u0001\u000b\u0017\u0002b\u0001W>\u00056\u00155\u0003c\u00011\u0006P\u0011)q\u0010\u000fb\u0001G\u0006AAo\\*ue&tw\r\u0006\u0002\u0002\\\u0005!QO\\5u+\t)I\u0006E\u0002]\u00011\fQ!\u001e8ji\u0002*B!b\u0018\u0006fQ!Q\u0011MC4!\u0011a\u0006!b\u0019\u0011\u0007\u0001,)\u0007B\u0003cy\t\u00071\rC\u0004\u0006jq\u0002\r!a\b\u0002\u0013\u0015D8-\u001a9uS>t\u0017AC:vG\u000e,7o\u001d4vYV!QqNC;)\u0011)\t(b\u001e\u0011\tq\u0003Q1\u000f\t\u0004A\u0016UD!\u00022>\u0005\u0004\u0019\u0007bBB~{\u0001\u0007Q1O\u0001\bMJ|W\u000e\u0016:z+\u0011)i(b!\u0015\t\u0015}TQ\u0011\t\u00059\u0002)\t\tE\u0002a\u000b\u0007#QA\u0019 C\u0002\rDqaa??\u0001\u0004)9\t\u0005\u0004\u0002,\u0006EV\u0011Q\u000b\u0005\u000b\u0017+\u0019\n\u0006\u0003\u0006\u000e\u0016=F\u0003BCH\u000b+\u0003B\u0001\u0018\u0001\u0006\u0012B\u0019\u0001-b%\u0005\u000b\t|$\u0019A2\t\u000bQ|\u00049A;)\u0011\u0015U\u0015QHCM\u000bS\u000btaHA#\u000b7+\t+M\u0005$\u0003\u001b\n\u0019&\"(\u0002VEJ1%!\u001c\u0002p\u0015}\u0015\u0011L\u0019\u0007I\u0005\r\u00121F*2\u000b\u0015*\u0019+\"*\u0010\u0005\u0015\u0015\u0016EACT\u0003\u001d)\u00070Z2dib\f\u0014bIA.\u0003{*Y+a 2\u0013\r\n9)!#\u0006.\u0006\r\u0015'\u0002\u0012Y%\u00065\u0005\u0002CCY\u007f\u0011\u0005\r!b-\u0002\t\t|G-\u001f\t\u00061\u0016UV\u0011S\u0005\u0004\u000bo\u0013&\u0001\u0003\u001fcs:\fW.\u001a \u0002\u0011M,\u0017/^3oG\u0016,b!\"0\u0006\\\u0016\u0015G\u0003BC`\u000bk$b!\"1\u0006`\u0016M\b\u0003\u0002/\u0001\u000b\u0007\u0004R\u0001YCc\u000b3$q!b2A\u0005\u0004)IMA\u0001N+\u0011)Y-\"6\u0012\u0007\u0011,i\r\u0005\u0004\u0002\"\u0015=W1[\u0005\u0005\u000b#\f)DA\bUe\u00064XM]:bE2,wJ\\2f!\r\u0001WQ\u001b\u0003\b\u000b/,)M1\u0001d\u0005\u0005A\u0006c\u00011\u0006\\\u00121QQ\u001c!C\u0002\r\u0014\u0011!\u0011\u0005\b\u000bC\u0004\u00059ACr\u0003\r\u0019'M\u001a\t\u000b\u000bK,Y/b<\u0006Z\u0016\rWBACt\u0015\u0011)Io! \u0002\u000f\u001d,g.\u001a:jG&!QQ^Ct\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\u0015\u0001WQYCy!\u0011a\u0006!\"7\t\u000bQ\u0004\u00059A;\t\u000f\u0015]\b\t1\u0001\u0006p\u0006\u0011\u0011N\\\u0001\u0011M&\u00148\u000f^\"p[BdW\r^3e\u001f\u001a,B!\"@\u0007\u0006Q!Qq D\u0005)\u00111\tAb\u0002\u0011\tq\u0003a1\u0001\t\u0004A\u001a\u0015A!\u00022B\u0005\u0004\u0019\u0007\"\u0002;B\u0001\b)\bb\u0002D\u0006\u0003\u0002\u0007aQB\u0001\bMV$XO]3t!\u0019\t\t#b4\u0007\u0002\u0005!a-\u001b8e+\u00111\u0019Bb\b\u0015\t\u0019Uaq\b\u000b\u0005\r/1\u0019\u0003\u0006\u0003\u0007\u001a\u0019\u0005\u0002\u0003\u0002/\u0001\r7\u0001R\u0001WAq\r;\u00012\u0001\u0019D\u0010\t\u0015\u0011'I1\u0001d\u0011\u0015!(\tq\u0001v\u0011\u001d\u0011YI\u0011a\u0001\rK\u0001r\u0001WAS\r;\t)\u000e\u000b\u0005\u0007$\u0005ub\u0011\u0006D\u001dc\u001dy\u0012Q\tD\u0016\rc\t\u0014bIA'\u0003'2i#!\u00162\u0013\r\ni'a\u001c\u00070\u0005e\u0013G\u0002\u0013\u0002$\u0005-2+M\u0003&\rg1)d\u0004\u0002\u00076\u0005\u0012aqG\u0001\naJ,G-[2bi\u0016\f\u0014bIA.\u0003{2Y$a 2\u0013\r\n9)!#\u0007>\u0005\r\u0015'\u0002\u0012Y%\u00065\u0005b\u0002D\u0006\u0005\u0002\u0007a\u0011\t\t\u0007\u0003C)yMb\u0011\u0011\tq\u0003aQ\u0004\u0015\t\r\u007f\tiDb\u0012\u0007XE:q$!\u0012\u0007J\u0019=\u0013'C\u0012\u0002N\u0005Mc1JA+c%\u0019\u0013QNA8\r\u001b\nI&\r\u0004%\u0003G\tYcU\u0019\u0006K\u0019Ec1K\b\u0003\r'\n#A\"\u0016\u0002\u001f\u0019,H/\u001e:fgR\u0014\u0018M^8oG\u0016\f\u0014bIA.\u0003{2I&a 2\u0013\r\n9)!#\u0007\\\u0005\r\u0015'\u0002\u0012Y%\u00065\u0005f\u0002\"\u0002\u0004\u0019}\u0013QB\u0011\u0003\rC\n!-^:fAQDW\rI8wKJdw.\u00193fI\u00022XM]:j_:\u0004sN\u001a\u0011uQ&\u001c\b%\\3uQ>$\u0007\u0005\u001e5bi\u0002\"\u0018m[3tA\u0005\u00043oY1mC:\u001aw\u000e\u001c7fGRLwN\u001c\u0018j[6,H/\u00192mK:JE/\u001a:bE2,\u0007%\u001b8ti\u0016\fG-\u0006\u0003\u0007f\u0019ED\u0003\u0002D4\rs\"BA\"\u001b\u0007vQ!a1\u000eD:!\u0011a\u0006A\"\u001c\u0011\u000ba\u000b\tOb\u001c\u0011\u0007\u00014\t\bB\u0003c\u0007\n\u00071\rC\u0003u\u0007\u0002\u000fQ\u000fC\u0004\u0003\f\u000e\u0003\rAb\u001e\u0011\u000fa\u000b)Kb\u001c\u0002V\"9a1B\"A\u0002\u0019m\u0004CBB<\r{2\t)\u0003\u0003\u0007\u0000\re$\u0001C%uKJ\f'\r\\3\u0011\tq\u0003aqN\u0001\tM>dG\rT3giV1aq\u0011DP\r'#BA\"#\u0007&R!a1\u0012DQ)\u00111iIb&\u0015\t\u0019=eQ\u0013\t\u00059\u00021\t\nE\u0002a\r'#aaa\u0006E\u0005\u0004\u0019\u0007\"\u0002;E\u0001\b)\bb\u0002DM\t\u0002\u0007a1T\u0001\u0003_B\u0004\u0012\u0002WB\u0010\r#3iJ\"%\u0011\u0007\u00014y\nB\u0003c\t\n\u00071\rC\u0004\u0007$\u0012\u0003\rA\"%\u0002\ti,'o\u001c\u0005\b\r\u0017!\u0005\u0019\u0001DT!\u0019\u00199H\" \u0007*B!A\f\u0001DO\u0003!1w\u000e\u001c3OKb$XC\u0002DX\r\u001349\f\u0006\u0005\u00072\u001amf1\u001aDh)\u00111\u0019L\"/\u0011\tq\u0003aQ\u0017\t\u0004A\u001a]FABB\f\u000b\n\u00071\rC\u0003u\u000b\u0002\u000fQ\u000fC\u0004\u0007>\u0016\u0003\rAb0\u0002\u0003%\u0004b!!\t\u0007B\u001a\u0015\u0017\u0002\u0002Db\u0003k\u0011\u0001\"\u0013;fe\u0006$xN\u001d\t\u00059\u000219\rE\u0002a\r\u0013$QAY#C\u0002\rDqA\"4F\u0001\u00041),A\u0005qe\u00164h+\u00197vK\"9a\u0011T#A\u0002\u0019E\u0007#\u0003-\u0004 \u0019Ufq\u0019D[\u0003\u00111w\u000e\u001c3\u0016\r\u0019]gQ\u001eDr)\u00111In\"\u0003\u0015\t\u0019mwq\u0001\u000b\u0005\r;49\u000f\u0006\u0003\u0007`\u001a\u0015\b\u0003\u0002/\u0001\rC\u00042\u0001\u0019Dr\t\u0019\u00199B\u0012b\u0001G\")AO\u0012a\u0002k\"9a\u0011\u0014$A\u0002\u0019%\b#\u0003-\u0004 \u0019\u0005h1\u001eDq!\r\u0001gQ\u001e\u0003\u0006E\u001a\u0013\ra\u0019\u0015\t\rO\fiD\"=\b\u0002E:q$!\u0012\u0007t\u001ae\u0018'C\u0012\u0002N\u0005McQ_A+c%\u0019\u0013QNA8\ro\fI&\r\u0004%\u0003G\tYcU\u0019\u0006K\u0019mhQ`\b\u0003\r{\f#Ab@\u0002\u000f\u0019|G\u000e\u001a$v]FJ1%a\u0017\u0002~\u001d\r\u0011qP\u0019\nG\u0005\u001d\u0015\u0011RD\u0003\u0003\u0007\u000bTA\t-S\u0003\u001bCqAb)G\u0001\u00041\t\u000fC\u0004\u0007\f\u0019\u0003\rab\u0003\u0011\r\u0005\u0005RqZD\u0007!\u0011a\u0006Ab;)\u000f\u0019\u000b\u0019a\"\u0005\u0002\u000e\u0005\u0012q1C\u0001\u001ckN,\u0007ER;ukJ,gFZ8mI2+g\r\u001e\u0011j]N$X-\u00193\u0002\rI,G-^2f+\u00199Ib\"\u000b\b$Q!q1DD\u0019)\u00119ib\"\f\u0015\t\u001d}q1\u0006\t\u00059\u00029\t\u0003E\u0002a\u000fG!qaa\u0006H\u0005\u00049)#E\u0002\b(\u001d\u00042\u0001YD\u0015\t\u0015\u0011wI1\u0001d\u0011\u0015!x\tq\u0001v\u0011\u001d1Ij\u0012a\u0001\u000f_\u0001\u0012\u0002WB\u0010\u000fC99c\"\t\t\u000f\u0019-q\t1\u0001\b4A1\u0011\u0011ECh\u000fk\u0001B\u0001\u0018\u0001\b(!:q)a\u0001\b:\u00055\u0011EAD\u001e\u0003u)8/\u001a\u0011GkR,(/\u001a\u0018sK\u0012,8-\u001a'fMR\u0004\u0013N\\:uK\u0006$\u0017A\u0003:fIV\u001cW\rT3giV1q\u0011ID)\u000f\u0017\"Bab\u0011\bZQ!qQID+)\u001199eb\u0015\u0011\tq\u0003q\u0011\n\t\u0004A\u001e-CaBB\f\u0011\n\u0007qQJ\t\u0004\u000f\u001f:\u0007c\u00011\bR\u0011)!\r\u0013b\u0001G\")A\u000f\u0013a\u0002k\"9a\u0011\u0014%A\u0002\u001d]\u0003#\u0003-\u0004 \u001d%sqJD%\u0011\u001d1Y\u0001\u0013a\u0001\u000f7\u0002baa\u001e\u0007~\u001du\u0003\u0003\u0002/\u0001\u000f\u001f\n\u0001\u0002\u001e:bm\u0016\u00148/Z\u000b\t\u000fG:9ib\u001f\bnQ!qQMDJ)\u001199gb#\u0015\r\u001d%tqPDE!\u0011a\u0006ab\u001b\u0011\u000b\u0001<ig\"\u001f\u0005\u000f\u0015\u001d\u0017J1\u0001\bpU!q\u0011OD<#\r!w1\u000f\t\u0007\u0003C)ym\"\u001e\u0011\u0007\u0001<9\bB\u0004\u0006X\u001e5$\u0019A2\u0011\u0007\u0001<Y\b\u0002\u0004\b~%\u0013\ra\u0019\u0002\u0002\u0005\"9Q\u0011]%A\u0004\u001d\u0005\u0005CCCs\u000bW<\u0019i\"\u001f\blA)\u0001m\"\u001c\b\u0006B\u0019\u0001mb\"\u0005\r\u0015u\u0017J1\u0001d\u0011\u0015!\u0018\nq\u0001v\u0011\u001d9i)\u0013a\u0001\u000f\u001f\u000b!A\u001a8\u0011\u000fa\u000b)k\"\"\b\u0012B!A\fAD=\u0011\u001d)90\u0013a\u0001\u000f\u0007\u000b\u0001$\u00138uKJt\u0017\r\\\"bY2\u0014\u0017mY6Fq\u0016\u001cW\u000f^8s!\r\u0019ik\u0013\u0002\u0019\u0013:$XM\u001d8bY\u000e\u000bG\u000e\u001c2bG.,\u00050Z2vi>\u00148#B&Xk\u001eu\u0005c\u0001/\b &\u0019q\u0011\u0015)\u0003!\t\u000bGo\u00195j]\u001e,\u00050Z2vi>\u0014HCADL\u0003A)hNY1uG\",G-\u0012=fGV$X\rF\u0002m\u000fSCqab+N\u0001\u00049i+A\u0001s!\u0011\u0019Iib,\n\t\u001dE61\u0012\u0002\t%Vtg.\u00192mK\u0006i!/\u001a9peR4\u0015-\u001b7ve\u0016$2\u0001\\D\\\u0011\u001d9IL\u0014a\u0001\u0003?\t\u0011\u0001\u001e")
public interface Future<T>
extends Awaitable<T> {
    public static <A, B, M extends TraversableOnce<Object>> Future<M> traverse(M m, Function1<A, Future<B>> function1, CanBuildFrom<M, B, M> canBuildFrom, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        Future$ traverse_this = future$;
        return m.foldLeft(traverse_this.successful(canBuildFrom.apply(m)), (arg_0, arg_1) -> Future$.$anonfun$traverse$1(function1, executionContext, arg_0, arg_1)).map(Future$::$anonfun$traverse$3, Future$InternalCallbackExecutor$.MODULE$);
    }

    public static <T, R> Future<R> reduceLeft(Iterable<Future<T>> iterable, Function2<R, T, R> function2, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        Future$ reduceLeft_this = future$;
        Iterator reduceLeft_i = iterable.iterator();
        if (!reduceLeft_i.hasNext()) {
            return reduceLeft_this.failed(new NoSuchElementException("reduceLeft attempted on empty collection"));
        }
        return ((Future)reduceLeft_i.next()).flatMap(arg_0 -> Future$.$anonfun$reduceLeft$1(reduceLeft_i, function2, executionContext, arg_0), executionContext);
    }

    public static <T, R> Future<R> reduce(TraversableOnce<Future<T>> traversableOnce, Function2<R, T, R> function2, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        Future$ reduce_this = future$;
        if (traversableOnce.isEmpty()) {
            return reduce_this.failed(new NoSuchElementException("reduce attempted on empty collection"));
        }
        return reduce_this.sequence(traversableOnce, TraversableOnce$.MODULE$.OnceCanBuildFrom(), executionContext).map(arg_0 -> Future$.$anonfun$reduce$1(function2, arg_0), executionContext);
    }

    public static <T, R> Future<R> fold(TraversableOnce<Future<T>> traversableOnce, R r, Function2<R, T, R> function2, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        Future$ fold_this = future$;
        if (traversableOnce.isEmpty()) {
            return fold_this.successful(r);
        }
        return fold_this.sequence(traversableOnce, TraversableOnce$.MODULE$.OnceCanBuildFrom(), executionContext).map(arg_0 -> Future$.$anonfun$fold$1(r, function2, arg_0), executionContext);
    }

    public static <T, R> Future<R> foldLeft(Iterable<Future<T>> iterable, R r, Function2<R, T, R> function2, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        Future$ foldLeft_this = future$;
        Iterator foldLeft_foldNext_i = iterable.iterator();
        if (!foldLeft_foldNext_i.hasNext()) {
            return foldLeft_this.successful(r);
        }
        return ((Future)foldLeft_foldNext_i.next()).flatMap(arg_0 -> Future$.$anonfun$foldNext$1(foldLeft_foldNext_i, function2, r, executionContext, arg_0), executionContext);
    }

    public static <T> Future<Option<T>> find(Iterable<Future<T>> iterable, Function1<T, Object> function1, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        Future$ find_this = future$;
        Iterator find_searchNext$1_i = iterable.iterator();
        if (!find_searchNext$1_i.hasNext()) {
            return find_this.successful(None$.MODULE$);
        }
        return ((Future)find_searchNext$1_i.next()).transformWith(arg_0 -> Future$.$anonfun$find$3(find_this, function1, find_searchNext$1_i, executionContext, arg_0), executionContext);
    }

    public static <T> Future<Option<T>> find(TraversableOnce<Future<T>> traversableOnce, Function1<T, Object> function1, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        Future$ find_this = future$;
        Buffer find_futuresBuffer = traversableOnce.toBuffer();
        if (find_futuresBuffer.isEmpty()) {
            return find_this.successful(None$.MODULE$);
        }
        Promise find_result = Promise$.MODULE$.apply();
        AtomicInteger find_ref = new AtomicInteger(find_futuresBuffer.size());
        Function1<Try, Object> & java.io.Serializable & Serializable find_search = arg_0 -> Future$.$anonfun$find$1$adapted(function1, find_result, find_ref, arg_0);
        find_futuresBuffer.foreach(arg_0 -> Future$.$anonfun$find$2$adapted(find_search, executionContext, arg_0));
        return find_result.future();
    }

    public static <T> Future<T> firstCompletedOf(TraversableOnce<Future<T>> traversableOnce, ExecutionContext executionContext) {
        return Future$.MODULE$.firstCompletedOf(traversableOnce, executionContext);
    }

    public static <A, M extends TraversableOnce<Object>> Future<M> sequence(M m, CanBuildFrom<M, A, M> canBuildFrom, ExecutionContext executionContext) {
        return Future$.MODULE$.sequence(m, canBuildFrom, executionContext);
    }

    public static <T> Future<T> apply(Function0<T> function0, ExecutionContext executionContext) {
        Future$ future$ = Future$.MODULE$;
        if (future$ == null) {
            throw null;
        }
        return future$.unit().map(arg_0 -> Future$.$anonfun$apply$1(function0, arg_0), executionContext);
    }

    public static <T> Future<T> fromTry(Try<T> try_) {
        return Future$.MODULE$.fromTry(try_);
    }

    public static <T> Future<T> successful(T t) {
        return Future$.MODULE$.successful(t);
    }

    public static Future<BoxedUnit> unit() {
        return Future$.MODULE$.unit();
    }

    public static /* synthetic */ void onSuccess$(Future $this, PartialFunction pf, ExecutionContext executor) {
        $this.onSuccess(pf, executor);
    }

    default public <U> void onSuccess(PartialFunction<T, U> pf, ExecutionContext executor) {
        this.onComplete((Function1<Try, Object> & java.io.Serializable & Serializable)x0$1 -> {
            BoxedUnit boxedUnit;
            if (x0$1 instanceof Success) {
                Object v = ((Success)x0$1).value();
                boxedUnit = pf.applyOrElse(v, (Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    return x;
                });
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            return boxedUnit;
        }, executor);
    }

    public static /* synthetic */ void onFailure$(Future $this, PartialFunction pf, ExecutionContext executor) {
        $this.onFailure(pf, executor);
    }

    default public <U> void onFailure(PartialFunction<Throwable, U> pf, ExecutionContext executor) {
        this.onComplete((Function1<Try, Object> & java.io.Serializable & Serializable)x0$1 -> {
            BoxedUnit boxedUnit;
            if (x0$1 instanceof Failure) {
                Throwable t = ((Failure)x0$1).exception();
                boxedUnit = pf.applyOrElse(t, (Function1<Throwable, Throwable> & java.io.Serializable & Serializable)x -> {
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    return x;
                });
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            return boxedUnit;
        }, executor);
    }

    public <U> void onComplete(Function1<Try<T>, U> var1, ExecutionContext var2);

    public boolean isCompleted();

    public Option<Try<T>> value();

    public static /* synthetic */ Future failed$(Future $this) {
        return $this.failed();
    }

    default public Future<Throwable> failed() {
        return this.transform((Function1<Try, Try> & java.io.Serializable & Serializable)x0$1 -> {
            Try try_;
            if (x0$1 instanceof Failure) {
                Throwable t = ((Failure)x0$1).exception();
                try_ = new Success<Throwable>(t);
            } else if (x0$1 instanceof Success) {
                try_ = new Failure(new NoSuchElementException("Future.failed not completed with a throwable."));
            } else {
                throw new MatchError(x0$1);
            }
            return try_;
        }, Future$InternalCallbackExecutor$.MODULE$);
    }

    public static /* synthetic */ void foreach$(Future $this, Function1 f, ExecutionContext executor) {
        $this.foreach(f, executor);
    }

    default public <U> void foreach(Function1<T, U> f, ExecutionContext executor) {
        this.onComplete((Function1<Try, Object> & java.io.Serializable & Serializable)x$1 -> {
            x$1.foreach(f);
            return BoxedUnit.UNIT;
        }, executor);
    }

    public static /* synthetic */ Future transform$(Future $this, Function1 s, Function1 f, ExecutionContext executor) {
        return $this.transform(s, f, executor);
    }

    default public <S> Future<S> transform(Function1<T, S> s, Function1<Throwable, Throwable> f, ExecutionContext executor) {
        return this.transform((Function1<Try, Try> & java.io.Serializable & Serializable)x0$1 -> {
            Try try_;
            if (x0$1 instanceof Success) {
                Try try_2;
                Object r = ((Success)x0$1).value();
                if (Try$.MODULE$ == null) {
                    throw null;
                }
                try {
                    try_2 = new Success<Object>(s.apply(r));
                }
                catch (Throwable throwable) {
                    Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
                    if (option.isEmpty()) {
                        throw throwable;
                    }
                    Throwable apply_e = option.get();
                    Failure failure = new Failure(apply_e);
                    try_2 = failure;
                }
                try_ = try_2;
            } else if (x0$1 instanceof Failure) {
                Throwable t = ((Failure)x0$1).exception();
                if (Try$.MODULE$ == null) {
                    throw null;
                }
                try {
                    Success success;
                    Success success2 = success;
                    Success success3 = success;
                    throw Future.$anonfun$transform$3(f, t);
                }
                catch (Throwable throwable) {
                    Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
                    if (option.isEmpty()) {
                        throw throwable;
                    }
                    Throwable apply_e = option.get();
                    Failure failure = new Failure(apply_e);
                    try_ = failure;
                }
            } else {
                throw new MatchError(x0$1);
            }
            return try_;
        }, executor);
    }

    public <S> Future<S> transform(Function1<Try<T>, Try<S>> var1, ExecutionContext var2);

    public <S> Future<S> transformWith(Function1<Try<T>, Future<S>> var1, ExecutionContext var2);

    public static /* synthetic */ Future map$(Future $this, Function1 f, ExecutionContext executor) {
        return $this.map(f, executor);
    }

    default public <S> Future<S> map(Function1<T, S> f, ExecutionContext executor) {
        return this.transform((Function1<Try, Try> & java.io.Serializable & Serializable)x$2 -> x$2.map(f), executor);
    }

    public static /* synthetic */ Future flatMap$(Future $this, Function1 f, ExecutionContext executor) {
        return $this.flatMap(f, executor);
    }

    default public <S> Future<S> flatMap(Function1<T, Future<S>> f, ExecutionContext executor) {
        return this.transformWith((Function1<Try, Future> & java.io.Serializable & Serializable)x0$1 -> {
            Future future;
            if (x0$1 instanceof Success) {
                Object s = ((Success)x0$1).value();
                future = (Future)f.apply(s);
            } else if (x0$1 instanceof Failure) {
                future = this;
            } else {
                throw new MatchError(x0$1);
            }
            return future;
        }, executor);
    }

    public static /* synthetic */ Future flatten$(Future $this, Predef$.less.colon.less ev) {
        return $this.flatten(ev);
    }

    default public <S> Future<S> flatten(Predef$.less.colon.less<T, Future<S>> ev) {
        return this.flatMap(ev, Future$InternalCallbackExecutor$.MODULE$);
    }

    public static /* synthetic */ Future filter$(Future $this, Function1 p, ExecutionContext executor) {
        return $this.filter(p, executor);
    }

    default public Future<T> filter(Function1<T, Object> p, ExecutionContext executor) {
        return this.map((Function1<Object, Object> & java.io.Serializable & Serializable)r -> {
            if (BoxesRunTime.unboxToBoolean(p.apply(r))) {
                return r;
            }
            throw new NoSuchElementException("Future.filter predicate is not satisfied");
        }, executor);
    }

    public static /* synthetic */ Future withFilter$(Future $this, Function1 p, ExecutionContext executor) {
        return $this.withFilter(p, executor);
    }

    default public Future<T> withFilter(Function1<T, Object> p, ExecutionContext executor) {
        return this.filter(p, executor);
    }

    public static /* synthetic */ Future collect$(Future $this, PartialFunction pf, ExecutionContext executor) {
        return $this.collect(pf, executor);
    }

    default public <S> Future<S> collect(PartialFunction<T, S> pf, ExecutionContext executor) {
        return this.map((Function1<Object, Object> & java.io.Serializable & Serializable)r -> pf.applyOrElse(r, (Function1<Object, Nothing$> & java.io.Serializable & Serializable)t -> {
            throw new NoSuchElementException(new StringBuilder(51).append("Future.collect partial function is not defined at: ").append(t).toString());
        }), executor);
    }

    public static /* synthetic */ Future recover$(Future $this, PartialFunction pf, ExecutionContext executor) {
        return $this.recover(pf, executor);
    }

    default public <U> Future<U> recover(PartialFunction<Throwable, U> pf, ExecutionContext executor) {
        return this.transform((Function1<Try, Try> & java.io.Serializable & Serializable)x$3 -> x$3.recover(pf), executor);
    }

    public static /* synthetic */ Future recoverWith$(Future $this, PartialFunction pf, ExecutionContext executor) {
        return $this.recoverWith(pf, executor);
    }

    default public <U> Future<U> recoverWith(PartialFunction<Throwable, Future<U>> pf, ExecutionContext executor) {
        return this.transformWith((Function1<Try, Future> & java.io.Serializable & Serializable)x0$1 -> {
            Future future;
            if (x0$1 instanceof Failure) {
                Throwable t = ((Failure)x0$1).exception();
                future = (Future)pf.applyOrElse(t, (Function1<Throwable, Future> & java.io.Serializable & Serializable)x$4 -> this);
            } else if (x0$1 instanceof Success) {
                future = this;
            } else {
                throw new MatchError(x0$1);
            }
            return future;
        }, executor);
    }

    public static /* synthetic */ Future zip$(Future $this, Future that) {
        return $this.zip(that);
    }

    default public <U> Future<Tuple2<T, U>> zip(Future<U> that) {
        Future$InternalCallbackExecutor$ ec = Future$InternalCallbackExecutor$.MODULE$;
        return this.flatMap((Function1<Object, Future> & java.io.Serializable & Serializable)r1 -> that.map((Function1<Object, Tuple2> & java.io.Serializable & Serializable)r2 -> new Tuple2<Object, Object>(r1, r2), ec), ec);
    }

    public static /* synthetic */ Future zipWith$(Future $this, Future that, Function2 f, ExecutionContext executor) {
        return $this.zipWith(that, f, executor);
    }

    default public <U, R> Future<R> zipWith(Future<U> that, Function2<T, U, R> f, ExecutionContext executor) {
        return this.flatMap((Function1<Object, Future> & java.io.Serializable & Serializable)r1 -> that.map((Function1<Object, Object> & java.io.Serializable & Serializable)r2 -> f.apply(r1, r2), executor), Future$InternalCallbackExecutor$.MODULE$);
    }

    public static /* synthetic */ Future fallbackTo$(Future $this, Future that) {
        return $this.fallbackTo(that);
    }

    default public <U> Future<U> fallbackTo(Future<U> that) {
        if (this == that) {
            return this;
        }
        Future$InternalCallbackExecutor$ ec = Future$InternalCallbackExecutor$.MODULE$;
        return this.recoverWith((PartialFunction<Throwable, Future<U>>)((Object)new Serializable(null, that){
            public static final long serialVersionUID = 0L;
            private final Future that$3;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                return (B1)this.that$3;
            }

            public final boolean isDefinedAt(Throwable x1) {
                return true;
            }
            {
                this.that$3 = that$3;
            }
        }), ec).recoverWith((PartialFunction<Throwable, Future<U>>)((Object)new Serializable(this){
            public static final long serialVersionUID = 0L;
            private final /* synthetic */ Future $outer;

            public final <A1 extends Throwable, B1> B1 applyOrElse(A1 x2, Function1<A1, B1> function1) {
                return (B1)this.$outer;
            }

            public final boolean isDefinedAt(Throwable x2) {
                return true;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }), ec);
    }

    public static /* synthetic */ Future mapTo$(Future $this, ClassTag tag) {
        return $this.mapTo(tag);
    }

    default public <S> Future<S> mapTo(ClassTag<S> tag) {
        Future$InternalCallbackExecutor$ ec = Future$InternalCallbackExecutor$.MODULE$;
        Class c = tag.runtimeClass();
        Class boxedClass = c.isPrimitive() ? (Class)Future$.MODULE$.toBoxed().apply(c) : c;
        Predef$.MODULE$.require(boxedClass != null);
        return this.map((Function1<Object, Object> & java.io.Serializable & Serializable)s -> boxedClass.cast(s), ec);
    }

    public static /* synthetic */ Future andThen$(Future $this, PartialFunction pf, ExecutionContext executor) {
        return $this.andThen(pf, executor);
    }

    default public <U> Future<T> andThen(PartialFunction<Try<T>, U> pf, ExecutionContext executor) {
        return this.transform((Function1<Try, Try> & java.io.Serializable & Serializable)result2 -> {
            try {
                pf.applyOrElse(result2, (Function1<Try, Try> & java.io.Serializable & Serializable)x -> {
                    if (Predef$.MODULE$ == null) {
                        throw null;
                    }
                    return x;
                });
            }
            catch (Throwable throwable) {
                Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
                if (!option.isEmpty()) {
                    Throwable t = option.get();
                    executor.reportFailure(t);
                }
                throw throwable;
            }
            return result2;
        }, executor);
    }

    public static /* synthetic */ void $anonfun$foreach$1(Function1 f$1, Try x$1) {
        x$1.foreach(f$1);
    }

    public static /* synthetic */ Nothing$ $anonfun$transform$3(Function1 f$2, Throwable t$1) {
        throw (Throwable)f$2.apply(t$1);
    }

    public static void $init$(Future $this) {
    }
}

