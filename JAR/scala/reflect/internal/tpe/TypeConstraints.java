/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.tpe;

import java.lang.invoke.LambdaMetafactory;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.Product;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.GenSeq;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.generic.Clearable;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.BitSet;
import scala.collection.mutable.BitSet$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Definitions$DefinitionsClass$NothingClass$;
import scala.reflect.internal.Depth$;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoType$;
import scala.reflect.internal.Variance;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.tpe.GlbLubs;
import scala.reflect.internal.tpe.TypeConstraints$TypeConstraint$;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.package$;
import scala.runtime.BooleanRef;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r\u0005eAC-[!\u0003\r\t\u0001\u00182\u0002B!)q\r\u0001C\u0001S\"AQ\u000e\u0001EC\u0002\u0013%a\u000e\u0003\u0004\u00048\u0001!\tA\u001c\u0004\u0005c\u0002\u0001!\u000fC\u0003|\t\u0011\u0005A0\u0002\u0003~\t\u0001q\b\"\u0003B\u0000\t\u0001\u0007I\u0011AB\u0001\u0011%\u00199\u0001\u0002a\u0001\n\u0003\u0019I\u0001\u0003\u0005\u0004\u000e\u0011\u0001\u000b\u0015BB\u0002\u0011\u001d\u0019y\u0001\u0002C\u0001\u0007#A\u0001ba\u0006\u0005\t\u0003q6\u0011\u0004\u0005\u0007\u0007;!A\u0011A5\t\u000f\r}A\u0001\"\u0001\u0004\"!Q1\u0011\b\u0001\t\u0006\u0004%I!!1\t\u0015\rm\u0002\u0001#b\u0001\n\u0013\t\tM\u0002\u0004\u0002Z\u0001\u0001\u0011\u0011\r\u0005\u000b\u0003G\u0002\"\u0011!Q\u0001\n\u0005\u0015\u0004BCA7!\t\u0005\t\u0015!\u0003\u0002f!Q\u0011q\u000e\t\u0003\u0002\u0003\u0006I!a\u001a\t\u0015\u0005E\u0004C!A!\u0002\u0013\t9\u0007\u0003\u0006\u0002tA\u0011\t\u0011)A\u0005\u0003kBaa\u001f\t\u0005\u0002\u0005m\u0004BB>\u0011\t\u0003\tI\t\u0003\u0004|!\u0011\u0005\u0011q\u0012\u0005\u0007wB!\t!a'\t\u0013\u0005u\u0005\u00031A\u0005\n\u0005}\u0005\"CAV!\u0001\u0007I\u0011BAW\u0011!\t\u0019\f\u0005Q!\n\u0005\u0005\u0006\"CA[!\u0001\u0007I\u0011BAP\u0011%\t9\f\u0005a\u0001\n\u0013\tI\f\u0003\u0005\u0002>B\u0001\u000b\u0015BAQ\u0011%\ty\f\u0005a\u0001\n\u0013\t\t\rC\u0005\u0002DB\u0001\r\u0011\"\u0003\u0002F\"A\u0011\u0011\u001a\t!B\u0013\t9\u0007C\u0005\u0002LB\u0001\r\u0011\"\u0003\u0002B\"I\u0011Q\u001a\tA\u0002\u0013%\u0011q\u001a\u0005\t\u0003'\u0004\u0002\u0015)\u0003\u0002h!I\u0011Q\u001b\tA\u0002\u0013%\u0011q\u001b\u0005\n\u00033\u0004\u0002\u0019!C\u0005\u00037D\u0001\"a8\u0011A\u0003&\u0011Q\u000f\u0005\b\u0003C\u0004B\u0011AAr\u0011\u001d\t)\u000f\u0005C\u0001\u0003GDq!a:\u0011\t\u0003\t9\u000eC\u0004\u0002jB!\t!a;\t\u0013\u0005U\b#%A\u0005\u0002\u0005]\bb\u0002B\u0007!\u0011\u0005!q\u0002\u0005\b\u0005'\u0001B\u0011\u0001B\u000b\u0011%\u0011Y\u0002EI\u0001\n\u0003\t9\u0010C\u0004\u0003\u001eA!\t!a6\t\u000f\t}\u0001\u0003\"\u0001\u0003\"!I!Q\u0005\tA\u0002\u0013\u0005\u0011\u0011\u0019\u0005\n\u0005O\u0001\u0002\u0019!C\u0001\u0005SA\u0001B!\f\u0011A\u0003&\u0011q\r\u0005\b\u0005_\u0001B\u0011AAl\u0011\u001d\u0011\t\u0004\u0005C\u0001\u0005gAqA!\u000e\u0011\t\u0003\u00129dB\u0005\u0004>\u0001\t\t\u0011#\u0001\u0004@\u0019I\u0011\u0011\f\u0001\u0002\u0002#\u00051\u0011\t\u0005\u0007wj\"\taa\u0011\t\u0013\r\u0015#(%A\u0005\u0002\u0005]\bbBB$\u0001\u0011\u00051\u0011J\u0004\t\u0003#Q\u0006\u0012\u0001/\u0002\u0014\u00199\u0011L\u0017E\u00019\u0006U\u0001BB>@\t\u0003\t9B\u0002\u0004\u0002\u001a}\u0012\u00151\u0004\u0005\u000b\u0003W\t%Q3A\u0005\u0002\u00055\u0002BCA(\u0003\nE\t\u0015!\u0003\u00020!Q\u0011\u0011K!\u0003\u0016\u0004%\t!a\u0015\t\u0015\t%\u0013I!E!\u0002\u0013\t)\u0006\u0003\u0004|\u0003\u0012\u0005!1\n\u0005\n\u0005+\n\u0015\u0011!C\u0001\u0005/B\u0011B!\u001bB#\u0003%\tAa\u001b\t\u0013\tU\u0014)%A\u0005\u0002\t]\u0004\"\u0003BA\u0003\u0006\u0005I\u0011\tBB\u0011%\u0011))QA\u0001\n\u0003\u00119\tC\u0005\u0003\u0010\u0006\u000b\t\u0011\"\u0001\u0003\u0012\"I!1T!\u0002\u0002\u0013\u0005#Q\u0014\u0005\n\u0005O\u000b\u0015\u0011!C\u0001\u0005SC\u0011B!,B\u0003\u0003%\tEa,\t\u0013\tU\u0012)!A\u0005B\t]\u0002\"\u0003BY\u0003\u0006\u0005I\u0011\tBZ\u000f%\u00119lPA\u0001\u0012\u0003\u0011ILB\u0005\u0002\u001a}\n\t\u0011#\u0001\u0003<\"11p\u0015C\u0001\u0005{C\u0011B!\u000eT\u0003\u0003%)Ea\u000e\t\u0013\t}6+!A\u0005\u0002\n\u0005\u0007\"\u0003Bj'\u0006\u0005I\u0011\u0011Bk\u0011%\u0011\u0019pUA\u0001\n\u0013\u0011)PA\bUsB,7i\u001c8tiJ\f\u0017N\u001c;t\u0015\tYF,A\u0002ua\u0016T!!\u00180\u0002\u0011%tG/\u001a:oC2T!a\u00181\u0002\u000fI,g\r\\3di*\t\u0011-A\u0003tG\u0006d\u0017m\u0005\u0002\u0001GB\u0011A-Z\u0007\u0002A&\u0011a\r\u0019\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%\u0007\u0001!\u0012A\u001b\t\u0003I.L!\u0001\u001c1\u0003\tUs\u0017\u000e^\u0001\t?VtGm\u001c'pOV\tq\u000e\u0005\u0002q\t5\t\u0001AA\u0004V]\u0012|Gj\\4\u0014\u0007\u0011\u00197\u000f\u0005\u0002us6\tQO\u0003\u0002wo\u00069q-\u001a8fe&\u001c'B\u0001=a\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0003uV\u0014\u0011b\u00117fCJ\f'\r\\3\u0002\rqJg.\u001b;?)\u0005y'!C+oI>\u0004\u0016-\u001b:t!\u0015y\u0018QAA\u0006\u001d\r!\u0017\u0011A\u0005\u0004\u0003\u0007\u0001\u0017a\u00029bG.\fw-Z\u0005\u0005\u0003\u000f\tIA\u0001\u0003MSN$(bAA\u0002AB9\u0011QB!\u0003~\u0006udbAA\b}5\t!,A\bUsB,7i\u001c8tiJ\f\u0017N\u001c;t!\r\tyaP\n\u0003\u007f\r$\"!a\u0005\u0003\u0011UsGm\u001c)bSJ,b!!\b\u00024\u0005]3CB!d\u0003?\t)\u0003E\u0002e\u0003CI1!a\ta\u0005\u001d\u0001&o\u001c3vGR\u00042\u0001ZA\u0014\u0013\r\tI\u0003\u0019\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0003iZ,\"!a\f\u0011\t\u0005E\u00121\u0007\u0007\u0001\t\u001d\t)$\u0011b\u0001\u0003o\u0011q\u0001V=qKZ\u000b'/\u0005\u0003\u0002:\u0005}\u0002c\u00013\u0002<%\u0019\u0011Q\b1\u0003\u000f9{G\u000f[5oOB!\u0011\u0011IA%!\u0011\t\u0019%!\u0012\u000e\u0003qK1!a\u0012]\u0005-\u0019\u00160\u001c2pYR\u000b'\r\\3\n\t\u0005U\u00121J\u0005\u0004\u0003\u001bb&!\u0002+za\u0016\u001c\u0018a\u0001;wA\u0005YAoQ8ogR\u0014\u0018-\u001b8u+\t\t)\u0006\u0005\u0003\u00022\u0005]CaBA-\u0003\n\u0007\u00111\f\u0002\u000f)f\u0004XmQ8ogR\u0014\u0018-\u001b8u#\u0011\tI$!\u0018\u0011\u0007\u0005}\u0003\u0003E\u0002\u0002\u0010\u0001\u0019\"\u0001E2\u0002\u00071|\u0007\u0007E\u0003\u0000\u0003\u000b\t9\u0007E\u0002q\u0003SJA!a\u001b\u0002L\t!A+\u001f9f\u0003\rA\u0017\u000eM\u0001\u0007]VlGn\u001c\u0019\u0002\r9,X\u000e[51\u00039\tgo\\5e/&$WM\\5oOB\u00022\u0001ZA<\u0013\r\tI\b\u0019\u0002\b\u0005>|G.Z1o)1\ti(a \u0002\u0002\u0006\r\u0015QQAD!\t\u0001\b\u0003C\u0004\u0002dY\u0001\r!!\u001a\t\u000f\u00055d\u00031\u0001\u0002f!9\u0011q\u000e\fA\u0002\u0005\u001d\u0004bBA9-\u0001\u0007\u0011q\r\u0005\n\u0003g2\u0002\u0013!a\u0001\u0003k\"b!! \u0002\f\u00065\u0005bBA2/\u0001\u0007\u0011Q\r\u0005\b\u0003[:\u0002\u0019AA3)\u0011\ti(!%\t\u000f\u0005M\u0005\u00041\u0001\u0002\u0016\u00061!m\\;oIN\u00042\u0001]AL\u0013\u0011\tI*a\u0013\u0003\u0015QK\b/\u001a\"pk:$7\u000f\u0006\u0002\u0002~\u0005AAn\u001c2pk:$7/\u0006\u0002\u0002\"B1\u00111UAU\u0003Oj!!!*\u000b\u0007\u0005\u001dv/A\u0005j[6,H/\u00192mK&!\u0011qAAS\u00031awNY8v]\u0012\u001cx\fJ3r)\rQ\u0017q\u0016\u0005\n\u0003c[\u0012\u0011!a\u0001\u0003C\u000b1\u0001\u001f\u00132\u0003%awNY8v]\u0012\u001c\b%\u0001\u0005iS\n|WO\u001c3t\u00031A\u0017NY8v]\u0012\u001cx\fJ3r)\rQ\u00171\u0018\u0005\n\u0003cs\u0012\u0011!a\u0001\u0003C\u000b\u0011\u0002[5c_VtGm\u001d\u0011\u0002\u000b9,X\u000e\\8\u0016\u0005\u0005\u001d\u0014!\u00038v[2|w\fJ3r)\rQ\u0017q\u0019\u0005\n\u0003c\u000b\u0013\u0011!a\u0001\u0003O\naA\\;nY>\u0004\u0013!\u00028v[\"L\u0017!\u00038v[\"Lw\fJ3r)\rQ\u0017\u0011\u001b\u0005\n\u0003c#\u0013\u0011!a\u0001\u0003O\naA\\;nQ&\u0004\u0013!D1w_&$w+\u001b3f]&tw-\u0006\u0002\u0002v\u0005\t\u0012M^8jI^KG-\u001a8j]\u001e|F%Z9\u0015\u0007)\fi\u000eC\u0005\u00022\u001e\n\t\u00111\u0001\u0002v\u0005q\u0011M^8jI^KG-\u001a8j]\u001e\u0004\u0013\u0001\u00037p\u0005>,h\u000eZ:\u0016\u0005\u0005\u0015\u0014\u0001\u00035j\u0005>,h\u000eZ:\u0002\u0015\u00054x.\u001b3XS\u0012,g.\u0001\u0006bI\u0012duNQ8v]\u0012$RA[Aw\u0003cDq!a<-\u0001\u0004\t9'\u0001\u0002ua\"I\u00111\u001f\u0017\u0011\u0002\u0003\u0007\u0011QO\u0001\u000fSNtU/\\3sS\u000e\u0014u.\u001e8e\u0003Q\tG\r\u001a'p\u0005>,h\u000e\u001a\u0013eK\u001a\fW\u000f\u001c;%eU\u0011\u0011\u0011 \u0016\u0005\u0003k\nYp\u000b\u0002\u0002~B!\u0011q B\u0005\u001b\t\u0011\tA\u0003\u0003\u0003\u0004\t\u0015\u0011!C;oG\",7m[3e\u0015\r\u00119\u0001Y\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002\u0002B\u0006\u0005\u0003\u0011\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u00035\u0019\u0007.Z2l/&$WM\\5oOR\u0019!N!\u0005\t\u000f\u0005=h\u00061\u0001\u0002h\u0005Q\u0011\r\u001a3IS\n{WO\u001c3\u0015\u000b)\u00149B!\u0007\t\u000f\u0005=x\u00061\u0001\u0002h!I\u00111_\u0018\u0011\u0002\u0003\u0007\u0011QO\u0001\u0015C\u0012$\u0007*\u001b\"pk:$G\u0005Z3gCVdG\u000f\n\u001a\u0002!%t7\u000f^,ji\"LgNQ8v]\u0012\u001c\u0018AD5t/&$\b.\u001b8C_VtGm\u001d\u000b\u0005\u0003k\u0012\u0019\u0003C\u0004\u0002pJ\u0002\r!a\u001a\u0002\t%t7\u000f^\u0001\tS:\u001cHo\u0018\u0013fcR\u0019!Na\u000b\t\u0013\u0005EF'!AA\u0002\u0005\u001d\u0014!B5ogR\u0004\u0013!C5ogR4\u0016\r\\5e\u00035\u0019Gn\u001c8f\u0013:$XM\u001d8bYV\u0011\u0011QP\u0001\ti>\u001cFO]5oOR\u0011!\u0011\b\t\u0005\u0005w\u0011)%\u0004\u0002\u0003>)!!q\bB!\u0003\u0011a\u0017M\\4\u000b\u0005\t\r\u0013\u0001\u00026bm\u0006LAAa\u0012\u0003>\t11\u000b\u001e:j]\u001e\fA\u0002^\"p]N$(/Y5oi\u0002\"bA!\u0014\u0003R\tM\u0003c\u0002B(\u0003\u0006=\u0012QK\u0007\u0002\u007f!9\u00111\u0006$A\u0002\u0005=\u0002bBA)\r\u0002\u0007\u0011QK\u0001\u0005G>\u0004\u00180\u0006\u0004\u0003Z\t}#1\r\u000b\u0007\u00057\u0012)Ga\u001a\u0011\u000f\t=\u0013I!\u0018\u0003bA!\u0011\u0011\u0007B0\t\u001d\t)d\u0012b\u0001\u0003o\u0001B!!\r\u0003d\u00119\u0011\u0011L$C\u0002\u0005m\u0003\"CA\u0016\u000fB\u0005\t\u0019\u0001B/\u0011%\t\tf\u0012I\u0001\u0002\u0004\u0011\t'\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\r\t5$\u0011\u000fB:+\t\u0011yG\u000b\u0003\u00020\u0005mHaBA\u001b\u0011\n\u0007\u0011q\u0007\u0003\b\u00033B%\u0019AA.\u00039\u0019w\u000e]=%I\u00164\u0017-\u001e7uII*bA!\u001f\u0003~\t}TC\u0001B>U\u0011\t)&a?\u0005\u000f\u0005U\u0012J1\u0001\u00028\u00119\u0011\u0011L%C\u0002\u0005m\u0013!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070\u0006\u0002\u0003:\u0005a\u0001O]8ek\u000e$\u0018I]5usV\u0011!\u0011\u0012\t\u0004I\n-\u0015b\u0001BGA\n\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR!!1\u0013BM!\r!'QS\u0005\u0004\u0005/\u0003'aA!os\"I\u0011\u0011\u0017'\u0002\u0002\u0003\u0007!\u0011R\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u0011!q\u0014\t\u0007\u0005C\u0013\u0019Ka%\u000e\u0003]L1A!*x\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\u0005U$1\u0016\u0005\n\u0003cs\u0015\u0011!a\u0001\u0005'\u000b\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0003\u0005\u0013\u000ba!Z9vC2\u001cH\u0003BA;\u0005kC\u0011\"!-R\u0003\u0003\u0005\rAa%\u0002\u0011UsGm\u001c)bSJ\u00042Aa\u0014T'\u0011\u00196-!\n\u0015\u0005\te\u0016!B1qa2LXC\u0002Bb\u0005\u0013\u0014i\r\u0006\u0004\u0003F\n='\u0011\u001b\t\b\u0005\u001f\n%q\u0019Bf!\u0011\t\tD!3\u0005\u000f\u0005UbK1\u0001\u00028A!\u0011\u0011\u0007Bg\t\u001d\tIF\u0016b\u0001\u00037Bq!a\u000bW\u0001\u0004\u00119\rC\u0004\u0002RY\u0003\rAa3\u0002\u000fUt\u0017\r\u001d9msV1!q\u001bBt\u0005W$BA!7\u0003nB)AMa7\u0003`&\u0019!Q\u001c1\u0003\r=\u0003H/[8o!\u001d!'\u0011\u001dBs\u0005SL1Aa9a\u0005\u0019!V\u000f\u001d7feA!\u0011\u0011\u0007Bt\t\u001d\t)d\u0016b\u0001\u0003o\u0001B!!\r\u0003l\u00129\u0011\u0011L,C\u0002\u0005m\u0003\"\u0003Bx/\u0006\u0005\t\u0019\u0001By\u0003\rAH\u0005\r\t\b\u0005\u001f\n%Q\u001dBu\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\t]\b\u0003\u0002B\u001e\u0005sLAAa?\u0003>\t1qJ\u00196fGR\u00042\u0001]A%\u0003\rawnZ\u000b\u0003\u0007\u0007\u00012a!\u0002\u0007\u001b\u0005!\u0011a\u00027pO~#S-\u001d\u000b\u0004U\u000e-\u0001\"CAY\u0011\u0005\u0005\t\u0019AB\u0002\u0003\u0011awn\u001a\u0011\u0002\rUtGm\u001c+p)\rQ71\u0003\u0005\b\u0007+Q\u0001\u0019AB\u0002\u0003\u0015a\u0017.\\5u\u0003\u0019\u0011XmY8sIR\u0019!na\u0007\t\u000f\u0005-2\u00021\u0001\u0003~\u0006)1\r\\3be\u0006!QO\u001c3p+\u0011\u0019\u0019ca\n\u0015\t\r\u00152Q\u0006\t\u0005\u0003c\u00199\u0003B\u0004\u0004*5\u0011\raa\u000b\u0003\u0003Q\u000bB!!\u000f\u0003\u0014\"A1qF\u0007\u0005\u0002\u0004\u0019\t$A\u0003cY>\u001c7\u000eE\u0003e\u0007g\u0019)#C\u0002\u00046\u0001\u0014\u0001\u0002\u00102z]\u0006lWMP\u0001\bk:$w\u000eT8h\u00039qW/\\3sS\u000eduNQ8v]\u0012\faB\\;nKJL7\rS5C_VtG-\u0001\bUsB,7i\u001c8tiJ\f\u0017N\u001c;\u0011\u0005AT4C\u0001\u001ed)\t\u0019y$A\u000e%Y\u0016\u001c8/\u001b8ji\u0012:'/Z1uKJ$C-\u001a4bk2$H%N\u0001\u0006g>dg/\u001a\u000b\r\u0003k\u001aYe!\u0015\u0004b\rM4q\u000f\u0005\b\u0007\u001bj\u0004\u0019AB(\u0003\u0015!h/\u0019:t!\u0015y\u0018Q\u0001B\u007f\u0011\u001d\u0019\u0019&\u0010a\u0001\u0007+\nq\u0001\u001e9be\u0006l7\u000fE\u0003\u0000\u0003\u000b\u00199\u0006E\u0002q\u00073JAaa\u0017\u0004^\t11+_7c_2L1aa\u0018]\u0005\u001d\u0019\u00160\u001c2pYNDqaa\u0019>\u0001\u0004\u0019)'A\u0006hKR4\u0016M]5b]\u000e,\u0007CBB4\u0007[\u001a9F\u0004\u0003\u0002D\r%\u0014bAB69\u0006Aa+\u0019:jC:\u001cW-\u0003\u0003\u0004p\rE$!C#yiJ\f7\r^8s\u0015\r\u0019Y\u0007\u0018\u0005\b\u0007kj\u0004\u0019AA;\u0003\u0015)\b\u000f]3s\u0011\u001d\u0019I(\u0010a\u0001\u0007w\nQ\u0001Z3qi\"\u0004B!a\u0011\u0004~%\u00191q\u0010/\u0003\u000b\u0011+\u0007\u000f\u001e5")
public interface TypeConstraints {
    public TypeConstraints$TypeConstraint$ TypeConstraint();

