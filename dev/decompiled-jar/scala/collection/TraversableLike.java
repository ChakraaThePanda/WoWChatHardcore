/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractIterator;
import scala.collection.GenMap;
import scala.collection.GenSeq;
import scala.collection.GenSet;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableLike;
import scala.collection.GenTraversableOnce;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.Traversable$;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.HasNewBuilder;
import scala.collection.generic.SliceInterval;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.HashSet$;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.TreeSet;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.Map$;
import scala.collection.mutable.StringBuilder;
import scala.collection.package$;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.ParIterable$;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BooleanRef;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.java8.JFunction0$mcV$sp;

@ScalaSignature(bytes="\u0006\u0001\u0011-ca\u0002\"D!\u0003\r\t\u0001\u0013\u0005\u0006e\u0002!\ta]\u0003\u0007o\u0002\u0001\u000b\u0011\u0003/\t\u000ba\u0004A\u0011A=\t\u000bi\u0004AQA>\t\u000f}\u0004\u0001\u0015\"\u0005\u0002\u0002!A\u0011\u0011\u0002\u0001!\n#\tY\u0001\u0003\u0005\u0002\u0010\u0001\u0001k\u0011CA\t\u0011!\ty\u0002\u0001Q\u0005\u0012\u0005\u0005\u0002bBA\u0015\u0001\u0019\u0005\u00111\u0006\u0005\u0007\u0003\u007f\u0001A\u0011A>\t\r\u0005\u0005\u0003\u0001\"\u0001|\u0011\u001d\t\u0019\u0005\u0001C\u0001\u0003\u000bBq!!\u001c\u0001\t\u0003\ty\u0007C\u0004\u0002n\u0001!\t!!\"\t\u000f\u0005m\u0005\u0001\"\u0001\u0002\u001e\"9\u00111\u0017\u0001\u0005\u0002\u0005U\u0006\u0002CAg\u0001\u0011\u0005Q)a4\t\u0011\u0005m\u0007\u0001)C\u0005\u0003;Dq!a?\u0001\t\u0003\ti\u0010C\u0004\u0003\u0002\u0001!\tAa\u0001\t\u000f\t\u001d\u0001\u0001\"\u0001\u0003\n!9!Q\u0005\u0001\u0005\u0002\t\u001d\u0002b\u0002B\u0019\u0001\u0011\u0005!1\u0007\u0005\b\u0005\u000f\u0002A\u0011\u0001B%\u0011\u001d\u0011i\u0005\u0001C\u0001\u0005\u001fBqAa\u0015\u0001\t\u0003\u0011)\u0006C\u0004\u0003`\u0001!\tA!\u0019\t\u000f\t\u0015\u0005\u0001\"\u0001\u0003\b\"9!\u0011\u0015\u0001\u0005\u0002\t\r\u0006b\u0002Bj\u0001\u0011\u0005!Q\u001b\u0005\b\u0005/\u0004A\u0011\u0001Bm\u0011\u0019\u0011Y\u000e\u0001C!s\"9!Q\u001c\u0001\u0005\u0002\tU\u0007b\u0002Bp\u0001\u0011\u0005!\u0011\u001c\u0005\u0007\u0005C\u0004A\u0011A=\t\u000f\t\r\b\u0001\"\u0001\u0003f\"9!\u0011\u001f\u0001\u0005\u0002\tM\bb\u0002B|\u0001\u0011\u0005!\u0011 \u0005\t\u0007\u0007\u0001\u0001\u0015\"\u0003\u0004\u0006!A1q\u0002\u0001\u0005\u0002\u0015\u001b\t\u0002\u0003\u0005\u0004\u001c\u0001!\t!RB\u000f\u0011\u001d\u0019\u0019\u0003\u0001C\u0001\u0007KAqa!\u000b\u0001\t\u0003\u0019Y\u0003C\u0004\u00040\u0001!\ta!\r\t\u000f\rU\u0002\u0001\"\u0001\u00048!911\b\u0001\u0005\u0002\ru\u0002bBB#\u0001\u0011\u00051Q\b\u0005\b\u0007\u000f\u0002A\u0011AB%\u0011\u001d\u0019\u0019\u0007\u0001C\u0001\u0003\u0003Aqa!\u001e\u0001\t\u0003\u00199\bC\u0004\u0004|\u0001!\ta! \t\u000f\r5\u0005\u0001\"\u0011\u0004\u0010\"911\u0017\u0001\u0005B\rU\u0006bBBg\u0001\u0011\u00051q\u001a\u0005\b\u0007#\u0004A\u0011ABj\u0011\u001d\u0019\t\u000e\u0001C\u0001\u0007ODqa!<\u0001\t\u0003\u0019yO\u0002\u0004\u0004t\u0002\u00011Q\u001f\u0005\u000b\u0003'T$\u0011!Q\u0001\n\u0005U\u0007bBB|u\u0011\u00051\u0011 \u0005\b\u00037SD\u0011\u0001C\u0001\u0011\u001d\t\u0019L\u000fC\u0001\t/Aq!!\u000b;\t\u0003!y\u0003C\u0004\u0004nj\"\t\u0001b\u000f\t\u000f\u0011\u0005\u0003\u0001\"\u0003\u0005D\tyAK]1wKJ\u001c\u0018M\u00197f\u0019&\\WM\u0003\u0002E\u000b\u0006Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003\u0019\u000bQa]2bY\u0006\u001c\u0001!F\u0002J-v\u001br\u0001\u0001&O?\n4\u0017\u000e\u0005\u0002L\u00196\tQ)\u0003\u0002N\u000b\n\u0019\u0011I\\=\u0011\t=\u0013F\u000bX\u0007\u0002!*\u0011\u0011kQ\u0001\bO\u0016tWM]5d\u0013\t\u0019\u0006KA\u0007ICNtUm\u001e\"vS2$WM\u001d\t\u0003+Zc\u0001\u0001\u0002\u0004X\u0001\u0011\u0015\r\u0001\u0017\u0002\u0002\u0003F\u0011\u0011L\u0013\t\u0003\u0017jK!aW#\u0003\u000f9{G\u000f[5oOB\u0011Q+\u0018\u0003\u0007=\u0002!)\u0019\u0001-\u0003\tI+\u0007O\u001d\t\u0005\u001f\u0002$F,\u0003\u0002b!\nia)\u001b7uKJluN\\1eS\u000e\u00042a\u00193U\u001b\u0005\u0019\u0015BA3D\u0005=!&/\u0019<feN\f'\r\\3P]\u000e,\u0007\u0003B2h)rK!\u0001[\"\u0003%\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK2K7.\u001a\t\u0005G*$F.\u0003\u0002l\u0007\nq\u0001+\u0019:bY2,G.\u001b>bE2,\u0007cA7q)6\taN\u0003\u0002p\u0007\u0006A\u0001/\u0019:bY2,G.\u0003\u0002r]\nY\u0001+\u0019:Ji\u0016\u0014\u0018M\u00197f\u0003\u0019!\u0013N\\5uIQ\tA\u000f\u0005\u0002Lk&\u0011a/\u0012\u0002\u0005+:LGO\u0001\u0003TK24\u0017\u0001\u0002:faJ,\u0012\u0001X\u0001\u0013SN$&/\u0019<feN\f'\r\\3BO\u0006Lg.F\u0001}!\tYU0\u0003\u0002\u007f\u000b\n9!i\\8mK\u0006t\u0017A\u0004;iSN\u001cu\u000e\u001c7fGRLwN\\\u000b\u0003\u0003\u0007\u0001BaYA\u0003)&\u0019\u0011qA\"\u0003\u0017Q\u0013\u0018M^3sg\u0006\u0014G.Z\u0001\ri>\u001cu\u000e\u001c7fGRLwN\u001c\u000b\u0005\u0003\u0007\ti\u0001C\u0003y\r\u0001\u0007A,\u0001\u0006oK^\u0014U/\u001b7eKJ,\"!a\u0005\u0011\r\u0005U\u00111\u0004+]\u001b\t\t9BC\u0002\u0002\u001a\r\u000bq!\\;uC\ndW-\u0003\u0003\u0002\u001e\u0005]!a\u0002\"vS2$WM]\u0001\fa\u0006\u00148i\\7cS:,'/\u0006\u0002\u0002$A)Q.!\nUY&\u0019\u0011q\u00058\u0003\u0011\r{WNY5oKJ\fqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0002.\u0005mBc\u0001;\u00020!9\u0011\u0011G\u0005A\u0002\u0005M\u0012!\u00014\u0011\r-\u000b)\u0004VA\u001d\u0013\r\t9$\u0012\u0002\n\rVt7\r^5p]F\u00022!VA\u001e\t\u0019\ti$\u0003b\u00011\n\tQ+A\u0004jg\u0016k\u0007\u000f^=\u0002\u001f!\f7\u000fR3gS:LG/Z*ju\u0016\f!\u0002\n9mkN$\u0003\u000f\\;t+\u0019\t9%!\u0018\u0002NQ!\u0011\u0011JA2)\u0011\tY%!\u0015\u0011\u0007U\u000bi\u0005\u0002\u0004\u0002P1\u0011\r\u0001\u0017\u0002\u0005)\"\fG\u000fC\u0004\u0002T1\u0001\u001d!!\u0016\u0002\u0005\t4\u0007\u0003C(\u0002Xq\u000bY&a\u0013\n\u0007\u0005e\u0003K\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000eE\u0002V\u0003;\"q!a\u0018\r\u0005\u0004\t\tGA\u0001C#\t!&\nC\u0004\u0002f1\u0001\r!a\u001a\u0002\tQD\u0017\r\u001e\t\u0006G\u0006%\u00141L\u0005\u0004\u0003W\u001a%AE$f]R\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\f\u0001\u0003\n9mkN$\u0003\u000f\\;tI\r|Gn\u001c8\u0016\r\u0005E\u0014qPA<)\u0011\t\u0019(!!\u0015\t\u0005U\u0014\u0011\u0010\t\u0004+\u0006]DABA(\u001b\t\u0007\u0001\fC\u0004\u0002T5\u0001\u001d!a\u001f\u0011\u0011=\u000b9\u0006XA?\u0003k\u00022!VA@\t\u001d\ty&\u0004b\u0001\u0003CBq!!\u001a\u000e\u0001\u0004\t\u0019\t\u0005\u0003dI\u0006uTCBAD\u0003+\u000bi\t\u0006\u0003\u0002\n\u0006]E\u0003BAF\u0003\u001f\u00032!VAG\t\u0019\tyE\u0004b\u00011\"9\u00111\u000b\bA\u0004\u0005E\u0005\u0003C(\u0002Xq\u000b\u0019*a#\u0011\u0007U\u000b)\nB\u0004\u0002`9\u0011\r!!\u0019\t\u000f\u0005\u0015d\u00021\u0001\u0002\u001aB)1-!\u0002\u0002\u0014\u0006\u0019Q.\u00199\u0016\r\u0005}\u0015QVAS)\u0011\t\t+a,\u0015\t\u0005\r\u0016q\u0015\t\u0004+\u0006\u0015FABA(\u001f\t\u0007\u0001\fC\u0004\u0002T=\u0001\u001d!!+\u0011\u0011=\u000b9\u0006XAV\u0003G\u00032!VAW\t\u0019\tyf\u0004b\u00011\"9\u0011\u0011G\bA\u0002\u0005E\u0006CB&\u00026Q\u000bY+A\u0004gY\u0006$X*\u00199\u0016\r\u0005]\u0016QYA_)\u0011\tI,a2\u0015\t\u0005m\u0016q\u0018\t\u0004+\u0006uFABA(!\t\u0007\u0001\fC\u0004\u0002TA\u0001\u001d!!1\u0011\u0011=\u000b9\u0006XAb\u0003w\u00032!VAc\t\u0019\ty\u0006\u0005b\u00011\"9\u0011\u0011\u0007\tA\u0002\u0005%\u0007CB&\u00026Q\u000bY\rE\u0003d\u0003S\n\u0019-\u0001\u0006gS2$XM]%na2$R\u0001XAi\u0003/Dq!a5\u0012\u0001\u0004\t).A\u0001q!\u0015Y\u0015Q\u0007+}\u0011\u0019\tI.\u0005a\u0001y\u0006I\u0011n\u001d$mSB\u0004X\rZ\u0001\u000fM&dG/\u001a:J[BdG*[:u+\u0011\ty.a<\u0015\u0011\u0005\u0005\u0018\u0011_A{\u0003s\u0004b!a9\u0002j\u00065XBAAs\u0015\r\t9oQ\u0001\nS6lW\u000f^1cY\u0016LA!a;\u0002f\n!A*[:u!\r)\u0016q\u001e\u0003\u0006/J\u0011\r\u0001\u0017\u0005\b\u0003g\u0014\u0002\u0019AAq\u0003\u0011\u0019X\r\u001c4\t\u000f\u0005M'\u00031\u0001\u0002xB11*!\u000e\u0002nrDa!!7\u0013\u0001\u0004a\u0018A\u00024jYR,'\u000fF\u0002]\u0003\u007fDq!a5\u0014\u0001\u0004\t).A\u0005gS2$XM\u001d(piR\u0019AL!\u0002\t\u000f\u0005MG\u00031\u0001\u0002V\u000691m\u001c7mK\u000e$XC\u0002B\u0006\u00053\u0011\t\u0002\u0006\u0003\u0003\u000e\tmA\u0003\u0002B\b\u0005'\u00012!\u0016B\t\t\u0019\ty%\u0006b\u00011\"9\u00111K\u000bA\u0004\tU\u0001\u0003C(\u0002Xq\u00139Ba\u0004\u0011\u0007U\u0013I\u0002\u0002\u0004\u0002`U\u0011\r\u0001\u0017\u0005\b\u0005;)\u0002\u0019\u0001B\u0010\u0003\t\u0001h\r\u0005\u0004L\u0005C!&qC\u0005\u0004\u0005G)%a\u0004)beRL\u0017\r\u001c$v]\u000e$\u0018n\u001c8\u0002\u0013A\f'\u000f^5uS>tG\u0003\u0002B\u0015\u0005_\u0001Ra\u0013B\u00169rK1A!\fF\u0005\u0019!V\u000f\u001d7fe!9\u00111\u001b\fA\u0002\u0005U\u0017aB4s_V\u0004()_\u000b\u0005\u0005k\u0011y\u0004\u0006\u0003\u00038\t\r\u0003cBAr\u0005s\u0011i\u0004X\u0005\u0005\u0005w\t)OA\u0002NCB\u00042!\u0016B \t\u0019\u0011\te\u0006b\u00011\n\t1\nC\u0004\u00022]\u0001\rA!\u0012\u0011\r-\u000b)\u0004\u0016B\u001f\u0003\u00191wN]1mYR\u0019APa\u0013\t\u000f\u0005M\u0007\u00041\u0001\u0002V\u00061Q\r_5tiN$2\u0001 B)\u0011\u001d\t\u0019.\u0007a\u0001\u0003+\fAAZ5oIR!!q\u000bB/!\u0011Y%\u0011\f+\n\u0007\tmSI\u0001\u0004PaRLwN\u001c\u0005\b\u0003'T\u0002\u0019AAk\u0003\u0011\u00198-\u00198\u0016\r\t\r$Q\u000fB6)\u0011\u0011)G!!\u0015\t\t\u001d$q\u000f\u000b\u0005\u0005S\u0012i\u0007E\u0002V\u0005W\"a!a\u0014\u001c\u0005\u0004A\u0006b\u0002B87\u0001\u000f!\u0011O\u0001\u0004G\n4\u0007\u0003C(\u0002Xq\u0013\u0019H!\u001b\u0011\u0007U\u0013)\bB\u0004\u0002`m\u0011\r!!\u0019\t\u000f\te4\u00041\u0001\u0003|\u0005\u0011q\u000e\u001d\t\n\u0017\nu$1\u000fB:\u0005gJ1Aa F\u0005%1UO\\2uS>t'\u0007C\u0004\u0003\u0004n\u0001\rAa\u001d\u0002\u0003i\f\u0001b]2b]2+g\r^\u000b\u0007\u0005\u0013\u0013IJ!%\u0015\t\t-%q\u0014\u000b\u0005\u0005\u001b\u0013Y\n\u0006\u0003\u0003\u0010\nM\u0005cA+\u0003\u0012\u00121\u0011q\n\u000fC\u0002aCq!a\u0015\u001d\u0001\b\u0011)\n\u0005\u0005P\u0003/b&q\u0013BH!\r)&\u0011\u0014\u0003\u0007\u0003?b\"\u0019\u0001-\t\u000f\teD\u00041\u0001\u0003\u001eBA1J! \u0003\u0018R\u00139\nC\u0004\u0003\u0004r\u0001\rAa&\u0002\u0013M\u001c\u0017M\u001c*jO\"$XC\u0002BS\u0005k\u0013i\u000b\u0006\u0003\u0003(\nmF\u0003\u0002BU\u0005o#BAa+\u00030B\u0019QK!,\u0005\r\u0005=SD1\u0001Y\u0011\u001d\t\u0019&\ba\u0002\u0005c\u0003\u0002bTA,9\nM&1\u0016\t\u0004+\nUFABA0;\t\u0007\u0001\fC\u0004\u0003zu\u0001\rA!/\u0011\u0011-\u0013i\b\u0016BZ\u0005gCqAa!\u001e\u0001\u0004\u0011\u0019\fK\u0004\u001e\u0005\u007f\u0013YMa4\u0011\t\t\u0005'qY\u0007\u0003\u0005\u0007T1A!2F\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0005\u0013\u0014\u0019MA\u0005nS\u001e\u0014\u0018\r^5p]\u0006\u0012!QZ\u0001i)\",\u0007EY3iCZLwN\u001d\u0011pM\u0002\u00027oY1o%&<\u0007\u000e\u001e1!Q\u0006\u001c\be\u00195b]\u001e,GM\f\u0011UQ\u0016\u0004\u0003O]3wS>,8\u000f\t2fQ\u00064\u0018n\u001c:!G\u0006t\u0007EY3!e\u0016\u0004(o\u001c3vG\u0016$\u0007e^5uQ\u0002\u001a8-\u00198SS\u001eDGO\f:fm\u0016\u00148/\u001a\u0018\"\u0005\tE\u0017!\u0002\u001a/s9\u0002\u0014\u0001\u00025fC\u0012,\u0012\u0001V\u0001\u000bQ\u0016\fGm\u00149uS>tWC\u0001B,\u0003\u0011!\u0018-\u001b7\u0002\t1\f7\u000f^\u0001\u000bY\u0006\u001cHo\u00149uS>t\u0017\u0001B5oSR\fA\u0001^1lKR\u0019ALa:\t\u000f\t%H\u00051\u0001\u0003l\u0006\ta\u000eE\u0002L\u0005[L1Aa<F\u0005\rIe\u000e^\u0001\u0005IJ|\u0007\u000fF\u0002]\u0005kDqA!;&\u0001\u0004\u0011Y/A\u0003tY&\u001cW\rF\u0003]\u0005w\u0014y\u0010C\u0004\u0003~\u001a\u0002\rAa;\u0002\t\u0019\u0014x.\u001c\u0005\b\u0007\u00031\u0003\u0019\u0001Bv\u0003\u0015)h\u000e^5m\u00035\u0019H.[2f\u0013:$XM\u001d8bYR9Ala\u0002\u0004\n\r-\u0001b\u0002B\u007fO\u0001\u0007!1\u001e\u0005\b\u0007\u00039\u0003\u0019\u0001Bv\u0011\u001d\u0019ia\na\u0001\u0003'\t\u0011AY\u0001\u0014g2L7-Z,ji\"\\en\\<o\t\u0016dG/\u0019\u000b\b9\u000eM1QCB\f\u0011\u001d\u0011i\u0010\u000ba\u0001\u0005WDqa!\u0001)\u0001\u0004\u0011Y\u000fC\u0004\u0004\u001a!\u0002\rAa;\u0002\u000b\u0011,G\u000e^1\u0002'Md\u0017nY3XSRD7J\\8x]\n{WO\u001c3\u0015\u000bq\u001byb!\t\t\u000f\tu\u0018\u00061\u0001\u0003l\"91\u0011A\u0015A\u0002\t-\u0018!\u0003;bW\u0016<\u0006.\u001b7f)\ra6q\u0005\u0005\b\u0003'T\u0003\u0019AAk\u0003%!'o\u001c9XQ&dW\rF\u0002]\u0007[Aq!a5,\u0001\u0004\t).\u0001\u0003ta\u0006tG\u0003\u0002B\u0015\u0007gAq!a5-\u0001\u0004\t).A\u0004ta2LG/\u0011;\u0015\t\t%2\u0011\b\u0005\b\u0005Sl\u0003\u0019\u0001Bv\u0003\u0015!\u0018-\u001b7t+\t\u0019y\u0004\u0005\u0003d\u0007\u0003b\u0016bAB\"\u0007\nA\u0011\n^3sCR|'/A\u0003j]&$8/A\u0006d_BLHk\\!se\u0006LX\u0003BB&\u00073\"r\u0001^B'\u00077\u001ay\u0006C\u0004\u0004PA\u0002\ra!\u0015\u0002\u0005a\u001c\b#B&\u0004T\r]\u0013bAB+\u000b\n)\u0011I\u001d:bsB\u0019Qk!\u0017\u0005\u000f\u0005}\u0003G1\u0001\u0002b!91Q\f\u0019A\u0002\t-\u0018!B:uCJ$\bbBB1a\u0001\u0007!1^\u0001\u0004Y\u0016t\u0017!\u0004;p)J\fg/\u001a:tC\ndW\rK\u00042\u0007O\u001aig!\u001d\u0011\u0007-\u001bI'C\u0002\u0004l\u0015\u0013A\u0003Z3qe\u0016\u001c\u0017\r^3e\u001fZ,'O]5eS:<\u0017EAB8\u00039+eNZ8sG\u0016\u00043m\u001c8ue\u0006\u001cG\u000fI8gAQ|GK]1wKJ\u001c\u0018M\u00197fAQD\u0017\r\u001e\u0011jM\u0002JG\u000fI5tAQ\u0013\u0018M^3sg\u0006\u0014G.\u001a\u0011ji\u0002\u0012X\r^;s]N\u0004\u0013\u000e^:fY\u001at\u0013EAB:\u0003\u0019\u0011d&M\u0019/a\u0005QAo\\%uKJ\fGo\u001c:\u0016\u0005\re\u0004\u0003B2\u0004BQ\u000b\u0001\u0002^8TiJ,\u0017-\\\u000b\u0003\u0007\u007f\u0002Ra!!\u0004\bRs1aSBB\u0013\r\u0019))R\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\u0019Iia#\u0003\rM#(/Z1n\u0015\r\u0019))R\u0001\u0003i>,Ba!%\u0004\u0016R!11SBX!\u0015)6QSBP\t\u001d\u00199\n\u000eb\u0001\u00073\u00131aQ8m+\rA61\u0014\u0003\b\u0007;\u001b)J1\u0001Y\u0005\u0005y&f\u0001+\u0004\".\u001211\u0015\t\u0005\u0007K\u001bY+\u0004\u0002\u0004(*!1\u0011\u0016Bb\u0003%)hn\u00195fG.,G-\u0003\u0003\u0004.\u000e\u001d&!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\"9!q\u000e\u001bA\u0004\rE\u0006cB(\u0002Xe#61S\u0001\ti>\u001cFO]5oOR\u00111q\u0017\t\u0005\u0007s\u001b9M\u0004\u0003\u0004<\u000e\r\u0007cAB_\u000b6\u00111q\u0018\u0006\u0004\u0007\u0003<\u0015A\u0002\u001fs_>$h(C\u0002\u0004F\u0016\u000ba\u0001\u0015:fI\u00164\u0017\u0002BBe\u0007\u0017\u0014aa\u0015;sS:<'bABc\u000b\u0006a1\u000f\u001e:j]\u001e\u0004&/\u001a4jqV\u00111qW\u0001\u0005m&,w/\u0006\u0002\u0004VJ11q[Bn\u0007C4aa!78\u0001\rU'\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004cA&\u0004^&\u00191q\\#\u0003\r\u0005s\u0017PU3g!\u0015\u001971\u001d+]\u0013\r\u0019)o\u0011\u0002\u0010)J\fg/\u001a:tC\ndWMV5foR11\u0011]Bu\u0007WDqA!@9\u0001\u0004\u0011Y\u000fC\u0004\u0004\u0002a\u0002\rAa;\u0002\u0015]LG\u000f\u001b$jYR,'\u000fF\u0002`\u0007cDq!a5:\u0001\u0004\t)N\u0001\u0006XSRDg)\u001b7uKJ\u001cBAOBn?\u00061A(\u001b8jiz\"Baa?\u0004\u0000B\u00191Q \u001e\u000e\u0003\u0001Aq!a5=\u0001\u0004\t).\u0006\u0004\u0005\u0004\u0011EA\u0011\u0002\u000b\u0005\t\u000b!\u0019\u0002\u0006\u0003\u0005\b\u0011-\u0001cA+\u0005\n\u00111\u0011qJ\u001fC\u0002aCq!a\u0015>\u0001\b!i\u0001\u0005\u0005P\u0003/bFq\u0002C\u0004!\r)F\u0011\u0003\u0003\u0007\u0003?j$\u0019\u0001-\t\u000f\u0005ER\b1\u0001\u0005\u0016A11*!\u000eU\t\u001f)b\u0001\"\u0007\u0005(\u0011}A\u0003\u0002C\u000e\tS!B\u0001\"\b\u0005\"A\u0019Q\u000bb\b\u0005\r\u0005=cH1\u0001Y\u0011\u001d\t\u0019F\u0010a\u0002\tG\u0001\u0002bTA,9\u0012\u0015BQ\u0004\t\u0004+\u0012\u001dBABA0}\t\u0007\u0001\fC\u0004\u00022y\u0002\r\u0001b\u000b\u0011\r-\u000b)\u0004\u0016C\u0017!\u0015\u0019\u0017\u0011\u000eC\u0013+\u0011!\t\u0004\"\u000f\u0015\u0007Q$\u0019\u0004C\u0004\u00022}\u0002\r\u0001\"\u000e\u0011\r-\u000b)\u0004\u0016C\u001c!\r)F\u0011\b\u0003\u0007\u0003{y$\u0019\u0001-\u0015\t\rmHQ\b\u0005\b\t\u007f\u0001\u0005\u0019AAk\u0003\u0005\t\u0018!E5uKJ\fG/Z+oi&dW)\u001c9usR!1q\bC#\u0011\u001d\t\t$\u0011a\u0001\t\u000f\u0002raSA\u001b\t\u0013\"I\u0005E\u0003d\u0003\u000b\u0019y\n")
public interface TraversableLike<A, Repr>
extends HasNewBuilder<A, Repr>,
FilterMonadic<A, Repr>,
TraversableOnce<A>,
GenTraversableLike<A, Repr> {
    public static /* synthetic */ Object repr$(TraversableLike $this) {
        return $this.repr();
    }

    @Override
    default public Repr repr() {
        return (Repr)this;
    }

    public static /* synthetic */ boolean isTraversableAgain$(TraversableLike $this) {
        return $this.isTraversableAgain();
    }

    @Override
    default public boolean isTraversableAgain() {
        return true;
    }

    public static /* synthetic */ Traversable thisCollection$(TraversableLike $this) {
        return $this.thisCollection();
    }

    default public Traversable<A> thisCollection() {
        return (Traversable)this;
    }

    public static /* synthetic */ Traversable toCollection$(TraversableLike $this, Object repr) {
        return $this.toCollection(repr);
    }

    default public Traversable<A> toCollection(Repr repr) {
        return (Traversable)repr;
    }

    @Override
    public Builder<A, Repr> newBuilder();

    public static /* synthetic */ Combiner parCombiner$(TraversableLike $this) {
        return $this.parCombiner();
    }

    @Override
    default public Combiner<A, ParIterable<A>> parCombiner() {
        return ParIterable$.MODULE$.newCombiner();
    }

    @Override
    public <U> void foreach(Function1<A, U> var1);

    public static /* synthetic */ boolean isEmpty$(TraversableLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        BooleanRef result2 = BooleanRef.create(true);
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Nothing$> & java.io.Serializable & Serializable)x -> {
            result$1.elem = false;
            return Traversable$.MODULE$.breaks().break();
        }));
        return result2.elem;
    }

    public static /* synthetic */ boolean hasDefiniteSize$(TraversableLike $this) {
        return $this.hasDefiniteSize();
    }

    @Override
    default public boolean hasDefiniteSize() {
        return true;
    }

    public static /* synthetic */ Object $plus$plus$(TraversableLike $this, GenTraversableOnce that, CanBuildFrom bf) {
        return $this.$plus$plus(that, bf);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    default public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Repr, B, That> bf) {
        Object object;
        if (bf == Set$.MODULE$.canBuildFrom()) {
            Object object2;
            if (this instanceof Set) {
                Set set = (Set)this;
                if (that instanceof GenSet) {
                    object2 = set.union((GenSet)that);
                    return (That)object2;
                }
            }
            object2 = this.defaultPlusPlus$1(bf, that);
            return (That)object2;
        }
        if (bf == HashSet$.MODULE$.canBuildFrom()) {
            Object object3;
            if (this instanceof HashSet) {
                HashSet hashSet = (HashSet)this;
                if (that instanceof GenSet) {
                    object3 = hashSet.union((GenSet)that);
                    return (That)object3;
                }
            }
            object3 = this.defaultPlusPlus$1(bf, that);
            return (That)object3;
        }
        if (this instanceof TreeSet) {
            object = ((TreeSet)this).addAllImpl(that, bf);
            return (That)object;
        }
        object = this.defaultPlusPlus$1(bf, that);
        return (That)object;
    }

    public static /* synthetic */ Object $plus$plus$colon$(TraversableLike $this, TraversableOnce that, CanBuildFrom bf) {
        return $this.$plus$plus$colon(that, bf);
    }

    /*
     * Enabled aggressive block sorting
     */
    default public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<Repr, B, That> bf) {
        Object object;
        if (bf == Set$.MODULE$.canBuildFrom()) {
            Object object2;
            if (this instanceof Set) {
                Set set = (Set)this;
                if (that instanceof GenSet) {
                    object2 = set.union((GenSet)((Object)that));
                    return (That)object2;
                }
            }
            object2 = this.defaultPlusPlus$2(bf, that);
            return (That)object2;
        }
        if (bf == HashSet$.MODULE$.canBuildFrom()) {
            Object object3;
            if (this instanceof HashSet) {
                HashSet hashSet = (HashSet)this;
                if (that instanceof GenSet) {
                    object3 = hashSet.union((GenSet)((Object)that));
                    return (That)object3;
                }
            }
            object3 = this.defaultPlusPlus$2(bf, that);
            return (That)object3;
        }
        if (this instanceof TreeSet) {
            object = ((TreeSet)this).addAllImpl(that, bf);
            return (That)object;
        }
        object = this.defaultPlusPlus$2(bf, that);
        return (That)object;
    }

    public static /* synthetic */ Object $plus$plus$colon$(TraversableLike $this, Traversable that, CanBuildFrom bf) {
        return $this.$plus$plus$colon(that, bf);
    }

    default public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<Repr, B, That> bf) {
        return that.$plus$plus(this.seq(), package$.MODULE$.breakOut(bf));
    }

    public static /* synthetic */ Object map$(TraversableLike $this, Function1 f, CanBuildFrom bf) {
        return $this.map(f, bf);
    }

    @Override
    default public <B, That> That map(Function1<A, B> f, CanBuildFrom<Repr, B, That> bf) {
        Builder b = this.builder$1(bf);
        this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x -> b.$plus$eq(f.apply(x)));
        return (That)b.result();
    }

    public static /* synthetic */ Object flatMap$(TraversableLike $this, Function1 f, CanBuildFrom bf) {
        return $this.flatMap(f, bf);
    }

    @Override
    default public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<Repr, B, That> bf) {
        Builder b = this.builder$2(bf);
        this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x -> (Builder)b.$plus$plus$eq(((GenTraversableOnce)f.apply(x)).seq()));
        return (That)b.result();
    }

    public static /* synthetic */ Object filterImpl$(TraversableLike $this, Function1 p, boolean isFlipped) {
        return $this.filterImpl(p, isFlipped);
    }

    default public Repr filterImpl(Function1<A, Object> p, boolean isFlipped) {
        List<Object> list;
        if (this instanceof List) {
            List list2 = (List)this;
            list = this.noneIn$1(list2, p, isFlipped);
        } else {
            Builder b = this.newBuilder();
            this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                if (BoxesRunTime.unboxToBoolean(p.apply(x)) != isFlipped) {
                    return b.$plus$eq((Object)x);
                }
                return BoxedUnit.UNIT;
            });
            list = b.result();
        }
        return (Repr)list;
    }

    private <A> List<A> filterImplList(List<A> self, Function1<A, Object> p, boolean isFlipped) {
        return this.noneIn$1(self, p, isFlipped);
    }

    public static /* synthetic */ Object filter$(TraversableLike $this, Function1 p) {
        return $this.filter(p);
    }

    @Override
    default public Repr filter(Function1<A, Object> p) {
        return this.filterImpl(p, false);
    }

    public static /* synthetic */ Object filterNot$(TraversableLike $this, Function1 p) {
        return $this.filterNot(p);
    }

    @Override
    default public Repr filterNot(Function1<A, Object> p) {
        return this.filterImpl(p, true);
    }

    public static /* synthetic */ Object collect$(TraversableLike $this, PartialFunction pf, CanBuildFrom bf) {
        return $this.collect(pf, bf);
    }

    @Override
    default public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<Repr, B, That> bf) {
        Builder b = bf.apply(this.repr());
        this.foreach(pf.runWith((Function1<Object, Builder> & java.io.Serializable & Serializable)x$1 -> b.$plus$eq((Object)x$1)));
        return b.result();
    }

    public static /* synthetic */ Tuple2 partition$(TraversableLike $this, Function1 p) {
        return $this.partition(p);
    }

    @Override
    default public Tuple2<Repr, Repr> partition(Function1<A, Object> p) {
        Builder l = this.newBuilder();
        Builder r = this.newBuilder();
        this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x -> (BoxesRunTime.unboxToBoolean(p.apply(x)) ? l : r).$plus$eq(x));
        return new Tuple2<Repr, Repr>(l.result(), r.result());
    }

    public static /* synthetic */ Map groupBy$(TraversableLike $this, Function1 f) {
        return $this.groupBy(f);
    }

    @Override
    default public <K> Map<K, Repr> groupBy(Function1<A, K> f) {
        GenMap m = Map$.MODULE$.empty();
        this.foreach(arg_0 -> TraversableLike.$anonfun$groupBy$1(this, f, (scala.collection.mutable.Map)m, arg_0));
        Builder b = scala.collection.immutable.Map$.MODULE$.newBuilder();
        m.withFilter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)check$ifrefutable$1 -> BoxesRunTime.boxToBoolean(bl = check$ifrefutable$1 != null)).foreach((Function1<Tuple2, Builder> & java.io.Serializable & Serializable)x$2 -> {
            if (x$2 == null) {
                throw new MatchError((Object)null);
            }
            Object k = x$2._1();
            Builder v = (Builder)x$2._2();
            Builder builder = b.$plus$eq(new Tuple2(k, v.result()));
            return builder;
        });
        return b.result();
    }

    public static /* synthetic */ boolean forall$(TraversableLike $this, Function1 p) {
        return $this.forall(p);
    }

    @Override
    default public boolean forall(Function1<A, Object> p) {
        BooleanRef result2 = BooleanRef.create(true);
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            TraversableLike.$anonfun$forall$2(p, result2, x);
            return BoxedUnit.UNIT;
        }));
        return result2.elem;
    }

    public static /* synthetic */ boolean exists$(TraversableLike $this, Function1 p) {
        return $this.exists(p);
    }

    @Override
    default public boolean exists(Function1<A, Object> p) {
        BooleanRef result2 = BooleanRef.create(false);
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            TraversableLike.$anonfun$exists$2(p, result2, x);
            return BoxedUnit.UNIT;
        }));
        return result2.elem;
    }

    public static /* synthetic */ Option find$(TraversableLike $this, Function1 p) {
        return $this.find(p);
    }

    @Override
    default public Option<A> find(Function1<A, Object> p) {
        ObjectRef<None$> result2 = ObjectRef.create(None$.MODULE$);
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            TraversableLike.$anonfun$find$2(p, result2, x);
            return BoxedUnit.UNIT;
        }));
        return (Option)result2.elem;
    }

    public static /* synthetic */ Object scan$(TraversableLike $this, Object z, Function2 op, CanBuildFrom cbf) {
        return $this.scan(z, op, cbf);
    }

    @Override
    default public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<Repr, B, That> cbf) {
        return this.scanLeft(z, op, cbf);
    }

    public static /* synthetic */ Object scanLeft$(TraversableLike $this, Object z, Function2 op, CanBuildFrom bf) {
        return $this.scanLeft(z, op, bf);
    }

    @Override
    default public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<Repr, B, That> bf) {
        Builder b = bf.apply(this.repr());
        b.sizeHint(this, 1);
        ObjectRef<B> acc = ObjectRef.create(z);
        b.$plus$eq((B)acc.elem);
        this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x -> {
            acc$1.elem = op.apply(acc$1.elem, x);
            return b.$plus$eq((Object)acc$1.elem);
        });
        return b.result();
    }

    public static /* synthetic */ Object scanRight$(TraversableLike $this, Object z, Function2 op, CanBuildFrom bf) {
        return $this.scanRight(z, op, bf);
    }

    @Override
    default public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<Repr, B, That> bf) {
        ObjectRef<GenTraversable> scanned = ObjectRef.create(List$.MODULE$.apply((Seq)Predef$.MODULE$.genericWrapArray(new Object[]{z})));
        ObjectRef<B> acc = ObjectRef.create(z);
        List list = this.reversed();
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Object a = foreach_these.head();
            TraversableLike.$anonfun$scanRight$1$adapted(acc, op, scanned, a);
            foreach_these = (List)foreach_these.tail();
        }
        Builder<B, That> b = bf.apply(this.repr());
        List list2 = (List)scanned.elem;
        if (list2 == null) {
            throw null;
        }
        List foreach_these2 = list2;
        while (!foreach_these2.isEmpty()) {
            Object a = foreach_these2.head();
            b.$plus$eq(a);
            foreach_these2 = (List)foreach_these2.tail();
        }
        return b.result();
    }

    public static /* synthetic */ Object head$(TraversableLike $this) {
        return $this.head();
    }

    @Override
    default public A head() {
        ObjectRef<Function0<Nothing$> & java.io.Serializable & Serializable> result2 = ObjectRef.create((Function0<Nothing$> & java.io.Serializable & Serializable)() -> {
            throw new NoSuchElementException();
        });
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Nothing$> & java.io.Serializable & Serializable)x -> {
            result$5.elem = (Function0<Object> & java.io.Serializable & Serializable)() -> x;
            return Traversable$.MODULE$.breaks().break();
        }));
        return (A)((Function0)result2.elem).apply();
    }

    public static /* synthetic */ Option headOption$(TraversableLike $this) {
        return $this.headOption();
    }

    @Override
    default public Option<A> headOption() {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return new Some<A>(this.head());
    }

    public static /* synthetic */ Object tail$(TraversableLike $this) {
        return $this.tail();
    }

    @Override
    default public Repr tail() {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.tail");
        }
        return this.drop(1);
    }

    public static /* synthetic */ Object last$(TraversableLike $this) {
        return $this.last();
    }

    @Override
    default public A last() {
        ObjectRef lst = ObjectRef.create(this.head());
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            lst.elem = x;
            return BoxedUnit.UNIT;
        });
        return (A)lst.elem;
    }

    public static /* synthetic */ Option lastOption$(TraversableLike $this) {
        return $this.lastOption();
    }

    @Override
    default public Option<A> lastOption() {
        if (this.isEmpty()) {
            return None$.MODULE$;
        }
        return new Some<A>(this.last());
    }

    public static /* synthetic */ Object init$(TraversableLike $this) {
        return $this.init();
    }

    @Override
    default public Repr init() {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("empty.init");
        }
        ObjectRef lst = ObjectRef.create(this.head());
        BooleanRef follow = BooleanRef.create(false);
        Builder b = this.newBuilder();
        b.sizeHint(this, -1);
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            TraversableLike.$anonfun$init$1(follow, b, lst, x);
            return BoxedUnit.UNIT;
        });
        return b.result();
    }

    public static /* synthetic */ Object take$(TraversableLike $this, int n) {
        return $this.take(n);
    }

    @Override
    default public Repr take(int n) {
        return this.slice(0, n);
    }

    public static /* synthetic */ Object drop$(TraversableLike $this, int n) {
        return $this.drop(n);
    }

    @Override
    default public Repr drop(int n) {
        if (n <= 0) {
            Builder<A, Repr> b = this.newBuilder();
            b.sizeHint(this);
            return (Repr)((Builder)b.$plus$plus$eq(this.thisCollection())).result();
        }
        return this.sliceWithKnownDelta(n, Integer.MAX_VALUE, -n);
    }

    public static /* synthetic */ Object slice$(TraversableLike $this, int from, int until) {
        return $this.slice(from, until);
    }

    @Override
    default public Repr slice(int from, int until) {
        return this.sliceWithKnownBound(scala.math.package$.MODULE$.max(from, 0), until);
    }

    private Repr sliceInternal(int from, int until, Builder<A, Repr> b) {
        IntRef i = IntRef.create(0);
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            TraversableLike.$anonfun$sliceInternal$2(i, from, b, until, x);
            return BoxedUnit.UNIT;
        }));
        return b.result();
    }

    public static /* synthetic */ Object sliceWithKnownDelta$(TraversableLike $this, int from, int until, int delta) {
        return $this.sliceWithKnownDelta(from, until, delta);
    }

    default public Repr sliceWithKnownDelta(int from, int until, int delta) {
        Builder<A, Repr> b = this.newBuilder();
        if (until <= from) {
            return b.result();
        }
        b.sizeHint(this, delta);
        return this.sliceInternal(from, until, b);
    }

    public static /* synthetic */ Object sliceWithKnownBound$(TraversableLike $this, int from, int until) {
        return $this.sliceWithKnownBound(from, until);
    }

    default public Repr sliceWithKnownBound(int from, int until) {
        Builder<A, Repr> b = this.newBuilder();
        if (until <= from) {
            return b.result();
        }
        b.sizeHintBounded(until - from, this);
        return this.sliceInternal(from, until, b);
    }

    public static /* synthetic */ Object takeWhile$(TraversableLike $this, Function1 p) {
        return $this.takeWhile(p);
    }

    @Override
    default public Repr takeWhile(Function1<A, Object> p) {
        Builder b = this.newBuilder();
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x -> {
            if (!BoxesRunTime.unboxToBoolean(p.apply(x))) {
                throw Traversable$.MODULE$.breaks().break();
            }
            return b.$plus$eq((Object)x);
        }));
        return b.result();
    }

    public static /* synthetic */ Object dropWhile$(TraversableLike $this, Function1 p) {
        return $this.dropWhile(p);
    }

    @Override
    default public Repr dropWhile(Function1<A, Object> p) {
        Builder b = this.newBuilder();
        BooleanRef go = BooleanRef.create(false);
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            if (!go$1.elem && !BoxesRunTime.unboxToBoolean(p.apply(x))) {
                go$1.elem = true;
            }
            if (go$1.elem) {
                return b.$plus$eq((Object)x);
            }
            return BoxedUnit.UNIT;
        });
        return b.result();
    }

    public static /* synthetic */ Tuple2 span$(TraversableLike $this, Function1 p) {
        return $this.span(p);
    }

    @Override
    default public Tuple2<Repr, Repr> span(Function1<A, Object> p) {
        Builder l = this.newBuilder();
        Builder r = this.newBuilder();
        BooleanRef toLeft = BooleanRef.create(true);
        this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x -> {
            toLeft$1.elem = toLeft$1.elem && BoxesRunTime.unboxToBoolean(p.apply(x));
            return (toLeft$1.elem ? l : r).$plus$eq(x);
        });
        return new Tuple2<Repr, Repr>(l.result(), r.result());
    }

    public static /* synthetic */ Tuple2 splitAt$(TraversableLike $this, int n) {
        return $this.splitAt(n);
    }

    @Override
    default public Tuple2<Repr, Repr> splitAt(int n) {
        Builder l = this.newBuilder();
        Builder r = this.newBuilder();
        l.sizeHintBounded(n, this);
        if (n >= 0) {
            r.sizeHint(this, -n);
        }
        IntRef i = IntRef.create(0);
        this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            TraversableLike.$anonfun$splitAt$1(i, n, l, r, x);
            return BoxedUnit.UNIT;
        });
        return new Tuple2<Repr, Repr>(l.result(), r.result());
    }

    public static /* synthetic */ Iterator tails$(TraversableLike $this) {
        return $this.tails();
    }

    /*
     * WARNING - void declaration
     */
    default public Iterator<Repr> tails() {
        void iterateUntilEmpty_iterate_start;
        Function1<Traversable, Traversable> & java.io.Serializable & Serializable iterateUntilEmpty_f = (Function1<Traversable, Traversable> & java.io.Serializable & Serializable)x$3 -> (Traversable)x$3.tail();
        Traversable<A> traversable = this.thisCollection();
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new AbstractIterator<T>(iterateUntilEmpty_iterate_start, iterateUntilEmpty_f){
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
        }.takeWhile((Function1<Traversable, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(TraversableLike.$anonfun$iterateUntilEmpty$1(x))).$plus$plus((Function0<Iterator> & java.io.Serializable & Serializable)() -> Iterator$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new Nil$[]{Nil$.MODULE$}))).map((Function1<Traversable, Object> & java.io.Serializable & Serializable)x -> ((Builder)this.newBuilder().$plus$plus$eq(x)).result());
    }

    public static /* synthetic */ Iterator inits$(TraversableLike $this) {
        return $this.inits();
    }

    /*
     * WARNING - void declaration
     */
    default public Iterator<Repr> inits() {
        void iterateUntilEmpty_iterate_start;
        Function1<Traversable, Traversable> & java.io.Serializable & Serializable iterateUntilEmpty_f = (Function1<Traversable, Traversable> & java.io.Serializable & Serializable)x$4 -> (Traversable)x$4.init();
        Traversable<A> traversable = this.thisCollection();
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new /* invalid duplicate definition of identical inner class */.takeWhile((Function1<Traversable, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(TraversableLike.$anonfun$iterateUntilEmpty$1(x))).$plus$plus((Function0<Iterator> & java.io.Serializable & Serializable)() -> Iterator$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new Nil$[]{Nil$.MODULE$}))).map((Function1<Traversable, Object> & java.io.Serializable & Serializable)x -> ((Builder)this.newBuilder().$plus$plus$eq(x)).result());
    }

    public static /* synthetic */ void copyToArray$(TraversableLike $this, Object xs, int start, int len) {
        $this.copyToArray(xs, start, len);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start, int len) {
        IntRef i = IntRef.create(start);
        int n = start + len;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int end = RichInt$.MODULE$.min$extension(n, ScalaRunTime$.MODULE$.array_length(xs));
        Traversable$.MODULE$.breaks().breakable((JFunction0$mcV$sp & Serializable)() -> this.foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
            TraversableLike.$anonfun$copyToArray$2(i, end, xs, x);
            return BoxedUnit.UNIT;
        }));
    }

    public static /* synthetic */ Traversable toTraversable$(TraversableLike $this) {
        return $this.toTraversable();
    }

    @Override
    default public Traversable<A> toTraversable() {
        return this.thisCollection();
    }

    public static /* synthetic */ Iterator toIterator$(TraversableLike $this) {
        return $this.toIterator();
    }

    @Override
    default public Iterator<A> toIterator() {
        return this.toStream().iterator();
    }

    public static /* synthetic */ Stream toStream$(TraversableLike $this) {
        return $this.toStream();
    }

    @Override
    default public Stream<A> toStream() {
        return this.toBuffer().toStream();
    }

    public static /* synthetic */ Object to$(TraversableLike $this, CanBuildFrom cbf) {
        return $this.to(cbf);
    }

    @Override
    default public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
        Builder<A, Col> b = cbf.apply();
        b.sizeHint(this);
        b.$plus$plus$eq(this.thisCollection());
        return b.result();
    }

    public static /* synthetic */ String toString$(TraversableLike $this) {
        return $this.toString();
    }

    default public String toString() {
        return this.mkString(new java.lang.StringBuilder(1).append(this.stringPrefix()).append("(").toString(), ", ", ")");
    }

    public static /* synthetic */ String stringPrefix$(TraversableLike $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        int pos;
        String fqn = this.repr().getClass().getName();
        for (pos = fqn.length() - 1; pos != -1 && fqn.charAt(pos) == '$'; --pos) {
        }
        if (pos == -1 || fqn.charAt(pos) == '.') {
            return "";
        }
        String result2 = "";
        while (true) {
            boolean atEnd;
            int partEnd = pos + 1;
            while (pos != -1 && fqn.charAt(pos) <= '9' && fqn.charAt(pos) >= '0') {
                --pos;
            }
            int lastNonDigit = pos;
            while (pos != -1 && fqn.charAt(pos) != '$' && fqn.charAt(pos) != '.') {
                --pos;
            }
            int partStart = pos + 1;
            if (pos == lastNonDigit && partEnd != fqn.length()) {
                return result2;
            }
            while (pos != -1 && fqn.charAt(pos) == '$') {
                --pos;
            }
            boolean bl = atEnd = pos == -1 || fqn.charAt(pos) == '.';
            if (!atEnd && TraversableLike.isPartLikelySynthetic$1(fqn, partStart)) continue;
            String part = fqn.substring(partStart, partEnd);
            String string = result2 = result2.isEmpty() ? part : new java.lang.StringBuilder(0).append(part).append('.').append(result2).toString();
            if (atEnd) break;
        }
        return result2;
    }

    public static /* synthetic */ TraversableView view$(TraversableLike $this) {
        return $this.view();
    }

    default public TraversableView<A, Repr> view() {
        return new TraversableView<A, Repr>(this){
            private Repr underlying;
            private volatile boolean bitmap$0;
            private final /* synthetic */ TraversableLike $outer;

            public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
                return (TraversableView)TraversableLike.tail$(this);
            }

            public String viewIdentifier() {
                return TraversableViewLike.viewIdentifier$(this);
            }

            public String viewIdString() {
                return TraversableViewLike.viewIdString$(this);
            }

            public String viewToString() {
                return TraversableViewLike.viewToString$(this);
            }

            public String stringPrefix() {
                return TraversableViewLike.stringPrefix$(this);
            }

            public Builder<A, TraversableView<A, Repr>> newBuilder() {
                return TraversableViewLike.newBuilder$(this);
            }

            public <B, That> That force(CanBuildFrom<Repr, B, That> bf) {
                return (That)TraversableViewLike.force$(this, bf);
            }

            public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
            }

            public <B, That> That map(Function1<A, B> f, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.map$(this, f, bf);
            }

            public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.collect$(this, pf, bf);
            }

            public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.flatMap$(this, f, bf);
            }

            public <B> TraversableViewLike.Transformed<B> flatten(Function1<A, GenTraversableOnce<B>> asTraversable) {
                return TraversableViewLike.flatten$(this, asTraversable);
            }

            public <B> TraversableViewLike.Transformed<B> newForced(Function0<GenSeq<B>> xs) {
                return TraversableViewLike.newForced$(this, xs);
            }

            public <B> TraversableViewLike.Transformed<B> newAppended(GenTraversable<B> that) {
                return TraversableViewLike.newAppended$(this, that);
            }

            public <B> TraversableViewLike.Transformed<B> newPrepended(GenTraversable<B> that) {
                return TraversableViewLike.newPrepended$(this, that);
            }

            public <B> TraversableViewLike.Transformed<B> newMapped(Function1<A, B> f) {
                return TraversableViewLike.newMapped$(this, f);
            }

            public <B> TraversableViewLike.Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
                return TraversableViewLike.newFlatMapped$(this, f);
            }

            public TraversableViewLike.Transformed<A> newFiltered(Function1<A, Object> p) {
                return TraversableViewLike.newFiltered$(this, p);
            }

            public TraversableViewLike.Transformed<A> newSliced(SliceInterval _endpoints) {
                return TraversableViewLike.newSliced$(this, _endpoints);
            }

            public TraversableViewLike.Transformed<A> newDroppedWhile(Function1<A, Object> p) {
                return TraversableViewLike.newDroppedWhile$(this, p);
            }

            public TraversableViewLike.Transformed<A> newTakenWhile(Function1<A, Object> p) {
                return TraversableViewLike.newTakenWhile$(this, p);
            }

            public TraversableViewLike.Transformed<A> newTaken(int n) {
                return TraversableViewLike.newTaken$(this, n);
            }

            public TraversableViewLike.Transformed<A> newDropped(int n) {
                return TraversableViewLike.newDropped$(this, n);
            }

            public TraversableView<A, Repr> filter(Function1<A, Object> p) {
                return TraversableViewLike.filter$(this, p);
            }

            public TraversableView<A, Repr> withFilter(Function1<A, Object> p) {
                return TraversableViewLike.withFilter$(this, p);
            }

            public Tuple2<TraversableView<A, Repr>, TraversableView<A, Repr>> partition(Function1<A, Object> p) {
                return TraversableViewLike.partition$(this, p);
            }

            public TraversableView<A, Repr> init() {
                return TraversableViewLike.init$(this);
            }

            public TraversableView<A, Repr> drop(int n) {
                return TraversableViewLike.drop$(this, n);
            }

            public TraversableView<A, Repr> take(int n) {
                return TraversableViewLike.take$(this, n);
            }

            public TraversableView<A, Repr> slice(int from, int until) {
                return TraversableViewLike.slice$(this, from, until);
            }

            public TraversableView<A, Repr> dropWhile(Function1<A, Object> p) {
                return TraversableViewLike.dropWhile$(this, p);
            }

            public TraversableView<A, Repr> takeWhile(Function1<A, Object> p) {
                return TraversableViewLike.takeWhile$(this, p);
            }

            public Tuple2<TraversableView<A, Repr>, TraversableView<A, Repr>> span(Function1<A, Object> p) {
                return TraversableViewLike.span$(this, p);
            }

            public Tuple2<TraversableView<A, Repr>, TraversableView<A, Repr>> splitAt(int n) {
                return TraversableViewLike.splitAt$(this, n);
            }

            public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
            }

            public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<TraversableView<A, Repr>, B, That> bf) {
                return (That)TraversableViewLike.scanRight$(this, z, op, bf);
            }

            public <K> Map<K, TraversableView<A, Repr>> groupBy(Function1<A, K> f) {
                return TraversableViewLike.groupBy$(this, f);
            }

            public <A1, A2> Tuple2<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
                return TraversableViewLike.unzip$(this, asPair);
            }

            public <A1, A2, A3> Tuple3<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>, TraversableViewLike.Transformed<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
                return TraversableViewLike.unzip3$(this, asTriple);
            }

            public TraversableView<A, Repr> filterNot(Function1<A, Object> p) {
                return TraversableViewLike.filterNot$(this, p);
            }

            public Iterator<TraversableView<A, Repr>> inits() {
                return TraversableViewLike.inits$(this);
            }

            public Iterator<TraversableView<A, Repr>> tails() {
                return TraversableViewLike.tails$(this);
            }

            public TraversableView<A, Repr> tail() {
                return TraversableViewLike.tail$(this);
            }

            public String toString() {
                return TraversableViewLike.toString$(this);
            }

            public Seq<A> thisSeq() {
                return ViewMkString.thisSeq$(this);
            }

            public String mkString() {
                return ViewMkString.mkString$(this);
            }

            public String mkString(String sep) {
                return ViewMkString.mkString$(this, sep);
            }

            public String mkString(String start, String sep, String end) {
                return ViewMkString.mkString$(this, start, sep, end);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return ViewMkString.addString$(this, b, start, sep, end);
            }

            public GenericCompanion<Traversable> companion() {
                return Traversable.companion$(this);
            }

            public Traversable<A> seq() {
                return Traversable.seq$(this);
            }

            public <B> Builder<B, Traversable<B>> genericBuilder() {
                return GenericTraversableTemplate.genericBuilder$(this);
            }

            public GenTraversable transpose(Function1 asTraversable) {
                return GenericTraversableTemplate.transpose$(this, asTraversable);
            }

            public Object repr() {
                return TraversableLike.repr$(this);
            }

            public final boolean isTraversableAgain() {
                return TraversableLike.isTraversableAgain$(this);
            }

            public Traversable<A> thisCollection() {
                return TraversableLike.thisCollection$(this);
            }

            public Traversable toCollection(Object repr) {
                return TraversableLike.toCollection$(this, repr);
            }

            public Combiner<A, ParIterable<A>> parCombiner() {
                return TraversableLike.parCombiner$(this);
            }

            public boolean isEmpty() {
                return TraversableLike.isEmpty$(this);
            }

            public boolean hasDefiniteSize() {
                return TraversableLike.hasDefiniteSize$(this);
            }

            public Object filterImpl(Function1 p, boolean isFlipped) {
                return TraversableLike.filterImpl$(this, p, isFlipped);
            }

            public boolean forall(Function1<A, Object> p) {
                return TraversableLike.forall$(this, p);
            }

            public boolean exists(Function1<A, Object> p) {
                return TraversableLike.exists$(this, p);
            }

            public Option<A> find(Function1<A, Object> p) {
                return TraversableLike.find$(this, p);
            }

            public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<TraversableView<A, Repr>, B, That> cbf) {
                return (That)TraversableLike.scan$(this, z, op, cbf);
            }

            public A head() {
                return (A)TraversableLike.head$(this);
            }

            public Option<A> headOption() {
                return TraversableLike.headOption$(this);
            }

            public A last() {
                return (A)TraversableLike.last$(this);
            }

            public Option<A> lastOption() {
                return TraversableLike.lastOption$(this);
            }

            public Object sliceWithKnownDelta(int from, int until, int delta) {
                return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
            }

            public Object sliceWithKnownBound(int from, int until) {
                return TraversableLike.sliceWithKnownBound$(this, from, until);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                TraversableLike.copyToArray$(this, xs, start, len);
            }

            public Traversable<A> toTraversable() {
                return TraversableLike.toTraversable$(this);
            }

            public Iterator<A> toIterator() {
                return TraversableLike.toIterator$(this);
            }

            public Stream<A> toStream() {
                return TraversableLike.toStream$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
                return (Col)TraversableLike.to$(this, cbf);
            }

            public TraversableView<A, TraversableView<A, Repr>> view() {
                return TraversableLike.view$(this);
            }

            public TraversableView<A, TraversableView<A, Repr>> view(int from, int until) {
                return TraversableLike.view$(this, from, until);
            }

            public Parallel par() {
                return Parallelizable.par$(this);
            }

            public List<A> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<A, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, A, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<A, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, A, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<A, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
                return TraversableOnce.reduceRightOption$(this, op);
            }

            public <A1> A1 reduce(Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.reduce$(this, op);
            }

            public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
                return TraversableOnce.reduceOption$(this, op);
            }

            public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
                return (A1)TraversableOnce.fold$(this, z, op);
            }

            public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public <B> A min(Ordering<B> cmp) {
                return (A)TraversableOnce.min$(this, cmp);
            }

            public <B> A max(Ordering<B> cmp) {
                return (A)TraversableOnce.max$(this, cmp);
            }

            public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.maxBy$(this, f, cmp);
            }

            public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
                return (A)TraversableOnce.minBy$(this, f, cmp);
            }

            public <B> void copyToBuffer(Buffer<B> dest) {
                TraversableOnce.copyToBuffer$(this, dest);
            }

            public <B> void copyToArray(Object xs, int start) {
                TraversableOnce.copyToArray$(this, xs, start);
            }

            public <B> void copyToArray(Object xs) {
                TraversableOnce.copyToArray$(this, xs);
            }

            public <B> Object toArray(ClassTag<B> evidence$1) {
                return TraversableOnce.toArray$(this, evidence$1);
            }

            public List<A> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<A> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<A> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<A> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<A> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public StringBuilder addString(StringBuilder b, String sep) {
                return TraversableOnce.addString$(this, b, sep);
            }

            public StringBuilder addString(StringBuilder b) {
                return TraversableOnce.addString$(this, b);
            }

            public int sizeHintIfCheap() {
                return GenTraversableOnce.sizeHintIfCheap$(this);
            }

            private Repr underlying$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.underlying = this.$outer.repr();
                        this.bitmap$0 = true;
                    }
                }
                return this.underlying;
            }

            public Repr underlying() {
                if (!this.bitmap$0) {
                    return this.underlying$lzycompute();
                }
                return this.underlying;
            }

            public <U> void foreach(Function1<A, U> f) {
                this.$outer.foreach(f);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Parallelizable.$init$(this);
                TraversableLike.$init$(this);
                GenericTraversableTemplate.$init$(this);
                GenTraversable.$init$(this);
                Traversable.$init$(this);
                ViewMkString.$init$(this);
                TraversableViewLike.$init$(this);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$groupBy$1(scala.collection.TraversableViewLike scala.collection.Seq )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ TraversableView view$(TraversableLike $this, int from, int until) {
        return $this.view(from, until);
    }

    default public TraversableView<A, Repr> view(int from, int until) {
        return this.view().slice(from, until);
    }

    public static /* synthetic */ FilterMonadic withFilter$(TraversableLike $this, Function1 p) {
        return $this.withFilter(p);
    }

    @Override
    default public FilterMonadic<A, Repr> withFilter(Function1<A, Object> p) {
        return new WithFilter(this, p);
    }

    /*
     * WARNING - void declaration
     */
    private Iterator<Repr> iterateUntilEmpty(Function1<Traversable<A>, Traversable<A>> f) {
        void iterate_start;
        Traversable<A> traversable = this.thisCollection();
        if (Iterator$.MODULE$ == null) {
            throw null;
        }
        return new /* invalid duplicate definition of identical inner class */.takeWhile((Function1<Traversable, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(TraversableLike.$anonfun$iterateUntilEmpty$1(x))).$plus$plus((Function0<Iterator> & java.io.Serializable & Serializable)() -> Iterator$.MODULE$.apply(Predef$.MODULE$.wrapRefArray((Object[])new Nil$[]{Nil$.MODULE$}))).map((Function1<Traversable, Object> & java.io.Serializable & Serializable)x -> ((Builder)this.newBuilder().$plus$plus$eq(x)).result());
    }

    private Object defaultPlusPlus$1(CanBuildFrom bf$1, GenTraversableOnce that$1) {
        Builder b = bf$1.apply(this.repr());
        if (that$1 instanceof IndexedSeqLike) {
            b.sizeHint(this, that$1.seq().size());
        }
        b.$plus$plus$eq(this.thisCollection());
        b.$plus$plus$eq(that$1.seq());
        return b.result();
    }

    private Object defaultPlusPlus$2(CanBuildFrom bf$2, TraversableOnce that$2) {
        Builder b = bf$2.apply(this.repr());
        if (that$2 instanceof IndexedSeqLike) {
            b.sizeHint(this, that$2.size());
        }
        b.$plus$plus$eq(that$2);
        b.$plus$plus$eq(this.thisCollection());
        return b.result();
    }

    /*
     * WARNING - void declaration
     */
    private Builder builder$1(CanBuildFrom bf$3) {
        void var2_2;
        Builder b = bf$3.apply(this.repr());
        b.sizeHint(this);
        return var2_2;
    }

    private Builder builder$2(CanBuildFrom bf$4) {
        return bf$4.apply(this.repr());
    }

    private List noneIn$1(List l, Function1 p$2, boolean isFlipped$2) {
        while (!l.isEmpty()) {
            Object h = l.head();
            List t = (List)l.tail();
            if (BoxesRunTime.unboxToBoolean(p$2.apply(h)) != isFlipped$2) {
                return this.allIn$1(l, t, p$2, isFlipped$2);
            }
            l = t;
        }
        return Nil$.MODULE$;
    }

    private List allIn$1(List start, List remaining, Function1 p$2, boolean isFlipped$2) {
        while (true) {
            if (remaining.isEmpty()) {
                return start;
            }
            Object x = remaining.head();
            if (BoxesRunTime.unboxToBoolean(p$2.apply(x)) == isFlipped$2) break;
            remaining = (List)remaining.tail();
        }
        return TraversableLike.partialFill$1(start, remaining, p$2, isFlipped$2);
    }

    private static List partialFill$1(List origStart, List firstMiss, Function1 p$2, boolean isFlipped$2) {
        List next;
        $colon$colon<Nothing$> newHead = new $colon$colon<Nothing$>((Nothing$)origStart.head(), Nil$.MODULE$);
        $colon$colon<Nothing$> currentLast = newHead;
        for (List toProcess = (List)origStart.tail(); toProcess != firstMiss; toProcess = (List)toProcess.tail()) {
            $colon$colon<Nothing$> newElem = new $colon$colon<Nothing$>((Nothing$)toProcess.head(), Nil$.MODULE$);
            currentLast.tl_$eq(newElem);
            currentLast = newElem;
        }
        List nextToCopy = next = (List)firstMiss.tail();
        while (!next.isEmpty()) {
            Object head = next.head();
            if (BoxesRunTime.unboxToBoolean(p$2.apply(head)) != isFlipped$2) {
                next = (List)next.tail();
                continue;
            }
            while (nextToCopy != next) {
                $colon$colon<Nothing$> newElem = new $colon$colon<Nothing$>((Nothing$)nextToCopy.head(), Nil$.MODULE$);
                currentLast.tl_$eq(newElem);
                currentLast = newElem;
                nextToCopy = (List)nextToCopy.tail();
            }
            nextToCopy = (List)next.tail();
            next = (List)next.tail();
        }
        if (!nextToCopy.isEmpty()) {
            currentLast.tl_$eq(nextToCopy);
        }
        return newHead;
    }

    public static /* synthetic */ Builder $anonfun$groupBy$1(TraversableLike $this, Function1 f$3, scala.collection.mutable.Map m$1, Object elem) {
        Object key = f$3.apply(elem);
        return ((Builder)m$1.getOrElseUpdate(key, (Function0<Builder> & java.io.Serializable & Serializable)() -> $this.newBuilder())).$plus$eq(elem);
    }

    public static /* synthetic */ void $anonfun$forall$2(Function1 p$4, BooleanRef result$2, Object x) {
        if (!BoxesRunTime.unboxToBoolean(p$4.apply(x))) {
            result$2.elem = false;
            throw Traversable$.MODULE$.breaks().break();
        }
    }

    public static /* synthetic */ void $anonfun$exists$2(Function1 p$5, BooleanRef result$3, Object x) {
        if (BoxesRunTime.unboxToBoolean(p$5.apply(x))) {
            result$3.elem = true;
            throw Traversable$.MODULE$.breaks().break();
        }
    }

    public static /* synthetic */ void $anonfun$find$2(Function1 p$6, ObjectRef result$4, Object x) {
        if (BoxesRunTime.unboxToBoolean(p$6.apply(x))) {
            result$4.elem = new Some<Object>(x);
            throw Traversable$.MODULE$.breaks().break();
        }
    }

    public static /* synthetic */ void $anonfun$scanRight$1(ObjectRef acc$2, Function2 op$2, ObjectRef scanned$1, Object x) {
        acc$2.elem = op$2.apply(x, acc$2.elem);
        scanned$1.elem = ((List)scanned$1.elem).$colon$colon(acc$2.elem);
    }

    public static /* synthetic */ void $anonfun$init$1(BooleanRef follow$1, Builder b$8, ObjectRef lst$2, Object x) {
        if (follow$1.elem) {
            b$8.$plus$eq(lst$2.elem);
        } else {
            follow$1.elem = true;
        }
        lst$2.elem = x;
    }

    public static /* synthetic */ void $anonfun$sliceInternal$2(IntRef i$1, int from$1, Builder b$9, int until$1, Object x) {
        if (i$1.elem >= from$1) {
            b$9.$plus$eq(x);
        }
        ++i$1.elem;
        if (i$1.elem >= until$1) {
            throw Traversable$.MODULE$.breaks().break();
        }
    }

    public static /* synthetic */ void $anonfun$splitAt$1(IntRef i$2, int n$1, Builder l$3, Builder r$3, Object x) {
        (i$2.elem < n$1 ? l$3 : r$3).$plus$eq(x);
        ++i$2.elem;
    }

    public static /* synthetic */ void $anonfun$copyToArray$2(IntRef i$3, int end$1, Object xs$1, Object x) {
        if (i$3.elem >= end$1) {
            throw Traversable$.MODULE$.breaks().break();
        }
        ScalaRunTime$.MODULE$.array_update(xs$1, i$3.elem, x);
        ++i$3.elem;
    }

    private static boolean isPartLikelySynthetic$1(String fqn$1, int partStart$1) {
        char firstChar = fqn$1.charAt(partStart$1);
        return firstChar > 'Z' && firstChar < '\u007f' || firstChar < 'A';
    }

    public static /* synthetic */ boolean $anonfun$iterateUntilEmpty$1(Traversable x) {
        return !x.isEmpty();
    }

    public static void $init$(TraversableLike $this) {
    }

    public static /* synthetic */ Object $anonfun$scanRight$1$adapted(ObjectRef acc$2, Function2 op$2, ObjectRef scanned$1, Object x) {
        TraversableLike.$anonfun$scanRight$1(acc$2, op$2, scanned$1, x);
        return BoxedUnit.UNIT;
    }

    public class WithFilter
    implements FilterMonadic<A, Repr> {
        private final Function1<A, Object> p;
        public final /* synthetic */ TraversableLike $outer;

        @Override
        public <B, That> That map(Function1<A, B> f, CanBuildFrom<Repr, B, That> bf) {
            Builder b = bf.apply(this.scala$collection$TraversableLike$WithFilter$$$outer().repr());
            this.scala$collection$TraversableLike$WithFilter$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                if (BoxesRunTime.unboxToBoolean($this.p.apply(x))) {
                    return b.$plus$eq((Object)f.apply(x));
                }
                return BoxedUnit.UNIT;
            });
            return b.result();
        }

        @Override
        public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<Repr, B, That> bf) {
            Builder b = bf.apply(this.scala$collection$TraversableLike$WithFilter$$$outer().repr());
            this.scala$collection$TraversableLike$WithFilter$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                if (BoxesRunTime.unboxToBoolean($this.p.apply(x))) {
                    return b.$plus$plus$eq(((GenTraversableOnce)f.apply(x)).seq());
                }
                return BoxedUnit.UNIT;
            });
            return b.result();
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            this.scala$collection$TraversableLike$WithFilter$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x -> {
                if (BoxesRunTime.unboxToBoolean($this.p.apply(x))) {
                    return f.apply(x);
                }
                return BoxedUnit.UNIT;
            });
        }

        public WithFilter withFilter(Function1<A, Object> q) {
            return new WithFilter(this.scala$collection$TraversableLike$WithFilter$$$outer(), (Function1<Object, Object> & java.io.Serializable & Serializable)x -> BoxesRunTime.boxToBoolean(WithFilter.$anonfun$withFilter$1(this, q, x)));
        }

        public /* synthetic */ TraversableLike scala$collection$TraversableLike$WithFilter$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ boolean $anonfun$withFilter$1(WithFilter $this, Function1 q$1, Object x) {
            return BoxesRunTime.unboxToBoolean($this.p.apply(x)) && BoxesRunTime.unboxToBoolean(q$1.apply(x));
        }

        public WithFilter(TraversableLike $outer, Function1<A, Object> p) {
            this.p = p;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }
}

