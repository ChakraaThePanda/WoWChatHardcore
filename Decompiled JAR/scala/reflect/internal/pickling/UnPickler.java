/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.pickling;

import java.io.IOException;
import java.lang.invoke.LambdaMetafactory;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashMap$;
import scala.collection.mutable.ListBuffer;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Flags$;
import scala.reflect.internal.Mirrors;
import scala.reflect.internal.MissingRequirementError;
import scala.reflect.internal.Names;
import scala.reflect.internal.Phase;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoType$;
import scala.reflect.internal.pickling.PickleBuffer;
import scala.reflect.internal.pickling.PickleFormat$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;
import scala.runtime.ObjectRef;
import scala.util.Either;
import scala.util.Left;
import scala.util.Right;
import scala.util.control.NonFatal$;

@ScalaSignature(bytes="\u0006\u0001\rUh!\u0002-Z\u0003\u0003\u0011\u0007\"B4\u0001\t\u0003A\u0007bB6\u0001\u0005\u00045\t\u0001\u001c\u0005\u0006c\u0002!\tA\u001d\u0005\n\u0003{\u0001!\u0019!C\u0005\u0003\u007fA\u0001\"a\u0016\u0001A\u0003%\u0011\u0011\t\u0004\u0007\u00033\u0002\u0001!a\u0017\t\u0013\u0005\rdA!A!\u0002\u0013A\b\"C@\u0007\u0005\u0003\u0005\u000b\u0011BA\u0001\u0011)\tIA\u0002B\u0001B\u0003%\u00111\u0002\u0005\u000b\u000371!\u0011!Q\u0001\n\u0005u\u0001BCA\u0013\r\t\u0005\t\u0015!\u0003\u0002(!1qM\u0002C\u0001\u0003KBq!a\u001d\u0007\t#\t)\bC\u0005\u0002~\u0019\u0011\r\u0011\"\u0003\u0002\u0000!A\u00111\u0012\u0004!\u0002\u0013\t\t\t\u0003\b\u0002\u000e\u001a!\t\u0011!B\u0001\u0006\u0004%I!a$\t\u0017\u0005MeA!A\u0001B\u0003%\u0011\u0011\u0013\u0005\n\u0003+3!\u0019!C\u0005\u0003/C\u0001\"a'\u0007A\u0003%\u0011\u0011\u0014\u0005\n\u0003;3!\u0019!C\u0005\u0003?C\u0001\"!-\u0007A\u0003%\u0011\u0011\u0015\u0005\b\u0003g3A\u0011BA[\u0011\u001d\t)M\u0002C\u0005\u0003\u000fDq!!>\u0007\t\u0003\t9\u0010C\u0004\u0002z\u001a!I!a>\t\u000f\u0005mh\u0001\"\u0005\u0002~\"9!1\u0001\u0004\u0005\u0012\t\u0015\u0001b\u0002B\u0005\r\u0011E!1\u0002\u0005\b\u0005\u001f1A\u0011\u0003B\t\u0011\u001d\u0011)B\u0002C\t\u0005/AqAa\u0007\u0007\t#\u0011i\u0002C\u0004\u0003\"\u0019!IAa\t\t\u000f\tMb\u0001\"\u0005\u00036!9!\u0011\b\u0004\u0005\u0012\tm\u0002b\u0002B)\r\u0011E!1\u000b\u0005\b\u0005?2A\u0011\u0002B1\u0011\u001d\u0011\u0019G\u0002C\t\u0005KBqAa\u001a\u0007\t#\u0011I\u0007C\u0005\u0003z\u0019\t\n\u0011\"\u0005\u0003|!9!\u0011\u0013\u0004\u0005\u0002\tM\u0005b\u0002BO\r\u0011E!q\u0014\u0005\b\u0005W3A\u0011\u0001BW\u0011\u001d\u0011)L\u0002C\t\u0003oDqAa.\u0007\t#\u0011I\fC\u0004\u0003H\u001a!IA!3\t\u000f\t]g\u0001\"\u0005\u0003Z\"9!Q\u001c\u0004\u0005\u0012\t}\u0007b\u0002Bu\r\u0011E\u0011q\u001f\u0005\b\u0005W4A\u0011\u0003Bw\u0011\u001d\u0011yO\u0002C\u0005\u0005cDqAa>\u0007\t#\u0011I\u0010C\u0004\u0003|\u001a!\tA!@\t\u000f\r\ra\u0001\"\u0001\u0004\u0006!91Q\u0002\u0004\u0005\u0012\t\u0015\u0004bBB\b\r\u0011E!1\u000b\u0005\b\u0007#1A\u0011CB\n\u0011\u001d\u0019)B\u0002C\t\u0005?Cqaa\u0006\u0007\t#\u0011i\u000fC\u0004\u0004\u001a\u0019!\tb!\u0002\t\u000f\rma\u0001\"\u0005\u0003z\"91Q\u0004\u0004\u0005\u0012\r}\u0001bBB\u0014\r\u0011E1\u0011\u0006\u0005\b\u0007c1A\u0011CB\u001a\u0011\u001d\u0019YD\u0002C\t\u0007{Aqa!\u0012\u0007\t#\u00199\u0005C\u0004\u0004P\u0019!\tb!\u0015\t\u000f\rec\u0001\"\u0005\u0004\\!911\r\u0004\u0005\u0012\r\u0015\u0004bBB5\r\u0011\u000511\u000e\u0005\b\u0007\u007f2A\u0011ABA\u0011\u001d\u0019YI\u0002C\u0001\u0007\u001bCqa!&\u0007\t\u0003\u00199J\u0002\u0004\u0004*\u001a!11\u0016\u0005\u000b\u0003WL%\u0011!Q\u0001\n\u0005\u0005\u0001BB4J\t\u0003\u0019\u0019\fC\u0005\u0004<&\u0013\r\u0011\"\u0003\u0004>\"A1QY%!\u0002\u0013\u0019y\fC\u0005\u0004H&\u0013\r\u0011\"\u0003\u0004J\"A1\u0011[%!\u0002\u0013\u0019Y\rC\u0004\u0004T&#\tb!6\t\u000f\re\u0017\n\"\u0011\u0004\\\"91q\\%\u0005B\r\u0005hABBs\r\u0011\u00199\u000f\u0003\u0006\u0002lN\u0013\t\u0011)A\u0005\u0003\u0003A!ba%T\u0005\u0003\u0005\u000b\u0011BA\u0001\u0011\u001997\u000b\"\u0001\u0004j\"911[*\u0005B\rE(!C+o!&\u001c7\u000e\\3s\u0015\tQ6,\u0001\u0005qS\u000e\\G.\u001b8h\u0015\taV,\u0001\u0005j]R,'O\\1m\u0015\tqv,A\u0004sK\u001adWm\u0019;\u000b\u0003\u0001\fQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001GB\u0011A-Z\u0007\u0002?&\u0011am\u0018\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005I\u0007C\u00016\u0001\u001b\u0005I\u0016aC:z[\n|G\u000eV1cY\u0016,\u0012!\u001c\t\u0003]>l\u0011aW\u0005\u0003an\u00131bU=nE>dG+\u00192mK\u0006AQO\u001c9jG.dW\rF\u0005tmz\f9!!\u0007\u0002$A\u0011A\r^\u0005\u0003k~\u0013A!\u00168ji\")qo\u0001a\u0001q\u0006)!-\u001f;fgB\u0019A-_>\n\u0005i|&!B!se\u0006L\bC\u00013}\u0013\tixL\u0001\u0003CsR,\u0007BB@\u0004\u0001\u0004\t\t!\u0001\u0004pM\u001a\u001cX\r\u001e\t\u0004I\u0006\r\u0011bAA\u0003?\n\u0019\u0011J\u001c;\t\u000f\u0005%1\u00011\u0001\u0002\f\u0005I1\r\\1tgJ{w\u000e\u001e\t\u0005\u0003\u001b\t\tBD\u0002\u0002\u0010\ti\u0011\u0001A\u0005\u0005\u0003'\t)BA\u0006DY\u0006\u001c8oU=nE>d\u0017bAA\f7\n91+_7c_2\u001c\bbBA\u000e\u0007\u0001\u0007\u0011QD\u0001\u000b[>$W\u000f\\3S_>$\b\u0003BA\u0007\u0003?IA!!\t\u0002\u0016\taQj\u001c3vY\u0016\u001c\u00160\u001c2pY\"9\u0011QE\u0002A\u0002\u0005\u001d\u0012\u0001\u00034jY\u0016t\u0017-\\3\u0011\t\u0005%\u0012q\u0007\b\u0005\u0003W\t\u0019\u0004E\u0002\u0002.}k!!a\f\u000b\u0007\u0005E\u0012-\u0001\u0004=e>|GOP\u0005\u0004\u0003ky\u0016A\u0002)sK\u0012,g-\u0003\u0003\u0002:\u0005m\"AB*ue&twMC\u0002\u00026}\u000bqbY8na2,G/\u001b8h'R\f7m[\u000b\u0003\u0003\u0003\u0002b!a\u0011\u0002N\u0005ESBAA#\u0015\u0011\t9%!\u0013\u0002\u000f5,H/\u00192mK*\u0019\u00111J0\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0003\u0002P\u0005\u0015#aC!se\u0006L()\u001e4gKJ\u0004B!!\u0004\u0002T%!\u0011QKA\u000b\u0005\u0019\u0019\u00160\u001c2pY\u0006\u00012m\\7qY\u0016$\u0018N\\4Ti\u0006\u001c7\u000e\t\u0002\u0005'\u000e\fgnE\u0002\u0007\u0003;\u00022A[A0\u0013\r\t\t'\u0017\u0002\r!&\u001c7\u000e\\3Ck\u001a4WM]\u0001\u0007?\nLH/Z:\u0015\u0019\u0005\u001d\u0014\u0011NA6\u0003[\ny'!\u001d\u0011\u0007\u0005=a\u0001\u0003\u0004\u0002d1\u0001\r\u0001\u001f\u0005\u0007\u007f2\u0001\r!!\u0001\t\u000f\u0005%A\u00021\u0001\u0002\f!9\u00111\u0004\u0007A\u0002\u0005u\u0001bBA\u0013\u0019\u0001\u0007\u0011qE\u0001\u0006I\u0016\u0014WoZ\u000b\u0003\u0003o\u00022\u0001ZA=\u0013\r\tYh\u0018\u0002\b\u0005>|G.Z1o\u00035aw.\u00193j]\u001el\u0015N\u001d:peV\u0011\u0011\u0011\u0011\t\u0005\u0003\u001b\t\u0019)\u0003\u0003\u0002\u0006\u0006\u001d%AB'jeJ|'/C\u0002\u0002\nn\u0013q!T5se>\u00148/\u0001\bm_\u0006$\u0017N\\4NSJ\u0014xN\u001d\u0011\u0002kM\u001c\u0017\r\\1%e\u00164G.Z2uI%tG/\u001a:oC2$\u0003/[2lY&tw\rJ+o!&\u001c7\u000e\\3sIM\u001b\u0017M\u001c\u0013%S:$W\r_\u000b\u0003\u0003#\u0003B\u0001Z=\u0002\u0002\u000514oY1mC\u0012\u0012XM\u001a7fGR$\u0013N\u001c;fe:\fG\u000e\n9jG.d\u0017N\\4%+:\u0004\u0016nY6mKJ$3kY1oI\u0011Jg\u000eZ3yA\u00059QM\u001c;sS\u0016\u001cXCAAM!\r!\u0017pY\u0001\tK:$(/[3tA\u0005I1/_7TG>\u0004Xm]\u000b\u0003\u0003C\u0003\u0002\"a\u0011\u0002$\u0006E\u0013qU\u0005\u0005\u0003K\u000b)EA\u0004ICNDW*\u00199\u0011\t\u00055\u0011\u0011V\u0005\u0005\u0003W\u000biKA\u0003TG>\u0004X-C\u0002\u00020n\u0013aaU2pa\u0016\u001c\u0018AC:z[N\u001bw\u000e]3tA\u00051Q\r\u001f9fGR$Ra]A\\\u0003wCq!!/\u0017\u0001\u0004\t\t!\u0001\u0005fqB,7\r^3e\u0011!\tiL\u0006CA\u0002\u0005}\u0016aA7tOB)A-!1\u0002(%\u0019\u00111Y0\u0003\u0011q\u0012\u0017P\\1nKz\n!B];o\u0003RLe\u000eZ3y+\u0011\tI-!5\u0015\t\u0005-\u0017\u0011\u001e\u000b\u0005\u0003\u001b\f\u0019\u000f\u0005\u0003\u0002P\u0006EG\u0002\u0001\u0003\b\u0003'<\"\u0019AAk\u0005\u0005!\u0016\u0003BAl\u0003;\u00042\u0001ZAm\u0013\r\tYn\u0018\u0002\b\u001d>$\b.\u001b8h!\r!\u0017q\\\u0005\u0004\u0003C|&aA!os\"A\u0011Q]\f\u0005\u0002\u0004\t9/\u0001\u0003c_\u0012L\b#\u00023\u0002B\u00065\u0007bBAv/\u0001\u0007\u0011\u0011A\u0001\u0002S\"\u001aq#a<\u0011\u0007\u0011\f\t0C\u0002\u0002t~\u0013a!\u001b8mS:,\u0017a\u0001:v]R\t1/\u0001\u0007dQ\u0016\u001c7NV3sg&|g.\u0001\u0005ts6\u001c6m\u001c9f)\u0011\t9+a@\t\u000f\t\u0005!\u00041\u0001\u0002R\u0005\u00191/_7\u0002\u001b%\u001c8+_7c_2,e\u000e\u001e:z)\u0011\t9Ha\u0002\t\u000f\u0005-8\u00041\u0001\u0002\u0002\u0005Y\u0011n]*z[\n|GNU3g)\u0011\t9H!\u0004\t\u000f\u0005-H\u00041\u0001\u0002\u0002\u0005Y\u0011n\u001d(b[\u0016,e\u000e\u001e:z)\u0011\t9Ha\u0005\t\u000f\u0005-X\u00041\u0001\u0002\u0002\u00059\u0012n]*z[\n|G.\u00118o_R\fG/[8o\u000b:$(/\u001f\u000b\u0005\u0003o\u0012I\u0002C\u0004\u0002lz\u0001\r!!\u0001\u0002\u001f%\u001c8\t[5mIJ,g.\u00128uef$B!a\u001e\u0003 !9\u00111^\u0010A\u0002\u0005\u0005\u0011aD7bs\n,'+Z1e'fl'm\u001c7\u0015\u0005\t\u0015\u0002\u0003\u0003B\u0014\u0005[\t\t!!\u0015\u000f\u0007\u0011\u0014I#C\u0002\u0003,}\u000bq\u0001]1dW\u0006<W-\u0003\u0003\u00030\tE\"AB#ji\",'OC\u0002\u0003,}\u000bq#[:SK\u001aLg.Z7f]R\u001c\u00160\u001c2pY\u0016sGO]=\u0015\t\u0005]$q\u0007\u0005\b\u0003W\f\u0003\u0019AA\u0001\u0003\t\tG/\u0006\u0003\u0003>\t\u0005CC\u0002B \u0005\u000b\u00129\u0005\u0005\u0003\u0002P\n\u0005CaBAjE\t\u0007!1I\t\u0004\u0003/\u001c\u0007bBAvE\u0001\u0007\u0011\u0011\u0001\u0005\b\u0005\u0013\u0012\u0003\u0019\u0001B&\u0003\ty\u0007\u000fE\u0003e\u0005\u001b\u0012y$C\u0002\u0003P}\u0013\u0011BR;oGRLwN\u001c\u0019\u0002\u0011I,\u0017\r\u001a(b[\u0016$\"A!\u0016\u0011\t\u00055!qK\u0005\u0005\u00053\u0012YF\u0001\u0003OC6,\u0017b\u0001B/7\n)a*Y7fg\u00069!/Z1e\u000b:$GCAA\u0001\u0003)\u0011X-\u00193Ts6\u0014w\u000e\u001c\u000b\u0003\u0003#\n\u0001B]3bIRK\b/\u001a\u000b\u0005\u0005W\u0012)\b\u0005\u0003\u0002\u000e\t5\u0014\u0002\u0002B8\u0005c\u0012A\u0001V=qK&\u0019!1O.\u0003\u000bQK\b/Z:\t\u0013\t]d\u0005%AA\u0002\u0005]\u0014a\u00044pe\u000e,\u0007K]8qKJ$\u0016\u0010]3\u0002%I,\u0017\r\u001a+za\u0016$C-\u001a4bk2$H%M\u000b\u0003\u0005{RC!a\u001e\u0003\u0000-\u0012!\u0011\u0011\t\u0005\u0005\u0007\u0013i)\u0004\u0002\u0003\u0006*!!q\u0011BE\u0003%)hn\u00195fG.,GMC\u0002\u0003\f~\u000b!\"\u00198o_R\fG/[8o\u0013\u0011\u0011yI!\"\u0003#Ut7\r[3dW\u0016$g+\u0019:jC:\u001cW-A\u0007o_N+8\r\u001b+za\u0016$\u0016m\u001a\u000b\u0007\u0005W\u0012)J!'\t\u000f\t]\u0005\u00061\u0001\u0002\u0002\u0005\u0019A/Y4\t\u000f\tm\u0005\u00061\u0001\u0002\u0002\u0005\u0019QM\u001c3\u0002\u0019I,\u0017\rZ\"p]N$\u0018M\u001c;\u0015\u0005\t\u0005\u0006\u0003BA\u0007\u0005GKAA!*\u0003(\nA1i\u001c8ti\u0006tG/C\u0002\u0003*n\u0013\u0011bQ8ogR\fg\u000e^:\u0002#9|7+^2i\u0007>t7\u000f^1oiR\u000bw\r\u0006\u0004\u0003\"\n=&\u0011\u0017\u0005\b\u0005/S\u0003\u0019AA\u0001\u0011\u001d\u0011\u0019L\u000ba\u0001\u0003\u0003\t1\u0001\\3o\u00031\u0011X-\u00193DQ&dGM]3o\u00031\u0011X-\u00193B]:|G/\u0011:h)\u0011\u0011YL!2\u0011\t\u00055!QX\u0005\u0005\u0005\u007f\u0013\tM\u0001\u0003Ue\u0016,\u0017b\u0001Bb7\n)AK]3fg\"9\u00111\u001e\u0017A\u0002\u0005\u0005\u0011A\u0004:fC\u0012\f%O]1z\u0003:tw\u000e\u001e\u000b\u0003\u0005\u0017\u0004B\u0001Z=\u0003NB!\u0011Q\u0002Bh\u0013\u0011\u0011\tNa5\u0003#\rc\u0017m]:gS2,\u0017I\u001c8pi\u0006\u0013x-C\u0002\u0003Vn\u0013q\"\u00118o_R\fG/[8o\u0013:4wn]\u0001\u0016e\u0016\fGm\u00117bgN4\u0017\u000e\\3B]:|G/\u0011:h)\u0011\u0011iMa7\t\u000f\u0005-h\u00061\u0001\u0002\u0002\u0005\u0011\"/Z1e\u0003:tw\u000e^1uS>t\u0017J\u001c4p)\u0011\u0011\tOa:\u0011\t\u00055!1]\u0005\u0005\u0005K\u0014\u0019N\u0001\bB]:|G/\u0019;j_:LeNZ8\t\u000f\tmu\u00061\u0001\u0002\u0002\u0005!\"/Z1e'fl'm\u001c7B]:|G/\u0019;j_:\faB]3bI\u0006sgn\u001c;bi&|g\u000e\u0006\u0002\u0003b\u0006\u0001\"/Z1e\u001d>tW)\u001c9usR\u0013X-\u001a\u000b\u0007\u0005w\u0013\u0019P!>\t\u000f\t]%\u00071\u0001\u0002\u0002!9!1\u0014\u001aA\u0002\u0005\u0005\u0011\u0001\u0003:fC\u0012$&/Z3\u0015\u0005\tm\u0016!\u00048p'V\u001c\u0007\u000e\u0016:fKR\u000bw\r\u0006\u0004\u0002X\n}8\u0011\u0001\u0005\b\u0005/#\u0004\u0019AA\u0001\u0011\u001d\u0011Y\n\u000ea\u0001\u0003\u0003\tQB]3bI6{G-\u001b4jKJ\u001cHCAB\u0004!\u0011\tia!\u0003\n\t\r-!\u0011\u0019\u0002\n\u001b>$\u0017NZ5feN\fQB]3bINKXNY8m%\u00164\u0017a\u0003:fC\u0012t\u0015-\\3SK\u001a\f1B]3bIRK\b/\u001a*fMR\u0011!1N\u0001\u0010e\u0016\fGmQ8ogR\fg\u000e\u001e*fM\u0006\t\"/Z1e\u0003:tw\u000e^1uS>t'+\u001a4\u0002!I,\u0017\rZ'pI&4\u0017.\u001a:t%\u00164\u0017a\u0003:fC\u0012$&/Z3SK\u001a\fqB]3bIRK\b/\u001a(b[\u0016\u0014VM\u001a\u000b\u0003\u0007C\u0001B!!\u0004\u0004$%!1Q\u0005B.\u0005!!\u0016\u0010]3OC6,\u0017a\u0004:fC\u0012$V-\u001c9mCR,'+\u001a4\u0015\u0005\r-\u0002\u0003BA\u0007\u0007[IAaa\f\u0003B\nAA+Z7qY\u0006$X-\u0001\bsK\u0006$7)Y:f\t\u00164'+\u001a4\u0015\u0005\rU\u0002\u0003BA\u0007\u0007oIAa!\u000f\u0003B\n91)Y:f\t\u00164\u0017!\u0004:fC\u00124\u0016\r\u001c#fMJ+g\r\u0006\u0002\u0004@A!\u0011QBB!\u0013\u0011\u0019\u0019E!1\u0003\rY\u000bG\u000eR3g\u00031\u0011X-\u00193JI\u0016tGOU3g)\t\u0019I\u0005\u0005\u0003\u0002\u000e\r-\u0013\u0002BB'\u0005\u0003\u0014Q!\u00133f]R\faB]3bIRK\b/\u001a#fMJ+g\r\u0006\u0002\u0004TA!\u0011QBB+\u0013\u0011\u00199F!1\u0003\u000fQK\b/\u001a#fM\u0006\u0001\"/Z1e\u001b\u0016l'-\u001a:EK\u001a\u0014VM\u001a\u000b\u0003\u0007;\u0002B!!\u0004\u0004`%!1\u0011\rBa\u0005%iU-\u001c2fe\u0012+g-A\tfeJ|'OQ1e'&<g.\u0019;ve\u0016$B!a6\u0004h!9\u0011Q\u0018#A\u0002\u0005\u001d\u0012AF5oM\u0016\u0014X*\u001a;i_\u0012\fE\u000e^3s]\u0006$\u0018N^3\u0015\u000fM\u001cig!\u001d\u0004|!91qN#A\u0002\tm\u0016a\u00014v]\"911O#A\u0002\rU\u0014aB1sOR\u0004Xm\u001d\t\u0007\u0005O\u00199Ha\u001b\n\t\re$\u0011\u0007\u0002\u0005\u0019&\u001cH\u000fC\u0004\u0004~\u0015\u0003\rAa\u001b\u0002\rI,7\u000f\u001e9f\u00039qWm\u001e'buf$\u0016\u0010]3SK\u001a$Baa!\u0004\nB!\u0011QBBC\u0013\u0011\u00199I!\u001d\u0003\u00111\u000b'0\u001f+za\u0016Dq!a;G\u0001\u0004\t\t!\u0001\foK^d\u0015M_=UsB,'+\u001a4B]\u0012\fE.[1t)\u0019\u0019\u0019ia$\u0004\u0012\"9\u00111^$A\u0002\u0005\u0005\u0001bBBJ\u000f\u0002\u0007\u0011\u0011A\u0001\u0002U\u0006YAo\u001c+za\u0016,%O]8s)\u0011\u0019Ija(\u0011\t\u0005511T\u0005\u0005\u0007;\u0013\tHA\u0005UsB,WI\u001d:pe\"91\u0011\u0015%A\u0002\r\r\u0016!A3\u0011\u00079\u001c)+C\u0002\u0004(n\u0013q#T5tg&twMU3rk&\u0014X-\\3oi\u0016\u0013(o\u001c:\u0003\u00171\u000b'0\u001f+za\u0016\u0014VMZ\n\u0006\u0013\u000e\r5Q\u0016\t\u0005\u0003\u001b\u0019y+\u0003\u0003\u00042\nE$!\u0006$mC\u001e\fuM\\8ti&\u001c7i\\7qY\u0016$XM\u001d\u000b\u0005\u0007k\u001bI\fE\u0002\u00048&k\u0011A\u0002\u0005\b\u0003W\\\u0005\u0019AA\u0001\u00039!WMZ5oK\u0012\fEOU;o\u0013\u0012,\"aa0\u0011\t\u000551\u0011Y\u0005\u0004\u0007\u0007|'!\u0002*v]&#\u0017a\u00043fM&tW\rZ!u%Vt\u0017\n\u001a\u0011\u0002\u0003A,\"aa3\u0011\u00079\u001ci-C\u0002\u0004Pn\u0013Q\u0001\u00155bg\u0016\f!\u0001\u001d\u0011\u0002!\r|W\u000e\u001d7fi\u0016Le\u000e^3s]\u0006dGcA:\u0004X\"9!\u0011\u0001)A\u0002\u0005E\u0013\u0001C2p[BdW\r^3\u0015\u0007M\u001ci\u000eC\u0004\u0003\u0002E\u0003\r!!\u0015\u0002\t1|\u0017\r\u001a\u000b\u0004g\u000e\r\bb\u0002B\u0001%\u0002\u0007\u0011\u0011\u000b\u0002\u0014\u0019\u0006T\u0018\u0010V=qKJ+g-\u00118e\u00032L\u0017m]\n\u0004'\u000eUFCBBv\u0007[\u001cy\u000fE\u0002\u00048NCq!a;W\u0001\u0004\t\t\u0001C\u0004\u0004\u0014Z\u0003\r!!\u0001\u0015\u0007M\u001c\u0019\u0010C\u0004\u0003\u0002]\u0003\r!!\u0015")
public abstract class UnPickler {
    private final ArrayBuffer<Symbols.Symbol> scala$reflect$internal$pickling$UnPickler$$completingStack = new ArrayBuffer(24);