    public static /* synthetic */ UndoLog scala$reflect$internal$tpe$TypeConstraints$$_undoLog$(TypeConstraints $this) {
        return $this.scala$reflect$internal$tpe$TypeConstraints$$_undoLog();
    }

    default public UndoLog scala$reflect$internal$tpe$TypeConstraints$$_undoLog() {
        return new UndoLog((SymbolTable)this);
    }

    public static /* synthetic */ UndoLog undoLog$(TypeConstraints $this) {
        return $this.undoLog();
    }

    default public UndoLog undoLog() {
        return this.scala$reflect$internal$tpe$TypeConstraints$$_undoLog();
    }

    public static /* synthetic */ Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericLoBound$(TypeConstraints $this) {
        return $this.scala$reflect$internal$tpe$TypeConstraints$$numericLoBound();
    }

    default public Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericLoBound() {
        return ((Definitions)((Object)this)).definitions().IntTpe();
    }

    public static /* synthetic */ Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericHiBound$(TypeConstraints $this) {
        return $this.scala$reflect$internal$tpe$TypeConstraints$$numericHiBound();
    }

    default public Types.Type scala$reflect$internal$tpe$TypeConstraints$$numericHiBound() {
        return ((Types)this).intersectionType(new $colon$colon<Nothing$>((Nothing$)((Object)((Definitions)((Object)this)).definitions().ByteTpe()), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)((Definitions)((Object)this)).definitions().CharTpe()), Nil$.MODULE$)), ((Definitions)((Object)this)).definitions().ScalaPackageClass());
    }

    public static /* synthetic */ boolean solve$(TypeConstraints $this, List tvars, List tparams, Variance.Extractor getVariance, boolean upper, int depth) {
        return $this.solve(tvars, tparams, getVariance, upper, depth);
    }

    default public boolean solve(List<Types.TypeVar> tvars, List<Symbols.Symbol> tparams, Variance.Extractor<Symbols.Symbol> getVariance, boolean upper, int depth) {
        boolean bl;
        block9: {
            boolean bl2;
            SymbolTable symbolTable;
            block8: {
                symbolTable = (SymbolTable)this;
                if (tvars == null) {
                    throw null;
                }
                List list = tparams;
                LinearSeqLike corresponds_this = tvars;
                while (true) {
                    GenSeq corresponds_that;
                    if (corresponds_this.isEmpty()) {
                        bl2 = corresponds_that.isEmpty();
                        break block8;
                    }
                    if (!corresponds_that.nonEmpty()) break;
                    Symbols.Symbol symbol = (Symbols.Symbol)corresponds_that.head();
                    if (!TypeConstraints.$anonfun$solve$1((Types.TypeVar)corresponds_this.head(), symbol)) break;
                    corresponds_that = (GenSeq)corresponds_that.tail();
                    corresponds_this = (LinearSeqLike)corresponds_this.tail();
                }
                bl2 = false;
            }
            SymbolTable assert_this = symbolTable;
            if (!bl2) {
                throw assert_this.throwAssertionError(TypeConstraints.$anonfun$solve$2(tparams, tvars));
            }
            BitSet areContravariant = BitSet$.MODULE$.empty();
            Collections cfr_ignored_0 = (Collections)((Object)this);
            int foreachWithIndex_index = 0;
            List foreachWithIndex_ys = tparams;
            while (!foreachWithIndex_ys.isEmpty()) {
                Symbols.Symbol symbol = foreachWithIndex_ys.head();
                TypeConstraints.$anonfun$solve$4(getVariance, areContravariant, symbol, foreachWithIndex_index);
                foreachWithIndex_ys = (List)foreachWithIndex_ys.tail();
                ++foreachWithIndex_index;
            }
            Collections cfr_ignored_1 = (Collections)((Object)this);
            int foreachWithIndex_index2 = 0;
            List foreachWithIndex_ys2 = tvars;
            while (!foreachWithIndex_ys2.isEmpty()) {
                Types.TypeVar typeVar = foreachWithIndex_ys2.head();
                this.solveOne$1(typeVar, foreachWithIndex_index2, areContravariant, upper, tvars, tparams, depth);
                foreachWithIndex_ys2 = (List)foreachWithIndex_ys2.tail();
                ++foreachWithIndex_index2;
            }
            LinearSeqOptimized forall_these = tvars;
            while (!forall_these.isEmpty()) {
                Types.TypeVar typeVar = (Types.TypeVar)forall_these.head();
                if (!TypeConstraints.$anonfun$solve$15(this, typeVar)) {
                    bl = false;
                    break block9;
                }
                forall_these = (LinearSeqOptimized)forall_these.tail();
            }
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ boolean $anonfun$solve$1(Types.TypeVar tvar, Symbols.Symbol tparam) {
        return tvar.origin().typeSymbol() == tparam;
    }

    public static /* synthetic */ Tuple2 $anonfun$solve$2(List tparams$1, List tvars$1) {
        return new Tuple2(tparams$1, tvars$1.map((Function1<Types.TypeVar, Symbols.Symbol> & java.io.Serializable & Serializable)x$10 -> x$10.origin().typeSymbol(), List$.MODULE$.canBuildFrom()));
    }

    public static /* synthetic */ void $anonfun$solve$4(Variance.Extractor getVariance$1, BitSet areContravariant$1, Symbols.Symbol tparam, int ix) {
        if (Variance$.MODULE$.isContravariant$extension(getVariance$1.apply(tparam))) {
            areContravariant$1.$plus$eq(ix);
        }
    }

    public static /* synthetic */ void $anonfun$solve$5(TypeConstraints $this, Symbols.Symbol tparam$1, Types.Type bound$1, boolean up$1, BooleanRef cyclic$1, BitSet areContravariant$1, boolean upper$1, List tvars$1, List tparams$1, int depth$1, Types.TypeVar tvar2, int jx) {
        Symbols.Symbol tparam2;
        Symbols.Symbol symbol = tparam2 = tvar2.origin().typeSymbol();
        if ((symbol == null ? tparam$1 != null : !symbol.equals(tparam$1)) && (bound$1.contains(tparam2) || up$1 && tparam2.info().lowerBound().$eq$colon$eq(tparam$1.tpeHK()) || !up$1 && tparam2.info().upperBound().$eq$colon$eq(tparam$1.tpeHK()))) {
            if (tvar2.constr().inst() == null) {
                cyclic$1.elem = true;
            }
            $this.solveOne$1(tvar2, jx, areContravariant$1, upper$1, tvars$1, tparams$1, depth$1);
        }
    }

    public static /* synthetic */ void $anonfun$solve$7(TypeConstraints $this, Symbols.Symbol tparam$1, Types.TypeVar tvar$1, List tparams$1, List tvars$1, Symbols.Symbol tparam2) {
        block5: {
            block7: {
                Symbols.Symbol symbol;
                Symbols.Symbol symbol2;
                block6: {
                    Types.Type type = tparam2.info().lowerBound().dealias();
                    if (!(type instanceof Types.TypeRef)) break block5;
                    symbol2 = ((Types.TypeRef)type).sym();
                    symbol = tparam$1;
                    if (symbol != null) break block6;
                    if (symbol2 != null) {
                        return;
                    }
                    break block7;
                }
                if (!symbol.equals(symbol2)) break block5;
            }
            ((SymbolTable)$this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(44).append(tvar$1).append(" addHiBound ").append(tparam2).append(".tpeHK.instantiateTypeParams(").append(tparams$1).append(", ").append(tvars$1).append(")").toString());
            tvar$1.addHiBound(tparam2.tpeHK().instantiateTypeParams(tparams$1, tvars$1), tvar$1.addHiBound$default$2());
            return;
        }
    }

    public static /* synthetic */ void $anonfun$solve$10(TypeConstraints $this, Symbols.Symbol tparam$1, Types.TypeVar tvar$1, List tparams$1, List tvars$1, Symbols.Symbol tparam2) {
        block5: {
            block7: {
                Symbols.Symbol symbol;
                Symbols.Symbol symbol2;
                block6: {
                    Types.Type type = tparam2.info().upperBound().dealias();
                    if (!(type instanceof Types.TypeRef)) break block5;
                    symbol2 = ((Types.TypeRef)type).sym();
                    symbol = tparam$1;
                    if (symbol != null) break block6;
                    if (symbol2 != null) {
                        return;
                    }
                    break block7;
                }
                if (!symbol.equals(symbol2)) break block5;
            }
            ((SymbolTable)$this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(44).append(tvar$1).append(" addLoBound ").append(tparam2).append(".tpeHK.instantiateTypeParams(").append(tparams$1).append(", ").append(tvars$1).append(")").toString());
            tvar$1.addLoBound(tparam2.tpeHK().instantiateTypeParams(tparams$1, tvars$1), tvar$1.addLoBound$default$2());
            return;
        }
    }

    private void solveOne$1(Types.TypeVar tvar, int ix, BitSet areContravariant$1, boolean upper$1, List tvars$1, List tparams$1, int depth$1) {
        block16: {
            boolean isContravariant;
            Symbols.Symbol tparam;
            block15: {
                Types$NoType$ types$NoType$;
                Types.Type type;
                block14: {
                    tparam = tvar.origin().typeSymbol();
                    isContravariant = areContravariant$1.apply(BoxesRunTime.boxToInteger(ix));
                    type = tvar.constr().inst();
                    types$NoType$ = ((Types)this).NoType();
                    if (type != null) break block14;
                    if (types$NoType$ != null) {
                        return;
                    }
                    break block15;
                }
                if (!type.equals(types$NoType$)) break block16;
            }
            boolean up = isContravariant ? !upper$1 : upper$1;
            tvar.constr().inst_$eq(null);
            Types.Type bound = up ? tparam.info().upperBound() : tparam.info().lowerBound();
            BooleanRef cyclic = BooleanRef.create(bound.contains(tparam));
            Collections cfr_ignored_0 = (Collections)((Object)this);
            int foreachWithIndex_index = 0;
            List foreachWithIndex_ys = tvars$1;
            while (!foreachWithIndex_ys.isEmpty()) {
                Types.TypeVar typeVar = (Types.TypeVar)foreachWithIndex_ys.head();
                TypeConstraints.$anonfun$solve$5(this, tparam, bound, up, cyclic, areContravariant$1, upper$1, tvars$1, tparams$1, depth$1, typeVar, foreachWithIndex_index);
                foreachWithIndex_ys = (List)foreachWithIndex_ys.tail();
                ++foreachWithIndex_index;
            }
            if (!cyclic.elem) {
                if (up) {
                    Symbols.Symbol symbol = bound.typeSymbol();
                    Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().AnyClass();
                    if (symbol == null ? classSymbol != null : !symbol.equals(classSymbol)) {
                        ((SymbolTable)this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(38).append(tvar).append(" addHiBound ").append(bound).append(".instantiateTypeParams(").append(tparams$1).append(", ").append(tvars$1).append(")").toString());
                        tvar.addHiBound(bound.instantiateTypeParams(tparams$1, tvars$1), tvar.addHiBound$default$2());
                    }
                    if (tparams$1 == null) {
                        throw null;
                    }
                    List foreach_these = tparams$1;
                    while (!foreach_these.isEmpty()) {
                        Symbols.Symbol symbol2 = (Symbols.Symbol)foreach_these.head();
                        TypeConstraints.$anonfun$solve$7(this, tparam, tvar, tparams$1, tvars$1, symbol2);
                        foreach_these = (List)foreach_these.tail();
                    }
                } else {
                    Symbols.Symbol symbol = bound.typeSymbol();
                    Definitions$DefinitionsClass$NothingClass$ definitions$DefinitionsClass$NothingClass$ = ((Definitions)((Object)this)).definitions().NothingClass();
                    if (symbol == null ? definitions$DefinitionsClass$NothingClass$ != null : !symbol.equals(definitions$DefinitionsClass$NothingClass$)) {
                        Symbols.Symbol symbol3 = bound.typeSymbol();
                        if (symbol3 == null || !symbol3.equals(tparam)) {
                            ((SymbolTable)this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(38).append(tvar).append(" addLoBound ").append(bound).append(".instantiateTypeParams(").append(tparams$1).append(", ").append(tvars$1).append(")").toString());
                            tvar.addLoBound(bound.instantiateTypeParams(tparams$1, tvars$1), tvar.addLoBound$default$2());
                        }
                    }
                    if (tparams$1 == null) {
                        throw null;
                    }
                    List foreach_these = tparams$1;
                    while (!foreach_these.isEmpty()) {
                        Symbols.Symbol symbol4 = (Symbols.Symbol)foreach_these.head();
                        TypeConstraints.$anonfun$solve$10(this, tparam, tvar, tparams$1, tvars$1, symbol4);
                        foreach_these = (List)foreach_these.tail();
                    }
                }
            }
            tvar.constr().inst_$eq(((Types)this).NoType());
            Types.Type newInst = up ? (Depth$.MODULE$.isAnyDepth$extension(depth$1) ? ((GlbLubs)((Object)this)).glb(tvar.constr().hiBounds()) : ((GlbLubs)((Object)this)).glb(tvar.constr().hiBounds(), depth$1)) : (Depth$.MODULE$.isAnyDepth$extension(depth$1) ? ((GlbLubs)((Object)this)).lub(tvar.constr().loBounds()) : ((GlbLubs)((Object)this)).lub(tvar.constr().loBounds(), depth$1));
            ((SymbolTable)this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(9).append(tvar).append(" setInst ").append(newInst).toString());
            tvar.setInst(newInst);
        }
    }

    private void logBounds$1(Types.TypeVar tv) {
        ((SymbolTable)this).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> {
            String what = !tv.instValid() ? "is invalid" : new StringBuilder(28).append("does not conform to bounds: ").append(tv.constr()).toString();
            return new StringBuilder(22).append("Inferred type for ").append(tv.originString()).append(" (").append(tv.inst()).append(") ").append(what).toString();
        });
    }

    public static /* synthetic */ boolean $anonfun$solve$15(TypeConstraints $this, Types.TypeVar tv) {
        block3: {
            block2: {
                if (tv.instWithinBounds()) break block2;
                $this.logBounds$1(tv);
                if (!package$.MODULE$.andFalse(BoxedUnit.UNIT)) break block3;
            }
            return true;
        }
        return false;
    }

    public static void $init$(TypeConstraints $this) {
    }

    public static /* synthetic */ Object $anonfun$solve$1$adapted(Types.TypeVar tvar, Symbols.Symbol tparam) {
        return BoxesRunTime.boxToBoolean(TypeConstraints.$anonfun$solve$1(tvar, tparam));
    }

    public static /* synthetic */ Object $anonfun$solve$4$adapted(Variance.Extractor getVariance$1, BitSet areContravariant$1, Symbols.Symbol tparam, Object ix) {
        TypeConstraints.$anonfun$solve$4(getVariance$1, areContravariant$1, tparam, BoxesRunTime.unboxToInt(ix));
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$solve$13$adapted(TypeConstraints $this, BitSet areContravariant$1, boolean upper$1, List tvars$1, List tparams$1, int depth$1, Types.TypeVar tvar, Object ix) {
        $this.solveOne$1(tvar, BoxesRunTime.unboxToInt(ix), areContravariant$1, upper$1, tvars$1, tparams$1, depth$1);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$solve$15$adapted(TypeConstraints $this, Types.TypeVar tv) {
        return BoxesRunTime.boxToBoolean(TypeConstraints.$anonfun$solve$15($this, tv));
    }

    public static /* synthetic */ Object $anonfun$solve$5$adapted(TypeConstraints $this, Symbols.Symbol tparam$1, Types.Type bound$1, boolean up$1, BooleanRef cyclic$1, BitSet areContravariant$1, boolean upper$1, List tvars$1, List tparams$1, int depth$1, Types.TypeVar tvar2, Object jx) {
        TypeConstraints.$anonfun$solve$5($this, tparam$1, bound$1, up$1, cyclic$1, areContravariant$1, upper$1, tvars$1, tparams$1, depth$1, tvar2, BoxesRunTime.unboxToInt(jx));
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$solve$7$adapted(TypeConstraints $this, Symbols.Symbol tparam$1, Types.TypeVar tvar$1, List tparams$1, List tvars$1, Symbols.Symbol tparam2) {
        TypeConstraints.$anonfun$solve$7($this, tparam$1, tvar$1, tparams$1, tvars$1, tparam2);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$solve$10$adapted(TypeConstraints $this, Symbols.Symbol tparam$1, Types.TypeVar tvar$1, List tparams$1, List tvars$1, Symbols.Symbol tparam2) {
        TypeConstraints.$anonfun$solve$10($this, tparam$1, tvar$1, tparams$1, tvars$1, tparam2);
        return BoxedUnit.UNIT;
    }

    public static class TypeConstraint {
        private List<Types.Type> lobounds;
        private List<Types.Type> hibounds;
        private Types.Type numlo;
        private Types.Type numhi;
        private boolean avoidWidening;
        private Types.Type inst;
        public final /* synthetic */ SymbolTable $outer;

        private List<Types.Type> lobounds() {
            return this.lobounds;
        }

        private void lobounds_$eq(List<Types.Type> x$1) {
            this.lobounds = x$1;
        }

        private List<Types.Type> hibounds() {
            return this.hibounds;
        }

        private void hibounds_$eq(List<Types.Type> x$1) {
            this.hibounds = x$1;
        }

        private Types.Type numlo() {
            return this.numlo;
        }

        private void numlo_$eq(Types.Type x$1) {
            this.numlo = x$1;
        }

        private Types.Type numhi() {
            return this.numhi;
        }

        private void numhi_$eq(Types.Type x$1) {
            this.numhi = x$1;
        }

        private boolean avoidWidening() {
            return this.avoidWidening;
        }

        private void avoidWidening_$eq(boolean x$1) {
            this.avoidWidening = x$1;
        }

        public List<Types.Type> loBounds() {
            Types.Type type = this.numlo();
            Types$NoType$ types$NoType$ = this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType();
            if (!(type != null ? !type.equals(types$NoType$) : types$NoType$ != null)) {
                return this.lobounds();
            }
            Types.Type type2 = this.numlo();
            return this.lobounds().$colon$colon(type2);
        }

        public List<Types.Type> hiBounds() {
            Types.Type type = this.numhi();
            Types$NoType$ types$NoType$ = this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType();
            if (!(type != null ? !type.equals(types$NoType$) : types$NoType$ != null)) {
                return this.hibounds();
            }
            Types.Type type2 = this.numhi();
            return this.hibounds().$colon$colon(type2);
        }

        public boolean avoidWiden() {
            return this.avoidWidening();
        }

        public void addLoBound(Types.Type tp, boolean isNumericBound) {
            boolean bl;
            Symbols.Symbol symbol = tp.typeSymbol();
            if (this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().definitions().NothingClass().equals(symbol)) {
                bl = true;
            } else {
                boolean bl2 = bl = !this.lobounds().contains(tp);
            }
            if (bl) {
                if (isNumericBound && this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().definitions().isNumericValueType(tp)) {
                    Types.Type type = this.numlo();
                    Types$NoType$ types$NoType$ = this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType();
                    if (!(type == null ? types$NoType$ != null : !type.equals(types$NoType$)) || this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().isNumericSubType(this.numlo(), tp)) {
                        this.numlo_$eq(tp);
                        return;
                    }
                    if (!this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().isNumericSubType(tp, this.numlo())) {
                        this.numlo_$eq(this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().scala$reflect$internal$tpe$TypeConstraints$$numericLoBound());
                        return;
                    }
                } else {
                    this.lobounds_$eq(this.lobounds().$colon$colon(tp));
                }
            }
        }

        public boolean addLoBound$default$2() {
            return false;
        }

        public void checkWidening(Types.Type tp) {
            if (tp.isStable()) {
                this.avoidWidening_$eq(true);
                return;
            }
            if (!this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().HasTypeMember().unapply(tp).isEmpty()) {
                this.avoidWidening_$eq(true);
                return;
            }
        }

        public void addHiBound(Types.Type tp, boolean isNumericBound) {
            boolean bl;
            Symbols.Symbol symbol = tp.typeSymbol();
            Symbols.ClassSymbol classSymbol = this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().definitions().AnyClass();
            if (!(classSymbol != null ? !classSymbol.equals(symbol) : symbol != null)) {
                bl = true;
            } else {
                boolean bl2 = bl = !this.hibounds().contains(tp);
            }
            if (bl) {
                this.checkWidening(tp);
                if (isNumericBound && this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().definitions().isNumericValueType(tp)) {
                    Types.Type type = this.numhi();
                    Types$NoType$ types$NoType$ = this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType();
                    if (!(type == null ? types$NoType$ != null : !type.equals(types$NoType$)) || this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().isNumericSubType(tp, this.numhi())) {
                        this.numhi_$eq(tp);
                        return;
                    }
                    if (!this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().isNumericSubType(this.numhi(), tp)) {
                        this.numhi_$eq(this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().scala$reflect$internal$tpe$TypeConstraints$$numericHiBound());
                        return;
                    }
                } else {
                    this.hibounds_$eq(this.hibounds().$colon$colon(tp));
                }
            }
        }

        public boolean addHiBound$default$2() {
            return false;
        }

        public boolean instWithinBounds() {
            return this.instValid() && this.isWithinBounds(this.inst());
        }

        public boolean isWithinBounds(Types.Type tp) {
            boolean bl;
            block10: {
                List<Types.Type> list = this.lobounds();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized forall_these = list;
                while (!forall_these.isEmpty()) {
                    Types.Type type = (Types.Type)forall_these.head();
                    if (!type.$less$colon$less(tp)) {
                        bl = false;
                        break block10;
                    }
                    forall_these = (LinearSeqOptimized)forall_these.tail();
                }
                bl = true;
            }
            if (bl) {
                boolean bl2;
                block11: {
                    List<Types.Type> list = this.hibounds();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized forall_these = list;
                    while (!forall_these.isEmpty()) {
                        Types.Type type = (Types.Type)forall_these.head();
                        if (!tp.$less$colon$less(type)) {
                            bl2 = false;
                            break block11;
                        }
                        forall_these = (LinearSeqOptimized)forall_these.tail();
                    }
                    bl2 = true;
                }
                if (bl2) {
                    Types.Type type = this.numlo();
                    Types$NoType$ types$NoType$ = this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType();
                    if (!(type == null ? types$NoType$ != null : !type.equals(types$NoType$)) || this.numlo().weak_$less$colon$less(tp)) {
                        Types.Type type2 = this.numhi();
                        Types$NoType$ types$NoType$2 = this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType();
                        if (!(type2 == null ? types$NoType$2 != null : !type2.equals(types$NoType$2)) || tp.weak_$less$colon$less(this.numhi())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public Types.Type inst() {
            return this.inst;
        }

        public void inst_$eq(Types.Type x$1) {
            this.inst = x$1;
        }

        public boolean instValid() {
            return this.inst() != null && this.inst() != this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType();
        }

        /*
         * WARNING - void declaration
         */
        public TypeConstraint cloneInternal() {
            void var1_1;
            TypeConstraint tc = new TypeConstraint(this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer(), this.lobounds(), this.hibounds(), this.numlo(), this.numhi(), this.avoidWidening());
            tc.inst_$eq(this.inst());
            return var1_1;
        }

        /*
         * Unable to fully structure code
         */
        public String toString() {
            block8: {
                block7: {
                    block6: {
                        block5: {
                            var4_1 = (List)this.loBounds().filterNot((Function1)(Function1<Types.Type, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$toString$1$adapted(scala.reflect.internal.Types$Type ), (Lscala/reflect/internal/Types$Type;)Ljava/lang/Object;)());
                            if (!Nil$.MODULE$.equals(var4_1)) break block5;
                            var2_2 = "";
                            break block6;
                        }
                        if (!(var4_1 instanceof $colon$colon)) ** GOTO lbl-1000
                        var5_3 = ($colon$colon)var4_1;
                        tp = (Types.Type)var5_3.head();
                        var7_5 = var5_3.tl$access$1();
                        if (Nil$.MODULE$.equals(var7_5)) {
                            var2_2 = new StringBuilder(4).append(" >: ").append(tp).toString();
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 = var4_1.mkString(" >: (", ", ", ")");
                        }
                    }
                    var8_6 = (List)this.hiBounds().filterNot((Function1)(Function1<Types.Type, Object> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$toString$2$adapted(scala.reflect.internal.Types$Type ), (Lscala/reflect/internal/Types$Type;)Ljava/lang/Object;)());
                    if (!Nil$.MODULE$.equals(var8_6)) break block7;
                    var1_7 = "";
                    break block8;
                }
                if (!(var8_6 instanceof $colon$colon)) ** GOTO lbl-1000
                var9_8 = ($colon$colon)var8_6;
                tp = (Types.Type)var9_8.head();
                var11_10 = var9_8.tl$access$1();
                if (Nil$.MODULE$.equals(var11_10)) {
                    var1_7 = new StringBuilder(4).append(" <: ").append(tp).toString();
                } else lbl-1000:
                // 2 sources

                {
                    var1_7 = var8_6.mkString(" <: (", ", ", ")");
                }
            }
            boundsStr = new StringBuilder(0).append(var2_2).append(var1_7).toString();
            if (this.inst() == this.scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer().NoType()) {
                return boundsStr;
            }
            return new StringBuilder(4).append(boundsStr).append(" _= ").append(this.inst().safeToString()).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeConstraints$TypeConstraint$$$outer() {
            return this.$outer;
        }

        public TypeConstraint(SymbolTable $outer, List<Types.Type> lo0, List<Types.Type> hi0, Types.Type numlo0, Types.Type numhi0, boolean avoidWidening0) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.lobounds = (List)lo0.filterNot((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.isNothing()));
            this.hibounds = (List)hi0.filterNot((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$3 -> BoxesRunTime.boxToBoolean(x$3.isAny()));
            this.numlo = numlo0;
            this.numhi = numhi0;
            this.avoidWidening = avoidWidening0;
            this.inst = $outer.NoType();
        }

        public TypeConstraint(SymbolTable $outer, List<Types.Type> lo0, List<Types.Type> hi0) {
            this($outer, lo0, hi0, $outer.NoType(), $outer.NoType(), $outer.TypeConstraint().$lessinit$greater$default$5());
        }

        public TypeConstraint(SymbolTable $outer, Types.TypeBounds bounds) {
            this($outer, new $colon$colon<Nothing$>((Nothing$)((Object)bounds.lo()), Nil$.MODULE$), new $colon$colon<Nothing$>((Nothing$)((Object)bounds.hi()), Nil$.MODULE$));
        }

        public TypeConstraint(SymbolTable $outer) {
            this($outer, Nil$.MODULE$, Nil$.MODULE$);
        }

        public static final /* synthetic */ Object $anonfun$isWithinBounds$1$adapted(Types.Type tp$1, Types.Type x$6) {
            return BoxesRunTime.boxToBoolean(x$6.$less$colon$less(tp$1));
        }

        public static final /* synthetic */ Object $anonfun$isWithinBounds$2$adapted(Types.Type tp$1, Types.Type x$7) {
            return BoxesRunTime.boxToBoolean(tp$1.$less$colon$less(x$7));
        }

        public static final /* synthetic */ Object $anonfun$toString$1$adapted(Types.Type x$8) {
            return BoxesRunTime.boxToBoolean(x$8.isNothing());
        }

        public static final /* synthetic */ Object $anonfun$toString$2$adapted(Types.Type x$9) {
            return BoxesRunTime.boxToBoolean(x$9.isAny());
        }
    }

    public static class UndoLog
    implements Clearable {
        private List<UndoPair<Types.TypeVar, TypeConstraint>> log;
        public final /* synthetic */ SymbolTable $outer;

        public List<UndoPair<Types.TypeVar, TypeConstraint>> log() {
            return this.log;
        }

        public void log_$eq(List<UndoPair<Types.TypeVar, TypeConstraint>> x$1) {
            this.log = x$1;
        }

        /*
         * WARNING - void declaration
         */
        public void undoTo(List<UndoPair<Types.TypeVar, TypeConstraint>> limit) {
            this.scala$reflect$internal$tpe$TypeConstraints$UndoLog$$$outer().assertCorrectThread();
            while (this.log() != limit && this.log().nonEmpty()) {
                void var4_4;
                void var3_3;
                UndoPair<Types.TypeVar, TypeConstraint> undoPair = this.log().head();
                if (undoPair == null) {
                    throw new MatchError((Object)null);
                }
                Types.TypeVar tv = undoPair.tv();
                TypeConstraint constr = undoPair.tConstraint();
                void tv2 = var3_3;
                void constr2 = var4_4;
                tv2.constr_$eq((TypeConstraint)constr2);
                this.log_$eq((List)this.log().tail());
            }
        }

        public void record(Types.TypeVar tv) {
            this.log_$eq(this.log().$colon$colon(new UndoPair<Types.TypeVar, TypeConstraint>(tv, tv.constr().cloneInternal())));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void clear() {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = this.scala$reflect$internal$tpe$TypeConstraints$UndoLog$$$outer().settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                this.scala$reflect$internal$tpe$TypeConstraints$UndoLog$$$outer().log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(35).append("Clearing ").append(this.log().size()).append(" entries from the undoLog.").toString());
            }
            this.log_$eq(Nil$.MODULE$);
        }

        public <T> T undo(Function0<T> block) {
            T t;
            List<UndoPair<Types.TypeVar, TypeConstraint>> before = this.log();
            try {
                t = block.apply();
            }
            finally {
                this.undoTo(before);
            }
            return t;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeConstraints$UndoLog$$$outer() {
            return this.$outer;
        }

        public UndoLog(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.log = Nil$.MODULE$;
            if ($outer.isCompilerUniverse()) {
                $outer.perRunCaches().recordCache(this);
            }
        }
    }

    public static final class UndoPair<TypeVar extends Types.TypeVar, TypeConstraint extends TypeConstraint>
    implements Product,
    Serializable {
        private final TypeVar tv;
        private final TypeConstraint tConstraint;

        public TypeVar tv() {
            return this.tv;
        }

        public TypeConstraint tConstraint() {
            return this.tConstraint;
        }

        public <TypeVar extends Types.TypeVar, TypeConstraint extends TypeConstraint> UndoPair<TypeVar, TypeConstraint> copy(TypeVar tv, TypeConstraint tConstraint) {
            return new UndoPair<TypeVar, TypeConstraint>(tv, tConstraint);
        }

        public <TypeVar extends Types.TypeVar, TypeConstraint extends TypeConstraint> TypeVar copy$default$1() {
            return this.tv();
        }

        public <TypeVar extends Types.TypeVar, TypeConstraint extends TypeConstraint> TypeConstraint copy$default$2() {
            return this.tConstraint();
        }

        @Override
        public String productPrefix() {
            return "UndoPair";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.tv();
                }
                case 1: {
                    return this.tConstraint();
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
            return x$1 instanceof UndoPair;
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
            if (!(x$1 instanceof UndoPair)) return false;
            boolean bl = true;
            if (!bl) return false;
            UndoPair undoPair = (UndoPair)x$1;
            TypeVar TypeVar2 = this.tv();
            TypeVar TypeVar3 = undoPair.tv();
            if (TypeVar2 == null) {
                if (TypeVar3 != null) {
                    return false;
                }
            } else if (!TypeVar2.equals(TypeVar3)) return false;
            TypeConstraint TypeConstraint2 = this.tConstraint();
            TypeConstraint TypeConstraint3 = undoPair.tConstraint();
            if (TypeConstraint2 == null) {
                if (TypeConstraint3 == null) return true;
                return false;
            } else {
                if (!TypeConstraint2.equals(TypeConstraint3)) return false;
                return true;
            }
        }

        public UndoPair(TypeVar tv, TypeConstraint tConstraint) {
            this.tv = tv;
            this.tConstraint = tConstraint;
            Product.$init$(this);
        }
    }
}

