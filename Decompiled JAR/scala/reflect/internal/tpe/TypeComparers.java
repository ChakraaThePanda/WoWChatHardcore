/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.tpe;

import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Product;
import scala.Serializable;
import scala.StringContext;
import scala.Tuple2;
import scala.collection.GenSeq;
import scala.collection.Iterator;
import scala.collection.LinearSeqLike;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.HashSet;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.AnnotationCheckers;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Depth$;
import scala.reflect.internal.Names;
import scala.reflect.internal.Reporting;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.TypesStats;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.settings.MutableSettings;
import scala.reflect.internal.settings.MutableSettings$;
import scala.reflect.internal.tpe.TypeComparers$SubTypePair$;
import scala.reflect.internal.tpe.TypeConstraints;
import scala.reflect.internal.tpe.TypeMaps;
import scala.reflect.internal.util.Collections;
import scala.reflect.internal.util.Statistics;
import scala.reflect.internal.util.StatisticsStatics;
import scala.reflect.internal.util.StripMarginInterpolator;
import scala.reflect.internal.util.TriState$;
import scala.reflect.internal.util.package$;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.runtime.java8.JFunction0$mcZ$sp;

@ScalaSignature(bytes="\u0006\u0001\rua!C A!\u0003\r\t!SB\f\u0011\u0015q\u0005\u0001\"\u0001P\u0011\u001d\u0019\u0006A1A\u0005\u000eQCqa\u0016\u0001C\u0002\u0013%\u0001\f\u0003\u0004\u0002h\u0001!\t\u0001\u0017\u0004\u0005G\u0002\u0011E\r\u0003\u0005l\u000b\tU\r\u0011\"\u0001m\u0011!\u0011XA!E!\u0002\u0013i\u0007\u0002C:\u0006\u0005+\u0007I\u0011\u00017\t\u0011Q,!\u0011#Q\u0001\n5DQ!^\u0003\u0005\u0002YDQ!_\u0003\u0005BiD\u0011\"a\u0002\u0006\u0003\u0003%\t!!\u0003\t\u0013\u0005=Q!%A\u0005\u0002\u0005E\u0001\"CA\u0014\u000bE\u0005I\u0011AA\t\u0011%\tI#BA\u0001\n\u0003\nY\u0003C\u0005\u0002.\u0015\t\t\u0011\"\u0001\u00020!I\u0011qG\u0003\u0002\u0002\u0013\u0005\u0011\u0011\b\u0005\n\u0003\u000b*\u0011\u0011!C!\u0003\u000fB\u0011\"!\u0015\u0006\u0003\u0003%\t!a\u0015\t\u0013\u0005uS!!A\u0005B\u0005}\u0003\"CA1\u000b\u0005\u0005I\u0011IA2\u000f%\tI\u0007AA\u0001\u0012\u0003\tYG\u0002\u0005d\u0001\u0005\u0005\t\u0012AA7\u0011\u0019)x\u0003\"\u0001\u0002|!9\u0011pFA\u0001\n\u000bR\b\"CA?/\u0005\u0005I\u0011QA@\u0011%\t)iFA\u0001\n\u0003\u000b9\tC\u0005\u0002\u001a\u0002\u0001\r\u0011\"\u0003\u00020!I\u00111\u0014\u0001A\u0002\u0013%\u0011Q\u0014\u0005\b\u0003C\u0003A\u0011AA\u0018\u0011\u001d\t\u0019\u000b\u0001C\u0001\u0003KCq!a+\u0001\t\u0013\ti\u000bC\u0004\u00028\u0002!I!!/\t\u000f\u0005E\u0007\u0001\"\u0003\u0002T\"9\u0011Q\u001c\u0001\u0005\n\u0005}\u0007bBAu\u0001\u0011\u0005\u00111\u001e\u0005\b\u0003c\u0004A\u0011AAz\u0011\u001d\tI\u0010\u0001C\u0005\u0003wDq!!?\u0001\t\u0013\u0011Y\u0001C\u0004\u0003\u0012\u0001!\tAa\u0005\t\u000f\te\u0001\u0001\"\u0003\u0003\u001c!9!\u0011\u0005\u0001\u0005\n\t\r\u0002b\u0002B\u0015\u0001\u0011%!1\u0006\u0005\b\u0005c\u0001A\u0011\u0002B\u001a\u0011\u001d\u0011I\u0004\u0001C\u0005\u0005wAqAa\u0012\u0001\t\u0013\u0011I\u0005C\u0004\u0003Z\u0001!IAa\u0017\t\u000f\tm\u0004\u0001\"\u0003\u0003~!9!1\u0011\u0001\u0005\n\t\u0015\u0005b\u0002BH\u0001\u0011\u0005!\u0011\u0013\u0005\b\u0005/\u0003A\u0011\u0001BM\u0011%\u0011Y\u000bAI\u0001\n\u0003\u0011i\u000bC\u0004\u00032\u0002!IAa-\t\u000f\t\u0015\u0007\u0001\"\u0003\u0003H\"9!q\u001a\u0001\u0005\n\tE\u0007b\u0002Bo\u0001\u0011%!q\u001c\u0005\b\u0005K\u0004A\u0011\u0002Bt\u0011\u001d\u0011i\u000f\u0001C\u0001\u0005_DqAa>\u0001\t\u0013\u0011I\u0010C\u0004\u0004\u0002\u0001!\taa\u0001\t\u000f\r%\u0001\u0001\"\u0001\u0004\f!91\u0011\u0003\u0001\u0005\n\rM!!\u0004+za\u0016\u001cu.\u001c9be\u0016\u00148O\u0003\u0002B\u0005\u0006\u0019A\u000f]3\u000b\u0005\r#\u0015\u0001C5oi\u0016\u0014h.\u00197\u000b\u0005\u00153\u0015a\u0002:fM2,7\r\u001e\u0006\u0002\u000f\u0006)1oY1mC\u000e\u00011C\u0001\u0001K!\tYE*D\u0001G\u0013\tieI\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003A\u0003\"aS)\n\u0005I3%\u0001B+oSR\f1\u0004T8h!\u0016tG-\u001b8h'V\u0014G+\u001f9fgRC'/Z:i_2$W#A+\u0010\u0003Yk\u0012AM\u0001\u0011?B,g\u000eZ5oON+(\rV=qKN,\u0012!\u0017\t\u00045~\u000bW\"A.\u000b\u0005qk\u0016aB7vi\u0006\u0014G.\u001a\u0006\u0003=\u001a\u000b!bY8mY\u0016\u001cG/[8o\u0013\t\u00017LA\u0004ICND7+\u001a;\u0011\u0005\t,Q\"\u0001\u0001\u0003\u0017M+(\rV=qKB\u000b\u0017N]\n\u0005\u000b)+\u0007\u000e\u0005\u0002LM&\u0011qM\u0012\u0002\b!J|G-^2u!\tY\u0015.\u0003\u0002k\r\na1+\u001a:jC2L'0\u00192mK\u0006\u0019A\u000f]\u0019\u0016\u00035\u0004\"A\u00198\n\u0005=\u0004(\u0001\u0002+za\u0016L!!\u001d\"\u0003\u000bQK\b/Z:\u0002\tQ\u0004\u0018\u0007I\u0001\u0004iB\u0014\u0014\u0001\u0002;qe\u0001\na\u0001P5oSRtDcA1xq\")1N\u0003a\u0001[\")1O\u0003a\u0001[\u0006AAo\\*ue&tw\rF\u0001|!\ra\u00181A\u0007\u0002{*\u0011ap`\u0001\u0005Y\u0006twM\u0003\u0002\u0002\u0002\u0005!!.\u0019<b\u0013\r\t)! \u0002\u0007'R\u0014\u0018N\\4\u0002\t\r|\u0007/\u001f\u000b\u0006C\u0006-\u0011Q\u0002\u0005\bW2\u0001\n\u00111\u0001n\u0011\u001d\u0019H\u0002%AA\u00025\fabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0002\u0002\u0014)\u001aQ.!\u0006,\u0005\u0005]\u0001\u0003BA\r\u0003Gi!!a\u0007\u000b\t\u0005u\u0011qD\u0001\nk:\u001c\u0007.Z2lK\u0012T1!!\tG\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003K\tYBA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fabY8qs\u0012\"WMZ1vYR$#'A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0002w\u0006a\u0001O]8ek\u000e$\u0018I]5usV\u0011\u0011\u0011\u0007\t\u0004\u0017\u0006M\u0012bAA\u001b\r\n\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR!\u00111HA!!\rY\u0015QH\u0005\u0004\u0003\u007f1%aA!os\"I\u00111I\t\u0002\u0002\u0003\u0007\u0011\u0011G\u0001\u0004q\u0012\n\u0014a\u00049s_\u0012,8\r^%uKJ\fGo\u001c:\u0016\u0005\u0005%\u0003CBA&\u0003\u001b\nY$D\u0001^\u0013\r\ty%\u0018\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0003\u0002V\u0005m\u0003cA&\u0002X%\u0019\u0011\u0011\f$\u0003\u000f\t{w\u000e\\3b]\"I\u00111I\n\u0002\u0002\u0003\u0007\u00111H\u0001\tQ\u0006\u001c\bnQ8eKR\u0011\u0011\u0011G\u0001\u0007KF,\u0018\r\\:\u0015\t\u0005U\u0013Q\r\u0005\n\u0003\u0007*\u0012\u0011!a\u0001\u0003w\tq\u0002]3oI&twmU;c)f\u0004Xm]\u0001\f'V\u0014G+\u001f9f!\u0006L'\u000f\u0005\u0002c/M!q#a\u001ci!\u001d\t\t(a\u001en[\u0006l!!a\u001d\u000b\u0007\u0005Ud)A\u0004sk:$\u0018.\\3\n\t\u0005e\u00141\u000f\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\u0014DCAA6\u0003\u0015\t\u0007\u000f\u001d7z)\u0015\t\u0017\u0011QAB\u0011\u0015Y'\u00041\u0001n\u0011\u0015\u0019(\u00041\u0001n\u0003\u001d)h.\u00199qYf$B!!#\u0002\u0016B)1*a#\u0002\u0010&\u0019\u0011Q\u0012$\u0003\r=\u0003H/[8o!\u0015Y\u0015\u0011S7n\u0013\r\t\u0019J\u0012\u0002\u0007)V\u0004H.\u001a\u001a\t\u0011\u0005]5$!AA\u0002\u0005\f1\u0001\u001f\u00131\u0003Yy6/\u001e2tC6,G/\u001f9f%\u0016\u001cWO]:j_:\u001c\u0018AG0tk\n\u001c\u0018-\\3usB,'+Z2veNLwN\\:`I\u0015\fHc\u0001)\u0002 \"I\u00111I\u000f\u0002\u0002\u0003\u0007\u0011\u0011G\u0001\u0016gV\u00147/Y7fif\u0004XMU3dkJ\u001c\u0018n\u001c8t\u0003e\u0019XOY:b[\u0016$\u0018\u0010]3SK\u000e,(o]5p]N|F%Z9\u0015\u0007A\u000b9\u000bC\u0004\u0002*~\u0001\r!!\r\u0002\u000bY\fG.^3\u0002\u0017%\u001cXK\\5gS\u0006\u0014G.\u001a\u000b\u0007\u0003+\ny+a-\t\r\u0005E\u0006\u00051\u0001n\u0003\u0011\u0001(/Z\u0019\t\r\u0005U\u0006\u00051\u0001n\u0003\u0011\u0001(/\u001a\u001a\u0002/%\u001c8+Y7f'B,7-[1mSj,GmU6pY\u0016lGCCA+\u0003w\u000bI-!4\u0002P\"9\u0011QX\u0011A\u0002\u0005}\u0016\u0001B:z[F\u00022AYAa\u0013\u0011\t\u0019-!2\u0003\rMKXNY8m\u0013\r\t9M\u0011\u0002\b'fl'm\u001c7t\u0011\u001d\tY-\ta\u0001\u0003\u007f\u000bAa]=ne!1\u0011\u0011W\u0011A\u00025Da!!.\"\u0001\u0004i\u0017\u0001C5t'V\u0014\u0007K]3\u0015\u0011\u0005U\u0013Q[Al\u00033Da!!-#\u0001\u0004i\u0007BBA[E\u0001\u0007Q\u000eC\u0004\u0002\\\n\u0002\r!a0\u0002\u0007MLX.\u0001\u000bfcV\fGnU=ng\u0006sG\r\u0015:fM&DXm\u001d\u000b\u000b\u0003+\n\t/a9\u0002f\u0006\u001d\bbBA_G\u0001\u0007\u0011q\u0018\u0005\u0007\u0003c\u001b\u0003\u0019A7\t\u000f\u0005-7\u00051\u0001\u0002@\"1\u0011QW\u0012A\u00025\fq\"[:ES\u001a4WM]3oiRK\b/\u001a\u000b\u0007\u0003+\ni/a<\t\u000b-$\u0003\u0019A7\t\u000bM$\u0003\u0019A7\u00025%\u001cH)\u001b4gKJ,g\u000e\u001e+za\u0016\u001cuN\\:ueV\u001cGo\u001c:\u0015\r\u0005U\u0013Q_A|\u0011\u0015YW\u00051\u0001n\u0011\u0015\u0019X\u00051\u0001n\u0003UI7oU1nKRK\b/Z\"p]N$(/^2u_J$b!!\u0016\u0002~\n\u001d\u0001bBA\u0000M\u0001\u0007!\u0011A\u0001\u0004iJ\f\u0004c\u00012\u0003\u0004%\u0019!Q\u00019\u0003\u000fQK\b/\u001a*fM\"9!\u0011\u0002\u0014A\u0002\t\u0005\u0011a\u0001;seQ1\u0011Q\u000bB\u0007\u0005\u001fAQa[\u0014A\u00025DQa]\u0014A\u00025\f!\"[:TC6,G+\u001f9f)\u0019\t)F!\u0006\u0003\u0018!)1\u000e\u000ba\u0001[\")1\u000f\u000ba\u0001[\u0006\u00112/Y7f\u0003:tw\u000e^1uK\u0012$\u0016\u0010]3t)\u0019\t)F!\b\u0003 !)1.\u000ba\u0001[\")1/\u000ba\u0001[\u0006Y\u0011n]*b[\u0016$\u0016\u0010]32)\u0019\t)F!\n\u0003(!)1N\u000ba\u0001[\")1O\u000ba\u0001[\u0006i\u0011n]*b[\u0016D5\nV=qKN$b!!\u0016\u0003.\t=\u0002\"B6,\u0001\u0004i\u0007\"B:,\u0001\u0004i\u0017!D5t'\u0006lW\rV=qKJ+g\r\u0006\u0004\u0002V\tU\"q\u0007\u0005\b\u0003\u007fd\u0003\u0019\u0001B\u0001\u0011\u001d\u0011I\u0001\fa\u0001\u0005\u0003\t1#[:TC6,7+\u001b8hY\u0016$xN\u001c+za\u0016$b!!\u0016\u0003>\t\u0015\u0003BB6.\u0001\u0004\u0011y\u0004E\u0002c\u0005\u0003J1Aa\u0011q\u00055\u0019\u0016N\\4mKR|g\u000eV=qK\"11/\fa\u0001\u0005\u007f\t\u0001#[:TC6,W*\u001a;i_\u0012$\u0016\u0010]3\u0015\r\u0005U#1\nB+\u0011\u001d\u0011iE\fa\u0001\u0005\u001f\n1!\u001c;2!\r\u0011'\u0011K\u0005\u0004\u0005'\u0002(AC'fi\"|G\rV=qK\"9!q\u000b\u0018A\u0002\t=\u0013aA7ue\u0005AR-];bYRK\b/\u001a)be\u0006l7/\u00118e%\u0016\u001cX\u000f\u001c;\u0015\u0015\u0005U#Q\fB8\u0005g\u00129\bC\u0004\u0003`=\u0002\rA!\u0019\u0002\u0011Q\u0004\u0018M]1ngF\u0002bAa\u0019\u0003j\u0005}fbA&\u0003f%\u0019!q\r$\u0002\u000fA\f7m[1hK&!!1\u000eB7\u0005\u0011a\u0015n\u001d;\u000b\u0007\t\u001dd\t\u0003\u0004\u0003r=\u0002\r!\\\u0001\u0005e\u0016\u001c\u0018\u0007C\u0004\u0003v=\u0002\rA!\u0019\u0002\u0011Q\u0004\u0018M]1ngJBaA!\u001f0\u0001\u0004i\u0017\u0001\u0002:fgJ\nq%\\3uQ>$\u0007*[4iKJ|%\u000fZ3s)f\u0004X\rU1sC6\u001c8+Y7f-\u0006\u0014\u0018.\u00198dKR1\u0011Q\u000bB@\u0005\u0003Cq!!01\u0001\u0004\ty\fC\u0004\u0002LB\u0002\r!a0\u0002M5,G\u000f[8e\u0011&<\u0007.\u001a:Pe\u0012,'\u000fV=qKB\u000b'/Y7t'V\u0014g+\u0019:jC:\u001cW\r\u0006\u0004\u0002V\t\u001d%1\u0012\u0005\b\u0005\u0013\u000b\u0004\u0019AA`\u0003\rawn\u001e\u0005\b\u0005\u001b\u000b\u0004\u0019AA`\u0003\u0011A\u0017n\u001a5\u0002\u0017%\u001c8+Y7f)f\u0004XM\r\u000b\u0007\u0003+\u0012\u0019J!&\t\u000b-\u0014\u0004\u0019A7\t\u000bM\u0014\u0004\u0019A7\u0002\u0013%\u001c8+\u001e2UsB,G\u0003CA+\u00057\u0013iJa(\t\u000b-\u001c\u0004\u0019A7\t\u000bM\u001c\u0004\u0019A7\t\u0013\t\u00056\u0007%AA\u0002\t\r\u0016!\u00023faRD\u0007\u0003\u0002BS\u0005Ok\u0011AQ\u0005\u0004\u0005S\u0013%!\u0002#faRD\u0017aE5t'V\u0014G+\u001f9fI\u0011,g-Y;mi\u0012\u001aTC\u0001BXU\u0011\u0011\u0019+!\u0006\u0002)QL\b/\u001a*fY\u0006$\u0018n\u001c8Qe\u0016\u001c\u0005.Z2l)\u0019\u0011)L!1\u0003DB!!q\u0017B_\u001b\t\u0011ILC\u0002\u0003<\n\u000bA!\u001e;jY&!!q\u0018B]\u0005!!&/[*uCR,\u0007\"B66\u0001\u0004i\u0007\"B:6\u0001\u0004i\u0017AC5t'V\u0014G+\u001f9fcQA\u0011Q\u000bBe\u0005\u0017\u0014i\rC\u0003lm\u0001\u0007Q\u000eC\u0003tm\u0001\u0007Q\u000eC\u0004\u0003\"Z\u0002\rAa)\u0002\u001b%\u001c\bk\u001c7z'V\u0014G+\u001f9f)\u0019\t)Fa5\u0003\\\"11n\u000ea\u0001\u0005+\u00042A\u0019Bl\u0013\r\u0011I\u000e\u001d\u0002\t!>d\u0017\u0010V=qK\"11o\u000ea\u0001\u0005+\fQ#[:UQ&\u001c\u0018I\u001c3TkB,'oU;cif\u0004X\r\u0006\u0004\u0002V\t\u0005(1\u001d\u0005\u0006Wb\u0002\r!\u001c\u0005\u0006gb\u0002\r!\\\u0001\u001aSNtu.\u0011:h'R\fG/[2DY\u0006\u001c8\u000fV=qKJ+g\r\u0006\u0003\u0002V\t%\bB\u0002Bvs\u0001\u0007Q.\u0001\u0002ua\u0006Y\u0011n\u001d%L'V\u0014G+\u001f9f)!\t)F!=\u0003t\nU\b\"B6;\u0001\u0004i\u0007\"B:;\u0001\u0004i\u0007b\u0002BQu\u0001\u0007!1U\u0001\u000bSN\u001cVO\u0019+za\u0016\u0014D\u0003CA+\u0005w\u0014iPa@\t\u000b-\\\u0004\u0019A7\t\u000bM\\\u0004\u0019A7\t\u000f\t\u00056\b1\u0001\u0003$\u0006i\u0011n],fC.\u001cVO\u0019+za\u0016$b!!\u0016\u0004\u0006\r\u001d\u0001\"B6=\u0001\u0004i\u0007\"B:=\u0001\u0004i\u0017\u0001E5t\u001dVlWM]5d'V\u0014G+\u001f9f)\u0019\t)f!\u0004\u0004\u0010!)1.\u0010a\u0001[\")1/\u0010a\u0001[\u0006\u0011\u0002O]5nSRLg/\u001a\"bg\u0016\u001cE.Y:t)\u0011\tyl!\u0006\t\r\t-h\b1\u0001n!\u0011\u0011)k!\u0007\n\u0007\rm!IA\u0006Ts6\u0014w\u000e\u001c+bE2,\u0007")
public interface TypeComparers {
    public TypeComparers$SubTypePair$ SubTypePair();

