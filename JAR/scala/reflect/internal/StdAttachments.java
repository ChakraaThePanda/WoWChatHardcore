/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Internals;
import scala.reflect.internal.Positions;
import scala.reflect.internal.StdAttachments$BackquotedIdentifierAttachment$;
import scala.reflect.internal.StdAttachments$ChangeOwnerAttachment$;
import scala.reflect.internal.StdAttachments$CompoundTypeTreeOriginalAttachment$;
import scala.reflect.internal.StdAttachments$DelambdafyTarget$;
import scala.reflect.internal.StdAttachments$ForAttachment$;
import scala.reflect.internal.StdAttachments$InlineCallsiteAttachment$;
import scala.reflect.internal.StdAttachments$JustMethodReference$;
import scala.reflect.internal.StdAttachments$KnownDirectSubclassesCalled$;
import scala.reflect.internal.StdAttachments$NoInlineCallsiteAttachment$;
import scala.reflect.internal.StdAttachments$NoWarnAttachment$;
import scala.reflect.internal.StdAttachments$OuterArgCanBeElided$;
import scala.reflect.internal.StdAttachments$PatVarDefAttachment$;
import scala.reflect.internal.StdAttachments$SAMFunction$;
import scala.reflect.internal.StdAttachments$SubpatternsAttachment$;
import scala.reflect.internal.StdAttachments$SyntheticUnitAttachment$;
import scala.reflect.internal.StdAttachments$TypeParamVarargsAttachment$;
import scala.reflect.internal.StdAttachments$UseInvokeSpecial$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.Position;
import scala.reflect.macros.Attachments;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0019]a\u0001\u0004B\n\u0005+\u0001\n1!\u0001\u0003$\u0019=\u0001b\u0002B\u0017\u0001\u0011\u0005!q\u0006\u0004\n\u0005o\u0001\u0001\u0013aA\u0001\u0005sAqA!\f\u0003\t\u0003\u0011y\u0003C\u0005\u0003<\t\u0001\r\u0011\"\u0005\u0003>!I!\u0011\r\u0002A\u0002\u0013E!1\r\u0005\b\u0005_\u0012A\u0011\u0001B\u001f\u0011\u001d\u0011\tH\u0001C\u0001\u0005gBqAa \u0003\t\u0003\u0011\t\tC\u0004\u0003.\n!\tAa,\t\u000f\tu&\u0001\"\u0001\u0003@\"9!1\u001b\u0002\u0005\u0002\tU\u0007b\u0002Bu\u0005\u0011\u0005!1\u001e\u0005\b\u0005[\u0014A\u0011\u0001Bx\u0011\u001d\u0011\u0019P\u0001C\u0001\u0005k4\u0011Ba?\u0001!\u0003\r\nA!@\t\u000f\t}xB\"\u0001\u0004\u0002\u0019I1q\u0003\u0001\u0011\u0002\u0007\u00051\u0011\u0004\u0005\b\u0005[\tB\u0011\u0001B\u0018\u0011\u001d\u0011y0\u0005C\u0001\u0007;1aaa\t\u0001\u0001\u000e\u0015\u0002BCB\u001a)\tU\r\u0011\"\u0001\u00046!Q1q\n\u000b\u0003\u0012\u0003\u0006Iaa\u000e\t\u0015\rECC!f\u0001\n\u0003\u0019)\u0004\u0003\u0006\u0004TQ\u0011\t\u0012)A\u0005\u0007oAqa!\u0016\u0015\t\u0003\u00199\u0006C\u0005\u0004`Q\t\t\u0011\"\u0001\u0004b!I1q\r\u000b\u0012\u0002\u0013\u00051\u0011\u000e\u0005\n\u0007\u007f\"\u0012\u0013!C\u0001\u0007SB\u0011b!!\u0015\u0003\u0003%\tea!\t\u0013\rUE#!A\u0005\u0002\r]\u0005\"CBP)\u0005\u0005I\u0011ABQ\u0011%\u0019)\u000bFA\u0001\n\u0003\u001a9\u000bC\u0005\u00046R\t\t\u0011\"\u0001\u00048\"I11\u0018\u000b\u0002\u0002\u0013\u00053Q\u0018\u0005\n\u0007\u007f#\u0012\u0011!C!\u0007\u0003D\u0011ba1\u0015\u0003\u0003%\te!2\b\u0013\r%\u0007!!A\t\u0002\r-g!CB\u0012\u0001\u0005\u0005\t\u0012ABg\u0011\u001d\u0019)F\nC\u0001\u00077D\u0011ba0'\u0003\u0003%)e!1\t\u0013\rug%!A\u0005\u0002\u000e}\u0007\"CBsM\u0005\u0005I\u0011QBt\r\u0019\u0019)\u0010\u0001!\u0004x\"Q11`\u0016\u0003\u0016\u0004%\ta!@\t\u0015\u0011%1F!E!\u0002\u0013\u0019y\u0010\u0003\u0006\u0005\f-\u0012)\u001a!C\u0001\t\u001bA!\u0002\"\u0007,\u0005#\u0005\u000b\u0011\u0002C\b\u0011)!Yb\u000bBK\u0002\u0013\u0005AQ\u0002\u0005\u000b\t;Y#\u0011#Q\u0001\n\u0011=\u0001bBB+W\u0011\u0005Aq\u0004\u0005\n\u0007?Z\u0013\u0011!C\u0001\tSA\u0011ba\u001a,#\u0003%\t\u0001\"\r\t\u0013\r}4&%A\u0005\u0002\u0011U\u0002\"\u0003C\u001dWE\u0005I\u0011\u0001C\u001b\u0011%\u0019\tiKA\u0001\n\u0003\u001a\u0019\tC\u0005\u0004\u0016.\n\t\u0011\"\u0001\u0004\u0018\"I1qT\u0016\u0002\u0002\u0013\u0005A1\b\u0005\n\u0007K[\u0013\u0011!C!\u0007OC\u0011b!.,\u0003\u0003%\t\u0001b\u0010\t\u0013\rm6&!A\u0005B\ru\u0006\"CB`W\u0005\u0005I\u0011IBa\u0011%\u0019\u0019mKA\u0001\n\u0003\"\u0019eB\u0005\u0005H\u0001\t\t\u0011#\u0001\u0005J\u0019I1Q\u001f\u0001\u0002\u0002#\u0005A1\n\u0005\b\u0007+\u0002E\u0011\u0001C*\u0011%\u0019y\fQA\u0001\n\u000b\u001a\t\rC\u0005\u0004^\u0002\u000b\t\u0011\"!\u0005V!I1Q\u001d!\u0002\u0002\u0013\u0005EQL\u0004\b\tS\u0002\u0001\u0012\u0011C6\r\u001d!i\u0007\u0001EA\t_Bqa!\u0016G\t\u0003!\t\bC\u0005\u0004\u0002\u001a\u000b\t\u0011\"\u0011\u0004\u0004\"I1Q\u0013$\u0002\u0002\u0013\u00051q\u0013\u0005\n\u0007?3\u0015\u0011!C\u0001\tgB\u0011b!*G\u0003\u0003%\tea*\t\u0013\rUf)!A\u0005\u0002\u0011]\u0004\"CB^\r\u0006\u0005I\u0011IB_\u0011%\u0019yLRA\u0001\n\u0003\u001a\tM\u0002\u0004\u0005|\u0001\u0001EQ\u0010\u0005\u000b\t\u007fz%Q3A\u0005\u0002\u00115\u0001B\u0003CA\u001f\nE\t\u0015!\u0003\u0005\u0010!91QK(\u0005\u0002\u0011\r\u0005\"CB0\u001f\u0006\u0005I\u0011\u0001CE\u0011%\u00199gTI\u0001\n\u0003!)\u0004C\u0005\u0004\u0002>\u000b\t\u0011\"\u0011\u0004\u0004\"I1QS(\u0002\u0002\u0013\u00051q\u0013\u0005\n\u0007?{\u0015\u0011!C\u0001\t\u001bC\u0011b!*P\u0003\u0003%\tea*\t\u0013\rUv*!A\u0005\u0002\u0011E\u0005\"CB^\u001f\u0006\u0005I\u0011IB_\u0011%\u0019ylTA\u0001\n\u0003\u001a\t\rC\u0005\u0004D>\u000b\t\u0011\"\u0011\u0005\u0016\u001eIA\u0011\u0014\u0001\u0002\u0002#\u0005A1\u0014\u0004\n\tw\u0002\u0011\u0011!E\u0001\t;Cqa!\u0016_\t\u0003!)\u000bC\u0005\u0004@z\u000b\t\u0011\"\u0012\u0004B\"I1Q\u001c0\u0002\u0002\u0013\u0005Eq\u0015\u0005\n\u0007Kt\u0016\u0011!CA\tW;q\u0001\"-\u0001\u0011\u0003#\u0019LB\u0004\u00056\u0002A\t\tb.\t\u000f\rUC\r\"\u0001\u0005:\"I1\u0011\u00113\u0002\u0002\u0013\u000531\u0011\u0005\n\u0007+#\u0017\u0011!C\u0001\u0007/C\u0011ba(e\u0003\u0003%\t\u0001b/\t\u0013\r\u0015F-!A\u0005B\r\u001d\u0006\"CB[I\u0006\u0005I\u0011\u0001C`\u0011%\u0019Y\fZA\u0001\n\u0003\u001ai\fC\u0005\u0004@\u0012\f\t\u0011\"\u0011\u0004B\u001e9A1\u0019\u0001\t\u0002\u0012\u0015ga\u0002Cd\u0001!\u0005E\u0011\u001a\u0005\b\u0007+rG\u0011\u0001Cf\u0011%\u0019\tI\\A\u0001\n\u0003\u001a\u0019\tC\u0005\u0004\u0016:\f\t\u0011\"\u0001\u0004\u0018\"I1q\u00148\u0002\u0002\u0013\u0005AQ\u001a\u0005\n\u0007Ks\u0017\u0011!C!\u0007OC\u0011b!.o\u0003\u0003%\t\u0001\"5\t\u0013\rmf.!A\u0005B\ru\u0006\"CB`]\u0006\u0005I\u0011IBa\u000f\u001d!)\u000e\u0001EA\t/4q\u0001\"7\u0001\u0011\u0003#Y\u000eC\u0004\u0004Va$\t\u0001\"8\t\u0013\r\u0005\u00050!A\u0005B\r\r\u0005\"CBKq\u0006\u0005I\u0011ABL\u0011%\u0019y\n_A\u0001\n\u0003!y\u000eC\u0005\u0004&b\f\t\u0011\"\u0011\u0004(\"I1Q\u0017=\u0002\u0002\u0013\u0005A1\u001d\u0005\n\u0007wC\u0018\u0011!C!\u0007{C\u0011ba0y\u0003\u0003%\te!1\b\u000f\u0011\u001d\b\u0001#!\u0005j\u001a9A1\u001e\u0001\t\u0002\u00125\b\u0002CB+\u0003\u000b!\t\u0001b<\t\u0015\r\u0005\u0015QAA\u0001\n\u0003\u001a\u0019\t\u0003\u0006\u0004\u0016\u0006\u0015\u0011\u0011!C\u0001\u0007/C!ba(\u0002\u0006\u0005\u0005I\u0011\u0001Cy\u0011)\u0019)+!\u0002\u0002\u0002\u0013\u00053q\u0015\u0005\u000b\u0007k\u000b)!!A\u0005\u0002\u0011U\bBCB^\u0003\u000b\t\t\u0011\"\u0011\u0004>\"Q1qXA\u0003\u0003\u0003%\te!1\b\u000f\u0011e\b\u0001#!\u0005|\u001a9AQ \u0001\t\u0002\u0012}\b\u0002CB+\u00033!\t!\"\u0001\t\u0015\r\u0005\u0015\u0011DA\u0001\n\u0003\u001a\u0019\t\u0003\u0006\u0004\u0016\u0006e\u0011\u0011!C\u0001\u0007/C!ba(\u0002\u001a\u0005\u0005I\u0011AC\u0002\u0011)\u0019)+!\u0007\u0002\u0002\u0013\u00053q\u0015\u0005\u000b\u0007k\u000bI\"!A\u0005\u0002\u0015\u001d\u0001BCB^\u00033\t\t\u0011\"\u0011\u0004>\"Q1qXA\r\u0003\u0003%\te!1\u0007\r\u0015-\u0001\u0001QC\u0007\u0011-)y!a\u000b\u0003\u0016\u0004%\ta!\u000e\t\u0017\u0015E\u00111\u0006B\tB\u0003%1q\u0007\u0005\t\u0007+\nY\u0003\"\u0001\u0006\u0014!Q1qLA\u0016\u0003\u0003%\t!\"\u0007\t\u0015\r\u001d\u00141FI\u0001\n\u0003\u0019I\u0007\u0003\u0006\u0004\u0002\u0006-\u0012\u0011!C!\u0007\u0007C!b!&\u0002,\u0005\u0005I\u0011ABL\u0011)\u0019y*a\u000b\u0002\u0002\u0013\u0005QQ\u0004\u0005\u000b\u0007K\u000bY#!A\u0005B\r\u001d\u0006BCB[\u0003W\t\t\u0011\"\u0001\u0006\"!Q11XA\u0016\u0003\u0003%\te!0\t\u0015\r}\u00161FA\u0001\n\u0003\u001a\t\r\u0003\u0006\u0004D\u0006-\u0012\u0011!C!\u000bK9\u0011\"\"\u000b\u0001\u0003\u0003E\t!b\u000b\u0007\u0013\u0015-\u0001!!A\t\u0002\u00155\u0002\u0002CB+\u0003\u0013\"\t!\"\r\t\u0015\r}\u0016\u0011JA\u0001\n\u000b\u001a\t\r\u0003\u0006\u0004^\u0006%\u0013\u0011!CA\u000bgA!b!:\u0002J\u0005\u0005I\u0011QC\u001c\r\u001d)i\u0004AA\u0001\u000b\u007fA\u0001b!\u0016\u0002T\u0011\u0005Q\u0011I\u0004\b\u000b\u000b\u0002\u0001\u0012QC$\r\u001d)I\u0005\u0001EA\u000b\u0017B\u0001b!\u0016\u0002Z\u0011\u0005QQ\n\u0005\u000b\u0007\u0003\u000bI&!A\u0005B\r\r\u0005BCBK\u00033\n\t\u0011\"\u0001\u0004\u0018\"Q1qTA-\u0003\u0003%\t!b\u0014\t\u0015\r\u0015\u0016\u0011LA\u0001\n\u0003\u001a9\u000b\u0003\u0006\u00046\u0006e\u0013\u0011!C\u0001\u000b'B!ba/\u0002Z\u0005\u0005I\u0011IB_\u0011)\u0019y,!\u0017\u0002\u0002\u0013\u00053\u0011Y\u0004\b\u000b/\u0002\u0001\u0012QC-\r\u001d)Y\u0006\u0001EA\u000b;B\u0001b!\u0016\u0002n\u0011\u0005Qq\f\u0005\u000b\u0007\u0003\u000bi'!A\u0005B\r\r\u0005BCBK\u0003[\n\t\u0011\"\u0001\u0004\u0018\"Q1qTA7\u0003\u0003%\t!\"\u0019\t\u0015\r\u0015\u0016QNA\u0001\n\u0003\u001a9\u000b\u0003\u0006\u00046\u00065\u0014\u0011!C\u0001\u000bKB!ba/\u0002n\u0005\u0005I\u0011IB_\u0011)\u0019y,!\u001c\u0002\u0002\u0013\u00053\u0011Y\u0004\b\u000bS\u0002\u0001\u0012QC6\r\u001d)i\u0007\u0001EA\u000b_B\u0001b!\u0016\u0002\u0002\u0012\u0005Q\u0011\u000f\u0005\u000b\u0007\u0003\u000b\t)!A\u0005B\r\r\u0005BCBK\u0003\u0003\u000b\t\u0011\"\u0001\u0004\u0018\"Q1qTAA\u0003\u0003%\t!b\u001d\t\u0015\r\u0015\u0016\u0011QA\u0001\n\u0003\u001a9\u000b\u0003\u0006\u00046\u0006\u0005\u0015\u0011!C\u0001\u000boB!ba/\u0002\u0002\u0006\u0005I\u0011IB_\u0011)\u0019y,!!\u0002\u0002\u0013\u00053\u0011Y\u0004\b\u000bw\u0002\u0001\u0012QC?\r\u001d)y\b\u0001EA\u000b\u0003C\u0001b!\u0016\u0002\u0016\u0012\u0005Q1\u0011\u0005\u000b\u0007\u0003\u000b)*!A\u0005B\r\r\u0005BCBK\u0003+\u000b\t\u0011\"\u0001\u0004\u0018\"Q1qTAK\u0003\u0003%\t!\"\"\t\u0015\r\u0015\u0016QSA\u0001\n\u0003\u001a9\u000b\u0003\u0006\u00046\u0006U\u0015\u0011!C\u0001\u000b\u0013C!ba/\u0002\u0016\u0006\u0005I\u0011IB_\u0011)\u0019y,!&\u0002\u0002\u0013\u00053\u0011\u0019\u0004\u0007\u000b\u001b\u0003\u0001)b$\t\u0017\u0015E\u0015q\u0015BK\u0002\u0013\u00051Q \u0005\f\u000b'\u000b9K!E!\u0002\u0013\u0019y\u0010\u0003\u0005\u0004V\u0005\u001dF\u0011ACK\u0011)\u0019y&a*\u0002\u0002\u0013\u0005Q1\u0014\u0005\u000b\u0007O\n9+%A\u0005\u0002\u0011E\u0002BCBA\u0003O\u000b\t\u0011\"\u0011\u0004\u0004\"Q1QSAT\u0003\u0003%\taa&\t\u0015\r}\u0015qUA\u0001\n\u0003)y\n\u0003\u0006\u0004&\u0006\u001d\u0016\u0011!C!\u0007OC!b!.\u0002(\u0006\u0005I\u0011ACR\u0011)\u0019Y,a*\u0002\u0002\u0013\u00053Q\u0018\u0005\u000b\u0007\u007f\u000b9+!A\u0005B\r\u0005\u0007BCBb\u0003O\u000b\t\u0011\"\u0011\u0006(\u001eIQ1\u0016\u0001\u0002\u0002#\u0005QQ\u0016\u0004\n\u000b\u001b\u0003\u0011\u0011!E\u0001\u000b_C\u0001b!\u0016\u0002F\u0012\u0005Q1\u0017\u0005\u000b\u0007\u007f\u000b)-!A\u0005F\r\u0005\u0007BCBo\u0003\u000b\f\t\u0011\"!\u00066\"Q1Q]Ac\u0003\u0003%\t)\"/\b\u000f\u0015}\u0006\u0001#!\u0006B\u001a9Q1\u0019\u0001\t\u0002\u0016\u0015\u0007\u0002CB+\u0003#$\t!b2\t\u0015\r\u0005\u0015\u0011[A\u0001\n\u0003\u001a\u0019\t\u0003\u0006\u0004\u0016\u0006E\u0017\u0011!C\u0001\u0007/C!ba(\u0002R\u0006\u0005I\u0011ACe\u0011)\u0019)+!5\u0002\u0002\u0013\u00053q\u0015\u0005\u000b\u0007k\u000b\t.!A\u0005\u0002\u00155\u0007BCB^\u0003#\f\t\u0011\"\u0011\u0004>\"Q1qXAi\u0003\u0003%\te!1\u0007\r\u0015E\u0007\u0001ACj\u0011-)).a9\u0003\u0006\u0004%\t\u0001\"\u0004\t\u0017\u0015]\u00171\u001dB\u0001B\u0003%Aq\u0002\u0005\t\u0007+\n\u0019\u000f\"\u0001\u0006Z\u001a1Qq\u001c\u0001A\u000bCD1\"b9\u0002l\nU\r\u0011\"\u0001\u0005\u000e!YQQ]Av\u0005#\u0005\u000b\u0011\u0002C\b\u0011!\u0019)&a;\u0005\u0002\u0015\u001d\bBCB0\u0003W\f\t\u0011\"\u0001\u0006n\"Q1qMAv#\u0003%\t\u0001\"\u000e\t\u0015\r\u0005\u00151^A\u0001\n\u0003\u001a\u0019\t\u0003\u0006\u0004\u0016\u0006-\u0018\u0011!C\u0001\u0007/C!ba(\u0002l\u0006\u0005I\u0011ACy\u0011)\u0019)+a;\u0002\u0002\u0013\u00053q\u0015\u0005\u000b\u0007k\u000bY/!A\u0005\u0002\u0015U\bBCB^\u0003W\f\t\u0011\"\u0011\u0004>\"Q1qXAv\u0003\u0003%\te!1\t\u0015\r\r\u00171^A\u0001\n\u0003*IpB\u0005\u0006~\u0002\t\t\u0011#\u0001\u0006\u0000\u001aIQq\u001c\u0001\u0002\u0002#\u0005a\u0011\u0001\u0005\t\u0007+\u0012I\u0001\"\u0001\u0007\u0006!Q1q\u0018B\u0005\u0003\u0003%)e!1\t\u0015\ru'\u0011BA\u0001\n\u000339\u0001\u0003\u0006\u0004f\n%\u0011\u0011!CA\r\u0017\u0011ab\u0015;e\u0003R$\u0018m\u00195nK:$8O\u0003\u0003\u0003\u0018\te\u0011\u0001C5oi\u0016\u0014h.\u00197\u000b\t\tm!QD\u0001\be\u00164G.Z2u\u0015\t\u0011y\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0007\u0001\u0011)\u0003\u0005\u0003\u0003(\t%RB\u0001B\u000f\u0013\u0011\u0011YC!\b\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uIQ\u0011!\u0011\u0007\t\u0005\u0005O\u0011\u0019$\u0003\u0003\u00036\tu!\u0001B+oSR\u0014!\"\u0011;uC\u000eD\u0017M\u00197f'\r\u0011!QE\u0001\u0007e\u0006<\u0018\r\u001e;\u0016\u0005\t}\"\u0003\u0002B!\u0005\u000b2aAa\u0011\u0003\u0001\t}\"\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004\u0003\u0002B$\u0005\u001bj!A!\u0013\u000b\t\t-#\u0011D\u0001\u0007[\u0006\u001c'o\\:\n\t\t=#\u0011\n\u0002\f\u0003R$\u0018m\u00195nK:$8/B\u0004\u0003T\t\u0005\u0003E!\u0016\u0003\u0007A{7\u000f\u0005\u0003\u0003X\teS\"\u0001\u0001\n\t\tm#Q\f\u0002\t!>\u001c\u0018\u000e^5p]&!!q\fB\u000b\u0005%\u0001vn]5uS>t7/\u0001\u0006sC^\fG\u000f^0%KF$BA!\r\u0003f!I!qM\u0003\u0002\u0002\u0003\u0007!\u0011N\u0001\u0004q\u0012\n$\u0003\u0002B6\u0005\u000b2aAa\u0011\u0003\u0001\t%Ta\u0002B*\u0005W\u0002#QK\u0001\fCR$\u0018m\u00195nK:$8/\u0001\btKR\fE\u000f^1dQ6,g\u000e^:\u0015\t\tU$qO\u0007\u0002\u0005!9!qN\u0004A\u0002\te$\u0003\u0002B>\u0005\u000b2aAa\u0011\u0003\u0001\teTa\u0002B*\u0005w\u0002#QK\u0001\u0011kB$\u0017\r^3BiR\f7\r[7f]R,BAa!\u0003\u0018R!!Q\u0011BU)\u0011\u0011)Ha\"\t\u0013\t%\u0005\"!AA\u0004\t-\u0015AC3wS\u0012,gnY3%cA1!Q\u0012BH\u0005'k!A!\u0007\n\t\tE%\u0011\u0004\u0002\t\u00072\f7o\u001d+bOB!!Q\u0013BL\u0019\u0001!qA!'\t\u0005\u0004\u0011YJA\u0001U#\u0011\u0011iJa)\u0011\t\t\u001d\"qT\u0005\u0005\u0005C\u0013iBA\u0004O_RD\u0017N\\4\u0011\t\t\u001d\"QU\u0005\u0005\u0005O\u0013iBA\u0002B]fDqAa+\t\u0001\u0004\u0011\u0019*\u0001\u0006biR\f7\r[7f]R\f\u0001C]3n_Z,\u0017\t\u001e;bG\"lWM\u001c;\u0016\t\tE&1\u0018\u000b\u0005\u0005k\u0012\u0019\fC\u0005\u00036&\t\t\u0011q\u0001\u00038\u0006QQM^5eK:\u001cW\r\n\u001a\u0011\r\t5%q\u0012B]!\u0011\u0011)Ja/\u0005\u000f\te\u0015B1\u0001\u0003\u001c\u00061r-\u001a;B]\u0012\u0014V-\\8wK\u0006#H/Y2i[\u0016tG/\u0006\u0003\u0003B\n-G\u0003\u0002Bb\u0005\u001b\u0004bAa\n\u0003F\n%\u0017\u0002\u0002Bd\u0005;\u0011aa\u00149uS>t\u0007\u0003\u0002BK\u0005\u0017$qA!'\u000b\u0005\u0004\u0011Y\nC\u0005\u0003P*\t\t\u0011q\u0001\u0003R\u0006QQM^5eK:\u001cW\rJ\u001a\u0011\r\t5%q\u0012Be\u00035A\u0017m]!ui\u0006\u001c\u0007.\\3oiV!!q\u001bBt)\u0011\u0011INa8\u0011\t\t\u001d\"1\\\u0005\u0005\u0005;\u0014iBA\u0004C_>dW-\u00198\t\u0013\t\u00058\"!AA\u0004\t\r\u0018AC3wS\u0012,gnY3%iA1!Q\u0012BH\u0005K\u0004BA!&\u0003h\u00129!\u0011T\u0006C\u0002\tm\u0015a\u00019pgV\u0011!QK\u0001\ba>\u001cx\fJ3r)\u0011\u0011\tD!=\t\u000f\t%X\u00021\u0001\u0003V\u000511/\u001a;Q_N$BA!\u001e\u0003x\"9!\u0011 \bA\u0002\tU\u0013A\u00028foB|7O\u0001\u000bJ[B|'\u000f^1cY\u0016\fE\u000f^1dQ6,g\u000e^\n\u0004\u001f\t\u0015\u0012\u0001E5na>\u0014H/\u0011;uC\u000eDW.\u001a8u)\u0011\u0019\u0019a!\u0002\u000e\u0003=Aqaa\u0002\u0011\u0001\u0004\u0019I!\u0001\u0005j[B|'\u000f^3s!\u0011\u00119fa\u0003\n\t\r51q\u0002\u0002\t\u00136\u0004xN\u001d;fe&!1\u0011CB\n\u0005%Ie\u000e^3s]\u0006d7O\u0003\u0003\u0004\u0016\te\u0011aA1qS\ny\u0001\u000b\\1j]\u0006#H/Y2i[\u0016tGoE\u0003\u0012\u0005K\u0019Y\u0002E\u0002\u0003X=!Baa\b\u0004\"5\t\u0011\u0003C\u0004\u0004\bM\u0001\ra!\u0003\u0003E\r{W\u000e]8v]\u0012$\u0016\u0010]3Ue\u0016,wJ]5hS:\fG.\u0011;uC\u000eDW.\u001a8u'\u001d!\"QEB\u0014\u0007[\u0001BAa\n\u0004*%!11\u0006B\u000f\u0005\u001d\u0001&o\u001c3vGR\u0004BAa\n\u00040%!1\u0011\u0007B\u000f\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003\u001d\u0001\u0018M]3oiN,\"aa\u000e\u0011\r\re2qHB#\u001d\u0011\u00119ca\u000f\n\t\ru\"QD\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\u0019\tea\u0011\u0003\t1K7\u000f\u001e\u0006\u0005\u0007{\u0011i\u0002\u0005\u0003\u0003X\r\u001d\u0013\u0002BB%\u0007\u0017\u0012A\u0001\u0016:fK&!1Q\nB\u000b\u0005\u0015!&/Z3t\u0003!\u0001\u0018M]3oiN\u0004\u0013!B:uCR\u001c\u0018AB:uCR\u001c\b%\u0001\u0004=S:LGO\u0010\u000b\u0007\u00073\u001aYf!\u0018\u0011\u0007\t]C\u0003C\u0004\u00044e\u0001\raa\u000e\t\u000f\rE\u0013\u00041\u0001\u00048\u0005!1m\u001c9z)\u0019\u0019Ifa\u0019\u0004f!I11\u0007\u000e\u0011\u0002\u0003\u00071q\u0007\u0005\n\u0007#R\u0002\u0013!a\u0001\u0007o\tabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0002\u0004l)\"1qGB7W\t\u0019y\u0007\u0005\u0003\u0004r\rmTBAB:\u0015\u0011\u0019)ha\u001e\u0002\u0013Ut7\r[3dW\u0016$'\u0002BB=\u0005;\t!\"\u00198o_R\fG/[8o\u0013\u0011\u0019iha\u001d\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\t\u0019)\t\u0005\u0003\u0004\b\u000eEUBABE\u0015\u0011\u0019Yi!$\u0002\t1\fgn\u001a\u0006\u0003\u0007\u001f\u000bAA[1wC&!11SBE\u0005\u0019\u0019FO]5oO\u0006a\u0001O]8ek\u000e$\u0018I]5usV\u00111\u0011\u0014\t\u0005\u0005O\u0019Y*\u0003\u0003\u0004\u001e\nu!aA%oi\u0006q\u0001O]8ek\u000e$X\t\\3nK:$H\u0003\u0002BR\u0007GC\u0011Ba\u001a \u0003\u0003\u0005\ra!'\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\"a!+\u0011\r\r-6\u0011\u0017BR\u001b\t\u0019iK\u0003\u0003\u00040\nu\u0011AC2pY2,7\r^5p]&!11WBW\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\te7\u0011\u0018\u0005\n\u0005O\n\u0013\u0011!a\u0001\u0005G\u000b\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0003\u00073\u000b\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0007\u000b\u000ba!Z9vC2\u001cH\u0003\u0002Bm\u0007\u000fD\u0011Ba\u001a%\u0003\u0003\u0005\rAa)\u0002E\r{W\u000e]8v]\u0012$\u0016\u0010]3Ue\u0016,wJ]5hS:\fG.\u0011;uC\u000eDW.\u001a8u!\r\u00119FJ\n\u0006M\r=7Q\u0006\t\u000b\u0007#\u001c9na\u000e\u00048\reSBABj\u0015\u0011\u0019)N!\b\u0002\u000fI,h\u000e^5nK&!1\u0011\\Bj\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|gN\r\u000b\u0003\u0007\u0017\fQ!\u00199qYf$ba!\u0017\u0004b\u000e\r\bbBB\u001aS\u0001\u00071q\u0007\u0005\b\u0007#J\u0003\u0019AB\u001c\u0003\u001d)h.\u00199qYf$Ba!;\u0004rB1!q\u0005Bc\u0007W\u0004\u0002Ba\n\u0004n\u000e]2qG\u0005\u0005\u0007_\u0014iB\u0001\u0004UkBdWM\r\u0005\n\u0007gT\u0013\u0011!a\u0001\u00073\n1\u0001\u001f\u00131\u0005-\u0019\u0016)\u0014$v]\u000e$\u0018n\u001c8\u0014\u0013-\u0012)c!?\u0004(\r5\u0002c\u0001B,#\u0005)1/Y7UaV\u00111q \t\u0005\u0005/\"\t!\u0003\u0003\u0005\u0004\u0011\u0015!\u0001\u0002+za\u0016LA\u0001b\u0002\u0003\u0016\t)A+\u001f9fg\u000611/Y7Ua\u0002\n1a]1n+\t!y\u0001\u0005\u0003\u0003X\u0011E\u0011\u0002\u0002C\n\t+\u0011aaU=nE>d\u0017\u0002\u0002C\f\u0005+\u0011qaU=nE>d7/\u0001\u0003tC6\u0004\u0013\u0001C:z]RD7\t\\:\u0002\u0013MLh\u000e\u001e5DYN\u0004C\u0003\u0003C\u0011\tG!)\u0003b\n\u0011\u0007\t]3\u0006C\u0004\u0004|J\u0002\raa@\t\u000f\u0011-!\u00071\u0001\u0005\u0010!9A1\u0004\u001aA\u0002\u0011=A\u0003\u0003C\u0011\tW!i\u0003b\f\t\u0013\rm8\u0007%AA\u0002\r}\b\"\u0003C\u0006gA\u0005\t\u0019\u0001C\b\u0011%!Yb\rI\u0001\u0002\u0004!y!\u0006\u0002\u00054)\"1q`B7+\t!9D\u000b\u0003\u0005\u0010\r5\u0014AD2paf$C-\u001a4bk2$He\r\u000b\u0005\u0005G#i\u0004C\u0005\u0003he\n\t\u00111\u0001\u0004\u001aR!!\u0011\u001cC!\u0011%\u00119gOA\u0001\u0002\u0004\u0011\u0019\u000b\u0006\u0003\u0003Z\u0012\u0015\u0003\"\u0003B4}\u0005\u0005\t\u0019\u0001BR\u0003-\u0019\u0016)\u0014$v]\u000e$\u0018n\u001c8\u0011\u0007\t]\u0003iE\u0003A\t\u001b\u001ai\u0003\u0005\u0007\u0004R\u0012=3q C\b\t\u001f!\t#\u0003\u0003\u0005R\rM'!E!cgR\u0014\u0018m\u0019;Gk:\u001cG/[8ogQ\u0011A\u0011\n\u000b\t\tC!9\u0006\"\u0017\u0005\\!911`\"A\u0002\r}\bb\u0002C\u0006\u0007\u0002\u0007Aq\u0002\u0005\b\t7\u0019\u0005\u0019\u0001C\b)\u0011!y\u0006b\u001a\u0011\r\t\u001d\"Q\u0019C1!)\u00119\u0003b\u0019\u0004\u0000\u0012=AqB\u0005\u0005\tK\u0012iB\u0001\u0004UkBdWm\r\u0005\n\u0007g$\u0015\u0011!a\u0001\tC\t\u0001\u0003R3mC6\u0014G-\u00194z)\u0006\u0014x-\u001a;\u0011\u0007\t]cI\u0001\tEK2\fWN\u00193bMf$\u0016M]4fiNIaI!\n\u0004z\u000e\u001d2Q\u0006\u000b\u0003\tW\"BAa)\u0005v!I!q\r&\u0002\u0002\u0003\u00071\u0011\u0014\u000b\u0005\u00053$I\bC\u0005\u0003h1\u000b\t\u00111\u0001\u0003$\n\u0019\"*^:u\u001b\u0016$\bn\u001c3SK\u001a,'/\u001a8dKNIqJ!\n\u0004z\u000e\u001d2QF\u0001\rY\u0006l'\rZ1UCJ<W\r^\u0001\u000eY\u0006l'\rZ1UCJ<W\r\u001e\u0011\u0015\t\u0011\u0015Eq\u0011\t\u0004\u0005/z\u0005b\u0002C@%\u0002\u0007Aq\u0002\u000b\u0005\t\u000b#Y\tC\u0005\u0005\u0000M\u0003\n\u00111\u0001\u0005\u0010Q!!1\u0015CH\u0011%\u00119gVA\u0001\u0002\u0004\u0019I\n\u0006\u0003\u0003Z\u0012M\u0005\"\u0003B43\u0006\u0005\t\u0019\u0001BR)\u0011\u0011I\u000eb&\t\u0013\t\u001dD,!AA\u0002\t\r\u0016a\u0005&vgRlU\r\u001e5pIJ+g-\u001a:f]\u000e,\u0007c\u0001B,=N)a\fb(\u0004.AA1\u0011\u001bCQ\t\u001f!))\u0003\u0003\u0005$\u000eM'!E!cgR\u0014\u0018m\u0019;Gk:\u001cG/[8ocQ\u0011A1\u0014\u000b\u0005\t\u000b#I\u000bC\u0004\u0005\u0000\u0005\u0004\r\u0001b\u0004\u0015\t\u00115Fq\u0016\t\u0007\u0005O\u0011)\rb\u0004\t\u0013\rM(-!AA\u0002\u0011\u0015\u0015A\b\"bG.\fXo\u001c;fI&#WM\u001c;jM&,'/\u0011;uC\u000eDW.\u001a8u!\r\u00119\u0006\u001a\u0002\u001f\u0005\u0006\u001c7.];pi\u0016$\u0017\nZ3oi&4\u0017.\u001a:BiR\f7\r[7f]R\u001c\u0012\u0002\u001aB\u0013\u0007s\u001c9c!\f\u0015\u0005\u0011MF\u0003\u0002BR\t{C\u0011Ba\u001ai\u0003\u0003\u0005\ra!'\u0015\t\teG\u0011\u0019\u0005\n\u0005OR\u0017\u0011!a\u0001\u0005G\u000b\u0001CT8XCJt\u0017\t\u001e;bG\"lWM\u001c;\u0011\u0007\t]cN\u0001\tO_^\u000b'O\\!ui\u0006\u001c\u0007.\\3oiNIaN!\n\u0004z\u000e\u001d2Q\u0006\u000b\u0003\t\u000b$BAa)\u0005P\"I!q\r:\u0002\u0002\u0003\u00071\u0011\u0014\u000b\u0005\u00053$\u0019\u000eC\u0005\u0003hQ\f\t\u00111\u0001\u0003$\u0006\u0019\u0002+\u0019;WCJ$UMZ!ui\u0006\u001c\u0007.\\3oiB\u0019!q\u000b=\u0003'A\u000bGOV1s\t\u00164\u0017\t\u001e;bG\"lWM\u001c;\u0014\u0013a\u0014)c!?\u0004(\r5BC\u0001Cl)\u0011\u0011\u0019\u000b\"9\t\u0013\t\u001dD0!AA\u0002\reE\u0003\u0002Bm\tKD\u0011Ba\u001a\u007f\u0003\u0003\u0005\rAa)\u0002\u001b\u0019{'/\u0011;uC\u000eDW.\u001a8u!\u0011\u00119&!\u0002\u0003\u001b\u0019{'/\u0011;uC\u000eDW.\u001a8u')\t)A!\n\u0004z\u000e\u001d2Q\u0006\u000b\u0003\tS$BAa)\u0005t\"Q!qMA\u0007\u0003\u0003\u0005\ra!'\u0015\t\teGq\u001f\u0005\u000b\u0005O\n\t\"!AA\u0002\t\r\u0016aF*z]RDW\r^5d+:LG/\u0011;uC\u000eDW.\u001a8u!\u0011\u00119&!\u0007\u0003/MKh\u000e\u001e5fi&\u001cWK\\5u\u0003R$\u0018m\u00195nK:$8CCA\r\u0005K\u0019Ipa\n\u0004.Q\u0011A1 \u000b\u0005\u0005G+)\u0001\u0003\u0006\u0003h\u0005\u0005\u0012\u0011!a\u0001\u00073#BA!7\u0006\n!Q!qMA\u0013\u0003\u0003\u0005\rAa)\u0003+M+(\r]1ui\u0016\u0014hn]!ui\u0006\u001c\u0007.\\3oiNA\u00111\u0006B\u0013\u0007O\u0019i#\u0001\u0005qCR$XM\u001d8t\u0003%\u0001\u0018\r\u001e;fe:\u001c\b\u0005\u0006\u0003\u0006\u0016\u0015]\u0001\u0003\u0002B,\u0003WA\u0001\"b\u0004\u00022\u0001\u00071q\u0007\u000b\u0005\u000b+)Y\u0002\u0003\u0006\u0006\u0010\u0005M\u0002\u0013!a\u0001\u0007o!BAa)\u0006 !Q!qMA\u001e\u0003\u0003\u0005\ra!'\u0015\t\teW1\u0005\u0005\u000b\u0005O\ny$!AA\u0002\t\rF\u0003\u0002Bm\u000bOA!Ba\u001a\u0002F\u0005\u0005\t\u0019\u0001BR\u0003U\u0019VO\u00199biR,'O\\:BiR\f7\r[7f]R\u0004BAa\u0016\u0002JM1\u0011\u0011JC\u0018\u0007[\u0001\u0002b!5\u0005\"\u000e]RQ\u0003\u000b\u0003\u000bW!B!\"\u0006\u00066!AQqBA(\u0001\u0004\u00199\u0004\u0006\u0003\u0006:\u0015m\u0002C\u0002B\u0014\u0005\u000b\u001c9\u0004\u0003\u0006\u0004t\u0006E\u0013\u0011!a\u0001\u000b+\u0011\u0011$\u00138mS:,\u0017I\u001c8pi\u0006$X\rZ!ui\u0006\u001c\u0007.\\3oiN!\u00111\u000bB\u0013)\t)\u0019\u0005\u0005\u0003\u0003X\u0005M\u0013A\u0007(p\u0013:d\u0017N\\3DC2d7/\u001b;f\u0003R$\u0018m\u00195nK:$\b\u0003\u0002B,\u00033\u0012!DT8J]2Lg.Z\"bY2\u001c\u0018\u000e^3BiR\f7\r[7f]R\u001c\u0002\"!\u0017\u0006D\r\u001d2Q\u0006\u000b\u0003\u000b\u000f\"BAa)\u0006R!Q!qMA1\u0003\u0003\u0005\ra!'\u0015\t\teWQ\u000b\u0005\u000b\u0005O\n)'!AA\u0002\t\r\u0016\u0001G%oY&tWmQ1mYNLG/Z!ui\u0006\u001c\u0007.\\3oiB!!qKA7\u0005aIe\u000e\\5oK\u000e\u000bG\u000e\\:ji\u0016\fE\u000f^1dQ6,g\u000e^\n\t\u0003[*\u0019ea\n\u0004.Q\u0011Q\u0011\f\u000b\u0005\u0005G+\u0019\u0007\u0003\u0006\u0003h\u0005U\u0014\u0011!a\u0001\u00073#BA!7\u0006h!Q!qMA=\u0003\u0003\u0005\rAa)\u0002'=+H/\u001a:Be\u001e\u001c\u0015M\u001c\"f\u000b2LG-\u001a3\u0011\t\t]\u0013\u0011\u0011\u0002\u0014\u001fV$XM]!sO\u000e\u000bgNQ3FY&$W\rZ\n\u000b\u0003\u0003\u0013)c!?\u0004(\r5BCAC6)\u0011\u0011\u0019+\"\u001e\t\u0015\t\u001d\u0014\u0011RA\u0001\u0002\u0004\u0019I\n\u0006\u0003\u0003Z\u0016e\u0004B\u0003B4\u0003\u001b\u000b\t\u00111\u0001\u0003$\u0006\u0001Rk]3J]Z|7.Z*qK\u000eL\u0017\r\u001c\t\u0005\u0005/\n)J\u0001\tVg\u0016LeN^8lKN\u0003XmY5bYNQ\u0011Q\u0013B\u0013\u0007s\u001c9c!\f\u0015\u0005\u0015uD\u0003\u0002BR\u000b\u000fC!Ba\u001a\u0002\u001e\u0006\u0005\t\u0019ABM)\u0011\u0011I.b#\t\u0015\t\u001d\u0014\u0011UA\u0001\u0002\u0004\u0011\u0019K\u0001\u000eUsB,\u0007+\u0019:b[Z\u000b'/\u0019:hg\u0006#H/Y2i[\u0016tGo\u0005\u0005\u0002(\n\u00152qEB\u0017\u00031!\u0018\u0010]3QCJ\fWNU3g\u00035!\u0018\u0010]3QCJ\fWNU3gAQ!QqSCM!\u0011\u00119&a*\t\u0011\u0015E\u0015Q\u0016a\u0001\u0007\u007f$B!b&\u0006\u001e\"QQ\u0011SAX!\u0003\u0005\raa@\u0015\t\t\rV\u0011\u0015\u0005\u000b\u0005O\n9,!AA\u0002\reE\u0003\u0002Bm\u000bKC!Ba\u001a\u0002<\u0006\u0005\t\u0019\u0001BR)\u0011\u0011I.\"+\t\u0015\t\u001d\u0014\u0011YA\u0001\u0002\u0004\u0011\u0019+\u0001\u000eUsB,\u0007+\u0019:b[Z\u000b'/\u0019:hg\u0006#H/Y2i[\u0016tG\u000f\u0005\u0003\u0003X\u0005\u00157CBAc\u000bc\u001bi\u0003\u0005\u0005\u0004R\u0012\u00056q`CL)\t)i\u000b\u0006\u0003\u0006\u0018\u0016]\u0006\u0002CCI\u0003\u0017\u0004\raa@\u0015\t\u0015mVQ\u0018\t\u0007\u0005O\u0011)ma@\t\u0015\rM\u0018QZA\u0001\u0002\u0004)9*A\u000eL]><h\u000eR5sK\u000e$8+\u001e2dY\u0006\u001c8/Z:DC2dW\r\u001a\t\u0005\u0005/\n\tNA\u000eL]><h\u000eR5sK\u000e$8+\u001e2dY\u0006\u001c8/Z:DC2dW\rZ\n\u000b\u0003#\u0014)c!?\u0004(\r5BCACa)\u0011\u0011\u0019+b3\t\u0015\t\u001d\u0014\u0011\\A\u0001\u0002\u0004\u0019I\n\u0006\u0003\u0003Z\u0016=\u0007B\u0003B4\u0003;\f\t\u00111\u0001\u0003$\n)\u0012+^1m)f\u0004XmU=n\u0003R$\u0018m\u00195nK:$8\u0003BAr\u0005K\t1a]=n\u0003\u0011\u0019\u00180\u001c\u0011\u0015\t\u0015mWQ\u001c\t\u0005\u0005/\n\u0019\u000f\u0003\u0005\u0006V\u0006%\b\u0019\u0001C\b\u0005U\u0019\u0005.\u00198hK>;h.\u001a:BiR\f7\r[7f]R\u001c\u0002\"a;\u0003&\r\u001d2QF\u0001\u000e_JLw-\u001b8bY>;h.\u001a:\u0002\u001d=\u0014\u0018nZ5oC2|uO\\3sAQ!Q\u0011^Cv!\u0011\u00119&a;\t\u0011\u0015\r\u0018\u0011\u001fa\u0001\t\u001f!B!\";\u0006p\"QQ1]Az!\u0003\u0005\r\u0001b\u0004\u0015\t\t\rV1\u001f\u0005\u000b\u0005O\nY0!AA\u0002\reE\u0003\u0002Bm\u000boD!Ba\u001a\u0002\u0000\u0006\u0005\t\u0019\u0001BR)\u0011\u0011I.b?\t\u0015\t\u001d$QAA\u0001\u0002\u0004\u0011\u0019+A\u000bDQ\u0006tw-Z(x]\u0016\u0014\u0018\t\u001e;bG\"lWM\u001c;\u0011\t\t]#\u0011B\n\u0007\u0005\u00131\u0019a!\f\u0011\u0011\rEG\u0011\u0015C\b\u000bS$\"!b@\u0015\t\u0015%h\u0011\u0002\u0005\t\u000bG\u0014y\u00011\u0001\u0005\u0010Q!AQ\u0016D\u0007\u0011)\u0019\u0019P!\u0005\u0002\u0002\u0003\u0007Q\u0011\u001e\t\u0005\r#1\u0019\"\u0004\u0002\u0003\u0016%!aQ\u0003B\u000b\u0005-\u0019\u00160\u001c2pYR\u000b'\r\\3")
public interface StdAttachments {
    public StdAttachments$CompoundTypeTreeOriginalAttachment$ CompoundTypeTreeOriginalAttachment();

