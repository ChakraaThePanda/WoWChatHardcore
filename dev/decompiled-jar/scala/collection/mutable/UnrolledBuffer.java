/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import scala.Array$;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericClassTagCompanion;
import scala.collection.generic.GenericClassTagTraversableTemplate;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.AbstractBuffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.UnrolledBuffer$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.ObjectRef;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r\u001df\u0001B+W!uC!\"a\u0002\u0001\u0005\u000b\u0007I1AA\u0005\u0011)\t9\u0002\u0001B\u0001B\u0003%\u00111\u0002\u0005\b\u00033\u0001A\u0011AA\u000e\u0011%\t\t\u0003\u0001a\u0001\n\u0013\t\u0019\u0003C\u0005\u0003R\u0002\u0001\r\u0011\"\u0003\u0003T\"A!q\u001b\u0001!B\u0013\t)\u0003C\u0005\u0003b\u0002\u0001\r\u0011\"\u0003\u0002$!I!1\u001d\u0001A\u0002\u0013%!Q\u001d\u0005\t\u0005S\u0004\u0001\u0015)\u0003\u0002&!I!Q\u001e\u0001A\u0002\u0013%\u0011q\u000e\u0005\n\u0005_\u0004\u0001\u0019!C\u0005\u0005cD\u0001B!>\u0001A\u0003&\u0011\u0011\u000f\u0005\t\u0005s\u0004A\u0011\u0001-\u0002$!A!1 \u0001\u0005\u0002a\u0013i\u0010\u0003\u0005\u0004\u0004\u0001!\t\u0001WA\u0012\u0011!\u0019)\u0001\u0001C\u00011\u000e\u001d\u0001\u0002CAH\u0001\u0011\u0005\u0001l!\u0004\t\u0011\u0005m\u0003\u0001)C)\u0007'Aqa!\u0006\u0001\t#\t\u0019\u0003\u0003\u0005\u0004\u0018\u0001!\t\u0001WB\r\u0011\u001d\u0019i\u0002\u0001C\u0001\u0007?Aqa!\t\u0001\t\u0003\u0019\u0019\u0003C\u0004\u0004*\u0001!\taa\u000b\t\u000f\rE\u0002\u0001\"\u0001\u0003F!911\u0007\u0001\u0005\u0002\rU\u0002b\u0002B\u0005\u0001\u0011\u00053Q\b\u0005\b\u0007\u0013\u0002A\u0011AB&\u0011\u001d\u0019i\u0005\u0001C\u0001\u0003_BqAa\b\u0001\t\u0003\u0019y\u0005C\u0004\u0003*\u0001!\taa\u0015\t\u000f\t\u001d\u0003\u0001\"\u0001\u0004Z!91Q\f\u0001\u0005\u0002\r}\u0003b\u0002B3\u0001\u0011\u000511\r\u0005\b\u0007[\u0002A\u0011BB8\u0011\u001d\u0019\t\t\u0001C\u0005\u0007\u0007Cqaa$\u0001\t\u0003\u001aY\u0005C\u0004\u0004\u0012\u0002!\tea%\b\u000f\u0005%b\u000b#\u0001\u0002,\u00191QK\u0016E\u0001\u0003[Aq!!\u0007(\t\u0003\t)\u0004C\u0004\u00028\u001d\"\u0019!!\u000f\t\u000f\u0005ms\u0005\"\u0001\u0002^!I\u0011QN\u0014C\u0002\u0013\u0005\u0011q\u000e\u0005\t\u0003o:\u0003\u0015!\u0003\u0002r!I\u0011\u0011P\u0014C\u0002\u0013\u0005\u0011q\u000e\u0005\t\u0003w:\u0003\u0015!\u0003\u0002r!Q\u0011QP\u0014C\u0002\u0013\u0005\u0001,a\u001c\t\u0011\u0005}t\u0005)A\u0005\u0003c2a!!!(\u0001\u0005\r\u0005BCAGc\t\u0005\r\u0011\"\u0001\u0002p!Q\u0011qR\u0019\u0003\u0002\u0004%\t!!%\t\u0015\u0005u\u0015G!A!B\u0013\t\t\b\u0003\u0006\u0002 F\u0012\t\u0019!C\u0001\u0003CC!\"!,2\u0005\u0003\u0007I\u0011AAX\u0011)\t\u0019,\rB\u0001B\u0003&\u00111\u0015\u0005\u000b\u0003k\u000b$\u00111A\u0005\u0002\u0005]\u0006BCA^c\t\u0005\r\u0011\"\u0001\u0002>\"Q\u0011\u0011Y\u0019\u0003\u0002\u0003\u0006K!!/\t\u0015\u0005\r\u0017G!b\u0001\n\u0003\t)\r\u0003\u0006\u0002JF\u0012\t\u0011)A\u0005\u0003\u000fD!\"a32\u0005\u0007\u0005\u000b1BAg\u0011!\tI\"\rC\u00011\u0006=\u0007\u0002CA\rc\u0011\u0005\u0001,!8\t\u0011\u0005e\u0011\u0007\"\u0001Y\u0003KDq!!=2\t\u0013\ty\u0007C\u0004\u0002tF\")!!>\t\u000f\t%\u0011\u0007\"\u0001\u0003\f!9!qD\u0019\u0005\u0006\t\u0005\u0002b\u0002B\u0015c\u0011\u0015!1\u0006\u0005\b\u0005k\tDQ\u0001B\u001c\u0011\u001d\u0011i$\rC\u0001\u0005\u007fAqAa\u00112\t\u0013\u0011)\u0005C\u0004\u0003HE\")A!\u0013\t\u000f\tM\u0013\u0007\"\u0003\u0003V!9!1L\u0019\u0005\u0012\tu\u0003b\u0002B3c\u0011\u0015!q\r\u0005\b\u0005s\nD\u0011\u0002B>\u0011\u001d\u0011))\rC\u0001\u0005\u000fCqA!$2\t\u0003\u0012yiB\u0005\u0003\"\u001e\n\t\u0011#\u0001\u0003$\u001aI\u0011\u0011Q\u0014\u0002\u0002#\u0005!Q\u0015\u0005\b\u00033\tF\u0011\u0001BT\u0011)\u0011I+UI\u0001\n\u0003A&1\u0016\u0005\n\u0005\u000f<\u0013\u0011!C\u0005\u0005\u0013\u0014a\"\u00168s_2dW\r\u001a\"vM\u001a,'O\u0003\u0002X1\u00069Q.\u001e;bE2,'BA-[\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u00027\u0006)1oY1mC\u000e\u0001QC\u00010f'!\u0001ql\u001c:w{\u0006\u0005\u0001c\u00011bG6\ta+\u0003\u0002c-\nq\u0011IY:ue\u0006\u001cGOQ;gM\u0016\u0014\bC\u00013f\u0019\u0001!QA\u001a\u0001C\u0002\u001d\u0014\u0011\u0001V\t\u0003Q2\u0004\"!\u001b6\u000e\u0003iK!a\u001b.\u0003\u000f9{G\u000f[5oOB\u0011\u0011.\\\u0005\u0003]j\u00131!\u00118z!\r\u0001\u0007oY\u0005\u0003cZ\u0013aAQ;gM\u0016\u0014\b\u0003\u00021tGVL!\u0001\u001e,\u0003\u0015\t+hMZ3s\u0019&\\W\rE\u0002a\u0001\r\u0004Ba\u001e>dy6\t\u0001P\u0003\u0002z1\u00069q-\u001a8fe&\u001c\u0017BA>y\u0005\t:UM\\3sS\u000e\u001cE.Y:t)\u0006<GK]1wKJ\u001c\u0018M\u00197f)\u0016l\u0007\u000f\\1uKB\u0011\u0001\r\u0001\t\u0005Az\u001cW/\u0003\u0002\u0000-\n9!)^5mI\u0016\u0014\bcA5\u0002\u0004%\u0019\u0011Q\u0001.\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\u0007Q\fw-\u0006\u0002\u0002\fA)\u0011QBA\nG6\u0011\u0011q\u0002\u0006\u0004\u0003#Q\u0016a\u0002:fM2,7\r^\u0005\u0005\u0003+\tyA\u0001\u0005DY\u0006\u001c8\u000fV1h\u0003\u0011!\u0018m\u001a\u0011\u0002\rqJg.\u001b;?)\t\ti\u0002F\u0002v\u0003?Aq!a\u0002\u0004\u0001\b\tY!A\u0004iK\u0006$\u0007\u000f\u001e:\u0016\u0005\u0005\u0015\u0002\u0003BA\u0014c\rt!\u0001\u0019\u0014\u0002\u001dUs'o\u001c7mK\u0012\u0014UO\u001a4feB\u0011\u0001mJ\n\u0006O\u0005=\u0012\u0011\u0001\t\u0005o\u0006EB0C\u0002\u00024a\u0014!d\u00117bgN$\u0016m\u001a+sCZ,'o]1cY\u00164\u0015m\u0019;pef$\"!a\u000b\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\t\u0005m\u0012\u0011\u000b\u000b\u0005\u0003{\t)\u0006E\u0005x\u0003\u007f\t\u0019%a\u0014\u0002T%\u0019\u0011\u0011\t=\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\t\u0005\u0015\u0013qI\u0007\u0002O%!\u0011\u0011JA&\u0005\u0011\u0019u\u000e\u001c7\n\u0007\u00055\u0003P\u0001\rHK:,'/[2DY\u0006\u001c8\u000fV1h\u0007>l\u0007/\u00198j_:\u00042\u0001ZA)\t\u00151\u0017F1\u0001h!\u0011\u0001\u0007!a\u0014\t\u000f\u0005]\u0013\u0006q\u0001\u0002Z\u0005\tA\u000f\u0005\u0004\u0002\u000e\u0005M\u0011qJ\u0001\u000b]\u0016<()^5mI\u0016\u0014X\u0003BA0\u0003K\"B!!\u0019\u0002jA1\u0001M`A2\u0003O\u00022\u0001ZA3\t\u00151'F1\u0001h!\u0011\u0001\u0007!a\u0019\t\u000f\u0005]#\u0006q\u0001\u0002lA1\u0011QBA\n\u0003G\n\u0011b^1uKJd\u0017N\\3\u0016\u0005\u0005E\u0004cA5\u0002t%\u0019\u0011Q\u000f.\u0003\u0007%sG/\u0001\u0006xCR,'\u000f\\5oK\u0002\nab^1uKJd\u0017N\\3EK2LW.A\bxCR,'\u000f\\5oK\u0012+G.[7!\u00039)hN]8mY\u0016$G.\u001a8hi\"\fq\"\u001e8s_2dW\r\u001a7f]\u001e$\b\u000e\t\u0002\t+:\u0014x\u000e\u001c7fIV!\u0011QQAV'\r\t\u0014q\u0011\t\u0004S\u0006%\u0015bAAF5\n1\u0011I\\=SK\u001a\fAa]5{K\u0006A1/\u001b>f?\u0012*\u0017\u000f\u0006\u0003\u0002\u0014\u0006e\u0005cA5\u0002\u0016&\u0019\u0011q\u0013.\u0003\tUs\u0017\u000e\u001e\u0005\n\u00037\u001b\u0014\u0011!a\u0001\u0003c\n1\u0001\u001f\u00132\u0003\u0015\u0019\u0018N_3!\u0003\u0015\t'O]1z+\t\t\u0019\u000bE\u0003j\u0003K\u000bI+C\u0002\u0002(j\u0013Q!\u0011:sCf\u00042\u0001ZAV\t\u00151\u0017G1\u0001h\u0003%\t'O]1z?\u0012*\u0017\u000f\u0006\u0003\u0002\u0014\u0006E\u0006\"CANm\u0005\u0005\t\u0019AAR\u0003\u0019\t'O]1zA\u0005!a.\u001a=u+\t\tI\fE\u0003\u0002FE\nI+\u0001\u0005oKb$x\fJ3r)\u0011\t\u0019*a0\t\u0013\u0005m\u0015(!AA\u0002\u0005e\u0016!\u00028fqR\u0004\u0013\u0001\u00022vM\u001a,\"!a2\u0011\t\u0001\u0004\u0011\u0011V\u0001\u0006EV4g\rI\u0001\u000bKZLG-\u001a8dK\u0012\n\u0004CBA\u0007\u0003'\tI\u000b\u0006\u0006\u0002R\u0006U\u0017q[Am\u00037$B!!/\u0002T\"9\u00111\u001a A\u0004\u00055\u0007bBAG}\u0001\u0007\u0011\u0011\u000f\u0005\b\u0003?s\u0004\u0019AAR\u0011\u001d\t)L\u0010a\u0001\u0003sC\u0011\"a1?!\u0003\u0005\r!a2\u0015\u0005\u0005}G\u0003BA]\u0003CD\u0011\"a9@\u0003\u0003\u0005\u001d!!4\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$#\u0007\u0006\u0003\u0002h\u00065H\u0003BA]\u0003SD\u0011\"a;A\u0003\u0003\u0005\u001d!!4\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$3\u0007C\u0004\u0002p\u0002\u0003\r!a2\u0002\u0003\t\f!B\\3yi2,gn\u001a;i\u0003\u0019\t\u0007\u000f]3oIR!\u0011\u0011XA|\u0011\u001d\tIP\u0011a\u0001\u0003S\u000bA!\u001a7f[\"\u001a!)!@\u0011\t\u0005}(QA\u0007\u0003\u0005\u0003Q1Aa\u0001[\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0005\u000f\u0011\tAA\u0004uC&d'/Z2\u0002\u000f\u0019|'/Z1dQV!!Q\u0002B\u000e)\u0011\t\u0019Ja\u0004\t\u000f\tE1\t1\u0001\u0003\u0014\u0005\ta\rE\u0004j\u0005+\tIK!\u0007\n\u0007\t]!LA\u0005Gk:\u001cG/[8ocA\u0019AMa\u0007\u0005\r\tu1I1\u0001h\u0005\u0005)\u0016!B1qa2LH\u0003BAU\u0005GAqA!\nE\u0001\u0004\t\t(A\u0002jIbD3\u0001RA\u007f\u0003\u0019)\b\u000fZ1uKR1\u00111\u0013B\u0017\u0005_AqA!\nF\u0001\u0004\t\t\bC\u0004\u00032\u0015\u0003\r!!+\u0002\u000f9,w/\u001a7f[\"\u001aQ)!@\u0002\r1|7-\u0019;f)\u0011\tIL!\u000f\t\u000f\t\u0015b\t1\u0001\u0002r!\u001aa)!@\u0002\u000fA\u0014X\r]3oIR!\u0011\u0011\u0018B!\u0011\u001d\tIp\u0012a\u0001\u0003S\u000b!b\u001d5jMR\u0014\u0018n\u001a5u)\t\t\u0019*\u0001\u0004sK6|g/\u001a\u000b\u0007\u0003S\u0013YE!\u0014\t\u000f\t\u0015\u0012\n1\u0001\u0002r!9!qJ%A\u0002\u0005\u001d\u0017A\u00022vM\u001a,'\u000fK\u0002J\u0003{\f\u0011b\u001d5jMRdWM\u001a;\u0015\t\u0005M%q\u000b\u0005\b\u00053R\u0005\u0019AA9\u0003\u0015aWM\u001a;c\u0003A!(/_'fe\u001e,w+\u001b;i\u001d\u0016DH\u000f\u0006\u0002\u0003`A\u0019\u0011N!\u0019\n\u0007\t\r$LA\u0004C_>dW-\u00198\u0002\u0013%t7/\u001a:u\u00032dG\u0003CAJ\u0005S\u0012YG!\u001e\t\u000f\t\u0015B\n1\u0001\u0002r!9\u0011q\u000b'A\u0002\t5\u0004C\u0002B8\u0005c\nI+D\u0001Y\u0013\r\u0011\u0019\b\u0017\u0002\f)J\fg/\u001a:tC\ndW\rC\u0004\u0003P1\u0003\r!a2)\u00071\u000bi0A\u0004ok2dw.\u001e;\u0015\r\u0005M%Q\u0010BA\u0011\u001d\u0011y(\u0014a\u0001\u0003c\nAA\u001a:p[\"9!1Q'A\u0002\u0005E\u0014!B;oi&d\u0017\u0001\u00022j]\u0012$BAa\u0018\u0003\n\"9!1\u0012(A\u0002\u0005e\u0016\u0001\u0003;iCRDW-\u00193\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"A!%\u0011\t\tM%QT\u0007\u0003\u0005+SAAa&\u0003\u001a\u0006!A.\u00198h\u0015\t\u0011Y*\u0001\u0003kCZ\f\u0017\u0002\u0002BP\u0005+\u0013aa\u0015;sS:<\u0017\u0001C+oe>dG.\u001a3\u0011\u0007\u0005\u0015\u0013kE\u0002R\u0003\u000f#\"Aa)\u00027\u0011bWm]:j]&$He\u001a:fCR,'\u000f\n3fM\u0006,H\u000e\u001e\u00135+\u0011\u0011iK!2\u0016\u0005\t=&\u0006\u0002BY\u0005o\u00032!\u001bBZ\u0013\r\u0011)L\u0017\u0002\u0005\u001dVdGn\u000b\u0002\u0003:B!!1\u0018Ba\u001b\t\u0011iL\u0003\u0003\u0003@\n\u0005\u0011!C;oG\",7m[3e\u0013\u0011\u0011\u0019M!0\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW\rB\u0003g'\n\u0007q-A\u0006sK\u0006$'+Z:pYZ,GC\u0001Bf!\u0011\u0011\u0019J!4\n\t\t='Q\u0013\u0002\u0007\u001f\nTWm\u0019;\u0002\u0017!,\u0017\r\u001a9ue~#S-\u001d\u000b\u0005\u0003'\u0013)\u000eC\u0005\u0002\u001c\u0016\t\t\u00111\u0001\u0002&\u0005A\u0001.Z1eaR\u0014\b\u0005K\u0002\u0007\u00057\u00042!\u001bBo\u0013\r\u0011yN\u0017\u0002\niJ\fgn]5f]R\fq\u0001\\1tiB$(/A\u0006mCN$\b\u000f\u001e:`I\u0015\fH\u0003BAJ\u0005OD\u0011\"a'\t\u0003\u0003\u0005\r!!\n\u0002\u00111\f7\u000f\u001e9ue\u0002B3!\u0003Bn\u0003\t\u0019(0\u0001\u0004tu~#S-\u001d\u000b\u0005\u0003'\u0013\u0019\u0010C\u0005\u0002\u001c.\t\t\u00111\u0001\u0002r\u0005\u00191O\u001f\u0011)\u00071\u0011Y.A\u0004iK\u0006$\u0007\u000b\u001e:\u0002\u0017!,\u0017\r\u001a)ue~#S-\u001d\u000b\u0005\u0003'\u0013y\u0010C\u0004\u0004\u00029\u0001\r!!\n\u0002\t!,\u0017\rZ\u0001\bY\u0006\u001cH\u000f\u0015;s\u0003-a\u0017m\u001d;QiJ|F%Z9\u0015\t\u0005M5\u0011\u0002\u0005\b\u0007\u0017\u0001\u0002\u0019AA\u0013\u0003\u0011a\u0017m\u001d;\u0015\t\u0005M5q\u0002\u0005\b\u0007#\t\u0002\u0019AA9\u0003\u0005\u0019X#A;\u0002\u00179,w/\u00168s_2dW\rZ\u0001\u000fG\u0006d7MT3yi2+gn\u001a;i)\u0011\t\tha\u0007\t\u000f\t5H\u00031\u0001\u0002r\u0005\t2\r\\1tgR\u000bwmQ8na\u0006t\u0017n\u001c8\u0016\u0005\u0005\u001d\u0012AB2p]\u000e\fG\u000fF\u0002v\u0007KAaaa\n\u0017\u0001\u0004)\u0018\u0001\u0002;iCR\f\u0001\u0002\n9mkN$S-\u001d\u000b\u0005\u0007[\u0019y#D\u0001\u0001\u0011\u0019\tIp\u0006a\u0001G\u0006)1\r\\3be\u0006A\u0011\u000e^3sCR|'/\u0006\u0002\u00048A)!qNB\u001dG&\u001911\b-\u0003\u0011%#XM]1u_J,Baa\u0010\u0004HQ!\u00111SB!\u0011\u001d\u0011\tB\u0007a\u0001\u0007\u0007\u0002b!\u001bB\u000bG\u000e\u0015\u0003c\u00013\u0004H\u00111!Q\u0004\u000eC\u0002\u001d\faA]3tk2$H#A;\u0002\r1,gn\u001a;i)\r\u00197\u0011\u000b\u0005\b\u0005Ki\u0002\u0019AA9)\u0019\t\u0019j!\u0016\u0004X!9!Q\u0005\u0010A\u0002\u0005E\u0004B\u0002B\u0019=\u0001\u00071\rF\u0002d\u00077BqA!\n \u0001\u0004\t\t(\u0001\b%a2,8\u000fJ3rI\r|Gn\u001c8\u0015\t\r52\u0011\r\u0005\u0007\u0003s\u0004\u0003\u0019A2\u0015\r\u0005M5QMB4\u0011\u001d\u0011)#\ta\u0001\u0003cBqa!\u001b\"\u0001\u0004\u0019Y'A\u0003fY\u0016l7\u000fE\u0003\u0003p\tE4-A\u0006xe&$Xm\u00142kK\u000e$H\u0003BAJ\u0007cBqaa\u001d#\u0001\u0004\u0019)(A\u0002pkR\u0004Baa\u001e\u0004~5\u00111\u0011\u0010\u0006\u0005\u0007w\u0012I*\u0001\u0002j_&!1qPB=\u0005Iy%M[3di>+H\u000f];u'R\u0014X-Y7\u0002\u0015I,\u0017\rZ(cU\u0016\u001cG\u000f\u0006\u0003\u0002\u0014\u000e\u0015\u0005bBBDG\u0001\u00071\u0011R\u0001\u0003S:\u0004Baa\u001e\u0004\f&!1QRB=\u0005Ey%M[3di&s\u0007/\u001e;TiJ,\u0017-\\\u0001\u0006G2|g.Z\u0001\rgR\u0014\u0018N\\4Qe\u00164\u0017\u000e_\u000b\u0003\u0005#K3\u0001ABL\u0013\r\u0019IJ\u0016\u0002\u0017\t>,(\r\\5oOVs'o\u001c7mK\u0012\u0014UO\u001a4fe\":\u0001a!(\u0004$\u000e\u0015\u0006cA5\u0004 &\u00191\u0011\u0015.\u0003!M+'/[1m-\u0016\u00148/[8o+&#\u0015!\u0002<bYV,g$A\u0001")
public class UnrolledBuffer<T>
extends AbstractBuffer<T>
implements GenericClassTagTraversableTemplate<T, UnrolledBuffer>,
Builder<T, UnrolledBuffer<T>>,
Serializable {
    public static final long serialVersionUID = 1L;
    private final ClassTag<T> tag;
    private transient Unrolled<T> scala$collection$mutable$UnrolledBuffer$$headptr;
    private transient Unrolled<T> lastptr;
    private transient int sz;

    public static int waterlineDelim() {
        return UnrolledBuffer$.MODULE$.waterlineDelim();
    }

    public static int waterline() {
        return UnrolledBuffer$.MODULE$.waterline();
    }

    public static <T> CanBuildFrom<UnrolledBuffer<?>, T, UnrolledBuffer<T>> canBuildFrom(ClassTag<T> classTag) {
        return UnrolledBuffer$.MODULE$.canBuildFrom(classTag);
    }

    public static Traversable empty(ClassTag classTag) {
        return UnrolledBuffer$.MODULE$.empty(classTag);
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
    public <NewTo> Builder<T, NewTo> mapResult(Function1<UnrolledBuffer<T>, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public <B> Builder<B, UnrolledBuffer<B>> genericClassTagBuilder(ClassTag<B> tag) {
        return GenericClassTagTraversableTemplate.genericClassTagBuilder$(this, tag);
    }

    @Override
    public GenericClassTagCompanion<UnrolledBuffer> classManifestCompanion() {
        return GenericClassTagTraversableTemplate.classManifestCompanion$(this);
    }

    @Override
    public <B> Builder<B, UnrolledBuffer<B>> genericClassManifestBuilder(ClassTag<B> manifest) {
        return GenericClassTagTraversableTemplate.genericClassManifestBuilder$(this, manifest);
    }

    @Override
    public ClassTag<T> tag() {
        return this.tag;
    }

    public Unrolled<T> scala$collection$mutable$UnrolledBuffer$$headptr() {
        return this.scala$collection$mutable$UnrolledBuffer$$headptr;
    }

    private void scala$collection$mutable$UnrolledBuffer$$headptr_$eq(Unrolled<T> x$1) {
        this.scala$collection$mutable$UnrolledBuffer$$headptr = x$1;
    }

    private Unrolled<T> lastptr() {
        return this.lastptr;
    }

    private void lastptr_$eq(Unrolled<T> x$1) {
        this.lastptr = x$1;
    }

    private int sz() {
        return this.sz;
    }

    private void sz_$eq(int x$1) {
        this.sz = x$1;
    }

    public Unrolled<T> headPtr() {
        return this.scala$collection$mutable$UnrolledBuffer$$headptr();
    }

    public void headPtr_$eq(Unrolled<T> head) {
        this.scala$collection$mutable$UnrolledBuffer$$headptr_$eq(head);
    }

    public Unrolled<T> lastPtr() {
        return this.lastptr();
    }

    public void lastPtr_$eq(Unrolled<T> last) {
        this.lastptr_$eq(last);
    }

    public void size_$eq(int s) {
        this.sz_$eq(s);
    }

    public UnrolledBuffer<T> newBuilder() {
        return new UnrolledBuffer<T>(this.tag());
    }

    public Unrolled<T> newUnrolled() {
        return new Unrolled<T>(this, this.tag());
    }

    public int calcNextLength(int sz) {
        return sz;
    }

    public UnrolledBuffer$ classTagCompanion() {
        return UnrolledBuffer$.MODULE$;
    }

    public UnrolledBuffer<T> concat(UnrolledBuffer<T> that) {
        if (!this.lastptr().bind(that.scala$collection$mutable$UnrolledBuffer$$headptr())) {
            this.lastptr_$eq(that.lastPtr());
        }
        this.sz_$eq(this.sz() + super.sz());
        that.clear();
        return this;
    }

    @Override
    public UnrolledBuffer<T> $plus$eq(T elem) {
        this.lastptr_$eq(this.lastptr().append(elem));
        this.sz_$eq(this.sz() + 1);
        return this;
    }

    @Override
    public void clear() {
        this.scala$collection$mutable$UnrolledBuffer$$headptr_$eq(this.newUnrolled());
        this.lastptr_$eq(this.scala$collection$mutable$UnrolledBuffer$$headptr());
        this.sz_$eq(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this){
            private int pos;
            private Unrolled<T> node;

            private int pos() {
                return this.pos;
            }

            private void pos_$eq(int x$1) {
                this.pos = x$1;
            }

            private Unrolled<T> node() {
                return this.node;
            }

            private void node_$eq(Unrolled<T> x$1) {
                this.node = x$1;
            }

            private void scan() {
                this.pos_$eq(this.pos() + 1);
                while (this.pos() >= this.node().size()) {
                    this.pos_$eq(0);
                    this.node_$eq(this.node().next());
                    if (this.node() != null) continue;
                    return;
                }
            }

            public boolean hasNext() {
                return this.node() != null;
            }

            /*
             * WARNING - void declaration
             */
            public T next() {
                if (this.hasNext()) {
                    void var1_1;
                    Object r = ScalaRunTime$.MODULE$.array_apply(this.node().array(), this.pos());
                    this.scan();
                    return var1_1;
                }
                return (T)Iterator$.MODULE$.empty().next();
            }
            {
                this.pos = -1;
                this.node = $outer.scala$collection$mutable$UnrolledBuffer$$headptr();
                this.scan();
            }
        };
    }

    @Override
    public <U> void foreach(Function1<T, U> f) {
        this.scala$collection$mutable$UnrolledBuffer$$headptr().foreach(f);
    }

    @Override
    public UnrolledBuffer<T> result() {
        return this;
    }

    @Override
    public int length() {
        return this.sz();
    }

    @Override
    public T apply(int idx) {
        if (idx >= 0 && idx < this.sz()) {
            return this.scala$collection$mutable$UnrolledBuffer$$headptr().apply(idx);
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
    }

    @Override
    public void update(int idx, T newelem) {
        if (idx >= 0 && idx < this.sz()) {
            this.scala$collection$mutable$UnrolledBuffer$$headptr().update(idx, newelem);
            return;
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
    }

    @Override
    public T remove(int idx) {
        if (idx >= 0 && idx < this.sz()) {
            this.sz_$eq(this.sz() - 1);
            return this.scala$collection$mutable$UnrolledBuffer$$headptr().remove(idx, this);
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
    }

    @Override
    public UnrolledBuffer<T> $plus$eq$colon(T elem) {
        this.scala$collection$mutable$UnrolledBuffer$$headptr_$eq(this.scala$collection$mutable$UnrolledBuffer$$headptr().prepend(elem));
        this.sz_$eq(this.sz() + 1);
        return this;
    }

    @Override
    public void insertAll(int idx, Traversable<T> elems) {
        if (idx >= 0 && idx <= this.sz()) {
            this.scala$collection$mutable$UnrolledBuffer$$headptr().insertAll(idx, elems, this);
            this.sz_$eq(this.sz() + elems.size());
            return;
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
    }

    private void writeObject(ObjectOutputStream out) {
        out.defaultWriteObject();
        out.writeInt(this.sz());
        this.foreach((Function1)(Function1<Object, Object> & java.io.Serializable & Serializable)elem -> {
            out.writeObject(elem);
            return BoxedUnit.UNIT;
        });
    }

    private void readObject(ObjectInputStream in) {
        in.defaultReadObject();
        int num = in.readInt();
        this.headPtr_$eq(this.newUnrolled());
        this.lastPtr_$eq(this.headPtr());
        this.sz_$eq(0);
        for (int i = 0; i < num; ++i) {
            this.$plus$eq(in.readObject());
        }
    }

    @Override
    public UnrolledBuffer<T> clone() {
        return (UnrolledBuffer)new UnrolledBuffer<T>(this.tag()).$plus$plus$eq(this);
    }

    @Override
    public String stringPrefix() {
        return "UnrolledBuffer";
    }

    public UnrolledBuffer(ClassTag<T> tag) {
        this.tag = tag;
        GenericClassTagTraversableTemplate.$init$(this);
        Builder.$init$(this);
        this.scala$collection$mutable$UnrolledBuffer$$headptr = this.newUnrolled();
        this.lastptr = this.scala$collection$mutable$UnrolledBuffer$$headptr();
        this.sz = 0;
    }

    public static class Unrolled<T> {
        private int size;
        private Object array;
        private Unrolled<T> next;
        private final UnrolledBuffer<T> buff;
        private final ClassTag<T> evidence$1;

        public int size() {
            return this.size;
        }

        public void size_$eq(int x$1) {
            this.size = x$1;
        }

        public Object array() {
            return this.array;
        }

        public void array_$eq(Object x$1) {
            this.array = x$1;
        }

        public Unrolled<T> next() {
            return this.next;
        }

        public void next_$eq(Unrolled<T> x$1) {
            this.next = x$1;
        }

        public UnrolledBuffer<T> buff() {
            return this.buff;
        }

        private int nextlength() {
            if (this.buff() == null) {
                return UnrolledBuffer$.MODULE$.unrolledlength();
            }
            return this.buff().calcNextLength(ScalaRunTime$.MODULE$.array_length(this.array()));
        }

        public final Unrolled<T> append(T elem) {
            while (true) {
                if (this_.size() < ScalaRunTime$.MODULE$.array_length(this_.array())) {
                    ScalaRunTime$.MODULE$.array_update(this_.array(), this_.size(), elem);
                    this_.size_$eq(this_.size() + 1);
                    return this_;
                }
                this_.next_$eq(new Unrolled<T>(0, this_.evidence$1.newArray(this_.nextlength()), null, this_.buff(), this_.evidence$1));
                Unrolled<T> this_ = this_.next();
            }
        }

        public <U> void foreach(Function1<T, U> f) {
            int i = 0;
            for (Unrolled<T> unrolled = this; unrolled != null; unrolled = unrolled.next()) {
                Object chunkarr = unrolled.array();
                int chunksz = unrolled.size();
                while (i < chunksz) {
                    Object elem = ScalaRunTime$.MODULE$.array_apply(chunkarr, i);
                    f.apply(elem);
                    ++i;
                }
                i = 0;
            }
        }

        public final T apply(int idx) {
            while (idx >= this_.size()) {
                idx -= this_.size();
                Unrolled<T> this_ = this_.next();
            }
            return (T)ScalaRunTime$.MODULE$.array_apply(this_.array(), idx);
        }

        public final void update(int idx, T newelem) {
            while (true) {
                if (idx < this_.size()) {
                    ScalaRunTime$.MODULE$.array_update(this_.array(), idx, newelem);
                    return;
                }
                idx -= this_.size();
                Unrolled<T> this_ = this_.next();
            }
        }

        public final Unrolled<T> locate(int idx) {
            while (idx >= this_.size()) {
                idx -= this_.size();
                Unrolled<T> this_ = this_.next();
            }
            return this_;
        }

        /*
         * WARNING - void declaration
         */
        public Unrolled<T> prepend(T elem) {
            void var2_2;
            if (this.size() < ScalaRunTime$.MODULE$.array_length(this.array())) {
                this.shiftright();
                ScalaRunTime$.MODULE$.array_update(this.array(), 0, elem);
                this.size_$eq(this.size() + 1);
                return this;
            }
            Unrolled<T> newhead = new Unrolled<T>(this.buff(), this.evidence$1);
            newhead.append(elem);
            newhead.next_$eq(this);
            return var2_2;
        }

        private void shiftright() {
            for (int i = this.size() - 1; i >= 0; --i) {
                ScalaRunTime$.MODULE$.array_update(this.array(), i + 1, ScalaRunTime$.MODULE$.array_apply(this.array(), i));
            }
        }

        /*
         * WARNING - void declaration
         */
        public final T remove(int idx, UnrolledBuffer<T> buffer) {
            while (true) {
                if (idx < this_.size()) {
                    void var3_3;
                    Object r = ScalaRunTime$.MODULE$.array_apply(this_.array(), idx);
                    this_.shiftleft(idx);
                    this_.size_$eq(this_.size() - 1);
                    if (this_.tryMergeWithNext()) {
                        buffer.lastPtr_$eq(this_);
                    }
                    return var3_3;
                }
                idx -= this_.size();
                Unrolled<T> this_ = this_.next();
            }
        }

        private void shiftleft(int leftb) {
            int i;
            for (i = leftb; i < this.size() - 1; ++i) {
                ScalaRunTime$.MODULE$.array_update(this.array(), i, ScalaRunTime$.MODULE$.array_apply(this.array(), i + 1));
            }
            this.nullout(i, i + 1);
        }

        public boolean tryMergeWithNext() {
            if (this.next() != null && this.size() + this.next().size() < ScalaRunTime$.MODULE$.array_length(this.array()) * UnrolledBuffer$.MODULE$.waterline() / UnrolledBuffer$.MODULE$.waterlineDelim()) {
                Array$.MODULE$.copy(this.next().array(), 0, this.array(), this.size(), this.next().size());
                this.size_$eq(this.size() + this.next().size());
                this.next_$eq(this.next().next());
                return this.next() == null;
            }
            return false;
        }

        public final void insertAll(int idx, Traversable<T> t, UnrolledBuffer<T> buffer) {
            while (true) {
                if (idx < this_.size()) {
                    Unrolled<T> newnextnode = new Unrolled<T>(0, this_.evidence$1.newArray(ScalaRunTime$.MODULE$.array_length(this_.array())), null, this_.buff(), this_.evidence$1);
                    Array$.MODULE$.copy(this_.array(), idx, newnextnode.array(), 0, this_.size() - idx);
                    newnextnode.size_$eq(this_.size() - idx);
                    newnextnode.next_$eq(this_.next());
                    super.nullout(idx, this_.size());
                    this_.size_$eq(idx);
                    this_.next_$eq(null);
                    ObjectRef curr = ObjectRef.create(this_);
                    t.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A elem) -> {
                        curr.elem = ((Unrolled)curr.elem).append(elem);
                        return BoxedUnit.UNIT;
                    });
                    ((Unrolled)curr.elem).next_$eq(newnextnode);
                    if (((Unrolled)curr.elem).tryMergeWithNext()) {
                        buffer.lastPtr_$eq((Unrolled)curr.elem);
                        return;
                    }
                    if (newnextnode.next() != null) break;
                    buffer.lastPtr_$eq(newnextnode);
                    return;
                }
                if (idx == this_.size() || this_.next() == null) {
                    ObjectRef<Unrolled> curr = ObjectRef.create(this_);
                    t.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A elem) -> {
                        curr.elem = ((Unrolled)curr.elem).append(elem);
                        return BoxedUnit.UNIT;
                    });
                    return;
                }
                idx -= this_.size();
                Unrolled<T> this_ = this_.next();
            }
        }

        private void nullout(int from, int until) {
            for (int idx = from; idx < until; ++idx) {
                ScalaRunTime$.MODULE$.array_update(this.array(), idx, null);
            }
        }

        public boolean bind(Unrolled<T> thathead) {
            Predef$.MODULE$.assert(this.next() == null);
            this.next_$eq(thathead);
            return this.tryMergeWithNext();
        }

        public String toString() {
            String string = "Unrolled@%08x";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringBuilder(4).append(Predef$.MODULE$.genericArrayOps(Predef$.MODULE$.genericArrayOps(this.array()).take(this.size())).mkString(new StringBuilder(4).append(new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(System.identityHashCode(this))}))).append("[").append(this.size()).append("/").append(ScalaRunTime$.MODULE$.array_length(this.array())).append("](").toString(), ", ", ")")).append(" -> ").append((Object)(this.next() != null ? this.next().toString() : "")).toString();
        }

        public Unrolled(int size, Object array, Unrolled<T> next, UnrolledBuffer<T> buff, ClassTag<T> evidence$1) {
            this.size = size;
            this.array = array;
            this.next = next;
            this.buff = buff;
            this.evidence$1 = evidence$1;
        }

        public Unrolled(ClassTag<T> evidence$2) {
            this(0, evidence$2.newArray(UnrolledBuffer$.MODULE$.unrolledlength()), null, null, evidence$2);
        }

        public Unrolled(UnrolledBuffer<T> b, ClassTag<T> evidence$3) {
            this(0, evidence$3.newArray(UnrolledBuffer$.MODULE$.unrolledlength()), null, b, evidence$3);
        }
    }
}

