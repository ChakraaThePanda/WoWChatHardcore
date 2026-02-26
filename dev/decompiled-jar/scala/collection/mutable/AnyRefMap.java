/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.util.Arrays;
import java.util.NoSuchElementException;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.BufferedIterator;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.Growable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Vector;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.AnyRefMap$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.collection.mutable.StringBuilder;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u0011%a\u0001B)S\u0005eC\u0001\u0002 \u0001\u0003\u0002\u0003\u0006I! \u0005\u000b\u0003\u0003\u0001!\u0011!Q\u0001\n\u0005\r\u0001BCA\u0005\u0001\t\u0005\t\u0015!\u0003\u0002\f!A\u0011\u0011\u0003\u0001\u0005\u0002Q\u000b\u0019\u0002C\u0004\u0002\u0012\u0001!\t!a\u0007\t\u000f\u0005E\u0001\u0001\"\u0001\u0002\u001e!9\u0011\u0011\u0003\u0001\u0005\u0002\u0005\u0005\u0002bBA\t\u0001\u0011\u0005\u0011Q\u0005\u0005\t\u0003W\u0001\u0001\u0015)\u0003\u0002\u0004!A\u0011Q\u0006\u0001!B\u0013\t\u0019\u0001\u0003\u0005\u00020\u0001\u0001\u000b\u0015BA\u0002\u0011!\t\t\u0004\u0001Q!\n\u0005M\u0002\u0002CA\u001d\u0001\u0001\u0006K!a\u000f\t\u0011\u0005u\u0002\u0001)Q\u0005\u0003wA\u0001\"a\u0010\u0001A\u0013%\u0011\u0011\t\u0005\t\u0003\u001b\u0002A\u0011\u0001+\u0002P!9\u0011\u0011\u000e\u0001\u0005B\u0005-\u0004bBA7\u0001\u0011\u0005\u0013q\u000e\u0005\b\u0003c\u0002A\u0011BA:\u0011\u001d\t)\b\u0001C\u0005\u0003oBq!! \u0001\t\u0013\ty\bC\u0004\u0002\n\u0002!I!a#\t\u000f\u0005E\u0005\u0001\"\u0011\u0002\u0014\"9\u0011q\u0013\u0001\u0005B\u0005e\u0005bBAR\u0001\u0011\u0005\u0013Q\u0015\u0005\b\u0003{\u0003A\u0011IA`\u0011\u001d\tI\r\u0001C\u0001\u0003\u0017Dq!a4\u0001\t\u0003\n\t\u000eC\u0004\u00026\u0002!\t%!6\t\u000f\u0005e\u0007\u0001\"\u0003\u0002\\\"9\u0011\u0011\u001c\u0001\u0005\u0002\u0005\u0005\bbBAr\u0001\u0011\u0005\u0013Q\u001d\u0005\b\u0003[\u0004A\u0011IAx\u0011\u001d\t)\u0010\u0001C\u0001\u0003oDq!!>\u0001\t\u0003\ty\u0010C\u0004\u0003\f\u0001!\tA!\u0004\t\u000f\tE\u0001\u0001\"\u0001\u0003\u0014!9!Q\u0004\u0001\u0005B\t}\u0001b\u0002B\u0018\u0001\u0011\u0005\u00131\u0004\u0005\b\u0005c\u0001A\u0011\tB\u001a\u0011\u001d\u0011\t\u0005\u0001C!\u0005\u0007BqA!\u0017\u0001\t\u0003\u0012Y\u0006\u0003\u0005\u0003j\u0001\u0001K\u0011\u0002B6\u0011\u001d\u0011\u0019\t\u0001C\u0001\u0005\u000bCqA!%\u0001\t\u0003\u0011\u0019\nC\u0004\u0003 \u0002!\tA!)\t\u000f\t=\u0006\u0001\"\u0001\u00032\"9!q\u0017\u0001\u0005B\u0005\u0005xa\u0002Bb%\"\u0005!Q\u0019\u0004\u0007#JC\tAa2\t\u000f\u0005E!\u0007\"\u0001\u0003J\"I!1\u001a\u001aC\u0002\u00135!Q\u001a\u0005\t\u0005'\u0014\u0004\u0015!\u0004\u0003P\"I!Q\u001b\u001aC\u0002\u00135!q\u001b\u0005\t\u0005;\u0014\u0004\u0015!\u0004\u0003Z\"I!q\u001c\u001aC\u0002\u00135!\u0011\u001d\u0005\t\u0005O\u0014\u0004\u0015!\u0004\u0003d\"I!\u0011\u001e\u001aC\u0002\u00135!1\u001e\u0005\t\u0005c\u0014\u0004\u0015!\u0004\u0003n\u001a1!1\u001f\u001a\u0005\u0005kDq!!\u0005=\t\u0003\u0011I\u0010C\u0004\u0002Pr\"\tAa@\t\u0013\r\u0015!G1A\u0005\n\r\u001d\u0001\u0002CB\u0005e\u0001\u0006IAa?\t\u000f\r-!\u0007b\u0001\u0004\u000e!A1Q\u0007\u001a!\u0002\u0013\u00199D\u0002\u0004\u0004JI\u001211\n\u0005\b\u0003#\u0019E\u0011AB1\u0011)\u0011\th\u0011a\u0001\n\u0003!6Q\r\u0005\u000b\u0007O\u001a\u0005\u0019!C\u0001)\u000e%\u0004\u0002CB8\u0007\u0002\u0006Kaa\u0018\t\u000f\u0005U8\t\"\u0001\u0004r!9!qW\"\u0005\u0002\u0005\u0005\bbBB=\u0007\u0012\u000511\u0010\u0005\b\u0003\u001f\u0014D\u0011ABC\u0011\u001d\tiG\rC\u0001\u0007;Cqaa+3\t\u0003\u0019i\u000bC\u0004\u0004@J\"\ta!1\t\u000f\r}&\u0007\"\u0001\u0004\\\"I1Q\u001f\u001a\u0002\u0002\u0013%1q\u001f\u0002\n\u0003:L(+\u001a4NCBT!a\u0015+\u0002\u000f5,H/\u00192mK*\u0011QKV\u0001\u000bG>dG.Z2uS>t'\"A,\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019!,\u00197\u0014\u000b\u0001Y&/^=\u0011\tqkvl[\u0007\u0002%&\u0011aL\u0015\u0002\f\u0003\n\u001cHO]1di6\u000b\u0007\u000f\u0005\u0002aC2\u0001A!\u00022\u0001\u0005\u0004\u0019'!A&\u0012\u0005\u0011D\u0007CA3g\u001b\u00051\u0016BA4W\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!Z5\n\u0005)4&AB!osJ+g\r\u0005\u0002aY\u0012)Q\u000e\u0001b\u0001]\n\ta+\u0005\u0002e_B\u0011Q\r]\u0005\u0003cZ\u00131!\u00118z!\u0011a6oX6\n\u0005Q\u0014&aA'baB)AL^0lq&\u0011qO\u0015\u0002\b\u001b\u0006\u0004H*[6f!\u0011a\u0006aX6\u0011\u0005\u0015T\u0018BA>W\u00051\u0019VM]5bY&T\u0018M\u00197f\u00031!WMZ1vYR,e\u000e\u001e:z!\u0011)gpX6\n\u0005}4&!\u0003$v]\u000e$\u0018n\u001c82\u0003EIg.\u001b;jC2\u0014UO\u001a4feNK'0\u001a\t\u0004K\u0006\u0015\u0011bAA\u0004-\n\u0019\u0011J\u001c;\u0002\u0013%t\u0017\u000e\u001e\"mC:\\\u0007cA3\u0002\u000e%\u0019\u0011q\u0002,\u0003\u000f\t{w\u000e\\3b]\u00061A(\u001b8jiz\"r\u0001_A\u000b\u0003/\tI\u0002C\u0003}\t\u0001\u0007Q\u0010C\u0004\u0002\u0002\u0011\u0001\r!a\u0001\t\u000f\u0005%A\u00011\u0001\u0002\fQ\t\u0001\u0010F\u0002y\u0003?AQ\u0001 \u0004A\u0002u$2\u0001_A\u0012\u0011\u001d\t\ta\u0002a\u0001\u0003\u0007!R\u0001_A\u0014\u0003SAQ\u0001 \u0005A\u0002uDq!!\u0001\t\u0001\u0004\t\u0019!\u0001\u0003nCN\\\u0017!B0tSj,\u0017aB0wC\u000e\fg\u000e^\u0001\b?\"\f7\u000f[3t!\u0015)\u0017QGA\u0002\u0013\r\t9D\u0016\u0002\u0006\u0003J\u0014\u0018-_\u0001\u0006?.,\u0017p\u001d\t\u0005K\u0006U\u0002.A\u0004`m\u0006dW/Z:\u0002#\u0011,g-Y;mi&s\u0017\u000e^5bY&TX\r\u0006\u0003\u0002D\u0005%\u0003cA3\u0002F%\u0019\u0011q\t,\u0003\tUs\u0017\u000e\u001e\u0005\b\u0003\u0017z\u0001\u0019AA\u0002\u0003\u0005q\u0017\u0001D5oSRL\u0017\r\\5{KR{GCDA\"\u0003#\n)&!\u0017\u0002^\u0005\u0005\u0014Q\r\u0005\b\u0003'\u0002\u0002\u0019AA\u0002\u0003\u0005i\u0007bBA,!\u0001\u0007\u00111A\u0001\u0003gjDq!a\u0017\u0011\u0001\u0004\t\u0019!\u0001\u0002wG\"9\u0011q\f\tA\u0002\u0005M\u0012A\u00015{\u0011\u001d\t\u0019\u0007\u0005a\u0001\u0003w\t!a\u001b>\t\u000f\u0005\u001d\u0004\u00031\u0001\u0002<\u0005\u0011aO_\u0001\u0005g&TX-\u0006\u0002\u0002\u0004\u0005)Q-\u001c9usV\t\u00010\u0001\u0006j[\n\fG.\u00198dK\u0012,\"!a\u0003\u0002\r!\f7\u000f[(g)\u0011\t\u0019!!\u001f\t\r\u0005mD\u00031\u0001`\u0003\rYW-_\u0001\ng\u0016,7.\u00128uef$b!a\u0001\u0002\u0002\u0006\u0015\u0005bBAB+\u0001\u0007\u00111A\u0001\u0002Q\"1\u0011qQ\u000bA\u0002!\f\u0011a[\u0001\u0010g\u0016,7.\u00128uef|%o\u00149f]R1\u00111AAG\u0003\u001fCq!a!\u0017\u0001\u0004\t\u0019\u0001\u0003\u0004\u0002\bZ\u0001\r\u0001[\u0001\tG>tG/Y5ogR!\u00111BAK\u0011\u0019\tYh\u0006a\u0001?\u0006\u0019q-\u001a;\u0015\t\u0005m\u0015\u0011\u0015\t\u0005K\u0006u5.C\u0002\u0002 Z\u0013aa\u00149uS>t\u0007BBA>1\u0001\u0007q,A\u0005hKR|%/\u00127tKV!\u0011qUAV)\u0019\tI+!-\u00024B\u0019\u0001-a+\u0005\u000f\u00055\u0016D1\u0001\u00020\n\u0011a+M\t\u0003W>Da!a\u001f\u001a\u0001\u0004y\u0006\u0002CA[3\u0011\u0005\r!a.\u0002\u000f\u0011,g-Y;miB)Q-!/\u0002*&\u0019\u00111\u0018,\u0003\u0011q\u0012\u0017P\\1nKz\nqbZ3u\u001fJ,En]3Va\u0012\fG/\u001a\u000b\u0006W\u0006\u0005\u00171\u0019\u0005\u0007\u0003wR\u0002\u0019A0\t\u0011\u0005\u0015'\u0004\"a\u0001\u0003\u000f\fA\u0002Z3gCVdGOV1mk\u0016\u0004B!ZA]W\u0006Iq-\u001a;Pe:+H\u000e\u001c\u000b\u0004W\u00065\u0007BBA>7\u0001\u0007q,A\u0003baBd\u0017\u0010F\u0002l\u0003'Da!a\u001f\u001d\u0001\u0004yFcA6\u0002X\"1\u00111P\u000fA\u0002}\u000baA]3qC\u000e\\G\u0003BA\"\u0003;Dq!a8\u001f\u0001\u0004\t\u0019!A\u0004oK^l\u0015m]6\u0015\u0005\u0005\r\u0013a\u00019viR1\u00111TAt\u0003SDa!a\u001f!\u0001\u0004y\u0006BBAvA\u0001\u00071.A\u0003wC2,X-\u0001\u0004va\u0012\fG/\u001a\u000b\u0007\u0003\u0007\n\t0a=\t\r\u0005m\u0014\u00051\u0001`\u0011\u0019\tY/\ta\u0001W\u0006AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0004\u0002z\u0006m\u0018Q`\u0007\u0002\u0001!1\u00111\u0010\u0012A\u0002}Ca!a;#\u0001\u0004YG\u0003BA}\u0005\u0003AqAa\u0001$\u0001\u0004\u0011)!\u0001\u0002lmB)QMa\u0002`W&\u0019!\u0011\u0002,\u0003\rQ+\b\u000f\\33\u0003%!S.\u001b8vg\u0012*\u0017\u000f\u0006\u0003\u0002z\n=\u0001BBA>I\u0001\u0007q,\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\u0011)\u0002\u0005\u0004\u0003\u0018\te!QA\u0007\u0002)&\u0019!1\u0004+\u0003\u0011%#XM]1u_J\fqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0003\"\t-B\u0003BA\"\u0005GAqA!\n'\u0001\u0004\u00119#A\u0001g!\u0019)gP!\u0002\u0003*A\u0019\u0001Ma\u000b\u0005\r\t5bE1\u0001o\u0005\u0005)\u0016!B2m_:,\u0017!\u0002\u0013qYV\u001cX\u0003\u0002B\u001b\u0005w!BAa\u000e\u0003>A)A\fA0\u0003:A\u0019\u0001Ma\u000f\u0005\u000f\u00055\u0006F1\u0001\u00020\"9!1\u0001\u0015A\u0002\t}\u0002CB3\u0003\b}\u0013I$\u0001\u0006%a2,8\u000f\n9mkN,BA!\u0012\u0003LQ!!q\tB'!\u0015a\u0006a\u0018B%!\r\u0001'1\n\u0003\b\u0003[K#\u0019AAX\u0011\u001d\u0011y%\u000ba\u0001\u0005#\n!\u0001_:\u0011\r\t]!1\u000bB,\u0013\r\u0011)\u0006\u0016\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW\r\u0005\u0004f\u0005\u000fy&\u0011J\u0001\bkB$\u0017\r^3e+\u0011\u0011iFa\u0019\u0015\r\t}#Q\rB4!\u0015a\u0006a\u0018B1!\r\u0001'1\r\u0003\b\u0003[S#\u0019AAX\u0011\u0019\tYH\u000ba\u0001?\"9\u00111\u001e\u0016A\u0002\t\u0005\u0014A\u00044pe\u0016\f7\r[#mK6,g\u000e^\u000b\u0007\u0005[\u0012IHa \u0015\r\u0005\r#q\u000eB:\u0011\u001d\u0011\th\u000ba\u0001\u0003w\tQ!\u001a7f[NDqA!\n,\u0001\u0004\u0011)\b\u0005\u0004f}\n]$Q\u0010\t\u0004A\neDA\u0002B>W\t\u0007aNA\u0001B!\r\u0001'q\u0010\u0003\u0007\u0005\u0003[#\u0019\u00018\u0003\u0003\t\u000b!BZ8sK\u0006\u001c\u0007nS3z+\u0011\u00119Ia$\u0015\t\u0005\r#\u0011\u0012\u0005\b\u0005Ka\u0003\u0019\u0001BF!\u0015)gp\u0018BG!\r\u0001'q\u0012\u0003\u0007\u0005wb#\u0019\u00018\u0002\u0019\u0019|'/Z1dQZ\u000bG.^3\u0016\t\tU%Q\u0014\u000b\u0005\u0003\u0007\u00129\nC\u0004\u0003&5\u0002\rA!'\u0011\u000b\u0015t8Na'\u0011\u0007\u0001\u0014i\n\u0002\u0004\u0003|5\u0012\rA\\\u0001\r[\u0006\u0004h+\u00197vKNtun^\u000b\u0005\u0005G\u0013I\u000b\u0006\u0003\u0003&\n-\u0006#\u0002/\u0001?\n\u001d\u0006c\u00011\u0003*\u00121\u0011Q\u0016\u0018C\u00029DqA!\n/\u0001\u0004\u0011i\u000bE\u0003f}.\u00149+A\bue\u0006t7OZ8s[Z\u000bG.^3t)\u0011\tIPa-\t\u000f\t\u0015r\u00061\u0001\u00036B!QM`6l\u0003\u0015\u0019G.Z1sQ\u001d\u0001!1XAv\u0005\u0003\u00042!\u001aB_\u0013\r\u0011yL\u0016\u0002\u0011'\u0016\u0014\u0018.\u00197WKJ\u001c\u0018n\u001c8V\u0013\u0012s\u0012!A\u0001\n\u0003:L(+\u001a4NCB\u0004\"\u0001\u0018\u001a\u0014\u0007IB\u0017\u0010\u0006\u0002\u0003F\u0006I\u0011J\u001c3fq6\u000b7o[\u000b\u0003\u0005\u001f|!A!5\u001e\t}z\u0000\u0000\u0000\u0001\u000b\u0013:$W\r_'bg.\u0004\u0013AC'jgNLgn\u001a\"jiV\u0011!\u0011\\\b\u0003\u00057lB\u0001!\u0001\u0001\u0001\u0005YQ*[:tS:<')\u001b;!\u0003%1\u0016mY1oi\nKG/\u0006\u0002\u0003d>\u0011!Q]\u000f\u0005\u0001\u0002\u0001\u0001!\u0001\u0006WC\u000e\fg\u000e\u001e\"ji\u0002\n!\"T5tgZ\u000b7-\u00198u+\t\u0011io\u0004\u0002\u0003pv!\u0001\u0019\u0001\u0001\u0001\u0003-i\u0015n]:WC\u000e\fg\u000e\u001e\u0011\u0003!\u0015C8-\u001a9uS>tG)\u001a4bk2$8#\u0002\u001fi\u0005oL\b\u0003B3\u007f_\u0012$\"Aa?\u0011\u0007\tuH(D\u00013)\r!7\u0011\u0001\u0005\u0007\u0003\u000fs\u0004\u0019A8)\u000fq\u0012Y,a;\u0003B\u0006\u0001R\r_2faRLwN\u001c#fM\u0006,H\u000e^\u000b\u0003\u0005w\f\u0011#\u001a=dKB$\u0018n\u001c8EK\u001a\fW\u000f\u001c;!\u00031\u0019\u0017M\u001c\"vS2$gI]8n+)\u0019ya!\t\u0004&\r-2\u0011G\u000b\u0003\u0007#\u0001\"ba\u0005\u0004\u001a\ru1qEB\u001a\u001b\t\u0019)BC\u0002\u0004\u0018Q\u000bqaZ3oKJL7-\u0003\u0003\u0004\u001c\rU!\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007C\u0002/\u0001\u0007?\u0019\u0019\u0003E\u0002a\u0007C!QAY!C\u0002\r\u00042\u0001YB\u0013\t\u0015i\u0017I1\u0001o!\u001d)'qAB\u0015\u0007_\u00012\u0001YB\u0016\t\u0019\u0019i#\u0011b\u0001G\n\t!\nE\u0002a\u0007c!aA!\fB\u0005\u0004q\u0007C\u0002/\u0001\u0007S\u0019y#A\nSKV\u001c\u0018M\u00197f\u0007\n3\u0015J\\:uC:\u001cWME\u0003\u0004:!\u001ciD\u0002\u0004\u0004<\t\u00031q\u0007\u0002\ryI,g-\u001b8f[\u0016tGO\u0010\t\u000b\u0007'\u0019Iba\u0010\u0004B\r}\u0002\u0003\u0002/\u0001Q>\u0004R!\u001aB\u0004Q>D\u0001\"a4\u0004:\u0011\u00051Q\t\u000b\u0005\u0007\u000f\u001ai\bE\u0003\u0003~\u000eCwN\u0001\tB]f\u0014VMZ'ba\n+\u0018\u000e\u001c3feV11QJB-\u0007;\u001aBa\u00115\u0004PA9Al!\u0015\u0004V\r}\u0013bAB*%\ny!+Z;tC\ndWMQ;jY\u0012,'\u000fE\u0004f\u0005\u000f\u00199fa\u0017\u0011\u0007\u0001\u001cI\u0006B\u0003c\u0007\n\u00071\rE\u0002a\u0007;\"Q!\\\"C\u00029\u0004b\u0001\u0018\u0001\u0004X\rmCCAB2!\u001d\u0011ipQB,\u00077*\"aa\u0018\u0002\u0013\u0015dW-\\:`I\u0015\fH\u0003BA\"\u0007WB\u0011b!\u001cG\u0003\u0003\u0005\raa\u0018\u0002\u0007a$\u0013'\u0001\u0004fY\u0016l7\u000f\t\u000b\u0005\u0007g\u001a)(D\u0001D\u0011\u001d\u00199\b\u0013a\u0001\u0007+\nQ!\u001a8uef\faA]3tk2$HCAB0\u0011!\u0019yha\u0011A\u0002\r}\u0012\u0001\u00024s_6D\u0001\"a4\u0004:\u0011\u000511\u0011\u000b\u0003\u0007\u000f*baa\"\u0004\u000e\u000eEE\u0003BBE\u0007'\u0003b\u0001\u0018\u0001\u0004\f\u000e=\u0005c\u00011\u0004\u000e\u0012)!m\u0013b\u0001GB\u0019\u0001m!%\u0005\u000b5\\%\u0019\u00018\t\u000f\tE4\n1\u0001\u0004\u0016B)Qma&\u0004\u001c&\u00191\u0011\u0014,\u0003\u0015q\u0012X\r]3bi\u0016$g\bE\u0004f\u0005\u000f\u0019Yia$\u0016\r\r}5QUBU+\t\u0019\t\u000b\u0005\u0004]\u0001\r\r6q\u0015\t\u0004A\u000e\u0015F!\u00022M\u0005\u0004\u0019\u0007c\u00011\u0004*\u0012)Q\u000e\u0014b\u0001]\u0006Yq/\u001b;i\t\u00164\u0017-\u001e7u+\u0019\u0019yk!.\u0004:R!1\u0011WB^!\u0019a\u0006aa-\u00048B\u0019\u0001m!.\u0005\u000b\tl%\u0019A2\u0011\u0007\u0001\u001cI\fB\u0003n\u001b\n\u0007a\u000eC\u0004\u000266\u0003\ra!0\u0011\r\u0015t81WB\\\u0003\u001d1'o\\7[SB,baa1\u0004J\u000e5GCBBc\u0007\u001f\u001c)\u000e\u0005\u0004]\u0001\r\u001d71\u001a\t\u0004A\u000e%G!\u00022O\u0005\u0004\u0019\u0007c\u00011\u0004N\u0012)QN\u0014b\u0001]\"91\u0011\u001b(A\u0002\rM\u0017\u0001B6fsN\u0004R!ZA\u001b\u0007\u000fDqaa6O\u0001\u0004\u0019I.\u0001\u0004wC2,Xm\u001d\t\u0006K\u0006U21Z\u000b\u0007\u0007;\u001c\u0019oa:\u0015\r\r}7\u0011^By!\u0019a\u0006a!9\u0004fB\u0019\u0001ma9\u0005\u000b\t|%\u0019A2\u0011\u0007\u0001\u001c9\u000fB\u0003n\u001f\n\u0007a\u000eC\u0004\u0004R>\u0003\raa;\u0011\u000bq\u001bio!9\n\u0007\r=(K\u0001\u0005Ji\u0016\u0014\u0018M\u00197f\u0011\u001d\u00199n\u0014a\u0001\u0007g\u0004R\u0001XBw\u0007K\f1B]3bIJ+7o\u001c7wKR\u00111\u0011 \t\u0005\u0007w$)!\u0004\u0002\u0004~*!1q C\u0001\u0003\u0011a\u0017M\\4\u000b\u0005\u0011\r\u0011\u0001\u00026bm\u0006LA\u0001b\u0002\u0004~\n1qJ\u00196fGR\u0004")
public final class AnyRefMap<K, V>
extends AbstractMap<K, V>
implements Serializable {
    public static final long serialVersionUID = 1L;
    private final Function1<K, V> defaultEntry;
    private int mask;
    private int _size;
    private int _vacant;
    public int[] scala$collection$mutable$AnyRefMap$$_hashes;
    public Object[] scala$collection$mutable$AnyRefMap$$_keys;
    public Object[] scala$collection$mutable$AnyRefMap$$_values;

    public static <K, V> AnyRefMap<K, V> fromZip(scala.collection.mutable.Iterable<K> iterable, scala.collection.mutable.Iterable<V> iterable2) {
        return AnyRefMap$.MODULE$.fromZip(iterable, iterable2);
    }

    public static <K, V> AnyRefMap<K, V> fromZip(K[] KArray, Object object) {
        return AnyRefMap$.MODULE$.fromZip(KArray, object);
    }

    public static <K, V, J, U> CanBuildFrom<AnyRefMap<K, V>, Tuple2<J, U>, AnyRefMap<J, U>> canBuildFrom() {
        return AnyRefMap$.MODULE$.canBuildFrom();
    }

    private void defaultInitialize(int n) {
        this.mask = n < 0 ? 7 : (1 << 32 - Integer.numberOfLeadingZeros(n - 1)) - 1 & 0x3FFFFFFF | 7;
        this.scala$collection$mutable$AnyRefMap$$_hashes = new int[this.mask + 1];
        this.scala$collection$mutable$AnyRefMap$$_keys = new Object[this.mask + 1];
        this.scala$collection$mutable$AnyRefMap$$_values = new Object[this.mask + 1];
    }

    public void initializeTo(int m, int sz, int vc, int[] hz, Object[] kz, Object[] vz) {
        this.mask = m;
        this._size = sz;
        this._vacant = vc;
        this.scala$collection$mutable$AnyRefMap$$_hashes = hz;
        this.scala$collection$mutable$AnyRefMap$$_keys = kz;
        this.scala$collection$mutable$AnyRefMap$$_values = vz;
    }

    @Override
    public int size() {
        return this._size;
    }

    @Override
    public AnyRefMap<K, V> empty() {
        return new AnyRefMap<K, V>(this.defaultEntry);
    }

    private boolean imbalanced() {
        return (double)(this._size + this._vacant) > 0.5 * (double)this.mask || this._vacant > this._size;
    }

    private int hashOf(K key) {
        if (key == null) {
            return 1091049865;
        }
        int h = key.hashCode();
        int i = (h ^ h >>> 16) * -2048144789;
        int j = (i ^ i >>> 13) & Integer.MAX_VALUE;
        if (j == 0) {
            return 1091049865;
        }
        return j;
    }

    private int seekEntry(int h, Object k) {
        int g;
        int e = h & this.mask;
        int x = 0;
        int[] hashes = this.scala$collection$mutable$AnyRefMap$$_hashes;
        Object[] keys2 = this.scala$collection$mutable$AnyRefMap$$_keys;
        while ((g = hashes[e]) != 0) {
            Object q;
            if (g == h && ((q = keys2[e]) == k || q != null && q.equals(k))) {
                return e;
            }
            e = e + 2 * (++x + 1) * x - 3 & this.mask;
        }
        return e | Integer.MIN_VALUE;
    }

    private int seekEntryOrOpen(int h, Object k) {
        int g;
        int e = h & this.mask;
        int x = 0;
        int o = -1;
        while ((g = this.scala$collection$mutable$AnyRefMap$$_hashes[e]) != 0) {
            Object q;
            if (g == h && ((q = this.scala$collection$mutable$AnyRefMap$$_keys[e]) == k || q != null && q.equals(k))) {
                return e;
            }
            if (o == -1 && g + g == 0) {
                o = e;
            }
            e = e + 2 * (++x + 1) * x - 3 & this.mask;
        }
        if (o >= 0) {
            return o | 0xC0000000;
        }
        return e | Integer.MIN_VALUE;
    }

    @Override
    public boolean contains(K key) {
        return this.seekEntry(this.hashOf(key), key) >= 0;
    }

    @Override
    public Option<V> get(K key) {
        int i = this.seekEntry(this.hashOf(key), key);
        if (i < 0) {
            return None$.MODULE$;
        }
        return new Some<Object>(this.scala$collection$mutable$AnyRefMap$$_values[i]);
    }

    @Override
    public <V1> V1 getOrElse(K key, Function0<V1> function0) {
        int i = this.seekEntry(this.hashOf(key), key);
        if (i < 0) {
            return function0.apply();
        }
        return (V1)this.scala$collection$mutable$AnyRefMap$$_values[i];
    }

    @Override
    public V getOrElseUpdate(K key, Function0<V> defaultValue) {
        int h = this.hashOf(key);
        int i = this.seekEntryOrOpen(h, key);
        if (i < 0) {
            int[] oh = this.scala$collection$mutable$AnyRefMap$$_hashes;
            V v = defaultValue.apply();
            if (oh != this.scala$collection$mutable$AnyRefMap$$_hashes && (i = this.seekEntryOrOpen(h, key)) >= 0) {
                --this._size;
            }
            ++this._size;
            int j = i & 0x3FFFFFFF;
            this.scala$collection$mutable$AnyRefMap$$_hashes[j] = h;
            this.scala$collection$mutable$AnyRefMap$$_keys[j] = key;
            this.scala$collection$mutable$AnyRefMap$$_values[j] = v;
            if ((i & 0x40000000) != 0) {
                --this._vacant;
            } else if (this.imbalanced()) {
                this.repack();
            }
            return v;
        }
        return (V)this.scala$collection$mutable$AnyRefMap$$_values[i];
    }

    public V getOrNull(K key) {
        int i = this.seekEntry(this.hashOf(key), key);
        if (i < 0) {
            return null;
        }
        return (V)this.scala$collection$mutable$AnyRefMap$$_values[i];
    }

    @Override
    public V apply(K key) {
        int i = this.seekEntry(this.hashOf(key), key);
        if (i < 0) {
            return this.defaultEntry.apply(key);
        }
        return (V)this.scala$collection$mutable$AnyRefMap$$_values[i];
    }

    @Override
    public V default(K key) {
        return this.defaultEntry.apply(key);
    }

    private void repack(int newMask) {
        int[] oh = this.scala$collection$mutable$AnyRefMap$$_hashes;
        Object[] ok = this.scala$collection$mutable$AnyRefMap$$_keys;
        Object[] ov = this.scala$collection$mutable$AnyRefMap$$_values;
        this.mask = newMask;
        this.scala$collection$mutable$AnyRefMap$$_hashes = new int[this.mask + 1];
        this.scala$collection$mutable$AnyRefMap$$_keys = new Object[this.mask + 1];
        this.scala$collection$mutable$AnyRefMap$$_values = new Object[this.mask + 1];
        this._vacant = 0;
        for (int i = 0; i < oh.length; ++i) {
            int h = oh[i];
            if (h + h == 0) continue;
            int e = h & this.mask;
            int x = 0;
            while (this.scala$collection$mutable$AnyRefMap$$_hashes[e] != 0) {
                e = e + 2 * (++x + 1) * x - 3 & this.mask;
            }
            this.scala$collection$mutable$AnyRefMap$$_hashes[e] = h;
            this.scala$collection$mutable$AnyRefMap$$_keys[e] = ok[i];
            this.scala$collection$mutable$AnyRefMap$$_values[e] = ov[i];
        }
    }

    public void repack() {
        int m = this.mask;
        if ((double)(this._size + this._vacant) >= 0.5 * (double)this.mask && !((double)this._vacant > 0.2 * (double)this.mask)) {
            m = (m << 1) + 1 & 0x3FFFFFFF;
        }
        while (m > 8 && 8 * this._size < m) {
            m >>>= 1;
        }
        this.repack(m);
    }

    @Override
    public Option<V> put(K key, V value) {
        int h = this.hashOf(key);
        int i = this.seekEntryOrOpen(h, key);
        if (i < 0) {
            int j = i & 0x3FFFFFFF;
            this.scala$collection$mutable$AnyRefMap$$_hashes[j] = h;
            this.scala$collection$mutable$AnyRefMap$$_keys[j] = key;
            this.scala$collection$mutable$AnyRefMap$$_values[j] = value;
            ++this._size;
            if ((i & 0x40000000) != 0) {
                --this._vacant;
            } else if (this.imbalanced()) {
                this.repack();
            }
            return None$.MODULE$;
        }
        Some<Object> ans = new Some<Object>(this.scala$collection$mutable$AnyRefMap$$_values[i]);
        this.scala$collection$mutable$AnyRefMap$$_hashes[i] = h;
        this.scala$collection$mutable$AnyRefMap$$_keys[i] = key;
        this.scala$collection$mutable$AnyRefMap$$_values[i] = value;
        return ans;
    }

    @Override
    public void update(K key, V value) {
        int h = this.hashOf(key);
        int i = this.seekEntryOrOpen(h, key);
        if (i < 0) {
            int j = i & 0x3FFFFFFF;
            this.scala$collection$mutable$AnyRefMap$$_hashes[j] = h;
            this.scala$collection$mutable$AnyRefMap$$_keys[j] = key;
            this.scala$collection$mutable$AnyRefMap$$_values[j] = value;
            ++this._size;
            if ((i & 0x40000000) != 0) {
                --this._vacant;
                return;
            }
            if (this.imbalanced()) {
                this.repack();
                return;
            }
        } else {
            this.scala$collection$mutable$AnyRefMap$$_hashes[i] = h;
            this.scala$collection$mutable$AnyRefMap$$_keys[i] = key;
            this.scala$collection$mutable$AnyRefMap$$_values[i] = value;
        }
    }

    public AnyRefMap<K, V> $plus$eq(K key, V value) {
        this.update(key, value);
        return this;
    }

    @Override
    public AnyRefMap<K, V> $plus$eq(Tuple2<K, V> kv) {
        this.update(kv._1(), kv._2());
        return this;
    }

    public AnyRefMap<K, V> $minus$eq(K key) {
        int i = this.seekEntry(this.hashOf(key), key);
        if (i >= 0) {
            --this._size;
            ++this._vacant;
            this.scala$collection$mutable$AnyRefMap$$_hashes[i] = Integer.MIN_VALUE;
            this.scala$collection$mutable$AnyRefMap$$_keys[i] = null;
            this.scala$collection$mutable$AnyRefMap$$_values[i] = null;
        }
        return this;
    }

    @Override
    public Iterator<Tuple2<K, V>> iterator() {
        return new Iterator<Tuple2<K, V>>(this){
            private final int[] hz;
            private final Object[] kz;
            private final Object[] vz;
            private int index;

            public Iterator<Tuple2<K, V>> seq() {
                return Iterator.seq$(this);
            }

            public boolean isEmpty() {
                return Iterator.isEmpty$(this);
            }

            public boolean isTraversableAgain() {
                return Iterator.isTraversableAgain$(this);
            }

            public boolean hasDefiniteSize() {
                return Iterator.hasDefiniteSize$(this);
            }

            public Iterator<Tuple2<K, V>> take(int n) {
                return Iterator.take$(this, n);
            }

            public Iterator<Tuple2<K, V>> drop(int n) {
                return Iterator.drop$(this, n);
            }

            public Iterator<Tuple2<K, V>> slice(int from, int until) {
                return Iterator.slice$(this, from, until);
            }

            public Iterator<Tuple2<K, V>> sliceIterator(int from, int until) {
                return Iterator.sliceIterator$(this, from, until);
            }

            public <B> Iterator<B> map(Function1<Tuple2<K, V>, B> f) {
                return Iterator.map$(this, f);
            }

            public <B> Iterator<B> $plus$plus(Function0<GenTraversableOnce<B>> that) {
                return Iterator.$plus$plus$(this, that);
            }

            public <B> Iterator<B> flatMap(Function1<Tuple2<K, V>, GenTraversableOnce<B>> f) {
                return Iterator.flatMap$(this, f);
            }

            public Iterator<Tuple2<K, V>> filter(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.filter$(this, p);
            }

            public <B> boolean corresponds(GenTraversableOnce<B> that, Function2<Tuple2<K, V>, B, Object> p) {
                return Iterator.corresponds$(this, that, p);
            }

            public Iterator<Tuple2<K, V>> withFilter(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.withFilter$(this, p);
            }

            public Iterator<Tuple2<K, V>> filterNot(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.filterNot$(this, p);
            }

            public <B> Iterator<B> collect(PartialFunction<Tuple2<K, V>, B> pf) {
                return Iterator.collect$(this, pf);
            }

            public <B> Iterator<B> scanLeft(B z, Function2<B, Tuple2<K, V>, B> op) {
                return Iterator.scanLeft$(this, z, op);
            }

            public <B> Iterator<B> scanRight(B z, Function2<Tuple2<K, V>, B, B> op) {
                return Iterator.scanRight$(this, z, op);
            }

            public Iterator<Tuple2<K, V>> takeWhile(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.takeWhile$(this, p);
            }

            public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> partition(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.partition$(this, p);
            }

            public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> span(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.span$(this, p);
            }

            public Iterator<Tuple2<K, V>> dropWhile(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.dropWhile$(this, p);
            }

            public <B> Iterator<Tuple2<Tuple2<K, V>, B>> zip(Iterator<B> that) {
                return Iterator.zip$(this, that);
            }

            public <A1> Iterator<A1> padTo(int len, A1 elem) {
                return Iterator.padTo$(this, len, elem);
            }

            public Iterator<Tuple2<Tuple2<K, V>, Object>> zipWithIndex() {
                return Iterator.zipWithIndex$(this);
            }

            public <B, A1, B1> Iterator<Tuple2<A1, B1>> zipAll(Iterator<B> that, A1 thisElem, B1 thatElem) {
                return Iterator.zipAll$(this, that, thisElem, thatElem);
            }

            public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
                Iterator.foreach$(this, f);
            }

            public boolean forall(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.forall$(this, p);
            }

            public boolean exists(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.exists$(this, p);
            }

            public boolean contains(Object elem) {
                return Iterator.contains$(this, elem);
            }

            public Option<Tuple2<K, V>> find(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.find$(this, p);
            }

            public int indexWhere(Function1<Tuple2<K, V>, Object> p) {
                return Iterator.indexWhere$(this, p);
            }

            public int indexWhere(Function1<Tuple2<K, V>, Object> p, int from) {
                return Iterator.indexWhere$(this, p, from);
            }

            public <B> int indexOf(B elem) {
                return Iterator.indexOf$(this, elem);
            }

            public <B> int indexOf(B elem, int from) {
                return Iterator.indexOf$(this, elem, from);
            }

            public BufferedIterator<Tuple2<K, V>> buffered() {
                return Iterator.buffered$(this);
            }

            public <B> Iterator.GroupedIterator<B> grouped(int size) {
                return Iterator.grouped$(this, size);
            }

            public <B> Iterator.GroupedIterator<B> sliding(int size, int step) {
                return Iterator.sliding$(this, size, step);
            }

            public <B> int sliding$default$2() {
                return Iterator.sliding$default$2$(this);
            }

            public int length() {
                return Iterator.length$(this);
            }

            public Tuple2<Iterator<Tuple2<K, V>>, Iterator<Tuple2<K, V>>> duplicate() {
                return Iterator.duplicate$(this);
            }

            public <B> Iterator<B> patch(int from, Iterator<B> patchElems, int replaced) {
                return Iterator.patch$(this, from, patchElems, replaced);
            }

            public <B> void copyToArray(Object xs, int start, int len) {
                Iterator.copyToArray$(this, xs, start, len);
            }

            public boolean sameElements(Iterator<?> that) {
                return Iterator.sameElements$(this, that);
            }

            public Traversable<Tuple2<K, V>> toTraversable() {
                return Iterator.toTraversable$(this);
            }

            public Iterator<Tuple2<K, V>> toIterator() {
                return Iterator.toIterator$(this);
            }

            public Stream<Tuple2<K, V>> toStream() {
                return Iterator.toStream$(this);
            }

            public String toString() {
                return Iterator.toString$(this);
            }

            public List<Tuple2<K, V>> reversed() {
                return TraversableOnce.reversed$(this);
            }

            public int size() {
                return TraversableOnce.size$(this);
            }

            public boolean nonEmpty() {
                return TraversableOnce.nonEmpty$(this);
            }

            public int count(Function1<Tuple2<K, V>, Object> p) {
                return TraversableOnce.count$(this, p);
            }

            public <B> Option<B> collectFirst(PartialFunction<Tuple2<K, V>, B> pf) {
                return TraversableOnce.collectFirst$(this, pf);
            }

            public <B> B $div$colon(B z, Function2<B, Tuple2<K, V>, B> op) {
                return (B)TraversableOnce.$div$colon$(this, z, op);
            }

            public <B> B $colon$bslash(B z, Function2<Tuple2<K, V>, B, B> op) {
                return (B)TraversableOnce.$colon$bslash$(this, z, op);
            }

            public <B> B foldLeft(B z, Function2<B, Tuple2<K, V>, B> op) {
                return (B)TraversableOnce.foldLeft$(this, z, op);
            }

            public <B> B foldRight(B z, Function2<Tuple2<K, V>, B, B> op) {
                return (B)TraversableOnce.foldRight$(this, z, op);
            }

            public <B> B reduceLeft(Function2<B, Tuple2<K, V>, B> op) {
                return (B)TraversableOnce.reduceLeft$(this, op);
            }

            public <B> B reduceRight(Function2<Tuple2<K, V>, B, B> op) {
                return (B)TraversableOnce.reduceRight$(this, op);
            }

            public <B> Option<B> reduceLeftOption(Function2<B, Tuple2<K, V>, B> op) {
                return TraversableOnce.reduceLeftOption$(this, op);
            }

            public <B> Option<B> reduceRightOption(Function2<Tuple2<K, V>, B, B> op) {
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

            public <B> B aggregate(Function0<B> z, Function2<B, Tuple2<K, V>, B> seqop, Function2<B, B, B> combop) {
                return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
            }

            public <B> B sum(Numeric<B> num) {
                return (B)TraversableOnce.sum$(this, num);
            }

            public <B> B product(Numeric<B> num) {
                return (B)TraversableOnce.product$(this, num);
            }

            public Object min(Ordering cmp) {
                return TraversableOnce.min$(this, cmp);
            }

            public Object max(Ordering cmp) {
                return TraversableOnce.max$(this, cmp);
            }

            public Object maxBy(Function1 f, Ordering cmp) {
                return TraversableOnce.maxBy$(this, f, cmp);
            }

            public Object minBy(Function1 f, Ordering cmp) {
                return TraversableOnce.minBy$(this, f, cmp);
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

            public List<Tuple2<K, V>> toList() {
                return TraversableOnce.toList$(this);
            }

            public Iterable<Tuple2<K, V>> toIterable() {
                return TraversableOnce.toIterable$(this);
            }

            public Seq<Tuple2<K, V>> toSeq() {
                return TraversableOnce.toSeq$(this);
            }

            public IndexedSeq<Tuple2<K, V>> toIndexedSeq() {
                return TraversableOnce.toIndexedSeq$(this);
            }

            public <B> Buffer<B> toBuffer() {
                return TraversableOnce.toBuffer$(this);
            }

            public <B> Set<B> toSet() {
                return TraversableOnce.toSet$(this);
            }

            public Vector<Tuple2<K, V>> toVector() {
                return TraversableOnce.toVector$(this);
            }

            public <Col> Col to(CanBuildFrom<Nothing$, Tuple2<K, V>, Col> cbf) {
                return (Col)TraversableOnce.to$(this, cbf);
            }

            public <T, U> Map<T, U> toMap(Predef$.less.colon.less<Tuple2<K, V>, Tuple2<T, U>> ev) {
                return TraversableOnce.toMap$(this, ev);
            }

            public String mkString(String start, String sep, String end) {
                return TraversableOnce.mkString$(this, start, sep, end);
            }

            public String mkString(String sep) {
                return TraversableOnce.mkString$(this, sep);
            }

            public String mkString() {
                return TraversableOnce.mkString$(this);
            }

            public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
                return TraversableOnce.addString$(this, b, start, sep, end);
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

            public boolean hasNext() {
                if (this.index < this.hz.length) {
                    int h = this.hz[this.index];
                    while (h + h == 0) {
                        ++this.index;
                        if (this.index >= this.hz.length) {
                            return false;
                        }
                        h = this.hz[this.index];
                    }
                    return true;
                }
                return false;
            }

            /*
             * WARNING - void declaration
             */
            public Tuple2<K, V> next() {
                if (this.hasNext()) {
                    void var1_1;
                    Tuple2<Object, Object> ans = new Tuple2<Object, Object>(this.kz[this.index], this.vz[this.index]);
                    ++this.index;
                    return var1_1;
                }
                throw new NoSuchElementException("next");
            }
            {
                GenTraversableOnce.$init$(this);
                TraversableOnce.$init$(this);
                Iterator.$init$(this);
                this.hz = $outer.scala$collection$mutable$AnyRefMap$$_hashes;
                this.kz = $outer.scala$collection$mutable$AnyRefMap$$_keys;
                this.vz = $outer.scala$collection$mutable$AnyRefMap$$_values;
                this.index = 0;
            }
        };
    }

    @Override
    public <U> void foreach(Function1<Tuple2<K, V>, U> f) {
        int i = 0;
        for (int e = this._size; e > 0; --e) {
            int h;
            while (i < this.scala$collection$mutable$AnyRefMap$$_hashes.length && (h = this.scala$collection$mutable$AnyRefMap$$_hashes[i]) + h == 0 && i < this.scala$collection$mutable$AnyRefMap$$_hashes.length) {
                ++i;
            }
            if (i < this.scala$collection$mutable$AnyRefMap$$_hashes.length) {
                f.apply(new Tuple2<Object, Object>(this.scala$collection$mutable$AnyRefMap$$_keys[i], this.scala$collection$mutable$AnyRefMap$$_values[i]));
                ++i;
                continue;
            }
            return;
        }
    }

    @Override
    public AnyRefMap<K, V> clone() {
        int[] hz = Arrays.copyOf(this.scala$collection$mutable$AnyRefMap$$_hashes, this.scala$collection$mutable$AnyRefMap$$_hashes.length);
        Object[] kz = Arrays.copyOf(this.scala$collection$mutable$AnyRefMap$$_keys, this.scala$collection$mutable$AnyRefMap$$_keys.length);
        Object[] vz = Arrays.copyOf(this.scala$collection$mutable$AnyRefMap$$_values, this.scala$collection$mutable$AnyRefMap$$_values.length);
        AnyRefMap<K, V> arm = new AnyRefMap<K, V>(this.defaultEntry, 1, false);
        arm.initializeTo(this.mask, this._size, this._vacant, hz, kz, vz);
        return arm;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <V1> AnyRefMap<K, V1> $plus(Tuple2<K, V1> kv) {
        void var2_2;
        Object arm = this.clone();
        ((AnyRefMap)arm).$plus$eq(kv);
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <V1> AnyRefMap<K, V1> $plus$plus(GenTraversableOnce<Tuple2<K, V1>> xs) {
        void var2_2;
        Object arm = this.clone();
        xs.foreach(arg_0 -> AnyRefMap.$anonfun$$plus$plus$1((AnyRefMap)arm, arg_0));
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <V1> AnyRefMap<K, V1> updated(K key, V1 value) {
        void var3_3;
        Object arm = this.clone();
        ((AnyRefMap)arm).$plus$eq(key, value);
        return var3_3;
    }

    private <A, B> void foreachElement(Object[] elems, Function1<A, B> f) {
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$AnyRefMap$$_hashes.length & j < this._size) {
            int h = this.scala$collection$mutable$AnyRefMap$$_hashes[i];
            if (h + h != 0) {
                ++j;
                f.apply(elems[i]);
            }
            ++i;
        }
    }

    public <A> void foreachKey(Function1<K, A> f) {
        this.foreachElement(this.scala$collection$mutable$AnyRefMap$$_keys, f);
    }

    public <A> void foreachValue(Function1<V, A> f) {
        this.foreachElement(this.scala$collection$mutable$AnyRefMap$$_values, f);
    }

    /*
     * WARNING - void declaration
     */
    public <V1> AnyRefMap<K, V1> mapValuesNow(Function1<V, V1> f) {
        void var2_2;
        AnyRefMap<Object, Nothing$> arm = new AnyRefMap<Object, Nothing$>(AnyRefMap$.MODULE$.scala$collection$mutable$AnyRefMap$$exceptionDefault(), 1, false);
        int[] hz = Arrays.copyOf(this.scala$collection$mutable$AnyRefMap$$_hashes, this.scala$collection$mutable$AnyRefMap$$_hashes.length);
        Object[] kz = Arrays.copyOf(this.scala$collection$mutable$AnyRefMap$$_keys, this.scala$collection$mutable$AnyRefMap$$_keys.length);
        Object[] vz = new Object[this.scala$collection$mutable$AnyRefMap$$_values.length];
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$AnyRefMap$$_hashes.length & j < this._size) {
            int h = this.scala$collection$mutable$AnyRefMap$$_hashes[i];
            if (h + h != 0) {
                ++j;
                vz[i] = f.apply(this.scala$collection$mutable$AnyRefMap$$_values[i]);
            }
            ++i;
        }
        arm.initializeTo(this.mask, this._size, this._vacant, hz, kz, vz);
        return var2_2;
    }

    public AnyRefMap<K, V> transformValues(Function1<V, V> f) {
        int i = 0;
        int j = 0;
        while (i < this.scala$collection$mutable$AnyRefMap$$_hashes.length & j < this._size) {
            int h = this.scala$collection$mutable$AnyRefMap$$_hashes[i];
            if (h + h != 0) {
                ++j;
                this.scala$collection$mutable$AnyRefMap$$_values[i] = f.apply(this.scala$collection$mutable$AnyRefMap$$_values[i]);
            }
            ++i;
        }
        return this;
    }

    @Override
    public void clear() {
        Arrays.fill(this.scala$collection$mutable$AnyRefMap$$_keys, null);
        Arrays.fill(this.scala$collection$mutable$AnyRefMap$$_values, null);
        Arrays.fill(this.scala$collection$mutable$AnyRefMap$$_hashes, 0);
        this._size = 0;
        this._vacant = 0;
    }

    public static final /* synthetic */ AnyRefMap $anonfun$$plus$plus$1(AnyRefMap arm$1, Tuple2 kv) {
        return arm$1.$plus$eq(kv);
    }

    public AnyRefMap(Function1<K, V> defaultEntry, int initialBufferSize, boolean initBlank) {
        this.defaultEntry = defaultEntry;
        this.mask = 0;
        this._size = 0;
        this._vacant = 0;
        this.scala$collection$mutable$AnyRefMap$$_hashes = null;
        this.scala$collection$mutable$AnyRefMap$$_keys = null;
        this.scala$collection$mutable$AnyRefMap$$_values = null;
        if (initBlank) {
            this.defaultInitialize(initialBufferSize);
        }
    }

    public AnyRefMap() {
        this(AnyRefMap$.MODULE$.scala$collection$mutable$AnyRefMap$$exceptionDefault(), 16, true);
    }

    public AnyRefMap(Function1<K, V> defaultEntry) {
        this(defaultEntry, 16, true);
    }

    public AnyRefMap(int initialBufferSize) {
        this(AnyRefMap$.MODULE$.scala$collection$mutable$AnyRefMap$$exceptionDefault(), initialBufferSize, true);
    }

    public AnyRefMap(Function1<K, V> defaultEntry, int initialBufferSize) {
        this(defaultEntry, initialBufferSize, true);
    }

    public static final class AnyRefMapBuilder<K, V>
    implements ReusableBuilder<Tuple2<K, V>, AnyRefMap<K, V>> {
        private AnyRefMap<K, V> elems;

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
        public <NewTo> Builder<Tuple2<K, V>, NewTo> mapResult(Function1<AnyRefMap<K, V>, NewTo> f) {
            return Builder.mapResult$(this, f);
        }

        @Override
        public Growable $plus$eq(Object elem1, Object elem2, Seq elems) {
            return Growable.$plus$eq$(this, elem1, elem2, elems);
        }

        @Override
        public Growable<Tuple2<K, V>> $plus$plus$eq(TraversableOnce<Tuple2<K, V>> xs) {
            return Growable.$plus$plus$eq$(this, xs);
        }

        public AnyRefMap<K, V> elems() {
            return this.elems;
        }

        public void elems_$eq(AnyRefMap<K, V> x$1) {
            this.elems = x$1;
        }

        @Override
        public AnyRefMapBuilder<K, V> $plus$eq(Tuple2<K, V> entry) {
            this.elems().$plus$eq((Tuple2)entry);
            return this;
        }

        @Override
        public void clear() {
            this.elems_$eq(new AnyRefMap());
        }

        @Override
        public AnyRefMap<K, V> result() {
            return this.elems();
        }

        public AnyRefMapBuilder() {
            Growable.$init$(this);
            Builder.$init$(this);
            this.elems = new AnyRefMap();
        }
    }

    public static class ExceptionDefault
    implements Function1<Object, Nothing$>,
    Serializable {
        public static final long serialVersionUID = 1L;

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
        public <A> Function1<A, Nothing$> compose(Function1<A, Object> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<Object, A> andThen(Function1<Nothing$, A> g) {
            return Function1.andThen$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        @Override
        public Nothing$ apply(Object k) {
            throw new NoSuchElementException(k == null ? "(null)" : k.toString());
        }
    }
}