    public StdAttachments$SAMFunction$ SAMFunction();

    public StdAttachments$DelambdafyTarget$ DelambdafyTarget();

    public StdAttachments$JustMethodReference$ JustMethodReference();

    public StdAttachments$BackquotedIdentifierAttachment$ BackquotedIdentifierAttachment();

    public StdAttachments$NoWarnAttachment$ NoWarnAttachment();

    public StdAttachments$PatVarDefAttachment$ PatVarDefAttachment();

    public StdAttachments$ForAttachment$ ForAttachment();

    public StdAttachments$SyntheticUnitAttachment$ SyntheticUnitAttachment();

    public StdAttachments$SubpatternsAttachment$ SubpatternsAttachment();

    public StdAttachments$NoInlineCallsiteAttachment$ NoInlineCallsiteAttachment();

    public StdAttachments$InlineCallsiteAttachment$ InlineCallsiteAttachment();

    public StdAttachments$OuterArgCanBeElided$ OuterArgCanBeElided();

    public StdAttachments$UseInvokeSpecial$ UseInvokeSpecial();

    public StdAttachments$TypeParamVarargsAttachment$ TypeParamVarargsAttachment();

    public StdAttachments$KnownDirectSubclassesCalled$ KnownDirectSubclassesCalled();

    public StdAttachments$ChangeOwnerAttachment$ ChangeOwnerAttachment();

