/*
 * Decompiled with CFR 0.152.
 */
package scala.util.control;

import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Serializable;
import scala.Some;
import scala.collection.Seq;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.java8.JFunction0$mcV$sp;
import scala.util.Either;
import scala.util.Failure;
import scala.util.Left;
import scala.util.Right;
import scala.util.Success;
import scala.util.Try;
import scala.util.control.Exception$;

@ScalaSignature(bytes="\u0006\u0001\u0011Us!B%K\u0011\u0003\tf!B*K\u0011\u0003!\u0006\"B-\u0002\t\u0003QV\u0001B.\u0002\u0001qCQA]\u0001\u0005\u0002MDq!!\u000b\u0002\t\u0003\tY\u0003C\u0004\u0002B\u0005!\u0019!a\u0011\t\u000f\u0005\r\u0014\u0001\"\u0001\u0002f\u0019I\u00111N\u0001\u0011\u0002\u0007\u0005\u0011Q\u000e\u0005\b\u0003_BA\u0011AA9\u0011%\tI\b\u0003b\u0001\u000e#\tY\bC\u0005\u0002\u0014\"\u0001\r\u0011\"\u0003\u0002|!I\u0011Q\u0013\u0005A\u0002\u0013%\u0011q\u0013\u0005\b\u0003;CA\u0011AA>\u0011\u001d\ty\n\u0003C\u0001\u0003CCq!!+\t\t\u0003\nYK\u0002\u0004\u0002<\u0006\u0001\u0011Q\u0018\u0005\u000b\u0003\u0003\u0004\"\u0011!S\u0001\n\u0005\r\u0007bB-\u0011\t\u0003\t\u0011\u0011\u001a\u0005\n\u0003s\u0002\"\u0019!C\t\u0003\u001fD\u0001\"!5\u0011A\u0003%\u0011Q\u0016\u0005\b\u0003'\u0004B\u0011AAk\u0011\u001d\tY\u000e\u0005C\u0001\u0003c2a!!8\u0002\u0001\u0005}\u0007BCA0/\t\u0015\r\u0011\"\u0001\u0002d\"Q\u00111^\f\u0003\u0002\u0003\u0006I!!:\t\u0015\u00055xC!b\u0001\n\u0003\ty\u000f\u0003\u0006\u0002x^\u0011\t\u0011)A\u0005\u0003cD!\"!?\u0018\u0005\u000b\u0007I\u0011AA~\u0011)\tip\u0006B\u0001B\u0003%\u00111\b\u0005\u00073^!\t!a@\t\u0013\u0005etC1A\u0005\u0012\u0005=\u0007\u0002CAi/\u0001\u0006I!!,\t\u000f\t%q\u0003\"\u0001\u0003\f!9!\u0011B\f\u0005\u0002\t}\u0001b\u0002B\u0016/\u0011\u0005!Q\u0006\u0005\b\u0005s9B\u0011\u0001B\u001e\u0011\u001d\u0011yd\u0006C\u0001\u0005\u0003BqAa\u0014\u0018\t\u0003\u0011\t\u0006C\u0004\u0003f]!\tAa\u001a\t\u000f\tet\u0003\"\u0001\u0003|!9!\u0011R\f\u0005\u0002\t-\u0005b\u0002BI/\u0011\u0005!1\u0013\u0005\b\u00053;B\u0011\u0001BN\u000f%\u0011\t+AA\u0001\u0012\u0003\u0011\u0019KB\u0005\u0002^\u0006\t\t\u0011#\u0001\u0003&\"1\u0011,\fC\u0001\u0005OC\u0011B!+.#\u0003%\tAa+\t\u0013\t\u0015W&%A\u0005\u0002\t\u001d\u0007\"\u0003Bh\u0003\t\u0007IQ\u0001Bi\u0011!\u0011).\u0001Q\u0001\u000e\tM\u0007b\u0002Bl\u0003\u0011\u0015!\u0011\u001c\u0005\b\u0005G\fAQ\u0001Bs\u0011%\u0011y/\u0001b\u0001\n\u000b\u0011\t\u0010\u0003\u0005\u0003v\u0006\u0001\u000bQ\u0002Bz\u0011\u001d\u001190\u0001C\u0003\u0005sDqaa\u0001\u0002\t\u000b\u0019)\u0001C\u0004\u0004\u0010\u0005!\ta!\u0005\t\u000f\r=\u0011\u0001\"\u0001\u00044!911I\u0001\u0005\u0002\r\u0015\u0003bBB\"\u0003\u0011\u00051Q\f\u0005\b\u0007W\nA\u0011AB7\u0011\u001d\u0019y(\u0001C\u0001\u0007\u0003Cqaa'\u0002\t\u0003\u0019iJ\u0002\u0004\u0004>\u0006\u00011q\u0018\u0005\u000b\u0003K\u0001%\u0011!Q\u0001\n\r\r\u0007BB-A\t\u0003\u0019y\rC\u0004\u0004V\u0002#\taa6\t\u000f\rm\u0017\u0001\"\u0001\u0004^\"91\u0011`\u0001\u0005\u0002\rm\bb\u0002C\u0004\u0003\u0011\u0005A\u0011\u0002\u0005\b\tC\tA\u0011\u0002C\u0012\u0011\u001d!\t%\u0001C\u0005\t\u0007\n\u0011\"\u0012=dKB$\u0018n\u001c8\u000b\u0005-c\u0015aB2p]R\u0014x\u000e\u001c\u0006\u0003\u001b:\u000bA!\u001e;jY*\tq*A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005I\u000bQ\"\u0001&\u0003\u0013\u0015C8-\u001a9uS>t7CA\u0001V!\t1v+D\u0001O\u0013\tAfJ\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003E\u0013qaQ1uG\",'/\u0006\u0002^SB!aK\u00181h\u0013\tyfJA\bQCJ$\u0018.\u00197Gk:\u001cG/[8o!\t\tGM\u0004\u0002WE&\u00111MT\u0001\ba\u0006\u001c7.Y4f\u0013\t)gMA\u0005UQJ|w/\u00192mK*\u00111M\u0014\t\u0003Q&d\u0001\u0001\u0002\u0004k\u0007\u0011\u0015\ra\u001b\u0002\u0002)F\u0011An\u001c\t\u0003-6L!A\u001c(\u0003\u000f9{G\u000f[5oOB\u0011a\u000b]\u0005\u0003c:\u00131!\u00118z\u0003%i7nQ1uG\",'/\u0006\u0003u\u0003\u001baH#B;\u0002\u0014\u0005\rBC\u0001<~%\r9X+\u001f\u0004\u0005q\u0012\u0001aO\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0002{\u0007ml\u0011!\u0001\t\u0003Qr$QA\u001b\u0003C\u0002-DqA \u0003\u0002\u0002\u0003\u000fq0\u0001\u0006fm&$WM\\2fIE\u0002b!!\u0001\u0002\b\u0005-QBAA\u0002\u0015\r\t)AT\u0001\be\u00164G.Z2u\u0013\u0011\tI!a\u0001\u0003\u0011\rc\u0017m]:UC\u001e\u00042\u0001[A\u0007\t\u001d\ty\u0001\u0002b\u0001\u0003#\u0011!!\u0012=\u0012\u00051\u0004\u0007bBA\u000b\t\u0001\u0007\u0011qC\u0001\u0006SN$UM\u001a\t\b-\u0006e\u00111BA\u000f\u0013\r\tYB\u0014\u0002\n\rVt7\r^5p]F\u00022AVA\u0010\u0013\r\t\tC\u0014\u0002\b\u0005>|G.Z1o\u0011\u001d\t)\u0003\u0002a\u0001\u0003O\t\u0011A\u001a\t\u0007-\u0006e\u00111B>\u0002%5\\G\u000b\u001b:po\u0006\u0014G.Z\"bi\u000eDWM]\u000b\u0005\u0003[\t9\u0004\u0006\u0004\u00020\u0005e\u0012Q\b\n\u0006\u0003c)\u00161\u0007\u0004\u0006q\u0012\u0001\u0011q\u0006\t\u0005u\u000e\t)\u0004E\u0002i\u0003o!QA[\u0003C\u0002-Dq!!\u0006\u0006\u0001\u0004\tY\u0004\u0005\u0004W\u00033\u0001\u0017Q\u0004\u0005\b\u0003K)\u0001\u0019AA !\u00191\u0016\u0011\u00041\u00026\u0005IB\u000f\u001b:po\u0006\u0014G.Z*vERL\b/\u001a+p\u0007\u0006$8\r[3s+\u0019\t)%a\u0017\u0002RQ!\u0011qIA/)\u0011\tI%a\u0015\u0013\u000b\u0005-S+!\u0014\u0007\u000ba$\u0001!!\u0013\u0011\ti\u001c\u0011q\n\t\u0004Q\u0006EC!\u00026\u0007\u0005\u0004Y\u0007\"CA+\r\u0005\u0005\t9AA,\u0003))g/\u001b3f]\u000e,GE\r\t\u0007\u0003\u0003\t9!!\u0017\u0011\u0007!\fY\u0006B\u0004\u0002\u0010\u0019\u0011\r!!\u0005\t\u000f\u0005}c\u00011\u0001\u0002b\u0005\u0011\u0001O\u001a\t\u0007-z\u000bI&a\u0014\u0002\u001bMDw.\u001e7e%\u0016$\bN]8x)\u0011\ti\"a\u001a\t\r\u0005%t\u00011\u0001a\u0003\u0005A(!\u0003#fg\u000e\u0014\u0018NY3e'\tAQ+\u0001\u0004%S:LG\u000f\n\u000b\u0003\u0003g\u00022AVA;\u0013\r\t9H\u0014\u0002\u0005+:LG/\u0001\u0003oC6,WCAA?!\u0011\ty(!$\u000f\t\u0005\u0005\u0015\u0011\u0012\t\u0004\u0003\u0007sUBAAC\u0015\r\t9\tU\u0001\u0007yI|w\u000e\u001e \n\u0007\u0005-e*\u0001\u0004Qe\u0016$WMZ\u0005\u0005\u0003\u001f\u000b\tJ\u0001\u0004TiJLgn\u001a\u0006\u0004\u0003\u0017s\u0015!B0eKN\u001c\u0017!C0eKN\u001cw\fJ3r)\u0011\t\u0019(!'\t\u0013\u0005mE\"!AA\u0002\u0005u\u0014a\u0001=%c\u0005!A-Z:d\u0003!9\u0018\u000e\u001e5EKN\u001cG\u0003BAR\u0003Kk\u0011\u0001\u0003\u0005\b\u0003Os\u0001\u0019AA?\u0003\u0005\u0019\u0018\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u00055\u0006\u0003BAX\u0003sk!!!-\u000b\t\u0005M\u0016QW\u0001\u0005Y\u0006twM\u0003\u0002\u00028\u0006!!.\u0019<b\u0013\u0011\ty)!-\u0003\u000f\u0019Kg.\u00197msN!\u0001#VA`!\tQ\b\"\u0001\u0003c_\u0012L\b#\u0002,\u0002F\u0006M\u0014bAAd\u001d\nAAHY=oC6,g\b\u0006\u0003\u0002L\u00065\u0007C\u0001>\u0011\u0011!\t\tM\u0005CA\u0002\u0005\rWCAAW\u0003\u0015q\u0017-\\3!\u0003\r\tg\u000e\u001a\u000b\u0005\u0003\u0017\f9\u000e\u0003\u0005\u0002ZV!\t\u0019AAb\u0003\u0015yG\u000f[3s\u0003\u0019IgN^8lK\n)1)\u0019;dQV!\u0011\u0011]Au'\u00119R+a0\u0016\u0005\u0005\u0015\b\u0003\u0002>\u0004\u0003O\u00042\u0001[Au\t\u0019Qw\u0003\"b\u0001W\u0006\u0019\u0001O\u001a\u0011\u0002\u0007\u0019Lg.\u0006\u0002\u0002rB)a+a=\u0002L&\u0019\u0011Q\u001f(\u0003\r=\u0003H/[8o\u0003\u00111\u0017N\u001c\u0011\u0002\u000fI,G\u000f\u001b:poV\u0011\u00111H\u0001\te\u0016$\bN]8xAQA!\u0011\u0001B\u0002\u0005\u000b\u00119\u0001\u0005\u0003{/\u0005\u001d\bbBA0=\u0001\u0007\u0011Q\u001d\u0005\n\u0003[t\u0002\u0013!a\u0001\u0003cD\u0011\"!?\u001f!\u0003\u0005\r!a\u000f\u0002\u0005=\u0014X\u0003\u0002B\u0007\u0005'!BAa\u0004\u0003\u001aA!!p\u0006B\t!\rA'1\u0003\u0003\b\u0005+\t#\u0019\u0001B\f\u0005\u0005)\u0016cAAt_\"9!1D\u0011A\u0002\tu\u0011a\u00019geA!!p\u0001B\t+\u0011\u0011\tCa\n\u0015\t\t\r\"\u0011\u0006\t\u0005u^\u0011)\u0003E\u0002i\u0005O!qA!\u0006#\u0005\u0004\u00119\u0002C\u0004\u0002Z\n\u0002\rAa\t\u0002\u000b\u0005\u0004\b\u000f\\=\u0016\t\t=\"1\u0007\u000b\u0005\u0005c\u0011)\u0004E\u0002i\u0005g!qA!\u0006$\u0005\u0004\u00119\u0002\u0003\u0005\u0002B\u000e\"\t\u0019\u0001B\u001c!\u00151\u0016Q\u0019B\u0019\u0003)\tg\u000e\u001a$j]\u0006dG.\u001f\u000b\u0005\u0005\u0003\u0011i\u0004\u0003\u0005\u0002B\u0012\"\t\u0019AAb\u0003\ry\u0007\u000f^\u000b\u0005\u0005\u0007\u0012I\u0005\u0006\u0003\u0003F\t-\u0003#\u0002,\u0002t\n\u001d\u0003c\u00015\u0003J\u00119!QC\u0013C\u0002\t]\u0001\u0002CAaK\u0011\u0005\rA!\u0014\u0011\u000bY\u000b)Ma\u0012\u0002\r\u0015LG\u000f[3s+\u0011\u0011\u0019Fa\u0018\u0015\t\tU#\u0011\r\t\b\u0005/\u0012I\u0006\u0019B/\u001b\u0005a\u0015b\u0001B.\u0019\n1Q)\u001b;iKJ\u00042\u0001\u001bB0\t\u001d\u0011)B\nb\u0001\u0005/A\u0001\"!1'\t\u0003\u0007!1\r\t\u0006-\u0006\u0015'QL\u0001\bo&$\b\u000e\u0016:z+\u0011\u0011IGa\u001d\u0015\t\t-$Q\u000f\t\u0007\u0005/\u0012iG!\u001d\n\u0007\t=DJA\u0002Uef\u00042\u0001\u001bB:\t\u001d\u0011)b\nb\u0001\u0005/A\u0001\"!1(\t\u0003\u0007!q\u000f\t\u0006-\u0006\u0015'\u0011O\u0001\no&$\b.\u00119qYf,BA! \u0003\u0004R!!q\u0010BC!\u0011QxC!!\u0011\u0007!\u0014\u0019\t\u0002\u0004\u0003\u0016!\u0012\ra\u001b\u0005\b\u0003KA\u0003\u0019\u0001BD!\u00191\u0016\u0011\u00041\u0003\u0002\u0006AAo\\(qi&|g.\u0006\u0002\u0003\u000eB!!p\u0006BH!\u00151\u00161_At\u0003!!x.R5uQ\u0016\u0014XC\u0001BK!\u0011QxCa&\u0011\u000f\t]#\u0011\f1\u0002h\u0006)Ao\u001c+ssV\u0011!Q\u0014\t\u0005u^\u0011y\n\u0005\u0004\u0003X\t5\u0014q]\u0001\u0006\u0007\u0006$8\r\u001b\t\u0003u6\u001a\"!L+\u0015\u0005\t\r\u0016a\u0007\u0013mKN\u001c\u0018N\\5uI\u001d\u0014X-\u0019;fe\u0012\"WMZ1vYR$#'\u0006\u0003\u0003.\n\rWC\u0001BXU\u0011\t\tP!-,\u0005\tM\u0006\u0003\u0002B[\u0005\u007fk!Aa.\u000b\t\te&1X\u0001\nk:\u001c\u0007.Z2lK\u0012T1A!0O\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0005\u0003\u00149LA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016$QA[\u0018C\u0002-\f1\u0004\n7fgNLg.\u001b;%OJ,\u0017\r^3sI\u0011,g-Y;mi\u0012\u001aT\u0003\u0002Be\u0005\u001b,\"Aa3+\t\u0005m\"\u0011\u0017\u0003\u0006UB\u0012\ra[\u0001\u000f]>$\b.\u001b8h\u0007\u0006$8\r[3s+\t\u0011\u0019\u000eE\u0002{\u00071\fqB\\8uQ&twmQ1uG\",'\u000fI\u0001\u0010]>tg)\u0019;bY\u000e\u000bGo\u00195feV!!1\u001cBq+\t\u0011i\u000e\u0005\u0003{\u0007\t}\u0007c\u00015\u0003b\u0012)!n\rb\u0001W\u0006Q\u0011\r\u001c7DCR\u001c\u0007.\u001a:\u0016\t\t\u001d(Q^\u000b\u0003\u0005S\u0004BA_\u0002\u0003lB\u0019\u0001N!<\u0005\u000b)$$\u0019A6\u0002\u000f9|7)\u0019;dQV\u0011!1\u001f\t\u0004u^a\u0017\u0001\u00038p\u0007\u0006$8\r\u001b\u0011\u0002\u0011\u0005dGnQ1uG\",BAa?\u0004\u0002U\u0011!Q \t\u0005u^\u0011y\u0010E\u0002i\u0007\u0003!QA[\u001cC\u0002-\fQB\\8o\r\u0006$\u0018\r\\\"bi\u000eDW\u0003BB\u0004\u0007\u001b)\"a!\u0003\u0011\ti<21\u0002\t\u0004Q\u000e5A!\u000269\u0005\u0004Y\u0017\u0001C2bi\u000eD\u0017N\\4\u0016\t\rM1\u0011\u0004\u000b\u0005\u0007+\u0019Y\u0002\u0005\u0003{/\r]\u0001c\u00015\u0004\u001a\u0011)!.\u000fb\u0001W\"91QD\u001dA\u0002\r}\u0011AC3yG\u0016\u0004H/[8ogB)ak!\t\u0004&%\u001911\u0005(\u0003\u0015q\u0012X\r]3bi\u0016$g\b\r\u0003\u0004(\r=\u0002CBA@\u0007S\u0019i#\u0003\u0003\u0004,\u0005E%!B\"mCN\u001c\bc\u00015\u00040\u0011Y1\u0011GB\u000e\u0003\u0003\u0005\tQ!\u0001l\u0005\ryF%M\u000b\u0005\u0007k\u0019Y\u0004\u0006\u0003\u00048\ru\u0002\u0003\u0002>\u0018\u0007s\u00012\u0001[B\u001e\t\u0015Q'H1\u0001l\u0011\u001d\u0019yD\u000fa\u0001\u0007\u0003\n\u0011a\u0019\t\u0005u\u000e\u0019I$A\u000bdCR\u001c\u0007.\u001b8h!J|W.[:dk>,8\u000f\\=\u0016\t\r\u001d3Q\n\u000b\u0005\u0007\u0013\u001ay\u0005\u0005\u0003{/\r-\u0003c\u00015\u0004N\u0011)!n\u000fb\u0001W\"91QD\u001eA\u0002\rE\u0003#\u0002,\u0004\"\rM\u0003\u0007BB+\u00073\u0002b!a \u0004*\r]\u0003c\u00015\u0004Z\u0011Y11LB(\u0003\u0003\u0005\tQ!\u0001l\u0005\ryFEM\u000b\u0005\u0007?\u001a)\u0007\u0006\u0003\u0004b\r\u001d\u0004\u0003\u0002>\u0018\u0007G\u00022\u0001[B3\t\u0015QGH1\u0001l\u0011\u001d\u0019y\u0004\u0010a\u0001\u0007S\u0002BA_\u0002\u0004d\u0005A\u0011n\u001a8pe&tw\r\u0006\u0003\u0004p\rE\u0004\u0003\u0002>\u0018\u0003gBqa!\b>\u0001\u0004\u0019\u0019\bE\u0003W\u0007C\u0019)\b\r\u0003\u0004x\rm\u0004CBA@\u0007S\u0019I\bE\u0002i\u0007w\"1b! \u0004r\u0005\u0005\t\u0011!B\u0001W\n\u0019q\fJ\u001a\u0002\u000f\u0019\f\u0017\u000e\\5oOV!11QBF)\u0011\u0019)i!$\u0011\ti<2q\u0011\t\u0006-\u0006M8\u0011\u0012\t\u0004Q\u000e-E!\u00026?\u0005\u0004Y\u0007bBB\u000f}\u0001\u00071q\u0012\t\u0006-\u000e\u00052\u0011\u0013\u0019\u0005\u0007'\u001b9\n\u0005\u0004\u0002\u0000\r%2Q\u0013\t\u0004Q\u000e]EaCBM\u0007\u001b\u000b\t\u0011!A\u0003\u0002-\u00141a\u0018\u00135\u0003-1\u0017-\u001b7BgZ\u000bG.^3\u0016\t\r}5q\u0015\u000b\u0005\u0007C\u001by\u000b\u0006\u0003\u0004$\u000e%\u0006\u0003\u0002>\u0018\u0007K\u00032\u0001[BT\t\u0015QwH1\u0001l\u0011!\u0019Yk\u0010CA\u0002\r5\u0016!\u0002<bYV,\u0007#\u0002,\u0002F\u000e\u0015\u0006bBB\u000f\u007f\u0001\u00071\u0011\u0017\t\u0006-\u000e\u000521\u0017\u0019\u0005\u0007k\u001bI\f\u0005\u0004\u0002\u0000\r%2q\u0017\t\u0004Q\u000eeFaCB^\u0007_\u000b\t\u0011!A\u0003\u0002-\u00141a\u0018\u00136\u0005\t\u0011\u00150\u0006\u0004\u0004B\u000e\u001d71Z\n\u0003\u0001V\u0003rAVA\r\u0007\u000b\u001cI\rE\u0002i\u0007\u000f$QA\u001b!C\u0002-\u00042\u0001[Bf\t\u0019\u0019i\r\u0011b\u0001W\n\t!\u000b\u0006\u0003\u0004R\u000eM\u0007C\u0002>A\u0007\u000b\u001cI\rC\u0004\u0002&\t\u0003\raa1\u0002\u0005\tLH\u0003BBe\u00073Dq!!\u001bD\u0001\u0004\u0019)-\u0001\u0005iC:$G.\u001b8h+\u0011\u0019yna:\u0015\t\r\u000581\u001e\t\u0007u\u0002\u001b\u0019o!;\u0011\rY\u000bI\u0002YBs!\rA7q\u001d\u0003\u0006U\u0012\u0013\ra\u001b\t\u0005u^\u0019)\u000fC\u0004\u0004\u001e\u0011\u0003\ra!<\u0011\u000bY\u001b\tca<1\t\rE8Q\u001f\t\u0007\u0003\u007f\u001aIca=\u0011\u0007!\u001c)\u0010B\u0006\u0004x\u000e-\u0018\u0011!A\u0001\u0006\u0003Y'aA0%m\u0005QQ\u000f\u001c;j[\u0006$X\r\\=\u0016\t\ruH1\u0001\u000b\u0005\u0007\u007f$)\u0001\u0005\u0003{/\u0011\u0005\u0001c\u00015\u0005\u0004\u0011)!.\u0012b\u0001W\"A\u0011\u0011Y#\u0005\u0002\u0004\t\u0019-\u0001\u0006v]^\u0014\u0018\r\u001d9j]\u001e,B\u0001b\u0003\u0005\u0012Q!AQ\u0002C\n!\u0011Qx\u0003b\u0004\u0011\u0007!$\t\u0002B\u0003k\r\n\u00071\u000eC\u0004\u0004\u001e\u0019\u0003\r\u0001\"\u0006\u0011\u000bY\u001b\t\u0003b\u00061\t\u0011eAQ\u0004\t\u0007\u0003\u007f\u001aI\u0003b\u0007\u0011\u0007!$i\u0002B\u0006\u0005 \u0011M\u0011\u0011!A\u0001\u0006\u0003Y'aA0%o\u0005Qqo\\;mI6\u000bGo\u00195\u0015\r\u0005uAQ\u0005C\u0014\u0011\u0019\tIg\u0012a\u0001A\"9A\u0011F$A\u0002\u0011-\u0012aB2mCN\u001cXm\u001d\t\u0007\t[!\u0019\u0004b\u000e\u000e\u0005\u0011=\"b\u0001C\u0019\u001d\u0006Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u0011UBq\u0006\u0002\u0004'\u0016\f\b\u0007\u0002C\u001d\t{\u0001b!a \u0004*\u0011m\u0002c\u00015\u0005>\u0011YAq\bC\u0014\u0003\u0003\u0005\tQ!\u0001l\u0005\ryF\u0005O\u0001\u0011a\u001a4%o\\7Fq\u000e,\u0007\u000f^5p]N$B\u0001\"\u0012\u0005HA!aK\u00181m\u0011\u001d\u0019i\u0002\u0013a\u0001\t\u0013\u0002RAVB\u0011\t\u0017\u0002D\u0001\"\u0014\u0005RA1\u0011qPB\u0015\t\u001f\u00022\u0001\u001bC)\t-!\u0019\u0006b\u0012\u0002\u0002\u0003\u0005)\u0011A6\u0003\u0007}#\u0013\b")
public final class Exception {
    public static <T> Catch<T> unwrapping(Seq<Class<?>> seq) {
        return Exception$.MODULE$.unwrapping(seq);
    }

