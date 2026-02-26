/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SerializedLambda;
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
import scala.collection.GenIterable;
import scala.collection.GenMapLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.MapLike;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.SortedMapLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Sorted;
import scala.collection.generic.SortedMapFactory;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.HasForeachEntry;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.RedBlackTree;
import scala.collection.immutable.RedBlackTree$;
import scala.collection.immutable.Set;
import scala.collection.immutable.SortedMap;
import scala.collection.immutable.SortedMap$;
import scala.collection.immutable.SortedSet;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Traversable;
import scala.collection.immutable.TreeMap$;
import scala.collection.immutable.TreeMap$TreeMapBuilder$adder$;
import scala.collection.immutable.TreeSet;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.package;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParMap;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.Nothing$;
import scala.util.hashing.MurmurHash3$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u0011Eu!B,Y\u0011\u0003yf!B1Y\u0011\u0003\u0011\u0007bBA\"\u0003\u0011\u000511\u0017\u0005\b\u0005W\tA\u0011AB[\u0011\u001d\u0019I-\u0001C\u0002\u0007\u0017Dq!!\u0015\u0002\t\u0003\u001aiO\u0002\u0004\u0005\u0004\u00051AQ\u0001\u0005\u000b\u0003_1!\u0011!Q\u0001\f\u0011]\u0001bBA\"\r\u0011\u0005A\u0011D\u0003\u0007\u0003W1\u0001\u0001\"\t\t\u0011\u0005}a\u0001)Q\u0005\tGAq\u0001b\n\u0007\t\u0003\"IcB\u0004\u00050\u0019AI\u0001\"\r\u0007\u000f\u0011Mb\u0001#\u0003\u00056!9\u00111I\u0007\u0005\u0002\u0011e\u0002\"\u0003C\u001e\u001b\u0001\u0007I\u0011\u0001C\u001f\u0011%!y$\u0004a\u0001\n\u0003!\t\u0005\u0003\u0005\u0005H5\u0001\u000b\u0015\u0002C\u0012\u0011\u001d!I%\u0004C\u0001\t\u0017Bq\u0001\"\u0016\u000e\t\u0003!9\u0006C\u0004\u0005b5!\t\u0005b\u0019\t\u000f\u0011%d\u0001\"\u0011\u0005l!9AQ\u000f\u0004\u0005B\u0011]\u0004b\u0002C=\r\u0011\u0005C1\u0010\u0005\n\t{\n\u0011\u0011!C\u0005\t\u007f2A!\u0019-\u0003U\"Q\u0011qD\r\u0003\u0002\u0003\u0006I!!\t\t\u0015\u0005=\u0012D!b\u0001\n\u0007\t\t\u0004\u0003\u0006\u0002Be\u0011\t\u0011)A\u0005\u0003gAq!a\u0011\u001a\t\u0013\t)\u0005C\u0004\u0002Ne!I!a\u0014\t\u0011\u0005E\u0013\u0004)C)\u0003'Bq!a\u001a\u001a\t\u0003\nI\u0007C\u0004\u0002De!\t!!\u001d\t\u000f\u0005]\u0014\u0004\"\u0011\u0002z!9\u0011\u0011R\r\u0005B\u0005-\u0005bBA?3\u0011\u0005\u0013\u0011\u0013\u0005\b\u0003+KB\u0011IAL\u0011\u001d\t9)\u0007C!\u00037Cq!a(\u001a\t\u0003\n\t\u000bC\u0004\u0002$f!\t%!)\t\u000f\u0005\u0015\u0016\u0004\"\u0011\u0002(\"9\u0011\u0011W\r\u0005B\u0005M\u0006bBA[3\u0011\u0005\u0013q\u0017\u0005\b\u0003wKB\u0011IAZ\u0011\u001d\ti,\u0007C!\u0003oCq!a0\u001a\t\u0003\n\t\rC\u0004\u0002Df!\t%!1\t\u000f\u0005\u0015\u0017\u0004\"\u0011\u0002H\"9\u0011QZ\r\u0005B\u0005=\u0007bBAj3\u0011%\u0011Q\u001b\u0005\b\u0003SLB\u0011IAv\u0011\u001d\t\t0\u0007C!\u0003gDq!a>\u001a\t\u0003\nI\u0010C\u0004\u0002~f!\t%a@\t\u0011\t\u0015\u0011\u0004)C\u0005\u0005\u000fAqA!\u0007\u001a\t\u0003\u0012Y\u0002C\u0004\u0003 e!\tE!\t\t\u000f\t\u0015\u0012\u0004\"\u0011\u0003(!9!1F\r\u0005B\u0005\u0005\u0007b\u0002B\u00173\u0011\u0005#q\u0006\u0005\b\u0005\u0003JB\u0011\tB\"\u0011\u001d\u0011\t%\u0007C!\u0005'BqA!\u001d\u001a\t\u0003\u0012\u0019\bC\u0004\u0003\nf!\tAa#\t\u000f\te\u0015\u0004\"\u0001\u0003\u001c\"A!qT\r\u0005\u0002i\u0013\t\u000bC\u0004\u0003.f!\tEa,\t\u000f\tU\u0016\u0004\"\u0011\u00038\"9!QZ\r\u0005B\t=\u0007b\u0002Bl3\u0011\u0005#\u0011\u001c\u0005\b\u0005?LB\u0011\tBq\u0011\u001d\u0011)/\u0007C!\u0005ODqAa;\u001a\t\u0003\u0012i\u000fC\u0004\u0003rf!\tEa=\t\u000f\t]\u0018\u0004\"\u0011\u0003z\"9!Q`\r\u0005B\t}\bbBB\u00023\u0011\u00053Q\u0001\u0005\t\u00077IB\u0011\t-\u0004\u001e!91QF\r\u0005B\r=\u0002bBB\u00193\u0011\u000531\u0007\u0005\b\u0007wIB\u0011IB\u001f\u0011\u001d\u0019\u0019%\u0007C!\u0007\u000bB\u0001b!\u0017\u001a\t\u0003b61\f\u0005\b\u0007GJB\u0011IB3\u0011\u001d\u0019I'\u0007C\u0005\u0007WBqaa#\u001a\t\u0003\u001ai)A\u0004Ue\u0016,W*\u00199\u000b\u0005eS\u0016!C5n[V$\u0018M\u00197f\u0015\tYF,\u0001\u0006d_2dWm\u0019;j_:T\u0011!X\u0001\u0006g\u000e\fG.Y\u0002\u0001!\t\u0001\u0017!D\u0001Y\u0005\u001d!&/Z3NCB\u001cB!A2\u0002\u0014A\u0019AmZ5\u000e\u0003\u0015T!A\u001a.\u0002\u000f\u001d,g.\u001a:jG&\u0011\u0001.\u001a\u0002\u001a\u00136lW\u000f^1cY\u0016\u001cvN\u001d;fI6\u000b\u0007OR1di>\u0014\u0018\u0010\u0005\u0002a3U\u00191.^@\u0014\u0017ea\u0007/a\u0001\u0002\u000e\u0005M\u0011\u0011\u0004\t\u0003[:l\u0011\u0001X\u0005\u0003_r\u0013a!\u00118z%\u00164\u0007\u0003\u00021rgzL!A\u001d-\u0003\u0013M{'\u000f^3e\u001b\u0006\u0004\bC\u0001;v\u0019\u0001!QA^\rC\u0002]\u0014\u0011!Q\t\u0003qn\u0004\"!\\=\n\u0005id&a\u0002(pi\"Lgn\u001a\t\u0003[rL!! /\u0003\u0007\u0005s\u0017\u0010\u0005\u0002u\u007f\u00129\u0011\u0011A\r\u0005\u0006\u00049(!\u0001\"\u0011\u0011\u0005\u0015\u0011qA:\u007f\u0003\u0017i\u0011AW\u0005\u0004\u0003\u0013Q&!D*peR,G-T1q\u0019&\\W\r\u0005\u0003a3Mt\bc\u00021\u0002\u0010Mt\u00181B\u0005\u0004\u0003#A&aB'ba2K7.\u001a\t\u0004[\u0006U\u0011bAA\f9\na1+\u001a:jC2L'0\u00192mKB)\u0001-a\u0007t}&\u0019\u0011Q\u0004-\u0003\u001f!\u000b7OR8sK\u0006\u001c\u0007.\u00128uef\fA\u0001\u001e:fKB1\u00111EA\u0015gzt1\u0001YA\u0013\u0013\r\t9\u0003W\u0001\r%\u0016$'\t\\1dWR\u0013X-Z\u0005\u0005\u0003W\tiC\u0001\u0003Ue\u0016,'bAA\u00141\u0006AqN\u001d3fe&tw-\u0006\u0002\u00024A)\u0011QGA\u001eg:\u0019Q.a\u000e\n\u0007\u0005eB,A\u0004qC\u000e\\\u0017mZ3\n\t\u0005u\u0012q\b\u0002\t\u001fJ$WM]5oO*\u0019\u0011\u0011\b/\u0002\u0013=\u0014H-\u001a:j]\u001e\u0004\u0013A\u0002\u001fj]&$h\b\u0006\u0003\u0002H\u0005-C\u0003BA\u0006\u0003\u0013Bq!a\f\u001e\u0001\b\t\u0019\u0004C\u0004\u0002 u\u0001\r!!\t\u0002\u000bQ\u0014X-\u001a\u0019\u0016\u0005\u0005\u0005\u0012A\u00038fo\n+\u0018\u000e\u001c3feV\u0011\u0011Q\u000b\t\t\u0003/\ni&!\u0019\u0002\f5\u0011\u0011\u0011\f\u0006\u0004\u00037R\u0016aB7vi\u0006\u0014G.Z\u0005\u0005\u0003?\nIFA\u0004Ck&dG-\u001a:\u0011\u000b5\f\u0019g\u001d@\n\u0007\u0005\u0015DL\u0001\u0004UkBdWMM\u0001\u0005g&TX-\u0006\u0002\u0002lA\u0019Q.!\u001c\n\u0007\u0005=DLA\u0002J]R$\"!a\u001d\u0015\t\u0005-\u0011Q\u000f\u0005\b\u0003_\t\u00039AA\u001a\u0003%\u0011\u0018M\\4f\u00136\u0004H\u000e\u0006\u0004\u0002\f\u0005m\u0014Q\u0011\u0005\b\u0003{\u0012\u0003\u0019AA@\u0003\u00111'o\\7\u0011\t5\f\ti]\u0005\u0004\u0003\u0007c&AB(qi&|g\u000eC\u0004\u0002\b\n\u0002\r!a \u0002\u000bUtG/\u001b7\u0002\u000bI\fgnZ3\u0015\r\u0005-\u0011QRAH\u0011\u0019\tih\ta\u0001g\"1\u0011qQ\u0012A\u0002M$B!a\u0003\u0002\u0014\"1\u0011Q\u0010\u0013A\u0002M\f!\u0001^8\u0015\t\u0005-\u0011\u0011\u0014\u0005\u0007\u0003++\u0003\u0019A:\u0015\t\u0005-\u0011Q\u0014\u0005\u0007\u0003\u000f3\u0003\u0019A:\u0002\u0011\u0019L'o\u001d;LKf,\u0012a]\u0001\bY\u0006\u001cHoS3z\u0003\u001d\u0019w.\u001c9be\u0016$b!a\u001b\u0002*\u00065\u0006BBAVS\u0001\u00071/\u0001\u0002la!1\u0011qV\u0015A\u0002M\f!a[\u0019\u0002\t!,\u0017\rZ\u000b\u0003\u0003C\n!\u0002[3bI>\u0003H/[8o+\t\tI\fE\u0003n\u0003\u0003\u000b\t'\u0001\u0003mCN$\u0018A\u00037bgR|\u0005\u000f^5p]\u0006!A/Y5m+\t\tY!\u0001\u0003j]&$\u0018\u0001\u00023s_B$B!a\u0003\u0002J\"9\u00111\u001a\u0019A\u0002\u0005-\u0014!\u00018\u0002\tQ\f7.\u001a\u000b\u0005\u0003\u0017\t\t\u000eC\u0004\u0002LF\u0002\r!a\u001b\u0002\u00199,w/T1q\u001fJ\u001cV\r\u001c4\u0016\t\u0005]\u0017Q\u001c\u000b\u0005\u00033\f\u0019\u000fE\u0003a3M\fY\u000eE\u0002u\u0003;$q!a83\u0005\u0004\t\tO\u0001\u0002CcE\u0011ap\u001f\u0005\b\u0003K\u0014\u0004\u0019AAt\u0003\u001dqWm\u001e+sK\u0016\u0004r!a\t\u0002*M\fY.A\u0003tY&\u001cW\r\u0006\u0004\u0002\f\u00055\u0018q\u001e\u0005\b\u0003{\u001a\u0004\u0019AA6\u0011\u001d\t9i\ra\u0001\u0003W\n\u0011\u0002\u001a:paJKw\r\u001b;\u0015\t\u0005-\u0011Q\u001f\u0005\b\u0003\u0017$\u0004\u0019AA6\u0003%!\u0018m[3SS\u001eDG\u000f\u0006\u0003\u0002\f\u0005m\bbBAfk\u0001\u0007\u00111N\u0001\bgBd\u0017\u000e^!u)\u0011\u0011\tAa\u0001\u0011\u000f5\f\u0019'a\u0003\u0002\f!9\u00111\u001a\u001cA\u0002\u0005-\u0014AC2pk:$x\u000b[5mKR!\u00111\u000eB\u0005\u0011\u001d\u0011Ya\u000ea\u0001\u0005\u001b\t\u0011\u0001\u001d\t\b[\n=\u0011\u0011\rB\n\u0013\r\u0011\t\u0002\u0018\u0002\n\rVt7\r^5p]F\u00022!\u001cB\u000b\u0013\r\u00119\u0002\u0018\u0002\b\u0005>|G.Z1o\u0003%!'o\u001c9XQ&dW\r\u0006\u0003\u0002\f\tu\u0001b\u0002B\u0006q\u0001\u0007!QB\u0001\ni\u0006\\Wm\u00165jY\u0016$B!a\u0003\u0003$!9!1B\u001dA\u0002\t5\u0011\u0001B:qC:$BA!\u0001\u0003*!9!1\u0002\u001eA\u0002\t5\u0011!B3naRL\u0018aB;qI\u0006$X\rZ\u000b\u0005\u0005c\u00119\u0004\u0006\u0004\u00034\te\"Q\b\t\u0006Af\u0019(Q\u0007\t\u0004i\n]BaBApy\t\u0007\u0011\u0011\u001d\u0005\u0007\u0005wa\u0004\u0019A:\u0002\u0007-,\u0017\u0010C\u0004\u0003@q\u0002\rA!\u000e\u0002\u000bY\fG.^3\u0002\u000b\u0011\u0002H.^:\u0016\t\t\u0015#1\n\u000b\u0005\u0005\u000f\u0012i\u0005E\u0003a3M\u0014I\u0005E\u0002u\u0005\u0017\"q!a8>\u0005\u0004\t\t\u000fC\u0004\u0003Pu\u0002\rA!\u0015\u0002\u0005-4\bCB7\u0002dM\u0014I%\u0006\u0003\u0003V\tmC\u0003\u0003B,\u0005;\u0012\u0019Ga\u001a\u0011\u000b\u0001L2O!\u0017\u0011\u0007Q\u0014Y\u0006B\u0004\u0002`z\u0012\r!!9\t\u000f\t}c\b1\u0001\u0003b\u0005)Q\r\\3ncA1Q.a\u0019t\u00053BqA!\u001a?\u0001\u0004\u0011\t'A\u0003fY\u0016l'\u0007C\u0004\u0003jy\u0002\rAa\u001b\u0002\u000b\u0015dW-\\:\u0011\u000b5\u0014iG!\u0019\n\u0007\t=DL\u0001\u0006=e\u0016\u0004X-\u0019;fIz\n!\u0002\n9mkN$\u0003\u000f\\;t+\u0011\u0011)Ha\u001f\u0015\t\t]$Q\u0010\t\u0006Af\u0019(\u0011\u0010\t\u0004i\nmDaBAp\u007f\t\u0007\u0011\u0011\u001d\u0005\b\u0005\u007fz\u0004\u0019\u0001BA\u0003\tA8\u000f\u0005\u0004\u0002\u0006\t\r%qQ\u0005\u0004\u0005\u000bS&AE$f]R\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\u0004b!\\A2g\ne\u0014AB5og\u0016\u0014H/\u0006\u0003\u0003\u000e\nMEC\u0002BH\u0005+\u00139\nE\u0003a3M\u0014\t\nE\u0002u\u0005'#q!a8A\u0005\u0004\t\t\u000f\u0003\u0004\u0003<\u0001\u0003\ra\u001d\u0005\b\u0005\u007f\u0001\u0005\u0019\u0001BI\u0003\u0019!S.\u001b8vgR!\u00111\u0002BO\u0011\u0019\u0011Y$\u0011a\u0001g\u0006i!/Z7pm\u0016\fE\u000e\\%na2$B!a\u0003\u0003$\"9!Q\u0015\"A\u0002\t\u001d\u0016A\u0001;t!\u0011\u0001'\u0011V:\n\u0007\t-\u0006LA\u0004Ue\u0016,7+\u001a;\u0002\u0007\u001d,G\u000f\u0006\u0003\u00032\nM\u0006\u0003B7\u0002\u0002zDaAa\u000fD\u0001\u0004\u0019\u0018!C4fi>\u0013X\t\\:f+\u0011\u0011IL!0\u0015\r\tm&\u0011\u0019Bb!\r!(Q\u0018\u0003\b\u0005\u007f#%\u0019AAq\u0005\t1\u0016\u0007\u0003\u0004\u0003<\u0011\u0003\ra\u001d\u0005\t\u0005\u000b$E\u00111\u0001\u0003H\u00069A-\u001a4bk2$\b#B7\u0003J\nm\u0016b\u0001Bf9\nAAHY=oC6,g(\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\u0011\t\u000e\u0005\u0004\u0002\u0006\tM\u0017\u0011M\u0005\u0004\u0005+T&\u0001C%uKJ\fGo\u001c:\u0002\u0019%$XM]1u_J4%o\\7\u0015\t\tE'1\u001c\u0005\u0007\u0005;4\u0005\u0019A:\u0002\u000bM$\u0018M\u001d;\u0002\u0019-,\u0017p]%uKJ\fGo\u001c:\u0016\u0005\t\r\b#BA\u0003\u0005'\u001c\u0018\u0001E6fsNLE/\u001a:bi>\u0014hI]8n)\u0011\u0011\u0019O!;\t\r\tu\u0007\n1\u0001t\u000391\u0018\r\\;fg&#XM]1u_J,\"Aa<\u0011\u000b\u0005\u0015!1\u001b@\u0002%Y\fG.^3t\u0013R,'/\u0019;pe\u001a\u0013x.\u001c\u000b\u0005\u0005_\u0014)\u0010\u0003\u0004\u0003^*\u0003\ra]\u0001\tG>tG/Y5ogR!!1\u0003B~\u0011\u0019\u0011Yd\u0013a\u0001g\u0006Y\u0011n\u001d#fM&tW\rZ!u)\u0011\u0011\u0019b!\u0001\t\r\tmB\n1\u0001t\u0003\u001d1wN]3bG\",Baa\u0002\u0004\u0018Q!1\u0011BB\b!\ri71B\u0005\u0004\u0007\u001ba&\u0001B+oSRDqa!\u0005N\u0001\u0004\u0019\u0019\"A\u0001g!\u001di'qBA1\u0007+\u00012\u0001^B\f\t\u0019\u0019I\"\u0014b\u0001o\n\tQ+\u0001\u0007g_J,\u0017m\u00195F]R\u0014\u00180\u0006\u0003\u0004 \r-B\u0003BB\u0005\u0007CAqa!\u0005O\u0001\u0004\u0019\u0019\u0003E\u0004n\u0007K\u0019hp!\u000b\n\u0007\r\u001dBLA\u0005Gk:\u001cG/[8oeA\u0019Aoa\u000b\u0005\r\reaJ1\u0001x\u0003!A\u0017m\u001d5D_\u0012,GCAA6\u0003\u0019YW-_*fiV\u00111Q\u0007\t\u0005A\u000e]2/C\u0002\u0004:a\u0013\u0011bU8si\u0016$7+\u001a;\u0002\r\u0015\fX/\u00197t)\u0011\u0011\u0019ba\u0010\t\r\r\u0005\u0013\u000b1\u0001|\u0003\ry'M[\u0001\u0007m\u0006dW/Z:\u0016\u0005\r\u001d\u0003#BB%\u0007+rh\u0002BB&\u0003oqAa!\u0014\u0004T5\u00111q\n\u0006\u0004\u0007#r\u0016A\u0002\u001fs_>$h(C\u0001^\u0013\u0011\u00199&a\u0010\u0003\u0011%#XM]1cY\u0016\f!BZ5mi\u0016\u0014\u0018*\u001c9m)\u0019\tYa!\u0018\u0004`!91\u0011C*A\u0002\t5\u0001bBB1'\u0002\u0007!1C\u0001\nSN4E.\u001b9qK\u0012\f\u0011\u0002]1si&$\u0018n\u001c8\u0015\t\t\u00051q\r\u0005\b\u0005\u0017!\u0006\u0019\u0001B\u0007\u0003\u001d\u0019\u0018-\\3D\u0005\u001a#BAa\u0005\u0004n!91qN+A\u0002\rE\u0014A\u00012ga!\u0019\u0019ha\u001f\u0004\u0002\u000e\u001d\u0005#\u00033\u0004v\re4qPBC\u0013\r\u00199(\u001a\u0002\r\u0007\u0006t')^5mI\u001a\u0013x.\u001c\t\u0004i\u000emDaCB?\u0007[\n\t\u0011!A\u0003\u0002]\u00141a\u0018\u00132!\r!8\u0011\u0011\u0003\f\u0007\u0007\u001bi'!A\u0001\u0002\u000b\u0005qOA\u0002`II\u00022\u0001^BD\t-\u0019Ii!\u001c\u0002\u0002\u0003\u0005)\u0011A<\u0003\u0007}#3'A\u0005ue\u0006t7OZ8s[V11qRBQ\u0007+#Ba!%\u0004&R!11SBM!\r!8Q\u0013\u0003\u0007\u0007/3&\u0019A<\u0003\tQC\u0017\r\u001e\u0005\b\u0007_2\u00069ABN!%!7QOA\u0006\u0007;\u001b\u0019\n\u0005\u0004n\u0003G\u001a8q\u0014\t\u0004i\u000e\u0005FABBR-\n\u0007qOA\u0001X\u0011\u001d\u0019\tB\u0016a\u0001\u0007O\u0003r!\\B\u0013gz\u001cy\nK\u0004\u001a\u0007W\u0013yd!-\u0011\u00075\u001ci+C\u0002\u00040r\u0013\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u001f\u0011\u0005s\u0007c#2t`\u000b'\u0012aX\u000b\u0007\u0007o\u001bil!1\u0015\t\re61\u0019\t\u0007Af\u0019Yla0\u0011\u0007Q\u001ci\fB\u0003w\u0007\t\u0007q\u000fE\u0002u\u0007\u0003$a!!\u0001\u0004\u0005\u00049\bbBBc\u0007\u0001\u000f1qY\u0001\u0004_J$\u0007CBA\u001b\u0003w\u0019Y,\u0001\u0007dC:\u0014U/\u001b7e\rJ|W.\u0006\u0004\u0004N\u000e\u00058Q\u001d\u000b\u0005\u0007\u001f\u001cI\u000fE\u0005e\u0007k\u001a\tn!8\u0004hB!11[Bk\u001b\u0005\t\u0011\u0002BBl\u00073\u0014AaQ8mY&\u001911\\3\u0003!M{'\u000f^3e\u001b\u0006\u0004h)Y2u_JL\bcB7\u0002d\r}71\u001d\t\u0004i\u000e\u0005H!\u0002<\u0005\u0005\u00049\bc\u0001;\u0004f\u00121\u0011\u0011\u0001\u0003C\u0002]\u0004b\u0001Y\r\u0004`\u000e\r\bbBBc\t\u0001\u000f11\u001e\t\u0007\u0003k\tYda8\u0016\r\r=8q_B~)\u0011\u0019\tpa@\u0011\u0011\u0005]\u0013QLBz\u0007{\u0004r!\\A2\u0007k\u001cI\u0010E\u0002u\u0007o$QA^\u0003C\u0002]\u00042\u0001^B~\t\u0019\t\t!\u0002b\u0001oB1\u0001-GB{\u0007sDqa!2\u0006\u0001\b!\t\u0001\u0005\u0004\u00026\u0005m2Q\u001f\u0002\u000f)J,W-T1q\u0005VLG\u000eZ3s+\u0019!9\u0001b\u0004\u0005\u0014M!a\u0001\u001cC\u0005!!\t9&!\u0018\u0005\f\u0011U\u0001cB7\u0002d\u00115A\u0011\u0003\t\u0004i\u0012=A!\u0002<\u0007\u0005\u00049\bc\u0001;\u0005\u0014\u00111\u0011\u0011\u0001\u0004C\u0002]\u0004b\u0001Y\r\u0005\u000e\u0011E\u0001CBA\u001b\u0003w!i\u0001\u0006\u0002\u0005\u001cQ!AQ\u0004C\u0010!\u001d\u0019\u0019N\u0002C\u0007\t#Aq!a\f\t\u0001\b!9\u0002\u0005\u0005\u0002$\u0005%BQ\u0002C\t!\r!)#C\u0007\u0002\r\u0005AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0003\u0005&\u0011-\u0002b\u0002C\u0017\u0017\u0001\u0007A1B\u0001\u0005K2,W.A\u0003bI\u0012,'\u000fE\u0002\u0005&5\u0011Q!\u00193eKJ\u001cB!\u00047\u00058AIQn!\n\u0005\u000e\u0011E1\u0011\u0002\u000b\u0003\tc\t1\"Y2dk6,H.\u0019;peV\u0011A1E\u0001\u0010C\u000e\u001cW/\\;mCR|'o\u0018\u0013fcR!1\u0011\u0002C\"\u0011%!)\u0005EA\u0001\u0002\u0004!\u0019#A\u0002yIE\nA\"Y2dk6,H.\u0019;pe\u0002\nq!\u00193e)J,W\r\u0006\u0004\u0005$\u00115C\u0011\u000b\u0005\b\t\u001f\u0012\u0002\u0019\u0001C\u0012\u0003\u0015\tGK]3f\u0011\u001d!\u0019F\u0005a\u0001\tG\tQA\u0019+sK\u0016\f!\"\u00193e\r>\u0014X)Y2i)\u0019!\u0019\u0003\"\u0017\u0005\\!9AqJ\nA\u0002\u0011\r\u0002b\u0002C/'\u0001\u0007AqL\u0001\u000bQ\u0006\u001chi\u001c:FC\u000eD\u0007c\u00021\u0002\u001c\u00115A\u0011C\u0001\u0006CB\u0004H.\u001f\u000b\u0007\u0007\u0013!)\u0007b\u001a\t\u000f\tmB\u00031\u0001\u0005\u000e!9!q\b\u000bA\u0002\u0011E\u0011!\u0004\u0013qYV\u001cH\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0003\u0005&\u00115\u0004b\u0002B@+\u0001\u0007Aq\u000e\t\u0007\u0003\u000b!\t\bb\u0003\n\u0007\u0011M$LA\bUe\u00064XM]:bE2,wJ\\2f\u0003\u0015\u0019G.Z1s)\t\u0019I!\u0001\u0004sKN,H\u000e\u001e\u000b\u0003\t+\t1B]3bIJ+7o\u001c7wKR\u0011A\u0011\u0011\t\u0005\t\u0007#i)\u0004\u0002\u0005\u0006*!Aq\u0011CE\u0003\u0011a\u0017M\\4\u000b\u0005\u0011-\u0015\u0001\u00026bm\u0006LA\u0001b$\u0005\u0006\n1qJ\u00196fGR\u0004")
public final class TreeMap<A, B>
implements SortedMap<A, B>,
Serializable,
HasForeachEntry<A, B> {
    public static final long serialVersionUID = 4714724050750123970L;
    private final RedBlackTree.Tree<A, B> tree;
    private final Ordering<A> ordering;

    public static <A, B> CanBuildFrom<TreeMap<?, ?>, Tuple2<A, B>, TreeMap<A, B>> canBuildFrom(Ordering<A> ordering) {
        return TreeMap$.MODULE$.canBuildFrom(ordering);
    }

    @Override
    public /* synthetic */ boolean scala$collection$immutable$SortedMap$$super$equals(Object that) {
        return GenMapLike.equals$(this, that);
    }

    @Override
    public SortedMap<A, B> filterKeys(Function1<A, Object> p) {
        return SortedMap.filterKeys$(this, p);
    }

    @Override
    public <C> SortedMap<A, C> mapValues(Function1<B, C> f) {
        return SortedMap.mapValues$(this, f);
    }

    @Override
    public boolean hasAll(Iterator<A> j) {
        return Sorted.hasAll$(this, j);
    }

    @Override
    public <T, U> scala.collection.immutable.Map<T, U> toMap(Predef$.less.colon.less<Tuple2<A, B>, Tuple2<T, U>> ev) {
        return scala.collection.immutable.Map.toMap$(this, ev);
    }

    @Override
    public scala.collection.immutable.Map<A, B> seq() {
        return scala.collection.immutable.Map.seq$(this);
    }

    @Override
    public <V1> scala.collection.immutable.Map<A, V1> withDefault(Function1<A, V1> d) {
        return scala.collection.immutable.Map.withDefault$(this, d);
    }

    @Override
    public <V1> scala.collection.immutable.Map<A, V1> withDefaultValue(V1 d) {
        return scala.collection.immutable.Map.withDefaultValue$(this, d);
    }

    @Override
    public Combiner<Tuple2<A, B>, ParMap<A, B>> parCombiner() {
        return scala.collection.immutable.MapLike.parCombiner$(this);
    }

    @Override
    public boolean isEmpty() {
        return MapLike.isEmpty$(this);
    }

    @Override
    public B apply(A key) {
        return (B)MapLike.apply$(this, key);
    }

    @Override
    public <K1 extends A, V1> V1 applyOrElse(K1 x, Function1<K1, V1> function1) {
        return (V1)MapLike.applyOrElse$(this, x, function1);
    }

    @Override
    public Iterable<A> keys() {
        return MapLike.keys$(this);
    }

    @Override
    public B default(A key) {
        return (B)MapLike.default$(this, key);
    }

    @Override
    public Map filterNot(Function1 p) {
        return MapLike.filterNot$(this, p);
    }

    @Override
    public Seq<Tuple2<A, B>> toSeq() {
        return MapLike.toSeq$(this);
    }

    @Override
    public <E> Buffer<E> toBuffer() {
        return MapLike.toBuffer$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return MapLike.addString$(this, b, start, sep, end);
    }

    @Override
    public String stringPrefix() {
        return MapLike.stringPrefix$(this);
    }

    @Override
    public String toString() {
        return MapLike.toString$(this);
    }

    @Override
    public Subtractable $minus(Object elem1, Object elem2, Seq elems) {
        return Subtractable.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public Subtractable $minus$minus(GenTraversableOnce xs) {
        return Subtractable.$minus$minus$(this, xs);
    }

    @Override
    public <A1 extends A, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
        return PartialFunction.orElse$(this, that);
    }

    @Override
    public <C> PartialFunction<A, C> andThen(Function1<B, C> k) {
        return PartialFunction.andThen$(this, k);
    }

    @Override
    public Function1<A, Option<B>> lift() {
        return PartialFunction.lift$(this);
    }

    @Override
    public <U> Function1<A, Object> runWith(Function1<B, U> action) {
        return PartialFunction.runWith$(this, action);
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, B> compose(Function1<A, A> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public GenericCompanion<scala.collection.immutable.Iterable> companion() {
        return scala.collection.immutable.Iterable.companion$(this);
    }

    @Override
    public Iterable<Tuple2<A, B>> thisCollection() {
        return IterableLike.thisCollection$(this);
    }

    @Override
    public Iterable toCollection(Object repr) {
        return IterableLike.toCollection$(this, repr);
    }

    @Override
    public boolean forall(Function1<Tuple2<A, B>, Object> p) {
        return IterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<Tuple2<A, B>, Object> p) {
        return IterableLike.exists$(this, p);
    }

    @Override
    public Option<Tuple2<A, B>> find(Function1<Tuple2<A, B>, Object> p) {
        return IterableLike.find$(this, p);
    }

    @Override
    public <B> B foldRight(B z, Function2<Tuple2<A, B>, B, B> op) {
        return (B)IterableLike.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceRight(Function2<Tuple2<A, B>, B, B> op) {
        return (B)IterableLike.reduceRight$(this, op);
    }

    @Override
    public Iterable<Tuple2<A, B>> toIterable() {
        return IterableLike.toIterable$(this);
    }

    @Override
    public Iterator<Tuple2<A, B>> toIterator() {
        return IterableLike.toIterator$(this);
    }

    @Override
    public Iterator<TreeMap<A, B>> grouped(int size) {
        return IterableLike.grouped$(this, size);
    }

    @Override
    public Iterator<TreeMap<A, B>> sliding(int size) {
        return IterableLike.sliding$(this, size);
    }

    @Override
    public Iterator<TreeMap<A, B>> sliding(int size, int step) {
        return IterableLike.sliding$(this, size, step);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IterableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<TreeMap<A, B>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zip$(this, that, bf);
    }

    @Override
    public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<TreeMap<A, B>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<TreeMap<A, B>, Tuple2<A1, Object>, That> bf) {
        return (That)IterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public Stream<Tuple2<A, B>> toStream() {
        return IterableLike.toStream$(this);
    }

    @Override
    public boolean canEqual(Object that) {
        return IterableLike.canEqual$(this, that);
    }

    @Override
    public IterableView<Tuple2<A, B>, TreeMap<A, B>> view() {
        return IterableLike.view$(this);
    }

    @Override
    public IterableView<Tuple2<A, B>, TreeMap<A, B>> view(int from, int until) {
        return IterableLike.view$(this, from, until);
    }

    @Override
    public <B> Builder<B, scala.collection.immutable.Iterable<B>> genericBuilder() {
        return GenericTraversableTemplate.genericBuilder$(this);
    }

    @Override
    public <A1, A2> Tuple2<scala.collection.immutable.Iterable<A1>, scala.collection.immutable.Iterable<A2>> unzip(Function1<Tuple2<A, B>, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<scala.collection.immutable.Iterable<A1>, scala.collection.immutable.Iterable<A2>, scala.collection.immutable.Iterable<A3>> unzip3(Function1<Tuple2<A, B>, Tuple3<A1, A2, A3>> asTriple) {
        return GenericTraversableTemplate.unzip3$(this, asTriple);
    }

    @Override
    public GenTraversable flatten(Function1 asTraversable) {
        return GenericTraversableTemplate.flatten$(this, asTraversable);
    }

    @Override
    public GenTraversable transpose(Function1 asTraversable) {
        return GenericTraversableTemplate.transpose$(this, asTraversable);
    }

    @Override
    public Object repr() {
        return TraversableLike.repr$(this);
    }

    @Override
    public final boolean isTraversableAgain() {
        return TraversableLike.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return TraversableLike.hasDefiniteSize$(this);
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(scala.collection.Traversable<B> that, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That map(Function1<Tuple2<A, B>, B> f, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.map$(this, f, bf);
    }

    @Override
    public <B, That> That flatMap(Function1<Tuple2<A, B>, GenTraversableOnce<B>> f, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    @Override
    public Object filter(Function1 p) {
        return TraversableLike.filter$(this, p);
    }

    @Override
    public <B, That> That collect(PartialFunction<Tuple2<A, B>, B> pf, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public <K> scala.collection.immutable.Map<K, TreeMap<A, B>> groupBy(Function1<Tuple2<A, B>, K> f) {
        return TraversableLike.groupBy$(this, f);
    }

    @Override
    public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<TreeMap<A, B>, B, That> cbf) {
        return (That)TraversableLike.scan$(this, z, op, cbf);
    }

    @Override
    public <B, That> That scanLeft(B z, Function2<B, Tuple2<A, B>, B> op, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <B, That> That scanRight(B z, Function2<Tuple2<A, B>, B, B> op, CanBuildFrom<TreeMap<A, B>, B, That> bf) {
        return (That)TraversableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public Object sliceWithKnownDelta(int from, int until, int delta) {
        return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
    }

    @Override
    public Object sliceWithKnownBound(int from, int until) {
        return TraversableLike.sliceWithKnownBound$(this, from, until);
    }

    @Override
    public Iterator<TreeMap<A, B>> tails() {
        return TraversableLike.tails$(this);
    }

    @Override
    public Iterator<TreeMap<A, B>> inits() {
        return TraversableLike.inits$(this);
    }

    @Override
    public scala.collection.Traversable<Tuple2<A, B>> toTraversable() {
        return TraversableLike.toTraversable$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<A, B>, Col> cbf) {
        return (Col)TraversableLike.to$(this, cbf);
    }

    @Override
    public FilterMonadic<Tuple2<A, B>, TreeMap<A, B>> withFilter(Function1<Tuple2<A, B>, Object> p) {
        return TraversableLike.withFilter$(this, p);
    }

    @Override
    public Parallel par() {
        return Parallelizable.par$(this);
    }

    @Override
    public List<Tuple2<A, B>> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<Tuple2<A, B>, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<Tuple2<A, B>, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, Tuple2<A, B>, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<Tuple2<A, B>, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, Tuple2<A, B>, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, Tuple2<A, B>, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<A, B>, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<Tuple2<A, B>, B, B> op) {
        return TraversableOnce.reduceRightOption$(this, op);
    }

    @Override
    public <A1> A1 reduce(Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.reduce$(this, op);
    }

    @Override
    public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
        return TraversableOnce.reduceOption$(this, op);
    }

    @Override
    public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.fold$(this, z, op);
    }

    @Override
    public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<A, B>, B> seqop, Function2<B, B, B> combop) {
        return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <B> B sum(Numeric<B> num) {
        return (B)TraversableOnce.sum$(this, num);
    }

    @Override
    public <B> B product(Numeric<B> num) {
        return (B)TraversableOnce.product$(this, num);
    }

    @Override
    public Object min(Ordering cmp) {
        return TraversableOnce.min$(this, cmp);
    }

    @Override
    public Object max(Ordering cmp) {
        return TraversableOnce.max$(this, cmp);
    }

    @Override
    public Object maxBy(Function1 f, Ordering cmp) {
        return TraversableOnce.maxBy$(this, f, cmp);
    }

    @Override
    public Object minBy(Function1 f, Ordering cmp) {
        return TraversableOnce.minBy$(this, f, cmp);
    }

    @Override
    public <B> void copyToBuffer(Buffer<B> dest) {
        TraversableOnce.copyToBuffer$(this, dest);
    }

    @Override
    public <B> void copyToArray(Object xs, int start) {
        TraversableOnce.copyToArray$(this, xs, start);
    }

    @Override
    public <B> void copyToArray(Object xs) {
        TraversableOnce.copyToArray$(this, xs);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public List<Tuple2<A, B>> toList() {
        return TraversableOnce.toList$(this);
    }

    @Override
    public IndexedSeq<Tuple2<A, B>> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public <B> Set<B> toSet() {
        return TraversableOnce.toSet$(this);
    }

    @Override
    public Vector<Tuple2<A, B>> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return TraversableOnce.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return TraversableOnce.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return TraversableOnce.mkString$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String sep) {
        return TraversableOnce.addString$(this, b, sep);
    }

    @Override
    public StringBuilder addString(StringBuilder b) {
        return TraversableOnce.addString$(this, b);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    @Override
    public Ordering<A> ordering() {
        return this.ordering;
    }

    public RedBlackTree.Tree<A, B> scala$collection$immutable$TreeMap$$tree0() {
        return this.tree;
    }

    @Override
    public Builder<Tuple2<A, B>, TreeMap<A, B>> newBuilder() {
        return TreeMap$.MODULE$.newBuilder(this.ordering());
    }

    @Override
    public int size() {
        return RedBlackTree$.MODULE$.count(this.tree);
    }

    @Override
    public TreeMap<A, B> rangeImpl(Option<A> from, Option<A> until) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.rangeImpl(this.tree, from, until, this.ordering()));
    }

    @Override
    public TreeMap<A, B> range(A from, A until) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.range(this.tree, from, until, this.ordering()));
    }

    @Override
    public TreeMap<A, B> from(A from) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.from(this.tree, from, this.ordering()));
    }

    @Override
    public TreeMap<A, B> to(A to) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.to(this.tree, to, this.ordering()));
    }

    @Override
    public TreeMap<A, B> until(A until) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.until(this.tree, until, this.ordering()));
    }

    @Override
    public A firstKey() {
        return RedBlackTree$.MODULE$.smallest(this.tree).key();
    }

    @Override
    public A lastKey() {
        return RedBlackTree$.MODULE$.greatest(this.tree).key();
    }

    @Override
    public int compare(A k0, A k1) {
        return this.ordering().compare(k0, k1);
    }

    @Override
    public Tuple2<A, B> head() {
        RedBlackTree.Tree<A, B> smallest = RedBlackTree$.MODULE$.smallest(this.tree);
        return new Tuple2<A, B>(smallest.key(), smallest.value());
    }

    @Override
    public Option<Tuple2<A, B>> headOption() {
        if (RedBlackTree$.MODULE$.isEmpty(this.tree)) {
            return None$.MODULE$;
        }
        return new Some<Object>(this.head());
    }

    @Override
    public Tuple2<A, B> last() {
        RedBlackTree.Tree<A, B> greatest = RedBlackTree$.MODULE$.greatest(this.tree);
        return new Tuple2<A, B>(greatest.key(), greatest.value());
    }

    @Override
    public Option<Tuple2<A, B>> lastOption() {
        if (RedBlackTree$.MODULE$.isEmpty(this.tree)) {
            return None$.MODULE$;
        }
        return new Some<Object>(this.last());
    }

    @Override
    public TreeMap<A, B> tail() {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.delete(this.tree, this.firstKey(), this.ordering()));
    }

    @Override
    public TreeMap<A, B> init() {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.delete(this.tree, this.lastKey(), this.ordering()));
    }

    @Override
    public TreeMap<A, B> drop(int n) {
        if (n <= 0) {
            return this;
        }
        if (n >= this.size()) {
            return this.empty();
        }
        return this.newMapOrSelf(RedBlackTree$.MODULE$.drop(this.tree, n, this.ordering()));
    }

    @Override
    public TreeMap<A, B> take(int n) {
        if (n <= 0) {
            return this.empty();
        }
        if (n >= this.size()) {
            return this;
        }
        return this.newMapOrSelf(RedBlackTree$.MODULE$.take(this.tree, n, this.ordering()));
    }

    private <B1> TreeMap<A, B1> newMapOrSelf(RedBlackTree.Tree<A, B1> newTree) {
        if (newTree == this.tree) {
            return this;
        }
        return new TreeMap<A, B1>(newTree, this.ordering());
    }

    @Override
    public TreeMap<A, B> slice(int from, int until) {
        if (until <= from) {
            return this.empty();
        }
        if (from <= 0) {
            return this.take(until);
        }
        if (until >= this.size()) {
            return this.drop(from);
        }
        return this.newMapOrSelf(RedBlackTree$.MODULE$.slice(this.tree, from, until, this.ordering()));
    }

    @Override
    public TreeMap<A, B> dropRight(int n) {
        return this.take(this.size() - package$.MODULE$.max(n, 0));
    }

    @Override
    public TreeMap<A, B> takeRight(int n) {
        return this.drop(this.size() - package$.MODULE$.max(n, 0));
    }

    @Override
    public Tuple2<TreeMap<A, B>, TreeMap<A, B>> splitAt(int n) {
        return new Tuple2<Object, Object>(this.take(n), this.drop(n));
    }

    /*
     * WARNING - void declaration
     */
    private int countWhile(Function1<Tuple2<A, B>, Object> p) {
        void var2_2;
        int result2 = 0;
        Iterator<Tuple2<A, B>> it = this.iterator();
        while (it.hasNext() && BoxesRunTime.unboxToBoolean(p.apply(it.next()))) {
            ++result2;
        }
        return (int)var2_2;
    }

    @Override
    public TreeMap<A, B> dropWhile(Function1<Tuple2<A, B>, Object> p) {
        return this.drop(this.countWhile(p));
    }

    @Override
    public TreeMap<A, B> takeWhile(Function1<Tuple2<A, B>, Object> p) {
        return this.take(this.countWhile(p));
    }

    @Override
    public Tuple2<TreeMap<A, B>, TreeMap<A, B>> span(Function1<Tuple2<A, B>, Object> p) {
        return this.splitAt(this.countWhile(p));
    }

    @Override
    public TreeMap<A, B> empty() {
        return this.newMapOrSelf(null);
    }

    @Override
    public <B1> TreeMap<A, B1> updated(A key, B1 value) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.update(this.tree, key, value, true, this.ordering()));
    }

    @Override
    public <B1> TreeMap<A, B1> $plus(Tuple2<A, B1> kv) {
        return this.updated((Object)kv._1(), (Object)kv._2());
    }

    @Override
    public <B1> TreeMap<A, B1> $plus(Tuple2<A, B1> elem1, Tuple2<A, B1> elem2, Seq<Tuple2<A, B1>> elems) {
        return ((TreeMap)((TreeMap)this.$plus((Tuple2)elem1)).$plus((Tuple2)elem2)).$plus$plus(elems);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public <B1> TreeMap<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        if (xs instanceof TreeMap) {
            TreeMap treeMap = (TreeMap)xs;
            Ordering<A> ordering = this.ordering();
            Ordering<A> ordering2 = treeMap.ordering();
            if (ordering == null) {
                if (ordering2 == null) return this.newMapOrSelf(RedBlackTree$.MODULE$.union(this.tree, treeMap.scala$collection$immutable$TreeMap$$tree0(), this.ordering()));
            } else if (ordering.equals(ordering2)) {
                return this.newMapOrSelf(RedBlackTree$.MODULE$.union(this.tree, treeMap.scala$collection$immutable$TreeMap$$tree0(), this.ordering()));
            }
        }
        TreeMap treeMap = (TreeMap)this.repr();
        return xs.seq().$div$colon(treeMap, (Function2<TreeMap, Tuple2, TreeMap> & java.io.Serializable & Serializable)(B x$2, A x$3) -> x$2.$plus((Tuple2)x$3));
    }

    public <B1> TreeMap<A, B1> insert(A key, B1 value) {
        Predef$.MODULE$.assert(!RedBlackTree$.MODULE$.contains(this.tree, key, this.ordering()));
        return this.newMapOrSelf(RedBlackTree$.MODULE$.update(this.tree, key, value, true, this.ordering()));
    }

    @Override
    public TreeMap<A, B> $minus(A key) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.delete(this.tree, key, this.ordering()));
    }

    public TreeMap<A, B> removeAllImpl(TreeSet<A> ts) {
        Ordering<A> ordering = this.ordering();
        Ordering<A> ordering2 = ts.ordering();
        Predef$.MODULE$.assert(!(ordering != null ? !ordering.equals(ordering2) : ordering2 != null));
        return this.newMapOrSelf(RedBlackTree$.MODULE$.difference(this.tree, ts.tree(), this.ordering()));
    }

    @Override
    public Option<B> get(A key) {
        return RedBlackTree$.MODULE$.get(this.tree, key, this.ordering());
    }

    @Override
    public <V1> V1 getOrElse(A key, Function0<V1> function0) {
        RedBlackTree.Tree<A, B> resultOrNull = RedBlackTree$.MODULE$.lookup(this.tree, key, this.ordering());
        if (resultOrNull == null) {
            return function0.apply();
        }
        return (V1)resultOrNull.value();
    }

    @Override
    public Iterator<Tuple2<A, B>> iterator() {
        return RedBlackTree$.MODULE$.iterator(this.tree, RedBlackTree$.MODULE$.iterator$default$2(), this.ordering());
    }

    @Override
    public Iterator<Tuple2<A, B>> iteratorFrom(A start) {
        return RedBlackTree$.MODULE$.iterator(this.tree, new Some<A>(start), this.ordering());
    }

    @Override
    public Iterator<A> keysIterator() {
        return RedBlackTree$.MODULE$.keysIterator(this.tree, RedBlackTree$.MODULE$.keysIterator$default$2(), this.ordering());
    }

    @Override
    public Iterator<A> keysIteratorFrom(A start) {
        return RedBlackTree$.MODULE$.keysIterator(this.tree, new Some<A>(start), this.ordering());
    }

    @Override
    public Iterator<B> valuesIterator() {
        return RedBlackTree$.MODULE$.valuesIterator(this.tree, RedBlackTree$.MODULE$.valuesIterator$default$2(), this.ordering());
    }

    @Override
    public Iterator<B> valuesIteratorFrom(A start) {
        return RedBlackTree$.MODULE$.valuesIterator(this.tree, new Some<A>(start), this.ordering());
    }

    @Override
    public boolean contains(A key) {
        return RedBlackTree$.MODULE$.contains(this.tree, key, this.ordering());
    }

    @Override
    public boolean isDefinedAt(A key) {
        return RedBlackTree$.MODULE$.contains(this.tree, key, this.ordering());
    }

    @Override
    public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
        RedBlackTree$.MODULE$.foreach(this.tree, f);
    }

    @Override
    public <U> void foreachEntry(Function2<A, B, U> f) {
        RedBlackTree$.MODULE$.foreachEntry(this.tree, f);
    }

    @Override
    public int hashCode() {
        if (this.isEmpty()) {
            return MurmurHash3$.MODULE$.emptyMapHash();
        }
        Map.HashCodeAccumulator hasher = new Map.HashCodeAccumulator();
        RedBlackTree$.MODULE$.foreachEntry(this.tree, hasher);
        return hasher.finalizeHash();
    }

    @Override
    public SortedSet<A> keySet() {
        return new TreeSet<A>(this.tree, this.ordering());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeMap)) return SortedMap.equals$(this, obj);
        TreeMap treeMap = (TreeMap)obj;
        Ordering<A> ordering = this.ordering();
        Ordering<A> ordering2 = treeMap.ordering();
        if (ordering != null) {
            if (!ordering.equals(ordering2)) return SortedMap.equals$(this, obj);
            return RedBlackTree$.MODULE$.entriesEqual(this.tree, treeMap.scala$collection$immutable$TreeMap$$tree0(), this.ordering());
        }
        if (ordering2 == null) return RedBlackTree$.MODULE$.entriesEqual(this.tree, treeMap.scala$collection$immutable$TreeMap$$tree0(), this.ordering());
        return SortedMap.equals$(this, obj);
    }

    @Override
    public Iterable<B> values() {
        return new MapLike.DefaultValuesIterable(this){
            private final /* synthetic */ TreeMap $outer;

            public <U> void foreach(Function1<B, U> f) {
                RedBlackTree$.MODULE$.foreachEntry(this.$outer.scala$collection$immutable$TreeMap$$tree0(), (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(x$4, value) -> f.apply(value));
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$foreach$1(scala.Function1 java.lang.Object java.lang.Object )}, serializedLambda);
            }
        };
    }

    @Override
    public TreeMap<A, B> filterImpl(Function1<Tuple2<A, B>, Object> f, boolean isFlipped) {
        return this.newMapOrSelf(RedBlackTree$.MODULE$.filterEntries(this.tree, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(k, v) -> BoxesRunTime.boxToBoolean(TreeMap.$anonfun$filterImpl$1(isFlipped, p, k, v))));
    }

    @Override
    public Tuple2<TreeMap<A, B>, TreeMap<A, B>> partition(Function1<Tuple2<A, B>, Object> p) {
        Tuple2<RedBlackTree.Tree<A, B>, RedBlackTree.Tree<A, B>> tuple2 = RedBlackTree$.MODULE$.partitionEntries(this.tree, (Function2<Object, Object, Object> & java.io.Serializable & Serializable)(k, v) -> BoxesRunTime.boxToBoolean(TreeMap.$anonfun$partition$1(p, k, v)));
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, B> tree = tuple2._1();
        RedBlackTree.Tree<A, B> tree2 = tuple2._2();
        RedBlackTree.Tree<A, B> l = tree;
        RedBlackTree.Tree<A, B> r = tree2;
        return new Tuple2<TreeMap<A, B>, TreeMap<A, B>>(this.newMapOrSelf(l), this.newMapOrSelf(r));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean sameCBF(CanBuildFrom<?, ?, ?> bf2) {
        while (true) {
            if (bf2 instanceof SortedMapFactory.SortedMapCanBuildFrom) {
                SortedMapFactory.SortedMapCanBuildFrom sortedMapCanBuildFrom = (SortedMapFactory.SortedMapCanBuildFrom)bf2;
                SortedMapFactory factory2 = sortedMapCanBuildFrom.factory();
                if (factory2 != TreeMap$.MODULE$ && factory2 != SortedMap$.MODULE$) {
                    if (factory2 != scala.collection.SortedMap$.MODULE$) return false;
                }
                Ordering ordering = sortedMapCanBuildFrom.ordering();
                Ordering<A> ordering2 = this.ordering();
                if (ordering != null) {
                    if (!ordering.equals(ordering2)) return false;
                    return true;
                }
                if (ordering2 == null) return true;
                return false;
            }
            if (!(bf2 instanceof package.WrappedCanBuildFrom)) return false;
            CanBuildFrom bf2 = ((package.WrappedCanBuildFrom)bf2).wrapped();
        }
    }

    @Override
    public <W, That> That transform(Function2<A, B, W> f, CanBuildFrom<TreeMap<A, B>, Tuple2<A, W>, That> bf) {
        if (this.sameCBF(bf)) {
            return (That)this.newMapOrSelf(RedBlackTree$.MODULE$.transform(this.tree, f));
        }
        Builder<Tuple2<A, W>, That> transform_b = bf.apply((TreeMap<A, B>)this.repr());
        this.withFilter(scala.collection.immutable.MapLike::$anonfun$transform$1$adapted).foreach(arg_0 -> scala.collection.immutable.MapLike.$anonfun$transform$2(transform_b, f, arg_0));
        return transform_b.result();
    }

    public static final /* synthetic */ boolean $anonfun$filterImpl$1(boolean isFlipped$1, Function1 f$2, Object k, Object v) {
        return isFlipped$1 ^ BoxesRunTime.unboxToBoolean(f$2.apply(new Tuple2<Object, Object>(k, v)));
    }

    public static final /* synthetic */ boolean $anonfun$partition$1(Function1 p$1, Object k, Object v) {
        return BoxesRunTime.unboxToBoolean(p$1.apply(new Tuple2<Object, Object>(k, v)));
    }

    public TreeMap(RedBlackTree.Tree<A, B> tree, Ordering<A> ordering) {
        this.tree = tree;
        this.ordering = ordering;
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        TraversableLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        scala.collection.Traversable.$init$(this);
        Traversable.$init$(this);
        GenIterable.$init$(this);
        IterableLike.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Iterable.$init$(this);
        GenMapLike.$init$(this);
        PartialFunction.$init$(this);
        Subtractable.$init$(this);
        MapLike.$init$(this);
        Map.$init$(this);
        scala.collection.immutable.MapLike.$init$(this);
        scala.collection.immutable.Map.$init$(this);
        Sorted.$init$(this);
        SortedMapLike.$init$(this);
        scala.collection.SortedMap.$init$(this);
        SortedMap.$init$(this);
    }

    public TreeMap(Ordering<A> ordering) {
        this(null, ordering);
    }

    public static final class TreeMapBuilder<A, B>
    implements Builder<Tuple2<A, B>, TreeMap<A, B>> {
        private volatile TreeMap$TreeMapBuilder$adder$ adder$module;
        public final Ordering<A> scala$collection$immutable$TreeMap$TreeMapBuilder$$ordering;
        private RedBlackTree.Tree<A, B> tree;

        @Override
        public void sizeHint(int size) {
            Builder.sizeHint$((Builder)this, size);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll) {
            Builder.sizeHint$((Builder)this, coll);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll, int delta) {
            Builder.sizeHint$(this, coll, delta);
        }

        @Override
        public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
            Builder.sizeHintBounded$(this, size, boundingColl);
        }

        @Override
        public <NewTo> Builder<Tuple2<A, B>, NewTo> mapResult(Function1<TreeMap<A, B>, NewTo> f) {
            return Builder.mapResult$(this, f);
        }

        @Override
        public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
            return Growable.$plus$eq$(this, elem1, elem2, elems);
        }

        private TreeMap$TreeMapBuilder$adder$ adder() {
            if (this.adder$module == null) {
                this.adder$lzycompute$1();
            }
            return this.adder$module;
        }

        @Override
        public TreeMapBuilder<A, B> $plus$eq(Tuple2<A, B> elem) {
            this.tree = RedBlackTree$.MODULE$.update(this.tree, elem._1(), elem._2(), true, this.scala$collection$immutable$TreeMap$TreeMapBuilder$$ordering);
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public TreeMapBuilder<A, B> $plus$plus$eq(TraversableOnce<Tuple2<A, B>> xs) {
            if (xs instanceof TreeMap) {
                TreeMap treeMap = (TreeMap)xs;
                Ordering ordering = treeMap.ordering();
                Ordering<A> ordering2 = this.scala$collection$immutable$TreeMap$TreeMapBuilder$$ordering;
                if (!(ordering != null ? !ordering.equals(ordering2) : ordering2 != null)) {
                    if (this.tree == null) {
                        this.tree = treeMap.scala$collection$immutable$TreeMap$$tree0();
                        return this;
                    }
                    this.tree = this.adder().addTree(this.tree, treeMap.scala$collection$immutable$TreeMap$$tree0());
                    return this;
                }
            }
            if (xs instanceof HasForeachEntry) {
                this.tree = this.adder().addForEach(this.tree, (HasForeachEntry)((Object)xs));
                return this;
            }
            Growable.$plus$plus$eq$(this, xs);
            return this;
        }

        @Override
        public void clear() {
            this.tree = null;
        }

        @Override
        public TreeMap<A, B> result() {
            return new TreeMap<A, B>(this.tree, this.scala$collection$immutable$TreeMap$TreeMapBuilder$$ordering);
        }

        private final void adder$lzycompute$1() {
            synchronized (this) {
                if (this.adder$module == null) {
                    this.adder$module = new TreeMap$TreeMapBuilder$adder$(this);
                }
                return;
            }
        }

        public TreeMapBuilder(Ordering<A> ordering) {
            this.scala$collection$immutable$TreeMap$TreeMapBuilder$$ordering = ordering;
            Growable.$init$(this);
            Builder.$init$(this);
            this.tree = null;
        }
    }
}