    public static void $init$(StdAttachments $this) {
    }

    public interface Attachable {
        public Attachments rawatt();

        public void rawatt_$eq(Attachments var1);

        public static /* synthetic */ Attachments attachments$(Attachable $this) {
            return $this.attachments();
        }

        default public Attachments attachments() {
            return this.rawatt();
        }

        public static /* synthetic */ Attachable setAttachments$(Attachable $this, Attachments attachments) {
            return $this.setAttachments(attachments);
        }

        default public Attachable setAttachments(Attachments attachments) {
            this.rawatt_$eq(attachments);
            return this;
        }

        public static /* synthetic */ Attachable updateAttachment$(Attachable $this, Object attachment, ClassTag evidence$1) {
            return $this.updateAttachment(attachment, evidence$1);
        }

        default public <T> Attachable updateAttachment(T attachment, ClassTag<T> evidence$1) {
            this.rawatt_$eq(this.rawatt().update(attachment, evidence$1));
            return this;
        }

        public static /* synthetic */ Attachable removeAttachment$(Attachable $this, ClassTag evidence$2) {
            return $this.removeAttachment(evidence$2);
        }

        default public <T> Attachable removeAttachment(ClassTag<T> evidence$2) {
            this.rawatt_$eq(this.rawatt().remove(evidence$2));
            return this;
        }