    public static <T> Catch<T> ultimately(Function0<BoxedUnit> function0) {
        return Exception$.MODULE$.ultimately(function0);
    }

    public static <T> By<Function1<Throwable, T>, Catch<T>> handling(Seq<Class<?>> seq) {
        return Exception$.MODULE$.handling(seq);
    }

    public static <T> Catch<T> failAsValue(Seq<Class<?>> seq, Function0<T> function0) {
        return Exception$.MODULE$.failAsValue(seq, function0);
    }

    public static <T> Catch<Option<T>> failing(Seq<Class<?>> seq) {
        return Exception$.MODULE$.failing(seq);
    }

    public static Catch<BoxedUnit> ignoring(Seq<Class<?>> seq) {
        return Exception$.MODULE$.ignoring(seq);
    }

    public static <T> Catch<T> catchingPromiscuously(PartialFunction<Throwable, T> partialFunction) {
        return Exception$.MODULE$.catchingPromiscuously(partialFunction);
    }

    public static <T> Catch<T> catchingPromiscuously(Seq<Class<?>> seq) {
        return Exception$.MODULE$.catchingPromiscuously(seq);
    }

    public static <T> Catch<T> catching(PartialFunction<Throwable, T> partialFunction) {
        return Exception$.MODULE$.catching(partialFunction);
    }