    public abstract SymbolTable symbolTable();

    /*
     * Unable to fully structure code
     */
    public void unpickle(byte[] bytes, int offset, Symbols.ClassSymbol classRoot, Symbols.ModuleSymbol moduleRoot, String filename) {
        try {
            v0 = this.symbolTable();
            v1 = classRoot;
            var6_6 = this.symbolTable().NoSymbol();
            if (!(v1 == null ? var6_6 != null : v1.equals(var6_6) == false)) ** GOTO lbl-1000
            v2 = moduleRoot;
            var7_7 = this.symbolTable().NoSymbol();
            if (v2 == null ? var7_7 != null : v2.equals(var7_7) == false) {
                v3 = true;
            } else lbl-1000:
            // 2 sources

            {
                v3 = var12_8 = false;
            }
            if (v0 == null) {
                throw null;
            }
            assert_this = v0;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(UnPickler.$anonfun$unpickle$1(classRoot, moduleRoot));
            }
            new Scan(this, bytes, offset, classRoot, moduleRoot, filename).run();
            return;
        }
        catch (Throwable var8_10) {
            var9_11 = NonFatal$.MODULE$.unapply(var8_10);
            if (!var9_11.isEmpty()) {
                ex = var9_11.get();
                ex.printStackTrace();
                throw new RuntimeException(new StringBuilder(35).append("error reading Scala signature of ").append(filename).append(": ").append(ex.getMessage()).toString());
            }
            throw var8_10;
        }
    }

    public ArrayBuffer<Symbols.Symbol> scala$reflect$internal$pickling$UnPickler$$completingStack() {
        return this.scala$reflect$internal$pickling$UnPickler$$completingStack;
    }

    public static final /* synthetic */ String $anonfun$unpickle$1(Symbols.ClassSymbol classRoot$1, Symbols.ModuleSymbol moduleRoot$1) {
        return new StringBuilder(52).append("The Unpickler expects a class and module symbol: ").append(classRoot$1).append(" - ").append(moduleRoot$1).toString();
    }

    public class Scan
    extends PickleBuffer {
        private final Symbols.ClassSymbol classRoot;
        private final Symbols.ModuleSymbol moduleRoot;
        private final String filename;
        private final Mirrors.RootsBase loadingMirror;
        private final int[] scala$reflect$internal$pickling$UnPickler$Scan$$index;
        private final Object[] entries;
        private final HashMap<Symbols.Symbol, Scopes.Scope> symScopes;
        public final /* synthetic */ UnPickler $outer;

        public boolean debug() {
            return BoxesRunTime.unboxToBoolean(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().settings().debug().value());
        }

        private Mirrors.RootsBase loadingMirror() {
            return this.loadingMirror;
        }

        public int[] scala$reflect$internal$pickling$UnPickler$Scan$$index() {
            return this.scala$reflect$internal$pickling$UnPickler$Scan$$index;
        }

        private Object[] entries() {
            return this.entries;
        }

        private HashMap<Symbols.Symbol, Scopes.Scope> symScopes() {
            return this.symScopes;
        }

        private void expect(int expected, Function0<String> msg) {
            int tag = this.readByte();
            if (tag != expected) {
                throw this.errorBadSignature(new StringBuilder(3).append((Object)msg.apply()).append(" (").append(tag).append(")").toString());
            }
        }

        private <T> T runAtIndex(int i, Function0<T> body) {
            T t;
            int saved = this.readIndex();
            this.readIndex_$eq(this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]);
            try {
                t = body.apply();
            }
            finally {
                this.readIndex_$eq(saved);
            }
            return t;
        }

        public void run() {
            IntRef i = IntRef.create(0);
            while (i.elem < this.scala$reflect$internal$pickling$UnPickler$Scan$$index().length) {
                if (this.entries()[i.elem] == null && this.isSymbolEntry(i.elem)) {
                    int runAtIndex_i = i.elem;
                    int runAtIndex_saved = this.readIndex();
                    this.readIndex_$eq(this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[runAtIndex_i]);
                    try {
                        this.entries()[i.elem] = this.readSymbol();
                    }
                    finally {
                        this.readIndex_$eq(runAtIndex_saved);
                    }
                }
                ++i.elem;
            }
            i.elem = 0;
            while (i.elem < this.scala$reflect$internal$pickling$UnPickler$Scan$$index().length) {
                if (this.entries()[i.elem] == null) {
                    if (this.isSymbolAnnotationEntry(i.elem)) {
                        int runAtIndex_i = i.elem;
                        int runAtIndex_saved = this.readIndex();
                        this.readIndex_$eq(this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[runAtIndex_i]);
                        try {
                            this.readSymbolAnnotation();
                        }
                        finally {
                            this.readIndex_$eq(runAtIndex_saved);
                        }
                    }
                    if (this.isChildrenEntry(i.elem)) {
                        int runAtIndex_i = i.elem;
                        int runAtIndex_saved = this.readIndex();
                        this.readIndex_$eq(this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[runAtIndex_i]);
                        try {
                            this.readChildren();
                        }
                        finally {
                            this.readIndex_$eq(runAtIndex_saved);
                        }
                    }
                }
                ++i.elem;
            }
        }

        private void checkVersion() {
            int major = this.readNat();
            int minor = this.readNat();
            if (major != PickleFormat$.MODULE$.MajorVersion() || minor > PickleFormat$.MODULE$.MinorVersion()) {
                throw new IOException(new StringBuilder(61).append("Scala signature ").append(this.classRoot.decodedName()).append(" has wrong version\n expected: ").append(PickleFormat$.MODULE$.MajorVersion()).append(".").append(PickleFormat$.MODULE$.MinorVersion()).append("\n found: ").append(major).append(".").append(minor).append(" in ").append(this.filename).toString());
            }
        }

        public Scopes.Scope symScope(Symbols.Symbol sym) {
            return this.symScopes().getOrElseUpdate(sym, (Function0<Scopes.Scope> & java.io.Serializable & Serializable)() -> this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().newScope());
        }

        public boolean isSymbolEntry(int i) {
            byte tag = this.bytes()[this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]];
            return 3 <= tag && tag <= 8 && (tag != 6 || !this.isRefinementSymbolEntry(i));
        }

        public boolean isSymbolRef(int i) {
            byte tag = this.bytes()[this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]];
            return 3 <= tag && tag <= 10;
        }

        public boolean isNameEntry(int i) {
            byte tag = this.bytes()[this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]];
            return tag == 1 || tag == 2;
        }

        public boolean isSymbolAnnotationEntry(int i) {
            return this.bytes()[this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]] == 40;
        }

        public boolean isChildrenEntry(int i) {
            return this.bytes()[this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]] == 41;
        }

        private Either<Object, Symbols.Symbol> maybeReadSymbol() {
            int n = this.readNat();
            switch (n) {
                default: 
            }
            if (this.isSymbolRef(n)) {
                return package$.MODULE$.Right().apply(this.at(n, (Function0<Symbols.Symbol> & java.io.Serializable & Serializable)() -> this.readSymbol()));
            }
            return package$.MODULE$.Left().apply(BoxesRunTime.boxToInteger(n));
        }

        public boolean isRefinementSymbolEntry(int i) {
            int savedIndex = this.readIndex();
            this.readIndex_$eq(this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]);
            int tag = this.readByte();
            this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().assert(tag == 6);
            this.readNat();
            Names.Name name = this.readNameRef();
            Names.TypeName typeName = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().tpnme().REFINE_CLASS_NAME();
            boolean result2 = !(name != null ? !name.equals(typeName) : typeName != null);
            this.readIndex_$eq(savedIndex);
            return result2;
        }

        /*
         * WARNING - void declaration
         */
        public <T> T at(int i, Function0<T> op) {
            void var3_3;
            Object r = this.entries()[i];
            if (r == null) {
                void assert_assertion;
                boolean bl;
                int savedIndex = this.readIndex();
                this.readIndex_$eq(this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]);
                r = op.apply();
                SymbolTable symbolTable = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable();
                boolean bl2 = bl = this.entries()[i] == null;
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable assert_this = symbolTable;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(Scan.$anonfun$at$1(this, i));
                }
                this.entries()[i] = r;
                this.readIndex_$eq(savedIndex);
            }
            return var3_3;
        }

        public Names.Name readName() {
            int tag = this.readByte();
            int len = this.readNat();
            switch (tag) {
                case 1: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().newTermName(this.bytes(), this.readIndex(), len);
                }
                case 2: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().newTypeName(this.bytes(), this.readIndex(), len);
                }
            }
            throw this.errorBadSignature(new StringBuilder(14).append("bad name tag: ").append(tag).toString());
        }

        private int readEnd() {
            return this.readNat() + this.readIndex();
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol readSymbol() {
            void var11_15;
            Symbols.Symbol symbol;
            Symbols.Symbol symbol2;
            int n;
            int tag = this.readByte();
            int end = this.readEnd();
            switch (tag) {
                case 3: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoSymbol();
                }
                case 9: 
                case 10: {
                    return this.readExtSymbol$1(tag, end);
                }
            }
            int nameref = this.readNat();
            Names.Name name = (Names.Name)this.at(nameref, (Function0<Names.Name> & java.io.Serializable & Serializable)() -> this.readName());
            Symbols.Symbol owner = this.readSymbolRef();
            long flags = Flags$.MODULE$.pickledToRawFlags().apply$mcJJ$sp(this.readLongNat());
            Either<Object, Symbols.Symbol> either = this.maybeReadSymbol();
            if (either instanceof Left) {
                int index = BoxesRunTime.unboxToInt(((Left)either).value());
                Symbols.NoSymbol noSymbol = Predef$.MODULE$.ArrowAssoc(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoSymbol());
                if (Predef$ArrowAssoc$.MODULE$ == null) {
                    throw null;
                }
                n = index;
                symbol2 = noSymbol;
            } else if (either instanceof Right) {
                Symbols.Symbol sym = (Symbols.Symbol)((Right)either).value();
                int n2 = this.readNat();
                Symbols.Symbol symbol3 = Predef$.MODULE$.ArrowAssoc(sym);
                if (Predef$ArrowAssoc$.MODULE$ == null) {
                    throw null;
                }
                n = n2;
                symbol2 = symbol3;
            } else {
                throw new MatchError(either);
            }
            Symbols.Symbol privateWithin = symbol2;
            switch (tag) {
                case 4: 
                case 5: {
                    symbol = owner.newNonClassSymbol(name.toTypeName(), this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoPosition(), Scan.pflags$1(flags));
                    break;
                }
                case 6: {
                    Symbols.Symbol sym;
                    Symbols.Symbol symbol4 = Scan.isModuleFlag$1(flags) && this.isModuleClassRoot$1(name, owner) ? this.moduleRoot.moduleClass().setFlag(Scan.pflags$1(flags)) : (sym = !Scan.isModuleFlag$1(flags) && this.isClassRoot$1(name, owner) ? this.classRoot.setFlag(Scan.pflags$1(flags)) : owner.newClassSymbol(name.toTypeName(), this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoPosition(), Scan.pflags$1(flags)));
                    if (!this.atEnd$1(end)) {
                        sym.typeOfThis_$eq(this.newLazyTypeRef(this.readNat()));
                    }
                    symbol = sym;
                    break;
                }
                case 7: {
                    Symbols.Symbol moduleClass = ((Types.Type)this.at(n, (Function0<Types.Type> & java.io.Serializable & Serializable)() -> this.readType(this.readType$default$1()))).typeSymbol();
                    if (this.isModuleRoot$1(name, owner)) {
                        symbol = this.moduleRoot.setFlag(Scan.pflags$1(flags));
                        break;
                    }
                    symbol = owner.newLinkedModule(moduleClass, Scan.pflags$1(flags));
                    break;
                }
                case 8: {
                    if (this.isModuleRoot$1(name, owner)) {
                        throw this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().abort(new StringBuilder(40).append("VALsym at module root: owner = ").append(owner).append(", name = ").append(name).toString());
                    }
                    symbol = owner.newTermSymbol(name.toTermName(), this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoPosition(), Scan.pflags$1(flags));
                    break;
                }
                default: {
                    throw this.errorBadSignature(new StringBuilder(16).append("bad symbol tag: ").append(tag).toString());
                }
            }
            return this.finishSym$1(symbol, (Symbols.Symbol)var11_15, n, end);
        }

        public Types.Type readType(boolean forceProperType) {
            int tag = this.readByte();
            int end = this.readEnd();
            switch (tag) {
                case 11: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoType();
                }
                case 12: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoPrefix();
                }
                case 13: {
                    return this.readThisType$1();
                }
                case 14: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().SingleType().apply(this.readTypeRef(), (Symbols.Symbol)this.readSymbolRef().filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(x$2.isStable())));
                }
                case 46: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().SuperType().apply(this.readTypeRef(), this.readTypeRef());
                }
                case 15: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().ConstantType().apply(this.readConstantRef());
                }
                case 16: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().TypeRef().apply(this.readTypeRef(), this.readSymbolRef(), this.readTypes$1(end));
                }
                case 17: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().TypeBounds().apply(this.readTypeRef(), this.readTypeRef());
                }
                case 18: 
                case 19: {
                    return this.CompoundType$1(this.readSymbolRef(), this.readTypes$1(end), tag);
                }
                case 20: {
                    return this.MethodTypeRef$1(this.readTypeRef(), this.readSymbols$1(end));
                }
                case 21: {
                    return this.PolyOrNullaryType$1(this.readTypeRef(), this.readSymbols$1(end));
                }
                case 48: {
                    Types.Type x$1 = this.readTypeRef();
                    List x$22 = this.readSymbols$1(end);
                    return new Types.ExistentialType(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), x$22, x$1);
                }
                case 42: {
                    Types.Type x$3 = this.readTypeRef();
                    List x$4 = this.readAnnots$1(end);
                    return new Types.AnnotatedType(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), x$4, x$3);
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(tag));
        }

        public boolean readType$default$1() {
            return false;
        }

        public Types.Type noSuchTypeTag(int tag, int end) {
            throw this.errorBadSignature(new StringBuilder(14).append("bad type tag: ").append(tag).toString());
        }

        public Constants.Constant readConstant() {
            int tag = this.readByte();
            int len = this.readNat();
            switch (tag) {
                case 24: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxedUnit.UNIT);
                }
                case 25: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToBoolean(this.readLong(len) != 0L));
                }
                case 26: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToByte((byte)this.readLong(len)));
                }
                case 27: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToShort((short)this.readLong(len)));
                }
                case 28: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToCharacter((char)this.readLong(len)));
                }
                case 29: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToInteger((int)this.readLong(len)));
                }
                case 30: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToLong(this.readLong(len)));
                }
                case 31: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToFloat(Float.intBitsToFloat((int)this.readLong(len))));
                }
                case 32: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), BoxesRunTime.boxToDouble(Double.longBitsToDouble(this.readLong(len))));
                }
                case 33: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.readNameRef().toString());
                }
                case 34: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), null);
                }
                case 35: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.readTypeRef());
                }
                case 36: {
                    return new Constants.Constant(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.readSymbolRef());
                }
            }
            return this.noSuchConstantTag(tag, len);
        }

        public Constants.Constant noSuchConstantTag(int tag, int len) {
            throw this.errorBadSignature(new StringBuilder(18).append("bad constant tag: ").append(tag).toString());
        }

        public void readChildren() {
            int tag = this.readByte();
            this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().assert(tag == 41);
            int end = this.readEnd();
            Symbols.Symbol target = this.readSymbolRef();
            while (this.readIndex() != end) {
                target.addChild(this.readSymbolRef());
            }
        }

        public Trees.Tree readAnnotArg(int i) {
            switch (this.bytes()[this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]]) {
                case 49: {
                    return (Trees.Tree)this.at(i, (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.readTree());
                }
            }
            Constants.Constant constant = (Constants.Constant)this.at(i, (Function0<Constants.Constant> & java.io.Serializable & Serializable)() -> this.readConstant());
            return new Trees.Literal(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), constant).setType(constant.tpe());
        }

        private AnnotationInfos.ClassfileAnnotArg[] readArrayAnnot() {
            this.readByte();
            int end = this.readEnd();
            return (AnnotationInfos.ClassfileAnnotArg[])this.until(end, (Function0<AnnotationInfos.ClassfileAnnotArg> & java.io.Serializable & Serializable)() -> this.readClassfileAnnotArg(this.readNat())).toArray(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().JavaArgumentTag());
        }

        public AnnotationInfos.ClassfileAnnotArg readClassfileAnnotArg(int i) {
            switch (this.bytes()[this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]]) {
                case 43: {
                    return new AnnotationInfos.NestedAnnotArg(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), (AnnotationInfos.AnnotationInfo)this.at(i, (Function0<AnnotationInfos.AnnotationInfo> & java.io.Serializable & Serializable)() -> this.readAnnotation()));
                }
                case 44: {
                    return (AnnotationInfos.ClassfileAnnotArg)this.at(i, (Function0<AnnotationInfos.ArrayAnnotArg> & java.io.Serializable & Serializable)() -> new AnnotationInfos.ArrayAnnotArg(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.readArrayAnnot()));
                }
            }
            return new AnnotationInfos.LiteralAnnotArg(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), (Constants.Constant)this.at(i, (Function0<Constants.Constant> & java.io.Serializable & Serializable)() -> this.readConstant()));
        }

        public AnnotationInfos.AnnotationInfo readAnnotationInfo(int end) {
            Types.Type atp = this.readTypeRef();
            ListBuffer args2 = new ListBuffer();
            ListBuffer assocs = new ListBuffer();
            while (this.readIndex() != end) {
                int argref = this.readNat();
                if (this.isNameEntry(argref)) {
                    Names.Name name = (Names.Name)this.at(argref, (Function0<Names.Name> & java.io.Serializable & Serializable)() -> this.readName());
                    AnnotationInfos.ClassfileAnnotArg arg = this.readClassfileAnnotArg(this.readNat());
                    assocs.$plus$eq(new Tuple2<Names.Name, AnnotationInfos.ClassfileAnnotArg>(name, arg));
                    continue;
                }
                args2.$plus$eq(this.readAnnotArg(argref));
            }
            return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().AnnotationInfo().apply(atp, args2.toList(), assocs.toList());
        }

        public void readSymbolAnnotation() {
            int expect_expected = 40;
            int expect_tag = this.readByte();
            if (expect_tag != expect_expected) {
                throw this.errorBadSignature(new StringBuilder(3).append((Object)Scan.$anonfun$readSymbolAnnotation$1()).append(" (").append(expect_tag).append(")").toString());
            }
            int end = this.readEnd();
            this.readSymbolRef().addAnnotation(this.readAnnotationInfo(end));
        }

        public AnnotationInfos.AnnotationInfo readAnnotation() {
            int tag = this.readByte();
            if (tag != 43) {
                throw this.errorBadSignature(new StringBuilder(22).append("annotation expected (").append(tag).append(")").toString());
            }
            int end = this.readEnd();
            return this.readAnnotationInfo(end);
        }

        private Trees.Tree readNonEmptyTree(int tag, int end) {
            Types.Type tpe = this.readTypeRef();
            Symbols.Symbol sym = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().isTreeSymbolPickled(tag) ? this.readSymbolRef() : null;
            Trees.Tree result2 = this.readTree$1(tpe, tag, end);
            if (sym != null) {
                result2.setSymbol(sym);
            }
            return result2.setType(tpe);
        }

        public Trees.Tree readTree() {
            int expect_expected = 49;
            int expect_tag = this.readByte();
            if (expect_tag != expect_expected) {
                throw this.errorBadSignature(new StringBuilder(3).append((Object)Scan.$anonfun$readTree$1()).append(" (").append(expect_tag).append(")").toString());
            }
            int end = this.readEnd();
            int n = this.readByte();
            switch (n) {
                case 1: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().EmptyTree();
                }
            }
            return this.readNonEmptyTree(n, end);
        }

        public Nothing$ noSuchTreeTag(int tag, int end) {
            return this.errorBadSignature(new StringBuilder(20).append("unknown tree type (").append(tag).append(")").toString());
        }

        public Trees.Modifiers readModifiers() {
            int tag = this.readNat();
            if (tag != 50) {
                throw this.errorBadSignature(new StringBuilder(27).append("expected a modifiers tag (").append(tag).append(")").toString());
            }
            this.readEnd();
            int pflagsHi = this.readNat();
            int pflagsLo = this.readNat();
            long pflags = ((long)pflagsHi << 32) + (long)pflagsLo;
            long flags = Flags$.MODULE$.pickledToRawFlags().apply$mcJJ$sp(pflags);
            Names.Name privateWithin = this.readNameRef();
            return new Trees.Modifiers(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), flags, privateWithin, Nil$.MODULE$);
        }

        /*
         * WARNING - void declaration
         */
        public Symbols.Symbol readSymbolRef() {
            int i = this.readNat();
            Object r = this.entries()[i];
            if (r == null) {
                void assert_assertion;
                boolean bl;
                int savedIndex = this.readIndex();
                this.readIndex_$eq(this.scala$reflect$internal$pickling$UnPickler$Scan$$index()[i]);
                r = this.readSymbol();
                SymbolTable symbolTable = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable();
                boolean bl2 = bl = this.entries()[i] == null;
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable assert_this = symbolTable;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(Scan.$anonfun$readSymbolRef$1(this, i));
                }
                this.entries()[i] = r;
                this.readIndex_$eq(savedIndex);
            }
            return (Symbols.Symbol)r;
        }

        public Names.Name readNameRef() {
            return (Names.Name)this.at(this.readNat(), (Function0<Names.Name> & java.io.Serializable & Serializable)() -> this.readName());
        }

        public Types.Type readTypeRef() {
            return (Types.Type)this.at(this.readNat(), (Function0<Types.Type> & java.io.Serializable & Serializable)() -> this.readType(this.readType$default$1()));
        }

        public Constants.Constant readConstantRef() {
            return (Constants.Constant)this.at(this.readNat(), (Function0<Constants.Constant> & java.io.Serializable & Serializable)() -> this.readConstant());
        }

        public AnnotationInfos.AnnotationInfo readAnnotationRef() {
            return (AnnotationInfos.AnnotationInfo)this.at(this.readNat(), (Function0<AnnotationInfos.AnnotationInfo> & java.io.Serializable & Serializable)() -> this.readAnnotation());
        }

        public Trees.Modifiers readModifiersRef() {
            return (Trees.Modifiers)this.at(this.readNat(), (Function0<Trees.Modifiers> & java.io.Serializable & Serializable)() -> this.readModifiers());
        }

        public Trees.Tree readTreeRef() {
            return (Trees.Tree)this.at(this.readNat(), (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.readTree());
        }

        public Names.TypeName readTypeNameRef() {
            return this.readNameRef().toTypeName();
        }

        public Trees.Template readTemplateRef() {
            Trees.Tree tree = this.readTreeRef();
            if (!(tree instanceof Trees.Template)) {
                throw this.errorBadSignature(new StringBuilder(22).append("expected a template (").append(tree).append(")").toString());
            }
            Trees.Template template = (Trees.Template)tree;
            return template;
        }

        public Trees.CaseDef readCaseDefRef() {
            Trees.Tree tree = this.readTreeRef();
            if (!(tree instanceof Trees.CaseDef)) {
                throw this.errorBadSignature(new StringBuilder(22).append("expected a case def (").append(tree).append(")").toString());
            }
            Trees.CaseDef caseDef = (Trees.CaseDef)tree;
            return caseDef;
        }

        public Trees.ValDef readValDefRef() {
            Trees.Tree tree = this.readTreeRef();
            if (!(tree instanceof Trees.ValDef)) {
                throw this.errorBadSignature(new StringBuilder(20).append("expected a ValDef (").append(tree).append(")").toString());
            }
            Trees.ValDef valDef = (Trees.ValDef)tree;
            return valDef;
        }

        public Trees.Ident readIdentRef() {
            Trees.Tree tree = this.readTreeRef();
            if (!(tree instanceof Trees.Ident)) {
                throw this.errorBadSignature(new StringBuilder(20).append("expected an Ident (").append(tree).append(")").toString());
            }
            Trees.Ident ident = (Trees.Ident)tree;
            return ident;
        }

        public Trees.TypeDef readTypeDefRef() {
            Trees.Tree tree = this.readTreeRef();
            if (!(tree instanceof Trees.TypeDef)) {
                throw this.errorBadSignature(new StringBuilder(22).append("expected an TypeDef (").append(tree).append(")").toString());
            }
            Trees.TypeDef typeDef = (Trees.TypeDef)tree;
            return typeDef;
        }

        public Trees.MemberDef readMemberDefRef() {
            Trees.Tree tree = this.readTreeRef();
            if (!(tree instanceof Trees.MemberDef)) {
                throw this.errorBadSignature(new StringBuilder(24).append("expected an MemberDef (").append(tree).append(")").toString());
            }
            Trees.MemberDef memberDef = (Trees.MemberDef)tree;
            return memberDef;
        }

        public Nothing$ errorBadSignature(String msg) {
            throw new RuntimeException(new StringBuilder(35).append("malformed Scala signature of ").append(this.classRoot.name()).append(" at ").append(this.readIndex()).append("; ").append(msg).toString());
        }

        public void inferMethodAlternative(Trees.Tree fun, List<Types.Type> argtpes, Types.Type restpe) {
        }

        public Types.LazyType newLazyTypeRef(int i) {
            return new LazyTypeRef(this, i);
        }

        public Types.LazyType newLazyTypeRefAndAlias(int i, int j) {
            return new LazyTypeRefAndAlias(this, i, j);
        }

        public Types.TypeError toTypeError(MissingRequirementError e) {
            return new Types.TypeError(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), e.msg());
        }

        public /* synthetic */ UnPickler scala$reflect$internal$pickling$UnPickler$Scan$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ Object $anonfun$at$1(Scan $this, int i$2) {
            return $this.entries()[i$2];
        }

        private final boolean atEnd$1(int end$1) {
            return this.readIndex() == end$1;
        }

        private static final Symbols.Symbol adjust$1(Symbols.Symbol sym, int tag$1) {
            if (tag$1 == 9) {
                return sym;
            }
            return sym.moduleClass();
        }

        private final Symbols.Symbol fromName$1(Names.Name name, Symbols.Symbol owner$1, int tag$1) {
            Symbols.Symbol symbol;
            Names.TermName termName = name.toTermName();
            Names.Name name2 = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().nme().ROOT();
            if (!(name2 != null ? !name2.equals(termName) : termName != null)) {
                symbol = this.loadingMirror().RootClass();
            } else {
                Names.TermName termName2 = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().nme().ROOTPKG();
                if (!(termName2 != null ? !termName2.equals(termName) : termName != null)) {
                    symbol = this.loadingMirror().RootPackage();
                } else {
                    Symbols.Symbol symbol2 = owner$1 instanceof Symbols.StubSymbol ? this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoSymbol() : owner$1.info().decl(name);
                    symbol = Scan.adjust$1(symbol2, tag$1);
                }
            }
            return symbol;
        }

        public static final /* synthetic */ String $anonfun$readSymbol$1(Tuple2 x0$1) {
            String string;
            if (x0$1 != null) {
                String group = (String)x0$1._1();
                String art = (String)x0$1._2();
                string = new StringBuilder(169).append("\n(NOTE: It looks like the ").append(art).append(" module is missing; try adding a dependency on \"").append(group).append("\" : \"").append(art).append("\".\n               |       See http://docs.scala-lang.org/overviews/ for more information.)").toString();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
            } else {
                throw new MatchError((Object)null);
            }
            String string2 = new StringOps(string).stripMargin();
            return string2;
        }

        public static final /* synthetic */ String $anonfun$readSymbol$2() {
            return "";
        }

        private static final String moduleAdvice$1(String missing) {
            Option module;
            Option option = missing.startsWith("scala.xml") ? new Some<Tuple2<String, String>>(new Tuple2<String, String>("org.scala-lang.modules", "scala-xml")) : (missing.startsWith("scala.util.parsing") ? new Some<Tuple2<String, String>>(new Tuple2<String, String>("org.scala-lang.modules", "scala-parser-combinators")) : (module = missing.startsWith("scala.swing") ? new Some<Tuple2<String, String>>(new Tuple2<String, String>("org.scala-lang.modules", "scala-swing")) : None$.MODULE$));
            if (module == null) {
                throw null;
            }
            Option option2 = module.isEmpty() ? None$.MODULE$ : new Some<String>(Scan.$anonfun$readSymbol$1((Tuple2)module.get()));
            if (option2 == null) {
                throw null;
            }
            String string = option2.isEmpty() ? Scan.$anonfun$readSymbol$2() : option2.get();
            return string;
        }

        private final Symbols.Symbol localDummy$1(Names.Name name$1, Symbols.Symbol owner$1) {
            if (this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().nme().isLocalDummyName(name$1)) {
                return owner$1.newLocalDummy(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoPosition());
            }
            return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoSymbol();
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$readSymbol$6(Scan $this, Symbols.Symbol owner$1, Names.Name name$1, int tag$1) {
            String advice = Scan.moduleAdvice$1(new StringBuilder(1).append(owner$1.fullName()).append(".").append(name$1).toString());
            Symbols.NoSymbol lazyCompletingSymbol = $this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().scala$reflect$internal$pickling$UnPickler$$completingStack().isEmpty() ? $this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoSymbol() : $this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().scala$reflect$internal$pickling$UnPickler$$completingStack().apply($this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().scala$reflect$internal$pickling$UnPickler$$completingStack().length() - 1);
            String string = new StringBuilder(318).append("|Symbol '").append(name$1.nameKind()).append(" ").append(owner$1.fullName()).append(".").append(name$1).append("' is missing from the classpath.\n                    |This symbol is required by '").append(lazyCompletingSymbol.kindString()).append(" ").append(lazyCompletingSymbol.fullName()).append("'.\n                    |Make sure that ").append(name$1.longString()).append(" is in your classpath and check for conflicting dependencies with `-Ylog-classpath`.\n                    |A full rebuild may help if '").append($this.filename).append("' was compiled against an incompatible version of ").append(owner$1.fullName()).append(".").append(advice).toString();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            String missingMessage = new StringOps(string).stripMargin();
            Names.Name stubName = tag$1 == 9 ? name$1 : name$1.toTypeName();
            return owner$1.newStubSymbol(stubName, missingMessage);
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$readSymbol$5(Scan $this, Symbols.Symbol owner$1, Names.Name name$1, int tag$1) {
            Symbols.Symbol symbol = Scan.adjust$1($this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().mirrorThatLoaded(owner$1).missingHook(owner$1, name$1), tag$1);
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol;
            if (orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return orElse_this;
            }
            return Scan.$anonfun$readSymbol$6($this, owner$1, name$1, tag$1);
        }

        public static final /* synthetic */ Symbols.Symbol $anonfun$readSymbol$4(Scan $this, Names.Name name$1, Symbols.Symbol owner$1, int tag$1) {
            Symbols.Symbol symbol = $this.fromName$1($this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().nme().expandedName(name$1.toTermName(), owner$1), owner$1, tag$1);
            if (symbol == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol;
            if (orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return orElse_this;
            }
            return Scan.$anonfun$readSymbol$5($this, owner$1, name$1, tag$1);
        }

        private final Symbols.Symbol readExtSymbol$1(int tag$1, int end$1) {
            Symbols.Symbol symbol;
            Symbols.Symbol owner;
            Names.Name name = this.readNameRef();
            Symbols.Symbol symbol2 = owner = this.atEnd$1(end$1) ? this.loadingMirror().RootClass() : this.readSymbolRef();
            Symbols.ClassSymbol classSymbol = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().definitions().ScalaPackageClass();
            if (!(symbol2 != null ? !symbol2.equals(classSymbol) : classSymbol != null)) {
                Names.Name name2 = name;
                Names.Name name3 = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().tpnme().AnyRef();
                if (!(name2 != null ? !name2.equals(name3) : name3 != null)) {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().definitions().AnyRefClass();
                }
            }
            Symbols.Symbol symbol3 = this.localDummy$1(name, owner);
            if (symbol3 == null) {
                throw null;
            }
            Symbols.Symbol orElse_this = symbol3;
            Symbols.Symbol symbol4 = symbol = orElse_this != orElse_this.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol() ? orElse_this : this.fromName$1(name, owner, tag$1);
            if (symbol == null) {
                throw null;
            }
            if (symbol != symbol.scala$reflect$internal$Symbols$Symbol$$$outer().NoSymbol()) {
                return symbol;
            }
            return Scan.$anonfun$readSymbol$4(this, name, owner, tag$1);
        }

        private static final boolean isModuleFlag$1(long flags$1) {
            return (flags$1 & 0x100L) != 0L;
        }

        private final boolean isClassRoot$1(Names.Name name$2, Symbols.Symbol owner$2) {
            Names.Name name = name$2;
            Names.Name name2 = this.classRoot.name();
            if (!(name != null ? !name.equals(name2) : name2 != null)) {
                Symbols.Symbol symbol = owner$2;
                Symbols.Symbol symbol2 = this.classRoot.owner();
                if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isModuleRoot$1(Names.Name name$2, Symbols.Symbol owner$2) {
            Names.Name name = name$2;
            Names.Name name2 = this.moduleRoot.name();
            if (!(name != null ? !name.equals(name2) : name2 != null)) {
                Symbols.Symbol symbol = owner$2;
                Symbols.Symbol symbol2 = this.moduleRoot.owner();
                if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isModuleClassRoot$1(Names.Name name$2, Symbols.Symbol owner$2) {
            Names.Name name = name$2;
            Names.TypeName typeName = ((Names.TermName)this.moduleRoot.name()).toTypeName();
            if (!(name != null ? !name.equals(typeName) : typeName != null)) {
                Symbols.Symbol symbol = owner$2;
                Symbols.Symbol symbol2 = this.moduleRoot.owner();
                if (!(symbol != null ? !symbol.equals(symbol2) : symbol2 != null)) {
                    return true;
                }
            }
            return false;
        }

        private static final long pflags$1(long flags$1) {
            return flags$1 & Flags$.MODULE$.PickledFlags();
        }

        private final boolean shouldEnterInOwnerScope$1(Symbols.Symbol sym$1) {
            if (sym$1.owner().isClass() && !sym$1.equals(this.classRoot)) {
                Symbols.Symbol symbol = sym$1;
                Symbols.ModuleSymbol moduleSymbol = this.moduleRoot;
                if (!(!(symbol == null ? moduleSymbol != null : !symbol.equals(moduleSymbol)) || sym$1.isModuleClass() || sym$1.isRefinementClass() || sym$1.isTypeParameter() || sym$1.isExistentiallyBound())) {
                    Names.Name name = sym$1.rawname();
                    Names.TypeName typeName = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().tpnme().LOCAL_CHILD();
                    if ((name == null ? typeName != null : !name.equals(typeName)) && !this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().nme().isLocalDummyName(sym$1.rawname())) {
                        return true;
                    }
                }
            }
            return false;
        }

        /*
         * WARNING - void declaration
         */
        private final Symbols.Symbol finishSym$1(Symbols.Symbol sym, Symbols.Symbol privateWithin$1, int inforef$1, int end$1) {
            Types.LazyType lazyType;
            this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().markFlagsCompleted(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{sym}), -1L);
            sym.privateWithin_$eq(privateWithin$1);
            if (this.atEnd$1(end$1)) {
                void assert_assertion;
                boolean bl;
                SymbolTable symbolTable = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable();
                boolean bl2 = bl = !sym.isSuperAccessor();
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable assert_this = symbolTable;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(sym);
                }
                lazyType = this.newLazyTypeRef(inforef$1);
            } else {
                void assert_assertion;
                boolean bl;
                SymbolTable symbolTable = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable();
                boolean bl3 = bl = sym.isSuperAccessor() || sym.isParamAccessor();
                if (symbolTable == null) {
                    throw null;
                }
                SymbolTable assert_this = symbolTable;
                if (assert_assertion == false) {
                    throw assert_this.throwAssertionError(sym);
                }
                lazyType = this.newLazyTypeRefAndAlias(inforef$1, this.readNat());
            }
            sym.info_$eq(lazyType);
            if (this.shouldEnterInOwnerScope$1(sym)) {
                this.symScope(sym.owner()).enter(sym);
            }
            return sym;
        }

        private final List all$1(Function0 body, int end$2) {
            return this.until(end$2, body);
        }

        private final List readTypes$1(int end$2) {
            Function0<Types.Type> & java.io.Serializable & Serializable all$1_body = (Function0<Types.Type> & java.io.Serializable & Serializable)() -> this.readTypeRef();
            return this.until(end$2, all$1_body);
        }

        private final List readSymbols$1(int end$2) {
            Function0<Symbols.Symbol> & java.io.Serializable & Serializable all$1_body = (Function0<Symbols.Symbol> & java.io.Serializable & Serializable)() -> this.readSymbolRef();
            return this.until(end$2, all$1_body);
        }

        private final List readAnnots$1(int end$2) {
            Function0<AnnotationInfos.AnnotationInfo> & java.io.Serializable & Serializable all$1_body = (Function0<AnnotationInfos.AnnotationInfo> & java.io.Serializable & Serializable)() -> this.readAnnotationRef();
            return this.until(end$2, all$1_body);
        }

        private final Types.Type MethodTypeRef$1(Types.Type restpe, List params) {
            Types.Type type = restpe;
            Types$NoType$ types$NoType$ = this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoType();
            if (!(type == null ? types$NoType$ != null : !type.equals(types$NoType$)) || params.contains(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoSymbol())) {
                return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().NoType();
            }
            return new Types.MethodType(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), params, restpe);
        }

        private final Types.Type PolyOrNullaryType$1(Types.Type restpe, List tparams) {
            Types.Type type = ((Object)Nil$.MODULE$).equals(tparams) ? new Types.NullaryMethodType(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), restpe) : new Types.PolyType(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), tparams, restpe);
            return type;
        }

        private final Types.Type CompoundType$1(Symbols.Symbol clazz, List parents, int tag$2) {
            switch (tag$2) {
                case 18: {
                    return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().RefinedType().apply(parents, this.symScope(clazz), clazz);
                }
                case 19: {
                    return new Types.ClassInfoType(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), parents, this.symScope(clazz), clazz);
                }
            }
            throw new MatchError(BoxesRunTime.boxToInteger(tag$2));
        }

        private final Types.Type readThisType$1() {
            Symbols.Symbol symbol = this.readSymbolRef();
            Symbols.Symbol symbol2 = symbol instanceof Symbols.StubSymbol ? ((Symbols.Symbol)((Object)((Symbols.StubSymbol)((Object)symbol)))).setFlag(16640L) : symbol;
            return this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().ThisType().apply(symbol2);
        }

        public static final /* synthetic */ String $anonfun$readSymbolAnnotation$1() {
            return "symbol annotation expected";
        }

        private final List all$2(Function0 body, int end$3) {
            return this.until(end$3, body);
        }

        private final List rep$1(Function0 body) {
            return this.times(this.readNat(), body);
        }

        /*
         * WARNING - void declaration
         */
        private final Trees.Apply fixApply$1(Trees.Apply tree, Types.Type tpe) {
            void var4_4;
            void var3_3;
            if (tree == null) {
                throw new MatchError((Object)null);
            }
            Trees.Tree fun = tree.fun();
            List<Trees.Tree> args2 = tree.args();
            void fun2 = var3_3;
            void args3 = var4_4;
            if (fun2.symbol().isOverloaded()) {
                fun2.setType(fun2.symbol().info());
                this.inferMethodAlternative((Trees.Tree)fun2, args3.map((Function1<Trees.Tree, Types.Type> & java.io.Serializable & Serializable)x$4 -> x$4.tpe(), List$.MODULE$.canBuildFrom()), tpe);
            }
            return tree;
        }

        private final Trees.Tree ref$1() {
            return this.readTreeRef();
        }

        private final Trees.CaseDef caseRef$1() {
            return this.readCaseDefRef();
        }

        private final Trees.Modifiers modsRef$1() {
            return this.readModifiersRef();
        }

        private final Trees.Template implRef$1() {
            return this.readTemplateRef();
        }

        private final Names.Name nameRef$1() {
            return this.readNameRef();
        }

        private final Trees.TypeDef tparamRef$1() {
            return this.readTypeDefRef();
        }

        private final Trees.ValDef vparamRef$1() {
            return this.readValDefRef();
        }

        private final Trees.MemberDef memberRef$1() {
            return this.readMemberDefRef();
        }

        private final Constants.Constant constRef$1() {
            return this.readConstantRef();
        }

        private final Trees.Ident idRef$1() {
            return this.readIdentRef();
        }

        private final Names.TermName termNameRef$1() {
            return this.readNameRef().toTermName();
        }

        private final Names.TypeName typeNameRef$1() {
            return this.readNameRef().toTypeName();
        }

        private final Trees.RefTree refTreeRef$1() {
            Trees.Tree tree = this.ref$1();
            if (!(tree instanceof Trees.RefTree)) {
                throw this.errorBadSignature(new StringBuilder(24).append("RefTree expected, found ").append(tree.shortClass()).toString());
            }
            Trees.RefTree refTree = (Trees.RefTree)((Object)tree);
            return refTree;
        }

        private final List selectorsRef$1(int end$3) {
            Function0<Trees.ImportSelector> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.ImportSelector> & java.io.Serializable & Serializable)() -> new Trees.ImportSelector(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.nameRef$1(), -1, this.nameRef$1(), -1);
            return this.until(end$3, all$2_body);
        }

        private final Trees.Tree readTree$1(Types.Type tpe, int tag$3, int end$3) {
            switch (tag$3) {
                case 36: {
                    return new Trees.Ident(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.nameRef$1());
                }
                case 35: {
                    return new Trees.Select(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.nameRef$1());
                }
                case 31: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return this.fixApply$1(new Trees.Apply(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body)), tpe);
                }
                case 18: {
                    return new Trees.Bind(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.nameRef$1(), this.ref$1());
                }
                case 13: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    List list = this.until(end$3, all$2_body);
                    Option option = package$.MODULE$.$colon$plus().unapply(list);
                    if (option.isEmpty()) {
                        throw new MatchError(list);
                    }
                    List<Trees.Tree> stats = option.get()._1();
                    Trees.Tree expr = (Trees.Tree)option.get()._2();
                    Trees.Block block = new Trees.Block(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), stats, expr);
                    return block;
                }
                case 23: {
                    return new Trees.If(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.ref$1(), this.ref$1());
                }
                case 37: {
                    return new Trees.Literal(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.constRef$1());
                }
                case 30: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.TypeApply(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body));
                }
                case 29: {
                    return new Trees.Typed(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.ref$1());
                }
                case 16: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.Alternative(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.until(end$3, all$2_body));
                }
                case 39: {
                    return new Trees.Annotated(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.ref$1());
                }
                case 43: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.AppliedTypeTree(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body));
                }
                case 32: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.ApplyDynamic(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body));
                }
                case 20: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.ArrayValue(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body));
                }
                case 22: {
                    return new Trees.Assign(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.ref$1());
                }
                case 14: {
                    return new Trees.CaseDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.ref$1(), this.ref$1());
                }
                case 3: {
                    Function0<Trees.TypeDef> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.TypeDef> & java.io.Serializable & Serializable)() -> this.tparamRef$1();
                    return new Trees.ClassDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.modsRef$1(), this.typeNameRef$1(), this.times(this.readNat(), rep$1_body), this.implRef$1());
                }
                case 42: {
                    return new Trees.CompoundTypeTree(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.implRef$1());
                }
                case 6: {
                    Function0<Trees.TypeDef> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.TypeDef> & java.io.Serializable & Serializable)() -> this.tparamRef$1();
                    Function0<List> & java.io.Serializable & Serializable rep$1_body2 = (Function0<List> & java.io.Serializable & Serializable)() -> {
                        Function0<Trees.ValDef> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.ValDef> & java.io.Serializable & Serializable)() -> this.vparamRef$1();
                        return this.times(this.readNat(), rep$1_body);
                    };
                    return new Trees.DefDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.modsRef$1(), this.termNameRef$1(), this.times(this.readNat(), rep$1_body), this.times(this.readNat(), rep$1_body2), this.ref$1(), this.ref$1());
                }
                case 45: {
                    Function0<Trees.MemberDef> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.MemberDef> & java.io.Serializable & Serializable)() -> this.memberRef$1();
                    return new Trees.ExistentialTypeTree(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body));
                }
                case 21: {
                    Function0<Trees.ValDef> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.ValDef> & java.io.Serializable & Serializable)() -> this.vparamRef$1();
                    return new Trees.Function(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.times(this.readNat(), rep$1_body), this.ref$1());
                }
                case 9: {
                    return new Trees.Import(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.selectorsRef$1(end$3));
                }
                case 8: {
                    Function0<Trees.Ident> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.Ident> & java.io.Serializable & Serializable)() -> this.idRef$1();
                    return new Trees.LabelDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.termNameRef$1(), this.times(this.readNat(), rep$1_body), this.ref$1());
                }
                case 24: {
                    Function0<Trees.CaseDef> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.CaseDef> & java.io.Serializable & Serializable)() -> this.caseRef$1();
                    return new Trees.Match(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body));
                }
                case 4: {
                    return new Trees.ModuleDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.modsRef$1(), this.termNameRef$1(), this.implRef$1());
                }
                case 28: {
                    return new Trees.New(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1());
                }
                case 2: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.PackageDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.refTreeRef$1(), this.until(end$3, all$2_body));
                }
                case 25: {
                    return new Trees.Return(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1());
                }
                case 41: {
                    return new Trees.SelectFromTypeTree(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.typeNameRef$1());
                }
                case 40: {
                    return new Trees.SingletonTypeTree(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1());
                }
                case 17: {
                    return new Trees.Star(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1());
                }
                case 33: {
                    return new Trees.Super(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.typeNameRef$1());
                }
                case 12: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.Template(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.times(this.readNat(), rep$1_body), this.vparamRef$1(), this.until(end$3, all$2_body));
                }
                case 34: {
                    return new Trees.This(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.typeNameRef$1());
                }
                case 27: {
                    return new Trees.Throw(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1());
                }
                case 26: {
                    Function0<Trees.CaseDef> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.CaseDef> & java.io.Serializable & Serializable)() -> this.caseRef$1();
                    return new Trees.Try(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.times(this.readNat(), rep$1_body), this.ref$1());
                }
                case 44: {
                    return new Trees.TypeBoundsTree(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.ref$1());
                }
                case 7: {
                    Function0<Trees.TypeDef> & java.io.Serializable & Serializable rep$1_body = (Function0<Trees.TypeDef> & java.io.Serializable & Serializable)() -> this.tparamRef$1();
                    return new Trees.TypeDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.modsRef$1(), this.typeNameRef$1(), this.times(this.readNat(), rep$1_body), this.ref$1());
                }
                case 38: {
                    return new Trees.TypeTree(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable());
                }
                case 19: {
                    Function0<Trees.Tree> & java.io.Serializable & Serializable all$2_body = (Function0<Trees.Tree> & java.io.Serializable & Serializable)() -> this.ref$1();
                    return new Trees.UnApply(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.ref$1(), this.until(end$3, all$2_body));
                }
                case 5: {
                    return new Trees.ValDef(this.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), this.modsRef$1(), this.termNameRef$1(), this.ref$1(), this.ref$1());
                }
            }
            throw this.noSuchTreeTag(tag$3, end$3);
        }

        public static final /* synthetic */ String $anonfun$readTree$1() {
            return "tree expected";
        }

        public static final /* synthetic */ Object $anonfun$readSymbolRef$1(Scan $this, int i$3) {
            return $this.entries()[i$3];
        }

        public Scan(UnPickler $outer, byte[] _bytes, int offset, Symbols.ClassSymbol classRoot, Symbols.ModuleSymbol moduleRoot, String filename) {
            this.classRoot = classRoot;
            this.moduleRoot = moduleRoot;
            this.filename = filename;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super(_bytes, offset, -1);
            this.checkVersion();
            this.loadingMirror = $outer.symbolTable().mirrorThatLoaded(classRoot);
            this.scala$reflect$internal$pickling$UnPickler$Scan$$index = this.createIndex();
            this.entries = new Object[this.scala$reflect$internal$pickling$UnPickler$Scan$$index().length];
            this.symScopes = (HashMap)HashMap$.MODULE$.apply(Nil$.MODULE$);
        }

        private class LazyTypeRef
        extends Types.LazyType
        implements Types.FlagAgnosticCompleter {
            private final int i;
            private final int definedAtRunId;
            private final Phase p;
            public final /* synthetic */ Scan $outer;

            private int definedAtRunId() {
                return this.definedAtRunId;
            }

            private Phase p() {
                return this.p;
            }

            /*
             * Unable to fully structure code
             */
            public void completeInternal(Symbols.Symbol sym) {
                try {
                    try {
                        block11: {
                            block10: {
                                this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().scala$reflect$internal$pickling$UnPickler$$completingStack().$plus$eq((Object)sym);
                                tp = (Types.Type)this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().at(this.i, (Function0<Types.Type> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$completeInternal$1(scala.reflect.internal.pickling.UnPickler$Scan$LazyTypeRef scala.reflect.internal.Symbols$Symbol ), ()Lscala/reflect/internal/Types$Type;)((LazyTypeRef)this, (Symbols.Symbol)sym));
                                v0 = sym.rawname();
                                var5_3 = this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().tpnme().LOCAL_CHILD();
                                if (v0 != null ? v0.equals(var5_3) == false : var5_3 != null) break block10;
                                if (!(tp instanceof Types.ClassInfoType)) ** GOTO lbl-1000
                                var6_4 = (Types.ClassInfoType)tp;
                                var7_5 = var6_4.parents();
                                decls = var6_4.decls();
                                typeSymbol = var6_4.typeSymbol();
                                if (!(var7_5 instanceof $colon$colon)) ** GOTO lbl-1000
                                var10_8 = ($colon$colon)var7_5;
                                superClass = (Types.Type)var10_8.head();
                                traits = var10_8.tl$access$1();
                                if (superClass.typeSymbol().isTrait()) {
                                    var13_11 = this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().definitions().ObjectTpe();
                                    var2_12 = new Types.ClassInfoType(this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable(), traits.$colon$colon(superClass).$colon$colon(var13_11), decls, typeSymbol);
                                } else lbl-1000:
                                // 3 sources

                                {
                                    var2_12 = tp;
                                }
                                v1 = var2_12;
                                break block11;
                            }
                            v1 = fixLocalChildTp = tp;
                        }
                        if (this.p() != null) {
                            this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().slowButSafeEnteringPhase(this.p(), (Function0<Symbols.Symbol> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$completeInternal$2(scala.reflect.internal.Symbols$Symbol scala.reflect.internal.Types$Type ), ()Lscala/reflect/internal/Symbols$Symbol;)((Symbols.Symbol)sym, (Types.Type)fixLocalChildTp));
                        }
                        if (this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().currentRunId() != this.definedAtRunId()) {
                            sym.setInfo(this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().adaptToNewRunMap().apply(fixLocalChildTp));
                        }
                    }
                    catch (MissingRequirementError e) {
                        throw this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().toTypeError(e);
                    }
                }
                finally {
                    this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().scala$reflect$internal$pickling$UnPickler$$completingStack().remove(this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().scala$reflect$internal$pickling$UnPickler$$completingStack().length() - 1);
                }
            }

            @Override
            public void complete(Symbols.Symbol sym) {
                this.completeInternal(sym);
                if (!this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().isCompilerUniverse()) {
                    this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().markAllCompleted(Predef$.MODULE$.wrapRefArray((Object[])new Symbols.Symbol[]{sym}));
                }
            }

            @Override
            public void load(Symbols.Symbol sym) {
                this.complete(sym);
            }

            public /* synthetic */ Scan scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer() {
                return this.$outer;
            }

            public static final /* synthetic */ Types.Type $anonfun$completeInternal$1(LazyTypeRef $this, Symbols.Symbol sym$2) {
                return $this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRef$$$outer().readType(sym$2.isTerm());
            }

            public static final /* synthetic */ Symbols.Symbol $anonfun$completeInternal$2(Symbols.Symbol sym$2, Types.Type fixLocalChildTp$1) {
                return sym$2.setInfo(fixLocalChildTp$1);
            }

            public LazyTypeRef(Scan $outer, int i) {
                this.i = i;
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super($outer.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable());
                this.definedAtRunId = $outer.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().currentRunId();
                this.p = $outer.scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().phase();
            }
        }

        private class LazyTypeRefAndAlias
        extends LazyTypeRef {
            private final int j;

            @Override
            public void completeInternal(Symbols.Symbol sym) {
                try {
                    super.completeInternal(sym);
                    ObjectRef<Symbols.Symbol> alias = ObjectRef.create((Symbols.Symbol)this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRefAndAlias$$$outer().at(this.j, (Function0<Symbols.Symbol> & java.io.Serializable & Serializable)() -> this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRefAndAlias$$$outer().readSymbol()));
                    if (((Symbols.Symbol)alias.elem).isOverloaded()) {
                        alias.elem = (Symbols.Symbol)this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRefAndAlias$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().slowButSafeEnteringPhase(this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRefAndAlias$$$outer().scala$reflect$internal$pickling$UnPickler$Scan$$$outer().symbolTable().picklerPhase(), (Function0<Symbols.Symbol> & java.io.Serializable & Serializable)() -> ((Symbols.Symbol)alias$1.elem).suchThat((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)alt -> BoxesRunTime.boxToBoolean(LazyTypeRefAndAlias.$anonfun$completeInternal$5(sym, alt))));
                    }
                    ((Symbols.TermSymbol)sym).setAlias((Symbols.Symbol)alias.elem);
                    return;
                }
                catch (MissingRequirementError e) {
                    throw this.scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRefAndAlias$$$outer().toTypeError(e);
                }
            }

            public /* synthetic */ Scan scala$reflect$internal$pickling$UnPickler$Scan$LazyTypeRefAndAlias$$$outer() {
                return this.$outer;
            }

            public static final /* synthetic */ boolean $anonfun$completeInternal$5(Symbols.Symbol sym$3, Symbols.Symbol alt) {
                if (sym$3.isParamAccessor()) {
                    return alt.isParamAccessor();
                }
                return sym$3.tpe().$eq$colon$eq(sym$3.owner().thisType().memberType(alt));
            }

            public LazyTypeRefAndAlias(Scan $outer, int i, int j) {
                this.j = j;
                super($outer, i);
            }
        }
    }
}

