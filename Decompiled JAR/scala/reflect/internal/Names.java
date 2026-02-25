/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.util.stream.IntStream;
import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.io.Codec$;
import scala.package$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.NameTransformer$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Names;
import scala.reflect.internal.Names$TermName$;
import scala.reflect.internal.Names$TypeName$;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0015}fACA5\u0003W\u0002\n1!\u0001\u0002z!9\u0011Q\u0012\u0001\u0005\u0002\u0005=\u0005\"CAL\u0001\t\u0007IQBAM\u0011%\ty\n\u0001b\u0001\n\u001b\t\t\u000bC\u0005\u0002(\u0002\u0011\r\u0011\"\u0004\u0002*\"I\u0011q\u0016\u0001C\u0002\u0013\u0015\u0011\u0011\u0017\u0005\b\u0003o\u0003A\u0011CA]\u0011%\t\t\r\u0001b\u0001\n\u0013\t\u0019\rC\u0005\u0002V\u0002\u0001\r\u0015\"\u0003\u0002X\"I\u0011Q\u001d\u0001AB\u0013%\u0011q\u001d\u0005\b\u0003[\u0004A\u0011AAl\u0011\u001d\ty\u0010\u0001C\u0001\u0005\u0003A\u0011B!\u0003\u0001\u0001\u0004%IAa\u0003\t\u0013\tM\u0001\u00011A\u0005\n\tU\u0001\"\u0003B\r\u0001\t\u0007I\u0011\u0002B\u000e\u0011%!\u0019\b\u0001b\u0001\n\u0013!)\bC\u0004\u0005z\u0001!)\u0001b\u001f\t\u000f\u0011\r\u0005\u0001\"\u0003\u0005\u0006\"9AQ\u0012\u0001\u0005\n\u0011=\u0005b\u0002CM\u0001\u0011%A1\u0014\u0005\b\tG\u0003AQ\u0001CS\u0011\u001d!\u0019\u000b\u0001C\u0003\t[Cq\u0001\"-\u0001\t\u000b!\u0019\fC\u0004\u0005$\u0002!)\u0001b.\t\u000f\u0011E\u0006\u0001\"\u0002\u0005B\"9A1\u0015\u0001\u0005\u0002\u0011-\u0007b\u0002CY\u0001\u0011\u0005Aq\u001c\u0005\b\tG\u0003AQ\u0001Cs\u0011\u001d!9\u0010\u0001C\u0003\tsDq\u0001\"@\u0001\t\u000b!y\u0010C\u0004\u00052\u0002!)!b\u0001\t\u000f\u0011E\u0006\u0001\"\u0002\u0006\f!9Q1\u0003\u0001\u0005\u0006\u0015Ua!\u0003B\u001b\u0001A\u0005\u0019\u0013\u0005B\u001c\u0011\u001d\u0011I$\tD\u0001\u0003s3qA!\u000b\u0001\u0003C\u0011Y\u0003\u0003\u0006\u0003D\r\u0012)\u0019!C\t\u0005\u0017A!B!\u0012$\u0005\u0003\u0005\u000b\u0011\u0002B\u0007\u0011)\u00119e\tBC\u0002\u0013E!1\u0002\u0005\u000b\u0005\u0013\u001a#\u0011!Q\u0001\n\t5\u0001B\u0003B&G\t\u0015\r\u0011\"\u0005\u0003N!Q!QM\u0012\u0003\u0002\u0003\u0006IAa\u0014\t\u000f\t\u001d4\u0005\"\u0001\u0003j\u00119!\u0011O\u0012\u0003\u0002\tM\u0004\u0002\u0003B>G\u00016\tB! \t\u000f\t\r5\u0005\"\u0002\u0003\f!9!QQ\u0012\u0007\u0002\t\u001d\u0005b\u0002BHG\u0011\u0015!\u0011\u0013\u0005\b\u0005'\u001bCQAA]\u0011\u001d\u0011Id\tC#\u0003sCqA!&$\r\u0003\u0011i\u0005C\u0004\u0003\u0018\u000e2\t!!/\t\u000f\te5E\"\u0001\u0002:\"9!1T\u0012\u0007\u0002\tu\u0005b\u0002BPG\u0019\u0005!\u0011\u0015\u0005\b\u0005\u000f\u001cc\u0011\u0001Bo\u0011\u001d\u0011yn\tC\u0001\u0005CDqAa>$\t\u000b\u0011I\u0010C\u0004\u0003J\u000e2\ta!\u0005\t\u000f\rm1\u0005\"\u0011\u0004\u001e!9!qX\u0012\u0007\u0002\r\r\u0002bBB\u0016G\u0011\u00051Q\u0006\u0005\b\u0007{\u0019CQAB \u0011\u001d\u00199e\tC\u0003\u0003/Dqa!\u0013$\t\u000b\u0012\t\nC\u0004\u0004L\r\"\ta!\u0014\t\u000f\r-3\u0005\"\u0001\u0004T!91qK\u0012\u0005\u0006\re\u0003bBB0G\u0011\u00151\u0011\r\u0005\b\u0007?\u001aCQAB4\u0011\u001d\u0019yf\tC\u0003\u0007[Bqaa\u0018$\t\u000b\u0019\u0019\bC\u0004\u0004z\r\")aa\u001f\t\u000f\re4\u0005\"\u0002\u0004\u0000!91QQ\u0012\u0005\u0006\r\u001d\u0005bBBCG\u0011\u00151Q\u0012\u0005\b\u0007\u000b\u001bCQABJ\u0011\u001d\u0019Ij\tC\u0003\u00077Cqa!'$\t\u000b\u0019\t\u000bC\u0004\u0004\u001a\u000e\")a!+\t\u000f\r=6\u0005\"\u0002\u00042\"91qV\u0012\u0005\u0006\r]\u0006bBB^G\u0011\u00151Q\u0018\u0005\b\u0007\u0007\u001cCQABc\u0011\u001d\u00199m\tC\u0003\u0007\u000bDqa!\"$\t\u000b\u0019I\rC\u0004\u0004\u0006\u000e\")aa4\t\u000f\re5\u0005\"\u0002\u0004V\"91\u0011T\u0012\u0005\u0006\re\u0007bBBoG\u0011%1q\u001c\u0005\b\u0007K\u001cC\u0011ABt\u0011\u001d\u0019)o\tC\u0001\u0007WDqa!:$\t\u0003\u0019\u0019\u0010C\u0004\u0004x\u000e\"\ta!?\t\u000f\r]8\u0005\"\u0001\u0004~\"9A\u0011A\u0012\u0005\u0002\u0011\r\u0001b\u0002C\u0005G\u0011\u0005!Q\n\u0005\b\t\u0017\u0019C\u0011\u0001B'\u0011\u001d!ia\tC\u0001\u0005{Bq\u0001b\u0004$\t\u0003\u0011i\bC\u0004\u0003\\\u000e\"\tA!\u0014\t\u000f\u0011E1\u0005\"\u0001\u0005\u0014!9A\u0011C\u0012\u0005\u0002\u0011]\u0001b\u0002C\tG\u0011\u0005A1\u0004\u0005\b\t#\u0019C\u0011\u0001C\u0010\u0011\u001d!9c\tC\u0001\tSAq\u0001\"\f$\t\u0003\u0011i\bC\u0004\u00050\r\"\t!!/\t\u000f\u0011E2\u0005\"\u0001\u0003N!9A1G\u0012\u0005\u0002\tU\u0007b\u0002C\u001bG\u0011\u0015Aq\u0007\u0005\b\tw\u0019CQ\tC\u001f\u0011\u001d!yd\tC\u0003\t\u0003Bq!\"\u0007\u0001\t\u0007)Y\u0002C\u0004\u0006b\u0001!\u0019!b\u0019\t\u000f\u0015%\u0004\u0001b\u0001\u0006l\u00191Qq\u0004\u0001\u0003\u000bCA!ba5u\u0005\u0003\u0005\u000b\u0011BC\u0013\u0011\u001d\u00119\u0007\u001eC\u0001\u000bWAq!\"\ru\t\u0003)\u0019\u0004C\u0004\u00062Q$\t!b\u000e\t\u000f\u0015mB\u000f\"\u0001\u0006>!9Q1\t;\u0005\u0002\u0015\u0015\u0003bBC%i\u0012\u0005Q1\n\u0005\b\u000b\u001f\"H\u0011\u0001BO\u0011\u001d)\t\u0006\u001eC\u0001\u0005;Cq!b\u0015u\t\u0003))\u0006C\u0004\u0006XQ$\tA!(\t\u000f\u0015eC\u000f\"\u0001\u0003\u001e\"9Q1\f;\u0005\u0002\tu\u0005bBC/i\u0012%!Q\u0014\u0005\n\u000bc\u0002!\u0019!C\u0002\u000bg2aAa\t\u0001\u0005\t\u0015\u0002\u0002\u0004BX\u0003\u0013\u0011\t\u0011)A\u0005\u0005\u001b!\u0003\u0002\u0004BY\u0003\u0013\u0011\t\u0011)A\u0005\u0005\u001b1\u0003b\u0003BC\u0003\u0013\u0011)\u0019!C\u0001\u0005;C1Ba-\u0002\n\t\u0005\t\u0015!\u0003\u0003 !a!1JA\u0005\u0005\u0003\u0005\u000b\u0011\u0002B(Q!A!qMA\u0005\t\u0003!I&B\u0004\u0003r\u0005%\u0001Aa\b\t\u0013\tm\u0014\u0011\u0002Q\u0005\u0012\tu\u0005\u0002\u0003BL\u0003\u0013!\t!!/\t\u0011\te\u0015\u0011\u0002C\u0001\u0003sC\u0001Ba'\u0002\n\u0011\u0005!Q\u0014\u0005\t\u0005?\u000bI\u0001\"\u0001\u0003\"\"A!qXA\u0005\t\u0003!\u0019\u0007\u0003\u0005\u0003H\u0006%A\u0011\u0001BQ\u0011!\u0011I-!\u0003\u0005\u0002\u0011\u001d\u0004\u0002\u0003BK\u0003\u0013!\tA!6\t\u0011\u00115\u0014\u0011\u0002C\u0005\t_B\u0011\"\" \u0001\u0005\u0004%\u0019!b \b\u000f\u0015\r\u0005\u0001#\u0001\u0006\u0006\u001a9!1\u0005\u0001\t\u0002\u0015\u001d\u0005\u0002\u0003B4\u0003c!\t!b$\t\u0011\u0015E\u0015\u0011\u0007C\u0001\u000b'C\u0001\"b&\u00022\u0011\u0005Q\u0011\u0014\u0004\u0007\u0005K\u0003!Aa*\t\u0019\t=\u0016\u0011\bB\u0001B\u0003%!Q\u0002\u0013\t\u0019\tE\u0016\u0011\bB\u0001B\u0003%!Q\u0002\u0014\t\u0017\t\u0015\u0015\u0011\bBC\u0002\u0013\u0005!\u0011\u0015\u0005\f\u0005g\u000bID!A!\u0002\u0013\u0011\u0019\u000b\u0003\u0007\u0003L\u0005e\"\u0011!Q\u0001\n\t=\u0003\u0006\u0003\u0005\u0003h\u0005eB\u0011\u0001B[\u000b\u001d\u0011\t(!\u000f\u0001\u0005GC\u0011Ba\u001f\u0002:\u0001&\tB!)\t\u0011\t]\u0015\u0011\bC\u0001\u0003sC\u0001B!'\u0002:\u0011\u0005\u0011\u0011\u0018\u0005\t\u00057\u000bI\u0004\"\u0001\u0003\u001e\"A!qTA\u001d\t\u0003\u0011\t\u000b\u0003\u0005\u0003@\u0006eB\u0011\u0001Ba\u0011!\u00119-!\u000f\u0005\u0002\tu\u0005\u0002\u0003Be\u0003s!\tAa3\t\u0011\tU\u0015\u0011\bC\u0001\u0005+D\u0001Ba7\u0002:\u0011\u0005#Q\n\u0005\n\u000bG\u0003!\u0019!C\u0002\u000bK;q!\"+\u0001\u0011\u0003)YKB\u0004\u0003&\u0002A\t!\",\t\u0011\t\u001d\u0014\u0011\rC\u0001\u000bkC\u0001\"\"%\u0002b\u0011\u0005Qq\u0017\u0005\t\u000b/\u000b\t\u0007\"\u0001\u0006<\n)a*Y7fg*!\u0011QNA8\u0003!Ig\u000e^3s]\u0006d'\u0002BA9\u0003g\nqA]3gY\u0016\u001cGO\u0003\u0002\u0002v\u0005)1oY1mC\u000e\u00011#\u0002\u0001\u0002|\u0005\r\u0005\u0003BA?\u0003\u007fj!!a\u001d\n\t\u0005\u0005\u00151\u000f\u0002\u0007\u0003:L(+\u001a4\u0011\t\u0005\u0015\u00151R\u0007\u0003\u0003\u000fSA!!#\u0002p\u0005\u0019\u0011\r]5\n\t\u0005%\u0014qQ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0005\u0005E\u0005\u0003BA?\u0003'KA!!&\u0002t\t!QK\\5u\u0003%A\u0015i\u0015%`'&SV)\u0006\u0002\u0002\u001c>\u0011\u0011QT\u000f\u0004\u0001\u0001\u0005\u0011!\u0003%B'\"{V*Q*L+\t\t\u0019k\u0004\u0002\u0002&v\u0011qp\u0000\u0001\n\u001d\u0006kUiX*J5\u0016+\"!a+\u0010\u0005\u00055Vd\u0001\u0002\u0001\u0001\u0005Ia.Y7f\t\u0016\u0014WoZ\u000b\u0003\u0003g{!!!.\u001a\u0003\u0001\t\u0001c]=oG\"\u0014xN\\5{K:\u000bW.Z:\u0016\u0005\u0005m\u0006\u0003BA?\u0003{KA!a0\u0002t\t9!i\\8mK\u0006t\u0017\u0001\u00038b[\u0016dunY6\u0016\u0005\u0005\u0015\u0007\u0003BAd\u0003#l!!!3\u000b\t\u0005-\u0017QZ\u0001\u0005Y\u0006twM\u0003\u0002\u0002P\u0006!!.\u0019<b\u0013\u0011\t\u0019.!3\u0003\r=\u0013'.Z2u\u0003\u0015y6\r\u001b:t+\t\tI\u000e\u0005\u0004\u0002~\u0005m\u0017q\\\u0005\u0005\u0003;\f\u0019HA\u0003BeJ\f\u0017\u0010\u0005\u0003\u0002~\u0005\u0005\u0018\u0002BAr\u0003g\u0012Aa\u00115be\u0006Iql\u00195sg~#S-\u001d\u000b\u0005\u0003#\u000bI\u000fC\u0005\u0002l&\t\t\u00111\u0001\u0002Z\u0006\u0019\u0001\u0010J\u0019\u0002\t\rD'o\u001d\u0015\b\u0015\u0005E\u0018q_A~!\u0011\ti(a=\n\t\u0005U\u00181\u000f\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017EAA}\u0003)\"uN\\\u0014uA\u0005\u001c7-Z:tA9\fW.\u001a\u0011uC\ndW\rI2p]R,g\u000e^:!I&\u0014Xm\u0019;ms:\n#!!@\u0002\rIr\u0013G\r\u0018:\u0003!\u0019\u0007N]:`I\u0015\fH\u0003BAI\u0005\u0007AqA!\u0002\f\u0001\u0004\tI.\u0001\u0002dg\":1\"!=\u0002x\u0006m\u0018A\u00018d+\t\u0011i\u0001\u0005\u0003\u0002~\t=\u0011\u0002\u0002B\t\u0003g\u00121!\u00138u\u0003\u0019q7m\u0018\u0013fcR!\u0011\u0011\u0013B\f\u0011%\tY/DA\u0001\u0002\u0004\u0011i!A\u0007uKJl\u0007*Y:ii\u0006\u0014G.Z\u000b\u0003\u0005;\u0001b!! \u0002\\\n}\u0001\u0003\u0002B\u0011\u0003\u0013i\u0011\u0001\u0001\u0002\t)\u0016\u0014XNT1nKN1\u0011\u0011\u0002B\u0014\t'\u00022A!\t$\u0005\u0011q\u0015-\\3\u0014\u000f\r\u0012iCa\r\u0003>A!!\u0011\u0005B\u0018\u0013\u0011\u0011\t$a#\u0003\u000f9\u000bW.Z!qSB\u0019!\u0011E\u0011\u0003\u001d9\u000bW.\u001a%bg&\u001bX)\u001c9usN\u0019\u0011%a\u001f\u0002\u000f%\u001cX)\u001c9us&\u0012\u0011e\t\t\u0005\u0003\u000f\u0014y$\u0003\u0003\u0003B\u0005%'\u0001D\"iCJ\u001cV-];f]\u000e,\u0017!B5oI\u0016D\u0018AB5oI\u0016D\b%A\u0002mK:\fA\u0001\\3oA\u0005a1-Y2iK\u0012\u001cFO]5oOV\u0011!q\n\t\u0005\u0005#\u0012yF\u0004\u0003\u0003T\tm\u0003\u0003\u0002B+\u0003gj!Aa\u0016\u000b\t\te\u0013qO\u0001\u0007yI|w\u000e\u001e \n\t\tu\u00131O\u0001\u0007!J,G-\u001a4\n\t\t\u0005$1\r\u0002\u0007'R\u0014\u0018N\\4\u000b\t\tu\u00131O\u0001\u000eG\u0006\u001c\u0007.\u001a3TiJLgn\u001a\u0011\u0002\rqJg.\u001b;?)!\u00119Ca\u001b\u0003n\t=\u0004b\u0002B\"U\u0001\u0007!Q\u0002\u0005\b\u0005\u000fR\u0003\u0019\u0001B\u0007\u0011\u001d\u0011YE\u000ba\u0001\u0005\u001f\u0012A\u0002\u00165jg:\u000bW.\u001a+za\u0016\fBA!\u001e\u0003(A!\u0011Q\u0010B<\u0013\u0011\u0011I(a\u001d\u0003\t9+H\u000e\\\u0001\ti\"L7OT1nKV\u0011!q\u0010\t\u0004\u0005\u0003[S\"A\u0012\u0002\u000bM$\u0018M\u001d;\u0002\t9,\u0007\u0010^\u000b\u0003\u0005\u0013\u0013bAa#\u0003(\t}dA\u0002BGG\u0001\u0011II\u0001\u0007=e\u00164\u0017N\\3nK:$h(\u0001\u0004mK:<G\u000f\u001b\u000b\u0003\u0005\u001b\t\u0001B\\8o\u000b6\u0004H/_\u0001\t]\u0006lWmS5oI\u0006Q\u0011n\u001d+fe6t\u0015-\\3\u0002\u0015%\u001cH+\u001f9f\u001d\u0006lW-\u0001\u0006u_R+'/\u001c(b[\u0016,\"Aa\b\u0002\u0015Q|G+\u001f9f\u001d\u0006lW-\u0006\u0002\u0003$B!!\u0011EA\u001d\u0005!!\u0016\u0010]3OC6,7CBA\u001d\u0005O\u0011I\u000b\u0005\u0003\u0003\"\t-\u0016\u0002\u0002BW\u0003\u0017\u00131\u0002V=qK:\u000bW.Z!qS\u00061\u0011N\u001c3fqB\nA\u0001\\3oa\u0005)a.\u001a=uAQQ!1\u0015B\\\u0005s\u0013YL!0\t\u0011\t=\u0016Q\ta\u0001\u0005\u001bA\u0001B!-\u0002F\u0001\u0007!Q\u0002\u0005\t\u0005\u000b\u000b)\u00051\u0001\u0003$\"A!1JA#\u0001\u0004\u0011y%A\u0004oK^t\u0015-\\3\u0015\t\t\r&1\u0019\u0005\t\u0005\u000b\f\u0019\u00061\u0001\u0003P\u0005\u00191\u000f\u001e:\u0002\u001b\r|W\u000e]1oS>tg*Y7f\u0003\u001d\u0019XO\u0019(b[\u0016$bAa)\u0003N\nE\u0007\u0002\u0003Bh\u0003/\u0002\rA!\u0004\u0002\t\u0019\u0014x.\u001c\u0005\t\u0005'\f9\u00061\u0001\u0003\u000e\u0005\u0011Ao\\\u000b\u0003\u0005/\u0004B!a2\u0003Z&!!\u0011MAe\u0003\u0019!WmY8eKV\u0011!qE\u0001\nE>$\bNT1nKN,\"Aa9\u0011\r\t\u0015(1\u001eB\u0014\u001d\u0011\tiHa:\n\t\t%\u00181O\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\u0011iOa<\u0003\t1K7\u000f\u001e\u0006\u0005\u0005S\f\u0019\bK\u00049\u0003c\u0014\u00190a?\"\u0005\tU\u0018aI+tK\u0002*\u0017\u000e\u001e5fe\u0002\"x\u000eV3s[:\u000bW.\u001a\u0011pe\u0002\"x\u000eV=qK:\u000bW.Z\u0001\tCN$\u0016\u0010]3PMV!!1`B\u0001)\u0011\u0011ip!\u0004\u0011\t\t}8\u0011\u0001\u0007\u0001\t\u001d\u0019\u0019!\u000fb\u0001\u0007\u000b\u0011\u0011AT\t\u0005\u0007\u000f\u00119\u0003\u0005\u0003\u0002~\r%\u0011\u0002BB\u0006\u0003g\u0012qAT8uQ&tw\rC\u0004\u0004\u0010e\u0002\rA!@\u0002\u000b=$\b.\u001a:\u0015\r\rM1qCB\r%\u0019\u0019)Ba\n\u0003\u0000\u00191!QR\u0012\u0001\u0007'AqAa4;\u0001\u0004\u0011i\u0001C\u0004\u0003Tj\u0002\rA!\u0004\u0002\u0017M,(mU3rk\u0016t7-\u001a\u000b\u0007\u0005{\u0019yb!\t\t\u000f\t=7\b1\u0001\u0003\u000e!9!1[\u001eA\u0002\t5A\u0003BB\u0013\u0007S\u0011baa\n\u0003(\t}dA\u0002BGG\u0001\u0019)\u0003C\u0004\u0003Fr\u0002\rAa\u0014\u0002\u000f5\f\u0007OT1nKR!1qFB\u001a%\u0019\u0019\tDa\n\u0003\u0000\u00191!QR\u0012\u0001\u0007_Aqa!\u000e>\u0001\u0004\u00199$A\u0001g!!\tih!\u000f\u0003P\t=\u0013\u0002BB\u001e\u0003g\u0012\u0011BR;oGRLwN\\\u0019\u0002\u0013\r|\u0007/_\"iCJ\u001cHCBAI\u0007\u0003\u001a\u0019\u0005C\u0004\u0003\u0006y\u0002\r!!7\t\u000f\r\u0015c\b1\u0001\u0003\u000e\u00051qN\u001a4tKR\fq\u0001^8DQ\u0006\u00148/\u0001\u0005iCND7i\u001c3f\u00035\u0019HO]5oO~#S-\u001d\u0013fcR!\u00111XB(\u0011\u001d\u0019\t&\u0011a\u0001\u0005O\tA\u0001\u001e5biR!\u00111XB+\u0011\u001d\u0019\tF\u0011a\u0001\u0005\u001f\naa\u00195be\u0006#H\u0003BAp\u00077Bqa!\u0018D\u0001\u0004\u0011i!A\u0001j\u0003\r\u0001xn\u001d\u000b\u0005\u0005\u001b\u0019\u0019\u0007C\u0004\u0004f\u0011\u0003\r!a8\u0002\u0003\r$BA!\u0004\u0004j!911N#A\u0002\t=\u0013!A:\u0015\r\t51qNB9\u0011\u001d\u0019)G\u0012a\u0001\u0003?DqAa!G\u0001\u0004\u0011i\u0001\u0006\u0004\u0003\u000e\rU4q\u000f\u0005\b\u0007W:\u0005\u0019\u0001B(\u0011\u001d\u0011\u0019i\u0012a\u0001\u0005\u001b\tq\u0001\\1tiB{7\u000f\u0006\u0003\u0003\u000e\ru\u0004bBB3\u0011\u0002\u0007\u0011q\u001c\u000b\u0007\u0005\u001b\u0019\tia!\t\u000f\r\u0015\u0014\n1\u0001\u0002`\"9!1Q%A\u0002\t5\u0011AC:uCJ$8oV5uQR!\u00111XBE\u0011\u001d\u0019YI\u0013a\u0001\u0005O\ta\u0001\u001d:fM&DHCBA^\u0007\u001f\u001b\t\nC\u0004\u0004\f.\u0003\rAa\n\t\u000f\t\r5\n1\u0001\u0003\u000eQ1\u00111XBK\u0007/Cqaa#M\u0001\u0004\u0011y\u0005C\u0004\u0003\u00042\u0003\rA!\u0004\u0002\u0011\u0015tGm],ji\"$B!a/\u0004\u001e\"91qT'A\u0002\t\u001d\u0012AB:vM\u001aL\u0007\u0010\u0006\u0004\u0002<\u000e\r6Q\u0015\u0005\b\u0007?s\u0005\u0019\u0001B\u0014\u0011\u001d\u00199K\u0014a\u0001\u0005\u001b\t1!\u001a8e)\u0019\tYla+\u0004.\"91qT(A\u0002\t=\u0003bBBT\u001f\u0002\u0007!QB\u0001\rG>tG/Y5og:\u000bW.\u001a\u000b\u0005\u0003w\u001b\u0019\fC\u0004\u00046B\u0003\rAa\u0014\u0002\u000fM,(M\\1nKR!\u00111XB]\u0011\u001d\u0019),\u0015a\u0001\u0005O\tAbY8oi\u0006Lgn]\"iCJ$B!a/\u0004@\"91\u0011\u0019*A\u0002\u0005}\u0017AA2i\u0003%\u0019H/\u0019:u\u0007\"\f'/\u0006\u0002\u0002`\u00069QM\u001c3DQ\u0006\u0014H\u0003BA^\u0007\u0017Dqa!4V\u0001\u0004\ty.\u0001\u0003dQ\u0006\u0014H\u0003BA^\u0007#Dqaa5W\u0001\u0004\u0011y%\u0001\u0003oC6,G\u0003BA^\u0007/Dqa!4X\u0001\u0004\ty\u000e\u0006\u0003\u0002<\u000em\u0007bBBj1\u0002\u0007!qJ\u0001\u000bM&D\u0018J\u001c3fq>3G\u0003\u0002B\u0007\u0007CDqaa9Z\u0001\u0004\u0011i!A\u0002jIb\fq!\u001b8eKb|e\r\u0006\u0003\u0003\u000e\r%\bbBBa5\u0002\u0007\u0011q\u001c\u000b\u0007\u0005\u001b\u0019ioa<\t\u000f\r\u00057\f1\u0001\u0002`\"91\u0011_.A\u0002\t5\u0011!\u00034s_6Le\u000eZ3y)\u0011\u0011ia!>\t\u000f\r-D\f1\u0001\u0003P\u0005YA.Y:u\u0013:$W\r_(g)\u0011\u0011iaa?\t\u000f\r\u0005W\f1\u0001\u0002`R!!QBB\u0000\u0011\u001d\u0019YG\u0018a\u0001\u0005\u001f\nqA]3qY\u0006\u001cW\r\u0006\u0004\u0003(\u0011\u0015Aq\u0001\u0005\b\u0005\u001f|\u0006\u0019AAp\u0011\u001d\u0011\u0019n\u0018a\u0001\u0003?\fq\u0001Z3d_\u0012,G-A\u0004f]\u000e|G-\u001a3\u0002\u0017\u0015t7m\u001c3fI:\u000bW.Z\u0001\u0007K:\u001cw\u000eZ3\u0002\r\u0005\u0004\b/\u001a8e)\u0011\u0019)\u0003\"\u0006\t\u000f\r\u0005W\r1\u0001\u0002`R!1Q\u0005C\r\u0011\u001d\u0019yJ\u001aa\u0001\u0005\u001f\"Ba!\n\u0005\u001e!91qT4A\u0002\t\u001dBCBB\u0013\tC!)\u0003C\u0004\u0005$!\u0004\r!a8\u0002\u0013M,\u0007/\u0019:bi>\u0014\bbBBPQ\u0002\u0007!qE\u0001\baJ,\u0007/\u001a8e)\u0011\u0019)\u0003b\u000b\t\u000f\r-\u0015\u000e1\u0001\u0003P\u0005YA-Z2pI\u0016$g*Y7f\u00039I7o\u00149fe\u0006$xN\u001d(b[\u0016\f!\u0002\\8oON#(/\u001b8h\u0003-!WMY;h'R\u0014\u0018N\\4\u0002%Q|7\u000b\u001e:j]\u001e<\u0016\u000e\u001e5Tk\u001a4\u0017\u000e\u001f\u000b\u0005\u0005\u001f\"I\u0004C\u0004\u0004 :\u0004\rAa\u0014\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"Aa\u0014\u0002\u0011\u0005\u0004\b/\u001a8e)>$\u0002\"!%\u0005D\u00115Cq\n\u0005\b\t\u000b\u0002\b\u0019\u0001C$\u0003\u0019\u0011WO\u001a4feB!\u0011q\u0019C%\u0013\u0011!Y%!3\u0003\u0019M#(/\u001b8h\u0005V4g-\u001a:\t\u000f\t\r\u0005\u000f1\u0001\u0003\u000e!9!q\u00129A\u0002\t5\u0011&B\u0012\u0002\n\u0005e\u0002\u0003\u0002B\u0011\t+JA\u0001b\u0016\u0002\f\nYA+\u001a:n\u001d\u0006lW-\u00119j))\u0011y\u0002b\u0017\u0005^\u0011}C\u0011\r\u0005\t\u0005_\u000b)\u00021\u0001\u0003\u000e!A!\u0011WA\u000b\u0001\u0004\u0011i\u0001\u0003\u0005\u0003\u0006\u0006U\u0001\u0019\u0001B\u0010\u0011!\u0011Y%!\u0006A\u0002\t=C\u0003\u0002B\u0010\tKB\u0001B!2\u0002$\u0001\u0007!q\n\u000b\u0007\u0005?!I\u0007b\u001b\t\u0011\t=\u0017q\u0005a\u0001\u0005\u001bA\u0001Ba5\u0002(\u0001\u0007!QB\u0001\u0014GJ,\u0017\r^3D_6\u0004\u0018M\\5p]:\u000bW.\u001a\u000b\u0005\u0005G#\t\b\u0003\u0005\u0003\u0006\u0006-\u0002\u0019\u0001BR\u00035!\u0018\u0010]3ICNDG/\u00192mKV\u0011Aq\u000f\t\u0007\u0003{\nYNa)\u0002\u0011\u0005dGNT1nKN$\"\u0001\" \u0011\r\t\u0015Hq\u0010B\u0010\u0013\u0011!\tIa<\u0003\u0011%#XM]1u_J\f\u0011\u0002[1tQZ\u000bG.^3\u0015\u0011\t5Aq\u0011CE\t\u0017CqA!\u0002\u0012\u0001\u0004\tI\u000eC\u0004\u0004FE\u0001\rA!\u0004\t\u000f\t\u001d\u0013\u00031\u0001\u0003\u000e\u00051Q-];bYN$\"\"a/\u0005\u0012\u0012MEQ\u0013CL\u0011\u001d\u0011\u0019E\u0005a\u0001\u0005\u001bAqA!\u0002\u0013\u0001\u0004\tI\u000eC\u0004\u0004FI\u0001\rA!\u0004\t\u000f\t\u001d#\u00031\u0001\u0003\u000e\u0005QQM\u001c;fe\u000eC\u0017M]:\u0015\u0011\u0005EEQ\u0014CP\tCCqA!\u0002\u0014\u0001\u0004\tI\u000eC\u0004\u0004FM\u0001\rA!\u0004\t\u000f\t\u001d3\u00031\u0001\u0003\u000e\u0005Ya.Z<UKJlg*Y7f)!\u0011y\u0002b*\u0005*\u0012-\u0006b\u0002B\u0003)\u0001\u0007\u0011\u0011\u001c\u0005\b\u0007\u000b\"\u0002\u0019\u0001B\u0007\u0011\u001d\u00119\u0005\u0006a\u0001\u0005\u001b!BAa\b\u00050\"9!QA\u000bA\u0002\u0005e\u0017a\u00038foRK\b/\u001a(b[\u0016$BAa)\u00056\"9!Q\u0001\fA\u0002\u0005eGC\u0003B\u0010\ts#Y\f\"0\u0005@\"9!QA\fA\u0002\u0005e\u0007bBB#/\u0001\u0007!Q\u0002\u0005\b\u0005c;\u0002\u0019\u0001B\u0007\u0011\u001d\u0011Ye\u0006a\u0001\u0005\u001f\"\"Ba)\u0005D\u0012\u0015Gq\u0019Ce\u0011\u001d\u0011)\u0001\u0007a\u0001\u00033Dqa!\u0012\u0019\u0001\u0004\u0011i\u0001C\u0004\u0003Ha\u0001\rA!\u0004\t\u000f\t-\u0003\u00041\u0001\u0003PQ!!q\u0004Cg\u0011\u001d\u0019Y'\u0007a\u0001\u0005\u001fBs!\u0007Ci\t/$Y\u000e\u0005\u0003\u0002~\u0011M\u0017\u0002\u0002Ck\u0003g\u0012A\u0003Z3qe\u0016\u001c\u0017\r^3e\u001fZ,'O]5eS:<\u0017E\u0001Cm\u0003i\"v\u000eI:z]\u000eD'o\u001c8ju\u0016d\u0003%^:fA\u0001|g/\u001a:sS\u0012,\u0007\u0005Z3gAMLhn\u00195s_:L'0\u001a(b[\u0016\u001c\b%\u0010\u0011ueV,\u0007-\t\u0002\u0005^\u00061!GL\u00192]A\"BAa)\u0005b\"911\u000e\u000eA\u0002\t=\u0003f\u0002\u000e\u0005R\u0012]G1\u001c\u000b\t\u0005?!9\u000fb=\u0005v\"9A\u0011^\u000eA\u0002\u0011-\u0018A\u00012t!\u0019\ti(a7\u0005nB!\u0011Q\u0010Cx\u0013\u0011!\t0a\u001d\u0003\t\tKH/\u001a\u0005\b\u0007\u000bZ\u0002\u0019\u0001B\u0007\u0011\u001d\u00119e\u0007a\u0001\u0005\u001b\t\u0011C\\3x)\u0016\u0014XNT1nK\u000e\u000b7\r[3e)\u0011\u0011y\u0002b?\t\u000f\r-D\u00041\u0001\u0003P\u0005\tb.Z<UsB,g*Y7f\u0007\u0006\u001c\u0007.\u001a3\u0015\t\t\rV\u0011\u0001\u0005\b\u0007Wj\u0002\u0019\u0001B()!\u0011\u0019+\"\u0002\u0006\b\u0015%\u0001b\u0002B\u0003=\u0001\u0007\u0011\u0011\u001c\u0005\b\u0007\u000br\u0002\u0019\u0001B\u0007\u0011\u001d\u00119E\ba\u0001\u0005\u001b!\u0002Ba)\u0006\u000e\u0015=Q\u0011\u0003\u0005\b\tS|\u0002\u0019\u0001Cv\u0011\u001d\u0019)e\ba\u0001\u0005\u001bAqAa\u0012 \u0001\u0004\u0011i!\u0001\bm_>\\W\u000f\u001d+za\u0016t\u0015-\\3\u0015\t\t\rVq\u0003\u0005\b\u0005\u000b\u0001\u0003\u0019AAm\u0003)\te.\u001f(b[\u0016|\u0005o\u001d\u000b\u0005\u000b;)y\u0006E\u0003\u0003\"Q\u00149CA\u0004OC6,w\n]:\u0016\t\u0015\rRqE\n\u0004i\u0006m\u0004\u0003\u0002B\u0000\u000bO!q!\"\u000bu\u0005\u0004\u0019)AA\u0001U)\u0011)i#b\f\u0011\u000b\t\u0005B/\"\n\t\u000f\rMg\u000f1\u0001\u0006&\u0005Y1\u000f\u001e:jaN+hMZ5y)\u0011))#\"\u000e\t\u000f\r}u\u000f1\u0001\u0003PQ!QQEC\u001d\u0011\u001d\u0019y\n\u001fa\u0001\u0005O\tA\u0001^1lKR!QQEC \u0011\u001d)\t%\u001fa\u0001\u0005\u001b\t\u0011A\\\u0001\u0005IJ|\u0007\u000f\u0006\u0003\u0006&\u0015\u001d\u0003bBC!u\u0002\u0007!QB\u0001\nIJ|\u0007OU5hQR$B!\"\n\u0006N!9Q\u0011I>A\u0002\t5\u0011!\u00033s_BdunY1m\u0003)!'o\u001c9TKR$XM]\u0001\u000bIJ|\u0007/T8ek2,WCAC\u0013\u0003%awnY1m\u001d\u0006lW-\u0001\u0006tKR$XM\u001d(b[\u0016\f!bZ3ui\u0016\u0014h*Y7f\u0003a!'o\u001c9Ue\u0006LGoU3ui\u0016\u00148+\u001a9be\u0006$xN\u001d\u0005\b\u0007'\f\b\u0019\u0001B\u0014\u0003-!VM]7OC6,w\n]:\u0015\t\u0015\u0015Tq\r\t\u0006\u0005C!(q\u0004\u0005\b\u0007'\u0014\b\u0019\u0001B\u0010\u0003-!\u0016\u0010]3OC6,w\n]:\u0015\t\u00155Tq\u000e\t\u0006\u0005C!(1\u0015\u0005\b\u0007'\u001c\b\u0019\u0001BR\u0003\u001dq\u0015-\\3UC\u001e,\"!\"\u001e\u0011\r\u0015]T\u0011\u0010B\u0014\u001b\t\ty'\u0003\u0003\u0006|\u0005=$\u0001C\"mCN\u001cH+Y4\u0002\u0017Q+'/\u001c(b[\u0016$\u0016mZ\u000b\u0003\u000b\u0003\u0003b!b\u001e\u0006z\t}\u0011\u0001\u0003+fe6t\u0015-\\3\u0011\t\t\u0005\u0012\u0011G\n\u0005\u0003c)I\t\u0005\u0003\u0003\"\u0015-\u0015\u0002BCG\u0003\u0017\u0013\u0011\u0003V3s[:\u000bW.Z#yiJ\f7\r^8s)\t)))A\u0003baBd\u0017\u0010\u0006\u0003\u0003 \u0015U\u0005\u0002CB6\u0003k\u0001\rAa\u0014\u0002\u000fUt\u0017\r\u001d9msR!Q1TCQ!\u0019\ti(\"(\u0003P%!QqTA:\u0005\u0019y\u0005\u000f^5p]\"A11[A\u001c\u0001\u0004\u0011y\"A\u0006UsB,g*Y7f)\u0006<WCACT!\u0019)9(\"\u001f\u0003$\u0006AA+\u001f9f\u001d\u0006lW\r\u0005\u0003\u0003\"\u0005\u00054\u0003BA1\u000b_\u0003BA!\t\u00062&!Q1WAF\u0005E!\u0016\u0010]3OC6,W\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u000bW#BAa)\u0006:\"A11NA3\u0001\u0004\u0011y\u0005\u0006\u0003\u0006\u001c\u0016u\u0006\u0002CBj\u0003O\u0002\rAa)")
public interface Names
extends scala.reflect.api.Names {
    @Override
    public Names$TermName$ TermName();

    @Override
    public Names$TypeName$ TypeName();

    public void scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$nameLock_$eq(Object var1);

    public void scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$termHashtable_$eq(TermName[] var1);

    public void scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$typeHashtable_$eq(TypeName[] var1);

    public void scala$reflect$internal$Names$_setter_$NameTag_$eq(ClassTag<Name> var1);

    public void scala$reflect$internal$Names$_setter_$TermNameTag_$eq(ClassTag<TermName> var1);

    public void scala$reflect$internal$Names$_setter_$TypeNameTag_$eq(ClassTag<TypeName> var1);

    private int HASH_SIZE() {
        return 32768;
    }

    private int HASH_MASK() {
        return Short.MAX_VALUE;
    }

    private int NAME_SIZE() {
        return 131072;
    }

    public static /* synthetic */ boolean nameDebug$(Names $this) {
        return $this.nameDebug();
    }

    default public boolean nameDebug() {
        return false;
    }

    public static /* synthetic */ boolean synchronizeNames$(Names $this) {
        return $this.synchronizeNames();
    }

    default public boolean synchronizeNames() {
        return false;
    }

    public Object scala$reflect$internal$Names$$nameLock();

    public char[] scala$reflect$internal$Names$$_chrs();

    public void scala$reflect$internal$Names$$_chrs_$eq(char[] var1);

    public static /* synthetic */ char[] chrs$(Names $this) {
        return $this.chrs();
    }

    default public char[] chrs() {
        return this.scala$reflect$internal$Names$$_chrs();
    }

    public static /* synthetic */ void chrs_$eq$(Names $this, char[] cs) {
        $this.chrs_$eq(cs);
    }

    default public void chrs_$eq(char[] cs) {
        this.scala$reflect$internal$Names$$_chrs_$eq(cs);
    }

    public int scala$reflect$internal$Names$$nc();

    public void scala$reflect$internal$Names$$nc_$eq(int var1);

    public TermName[] scala$reflect$internal$Names$$termHashtable();

    public TypeName[] scala$reflect$internal$Names$$typeHashtable();

    public static /* synthetic */ Iterator allNames$(Names $this) {
        return $this.allNames();
    }

    default public Iterator<TermName> allNames() {
        return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$reflect$internal$Names$$termHashtable())).iterator().filter((Function1<Object, Object>)(Function1<TermName, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(Names.$anonfun$allNames$1(x$1))).flatMap((Function1<TermName, Iterator> & java.io.Serializable & Serializable)n -> {
            void iterate_f;
            Function1<TermName, TermName> & java.io.Serializable & Serializable intersect = (Function1<TermName, TermName> & java.io.Serializable & Serializable)x$2 -> x$2.next();
            if (package$.MODULE$.Iterator() == null) {
                throw null;
            }
            return new AbstractIterator<T>(n, (Function1)iterate_f){
                private boolean first;
                private T acc;
                private final Function1 f$2;

                public boolean hasNext() {
                    return true;
                }

                public T next() {
                    if (this.first) {
                        this.first = false;
                    } else {
                        this.acc = this.f$2.apply(this.acc);
                    }
                    return this.acc;
                }
                {
                    this.f$2 = f$2;
                    this.first = true;
                    this.acc = start$2;
                }
            }.takeWhile((Function1<TermName, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(Names.$anonfun$allNames$4(x$3)));
        });
    }

    public static /* synthetic */ int scala$reflect$internal$Names$$hashValue$(Names $this, char[] cs, int offset, int len) {
        return $this.scala$reflect$internal$Names$$hashValue(cs, offset, len);
    }

    default public int scala$reflect$internal$Names$$hashValue(char[] cs, int offset, int len) {
        int h = 0;
        for (int i = 0; i < len; ++i) {
            h = 31 * h + cs[i + offset];
        }
        return h;
    }

    private boolean equals(int index, char[] cs, int offset, int len) {
        int i;
        char[] chrs = this.scala$reflect$internal$Names$$_chrs();
        for (i = 0; i < len && chrs[index + i] == cs[offset + i]; ++i) {
        }
        return i == len;
    }

    private void enterChars(char[] cs, int offset, int len) {
        for (int i = 0; i < len; ++i) {
            if (this.scala$reflect$internal$Names$$nc() + i == this.scala$reflect$internal$Names$$_chrs().length) {
                char[] newchrs = new char[this.scala$reflect$internal$Names$$_chrs().length * 2];
                System.arraycopy(this.scala$reflect$internal$Names$$_chrs(), 0, newchrs, 0, this.scala$reflect$internal$Names$$_chrs().length);
                this.scala$reflect$internal$Names$$_chrs_$eq(newchrs);
            }
            this.scala$reflect$internal$Names$$_chrs()[this.scala$reflect$internal$Names$$nc() + i] = cs[offset + i];
        }
        if (len == 0) {
            this.scala$reflect$internal$Names$$nc_$eq(this.scala$reflect$internal$Names$$nc() + 1);
            return;
        }
        this.scala$reflect$internal$Names$$nc_$eq(this.scala$reflect$internal$Names$$nc() + len);
    }

    public static /* synthetic */ TermName newTermName$(Names $this, char[] cs, int offset, int len) {
        return $this.newTermName(cs, offset, len);
    }

    default public TermName newTermName(char[] cs, int offset, int len) {
        return this.newTermName(cs, offset, len, null);
    }

    public static /* synthetic */ TermName newTermName$(Names $this, char[] cs) {
        return $this.newTermName(cs);
    }

    default public TermName newTermName(char[] cs) {
        return this.newTermName(cs, 0, cs.length);
    }

    public static /* synthetic */ TypeName newTypeName$(Names $this, char[] cs) {
        return $this.newTypeName(cs);
    }

    default public TypeName newTypeName(char[] cs) {
        return this.newTypeName(cs, 0, cs.length);
    }

    public static /* synthetic */ TermName newTermName$(Names $this, char[] cs, int offset, int len0, String cachedString) {
        return $this.newTermName(cs, offset, len0, cachedString);
    }

    default public TermName newTermName(char[] cs, int offset, int len0, String cachedString) {
        if (this.synchronizeNames()) {
            Object object = this.scala$reflect$internal$Names$$nameLock();
            synchronized (object) {
                TermName termName = this.body$1(offset, len0, cs, cachedString);
                return termName;
            }
        }
        return this.body$1(offset, len0, cs, cachedString);
    }

    public static /* synthetic */ TypeName newTypeName$(Names $this, char[] cs, int offset, int len, String cachedString) {
        return $this.newTypeName(cs, offset, len, cachedString);
    }

    default public TypeName newTypeName(char[] cs, int offset, int len, String cachedString) {
        return this.newTermName(cs, offset, len, cachedString).toTypeName();
    }

    public static /* synthetic */ TermName newTermName$(Names $this, String s) {
        return $this.newTermName(s);
    }

    @Override
    default public TermName newTermName(String s) {
        return this.newTermName(s.toCharArray(), 0, s.length(), null);
    }

    public static /* synthetic */ TypeName newTypeName$(Names $this, String s) {
        return $this.newTypeName(s);
    }

    @Override
    default public TypeName newTypeName(String s) {
        return this.newTermName(s).toTypeName();
    }

    public static /* synthetic */ TermName newTermName$(Names $this, byte[] bs, int offset, int len) {
        return $this.newTermName(bs, offset, len);
    }

    default public TermName newTermName(byte[] bs, int offset, int len) {
        char[] chars = Codec$.MODULE$.fromUTF8(bs, offset, len);
        return this.newTermName(chars, 0, chars.length);
    }

    public static /* synthetic */ TermName newTermNameCached$(Names $this, String s) {
        return $this.newTermNameCached(s);
    }

    default public TermName newTermNameCached(String s) {
        return this.newTermName(s.toCharArray(), 0, s.length(), s);
    }

    public static /* synthetic */ TypeName newTypeNameCached$(Names $this, String s) {
        return $this.newTypeNameCached(s);
    }

    default public TypeName newTypeNameCached(String s) {
        return this.newTypeName(s.toCharArray(), 0, s.length(), s);
    }

    public static /* synthetic */ TypeName newTypeName$(Names $this, char[] cs, int offset, int len) {
        return $this.newTypeName(cs, offset, len);
    }

    default public TypeName newTypeName(char[] cs, int offset, int len) {
        return this.newTermName(cs, offset, len, null).toTypeName();
    }

    public static /* synthetic */ TypeName newTypeName$(Names $this, byte[] bs, int offset, int len) {
        return $this.newTypeName(bs, offset, len);
    }

    default public TypeName newTypeName(byte[] bs, int offset, int len) {
        return this.newTermName(bs, offset, len).toTypeName();
    }

    public static /* synthetic */ TypeName lookupTypeName$(Names $this, char[] cs) {
        return $this.lookupTypeName(cs);
    }

    /*
     * WARNING - void declaration
     */
    default public TypeName lookupTypeName(char[] cs) {
        void var3_3;
        void assert_assertion;
        boolean bl;
        TypeName typeName;
        int hash = this.scala$reflect$internal$Names$$hashValue(cs, 0, cs.length) & Short.MAX_VALUE;
        for (typeName = this.scala$reflect$internal$Names$$typeHashtable()[hash]; !(typeName == null || typeName.length() == cs.length && this.equals(typeName.start(), cs, 0, cs.length)); typeName = typeName.next()) {
        }
        boolean bl2 = bl = typeName != null;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)Names.$anonfun$lookupTypeName$1(cs)).toString());
        }
        return var3_3;
    }

    public static /* synthetic */ NameOps AnyNameOps$(Names $this, Name name) {
        return $this.AnyNameOps(name);
    }

    default public NameOps<Name> AnyNameOps(Name name) {
        return new NameOps(this, name);
    }

    public static /* synthetic */ NameOps TermNameOps$(Names $this, TermName name) {
        return $this.TermNameOps(name);
    }

    default public NameOps<TermName> TermNameOps(TermName name) {
        return new NameOps(this, (Name)name);
    }

    public static /* synthetic */ NameOps TypeNameOps$(Names $this, TypeName name) {
        return $this.TypeNameOps(name);
    }

    default public NameOps<TypeName> TypeNameOps(TypeName name) {
        return new NameOps(this, (Name)name);
    }

    public ClassTag<Name> NameTag();

    public ClassTag<TermName> TermNameTag();

    public ClassTag<TypeName> TypeNameTag();

    public static /* synthetic */ boolean $anonfun$allNames$1(TermName x$1) {
        return x$1 != null;
    }

    public static /* synthetic */ boolean $anonfun$allNames$4(TermName x$3) {
        return x$3 != null;
    }

    public static /* synthetic */ String $anonfun$newTermName$1(int offset$1) {
        return new StringBuilder(33).append("offset must be non-negative, got ").append(offset$1).toString();
    }

    /*
     * WARNING - void declaration
     */
    private TermName body$1(int offset$1, int len0$1, char[] cs$1, String cachedString$1) {
        TermName termName;
        int startIndex;
        TermName n;
        void require_requirement;
        boolean bl;
        boolean bl2 = bl = offset$1 >= 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (require_requirement == false) {
            throw new IllegalArgumentException(new StringBuilder(20).append("requirement failed: ").append((Object)Names.$anonfun$newTermName$1(offset$1)).toString());
        }
        int len = scala.math.package$.MODULE$.max(len0$1, 0);
        int h = this.scala$reflect$internal$Names$$hashValue(cs$1, offset$1, len) & Short.MAX_VALUE;
        for (n = this.scala$reflect$internal$Names$$termHashtable()[h]; !(n == null || n.length() == len && this.equals(n.start(), cs$1, offset$1, len)); n = n.next()) {
        }
        if (n != null) {
            return n;
        }
        if (cs$1 == this.scala$reflect$internal$Names$$_chrs()) {
            startIndex = offset$1;
        } else {
            startIndex = this.scala$reflect$internal$Names$$nc();
            this.enterChars(cs$1, offset$1, len);
        }
        TermName next = this.scala$reflect$internal$Names$$termHashtable()[h];
        this.scala$reflect$internal$Names$$termHashtable()[h] = termName = new TermName(this, startIndex, len, next, cachedString$1);
        return termName;
    }

    public static /* synthetic */ String $anonfun$lookupTypeName$1(char[] cs$2) {
        return new StringBuilder(26).append("TypeName ").append(new String(cs$2)).append(" not yet created.").toString();
    }

    public static void $init$(Names $this) {
        $this.scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$nameLock_$eq(new Object());
        $this.scala$reflect$internal$Names$$_chrs_$eq(new char[131072]);
        $this.scala$reflect$internal$Names$$nc_$eq(0);
        $this.scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$termHashtable_$eq(new TermName[32768]);
        $this.scala$reflect$internal$Names$_setter_$scala$reflect$internal$Names$$typeHashtable_$eq(new TypeName[32768]);
        $this.scala$reflect$internal$Names$_setter_$NameTag_$eq(ClassTag$.MODULE$.apply(Name.class));
        $this.scala$reflect$internal$Names$_setter_$TermNameTag_$eq(ClassTag$.MODULE$.apply(TermName.class));
        $this.scala$reflect$internal$Names$_setter_$TypeNameTag_$eq(ClassTag$.MODULE$.apply(TypeName.class));
    }

    public abstract class Name
    extends Names.NameApi
    implements NameHasIsEmpty,
    CharSequence {
        private final int index;
        private final int len;
        private final String cachedString;

        @Override
        public IntStream chars() {
            return CharSequence.super.chars();
        }

        @Override
        public IntStream codePoints() {
            return CharSequence.super.codePoints();
        }

        public int index() {
            return this.index;
        }

        public int len() {
            return this.len;
        }

        public String cachedString() {
            return this.cachedString;
        }

        public abstract Name thisName();

        public final int start() {
            return this.index();
        }

        public abstract Name next();

        @Override
        public final int length() {
            return this.len();
        }

        public final boolean nonEmpty() {
            return !this.isEmpty();
        }

        @Override
        public final boolean isEmpty() {
            return this.length() == 0;
        }

        public abstract String nameKind();

        @Override
        public abstract boolean isTermName();

        @Override
        public abstract boolean isTypeName();

        @Override
        public abstract TermName toTermName();

        @Override
        public abstract TypeName toTypeName();

        public abstract Name companionName();

        public List<Name> bothNames() {
            return new $colon$colon<Nothing$>((Nothing$)((Object)this.toTermName()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)this.toTypeName()), Nil$.MODULE$));
        }

        public final <N extends Name> N asTypeOf(N other) {
            return (N)(other.isTermName() ? this.toTermName() : this.toTypeName());
        }

        public abstract Name subName(int var1, int var2);

        @Override
        public CharSequence subSequence(int from, int to) {
            return this.subName(from, to);
        }

        public abstract Name newName(String var1);

        public Name mapName(Function1<String, String> f) {
            return this.newName(f.apply(this.toString()));
        }

        public final void copyChars(char[] cs, int offset) {
            System.arraycopy(this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs(), this.index(), cs, offset, this.len());
        }

        /*
         * WARNING - void declaration
         */
        public final char[] toChars() {
            void var1_1;
            char[] cs = new char[this.len()];
            this.copyChars(cs, 0);
            return var1_1;
        }

        public final int hashCode() {
            return this.index();
        }

        public boolean string_$eq$eq(Name that) {
            if (that != null) {
                String string = this.toString();
                String string2 = that.toString();
                if (!(string != null ? !string.equals(string2) : string2 != null)) {
                    return true;
                }
            }
            return false;
        }

        public boolean string_$eq$eq(String that) {
            if (that != null) {
                String string = this.toString();
                if (string != null && string.equals(that)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public final char charAt(int i) {
            return this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs()[this.index() + i];
        }

        public final int pos(char c) {
            return this.pos(c, 0);
        }

        public final int pos(String s) {
            return this.pos(s, 0);
        }

        /*
         * WARNING - void declaration
         */
        public final int pos(char c, int start) {
            void var3_3;
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            for (int i = start; i < this.len() && chrs[this.index() + i] != c; ++i) {
            }
            return (int)var3_3;
        }

        public final int pos(String s, int start) {
            int i = this.pos(s.charAt(0), start);
            int sLen = s.length();
            if (sLen == 1) {
                return i;
            }
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            while (i + sLen <= this.len()) {
                int j = 1;
                while (s.charAt(j) == chrs[this.index() + i + j]) {
                    if (++j != sLen) continue;
                    return i;
                }
                i = this.pos(s.charAt(0), i + 1);
            }
            return this.len();
        }

        public final int lastPos(char c) {
            return this.lastPos(c, this.len() - 1);
        }

        /*
         * WARNING - void declaration
         */
        public final int lastPos(char c, int start) {
            void var3_3;
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            for (int i = start; i >= 0 && chrs[this.index() + i] != c; --i) {
            }
            return (int)var3_3;
        }

        public final boolean startsWith(Name prefix) {
            return this.startsWith(prefix, 0);
        }

        public final boolean startsWith(Name prefix, int start) {
            int i;
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            for (i = 0; i < prefix.length() && start + i < this.len() && chrs[this.index() + start + i] == chrs[prefix.start() + i]; ++i) {
            }
            return i == prefix.length();
        }

        public final boolean startsWith(String prefix, int start) {
            int i;
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            for (i = 0; i < prefix.length() && start + i < this.len() && chrs[this.index() + start + i] == prefix.charAt(i); ++i) {
            }
            return i == prefix.length();
        }

        public final boolean endsWith(Name suffix) {
            return this.endsWith(suffix, this.len());
        }

        public final boolean endsWith(Name suffix, int end) {
            int i;
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            for (i = 1; i <= suffix.length() && i <= end && chrs[this.index() + end - i] == chrs[suffix.start() + suffix.length() - i]; ++i) {
            }
            return i > suffix.length();
        }

        public final boolean endsWith(String suffix, int end) {
            int i;
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            for (i = 1; i <= suffix.length() && i <= end && chrs[this.index() + end - i] == suffix.charAt(suffix.length() - i); ++i) {
            }
            return i > suffix.length();
        }

        public final boolean containsName(String subname) {
            return this.containsName(this.scala$reflect$internal$Names$Name$$$outer().newTermName(subname));
        }

        public final boolean containsName(Name subname) {
            int start;
            int last = this.len() - subname.length();
            for (start = 0; start <= last && !this.startsWith(subname, start); ++start) {
            }
            return start <= last;
        }

        public final boolean containsChar(char ch) {
            int max = this.index() + this.len();
            char[] chrs = this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs();
            for (int i = this.index(); i < max; ++i) {
                if (chrs[i] != ch) continue;
                return true;
            }
            return false;
        }

        public final char startChar() {
            return this.charAt(0);
        }

        public final char endChar() {
            return this.charAt(this.len() - 1);
        }

        public final boolean startsWith(char c) {
            return this.len() > 0 && this.startChar() == c;
        }

        public final boolean startsWith(String name) {
            return this.startsWith(name, 0);
        }

        public final boolean endsWith(char c) {
            return this.len() > 0 && this.endChar() == c;
        }

        public final boolean endsWith(String name) {
            return this.endsWith(name, this.len());
        }

        private int fixIndexOf(int idx) {
            if (idx == this.length()) {
                return -1;
            }
            return idx;
        }

        public int indexOf(char ch) {
            return this.fixIndexOf(this.pos(ch));
        }

        public int indexOf(char ch, int fromIndex) {
            return this.fixIndexOf(this.pos(ch, fromIndex));
        }

        public int indexOf(String s) {
            return this.fixIndexOf(this.pos(s));
        }

        public int lastIndexOf(char ch) {
            return this.lastPos(ch);
        }

        public int lastIndexOf(String s) {
            return this.toString().lastIndexOf(s);
        }

        public Name replace(char from, char to) {
            char[] cs = new char[this.len()];
            for (int i = 0; i < this.len(); ++i) {
                char ch = this.charAt(i);
                cs[i] = ch == from ? to : ch;
            }
            return this.scala$reflect$internal$Names$Name$$$outer().newTermName(cs, 0, this.len());
        }

        @Override
        public String decoded() {
            return this.decode();
        }

        @Override
        public String encoded() {
            return String.valueOf(this.encode());
        }

        @Override
        public Name encodedName() {
            return this.encode();
        }

        public Name encode() {
            String res;
            String str = this.toString();
            String string = res = NameTransformer$.MODULE$.encode(str);
            if (!(string != null ? !string.equals(str) : str != null)) {
                return this.thisName();
            }
            return this.newName(res);
        }

        /*
         * WARNING - void declaration
         */
        public String decode() {
            if (this.containsChar('$')) {
                void var2_2;
                String res;
                String str = this.toString();
                String string = res = NameTransformer$.MODULE$.decode(str);
                if (!(string != null ? !string.equals(str) : str != null)) {
                    return str;
                }
                return var2_2;
            }
            return this.toString();
        }

        public Name append(char ch) {
            return this.newName(new StringBuilder(0).append(this.toString()).append(ch).toString());
        }

        public Name append(String suffix) {
            return this.newName(new StringBuilder(0).append(this.toString()).append(suffix).toString());
        }

        public Name append(Name suffix) {
            return this.newName(new StringBuilder(0).append(this.toString()).append(suffix).toString());
        }

        public Name append(char separator, Name suffix) {
            return this.newName(new StringBuilder(0).append(this.toString()).append(separator).append(suffix).toString());
        }

        public Name prepend(String prefix) {
            return this.newName(new StringBuilder(0).append(prefix).append(this).toString());
        }

        @Override
        public Name decodedName() {
            return this.newName(this.decode());
        }

        public boolean isOperatorName() {
            String string = this.decode();
            String string2 = this.toString();
            return string == null ? string2 != null : !string.equals(string2);
        }

        public String longString() {
            return new StringBuilder(1).append(this.nameKind()).append(" ").append(this.decode()).toString();
        }

        /*
         * WARNING - void declaration
         */
        public String debugString() {
            void var1_1;
            String s = this.decode();
            if (this.isTypeName()) {
                return new StringBuilder(1).append(s).append("!").toString();
            }
            return var1_1;
        }

        public final String toStringWithSuffix(String suffix) {
            StringBuilder builder = new StringBuilder(this.length() + suffix.length());
            builder.append(this);
            builder.append(suffix);
            return builder.toString();
        }

        @Override
        public final String toString() {
            if (this.cachedString() == null) {
                return new String(this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs(), this.index(), this.len());
            }
            return this.cachedString();
        }

        public final void appendTo(StringBuffer buffer, int start, int length) {
            buffer.append(this.scala$reflect$internal$Names$Name$$$outer().scala$reflect$internal$Names$$_chrs(), this.start() + start, length);
        }

        public /* synthetic */ Names scala$reflect$internal$Names$Name$$$outer() {
            return (Names)this.$outer;
        }

        public Name(Names $outer, int index, int len, String cachedString) {
            this.index = index;
            this.len = len;
            this.cachedString = cachedString;
        }
    }

    public interface NameHasIsEmpty {
        public boolean isEmpty();
    }

    public final class NameOps<T extends Name> {
        private final T name;
        private final /* synthetic */ Names $outer;

        public T stripSuffix(String suffix) {
            if (((Name)this.name).endsWith(suffix)) {
                return this.dropRight(suffix.length());
            }
            return this.name;
        }

        public T stripSuffix(Name suffix) {
            if (((Name)this.name).endsWith(suffix)) {
                return this.dropRight(suffix.length());
            }
            return this.name;
        }

        public T take(int n) {
            return (T)((Name)this.name).subName(0, n);
        }

        public T drop(int n) {
            return (T)((Name)this.name).subName(n, ((Name)this.name).length());
        }

        public T dropRight(int n) {
            return (T)((Name)this.name).subName(0, ((Name)this.name).length() - n);
        }

        public TermName dropLocal() {
            return this.$outer.TermNameOps(((Name)this.name).toTermName()).stripSuffix(" ");
        }

        public TermName dropSetter() {
            return this.$outer.TermNameOps(((Name)this.name).toTermName()).stripSuffix("_$eq");
        }

        public T dropModule() {
            return this.stripSuffix("$");
        }

        public TermName localName() {
            return (TermName)this.getterName().append(" ");
        }

        public TermName setterName() {
            return (TermName)this.getterName().append("_$eq");
        }

        public TermName getterName() {
            return this.$outer.TermNameOps(this.$outer.TermNameOps(this.dropTraitSetterSeparator()).dropSetter()).dropLocal();
        }

        private TermName dropTraitSetterSeparator() {
            int n = ((Name)this.name).indexOf("$_setter_$");
            switch (n) {
                case -1: {
                    return ((Name)this.name).toTermName();
                }
            }
            return this.$outer.TermNameOps(this.$outer.TermNameOps(((Name)this.name).toTermName()).drop(n)).drop("$_setter_$".length());
        }

        public NameOps(T name) {
            this.name = name;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public final class TermName
    extends Name
    implements Names.TermNameApi {
        private final TermName next;

        @Override
        public TermName next() {
            return this.next;
        }

        @Override
        public TermName thisName() {
            return this;
        }

        @Override
        public boolean isTermName() {
            return true;
        }

        @Override
        public boolean isTypeName() {
            return false;
        }

        @Override
        public TermName toTermName() {
            return this;
        }

        @Override
        public TypeName toTypeName() {
            if (this.scala$reflect$internal$Names$TermName$$$outer().synchronizeNames()) {
                Object object = this.scala$reflect$internal$Names$TermName$$$outer().scala$reflect$internal$Names$$nameLock();
                synchronized (object) {
                    TypeName typeName = this.body$2();
                    return typeName;
                }
            }
            return this.body$2();
        }

        @Override
        public TermName newName(String str) {
            return this.scala$reflect$internal$Names$TermName$$$outer().newTermName(str);
        }

        @Override
        public TypeName companionName() {
            return this.toTypeName();
        }

        @Override
        public TermName subName(int from, int to) {
            return this.scala$reflect$internal$Names$TermName$$$outer().newTermName(this.scala$reflect$internal$Names$TermName$$$outer().scala$reflect$internal$Names$$_chrs(), this.start() + from, to - from);
        }

        @Override
        public String nameKind() {
            return "term";
        }

        private TypeName createCompanionName(TypeName next) {
            return new TypeName(this.scala$reflect$internal$Names$TermName$$$outer(), this.index(), this.len(), next, super.cachedString());
        }

        public /* synthetic */ Names scala$reflect$internal$Names$TermName$$$outer() {
            return (Names)this.$outer;
        }

        private final TypeName body$2() {
            TypeName typeName;
            TypeName n;
            int h = this.scala$reflect$internal$Names$TermName$$$outer().scala$reflect$internal$Names$$hashValue(this.scala$reflect$internal$Names$TermName$$$outer().scala$reflect$internal$Names$$_chrs(), this.index(), this.len()) & Short.MAX_VALUE;
            for (n = this.scala$reflect$internal$Names$TermName$$$outer().scala$reflect$internal$Names$$typeHashtable()[h]; n != null && n.start() != this.index(); n = n.next()) {
            }
            if (n != null) {
                return n;
            }
            TypeName next = this.scala$reflect$internal$Names$TermName$$$outer().scala$reflect$internal$Names$$typeHashtable()[h];
            this.scala$reflect$internal$Names$TermName$$$outer().scala$reflect$internal$Names$$typeHashtable()[h] = typeName = this.createCompanionName(next);
            return typeName;
        }

        public TermName(Names $outer, int index0, int len0, TermName next, String cachedString) {
            this.next = next;
            super($outer, index0, len0, cachedString);
        }
    }

    public final class TypeName
    extends Name
    implements Names.TypeNameApi {
        private final TypeName next;

        @Override
        public TypeName next() {
            return this.next;
        }

        @Override
        public TypeName thisName() {
            return this;
        }

        @Override
        public boolean isTermName() {
            return false;
        }

        @Override
        public boolean isTypeName() {
            return true;
        }

        @Override
        public TermName toTermName() {
            if (this.scala$reflect$internal$Names$TypeName$$$outer().synchronizeNames()) {
                Object object = this.scala$reflect$internal$Names$TypeName$$$outer().scala$reflect$internal$Names$$nameLock();
                synchronized (object) {
                    TermName termName = this.body$3();
                    return termName;
                }
            }
            return this.body$3();
        }

        @Override
        public TypeName toTypeName() {
            return this;
        }

        @Override
        public TypeName newName(String str) {
            return this.scala$reflect$internal$Names$TypeName$$$outer().newTypeName(str);
        }

        @Override
        public TermName companionName() {
            return this.toTermName();
        }

        @Override
        public TypeName subName(int from, int to) {
            return this.scala$reflect$internal$Names$TypeName$$$outer().newTypeName(this.scala$reflect$internal$Names$TypeName$$$outer().scala$reflect$internal$Names$$_chrs(), this.start() + from, to - from);
        }

        @Override
        public String nameKind() {
            return "type";
        }

        @Override
        public String decode() {
            return super.decode();
        }

        public /* synthetic */ Names scala$reflect$internal$Names$TypeName$$$outer() {
            return (Names)this.$outer;
        }

        public static final /* synthetic */ String $anonfun$toTermName$1(TypeName $this) {
            return new StringBuilder(38).append("TypeName ").append($this).append(" is missing its correspondent").toString();
        }

        /*
         * WARNING - void declaration
         */
        private final TermName body$3() {
            void var2_2;
            void assert_assertion;
            boolean bl;
            TermName n;
            int h = this.scala$reflect$internal$Names$TypeName$$$outer().scala$reflect$internal$Names$$hashValue(this.scala$reflect$internal$Names$TypeName$$$outer().scala$reflect$internal$Names$$_chrs(), this.index(), this.len()) & Short.MAX_VALUE;
            for (n = this.scala$reflect$internal$Names$TypeName$$$outer().scala$reflect$internal$Names$$termHashtable()[h]; n != null && n.start() != this.index(); n = n.next()) {
            }
            boolean bl2 = bl = n != null;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)TypeName.$anonfun$toTermName$1(this)).toString());
            }
            return var2_2;
        }

        public TypeName(Names $outer, int index0, int len0, TypeName next, String cachedString) {
            this.next = next;
            super($outer, index0, len0, cachedString);
        }
    }
}