    public static <T> Catch<T> catching(Seq<Class<?>> seq) {
        return Exception$.MODULE$.catching(seq);
    }

    public static <T> Catch<T> nonFatalCatch() {
        return Exception$.MODULE$.nonFatalCatch();
    }

    public static <T> Catch<T> allCatch() {
        return Exception$.MODULE$.allCatch();
    }

    public static Catch<Nothing$> noCatch() {
        return Exception$.MODULE$.noCatch();
    }

    public static <T> PartialFunction<Throwable, T> allCatcher() {
        return Exception$.MODULE$.allCatcher();
    }

    public static <T> PartialFunction<Throwable, T> nonFatalCatcher() {
        return Exception$.MODULE$.nonFatalCatcher();
    }

    public static PartialFunction<Throwable, Nothing$> nothingCatcher() {
        return Exception$.MODULE$.nothingCatcher();
    }

    public static boolean shouldRethrow(Throwable throwable) {
        return Exception$.MODULE$.shouldRethrow(throwable);
    }

    public static <Ex extends Throwable, T> PartialFunction<Throwable, T> throwableSubtypeToCatcher(PartialFunction<Ex, T> partialFunction, ClassTag<Ex> classTag) {
        return Exception$.MODULE$.throwableSubtypeToCatcher(partialFunction, classTag);
    }

