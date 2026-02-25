/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSeq;
import scala.collection.GenSeqLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.IterableViewLike;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqLike;
import scala.collection.SeqView;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.TraversableView;
import scala.collection.TraversableViewLike;
import scala.collection.ViewMkString;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.SliceInterval;
import scala.collection.generic.SliceInterval$;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParSeq;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0015maaB;w!\u0003\r\ta\u001f\u0005\b\u0003\u001f\u0002A\u0011AA)\r!\tI\u0006AA\u0001m\u0006m\u0003bBAR\u0005\u0011\u0005\u0011Q\u0015\u0004\n\u0003[\u0002\u0001\u0013aA\u0001\u0003cBq!a\u0014\u0005\t\u0003\t\t\u0006C\u0004\u0002~\u00111\t!a \t\u000f\u0005\u001dEA\"\u0001\u0002\n\"9\u0011q\u0012\u0003\u0005B\u0005Ee!CAU\u0001A\u0005\u0019\u0011AAV\u0011\u001d\ty%\u0003C\u0001\u0003#Bq!! \n\t\u000b\ny\bC\u0004\u0002\b&!)%a-\u0007\u0013\u0005e\u0006\u0001%A\u0002\u0002\u0005m\u0006bBA(\u001b\u0011\u0005\u0011\u0011\u000b\u0005\b\u0003{jA\u0011AA@\u0011\u001d\t9)\u0004C\u0001\u0003\u00134\u0011\"!4\u0001!\u0003\r\t!a4\t\u000f\u0005=\u0013\u0003\"\u0001\u0002R!9\u0011QP\t\u0005\u0002\u0005}\u0004bBAD#\u0011\u0005\u0011q\u001b\u0005\b\u00037\fB\u0011IAo\u0011\u001d\t\t0\u0005C!\u0003g4\u0011\"a?\u0001!\u0003\r\t!!@\t\u000f\u0005=s\u0003\"\u0001\u0002R!9\u0011QP\f\u0005\u0002\u0005}\u0004bBAD/\u0011\u0005!1\u0002\u0004\n\u0005\u001f\u0001\u0001\u0013aA\u0001\u0005#Aq!a\u0014\u001c\t\u0003\t\t\u0006\u0003\u0006\u0003 mA)\u0019)C\t\u0005CA\u0001B!\u000b\u001cA\u0013E!1\u0006\u0005\b\u0003{ZB\u0011AA@\u0011\u001d\t9i\u0007C\u0001\u0005o1\u0011Ba\u000f\u0001!\u0003\r\tA!\u0010\t\u000f\u0005=\u0013\u0005\"\u0001\u0002R!Q!QJ\u0011\t\u0006\u0004&\tBa\u0014\t\u000f\u0005u\u0014\u0005\"\u0001\u0002\u0000!9\u0011qQ\u0011\u0005\u0002\t]c!\u0003B.\u0001A\u0005\u0019\u0011\u0001B/\u0011\u001d\tyE\nC\u0001\u0003#B!Ba\u001b'\u0011\u000b\u0007K\u0011\u0003B7\u0011\u001d\tiH\nC\u0001\u0003\u007fBq!a\"'\t\u0003\u0011\tHB\u0005\u0003v\u0001\u0001\n1!\u0001\u0003x!9\u0011qJ\u0016\u0005\u0002\u0005E\u0003B\u0003B\u0010W!\u0015\r\u0015\"\u0005\u0003\"!9\u0011QP\u0016\u0005\u0002\u0005}\u0004bBADW\u0011\u0005!Q\u0010\u0004\n\u0005\u0003\u0003\u0001\u0013aA\u0001\u0005\u0007Cq!a\u00141\t\u0003\t\t\u0006\u0003\u0006\u0003\nBB)\u0019)C\t\u0003\u007fBq!! 1\t\u0003\ty\bC\u0004\u0002\bB\"\tAa#\u0007\u0013\t=\u0005\u0001%A\u0002\u0002\tE\u0005bBA(k\u0011\u0005\u0011\u0011\u000b\u0005\u000b\u0005/+\u0004R1Q\u0005\u0012\u0005}\u0004bBA?k\u0011\u0005\u0011q\u0010\u0005\b\u0003\u000f+D\u0011\u0001BM\r%\u0011i\n\u0001I\u0001\u0004\u0003\u0011y\nC\u0004\u0002Pi\"\t!!\u0015\t\u0015\tM&\b#b!\n#\u0011)\fC\u0004\u0002~i\"\t!a \t\u000f\u0005\u001d%\b\"\u0001\u0003:\u001aI!Q\u0018\u0001\u0011\u0002\u0007\u0005!q\u0018\u0005\b\u0003\u001fzD\u0011AA)\u0011)\u0011\u0019l\u0010ECB\u0013E!Q\u001b\u0005\b\u0003{zD\u0011AA@\u0011\u001d\t9i\u0010C\u0001\u000534\u0011B!8\u0001!\u0003\r\tAa8\t\u000f\u0005=C\t\"\u0001\u0002R!9\u0011\u0011\u001f#\u0005B\u0005M\bbBA?\t\u0012\u0005\u0011q\u0010\u0005\b\u0003\u000f#E\u0011\u0001Bq\u0011!\u0011)\u000f\u0012Q\u0005V\t\u001d\bb\u0002Bu\t\u0012%\u00111\u001f\u0004\n\u0005W\u0004\u0001\u0013aA\u0001\u0005[Dq!a\u0014L\t\u0003\t\t\u0006C\u0005\u0003x.\u0013\rU\"\u0005\u0002\u0000!I!\u0011`&CB\u001bE!1 \u0005\n\u0005\u007f\\%\u0019)D\t\u0003\u007fB!b!\u0001L\u0011\u000b\u0007I\u0011BA@\u0011\u001d\t\tp\u0013C!\u0007\u0007Aq!! L\t\u0003\ty\bC\u0004\u0002\b.#\taa\u0002\t\u0011\t\u00158\n)C+\u0005ODqaa\u0003\u0001\t#\u001ai\u0001C\u0004\u0004$\u0001!\tf!\n\t\u000f\re\u0002\u0001\"\u0015\u0004<!91\u0011\n\u0001\u0005R\r-\u0003bBB-\u0001\u0011E31\f\u0005\b\u0007_\u0002A\u0011KB9\u0011\u001d\u0019y\b\u0001C)\u0007\u0003Cqaa%\u0001\t#\u001a)\nC\u0004\u0004\u001a\u0002!\tfa'\t\u000f\r}\u0005\u0001\"\u0015\u0004\"\"91Q\u0017\u0001\u0005R\r]\u0006bBBj\u0001\u0011E1Q\u001b\u0005\b\u0007/\u0004A\u0011CBm\u0011\u001d\u0019\t\u0010\u0001C)\u0007gDqaa>\u0001\t#\u001aI\u0010C\u0004\u0004~\u0002!\tea@\t\u000f\te\b\u0001\"\u0011\u0005\u0002!9A1\u0005\u0001\u0005B\u0011\u0015\u0002b\u0002C\u001f\u0001\u0011\u0005Cq\b\u0005\b\t+\u0002A\u0011\tC,\u0011\u001d!i\u0007\u0001C!\t_Bq\u0001b!\u0001\t\u0003\")\tC\u0004\u0005\u001a\u0002!\t\u0005b'\t\u000f\u0011E\u0006\u0001\"\u0011\u00054\"9Aq\u0018\u0001\u0005B\u0011\u0005\u0007b\u0002Cg\u0001\u0011\u0005Cq\u001a\u0005\b\tS\u0004A\u0011\tCv\u0011\u001d!9\u0010\u0001C!\tsDq!b\u0003\u0001\t\u0003*i\u0001C\u0004\u0006\u0014\u0001!\t%\"\u0006\t\u000f\u0015]\u0001\u0001\"\u0011\u0004\u0000\"9Q\u0011\u0004\u0001\u0005B\t\u001d(aC*fcZKWm\u001e'jW\u0016T!a\u001e=\u0002\u0015\r|G\u000e\\3di&|gNC\u0001z\u0003\u0015\u00198-\u00197b\u0007\u0001)r\u0001`A\b\u0003{\tIc\u0005\u0006\u0001{\u0006\r\u0011\u0011EA\"\u0003\u0013\u0002\"A`@\u000e\u0003aL1!!\u0001y\u0005\u0019\te.\u001f*fMB1\u0011QAA\u0004\u0003\u0017i\u0011A^\u0005\u0004\u0003\u00131(aA*fcB!\u0011QBA\b\u0019\u0001!\u0001\"!\u0005\u0001\t\u000b\u0007\u00111\u0003\u0002\u0002\u0003F!\u0011QCA\u000e!\rq\u0018qC\u0005\u0004\u00033A(a\u0002(pi\"Lgn\u001a\t\u0004}\u0006u\u0011bAA\u0010q\n\u0019\u0011I\\=\u0011\u0011\u0005\u0015\u00111EA\u0006\u0003OI1!!\nw\u0005\u001d\u0019V-\u001d'jW\u0016\u0004B!!\u0004\u0002*\u0011A\u00111\u0006\u0001\u0005\u0006\u0004\tiC\u0001\u0003UQ&\u001c\u0018\u0003BA\u000b\u0003_\u0011b!!\r\u00026\u0005\u0005cABA\u001a\u0001\u0001\tyC\u0001\u0007=e\u00164\u0017N\\3nK:$h\b\u0005\u0005\u0002\u0006\u0005]\u00121BA\u001e\u0013\r\tID\u001e\u0002\b'\u0016\fh+[3x!\u0011\ti!!\u0010\u0005\u0011\u0005}\u0002\u0001\"b\u0001\u0003'\u0011AaQ8mYBI\u0011Q\u0001\u0001\u0002\f\u0005m\u0012q\u0005\t\t\u0003\u000b\t)%a\u0003\u0002<%\u0019\u0011q\t<\u0003\u0019%#XM]1cY\u00164\u0016.Z<\u0011\u0015\u0005\u0015\u00111JA\u0006\u0003w\t9#C\u0002\u0002NY\u0014\u0001#\u0013;fe\u0006\u0014G.\u001a,jK^d\u0015n[3\u0002\r\u0011Jg.\u001b;%)\t\t\u0019\u0006E\u0002\u007f\u0003+J1!a\u0016y\u0005\u0011)f.\u001b;\u0003'\u0005\u00137\u000f\u001e:bGR$&/\u00198tM>\u0014X.\u001a3\u0016\t\u0005u\u00131M\n\t\u0005u\fy&a\u001a\u0002pA1\u0011QAA\u0004\u0003C\u0002B!!\u0004\u0002d\u0011A\u0011Q\r\u0002\u0005\u0006\u0004\t\u0019BA\u0001C!\u0019\tI'a\u001b\u0002b5\t\u0001!\u0003\u0003\u0002n\u0005-#a\u0003+sC:\u001chm\u001c:nK\u0012\u0004R!!\u001b\u0005\u0003C*B!a\u001d\u0002zM1A!`A;\u0003w\u0002\u0002\"!\u0002\u00028\u0005]\u00141\b\t\u0005\u0003\u001b\tI\b\u0002\u0005\u0002f\u0011!)\u0019AA\n!\u0019\tI'a\u001b\u0002x\u00051A.\u001a8hi\",\"!!!\u0011\u0007y\f\u0019)C\u0002\u0002\u0006b\u00141!\u00138u\u0003\u0015\t\u0007\u000f\u001d7z)\u0011\t9(a#\t\u000f\u00055u\u00011\u0001\u0002\u0002\u0006\u0019\u0011\u000e\u001a=\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!a%\u0011\t\u0005U\u0015qT\u0007\u0003\u0003/SA!!'\u0002\u001c\u0006!A.\u00198h\u0015\t\ti*\u0001\u0003kCZ\f\u0017\u0002BAQ\u0003/\u0013aa\u0015;sS:<\u0017A\u0002\u001fj]&$h\b\u0006\u0002\u0002(B)\u0011\u0011\u000e\u0002\u0002b\tIQ)\u001c9usZKWm^\n\u0007\u0013u\fi+a,\u0011\u000b\u0005%D!!\u0006\u0011\t\u0005%\u0014\u0011W\u0005\u0005\u0003S\u000bY\u0005\u0006\u0003\u0002\u0016\u0005U\u0006bBA\\\u0019\u0001\u0007\u0011\u0011Q\u0001\u0002]\n1ai\u001c:dK\u0012,B!!0\u0002FN1Q\"`A`\u0003\u000f\u0004b!!\u001b\u0002B\u0006\r\u0017\u0002BA]\u0003\u0017\u0002B!!\u0004\u0002F\u00129\u0011QM\u0007C\u0002\u0005M\u0001#BA5\t\u0005\rG\u0003BAb\u0003\u0017Dq!!$\u0011\u0001\u0004\t\tI\u0001\u0004TY&\u001cW\rZ\n\u0007#u\f\t.!6\u0011\t\u0005%\u00141[\u0005\u0005\u0003\u001b\fY\u0005E\u0003\u0002j\u0011\tY\u0001\u0006\u0003\u0002\f\u0005e\u0007bBAG)\u0001\u0007\u0011\u0011Q\u0001\bM>\u0014X-Y2i+\u0011\ty.!<\u0015\t\u0005M\u0013\u0011\u001d\u0005\b\u0003G,\u0002\u0019AAs\u0003\u00051\u0007c\u0002@\u0002h\u0006-\u00111^\u0005\u0004\u0003SD(!\u0003$v]\u000e$\u0018n\u001c82!\u0011\ti!!<\u0005\u000f\u0005=XC1\u0001\u0002\u0014\t\tQ+\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\t)\u0010\u0005\u0004\u0002\u0006\u0005]\u00181B\u0005\u0004\u0003s4(\u0001C%uKJ\fGo\u001c:\u0003\r5\u000b\u0007\u000f]3e+\u0011\tyPa\u0002\u0014\r]i(\u0011\u0001B\u0005!\u0019\tIGa\u0001\u0003\u0006%!\u00111`A&!\u0011\tiAa\u0002\u0005\u000f\u0005\u0015tC1\u0001\u0002\u0014A)\u0011\u0011\u000e\u0003\u0003\u0006Q!!Q\u0001B\u0007\u0011\u001d\tiI\u0007a\u0001\u0003\u0003\u0013!B\u00127bi6\u000b\u0007\u000f]3e+\u0011\u0011\u0019Ba\u0007\u0014\rmi(Q\u0003B\u000f!\u0019\tIGa\u0006\u0003\u001a%!!qBA&!\u0011\tiAa\u0007\u0005\u000f\u0005\u00154D1\u0001\u0002\u0014A)\u0011\u0011\u000e\u0003\u0003\u001a\u0005)\u0011N\u001c3fqV\u0011!1\u0005\t\u0006}\n\u0015\u0012\u0011Q\u0005\u0004\u0005OA(!B!se\u0006L\u0018a\u00024j]\u0012\u0014vn\u001e\u000b\t\u0003\u0003\u0013iCa\f\u00034!9\u0011Q\u0012\u0010A\u0002\u0005\u0005\u0005b\u0002B\u0019=\u0001\u0007\u0011\u0011Q\u0001\u0003Y>DqA!\u000e\u001f\u0001\u0004\t\t)\u0001\u0002iSR!!\u0011\u0004B\u001d\u0011\u001d\ti\t\ta\u0001\u0003\u0003\u0013\u0001\"\u00119qK:$W\rZ\u000b\u0005\u0005\u007f\u00119e\u0005\u0004\"{\n\u0005#1\n\t\u0007\u0003S\u0012\u0019E!\u0012\n\t\tm\u00121\n\t\u0005\u0003\u001b\u00119\u0005B\u0004\u0002f\u0005\u0012\rA!\u0013\u0012\t\u0005-\u00111\u0004\t\u0006\u0003S\"!QI\u0001\be\u0016\u001cHoU3r+\t\u0011\t\u0006\u0005\u0004\u0002\u0006\tM#QI\u0005\u0004\u0005+2(AB$f]N+\u0017\u000f\u0006\u0003\u0003F\te\u0003bBAGK\u0001\u0007\u0011\u0011\u0011\u0002\n!J,\u0007/\u001a8eK\u0012,BAa\u0018\u0003hM1a% B1\u0005S\u0002b!!\u001b\u0003d\t\u0015\u0014\u0002\u0002B.\u0003\u0017\u0002B!!\u0004\u0003h\u00119\u0011Q\r\u0014C\u0002\t%\u0003#BA5\t\t\u0015\u0014A\u00024tiN+\u0017/\u0006\u0002\u0003pA1\u0011Q\u0001B*\u0005K\"BA!\u001a\u0003t!9\u0011Q\u0012\u0016A\u0002\u0005\u0005%\u0001\u0003$jYR,'/\u001a3\u0014\r-j(\u0011PAk!\u0011\tIGa\u001f\n\t\tU\u00141\n\u000b\u0005\u0003\u0017\u0011y\bC\u0004\u0002\u000e>\u0002\r!!!\u0003\u0015Q\u000b7.\u001a8XQ&dWm\u0005\u00041{\n\u0015\u0015Q\u001b\t\u0005\u0003S\u00129)\u0003\u0003\u0003\u0002\u0006-\u0013a\u00017f]R!\u00111\u0002BG\u0011\u001d\ti\t\u000ea\u0001\u0003\u0003\u0013A\u0002\u0012:paB,Gm\u00165jY\u0016\u001cb!N?\u0003\u0014\u0006U\u0007\u0003BA5\u0005+KAAa$\u0002L\u0005)1\u000f^1siR!\u00111\u0002BN\u0011\u001d\ti)\u000fa\u0001\u0003\u0003\u0013aAW5qa\u0016$W\u0003\u0002BQ\u0005S\u001bbAO?\u0003$\n-\u0006CBA5\u0005K\u00139+\u0003\u0003\u0003\u001e\u0006-\u0003\u0003BA\u0007\u0005S#q!!\u001a;\u0005\u0004\t\u0019\u0002E\u0003\u0002j\u0011\u0011i\u000bE\u0004\u007f\u0005_\u000bYAa*\n\u0007\tE\u0006P\u0001\u0004UkBdWMM\u0001\bi\"\fGoU3r+\t\u00119\f\u0005\u0004\u0002\u0006\u0005\u001d!q\u0015\u000b\u0005\u0005[\u0013Y\fC\u0004\u0002\u000ez\u0002\r!!!\u0003\u0013iK\u0007\u000f]3e\u00032dWC\u0002Ba\u0005\u0013\u0014ym\u0005\u0004@{\n\r'\u0011\u001b\t\t\u0003S\u0012)Ma2\u0003N&!!QXA&!\u0011\tiA!3\u0005\u000f\t-wH1\u0001\u0003J\t\u0011\u0011)\r\t\u0005\u0003\u001b\u0011y\rB\u0004\u0002f}\u0012\r!a\u0005\u0011\u000b\u0005%DAa5\u0011\u000fy\u0014yKa2\u0003NV\u0011!q\u001b\t\u0007\u0003\u000b\t9A!4\u0015\t\tM'1\u001c\u0005\b\u0003\u001b\u001b\u0005\u0019AAA\u0005!\u0011VM^3sg\u0016$7\u0003\u0002#~\u0003+$B!a\u0003\u0003d\"9\u0011Q\u0012%A\u0002\u0005\u0005\u0015A\u0004<jK^LE-\u001a8uS\u001aLWM]\u000b\u0003\u0003'\u000bac\u0019:fCR,'+\u001a<feN,G-\u0013;fe\u0006$xN\u001d\u0002\b!\u0006$8\r[3e+\u0011\u0011yO!>\u0014\t-k(\u0011\u001f\t\u0006\u0003S\"!1\u001f\t\u0005\u0003\u001b\u0011)\u0010B\u0004\u0002f-\u0013\rA!\u0013\u0002\t\u0019\u0014x.\\\u0001\u0006a\u0006$8\r[\u000b\u0003\u0005{\u0004b!!\u0002\u0003T\tM\u0018\u0001\u0003:fa2\f7-\u001a3\u0002\tAdWM\\\u000b\u0003\u0007\u000b\u0001b!!\u0002\u0002x\nMH\u0003\u0002Bz\u0007\u0013Aq!!$T\u0001\u0004\t\t)A\u0005oK^4uN]2fIV!1qBB\u000b)\u0011\u0019\tba\u0006\u0011\u000b\u0005%Daa\u0005\u0011\t\u000551Q\u0003\u0003\b\u0003K*&\u0019AA\n\u0011!\u0019I\"\u0016CA\u0002\rm\u0011A\u0001=t!\u0015q8QDB\u0011\u0013\r\u0019y\u0002\u001f\u0002\ty\tLh.Y7f}A1\u0011Q\u0001B*\u0007'\t1B\\3x\u0003B\u0004XM\u001c3fIV!1qEB\u0017)\u0011\u0019Ica\f\u0011\u000b\u0005%Daa\u000b\u0011\t\u000551Q\u0006\u0003\b\u0003K2&\u0019\u0001B%\u0011\u001d\u0019\tD\u0016a\u0001\u0007g\tA\u0001\u001e5biB1\u0011QAB\u001b\u0007WI1aa\u000ew\u000599UM\u001c+sCZ,'o]1cY\u0016\fAB\\3x!J,\u0007/\u001a8eK\u0012,Ba!\u0010\u0004DQ!1qHB#!\u0015\tI\u0007BB!!\u0011\tiaa\u0011\u0005\u000f\u0005\u0015tK1\u0001\u0003J!91\u0011G,A\u0002\r\u001d\u0003CBA\u0003\u0007k\u0019\t%A\u0005oK^l\u0015\r\u001d9fIV!1QJB*)\u0011\u0019ye!\u0016\u0011\u000b\u0005%Da!\u0015\u0011\t\u0005511\u000b\u0003\b\u0003KB&\u0019AA\n\u0011\u001d\t\u0019\u000f\u0017a\u0001\u0007/\u0002rA`At\u0003\u0017\u0019\t&A\u0007oK^4E.\u0019;NCB\u0004X\rZ\u000b\u0005\u0007;\u001a\u0019\u0007\u0006\u0003\u0004`\r\u0015\u0004#BA5\t\r\u0005\u0004\u0003BA\u0007\u0007G\"q!!\u001aZ\u0005\u0004\t\u0019\u0002C\u0004\u0002df\u0003\raa\u001a\u0011\u000fy\f9/a\u0003\u0004jA1\u0011QAB6\u0007CJ1a!\u001cw\u0005I9UM\u001c+sCZ,'o]1cY\u0016|enY3\u0002\u00179,wOR5mi\u0016\u0014X\r\u001a\u000b\u0005\u0003+\u001c\u0019\bC\u0004\u0004vi\u0003\raa\u001e\u0002\u0003A\u0004rA`At\u0003\u0017\u0019I\bE\u0002\u007f\u0007wJ1a! y\u0005\u001d\u0011un\u001c7fC:\f\u0011B\\3x'2L7-\u001a3\u0015\t\u0005U71\u0011\u0005\b\u0007\u000b[\u0006\u0019ABD\u0003)yVM\u001c3q_&tGo\u001d\t\u0005\u0007\u0013\u001by)\u0004\u0002\u0004\f*\u00191Q\u0012<\u0002\u000f\u001d,g.\u001a:jG&!1\u0011SBF\u00055\u0019F.[2f\u0013:$XM\u001d<bY\u0006ya.Z<Ee>\u0004\b/\u001a3XQ&dW\r\u0006\u0003\u0002V\u000e]\u0005bBB;9\u0002\u00071qO\u0001\u000e]\u0016<H+Y6f]^C\u0017\u000e\\3\u0015\t\u0005U7Q\u0014\u0005\b\u0007kj\u0006\u0019AB<\u0003%qWm\u001e.jaB,G-\u0006\u0003\u0004$\u000e-F\u0003BBS\u0007[\u0003R!!\u001b\u0005\u0007O\u0003rA BX\u0003\u0017\u0019I\u000b\u0005\u0003\u0002\u000e\r-FaBA3=\n\u0007\u00111\u0003\u0005\b\u0007cq\u0006\u0019ABX!\u0019\t)a!-\u0004*&\u001911\u0017<\u0003\u0017\u001d+g.\u0013;fe\u0006\u0014G.Z\u0001\r]\u0016<(,\u001b9qK\u0012\fE\u000e\\\u000b\u0007\u0007s\u001b\tm!2\u0015\u0011\rm6qYBf\u0007\u001f\u0004R!!\u001b\u0005\u0007{\u0003rA BX\u0007\u007f\u001b\u0019\r\u0005\u0003\u0002\u000e\r\u0005Ga\u0002Bf?\n\u0007!\u0011\n\t\u0005\u0003\u001b\u0019)\rB\u0004\u0002f}\u0013\r!a\u0005\t\u000f\rEr\f1\u0001\u0004JB1\u0011QABY\u0007\u0007Dqa!4`\u0001\u0004\u0019y,A\u0005`i\"L7/\u00127f[\"91\u0011[0A\u0002\r\r\u0017!C0uQ\u0006$X\t\\3n\u0003-qWm\u001e*fm\u0016\u00148/\u001a3\u0016\u0005\u0005U\u0017A\u00038foB\u000bGo\u00195fIV!11\\Bq)!\u0019ina9\u0004h\u000e5\b#BA5\t\r}\u0007\u0003BA\u0007\u0007C$q!!\u001ab\u0005\u0004\u0011I\u0005C\u0004\u0004f\u0006\u0004\r!!!\u0002\u000b}3'o\\7\t\u000f\r%\u0018\r1\u0001\u0004l\u00061q\f]1uG\"\u0004b!!\u0002\u0003T\r}\u0007bBBxC\u0002\u0007\u0011\u0011Q\u0001\n?J,\u0007\u000f\\1dK\u0012\f\u0001B\\3x)\u0006\\WM\u001c\u000b\u0005\u0003+\u001c)\u0010C\u0004\u00028\n\u0004\r!!!\u0002\u00159,w\u000f\u0012:paB,G\r\u0006\u0003\u0002V\u000em\bbBA\\G\u0002\u0007\u0011\u0011Q\u0001\be\u00164XM]:f+\t\t9#\u0006\u0004\u0005\u0004\u0011eA\u0011\u0002\u000b\t\t\u000b!Y\u0002\"\b\u0005\"Q!Aq\u0001C\u0007!\u0011\ti\u0001\"\u0003\u0005\u000f\u0011-QM1\u0001\u0002\u0014\t!A\u000b[1u\u0011\u001d!y!\u001aa\u0002\t#\t!A\u00194\u0011\u0015\r%E1CA\u0014\t/!9!\u0003\u0003\u0005\u0016\r-%\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007\u0003BA\u0007\t3!q!!\u001af\u0005\u0004\u0011I\u0005C\u0004\u0003x\u0016\u0004\r!!!\t\u000f\teX\r1\u0001\u0005 A1\u0011Q\u0001B*\t/AqAa@f\u0001\u0004\t\t)A\u0003qC\u0012$v.\u0006\u0004\u0005(\u0011UBQ\u0006\u000b\u0007\tS!9\u0004\"\u000f\u0015\t\u0011-Bq\u0006\t\u0005\u0003\u001b!i\u0003B\u0004\u0005\f\u0019\u0014\r!a\u0005\t\u000f\u0011=a\rq\u0001\u00052AQ1\u0011\u0012C\n\u0003O!\u0019\u0004b\u000b\u0011\t\u00055AQ\u0007\u0003\b\u0003K2'\u0019\u0001B%\u0011\u001d\u0011II\u001aa\u0001\u0003\u0003Cq\u0001b\u000fg\u0001\u0004!\u0019$\u0001\u0003fY\u0016l\u0017A\u0003:fm\u0016\u00148/Z'baV1A\u0011\tC(\t\u000f\"B\u0001b\u0011\u0005RQ!AQ\tC%!\u0011\ti\u0001b\u0012\u0005\u000f\u0011-qM1\u0001\u0002\u0014!9AqB4A\u0004\u0011-\u0003CCBE\t'\t9\u0003\"\u0014\u0005FA!\u0011Q\u0002C(\t\u001d\t)g\u001ab\u0001\u0003'Aq!a9h\u0001\u0004!\u0019\u0006E\u0004\u007f\u0003O\fY\u0001\"\u0014\u0002\u000fU\u0004H-\u0019;fIV1A\u0011\fC4\t?\"b\u0001b\u0017\u0005j\u0011-D\u0003\u0002C/\tC\u0002B!!\u0004\u0005`\u00119A1\u00025C\u0002\u0005M\u0001b\u0002C\bQ\u0002\u000fA1\r\t\u000b\u0007\u0013#\u0019\"a\n\u0005f\u0011u\u0003\u0003BA\u0007\tO\"q!!\u001ai\u0005\u0004\u0011I\u0005C\u0004\u0003 !\u0004\r!!!\t\u000f\u0011m\u0002\u000e1\u0001\u0005f\u0005YA\u0005\u001d7vg\u0012\u001aw\u000e\\8o+\u0019!\t\bb \u0005xQ!A1\u000fCA)\u0011!)\b\"\u001f\u0011\t\u00055Aq\u000f\u0003\b\t\u0017I'\u0019AA\n\u0011\u001d!y!\u001ba\u0002\tw\u0002\"b!#\u0005\u0014\u0005\u001dBQ\u0010C;!\u0011\ti\u0001b \u0005\u000f\u0005\u0015\u0014N1\u0001\u0003J!9A1H5A\u0002\u0011u\u0014a\u0003\u0013d_2|g\u000e\n9mkN,b\u0001b\"\u0005\u0016\u00125E\u0003\u0002CE\t/#B\u0001b#\u0005\u0010B!\u0011Q\u0002CG\t\u001d!YA\u001bb\u0001\u0003'Aq\u0001b\u0004k\u0001\b!\t\n\u0005\u0006\u0004\n\u0012M\u0011q\u0005CJ\t\u0017\u0003B!!\u0004\u0005\u0016\u00129\u0011Q\r6C\u0002\t%\u0003b\u0002C\u001eU\u0002\u0007A1S\u0001\u0006k:LwN\\\u000b\u0007\t;#Y\u000bb)\u0015\t\u0011}EQ\u0016\u000b\u0005\tC#)\u000b\u0005\u0003\u0002\u000e\u0011\rFa\u0002C\u0006W\n\u0007\u00111\u0003\u0005\b\t\u001fY\u00079\u0001CT!)\u0019I\tb\u0005\u0002(\u0011%F\u0011\u0015\t\u0005\u0003\u001b!Y\u000bB\u0004\u0002f-\u0014\rA!\u0013\t\u000f\rE2\u000e1\u0001\u00050B1\u0011Q\u0001B*\tS\u000bA\u0001Z5gMV!AQ\u0017C_)\u0011\t9\u0003b.\t\u000f\rEB\u000e1\u0001\u0005:B1\u0011Q\u0001B*\tw\u0003B!!\u0004\u0005>\u00129\u0011Q\r7C\u0002\t%\u0013!C5oi\u0016\u00148/Z2u+\u0011!\u0019\rb3\u0015\t\u0005\u001dBQ\u0019\u0005\b\u0007ci\u0007\u0019\u0001Cd!\u0019\t)Aa\u0015\u0005JB!\u0011Q\u0002Cf\t\u001d\t)'\u001cb\u0001\u0005\u0013\naa]8si\u0016$W\u0003\u0002Ci\tO$B!a\n\u0005T\"9AQ\u001b8A\u0004\u0011]\u0017aA8sIB1A\u0011\u001cCp\tKt1A Cn\u0013\r!i\u000e_\u0001\ba\u0006\u001c7.Y4f\u0013\u0011!\t\u000fb9\u0003\u0011=\u0013H-\u001a:j]\u001eT1\u0001\"8y!\u0011\ti\u0001b:\u0005\u000f\u0005\u0015dN1\u0001\u0003J\u0005A1o\u001c:u/&$\b\u000e\u0006\u0003\u0002(\u00115\bb\u0002Cx_\u0002\u0007A\u0011_\u0001\u0003YR\u0004\u0012B Cz\u0003\u0017\tYa!\u001f\n\u0007\u0011U\bPA\u0005Gk:\u001cG/[8oe\u000511o\u001c:u\u0005f,B\u0001b?\u0006\u0006Q!AQ`C\u0004)\u0011\t9\u0003b@\t\u000f\u0011U\u0007\u000fq\u0001\u0006\u0002A1A\u0011\u001cCp\u000b\u0007\u0001B!!\u0004\u0006\u0006\u00119\u0011Q\r9C\u0002\u0005M\u0001bBAra\u0002\u0007Q\u0011\u0002\t\b}\u0006\u001d\u00181BC\u0002\u00031\u0019w.\u001c2j]\u0006$\u0018n\u001c8t)\u0011)y!\"\u0005\u0011\r\u0005\u0015\u0011q_A\u0014\u0011\u001d\t9,\u001da\u0001\u0003\u0003\u000bA\u0002]3s[V$\u0018\r^5p]N,\"!b\u0004\u0002\u0011\u0011L7\u000f^5oGR\fAb\u001d;sS:<\u0007K]3gSb\u0004")
public interface SeqViewLike<A, Coll, This extends SeqView<A, Coll> & SeqViewLike<A, Coll, This>>
extends Seq<A>,
IterableView<A, Coll> {
    @Override
    default public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
        return new Forced<B>(this, xs){
            private final GenSeq<B> forced;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return Forced.length$(this);
            }

            public B apply(int idx) {
                return (B)Forced.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Forced.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Forced.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Forced.viewIdentifier$(this);
            }

            public GenSeq<B> forced() {
                return this.forced;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Forced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Forced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Forced$$$outer() {
                return this.$outer;
            }
            {
                GenSeq forced;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.forced = forced = (GenSeq)xs$1.apply();
                TraversableViewLike.Forced.$init$(this);
                IterableViewLike.Forced.$init$(this);
                Forced.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newAppended(GenTraversable<B> that) {
        return new Appended<B>(this, that){
            private final GenTraversable<B> rest;
            private GenSeq<B> restSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return Appended.length$(this);
            }

            public B apply(int idx) {
                return (B)Appended.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Appended.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Appended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Appended.viewIdentifier$(this);
            }

            private GenSeq<B> restSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.restSeq = Appended.restSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.restSeq;
            }

            public GenSeq<B> restSeq() {
                if (!this.bitmap$0) {
                    return this.restSeq$lzycompute();
                }
                return this.restSeq;
            }

            public GenTraversable<B> rest() {
                return this.rest;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Appended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Appended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Appended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.rest = that$1;
                TraversableViewLike.Appended.$init$(this);
                IterableViewLike.Appended.$init$(this);
                Appended.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
        return new Prepended<B>(this, that){
            private final GenTraversable<B> fst;
            private GenSeq<B> fstSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return Prepended.length$(this);
            }

            public B apply(int idx) {
                return (B)Prepended.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Prepended.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Prepended.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Prepended.viewIdentifier$(this);
            }

            private GenSeq<B> fstSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.fstSeq = Prepended.fstSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.fstSeq;
            }

            public GenSeq<B> fstSeq() {
                if (!this.bitmap$0) {
                    return this.fstSeq$lzycompute();
                }
                return this.fstSeq;
            }

            public GenTraversable<B> fst() {
                return this.fst;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Prepended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Prepended$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Prepended$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.fst = that$2;
                TraversableViewLike.Prepended.$init$(this);
                IterableViewLike.Prepended.$init$(this);
                Prepended.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newMapped(Function1<A, B> f) {
        return new Mapped<B>(this, f){
            private final Function1<A, B> mapping;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return Mapped.length$(this);
            }

            public B apply(int idx) {
                return (B)Mapped.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.Mapped.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.Mapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Mapped.viewIdentifier$(this);
            }

            public Function1<A, B> mapping() {
                return this.mapping;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Mapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Mapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Mapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$1;
                TraversableViewLike.Mapped.$init$(this);
                IterableViewLike.Mapped.$init$(this);
                Mapped.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<B> newFlatMapped(Function1<A, GenTraversableOnce<B>> f) {
        return new FlatMapped<B>(this, f){
            private final Function1<A, GenTraversableOnce<B>> mapping;
            private int[] index;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int findRow(int idx, int lo, int hi) {
                return FlatMapped.findRow$(this, idx, lo, hi);
            }

            public int length() {
                return FlatMapped.length$(this);
            }

            public B apply(int idx) {
                return (B)FlatMapped.apply$(this, idx);
            }

            public Iterator<B> iterator() {
                return IterableViewLike.FlatMapped.iterator$(this);
            }

            public <U> void foreach(Function1<B, U> f) {
                TraversableViewLike.FlatMapped.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.FlatMapped.viewIdentifier$(this);
            }

            private int[] index$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.index = FlatMapped.index$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.index;
            }

            public int[] index() {
                if (!this.bitmap$0) {
                    return this.index$lzycompute();
                }
                return this.index;
            }

            public Function1<A, GenTraversableOnce<B>> mapping() {
                return this.mapping;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$FlatMapped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.mapping = f$2;
                TraversableViewLike.FlatMapped.$init$(this);
                IterableViewLike.FlatMapped.$init$(this);
                FlatMapped.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newFiltered(Function1<A, Object> p) {
        return new Filtered(this, p){
            private final Function1<A, Object> pred;
            private int[] index;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return Filtered.length$(this);
            }

            public A apply(int idx) {
                return (A)Filtered.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.Filtered.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.Filtered.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Filtered.viewIdentifier$(this);
            }

            private int[] index$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.index = Filtered.index$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.index;
            }

            public int[] index() {
                if (!this.bitmap$0) {
                    return this.index$lzycompute();
                }
                return this.index;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Filtered$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Filtered$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$1;
                TraversableViewLike.Filtered.$init$(this);
                IterableViewLike.Filtered.$init$(this);
                Filtered.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newSliced(SliceInterval _endpoints) {
        return new Sliced(this, _endpoints){
            private final SliceInterval endpoints;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return Sliced.length$(this);
            }

            public A apply(int idx) {
                return (A)Sliced.apply$(this, idx);
            }

            public <U> void foreach(Function1<A, U> f) {
                Sliced.foreach$(this, f);
            }

            public Iterator<A> iterator() {
                return Sliced.iterator$(this);
            }

            public int from() {
                return TraversableViewLike.Sliced.from$(this);
            }

            public int until() {
                return TraversableViewLike.Sliced.until$(this);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.Sliced.viewIdentifier$(this);
            }

            public SliceInterval endpoints() {
                return this.endpoints;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Sliced$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Sliced$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.endpoints = _endpoints$1;
                TraversableViewLike.Sliced.$init$(this);
                IterableViewLike.Sliced.$init$(this);
                Sliced.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newDroppedWhile(Function1<A, Object> p) {
        return new DroppedWhile(this, p){
            private final Function1<A, Object> pred;
            private int start;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return DroppedWhile.length$(this);
            }

            public A apply(int idx) {
                return (A)DroppedWhile.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.DroppedWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.DroppedWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.DroppedWhile.viewIdentifier$(this);
            }

            private int start$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.start = DroppedWhile.start$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.start;
            }

            public int start() {
                if (!this.bitmap$0) {
                    return this.start$lzycompute();
                }
                return this.start;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$DroppedWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$2;
                TraversableViewLike.DroppedWhile.$init$(this);
                IterableViewLike.DroppedWhile.$init$(this);
                DroppedWhile.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newTakenWhile(Function1<A, Object> p) {
        return new TakenWhile(this, p){
            private final Function1<A, Object> pred;
            private int len;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return TakenWhile.length$(this);
            }

            public A apply(int idx) {
                return (A)TakenWhile.apply$(this, idx);
            }

            public Iterator<Object> iterator() {
                return IterableViewLike.TakenWhile.iterator$(this);
            }

            public <U> void foreach(Function1<Object, U> f) {
                TraversableViewLike.TakenWhile.foreach$(this, f);
            }

            public final String viewIdentifier() {
                return TraversableViewLike.TakenWhile.viewIdentifier$(this);
            }

            private int len$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.len = TakenWhile.len$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.len;
            }

            public int len() {
                if (!this.bitmap$0) {
                    return this.len$lzycompute();
                }
                return this.len;
            }

            public Function1<A, Object> pred() {
                return this.pred;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$TakenWhile$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.pred = p$3;
                TraversableViewLike.TakenWhile.$init$(this);
                IterableViewLike.TakenWhile.$init$(this);
                TakenWhile.$init$(this);
            }
        };
    }

    @Override
    default public <B> Transformed<Tuple2<A, B>> newZipped(GenIterable<B> that) {
        return new Zipped<B>(this, that){
            private final GenIterable<B> other;
            private Seq<B> thatSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return Zipped.length$(this);
            }

            public Tuple2<A, B> apply(int idx) {
                return Zipped.apply$(this, idx);
            }

            public Iterator<Tuple2<A, B>> iterator() {
                return IterableViewLike.Zipped.iterator$(this);
            }

            public final String viewIdentifier() {
                return IterableViewLike.Zipped.viewIdentifier$(this);
            }

            private Seq<B> thatSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.thatSeq = Zipped.thatSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.thatSeq;
            }

            public Seq<B> thatSeq() {
                if (!this.bitmap$0) {
                    return this.thatSeq$lzycompute();
                }
                return this.thatSeq;
            }

            public GenIterable<B> other() {
                return this.other;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Zipped$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Zipped$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.other = that$3;
                IterableViewLike.Zipped.$init$(this);
                Zipped.$init$(this);
            }
        };
    }

    @Override
    default public <A1, B> Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
        return new ZippedAll<A1, B>(this, that, _thisElem, _thatElem){
            private final GenIterable<B> other;
            private final A1 thisElem;
            private final B thatElem;
            private Seq<B> thatSeq;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public int length() {
                return ZippedAll.length$(this);
            }

            public Tuple2<A1, B> apply(int idx) {
                return ZippedAll.apply$(this, idx);
            }

            public final String viewIdentifier() {
                return IterableViewLike.ZippedAll.viewIdentifier$(this);
            }

            public Iterator<Tuple2<A1, B>> iterator() {
                return IterableViewLike.ZippedAll.iterator$(this);
            }

            private Seq<B> thatSeq$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.thatSeq = ZippedAll.thatSeq$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.thatSeq;
            }

            public Seq<B> thatSeq() {
                if (!this.bitmap$0) {
                    return this.thatSeq$lzycompute();
                }
                return this.thatSeq;
            }

            public GenIterable<B> other() {
                return this.other;
            }

            public A1 thisElem() {
                return this.thisElem;
            }

            public B thatElem() {
                return this.thatElem;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$ZippedAll$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$ZippedAll$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.other = that$4;
                this.thisElem = _thisElem$1;
                this.thatElem = _thatElem$1;
                IterableViewLike.ZippedAll.$init$(this);
                ZippedAll.$init$(this);
            }
        };
    }

    default public Transformed<A> newReversed() {
        return new Reversed(this){
            private final /* synthetic */ SeqViewLike $outer;

            public Iterator<A> iterator() {
                return Reversed.iterator$(this);
            }

            public int length() {
                return Reversed.length$(this);
            }

            public A apply(int idx) {
                return (A)Reversed.apply$(this, idx);
            }

            public final String viewIdentifier() {
                return Reversed.viewIdentifier$(this);
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Reversed$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                Reversed.$init$(this);
            }
        };
    }

    default public <B> Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
        return new Patched<B>(this, _from, _patch, _replaced){
            private final int from;
            private final GenSeq<B> patch;
            private final int replaced;
            private int scala$collection$SeqViewLike$Patched$$plen;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SeqViewLike $outer;

            public Iterator<B> iterator() {
                return Patched.iterator$(this);
            }

            public int length() {
                return Patched.length$(this);
            }

            public B apply(int idx) {
                return (B)Patched.apply$(this, idx);
            }

            public final String viewIdentifier() {
                return Patched.viewIdentifier$(this);
            }

            private int scala$collection$SeqViewLike$Patched$$plen$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.scala$collection$SeqViewLike$Patched$$plen = Patched.scala$collection$SeqViewLike$Patched$$plen$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.scala$collection$SeqViewLike$Patched$$plen;
            }

            public int scala$collection$SeqViewLike$Patched$$plen() {
                if (!this.bitmap$0) {
                    return this.scala$collection$SeqViewLike$Patched$$plen$lzycompute();
                }
                return this.scala$collection$SeqViewLike$Patched$$plen;
            }

            public int from() {
                return this.from;
            }

            public GenSeq<B> patch() {
                return this.patch;
            }

            public int replaced() {
                return this.replaced;
            }

            public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Patched$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.from = _from$1;
                this.patch = _patch$1;
                this.replaced = _replaced$1;
                Patched.$init$(this);
            }
        };
    }

    @Override
    default public Transformed<A> newTaken(int n) {
        return this.newSliced(SliceInterval$.MODULE$.apply(0, n));
    }

    @Override
    default public Transformed<A> newDropped(int n) {
        return this.newSliced(SliceInterval$.MODULE$.apply(n, Integer.MAX_VALUE));
    }

    @Override
    default public This reverse() {
        return (This)this.newReversed();
    }

    @Override
    default public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<This, B, That> bf) {
        int nonNegFrom = package$.MODULE$.max(0, from);
        int nonNegRep = package$.MODULE$.max(0, replaced);
        return (That)this.newPatched(nonNegFrom, patch, nonNegRep);
    }

    @Override
    default public <B, That> That padTo(int len, B elem, CanBuildFrom<This, B, That> bf) {
        int fill_n;
        int n = this.length();
        Seq$ seq$ = Seq$.MODULE$;
        int n2 = len - this.length();
        if (seq$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)seq$).newBuilder();
        fill_b.sizeHint(fill_n);
        for (int fill_i = 0; fill_i < fill_n; ++fill_i) {
            fill_b.$plus$eq(elem);
        }
        return this.patch(n, (GenSeq<B>)((GenSeq)((GenTraversable)fill_b.result())), 0, bf);
    }

    @Override
    default public <B, That> That reverseMap(Function1<A, B> f, CanBuildFrom<This, B, That> bf) {
        return this.reverse().map(f, bf);
    }

    @Override
    default public <B, That> That updated(int index, B elem, CanBuildFrom<This, B, That> bf) {
        Predef$.MODULE$.require(0 <= index && index < this.length());
        return this.patch(index, (GenSeq<B>)List$.MODULE$.apply((Seq)Predef$.MODULE$.genericWrapArray(new Object[]{elem})), 1, bf);
    }

    @Override
    default public <B, That> That $plus$colon(B elem, CanBuildFrom<This, B, That> bf) {
        return (That)this.newPrepended(Nil$.MODULE$.$colon$colon(elem));
    }

    @Override
    default public <B, That> That $colon$plus(B elem, CanBuildFrom<This, B, That> bf) {
        return this.$plus$plus(Iterator$.MODULE$.single(elem), bf);
    }

    @Override
    default public <B, That> That union(GenSeq<B> that, CanBuildFrom<This, B, That> bf) {
        return (That)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> this.thisSeq().union(that, Seq$.MODULE$.canBuildFrom()));
    }

    @Override
    default public <B> This diff(GenSeq<B> that) {
        return (This)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> (Seq)this.thisSeq().diff(that));
    }

    @Override
    default public <B> This intersect(GenSeq<B> that) {
        return (This)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> (Seq)this.thisSeq().intersect(that));
    }

    @Override
    default public <B> This sorted(Ordering<B> ord) {
        return (This)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> (Seq)this.thisSeq().sorted(ord));
    }

    @Override
    default public This sortWith(Function2<A, A, Object> lt) {
        return (This)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> (Seq)this.thisSeq().sortWith(lt));
    }

    @Override
    default public <B> This sortBy(Function1<A, B> f, Ordering<B> ord) {
        return (This)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> (Seq)this.thisSeq().sortBy(f, ord));
    }

    @Override
    default public Iterator<This> combinations(int n) {
        return this.thisSeq().combinations(n).map((Function1<Seq, SeqView> & java.io.Serializable & Serializable)as -> this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> as));
    }

    @Override
    default public Iterator<This> permutations() {
        return this.thisSeq().permutations().map((Function1<Seq, SeqView> & java.io.Serializable & Serializable)as -> this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> as));
    }

    @Override
    default public This distinct() {
        return (This)this.newForced((Function0<Seq> & java.io.Serializable & Serializable)() -> (Seq)this.thisSeq().distinct());
    }

    @Override
    default public String stringPrefix() {
        return "SeqView";
    }

    public static void $init$(SeqViewLike $this) {
    }

    public abstract class AbstractTransformed<B>
    implements Transformed<B> {
        private Coll underlying;
        private volatile boolean bitmap$0;

        @Override
        public String toString() {
            return ((Transformed)this).toString();
        }

        @Override
        public <B> Transformed<B> newForced(Function0<GenSeq<B>> xs) {
            return ((SeqViewLike)this).newForced(xs);
        }

        @Override
        public <B> Transformed<B> newAppended(GenTraversable<B> that) {
            return ((SeqViewLike)this).newAppended(that);
        }

        @Override
        public <B> Transformed<B> newPrepended(GenTraversable<B> that) {
            return ((SeqViewLike)this).newPrepended(that);
        }

        @Override
        public <B> Transformed<B> newMapped(Function1<B, B> f) {
            return ((SeqViewLike)this).newMapped(f);
        }

        @Override
        public <B> Transformed<B> newFlatMapped(Function1<B, GenTraversableOnce<B>> f) {
            return ((SeqViewLike)this).newFlatMapped(f);
        }

        @Override
        public Transformed<B> newFiltered(Function1<B, Object> p) {
            return ((SeqViewLike)this).newFiltered(p);
        }

        @Override
        public Transformed<B> newSliced(SliceInterval _endpoints) {
            return ((SeqViewLike)this).newSliced(_endpoints);
        }

        @Override
        public Transformed<B> newDroppedWhile(Function1<B, Object> p) {
            return ((SeqViewLike)this).newDroppedWhile(p);
        }

        @Override
        public Transformed<B> newTakenWhile(Function1<B, Object> p) {
            return ((SeqViewLike)this).newTakenWhile(p);
        }

        @Override
        public <B> Transformed<Tuple2<B, B>> newZipped(GenIterable<B> that) {
            return ((SeqViewLike)this).newZipped(that);
        }

        @Override
        public <A1, B> Transformed<Tuple2<A1, B>> newZippedAll(GenIterable<B> that, A1 _thisElem, B _thatElem) {
            return ((SeqViewLike)this).newZippedAll(that, _thisElem, _thatElem);
        }

        @Override
        public Transformed<B> newReversed() {
            return ((SeqViewLike)this).newReversed();
        }

        @Override
        public <B> Transformed<B> newPatched(int _from, GenSeq<B> _patch, int _replaced) {
            return ((SeqViewLike)this).newPatched(_from, _patch, _replaced);
        }

        @Override
        public Transformed<B> newTaken(int n) {
            return ((SeqViewLike)this).newTaken(n);
        }

        @Override
        public Transformed<B> newDropped(int n) {
            return ((SeqViewLike)this).newDropped(n);
        }

        @Override
        public SeqView<B, Coll> reverse() {
            return ((SeqViewLike)this).reverse();
        }

        @Override
        public <B, That> That patch(int from, GenSeq<B> patch, int replaced, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)((SeqViewLike)this).patch(from, (GenSeq<B>)patch, replaced, bf);
        }

        @Override
        public <B, That> That padTo(int len, B elem, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)((SeqViewLike)this).padTo(len, (B)elem, bf);
        }

        @Override
        public <B, That> That reverseMap(Function1<B, B> f, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)((SeqViewLike)this).reverseMap((Function1<A, B>)f, bf);
        }

        @Override
        public <B, That> That updated(int index, B elem, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)((SeqViewLike)this).updated(index, (B)elem, bf);
        }

        @Override
        public <B, That> That $plus$colon(B elem, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)((SeqViewLike)this).$plus$colon((B)elem, bf);
        }

        @Override
        public <B, That> That $colon$plus(B elem, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)((SeqViewLike)this).$colon$plus((B)elem, bf);
        }

        @Override
        public <B, That> That union(GenSeq<B> that, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)((SeqViewLike)this).union((GenSeq<B>)that, bf);
        }

        @Override
        public <B> SeqView<B, Coll> diff(GenSeq<B> that) {
            return ((SeqViewLike)this).diff(that);
        }

        @Override
        public <B> SeqView<B, Coll> intersect(GenSeq<B> that) {
            return ((SeqViewLike)this).intersect(that);
        }

        @Override
        public <B> SeqView<B, Coll> sorted(Ordering<B> ord) {
            return ((SeqViewLike)this).sorted(ord);
        }

        @Override
        public SeqView<B, Coll> sortWith(Function2<B, B, Object> lt) {
            return ((SeqViewLike)this).sortWith(lt);
        }

        @Override
        public <B> SeqView<B, Coll> sortBy(Function1<B, B> f, Ordering<B> ord) {
            return ((SeqViewLike)this).sortBy(f, ord);
        }

        @Override
        public Iterator<SeqView<B, Coll>> combinations(int n) {
            return ((SeqViewLike)this).combinations(n);
        }

        @Override
        public Iterator<SeqView<B, Coll>> permutations() {
            return ((SeqViewLike)this).permutations();
        }

        @Override
        public SeqView<B, Coll> distinct() {
            return ((SeqViewLike)this).distinct();
        }

        @Override
        public String stringPrefix() {
            return ((SeqViewLike)this).stringPrefix();
        }

        @Override
        public <U> void foreach(Function1<B, U> f) {
            IterableViewLike.Transformed.foreach$(this, f);
        }

        @Override
        public boolean isEmpty() {
            return IterableViewLike.Transformed.isEmpty$(this);
        }

        @Override
        public final String viewIdString() {
            return TraversableViewLike.Transformed.viewIdString$(this);
        }

        @Override
        public Option<B> headOption() {
            return TraversableViewLike.Transformed.headOption$(this);
        }

        @Override
        public B last() {
            return (B)TraversableViewLike.Transformed.last$(this);
        }

        @Override
        public Option<B> lastOption() {
            return TraversableViewLike.Transformed.lastOption$(this);
        }

        @Override
        public IterableView drop(int n) {
            return IterableViewLike.drop$(this, n);
        }

        @Override
        public IterableView take(int n) {
            return IterableViewLike.take$(this, n);
        }

        @Override
        public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<SeqView<B, Coll>, Tuple2<A1, B>, That> bf) {
            return (That)IterableViewLike.zip$(this, that, bf);
        }

        @Override
        public <A1, That> That zipWithIndex(CanBuildFrom<SeqView<B, Coll>, Tuple2<A1, Object>, That> bf) {
            return (That)IterableViewLike.zipWithIndex$(this, bf);
        }

        @Override
        public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<SeqView<B, Coll>, Tuple2<A1, B>, That> bf) {
            return (That)IterableViewLike.zipAll$(this, that, thisElem, thatElem, bf);
        }

        @Override
        public Iterator<SeqView<B, Coll>> grouped(int size) {
            return IterableViewLike.grouped$(this, size);
        }

        @Override
        public Iterator<SeqView<B, Coll>> sliding(int size, int step) {
            return IterableViewLike.sliding$(this, size, step);
        }

        @Override
        public Iterator<SeqView<B, Coll>> sliding(int size) {
            return IterableViewLike.sliding$(this, size);
        }

        @Override
        public IterableView dropRight(int n) {
            return IterableViewLike.dropRight$(this, n);
        }

        @Override
        public IterableView takeRight(int n) {
            return IterableViewLike.takeRight$(this, n);
        }

        @Override
        public /* synthetic */ TraversableView scala$collection$TraversableViewLike$$super$tail() {
            return (TraversableView)TraversableLike.tail$(this);
        }

        @Override
        public String viewIdentifier() {
            return TraversableViewLike.viewIdentifier$(this);
        }

        @Override
        public String viewToString() {
            return TraversableViewLike.viewToString$(this);
        }

        @Override
        public Builder<B, SeqView<B, Coll>> newBuilder() {
            return TraversableViewLike.newBuilder$(this);
        }

        @Override
        public <B, That> That force(CanBuildFrom<Coll, B, That> bf) {
            return (That)TraversableViewLike.force$(this, bf);
        }

        @Override
        public <B, That> That $plus$plus(GenTraversableOnce<B> xs, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.$plus$plus$(this, xs, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(TraversableOnce<B> xs, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
        }

        @Override
        public <B, That> That $plus$plus$colon(Traversable<B> xs, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.$plus$plus$colon$((TraversableViewLike)this, xs, bf);
        }

        @Override
        public <B, That> That map(Function1<B, B> f, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.map$(this, f, bf);
        }

        @Override
        public <B, That> That collect(PartialFunction<B, B> pf, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.collect$(this, pf, bf);
        }

        @Override
        public <B, That> That flatMap(Function1<B, GenTraversableOnce<B>> f, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.flatMap$(this, f, bf);
        }

        @Override
        public <B> TraversableViewLike.Transformed<B> flatten(Function1<B, GenTraversableOnce<B>> asTraversable) {
            return TraversableViewLike.flatten$(this, asTraversable);
        }

        @Override
        public TraversableView filter(Function1 p) {
            return TraversableViewLike.filter$(this, p);
        }

        @Override
        public TraversableView withFilter(Function1 p) {
            return TraversableViewLike.withFilter$(this, p);
        }

        @Override
        public Tuple2<SeqView<B, Coll>, SeqView<B, Coll>> partition(Function1<B, Object> p) {
            return TraversableViewLike.partition$(this, p);
        }

        @Override
        public TraversableView init() {
            return TraversableViewLike.init$(this);
        }

        @Override
        public TraversableView slice(int from, int until) {
            return TraversableViewLike.slice$(this, from, until);
        }

        @Override
        public TraversableView dropWhile(Function1 p) {
            return TraversableViewLike.dropWhile$(this, p);
        }

        @Override
        public TraversableView takeWhile(Function1 p) {
            return TraversableViewLike.takeWhile$(this, p);
        }

        @Override
        public Tuple2<SeqView<B, Coll>, SeqView<B, Coll>> span(Function1<B, Object> p) {
            return TraversableViewLike.span$(this, p);
        }

        @Override
        public Tuple2<SeqView<B, Coll>, SeqView<B, Coll>> splitAt(int n) {
            return TraversableViewLike.splitAt$(this, n);
        }

        @Override
        public <B, That> That scanLeft(B z, Function2<B, B, B> op, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.scanLeft$(this, z, op, bf);
        }

        @Override
        public <B, That> That scanRight(B z, Function2<B, B, B> op, CanBuildFrom<SeqView<B, Coll>, B, That> bf) {
            return (That)TraversableViewLike.scanRight$(this, z, op, bf);
        }

        @Override
        public <K> Map<K, SeqView<B, Coll>> groupBy(Function1<B, K> f) {
            return TraversableViewLike.groupBy$(this, f);
        }

        @Override
        public <A1, A2> Tuple2<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>> unzip(Function1<B, Tuple2<A1, A2>> asPair) {
            return TraversableViewLike.unzip$(this, asPair);
        }

        @Override
        public <A1, A2, A3> Tuple3<TraversableViewLike.Transformed<A1>, TraversableViewLike.Transformed<A2>, TraversableViewLike.Transformed<A3>> unzip3(Function1<B, Tuple3<A1, A2, A3>> asTriple) {
            return TraversableViewLike.unzip3$(this, asTriple);
        }

        @Override
        public TraversableView filterNot(Function1 p) {
            return TraversableViewLike.filterNot$(this, p);
        }

        @Override
        public Iterator<SeqView<B, Coll>> inits() {
            return TraversableViewLike.inits$(this);
        }

        @Override
        public Iterator<SeqView<B, Coll>> tails() {
            return TraversableViewLike.tails$(this);
        }

        @Override
        public TraversableView tail() {
            return TraversableViewLike.tail$(this);
        }

        @Override
        public Seq<B> thisSeq() {
            return ViewMkString.thisSeq$(this);
        }

        @Override
        public String mkString() {
            return ViewMkString.mkString$(this);
        }

        @Override
        public String mkString(String sep) {
            return ViewMkString.mkString$(this, sep);
        }

        @Override
        public String mkString(String start, String sep, String end) {
            return ViewMkString.mkString$(this, start, sep, end);
        }

        @Override
        public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
            return ViewMkString.addString$(this, b, start, sep, end);
        }

        @Override
        public GenericCompanion<Seq> companion() {
            return Seq.companion$(this);
        }

        @Override
        public Seq<B> seq() {
            return Seq.seq$(this);
        }

        @Override
        public Seq<B> thisCollection() {
            return SeqLike.thisCollection$(this);
        }

        @Override
        public Seq toCollection(Object repr) {
            return SeqLike.toCollection$(this, repr);
        }

        @Override
        public Combiner<B, ParSeq<B>> parCombiner() {
            return SeqLike.parCombiner$(this);
        }

        @Override
        public int lengthCompare(int len) {
            return SeqLike.lengthCompare$(this, len);
        }

        @Override
        public int size() {
            return SeqLike.size$(this);
        }

        @Override
        public int segmentLength(Function1<B, Object> p, int from) {
            return SeqLike.segmentLength$(this, p, from);
        }

        @Override
        public int indexWhere(Function1<B, Object> p, int from) {
            return SeqLike.indexWhere$(this, p, from);
        }

        @Override
        public int lastIndexWhere(Function1<B, Object> p, int end) {
            return SeqLike.lastIndexWhere$(this, p, end);
        }

        @Override
        public Iterator<B> reverseIterator() {
            return SeqLike.reverseIterator$(this);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that, int offset) {
            return SeqLike.startsWith$(this, that, offset);
        }

        @Override
        public <B> boolean endsWith(GenSeq<B> that) {
            return SeqLike.endsWith$(this, that);
        }

        @Override
        public <B> int indexOfSlice(GenSeq<B> that) {
            return SeqLike.indexOfSlice$(this, that);
        }

        @Override
        public <B> int indexOfSlice(GenSeq<B> that, int from) {
            return SeqLike.indexOfSlice$(this, that, from);
        }

        @Override
        public <B> int lastIndexOfSlice(GenSeq<B> that) {
            return SeqLike.lastIndexOfSlice$(this, that);
        }

        @Override
        public <B> int lastIndexOfSlice(GenSeq<B> that, int end) {
            return SeqLike.lastIndexOfSlice$(this, that, end);
        }

        @Override
        public <B> boolean containsSlice(GenSeq<B> that) {
            return SeqLike.containsSlice$(this, that);
        }

        @Override
        public <A1> boolean contains(A1 elem) {
            return SeqLike.contains$(this, elem);
        }

        @Override
        public <B> boolean corresponds(GenSeq<B> that, Function2<B, B, Object> p) {
            return SeqLike.corresponds$(this, that, p);
        }

        @Override
        public Seq<B> toSeq() {
            return SeqLike.toSeq$(this);
        }

        @Override
        public Range indices() {
            return SeqLike.indices$(this);
        }

        @Override
        public SeqView<B, SeqView<B, Coll>> view() {
            return SeqLike.view$(this);
        }

        @Override
        public SeqView<B, SeqView<B, Coll>> view(int from, int until) {
            return SeqLike.view$(this, from, until);
        }

        @Override
        public boolean isDefinedAt(int idx) {
            return GenSeqLike.isDefinedAt$(this, idx);
        }

        @Override
        public int prefixLength(Function1<B, Object> p) {
            return GenSeqLike.prefixLength$(this, p);
        }

        @Override
        public int indexWhere(Function1<B, Object> p) {
            return GenSeqLike.indexWhere$(this, p);
        }

        @Override
        public <B> int indexOf(B elem) {
            return GenSeqLike.indexOf$(this, elem);
        }

        @Override
        public <B> int indexOf(B elem, int from) {
            return GenSeqLike.indexOf$(this, elem, from);
        }

        @Override
        public <B> int lastIndexOf(B elem) {
            return GenSeqLike.lastIndexOf$(this, elem);
        }

        @Override
        public <B> int lastIndexOf(B elem, int end) {
            return GenSeqLike.lastIndexOf$(this, elem, end);
        }

        @Override
        public int lastIndexWhere(Function1<B, Object> p) {
            return GenSeqLike.lastIndexWhere$(this, p);
        }

        @Override
        public <B> boolean startsWith(GenSeq<B> that) {
            return GenSeqLike.startsWith$(this, that);
        }

        @Override
        public int hashCode() {
            return GenSeqLike.hashCode$(this);
        }

        @Override
        public boolean equals(Object that) {
            return GenSeqLike.equals$(this, that);
        }

        @Override
        public boolean forall(Function1<B, Object> p) {
            return IterableLike.forall$(this, p);
        }

        @Override
        public boolean exists(Function1<B, Object> p) {
            return IterableLike.exists$(this, p);
        }

        @Override
        public Option<B> find(Function1<B, Object> p) {
            return IterableLike.find$(this, p);
        }

        @Override
        public <B> B foldRight(B z, Function2<B, B, B> op) {
            return (B)IterableLike.foldRight$(this, z, op);
        }

        @Override
        public <B> B reduceRight(Function2<B, B, B> op) {
            return (B)IterableLike.reduceRight$(this, op);
        }

        @Override
        public Iterable<B> toIterable() {
            return IterableLike.toIterable$(this);
        }

        @Override
        public Iterator<B> toIterator() {
            return IterableLike.toIterator$(this);
        }

        @Override
        public B head() {
            return (B)IterableLike.head$(this);
        }

        @Override
        public <B> void copyToArray(Object xs, int start, int len) {
            IterableLike.copyToArray$(this, xs, start, len);
        }

        @Override
        public <B> boolean sameElements(GenIterable<B> that) {
            return IterableLike.sameElements$(this, that);
        }

        @Override
        public Stream<B> toStream() {
            return IterableLike.toStream$(this);
        }

        @Override
        public boolean canEqual(Object that) {
            return IterableLike.canEqual$(this, that);
        }

        @Override
        public <B> Builder<B, Seq<B>> genericBuilder() {
            return GenericTraversableTemplate.genericBuilder$(this);
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
        public Object filterImpl(Function1 p, boolean isFlipped) {
            return TraversableLike.filterImpl$(this, p, isFlipped);
        }

        @Override
        public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<SeqView<B, Coll>, B, That> cbf) {
            return (That)TraversableLike.scan$(this, z, op, cbf);
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
        public Traversable<B> toTraversable() {
            return TraversableLike.toTraversable$(this);
        }

        @Override
        public <Col> Col to(CanBuildFrom<Nothing$, B, Col> cbf) {
            return (Col)TraversableLike.to$(this, cbf);
        }

        @Override
        public Parallel par() {
            return Parallelizable.par$(this);
        }

        @Override
        public List<B> reversed() {
            return TraversableOnce.reversed$(this);
        }

        @Override
        public boolean nonEmpty() {
            return TraversableOnce.nonEmpty$(this);
        }

        @Override
        public int count(Function1<B, Object> p) {
            return TraversableOnce.count$(this, p);
        }

        @Override
        public <B> Option<B> collectFirst(PartialFunction<B, B> pf) {
            return TraversableOnce.collectFirst$(this, pf);
        }

        @Override
        public <B> B $div$colon(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.$div$colon$(this, z, op);
        }

        @Override
        public <B> B $colon$bslash(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.$colon$bslash$(this, z, op);
        }

        @Override
        public <B> B foldLeft(B z, Function2<B, B, B> op) {
            return (B)TraversableOnce.foldLeft$(this, z, op);
        }

        @Override
        public <B> B reduceLeft(Function2<B, B, B> op) {
            return (B)TraversableOnce.reduceLeft$(this, op);
        }

        @Override
        public <B> Option<B> reduceLeftOption(Function2<B, B, B> op) {
            return TraversableOnce.reduceLeftOption$(this, op);
        }

        @Override
        public <B> Option<B> reduceRightOption(Function2<B, B, B> op) {
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
        public <B> B aggregate(Function0<B> z, Function2<B, B, B> seqop, Function2<B, B, B> combop) {
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
        public <B> B min(Ordering<B> cmp) {
            return (B)TraversableOnce.min$(this, cmp);
        }

        @Override
        public <B> B max(Ordering<B> cmp) {
            return (B)TraversableOnce.max$(this, cmp);
        }

        @Override
        public <B> B maxBy(Function1<B, B> f, Ordering<B> cmp) {
            return (B)TraversableOnce.maxBy$(this, f, cmp);
        }

        @Override
        public <B> B minBy(Function1<B, B> f, Ordering<B> cmp) {
            return (B)TraversableOnce.minBy$(this, f, cmp);
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
        public List<B> toList() {
            return TraversableOnce.toList$(this);
        }

        @Override
        public IndexedSeq<B> toIndexedSeq() {
            return TraversableOnce.toIndexedSeq$(this);
        }

        @Override
        public <B> Buffer<B> toBuffer() {
            return TraversableOnce.toBuffer$(this);
        }

        @Override
        public <B> Set<B> toSet() {
            return TraversableOnce.toSet$(this);
        }

        @Override
        public Vector<B> toVector() {
            return TraversableOnce.toVector$(this);
        }

        @Override
        public <T, U> Map<T, U> toMap(Predef$.less.colon.less<B, Tuple2<T, U>> ev) {
            return TraversableOnce.toMap$(this, ev);
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
        public <A1, B1> PartialFunction<A1, B1> orElse(PartialFunction<A1, B1> that) {
            return PartialFunction.orElse$(this, that);
        }

        @Override
        public <C> PartialFunction<Object, C> andThen(Function1<B, C> k) {
            return PartialFunction.andThen$(this, k);
        }

        @Override
        public Function1<Object, Option<B>> lift() {
            return PartialFunction.lift$(this);
        }

        @Override
        public Object applyOrElse(Object x, Function1 function1) {
            return PartialFunction.applyOrElse$(this, x, function1);
        }

        @Override
        public <U> Function1<Object, Object> runWith(Function1<B, U> action) {
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
        public <A> Function1<A, B> compose(Function1<A, Object> g) {
            return Function1.compose$(this, g);
        }

        private Coll underlying$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.underlying = TraversableViewLike.Transformed.underlying$(this);
                    this.bitmap$0 = true;
                }
            }
            return this.underlying;
        }

        @Override
        public Coll underlying() {
            if (!this.bitmap$0) {
                return this.underlying$lzycompute();
            }
            return this.underlying;
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$AbstractTransformed$$$outer() {
            return SeqViewLike.this;
        }

        @Override
        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Transformed$$$outer() {
            return this.scala$collection$SeqViewLike$AbstractTransformed$$$outer();
        }

        @Override
        public /* synthetic */ IterableViewLike scala$collection$IterableViewLike$Transformed$$$outer() {
            return this.scala$collection$SeqViewLike$AbstractTransformed$$$outer();
        }

        @Override
        public /* synthetic */ TraversableViewLike scala$collection$TraversableViewLike$Transformed$$$outer() {
            return this.scala$collection$SeqViewLike$AbstractTransformed$$$outer();
        }

        public AbstractTransformed() {
            if (SeqViewLike.this == null) {
                throw null;
            }
            PartialFunction.$init$(this);
            GenTraversableOnce.$init$(this);
            TraversableOnce.$init$(this);
            Parallelizable.$init$(this);
            TraversableLike.$init$(this);
            GenericTraversableTemplate.$init$(this);
            GenTraversable.$init$(this);
            Traversable.$init$(this);
            GenIterable.$init$(this);
            IterableLike.$init$(this);
            Iterable.$init$(this);
            GenSeqLike.$init$(this);
            GenSeq.$init$(this);
            SeqLike.$init$(this);
            Seq.$init$(this);
            ViewMkString.$init$(this);
            TraversableViewLike.$init$(this);
            IterableViewLike.$init$(this);
            TraversableViewLike.Transformed.$init$(this);
            IterableViewLike.Transformed.$init$(this);
            SeqViewLike.$init$(this);
            Transformed.$init$(this);
        }
    }

    public interface Appended<B>
    extends IterableViewLike.Appended<B>,
    Transformed<B> {
        public static /* synthetic */ GenSeq restSeq$(Appended $this) {
            return $this.restSeq();
        }

        default public GenSeq<B> restSeq() {
            return this.rest().toSeq();
        }

        public static /* synthetic */ int length$(Appended $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.scala$collection$SeqViewLike$Appended$$$outer().length() + this.restSeq().length();
        }

        public static /* synthetic */ Object apply$(Appended $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public B apply(int idx) {
            if (idx < this.scala$collection$SeqViewLike$Appended$$$outer().length()) {
                return (B)this.scala$collection$SeqViewLike$Appended$$$outer().apply(idx);
            }
            return (B)this.restSeq().apply(idx - this.scala$collection$SeqViewLike$Appended$$$outer().length());
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Appended$$$outer();

        public static void $init$(Appended $this) {
        }
    }

    public interface DroppedWhile
    extends IterableViewLike.DroppedWhile,
    Transformed<A> {
        public static /* synthetic */ int start$(DroppedWhile $this) {
            return $this.start();
        }

        default public int start() {
            return this.scala$collection$SeqViewLike$DroppedWhile$$$outer().prefixLength(this.pred());
        }

        public static /* synthetic */ int length$(DroppedWhile $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.scala$collection$SeqViewLike$DroppedWhile$$$outer().length() - this.start();
        }

        public static /* synthetic */ Object apply$(DroppedWhile $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public A apply(int idx) {
            if (idx >= 0) {
                return this.scala$collection$SeqViewLike$DroppedWhile$$$outer().apply(idx + this.start());
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$DroppedWhile$$$outer();

        public static void $init$(DroppedWhile $this) {
        }
    }

    public interface EmptyView
    extends Transformed<Nothing$>,
    IterableViewLike.EmptyView {
        public static /* synthetic */ int length$(EmptyView $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return 0;
        }

        public static /* synthetic */ Nothing$ apply$(EmptyView $this, int n) {
            return $this.apply(n);
        }

        @Override
        default public Nothing$ apply(int n) {
            return (Nothing$)Nil$.MODULE$.apply(n);
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$EmptyView$$$outer();

        public static void $init$(EmptyView $this) {
        }
    }

    public interface Filtered
    extends IterableViewLike.Filtered,
    Transformed<A> {
        public static /* synthetic */ int[] index$(Filtered $this) {
            return $this.index();
        }

        default public int[] index() {
            IntRef len = IntRef.create(0);
            int[] arr = new int[this.scala$collection$SeqViewLike$Filtered$$$outer().length()];
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Range range = RichInt$.MODULE$.until$extension0(n, this.scala$collection$SeqViewLike$Filtered$$$outer().length());
            if (range == null) {
                throw null;
            }
            Range foreach$mVc$sp_this = range;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    Filtered.$anonfun$index$2(this, arr, len, foreach$mVc$sp_i);
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
            }
            return (int[])new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(arr)).take(len.elem);
        }

        public static /* synthetic */ int length$(Filtered $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.index().length;
        }

        public static /* synthetic */ Object apply$(Filtered $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public A apply(int idx) {
            return this.scala$collection$SeqViewLike$Filtered$$$outer().apply(this.index()[idx]);
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Filtered$$$outer();

        public static /* synthetic */ void $anonfun$index$2(Filtered $this, int[] arr$1, IntRef len$1, int i) {
            if (BoxesRunTime.unboxToBoolean($this.pred().apply($this.scala$collection$SeqViewLike$Filtered$$$outer().apply(i)))) {
                arr$1[len$1.elem] = i;
                ++len$1.elem;
            }
        }

        public static void $init$(Filtered $this) {
        }
    }

    public interface FlatMapped<B>
    extends IterableViewLike.FlatMapped<B>,
    Transformed<B> {
        public static /* synthetic */ int[] index$(FlatMapped $this) {
            return $this.index();
        }

        /*
         * WARNING - void declaration
         */
        default public int[] index() {
            void var1_1;
            int[] index = new int[this.scala$collection$SeqViewLike$FlatMapped$$$outer().length() + 1];
            index[0] = 0;
            int n = 0;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            Range range = RichInt$.MODULE$.until$extension0(n, this.scala$collection$SeqViewLike$FlatMapped$$$outer().length());
            if (range == null) {
                throw null;
            }
            Range foreach$mVc$sp_this = range;
            if (!foreach$mVc$sp_this.isEmpty()) {
                int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
                while (true) {
                    index[foreach$mVc$sp_i + 1] = index[foreach$mVc$sp_i] + this.mapping().apply(this.scala$collection$SeqViewLike$FlatMapped$$$outer().apply(foreach$mVc$sp_i)).seq().size();
                    if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                    foreach$mVc$sp_i += foreach$mVc$sp_this.step();
                }
            }
            return var1_1;
        }

        public static /* synthetic */ int findRow$(FlatMapped $this, int idx, int lo, int hi) {
            return $this.findRow(idx, lo, hi);
        }

        default public int findRow(int idx, int lo, int hi) {
            int mid = (lo + hi) / 2;
            if (idx < this.index()[mid]) {
                return this.findRow(idx, lo, mid - 1);
            }
            if (idx >= this.index()[mid + 1]) {
                return this.findRow(idx, mid + 1, hi);
            }
            return mid;
        }

        public static /* synthetic */ int length$(FlatMapped $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.index()[this.scala$collection$SeqViewLike$FlatMapped$$$outer().length()];
        }

        public static /* synthetic */ Object apply$(FlatMapped $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public B apply(int idx) {
            if (idx < 0 || idx >= this.length()) {
                throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
            }
            int row = this.findRow(idx, 0, this.scala$collection$SeqViewLike$FlatMapped$$$outer().length() - 1);
            return (B)this.mapping().apply(this.scala$collection$SeqViewLike$FlatMapped$$$outer().apply(row)).seq().toSeq().apply(idx - this.index()[row]);
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$FlatMapped$$$outer();

        public static void $init$(FlatMapped $this) {
        }
    }

    public interface Forced<B>
    extends IterableViewLike.Forced<B>,
    Transformed<B> {
        public static /* synthetic */ int length$(Forced $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.forced().length();
        }

        public static /* synthetic */ Object apply$(Forced $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public B apply(int idx) {
            return (B)this.forced().apply(idx);
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Forced$$$outer();

        public static void $init$(Forced $this) {
        }
    }

    public interface Mapped<B>
    extends IterableViewLike.Mapped<B>,
    Transformed<B> {
        public static /* synthetic */ int length$(Mapped $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.scala$collection$SeqViewLike$Mapped$$$outer().length();
        }

        public static /* synthetic */ Object apply$(Mapped $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public B apply(int idx) {
            return this.mapping().apply(this.scala$collection$SeqViewLike$Mapped$$$outer().apply(idx));
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Mapped$$$outer();

        public static void $init$(Mapped $this) {
        }
    }

    public interface Patched<B>
    extends Transformed<B> {
        public int from();

        public GenSeq<B> patch();

        public int replaced();

        public static /* synthetic */ int scala$collection$SeqViewLike$Patched$$plen$(Patched $this) {
            return $this.scala$collection$SeqViewLike$Patched$$plen();
        }

        default public int scala$collection$SeqViewLike$Patched$$plen() {
            return this.patch().length();
        }

        public static /* synthetic */ Iterator iterator$(Patched $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<B> iterator() {
            return this.scala$collection$SeqViewLike$Patched$$$outer().iterator().patch(this.from(), this.patch().iterator(), this.replaced());
        }

        public static /* synthetic */ int length$(Patched $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            int len = this.scala$collection$SeqViewLike$Patched$$$outer().length();
            int pre = package$.MODULE$.min(this.from(), len);
            int post = package$.MODULE$.max(0, len - pre - this.replaced());
            return pre + this.scala$collection$SeqViewLike$Patched$$plen() + post;
        }

        public static /* synthetic */ Object apply$(Patched $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public B apply(int idx) {
            int actualFrom;
            int n = actualFrom = this.scala$collection$SeqViewLike$Patched$$$outer().lengthCompare(this.from()) < 0 ? this.scala$collection$SeqViewLike$Patched$$$outer().length() : this.from();
            if (idx < actualFrom) {
                return (B)this.scala$collection$SeqViewLike$Patched$$$outer().apply(idx);
            }
            if (idx < actualFrom + this.scala$collection$SeqViewLike$Patched$$plen()) {
                return (B)this.patch().apply(idx - actualFrom);
            }
            return (B)this.scala$collection$SeqViewLike$Patched$$$outer().apply(idx - this.scala$collection$SeqViewLike$Patched$$plen() + this.replaced());
        }

        public static /* synthetic */ String viewIdentifier$(Patched $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "P";
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Patched$$$outer();

        public static void $init$(Patched $this) {
        }
    }

    public interface Prepended<B>
    extends IterableViewLike.Prepended<B>,
    Transformed<B> {
        public static /* synthetic */ GenSeq fstSeq$(Prepended $this) {
            return $this.fstSeq();
        }

        default public GenSeq<B> fstSeq() {
            return this.fst().toSeq();
        }

        public static /* synthetic */ int length$(Prepended $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.fstSeq().length() + this.scala$collection$SeqViewLike$Prepended$$$outer().length();
        }

        public static /* synthetic */ Object apply$(Prepended $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public B apply(int idx) {
            if (idx < this.fstSeq().length()) {
                return (B)this.fstSeq().apply(idx);
            }
            return (B)this.scala$collection$SeqViewLike$Prepended$$$outer().apply(idx - this.fstSeq().length());
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Prepended$$$outer();

        public static void $init$(Prepended $this) {
        }
    }

    public interface Reversed
    extends Transformed<A> {
        public static /* synthetic */ Iterator iterator$(Reversed $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<A> iterator() {
            return this.createReversedIterator();
        }

        public static /* synthetic */ int length$(Reversed $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.scala$collection$SeqViewLike$Reversed$$$outer().length();
        }

        public static /* synthetic */ Object apply$(Reversed $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public A apply(int idx) {
            return this.scala$collection$SeqViewLike$Reversed$$$outer().apply(this.length() - 1 - idx);
        }

        public static /* synthetic */ String viewIdentifier$(Reversed $this) {
            return $this.viewIdentifier();
        }

        @Override
        default public String viewIdentifier() {
            return "R";
        }

        private Iterator<A> createReversedIterator() {
            ObjectRef<Nil$> lst = ObjectRef.create(Nil$.MODULE$);
            this.scala$collection$SeqViewLike$Reversed$$$outer().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(A elem) -> {
                lst.elem = ((List)lst.elem).$colon$colon(elem);
                return BoxedUnit.UNIT;
            });
            return ((List)lst.elem).iterator();
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Reversed$$$outer();

        public static void $init$(Reversed $this) {
        }
    }

    public interface Sliced
    extends IterableViewLike.Sliced,
    Transformed<A> {
        public static /* synthetic */ int length$(Sliced $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.iterator().size();
        }

        public static /* synthetic */ Object apply$(Sliced $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public A apply(int idx) {
            if (idx >= 0 && idx + this.from() < this.until()) {
                return this.scala$collection$SeqViewLike$Sliced$$$outer().apply(idx + this.from());
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }

        public static /* synthetic */ void foreach$(Sliced $this, Function1 f) {
            $this.foreach(f);
        }

        @Override
        default public <U> void foreach(Function1<A, U> f) {
            this.iterator().foreach(f);
        }

        public static /* synthetic */ Iterator iterator$(Sliced $this) {
            return $this.iterator();
        }

        @Override
        default public Iterator<A> iterator() {
            return this.scala$collection$SeqViewLike$Sliced$$$outer().iterator().drop(this.from()).take(this.endpoints().width());
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Sliced$$$outer();

        public static void $init$(Sliced $this) {
        }
    }

    public interface TakenWhile
    extends IterableViewLike.TakenWhile,
    Transformed<A> {
        public static /* synthetic */ int len$(TakenWhile $this) {
            return $this.len();
        }

        default public int len() {
            return this.scala$collection$SeqViewLike$TakenWhile$$$outer().prefixLength(this.pred());
        }

        public static /* synthetic */ int length$(TakenWhile $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            return this.len();
        }

        public static /* synthetic */ Object apply$(TakenWhile $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public A apply(int idx) {
            if (idx < this.len()) {
                return this.scala$collection$SeqViewLike$TakenWhile$$$outer().apply(idx);
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$TakenWhile$$$outer();

        public static void $init$(TakenWhile $this) {
        }
    }

    public interface Transformed<B>
    extends SeqView<B, Coll>,
    IterableViewLike.Transformed<B> {
        @Override
        public int length();

        @Override
        public B apply(int var1);

        @Override
        default public String toString() {
            return this.viewToString();
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Transformed$$$outer();

        public static void $init$(Transformed $this) {
        }
    }

    public interface Zipped<B>
    extends IterableViewLike.Zipped<B>,
    Transformed<Tuple2<A, B>> {
        public static /* synthetic */ Seq thatSeq$(Zipped $this) {
            return $this.thatSeq();
        }

        default public Seq<B> thatSeq() {
            return this.other().seq().toSeq();
        }

        public static /* synthetic */ int length$(Zipped $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            if (this.thatSeq().lengthCompare(this.scala$collection$SeqViewLike$Zipped$$$outer().length()) <= 0) {
                return this.thatSeq().length();
            }
            return this.scala$collection$SeqViewLike$Zipped$$$outer().length();
        }

        public static /* synthetic */ Tuple2 apply$(Zipped $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public Tuple2<A, B> apply(int idx) {
            return new Tuple2(this.scala$collection$SeqViewLike$Zipped$$$outer().apply(idx), this.thatSeq().apply(idx));
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$Zipped$$$outer();

        public static void $init$(Zipped $this) {
        }
    }

    public interface ZippedAll<A1, B>
    extends IterableViewLike.ZippedAll<A1, B>,
    Transformed<Tuple2<A1, B>> {
        public static /* synthetic */ Seq thatSeq$(ZippedAll $this) {
            return $this.thatSeq();
        }

        default public Seq<B> thatSeq() {
            return this.other().seq().toSeq();
        }

        public static /* synthetic */ int length$(ZippedAll $this) {
            return $this.length();
        }

        @Override
        default public int length() {
            int n = this.scala$collection$SeqViewLike$ZippedAll$$$outer().length();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.max$extension(n, this.thatSeq().length());
        }

        public static /* synthetic */ Tuple2 apply$(ZippedAll $this, int idx) {
            return $this.apply(idx);
        }

        @Override
        default public Tuple2<A1, B> apply(int idx) {
            return new Tuple2(idx < this.scala$collection$SeqViewLike$ZippedAll$$$outer().length() ? this.scala$collection$SeqViewLike$ZippedAll$$$outer().apply(idx) : this.thisElem(), idx < this.thatSeq().length() ? this.thatSeq().apply(idx) : this.thatElem());
        }

        public /* synthetic */ SeqViewLike scala$collection$SeqViewLike$ZippedAll$$$outer();

        public static void $init$(ZippedAll $this) {
        }
    }
}