        public static /* synthetic */ Option getAndRemoveAttachment$(Attachable $this, ClassTag evidence$3) {
            return $this.getAndRemoveAttachment(evidence$3);
        }

        /*
         * WARNING - void declaration
         */
        default public <T> Option<T> getAndRemoveAttachment(ClassTag<T> evidence$3) {
            void var2_2;
            Option<T> r = this.attachments().get(evidence$3);
            if (r.nonEmpty()) {
                this.removeAttachment(evidence$3);
            }
            return var2_2;
        }

        public static /* synthetic */ boolean hasAttachment$(Attachable $this, ClassTag evidence$4) {
            return $this.hasAttachment(evidence$4);
        }

        default public <T> boolean hasAttachment(ClassTag<T> evidence$4) {
            return this.rawatt().contains(evidence$4);
        }

        public static /* synthetic */ Position pos$(Attachable $this) {
            return $this.pos();
        }

        default public Position pos() {
            return (Position)this.rawatt().pos();
        }

        public static /* synthetic */ void pos_$eq$(Attachable $this, Position pos) {
            $this.pos_$eq(pos);
        }

        default public void pos_$eq(Position pos) {
            this.rawatt_$eq(this.rawatt().withPos(pos));
        }

        public static /* synthetic */ Attachable setPos$(Attachable $this, Position newpos) {
            return $this.setPos(newpos);
        }