    public static <T> PartialFunction<Throwable, T> mkThrowableCatcher(Function1<Throwable, Object> function1, Function1<Throwable, T> function12) {
        return Exception$.MODULE$.mkThrowableCatcher(function1, function12);
    }

    public static <Ex extends Throwable, T> PartialFunction<Throwable, T> mkCatcher(Function1<Ex, Object> function1, Function1<Ex, T> function12, ClassTag<Ex> classTag) {
        return Exception$.MODULE$.mkCatcher(function1, function12, classTag);
    }

    public static class By<T, R> {
        private final Function1<T, R> f;

        public R by(T x) {
            return this.f.apply(x);
        }

        public By(Function1<T, R> f) {
            this.f = f;
        }
    }

    public static class Catch<T>
    implements Described {
        private final PartialFunction<Throwable, T> pf;
        private final Option<Finally> fin;
        private final Function1<Throwable, Object> rethrow;
        private final String name;
        private String scala$util$control$Exception$Described$$_desc;

        @Override
        public String desc() {
            return ((Described)this).desc();
        }

        @Override
        public Described withDesc(String s) {
            return ((Described)this).withDesc(s);
        }

        @Override
        public String toString() {
            return ((Described)this).toString();
        }

        @Override
        public String scala$util$control$Exception$Described$$_desc() {
            return this.scala$util$control$Exception$Described$$_desc;
        }

        @Override
        public void scala$util$control$Exception$Described$$_desc_$eq(String x$1) {
            this.scala$util$control$Exception$Described$$_desc = x$1;
        }

        public PartialFunction<Throwable, T> pf() {
            return this.pf;
        }

        public Option<Finally> fin() {
            return this.fin;
        }

        public Function1<Throwable, Object> rethrow() {
            return this.rethrow;
        }

        @Override
        public String name() {
            return this.name;
        }

        public <U> Catch<U> or(PartialFunction<Throwable, U> pf2) {
            return new Catch<U>(this.pf().orElse(pf2), this.fin(), this.rethrow());
        }

        public <U> Catch<U> or(Catch<U> other) {
            return this.or(other.pf());
        }

        public <U> U apply(Function0<U> body) {
            Object object;
            block10: {
                try {
                    try {
                        object = body.apply();
                    }
                    catch (Throwable throwable) {
                        if (BoxesRunTime.unboxToBoolean(this.rethrow().apply(throwable))) {
                            throw throwable;
                        }
                        if (this.pf().isDefinedAt(throwable)) {
                            object = this.pf().apply(throwable);
                            break block10;
                        }
                        throw throwable;
                    }
                }
                catch (Throwable throwable) {
                    Option<Finally> option = this.fin();
                    if (option == null) {
                        throw null;
                    }
                    Option<Finally> foreach_this = option;
                    if (!foreach_this.isEmpty()) {
                        Catch.$anonfun$apply$1$adapted(foreach_this.get());
                    }
                    throw throwable;
                }
            }
            Option<Finally> option = this.fin();
            if (option == null) {
                throw null;
            }
            Option<Finally> foreach_this = option;
            if (!foreach_this.isEmpty()) {
                Catch.$anonfun$apply$1$adapted(foreach_this.get());
                return object;
            }
            return object;
        }

        public Catch<T> andFinally(Function0<BoxedUnit> body) {
            Option option;
            Option option2;
            Option<Finally> option3 = this.fin();
            if (option3 == null) {
                throw null;
            }
            Option<Finally> map_this = option3;
            if (map_this.isEmpty()) {
                option2 = None$.MODULE$;
            } else {
                Finally finally_ = map_this.get();
                option2 = option = new Some<Finally>(finally_.and(body));
            }
            if (option == null) {
                throw null;
            }
            Finally appendedFin = option.isEmpty() ? Catch.$anonfun$andFinally$2(body) : option.get();
            return new Catch<T>(this.pf(), new Some<Finally>(appendedFin), this.rethrow());
        }

        public <U> Option<U> opt(Function0<U> body) {
            return (Option)this.toOption().apply((Function0<Some> & java.io.Serializable & Serializable)() -> new Some(body.apply()));
        }

        public <U> Either<Throwable, U> either(Function0<U> body) {
            return (Either)this.toEither().apply((Function0<Right> & java.io.Serializable & Serializable)() -> new Right(body.apply()));
        }

        public <U> Try<U> withTry(Function0<U> body) {
            return (Try)this.toTry().apply((Function0<Success> & java.io.Serializable & Serializable)() -> new Success(body.apply()));
        }

        public <U> Catch<U> withApply(Function1<Throwable, U> f) {
            PartialFunction pf2 = new PartialFunction<Throwable, U>(this, f){
                private final /* synthetic */ Catch $outer;
                private final Function1 f$2;

                public <A1 extends Throwable, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
                    return PartialFunction.orElse$(this, that);
                }

                public <C> PartialFunction<Throwable, C> andThen(Function1<U, C> k) {
                    return PartialFunction.andThen$(this, k);
                }

                public Function1<Throwable, Option<U>> lift() {
                    return PartialFunction.lift$(this);
                }

                public Object applyOrElse(Object x, Function1 function1) {
                    return PartialFunction.applyOrElse$(this, x, function1);
                }

                public <U> Function1<Throwable, Object> runWith(Function1<U, U> action) {
                    return PartialFunction.runWith$(this, action);
                }

                public boolean apply$mcZD$sp(double v1) {
                    return Function1.apply$mcZD$sp$(this, v1);
                }

                public double apply$mcDD$sp(double v1) {
                    return Function1.apply$mcDD$sp$(this, v1);
                }

                public float apply$mcFD$sp(double v1) {
                    return Function1.apply$mcFD$sp$(this, v1);
                }

                public int apply$mcID$sp(double v1) {
                    return Function1.apply$mcID$sp$(this, v1);
                }

                public long apply$mcJD$sp(double v1) {
                    return Function1.apply$mcJD$sp$(this, v1);
                }

                public void apply$mcVD$sp(double v1) {
                    Function1.apply$mcVD$sp$(this, v1);
                }

                public boolean apply$mcZF$sp(float v1) {
                    return Function1.apply$mcZF$sp$(this, v1);
                }

                public double apply$mcDF$sp(float v1) {
                    return Function1.apply$mcDF$sp$(this, v1);
                }

                public float apply$mcFF$sp(float v1) {
                    return Function1.apply$mcFF$sp$(this, v1);
                }

                public int apply$mcIF$sp(float v1) {
                    return Function1.apply$mcIF$sp$(this, v1);
                }

                public long apply$mcJF$sp(float v1) {
                    return Function1.apply$mcJF$sp$(this, v1);
                }

                public void apply$mcVF$sp(float v1) {
                    Function1.apply$mcVF$sp$(this, v1);
                }

                public boolean apply$mcZI$sp(int v1) {
                    return Function1.apply$mcZI$sp$(this, v1);
                }

                public double apply$mcDI$sp(int v1) {
                    return Function1.apply$mcDI$sp$(this, v1);
                }

                public float apply$mcFI$sp(int v1) {
                    return Function1.apply$mcFI$sp$(this, v1);
                }

                public int apply$mcII$sp(int v1) {
                    return Function1.apply$mcII$sp$(this, v1);
                }

                public long apply$mcJI$sp(int v1) {
                    return Function1.apply$mcJI$sp$(this, v1);
                }

                public void apply$mcVI$sp(int v1) {
                    Function1.apply$mcVI$sp$(this, v1);
                }

                public boolean apply$mcZJ$sp(long v1) {
                    return Function1.apply$mcZJ$sp$(this, v1);
                }

                public double apply$mcDJ$sp(long v1) {
                    return Function1.apply$mcDJ$sp$(this, v1);
                }

                public float apply$mcFJ$sp(long v1) {
                    return Function1.apply$mcFJ$sp$(this, v1);
                }

                public int apply$mcIJ$sp(long v1) {
                    return Function1.apply$mcIJ$sp$(this, v1);
                }

                public long apply$mcJJ$sp(long v1) {
                    return Function1.apply$mcJJ$sp$(this, v1);
                }

                public void apply$mcVJ$sp(long v1) {
                    Function1.apply$mcVJ$sp$(this, v1);
                }

                public <A> Function1<A, U> compose(Function1<A, Throwable> g) {
                    return Function1.compose$(this, g);
                }

                public String toString() {
                    return Function1.toString$(this);
                }

                public boolean isDefinedAt(Throwable x) {
                    return this.$outer.pf().isDefinedAt(x);
                }

                public U apply(Throwable x) {
                    return (U)this.f$2.apply(x);
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    this.f$2 = f$2;
                    PartialFunction.$init$(this);
                }
            };
            return new Catch<T>(pf2, this.fin(), this.rethrow());
        }

