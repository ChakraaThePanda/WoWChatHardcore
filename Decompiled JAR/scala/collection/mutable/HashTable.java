/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import scala.Function0;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.DebugUtils$;
import scala.collection.Iterator;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.HashEntry;
import scala.collection.mutable.HashTable$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Statics;
import scala.util.hashing.package$;

@ScalaSignature(bytes="\u0006\u0001\r\rbaB'O!\u0003\r\t!\u0016\u0005\u0006w\u0002!\t\u0001 \u0005\bY\u0002\u0001\r\u0011\"\u0005e\u0011%\t\u0019\f\u0001a\u0001\n#\t)\fC\u0005\u0002B\u0001\u0001\r\u0011\"\u0005\u0002<\"I\u0011\u0011\u001a\u0001A\u0002\u0013E\u00111\u001a\u0005\t\u0003O\u0002\u0001\u0019!C\tI\"I\u0011\u0011\u001b\u0001A\u0002\u0013E\u00111\u001b\u0005\t\u0003W\u0002\u0001\u0019!C\tI\"I\u0011\u0011\u001c\u0001A\u0002\u0013E\u00111\u001c\u0005\n\u0003g\u0002\u0001\u0019!C\t\u0003kB\u0011\"!9\u0001\u0001\u0004%\t\"a9\t\u0011\u0005=\u0004\u00011A\u0005\u0012\u0011D\u0011\"!;\u0001\u0001\u0004%\t\"a;\t\r\u0005=\b\u0001\"\u0005e\u0011\u0019\t\t\u0010\u0001C\tI\"9\u00111\u001f\u0001\u0005\n\u0005U\bBBA}\u0001\u0011%A\r\u0003\u0004\u0002|\u0002!I\u0001\u001a\u0005\t\u0003{\u0004A\u0011\u0001)\u0002\u0000\"A!q\u0004\u0001\u0005\u0002A\u0013\t\u0003C\u0004\u00038\u0001!\tB!\u000f\t\u0011\t5\u0003\u0001)C\u0005\u0005\u001fBqAa\u0016\u0001\t#\u0011I\u0006\u0003\u0005\u0003f\u0001\u0001K\u0011\u0002B4\u0011\u001d\u0011i\u0007\u0001C\t\u0005_BqAa \u0001\r#\u0011\t\tC\u0004\u0003\u000e\u0002!\tBa$\t\u000f\te\u0005\u0001\"\u0005\u0003\u001c\"9!Q\u0015\u0001\u0005\u0012\t\u001d\u0006B\u0002B\\\u0001\u0011EA\u0010C\u0004\u0003:\u0002!IAa/\t\u000f\t\u0005\u0007\u0001\"\u0005\u0003D\"9!\u0011\u001a\u0001\u0005\u0012\t-\u0007b\u0002Bi\u0001\u0011E!1\u001b\u0005\b\u00057\u0004AQ\u0001)e\u0011\u001d\u0011i\u000e\u0001C\t\u0005?DqA!:\u0001\t#\u00119\u000f\u0003\u0004\u0003l\u0002!\t\u0002 \u0005\b\u0005_\u0004A\u0011\u0001)}\u0011\u0019\u0011\t\u0010\u0001C\ty\"9!Q\u001f\u0001\u0005\u0012\t]\bbBB\u0001\u0001\u0011E!q\u001f\u0005\b\u0007\u0007\u0001A\u0011CB\u0003\u0011\u001d\u0019y\u0001\u0001C\u000b\u0007#Aqa!\u0006\u0001\t#\u00199\u0002\u0003\u0005\u0004 \u0001!\t\u0001UB\u0011\u000f\u0019qf\n#\u0001Q?\u001a1QJ\u0014E\u0001!\u0002DQ!\u0019\u0019\u0005\u0002\tDaa\u0019\u0019\u0005\u0006A#\u0007B\u000251\t\u000b\u0001F\r\u0003\u0004ja\u0011\u0015\u0001K\u001b\u0005\u0007_B\")\u0001\u00159\t\rQ\u0004DQ\u0001)v\r\u001dA\b\u0007%A\u0002\u0002eDQa_\u001c\u0005\u0002qDa!!\u00018\t+!\u0007BBA\u0002o\u0011UA\rC\u0004\u0002\u0006]\"\t\"a\u0002\t\u000f\u0005\rr\u0007\"\u0006\u0002&!A\u0011q\u0006\u0019\u0005\u0002A\u000b\tD\u0002\u0004\u00028A\u0002\u0011\u0011\b\u0005\n\u0003{q$Q1A\u0005\u0002\u0011D\u0011\"a\u0010?\u0005\u0003\u0005\u000b\u0011B3\t\u0015\u0005\u0005cH!b\u0001\n\u0003\t\u0019\u0005\u0003\u0006\u0002fy\u0012\t\u0011)A\u0005\u0003\u000bB\u0011\"a\u001a?\u0005\u000b\u0007I\u0011\u00013\t\u0013\u0005%dH!A!\u0002\u0013)\u0007\"CA6}\t\u0015\r\u0011\"\u0001e\u0011%\tiG\u0010B\u0001B\u0003%Q\rC\u0005\u0002py\u0012)\u0019!C\u0001I\"I\u0011\u0011\u000f \u0003\u0002\u0003\u0006I!\u001a\u0005\u000b\u0003gr$Q1A\u0005\u0002\u0005U\u0004BCA=}\t\u0005\t\u0015!\u0003\u0002x!1\u0011M\u0010C\u0001\u0003wB\u0001\"!$?\t\u0003\u0001\u0016q\u0012\u0002\n\u0011\u0006\u001c\b\u000eV1cY\u0016T!a\u0014)\u0002\u000f5,H/\u00192mK*\u0011\u0011KU\u0001\u000bG>dG.Z2uS>t'\"A*\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U)a+!+\u0002DN\u0019\u0001aV.\u0011\u0005aKV\"\u0001*\n\u0005i\u0013&AB!osJ+g\r\u0005\u0003]o\u0005\u001dfBA/0\u001b\u0005q\u0015!\u0003%bg\"$\u0016M\u00197f!\ti\u0006g\u0005\u00021/\u00061A(\u001b8jiz\"\u0012aX\u0001\u0012I\u00164\u0017-\u001e7u\u0019>\fGMR1di>\u0014X#A3\u0011\u0005a3\u0017BA4S\u0005\rIe\u000e^\u0001\u0010Y>\fGMR1di>\u0014H)\u001a8v[\u0006aa.Z<UQJ,7\u000f[8mIR\u0019Qm[7\t\u000b1$\u0004\u0019A3\u0002\u0017}cw.\u00193GC\u000e$xN\u001d\u0005\u0006]R\u0002\r!Z\u0001\u0005g&TX-\u0001\ttSj,gi\u001c:UQJ,7\u000f[8mIR\u0019Q-\u001d:\t\u000b1,\u0004\u0019A3\t\u000bM,\u0004\u0019A3\u0002\u0007QD'/\u0001\u0005dCB\f7-\u001b;z)\t)g\u000fC\u0003xm\u0001\u0007Q-\u0001\u0007fqB,7\r^3e'&TXMA\u0005ICNDW\u000b^5mgV\u0019!0!\u0005\u0014\u0005]:\u0016A\u0002\u0013j]&$H\u0005F\u0001~!\tAf0\u0003\u0002\u0000%\n!QK\\5u\u0003Q\u0019\u0018N_3NCB\u0014UoY6fi\nKGoU5{K\u0006\t2/\u001b>f\u001b\u0006\u0004()^2lKR\u001c\u0016N_3\u0002\u0019\u0015dW-\u001c%bg\"\u001cu\u000eZ3\u0015\u0007\u0015\fI\u0001C\u0004\u0002\fm\u0002\r!!\u0004\u0002\u0007-,\u0017\u0010\u0005\u0003\u0002\u0010\u0005EA\u0002\u0001\u0003\b\u0003'9$\u0019AA\u000b\u0005\u001dYU-\u001f+za\u0016\fB!a\u0006\u0002\u001eA\u0019\u0001,!\u0007\n\u0007\u0005m!KA\u0004O_RD\u0017N\\4\u0011\u0007a\u000by\"C\u0002\u0002\"I\u00131!\u00118z\u0003\u001dIW\u000e\u001d:pm\u0016$R!ZA\u0014\u0003WAa!!\u000b=\u0001\u0004)\u0017!\u00025d_\u0012,\u0007BBA\u0017y\u0001\u0007Q-\u0001\u0003tK\u0016$\u0017A\u00068fqR\u0004vn]5uSZ,\u0007k\\<fe>3Gk^8\u0015\u0007\u0015\f\u0019\u0004\u0003\u0004\u00026u\u0002\r!Z\u0001\u0007i\u0006\u0014x-\u001a;\u0003\u0011\r{g\u000e^3oiN,b!a\u000f\u0002T\u0005e3C\u0001 X\u0003)aw.\u00193GC\u000e$xN]\u0001\fY>\fGMR1di>\u0014\b%A\u0003uC\ndW-\u0006\u0002\u0002FA)\u0001,a\u0012\u0002L%\u0019\u0011\u0011\n*\u0003\u000b\u0005\u0013(/Y=\u0011\u000fu\u000bi%!\u0015\u0002X%\u0019\u0011q\n(\u0003\u0013!\u000b7\u000f[#oiJL\b\u0003BA\b\u0003'\"q!!\u0016?\u0005\u0004\t)BA\u0001B!\u0011\ty!!\u0017\u0005\u000f\u0005mcH1\u0001\u0002^\t)QI\u001c;ssF!\u0011qLA&!\rA\u0016\u0011M\u0005\u0004\u0003G\u0012&\u0001\u0002(vY2\fa\u0001^1cY\u0016\u0004\u0013!\u0003;bE2,7+\u001b>f\u0003)!\u0018M\u00197f'&TX\rI\u0001\ni\"\u0014Xm\u001d5pY\u0012\f!\u0002\u001e5sKNDw\u000e\u001c3!\u0003%\u0019X-\u001a3wC2,X-\u0001\u0006tK\u0016$g/\u00197vK\u0002\nqa]5{K6\f\u0007/\u0006\u0002\u0002xA!\u0001,a\u0012f\u0003!\u0019\u0018N_3nCB\u0004CCDA?\u0003\u0003\u000b\u0019)!\"\u0002\b\u0006%\u00151\u0012\t\b\u0003\u007fr\u0014\u0011KA,\u001b\u0005\u0001\u0004BBA\u001f\u0017\u0002\u0007Q\rC\u0004\u0002B-\u0003\r!!\u0012\t\r\u0005\u001d4\n1\u0001f\u0011\u0019\tYg\u0013a\u0001K\"1\u0011qN&A\u0002\u0015Dq!a\u001dL\u0001\u0004\t9(\u0001\teK\n,x-\u00138g_Jl\u0017\r^5p]V\u0011\u0011\u0011\u0013\t\u0005\u0003'\u000b\tK\u0004\u0003\u0002\u0016\u0006u\u0005cAAL%6\u0011\u0011\u0011\u0014\u0006\u0004\u00037#\u0016A\u0002\u001fs_>$h(C\u0002\u0002 J\u000ba\u0001\u0015:fI\u00164\u0017\u0002BAR\u0003K\u0013aa\u0015;sS:<'bAAP%B!\u0011qBAU\t\u001d\t)\u0006\u0001b\u0001\u0003+A3AAAW!\rA\u0016qV\u0005\u0004\u0003c\u0013&!\u0003;sC:\u001c\u0018.\u001a8u\u0003=yFn\\1e\r\u0006\u001cGo\u001c:`I\u0015\fHcA?\u00028\"A\u0011\u0011X\u0002\u0002\u0002\u0003\u0007Q-A\u0002yIE*\"!!0\u0011\u000ba\u000b9%a0\u0011\u000fu\u000bi%a*\u0002BB!\u0011qBAb\t\u001d\tY\u0006\u0001b\u0001\u0003\u000b\fB!a\u0018\u0002@\"\u001aA!!,\u0002\u0013Q\f'\r\\3`I\u0015\fHcA?\u0002N\"I\u0011\u0011X\u0003\u0002\u0002\u0003\u0007\u0011Q\u0018\u0015\u0004\r\u00055\u0016!\u0004;bE2,7+\u001b>f?\u0012*\u0017\u000fF\u0002~\u0003+D\u0001\"!/\b\u0003\u0003\u0005\r!\u001a\u0015\u0004\u0011\u00055\u0016!\u0004;ie\u0016\u001c\bn\u001c7e?\u0012*\u0017\u000fF\u0002~\u0003;D\u0001\"!/\n\u0003\u0003\u0005\r!\u001a\u0015\u0004\u0015\u00055\u0016aC:ju\u0016l\u0017\r]0%KF$2!`As\u0011%\tIlCA\u0001\u0002\u0004\t9\bK\u0002\r\u0003[\u000bQb]3fIZ\fG.^3`I\u0015\fHcA?\u0002n\"A\u0011\u0011X\u0007\u0002\u0002\u0003\u0007Q-A\u0007uC\ndWmU5{KN+W\rZ\u0001\fS:LG/[1m'&TX-\u0001\tj]&$\u0018.\u00197UQJ,7\u000f[8mIR\u0019Q-a>\t\u000b1\u0004\u0002\u0019A3\u0002\u001f%t\u0017\u000e^5bY\u000e\u000b\u0007/Y2jif\f!\u0003\\1tiB{\u0007/\u001e7bi\u0016$\u0017J\u001c3fq\u0006!\u0011N\\5u)\u0015i(\u0011\u0001B\u000b\u0011\u001d\u0011\u0019a\u0005a\u0001\u0005\u000b\t!!\u001b8\u0011\t\t\u001d!\u0011C\u0007\u0003\u0005\u0013QAAa\u0003\u0003\u000e\u0005\u0011\u0011n\u001c\u0006\u0003\u0005\u001f\tAA[1wC&!!1\u0003B\u0005\u0005Ey%M[3di&s\u0007/\u001e;TiJ,\u0017-\u001c\u0005\t\u0005/\u0019B\u00111\u0001\u0003\u001a\u0005I!/Z1e\u000b:$(/\u001f\t\u00061\nm\u0011\u0011Y\u0005\u0004\u0005;\u0011&\u0001\u0003\u001fcs:\fW.\u001a \u0002\u0017M,'/[1mSj,Gk\u001c\u000b\u0006{\n\r\"Q\u0006\u0005\b\u0005K!\u0002\u0019\u0001B\u0014\u0003\ryW\u000f\u001e\t\u0005\u0005\u000f\u0011I#\u0003\u0003\u0003,\t%!AE(cU\u0016\u001cGoT;uaV$8\u000b\u001e:fC6DqAa\f\u0015\u0001\u0004\u0011\t$\u0001\u0006xe&$X-\u00128uef\u0004b\u0001\u0017B\u001a\u0003\u0003l\u0018b\u0001B\u001b%\nIa)\u001e8di&|g.M\u0001\nM&tG-\u00128uef$B!!1\u0003<!9\u00111B\u000bA\u0002\u0005\u001d\u0006fB\u000b\u0003@\t\u0015#\u0011\n\t\u00041\n\u0005\u0013b\u0001B\"%\n!B-\u001a9sK\u000e\fG/\u001a3Pm\u0016\u0014(/\u001b3j]\u001e\f#Aa\u0012\u0002E:{\u0007e]3og&\u0014G.\u001a\u0011xCf\u0004Co\u001c\u0011pm\u0016\u0014(/\u001b3fA\u0019Lg\u000eZ#oiJL\b%Y:!aJLg/\u0019;fA\u0019Lg\u000eZ#oiJL\b\u0007I5tAU\u001cX\r\u001a\u0011j]\u0002jW\u000f\u001c;ja2,\u0007\u0005\u001d7bG\u0016\u001c\b%\u001b8uKJt\u0017\r\u001c7z]\u0005\u0012!1J\u0001\u0007e9\n\u0014G\f\u0019\u0002\u0015\u0019Lg\u000eZ#oiJL\b\u0007\u0006\u0004\u0002B\nE#1\u000b\u0005\b\u0003\u00171\u0002\u0019AAT\u0011\u0019\u0011)F\u0006a\u0001K\u0006\t\u0001.\u0001\u0005bI\u0012,e\u000e\u001e:z)\ri(1\f\u0005\b\u0005;:\u0002\u0019AAa\u0003\u0005)\u0007fB\f\u0003@\t\u0005$\u0011J\u0011\u0003\u0005G\n\u0001MT8!g\u0016t7/\u001b2mK\u0002:\u0018-\u001f\u0011u_\u0002zg/\u001a:sS\u0012,\u0007%\u00193e\u000b:$(/\u001f\u0011bg\u0002\u0002(/\u001b<bi\u0016\u0004\u0013\r\u001a3F]R\u0014\u0018\u0010\r\u0011jg\u0002*8/\u001a3!S:\u0004S.\u001e7uSBdW\r\t9mC\u000e,7\u000fI5oi\u0016\u0014h.\u00197ms:\n\u0011\"\u00193e\u000b:$(/\u001f\u0019\u0015\u000bu\u0014IGa\u001b\t\u000f\tu\u0003\u00041\u0001\u0002B\"1!Q\u000b\rA\u0002\u0015\faBZ5oI>\u0013\u0018\t\u001a3F]R\u0014\u00180\u0006\u0003\u0003r\tmDCBAa\u0005g\u0012)\bC\u0004\u0002\fe\u0001\r!a*\t\u000f\t]\u0014\u00041\u0001\u0003z\u0005)a/\u00197vKB!\u0011q\u0002B>\t\u001d\u0011i(\u0007b\u0001\u0003+\u0011\u0011AQ\u0001\u000fGJ,\u0017\r^3OK^,e\u000e\u001e:z+\u0011\u0011\u0019Ia#\u0015\r\u0005\u0005'Q\u0011BD\u0011\u001d\tYA\u0007a\u0001\u0003OCqAa\u001e\u001b\u0001\u0004\u0011I\t\u0005\u0003\u0002\u0010\t-Ea\u0002B?5\t\u0007\u0011QC\u0001\fe\u0016lwN^3F]R\u0014\u0018\u0010\u0006\u0003\u0002B\nE\u0005bBA\u00067\u0001\u0007\u0011q\u0015\u0015\b7\t}\"Q\u0013B%C\t\u00119*\u0001&J]R,'O\\1mA%l\u0007\u000f\\3nK:$\u0018\r^5p]\u0002\"w.Z:!]>$\b%\u00193nSR\u00043/\u001a8tS\ndW\rI8wKJ\u0014\u0018\u000eZ5oO\u0002zg\r\t;iSN\u0004S.\u001a;i_\u0012t\u0013aD3oiJLWm]%uKJ\fGo\u001c:\u0016\u0005\tu\u0005C\u0002BP\u0005C\u000b\t-D\u0001Q\u0013\r\u0011\u0019\u000b\u0015\u0002\t\u0013R,'/\u0019;pe\u0006aam\u001c:fC\u000eDWI\u001c;ssV!!\u0011\u0016BZ)\ri(1\u0016\u0005\b\u0005[k\u0002\u0019\u0001BX\u0003\u00051\u0007c\u0002-\u00034\u0005\u0005'\u0011\u0017\t\u0005\u0003\u001f\u0011\u0019\fB\u0004\u00036v\u0011\r!!\u0006\u0003\u0003U\u000b!b\u00197fCJ$\u0016M\u00197f\u0003\u0019\u0011Xm]5{KR\u0019QP!0\t\r\t}v\u00041\u0001f\u0003\u001dqWm^*ju\u0016\fAB\u001c8TSj,W*\u00199BI\u0012$2! Bc\u0011\u0019\u0011)\u0006\ta\u0001K\":\u0001Ea\u0010\u0003\u0016\n%\u0013a\u00048o'&TX-T1q%\u0016lwN^3\u0015\u0007u\u0014i\r\u0003\u0004\u0003V\u0005\u0002\r!\u001a\u0015\bC\t}\"Q\u0013B%\u00039qgnU5{K6\u000b\u0007OU3tKR$2! Bk\u0011\u0019\u00119N\ta\u0001K\u0006YA/\u00192mK2+gn\u001a;iQ\u001d\u0011#q\bBK\u0005\u0013\n1\u0003^8uC2\u001c\u0016N_3NCB\u0014UoY6fiN\fqbY1mGNK'0Z'baNK'0\u001a\u000b\u0004K\n\u0005\bB\u0002BlI\u0001\u0007Q\rK\u0004%\u0005\u007f\u0011)J!\u0013\u0002\u0017ML'0Z'ba&s\u0017\u000e\u001e\u000b\u0004{\n%\bB\u0002BlK\u0001\u0007Q-A\u000btSj,W*\u00199J]&$\u0018I\u001c3SK\n,\u0018\u000e\u001c3)\u000f\u0019\u0012yD!&\u0003J\u0005a\u0001O]5oiNK'0Z'ba\u0006q1/\u001b>f\u001b\u0006\u0004H)[:bE2,\u0007f\u0002\u0015\u0003@\tU%\u0011J\u0001\u0011SN\u001c\u0016N_3NCB$UMZ5oK\u0012,\"A!?\u0011\u0007a\u0013Y0C\u0002\u0003~J\u0013qAQ8pY\u0016\fg\u000eK\u0004*\u0005\u007f\u0011)J!\u0013\u0002#\u0005dw/Y=t\u0013:LGoU5{K6\u000b\u0007/\u0001\u0006fY\u0016lW)];bYN$bA!?\u0004\b\r-\u0001bBB\u0005W\u0001\u0007\u0011qU\u0001\u0005W\u0016L\u0018\u0007C\u0004\u0004\u000e-\u0002\r!a*\u0002\t-,\u0017PM\u0001\u0006S:$W\r\u001f\u000b\u0004K\u000eM\u0001BBA\u0015Y\u0001\u0007Q-\u0001\tj]&$x+\u001b;i\u0007>tG/\u001a8ugR\u0019Qp!\u0007\t\u000f\rmQ\u00061\u0001\u0004\u001e\u0005\t1\r\u0005\u0004]}\u0005\u001d\u0016\u0011Y\u0001\u0012Q\u0006\u001c\b\u000eV1cY\u0016\u001cuN\u001c;f]R\u001cXCAB\u000f\u0001")
public interface HashTable<A, Entry extends HashEntry<A, Entry>>
extends HashUtils<A> {
    public int _loadFactor();

    public void _loadFactor_$eq(int var1);

    public HashEntry<A, Entry>[] table();

    public void table_$eq(HashEntry<A, Entry>[] var1);

    public int tableSize();

    public void tableSize_$eq(int var1);

    public int threshold();

    public void threshold_$eq(int var1);

    public int[] sizemap();

    public void sizemap_$eq(int[] var1);

    public int seedvalue();

    public void seedvalue_$eq(int var1);

    public static /* synthetic */ int tableSizeSeed$(HashTable $this) {
        return $this.tableSizeSeed();
    }

    default public int tableSizeSeed() {
        return Integer.bitCount(this.table().length - 1);
    }

    public static /* synthetic */ int initialSize$(HashTable $this) {
        return $this.initialSize();
    }

    default public int initialSize() {
        return 16;
    }

    private int initialThreshold(int _loadFactor) {
        return HashTable$.MODULE$.newThreshold(_loadFactor, this.initialCapacity());
    }

    private int initialCapacity() {
        return HashTable$.MODULE$.capacity(this.initialSize());
    }

    public static /* synthetic */ int scala$collection$mutable$HashTable$$lastPopulatedIndex$(HashTable $this) {
        return $this.scala$collection$mutable$HashTable$$lastPopulatedIndex();
    }

    /*
     * WARNING - void declaration
     */
    default public int scala$collection$mutable$HashTable$$lastPopulatedIndex() {
        void var1_1;
        for (int idx = this.table().length - 1; this.table()[idx] == null && idx > 0; --idx) {
        }
        return (int)var1_1;
    }

    public static /* synthetic */ void init$(HashTable $this, ObjectInputStream in, Function0 readEntry2) {
        $this.init(in, readEntry2);
    }

    default public void init(ObjectInputStream in, Function0<Entry> readEntry2) {
        in.defaultReadObject();
        this._loadFactor_$eq(in.readInt());
        Predef$.MODULE$.assert(this._loadFactor() > 0);
        int size = in.readInt();
        this.tableSize_$eq(0);
        Predef$.MODULE$.assert(size >= 0);
        this.seedvalue_$eq(in.readInt());
        boolean smDefined = in.readBoolean();
        this.table_$eq(new HashEntry[HashTable$.MODULE$.capacity(HashTable$.MODULE$.sizeForThreshold(this._loadFactor(), size))]);
        this.threshold_$eq(HashTable$.MODULE$.newThreshold(this._loadFactor(), this.table().length));
        if (smDefined) {
            this.sizeMapInit(this.table().length);
        } else {
            this.sizemap_$eq(null);
        }
        for (int index = 0; index < size; ++index) {
            this.addEntry((HashEntry)readEntry2.apply());
        }
    }

    public static /* synthetic */ void serializeTo$(HashTable $this, ObjectOutputStream out, Function1 writeEntry) {
        $this.serializeTo(out, writeEntry);
    }

    default public void serializeTo(ObjectOutputStream out, Function1<Entry, BoxedUnit> writeEntry) {
        out.defaultWriteObject();
        out.writeInt(this._loadFactor());
        out.writeInt(this.tableSize());
        out.writeInt(this.seedvalue());
        out.writeBoolean(this.isSizeMapDefined());
        this.foreachEntry(writeEntry);
    }

    public static /* synthetic */ HashEntry findEntry$(HashTable $this, Object key) {
        return $this.findEntry(key);
    }

    default public Entry findEntry(A key) {
        return this.findEntry0(key, this.index(this.elemHashCode(key)));
    }

    /*
     * WARNING - void declaration
     */
    private Entry findEntry0(A key, int h) {
        void var3_3;
        for (HashEntry e = this.table()[h]; e != null && !this.elemEquals(e.key(), key); e = (HashEntry)e.next()) {
        }
        return var3_3;
    }

    public static /* synthetic */ void addEntry$(HashTable $this, HashEntry e) {
        $this.addEntry(e);
    }

    default public void addEntry(Entry e) {
        this.addEntry0(e, this.index(this.elemHashCode(e.key())));
    }

    private void addEntry0(Entry e, int h) {
        e.next_$eq(this.table()[h]);
        this.table()[h] = e;
        this.tableSize_$eq(this.tableSize() + 1);
        this.nnSizeMapAdd(h);
        if (this.tableSize() > this.threshold()) {
            this.resize(2 * this.table().length);
        }
    }

    public static /* synthetic */ HashEntry findOrAddEntry$(HashTable $this, Object key, Object value) {
        return $this.findOrAddEntry(key, value);
    }

    default public <B> Entry findOrAddEntry(A key, B value) {
        int h = this.index(this.elemHashCode(key));
        Entry e = this.findEntry0(key, h);
        if (e != null) {
            return e;
        }
        this.addEntry0(this.createNewEntry(key, value), h);
        return null;
    }

    public <B> Entry createNewEntry(A var1, B var2);

    public static /* synthetic */ HashEntry removeEntry$(HashTable $this, Object key) {
        return $this.removeEntry(key);
    }

    default public Entry removeEntry(A key) {
        int h = this.index(this.elemHashCode(key));
        HashEntry e = this.table()[h];
        if (e != null) {
            HashEntry e1;
            if (this.elemEquals(e.key(), key)) {
                this.table()[h] = (HashEntry)e.next();
                this.tableSize_$eq(this.tableSize() - 1);
                this.nnSizeMapRemove(h);
                e.next_$eq(null);
                return (Entry)e;
            }
            for (e1 = (HashEntry)e.next(); e1 != null && !this.elemEquals(e1.key(), key); e1 = (HashEntry)e1.next()) {
                e = e1;
            }
            if (e1 != null) {
                e.next_$eq(e1.next());
                this.tableSize_$eq(this.tableSize() - 1);
                this.nnSizeMapRemove(h);
                e1.next_$eq(null);
                return (Entry)e1;
            }
        }
        return null;
    }

    public static /* synthetic */ Iterator entriesIterator$(HashTable $this) {
        return $this.entriesIterator();
    }

    default public Iterator<Entry> entriesIterator() {
        return new AbstractIterator<Entry>(this){
            private final HashEntry<A, Entry>[] iterTable;
            private int idx;
            private HashEntry<A, Entry> es;

            private HashEntry<A, Entry>[] iterTable() {
                return this.iterTable;
            }

            private int idx() {
                return this.idx;
            }

            private void idx_$eq(int x$1) {
                this.idx = x$1;
            }

            private HashEntry<A, Entry> es() {
                return this.es;
            }

            private void es_$eq(HashEntry<A, Entry> x$1) {
                this.es = x$1;
            }

            public boolean hasNext() {
                return this.es() != null;
            }

            /*
             * WARNING - void declaration
             */
            public Entry next() {
                void var1_1;
                HashEntry<A, Entry> res = this.es();
                this.es_$eq((HashEntry)this.es().next());
                while (this.es() == null && this.idx() > 0) {
                    this.idx_$eq(this.idx() - 1);
                    this.es_$eq(this.iterTable()[this.idx()]);
                }
                return var1_1;
            }
            {
                this.iterTable = $outer.table();
                this.idx = $outer.scala$collection$mutable$HashTable$$lastPopulatedIndex();
                this.es = this.iterTable()[this.idx()];
            }
        };
    }

    public static /* synthetic */ void foreachEntry$(HashTable $this, Function1 f) {
        $this.foreachEntry(f);
    }

    default public <U> void foreachEntry(Function1<Entry, U> f) {
        HashEntry<A, Entry>[] iterTable = this.table();
        int idx = this.scala$collection$mutable$HashTable$$lastPopulatedIndex();
        HashEntry<A, Entry> es = iterTable[idx];
        while (es != null) {
            HashEntry<A, Entry> next = (HashEntry<A, Entry>)es.next();
            f.apply(es);
            es = next;
            while (es == null && idx > 0) {
                es = iterTable[--idx];
            }
        }
    }

    public static /* synthetic */ void clearTable$(HashTable $this) {
        $this.clearTable();
    }

    default public void clearTable() {
        for (int i = this.table().length - 1; i >= 0; --i) {
            this.table()[i] = null;
        }
        this.tableSize_$eq(0);
        this.nnSizeMapReset(0);
    }

    private void resize(int newSize) {
        HashEntry<A, Entry>[] oldTable = this.table();
        this.table_$eq(new HashEntry[newSize]);
        this.nnSizeMapReset(this.table().length);
        for (int i = oldTable.length - 1; i >= 0; --i) {
            HashEntry e = oldTable[i];
            while (e != null) {
                int h = this.index(this.elemHashCode(e.key()));
                HashEntry e1 = (HashEntry)e.next();
                e.next_$eq(this.table()[h]);
                this.table()[h] = e;
                e = e1;
                this.nnSizeMapAdd(h);
            }
        }
        this.threshold_$eq(HashTable$.MODULE$.newThreshold(this._loadFactor(), newSize));
    }

    public static /* synthetic */ void nnSizeMapAdd$(HashTable $this, int h) {
        $this.nnSizeMapAdd(h);
    }

    default public void nnSizeMapAdd(int h) {
        if (this.sizemap() != null) {
            int[] nArray = this.sizemap();
            int n = h >> this.sizeMapBucketBitSize();
            nArray[n] = nArray[n] + 1;
        }
    }

    public static /* synthetic */ void nnSizeMapRemove$(HashTable $this, int h) {
        $this.nnSizeMapRemove(h);
    }

    default public void nnSizeMapRemove(int h) {
        if (this.sizemap() != null) {
            int[] nArray = this.sizemap();
            int n = h >> this.sizeMapBucketBitSize();
            nArray[n] = nArray[n] - 1;
        }
    }

    public static /* synthetic */ void nnSizeMapReset$(HashTable $this, int tableLength) {
        $this.nnSizeMapReset(tableLength);
    }

    default public void nnSizeMapReset(int tableLength) {
        if (this.sizemap() != null) {
            int nsize = this.calcSizeMapSize(tableLength);
            if (this.sizemap().length != nsize) {
                this.sizemap_$eq(new int[nsize]);
                return;
            }
            Arrays.fill(this.sizemap(), 0);
        }
    }

    public static /* synthetic */ int totalSizeMapBuckets$(HashTable $this) {
        return $this.totalSizeMapBuckets();
    }

    default public int totalSizeMapBuckets() {
        if (this.sizeMapBucketSize() < this.table().length) {
            return 1;
        }
        return this.table().length / this.sizeMapBucketSize();
    }

    public static /* synthetic */ int calcSizeMapSize$(HashTable $this, int tableLength) {
        return $this.calcSizeMapSize(tableLength);
    }

    default public int calcSizeMapSize(int tableLength) {
        return (tableLength >> this.sizeMapBucketBitSize()) + 1;
    }

    public static /* synthetic */ void sizeMapInit$(HashTable $this, int tableLength) {
        $this.sizeMapInit(tableLength);
    }

    default public void sizeMapInit(int tableLength) {
        this.sizemap_$eq(new int[this.calcSizeMapSize(tableLength)]);
    }

    public static /* synthetic */ void sizeMapInitAndRebuild$(HashTable $this) {
        $this.sizeMapInitAndRebuild();
    }

    default public void sizeMapInitAndRebuild() {
        this.sizeMapInit(this.table().length);
        int tableidx = 0;
        HashEntry<A, Entry>[] tbl = this.table();
        int tableuntil = tbl.length < this.sizeMapBucketSize() ? tbl.length : this.sizeMapBucketSize();
        int totalbuckets = this.totalSizeMapBuckets();
        for (int bucketidx = 0; bucketidx < totalbuckets; ++bucketidx) {
            int currbucketsize = 0;
            while (tableidx < tableuntil) {
                for (HashEntry e = tbl[tableidx]; e != null; e = (HashEntry)e.next()) {
                    ++currbucketsize;
                }
                ++tableidx;
            }
            this.sizemap()[bucketidx] = currbucketsize;
            tableuntil += this.sizeMapBucketSize();
        }
    }

    public static /* synthetic */ void printSizeMap$(HashTable $this) {
        $this.printSizeMap();
    }

    default public void printSizeMap() {
        Predef$.MODULE$.println(new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(this.sizemap())).toList());
    }

    public static /* synthetic */ void sizeMapDisable$(HashTable $this) {
        $this.sizeMapDisable();
    }

    default public void sizeMapDisable() {
        this.sizemap_$eq(null);
    }

    public static /* synthetic */ boolean isSizeMapDefined$(HashTable $this) {
        return $this.isSizeMapDefined();
    }

    default public boolean isSizeMapDefined() {
        return this.sizemap() != null;
    }

    public static /* synthetic */ boolean alwaysInitSizeMap$(HashTable $this) {
        return $this.alwaysInitSizeMap();
    }

    default public boolean alwaysInitSizeMap() {
        return false;
    }

    public static /* synthetic */ boolean elemEquals$(HashTable $this, Object key1, Object key2) {
        return $this.elemEquals(key1, key2);
    }

    default public boolean elemEquals(A key1, A key2) {
        return BoxesRunTime.equals(key1, key2);
    }

    public static /* synthetic */ int index$(HashTable $this, int hcode) {
        return $this.index(hcode);
    }

    default public int index(int hcode) {
        int ones = this.table().length - 1;
        int exponent = Integer.numberOfLeadingZeros(ones);
        return this.improve(hcode, this.seedvalue()) >>> exponent & ones;
    }

    public static /* synthetic */ void initWithContents$(HashTable $this, Contents c) {
        $this.initWithContents(c);
    }

    default public void initWithContents(Contents<A, Entry> c) {
        if (c != null) {
            this._loadFactor_$eq(c.loadFactor());
            this.table_$eq(c.table());
            this.tableSize_$eq(c.tableSize());
            this.threshold_$eq(c.threshold());
            this.seedvalue_$eq(c.seedvalue());
            this.sizemap_$eq(c.sizemap());
        }
        if (this.alwaysInitSizeMap() && this.sizemap() == null) {
            this.sizeMapInitAndRebuild();
        }
    }

    public static /* synthetic */ Contents hashTableContents$(HashTable $this) {
        return $this.hashTableContents();
    }

    default public Contents<A, Entry> hashTableContents() {
        return new Contents<A, Entry>(this._loadFactor(), this.table(), this.tableSize(), this.threshold(), this.seedvalue(), this.sizemap());
    }

    public static void $init$(HashTable $this) {
        $this._loadFactor_$eq(HashTable$.MODULE$.defaultLoadFactor());
        $this.table_$eq(new HashEntry[$this.initialCapacity()]);
        $this.tableSize_$eq(0);
        $this.threshold_$eq($this.initialThreshold($this._loadFactor()));
        $this.sizemap_$eq(null);
        $this.seedvalue_$eq($this.tableSizeSeed());
    }

    public static class Contents<A, Entry extends HashEntry<A, Entry>> {
        private final int loadFactor;
        private final HashEntry<A, Entry>[] table;
        private final int tableSize;
        private final int threshold;
        private final int seedvalue;
        private final int[] sizemap;

        public int loadFactor() {
            return this.loadFactor;
        }

        public HashEntry<A, Entry>[] table() {
            return this.table;
        }

        public int tableSize() {
            return this.tableSize;
        }

        public int threshold() {
            return this.threshold;
        }

        public int seedvalue() {
            return this.seedvalue;
        }

        public int[] sizemap() {
            return this.sizemap;
        }

        public String debugInformation() {
            return DebugUtils$.MODULE$.buildString((Function1<Function1<Object, BoxedUnit>, BoxedUnit>)(Function1<Function1, Object> & java.io.Serializable & Serializable)append -> {
                append.apply("Hash table contents");
                append.apply("-------------------");
                append.apply(new StringBuilder(9).append("Table: [").append(DebugUtils$.MODULE$.arrayString(this.table(), 0, this.table().length)).append("]").toString());
                append.apply(new StringBuilder(12).append("Table size: ").append(this.tableSize()).toString());
                append.apply(new StringBuilder(13).append("Load factor: ").append(this.loadFactor()).toString());
                append.apply(new StringBuilder(11).append("Seedvalue: ").append(this.seedvalue()).toString());
                append.apply(new StringBuilder(11).append("Threshold: ").append(this.threshold()).toString());
                append.apply(new StringBuilder(11).append("Sizemap: [").append(DebugUtils$.MODULE$.arrayString(this.sizemap(), 0, this.sizemap().length)).append("]").toString());
                return BoxedUnit.UNIT;
            });
        }

        public static final /* synthetic */ void $anonfun$debugInformation$1(Contents $this, Function1 append) {
            append.apply("Hash table contents");
            append.apply("-------------------");
            append.apply(new StringBuilder(9).append("Table: [").append(DebugUtils$.MODULE$.arrayString($this.table(), 0, $this.table().length)).append("]").toString());
            append.apply(new StringBuilder(12).append("Table size: ").append($this.tableSize()).toString());
            append.apply(new StringBuilder(13).append("Load factor: ").append($this.loadFactor()).toString());
            append.apply(new StringBuilder(11).append("Seedvalue: ").append($this.seedvalue()).toString());
            append.apply(new StringBuilder(11).append("Threshold: ").append($this.threshold()).toString());
            append.apply(new StringBuilder(11).append("Sizemap: [").append(DebugUtils$.MODULE$.arrayString($this.sizemap(), 0, $this.sizemap().length)).append("]").toString());
        }

        public Contents(int loadFactor, HashEntry<A, Entry>[] table, int tableSize, int threshold, int seedvalue, int[] sizemap) {
            this.loadFactor = loadFactor;
            this.table = table;
            this.tableSize = tableSize;
            this.threshold = threshold;
            this.seedvalue = seedvalue;
            this.sizemap = sizemap;
        }
    }

    public static interface HashUtils<KeyType> {
        public static /* synthetic */ int sizeMapBucketBitSize$(HashUtils $this) {
            return $this.sizeMapBucketBitSize();
        }

        default public int sizeMapBucketBitSize() {
            return 5;
        }

        public static /* synthetic */ int sizeMapBucketSize$(HashUtils $this) {
            return $this.sizeMapBucketSize();
        }

        default public int sizeMapBucketSize() {
            return 1 << this.sizeMapBucketBitSize();
        }

        public static /* synthetic */ int elemHashCode$(HashUtils $this, Object key) {
            return $this.elemHashCode(key);
        }

        default public int elemHashCode(KeyType key) {
            return Statics.anyHash(key);
        }

        public static /* synthetic */ int improve$(HashUtils $this, int hcode, int seed) {
            return $this.improve(hcode, seed);
        }

        default public int improve(int hcode, int seed) {
            return Integer.rotateRight(package$.MODULE$.byteswap32(hcode), seed);
        }

        public static void $init$(HashUtils $this) {
        }
    }
}

