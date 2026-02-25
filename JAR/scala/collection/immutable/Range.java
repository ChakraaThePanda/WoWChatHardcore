/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.AbstractSeq;
import scala.collection.CustomParallelizable;
import scala.collection.GenSeqLike;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range$Partial$;
import scala.collection.immutable.Seq;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Buffer;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParRange;
import scala.math.Numeric;
import scala.math.Numeric$IntIsIntegral$;
import scala.math.Ordering;
import scala.math.Ordering$Int$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0011\u0005g\u0001B<y!}D!\"a\r\u0001\u0005\u000b\u0007I\u0011AA\u001b\u0011)\t9\u0004\u0001B\u0001B\u0003%\u0011\u0011\u0002\u0005\u000b\u0003s\u0001!Q1A\u0005\u0002\u0005U\u0002BCA\u001e\u0001\t\u0005\t\u0015!\u0003\u0002\n!Q\u0011Q\b\u0001\u0003\u0006\u0004%\t!!\u000e\t\u0015\u0005}\u0002A!A!\u0002\u0013\tI\u0001C\u0004\u0002B\u0001!\t!a\u0011\t\u000f\u00055\u0003\u0001\"\u0011\u0002P!9\u0011\u0011\u000b\u0001\u0005\n\u0005M\u0003bBA.\u0001\u0011%\u0011Q\f\u0005\b\u0003K\u0002A\u0011BA/\u0011\u001d\t9\u0007\u0001C\u0005\u0003'B\u0011\"!\u001b\u0001\u0005\u0004%)%!\u0018\t\u0011\u0005-\u0004\u0001)A\u0007\u0003?B\u0011\"!\u001c\u0001\u0005\u0004%I!!\u000e\t\u0011\u0005=\u0004\u0001)A\u0005\u0003\u0013Aa\"!\u001d\u0001\t\u0003\u0005)\u0011!b\u0001\n\u0013\t)\u0004C\u0006\u0002t\u0001\u0011\t\u0011!Q\u0001\n\u0005%\u0001bBA;\u0001\u0011\u0005\u0013Q\u0007\u0005\b\u0003o\u0002A\u0011IA\u001b\u0011\u001d\tI\b\u0001C!\u0003wBq!!)\u0001\t\u0003\n\u0019\u000bC\u0004\u00020\u0002!\t\"!-\t\u000f\u0005e\u0006\u0001\"\u0001\u0002<\"9\u0011q\u0018\u0001\u0005\u0002\u0005u\u0003bBAa\u0001\u0011\u0005\u0013Q\u0007\u0005\b\u0003\u0007\u0004A\u0011IA\u001b\u0011\u001d\t)\r\u0001C\u0005\u0003\u000fDq!a8\u0001\t\u0013\t\t\u000fC\u0004\u0002j\u0002!I!a;\t\u000f\u0005M\b\u0001\"\u0002\u0002v\"9\u00111 \u0001\u0005F\u0005u\bb\u0002B\u0016\u0001\u0011\u0015#Q\u0006\u0005\b\u0005g\u0001AQ\tB\u001b\u0011\u001d\u0011I\u0004\u0001C!\u0005wAqA!\u0012\u0001\t\u000b\u00129\u0005C\u0004\u0003J\u0001!)Ea\u0012\t\u000f\t-\u0003\u0001\"\u0003\u0003N!9!Q\u000b\u0001\u0005\n\t]\u0003b\u0002B.\u0001\u0011%!Q\f\u0005\b\u0005G\u0002AQ\tB3\u0011\u001d\u0011I\u0007\u0001C#\u0005WBqAa\u001c\u0001\t\u000b\u0012\t\bC\u0004\u0003|\u0001!)E! \t\u000f\t\u0005\u0005\u0001\"\u0012\u0003\u0004\"9!q\u0011\u0001\u0005F\t%\u0005b\u0002BG\u0001\u0011\u0015#q\t\u0005\b\u0005\u001f\u0003A\u0011\u0001B$\u0011\u001d\u0011\t\n\u0001C\u0003\u0005'CqA!'\u0001\t\u000b\u0012Y\nC\u0004\u00030\u0002!\tEa\u0012\t\u000f\tE\u0006\u0001\"\u0011\u0003H!9!1\u0017\u0001\u0005B\tU\u0006b\u0002B^\u0001\u0011\u0005#QX\u0004\b\u0005oD\b\u0012\u0001Bg\r\u00199\b\u0010#\u0001\u0003D\"9\u0011\u0011\t\u001d\u0005\u0002\t-\u0007b\u0002Bhq\u0011\u0005!\u0011\u001b\u0005\b\u0005\u001fDD\u0011\u0001Bn\r\u0019\u0011\t\r\u000f\u0002\u0005$\"Y\u00111\u0007\u001f\u0003\u0002\u0003\u0006I!!\u0003\u0002\u0011-\tI\u0004\u0010B\u0001B\u0003%\u0011\u0011B\u0002\t\u0017\u0005uBH!A!\u0002\u0013\tI!\u0002\u0005\b\u0003\u0003bD\u0011\u0001CS\u0011\u001d\ty\f\u0010C!\u0003;Bq!a,=\t#\"y\u000bC\u0004\u0002tb\"\tAa9\t\u000f\u0005M\b\b\"\u0001\u0003l\"9!q\u0012\u001d\u0005\u0002\tE\bb\u0002BHq\u0011\u0005!q`\u0004\b\u0007\u000bA\u0004\u0012AB\u0004\r\u001d\u0019Y\u0001\u000fE\u0001\u0007\u001bAq!!\u0011I\t\u0003\u0019y\u0001C\u0004\u0002t\"#\ta!\u0005\t\u000f\t=\u0005\n\"\u0001\u0004,\u001d91q\u0007\u001d\t\u0002\rebaBA-q!\u000511\b\u0005\b\u0003\u0003jE\u0011AB\u001f\u0011\u001d\t\u00190\u0014C\u0001\u0007\u007fAqAa$N\t\u0003\u0019IeB\u0004\u0004TaB\ta!\u0016\u0007\u000f\r]\u0003\b#\u0001\u0004Z!9\u0011\u0011\t*\u0005\u0002\rm\u0003\"CB/%\n\u0007I1AB0\u0011!\u0019YH\u0015Q\u0001\n\r\u0005\u0004bBAz%\u0012\u00051Q\u0010\u0005\b\u0005\u001f\u0013F\u0011ABF\u000f\u001d\u0019)\n\u000fE\u0001\u0007/3qa!'9\u0011\u0003\u0019Y\nC\u0004\u0002Be#\ta!(\t\u0013\ru\u0013L1A\u0005\u0004\r}\u0003\u0002CB>3\u0002\u0006Ia!\u0019\t\u0013\r}\u0015L1A\u0005\u0004\r\u0005\u0006\u0002CBU3\u0002\u0006Iaa)\t\u000f\r-\u0016\f\"\u0001\u0004.\"9\u00111_-\u0005\u0002\rU\u0006b\u0002BH3\u0012\u000511\u001b\u0004\u0007\u0007CD$aa9\t\u001d\r5(\r\"A\u0001\u0006\u000b\u0015\r\u0011\"\u0003\u0004p\"Y1Q 2\u0003\u0006\u0003\u0005\u000b\u0011BBy\u0011\u001d\t\tE\u0019C\u0001\u0007\u007fDq!!/c\t\u0003!)\u0001C\u0004\u0003<\n$\t\u0005\"\u0003\t\u0013\u0011e!-!A\u0005B\u0011m\u0001\"\u0003BZE\u0006\u0005I\u0011\tC\u000f\u000f\u001d!\u0019\u0003\u000fE\u0001\tK1q!a\u00049\u0011\u0003!9\u0003C\u0004\u0002B-$\t\u0001\"\u000b\t\u000f\u0005M8\u000e\"\u0001\u0005,!9!qR6\u0005\u0002\u0011Ur!\u0003C q\u0005\u0005\t\u0012\u0001C!\r%\u0019\t\u000fOA\u0001\u0012\u0003!\u0019\u0005C\u0004\u0002BA$\t\u0001\"\u0012\t\u000f\u0011\u001d\u0003\u000f\"\u0002\u0005J!9Aq\f9\u0005\u0006\u0011\u0005\u0004\"\u0003C9a\u0006\u0005IQ\u0001C:\u0011%!\u0019\t]A\u0001\n\u000b!)\tC\u0005\u0005\u001ab\n\t\u0011\"\u0003\u0005\u001c\n)!+\u00198hK*\u0011\u0011P_\u0001\nS6lW\u000f^1cY\u0016T!a\u001f?\u0002\u0015\r|G\u000e\\3di&|gNC\u0001~\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\u0012\u0002AA\u0001\u0003#\tI\"!\f\u0011\r\u0005\r\u0011QAA\u0005\u001b\u0005Q\u0018bAA\u0004u\nY\u0011IY:ue\u0006\u001cGoU3r!\u0011\tY!!\u0004\u000e\u0003qL1!a\u0004}\u0005\rIe\u000e\u001e\t\u0007\u0003'\t)\"!\u0003\u000e\u0003aL1!a\u0006y\u0005)Ie\u000eZ3yK\u0012\u001cV-\u001d\t\t\u0003\u0007\tY\"!\u0003\u0002 %\u0019\u0011Q\u0004>\u0003)\r+8\u000f^8n!\u0006\u0014\u0018\r\u001c7fY&T\u0018M\u00197f!\u0011\t\t#!\u000b\u000e\u0005\u0005\r\"bA=\u0002&)\u0019\u0011q\u0005>\u0002\u0011A\f'/\u00197mK2LA!a\u000b\u0002$\tA\u0001+\u0019:SC:<W\r\u0005\u0003\u0002\f\u0005=\u0012bAA\u0019y\na1+\u001a:jC2L'0\u00192mK\u0006)1\u000f^1siV\u0011\u0011\u0011B\u0001\u0007gR\f'\u000f\u001e\u0011\u0002\u0007\u0015tG-\u0001\u0003f]\u0012\u0004\u0013\u0001B:uKB\fQa\u001d;fa\u0002\na\u0001P5oSRtD\u0003CA#\u0003\u000f\nI%a\u0013\u0011\u0007\u0005M\u0001\u0001C\u0004\u00024\u001d\u0001\r!!\u0003\t\u000f\u0005er\u00011\u0001\u0002\n!9\u0011QH\u0004A\u0002\u0005%\u0011a\u00019beV\u0011\u0011qD\u0001\u0004O\u0006\u0004XCAA+!\u0011\tY!a\u0016\n\u0007\u0005eCP\u0001\u0003M_:<\u0017aB5t\u000bb\f7\r^\u000b\u0003\u0003?\u0002B!a\u0003\u0002b%\u0019\u00111\r?\u0003\u000f\t{w\u000e\\3b]\u00069\u0001.Y:TiV\u0014\u0017A\u00037p]\u001edUM\\4uQ\u00069\u0011n]#naRL\u0018\u0001C5t\u000b6\u0004H/\u001f\u0011\u0002!9,XNU1oO\u0016,E.Z7f]R\u001c\u0018!\u00058v[J\u000bgnZ3FY\u0016lWM\u001c;tA\u0005i3oY1mC\u0012\u001aw\u000e\u001c7fGRLwN\u001c\u0013j[6,H/\u00192mK\u0012\u0012\u0016M\\4fI\u0011b\u0017m\u001d;FY\u0016lWM\u001c;\u0002]M\u001c\u0017\r\\1%G>dG.Z2uS>tG%[7nkR\f'\r\\3%%\u0006tw-\u001a\u0013%Y\u0006\u001cH/\u00127f[\u0016tG\u000fI\u0001\u0005Y\u0006\u001cH/\u0001\u0003iK\u0006$\u0017aA7j]V!\u0011QPAK)\u0011\tI!a \t\u000f\u0005\u0005U\u0003q\u0001\u0002\u0004\u0006\u0019qN\u001d3\u0011\r\u0005\u0015\u00151RAI\u001d\u0011\tY!a\"\n\u0007\u0005%E0A\u0004qC\u000e\\\u0017mZ3\n\t\u00055\u0015q\u0012\u0002\t\u001fJ$WM]5oO*\u0019\u0011\u0011\u0012?\u0011\t\u0005M\u0015Q\u0013\u0007\u0001\t\u001d\t9*\u0006b\u0001\u00033\u0013!!Q\u0019\u0012\t\u0005%\u00111\u0014\t\u0005\u0003\u0017\ti*C\u0002\u0002 r\u00141!\u00118z\u0003\ri\u0017\r_\u000b\u0005\u0003K\u000bi\u000b\u0006\u0003\u0002\n\u0005\u001d\u0006bBAA-\u0001\u000f\u0011\u0011\u0016\t\u0007\u0003\u000b\u000bY)a+\u0011\t\u0005M\u0015Q\u0016\u0003\b\u0003/3\"\u0019AAM\u0003\u0011\u0019w\u000e]=\u0015\u0011\u0005\u0015\u00131WA[\u0003oCq!a\r\u0018\u0001\u0004\tI\u0001C\u0004\u0002:]\u0001\r!!\u0003\t\u000f\u0005ur\u00031\u0001\u0002\n\u0005\u0011!-\u001f\u000b\u0005\u0003\u000b\ni\fC\u0004\u0002>a\u0001\r!!\u0003\u0002\u0017%\u001c\u0018J\\2mkNLg/Z\u0001\u0005g&TX-\u0001\u0004mK:<G\u000f[\u0001\fI\u0016\u001c8M]5qi&|g.\u0006\u0002\u0002JB!\u00111ZAm\u001d\u0011\ti-!6\u0011\u0007\u0005=G0\u0004\u0002\u0002R*\u0019\u00111\u001b@\u0002\rq\u0012xn\u001c;?\u0013\r\t9\u000e`\u0001\u0007!J,G-\u001a4\n\t\u0005m\u0017Q\u001c\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005]G0\u0001\u0003gC&dGCAAr!\u0011\tY!!:\n\u0007\u0005\u001dHPA\u0004O_RD\u0017N\\4\u0002#Y\fG.\u001b3bi\u0016l\u0015\r\u001f'f]\u001e$\b\u000e\u0006\u0002\u0002nB!\u00111BAx\u0013\r\t\t\u0010 \u0002\u0005+:LG/A\u0003baBd\u0017\u0010\u0006\u0003\u0002\n\u0005]\bbBA}?\u0001\u0007\u0011\u0011B\u0001\u0004S\u0012D\u0018a\u00024pe\u0016\f7\r[\u000b\u0005\u0003\u007f\u0014i\u0001\u0006\u0003\u0002n\n\u0005\u0001b\u0002B\u0002A\u0001\u0007!QA\u0001\u0002MBA\u00111\u0002B\u0004\u0003\u0013\u0011Y!C\u0002\u0003\nq\u0014\u0011BR;oGRLwN\\\u0019\u0011\t\u0005M%Q\u0002\u0003\f\u0005\u001f\u0001\u0003\u0015!A\u0001\u0006\u0004\u0011\tBA\u0001V#\u0011\t\u0019/a')\r\t5!Q\u0003B\u000e!\u0011\tYAa\u0006\n\u0007\teAPA\u0006ta\u0016\u001c\u0017.\u00197ju\u0016$\u0017g\u0002\u0013\u0003\u001e\t}!\u0011\u0005\b\u0005\u0003\u0017\u0011y\"C\u0002\u0003\"q\fA!\u00168ji\"\u001a\u0001E!\n\u0011\t\u0005-!qE\u0005\u0004\u0005Sa(AB5oY&tW-\u0001\u0003uC.,G\u0003BA#\u0005_AqA!\r\"\u0001\u0004\tI!A\u0001o\u0003\u0011!'o\u001c9\u0015\t\u0005\u0015#q\u0007\u0005\b\u0005c\u0011\u0003\u0019AA\u0005\u0003\u0015\u0019H.[2f)\u0019\t)E!\u0010\u0003B!9!qH\u0012A\u0002\u0005%\u0011\u0001\u00024s_6DqAa\u0011$\u0001\u0004\tI!A\u0003v]RLG.\u0001\u0003j]&$XCAA#\u0003\u0011!\u0018-\u001b7\u0002\u0019\u0005\u0014x\rV1lK^C\u0017\u000e\\3\u0015\t\u0005U#q\n\u0005\b\u0005#2\u0003\u0019\u0001B*\u0003\u0005\u0001\b\u0003CA\u0006\u0005\u000f\tI!a\u0018\u0002\u001d1|7-\u0019;j_:\fe\r^3s\u001dR!\u0011\u0011\u0002B-\u0011\u001d\u0011\td\na\u0001\u0003\u0013\tQB\\3x\u000b6\u0004H/\u001f*b]\u001e,G\u0003BA#\u0005?BqA!\u0019)\u0001\u0004\tI!A\u0003wC2,X-A\u0005uC.,w\u000b[5mKR!\u0011Q\tB4\u0011\u001d\u0011\t&\u000ba\u0001\u0005'\n\u0011\u0002\u001a:pa^C\u0017\u000e\\3\u0015\t\u0005\u0015#Q\u000e\u0005\b\u0005#R\u0003\u0019\u0001B*\u0003\u0011\u0019\b/\u00198\u0015\t\tM$\u0011\u0010\t\t\u0003\u0017\u0011)(!\u0012\u0002F%\u0019!q\u000f?\u0003\rQ+\b\u000f\\33\u0011\u001d\u0011\tf\u000ba\u0001\u0005'\nqa\u001d9mSR\fE\u000f\u0006\u0003\u0003t\t}\u0004b\u0002B\u0019Y\u0001\u0007\u0011\u0011B\u0001\ni\u0006\\WMU5hQR$B!!\u0012\u0003\u0006\"9!\u0011G\u0017A\u0002\u0005%\u0011!\u00033s_B\u0014\u0016n\u001a5u)\u0011\t)Ea#\t\u000f\tEb\u00061\u0001\u0002\n\u00059!/\u001a<feN,\u0017!C5oG2,8/\u001b<f\u0003!\u0019wN\u001c;bS:\u001cH\u0003BA0\u0005+CqAa&2\u0001\u0004\tI!A\u0001y\u0003\r\u0019X/\\\u000b\u0005\u0005;\u0013Y\u000b\u0006\u0003\u0002\n\t}\u0005b\u0002BQe\u0001\u000f!1U\u0001\u0004]Vl\u0007CBAC\u0005K\u0013I+\u0003\u0003\u0003(\u0006=%a\u0002(v[\u0016\u0014\u0018n\u0019\t\u0005\u0003'\u0013Y\u000bB\u0004\u0003.J\u0012\r!!'\u0003\u0003\t\u000b!\u0002^8Ji\u0016\u0014\u0018M\u00197f\u0003\u0015!xnU3r\u0003\u0019)\u0017/^1mgR!\u0011q\fB\\\u0011\u001d\u0011I,\u000ea\u0001\u00037\u000bQa\u001c;iKJ\f\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0003\u0013L#\u0001\u0001\u001f\u0003\u0013%s7\r\\;tSZ,7#\u0002\u001d\u0003F\u00065\u0002\u0003BA\u0006\u0005\u000fL1A!3}\u0005\u0019\te.\u001f*fMR\u0011!Q\u001a\t\u0004\u0003'A\u0014!B2pk:$HCCA\u0005\u0005'\u0014)Na6\u0003Z\"9\u00111\u0007\u001eA\u0002\u0005%\u0001bBA\u001du\u0001\u0007\u0011\u0011\u0002\u0005\b\u0003{Q\u0004\u0019AA\u0005\u0011\u001d\tyL\u000fa\u0001\u0003?\"\u0002\"!\u0003\u0003^\n}'\u0011\u001d\u0005\b\u0003gY\u0004\u0019AA\u0005\u0011\u001d\tId\u000fa\u0001\u0003\u0013Aq!!\u0010<\u0001\u0004\tI\u0001\u0006\u0005\u0002F\t\u0015(q\u001dBu\u0011\u001d\t\u0019d\u0011a\u0001\u0003\u0013Aq!!\u000fD\u0001\u0004\tI\u0001C\u0004\u0002>\r\u0003\r!!\u0003\u0015\r\u0005\u0015#Q\u001eBx\u0011\u001d\t\u0019\u0004\u0012a\u0001\u0003\u0013Aq!!\u000fE\u0001\u0004\tI\u0001\u0006\u0005\u0003t\ne(1 B\u007f!\r\u0011)\u0010\u0010\b\u0004\u0003'9\u0014!\u0002*b]\u001e,\u0007bBA\u001a\u000b\u0002\u0007\u0011\u0011\u0002\u0005\b\u0003s)\u0005\u0019AA\u0005\u0011\u001d\ti$\u0012a\u0001\u0003\u0013!bAa=\u0004\u0002\r\r\u0001bBA\u001a\r\u0002\u0007\u0011\u0011\u0002\u0005\b\u0003s1\u0005\u0019AA\u0005\u0003\u0019\u0011\u0015nZ%oiB\u00191\u0011\u0002%\u000e\u0003a\u0012aAQ5h\u0013:$8c\u0001%\u0003FR\u00111q\u0001\u000b\t\u0007'\u0019)ca\n\u0004*A11QCB\u000e\u0007CqA!a\u0005\u0004\u0018%\u00191\u0011\u0004=\u0002\u00199+X.\u001a:jGJ\u000bgnZ3\n\t\ru1q\u0004\u0002\n\u000bb\u001cG.^:jm\u0016T1a!\u0007y!\u0011\t)ia\t\n\t\r-\u0011q\u0012\u0005\b\u0003gQ\u0005\u0019AB\u0011\u0011\u001d\tID\u0013a\u0001\u0007CAq!!\u0010K\u0001\u0004\u0019\t\u0003\u0006\u0005\u0004.\rE21GB\u001b!\u0019\u0019)ba\f\u0004\"%!!\u0011YB\u0010\u0011\u001d\t\u0019d\u0013a\u0001\u0007CAq!!\u000fL\u0001\u0004\u0019\t\u0003C\u0004\u0002>-\u0003\ra!\t\u0002\t1{gn\u001a\t\u0004\u0007\u0013i5cA'\u0003FR\u00111\u0011\b\u000b\t\u0007\u0003\u001a\u0019e!\u0012\u0004HA11QCB\u000e\u0003+Bq!a\rP\u0001\u0004\t)\u0006C\u0004\u0002:=\u0003\r!!\u0016\t\u000f\u0005ur\n1\u0001\u0002VQA11JB'\u0007\u001f\u001a\t\u0006\u0005\u0004\u0004\u0016\r=\u0012Q\u000b\u0005\b\u0003g\u0001\u0006\u0019AA+\u0011\u001d\tI\u0004\u0015a\u0001\u0003+Bq!!\u0010Q\u0001\u0004\t)&\u0001\u0006CS\u001e$UmY5nC2\u00042a!\u0003S\u0005)\u0011\u0015n\u001a#fG&l\u0017\r\\\n\u0004%\n\u0015GCAB+\u0003A\u0011\u0017n\u001a#fG\u0006\u001b\u0018J\u001c;fOJ\fG.\u0006\u0002\u0004b9!11MB;\u001d\u0011\u0019)ga\u001c\u000f\t\r\u001d41\u000e\b\u0005\u0003\u001f\u001cI'C\u0001~\u0013\r\u0019i\u0007`\u0001\u0005[\u0006$\b.\u0003\u0003\u0004r\rM\u0014a\u0002(v[\u0016\u0014\u0018n\u0019\u0006\u0004\u0007[b\u0018\u0002BB<\u0007s\naCQ5h\t\u0016\u001c\u0017.\\1m\u0003NLe-\u00138uK\u001e\u0014\u0018\r\u001c\u0006\u0005\u0007c\u001a\u0019(A\tcS\u001e$UmY!t\u0013:$Xm\u001a:bY\u0002\"\u0002ba \u0004\u0006\u000e\u001d5\u0011\u0012\t\u0007\u0007+\u0019Yb!!\u0011\t\u0005\u001551Q\u0005\u0005\u0007/\ny\tC\u0004\u00024Y\u0003\ra!!\t\u000f\u0005eb\u000b1\u0001\u0004\u0002\"9\u0011Q\b,A\u0002\r\u0005E\u0003CBG\u0007\u001f\u001b\tja%\u0011\r\rU1qFBA\u0011\u001d\t\u0019d\u0016a\u0001\u0007\u0003Cq!!\u000fX\u0001\u0004\u0019\t\tC\u0004\u0002>]\u0003\ra!!\u0002\r\u0011{WO\u00197f!\r\u0019I!\u0017\u0002\u0007\t>,(\r\\3\u0014\u0007e\u0013)\r\u0006\u0002\u0004\u0018\u0006\u0001Bm\\;cY\u0016\f5/\u00138uK\u001e\u0014\u0018\r\\\u000b\u0003\u0007GsAaa\u0019\u0004&&!1qUB=\u0003I!u.\u001e2mK\u0006\u001b\u0018JZ%oi\u0016<'/\u00197\u0002#\u0011|WO\u00197f\u0003NLe\u000e^3he\u0006d\u0007%\u0001\u0003u_\n#E\u0003BBA\u0007_CqAa&`\u0001\u0004\u0019\t\f\u0005\u0003\u0002\f\rM\u0016bABMyRA1qWB_\u0007\u007f\u001b\t\r\u0005\u0004\u0002\u0014\re6\u0011W\u0005\u0004\u0007wC(\u0001\u0004(v[\u0016\u0014\u0018n\u0019*b]\u001e,\u0007bBA\u001aA\u0002\u00071\u0011\u0017\u0005\b\u0003s\u0001\u0007\u0019ABY\u0011\u001d\ti\u0004\u0019a\u0001\u0007cCs\u0001YBc\u0007\u0017\u001cy\r\u0005\u0003\u0002\f\r\u001d\u0017bABey\nQA-\u001a9sK\u000e\fG/\u001a3\"\u0005\r5\u0017\u0001H;tK\u0002\u0012\u0016M\\4f]\tKw\rR3dS6\fG\u000eI5ogR,\u0017\rZ\u0011\u0003\u0007#\faA\r\u00182e92D\u0003CB\\\u0007+\u001c9n!7\t\u000f\u0005M\u0012\r1\u0001\u00042\"9\u0011\u0011H1A\u0002\rE\u0006bBA\u001fC\u0002\u00071\u0011\u0017\u0015\bC\u000e\u00157Q\\BhC\t\u0019y.\u0001\u0014vg\u0016\u0004#+\u00198hK:\u0012\u0015n\u001a#fG&l\u0017\r\u001c\u0018j]\u000edWo]5wK\u0002Jgn\u001d;fC\u0012\u0014q\u0001U1si&\fG.\u0006\u0004\u0004f\u000eU81`\n\u0004E\u000e\u001d\b\u0003BA\u0006\u0007SL1aa;}\u0005\u0019\te.\u001f,bY\u0006Y3oY1mC\u0012\u001aw\u000e\u001c7fGRLwN\u001c\u0013j[6,H/\u00192mK\u0012\u0012\u0016M\\4fIA\u000b'\u000f^5bY\u0012\"c-\u0006\u0002\u0004rBA\u00111\u0002B\u0004\u0007g\u001cI\u0010\u0005\u0003\u0002\u0014\u000eUHaBB|E\n\u0007!\u0011\u0003\u0002\u0002)B!\u00111SB~\t\u001d\u0011yA\u0019b\u0001\u0005#\tAf]2bY\u0006$3m\u001c7mK\u000e$\u0018n\u001c8%S6lW\u000f^1cY\u0016$#+\u00198hK\u0012\u0002\u0016M\u001d;jC2$CE\u001a\u0011\u0015\t\u0011\u0005A1\u0001\t\b\u0007\u0013\u001171_B}\u0011\u001d\u0011\u0019!\u001aa\u0001\u0007c$Ba!?\u0005\b!9!q\u00134A\u0002\rMHC\u0001C\u0006!\u0011!i\u0001b\u0006\u000e\u0005\u0011=!\u0002\u0002C\t\t'\tA\u0001\\1oO*\u0011AQC\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002\\\u0012=\u0011\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005%A\u0003BA0\t?A\u0011\u0002\"\tj\u0003\u0003\u0005\r!a'\u0002\u0007a$\u0013'A\u0002J]R\u00042a!\u0003l'\rY'Q\u0019\u000b\u0003\tK!\u0002\u0002\"\f\u00050\u0011EB1\u0007\t\u0007\u0007+\u0019Y\"!\u0003\t\u000f\u0005MR\u000e1\u0001\u0002\n!9\u0011\u0011H7A\u0002\u0005%\u0001bBA\u001f[\u0002\u0007\u0011\u0011\u0002\u000b\t\to!I\u0004b\u000f\u0005>A11QCB\u0018\u0003\u0013Aq!a\ro\u0001\u0004\tI\u0001C\u0004\u0002:9\u0004\r!!\u0003\t\u000f\u0005ub\u000e1\u0001\u0002\n\u00059\u0001+\u0019:uS\u0006d\u0007cAB\u0005aN\u0019\u0001O!2\u0015\u0005\u0011\u0005\u0013\u0001\u00042zI\u0015DH/\u001a8tS>tWC\u0002C&\t/\"\t\u0006\u0006\u0003\u0005N\u0011eC\u0003\u0002C(\t'\u0002B!a%\u0005R\u00119!q\u0002:C\u0002\tE\u0001b\u0002BLe\u0002\u0007AQ\u000b\t\u0005\u0003'#9\u0006B\u0004\u0004xJ\u0014\rA!\u0005\t\u000f\u0011m#\u000f1\u0001\u0005^\u0005)A\u0005\u001e5jgB91\u0011\u00022\u0005V\u0011=\u0013A\u0005;p'R\u0014\u0018N\\4%Kb$XM\\:j_:,b\u0001b\u0019\u0005l\u0011=D\u0003\u0002C\u0005\tKBq\u0001b\u0017t\u0001\u0004!9\u0007E\u0004\u0004\n\t$I\u0007\"\u001c\u0011\t\u0005ME1\u000e\u0003\b\u0007o\u001c(\u0019\u0001B\t!\u0011\t\u0019\nb\u001c\u0005\u000f\t=1O1\u0001\u0003\u0012\u0005\u0011\u0002.Y:i\u0007>$W\rJ3yi\u0016t7/[8o+\u0019!)\b\" \u0005\u0002R!A1\u0004C<\u0011\u001d!Y\u0006\u001ea\u0001\ts\u0002ra!\u0003c\tw\"y\b\u0005\u0003\u0002\u0014\u0012uDaBB|i\n\u0007!\u0011\u0003\t\u0005\u0003'#\t\tB\u0004\u0003\u0010Q\u0014\rA!\u0005\u0002!\u0015\fX/\u00197tI\u0015DH/\u001a8tS>tWC\u0002CD\t'#9\n\u0006\u0003\u0005\n\u00125E\u0003BA0\t\u0017C\u0011\u0002\"\tv\u0003\u0003\u0005\r!a'\t\u000f\u0011mS\u000f1\u0001\u0005\u0010B91\u0011\u00022\u0005\u0012\u0012U\u0005\u0003BAJ\t'#qaa>v\u0005\u0004\u0011\t\u0002\u0005\u0003\u0002\u0014\u0012]Ea\u0002B\bk\n\u0007!\u0011C\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0005\u001eB!AQ\u0002CP\u0013\u0011!\t\u000bb\u0004\u0003\r=\u0013'.Z2u'\ra\u0014Q\t\u000b\t\tO#I\u000bb+\u0005.B\u00191\u0011\u0002\u001f\t\u000f\u0005M\u0002\t1\u0001\u0002\n!9\u0011\u0011\b!A\u0002\u0005%\u0001bBA\u001f\u0001\u0002\u0007\u0011\u0011\u0002\u000b\t\u0003\u000b\"\t\fb-\u00056\"9\u00111\u0007\"A\u0002\u0005%\u0001bBA\u001d\u0005\u0002\u0007\u0011\u0011\u0002\u0005\b\u0003{\u0011\u0005\u0019AA\u0005Q\u001d\u0001A\u0011\u0018B1\t\u007f\u0003B!a\u0003\u0005<&\u0019AQ\u0018?\u0003!M+'/[1m-\u0016\u00148/[8o+&#e\u0004C5<HS[[CM\u0007")
public class Range
extends AbstractSeq<Object>
implements scala.collection.immutable.IndexedSeq<Object>,
CustomParallelizable<Object, ParRange>,
Serializable {
    public static final long serialVersionUID = 7618862778670199309L;
    private final int start;
    private final int end;
    private final int step;
    private final boolean isEmpty;
    private final int scala$collection$immutable$Range$$numRangeElements;
    private final int scala$collection$immutable$Range$$lastElement;

    @Override
    public Combiner<Object, ParRange> parCombiner() {
        return CustomParallelizable.parCombiner$(this);
    }

    @Override
    public GenericCompanion<scala.collection.immutable.IndexedSeq> companion() {
        return scala.collection.immutable.IndexedSeq.companion$(this);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<Object> toIndexedSeq() {
        return scala.collection.immutable.IndexedSeq.toIndexedSeq$(this);
    }

    @Override
    public scala.collection.immutable.IndexedSeq<Object> seq() {
        return scala.collection.immutable.IndexedSeq.seq$(this);
    }

    @Override
    public int hashCode() {
        return IndexedSeqLike.hashCode$(this);
    }

    @Override
    public IndexedSeq<Object> thisCollection() {
        return IndexedSeqLike.thisCollection$(this);
    }

    @Override
    public IndexedSeq toCollection(Object repr) {
        return IndexedSeqLike.toCollection$(this, repr);
    }

    @Override
    public Iterator<Object> iterator() {
        return IndexedSeqLike.iterator$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return IndexedSeqLike.sizeHintIfCheap$(this);
    }

    public int start() {
        return this.start;
    }

    public int end() {
        return this.end;
    }

    public int step() {
        return this.step;
    }

    @Override
    public ParRange par() {
        return new ParRange(this);
    }

    private long gap() {
        return (long)this.end() - (long)this.start();
    }

    private boolean isExact() {
        return this.gap() % (long)this.step() == 0L;
    }

    private boolean hasStub() {
        return this.isInclusive() || !this.isExact();
    }

    private long longLength() {
        return this.gap() / (long)this.step() + (long)(this.hasStub() ? 1 : 0);
    }

    @Override
    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public int scala$collection$immutable$Range$$numRangeElements() {
        return this.scala$collection$immutable$Range$$numRangeElements;
    }

    public int scala$collection$immutable$Range$$lastElement() {
        return this.scala$collection$immutable$Range$$lastElement;
    }

    @Override
    public int last() {
        if (this.isEmpty()) {
            return BoxesRunTime.unboxToInt(Nil$.MODULE$.last());
        }
        return this.scala$collection$immutable$Range$$lastElement();
    }

    @Override
    public int head() {
        if (this.isEmpty()) {
            throw Nil$.MODULE$.head();
        }
        return this.start();
    }

    @Override
    public <A1> int min(Ordering<A1> ord) {
        if (ord == Ordering$Int$.MODULE$) {
            if (this.step() > 0) {
                return this.head();
            }
            return this.last();
        }
        return BoxesRunTime.unboxToInt(TraversableOnce.min$(this, ord));
    }

    @Override
    public <A1> int max(Ordering<A1> ord) {
        if (ord == Ordering$Int$.MODULE$) {
            if (this.step() > 0) {
                return this.last();
            }
            return this.head();
        }
        return BoxesRunTime.unboxToInt(TraversableOnce.max$(this, ord));
    }

    public Range copy(int start, int end, int step) {
        return new Range(start, end, step);
    }

    public Range by(int step) {
        return this.copy(this.start(), this.end(), step);
    }

    public boolean isInclusive() {
        return false;
    }

    @Override
    public int size() {
        return this.length();
    }

    @Override
    public int length() {
        if (this.scala$collection$immutable$Range$$numRangeElements() < 0) {
            throw this.fail();
        }
        return this.scala$collection$immutable$Range$$numRangeElements();
    }

    private String description() {
        String string = "%d %s %d by %s";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(this.start()), this.isInclusive() ? "to" : "until", BoxesRunTime.boxToInteger(this.end()), BoxesRunTime.boxToInteger(this.step())}));
    }

    private Nothing$ fail() {
        throw new IllegalArgumentException(new StringBuilder(54).append(this.description()).append(": seqs cannot contain more than Int.MaxValue elements.").toString());
    }

    public void scala$collection$immutable$Range$$validateMaxLength() {
        if (this.scala$collection$immutable$Range$$numRangeElements() < 0) {
            throw this.fail();
        }
    }

    @Override
    public final int apply(int idx) {
        return this.apply$mcII$sp(idx);
    }

    @Override
    public final <U> void foreach(Function1<Object, U> f) {
        if (!this.isEmpty()) {
            int i = this.start();
            while (true) {
                f.apply(BoxesRunTime.boxToInteger(i));
                if (i == this.scala$collection$immutable$Range$$lastElement()) {
                    return;
                }
                i += this.step();
            }
        }
    }

    @Override
    public final Range take(int n) {
        if (n <= 0 || this.isEmpty()) {
            return this.newEmptyRange(this.start());
        }
        if (n >= this.scala$collection$immutable$Range$$numRangeElements() && this.scala$collection$immutable$Range$$numRangeElements() >= 0) {
            return this;
        }
        return new Inclusive(this.start(), this.locationAfterN(n - 1), this.step());
    }

    @Override
    public final Range drop(int n) {
        if (n <= 0 || this.isEmpty()) {
            return this;
        }
        if (n >= this.scala$collection$immutable$Range$$numRangeElements() && this.scala$collection$immutable$Range$$numRangeElements() >= 0) {
            return this.newEmptyRange(this.end());
        }
        return this.copy(this.locationAfterN(n), this.end(), this.step());
    }

    @Override
    public Range slice(int from, int until) {
        if (from <= 0) {
            return this.take(until);
        }
        if (until >= this.scala$collection$immutable$Range$$numRangeElements() && this.scala$collection$immutable$Range$$numRangeElements() >= 0) {
            return this.drop(from);
        }
        int fromValue = this.locationAfterN(from);
        if (from >= until) {
            return this.newEmptyRange(fromValue);
        }
        return new Inclusive(fromValue, this.locationAfterN(until - 1), this.step());
    }

    @Override
    public final Range init() {
        if (this.isEmpty()) {
            Nil$.MODULE$.init();
        }
        return this.dropRight(1);
    }

    @Override
    public final Range tail() {
        if (this.isEmpty()) {
            Nil$.MODULE$.tail();
        }
        return this.drop(1);
    }

    private long argTakeWhile(Function1<Object, Object> p) {
        int current;
        if (this.isEmpty()) {
            return this.start();
        }
        int stop = this.last();
        for (current = this.start(); current != stop && p.apply$mcZI$sp(current); current += this.step()) {
        }
        if (current != stop || !p.apply$mcZI$sp(current)) {
            return current;
        }
        return (long)current + (long)this.step();
    }

    private int locationAfterN(int n) {
        return this.start() + this.step() * n;
    }

    private Range newEmptyRange(int value) {
        return new Range(value, value, this.step());
    }

    @Override
    public final Range takeWhile(Function1<Object, Object> p) {
        long l;
        long l2;
        if (this.isEmpty()) {
            l2 = this.start();
        } else {
            int argTakeWhile_current;
            int argTakeWhile_stop = this.last();
            for (argTakeWhile_current = this.start(); argTakeWhile_current != argTakeWhile_stop && p.apply$mcZI$sp(argTakeWhile_current); argTakeWhile_current += this.step()) {
            }
            l2 = l = argTakeWhile_current != argTakeWhile_stop || !p.apply$mcZI$sp(argTakeWhile_current) ? (long)argTakeWhile_current : (long)argTakeWhile_current + (long)this.step();
        }
        if (l == (long)this.start()) {
            return this.newEmptyRange(this.start());
        }
        int x = (int)(l - (long)this.step());
        if (x == this.last()) {
            return this;
        }
        return new Inclusive(this.start(), x, this.step());
    }

    @Override
    public final Range dropWhile(Function1<Object, Object> p) {
        long l;
        long l2;
        if (this.isEmpty()) {
            l2 = this.start();
        } else {
            int argTakeWhile_current;
            int argTakeWhile_stop = this.last();
            for (argTakeWhile_current = this.start(); argTakeWhile_current != argTakeWhile_stop && p.apply$mcZI$sp(argTakeWhile_current); argTakeWhile_current += this.step()) {
            }
            l2 = l = argTakeWhile_current != argTakeWhile_stop || !p.apply$mcZI$sp(argTakeWhile_current) ? (long)argTakeWhile_current : (long)argTakeWhile_current + (long)this.step();
        }
        if (l == (long)this.start()) {
            return this;
        }
        int x = (int)(l - (long)this.step());
        if (x == this.last()) {
            return this.newEmptyRange(this.last());
        }
        return new Inclusive(x + this.step(), this.last(), this.step());
    }

    @Override
    public final Tuple2<Range, Range> span(Function1<Object, Object> p) {
        long l;
        long l2;
        if (this.isEmpty()) {
            l2 = this.start();
        } else {
            int argTakeWhile_current;
            int argTakeWhile_stop = this.last();
            for (argTakeWhile_current = this.start(); argTakeWhile_current != argTakeWhile_stop && p.apply$mcZI$sp(argTakeWhile_current); argTakeWhile_current += this.step()) {
            }
            l2 = l = argTakeWhile_current != argTakeWhile_stop || !p.apply$mcZI$sp(argTakeWhile_current) ? (long)argTakeWhile_current : (long)argTakeWhile_current + (long)this.step();
        }
        if (l == (long)this.start()) {
            return new Tuple2<Range, Range>(this.newEmptyRange(this.start()), this);
        }
        int x = (int)(l - (long)this.step());
        if (x == this.last()) {
            return new Tuple2<Range, Range>(this, this.newEmptyRange(this.last()));
        }
        return new Tuple2<Range, Range>(new Inclusive(this.start(), x, this.step()), new Inclusive(x + this.step(), this.last(), this.step()));
    }

    @Override
    public final Tuple2<Range, Range> splitAt(int n) {
        return new Tuple2<Range, Range>(this.take(n), this.drop(n));
    }

    @Override
    public final Range takeRight(int n) {
        if (n <= 0) {
            return this.newEmptyRange(this.start());
        }
        if (this.scala$collection$immutable$Range$$numRangeElements() >= 0) {
            return this.drop(this.scala$collection$immutable$Range$$numRangeElements() - n);
        }
        int y = this.last();
        long x = (long)y - (long)this.step() * (long)(n - 1);
        if (this.step() > 0 && x < (long)this.start() || this.step() < 0 && x > (long)this.start()) {
            return this;
        }
        return new Inclusive((int)x, y, this.step());
    }

    @Override
    public final Range dropRight(int n) {
        if (n <= 0) {
            return this;
        }
        if (this.scala$collection$immutable$Range$$numRangeElements() >= 0) {
            return this.take(this.scala$collection$immutable$Range$$numRangeElements() - n);
        }
        int y = this.last() - this.step() * n;
        if (this.step() > 0 && y < this.start() || this.step() < 0 && y > this.start()) {
            return this.newEmptyRange(this.start());
        }
        return new Inclusive(this.start(), y, this.step());
    }

    @Override
    public final Range reverse() {
        if (this.isEmpty()) {
            return this;
        }
        return new Inclusive(this.last(), this.start(), -this.step());
    }

    public Range inclusive() {
        if (this.isInclusive()) {
            return this;
        }
        return new Inclusive(this.start(), this.end(), this.step());
    }

    @Override
    public final boolean contains(int x) {
        if (x == this.end() && !this.isInclusive()) {
            return false;
        }
        if (this.step() > 0) {
            if (x < this.start() || x > this.end()) {
                return false;
            }
            return this.step() == 1 || (x - this.start()) % this.step() == 0;
        }
        if (x < this.end() || x > this.start()) {
            return false;
        }
        return this.step() == -1 || (x - this.start()) % this.step() == 0;
    }

    @Override
    public final <B> int sum(Numeric<B> num) {
        if (num == Numeric$IntIsIntegral$.MODULE$) {
            if (this.isEmpty()) {
                return 0;
            }
            if (this.scala$collection$immutable$Range$$numRangeElements() == 1) {
                return this.head();
            }
            return (int)((long)this.scala$collection$immutable$Range$$numRangeElements() * ((long)this.head() + (long)this.last()) / 2L);
        }
        if (this.isEmpty()) {
            return num.toInt(num.zero());
        }
        Object acc = num.zero();
        int i = this.head();
        while (true) {
            acc = num.plus(acc, BoxesRunTime.boxToInteger(i));
            if (i == this.scala$collection$immutable$Range$$lastElement()) {
                return num.toInt(acc);
            }
            i += this.step();
        }
    }

    @Override
    public Range toIterable() {
        return this;
    }

    @Override
    public Range toSeq() {
        return this;
    }

    @Override
    public boolean equals(Object other) {
        int l0;
        Range range;
        boolean bl = other instanceof Range ? (range = (Range)other).canEqual(this) && (this.isEmpty() ? range.isEmpty() : range.nonEmpty() && this.start() == range.start() && (l0 = this.last()) == range.last() && (this.start() == l0 || this.step() == range.step())) : GenSeqLike.equals$(this, other);
        return bl;
    }

    @Override
    public String toString() {
        String stepped;
        String preposition = this.isInclusive() ? "to" : "until";
        String string = stepped = this.step() == 1 ? "" : new StringBuilder(4).append(" by ").append(this.step()).toString();
        String prefix = this.isEmpty() ? "empty " : (!this.isExact() ? "inexact " : "");
        return new StringBuilder(8).append(prefix).append("Range ").append(this.start()).append(" ").append(preposition).append(" ").append(this.end()).append(stepped).toString();
    }

    public final void foreach$mVc$sp(Function1<Object, BoxedUnit> f) {
        if (!this.isEmpty()) {
            int i = this.start();
            while (true) {
                f.apply$mcVI$sp(i);
                if (i == this.scala$collection$immutable$Range$$lastElement()) {
                    return;
                }
                i += this.step();
            }
        }
    }

    @Override
    public int apply$mcII$sp(int idx) {
        this.scala$collection$immutable$Range$$validateMaxLength();
        if (idx < 0 || idx >= this.scala$collection$immutable$Range$$numRangeElements()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }
        return this.start() + this.step() * idx;
    }

    public Range(int start, int end, int step) {
        int n;
        long len;
        this.start = start;
        this.end = end;
        this.step = step;
        Traversable.$init$(this);
        Iterable.$init$(this);
        Seq.$init$(this);
        IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        scala.collection.immutable.IndexedSeq.$init$(this);
        CustomParallelizable.$init$(this);
        boolean bl = this.isEmpty = start > end && step > 0 || start < end && step < 0 || start == end && !this.isInclusive();
        if (step == 0) {
            throw new IllegalArgumentException("step cannot be 0.");
        }
        this.scala$collection$immutable$Range$$numRangeElements = this.isEmpty() ? 0 : ((len = this.longLength()) > Integer.MAX_VALUE ? -1 : (int)len);
        switch (step) {
            case 1: {
                if (this.isInclusive()) {
                    n = end;
                    break;
                }
                n = end - 1;
                break;
            }
            case -1: {
                if (this.isInclusive()) {
                    n = end;
                    break;
                }
                n = end + 1;
                break;
            }
            default: {
                int remainder = (int)(this.gap() % (long)step);
                n = remainder != 0 ? end - remainder : (this.isInclusive() ? end : end - step);
            }
        }
        this.scala$collection$immutable$Range$$lastElement = n;
    }

    public static final class Inclusive
    extends Range {
        @Override
        public boolean isInclusive() {
            return true;
        }

        @Override
        public Range copy(int start, int end, int step) {
            return new Inclusive(start, end, step);
        }

        public Inclusive(int start, int end, int step) {
            super(start, end, step);
        }
    }

    public static final class Partial<T, U> {
        private final Function1<T, U> scala$collection$immutable$Range$Partial$$f;

        public Function1<T, U> scala$collection$immutable$Range$Partial$$f() {
            return this.scala$collection$immutable$Range$Partial$$f;
        }

        public U by(T x) {
            return Range$Partial$.MODULE$.by$extension(this.scala$collection$immutable$Range$Partial$$f(), x);
        }

        public String toString() {
            return Range$Partial$.MODULE$.toString$extension(this.scala$collection$immutable$Range$Partial$$f());
        }

        public int hashCode() {
            return Range$Partial$.MODULE$.hashCode$extension(this.scala$collection$immutable$Range$Partial$$f());
        }

        public boolean equals(Object x$1) {
            return Range$Partial$.MODULE$.equals$extension(this.scala$collection$immutable$Range$Partial$$f(), x$1);
        }

        public Partial(Function1<T, U> f) {
            this.scala$collection$immutable$Range$Partial$$f = f;
        }
    }
}