        public Catch<Option<T>> toOption() {
            return this.withApply((Function1<Throwable, None$> & java.io.Serializable & Serializable)x$3 -> None$.MODULE$);
        }

        public Catch<Either<Throwable, T>> toEither() {
            return this.withApply((Function1<Throwable, Left> & java.io.Serializable & Serializable)x$4 -> new Left((Throwable)x$4));
        }

        public Catch<Try<T>> toTry() {
            return this.withApply((Function1<Throwable, Failure> & java.io.Serializable & Serializable)x -> new Failure((Throwable)x));
        }

        public static final /* synthetic */ Finally $anonfun$andFinally$2(Function0 body$1) {
            return new Finally(body$1);
        }

        public Catch(PartialFunction<Throwable, T> pf, Option<Finally> fin, Function1<Throwable, Object> rethrow) {
            this.pf = pf;
            this.fin = fin;
            this.rethrow = rethrow;
            Described.$init$(this);
            this.name = "Catch";
        }

        public static final /* synthetic */ Object $anonfun$apply$1$adapted(Finally x$1) {
            x$1.invoke();
            return BoxedUnit.UNIT;
        }
    }

    public static interface Described {
        public String name();

        public String scala$util$control$Exception$Described$$_desc();

        public void scala$util$control$Exception$Described$$_desc_$eq(String var1);

        default public String desc() {
            return this.scala$util$control$Exception$Described$$_desc();
        }

        default public Described withDesc(String s) {
            this.scala$util$control$Exception$Described$$_desc_$eq(s);
            return this;
        }

        default public String toString() {
            return new StringBuilder(2).append(this.name()).append("(").append(this.desc()).append(")").toString();
        }

        public static void $init$(Described $this) {
            $this.scala$util$control$Exception$Described$$_desc_$eq("");
        }
    }

    public static class Finally
    implements Described {
        private final Function0<BoxedUnit> body;
        private final String name;
        private String scala$util$control$Exception$Described$$_desc;

        @Override
        public String desc() {
            return ((Described)this).desc();
        }

        @Override
        public Described withDesc(String s) {
            return ((Described)this).withDesc(s);
        }

        @Override
        public String toString() {
            return ((Described)this).toString();
        }

        @Override
        public String scala$util$control$Exception$Described$$_desc() {
            return this.scala$util$control$Exception$Described$$_desc;
        }

        @Override
        public void scala$util$control$Exception$Described$$_desc_$eq(String x$1) {
            this.scala$util$control$Exception$Described$$_desc = x$1;
        }

        @Override
        public String name() {
            return this.name;
        }

        public Finally and(Function0<BoxedUnit> other) {
            return new Finally((JFunction0$mcV$sp & Serializable)() -> {
                $this.body.apply$mcV$sp();
                other.apply$mcV$sp();
            });
        }

        public void invoke() {
            this.body.apply$mcV$sp();
        }

        public Finally(Function0<BoxedUnit> body) {
            this.body = body;
            Described.$init$(this);
            this.name = "Finally";
        }
    }
}

