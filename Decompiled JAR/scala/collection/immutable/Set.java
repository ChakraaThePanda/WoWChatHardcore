/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.AbstractIterator;
import scala.collection.AbstractSet;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.Growable;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Set$;
import scala.collection.immutable.Traversable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.ReusableBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSet;
import scala.collection.parallel.immutable.ParSet$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0015ehaB;w!\u0003\r\t! \u0005\b\u0003+\u0002A\u0011AA,\u0011\u001d\ty\u0006\u0001C!\u0003CBq!!\u001b\u0001\t\u0003\nY\u0007C\u0004\u0002z\u0001!\t%a\u001f\t\u000f\u0005u\u0004\u0001\"\u0015\u0002\u0000\u001d9\u0011\u0011\u0012<\t\u0002\u0005-eAB;w\u0011\u0003\ti\tC\u0004\u0002\u0016\u001e!\t!a&\t\u000f\u0005eu\u0001\"\u0011\u0002\u001c\"9\u0011\u0011W\u0004\u0005\u0004\u0005M\u0006\u0002CAf\u000f\u0001\u0006I!!4\b\u000f\u00055x\u0001#\u0003\u0002p\u001a9\u0011\u0011_\u0004\t\n\u0005M\bbBAK\u001b\u0011\u0005!\u0011\u0001\u0005\b\u0005\u0007iA\u0011\tB\u0003\u0011\u001d\u0011i!\u0004C\u0001\u0005\u001fAqAa\u0007\u000e\t\u0003\u0011i\u0002C\u0004\u0003\"5!\tAa\t\t\u000f\t\u001dR\u0002\"\u0001\u0003*!9!\u0011G\u0007\u0005B\tM\u0002bBA5\u001b\u0011\u0005#q\t\u0005\b\u0005'jA\u0011\tB+\u0011%\u0011)(DA\u0001\n\u0013\u00119\b\u0003\u0005\u0003\u0018\u001e!\t\u0001\u001fBM\r\u001d\u0011YjBA\u0005\u0005;C!Ba+\u001a\u0005\u0003\u0005\u000b\u0011\u0002B\u0004\u0011\u001d\t)*\u0007C\u0001\u0005[C\u0001Ba-\u001aA\u0003&!q\u0001\u0005\t\u0005kK\u0002\u0015)\u0003\u0003\b!9!qW\r\u0005\u0002\te\u0006b\u0002B^3\u0019\u0005!Q\u0018\u0005\b\u0005\u0007LB\u0011\u0001Bc\u0011\u001d\u00119-\u0007C!\u0005\u00134aAa5\b\u0001\tU\u0007B\u0003BqE\t\u0005\t\u0015!\u0003\u0003\\\"A\u0011Q\u0013\u0012\u0005\u0002a\u0014\u0019\u000fC\u0004\u0003\u0004\t\"\tE!\u0002\t\u000f\t5!\u0005\"\u0001\u0003j\"9!1\u0004\u0012\u0005\u0002\t5\bb\u0002B\u0011E\u0011\u0005!\u0011\u001f\u0005\b\u0005O\u0011C\u0011\u0001B{\u0011\u001d\u0011\tD\tC!\u0005sDqa!\u0002#\t\u0003\u001a9\u0001C\u0004\u0004j\t\"\tea\u001b\t\u0011\r\u0005%\u0005\"\u0011{\u0007\u0007Cqa!$#\t\u0003\u001ay\tC\u0004\u0004,\n\"\te!,\t\u000f\r=&\u0005\"\u0011\u00042\"9\u0011\u0011\u000e\u0012\u0005B\rMfABBj\u000f\u0001\u0019)\u000e\u0003\u0006\u0003bJ\u0012\t\u0011)A\u0005\u00077D!b!93\u0005\u0003\u0005\u000b\u0011BBn\u0011!\t)J\rC\u0001q\u000e\r\bb\u0002B\u0002e\u0011\u0005#Q\u0001\u0005\b\u0005\u001b\u0011D\u0011ABv\u0011\u001d\u0011YB\rC\u0001\u0007_DqA!\t3\t\u0003\u0019\u0019\u0010C\u0004\u0003(I\"\taa>\t\u000f\rm(\u0007\"\u0003\u0004~\"9!\u0011\u0007\u001a\u0005B\u0011\u0005\u0001bBB\u0003e\u0011\u0005CQ\u0002\u0005\b\u0007S\u0012D\u0011\tC\u0013\u0011!\u0019\tI\rC!u\u0012m\u0002bBBGe\u0011\u0005C\u0011\t\u0005\b\u0007W\u0013D\u0011\tC-\u0011\u001d\u0019yK\rC!\t7Bq!!\u001b3\t\u0003\"iF\u0002\u0004\u0005p\u001d\u0001A\u0011\u000f\u0005\u000b\u0005C$%\u0011!Q\u0001\n\u0011]\u0004BCBq\t\n\u0005\t\u0015!\u0003\u0005x!QAQ\u0010#\u0003\u0002\u0003\u0006I\u0001b\u001e\t\u0011\u0005UE\t\"\u0001y\t\u007fBqAa\u0001E\t\u0003\u0012)\u0001C\u0004\u0003\u000e\u0011#\t\u0001\"#\t\u000f\tmA\t\"\u0001\u0005\u000e\"9!\u0011\u0005#\u0005\u0002\u0011E\u0005b\u0002B\u0014\t\u0012\u0005AQ\u0013\u0005\b\u0007w$E\u0011\u0002CM\u0011\u001d\u0011\t\u0004\u0012C!\t;Cqa!\u0002E\t\u0003\"I\u000bC\u0004\u0004j\u0011#\t\u0005\"1\t\u0011\r\u0005E\t\"\u0011{\t/Dqa!$E\t\u0003\"i\u000eC\u0004\u0004,\u0012#\t\u0005\">\t\u000f\r=F\t\"\u0011\u0005x\"9\u0011\u0011\u000e#\u0005B\u0011ehABC\u0006\u000f\u0001)i\u0001\u0003\u0006\u0003b^\u0013\t\u0011)A\u0005\u000b'A!b!9X\u0005\u0003\u0005\u000b\u0011BC\n\u0011)!ih\u0016B\u0001B\u0003%Q1\u0003\u0005\u000b\u000b39&\u0011!Q\u0001\n\u0015M\u0001\u0002CAK/\u0012\u0005\u00010b\u0007\t\u000f\t\rq\u000b\"\u0011\u0003\u0006!9!QB,\u0005\u0002\u0015\u001d\u0002b\u0002B\u000e/\u0012\u0005Q1\u0006\u0005\b\u0005C9F\u0011AC\u0018\u0011\u001d\u00119c\u0016C\u0001\u000bgAqaa?X\t\u0013)9\u0004C\u0004\u00032]#\t%b\u000f\t\u000f\r\u0015q\u000b\"\u0011\u0006H!91\u0011N,\u0005B\u0015}\u0003\u0002CBA/\u0012\u0005#0\"\u001e\t\u000f\r5u\u000b\"\u0011\u0006|!911V,\u0005B\u0015M\u0005bBBX/\u0012\u0005SQ\u0013\u0005\b\u0003S:F\u0011ICL\r\u0019)Ik\u0002\u0004\u0006,\"9\u0011QS6\u0005\u0002\u0015m\u0006\u0002CC`W\u0002\u0006K!\"/\t\u0011\u0015\u00057\u000e)Q\u0005\u0005#A1\"b1l\u0001\u0004\u0005\t\u0015)\u0003\u0006F\"9Q1\\6\u0005B\u0005]\u0003bBCoW\u0012\u0005Sq\u001c\u0005\b\u000bC\\G\u0011ICr\u0011\u001d)Io\u001bC\u0005\u0003/Bq!b;l\t\u0003*iOA\u0002TKRT!a\u001e=\u0002\u0013%lW.\u001e;bE2,'BA={\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002w\u0006)1oY1mC\u000e\u0001Qc\u0001@\u0002\u0014Ma\u0001a`A\u0004\u0003K\tY#!\u000f\u0002BA!\u0011\u0011AA\u0002\u001b\u0005Q\u0018bAA\u0003u\n1\u0011I\\=SK\u001a\u0004b!!\u0003\u0002\f\u0005=Q\"\u0001<\n\u0007\u00055aO\u0001\u0005Ji\u0016\u0014\u0018M\u00197f!\u0011\t\t\"a\u0005\r\u0001\u00119\u0011Q\u0003\u0001C\u0002\u0005]!!A!\u0012\t\u0005e\u0011q\u0004\t\u0005\u0003\u0003\tY\"C\u0002\u0002\u001ei\u0014qAT8uQ&tw\r\u0005\u0003\u0002\u0002\u0005\u0005\u0012bAA\u0012u\n\u0019\u0011I\\=\u0011\r\u0005\u001d\u0012\u0011FA\b\u001b\u0005A\u0018BA;y!!\ti#a\r\u0002\u0010\u0005]RBAA\u0018\u0015\r\t\t\u0004_\u0001\bO\u0016tWM]5d\u0013\u0011\t)$a\f\u0003%\u001d+g.\u001a:jGN+G\u000fV3na2\fG/\u001a\t\u0004\u0003\u0013\u0001\u0001\u0003CA\u0014\u0003w\ty!a\u0010\n\u0007\u0005u\u0002PA\u0004TKRd\u0015n[3\u0011\u000b\u0005%\u0001!a\u0004\u0011\u0011\u0005\u001d\u00121IA\b\u0003\u000fJ1!!\u0012y\u00059\u0001\u0016M]1mY\u0016d\u0017N_1cY\u0016\u0004b!!\u0013\u0002R\u0005=QBAA&\u0015\r9\u0018Q\n\u0006\u0004\u0003\u001fB\u0018\u0001\u00039be\u0006dG.\u001a7\n\t\u0005M\u00131\n\u0002\u0007!\u0006\u00148+\u001a;\u0002\r\u0011Jg.\u001b;%)\t\tI\u0006\u0005\u0003\u0002\u0002\u0005m\u0013bAA/u\n!QK\\5u\u0003%\u0019w.\u001c9b]&|g.\u0006\u0002\u0002dA1\u0011QFA3\u0003oIA!a\u001a\u00020\t\u0001r)\u001a8fe&\u001c7i\\7qC:LwN\\\u0001\u0006i>\u001cV\r^\u000b\u0005\u0003[\n\u0019(\u0006\u0002\u0002pA)\u0011\u0011\u0002\u0001\u0002rA!\u0011\u0011CA:\t\u001d\t)h\u0001b\u0001\u0003o\u0012\u0011AQ\t\u0005\u0003\u001f\ty\"A\u0002tKF,\"!a\u0010\u0002\u0017A\f'oQ8nE&tWM]\u000b\u0003\u0003\u0003\u0003\u0002\"a!\u0002\u0006\u0006=\u0011qI\u0007\u0003\u0003\u001bJA!a\"\u0002N\tA1i\\7cS:,'/A\u0002TKR\u00042!!\u0003\b'\r9\u0011q\u0012\t\u0007\u0003[\t\t*a\u000e\n\t\u0005M\u0015q\u0006\u0002\u0014\u00136lW\u000f^1cY\u0016\u001cV\r\u001e$bGR|'/_\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005\u0005-\u0015A\u00038fo\n+\u0018\u000e\u001c3feV!\u0011QTAW+\t\ty\n\u0005\u0005\u0002\"\u0006\u001d\u00161VAX\u001b\t\t\u0019KC\u0002\u0002&b\fq!\\;uC\ndW-\u0003\u0003\u0002*\u0006\r&a\u0002\"vS2$WM\u001d\t\u0005\u0003#\ti\u000bB\u0004\u0002\u0016%\u0011\r!a\u0006\u0011\u000b\u0005%\u0001!a+\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\t\u0005U\u0016qY\u000b\u0003\u0003o\u0003\"\"!\f\u0002:\u0006u\u0016QYAe\u0013\u0011\tY,a\f\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\t\u0005}\u0016\u0011Y\u0007\u0002\u000f%!\u00111YA3\u0005\u0011\u0019u\u000e\u001c7\u0011\t\u0005E\u0011q\u0019\u0003\b\u0003+Q!\u0019AA\f!\u0015\tI\u0001AAc\u0003-\u0011V-^:bE2,7I\u0011$\u0013\u000b\u0005=w0a7\u0007\r\u0005E\u0007\u0001AAg\u00051a$/\u001a4j]\u0016lWM\u001c;?\u0013\u0011\t).a6\u0002\u001fM,GoQ1o\u0005VLG\u000e\u001a$s_6LA!!7\u00020\tiq)\u001a8TKR4\u0015m\u0019;pef\u0004\"\"!\f\u0002:\u0006u\u0017qDAva\u0011\ty.a9\u0011\u000b\u0005%\u0001!!9\u0011\t\u0005E\u00111\u001d\u0003\f\u0003K\u0004\u0011\u0011!A\u0001\u0006\u0003\t9BA\u0002`IEJA!!;\u0002T\n)A%\u00198p]B)\u0011\u0011\u0002\u0001\u0002 \u0005AQ)\u001c9usN+G\u000fE\u0002\u0002@6\u0011\u0001\"R7qif\u001cV\r^\n\b\u001b\u0005U\u00181^A~!\u0019\t9#a>\u0002 %\u0019\u0011\u0011 =\u0003\u0017\u0005\u00137\u000f\u001e:bGR\u001cV\r\u001e\t\u0005\u0003\u0003\ti0C\u0002\u0002\u0000j\u0014AbU3sS\u0006d\u0017N_1cY\u0016$\"!a<\u0002\tML'0Z\u000b\u0003\u0005\u000f\u0001B!!\u0001\u0003\n%\u0019!1\u0002>\u0003\u0007%sG/\u0001\u0005d_:$\u0018-\u001b8t)\u0011\u0011\tBa\u0006\u0011\t\u0005\u0005!1C\u0005\u0004\u0005+Q(a\u0002\"p_2,\u0017M\u001c\u0005\b\u00053\u0001\u0002\u0019AA\u0010\u0003\u0011)G.Z7\u0002\u000b\u0011\u0002H.^:\u0015\t\u0005-(q\u0004\u0005\b\u00053\t\u0002\u0019AA\u0010\u0003\u0019!S.\u001b8vgR!\u00111\u001eB\u0013\u0011\u001d\u0011IB\u0005a\u0001\u0003?\t\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0005W\u0001b!a\n\u0003.\u0005}\u0011b\u0001B\u0018q\nA\u0011\n^3sCR|'/A\u0004g_J,\u0017m\u00195\u0016\t\tU\"1\t\u000b\u0005\u00033\u00129\u0004C\u0004\u0003:Q\u0001\rAa\u000f\u0002\u0003\u0019\u0004\u0002\"!\u0001\u0003>\u0005}!\u0011I\u0005\u0004\u0005\u007fQ(!\u0003$v]\u000e$\u0018n\u001c82!\u0011\t\tBa\u0011\u0005\u000f\t\u0015CC1\u0001\u0002\u0018\t\tQ+\u0006\u0003\u0003J\t=SC\u0001B&!\u0015\tI\u0001\u0001B'!\u0011\t\tBa\u0014\u0005\u000f\u0005UTC1\u0001\u0003RE!\u0011qDA\u0010\u0003)!\u0003\u000f\\;tIAdWo]\u000b\u0007\u0005/\u0012IG!\u0018\u0015\t\te#1\u000e\u000b\u0005\u00057\u0012\t\u0007\u0005\u0003\u0002\u0012\tuCa\u0002B0-\t\u0007\u0011q\u0003\u0002\u0005)\"\fG\u000fC\u0004\u0003dY\u0001\u001dA!\u001a\u0002\u0005\t4\u0007CCA\u0017\u0003s\u000bYOa\u001a\u0003\\A!\u0011\u0011\u0003B5\t\u001d\t)H\u0006b\u0001\u0005#BqA!\u001c\u0017\u0001\u0004\u0011y'\u0001\u0003uQ\u0006$\bCBA\u0014\u0005c\u00129'C\u0002\u0003ta\u0014!cR3o)J\fg/\u001a:tC\ndWm\u00148dK\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0011I\b\u0005\u0003\u0003|\t\u0015UB\u0001B?\u0015\u0011\u0011yH!!\u0002\t1\fgn\u001a\u0006\u0003\u0005\u0007\u000bAA[1wC&!!q\u0011B?\u0005\u0019y%M[3di\":QBa#\u0003\u0012\nM\u0005\u0003BA\u0001\u0005\u001bK1Aa${\u0005A\u0019VM]5bYZ+'o]5p]VKE)A\u0003wC2,XM\b\u0005_.E:~=\u000bgyQ\u001da!1\u0012BI\u0005'\u000bQ\"Z7qifLen\u001d;b]\u000e,WCAAv\u00051\u0019V\r\u001e(Ji\u0016\u0014\u0018\r^8s+\u0011\u0011yJ!+\u0014\u000be\u0011\t+a?\u0011\r\u0005\u001d\"1\u0015BT\u0013\r\u0011)\u000b\u001f\u0002\u0011\u0003\n\u001cHO]1di&#XM]1u_J\u0004B!!\u0005\u0003*\u00129\u0011QC\rC\u0002\u0005]\u0011!\u00018\u0015\t\t=&\u0011\u0017\t\u0006\u0003\u007fK\"q\u0015\u0005\b\u0005W[\u0002\u0019\u0001B\u0004\u0003\u001d\u0019WO\u001d:f]R\f\u0011B]3nC&tG-\u001a:\u0002\u000f!\f7OT3yiV\u0011!\u0011C\u0001\u0006CB\u0004H.\u001f\u000b\u0005\u0005O\u0013y\fC\u0004\u0003B~\u0001\rAa\u0002\u0002\u0003%\fAA\\3yiR\u0011!qU\u0001\u0005IJ|\u0007\u000f\u0006\u0003\u0003L\n5\u0007CBA\u0014\u0005[\u00119\u000bC\u0004\u0003,\u0006\u0002\rAa\u0002)\u000fe\u0011YI!%\u0003Rz\t1A\u0001\u0003TKR\fT\u0003\u0002Bl\u0005;\u001crA\tBm\u0005?\fY\u0010\u0005\u0004\u0002(\u0005](1\u001c\t\u0005\u0003#\u0011i\u000eB\u0004\u0002\u0016\t\u0012\r!a\u0006\u0011\u000b\u0005%\u0001Aa7\u0002\u000b\u0015dW-\\\u0019\u0015\t\t\u0015(q\u001d\t\u0006\u0003\u007f\u0013#1\u001c\u0005\b\u0005C$\u0003\u0019\u0001Bn)\u0011\u0011\tBa;\t\u000f\tea\u00051\u0001\u0003\\R!!q\u001cBx\u0011\u001d\u0011Ib\na\u0001\u00057$BAa8\u0003t\"9!\u0011\u0004\u0015A\u0002\tmWC\u0001B|!\u0019\t9C!\f\u0003\\V!!1`B\u0002)\u0011\tIF!@\t\u000f\te\"\u00061\u0001\u0003\u0000BA\u0011\u0011\u0001B\u001f\u00057\u001c\t\u0001\u0005\u0003\u0002\u0012\r\rAa\u0002B#U\t\u0007\u0011qC\u0001\u0007KbL7\u000f^:\u0015\t\tE1\u0011\u0002\u0005\b\u0007\u0017Y\u0003\u0019AB\u0007\u0003\u0005\u0001\b\u0003CA\u0001\u0005{\u0011YN!\u0005)\u0011\r%1\u0011CB\f\u0007+\u0002B!!\u0001\u0004\u0014%\u00191Q\u0003>\u0003\u001d\u0011,\u0007O]3dCR,GMT1nKF:qd!\u0007\u0004 \r=\u0003\u0003BA\u0001\u00077I1a!\b{\u0005\u0019\u0019\u00160\u001c2pYFJ1e!\t\u0004(\r\r#1\u0018\u000b\u0005\u00073\u0019\u0019\u0003C\u0004\u0004&q\u0004\ra!\f\u0002\t9\fW.Z\u0005\u0005\u0005w\u001bICC\u0002\u0004,i\faaU=nE>d\u0007\u0003BB\u0018\u0007{qAa!\r\u0004:A\u001911\u0007>\u000e\u0005\rU\"bAB\u001cy\u00061AH]8pizJ1aa\u000f{\u0003\u0019\u0001&/\u001a3fM&!1qHB!\u0005\u0019\u0019FO]5oO*\u001911\b>2\u0013\r\u001a)ea\u0013\u0004N\r-b\u0002BB$\u0007\u0017rAaa\r\u0004J%\t10C\u0002\u0004,i\fd\u0001JB$\u0007\u0013Z\u0018'B\u0013\u0004R\rMsBAB*C\t\u0011I$M\u0005$\u0007[\u00199fa\u0018\u0004Z%!1\u0011LB.\u0003m!C.Z:tS:LG\u000fJ4sK\u0006$XM\u001d\u0013eK\u001a\fW\u000f\u001c;%e)\u00191Q\f>\u0002\u001d\u0011,\u0007O]3dCR,GMT1nKFJ1e!\u0019\u0004d\r\u00154Q\f\b\u0005\u0003\u0003\u0019\u0019'C\u0002\u0004^i\fdAIA\u0001u\u000e\u001d$!B:dC2\f\u0017A\u00024pe\u0006dG\u000e\u0006\u0003\u0003\u0012\r5\u0004bBB\u0006Y\u0001\u00071Q\u0002\u0015\t\u0007[\u001a\tb!\u001d\u0004|E:qd!\u0007\u0004t\re\u0014'C\u0012\u0004\"\r\u001d2Q\u000fB^c%\u00193QIB&\u0007o\u001aY#\r\u0004%\u0007\u000f\u001aIe_\u0019\u0006K\rE31K\u0019\nG\r52qKB?\u00073\n\u0014bIB1\u0007G\u001ayh!\u00182\r\t\n\tA_B4\u0003)1\u0017\u000e\u001c;fe&k\u0007\u000f\u001c\u000b\u0007\u0005?\u001c)i!#\t\u000f\r\u001dU\u00061\u0001\u0004\u000e\u0005!\u0001O]3e\u0011\u001d\u0019Y)\fa\u0001\u0005#\t\u0011\"[:GY&\u0004\b/\u001a3\u0002\t\u0019Lg\u000e\u001a\u000b\u0005\u0007#\u001b9\n\u0005\u0004\u0002\u0002\rM%1\\\u0005\u0004\u0007+S(AB(qi&|g\u000eC\u0004\u0004\f9\u0002\ra!\u0004)\u0011\r]5\u0011CBN\u0007K\u000btaHB\r\u0007;\u001b\u0019+M\u0005$\u0007C\u00199ca(\u0003<FJ1e!\u0012\u0004L\r\u000561F\u0019\u0007I\r\u001d3\u0011J>2\u000b\u0015\u001a\tfa\u00152\u0013\r\u001aica\u0016\u0004(\u000ee\u0013'C\u0012\u0004b\r\r4\u0011VB/c\u0019\u0011\u0013\u0011\u0001>\u0004h\u0005!\u0001.Z1e+\t\u0011Y.\u0001\u0003uC&dWC\u0001Bp+\u0011\u0019)la/\u0016\u0005\r]\u0006#BA\u0005\u0001\re\u0006\u0003BA\t\u0007w#q!!\u001e2\u0005\u0004\u0019i,\u0005\u0003\u0003\\\u0006}\u0001fB\u0019\u0004B\u000e\u001d71\u001a\t\u0005\u0003\u0003\u0019\u0019-C\u0002\u0004Fj\u0014A\u0003Z3qe\u0016\u001c\u0017\r^3e\u001fZ,'O]5eS:<\u0017EABe\u0003\u0005$\u0006.[:!S6lW\u000f^1cY\u0016\u00043/\u001a;!g\"|W\u000f\u001c3!I>\u0004cn\u001c;iS:<\u0007e\u001c8!i>\u001cV\r\u001e\u0011ckR\u00043-Y:uA%$8/\u001a7gAQ|\u0007%\u0019\u0011TKR\u0004s/\u001b;iA\u0005\u0004s/\u001b3fe\u0002*G.Z7f]R\u0004C/\u001f9f]\u0005\u00121QZ\u0001\u0007e9\n\u0014G\f\u001d)\u000f\t\u0012YI!%\u0004RzA\u0011#HoOf).>S\u0001\u0003TKR\u0014T\u0003BBl\u0007;\u001crAMBm\u0007?\fY\u0010\u0005\u0004\u0002(\u0005]81\u001c\t\u0005\u0003#\u0019i\u000eB\u0004\u0002\u0016I\u0012\r!a\u0006\u0011\u000b\u0005%\u0001aa7\u0002\u000b\u0015dW-\u001c\u001a\u0015\r\r\u00158q]Bu!\u0015\tyLMBn\u0011\u001d\u0011\t/\u000ea\u0001\u00077Dqa!96\u0001\u0004\u0019Y\u000e\u0006\u0003\u0003\u0012\r5\bb\u0002B\ro\u0001\u000711\u001c\u000b\u0005\u0007?\u001c\t\u0010C\u0004\u0003\u001aa\u0002\raa7\u0015\t\r}7Q\u001f\u0005\b\u00053I\u0004\u0019ABn+\t\u0019I\u0010\u0005\u0004\u0002(\t521\\\u0001\bO\u0016$X\t\\3n)\u0011\u0019Yna@\t\u000f\t\u00057\b1\u0001\u0003\bU!A1\u0001C\u0006)\u0011\tI\u0006\"\u0002\t\u000f\teB\b1\u0001\u0005\bAA\u0011\u0011\u0001B\u001f\u00077$I\u0001\u0005\u0003\u0002\u0012\u0011-Aa\u0002B#y\t\u0007\u0011q\u0003\u000b\u0005\u0005#!y\u0001C\u0004\u0004\fu\u0002\r\u0001\"\u0005\u0011\u0011\u0005\u0005!QHBn\u0005#A\u0003\u0002b\u0004\u0004\u0012\u0011UAqD\u0019\b?\reAq\u0003C\u000fc%\u00193\u0011EB\u0014\t3\u0011Y,M\u0005$\u0007\u000b\u001aY\u0005b\u0007\u0004,E2Aea\u0012\u0004Jm\fT!JB)\u0007'\n\u0014bIB\u0017\u0007/\"\tc!\u00172\u0013\r\u001a\tga\u0019\u0005$\ru\u0013G\u0002\u0012\u0002\u0002i\u001c9\u0007\u0006\u0003\u0003\u0012\u0011\u001d\u0002bBB\u0006}\u0001\u0007A\u0011\u0003\u0015\t\tO\u0019\t\u0002b\u000b\u00056E:qd!\u0007\u0005.\u0011M\u0012'C\u0012\u0004\"\r\u001dBq\u0006B^c%\u00193QIB&\tc\u0019Y#\r\u0004%\u0007\u000f\u001aIe_\u0019\u0006K\rE31K\u0019\nG\r52q\u000bC\u001c\u00073\n\u0014bIB1\u0007G\"Id!\u00182\r\t\n\tA_B4)\u0019\u0019y\u000e\"\u0010\u0005@!91qQ A\u0002\u0011E\u0001bBBF\u007f\u0001\u0007!\u0011\u0003\u000b\u0005\t\u0007\")\u0005\u0005\u0004\u0002\u0002\rM51\u001c\u0005\b\u0007\u0017\u0001\u0005\u0019\u0001C\tQ!!)e!\u0005\u0005J\u0011M\u0013gB\u0010\u0004\u001a\u0011-C\u0011K\u0019\nG\r\u00052q\u0005C'\u0005w\u000b\u0014bIB#\u0007\u0017\"yea\u000b2\r\u0011\u001a9e!\u0013|c\u0015)3\u0011KB*c%\u00193QFB,\t+\u001aI&M\u0005$\u0007C\u001a\u0019\u0007b\u0016\u0004^E2!%!\u0001{\u0007O*\"aa7\u0016\u0005\r}W\u0003\u0002C0\tK*\"\u0001\"\u0019\u0011\u000b\u0005%\u0001\u0001b\u0019\u0011\t\u0005EAQ\r\u0003\b\u0003k\u001a%\u0019\u0001C4#\u0011\u0019Y.a\b)\u000f\r\u001b\tma2\u0004L\":!Ga#\u0003\u0012\u00125d\u0004\u0003T\u0016(0L2)\u000e;\u0003\tM+GoM\u000b\u0005\tg\"IhE\u0004E\tk\"Y(a?\u0011\r\u0005\u001d\u0012q\u001fC<!\u0011\t\t\u0002\"\u001f\u0005\u000f\u0005UAI1\u0001\u0002\u0018A)\u0011\u0011\u0002\u0001\u0005x\u0005)Q\r\\3ngQAA\u0011\u0011CB\t\u000b#9\tE\u0003\u0002@\u0012#9\bC\u0004\u0003b\"\u0003\r\u0001b\u001e\t\u000f\r\u0005\b\n1\u0001\u0005x!9AQ\u0010%A\u0002\u0011]D\u0003\u0002B\t\t\u0017CqA!\u0007K\u0001\u0004!9\b\u0006\u0003\u0005|\u0011=\u0005b\u0002B\r\u0017\u0002\u0007Aq\u000f\u000b\u0005\tw\"\u0019\nC\u0004\u0003\u001a1\u0003\r\u0001b\u001e\u0016\u0005\u0011]\u0005CBA\u0014\u0005[!9\b\u0006\u0003\u0005x\u0011m\u0005b\u0002Ba\u001d\u0002\u0007!qA\u000b\u0005\t?#9\u000b\u0006\u0003\u0002Z\u0011\u0005\u0006b\u0002B\u001d\u001f\u0002\u0007A1\u0015\t\t\u0003\u0003\u0011i\u0004b\u001e\u0005&B!\u0011\u0011\u0003CT\t\u001d\u0011)e\u0014b\u0001\u0003/!BA!\u0005\u0005,\"911\u0002)A\u0002\u00115\u0006\u0003CA\u0001\u0005{!9H!\u0005)\u0011\u0011-6\u0011\u0003CY\tw\u000btaHB\r\tg#I,M\u0005$\u0007C\u00199\u0003\".\u0003<FJ1e!\u0012\u0004L\u0011]61F\u0019\u0007I\r\u001d3\u0011J>2\u000b\u0015\u001a\tfa\u00152\u0013\r\u001aica\u0016\u0005>\u000ee\u0013'C\u0012\u0004b\r\rDqXB/c\u0019\u0011\u0013\u0011\u0001>\u0004hQ!!\u0011\u0003Cb\u0011\u001d\u0019Y!\u0015a\u0001\t[C\u0003\u0002b1\u0004\u0012\u0011\u001dG\u0011[\u0019\b?\reA\u0011\u001aChc%\u00193\u0011EB\u0014\t\u0017\u0014Y,M\u0005$\u0007\u000b\u001aY\u0005\"4\u0004,E2Aea\u0012\u0004Jm\fT!JB)\u0007'\n\u0014bIB\u0017\u0007/\"\u0019n!\u00172\u0013\r\u001a\tga\u0019\u0005V\u000eu\u0013G\u0002\u0012\u0002\u0002i\u001c9\u0007\u0006\u0004\u0005|\u0011eG1\u001c\u0005\b\u0007\u000f\u0013\u0006\u0019\u0001CW\u0011\u001d\u0019YI\u0015a\u0001\u0005#!B\u0001b8\u0005bB1\u0011\u0011ABJ\toBqaa\u0003T\u0001\u0004!i\u000b\u000b\u0005\u0005b\u000eEAQ\u001dCxc\u001dy2\u0011\u0004Ct\t[\f\u0014bIB\u0011\u0007O!IOa/2\u0013\r\u001a)ea\u0013\u0005l\u000e-\u0012G\u0002\u0013\u0004H\r%30M\u0003&\u0007#\u001a\u0019&M\u0005$\u0007[\u00199\u0006\"=\u0004ZEJ1e!\u0019\u0004d\u0011M8QL\u0019\u0007E\u0005\u0005!pa\u001a\u0016\u0005\u0011]TC\u0001C>+\u0011!Y0\"\u0001\u0016\u0005\u0011u\b#BA\u0005\u0001\u0011}\b\u0003BA\t\u000b\u0003!q!!\u001eW\u0005\u0004)\u0019!\u0005\u0003\u0005x\u0005}\u0001f\u0002,\u0004B\u000e\u001d71\u001a\u0015\b\t\n-%\u0011SC\u0005=!qM&s\u001f:W\u0014\u0003+\u0001B*fiR*B!b\u0004\u0006\u0016M9q+\"\u0005\u0006\u0018\u0005m\bCBA\u0014\u0003o,\u0019\u0002\u0005\u0003\u0002\u0012\u0015UAaBA\u000b/\n\u0007\u0011q\u0003\t\u0006\u0003\u0013\u0001Q1C\u0001\u0006K2,W\u000e\u000e\u000b\u000b\u000b;)y\"\"\t\u0006$\u0015\u0015\u0002#BA`/\u0016M\u0001b\u0002Bq9\u0002\u0007Q1\u0003\u0005\b\u0007Cd\u0006\u0019AC\n\u0011\u001d!i\b\u0018a\u0001\u000b'Aq!\"\u0007]\u0001\u0004)\u0019\u0002\u0006\u0003\u0003\u0012\u0015%\u0002b\u0002B\r=\u0002\u0007Q1\u0003\u000b\u0005\u000b/)i\u0003C\u0004\u0003\u001a}\u0003\r!b\u0005\u0015\t\u0015]Q\u0011\u0007\u0005\b\u00053\u0001\u0007\u0019AC\n+\t))\u0004\u0005\u0004\u0002(\t5R1\u0003\u000b\u0005\u000b')I\u0004C\u0004\u0003B\n\u0004\rAa\u0002\u0016\t\u0015uRQ\t\u000b\u0005\u00033*y\u0004C\u0004\u0003:\r\u0004\r!\"\u0011\u0011\u0011\u0005\u0005!QHC\n\u000b\u0007\u0002B!!\u0005\u0006F\u00119!QI2C\u0002\u0005]A\u0003\u0002B\t\u000b\u0013Bqaa\u0003e\u0001\u0004)Y\u0005\u0005\u0005\u0002\u0002\tuR1\u0003B\tQ!)Ie!\u0005\u0006P\u0015e\u0013gB\u0010\u0004\u001a\u0015ESqK\u0019\nG\r\u00052qEC*\u0005w\u000b\u0014bIB#\u0007\u0017*)fa\u000b2\r\u0011\u001a9e!\u0013|c\u0015)3\u0011KB*c%\u00193QFB,\u000b7\u001aI&M\u0005$\u0007C\u001a\u0019'\"\u0018\u0004^E2!%!\u0001{\u0007O\"BA!\u0005\u0006b!911B3A\u0002\u0015-\u0003\u0006CC1\u0007#))'b\u001c2\u000f}\u0019I\"b\u001a\u0006nEJ1e!\t\u0004(\u0015%$1X\u0019\nG\r\u001531JC6\u0007W\td\u0001JB$\u0007\u0013Z\u0018'B\u0013\u0004R\rM\u0013'C\u0012\u0004.\r]S\u0011OB-c%\u00193\u0011MB2\u000bg\u001ai&\r\u0004#\u0003\u0003Q8q\r\u000b\u0007\u000b/)9(\"\u001f\t\u000f\r\u001de\r1\u0001\u0006L!911\u00124A\u0002\tEA\u0003BC?\u000b\u007f\u0002b!!\u0001\u0004\u0014\u0016M\u0001bBB\u0006O\u0002\u0007Q1\n\u0015\t\u000b\u007f\u001a\t\"b!\u0006\u000eF:qd!\u0007\u0006\u0006\u0016-\u0015'C\u0012\u0004\"\r\u001dRq\u0011B^c%\u00193QIB&\u000b\u0013\u001bY#\r\u0004%\u0007\u000f\u001aIe_\u0019\u0006K\rE31K\u0019\nG\r52qKCH\u00073\n\u0014bIB1\u0007G*\tj!\u00182\r\t\n\tA_B4+\t)\u0019\"\u0006\u0002\u0006\u0018U!Q\u0011TCP+\t)Y\nE\u0003\u0002\n\u0001)i\n\u0005\u0003\u0002\u0012\u0015}EaBA;U\n\u0007Q\u0011U\t\u0005\u000b'\ty\u0002K\u0004k\u0007\u0003\u001c9ma3)\u000f]\u0013YI!%\u0006(zAQZ/TE$6D_W\u0001\bTKR\u0014U/\u001b7eKJLU\u000e\u001d7\u0016\t\u00155VqW\n\u0005W~,y\u000b\u0005\u0005\u0002\"\u0016EVQWC]\u0013\u0011)\u0019,a)\u0003\u001fI+Wo]1cY\u0016\u0014U/\u001b7eKJ\u0004B!!\u0005\u00068\u00129\u0011QC6C\u0002\u0005]\u0001#BA\u0005\u0001\u0015UFCAC_!\u0015\tyl[C[\u0003\u0015)G.Z7t\u0003a\u0019x/\u001b;dQ\u0016$Gk\u001c%bg\"\u001cV\r\u001e\"vS2$WM]\u0001\u000fQ\u0006\u001c\bnU3u\u0005VLG\u000eZ3s!\u0019)9-\"6\u00066:!Q\u0011ZCi\u001d\u0011)Y-b4\u000f\t\r\u001dSQZ\u0005\u0003sjL!a\u001e=\n\u0007\u0015Mg/A\u0004ICND7+\u001a;\n\t\u0015]W\u0011\u001c\u0002\u000f\u0011\u0006\u001c\bnU3u\u0005VLG\u000eZ3s\u0015\r)\u0019N^\u0001\u0006G2,\u0017M]\u0001\u0007e\u0016\u001cX\u000f\u001c;\u0015\u0005\u0015e\u0016\u0001\u0003\u0013qYV\u001cH%Z9\u0015\t\u0015\u0015Xq]\u0007\u0002W\"9!\u0011\u0004:A\u0002\u0015U\u0016aF2p]Z,'\u000f\u001e+p\u0011\u0006\u001c\bnU3u\u0005VLG\u000eZ3s\u00035!\u0003\u000f\\;tIAdWo\u001d\u0013fcR!QQ]Cx\u0011\u001d)\t\u0010\u001ea\u0001\u000bg\f!\u0001_:\u0011\r\u0005\u001dRQ_C[\u0013\r)9\u0010\u001f\u0002\u0010)J\fg/\u001a:tC\ndWm\u00148dK\u0002")
public interface Set<A>
extends Iterable<A>,
scala.collection.Set<A> {
    public static <A> CanBuildFrom<Set<?>, A, Set<A>> canBuildFrom() {
        return Set$.MODULE$.canBuildFrom();
    }

    public static <A> CanBuildFrom<Set<?>, A, Set<A>> setCanBuildFrom() {
        return Set$.MODULE$.setCanBuildFrom();
    }

    @Override
    default public GenericCompanion<Set> companion() {
        return Set$.MODULE$;
    }

    public static /* synthetic */ Set toSet$(Set $this) {
        return $this.toSet();
    }

    @Override
    default public <B> Set<B> toSet() {
        Builder sb = Set$.MODULE$.newBuilder();
        this.foreach((Function1<Object, Builder> & java.io.Serializable & Serializable)x$1 -> sb.$plus$eq(x$1));
        return sb.result();
    }

    @Override
    default public Set<A> seq() {
        return this;
    }

    @Override
    default public Combiner<A, ParSet<A>> parCombiner() {
        return ParSet$.MODULE$.newCombiner();
    }

    public static void $init$(Set $this) {
    }

    public static class Set1<A>
    extends AbstractSet<A>
    implements Set<A>,
    Serializable {
        public static final long serialVersionUID = 1233385750652442003L;
        private final A elem1;

        @Override
        public GenericCompanion<Set> companion() {
            return ((Set)this).companion();
        }

        @Override
        public Set<A> seq() {
            return ((Set)this).seq();
        }

        @Override
        public Combiner<A, ParSet<A>> parCombiner() {
            return ((Set)this).parCombiner();
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public boolean contains(A elem) {
            return BoxesRunTime.equals(elem, this.elem1);
        }

        @Override
        public Set<A> $plus(A elem) {
            if (this.contains(elem)) {
                return this;
            }
            return new Set2<A>(this.elem1, elem);
        }

        @Override
        public Set<A> $minus(A elem) {
            if (BoxesRunTime.equals(elem, this.elem1)) {
                return Set$.MODULE$.empty();
            }
            return this;
        }

        @Override
        public Iterator<A> iterator() {
            return Iterator$.MODULE$.single(this.elem1);
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            f.apply(this.elem1);
        }

        @Override
        public boolean exists(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1));
        }

        @Override
        public boolean forall(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1));
        }

        @Override
        public Set<A> filterImpl(Function1<A, Object> pred, boolean isFlipped) {
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem1)) != isFlipped) {
                return this;
            }
            return Set$.MODULE$.empty();
        }

        @Override
        public Option<A> find(Function1<A, Object> p) {
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem1))) {
                return new Some<A>(this.elem1);
            }
            return None$.MODULE$;
        }

        @Override
        public A head() {
            return this.elem1;
        }

        @Override
        public Set<A> tail() {
            return Set$.MODULE$.empty();
        }

        @Override
        public <B> Set<B> toSet() {
            return this;
        }

        public Set1(A elem1) {
            this.elem1 = elem1;
            Traversable.$init$(this);
            Iterable.$init$(this);
            Set.$init$(this);
        }
    }

    public static class Set2<A>
    extends AbstractSet<A>
    implements Set<A>,
    Serializable {
        public static final long serialVersionUID = -6443011234944830092L;
        private final A elem1;
        private final A elem2;

        @Override
        public GenericCompanion<Set> companion() {
            return ((Set)this).companion();
        }

        @Override
        public Set<A> seq() {
            return ((Set)this).seq();
        }

        @Override
        public Combiner<A, ParSet<A>> parCombiner() {
            return ((Set)this).parCombiner();
        }

        @Override
        public int size() {
            return 2;
        }

        @Override
        public boolean contains(A elem) {
            return BoxesRunTime.equals(elem, this.elem1) || BoxesRunTime.equals(elem, this.elem2);
        }

        @Override
        public Set<A> $plus(A elem) {
            if (this.contains(elem)) {
                return this;
            }
            return new Set3<A>(this.elem1, this.elem2, elem);
        }

        @Override
        public Set<A> $minus(A elem) {
            if (BoxesRunTime.equals(elem, this.elem1)) {
                return new Set1<A>(this.elem2);
            }
            if (BoxesRunTime.equals(elem, this.elem2)) {
                return new Set1<A>(this.elem1);
            }
            return this;
        }

        @Override
        public Iterator<A> iterator() {
            return new SetNIterator<A>(this){
                private final /* synthetic */ Set2 $outer;

                public A apply(int i) {
                    return this.$outer.scala$collection$immutable$Set$Set2$$getElem(i);
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super($outer.size());
                }
            };
        }

        public A scala$collection$immutable$Set$Set2$$getElem(int i) {
            switch (i) {
                case 0: {
                    return this.elem1;
                }
                case 1: {
                    return this.elem2;
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(i));
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            f.apply(this.elem1);
            f.apply(this.elem2);
        }

        @Override
        public boolean exists(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1)) || BoxesRunTime.unboxToBoolean(p.apply(this.elem2));
        }

        @Override
        public boolean forall(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1)) && BoxesRunTime.unboxToBoolean(p.apply(this.elem2));
        }

        @Override
        public Set<A> filterImpl(Function1<A, Object> pred, boolean isFlipped) {
            Object r1 = null;
            int n = 0;
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem1)) != isFlipped) {
                r1 = this.elem1;
                ++n;
            }
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem2)) != isFlipped) {
                if (n == 0) {
                    r1 = this.elem2;
                }
                ++n;
            }
            switch (n) {
                case 0: {
                    return Set$.MODULE$.empty();
                }
                case 1: {
                    return new Set1<Object>(r1);
                }
                case 2: {
                    return this;
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(n));
        }

        @Override
        public Option<A> find(Function1<A, Object> p) {
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem1))) {
                return new Some<A>(this.elem1);
            }
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem2))) {
                return new Some<A>(this.elem2);
            }
            return None$.MODULE$;
        }

        @Override
        public A head() {
            return this.elem1;
        }

        @Override
        public Set<A> tail() {
            return new Set1<A>(this.elem2);
        }

        @Override
        public <B> Set<B> toSet() {
            return this;
        }

        public Set2(A elem1, A elem2) {
            this.elem1 = elem1;
            this.elem2 = elem2;
            Traversable.$init$(this);
            Iterable.$init$(this);
            Set.$init$(this);
        }
    }

    public static class Set3<A>
    extends AbstractSet<A>
    implements Set<A>,
    Serializable {
        public static final long serialVersionUID = -3590273538119220064L;
        private final A elem1;
        private final A elem2;
        private final A elem3;

        @Override
        public GenericCompanion<Set> companion() {
            return ((Set)this).companion();
        }

        @Override
        public Set<A> seq() {
            return ((Set)this).seq();
        }

        @Override
        public Combiner<A, ParSet<A>> parCombiner() {
            return ((Set)this).parCombiner();
        }

        @Override
        public int size() {
            return 3;
        }

        @Override
        public boolean contains(A elem) {
            return BoxesRunTime.equals(elem, this.elem1) || BoxesRunTime.equals(elem, this.elem2) || BoxesRunTime.equals(elem, this.elem3);
        }

        @Override
        public Set<A> $plus(A elem) {
            if (this.contains(elem)) {
                return this;
            }
            return new Set4<A>(this.elem1, this.elem2, this.elem3, elem);
        }

        @Override
        public Set<A> $minus(A elem) {
            if (BoxesRunTime.equals(elem, this.elem1)) {
                return new Set2<A>(this.elem2, this.elem3);
            }
            if (BoxesRunTime.equals(elem, this.elem2)) {
                return new Set2<A>(this.elem1, this.elem3);
            }
            if (BoxesRunTime.equals(elem, this.elem3)) {
                return new Set2<A>(this.elem1, this.elem2);
            }
            return this;
        }

        @Override
        public Iterator<A> iterator() {
            return new SetNIterator<A>(this){
                private final /* synthetic */ Set3 $outer;

                public A apply(int i) {
                    return this.$outer.scala$collection$immutable$Set$Set3$$getElem(i);
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super($outer.size());
                }
            };
        }

        public A scala$collection$immutable$Set$Set3$$getElem(int i) {
            switch (i) {
                case 0: {
                    return this.elem1;
                }
                case 1: {
                    return this.elem2;
                }
                case 2: {
                    return this.elem3;
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(i));
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            f.apply(this.elem1);
            f.apply(this.elem2);
            f.apply(this.elem3);
        }

        @Override
        public boolean exists(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1)) || BoxesRunTime.unboxToBoolean(p.apply(this.elem2)) || BoxesRunTime.unboxToBoolean(p.apply(this.elem3));
        }

        @Override
        public boolean forall(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1)) && BoxesRunTime.unboxToBoolean(p.apply(this.elem2)) && BoxesRunTime.unboxToBoolean(p.apply(this.elem3));
        }

        @Override
        public Set<A> filterImpl(Function1<A, Object> pred, boolean isFlipped) {
            Object r1 = null;
            Object r2 = null;
            int n = 0;
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem1)) != isFlipped) {
                r1 = this.elem1;
                ++n;
            }
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem2)) != isFlipped) {
                if (n == 0) {
                    r1 = this.elem2;
                } else {
                    r2 = this.elem2;
                }
                ++n;
            }
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem3)) != isFlipped) {
                if (n == 0) {
                    r1 = this.elem3;
                } else if (n == 1) {
                    r2 = this.elem3;
                }
                ++n;
            }
            switch (n) {
                case 0: {
                    return Set$.MODULE$.empty();
                }
                case 1: {
                    return new Set1<Object>(r1);
                }
                case 2: {
                    return new Set2<Object>(r1, r2);
                }
                case 3: {
                    return this;
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(n));
        }

        @Override
        public Option<A> find(Function1<A, Object> p) {
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem1))) {
                return new Some<A>(this.elem1);
            }
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem2))) {
                return new Some<A>(this.elem2);
            }
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem3))) {
                return new Some<A>(this.elem3);
            }
            return None$.MODULE$;
        }

        @Override
        public A head() {
            return this.elem1;
        }

        @Override
        public Set<A> tail() {
            return new Set2<A>(this.elem2, this.elem3);
        }

        @Override
        public <B> Set<B> toSet() {
            return this;
        }

        public Set3(A elem1, A elem2, A elem3) {
            this.elem1 = elem1;
            this.elem2 = elem2;
            this.elem3 = elem3;
            Traversable.$init$(this);
            Iterable.$init$(this);
            Set.$init$(this);
        }
    }

    public static class Set4<A>
    extends AbstractSet<A>
    implements Set<A>,
    Serializable {
        public static final long serialVersionUID = -3622399588156184395L;
        private final A elem1;
        private final A elem2;
        private final A elem3;
        private final A elem4;

        @Override
        public GenericCompanion<Set> companion() {
            return ((Set)this).companion();
        }

        @Override
        public Set<A> seq() {
            return ((Set)this).seq();
        }

        @Override
        public Combiner<A, ParSet<A>> parCombiner() {
            return ((Set)this).parCombiner();
        }

        @Override
        public int size() {
            return 4;
        }

        @Override
        public boolean contains(A elem) {
            return BoxesRunTime.equals(elem, this.elem1) || BoxesRunTime.equals(elem, this.elem2) || BoxesRunTime.equals(elem, this.elem3) || BoxesRunTime.equals(elem, this.elem4);
        }

        @Override
        public Set<A> $plus(A elem) {
            if (this.contains(elem)) {
                return this;
            }
            return ((HashSet)((HashSet)((HashSet)((HashSet)new HashSet().$plus((Object)this.elem1)).$plus((Object)this.elem2)).$plus((Object)this.elem3)).$plus((Object)this.elem4)).$plus((Object)elem);
        }

        @Override
        public Set<A> $minus(A elem) {
            if (BoxesRunTime.equals(elem, this.elem1)) {
                return new Set3<A>(this.elem2, this.elem3, this.elem4);
            }
            if (BoxesRunTime.equals(elem, this.elem2)) {
                return new Set3<A>(this.elem1, this.elem3, this.elem4);
            }
            if (BoxesRunTime.equals(elem, this.elem3)) {
                return new Set3<A>(this.elem1, this.elem2, this.elem4);
            }
            if (BoxesRunTime.equals(elem, this.elem4)) {
                return new Set3<A>(this.elem1, this.elem2, this.elem3);
            }
            return this;
        }

        @Override
        public Iterator<A> iterator() {
            return new SetNIterator<A>(this){
                private final /* synthetic */ Set4 $outer;

                public A apply(int i) {
                    return this.$outer.scala$collection$immutable$Set$Set4$$getElem(i);
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super($outer.size());
                }
            };
        }

        public A scala$collection$immutable$Set$Set4$$getElem(int i) {
            switch (i) {
                case 0: {
                    return this.elem1;
                }
                case 1: {
                    return this.elem2;
                }
                case 2: {
                    return this.elem3;
                }
                case 3: {
                    return this.elem4;
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(i));
        }

        @Override
        public <U> void foreach(Function1<A, U> f) {
            f.apply(this.elem1);
            f.apply(this.elem2);
            f.apply(this.elem3);
            f.apply(this.elem4);
        }

        @Override
        public boolean exists(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1)) || BoxesRunTime.unboxToBoolean(p.apply(this.elem2)) || BoxesRunTime.unboxToBoolean(p.apply(this.elem3)) || BoxesRunTime.unboxToBoolean(p.apply(this.elem4));
        }

        @Override
        public boolean forall(Function1<A, Object> p) {
            return BoxesRunTime.unboxToBoolean(p.apply(this.elem1)) && BoxesRunTime.unboxToBoolean(p.apply(this.elem2)) && BoxesRunTime.unboxToBoolean(p.apply(this.elem3)) && BoxesRunTime.unboxToBoolean(p.apply(this.elem4));
        }

        @Override
        public Set<A> filterImpl(Function1<A, Object> pred, boolean isFlipped) {
            Object r1 = null;
            Object r2 = null;
            Object r3 = null;
            int n = 0;
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem1)) != isFlipped) {
                r1 = this.elem1;
                ++n;
            }
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem2)) != isFlipped) {
                if (n == 0) {
                    r1 = this.elem2;
                } else {
                    r2 = this.elem2;
                }
                ++n;
            }
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem3)) != isFlipped) {
                if (n == 0) {
                    r1 = this.elem3;
                } else if (n == 1) {
                    r2 = this.elem3;
                } else {
                    r3 = this.elem3;
                }
                ++n;
            }
            if (BoxesRunTime.unboxToBoolean(pred.apply(this.elem4)) != isFlipped) {
                if (n == 0) {
                    r1 = this.elem4;
                } else if (n == 1) {
                    r2 = this.elem4;
                } else if (n == 2) {
                    r3 = this.elem4;
                }
                ++n;
            }
            switch (n) {
                case 0: {
                    return Set$.MODULE$.empty();
                }
                case 1: {
                    return new Set1<Object>(r1);
                }
                case 2: {
                    return new Set2<Object>(r1, r2);
                }
                case 3: {
                    return new Set3<Object>(r1, r2, r3);
                }
                case 4: {
                    return this;
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(n));
        }

        @Override
        public Option<A> find(Function1<A, Object> p) {
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem1))) {
                return new Some<A>(this.elem1);
            }
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem2))) {
                return new Some<A>(this.elem2);
            }
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem3))) {
                return new Some<A>(this.elem3);
            }
            if (BoxesRunTime.unboxToBoolean(p.apply(this.elem4))) {
                return new Some<A>(this.elem4);
            }
            return None$.MODULE$;
        }

        @Override
        public A head() {
            return this.elem1;
        }

        @Override
        public Set<A> tail() {
            return new Set3<A>(this.elem2, this.elem3, this.elem4);
        }

        @Override
        public <B> Set<B> toSet() {
            return this;
        }

        public Set4(A elem1, A elem2, A elem3, A elem4) {
            this.elem1 = elem1;
            this.elem2 = elem2;
            this.elem3 = elem3;
            this.elem4 = elem4;
            Traversable.$init$(this);
            Iterable.$init$(this);
            Set.$init$(this);
        }
    }

    public static final class SetBuilderImpl<A>
    implements ReusableBuilder<A, Set<A>> {
        private Set<A> elems;
        private boolean switchedToHashSetBuilder;
        private HashSet.HashSetBuilder<A> hashSetBuilder;

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
        public <NewTo> Builder<A, NewTo> mapResult(Function1<Set<A>, NewTo> f) {
            return Builder.mapResult$(this, f);
        }

        @Override
        public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
            return Growable.$plus$eq$(this, elem1, elem2, elems);
        }

        @Override
        public void clear() {
            this.elems = Set$.MODULE$.empty();
            if (this.hashSetBuilder != null) {
                this.hashSetBuilder.clear();
            }
            this.switchedToHashSetBuilder = false;
        }

        @Override
        public Set<A> result() {
            if (this.switchedToHashSetBuilder) {
                return this.hashSetBuilder.result();
            }
            return this.elems;
        }

        @Override
        public SetBuilderImpl<A> $plus$eq(A elem) {
            if (this.switchedToHashSetBuilder) {
                this.hashSetBuilder.$plus$eq((Object)elem);
            } else if (this.elems.size() < 4) {
                this.elems = (Set)this.elems.$plus(elem);
            } else if (!this.elems.contains(elem)) {
                this.convertToHashSetBuilder();
                this.hashSetBuilder.$plus$eq((Object)elem);
            }
            return this;
        }

        private void convertToHashSetBuilder() {
            this.switchedToHashSetBuilder = true;
            if (this.hashSetBuilder == null) {
                this.hashSetBuilder = new HashSet.HashSetBuilder();
            }
            this.hashSetBuilder.$plus$plus$eq((TraversableOnce)this.elems);
        }

        @Override
        public SetBuilderImpl<A> $plus$plus$eq(TraversableOnce<A> xs) {
            scala.collection.Set set;
            if (this.switchedToHashSetBuilder) {
                this.hashSetBuilder.$plus$plus$eq((TraversableOnce)xs);
            } else if (xs instanceof scala.collection.Set && (set = (scala.collection.Set)xs).size() > 4) {
                this.convertToHashSetBuilder();
                this.hashSetBuilder.$plus$plus$eq((TraversableOnce)set);
            } else {
                ReusableBuilder cfr_ignored_0 = (ReusableBuilder)Growable.$plus$plus$eq$(this, xs);
            }
            return this;
        }

        public SetBuilderImpl() {
            Growable.$init$(this);
            Builder.$init$(this);
            this.elems = Set$.MODULE$.empty();
            this.switchedToHashSetBuilder = false;
        }
    }

    public static abstract class SetNIterator<A>
    extends AbstractIterator<A>
    implements Serializable {
        public static final long serialVersionUID = 3L;
        private int current = 0;
        private int remainder;

        @Override
        public boolean hasNext() {
            return this.remainder > 0;
        }

        public abstract A apply(int var1);

        /*
         * WARNING - void declaration
         */
        @Override
        public A next() {
            if (this.hasNext()) {
                void var1_1;
                A r = this.apply(this.current);
                ++this.current;
                --this.remainder;
                return var1_1;
            }
            return (A)Iterator$.MODULE$.empty().next();
        }

        @Override
        public Iterator<A> drop(int n) {
            if (n > 0) {
                this.current += n;
                this.remainder = Math.max(0, this.remainder - n);
            }
            return this;
        }

        public SetNIterator(int n) {
            this.remainder = n;
        }
    }
}

