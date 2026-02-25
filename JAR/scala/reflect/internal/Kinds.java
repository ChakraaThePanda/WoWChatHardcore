/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Predef$any2stringadd$;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.IterableLike;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ListBuffer;
import scala.math.Ordering$Int$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Definitions$DefinitionsClass$NothingClass$;
import scala.reflect.internal.Kinds;
import scala.reflect.internal.Kinds$Kind$;
import scala.reflect.internal.Kinds$KindErrors$;
import scala.reflect.internal.Kinds$ProperTypeKind$;
import scala.reflect.internal.Kinds$TypeConKind$;
import scala.reflect.internal.Kinds$inferKind$;
import scala.reflect.internal.Names;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoType$;
import scala.reflect.internal.Types$WildcardType$;
import scala.reflect.internal.Variance;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.StringOps$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0015eh\u0001DAS\u0003O\u0003\n1!\u0001\u00026\u0016M\bbBA`\u0001\u0011\u0005\u0011\u0011Y\u0003\u0007\u0003\u0013\u0004A!a3\u0007\r\u0005u\u0007\u0001QAp\u0011)\tio\u0001BK\u0002\u0013\u0005\u0011q\u001e\u0005\u000b\u0005\u0003\u0019!\u0011#Q\u0001\n\u0005E\bB\u0003B\u0002\u0007\tU\r\u0011\"\u0001\u0002p\"Q!QA\u0002\u0003\u0012\u0003\u0006I!!=\t\u0015\t\u001d1A!f\u0001\n\u0003\ty\u000f\u0003\u0006\u0003\n\r\u0011\t\u0012)A\u0005\u0003cDqAa\u0003\u0004\t\u0003\u0011i\u0001C\u0004\u0003\u0018\r!\tA!\u0007\t\u000f\t\u00052\u0001\"\u0001\u0003$!9!\u0011F\u0002\u0005\u0002\t-\u0002b\u0002B\u0018\u0007\u0011\u0005!\u0011\u0007\u0005\b\u0005k\u0019A\u0011\u0001B\u001c\u0011\u001d\u0011id\u0001C\u0005\u0005\u007fAqAa\u0017\u0004\t\u0013\u0011i\u0006C\u0004\u0003h\r!IA!\u001b\t\u000f\t}4\u0001\"\u0003\u0003\u0002\"9!qQ\u0002\u0005\n\t%\u0005b\u0002BH\u0007\u0011%!\u0011\u0013\u0005\b\u0005/\u001bA\u0011\u0002BM\u0011\u001d\u0011\tl\u0001C\u0001\u0005gC\u0011Ba2\u0004\u0003\u0003%\tA!3\t\u0013\tE7!%A\u0005\u0002\tM\u0007\"\u0003Bu\u0007E\u0005I\u0011\u0001Bj\u0011%\u0011YoAI\u0001\n\u0003\u0011\u0019\u000eC\u0005\u0003n\u000e\t\t\u0011\"\u0011\u0003p\"I!\u0011_\u0002\u0002\u0002\u0013\u0005!1\u001f\u0005\n\u0005w\u001c\u0011\u0011!C\u0001\u0005{D\u0011b!\u0003\u0004\u0003\u0003%\tea\u0003\t\u0013\re1!!A\u0005\u0002\rm\u0001\"CB\u0010\u0007\u0005\u0005I\u0011IB\u0011\u0011%\u0019\u0019cAA\u0001\n\u0003\u001a)\u0003C\u0005\u0004(\r\t\t\u0011\"\u0011\u0004*\u001dI1Q\u0006\u0001\u0002\u0002#\u00051q\u0006\u0004\n\u0003;\u0004\u0011\u0011!E\u0001\u0007cAqAa\u0003&\t\u0003\u0019\t\u0005C\u0005\u0004$\u0015\n\t\u0011\"\u0012\u0004&!I11I\u0013\u0002\u0002\u0013\u00055Q\t\u0005\n\u0007\u001b*\u0013\u0013!C\u0001\u0005'D\u0011ba\u0014&#\u0003%\tAa5\t\u0013\rES%%A\u0005\u0002\tM\u0007\"CB*K\u0005\u0005I\u0011QB+\u0011%\u00199'JI\u0001\n\u0003\u0011\u0019\u000eC\u0005\u0004j\u0015\n\n\u0011\"\u0001\u0003T\"I11N\u0013\u0012\u0002\u0013\u0005!1\u001b\u0005\n\u0007[\u0002!\u0019!C\u0001\u0007_Bqa!\u001d\u0001\t\u0003\u0019\u0019\bC\u0004\u0004\n\u0002!Iaa#\t\u000f\rU\u0005\u0001\"\u0001\u0004\u0018\u001a91\u0011\u0016\u0001\u0002\u0002\r-\u0006b\u0002B\u0006i\u0011\u00051Q\u0016\u0005\b\u0007c#d\u0011ABZ\u0011\u001d\u0019)\f\u000eD\u0001\u0005gDqaa.5\r\u0003\u0019I\fC\u0004\u0004BR2\taa-\t\u000f\r\rGG\"\u0001\u00044\"91Q\u0019\u001b\u0005\u0002\te\u0001\"CBdi\u0019\u0005\u0011qUBe\u000f\u001d\u0019\t\u000e\u0001E\u0001\u0007'4qa!+\u0001\u0011\u0003\u0019)\u000eC\u0004\u0003\fy\"\taa6\u0007\u0017\reg\b%A\u0012\"\u0005\u001d61\u001c\u0004\t\u0007?t\u0004+a*\u0004b\"Q1QW!\u0003\u0016\u0004%\tAa=\t\u0015\r\u001d\u0018I!E!\u0002\u0013\u0011)\u0010\u0003\u0006\u0004j\u0006\u0013)\u001a!C\u0001\u0007WD!ba<B\u0005#\u0005\u000b\u0011BBw\u0011)\u0019\t0\u0011BK\u0002\u0013\u000511\u001f\u0005\u000b\u0007o\f%\u0011#Q\u0001\n\rU\bb\u0002B\u0006\u0003\u0012\u00051\u0011 \u0005\b\u0007G\tE\u0011\tC\u0002\u0011\u001d!)!\u0011C\u0005\t\u000fA\u0011Ba2B\u0003\u0003%\t\u0001\"\u0004\t\u0013\tE\u0017)%A\u0005\u0002\u0011U\u0001\"\u0003Bu\u0003F\u0005I\u0011\u0001C\r\u0011%\u0011Y/QI\u0001\n\u0003!i\u0002C\u0005\u0003n\u0006\u000b\t\u0011\"\u0011\u0003p\"I!\u0011_!\u0002\u0002\u0013\u0005!1\u001f\u0005\n\u0005w\f\u0015\u0011!C\u0001\tCA\u0011b!\u0003B\u0003\u0003%\tea\u0003\t\u0013\re\u0011)!A\u0005\u0002\u0011\u0015\u0002\"CB\u0010\u0003\u0006\u0005I\u0011IB\u0011\u0011%\u00199#QA\u0001\n\u0003\"IcB\u0006\u0005Py\n\t\u0011#\u0001\u0002(\u0012EcaCBp}\u0005\u0005\t\u0012AAT\t'BqAa\u0003X\t\u0003!9\u0006C\u0005\u0004$]\u000b\t\u0011\"\u0012\u0004&!I11I,\u0002\u0002\u0013\u0005E\u0011\f\u0005\n\u0007':\u0016\u0011!CA\tC2\u0001\u0002\"\f?!\u0006\u001dFq\u0006\u0005\u000b\tca&Q3A\u0005\u0002\rM\u0006B\u0003C\u001a9\nE\t\u0015!\u0003\u0003B!9!1\u0002/\u0005\u0002\u0011U\u0002bBB\u00129\u0012\u0005C1\u0001\u0005\n\u0005\u000fd\u0016\u0011!C\u0001\twA\u0011B!5]#\u0003%\t\u0001b\u0010\t\u0013\t5H,!A\u0005B\t=\b\"\u0003By9\u0006\u0005I\u0011\u0001Bz\u0011%\u0011Y\u0010XA\u0001\n\u0003!\u0019\u0005C\u0005\u0004\nq\u000b\t\u0011\"\u0011\u0004\f!I1\u0011\u0004/\u0002\u0002\u0013\u0005Aq\t\u0005\n\u0007?a\u0016\u0011!C!\u0007CA\u0011ba\n]\u0003\u0003%\t\u0005b\u0013\b\u0017\u0011%d(!A\t\u0002\u0005\u001dF1\u000e\u0004\f\t[q\u0014\u0011!E\u0001\u0003O#i\u0007C\u0004\u0003\f-$\t\u0001\"\u001e\t\u0013\r\r2.!A\u0005F\r\u0015\u0002\"CB\"W\u0006\u0005I\u0011\u0011C<\u0011%\u0019\u0019f[A\u0001\n\u0003#YH\u0002\u0005\u0005\u0000y\u0002\u0015q\u0015CA\u0011)!\u0019\t\u001dBK\u0002\u0013\u0005AQ\u0011\u0005\u000b\t\u001b\u0003(\u0011#Q\u0001\n\u0011\u001d\u0005b\u0002B\u0006a\u0012\u0005Aq\u0012\u0005\b\u0007G\u0001H\u0011\tC\u0002\u0011\u001d!)\n\u001dC\u0001\t/Cq\u0001b'q\t\u0003!i\nC\u0004\u0005&B$\t\u0001b*\t\u000f\u00115\u0006\u000f\"\u0001\u00050\"9A\u0011\u00179\u0005\u0002\u0011=\u0006\"\u0003Bda\u0006\u0005I\u0011\u0001CZ\u0011%\u0011\t\u000e]I\u0001\n\u0003!9\fC\u0005\u0003nB\f\t\u0011\"\u0011\u0003p\"I!\u0011\u001f9\u0002\u0002\u0013\u0005!1\u001f\u0005\n\u0005w\u0004\u0018\u0011!C\u0001\twC\u0011b!\u0003q\u0003\u0003%\tea\u0003\t\u0013\re\u0001/!A\u0005\u0002\u0011}\u0006\"CB\u0010a\u0006\u0005I\u0011IB\u0011\u0011%\u00199\u0003]A\u0001\n\u0003\"\u0019mB\u0005\u0005HzB\t!a*\u0005J\u001aIAq\u0010 \t\u0002\u0005\u001dF1\u001a\u0005\t\u0005\u0017\tI\u0001\"\u0001\u0005N\"AAqZA\u0005\t\u0003!y\u000b\u0003\u0006\u0004D\u0005%\u0011\u0011!CA\t#D!ba\u0015\u0002\n\u0005\u0005I\u0011\u0011Ck\u0011\u001d!YN\u0010C\u0001\t;Dq\u0001\"9?\t\u0003!\u0019O\u0002\u0004\u0005v\u0002\u0001Aq\u001f\u0005\f\u0007o\u000b9B!b\u0001\n\u0003\u0019I\fC\u0006\u0005z\u0006]!\u0011!Q\u0001\n\rm\u0006\u0002\u0003B\u0006\u0003/!\t\u0001b?\t\u0015\rE\u0016q\u0003b\u0001\n\u0003\u0019\u0019\fC\u0005\u0006\u0002\u0005]\u0001\u0015!\u0003\u0003B!Q1QWA\f\u0005\u0004%\tAa=\t\u0013\r\u001d\u0018q\u0003Q\u0001\n\tU\bBCBd\u0003/!\t!a*\u0006\u0004!A1\u0011YA\f\t\u0003\u0019\u0019\f\u0003\u0005\u0004D\u0006]A\u0011ABZ\u000f\u001d)i\u0001\u0001E\u0001\u000b\u001f1q\u0001\">\u0001\u0011\u0003)\t\u0002\u0003\u0005\u0003\f\u0005=B\u0011AC\n\u0011!\u0019\u0019%a\f\u0005\u0002\u0015U\u0001\u0002CB\"\u0003_!\t!b\u0006\t\u0011\rM\u0013q\u0006C\u0001\u000b71a!b\n\u0001\u0001\u0015%\u0002bCB\\\u0003s\u0011)\u0019!C\u0001\u0007sC1\u0002\"?\u0002:\t\u0005\t\u0015!\u0003\u0004<\"YQ1FA\u001d\u0005\u000b\u0007I\u0011AC\u0017\u0011-)I+!\u000f\u0003\u0002\u0003\u0006I!b\f\t\u0011\t-\u0011\u0011\bC\u0001\u000bWC!b!.\u0002:\t\u0007I\u0011\u0001Bz\u0011%\u00199/!\u000f!\u0002\u0013\u0011)\u0010\u0003\u0005\u00042\u0006eB\u0011ABZ\u0011!\u0019)-!\u000f\u0005B\te\u0001\u0002CBa\u0003s!\taa-\t\u0015\r\u001d\u0017\u0011\bC\u0001\u0003O+\t\f\u0003\u0005\u0004D\u0006eB\u0011ABZ\u000f\u001d))\u0004\u0001E\u0001\u000bo1q!b\n\u0001\u0011\u0003)I\u0004\u0003\u0005\u0003\f\u0005UC\u0011AC\u001e\u0011!\u0019\u0019%!\u0016\u0005\u0002\u0015u\u0002\u0002CB\"\u0003+\"\t!b\u0011\t\u0011\rM\u0013Q\u000bC\u0001\u000b\u00132q!b\u0015\u0002V\u0001+)\u0006C\u0006\u0003\u0004\u0005}#Q3A\u0005\u0002\u0015]\u0003b\u0003B\u0003\u0003?\u0012\t\u0012)A\u0005\t[D1\"\"\u0017\u0002`\tU\r\u0011\"\u0001\u0006\\!YQQLA0\u0005#\u0005\u000b\u0011BBX\u0011-!\u0019+a\u0018\u0003\u0006\u0004%\t!b\u0018\t\u0017\u0015\u0005\u0014q\fB\u0001B\u0003%\u0011\u0011\u001b\u0005\t\u0005\u0017\ty\u0006\"\u0001\u0006d!Q!qYA0\u0003\u0003%\t!\"\u001d\t\u0015\tE\u0017qLI\u0001\n\u0003)Y\b\u0003\u0006\u0003j\u0006}\u0013\u0013!C\u0001\u000b\u007fB!B!<\u0002`\u0005\u0005I\u0011\tBx\u0011)\u0011\t0a\u0018\u0002\u0002\u0013\u0005!1\u001f\u0005\u000b\u0005w\fy&!A\u0005\u0002\u0015\r\u0005BCB\u0005\u0003?\n\t\u0011\"\u0011\u0004\f!Q1\u0011DA0\u0003\u0003%\t!b\"\t\u0015\r}\u0011qLA\u0001\n\u0003\u001a\t\u0003\u0003\u0006\u0004$\u0005}\u0013\u0011!C!\u0007KA!ba\n\u0002`\u0005\u0005I\u0011ICF\u000f))y)!\u0016\u0002\u0002#\u0005Q\u0011\u0013\u0004\u000b\u000b'\n)&!A\t\u0002\u0015M\u0005\u0002\u0003B\u0006\u0003\u000f#\t!\"&\t\u0015\r\r\u0012qQA\u0001\n\u000b\u001a)\u0003\u0003\u0006\u0004D\u0005\u001d\u0015\u0011!CA\u000b/C!ba\u0015\u0002\b\u0006\u0005I\u0011QCQ\u000f\u001d)i\f\u0001E\u0001\u000b\u007f3q!\"1\u0001\u0011\u0003)\u0019\r\u0003\u0005\u0003\f\u0005ME\u0011ACc\r!)9-a%\u0002\u0002\u0015%\u0007\u0002\u0003B\u0006\u0003/#\t!b3\t\u0011\u0015E\u0017q\u0013D\t\u000b'D\u0001\"\"5\u0002\u0018\u0012EQq\u001c\u0005\t\u0007\u0007\n9\n\"\u0001\u0006f\"A11IAL\t\u0003)I\u000f\u0003\u0005\u0004D\u0005ME\u0011ACx\u0005\u0015Y\u0015N\u001c3t\u0015\u0011\tI+a+\u0002\u0011%tG/\u001a:oC2TA!!,\u00020\u00069!/\u001a4mK\u000e$(BAAY\u0003\u0015\u00198-\u00197b\u0007\u0001\u00192\u0001AA\\!\u0011\tI,a/\u000e\u0005\u0005=\u0016\u0002BA_\u0003_\u0013a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005\u0006\u0002\u0002DB!\u0011\u0011XAc\u0013\u0011\t9-a,\u0003\tUs\u0017\u000e\u001e\u0002\b'fl\u0007+Y5s!!\tI,!4\u0002R\u0006E\u0017\u0002BAh\u0003_\u0013a\u0001V;qY\u0016\u0014\u0004\u0003BAj\u0003+l\u0011\u0001A\u0005\u0005\u0003/\fIN\u0001\u0004Ts6\u0014w\u000e\\\u0005\u0005\u00037\f9KA\u0004Ts6\u0014w\u000e\\:\u0003\u0015-Kg\u000eZ#se>\u00148oE\u0004\u0004\u0003o\u000b\t/a:\u0011\t\u0005e\u00161]\u0005\u0005\u0003K\fyKA\u0004Qe>$Wo\u0019;\u0011\t\u0005e\u0016\u0011^\u0005\u0005\u0003W\fyK\u0001\u0007TKJL\u0017\r\\5{C\ndW-A\u0003be&$\u00180\u0006\u0002\u0002rB1\u00111_A}\u0003\u007ftA!!/\u0002v&!\u0011q_AX\u0003\u001d\u0001\u0018mY6bO\u0016LA!a?\u0002~\n!A*[:u\u0015\u0011\t90a,\u0011\u0007\u0005M'!\u0001\u0004be&$\u0018\u0010I\u0001\tm\u0006\u0014\u0018.\u00198dK\u0006Ia/\u0019:jC:\u001cW\rI\u0001\u000bgR\u0014\u0018n\u0019;oKN\u001c\u0018aC:ue&\u001cGO\\3tg\u0002\na\u0001P5oSRtD\u0003\u0003B\b\u0005#\u0011\u0019B!\u0006\u0011\u0007\u0005M7\u0001C\u0005\u0002n*\u0001\n\u00111\u0001\u0002r\"I!1\u0001\u0006\u0011\u0002\u0003\u0007\u0011\u0011\u001f\u0005\n\u0005\u000fQ\u0001\u0013!a\u0001\u0003c\fq![:F[B$\u00180\u0006\u0002\u0003\u001cA!\u0011\u0011\u0018B\u000f\u0013\u0011\u0011y\"a,\u0003\u000f\t{w\u000e\\3b]\u0006Q\u0011M]5us\u0016\u0013(o\u001c:\u0015\t\t=!Q\u0005\u0005\b\u0005Oa\u0001\u0019AA\u0000\u0003\u0011\u0019\u00180\\:\u0002\u001bY\f'/[1oG\u0016,%O]8s)\u0011\u0011yA!\f\t\u000f\t\u001dR\u00021\u0001\u0002\u0000\u0006y1\u000f\u001e:jGRtWm]:FeJ|'\u000f\u0006\u0003\u0003\u0010\tM\u0002b\u0002B\u0014\u001d\u0001\u0007\u0011q`\u0001\u000bIAdWo\u001d\u0013qYV\u001cH\u0003\u0002B\b\u0005sAqAa\u000f\u0010\u0001\u0004\u0011y!\u0001\u0003feJ\u001c\u0018A\u0002<beN#(\u000f\u0006\u0003\u0003B\t]\u0003\u0003\u0002B\"\u0005#rAA!\u0012\u0003NA!!qIAX\u001b\t\u0011IE\u0003\u0003\u0003L\u0005M\u0016A\u0002\u001fs_>$h(\u0003\u0003\u0003P\u0005=\u0016A\u0002)sK\u0012,g-\u0003\u0003\u0003T\tU#AB*ue&twM\u0003\u0003\u0003P\u0005=\u0006b\u0002B-!\u0001\u0007\u0011\u0011[\u0001\u0002g\u00069\u0011/^1mS\u001aLHC\u0002B!\u0005?\u0012\u0019\u0007C\u0004\u0003bE\u0001\r!!5\u0002\u0005\u0005\u0004\u0004b\u0002B3#\u0001\u0007\u0011\u0011[\u0001\u0003EB\n1b[5oI6+7o]1hKR1!1\u000eB<\u0005w\"BA!\u0011\u0003n!9!q\u000e\nA\u0002\tE\u0014!\u00014\u0011\u0015\u0005e&1\u000fB!\u0005\u0003\u0012\t%\u0003\u0003\u0003v\u0005=&!\u0003$v]\u000e$\u0018n\u001c83\u0011\u001d\u0011IH\u0005a\u0001\u0003#\f\u0011!\u0019\u0005\b\u0005{\u0012\u0002\u0019AAi\u0003\u0005\u0001\u0018!E:ue&\u001cGO\\3tg6+7o]1hKR1!\u0011\tBB\u0005\u000bCqA!\u001f\u0014\u0001\u0004\t\t\u000eC\u0004\u0003~M\u0001\r!!5\u0002\u001fY\f'/[1oG\u0016lUm]:bO\u0016$bA!\u0011\u0003\f\n5\u0005b\u0002B=)\u0001\u0007\u0011\u0011\u001b\u0005\b\u0005{\"\u0002\u0019AAi\u00031\t'/\u001b;z\u001b\u0016\u001c8/Y4f)\u0019\u0011\tEa%\u0003\u0016\"9!\u0011P\u000bA\u0002\u0005E\u0007b\u0002B?+\u0001\u0007\u0011\u0011[\u0001\rEVLG\u000eZ'fgN\fw-\u001a\u000b\u0007\u00057\u0013IK!,\u0011\t\tu%qU\u0007\u0003\u0005?SAA!)\u0003$\u0006!A.\u00198h\u0015\t\u0011)+\u0001\u0003kCZ\f\u0017\u0002\u0002B*\u0005?CqAa+\u0017\u0001\u0004\t\t0\u0001\u0002yg\"9!q\u000e\fA\u0002\t=\u0006CCA]\u0005g\n\t.!5\u0003B\u0005aQM\u001d:pe6+7o]1hKR1!\u0011\tB[\u0005\u0007DqAa.\u0018\u0001\u0004\u0011I,\u0001\u0003uCJ<\u0007\u0003BAj\u0005wKAA!0\u0003@\n!A+\u001f9f\u0013\u0011\u0011\t-a*\u0003\u000bQK\b/Z:\t\u000f\t\u0015w\u00031\u0001\u0002R\u00061A\u000f]1sC6\fAaY8qsRA!q\u0002Bf\u0005\u001b\u0014y\rC\u0005\u0002nb\u0001\n\u00111\u0001\u0002r\"I!1\u0001\r\u0011\u0002\u0003\u0007\u0011\u0011\u001f\u0005\n\u0005\u000fA\u0002\u0013!a\u0001\u0003c\fabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0002\u0003V*\"\u0011\u0011\u001fBlW\t\u0011I\u000e\u0005\u0003\u0003\\\n\u0015XB\u0001Bo\u0015\u0011\u0011yN!9\u0002\u0013Ut7\r[3dW\u0016$'\u0002\u0002Br\u0003_\u000b!\"\u00198o_R\fG/[8o\u0013\u0011\u00119O!8\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%g\u0005i\u0001O]8ek\u000e$\bK]3gSb,\"Aa'\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0005\tU\b\u0003BA]\u0005oLAA!?\u00020\n\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR!!q`B\u0003!\u0011\tIl!\u0001\n\t\r\r\u0011q\u0016\u0002\u0004\u0003:L\b\"CB\u0004=\u0005\u0005\t\u0019\u0001B{\u0003\rAH%M\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\u00111Q\u0002\t\u0007\u0007\u001f\u0019)Ba@\u000e\u0005\rE!\u0002BB\n\u0003_\u000b!bY8mY\u0016\u001cG/[8o\u0013\u0011\u00199b!\u0005\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u00057\u0019i\u0002C\u0005\u0004\b\u0001\n\t\u00111\u0001\u0003\u0000\u0006A\u0001.Y:i\u0007>$W\r\u0006\u0002\u0003v\u0006AAo\\*ue&tw\r\u0006\u0002\u0003\u001c\u00061Q-];bYN$BAa\u0007\u0004,!I1qA\u0012\u0002\u0002\u0003\u0007!q`\u0001\u000b\u0017&tG-\u0012:s_J\u001c\bcAAjKM)Qea\r\u0002hBa1QGB\u001e\u0007\u007f\u0019yda\u0010\u0003\u00105\u00111q\u0007\u0006\u0005\u0007s\ty+A\u0004sk:$\u0018.\\3\n\t\ru2q\u0007\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\u001c\u0004CBAz\u0003s\fY\r\u0006\u0002\u00040\u0005)\u0011\r\u001d9msRA!qBB$\u0007\u0013\u001aY\u0005C\u0005\u0002n\"\u0002\n\u00111\u0001\u0002r\"I!1\u0001\u0015\u0011\u0002\u0003\u0007\u0011\u0011\u001f\u0005\n\u0005\u000fA\u0003\u0013!a\u0001\u0003c\fq\"\u00199qYf$C-\u001a4bk2$H%M\u0001\u0010CB\u0004H.\u001f\u0013eK\u001a\fW\u000f\u001c;%e\u0005y\u0011\r\u001d9ms\u0012\"WMZ1vYR$3'A\u0004v]\u0006\u0004\b\u000f\\=\u0015\t\r]31\r\t\u0007\u0003s\u001bIf!\u0018\n\t\rm\u0013q\u0016\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u0015\u0005e6qLAy\u0003c\f\t0\u0003\u0003\u0004b\u0005=&A\u0002+va2,7\u0007C\u0005\u0004f1\n\t\u00111\u0001\u0003\u0010\u0005\u0019\u0001\u0010\n\u0019\u00027\u0011bWm]:j]&$He\u001a:fCR,'\u000f\n3fM\u0006,H\u000e\u001e\u00132\u0003m!C.Z:tS:LG\u000fJ4sK\u0006$XM\u001d\u0013eK\u001a\fW\u000f\u001c;%e\u0005YB\u0005\\3tg&t\u0017\u000e\u001e\u0013he\u0016\fG/\u001a:%I\u00164\u0017-\u001e7uIM\nABT8LS:$WI\u001d:peN,\"Aa\u0004\u0002\u0019-Lg\u000eZ:D_:4wN]7\u0015\u0015\tm1QOB>\u0007\u0003\u001b)\tC\u0004\u0004xE\u0002\ra!\u001f\u0002\u000fQ\u0004\u0018M]1ngB1\u00111_A}\u0003#Dqa! 2\u0001\u0004\u0019y(A\u0003uCJ<7\u000f\u0005\u0004\u0002t\u0006e(\u0011\u0018\u0005\b\u0007\u0007\u000b\u0004\u0019\u0001B]\u0003\r\u0001(/\u001a\u0005\b\u0007\u000f\u000b\u0004\u0019AAi\u0003\u0015ywO\\3s\u000391\u0018M]5b]\u000e,7/T1uG\"$bAa\u0007\u0004\u000e\u000eE\u0005bBBHe\u0001\u0007\u0011\u0011[\u0001\u0005gfl\u0017\u0007C\u0004\u0004\u0014J\u0002\r!!5\u0002\tMLXNM\u0001\u0011G\",7m[&j]\u0012\u0014u.\u001e8egB\"Bb!'\u0004\u001e\u000e}5\u0011UBR\u0007K\u0003b!a=\u0002z\u000em\u0005CCA]\u0007?\u0012I,!5\u0003\u0010!91qO\u001aA\u0002\re\u0004bBB?g\u0001\u00071q\u0010\u0005\b\u0007\u0007\u001b\u0004\u0019\u0001B]\u0011\u001d\u00199i\ra\u0001\u0003#Dqaa*4\u0001\u0004\u0011Y\"A\u0007fqBd\u0017-\u001b8FeJ|'o\u001d\u0002\u0005\u0017&tGmE\u00025\u0003o#\"aa,\u0011\u0007\u0005MG'A\u0006eKN\u001c'/\u001b9uS>tWC\u0001B!\u0003\u0015y'\u000fZ3s\u0003\u0019\u0011w.\u001e8egV\u001111\u0018\t\u0005\u0003'\u001ci,\u0003\u0003\u0004@\n}&A\u0003+za\u0016\u0014u.\u001e8eg\u0006i1oY1mC:{G/\u0019;j_:\fAb\u001d;be:{G/\u0019;j_:\f\u0011\u0002[1t\u0005>,h\u000eZ:\u0002\u0015\t,\u0018\u000e\u001c3Ti\u0006$X\r\u0006\u0004\u0004L\u0012\u001dH\u0011\u001e\u000b\u0005\u0007\u001b$)\u000fE\u0002\u0004PBt1!a5>\u0003\u0011Y\u0015N\u001c3\u0011\u0007\u0005MghE\u0002?\u0003o#\"aa5\u0003\u001bM\u001b\u0017\r\\1O_R\fG/[8o'\r\u0001\u0015qW\u0015\u0004\u0001\u0006c&\u0001\u0002%fC\u0012\u001c\u0012\"QA\\\u0007G\f\t/a:\u0011\u0007\r\u0015\b)D\u0001?\u0003\u0019y'\u000fZ3sA\u0005\ta.\u0006\u0002\u0004nB1\u0011\u0011XB-\u0005k\f!A\u001c\u0011\u0002\u000b\u0005d\u0017.Y:\u0016\u0005\rU\bCBA]\u00073\u0012\t%\u0001\u0004bY&\f7\u000f\t\u000b\t\u0007w\u001cipa@\u0005\u0002A\u00191Q]!\t\u000f\rU\u0006\n1\u0001\u0003v\"91\u0011\u001e%A\u0002\r5\bbBBy\u0011\u0002\u00071Q\u001f\u000b\u0003\u0005\u0003\n\u0011\u0002^=qK\u0006c\u0017.Y:\u0015\t\t\u0005C\u0011\u0002\u0005\b\t\u0017Q\u0005\u0019\u0001B{\u0003\u0005AH\u0003CB~\t\u001f!\t\u0002b\u0005\t\u0013\rU6\n%AA\u0002\tU\b\"CBu\u0017B\u0005\t\u0019ABw\u0011%\u0019\tp\u0013I\u0001\u0002\u0004\u0019)0\u0006\u0002\u0005\u0018)\"!Q\u001fBl+\t!YB\u000b\u0003\u0004n\n]WC\u0001C\u0010U\u0011\u0019)Pa6\u0015\t\t}H1\u0005\u0005\n\u0007\u000f\t\u0016\u0011!a\u0001\u0005k$BAa\u0007\u0005(!I1qA*\u0002\u0002\u0003\u0007!q \u000b\u0005\u00057!Y\u0003C\u0005\u0004\bU\u000b\t\u00111\u0001\u0003\u0000\n!A+\u001a=u'%a\u0016qWBr\u0003C\f9/A\u0003wC2,X-\u0001\u0004wC2,X\r\t\u000b\u0005\to!I\u0004E\u0002\u0004frCq\u0001\"\r`\u0001\u0004\u0011\t\u0005\u0006\u0003\u00058\u0011u\u0002\"\u0003C\u0019CB\u0005\t\u0019\u0001B!+\t!\tE\u000b\u0003\u0003B\t]G\u0003\u0002B\u0000\t\u000bB\u0011ba\u0002f\u0003\u0003\u0005\rA!>\u0015\t\tmA\u0011\n\u0005\n\u0007\u000f9\u0017\u0011!a\u0001\u0005\u007f$BAa\u0007\u0005N!I1qA5\u0002\u0002\u0003\u0007!q`\u0001\u0005\u0011\u0016\fG\rE\u0002\u0004f^\u001bRa\u0016C+\u0003O\u0004Bb!\u000e\u0004<\tU8Q^B{\u0007w$\"\u0001\"\u0015\u0015\u0011\rmH1\fC/\t?Bqa!.[\u0001\u0004\u0011)\u0010C\u0004\u0004jj\u0003\ra!<\t\u000f\rE(\f1\u0001\u0004vR!A1\rC4!\u0019\tIl!\u0017\u0005fAQ\u0011\u0011XB0\u0005k\u001cio!>\t\u0013\r\u00154,!AA\u0002\rm\u0018\u0001\u0002+fqR\u00042a!:l'\u0015YGqNAt!!\u0019)\u0004\"\u001d\u0003B\u0011]\u0012\u0002\u0002C:\u0007o\u0011\u0011#\u00112tiJ\f7\r\u001e$v]\u000e$\u0018n\u001c82)\t!Y\u0007\u0006\u0003\u00058\u0011e\u0004b\u0002C\u0019]\u0002\u0007!\u0011\t\u000b\u0005\u0007k$i\bC\u0005\u0004f=\f\t\u00111\u0001\u00058\tY1\u000b\u001e:j]\u001e\u001cF/\u0019;f'\u001d\u0001\u0018qWAq\u0003O\fa\u0001^8lK:\u001cXC\u0001CD!\u0019\t\u0019\u0010\"#\u0004d&!A1RA\u007f\u0005\r\u0019V-]\u0001\bi>\\WM\\:!)\u0011!\t\nb%\u0011\u0007\r\u0015\b\u000fC\u0004\u0005\u0004N\u0004\r\u0001b\"\u0002\r\u0005\u0004\b/\u001a8e)\u0011!\t\n\"'\t\u000f\u0011ER\u000f1\u0001\u0003B\u0005Q\u0011\r\u001d9f]\u0012DU-\u00193\u0015\r\u0011EEq\u0014CQ\u0011\u001d\u0019)L\u001ea\u0001\u0005kDq\u0001b)w\u0001\u0004\t\t.A\u0002ts6\fAbY8v]R\u0014\u0015p\u0014:eKJ$BA!>\u0005*\"9A1V<A\u0002\tU\u0018!A8\u0002\u0015I,Wn\u001c<f\u001f:,7/\u0006\u0002\u0005\u0012\u0006Y!/Z7pm\u0016\fE.[1t)\u0011!\t\n\".\t\u0013\u0011\r%\u0010%AA\u0002\u0011\u001dUC\u0001C]U\u0011!9Ia6\u0015\t\t}HQ\u0018\u0005\n\u0007\u000fq\u0018\u0011!a\u0001\u0005k$BAa\u0007\u0005B\"Q1qAA\u0001\u0003\u0003\u0005\rAa@\u0015\t\tmAQ\u0019\u0005\u000b\u0007\u000f\t)!!AA\u0002\t}\u0018aC*ue&twm\u0015;bi\u0016\u0004Ba!:\u0002\nM1\u0011\u0011BA\\\u0003O$\"\u0001\"3\u0002\u000b\u0015l\u0007\u000f^=\u0015\t\u0011EE1\u001b\u0005\t\t\u0007\u000by\u00011\u0001\u0005\bR!Aq\u001bCm!\u0019\tIl!\u0017\u0005\b\"Q1QMA\t\u0003\u0003\u0005\r\u0001\"%\u0002\u0015\u0019\u0013x.\u001c)be\u0006l7\u000f\u0006\u0003\u0003:\u0012}\u0007\u0002CB<\u0003'\u0001\ra!\u001f\u0002\u0011]KG\u000eZ2be\u0012,\"A!/\t\u000f\teC\b1\u0001\u0004N\"9A1\u0015\u001fA\u0002\u0005E\u0007b\u0002Cvy\u0001\u0007AQ^\u0001\u0002mB!Aq\u001eCy\u001b\t\t9+\u0003\u0003\u0005t\u0006\u001d&\u0001\u0003,be&\fgnY3\u0003\u001dA\u0013x\u000e]3s)f\u0004XmS5oIN!\u0011qCBX\u0003\u001d\u0011w.\u001e8eg\u0002\"B\u0001\"@\u0005\u0000B!\u00111[A\f\u0011!\u00199,!\bA\u0002\rm\u0016\u0001\u00043fg\u000e\u0014\u0018\u000e\u001d;j_:\u0004CCBC\u0003\u000b\u0013)Y\u0001\u0006\u0003\u0004N\u0016\u001d\u0001\u0002\u0003B-\u0003O\u0001\ra!4\t\u0011\u0011\r\u0016q\u0005a\u0001\u0003#D\u0001\u0002b;\u0002(\u0001\u0007AQ^\u0001\u000f!J|\u0007/\u001a:UsB,7*\u001b8e!\u0011\t\u0019.a\f\u0014\t\u0005=\u0012q\u0017\u000b\u0003\u000b\u001f)\"\u0001\"@\u0015\t\u0011uX\u0011\u0004\u0005\t\u0007o\u000b)\u00041\u0001\u0004<R!QQDC\u0012!\u0019\tI,b\b\u0004<&!Q\u0011EAX\u0005\u0011\u0019v.\\3\t\u0011\u0015\u0015\u0012q\u0007a\u0001\t{\f1\u0001\u001d;l\u0005-!\u0016\u0010]3D_:\\\u0015N\u001c3\u0014\t\u0005e2qV\u0001\u0005CJ<7/\u0006\u0002\u00060A1\u00111\u001fCE\u000bc\u0001B!b\r\u0002`9!\u00111[A*\u0003-!\u0016\u0010]3D_:\\\u0015N\u001c3\u0011\t\u0005M\u0017QK\n\u0005\u0003+\n9\f\u0006\u0002\u00068Q!QqHC!!\u0011\t\u0019.!\u000f\t\u0011\u0015-\u0012\u0011\fa\u0001\u000b_!b!b\u0010\u0006F\u0015\u001d\u0003\u0002CB\\\u00037\u0002\raa/\t\u0011\u0015-\u00121\fa\u0001\u000b_!B!b\u0013\u0006PA1\u0011\u0011XC\u0010\u000b\u001b\u0002\u0002\"!/\u0002N\u000emVq\u0006\u0005\t\u000b#\ni\u00061\u0001\u0006@\u0005\u0019AoY6\u0003\u0011\u0005\u0013x-^7f]R\u001c\u0002\"a\u0018\u00028\u0006\u0005\u0018q]\u000b\u0003\t[\fAa[5oIV\u00111qV\u0001\u0006W&tG\rI\u000b\u0003\u0003#\fAa]=nAQ1QQMC7\u000b_\"B!b\u001a\u0006lA!Q\u0011NA0\u001b\t\t)\u0006\u0003\u0005\u0005$\u00065\u0004\u0019AAi\u0011!\u0011\u0019!!\u001cA\u0002\u00115\b\u0002CC-\u0003[\u0002\raa,\u0015\r\u0015MTqOC=)\u0011)9'\"\u001e\t\u0011\u0011\r\u0016q\u000ea\u0001\u0003#D!Ba\u0001\u0002pA\u0005\t\u0019\u0001Cw\u0011))I&a\u001c\u0011\u0002\u0003\u00071qV\u000b\u0003\u000b{RC\u0001\"<\u0003XV\u0011Q\u0011\u0011\u0016\u0005\u0007_\u00139\u000e\u0006\u0003\u0003\u0000\u0016\u0015\u0005BCB\u0004\u0003s\n\t\u00111\u0001\u0003vR!!1DCE\u0011)\u00199!! \u0002\u0002\u0003\u0007!q \u000b\u0005\u00057)i\t\u0003\u0006\u0004\b\u0005\r\u0015\u0011!a\u0001\u0005\u007f\f\u0001\"\u0011:hk6,g\u000e\u001e\t\u0005\u000bS\n9i\u0005\u0004\u0002\b\u0006]\u0016q\u001d\u000b\u0003\u000b##b!\"'\u0006\u001e\u0016}E\u0003BC4\u000b7C\u0001\u0002b)\u0002\u000e\u0002\u0007\u0011\u0011\u001b\u0005\t\u0005\u0007\ti\t1\u0001\u0005n\"AQ\u0011LAG\u0001\u0004\u0019y\u000b\u0006\u0003\u0006$\u0016\u001d\u0006CBA]\u00073*)\u000b\u0005\u0005\u0002:\u00065GQ^BX\u0011)\u0019)'a$\u0002\u0002\u0003\u0007QqM\u0001\u0006CJ<7\u000f\t\u000b\u0007\u000b\u007f)i+b,\t\u0011\r]\u00161\ta\u0001\u0007wC\u0001\"b\u000b\u0002D\u0001\u0007Qq\u0006\u000b\u0007\u000bg+I,b/\u0015\t\r5WQ\u0017\u0005\t\u000bo\u000by\u00051\u0001\u0004N\u0006\u00111\u000f\r\u0005\t\tG\u000by\u00051\u0001\u0002R\"AA1^A(\u0001\u0004!i/A\u0005j]\u001a,'oS5oIB!\u00111[AJ\u0005%IgNZ3s\u0017&tGm\u0005\u0003\u0002\u0014\u0006]FCAC`\u0005%IeNZ3s\u0017&tGm\u0005\u0003\u0002\u0018\u0006]FCACg!\u0011)y-a&\u000e\u0005\u0005M\u0015!B5oM\u0016\u0014H\u0003CBX\u000b+,I.b7\t\u0011\u0015]\u00171\u0014a\u0001\u0005s\u000b1\u0001\u001e9f\u0011!\u00199)a'A\u0002\u0005E\u0007\u0002CCo\u00037\u0003\rAa\u0007\u0002\u0011Q|\u0007\u000fT3wK2$baa,\u0006b\u0016\r\b\u0002\u0003CR\u0003;\u0003\r!!5\t\u0011\u0015u\u0017Q\u0014a\u0001\u00057!Baa,\u0006h\"AA1UAP\u0001\u0004\t\t\u000e\u0006\u0004\u00040\u0016-XQ\u001e\u0005\t\u000b/\f\t\u000b1\u0001\u0003:\"A1qQAQ\u0001\u0004\t\t\u000e\u0006\u0003\u0006N\u0016E\b\u0002CBB\u0003G\u0003\rA!/\u0011\t\u0011=XQ_\u0005\u0005\u000bo\f9KA\u0006Ts6\u0014w\u000e\u001c+bE2,\u0007")
public interface Kinds {
    public Kinds$KindErrors$ KindErrors();