        default public Attachable setPos(Position newpos) {
            this.pos_$eq(newpos);
            return this;
        }

        public /* synthetic */ StdAttachments scala$reflect$internal$StdAttachments$Attachable$$$outer();

        public static void $init$(Attachable $this) {
            $this.rawatt_$eq(((Positions)((Object)$this.scala$reflect$internal$StdAttachments$Attachable$$$outer())).NoPosition());
        }
    }

    public class ChangeOwnerAttachment
    implements Product,
    Serializable {
        private final Symbols.Symbol originalOwner;
        public final /* synthetic */ SymbolTable $outer;

        public Symbols.Symbol originalOwner() {
            return this.originalOwner;
        }

        public ChangeOwnerAttachment copy(Symbols.Symbol originalOwner) {
            return new ChangeOwnerAttachment(this.scala$reflect$internal$StdAttachments$ChangeOwnerAttachment$$$outer(), originalOwner);
        }

        public Symbols.Symbol copy$default$1() {
            return this.originalOwner();
        }

        @Override
        public String productPrefix() {
            return "ChangeOwnerAttachment";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.originalOwner();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof ChangeOwnerAttachment;
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
                    boolean bl = x$1 instanceof ChangeOwnerAttachment && ((ChangeOwnerAttachment)x$1).scala$reflect$internal$StdAttachments$ChangeOwnerAttachment$$$outer() == this.scala$reflect$internal$StdAttachments$ChangeOwnerAttachment$$$outer();
                    if (!bl) break block3;
                    ChangeOwnerAttachment changeOwnerAttachment = (ChangeOwnerAttachment)x$1;
                    Symbols.Symbol symbol = this.originalOwner();
                    Symbols.Symbol symbol2 = changeOwnerAttachment.originalOwner();
                    if (!(!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null) && changeOwnerAttachment.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$ChangeOwnerAttachment$$$outer() {
            return this.$outer;
        }

        public ChangeOwnerAttachment(SymbolTable $outer, Symbols.Symbol originalOwner) {
            this.originalOwner = originalOwner;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }

    public class CompoundTypeTreeOriginalAttachment
    implements Product,
    Serializable {
        private final List<Trees.Tree> parents;
        private final List<Trees.Tree> stats;
        public final /* synthetic */ SymbolTable $outer;

        public List<Trees.Tree> parents() {
            return this.parents;
        }

        public List<Trees.Tree> stats() {
            return this.stats;
        }

        public CompoundTypeTreeOriginalAttachment copy(List<Trees.Tree> parents, List<Trees.Tree> stats) {
            return new CompoundTypeTreeOriginalAttachment(this.scala$reflect$internal$StdAttachments$CompoundTypeTreeOriginalAttachment$$$outer(), parents, stats);
        }

        public List<Trees.Tree> copy$default$1() {
            return this.parents();
        }

        public List<Trees.Tree> copy$default$2() {
            return this.stats();
        }

        @Override
        public String productPrefix() {
            return "CompoundTypeTreeOriginalAttachment";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.parents();
                }
                case 1: {
                    return this.stats();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof CompoundTypeTreeOriginalAttachment;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof CompoundTypeTreeOriginalAttachment)) return false;
            if (((CompoundTypeTreeOriginalAttachment)x$1).scala$reflect$internal$StdAttachments$CompoundTypeTreeOriginalAttachment$$$outer() != this.scala$reflect$internal$StdAttachments$CompoundTypeTreeOriginalAttachment$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            CompoundTypeTreeOriginalAttachment compoundTypeTreeOriginalAttachment = (CompoundTypeTreeOriginalAttachment)x$1;
            List<Trees.Tree> list = this.parents();
            List<Trees.Tree> list2 = compoundTypeTreeOriginalAttachment.parents();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            List<Trees.Tree> list3 = this.stats();
            List<Trees.Tree> list4 = compoundTypeTreeOriginalAttachment.stats();
            if (list3 == null) {
                if (list4 != null) {
                    return false;
                }
            } else if (!((Object)list3).equals(list4)) return false;
            if (!compoundTypeTreeOriginalAttachment.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$CompoundTypeTreeOriginalAttachment$$$outer() {
            return this.$outer;
        }

        public CompoundTypeTreeOriginalAttachment(SymbolTable $outer, List<Trees.Tree> parents, List<Trees.Tree> stats) {
            this.parents = parents;
            this.stats = stats;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }

    public interface ImportableAttachment {
        public ImportableAttachment importAttachment(Internals.Importer var1);
    }

    public static abstract class InlineAnnotatedAttachment {
        public final /* synthetic */ SymbolTable $outer;

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$InlineAnnotatedAttachment$$$outer() {
            return this.$outer;
        }

        public InlineAnnotatedAttachment(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public class JustMethodReference
    implements PlainAttachment,
    Product,
    Serializable {
        private final Symbols.Symbol lambdaTarget;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public PlainAttachment importAttachment(Internals.Importer importer) {
            return ((PlainAttachment)this).importAttachment(importer);
        }

        public Symbols.Symbol lambdaTarget() {
            return this.lambdaTarget;
        }

        public JustMethodReference copy(Symbols.Symbol lambdaTarget) {
            return new JustMethodReference(this.scala$reflect$internal$StdAttachments$JustMethodReference$$$outer(), lambdaTarget);
        }

        public Symbols.Symbol copy$default$1() {
            return this.lambdaTarget();
        }

        @Override
        public String productPrefix() {
            return "JustMethodReference";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.lambdaTarget();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof JustMethodReference;
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
                    boolean bl = x$1 instanceof JustMethodReference && ((JustMethodReference)x$1).scala$reflect$internal$StdAttachments$JustMethodReference$$$outer() == this.scala$reflect$internal$StdAttachments$JustMethodReference$$$outer();
                    if (!bl) break block3;
                    JustMethodReference justMethodReference = (JustMethodReference)x$1;
                    Symbols.Symbol symbol = this.lambdaTarget();
                    Symbols.Symbol symbol2 = justMethodReference.lambdaTarget();
                    if (!(!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null) && justMethodReference.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$JustMethodReference$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ StdAttachments scala$reflect$internal$StdAttachments$PlainAttachment$$$outer() {
            return this.scala$reflect$internal$StdAttachments$JustMethodReference$$$outer();
        }

        public JustMethodReference(SymbolTable $outer, Symbols.Symbol lambdaTarget) {
            this.lambdaTarget = lambdaTarget;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            PlainAttachment.$init$(this);
            Product.$init$(this);
        }
    }

    public interface PlainAttachment
    extends ImportableAttachment {
        @Override
        default public PlainAttachment importAttachment(Internals.Importer importer) {
            return this;
        }

        public /* synthetic */ StdAttachments scala$reflect$internal$StdAttachments$PlainAttachment$$$outer();

        public static void $init$(PlainAttachment $this) {
        }
    }

    public class QualTypeSymAttachment {
        private final Symbols.Symbol sym;
        public final /* synthetic */ SymbolTable $outer;

        public Symbols.Symbol sym() {
            return this.sym;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$QualTypeSymAttachment$$$outer() {
            return this.$outer;
        }

        public QualTypeSymAttachment(SymbolTable $outer, Symbols.Symbol sym) {
            this.sym = sym;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public class SAMFunction
    implements PlainAttachment,
    Product,
    Serializable {
        private final Types.Type samTp;
        private final Symbols.Symbol sam;
        private final Symbols.Symbol synthCls;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public PlainAttachment importAttachment(Internals.Importer importer) {
            return ((PlainAttachment)this).importAttachment(importer);
        }

        public Types.Type samTp() {
            return this.samTp;
        }

        public Symbols.Symbol sam() {
            return this.sam;
        }

        public Symbols.Symbol synthCls() {
            return this.synthCls;
        }

        public SAMFunction copy(Types.Type samTp, Symbols.Symbol sam, Symbols.Symbol synthCls) {
            return new SAMFunction(this.scala$reflect$internal$StdAttachments$SAMFunction$$$outer(), samTp, sam, synthCls);
        }

        public Types.Type copy$default$1() {
            return this.samTp();
        }

        public Symbols.Symbol copy$default$2() {
            return this.sam();
        }

        public Symbols.Symbol copy$default$3() {
            return this.synthCls();
        }

        @Override
        public String productPrefix() {
            return "SAMFunction";
        }

        @Override
        public int productArity() {
            return 3;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.samTp();
                }
                case 1: {
                    return this.sam();
                }
                case 2: {
                    return this.synthCls();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof SAMFunction;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof SAMFunction)) return false;
            if (((SAMFunction)x$1).scala$reflect$internal$StdAttachments$SAMFunction$$$outer() != this.scala$reflect$internal$StdAttachments$SAMFunction$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            SAMFunction sAMFunction = (SAMFunction)x$1;
            Types.Type type = this.samTp();
            Types.Type type2 = sAMFunction.samTp();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            Symbols.Symbol symbol = this.sam();
            Symbols.Symbol symbol2 = sAMFunction.sam();
            if (symbol == null) {
                if (symbol2 != null) {
                    return false;
                }
            } else if (!symbol.equals(symbol2)) return false;
            Symbols.Symbol symbol3 = this.synthCls();
            Symbols.Symbol symbol4 = sAMFunction.synthCls();
            if (symbol3 == null) {
                if (symbol4 != null) {
                    return false;
                }
            } else if (!symbol3.equals(symbol4)) return false;
            if (!sAMFunction.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$SAMFunction$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ StdAttachments scala$reflect$internal$StdAttachments$PlainAttachment$$$outer() {
            return this.scala$reflect$internal$StdAttachments$SAMFunction$$$outer();
        }

        public SAMFunction(SymbolTable $outer, Types.Type samTp, Symbols.Symbol sam, Symbols.Symbol synthCls) {
            this.samTp = samTp;
            this.sam = sam;
            this.synthCls = synthCls;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            PlainAttachment.$init$(this);
            Product.$init$(this);
        }
    }

    public class SubpatternsAttachment
    implements Product,
    Serializable {
        private final List<Trees.Tree> patterns;
        public final /* synthetic */ SymbolTable $outer;

        public List<Trees.Tree> patterns() {
            return this.patterns;
        }

        public SubpatternsAttachment copy(List<Trees.Tree> patterns) {
            return new SubpatternsAttachment(this.scala$reflect$internal$StdAttachments$SubpatternsAttachment$$$outer(), patterns);
        }

        public List<Trees.Tree> copy$default$1() {
            return this.patterns();
        }

        @Override
        public String productPrefix() {
            return "SubpatternsAttachment";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.patterns();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof SubpatternsAttachment;
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
                    boolean bl = x$1 instanceof SubpatternsAttachment && ((SubpatternsAttachment)x$1).scala$reflect$internal$StdAttachments$SubpatternsAttachment$$$outer() == this.scala$reflect$internal$StdAttachments$SubpatternsAttachment$$$outer();
                    if (!bl) break block3;
                    SubpatternsAttachment subpatternsAttachment = (SubpatternsAttachment)x$1;
                    List<Trees.Tree> list = this.patterns();
                    List<Trees.Tree> list2 = subpatternsAttachment.patterns();
                    if (!(!(list != null ? !((Object)list).equals(list2) : list2 != null) && subpatternsAttachment.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$SubpatternsAttachment$$$outer() {
            return this.$outer;
        }

        public SubpatternsAttachment(SymbolTable $outer, List<Trees.Tree> patterns) {
            this.patterns = patterns;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }

    public class TypeParamVarargsAttachment
    implements Product,
    Serializable {
        private final Types.Type typeParamRef;
        public final /* synthetic */ SymbolTable $outer;

        public Types.Type typeParamRef() {
            return this.typeParamRef;
        }

        public TypeParamVarargsAttachment copy(Types.Type typeParamRef) {
            return new TypeParamVarargsAttachment(this.scala$reflect$internal$StdAttachments$TypeParamVarargsAttachment$$$outer(), typeParamRef);
        }

        public Types.Type copy$default$1() {
            return this.typeParamRef();
        }

        @Override
        public String productPrefix() {
            return "TypeParamVarargsAttachment";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.typeParamRef();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof TypeParamVarargsAttachment;
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
                    boolean bl = x$1 instanceof TypeParamVarargsAttachment && ((TypeParamVarargsAttachment)x$1).scala$reflect$internal$StdAttachments$TypeParamVarargsAttachment$$$outer() == this.scala$reflect$internal$StdAttachments$TypeParamVarargsAttachment$$$outer();
                    if (!bl) break block3;
                    TypeParamVarargsAttachment typeParamVarargsAttachment = (TypeParamVarargsAttachment)x$1;
                    Types.Type type = this.typeParamRef();
                    Types.Type type2 = typeParamVarargsAttachment.typeParamRef();
                    if (!(!(type != null ? !type.equals(type2) : type2 != null) && typeParamVarargsAttachment.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$StdAttachments$TypeParamVarargsAttachment$$$outer() {
            return this.$outer;
        }

        public TypeParamVarargsAttachment(SymbolTable $outer, Types.Type typeParamRef) {
            this.typeParamRef = typeParamRef;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }
}

