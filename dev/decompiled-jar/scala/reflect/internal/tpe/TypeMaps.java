/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.tpe;

import java.lang.invoke.LambdaMetafactory;
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
import scala.StringContext;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractTraversable;
import scala.collection.LinearSeqOptimized;
import scala.collection.Seq;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set;
import scala.collection.immutable.Set$;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashMap$;
import scala.collection.mutable.ListBuffer;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Trees;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Names;
import scala.reflect.internal.Scopes;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$UnmappableTree$;
import scala.reflect.internal.Variance$;
import scala.reflect.internal.tpe.TypeConstraints;
import scala.reflect.internal.tpe.TypeMaps$ApproximateDependentMap$;
import scala.reflect.internal.tpe.TypeMaps$AsSeenFromMap$annotationArgRewriter$;
import scala.reflect.internal.tpe.TypeMaps$ErroneousCollector$;
import scala.reflect.internal.tpe.TypeMaps$InstantiateDependentMap$StabilizedArgTp$;
import scala.reflect.internal.tpe.TypeMaps$InstantiateDependentMap$StableArgTp$;
import scala.reflect.internal.tpe.TypeMaps$InstantiateDependentMap$UnstableArgTp$;
import scala.reflect.internal.tpe.TypeMaps$InstantiateDependentMap$treeTrans$1$;
import scala.reflect.internal.tpe.TypeMaps$IsDependentCollector$;
import scala.reflect.internal.tpe.TypeMaps$SubstSymMap$mapTreeSymbols$;
import scala.reflect.internal.tpe.TypeMaps$SubstTypeMap$trans$1$;
import scala.reflect.internal.tpe.TypeMaps$abstractTypesToBounds$;
import scala.reflect.internal.tpe.TypeMaps$adaptToNewRunMap$;
import scala.reflect.internal.tpe.TypeMaps$dropIllegalStarTypes$;
import scala.reflect.internal.tpe.TypeMaps$dropSingletonType$;
import scala.reflect.internal.tpe.TypeMaps$normalizeAliases$;
import scala.reflect.internal.tpe.TypeMaps$typeVarToOriginMap$;
import scala.reflect.internal.tpe.TypeMaps$wildcardExtrapolation$;
import scala.reflect.internal.tpe.TypeMaps$wildcardToTypeVarMap$;
import scala.reflect.internal.util.StripMarginInterpolator;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LambdaDeserialize;
import scala.runtime.LazyRef;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u001dEfADAt\u0003S\u0004\n1!\u0001\u0002n\u0006ex1\u0016\u0005\b\u0005\u0007\u0001A\u0011\u0001B\u0004\u000f\u001d\u0011y\u0001\u0001E\u0001\u0005#1qA!\u0006\u0001\u0011\u0003\u00119\u0002C\u0004\u00038\r!\ta!\u0017\t\u000f\t\u00053\u0001\"\u0001\u0004\\\u001d91q\f\u0001\t\u0002\r\u0005daBB2\u0001!\u00051Q\r\u0005\b\u0005o9A\u0011AB4\u0011\u001d\u0011\te\u0002C\u0001\u0007S:qa!\u001c\u0001\u0011\u0003\u0019yGB\u0004\u0004r\u0001A\taa\u001d\t\u000f\t]2\u0002\"\u0001\u0004v!9!\u0011I\u0006\u0005\u0002\r]taBB>\u0001!\u00051Q\u0010\u0004\b\u0007\u007f\u0002\u0001\u0012ABA\u0011\u001d\u00119d\u0004C\u0001\u0007\u0007CqA!\u0011\u0010\t\u0003\u0019)IB\u0005\u0004\n\u0002\u0001\n1!\u0001\u0004\f\"9!1\u0001\n\u0005\u0002\t\u001d\u0001bBBG%\u0019\u00051q\u0012\u0005\b\u0005?\u0012B\u0011IBJ\u00115\u00199J\u0005I\u0001\u0004\u0003\u0005I\u0011BBMU\u0019I1Q\u0014\u0001\u0011\u0002\u0007\u00051q\u0014\u0005\b\u0005\u00079B\u0011\u0001B\u0004\u0011\u001d\u0019ii\u0006C\u0001\u0007G3qAa\u0007\u0001\u0003\u0003\u0011i\u0002\u0003\b\u00030i!\t\u0011!B\u0003\u0002\u0003\u0006IA!\r\t\u000f\t]\"\u0004\"\u0001\u0003:!9!q\u0007\u000e\u0005\u0002\t}\u0002b\u0002B!5\u0019\u0005!1\t\u0005\t\u0005\u0013R\u0002\u0015)\u0003\u0003L!9!1\u000b\u000e\u0005\u0002\tU\u0003b\u0002B.5\u0011\u0005!Q\f\u0005\b\u0005?RB\u0011\u0001B1\u0011\u001d\u0011)G\u0007C\u0003\u0005OBqA!'\u001b\t\u000b\u0011Y\nC\u0004\u0003*j!)Ba+\t\u000f\t='\u0004\"\u0003\u0003R\"9!1\u001c\u000e\u0005\n\tu\u0007b\u0002B05\u0011\u0005!\u0011\u001e\u0005\b\u0005?RB\u0011\u0001B}\u0011\u001d\u0011yF\u0007C\u0001\u0005{Dqa!\u0004\u001b\t\u0003\u0019y\u0001C\u0004\u0004\u0018i!\ta!\u0007\t\u000f\t}#\u0004\"\u0001\u0004*!9!q\f\u000e\u0005\u0002\r=bABB\u001f5\u0001\u0019y\u0004C\u0004\u00038=\"\ta!\u0014\t\u000f\rMs\u0006\"\u0011\u0004V\u001991q\u0015\u0001\u0002\u0002\r%\u0006b\u0002B\u001ce\u0011\u000511\u0016\u0005\b\u0007_\u0013d\u0011ABY\u0011\u001d\u0011\tE\rC\u0001\u0007k3qa!/\u0001\u0003\u0003\u0019Y\fC\u0004\u00038Y\"\taa0\t\u000f\r\u001dgG\"\u0001\u0004J\"911\u001a\u001c\u0007\u0002\t\u001daaBBg\u0001\u0005\u00051q\u001a\u0005\u000b\u0007'T$\u0011!Q\u0001\n\rU\u0007b\u0002B\u001cu\u0011\u00051\u0011\u001c\u0005\f\u0007\u000fT\u0004\u0019!a\u0001\n\u0003\u0019y\u000eC\u0006\u0004bj\u0002\r\u00111A\u0005\u0002\r\r\bbCBuu\u0001\u0007\t\u0011)Q\u0005\u0007+Dqaa;;\t\u0003\u0019i\u000fC\u0004\u0004r\u0002!\taa=\u0007\r\rU\b\u0001AB|\u0011)\u0011\tM\u0011B\u0001B\u0003%!1\u0019\u0005\b\u0005o\u0011E\u0011AB}\u0011%\u0019yP\u0011b\u0001\n\u0013!\t\u0001\u0003\u0005\u0005\u0014\t\u0003\u000b\u0011\u0002C\u0002\u0011\u001d!)B\u0011C\u0005\t/Aq\u0001b\u0007C\t\u0003!i\u0002C\u0004\u0003B\t#\t\u0001\"\t\t\u000f\t}#\t\"\u0011\u0005&!9!q\f\"\u0005B\u0011%ra\u0002C\u0017\u0001!\u0005Aq\u0006\u0004\b\tc\u0001\u0001\u0012\u0001C\u001a\u0011\u001d\u00119$\u0014C\u0001\tkAqA!\u0011N\t\u0003!9\u0004C\u0004\u0005<\u0001!\t\u0001\"\u0010\t\u0013\u0011\r\u0003\u0001\"\u0005\u0002n\u0012\u0015\u0003b\u0002C'\u0001\u0011\u0015Aq\n\u0004\u0007\t'\u0002\u0001\u0001\"\u0016\t\u0015\u0011e3K!A!\u0002\u0013\u0011)\u0003\u0003\u0006\u0005\\M\u0013\t\u0011)A\u0005\u0005\u000bDqAa\u000eT\t\u0003!i\u0006C\u0005\u0005dM\u0013\r\u0011\"\u0003\u0005f!AAqM*!\u0002\u0013\u0011)\u0003C\u0004\u0005jM#\t\u0001b\u001b\t\u000f\u001154\u000b\"\u0001\u0005l!9!\u0011I*\u0005\u0002\u0011=\u0004\"\u0003C:'\u0002\u0007I\u0011\u0002C6\u0011%!)h\u0015a\u0001\n\u0013!9\b\u0003\u0005\u0005|M\u0003\u000b\u0015\u0002Bb\u0011%!ih\u0015a\u0001\n\u0013!Y\u0007C\u0005\u0005\u0000M\u0003\r\u0011\"\u0003\u0005\u0002\"AAQQ*!B\u0013\u0011\u0019\rC\u0005\u0005\bN\u0013\r\u0011\"\u0003\u0005\n\"AA1R*!\u0002\u0013\u0011\t\u0004C\u0004\u0005\u000eN#I\u0001b$\t\u000f\u0011U5\u000b\"\u0003\u0005\u0018\"IA1T*A\u0002\u0013%AQ\u0014\u0005\n\t?\u001b\u0006\u0019!C\u0005\tCC\u0001\u0002\"*TA\u0003&!q\u001c\u0005\b\tO\u001bF\u0011\u0002CU\u0011\u001d!Yk\u0015C\t\t[Cq\u0001b-T\t#!)\fC\u0004\u0005<N#I\u0001\"0\t\u000f\u0011\u001d7\u000b\"\u0003\u0005J\"9AqZ*\u0005\n\u0011E\u0007\u0002\u0003Co'\u0002\u0006KA!\r\b\u000f\u0011}7\u000b#\u0003\u0005b\u001a9AQ]*\t\n\u0011\u001d\bb\u0002B\u001cc\u0012\u0005A1\u001e\u0005\b\t[\fH\u0011\u0002Cx\u0011\u001d!)0\u001dC\u0005\toDqaa\u0015r\t\u0003\"I\u0010C\u0004\u0003`M#\t\u0005\"@\t\u000f\u0015\r1\u000b\"\u0003\u0006\u0006!9QqB*\u0005\n\u0015E\u0001bBC\u000e'\u0012\u0005SQ\u0004\u0004\b\u000b\u0013\u0002\u0011\u0011AC&\u0011))yE\u001fB\u0001B\u0003%!1\u0019\u0005\u000b\u000b#R(\u0011!Q\u0001\n\u0015M\u0003b\u0002B\u001cu\u0012\u0005Q\u0011\f\u0005\t\u000bCR\b\u0015)\u0003\u00032!AQ1\r>!B\u0013\u0011y\u000e\u0003\u0005\u0006fi\u0004\u000b\u0015\u0002Bp\u0011!)9G\u001fQ!\n\t}\u0007bBC5u\u0012EQ1\u000e\u0005\b\u000bgRh\u0011CC;\u0011\u001d)iH\u001fC\t\u000b\u007fBq!b!{\t\u0013))\tC\u0004\u0006\u001ej$I!b(\t\u000f\t\u0005#\u0010\"\u0001\u0006&\u001a1Q1\u0016\u0001\u0001\u000b[C1\"b\u0014\u0002\u0012\t\u0005\t\u0015!\u0003\u0003D\"YQ\u0011KA\t\u0005\u0003\u0005\u000b\u0011\u0002Bb\u0011!\u00119$!\u0005\u0005\u0002\u0015E\u0006\u0002\u0003B\u001c\u0003#!\t!\"/\t\u0011\u0015M\u0014\u0011\u0003C\t\u000b\u0017D\u0001\"b!\u0002\u0012\u0011%Q\u0011\u001b\u0005\t\u000b7\f\t\u0002\"\u0003\u0006^\"A!\u0011IA\t\t\u0003*\to\u0002\u0005\u0006f\u0006E\u0001\u0012ACt\r!)Y/!\u0005\t\u0002\u00155\b\u0002\u0003B\u001c\u0003K!\t!\"=\t\u0015\u0015M\u0018Q\u0005b\u0001\n\u0003))\u0010C\u0005\u0006~\u0006\u0015\u0002\u0015!\u0003\u0006x\"AQq`A\u0013\t\u00031\t\u0001\u0003\u0005\u0007\f\u0005\u0015B\u0011\u0001D\u0007\u0011!\u0019\u0019&!\n\u0005B\u0019e\u0001\u0002\u0003B0\u0003#!\tE\"\b\u0007\r\u0019\r\u0002\u0001\u0001D\u0013\u0011-)y%!\u000e\u0003\u0006\u0004%\t\u0001b\u001b\t\u0017\u0019%\u0012Q\u0007B\u0001B\u0003%!1\u0019\u0005\f\u000b#\n)D!b\u0001\n\u00031Y\u0003C\u0006\u0007.\u0005U\"\u0011!Q\u0001\n\t5\u0006\u0002\u0003B\u001c\u0003k!\tAb\f\t\u0011\u0015M\u0014Q\u0007C\t\roA\u0001Ba\u0018\u00026\u0011\u0005cQ\b\u0004\u0007\r\u0007\u0002\u0001A\"\u0012\t\u0017\u0015=\u0013Q\tB\u0001B\u0003%!Q\u0019\u0005\f\u000b#\n)E!A!\u0002\u0013\u0011)\u0003\u0003\u0005\u00038\u0005\u0015C\u0011\u0001D$\u0011!\u0011\t%!\u0012\u0005\u0002\u0019=cA\u0002D*\u0001\u00011)\u0006C\u0006\u0006P\u0005=#\u0011!Q\u0001\n\t\r\u0007\u0002\u0003B\u001c\u0003\u001f\"\tAb\u0016\t\u0011\t\u0005\u0013q\nC\u0001\r;:qA\"\u0019\u0001\u0011\u00031\u0019GB\u0004\u0007f\u0001A\tAb\u001a\t\u0011\t]\u0012\u0011\fC\u0001\rWB\u0001ba,\u0002Z\u0011\u0005aQN\u0004\b\rc\u0002\u0001\u0012\u0001D:\r\u001d1)\b\u0001E\u0001\roB\u0001Ba\u000e\u0002b\u0011\u0005a\u0011\u0010\u0005\t\u0005\u0003\n\t\u0007\"\u0001\u0007|\u00191aq\u0010\u0001\u0001\r\u0003C1Bb!\u0002h\t\u0005\t\u0015!\u0003\u0003D\"YaQQA4\u0005\u0003\u0005\u000b\u0011\u0002BW\u0011!\u00119$a\u001a\u0005\u0002\u0019\u001d\u0005\u0002\u0004DH\u0003O\u0002\r\u0011!Q!\n\u0019E\u0005\u0002\u0004DL\u0003O\u0002\r\u0011!Q!\n\u0019e\u0005\u0002\u0003DN\u0003O\"IA\"(\t\u0011\u0019}\u0015q\rC\u0005\rCC\u0001Bb)\u0002h\u0011\u0005A1N\u0004\t\rK\u000b9\u0007#\u0003\u0007(\u001aAa1VA4\u0011\u00131i\u000b\u0003\u0005\u00038\u0005mD\u0011\u0001DX\u0011!1\t,a\u001f\u0005\u0002\u0019M\u0006\u0002\u0003D^\u0003O\"IA\"0\b\u0011\u0019\r\u0017q\rE\u0005\r\u000b4\u0001Bb2\u0002h!%a\u0011\u001a\u0005\t\u0005o\t)\t\"\u0001\u0007L\"Aa\u0011WAC\t\u00031im\u0002\u0005\u0007V\u0006\u001d\u0004\u0012\u0002Dl\r!1I.a\u001a\t\n\u0019m\u0007\u0002\u0003B\u001c\u0003\u001b#\tA\"8\t\u0011\u0019E\u0016Q\u0012C\u0001\r?D\u0001B!\u0011\u0002h\u0011\u0005a1\u001d\u0005\t\u0005?\n9\u0007\"\u0011\u0007h\u001e9aq\u001e\u0001\t\u0002\u0019Eha\u0002Dz\u0001!\u0005aQ\u001f\u0005\t\u0005o\tI\n\"\u0001\u0007x\"A!\u0011IAM\t\u00031IpB\u0004\u0007~\u0002A\tAb@\u0007\u000f\u001d\u0005\u0001\u0001#\u0001\b\u0004!A!qGAQ\t\u00039)\u0001\u0003\u0005\u0003B\u0005\u0005F\u0011AD\u0004\r\u00199Y\u0001\u0001\u0001\b\u000e!Y!Q[AT\u0005\u0003\u0005\u000b\u0011\u0002Bc\u0011!\u00119$a*\u0005\u0002\u001d=\u0001\u0002CBX\u0003O#\ta\"\u0006\t\u0011\t}\u0013q\u0015C!\u000f31aa\"\b\u0001\u0001\u001d}\u0001bCD\u0012\u0003c\u0013\t\u0011)A\u0005\u000fKA\u0001Ba\u000e\u00022\u0012\u0005qq\u0005\u0005\t\u0007W\f\t\f\"\u0011\b.!A1qVAY\t\u00039YD\u0002\u0004\b@\u0001\u0001q\u0011\t\u0005\f\u000f\u001b\nYL!A!\u0002\u00139y\u0005\u0003\u0005\u00038\u0005mF\u0011AD+\u0011!\u0019Y/a/\u0005B\u001dm\u0003\u0002CBX\u0003w#\ta\"\u0019\u0007\r\u001d\u0015\u0004\u0001AD4\u0011-9I'!2\u0003\u0002\u0003\u0006Iab\u001b\t\u0011\t]\u0012Q\u0019C\u0001\u000f[B\u0001ba,\u0002F\u0012\u0005q1\u000f\u0004\u0007\u000fo\u0002\u0001a\"\u001f\t\u0017\u001d\r\u0012Q\u001aB\u0001B\u0003%qQ\u0005\u0005\t\u0005o\ti\r\"\u0001\b~!A1qVAg\t\u00039\u0019iB\u0004\b\b\u0002A\ta\"#\u0007\u000f\u001d-\u0005\u0001#\u0001\b\u000e\"A!qGAl\t\u00039y\t\u0003\u0005\u00040\u0006]G\u0011ADI\u000f\u001d9)\n\u0001E\u0001\u000f/3qa\"'\u0001\u0011\u00039Y\n\u0003\u0005\u00038\u0005}G\u0011ADO\u0011!9y*a8\u0005\n\u001d\u0005\u0006\u0002\u0003B!\u0003?$\tab*\u0003\u0011QK\b/Z'baNTA!a;\u0002n\u0006\u0019A\u000f]3\u000b\t\u0005=\u0018\u0011_\u0001\tS:$XM\u001d8bY*!\u00111_A{\u0003\u001d\u0011XM\u001a7fGRT!!a>\u0002\u000bM\u001c\u0017\r\\1\u0014\u0007\u0001\tY\u0010\u0005\u0003\u0002~\u0006}XBAA{\u0013\u0011\u0011\t!!>\u0003\r\u0005s\u0017PU3g\u0003\u0019!\u0013N\\5uI\r\u0001AC\u0001B\u0005!\u0011\tiPa\u0003\n\t\t5\u0011Q\u001f\u0002\u0005+:LG/\u0001\to_Jl\u0017\r\\5{K\u0006c\u0017.Y:fgB\u0019!1C\u0002\u000e\u0003\u0001\u0011\u0001C\\8s[\u0006d\u0017N_3BY&\f7/Z:\u0014\u0007\r\u0011I\u0002E\u0002\u0003\u0014i\u0011q\u0001V=qK6\u000b\u0007oE\u0003\u001b\u0003w\u0014y\u0002\u0005\u0005\u0002~\n\u0005\"Q\u0005B\u0013\u0013\u0011\u0011\u0019#!>\u0003\u0013\u0019+hn\u0019;j_:\f\u0004\u0003\u0002B\n\u0005OIAA!\u000b\u0003,\t!A+\u001f9f\u0013\u0011\u0011i#!<\u0003\u000bQK\b/Z:\u0002uM\u001c\u0017\r\\1%e\u00164G.Z2uI%tG/\u001a:oC2$C\u000f]3%)f\u0004X-T1qg\u0012\"\u0016\u0010]3NCB$C\u0005\u001e:bG.4\u0016M]5b]\u000e,\u0007\u0003BA\u007f\u0005gIAA!\u000e\u0002v\n9!i\\8mK\u0006t\u0017A\u0002\u001fj]&$h\b\u0006\u0003\u0003\u001a\tm\u0002b\u0002B\u001f9\u0001\u0007!\u0011G\u0001\u000eiJ\f7m\u001b,be&\fgnY3\u0015\u0005\te\u0011!B1qa2LH\u0003\u0002B\u0013\u0005\u000bBqAa\u0012\u001f\u0001\u0004\u0011)#\u0001\u0002ua\u0006IqL^1sS\u0006t7-\u001a\t\u0005\u0005\u001b\u0012y%\u0004\u0002\u0002n&!!\u0011KAw\u0005!1\u0016M]5b]\u000e,\u0017\u0001\u0004<be&\fgnY3`I\u0015\fH\u0003\u0002B\u0005\u0005/BqA!\u0017!\u0001\u0004\u0011Y%A\u0001y\u0003!1\u0018M]5b]\u000e,WC\u0001B&\u0003\u001di\u0017\r](wKJ$BA!\n\u0003d!9!q\t\u0012A\u0002\t\u0015\u0012\u0001D<ji\"4\u0016M]5b]\u000e,W\u0003\u0002B5\u0005c\"BAa\u001b\u0003\u000eR!!Q\u000eBB!\u0011\u0011yG!\u001d\r\u0001\u00119!1O\u0012C\u0002\tU$!\u0001+\u0012\t\t]$Q\u0010\t\u0005\u0003{\u0014I(\u0003\u0003\u0003|\u0005U(a\u0002(pi\"Lgn\u001a\t\u0005\u0003{\u0014y(\u0003\u0003\u0003\u0002\u0006U(aA!os\"A!QQ\u0012\u0005\u0002\u0004\u00119)\u0001\u0003c_\u0012L\bCBA\u007f\u0005\u0013\u0013i'\u0003\u0003\u0003\f\u0006U(\u0001\u0003\u001fcs:\fW.\u001a \t\u000f\t=5\u00051\u0001\u0003L\u0005\ta\u000fK\u0002$\u0005'\u0003B!!@\u0003\u0016&!!qSA{\u0005\u0019Ig\u000e\\5oK\u00069a\r\\5qa\u0016$W\u0003\u0002BO\u0005C#BAa(\u0003$B!!q\u000eBQ\t\u001d\u0011\u0019\b\nb\u0001\u0005kB\u0001B!\"%\t\u0003\u0007!Q\u0015\t\u0007\u0003{\u0014IIa()\u0007\u0011\u0012\u0019*A\u0006nCB|e/\u001a:Be\u001e\u001cHC\u0002BW\u0005w\u0013y\f\u0005\u0004\u00030\nU&Q\u0005\b\u0005\u0003{\u0014\t,\u0003\u0003\u00034\u0006U\u0018a\u00029bG.\fw-Z\u0005\u0005\u0005o\u0013IL\u0001\u0003MSN$(\u0002\u0002BZ\u0003kDqA!0&\u0001\u0004\u0011i+\u0001\u0003be\u001e\u001c\bb\u0002BaK\u0001\u0007!1Y\u0001\biB\f'/Y7t!\u0019\u0011yK!.\u0003FB!!1\u0003Bd\u0013\u0011\u0011IMa3\u0003\rMKXNY8m\u0013\u0011\u0011i-!<\u0003\u000fMKXNY8mg\u0006\t\u0012\r\u001d9msR{7+_7c_2LeNZ8\u0015\r\t\u0015\"1\u001bBl\u0011\u001d\u0011)N\na\u0001\u0005\u000b\f1a]=n\u0011\u001d\u0011IN\na\u0001\u0005K\tA!\u001b8g_\u0006\u0011b-\u001b:ti\u000eC\u0017M\\4fINKXNY8m)\u0011\u0011yN!:\u0011\t\u0005u(\u0011]\u0005\u0005\u0005G\f)PA\u0002J]RDqAa:(\u0001\u0004\u0011\u0019-\u0001\u0005pe&<7+_7t)\u0011\u0011YO!>\u0011\t\tM!Q^\u0005\u0005\u0005_\u0014\tPA\u0003TG>\u0004X-\u0003\u0003\u0003t\u00065(AB*d_B,7\u000fC\u0004\u0003x\"\u0002\rAa;\u0002\u000bM\u001cw\u000e]3\u0015\t\t\r'1 \u0005\b\u0005OL\u0003\u0019\u0001Bb)\u0011\u0011yp!\u0003\u0011\t\tM1\u0011A\u0005\u0005\u0007\u0007\u0019)A\u0001\bB]:|G/\u0019;j_:LeNZ8\n\t\r\u001d\u0011Q\u001e\u0002\u0010\u0003:tw\u000e^1uS>t\u0017J\u001c4pg\"911\u0002\u0016A\u0002\t}\u0018!B1o]>$\u0018AE7ba>3XM]!o]>$\u0018\r^5p]N$Ba!\u0005\u0004\u0014A1!q\u0016B[\u0005\u007fDqa!\u0006,\u0001\u0004\u0019\t\"\u0001\u0004b]:|Go]\u0001\u0011[\u0006\u0004xJ^3s\u0003:tw\u000e^!sON$Baa\u0007\u0004(A1!q\u0016B[\u0007;\u0001BAa\u0005\u0004 %!1\u0011EB\u0012\u0005\u0011!&/Z3\n\t\r\u0015\u0012Q\u001e\u0002\u0006)J,Wm\u001d\u0005\b\u0005{c\u0003\u0019AB\u000e)\u0011\u0019iba\u000b\t\u000f\r5R\u00061\u0001\u0004\u001e\u0005!AO]3f)\u0019\u0019ib!\r\u00044!91Q\u0006\u0018A\u0002\ru\u0001bBB\u001b]\u0001\u00071qG\u0001\u0007O&4X-\u001e9\u0011\r\u0005u8\u0011\bB<\u0013\u0011\u0019Y$!>\u0003\u0013\u0019+hn\u0019;j_:\u0004$A\u0005+za\u0016l\u0015\r\u001d+sC:\u001chm\u001c:nKJ\u001c2aLB!!\u0011\u0011\u0019ba\u0011\n\t\r\u00153q\t\u0002\f)J\fgn\u001d4pe6,'/\u0003\u0003\u0004&\r%#\u0002BB&\u0003c\f1!\u00199j)\t\u0019y\u0005E\u0002\u0004R=j\u0011AG\u0001\niJ\fgn\u001d4pe6$Ba!\b\u0004X!91QF\u0019A\u0002\ruAC\u0001B\t)\u0011\u0011)c!\u0018\t\u000f\t\u001dS\u00011\u0001\u0003&\u0005\tBM]8q'&tw\r\\3u_:$\u0016\u0010]3\u0011\u0007\tMqAA\tee>\u00048+\u001b8hY\u0016$xN\u001c+za\u0016\u001c2a\u0002B\r)\t\u0019\t\u0007\u0006\u0003\u0003&\r-\u0004b\u0002B$\u0013\u0001\u0007!QE\u0001\u0016C\n\u001cHO]1diRK\b/Z:U_\n{WO\u001c3t!\r\u0011\u0019b\u0003\u0002\u0016C\n\u001cHO]1diRK\b/Z:U_\n{WO\u001c3t'\rY!\u0011\u0004\u000b\u0003\u0007_\"BA!\n\u0004z!9!qI\u0007A\u0002\t\u0015\u0012\u0001\u00063s_BLE\u000e\\3hC2\u001cF/\u0019:UsB,7\u000fE\u0002\u0003\u0014=\u0011A\u0003\u001a:pa&cG.Z4bYN#\u0018M\u001d+za\u0016\u001c8cA\b\u0003\u001aQ\u00111Q\u0010\u000b\u0005\u0005K\u00199\tC\u0004\u0003HE\u0001\rA!\n\u0003!\u0005sgn\u001c;bi&|gNR5mi\u0016\u00148c\u0001\n\u0003\u001a\u0005q1.Z3q\u0003:tw\u000e^1uS>tG\u0003\u0002B\u0019\u0007#Cqaa\u0003\u0015\u0001\u0004\u0011y\u0010\u0006\u0003\u0003\u0000\u000eU\u0005bBB\u0006+\u0001\u0007!q`\u0001\u000egV\u0004XM\u001d\u0013nCB|e/\u001a:\u0015\t\t}81\u0014\u0005\b\u0007\u00171\u0002\u0019\u0001B\u0000\u0005]YU-\u001a9P]2LH+\u001f9f\u0007>t7\u000f\u001e:bS:$8oE\u0003\u0018\u00053\u0019\t\u000bE\u0002\u0003\u0014I!BA!\r\u0004&\"911B\rA\u0002\t}(!\u0004+za\u0016$&/\u0019<feN,'oE\u00023\u00053!\"a!,\u0011\u0007\tM!'\u0001\u0005ue\u00064XM]:f)\u0011\u0011Iaa-\t\u000f\t\u001dC\u00071\u0001\u0003&Q!!QEB\\\u0011\u001d\u00119%\u000ea\u0001\u0005K\u0011q\u0003V=qKR\u0013\u0018M^3sg\u0016\u0014x+\u001b;i%\u0016\u001cX\u000f\u001c;\u0016\t\ru6QY\n\u0004m\r5FCABa!\u0015\u0011\u0019BNBb!\u0011\u0011yg!2\u0005\u000f\tMdG1\u0001\u0003v\u00051!/Z:vYR,\"aa1\u0002\u000b\rdW-\u0019:\u0003\u001bQK\b/Z\"pY2,7\r^8s+\u0011\u0019\tna6\u0014\u0007i\u001ai+A\u0004j]&$\u0018.\u00197\u0011\t\t=4q\u001b\u0003\b\u0005gR$\u0019\u0001B;)\u0011\u0019Yn!8\u0011\u000b\tM!h!6\t\u000f\rMG\b1\u0001\u0004VV\u00111Q[\u0001\u000be\u0016\u001cX\u000f\u001c;`I\u0015\fH\u0003\u0002B\u0005\u0007KD\u0011ba:?\u0003\u0003\u0005\ra!6\u0002\u0007a$\u0013'A\u0004sKN,H\u000e\u001e\u0011\u0002\u000f\r|G\u000e\\3diR!1Q[Bx\u0011\u001d\u00119\u0005\u0011a\u0001\u0005K\t\u0001C]1x)>,\u00050[:uK:$\u0018.\u00197\u0016\u0005\te!\u0001G#ySN$XM\u001c;jC2,\u0005\u0010\u001e:ba>d\u0017\r^5p]N\u0019!I!\u0007\u0015\t\rm8Q \t\u0004\u0005'\u0011\u0005b\u0002Ba\t\u0002\u0007!1Y\u0001\u000b_\u000e\u001cWO]\"pk:$XC\u0001C\u0002!!!)\u0001b\u0004\u0003F\n}WB\u0001C\u0004\u0015\u0011!I\u0001b\u0003\u0002\u000f5,H/\u00192mK*!AQBA{\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\t#!9AA\u0004ICNDW*\u00199\u0002\u0017=\u001c7-\u001e:D_VtG\u000fI\u0001\nG>,h\u000e^(dGN$BA!\u0003\u0005\u001a!9!qI$A\u0002\t\u0015\u0012aC3yiJ\f\u0007o\u001c7bi\u0016$BA!\n\u0005 !9\u00111\u001e%A\u0002\t\u0015B\u0003\u0002B\u0013\tGAqAa\u0012J\u0001\u0004\u0011)\u0003\u0006\u0003\u0003&\u0011\u001d\u0002b\u0002B$\u0015\u0002\u0007!Q\u0005\u000b\u0005\u0007;!Y\u0003C\u0004\u0004.-\u0003\ra!\b\u0002+]LG\u000eZ2be\u0012,\u0005\u0010\u001e:ba>d\u0017\r^5p]B\u0019!1C'\u0003+]LG\u000eZ2be\u0012,\u0005\u0010\u001e:ba>d\u0017\r^5p]N\u0019QJ!\u0007\u0015\u0005\u0011=B\u0003\u0002B\u0013\tsAqAa\u0012P\u0001\u0004\u0011)#\u0001\tjgB{7o]5cY\u0016\u0004&/\u001a4jqR!!\u0011\u0007C \u0011\u001d!\t\u0005\u0015a\u0001\u0005\u000b\fQa\u00197buj\fAb]6jaB\u0013XMZ5y\u001f\u001a$bA!\r\u0005H\u0011-\u0003b\u0002C%#\u0002\u0007!QE\u0001\u0004aJ,\u0007b\u0002C!#\u0002\u0007!QY\u0001\u0011]\u0016<\u0018i]*fK:4%o\\7NCB$b\u0001\"\u0015\u00066\u0015]\u0002c\u0001B\n'\ni\u0011i]*fK:4%o\\7NCB\u001cRa\u0015B\r\t/\u00022Aa\u0005\u0018\u0003=\u0019X-\u001a8Ge>l\u0007K]3gSb\u0004\u0014!D:fK:4%o\\7DY\u0006\u001c8\u000f\u0006\u0004\u0005R\u0011}C\u0011\r\u0005\b\t32\u0006\u0019\u0001B\u0013\u0011\u001d!YF\u0016a\u0001\u0005\u000b\fab]3f]\u001a\u0013x.\u001c)sK\u001aL\u00070\u0006\u0002\u0003&\u0005y1/Z3o\rJ|W\u000e\u0015:fM&D\b%\u0001\bdCB$XO]3e!\u0006\u0014\u0018-\\:\u0016\u0005\t\r\u0017aD2baR,(/\u001a3TW>dW-\\:\u0015\t\t\u0015B\u0011\u000f\u0005\b\u0005\u000fZ\u0006\u0019\u0001B\u0013\u0003Ay6-\u00199ukJ,GmU6pY\u0016l7/\u0001\u000b`G\u0006\u0004H/\u001e:fIN[w\u000e\\3ng~#S-\u001d\u000b\u0005\u0005\u0013!I\bC\u0005\u0004hv\u000b\t\u00111\u0001\u0003D\u0006\trlY1qiV\u0014X\rZ*l_2,Wn\u001d\u0011\u0002\u001f}\u001b\u0017\r\u001d;ve\u0016$\u0007+\u0019:b[N\f1cX2baR,(/\u001a3QCJ\fWn]0%KF$BA!\u0003\u0005\u0004\"I1q\u001d1\u0002\u0002\u0003\u0007!1Y\u0001\u0011?\u000e\f\u0007\u000f^;sK\u0012\u0004\u0016M]1ng\u0002\na\"[:Ti\u0006\u0014G.\u001a)sK\u001aL\u00070\u0006\u0002\u00032\u0005y\u0011n]*uC\ndW\r\u0015:fM&D\b%A\u000ejg\n\u000b7/Z\"mCN\u001cxJZ#oG2|7/\u001b8h\u00072\f7o\u001d\u000b\u0005\u0005c!\t\nC\u0004\u0005\u0014\u0012\u0004\rA!2\u0002\t\t\f7/Z\u0001\u001cSN$\u0016\u0010]3QCJ\fWn\u00144F]\u000edwn]5oO\u000ec\u0017m]:\u0015\t\tEB\u0011\u0014\u0005\b\u0005+,\u0007\u0019\u0001Bc\u0003=\u0019\u0017\r\u001d;ve\u0016$G\u000b[5t\u0013\u0012\u001cXC\u0001Bp\u0003M\u0019\u0017\r\u001d;ve\u0016$G\u000b[5t\u0013\u0012\u001cx\fJ3r)\u0011\u0011I\u0001b)\t\u0013\r\u001dx-!AA\u0002\t}\u0017\u0001E2baR,(/\u001a3UQ&\u001c\u0018\nZ:!\u0003IqW\r\u001f;DCB$XO]3e)\"L7/\u00133\u0015\u0005\t}\u0017aC2baR,(/\u001a+iSN$bA!\n\u00050\u0012E\u0006b\u0002C%U\u0002\u0007!Q\u0005\u0005\b\t\u0003R\u0007\u0019\u0001Bc\u00039\u0019\u0017\r\u001d;ve\u0016\u001c6n\u001c7f[N$BA!\u0003\u00058\"9A\u0011X6A\u0002\t\r\u0017aB:l_2,Wn]\u0001\u001aG>\u0014(/Z:q_:$\u0017N\\4UsB,\u0017I]4v[\u0016tG\u000f\u0006\u0004\u0003&\u0011}F1\u0019\u0005\b\t\u0003d\u0007\u0019\u0001B\u0013\u0003\ra\u0007n\u001d\u0005\b\t\u000bd\u0007\u0019\u0001B\u0013\u0003\r\u0011\bn]\u0001\u0015G2\f7o\u001d)be\u0006lW\r^3s\u0003N\u001cV-\u001a8\u0015\t\t\u0015B1\u001a\u0005\b\t\u001bl\u0007\u0019\u0001B\u0013\u0003)\u0019G.Y:t!\u0006\u0014\u0018-\\\u0001\u0016[\u0006$8\r[3t!J,g-\u001b=B]\u0012\u001cE.Y:t)\u0019!\u0019\u000e\"7\u0005\\R!!\u0011\u0007Ck\u0011\u001d!9N\u001ca\u0001\u0005\u000b\f\u0011bY1oI&$\u0017\r^3\t\u000f\u0011%c\u000e1\u0001\u0003&!9A\u0011\t8A\u0002\t\u0015\u0017aD<s_R,\u0017I\u001c8pi\u0006$\u0018n\u001c8\u0002+\u0005tgn\u001c;bi&|g.\u0011:h%\u0016<(/\u001b;feB\u0019A1]9\u000e\u0003M\u0013Q#\u00198o_R\fG/[8o\u0003J<'+Z<sSR,'oE\u0002r\tS\u00042\u0001b90)\t!\t/A\u0006nCR\u001c\u0007.Z:UQ&\u001cH\u0003\u0002B\u0019\tcDq\u0001b=t\u0001\u0004\u0011)-\u0001\u0003uQ&T\u0018a\u00028foRC\u0017n\u001d\u000b\u0003\u0007;!Ba!\b\u0005|\"91QF;A\u0002\ruACBB\u000f\t\u007f,\t\u0001C\u0004\u0004.Y\u0004\ra!\b\t\u000f\rUb\u000f1\u0001\u00048\u0005qA\u000f[5t)f\u0004X-Q:TK\u0016tG\u0003\u0002B\u0013\u000b\u000fAqAa\u0012x\u0001\u0004)I\u0001\u0005\u0003\u0003\u0014\u0015-\u0011\u0002BC\u0007\u0005W\u0011\u0001\u0002\u00165jgRK\b/Z\u0001\u0011g&tw\r\\3UsB,\u0017i]*fK:$BA!\n\u0006\u0014!9!q\t=A\u0002\u0015U\u0001\u0003\u0002B\n\u000b/IA!\"\u0007\u0003,\tQ1+\u001b8hY\u0016$\u0016\u0010]3\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!b\b\u0011\t\u0015\u0005Rq\u0006\b\u0005\u000bG)Y\u0003\u0005\u0003\u0006&\u0005UXBAC\u0014\u0015\u0011)IC!\u0002\u0002\rq\u0012xn\u001c;?\u0013\u0011)i#!>\u0002\rA\u0013X\rZ3g\u0013\u0011)\t$b\r\u0003\rM#(/\u001b8h\u0015\u0011)i#!>\t\u000f\u0011%#\u000b1\u0001\u0003&!9A\u0011\t*A\u0002\t\u0015\u0007f\u0002*\u0006<\u0015\u0005SQ\t\t\u0005\u0003{,i$\u0003\u0003\u0006@\u0005U(A\u00033faJ,7-\u0019;fI\u0006\u0012Q1I\u0001\u001ekN,\u0007E\\3xA\u0005\u001b8+Z3o\rJ|W.T1qA%t7\u000f^3bI\u0006\u0012QqI\u0001\u0007e9\n$G\f\u0019\u0003\u0011M+(m\u001d;NCB,B!\"\u0014\u0006XM\u0019!P!\u0007\u0002\t\u0019\u0014x.\\\u0001\u0003i>\u0004bAa,\u00036\u0016U\u0003\u0003\u0002B8\u000b/\"qAa\u001d{\u0005\u0004\u0011)\b\u0006\u0004\u0006\\\u0015uSq\f\t\u0006\u0005'QXQ\u000b\u0005\b\u000b\u001fj\b\u0019\u0001Bb\u0011\u001d)\t& a\u0001\u000b'\n\u0011C\u001a:p[\"\u000b7\u000fV3s[NKXNY8m\u0003\u001d1'o\\7NS:\fqA\u001a:p[6\u000b\u00070\u0001\u0005ge>l7+\u001b>f\u0003\u001di\u0017\r^2iKN$bA!\r\u0006n\u0015=\u0004\u0002\u0003Bk\u0003\u000b\u0001\rA!2\t\u0011\u0015E\u0014Q\u0001a\u0001\u0005\u000b\fAa]=nc\u00051Ao\u001c+za\u0016$bA!\n\u0006x\u0015m\u0004\u0002CC=\u0003\u000f\u0001\rA!\n\u0002\r\u0019\u0014x.\u001c;q\u0011!\u00119%a\u0002A\u0002\u0015U\u0013a\u0004:f]\u0006lWMQ8v]\u0012\u001c\u00160\\:\u0015\t\t\u0015R\u0011\u0011\u0005\t\u0005\u000f\nI\u00011\u0001\u0003&\u0005)1/\u001e2tiRQ!QECD\u000b\u0013+Y)\"$\t\u0011\t\u001d\u00131\u0002a\u0001\u0005KA\u0001B!6\u0002\f\u0001\u0007!Q\u0019\u0005\t\u000b\u001f\nY\u00011\u0001\u0003D\"AQ\u0011KA\u0006\u0001\u0004)\u0019\u0006\u000b\u0003\u0002\f\u0015E\u0005\u0003BCJ\u000b3k!!\"&\u000b\t\u0015]\u0015Q_\u0001\u000bC:tw\u000e^1uS>t\u0017\u0002BCN\u000b+\u0013q\u0001^1jYJ,7-\u0001\u0007ge>l7i\u001c8uC&t7\u000f\u0006\u0003\u00032\u0015\u0005\u0006\u0002CCR\u0003\u001b\u0001\rAa1\u0002\tMLXn\u001d\u000b\u0005\u0005K)9\u000b\u0003\u0005\u0006*\u0006=\u0001\u0019\u0001B\u0013\u0003\r!\b\u000f\r\u0002\f'V\u00147\u000f^*z[6\u000b\u0007o\u0005\u0003\u0002\u0012\u0015=\u0006#\u0002B\nu\n\u0015GCBCZ\u000bk+9\f\u0005\u0003\u0003\u0014\u0005E\u0001\u0002CC(\u0003/\u0001\rAa1\t\u0011\u0015E\u0013q\u0003a\u0001\u0005\u0007$B!b-\u0006<\"AQQXA\r\u0001\u0004)y,A\u0003qC&\u00148\u000f\u0005\u0004\u0002~\u0016\u0005WQY\u0005\u0005\u000b\u0007\f)P\u0001\u0006=e\u0016\u0004X-\u0019;fIz\u0002\u0002\"!@\u0006H\n\u0015'QY\u0005\u0005\u000b\u0013\f)P\u0001\u0004UkBdWM\r\u000b\u0007\u0005K)i-b4\t\u0011\u0015e\u00141\u0004a\u0001\u0005KA\u0001B!6\u0002\u001c\u0001\u0007!Q\u0019\u000b\t\u0005\u000b,\u0019.\"6\u0006X\"A!Q[A\u000f\u0001\u0004\u0011)\r\u0003\u0005\u0006P\u0005u\u0001\u0019\u0001Bb\u0011!)\t&!\bA\u0002\t\r\u0007\u0006BA\u000f\u000b#\u000b\u0001b];cgR4uN\u001d\u000b\u0005\u0005\u000b,y\u000e\u0003\u0005\u0003V\u0006}\u0001\u0019\u0001Bc)\u0011\u0011)#b9\t\u0011\t\u001d\u0013\u0011\u0005a\u0001\u0005K\ta\"\\1q)J,WmU=nE>d7\u000f\u0005\u0003\u0006j\u0006\u0015RBAA\t\u00059i\u0017\r\u001d+sK\u0016\u001c\u00160\u001c2pYN\u001cB!!\n\u0006pB\u0019Q\u0011^\u0018\u0015\u0005\u0015\u001d\u0018AC:ue&\u001cGoQ8qsV\u0011Qq\u001f\t\u0005\u0005')I0\u0003\u0003\u0006|\u000e\r\"A\u0003+sK\u0016\u001cu\u000e]5fe\u0006Y1\u000f\u001e:jGR\u001cu\u000e]=!\u0003)!XM]7NCB\u001cHk\u001c\u000b\u0005\r\u00071I\u0001\u0005\u0004\u0002~\u001a\u0015!QY\u0005\u0005\r\u000f\t)P\u0001\u0004PaRLwN\u001c\u0005\t\u0005+\fi\u00031\u0001\u0003F\u0006\tBO]1og\u001a|'/\\%g\u001b\u0006\u0004\b/\u001a3\u0015\t\u0019=aq\u0003\u000b\u0005\u0007;1\t\u0002\u0003\u0005\u0007\u0014\u0005=\u0002\u0019\u0001D\u000b\u0003\u0015!(/\u00198t!!\tiP!\t\u0003F\u000eu\u0001\u0002CB\u0017\u0003_\u0001\ra!\b\u0015\t\rua1\u0004\u0005\t\u0007[\t\t\u00041\u0001\u0004\u001eQ11Q\u0004D\u0010\rCA\u0001b!\f\u00024\u0001\u00071Q\u0004\u0005\t\u0007k\t\u0019\u00041\u0001\u00048\ta1+\u001e2tiRK\b/Z'baN!\u0011Q\u0007D\u0014!\u0015\u0011\u0019B\u001fB\u0013\u0003\u00151'o\\7!+\t\u0011i+A\u0002u_\u0002\"bA\"\r\u00074\u0019U\u0002\u0003\u0002B\n\u0003kA\u0001\"b\u0014\u0002@\u0001\u0007!1\u0019\u0005\t\u000b#\ny\u00041\u0001\u0003.R1!Q\u0005D\u001d\rwA\u0001\"\"\u001f\u0002B\u0001\u0007!Q\u0005\u0005\t\u0005\u000f\n\t\u00051\u0001\u0003&Q11Q\u0004D \r\u0003B\u0001b!\f\u0002D\u0001\u00071Q\u0004\u0005\t\u0007k\t\u0019\u00051\u0001\u00048\ta1+\u001e2tiRC\u0017n]'baN!\u0011Q\tB\r)\u00191IEb\u0013\u0007NA!!1CA#\u0011!)y%a\u0013A\u0002\t\u0015\u0007\u0002CC)\u0003\u0017\u0002\rA!\n\u0015\t\t\u0015b\u0011\u000b\u0005\t\u0005\u000f\ni\u00051\u0001\u0003&\t\u00012+\u001e2ti^KG\u000eZ2be\u0012l\u0015\r]\n\u0005\u0003\u001f\u0012I\u0002\u0006\u0003\u0007Z\u0019m\u0003\u0003\u0002B\n\u0003\u001fB\u0001\"b\u0014\u0002T\u0001\u0007!1\u0019\u000b\u0005\u0005K1y\u0006\u0003\u0005\u0003H\u0005U\u0003\u0019\u0001B\u0013\u0003QI5\u000fR3qK:$WM\u001c;D_2dWm\u0019;peB!!1CA-\u0005QI5\u000fR3qK:$WM\u001c;D_2dWm\u0019;peN!\u0011\u0011\fD5!\u0015\u0011\u0019B\u000fB\u0019)\t1\u0019\u0007\u0006\u0003\u0003\n\u0019=\u0004\u0002\u0003B$\u0003;\u0002\rA!\n\u0002/\u0005\u0003\bO]8yS6\fG/\u001a#fa\u0016tG-\u001a8u\u001b\u0006\u0004\b\u0003\u0002B\n\u0003C\u0012q#\u00119qe>D\u0018.\\1uK\u0012+\u0007/\u001a8eK:$X*\u00199\u0014\t\u0005\u0005$\u0011\u0004\u000b\u0003\rg\"BA!\n\u0007~!A!qIA3\u0001\u0004\u0011)CA\fJ]N$\u0018M\u001c;jCR,G)\u001a9f]\u0012,g\u000e^'baN1\u0011q\rB\r\t/\na\u0001]1sC6\u001c\u0018\u0001C1diV\fGn\u001d\u0019\u0015\r\u0019%e1\u0012DG!\u0011\u0011\u0019\"a\u001a\t\u0011\u0019\r\u0015Q\u000ea\u0001\u0005\u0007D\u0001B\"\"\u0002n\u0001\u0007!QV\u0001\t?\u0006\u001cG/^1mgB1\u0011Q DJ\u0005KIAA\"&\u0002v\n)\u0011I\u001d:bs\u0006iq,\u001a=jgR,g\u000e^5bYN\u0004b!!@\u0007\u0014\n\u0015\u0017aB1diV\fGn]\u000b\u0003\r#\u000bA\"\u001a=jgR,g\u000e^5bYN,\"A\"'\u0002%\u0015D\u0018n\u001d;f]RL\u0017\r\\:OK\u0016$W\rZ\u0001\f'R\f'\r\\3Be\u001e$\u0006\u000f\u0005\u0003\u0007*\u0006mTBAA4\u0005-\u0019F/\u00192mK\u0006\u0013x\r\u00169\u0014\t\u0005m\u00141 \u000b\u0003\rO\u000bq!\u001e8baBd\u0017\u0010\u0006\u0003\u00076\u001a]\u0006CBA\u007f\r\u000b\u0011)\u0003\u0003\u0005\u0007:\u0006}\u0004\u0019\u0001Bc\u0003\u0015\u0001\u0018M]1n\u00039)\u00070[:uK:$\u0018.\u00197G_J$BA!2\u0007@\"Aa\u0011YAA\u0001\u0004\u0011y.A\u0002qS\u0012\fQ\"\u00168ti\u0006\u0014G.Z!sOR\u0003\b\u0003\u0002DU\u0003\u000b\u0013Q\"\u00168ti\u0006\u0014G.Z!sOR\u00038\u0003BAC\u0003w$\"A\"2\u0015\t\u0019=g1\u001b\t\u0007\u0003{4)A\"5\u0011\u0011\u0005uXq\u0019Bc\u0005KA\u0001B\"/\u0002\n\u0002\u0007!QY\u0001\u0010'R\f'-\u001b7ju\u0016$\u0017I]4UaB!a\u0011VAG\u0005=\u0019F/\u00192jY&TX\rZ!sOR\u00038\u0003BAG\u0003w$\"Ab6\u0015\t\u0019Uf\u0011\u001d\u0005\t\rs\u000b\t\n1\u0001\u0003FR!!Q\u0005Ds\u0011!\u00119%a%A\u0002\t\u0015BCBB\u000f\rS4i\u000f\u0003\u0005\u0007l\u0006U\u0005\u0019AB\u000f\u0003\r\t'o\u001a\u0005\t\u0007k\t)\n1\u0001\u00048\u0005!r/\u001b7eG\u0006\u0014H\rV8UsB,g+\u0019:NCB\u0004BAa\u0005\u0002\u001a\n!r/\u001b7eG\u0006\u0014H\rV8UsB,g+\u0019:NCB\u001cB!!'\u0003\u001aQ\u0011a\u0011\u001f\u000b\u0005\u0005K1Y\u0010\u0003\u0005\u0003H\u0005u\u0005\u0019\u0001B\u0013\u0003I!\u0018\u0010]3WCJ$vn\u0014:jO&tW*\u00199\u0011\t\tM\u0011\u0011\u0015\u0002\u0013if\u0004XMV1s)>|%/[4j]6\u000b\u0007o\u0005\u0003\u0002\"\neAC\u0001D\u0000)\u0011\u0011)c\"\u0003\t\u0011\t\u001d\u0013Q\u0015a\u0001\u0005K\u0011\u0011cQ8oi\u0006Lgn]\"pY2,7\r^8s'\u0011\t9K\"\u001b\u0015\t\u001dEq1\u0003\t\u0005\u0005'\t9\u000b\u0003\u0005\u0003V\u0006-\u0006\u0019\u0001Bc)\u0011\u0011Iab\u0006\t\u0011\t\u001d\u0013Q\u0016a\u0001\u0005K!Ba!\b\b\u001c!Aa1^AX\u0001\u0004\u0019iBA\nGS2$XM\u001d+za\u0016\u001cu\u000e\u001c7fGR|'o\u0005\u0003\u00022\u001e\u0005\u0002#\u0002B\nu\t5\u0016!\u00019\u0011\u0011\u0005u(\u0011\u0005B\u0013\u0005c!Ba\"\u000b\b,A!!1CAY\u0011!9\u0019#!.A\u0002\u001d\u0015B\u0003BD\u0018\u000fs\u0001ba\"\r\b8\t\u0015RBAD\u001a\u0015\u00119)\u0004b\u0003\u0002\u0013%lW.\u001e;bE2,\u0017\u0002\u0002B\\\u000fgA\u0001Ba\u0012\u00028\u0002\u0007!Q\u0005\u000b\u0005\u0005\u00139i\u0004\u0003\u0005\u0003H\u0005e\u0006\u0019\u0001B\u0013\u0005Q\u0019u\u000e\u001c7fGR$\u0016\u0010]3D_2dWm\u0019;peV!q1ID&'\u0011\tYl\"\u0012\u0011\u000b\tM!hb\u0012\u0011\r\t=&QWD%!\u0011\u0011ygb\u0013\u0005\u0011\tM\u00141\u0018b\u0001\u0005k\n!\u0001\u001d4\u0011\u0011\u0005ux\u0011\u000bB\u0013\u000f\u0013JAab\u0015\u0002v\ny\u0001+\u0019:uS\u0006dg)\u001e8di&|g\u000e\u0006\u0003\bX\u001de\u0003C\u0002B\n\u0003w;I\u0005\u0003\u0005\bN\u0005}\u0006\u0019AD()\u00119ifb\u0018\u0011\r\u001dErqGD%\u0011!\u00119%!1A\u0002\t\u0015B\u0003\u0002B\u0005\u000fGB\u0001Ba\u0012\u0002D\u0002\u0007!Q\u0005\u0002\u0015\r>\u0014X)Y2i)f\u0004X\r\u0016:bm\u0016\u00148/\u001a:\u0014\t\u0005\u00157QV\u0001\u0002MBA\u0011Q B\u0011\u0005K\u0011I\u0001\u0006\u0003\bp\u001dE\u0004\u0003\u0002B\n\u0003\u000bD\u0001b\"\u001b\u0002J\u0002\u0007q1\u000e\u000b\u0005\u0005\u00139)\b\u0003\u0005\u0003H\u0005-\u0007\u0019\u0001B\u0013\u0005E1\u0015N\u001c3UsB,7i\u001c7mK\u000e$xN]\n\u0005\u0003\u001b<Y\bE\u0003\u0003\u0014i2)\f\u0006\u0003\b\u0000\u001d\u0005\u0005\u0003\u0002B\n\u0003\u001bD\u0001bb\t\u0002R\u0002\u0007qQ\u0005\u000b\u0005\u0005\u00139)\t\u0003\u0005\u0003H\u0005M\u0007\u0019\u0001B\u0013\u0003I)%O]8oK>,8oQ8mY\u0016\u001cGo\u001c:\u0011\t\tM\u0011q\u001b\u0002\u0013\u000bJ\u0014xN\\3pkN\u001cu\u000e\u001c7fGR|'o\u0005\u0003\u0002X\u001a%DCADE)\u0011\u0011Iab%\t\u0011\t\u001d\u00131\u001ca\u0001\u0005K\t\u0001#\u00193baR$vNT3x%VtW*\u00199\u0011\t\tM\u0011q\u001c\u0002\u0011C\u0012\f\u0007\u000f\u001e+p\u001d\u0016<(+\u001e8NCB\u001cB!a8\u0003\u001aQ\u0011qqS\u0001\u000eC\u0012\f\u0007\u000f\u001e+p\u001d\u0016<(+\u001e8\u0015\r\t\u0015w1UDS\u0011!!I%a9A\u0002\t\u0015\u0002\u0002\u0003Bk\u0003G\u0004\rA!2\u0015\t\t\u0015r\u0011\u0016\u0005\t\u0005\u000f\n)\u000f1\u0001\u0003&A!!QJDW\u0013\u00119y+!<\u0003\u0017MKXNY8m)\u0006\u0014G.\u001a")
public interface TypeMaps {
    public TypeMaps$normalizeAliases$ normalizeAliases();