    public Kinds$Kind$ Kind();

    public Kinds$ProperTypeKind$ ProperTypeKind();

    public Kinds$TypeConKind$ TypeConKind();

    public Kinds$inferKind$ inferKind();

    public void scala$reflect$internal$Kinds$_setter_$NoKindErrors_$eq(KindErrors var1);

    public KindErrors NoKindErrors();

    public static /* synthetic */ boolean kindsConform$(Kinds $this, List tparams, List targs, Types.Type pre, Symbols.Symbol owner) {
        return $this.kindsConform(tparams, targs, pre, owner);
    }

    default public boolean kindsConform(List<Symbols.Symbol> tparams, List<Types.Type> targs, Types.Type pre, Symbols.Symbol owner) {
        return this.checkKindBounds0(tparams, targs, pre, owner, false).isEmpty();
    }

    private boolean variancesMatch(Symbols.Symbol sym1, Symbols.Symbol sym2) {
        return Variance$.MODULE$.isInvariant$extension(sym2.variance()) || sym1.variance() == sym2.variance();
    }

    public static /* synthetic */ List checkKindBounds0$(Kinds $this, List tparams, List targs, Types.Type pre, Symbols.Symbol owner, boolean explainErrors) {
        return $this.checkKindBounds0(tparams, targs, pre, owner, explainErrors);
    }