    public void scala$reflect$internal$tpe$TypeComparers$_setter_$scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes_$eq(HashSet<SubTypePair> var1);

    private int LogPendingSubTypesThreshold() {
        return 50;
    }

    public HashSet<SubTypePair> scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes();

    public static /* synthetic */ HashSet pendingSubTypes$(TypeComparers $this) {
        return $this.pendingSubTypes();
    }

    default public HashSet<SubTypePair> pendingSubTypes() {
        return this.scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes();
    }

    public int scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions();

    public void scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions_$eq(int var1);

    public static /* synthetic */ int subsametypeRecursions$(TypeComparers $this) {
        return $this.subsametypeRecursions();
    }

    default public int subsametypeRecursions() {
        return this.scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions();
    }

    public static /* synthetic */ void subsametypeRecursions_$eq$(TypeComparers $this, int value) {
        $this.subsametypeRecursions_$eq(value);
    }

    default public void subsametypeRecursions_$eq(int value) {
        this.scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions_$eq(value);
    }

    private boolean isUnifiable(Types.Type pre1, Types.Type pre2) {
        return (((Types)this).isEligibleForPrefixUnification(pre1) || ((Types)this).isEligibleForPrefixUnification(pre2)) && pre1.$eq$colon$eq(pre2);
    }