    public TypeMaps$dropSingletonType$ dropSingletonType();

    public TypeMaps$abstractTypesToBounds$ abstractTypesToBounds();

    public TypeMaps$dropIllegalStarTypes$ dropIllegalStarTypes();

    public TypeMaps$wildcardExtrapolation$ wildcardExtrapolation();

    public TypeMaps$IsDependentCollector$ IsDependentCollector();

    public TypeMaps$ApproximateDependentMap$ ApproximateDependentMap();

    public TypeMaps$wildcardToTypeVarMap$ wildcardToTypeVarMap();

    public TypeMaps$typeVarToOriginMap$ typeVarToOriginMap();

    public TypeMaps$ErroneousCollector$ ErroneousCollector();

    public TypeMaps$adaptToNewRunMap$ adaptToNewRunMap();

    public static /* synthetic */ TypeMap rawToExistential$(TypeMaps $this) {
        return $this.rawToExistential();
    }

    default public TypeMap rawToExistential() {
        return new TypeMap((SymbolTable)this){
            private Set<Symbols.Symbol> expanded;
            private final /* synthetic */ SymbolTable $outer;

            private Set<Symbols.Symbol> expanded() {
                return this.expanded;
            }

            private void expanded_$eq(Set<Symbols.Symbol> x$1) {
                this.expanded = x$1;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public Types.Type apply(Types.Type tp) {
                Types.Type type;
                if (!(tp instanceof Types.TypeRef)) return this.mapOver(tp);
                Types.TypeRef typeRef = (Types.TypeRef)tp;
                Types.Type pre = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List<Types.Type> list = typeRef.args();
                Some<List<Types.Type>> some = List$.MODULE$.unapplySeq(list);
                if (some.isEmpty()) return this.mapOver(tp);
                if (some.get() == null) return this.mapOver(tp);
                if (((LinearSeqOptimized)some.get()).lengthCompare(0) != 0) return this.mapOver(tp);
                if (!this.$outer.isRawIfWithoutArgs(sym)) return this.mapOver(tp);
                if (this.expanded().contains(sym)) {
                    type = this.$outer.definitions().AnyRefTpe();
                    return type;
                }
                try {
                    this.expanded_$eq((Set)this.expanded().$plus(sym));
                    List<Symbols.Symbol> eparams = this.mapOver(this.$outer.typeParamsToExistentials(sym));
                    type = this.$outer.existentialAbstraction(eparams, this.$outer.typeRef(this.apply(pre), sym, eparams.map((Function1<Symbols.Symbol, Types.Type> & java.io.Serializable & Serializable)x$5 -> x$5.tpe(), List$.MODULE$.canBuildFrom())));
                    return type;
                }
                finally {
                    this.expanded_$eq((Set)this.expanded().$minus(sym));
                }
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super($outer);
                this.expanded = (Set)Set$.MODULE$.apply(Nil$.MODULE$);
            }

            private static /* synthetic */ Object $deserializeLambda$(SerializedLambda serializedLambda) {
                return LambdaDeserialize.bootstrap("lambdaDeserialize", new MethodHandle[]{$anonfun$apply$3(scala.reflect.internal.Symbols$Symbol )}, serializedLambda);
            }
        };
    }

    public static /* synthetic */ boolean isPossiblePrefix$(TypeMaps $this, Symbols.Symbol clazz) {
        return $this.isPossiblePrefix(clazz);
    }

    default public boolean isPossiblePrefix(Symbols.Symbol clazz) {
        return clazz.isClass() && !clazz.isPackageClass();
    }

    public static /* synthetic */ boolean skipPrefixOf$(TypeMaps $this, Types.Type pre, Symbols.Symbol clazz) {
        return $this.skipPrefixOf(pre, clazz);
    }

    default public boolean skipPrefixOf(Types.Type pre, Symbols.Symbol clazz) {
        return pre == ((Types)this).NoType() || pre == ((Types)this).NoPrefix() || !this.isPossiblePrefix(clazz);
    }

    public static /* synthetic */ AsSeenFromMap newAsSeenFromMap$(TypeMaps $this, Types.Type pre, Symbols.Symbol clazz) {
        return $this.newAsSeenFromMap(pre, clazz);
    }

    default public AsSeenFromMap newAsSeenFromMap(Types.Type pre, Symbols.Symbol clazz) {
        return new AsSeenFromMap((SymbolTable)this, pre, clazz);
    }

    public static void $init$(TypeMaps $this) {
    }

    public interface AnnotationFilter {
        public /* synthetic */ AnnotationInfos.AnnotationInfo scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$super$mapOver(AnnotationInfos.AnnotationInfo var1);

        public boolean keepAnnotation(AnnotationInfos.AnnotationInfo var1);

        default public AnnotationInfos.AnnotationInfo mapOver(AnnotationInfos.AnnotationInfo annot) {
            if (this.keepAnnotation(annot)) {
                return this.scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$super$mapOver(annot);
            }
            return ((AnnotationInfos)((Object)this.scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$$outer())).UnmappableAnnotation();
        }

        public /* synthetic */ TypeMaps scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$$outer();

        public static void $init$(AnnotationFilter $this) {
        }
    }

    public class AsSeenFromMap
    extends TypeMap
    implements KeepOnlyTypeConstraints {
        private volatile TypeMaps$AsSeenFromMap$annotationArgRewriter$ annotationArgRewriter$module;
        public final Symbols.Symbol scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromClass;
        private final Types.Type scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix;
        private List<Symbols.Symbol> _capturedSkolems;
        private List<Symbols.Symbol> _capturedParams;
        private final boolean isStablePrefix;
        private int capturedThisIds;
        public boolean scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation;

        @Override
        public boolean keepAnnotation(AnnotationInfos.AnnotationInfo annot) {
            return ((KeepOnlyTypeConstraints)this).keepAnnotation(annot);
        }

        @Override
        public /* synthetic */ AnnotationInfos.AnnotationInfo scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$super$mapOver(AnnotationInfos.AnnotationInfo annot) {
            return super.mapOver(annot);
        }

        @Override
        public AnnotationInfos.AnnotationInfo mapOver(AnnotationInfos.AnnotationInfo annot) {
            return ((AnnotationFilter)this).mapOver(annot);
        }

        private TypeMaps$AsSeenFromMap$annotationArgRewriter$ annotationArgRewriter() {
            if (this.annotationArgRewriter$module == null) {
                this.annotationArgRewriter$lzycompute$1();
            }
            return this.annotationArgRewriter$module;
        }

        public Types.Type scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix() {
            return this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix;
        }

        public List<Symbols.Symbol> capturedParams() {
            return this._capturedParams();
        }

        public List<Symbols.Symbol> capturedSkolems() {
            return this._capturedSkolems();
        }

        @Override
        public Types.Type apply(Types.Type tp) {
            Types.Type type;
            if (tp instanceof Types.ThisType) {
                Types.ThisType thisType = (Types.ThisType)tp;
                type = this.thisTypeAsSeen(thisType);
            } else {
                Types.TypeRef typeRef;
                Symbols.Symbol sym;
                Types.SingleType singleType;
                type = tp instanceof Types.SingleType ? ((singleType = (Types.SingleType)tp).sym().isPackageClass() ? singleType : this.singleTypeAsSeen(singleType)) : (tp instanceof Types.TypeRef && this.isTypeParamOfEnclosingClass(sym = (typeRef = (Types.TypeRef)tp).sym()) ? this.classParameterAsSeen(typeRef) : this.mapOver(tp));
            }
            return type;
        }

        private List<Symbols.Symbol> _capturedSkolems() {
            return this._capturedSkolems;
        }

        private void _capturedSkolems_$eq(List<Symbols.Symbol> x$1) {
            this._capturedSkolems = x$1;
        }

        private List<Symbols.Symbol> _capturedParams() {
            return this._capturedParams;
        }

        private void _capturedParams_$eq(List<Symbols.Symbol> x$1) {
            this._capturedParams = x$1;
        }

        private boolean isStablePrefix() {
            return this.isStablePrefix;
        }

        private boolean isBaseClassOfEnclosingClass(Symbols.Symbol base) {
            return !base.hasCompleteInfo() || this.loop$2(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromClass, base);
        }

        private boolean isTypeParamOfEnclosingClass(Symbols.Symbol sym) {
            return sym.isTypeParameter() && sym.owner().isClass() && this.isBaseClassOfEnclosingClass(sym.owner());
        }

        private int capturedThisIds() {
            return this.capturedThisIds;
        }

        private void capturedThisIds_$eq(int x$1) {
            this.capturedThisIds = x$1;
        }

        private int nextCapturedThisId() {
            this.capturedThisIds_$eq(this.capturedThisIds() + 1);
            return this.capturedThisIds();
        }

        public Types.Type captureThis(Types.Type pre, Symbols.Symbol clazz) {
            Types.Type type;
            Option option;
            block5: {
                List<Symbols.Symbol> list = this.capturedParams();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized find_these = list;
                while (!find_these.isEmpty()) {
                    Symbols.Symbol symbol = (Symbols.Symbol)find_these.head();
                    if (AsSeenFromMap.$anonfun$captureThis$1(clazz, symbol)) {
                        option = new Some(find_these.head());
                        break block5;
                    }
                    find_these = (LinearSeqOptimized)find_these.tail();
                }
                option = None$.MODULE$;
            }
            if (option instanceof Some) {
                type = ((Symbols.Symbol)((Some)option).value()).tpe();
            } else {
                Symbols.TypeSymbol qvar = (Symbols.TypeSymbol)clazz.freshExistential(".type", this.nextCapturedThisId()).setInfo(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().singletonBounds(pre));
                this._capturedParams_$eq(this._capturedParams().$colon$colon(qvar));
                this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(28).append("Captured This(").append(clazz.fullNameString()).append(") seen from ").append(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix()).append(": ").append(qvar.defString()).toString());
                type = qvar.tpe();
            }
            return type;
        }

        public void captureSkolems(List<Symbols.Symbol> skolems) {
            skolems.withFilter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)p -> BoxesRunTime.boxToBoolean(AsSeenFromMap.$anonfun$captureSkolems$1(this, p))).foreach((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)p -> {
                AsSeenFromMap.$anonfun$captureSkolems$2(this, p);
                return BoxedUnit.UNIT;
            });
        }

        /*
         * WARNING - void declaration
         */
        private Types.Type correspondingTypeArgument(Types.Type lhs, Types.Type rhs) {
            $colon$colon<Nothing$> $colon$colon;
            void require_requirement;
            boolean bl;
            void var10_10;
            void var9_9;
            void var5_5;
            void var4_4;
            if (!(lhs instanceof Types.TypeRef)) {
                throw new MatchError(lhs);
            }
            Types.TypeRef typeRef = (Types.TypeRef)lhs;
            Symbols.Symbol lhsSym = typeRef.sym();
            List<Types.Type> lhsArgs = typeRef.args();
            void lhsSym2 = var4_4;
            void lhsArgs2 = var5_5;
            if (!(rhs instanceof Types.TypeRef)) {
                throw new MatchError(rhs);
            }
            Types.TypeRef typeRef2 = (Types.TypeRef)rhs;
            Symbols.Symbol rhsSym = typeRef2.sym();
            List<Types.Type> rhsArgs = typeRef2.args();
            void rhsSym2 = var9_9;
            void rhsArgs2 = var10_10;
            SymbolTable symbolTable = this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer();
            Symbols.Symbol symbol = lhsSym2.owner();
            boolean bl2 = !(symbol != null ? !symbol.equals(rhsSym2) : rhsSym2 != null) ? true : (bl = false);
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable require_this = symbolTable;
            if (require_requirement == false) {
                throw require_this.throwRequirementError(AsSeenFromMap.$anonfun$correspondingTypeArgument$1((Symbols.Symbol)lhsSym2, (Symbols.Symbol)rhsSym2));
            }
            int argIndex = rhsSym2.typeParams().indexWhere(arg_0 -> AsSeenFromMap.$anonfun$correspondingTypeArgument$2$adapted((Symbols.Symbol)lhsSym2, arg_0));
            if (argIndex < 0) {
                boolean bl3;
                block22: {
                    List<Types.Type> list = rhs.parents();
                    if (list == null) {
                        throw null;
                    }
                    LinearSeqOptimized exists_these = list;
                    while (!exists_these.isEmpty()) {
                        if (((Types.Type)exists_these.head()).isErroneous()) {
                            bl3 = true;
                            break block22;
                        }
                        exists_these = (LinearSeqOptimized)exists_these.tail();
                    }
                    bl3 = false;
                }
                if (bl3) {
                    return this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().ErrorType();
                }
            }
            if (!rhsArgs2.isDefinedAt(argIndex)) {
                throw this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().abort(new StringBuilder(50).append("Something is wrong: cannot find ").append(lhs).append(" in applied type ").append(rhs).append("\n").append(this.explain$1((Symbols.Symbol)lhsSym2, (Symbols.Symbol)rhsSym2)).toString());
            }
            Types.Type targ = (Types.Type)rhsArgs2.apply(argIndex);
            SymbolTable symbolTable2 = this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer();
            if (lhsArgs2 == null) {
                throw null;
            }
            void var23_19 = lhsArgs2;
            void var22_20 = lhsArgs2;
            Object var21_21 = null;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
            while (true) {
                List mapConserve_loop$1_tail0;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                List mapConserve_loop$1_unchanged;
                List mapConserve_loop$1_pending;
                if (mapConserve_loop$1_pending.isEmpty()) {
                    if (mapConserve_loop$1_mappedHead == null) {
                        $colon$colon = mapConserve_loop$1_unchanged;
                        break;
                    }
                    mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                    $colon$colon = mapConserve_loop$1_mappedHead;
                    break;
                }
                Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                Object mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                    mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                    continue;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                if (mapConserve_loop$1_mappedHead1 == null) {
                    mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                }
                if (mapConserve_loop$1_mappedLast1 != null) {
                    mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                }
                mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
            }
            Types.Type result2 = symbolTable2.appliedType(targ, (List<Types.Type>)$colon$colon);
            SymbolTable symbolTable3 = this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer();
            Function0<String> & java.io.Serializable & Serializable intersect = () -> AsSeenFromMap.$anonfun$correspondingTypeArgument$6(this, result2, (Symbols.Symbol)lhsSym2, (Symbols.Symbol)rhsSym2);
            if (symbolTable3 == null) {
                throw null;
            }
            SymbolTable devWarningIf_this = symbolTable3;
            if (devWarningIf_this.isDeveloper() && AsSeenFromMap.$anonfun$correspondingTypeArgument$5((Symbols.Symbol)rhsSym2, (Symbols.Symbol)lhsSym2)) {
                void devWarningIf_msg;
                devWarningIf_this.devWarning((Function0<String>)devWarningIf_msg);
            }
            return result2;
        }

        /*
         * WARNING - void declaration
         */
        private Types.Type classParameterAsSeen(Types.Type classParam) {
            void var2_2;
            if (!(classParam instanceof Types.TypeRef)) {
                throw new MatchError(classParam);
            }
            Symbols.Symbol tparam = ((Types.TypeRef)classParam).sym();
            return this.loop$3(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix(), this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromClass, classParam, (Symbols.Symbol)var2_2);
        }

        public boolean scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$matchesPrefixAndClass(Types.Type pre, Symbols.Symbol clazz, Symbols.Symbol candidate) {
            Symbols.Symbol symbol = clazz;
            if (!(symbol != null ? !symbol.equals(candidate) : candidate != null)) {
                Types.Type type = pre instanceof Types.TypeVar ? ((Types.TypeVar)pre).origin() : pre;
                if (clazz.isRefinementClass() ? type.widen().typeSymbol().isSubClass(clazz) : type.widen().baseTypeIndex(clazz) != -1) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Trees.Tree mapOver(Trees.Tree tree, Function0<Nothing$> giveup) {
            Trees.Tree tree2;
            if (this.isStablePrefix()) {
                return this.annotationArgRewriter().transform(tree);
            }
            boolean saved = this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation;
            this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation = false;
            try {
                tree2 = this.annotationArgRewriter().transform(tree);
            }
            catch (Throwable throwable) {
                if (this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation) {
                    giveup.apply();
                } else {
                    this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation = saved;
                }
                throw throwable;
            }
            if (this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation) {
                giveup.apply();
                return tree2;
            }
            this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation = saved;
            return tree2;
        }

        private Types.Type thisTypeAsSeen(Types.ThisType tp) {
            return this.loop$4(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix(), this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromClass, tp);
        }

        /*
         * WARNING - void declaration
         */
        private Types.Type singleTypeAsSeen(Types.SingleType tp) {
            void var3_3;
            void var2_2;
            if (tp == null) {
                throw new MatchError((Object)null);
            }
            Types.Type pre = tp.pre();
            Symbols.Symbol sym = tp.sym();
            void pre2 = var2_2;
            void sym2 = var3_3;
            Types.Type pre1 = this.apply((Types.Type)pre2);
            if (pre1 == pre2) {
                return tp;
            }
            if (pre1.isStable()) {
                return this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().singleType(pre1, (Symbols.Symbol)sym2);
            }
            return pre1.memberType((Symbols.Symbol)sym2).resultType();
        }

        @Override
        public String toString() {
            return new StringBuilder(17).append("AsSeenFromMap(").append(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix()).append(", ").append(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromClass).append(")").toString();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ TypeMaps scala$reflect$internal$tpe$TypeMaps$KeepOnlyTypeConstraints$$$outer() {
            return this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer();
        }

        @Override
        public /* synthetic */ TypeMaps scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$$outer() {
            return this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer();
        }

        private final void annotationArgRewriter$lzycompute$1() {
            synchronized (this) {
                if (this.annotationArgRewriter$module == null) {
                    this.annotationArgRewriter$module = new TypeMaps$AsSeenFromMap$annotationArgRewriter$(this);
                }
                return;
            }
        }

        private final boolean loop$2(Symbols.Symbol encl, Symbols.Symbol base$1) {
            while (this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().isPossiblePrefix(encl)) {
                if (!encl.isSubClass(base$1)) {
                    encl = encl.owner().enclClass();
                    continue;
                }
                return true;
            }
            return false;
        }

        public static final /* synthetic */ boolean $anonfun$captureThis$1(Symbols.Symbol clazz$1, Symbols.Symbol x$6) {
            Symbols.Symbol symbol = x$6.owner();
            return !(symbol != null ? !symbol.equals(clazz$1) : clazz$1 != null);
        }

        public static final /* synthetic */ boolean $anonfun$captureSkolems$1(AsSeenFromMap $this, Symbols.Symbol p) {
            return !$this.capturedSkolems().contains(p);
        }

        public static final /* synthetic */ void $anonfun$captureSkolems$2(AsSeenFromMap $this, Symbols.Symbol p) {
            $this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(20).append("Captured ").append(p).append(" seen from ").append($this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix()).toString());
            $this._capturedSkolems_$eq($this._capturedSkolems().$colon$colon(p));
        }

        public static final /* synthetic */ String $anonfun$correspondingTypeArgument$1(Symbols.Symbol lhsSym$1, Symbols.Symbol rhsSym$1) {
            return new StringBuilder(28).append(lhsSym$1).append(" is not a type parameter of ").append(rhsSym$1).toString();
        }

        public static final /* synthetic */ boolean $anonfun$correspondingTypeArgument$2(Symbols.Symbol lhsSym$1, Symbols.Symbol x$9) {
            Names.Name name = lhsSym$1.name();
            Names.Name name2 = x$9.name();
            return !(name != null ? !name.equals(name2) : name2 != null);
        }

        private static final String own_s$1(Symbols.Symbol s) {
            return new StringBuilder(4).append(s.nameString()).append(" in ").append(s.owner().nameString()).toString();
        }

        private final String explain$1(Symbols.Symbol lhsSym$1, Symbols.Symbol rhsSym$1) {
            return ((StripMarginInterpolator)this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().StringContextStripMarginOps().apply(new StringContext(Predef$.MODULE$.wrapRefArray((Object[])new String[]{"|   sought  ", "\n               | classSym  ", "\n               |  tparams  ", "\n               |"})))).sm(Predef$.MODULE$.genericWrapArray(new Object[]{AsSeenFromMap.own_s$1(lhsSym$1), AsSeenFromMap.own_s$1(rhsSym$1), ((TraversableOnce)rhsSym$1.typeParams().map((Function1<Symbols.Symbol, String> & java.io.Serializable & Serializable)s -> AsSeenFromMap.own_s$1(s), List$.MODULE$.canBuildFrom())).mkString(", ")}));
        }

        private static final String msg$2(Types.Type result$1, Symbols.Symbol lhsSym$1, Symbols.Symbol rhsSym$1) {
            return new StringBuilder(50).append("Created ").append(result$1).append(", though could not find ").append(AsSeenFromMap.own_s$1(lhsSym$1)).append(" among tparams of ").append(AsSeenFromMap.own_s$1(rhsSym$1)).toString();
        }

        public static final /* synthetic */ boolean $anonfun$correspondingTypeArgument$5(Symbols.Symbol rhsSym$1, Symbols.Symbol lhsSym$1) {
            return !rhsSym$1.typeParams().contains(lhsSym$1);
        }

        public static final /* synthetic */ String $anonfun$correspondingTypeArgument$6(AsSeenFromMap $this, Types.Type result$1, Symbols.Symbol lhsSym$1, Symbols.Symbol rhsSym$1) {
            return new StringBuilder(60).append("Inconsistent tparam/owner views: had to fall back on names\n").append(AsSeenFromMap.msg$2(result$1, lhsSym$1, rhsSym$1)).append("\n").append($this.explain$1(lhsSym$1, rhsSym$1)).toString();
        }

        private static final Types.Type nextBase$1(Types.Type pre$1, Symbols.Symbol clazz$2) {
            return pre$1.baseType(clazz$2).deconst();
        }

        private final Types.Type loop$3(Types.Type pre, Symbols.Symbol clazz, Types.Type classParam$1, Symbols.Symbol tparam$1) {
            Types.Type type;
            block4: {
                while (true) {
                    if (this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().skipPrefixOf(pre, clazz)) {
                        return this.mapOver(classParam$1);
                    }
                    if (!this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$matchesPrefixAndClass(pre, clazz, tparam$1.owner())) {
                        Types.Type type2 = AsSeenFromMap.nextBase$1(pre, clazz).prefix();
                        clazz = clazz.owner();
                        pre = type2;
                        continue;
                    }
                    type = AsSeenFromMap.nextBase$1(pre, clazz);
                    if (this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().NoType().equals(type)) {
                        clazz = clazz.owner();
                        pre = this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().NoType();
                        continue;
                    }
                    if (type instanceof Types.TypeRef) break block4;
                    if (!(type instanceof Types.ExistentialType)) break;
                    Types.ExistentialType existentialType = (Types.ExistentialType)type;
                    List<Symbols.Symbol> eparams = existentialType.quantified();
                    Types.Type qtpe = existentialType.underlying();
                    this.captureSkolems(eparams);
                    pre = qtpe;
                }
                throw this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().abort(new StringBuilder(33).append(tparam$1).append(" in ").append(tparam$1.owner()).append(" cannot be instantiated from ").append(this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix().widen()).toString());
            }
            Types.TypeRef typeRef = (Types.TypeRef)type;
            Types.Type type3 = this.correspondingTypeArgument(classParam$1, typeRef);
            return type3;
        }

        private final Types.Type loop$4(Types.Type pre, Symbols.Symbol clazz, Types.ThisType tp$2) {
            Types.Type type;
            while (true) {
                type = pre instanceof Types.SuperType ? ((Types.SuperType)pre).thistpe() : pre;
                if (this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$$outer().skipPrefixOf(pre, clazz)) {
                    return this.mapOver(tp$2);
                }
                if (this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$matchesPrefixAndClass(pre, clazz, tp$2.sym())) break;
                Types.Type type2 = pre.baseType(clazz).prefix();
                clazz = clazz.owner();
                pre = type2;
            }
            if (type.isStable()) {
                return type;
            }
            return this.captureThis(type, clazz);
        }

        public AsSeenFromMap(SymbolTable $outer, Types.Type seenFromPrefix0, Symbols.Symbol seenFromClass) {
            this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromClass = seenFromClass;
            super($outer);
            AnnotationFilter.$init$(this);
            KeepOnlyTypeConstraints.$init$(this);
            this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix = seenFromPrefix0.typeSymbolDirect().hasPackageFlag() && !seenFromClass.hasPackageFlag() ? seenFromPrefix0.packageObject().typeOfThis() : seenFromPrefix0;
            this._capturedSkolems = Nil$.MODULE$;
            this._capturedParams = Nil$.MODULE$;
            this.isStablePrefix = this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$seenFromPrefix().isStable();
            this.capturedThisIds = 0;
            this.scala$reflect$internal$tpe$TypeMaps$AsSeenFromMap$$wroteAnnotation = false;
        }

        public static final /* synthetic */ Object $anonfun$captureThis$1$adapted(Symbols.Symbol clazz$1, Symbols.Symbol x$6) {
            return BoxesRunTime.boxToBoolean(AsSeenFromMap.$anonfun$captureThis$1(clazz$1, x$6));
        }

        public static final /* synthetic */ Object $anonfun$correspondingTypeArgument$2$adapted(Symbols.Symbol lhsSym$1, Symbols.Symbol x$9) {
            return BoxesRunTime.boxToBoolean(AsSeenFromMap.$anonfun$correspondingTypeArgument$2(lhsSym$1, x$9));
        }

        public static final /* synthetic */ Object $anonfun$correspondingTypeArgument$3$adapted(Types.Type x$10) {
            return BoxesRunTime.boxToBoolean(x$10.isErroneous());
        }
    }

    public class CollectTypeCollector<T>
    extends TypeCollector<List<T>> {
        private final PartialFunction<Types.Type, T> pf;

        @Override
        public List<T> collect(Types.Type tp) {
            return ((List)super.collect(tp)).reverse();
        }

        @Override
        public void traverse(Types.Type tp) {
            if (this.pf.isDefinedAt(tp)) {
                this.result_$eq(((List)this.result()).$colon$colon(this.pf.apply(tp)));
            }
            this.mapOver(tp);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$CollectTypeCollector$$$outer() {
            return this.$outer;
        }

        public CollectTypeCollector(SymbolTable $outer, PartialFunction<Types.Type, T> pf) {
            this.pf = pf;
            super($outer, Nil$.MODULE$);
        }
    }

    public class ContainsCollector
    extends TypeCollector<Object> {
        private final Symbols.Symbol sym;

        @Override
        public void traverse(Types.Type tp) {
            if (!BoxesRunTime.unboxToBoolean(this.result())) {
                if (tp instanceof Types.ExistentialType) {
                    this.mapOver(tp);
                    return;
                }
                Types.Type type = tp.normalize();
                if (type instanceof Types.TypeRef) {
                    Symbols.Symbol sym1 = ((Types.TypeRef)type).sym();
                    Symbols.Symbol symbol = this.sym;
                    if (!(symbol != null ? !symbol.equals(sym1) : sym1 != null)) {
                        this.result_$eq(BoxesRunTime.boxToBoolean(true));
                        return;
                    }
                }
                if (type instanceof Types.RefinedType) {
                    Types.RefinedType refinedType = (Types.RefinedType)type;
                    this.mapOver(tp.prefix());
                    this.mapOver(refinedType);
                    return;
                }
                if (type instanceof Types.SingleType) {
                    Symbols.Symbol sym1 = ((Types.SingleType)type).sym();
                    Symbols.Symbol symbol = this.sym;
                    if (!(symbol != null ? !symbol.equals(sym1) : sym1 != null)) {
                        this.result_$eq(BoxesRunTime.boxToBoolean(true));
                        return;
                    }
                }
                this.mapOver(tp);
                return;
            }
        }

        @Override
        public Trees.Tree mapOver(Trees.Tree arg) {
            arg.foreach((Function1<Trees.Tree, BoxedUnit>)(Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)t -> {
                ContainsCollector.$anonfun$mapOver$6(this, t);
                return BoxedUnit.UNIT;
            });
            return arg;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$ContainsCollector$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ void $anonfun$mapOver$6(ContainsCollector $this, Trees.Tree t) {
            block7: {
                block6: {
                    Symbols.Symbol symbol;
                    Symbols.Symbol symbol2;
                    block5: {
                        $this.traverse(t.tpe());
                        symbol2 = t.symbol();
                        symbol = $this.sym;
                        if (symbol2 != null) break block5;
                        if (symbol != null) {
                            return;
                        }
                        break block6;
                    }
                    if (!symbol2.equals(symbol)) break block7;
                }
                $this.result_$eq(BoxesRunTime.boxToBoolean(true));
            }
        }

        public ContainsCollector(SymbolTable $outer, Symbols.Symbol sym) {
            this.sym = sym;
            super($outer, BoxesRunTime.boxToBoolean(false));
        }
    }

    public class ExistentialExtrapolation
    extends TypeMap {
        private final List<Symbols.Symbol> tparams;
        private final HashMap<Symbols.Symbol, Object> occurCount;

        private HashMap<Symbols.Symbol, Object> occurCount() {
            return this.occurCount;
        }

        private void countOccs(Types.Type tp) {
            tp.foreach((Function1<Types.Type, BoxedUnit>)(Function1<Types.Type, Object> & java.io.Serializable & Serializable)x0$1 -> {
                ExistentialExtrapolation.$anonfun$countOccs$1(this, x0$1);
                return BoxedUnit.UNIT;
            });
        }

        public Types.Type extrapolate(Types.Type tpe) {
            List list = this.tparams;
            if (list == null) {
                throw null;
            }
            List foreach_these = list;
            while (!foreach_these.isEmpty()) {
                Symbols.Symbol symbol = foreach_these.head();
                ExistentialExtrapolation.$anonfun$extrapolate$1(this, symbol);
                foreach_these = (List)foreach_these.tail();
            }
            this.countOccs(tpe);
            List list2 = this.tparams;
            if (list2 == null) {
                throw null;
            }
            List foreach_these2 = list2;
            while (!foreach_these2.isEmpty()) {
                Symbols.Symbol symbol = foreach_these2.head();
                this.countOccs(symbol.info());
                foreach_these2 = (List)foreach_these2.tail();
            }
            return this.apply(tpe);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        @Override
        public Types.Type apply(Types.Type tp) {
            block9: {
                block8: {
                    block7: {
                        tp1 = this.mapOver(tp);
                        if (Variance$.MODULE$.isInvariant$extension(this.variance())) {
                            return tp1;
                        }
                        if (!(tp1 instanceof Types.TypeRef) || !this.tparams.contains(sym = ((Types.TypeRef)tp1).sym()) || BoxesRunTime.unboxToInt(this.occurCount().apply(sym)) != 1) break block8;
                        v0 = repl = Variance$.MODULE$.isPositive$extension(this.variance()) != false ? this.scala$reflect$internal$tpe$TypeMaps$ExistentialExtrapolation$$$outer().dropSingletonType().apply(tp1.upperBound()) : tp1.lowerBound();
                        if (repl.typeSymbol().isBottomClass()) ** GOTO lbl-1000
                        v1 = this.tparams;
                        if (v1 == null) {
                            throw null;
                        }
                        exists_these /* !! */  = v1;
                        while (!exists_these /* !! */ .isEmpty()) {
                            var9_6 = (Symbols.Symbol)exists_these /* !! */ .head();
                            if (ExistentialExtrapolation.$anonfun$apply$4(repl, var9_6)) {
                                var7_7 = true;
                                break block7;
                            }
                            exists_these /* !! */  = (LinearSeqOptimized)exists_these /* !! */ .tail();
                        }
                        var7_7 = false;
                    }
                    if (!var7_7) {
                        v2 = this.scala$reflect$internal$tpe$TypeMaps$ExistentialExtrapolation$$$outer();
                        var8_8 = (Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$apply$5(scala.reflect.internal.tpe.TypeMaps$ExistentialExtrapolation scala.reflect.internal.Types$Type ), ()Ljava/lang/String;)((ExistentialExtrapolation)this, (Types.Type)tp1);
                        if (v2 == null) {
                            throw null;
                        }
                        v2.debuglog((Function0<String> & java.io.Serializable & Serializable)LambdaMetafactory.altMetafactory(null, null, null, ()Ljava/lang/Object;, $anonfun$debuglogResult$1(scala.Function0 java.lang.Object ), ()Ljava/lang/String;)((Function0)debuglogResult_msg, (Object)repl));
                        v3 = repl;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v3 = tp1;
                    }
                    var2_9 = v3;
                    break block9;
                }
                var2_9 = tp1;
            }
            return var2_9;
        }

        @Override
        public Types.Type mapOver(Types.Type tp) {
            Types.Type type;
            if (tp instanceof Types.SingleType) {
                Types.Type pre1;
                Types.SingleType singleType = (Types.SingleType)tp;
                Types.Type pre = singleType.pre();
                Symbols.Symbol sym = singleType.sym();
                type = sym.isPackageClass() ? tp : ((pre1 = this.apply(pre)) == pre || !pre1.isStable() ? tp : this.scala$reflect$internal$tpe$TypeMaps$ExistentialExtrapolation$$$outer().singleType(pre1, sym));
            } else {
                type = super.mapOver(tp);
            }
            return type;
        }

        @Override
        public Trees.Tree mapOver(Trees.Tree tree) {
            Trees.Tree tree2 = tree instanceof Trees.Ident && tree.tpe().isStable() ? tree : super.mapOver(tree);
            return tree2;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$ExistentialExtrapolation$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ void $anonfun$countOccs$1(ExistentialExtrapolation $this, Types.Type x0$1) {
            Symbols.Symbol sym;
            if (x0$1 instanceof Types.TypeRef && $this.tparams.contains(sym = ((Types.TypeRef)x0$1).sym())) {
                $this.occurCount().update(sym, BoxesRunTime.boxToInteger(BoxesRunTime.unboxToInt($this.occurCount().apply(sym)) + 1));
                return;
            }
        }

        public static final /* synthetic */ void $anonfun$extrapolate$1(ExistentialExtrapolation $this, Symbols.Symbol t) {
            $this.occurCount().update(t, BoxesRunTime.boxToInteger(0));
        }

        private final String msg$1(Types.Type tp1$1) {
            String word = Variance$.MODULE$.isPositive$extension(this.variance()) ? "upper" : "lower";
            return new StringBuilder(56).append("Widened lone occurrence of ").append(tp1$1).append(" inside existential to ").append(word).append(" bound").toString();
        }

        public static final /* synthetic */ String $anonfun$apply$5(ExistentialExtrapolation $this, Types.Type tp1$1) {
            return $this.msg$1(tp1$1);
        }

        public ExistentialExtrapolation(SymbolTable $outer, List<Symbols.Symbol> tparams) {
            this.tparams = tparams;
            super($outer, true);
            this.occurCount = (HashMap)HashMap$.MODULE$.apply(Nil$.MODULE$);
        }

        public static final /* synthetic */ Object $anonfun$extrapolate$1$adapted(ExistentialExtrapolation $this, Symbols.Symbol t) {
            ExistentialExtrapolation.$anonfun$extrapolate$1($this, t);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$extrapolate$2$adapted(ExistentialExtrapolation $this, Symbols.Symbol tparam) {
            $this.countOccs(tparam.info());
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$apply$4$adapted(Types.Type repl$1, Symbols.Symbol sym) {
            return BoxesRunTime.boxToBoolean(repl$1.contains(sym));
        }
    }

    public class FilterTypeCollector
    extends TypeCollector<List<Types.Type>> {
        private final Function1<Types.Type, Object> p;

        @Override
        public List<Types.Type> collect(Types.Type tp) {
            return ((List)super.collect(tp)).reverse();
        }

        @Override
        public void traverse(Types.Type tp) {
            if (BoxesRunTime.unboxToBoolean(this.p.apply(tp))) {
                this.result_$eq(((List)this.result()).$colon$colon(tp));
            }
            this.mapOver(tp);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$FilterTypeCollector$$$outer() {
            return this.$outer;
        }

        public FilterTypeCollector(SymbolTable $outer, Function1<Types.Type, Object> p) {
            this.p = p;
            super($outer, Nil$.MODULE$);
        }
    }

    public class FindTypeCollector
    extends TypeCollector<Option<Types.Type>> {
        private final Function1<Types.Type, Object> p;

        @Override
        public void traverse(Types.Type tp) {
            if (((Option)this.result()).isEmpty()) {
                if (BoxesRunTime.unboxToBoolean(this.p.apply(tp))) {
                    this.result_$eq(new Some<Types.Type>(tp));
                }
                this.mapOver(tp);
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$FindTypeCollector$$$outer() {
            return this.$outer;
        }

        public FindTypeCollector(SymbolTable $outer, Function1<Types.Type, Object> p) {
            this.p = p;
            super($outer, None$.MODULE$);
        }
    }

    public class ForEachTypeTraverser
    extends TypeTraverser {
        private final Function1<Types.Type, BoxedUnit> f;

        @Override
        public void traverse(Types.Type tp) {
            this.f.apply(tp);
            this.mapOver(tp);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$ForEachTypeTraverser$$$outer() {
            return this.$outer;
        }

        public ForEachTypeTraverser(SymbolTable $outer, Function1<Types.Type, BoxedUnit> f) {
            this.f = f;
            super($outer);
        }
    }

    public class InstantiateDependentMap
    extends TypeMap
    implements KeepOnlyTypeConstraints {
        private volatile TypeMaps$InstantiateDependentMap$StableArgTp$ StableArgTp$module;
        private volatile TypeMaps$InstantiateDependentMap$UnstableArgTp$ UnstableArgTp$module;
        private volatile TypeMaps$InstantiateDependentMap$StabilizedArgTp$ StabilizedArgTp$module;
        public final List<Symbols.Symbol> scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$params;
        private final List<Types.Type> actuals0;
        private Types.Type[] _actuals;
        private Symbols.Symbol[] _existentials;

        @Override
        public boolean keepAnnotation(AnnotationInfos.AnnotationInfo annot) {
            return ((KeepOnlyTypeConstraints)this).keepAnnotation(annot);
        }

        @Override
        public /* synthetic */ AnnotationInfos.AnnotationInfo scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$super$mapOver(AnnotationInfos.AnnotationInfo annot) {
            return super.mapOver(annot);
        }

        @Override
        public AnnotationInfos.AnnotationInfo mapOver(AnnotationInfos.AnnotationInfo annot) {
            return ((AnnotationFilter)this).mapOver(annot);
        }

        public TypeMaps$InstantiateDependentMap$StableArgTp$ scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$StableArgTp() {
            if (this.StableArgTp$module == null) {
                this.StableArgTp$lzycompute$1();
            }
            return this.StableArgTp$module;
        }

        public TypeMaps$InstantiateDependentMap$UnstableArgTp$ scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$UnstableArgTp() {
            if (this.UnstableArgTp$module == null) {
                this.UnstableArgTp$lzycompute$1();
            }
            return this.UnstableArgTp$module;
        }

        private TypeMaps$InstantiateDependentMap$StabilizedArgTp$ StabilizedArgTp() {
            if (this.StabilizedArgTp$module == null) {
                this.StabilizedArgTp$lzycompute$1();
            }
            return this.StabilizedArgTp$module;
        }

        public Types.Type[] scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$actuals() {
            if (this._actuals == null) {
                Types.Type[] temp = new Types.Type[this.actuals0.size()];
                List l = this.actuals0;
                for (int i = 0; i < temp.length; ++i) {
                    temp[i] = l.head();
                    l = (List)l.tail();
                }
                this._actuals = temp;
            }
            return this._actuals;
        }

        private Symbols.Symbol[] existentials() {
            if (this._existentials == null) {
                this._existentials = new Symbols.Symbol[this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$actuals().length];
            }
            return this._existentials;
        }

        public List<Symbols.Symbol> existentialsNeeded() {
            if (this._existentials == null) {
                return Nil$.MODULE$;
            }
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.existentials())).iterator().filter((Function1<Object, Object>)(Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)x$14 -> BoxesRunTime.boxToBoolean(InstantiateDependentMap.$anonfun$existentialsNeeded$1(x$14))).toList();
        }

        public Symbols.Symbol scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$existentialFor(int pid) {
            if (this.existentials()[pid] == null) {
                Symbols.Symbol param2 = this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$params.apply(pid);
                this.existentials()[pid] = param2.owner().newExistential((Names.TypeName)param2.name().toTypeName().append(".type"), param2.pos(), param2.flags()).setInfo(this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$$outer().singletonBounds(this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$actuals()[pid]));
            }
            return this.existentials()[pid];
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Types.Type apply(Types.Type tp) {
            if (!(tp instanceof Types.SingleType)) return this.mapOver(tp);
            Types.SingleType singleType = (Types.SingleType)tp;
            Types.Type type = singleType.pre();
            Symbols.Symbol symbol = singleType.sym();
            if (!this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$$outer().NoPrefix().equals(type)) return this.mapOver(tp);
            Option<Types.Type> option = this.StabilizedArgTp().unapply(symbol);
            if (option.isEmpty()) return this.mapOver(tp);
            return option.get();
        }

        @Override
        public Trees.Tree mapOver(Trees.Tree arg, Function0<Nothing$> giveup) {
            LazyRef treeTrans$module = new LazyRef();
            return this.treeTrans$2(treeTrans$module).transform(arg);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ TypeMaps scala$reflect$internal$tpe$TypeMaps$KeepOnlyTypeConstraints$$$outer() {
            return this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$$outer();
        }

        @Override
        public /* synthetic */ TypeMaps scala$reflect$internal$tpe$TypeMaps$AnnotationFilter$$$outer() {
            return this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$$outer();
        }

        private final void StableArgTp$lzycompute$1() {
            synchronized (this) {
                if (this.StableArgTp$module == null) {
                    this.StableArgTp$module = new TypeMaps$InstantiateDependentMap$StableArgTp$(this);
                }
                return;
            }
        }

        private final void UnstableArgTp$lzycompute$1() {
            synchronized (this) {
                if (this.UnstableArgTp$module == null) {
                    this.UnstableArgTp$module = new TypeMaps$InstantiateDependentMap$UnstableArgTp$(this);
                }
                return;
            }
        }

        private final void StabilizedArgTp$lzycompute$1() {
            synchronized (this) {
                if (this.StabilizedArgTp$module == null) {
                    this.StabilizedArgTp$module = new TypeMaps$InstantiateDependentMap$StabilizedArgTp$(this);
                }
                return;
            }
        }

        public static final /* synthetic */ boolean $anonfun$existentialsNeeded$1(Symbols.Symbol x$14) {
            return x$14 != null;
        }

        private final /* synthetic */ TypeMaps$InstantiateDependentMap$treeTrans$1$ treeTrans$lzycompute$1(LazyRef treeTrans$module$1) {
            synchronized (treeTrans$module$1) {
                TypeMaps$InstantiateDependentMap$treeTrans$1$ typeMaps$InstantiateDependentMap$treeTrans$1$ = treeTrans$module$1.initialized() ? (TypeMaps$InstantiateDependentMap$treeTrans$1$)treeTrans$module$1.value() : treeTrans$module$1.initialize(new TypeMaps$InstantiateDependentMap$treeTrans$1$(this));
                return typeMaps$InstantiateDependentMap$treeTrans$1$;
            }
        }

        private final TypeMaps$InstantiateDependentMap$treeTrans$1$ treeTrans$2(LazyRef treeTrans$module$1) {
            if (treeTrans$module$1.initialized()) {
                return (TypeMaps$InstantiateDependentMap$treeTrans$1$)treeTrans$module$1.value();
            }
            return this.treeTrans$lzycompute$1(treeTrans$module$1);
        }

        public InstantiateDependentMap(SymbolTable $outer, List<Symbols.Symbol> params, List<Types.Type> actuals0) {
            this.scala$reflect$internal$tpe$TypeMaps$InstantiateDependentMap$$params = params;
            this.actuals0 = actuals0;
            super($outer);
            AnnotationFilter.$init$(this);
            KeepOnlyTypeConstraints.$init$(this);
        }
    }

    public interface KeepOnlyTypeConstraints
    extends AnnotationFilter {
        @Override
        default public boolean keepAnnotation(AnnotationInfos.AnnotationInfo annot) {
            return annot.matches(((Definitions)((Object)this.scala$reflect$internal$tpe$TypeMaps$KeepOnlyTypeConstraints$$$outer())).definitions().TypeConstraintClass());
        }

        public /* synthetic */ TypeMaps scala$reflect$internal$tpe$TypeMaps$KeepOnlyTypeConstraints$$$outer();

        public static void $init$(KeepOnlyTypeConstraints $this) {
        }
    }

    public abstract class SubstMap<T>
    extends TypeMap {
        private final List<Symbols.Symbol> from;
        private final List<T> to;
        private boolean fromHasTermSymbol;
        private int fromMin;
        private int fromMax;
        private int fromSize;

        public boolean matches(Symbols.Symbol sym, Symbols.Symbol sym1) {
            return sym == sym1;
        }

        public abstract Types.Type toType(Types.Type var1, T var2);

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Types.Type renameBoundSyms(Types.Type tp) {
            if (tp instanceof Types.MethodType) {
                Types.MethodType methodType = (Types.MethodType)tp;
                List<Symbols.Symbol> ps = methodType.params();
                Types.Type restp = methodType.resultType();
                if (this.fromHasTermSymbol && this.fromContains(ps)) {
                    return (Types.Type)this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().createFromClonedSymbols(ps, restp, (Function2<List, Types.Type, Types.Type> & java.io.Serializable & Serializable)(ps1, tp1) -> this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().copyMethodType(tp, (List<Symbols.Symbol>)ps1, (Types.Type)tp1));
                }
            }
            if (tp instanceof Types.PolyType) {
                Types.PolyType polyType = (Types.PolyType)tp;
                List<Symbols.Symbol> bs = polyType.typeParams();
                Types.Type restp = polyType.resultType();
                if (this.fromContains(bs)) {
                    return (Types.Type)this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().createFromClonedSymbols(bs, restp, (Function2<List, Types.Type, Types.PolyType> & java.io.Serializable & Serializable)(ps1, tp1) -> new Types.PolyType(this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer(), (List<Symbols.Symbol>)ps1, (Types.Type)tp1));
                }
            }
            if (!(tp instanceof Types.ExistentialType)) return tp;
            Types.ExistentialType existentialType = (Types.ExistentialType)tp;
            List<Symbols.Symbol> bs = existentialType.quantified();
            Types.Type restp = existentialType.underlying();
            if (!this.fromContains(bs)) return tp;
            return (Types.Type)this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().createFromClonedSymbols(bs, restp, (Function2<List, Types.Type, Types.Type> & java.io.Serializable & Serializable)(quantified, underlying) -> this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().newExistentialType((List<Symbols.Symbol>)quantified, (Types.Type)underlying));
        }

        private Types.Type subst(Types.Type tp, Symbols.Symbol sym, List<Symbols.Symbol> from, List<T> to) {
            while (!from.isEmpty()) {
                if (this.matches(from.head(), sym)) {
                    return this.toType(tp, to.head());
                }
                to = (List)to.tail();
                from = (List)from.tail();
            }
            return tp;
        }

        private boolean fromContains(List<Symbols.Symbol> syms) {
            for (List syms1 = syms; syms1 != Nil$.MODULE$; syms1 = (List)syms1.tail()) {
                Symbols.Symbol sym = syms1.head();
                if (!this.fromContains$1(sym)) continue;
                return true;
            }
            return false;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Types.Type apply(Types.Type tp0) {
            if (this.from.isEmpty()) {
                return tp0;
            }
            Types.Type tp = this.mapOver(this.renameBoundSyms(tp0));
            if (tp instanceof Types.TypeRef) {
                Types.TypeRef typeRef = (Types.TypeRef)tp;
                Types.Type type = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List<Types.Type> args2 = typeRef.args();
                if (this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().NoPrefix().equals(type)) {
                    Types.Type tcon = this.substFor$1(sym, tp);
                    return tp == tcon || args2.isEmpty() ? tcon : this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().appliedType(tcon.typeConstructor(), args2);
                }
            }
            if (tp instanceof Types.SingleType) {
                Types.SingleType singleType = (Types.SingleType)tp;
                Types.Type type = singleType.pre();
                Symbols.Symbol sym = singleType.sym();
                if (this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer().NoPrefix().equals(type)) {
                    return this.substFor$1(sym, tp);
                }
            }
            if (!(tp instanceof Types.ClassInfoType)) return tp;
            Types.ClassInfoType classInfoType = (Types.ClassInfoType)tp;
            List<Types.Type> parents = classInfoType.parents();
            Scopes.Scope decls = classInfoType.decls();
            Symbols.Symbol sym = classInfoType.typeSymbol();
            if (parents == null) {
                throw null;
            }
            List<Types.Type> list = parents;
            List<Types.Type> list2 = parents;
            Object var17_18 = null;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
            while (true) {
                List mapConserve_loop$1_tail0;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                List mapConserve_loop$1_unchanged;
                List mapConserve_loop$1_pending;
                if (mapConserve_loop$1_pending.isEmpty()) {
                    $colon$colon<Nothing$> $colon$colon;
                    if (mapConserve_loop$1_mappedHead == null) {
                        $colon$colon = mapConserve_loop$1_unchanged;
                        return $colon$colon == parents ? tp : new Types.ClassInfoType(this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer(), $colon$colon, decls, sym);
                    }
                    mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                    $colon$colon = mapConserve_loop$1_mappedHead;
                    return $colon$colon == parents ? tp : new Types.ClassInfoType(this.scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer(), $colon$colon, decls, sym);
                }
                Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                Object mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                    mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                    continue;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                if (mapConserve_loop$1_mappedHead1 == null) {
                    mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                }
                if (mapConserve_loop$1_mappedLast1 != null) {
                    mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                }
                mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$SubstMap$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$new$1(SubstMap $this) {
            return new StringBuilder(30).append("Unsound substitution from ").append($this.from).append(" to ").append($this.to).toString();
        }

        public static final /* synthetic */ void $anonfun$new$2(SubstMap $this, Symbols.Symbol sym) {
            $this.fromMin = package$.MODULE$.min($this.fromMin, sym.id());
            $this.fromMax = package$.MODULE$.max($this.fromMax, sym.id());
            ++$this.fromSize;
            if (sym.isTerm()) {
                $this.fromHasTermSymbol = true;
            }
        }

        private final boolean fromContains$1(Symbols.Symbol sym) {
            int symId = sym.id();
            return symId >= this.fromMin && symId <= this.fromMax && (symId == this.fromMin || symId == this.fromMax || this.fromSize > 2 && this.from.contains(sym));
        }

        private final Types.Type substFor$1(Symbols.Symbol sym, Types.Type tp$4) {
            return this.subst(tp$4, sym, this.from, this.to);
        }

        public SubstMap(SymbolTable $outer, List<Symbols.Symbol> from, List<T> to) {
            this.from = from;
            this.to = to;
            super($outer);
            if ($outer.isDeveloper() && !$outer.sameLength(from, to)) {
                throw $outer.throwAssertionError(SubstMap.$anonfun$new$1(this));
            }
            this.fromHasTermSymbol = false;
            this.fromMin = Integer.MAX_VALUE;
            this.fromMax = Integer.MIN_VALUE;
            this.fromSize = 0;
            if (from == null) {
                throw null;
            }
            List foreach_these = from;
            while (!foreach_these.isEmpty()) {
                Symbols.Symbol symbol = foreach_these.head();
                SubstMap.$anonfun$new$2(this, symbol);
                foreach_these = (List)foreach_these.tail();
            }
        }

        public static final /* synthetic */ Object $anonfun$new$2$adapted(SubstMap $this, Symbols.Symbol sym) {
            SubstMap.$anonfun$new$2($this, sym);
            return BoxedUnit.UNIT;
        }
    }

    public class SubstSymMap
    extends SubstMap<Symbols.Symbol> {
        private volatile TypeMaps$SubstSymMap$mapTreeSymbols$ mapTreeSymbols$module;
        public final List<Symbols.Symbol> scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$from;
        public final List<Symbols.Symbol> scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$to;

        public TypeMaps$SubstSymMap$mapTreeSymbols$ mapTreeSymbols() {
            if (this.mapTreeSymbols$module == null) {
                this.mapTreeSymbols$lzycompute$1();
            }
            return this.mapTreeSymbols$module;
        }

        @Override
        public Types.Type toType(Types.Type fromtp, Symbols.Symbol sym) {
            Types.Type type;
            if (fromtp instanceof Types.TypeRef) {
                Types.TypeRef typeRef = (Types.TypeRef)fromtp;
                Types.Type pre = typeRef.pre();
                List<Types.Type> args2 = typeRef.args();
                type = this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$$outer().copyTypeRef(fromtp, pre, sym, args2);
            } else if (fromtp instanceof Types.SingleType) {
                Types.Type pre = ((Types.SingleType)fromtp).pre();
                type = this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$$outer().singleType(pre, sym);
            } else {
                throw new MatchError(fromtp);
            }
            return type;
        }

        private Symbols.Symbol subst(Symbols.Symbol sym, List<Symbols.Symbol> from, List<Symbols.Symbol> to) {
            while (!from.isEmpty()) {
                if (this.matches(from.head(), sym)) {
                    return to.head();
                }
                to = (List)to.tail();
                from = (List)from.tail();
            }
            return sym;
        }

        private Symbols.Symbol substFor(Symbols.Symbol sym) {
            return this.subst(sym, this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$from, this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$to);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Types.Type apply(Types.Type tp) {
            if (this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$from.isEmpty()) {
                return tp;
            }
            if (tp instanceof Types.TypeRef) {
                Types.TypeRef typeRef = (Types.TypeRef)tp;
                Types.Type pre = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List<Types.Type> args2 = typeRef.args();
                if (pre != this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$$outer().NoPrefix()) {
                    Symbols.Symbol newSym = this.substFor(sym);
                    return this.mapOver(sym == newSym ? tp : this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$$outer().copyTypeRef(tp, pre, newSym, args2));
                }
            }
            if (!(tp instanceof Types.SingleType)) return super.apply(tp);
            Types.SingleType singleType = (Types.SingleType)tp;
            Types.Type pre = singleType.pre();
            Symbols.Symbol sym = singleType.sym();
            if (pre == this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$$outer().NoPrefix()) return super.apply(tp);
            Symbols.Symbol newSym = this.substFor(sym);
            return this.mapOver(sym == newSym ? tp : this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$$outer().singleType(pre, newSym));
        }

        @Override
        public Trees.Tree mapOver(Trees.Tree tree, Function0<Nothing$> giveup) {
            return this.mapTreeSymbols().transform(tree);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$$outer() {
            return this.$outer;
        }

        private final void mapTreeSymbols$lzycompute$1() {
            synchronized (this) {
                if (this.mapTreeSymbols$module == null) {
                    this.mapTreeSymbols$module = new TypeMaps$SubstSymMap$mapTreeSymbols$(this);
                }
                return;
            }
        }

        public SubstSymMap(SymbolTable $outer, List<Symbols.Symbol> from, List<Symbols.Symbol> to) {
            this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$from = from;
            this.scala$reflect$internal$tpe$TypeMaps$SubstSymMap$$to = to;
            super($outer, from, to);
        }

        public SubstSymMap(SymbolTable $outer, Seq<Tuple2<Symbols.Symbol, Symbols.Symbol>> pairs) {
            this($outer, pairs.toList().map(new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final Symbols.Symbol apply(Tuple2<Symbols.Symbol, Symbols.Symbol> x$12) {
                    return x$12._1();
                }
            }, List$.MODULE$.canBuildFrom()), pairs.toList().map(new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final Symbols.Symbol apply(Tuple2<Symbols.Symbol, Symbols.Symbol> x$13) {
                    return x$13._2();
                }
            }, List$.MODULE$.canBuildFrom()));
        }
    }

    public class SubstThisMap
    extends TypeMap {
        private final Symbols.Symbol from;
        private final Types.Type to;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Types.Type apply(Types.Type tp) {
            if (!(tp instanceof Types.ThisType)) return this.mapOver(tp);
            Symbols.Symbol symbol = ((Types.ThisType)tp).sym();
            Symbols.Symbol symbol2 = this.from;
            if (symbol != null) {
                if (!symbol.equals(symbol2)) return this.mapOver(tp);
                return this.to;
            }
            if (symbol2 == null) return this.to;
            return this.mapOver(tp);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$SubstThisMap$$$outer() {
            return this.$outer;
        }

        public SubstThisMap(SymbolTable $outer, Symbols.Symbol from, Types.Type to) {
            this.from = from;
            this.to = to;
            super($outer);
        }
    }

    public class SubstTypeMap
    extends SubstMap<Types.Type> {
        private final List<Symbols.Symbol> from;
        private final List<Types.Type> to;

        public List<Symbols.Symbol> from() {
            return this.from;
        }

        public List<Types.Type> to() {
            return this.to;
        }

        @Override
        public Types.Type toType(Types.Type fromtp, Types.Type tp) {
            return tp;
        }

        @Override
        public Trees.Tree mapOver(Trees.Tree tree, Function0<Nothing$> giveup) {
            TypeMaps$SubstTypeMap$trans$1$ typeMaps$SubstTypeMap$trans$1$;
            LazyRef<TypeMaps$SubstTypeMap$trans$1$> trans$module = new LazyRef<TypeMaps$SubstTypeMap$trans$1$>();
            if (trans$module.initialized()) {
                typeMaps$SubstTypeMap$trans$1$ = (TypeMaps$SubstTypeMap$trans$1$)trans$module.value();
            } else {
                TypeMaps$SubstTypeMap$trans$1$ typeMaps$SubstTypeMap$trans$1$2;
                synchronized (trans$module) {
                    typeMaps$SubstTypeMap$trans$1$2 = trans$module.initialized() ? (TypeMaps$SubstTypeMap$trans$1$)trans$module.value() : trans$module.initialize(new TypeMaps$SubstTypeMap$trans$1$(this, giveup));
                }
                typeMaps$SubstTypeMap$trans$1$ = typeMaps$SubstTypeMap$trans$1$2;
            }
            return typeMaps$SubstTypeMap$trans$1$.transform(tree);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$SubstTypeMap$$$outer() {
            return this.$outer;
        }

        private final /* synthetic */ TypeMaps$SubstTypeMap$trans$1$ trans$lzycompute$1(LazyRef trans$module$1, Function0 giveup$1) {
            synchronized (trans$module$1) {
                TypeMaps$SubstTypeMap$trans$1$ typeMaps$SubstTypeMap$trans$1$ = trans$module$1.initialized() ? (TypeMaps$SubstTypeMap$trans$1$)trans$module$1.value() : trans$module$1.initialize(new TypeMaps$SubstTypeMap$trans$1$(this, giveup$1));
                return typeMaps$SubstTypeMap$trans$1$;
            }
        }

        private final TypeMaps$SubstTypeMap$trans$1$ trans$2(LazyRef trans$module$1, Function0 giveup$1) {
            TypeMaps$SubstTypeMap$trans$1$ typeMaps$SubstTypeMap$trans$1$;
            if (trans$module$1.initialized()) {
                return (TypeMaps$SubstTypeMap$trans$1$)trans$module$1.value();
            }
            synchronized (trans$module$1) {
                typeMaps$SubstTypeMap$trans$1$ = trans$module$1.initialized() ? (TypeMaps$SubstTypeMap$trans$1$)trans$module$1.value() : trans$module$1.initialize(new TypeMaps$SubstTypeMap$trans$1$(this, giveup$1));
            }
            return typeMaps$SubstTypeMap$trans$1$;
        }

        public SubstTypeMap(SymbolTable $outer, List<Symbols.Symbol> from, List<Types.Type> to) {
            this.from = from;
            this.to = to;
            super($outer, from, to);
        }
    }

    public class SubstWildcardMap
    extends TypeMap {
        private final List<Symbols.Symbol> from;

        @Override
        public Types.Type apply(Types.Type tp) {
            try {
                Symbols.Symbol sym;
                Types.Type type = tp instanceof Types.TypeRef && this.from.contains(sym = ((Types.TypeRef)tp).sym()) ? new Types.BoundedWildcardType(this.scala$reflect$internal$tpe$TypeMaps$SubstWildcardMap$$$outer(), sym.info().bounds()) : this.mapOver(tp);
                return type;
            }
            catch (Types.MalformedType malformedType) {
                return this.scala$reflect$internal$tpe$TypeMaps$SubstWildcardMap$$$outer().WildcardType();
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$SubstWildcardMap$$$outer() {
            return this.$outer;
        }

        public SubstWildcardMap(SymbolTable $outer, List<Symbols.Symbol> from) {
            this.from = from;
            super($outer);
        }
    }

    public abstract class TypeCollector<T>
    extends TypeTraverser {
        private final T initial;
        private T result;

        public T result() {
            return this.result;
        }

        public void result_$eq(T x$1) {
            this.result = x$1;
        }

        public T collect(Types.Type tp) {
            T t;
            T saved = this.result();
            try {
                this.result_$eq(this.initial);
                this.traverse(tp);
                t = this.result();
            }
            finally {
                this.result_$eq(saved);
            }
            return t;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$TypeCollector$$$outer() {
            return this.$outer;
        }

        public TypeCollector(SymbolTable $outer, T initial) {
            this.initial = initial;
            super($outer);
        }
    }

    public abstract class TypeMap
    implements Function1<Types.Type, Types.Type> {
        public final boolean scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance;
        private int _variance;
        public final /* synthetic */ SymbolTable $outer;

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
        public <A> Function1<A, Types.Type> compose(Function1<A, Types.Type> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<Types.Type, A> andThen(Function1<Types.Type, A> g) {
            return Function1.andThen$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        @Override
        public abstract Types.Type apply(Types.Type var1);

        /*
         * WARNING - void declaration
         */
        public void variance_$eq(int x) {
            void assert_assertion;
            SymbolTable symbolTable = this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer();
            boolean bl = this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance;
            if (symbolTable == null) {
                throw null;
            }
            SymbolTable assert_this = symbolTable;
            if (assert_assertion == false) {
                throw assert_this.throwAssertionError(this);
            }
            this._variance = x;
        }

        public int variance() {
            return this._variance;
        }

        public Types.Type mapOver(Types.Type tp) {
            Types.Type type;
            if (tp instanceof Types.TypeRef) {
                List<Types.Type> list;
                Types.TypeRef typeRef = (Types.TypeRef)tp;
                Types.Type pre = typeRef.pre();
                Symbols.Symbol sym = typeRef.sym();
                List<Types.Type> args2 = typeRef.args();
                Types.Type pre1 = this.apply(pre);
                if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance && args2.nonEmpty() && !Variance$.MODULE$.isInvariant$extension(this.variance())) {
                    List<Symbols.Symbol> tparams = sym.typeParams();
                    if (tparams.isEmpty()) {
                        $colon$colon<Nothing$> $colon$colon;
                        List<Types.Type> list2 = args2;
                        List<Types.Type> list3 = args2;
                        Object var65_10 = null;
                        $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
                        while (true) {
                            List mapConserve_loop$1_tail0;
                            $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                            List mapConserve_loop$1_unchanged;
                            List mapConserve_loop$1_pending;
                            if (mapConserve_loop$1_pending.isEmpty()) {
                                if (mapConserve_loop$1_mappedHead == null) {
                                    $colon$colon = mapConserve_loop$1_unchanged;
                                    break;
                                }
                                mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                                $colon$colon = mapConserve_loop$1_mappedHead;
                                break;
                            }
                            Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                            Object mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                            if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                                mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                                continue;
                            }
                            $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                            $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                            for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                                $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                                if (mapConserve_loop$1_mappedHead1 == null) {
                                    mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                                }
                                if (mapConserve_loop$1_mappedLast1 != null) {
                                    mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                                }
                                mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                            }
                            $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                            if (mapConserve_loop$1_mappedHead1 == null) {
                                mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                            }
                            if (mapConserve_loop$1_mappedLast1 != null) {
                                mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                            }
                            mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                            mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                            mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                            mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                            mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
                        }
                        list = $colon$colon;
                    } else {
                        list = this.mapOverArgs(args2, tparams);
                    }
                } else {
                    $colon$colon<Nothing$> $colon$colon;
                    if (args2 == null) {
                        throw null;
                    }
                    List<Types.Type> list4 = args2;
                    List<Types.Type> list5 = args2;
                    Object var78_23 = null;
                    $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
                    while (true) {
                        List mapConserve_loop$1_tail0;
                        $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                        List mapConserve_loop$1_unchanged;
                        List mapConserve_loop$1_pending;
                        if (mapConserve_loop$1_pending.isEmpty()) {
                            if (mapConserve_loop$1_mappedHead == null) {
                                $colon$colon = mapConserve_loop$1_unchanged;
                                break;
                            }
                            mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                            $colon$colon = mapConserve_loop$1_mappedHead;
                            break;
                        }
                        Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                        Object mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                        if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                            mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                            continue;
                        }
                        $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                        $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                        for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                            $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                            if (mapConserve_loop$1_mappedHead1 == null) {
                                mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                            }
                            if (mapConserve_loop$1_mappedLast1 != null) {
                                mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                            }
                            mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                        }
                        $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                        if (mapConserve_loop$1_mappedHead1 == null) {
                            mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                        }
                        if (mapConserve_loop$1_mappedLast1 != null) {
                            mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                        }
                        mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                        mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                        mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                        mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                        mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
                    }
                    list = $colon$colon;
                }
                List<Types.Type> args1 = list;
                type = pre1 == pre && args1 == args2 ? tp : this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().copyTypeRef(tp, pre1, typeRef.coevolveSym(pre1), args1);
            } else if (tp instanceof Types.ThisType) {
                type = tp;
            } else if (tp instanceof Types.SingleType) {
                Types.Type pre1;
                Types.SingleType singleType = (Types.SingleType)tp;
                Types.Type pre = singleType.pre();
                Symbols.Symbol sym = singleType.sym();
                type = sym.isPackageClass() ? tp : ((pre1 = this.apply(pre)) == pre ? tp : this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().singleType(pre1, sym));
            } else if (tp instanceof Types.MethodType) {
                List list;
                Types.MethodType methodType = (Types.MethodType)tp;
                List<Symbols.Symbol> params = methodType.params();
                Types.Type result2 = methodType.resultType();
                if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                    this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
                }
                try {
                    list = this.mapOver(params);
                }
                finally {
                    if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                        this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
                    }
                }
                List params1 = list;
                Types.Type result1 = this.apply(result2);
                type = params1 == params && result1 == result2 ? tp : this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().copyMethodType(tp, params1, result1.substSym(params, params1));
            } else if (tp instanceof Types.PolyType) {
                List list;
                Types.PolyType polyType = (Types.PolyType)tp;
                List<Symbols.Symbol> tparams = polyType.typeParams();
                Types.Type result3 = polyType.resultType();
                if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                    this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
                }
                try {
                    list = this.mapOver(tparams);
                }
                finally {
                    if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                        this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
                    }
                }
                List tparams1 = list;
                Types.Type result1 = this.apply(result3);
                type = tparams1 == tparams && result1 == result3 ? tp : new Types.PolyType(this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer(), tparams1, result1.substSym(tparams, tparams1));
            } else if (tp instanceof Types.NullaryMethodType) {
                Types.Type result4 = ((Types.NullaryMethodType)tp).resultType();
                Types.Type result1 = this.apply(result4);
                type = result1 == result4 ? tp : new Types.NullaryMethodType(this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer(), result1);
            } else if (tp instanceof Types.ConstantType) {
                type = tp;
            } else if (tp instanceof Types.SuperType) {
                Types.SuperType superType = (Types.SuperType)tp;
                Types.Type thistp = superType.thistpe();
                Types.Type supertp = superType.supertpe();
                Types.Type thistp1 = this.apply(thistp);
                Types.Type supertp1 = this.apply(supertp);
                type = thistp1 == thistp && supertp1 == supertp ? tp : this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().SuperType().apply(thistp1, supertp1);
            } else if (tp instanceof Types.TypeBounds) {
                Types.Type type2;
                Types.TypeBounds typeBounds = (Types.TypeBounds)tp;
                Types.Type lo = typeBounds.lo();
                Types.Type hi = typeBounds.hi();
                if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                    this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
                }
                try {
                    type2 = this.apply(lo);
                }
                finally {
                    if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                        this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
                    }
                }
                Types.Type lo1 = type2;
                Types.Type hi1 = this.apply(hi);
                type = lo1 == lo && hi1 == hi ? tp : this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().TypeBounds().apply(lo1, hi1);
            } else if (tp instanceof Types.BoundedWildcardType) {
                Types.TypeBounds bounds = ((Types.BoundedWildcardType)tp).bounds();
                Types.Type bounds1 = this.apply(bounds);
                type = bounds1 == bounds ? tp : new Types.BoundedWildcardType(this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer(), (Types.TypeBounds)bounds1);
            } else if (tp instanceof Types.RefinedType) {
                $colon$colon<Nothing$> $colon$colon;
                Types.RefinedType refinedType = (Types.RefinedType)tp;
                List<Types.Type> parents = refinedType.parents();
                Scopes.Scope decls = refinedType.decls();
                if (parents == null) {
                    throw null;
                }
                List<Types.Type> list = parents;
                List<Types.Type> list6 = parents;
                Object var94_72 = null;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
                while (true) {
                    List mapConserve_loop$1_tail0;
                    $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                    List mapConserve_loop$1_unchanged;
                    List mapConserve_loop$1_pending;
                    if (mapConserve_loop$1_pending.isEmpty()) {
                        if (mapConserve_loop$1_mappedHead == null) {
                            $colon$colon = mapConserve_loop$1_unchanged;
                            break;
                        }
                        mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                        $colon$colon = mapConserve_loop$1_mappedHead;
                        break;
                    }
                    Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                    Object mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                    if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                        mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                        continue;
                    }
                    $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                    $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                    for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                        $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                        if (mapConserve_loop$1_mappedHead1 == null) {
                            mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                        }
                        if (mapConserve_loop$1_mappedLast1 != null) {
                            mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                        }
                        mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                    }
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                    mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                    mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                    mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                    mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
                }
                Scopes.Scope decls1 = this.mapOver(decls);
                type = this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().copyRefinedType(refinedType, $colon$colon, decls1);
            } else if (tp instanceof Types.ExistentialType) {
                Types.ExistentialType existentialType = (Types.ExistentialType)tp;
                List<Symbols.Symbol> tparams = existentialType.quantified();
                Types.Type result5 = existentialType.underlying();
                List<Symbols.Symbol> tparams1 = this.mapOver(tparams);
                Types.Type result1 = this.apply(result5);
                type = tparams1 == tparams && result1 == result5 ? tp : this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().newExistentialType(tparams1, result1.substSym(tparams, tparams1));
            } else if (tp instanceof Types.OverloadedType) {
                Types.OverloadedType overloadedType = (Types.OverloadedType)tp;
                Types.Type pre = overloadedType.pre();
                List<Symbols.Symbol> alts = overloadedType.alternatives();
                Types.Type pre1 = pre instanceof Types.ClassInfoType ? pre : this.apply(pre);
                type = pre1 == pre ? tp : new Types.OverloadedType(this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer(), pre1, alts);
            } else if (tp instanceof Types.AntiPolyType) {
                $colon$colon<Nothing$> $colon$colon;
                Types.AntiPolyType antiPolyType = (Types.AntiPolyType)tp;
                Types.Type pre = antiPolyType.pre();
                List<Types.Type> args3 = antiPolyType.targs();
                Types.Type pre1 = this.apply(pre);
                if (args3 == null) {
                    throw null;
                }
                List<Types.Type> list = args3;
                List<Types.Type> list7 = args3;
                Object var107_99 = null;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
                while (true) {
                    List mapConserve_loop$1_tail0;
                    $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                    List mapConserve_loop$1_unchanged;
                    List mapConserve_loop$1_pending;
                    if (mapConserve_loop$1_pending.isEmpty()) {
                        if (mapConserve_loop$1_mappedHead == null) {
                            $colon$colon = mapConserve_loop$1_unchanged;
                            break;
                        }
                        mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                        $colon$colon = mapConserve_loop$1_mappedHead;
                        break;
                    }
                    Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                    Object mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                    if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                        mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                        continue;
                    }
                    $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                    $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                    for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                        $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                        if (mapConserve_loop$1_mappedHead1 == null) {
                            mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                        }
                        if (mapConserve_loop$1_mappedLast1 != null) {
                            mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                        }
                        mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                    }
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                    mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                    mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                    mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                    mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
                }
                type = pre1 == pre && $colon$colon == args3 ? tp : new Types.AntiPolyType(this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer(), pre1, $colon$colon);
            } else if (tp instanceof Types.TypeVar) {
                List<Types.Type> args4;
                List<Types.Type> args1;
                Types.TypeVar typeVar = (Types.TypeVar)tp;
                TypeConstraints.TypeConstraint constr = typeVar.constr();
                type = constr.instValid() ? this.apply(constr.inst()) : ((args1 = this.mapOverArgs(args4 = typeVar.typeArgs(), typeVar.params())) == args4 ? typeVar : typeVar.applyArgs(args1));
            } else if (tp instanceof Types.AnnotatedType) {
                Types.AnnotatedType annotatedType = (Types.AnnotatedType)tp;
                List<AnnotationInfos.AnnotationInfo> annots = annotatedType.annotations();
                Types.Type atp = annotatedType.underlying();
                List<AnnotationInfos.AnnotationInfo> annots1 = this.mapOverAnnotations(annots);
                Types.Type atp1 = this.apply(atp);
                type = annots1 == annots && atp1 == atp ? tp : (annots1.isEmpty() ? atp1 : new Types.AnnotatedType(this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer(), annots1, atp1));
            } else {
                type = tp;
            }
            return type;
        }

        public final <T> T withVariance(int v, Function0<T> body) {
            T t;
            int saved = this.variance();
            this.variance_$eq(v);
            try {
                t = body.apply();
            }
            finally {
                this.variance_$eq(saved);
            }
            return t;
        }

        public final <T> T flipped(Function0<T> body) {
            T t;
            if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
            }
            try {
                t = body.apply();
            }
            finally {
                if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                    this.variance_$eq(Variance$.MODULE$.flip$extension(this.variance()));
                }
            }
            return t;
        }

        public final List<Types.Type> mapOverArgs(List<Types.Type> args2, List<Symbols.Symbol> tparams) {
            $colon$colon<Nothing$> $colon$colon;
            if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance) {
                if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer() == null) {
                    throw null;
                }
                List<Symbols.Symbol> list = tparams;
                List<Types.Type> list2 = args2;
                List<Types.Type> list3 = args2;
                ListBuffer map2Conserve_loop$2_mapped = null;
                while (true) {
                    List map2Conserve_loop$2_tail1;
                    Object map2Conserve_loop$2_head01;
                    Symbols.Symbol symbol;
                    List map2Conserve_loop$2_unchanged;
                    List map2Conserve_loop$2_pending1;
                    List map2Conserve_loop$2_pending0;
                    if (map2Conserve_loop$2_pending0.isEmpty() || map2Conserve_loop$2_pending1.isEmpty()) {
                        if (map2Conserve_loop$2_mapped == null) {
                            return map2Conserve_loop$2_unchanged;
                        }
                        return map2Conserve_loop$2_mapped.prependToList(map2Conserve_loop$2_unchanged);
                    }
                    Object map2Conserve_loop$2_head00 = map2Conserve_loop$2_pending0.head();
                    Types.Type type = (Types.Type)map2Conserve_loop$2_head00;
                    Types.Type map2Conserve_loop$2_head1 = TypeMap.$anonfun$mapOverArgs$1(this, type, symbol = (Symbols.Symbol)(map2Conserve_loop$2_head01 = map2Conserve_loop$2_pending1.head()));
                    if (map2Conserve_loop$2_head1 == map2Conserve_loop$2_head00) {
                        map2Conserve_loop$2_pending1 = (List)map2Conserve_loop$2_pending1.tail();
                        map2Conserve_loop$2_pending0 = (List)map2Conserve_loop$2_pending0.tail();
                        continue;
                    }
                    ListBuffer map2Conserve_loop$2_b = map2Conserve_loop$2_mapped == null ? new ListBuffer() : map2Conserve_loop$2_mapped;
                    for (List map2Conserve_loop$2_xc = map2Conserve_loop$2_unchanged; map2Conserve_loop$2_xc != map2Conserve_loop$2_pending0 && map2Conserve_loop$2_xc != map2Conserve_loop$2_pending1; map2Conserve_loop$2_xc = (List)map2Conserve_loop$2_xc.tail()) {
                        map2Conserve_loop$2_b.$plus$eq(map2Conserve_loop$2_xc.head());
                    }
                    map2Conserve_loop$2_b.$plus$eq(map2Conserve_loop$2_head1);
                    List map2Conserve_loop$2_tail0 = (List)map2Conserve_loop$2_pending0.tail();
                    map2Conserve_loop$2_pending1 = map2Conserve_loop$2_tail1 = (List)map2Conserve_loop$2_pending1.tail();
                    map2Conserve_loop$2_pending0 = map2Conserve_loop$2_tail0;
                    map2Conserve_loop$2_unchanged = map2Conserve_loop$2_tail0;
                    map2Conserve_loop$2_mapped = map2Conserve_loop$2_b;
                }
            }
            if (args2 == null) {
                throw null;
            }
            List<Types.Type> list = args2;
            List<Types.Type> list4 = args2;
            Object var4_18 = null;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
            while (true) {
                List mapConserve_loop$1_tail0;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast;
                List mapConserve_loop$1_unchanged;
                List mapConserve_loop$1_pending;
                if (mapConserve_loop$1_pending.isEmpty()) {
                    if (mapConserve_loop$1_mappedHead == null) {
                        $colon$colon = mapConserve_loop$1_unchanged;
                        break;
                    }
                    mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                    $colon$colon = mapConserve_loop$1_mappedHead;
                    break;
                }
                Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                Object mapConserve_loop$1_head1 = this.apply(mapConserve_loop$1_head0);
                if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                    mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                    continue;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_head1, Nil$.MODULE$);
                if (mapConserve_loop$1_mappedHead1 == null) {
                    mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                }
                if (mapConserve_loop$1_mappedLast1 != null) {
                    mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                }
                mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
            }
            return $colon$colon;
        }

        private Types.Type applyToSymbolInfo(Symbols.Symbol sym, Types.Type info) {
            if (this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance && !Variance$.MODULE$.isInvariant$extension(this.variance()) && sym.isAliasType()) {
                Types.Type type;
                int withVariance_v = Variance$.MODULE$.Invariant();
                int withVariance_saved = this.variance();
                this.variance_$eq(withVariance_v);
                try {
                    type = this.apply(info);
                }
                finally {
                    this.variance_$eq(withVariance_saved);
                }
                return type;
            }
            return this.apply(info);
        }

        private int firstChangedSymbol(List<Symbols.Symbol> origSyms) {
            return this.loop$1(0, origSyms);
        }

        public Scopes.Scope mapOver(Scopes.Scope scope) {
            List<Symbols.Symbol> elems = scope.toList();
            List<Symbols.Symbol> elems1 = this.mapOver(elems);
            if (elems1 == elems) {
                return scope;
            }
            return this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().newScopeWith(elems1);
        }

        /*
         * WARNING - void declaration
         */
        public List<Symbols.Symbol> mapOver(List<Symbols.Symbol> origSyms) {
            void var3_3;
            int firstChange = this.firstChangedSymbol(origSyms);
            if (firstChange < 0) {
                return origSyms;
            }
            List<Symbols.Symbol> cloned = this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().cloneSymbols(origSyms);
            Object object = cloned.drop(firstChange);
            if (object == null) {
                throw null;
            }
            Object foreach_these = object;
            while (!((List)foreach_these).isEmpty()) {
                Symbols.Symbol symbol = (Symbols.Symbol)((List)foreach_these).head();
                symbol.modifyInfo(this);
                foreach_these = (List)((AbstractTraversable)foreach_these).tail();
            }
            return var3_3;
        }

        /*
         * WARNING - void declaration
         */
        public AnnotationInfos.AnnotationInfo mapOver(AnnotationInfos.AnnotationInfo annot) {
            void var5_5;
            void var4_4;
            void var3_3;
            Option<Tuple3<Types.Type, List<Trees.Tree>, List<Tuple2<Names.Name, AnnotationInfos.ClassfileAnnotArg>>>> option = this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().AnnotationInfo().unapply(annot);
            if (option.isEmpty()) {
                throw new MatchError(annot);
            }
            Types.Type atp = option.get()._1();
            List<Trees.Tree> args2 = option.get()._2();
            List<Tuple2<Names.Name, AnnotationInfos.ClassfileAnnotArg>> assocs = option.get()._3();
            void atp2 = var3_3;
            void args3 = var4_4;
            void assocs2 = var5_5;
            Types.Type atp1 = this.mapOver((Types.Type)atp2);
            List<Trees.Tree> args1 = this.mapOverAnnotArgs((List<Trees.Tree>)args3);
            if (args3 == args1 && atp2 == atp1) {
                return annot;
            }
            if (args1.isEmpty() && args3.nonEmpty()) {
                return this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().UnmappableAnnotation();
            }
            return this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().AnnotationInfo().apply(atp1, args1, (List<Tuple2<Names.Name, AnnotationInfos.ClassfileAnnotArg>>)assocs2).setPos(annot.pos());
        }

        public List<AnnotationInfos.AnnotationInfo> mapOverAnnotations(List<AnnotationInfos.AnnotationInfo> annots) {
            $colon$colon<Nothing$> $colon$colon;
            if (annots == null) {
                throw null;
            }
            List<AnnotationInfos.AnnotationInfo> list = annots;
            List<AnnotationInfos.AnnotationInfo> list2 = annots;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedLast = null;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
            while (true) {
                List mapConserve_loop$1_tail0;
                List mapConserve_loop$1_unchanged;
                List mapConserve_loop$1_pending;
                if (mapConserve_loop$1_pending.isEmpty()) {
                    if (mapConserve_loop$1_mappedHead == null) {
                        $colon$colon = mapConserve_loop$1_unchanged;
                        break;
                    }
                    mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                    $colon$colon = mapConserve_loop$1_mappedHead;
                    break;
                }
                Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                AnnotationInfos.AnnotationInfo annotationInfo = (AnnotationInfos.AnnotationInfo)mapConserve_loop$1_head0;
                AnnotationInfos.AnnotationInfo mapConserve_loop$1_head1 = this.mapOver(annotationInfo);
                if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                    mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                    continue;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)((Object)mapConserve_loop$1_head1), Nil$.MODULE$);
                if (mapConserve_loop$1_mappedHead1 == null) {
                    mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                }
                if (mapConserve_loop$1_mappedLast1 != null) {
                    mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                }
                mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
            }
            if ($colon$colon == annots) {
                return annots;
            }
            return (List)$colon$colon.filterNot((Function1<AnnotationInfos.AnnotationInfo, Object> & java.io.Serializable & Serializable)x$4 -> BoxesRunTime.boxToBoolean(TypeMap.$anonfun$mapOverAnnotations$2(this, x$4)));
        }

        public List<Trees.Tree> mapOverAnnotArgs(List<Trees.Tree> args2) {
            $colon$colon<Nothing$> $colon$colon;
            if (args2 == null) {
                throw null;
            }
            List<Trees.Tree> list = args2;
            List<Trees.Tree> list2 = args2;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedLast = null;
            $colon$colon<Nothing$> mapConserve_loop$1_mappedHead = null;
            while (true) {
                List mapConserve_loop$1_tail0;
                List mapConserve_loop$1_unchanged;
                List mapConserve_loop$1_pending;
                if (mapConserve_loop$1_pending.isEmpty()) {
                    if (mapConserve_loop$1_mappedHead == null) {
                        $colon$colon = mapConserve_loop$1_unchanged;
                        break;
                    }
                    mapConserve_loop$1_mappedLast.tl_$eq(mapConserve_loop$1_unchanged);
                    $colon$colon = mapConserve_loop$1_mappedHead;
                    break;
                }
                Object mapConserve_loop$1_head0 = mapConserve_loop$1_pending.head();
                Trees.Tree tree = (Trees.Tree)mapConserve_loop$1_head0;
                Trees.Tree mapConserve_loop$1_head1 = this.mapOver(tree);
                if (mapConserve_loop$1_head1 == mapConserve_loop$1_head0) {
                    mapConserve_loop$1_pending = (List)mapConserve_loop$1_pending.tail();
                    continue;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_mappedHead;
                $colon$colon<Nothing$> mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_mappedLast;
                for (List mapConserve_loop$1_xc = mapConserve_loop$1_unchanged; mapConserve_loop$1_xc != mapConserve_loop$1_pending; mapConserve_loop$1_xc = (List)mapConserve_loop$1_xc.tail()) {
                    $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)mapConserve_loop$1_xc.head(), Nil$.MODULE$);
                    if (mapConserve_loop$1_mappedHead1 == null) {
                        mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                    }
                    if (mapConserve_loop$1_mappedLast1 != null) {
                        mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                    }
                    mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                }
                $colon$colon<Nothing$> mapConserve_loop$1_next = new $colon$colon<Nothing$>((Nothing$)((Object)mapConserve_loop$1_head1), Nil$.MODULE$);
                if (mapConserve_loop$1_mappedHead1 == null) {
                    mapConserve_loop$1_mappedHead1 = mapConserve_loop$1_next;
                }
                if (mapConserve_loop$1_mappedLast1 != null) {
                    mapConserve_loop$1_mappedLast1.tl_$eq(mapConserve_loop$1_next);
                }
                mapConserve_loop$1_mappedLast1 = mapConserve_loop$1_next;
                mapConserve_loop$1_pending = mapConserve_loop$1_tail0 = (List)mapConserve_loop$1_pending.tail();
                mapConserve_loop$1_unchanged = mapConserve_loop$1_tail0;
                mapConserve_loop$1_mappedLast = mapConserve_loop$1_mappedLast1;
                mapConserve_loop$1_mappedHead = mapConserve_loop$1_mappedHead1;
            }
            if ($colon$colon.contains(this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().UnmappableTree())) {
                return Nil$.MODULE$;
            }
            return $colon$colon;
        }

        public Trees.Tree mapOver(Trees.Tree tree) {
            Object object = new Object();
            try {
                return this.mapOver(tree, (Function0<Nothing$> & java.io.Serializable & Serializable)() -> {
                    throw new NonLocalReturnControl<Types$UnmappableTree$>(object, this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().UnmappableTree());
                });
            }
            catch (NonLocalReturnControl ex) {
                if (ex.key() == object) {
                    return (Trees.Tree)ex.value();
                }
                throw ex;
            }
        }

        public Trees.Tree mapOver(Trees.Tree tree, Function0<Nothing$> giveup) {
            return new TypeMapTransformer().transform(tree);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ Types.Type $anonfun$mapOverArgs$1(TypeMap $this, Types.Type arg, Symbols.Symbol tparam) {
            Types.Type type;
            int withVariance_v = Variance$.MODULE$.$times$extension($this.variance(), tparam.variance());
            int withVariance_saved = $this.variance();
            $this.variance_$eq(withVariance_v);
            try {
                type = $this.apply(arg);
            }
            finally {
                $this.variance_$eq(withVariance_saved);
            }
            return type;
        }

        private final int loop$1(int i, List syms) {
            int n;
            block2: {
                while (syms instanceof $colon$colon) {
                    $colon$colon $colon$colon = ($colon$colon)syms;
                    Symbols.Symbol x = (Symbols.Symbol)$colon$colon.head();
                    List xs = $colon$colon.tl$access$1();
                    Types.Type info = x.info();
                    if (this.applyToSymbolInfo(x, info) == info) {
                        syms = xs;
                        ++i;
                        continue;
                    }
                    n = i;
                    break block2;
                }
                n = -1;
            }
            return n;
        }

        public static final /* synthetic */ boolean $anonfun$mapOverAnnotations$2(TypeMap $this, AnnotationInfos.AnnotationInfo x$4) {
            return x$4 == $this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer().UnmappableAnnotation();
        }

        public TypeMap(SymbolTable $outer, boolean trackVariance) {
            this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$trackVariance = trackVariance;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this._variance = trackVariance ? Variance$.MODULE$.Covariant() : Variance$.MODULE$.Invariant();
        }

        public TypeMap(SymbolTable $outer) {
            this($outer, false);
        }

        public class TypeMapTransformer
        extends Trees.Transformer {
            public Trees.Tree transform(Trees.Tree tree) {
                Trees.Tree tree1 = (Trees.Tree)super.transform(tree);
                Types.Type tpe1 = this.scala$reflect$internal$tpe$TypeMaps$TypeMap$TypeMapTransformer$$$outer().apply(tree1.tpe());
                if (tree == tree1 && tree.tpe() == tpe1) {
                    return tree;
                }
                return tree1.shallowDuplicate().setType(tpe1);
            }

            public /* synthetic */ TypeMap scala$reflect$internal$tpe$TypeMaps$TypeMap$TypeMapTransformer$$$outer() {
                return TypeMap.this;
            }

            public TypeMapTransformer() {
                if (TypeMap.this == null) {
                    throw null;
                }
                super(TypeMap.this.scala$reflect$internal$tpe$TypeMaps$TypeMap$$$outer());
            }
        }
    }

    public abstract class TypeTraverser
    extends TypeMap {
        public abstract void traverse(Types.Type var1);

        @Override
        public Types.Type apply(Types.Type tp) {
            this.traverse(tp);
            return tp;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$TypeTraverser$$$outer() {
            return this.$outer;
        }

        public TypeTraverser(SymbolTable $outer) {
            super($outer);
        }
    }

    public abstract class TypeTraverserWithResult<T>
    extends TypeTraverser {
        public abstract T result();

        public abstract void clear();

        public /* synthetic */ SymbolTable scala$reflect$internal$tpe$TypeMaps$TypeTraverserWithResult$$$outer() {
            return this.$outer;
        }

        public TypeTraverserWithResult(SymbolTable $outer) {
            super($outer);
        }
    }
}