    /*
     * WARNING - void declaration
     */
    default public List<Tuple3<Types.Type, Symbols.Symbol, KindErrors>> checkKindBounds0(List<Symbols.Symbol> tparams, List<Types.Type> targs, Types.Type pre, Symbols.Symbol owner, boolean explainErrors) {
        Object object = new Object();
        try {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = ((SymbolTable)this).settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value()) && (tparams.nonEmpty() || targs.nonEmpty())) {
                ((SymbolTable)this).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(26).append("checkKindBounds0(").append(tparams).append(", ").append(targs).append(", ").append(pre).append(", ").append(owner).append(", ").append(explainErrors).append(")").toString());
            }
            Collections cfr_ignored_0 = (Collections)((Object)this);
            ListBuffer flatMap2_lb = null;
            List flatMap2_ys1 = tparams;
            List flatMap2_ys2 = targs;
            while (!flatMap2_ys1.isEmpty() && !flatMap2_ys2.isEmpty()) {
                Types.Type type = flatMap2_ys2.head();
                Symbols.Symbol symbol = flatMap2_ys1.head();
                List flatMap2_cs = Kinds.$anonfun$checkKindBounds0$10(this, explainErrors, object, owner, tparams, targs, pre, symbol, type);
                if (flatMap2_cs != Nil$.MODULE$) {
                    if (flatMap2_lb == null) {
                        flatMap2_lb = new ListBuffer();
                    }
                    flatMap2_lb.$plus$plus$eq((TraversableOnce)flatMap2_cs);
                }
                flatMap2_ys1 = (List)flatMap2_ys1.tail();
                flatMap2_ys2 = (List)flatMap2_ys2.tail();
            }
            return flatMap2_lb == null ? Nil$.MODULE$ : flatMap2_lb.result();
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return (List)ex.value();
            }
            throw ex;
        }
    }

    private static Types.Type transform$1(Types.Type tp, Symbols.Symbol clazz, Types.Type pre$1) {
        return tp.asSeenFrom(pre$1, clazz);
    }

    private static Types.Type bindHKParams$1(Types.Type tp, List underHKParams$1, List withHKArgs$1) {
        return tp.substSym(underHKParams$1, withHKArgs$1);
    }

    private static void kindCheck$1(boolean cond, Function1 f, ObjectRef kindErrors$1) {
        if (!cond) {
            kindErrors$1.elem = (KindErrors)f.apply((KindErrors)kindErrors$1.elem);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ KindErrors $anonfun$checkKindBounds0$5(Symbols.Symbol hkarg$1, Symbols.Symbol hkparam$1, KindErrors x$7) {
        void $minus$greater$extension_$this;
        Symbols.Symbol symbol = Predef$.MODULE$.ArrowAssoc(hkarg$1);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        return x$7.varianceError(new Tuple2<void, Symbols.Symbol>($minus$greater$extension_$this, hkparam$1));
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ KindErrors $anonfun$checkKindBounds0$6(Symbols.Symbol hkarg$1, Symbols.Symbol hkparam$1, KindErrors x$8) {
        void $minus$greater$extension_$this;
        Symbols.Symbol symbol = Predef$.MODULE$.ArrowAssoc(hkarg$1);
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        return x$8.strictnessError(new Tuple2<void, Symbols.Symbol>($minus$greater$extension_$this, hkparam$1));
    }

    public static /* synthetic */ void $anonfun$checkKindBounds0$4(Kinds $this, List tparams$1, List targs$1, Symbols.Symbol paramowner$1, Symbols.Symbol owner$1, ObjectRef kindErrors$1, List underHKParams$1, List withHKArgs$1, boolean explainErrors$1, Object nonLocalReturnKey1$1, Types.Type pre$1, Symbols.Symbol hkarg, Symbols.Symbol hkparam) {
        if (hkparam.typeParams().isEmpty() && hkarg.typeParams().isEmpty()) {
            Types.Type argumentBounds;
            Types.Type declaredBounds;
            Types.Type declaredBoundsInst;
            if (!$this.variancesMatch(hkarg, hkparam)) {
                KindErrors kindErrors = (KindErrors)kindErrors$1.elem;
                kindErrors$1.elem = Kinds.$anonfun$checkKindBounds0$5(hkarg, hkparam, kindErrors);
            }
            if (!(declaredBoundsInst = Kinds.transform$1(Kinds.bindHKParams$1(declaredBounds = Kinds.transform$1(hkparam.info().instantiateTypeParams(tparams$1, targs$1).bounds(), paramowner$1, pre$1), underHKParams$1, withHKArgs$1), owner$1, pre$1)).$less$colon$less(argumentBounds = Kinds.transform$1(hkarg.info().bounds(), owner$1, pre$1))) {
                KindErrors kindErrors = (KindErrors)kindErrors$1.elem;
                kindErrors$1.elem = Kinds.$anonfun$checkKindBounds0$6(hkarg, hkparam, kindErrors);
            }
            ((SymbolTable)$this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(129).append("checkKindBoundsHK base case: ").append(hkparam).append(" declared bounds: ").append(declaredBounds).append(" after instantiating earlier hkparams: ").append(declaredBoundsInst).append("\n").append("checkKindBoundsHK base case: ").append(hkarg).append(" has bounds: ").append(argumentBounds).toString());
        } else {
            hkarg.initialize();
            ((SymbolTable)$this).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(55).append("checkKindBoundsHK recursing to compare params of ").append(hkparam).append(" with ").append(hkarg).toString());
            kindErrors$1.elem = ((KindErrors)kindErrors$1.elem).$plus$plus($this.checkKindBoundsHK$1(hkarg.typeParams(), hkarg, hkparam, paramowner$1, underHKParams$1.$plus$plus(hkparam.typeParams(), List$.MODULE$.canBuildFrom()), withHKArgs$1.$plus$plus(hkarg.typeParams(), List$.MODULE$.canBuildFrom()), owner$1, tparams$1, targs$1, explainErrors$1, pre$1));
        }
        if (!explainErrors$1 && !((KindErrors)kindErrors$1.elem).isEmpty()) {
            throw new NonLocalReturnControl<KindErrors>(nonLocalReturnKey1$1, (KindErrors)kindErrors$1.elem);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private KindErrors checkKindBoundsHK$1(List hkargs, Symbols.Symbol arg, Symbols.Symbol param2, Symbols.Symbol paramowner, List underHKParams, List withHKArgs, Symbols.Symbol owner$1, List tparams$1, List targs$1, boolean explainErrors$1, Types.Type pre$1) {
        Object object = new Object();
        try {
            void reflectSettingToBoolean_s;
            ObjectRef<KindErrors> kindErrors = ObjectRef.create(this.NoKindErrors());
            List hkparams = param2.typeParams();
            MutableSettings.SettingValue settingValue = ((SymbolTable)this).settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                ((SymbolTable)this).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(59).append("checkKindBoundsHK expected: ").append(param2).append(" with params ").append(hkparams).append(" by definition in ").append(paramowner).toString());
                ((SymbolTable)this).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(47).append("checkKindBoundsHK supplied: ").append(arg).append(" with params ").append(hkargs).append(" from ").append(owner$1).toString());
                ((SymbolTable)this).log((Function0<Object>)(Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(43).append("checkKindBoundsHK under params: ").append(underHKParams).append(" with args ").append(withHKArgs).toString());
            }
            if (!((Collections)((Object)this)).sameLength(hkargs, hkparams)) {
                Symbols.Symbol symbol = arg;
                Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().AnyClass();
                if (symbol == null ? classSymbol != null : !symbol.equals(classSymbol)) {
                    Symbols.Symbol symbol2 = arg;
                    Definitions$DefinitionsClass$NothingClass$ definitions$DefinitionsClass$NothingClass$ = ((Definitions)((Object)this)).definitions().NothingClass();
                    if (symbol2 != null ? !symbol2.equals(definitions$DefinitionsClass$NothingClass$) : definitions$DefinitionsClass$NothingClass$ != null) {
                        Symbols.Symbol symbol3 = Predef$.MODULE$.ArrowAssoc(arg);
                        if (Predef$ArrowAssoc$.MODULE$ != null) void $minus$greater$extension_$this;
                        return ((KindErrors)kindErrors.elem).arityError(new Tuple2<void, Symbols.Symbol>($minus$greater$extension_$this, param2));
                        throw null;
                    }
                }
                this.NoKindErrors();
            } else {
                Collections cfr_ignored_0 = (Collections)((Object)this);
                List foreach2_ys1 = hkargs;
                List foreach2_ys2 = hkparams;
                while (!foreach2_ys1.isEmpty() && !foreach2_ys2.isEmpty()) {
                    Symbols.Symbol symbol = foreach2_ys2.head();
                    Symbols.Symbol symbol4 = (Symbols.Symbol)foreach2_ys1.head();
                    Kinds.$anonfun$checkKindBounds0$4(this, tparams$1, targs$1, paramowner, owner$1, kindErrors, underHKParams, withHKArgs, explainErrors$1, object, pre$1, symbol4, symbol);
                    foreach2_ys1 = (List)foreach2_ys1.tail();
                    foreach2_ys2 = (List)foreach2_ys2.tail();
                }
            }
            if (!explainErrors$1) return this.NoKindErrors();
            return (KindErrors)kindErrors.elem;
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() != object) throw ex;
            return (KindErrors)ex.value();
        }
    }

    public static /* synthetic */ List $anonfun$checkKindBounds0$10(Kinds $this, boolean explainErrors$1, Object nonLocalReturnKey2$1, Symbols.Symbol owner$1, List tparams$1, List targs$1, Types.Type pre$1, Symbols.Symbol tparam, Types.Type targ) {
        Types.Type type = targ;
        Types$WildcardType$ types$WildcardType$ = ((Types)((Object)$this)).WildcardType();
        if (!(type != null ? !type.equals(types$WildcardType$) : types$WildcardType$ != null)) {
            return Nil$.MODULE$;
        }
        targ.typeSymbolDirect().info();
        List<Symbols.Symbol> tparamsHO = targ.typeParams();
        if (targ.isHigherKinded() || tparam.typeParams().nonEmpty()) {
            KindErrors kindErrors = $this.checkKindBoundsHK$1(tparamsHO, targ.typeSymbolDirect(), tparam, tparam.owner(), tparam.typeParams(), tparamsHO, owner$1, tparams$1, targs$1, explainErrors$1, pre$1);
            if (kindErrors.isEmpty()) {
                return Nil$.MODULE$;
            }
            if (explainErrors$1) {
                return new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple3<Types.Type, Symbols.Symbol, KindErrors>(targ, tparam, kindErrors)), Nil$.MODULE$);
            }
            throw new NonLocalReturnControl<$colon$colon<Nothing$>>(nonLocalReturnKey2$1, new $colon$colon<Nothing$>((Nothing$)((Object)new Tuple3<Types$NoType$, Symbols.NoSymbol, KindErrors>(((Types)((Object)$this)).NoType(), ((Symbols)((Object)$this)).NoSymbol(), $this.NoKindErrors())), Nil$.MODULE$));
        }
        return Nil$.MODULE$;
    }

    public static void $init$(Kinds $this) {
        $this.scala$reflect$internal$Kinds$_setter_$NoKindErrors_$eq(new KindErrors((SymbolTable)$this, Nil$.MODULE$, Nil$.MODULE$, Nil$.MODULE$));
    }

    public static /* synthetic */ Object $anonfun$checkKindBounds0$4$adapted(Kinds $this, List tparams$1, List targs$1, Symbols.Symbol paramowner$1, Symbols.Symbol owner$1, ObjectRef kindErrors$1, List underHKParams$1, List withHKArgs$1, boolean explainErrors$1, Object nonLocalReturnKey1$1, Types.Type pre$1, Symbols.Symbol hkarg, Symbols.Symbol hkparam) {
        Kinds.$anonfun$checkKindBounds0$4($this, tparams$1, targs$1, paramowner$1, owner$1, kindErrors$1, underHKParams$1, withHKArgs$1, explainErrors$1, nonLocalReturnKey1$1, pre$1, hkarg, hkparam);
        return BoxedUnit.UNIT;
    }

    public static abstract class Kind {
        public final /* synthetic */ SymbolTable $outer;

        public abstract String description();

        public abstract int order();

        public abstract Types.TypeBounds bounds();

        public abstract String scalaNotation();

        public abstract String starNotation();

        public boolean hasBounds() {
            return !this.bounds().isEmptyBounds();
        }

        public abstract StringState buildState(Symbols.Symbol var1, int var2, StringState var3);

        public /* synthetic */ SymbolTable scala$reflect$internal$Kinds$Kind$$$outer() {
            return this.$outer;
        }

        public Kind(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }

        public class StringState
        implements Product,
        Serializable {
            private final Seq<ScalaNotation> tokens;
            public final /* synthetic */ Kinds$Kind$ $outer;

            public Seq<ScalaNotation> tokens() {
                return this.tokens;
            }

            public String toString() {
                return this.tokens().mkString();
            }

            public StringState append(String value) {
                return new StringState(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), this.tokens().$colon$plus(new Text(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), value), Seq$.MODULE$.canBuildFrom()));
            }

            public StringState appendHead(int order, Symbols.Symbol sym) {
                int n = this.countByOrder(order) + 1;
                Option alias = sym == this.scala$reflect$internal$Kinds$Kind$StringState$$$outer().scala$reflect$internal$Kinds$Kind$$$outer().NoSymbol() ? None$.MODULE$ : new Some<String>(sym.nameString());
                return new StringState(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), this.tokens().$colon$plus(new Head(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), order, new Some<Object>(BoxesRunTime.boxToInteger(n)), alias), Seq$.MODULE$.canBuildFrom()));
            }

            public int countByOrder(int o) {
                return this.tokens().count((Function1<ScalaNotation, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(StringState.$anonfun$countByOrder$1(o, x0$1)));
            }

            /*
             * WARNING - void declaration
             */
            public StringState removeOnes() {
                void $div$colon_op;
                int maxOrder = BoxesRunTime.unboxToInt(((TraversableOnce)this.tokens().map((Function1<ScalaNotation, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToInteger(n = x0$1 instanceof Head ? ((Head)x0$1).order() : 0), Seq$.MODULE$.canBuildFrom())).max(Ordering$Int$.MODULE$));
                Seq<ScalaNotation> seq = this.tokens();
                int n = 0;
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(n, maxOrder);
                Function2<Seq, Object, Seq> & java.io.Serializable & Serializable intersect = (Function2<Seq, Object, Seq> & java.io.Serializable & Serializable)(ts, o) -> StringState.$anonfun$removeOnes$2(this, ts, BoxesRunTime.unboxToInt(o));
                if (inclusive == null) {
                    throw null;
                }
                return new StringState(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), inclusive.foldLeft(seq, $div$colon_op));
            }

            public StringState removeAlias() {
                return new StringState(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), this.tokens().map((Function1<ScalaNotation, ScalaNotation> & java.io.Serializable & Serializable)x0$1 -> {
                    if (!(x0$1 instanceof Head)) return x0$1;
                    Head head = (Head)x0$1;
                    int o = head.order();
                    Option<Object> n = head.n();
                    if (!(head.alias() instanceof Some)) return x0$1;
                    return new Head(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), o, n, None$.MODULE$);
                }, Seq$.MODULE$.canBuildFrom()));
            }

            public StringState copy(Seq<ScalaNotation> tokens) {
                return new StringState(this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), tokens);
            }

            public Seq<ScalaNotation> copy$default$1() {
                return this.tokens();
            }

            @Override
            public String productPrefix() {
                return "StringState";
            }

            @Override
            public int productArity() {
                return 1;
            }

            @Override
            public Object productElement(int x$1) {
                switch (x$1) {
                    case 0: {
                        return this.tokens();
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
                return x$1 instanceof StringState;
            }

            public int hashCode() {
                return ScalaRunTime$.MODULE$._hashCode(this);
            }

            @Override
            public boolean equals(Object x$1) {
                block3: {
                    block2: {
                        if (this == x$1) break block2;
                        boolean bl = x$1 instanceof StringState && ((StringState)x$1).scala$reflect$internal$Kinds$Kind$StringState$$$outer() == this.scala$reflect$internal$Kinds$Kind$StringState$$$outer();
                        if (!bl) break block3;
                        StringState stringState = (StringState)x$1;
                        Seq<ScalaNotation> seq = this.tokens();
                        Seq<ScalaNotation> seq2 = stringState.tokens();
                        if (!(!(seq != null ? !seq.equals(seq2) : seq2 != null) && stringState.canEqual(this))) break block3;
                    }
                    return true;
                }
                return false;
            }

            public /* synthetic */ Kinds$Kind$ scala$reflect$internal$Kinds$Kind$StringState$$$outer() {
                return this.$outer;
            }

            public static final /* synthetic */ boolean $anonfun$countByOrder$1(int o$1, ScalaNotation x0$1) {
                int n;
                boolean bl = x0$1 instanceof Head && o$1 == (n = ((Head)x0$1).order());
                return bl;
            }

            public static final /* synthetic */ Seq $anonfun$removeOnes$2(StringState $this, Seq ts, int o) {
                if ($this.countByOrder(o) <= 1) {
                    return ts.map((Function1<ScalaNotation, ScalaNotation> & java.io.Serializable & Serializable)x0$2 -> {
                        if (!(x0$2 instanceof Head)) return x0$2;
                        Head head = (Head)x0$2;
                        int n = head.order();
                        Option<String> a = head.alias();
                        if (o != n) return x0$2;
                        return new Head($this.scala$reflect$internal$Kinds$Kind$StringState$$$outer(), o, None$.MODULE$, a);
                    }, Seq$.MODULE$.canBuildFrom());
                }
                return ts;
            }

            public StringState(Kinds$Kind$ $outer, Seq<ScalaNotation> tokens) {
                this.tokens = tokens;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                Product.$init$(this);
            }
        }
    }

    public class KindErrors
    implements Product,
    Serializable {
        private final List<Tuple2<Symbols.Symbol, Symbols.Symbol>> arity;
        private final List<Tuple2<Symbols.Symbol, Symbols.Symbol>> variance;
        private final List<Tuple2<Symbols.Symbol, Symbols.Symbol>> strictness;
        public final /* synthetic */ SymbolTable $outer;

        public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> arity() {
            return this.arity;
        }

        public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> variance() {
            return this.variance;
        }

        public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> strictness() {
            return this.strictness;
        }

        public boolean isEmpty() {
            return this.arity().isEmpty() && this.variance().isEmpty() && this.strictness().isEmpty();
        }

        public KindErrors arityError(Tuple2<Symbols.Symbol, Symbols.Symbol> syms) {
            return this.copy(this.arity().$colon$plus(syms, List$.MODULE$.canBuildFrom()), this.copy$default$2(), this.copy$default$3());
        }

        public KindErrors varianceError(Tuple2<Symbols.Symbol, Symbols.Symbol> syms) {
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> x$1 = this.variance().$colon$plus(syms, List$.MODULE$.canBuildFrom());
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> x$2 = this.copy$default$1();
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> x$3 = this.copy$default$3();
            return this.copy(x$2, x$1, x$3);
        }

        public KindErrors strictnessError(Tuple2<Symbols.Symbol, Symbols.Symbol> syms) {
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> x$1 = this.strictness().$colon$plus(syms, List$.MODULE$.canBuildFrom());
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> x$2 = this.copy$default$1();
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> x$3 = this.copy$default$2();
            return this.copy(x$2, x$3, x$1);
        }

        public KindErrors $plus$plus(KindErrors errs) {
            return new KindErrors(this.scala$reflect$internal$Kinds$KindErrors$$$outer(), this.arity().$plus$plus(errs.arity(), List$.MODULE$.canBuildFrom()), this.variance().$plus$plus(errs.variance(), List$.MODULE$.canBuildFrom()), this.strictness().$plus$plus(errs.strictness(), List$.MODULE$.canBuildFrom()));
        }

        private String varStr(Symbols.Symbol s) {
            if (s.isCovariant()) {
                return "covariant";
            }
            if (s.isContravariant()) {
                return "contravariant";
            }
            return "invariant";
        }

        private String qualify(Symbols.Symbol a0, Symbols.Symbol b0) {
            String string = a0.toString();
            String string2 = b0.toString();
            if (string == null ? string2 != null : !string.equals(string2)) {
                return "";
            }
            if (a0 == b0 || a0.owner() == b0.owner()) {
                return "";
            }
            Symbols.Symbol a = a0;
            Symbols.Symbol b = b0;
            while (true) {
                Names.Name name = a.owner().name();
                Names.Name name2 = b.owner().name();
                if (name != null ? !name.equals(name2) : name2 != null) break;
                a = a.owner();
                b = b.owner();
            }
            if (a.locationString() != "") {
                return new StringBuilder(3).append(" (").append(a.locationString().trim()).append(")").toString();
            }
            return "";
        }

        private String kindMessage(Symbols.Symbol a, Symbols.Symbol p, Function2<String, String, String> f) {
            return f.apply(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(a), this.qualify(a, p)), Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(p), this.qualify(p, a)));
        }

        private String strictnessMessage(Symbols.Symbol a, Symbols.Symbol p) {
            String string = Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(p), this.qualify(p, a));
            String string2 = Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(a), this.qualify(a, p));
            return KindErrors.$anonfun$strictnessMessage$1(a, p, string2, string);
        }

        private String varianceMessage(Symbols.Symbol a, Symbols.Symbol p) {
            String string = Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(p), this.qualify(p, a));
            String string2 = Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(a), this.qualify(a, p));
            return KindErrors.$anonfun$varianceMessage$1(this, a, p, string2, string);
        }

        private String arityMessage(Symbols.Symbol a, Symbols.Symbol p) {
            String string = Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(p), this.qualify(p, a));
            String string2 = Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(a), this.qualify(a, p));
            return KindErrors.$anonfun$arityMessage$1(a, p, string2, string);
        }

        private String buildMessage(List<Tuple2<Symbols.Symbol, Symbols.Symbol>> xs, Function2<Symbols.Symbol, Symbols.Symbol, String> f) {
            if (xs.isEmpty()) {
                return "";
            }
            return ((TraversableOnce)xs.map(f.tupled(), List$.MODULE$.canBuildFrom())).mkString("\n", ", ", "");
        }

        /*
         * WARNING - void declaration
         */
        public String errorMessage(Types.Type targ, Symbols.Symbol tparam) {
            void buildMessage_f;
            void buildMessage_f2;
            void buildMessage_f3;
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> buildMessage_xs;
            Function2<Symbols.Symbol, Symbols.Symbol, String> & java.io.Serializable & Serializable intersect = (Function2<Symbols.Symbol, Symbols.Symbol, String> & java.io.Serializable & Serializable)(a, p) -> this.arityMessage((Symbols.Symbol)a, (Symbols.Symbol)p);
            StringBuilder stringBuilder = new StringBuilder(23).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(targ), "'s type parameters do not match ")).append(tparam).append("'s expected parameters:").append((buildMessage_xs = this.arity()).isEmpty() ? "" : ((TraversableOnce)buildMessage_xs.map(buildMessage_f3.tupled(), List$.MODULE$.canBuildFrom())).mkString("\n", ", ", ""));
            Function2<Symbols.Symbol, Symbols.Symbol, String> & java.io.Serializable & Serializable intersect2 = (Function2<Symbols.Symbol, Symbols.Symbol, String> & java.io.Serializable & Serializable)(a, p) -> this.varianceMessage((Symbols.Symbol)a, (Symbols.Symbol)p);
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> buildMessage_xs2 = this.variance();
            Function2<Symbols.Symbol, Symbols.Symbol, String> & java.io.Serializable & Serializable intersect3 = (Function2<Symbols.Symbol, Symbols.Symbol, String> & java.io.Serializable & Serializable)(a, p) -> this.strictnessMessage((Symbols.Symbol)a, (Symbols.Symbol)p);
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> buildMessage_xs3 = this.strictness();
            return stringBuilder.append(buildMessage_xs2.isEmpty() ? "" : ((TraversableOnce)buildMessage_xs2.map(buildMessage_f2.tupled(), List$.MODULE$.canBuildFrom())).mkString("\n", ", ", "")).append(buildMessage_xs3.isEmpty() ? "" : ((TraversableOnce)buildMessage_xs3.map(buildMessage_f.tupled(), List$.MODULE$.canBuildFrom())).mkString("\n", ", ", "")).toString();
        }

        public KindErrors copy(List<Tuple2<Symbols.Symbol, Symbols.Symbol>> arity, List<Tuple2<Symbols.Symbol, Symbols.Symbol>> variance, List<Tuple2<Symbols.Symbol, Symbols.Symbol>> strictness) {
            return new KindErrors(this.scala$reflect$internal$Kinds$KindErrors$$$outer(), arity, variance, strictness);
        }

        public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> copy$default$1() {
            return this.arity();
        }

        public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> copy$default$2() {
            return this.variance();
        }

        public List<Tuple2<Symbols.Symbol, Symbols.Symbol>> copy$default$3() {
            return this.strictness();
        }

        @Override
        public String productPrefix() {
            return "KindErrors";
        }

        @Override
        public int productArity() {
            return 3;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.arity();
                }
                case 1: {
                    return this.variance();
                }
                case 2: {
                    return this.strictness();
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
            return x$1 instanceof KindErrors;
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
            if (!(x$1 instanceof KindErrors)) return false;
            if (((KindErrors)x$1).scala$reflect$internal$Kinds$KindErrors$$$outer() != this.scala$reflect$internal$Kinds$KindErrors$$$outer()) return false;
            boolean bl = true;
            if (!bl) return false;
            KindErrors kindErrors = (KindErrors)x$1;
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> list = this.arity();
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> list2 = kindErrors.arity();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> list3 = this.variance();
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> list4 = kindErrors.variance();
            if (list3 == null) {
                if (list4 != null) {
                    return false;
                }
            } else if (!((Object)list3).equals(list4)) return false;
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> list5 = this.strictness();
            List<Tuple2<Symbols.Symbol, Symbols.Symbol>> list6 = kindErrors.strictness();
            if (list5 == null) {
                if (list6 != null) {
                    return false;
                }
            } else if (!((Object)list5).equals(list6)) return false;
            if (!kindErrors.canEqual(this)) return false;
            return true;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Kinds$KindErrors$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$strictnessMessage$1(Symbols.Symbol a$1, Symbols.Symbol p$1, String x$1, String x$2) {
            String string = "%s's bounds%s are stricter than %s's declared bounds%s";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Object[] objectArray = new Object[4];
            objectArray[0] = x$1;
            objectArray[1] = a$1.info();
            objectArray[2] = x$2;
            Types.Type type = p$1.info();
            String string2 = type instanceof Types.TypeBounds && ((Types.TypeBounds)type).isEmptyBounds() ? " >: Nothing <: Any" : String.valueOf(type);
            objectArray[3] = string2;
            return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(objectArray));
        }

        public static final /* synthetic */ String $anonfun$varianceMessage$1(KindErrors $this, Symbols.Symbol a$2, Symbols.Symbol p$2, String x$3, String x$4) {
            String string = "%s is %s, but %s is declared %s";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{x$3, $this.varStr(a$2), x$4, $this.varStr(p$2)}));
        }

        public static final /* synthetic */ String $anonfun$arityMessage$1(Symbols.Symbol a$3, Symbols.Symbol p$3, String x$5, String x$6) {
            String string = "%s has %s, but %s has %s";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{x$5, StringOps$.MODULE$.countElementsAsString(a$3.typeParams().length(), "type parameter"), x$6, StringOps$.MODULE$.countAsString(p$3.typeParams().length())}));
        }

        public KindErrors(SymbolTable $outer, List<Tuple2<Symbols.Symbol, Symbols.Symbol>> arity, List<Tuple2<Symbols.Symbol, Symbols.Symbol>> variance, List<Tuple2<Symbols.Symbol, Symbols.Symbol>> strictness) {
            this.arity = arity;
            this.variance = variance;
            this.strictness = strictness;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }

    public class ProperTypeKind
    extends Kind {
        private final Types.TypeBounds bounds;
        private final String description;
        private final int order;

        @Override
        public Types.TypeBounds bounds() {
            return this.bounds;
        }

        @Override
        public String description() {
            return this.description;
        }

        @Override
        public int order() {
            return this.order;
        }

        @Override
        public Kind.StringState buildState(Symbols.Symbol sym, int v, Kind.StringState s) {
            return s.append(Variance$.MODULE$.symbolicString$extension(v)).appendHead(this.order(), sym).append(this.bounds().scalaNotation((Function1<Types.Type, String> & java.io.Serializable & Serializable)x$11 -> x$11.toString()));
        }

        @Override
        public String scalaNotation() {
            return Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(new Kind.Head(this.scala$reflect$internal$Kinds$ProperTypeKind$$$outer().Kind(), this.order(), None$.MODULE$, None$.MODULE$)), this.bounds().scalaNotation((Function1<Types.Type, String> & java.io.Serializable & Serializable)x$12 -> x$12.toString()));
        }

        @Override
        public String starNotation() {
            return new StringBuilder(1).append("*").append(this.bounds().starNotation((Function1<Types.Type, String> & java.io.Serializable & Serializable)x$13 -> x$13.toString())).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Kinds$ProperTypeKind$$$outer() {
            return this.$outer;
        }

        public ProperTypeKind(SymbolTable $outer, Types.TypeBounds bounds) {
            this.bounds = bounds;
            super($outer);
            this.description = "This is a proper type.";
            this.order = 0;
        }
    }

    public class TypeConKind
    extends Kind {
        private final Types.TypeBounds bounds;
        private final Seq<Argument> args;
        private final int order;

        @Override
        public Types.TypeBounds bounds() {
            return this.bounds;
        }

        public Seq<Argument> args() {
            return this.args;
        }

        @Override
        public int order() {
            return this.order;
        }

        @Override
        public String description() {
            if (this.order() == 1) {
                return "This is a type constructor: a 1st-order-kinded type.";
            }
            return "This is a type constructor that takes type constructor(s): a higher-kinded type.";
        }

        @Override
        public boolean hasBounds() {
            return super.hasBounds() || this.args().exists((Function1<Argument, Object> & java.io.Serializable & Serializable)x$15 -> BoxesRunTime.boxToBoolean(TypeConKind.$anonfun$hasBounds$1(x$15)));
        }

        @Override
        public String scalaNotation() {
            Kind.StringState s = this.buildState(this.scala$reflect$internal$Kinds$TypeConKind$$$outer().NoSymbol(), Variance$.MODULE$.Invariant(), this.scala$reflect$internal$Kinds$TypeConKind$$$outer().Kind().StringState().empty()).removeOnes();
            return (this.hasBounds() ? s : s.removeAlias()).toString();
        }

        @Override
        public Kind.StringState buildState(Symbols.Symbol sym, int v, Kind.StringState s0) {
            ObjectRef<Kind.StringState> s = ObjectRef.create(s0);
            s.elem = ((Kind.StringState)s.elem).append(Variance$.MODULE$.symbolicString$extension(v)).appendHead(this.order(), sym).append("[");
            ((IterableLike)this.args().zipWithIndex(Seq$.MODULE$.canBuildFrom())).foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)x0$1 -> {
                TypeConKind.$anonfun$buildState$2(this, s, x0$1);
                return BoxedUnit.UNIT;
            });
            s.elem = ((Kind.StringState)s.elem).append("]").append(this.bounds().scalaNotation((Function1<Types.Type, String> & java.io.Serializable & Serializable)x$16 -> x$16.toString()));
            return (Kind.StringState)s.elem;
        }

        @Override
        public String starNotation() {
            return new StringBuilder(1).append(((TraversableOnce)this.args().map((Function1<Argument, String> & java.io.Serializable & Serializable)arg -> new StringBuilder(0).append(arg.kind().order() == 0 ? arg.kind().starNotation() : new StringBuilder(2).append("(").append(arg.kind().starNotation()).append(")").toString()).append((Object)(arg.variance() == Variance$.MODULE$.Invariant() ? " -> " : new StringBuilder(7).append(" -(").append(Variance$.MODULE$.symbolicString$extension(arg.variance())).append(")-> ").toString())).toString(), Seq$.MODULE$.canBuildFrom())).mkString()).append("*").append(this.bounds().starNotation((Function1<Types.Type, String> & java.io.Serializable & Serializable)x$17 -> x$17.toString())).toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Kinds$TypeConKind$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ int $anonfun$order$1(Argument x$14) {
            return x$14.kind().order();
        }

        public static final /* synthetic */ boolean $anonfun$hasBounds$1(Argument x$15) {
            return x$15.kind().hasBounds();
        }

        public static final /* synthetic */ void $anonfun$buildState$2(TypeConKind $this, ObjectRef s$1, Tuple2 x0$1) {
            if (x0$1 != null) {
                Argument arg = (Argument)x0$1._1();
                int i = x0$1._2$mcI$sp();
                s$1.elem = arg.kind().buildState(arg.sym(), arg.variance(), (Kind.StringState)s$1.elem);
                if (i != $this.args().size() - 1) {
                    s$1.elem = ((Kind.StringState)s$1.elem).append(",");
                    return;
                }
            } else {
                throw new MatchError((Object)null);
            }
        }

        public TypeConKind(SymbolTable $outer, Types.TypeBounds bounds, Seq<Argument> args2) {
            this.bounds = bounds;
            this.args = args2;
            super($outer);
            this.order = BoxesRunTime.unboxToInt(((TraversableOnce)args2.map((Function1<Argument, Object> & java.io.Serializable & Serializable)x$14 -> BoxesRunTime.boxToInteger(TypeConKind.$anonfun$order$1(x$14)), Seq$.MODULE$.canBuildFrom())).max(Ordering$Int$.MODULE$)) + 1;
        }

        public class Argument
        implements Product,
        Serializable {
            private final int variance;
            private final Kind kind;
            private final Symbols.Symbol sym;
            public final /* synthetic */ Kinds$TypeConKind$ $outer;

            public int variance() {
                return this.variance;
            }

            public Kind kind() {
                return this.kind;
            }

            public Symbols.Symbol sym() {
                return this.sym;
            }

            public Argument copy(int variance, Kind kind, Symbols.Symbol sym) {
                return new Argument(this.scala$reflect$internal$Kinds$TypeConKind$Argument$$$outer(), variance, kind, sym);
            }

            public int copy$default$1() {
                return this.variance();
            }

            public Kind copy$default$2() {
                return this.kind();
            }

            @Override
            public String productPrefix() {
                return "Argument";
            }

            @Override
            public int productArity() {
                return 2;
            }

            @Override
            public Object productElement(int x$1) {
                switch (x$1) {
                    case 0: {
                        return new Variance(this.variance());
                    }
                    case 1: {
                        return this.kind();
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
                return x$1 instanceof Argument;
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
                if (!(x$1 instanceof Argument)) return false;
                if (((Argument)x$1).scala$reflect$internal$Kinds$TypeConKind$Argument$$$outer() != this.scala$reflect$internal$Kinds$TypeConKind$Argument$$$outer()) return false;
                boolean bl = true;
                if (!bl) return false;
                Argument argument = (Argument)x$1;
                if (this.variance() != argument.variance()) return false;
                Kind kind = this.kind();
                Kind kind2 = argument.kind();
                if (kind == null) {
                    if (kind2 != null) {
                        return false;
                    }
                } else if (!kind.equals(kind2)) return false;
                if (!argument.canEqual(this)) return false;
                return true;
            }

            public /* synthetic */ Kinds$TypeConKind$ scala$reflect$internal$Kinds$TypeConKind$Argument$$$outer() {
                return this.$outer;
            }

            public Argument(Kinds$TypeConKind$ $outer, int variance, Kind kind, Symbols.Symbol sym) {
                this.variance = variance;
                this.kind = kind;
                this.sym = sym;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                Product.$init$(this);
            }
        }
    }
}

