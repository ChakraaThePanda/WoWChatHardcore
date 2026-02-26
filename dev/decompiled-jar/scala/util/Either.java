/*
 * Decompiled with CFR 0.152.
 */
package scala.util;

import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Seq$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;
import scala.util.Either$;
import scala.util.Either$MergeableEither$;
import scala.util.Failure;
import scala.util.Left;
import scala.util.Right;
import scala.util.Success;
import scala.util.Try;

@ScalaSignature(bytes="\u0006\u0001\u0015\u001dd!\u00024h\u0003Ca\u0007\"\u0002=\u0001\t\u0003I\bbBA\u000b\u0001\u0011\u0005\u0011q\u0003\u0005\b\u0003\u0003\u0002A\u0011\u0001C:\u0011\u001d!9\b\u0001C\u0001\tsBq\u0001b$\u0001\t\u0003!\t\nC\u0004\u0005\u0016\u0002!\t\u0001b&\t\u000f\u0011]\u0006\u0001\"\u0001\u0005:\"9\u0011Q\u0017\u0001\u0005\u0002\u0011=\u0007bBAi\u0001\u0011\u0005A1\u001c\u0005\b\tO\u0004AQ\u0001Cu\u0011\u001d\t)\u000f\u0001C\u0001\tkDqAa\u0013\u0001\t\u0003!Y\u0010C\u0004\u0003d\u0001!\t\u0001b@\t\u000f\tm\u0004\u0001\"\u0001\u0006\u0012!9Qq\u0004\u0001\u0005\u0002\u0015\u0005\u0002b\u0002BP\u0001\u0011\u0005Q1\u0007\u0005\b\u0005c\u0003A\u0011AC \u0011\u001d)\u0019\u0005\u0001C\u0001\u000b\u000bBq!b\u0016\u0001\r\u0003)I\u0006C\u0004\u0006\\\u00011\t!\"\u0017\b\u000f\u0005uq\r#\u0001\u0002 \u00191am\u001aE\u0001\u0003CAa\u0001\u001f\f\u0005\u0002\u0005\r\u0002bBA\u0013-\u0011\u0005\u0011q\u0005\u0004\u0007\u0003\u001b22!a\u0014\t\u001d\u0005e\u0013\u0004\"A\u0001\u0006\u000b\u0015\r\u0011\"\u0003\u0002\\!Y\u00111M\r\u0003\u0006\u0003\u0005\u000b\u0011BA/\u0011\u0019A\u0018\u0004\"\u0001\u0002f!9\u0011qN\r\u0005\u0002\u0005E\u0004\"CA:3\u0005\u0005I\u0011IA;\u0011%\ti(GA\u0001\n\u0003\ny\bC\u0005\u0002\u0006Z\t\t\u0011b\u0001\u0002\b\u001a1\u0011Q\u0013\fC\u0003/C!\"a'\"\u0005+\u0007I\u0011AAO\u0011)\tI+\tB\tB\u0003%\u0011q\u0014\u0005\u0007q\u0006\"\t!a+\t\u000f\u0005E\u0016\u0005\"\u0001\u00024\"9\u0011QW\u0011\u0005\u0002\u0005]\u0006bBAiC\u0011\u0005\u00111\u001b\u0005\b\u0003K\fC\u0011AAt\u0011\u001d\u0011Y%\tC\u0001\u0005\u001bBqAa\u0019\"\t\u0003\u0011)\u0007C\u0004\u0003|\u0005\"\tA! \t\u000f\t-\u0015\u0005\"\u0001\u0003\u000e\"9!qT\u0011\u0005\u0002\t\u0005\u0006b\u0002BYC\u0011\u0005!1\u0017\u0005\n\u0005o\u000b\u0013\u0011!C\u0001\u0005sC\u0011Ba3\"#\u0003%\tA!4\t\u0013\t%\u0018%!A\u0005B\t-\b\"\u0003B~C\u0005\u0005I\u0011\u0001B\u007f\u0011%\u0011y0IA\u0001\n\u0003\u0019\t\u0001C\u0005\u0004\u0006\u0005\n\t\u0011\"\u0011\u0004\b!I1QC\u0011\u0002\u0002\u0013\u00051q\u0003\u0005\n\u0003g\n\u0013\u0011!C!\u0003kB\u0011ba\u0007\"\u0003\u0003%\te!\b\t\u0013\u0005u\u0014%!A\u0005B\r}q!CB\u0012-\u0005\u0005\t\u0012AB\u0013\r%\t)JFA\u0001\u0012\u0003\u00199\u0003\u0003\u0004yu\u0011\u00051\u0011\u0006\u0005\n\u00077Q\u0014\u0011!C#\u0007;A\u0011B!\u0003;\u0003\u0003%\tia\u000b\t\u0013\ru\"(!A\u0005\u0002\u000e}\u0002\"CB+u\u0005\u0005I\u0011BB,\r\u0019\u0019yF\u0006\"\u0004b!Q\u00111\u0014!\u0003\u0016\u0004%\ta!\u001a\t\u0015\u0005%\u0006I!E!\u0002\u0013\u00199\u0007\u0003\u0004y\u0001\u0012\u00051\u0011\u000f\u0005\b\u0003c\u0003E\u0011AB<\u0011\u001d\t)\f\u0011C\u0001\u0007sBq!!5A\t\u0003\u0019)\tC\u0004\u0002f\u0002#\taa%\t\u000f\t-\u0003\t\"\u0001\u0004\u001a\"9!1\r!\u0005\u0002\r=\u0006b\u0002B>\u0001\u0012\u000511\u0019\u0005\b\u0005\u0017\u0003E\u0011ABi\u0011\u001d\u0011y\n\u0011C\u0001\u0007?DqA!-A\t\u0003\u0019\u0019\u000fC\u0005\u00038\u0002\u000b\t\u0011\"\u0001\u0004h\"I!1\u001a!\u0012\u0002\u0013\u00051\u0011 \u0005\n\u0005S\u0004\u0015\u0011!C!\u0005WD\u0011Ba?A\u0003\u0003%\tA!@\t\u0013\t}\b)!A\u0005\u0002\u0011\r\u0001\"CB\u0003\u0001\u0006\u0005I\u0011IB\u0004\u0011%\u0019)\u0002QA\u0001\n\u0003!9\u0001C\u0005\u0002t\u0001\u000b\t\u0011\"\u0011\u0002v!I11\u0004!\u0002\u0002\u0013\u00053Q\u0004\u0005\n\u0003{\u0002\u0015\u0011!C!\t\u00179\u0011\u0002b\u0004\u0017\u0003\u0003E\t\u0001\"\u0005\u0007\u0013\r}c#!A\t\u0002\u0011M\u0001B\u0002=Z\t\u0003!)\u0002C\u0005\u0004\u001ce\u000b\t\u0011\"\u0012\u0004\u001e!I!\u0011B-\u0002\u0002\u0013\u0005Eq\u0003\u0005\n\u0007{I\u0016\u0011!CA\tSA\u0011b!\u0016Z\u0003\u0003%Iaa\u0016\b\u0013\u0005\u0015e#!A\t\u0002\u0011ub!CA'-\u0005\u0005\t\u0012\u0001C \u0011\u0019A\b\r\"\u0001\u0005B!9A1\t1\u0005\u0006\u0011\u0015\u0003\"\u0003C*A\u0006\u0005IQ\u0001C+\u0011%!\t\u0007YA\u0001\n\u000b!\u0019\u0007C\u0005\u0004VY\t\t\u0011\"\u0003\u0004X\t1Q)\u001b;iKJT!\u0001[5\u0002\tU$\u0018\u000e\u001c\u0006\u0002U\u0006)1oY1mC\u000e\u0001Q\u0003B7\u007f\u0003#\u0019B\u0001\u00018skB\u0011q\u000e]\u0007\u0002S&\u0011\u0011/\u001b\u0002\u0007\u0003:L(+\u001a4\u0011\u0005=\u001c\u0018B\u0001;j\u0005\u001d\u0001&o\u001c3vGR\u0004\"a\u001c<\n\u0005]L'\u0001D*fe&\fG.\u001b>bE2,\u0017A\u0002\u001fj]&$h\bF\u0001{!\u0015Y\b\u0001`A\b\u001b\u00059\u0007CA?\u007f\u0019\u0001!qa \u0001\u0005\u0006\u0004\t\tAA\u0001B#\u0011\t\u0019!!\u0003\u0011\u0007=\f)!C\u0002\u0002\b%\u0014qAT8uQ&tw\rE\u0002p\u0003\u0017I1!!\u0004j\u0005\r\te.\u001f\t\u0004{\u0006EA\u0001CA\n\u0001\u0011\u0015\r!!\u0001\u0003\u0003\t\u000bA\u0001\\3giV\u0011\u0011\u0011\u0004\t\u0007\u00037\tC0a\u0004\u000f\u0005m,\u0012AB#ji\",'\u000f\u0005\u0002|-M\u0019aC\\;\u0015\u0005\u0005}\u0011\u0001B2p]\u0012,b!!\u000b\u00020\u0005MB\u0003CA\u0016\u0003k\ty$!\u0013\u0011\rm\u0004\u0011QFA\u0019!\ri\u0018q\u0006\u0003\u0007\u007fb\u0011\r!!\u0001\u0011\u0007u\f\u0019\u0004B\u0004\u0002\u0014a\u0011\r!!\u0001\t\u000f\u0005]\u0002\u00041\u0001\u0002:\u0005!A/Z:u!\ry\u00171H\u0005\u0004\u0003{I'a\u0002\"p_2,\u0017M\u001c\u0005\t\u0003\u0003BB\u00111\u0001\u0002D\u0005)!/[4iiB)q.!\u0012\u00022%\u0019\u0011qI5\u0003\u0011q\u0012\u0017P\\1nKzB\u0001\"!\u0006\u0019\t\u0003\u0007\u00111\n\t\u0006_\u0006\u0015\u0013Q\u0006\u0002\u0010\u001b\u0016\u0014x-Z1cY\u0016,\u0015\u000e\u001e5feV!\u0011\u0011KA1'\rI\u00121\u000b\t\u0004_\u0006U\u0013bAA,S\n1\u0011I\\=WC2\fAe]2bY\u0006$S\u000f^5mI\u0015KG\u000f[3sI5+'oZ3bE2,W)\u001b;iKJ$C\u0005_\u000b\u0003\u0003;\u0002ba\u001f\u0001\u0002`\u0005}\u0003cA?\u0002b\u00111q0\u0007b\u0001\u0003\u0003\tQe]2bY\u0006$S\u000f^5mI\u0015KG\u000f[3sI5+'oZ3bE2,W)\u001b;iKJ$C\u0005\u001f\u0011\u0015\t\u0005\u001d\u00141\u000e\t\u0006\u0003SJ\u0012qL\u0007\u0002-!9\u0011Q\u000e\u000fA\u0002\u0005u\u0013!\u0001=\u0002\u000b5,'oZ3\u0016\u0005\u0005}\u0013\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005]\u0004cA8\u0002z%\u0019\u00111P5\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003s\t\t\tC\u0005\u0002\u0004~\t\t\u00111\u0001\u0002\n\u0005\u0019\u0001\u0010J\u0019\u0002\u001f5+'oZ3bE2,W)\u001b;iKJ,B!!#\u0002\u0010R!\u00111RAI!\u0015\tI'GAG!\ri\u0018q\u0012\u0003\u0007\u007f\u0002\u0012\r!!\u0001\t\u000f\u00055\u0004\u00051\u0001\u0002\u0014B11\u0010AAG\u0003\u001b\u0013a\u0002T3giB\u0013xN[3di&|g.\u0006\u0004\u0002\u001a\u0006\r\u0016qU\n\u0005C9\u0014X/A\u0001f+\t\ty\n\u0005\u0004|\u0001\u0005\u0005\u0016Q\u0015\t\u0004{\u0006\rFaB@\"\t\u000b\u0007\u0011\u0011\u0001\t\u0004{\u0006\u001dF\u0001CA\nC\u0011\u0015\r!!\u0001\u0002\u0005\u0015\u0004C\u0003BAW\u0003_\u0003r!!\u001b\"\u0003C\u000b)\u000bC\u0004\u0002\u001c\u0012\u0002\r!a(\u0002\u0007\u001d,G/\u0006\u0002\u0002\"\u00069am\u001c:fC\u000eDW\u0003BA]\u0003\u001b$B!a/\u0002BB\u0019q.!0\n\u0007\u0005}\u0016N\u0001\u0003V]&$\bbBAbM\u0001\u0007\u0011QY\u0001\u0002MB9q.a2\u0002\"\u0006-\u0017bAAeS\nIa)\u001e8di&|g.\r\t\u0004{\u00065GaBAhM\t\u0007\u0011\u0011\u0001\u0002\u0002+\u0006Iq-\u001a;Pe\u0016c7/Z\u000b\u0005\u0003+\fI\u000e\u0006\u0003\u0002X\u0006}\u0007cA?\u0002Z\u00129\u00111\\\u0014C\u0002\u0005u'AA!2#\u0011\t\t+!\u0003\t\u0011\u0005\u0005x\u0005\"a\u0001\u0003G\f!a\u001c:\u0011\u000b=\f)%a6\u0002\r\u0019|'/\u00197m)\u0011\tI$!;\t\u000f\u0005-\b\u00061\u0001\u0002n\u0006\t\u0001\u000fE\u0004p\u0003\u000f\f\t+!\u000f)\u0011\u0005%\u0018\u0011_A|\u0005o\u00012a\\Az\u0013\r\t)0\u001b\u0002\u000fI\u0016\u0004(/Z2bi\u0016$g*Y7fc\u001dy\u0012\u0011`A\u0000\u0005c\u00012a\\A~\u0013\r\ti0\u001b\u0002\u0007'fl'm\u001c72\u0013\r\u0012\tAa\u0002\u0003&\t%A\u0003BA}\u0005\u0007AqA!\u0002l\u0001\u0004\u0011y!\u0001\u0003oC6,\u0017\u0002\u0002B\u0005\u0005\u0017\tQ!\u00199qYfT1A!\u0004j\u0003\u0019\u0019\u00160\u001c2pYB!!\u0011\u0003B\u0010\u001d\u0011\u0011\u0019Ba\u0007\u0011\u0007\tU\u0011.\u0004\u0002\u0003\u0018)\u0019!\u0011D6\u0002\rq\u0012xn\u001c;?\u0013\r\u0011i\"[\u0001\u0007!J,G-\u001a4\n\t\t\u0005\"1\u0005\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\tu\u0011.M\u0005$\u0005O\u0011iCa\f\u0003\u000e9!!\u0011\u0006B\u0017\u001d\u0011\u0011)Ba\u000b\n\u0003)L1A!\u0004jc\u0019!#\u0011\u0006B\u0016UF*QEa\r\u00036=\u0011!QG\u0011\u0003\u0003\u0007\f\u0014b\tB\b\u0005s\u0011\tEa\u000f\n\t\tm\"QH\u0001\u001cI1,7o]5oSR$sM]3bi\u0016\u0014H\u0005Z3gCVdG\u000f\n\u001a\u000b\u0007\t}\u0012.\u0001\beKB\u0014XmY1uK\u0012t\u0015-\\32\u0013\r\u0012\u0019E!\u0012\u0003H\t}bbA8\u0003F%\u0019!qH52\u000b\tz\u0017N!\u0013\u0003\u000bM\u001c\u0017\r\\1\u0002\r\u0015D\u0018n\u001d;t)\u0011\tIDa\u0014\t\u000f\u0005-\u0018\u00061\u0001\u0002n\"B!qJAy\u0005'\u0012i&M\u0004 \u0003s\u0014)Fa\u00172\u0013\r\u0012\tAa\u0002\u0003X\t%\u0011'C\u0012\u0003(\t5\"\u0011\fB\u0007c\u0019!#\u0011\u0006B\u0016UF*QEa\r\u00036EJ1Ea\u0004\u0003:\t}#1H\u0019\nG\t\r#Q\tB1\u0005\u007f\tTAI8j\u0005\u0013\nqA\u001a7bi6\u000b\u0007/\u0006\u0004\u0003h\t5$\u0011\u000f\u000b\u0005\u0005S\u00129\b\u0005\u0004|\u0001\t-$q\u000e\t\u0004{\n5DaBAnU\t\u0007\u0011\u0011\u0001\t\u0004{\nEDa\u0002B:U\t\u0007!Q\u000f\u0002\u0003\u0005F\nB!!*\u0002\n!9\u00111\u0019\u0016A\u0002\te\u0004cB8\u0002H\u0006\u0005&\u0011N\u0001\u0004[\u0006\u0004X\u0003\u0002B@\u0005\u000b#BA!!\u0003\bB11\u0010\u0001BB\u0003K\u00032! BC\t\u001d\tYn\u000bb\u0001\u0003\u0003Aq!a1,\u0001\u0004\u0011I\tE\u0004p\u0003\u000f\f\tKa!\u0002\r\u0019LG\u000e^3s+\u0011\u0011yIa'\u0015\t\tE%Q\u0014\t\u0006_\nM%qS\u0005\u0004\u0005+K'AB(qi&|g\u000e\u0005\u0004|\u0001\u0005\u0005&\u0011\u0014\t\u0004{\nmEa\u0002B:Y\t\u0007\u0011\u0011\u0001\u0005\b\u0003Wd\u0003\u0019AAw\u0003\u0015!xnU3r+\t\u0011\u0019\u000b\u0005\u0004\u0003&\n-\u0016\u0011\u0015\b\u0004_\n\u001d\u0016b\u0001BUS\u00069\u0001/Y2lC\u001e,\u0017\u0002\u0002BW\u0005_\u00131aU3r\u0015\r\u0011I+[\u0001\ti>|\u0005\u000f^5p]V\u0011!Q\u0017\t\u0006_\nM\u0015\u0011U\u0001\u0005G>\u0004\u00180\u0006\u0004\u0003<\n\u0005'Q\u0019\u000b\u0005\u0005{\u00139\rE\u0004\u0002j\u0005\u0012yLa1\u0011\u0007u\u0014\t\r\u0002\u0004\u0000_\t\u0007\u0011\u0011\u0001\t\u0004{\n\u0015GaBA\n_\t\u0007\u0011\u0011\u0001\u0005\n\u00037{\u0003\u0013!a\u0001\u0005\u0013\u0004ba\u001f\u0001\u0003@\n\r\u0017AD2paf$C-\u001a4bk2$H%M\u000b\u0007\u0005\u001f\u0014)Oa:\u0016\u0005\tE'\u0006BAP\u0005'\\#A!6\u0011\t\t]'\u0011]\u0007\u0003\u00053TAAa7\u0003^\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0004\u0005?L\u0017AC1o]>$\u0018\r^5p]&!!1\u001dBm\u0005E)hn\u00195fG.,GMV1sS\u0006t7-\u001a\u0003\u0007\u007fB\u0012\r!!\u0001\u0005\u000f\u0005M\u0001G1\u0001\u0002\u0002\u0005i\u0001O]8ek\u000e$\bK]3gSb,\"A!<\u0011\t\t=(\u0011`\u0007\u0003\u0005cTAAa=\u0003v\u0006!A.\u00198h\u0015\t\u001190\u0001\u0003kCZ\f\u0017\u0002\u0002B\u0011\u0005c\fA\u0002\u001d:pIV\u001cG/\u0011:jif,\"!a\u001e\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR!\u0011\u0011BB\u0002\u0011%\t\u0019iMA\u0001\u0002\u0004\t9(A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\t\u0019I\u0001\u0005\u0004\u0004\f\rE\u0011\u0011B\u0007\u0003\u0007\u001bQ1aa\u0004j\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0007'\u0019iA\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dG\u0003BA\u001d\u00073A\u0011\"a!6\u0003\u0003\u0005\r!!\u0003\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"A!<\u0015\t\u0005e2\u0011\u0005\u0005\n\u0003\u0007C\u0014\u0011!a\u0001\u0003\u0013\ta\u0002T3giB\u0013xN[3di&|g\u000eE\u0002\u0002ji\u001a2A\u000f8v)\t\u0019)#\u0006\u0004\u0004.\rM2q\u0007\u000b\u0005\u0007_\u0019I\u0004E\u0004\u0002j\u0005\u001a\td!\u000e\u0011\u0007u\u001c\u0019\u0004\u0002\u0004\u0000{\t\u0007\u0011\u0011\u0001\t\u0004{\u000e]BaBA\n{\t\u0007\u0011\u0011\u0001\u0005\b\u00037k\u0004\u0019AB\u001e!\u0019Y\ba!\r\u00046\u00059QO\\1qa2LXCBB!\u0007\u0013\u001ai\u0005\u0006\u0003\u0004D\r=\u0003#B8\u0003\u0014\u000e\u0015\u0003CB>\u0001\u0007\u000f\u001aY\u0005E\u0002~\u0007\u0013\"aa  C\u0002\u0005\u0005\u0001cA?\u0004N\u00119\u00111\u0003 C\u0002\u0005\u0005\u0001\"CB)}\u0005\u0005\t\u0019AB*\u0003\rAH\u0005\r\t\b\u0003S\n3qIB&\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\re\u0003\u0003\u0002Bx\u00077JAa!\u0018\u0003r\n1qJ\u00196fGR\u0014qBU5hQR\u0004&o\u001c6fGRLwN\\\u000b\u0007\u0007G\u001aYga\u001c\u0014\t\u0001s'/^\u000b\u0003\u0007O\u0002ba\u001f\u0001\u0004j\r5\u0004cA?\u0004l\u00119q\u0010\u0011CC\u0002\u0005\u0005\u0001cA?\u0004p\u0011A\u00111\u0003!\u0005\u0006\u0004\t\t\u0001\u0006\u0003\u0004t\rU\u0004cBA5\u0001\u000e%4Q\u000e\u0005\b\u00037\u001b\u0005\u0019AB4+\t\u0019i'\u0006\u0003\u0004|\r\rE\u0003BA^\u0007{Bq!a1F\u0001\u0004\u0019y\bE\u0004p\u0003\u000f\u001cig!!\u0011\u0007u\u001c\u0019\tB\u0004\u0002P\u0016\u0013\r!!\u0001\u0016\t\r\u001d51\u0012\u000b\u0005\u0007\u0013\u001by\tE\u0002~\u0007\u0017#qAa\u001dG\u0005\u0004\u0019i)\u0005\u0003\u0004n\u0005%\u0001\u0002CAq\r\u0012\u0005\ra!%\u0011\u000b=\f)e!#\u0015\t\u0005e2Q\u0013\u0005\b\u0003\u0007<\u0005\u0019ABL!\u001dy\u0017qYB7\u0003s!B!!\u000f\u0004\u001c\"9\u00111\u001e%A\u0002\r]\u0005\u0006CBN\u0003c\u001cyj!+2\u000f}\tIp!)\u0004(FJ1E!\u0001\u0003\b\r\r&\u0011B\u0019\nG\t\u001d\"QFBS\u0005\u001b\td\u0001\nB\u0015\u0005WQ\u0017'B\u0013\u00034\tU\u0012'C\u0012\u0003\u0010\te21\u0016B\u001ec%\u0019#1\tB#\u0007[\u0013y$M\u0003#_&\u0014I%\u0006\u0004\u00042\u000e]6Q\u0018\u000b\u0005\u0007g\u001by\f\u0005\u0004|\u0001\rU61\u0018\t\u0004{\u000e]FaBAn\u0013\n\u00071\u0011X\t\u0005\u0007S\nI\u0001E\u0002~\u0007{#qAa\u001dJ\u0005\u0004\t\t\u0001C\u0004\u0002D&\u0003\ra!1\u0011\u000f=\f9m!\u001c\u00044V!1QYBf)\u0011\u00199m!4\u0011\rm\u00041\u0011NBe!\ri81\u001a\u0003\b\u0005gR%\u0019AA\u0001\u0011\u001d\t\u0019M\u0013a\u0001\u0007\u001f\u0004ra\\Ad\u0007[\u001aI-\u0006\u0003\u0004T\u000emG\u0003BBk\u0007;\u0004Ra\u001cBJ\u0007/\u0004ba\u001f\u0001\u0004Z\u000e5\u0004cA?\u0004\\\u00129\u00111\\&C\u0002\u0005\u0005\u0001bBAv\u0017\u0002\u00071qS\u000b\u0003\u0007C\u0004bA!*\u0003,\u000e5TCABs!\u0015y'1SB7+\u0019\u0019Ioa<\u0004tR!11^B{!\u001d\tI\u0007QBw\u0007c\u00042!`Bx\t\u0019yhJ1\u0001\u0002\u0002A\u0019Qpa=\u0005\u000f\u0005MaJ1\u0001\u0002\u0002!I\u00111\u0014(\u0011\u0002\u0003\u00071q\u001f\t\u0007w\u0002\u0019io!=\u0016\r\rm8q C\u0001+\t\u0019iP\u000b\u0003\u0004h\tMGAB@P\u0005\u0004\t\t\u0001B\u0004\u0002\u0014=\u0013\r!!\u0001\u0015\t\u0005%AQ\u0001\u0005\n\u0003\u0007\u0013\u0016\u0011!a\u0001\u0003o\"B!!\u000f\u0005\n!I\u00111\u0011+\u0002\u0002\u0003\u0007\u0011\u0011\u0002\u000b\u0005\u0003s!i\u0001C\u0005\u0002\u0004^\u000b\t\u00111\u0001\u0002\n\u0005y!+[4iiB\u0013xN[3di&|g\u000eE\u0002\u0002je\u001b2!\u00178v)\t!\t\"\u0006\u0004\u0005\u001a\u0011}A1\u0005\u000b\u0005\t7!)\u0003E\u0004\u0002j\u0001#i\u0002\"\t\u0011\u0007u$y\u0002\u0002\u0004\u00009\n\u0007\u0011\u0011\u0001\t\u0004{\u0012\rBaBA\n9\n\u0007\u0011\u0011\u0001\u0005\b\u00037c\u0006\u0019\u0001C\u0014!\u0019Y\b\u0001\"\b\u0005\"U1A1\u0006C\u001a\to!B\u0001\"\f\u0005:A)qNa%\u00050A11\u0010\u0001C\u0019\tk\u00012! C\u001a\t\u0019yXL1\u0001\u0002\u0002A\u0019Q\u0010b\u000e\u0005\u000f\u0005MQL1\u0001\u0002\u0002!I1\u0011K/\u0002\u0002\u0003\u0007A1\b\t\b\u0003S\u0002E\u0011\u0007C\u001b!\r\tI\u0007Y\n\u0003A:$\"\u0001\"\u0010\u0002\u001f5,'oZ3%Kb$XM\\:j_:,B\u0001b\u0012\u0005LQ!A\u0011\nC'!\riH1\n\u0003\u0007\u007f\n\u0014\r!!\u0001\t\u000f\u0011=#\r1\u0001\u0005R\u0005)A\u0005\u001e5jgB)\u0011\u0011N\r\u0005J\u0005\u0011\u0002.Y:i\u0007>$W\rJ3yi\u0016t7/[8o+\u0011!9\u0006b\u0018\u0015\t\u0005UD\u0011\f\u0005\b\t\u001f\u001a\u0007\u0019\u0001C.!\u0015\tI'\u0007C/!\riHq\f\u0003\u0007\u007f\u000e\u0014\r!!\u0001\u0002!\u0015\fX/\u00197tI\u0015DH/\u001a8tS>tW\u0003\u0002C3\tc\"B\u0001b\u001a\u0005lQ!\u0011\u0011\bC5\u0011%\t\u0019\tZA\u0001\u0002\u0004\tI\u0001C\u0004\u0005P\u0011\u0004\r\u0001\"\u001c\u0011\u000b\u0005%\u0014\u0004b\u001c\u0011\u0007u$\t\b\u0002\u0004\u0000I\n\u0007\u0011\u0011A\u000b\u0003\tk\u0002b!a\u0007Ay\u0006=\u0011\u0001\u00024pY\u0012,B\u0001b\u001f\u0005\u0000Q1AQ\u0010CB\t\u0013\u00032! C@\t\u001d!\t\t\u0002b\u0001\u0003\u0003\u0011\u0011a\u0011\u0005\b\t\u000b#\u0001\u0019\u0001CD\u0003\t1\u0017\r\u0005\u0004p\u0003\u000fdHQ\u0010\u0005\b\t\u0017#\u0001\u0019\u0001CG\u0003\t1'\rE\u0004p\u0003\u000f\fy\u0001\" \u0002\tM<\u0018\r]\u000b\u0003\t'\u0003Ra\u001f\u0001\u0002\u0010q\f\u0011B[8j]JKw\r\u001b;\u0016\u0011\u0011eEq\u0014CZ\tK#B\u0001b'\u0005(B11\u0010\u0001CO\tG\u00032! CP\t\u001d\tYN\u0002b\u0001\tC\u000b2\u0001`A\u0005!\riHQ\u0015\u0003\b\t\u00033!\u0019AA\u0001\u0011\u001d!IK\u0002a\u0002\tW\u000b!!\u001a<\u0011\u0011\tEAQ\u0016CY\t7KA\u0001b,\u0003$\t\u0001B\u0005\\3tg\u0012\u001aw\u000e\\8oI1,7o\u001d\t\u0004{\u0012MFa\u0002B:\r\t\u0007AQW\t\u0005\u0003\u001f\tI!\u0001\u0005k_&tG*\u001a4u+!!Y\f\"4\u0005F\u0012\u0005G\u0003\u0002C_\t\u000f\u0004ba\u001f\u0001\u0005@\u0012\r\u0007cA?\u0005B\u00129A\u0011Q\u0004C\u0002\u0005\u0005\u0001cA?\u0005F\u00129!1O\u0004C\u0002\u0011U\u0006b\u0002CU\u000f\u0001\u000fA\u0011\u001a\t\t\u0005#!i\u000bb3\u0005>B\u0019Q\u0010\"4\u0005\u000f\u0005mwA1\u0001\u0005\"V!A\u0011\u001bCm)\u0011\tY\fb5\t\u000f\u0005\r\u0007\u00021\u0001\u0005VB9q.a2\u0002\u0010\u0011]\u0007cA?\u0005Z\u00129\u0011q\u001a\u0005C\u0002\u0005\u0005Q\u0003\u0002Co\tC$B\u0001b8\u0005dB\u0019Q\u0010\"9\u0005\u000f\tM\u0014B1\u0001\u00056\"A\u0011\u0011]\u0005\u0005\u0002\u0004!)\u000fE\u0003p\u0003\u000b\"y.\u0001\u0005d_:$\u0018-\u001b8t+\u0011!Y\u000fb=\u0015\t\u0005eBQ\u001e\u0005\b\t_T\u0001\u0019\u0001Cy\u0003\u0011)G.Z7\u0011\u0007u$\u0019\u0010B\u0004\u0003t)\u0011\r\u0001\".\u0015\t\u0005eBq\u001f\u0005\b\u0003\u0007\\\u0001\u0019\u0001C}!\u001dy\u0017qYA\b\u0003s!B!!\u000f\u0005~\"9\u00111\u001e\u0007A\u0002\u0011eXCBC\u0001\u000b\u000f)Y\u0001\u0006\u0003\u0006\u0004\u00155\u0001CB>\u0001\u000b\u000b)I\u0001E\u0002~\u000b\u000f!q!a7\u000e\u0005\u0004!\t\u000bE\u0002~\u000b\u0017!qAa\u001d\u000e\u0005\u0004\t\t\u0001C\u0004\u0002D6\u0001\r!b\u0004\u0011\u000f=\f9-a\u0004\u0006\u0004U!Q1CC\r)\u0011))\"b\u0007\u0011\u000bm\u0004A0b\u0006\u0011\u0007u,I\u0002B\u0004\u0003t9\u0011\r!!\u0001\t\u000f\u0005\rg\u00021\u0001\u0006\u001eA9q.a2\u0002\u0010\u0015]\u0011\u0001\u00044jYR,'o\u0014:FYN,W\u0003BC\u0012\u000bS!b!\"\n\u0006,\u00155\u0002CB>\u0001\u000bO\ty\u0001E\u0002~\u000bS!q!a7\u0010\u0005\u0004!\t\u000bC\u0004\u0002l>\u0001\r\u0001\"?\t\u0011\u0015=r\u0002\"a\u0001\u000bc\tAA_3s_B)q.!\u0012\u0006(U\u0011QQ\u0007\t\u0007\u000bo)i$a\u0004\u000e\u0005\u0015e\"\u0002BC\u001e\u0007\u001b\t\u0011\"[7nkR\f'\r\\3\n\t\t5V\u0011H\u000b\u0003\u000b\u0003\u0002Ra\u001cBJ\u0003\u001f\tQ\u0001^8Uef$B!b\u0012\u0006NA)10\"\u0013\u0002\u0010%\u0019Q1J4\u0003\u0007Q\u0013\u0018\u0010C\u0004\u0005*J\u0001\u001d!b\u0014\u0011\u000f\tEAQ\u0016?\u0006RA!!QUC*\u0013\u0011))Fa,\u0003\u0013QC'o\\<bE2,\u0017AB5t\u0019\u00164G/\u0006\u0002\u0002:\u00059\u0011n\u001d*jO\"$\u0018&\u0002\u0001\u0006`\u0015\r\u0014bAC1O\n!A*\u001a4u\u0013\r))g\u001a\u0002\u0006%&<\u0007\u000e\u001e")
public abstract class Either<A, B>
implements Product,
Serializable {
    public static Either MergeableEither(Either either) {
        return Either$.MODULE$.MergeableEither(either);
    }

    public static <A, B> Either<A, B> cond(boolean bl, Function0<B> function0, Function0<A> function02) {
        if (Either$.MODULE$ == null) {
            throw null;
        }
        if (bl) {
            return new Right(function0.apply());
        }
        return new Left(function02.apply());
    }

    @Override
    public Iterator<Object> productIterator() {
        return Product.productIterator$(this);
    }

    @Override
    public String productPrefix() {
        return Product.productPrefix$(this);
    }

    public LeftProjection<A, B> left() {
        return new LeftProjection(this);
    }

    public RightProjection<A, B> right() {
        return new RightProjection(this);
    }

    public <C> C fold(Function1<A, C> fa, Function1<B, C> fb) {
        C c;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            c = fb.apply(b);
        } else if (this instanceof Left) {
            Object a = ((Left)this).value();
            c = fa.apply(a);
        } else {
            throw new MatchError(this);
        }
        return c;
    }

    public Either<B, A> swap() {
        Either either;
        if (this instanceof Left) {
            Object a = ((Left)this).value();
            either = new Right(a);
        } else if (this instanceof Right) {
            Object b = ((Right)this).value();
            either = new Left(b);
        } else {
            throw new MatchError(this);
        }
        return either;
    }

    public <A1, B1, C> Either<A1, C> joinRight(Predef$.less.colon.less<B1, Either<A1, C>> ev) {
        Either either;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            either = (Either)ev.apply(b);
        } else {
            either = this;
        }
        return either;
    }

    public <A1, B1, C> Either<C, B1> joinLeft(Predef$.less.colon.less<A1, Either<C, B1>> ev) {
        Either either;
        if (this instanceof Left) {
            Object a = ((Left)this).value();
            either = (Either)ev.apply(a);
        } else {
            either = this;
        }
        return either;
    }

    public <U> void foreach(Function1<B, U> f) {
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            f.apply(b);
            return;
        }
    }

    public <B1> B1 getOrElse(Function0<B1> or) {
        Object object = this instanceof Right ? ((Right)this).value() : or.apply();
        return object;
    }

    public final <B1> boolean contains(B1 elem) {
        boolean bl = this instanceof Right ? BoxesRunTime.equals(((Right)this).value(), elem) : false;
        return bl;
    }

    public boolean forall(Function1<B, Object> f) {
        boolean bl;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            bl = BoxesRunTime.unboxToBoolean(f.apply(b));
        } else {
            bl = true;
        }
        return bl;
    }

    public boolean exists(Function1<B, Object> p) {
        boolean bl;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            bl = BoxesRunTime.unboxToBoolean(p.apply(b));
        } else {
            bl = false;
        }
        return bl;
    }

    public <A1, B1> Either<A1, B1> flatMap(Function1<B, Either<A1, B1>> f) {
        Either<A1, B1> either;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            either = f.apply(b);
        } else {
            either = this;
        }
        return either;
    }

    public <B1> Either<A, B1> map(Function1<B, B1> f) {
        Right right;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            right = new Right(f.apply(b));
        } else {
            right = this;
        }
        return right;
    }

    public <A1> Either<A1, B> filterOrElse(Function1<B, Object> p, Function0<A1> zero) {
        Object b;
        Left left = this instanceof Right && !BoxesRunTime.unboxToBoolean(p.apply(b = ((Right)((Object)this)).value())) ? new Left(zero.apply()) : this;
        return left;
    }

    public scala.collection.immutable.Seq<B> toSeq() {
        scala.collection.immutable.Seq<Nothing$> seq;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            seq = (scala.collection.immutable.Seq)Seq$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{b}));
        } else {
            seq = Nil$.MODULE$;
        }
        return seq;
    }

    public Option<B> toOption() {
        Option option;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            option = new Some(b);
        } else {
            option = None$.MODULE$;
        }
        return option;
    }

    public Try<B> toTry(Predef$.less.colon.less<A, Throwable> ev) {
        Try try_;
        if (this instanceof Right) {
            Object b = ((Right)this).value();
            try_ = new Success(b);
        } else if (this instanceof Left) {
            Object a = ((Left)this).value();
            try_ = new Failure((Throwable)ev.apply(a));
        } else {
            throw new MatchError(this);
        }
        return try_;
    }

    public abstract boolean isLeft();

    public abstract boolean isRight();

    public Either() {
        Product.$init$(this);
    }

    public static final class LeftProjection<A, B>
    implements Product,
    Serializable {
        private final Either<A, B> e;

        public Either<A, B> e() {
            return this.e;
        }

        public A get() {
            Either<A, B> either = this.e();
            if (!(either instanceof Left)) {
                throw new NoSuchElementException("Either.left.get on Right");
            }
            Object a = ((Left)either).value();
            return a;
        }

        public <U> void foreach(Function1<A, U> f) {
            Either<A, B> either = this.e();
            if (either instanceof Left) {
                Object a = ((Left)either).value();
                f.apply(a);
                return;
            }
        }

        public <A1> A1 getOrElse(Function0<A1> or) {
            Either<A, B> either = this.e();
            Object object = either instanceof Left ? ((Left)either).value() : or.apply();
            return object;
        }

        public boolean forall(Function1<A, Object> p) {
            boolean bl;
            Either<A, B> either = this.e();
            if (either instanceof Left) {
                Object a = ((Left)either).value();
                bl = BoxesRunTime.unboxToBoolean(p.apply(a));
            } else {
                bl = true;
            }
            return bl;
        }

        public boolean exists(Function1<A, Object> p) {
            boolean bl;
            Either<A, B> either = this.e();
            if (either instanceof Left) {
                Object a = ((Left)either).value();
                bl = BoxesRunTime.unboxToBoolean(p.apply(a));
            } else {
                bl = false;
            }
            return bl;
        }

        public <A1, B1> Either<A1, B1> flatMap(Function1<A, Either<A1, B1>> f) {
            Either<Object, Object> either;
            Either<A, B> either2 = this.e();
            if (either2 instanceof Left) {
                Object a = ((Left)either2).value();
                either = f.apply(a);
            } else {
                either = this.e();
            }
            return either;
        }

        public <A1> Either<A1, B> map(Function1<A, A1> f) {
            Either<A, B> either;
            Either<A, B> either2 = this.e();
            if (either2 instanceof Left) {
                Object a = ((Left)either2).value();
                either = new Left(f.apply(a));
            } else {
                either = this.e();
            }
            return either;
        }

        public <B1> Option<Either<A, B1>> filter(Function1<A, Object> p) {
            Left left;
            Object a;
            Either<A, B> either = this.e();
            Option option = either instanceof Left && BoxesRunTime.unboxToBoolean(p.apply(a = (left = (Left)either).value())) ? new Some<Left>(left) : None$.MODULE$;
            return option;
        }

        public Seq<A> toSeq() {
            Seq<Nothing$> seq;
            Either<A, B> either = this.e();
            if (either instanceof Left) {
                Object a = ((Left)either).value();
                seq = (Seq)scala.collection.Seq$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{a}));
            } else {
                seq = Nil$.MODULE$;
            }
            return seq;
        }

        public Option<A> toOption() {
            Option option;
            Either<A, B> either = this.e();
            if (either instanceof Left) {
                Object a = ((Left)either).value();
                option = new Some(a);
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        public <A, B> LeftProjection<A, B> copy(Either<A, B> e) {
            return new LeftProjection<A, B>(e);
        }

        public <A, B> Either<A, B> copy$default$1() {
            return this.e();
        }

        @Override
        public String productPrefix() {
            return "LeftProjection";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.e();
                }
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof LeftProjection;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof LeftProjection;
                    if (!bl) break block3;
                    LeftProjection leftProjection = (LeftProjection)x$1;
                    Either<A, B> either = this.e();
                    Either<A, B> either2 = leftProjection.e();
                    if (!(!(either != null ? !either.equals(either2) : either2 != null))) break block3;
                }
                return true;
            }
            return false;
        }

        public LeftProjection(Either<A, B> e) {
            this.e = e;
            Product.$init$(this);
        }
    }

    public static final class MergeableEither<A> {
        private final Either<A, A> scala$util$Either$MergeableEither$$x;

        public Either<A, A> scala$util$Either$MergeableEither$$x() {
            return this.scala$util$Either$MergeableEither$$x;
        }

        public A merge() {
            return Either$MergeableEither$.MODULE$.merge$extension(this.scala$util$Either$MergeableEither$$x());
        }

        public int hashCode() {
            return Either$MergeableEither$.MODULE$.hashCode$extension(this.scala$util$Either$MergeableEither$$x());
        }

        public boolean equals(Object x$1) {
            return Either$MergeableEither$.MODULE$.equals$extension(this.scala$util$Either$MergeableEither$$x(), x$1);
        }

        public MergeableEither(Either<A, A> x) {
            this.scala$util$Either$MergeableEither$$x = x;
        }
    }

    public static final class RightProjection<A, B>
    implements Product,
    Serializable {
        private final Either<A, B> e;

        public Either<A, B> e() {
            return this.e;
        }

        public B get() {
            Either<A, B> either = this.e();
            if (!(either instanceof Right)) {
                throw new NoSuchElementException("Either.right.get on Left");
            }
            Object b = ((Right)either).value();
            return b;
        }

        public <U> void foreach(Function1<B, U> f) {
            Either<A, B> either = this.e();
            if (either instanceof Right) {
                Object b = ((Right)either).value();
                f.apply(b);
                return;
            }
        }

        public <B1> B1 getOrElse(Function0<B1> or) {
            Either<A, B> either = this.e();
            Object object = either instanceof Right ? ((Right)either).value() : or.apply();
            return object;
        }

        public boolean forall(Function1<B, Object> f) {
            boolean bl;
            Either<A, B> either = this.e();
            if (either instanceof Right) {
                Object b = ((Right)either).value();
                bl = BoxesRunTime.unboxToBoolean(f.apply(b));
            } else {
                bl = true;
            }
            return bl;
        }

        public boolean exists(Function1<B, Object> p) {
            boolean bl;
            Either<A, B> either = this.e();
            if (either instanceof Right) {
                Object b = ((Right)either).value();
                bl = BoxesRunTime.unboxToBoolean(p.apply(b));
            } else {
                bl = false;
            }
            return bl;
        }

        public <A1, B1> Either<A1, B1> flatMap(Function1<B, Either<A1, B1>> f) {
            Either<Object, Object> either;
            Either<A, B> either2 = this.e();
            if (either2 instanceof Right) {
                Object b = ((Right)either2).value();
                either = f.apply(b);
            } else {
                either = this.e();
            }
            return either;
        }

        public <B1> Either<A, B1> map(Function1<B, B1> f) {
            Either<A, B> either;
            Either<A, B> either2 = this.e();
            if (either2 instanceof Right) {
                Object b = ((Right)either2).value();
                either = new Right(f.apply(b));
            } else {
                either = this.e();
            }
            return either;
        }

        public <A1> Option<Either<A1, B>> filter(Function1<B, Object> p) {
            Object b;
            Either<A, B> either = this.e();
            Option option = either instanceof Right && BoxesRunTime.unboxToBoolean(p.apply(b = ((Right)either).value())) ? new Some(new Right(b)) : None$.MODULE$;
            return option;
        }

        public Seq<B> toSeq() {
            Seq<Nothing$> seq;
            Either<A, B> either = this.e();
            if (either instanceof Right) {
                Object b = ((Right)either).value();
                seq = (Seq)scala.collection.Seq$.MODULE$.apply(Predef$.MODULE$.genericWrapArray(new Object[]{b}));
            } else {
                seq = Nil$.MODULE$;
            }
            return seq;
        }

        public Option<B> toOption() {
            Option option;
            Either<A, B> either = this.e();
            if (either instanceof Right) {
                Object b = ((Right)either).value();
                option = new Some(b);
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        public <A, B> RightProjection<A, B> copy(Either<A, B> e) {
            return new RightProjection<A, B>(e);
        }

        public <A, B> Either<A, B> copy$default$1() {
            return this.e();
        }

        @Override
        public String productPrefix() {
            return "RightProjection";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.e();
                }
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof RightProjection;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof RightProjection;
                    if (!bl) break block3;
                    RightProjection rightProjection = (RightProjection)x$1;
                    Either<A, B> either = this.e();
                    Either<A, B> either2 = rightProjection.e();
                    if (!(!(either != null ? !either.equals(either2) : either2 != null))) break block3;
                }
                return true;
            }
            return false;
        }

        public RightProjection(Either<A, B> e) {
            this.e = e;
            Product.$init$(this);
        }
    }
}