    private boolean isSameSpecializedSkolem(Symbols.Symbol sym1, Symbols.Symbol sym2, Types.Type pre1, Types.Type pre2) {
        if (sym1.isExistentialSkolem() && sym2.isExistentialSkolem()) {
            Names.Name name = sym1.name();
            Names.Name name2 = sym2.name();
            if (!(name != null ? !name.equals(name2) : name2 != null)) {
                if (((SymbolTable)this).phase().specialized() && sym1.info().$eq$colon$eq(sym2.info()) && pre1.$eq$colon$eq(pre2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private boolean isSubPre(Types.Type pre1, Types.Type pre2, Symbols.Symbol sym) {
        if (pre1 != pre2 && pre1 != ((Types)this).NoPrefix() && pre2 != ((Types)this).NoPrefix() && pre1.$less$colon$less(pre2)) {
            void reflectSettingToBoolean_s;
            MutableSettings.SettingValue settingValue = ((SymbolTable)this).settings().debug();
            if (MutableSettings$.MODULE$ == null) {
                throw null;
            }
            if (BoxesRunTime.unboxToBoolean(reflectSettingToBoolean_s.value())) {
                Predef$.MODULE$.println(new StringBuilder(20).append("new isSubPre ").append(sym).append(": ").append(pre1).append(" <:< ").append(pre2).toString());
            }
            return true;
        }
        return false;
    }

    private boolean equalSymsAndPrefixes(Symbols.Symbol sym1, Types.Type pre1, Symbols.Symbol sym2, Types.Type pre2) {
        if (sym1 == sym2) {
            return sym1.hasPackageFlag() || sym1.owner().hasPackageFlag() || ((SymbolTable)this).phase().erasedTypes() || pre1.$eq$colon$eq(pre2);
        }
        Names.Name name = sym1.name();
        Names.Name name2 = sym2.name();
        return !(name != null ? !name.equals(name2) : name2 != null) && this.isUnifiable(pre1, pre2);
    }

    public static /* synthetic */ boolean isDifferentType$(TypeComparers $this, Types.Type tp1, Types.Type tp2) {
        return $this.isDifferentType(tp1, tp2);
    }

    default public boolean isDifferentType(Types.Type tp1, Types.Type tp2) {
        boolean bl;
        try {
            this.subsametypeRecursions_$eq(this.subsametypeRecursions() + 1);
            bl = BoxesRunTime.unboxToBoolean(((TypeConstraints)((Object)this)).undoLog().undo((JFunction0$mcZ$sp & Serializable)() -> !this.isSameType1(tp1, tp2)));
        }
        finally {
            this.subsametypeRecursions_$eq(this.subsametypeRecursions() - 1);
        }
        return bl;
    }

    public static /* synthetic */ boolean isDifferentTypeConstructor$(TypeComparers $this, Types.Type tp1, Types.Type tp2) {
        return $this.isDifferentTypeConstructor(tp1, tp2);
    }

    default public boolean isDifferentTypeConstructor(Types.Type tp1, Types.Type tp2) {
        return !this.isSameTypeConstructor(tp1, tp2);
    }

    private boolean isSameTypeConstructor(Types.TypeRef tr1, Types.TypeRef tr2) {
        return tr1.sym() == tr2.sym() && !this.isDifferentType(tr1.pre(), tr2.pre());
    }

    private boolean isSameTypeConstructor(Types.Type tp1, Types.Type tp2) {
        return tp1 instanceof Types.TypeRef && tp2 instanceof Types.TypeRef && this.isSameTypeConstructor((Types.TypeRef)tp1, (Types.TypeRef)tp2);
    }

    public static /* synthetic */ boolean isSameType$(TypeComparers $this, Types.Type tp1, Types.Type tp2) {
        return $this.isSameType(tp1, tp2);
    }

    /*
     * WARNING - void declaration
     */
    default public boolean isSameType(Types.Type tp1, Types.Type tp2) {
        boolean bl;
        try {
            if (StatisticsStatics.areSomeColdStatsEnabled()) {
                void incCounter_c;
                Statistics statistics = ((SymbolTable)this).statistics();
                Statistics.Counter counter = ((TypesStats)((Object)((SymbolTable)this).statistics())).sametypeCount();
                if (statistics == null) {
                    throw null;
                }
                if (statistics.areColdStatsLocallyEnabled() && incCounter_c != null) {
                    incCounter_c.value_$eq(incCounter_c.value() + 1);
                }
            }
            this.subsametypeRecursions_$eq(this.subsametypeRecursions() + 1);
            List<TypeConstraints.UndoPair<Types.TypeVar, TypeConstraints.TypeConstraint>> before = ((TypeConstraints)((Object)this)).undoLog().log();
            boolean result2 = false;
            try {
                result2 = this.isSameType1(tp1, tp2);
            }
            finally {
                if (!result2) {
                    ((TypeConstraints)((Object)this)).undoLog().undoTo(before);
                }
            }
            bl = result2;
        }
        finally {
            this.subsametypeRecursions_$eq(this.subsametypeRecursions() - 1);
        }
        return bl;
    }

    private boolean sameAnnotatedTypes(Types.Type tp1, Types.Type tp2) {
        return ((AnnotationCheckers)((Object)this)).annotationsConform(tp1, tp2) && ((AnnotationCheckers)((Object)this)).annotationsConform(tp2, tp1) && tp1.withoutAnnotations().$eq$colon$eq(tp2.withoutAnnotations());
    }

    private boolean isSameType1(Types.Type tp1, Types.Type tp2) {
        int n = this.typeRelationPreCheck(tp1, tp2);
        boolean bl = TriState$.MODULE$.isKnown$extension(n) ? TriState$.MODULE$.booleanValue$extension(n) : (tp1 instanceof Types.AnnotatedType || tp2 instanceof Types.AnnotatedType ? this.sameAnnotatedTypes(tp1, tp2) : this.isSameType2(tp1, tp2));
        return bl;
    }

    private boolean isSameHKTypes(Types.Type tp1, Types.Type tp2) {
        return tp1.isHigherKinded() && tp2.isHigherKinded() && tp1.normalize().$eq$colon$eq(tp2.normalize());
    }

    private boolean isSameTypeRef(Types.TypeRef tr1, Types.TypeRef tr2) {
        return this.equalSymsAndPrefixes(tr1.sym(), tr1.pre(), tr2.sym(), tr2.pre()) && (this.isSameHKTypes(tr1, tr2) || ((Types)this).isSameTypes(tr1.args(), tr2.args()));
    }

    private boolean isSameSingletonType(Types.SingletonType tp1, Types.SingletonType tp2) {
        Types.Type origin1 = this.chaseDealiasedUnderlying$1(tp1);
        Types.Type origin2 = this.chaseDealiasedUnderlying$1(tp2);
        return (origin1 != tp1 || origin2 != tp2) && origin1.$eq$colon$eq(origin2);
    }

    private boolean isSameMethodType(Types.MethodType mt1, Types.MethodType mt2) {
        return ((Types)this).isSameTypes(mt1.paramTypes(), mt2.paramTypes()) && mt1.resultType().$eq$colon$eq(mt2.resultType().substSym(mt2.params(), mt1.params())) && mt1.isImplicit() == mt2.isImplicit();
    }

    private boolean equalTypeParamsAndResult(List<Symbols.Symbol> tparams1, Types.Type res1, List<Symbols.Symbol> tparams2, Types.Type res2) {
        if (((Collections)((Object)this)).sameLength(tparams1, tparams2)) {
            boolean bl;
            block5: {
                if (tparams1 == null) {
                    throw null;
                }
                List<Symbols.Symbol> list = tparams2;
                LinearSeqLike corresponds_this = tparams1;
                while (true) {
                    GenSeq corresponds_that;
                    if (corresponds_this.isEmpty()) {
                        bl = corresponds_that.isEmpty();
                        break block5;
                    }
                    if (!corresponds_that.nonEmpty()) break;
                    Symbols.Symbol symbol = (Symbols.Symbol)corresponds_that.head();
                    Symbols.Symbol symbol2 = (Symbols.Symbol)corresponds_this.head();
                    if (!TypeComparers.$anonfun$equalTypeParamsAndResult$1(this, tparams2, tparams1, symbol2, symbol)) break;
                    corresponds_that = (GenSeq)corresponds_that.tail();
                    corresponds_this = (LinearSeqLike)corresponds_this.tail();
                }
                bl = false;
            }
            if (bl && res1.$eq$colon$eq(TypeComparers.subst$1(res2, tparams2, tparams1))) {
                return true;
            }
        }
        return false;
    }

    private boolean methodHigherOrderTypeParamsSameVariance(Symbols.Symbol sym1, Symbols.Symbol sym2) {
        return !((SymbolTable)this).settings().isScala211() || TypeComparers.ignoreVariance$1(sym1) || TypeComparers.ignoreVariance$1(sym2) || sym1.variance() == sym2.variance();
    }

    private boolean methodHigherOrderTypeParamsSubVariance(Symbols.Symbol low, Symbols.Symbol high) {
        return !((SymbolTable)this).settings().isScala211() || this.methodHigherOrderTypeParamsSameVariance(low, high) || Variance$.MODULE$.isInvariant$extension(low.variance());
    }

    public static /* synthetic */ boolean isSameType2$(TypeComparers $this, Types.Type tp1, Types.Type tp2) {
        return $this.isSameType2(tp1, tp2);
    }

    default public boolean isSameType2(Types.Type tp1, Types.Type tp2) {
        return this.sameTypeAndSameCaseClass$1(tp1, tp2) || this.sameSingletonType$1(tp1, tp2) || TypeComparers.mutateNonTypeConstructs$1(tp1, tp2, tp1) || TypeComparers.mutateNonTypeConstructs$1(tp2, tp1, tp1) || this.retry$1(tp1, tp2);
    }

    public static /* synthetic */ boolean isSubType$(TypeComparers $this, Types.Type tp1, Types.Type tp2, int depth) {
        return $this.isSubType(tp1, tp2, depth);
    }

    default public boolean isSubType(Types.Type tp1, Types.Type tp2, int depth) {
        boolean bl;
        try {
            this.subsametypeRecursions_$eq(this.subsametypeRecursions() + 1);
            List<TypeConstraints.UndoPair<Types.TypeVar, TypeConstraints.TypeConstraint>> before = ((TypeConstraints)((Object)this)).undoLog().log();
            boolean result2 = false;
            try {
                boolean bl2;
                if (this.subsametypeRecursions() >= 50) {
                    SubTypePair p = new SubTypePair((SymbolTable)this, tp1, tp2);
                    if (this.pendingSubTypes().apply(p)) {
                        bl2 = false;
                    } else {
                        try {
                            this.pendingSubTypes().$plus$eq((Object)p);
                            bl2 = this.isSubType1(tp1, tp2, depth);
                        }
                        finally {
                            this.pendingSubTypes().$minus$eq((Object)p);
                        }
                    }
                } else {
                    bl2 = this.isSubType1(tp1, tp2, depth);
                }
                result2 = bl2;
            }
            finally {
                if (!result2) {
                    ((TypeConstraints)((Object)this)).undoLog().undoTo(before);
                }
            }
            bl = result2;
        }
        finally {
            this.subsametypeRecursions_$eq(this.subsametypeRecursions() - 1);
        }
        return bl;
    }

    public static /* synthetic */ int isSubType$default$3$(TypeComparers $this) {
        return $this.isSubType$default$3();
    }

    default public int isSubType$default$3() {
        return Depth$.MODULE$.AnyDepth();
    }

    private int typeRelationPreCheck(Types.Type tp1, Types.Type tp2) {
        if (this.isTrue$1(tp1, tp2)) {
            return TriState$.MODULE$.True();
        }
        if (this.isFalse$1(tp1, tp2)) {
            return TriState$.MODULE$.False();
        }
        return TriState$.MODULE$.Unknown();
    }

    private boolean isSubType1(Types.Type tp1, Types.Type tp2, int depth) {
        int n = this.typeRelationPreCheck(tp1, tp2);
        boolean bl = TriState$.MODULE$.isKnown$extension(n) ? TriState$.MODULE$.booleanValue$extension(n) : (tp1 instanceof Types.AnnotatedType || tp2 instanceof Types.AnnotatedType ? ((AnnotationCheckers)((Object)this)).annotationsConform(tp1, tp2) && tp1.withoutAnnotations().$less$colon$less(tp2.withoutAnnotations()) : this.isSubType2(tp1, tp2, depth));
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private boolean isPolySubType(Types.PolyType tp1, Types.PolyType tp2) {
        void var8_8;
        void var7_7;
        void var4_4;
        void var3_3;
        if (tp1 == null) {
            throw new MatchError((Object)null);
        }
        List<Symbols.Symbol> tparams1 = tp1.typeParams();
        Types.Type res1 = tp1.resultType();
        void tparams12 = var3_3;
        void res12 = var4_4;
        if (tp2 == null) {
            throw new MatchError((Object)null);
        }
        List<Symbols.Symbol> tparams2 = tp2.typeParams();
        Types.Type res2 = tp2.resultType();
        void tparams22 = var7_7;
        void res22 = var8_8;
        if (((Collections)((Object)this)).sameLength((List<?>)tparams12, (List<?>)tparams22)) {
            boolean bl;
            void substitutes;
            boolean isMethod;
            block6: {
                isMethod = ((Symbols.Symbol)tparams12.head()).owner().isMethod();
                substitutes = isMethod ? tparams12 : ((Symbols)((Object)this)).cloneSymbols((List<Symbols.Symbol>)tparams12);
                void var14_13 = tparams22;
                LinearSeqLike corresponds_this = tparams12;
                while (true) {
                    GenSeq corresponds_that;
                    if (corresponds_this.isEmpty()) {
                        bl = corresponds_that.isEmpty();
                        break block6;
                    }
                    if (!corresponds_that.nonEmpty()) break;
                    Symbols.Symbol symbol = (Symbols.Symbol)corresponds_that.head();
                    Symbols.Symbol symbol2 = (Symbols.Symbol)corresponds_this.head();
                    if (!this.cmp$1(symbol2, symbol, (List)tparams22, (List)substitutes, isMethod, (List)tparams12)) break;
                    corresponds_that = (GenSeq)corresponds_that.tail();
                    corresponds_this = (LinearSeqLike)corresponds_this.tail();
                }
                bl = false;
            }
            if (bl && TypeComparers.sub1$1((Types.Type)res12, isMethod, (List)tparams12, (List)substitutes).$less$colon$less(TypeComparers.sub2$1((Types.Type)res22, (List)tparams22, (List)substitutes))) {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isThisAndSuperSubtype(Types.Type tp1, Types.Type tp2) {
        Types.Type type = tp1;
        Types.Type type2 = tp2;
        if (!(type instanceof Types.SingleType)) return false;
        Types.SingleType singleType = (Types.SingleType)type;
        Types.Type type3 = singleType.pre();
        Symbols.Symbol v1 = singleType.sym();
        if (!(type3 instanceof Types.ThisType)) return false;
        Symbols.Symbol lpre = ((Types.ThisType)type3).sym();
        if (!(type2 instanceof Types.SingleType)) return false;
        Types.SingleType singleType2 = (Types.SingleType)type2;
        Types.Type type4 = singleType2.pre();
        Symbols.Symbol v2 = singleType2.sym();
        if (!(type4 instanceof Types.SuperType)) return false;
        Types.Type type5 = ((Types.SuperType)type4).thistpe();
        if (!(type5 instanceof Types.ThisType)) return false;
        Symbols.Symbol rpre = ((Types.ThisType)type5).sym();
        if (lpre != rpre) return false;
        if (!v1.overrideChain().contains(v2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isNoArgStaticClassTypeRef(Types.Type tp) {
        if (!(tp instanceof Types.TypeRef)) return false;
        Types.TypeRef typeRef = (Types.TypeRef)tp;
        Symbols.Symbol sym = typeRef.sym();
        List<Types.Type> list = typeRef.args();
        if (!((Object)Nil$.MODULE$).equals(list)) return false;
        if (!sym.isClass()) return false;
        if (!sym.isStatic()) return false;
        return true;
    }

    public static /* synthetic */ boolean isHKSubType$(TypeComparers $this, Types.Type tp1, Types.Type tp2, int depth) {
        return $this.isHKSubType(tp1, tp2, depth);
    }

    default public boolean isHKSubType(Types.Type tp1, Types.Type tp2, int depth) {
        return tp1.typeSymbol() == ((Definitions)((Object)this)).definitions().NothingClass() || tp2.typeSymbol() == ((Definitions)((Object)this)).definitions().AnyClass() || (this.isNoArgStaticClassTypeRef(tp1) && this.isNoArgStaticClassTypeRef(tp2) ? tp1.typeSymbolDirect().isNonBottomSubClass(tp2.typeSymbolDirect()) : this.isSub$1(tp1.withoutAnnotations(), tp2.withoutAnnotations(), tp1, tp2) && ((AnnotationCheckers)((Object)this)).annotationsConform(tp1, tp2));
    }

    private boolean isSubType2(Types.Type tp1, Types.Type tp2, int depth) {
        if (((Types)this).isSingleType(tp1) && ((Types)this).isSingleType(tp2) || ((Types)this).isConstantType(tp1) && ((Types)this).isConstantType(tp2)) {
            return tp1.$eq$colon$eq(tp2) || this.isThisAndSuperSubtype(tp1, tp2) || this.retry$2(tp1.underlying(), tp2, tp1, tp2, depth);
        }
        if (tp1.isHigherKinded() || tp2.isHigherKinded()) {
            return this.isHKSubType(tp1, tp2, depth);
        }
        return this.firstTry$1(tp2, tp1, depth);
    }

    public static /* synthetic */ boolean isWeakSubType$(TypeComparers $this, Types.Type tp1, Types.Type tp2) {
        return $this.isWeakSubType(tp1, tp2);
    }

    /*
     * Unable to fully structure code
     */
    default public boolean isWeakSubType(Types.Type tp1, Types.Type tp2) {
        block5: {
            block6: {
                block4: {
                    var6_3 = tp1.dealiasWiden();
                    if (!(var6_3 instanceof Types.TypeRef)) break block4;
                    sym1 = ((Types.TypeRef)var6_3).sym();
                    if (!((Definitions)this).definitions().isNumericValueClass(sym1)) break block4;
                    var8_5 = tp2.deconst().dealias();
                    if (!(var8_5 instanceof Types.TypeRef)) ** GOTO lbl-1000
                    sym2 = ((Types.TypeRef)var8_5).sym();
                    if (((Definitions)this).definitions().isNumericValueClass(sym2)) {
                        var5_7 = ((Definitions)this).definitions().isNumericSubClass(sym1, sym2);
                    } else lbl-1000:
                    // 2 sources

                    {
                        var5_7 = var8_5 instanceof Types.TypeVar != false ? ((Types.TypeVar)var8_5).registerBound(tp1, true, true) : this.isSubType(tp1, tp2, this.isSubType$default$3());
                    }
                    var3_8 = var5_7;
                    break block5;
                }
                if (!(var6_3 instanceof Types.TypeVar)) break block6;
                var10_9 = (Types.TypeVar)var6_3;
                var11_10 = tp2.deconst().dealias();
                if (!(var11_10 instanceof Types.TypeRef)) ** GOTO lbl-1000
                sym2 = ((Types.TypeRef)var11_10).sym();
                if (((Definitions)this).definitions().isNumericValueClass(sym2)) {
                    var4_12 = var10_9.registerBound(tp2, false, true);
                } else lbl-1000:
                // 2 sources

                {
                    var4_12 = this.isSubType(tp1, tp2, this.isSubType$default$3());
                }
                var3_8 = var4_12;
                break block5;
            }
            var3_8 = this.isSubType(tp1, tp2, this.isSubType$default$3());
        }
        return var3_8;
    }

    public static /* synthetic */ boolean isNumericSubType$(TypeComparers $this, Types.Type tp1, Types.Type tp2) {
        return $this.isNumericSubType(tp1, tp2);
    }

    default public boolean isNumericSubType(Types.Type tp1, Types.Type tp2) {
        return ((Definitions)((Object)this)).definitions().isNumericSubClass(this.primitiveBaseClass(tp1.dealiasWiden()), this.primitiveBaseClass(tp2.dealias()));
    }

    private Symbols.Symbol primitiveBaseClass(Types.Type tp) {
        return this.loop$1(tp.baseClasses());
    }

    private Types.Type chaseDealiasedUnderlying$1(Types.Type tp) {
        Types.SingletonType singletonType;
        Types.Type type;
        while ((type = tp.underlying().dealias()) instanceof Types.SingletonType && tp != (singletonType = (Types.SingletonType)type)) {
            tp = singletonType;
            TypeComparers this_ = (SymbolTable)this_;
        }
        return tp;
    }

    private static Types.Type subst$1(Types.Type info, List tparams2$1, List tparams1$1) {
        return info.substSym(tparams2$1, tparams1$1);
    }

    public static /* synthetic */ boolean $anonfun$equalTypeParamsAndResult$1(TypeComparers $this, List tparams2$1, List tparams1$1, Symbols.Symbol p1, Symbols.Symbol p2) {
        return $this.methodHigherOrderTypeParamsSameVariance(p1, p2) && p1.info().$eq$colon$eq(TypeComparers.subst$1(p2.info(), tparams2$1, tparams1$1));
    }

    private static boolean ignoreVariance$1(Symbols.Symbol sym) {
        return !sym.isHigherOrderTypeParameter() || !sym.logicallyEnclosingMember().isMethod();
    }

    private boolean retry$1(Types.Type tp1$2, Types.Type tp2$2) {
        if (!(this.isNoArgStaticClassTypeRef(tp1$2) && this.isNoArgStaticClassTypeRef(tp2$2))) {
            Types.Type lhs = ((Types)this).normalizePlus(tp1$2);
            Types.Type rhs = ((Types)this).normalizePlus(tp2$2);
            if ((lhs != tp1$2 || rhs != tp2$2) && this.isSameType(lhs, rhs)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean mutateNonTypeConstructs$1(Types.Type lhs, Types.Type rhs, Types.Type tp1$2) {
        if (lhs instanceof Types.BoundedWildcardType) {
            return ((Types.BoundedWildcardType)lhs).bounds().containsType(rhs);
        }
        if (lhs instanceof Types.TypeVar) {
            return ((Types.TypeVar)lhs).registerTypeEquality(rhs, lhs == tp1$2);
        }
        if (!(lhs instanceof Types.TypeRef)) return false;
        Types.TypeRef typeRef = (Types.TypeRef)lhs;
        Types.Type tv = typeRef.pre();
        Symbols.Symbol sym = typeRef.sym();
        if (!(tv instanceof Types.TypeVar)) return false;
        return ((Types.TypeVar)tv).registerTypeSelection(sym, rhs);
    }

    private boolean sameSingletonType$1(Types.Type tp1$2, Types.Type tp2$2) {
        boolean bl;
        if (tp1$2 instanceof Types.SingletonType) {
            boolean bl2;
            Types.SingletonType singletonType = (Types.SingletonType)tp1$2;
            if (tp2$2 instanceof Types.SingletonType) {
                Types.SingletonType singletonType2 = (Types.SingletonType)tp2$2;
                bl2 = this.isSameSingletonType(singletonType, singletonType2);
            } else {
                bl2 = false;
            }
            bl = bl2;
        } else {
            bl = false;
        }
        return bl;
    }

    private boolean sameTypeAndSameCaseClass$1(Types.Type tp1$2, Types.Type tp2$2) {
        boolean bl;
        if (tp1$2 instanceof Types.TypeRef) {
            boolean bl2;
            Types.TypeRef typeRef = (Types.TypeRef)tp1$2;
            if (tp2$2 instanceof Types.TypeRef) {
                Types.TypeRef typeRef2 = (Types.TypeRef)tp2$2;
                bl2 = this.isSameTypeRef(typeRef, typeRef2);
            } else {
                bl2 = false;
            }
            bl = bl2;
        } else if (tp1$2 instanceof Types.MethodType) {
            boolean bl3;
            Types.MethodType methodType = (Types.MethodType)tp1$2;
            if (tp2$2 instanceof Types.MethodType) {
                Types.MethodType methodType2 = (Types.MethodType)tp2$2;
                bl3 = this.isSameMethodType(methodType, methodType2);
            } else {
                bl3 = false;
            }
            bl = bl3;
        } else if (tp1$2 instanceof Types.RefinedType) {
            boolean bl4;
            Types.RefinedType refinedType = (Types.RefinedType)tp1$2;
            List<Types.Type> ps1 = refinedType.parents();
            Scopes.Scope decls1 = refinedType.decls();
            if (tp2$2 instanceof Types.RefinedType) {
                Types.RefinedType refinedType2 = (Types.RefinedType)tp2$2;
                List<Types.Type> ps2 = refinedType2.parents();
                Scopes.Scope decls2 = refinedType2.decls();
                bl4 = ((Types)this).isSameTypes(ps1, ps2) && decls1.isSameScope(decls2);
            } else {
                bl4 = false;
            }
            bl = bl4;
        } else if (tp1$2 instanceof Types.SingleType) {
            boolean bl5;
            Types.SingleType singleType = (Types.SingleType)tp1$2;
            Types.Type pre1 = singleType.pre();
            Symbols.Symbol sym1 = singleType.sym();
            if (tp2$2 instanceof Types.SingleType) {
                Types.SingleType singleType2 = (Types.SingleType)tp2$2;
                Types.Type pre2 = singleType2.pre();
                Symbols.Symbol sym2 = singleType2.sym();
                bl5 = this.equalSymsAndPrefixes(sym1, pre1, sym2, pre2);
            } else {
                bl5 = false;
            }
            bl = bl5;
        } else if (tp1$2 instanceof Types.PolyType) {
            boolean bl6;
            Types.PolyType polyType = (Types.PolyType)tp1$2;
            List<Symbols.Symbol> ps1 = polyType.typeParams();
            Types.Type res1 = polyType.resultType();
            if (tp2$2 instanceof Types.PolyType) {
                Types.PolyType polyType2 = (Types.PolyType)tp2$2;
                List<Symbols.Symbol> ps2 = polyType2.typeParams();
                Types.Type res2 = polyType2.resultType();
                bl6 = this.equalTypeParamsAndResult(ps1, res1, ps2, res2);
            } else {
                bl6 = false;
            }
            bl = bl6;
        } else if (tp1$2 instanceof Types.ExistentialType) {
            boolean bl7;
            Types.ExistentialType existentialType = (Types.ExistentialType)tp1$2;
            List<Symbols.Symbol> qs1 = existentialType.quantified();
            Types.Type res1 = existentialType.underlying();
            if (tp2$2 instanceof Types.ExistentialType) {
                Types.ExistentialType existentialType2 = (Types.ExistentialType)tp2$2;
                List<Symbols.Symbol> qs2 = existentialType2.quantified();
                Types.Type res2 = existentialType2.underlying();
                bl7 = this.equalTypeParamsAndResult(qs1, res1, qs2, res2);
            } else {
                bl7 = false;
            }
            bl = bl7;
        } else if (tp1$2 instanceof Types.ThisType) {
            Symbols.Symbol sym2;
            Symbols.Symbol sym1 = ((Types.ThisType)tp1$2).sym();
            boolean bl8 = tp2$2 instanceof Types.ThisType ? sym1 == (sym2 = ((Types.ThisType)tp2$2).sym()) : false;
            bl = bl8;
        } else if (tp1$2 instanceof Types.ConstantType) {
            boolean bl9;
            Constants.Constant c1 = ((Types.ConstantType)tp1$2).value();
            if (tp2$2 instanceof Types.ConstantType) {
                Constants.Constant c2 = ((Types.ConstantType)tp2$2).value();
                Constants.Constant constant = c1;
                bl9 = !(constant != null ? !((Object)constant).equals(c2) : c2 != null);
            } else {
                bl9 = false;
            }
            bl = bl9;
        } else if (tp1$2 instanceof Types.NullaryMethodType) {
            boolean bl10;
            Types.Type res1 = ((Types.NullaryMethodType)tp1$2).resultType();
            if (tp2$2 instanceof Types.NullaryMethodType) {
                Types.Type res2 = ((Types.NullaryMethodType)tp2$2).resultType();
                bl10 = res1.$eq$colon$eq(res2);
            } else {
                bl10 = false;
            }
            bl = bl10;
        } else if (tp1$2 instanceof Types.TypeBounds) {
            boolean bl11;
            Types.TypeBounds typeBounds = (Types.TypeBounds)tp1$2;
            Types.Type lo1 = typeBounds.lo();
            Types.Type hi1 = typeBounds.hi();
            if (tp2$2 instanceof Types.TypeBounds) {
                Types.TypeBounds typeBounds2 = (Types.TypeBounds)tp2$2;
                Types.Type lo2 = typeBounds2.lo();
                Types.Type hi2 = typeBounds2.hi();
                bl11 = lo1.$eq$colon$eq(lo2) && hi1.$eq$colon$eq(hi2);
            } else {
                bl11 = false;
            }
            bl = bl11;
        } else {
            bl = false;
        }
        return bl;
    }

    private boolean isTrue$1(Types.Type tp1$3, Types.Type tp2$3) {
        return tp1$3 == tp2$3 || ((Types)this).isErrorOrWildcard(tp1$3) || ((Types)this).isErrorOrWildcard(tp2$3) || tp1$3 == ((Types)this).NoPrefix() && tp2$3.typeSymbol().isPackageClass() || tp2$3 == ((Types)this).NoPrefix() && tp1$3.typeSymbol().isPackageClass();
    }

    private boolean isFalse$1(Types.Type tp1$3, Types.Type tp2$3) {
        return tp1$3 == ((Types)this).NoType() || tp2$3 == ((Types)this).NoType() || tp1$3 == ((Types)this).NoPrefix() || tp2$3 == ((Types)this).NoPrefix();
    }

    private static Types.Type sub1$1(Types.Type tp, boolean isMethod$1, List tparams1$2, List substitutes$1) {
        if (isMethod$1) {
            return tp;
        }
        return tp.substSym(tparams1$2, substitutes$1);
    }

    private static Types.Type sub2$1(Types.Type tp, List tparams2$2, List substitutes$1) {
        return tp.substSym(tparams2$2, substitutes$1);
    }

    private boolean cmp$1(Symbols.Symbol p1, Symbols.Symbol p2, List tparams2$2, List substitutes$1, boolean isMethod$1, List tparams1$2) {
        return this.methodHigherOrderTypeParamsSubVariance(p2, p1) && TypeComparers.sub2$1(p2.info(), tparams2$2, substitutes$1).$less$colon$less(TypeComparers.sub1$1(p1.info(), isMethod$1, tparams1$2, substitutes$1));
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isSubHKTypeVar$1(Types.Type tp1, Types.Type tp2) {
        GenSeq corresponds_that;
        void corresponds_that2;
        Tuple2<Types.Type, Types.Type> tuple2 = new Tuple2<Types.Type, Types.Type>(tp1, tp2);
        Types.Type tv1 = tp1;
        Types.Type tv2 = tp2;
        if (tv1 instanceof Types.TypeVar) {
            Types.TypeVar typeVar = (Types.TypeVar)tv1;
            if (tv2 instanceof Types.TypeVar) {
                Types.TypeVar typeVar2 = (Types.TypeVar)tv2;
                ((Reporting)((Object)this)).reporter().warning(typeVar.typeSymbol().pos(), ((StripMarginInterpolator)((SymbolTable)this).StringContextStripMarginOps().apply(new StringContext(Predef$.MODULE$.wrapRefArray((Object[])new String[]{"|compiler bug: Unexpected code path: testing two type variables for subtype relation:\n               |  ", " <:< ", "\n               |Please report bug at https://github.com/scala/bug/issues\n            "})))).sm(Predef$.MODULE$.genericWrapArray(new Object[]{typeVar, typeVar2})).trim());
                return false;
            }
        }
        Types.Type tp12 = tp1;
        Types.Type tv22 = tp2;
        if (tv22 instanceof Types.TypeVar) {
            GenSeq corresponds_that3;
            void corresponds_that4;
            Types.TypeVar typeVar = (Types.TypeVar)tv22;
            Types.Type ntp1 = tp12.normalize();
            List<Symbols.Symbol> list = typeVar.params();
            List<Symbols.Symbol> list2 = ntp1.typeParams();
            if (list == null) {
                throw null;
            }
            void var19_14 = corresponds_that4;
            List<Symbols.Symbol> list3 = list;
            while (true) {
                void var18_16;
                if (var18_16.isEmpty()) break;
                if (!corresponds_that3.nonEmpty()) return false;
                Symbols.Symbol symbol = (Symbols.Symbol)corresponds_that3.head();
                Symbols.Symbol symbol2 = (Symbols.Symbol)var18_16.head();
                if (!this.methodHigherOrderTypeParamsSubVariance(symbol2, symbol)) return false;
                corresponds_that3 = (GenSeq)corresponds_that3.tail();
                LinearSeqLike linearSeqLike = (LinearSeqLike)var18_16.tail();
            }
            boolean bl = corresponds_that3.isEmpty();
            if (!bl) return false;
            typeVar.addLoBound(ntp1, typeVar.addLoBound$default$2());
            return true;
        }
        if (tuple2 == null) return false;
        Types.Type tv12 = tp1;
        Types.Type tp22 = tp2;
        if (!(tv12 instanceof Types.TypeVar)) return false;
        Types.TypeVar typeVar = (Types.TypeVar)tv12;
        Types.Type ntp2 = tp22.normalize();
        List<Symbols.Symbol> list = ntp2.typeParams();
        List<Symbols.Symbol> list4 = typeVar.params();
        if (list == null) {
            throw null;
        }
        void var23_26 = corresponds_that2;
        List<Symbols.Symbol> list5 = list;
        while (true) {
            void var22_28;
            if (var22_28.isEmpty()) break;
            if (!corresponds_that.nonEmpty()) return false;
            Symbols.Symbol symbol = (Symbols.Symbol)corresponds_that.head();
            Symbols.Symbol symbol3 = (Symbols.Symbol)var22_28.head();
            if (!this.methodHigherOrderTypeParamsSubVariance(symbol3, symbol)) return false;
            corresponds_that = (GenSeq)corresponds_that.tail();
            LinearSeqLike linearSeqLike = (LinearSeqLike)var22_28.tail();
        }
        boolean bl = corresponds_that.isEmpty();
        if (!bl) return false;
        typeVar.addHiBound(ntp2, typeVar.addHiBound$default$2());
        return true;
    }

    private boolean isSub$1(Types.Type tp1, Types.Type tp2, Types.Type tp1$4, Types.Type tp2$4) {
        return ((SymbolTable)this).settings().isScala213() && this.isSubHKTypeVar$1(tp1, tp2) || this.isSub2$1(tp1.normalize(), tp2.normalize(), tp1$4, tp2$4);
    }

    public static /* synthetic */ boolean $anonfun$isHKSubType$3(Symbols.Symbol x$3) {
        return x$3.tpe().isWildcard();
    }

    private static String tp_s$1(Types.Type tp) {
        String arg$macro$2 = package$.MODULE$.shortClassOfInstance(tp);
        return new StringOps("%-20s %s").format(Predef$.MODULE$.genericWrapArray(new Object[]{tp, arg$macro$2}));
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isSub2$1(Types.Type ntp1, Types.Type ntp2, Types.Type tp1$4, Types.Type tp2$4) {
        Types.Type type;
        Tuple2<Types.Type, Types.Type> tuple2 = new Tuple2<Types.Type, Types.Type>(ntp1, ntp2);
        Types.Type type2 = ntp1;
        if (type2 instanceof Types.TypeRef) {
            Symbols.Symbol symbol = ((Types.TypeRef)type2).sym();
            Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().AnyClass();
            if (classSymbol == null) {
                if (symbol == null) return false;
            } else if (classSymbol.equals(symbol)) {
                return false;
            }
        }
        if ((type = ntp2) instanceof Types.TypeRef) {
            Symbols.Symbol symbol = ((Types.TypeRef)type).sym();
            if (((Definitions)((Object)this)).definitions().NothingClass().equals(symbol)) {
                return false;
            }
        }
        if (tuple2 != null) {
            Types.Type pt1 = ntp1;
            Types.Type pt2 = ntp2;
            if (pt1 instanceof Types.PolyType) {
                Types.PolyType polyType = (Types.PolyType)pt1;
                if (pt2 instanceof Types.PolyType) {
                    Types.PolyType polyType2 = (Types.PolyType)pt2;
                    return this.isPolySubType(polyType, polyType2);
                }
            }
        }
        if (tuple2 != null) {
            Types.Type type3 = ntp2;
            if (ntp1 instanceof Types.PolyType && type3 instanceof Types.MethodType) {
                void var17_18;
                List<Symbols.Symbol> ps = ((Types.MethodType)type3).params();
                if (ps == null) {
                    throw null;
                }
                List<Symbols.Symbol> list = ps;
                while (!var17_18.isEmpty()) {
                    if (TypeComparers.$anonfun$isHKSubType$3((Symbols.Symbol)var17_18.head())) {
                        return false;
                    }
                    LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var17_18.tail();
                }
                boolean bl = false;
                if (bl) {
                    return false;
                }
            }
        }
        ((SymbolTable)this).devWarning((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(79).append("HK subtype check on ").append(tp1$4).append(" and ").append(tp2$4).append(", but both don't normalize to polytypes:\n  tp1=").append(TypeComparers.tp_s$1(ntp1)).append("\n  tp2=").append(TypeComparers.tp_s$1(ntp2)).toString());
        return false;
    }

    private boolean retry$2(Types.Type lhs, Types.Type rhs, Types.Type tp1$5, Types.Type tp2$5, int depth$1) {
        return (lhs != tp1$5 || rhs != tp2$5) && this.isSubType(lhs, rhs, depth$1);
    }

    /*
     * Unable to fully structure code
     */
    private boolean firstTry$1(Types.Type tp2$5, Types.Type tp1$5, int depth$1) {
        block13: {
            block8: {
                block12: {
                    block9: {
                        block11: {
                            block10: {
                                if (!(tp2$5 instanceof Types.TypeRef)) break block8;
                                var8_4 = (Types.TypeRef)tp2$5;
                                if (!(tp1$5 instanceof Types.TypeRef)) break block9;
                                var9_5 = (Types.TypeRef)tp1$5;
                                sym1 = var9_5.sym();
                                sym2 = var8_4.sym();
                                pre1 = var9_5.pre();
                                pre2 = var8_4.pre();
                                if (sym1 != sym2) break block10;
                                v0 = ((SymbolTable)this).phase().erasedTypes() || sym1.rawowner().hasPackageFlag() || this.isSubType(pre1, pre2, depth$1);
                                break block11;
                            }
                            v1 = sym1.name();
                            var14_10 = sym2.name();
                            if (v1 != null ? v1.equals(var14_10) == false : var14_10 != null) ** GOTO lbl-1000
                            if (!sym1.isModuleClass() && !sym2.isModuleClass() && (this.isUnifiable(pre1, pre2) || this.isSameSpecializedSkolem(sym1, sym2, pre1, pre2) || sym2.isAbstractType() && this.isSubPre(pre1, pre2, sym2))) {
                                v0 = true;
                            } else lbl-1000:
                            // 2 sources

                            {
                                v0 = false;
                            }
                        }
                        var7_12 = v0 != false && ((Types)this).isSubArgs(var9_5.args(), var8_4.args(), sym1.typeParams(), depth$1) != false || sym2.isClass() != false && ((base = var9_5.baseType(sym2)) != var9_5 && base != ((Types)this).NoType() && this.isSubType(base, var8_4, depth$1) != false) != false || this.thirdTryRef$1(var9_5, var8_4, depth$1, tp1$5, tp2$5) != false;
                        break block12;
                    }
                    var7_12 = this.secondTry$1(tp1$5, tp2$5, depth$1);
                }
                var4_13 = var7_12;
                break block13;
            }
            if (tp2$5 instanceof Types.AnnotatedType) {
                var4_13 = this.isSubType(tp1$5.withoutAnnotations(), tp2$5.withoutAnnotations(), depth$1) != false && ((AnnotationCheckers)this).annotationsConform(tp1$5, tp2$5) != false;
            } else if (tp2$5 instanceof Types.BoundedWildcardType) {
                bounds = ((Types.BoundedWildcardType)tp2$5).bounds();
                var4_13 = this.isSubType(tp1$5, bounds.hi(), depth$1);
            } else if (tp2$5 instanceof Types.TypeVar) {
                var17_15 = (Types.TypeVar)tp2$5;
                var6_16 = tp1$5 instanceof Types.AnnotatedType != false ? true : tp1$5 instanceof Types.BoundedWildcardType != false;
                var5_17 = var6_16 != false ? this.secondTry$1(tp1$5, tp2$5, depth$1) : var17_15.registerBound(tp1$5, true, var17_15.registerBound$default$3());
                var4_13 = var5_17;
            } else {
                var4_13 = this.secondTry$1(tp1$5, tp2$5, depth$1);
            }
        }
        return var4_13;
    }

    private boolean secondTry$1(Types.Type tp1$5, Types.Type tp2$5, int depth$1) {
        boolean bl;
        if (tp1$5 instanceof Types.AnnotatedType) {
            bl = this.isSubType(tp1$5.withoutAnnotations(), tp2$5.withoutAnnotations(), depth$1) && ((AnnotationCheckers)((Object)this)).annotationsConform(tp1$5, tp2$5);
        } else if (tp1$5 instanceof Types.BoundedWildcardType) {
            bl = this.isSubType(tp1$5.lowerBound(), tp2$5, depth$1);
        } else if (tp1$5 instanceof Types.TypeVar) {
            Types.TypeVar typeVar = (Types.TypeVar)tp1$5;
            bl = typeVar.registerBound(tp2$5, false, typeVar.registerBound$default$3());
        } else if (tp1$5 instanceof Types.ExistentialType) {
            boolean bl2;
            try {
                ((Types)this).skolemizationLevel_$eq(((Types)this).skolemizationLevel() + 1);
                bl2 = this.isSubType(tp1$5.skolemizeExistential(), tp2$5, depth$1);
            }
            finally {
                ((Types)this).skolemizationLevel_$eq(((Types)this).skolemizationLevel() - 1);
            }
            bl = bl2;
        } else {
            bl = this.thirdTry$1(tp2$5, tp1$5, depth$1);
        }
        return bl;
    }

    private boolean retry$3(Types.Type lhs, Types.Type rhs, int depth$1) {
        return this.isSubType(lhs, rhs, depth$1);
    }

    private boolean abstractTypeOnRight$1(Types.Type lo, Types.TypeRef tp2$6, Types.Type tp1$6, int depth$1) {
        return this.isDifferentTypeConstructor(tp2$6, lo) && this.retry$3(tp1$6, lo, depth$1);
    }

    private boolean classOnRight$1(Types.TypeRef tp2$6, Types.Type tp1$6, Symbols.Symbol sym2$1, int depth$1, Types.Type tp1$5, Types.Type tp2$5) {
        if (((Types)this).isRawType(tp2$6)) {
            return this.retry$3(tp1$6, ((TypeMaps)((Object)this)).rawToExistential().apply(tp2$6), depth$1);
        }
        if (sym2$1.isRefinementClass()) {
            return this.retry$3(tp1$6, sym2$1.info(), depth$1);
        }
        return this.fourthTry$1(tp1$5, tp2$5, depth$1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean thirdTryRef$1(Types.Type tp1, Types.TypeRef tp2, int depth$1, Types.Type tp1$5, Types.Type tp2$5) {
        Symbols.Symbol sym2 = tp2.sym();
        boolean bl = false;
        Symbols.ClassSymbol classSymbol = ((Definitions)((Object)this)).definitions().SingletonClass();
        if (!(classSymbol != null ? !classSymbol.equals(sym2) : sym2 != null)) {
            if (tp1.isStable()) return true;
            if (!this.fourthTry$1(tp1$5, tp2$5, depth$1)) return false;
            return true;
        }
        if (sym2 instanceof Symbols.ClassSymbol) {
            return this.classOnRight$1(tp2, tp1, sym2, depth$1, tp1$5, tp2$5);
        }
        if (sym2 instanceof Symbols.TypeSymbol) {
            bl = true;
            Symbols.TypeSymbol cfr_ignored_0 = (Symbols.TypeSymbol)sym2;
            if (sym2.isDeferred()) {
                if (this.abstractTypeOnRight$1(tp2.lowerBound(), tp2, tp1, depth$1)) return true;
                if (!this.fourthTry$1(tp1$5, tp2$5, depth$1)) return false;
                return true;
            }
        }
        if (!bl) return this.fourthTry$1(tp1$5, tp2$5, depth$1);
        return this.retry$3(((Types)this).normalizePlus(tp1), ((Types)this).normalizePlus(tp2), depth$1);
    }

    public static /* synthetic */ boolean $anonfun$isSubType2$2(TypeComparers $this, Types.Type tp1$5, int depth$1, Symbols.Symbol x$5) {
        return ((Types)$this).specializesSym(tp1$5, x$5, depth$1);
    }

    private boolean thirdTry$1(Types.Type tp2$5, Types.Type tp1$5, int depth$1) {
        boolean bl;
        if (tp2$5 instanceof Types.TypeRef) {
            Types.TypeRef typeRef = (Types.TypeRef)tp2$5;
            bl = this.thirdTryRef$1(tp1$5, typeRef, depth$1, tp1$5, tp2$5);
        } else if (tp2$5 instanceof Types.RefinedType) {
            boolean bl2;
            Types.RefinedType refinedType;
            block21: {
                refinedType = (Types.RefinedType)tp2$5;
                List<Types.Type> list = refinedType.parents();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized forall_these = list;
                while (!forall_these.isEmpty()) {
                    Types.Type type = (Types.Type)forall_these.head();
                    if (!this.isSubType(tp1$5, type, depth$1)) {
                        bl2 = false;
                        break block21;
                    }
                    forall_these = (LinearSeqOptimized)forall_these.tail();
                }
                bl2 = true;
            }
            bl = bl2 && refinedType.decls().forall((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$5 -> BoxesRunTime.boxToBoolean(TypeComparers.$anonfun$isSubType2$2(this, tp1$5, depth$1, x$5)));
        } else if (tp2$5 instanceof Types.ExistentialType) {
            bl = ((Types.ExistentialType)tp2$5).withTypeVars((Function1<Types.Type, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToBoolean(this.isSubType(tp1$5, x$6, depth$1)), depth$1) || this.fourthTry$1(tp1$5, tp2$5, depth$1);
        } else if (tp2$5 instanceof Types.MethodType) {
            boolean bl3;
            Types.MethodType methodType = (Types.MethodType)tp2$5;
            if (tp1$5 instanceof Types.MethodType) {
                Types.MethodType methodType2 = (Types.MethodType)tp1$5;
                List<Symbols.Symbol> params1 = methodType2.params();
                Types.Type res1 = methodType2.resultType();
                List<Symbols.Symbol> params2 = methodType.params();
                Types.Type res2 = methodType.resultType();
                bl3 = ((Collections)((Object)this)).sameLength(params1, params2) && methodType2.isImplicit() == methodType.isImplicit() && ((Types)this).matchingParams(params1, params2, methodType2.isJava(), methodType.isJava()) && this.isSubType(res1.substSym(params1, params2), res2, depth$1);
            } else {
                bl3 = false;
            }
            bl = bl3;
        } else if (tp2$5 instanceof Types.NullaryMethodType) {
            boolean bl4;
            Types.NullaryMethodType nullaryMethodType = (Types.NullaryMethodType)tp2$5;
            if (tp1$5 instanceof Types.NullaryMethodType) {
                Types.NullaryMethodType nullaryMethodType2 = (Types.NullaryMethodType)tp1$5;
                bl4 = this.isSubType(nullaryMethodType2.resultType(), nullaryMethodType.resultType(), depth$1);
            } else {
                bl4 = false;
            }
            bl = bl4;
        } else if (tp2$5 instanceof Types.TypeBounds) {
            boolean bl5;
            Types.TypeBounds typeBounds = (Types.TypeBounds)tp2$5;
            Types.Type lo2 = typeBounds.lo();
            Types.Type hi2 = typeBounds.hi();
            if (tp1$5 instanceof Types.TypeBounds) {
                Types.TypeBounds typeBounds2 = (Types.TypeBounds)tp1$5;
                Types.Type lo1 = typeBounds2.lo();
                Types.Type hi1 = typeBounds2.hi();
                bl5 = this.isSubType(lo2, lo1, depth$1) && this.isSubType(hi1, hi2, depth$1);
            } else {
                bl5 = false;
            }
            bl = bl5;
        } else {
            bl = this.fourthTry$1(tp1$5, tp2$5, depth$1);
        }
        return bl;
    }

    private boolean retry$4(Types.Type lhs, Types.Type rhs, Types.Type tp1$5, Types.Type tp2$5, int depth$1) {
        return (tp1$5 != lhs || tp2$5 != rhs) && this.isSubType(lhs, rhs, depth$1);
    }

    private boolean abstractTypeOnLeft$1(Types.Type hi, Types.Type tp1$5, Types.Type tp2$5, int depth$1) {
        return this.isDifferentTypeConstructor(tp1$5, hi) && this.retry$4(hi, tp2$5, tp1$5, tp2$5, depth$1);
    }

    private boolean nullOnLeft$1(Types.Type tp2$5, Symbols.Symbol sym1$1, Types.Type tp1$5, int depth$1) {
        boolean bl;
        if (tp2$5 instanceof Types.TypeRef) {
            Symbols.Symbol sym2 = ((Types.TypeRef)tp2$5).sym();
            bl = sym1$1.isBottomSubClass(sym2);
        } else {
            bl = ((Types)this).isSingleType(tp2$5) && this.retry$4(tp1$5, tp2$5.widen(), tp1$5, tp2$5, depth$1);
        }
        return bl;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean fourthTry$1(Types.Type tp1$5, Types.Type tp2$5, int depth$1) {
        block15: {
            block8: {
                block10: {
                    block14: {
                        block13: {
                            block12: {
                                block11: {
                                    block9: {
                                        if (!(tp1$5 instanceof Types.TypeRef)) break block8;
                                        sym1 = ((Types.TypeRef)tp1$5).sym();
                                        var7_5 = false;
                                        var8_6 = false;
                                        if (!((Definitions)this).definitions().NothingClass().equals(sym1)) break block9;
                                        var5_7 = true;
                                        break block10;
                                    }
                                    if (!((Definitions)this).definitions().NullClass().equals(sym1)) break block11;
                                    var5_7 = this.nullOnLeft$1(tp2$5, sym1, tp1$5, depth$1);
                                    break block10;
                                }
                                if (!(sym1 instanceof Symbols.ClassSymbol)) break block12;
                                var7_5 = true;
                                (Symbols.ClassSymbol)sym1;
                                if (!((Types)this).isRawType(tp1$5)) break block12;
                                var5_7 = this.retry$4(((Types)this).normalizePlus(tp1$5), ((Types)this).normalizePlus(tp2$5), tp1$5, tp2$5, depth$1);
                                break block10;
                            }
                            if (!var7_5 || !sym1.isModuleClass()) break block13;
                            var5_7 = this.retry$4(((Types)this).normalizePlus(tp1$5), ((Types)this).normalizePlus(tp2$5), tp1$5, tp2$5, depth$1);
                            break block10;
                        }
                        if (!var7_5 || !sym1.isRefinementClass()) break block14;
                        var5_7 = this.retry$4(sym1.info(), tp2$5, tp1$5, tp2$5, depth$1);
                        break block10;
                    }
                    if (!(sym1 instanceof Symbols.TypeSymbol)) ** GOTO lbl-1000
                    var8_6 = true;
                    (Symbols.TypeSymbol)sym1;
                    if (sym1.isDeferred()) {
                        var5_7 = this.abstractTypeOnLeft$1(tp1$5.upperBound(), tp1$5, tp2$5, depth$1);
                    } else lbl-1000:
                    // 2 sources

                    {
                        var5_7 = var8_6 != false ? this.retry$4(((Types)this).normalizePlus(tp1$5), ((Types)this).normalizePlus(tp2$5), tp1$5, tp2$5, depth$1) : false;
                    }
                }
                var4_8 = var5_7;
                break block15;
            }
            if (tp1$5 instanceof Types.RefinedType) {
                block7: {
                    parents = ((Types.RefinedType)tp1$5).parents();
                    if (parents == null) {
                        throw null;
                    }
                    exists_these /* !! */  = parents;
                    while (!exists_these /* !! */ .isEmpty()) {
                        var12_11 = (Types.Type)exists_these /* !! */ .head();
                        if (TypeComparers.$anonfun$isSubType2$4(this, tp2$5, tp1$5, depth$1, var12_11)) {
                            var11_12 = true;
                            break block7;
                        }
                        exists_these /* !! */  = (LinearSeqOptimized)exists_these /* !! */ .tail();
                    }
                    var11_12 = false;
                }
                var4_8 = var11_12;
            } else {
                var4_8 = tp1$5 instanceof Types.SingletonType != false ? this.retry$4(tp1$5.underlying(), tp2$5, tp1$5, tp2$5, depth$1) : false;
            }
        }
        return var4_8;
    }

    private Symbols.Symbol loop$1(List bases) {
        Symbols.Symbol symbol;
        block2: {
            block3: {
                Symbols.Symbol x;
                while (true) {
                    if (((Object)Nil$.MODULE$).equals(bases)) {
                        symbol = ((Symbols)((Object)this_)).NoSymbol();
                        break block2;
                    }
                    if (!(bases instanceof $colon$colon)) break block3;
                    $colon$colon $colon$colon = ($colon$colon)bases;
                    x = (Symbols.Symbol)$colon$colon.head();
                    List xs = $colon$colon.tl$access$1();
                    if (((Definitions)((Object)this_)).definitions().isPrimitiveValueClass(x)) break;
                    bases = xs;
                    TypeComparers this_ = (SymbolTable)this_;
                }
                symbol = x;
                break block2;
            }
            throw new MatchError(bases);
        }
        return symbol;
    }

    public static void $init$(TypeComparers $this) {
        $this.scala$reflect$internal$tpe$TypeComparers$_setter_$scala$reflect$internal$tpe$TypeComparers$$_pendingSubTypes_$eq(new HashSet<SubTypePair>());
        $this.scala$reflect$internal$tpe$TypeComparers$$_subsametypeRecursions_$eq(0);
    }

    public static /* synthetic */ Object $anonfun$equalTypeParamsAndResult$1$adapted(TypeComparers $this, List tparams2$1, List tparams1$1, Symbols.Symbol p1, Symbols.Symbol p2) {
        return BoxesRunTime.boxToBoolean(TypeComparers.$anonfun$equalTypeParamsAndResult$1($this, tparams2$1, tparams1$1, p1, p2));
    }

    public static /* synthetic */ Object $anonfun$isPolySubType$1$adapted(TypeComparers $this, List tparams2$2, List substitutes$1, boolean isMethod$1, List tparams1$2, Symbols.Symbol p1, Symbols.Symbol p2) {
        return BoxesRunTime.boxToBoolean($this.cmp$1(p1, p2, tparams2$2, substitutes$1, isMethod$1, tparams1$2));
    }

    public static /* synthetic */ Object $anonfun$isHKSubType$1$adapted(TypeComparers $this, Symbols.Symbol low, Symbols.Symbol high) {
        return BoxesRunTime.boxToBoolean($this.methodHigherOrderTypeParamsSubVariance(low, high));
    }

    public static /* synthetic */ Object $anonfun$isHKSubType$2$adapted(TypeComparers $this, Symbols.Symbol low, Symbols.Symbol high) {
        return BoxesRunTime.boxToBoolean($this.methodHigherOrderTypeParamsSubVariance(low, high));
    }

    public static /* synthetic */ Object $anonfun$isHKSubType$3$adapted(Symbols.Symbol x$3) {
        return BoxesRunTime.boxToBoolean(TypeComparers.$anonfun$isHKSubType$3(x$3));
    }

    public static /* synthetic */ Object $anonfun$isSubType2$1$adapted(TypeComparers $this, Types.Type tp1$5, int depth$1, Types.Type x$4) {
        return BoxesRunTime.boxToBoolean($this.isSubType(tp1$5, x$4, depth$1));
    }

    public static /* synthetic */ Object $anonfun$isSubType2$4$adapted(TypeComparers $this, Types.Type tp2$5, Types.Type tp1$5, int depth$1, Types.Type x$7) {
        return BoxesRunTime.boxToBoolean($this.retry$4(x$7, tp2$5, tp1$5, tp2$5, depth$1));
    }

    public final class SubTypePair
    implements Product,
    Serializable {
        private final Types.Type tp1;
        private final Types.Type tp2;
        private final /* synthetic */ SymbolTable $outer;

        public Types.Type tp1() {
            return this.tp1;
        }

        public Types.Type tp2() {
            return this.tp2;
        }

        public String toString() {
            return new StringBuilder(0).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(this.tp1()), " <:<? ")).append(this.tp2()).toString();
        }

        public SubTypePair copy(Types.Type tp1, Types.Type tp2) {
            return new SubTypePair(this.$outer, tp1, tp2);
        }

        public Types.Type copy$default$1() {
            return this.tp1();
        }

        public Types.Type copy$default$2() {
            return this.tp2();
        }

        @Override
        public String productPrefix() {
            return "SubTypePair";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.tp1();
                }
                case 1: {
                    return this.tp2();
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
            return x$1 instanceof SubTypePair;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof SubTypePair)) return false;
            boolean bl = true;
            if (!bl) return false;
            SubTypePair subTypePair = (SubTypePair)x$1;
            Types.Type type = this.tp1();
            Types.Type type2 = subTypePair.tp1();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            Types.Type type3 = this.tp2();
            Types.Type type4 = subTypePair.tp2();
            if (type3 == null) {
                if (type4 == null) return true;
                return false;
            } else {
                if (!type3.equals(type4)) return false;
                return true;
            }
        }

        public SubTypePair(SymbolTable $outer, Types.Type tp1, Types.Type tp2) {
            this.tp1 = tp1;
            this.tp2 = tp2;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }
}

